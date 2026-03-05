import 'dart:ui';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../../core/theme/theme_provider.dart';
import '../transactions/transaction_repository.dart';
import 'dashboard_provider.dart';

class DashboardScreen extends ConsumerWidget {
  const DashboardScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final currentTheme = ref.watch(themeProvider);
    final bool isGlass = currentTheme == AppThemeMode.glass;
    
    // Ma'lumotlarni provayderlardan olish
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
                _buildHeader(context, ref),
                const SizedBox(height: 24),
                
                // 1. Balans Kartochkalari (Real ma'lumotlar bilan)
                _buildBalanceCards(context, statsAsync),
                
                // 2. Tasdiqlash kutilayotgan amallar (Faqat ma'lumot bo'lsa chiqadi)
                pendingAsync.when(
                  data: (items) => items.isNotEmpty 
                    ? _buildPendingSection(context, ref, items) 
                    : const SizedBox.shrink(),
                  loading: () => const Padding(
                    padding: EdgeInsets.symmetric(vertical: 20),
                    child: Center(child: LinearProgressIndicator()),
                  ),
                  error: (e, _) => const SizedBox.shrink(),
                ),

                const SizedBox(height: 24),
                const Text("Oylik statistika", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
                const SizedBox(height: 16),
                _buildMainChart(context),
                
                const SizedBox(height: 24),
                const Text("Oxirgi amallar", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
                _buildRecentTransactions(),
              ],
            ),
          ),
        ),
      ),
    );
  }

  // Header bo'limi
  Widget _buildHeader(BuildContext context, WidgetRef ref) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        const Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text("Xush kelibsiz!", style: TextStyle(fontSize: 14, color: Colors.grey)),
            Text("Boshqaruv paneli", style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold)),
          ],
        ),
        _ThemeSwitcher(),
      ],
    );
  }

  // Balans kartochkalari vidjeti
  Widget _buildBalanceCards(BuildContext context, AsyncValue<Map<String, double>> statsAsync) {
    return statsAsync.when(
      data: (stats) {
        final width = MediaQuery.of(context).size.width;
        int crossAxisCount = width > 1200 ? 3 : (width > 600 ? 2 : 1);
        return GridView.count(
          shrinkWrap: true,
          physics: const NeverScrollableScrollPhysics(),
          crossAxisCount: crossAxisCount,
          childAspectRatio: 2.8,
          mainAxisSpacing: 16,
          crossAxisSpacing: 16,
          children: [
            _FinanceCard(
              title: "Umumiy balans", 
              amount: "${stats['balance']?.toStringAsFixed(0)} UZS", 
              icon: Icons.account_balance_wallet, 
              color: Colors.blue
            ),
            _FinanceCard(
              title: "Oylik kirim", 
              amount: "+${stats['income']?.toStringAsFixed(0)} UZS", 
              icon: Icons.trending_up, 
              color: Colors.green
            ),
            _FinanceCard(
              title: "Oylik chiqim", 
              amount: "-${stats['expense']?.toStringAsFixed(0)} UZS", 
              icon: Icons.trending_down, 
              color: Colors.red
            ),
          ],
        );
      },
      loading: () => const Center(child: CircularProgressIndicator()),
      error: (e, _) => Center(child: Text("Xatolik: $e")),
    );
  }

  // Tasdiqlash kutilayotgan amallar vidjeti
  Widget _buildPendingSection(BuildContext context, WidgetRef ref, List<Map<String, dynamic>> items) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        const SizedBox(height: 24),
        Row(
          children: [
            const Icon(Icons.pending_actions, color: Colors.orange, size: 20),
            const SizedBox(width: 8),
            Text(
              "Tasdiqlash kutilmoqda (${items.length})",
              style: const TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.orange),
            ),
          ],
        ),
        const SizedBox(height: 12),
        ListView.builder(
          shrinkWrap: true,
          physics: const NeverScrollableScrollPhysics(),
          itemCount: items.length,
          itemBuilder: (context, index) {
            final item = items[index];
            return _GlassContainer(
              margin: const EdgeInsets.only(bottom: 10),
              child: ListTile(
                contentPadding: const EdgeInsets.symmetric(horizontal: 12),
                title: Text("${item['amount_uzs']} UZS", style: const TextStyle(fontWeight: FontWeight.bold)),
                subtitle: Text("Kimdan: ${item['profiles']?['full_name'] ?? 'Noma\'lum'}\nIzoh: ${item['comment'] ?? '-'}"),
                trailing: Row(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    IconButton(
                      icon: const Icon(Icons.check_circle, color: Colors.green),
                      onPressed: () => _updateStatus(ref, item['id'], 'confirmed'),
                    ),
                    IconButton(
                      icon: const Icon(Icons.cancel, color: Colors.red),
                      onPressed: () => _updateStatus(ref, item['id'], 'rejected'),
                    ),
                  ],
                ),
              ),
            );
          },
        ),
      ],
    );
  }

  Future<void> _updateStatus(WidgetRef ref, String id, String status) async {
    await ref.read(transactionRepoProvider).updateSalaryStatus(salaryId: id, newStatus: status);
    ref.invalidate(pendingSalariesProvider);
    ref.invalidate(statsProvider);
  }

  Widget _buildMainChart(BuildContext context) {
    return _GlassContainer(
      height: 250,
      width: double.infinity,
      child: const Center(child: Text("Grafik (fl_chart) tayyorlanmoqda...")),
    );
  }

  Widget _buildRecentTransactions() {
    return ListView.builder(
      shrinkWrap: true,
      physics: const NeverScrollableScrollPhysics(),
      itemCount: 3,
      itemBuilder: (context, index) => ListTile(
        contentPadding: EdgeInsets.zero,
        leading: const CircleAvatar(child: Icon(Icons.history, size: 20)),
        title: const Text("Oxirgi amaliyot"),
        subtitle: const Text("Bugun"),
        trailing: const Text("Ko'rish", style: TextStyle(color: Colors.blue)),
      ),
    );
  }
}

