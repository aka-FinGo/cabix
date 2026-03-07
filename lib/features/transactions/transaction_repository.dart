import 'package:supabase_flutter/supabase_flutter.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

final transactionRepoProvider = Provider((ref) => TransactionRepository(Supabase.instance.client));

class TransactionRepository {
  final SupabaseClient _client;
  TransactionRepository(this._client);

  // Salary statusini yangilash
  // TUZATISH: 'confirmed_at' ustuni SQL sxemada YO'Q — o'chirildi
  Future<void> updateSalaryStatus({
    required String salaryId,
    required String newStatus,
  }) async {
    await _client.from('salaries').update({
      'status': newStatus,
      'updated_at': DateTime.now().toIso8601String(),
    }).eq('id', salaryId);
  }

  // Pending oyliklarni rol asosida olish
  Future<List<Map<String, dynamic>>> getPendingApprovals(String role) async {
    final userId = _client.auth.currentUser?.id;
    if (userId == null) return [];

    final all = List<Map<String, dynamic>>.from(
      await _client
          .from('salaries')
          .select('*, employee:profiles!salaries_user_id_fkey(full_name), creator:profiles!salaries_created_by_fkey(full_name)')
          .eq('status', 'pending')
          .order('created_at', ascending: false),
    );

    if (role == 'admin') {
      // Admin: xodim o'zi yozgan → admin tasdiqlaydi (created_by == user_id)
      return all.where((s) => s['created_by'] == s['user_id']).toList();
    } else {
      // Xodim: admin yozgan, o'ziga tegishli → xodim tasdiqlaydi
      return all.where((s) => s['user_id'] == userId && s['created_by'] != userId).toList();
    }
  }
}