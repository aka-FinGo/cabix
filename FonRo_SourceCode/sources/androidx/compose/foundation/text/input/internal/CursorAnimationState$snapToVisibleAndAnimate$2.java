package androidx.compose.foundation.text.input.internal;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CursorAnimationState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2", f = "CursorAnimationState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class CursorAnimationState$snapToVisibleAndAnimate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CursorAnimationState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CursorAnimationState$snapToVisibleAndAnimate$2(CursorAnimationState cursorAnimationState, Continuation<? super CursorAnimationState$snapToVisibleAndAnimate$2> continuation) {
        super(2, continuation);
        this.this$0 = cursorAnimationState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CursorAnimationState$snapToVisibleAndAnimate$2 cursorAnimationState$snapToVisibleAndAnimate$2 = new CursorAnimationState$snapToVisibleAndAnimate$2(this.this$0, continuation);
        cursorAnimationState$snapToVisibleAndAnimate$2.L$0 = obj;
        return cursorAnimationState$snapToVisibleAndAnimate$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((CursorAnimationState$snapToVisibleAndAnimate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AtomicReference atomicReference;
        AtomicReference atomicReference2;
        Job launch$default;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            atomicReference = this.this$0.animationJob;
            Job job = (Job) atomicReference.getAndSet(null);
            atomicReference2 = this.this$0.animationJob;
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(job, this.this$0, null), 3, null);
            return Boxing.boxBoolean(PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference2, null, launch$default));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CursorAnimationState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2$1", f = "CursorAnimationState.kt", i = {}, l = {72, 77, 79, 81}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $oldJob;
        int label;
        final /* synthetic */ CursorAnimationState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Job job, CursorAnimationState cursorAnimationState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$oldJob = job;
            this.this$0 = cursorAnimationState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$oldJob, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0080, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(500, r10) == r0) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0044, code lost:
        
            if (kotlinx.coroutines.JobKt.cancelAndJoin(r11, r10) == r0) goto L35;
         */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0071  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0080 -> B:9:0x0083). Please report as a decompilation issue!!! */
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
                r2 = 500(0x1f4, double:2.47E-321)
                r4 = 1065353216(0x3f800000, float:1.0)
                r5 = 0
                r6 = 4
                r7 = 3
                r8 = 2
                r9 = 1
                if (r1 == 0) goto L34
                if (r1 == r9) goto L30
                if (r1 == r8) goto L2a
                if (r1 == r7) goto L26
                if (r1 != r6) goto L1d
                kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L2e
                goto L83
            L1d:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L26:
                kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L2e
                goto L72
            L2a:
                kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L2e
                goto L60
            L2e:
                r11 = move-exception
                goto L89
            L30:
                kotlin.ResultKt.throwOnFailure(r11)
                goto L47
            L34:
                kotlin.ResultKt.throwOnFailure(r11)
                kotlinx.coroutines.Job r11 = r10.$oldJob
                if (r11 == 0) goto L47
                r1 = r10
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r10.label = r9
                java.lang.Object r11 = kotlinx.coroutines.JobKt.cancelAndJoin(r11, r1)
                if (r11 != r0) goto L47
                goto L82
            L47:
                androidx.compose.foundation.text.input.internal.CursorAnimationState r11 = r10.this$0     // Catch: java.lang.Throwable -> L2e
                androidx.compose.foundation.text.input.internal.CursorAnimationState.access$setCursorAlpha(r11, r4)     // Catch: java.lang.Throwable -> L2e
                androidx.compose.foundation.text.input.internal.CursorAnimationState r11 = r10.this$0     // Catch: java.lang.Throwable -> L2e
                boolean r11 = r11.getAnimate()     // Catch: java.lang.Throwable -> L2e
                if (r11 != 0) goto L66
                r11 = r10
                kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch: java.lang.Throwable -> L2e
                r10.label = r8     // Catch: java.lang.Throwable -> L2e
                java.lang.Object r11 = kotlinx.coroutines.DelayKt.awaitCancellation(r11)     // Catch: java.lang.Throwable -> L2e
                if (r11 != r0) goto L60
                goto L82
            L60:
                kotlin.KotlinNothingValueException r11 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L2e
                r11.<init>()     // Catch: java.lang.Throwable -> L2e
                throw r11     // Catch: java.lang.Throwable -> L2e
            L66:
                r11 = r10
                kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch: java.lang.Throwable -> L2e
                r10.label = r7     // Catch: java.lang.Throwable -> L2e
                java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r2, r11)     // Catch: java.lang.Throwable -> L2e
                if (r11 != r0) goto L72
                goto L82
            L72:
                androidx.compose.foundation.text.input.internal.CursorAnimationState r11 = r10.this$0     // Catch: java.lang.Throwable -> L2e
                androidx.compose.foundation.text.input.internal.CursorAnimationState.access$setCursorAlpha(r11, r5)     // Catch: java.lang.Throwable -> L2e
                r11 = r10
                kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch: java.lang.Throwable -> L2e
                r10.label = r6     // Catch: java.lang.Throwable -> L2e
                java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r2, r11)     // Catch: java.lang.Throwable -> L2e
                if (r11 != r0) goto L83
            L82:
                return r0
            L83:
                androidx.compose.foundation.text.input.internal.CursorAnimationState r11 = r10.this$0     // Catch: java.lang.Throwable -> L2e
                androidx.compose.foundation.text.input.internal.CursorAnimationState.access$setCursorAlpha(r11, r4)     // Catch: java.lang.Throwable -> L2e
                goto L66
            L89:
                androidx.compose.foundation.text.input.internal.CursorAnimationState r10 = r10.this$0
                androidx.compose.foundation.text.input.internal.CursorAnimationState.access$setCursorAlpha(r10, r5)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.CursorAnimationState$snapToVisibleAndAnimate$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
