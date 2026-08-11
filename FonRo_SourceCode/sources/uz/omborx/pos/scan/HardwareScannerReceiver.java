package uz.FonRo.pos.scan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: HardwareScannerReceiver.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016Ê\u0001\f\b\u000b\u0012\b\b\f\u0012\u0004\b\u0003\u0010\u0000¨\u0006\n"}, d2 = {"Luz/FonRo/pos/scan/HardwareScannerReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class HardwareScannerReceiver extends BroadcastReceiver {
    public static final int $stable = 8;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String codeOf$app = HardwareScanner.INSTANCE.codeOf$app(intent);
        if (codeOf$app == null) {
            return;
        }
        HardwareScanner.INSTANCE.emit(codeOf$app);
    }
}
