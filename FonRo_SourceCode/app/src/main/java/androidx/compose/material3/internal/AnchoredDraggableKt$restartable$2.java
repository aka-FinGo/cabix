package androidx.compose.material3.internal;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "I", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2", f = "AnchoredDraggable.kt", i = {}, l = {715}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class AnchoredDraggableKt$restartable$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Function0<I> $inputs;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AnchoredDraggableKt$restartable$2(Function0<? extends I> function0, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnchoredDraggableKt$restartable$2> continuation) {
        super(2, continuation);
        this.$inputs = function0;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AnchoredDraggableKt$restartable$2 anchoredDraggableKt$restartable$2 = new AnchoredDraggableKt$restartable$2(this.$inputs, this.$block, continuation);
        anchoredDraggableKt$restartable$2.L$0 = obj;
        return anchoredDraggableKt$restartable$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnchoredDraggableKt$restartable$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            this.label = 1;
            if (SnapshotStateKt.snapshotFlow(this.$inputs).collect(new AnonymousClass1(objectRef, coroutineScope, this.$block), this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "I", "latestInputs", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* renamed from: androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ CoroutineScope $$this$coroutineScope;
        final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Ref.ObjectRef<Job> $previousDrag;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Ref.ObjectRef<Job> objectRef, CoroutineScope coroutineScope, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2) {
            this.$previousDrag = objectRef;
            this.$$this$coroutineScope = coroutineScope;
            this.$block = function2;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(I r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$emit$1
                if (r0 == 0) goto L14
                r0 = r9
                androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$emit$1 r0 = (androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r9 = r0.label
                int r9 = r9 - r2
                r0.label = r9
                goto L19
            L14:
                androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$emit$1 r0 = new androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$emit$1
                r0.<init>(r7, r9)
            L19:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L3f
                if (r2 != r3) goto L37
                java.lang.Object r7 = r0.L$2
                kotlinx.coroutines.Job r7 = (kotlinx.coroutines.Job) r7
                java.lang.Object r7 = r0.L$1
                java.lang.Object r8 = r0.L$0
                androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1 r8 = (androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2.AnonymousClass1) r8
                kotlin.ResultKt.throwOnFailure(r9)
                r6 = r8
                r8 = r7
                r7 = r6
                goto L63
            L37:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L3f:
                kotlin.ResultKt.throwOnFailure(r9)
                kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.Job> r9 = r7.$previousDrag
                T r9 = r9.element
                kotlinx.coroutines.Job r9 = (kotlinx.coroutines.Job) r9
                if (r9 == 0) goto L63
                androidx.compose.material3.internal.AnchoredDragFinishedSignal r2 = new androidx.compose.material3.internal.AnchoredDragFinishedSignal
                r2.<init>()
                java.util.concurrent.CancellationException r2 = (java.util.concurrent.CancellationException) r2
                r9.cancel(r2)
                r0.L$0 = r7
                r0.L$1 = r8
                r0.L$2 = r9
                r0.label = r3
                java.lang.Object r9 = r9.join(r0)
                if (r9 != r1) goto L63
                return r1
            L63:
                kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.Job> r9 = r7.$previousDrag
                kotlinx.coroutines.CoroutineScope r0 = r7.$$this$coroutineScope
                kotlinx.coroutines.CoroutineStart r2 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$2 r1 = new androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$2
                kotlin.jvm.functions.Function2<I, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r3 = r7.$block
                kotlinx.coroutines.CoroutineScope r7 = r7.$$this$coroutineScope
                r4 = 0
                r1.<init>(r3, r8, r7, r4)
                r3 = r1
                kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
                r4 = 1
                r5 = 0
                r1 = 0
                kotlinx.coroutines.Job r7 = kotlinx.coroutines.BuildersKt.launch$default(r0, r1, r2, r3, r4, r5)
                r9.element = r7
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AnchoredDraggable.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "I", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(c = "androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$2", f = "AnchoredDraggable.kt", i = {}, l = {722}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2$1$2, reason: invalid class name */
        /* loaded from: classes4.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
            final /* synthetic */ I $latestInputs;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2, I i, CoroutineScope coroutineScope, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$block = function2;
                this.$latestInputs = i;
                this.$$this$coroutineScope = coroutineScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$block, this.$latestInputs, this.$$this$coroutineScope, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function2<I, Continuation<? super Unit>, Object> function2 = this.$block;
                    I i2 = this.$latestInputs;
                    this.label = 1;
                    if (function2.invoke(i2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                CoroutineScopeKt.cancel(this.$$this$coroutineScope, new AnchoredDragFinishedSignal());
                return Unit.INSTANCE;
            }
        }
    }
}
