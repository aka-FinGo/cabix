package androidx.work.impl;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.Logger;
import androidx.work.impl.WorkerWrapper;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WorkerWrapper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.work.impl.WorkerWrapper$launch$1", f = "WorkerWrapper.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class WorkerWrapper$launch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ WorkerWrapper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkerWrapper$launch$1(WorkerWrapper workerWrapper, Continuation<? super WorkerWrapper$launch$1> continuation) {
        super(2, continuation);
        this.this$0 = workerWrapper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkerWrapper$launch$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((WorkerWrapper$launch$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        final WorkerWrapper.Resolution.Failed failed;
        WorkDatabase workDatabase;
        CompletableJob completableJob;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                completableJob = this.this$0.workerJob;
                this.label = 1;
                obj = BuildersKt.withContext(completableJob, new WorkerWrapper$launch$1$resolution$1(this.this$0, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            failed = (WorkerWrapper.Resolution) obj;
        } catch (WorkerStoppedException e) {
            failed = new WorkerWrapper.Resolution.ResetWorkerStatus(e.getReason());
        } catch (CancellationException unused) {
            failed = new WorkerWrapper.Resolution.Failed(null, 1, null);
        } catch (Throwable th) {
            str = WorkerWrapperKt.TAG;
            Logger.get().error(str, "Unexpected error in WorkerWrapper", th);
            failed = new WorkerWrapper.Resolution.Failed(null, 1, null);
        }
        workDatabase = this.this$0.workDatabase;
        final WorkerWrapper workerWrapper = this.this$0;
        Object runInTransaction = workDatabase.runInTransaction((Callable<Object>) new Callable() { // from class: androidx.work.impl.WorkerWrapper$launch$1$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return WorkerWrapper$launch$1.invokeSuspend$lambda$1(WorkerWrapper.Resolution.this, workerWrapper);
            }
        });
        Intrinsics.checkNotNullExpressionValue(runInTransaction, "workDatabase.runInTransa…          }\n            )");
        return runInTransaction;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Boolean invokeSuspend$lambda$1(WorkerWrapper.Resolution resolution, WorkerWrapper workerWrapper) {
        boolean resetWorkerStatus;
        if (resolution instanceof WorkerWrapper.Resolution.Finished) {
            resetWorkerStatus = workerWrapper.onWorkFinished(((WorkerWrapper.Resolution.Finished) resolution).getResult());
        } else if (resolution instanceof WorkerWrapper.Resolution.Failed) {
            workerWrapper.setFailed(((WorkerWrapper.Resolution.Failed) resolution).getResult());
            resetWorkerStatus = false;
        } else {
            if (!(resolution instanceof WorkerWrapper.Resolution.ResetWorkerStatus)) {
                throw new NoWhenBranchMatchedException();
            }
            resetWorkerStatus = workerWrapper.resetWorkerStatus(((WorkerWrapper.Resolution.ResetWorkerStatus) resolution).getReason());
        }
        return Boolean.valueOf(resetWorkerStatus);
    }
}
