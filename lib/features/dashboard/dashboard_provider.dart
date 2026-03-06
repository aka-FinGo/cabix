import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';

// --------------------------------------------------------
// 1. STATISTIKA PROVAYDERI (Balans, Kirim, Chiqim)
// --------------------------------------------------------
final statsProvider = FutureProvider.autoDispose<Map<String, double>>((ref) async {
  final supabase = Supabase.instance.client;
  final user = supabase.auth.currentUser;
  
  if (user == null) return {'balance': 0.0, 'income': 0.0, 'expense': 0.0};

  double income = 0;
  double expense = 0;

  // 1. SHAXSIY TRANZAKSIYALAR (Faqat o'ziga tegishli pullar)
  // .eq('user_id', user.id) orqali Admin ham, xodim ham FAQT o'zini hisoblaydi
  final txResponse = await supabase
      .from('transactions')
      .select('type, amount')
      .eq('user_id', user.id); 

  for (var tx in txResponse) {
    final amount = (tx['amount'] as num?)?.toDouble() ?? 0.0;
    if (tx['type'] == 'income' || tx['type'] == 'kirim') {
      income += amount;
    } else if (tx['type'] == 'expense' || tx['type'] == 'chiqim') {
      expense += amount;
    }
  }

  // 2. OYLIK VA AVANSLAR (Faqat tasdiqlanganlar)
  
  // A) Menga kelgan pullar (Kirim bo'ladi)
  final salariesReceived = await supabase
      .from('salaries')
      .select('amount_uzs')
      .eq('status', 'confirmed')
      .eq('user_id', user.id); // Pulni oluvchi MEN bo'lsam

  for (var salary in salariesReceived) {
    income += (salary['amount_uzs'] as num?)?.toDouble() ?? 0.0;
  }

  // B) Men birovga bergan pullarim (Chiqim bo'ladi)
  final salariesGiven = await supabase
      .from('salaries')
      .select('amount_uzs, user_id')
      .eq('status', 'confirmed')
      .eq('created_by', user.id); // Pulni yuborgan MEN bo'lsam

  for (var salary in salariesGiven) {
    // Agar o'zimga o'zim yozmagan bo'lsam (ya'ni boshqa xodimga bergan bo'lsam) bu menga CHIQIM!
    if (salary['user_id'] != user.id) {
      expense += (salary['amount_uzs'] as num?)?.toDouble() ?? 0.0;
    }
  }

  // Yakuniy balans
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
// Yillik oylik hisobot uchun provayder
final annualReportProvider = FutureProvider.autoDispose<List<Map<String, dynamic>>>((ref) async {
  final supabase = Supabase.instance.client;
  final user = supabase.auth.currentUser;
  if (user == null) return [];

  final now = DateTime.now();
  // Joriy yilning boshidan oxirigacha bo'lgan tranzaksiyalarni olamiz
  final response = await supabase
      .from('transactions')
      .select('type, amount, created_at')
      .eq('user_id', user.id)
      .gte('created_at', '${now.year}-01-01')
      .lte('created_at', '${now.year}-12-31');

  // Oylar bo'yicha guruhlash (0-11)
  List<Map<String, dynamic>> monthlyData = List.generate(12, (index) => {
    'month': index,
    'income': 0.0,
    'expense': 0.0,
  });

  for (var tx in response) {
    final date = DateTime.parse(tx['created_at']);
    final month = date.month - 1;
    final amount = (tx['amount'] as num).toDouble();
    
    if (tx['type'] == 'income') {
      monthlyData[month]['income'] += amount;
    } else {
      monthlyData[month]['expense'] += amount;
    }
  }
  
  return monthlyData;
});
