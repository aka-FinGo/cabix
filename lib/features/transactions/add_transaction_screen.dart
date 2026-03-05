import 'package:supabase_flutter/supabase_flutter.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

// Riverpod Provider
final transactionRepoProvider = Provider((ref) => TransactionRepository(Supabase.instance.client));

class TransactionRepository {
  final SupabaseClient _client;
  TransactionRepository(this._client);

  /// Yangi amal qo'shish (Kirim, Chiqim yoki Ish haqi)
  Future<void> addRecord({
    required String type,          // 'income' yoki 'expense'
    required String subCategory,   // 'salary' yoki 'other'
    required double amount,
    required String currency,      // 'UZS' yoki 'USD'
    double exchangeRate = 1.0,
    required String comment,
    required String userRole,      // 'admin' yoki 'user'
    String? targetEmployeeId,      // Admin to'lov qilayotgan xodimning ID si
  }) async {
    final currentUserId = _client.auth.currentUser?.id;
    if (currentUserId == null) throw Exception("Sessiya topilmadi");

    // Valyuta hisob-kitobi (Doim UZS ga o'girib saqlaymiz)
    final double amountUzs = currency == 'USD' ? amount * exchangeRate : amount;
    final double amountUsd = currency == 'USD' ? amount : 0;

    if (subCategory == 'salary') {
      // 1. Ish haqi mantig'i (O'zaro tasdiqlash bilan)
      
      // Statusni aniqlash:
      // Admin yozsa -> xodim tasdiqlashi kerak (pending_employee)
      // Xodim yozsa -> admin tasdiqlashi kerak (pending_admin)
      String initialStatus = (userRole == 'admin') 
          ? 'pending_employee' 
          : 'pending_admin';

      // Agar xodim o'zi uchun yozayotgan bo'lsa, targetEmployeeId uning o'z ID si bo'ladi
      final String employeeId = (userRole == 'admin') 
          ? (targetEmployeeId ?? '') 
          : currentUserId;

      if (employeeId.isEmpty) throw Exception("Xodim tanlanishi shart");

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
      // 2. Oddiy tranzaksiyalar (Kirim/Chiqim) - Darhol tasdiqlanadi
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

  /// Ish haqini tasdiqlash yoki rad etish
  Future<void> updateSalaryStatus({
    required String salaryId,
    required String newStatus, // 'confirmed' yoki 'rejected'
  }) async {
    await _client.from('salaries').update({
      'status': newStatus,
      'confirmed_at': newStatus == 'confirmed' ? DateTime.now().toIso8601String() : null,
    }).eq('id', salaryId);
  }

  /// Tasdiqlash kutilayotgan ish haqlarini olish
  /// Admin uchun: pending_admin bo'lganlar
  /// Xodim uchun: pending_employee bo'lganlar
  Future<List<Map<String, dynamic>>> getPendingApprovals(String role) async {
    final userId = _client.auth.currentUser?.id;
    final String targetStatus = (role == 'admin') ? 'pending_admin' : 'pending_employee';

    var query = _client.from('salaries').select('*, profiles(full_name)');

    if (role == 'admin') {
      // Admin barcha kutayotganlarni ko'radi
      return await query.eq('status', 'pending_admin');
    } else {
      // Xodim faqat o'ziga tegishli kutayotganlarni ko'radi
      return await query.eq('status', 'pending_employee').eq('user_id', userId!);
    }
  }
}
