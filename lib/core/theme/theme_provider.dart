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
        return ThemeData.dark(useMaterial3: true).copyWith(
          colorScheme: ColorScheme.fromSeed(seedColor: const Color(0xFF2EAF9B), brightness: Brightness.dark),
        );
      case AppThemeMode.glass:
        return ThemeData.light(useMaterial3: true).copyWith(
          colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
          scaffoldBackgroundColor: Colors.transparent, // Glass uchun orqa fon gradient bo'ladi
        );
      default:
        return ThemeData.light(useMaterial3: true).copyWith(
          colorScheme: ColorScheme.fromSeed(seedColor: const Color(0xFF0F6659)),
        );
    }
  }
}
