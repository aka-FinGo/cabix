import 'dart:ui';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:go_router/go_router.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import '../../features/dashboard/dashboard_provider.dart';
import '../../core/theme/theme_provider.dart';

class MainWrapper extends ConsumerWidget {
  final StatefulNavigationShell navigationShell;
  const MainWrapper({super.key, required this.navigationShell});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final width = MediaQuery.of(context).size.width;
    final bool isWeb = width > 900;
    final theme = ref.watch(themeProvider);
    final isGlass = theme == AppThemeMode.glass;
    final isDark = theme == AppThemeMode.dark || isGlass;

    final scaffold = Scaffold(
      backgroundColor: isGlass
          ? Colors.transparent
          : (isDark ? const Color(0xFF0F0F12) : const Color(0xFFF8FAFC)),
      body: Row(
        children: [
          if (isWeb) _buildSidebar(context, ref, width, theme, isDark, isGlass),
          Expanded(
            child: Column(
              children: [
                _buildTopBar(context, ref, isDark, isGlass),
                Expanded(child: navigationShell),
              ],
            ),
          ),
        ],
      ),
      floatingActionButtonLocation:
          isWeb ? null : FloatingActionButtonLocation.centerDocked,
      floatingActionButton: isWeb
          ? null
          : FloatingActionButton(
              shape: const CircleBorder(),
              onPressed: () => context.push('/add-transaction'),
              backgroundColor: const Color(0xFF6366F1),
              elevation: 4,
              child: const Icon(Icons.add, color: Colors.white, size: 28),
            ),
      bottomNavigationBar: isWeb
          ? null
          : _buildMobileBottomBar(context, ref, theme, isDark, isGlass),
    );

    if (isGlass) {
      return Container(
        decoration: const BoxDecoration(
          gradient: LinearGradient(
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
            colors: [Color(0xFF0F172A), Color(0xFF1E293B), Color(0xFF0F172A)],
          ),
        ),
        child: scaffold,
      );
    }

