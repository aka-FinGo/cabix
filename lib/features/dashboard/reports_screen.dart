import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'dashboard_provider.dart';
import 'dashboard_widgets.dart';

class ReportsScreen extends ConsumerWidget {
  const ReportsScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final isDark = Theme.of(context).brightness == Brightness.dark;
    final recent = ref.watch(recentTransactionsProvider);

    return Scaffold(
      backgroundColor:
          isDark ? const Color(0xFF0F0F12) : const Color(0xFFF8FAFC),
      appBar: AppBar(
        title: const Text("Hisobotlar"),
        backgroundColor: Colors.transparent,
        elevation: 0,
        actions: [
          _buildTopFilters(ref),
          const SizedBox(width: 16),
        ],
      ),
      body: Padding(
        padding: const EdgeInsets.all(24),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text("Barcha Harakatlar",
                style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold)),
            const SizedBox(height: 20),
            Expanded(
              child: recent.when(
                data: (list) {
                  if (list.isEmpty)
                    return const Center(child: Text("Hozircha ma'lumot yo'q"));
                  return ListView.builder(
                    itemCount: list.length,
                    itemBuilder: (context, index) {
                      final tx = list[index];
                      final isIncome = tx['type'] == 'income';
                      return Container(
                        margin: const EdgeInsets.only(bottom: 12),
                        padding: const EdgeInsets.all(16),
                        decoration: BoxDecoration(
                          color:
                              isDark ? const Color(0xFF1C1C21) : Colors.white,
                          borderRadius: BorderRadius.circular(16),
                        ),
                        child: Row(
                          children: [
                            CircleAvatar(
                              backgroundColor:
                                  (isIncome ? Colors.green : Colors.red)
                                      .withOpacity(0.1),
                              child: Icon(isIncome ? Icons.add : Icons.remove,
                                  color: isIncome ? Colors.green : Colors.red),
                            ),
                            const SizedBox(width: 16),
                            Expanded(
                              child: Column(
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Text(tx['category'] ?? 'Boshqa',
                                      style: const TextStyle(
                                          fontWeight: FontWeight.bold,
                                          fontSize: 16)),
                                  Text(
                                      tx['created_at'].toString().split('T')[0],
                                      style: const TextStyle(
                                          color: Colors.grey, fontSize: 12)),
                                ],
                              ),
                            ),
                            Text(
                              "${isIncome ? '+' : '-'}${DashboardWidgets.formatCurrency(tx['amount'])} UZS",
                              style: TextStyle(
                                fontWeight: FontWeight.bold,
                                fontSize: 16,
                                color: isIncome
                                    ? Colors.green
                                    : (isDark ? Colors.white : Colors.black87),
                              ),
                            ),
                          ],
                        ),
                      );
                    },
                  );
                },
                loading: () => const Center(child: CircularProgressIndicator()),
                error: (e, __) => Center(child: Text('Xato: $e')),
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildTopFilters(WidgetRef ref) {
    final period = ref.watch(selectedRecentPeriodProvider);
    return Container(
      padding: const EdgeInsets.all(4),
      decoration: BoxDecoration(
          color: Colors.grey.withOpacity(0.1),
          borderRadius: BorderRadius.circular(12)),
      child: Row(
        children: ['Kun', 'Hafta', 'Oy', 'Yil']
            .map((p) => GestureDetector(
                  onTap: () =>
                      ref.read(selectedRecentPeriodProvider.notifier).state = p,
                  child: Container(
                    padding:
                        const EdgeInsets.symmetric(horizontal: 12, vertical: 6),
                    decoration: BoxDecoration(
                      color: period == p ? Colors.white : Colors.transparent,
                      borderRadius: BorderRadius.circular(8),
                    ),
                    child: Text(p,
                        style: TextStyle(
                            color: period == p ? Colors.black : Colors.grey,
                            fontSize: 12)),
                  ),
                ))
            .toList(),
      ),
    );
  }
}
