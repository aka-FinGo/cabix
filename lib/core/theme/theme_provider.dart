import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

enum AppThemeMode { standard, dark, glass }

final themeProvider = StateNotifierProvider<ThemeNotifier, AppThemeMode>((ref) {
  return ThemeNotifier();
});

class ThemeNotifier extends StateNotifier<AppThemeMode> {
  ThemeNotifier() : super(AppThemeMode.standard);

  void setTheme(AppThemeMode mode) => state = mode;

  void toggleTheme() {
    if (state == AppThemeMode.standard) {
      state = AppThemeMode.dark;
    } else if (state == AppThemeMode.dark) {
      state = AppThemeMode.glass;
    } else {
      state = AppThemeMode.standard;
    }
  }

  // Mavzuga qarab ranglar va effektlar palitrasini olish
  ThemeData getThemeData() {
    switch (state) {
      case AppThemeMode.dark:
        return ThemeData(
          useMaterial3: true,
          brightness: Brightness.dark,
          scaffoldBackgroundColor: const Color(0xFF0F0F12), // Deep black/grey
          primaryColor: const Color(0xFF6366F1), // StoreShop Indigo
          cardColor: const Color(0xFF1C1C21),
          colorScheme: const ColorScheme.dark(
            primary: Color(0xFF6366F1),
            secondary: Color(0xFF2EAF9B),
            surface: Color(0xFF1C1C21),
            background: Color(0xFF0F0F12),
          ),
          textTheme: const TextTheme(
            headlineLarge:
                TextStyle(color: Colors.white, fontWeight: FontWeight.bold),
            bodyMedium: TextStyle(color: Colors.white70),
          ),
        );
      case AppThemeMode.glass:
        return ThemeData(
          useMaterial3: true,
          brightness: Brightness.dark,
          scaffoldBackgroundColor: Colors.transparent,
          primaryColor: Colors.white,
          colorScheme: ColorScheme.fromSeed(
            seedColor: Colors.deepPurple,
            brightness: Brightness.dark,
            primary: Colors.white,
          ),
        );
      default:
        return ThemeData(
          useMaterial3: true,
          brightness: Brightness.light,
          scaffoldBackgroundColor: const Color(0xFFF8FAFC),
          primaryColor: const Color(0xFF6366F1),
          cardColor: Colors.white,
          colorScheme: const ColorScheme.light(
            primary: Color(0xFF6366F1),
            secondary: Color(0xFF0F172A),
            surface: Colors.white,
            background: Color(0xFFF8FAFC),
          ),
        );
    }
  }
}
