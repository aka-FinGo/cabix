package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Scrollable.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J#\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J*\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "enabled", "", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Z)V", "getEnabled", "()Z", "setEnabled", "(Z)V", "getScrollingLogic", "()Landroidx/compose/foundation/gestures/ScrollingLogic;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", FirebaseAnalytics.Param.SOURCE, "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ScrollableNestedScrollConnection implements NestedScrollConnection {
    private boolean enabled;
    private final ScrollingLogic scrollingLogic;

    public ScrollableNestedScrollConnection(ScrollingLogic scrollingLogic, boolean z) {
        this.scrollingLogic = scrollingLogic;
        this.enabled = z;
    }

    public final ScrollingLogic getScrollingLogic() {
        return this.scrollingLogic;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long mo821onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (this.enabled) {
            return this.scrollingLogic.m835performRawScrollMKHz9U(available);
        }
        return Offset.INSTANCE.m4141getZeroF1C5BW0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0063, code lost:
    
        if (r5 == r8) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0075, code lost:
    
        if (r5 == r8) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo820onPostFlingRZ2iAVY(long r4, long r6, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r8) {
        /*
            r3 = this;
            boolean r4 = r8 instanceof androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1
            if (r4 == 0) goto L14
            r4 = r8
            androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1 r4 = (androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1) r4
            int r5 = r4.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 & r0
            if (r5 == 0) goto L14
            int r5 = r4.label
            int r5 = r5 - r0
            r4.label = r5
            goto L19
        L14:
            androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1 r4 = new androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1
            r4.<init>(r3, r8)
        L19:
            java.lang.Object r5 = r4.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r4.label
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L3f
            if (r0 == r2) goto L38
            if (r0 != r1) goto L2f
            long r6 = r4.J$0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L78
        L2f:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L38:
            long r3 = r4.J$0
            kotlin.ResultKt.throwOnFailure(r5)
            r6 = r3
            goto L66
        L3f:
            kotlin.ResultKt.throwOnFailure(r5)
            boolean r5 = r3.enabled
            if (r5 == 0) goto L83
            boolean r5 = androidx.compose.foundation.ComposeFoundationFlags.NewNestedFlingPropagationEnabled
            androidx.compose.foundation.gestures.ScrollingLogic r0 = r3.scrollingLogic
            if (r5 == 0) goto L6d
            boolean r5 = r0.getIsFlinging()
            if (r5 == 0) goto L59
            androidx.compose.ui.unit.Velocity$Companion r3 = androidx.compose.ui.unit.Velocity.INSTANCE
            long r3 = r3.m7238getZero9UxMQ8M()
            goto L7e
        L59:
            androidx.compose.foundation.gestures.ScrollingLogic r3 = r3.scrollingLogic
            r4.J$0 = r6
            r4.label = r2
            java.lang.Object r5 = r3.m833doFlingAnimationQWom1Mo(r6, r4)
            if (r5 != r8) goto L66
            goto L77
        L66:
            androidx.compose.ui.unit.Velocity r5 = (androidx.compose.ui.unit.Velocity) r5
            long r3 = r5.getPackedValue()
            goto L7e
        L6d:
            r4.J$0 = r6
            r4.label = r1
            java.lang.Object r5 = r0.m833doFlingAnimationQWom1Mo(r6, r4)
            if (r5 != r8) goto L78
        L77:
            return r8
        L78:
            androidx.compose.ui.unit.Velocity r5 = (androidx.compose.ui.unit.Velocity) r5
            long r3 = r5.getPackedValue()
        L7e:
            long r3 = androidx.compose.ui.unit.Velocity.m7230minusAH228Gc(r6, r3)
            goto L89
        L83:
            androidx.compose.ui.unit.Velocity$Companion r3 = androidx.compose.ui.unit.Velocity.INSTANCE
            long r3 = r3.m7238getZero9UxMQ8M()
        L89:
            androidx.compose.ui.unit.Velocity r3 = androidx.compose.ui.unit.Velocity.m7218boximpl(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableNestedScrollConnection.mo820onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
