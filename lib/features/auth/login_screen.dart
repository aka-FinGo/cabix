import 'package:flutter/material.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'package:go_router/go_router.dart';

class LoginScreen extends StatefulWidget {
  const LoginScreen({super.key});

  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  final _emailController = TextEditingController();
  final _passwordController = TextEditingController();
  final _formKey = GlobalKey<FormState>();
  bool _isLoading = false;
  bool _obscurePassword = true;

  Future<void> _signIn() async {
    if (!_formKey.currentState!.validate()) return;
    
    setState(() => _isLoading = true);
    try {
      await Supabase.instance.client.auth.signInWithPassword(
        email: _emailController.text.trim(),
        password: _passwordController.text.trim(),
      );
    } on AuthException catch (e) {
      if (mounted) {
        ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text(e.message)));
      }
    } catch (e) {
      if (mounted) {
        ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('Kutilmagan xatolik')));
      }
    } finally {
      if (mounted) setState(() => _isLoading = false);
    }
  }

  @override
  void dispose() {
    _emailController.dispose();
    _passwordController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    const fintechPrimary = Color(0xFF0F6659);
    const fintechAccent = Color(0xFF2EAF9B);
    
    // Ekran o'lchamini aniqlash
    final size = MediaQuery.of(context).size;
    final bool isSmallScreen = size.height < 700;

    return Scaffold(
      backgroundColor: fintechPrimary,
      body: Stack(
        children: [
          // 1. Header qismi - Mobil uchun qisqartirildi
          Positioned(
            top: 0,
            left: 0,
            right: 0,
            height: isSmallScreen ? size.height * 0.25 : size.height * 0.35,
            child: Container(
              color: fintechPrimary,
              child: const Center(
                child: Icon(Icons.account_balance_wallet_outlined, size: 60, color: Colors.white70),
              ),
            ),
          ),
          
          // 2. Oq karta - Autofill bilan boyitildi
          Positioned(
            top: isSmallScreen ? size.height * 0.22 : size.height * 0.3,
            left: 0,
            right: 0,
            bottom: 0,
            child: Container(
              decoration: const BoxDecoration(
                color: Colors.white,
                borderRadius: BorderRadius.only(
                  topLeft: Radius.circular(32),
                  topRight: Radius.circular(32),
                ),
              ),
              child: SingleChildScrollView(
                padding: const EdgeInsets.all(24.0),
                child: AutofillGroup( // Brauzer eslab qolishi uchun asosiy qism
                  child: Form(
                    key: _formKey,
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.stretch,
                      children: [
                        const Text(
                          'Cabix Moliya',
                          textAlign: TextAlign.center,
                          style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold, color: fintechPrimary),
                        ),
                        const SizedBox(height: 24),
                        
                        // Email Input + Autofill Hint
                        TextFormField(
                          controller: _emailController,
                          autofillHints: const [AutofillHints.email], // Tizimga signal: "Bu email maydoni"
                          keyboardType: TextInputType.emailAddress,
                          textInputAction: TextInputAction.next, // Keyingi inputga o'tish
                          decoration: InputDecoration(
                            labelText: 'Email',
                            prefixIcon: const Icon(Icons.email_outlined, color: fintechPrimary),
                            border: OutlineInputBorder(borderRadius: BorderRadius.circular(12)),
                            filled: true,
                            fillColor: Colors.grey[50],
                          ),
                          validator: (val) => val!.isEmpty ? 'Emailni kiriting' : null,
                        ),
                        const SizedBox(height: 16),
                        
                        // Parol Input + Autofill Hint
                        TextFormField(
                          controller: _passwordController,
                          autofillHints: const [AutofillHints.password], // Tizimga signal: "Bu parol maydoni"
                          obscureText: _obscurePassword,
                          textInputAction: TextInputAction.done, // Klaviaturada "Tayyor" tugmasi
                          onFieldSubmitted: (_) => _signIn(), // Enterni bossa kiradi
                          decoration: InputDecoration(
                            labelText: 'Parol',
                            prefixIcon: const Icon(Icons.lock_outline, color: fintechPrimary),
                            suffixIcon: IconButton(
                              icon: Icon(_obscurePassword ? Icons.visibility_off : Icons.visibility, color: fintechPrimary),
                              onPressed: () => setState(() => _obscurePassword = !_obscurePassword),
                            ),
                            border: OutlineInputBorder(borderRadius: BorderRadius.circular(12)),
                            filled: true,
                            fillColor: Colors.grey[50],
                          ),
                          validator: (val) => val!.isEmpty ? 'Parolni kiriting' : null,
                        ),
                        
                        const SizedBox(height: 24),
                        
                        ElevatedButton(
                          onPressed: _isLoading ? null : _signIn,
                          style: ElevatedButton.styleFrom(
                            backgroundColor: fintechAccent,
                            foregroundColor: Colors.white,
                            padding: const EdgeInsets.symmetric(vertical: 14),
                            shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
                          ),
                          child: _isLoading 
                              ? const SizedBox(height: 20, width: 20, child: CircularProgressIndicator(color: Colors.white, strokeWidth: 2)) 
                              : const Text('KIRISH', style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold)),
                        ),
                        
                        const SizedBox(height: 16),
                        Row(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            const Text('Akkauntingiz yo\'qmi?'),
                            TextButton(
                              onPressed: () => context.go('/register'),
                              child: const Text('Ro\'yxatdan o\'ting', style: TextStyle(color: fintechPrimary)),
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
        ],
      ),
    );
  }
}
