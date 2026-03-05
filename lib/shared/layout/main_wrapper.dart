import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:supabase_flutter/supabase_flutter.dart';

class MainWrapper extends StatelessWidget {
  final StatefulNavigationShell navigationShell;

  const MainWrapper({super.key, required this.navigationShell});

  Future<void> _signOut(BuildContext context) async {
    await Supabase.instance.client.auth.signOut();
    if (context.mounted) {
      context.go('/login');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Cabix'),
        elevation: 0,
        actions: [
          IconButton(
            icon: const Icon(Icons.logout),
            onPressed: () => _signOut(context),
            tooltip: 'Tizimdan chiqish',
          ),
        ],
      ),
      body: navigationShell, // Sahifalar shu yerda almashadi
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          // TODO: Add Transaction sahifasini ochish
        },
        child: const Icon(Icons.add),
      ),
      floatingActionButtonLocation: FloatingActionButtonLocation.centerDocked,
      bottomNavigationBar: NavigationBar(
        selectedIndex: navigationShell.currentIndex,
        onDestinationSelected: (index) {
          navigationShell.goBranch(
            index,
            initialLocation: index == navigationShell.currentIndex, // Tab ustiga yana bossa sahifani boshiga qaytaradi
          );
        },
        destinations: const [
          NavigationDestination(icon: Icon(Icons.dashboard), label: 'Bosh sahifa'),
          NavigationDestination(icon: Icon(Icons.money), label: 'Ish haqi'),
          NavigationDestination(icon: Icon(Icons.pie_chart), label: 'Hisobot'),
          NavigationDestination(icon: Icon(Icons.settings), label: 'Sozlamalar'),
        ],
      ),
    );
  }
}
