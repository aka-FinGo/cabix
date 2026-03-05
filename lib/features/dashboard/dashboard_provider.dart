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
