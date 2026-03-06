import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import '../transactions/transaction_repository.dart';
import 'dashboard_repository.dart';

final dashboardRepoProvider = Provider((ref) => DashboardRepository());

final statsProvider = FutureProvider<Map<String, double>>((ref) async {
  return ref.read(dashboardRepoProvider).getMonthlyStats();
});

final pendingSalariesProvider = FutureProvider.autoDispose<List<Map<String, dynamic>>>((ref) async {
  final user = Supabase.instance.client.auth.currentUser;
  if (user == null) return [];

  final isAdmin = user.appMetadata['is_admin'] == true;

  // Bazadan status='pending' bo'lganlarni olamiz
  var query = Supabase.instance.client
      .from('salaries')
      .select()
      .eq('status', 'pending');

  // Shaffoflik mantig'i:
  if (isAdmin) {
    // Admin faqat boshqalar (xodimlar) yuborgan so'rovlarni tasdiqlaydi
    query = query.neq('created_by', user.id);
  } else {
    // Xodim faqat admin unga yozgan pullarni tasdiqlaydi
    query = query.eq('user_id', user.id).neq('created_by', user.id);
  }

  final response = await query;
  return List<Map<String, dynamic>>.from(response);
});
// ... oldingi kodlar (statsProvider, pendingSalariesProvider va hokazo)

// QO'SHILDI: Oxirgi tranzaksiyalarni olib keluvchi provayder
final recentTransactionsProvider = FutureProvider.autoDispose<List<Map<String, dynamic>>>((ref) async {
  final supabase = Supabase.instance.client;
  
  // RLS o'zi ajratib beradi (admin hammasini, user o'zini ko'radi)
  final response = await supabase
      .from('transactions')
      .select()
      .order('created_at', ascending: false)
      .limit(5); // Faqat oxirgi 5 tasini olamiz
      
  return List<Map<String, dynamic>>.from(response);
});
