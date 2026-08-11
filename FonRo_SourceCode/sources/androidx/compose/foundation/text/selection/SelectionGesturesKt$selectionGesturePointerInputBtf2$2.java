package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SelectionGestures.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGesturePointerInputBtf2$2", f = "SelectionGestures.kt", i = {0}, l = {209, 217, 220, 221}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"})
/* loaded from: classes.dex */
public final class SelectionGesturesKt$selectionGesturePointerInputBtf2$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ClicksCounter $clicksCounter;
    final /* synthetic */ MouseSelectionObserver $mouseSelectionObserver;
    final /* synthetic */ TextDragObserver $textDragObserver;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectionGesturesKt$selectionGesturePointerInputBtf2$2(ClicksCounter clicksCounter, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation<? super SelectionGesturesKt$selectionGesturePointerInputBtf2$2> continuation) {
        super(2, continuation);
        this.$clicksCounter = clicksCounter;
        this.$mouseSelectionObserver = mouseSelectionObserver;
        this.$textDragObserver = textDragObserver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SelectionGesturesKt$selectionGesturePointerInputBtf2$2 selectionGesturesKt$selectionGesturePointerInputBtf2$2 = new SelectionGesturesKt$selectionGesturePointerInputBtf2$2(this.$clicksCounter, this.$mouseSelectionObserver, this.$textDragObserver, continuation);
        selectionGesturesKt$selectionGesturePointerInputBtf2$2.L$0 = obj;
        return selectionGesturesKt$selectionGesturePointerInputBtf2$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((SelectionGesturesKt$selectionGesturePointerInputBtf2$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0087, code lost:
    
        if (r12 == r0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b1, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
    
        if (r12 == r0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00af, code lost:
    
        if (r12 == r0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x003e, code lost:
    
        if (r13 == r0) goto L37;
     */
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
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L2b
            if (r1 == r5) goto L23
            if (r1 == r4) goto L1e
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L15
            goto L1e
        L15:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L1e:
            kotlin.ResultKt.throwOnFailure(r13)
            goto Lb2
        L23:
            java.lang.Object r1 = r12.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto L42
        L2b:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            r1 = r13
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            r13 = r12
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
            r12.L$0 = r1
            r12.label = r5
            java.lang.Object r13 = androidx.compose.foundation.text.selection.SelectionGesturesKt.access$awaitDown(r1, r13)
            if (r13 != r0) goto L42
            goto Lb1
        L42:
            androidx.compose.ui.input.pointer.PointerEvent r13 = (androidx.compose.ui.input.pointer.PointerEvent) r13
            androidx.compose.foundation.text.selection.ClicksCounter r6 = r12.$clicksCounter
            r6.update(r13)
            boolean r6 = androidx.compose.foundation.text.selection.SelectionGesturesKt.isPrecisePointer(r13)
            r7 = 0
            if (r6 == 0) goto L8a
            int r8 = r13.getButtons()
            boolean r8 = androidx.compose.ui.input.pointer.PointerEvent_androidKt.m5580isPrimaryPressedaHzCxE(r8)
            if (r8 == 0) goto L8a
            java.util.List r8 = r13.getChanges()
            r9 = r8
            java.util.Collection r9 = (java.util.Collection) r9
            int r9 = r9.size()
            r10 = 0
        L66:
            if (r10 >= r9) goto L78
            java.lang.Object r11 = r8.get(r10)
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.isConsumed()
            if (r11 == 0) goto L75
            goto L8a
        L75:
            int r10 = r10 + 1
            goto L66
        L78:
            androidx.compose.foundation.text.selection.MouseSelectionObserver r2 = r12.$mouseSelectionObserver
            androidx.compose.foundation.text.selection.ClicksCounter r3 = r12.$clicksCounter
            r5 = r12
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r12.L$0 = r7
            r12.label = r4
            java.lang.Object r12 = androidx.compose.foundation.text.selection.SelectionGesturesKt.access$mouseSelectionBtf2(r1, r2, r3, r13, r5)
            if (r12 != r0) goto Lb2
            goto Lb1
        L8a:
            if (r6 != 0) goto Lb2
            androidx.compose.foundation.text.selection.ClicksCounter r4 = r12.$clicksCounter
            int r4 = r4.getClicks()
            androidx.compose.foundation.text.TextDragObserver r6 = r12.$textDragObserver
            if (r4 != r5) goto La4
            r2 = r12
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r12.L$0 = r7
            r12.label = r3
            java.lang.Object r12 = androidx.compose.foundation.text.selection.SelectionGesturesKt.access$touchSelectionFirstPress(r1, r6, r13, r2)
            if (r12 != r0) goto Lb2
            goto Lb1
        La4:
            r3 = r12
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r12.L$0 = r7
            r12.label = r2
            java.lang.Object r12 = androidx.compose.foundation.text.selection.SelectionGesturesKt.access$touchSelectionSubsequentPress(r1, r6, r13, r3)
            if (r12 != r0) goto Lb2
        Lb1:
            return r0
        Lb2:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGesturePointerInputBtf2$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
