import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:fl_chart/fl_chart.dart';
import 'dashboard_provider.dart';

class DashboardScreen extends ConsumerWidget {
  const DashboardScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final statsAsync = ref.watch(statsProvider);
    final width = MediaQuery.of(context).size.width;
    final bool isWeb = width > 800;

    return Scaffold(
      backgroundColor: Colors.grey.shade50,
      body: RefreshIndicator(
        onRefresh: () async {
          ref.invalidate(statsProvider);
          ref.invalidate(recentTransactionsProvider);
        },
        child: SingleChildScrollView(
          padding: EdgeInsets.all(isWeb ? 32 : 16),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              const Text("Moliyaviy Holat", style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold)),
              const SizedBox(height: 24),

              // 1. KARTALAR
              statsAsync.when(
                data: (stats) => GridView.count(
                  shrinkWrap: true,
                  physics: const NeverScrollableScrollPhysics(),
                  crossAxisCount: isWeb ? 3 : 1,
                  mainAxisSpacing: 16,
                  crossAxisSpacing: 16,
                  childAspectRatio: isWeb ? 3 : 3.5,
                  children: [
                    _StatCard(title: "BALANS", amount: "${stats['balance']}", color: Colors.blue, icon: Icons.account_balance_wallet),
                    _StatCard(title: "KIRIM", amount: "${stats['income']}", color: Colors.green, icon: Icons.trending_up),
                    _StatCard(title: "CHIQIM", amount: "${stats['expense']}", color: Colors.red, icon: Icons.trending_down),
                  ],
                ),
                loading: () => const LinearProgressIndicator(),
                error: (e, _) => Text(e.toString()),
              ),
              
              const SizedBox(height: 32),

              // 2. OYLIK DINAMIKA (12 OY)
              const Text("Oylik Dinamika (Yillik)", style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold)),
              const SizedBox(height: 16),
              _buildMonthlyAreaChart(),
              
              const SizedBox(height: 32),

              // 3. OXIRGI AMALLAR
              const Text("Oxirgi amallar", style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold)),
              const SizedBox(height: 16),
              _buildTransactionsList(ref),
            ],
          ),
        ),
      ),
    );
  }

  Widget _buildMonthlyAreaChart() {
    return Container(
      height: 350,
      padding: const EdgeInsets.fromLTRB(10, 25, 25, 10),
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(24),
        boxShadow: [BoxShadow(color: Colors.black.withOpacity(0.05), blurRadius: 20)],
      ),
      child: LineChart(
        LineChartData(
          gridData: FlGridData(
            show: true,
            drawVerticalLine: false,
            getDrawingHorizontalLine: (v) => FlLine(color: Colors.grey.shade100, strokeWidth: 1),
          ),
          titlesData: FlTitlesData(
            rightTitles: const AxisTitles(sideTitles: SideTitles(showTitles: false)),
            topTitles: const AxisTitles(sideTitles: SideTitles(showTitles: false)),
            bottomTitles: AxisTitles(
              sideTitles: SideTitles(
                showTitles: true,
                reservedSize: 35,
                interval: 1,
                getTitlesWidget: (v, m) {
                  const months = ['Yan', 'Feb', 'Mar', 'Apr', 'May', 'Iyun', 'Iyul', 'Avg', 'Sen', 'Okt', 'Noy', 'Dek'];
                  if (v.toInt() >= 0 && v.toInt() < months.length) {
                    return SideTitleWidget(
                      axisSide: m.axisSide,
                      space: 10,
                      child: Text(months[v.toInt()], style: const TextStyle(fontSize: 10, color: Colors.grey, fontWeight: FontWeight.bold)),
                    );
                  }
                  return const Text('');
                },
              ),
            ),
          ),
          borderData: FlBorderData(show: false),
          minX: 0,
          maxX: 11,
          lineBarsData: [
            LineChartBarData(
              // Spots: 0 - Yanvar, 11 - Dekabr. Hozircha namunaviy ma'lumotlar.
              spots: const [
                FlSpot(0, 2.5), FlSpot(1, 1.8), FlSpot(2, 5), FlSpot(3, 3.2), 
                FlSpot(4, 4.5), FlSpot(5, 3.8), FlSpot(6, 6), FlSpot(7, 5.2),
                FlSpot(8, 7), FlSpot(9, 6.5), FlSpot(10, 8), FlSpot(11, 7.5),
              ],
              isCurved: true,
              color: const Color(0xFF2EAF9B),
              barWidth: 5,
              isStrokeCapRound: true,
              dotData: const FlDotData(show: false), // Nuqtalarni yashiramiz, toza chiqishi uchun
              belowBarData: BarAreaData(
                show: true,
                gradient: LinearGradient(
                  colors: [const Color(0xFF2EAF9B).withOpacity(0.4), const Color(0xFF2EAF9B).withOpacity(0.01)],
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

  Widget _buildTransactionsList(WidgetRef ref) {
    final txAsync = ref.watch(recentTransactionsProvider);
    return txAsync.when(
      data: (list) => ListView.builder(
        shrinkWrap: true,
        physics: const NeverScrollableScrollPhysics(),
        itemCount: list.length,
        itemBuilder: (context, i) => Container(
          margin: const EdgeInsets.only(bottom: 8),
          decoration: BoxDecoration(color: Colors.white, borderRadius: BorderRadius.circular(16)),
          child: ListTile(
            leading: CircleAvatar(
              backgroundColor: list[i]['type'] == 'income' ? Colors.green.withOpacity(0.1) : Colors.red.withOpacity(0.1),
              child: Icon(list[i]['type'] == 'income' ? Icons.south_west : Icons.north_east, size: 16, color: list[i]['type'] == 'income' ? Colors.green : Colors.red),
            ),
            title: Text(list[i]['category'] ?? 'Boshqa', style: const TextStyle(fontWeight: FontWeight.bold)),
            subtitle: Text(list[i]['created_at'].toString().split('T')[0]),
            trailing: Text("${list[i]['amount']} UZS", style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 15)),
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
      decoration: BoxDecoration(
        color: Colors.white, 
        borderRadius: BorderRadius.circular(20),
        boxShadow: [BoxShadow(color: Colors.black.withOpacity(0.02), blurRadius: 10)],
      ),
      child: Row(
        children: [
          Container(
            padding: const EdgeInsets.all(10),
            decoration: BoxDecoration(color: color.withOpacity(0.1), shape: BoxShape.circle),
            child: Icon(icon, color: color, size: 24),
          ),
          const SizedBox(width: 16),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start, 
              mainAxisAlignment: MainAxisAlignment.center, 
              children: [
                Text(title, style: const TextStyle(fontSize: 10, fontWeight: FontWeight.bold, color: Colors.grey)),
                FittedBox(child: Text("$amount UZS", style: const TextStyle(fontSize: 18, fontWeight: FontWeight.bold))),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
