import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:supabase_flutter/supabase_flutter.dart';
import 'package:go_router/go_router.dart';
import 'dashboard_provider.dart';
import '../../core/theme/theme_provider.dart';

class SettingsPageWrapper extends ConsumerWidget {
  const SettingsPageWrapper({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final user = Supabase.instance.client.auth.currentUser;
    final isAdmin = user?.appMetadata['is_admin'] == true;
    final theme = ref.watch(themeProvider);
    final isDark = theme == AppThemeMode.dark || theme == AppThemeMode.glass;

    return Scaffold(
      backgroundColor: Colors.transparent,
      body: ListView(
        padding: const EdgeInsets.all(24),
        children: [
          _buildSectionHeader("Umumiy Sozlamalar", isDark),
          const SizedBox(height: 16),
          _buildSettingTile(
            icon: Icons.palette_outlined,
            title: "Mavzu",
            subtitle: "Dastur ko'rinishini o'zgartirish",
            trailing: Text(theme.name.toUpperCase()),
            onTap: () => ref.read(themeProvider.notifier).toggleTheme(),
            isDark: isDark,
          ),
          const SizedBox(height: 32),
          if (isAdmin) ...[
            _buildSectionHeader("Admin Sozlamalari", isDark),
            const SizedBox(height: 16),
            _buildSettingTile(
              icon: Icons.admin_panel_settings_outlined,
              title: "Admin Huquqlari",
              subtitle: "Xodimlar uchun ruxsatlarni boshqarish",
              onTap: () => context.push('/admin-settings'),
              isDark: isDark,
            ),
          ],
          const SizedBox(height: 32),
          _buildSettingTile(
            icon: Icons.logout,
            title: "Tizimdan chiqish",
            subtitle: "Hozirgi seansni yakunlash",
            onTap: () => Supabase.instance.client.auth.signOut(),
            isDark: isDark,
            danger: true,
          ),
        ],
      ),
    );
  }

  Widget _buildSectionHeader(String title, bool isDark) {
    return Text(
      title,
      style: TextStyle(
        fontSize: 14,
        fontWeight: FontWeight.bold,
        color: isDark ? Colors.white54 : Colors.grey.shade600,
        letterSpacing: 1,
      ),
    );
  }

  Widget _buildSettingTile({
    required IconData icon,
    required String title,
    required String subtitle,
    Widget? trailing,
    required VoidCallback onTap,
    required bool isDark,
    bool danger = false,
  }) {
    final color =
        danger ? Colors.redAccent : (isDark ? Colors.white : Colors.black87);

    return Container(
      decoration: BoxDecoration(
        color: isDark ? Colors.white.withOpacity(0.05) : Colors.white,
        borderRadius: BorderRadius.circular(16),
        border:
            isDark ? Border.all(color: Colors.white.withOpacity(0.05)) : null,
        boxShadow: isDark
            ? []
            : [
                BoxShadow(
                    color: Colors.black.withOpacity(0.02),
                    blurRadius: 10,
                    offset: const Offset(0, 4))
              ],
      ),
      child: ListTile(
        onTap: onTap,
        contentPadding: const EdgeInsets.symmetric(horizontal: 20, vertical: 8),
        leading: Icon(icon, color: color),
        title: Text(title,
            style: TextStyle(color: color, fontWeight: FontWeight.bold)),
        subtitle: Text(subtitle,
            style: const TextStyle(color: Colors.grey, fontSize: 12)),
        trailing:
            trailing ?? const Icon(Icons.chevron_right, color: Colors.grey),
      ),
    );
  }
}
