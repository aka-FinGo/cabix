import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'dashboard_repository.dart';

final dashboardRepoProvider = Provider((ref) => DashboardRepository());

final statsProvider = FutureProvider<Map<String, double>>((ref) async {
  return ref.read(dashboardRepoProvider).getMonthlyStats();
});
// Kutilayotgan tasdiqlarni olish provayderi
final pendingSalariesProvider = FutureProvider<List<Map<String, dynamic>>>((ref) async {
  final repo = ref.read(transactionRepoProvider);
  // Hozirgi foydalanuvchi rolini aniqlash (bu yerda session'dan yoki alohida provider'dan olish mumkin)
  // Test uchun hozircha profilni tekshiramiz
  final user = Supabase.instance.client.auth.currentUser;
  final profile = await Supabase.instance.client
      .from('profiles')
      .select('role')
      .eq('id', user!.id)
      .single();
  
  return repo.getPendingApprovals(profile['role']);
});
