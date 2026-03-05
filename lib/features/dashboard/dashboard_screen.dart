import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'dashboard_provider.dart';

class DashboardScreen extends ConsumerWidget {
  const DashboardScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final statsAsync = ref.watch(statsProvider);

    return Scaffold(
      appBar: AppBar(
        title: const Text("CABIX Moliya"),
        centerTitle: true,
        actions: [
          IconButton(
            onPressed: () => Supabase.instance.client.auth.signOut(),
            icon: const Icon(Icons.logout_rounded),
          )
        ],
      ),
      body: statsAsync.when(
        data: (stats) => RefreshIndicator(
          onRefresh: () => ref.refresh(statsProvider.future),
          child: SingleChildScrollView(
            physics: const AlwaysScrollableScrollPhysics(),
            padding: const EdgeInsets.all(16),
            child: Column(
              children: [
                _buildFinanceCard("UMUMIY BALANS", "${stats['balance']} UZS", Colors.blue),
                const SizedBox(height: 16),
                Row(
                  children: [
                    Expanded(child: _buildFinanceCard("KIRIM", "+${stats['income']}", Colors.green)),
                    const SizedBox(width: 12),
                    Expanded(child: _buildFinanceCard("CHIQIM", "-${stats['expense']}", Colors.red)),
                  ],
                ),
                const SizedBox(height: 32),
                const Icon(Icons.verified_user, color: Colors.green, size: 40),
                const SizedBox(height: 8),
                const Text("Ma'lumotlar muvaffaqiyatli yuklandi", 
                  style: TextStyle(color: Colors.grey)),
              ],
            ),
          ),
        ),
        loading: () => const Center(child: CircularProgressIndicator()),
        error: (e, _) => Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              const Icon(Icons.error_outline, color: Colors.red, size: 60),
              const SizedBox(height: 16),
              Text("Xatolik: $e", textAlign: TextAlign.center),
              ElevatedButton(
                onPressed: () => ref.refresh(statsProvider),
                child: const Text("Qayta urinish"),
              )
            ],
          ),
        ),
      ),
    );
  }

  Widget _buildFinanceCard(String title, String amount, Color color) {
    return Container(
      padding: const EdgeInsets.all(20),
      decoration: BoxDecoration(
        color: color.withOpacity(0.05),
        borderRadius: BorderRadius.circular(20),
        border: Border.all(color: color.withOpacity(0.2), width: 2),
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(title, style: TextStyle(color: color, fontWeight: FontWeight.bold, fontSize: 12)),
          const SizedBox(height: 8),
          FittedBox(
            child: Text(amount, style: const TextStyle(fontSize: 22, fontWeight: FontWeight.bold)),
          ),
        ],
      ),
    );
  }
}
