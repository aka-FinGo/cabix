import 'dart:ui';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'package:fl_chart/fl_chart.dart'; // fl_chart kutubxonasi
import '../../core/theme/theme_provider.dart';
import '../transactions/transaction_repository.dart';
import 'dashboard_provider.dart';

class DashboardScreen extends ConsumerWidget {
  const DashboardScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final currentTheme = ref.watch(themeProvider);
    final bool isGlass = currentTheme == AppThemeMode.glass;
    
    // 1. ROLNI TOKEN DAN OLISH (Bazada recursion bo'lmasligi uchun eng muhim qator!)
    final user = Supabase.instance.client.auth.currentUser;
    final bool isAdmin = user?.appMetadata['is_admin'] == true;

    // 2. Ma'lumotlarni yuklash
    final statsAsync = ref.watch(statsProvider);
    final pendingAsync = ref.watch(pendingSalariesProvider);
    // YENGI QO'SHILDI: Tranzaksiyalar provayderini kuzatish
    final recentTransactionsAsync = ref.watch(recentTransactionsProvider);

    return Scaffold(
      body: Container(
        decoration: isGlass ? const BoxDecoration(
          gradient: LinearGradient(
            colors: [Color(0xFF0F6659), Color(0xFF2EAF9B)],
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
          ),
        ) : null,
        child: SafeArea(
          child: RefreshIndicator(
            onRefresh: () async {
              ref.invalidate(statsProvider);
              ref.invalidate(pendingSalariesProvider);
              ref.invalidate(recentTransactionsProvider); // Buni ham yangilaymiz
            },
            child: CustomScrollView(
              physics: const AlwaysScrollableScrollPhysics(),
              slivers: [
                SliverAppBar(
                  floating: true,
                  backgroundColor: Colors.transparent,
                  elevation: 0,
                  title: Text(isAdmin ? "CABIX: Admin Panel" : "CABIX: Xodim Paneli", 
                    style: TextStyle(color: isGlass ? Colors.white : Colors.black, fontWeight: FontWeight.bold)
                  ),
                  actions: [
                    _ThemeSwitcher(),
                    IconButton(
                      tooltip: "Tizimdan chiqish",
                      icon: Icon(Icons.logout_rounded, color: isGlass ? Colors.white : Colors.black),
                      onPressed: () async {
                        await Supabase.instance.client.auth.signOut();
                        // GoRouter o'zi login sahifasiga otib yuboradi
                      },
                    ),
                  ],
                ),
                SliverToBoxAdapter(
                  child: Padding(
                    padding: const EdgeInsets.all(16.0),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        // --- BALANS KARTALARI ---
                        statsAsync.when(
                          data: (stats) => _buildBalanceCards(context, stats, isAdmin),
                          loading: () => const Center(child: CircularProgressIndicator()),
                          error: (e, _) => _buildErrorState(e.toString(), ref),
                        ),

                        const SizedBox(height: 24),

                        // --- TASDIQLASH KUTILAYOTGANLAR ---
                        pendingAsync.when(
                          data: (items) => items.isNotEmpty 
                            ? _buildPendingSection(context, ref, items, isAdmin) 
                            : const SizedBox.shrink(),
                          loading: () => const LinearProgressIndicator(),
                          error: (e, _) => const SizedBox.shrink(),
                        ),

                        const SizedBox(height: 24),

                        // --- STATISTIKA GRAFIGI (FL_CHART) ---
                        const Text("Oylik Dinamika", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
                        const SizedBox(height: 16),
                        _buildChartSection(context),
                        
                        const SizedBox(height: 24),

                        // --- OXIRGI AMALLAR ---
                        Text(isAdmin ? "Barcha oxirgi amallar" : "Mening amallarim", 
                            style: const TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
                        const SizedBox(height: 12),
                        
                        // YENGI QO'SHILDI: Haqiqiy ma'lumotlarni chizish
                        _buildRecentTransactions(context, recentTransactionsAsync),
                        
                        const SizedBox(height: 80), // Fab tugma yopib qo'ymasligi uchun joy
                      ],
                    ),
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  // --- BALANS KARTALARI WIDGETI ---
  Widget _buildBalanceCards(BuildContext context, Map<String, double> stats, bool isAdmin) {
    final width = MediaQuery.of(context).size.width;
    int crossAxisCount = width > 800 ? 3 : (width > 500 ? 2 : 1);
    
    return GridView.count(
      shrinkWrap: true,
      physics: const NeverScrollableScrollPhysics(),
      crossAxisCount: crossAxisCount,
      mainAxisSpacing: 16,
      crossAxisSpacing: 16,
      childAspectRatio: 2.5,
      children: [
        _FinanceCard(title: "UMUMIY BALANS", amount: "${stats['balance']} UZS", color: Colors.blue, icon: Icons.account_balance_wallet),
        _FinanceCard(title: "KIRIM", amount: "+${stats['income']} UZS", color: Colors.green, icon: Icons.trending_up),
        _FinanceCard(title: "CHIQIM", amount: "-${stats['expense']} UZS", color: Colors.red, icon: Icons.trending_down),
      ],
    );
  }

  // --- TASDIQLASH BO'LIMI WIDGETI ---
  Widget _buildPendingSection(BuildContext context, WidgetRef ref, List<Map<String, dynamic>> items, bool isAdmin) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Row(
          children: [
            const Icon(Icons.pending_actions, color: Colors.orange),
            const SizedBox(width: 8),
            Text("Tasdiq kutilmoqda (${items.length})", 
              style: const TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.orange)),
          ],
        ),
        const SizedBox(height: 12),
        ListView.builder(
          shrinkWrap: true,
          physics: const NeverScrollableScrollPhysics(),
          itemCount: items.length,
          itemBuilder: (context, index) {
            final item = items[index];
            return Card(
              shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(16)),
              child: ListTile(
                contentPadding: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
                title: Text("${item['amount_uzs']} UZS", style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 16)),
                subtitle: Text("Izoh: ${item['comment'] ?? 'Izohsiz'}\nSana: ${item['created_at'].toString().split('T')[0]}"),
                trailing: Row(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    IconButton(
                      icon: const Icon(Icons.check_circle, color: Colors.green, size: 28),
                      onPressed: () async {
                        await ref.read(transactionRepoProvider).updateSalaryStatus(salaryId: item['id'], newStatus: 'confirmed');
                        ref.invalidate(pendingSalariesProvider);
                        ref.invalidate(statsProvider);
                      },
                    ),
                    IconButton(
                      icon: const Icon(Icons.cancel, color: Colors.red, size: 28),
                      onPressed: () async {
                        await ref.read(transactionRepoProvider).updateSalaryStatus(salaryId: item['id'], newStatus: 'rejected');
                        ref.invalidate(pendingSalariesProvider);
                      },
                    ),
                  ],
                ),
              ),
            );
          },
        ),
      ],
    );
  }

  // --- FL_CHART GRAFIK WIDGETI ---
  Widget _buildChartSection(BuildContext context) {
    return Container(
      height: 250,
      padding: const EdgeInsets.all(16),
      decoration: BoxDecoration(
        color: Theme.of(context).cardColor.withOpacity(0.8),
        borderRadius: BorderRadius.circular(20),
        boxShadow: [BoxShadow(color: Colors.black.withOpacity(0.05), blurRadius: 10)],
      ),
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
                  const days = ['Dush', 'Sesh', 'Chor', 'Pay', 'Jum', 'Shan', 'Yak'];
                  if (value.toInt() >= 0 && value.toInt() < days.length) {
                    return Padding(padding: const EdgeInsets.only(top: 8.0), child: Text(days[value.toInt()], style: const TextStyle(fontSize: 10)));
                  }
                  return const Text('');
                },
              ),
            ),
          ),
          borderData: FlBorderData(show: false),
          lineBarsData: [
            LineChartBarData(
              spots: const [
                FlSpot(0, 1), FlSpot(1, 3), FlSpot(2, 2), FlSpot(3, 5), FlSpot(4, 3.5), FlSpot(5, 6), FlSpot(6, 4),
              ],
              isCurved: true,
              color: const Color(0xFF2EAF9B),
              barWidth: 4,
              isStrokeCapRound: true,
              dotData: FlDotData(show: false),
              belowBarData: BarAreaData(show: true, color: const Color(0xFF2EAF9B).withOpacity(0.2)),
            ),
          ],
        ),
      ),
    );
  }

  // --- HAQIQIY TRANZAKSIYALAR RO'YXATI WIDGETI (YANGILANDI) ---
  Widget _buildRecentTransactions(BuildContext context, AsyncValue<List<Map<String, dynamic>>> transactionsAsync) {
    return transactionsAsync.when(
      data: (transactions) {
        if (transactions.isEmpty) {
          return Container(
            padding: const EdgeInsets.all(32),
            alignment: Alignment.center,
            child: Column(
              children: [
                Icon(Icons.receipt_long_outlined, size: 48, color: Colors.grey.shade400),
                const SizedBox(height: 16),
                Text("Hozircha hech qanday amal bajarilmagan", style: TextStyle(color: Colors.grey.shade600)),
              ],
            ),
          );
        }

        return ListView.builder(
          shrinkWrap: true,
          physics: const NeverScrollableScrollPhysics(),
          itemCount: transactions.length,
          itemBuilder: (context, index) {
            final tx = transactions[index];
            // Baza tuzilishiga qarab 'income' yoki 'expense' ekanligini aniqlaymiz
            final isIncome = tx['type'] == 'income' || tx['type'] == 'kirim'; 
            final amount = tx['amount']?.toString() ?? '0';
            final date = tx['created_at'].toString().split('T')[0]; // Sanani ajratib olish
            final category = tx['category'] ?? 'Boshqa';
            
            return Card(
              elevation: 0,
              color: Theme.of(context).cardColor.withOpacity(0.5),
              shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
              margin: const EdgeInsets.only(bottom: 8),
              child: ListTile(
                leading: CircleAvatar(
                  backgroundColor: isIncome ? Colors.green.withOpacity(0.1) : Colors.red.withOpacity(0.1),
                  child: Icon(
                    isIncome ? Icons.south_west_rounded : Icons.north_east_rounded, 
                    color: isIncome ? Colors.green : Colors.red, 
                    size: 20
                  )
                ),
                title: Text(category, style: const TextStyle(fontWeight: FontWeight.bold)),
                subtitle: Text("$date • ${tx['description'] ?? ''}", style: const TextStyle(fontSize: 12), maxLines: 1, overflow: TextOverflow.ellipsis),
                trailing: Text(
                  "${isIncome ? '+' : '-'}$amount UZS", 
                  style: TextStyle(
                    color: isIncome ? Colors.green : Colors.red, 
                    fontWeight: FontWeight.bold,
                    fontSize: 14,
                  )
                ),
              ),
            );
          },
        );
      },
      loading: () => const Padding(
        padding: EdgeInsets.all(20.0),
        child: Center(child: CircularProgressIndicator()),
      ),
      error: (e, _) => Padding(
        padding: const EdgeInsets.all(20.0),
        child: Center(child: Text("Xatolik yuz berdi", style: const TextStyle(color: Colors.red))),
      ),
    );
  }

  Widget _buildErrorState(String error, WidgetRef ref) {
    return Container(
      padding: const EdgeInsets.all(20),
      decoration: BoxDecoration(color: Colors.red.withOpacity(0.1), borderRadius: BorderRadius.circular(16)),
      child: Column(
        children: [
          const Icon(Icons.error_outline, color: Colors.red, size: 48),
          const SizedBox(height: 16),
          Text("Xatolik yuz berdi: $error", textAlign: TextAlign.center),
          const SizedBox(height: 16),
          ElevatedButton(
            onPressed: () => ref.refresh(statsProvider),
            child: const Text("Qayta yuklash"),
          )
        ],
      ),
    );
  }
}

