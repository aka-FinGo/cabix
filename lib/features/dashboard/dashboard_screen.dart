import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:fl_chart/fl_chart.dart';
import '../../core/theme/theme_provider.dart';
import 'dashboard_provider.dart';

class DashboardScreen extends ConsumerWidget {
  const DashboardScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final currentTheme = ref.watch(themeProvider);
    final bool isGlass = currentTheme == AppThemeMode.glass;
    final statsAsync = ref.watch(statsProvider);
    final width = MediaQuery.of(context).size.width;
    final bool isWeb = width > 800;

    return Scaffold(
      backgroundColor: Colors.transparent, // MainWrapper foni ko'rinishi uchun
      body: RefreshIndicator(
        onRefresh: () async {
          ref.invalidate(statsProvider);
          ref.invalidate(recentTransactionsProvider);
        },
        child: CustomScrollView(
          slivers: [
            SliverToBoxAdapter(
              child: Padding(
                padding: EdgeInsets.all(isWeb ? 32.0 : 16.0),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    // 1. KARTALAR (Webda 3 ta, Mobilda 1 tadan)
                    statsAsync.when(
                      data: (stats) => _buildResponsiveCards(stats, isWeb),
                      loading: () => const LinearProgressIndicator(),
                      error: (e, _) => Text(e.toString()),
                    ),
                    const SizedBox(height: 32),

                    // 2. GRAFIK (Rasmga moslangan: Area Chart)
                    const Text("Oylik Dinamika", style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold)),
                    const SizedBox(height: 16),
                    _buildProfessionalChart(isGlass),
                    
                    const SizedBox(height: 32),
                    
                    // 3. OXIRGI AMALLAR
                    const Text("Oxirgi amallar", style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold)),
                    const SizedBox(height: 16),
                    _buildRecentTransactionsList(ref),
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildProfessionalChart(bool isGlass) {
    return Container(
      height: 350,
      padding: const EdgeInsets.all(20),
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(24),
        boxShadow: [BoxShadow(color: Colors.black.withOpacity(0.05), blurRadius: 20)],
      ),
      child: LineChart(
        LineChartData(
          gridData: FlGridData(show: true, drawVerticalLine: false, getDrawingHorizontalLine: (value) => FlLine(color: Colors.grey.shade100, strokeWidth: 1)),
          titlesData: FlTitlesData(
            rightTitles: const AxisTitles(sideTitles: SideTitles(showTitles: false)),
            topTitles: const AxisTitles(sideTitles: SideTitles(showTitles: false)),
            bottomTitles: AxisTitles(sideTitles: SideTitles(showTitles: true, reservedSize: 30, getTitlesWidget: (value, meta) {
              const days = ['Dush', 'Sesh', 'Chor', 'Pay', 'Jum', 'Shan', 'Yak'];
              return Text(days[value.toInt() % 7], style: const TextStyle(fontSize: 10, color: Colors.grey));
            })),
          ),
          borderData: FlBorderData(show: false),
          lineBarsData: [
            LineChartBarData(
              spots: const [FlSpot(0, 3), FlSpot(1, 1.5), FlSpot(2, 5), FlSpot(3, 2.5), FlSpot(4, 4), FlSpot(5, 3.5), FlSpot(6, 5)],
              isCurved: true,
              color: const Color(0xFF2EAF9B),
              barWidth: 5,
              isStrokeCapRound: true,
              dotData: const FlDotData(show: true),
              belowBarData: BarAreaData(
                show: true,
                gradient: LinearGradient(
                  colors: [const Color(0xFF2EAF9B).withOpacity(0.4), const Color(0xFF2EAF9B).withOpacity(0.0)],
                  begin: Alignment.topCenter,
                  end: Alignment.bottomCenter,
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildResponsiveCards(Map<String, double> stats, bool isWeb) {
    return GridView.count(
      shrinkWrap: true,
      physics: const NeverScrollableScrollPhysics(),
      crossAxisCount: isWeb ? 3 : 1,
      mainAxisSpacing: 16,
      crossAxisSpacing: 16,
      childAspectRatio: isWeb ? 2.8 : 3.5,
      children: [
        _StatCard(title: "BALANS", amount: "${stats['balance']}", color: Colors.blue, icon: Icons.account_balance_wallet),
        _StatCard(title: "KIRIM", amount: "${stats['income']}", color: Colors.green, icon: Icons.trending_up),
        _StatCard(title: "CHIQIM", amount: "${stats['expense']}", color: Colors.red, icon: Icons.trending_down),
      ],
    );
  }

  Widget _buildRecentTransactionsList(WidgetRef ref) {
    final txAsync = ref.watch(recentTransactionsProvider);
    return txAsync.when(
      data: (list) => ListView.builder(
        shrinkWrap: true,
        physics: const NeverScrollableScrollPhysics(),
        itemCount: list.length,
        itemBuilder: (context, i) => Card(
          elevation: 0,
          margin: const EdgeInsets.only(bottom: 12),
          shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(16)),
          child: ListTile(
            leading: CircleAvatar(backgroundColor: list[i]['type'] == 'income' ? Colors.green.withOpacity(0.1) : Colors.red.withOpacity(0.1), 
            child: Icon(list[i]['type'] == 'income' ? Icons.south_west : Icons.north_east, color: list[i]['type'] == 'income' ? Colors.green : Colors.red, size: 18)),
            title: Text(list[i]['category'] ?? 'Boshqa', style: const TextStyle(fontWeight: FontWeight.bold)),
            trailing: Text("${list[i]['amount']} UZS", style: const TextStyle(fontWeight: FontWeight.bold)),
          ),
        ),
      ),
      loading: () => const Center(child: CircularProgressIndicator()),
      error: (e, _) => Text(e.toString()),
    );
  }
}

class _StatCard extends StatelessWidget {
  final String title;
  final String amount;
  final Color color;
  final IconData icon;
  const _StatCard({required this.title, required this.amount, required this.color, required this.icon});

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.all(20),
      decoration: BoxDecoration(color: Colors.white, borderRadius: BorderRadius.circular(24), boxShadow: [BoxShadow(color: Colors.black.withOpacity(0.05), blurRadius: 10)]),
      child: Row(children: [
        CircleAvatar(backgroundColor: color.withOpacity(0.1), child: Icon(icon, color: color)),
        const SizedBox(width: 16),
        Column(crossAxisAlignment: CrossAxisAlignment.start, mainAxisAlignment: MainAxisAlignment.center, children: [
          Text(title, style: const TextStyle(color: Colors.grey, fontSize: 12, fontWeight: FontWeight.bold)),
          Text("$amount UZS", style: const TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
        ])
      ]),
    );
  }
}
