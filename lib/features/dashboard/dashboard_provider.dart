import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';

// 0. REAL-TIME YANGILANISH TRIGGERI
// Ushbu provider ma'lumotlar bazasidagi o'zgarishlarni eshitib turadi
final dashboardRealtimeProvider = StreamProvider.autoDispose<void>((ref) {
  final supabase = Supabase.instance.client;
  // Transactions va Salaries jadvallaridagi barcha o'zgarishlarga obuna bo'lamiz
  final channel = supabase.channel('dashboard-updates');

  channel
      .onPostgresChanges(
        event: PostgresChangeEvent.all,
        schema: 'public',
        table: 'transactions',
        callback: (_) =>
            ref.invalidateSelf(), // O'zini yangilaydi (+ unga bog'liqlar)
      )
      .onPostgresChanges(
        event: PostgresChangeEvent.all,
        schema: 'public',
        table: 'salaries',
        callback: (_) => ref.invalidateSelf(),
      )
      .subscribe();

  ref.onDispose(() => supabase.removeChannel(channel));
  return const Stream.empty();
});

// 1. FILTRLAR
final selectedPeriodProvider = StateProvider<String>((ref) => 'Oy');
final selectedRecentPeriodProvider = StateProvider<String>((ref) => 'Oy');
final selectedCategoryPeriodProvider = StateProvider<String>((ref) => 'Oy');

// Xodim filteri: faqat adminlar uchun. Oddiy user uchun hamisha null (o'zi).
final selectedEmployeeFilterProvider = StateProvider<String?>((ref) {
  return null; // Dastlab null
});

// 2. FOYDALANUVCHI PROFILI (AppBar uchun)
final userProfileProvider =
    FutureProvider.autoDispose<Map<String, dynamic>>((ref) async {
  ref.watch(dashboardRealtimeProvider); // Realtime triggerga ulanish
  final user = Supabase.instance.client.auth.currentUser;
  if (user == null) return {};
  try {
    final res = await Supabase.instance.client
        .from('profiles')
        .select()
        .eq('id', user.id)
        .single();
    return res;
  } catch (e) {
    // Agar 'permissions' ustuni hali yo'q bo'lsa, xatosiz qaytarish
    final res = await Supabase.instance.client
        .from('profiles')
        .select('id, full_name, email') // permissions'siz select
        .eq('id', user.id)
        .single();
    return {...res, 'permissions': {}};
  }
});

// 3. XODIMLAR RO'YXATI (Faqat adminlar uchun)
final employeesProvider =
    FutureProvider.autoDispose<List<Map<String, dynamic>>>((ref) async {
  final user = Supabase.instance.client.auth.currentUser;
  final isAdmin = user?.appMetadata['is_admin'] == true;
  if (!isAdmin) return [];

  final res = await Supabase.instance.client
      .from('profiles')
      .select('id, full_name')
      .order('full_name');
  return List<Map<String, dynamic>>.from(res);
});

