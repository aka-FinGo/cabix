import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:go_router/go_router.dart';
import 'package:flutter_slidable/flutter_slidable.dart'; // Surish uchun kutubxona
import '../dashboard/dashboard_provider.dart';
import '../transactions/transaction_repository.dart'; // transactionRepoProvider uchun joy

class NotificationsScreen extends ConsumerWidget {
  const NotificationsScreen({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final pendingAsync = ref.watch(pendingSalariesProvider);

    return Scaffold(
      backgroundColor: Colors.white, // Rasmga o'xshash toza oq fon
      appBar: AppBar(
        backgroundColor: const Color(0xFF48D1CC), // Rasmga mos yashil-ko'k rang
        foregroundColor: Colors.white,
        elevation: 0,
        centerTitle: true,
        title: const Text("Xabarnomalar", style: TextStyle(fontWeight: FontWeight.bold)),
        leading: IconButton(
          icon: const Icon(Icons.menu), // Rasmga o'xshab menyu yoki orqaga
          onPressed: () => context.pop(),
        ),
      ),
      body: pendingAsync.when(
        data: (items) {
          // 1. BO'SH HOLAT (Rasmga o'xshash katta qo'ng'iroqcha)
          if (items.isEmpty) {
            return Center(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Icon(Icons.notifications_active_outlined, size: 120, color: Colors.grey.shade300),
                  const SizedBox(height: 24),
                  const Text("Hozircha hech narsa yo'q!!!", 
                    style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold, color: Colors.black87)
                  ),
                  const SizedBox(height: 8),
                  Text("Yangi tasdiqlashlar kelganda\nshu yerda ko'rinadi.", 
                    textAlign: TextAlign.center, 
                    style: TextStyle(color: Colors.grey.shade500, fontSize: 14)
                  ),
                ],
              ),
            );
          }

          // 2. XABARLAR RO'YXATI (Suriladigan)
          return ListView.builder(
            padding: const EdgeInsets.symmetric(vertical: 8),
            itemCount: items.length,
            itemBuilder: (context, index) {
              final item = items[index];
              final amount = item['amount_uzs'];
              final comment = item['comment'] ?? 'Izohsiz';
              final date = item['created_at'].toString().split('T')[0]; // Sanani ajratish

              return Slidable(
                key: ValueKey(item['id']),
                endActionPane: ActionPane(
                  motion: const StretchMotion(), // Yaxshiroq animatsiya
                  extentRatio: 0.5, // 2 ta tugma uchun
                  children: [
                    // Rad etish (Qizil)
                    SlidableAction(
                      onPressed: (context) async {
                        try {
                          await ref.read(transactionRepoProvider).updateSalaryStatus(salaryId: item['id'], newStatus: 'rejected');
                          ref.invalidate(pendingSalariesProvider);
                          ref.invalidate(salariesProvider); // Ro'yxat yangilanishi uchun
                          ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('Rad etildi'), backgroundColor: Colors.red));
                        } catch(e) {
                          ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text('Xatolik: $e'), backgroundColor: Colors.red));
                        }
                      },
                      backgroundColor: const Color(0xFFFF8A8A), 
                      foregroundColor: Colors.white,
                      icon: Icons.close,
                      label: 'Rad etish',
                    ),
                    // Tasdiqlash (Yashil)
                    SlidableAction(
                      onPressed: (context) async {
                        try {
                          await ref.read(transactionRepoProvider).updateSalaryStatus(salaryId: item['id'], newStatus: 'confirmed');
                          ref.invalidate(pendingSalariesProvider);
                          ref.invalidate(salariesProvider);
                          ref.invalidate(statsProvider);
                          ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('Tasdiqlandi'), backgroundColor: Colors.green));
                        } catch(e) {
                          ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text('Xatolik: $e'), backgroundColor: Colors.red));
                        }
                      },
                      backgroundColor: const Color(0xFF48D1CC),
                      foregroundColor: Colors.white,
                      icon: Icons.check,
                      label: 'Tasdiqlash',
                    ),
                  ],
                ),
                // Xabarning asosiy ko'rinishi
                child: Container(
                  decoration: BoxDecoration(
                    color: Colors.white,
                    border: Border(bottom: BorderSide(color: Colors.grey.shade200)),
                  ),
                  child: ListTile(
                    contentPadding: const EdgeInsets.symmetric(horizontal: 20, vertical: 12),
                    leading: CircleAvatar(
                      backgroundColor: Colors.orange.shade100,
                      child: const Text("YANGI", style: TextStyle(color: Colors.orange, fontSize: 10, fontWeight: FontWeight.bold)),
                    ),
                    title: Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        Text("$amount UZS", style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 16)),
                        Container(
                          padding: const EdgeInsets.symmetric(horizontal: 6, vertical: 2),
                          decoration: BoxDecoration(color: Colors.yellow.shade700, borderRadius: BorderRadius.circular(4)),
                          child: const Text("KUTILMOQDA", style: TextStyle(color: Colors.white, fontSize: 8, fontWeight: FontWeight.bold)),
                        ),
                      ],
                    ),
                    subtitle: Padding(
                      padding: const EdgeInsets.only(top: 6.0),
                      child: Text("$date • $comment", style: TextStyle(color: Colors.grey.shade600, fontSize: 13)),
                    ),
                  ),
                ),
              );
            },
          );
        },
        loading: () => const Center(child: CircularProgressIndicator()),
        error: (e, _) => Center(child: Text("Xatolik: $e")),
      ),
    );
  }
}
