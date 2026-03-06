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
    final bool isWeb = width > 800;
    final profile = ref.watch(userProfileProvider);
    final theme = ref.watch(themeProvider);

    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white,
        elevation: 0.5,
        title: profile.when(
          data: (p) => Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(p['full_name'] ?? 'Foydalanuvchi', style: const TextStyle(color: Colors.black, fontSize: 14, fontWeight: FontWeight.bold)),
              Text(Supabase.instance.client.auth.currentUser?.appMetadata['is_admin'] == true ? "Administrator" : "Xodim", style: const TextStyle(color: Colors.teal, fontSize: 10)),
            ],
          ),
          loading: () => const Text("Yuklanmoqda..."),
          error: (_, __) => const Text("CABIX"),
        ),
        actions: [
          _buildNotificationBell(ref, context), // TO'G'RI CHAQUV
          IconButton(
            icon: Icon(theme == AppThemeMode.glass ? Icons.dark_mode : Icons.light_mode),
            onPressed: () => ref.read(themeProvider.notifier).setTheme(theme == AppThemeMode.glass ? AppThemeMode.standard : AppThemeMode.glass),
          ),
          IconButton(icon: const Icon(Icons.logout, color: Colors.red), onPressed: () => Supabase.instance.client.auth.signOut()),
          const SizedBox(width: 8),
        ],
      ),
      body: Row(
        children: [
          if (isWeb) _buildWebMenu(context, ref, width),
          Expanded(child: navigationShell),
        ],
      ),
      floatingActionButtonLocation: isWeb ? null : FloatingActionButtonLocation.centerDocked,
      floatingActionButton: isWeb ? null : FloatingActionButton(
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(30)),
        onPressed: () => context.push('/add-transaction'),
        backgroundColor: const Color(0xFF2EAF9B),
        elevation: 4,
        child: const Icon(Icons.add_card, color: Colors.white, size: 28),
      ),
      bottomNavigationBar: isWeb ? null : BottomAppBar(
        shape: const CircularNotchedRectangle(),
        notchMargin: 8.0,
        color: theme == AppThemeMode.glass ? const Color(0xFF1E1E2C).withOpacity(0.9) : Colors.white,
        elevation: 8,
        child: SizedBox(
          height: 60,
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            children: [
              _buildNavItem(context, icon: Icons.grid_view, label: 'Bosh', index: 0, currentIndex: navigationShell.currentIndex, theme: theme),
              _buildNavItem(context, icon: Icons.payments, label: 'Ish haqi', index: 1, currentIndex: navigationShell.currentIndex, theme: theme),
              const SizedBox(width: 48), // FAB uchun o'rtada bo'shliq
              _buildNavItem(context, icon: Icons.bar_chart, label: 'Hisobot', index: 2, currentIndex: navigationShell.currentIndex, theme: theme),
              _buildNavItem(context, icon: Icons.settings, label: 'Sozlamalar', index: 3, currentIndex: navigationShell.currentIndex, theme: theme),
            ],
          ),
        ),
      ),
    );
  }

  Widget _buildNavItem(BuildContext context, {required IconData icon, required String label, required int index, required int currentIndex, required AppThemeMode theme}) {
    final isSelected = index == currentIndex;
    final color = isSelected ? const Color(0xFF2EAF9B) : Colors.grey;
    return GestureDetector(
      behavior: HitTestBehavior.opaque,
      onTap: () => navigationShell.goBranch(index),
      child: Column(
        mainAxisSize: MainAxisSize.min,
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Icon(icon, color: color, size: isSelected ? 28 : 24),
          Text(label, style: TextStyle(color: color, fontSize: 10, fontWeight: isSelected ? FontWeight.bold : FontWeight.normal)),
        ],
      ),
    );
  }

  Widget _buildWebMenu(BuildContext context, WidgetRef ref, double width) {
    return NavigationRail(
      extended: width > 1200,
      selectedIndex: navigationShell.currentIndex,
      onDestinationSelected: (i) => navigationShell.goBranch(i),
      leading: FloatingActionButton(
        mini: true, onPressed: () => context.push('/add-transaction'),
        backgroundColor: const Color(0xFF2EAF9B), child: const Icon(Icons.add, color: Colors.white),
      ),
      destinations: const [
        NavigationRailDestination(icon: Icon(Icons.grid_view), label: Text('Dashboard')),
        NavigationRailDestination(icon: Icon(Icons.payments), label: Text('Ish haqi')),
        NavigationRailDestination(icon: Icon(Icons.bar_chart), label: Text('Hisobot')),
        NavigationRailDestination(icon: Icon(Icons.settings), label: Text('Sozlamalar')),
      ],
    );
  }

  Widget _buildNotificationBell(WidgetRef ref, BuildContext context) {
    final pending = ref.watch(pendingSalariesProvider);
    return IconButton(
      icon: Stack(children: [
        const Icon(Icons.notifications_none, color: Colors.black),
        pending.maybeWhen(
          data: (items) => items.isNotEmpty ? Positioned(right: 0, child: Container(padding: const EdgeInsets.all(2), decoration: const BoxDecoration(color: Colors.red, shape: BoxShape.circle), child: Text('${items.length}', style: const TextStyle(fontSize: 8, color: Colors.white)))) : const SizedBox(),
          orElse: () => const SizedBox(),
        ),
      ]),
      onPressed: () => context.push('/notifications'),
    );
  }
}
