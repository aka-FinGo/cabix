package androidx.work.impl;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WorkerWrapper.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Landroidx/work/ListenableWorker$Result;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.work.impl.WorkerWrapper$runWorker$result$1", f = "WorkerWrapper.kt", i = {}, l = {300, 311}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class WorkerWrapper$runWorker$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {
    final /* synthetic */ ForegroundUpdater $foregroundUpdater;
    final /* synthetic */ ListenableWorker $worker;
    int label;
    final /* synthetic */ WorkerWrapper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkerWrapper$runWorker$result$1(WorkerWrapper workerWrapper, ListenableWorker listenableWorker, ForegroundUpdater foregroundUpdater, Continuation<? super WorkerWrapper$runWorker$result$1> continuation) {
        super(2, continuation);
        this.this$0 = workerWrapper;
        this.$worker = listenableWorker;
        this.$foregroundUpdater = foregroundUpdater;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkerWrapper$runWorker$result$1(this.this$0, this.$worker, this.$foregroundUpdater, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ListenableWorker.Result> continuation) {
        return ((WorkerWrapper$runWorker$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
    
        if (androidx.work.impl.utils.WorkForegroundKt.workForeground(r4, r5, r6, r7, r8, r10) == r0) goto L16;
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
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r11)
            return r11
        L12:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L1a:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L43
        L1e:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.work.impl.WorkerWrapper r11 = r10.this$0
            android.content.Context r4 = androidx.work.impl.WorkerWrapper.access$getAppContext$p(r11)
            androidx.work.impl.WorkerWrapper r11 = r10.this$0
            androidx.work.impl.model.WorkSpec r5 = r11.getWorkSpec()
            androidx.work.ListenableWorker r6 = r10.$worker
            androidx.work.ForegroundUpdater r7 = r10.$foregroundUpdater
            androidx.work.impl.WorkerWrapper r11 = r10.this$0
            androidx.work.impl.utils.taskexecutor.TaskExecutor r8 = androidx.work.impl.WorkerWrapper.access$getWorkTaskExecutor$p(r11)
            r9 = r10
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r10.label = r3
            java.lang.Object r11 = androidx.work.impl.utils.WorkForegroundKt.workForeground(r4, r5, r6, r7, r8, r9)
            if (r11 != r0) goto L43
            goto L7c
        L43:
            java.lang.String r11 = androidx.work.impl.WorkerWrapperKt.access$getTAG$p()
            androidx.work.impl.WorkerWrapper r1 = r10.this$0
            androidx.work.Logger r3 = androidx.work.Logger.get()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Starting work for "
            r4.<init>(r5)
            androidx.work.impl.model.WorkSpec r1 = r1.getWorkSpec()
            java.lang.String r1 = r1.workerClassName
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r3.debug(r11, r1)
            androidx.work.ListenableWorker r11 = r10.$worker
            com.google.common.util.concurrent.ListenableFuture r11 = r11.startWork()
            java.lang.String r1 = "worker.startWork()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r1)
            androidx.work.ListenableWorker r1 = r10.$worker
            r3 = r10
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r10.label = r2
            java.lang.Object r10 = androidx.work.impl.WorkerWrapperKt.awaitWithin(r11, r1, r3)
            if (r10 != r0) goto L7d
        L7c:
            return r0
        L7d:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.WorkerWrapper$runWorker$result$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
