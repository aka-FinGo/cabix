import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'package:go_router/go_router.dart';

class LoginScreen extends StatefulWidget {
  const LoginScreen({super.key});

  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  final _formKey = GlobalKey<FormState>();
  final _emailController = TextEditingController();
  final _passwordController = TextEditingController();
  
  bool _isLoading = false;
  bool _obscurePassword = true;

  @override
  void dispose() {
    _emailController.dispose();
    _passwordController.dispose();
    super.dispose();
  }

  Future<void> _signIn() async {
    if (!_formKey.currentState!.validate()) return;
    
    FocusScope.of(context).unfocus();
    setState(() => _isLoading = true);

    try {
      final response = await Supabase.instance.client.auth.signInWithPassword(
        email: _emailController.text.trim(),
        password: _passwordController.text.trim(),
      );
      
      if (response.user != null && mounted) {
        // MUHIM: Muvaffaqiyatli kirgach, OS/Brauzerga parolni saqlashni buyurish
        TextInput.finishAutofillContext(); 
        context.go('/dashboard');
      }
    } on AuthException catch (e) {
      String errorMessage = "Kirishda xatolik yuz berdi.";
      if (e.message.contains('Invalid login credentials')) {
        errorMessage = "Email yoki parol noto'g'ri!";
      } else {
        errorMessage = e.message;
      }
      _showError(errorMessage);
    } catch (e) {
      _showError("Kutilmagan xatolik: Tarmoqni tekshiring.");
    } finally {
      if (mounted) setState(() => _isLoading = false);
    }
  }

  void _showError(String message) {
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Row(
          children: [
            const Icon(Icons.error_outline, color: Colors.white),
            const SizedBox(width: 12),
            Expanded(child: Text(message)),
          ],
        ),
        backgroundColor: Colors.red.shade600,
        behavior: SnackBarBehavior.floating,
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
        margin: const EdgeInsets.all(16),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFFF5F7FA),
      body: Center(
        child: SingleChildScrollView(
          padding: const EdgeInsets.all(24.0),
          child: Container(
            constraints: const BoxConstraints(maxWidth: 400),
            padding: const EdgeInsets.all(32),
            decoration: BoxDecoration(
              color: Colors.white,
              borderRadius: BorderRadius.circular(24),
              boxShadow: [
                BoxShadow(color: Colors.black.withOpacity(0.05), blurRadius: 20, offset: const Offset(0, 10))
              ],
            ),
            // AutofillGroup brauzer va OS parollarni eslab qolishi uchun shart
            child: AutofillGroup(
              child: Form(
                key: _formKey,
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.stretch,
                  children: [
                    const Icon(Icons.account_balance_wallet, size: 60, color: Color(0xFF0F6659)),
                    const SizedBox(height: 16),
                    const Text("CABIX", textAlign: TextAlign.center, style: TextStyle(fontSize: 28, fontWeight: FontWeight.bold, color: Color(0xFF0F6659), letterSpacing: 1.5)),
                    const SizedBox(height: 8),
                    Text("Tizimga xush kelibsiz", textAlign: TextAlign.center, style: TextStyle(color: Colors.grey.shade600, fontSize: 14)),
                    const SizedBox(height: 40),

                    // EMAIL
                    TextFormField(
                      controller: _emailController,
                      keyboardType: TextInputType.emailAddress,
                      textInputAction: TextInputAction.next,
                      autofillHints: const [AutofillHints.email], // Eslab qolish uchun
                      decoration: InputDecoration(
                        labelText: "Email",
                        prefixIcon: const Icon(Icons.email_outlined),
                        border: OutlineInputBorder(borderRadius: BorderRadius.circular(12)),
                        enabledBorder: OutlineInputBorder(borderRadius: BorderRadius.circular(12), borderSide: BorderSide(color: Colors.grey.shade300)),
                      ),
                      validator: (value) {
                        if (value == null || value.isEmpty) return "Email kiritish majburiy";
                        return null;
                      },
                    ),
                    const SizedBox(height: 20),

                    // PAROL
                    TextFormField(
                      controller: _passwordController,
                      obscureText: _obscurePassword,
                      textInputAction: TextInputAction.done,
                      autofillHints: const [AutofillHints.password], // Eslab qolish uchun
                      onFieldSubmitted: (_) => _signIn(),
                      decoration: InputDecoration(
                        labelText: "Parol",
                        prefixIcon: const Icon(Icons.lock_outline),
                        suffixIcon: IconButton(
                          icon: Icon(_obscurePassword ? Icons.visibility_off : Icons.visibility),
                          onPressed: () => setState(() => _obscurePassword = !_obscurePassword),
                        ),
                        border: OutlineInputBorder(borderRadius: BorderRadius.circular(12)),
                        enabledBorder: OutlineInputBorder(borderRadius: BorderRadius.circular(12), borderSide: BorderSide(color: Colors.grey.shade300)),
                      ),
                      validator: (value) {
                        if (value == null || value.isEmpty) return "Parol kiritish majburiy";
                        return null;
                      },
                    ),
                    
                    // PAROLNI UNUTDINGIZMI? TUGMASI
                    Align(
                      alignment: Alignment.centerRight,
                      child: TextButton(
                        onPressed: () {
                          // TODO: Parolni tiklash sahifasiga o'tish
                          // context.push('/forgot-password');
                          ScaffoldMessenger.of(context).showSnackBar(
                            const SnackBar(content: Text("Parolni tiklash sahifasi ulanmoqda..."))
                          );
                        },
                        child: const Text("Parolni unutdingizmi?", style: TextStyle(color: Color(0xFF0F6659))),
                      ),
                    ),
                    const SizedBox(height: 16),

                    // KIRISH TUGMASI
                    SizedBox(
                      height: 55,
                      child: ElevatedButton(
                        onPressed: _isLoading ? null : _signIn,
                        style: ElevatedButton.styleFrom(
                          backgroundColor: const Color(0xFF0F6659),
                          foregroundColor: Colors.white,
                          elevation: 0,
                          shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
                        ),
                        child: _isLoading 
                          ? const SizedBox(height: 24, width: 24, child: CircularProgressIndicator(color: Colors.white, strokeWidth: 2.5)) 
                          : const Text("KIRISH", style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold, letterSpacing: 1)),
                      ),
                    ),
                    const SizedBox(height: 24),

                    // RO'YXATDAN O'TISH TUGMASI
                    Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Text("Hisobingiz yo'qmi?", style: TextStyle(color: Colors.grey.shade600)),
                        TextButton(
                          onPressed: () {
                            // TODO: Ro'yxatdan o'tish sahifasiga o'tish
                            // context.push('/register');
                            ScaffoldMessenger.of(context).showSnackBar(
                              const SnackBar(content: Text("Ro'yxatdan o'tish sahifasi ulanmoqda..."))
                            );
                          },
                          child: const Text("Ro'yxatdan o'tish", style: TextStyle(fontWeight: FontWeight.bold, color: Color(0xFF0F6659))),
                        ),
                      ],
                    ),
                  ],
                ),
              ),
            ),
          ),
        ),
      ),
    );
  }
}
