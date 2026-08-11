package androidx.compose.foundation;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BasicMarquee.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.MarqueeModifierNode$restartAnimation$1", f = "BasicMarquee.kt", i = {}, l = {379, 380}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class MarqueeModifierNode$restartAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Job $oldJob;
    int label;
    final /* synthetic */ MarqueeModifierNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeModifierNode$restartAnimation$1(Job job, MarqueeModifierNode marqueeModifierNode, Continuation<? super MarqueeModifierNode$restartAnimation$1> continuation) {
        super(2, continuation);
        this.$oldJob = job;
        this.this$0 = marqueeModifierNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MarqueeModifierNode$restartAnimation$1(this.$oldJob, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MarqueeModifierNode$restartAnimation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
    
        if (r4 == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        if (r5.join(r4) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1f
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r5)
            goto L40
        L12:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L1b:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L32
        L1f:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlinx.coroutines.Job r5 = r4.$oldJob
            if (r5 == 0) goto L32
            r1 = r4
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4.label = r3
            java.lang.Object r5 = r5.join(r1)
            if (r5 != r0) goto L32
            goto L3f
        L32:
            androidx.compose.foundation.MarqueeModifierNode r5 = r4.this$0
            r1 = r4
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4.label = r2
            java.lang.Object r4 = androidx.compose.foundation.MarqueeModifierNode.access$runAnimation(r5, r1)
            if (r4 != r0) goto L40
        L3f:
            return r0
        L40:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MarqueeModifierNode$restartAnimation$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
