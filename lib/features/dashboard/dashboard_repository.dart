import 'package:supabase_flutter/supabase_flutter.dart';

class DashboardRepository {
  final _client = Supabase.instance.client;

  Future<Map<String, double>> getMonthlyStats() async {
    final userId = _client.auth.currentUser?.id;
    if (userId == null) return {'income': 0, 'expense': 0, 'balance': 0};

    // 1. Oylik kirimlarni (Salaries) hisoblash
    final salaryResponse = await _client
        .from('salaries')
        .select('amount_uzs')
        .eq('user_id', userId);
    
    // 2. Tranzaksiyalarni (Income/Expense) hisoblash
    final transResponse = await _client
        .from('transactions')
        .select('type, amount_uzs')
        .eq('user_id', userId);

    double totalIncome = 0;
    double totalExpense = 0;

    for (var item in salaryResponse) {
      totalIncome += (item['amount_uzs'] as num).toDouble();
    }

    for (var item in transResponse) {
      if (item['type'] == 'income') {
        totalIncome += (item['amount_uzs'] as num).toDouble();
      } else {
        totalExpense += (item['amount_uzs'] as num).toDouble();
      }
    }

    return {
      'income': totalIncome,
      'expense': totalExpense,
      'balance': totalIncome - totalExpense,
    };
  }
}