// --- KICHIK YORDAMCHI WIDGETLAR ---

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
        color: Theme.of(context).cardColor.withOpacity(0.9),
        borderRadius: BorderRadius.circular(20),
        border: Border.all(color: color.withOpacity(0.3), width: 1.5),
        boxShadow: [BoxShadow(color: color.withOpacity(0.05), blurRadius: 10, offset: const Offset(0, 4))],
      ),
      child: Row(
        children: [
          Container(
            padding: const EdgeInsets.all(12),
            decoration: BoxDecoration(color: color.withOpacity(0.1), shape: BoxShape.circle),
            child: Icon(icon, color: color, size: 28),
          ),
          const SizedBox(width: 16),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(title, style: TextStyle(color: Colors.grey.shade600, fontSize: 12, fontWeight: FontWeight.bold)),
                const SizedBox(height: 4),
                FittedBox(child: Text(amount, style: const TextStyle(fontSize: 20, fontWeight: FontWeight.bold))),
              ],
            ),
          )
        ],
      ),
    );
  }
}

class _ThemeSwitcher extends ConsumerWidget {
  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final theme = ref.watch(themeProvider);
    return IconButton(
      tooltip: "Mavzuni o'zgartirish",
      icon: Icon(theme == AppThemeMode.glass ? Icons.dark_mode : Icons.auto_awesome),
      onPressed: () {
        ref.read(themeProvider.notifier).setTheme(
          theme == AppThemeMode.glass ? AppThemeMode.standard : AppThemeMode.glass
        );
      },
    );
  }
}
