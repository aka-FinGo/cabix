import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:supabase_flutter/supabase_flutter.dart';

class MainWrapper extends StatefulWidget {
  final StatefulNavigationShell navigationShell;

  const MainWrapper({super.key, required this.navigationShell});

  @override
  State<MainWrapper> createState() => _MainWrapperState();
}

class _MainWrapperState extends State<MainWrapper> {
  // Tizimdan chiqish funksiyasi
  Future<void> _signOut(BuildContext context) async {
    await Supabase.instance.client.auth.signOut();
    if (context.mounted) context.go('/login');
  }

  @override
  Widget build(BuildContext context) {
    // Ekran kengligini aniqlash (Web yoki Mobile ekanini bilish uchun)
    final double width = MediaQuery.of(context).size.width;
    final bool isWeb = width > 800; // 800px dan keng bo'lsa Web deb hisoblaymiz

    return Scaffold(
      // 1. HEADER (AppBar) - DIQQAT: O'ZGARISH SHU YERDA!
      // Faqat Webda (kompyuterda) oq AppBar chiqadi. 
      // Telefonda (isWeb == false) null bo'ladi, ya'ni Dashboard'ning o'zidagi yashil AppBar ko'rinadi.
      appBar: isWeb 
        ? AppBar(
            title: const Text('Cabix', style: TextStyle(fontWeight: FontWeight.bold)),
            elevation: 1,
            centerTitle: false,
            actions: [
              IconButton(
                icon: const Icon(Icons.notifications_none),
                onPressed: () {}, // Bildirishnomalar uchun
              ),
              IconButton(
                icon: const Icon(Icons.logout_rounded),
                onPressed: () => _signOut(context),
                tooltip: 'Chiqish',
              ),
              const SizedBox(width: 8),
            ],
          )
        : null, // Telefonda oq AppBar butunlay yo'qoladi!

      // 2. BODY - Webda yon menyu bilan, Mobilda menyusiz
      body: Row(
        children: [
          if (isWeb) ...[
            // Web uchun yon menyu (Navigation Rail)
            NavigationRail(
              extended: width > 1200, // Juda keng ekranda yozuvlari bilan chiqadi
              selectedIndex: widget.navigationShell.currentIndex,
              onDestinationSelected: (index) => _onTap(index),
              leading: const CircleAvatar(
                backgroundColor: Color(0xFF0F6659),
                child: Icon(Icons.person, color: Colors.white),
              ),
              labelType: width <= 1200 ? NavigationRailLabelType.all : null,
              destinations: const [
                NavigationRailDestination(icon: Icon(Icons.dashboard_outlined), selectedIcon: Icon(Icons.dashboard), label: Text('Dashboard')),
                NavigationRailDestination(icon: Icon(Icons.payments_outlined), selectedIcon: Icon(Icons.payments), label: Text('Ish haqi')),
                NavigationRailDestination(icon: Icon(Icons.analytics_outlined), selectedIcon: Icon(Icons.analytics), label: Text('Hisobot')),
                NavigationRailDestination(icon: Icon(Icons.settings_outlined), selectedIcon: Icon(Icons.settings), label: Text('Sozlamalar')),
              ],
            ),
            const VerticalDivider(thickness: 1, width: 1),
          ],
          
          // Asosiy kontent qismi (Sahifalar shu yerda almashadi)
          Expanded(
            child: widget.navigationShell,
          ),
        ],
      ),

      // 3. BOTTOMBAR - Faqat mobil versiya uchun
      bottomNavigationBar: isWeb ? null : NavigationBar(
        selectedIndex: widget.navigationShell.currentIndex,
        onDestinationSelected: (index) => _onTap(index),
        destinations: const [
          NavigationDestination(icon: Icon(Icons.dashboard_outlined), selectedIcon: Icon(Icons.dashboard), label: 'Bosh'),
          NavigationDestination(icon: Icon(Icons.payments_outlined), selectedIcon: Icon(Icons.payments), label: 'Ish haqi'),
          NavigationDestination(icon: Icon(Icons.analytics_outlined), selectedIcon: Icon(Icons.analytics), label: 'Hisobot'),
          NavigationDestination(icon: Icon(Icons.settings_outlined), selectedIcon: Icon(Icons.settings), label: 'Sozlamalar'),
        ],
      ),
      
      // Mobilda yangi amal qo'shish tugmasi
      floatingActionButton: isWeb ? null : FloatingActionButton(
        onPressed: () => context.push('/add-transaction'), 
        backgroundColor: const Color(0xFF2EAF9B),
        child: const Icon(Icons.add, color: Colors.white),
      ),
    );
  }

  // Sahifalar orasida o'tish logikasi
  void _onTap(int index) {
    widget.navigationShell.goBranch(
      index,
      initialLocation: index == widget.navigationShell.currentIndex,
    );
  }
}
