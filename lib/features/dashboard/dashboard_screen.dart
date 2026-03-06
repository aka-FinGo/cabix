import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:fl_chart/fl_chart.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'dashboard_provider.dart';

class DashboardScreen extends ConsumerWidget {
  const DashboardScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final stats = ref.watch(statsProvider);
    final width = MediaQuery.of(context).size.width;
    final bool isWeb = width > 800;
    final bool isAdmin = Supabase.instance.client.auth.currentUser?.appMetadata['is_admin'] == true;

    return Scaffold(
      backgroundColor: Colors.grey.shade50,
      body: RefreshIndicator(
        onRefresh: () async { ref.invalidate(statsProvider); ref.invalidate(chartSpotsProvider); },
        child: SingleChildScrollView(
          padding: EdgeInsets.all(isWeb ? 32 : 16),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              _buildTopFilters(ref, isAdmin),
              const SizedBox(height: 24),
              stats.when(data: (s) => _buildStatCards(s, isWeb), loading: () => const LinearProgressIndicator(), error: (e, _) => Text('$e')),
              const SizedBox(height: 32),
              const Text("Dinamika (Mln UZS)", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
              const SizedBox(height: 16),
              _buildDynamicChart(ref),
              const SizedBox(height: 32),
              const Text("Yillik Batafsil Jadval", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
              const SizedBox(height: 16),
              _buildAnnualTable(ref),
            ],
          ),
        ),
      ),
    );
  }

  Widget _buildTopFilters(WidgetRef ref, bool isAdmin) {
    final period = ref.watch(selectedPeriodProvider);
    final selectedEmp = ref.watch(selectedEmployeeFilterProvider);
    final emps = ref.watch(employeesProvider);

    return Column(children: [
      Row(children: ['Kun', 'Hafta', 'Oy', 'Yil'].map((p) => Padding(
        padding: const EdgeInsets.only(right: 8),
        child: ChoiceChip(label: Text(p), selected: period == p, onSelected: (_) => ref.read(selectedPeriodProvider.notifier).state = p),
      )).toList()),
      if (isAdmin) Padding(
        padding: const EdgeInsets.only(top: 12),
        child: emps.when(data: (list) => DropdownButtonFormField<String?>(
          value: selectedEmp, decoration: InputDecoration(filled: true, fillColor: Colors.white, border: OutlineInputBorder(borderRadius: BorderRadius.circular(12), borderSide: BorderSide.none), hintText: "Xodimni tanlang"),
          items: [const DropdownMenuItem(value: null, child: Text("Hamma")), ...list.map((e) => DropdownMenuItem(value: e['id'], child: Text(e['full_name'] ?? '---')))],
          onChanged: (v) => ref.read(selectedEmployeeFilterProvider.notifier).state = v,
        ), loading: () => const SizedBox(), error: (_, __) => const SizedBox()),
      )
    ]);
  }

  Widget _buildStatCards(Map<String, double> s, bool isWeb) {
    return GridView.count(
      shrinkWrap: true, physics: const NeverScrollableScrollPhysics(), crossAxisCount: isWeb ? 3 : 1, mainAxisSpacing: 12, crossAxisSpacing: 12, childAspectRatio: isWeb ? 3 : 4,
      children: [
        _stat("BALANS", "${s['balance']}", Colors.blue),
        _stat("KIRIM", "${s['income']}", Colors.green),
        _stat("CHIQIM", "${s['expense']}", Colors.red),
      ],
    );
  }

  Widget _stat(String t, String v, Color c) => Container(padding: const EdgeInsets.all(12), decoration: BoxDecoration(color: Colors.white, borderRadius: BorderRadius.circular(16), border: Border.all(color: Colors.grey.shade200)), child: Column(mainAxisAlignment: MainAxisAlignment.center, children: [Text(t, style: const TextStyle(fontSize: 10, color: Colors.grey)), Text("$v UZS", style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold, color: c))]));

  Widget _buildDynamicChart(WidgetRef ref) {
    final spots = ref.watch(chartSpotsProvider);
    return Container(
      height: 250, padding: const EdgeInsets.all(16), decoration: BoxDecoration(color: Colors.white, borderRadius: BorderRadius.circular(20)),
      child: spots.when(
        data: (s) => LineChart(LineChartData(
          gridData: FlGridData(show: false), borderData: FlBorderData(show: false),
          titlesData: FlTitlesData(topTitles: const AxisTitles(), rightTitles: const AxisTitles()),
          lineBarsData: [LineChartBarData(spots: s, isCurved: true, color: Colors.teal, barWidth: 4, belowBarData: BarAreaData(show: true, gradient: LinearGradient(colors: [Colors.teal.withOpacity(0.3), Colors.transparent], begin: Alignment.topCenter, end: Alignment.bottomCenter)))],
        )),
        loading: () => const Center(child: CircularProgressIndicator()),
        error: (_, __) => const Center(child: Text("Ma'lumot yo'q")),
      ),
    );
  }

  Widget _buildAnnualTable(WidgetRef ref) {
    final report = ref.watch(annualReportProvider);
    const months = ['Yan', 'Fev', 'Mar', 'Apr', 'May', 'Iyun', 'Iyul', 'Avg', 'Sen', 'Okt', 'Noy', 'Dek'];
    return report.when(
      data: (data) => Container(width: double.infinity, decoration: BoxDecoration(color: Colors.white, borderRadius: BorderRadius.circular(16)), child: SingleChildScrollView(scrollDirection: Axis.horizontal, child: DataTable(columns: const [DataColumn(label: Text('Oy')), DataColumn(label: Text('Kirim')), DataColumn(label: Text('Chiqim'))], rows: data.map((e) => DataRow(cells: [DataCell(Text(months[e['month']])), DataCell(Text('${e['income']}')), DataCell(Text('${e['expense']}'))])).toList()))),
      loading: () => const SizedBox(), error: (_, __) => const SizedBox(),
    );
  }
}
