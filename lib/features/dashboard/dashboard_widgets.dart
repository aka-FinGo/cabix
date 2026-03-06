import 'package:flutter/material.dart';
import 'package:fl_chart/fl_chart.dart';
import 'package:intl/intl.dart';

class DashboardWidgets {
  static final formatter = NumberFormat('#,###', 'uz_UZ');

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
            style: const TextStyle(fontSize: 24, fontWeight: FontWeight.bold, color: Color(0xFF1E293B)),
          ),
          if (trend != null) ...[
            const SizedBox(height: 12),
            Row(
              children: [
                Icon(
                  trend.contains('+') ? Icons.arrow_upward : Icons.arrow_downward,
                  size: 14,
                  color: trendColor ?? Colors.green,
                ),
                const SizedBox(width: 4),
                Text(
                  trend,
                  style: TextStyle(color: trendColor ?? Colors.green, fontWeight: FontWeight.bold, fontSize: 12),
                ),
                const SizedBox(width: 8),
                const Text("vs o'tgan oy", style: TextStyle(color: Colors.grey, fontSize: 12)),
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
              const Text("Boshqaruv markazi", style: TextStyle(color: Colors.white70, fontSize: 14)),
              const Icon(Icons.account_balance_wallet, color: Colors.white, size: 28),
            ],
          ),
          const SizedBox(height: 32),
          Text(
            name.toUpperCase(),
            style: const TextStyle(color: Colors.white, fontSize: 16, letterSpacing: 2, fontWeight: FontWeight.w500),
          ),
          const SizedBox(height: 8),
          Text(
            "${formatter.format(balance)} UZS",
            style: const TextStyle(color: Colors.white, fontSize: 32, fontWeight: FontWeight.bold),
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
         boxShadow: [BoxShadow(color: Colors.black.withOpacity(0.04), blurRadius: 10, offset: const Offset(0, 4))]
       ),
       child: Column(
         crossAxisAlignment: CrossAxisAlignment.start,
         children: [
           Text(title, style: TextStyle(color: Colors.grey.shade600, fontSize: 12)),
           const SizedBox(height: 8),
           Text(
             "${formatter.format(amount)}",
             style: TextStyle(color: color, fontSize: 16, fontWeight: FontWeight.bold),
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
        return const Center(child: Text("Ma'lumot yo'q", style: TextStyle(color: Colors.grey)));
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
                    child: Text(value.toInt().toString(), style: const TextStyle(color: Colors.grey, fontSize: 10))
                );
              },
            ),
          ),
          leftTitles: const AxisTitles(sideTitles: SideTitles(showTitles: false)),
          topTitles: const AxisTitles(sideTitles: SideTitles(showTitles: false)),
          rightTitles: const AxisTitles(sideTitles: SideTitles(showTitles: false)),
        ),
        gridData: FlGridData(
          show: true,
          drawVerticalLine: false,
          horizontalInterval: (maxY > 0 ? maxY / 3 : 1),
          getDrawingHorizontalLine: (value) => FlLine(color: Colors.grey.withOpacity(0.1), strokeWidth: 1, dashArray: [5, 5]),
        ),
        borderData: FlBorderData(show: false),
        barGroups: spots.map((spot) => BarChartGroupData(
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
                color: const Color(0xFFEFF6FF)
              ),
            ),
          ],
        )).toList(),
      ),
    );
  }

  // Pie Chart (Xarajatlar bo'linishi) yengil versiyasi
  static Widget buildPieChart() {
     return PieChart(
       PieChartData(
         sectionsSpace: 4,
         centerSpaceRadius: 40,
         sections: [
           PieChartSectionData(color: const Color(0xFF1E3A8A), value: 40, title: '40%', radius: 60, titleStyle: const TextStyle(color: Colors.white, fontWeight: FontWeight.bold)), // Dark Blue
           PieChartSectionData(color: const Color(0xFF3B82F6), value: 35, title: '35%', radius: 60, titleStyle: const TextStyle(color: Colors.white, fontWeight: FontWeight.bold)), // Normal Blue
           PieChartSectionData(color: const Color(0xFFBFDBFE), value: 25, title: '25%', radius: 60, titleStyle: const TextStyle(color: Colors.blueGrey, fontWeight: FontWeight.bold)), // Light Blue
         ]
       )
     );
  }
}
