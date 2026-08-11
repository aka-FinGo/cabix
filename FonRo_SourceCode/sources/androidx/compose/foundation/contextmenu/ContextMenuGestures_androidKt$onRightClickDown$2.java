package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContextMenuGestures.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt$onRightClickDown$2", f = "ContextMenuGestures.android.kt", i = {0}, l = {58, LockFreeTaskQueueCore.CLOSED_SHIFT}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"})
/* loaded from: classes.dex */
public final class ContextMenuGestures_androidKt$onRightClickDown$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Offset, Unit> $onDown;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContextMenuGestures_androidKt$onRightClickDown$2(Function1<? super Offset, Unit> function1, Continuation<? super ContextMenuGestures_androidKt$onRightClickDown$2> continuation) {
        super(2, continuation);
        this.$onDown = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ContextMenuGestures_androidKt$onRightClickDown$2 contextMenuGestures_androidKt$onRightClickDown$2 = new ContextMenuGestures_androidKt$onRightClickDown$2(this.$onDown, continuation);
        contextMenuGestures_androidKt$onRightClickDown$2.L$0 = obj;
        return contextMenuGestures_androidKt$onRightClickDown$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((ContextMenuGestures_androidKt$onRightClickDown$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0057, code lost:
    
        if (r8 == r0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        if (r8 == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L23
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5a
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1b:
            java.lang.Object r1 = r7.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L39
        L23:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            r1 = r8
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r7.L$0 = r1
            r7.label = r3
            java.lang.Object r8 = androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt.access$awaitFirstRightClickDown(r1, r8)
            if (r8 != r0) goto L39
            goto L59
        L39:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            r8.consume()
            kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r4 = r7.$onDown
            long r5 = r8.getPosition()
            androidx.compose.ui.geometry.Offset r8 = androidx.compose.ui.geometry.Offset.m4114boximpl(r5)
            r4.invoke(r8)
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r4 = 0
            r7.L$0 = r4
            r7.label = r2
            java.lang.Object r8 = androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation$default(r1, r4, r8, r3, r4)
            if (r8 != r0) goto L5a
        L59:
            return r0
        L5a:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 == 0) goto L61
            r8.consume()
        L61:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt$onRightClickDown$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
