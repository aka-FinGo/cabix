import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';

// --------------------------------------------------------
// 1. FILTRLAR (Vaqt va Xodim)
// --------------------------------------------------------
final selectedPeriodProvider = StateProvider<String>((ref) => 'Oy');
final selectedEmployeeFilterProvider = StateProvider<String?>((ref) => null);

// --------------------------------------------------------
// 2. XODIMLAR RO'YXATI (Admin uchun)
// --------------------------------------------------------
final employeesProvider = FutureProvider.autoDispose<List<Map<String, dynamic>>>((ref) async {
  final response = await Supabase.instance.client
      .from('profiles')
      .select('id, full_name')
      .order('full_name');
  return List<Map<String, dynamic>>.from(response);
});
// PROFIL MA'LUMOTLARINI OLISH (AppBar uchun)
final userProfileProvider = FutureProvider.autoDispose<Map<String, dynamic>>((ref) async {
  final user = Supabase.instance.client.auth.currentUser;
  if (user == null) return {};
  final res = await Supabase.instance.client.from('profiles').select().eq('id', user.id).single();
  return res;
});
// --------------------------------------------------------
// 3. STATISTIKA (Balans, Kirim, Chiqim)
// --------------------------------------------------------
final statsProvider = FutureProvider.autoDispose<Map<String, double>>((ref) async {
  final supabase = Supabase.instance.client;
  final period = ref.watch(selectedPeriodProvider);
  final employeeId = ref.watch(selectedEmployeeFilterProvider) ?? supabase.auth.currentUser?.id;

  if (employeeId == null) return {'balance': 0.0, 'income': 0.0, 'expense': 0.0};

  double income = 0;
  double expense = 0;

  final response = await supabase
      .from('transactions')
      .select('type, amount')
      .eq('user_id', employeeId);

  for (var tx in response) {
    final amount = (tx['amount'] as num?)?.toDouble() ?? 0.0;
    if (tx['type'] == 'income' || tx['type'] == 'kirim') {
      income += amount;
    } else {
      expense += amount;
    }
  }

  return {'balance': income - expense, 'income': income, 'expense': expense};
});

// --------------------------------------------------------
// 4. TASDIQLASH KUTILAYOTGANLAR (XATO BERAYOTGAN QISM MANA SHU!)
// --------------------------------------------------------
final pendingSalariesProvider = FutureProvider.autoDispose<List<Map<String, dynamic>>>((ref) async {
  final supabase = Supabase.instance.client;
  final user = supabase.auth.currentUser;
  if (user == null) return [];

  // Foydalanuvchiga kelgan, lekin hali tasdiqlanmagan pullar
  final response = await supabase
      .from('salaries')
      .select('*, profiles!salaries_created_by_fkey(full_name)')
      .eq('user_id', user.id)
      .eq('status', 'pending')
      .order('created_at', ascending: false);

  return List<Map<String, dynamic>>.from(response);
});

// DINAMIK GRAFIK MA'LUMOTLARI (Vaqtga qarab o'zgaradi)
final chartDataProvider = FutureProvider.autoDispose<List<FlSpot>>((ref) async {
  final period = ref.watch(selectedPeriodProvider);
  final empId = ref.watch(selectedEmployeeFilterProvider) ?? Supabase.instance.client.auth.currentUser?.id;
  final supabase = Supabase.instance.client;

  DateTime now = DateTime.now();
  DateTime startDate;

  // Vaqt oralig'ini belgilash
  if (period == 'Kun') startDate = DateTime(now.year, now.month, now.day);
  else if (period == 'Hafta') startDate = now.subtract(const Duration(days: 7));
  else if (period == 'Oy') startDate = DateTime(now.year, now.month, 1);
  else startDate = DateTime(now.year, 1, 1);

  final res = await supabase.from('transactions')
      .select('amount, created_at')
      .eq('user_id', empId!)
      .gte('created_at', startDate.toIso8601String())
      .order('created_at');

  // Ma'lumotlarni grafik nuqtalariga aylantirish
  List<FlSpot> spots = [];
  for (int i = 0; i < res.length; i++) {
    final amount = (res[i]['amount'] as num).toDouble() / 1000000; // Mln so'mda
    spots.add(FlSpot(i.toDouble(), amount));
  }
  
  if (spots.isEmpty) spots = [const FlSpot(0, 0)]; // Bo'sh bo'lsa xato bermasligi uchun
  return spots;
});

// --------------------------------------------------------
// 6. OXIRGI TRANZAKSIYALAR
// --------------------------------------------------------
final recentTransactionsProvider = FutureProvider.autoDispose<List<Map<String, dynamic>>>((ref) async {
  final employeeId = ref.watch(selectedEmployeeFilterProvider) ?? Supabase.instance.client.auth.currentUser?.id;
  if (employeeId == null) return [];

  final response = await Supabase.instance.client
      .from('transactions')
      .select('*')
      .eq('user_id', employeeId)
      .order('created_at', ascending: false)
      .limit(10);
  return List<Map<String, dynamic>>.from(response);
});

// --------------------------------------------------------
// 7. TRANZAKSIYALAR REPO VA STATUSNI YANGILASH
// --------------------------------------------------------
final transactionRepoProvider = Provider((ref) => TransactionRepository());

class TransactionRepository {
  Future<void> updateSalaryStatus({required String salaryId, required String newStatus}) async {
    await Supabase.instance.client
        .from('salaries')
        .update({'status': newStatus})
        .eq('id', salaryId);
  }
}
