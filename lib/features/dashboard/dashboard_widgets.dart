import 'dart:ui';
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

  // Premium Stat Card (StoreShop style)
  static Widget buildStatCard({
    required BuildContext context,
    required String title,
    required String amount,
    required IconData icon,
    required Color color,
    required String trend,
    required bool isPositive,
    required bool isGlass,
    VoidCallback? onTap,
  }) {
    final isDark = Theme.of(context).brightness == Brightness.dark;

    return InkWell(
      onTap: onTap,
      borderRadius: BorderRadius.circular(24),
      child: Container(
        padding: const EdgeInsets.all(20),
        decoration: BoxDecoration(
          color: isGlass
              ? Colors.white.withOpacity(0.1)
              : (isDark ? const Color(0xFF1C1C21) : Colors.white),
          borderRadius: BorderRadius.circular(24),
          border:
              isGlass ? Border.all(color: Colors.white.withOpacity(0.2)) : null,
          boxShadow: isGlass
              ? []
              : [
                  BoxShadow(
                    color: Colors.black.withOpacity(isDark ? 0.3 : 0.05),
                    blurRadius: 20,
                    offset: const Offset(0, 10),
                  )
                ],
        ),
        child: ClipRRect(
          borderRadius: BorderRadius.circular(24),
          child: BackdropFilter(
            filter: ImageFilter.blur(
                sigmaX: isGlass ? 10 : 0, sigmaY: isGlass ? 10 : 0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Container(
                      padding: const EdgeInsets.all(10),
                      decoration: BoxDecoration(
                        color: color.withOpacity(0.15),
                        borderRadius: BorderRadius.circular(12),
                      ),
                      child: Icon(icon, color: color, size: 20),
                    ),
                    const Icon(Icons.more_horiz, color: Colors.grey, size: 20),
                  ],
                ),
                const Spacer(),
                Text(title,
                    style: TextStyle(
                        color: isDark ? Colors.white60 : Colors.grey,
                        fontSize: 13,
                        fontWeight: FontWeight.w500)),
                const SizedBox(height: 8),
                FittedBox(
                  child: Text(
                    "$amount UZS",
                    style: TextStyle(
                        fontSize: 22,
                        fontWeight: FontWeight.bold,
                        color: isDark ? Colors.white : const Color(0xFF1E293B)),
                  ),
                ),
                const SizedBox(height: 12),
                Row(
                  children: [
                    Icon(
                      isPositive ? Icons.trending_up : Icons.trending_down,
                      size: 14,
                      color: isPositive ? Colors.greenAccent : Colors.redAccent,
                    ),
                    const SizedBox(width: 4),
                    Text(
                      trend,
                      style: TextStyle(
                          color: isPositive
                              ? Colors.greenAccent
                              : Colors.redAccent,
                          fontWeight: FontWeight.bold,
                          fontSize: 12),
                    ),
                    const SizedBox(width: 6),
                    const Text("bugun",
                        style: TextStyle(color: Colors.grey, fontSize: 11)),
                  ],
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  // Premium Bar Chart (Dual Bar: Income vs Expense)
  static Widget buildMainChart(List<dynamic> data, bool isDark) {
    if (data.isEmpty) {
      return const Center(
          child: Text("Ma'lumot mavjud emas",
              style: TextStyle(color: Colors.grey)));
    }

    double maxVal = 0;
    for (var d in data) {
      if (d.income > maxVal) maxVal = d.income;
      if (d.expense > maxVal) maxVal = d.expense;
    }
    if (maxVal == 0) maxVal = 1;

    return BarChart(
      BarChartData(
        alignment: BarChartAlignment.spaceAround,
        maxY: maxVal * 1.3,
        barTouchData: BarTouchData(
          enabled: true,
          touchTooltipData: BarTouchTooltipData(
            getTooltipColor: (_) =>
                isDark ? const Color(0xFF2D2D35) : Colors.white,
            getTooltipItem: (group, groupIndex, rod, rodIndex) {
              final isIncome = rodIndex == 0;
              return BarTooltipItem(
                "${isIncome ? 'Kirim' : 'Chiqim'}: ${formatCurrency(rod.toY)} UZS",
                TextStyle(
                  color: isIncome ? Colors.greenAccent : Colors.redAccent,
                  fontWeight: FontWeight.bold,
                  fontSize: 12,
                ),
              );
            },
          ),
        ),
        titlesData: FlTitlesData(
          show: true,
          bottomTitles: AxisTitles(
            sideTitles: SideTitles(
              showTitles: true,
              getTitlesWidget: (value, meta) {
                int idx = value.toInt();
                if (idx < 0 || idx >= data.length) return const SizedBox();
                return Padding(
                  padding: const EdgeInsets.only(top: 10),
                  child: Text(
                    data[idx].label,
                    style: TextStyle(
                      color: isDark ? Colors.white38 : Colors.grey,
                      fontSize: 10,
                    ),
                  ),
                );
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
          getDrawingHorizontalLine: (value) => FlLine(
            color: isDark
                ? Colors.white.withOpacity(0.05)
                : Colors.black.withOpacity(0.05),
            strokeWidth: 1,
          ),
        ),
        borderData: FlBorderData(show: false),
        barGroups: data.asMap().entries.map((entry) {
          int i = entry.key;
          var d = entry.value;
          return BarChartGroupData(
            x: i,
            barsSpace: 4,
            barRods: [
              // Income Bar
              BarChartRodData(
                toY: d.income,
                gradient: const LinearGradient(
                  colors: [Color(0xFF2EAF9B), Color(0xFF5EEAD4)],
                  begin: Alignment.bottomCenter,
                  end: Alignment.topCenter,
                ),
                width: 8,
                borderRadius:
                    const BorderRadius.vertical(top: Radius.circular(4)),
              ),
              // Expense Bar
              BarChartRodData(
                toY: d.expense,
                gradient: const LinearGradient(
                  colors: [Color(0xFFEC4899), Color(0xFFF472B6)],
                  begin: Alignment.bottomCenter,
                  end: Alignment.topCenter,
                ),
                width: 8,
                borderRadius:
                    const BorderRadius.vertical(top: Radius.circular(4)),
              ),
            ],
          );
        }).toList(),
      ),
    );
  }

  // Donut Chart (Traffic/Categories style)
  static Widget buildDonutChart(Map<String, double> stats, bool isDark) {
    if (stats.isEmpty) {
      return const Center(
          child: Text("Ma'lumot yo'q", style: TextStyle(color: Colors.grey)));
    }

    final total = stats.values.fold(0.0, (sum, val) => sum + val);
    final colors = [
      const Color(0xFF6366F1), // Indigo
      const Color(0xFF2EAF9B), // Teal
      const Color(0xFFF59E0B), // Amber
      const Color(0xFFEC4899), // Pink
      const Color(0xFF8B5CF6), // Purple
    ];

    int index = 0;
    return PieChart(
      PieChartData(
        sectionsSpace: 4,
        centerSpaceRadius: 50,
        sections: stats.entries.map((entry) {
          final color = colors[index % colors.length];
          index++;
          final percentage = (entry.value / total * 100).toStringAsFixed(1);
          return PieChartSectionData(
            color: color,
            value: entry.value,
            title: '$percentage%',
            radius: 20,
            titleStyle: const TextStyle(
                fontSize: 10, fontWeight: FontWeight.bold, color: Colors.white),
          );
        }).toList(),
      ),
    );
  }

  // Bank App (Mobile) Main Card - Refined
  static Widget buildMobileMainCard({
    required double balance,
    required String name,
    bool isGlass = false,
  }) {
    return Container(
      width: double.infinity,
      padding: const EdgeInsets.all(28),
      decoration: BoxDecoration(
        gradient: LinearGradient(
          colors: isGlass
              ? [Colors.white.withOpacity(0.2), Colors.white.withOpacity(0.05)]
              : [const Color(0xFF6366F1), const Color(0xFF4F46E5)],
          begin: Alignment.topLeft,
          end: Alignment.bottomRight,
        ),
        borderRadius: BorderRadius.circular(32),
        border:
            isGlass ? Border.all(color: Colors.white.withOpacity(0.3)) : null,
        boxShadow: isGlass
            ? []
            : [
                BoxShadow(
                  color: const Color(0xFF4F46E5).withOpacity(0.3),
                  blurRadius: 25,
                  offset: const Offset(0, 15),
                )
              ],
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Text("Umumiy Balans",
                  style: TextStyle(
                      color: isGlass ? Colors.white : Colors.white70,
                      fontSize: 14,
                      fontWeight: FontWeight.w500)),
              Icon(Icons.contactless,
                  color: Colors.white.withOpacity(0.8), size: 32),
            ],
          ),
          const SizedBox(height: 12),
          Text(
            "${formatCurrency(balance)} UZS",
            style: const TextStyle(
                color: Colors.white,
                fontSize: 34,
                fontWeight: FontWeight.bold,
                letterSpacing: -0.5),
          ),
          const SizedBox(height: 40),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            crossAxisAlignment: CrossAxisAlignment.end,
            children: [
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  const Text("KARTA EGASI",
                      style: TextStyle(
                          color: Colors.white54,
                          fontSize: 10,
                          letterSpacing: 1.5)),
                  const SizedBox(height: 4),
                  Text(name.toUpperCase(),
                      style: const TextStyle(
                          color: Colors.white,
                          fontSize: 16,
                          fontWeight: FontWeight.w600)),
                ],
              ),
              const Text("VISA",
                  style: TextStyle(
                      color: Colors.white,
                      fontSize: 24,
                      fontWeight: FontWeight.w900,
                      fontStyle: FontStyle.italic)),
            ],
          ),
        ],
      ),
    );
  }

  static Widget buildMobileStatItem(
      String title, double amount, Color color, bool isDark) {
    return Container(
      padding: const EdgeInsets.all(16),
      decoration: BoxDecoration(
          color: isDark ? const Color(0xFF1C1C21) : Colors.white,
          borderRadius: BorderRadius.circular(20),
          boxShadow: [
            BoxShadow(
                color: Colors.black.withOpacity(isDark ? 0.2 : 0.03),
                blurRadius: 10,
                offset: const Offset(0, 4))
          ]),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Row(
            children: [
              Container(
                  width: 8,
                  height: 8,
                  decoration:
                      BoxDecoration(color: color, shape: BoxShape.circle)),
              const SizedBox(width: 8),
              Text(title,
                  style: TextStyle(
                      color: isDark ? Colors.white60 : Colors.grey,
                      fontSize: 12)),
            ],
          ),
          const SizedBox(height: 8),
          FittedBox(
            child: Text(
              formatCurrency(amount),
              style: TextStyle(
                  color: isDark ? Colors.white : Colors.black87,
                  fontSize: 16,
                  fontWeight: FontWeight.bold),
            ),
          ),
        ],
      ),
    );
  }
}
