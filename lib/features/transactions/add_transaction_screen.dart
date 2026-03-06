import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'package:go_router/go_router.dart';
import '../dashboard/dashboard_provider.dart'; 

// Xodimlarni bazadan olib keluvchi provayder (Admin ro'yxatdan tanlashi uchun)
final employeesProvider = FutureProvider.autoDispose<List<Map<String, dynamic>>>((ref) async {
  final response = await Supabase.instance.client
      .from('profiles')
      .select('id, full_name, is_super_admin')
      .neq('is_super_admin', true); // Faqat xodimlarni olamiz
  return List<Map<String, dynamic>>.from(response);
});

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
  String _selectedType = 'income'; // 'income' (Kirim/Oylik) yoki 'expense' (Chiqim)
  String _selectedCategory = 'Boshqa';
  
  String? _selectedEmployeeId; // Tanlangan xodim (Admin uchun)

  final List<String> _incomeCategories = ['Oylik/Avans', 'Sotuv', 'Xizmat', 'Qarz qaytimi', 'Boshqa'];
  final List<String> _expenseCategories = ['Oziq-ovqat', 'Xomashyo', 'Arenda', 'Soliq', 'Boshqa'];

  @override
  void initState() {
    super.initState();
    _selectedCategory = _incomeCategories.first;
    // Boshlang'ich qiymat sifatida foydalanuvchining o'zini tanlaymiz
    _selectedEmployeeId = Supabase.instance.client.auth.currentUser?.id;
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
      if (user == null) throw Exception("Foydalanuvchi topilmadi.");

      final isAdmin = user.appMetadata['is_admin'] == true;
      final amount = double.parse(_amountController.text.replaceAll(',', ''));
      final desc = "[$_selectedCategory] ${_descController.text.trim()}";

      if (_selectedType == 'expense') {
        // 1. CHIQIMLAR: Hech kim tasdiqlamaydi, to'g'ridan-to'g'ri transactions jadvaliga yoziladi
        await Supabase.instance.client.from('transactions').insert({
          'user_id': user.id,
          'type': 'expense',
          'amount': amount,
          'category': _selectedCategory,
          'description': _descController.text.trim(),
        });
      } else {
        // 2. KIRIMLAR (Oylik, tushum, avans)
        if (isAdmin) {
          if (_selectedEmployeeId == user.id) {
            // ADMIN O'ZI UCHUN: Avto tasdiq. 
            await Supabase.instance.client.from('salaries').insert({
              'user_id': user.id,
              'created_by': user.id,
              'amount_uzs': amount,
              'comment': desc,
              'status': 'confirmed' // Tasdiq talab qilinmaydi
            });
          } else {
            // ADMIN XODIMGA: Xodim tasdiqlashi kutilyapti
            await Supabase.instance.client.from('salaries').insert({
              'user_id': _selectedEmployeeId,
              'created_by': user.id, // Admin yozganini bildirish uchun
              'amount_uzs': amount,
              'comment': desc,
              'status': 'pending'
            });
          }
        } else {
          // XODIM O'ZIGA: Admin tasdiqlashi kutilyapti
          await Supabase.instance.client.from('salaries').insert({
            'user_id': user.id,
            'created_by': user.id,
            'amount_uzs': amount,
            'comment': desc,
            'status': 'pending'
          });
        }
      }

      if (mounted) {
        // Barcha ro'yxatlar va grafiklarni yangilashga buyruq
        ref.invalidate(statsProvider);
        ref.invalidate(pendingSalariesProvider); // Tasdiqlash ro'yxatini ham yangilash

        ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(content: Text("Amal muvaffaqiyatli saqlandi!"), backgroundColor: Colors.green),
        );
        context.pop(); 
      }
    } catch (e) {
      ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text("Xatolik: $e"), backgroundColor: Colors.red));
    } finally {
      if (mounted) setState(() => _isLoading = false);
    }
  }

  @override
  Widget build(BuildContext context) {
    final user = Supabase.instance.client.auth.currentUser;
    final isAdmin = user?.appMetadata['is_admin'] == true;
    final isIncome = _selectedType == 'income';
    final activeColor = isIncome ? Colors.green : Colors.red;

    return Scaffold(
      backgroundColor: const Color(0xFFF5F7FA),
      appBar: AppBar(
        backgroundColor: Colors.transparent,
        elevation: 0,
        title: const Text("Yangi Amal", style: TextStyle(color: Colors.black, fontWeight: FontWeight.bold)),
        leading: IconButton(icon: const Icon(Icons.close, color: Colors.black), onPressed: () => context.pop()),
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
                      // 1. KIRIM / CHIQIM TANLASH
                      Container(
                        decoration: BoxDecoration(color: Colors.grey.shade200, borderRadius: BorderRadius.circular(16)),
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
                                  child: Text("KIRIM (Oylik/Tushum)", style: TextStyle(fontWeight: FontWeight.bold, color: isIncome ? Colors.green : Colors.grey.shade600)),
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
                      const SizedBox(height: 24),

                      // 2. HOLAT (Shaffoflik qoidalari) HAQIDA OGOHLANTIRISH
                      Container(
                        width: double.infinity,
                        padding: const EdgeInsets.all(12),
                        decoration: BoxDecoration(color: activeColor.withOpacity(0.1), borderRadius: BorderRadius.circular(12)),
                        child: Row(
                          children: [
                            Icon(Icons.info_outline, color: activeColor, size: 20),
                            const SizedBox(width: 8),
                            Expanded(
                              child: Text(
                                !isIncome 
                                  ? "Chiqimlar darhol balansingizdan yechiladi."
                                  : (isAdmin 
                                      ? (_selectedEmployeeId == user?.id 
                                          ? "Siz o'zingizga pul yozyapsiz. Bu amal darhol tasdiqlanadi." 
                                          : "Bu amal xodim profiliga tushadi va u tasdiqlagandan so'ng hisoblanadi.")
                                      : "Siz kiritgan summa tasdiqlash uchun Adminga yuboriladi."),
                                style: TextStyle(color: activeColor, fontSize: 13),
                              ),
                            ),
                          ],
                        ),
                      ),
                      const SizedBox(height: 24),

                      // 3. XODIMNI TANLASH (Faqat Admin va faqat Kirim bo'lsa)
                      if (isAdmin && isIncome) ...[
                        const Text("KIM UCHUN?", style: TextStyle(color: Colors.grey, fontSize: 12, fontWeight: FontWeight.bold)),
                        const SizedBox(height: 8),
                        Consumer(
                          builder: (context, ref, child) {
                            final employeesAsync = ref.watch(employeesProvider);
                            return employeesAsync.when(
                              data: (employees) {
                                return DropdownButtonFormField<String>(
                                  value: _selectedEmployeeId,
                                  decoration: InputDecoration(
                                    filled: true,
                                    fillColor: Colors.white,
                                    border: OutlineInputBorder(borderRadius: BorderRadius.circular(16), borderSide: BorderSide.none),
                                  ),
                                  items: [
                                    DropdownMenuItem(value: user?.id, child: const Text("Menga (O'zim uchun)")),
                                    ...employees.map((e) => DropdownMenuItem(
                                      value: e['id'], 
                                      child: Text(e['full_name'] ?? 'Ismsiz xodim')
                                    )),
                                  ],
                                  onChanged: (val) => setState(() => _selectedEmployeeId = val),
                                );
                              },
                              loading: () => const LinearProgressIndicator(),
                              error: (e, _) => Text("Xodimlarni yuklashda xato: $e"),
                            );
                          },
                        ),
                        const SizedBox(height: 24),
                      ],

                      // 4. SUMMA
                      const Text("SUMMA (UZS)", style: TextStyle(color: Colors.grey, fontSize: 12, fontWeight: FontWeight.bold)),
                      const SizedBox(height: 8),
                      TextFormField(
                        controller: _amountController,
                        keyboardType: const TextInputType.numberWithOptions(decimal: true),
                        inputFormatters: [FilteringTextInputFormatter.allow(RegExp(r'^\d+\.?\d{0,2}'))],
                        style: TextStyle(fontSize: 32, fontWeight: FontWeight.bold, color: activeColor),
                        decoration: InputDecoration(
                          hintText: "0",
                          prefixIcon: Padding(
                            padding: const EdgeInsets.all(12.0),
                            child: Text(isIncome ? "+" : "-", style: TextStyle(fontSize: 32, color: activeColor, fontWeight: FontWeight.bold)),
                          ),
                          border: OutlineInputBorder(borderRadius: BorderRadius.circular(16), borderSide: BorderSide.none),
                          filled: true,
                          fillColor: Colors.white,
                        ),
                        validator: (value) {
                          if (value == null || value.isEmpty) return "Summani kiriting";
                          if (double.tryParse(value) == null || double.parse(value) <= 0) return "Noto'g'ri summa";
                          return null;
                        },
                      ),
                      const SizedBox(height: 24),

                      // 5. KATEGORIYA 
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
                            onSelected: (selected) { if (selected) setState(() => _selectedCategory = category); },
                            selectedColor: activeColor.withOpacity(0.2),
                            labelStyle: TextStyle(color: isSelected ? activeColor : Colors.black87, fontWeight: isSelected ? FontWeight.bold : FontWeight.normal),
                            backgroundColor: Colors.white,
                            shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12), side: const BorderSide(color: Colors.transparent)),
                          );
                        }).toList(),
                      ),
                      const SizedBox(height: 24),

                      // 6. IZOH
                      const Text("IZOH (Ixtiyoriy)", style: TextStyle(color: Colors.grey, fontSize: 12, fontWeight: FontWeight.bold)),
                      const SizedBox(height: 8),
                      TextFormField(
                        controller: _descController,
                        maxLines: 2,
                        decoration: InputDecoration(
                          hintText: "Masalan: Avans yoki material uchun...",
                          border: OutlineInputBorder(borderRadius: BorderRadius.circular(16), borderSide: BorderSide.none),
                          filled: true,
                          fillColor: Colors.white,
                        ),
                      ),
                    ],
                  ),
                ),
              ),

              // SAQLASH TUGMASI
              Container(
                padding: const EdgeInsets.all(24),
                decoration: BoxDecoration(color: Colors.white, boxShadow: [BoxShadow(color: Colors.black.withOpacity(0.05), blurRadius: 10, offset: const Offset(0, -5))]),
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