// 4. STATISTIKA
final statsProvider =
    FutureProvider.autoDispose<Map<String, double>>((ref) async {
  ref.watch(dashboardRealtimeProvider);
  final supabase = Supabase.instance.client;
  final user = supabase.auth.currentUser;
  if (user == null) return {};

  final isAdmin = user.appMetadata['is_admin'] == true;
  final period = ref.watch(selectedPeriodProvider);
  final requestedEmpId = ref.watch(selectedEmployeeFilterProvider);

  // Huquqlarni olish
  final profile = ref.watch(userProfileProvider).value;
  final permissions = Map<String, dynamic>.from(profile?['permissions'] ?? {});
  final canSeeExpenses = permissions['see_employee_expenses'] ?? false;

  double totalIncome = 0;
  double totalExpense = 0;
  double periodIncome = 0;
  double periodExpense = 0;
  double pendingSum = 0;

  // Davr chegaralarini aniqlash
  final now = DateTime.now();
  DateTime start;
  if (period == 'Kun') {
    start = DateTime(now.year, now.month, now.day);
  } else if (period == 'Hafta') {
    start = now.subtract(Duration(days: now.weekday - 1));
    start = DateTime(start.year, start.month, start.day);
  } else if (period == 'Yil') {
    start = DateTime(now.year, 1, 1);
  } else {
    start = DateTime(now.year, now.month, 1);
  }

  // 1. Chiqimlarni va Kirimlarni (Transactions) olish
  bool fetchTransactions = false;
  String? targetUserId;

  if (!isAdmin) {
    fetchTransactions = true;
    targetUserId = user.id;
  } else {
    if (requestedEmpId == null || requestedEmpId == user.id) {
      fetchTransactions = true;
      targetUserId = user.id;
    } else if (canSeeExpenses) {
      fetchTransactions = true;
      targetUserId = requestedEmpId;
    }
  }

  if (fetchTransactions && targetUserId != null) {
    final txRes = await supabase
        .from('transactions')
        .select()
        .eq('user_id', targetUserId);
    for (var tx in txRes) {
      double amt = (tx['amount'] as num?)?.toDouble() ?? 0.0;
      bool isInc = tx['type'] == 'income';

      if (isInc) {
        totalIncome += amt;
      } else {
        totalExpense += amt;
      }

      DateTime dt = DateTime.parse(tx['created_at']);
      if (dt.isAfter(start) || dt.isAtSameMomentAs(start)) {
        if (isInc) {
          periodIncome += amt;
        } else {
          periodExpense += amt;
        }
      }
    }
  }

  // 2. Kirimlarni (Salaries) olish
  var salQuery = supabase.from('salaries').select();
  if (isAdmin) {
    if (requestedEmpId != null) {
      salQuery = salQuery.eq('user_id', requestedEmpId);
    }
  } else {
    salQuery = salQuery.eq('user_id', user.id);
  }

  final salaryRes = await salQuery;
  for (var s in salaryRes) {
    double amt = (s['amount_uzs'] as num?)?.toDouble() ?? 0.0;
    if (s['status'] == 'confirmed') {
      totalIncome += amt;
      DateTime dt = DateTime.parse(s['created_at']);
      if (dt.isAfter(start) || dt.isAtSameMomentAs(start)) {
        periodIncome += amt;
      }
    } else if (s['status'] == 'pending') {
      pendingSum += amt;
    }
  }

  return {
    'total_balance': totalIncome - totalExpense,
    'period_income': periodIncome,
    'period_expense': periodExpense,
    'pending_sum': pendingSum,
  };
});

// 5. BAR CHART DATA PROVIDER
class DashboardChartData {
  final double income;
  final double expense;
  final String label;
  DashboardChartData(this.income, this.expense, this.label);
}

