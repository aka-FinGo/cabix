package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Scrollable.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "velocity"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$onScrollStopped$performFling$1", f = "Scrollable.kt", i = {0, 1, 1, 2, 2}, l = {748, 751, 754}, m = "invokeSuspend", n = {"velocity", "velocity", "available", "velocity", "velocityLeft"}, s = {"J$0", "J$0", "J$1", "J$0", "J$1"})
/* loaded from: classes.dex */
public final class ScrollingLogic$onScrollStopped$performFling$1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
    /* synthetic */ long J$0;
    long J$1;
    int label;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingLogic$onScrollStopped$performFling$1(ScrollingLogic scrollingLogic, Continuation<? super ScrollingLogic$onScrollStopped$performFling$1> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollingLogic$onScrollStopped$performFling$1 scrollingLogic$onScrollStopped$performFling$1 = new ScrollingLogic$onScrollStopped$performFling$1(this.this$0, continuation);
        scrollingLogic$onScrollStopped$performFling$1.J$0 = ((Velocity) obj).getPackedValue();
        return scrollingLogic$onScrollStopped$performFling$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Velocity velocity, Continuation<? super Velocity> continuation) {
        return m841invokesFctU(velocity.getPackedValue(), continuation);
    }

    /* renamed from: invoke-sF-c-tU, reason: not valid java name */
    public final Object m841invokesFctU(long j, Continuation<? super Velocity> continuation) {
        return ((ScrollingLogic$onScrollStopped$performFling$1) create(Velocity.m7218boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
    
        if (r2 == r1) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3c
            if (r2 == r5) goto L34
            if (r2 == r4) goto L27
            if (r2 != r3) goto L1e
            long r1 = r0.J$1
            long r3 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r18)
            r0 = r18
            goto L94
        L1e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L27:
            long r4 = r0.J$1
            long r6 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r18)
            r15 = r6
            r7 = r4
            r5 = r15
            r2 = r18
            goto L72
        L34:
            long r5 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r18)
            r2 = r18
            goto L56
        L3c:
            kotlin.ResultKt.throwOnFailure(r18)
            long r6 = r0.J$0
            androidx.compose.foundation.gestures.ScrollingLogic r2 = r0.this$0
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r2 = androidx.compose.foundation.gestures.ScrollingLogic.access$getNestedScrollDispatcher$p(r2)
            r8 = r0
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r0.J$0 = r6
            r0.label = r5
            java.lang.Object r2 = r2.m5483dispatchPreFlingQWom1Mo(r6, r8)
            if (r2 != r1) goto L55
            goto L91
        L55:
            r5 = r6
        L56:
            androidx.compose.ui.unit.Velocity r2 = (androidx.compose.ui.unit.Velocity) r2
            long r7 = r2.getPackedValue()
            long r7 = androidx.compose.ui.unit.Velocity.m7230minusAH228Gc(r5, r7)
            androidx.compose.foundation.gestures.ScrollingLogic r2 = r0.this$0
            r9 = r0
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r0.J$0 = r5
            r0.J$1 = r7
            r0.label = r4
            java.lang.Object r2 = r2.m833doFlingAnimationQWom1Mo(r7, r9)
            if (r2 != r1) goto L72
            goto L91
        L72:
            androidx.compose.ui.unit.Velocity r2 = (androidx.compose.ui.unit.Velocity) r2
            long r12 = r2.getPackedValue()
            androidx.compose.foundation.gestures.ScrollingLogic r2 = r0.this$0
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r9 = androidx.compose.foundation.gestures.ScrollingLogic.access$getNestedScrollDispatcher$p(r2)
            long r10 = androidx.compose.ui.unit.Velocity.m7230minusAH228Gc(r7, r12)
            r14 = r0
            kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14
            r0.J$0 = r5
            r0.J$1 = r12
            r0.label = r3
            java.lang.Object r0 = r9.m5481dispatchPostFlingRZ2iAVY(r10, r12, r14)
            if (r0 != r1) goto L92
        L91:
            return r1
        L92:
            r3 = r5
            r1 = r12
        L94:
            androidx.compose.ui.unit.Velocity r0 = (androidx.compose.ui.unit.Velocity) r0
            long r5 = r0.getPackedValue()
            long r0 = androidx.compose.ui.unit.Velocity.m7230minusAH228Gc(r1, r5)
            long r0 = androidx.compose.ui.unit.Velocity.m7230minusAH228Gc(r3, r0)
            androidx.compose.ui.unit.Velocity r0 = androidx.compose.ui.unit.Velocity.m7218boximpl(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic$onScrollStopped$performFling$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
