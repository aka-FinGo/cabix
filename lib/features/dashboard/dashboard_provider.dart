import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'dashboard_repository.dart';

final dashboardRepoProvider = Provider((ref) => DashboardRepository());

final statsProvider = FutureProvider<Map<String, double>>((ref) async {
  return ref.read(dashboardRepoProvider).getMonthlyStats();
});
