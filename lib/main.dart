import 'package:flutter/material.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'package:go_router/go_router.dart';
import 'core/constants.dart';
import 'features/auth/login_screen.dart';
import 'features/auth/register_screen.dart'; // <-- Yangi sahifa import qilindi
import 'shared/layout/main_wrapper.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  if (AppConstants.supabaseUrl.isNotEmpty && AppConstants.supabaseAnonKey.isNotEmpty) {
    await Supabase.initialize(
      url: AppConstants.supabaseUrl,
      anonKey: AppConstants.supabaseAnonKey,
    );
  } else {
    debugPrint('DIQQAT: Supabase kalitlari topilmadi.');
  }

  runApp(const CabixApp());
}

final _rootNavigatorKey = GlobalKey<NavigatorState>();

final GoRouter _router = GoRouter(
  navigatorKey: _rootNavigatorKey,
  initialLocation: '/dashboard',
  redirect: (context, state) {
    final session = Supabase.instance.client.auth.currentSession;
    final isGoingToLogin = state.matchedLocation == '/login';
    final isGoingToRegister = state.matchedLocation == '/register';

    if (session == null && !isGoingToLogin && !isGoingToRegister) {
      return '/login'; 
    }
    if (session != null && (isGoingToLogin || isGoingToRegister)) {
      return '/dashboard'; 
    }
    return null;
  },
  routes: [
    GoRoute(
      path: '/login',
      builder: (context, state) => const LoginScreen(),
    ),
    GoRoute(
      path: '/register',
      builder: (context, state) => const RegisterScreen(),
    ),
    StatefulShellRoute.indexedStack(
      builder: (context, state, navigationShell) {
        return MainWrapper(navigationShell: navigationShell);
      },
      branches: [
        StatefulShellBranch(routes: [
          GoRoute(path: '/dashboard', builder: (context, state) => const Center(child: Text('Bosh Sahifa - Dashboard'))),
        ]),
        StatefulShellBranch(routes: [
          GoRoute(path: '/salaries', builder: (context, state) => const Center(child: Text('Ish haqi va Tranzaksiyalar'))),
        ]),
        StatefulShellBranch(routes: [
          GoRoute(path: '/reports', builder: (context, state) => const Center(child: Text('Hisobotlar (PDF/Excel)'))),
        ]),
        StatefulShellBranch(routes: [
          GoRoute(path: '/settings', builder: (context, state) => const Center(child: Text('Sozlamalar va Profil'))),
        ]),
      ],
    ),
  ],
);

class CabixApp extends StatelessWidget {
  const CabixApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp.router(
      title: 'Cabix - Moliya',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: const Color(0xFF0F6659)), // Fintech asosiy rangi
        useMaterial3: true,
      ),
      routerConfig: _router,
    );
  }
}
