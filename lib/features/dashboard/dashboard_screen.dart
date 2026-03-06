import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:fl_chart/fl_chart.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'dashboard_provider.dart';
import 'dashboard_widgets.dart';

class DashboardScreen extends ConsumerWidget {
  const DashboardScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final width = MediaQuery.of(context).size.width;
    final bool isWeb = width > 800; // O'tish nuqtasi

    final theme = ref.watch(themeProvider);

    return Scaffold(
      backgroundColor: theme == AppThemeMode.glass ? Colors.transparent : (theme == AppThemeMode.dark ? const Color(0xFF1E1E2C) : const Color(0xFFF1F5F9)),
      body: RefreshIndicator(
        onRefresh: () async { 
          ref.invalidate(statsProvider); 
          ref.invalidate(chartSpotsProvider); 
          ref.invalidate(recentTransactionsProvider);
        },
        child: isWeb ? _buildWebLayout(context, ref) : _buildMobileLayout(context, ref),
      ),
    );
  }

  // ==========================================
  // WEB LAYOUT (FinTrack uslubi)
  // ==========================================
  Widget _buildWebLayout(BuildContext context, WidgetRef ref) {
    final stats = ref.watch(statsProvider);
    final user = Supabase.instance.client.auth.currentUser;
    final isAdmin = user?.appMetadata['is_admin'] == true;

    return SingleChildScrollView(
      padding: const EdgeInsets.all(40),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          // Header qismi
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text("Salom, ${user?.email?.split('@')[0] ?? 'Foydalanuvchi'} 👋", style: const TextStyle(fontSize: 28, fontWeight: FontWeight.bold, color: Color(0xFF1E293B))),
                  const SizedBox(height: 8),
                  const Text("Moliya, osonlashgan va nazorat ostida.", style: TextStyle(color: Colors.grey, fontSize: 16)),
                ],
              ),
              _buildTopFilters(ref, isAdmin),
            ],
          ),
          const SizedBox(height: 40),
          
          // Asosiy Kontent (Chapa qism va O'ng qism)
          Row(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              // CHAP QISM (Kartalar va Bar Chart)
              Expanded(
                flex: 2,
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    // Kartalar Grid
                    stats.when(
                      data: (s) => GridView.count(
                        shrinkWrap: true,
                        physics: const NeverScrollableScrollPhysics(),
                        crossAxisCount: 2,
                        mainAxisSpacing: 24,
                        crossAxisSpacing: 24,
                        childAspectRatio: 1.8,
                        children: [
                           DashboardWidgets.buildWebStatCard(title: "Umumiy Balans", amountStr: "${s['balance']}", icon: Icons.account_balance_wallet, iconColor: Colors.blue, trend: "+4.59%"),
                           DashboardWidgets.buildWebStatCard(title: "Oylik Chiqimlar", amountStr: "${s['expense']}", icon: Icons.money_off, iconColor: Colors.red, trend: "-2.97%", trendColor: Colors.red),
                           DashboardWidgets.buildWebStatCard(title: "Oylik Kirimlar", amountStr: "${s['income']}", icon: Icons.savings, iconColor: Colors.green, trend: "+65%"),
                           DashboardWidgets.buildWebStatCard(title: "Kutilayotgan", amountStr: "0.0", icon: Icons.pending_actions, iconColor: Colors.orange, trend: "-03 Days Left", trendColor: Colors.orange),
                        ],
                      ),
                      loading: () => const Center(child: CircularProgressIndicator()),
                      error: (e, _) => Text('Error: $e'),
                    ),
                    const SizedBox(height: 32),
                    
                    // Finance Statistics (Bar Chart)
                    Container(
                      padding: const EdgeInsets.all(24),
                      decoration: BoxDecoration(color: Colors.white, borderRadius: BorderRadius.circular(20)),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          const Row(
                            mainAxisAlignment: MainAxisAlignment.spaceBetween,
                            children: [
                              Text("Moliya Statistikasi", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
                              Icon(Icons.more_horiz)
                            ]
                          ),
                          const SizedBox(height: 24),
                          SizedBox(
                            height: 250,
                            child: ref.watch(chartSpotsProvider).when(
                              data: (spots) => DashboardWidgets.buildBarChart(spots),
                              loading: () => const Center(child: CircularProgressIndicator()),
                              error: (_, __) => const SizedBox(),
                            ),
                          )
                        ],
                      ),
                    )
                  ],
                ),
              ),
              const SizedBox(width: 32),
              
              // O'NG QISM (Pie Chart va Ro'yxat)
              Expanded(
                flex: 1,
                child: Column(
                  children: [
                     // Spending Breakdown (Pie Chart)
                     Container(
                       padding: const EdgeInsets.all(24),
                       decoration: BoxDecoration(color: Colors.white, borderRadius: BorderRadius.circular(20)),
                       child: Column(
                         crossAxisAlignment: CrossAxisAlignment.start,
                         children: [
                           const Text("Xarajat Bo'linishi", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
                           const SizedBox(height: 24),
                           SizedBox(height: 200, child: DashboardWidgets.buildPieChart()),
                           const SizedBox(height: 32),
                           _buildLegendItem("Oylik", "40%", const Color(0xFF1E3A8A)),
                           const SizedBox(height: 12),
                           _buildLegendItem("Xizmatlar", "35%", const Color(0xFF3B82F6)),
                           const SizedBox(height: 12),
                           _buildLegendItem("Boshqa", "25%", const Color(0xFFBFDBFE)),
                         ]
                       ),
                     ),
                     const SizedBox(height: 32),
                     
                     // Recent Transactions
                     Container(
                       padding: const EdgeInsets.all(24),
                       decoration: BoxDecoration(color: Colors.white, borderRadius: BorderRadius.circular(20)),
                       child: Column(
                         crossAxisAlignment: CrossAxisAlignment.start,
                         children: [
                           const Text("Oxirgi Amallar", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
                           const SizedBox(height: 16),
                           _buildRecentTxList(ref),
                         ],
                       ),
                     )
                  ],
                ),
              )
            ],
          )
        ],
      )
    );
  }

  // ==========================================
  // MOBILE LAYOUT (Bank App uslubi)
  // ==========================================
  Widget _buildMobileLayout(BuildContext context, WidgetRef ref) {
    final stats = ref.watch(statsProvider);
    final user = Supabase.instance.client.auth.currentUser;
    final isAdmin = user?.appMetadata['is_admin'] == true;

    return SingleChildScrollView(
      padding: const EdgeInsets.all(20),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const SizedBox(height: 40), // SafeArea o'rniga
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              const Icon(Icons.menu, color: Colors.black87),
              Text("Home", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.grey.shade800)),
              CircleAvatar(backgroundColor: Colors.grey.shade200, child: const Icon(Icons.person_outline, color: Colors.black)),
            ],
          ),
          const SizedBox(height: 32),
          
          // Asosiy Yashil Karta
          stats.when(
            data: (s) => DashboardWidgets.buildMobileMainCard(balance: s['balance'] ?? 0, name: user?.email?.split('@')[0] ?? 'Tizim'),
            loading: () => const LinearProgressIndicator(),
            error: (_, __) => const SizedBox(),
          ),
          
          const SizedBox(height: 24),
          _buildTopFiltersMobile(ref, isAdmin),
          
          const SizedBox(height: 24),
          const Text("Analitika", style: TextStyle(fontWeight: FontWeight.bold, fontSize: 16)),
          const SizedBox(height: 16),
          
          // Ikki ustunli qisqa ma'lumot
          stats.when(
            data: (s) => Row(
              children: [
                Expanded(child: DashboardWidgets.buildMobileStatItem("Kirim", s['income'] ?? 0, Colors.green)),
                const SizedBox(width: 16),
                Expanded(child: DashboardWidgets.buildMobileStatItem("Chiqim", s['expense'] ?? 0, Colors.red)),
              ]
            ),
            loading: () => const SizedBox(),
            error: (_, __) => const SizedBox(),
          ),
          
          const SizedBox(height: 32),
          // History (Oxirgi amallar)
          const Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Text("Tarix", style: TextStyle(fontWeight: FontWeight.bold, fontSize: 16)),
              Text("Barchasi", style: TextStyle(color: Colors.grey, fontSize: 12)),
            ],
          ),
          const SizedBox(height: 16),
          _buildRecentTxListMobile(ref),
        ],
      )
    );
  }

  // Yordamchi vidjetlar...
  Widget _buildTopFilters(WidgetRef ref, bool isAdmin) {
      final period = ref.watch(selectedPeriodProvider);
      return Row(children: ['Kun', 'Hafta', 'Oy', 'Yil'].map((p) => Padding(
        padding: const EdgeInsets.only(left: 8),
        child: ChoiceChip(
           label: Text(p), 
           selected: period == p, 
           onSelected: (_) => ref.read(selectedPeriodProvider.notifier).state = p,
           selectedColor: const Color(0xFFEFF6FF),
           labelStyle: TextStyle(color: period == p ? const Color(0xFF3B82F6) : Colors.grey),
           shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(8)),
        ),
      )).toList());
  }

  Widget _buildTopFiltersMobile(WidgetRef ref, bool isAdmin) {
      final period = ref.watch(selectedPeriodProvider);
      return SingleChildScrollView(
        scrollDirection: Axis.horizontal,
        child: Row(children: ['Kun', 'Hafta', 'Oy', 'Yil'].map((p) => Padding(
          padding: const EdgeInsets.only(right: 8),
          child: ChoiceChip(
             label: Text(p), 
             selected: period == p, 
             onSelected: (_) => ref.read(selectedPeriodProvider.notifier).state = p,
             selectedColor: const Color(0xFF147A6B),
             labelStyle: TextStyle(color: period == p ? Colors.white : Colors.grey),
          ),
        )).toList()),
      );
  }

  Widget _buildLegendItem(String title, String percent, Color color) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Row(
          children: [
            CircleAvatar(radius: 4, backgroundColor: color),
            const SizedBox(width: 8),
            Text(title, style: const TextStyle(color: Colors.grey, fontSize: 14)),
          ],
        ),
        Text(percent, style: const TextStyle(fontWeight: FontWeight.bold)),
      ],
    );
  }

  Widget _buildRecentTxList(WidgetRef ref) {
    final recent = ref.watch(recentTransactionsProvider);
    return recent.when(
      data: (list) {
        if(list.isEmpty) return const Text("Amallar mavjud emas");
        return ListView.separated(
          shrinkWrap: true,
          physics: const NeverScrollableScrollPhysics(),
          itemCount: list.length > 5 ? 5 : list.length,
          separatorBuilder: (_, __) => const SizedBox(height: 16),
          itemBuilder: (context, index) {
             final tx = list[index];
             final isIncome = tx['type'] == 'income';
             return Row(
               mainAxisAlignment: MainAxisAlignment.spaceBetween,
               children: [
                 Row(
                   children: [
                     Container(
                       padding: const EdgeInsets.all(8),
                       decoration: BoxDecoration(color: (isIncome ? Colors.green : Colors.red).withOpacity(0.1), borderRadius: BorderRadius.circular(8)),
                       child: Icon(isIncome ? Icons.arrow_downward : Icons.arrow_upward, color: isIncome ? Colors.green : Colors.red, size: 20),
                     ),
                     const SizedBox(width: 12),
                     Column(
                       crossAxisAlignment: CrossAxisAlignment.start,
                       children: [
                         Text(tx['category'] ?? 'Boshqa', style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 14)),
                         Text((tx['created_at'].toString().split('T')[0]), style: const TextStyle(color: Colors.grey, fontSize: 12)),
                       ],
                     ),
                   ],
                 ),
                 Text("${isIncome ? '+' : '-'}${tx['amount']} UZS", style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 14)),
               ],
             );
          },
        );
      },
      loading: () => const Center(child: CircularProgressIndicator()),
      error: (_, __) => const SizedBox(),
    );
  }

  Widget _buildRecentTxListMobile(WidgetRef ref) {
    final recent = ref.watch(recentTransactionsProvider);
    return recent.when(
      data: (list) {
        if(list.isEmpty) return const Center(child: Text("Hozircha amallar yo'q"));
        return ListView.builder(
          shrinkWrap: true,
          physics: const NeverScrollableScrollPhysics(),
          itemCount: list.length,
          itemBuilder: (context, index) {
             final tx = list[index];
             final isIncome = tx['type'] == 'income';
             return ListTile(
               contentPadding: EdgeInsets.zero,
               leading: CircleAvatar(
                 backgroundColor: (isIncome ? Colors.green : Colors.red).withOpacity(0.1),
                 child: Icon(isIncome ? Icons.add : Icons.remove, color: isIncome ? Colors.green : Colors.red),
               ),
               title: Text(tx['category'] ?? 'Boshqa', style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 14)),
               subtitle: Text((tx['created_at'].toString().split('T')[0]), style: const TextStyle(color: Colors.grey, fontSize: 12)),
               trailing: Text("${isIncome ? '+' : '-'}${DashboardWidgets.formatCurrency(tx['amount'])} UZS", style: TextStyle(fontWeight: FontWeight.bold, fontSize: 14, color: isIncome ? Colors.green : Colors.black87)),
             );
          },
        );
      },
      loading: () => const Center(child: CircularProgressIndicator()),
      error: (_, __) => const SizedBox(),
    );
  }
}