final barChartDataProvider =
    FutureProvider.autoDispose<List<DashboardChartData>>((ref) async {
  ref.watch(dashboardRealtimeProvider);
  final supabase = Supabase.instance.client;
  final user = supabase.auth.currentUser;
  if (user == null) return [];

  final isAdmin = user.appMetadata['is_admin'] == true;
  final period = ref.watch(selectedPeriodProvider);
  final requestedEmpId = ref.watch(selectedEmployeeFilterProvider);

  // Huquqlarni olish
  final profile = ref.watch(userProfileProvider).value;
  final permissions = Map<String, dynamic>.from(profile?['permissions'] ?? {});
  final canSeeExpenses = permissions['see_employee_expenses'] ?? false;

  DateTime now = DateTime.now();
  DateTime start;

  if (period == 'Yil') {
    start = DateTime(now.year, 1, 1);
  } else if (period == 'Oy') {
    start = DateTime(now.year, now.month, 1);
  } else if (period == 'Hafta') {
    start = now.subtract(Duration(days: now.weekday - 1));
    start = DateTime(start.year, start.month, start.day);
  } else {
    start = DateTime(now.year, now.month, now.day);
  }

  // 1. Transactions (Adminniki yoki Hodimniki)
  List<dynamic> txRes = [];
  bool fetchTransactions = false;
  String? targetUserId;

  if (!isAdmin) {
    fetchTransactions = true;
    targetUserId = user.id;
  } else {
    if (requestedEmpId == null || requestedEmpId == user.id) {
      fetchTransactions = true;
      targetUserId = user.id;
    } else if (canSeeExpenses) {
      fetchTransactions = true;
      targetUserId = requestedEmpId;
    }
  }

  if (fetchTransactions && targetUserId != null) {
    txRes = await supabase
        .from('transactions')
        .select()
        .eq('user_id', targetUserId)
        .gte('created_at', start.toIso8601String());
  }

  // 2. Salaries (Admin uchun hamma/tanlangan, hodim uchun o'zi)
  var salQuery = supabase
      .from('salaries')
      .select()
      .eq('status', 'confirmed')
      .gte('created_at', start.toIso8601String());
  if (isAdmin) {
    if (requestedEmpId != null) {
      salQuery = salQuery.eq('user_id', requestedEmpId);
    }
  } else {
    salQuery = salQuery.eq('user_id', user.id);
  }
  final salaryRes = await salQuery;

  List<DashboardChartData> data = [];
  if (period == 'Yil') {
    final labels = [
      'Yan',
      'Feb',
      'Mar',
      'Apr',
      'May',
      'Iyun',
      'Iyul',
      'Avg',
      'Sen',
      'Okt',
      'Noy',
      'Dek'
    ];
    for (int i = 0; i < 12; i++) {
      double inc = 0;
      double exp = 0;
      for (var s in salaryRes) {
        if (DateTime.parse(s['created_at']).month == i + 1)
          inc += (s['amount_uzs'] as num?)?.toDouble() ?? 0;
      }
      for (var tx in txRes) {
        if (DateTime.parse(tx['created_at']).month == i + 1) {
          double amt = (tx['amount'] as num?)?.toDouble() ?? 0;
          if (tx['type'] == 'income')
            inc += amt;
          else
            exp += amt;
        }
      }
      data.add(DashboardChartData(inc, exp, labels[i]));
    }
  } else if (period == 'Oy') {
    for (int i = 1; i <= 5; i++) {
      double inc = 0;
      double exp = 0;
      for (var s in salaryRes) {
        int week = ((DateTime.parse(s['created_at']).day - 1) / 7).floor() + 1;
        if (week == i) inc += (s['amount_uzs'] as num?)?.toDouble() ?? 0;
      }
      for (var tx in txRes) {
        int week = ((DateTime.parse(tx['created_at']).day - 1) / 7).floor() + 1;
        if (week == i) {
          double amt = (tx['amount'] as num?)?.toDouble() ?? 0;
          if (tx['type'] == 'income')
            inc += amt;
          else
            exp += amt;
        }
      }
      data.add(DashboardChartData(inc, exp, '$i-hafta'));
    }
  } else if (period == 'Hafta') {
    final labels = ['Du', 'Se', 'Shor', 'Pay', 'Ju', 'Sha', 'Yak'];
    for (int i = 0; i < 7; i++) {
      double inc = 0;
      double exp = 0;
      DateTime d = start.add(Duration(days: i));
      for (var s in salaryRes) {
        DateTime sd = DateTime.parse(s['created_at']);
        if (sd.day == d.day && sd.month == d.month)
          inc += (s['amount_uzs'] as num?)?.toDouble() ?? 0;
      }
      for (var tx in txRes) {
        DateTime td = DateTime.parse(tx['created_at']);
        if (td.day == d.day && td.month == d.month) {
          double amt = (tx['amount'] as num?)?.toDouble() ?? 0;
          if (tx['type'] == 'income')
            inc += amt;
          else
            exp += amt;
        }
      }
      data.add(DashboardChartData(inc, exp, labels[i]));
    }
  } else {
    double inc = 0;
    double exp = 0;
    for (var s in salaryRes) inc += (s['amount_uzs'] as num?)?.toDouble() ?? 0;
    for (var tx in txRes) {
      double amt = (tx['amount'] as num?)?.toDouble() ?? 0;
      if (tx['type'] == 'income')
        inc += amt;
      else
        exp += amt;
    }
    data.add(DashboardChartData(inc, exp, 'Bugun'));
  }

  return data;
});

// 6. PENDING NOTIFIKATSIYALAR
//
//  MANTIQ:
//   Xodim o'zi yozadi  → created_by == user_id  → ADMIN tasdiqlaydi
//   Admin xodimga yozadi → user_id == xodim, created_by == admin → XODIM tasdiqlaydi
// ─────────────────────────────────────────────────────────────────────────────
final pendingSalariesProvider =
    FutureProvider.autoDispose<List<Map<String, dynamic>>>((ref) async {
  ref.watch(dashboardRealtimeProvider); // Realtime triggerga ulanish
  final supabase = Supabase.instance.client;
  final user = supabase.auth.currentUser;
  if (user == null) return [];

  final isAdmin = user.appMetadata['is_admin'] == true;

  if (isAdmin) {
    // ADMIN ko'radi: xodim o'zi yozgan (created_by == user_id) → admin tasdiqlaydi
    // Supabase da ikki ustunni solishtirish uchun Dart tomonida filter ishlatamiz
    final all = List<Map<String, dynamic>>.from(
      await supabase
          .from('salaries')
          .select(
              'id, user_id, created_by, amount_uzs, amount_usd, exchange_rate, comment, status, created_at, employee:profiles!salaries_user_id_fkey(full_name)')
          .eq('status', 'pending')
          .order('created_at', ascending: false),
    );
    // Dart filter: faqat xodim o'zi yozgan (ikkala ustun teng)
    return all.where((s) => s['created_by'] == s['user_id']).toList();
  } else {
    // XODIM ko'radi: o'ziga tegishli, lekin ADMIN yozgan → xodim tasdiqlaydi
    final res = await supabase
        .from('salaries')
        .select(
            'id, user_id, created_by, amount_uzs, amount_usd, exchange_rate, comment, status, created_at, creator:profiles!salaries_created_by_fkey(full_name)')
        .eq('status', 'pending')
        .eq('user_id', user.id)
        .neq('created_by', user.id)
        .order('created_at', ascending: false);
    return List<Map<String, dynamic>>.from(res);
  }
});

