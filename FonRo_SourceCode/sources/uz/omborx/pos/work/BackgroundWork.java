package uz.FonRo.pos.work;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackgroundWork.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0013"}, d2 = {"Luz/FonRo/pos/work/BackgroundWork;", "", "<init>", "()V", "OUTBOX_WORK", "", "POLL_WORK", "TAG", "networkRequired", "Landroidx/work/Constraints;", "scheduleOutboxFlush", "", "context", "Landroid/content/Context;", "flushNow", "schedulePolling", "cancelAll", "outboxRequest", "Landroidx/work/OneTimeWorkRequest;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class BackgroundWork {
    public static final int $stable = 0;
    private static final String OUTBOX_WORK = "FonRo-outbox";
    private static final String POLL_WORK = "FonRo-poll";
    public static final String TAG = "FonRo-bg";
    public static final BackgroundWork INSTANCE = new BackgroundWork();
    private static final Constraints networkRequired = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();

    private BackgroundWork() {
    }

    public final void scheduleOutboxFlush(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WorkManager.INSTANCE.getInstance(context).enqueueUniqueWork(OUTBOX_WORK, ExistingWorkPolicy.KEEP, outboxRequest());
    }

    public final void flushNow(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WorkManager.INSTANCE.getInstance(context).enqueueUniqueWork(OUTBOX_WORK, ExistingWorkPolicy.REPLACE, outboxRequest());
    }

    public final void schedulePolling(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WorkManager.INSTANCE.getInstance(context).enqueueUniquePeriodicWork(POLL_WORK, ExistingPeriodicWorkPolicy.UPDATE, new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) PollWorker.class, 15L, TimeUnit.MINUTES).setConstraints(networkRequired).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 30L, TimeUnit.SECONDS).addTag(TAG).build());
    }

    public final void cancelAll(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WorkManager companion = WorkManager.INSTANCE.getInstance(context);
        companion.cancelUniqueWork(OUTBOX_WORK);
        companion.cancelUniqueWork(POLL_WORK);
    }

    private final OneTimeWorkRequest outboxRequest() {
        return new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) OutboxWorker.class).setConstraints(networkRequired).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 30L, TimeUnit.SECONDS).addTag(TAG).build();
    }
}
