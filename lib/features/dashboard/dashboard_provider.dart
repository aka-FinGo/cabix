import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'package:fl_chart/fl_chart.dart';

// 1. FILTRLAR
final selectedPeriodProvider = StateProvider<String>((ref) => 'Oy');
final selectedEmployeeFilterProvider = StateProvider<String?>((ref) => null);

// 2. FOYDALANUVCHI PROFILI (AppBar uchun)
final userProfileProvider = FutureProvider.autoDispose<Map<String, dynamic>>((ref) async {
  final user = Supabase.instance.client.auth.currentUser;
  if (user == null) return {};
  final res = await Supabase.instance.client.from('profiles').select().eq('id', user.id).single();
  return res;
});

// 3. XODIMLAR RO'YXATI
final employeesProvider = FutureProvider.autoDispose<List<Map<String, dynamic>>>((ref) async {
  final res = await Supabase.instance.client
      .from('profiles')
      .select('id, full_name')
      .order('full_name');
  return List<Map<String, dynamic>>.from(res);
});

// 4. STATISTIKA
final statsProvider = FutureProvider.autoDispose<Map<String, double>>((ref) async {
  final supabase = Supabase.instance.client;
  final empId = ref.watch(selectedEmployeeFilterProvider) ?? supabase.auth.currentUser?.id;
  double income = 0;
  double expense = 0;
  final res = await supabase.from('transactions').select('type, amount').eq('user_id', empId!);
  for (var tx in res) {
    final amt = (tx['amount'] as num?)?.toDouble() ?? 0.0;
    if (tx['type'] == 'income' || tx['type'] == 'kirim') { income += amt; } else { expense += amt; }
  }
  return {'balance': income - expense, 'income': income, 'expense': expense};
});

// 5. GRAFIK
final chartSpotsProvider = FutureProvider.autoDispose<List<FlSpot>>((ref) async {
  final period = ref.watch(selectedPeriodProvider);
  final empId = ref.watch(selectedEmployeeFilterProvider) ?? Supabase.instance.client.auth.currentUser?.id;
  final supabase = Supabase.instance.client;
  DateTime now = DateTime.now();
  DateTime start;
  if (period == 'Kun') { start = DateTime(now.year, now.month, now.day); }
  else if (period == 'Hafta') { start = now.subtract(const Duration(days: 7)); }
  else if (period == 'Yil') { start = DateTime(now.year, 1, 1); }
  else { start = DateTime(now.year, now.month, 1); }
  final res = await supabase.from('transactions').select('amount, created_at').eq('user_id', empId!).gte('created_at', start.toIso8601String()).order('created_at');
  if (res.isEmpty) return [const FlSpot(0, 0)];
  return List.generate(res.length, (i) => FlSpot(i.toDouble(), (res[i]['amount'] as num).toDouble() / 1000000));
});

// ─────────────────────────────────────────────────────────────────────────────
// 6. PENDING NOTIFIKATSIYALAR
//
//  MANTIQ:
//   Xodim o'zi yozadi  → created_by == user_id  → ADMIN tasdiqlaydi
//   Admin xodimga yozadi → user_id == xodim, created_by == admin → XODIM tasdiqlaydi
// ─────────────────────────────────────────────────────────────────────────────
final pendingSalariesProvider = FutureProvider.autoDispose<List<Map<String, dynamic>>>((ref) async {
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
          .select('id, user_id, created_by, amount_uzs, amount_usd, exchange_rate, comment, status, created_at, employee:profiles!salaries_user_id_fkey(full_name)')
          .eq('status', 'pending')
          .order('created_at', ascending: false),
    );
    // Dart filter: faqat xodim o'zi yozgan (ikkala ustun teng)
    return all.where((s) => s['created_by'] == s['user_id']).toList();
  } else {
    // XODIM ko'radi: o'ziga tegishli, lekin ADMIN yozgan → xodim tasdiqlaydi
    final res = await supabase
        .from('salaries')
        .select('id, user_id, created_by, amount_uzs, amount_usd, exchange_rate, comment, status, created_at, creator:profiles!salaries_created_by_fkey(full_name)')
        .eq('status', 'pending')
        .eq('user_id', user.id)
        .neq('created_by', user.id)
        .order('created_at', ascending: false);
    return List<Map<String, dynamic>>.from(res);
  }
});

// 7. YILLIK HISOBOT
final annualReportProvider = FutureProvider.autoDispose<List<Map<String, dynamic>>>((ref) async {
  final empId = ref.watch(selectedEmployeeFilterProvider) ?? Supabase.instance.client.auth.currentUser?.id;
  final res = await Supabase.instance.client.from('transactions').select().eq('user_id', empId!).gte('created_at', '${DateTime.now().year}-01-01');
  List<Map<String, dynamic>> data = List.generate(12, (i) => {'month': i, 'income': 0.0, 'expense': 0.0});
  for (var tx in res) {
    int m = DateTime.parse(tx['created_at']).month - 1;
    if (tx['type'] == 'income') { data[m]['income'] += tx['amount']; } else { data[m]['expense'] += tx['amount']; }
  }
  return data;
});

// 8. OXIRGI AMALLAR
final recentTransactionsProvider = FutureProvider.autoDispose<List<Map<String, dynamic>>>((ref) async {
  final empId = ref.watch(selectedEmployeeFilterProvider) ?? Supabase.instance.client.auth.currentUser?.id;
  final res = await Supabase.instance.client.from('transactions').select().eq('user_id', empId!).order('created_at', ascending: false).limit(10);
  return List<Map<String, dynamic>>.from(res);
});