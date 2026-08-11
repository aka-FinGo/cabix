package androidx.compose.material3.pulltorefresh;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PullToRefresh.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$update$1", f = "PullToRefresh.kt", i = {}, l = {333, 335}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class PullToRefreshModifierNode$update$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PullToRefreshModifierNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshModifierNode$update$1(PullToRefreshModifierNode pullToRefreshModifierNode, Continuation<? super PullToRefreshModifierNode$update$1> continuation) {
        super(2, continuation);
        this.this$0 = pullToRefreshModifierNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PullToRefreshModifierNode$update$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PullToRefreshModifierNode$update$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
    
        if (r4 == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        if (r4 == r0) goto L17;
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
            if (r1 == 0) goto L1b
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L17:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L40
        L1b:
            kotlin.ResultKt.throwOnFailure(r5)
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r5 = r4.this$0
            boolean r5 = r5.getIsRefreshing()
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r1 = r4.this$0
            if (r5 != 0) goto L34
            r5 = r4
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r4.label = r3
            java.lang.Object r4 = androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.access$animateToHidden(r1, r5)
            if (r4 != r0) goto L40
            goto L3f
        L34:
            r5 = r4
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r4.label = r2
            java.lang.Object r4 = androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.access$animateToThreshold(r1, r5)
            if (r4 != r0) goto L40
        L3f:
            return r0
        L40:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$update$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
