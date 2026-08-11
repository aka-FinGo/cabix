package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
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
@DebugMetadata(c = "androidx.compose.foundation.AbstractClickableNode$handlePressInteraction$2$1$delayJob$1", f = "Clickable.kt", i = {1}, l = {1257, 1260}, m = "invokeSuspend", n = {"press"}, s = {"L$0"})
/* loaded from: classes.dex */
final class AbstractClickableNode$handlePressInteraction$2$1$delayJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $offset;
    Object L$0;
    int label;
    final /* synthetic */ AbstractClickableNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractClickableNode$handlePressInteraction$2$1$delayJob$1(AbstractClickableNode abstractClickableNode, long j, MutableInteractionSource mutableInteractionSource, Continuation<? super AbstractClickableNode$handlePressInteraction$2$1$delayJob$1> continuation) {
        super(2, continuation);
        this.this$0 = abstractClickableNode;
        this.$offset = j;
        this.$interactionSource = mutableInteractionSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AbstractClickableNode$handlePressInteraction$2$1$delayJob$1(this.this$0, this.$offset, this.$interactionSource, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AbstractClickableNode$handlePressInteraction$2$1$delayJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(androidx.compose.foundation.Clickable_androidKt.getTapIndicationDelay(), r6) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L23
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L16
            java.lang.Object r0 = r6.L$0
            androidx.compose.foundation.interaction.PressInteraction$Press r0 = (androidx.compose.foundation.interaction.PressInteraction.Press) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5a
        L16:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1f:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L3e
        L23:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.compose.foundation.AbstractClickableNode r7 = r6.this$0
            boolean r7 = androidx.compose.foundation.AbstractClickableNode.access$delayPressInteraction(r7)
            if (r7 == 0) goto L3e
            long r4 = androidx.compose.foundation.Clickable_androidKt.getTapIndicationDelay()
            r7 = r6
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r6.label = r3
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r7)
            if (r7 != r0) goto L3e
            goto L58
        L3e:
            androidx.compose.foundation.interaction.PressInteraction$Press r7 = new androidx.compose.foundation.interaction.PressInteraction$Press
            long r3 = r6.$offset
            r1 = 0
            r7.<init>(r3, r1)
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = r6.$interactionSource
            r3 = r7
            androidx.compose.foundation.interaction.Interaction r3 = (androidx.compose.foundation.interaction.Interaction) r3
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6.L$0 = r7
            r6.label = r2
            java.lang.Object r1 = r1.emit(r3, r4)
            if (r1 != r0) goto L59
        L58:
            return r0
        L59:
            r0 = r7
        L5a:
            androidx.compose.foundation.AbstractClickableNode r6 = r6.this$0
            androidx.compose.foundation.AbstractClickableNode.access$setPressInteraction$p(r6, r0)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AbstractClickableNode$handlePressInteraction$2$1$delayJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
