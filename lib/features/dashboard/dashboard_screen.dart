import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'dashboard_provider.dart';

class DashboardScreen extends ConsumerWidget {
  const DashboardScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    // Rolni faqat UI darajasida ajratamiz (bazaga so'rov yo'q)
    final user = Supabase.instance.client.auth.currentUser;
    // Diqqat: Profil jadvalidan emas, login qilgan email-dan yoki statik tekshiramiz
    final bool isAdmin = user?.email == 'admin@cabix.uz'; // O'zingizni admin email-ingizni yozing

    final statsAsync = ref.watch(statsProvider);

    return Scaffold(
      appBar: AppBar(
        title: Text(isAdmin ? "Admin Panel" : "Xodim Paneli"),
        actions: [
          IconButton(
            onPressed: () async {
              await Supabase.instance.client.auth.signOut();
            },
            icon: const Icon(Icons.logout),
          )
        ],
      ),
      body: statsAsync.when(
        data: (stats) => SingleChildScrollView(
          padding: const EdgeInsets.all(16),
          child: Column(
            children: [
              _buildCard("Balans", "${stats['balance']} UZS", Colors.blue),
              const SizedBox(height: 12),
              _buildCard("Kirim", "+${stats['income']} UZS", Colors.green),
              const SizedBox(height: 12),
              _buildCard("Chiqim", "-${stats['expense']} UZS", Colors.red),
              const SizedBox(height: 24),
              const Text("Oxirgi amallaringiz bazada saqlanmoqda...", style: TextStyle(color: Colors.grey)),
            ],
          ),
        ),
        loading: () => const Center(child: CircularProgressIndicator()),
        error: (e, _) => Center(child: Text("Yuklashda xato: $e")),
      ),
    );
  }

  Widget _buildCard(String title, String amount, Color color) {
    return Container(
      width: double.infinity,
      padding: const EdgeInsets.all(20),
      decoration: BoxDecoration(
        color: color.withOpacity(0.1),
        borderRadius: BorderRadius.circular(16),
        border: Border.all(color: color.withOpacity(0.3)),
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(title, style: TextStyle(color: color, fontWeight: FontWeight.bold)),
          const SizedBox(height: 8),
          Text(amount, style: const TextStyle(fontSize: 24, fontWeight: FontWeight.bold)),
        ],
      ),
    );
  }
}
