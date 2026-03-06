import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';

// Oyliklar ro'yxatini yuklash uchun tayyorlangan provayder
// Agar admin bo'lsa barchasini, xodim bo'lsa faqat o'zinikini ko'radi.
final salariesProvider = FutureProvider.autoDispose<List<Map<String, dynamic>>>((ref) async {
  final supabase = Supabase.instance.client;
  final user = supabase.auth.currentUser;
  
  if (user == null) return [];

  final isAdmin = user.appMetadata['is_admin'] == true;

  var query = supabase.from('salaries').select('*, profiles!salaries_user_id_fkey(full_name), creator:profiles!salaries_created_by_fkey(full_name)').order('created_at', ascending: false);

  if (!isAdmin) {
    // We must await final filter builder, no dynamic reassignment over PostgrestTransformBuilder directly 
    // without matching types. Instead we specify filter builder explicitly.
    final response = await supabase.from('salaries')
        .select('*, profiles!salaries_user_id_fkey(full_name), creator:profiles!salaries_created_by_fkey(full_name)')
        .eq('user_id', user.id)
        .order('created_at', ascending: false);
    return List<Map<String, dynamic>>.from(response);
  }

  final response = await query;
  return List<Map<String, dynamic>>.from(response);
});

// Tasdiqlanishi kutilayotgan oyliklarni sanash uchun (badge)
final pendingSalariesCountProvider = FutureProvider.autoDispose<int>((ref) async {
  final supabase = Supabase.instance.client;
  final user = supabase.auth.currentUser;
  
  if (user == null) return 0;
  
  final isAdmin = user.appMetadata['is_admin'] == true;
  List res;

  if (isAdmin) {
    // Admin o'zi yozganini tasdiqlamaydi
    res = await supabase.from('salaries').select('id').eq('status', 'pending').neq('created_by', user.id);
  } else {
    // xodim faqat o'ziga tegishli va o'zi yozmagan (admin yozgan)larni tasdiqlaydi
    res = await supabase.from('salaries').select('id').eq('status', 'pending').eq('user_id', user.id).neq('created_by', user.id);
  }
  
  return res.length;
});