// ---------------------------------------------------------
// UI KOMPONENTLARI (Glassmorphism & Cards)
// ---------------------------------------------------------

class _GlassContainer extends ConsumerWidget {
  final Widget child;
  final double? height;
  final double? width;
  final EdgeInsetsGeometry? margin;

  const _GlassContainer({required this.child, this.height, this.width, this.margin});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final theme = ref.watch(themeProvider);
    if (theme != AppThemeMode.glass) {
      return Container(
        height: height,
        width: width,
        margin: margin,
        padding: const EdgeInsets.all(16),
        decoration: BoxDecoration(
          color: Theme.of(context).cardColor,
          borderRadius: BorderRadius.circular(20),
          border: Border.all(color: Colors.grey.withOpacity(0.1)),
        ),
        child: child,
      );
    }

    return Container(
      margin: margin,
      child: ClipRRect(
        borderRadius: BorderRadius.circular(24),
        child: BackdropFilter(
          filter: ImageFilter.blur(sigmaX: 12, sigmaY: 12),
          child: Container(
            height: height,
            width: width,
            padding: const EdgeInsets.all(16),
            decoration: BoxDecoration(
              color: Colors.white.withOpacity(0.15),
              borderRadius: BorderRadius.circular(24),
              border: Border.all(color: Colors.white.withOpacity(0.2)),
            ),
            child: child,
          ),
        ),
      ),
    );
  }
}

class _FinanceCard extends StatelessWidget {
  final String title;
  final String amount;
  final IconData icon;
  final Color color;

  const _FinanceCard({required this.title, required this.amount, required this.icon, required this.color});

  @override
  Widget build(BuildContext context) {
    return _GlassContainer(
      child: Row(
        children: [
          Container(
            padding: const EdgeInsets.all(10),
            decoration: BoxDecoration(color: color.withOpacity(0.1), borderRadius: BorderRadius.circular(12)),
            child: Icon(icon, color: color, size: 24),
          ),
          const SizedBox(width: 12),
          Expanded(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(title, style: const TextStyle(color: Colors.grey, fontSize: 12)),
                Text(amount, style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 16)),
              ],
            ),
          )
        ],
      ),
    );
  }
}

class _ThemeSwitcher extends ConsumerWidget {
  @override
  Widget build(BuildContext context, WidgetRef ref) {
    return Row(
      children: [
        IconButton(onPressed: () => ref.read(themeProvider.notifier).setTheme(AppThemeMode.standard), icon: const Icon(Icons.light_mode_outlined, size: 20)),
        IconButton(onPressed: () => ref.read(themeProvider.notifier).setTheme(AppThemeMode.dark), icon: const Icon(Icons.dark_mode_outlined, size: 20)),
        IconButton(onPressed: () => ref.read(themeProvider.notifier).setTheme(AppThemeMode.glass), icon: const Icon(Icons.blur_on, size: 20)),
      ],
    );
  }
}
