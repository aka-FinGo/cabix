import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:go_router/go_router.dart';
import 'package:flutter_slidable/flutter_slidable.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import '../dashboard/dashboard_provider.dart';
import '../transactions/transaction_repository.dart';
import '../salaries/salary_provider.dart';

class NotificationsScreen extends ConsumerWidget {
  const NotificationsScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final pendingAsync = ref.watch(pendingSalariesProvider);
    final user = Supabase.instance.client.auth.currentUser;
    final isAdmin = user?.appMetadata['is_admin'] == true;

    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        backgroundColor: const Color(0xFF48D1CC),
        foregroundColor: Colors.white,
        elevation: 0,
        centerTitle: true,
        title: const Text('Xabarnomalar', style: TextStyle(fontWeight: FontWeight.bold)),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () => context.pop(),
        ),
      ),
      body: pendingAsync.when(
        // ── BO'SH HOLAT ──────────────────────────────────────────────────────
        data: (items) {
          if (items.isEmpty) {
            return Center(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Icon(Icons.notifications_active_outlined, size: 120, color: Colors.grey.shade300),
                  const SizedBox(height: 24),
                  const Text(
                    "Hozircha hech narsa yo'q!!!",
                    style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold, color: Colors.black87),
                  ),
                  const SizedBox(height: 8),
                  Text(
                    isAdmin
                        ? "Xodimlar ish haqi qo'shganda\nshu yerda tasdiqlash so'rovi keladi."
                        : "Admin sizga pul yozganda\nbu yerda tasdiq so'rovi ko'rinadi.",
                    textAlign: TextAlign.center,
                    style: TextStyle(color: Colors.grey.shade500, fontSize: 14),
                  ),
                ],
              ),
            );
          }

          // ── XABARLAR RO'YXATI ────────────────────────────────────────────
          return ListView.builder(
            padding: const EdgeInsets.symmetric(vertical: 8),
            itemCount: items.length,
            itemBuilder: (context, index) {
              final item = items[index];
              final amountUzs = (item['amount_uzs'] as num?)?.toDouble() ?? 0.0;
              final comment = item['comment'] ?? 'Izohsiz';
              final date = (item['created_at'] ?? '').toString().split('T')[0];

              // Admin ko'rsa → xodim ismini ko'rsatadi (employee join)
              // Xodim ko'rsa  → admin ismini ko'rsatadi (creator join)
              String displayName;
              if (isAdmin) {
                displayName = (item['employee'] as Map?)?['full_name'] ?? 'Noma\'lum xodim';
              } else {
                displayName = (item['creator'] as Map?)?['full_name'] ?? 'Administrator';
              }

              return Slidable(
                key: ValueKey(item['id']),
                endActionPane: ActionPane(
                  motion: const StretchMotion(),
                  extentRatio: 0.5,
                  children: [
                    // Rad etish
                    SlidableAction(
                      onPressed: (_) => _updateStatus(context, ref, item['id'], 'rejected'),
                      backgroundColor: const Color(0xFFFF8A8A),
                      foregroundColor: Colors.white,
                      icon: Icons.close,
                      label: 'Rad etish',
                    ),
                    // Tasdiqlash
                    SlidableAction(
                      onPressed: (_) => _updateStatus(context, ref, item['id'], 'confirmed'),
                      backgroundColor: const Color(0xFF48D1CC),
                      foregroundColor: Colors.white,
                      icon: Icons.check,
                      label: 'Tasdiqlash',
                    ),
                  ],
                ),
                child: _NotifCard(
                  isAdmin: isAdmin,
                  displayName: displayName,
                  amountUzs: amountUzs,
                  date: date,
                  comment: comment,
                  onApprove: () => _updateStatus(context, ref, item['id'], 'confirmed'),
                  onReject: () => _updateStatus(context, ref, item['id'], 'rejected'),
                ),
              );
            },
          );
        },
        loading: () => const Center(child: CircularProgressIndicator()),
        error: (e, _) => Center(child: Text('Xatolik: $e')),
      ),
    );
  }

  Future<void> _updateStatus(
    BuildContext context,
    WidgetRef ref,
    String salaryId,
    String newStatus,
  ) async {
    try {
      await ref.read(transactionRepoProvider).updateSalaryStatus(
            salaryId: salaryId,
            newStatus: newStatus,
          );
      ref.invalidate(pendingSalariesProvider);
      ref.invalidate(salariesProvider);
      ref.invalidate(statsProvider);

      if (context.mounted) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(
            content: Text(newStatus == 'confirmed' ? '✅ Tasdiqlandi' : '❌ Rad etildi'),
            backgroundColor: newStatus == 'confirmed' ? Colors.green : Colors.red,
          ),
        );
      }
    } catch (e) {
      if (context.mounted) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text('Xatolik: $e'), backgroundColor: Colors.red),
        );
      }
    }
  }
}

