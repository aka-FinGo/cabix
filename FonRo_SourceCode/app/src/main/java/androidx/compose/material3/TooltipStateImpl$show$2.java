package androidx.compose.material3;

import androidx.compose.foundation.MutatePriority;
import androidx.constraintlayout.core.motion.utils.TypedValues;
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

/* compiled from: Tooltip.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.material3.TooltipStateImpl$show$2", f = "Tooltip.kt", i = {}, l = {TypedValues.PositionType.TYPE_PERCENT_HEIGHT, TypedValues.PositionType.TYPE_PERCENT_X}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class TooltipStateImpl$show$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $cancellableShow;
    final /* synthetic */ MutatePriority $mutatePriority;
    int label;
    final /* synthetic */ TooltipStateImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TooltipStateImpl$show$2(TooltipStateImpl tooltipStateImpl, Function1<? super Continuation<? super Unit>, ? extends Object> function1, MutatePriority mutatePriority, Continuation<? super TooltipStateImpl$show$2> continuation) {
        super(1, continuation);
        this.this$0 = tooltipStateImpl;
        this.$cancellableShow = function1;
        this.$mutatePriority = mutatePriority;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TooltipStateImpl$show$2(this.this$0, this.$cancellableShow, this.$mutatePriority, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TooltipStateImpl$show$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        if (kotlinx.coroutines.TimeoutKt.withTimeout(1500, new androidx.compose.material3.TooltipStateImpl$show$2.AnonymousClass1(r4.$cancellableShow, null), r4) == r0) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
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
            if (r1 == 0) goto L1d
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L17:
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L1b
            goto L4b
        L1b:
            r5 = move-exception
            goto L59
        L1d:
            kotlin.ResultKt.throwOnFailure(r5)
            androidx.compose.material3.TooltipStateImpl r5 = r4.this$0     // Catch: java.lang.Throwable -> L1b
            boolean r5 = r5.getIsPersistent()     // Catch: java.lang.Throwable -> L1b
            if (r5 == 0) goto L33
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r5 = r4.$cancellableShow     // Catch: java.lang.Throwable -> L1b
            r4.label = r3     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r5 = r5.invoke(r4)     // Catch: java.lang.Throwable -> L1b
            if (r5 != r0) goto L4b
            goto L4a
        L33:
            androidx.compose.material3.TooltipStateImpl$show$2$1 r5 = new androidx.compose.material3.TooltipStateImpl$show$2$1     // Catch: java.lang.Throwable -> L1b
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r1 = r4.$cancellableShow     // Catch: java.lang.Throwable -> L1b
            r3 = 0
            r5.<init>(r1, r3)     // Catch: java.lang.Throwable -> L1b
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch: java.lang.Throwable -> L1b
            r1 = r4
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch: java.lang.Throwable -> L1b
            r4.label = r2     // Catch: java.lang.Throwable -> L1b
            r2 = 1500(0x5dc, double:7.41E-321)
            java.lang.Object r5 = kotlinx.coroutines.TimeoutKt.withTimeout(r2, r5, r1)     // Catch: java.lang.Throwable -> L1b
            if (r5 != r0) goto L4b
        L4a:
            return r0
        L4b:
            androidx.compose.foundation.MutatePriority r5 = r4.$mutatePriority
            androidx.compose.foundation.MutatePriority r0 = androidx.compose.foundation.MutatePriority.PreventUserInput
            if (r5 == r0) goto L56
            androidx.compose.material3.TooltipStateImpl r4 = r4.this$0
            r4.dismiss()
        L56:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L59:
            androidx.compose.foundation.MutatePriority r0 = r4.$mutatePriority
            androidx.compose.foundation.MutatePriority r1 = androidx.compose.foundation.MutatePriority.PreventUserInput
            if (r0 == r1) goto L64
            androidx.compose.material3.TooltipStateImpl r4 = r4.this$0
            r4.dismiss()
        L64:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TooltipStateImpl$show$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Tooltip.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.material3.TooltipStateImpl$show$2$1", f = "Tooltip.kt", i = {}, l = {TypedValues.PositionType.TYPE_PERCENT_X}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.TooltipStateImpl$show$2$1, reason: invalid class name */
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
