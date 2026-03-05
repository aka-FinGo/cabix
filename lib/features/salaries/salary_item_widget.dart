Widget _buildConfirmationButton(dynamic salary, String currentUserRole) {
  bool canConfirm = false;

  if (currentUserRole == 'admin' && salary['status'] == 'pending_admin') {
    canConfirm = true;
  } else if (currentUserRole == 'user' && salary['status'] == 'pending_employee') {
    canConfirm = true;
  }

  if (!canConfirm) {
    return Chip(
      label: Text(salary['status'] == 'confirmed' ? 'Tasdiqlangan' : 'Kutilmoqda'),
      backgroundColor: salary['status'] == 'confirmed' ? Colors.green[100] : Colors.orange[100],
    );
  }

  return ElevatedButton(
    style: ElevatedButton.styleFrom(backgroundColor: Colors.green, foregroundColor: Colors.white),
    onPressed: () async {
      // Tasdiqlash mantig'i
      await Supabase.instance.client
          .from('salaries')
          .update({'status': 'confirmed', 'confirmed_at': DateTime.now().toIso8601String()})
          .eq('id', salary['id']);
      
      // Dashboardni yangilash
      // ref.invalidate(statsProvider);
    },
    child: const Text('Tasdiqlash'),
  );
}
