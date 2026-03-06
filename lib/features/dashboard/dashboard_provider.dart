import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import '../transactions/transaction_repository.dart';
import 'dashboard_repository.dart';

final dashboardRepoProvider = Provider((ref) => DashboardRepository());

final statsProvider = FutureProvider<Map<String, double>>((ref) async {
  return ref.read(dashboardRepoProvider).getMonthlyStats();
});

final pendingSalariesProvider = FutureProvider<List<Map<String, dynamic>>>((ref) async {
  final repo = ref.read(transactionRepoProvider);
  final user = Supabase.instance.client.auth.currentUser;
  if (user == null) return [];
  
  final profile = await Supabase.instance.client.from('profiles').select('role').eq('id', user.id).single();
  return repo.getPendingApprovals(profile['role']);
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
