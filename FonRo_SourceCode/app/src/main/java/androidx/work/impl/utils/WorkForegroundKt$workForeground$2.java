package androidx.work.impl.utils;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.impl.model.WorkSpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WorkForeground.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.work.impl.utils.WorkForegroundKt$workForeground$2", f = "WorkForeground.kt", i = {}, l = {42, 50}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class WorkForegroundKt$workForeground$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Void>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ForegroundUpdater $foregroundUpdater;
    final /* synthetic */ WorkSpec $spec;
    final /* synthetic */ ListenableWorker $worker;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkForegroundKt$workForeground$2(ListenableWorker listenableWorker, WorkSpec workSpec, ForegroundUpdater foregroundUpdater, Context context, Continuation<? super WorkForegroundKt$workForeground$2> continuation) {
        super(2, continuation);
        this.$worker = listenableWorker;
        this.$spec = workSpec;
        this.$foregroundUpdater = foregroundUpdater;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkForegroundKt$workForeground$2(this.$worker, this.$spec, this.$foregroundUpdater, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Void> continuation) {
        return ((WorkForegroundKt$workForeground$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
    
        if (r8 == r0) goto L18;
     */
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
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r8)
            return r8
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1a:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L3a
        L1e:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.work.ListenableWorker r8 = r7.$worker
            com.google.common.util.concurrent.ListenableFuture r8 = r8.getForegroundInfoAsync()
            java.lang.String r1 = "worker.getForegroundInfoAsync()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
            androidx.work.ListenableWorker r1 = r7.$worker
            r4 = r7
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r7.label = r3
            java.lang.Object r8 = androidx.work.impl.WorkerWrapperKt.awaitWithin(r8, r1, r4)
            if (r8 != r0) goto L3a
            goto L79
        L3a:
            androidx.work.ForegroundInfo r8 = (androidx.work.ForegroundInfo) r8
            if (r8 == 0) goto L7b
            java.lang.String r1 = androidx.work.impl.utils.WorkForegroundKt.access$getTAG$p()
            androidx.work.impl.model.WorkSpec r3 = r7.$spec
            androidx.work.Logger r4 = androidx.work.Logger.get()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Updating notification for "
            r5.<init>(r6)
            java.lang.String r3 = r3.workerClassName
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r4.debug(r1, r3)
            androidx.work.ForegroundUpdater r1 = r7.$foregroundUpdater
            android.content.Context r3 = r7.$context
            androidx.work.ListenableWorker r4 = r7.$worker
            java.util.UUID r4 = r4.getId()
            com.google.common.util.concurrent.ListenableFuture r8 = r1.setForegroundAsync(r3, r4, r8)
            java.lang.String r1 = "foregroundUpdater.setFor…orker.id, foregroundInfo)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
            r1 = r7
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r7.label = r2
            java.lang.Object r7 = androidx.concurrent.futures.ListenableFutureKt.await(r8, r1)
            if (r7 != r0) goto L7a
        L79:
            return r0
        L7a:
            return r7
        L7b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "Worker was marked important ("
            r8.<init>(r0)
            androidx.work.impl.model.WorkSpec r7 = r7.$spec
            java.lang.String r7 = r7.workerClassName
            r8.append(r7)
            java.lang.String r7 = ") but did not provide ForegroundInfo"
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.WorkForegroundKt$workForeground$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
