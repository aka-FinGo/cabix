import 'dart:ui';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../../core/theme/theme_provider.dart';

class DashboardScreen extends ConsumerWidget {
  const DashboardScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final currentTheme = ref.watch(themeProvider);
    final bool isGlass = currentTheme == AppThemeMode.glass;

    return Scaffold(
      body: Container(
        decoration: isGlass ? const BoxDecoration(
          gradient: LinearGradient(
            colors: [Color(0xFF0F6659), Color(0xFF2EAF9B)], // Fintech ranglari
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
          ),
        ) : null,
        child: SingleChildScrollView(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              _buildHeader(context, ref),
              const SizedBox(height: 24),
              _buildBalanceCards(context),
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
    );
  }

  Widget _buildHeader(BuildContext context, WidgetRef ref) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween, // XATO SHU YERDA TUZATILDI
      children: [
        const Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text("Xush kelibsiz!", style: TextStyle(fontSize: 14, color: Colors.grey)),
            Text("Admin", style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold)),
          ],
        ),
        _ThemeSwitcher(),
      ],
    );
  }

  Widget _buildBalanceCards(BuildContext context) {
    final width = MediaQuery.of(context).size.width;
    int crossAxisCount = width > 1200 ? 3 : (width > 600 ? 2 : 1);

    return GridView.count(
      shrinkWrap: true,
      physics: const NeverScrollableScrollPhysics(),
      crossAxisCount: crossAxisCount,
      childAspectRatio: 2.8,
      mainAxisSpacing: 16,
      crossAxisSpacing: 16,
      children: const [
        _FinanceCard(title: "Umumiy balans", amount: "45,000,000 UZS", icon: Icons.account_balance_wallet, color: Colors.blue),
        _FinanceCard(title: "Oylik kirim", amount: "+12,500,000 UZS", icon: Icons.trending_up, color: Colors.green),
        _FinanceCard(title: "Oylik chiqim", amount: "-3,200,000 UZS", icon: Icons.trending_down, color: Colors.red),
      ],
    );
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
      itemCount: 5,
      itemBuilder: (context, index) => Card(
        elevation: 0,
        color: Colors.transparent,
        child: ListTile(
          contentPadding: EdgeInsets.zero,
          leading: const CircleAvatar(backgroundColor: Color(0xFFF1F1F1), child: Icon(Icons.shopping_cart, size: 20, color: Colors.black)),
          title: const Text("Oziq-ovqat", style: TextStyle(fontWeight: FontWeight.w600)),
          subtitle: const Text("Bugun, 14:20", style: TextStyle(fontSize: 12)),
          trailing: const Text("-150,000 UZS", style: TextStyle(fontWeight: FontWeight.bold, color: Colors.red)),
        ),
      ),
    );
  }
}

class _GlassContainer extends ConsumerWidget {
  final Widget child;
  final double? height;
  final double? width;

  const _GlassContainer({required this.child, this.height, this.width});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final theme = ref.watch(themeProvider);
    if (theme != AppThemeMode.glass) {
      return Container(
        height: height,
        width: width,
        padding: const EdgeInsets.all(16),
        decoration: BoxDecoration(
          color: Theme.of(context).cardColor,
          borderRadius: BorderRadius.circular(20),
          border: Border.all(color: Colors.grey.withOpacity(0.1)),
        ),
        child: child,
      );
    }

    return ClipRRect(
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
                Text(title, style: const TextStyle(color: Colors.grey, fontSize: 12), maxLines: 1, overflow: TextOverflow.ellipsis),
                Text(amount, style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 16), maxLines: 1, overflow: TextOverflow.ellipsis),
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
