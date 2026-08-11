package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* compiled from: AppBar.kt */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"androidx/compose/material3/EnterAlwaysScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", FirebaseAnalytics.Param.SOURCE, "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class EnterAlwaysScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ EnterAlwaysScrollBehavior this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EnterAlwaysScrollBehavior$nestedScrollConnection$1(EnterAlwaysScrollBehavior enterAlwaysScrollBehavior) {
        this.this$0 = enterAlwaysScrollBehavior;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo1127onPreScrollOzD1aCk(long available, int source) {
        if (!this.this$0.getCanScroll().invoke().booleanValue()) {
            return Offset.INSTANCE.m4141getZeroF1C5BW0();
        }
        float heightOffset = this.this$0.getState().getHeightOffset();
        this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Offset.m4126getYimpl(available));
        if (heightOffset != this.this$0.getState().getHeightOffset()) {
            return Offset.m4119copydBAh8RU$default(available, 0.0f, 0.0f, 2, null);
        }
        return Offset.INSTANCE.m4141getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo821onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (!this.this$0.getCanScroll().invoke().booleanValue()) {
            return Offset.INSTANCE.m4141getZeroF1C5BW0();
        }
        TopAppBarState state = this.this$0.getState();
        state.setContentOffset(state.getContentOffset() + Offset.m4126getYimpl(consumed));
        if ((this.this$0.getState().getHeightOffset() == 0.0f || this.this$0.getState().getHeightOffset() == this.this$0.getState().getHeightOffsetLimit()) && Offset.m4126getYimpl(consumed) == 0.0f && Offset.m4126getYimpl(available) > 0.0f) {
            this.this$0.getState().setContentOffset(0.0f);
        }
        this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Offset.m4126getYimpl(consumed));
        return Offset.INSTANCE.m4141getZeroF1C5BW0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
    
        if (r0 == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo820onPostFlingRZ2iAVY(long r6, long r8, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r10) {
        /*
            r5 = this;
            boolean r0 = r10 instanceof androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1
            if (r0 == 0) goto L14
            r0 = r10
            androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 r0 = (androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 r0 = new androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1
            r0.<init>(r5, r10)
        L19:
            r10 = r0
            java.lang.Object r0 = r10.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r10.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            long r5 = r10.J$0
            kotlin.ResultKt.throwOnFailure(r0)
            goto L7d
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            long r8 = r10.J$0
            java.lang.Object r5 = r10.L$0
            androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1 r5 = (androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1) r5
            kotlin.ResultKt.throwOnFailure(r0)
            goto L52
        L42:
            kotlin.ResultKt.throwOnFailure(r0)
            r10.L$0 = r5
            r10.J$0 = r8
            r10.label = r4
            java.lang.Object r0 = super.mo820onPostFlingRZ2iAVY(r6, r8, r10)
            if (r0 != r1) goto L52
            goto L7b
        L52:
            androidx.compose.ui.unit.Velocity r0 = (androidx.compose.ui.unit.Velocity) r0
            long r6 = r0.getPackedValue()
            androidx.compose.material3.EnterAlwaysScrollBehavior r0 = r5.this$0
            androidx.compose.material3.TopAppBarState r0 = r0.getState()
            float r8 = androidx.compose.ui.unit.Velocity.m7228getYimpl(r8)
            androidx.compose.material3.EnterAlwaysScrollBehavior r9 = r5.this$0
            androidx.compose.animation.core.DecayAnimationSpec r9 = r9.getFlingAnimationSpec()
            androidx.compose.material3.EnterAlwaysScrollBehavior r5 = r5.this$0
            androidx.compose.animation.core.AnimationSpec r5 = r5.getSnapAnimationSpec()
            r2 = 0
            r10.L$0 = r2
            r10.J$0 = r6
            r10.label = r3
            java.lang.Object r0 = androidx.compose.material3.AppBarKt.access$settleAppBar(r0, r8, r9, r5, r10)
            if (r0 != r1) goto L7c
        L7b:
            return r1
        L7c:
            r5 = r6
        L7d:
            androidx.compose.ui.unit.Velocity r0 = (androidx.compose.ui.unit.Velocity) r0
            long r7 = r0.getPackedValue()
            long r5 = androidx.compose.ui.unit.Velocity.m7231plusAH228Gc(r5, r7)
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.m7218boximpl(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1.mo820onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
