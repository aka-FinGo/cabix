import 'package:flutter/material.dart';
import 'package:supabase_flutter/supabase_flutter.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  int _currentIndex = 0;

  Future<void> _signOut() async {
    await Supabase.instance.client.auth.signOut();
  }

  @override
  Widget build(BuildContext context) {
    final List<Widget> pages = [
      const Center(child: Text('Dashboard (Tez kunda)')),
      const Center(child: Text('Ish haqi tarixi')),
      const Center(child: Text('Hisobotlar')),
      const Center(child: Text('Sozlamalar')),
    ];

    return Scaffold(
      appBar: AppBar(
        title: const Text('Cabix Dashboard'),
        actions: [
          IconButton(
            icon: const Icon(Icons.logout),
            onPressed: _signOut,
            tooltip: 'Tizimdan chiqish',
          ),
        ],
      ),
      body: pages[_currentIndex],
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          ScaffoldMessenger.of(context).showSnackBar(
            const SnackBar(content: Text('Amal qo\'shish oynasi ochiladi')),
          );
        },
        child: const Icon(Icons.add),
      ),
      floatingActionButtonLocation: FloatingActionButtonLocation.centerDocked,
      bottomNavigationBar: NavigationBar(
        selectedIndex: _currentIndex,
        onDestinationSelected: (index) {
          setState(() => _currentIndex = index);
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
