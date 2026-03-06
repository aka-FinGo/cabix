import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'salary_provider.dart';
import '../transactions/transaction_repository.dart';
import '../../core/theme/theme_provider.dart';
import '../dashboard/dashboard_widgets.dart';

class SalariesScreen extends ConsumerWidget {
  const SalariesScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final themeMode = ref.watch(themeProvider);
    final isDark = themeMode == AppThemeMode.dark;
    final isGlass = themeMode == AppThemeMode.glass;
    
    final salariesAsync = ref.watch(salariesProvider);
    
    final supabase = Supabase.instance.client;
    final user = supabase.auth.currentUser;
    final isAdmin = user?.appMetadata['is_admin'] == true;

    return Scaffold(
      backgroundColor: isGlass ? Colors.transparent : (isDark ? const Color(0xFF1E1E2C) : const Color(0xFFF5F7FA)),
      appBar: AppBar(
        title: const Text('Ish Hakki Boshqaruvi', style: TextStyle(fontWeight: FontWeight.bold)),
        backgroundColor: Colors.transparent,
        elevation: 0,
        actions: [
          IconButton(
            icon: const Icon(Icons.refresh),
            onPressed: () => ref.refresh(salariesProvider),
          )
        ],
      ),
      body: salariesAsync.when(
        loading: () => const Center(child: CircularProgressIndicator()),
        error: (err, stack) => Center(child: Text('Xatolik: $err', style: const TextStyle(color: Colors.red))),
        data: (salaries) {
          if (salaries.isEmpty) {
             return const Center(child: Text("Hozircha ish haqlari ro'yxati bo'sh.", style: TextStyle(fontSize: 16)));
          }
          
          return RefreshIndicator(
            onRefresh: () async => ref.refresh(salariesProvider),
            child: ListView.builder(
              padding: const EdgeInsets.all(16),
              itemCount: salaries.length,
              itemBuilder: (context, index) {
                final salary = salaries[index];
                return _buildSalaryCard(context, ref, salary, user?.id ?? '', isAdmin, isDark);
              },
            ),
          );
        },
      ),
      floatingActionButton: isAdmin ? FloatingActionButton.extended(
        onPressed: () {
          // Xodimga oylik yozish logikasi AddTransactionScreen orqali qilinadi
          Navigator.pushNamed(context, '/add-transaction'); // Yoki xususiy dialog
        },
        backgroundColor: const Color(0xFF0F6659),
        icon: const Icon(Icons.add_card, color: Colors.white),
        label: const Text("Oylik Yozish", style: TextStyle(color: Colors.white)),
      ) : null,
    );
  }

  Widget _buildSalaryCard(BuildContext context, WidgetRef ref, Map<String, dynamic> salary, String currentUserId, bool isAdmin, bool isDark) {
    final isPending = salary['status'] == 'pending';
    final isConfirmed = salary['status'] == 'confirmed';
    final isRejected = salary['status'] == 'rejected';
    
    // Kim tasdiqlashi kerak degan mantiq:
    // User_id == created_by -> xodim yozgan -> admin tasdiqlaydi
    // User_id != created_by -> admin yozgan -> xodim tasdiqlaydi
    final createdBy = salary['created_by'];
    final userId = salary['user_id'];
    
    // "Tasdiqlash" tugmasi ko'rinishi uchun shart
    bool canConfirm = false;
    if (isPending) {
        if (isAdmin && createdBy != currentUserId) canConfirm = true;
        if (!isAdmin && userId == currentUserId && createdBy != currentUserId) canConfirm = true;
    }
    
    final uzs = double.tryParse(salary['amount_uzs'].toString()) ?? 0.0;
    
    IconData statusIcon = Icons.hourglass_empty;
    Color statusColor = Colors.orange;
    
    if (isConfirmed) {
      statusIcon = Icons.check_circle;
      statusColor = Colors.green;
    } else if (isRejected) {
      statusIcon = Icons.cancel;
      statusColor = Colors.red;
    }

    return Card(
      margin: const EdgeInsets.only(bottom: 12),
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(16)),
      elevation: 2,
      child: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Expanded(
                  child: Text(
                    isAdmin ? (salary['profiles']?['full_name'] ?? 'Noma\'lum xodim') : 'Mening Ish Haqim',
                    style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 16),
                    overflow: TextOverflow.ellipsis,
                  ),
                ),
                Container(
                  padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 4),
                  decoration: BoxDecoration(
                    color: statusColor.withOpacity(0.1),
                    borderRadius: BorderRadius.circular(8),
                  ),
                  child: Row(
                    children: [
                      Icon(statusIcon, size: 14, color: statusColor),
                      const SizedBox(width: 4),
                      Text(
                        salary['status'].toString().toUpperCase(),
                        style: TextStyle(fontSize: 12, fontWeight: FontWeight.bold, color: statusColor),
                      ),
                    ],
                  ),
                )
              ],
            ),
            const SizedBox(height: 8),
            Text(
              "${DashboardWidgets.formatCurrency(uzs)} UZS",
              style: const TextStyle(fontSize: 20, fontWeight: FontWeight.bold, color: Color(0xFF0F6659)),
            ),
            if (salary['comment'] != null && salary['comment'].isNotEmpty)
              Padding(
                padding: const EdgeInsets.only(top: 8.0),
                child: Text('Izoh: ${salary['comment']}', style: TextStyle(color: Colors.grey[600], fontStyle: FontStyle.italic)),
              ),
            
            const SizedBox(height: 12),
            if (canConfirm)
              Row(
                children: [
                  Expanded(
                    child: ElevatedButton(
                       style: ElevatedButton.styleFrom(
                         backgroundColor: Colors.green, 
                         foregroundColor: Colors.white,
                         shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10))
                       ),
                       onPressed: () => _updateStatus(context, ref, salary['id'], 'confirmed'),
                       child: const Text('Tasdiqlash'),
                    ),
                  ),
                  const SizedBox(width: 8),
                  Expanded(
                    child: OutlinedButton(
                       style: OutlinedButton.styleFrom(
                         foregroundColor: Colors.red,
                         side: const BorderSide(color: Colors.red),
                         shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10))
                       ),
                       onPressed: () => _updateStatus(context, ref, salary['id'], 'rejected'),
                       child: const Text('Rad etish'),
                    ),
                  )
                ],
              ),
          ],
        ),
      ),
    );
  }

  Future<void> _updateStatus(BuildContext context, WidgetRef ref, String salaryId, String newStatus) async {
    try {
      final repo = ref.read(transactionRepoProvider);
      await repo.updateSalaryStatus(salaryId: salaryId, newStatus: newStatus);
      ref.invalidate(salariesProvider);
      ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('Status yangilandi'), backgroundColor: Colors.green));
    } catch (e) {
      ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text('Xatolik: $e'), backgroundColor: Colors.red));
    }
  }
}
