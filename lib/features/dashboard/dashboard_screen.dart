import 'dart:ui';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import '../../core/theme/theme_provider.dart';
import '../transactions/transaction_repository.dart';
import 'dashboard_provider.dart';

class DashboardScreen extends ConsumerWidget {
  const DashboardScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final currentTheme = ref.watch(themeProvider);
    final bool isGlass = currentTheme == AppThemeMode.glass;
    
    // ROLNI TO'G'RIDAN-TO'G'RI METADATADAN OLAMIZ (DATABASEGA SO'ROV YO'Q!)
    final user = Supabase.instance.client.auth.currentUser;
    final String role = user?.appMetadata['role'] ?? 'user';

    final statsAsync = ref.watch(statsProvider);
    final pendingAsync = ref.watch(pendingSalariesProvider);

    return Scaffold(
      body: Container(
        decoration: isGlass ? const BoxDecoration(
          gradient: LinearGradient(
            colors: [Color(0xFF0F6659), Color(0xFF2EAF9B)],
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
          ),
        ) : null,
        child: RefreshIndicator(
          onRefresh: () async {
            ref.invalidate(statsProvider);
            ref.invalidate(pendingSalariesProvider);
          },
          child: SingleChildScrollView(
            physics: const AlwaysScrollableScrollPhysics(),
            padding: const EdgeInsets.all(16.0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                _buildHeader(context, ref, role),
                const SizedBox(height: 24),
                
                // Balanslar
                _buildBalanceCards(context, statsAsync, role),

                // Tasdiq kutilayotganlar
                pendingAsync.when(
                  data: (items) => items.isNotEmpty 
                    ? _buildPendingSection(context, ref, items, role) 
                    : const SizedBox.shrink(),
                  loading: () => const LinearProgressIndicator(),
                  error: (e, _) => const SizedBox.shrink(),
                ),

                const SizedBox(height: 24),
                const Text("Haftalik hisobot", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
                const SizedBox(height: 16),
                _buildChartPlaceholder(), // fl_chart uchun joy
                
                const SizedBox(height: 24),
                _buildRecentTransactions(role),
              ],
            ),
          ),
        ),
      ),
    );
  }

  Widget _buildHeader(BuildContext context, WidgetRef ref, String role) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text("Xush kelibsiz!", style: TextStyle(color: Colors.grey)),
            Text(role == 'admin' ? "Admin Boshqaruvi" : "Xodim Paneli", 
                style: const TextStyle(fontSize: 22, fontWeight: FontWeight.bold)),
          ],
        ),
        _ThemeSwitcher(),
      ],
    );
  }

  Widget _buildBalanceCards(BuildContext context, AsyncValue<Map<String, double>> stats, String role) {
    return stats.when(
      data: (data) => GridView.count(
        shrinkWrap: true,
        crossAxisCount: MediaQuery.of(context).size.width > 600 ? 3 : 1,
        childAspectRatio: 3,
        mainAxisSpacing: 12,
        crossAxisSpacing: 12,
        children: [
          _FinanceCard(title: "Balans", amount: "${data['balance']} UZS", color: Colors.blue),
          _FinanceCard(title: "Kirim", amount: "+${data['income']} UZS", color: Colors.green),
          _FinanceCard(title: "Chiqim", amount: "-${data['expense']} UZS", color: Colors.red),
        ],
      ),
      loading: () => const Center(child: CircularProgressIndicator()),
      error: (e, _) => const Text("Xatolik yuz berdi"),
    );
  }

  Widget _buildPendingSection(BuildContext context, WidgetRef ref, List<Map<String, dynamic>> items, String role) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        const SizedBox(height: 20),
        Text("Tasdiqlash kutilmoqda (${items.length})", style: const TextStyle(color: Colors.orange, fontWeight: FontWeight.bold)),
        ListView.builder(
          shrinkWrap: true,
          itemCount: items.length,
          itemBuilder: (context, index) => Card(
            child: ListTile(
              title: Text("${items[index]['amount_uzs']} UZS"),
              subtitle: Text(items[index]['comment'] ?? ""),
              trailing: Row(
                mainAxisSize: MainAxisSize.min,
                children: [
                  IconButton(icon: const Icon(Icons.check, color: Colors.green), onPressed: () => _action(ref, items[index]['id'], 'confirmed')),
                  IconButton(icon: const Icon(Icons.close, color: Colors.red), onPressed: () => _action(ref, items[index]['id'], 'rejected')),
                ],
              ),
            ),
          ),
        ),
      ],
    );
  }

  Future<void> _action(WidgetRef ref, String id, String status) async {
    await ref.read(transactionRepoProvider).updateSalaryStatus(salaryId: id, newStatus: status);
    ref.invalidate(pendingSalariesProvider);
    ref.invalidate(statsProvider);
  }

  Widget _buildChartPlaceholder() => Container(height: 200, decoration: BoxDecoration(color: Colors.black12, borderRadius: BorderRadius.circular(16)), child: const Center(child: Text("Grafik fl_chart")));

  Widget _buildRecentTransactions(String role) => const Column(children: [Text("Oxirgi amallar"), SizedBox(height: 100, child: Center(child: Text("Tarix bo'sh")))]);
}

class _FinanceCard extends StatelessWidget {
  final String title;
  final String amount;
  final Color color;
  const _FinanceCard({required this.title, required this.amount, required this.color});
  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.all(16),
      decoration: BoxDecoration(color: color.withOpacity(0.1), borderRadius: BorderRadius.circular(16), border: Border.all(color: color.withOpacity(0.2))),
      child: Column(crossAxisAlignment: CrossAxisAlignment.start, mainAxisAlignment: MainAxisAlignment.center, children: [Text(title, style: TextStyle(color: color, fontSize: 12)), Text(amount, style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 16))]),
    );
  }
}

class _ThemeSwitcher extends ConsumerWidget {
  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return IconButton(onPressed: () => ref.read(themeProvider.notifier).setTheme(AppThemeMode.glass), icon: const Icon(Icons.auto_awesome));
  }
}
