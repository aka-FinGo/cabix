import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'package:go_router/go_router.dart';
import '../dashboard/dashboard_provider.dart'; // Dashboard'ni yangilash uchun

class AddTransactionScreen extends ConsumerStatefulWidget {
  const AddTransactionScreen({super.key});

  @override
  ConsumerState<AddTransactionScreen> createState() => _AddTransactionScreenState();
}

class _AddTransactionScreenState extends ConsumerState<AddTransactionScreen> {
  final _formKey = GlobalKey<FormState>();
  final _amountController = TextEditingController();
  final _descController = TextEditingController();
  
  bool _isLoading = false;
  String _selectedType = 'income'; // 'income' yoki 'expense'
  String _selectedCategory = '';

  // Tayyor kategoriyalar
  final List<String> _incomeCategories = ['Sotuv', 'Xizmat', 'Qarz qaytimi', 'Boshqa'];
  final List<String> _expenseCategories = ['Oziq-ovqat', 'Xomashyo', 'Arenda', 'Soliq', 'Oylik', 'Boshqa'];

  @override
  void initState() {
    super.initState();
    _selectedCategory = _incomeCategories.first; // Boshlang'ich kategoriya
  }

  @override
  void dispose() {
    _amountController.dispose();
    _descController.dispose();
    super.dispose();
  }

  void _onTypeChanged(String type) {
    setState(() {
      _selectedType = type;
      _selectedCategory = type == 'income' ? _incomeCategories.first : _expenseCategories.first;
    });
  }

