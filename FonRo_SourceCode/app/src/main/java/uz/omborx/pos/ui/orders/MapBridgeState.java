package uz.FonRo.pos.ui.orders;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StoreLocationMap.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Luz/FonRo/pos/ui/orders/MapBridgeState;", "", "<init>", "()V", "ready", "", "getReady", "()Z", "setReady", "(Z)V", "pending", "", "getPending", "()Ljava/lang/String;", "setPending", "(Ljava/lang/String;)V", "sent", "getSent", "setSent", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class MapBridgeState {
    private String pending;
    private boolean ready;
    private String sent;

    public final boolean getReady() {
        return this.ready;
    }

    public final void setReady(boolean z) {
        this.ready = z;
    }

    public final String getPending() {
        return this.pending;
    }

    public final void setPending(String str) {
        this.pending = str;
    }

    public final String getSent() {
        return this.sent;
    }

    public final void setSent(String str) {
        this.sent = str;
    }
}
