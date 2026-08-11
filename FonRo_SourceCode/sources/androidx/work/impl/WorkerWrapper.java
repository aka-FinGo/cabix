package androidx.work.impl;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.Clock;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.ListenableFutureKt;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

/* compiled from: WorkerWrapper.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0002>?B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010(\u001a\u00020\u00152\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0007J\u0010\u00101\u001a\u00020.2\u0006\u0010#\u001a\u00020\u0015H\u0002J\f\u00102\u001a\b\u0012\u0004\u0012\u00020*03J\u0010\u00104\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u00105\u001a\u00020*2\u0006\u0010/\u001a\u000200H\u0002J\b\u00106\u001a\u00020*H\u0002J\u0010\u00107\u001a\u00020*2\u0006\u0010/\u001a\u000200H\u0002J\u000e\u00108\u001a\u000209H\u0082@¢\u0006\u0002\u0010:J\u0010\u0010;\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0007J\u0010\u0010<\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010=\u001a\u00020*H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Landroidx/work/impl/WorkerWrapper;", "", "builder", "Landroidx/work/impl/WorkerWrapper$Builder;", "(Landroidx/work/impl/WorkerWrapper$Builder;)V", "appContext", "Landroid/content/Context;", "builderWorker", "Landroidx/work/ListenableWorker;", "clock", "Landroidx/work/Clock;", "configuration", "Landroidx/work/Configuration;", "dependencyDao", "Landroidx/work/impl/model/DependencyDao;", "foregroundProcessor", "Landroidx/work/impl/foreground/ForegroundProcessor;", "runtimeExtras", "Landroidx/work/WorkerParameters$RuntimeExtras;", "tags", "", "", "workDatabase", "Landroidx/work/impl/WorkDatabase;", "workDescription", "workGenerationalId", "Landroidx/work/impl/model/WorkGenerationalId;", "getWorkGenerationalId", "()Landroidx/work/impl/model/WorkGenerationalId;", "workSpec", "Landroidx/work/impl/model/WorkSpec;", "getWorkSpec", "()Landroidx/work/impl/model/WorkSpec;", "workSpecDao", "Landroidx/work/impl/model/WorkSpecDao;", "workSpecId", "workTaskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "workerJob", "Lkotlinx/coroutines/CompletableJob;", "createWorkDescription", "handleResult", "", "result", "Landroidx/work/ListenableWorker$Result;", "interrupt", "", "stopReason", "", "iterativelyFailWorkAndDependents", "launch", "Lcom/google/common/util/concurrent/ListenableFuture;", "onWorkFinished", "reschedule", "resetPeriodic", "resetWorkerStatus", "runWorker", "Landroidx/work/impl/WorkerWrapper$Resolution;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFailed", "setSucceeded", "trySetRunning", "Builder", "Resolution", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class WorkerWrapper {
    private final Context appContext;
    private final ListenableWorker builderWorker;
    private final Clock clock;
    private final Configuration configuration;
    private final DependencyDao dependencyDao;
    private final ForegroundProcessor foregroundProcessor;
    private final WorkerParameters.RuntimeExtras runtimeExtras;
    private final List<String> tags;
    private final WorkDatabase workDatabase;
    private final String workDescription;
    private final WorkSpec workSpec;
    private final WorkSpecDao workSpecDao;
    private final String workSpecId;
    private final TaskExecutor workTaskExecutor;
    private final CompletableJob workerJob;

    public WorkerWrapper(Builder builder) {
        CompletableJob Job$default;
        Intrinsics.checkNotNullParameter(builder, "builder");
        WorkSpec workSpec = builder.getWorkSpec();
        this.workSpec = workSpec;
        this.appContext = builder.getAppContext();
        this.workSpecId = workSpec.id;
        this.runtimeExtras = builder.getRuntimeExtras();
        this.builderWorker = builder.getWorker();
        this.workTaskExecutor = builder.getWorkTaskExecutor();
        Configuration configuration = builder.getConfiguration();
        this.configuration = configuration;
        this.clock = configuration.getClock();
        this.foregroundProcessor = builder.getForegroundProcessor();
        WorkDatabase workDatabase = builder.getWorkDatabase();
        this.workDatabase = workDatabase;
        this.workSpecDao = workDatabase.workSpecDao();
        this.dependencyDao = workDatabase.dependencyDao();
        List<String> tags = builder.getTags();
        this.tags = tags;
        this.workDescription = createWorkDescription(tags);
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.workerJob = Job$default;
    }

    public final WorkSpec getWorkSpec() {
        return this.workSpec;
    }

    public final WorkGenerationalId getWorkGenerationalId() {
        return WorkSpecKt.generationalId(this.workSpec);
    }

    public final ListenableFuture<Boolean> launch() {
        CompletableJob Job$default;
        CoroutineDispatcher taskCoroutineDispatcher = this.workTaskExecutor.getTaskCoroutineDispatcher();
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        return ListenableFutureKt.launchFuture$default(taskCoroutineDispatcher.plus(Job$default), null, new WorkerWrapper$launch$1(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WorkerWrapper.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Landroidx/work/impl/WorkerWrapper$Resolution;", "", "()V", "Failed", "Finished", "ResetWorkerStatus", "Landroidx/work/impl/WorkerWrapper$Resolution$Failed;", "Landroidx/work/impl/WorkerWrapper$Resolution$Finished;", "Landroidx/work/impl/WorkerWrapper$Resolution$ResetWorkerStatus;", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static abstract class Resolution {
        public /* synthetic */ Resolution(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: WorkerWrapper.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/work/impl/WorkerWrapper$Resolution$ResetWorkerStatus;", "Landroidx/work/impl/WorkerWrapper$Resolution;", "reason", "", "(I)V", "getReason", "()I", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes5.dex */
        public static final class ResetWorkerStatus extends Resolution {
            private final int reason;

            public ResetWorkerStatus() {
                this(0, 1, null);
            }

            public ResetWorkerStatus(int i) {
                super(null);
                this.reason = i;
            }

            public /* synthetic */ ResetWorkerStatus(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i2 & 1) != 0 ? -256 : i);
            }

            public final int getReason() {
                return this.reason;
            }
        }

        private Resolution() {
        }

        /* compiled from: WorkerWrapper.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/work/impl/WorkerWrapper$Resolution$Failed;", "Landroidx/work/impl/WorkerWrapper$Resolution;", "result", "Landroidx/work/ListenableWorker$Result;", "(Landroidx/work/ListenableWorker$Result;)V", "getResult", "()Landroidx/work/ListenableWorker$Result;", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes5.dex */
        public static final class Failed extends Resolution {
            private final ListenableWorker.Result result;

            /* JADX WARN: Multi-variable type inference failed */
            public Failed() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failed(ListenableWorker.Result result) {
                super(null);
                Intrinsics.checkNotNullParameter(result, "result");
                this.result = result;
            }

            public /* synthetic */ Failed(ListenableWorker.Result.Failure failure, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? new ListenableWorker.Result.Failure() : failure);
            }

            public final ListenableWorker.Result getResult() {
                return this.result;
            }
        }

        /* compiled from: WorkerWrapper.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/work/impl/WorkerWrapper$Resolution$Finished;", "Landroidx/work/impl/WorkerWrapper$Resolution;", "result", "Landroidx/work/ListenableWorker$Result;", "(Landroidx/work/ListenableWorker$Result;)V", "getResult", "()Landroidx/work/ListenableWorker$Result;", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes5.dex */
        public static final class Finished extends Resolution {
            private final ListenableWorker.Result result;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Finished(ListenableWorker.Result result) {
                super(null);
                Intrinsics.checkNotNullParameter(result, "result");
                this.result = result;
            }

            public final ListenableWorker.Result getResult() {
                return this.result;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runWorker(kotlin.coroutines.Continuation<? super androidx.work.impl.WorkerWrapper.Resolution> r23) {
        /*
            Method dump skipped, instructions count: 620
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.WorkerWrapper.runWorker(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Boolean runWorker$lambda$1(WorkerWrapper workerWrapper) {
        if (workerWrapper.workSpec.state != WorkInfo.State.ENQUEUED) {
            String access$getTAG$p = WorkerWrapperKt.access$getTAG$p();
            Logger.get().debug(access$getTAG$p, workerWrapper.workSpec.workerClassName + " is not in ENQUEUED state. Nothing more to do");
            return true;
        }
        if ((workerWrapper.workSpec.isPeriodic() || workerWrapper.workSpec.isBackedOff()) && workerWrapper.clock.currentTimeMillis() < workerWrapper.workSpec.calculateNextRunTime()) {
            Logger.get().debug(WorkerWrapperKt.access$getTAG$p(), "Delaying execution for " + workerWrapper.workSpec.workerClassName + " because it is being executed before schedule.");
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onWorkFinished(ListenableWorker.Result result) {
        WorkInfo.State state = this.workSpecDao.getState(this.workSpecId);
        this.workDatabase.workProgressDao().delete(this.workSpecId);
        if (state == null) {
            return false;
        }
        if (state == WorkInfo.State.RUNNING) {
            return handleResult(result);
        }
        if (state.isFinished()) {
            return false;
        }
        return reschedule(WorkInfo.STOP_REASON_UNKNOWN);
    }

    public final void interrupt(int stopReason) {
        this.workerJob.cancel((CancellationException) new WorkerStoppedException(stopReason));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean resetWorkerStatus(int stopReason) {
        WorkInfo.State state = this.workSpecDao.getState(this.workSpecId);
        if (state != null && !state.isFinished()) {
            String access$getTAG$p = WorkerWrapperKt.access$getTAG$p();
            Logger.get().debug(access$getTAG$p, "Status for " + this.workSpecId + " is " + state + "; not doing any work and rescheduling for later execution");
            this.workSpecDao.setState(WorkInfo.State.ENQUEUED, this.workSpecId);
            this.workSpecDao.setStopReason(this.workSpecId, stopReason);
            this.workSpecDao.markWorkSpecScheduled(this.workSpecId, -1L);
            return true;
        }
        String access$getTAG$p2 = WorkerWrapperKt.access$getTAG$p();
        Logger.get().debug(access$getTAG$p2, "Status for " + this.workSpecId + " is " + state + " ; not doing any work");
        return false;
    }

    private final boolean handleResult(ListenableWorker.Result result) {
        if (result instanceof ListenableWorker.Result.Success) {
            String access$getTAG$p = WorkerWrapperKt.access$getTAG$p();
            Logger.get().info(access$getTAG$p, "Worker result SUCCESS for " + this.workDescription);
            if (this.workSpec.isPeriodic()) {
                return resetPeriodic();
            }
            return setSucceeded(result);
        }
        if (result instanceof ListenableWorker.Result.Retry) {
            String access$getTAG$p2 = WorkerWrapperKt.access$getTAG$p();
            Logger.get().info(access$getTAG$p2, "Worker result RETRY for " + this.workDescription);
            return reschedule(-256);
        }
        String access$getTAG$p3 = WorkerWrapperKt.access$getTAG$p();
        Logger.get().info(access$getTAG$p3, "Worker result FAILURE for " + this.workDescription);
        if (this.workSpec.isPeriodic()) {
            return resetPeriodic();
        }
        if (result == null) {
            result = new ListenableWorker.Result.Failure();
        }
        return setFailed(result);
    }

    private final boolean trySetRunning() {
        Object runInTransaction = this.workDatabase.runInTransaction((Callable<Object>) new Callable() { // from class: androidx.work.impl.WorkerWrapper$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return WorkerWrapper.trySetRunning$lambda$11(WorkerWrapper.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(runInTransaction, "workDatabase.runInTransa…e\n            }\n        )");
        return ((Boolean) runInTransaction).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Boolean trySetRunning$lambda$11(WorkerWrapper workerWrapper) {
        boolean z;
        if (workerWrapper.workSpecDao.getState(workerWrapper.workSpecId) == WorkInfo.State.ENQUEUED) {
            workerWrapper.workSpecDao.setState(WorkInfo.State.RUNNING, workerWrapper.workSpecId);
            workerWrapper.workSpecDao.incrementWorkSpecRunAttemptCount(workerWrapper.workSpecId);
            workerWrapper.workSpecDao.setStopReason(workerWrapper.workSpecId, -256);
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public final boolean setFailed(ListenableWorker.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        iterativelyFailWorkAndDependents(this.workSpecId);
        Data outputData = ((ListenableWorker.Result.Failure) result).getOutputData();
        Intrinsics.checkNotNullExpressionValue(outputData, "failure.outputData");
        this.workSpecDao.resetWorkSpecNextScheduleTimeOverride(this.workSpecId, this.workSpec.getNextScheduleTimeOverrideGeneration());
        this.workSpecDao.setOutput(this.workSpecId, outputData);
        return false;
    }

    private final void iterativelyFailWorkAndDependents(String workSpecId) {
        List mutableListOf = CollectionsKt.mutableListOf(workSpecId);
        while (!mutableListOf.isEmpty()) {
            String str = (String) CollectionsKt.removeLast(mutableListOf);
            if (this.workSpecDao.getState(str) != WorkInfo.State.CANCELLED) {
                this.workSpecDao.setState(WorkInfo.State.FAILED, str);
            }
            mutableListOf.addAll(this.dependencyDao.getDependentWorkIds(str));
        }
    }

    private final boolean reschedule(int stopReason) {
        this.workSpecDao.setState(WorkInfo.State.ENQUEUED, this.workSpecId);
        this.workSpecDao.setLastEnqueueTime(this.workSpecId, this.clock.currentTimeMillis());
        this.workSpecDao.resetWorkSpecNextScheduleTimeOverride(this.workSpecId, this.workSpec.getNextScheduleTimeOverrideGeneration());
        this.workSpecDao.markWorkSpecScheduled(this.workSpecId, -1L);
        this.workSpecDao.setStopReason(this.workSpecId, stopReason);
        return true;
    }

    private final boolean resetPeriodic() {
        this.workSpecDao.setLastEnqueueTime(this.workSpecId, this.clock.currentTimeMillis());
        this.workSpecDao.setState(WorkInfo.State.ENQUEUED, this.workSpecId);
        this.workSpecDao.resetWorkSpecRunAttemptCount(this.workSpecId);
        this.workSpecDao.resetWorkSpecNextScheduleTimeOverride(this.workSpecId, this.workSpec.getNextScheduleTimeOverrideGeneration());
        this.workSpecDao.incrementPeriodCount(this.workSpecId);
        this.workSpecDao.markWorkSpecScheduled(this.workSpecId, -1L);
        return false;
    }

    private final boolean setSucceeded(ListenableWorker.Result result) {
        this.workSpecDao.setState(WorkInfo.State.SUCCEEDED, this.workSpecId);
        Intrinsics.checkNotNull(result, "null cannot be cast to non-null type androidx.work.ListenableWorker.Result.Success");
        Data outputData = ((ListenableWorker.Result.Success) result).getOutputData();
        Intrinsics.checkNotNullExpressionValue(outputData, "success.outputData");
        this.workSpecDao.setOutput(this.workSpecId, outputData);
        long currentTimeMillis = this.clock.currentTimeMillis();
        for (String str : this.dependencyDao.getDependentWorkIds(this.workSpecId)) {
            if (this.workSpecDao.getState(str) == WorkInfo.State.BLOCKED && this.dependencyDao.hasCompletedAllPrerequisites(str)) {
                String access$getTAG$p = WorkerWrapperKt.access$getTAG$p();
                Logger.get().info(access$getTAG$p, "Setting status to enqueued for " + str);
                this.workSpecDao.setState(WorkInfo.State.ENQUEUED, str);
                this.workSpecDao.setLastEnqueueTime(str, currentTimeMillis);
            }
        }
        return false;
    }

    private final String createWorkDescription(List<String> tags) {
        return "Work [ id=" + this.workSpecId + ", tags={ " + CollectionsKt.joinToString$default(tags, ",", null, null, 0, null, null, 62, null) + " } ]";
    }

    /* compiled from: WorkerWrapper.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001BE\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\u0010\u0011J\u0006\u0010-\u001a\u00020.J\u0010\u0010/\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0010\u00100\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(H\u0007R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00061"}, d2 = {"Landroidx/work/impl/WorkerWrapper$Builder;", "", "context", "Landroid/content/Context;", "configuration", "Landroidx/work/Configuration;", "workTaskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "foregroundProcessor", "Landroidx/work/impl/foreground/ForegroundProcessor;", "workDatabase", "Landroidx/work/impl/WorkDatabase;", "workSpec", "Landroidx/work/impl/model/WorkSpec;", "tags", "", "", "(Landroid/content/Context;Landroidx/work/Configuration;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;Landroidx/work/impl/foreground/ForegroundProcessor;Landroidx/work/impl/WorkDatabase;Landroidx/work/impl/model/WorkSpec;Ljava/util/List;)V", "appContext", "getAppContext", "()Landroid/content/Context;", "getConfiguration", "()Landroidx/work/Configuration;", "getForegroundProcessor", "()Landroidx/work/impl/foreground/ForegroundProcessor;", "runtimeExtras", "Landroidx/work/WorkerParameters$RuntimeExtras;", "getRuntimeExtras", "()Landroidx/work/WorkerParameters$RuntimeExtras;", "setRuntimeExtras", "(Landroidx/work/WorkerParameters$RuntimeExtras;)V", "getTags", "()Ljava/util/List;", "getWorkDatabase", "()Landroidx/work/impl/WorkDatabase;", "getWorkSpec", "()Landroidx/work/impl/model/WorkSpec;", "getWorkTaskExecutor", "()Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "worker", "Landroidx/work/ListenableWorker;", "getWorker", "()Landroidx/work/ListenableWorker;", "setWorker", "(Landroidx/work/ListenableWorker;)V", "build", "Landroidx/work/impl/WorkerWrapper;", "withRuntimeExtras", "withWorker", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Builder {
        private final Context appContext;
        private final Configuration configuration;
        private final ForegroundProcessor foregroundProcessor;
        private WorkerParameters.RuntimeExtras runtimeExtras;
        private final List<String> tags;
        private final WorkDatabase workDatabase;
        private final WorkSpec workSpec;
        private final TaskExecutor workTaskExecutor;
        private ListenableWorker worker;

        public Builder(Context context, Configuration configuration, TaskExecutor workTaskExecutor, ForegroundProcessor foregroundProcessor, WorkDatabase workDatabase, WorkSpec workSpec, List<String> tags) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            Intrinsics.checkNotNullParameter(workTaskExecutor, "workTaskExecutor");
            Intrinsics.checkNotNullParameter(foregroundProcessor, "foregroundProcessor");
            Intrinsics.checkNotNullParameter(workDatabase, "workDatabase");
            Intrinsics.checkNotNullParameter(workSpec, "workSpec");
            Intrinsics.checkNotNullParameter(tags, "tags");
            this.configuration = configuration;
            this.workTaskExecutor = workTaskExecutor;
            this.foregroundProcessor = foregroundProcessor;
            this.workDatabase = workDatabase;
            this.workSpec = workSpec;
            this.tags = tags;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            this.appContext = applicationContext;
            this.runtimeExtras = new WorkerParameters.RuntimeExtras();
        }

        public final Configuration getConfiguration() {
            return this.configuration;
        }

        public final TaskExecutor getWorkTaskExecutor() {
            return this.workTaskExecutor;
        }

        public final ForegroundProcessor getForegroundProcessor() {
            return this.foregroundProcessor;
        }

        public final WorkDatabase getWorkDatabase() {
            return this.workDatabase;
        }

        public final WorkSpec getWorkSpec() {
            return this.workSpec;
        }

        public final List<String> getTags() {
            return this.tags;
        }

        public final Context getAppContext() {
            return this.appContext;
        }

        public final ListenableWorker getWorker() {
            return this.worker;
        }

        public final void setWorker(ListenableWorker listenableWorker) {
            this.worker = listenableWorker;
        }

        public final WorkerParameters.RuntimeExtras getRuntimeExtras() {
            return this.runtimeExtras;
        }

        public final void setRuntimeExtras(WorkerParameters.RuntimeExtras runtimeExtras) {
            Intrinsics.checkNotNullParameter(runtimeExtras, "<set-?>");
            this.runtimeExtras = runtimeExtras;
        }

        public final Builder withRuntimeExtras(WorkerParameters.RuntimeExtras runtimeExtras) {
            if (runtimeExtras != null) {
                this.runtimeExtras = runtimeExtras;
            }
            return this;
        }

        public final Builder withWorker(ListenableWorker worker) {
            Intrinsics.checkNotNullParameter(worker, "worker");
            this.worker = worker;
            return this;
        }

        public final WorkerWrapper build() {
            return new WorkerWrapper(this);
        }
    }
}
