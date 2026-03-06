import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';

// --------------------------------------------------------
// 1. STATISTIKA PROVAYDERI (Balans, Kirim, Chiqim)
// --------------------------------------------------------
final statsProvider = FutureProvider.autoDispose<Map<String, double>>((ref) async {
  final supabase = Supabase.instance.client;
  final user = supabase.auth.currentUser;
  
  if (user == null) return {'balance': 0.0, 'income': 0.0, 'expense': 0.0};

  // Tranzaksiyalarni o'qiymiz
  final response = await supabase.from('transactions').select('type, amount');
  
  double income = 0;
  double expense = 0;

  for (var tx in response) {
    final amount = (tx['amount'] as num).toDouble();
    if (tx['type'] == 'income' || tx['type'] == 'kirim') {
      income += amount;
    } else if (tx['type'] == 'expense' || tx['type'] == 'chiqim') {
      expense += amount;
    }
  }

  // Tasdiqlangan oylik/avanslarni (salaries) ham kirimga qo'shamiz
  final salariesResponse = await supabase
      .from('salaries')
      .select('amount_uzs')
      .eq('status', 'confirmed'); // Faqat tasdiqlanganlari balansga ta'sir qiladi

  for (var salary in salariesResponse) {
    income += (salary['amount_uzs'] as num).toDouble();
  }

  final balance = income - expense;

  return {
    'balance': balance,
    'income': income,
    'expense': expense,
  };
});

// --------------------------------------------------------
// 2. TASDIQLASH KUTILAYOTGANLAR (Pending Salaries)
// --------------------------------------------------------
final pendingSalariesProvider = FutureProvider.autoDispose<List<Map<String, dynamic>>>((ref) async {
  final user = Supabase.instance.client.auth.currentUser;
  if (user == null) return [];

  final isAdmin = user.appMetadata['is_admin'] == true;

  // Bazadan status='pending' bo'lganlarni olamiz
  var query = Supabase.instance.client
      .from('salaries')
      .select()
      .eq('status', 'pending');

  // MANTIQ:
  // Admin -> Xodimlar yozgan so'rovlarni ko'radi (o'zi yozganini emas)
  // Xodim -> Admin unga yozgan pullarni ko'radi (o'zi yozganini emas)
  if (isAdmin) {
    query = query.neq('created_by', user.id);
  } else {
    query = query.eq('user_id', user.id).neq('created_by', user.id);
  }

  final response = await query;
  return List<Map<String, dynamic>>.from(response);
});

// --------------------------------------------------------
// 3. OXIRGI TRANZAKSIYALAR (Recent Transactions)
// --------------------------------------------------------
final recentTransactionsProvider = FutureProvider.autoDispose<List<Map<String, dynamic>>>((ref) async {
  final supabase = Supabase.instance.client;
  
  // RLS (Xavfsizlik qoidalari) o'zi avtomatik ravishda 
  // Admin bo'lsa hammasini, Xodim bo'lsa faqat o'zinikini ajratib beradi.
  final response = await supabase
      .from('transactions')
      .select()
      .order('created_at', ascending: false)
      .limit(5); 
      
  return List<Map<String, dynamic>>.from(response);
});

// --------------------------------------------------------
// 4. HOLATNI YANGILASH FUNKSIYASI (Tasdiqlash/Rad etish)
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
