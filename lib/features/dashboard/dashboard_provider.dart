import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart'; // Supabase xatosini tuzatadi
import '../transactions/transaction_repository.dart'; // Repo xatosini tuzatadi
import 'dashboard_repository.dart';

// Statistikani hisoblash uchun repo
final dashboardRepoProvider = Provider((ref) => DashboardRepository());

// Balanslar uchun provider
final statsProvider = FutureProvider<Map<String, double>>((ref) async {
  return ref.read(dashboardRepoProvider).getMonthlyStats();
});

// Tasdiqlash kutilayotganlar uchun provider
final pendingSalariesProvider = FutureProvider<List<Map<String, dynamic>>>((ref) async {
  final repo = ref.read(transactionRepoProvider);
  final user = Supabase.instance.client.auth.currentUser;
  
  if (user == null) return [];

  final profile = await Supabase.instance.client
      .from('profiles')
      .select('role')
      .eq('id', user.id)
      .single();
  
  return repo.getPendingApprovals(profile['role']);
});
