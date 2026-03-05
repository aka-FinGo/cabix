import 'package:supabase_flutter/supabase_flutter.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

final transactionRepoProvider = Provider((ref) => TransactionRepository(Supabase.instance.client));

class TransactionRepository {
  final SupabaseClient _client;
  TransactionRepository(this._client);

  Future<void> addRecord({
    required String type,
    required String subCategory,
    required double amount,
    required String currency,
    double exchangeRate = 1.0,
    required String comment,
    required String userRole,
    String? targetEmployeeId,
  }) async {
    final currentUserId = _client.auth.currentUser?.id;
    if (currentUserId == null) throw Exception("Sessiya topilmadi");

    final double amountUzs = currency == 'USD' ? amount * exchangeRate : amount;
    final double amountUsd = currency == 'USD' ? amount : 0;

    if (subCategory == 'salary') {
      // Shaffoflik mantig'i: Kim yozganiga qarab status qo'yish
      String initialStatus = (userRole == 'admin') ? 'pending_employee' : 'pending_admin';
      
      // Admin xodimni tanlashi kerak, xodim esa o'ziga yozadi
      final String employeeId = (userRole == 'admin') ? (targetEmployeeId ?? '') : currentUserId;
      if (employeeId.isEmpty) throw Exception("Xodim tanlanmagan");

      await _client.from('salaries').insert({
        'user_id': employeeId,
        'amount_uzs': amountUzs,
        'amount_usd': amountUsd,
        'exchange_rate': exchangeRate,
        'comment': comment,
        'status': initialStatus,
        'created_by': currentUserId,
      });
    } else {
      // Oddiy tranzaksiya
      await _client.from('transactions').insert({
        'user_id': currentUserId,
        'type': type,
        'amount_uzs': amountUzs,
        'amount_usd': amountUsd,
        'exchange_rate': exchangeRate,
        'comment': comment,
      });
    }
  }

  Future<void> updateSalaryStatus({required String salaryId, required String newStatus}) async {
    await _client.from('salaries').update({
      'status': newStatus,
      'confirmed_at': newStatus == 'confirmed' ? DateTime.now().toIso8601String() : null,
    }).eq('id', salaryId);
  }

  Future<List<Map<String, dynamic>>> getPendingApprovals(String role) async {
    final userId = _client.auth.currentUser?.id;
    final String targetStatus = (role == 'admin') ? 'pending_admin' : 'pending_employee';
    
    var query = _client.from('salaries').select('*, profiles(full_name)');
    if (role == 'admin') {
      return await query.eq('status', targetStatus);
    } else {
      return await query.eq('status', targetStatus).eq('user_id', userId!);
    }
  }
}