  Future<void> _saveTransaction() async {
    if (!_formKey.currentState!.validate()) return;
    
    FocusScope.of(context).unfocus();
    setState(() => _isLoading = true);

    try {
      final user = Supabase.instance.client.auth.currentUser;
      if (user == null) throw Exception("Foydalanuvchi topilmadi. Qayta logindan o'ting.");

      // Bazaga ma'lumotni yozish
      await Supabase.instance.client.from('transactions').insert({
        'user_id': user.id,
        'type': _selectedType,
        'amount': double.parse(_amountController.text.replaceAll(',', '')),
        'category': _selectedCategory,
        'description': _descController.text.trim(),
      });

      if (mounted) {
        // MUHIM: Dashboard'dagi ma'lumotlarni qayta yuklashga majbur qilamiz
        ref.invalidate(statsProvider);
        ref.invalidate(recentTransactionsProvider);

        ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(content: Text("Tranzaksiya muvaffaqiyatli saqlandi!"), backgroundColor: Colors.green),
        );
        
        context.pop(); // Dashboardga qaytish
      }
    } catch (e) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text("Xatolik: $e"), backgroundColor: Colors.red),
      );
    } finally {
      if (mounted) setState(() => _isLoading = false);
    }
  }

  @override
  Widget build(BuildContext context) {
    final isIncome = _selectedType == 'income';
    final activeColor = isIncome ? Colors.green : Colors.red;

    return Scaffold(
      backgroundColor: const Color(0xFFF5F7FA),
      appBar: AppBar(
        backgroundColor: Colors.transparent,
        elevation: 0,
        title: const Text("Yangi Tranzaksiya", style: TextStyle(color: Colors.black, fontWeight: FontWeight.bold)),
        leading: IconButton(
          icon: const Icon(Icons.close, color: Colors.black),
          onPressed: () => context.pop(),
        ),
      ),
      body: SafeArea(
        child: Form(
          key: _formKey,
          child: Column(
            children: [
              Expanded(
                child: SingleChildScrollView(
                  padding: const EdgeInsets.all(24.0),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      // 1. KIRIM / CHIQIM TANLASH (Segmented Control o'rniga oddiy tugmalar)
                      Container(
                        decoration: BoxDecoration(
                          color: Colors.grey.shade200,
                          borderRadius: BorderRadius.circular(16),
                        ),
                        padding: const EdgeInsets.all(4),
                        child: Row(
                          children: [
                            Expanded(
                              child: GestureDetector(
                                onTap: () => _onTypeChanged('income'),
                                child: Container(
                                  padding: const EdgeInsets.symmetric(vertical: 12),
                                  decoration: BoxDecoration(
                                    color: isIncome ? Colors.white : Colors.transparent,
                                    borderRadius: BorderRadius.circular(12),
                                    boxShadow: isIncome ? [BoxShadow(color: Colors.black.withOpacity(0.05), blurRadius: 4)] : null,
                                  ),
                                  alignment: Alignment.center,
                                  child: Text("KIRIM", style: TextStyle(fontWeight: FontWeight.bold, color: isIncome ? Colors.green : Colors.grey.shade600)),
                                ),
                              ),
                            ),
                            Expanded(
                              child: GestureDetector(
                                onTap: () => _onTypeChanged('expense'),
                                child: Container(
                                  padding: const EdgeInsets.symmetric(vertical: 12),
                                  decoration: BoxDecoration(
                                    color: !isIncome ? Colors.white : Colors.transparent,
                                    borderRadius: BorderRadius.circular(12),
                                    boxShadow: !isIncome ? [BoxShadow(color: Colors.black.withOpacity(0.05), blurRadius: 4)] : null,
                                  ),
                                  alignment: Alignment.center,
                                  child: Text("CHIQIM", style: TextStyle(fontWeight: FontWeight.bold, color: !isIncome ? Colors.red : Colors.grey.shade600)),
                                ),
                              ),
                            ),
                          ],
                        ),
                      ),
                      const SizedBox(height: 32),

                      // 2. SUMMA KIRITISH
                      const Text("SUMMA (UZS)", style: TextStyle(color: Colors.grey, fontSize: 12, fontWeight: FontWeight.bold)),
                      const SizedBox(height: 8),
                      TextFormField(
                        controller: _amountController,
                        keyboardType: const TextInputType.numberWithOptions(decimal: true),
                        inputFormatters: [FilteringTextInputFormatter.allow(RegExp(r'^\d+\.?\d{0,2}'))],
                        style: TextStyle(fontSize: 36, fontWeight: FontWeight.bold, color: activeColor),
                        decoration: InputDecoration(
                          hintText: "0",
                          prefixIcon: Padding(
                            padding: const EdgeInsets.all(12.0),
                            child: Text(isIncome ? "+" : "-", style: TextStyle(fontSize: 36, color: activeColor, fontWeight: FontWeight.bold)),
                          ),
                          border: OutlineInputBorder(borderRadius: BorderRadius.circular(16), borderSide: BorderSide.none),
                          filled: true,
                          fillColor: Colors.white,
                          contentPadding: const EdgeInsets.symmetric(vertical: 20, horizontal: 16),
                        ),
                        validator: (value) {
                          if (value == null || value.isEmpty) return "Summani kiriting";
                          if (double.tryParse(value) == null || double.parse(value) <= 0) return "Noto'g'ri summa";
                          return null;
                        },
                      ),
                      const SizedBox(height: 24),

                      // 3. KATEGORIYA TANLASH
                      const Text("KATEGORIYA", style: TextStyle(color: Colors.grey, fontSize: 12, fontWeight: FontWeight.bold)),
                      const SizedBox(height: 12),
                      Wrap(
                        spacing: 8,
                        runSpacing: 8,
                        children: (isIncome ? _incomeCategories : _expenseCategories).map((category) {
                          final isSelected = _selectedCategory == category;
                          return ChoiceChip(
                            label: Text(category),
                            selected: isSelected,
                            onSelected: (selected) {
                              if (selected) setState(() => _selectedCategory = category);
                            },
                            selectedColor: activeColor.withOpacity(0.2),
                            labelStyle: TextStyle(
                              color: isSelected ? activeColor : Colors.black87,
                              fontWeight: isSelected ? FontWeight.bold : FontWeight.normal,
                            ),
                            backgroundColor: Colors.white,
                            shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
                          );
                        }).toList(),
                      ),
                      const SizedBox(height: 24),

                      // 4. IZOH KIRITISH
                      const Text("IZOH (Ixtiyoriy)", style: TextStyle(color: Colors.grey, fontSize: 12, fontWeight: FontWeight.bold)),
                      const SizedBox(height: 8),
                      TextFormField(
                        controller: _descController,
                        maxLines: 3,
                        decoration: InputDecoration(
                          hintText: "Tranzaksiya haqida qisqacha...",
                          border: OutlineInputBorder(borderRadius: BorderRadius.circular(16), borderSide: BorderSide.none),
                          filled: true,
                          fillColor: Colors.white,
                        ),
                      ),
                    ],
                  ),
                ),
              ),

              // 5. SAQLASH TUGMASI (Pastga qadab qo'yilgan)
              Container(
                padding: const EdgeInsets.all(24),
                decoration: BoxDecoration(
                  color: Colors.white,
                  boxShadow: [BoxShadow(color: Colors.black.withOpacity(0.05), blurRadius: 10, offset: const Offset(0, -5))],
                ),
                child: SafeArea(
                  child: SizedBox(
                    width: double.infinity,
                    height: 55,
                    child: ElevatedButton(
                      onPressed: _isLoading ? null : _saveTransaction,
                      style: ElevatedButton.styleFrom(
                        backgroundColor: activeColor,
                        foregroundColor: Colors.white,
                        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(16)),
                        elevation: 0,
                      ),
                      child: _isLoading 
                        ? const CircularProgressIndicator(color: Colors.white) 
                        : const Text("SAQLASH", style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold, letterSpacing: 1)),
                    ),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
