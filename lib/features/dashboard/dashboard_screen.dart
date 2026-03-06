import 'dart:ui';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'package:fl_chart/fl_chart.dart';
import '../../core/theme/theme_provider.dart';
import 'dashboard_provider.dart';

class DashboardScreen extends ConsumerWidget {
  const DashboardScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final currentTheme = ref.watch(themeProvider);
    final bool isGlass = currentTheme == AppThemeMode.glass;
    
    final user = Supabase.instance.client.auth.currentUser;
    final bool isAdmin = user?.appMetadata['is_admin'] == true;

    final statsAsync = ref.watch(statsProvider);
    final recentTransactionsAsync = ref.watch(recentTransactionsProvider);

    // Ekran kengligi (Web/Mobile uchun)
    final double width = MediaQuery.of(context).size.width;
    final bool isWeb = width > 800;

    return Scaffold(
      // AppBar olib tashlandi, chunki u MainWrapper'da oq rangda turibdi
      body: Container(
        decoration: isGlass ? const BoxDecoration(
          gradient: LinearGradient(
            colors: [Color(0xFF0F6659), Color(0xFF2EAF9B)],
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
          ),
        ) : BoxDecoration(color: Colors.grey.shade50),
        child: SafeArea(
          child: RefreshIndicator(
            onRefresh: () async {
              ref.invalidate(statsProvider);
              ref.invalidate(recentTransactionsProvider);
              ref.invalidate(pendingSalariesProvider);
            },
            child: SingleChildScrollView(
              physics: const AlwaysScrollableScrollPhysics(),
              padding: EdgeInsets.symmetric(
                horizontal: isWeb ? 32.0 : 16.0, 
                vertical: 20.0
              ),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  // 1. SALOMLASHISH VA ROL
                  Text(
                    isAdmin ? "Admin Boshqaruvi" : "Xodim Ish Stoli",
                    style: TextStyle(
                      fontSize: isWeb ? 32 : 24, 
                      fontWeight: FontWeight.bold,
                      color: isGlass ? Colors.white : Colors.black87
                    ),
                  ),
                  Text(
                    "Bugungi ko'rsatkichlaringiz bilan tanishing",
                    style: TextStyle(
                      fontSize: 14, 
                      color: isGlass ? Colors.white70 : Colors.grey.shade600
                    ),
                  ),
                  const SizedBox(height: 24),

                  // 2. BALANS KARTALARI
                  statsAsync.when(
                    data: (stats) => _buildBalanceCards(context, stats, isWeb),
                    loading: () => const Center(child: CircularProgressIndicator()),
                    error: (e, _) => Center(child: Text("Xatolik: $e")),
                  ),

                  const SizedBox(height: 32),

                  // 3. GRAFIK VA TRANZAKSIYALAR (Webda yonma-yon, Mobilda ustma-ust)
                  if (isWeb)
                    Row(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Expanded(flex: 3, child: _buildChartSection(context, isGlass)),
                        const SizedBox(width: 24),
                        Expanded(flex: 2, child: _buildRecentTransactionsSection(context, recentTransactionsAsync, isAdmin, isGlass)),
                      ],
                    )
                  else
                    Column(
                      children: [
                        _buildChartSection(context, isGlass),
                        const SizedBox(height: 32),
                        _buildRecentTransactionsSection(context, recentTransactionsAsync, isAdmin, isGlass),
                      ],
                    ),
                  
                  const SizedBox(height: 100), // FAB uchun joy
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }

  // --- BALANS KARTALARI ---
  Widget _buildBalanceCards(BuildContext context, Map<String, double> stats, bool isWeb) {
    return LayoutBuilder(
      builder: (context, constraints) {
        return GridView.count(
          shrinkWrap: true,
          physics: const NeverScrollableScrollPhysics(),
          crossAxisCount: isWeb ? 3 : 1,
          mainAxisSpacing: 16,
          crossAxisSpacing: 16,
          childAspectRatio: isWeb ? 2.5 : 3.5,
          children: [
            _FinanceCard(title: "UMUMIY BALANS", amount: "${stats['balance']} UZS", color: Colors.blue, icon: Icons.account_balance_wallet),
            _FinanceCard(title: "KIRIM", amount: "+${stats['income']} UZS", color: Colors.green, icon: Icons.trending_up),
            _FinanceCard(title: "CHIQIM", amount: "-${stats['expense']} UZS", color: Colors.red, icon: Icons.trending_down),
          ],
        );
      },
    );
  }

  // --- OXIRGI TRANZAKSIYALAR BO'LIMI ---
  Widget _buildRecentTransactionsSection(BuildContext context, AsyncValue<List<Map<String, dynamic>>> transactionsAsync, bool isAdmin, bool isGlass) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(
          isAdmin ? "Barcha oxirgi amallar" : "Mening amallarim", 
          style: TextStyle(
            fontSize: 18, 
            fontWeight: FontWeight.bold,
            color: isGlass ? Colors.white : Colors.black87
          )
        ),
        const SizedBox(height: 12),
        _buildRecentTransactionsList(context, transactionsAsync),
      ],
    );
  }