    return scaffold;
  }

  Widget _buildTopBar(
      BuildContext context, WidgetRef ref, bool isDark, bool isGlass) {
    final profile = ref.watch(userProfileProvider);
    final theme = ref.watch(themeProvider);

    return Container(
      height: 70,
      padding: const EdgeInsets.symmetric(horizontal: 24),
      decoration: BoxDecoration(
        color: isGlass
            ? Colors.white.withOpacity(0.02)
            : (isDark ? const Color(0xFF0F0F12) : Colors.white),
        border: Border(
            bottom: BorderSide(
                color: isDark
                    ? Colors.white.withOpacity(0.05)
                    : Colors.black.withOpacity(0.05))),
      ),
      child: Row(
        children: [
          if (MediaQuery.of(context).size.width <= 900)
            const Text("CABIX",
                style: TextStyle(
                    fontSize: 20,
                    fontWeight: FontWeight.bold,
                    color: Color(0xFF6366F1))),
          const Spacer(),
          // Search Mockup
          if (MediaQuery.of(context).size.width > 600)
            Container(
              width: 300,
              height: 40,
              padding: const EdgeInsets.symmetric(horizontal: 16),
              decoration: BoxDecoration(
                color: isDark
                    ? Colors.white.withOpacity(0.05)
                    : Colors.grey.shade100,
                borderRadius: BorderRadius.circular(10),
              ),
              child: Row(
                children: [
                  Icon(Icons.search,
                      size: 18, color: isDark ? Colors.white30 : Colors.grey),
                  const SizedBox(width: 10),
                  Text("Qidiruv...",
                      style: TextStyle(
                          color: isDark ? Colors.white30 : Colors.grey,
                          fontSize: 13)),
                ],
              ),
            ),
          const SizedBox(width: 24),
          _buildNotificationIcon(ref, context, isDark),
          const SizedBox(width: 16),
          IconButton(
            icon: Icon(
              theme == AppThemeMode.standard
                  ? Icons.wb_sunny_outlined
                  : theme == AppThemeMode.dark
                      ? Icons.nightlight_round
                      : Icons.blur_on,
              color: isDark ? Colors.white70 : Colors.black87,
            ),
            onPressed: () => ref.read(themeProvider.notifier).toggleTheme(),
          ),
          const SizedBox(width: 16),
          profile.when(
            data: (p) => Row(
              children: [
                Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.end,
                  children: [
                    Text(p['full_name'] ?? 'Foydalanuvchi',
                        style: TextStyle(
                            fontSize: 13,
                            fontWeight: FontWeight.bold,
                            color: isDark ? Colors.white : Colors.black87)),
                    Text(
                        Supabase.instance.client.auth.currentUser
                                    ?.appMetadata['is_admin'] ==
                                true
                            ? "Admin"
                            : "Xodim",
                        style:
                            const TextStyle(fontSize: 11, color: Colors.grey)),
                  ],
                ),
                const SizedBox(width: 12),
                CircleAvatar(
                  radius: 18,
                  backgroundColor: const Color(0xFF6366F1),
                  child: Text(p['full_name']?[0] ?? 'U',
                      style: const TextStyle(
                          color: Colors.white,
                          fontSize: 14,
                          fontWeight: FontWeight.bold)),
                ),
              ],
            ),
            loading: () => const SizedBox(),
            error: (_, __) => const SizedBox(),
          ),
        ],
      ),
    );
  }

  Widget _buildSidebar(BuildContext context, WidgetRef ref, double width,
      AppThemeMode theme, bool isDark, bool isGlass) {
    return Container(
      width: width > 1200 ? 260 : 80,
      decoration: BoxDecoration(
        color: isGlass
            ? Colors.black.withOpacity(0.2)
            : (isDark ? const Color(0xFF0F0F12) : Colors.white),
        border: Border(
            right: BorderSide(
                color: isDark
                    ? Colors.white.withOpacity(0.05)
                    : Colors.black.withOpacity(0.05))),
      ),
      child: Column(
        children: [
          const SizedBox(height: 30),
          // Logo
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              const Icon(Icons.auto_graph, color: Color(0xFF6366F1), size: 32),
              if (width > 1200) ...[
                const SizedBox(width: 12),
                const Text("CABIX",
                    style: TextStyle(
                        fontSize: 22,
                        fontWeight: FontWeight.bold,
                        letterSpacing: 1)),
              ],
            ],
          ),
          const SizedBox(height: 50),
          _buildSidebarItem(context,
              icon: Icons.grid_view_rounded,
              label: "Bosh",
              index: 0,
              expanded: width > 1200,
              isDark: isDark),
          _buildSidebarItem(context,
              icon: Icons.payments_outlined,
              label: "Ish haqi",
              index: 1,
              expanded: width > 1200,
              isDark: isDark),
          _buildSidebarItem(context,
              icon: Icons.analytics_outlined,
              label: "Hisobot",
              index: 2,
              expanded: width > 1200,
              isDark: isDark),
          _buildSidebarItem(context,
              icon: Icons.settings_outlined,
              label: "Sozlamalar",
              index: 3,
              expanded: width > 1200,
              isDark: isDark),
          const SizedBox(height: 20),
          // Web Add Action
          Padding(
            padding: const EdgeInsets.symmetric(horizontal: 16),
            child: ElevatedButton.icon(
              onPressed: () => context.push('/add-transaction'),
              icon: const Icon(Icons.add_circle_outline, size: 20),
              label:
                  width > 1200 ? const Text("Amal qo'shish") : const SizedBox(),
              style: ElevatedButton.styleFrom(
                backgroundColor: const Color(0xFF2EAF9B),
                foregroundColor: Colors.white,
                minimumSize: const Size(double.infinity, 48),
                shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(12)),
              ),
            ),
          ),
          const Spacer(),
          if (width > 1200)
            Container(
              margin: const EdgeInsets.all(20),
              padding: const EdgeInsets.all(16),
              decoration: BoxDecoration(
                  color: const Color(0xFF6366F1).withOpacity(0.1),
                  borderRadius: BorderRadius.circular(16)),
              child: Column(
                children: [
                  const Text("Premiumga o'ting",
                      style:
                          TextStyle(fontWeight: FontWeight.bold, fontSize: 14)),
                  const SizedBox(height: 4),
                  const Text("Barcha imkoniyatlar",
                      style: TextStyle(fontSize: 11, color: Colors.grey),
                      textAlign: TextAlign.center),
                  const SizedBox(height: 12),
                  SizedBox(
                    width: double.infinity,
                    child: ElevatedButton(
                      onPressed: () {},
                      style: ElevatedButton.styleFrom(
                          backgroundColor: const Color(0xFF6366F1),
                          foregroundColor: Colors.white,
                          elevation: 0,
                          shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(10))),
                      child: const Text("Yangilash",
                          style: TextStyle(fontSize: 12)),
                    ),
                  )
                ],
              ),
            ),
          ListTile(
            leading: const Icon(Icons.logout, color: Colors.redAccent),
            title: width > 1200
                ? const Text("Chiqish",
                    style: TextStyle(color: Colors.redAccent))
                : null,
            onTap: () => Supabase.instance.client.auth.signOut(),
          ),
          const SizedBox(height: 20),
        ],
      ),
    );
  }

  Widget _buildSidebarItem(BuildContext context,
      {required IconData icon,
      required String label,
      required int index,
      required bool expanded,
      required bool isDark}) {
    final isSelected = navigationShell.currentIndex == index;
    final color = isSelected
        ? const Color(0xFF6366F1)
        : (isDark ? Colors.white54 : Colors.grey);

    return InkWell(
      onTap: () => navigationShell.goBranch(index),
      child: Container(
        margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 4),
        padding: const EdgeInsets.symmetric(vertical: 12, horizontal: 12),
        decoration: BoxDecoration(
          color: isSelected
              ? const Color(0xFF6366F1).withOpacity(0.1)
              : Colors.transparent,
          borderRadius: BorderRadius.circular(12),
        ),
        child: Row(
          mainAxisAlignment:
              expanded ? MainAxisAlignment.start : MainAxisAlignment.center,
          children: [
            Icon(icon, color: color, size: 24),
            if (expanded) ...[
              const SizedBox(width: 16),
              Text(label,
                  style: TextStyle(
                      color: color,
                      fontWeight:
                          isSelected ? FontWeight.bold : FontWeight.normal,
                      fontSize: 14)),
            ],
          ],
        ),
      ),
    );
  }

  Widget _buildMobileBottomBar(BuildContext context, WidgetRef ref,
      AppThemeMode theme, bool isDark, bool isGlass) {
    return BottomAppBar(
      height: 80,
      padding: EdgeInsets.zero,
      notchMargin: 8,
      shape: const CircularNotchedRectangle(),
      color: isGlass
          ? Colors.black.withOpacity(0.8)
          : (isDark ? const Color(0xFF1C1C21) : Colors.white),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceAround,
        children: [
          _buildMobileNavItem(context,
              icon: Icons.grid_view_rounded,
              label: "Bosh",
              index: 0,
              isDark: isDark),
          _buildMobileNavItem(context,
              icon: Icons.payments_outlined,
              label: "Ish haqi",
              index: 1,
              isDark: isDark),
          const SizedBox(width: 48),
          _buildMobileNavItem(context,
              icon: Icons.analytics_outlined,
              label: "Hisobot",
              index: 2,
              isDark: isDark),
          _buildMobileNavItem(context,
              icon: Icons.settings_outlined,
              label: "Sozlamalar",
              index: 3,
              isDark: isDark),
        ],
      ),
    );
  }

  Widget _buildMobileNavItem(BuildContext context,
      {required IconData icon,
      required String label,
      required int index,
      required bool isDark}) {
    final isSelected = navigationShell.currentIndex == index;
    final color = isSelected
        ? const Color(0xFF2EAF9B)
        : (isDark ? Colors.white30 : Colors.grey);

    return InkWell(
      onTap: () => navigationShell.goBranch(index),
      child: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          Icon(icon, color: color, size: 24),
          const SizedBox(height: 4),
          Text(label,
              style: TextStyle(
                  color: color,
                  fontSize: 11,
                  fontWeight:
                      isSelected ? FontWeight.bold : FontWeight.normal)),
        ],
      ),
    );
  }

  Widget _buildNotificationIcon(
      WidgetRef ref, BuildContext context, bool isDark) {
    final pending = ref.watch(pendingSalariesProvider);
    return IconButton(
      icon: Stack(children: [
        Icon(Icons.notifications_outlined,
            color: isDark ? Colors.white70 : Colors.black87),
        pending.maybeWhen(
          data: (items) => items.isNotEmpty
              ? Positioned(
                  right: 0,
                  top: 0,
                  child: Container(
                      width: 10,
                      height: 10,
                      decoration: const BoxDecoration(
                          color: Colors.redAccent, shape: BoxShape.circle)))
              : const SizedBox(),
          orElse: () => const SizedBox(),
        ),
      ]),
      onPressed: () => context.push('/notifications'),
    );
  }
}
