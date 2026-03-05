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
        // Glass mode uchun chiroyli gradient fon
        decoration: isGlass ? const BoxDecoration(
          gradient: LinearGradient(
            colors: [Color(0xFF667eea), Color(0xFF764ba2)],
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
          ),
        ) : null,
        child: SingleChildScrollView(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              _buildHeader(context),
              const SizedBox(height: 24),
              _buildBalanceCards(context, ref),
              const SizedBox(height: 24),
              const Text("Oylik statistika", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
              const SizedBox(height: 16),
              _buildMainChart(context, ref), // fl_chart uchun joy
              const SizedBox(height: 24),
              const Text("Oxirgi amallar", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
              _buildRecentTransactions(context, ref),
            ],
          ),
        ),
      ),
    );
  }

  // 1. Header: Salomlashish va Mavzuni o'zgartirish
  Widget _buildHeader(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.between,
      children: [
        const Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text("Xush kelibsiz!", style: TextStyle(fontSize: 14, color: Colors.grey)),
            Text("Admin Foydalanuvchi", style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold)),
          ],
        ),
        _ThemeSwitcher(), // Mavzularni almashtiruvchi tugmalar
      ],
    );
  }

  // 2. Balans Kartochkalari (Responsive Grid)
  Widget _buildBalanceCards(BuildContext context, WidgetRef ref) {
    final width = MediaQuery.of(context).size.width;
    int crossAxisCount = width > 1200 ? 3 : (width > 600 ? 2 : 1);

    return GridView.count(
      shrinkWrap: true,
      physics: const NeverScrollableScrollPhysics(),
      crossAxisCount: crossAxisCount,
      childAspectRatio: 2.5,
      mainAxisSpacing: 16,
      crossAxisSpacing: 16,
      children: [
        _FinanceCard(title: "Umumiy balans", amount: "45,000,000 UZS", icon: Icons.account_balance_wallet, color: Colors.blue),
        _FinanceCard(title: "Oylik kirim", amount: "+12,500,000 UZS", icon: Icons.trending_up, color: Colors.green),
        _FinanceCard(title: "Oylik chiqim", amount: "-3,200,000 UZS", icon: Icons.trending_down, color: Colors.red),
      ],
    );
  }

  Widget _buildMainChart(BuildContext context, WidgetRef ref) {
    return _GlassContainer(
      height: 250,
      child: const Center(child: Text("Grafik (fl_chart) bu yerda bo'ladi")),
    );
  }

  Widget _buildRecentTransactions(BuildContext context, WidgetRef ref) {
    return ListView.builder(
      shrinkWrap: true,
      physics: const NeverScrollableScrollPhysics(),
      itemCount: 5,
      itemBuilder: (context, index) => ListTile(
        leading: const CircleAvatar(child: Icon(Icons.shopping_cart)),
        title: const Text("Oziq-ovqat"),
        subtitle: const Text("Bugun, 14:20"),
        trailing: const Text("-150,000 UZS", style: TextStyle(fontWeight: FontWeight.bold, color: Colors.red)),
      ),
    );
  }
}

// ---------------------------------------------------------
// YORDAMCHI WIDGETLAR (Glass Effektlari bilan)
// ---------------------------------------------------------

class _GlassContainer extends ConsumerWidget {
  final Widget child;
  final double? height;

  const _GlassContainer({required this.child, this.height});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final theme = ref.watch(themeProvider);
    if (theme != AppThemeMode.glass) {
      return Container(
        height: height,
        padding: const EdgeInsets.all(16),
        decoration: BoxDecoration(
          color: Theme.of(context).cardColor,
          borderRadius: BorderRadius.circular(20),
          boxShadow: [BoxShadow(color: Colors.black.withOpacity(0.05), blurRadius: 10)],
        ),
        child: child,
      );
    }

    return ClipRRect(
      borderRadius: BorderRadius.circular(24),
      child: BackdropFilter(
        filter: ImageFilter.blur(sigmaX: 10, sigmaY: 10),
        child: Container(
          height: height,
          padding: const EdgeInsets.all(16),
          decoration: BoxDecoration(
            color: Colors.white.withOpacity(0.2),
            borderRadius: BorderRadius.circular(24),
            border: Border.all(color: Colors.white.withOpacity(0.3)),
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
            padding: const EdgeInsets.all(12),
            decoration: BoxDecoration(color: color.withOpacity(0.1), borderRadius: BorderRadius.circular(12)),
            child: Icon(icon, color: color),
          ),
          const SizedBox(width: 16),
          Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(title, style: const TextStyle(color: Colors.grey, fontSize: 13)),
              Text(amount, style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 18)),
            ],
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
        IconButton(onPressed: () => ref.read(themeProvider.notifier).setTheme(AppThemeMode.standard), icon: const Icon(Icons.wb_sunny_outlined)),
        IconButton(onPressed: () => ref.read(themeProvider.notifier).setTheme(AppThemeMode.dark), icon: const Icon(Icons.nightlight_outlined)),
        IconButton(onPressed: () => ref.read(themeProvider.notifier).setTheme(AppThemeMode.glass), icon: const Icon(Icons.auto_awesome_motion)),
      ],
    );
  }
}