  // --- GRAFIK BO'LIMI ---
  Widget _buildChartSection(BuildContext context, bool isGlass) {
    return Container(
      height: 300,
      padding: const EdgeInsets.all(20),
      decoration: BoxDecoration(
        color: isGlass ? Colors.white.withOpacity(0.1) : Colors.white,
        borderRadius: BorderRadius.circular(24),
        border: isGlass ? Border.all(color: Colors.white.withOpacity(0.2)) : null,
        boxShadow: isGlass ? [] : [BoxShadow(color: Colors.black.withOpacity(0.05), blurRadius: 15)],
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text("Oylik Dinamika", style: TextStyle(fontWeight: FontWeight.bold, color: isGlass ? Colors.white : Colors.black87)),
          const SizedBox(height: 20),
          Expanded(
            child: LineChart(
              LineChartData(
                gridData: FlGridData(show: false),
                titlesData: FlTitlesData(
                  rightTitles: AxisTitles(sideTitles: SideTitles(showTitles: false)),
                  topTitles: AxisTitles(sideTitles: SideTitles(showTitles: false)),
                  bottomTitles: AxisTitles(
                    sideTitles: SideTitles(
                      showTitles: true,
                      getTitlesWidget: (value, meta) {
                        const days = ['Du', 'Se', 'Ch', 'Pa', 'Ju', 'Sh', 'Ya'];
                        if (value.toInt() >= 0 && value.toInt() < days.length) {
                          return Text(days[value.toInt()], style: TextStyle(fontSize: 10, color: isGlass ? Colors.white70 : Colors.grey));
                        }
                        return const Text('');
                      },
                    ),
                  ),
                ),
                borderData: FlBorderData(show: false),
                lineBarsData: [
                  LineChartBarData(
                    spots: const [FlSpot(0, 2), FlSpot(1, 4), FlSpot(2, 3), FlSpot(3, 7), FlSpot(4, 5), FlSpot(5, 8), FlSpot(6, 6)],
                    isCurved: true,
                    color: const Color(0xFF2EAF9B),
                    barWidth: 4,
                    belowBarData: BarAreaData(show: true, color: const Color(0xFF2EAF9B).withOpacity(0.1)),
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }

  // --- TRANZAKSIYALAR RO'YXATI ---
  Widget _buildRecentTransactionsList(BuildContext context, AsyncValue<List<Map<String, dynamic>>> transactionsAsync) {
    return transactionsAsync.when(
      data: (transactions) {
        if (transactions.isEmpty) return const Center(child: Text("Ma'lumot yo'q"));
        return ListView.builder(
          shrinkWrap: true,
          physics: const NeverScrollableScrollPhysics(),
          itemCount: transactions.length,
          itemBuilder: (context, index) {
            final tx = transactions[index];
            final isIncome = tx['type'] == 'income';
            return Card(
              margin: const EdgeInsets.only(bottom: 8),
              shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
              child: ListTile(
                leading: Icon(isIncome ? Icons.arrow_downward : Icons.arrow_upward, color: isIncome ? Colors.green : Colors.red),
                title: Text(tx['category'] ?? 'Boshqa', style: const TextStyle(fontWeight: FontWeight.bold)),
                subtitle: Text(tx['created_at'].toString().split('T')[0]),
                trailing: Text("${isIncome ? '+' : '-'}${tx['amount']} UZS", style: TextStyle(color: isIncome ? Colors.green : Colors.red, fontWeight: FontWeight.bold)),
              ),
            );
          },
        );
      },
      loading: () => const Center(child: CircularProgressIndicator()),
      error: (e, _) => Text(e.toString()),
    );
  }
}

// --- YORDAMCHI KARTA WIDGETI ---
class _FinanceCard extends StatelessWidget {
  final String title;
  final String amount;
  final Color color;
  final IconData icon;

  const _FinanceCard({required this.title, required this.amount, required this.color, required this.icon});

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.all(16),
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(20),
        boxShadow: [BoxShadow(color: color.withOpacity(0.1), blurRadius: 10, offset: const Offset(0, 4))],
      ),
      child: Row(
        children: [
          CircleAvatar(backgroundColor: color.withOpacity(0.1), child: Icon(icon, color: color)),
          const SizedBox(width: 12),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(title, style: const TextStyle(fontSize: 10, fontWeight: FontWeight.bold, color: Colors.grey)),
                Text(amount, style: const TextStyle(fontSize: 16, fontWeight: FontWeight.bold)),
              ],
            ),
          )
        ],
      ),
    );
  }
}
