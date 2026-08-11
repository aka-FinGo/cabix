package androidx.compose.foundation.gestures;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MouseWheelScrollable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1", f = "MouseWheelScrollable.kt", i = {0, 1}, l = {107, 110}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
/* loaded from: classes.dex */
public final class MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MouseWheelScrollingLogic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1(MouseWheelScrollingLogic mouseWheelScrollingLogic, Continuation<? super MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1> continuation) {
        super(2, continuation);
        this.this$0 = mouseWheelScrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1 mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1 = new MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1(this.this$0, continuation);
        mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1.L$0 = obj;
        return mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0084, code lost:
    
        if (r13 != r0) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003f A[Catch: all -> 0x0029, TRY_ENTER, TryCatch #0 {all -> 0x0029, blocks: (B:7:0x0013, B:9:0x0033, B:12:0x003f, B:18:0x0054, B:26:0x0025), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0087  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0084 -> B:8:0x0016). Please report as a decompilation issue!!! */
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
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2c
            if (r1 == r4) goto L21
            if (r1 != r3) goto L18
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Throwable -> L29
        L16:
            r13 = r1
            goto L33
        L18:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L21:
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Throwable -> L29
            goto L54
        L29:
            r0 = move-exception
            r13 = r0
            goto L8d
        L2c:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            kotlinx.coroutines.CoroutineScope r13 = (kotlinx.coroutines.CoroutineScope) r13
        L33:
            kotlin.coroutines.CoroutineContext r1 = r13.getCoroutineContext()     // Catch: java.lang.Throwable -> L29
            boolean r1 = kotlinx.coroutines.JobKt.isActive(r1)     // Catch: java.lang.Throwable -> L29
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic r5 = r12.this$0
            if (r1 == 0) goto L87
            kotlinx.coroutines.channels.Channel r1 = androidx.compose.foundation.gestures.MouseWheelScrollingLogic.access$getChannel$p(r5)     // Catch: java.lang.Throwable -> L29
            r5 = r12
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Throwable -> L29
            r12.L$0 = r13     // Catch: java.lang.Throwable -> L29
            r12.label = r4     // Catch: java.lang.Throwable -> L29
            java.lang.Object r1 = r1.receive(r5)     // Catch: java.lang.Throwable -> L29
            if (r1 != r0) goto L51
            goto L86
        L51:
            r11 = r1
            r1 = r13
            r13 = r11
        L54:
            r7 = r13
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic$MouseWheelScrollDelta r7 = (androidx.compose.foundation.gestures.MouseWheelScrollingLogic.MouseWheelScrollDelta) r7     // Catch: java.lang.Throwable -> L29
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic r13 = r12.this$0     // Catch: java.lang.Throwable -> L29
            androidx.compose.ui.unit.Density r13 = androidx.compose.foundation.gestures.MouseWheelScrollingLogic.access$getDensity$p(r13)     // Catch: java.lang.Throwable -> L29
            float r5 = androidx.compose.foundation.gestures.MouseWheelScrollableKt.access$getAnimationThreshold$p()     // Catch: java.lang.Throwable -> L29
            float r8 = r13.mo700toPx0680j_4(r5)     // Catch: java.lang.Throwable -> L29
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic r13 = r12.this$0     // Catch: java.lang.Throwable -> L29
            androidx.compose.ui.unit.Density r13 = androidx.compose.foundation.gestures.MouseWheelScrollingLogic.access$getDensity$p(r13)     // Catch: java.lang.Throwable -> L29
            float r5 = androidx.compose.foundation.gestures.MouseWheelScrollableKt.access$getAnimationSpeed$p()     // Catch: java.lang.Throwable -> L29
            float r9 = r13.mo700toPx0680j_4(r5)     // Catch: java.lang.Throwable -> L29
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic r5 = r12.this$0     // Catch: java.lang.Throwable -> L29
            androidx.compose.foundation.gestures.ScrollingLogic r6 = androidx.compose.foundation.gestures.MouseWheelScrollingLogic.access$getScrollingLogic$p(r5)     // Catch: java.lang.Throwable -> L29
            r10 = r12
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10     // Catch: java.lang.Throwable -> L29
            r12.L$0 = r1     // Catch: java.lang.Throwable -> L29
            r12.label = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r13 = androidx.compose.foundation.gestures.MouseWheelScrollingLogic.access$dispatchMouseWheelScroll(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L29
            if (r13 != r0) goto L16
        L86:
            return r0
        L87:
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic.access$setReceivingMouseWheelEventsJob$p(r5, r2)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L8d:
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic r12 = r12.this$0
            androidx.compose.foundation.gestures.MouseWheelScrollingLogic.access$setReceivingMouseWheelEventsJob$p(r12, r2)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
