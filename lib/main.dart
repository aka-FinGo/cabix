import 'dart:async'; // StreamSubscription uchun kerak
import 'package:flutter/material.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'package:go_router/go_router.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'core/constants.dart';
import 'core/theme/theme_provider.dart';
import 'features/auth/login_screen.dart';
import 'features/auth/register_screen.dart';
import 'features/dashboard/dashboard_screen.dart';
import 'shared/layout/main_wrapper.dart';
import 'features/transactions/add_transaction_screen.dart';
import 'package:cabix/features/notifications/notifications_screen.dart';
import 'features/dashboard/reports_screen.dart';
import 'features/dashboard/admin_settings_screen.dart';
import 'features/dashboard/settings_page_wrapper.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  if (AppConstants.supabaseUrl.isNotEmpty &&
      AppConstants.supabaseAnonKey.isNotEmpty) {
    await Supabase.initialize(
      url: AppConstants.supabaseUrl,
      anonKey: AppConstants.supabaseAnonKey,
    );
  }

  runApp(
    const ProviderScope(
      child: CabixApp(),
    ),
  );
}

final _rootNavigatorKey = GlobalKey<NavigatorState>();

// --- QO'SHILDI: Supabase Auth o'zgarishlarini GoRouter'ga yetkazuvchi "Quloq" ---
class GoRouterRefreshStream extends ChangeNotifier {
  GoRouterRefreshStream(Stream<dynamic> stream) {
    notifyListeners();
    _subscription = stream.asBroadcastStream().listen(
          (dynamic _) => notifyListeners(),
        );
  }
  late final StreamSubscription<dynamic> _subscription;
  @override
  void dispose() {
    _subscription.cancel();
    super.dispose();
  }
}
// ---------------------------------------------------------------------------------

final GoRouter _router = GoRouter(
  navigatorKey: _rootNavigatorKey,
  initialLocation: '/dashboard',

  // QO'SHILDI: Tizimdan chiqilganda yoki kirganda routerni avtomatik yangilash
  refreshListenable:
      GoRouterRefreshStream(Supabase.instance.client.auth.onAuthStateChange),

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
    GoRoute(
      path: '/notifications',
      builder: (context, state) => const NotificationsScreen(),
    ),
    GoRoute(
      path: '/admin-settings',
      builder: (context, state) => const AdminSettingsScreen(),
    ),
    StatefulShellRoute.indexedStack(
      builder: (context, state, navigationShell) {
        return MainWrapper(navigationShell: navigationShell);
      },
      branches: [
        StatefulShellBranch(routes: [
          GoRoute(
            path: '/dashboard',
            builder: (context, state) => const DashboardScreen(),
          ),
        ]),
        StatefulShellBranch(routes: [
          GoRoute(
              path: '/salaries',
              builder: (context, state) =>
                  const Center(child: Text('Ish haqi'))),
        ]),
        StatefulShellBranch(routes: [
          GoRoute(
              path: '/reports',
              builder: (context, state) => const ReportsScreen()),
        ]),
        StatefulShellBranch(routes: [
          GoRoute(
              path: '/settings',
              builder: (context, state) => const SettingsPageWrapper()),
        ]),
      ],
    ),
  ],
);

class CabixApp extends ConsumerWidget {
  const CabixApp({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final themeModeNotifier = ref.watch(themeProvider.notifier);

    return MaterialApp.router(
      title: 'Cabix - Moliya',
      debugShowCheckedModeBanner: false,
      theme: themeModeNotifier.getThemeData(),
      routerConfig: _router,
    );
  }
}
