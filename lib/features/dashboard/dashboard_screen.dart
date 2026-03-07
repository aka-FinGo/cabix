import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'package:go_router/go_router.dart';
import '../../core/theme/theme_provider.dart';
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
      backgroundColor: theme == AppThemeMode.glass
          ? Colors.transparent
          : (theme == AppThemeMode.dark
              ? const Color(0xFF1E1E2C)
              : const Color(0xFFF1F5F9)),
      body: RefreshIndicator(
        onRefresh: () async {
          ref.invalidate(statsProvider);
          ref.invalidate(barChartDataProvider);
          ref.invalidate(recentTransactionsProvider);
        },
        child: isWeb
            ? _buildWebLayout(context, ref)
            : _buildMobileLayout(context, ref),
      ),
    );
  }

  // ==========================================
  // WEB LAYOUT (StoreShop uslubi)
  // ==========================================
  Widget _buildWebLayout(BuildContext context, WidgetRef ref) {
    final stats = ref.watch(statsProvider);
    final catStats = ref.watch(categoryStatsProvider);
    final theme = ref.watch(themeProvider);
    final isGlass = theme == AppThemeMode.glass;
    final isDark = theme == AppThemeMode.dark || isGlass;

    return SingleChildScrollView(
      padding: const EdgeInsets.all(40),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          // Header
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text("Dashboard",
                      style: TextStyle(
                          fontSize: 32,
                          fontWeight: FontWeight.bold,
                          color:
                              isDark ? Colors.white : const Color(0xFF0F172A))),
                  const SizedBox(height: 4),
                  Text("Analitik ma'lumotlaringiz shu yerda",
                      style: TextStyle(
                          color: isDark ? Colors.white60 : Colors.grey,
                          fontSize: 14)),
                ],
              ),
              Row(
                children: [
                  _buildEmployeeFilter(ref, isDark),
                  const SizedBox(width: 20),
                  _buildTopFilters(ref),
                ],
              ),
            ],
          ),
          const SizedBox(height: 40),

          // Cards & Main Chart Row
          Row(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              // Left side - 4 Small Stats
              Expanded(
                flex: 1,
                child: stats.when(
                  data: (s) => GridView.count(
                    shrinkWrap: true,
                    physics: const NeverScrollableScrollPhysics(),
                    crossAxisCount: 2,
                    mainAxisSpacing: 20,
                    crossAxisSpacing: 20,
                    childAspectRatio: 1.1,
                    children: [
                      DashboardWidgets.buildStatCard(
                        context: context,
                        title: "Jami balans",
                        amount: DashboardWidgets.formatCurrency(
                            s['total_balance'] ?? 0),
                        icon: Icons.account_balance_wallet_outlined,
                        color: const Color(0xFF6366F1),
                        trend: "Balans",
                        isPositive: true,
                        isGlass: isGlass,
                        onTap: () => context.go('/reports'),
                      ),
                      DashboardWidgets.buildStatCard(
                        context: context,
                        title: "Oylik Chiqimlar",
                        amount: DashboardWidgets.formatCurrency(
                            s['period_expense'] ?? 0),
                        icon: Icons.trending_down,
                        color: const Color(0xFFEC4899),
                        trend: "Chiqim",
                        isPositive: false,
                        isGlass: isGlass,
                        onTap: () => context.go('/reports'),
                      ),
                      DashboardWidgets.buildStatCard(
                        context: context,
                        title: "Oylik Kirimlar",
                        amount: DashboardWidgets.formatCurrency(
                            s['period_income'] ?? 0),
                        icon: Icons.trending_up,
                        color: const Color(0xFF2EAF9B),
                        trend: "Kirim",
                        isPositive: true,
                        isGlass: isGlass,
                        onTap: () => context.go('/reports'),
                      ),
                      DashboardWidgets.buildStatCard(
                        context: context,
                        title: "Tasdiqlanishi kutilayotgan",
                        amount: DashboardWidgets.formatCurrency(
                            s['pending_sum'] ?? 0),
                        icon: Icons.hourglass_empty,
                        color: const Color(0xFFF59E0B),
                        trend: "Kutilmoqda",
                        isPositive: true,
                        isGlass: isGlass,
                        onTap: () => context.push('/notifications'),
                      ),
                    ],
                  ),
                  loading: () =>
                      const Center(child: CircularProgressIndicator()),
                  error: (e, _) => Text('Xatolik: $e'),
                ),
              ),
              const SizedBox(width: 24),
              // Right side - Main Revenue Chart
              Expanded(
                flex: 1,
                child: Container(
                  height: 380,
                  padding: const EdgeInsets.all(24),
                  decoration: BoxDecoration(
                    color: isGlass
                        ? Colors.white.withOpacity(0.05)
                        : (isDark ? const Color(0xFF1C1C21) : Colors.white),
                    borderRadius: BorderRadius.circular(24),
                    border: isGlass
                        ? Border.all(color: Colors.white.withOpacity(0.1))
                        : null,
                  ),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: [
                          const Text("Kirim va Chiqim",
                              style: TextStyle(
                                  fontSize: 18, fontWeight: FontWeight.bold)),
                          Container(
                            padding: const EdgeInsets.symmetric(
                                horizontal: 12, vertical: 6),
                            decoration: BoxDecoration(
                                color: Colors.grey.withOpacity(0.1),
                                borderRadius: BorderRadius.circular(8)),
                            child: const Text("Tahlil",
                                style: TextStyle(fontSize: 12)),
                          )
                        ],
                      ),
                      const SizedBox(height: 30),
                      Expanded(
                        child: ref.watch(barChartDataProvider).when(
                              data: (data) =>
                                  DashboardWidgets.buildMainChart(data, isDark),
                              loading: () => const Center(
                                  child: CircularProgressIndicator()),
                              error: (e, __) =>
                                  Center(child: Text('Grafik xatosi: $e')),
                            ),
                      ),
                      const SizedBox(height: 10),
                      Row(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          _buildChartLegend("Kirim", const Color(0xFF2EAF9B)),
                          const SizedBox(width: 20),
                          _buildChartLegend("Chiqim", const Color(0xFFEC4899)),
                        ],
                      ),
                    ],
                  ),
                ),
              ),
            ],
          ),
          const SizedBox(height: 32),

          // Bottom Section - Recent Activity & Traffic
          Row(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              // Recent Activity Table
              Expanded(
                flex: 2,
                child: Container(
                  padding: const EdgeInsets.all(24),
                  decoration: BoxDecoration(
                    color: isGlass
                        ? Colors.white.withOpacity(0.05)
                        : (isDark ? const Color(0xFF1C1C21) : Colors.white),
                    borderRadius: BorderRadius.circular(24),
                  ),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: [
                          const Text("Oxirgi Harakatlar",
                              style: TextStyle(
                                  fontSize: 18, fontWeight: FontWeight.bold)),
                          _buildSectionFilter(
                              ref, selectedRecentPeriodProvider),
                        ],
                      ),
                      const SizedBox(height: 20),
                      SizedBox(
                        height: 400,
                        child: SingleChildScrollView(
                          child: _buildRecentTxList(context, ref, isDark),
                        ),
                      ),
                    ],
                  ),
                ),
              ),
              const SizedBox(width: 24),
              // Traffic Channel (Pie)
              Expanded(
                flex: 1,
                child: Container(
                  height: 400,
                  padding: const EdgeInsets.all(24),
                  decoration: BoxDecoration(
                    color: isGlass
                        ? Colors.white.withOpacity(0.05)
                        : (isDark ? const Color(0xFF1C1C21) : Colors.white),
                    borderRadius: BorderRadius.circular(24),
                  ),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      const Text("Xarajat Tarkibi",
                          style: TextStyle(
                              fontSize: 18, fontWeight: FontWeight.bold)),
                      const Spacer(),
                      SizedBox(
                        height: 200,
                        child: catStats.when(
                          data: (data) =>
                              DashboardWidgets.buildDonutChart(data, isDark),
                          loading: () =>
                              const Center(child: CircularProgressIndicator()),
                          error: (_, __) => const SizedBox(),
                        ),
                      ),
                      const Spacer(),
                      catStats.when(
                        data: (stats) {
                          if (stats.isEmpty) return const SizedBox();
                          final total =
                              stats.values.fold(0.0, (sum, val) => sum + val);
                          final colors = [
                            const Color(0xFF6366F1),
                            const Color(0xFF2EAF9B),
                            const Color(0xFFF59E0B),
                            const Color(0xFFEC4899),
                            const Color(0xFF8B5CF6),
                          ];
                          int idx = 0;
                          return Column(
                            children: stats.entries.map((entry) {
                              final color = colors[idx % colors.length];
                              final percent = total > 0
                                  ? (entry.value / total * 100)
                                      .toStringAsFixed(1)
                                  : "0.0";
                              idx++;
                              return Padding(
                                padding: const EdgeInsets.only(bottom: 12),
                                child: _buildLegendItem(
                                    entry.key, "$percent%", color, isDark),
                              );
                            }).toList(),
                          );
                        },
                        loading: () => const SizedBox(),
                        error: (_, __) => const SizedBox(),
                      ),
                    ],
                  ),
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }

  // ==========================================
  // MOBILE LAYOUT (Refined Kezabank style)
  // ==========================================
  Widget _buildMobileLayout(BuildContext context, WidgetRef ref) {
    final stats = ref.watch(statsProvider);
    final theme = ref.watch(themeProvider);
    final isGlass = theme == AppThemeMode.glass;
    final isDark = theme == AppThemeMode.dark || isGlass;
    final user = Supabase.instance.client.auth.currentUser;

    return SingleChildScrollView(
      padding: const EdgeInsets.all(20),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const SizedBox(height: 30),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text("Mening Dashboardim",
                      style: TextStyle(
                          fontSize: 22,
                          fontWeight: FontWeight.bold,
                          color: isDark ? Colors.white : Colors.black)),
                  Text("Xush kelibsiz!",
                      style: TextStyle(
                          color: isDark ? Colors.white60 : Colors.grey,
                          fontSize: 13)),
                ],
              ),
              _buildEmployeeFilter(ref, isDark, isMobile: true),
            ],
          ),
          const SizedBox(height: 32),

          // Card
          stats.when(
            data: (s) => DashboardWidgets.buildMobileMainCard(
              balance: s['total_balance'] ?? 0,
              name: user?.email?.split('@')[0] ?? 'Foydalanuvchi',
              isGlass: isGlass,
            ),
            loading: () => Container(
                height: 200,
                alignment: Alignment.center,
                child: const CircularProgressIndicator()),
            error: (_, __) => const SizedBox(),
          ),

          const SizedBox(height: 32),
          Text("Statistika",
              style: TextStyle(
                  fontSize: 18,
                  fontWeight: FontWeight.bold,
                  color: isDark ? Colors.white : Colors.black)),
          const SizedBox(height: 16),
          stats.when(
            data: (s) => Column(
              children: [
                Row(
                  children: [
                    Expanded(
                        child: DashboardWidgets.buildMobileStatItem(
                            "Oylik Kirim",
                            s['period_income'] ?? 0,
                            const Color(0xFF2EAF9B),
                            isDark)),
                    const SizedBox(width: 16),
                    Expanded(
                        child: DashboardWidgets.buildMobileStatItem(
                            "Oylik Chiqim",
                            s['period_expense'] ?? 0,
                            const Color(0xFFEC4899),
                            isDark)),
                  ],
                ),
                const SizedBox(height: 16),
                DashboardWidgets.buildMobileStatItem(
                    "Tasdiqlanishi kutilayotgan",
                    s['pending_sum'] ?? 0,
                    const Color(0xFFF59E0B),
                    isDark),
              ],
            ),
            loading: () => const SizedBox(),
            error: (_, __) => const SizedBox(),
          ),

          const SizedBox(height: 32),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Text("Amallar Tarixi",
                  style: TextStyle(
                      fontSize: 18,
                      fontWeight: FontWeight.bold,
                      color: isDark ? Colors.white : Colors.black)),
              Text("Hammasi",
                  style: TextStyle(
                      color: isDark ? Colors.white60 : Colors.grey,
                      fontSize: 12)),
            ],
          ),
          const SizedBox(height: 16),
          _buildRecentTxListMobile(ref, isDark),
        ],
      ),
    );
  }

  // Yordamchi vidjetlar...

  Widget _buildSectionFilter(WidgetRef ref, StateProvider<String> provider) {
    final period = ref.watch(provider);
    return Container(
      padding: const EdgeInsets.all(2),
      decoration: BoxDecoration(
          color: Colors.grey.withOpacity(0.05),
          borderRadius: BorderRadius.circular(8)),
      child: Row(
        children: ['Kun', 'Hafta', 'Oy', 'Yil']
            .map((p) => GestureDetector(
                  onTap: () => ref.read(provider.notifier).state = p,
                  child: Container(
                    padding:
                        const EdgeInsets.symmetric(horizontal: 10, vertical: 4),
                    decoration: BoxDecoration(
                      color: period == p ? Colors.white : Colors.transparent,
                      borderRadius: BorderRadius.circular(6),
                      boxShadow: period == p
                          ? [
                              const BoxShadow(
                                  color: Colors.black12, blurRadius: 2)
                            ]
                          : [],
                    ),
                    child: Text(p,
                        style: TextStyle(
                            color: period == p ? Colors.black : Colors.grey,
                            fontWeight: period == p
                                ? FontWeight.bold
                                : FontWeight.normal,
                            fontSize: 11)),
                  ),
                ))
            .toList(),
      ),
    );
  }

  Widget _buildTopFilters(WidgetRef ref) {
    final period = ref.watch(selectedPeriodProvider);
    return Container(
      padding: const EdgeInsets.all(4),
      decoration: BoxDecoration(
          color: Colors.grey.withOpacity(0.1),
          borderRadius: BorderRadius.circular(12)),
      child: Row(
        children: ['Kun', 'Hafta', 'Oy', 'Yil']
            .map((p) => GestureDetector(
                  onTap: () =>
                      ref.read(selectedPeriodProvider.notifier).state = p,
                  child: Container(
                    padding:
                        const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
                    decoration: BoxDecoration(
                      color: period == p ? Colors.white : Colors.transparent,
                      borderRadius: BorderRadius.circular(10),
                      boxShadow: period == p
                          ? [
                              const BoxShadow(
                                  color: Colors.black12, blurRadius: 4)
                            ]
                          : [],
                    ),
                    child: Text(p,
                        style: TextStyle(
                            color: period == p ? Colors.black : Colors.grey,
                            fontWeight: period == p
                                ? FontWeight.bold
                                : FontWeight.normal,
                            fontSize: 13)),
                  ),
                ))
            .toList(),
      ),
    );
  }

  Widget _buildEmployeeFilter(WidgetRef ref, bool isDark,
      {bool isMobile = false}) {
    final user = Supabase.instance.client.auth.currentUser;
    final isAdmin = user?.appMetadata['is_admin'] == true;
    if (!isAdmin) {
      if (isMobile) {
        return CircleAvatar(
          radius: 22,
          backgroundColor: isDark ? Colors.white10 : Colors.grey.shade100,
          child: const Icon(Icons.person_outline, color: Color(0xFF6366F1)),
        );
      }
      return const SizedBox();
    }

    final employees = ref.watch(employeesProvider);
    final selectedEmp = ref.watch(selectedEmployeeFilterProvider);

    return employees.when(
      data: (list) => Container(
        padding: const EdgeInsets.symmetric(horizontal: 12),
        decoration: BoxDecoration(
          color: isDark ? Colors.white.withOpacity(0.05) : Colors.grey.shade100,
          borderRadius: BorderRadius.circular(12),
        ),
        child: DropdownButtonHideUnderline(
          child: DropdownButton<String?>(
            value: selectedEmp,
            hint: Text("Xodim",
                style: TextStyle(
                    fontSize: 12,
                    color: isDark ? Colors.white70 : Colors.black87)),
            icon: const Icon(Icons.arrow_drop_down, size: 20),
            dropdownColor: isDark ? const Color(0xFF1C1C21) : Colors.white,
            items: [
              DropdownMenuItem(
                  value: null,
                  child: Text("Hammasi",
                      style: TextStyle(
                          fontSize: 13,
                          color: isDark ? Colors.white : Colors.black))),
              ...list.map((e) => DropdownMenuItem(
                    value: e['id'],
                    child: Text(e['full_name'] ?? 'Nomisiz',
                        style: TextStyle(
                            fontSize: 13,
                            color: isDark ? Colors.white : Colors.black)),
                  )),
            ],
            onChanged: (val) =>
                ref.read(selectedEmployeeFilterProvider.notifier).state = val,
          ),
        ),
      ),
      loading: () => const SizedBox(),
      error: (_, __) => const SizedBox(),
    );
  }

  Widget _buildChartLegend(String label, Color color) {
    return Row(
      children: [
        Container(
            width: 10,
            height: 10,
            decoration: BoxDecoration(
                color: color, borderRadius: BorderRadius.circular(2))),
        const SizedBox(width: 6),
        Text(label, style: const TextStyle(fontSize: 11, color: Colors.grey)),
      ],
    );
  }

  Widget _buildLegendItem(
      String title, String percent, Color color, bool isDark) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: [
        Row(
          children: [
            Container(
                width: 8,
                height: 8,
                decoration:
                    BoxDecoration(color: color, shape: BoxShape.circle)),
            const SizedBox(width: 10),
            Text(title,
                style: TextStyle(
                    color: isDark ? Colors.white60 : Colors.grey,
                    fontSize: 14)),
          ],
        ),
        Text(percent,
            style: TextStyle(
                fontWeight: FontWeight.bold,
                color: isDark ? Colors.white : Colors.black)),
      ],
    );
  }

  Widget _buildRecentTxList(BuildContext context, WidgetRef ref, bool isDark) {
    final recent = ref.watch(recentTransactionsProvider);
    return recent.when(
      data: (list) {
        if (list.isEmpty) return const Text("Amallar mavjud emas");
        return Column(
          children: [
            // Header
            Padding(
              padding: const EdgeInsets.symmetric(vertical: 8, horizontal: 12),
              child: Row(
                children: [
                  const SizedBox(
                      width: 56,
                      child: Text("Status",
                          style: TextStyle(
                              color: Colors.grey,
                              fontSize: 12,
                              fontWeight: FontWeight.bold))),
                  Expanded(
                      flex: 3,
                      child: Text("Kategoriya / Izoh",
                          style: TextStyle(
                              color: Colors.grey,
                              fontSize: 12,
                              fontWeight: FontWeight.bold))),
                  Expanded(
                      flex: 2,
                      child: Text("Sana",
                          style: TextStyle(
                              color: Colors.grey,
                              fontSize: 12,
                              fontWeight: FontWeight.bold))),
                  const SizedBox(
                      width: 120,
                      child: Text("Summa",
                          textAlign: TextAlign.right,
                          style: TextStyle(
                              color: Colors.grey,
                              fontSize: 12,
                              fontWeight: FontWeight.bold))),
                ],
              ),
            ),
            const Divider(height: 1),
            ...list.take(8).map((tx) {
              final isIncome = tx['type'] == 'income';
              return InkWell(
                onTap: () => _showTransactionDetails(context, tx, isDark),
                borderRadius: BorderRadius.circular(12),
                child: Container(
                  padding:
                      const EdgeInsets.symmetric(vertical: 14, horizontal: 12),
                  decoration: BoxDecoration(
                    border: Border(
                        bottom:
                            BorderSide(color: Colors.grey.withOpacity(0.05))),
                  ),
                  child: Row(
                    children: [
                      CircleAvatar(
                        radius: 18,
                        backgroundColor: (isIncome ? Colors.green : Colors.red)
                            .withOpacity(0.1),
                        child: Icon(
                            isIncome
                                ? Icons.arrow_downward
                                : Icons.arrow_upward,
                            color: isIncome ? Colors.green : Colors.red,
                            size: 16),
                      ),
                      const SizedBox(width: 20),
                      Expanded(
                        flex: 3,
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text(tx['category'] ?? 'Boshqa',
                                style: const TextStyle(
                                    fontWeight: FontWeight.bold, fontSize: 14)),
                            Text("${tx['comment'] ?? ''}",
                                style: const TextStyle(
                                    color: Colors.grey, fontSize: 12),
                                overflow: TextOverflow.ellipsis),
                          ],
                        ),
                      ),
                      Expanded(
                        flex: 2,
                        child: Text(
                            "${tx['created_at'].toString().split('T')[0]}",
                            style: const TextStyle(
                                color: Colors.grey, fontSize: 13)),
                      ),
                      SizedBox(
                        width: 120,
                        child: Text(
                          "${isIncome ? '+' : '-'}${DashboardWidgets.formatCurrency(tx['amount'])}",
                          textAlign: TextAlign.right,
                          style: TextStyle(
                              fontWeight: FontWeight.bold,
                              fontSize: 14,
                              color: isIncome ? Colors.green : Colors.red),
                        ),
                      ),
                    ],
                  ),
                ),
              );
            }).toList(),
            const SizedBox(height: 20),
            Center(
              child: TextButton.icon(
                onPressed: () => context.go('/reports'),
                icon: const Icon(Icons.list_alt, size: 18),
                label: const Text("Barchasini ko'rish"),
                style: TextButton.styleFrom(
                  foregroundColor: const Color(0xFF6366F1),
                  padding:
                      const EdgeInsets.symmetric(horizontal: 24, vertical: 12),
                  shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10)),
                ),
              ),
            ),
          ],
        );
      },
      loading: () => const Center(child: CircularProgressIndicator()),
      error: (e, __) => Text('Xatolik: $e'),
    );
  }

  Widget _buildRecentTxListMobile(WidgetRef ref, bool isDark) {
    final recent = ref.watch(recentTransactionsProvider);
    return recent.when(
      data: (list) {
        if (list.isEmpty)
          return const Center(child: Text("Hozircha amallar yo'q"));
        return ListView.builder(
          shrinkWrap: true,
          physics: const NeverScrollableScrollPhysics(),
          itemCount: list.length,
          itemBuilder: (context, index) {
            final tx = list[index];
            final isIncome = tx['type'] == 'income';
            return InkWell(
              onTap: () => _showTransactionDetails(context, tx, isDark),
              child: Container(
                margin: const EdgeInsets.only(bottom: 12),
                padding: const EdgeInsets.all(12),
                decoration: BoxDecoration(
                  color: isDark ? const Color(0xFF1C1C21) : Colors.white,
                  borderRadius: BorderRadius.circular(16),
                ),
                child: Row(
                  children: [
                    CircleAvatar(
                      backgroundColor: (isIncome ? Colors.green : Colors.red)
                          .withOpacity(0.1),
                      child: Icon(isIncome ? Icons.add : Icons.remove,
                          color: isIncome ? Colors.green : Colors.red),
                    ),
                    const SizedBox(width: 12),
                    Expanded(
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(tx['category'] ?? 'Boshqa',
                              style: const TextStyle(
                                  fontWeight: FontWeight.bold, fontSize: 14)),
                          Text((tx['created_at'].toString().split('T')[0]),
                              style: const TextStyle(
                                  color: Colors.grey, fontSize: 11)),
                        ],
                      ),
                    ),
                    Text(
                      "${isIncome ? '+' : '-'}${DashboardWidgets.formatCurrency(tx['amount'])} UZS",
                      style: TextStyle(
                          fontWeight: FontWeight.bold,
                          fontSize: 14,
                          color: isIncome
                              ? Colors.green
                              : (isDark ? Colors.white : Colors.black87)),
                    ),
                  ],
                ),
              ),
            );
          },
        );
      },
      loading: () => const Center(child: CircularProgressIndicator()),
      error: (_, __) => const SizedBox(),
    );
  }

  void _showTransactionDetails(
      BuildContext context, Map<String, dynamic> tx, bool isDark) {
    showModalBottomSheet(
      context: context,
      backgroundColor: isDark ? const Color(0xFF1C1C21) : Colors.white,
      shape: const RoundedRectangleBorder(
          borderRadius: BorderRadius.vertical(top: Radius.circular(24))),
      builder: (context) {
        final isIncome = tx['type'] == 'income';
        return Padding(
          padding: const EdgeInsets.all(24),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text(tx['category'] ?? 'Boshqa',
                      style: const TextStyle(
                          fontSize: 20, fontWeight: FontWeight.bold)),
                  IconButton(
                      onPressed: () => Navigator.pop(context),
                      icon: const Icon(Icons.close)),
                ],
              ),
              const Divider(),
              const SizedBox(height: 16),
              _buildDetailRow(
                  "Summa",
                  "${isIncome ? '+' : '-'}${DashboardWidgets.formatCurrency(tx['amount'])} UZS",
                  isIncome ? Colors.green : Colors.red),
              _buildDetailRow(
                  "Sana", tx['created_at'].toString().split('T')[0], null),
              _buildDetailRow("Izoh", tx['comment'] ?? "Izoh yo'q", null),
              const SizedBox(height: 32),
              Row(
                children: [
                  Expanded(
                    child: OutlinedButton.icon(
                      onPressed: () {},
                      icon: const Icon(Icons.edit_outlined),
                      label: const Text("Tahrirlash"),
                      style: OutlinedButton.styleFrom(
                        padding: const EdgeInsets.symmetric(vertical: 12),
                        shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(12)),
                      ),
                    ),
                  ),
                  const SizedBox(width: 16),
                  Expanded(
                    child: ElevatedButton.icon(
                      onPressed: () {},
                      icon: const Icon(Icons.delete_outline),
                      label: const Text("O'chirish"),
                      style: ElevatedButton.styleFrom(
                        backgroundColor: Colors.redAccent.withOpacity(0.1),
                        foregroundColor: Colors.redAccent,
                        elevation: 0,
                        padding: const EdgeInsets.symmetric(vertical: 12),
                        shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(12)),
                      ),
                    ),
                  ),
                ],
              ),
              const SizedBox(height: 16),
            ],
          ),
        );
      },
    );
  }

  Widget _buildDetailRow(String label, String value, Color? valueColor) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 8),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Text(label, style: const TextStyle(color: Colors.grey, fontSize: 14)),
          Text(value,
              style: TextStyle(
                  fontWeight: FontWeight.bold,
                  fontSize: 14,
                  color: valueColor)),
        ],
      ),
    );
  }
}
