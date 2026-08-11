package androidx.compose.material3.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BasicTooltip.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltipStateImpl$show$2", f = "BasicTooltip.kt", i = {}, l = {152, 154}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class BasicTooltipStateImpl$show$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $cancellableShow;
    int label;
    final /* synthetic */ BasicTooltipStateImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BasicTooltipStateImpl$show$2(BasicTooltipStateImpl basicTooltipStateImpl, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super BasicTooltipStateImpl$show$2> continuation) {
        super(1, continuation);
        this.this$0 = basicTooltipStateImpl;
        this.$cancellableShow = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new BasicTooltipStateImpl$show$2(this.this$0, this.$cancellableShow, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((BasicTooltipStateImpl$show$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
    
        if (kotlinx.coroutines.TimeoutKt.withTimeout(1500, new androidx.compose.material3.internal.BasicTooltipStateImpl$show$2.AnonymousClass1(r5.$cancellableShow, null), r5) == r0) goto L21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [kotlin.Unit, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L1e
            if (r1 == r4) goto L18
            if (r1 != r3) goto L10
            goto L18
        L10:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L18:
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L1c
            goto L4c
        L1c:
            r6 = move-exception
            goto L54
        L1e:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.compose.material3.internal.BasicTooltipStateImpl r6 = r5.this$0     // Catch: java.lang.Throwable -> L1c
            boolean r6 = r6.getIsPersistent()     // Catch: java.lang.Throwable -> L1c
            if (r6 == 0) goto L34
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r6 = r5.$cancellableShow     // Catch: java.lang.Throwable -> L1c
            r5.label = r4     // Catch: java.lang.Throwable -> L1c
            java.lang.Object r6 = r6.invoke(r5)     // Catch: java.lang.Throwable -> L1c
            if (r6 != r0) goto L4c
            goto L4b
        L34:
            androidx.compose.material3.internal.BasicTooltipStateImpl$show$2$1 r6 = new androidx.compose.material3.internal.BasicTooltipStateImpl$show$2$1     // Catch: java.lang.Throwable -> L1c
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r1 = r5.$cancellableShow     // Catch: java.lang.Throwable -> L1c
            r4 = 0
            r6.<init>(r1, r4)     // Catch: java.lang.Throwable -> L1c
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch: java.lang.Throwable -> L1c
            r1 = r5
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch: java.lang.Throwable -> L1c
            r5.label = r3     // Catch: java.lang.Throwable -> L1c
            r3 = 1500(0x5dc, double:7.41E-321)
            java.lang.Object r6 = kotlinx.coroutines.TimeoutKt.withTimeout(r3, r6, r1)     // Catch: java.lang.Throwable -> L1c
            if (r6 != r0) goto L4c
        L4b:
            return r0
        L4c:
            androidx.compose.material3.internal.BasicTooltipStateImpl r5 = r5.this$0
            r5.setVisible(r2)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L54:
            androidx.compose.material3.internal.BasicTooltipStateImpl r5 = r5.this$0
            r5.setVisible(r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltipStateImpl$show$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BasicTooltip.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltipStateImpl$show$2$1", f = "BasicTooltip.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.internal.BasicTooltipStateImpl$show$2$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $cancellableShow;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$cancellableShow = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$cancellableShow, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<Continuation<? super Unit>, Object> function1 = this.$cancellableShow;
                this.label = 1;
                if (function1.invoke(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
