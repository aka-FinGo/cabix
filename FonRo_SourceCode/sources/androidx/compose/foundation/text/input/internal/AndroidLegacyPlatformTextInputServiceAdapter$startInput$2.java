package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.ui.platform.PlatformTextInputSession;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LegacyPlatformTextInputServiceAdapter.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/PlatformTextInputSession;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2", f = "LegacyPlatformTextInputServiceAdapter.android.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class AndroidLegacyPlatformTextInputServiceAdapter$startInput$2 extends SuspendLambda implements Function2<PlatformTextInputSession, Continuation<?>, Object> {
    final /* synthetic */ Function1<LegacyTextInputMethodRequest, Unit> $initializeRequest;
    final /* synthetic */ LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode $node;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AndroidLegacyPlatformTextInputServiceAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AndroidLegacyPlatformTextInputServiceAdapter$startInput$2(Function1<? super LegacyTextInputMethodRequest, Unit> function1, AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter, LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode legacyPlatformTextInputNode, Continuation<? super AndroidLegacyPlatformTextInputServiceAdapter$startInput$2> continuation) {
        super(2, continuation);
        this.$initializeRequest = function1;
        this.this$0 = androidLegacyPlatformTextInputServiceAdapter;
        this.$node = legacyPlatformTextInputNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidLegacyPlatformTextInputServiceAdapter$startInput$2 androidLegacyPlatformTextInputServiceAdapter$startInput$2 = new AndroidLegacyPlatformTextInputServiceAdapter$startInput$2(this.$initializeRequest, this.this$0, this.$node, continuation);
        androidLegacyPlatformTextInputServiceAdapter$startInput$2.L$0 = obj;
        return androidLegacyPlatformTextInputServiceAdapter$startInput$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PlatformTextInputSession platformTextInputSession, Continuation<?> continuation) {
        return ((AndroidLegacyPlatformTextInputServiceAdapter$startInput$2) create(platformTextInputSession, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LegacyPlatformTextInputServiceAdapter.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1", f = "LegacyPlatformTextInputServiceAdapter.android.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ PlatformTextInputSession $$this$launchTextInputSession;
        final /* synthetic */ Function1<LegacyTextInputMethodRequest, Unit> $initializeRequest;
        final /* synthetic */ LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode $node;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AndroidLegacyPlatformTextInputServiceAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(PlatformTextInputSession platformTextInputSession, Function1<? super LegacyTextInputMethodRequest, Unit> function1, AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter, LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode legacyPlatformTextInputNode, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$$this$launchTextInputSession = platformTextInputSession;
            this.$initializeRequest = function1;
            this.this$0 = androidLegacyPlatformTextInputServiceAdapter;
            this.$node = legacyPlatformTextInputNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$launchTextInputSession, this.$initializeRequest, this.this$0, this.$node, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    InputMethodManager invoke = LegacyPlatformTextInputServiceAdapter_androidKt.getInputMethodManagerFactory().invoke(this.$$this$launchTextInputSession.getView());
                    LegacyTextInputMethodRequest legacyTextInputMethodRequest = new LegacyTextInputMethodRequest(this.$$this$launchTextInputSession.getView(), new AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1(this.$node), invoke);
                    if (StylusHandwriting_androidKt.isStylusHandwritingSupported()) {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C00251(this.this$0, invoke, null), 3, null);
                    }
                    Function1<LegacyTextInputMethodRequest, Unit> function1 = this.$initializeRequest;
                    if (function1 != null) {
                        function1.invoke(legacyTextInputMethodRequest);
                    }
                    this.this$0.currentRequest = legacyTextInputMethodRequest;
                    this.label = 1;
                    if (this.$$this$launchTextInputSession.startInputMethod(legacyTextInputMethodRequest, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            } catch (Throwable th) {
                this.this$0.currentRequest = null;
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LegacyPlatformTextInputServiceAdapter.android.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1", f = "LegacyPlatformTextInputServiceAdapter.android.kt", i = {}, l = {140, 141}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C00251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ InputMethodManager $inputMethodManager;
            int label;
            final /* synthetic */ AndroidLegacyPlatformTextInputServiceAdapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00251(AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter, InputMethodManager inputMethodManager, Continuation<? super C00251> continuation) {
                super(2, continuation);
                this.this$0 = androidLegacyPlatformTextInputServiceAdapter;
                this.$inputMethodManager = inputMethodManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00251(this.this$0, this.$inputMethodManager, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:15:0x004c, code lost:
            
                if (r5.collect(new androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2.AnonymousClass1.C00251.AnonymousClass2(), r4) == r0) goto L17;
             */
            /* JADX WARN: Code restructure failed: missing block: B:16:0x004e, code lost:
            
                return r0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
            
                if (androidx.compose.runtime.MonotonicFrameClockKt.withFrameMillis(androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2.AnonymousClass1.C00251.C00261.INSTANCE, r4) == r0) goto L17;
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
                    if (r1 == r2) goto L17
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                    r4.<init>(r5)
                    throw r4
                L17:
                    kotlin.ResultKt.throwOnFailure(r5)
                    goto L4f
                L1b:
                    kotlin.ResultKt.throwOnFailure(r5)
                    goto L32
                L1f:
                    kotlin.ResultKt.throwOnFailure(r5)
                    androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1$1 r5 = new kotlin.jvm.functions.Function1<java.lang.Long, kotlin.Unit>() { // from class: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter.startInput.2.1.1.1
                        static {
                            /*
                                androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1$1 r0 = new androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1$1
                                r0.<init>()
                                
                                // error: 0x0005: SPUT (r0 I:androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1$1) androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter.startInput.2.1.1.1.INSTANCE androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1$1
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2.AnonymousClass1.C00251.C00261.<clinit>():void");
                        }

                        {
                            /*
                                r1 = this;
                                r0 = 1
                                r1.<init>(r0)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2.AnonymousClass1.C00251.C00261.<init>():void");
                        }

                        public final void invoke(long r1) {
                            /*
                                r0 = this;
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2.AnonymousClass1.C00251.C00261.invoke(long):void");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.Long r3) {
                            /*
                                r2 = this;
                                java.lang.Number r3 = (java.lang.Number) r3
                                long r0 = r3.longValue()
                                r2.invoke(r0)
                                kotlin.Unit r2 = kotlin.Unit.INSTANCE
                                return r2
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2.AnonymousClass1.C00251.C00261.invoke(java.lang.Object):java.lang.Object");
                        }
                    }
                    kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
                    r1 = r4
                    kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                    r4.label = r3
                    java.lang.Object r5 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameMillis(r5, r1)
                    if (r5 != r0) goto L32
                    goto L4e
                L32:
                    androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter r5 = r4.this$0
                    kotlinx.coroutines.flow.MutableSharedFlow r5 = androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter.access$getStylusHandwritingTrigger(r5)
                    if (r5 == 0) goto L55
                    androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1$2 r1 = new androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1$2
                    androidx.compose.foundation.text.input.internal.InputMethodManager r3 = r4.$inputMethodManager
                    r1.<init>()
                    kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                    r3 = r4
                    kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                    r4.label = r2
                    java.lang.Object r4 = r5.collect(r1, r3)
                    if (r4 != r0) goto L4f
                L4e:
                    return r0
                L4f:
                    kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
                    r4.<init>()
                    throw r4
                L55:
                    kotlin.Unit r4 = kotlin.Unit.INSTANCE
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2.AnonymousClass1.C00251.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(new AnonymousClass1((PlatformTextInputSession) this.L$0, this.$initializeRequest, this.this$0, this.$node, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
