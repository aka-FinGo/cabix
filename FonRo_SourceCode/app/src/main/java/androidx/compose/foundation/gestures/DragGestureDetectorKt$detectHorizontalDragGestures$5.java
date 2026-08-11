package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DragGestureDetector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5", f = "DragGestureDetector.kt", i = {0, 1, 1}, l = {661, 664, 672}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "overSlop"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: classes.dex */
public final class DragGestureDetectorKt$detectHorizontalDragGestures$5 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function0<Unit> $onDragEnd;
    final /* synthetic */ Function1<Offset, Unit> $onDragStart;
    final /* synthetic */ Function2<PointerInputChange, Float, Unit> $onHorizontalDrag;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DragGestureDetectorKt$detectHorizontalDragGestures$5(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super DragGestureDetectorKt$detectHorizontalDragGestures$5> continuation) {
        super(2, continuation);
        this.$onDragStart = function1;
        this.$onHorizontalDrag = function2;
        this.$onDragEnd = function0;
        this.$onDragCancel = function02;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectHorizontalDragGestures$5 dragGestureDetectorKt$detectHorizontalDragGestures$5 = new DragGestureDetectorKt$detectHorizontalDragGestures$5(this.$onDragStart, this.$onHorizontalDrag, this.$onDragEnd, this.$onDragCancel, continuation);
        dragGestureDetectorKt$detectHorizontalDragGestures$5.L$0 = obj;
        return dragGestureDetectorKt$detectHorizontalDragGestures$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectHorizontalDragGestures$5) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ae, code lost:
    
        if (r12 == r0) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L34
            if (r1 == r4) goto L2b
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L16
            kotlin.ResultKt.throwOnFailure(r12)
            goto Lb1
        L16:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L1f:
            java.lang.Object r1 = r11.L$1
            kotlin.jvm.internal.Ref$FloatRef r1 = (kotlin.jvm.internal.Ref.FloatRef) r1
            java.lang.Object r3 = r11.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
            kotlin.ResultKt.throwOnFailure(r12)
            goto L77
        L2b:
            java.lang.Object r1 = r11.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r12)
            r4 = r1
            goto L4f
        L34:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            r5 = r12
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            r8 = r11
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r11.L$0 = r5
            r11.label = r4
            r6 = 0
            r7 = 0
            r9 = 2
            r10 = 0
            java.lang.Object r12 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)
            if (r12 != r0) goto L4e
            goto Lb0
        L4e:
            r4 = r5
        L4f:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            kotlin.jvm.internal.Ref$FloatRef r1 = new kotlin.jvm.internal.Ref$FloatRef
            r1.<init>()
            long r5 = r12.getId()
            int r7 = r12.getType()
            androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$drag$1 r12 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$drag$1
            r12.<init>()
            r8 = r12
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r9 = r11
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r11.L$0 = r4
            r11.L$1 = r1
            r11.label = r3
            java.lang.Object r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m744awaitHorizontalPointerSlopOrCancellationgDDlDlE(r4, r5, r7, r8, r9)
            if (r12 != r0) goto L76
            goto Lb0
        L76:
            r3 = r4
        L77:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            if (r12 == 0) goto Lc4
            kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r4 = r11.$onDragStart
            long r5 = r12.getPosition()
            androidx.compose.ui.geometry.Offset r5 = androidx.compose.ui.geometry.Offset.m4114boximpl(r5)
            r4.invoke(r5)
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float, kotlin.Unit> r4 = r11.$onHorizontalDrag
            float r1 = r1.element
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)
            r4.invoke(r12, r1)
            long r4 = r12.getId()
            androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1 r12 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float, kotlin.Unit> r1 = r11.$onHorizontalDrag
            r12.<init>()
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            r1 = r11
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6 = 0
            r11.L$0 = r6
            r11.L$1 = r6
            r11.label = r2
            java.lang.Object r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m757horizontalDragjO51t88(r3, r4, r12, r1)
            if (r12 != r0) goto Lb1
        Lb0:
            return r0
        Lb1:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto Lbf
            kotlin.jvm.functions.Function0<kotlin.Unit> r11 = r11.$onDragEnd
            r11.invoke()
            goto Lc4
        Lbf:
            kotlin.jvm.functions.Function0<kotlin.Unit> r11 = r11.$onDragCancel
            r11.invoke()
        Lc4:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
