import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:go_router/go_router.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'transaction_repository.dart';
import '../dashboard/dashboard_provider.dart';

class AddTransactionScreen extends ConsumerStatefulWidget {
  const AddTransactionScreen({super.key});

  @override
  ConsumerState<AddTransactionScreen> createState() => _AddTransactionScreenState();
}

class _AddTransactionScreenState extends ConsumerState<AddTransactionScreen> {
  final _formKey = GlobalKey<FormState>();
  final _amountController = TextEditingController();
  final _rateController = TextEditingController(text: '12850');
  final _commentController = TextEditingController();

  String _mainType = 'income';
  String _subType = 'salary';
  String _currency = 'UZS';
  bool _isLoading = false;

  Future<void> _handleSave() async {
    if (!_formKey.currentState!.validate()) return;
    setState(() => _isLoading = true);

    try {
      final user = Supabase.instance.client.auth.currentUser;
      final profile = await Supabase.instance.client.from('profiles').select('role').eq('id', user!.id).single();
      
      await ref.read(transactionRepoProvider).addRecord(
        type: _mainType,
        subCategory: _subType,
        amount: double.parse(_amountController.text),
        currency: _currency,
        exchangeRate: _currency == 'USD' ? double.parse(_rateController.text) : 1.0,
        comment: _commentController.text,
        userRole: profile['role'],
      );

      ref.invalidate(statsProvider);
      ref.invalidate(pendingSalariesProvider);

      if (mounted) {
        context.pop();
        ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('Muvaffaqiyatli saqlandi!')));
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
              SegmentedButton<String>(
                segments: const [
                  ButtonSegment(value: 'income', label: Text('Kirim'), icon: Icon(Icons.add_circle)),
                  ButtonSegment(value: 'expense', label: Text('Chiqim'), icon: Icon(Icons.remove_circle)),
                ],
                selected: {_mainType},
                onSelectionChanged: (val) => setState(() { _mainType = val.first; if(_mainType == 'expense') _subType = 'other'; }),
              ),
              const SizedBox(height: 20),
              if (_mainType == 'income')
                DropdownButtonFormField<String>(
                  value: _subType,
                  decoration: const InputDecoration(labelText: 'Turi', border: OutlineInputBorder()),
                  items: const [
                    DropdownMenuItem(value: 'salary', child: Text('Ish haqi')),
                    DropdownMenuItem(value: 'other', child: Text('Boshqa')),
                  ],
                  onChanged: (val) => setState(() => _subType = val!),
                ),
              const SizedBox(height: 16),
              Row(
                children: [
                  Expanded(flex: 2, child: TextFormField(controller: _amountController, keyboardType: TextInputType.number, decoration: const InputDecoration(labelText: 'Summa', border: OutlineInputBorder()))),
                  const SizedBox(width: 10),
                  Expanded(child: DropdownButtonFormField<String>(value: _currency, items: const [DropdownMenuItem(value: 'UZS', child: Text('UZS')), DropdownMenuItem(value: 'USD', child: Text('USD'))], onChanged: (v) => setState(() => _currency = v!))),
                ],
              ),
              const SizedBox(height: 30),
              SizedBox(width: double.infinity, height: 50, child: ElevatedButton(onPressed: _isLoading ? null : _handleSave, child: _isLoading ? const CircularProgressIndicator() : const Text('SAQLASH'))),
            ],
          ),
        ),
      ),
    );
  }
}
