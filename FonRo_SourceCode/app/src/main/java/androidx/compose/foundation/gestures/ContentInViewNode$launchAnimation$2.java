package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContentInViewNode.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2", f = "ContentInViewNode.kt", i = {}, l = {215}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class ContentInViewNode$launchAnimation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UpdatableAnimationState $animationState;
    final /* synthetic */ BringIntoViewSpec $bringIntoViewSpec;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ContentInViewNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentInViewNode$launchAnimation$2(ContentInViewNode contentInViewNode, UpdatableAnimationState updatableAnimationState, BringIntoViewSpec bringIntoViewSpec, Continuation<? super ContentInViewNode$launchAnimation$2> continuation) {
        super(2, continuation);
        this.this$0 = contentInViewNode;
        this.$animationState = updatableAnimationState;
        this.$bringIntoViewSpec = bringIntoViewSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ContentInViewNode$launchAnimation$2 contentInViewNode$launchAnimation$2 = new ContentInViewNode$launchAnimation$2(this.this$0, this.$animationState, this.$bringIntoViewSpec, continuation);
        contentInViewNode$launchAnimation$2.L$0 = obj;
        return contentInViewNode$launchAnimation$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ContentInViewNode$launchAnimation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ScrollingLogic scrollingLogic;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        CancellationException cancellationException = null;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Job job = JobKt.getJob(((CoroutineScope) this.L$0).getCoroutineContext());
                    this.this$0.isAnimationRunning = true;
                    scrollingLogic = this.this$0.scrollingLogic;
                    this.label = 1;
                    if (scrollingLogic.scroll(MutatePriority.Default, new AnonymousClass1(this.$animationState, this.this$0, this.$bringIntoViewSpec, job, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.this$0.bringIntoViewRequests.resumeAndRemoveAll();
                this.this$0.isAnimationRunning = false;
                this.this$0.bringIntoViewRequests.cancelAndRemoveAll(null);
                this.this$0.trackingFocusedChild = false;
                return Unit.INSTANCE;
            } catch (CancellationException e) {
                cancellationException = e;
                throw cancellationException;
            }
        } catch (Throwable th) {
            this.this$0.isAnimationRunning = false;
            this.this$0.bringIntoViewRequests.cancelAndRemoveAll(cancellationException);
            this.this$0.trackingFocusedChild = false;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ContentInViewNode.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1", f = "ContentInViewNode.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $animationJob;
        final /* synthetic */ UpdatableAnimationState $animationState;
        final /* synthetic */ BringIntoViewSpec $bringIntoViewSpec;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ContentInViewNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UpdatableAnimationState updatableAnimationState, ContentInViewNode contentInViewNode, BringIntoViewSpec bringIntoViewSpec, Job job, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$animationState = updatableAnimationState;
            this.this$0 = contentInViewNode;
            this.$bringIntoViewSpec = bringIntoViewSpec;
            this.$animationJob = job;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$animationState, this.this$0, this.$bringIntoViewSpec, this.$animationJob, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(NestedScrollScope nestedScrollScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(nestedScrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            float calculateScrollDelta;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final NestedScrollScope nestedScrollScope = (NestedScrollScope) this.L$0;
                UpdatableAnimationState updatableAnimationState = this.$animationState;
                calculateScrollDelta = this.this$0.calculateScrollDelta(this.$bringIntoViewSpec);
                updatableAnimationState.setValue(calculateScrollDelta);
                UpdatableAnimationState updatableAnimationState2 = this.$animationState;
                final ContentInViewNode contentInViewNode = this.this$0;
                final UpdatableAnimationState updatableAnimationState3 = this.$animationState;
                final Job job = this.$animationJob;
                Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewNode.launchAnimation.2.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                        invoke(f.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f) {
                        boolean z;
                        ScrollingLogic scrollingLogic;
                        z = ContentInViewNode.this.reverseDirection;
                        float f2 = z ? 1.0f : -1.0f;
                        scrollingLogic = ContentInViewNode.this.scrollingLogic;
                        float m838toFloatk4lQ0M = f2 * scrollingLogic.m838toFloatk4lQ0M(scrollingLogic.m836reverseIfNeededMKHz9U(nestedScrollScope.mo792scrollByOzD1aCk(scrollingLogic.m836reverseIfNeededMKHz9U(scrollingLogic.m839toOffsettuRUvjQ(f2 * f)), NestedScrollSource.INSTANCE.m5500getUserInputWNlRxjI())));
                        if (Math.abs(m838toFloatk4lQ0M) < Math.abs(f)) {
                            JobKt__JobKt.cancel$default(job, "Scroll animation cancelled because scroll was not consumed (" + m838toFloatk4lQ0M + " < " + f + ')', null, 2, null);
                        }
                    }
                };
                final ContentInViewNode contentInViewNode2 = this.this$0;
                final UpdatableAnimationState updatableAnimationState4 = this.$animationState;
                final BringIntoViewSpec bringIntoViewSpec = this.$bringIntoViewSpec;
                this.label = 1;
                if (updatableAnimationState2.animateToZero(function1, new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewNode.launchAnimation.2.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:12:0x0062, code lost:
                    
                        r2 = r1.getFocusedChildBounds();
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final void invoke2() {
                        /*
                            r8 = this;
                            androidx.compose.foundation.gestures.ContentInViewNode r0 = androidx.compose.foundation.gestures.ContentInViewNode.this
                            androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue r0 = androidx.compose.foundation.gestures.ContentInViewNode.access$getBringIntoViewRequests$p(r0)
                            androidx.compose.foundation.gestures.ContentInViewNode r1 = androidx.compose.foundation.gestures.ContentInViewNode.this
                        L8:
                            androidx.compose.runtime.collection.MutableVector r2 = androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue.access$getRequests$p(r0)
                            int r2 = r2.getSize()
                            r7 = 1
                            if (r2 == 0) goto L5a
                            androidx.compose.runtime.collection.MutableVector r2 = androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue.access$getRequests$p(r0)
                            java.lang.Object r2 = r2.last()
                            androidx.compose.foundation.gestures.ContentInViewNode$Request r2 = (androidx.compose.foundation.gestures.ContentInViewNode.Request) r2
                            kotlin.jvm.functions.Function0 r2 = r2.getCurrentBounds()
                            java.lang.Object r2 = r2.invoke()
                            androidx.compose.ui.geometry.Rect r2 = (androidx.compose.ui.geometry.Rect) r2
                            if (r2 != 0) goto L2b
                            r2 = r7
                            goto L33
                        L2b:
                            r5 = 1
                            r6 = 0
                            r3 = 0
                            boolean r2 = androidx.compose.foundation.gestures.ContentInViewNode.m731isMaxVisibleO0kMr_c$default(r1, r2, r3, r5, r6)
                        L33:
                            if (r2 == 0) goto L5a
                            androidx.compose.runtime.collection.MutableVector r2 = androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue.access$getRequests$p(r0)
                            androidx.compose.runtime.collection.MutableVector r3 = androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue.access$getRequests$p(r0)
                            int r3 = r3.getSize()
                            int r3 = r3 - r7
                            java.lang.Object r2 = r2.removeAt(r3)
                            androidx.compose.foundation.gestures.ContentInViewNode$Request r2 = (androidx.compose.foundation.gestures.ContentInViewNode.Request) r2
                            kotlinx.coroutines.CancellableContinuation r2 = r2.getContinuation()
                            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                            kotlin.Unit r3 = kotlin.Unit.INSTANCE
                            kotlin.Result$Companion r4 = kotlin.Result.INSTANCE
                            java.lang.Object r3 = kotlin.Result.m7870constructorimpl(r3)
                            r2.resumeWith(r3)
                            goto L8
                        L5a:
                            androidx.compose.foundation.gestures.ContentInViewNode r0 = androidx.compose.foundation.gestures.ContentInViewNode.this
                            boolean r0 = androidx.compose.foundation.gestures.ContentInViewNode.access$getTrackingFocusedChild$p(r0)
                            if (r0 == 0) goto L7c
                            androidx.compose.foundation.gestures.ContentInViewNode r0 = androidx.compose.foundation.gestures.ContentInViewNode.this
                            androidx.compose.ui.geometry.Rect r2 = androidx.compose.foundation.gestures.ContentInViewNode.access$getFocusedChildBounds(r0)
                            if (r2 == 0) goto L7c
                            androidx.compose.foundation.gestures.ContentInViewNode r1 = androidx.compose.foundation.gestures.ContentInViewNode.this
                            r5 = 1
                            r6 = 0
                            r3 = 0
                            boolean r0 = androidx.compose.foundation.gestures.ContentInViewNode.m731isMaxVisibleO0kMr_c$default(r1, r2, r3, r5, r6)
                            if (r0 != r7) goto L7c
                            androidx.compose.foundation.gestures.ContentInViewNode r0 = androidx.compose.foundation.gestures.ContentInViewNode.this
                            r1 = 0
                            androidx.compose.foundation.gestures.ContentInViewNode.access$setTrackingFocusedChild$p(r0, r1)
                        L7c:
                            androidx.compose.foundation.gestures.UpdatableAnimationState r0 = r2
                            androidx.compose.foundation.gestures.ContentInViewNode r1 = androidx.compose.foundation.gestures.ContentInViewNode.this
                            androidx.compose.foundation.gestures.BringIntoViewSpec r8 = r3
                            float r8 = androidx.compose.foundation.gestures.ContentInViewNode.access$calculateScrollDelta(r1, r8)
                            r0.setValue(r8)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2.AnonymousClass1.AnonymousClass2.invoke2():void");
                    }
                }, this) == coroutine_suspended) {
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
