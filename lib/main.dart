import 'package:flutter/material.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'package:go_router/go_router.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart'; // Riverpod import qilindi
import 'core/constants.dart';
import 'core/theme/theme_provider.dart'; // ThemeProvider import qilindi
import 'features/auth/login_screen.dart';
import 'features/auth/register_screen.dart';
import 'features/dashboard/dashboard_screen.dart'; // Dashboard qo'shildi
import 'shared/layout/main_wrapper.dart';
import 'features/transactions/add_transaction_screen.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  if (AppConstants.supabaseUrl.isNotEmpty && AppConstants.supabaseAnonKey.isNotEmpty) {
    await Supabase.initialize(
      url: AppConstants.supabaseUrl,
      anonKey: AppConstants.supabaseAnonKey,
    );
  }

  // Riverpod ishlashi uchun ProviderScope bilan o'rash shart
  runApp(
    const ProviderScope(
      child: CabixApp(),
    ),
  );
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
    GoRoute(
     path: '/add-transaction',
     builder: (context, state) => const AddTransactionScreen(),
),
    StatefulShellRoute.indexedStack(
      builder: (context, state, navigationShell) {
        return MainWrapper(navigationShell: navigationShell);
      },
      branches: [
        StatefulShellBranch(routes: [
          GoRoute(
            path: '/dashboard', 
            builder: (context, state) => const DashboardScreen(), // Haqiqiy Dashboard ulandi
          ),
        ]),
        StatefulShellBranch(routes: [
          GoRoute(path: '/salaries', builder: (context, state) => const Center(child: Text('Ish haqi'))),
        ]),
        StatefulShellBranch(routes: [
          GoRoute(path: '/reports', builder: (context, state) => const Center(child: Text('Hisobotlar'))),
        ]),
        StatefulShellBranch(routes: [
          GoRoute(path: '/settings', builder: (context, state) => const Center(child: Text('Sozlamalar'))),
        ]),
      ],
    ),
  ],
);

class CabixApp extends ConsumerWidget { // ConsumerWidget to'g'ri ulandi
  const CabixApp({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    // Endi ref.watch xatosiz ishlaydi
    final themeModeNotifier = ref.watch(themeProvider.notifier);

    return MaterialApp.router(
      title: 'Cabix - Moliya',
      debugShowCheckedModeBanner: false,
      theme: themeModeNotifier.getThemeData(), // Dinamik mavzu ulandi
      routerConfig: _router,
    );
  }
}
