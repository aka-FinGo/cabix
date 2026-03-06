import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:fl_chart/fl_chart.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'dashboard_provider.dart';

class DashboardScreen extends ConsumerWidget {
  const DashboardScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final statsAsync = ref.watch(statsProvider);
    final annualReportAsync = ref.watch(annualReportProvider);
    final width = MediaQuery.of(context).size.width;
    final bool isWeb = width > 800;
    final bool isAdmin = Supabase.instance.client.auth.currentUser?.appMetadata['is_admin'] == true;

    return Scaffold(
      backgroundColor: Colors.grey.shade50,
      body: RefreshIndicator(
        onRefresh: () async {
          ref.invalidate(statsProvider);
          ref.invalidate(annualReportProvider);
        },
        child: SingleChildScrollView(
          padding: EdgeInsets.all(isWeb ? 32 : 16),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              // 1. FILTRLAR BO'LIMI
              _buildFilters(ref, isAdmin),
              const SizedBox(height: 24),

              // 2. KARTALAR
              statsAsync.when(
                data: (stats) => _buildStatCards(stats, isWeb),
                loading: () => const LinearProgressIndicator(),
                error: (e, _) => Text(e.toString()),
              ),
              const SizedBox(height: 32),

              // 3. GRAFIK (Area Chart - 12 oy)
              const Text("Oylik Dinamika", style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold)),
              const SizedBox(height: 16),
              _buildAreaChart(annualReportAsync),
              
              const SizedBox(height: 32),

              // 4. YILLIK JADVAL (Yangi vidjet)
              const Text("Yillik Batafsil Hisobot", style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold)),
              const SizedBox(height: 16),
              _buildAnnualTable(annualReportAsync),

              const SizedBox(height: 32),

              // 5. OXIRGI AMALLAR
              const Text("Oxirgi amallar", style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold)),
              const SizedBox(height: 16),
              _buildRecentTransactions(ref),
            ],
          ),
        ),
      ),
    );
  }

  // --- FILTRLAR WIDGETI ---
  Widget _buildFilters(WidgetRef ref, bool isAdmin) {
    final period = ref.watch(selectedPeriodProvider);
    final selectedEmp = ref.watch(selectedEmployeeFilterProvider);
    final empsAsync = ref.watch(employeesProvider);

    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Row(
          children: ['Kun', 'Hafta', 'Oy', 'Yil'].map((p) => Padding(
            padding: const EdgeInsets.only(right: 8),
            child: ChoiceChip(
              label: Text(p),
              selected: period == p,
              onSelected: (s) => ref.read(selectedPeriodProvider.notifier).state = p,
              selectedColor: const Color(0xFF2EAF9B).withOpacity(0.2),
            ),
          )).toList(),
        ),
        if (isAdmin) ...[
          const SizedBox(height: 12),
          empsAsync.when(
            data: (list) => DropdownButtonFormField<String?>(
              value: selectedEmp,
              decoration: InputDecoration(
                hintText: "Xodimni tanlang",
                filled: true, fillColor: Colors.white,
                border: OutlineInputBorder(borderRadius: BorderRadius.circular(12), borderSide: BorderSide.none),
              ),
              items: [
                const DropdownMenuItem(value: null, child: Text("O'zim (yoki Hamma)")),
                ...list.map((e) => DropdownMenuItem(value: e['id'], child: Text(e['full_name'] ?? 'Ismsiz'))),
              ],
              onChanged: (val) => ref.read(selectedEmployeeFilterProvider.notifier).state = val,
            ),
            loading: () => const SizedBox.shrink(),
            error: (_, __) => const SizedBox.shrink(),
          ),
        ]
      ],
    );
  }

  // --- STATISTIKA KARTALARI ---
  Widget _buildStatCards(Map<String, double> stats, bool isWeb) {
    return GridView.count(
      shrinkWrap: true, physics: const NeverScrollableScrollPhysics(),
      crossAxisCount: isWeb ? 3 : 1, mainAxisSpacing: 16, crossAxisSpacing: 16, childAspectRatio: isWeb ? 3 : 3.5,
      children: [
        _StatCard(title: "BALANS", amount: "${stats['balance']}", color: Colors.blue, icon: Icons.account_balance_wallet),
        _StatCard(title: "KIRIM", amount: "${stats['income']}", color: Colors.green, icon: Icons.trending_up),
        _StatCard(title: "CHIQIM", amount: "${stats['expense']}", color: Colors.red, icon: Icons.trending_down),
      ],
    );
  }

  // --- AREA CHART (PROFESSIONAL) ---
  Widget _buildAreaChart(AsyncValue<List<Map<String, dynamic>>> reportAsync) {
    return Container(
      height: 300, padding: const EdgeInsets.all(20),
      decoration: BoxDecoration(color: Colors.white, borderRadius: BorderRadius.circular(24), boxShadow: [BoxShadow(color: Colors.black.withOpacity(0.05), blurRadius: 20)]),
      child: reportAsync.when(
        data: (data) => LineChart(
          LineChartData(
            gridData: FlGridData(show: true, drawVerticalLine: false, getDrawingHorizontalLine: (v) => FlLine(color: Colors.grey.shade100, strokeWidth: 1)),
            titlesData: FlTitlesData(
              rightTitles: const AxisTitles(sideTitles: SideTitles(showTitles: false)),
              topTitles: const AxisTitles(sideTitles: SideTitles(showTitles: false)),
              bottomTitles: AxisTitles(sideTitles: SideTitles(showTitles: true, getTitlesWidget: (v, m) {
                const months = ['Yan', 'Feb', 'Mar', 'Apr', 'May', 'Iyun', 'Iyul', 'Avg', 'Sen', 'Okt', 'Noy', 'Dek'];
                return Text(months[v.toInt() % 12], style: const TextStyle(fontSize: 10, color: Colors.grey));
              })),
            ),
            borderData: FlBorderData(show: false),
            lineBarsData: [
              LineChartBarData(
                spots: data.map((e) => FlSpot(e['month'].toDouble(), e['income'] / 1000000)).toList(), // mln so'mda
                isCurved: true, color: const Color(0xFF2EAF9B), barWidth: 4,
                belowBarData: BarAreaData(show: true, gradient: LinearGradient(colors: [const Color(0xFF2EAF9B).withOpacity(0.3), const Color(0xFF2EAF9B).withOpacity(0.0)], begin: Alignment.topCenter, end: Alignment.bottomCenter)),
                dotData: const FlDotData(show: false),
              ),
            ],
          ),
        ),
        loading: () => const Center(child: CircularProgressIndicator()),
        error: (e, _) => Text(e.toString()),
      ),
    );
  }

  // --- YILLIK JADVAL ---
  Widget _buildAnnualTable(AsyncValue<List<Map<String, dynamic>>> reportAsync) {
    const months = ['Yanvar', 'Fevral', 'Mart', 'Aprel', 'May', 'Iyun', 'Iyul', 'Avgust', 'Sentyabr', 'Oktyabr', 'Noyabr', 'Dekabr'];
    return reportAsync.when(
      data: (data) => Container(
        decoration: BoxDecoration(color: Colors.white, borderRadius: BorderRadius.circular(20)),
        child: SingleChildScrollView(
          scrollDirection: Axis.horizontal,
          child: DataTable(
            columns: const [
              DataColumn(label: Text('OY')),
              DataColumn(label: Text('KIRIM')),
              DataColumn(label: Text('CHIQIM')),
              DataColumn(label: Text('FOYDA')),
            ],
            rows: data.map((item) {
              final profit = item['income'] - item['expense'];
              return DataRow(cells: [
                DataCell(Text(months[item['month']])),
                DataCell(Text("${item['income']}")),
                DataCell(Text("${item['expense']}")),
                DataCell(Text("${profit}", style: TextStyle(color: profit >= 0 ? Colors.blue : Colors.red, fontWeight: FontWeight.bold))),
              ]);
            }).toList(),
          ),
        ),
      ),
      loading: () => const SizedBox.shrink(),
      error: (e, _) => Text(e.toString()),
    );
  }

  Widget _buildRecentTransactions(WidgetRef ref) {
    final txAsync = ref.watch(recentTransactionsProvider);
    return txAsync.when(
      data: (list) => ListView.builder(
        shrinkWrap: true, physics: const NeverScrollableScrollPhysics(),
        itemCount: list.length,
        itemBuilder: (context, i) => ListTile(
          leading: Icon(list[i]['type'] == 'income' ? Icons.south_west : Icons.north_east, color: list[i]['type'] == 'income' ? Colors.green : Colors.red),
          title: Text(list[i]['category'] ?? 'Boshqa'),
          trailing: Text("${list[i]['amount']} UZS", style: const TextStyle(fontWeight: FontWeight.bold)),
        ),
      ),
      loading: () => const Center(child: CircularProgressIndicator()),
      error: (e, _) => Text(e.toString()),
    );
  }
}

class _StatCard extends StatelessWidget {
  final String title; final String amount; final Color color; final IconData icon;
  const _StatCard({required this.title, required this.amount, required this.color, required this.icon});

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.all(16),
      decoration: BoxDecoration(color: Colors.white, borderRadius: BorderRadius.circular(20), border: Border.all(color: Colors.grey.shade100)),
      child: Row(children: [
        Icon(icon, color: color, size: 28),
        const SizedBox(width: 12),
        Column(crossAxisAlignment: CrossAxisAlignment.start, mainAxisAlignment: MainAxisAlignment.center, children: [
          Text(title, style: const TextStyle(fontSize: 10, color: Colors.grey, fontWeight: FontWeight.bold)),
          Text("$amount UZS", style: const TextStyle(fontSize: 16, fontWeight: FontWeight.bold)),
        ]),
      ]),
    );
  }
}