// 7. YILLIK HISOBOT
final annualReportProvider =
    FutureProvider.autoDispose<List<Map<String, dynamic>>>((ref) async {
  final supabase = Supabase.instance.client;
  final user = supabase.auth.currentUser;
  if (user == null) return [];

  final isAdmin = user.appMetadata['is_admin'] == true;
  final requestedEmpId = ref.watch(selectedEmployeeFilterProvider);

  // Huquqlarni olish
  final profile = ref.watch(userProfileProvider).value;
  final permissions = Map<String, dynamic>.from(profile?['permissions'] ?? {});
  final canSeeExpenses = permissions['see_employee_expenses'] ?? false;

  // 1. Transactions (Adminniki yoki Hodimniki)
  List<dynamic> txRes = [];
  bool fetchTransactions = false;
  String? targetUserId;

  if (!isAdmin) {
    fetchTransactions = true;
    targetUserId = user.id;
  } else {
    if (requestedEmpId == null || requestedEmpId == user.id) {
      fetchTransactions = true;
      targetUserId = user.id;
    } else if (canSeeExpenses) {
      fetchTransactions = true;
      targetUserId = requestedEmpId;
    }
  }

  if (fetchTransactions && targetUserId != null) {
    txRes = await supabase
        .from('transactions')
        .select()
        .eq('user_id', targetUserId)
        .gte('created_at', '${DateTime.now().year}-01-01');
  }

  // 2. Salaries (Admin uchun hamma/tanlangan, hodim uchun o'zi)
  var salQuery = supabase
      .from('salaries')
      .select()
      .eq('status', 'confirmed')
      .gte('created_at', '${DateTime.now().year}-01-01');
  if (isAdmin) {
    if (requestedEmpId != null) {
      salQuery = salQuery.eq('user_id', requestedEmpId);
    }
  } else {
    salQuery = salQuery.eq('user_id', user.id);
  }
  final salaryRes = await salQuery;

  List<Map<String, dynamic>> data =
      List.generate(12, (i) => {'month': i, 'income': 0.0, 'expense': 0.0});

  for (var tx in txRes) {
    int m = DateTime.parse(tx['created_at']).month - 1;
    double amt = (tx['amount'] as num?)?.toDouble() ?? 0;
    if (tx['type'] == 'income') {
      data[m]['income'] = (data[m]['income'] as double) + amt;
    } else {
      data[m]['expense'] = (data[m]['expense'] as double) + amt;
    }
  }

  for (var s in salaryRes) {
    int m = DateTime.parse(s['created_at']).month - 1;
    double amt = (s['amount_uzs'] as num?)?.toDouble() ?? 0;
    data[m]['income'] = (data[m]['income'] as double) + amt;
  }

  return data;
});

