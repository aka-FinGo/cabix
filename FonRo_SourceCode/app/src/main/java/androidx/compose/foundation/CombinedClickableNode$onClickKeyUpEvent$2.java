package androidx.compose.foundation;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Clickable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.CombinedClickableNode$onClickKeyUpEvent$2", f = "Clickable.kt", i = {0, 0}, l = {908, 912}, m = "invokeSuspend", n = {"minTime", "timeout"}, s = {"J$0", "J$1"})
/* loaded from: classes.dex */
final class CombinedClickableNode$onClickKeyUpEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $keyCode;
    long J$0;
    long J$1;
    int label;
    final /* synthetic */ CombinedClickableNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombinedClickableNode$onClickKeyUpEvent$2(CombinedClickableNode combinedClickableNode, long j, Continuation<? super CombinedClickableNode$onClickKeyUpEvent$2> continuation) {
        super(2, continuation);
        this.this$0 = combinedClickableNode;
        this.$keyCode = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CombinedClickableNode$onClickKeyUpEvent$2(this.this$0, this.$keyCode, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombinedClickableNode$onClickKeyUpEvent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006c, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r4 - r6, r10) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006e, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r6, r10) == r0) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L23
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r11)
            goto L6f
        L12:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L1b:
            long r4 = r10.J$1
            long r6 = r10.J$0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L4e
        L23:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.compose.foundation.CombinedClickableNode r11 = r10.this$0
            androidx.compose.ui.node.CompositionLocalConsumerModifierNode r11 = (androidx.compose.ui.node.CompositionLocalConsumerModifierNode) r11
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            java.lang.Object r11 = androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt.currentValueOf(r11, r1)
            androidx.compose.ui.platform.ViewConfiguration r11 = (androidx.compose.ui.platform.ViewConfiguration) r11
            long r6 = r11.getDoubleTapMinTimeMillis()
            long r4 = r11.getDoubleTapTimeoutMillis()
            r11 = r10
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r10.J$0 = r6
            r10.J$1 = r4
            r10.label = r3
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r6, r11)
            if (r11 != r0) goto L4e
            goto L6e
        L4e:
            androidx.compose.foundation.CombinedClickableNode r11 = r10.this$0
            androidx.collection.MutableLongObjectMap r11 = androidx.compose.foundation.CombinedClickableNode.access$getDoubleKeyClickStates$p(r11)
            long r8 = r10.$keyCode
            java.lang.Object r11 = r11.get(r8)
            androidx.compose.foundation.CombinedClickableNode$DoubleKeyClickState r11 = (androidx.compose.foundation.CombinedClickableNode.DoubleKeyClickState) r11
            if (r11 != 0) goto L5f
            goto L62
        L5f:
            r11.setDoubleTapMinTimeMillisElapsed(r3)
        L62:
            long r4 = r4 - r6
            r11 = r10
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r10.label = r2
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r4, r11)
            if (r11 != r0) goto L6f
        L6e:
            return r0
        L6f:
            androidx.compose.foundation.CombinedClickableNode r10 = r10.this$0
            kotlin.jvm.functions.Function0 r10 = r10.getOnClick()
            r10.invoke()
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.CombinedClickableNode$onClickKeyUpEvent$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
