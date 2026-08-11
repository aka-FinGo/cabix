package androidx.compose.material3.internal;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.material3.TooltipState;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: BasicTooltip.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1", f = "BasicTooltip.android.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class BasicTooltip_androidKt$handleGestures$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TooltipState $state;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicTooltip_androidKt$handleGestures$1(TooltipState tooltipState, Continuation<? super BasicTooltip_androidKt$handleGestures$1> continuation) {
        super(2, continuation);
        this.$state = tooltipState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BasicTooltip_androidKt$handleGestures$1 basicTooltip_androidKt$handleGestures$1 = new BasicTooltip_androidKt$handleGestures$1(this.$state, continuation);
        basicTooltip_androidKt$handleGestures$1.L$0 = obj;
        return basicTooltip_androidKt$handleGestures$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((BasicTooltip_androidKt$handleGestures$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BasicTooltip.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1", f = "BasicTooltip.android.kt", i = {}, l = {163}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerInputScope $$this$pointerInput;
        final /* synthetic */ TooltipState $state;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PointerInputScope pointerInputScope, TooltipState tooltipState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$$this$pointerInput = pointerInputScope;
            this.$state = tooltipState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$pointerInput, this.$state, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BasicTooltip.android.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1", f = "BasicTooltip.android.kt", i = {0, 0, 0, 0, 1, 1, 1, 2}, l = {171, 177, 197}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "isLongPressedFlow", "pass", "longPressTimeout", "$this$awaitEachGesture", "isLongPressedFlow", "pass", "isLongPressedFlow"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$0"})
        /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C00471 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ TooltipState $state;
            long J$0;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00471(CoroutineScope coroutineScope, TooltipState tooltipState, Continuation<? super C00471> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.$state = tooltipState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00471 c00471 = new C00471(this.$$this$coroutineScope, this.$state, continuation);
                c00471.L$0 = obj;
                return c00471;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((C00471) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
            
                if (r5 == r1) goto L38;
             */
            /* JADX WARN: Removed duplicated region for block: B:12:0x00fe A[Catch: all -> 0x0021, TRY_LEAVE, TryCatch #0 {all -> 0x0021, blocks: (B:8:0x001a, B:10:0x00fa, B:12:0x00fe), top: B:7:0x001a }] */
            /* JADX WARN: Removed duplicated region for block: B:32:0x00f9  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r18) {
                /*
                    Method dump skipped, instructions count: 275
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1.AnonymousClass1.C00471.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: BasicTooltip.android.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$1", f = "BasicTooltip.android.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: classes4.dex */
            public static final class C00481 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
                final /* synthetic */ PointerEventPass $pass;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00481(PointerEventPass pointerEventPass, Continuation<? super C00481> continuation) {
                    super(2, continuation);
                    this.$pass = pointerEventPass;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00481 c00481 = new C00481(this.$pass, continuation);
                    c00481.L$0 = obj;
                    return c00481;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
                    return ((C00481) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i != 0) {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object waitForUpOrCancellation = TapGestureDetectorKt.waitForUpOrCancellation((AwaitPointerEventScope) this.L$0, this.$pass, this);
                    return waitForUpOrCancellation == coroutine_suspended ? coroutine_suspended : waitForUpOrCancellation;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: BasicTooltip.android.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2", f = "BasicTooltip.android.kt", i = {}, l = {ModuleDescriptor.MODULE_VERSION, 187, 187}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2, reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ MutableStateFlow<Boolean> $isLongPressedFlow;
                final /* synthetic */ TooltipState $state;
                Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(MutableStateFlow<Boolean> mutableStateFlow, TooltipState tooltipState, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$isLongPressedFlow = mutableStateFlow;
                    this.$state = tooltipState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.$isLongPressedFlow, this.$state, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:17:0x005e, code lost:
                
                    if (r7 == r0) goto L26;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:18:0x007e, code lost:
                
                    return r0;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
                
                    if (r7.$state.show(androidx.compose.foundation.MutatePriority.PreventUserInput, r7) == r0) goto L26;
                 */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r3v0 */
                /* JADX WARN: Type inference failed for: r3v2, types: [androidx.compose.material3.TooltipState] */
                /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object] */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                    /*
                        r7 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r7.label
                        r2 = 0
                        r3 = 3
                        r4 = 2
                        r5 = 1
                        if (r1 == 0) goto L2c
                        if (r1 == r5) goto L26
                        if (r1 == r4) goto L22
                        if (r1 == r3) goto L1a
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L1a:
                        java.lang.Object r7 = r7.L$0
                        java.lang.Throwable r7 = (java.lang.Throwable) r7
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L80
                    L22:
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L61
                    L26:
                        kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L2a
                        goto L48
                    L2a:
                        r8 = move-exception
                        goto L64
                    L2c:
                        kotlin.ResultKt.throwOnFailure(r8)
                        kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r8 = r7.$isLongPressedFlow     // Catch: java.lang.Throwable -> L2a
                        java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)     // Catch: java.lang.Throwable -> L2a
                        r8.tryEmit(r1)     // Catch: java.lang.Throwable -> L2a
                        androidx.compose.material3.TooltipState r8 = r7.$state     // Catch: java.lang.Throwable -> L2a
                        androidx.compose.foundation.MutatePriority r1 = androidx.compose.foundation.MutatePriority.PreventUserInput     // Catch: java.lang.Throwable -> L2a
                        r6 = r7
                        kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.lang.Throwable -> L2a
                        r7.label = r5     // Catch: java.lang.Throwable -> L2a
                        java.lang.Object r8 = r8.show(r1, r6)     // Catch: java.lang.Throwable -> L2a
                        if (r8 != r0) goto L48
                        goto L7e
                    L48:
                        kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r8 = r7.$isLongPressedFlow
                        kotlinx.coroutines.flow.Flow r8 = (kotlinx.coroutines.flow.Flow) r8
                        androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1 r1 = new androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1
                        androidx.compose.material3.TooltipState r3 = r7.$state
                        r1.<init>(r3, r2)
                        kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                        r2 = r7
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        r7.label = r4
                        java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.collectLatest(r8, r1, r2)
                        if (r7 != r0) goto L61
                        goto L7e
                    L61:
                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                        return r7
                    L64:
                        kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r1 = r7.$isLongPressedFlow
                        kotlinx.coroutines.flow.Flow r1 = (kotlinx.coroutines.flow.Flow) r1
                        androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1 r4 = new androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1
                        androidx.compose.material3.TooltipState r5 = r7.$state
                        r4.<init>(r5, r2)
                        kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
                        r2 = r7
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        r7.L$0 = r8
                        r7.label = r3
                        java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.collectLatest(r1, r4, r2)
                        if (r7 != r0) goto L7f
                    L7e:
                        return r0
                    L7f:
                        r7 = r8
                    L80:
                        throw r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1.AnonymousClass1.C00471.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: BasicTooltip.android.kt */
                @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "isLongPressed", ""}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1", f = "BasicTooltip.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.material3.internal.BasicTooltip_androidKt$handleGestures$1$1$1$2$1, reason: invalid class name and collision with other inner class name */
                /* loaded from: classes4.dex */
                public static final class C00491 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
                    final /* synthetic */ TooltipState $state;
                    /* synthetic */ boolean Z$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00491(TooltipState tooltipState, Continuation<? super C00491> continuation) {
                        super(2, continuation);
                        this.$state = tooltipState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C00491 c00491 = new C00491(this.$state, continuation);
                        c00491.Z$0 = ((Boolean) obj).booleanValue();
                        return c00491;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
                        return invoke(bool.booleanValue(), continuation);
                    }

                    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
                        return ((C00491) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        if (!this.Z$0) {
                            this.$state.dismiss();
                        }
                        return Unit.INSTANCE;
                    }
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture(this.$$this$pointerInput, new C00471(coroutineScope, this.$state, null), this) == coroutine_suspended) {
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

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(new AnonymousClass1((PointerInputScope) this.L$0, this.$state, null), this) == coroutine_suspended) {
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
