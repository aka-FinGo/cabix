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
      // Muvaffaqiyatli kirilsa, router yoki AuthGate uni Dashboard'ga o'tkazadi
    } on AuthException catch (e) {
      if (mounted) {
        ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text(e.message)));
      }
    } catch (e) {
      if (mounted) {
        ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('Kutilmagan xatolik yuz berdi')));
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
    final colors = Theme.of(context).colorScheme;
    final primaryColor = colors.primary; // default seed colors bilan ko'k bo'ladi, lekin biz ranglarni o'zgartiramiz
    const fintechPrimary = Color(0xFF0F6659); // image_3.png ning to'q yashil-ko'k rangi
    const fintechAccent = Color(0xFF2EAF9B); // image_3.png ning ochroq yashil-ko'k rangi

    return Scaffold(
      backgroundColor: fintechPrimary, // Yuqori qism yashil fonda
      body: Stack(
        children: [
          // 1. Yuqori qism: Fintech Illyustratsiyasi Placeholder (Yashil fonda)
          // Bu yerga haqiqiy illyustratsiya rasmini (asset) qo'shishingiz kerak. Hozircha rangli blok.
          Positioned(
            top: 0,
            left: 0,
            right: 0,
            height: MediaQuery.of(context).size.height * 0.45, // Ekranning 45% qismi
            child: Container(
              color: fintechPrimary,
              child: const Center(
                child: Padding(
                  padding: EdgeInsets.all(24.0),
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      // Fintech illyustratsiyasi placeholder
                      Icon(Icons.account_balance_wallet_outlined, size: 80, color: Colors.white70),
                      SizedBox(height: 16),
                      Text(
                        'Xavfsiz va aqlli moliya',
                        textAlign: TextAlign.center,
                        style: TextStyle(fontSize: 18, color: Colors.white70),
                      ),
                    ],
                  ),
                ),
              ),
            ),
          ),
          
          // 2. Pastki qism: Modern Oq Karta (Inputlar va Tugmalar)
          Positioned(
            top: MediaQuery.of(context).size.height * 0.4, // Ekranning 40% qismidan boshlanadi
            left: 0,
            right: 0,
            bottom: 0,
            child: SingleChildScrollView(
              padding: const EdgeInsets.only(top: 24.0),
              child: ConstrainedBox(
                constraints: BoxConstraints(minHeight: MediaQuery.of(context).size.height * 0.6),
                child: Container(
                  decoration: const BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.only(
                      topLeft: Radius.circular(32),
                      topRight: Radius.circular(32),
                    ),
                    boxShadow: [
                      BoxShadow(color: Colors.black12, blurRadius: 10, offset: Offset(0, -5)),
                    ],
                  ),
                  child: Padding(
                    padding: const EdgeInsets.all(24.0),
                    child: Form(
                      key: _formKey,
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.start,
                        crossAxisAlignment: CrossAxisAlignment.stretch,
                        children: [
                          // 3. Cabix Logosi va Matnlar
                          const Icon(Icons.account_balance_wallet, size: 56, color: fintechPrimary),
                          const SizedBox(height: 16),
                          const Text(
                            'Cabix Moliya',
                            textAlign: TextAlign.center,
                            style: TextStyle(fontSize: 28, fontWeight: FontWeight.bold, color: fintechPrimary),
                          ),
                          const SizedBox(height: 8),
                          const Text(
                            'Hisobingizga kiring',
                            textAlign: TextAlign.center,
                            style: TextStyle(fontSize: 16, color: Colors.grey),
                          ),
                          const SizedBox(height: 32),
                          
                          // 4. Input Maydonlari (Yumaloq va Soyali)
                          TextFormField(
                            controller: _emailController,
                            decoration: InputDecoration(
                              labelText: 'Email',
                              prefixIcon: const Icon(Icons.email_outlined, color: fintechPrimary),
                              border: OutlineInputBorder(borderRadius: BorderRadius.circular(16)),
                              filled: true,
                              fillColor: Colors.grey[100],
                            ),
                            keyboardType: TextInputType.emailAddress,
                            validator: (val) => val!.isEmpty ? 'Emailni kiriting' : null,
                          ),
                          const SizedBox(height: 16),
                          
                          TextFormField(
                            controller: _passwordController,
                            decoration: InputDecoration(
                              labelText: 'Parol',
                              prefixIcon: const Icon(Icons.lock_outline, color: fintechPrimary),
                              suffixIcon: IconButton(
                                icon: Icon(_obscurePassword ? Icons.visibility_off : Icons.visibility, color: fintechPrimary),
                                onPressed: () => setState(() => _obscurePassword = !_obscurePassword),
                              ),
                              border: OutlineInputBorder(borderRadius: BorderRadius.circular(16)),
                              filled: true,
                              fillColor: Colors.grey[100],
                            ),
                            obscureText: _obscurePassword,
                            validator: (val) => val!.isEmpty ? 'Parolni kiriting' : null,
                          ),
                          const SizedBox(height: 8),
                          
                          Align(
                            alignment: Alignment.centerRight,
                            child: TextButton(
                              onPressed: () {},
                              child: const Text('Parolni unutdingizmi?', style: TextStyle(color: fintechPrimary)),
                            ),
                          ),
                          const SizedBox(height: 16),
                          
                          // 5. KIRISH Tugmasi (Modern Yashil)
                          ElevatedButton(
                            onPressed: _isLoading ? null : _signIn,
                            style: ElevatedButton.styleFrom(
                              backgroundColor: fintechAccent,
                              foregroundColor: Colors.white,
                              padding: const EdgeInsets.symmetric(vertical: 16),
                              shape: RoundedRectangleWithCornerRadii(borderRadius: BorderRadius.circular(16)),
                              elevation: 2,
                            ),
                            child: _isLoading 
                                ? const SizedBox(height: 20, width: 20, child: CircularProgressIndicator(color: Colors.white)) 
                                : const Text('KIRISH', style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold)),
                          ),
                          const SizedBox(height: 24),
                          
                          // 6. Google va Apple Tugmalari Placeholders (Hozircha UI-da)
                          const Text(
                            'Yoki orqali kirish',
                            textAlign: TextAlign.center,
                            style: TextStyle(color: Colors.grey),
                          ),
                          const SizedBox(height: 16),
                          Row(
                            children: [
                              Expanded(
                                child: _SocialAuthButton(
                                  iconPath: 'assets/images/google_logo.png', // asset yo'lini o'zgartiring
                                  text: 'Google',
                                  color: Colors.white,
                                  onPressed: () {},
                                ),
                              ),
                              const SizedBox(width: 16),
                              Expanded(
                                child: _SocialAuthButton(
                                  iconPath: 'assets/images/apple_logo.png', // asset yo'lini o'zgartiring
                                  text: 'Apple',
                                  color: Colors.black,
                                  onPressed: () {},
                                ),
                              ),
                            ],
                          ),
                          const SizedBox(height: 24),
                          
                          // 7. Ro'yxatdan o'tish havolasi
                          Row(
                            mainAxisAlignment: MainAxisAlignment.center,
                            children: [
                              const Text('Akkauntingiz yo\'qmi?'),
                              TextButton(
                                onPressed: () {
                                  // TODO: Ro'yxatdan o'tish sahifasiga o'tish (context.go('/signup'))
                                  ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('Ro\'yxatdan o\'tish sahifasi tez kunda')));
                                },
                                child: const Text('Ro\'yxatdan o\'ting', style: TextStyle(color: fintechPrimary)),
                              ),
                            ],
                          ),
                          const SizedBox(height: 24),
                        ],
                      ),
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

// 8. Google va Apple tugmalari uchun yordamchi widget (Hozircha placeholderlar orqali)
class _SocialAuthButton extends StatelessWidget {
  final String iconPath;
  final String text;
  final Color color;
  final VoidCallback onPressed;

  const _SocialAuthButton({
    required this.iconPath,
    required this.text,
    required this.color,
    required this.onPressed,
  });

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        color: color,
        border: color == Colors.white ? Border.all(color: Colors.grey[300]!) : null,
        borderRadius: BorderRadius.circular(16),
        boxShadow: const [
          BoxShadow(color: Colors.black12, blurRadius: 4, offset: Offset(0, 2)),
        ],
      ),
      child: Material(
        color: Colors.transparent,
        child: InkWell(
          onPressed: onPressed,
          borderRadius: BorderRadius.circular(16),
          child: Padding(
            padding: const EdgeInsets.all(12.0),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                // Haqiqiy logo rasmi (asset) qo'shilguncha icon placeholder
                Icon(
                  color == Colors.black ? Icons.apple : Icons.g_mobiledata,
                  size: 24,
                  color: color == Colors.black ? Colors.white : Colors.black,
                ),
                const SizedBox(width: 8),
                Text(
                  text,
                  style: TextStyle(
                    color: color == Colors.black ? Colors.white : Colors.black,
                    fontWeight: FontWeight.bold,
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
