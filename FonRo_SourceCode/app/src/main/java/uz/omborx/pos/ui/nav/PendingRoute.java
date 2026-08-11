package uz.FonRo.pos.ui.nav;

import android.content.Intent;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* compiled from: PendingRoute.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u001e\u001a\u00020\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R/\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b \u0012\b\b!\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001f"}, d2 = {"Luz/FonRo/pos/ui/nav/PendingRoute;", "", "<init>", "()V", "EXTRA", "", "EXTRA_ID", "<set-?>", "route", "getRoute", "()Ljava/lang/String;", "setRoute", "(Ljava/lang/String;)V", "route$delegate", "Landroidx/compose/runtime/MutableState;", "", "seq", "getSeq", "()I", "setSeq", "(I)V", "seq$delegate", "Landroidx/compose/runtime/MutableIntState;", "lastId", "", "offer", "", "intent", "Landroid/content/Intent;", "consume", "clear", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class PendingRoute {
    public static final int $stable = 0;
    public static final String EXTRA = "ox_route";
    public static final String EXTRA_ID = "ox_route_id";
    public static final PendingRoute INSTANCE = new PendingRoute();
    private static long lastId;

    /* renamed from: route$delegate, reason: from kotlin metadata */
    private static final MutableState route;

    /* renamed from: seq$delegate, reason: from kotlin metadata */
    private static final MutableIntState seq;

    private PendingRoute() {
    }

    static {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        route = mutableStateOf$default;
        seq = SnapshotIntStateKt.mutableIntStateOf(0);
    }

    private final void setRoute(String str) {
        route.setValue(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getRoute() {
        return (String) route.getValue();
    }

    private final void setSeq(int i) {
        seq.setIntValue(i);
    }

    public final int getSeq() {
        return seq.getIntValue();
    }

    public final void offer(Intent intent) {
        String stringExtra;
        if (intent == null || (stringExtra = intent.getStringExtra(EXTRA)) == null) {
            return;
        }
        if (StringsKt.isBlank(stringExtra)) {
            stringExtra = null;
        }
        if (stringExtra == null) {
            return;
        }
        long longExtra = intent.getLongExtra(EXTRA_ID, 0L);
        if (longExtra == 0 || longExtra != lastId) {
            lastId = longExtra;
            setRoute(stringExtra);
            setSeq(getSeq() + 1);
            intent.removeExtra(EXTRA);
        }
    }

    public final String consume() {
        String route2 = getRoute();
        setRoute(null);
        return route2;
    }

    public final void clear() {
        setRoute(null);
    }
}
