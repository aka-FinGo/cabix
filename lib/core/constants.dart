class AppConstants {
  // GitHub Actions orqali uzatilgan kalitlarni o'qib olamiz
  static const String supabaseUrl = String.fromEnvironment(
    'SUPABASE_URL',
    defaultValue: '', // Agar topilmasa, bo'sh satr qaytaradi
  );
  
  static const String supabaseAnonKey = String.fromEnvironment(
    'SUPABASE_ANON_KEY',
    defaultValue: '',
  );
}
