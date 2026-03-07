import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'package:fl_chart/fl_chart.dart';

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
final selectedEmployeeFilterProvider = StateProvider<String?>((ref) => null);

// 2. FOYDALANUVCHI PROFILI (AppBar uchun)
final userProfileProvider =
    FutureProvider.autoDispose<Map<String, dynamic>>((ref) async {
  ref.watch(dashboardRealtimeProvider); // Realtime triggerga ulanish
  final user = Supabase.instance.client.auth.currentUser;
  if (user == null) return {};
  final res = await Supabase.instance.client
      .from('profiles')
      .select()
      .eq('id', user.id)
      .single();
  return res;
});

// 3. XODIMLAR RO'YXATI
final employeesProvider =
    FutureProvider.autoDispose<List<Map<String, dynamic>>>((ref) async {
  final res = await Supabase.instance.client
      .from('profiles')
      .select('id, full_name')
      .order('full_name');
  return List<Map<String, dynamic>>.from(res);
});

// 4. STATISTIKA
final statsProvider =
    FutureProvider.autoDispose<Map<String, double>>((ref) async {
  ref.watch(dashboardRealtimeProvider); // Realtime triggerga ulanish
  final supabase = Supabase.instance.client;
  final empId = ref.watch(selectedEmployeeFilterProvider) ??
      supabase.auth.currentUser?.id;
  double income = 0;
  double expense = 0;

  // 1. Chiqimlarni olish
  final txRes = await supabase
      .from('transactions')
      .select('type, amount')
      .eq('user_id', empId!);
  for (var tx in txRes) {
    expense += (tx['amount'] as num?)?.toDouble() ?? 0.0;
  }

  // 2. Kirimlarni olish (confirmed salaries)
  final salaryRes = await supabase
      .from('salaries')
      .select('amount_uzs')
      .eq('user_id', empId)
      .eq('status', 'confirmed');
  for (var s in salaryRes) {
    income += (s['amount_uzs'] as num?)?.toDouble() ?? 0.0;
  }

  return {'balance': income - expense, 'income': income, 'expense': expense};
});

// 5. GRAFIK
final chartSpotsProvider =
    FutureProvider.autoDispose<List<FlSpot>>((ref) async {
  ref.watch(dashboardRealtimeProvider); // Realtime triggerga ulanish
  final period = ref.watch(selectedPeriodProvider);
  final empId = ref.watch(selectedEmployeeFilterProvider) ??
      Supabase.instance.client.auth.currentUser?.id;
  final supabase = Supabase.instance.client;
  DateTime now = DateTime.now();
  DateTime start;
  if (period == 'Kun') {
    start = DateTime(now.year, now.month, now.day);
  } else if (period == 'Hafta') {
    start = now.subtract(const Duration(days: 7));
  } else if (period == 'Yil') {
    start = DateTime(now.year, 1, 1);
  } else {
    start = DateTime(now.year, now.month, 1);
  }

  final txRes = await supabase
      .from('transactions')
      .select('amount, created_at')
      .eq('user_id', empId!)
      .gte('created_at', start.toIso8601String())
      .order('created_at');

  final salaryRes = await supabase
      .from('salaries')
      .select('amount_uzs, created_at')
      .eq('user_id', empId)
      .eq('status', 'confirmed')
      .gte('created_at', start.toIso8601String())
      .order('created_at');

  List<Map<String, dynamic>> all = [];
  for (var tx in txRes) {
    all.add({
      'amount': (tx['amount'] as num).toDouble(),
      'created_at': tx['created_at']
    });
  }
  for (var s in salaryRes) {
    all.add({
      'amount': (s['amount_uzs'] as num).toDouble(),
      'created_at': s['created_at']
    });
  }

  all.sort((a, b) => a['created_at'].compareTo(b['created_at']));

  if (all.isEmpty) return [const FlSpot(0, 0)];
  return List.generate(
      all.length,
      (i) =>
          FlSpot(i.toDouble(), (all[i]['amount'] as num).toDouble() / 1000000));
});

// ─────────────────────────────────────────────────────────────────────────────
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
  final empId = ref.watch(selectedEmployeeFilterProvider) ??
      Supabase.instance.client.auth.currentUser?.id;
  final res = await Supabase.instance.client
      .from('transactions')
      .select()
      .eq('user_id', empId!)
      .gte('created_at', '${DateTime.now().year}-01-01');
  List<Map<String, dynamic>> data =
      List.generate(12, (i) => {'month': i, 'income': 0.0, 'expense': 0.0});
  for (var tx in res) {
    int m = DateTime.parse(tx['created_at']).month - 1;
    if (tx['type'] == 'income') {
      data[m]['income'] += tx['amount'];
    } else {
      data[m]['expense'] += tx['amount'];
    }
  }
  return data;
});

// 8. OXIRGI AMALLAR
final recentTransactionsProvider =
    FutureProvider.autoDispose<List<Map<String, dynamic>>>((ref) async {
  ref.watch(dashboardRealtimeProvider); // Realtime triggerga ulanish
  final supabase = Supabase.instance.client;
  final empId = ref.watch(selectedEmployeeFilterProvider) ??
      supabase.auth.currentUser?.id;

  final txRes = await supabase
      .from('transactions')
      .select()
      .eq('user_id', empId!)
      .order('created_at', ascending: false)
      .limit(10);

  final salaryRes = await supabase
      .from('salaries')
      .select()
      .eq('user_id', empId)
      .eq('status', 'confirmed')
      .order('created_at', ascending: false)
      .limit(10);

  List<Map<String, dynamic>> all = [];
  for (var tx in txRes) {
    all.add({...tx, 'type': 'expense'});
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

// 9. KATEGORIYA STATISTIKASI (Pie Chart uchun)
final categoryStatsProvider =
    FutureProvider.autoDispose<Map<String, double>>((ref) async {
  ref.watch(dashboardRealtimeProvider);
  final supabase = Supabase.instance.client;
  final empId = ref.watch(selectedEmployeeFilterProvider) ??
      supabase.auth.currentUser?.id;

  // Xarajatlar kategoriyalari
  final txRes = await supabase
      .from('transactions')
      .select('category, amount')
      .eq('user_id', empId!);

  Map<String, double> stats = {};
  for (var tx in txRes) {
    final cat = tx['category'] ?? 'Boshqa';
    stats[cat] = (stats[cat] ?? 0) + (tx['amount'] as num).toDouble();
  }
  return stats;
});
