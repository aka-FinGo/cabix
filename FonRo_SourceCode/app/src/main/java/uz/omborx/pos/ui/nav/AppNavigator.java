package uz.FonRo.pos.ui.nav;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Routes.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Luz/FonRo/pos/ui/nav/AppNavigator;", "", "<init>", "()V", "stack", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "", "getStack", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "current", "getCurrent", "()Ljava/lang/String;", "activeTab", "getActiveTab", "open", "", "route", "openTab", "close", "closeTo", "goHome", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class AppNavigator {
    public static final int $stable = 0;
    private static final Set<String> TAB_KEYS = SetsKt.setOf((Object[]) new String[]{Routes.STOCK_IN, Routes.CATALOG, Routes.SALE, Routes.STATS, Routes.AUDIT});
    private final SnapshotStateList<String> stack = SnapshotStateKt.mutableStateListOf();

    public final SnapshotStateList<String> getStack() {
        return this.stack;
    }

    public final String getCurrent() {
        String str = (String) CollectionsKt.lastOrNull((List) this.stack);
        return str == null ? Routes.HOME : str;
    }

    public final String getActiveTab() {
        String str = (String) CollectionsKt.firstOrNull((List) this.stack);
        if (str == null || !TAB_KEYS.contains(str)) {
            return null;
        }
        return str;
    }

    public final void open(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        if (Intrinsics.areEqual(CollectionsKt.lastOrNull((List) this.stack), route)) {
            return;
        }
        this.stack.add(route);
    }

    public final void openTab(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        this.stack.clear();
        this.stack.add(route);
    }

    public final void close() {
        if (this.stack.isEmpty()) {
            return;
        }
        SnapshotStateList<String> snapshotStateList = this.stack;
        snapshotStateList.remove(CollectionsKt.getLastIndex(snapshotStateList));
    }

    public final void closeTo(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        while (!this.stack.isEmpty() && !Intrinsics.areEqual(CollectionsKt.last((List) this.stack), route)) {
            SnapshotStateList<String> snapshotStateList = this.stack;
            snapshotStateList.remove(CollectionsKt.getLastIndex(snapshotStateList));
        }
    }

    public final void goHome() {
        this.stack.clear();
    }
}
