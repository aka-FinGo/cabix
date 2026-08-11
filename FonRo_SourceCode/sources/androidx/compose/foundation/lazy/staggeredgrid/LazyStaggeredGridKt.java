package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* compiled from: LazyStaggeredGrid.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0093\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"LazyStaggeredGrid", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyStaggeredGrid-w41Enmo", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;FFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyStaggeredGridKt {
    /* JADX WARN: Removed duplicated region for block: B:103:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02ec  */
    /* renamed from: LazyStaggeredGrid-w41Enmo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1257LazyStaggeredGridw41Enmo(final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r25, final androidx.compose.foundation.gestures.Orientation r26, final androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider r27, androidx.compose.ui.Modifier r28, androidx.compose.foundation.layout.PaddingValues r29, boolean r30, androidx.compose.foundation.gestures.FlingBehavior r31, boolean r32, final androidx.compose.foundation.OverscrollEffect r33, float r34, float r35, final kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, final int r38, final int r39, final int r40) {
        /*
            Method dump skipped, instructions count: 938
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt.m1257LazyStaggeredGridw41Enmo(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState, androidx.compose.foundation.gestures.Orientation, androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider, androidx.compose.ui.Modifier, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, androidx.compose.foundation.OverscrollEffect, float, float, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
