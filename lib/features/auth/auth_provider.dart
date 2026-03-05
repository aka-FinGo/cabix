import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';

// Foydalanuvchi roli uchun provider
final userRoleProvider = StateProvider<String>((ref) {
  final user = Supabase.instance.client.auth.currentUser;
  // Metadata ichidan rolni olamiz (SQL-da metadata-ga yozishni sozladik)
  return user?.userMetadata?['role'] ?? 'user';
});