// ── Kartochka ─────────────────────────────────────────────────────────────────
class _NotifCard extends StatelessWidget {
  final bool isAdmin;
  final String displayName;
  final double amountUzs;
  final String date;
  final String comment;
  final VoidCallback onApprove;
  final VoidCallback onReject;

  const _NotifCard({
    required this.isAdmin,
    required this.displayName,
    required this.amountUzs,
    required this.date,
    required this.comment,
    required this.onApprove,
    required this.onReject,
  });

  String _formatAmount(double amount) {
    String str = amount.truncate().toString();
    String result = '';
    int count = 0;
    for (int i = str.length - 1; i >= 0; i--) {
      if (count != 0 && count % 3 == 0) result = ' $result';
      result = str[i] + result;
      count++;
    }
    return result;
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        color: Colors.white,
        border: Border(bottom: BorderSide(color: Colors.grey.shade200)),
      ),
      child: ListTile(
        contentPadding: const EdgeInsets.symmetric(horizontal: 20, vertical: 12),
        leading: CircleAvatar(
          backgroundColor: isAdmin ? Colors.orange.shade100 : Colors.blue.shade100,
          child: Text(
            displayName.isNotEmpty ? displayName[0].toUpperCase() : '?',
            style: TextStyle(
              color: isAdmin ? Colors.orange : Colors.blue,
              fontWeight: FontWeight.bold,
            ),
          ),
        ),
        title: Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            Expanded(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  // Admin ko'rsa: "Ali Valiyev (xodim)"
                  // Xodim ko'rsa: "Admin tomonidan"
                  Text(
                    isAdmin ? displayName : 'Admin: $displayName',
                    style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 14),
                    overflow: TextOverflow.ellipsis,
                  ),
                  Text(
                    '${_formatAmount(amountUzs)} UZS',
                    style: const TextStyle(
                      fontWeight: FontWeight.bold,
                      fontSize: 16,
                      color: Color(0xFF48D1CC),
                    ),
                  ),
                ],
              ),
            ),
            Container(
              padding: const EdgeInsets.symmetric(horizontal: 6, vertical: 3),
              decoration: BoxDecoration(
                color: Colors.orange.shade700,
                borderRadius: BorderRadius.circular(4),
              ),
              child: const Text(
                'KUTILMOQDA',
                style: TextStyle(color: Colors.white, fontSize: 8, fontWeight: FontWeight.bold),
              ),
            ),
          ],
        ),
        subtitle: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const SizedBox(height: 6),
            Text(
              '$date  •  $comment',
              style: TextStyle(color: Colors.grey.shade600, fontSize: 13),
            ),
            const SizedBox(height: 10),
            Row(
              children: [
                Expanded(
                  child: OutlinedButton.icon(
                    onPressed: onReject,
                    icon: const Icon(Icons.close, size: 14),
                    label: const Text('Rad', style: TextStyle(fontSize: 12)),
                    style: OutlinedButton.styleFrom(
                      foregroundColor: Colors.red,
                      side: const BorderSide(color: Colors.red),
                      minimumSize: const Size(0, 34),
                    ),
                  ),
                ),
                const SizedBox(width: 8),
                Expanded(
                  child: ElevatedButton.icon(
                    onPressed: onApprove,
                    icon: const Icon(Icons.check, size: 14),
                    label: const Text('Tasdiqlash', style: TextStyle(fontSize: 12)),
                    style: ElevatedButton.styleFrom(
                      backgroundColor: const Color(0xFF48D1CC),
                      foregroundColor: Colors.white,
                      minimumSize: const Size(0, 34),
                    ),
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}