import 'package:flutter/material.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'core/constants.dart';
import 'features/auth/login_screen.dart';
import 'features/home/home_screen.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  // Kalitlar kelayotganini tekshirish (faqat debug uchun)
  if (AppConstants.supabaseUrl.isEmpty || AppConstants.supabaseAnonKey.isEmpty) {
    debugPrint('DIQQAT: Supabase kalitlari topilmadi. --dart-define tekshiring.');
  } else {
    // Supabase ulanishi
    await Supabase.initialize(
      url: AppConstants.supabaseUrl,
      anonKey: AppConstants.supabaseAnonKey,
    );
  }

  runApp(const CabixApp());
}

class CabixApp extends StatelessWidget {
  const CabixApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Cabix - Moliya',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.blueAccent),
        useMaterial3: true,
      ),
      // Agar Supabase ulanmagan bo'lsa, xatolik oldini olish uchun tekshiramiz
      home: AppConstants.supabaseUrl.isEmpty 
          ? const Scaffold(body: Center(child: Text('Sozlamalar xatosi (Kalitlar yo\'q)'))) 
          : const AuthGate(),
    );
  }
}

class AuthGate extends StatelessWidget {
  const AuthGate({super.key});

  @override
  Widget build(BuildContext context) {
    return StreamBuilder<AuthState>(
      stream: Supabase.instance.client.auth.onAuthStateChange,
      builder: (context, snapshot) {
        if (snapshot.connectionState == ConnectionState.waiting) {
          return const Scaffold(body: Center(child: CircularProgressIndicator()));
        }
        
        final session = snapshot.data?.session;
        if (session != null) {
          return const HomeScreen(); 
        }
        return const LoginScreen(); 
      },
    );
  }
}
