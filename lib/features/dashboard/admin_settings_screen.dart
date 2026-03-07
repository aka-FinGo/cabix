import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'package:go_router/go_router.dart';
import 'dashboard_provider.dart';

final allAdminsProvider =
    FutureProvider.autoDispose<List<Map<String, dynamic>>>((ref) async {
  try {
    final res = await Supabase.instance.client
        .from('profiles')
        .select('id, full_name, permissions')
        .order('full_name');
    return List<Map<String, dynamic>>.from(res);
  } catch (e) {
    // Agar 'permissions' ustuni bazada bo'lmasa xato bermasligi uchun fallback
    final res = await Supabase.instance.client
        .from('profiles')
        .select('id, full_name')
        .order('full_name');
    return List<Map<String, dynamic>>.from(
        res.map((e) => {...e, 'permissions': {}}));
  }
});

class AdminSettingsScreen extends ConsumerWidget {
  const AdminSettingsScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final adminsAsync = ref.watch(allAdminsProvider);
    return Scaffold(
      appBar: AppBar(
        title: const Text("Admin Huquqlari"),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () => context.pop(),
        ),
      ),
      body: adminsAsync.when(
        data: (admins) => ListView.builder(
          padding: const EdgeInsets.all(16),
          itemCount: admins.length,
          itemBuilder: (context, index) {
            final admin = admins[index];
            final permissions =
                Map<String, dynamic>.from(admin['permissions'] ?? {});
            final seeExpenses = permissions['see_employee_expenses'] ?? false;

            return Card(
              margin: const EdgeInsets.only(bottom: 12),
              shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(16)),
              child: ListTile(
                contentPadding:
                    const EdgeInsets.symmetric(horizontal: 20, vertical: 8),
                title: Text(admin['full_name'] ?? 'Nomsiz',
                    style: const TextStyle(fontWeight: FontWeight.bold)),
                subtitle: const Text("Xodimlar xarajatlarini ko'rish"),
                trailing: Switch(
                  value: seeExpenses,
                  onChanged: (val) async {
                    final newPermissions = {
                      ...permissions,
                      'see_employee_expenses': val
                    };
                    try {
                      await Supabase.instance.client
                          .from('profiles')
                          .update({'permissions': newPermissions}).eq(
                              'id', admin['id']);
                    } catch (e) {
                      if (context.mounted) {
                        ScaffoldMessenger.of(context).showSnackBar(
                          SnackBar(
                              content: Text(
                                  "Bazada 'permissions' ustuni topilmadi. Uni SQL orqali qo'shish kerak.")),
                        );
                      }
                    }
                    ref.invalidate(allAdminsProvider);
                    ref.invalidate(userProfileProvider);
                    ref.invalidate(statsProvider);
                  },
                  activeColor: const Color(0xFF6366F1),
                ),
              ),
            );
          },
        ),
        loading: () => const Center(child: CircularProgressIndicator()),
        error: (e, _) => Center(child: Text("Xatolik: $e")),
      ),
    );
  }
}
