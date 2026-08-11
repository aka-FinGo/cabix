package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: PressDownGesture.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.PressDownGestureKt$detectPressDownGesture$2", f = "PressDownGesture.kt", i = {0, 1, 1}, l = {31, 37}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: classes.dex */
final class PressDownGestureKt$detectPressDownGesture$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TapOnPosition $onDown;
    final /* synthetic */ Function0<Unit> $onUp;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PressDownGestureKt$detectPressDownGesture$2(TapOnPosition tapOnPosition, Function0<Unit> function0, Continuation<? super PressDownGestureKt$detectPressDownGesture$2> continuation) {
        super(2, continuation);
        this.$onDown = tapOnPosition;
        this.$onUp = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PressDownGestureKt$detectPressDownGesture$2 pressDownGestureKt$detectPressDownGesture$2 = new PressDownGestureKt$detectPressDownGesture$2(this.$onDown, this.$onUp, continuation);
        pressDownGestureKt$detectPressDownGesture$2.L$0 = obj;
        return pressDownGestureKt$detectPressDownGesture$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((PressDownGestureKt$detectPressDownGesture$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0065, code lost:
    
        if (r13 != r0) goto L20;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0065 -> B:6:0x0068). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2b
            if (r1 == r3) goto L23
            if (r1 != r2) goto L1a
            java.lang.Object r1 = r12.L$1
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            java.lang.Object r4 = r12.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
            kotlin.ResultKt.throwOnFailure(r13)
            goto L68
        L1a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L23:
            java.lang.Object r1 = r12.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto L46
        L2b:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            r4 = r13
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
            r7 = r12
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r12.L$0 = r4
            r12.label = r3
            r5 = 0
            r6 = 0
            r8 = 2
            r9 = 0
            java.lang.Object r13 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r4, r5, r6, r7, r8, r9)
            if (r13 != r0) goto L45
            goto L67
        L45:
            r1 = r4
        L46:
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            androidx.compose.foundation.text.input.internal.selection.TapOnPosition r4 = r12.$onDown
            long r5 = r13.getPosition()
            r4.mo1660onEventk4lQ0M(r5)
            kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r12.$onUp
            if (r4 == 0) goto L9b
            r4 = r1
            r1 = r13
        L57:
            r13 = r12
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
            r12.L$0 = r4
            r12.L$1 = r1
            r12.label = r2
            r5 = 0
            java.lang.Object r13 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r4, r5, r13, r3, r5)
            if (r13 != r0) goto L68
        L67:
            return r0
        L68:
            androidx.compose.ui.input.pointer.PointerEvent r13 = (androidx.compose.ui.input.pointer.PointerEvent) r13
            java.util.List r13 = r13.getChanges()
            r5 = r13
            java.util.Collection r5 = (java.util.Collection) r5
            int r5 = r5.size()
            r6 = 0
        L76:
            if (r6 >= r5) goto L96
            java.lang.Object r7 = r13.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            long r8 = r7.getId()
            long r10 = r1.getId()
            boolean r8 = androidx.compose.ui.input.pointer.PointerId.m5589equalsimpl0(r8, r10)
            if (r8 == 0) goto L93
            boolean r7 = r7.getPressed()
            if (r7 == 0) goto L93
            goto L57
        L93:
            int r6 = r6 + 1
            goto L76
        L96:
            kotlin.jvm.functions.Function0<kotlin.Unit> r12 = r12.$onUp
            r12.invoke()
        L9b:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.PressDownGestureKt$detectPressDownGesture$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
