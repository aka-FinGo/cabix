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
              const Text("Moliyaviy Dinamika", style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold)),
              const SizedBox(height: 24),

              // KARTALAR
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

              // 12 OYLIK PROFESSIONAL GRAFIK
              const Text("Yillik Hisobot (Oylar kesimida)", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
              const SizedBox(height: 16),
              _buildMonthlyAreaChart(),
              
              const SizedBox(height: 32),

              // OXIRGI AMALLAR
              const Text("Oxirgi amallar", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
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
          gridData: FlGridData(show: true, drawVerticalLine: false, getDrawingHorizontalLine: (v) => FlLine(color: Colors.grey.shade100, strokeWidth: 1)),
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
                      child: Text(months[v.toInt()], style: const TextStyle(fontSize: 10, color: Colors.grey, fontWeight: FontWeight.bold)),
                    );
                  }
                  return const Text('');
                },
              ),
            ),
          ),
          borderData: FlBorderData(show: false),
          minX: 0, maxX: 11, // 12 ta oy
          lineBarsData: [
            LineChartBarData(
              spots: const [
                FlSpot(0, 3), FlSpot(1, 4.5), FlSpot(2, 3.8), FlSpot(3, 6), 
                FlSpot(4, 5.2), FlSpot(5, 7.5), FlSpot(6, 6.8), FlSpot(7, 8.2),
                FlSpot(8, 7.1), FlSpot(9, 9), FlSpot(10, 8.5), FlSpot(11, 10),
              ],
              isCurved: true,
              color: const Color(0xFF2EAF9B),
              barWidth: 5,
              dotData: const FlDotData(show: false),
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

  Widget _buildTransactionsList(WidgetRef ref) {
    final txAsync = ref.watch(recentTransactionsProvider);
    return txAsync.when(
      data: (list) => ListView.builder(
        shrinkWrap: true,
        physics: const NeverScrollableScrollPhysics(),
        itemCount: list.length,
        itemBuilder: (context, i) => Card(
          elevation: 0,
          margin: const EdgeInsets.only(bottom: 8),
          shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
          child: ListTile(
            leading: Icon(list[i]['type'] == 'income' ? Icons.south_west : Icons.north_east, 
                        color: list[i]['type'] == 'income' ? Colors.green : Colors.red),
            title: Text(list[i]['category'] ?? 'Boshqa', style: const TextStyle(fontWeight: FontWeight.bold)),
            subtitle: Text(list[i]['created_at'].toString().split('T')[0]),
            trailing: Text("${list[i]['amount']} UZS", style: const TextStyle(fontWeight: FontWeight.bold)),
          ),
        ),
      ),
      loading: () => const CircularProgressIndicator(),
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
      padding: const EdgeInsets.all(16),
      decoration: BoxDecoration(color: Colors.white, borderRadius: BorderRadius.circular(20), boxShadow: [BoxShadow(color: Colors.black.withOpacity(0.02), blurRadius: 10)]),
      child: Row(children: [
        Icon(icon, color: color),
        const SizedBox(width: 12),
        Column(crossAxisAlignment: CrossAxisAlignment.start, mainAxisAlignment: MainAxisAlignment.center, children: [
          Text(title, style: const TextStyle(fontSize: 10, color: Colors.grey, fontWeight: FontWeight.bold)),
          Text("$amount UZS", style: const TextStyle(fontSize: 16, fontWeight: FontWeight.bold)),
        ]),
      ]),
    );
  }
}
