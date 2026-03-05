import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:go_router/go_router.dart';
import '../dashboard/dashboard_provider.dart';
import '../transactions/transaction_repository.dart'; // Bu faylni avval yaratganmiz

class AddTransactionScreen extends ConsumerStatefulWidget {
  const AddTransactionScreen({super.key});

  @override
  ConsumerState<AddTransactionScreen> createState() => _AddTransactionScreenState();
}

class _AddTransactionScreenState extends ConsumerState<AddTransactionScreen> {
  final _formKey = GlobalKey<FormState>();
  final _amountController = TextEditingController();
  final _rateController = TextEditingController(text: '12850'); // Standart kurs
  final _commentController = TextEditingController();

  String _mainType = 'income'; // 'income' yoki 'expense'
  String _subType = 'salary';  // 'salary' yoki 'other'
  String _currency = 'UZS';
  bool _isLoading = false;

  Future<void> _handleSave() async {
    if (!_formKey.currentState!.validate()) return;

    setState(() => _isLoading = true);
    try {
      final repo = ref.read(dashboardRepoProvider); // Dashboard repo'dan foydalanamiz yoki yangi ochamiz
      
      // Valyuta hisobi
      double amount = double.parse(_amountController.text);
      double rate = _currency == 'USD' ? double.parse(_rateController.text) : 1.0;

      // Repository orqali bazaga yozish
      // Eslatma: Bu funksiya avvalgi darsimizda yozilgan mantiq asosida ishlaydi
      await ref.read(transactionRepoProvider).addRecord(
        type: _mainType,
        subCategory: _subType,
        amount: amount,
        currency: _currency,
        exchangeRate: rate,
        comment: _commentController.text,
      );

      // Ma'lumotlarni yangilash
      ref.invalidate(statsProvider);

      if (mounted) {
        context.pop();
        ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('Amaliyot saqlandi!')));
      }
    } catch (e) {
      ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text('Xatolik: $e')));
    } finally {
      if (mounted) setState(() => _isLoading = false);
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Yangi amaliyot')),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(20),
        child: Form(
          key: _formKey,
          child: Column(
            children: [
              // 1. Asosiy tur (Kirim/Chiqim)
              SegmentedButton<String>(
                segments: const [
                  ButtonSegment(value: 'income', label: Text('Kirim'), icon: Icon(Icons.add_circle_outline)),
                  ButtonSegment(value: 'expense', label: Text('Chiqim'), icon: Icon(Icons.remove_circle_outline)),
                ],
                selected: {_mainType},
                onSelectionChanged: (val) => setState(() => _mainType = val.first),
              ),
              const SizedBox(height: 20),

              // 2. Ichki tur (Faqat kirim bo'lsa chiqadi)
              if (_mainType == 'income')
                DropdownButtonFormField<String>(
                  value: _subType,
                  decoration: const InputDecoration(labelText: 'Kirim turi', border: OutlineInputBorder()),
                  items: const [
                    DropdownMenuItem(value: 'salary', child: Text('Ish haqi')),
                    DropdownMenuItem(value: 'other', child: Text('Boshqa daromad')),
                  ],
                  onChanged: (val) => setState(() => _subType = val!),
                ),
              const SizedBox(height: 16),

              // 3. Valyuta tanlash
              Row(
                children: [
                  Expanded(
                    flex: 2,
                    child: TextFormField(
                      controller: _amountController,
                      keyboardType: TextInputType.number,
                      decoration: const InputDecoration(labelText: 'Summa', border: OutlineInputBorder()),
                      validator: (v) => v!.isEmpty ? 'Summani yozing' : null,
                    ),
                  ),
                  const SizedBox(width: 10),
                  Expanded(
                    child: DropdownButtonFormField<String>(
                      value: _currency,
                      decoration: const InputDecoration(border: OutlineInputBorder()),
                      items: const [
                        DropdownMenuItem(value: 'UZS', child: Text('UZS')),
                        DropdownMenuItem(value: 'USD', child: Text('USD')),
                      ],
                      onChanged: (val) => setState(() => _currency = val!),
                    ),
                  ),
                ],
              ),
              const SizedBox(height: 16),

              // 4. Kurs (Faqat USD bo'lsa)
              if (_currency == 'USD')
                TextFormField(
                  controller: _rateController,
                  keyboardType: TextInputType.number,
                  decoration: const InputDecoration(labelText: 'Kurs (1 USD = ? UZS)', border: OutlineInputBorder()),
                ),
              const SizedBox(height: 16),

              // 5. Izoh
              TextFormField(
                controller: _commentController,
                decoration: const InputDecoration(labelText: 'Izoh', border: OutlineInputBorder()),
                maxLines: 2,
              ),
              const SizedBox(height: 30),

              // 6. Saqlash tugmasi
              SizedBox(
                width: double.infinity,
                height: 55,
                child: ElevatedButton(
                  onPressed: _isLoading ? null : _handleSave,
                  style: ElevatedButton.styleFrom(backgroundColor: const Color(0xFF0F6659), foregroundColor: Colors.white),
                  child: _isLoading ? const CircularProgressIndicator(color: Colors.white) : const Text('SAQLASH'),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
