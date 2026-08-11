package uz.FonRo.pos.ui.docs;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: ReturnsScreen.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tÊ\u0001\f\b\u000b\u0012\b\b\f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\n"}, d2 = {"Luz/FonRo/pos/ui/docs/ReturnsHandoff;", "", "<init>", "()V", "pendingTransactionId", "", "getPendingTransactionId", "()Ljava/lang/String;", "setPendingTransactionId", "(Ljava/lang/String;)V", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ReturnsHandoff {
    public static final int $stable = 0;
    public static final ReturnsHandoff INSTANCE = new ReturnsHandoff();
    private static String pendingTransactionId;

    private ReturnsHandoff() {
    }

    public final String getPendingTransactionId() {
        return pendingTransactionId;
    }

    public final void setPendingTransactionId(String str) {
        pendingTransactionId = str;
    }
}
