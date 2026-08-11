package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: LazyLayoutScrollScope.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0082\b\u001a2\u0010\f\u001a\u00020\b*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0080@¢\u0006\u0002\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u0016"}, d2 = {"BoundDistance", "Landroidx/compose/ui/unit/Dp;", "F", "DEBUG", "", "MinimumDistance", "TargetDistance", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "animateScrollToItem", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;", FirebaseAnalytics.Param.INDEX, "", "scrollOffset", "numOfItemsForTeleport", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;IIILandroidx/compose/ui/unit/Density;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isItemVisible", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyLayoutScrollScopeKt {
    private static final boolean DEBUG = false;
    private static final float TargetDistance = Dp.m6989constructorimpl(2500.0f);
    private static final float BoundDistance = Dp.m6989constructorimpl(1500.0f);
    private static final float MinimumDistance = Dp.m6989constructorimpl(50.0f);

    private static final void debugLog(Function0<String> function0) {
    }

    public static final boolean isItemVisible(LazyLayoutScrollScope lazyLayoutScrollScope, int i) {
        return i <= lazyLayoutScrollScope.getLastVisibleItemIndex() && lazyLayoutScrollScope.getFirstVisibleItemIndex() <= i;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:(1:(2:30|31))|(1:(16:81|39|(1:41)(1:75)|42|(1:44)(1:74)|45|46|47|48|49|50|51|52|53|(8:55|21|22|23|24|25|26|(4:28|30|31|(0)(4:33|34|35|(1:37))))|56)(1:82))(0)|38|39|(0)(0)|42|(0)(0)|45|46|47|48|49|50|51|52|53|(0)|56) */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01dd, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01de, code lost:
    
        r21 = r5;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ec A[Catch: ItemFoundInScroll -> 0x01eb, TryCatch #5 {ItemFoundInScroll -> 0x01eb, blocks: (B:26:0x00e8, B:28:0x00ec, B:30:0x00f2, B:39:0x0121, B:42:0x015d), top: B:25:0x00e8 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x007d  */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.compose.animation.core.AnimationState, T] */
    /* JADX WARN: Type inference failed for: r8v16, types: [androidx.compose.animation.core.AnimationState, T] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x01b7 -> B:21:0x0074). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object animateScrollToItem(androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope r37, int r38, int r39, int r40, androidx.compose.ui.unit.Density r41, kotlin.coroutines.Continuation<? super kotlin.Unit> r42) {
        /*
            Method dump skipped, instructions count: 645
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt.animateScrollToItem(androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope, int, int, int, androidx.compose.ui.unit.Density, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean animateScrollToItem$isOvershot(boolean z, LazyLayoutScrollScope lazyLayoutScrollScope, int i, int i2) {
        if (z) {
            if (lazyLayoutScrollScope.getFirstVisibleItemIndex() > i) {
                return true;
            }
            return lazyLayoutScrollScope.getFirstVisibleItemIndex() == i && lazyLayoutScrollScope.getFirstVisibleItemScrollOffset() > i2;
        }
        if (lazyLayoutScrollScope.getFirstVisibleItemIndex() < i) {
            return true;
        }
        return lazyLayoutScrollScope.getFirstVisibleItemIndex() == i && lazyLayoutScrollScope.getFirstVisibleItemScrollOffset() < i2;
    }
}
