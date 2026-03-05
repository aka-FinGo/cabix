import 'package:flutter/material.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'package:go_router/go_router.dart';
import 'core/constants.dart';
import 'features/auth/login_screen.dart';
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

// GoRouter konfiguratsiyasi
final _rootNavigatorKey = GlobalKey<NavigatorState>();

final GoRouter _router = GoRouter(
  navigatorKey: _rootNavigatorKey,
  initialLocation: '/dashboard',
  redirect: (context, state) {
    // Supabase sessiyasini tekshirish
    final session = Supabase.instance.client.auth.currentSession;
    final isGoingToLogin = state.matchedLocation == '/login';

    if (session == null && !isGoingToLogin) {
      return '/login'; // Kirmagan bo'lsa, loginga jo'natish
    }
    if (session != null && isGoingToLogin) {
      return '/dashboard'; // Kirgan bo'lsa, bosh sahifaga
    }
    return null;
  },
  routes: [
    GoRoute(
      path: '/login',
      builder: (context, state) => const LoginScreen(),
    ),
    // ShellRoute - O'sha siz aytgan Wrapper
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
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.blueAccent),
        useMaterial3: true,
      ),
      routerConfig: _router, // Router ulandi
    );
  }
}
