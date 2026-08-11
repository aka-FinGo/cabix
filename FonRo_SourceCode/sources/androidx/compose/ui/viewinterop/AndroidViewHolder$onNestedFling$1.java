package androidx.compose.ui.viewinterop;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidViewHolder.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedFling$1", f = "AndroidViewHolder.android.kt", i = {}, l = {639, 641}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class AndroidViewHolder$onNestedFling$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $consumed;
    final /* synthetic */ long $viewVelocity;
    int label;
    final /* synthetic */ AndroidViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder$onNestedFling$1(boolean z, AndroidViewHolder androidViewHolder, long j, Continuation<? super AndroidViewHolder$onNestedFling$1> continuation) {
        super(2, continuation);
        this.$consumed = z;
        this.this$0 = androidViewHolder;
        this.$viewVelocity = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidViewHolder$onNestedFling$1(this.$consumed, this.this$0, this.$viewVelocity, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AndroidViewHolder$onNestedFling$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        if (r4.m5481dispatchPostFlingRZ2iAVY(androidx.compose.ui.unit.Velocity.INSTANCE.m7238getZero9UxMQ8M(), r10.$viewVelocity, r10) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0054, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
    
        if (r1.m5481dispatchPostFlingRZ2iAVY(r10.$viewVelocity, androidx.compose.ui.unit.Velocity.INSTANCE.m7238getZero9UxMQ8M(), r10) == r0) goto L17;
     */
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
            if (r1 == 0) goto L1b
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L17:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L55
        L1b:
            kotlin.ResultKt.throwOnFailure(r11)
            boolean r11 = r10.$consumed
            androidx.compose.ui.viewinterop.AndroidViewHolder r1 = r10.this$0
            if (r11 != 0) goto L3c
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r4 = androidx.compose.ui.viewinterop.AndroidViewHolder.access$getDispatcher$p(r1)
            androidx.compose.ui.unit.Velocity$Companion r11 = androidx.compose.ui.unit.Velocity.INSTANCE
            long r5 = r11.m7238getZero9UxMQ8M()
            long r7 = r10.$viewVelocity
            r9 = r10
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r10.label = r3
            java.lang.Object r10 = r4.m5481dispatchPostFlingRZ2iAVY(r5, r7, r9)
            if (r10 != r0) goto L55
            goto L54
        L3c:
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r1 = androidx.compose.ui.viewinterop.AndroidViewHolder.access$getDispatcher$p(r1)
            r11 = r2
            long r2 = r10.$viewVelocity
            androidx.compose.ui.unit.Velocity$Companion r4 = androidx.compose.ui.unit.Velocity.INSTANCE
            long r4 = r4.m7238getZero9UxMQ8M()
            r6 = r10
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r10.label = r11
            java.lang.Object r10 = r1.m5481dispatchPostFlingRZ2iAVY(r2, r4, r6)
            if (r10 != r0) goto L55
        L54:
            return r0
        L55:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedFling$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
