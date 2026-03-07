import 'package:flutter/material.dart';
import 'package:fl_chart/fl_chart.dart';

class DashboardWidgets {
  static String formatCurrency(num amount) {
    String str = amount.truncate().toString();
    String result = '';
    int count = 0;
    for (int i = str.length - 1; i >= 0; i--) {
      if (count != 0 && count % 3 == 0 && str[i] != '-') {
        result = ' ' + result;
      }
      result = str[i] + result;
      count++;
    }
    return result;
  }

  // FinTrack (Web) uchun Oq/Yengil soyali Karta
  static Widget buildWebStatCard({
    required String title,
    required String amountStr,
    required IconData icon,
    required Color iconColor,
    String? trend,
    Color? trendColor,
  }) {
    return Container(
      padding: const EdgeInsets.all(24),
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(20),
        boxShadow: [
          BoxShadow(
            color: Colors.black.withOpacity(0.02),
            blurRadius: 20,
            offset: const Offset(0, 10),
          )
        ],
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Container(
                padding: const EdgeInsets.all(12),
                decoration: BoxDecoration(
                  color: iconColor.withOpacity(0.1),
                  borderRadius: BorderRadius.circular(12),
                ),
                child: Icon(icon, color: iconColor),
              ),
              const Icon(Icons.more_vert, color: Colors.grey),
            ],
          ),
          const SizedBox(height: 16),
          Text(title, style: const TextStyle(color: Colors.grey, fontSize: 14)),
          const SizedBox(height: 8),
          Text(
            "$amountStr UZS",
            style: const TextStyle(
                fontSize: 24,
                fontWeight: FontWeight.bold,
                color: Color(0xFF1E293B)),
          ),
          if (trend != null) ...[
            const SizedBox(height: 12),
            Row(
              children: [
                Icon(
                  trend.contains('+')
                      ? Icons.arrow_upward
                      : Icons.arrow_downward,
                  size: 14,
                  color: trendColor ?? Colors.green,
                ),
                const SizedBox(width: 4),
                Text(
                  trend,
                  style: TextStyle(
                      color: trendColor ?? Colors.green,
                      fontWeight: FontWeight.bold,
                      fontSize: 12),
                ),
                const SizedBox(width: 8),
                const Text("vs o'tgan oy",
                    style: TextStyle(color: Colors.grey, fontSize: 12)),
              ],
            )
          ]
        ],
      ),
    );
  }

  // Bank App (Mobile) uchun Asosiy Yashil Karta
  static Widget buildMobileMainCard({
    required double balance,
    required String name,
  }) {
    return Container(
      width: double.infinity,
      padding: const EdgeInsets.all(24),
      decoration: BoxDecoration(
        gradient: const LinearGradient(
          colors: [Color(0xFF2EAF9B), Color(0xFF0F6659)],
          begin: Alignment.topLeft,
          end: Alignment.bottomRight,
        ),
        borderRadius: BorderRadius.circular(24),
        boxShadow: [
          BoxShadow(
            color: const Color(0xFF0F6659).withOpacity(0.3),
            blurRadius: 20,
            offset: const Offset(0, 10),
          )
        ],
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              const Text("Boshqaruv markazi",
                  style: TextStyle(color: Colors.white70, fontSize: 14)),
              const Icon(Icons.account_balance_wallet,
                  color: Colors.white, size: 28),
            ],
          ),
          const SizedBox(height: 32),
          Text(
            name.toUpperCase(),
            style: const TextStyle(
                color: Colors.white,
                fontSize: 16,
                letterSpacing: 2,
                fontWeight: FontWeight.w500),
          ),
          const SizedBox(height: 8),
          Text(
            "${formatCurrency(balance)} UZS",
            style: const TextStyle(
                color: Colors.white, fontSize: 32, fontWeight: FontWeight.bold),
          ),
        ],
      ),
    );
  }

  // Mobil uchun kichik statistik ustunlar
  static Widget buildMobileStatItem(String title, double amount, Color color) {
    return Container(
      padding: const EdgeInsets.symmetric(vertical: 16, horizontal: 20),
      decoration: BoxDecoration(
          color: Colors.white,
          borderRadius: BorderRadius.circular(20),
          boxShadow: [
            BoxShadow(
                color: Colors.black.withOpacity(0.04),
                blurRadius: 10,
                offset: const Offset(0, 4))
          ]),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(title,
              style: TextStyle(color: Colors.grey.shade600, fontSize: 12)),
          const SizedBox(height: 8),
          Text(
            formatCurrency(amount),
            style: TextStyle(
                color: color, fontSize: 16, fontWeight: FontWeight.bold),
          ),
        ],
      ),
    );
  }

  // FinTrack uslubidagi BarChart (Dinamika)
  static Widget buildBarChart(List<FlSpot> spots) {
    // Eng yuqori qiymatni topish (Y o'qi uchun)
    double maxY = 0;
    for (var spot in spots) {
      if (spot.y > maxY) maxY = spot.y;
    }

    // Agar chart bo'sh bo'lsa
    if (spots.isEmpty || (spots.length == 1 && spots[0].y == 0)) {
      return const Center(
          child: Text("Ma'lumot yo'q", style: TextStyle(color: Colors.grey)));
    }

    return BarChart(
      BarChartData(
        alignment: BarChartAlignment.spaceAround,
        maxY: maxY * 1.2, // ozgina joy qoldiramiz
        barTouchData: BarTouchData(enabled: true),
        titlesData: FlTitlesData(
          show: true,
          bottomTitles: AxisTitles(
            sideTitles: SideTitles(
              showTitles: true,
              getTitlesWidget: (value, meta) {
                // Oddiy sonlarni oy yoki kunga aylantirish mantiqi kerak bo'lsa shu yerda qilinadi
                return Padding(
                    padding: const EdgeInsets.only(top: 8),
                    child: Text(value.toInt().toString(),
                        style:
                            const TextStyle(color: Colors.grey, fontSize: 10)));
              },
            ),
          ),
          leftTitles:
              const AxisTitles(sideTitles: SideTitles(showTitles: false)),
          topTitles:
              const AxisTitles(sideTitles: SideTitles(showTitles: false)),
          rightTitles:
              const AxisTitles(sideTitles: SideTitles(showTitles: false)),
        ),
        gridData: FlGridData(
          show: true,
          drawVerticalLine: false,
          horizontalInterval: (maxY > 0 ? maxY / 3 : 1),
          getDrawingHorizontalLine: (value) => FlLine(
              color: Colors.grey.withOpacity(0.1),
              strokeWidth: 1,
              dashArray: [5, 5]),
        ),
        borderData: FlBorderData(show: false),
        barGroups: spots
            .map((spot) => BarChartGroupData(
                  x: spot.x.toInt(),
                  barRods: [
                    BarChartRodData(
                      toY: spot.y,
                      color: const Color(0xFF3B82F6), // FinTrack Blue
                      width: 16,
                      borderRadius: BorderRadius.circular(4),
                      backDrawRodData: BackgroundBarChartRodData(
                          show: true,
                          toY: maxY * 1.2,
                          color: const Color(0xFFEFF6FF)),
                    ),
                  ],
                ))
            .toList(),
      ),
    );
  }

  // Pie Chart (Xarajatlar bo'linishi) dinamik versiyasi
  static Widget buildPieChart(Map<String, double> categoryStats) {
    if (categoryStats.isEmpty) {
      return const Center(
          child: Text("Ma'lumot yo'q", style: TextStyle(color: Colors.grey)));
    }

    final total = categoryStats.values.fold(0.0, (sum, val) => sum + val);
    final colors = [
      const Color(0xFF1E3A8A),
      const Color(0xFF3B82F6),
      const Color(0xFFBFDBFE),
      const Color(0xFF60A5FA),
      const Color(0xFF93C5FD),
    ];

    int index = 0;
    return PieChart(PieChartData(
      sectionsSpace: 4,
      centerSpaceRadius: 40,
      sections: categoryStats.entries.map((entry) {
        final color = colors[index % colors.length];
        index++;
        final percentage = (entry.value / total * 100).toStringAsFixed(1);
        return PieChartSectionData(
            color: color,
            value: entry.value,
            title: '$percentage%',
            radius: 60,
            titleStyle: const TextStyle(
                color: Colors.white,
                fontWeight: FontWeight.bold,
                fontSize: 12));
      }).toList(),
    ));
  }
}