// 8. OXIRGI AMALLAR
final recentTransactionsProvider =
    FutureProvider.autoDispose<List<Map<String, dynamic>>>((ref) async {
  ref.watch(dashboardRealtimeProvider);
  final supabase = Supabase.instance.client;
  final user = supabase.auth.currentUser;
  if (user == null) return [];

  final isAdmin = user.appMetadata['is_admin'] == true;
  final requestedEmpId = ref.watch(selectedEmployeeFilterProvider);
  final period = ref.watch(selectedRecentPeriodProvider);

  // Huquqlarni olish
  final profile = ref.watch(userProfileProvider).value;
  final permissions = Map<String, dynamic>.from(profile?['permissions'] ?? {});
  final canSeeExpenses = permissions['see_employee_expenses'] ?? false;

  final now = DateTime.now();
  DateTime start;
  if (period == 'Kun') {
    start = DateTime(now.year, now.month, now.day);
  } else if (period == 'Hafta') {
    start = now.subtract(Duration(days: now.weekday - 1));
    start = DateTime(start.year, start.month, start.day);
  } else if (period == 'Yil') {
    start = DateTime(now.year, 1, 1);
  } else {
    start = DateTime(now.year, now.month, 1);
  }

  // 1. Transactions (Adminniki yoki Hodimniki)
  List<dynamic> txRes = [];
  bool fetchTransactions = false;
  String? targetUserId;

  if (!isAdmin) {
    fetchTransactions = true;
    targetUserId = user.id;
  } else {
    if (requestedEmpId == null || requestedEmpId == user.id) {
      fetchTransactions = true;
      targetUserId = user.id;
    } else if (canSeeExpenses) {
      fetchTransactions = true;
      targetUserId = requestedEmpId;
    }
  }

  if (fetchTransactions && targetUserId != null) {
    txRes = await supabase
        .from('transactions')
        .select()
        .eq('user_id', targetUserId)
        .gte('created_at', start.toIso8601String())
        .order('created_at', ascending: false)
        .limit(20);
  }

  // 2. Salaries (Admin uchun hamma/tanlangan, hodim uchun o'zi)
  var salQuery = supabase
      .from('salaries')
      .select()
      .eq('status', 'confirmed')
      .gte('created_at', start.toIso8601String());

  if (isAdmin) {
    if (requestedEmpId != null) {
      salQuery = salQuery.eq('user_id', requestedEmpId);
    }
  } else {
    salQuery = salQuery.eq('user_id', user.id);
  }

  final salaryRes =
      await salQuery.order('created_at', ascending: false).limit(20);

  List<Map<String, dynamic>> all = [];
  for (var tx in txRes) {
    // BUG FIX: O'zining kirimlarini ham ko'rsin
    all.add({...tx});
  }
  for (var s in salaryRes) {
    all.add({
      'id': s['id'],
      'amount': s['amount_uzs'],
      'type': 'income',
      'category': 'Oylik/Kirim',
      'comment': s['comment'],
      'created_at': s['created_at'],
    });
  }

  all.sort((a, b) =>
      (b['created_at'] as String).compareTo(a['created_at'] as String));
  return all.take(10).toList();
});

// 9. KATEGORIYA STATISTIKASI
final categoryStatsProvider =
    FutureProvider.autoDispose<Map<String, double>>((ref) async {
  ref.watch(dashboardRealtimeProvider);
  final supabase = Supabase.instance.client;
  final user = supabase.auth.currentUser;
  if (user == null) return {};

  final isAdmin = user.appMetadata['is_admin'] == true;
  final requestedEmpId = ref.watch(selectedEmployeeFilterProvider);
  final period = ref.watch(selectedCategoryPeriodProvider);

  // Huquqlarni olish
  final profile = ref.watch(userProfileProvider).value;
  final permissions = Map<String, dynamic>.from(profile?['permissions'] ?? {});
  final canSeeExpenses = permissions['see_employee_expenses'] ?? false;

  final now = DateTime.now();
  DateTime start;
  if (period == 'Kun') {
    start = DateTime(now.year, now.month, now.day);
  } else if (period == 'Hafta') {
    start = now.subtract(Duration(days: now.weekday - 1));
    start = DateTime(start.year, start.month, start.day);
  } else if (period == 'Yil') {
    start = DateTime(now.year, 1, 1);
  } else {
    start = DateTime(now.year, now.month, 1);
  }

  // Qoida: Admin faqat o'zi ko'radi (Xarajat tarkibi diagrammasida)
  // AGAR canSeeExpenses bo'lsa xodimnikini ham ko'radi.
  bool fetchTransactions = false;
  String? targetUserId;

  if (!isAdmin) {
    fetchTransactions = true;
    targetUserId = user.id;
  } else {
    if (requestedEmpId == null || requestedEmpId == user.id) {
      fetchTransactions = true;
      targetUserId = user.id;
    } else if (canSeeExpenses) {
      fetchTransactions = true;
      targetUserId = requestedEmpId;
    }
  }

  List<dynamic> txRes = [];
  if (fetchTransactions && targetUserId != null) {
    txRes = await supabase
        .from('transactions')
        .select('category, amount')
        .eq('user_id', targetUserId)
        .eq('type', 'expense')
        .gte('created_at', start.toIso8601String());
  }

  Map<String, double> stats = {};
  for (var tx in txRes) {
    final cat = tx['category'] ?? 'Boshqa';
    stats[cat] = (stats[cat] ?? 0) + ((tx['amount'] as num?)?.toDouble() ?? 0);
  }
  return stats;
});
