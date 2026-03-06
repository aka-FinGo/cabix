import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:go_router/go_router.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import '../../features/dashboard/dashboard_provider.dart';
import '../../core/theme/theme_provider.dart';

class MainWrapper extends ConsumerStatefulWidget {
  final StatefulNavigationShell navigationShell;
  const MainWrapper({super.key, required this.navigationShell});

  @override
  ConsumerState<MainWrapper> createState() => _MainWrapperState();
}

class _MainWrapperState extends ConsumerState<MainWrapper> {
  @override
  Widget build(BuildContext context) {
    final double width = MediaQuery.of(context).size.width;
    final bool isWeb = width > 800;
    final theme = ref.watch(themeProvider);

    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white,
        foregroundColor: Colors.black,
        elevation: 0.5,
        title: const Text('CABIX', style: TextStyle(fontWeight: FontWeight.bold, letterSpacing: 1.5)),
        actions: [
          _buildNotificationBell(),
          IconButton(
            icon: Icon(theme == AppThemeMode.glass ? Icons.dark_mode : Icons.auto_awesome),
            onPressed: () => ref.read(themeProvider.notifier).setTheme(
              theme == AppThemeMode.glass ? AppThemeMode.standard : AppThemeMode.glass
            ),
          ),
          IconButton(
            icon: const Icon(Icons.logout_rounded),
            onPressed: () async {
              await Supabase.instance.client.auth.signOut();
              if (mounted) context.go('/login');
            },
          ),
          const SizedBox(width: 8),
        ],
      ),
      body: Row(
        children: [
          if (isWeb) ...[
            NavigationRail(
              extended: width > 1200,
              selectedIndex: widget.navigationShell.currentIndex,
              onDestinationSelected: (i) => widget.navigationShell.goBranch(i),
              // WEB UCHUN YON PANELDA TUGMA
              leading: Padding(
                padding: const EdgeInsets.symmetric(vertical: 20),
                child: FloatingActionButton.extended(
                  onPressed: () => context.push('/add-transaction'),
                  label: const Text("Yangi Amal"),
                  icon: const Icon(Icons.add),
                  backgroundColor: const Color(0xFF2EAF9B),
                  foregroundColor: Colors.white,
                ),
              ),
              destinations: const [
                NavigationRailDestination(icon: Icon(Icons.grid_view_outlined), selectedIcon: Icon(Icons.grid_view), label: Text('Dashboard')),
                NavigationRailDestination(icon: Icon(Icons.payments_outlined), selectedIcon: Icon(Icons.payments), label: Text('Ish haqi')),
                NavigationRailDestination(icon: Icon(Icons.analytics_outlined), selectedIcon: Icon(Icons.analytics), label: Text('Hisobot')),
                NavigationRailDestination(icon: Icon(Icons.settings_outlined), selectedIcon: Icon(Icons.settings), label: Text('Sozlamalar')),
              ],
            ),
            const VerticalDivider(thickness: 1, width: 1),
          ],
          Expanded(child: widget.navigationShell),
        ],
      ),
      bottomNavigationBar: isWeb ? null : NavigationBar(
        selectedIndex: widget.navigationShell.currentIndex,
        onDestinationSelected: (i) => widget.navigationShell.goBranch(i),
        destinations: const [
          NavigationDestination(icon: Icon(Icons.grid_view_outlined), label: 'Bosh'),
          NavigationDestination(icon: Icon(Icons.payments_outlined), label: 'Ish haqi'),
          NavigationDestination(icon: Icon(Icons.analytics_outlined), label: 'Hisobot'),
          NavigationDestination(icon: Icon(Icons.settings_outlined), label: 'Sozlamalar'),
        ],
      ),
      floatingActionButton: isWeb ? null : FloatingActionButton(
        onPressed: () => context.push('/add-transaction'), 
        backgroundColor: const Color(0xFF2EAF9B),
        child: const Icon(Icons.add, color: Colors.white),
      ),
    );
  }

  Widget _buildNotificationBell() {
    final pendingAsync = ref.watch(pendingSalariesProvider);
    return IconButton(
      icon: Stack(
        clipBehavior: Clip.none,
        children: [
          const Icon(Icons.notifications_none_rounded),
          pendingAsync.maybeWhen(
            data: (items) => items.isNotEmpty 
              ? Positioned(
                  right: -2, top: -2,
                  child: Container(
                    padding: const EdgeInsets.all(4),
                    decoration: const BoxDecoration(color: Colors.red, shape: BoxShape.circle),
                    child: Text(items.length.toString(), style: const TextStyle(color: Colors.white, fontSize: 8)),
                  ),
                ) 
              : const SizedBox.shrink(),
            orElse: () => const SizedBox.shrink(),
          ),
        ],
      ),
      onPressed: () => context.push('/notifications'),
    );
  }
}
