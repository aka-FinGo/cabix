import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';

// Tizimdagi holatni (sessiyani) kuzatuvchi asosiy provider
final authStateProvider = StreamProvider<AuthState>((ref) {
  return Supabase.instance.client.auth.onAuthStateChange;
});

// Foydalanuvchi rolini Token'dan (app_metadata) o'qib beruvchi provider
final userRoleProvider = Provider<String>((ref) {
  final user = Supabase.instance.client.auth.currentUser;
  
  if (user == null) return 'guest';
  
  final isAdmin = user.appMetadata['is_admin'] == true;
  return isAdmin ? 'admin' : 'worker';
});
