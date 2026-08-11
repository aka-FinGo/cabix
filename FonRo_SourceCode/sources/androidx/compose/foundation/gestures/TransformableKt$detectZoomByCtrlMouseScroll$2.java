package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Transformable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$detectZoomByCtrlMouseScroll$2", f = "Transformable.kt", i = {0, 1}, l = {272, 284}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope"}, s = {"L$0", "L$0"})
/* loaded from: classes.dex */
public final class TransformableKt$detectZoomByCtrlMouseScroll$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<TransformEvent> $channel;
    final /* synthetic */ CoroutineContext $currentContext;
    final /* synthetic */ ScrollConfig $scrollConfig;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransformableKt$detectZoomByCtrlMouseScroll$2(CoroutineContext coroutineContext, ScrollConfig scrollConfig, Channel<TransformEvent> channel, Continuation<? super TransformableKt$detectZoomByCtrlMouseScroll$2> continuation) {
        super(2, continuation);
        this.$currentContext = coroutineContext;
        this.$scrollConfig = scrollConfig;
        this.$channel = channel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransformableKt$detectZoomByCtrlMouseScroll$2 transformableKt$detectZoomByCtrlMouseScroll$2 = new TransformableKt$detectZoomByCtrlMouseScroll$2(this.$currentContext, this.$scrollConfig, this.$channel, continuation);
        transformableKt$detectZoomByCtrlMouseScroll$2.L$0 = obj;
        return transformableKt$detectZoomByCtrlMouseScroll$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((TransformableKt$detectZoomByCtrlMouseScroll$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x008f, code lost:
    
        if (r13 == r0) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c A[Catch: all -> 0x0028, TRY_ENTER, TryCatch #0 {all -> 0x0028, blocks: (B:7:0x0012, B:8:0x0092, B:10:0x0096, B:11:0x0059, B:18:0x003c, B:21:0x004c, B:28:0x0024), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ab  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x008f -> B:8:0x0092). Please report as a decompilation issue!!! */
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
            if (r1 == 0) goto L2c
            if (r1 == r3) goto L20
            if (r1 != r2) goto L17
            java.lang.Object r1 = r12.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Throwable -> L28
            goto L92
        L17:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L20:
            java.lang.Object r1 = r12.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Throwable -> L28
            goto L4c
        L28:
            r0 = move-exception
            r13 = r0
            goto La3
        L2c:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            r1 = r13
        L34:
            kotlin.coroutines.CoroutineContext r13 = r12.$currentContext
            boolean r13 = kotlinx.coroutines.JobKt.isActive(r13)
            if (r13 == 0) goto Lab
            androidx.compose.foundation.gestures.ScrollConfig r13 = r12.$scrollConfig     // Catch: java.lang.Throwable -> L28
            r4 = r12
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch: java.lang.Throwable -> L28
            r12.L$0 = r1     // Catch: java.lang.Throwable -> L28
            r12.label = r3     // Catch: java.lang.Throwable -> L28
            java.lang.Object r13 = androidx.compose.foundation.gestures.TransformableKt.access$awaitFirstCtrlMouseScroll(r1, r13, r4)     // Catch: java.lang.Throwable -> L28
            if (r13 != r0) goto L4c
            goto L91
        L4c:
            androidx.compose.ui.geometry.Offset r13 = (androidx.compose.ui.geometry.Offset) r13     // Catch: java.lang.Throwable -> L28
            long r4 = r13.m4135unboximpl()     // Catch: java.lang.Throwable -> L28
            kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r13 = r12.$channel     // Catch: java.lang.Throwable -> L28
            androidx.compose.foundation.gestures.TransformEvent$TransformStarted r6 = androidx.compose.foundation.gestures.TransformEvent.TransformStarted.INSTANCE     // Catch: java.lang.Throwable -> L28
            r13.mo9440trySendJP2dKIU(r6)     // Catch: java.lang.Throwable -> L28
        L59:
            r6 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r4 = r4 & r6
            int r13 = (int) r4     // Catch: java.lang.Throwable -> L28
            float r13 = java.lang.Float.intBitsToFloat(r13)     // Catch: java.lang.Throwable -> L28
            r4 = 1141391360(0x44084000, float:545.0)
            float r13 = r13 / r4
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r6 = (double) r13     // Catch: java.lang.Throwable -> L28
            double r4 = java.lang.Math.pow(r4, r6)     // Catch: java.lang.Throwable -> L28
            float r7 = (float) r4     // Catch: java.lang.Throwable -> L28
            kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r13 = r12.$channel     // Catch: java.lang.Throwable -> L28
            androidx.compose.foundation.gestures.TransformEvent$TransformDelta r6 = new androidx.compose.foundation.gestures.TransformEvent$TransformDelta     // Catch: java.lang.Throwable -> L28
            androidx.compose.ui.geometry.Offset$Companion r4 = androidx.compose.ui.geometry.Offset.INSTANCE     // Catch: java.lang.Throwable -> L28
            long r8 = r4.m4141getZeroF1C5BW0()     // Catch: java.lang.Throwable -> L28
            r10 = 0
            r11 = 0
            r6.<init>(r7, r8, r10, r11)     // Catch: java.lang.Throwable -> L28
            r13.mo9440trySendJP2dKIU(r6)     // Catch: java.lang.Throwable -> L28
            androidx.compose.foundation.gestures.ScrollConfig r13 = r12.$scrollConfig     // Catch: java.lang.Throwable -> L28
            r4 = r12
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch: java.lang.Throwable -> L28
            r12.L$0 = r1     // Catch: java.lang.Throwable -> L28
            r12.label = r2     // Catch: java.lang.Throwable -> L28
            java.lang.Object r13 = androidx.compose.foundation.gestures.TransformableKt.access$awaitCtrlMouseScrollOrNull(r1, r13, r4)     // Catch: java.lang.Throwable -> L28
            if (r13 != r0) goto L92
        L91:
            return r0
        L92:
            androidx.compose.ui.geometry.Offset r13 = (androidx.compose.ui.geometry.Offset) r13     // Catch: java.lang.Throwable -> L28
            if (r13 == 0) goto L9b
            long r4 = r13.m4135unboximpl()     // Catch: java.lang.Throwable -> L28
            goto L59
        L9b:
            kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r13 = r12.$channel
            androidx.compose.foundation.gestures.TransformEvent$TransformStopped r4 = androidx.compose.foundation.gestures.TransformEvent.TransformStopped.INSTANCE
            r13.mo9440trySendJP2dKIU(r4)
            goto L34
        La3:
            kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r12 = r12.$channel
            androidx.compose.foundation.gestures.TransformEvent$TransformStopped r0 = androidx.compose.foundation.gestures.TransformEvent.TransformStopped.INSTANCE
            r12.mo9440trySendJP2dKIU(r0)
            throw r13
        Lab:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt$detectZoomByCtrlMouseScroll$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
