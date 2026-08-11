package androidx.work.impl.model;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.NetworkRequestCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes5.dex */
public final class WorkSpecDao_Impl implements WorkSpecDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<WorkSpec> __insertionAdapterOfWorkSpec;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfIncrementGeneration;
    private final SharedSQLiteStatement __preparedStmtOfIncrementPeriodCount;
    private final SharedSQLiteStatement __preparedStmtOfIncrementWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfMarkWorkSpecScheduled;
    private final SharedSQLiteStatement __preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast;
    private final SharedSQLiteStatement __preparedStmtOfResetScheduledState;
    private final SharedSQLiteStatement __preparedStmtOfResetWorkSpecNextScheduleTimeOverride;
    private final SharedSQLiteStatement __preparedStmtOfResetWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfSetCancelledState;
    private final SharedSQLiteStatement __preparedStmtOfSetLastEnqueueTime;
    private final SharedSQLiteStatement __preparedStmtOfSetNextScheduleTimeOverride;
    private final SharedSQLiteStatement __preparedStmtOfSetOutput;
    private final SharedSQLiteStatement __preparedStmtOfSetState;
    private final SharedSQLiteStatement __preparedStmtOfSetStopReason;
    private final EntityDeletionOrUpdateAdapter<WorkSpec> __updateAdapterOfWorkSpec;

    public WorkSpecDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfWorkSpec = new EntityInsertionAdapter<WorkSpec>(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`next_schedule_time_override`,`next_schedule_time_override_generation`,`stop_reason`,`trace_tag`,`required_network_type`,`required_network_request`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) {
                supportSQLiteStatement.bindString(1, workSpec.id);
                WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(2, WorkTypeConverters.stateToInt(workSpec.state));
                supportSQLiteStatement.bindString(3, workSpec.workerClassName);
                supportSQLiteStatement.bindString(4, workSpec.inputMergerClassName);
                supportSQLiteStatement.bindBlob(5, Data.toByteArrayInternalV1(workSpec.input));
                supportSQLiteStatement.bindBlob(6, Data.toByteArrayInternalV1(workSpec.output));
                supportSQLiteStatement.bindLong(7, workSpec.initialDelay);
                supportSQLiteStatement.bindLong(8, workSpec.intervalDuration);
                supportSQLiteStatement.bindLong(9, workSpec.flexDuration);
                supportSQLiteStatement.bindLong(10, workSpec.runAttemptCount);
                WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(11, WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
                supportSQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
                supportSQLiteStatement.bindLong(13, workSpec.lastEnqueueTime);
                supportSQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
                supportSQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
                supportSQLiteStatement.bindLong(16, workSpec.expedited ? 1L : 0L);
                WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(17, WorkTypeConverters.outOfQuotaPolicyToInt(workSpec.outOfQuotaPolicy));
                supportSQLiteStatement.bindLong(18, workSpec.getPeriodCount());
                supportSQLiteStatement.bindLong(19, workSpec.getGeneration());
                supportSQLiteStatement.bindLong(20, workSpec.getNextScheduleTimeOverride());
                supportSQLiteStatement.bindLong(21, workSpec.getNextScheduleTimeOverrideGeneration());
                supportSQLiteStatement.bindLong(22, workSpec.getStopReason());
                if (workSpec.getTraceTag() == null) {
                    supportSQLiteStatement.bindNull(23);
                } else {
                    supportSQLiteStatement.bindString(23, workSpec.getTraceTag());
                }
                Constraints constraints = workSpec.constraints;
                WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(24, WorkTypeConverters.networkTypeToInt(constraints.getRequiredNetworkType()));
                WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindBlob(25, WorkTypeConverters.fromNetworkRequest$work_runtime_release(constraints.getRequiredNetworkRequestCompat()));
                supportSQLiteStatement.bindLong(26, constraints.getRequiresCharging() ? 1L : 0L);
                supportSQLiteStatement.bindLong(27, constraints.getRequiresDeviceIdle() ? 1L : 0L);
                supportSQLiteStatement.bindLong(28, constraints.getRequiresBatteryNotLow() ? 1L : 0L);
                supportSQLiteStatement.bindLong(29, constraints.getRequiresStorageNotLow() ? 1L : 0L);
                supportSQLiteStatement.bindLong(30, constraints.getContentTriggerUpdateDelayMillis());
                supportSQLiteStatement.bindLong(31, constraints.getContentTriggerMaxDelayMillis());
                WorkTypeConverters workTypeConverters6 = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindBlob(32, WorkTypeConverters.setOfTriggersToByteArray(constraints.getContentUriTriggers()));
            }
        };
        this.__updateAdapterOfWorkSpec = new EntityDeletionOrUpdateAdapter<WorkSpec>(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`next_schedule_time_override` = ?,`next_schedule_time_override_generation` = ?,`stop_reason` = ?,`trace_tag` = ?,`required_network_type` = ?,`required_network_request` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) {
                supportSQLiteStatement.bindString(1, workSpec.id);
                WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(2, WorkTypeConverters.stateToInt(workSpec.state));
                supportSQLiteStatement.bindString(3, workSpec.workerClassName);
                supportSQLiteStatement.bindString(4, workSpec.inputMergerClassName);
                supportSQLiteStatement.bindBlob(5, Data.toByteArrayInternalV1(workSpec.input));
                supportSQLiteStatement.bindBlob(6, Data.toByteArrayInternalV1(workSpec.output));
                supportSQLiteStatement.bindLong(7, workSpec.initialDelay);
                supportSQLiteStatement.bindLong(8, workSpec.intervalDuration);
                supportSQLiteStatement.bindLong(9, workSpec.flexDuration);
                supportSQLiteStatement.bindLong(10, workSpec.runAttemptCount);
                WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(11, WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
                supportSQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
                supportSQLiteStatement.bindLong(13, workSpec.lastEnqueueTime);
                supportSQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
                supportSQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
                supportSQLiteStatement.bindLong(16, workSpec.expedited ? 1L : 0L);
                WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(17, WorkTypeConverters.outOfQuotaPolicyToInt(workSpec.outOfQuotaPolicy));
                supportSQLiteStatement.bindLong(18, workSpec.getPeriodCount());
                supportSQLiteStatement.bindLong(19, workSpec.getGeneration());
                supportSQLiteStatement.bindLong(20, workSpec.getNextScheduleTimeOverride());
                supportSQLiteStatement.bindLong(21, workSpec.getNextScheduleTimeOverrideGeneration());
                supportSQLiteStatement.bindLong(22, workSpec.getStopReason());
                if (workSpec.getTraceTag() == null) {
                    supportSQLiteStatement.bindNull(23);
                } else {
                    supportSQLiteStatement.bindString(23, workSpec.getTraceTag());
                }
                Constraints constraints = workSpec.constraints;
                WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(24, WorkTypeConverters.networkTypeToInt(constraints.getRequiredNetworkType()));
                WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindBlob(25, WorkTypeConverters.fromNetworkRequest$work_runtime_release(constraints.getRequiredNetworkRequestCompat()));
                supportSQLiteStatement.bindLong(26, constraints.getRequiresCharging() ? 1L : 0L);
                supportSQLiteStatement.bindLong(27, constraints.getRequiresDeviceIdle() ? 1L : 0L);
                supportSQLiteStatement.bindLong(28, constraints.getRequiresBatteryNotLow() ? 1L : 0L);
                supportSQLiteStatement.bindLong(29, constraints.getRequiresStorageNotLow() ? 1L : 0L);
                supportSQLiteStatement.bindLong(30, constraints.getContentTriggerUpdateDelayMillis());
                supportSQLiteStatement.bindLong(31, constraints.getContentTriggerMaxDelayMillis());
                WorkTypeConverters workTypeConverters6 = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindBlob(32, WorkTypeConverters.setOfTriggersToByteArray(constraints.getContentUriTriggers()));
                supportSQLiteStatement.bindString(33, workSpec.id);
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.__preparedStmtOfSetState = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET state=? WHERE id=?";
            }
        };
        this.__preparedStmtOfSetCancelledState = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET stop_reason = CASE WHEN state=1 THEN 1 ELSE -256 END, state=5 WHERE id=?";
            }
        };
        this.__preparedStmtOfIncrementPeriodCount = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET period_count=period_count+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfSetOutput = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.__preparedStmtOfSetLastEnqueueTime = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET last_enqueue_time=? WHERE id=?";
            }
        };
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.9
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfResetWorkSpecRunAttemptCount = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.10
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.__preparedStmtOfSetNextScheduleTimeOverride = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.11
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET next_schedule_time_override=? WHERE id=?";
            }
        };
        this.__preparedStmtOfResetWorkSpecNextScheduleTimeOverride = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.12
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET next_schedule_time_override=9223372036854775807 WHERE (id=? AND next_schedule_time_override_generation=?)";
            }
        };
        this.__preparedStmtOfMarkWorkSpecScheduled = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.13
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.__preparedStmtOfResetScheduledState = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.14
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.15
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }
        };
        this.__preparedStmtOfIncrementGeneration = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.16
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET generation=generation+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfSetStopReason = new SharedSQLiteStatement(__db) { // from class: androidx.work.impl.model.WorkSpecDao_Impl.17
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET stop_reason=? WHERE id=?";
            }
        };
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void insertWorkSpec(final WorkSpec workSpec) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWorkSpec.insert((EntityInsertionAdapter<WorkSpec>) workSpec);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void updateWorkSpec(final WorkSpec workSpec) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfWorkSpec.handle(workSpec);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void delete(final String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDelete.acquire();
        acquire.bindString(1, id);
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfDelete.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int setState(final WorkInfo.State state, final String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetState.acquire();
        WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
        acquire.bindLong(1, WorkTypeConverters.stateToInt(state));
        acquire.bindString(2, id);
        try {
            this.__db.beginTransaction();
            try {
                int executeUpdateDelete = acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                return executeUpdateDelete;
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfSetState.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int setCancelledState(final String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetCancelledState.acquire();
        acquire.bindString(1, id);
        try {
            this.__db.beginTransaction();
            try {
                int executeUpdateDelete = acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                return executeUpdateDelete;
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfSetCancelledState.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void incrementPeriodCount(final String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfIncrementPeriodCount.acquire();
        acquire.bindString(1, id);
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfIncrementPeriodCount.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setOutput(final String id, final Data output) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetOutput.acquire();
        acquire.bindBlob(1, Data.toByteArrayInternalV1(output));
        acquire.bindString(2, id);
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfSetOutput.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setLastEnqueueTime(final String id, final long enqueueTime) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetLastEnqueueTime.acquire();
        acquire.bindLong(1, enqueueTime);
        acquire.bindString(2, id);
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfSetLastEnqueueTime.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int incrementWorkSpecRunAttemptCount(final String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.acquire();
        acquire.bindString(1, id);
        try {
            this.__db.beginTransaction();
            try {
                int executeUpdateDelete = acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                return executeUpdateDelete;
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int resetWorkSpecRunAttemptCount(final String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetWorkSpecRunAttemptCount.acquire();
        acquire.bindString(1, id);
        try {
            this.__db.beginTransaction();
            try {
                int executeUpdateDelete = acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                return executeUpdateDelete;
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfResetWorkSpecRunAttemptCount.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setNextScheduleTimeOverride(final String id, final long nextScheduleTimeOverrideMillis) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetNextScheduleTimeOverride.acquire();
        acquire.bindLong(1, nextScheduleTimeOverrideMillis);
        acquire.bindString(2, id);
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfSetNextScheduleTimeOverride.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void resetWorkSpecNextScheduleTimeOverride(final String id, final int overrideGeneration) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetWorkSpecNextScheduleTimeOverride.acquire();
        acquire.bindString(1, id);
        acquire.bindLong(2, overrideGeneration);
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfResetWorkSpecNextScheduleTimeOverride.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int markWorkSpecScheduled(final String id, final long startTime) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfMarkWorkSpecScheduled.acquire();
        acquire.bindLong(1, startTime);
        acquire.bindString(2, id);
        try {
            this.__db.beginTransaction();
            try {
                int executeUpdateDelete = acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                return executeUpdateDelete;
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfMarkWorkSpecScheduled.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int resetScheduledState() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetScheduledState.acquire();
        try {
            this.__db.beginTransaction();
            try {
                int executeUpdateDelete = acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
                return executeUpdateDelete;
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfResetScheduledState.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.acquire();
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void incrementGeneration(final String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfIncrementGeneration.acquire();
        acquire.bindString(1, id);
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfIncrementGeneration.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setStopReason(final String id, final int stopReason) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetStopReason.acquire();
        acquire.bindLong(1, stopReason);
        acquire.bindString(2, id);
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfSetStopReason.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec getWorkSpec(final String id) {
        RoomSQLiteQuery roomSQLiteQuery;
        WorkSpec workSpec;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE id=?", 1);
        acquire.bindString(1, id);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override_generation");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "stop_reason");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "trace_tag");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "required_network_request");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                if (query.moveToFirst()) {
                    String string = query.getString(columnIndexOrThrow);
                    int i = query.getInt(columnIndexOrThrow2);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    WorkInfo.State intToState = WorkTypeConverters.intToState(i);
                    String string2 = query.getString(columnIndexOrThrow3);
                    String string3 = query.getString(columnIndexOrThrow4);
                    Data fromByteArray = Data.fromByteArray(query.getBlob(columnIndexOrThrow5));
                    Data fromByteArray2 = Data.fromByteArray(query.getBlob(columnIndexOrThrow6));
                    long j = query.getLong(columnIndexOrThrow7);
                    long j2 = query.getLong(columnIndexOrThrow8);
                    long j3 = query.getLong(columnIndexOrThrow9);
                    int i2 = query.getInt(columnIndexOrThrow10);
                    int i3 = query.getInt(columnIndexOrThrow11);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i3);
                    long j4 = query.getLong(columnIndexOrThrow12);
                    long j5 = query.getLong(columnIndexOrThrow13);
                    long j6 = query.getLong(columnIndexOrThrow14);
                    long j7 = query.getLong(columnIndexOrThrow15);
                    boolean z = query.getInt(columnIndexOrThrow16) != 0;
                    int i4 = query.getInt(columnIndexOrThrow17);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(i4);
                    int i5 = query.getInt(columnIndexOrThrow18);
                    int i6 = query.getInt(columnIndexOrThrow19);
                    long j8 = query.getLong(columnIndexOrThrow20);
                    int i7 = query.getInt(columnIndexOrThrow21);
                    int i8 = query.getInt(columnIndexOrThrow22);
                    String string4 = query.isNull(columnIndexOrThrow23) ? null : query.getString(columnIndexOrThrow23);
                    int i9 = query.getInt(columnIndexOrThrow24);
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i9);
                    byte[] blob = query.getBlob(columnIndexOrThrow25);
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                    boolean z2 = query.getInt(columnIndexOrThrow26) != 0;
                    boolean z3 = query.getInt(columnIndexOrThrow27) != 0;
                    boolean z4 = query.getInt(columnIndexOrThrow28) != 0;
                    boolean z5 = query.getInt(columnIndexOrThrow29) != 0;
                    long j9 = query.getLong(columnIndexOrThrow30);
                    long j10 = query.getLong(columnIndexOrThrow31);
                    byte[] blob2 = query.getBlob(columnIndexOrThrow32);
                    WorkTypeConverters workTypeConverters6 = WorkTypeConverters.INSTANCE;
                    workSpec = new WorkSpec(string, intToState, string2, string3, fromByteArray, fromByteArray2, j, j2, j3, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z2, z3, z4, z5, j9, j10, WorkTypeConverters.byteArrayToSetOfTriggers(blob2)), i2, intToBackoffPolicy, j4, j5, j6, j7, z, intToOutOfQuotaPolicy, i5, i6, j8, i7, i8, string4);
                } else {
                    workSpec = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return workSpec;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(final String name) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        acquire.bindString(1, name);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                String string = query.getString(0);
                int i = query.getInt(1);
                WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                arrayList.add(new WorkSpec.IdAndState(string, WorkTypeConverters.intToState(i)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getAllWorkSpecIds() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<String>> getAllWorkSpecIdsLiveData() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"workspec"}, true, new Callable<List<String>>() { // from class: androidx.work.impl.model.WorkSpecDao_Impl.18
            @Override // java.util.concurrent.Callable
            public List<String> call() throws Exception {
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, false, null);
                    try {
                        ArrayList arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            arrayList.add(query.getString(0));
                        }
                        WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                        return arrayList;
                    } finally {
                        query.close();
                    }
                } finally {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkInfo.State getState(final String id) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT state FROM workspec WHERE id=?", 1);
        acquire.bindString(1, id);
        this.__db.assertNotSuspendingTransaction();
        WorkInfo.State state = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            if (query.moveToFirst()) {
                Integer valueOf = query.isNull(0) ? null : Integer.valueOf(query.getInt(0));
                if (valueOf != null) {
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    state = WorkTypeConverters.intToState(valueOf.intValue());
                }
            }
            return state;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec.WorkInfoPojo getWorkStatusPojoForId(final String id) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id=?", 1);
        acquire.bindString(1, id);
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            WorkSpec.WorkInfoPojo workInfoPojo = null;
            Cursor query = DBUtil.query(this.__db, acquire, true, null);
            try {
                HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
                HashMap<String, ArrayList<Data>> hashMap2 = new HashMap<>();
                while (query.moveToNext()) {
                    String string = query.getString(0);
                    if (!hashMap.containsKey(string)) {
                        hashMap.put(string, new ArrayList<>());
                    }
                    String string2 = query.getString(0);
                    if (!hashMap2.containsKey(string2)) {
                        hashMap2.put(string2, new ArrayList<>());
                    }
                }
                query.moveToPosition(-1);
                __fetchRelationshipWorkTagAsjavaLangString(hashMap);
                __fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                if (query.moveToFirst()) {
                    String string3 = query.getString(0);
                    int i = query.getInt(1);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    WorkInfo.State intToState = WorkTypeConverters.intToState(i);
                    Data fromByteArray = Data.fromByteArray(query.getBlob(2));
                    int i2 = query.getInt(3);
                    int i3 = query.getInt(4);
                    long j = query.getLong(14);
                    long j2 = query.getLong(15);
                    long j3 = query.getLong(16);
                    int i4 = query.getInt(17);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i4);
                    long j4 = query.getLong(18);
                    long j5 = query.getLong(19);
                    int i5 = query.getInt(20);
                    long j6 = query.getLong(21);
                    int i6 = query.getInt(22);
                    int i7 = query.getInt(5);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i7);
                    byte[] blob = query.getBlob(6);
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                    boolean z = query.getInt(7) != 0;
                    boolean z2 = query.getInt(8) != 0;
                    boolean z3 = query.getInt(9) != 0;
                    boolean z4 = query.getInt(10) != 0;
                    long j7 = query.getLong(11);
                    long j8 = query.getLong(12);
                    byte[] blob2 = query.getBlob(13);
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    workInfoPojo = new WorkSpec.WorkInfoPojo(string3, intToState, fromByteArray, j, j2, j3, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z, z2, z3, z4, j7, j8, WorkTypeConverters.byteArrayToSetOfTriggers(blob2)), i2, intToBackoffPolicy, j4, j5, i5, i3, j6, i6, hashMap.get(query.getString(0)), hashMap2.get(query.getString(0)));
                }
                this.__db.setTransactionSuccessful();
                return workInfoPojo;
            } finally {
                query.close();
                acquire.release();
            }
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForIds(final List<String> ids) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (");
        int size = ids.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        Iterator<String> it = ids.iterator();
        int i = 1;
        while (it.hasNext()) {
            acquire.bindString(i, it.next());
            i++;
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            Cursor query = DBUtil.query(this.__db, acquire, true, null);
            try {
                HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
                HashMap<String, ArrayList<Data>> hashMap2 = new HashMap<>();
                while (query.moveToNext()) {
                    String string = query.getString(0);
                    if (!hashMap.containsKey(string)) {
                        hashMap.put(string, new ArrayList<>());
                    }
                    String string2 = query.getString(0);
                    if (!hashMap2.containsKey(string2)) {
                        hashMap2.put(string2, new ArrayList<>());
                    }
                }
                query.moveToPosition(-1);
                __fetchRelationshipWorkTagAsjavaLangString(hashMap);
                __fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string3 = query.getString(0);
                    int i2 = query.getInt(1);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    WorkInfo.State intToState = WorkTypeConverters.intToState(i2);
                    Data fromByteArray = Data.fromByteArray(query.getBlob(2));
                    int i3 = query.getInt(3);
                    int i4 = query.getInt(4);
                    long j = query.getLong(14);
                    long j2 = query.getLong(15);
                    long j3 = query.getLong(16);
                    int i5 = query.getInt(17);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i5);
                    long j4 = query.getLong(18);
                    long j5 = query.getLong(19);
                    int i6 = query.getInt(20);
                    long j6 = query.getLong(21);
                    int i7 = query.getInt(22);
                    int i8 = query.getInt(5);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i8);
                    byte[] blob = query.getBlob(6);
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                    boolean z = query.getInt(7) != 0;
                    boolean z2 = query.getInt(8) != 0;
                    boolean z3 = query.getInt(9) != 0;
                    boolean z4 = query.getInt(10) != 0;
                    long j7 = query.getLong(11);
                    long j8 = query.getLong(12);
                    byte[] blob2 = query.getBlob(13);
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    arrayList.add(new WorkSpec.WorkInfoPojo(string3, intToState, fromByteArray, j, j2, j3, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z, z2, z3, z4, j7, j8, WorkTypeConverters.byteArrayToSetOfTriggers(blob2)), i3, intToBackoffPolicy, j4, j5, i6, i4, j6, i7, hashMap.get(query.getString(0)), hashMap2.get(query.getString(0))));
                }
                this.__db.setTransactionSuccessful();
                return arrayList;
            } finally {
                query.close();
                acquire.release();
            }
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForIds(final List<String> ids) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (");
        int size = ids.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        Iterator<String> it = ids.iterator();
        int i = 1;
        while (it.hasNext()) {
            acquire.bindString(i, it.next());
            i++;
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, new Callable<List<WorkSpec.WorkInfoPojo>>() { // from class: androidx.work.impl.model.WorkSpecDao_Impl.19
            @Override // java.util.concurrent.Callable
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, true, null);
                    try {
                        HashMap hashMap = new HashMap();
                        HashMap hashMap2 = new HashMap();
                        while (query.moveToNext()) {
                            String string = query.getString(0);
                            if (!hashMap.containsKey(string)) {
                                hashMap.put(string, new ArrayList());
                            }
                            String string2 = query.getString(0);
                            if (!hashMap2.containsKey(string2)) {
                                hashMap2.put(string2, new ArrayList());
                            }
                        }
                        query.moveToPosition(-1);
                        WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                        WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                        ArrayList arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            String string3 = query.getString(0);
                            int i2 = query.getInt(1);
                            WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                            WorkInfo.State intToState = WorkTypeConverters.intToState(i2);
                            Data fromByteArray = Data.fromByteArray(query.getBlob(2));
                            int i3 = query.getInt(3);
                            int i4 = query.getInt(4);
                            long j = query.getLong(14);
                            long j2 = query.getLong(15);
                            long j3 = query.getLong(16);
                            int i5 = query.getInt(17);
                            WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                            BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i5);
                            long j4 = query.getLong(18);
                            long j5 = query.getLong(19);
                            int i6 = query.getInt(20);
                            long j6 = query.getLong(21);
                            int i7 = query.getInt(22);
                            int i8 = query.getInt(5);
                            WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                            NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i8);
                            byte[] blob = query.getBlob(6);
                            WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                            NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                            boolean z = query.getInt(7) != 0;
                            boolean z2 = query.getInt(8) != 0;
                            boolean z3 = query.getInt(9) != 0;
                            boolean z4 = query.getInt(10) != 0;
                            long j7 = query.getLong(11);
                            long j8 = query.getLong(12);
                            byte[] blob2 = query.getBlob(13);
                            WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                            arrayList.add(new WorkSpec.WorkInfoPojo(string3, intToState, fromByteArray, j, j2, j3, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z, z2, z3, z4, j7, j8, WorkTypeConverters.byteArrayToSetOfTriggers(blob2)), i3, intToBackoffPolicy, j4, j5, i6, i4, j6, i7, (ArrayList) hashMap.get(query.getString(0)), (ArrayList) hashMap2.get(query.getString(0))));
                        }
                        WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                        return arrayList;
                    } finally {
                        query.close();
                    }
                } finally {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public Flow<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoFlowDataForIds(final List<String> ids) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (");
        int size = ids.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        Iterator<String> it = ids.iterator();
        int i = 1;
        while (it.hasNext()) {
            acquire.bindString(i, it.next());
            i++;
        }
        return CoroutinesRoom.createFlow(this.__db, true, new String[]{"WorkTag", "WorkProgress", "workspec"}, new Callable<List<WorkSpec.WorkInfoPojo>>() { // from class: androidx.work.impl.model.WorkSpecDao_Impl.20
            @Override // java.util.concurrent.Callable
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, true, null);
                    try {
                        HashMap hashMap = new HashMap();
                        HashMap hashMap2 = new HashMap();
                        while (query.moveToNext()) {
                            String string = query.getString(0);
                            if (!hashMap.containsKey(string)) {
                                hashMap.put(string, new ArrayList());
                            }
                            String string2 = query.getString(0);
                            if (!hashMap2.containsKey(string2)) {
                                hashMap2.put(string2, new ArrayList());
                            }
                        }
                        query.moveToPosition(-1);
                        WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                        WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                        ArrayList arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            String string3 = query.getString(0);
                            int i2 = query.getInt(1);
                            WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                            WorkInfo.State intToState = WorkTypeConverters.intToState(i2);
                            Data fromByteArray = Data.fromByteArray(query.getBlob(2));
                            int i3 = query.getInt(3);
                            int i4 = query.getInt(4);
                            long j = query.getLong(14);
                            long j2 = query.getLong(15);
                            long j3 = query.getLong(16);
                            int i5 = query.getInt(17);
                            WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                            BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i5);
                            long j4 = query.getLong(18);
                            long j5 = query.getLong(19);
                            int i6 = query.getInt(20);
                            long j6 = query.getLong(21);
                            int i7 = query.getInt(22);
                            int i8 = query.getInt(5);
                            WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                            NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i8);
                            byte[] blob = query.getBlob(6);
                            WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                            NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                            boolean z = query.getInt(7) != 0;
                            boolean z2 = query.getInt(8) != 0;
                            boolean z3 = query.getInt(9) != 0;
                            boolean z4 = query.getInt(10) != 0;
                            long j7 = query.getLong(11);
                            long j8 = query.getLong(12);
                            byte[] blob2 = query.getBlob(13);
                            WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                            arrayList.add(new WorkSpec.WorkInfoPojo(string3, intToState, fromByteArray, j, j2, j3, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z, z2, z3, z4, j7, j8, WorkTypeConverters.byteArrayToSetOfTriggers(blob2)), i3, intToBackoffPolicy, j4, j5, i6, i4, j6, i7, (ArrayList) hashMap.get(query.getString(0)), (ArrayList) hashMap2.get(query.getString(0))));
                        }
                        WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                        return arrayList;
                    } finally {
                        query.close();
                    }
                } finally {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForTag(final String tag) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        acquire.bindString(1, tag);
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            Cursor query = DBUtil.query(this.__db, acquire, true, null);
            try {
                HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
                HashMap<String, ArrayList<Data>> hashMap2 = new HashMap<>();
                while (query.moveToNext()) {
                    String string = query.getString(0);
                    if (!hashMap.containsKey(string)) {
                        hashMap.put(string, new ArrayList<>());
                    }
                    String string2 = query.getString(0);
                    if (!hashMap2.containsKey(string2)) {
                        hashMap2.put(string2, new ArrayList<>());
                    }
                }
                query.moveToPosition(-1);
                __fetchRelationshipWorkTagAsjavaLangString(hashMap);
                __fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string3 = query.getString(0);
                    int i = query.getInt(1);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    WorkInfo.State intToState = WorkTypeConverters.intToState(i);
                    Data fromByteArray = Data.fromByteArray(query.getBlob(2));
                    int i2 = query.getInt(3);
                    int i3 = query.getInt(4);
                    long j = query.getLong(14);
                    long j2 = query.getLong(15);
                    long j3 = query.getLong(16);
                    int i4 = query.getInt(17);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i4);
                    long j4 = query.getLong(18);
                    long j5 = query.getLong(19);
                    int i5 = query.getInt(20);
                    long j6 = query.getLong(21);
                    int i6 = query.getInt(22);
                    int i7 = query.getInt(5);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i7);
                    byte[] blob = query.getBlob(6);
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                    boolean z = query.getInt(7) != 0;
                    boolean z2 = query.getInt(8) != 0;
                    boolean z3 = query.getInt(9) != 0;
                    boolean z4 = query.getInt(10) != 0;
                    long j7 = query.getLong(11);
                    long j8 = query.getLong(12);
                    byte[] blob2 = query.getBlob(13);
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    arrayList.add(new WorkSpec.WorkInfoPojo(string3, intToState, fromByteArray, j, j2, j3, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z, z2, z3, z4, j7, j8, WorkTypeConverters.byteArrayToSetOfTriggers(blob2)), i2, intToBackoffPolicy, j4, j5, i5, i3, j6, i6, hashMap.get(query.getString(0)), hashMap2.get(query.getString(0))));
                }
                this.__db.setTransactionSuccessful();
                return arrayList;
            } finally {
                query.close();
                acquire.release();
            }
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public Flow<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoFlowForTag(final String tag) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        acquire.bindString(1, tag);
        return CoroutinesRoom.createFlow(this.__db, true, new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"}, new Callable<List<WorkSpec.WorkInfoPojo>>() { // from class: androidx.work.impl.model.WorkSpecDao_Impl.21
            @Override // java.util.concurrent.Callable
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, true, null);
                    try {
                        HashMap hashMap = new HashMap();
                        HashMap hashMap2 = new HashMap();
                        while (query.moveToNext()) {
                            String string = query.getString(0);
                            if (!hashMap.containsKey(string)) {
                                hashMap.put(string, new ArrayList());
                            }
                            String string2 = query.getString(0);
                            if (!hashMap2.containsKey(string2)) {
                                hashMap2.put(string2, new ArrayList());
                            }
                        }
                        query.moveToPosition(-1);
                        WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                        WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                        ArrayList arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            String string3 = query.getString(0);
                            int i = query.getInt(1);
                            WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                            WorkInfo.State intToState = WorkTypeConverters.intToState(i);
                            Data fromByteArray = Data.fromByteArray(query.getBlob(2));
                            int i2 = query.getInt(3);
                            int i3 = query.getInt(4);
                            long j = query.getLong(14);
                            long j2 = query.getLong(15);
                            long j3 = query.getLong(16);
                            int i4 = query.getInt(17);
                            WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                            BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i4);
                            long j4 = query.getLong(18);
                            long j5 = query.getLong(19);
                            int i5 = query.getInt(20);
                            long j6 = query.getLong(21);
                            int i6 = query.getInt(22);
                            int i7 = query.getInt(5);
                            WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                            NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i7);
                            byte[] blob = query.getBlob(6);
                            WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                            NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                            boolean z = query.getInt(7) != 0;
                            boolean z2 = query.getInt(8) != 0;
                            boolean z3 = query.getInt(9) != 0;
                            boolean z4 = query.getInt(10) != 0;
                            long j7 = query.getLong(11);
                            long j8 = query.getLong(12);
                            byte[] blob2 = query.getBlob(13);
                            WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                            arrayList.add(new WorkSpec.WorkInfoPojo(string3, intToState, fromByteArray, j, j2, j3, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z, z2, z3, z4, j7, j8, WorkTypeConverters.byteArrayToSetOfTriggers(blob2)), i2, intToBackoffPolicy, j4, j5, i5, i3, j6, i6, (ArrayList) hashMap.get(query.getString(0)), (ArrayList) hashMap2.get(query.getString(0))));
                        }
                        WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                        return arrayList;
                    } finally {
                        query.close();
                    }
                } finally {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForTag(final String tag) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        acquire.bindString(1, tag);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"}, true, new Callable<List<WorkSpec.WorkInfoPojo>>() { // from class: androidx.work.impl.model.WorkSpecDao_Impl.22
            @Override // java.util.concurrent.Callable
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, true, null);
                    try {
                        HashMap hashMap = new HashMap();
                        HashMap hashMap2 = new HashMap();
                        while (query.moveToNext()) {
                            String string = query.getString(0);
                            if (!hashMap.containsKey(string)) {
                                hashMap.put(string, new ArrayList());
                            }
                            String string2 = query.getString(0);
                            if (!hashMap2.containsKey(string2)) {
                                hashMap2.put(string2, new ArrayList());
                            }
                        }
                        query.moveToPosition(-1);
                        WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                        WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                        ArrayList arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            String string3 = query.getString(0);
                            int i = query.getInt(1);
                            WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                            WorkInfo.State intToState = WorkTypeConverters.intToState(i);
                            Data fromByteArray = Data.fromByteArray(query.getBlob(2));
                            int i2 = query.getInt(3);
                            int i3 = query.getInt(4);
                            long j = query.getLong(14);
                            long j2 = query.getLong(15);
                            long j3 = query.getLong(16);
                            int i4 = query.getInt(17);
                            WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                            BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i4);
                            long j4 = query.getLong(18);
                            long j5 = query.getLong(19);
                            int i5 = query.getInt(20);
                            long j6 = query.getLong(21);
                            int i6 = query.getInt(22);
                            int i7 = query.getInt(5);
                            WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                            NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i7);
                            byte[] blob = query.getBlob(6);
                            WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                            NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                            boolean z = query.getInt(7) != 0;
                            boolean z2 = query.getInt(8) != 0;
                            boolean z3 = query.getInt(9) != 0;
                            boolean z4 = query.getInt(10) != 0;
                            long j7 = query.getLong(11);
                            long j8 = query.getLong(12);
                            byte[] blob2 = query.getBlob(13);
                            WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                            arrayList.add(new WorkSpec.WorkInfoPojo(string3, intToState, fromByteArray, j, j2, j3, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z, z2, z3, z4, j7, j8, WorkTypeConverters.byteArrayToSetOfTriggers(blob2)), i2, intToBackoffPolicy, j4, j5, i5, i3, j6, i6, (ArrayList) hashMap.get(query.getString(0)), (ArrayList) hashMap2.get(query.getString(0))));
                        }
                        WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                        return arrayList;
                    } finally {
                        query.close();
                    }
                } finally {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForName(final String name) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        acquire.bindString(1, name);
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            Cursor query = DBUtil.query(this.__db, acquire, true, null);
            try {
                HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
                HashMap<String, ArrayList<Data>> hashMap2 = new HashMap<>();
                while (query.moveToNext()) {
                    String string = query.getString(0);
                    if (!hashMap.containsKey(string)) {
                        hashMap.put(string, new ArrayList<>());
                    }
                    String string2 = query.getString(0);
                    if (!hashMap2.containsKey(string2)) {
                        hashMap2.put(string2, new ArrayList<>());
                    }
                }
                query.moveToPosition(-1);
                __fetchRelationshipWorkTagAsjavaLangString(hashMap);
                __fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string3 = query.getString(0);
                    int i = query.getInt(1);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    WorkInfo.State intToState = WorkTypeConverters.intToState(i);
                    Data fromByteArray = Data.fromByteArray(query.getBlob(2));
                    int i2 = query.getInt(3);
                    int i3 = query.getInt(4);
                    long j = query.getLong(14);
                    long j2 = query.getLong(15);
                    long j3 = query.getLong(16);
                    int i4 = query.getInt(17);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i4);
                    long j4 = query.getLong(18);
                    long j5 = query.getLong(19);
                    int i5 = query.getInt(20);
                    long j6 = query.getLong(21);
                    int i6 = query.getInt(22);
                    int i7 = query.getInt(5);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i7);
                    byte[] blob = query.getBlob(6);
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                    boolean z = query.getInt(7) != 0;
                    boolean z2 = query.getInt(8) != 0;
                    boolean z3 = query.getInt(9) != 0;
                    boolean z4 = query.getInt(10) != 0;
                    long j7 = query.getLong(11);
                    long j8 = query.getLong(12);
                    byte[] blob2 = query.getBlob(13);
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    arrayList.add(new WorkSpec.WorkInfoPojo(string3, intToState, fromByteArray, j, j2, j3, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z, z2, z3, z4, j7, j8, WorkTypeConverters.byteArrayToSetOfTriggers(blob2)), i2, intToBackoffPolicy, j4, j5, i5, i3, j6, i6, hashMap.get(query.getString(0)), hashMap2.get(query.getString(0))));
                }
                this.__db.setTransactionSuccessful();
                return arrayList;
            } finally {
                query.close();
                acquire.release();
            }
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForName(final String name) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        acquire.bindString(1, name);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "workname"}, true, new Callable<List<WorkSpec.WorkInfoPojo>>() { // from class: androidx.work.impl.model.WorkSpecDao_Impl.23
            @Override // java.util.concurrent.Callable
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, true, null);
                    try {
                        HashMap hashMap = new HashMap();
                        HashMap hashMap2 = new HashMap();
                        while (query.moveToNext()) {
                            String string = query.getString(0);
                            if (!hashMap.containsKey(string)) {
                                hashMap.put(string, new ArrayList());
                            }
                            String string2 = query.getString(0);
                            if (!hashMap2.containsKey(string2)) {
                                hashMap2.put(string2, new ArrayList());
                            }
                        }
                        query.moveToPosition(-1);
                        WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                        WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                        ArrayList arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            String string3 = query.getString(0);
                            int i = query.getInt(1);
                            WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                            WorkInfo.State intToState = WorkTypeConverters.intToState(i);
                            Data fromByteArray = Data.fromByteArray(query.getBlob(2));
                            int i2 = query.getInt(3);
                            int i3 = query.getInt(4);
                            long j = query.getLong(14);
                            long j2 = query.getLong(15);
                            long j3 = query.getLong(16);
                            int i4 = query.getInt(17);
                            WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                            BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i4);
                            long j4 = query.getLong(18);
                            long j5 = query.getLong(19);
                            int i5 = query.getInt(20);
                            long j6 = query.getLong(21);
                            int i6 = query.getInt(22);
                            int i7 = query.getInt(5);
                            WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                            NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i7);
                            byte[] blob = query.getBlob(6);
                            WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                            NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                            boolean z = query.getInt(7) != 0;
                            boolean z2 = query.getInt(8) != 0;
                            boolean z3 = query.getInt(9) != 0;
                            boolean z4 = query.getInt(10) != 0;
                            long j7 = query.getLong(11);
                            long j8 = query.getLong(12);
                            byte[] blob2 = query.getBlob(13);
                            WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                            arrayList.add(new WorkSpec.WorkInfoPojo(string3, intToState, fromByteArray, j, j2, j3, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z, z2, z3, z4, j7, j8, WorkTypeConverters.byteArrayToSetOfTriggers(blob2)), i2, intToBackoffPolicy, j4, j5, i5, i3, j6, i6, (ArrayList) hashMap.get(query.getString(0)), (ArrayList) hashMap2.get(query.getString(0))));
                        }
                        WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                        return arrayList;
                    } finally {
                        query.close();
                    }
                } finally {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public Flow<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoFlowForName(final String name) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        acquire.bindString(1, name);
        return CoroutinesRoom.createFlow(this.__db, true, new String[]{"WorkTag", "WorkProgress", "workspec", "workname"}, new Callable<List<WorkSpec.WorkInfoPojo>>() { // from class: androidx.work.impl.model.WorkSpecDao_Impl.24
            @Override // java.util.concurrent.Callable
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, true, null);
                    try {
                        HashMap hashMap = new HashMap();
                        HashMap hashMap2 = new HashMap();
                        while (query.moveToNext()) {
                            String string = query.getString(0);
                            if (!hashMap.containsKey(string)) {
                                hashMap.put(string, new ArrayList());
                            }
                            String string2 = query.getString(0);
                            if (!hashMap2.containsKey(string2)) {
                                hashMap2.put(string2, new ArrayList());
                            }
                        }
                        query.moveToPosition(-1);
                        WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(hashMap);
                        WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(hashMap2);
                        ArrayList arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            String string3 = query.getString(0);
                            int i = query.getInt(1);
                            WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                            WorkInfo.State intToState = WorkTypeConverters.intToState(i);
                            Data fromByteArray = Data.fromByteArray(query.getBlob(2));
                            int i2 = query.getInt(3);
                            int i3 = query.getInt(4);
                            long j = query.getLong(14);
                            long j2 = query.getLong(15);
                            long j3 = query.getLong(16);
                            int i4 = query.getInt(17);
                            WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                            BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i4);
                            long j4 = query.getLong(18);
                            long j5 = query.getLong(19);
                            int i5 = query.getInt(20);
                            long j6 = query.getLong(21);
                            int i6 = query.getInt(22);
                            int i7 = query.getInt(5);
                            WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                            NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i7);
                            byte[] blob = query.getBlob(6);
                            WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                            NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                            boolean z = query.getInt(7) != 0;
                            boolean z2 = query.getInt(8) != 0;
                            boolean z3 = query.getInt(9) != 0;
                            boolean z4 = query.getInt(10) != 0;
                            long j7 = query.getLong(11);
                            long j8 = query.getLong(12);
                            byte[] blob2 = query.getBlob(13);
                            WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                            arrayList.add(new WorkSpec.WorkInfoPojo(string3, intToState, fromByteArray, j, j2, j3, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z, z2, z3, z4, j7, j8, WorkTypeConverters.byteArrayToSetOfTriggers(blob2)), i2, intToBackoffPolicy, j4, j5, i5, i3, j6, i6, (ArrayList) hashMap.get(query.getString(0)), (ArrayList) hashMap2.get(query.getString(0))));
                        }
                        WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                        return arrayList;
                    } finally {
                        query.close();
                    }
                } finally {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<Data> getInputsFromPrerequisites(final String id) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        acquire.bindString(1, id);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(Data.fromByteArray(query.getBlob(0)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getUnfinishedWorkWithTag(final String tag) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        acquire.bindString(1, tag);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getUnfinishedWorkWithName(final String name) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        acquire.bindString(1, name);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getAllUnfinishedWork() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public Flow<Boolean> hasUnfinishedWorkFlow() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"workspec"}, new Callable<Boolean>() { // from class: androidx.work.impl.model.WorkSpecDao_Impl.25
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                boolean z;
                Cursor query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, false, null);
                try {
                    if (query.moveToFirst()) {
                        z = Boolean.valueOf(query.getInt(0) != 0);
                    } else {
                        z = false;
                    }
                    return z;
                } finally {
                    query.close();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<Long> getScheduleRequestedAtLiveData(final String id) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT schedule_requested_at FROM workspec WHERE id=?", 1);
        acquire.bindString(1, id);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"workspec"}, false, new Callable<Long>() { // from class: androidx.work.impl.model.WorkSpecDao_Impl.26
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Long call() throws Exception {
                Long l = null;
                Cursor query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, false, null);
                try {
                    if (query.moveToFirst() && !query.isNull(0)) {
                        l = Long.valueOf(query.getLong(0));
                    }
                    return l;
                } finally {
                    query.close();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getEligibleWorkForScheduling(final int schedulerLimit) {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND LENGTH(content_uri_triggers)=0 AND state NOT IN (2, 3, 5))", 1);
        acquire.bindLong(1, schedulerLimit);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override_generation");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "stop_reason");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "trace_tag");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "required_network_request");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    int i2 = query.getInt(columnIndexOrThrow2);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    WorkInfo.State intToState = WorkTypeConverters.intToState(i2);
                    String string2 = query.getString(columnIndexOrThrow3);
                    String string3 = query.getString(columnIndexOrThrow4);
                    Data fromByteArray = Data.fromByteArray(query.getBlob(columnIndexOrThrow5));
                    Data fromByteArray2 = Data.fromByteArray(query.getBlob(columnIndexOrThrow6));
                    long j = query.getLong(columnIndexOrThrow7);
                    long j2 = query.getLong(columnIndexOrThrow8);
                    long j3 = query.getLong(columnIndexOrThrow9);
                    int i3 = query.getInt(columnIndexOrThrow10);
                    int i4 = query.getInt(columnIndexOrThrow11);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i4);
                    long j4 = query.getLong(columnIndexOrThrow12);
                    long j5 = query.getLong(columnIndexOrThrow13);
                    int i5 = i;
                    long j6 = query.getLong(i5);
                    int i6 = columnIndexOrThrow;
                    int i7 = columnIndexOrThrow15;
                    long j7 = query.getLong(i7);
                    columnIndexOrThrow15 = i7;
                    int i8 = columnIndexOrThrow16;
                    boolean z = query.getInt(i8) != 0;
                    columnIndexOrThrow16 = i8;
                    int i9 = columnIndexOrThrow17;
                    int i10 = query.getInt(i9);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(i10);
                    columnIndexOrThrow17 = i9;
                    int i11 = columnIndexOrThrow18;
                    int i12 = query.getInt(i11);
                    columnIndexOrThrow18 = i11;
                    int i13 = columnIndexOrThrow19;
                    int i14 = query.getInt(i13);
                    columnIndexOrThrow19 = i13;
                    int i15 = columnIndexOrThrow20;
                    long j8 = query.getLong(i15);
                    columnIndexOrThrow20 = i15;
                    int i16 = columnIndexOrThrow21;
                    int i17 = query.getInt(i16);
                    columnIndexOrThrow21 = i16;
                    int i18 = columnIndexOrThrow22;
                    int i19 = query.getInt(i18);
                    columnIndexOrThrow22 = i18;
                    int i20 = columnIndexOrThrow23;
                    String string4 = query.isNull(i20) ? null : query.getString(i20);
                    columnIndexOrThrow23 = i20;
                    int i21 = columnIndexOrThrow24;
                    int i22 = query.getInt(i21);
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i22);
                    columnIndexOrThrow24 = i21;
                    int i23 = columnIndexOrThrow25;
                    byte[] blob = query.getBlob(i23);
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                    columnIndexOrThrow25 = i23;
                    int i24 = columnIndexOrThrow26;
                    boolean z2 = query.getInt(i24) != 0;
                    columnIndexOrThrow26 = i24;
                    int i25 = columnIndexOrThrow27;
                    boolean z3 = query.getInt(i25) != 0;
                    columnIndexOrThrow27 = i25;
                    int i26 = columnIndexOrThrow28;
                    boolean z4 = query.getInt(i26) != 0;
                    columnIndexOrThrow28 = i26;
                    int i27 = columnIndexOrThrow29;
                    boolean z5 = query.getInt(i27) != 0;
                    columnIndexOrThrow29 = i27;
                    int i28 = columnIndexOrThrow30;
                    long j9 = query.getLong(i28);
                    columnIndexOrThrow30 = i28;
                    int i29 = columnIndexOrThrow31;
                    long j10 = query.getLong(i29);
                    columnIndexOrThrow31 = i29;
                    int i30 = columnIndexOrThrow32;
                    byte[] blob2 = query.getBlob(i30);
                    WorkTypeConverters workTypeConverters6 = WorkTypeConverters.INSTANCE;
                    WorkSpec workSpec = new WorkSpec(string, intToState, string2, string3, fromByteArray, fromByteArray2, j, j2, j3, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z2, z3, z4, z5, j9, j10, WorkTypeConverters.byteArrayToSetOfTriggers(blob2)), i3, intToBackoffPolicy, j4, j5, j6, j7, z, intToOutOfQuotaPolicy, i12, i14, j8, i17, i19, string4);
                    columnIndexOrThrow32 = i30;
                    arrayList.add(workSpec);
                    columnIndexOrThrow = i6;
                    i = i5;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getEligibleWorkForSchedulingWithContentUris() {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override_generation");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "stop_reason");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "trace_tag");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "required_network_request");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    int i2 = query.getInt(columnIndexOrThrow2);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    WorkInfo.State intToState = WorkTypeConverters.intToState(i2);
                    String string2 = query.getString(columnIndexOrThrow3);
                    String string3 = query.getString(columnIndexOrThrow4);
                    Data fromByteArray = Data.fromByteArray(query.getBlob(columnIndexOrThrow5));
                    Data fromByteArray2 = Data.fromByteArray(query.getBlob(columnIndexOrThrow6));
                    long j = query.getLong(columnIndexOrThrow7);
                    long j2 = query.getLong(columnIndexOrThrow8);
                    long j3 = query.getLong(columnIndexOrThrow9);
                    int i3 = query.getInt(columnIndexOrThrow10);
                    int i4 = query.getInt(columnIndexOrThrow11);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i4);
                    long j4 = query.getLong(columnIndexOrThrow12);
                    long j5 = query.getLong(columnIndexOrThrow13);
                    int i5 = i;
                    long j6 = query.getLong(i5);
                    int i6 = columnIndexOrThrow;
                    int i7 = columnIndexOrThrow15;
                    long j7 = query.getLong(i7);
                    columnIndexOrThrow15 = i7;
                    int i8 = columnIndexOrThrow16;
                    boolean z = query.getInt(i8) != 0;
                    columnIndexOrThrow16 = i8;
                    int i9 = columnIndexOrThrow17;
                    int i10 = query.getInt(i9);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(i10);
                    columnIndexOrThrow17 = i9;
                    int i11 = columnIndexOrThrow18;
                    int i12 = query.getInt(i11);
                    columnIndexOrThrow18 = i11;
                    int i13 = columnIndexOrThrow19;
                    int i14 = query.getInt(i13);
                    columnIndexOrThrow19 = i13;
                    int i15 = columnIndexOrThrow20;
                    long j8 = query.getLong(i15);
                    columnIndexOrThrow20 = i15;
                    int i16 = columnIndexOrThrow21;
                    int i17 = query.getInt(i16);
                    columnIndexOrThrow21 = i16;
                    int i18 = columnIndexOrThrow22;
                    int i19 = query.getInt(i18);
                    columnIndexOrThrow22 = i18;
                    int i20 = columnIndexOrThrow23;
                    String string4 = query.isNull(i20) ? null : query.getString(i20);
                    columnIndexOrThrow23 = i20;
                    int i21 = columnIndexOrThrow24;
                    int i22 = query.getInt(i21);
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i22);
                    columnIndexOrThrow24 = i21;
                    int i23 = columnIndexOrThrow25;
                    byte[] blob = query.getBlob(i23);
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                    columnIndexOrThrow25 = i23;
                    int i24 = columnIndexOrThrow26;
                    boolean z2 = query.getInt(i24) != 0;
                    columnIndexOrThrow26 = i24;
                    int i25 = columnIndexOrThrow27;
                    boolean z3 = query.getInt(i25) != 0;
                    columnIndexOrThrow27 = i25;
                    int i26 = columnIndexOrThrow28;
                    boolean z4 = query.getInt(i26) != 0;
                    columnIndexOrThrow28 = i26;
                    int i27 = columnIndexOrThrow29;
                    boolean z5 = query.getInt(i27) != 0;
                    columnIndexOrThrow29 = i27;
                    int i28 = columnIndexOrThrow30;
                    long j9 = query.getLong(i28);
                    columnIndexOrThrow30 = i28;
                    int i29 = columnIndexOrThrow31;
                    long j10 = query.getLong(i29);
                    columnIndexOrThrow31 = i29;
                    int i30 = columnIndexOrThrow32;
                    byte[] blob2 = query.getBlob(i30);
                    WorkTypeConverters workTypeConverters6 = WorkTypeConverters.INSTANCE;
                    WorkSpec workSpec = new WorkSpec(string, intToState, string2, string3, fromByteArray, fromByteArray2, j, j2, j3, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z2, z3, z4, z5, j9, j10, WorkTypeConverters.byteArrayToSetOfTriggers(blob2)), i3, intToBackoffPolicy, j4, j5, j6, j7, z, intToOutOfQuotaPolicy, i12, i14, j8, i17, i19, string4);
                    columnIndexOrThrow32 = i30;
                    arrayList.add(workSpec);
                    columnIndexOrThrow = i6;
                    i = i5;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getAllEligibleWorkSpecsForScheduling(final int maxLimit) {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?", 1);
        acquire.bindLong(1, maxLimit);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override_generation");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "stop_reason");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "trace_tag");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "required_network_request");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    int i2 = query.getInt(columnIndexOrThrow2);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    WorkInfo.State intToState = WorkTypeConverters.intToState(i2);
                    String string2 = query.getString(columnIndexOrThrow3);
                    String string3 = query.getString(columnIndexOrThrow4);
                    Data fromByteArray = Data.fromByteArray(query.getBlob(columnIndexOrThrow5));
                    Data fromByteArray2 = Data.fromByteArray(query.getBlob(columnIndexOrThrow6));
                    long j = query.getLong(columnIndexOrThrow7);
                    long j2 = query.getLong(columnIndexOrThrow8);
                    long j3 = query.getLong(columnIndexOrThrow9);
                    int i3 = query.getInt(columnIndexOrThrow10);
                    int i4 = query.getInt(columnIndexOrThrow11);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i4);
                    long j4 = query.getLong(columnIndexOrThrow12);
                    long j5 = query.getLong(columnIndexOrThrow13);
                    int i5 = i;
                    long j6 = query.getLong(i5);
                    int i6 = columnIndexOrThrow;
                    int i7 = columnIndexOrThrow15;
                    long j7 = query.getLong(i7);
                    columnIndexOrThrow15 = i7;
                    int i8 = columnIndexOrThrow16;
                    boolean z = query.getInt(i8) != 0;
                    columnIndexOrThrow16 = i8;
                    int i9 = columnIndexOrThrow17;
                    int i10 = query.getInt(i9);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(i10);
                    columnIndexOrThrow17 = i9;
                    int i11 = columnIndexOrThrow18;
                    int i12 = query.getInt(i11);
                    columnIndexOrThrow18 = i11;
                    int i13 = columnIndexOrThrow19;
                    int i14 = query.getInt(i13);
                    columnIndexOrThrow19 = i13;
                    int i15 = columnIndexOrThrow20;
                    long j8 = query.getLong(i15);
                    columnIndexOrThrow20 = i15;
                    int i16 = columnIndexOrThrow21;
                    int i17 = query.getInt(i16);
                    columnIndexOrThrow21 = i16;
                    int i18 = columnIndexOrThrow22;
                    int i19 = query.getInt(i18);
                    columnIndexOrThrow22 = i18;
                    int i20 = columnIndexOrThrow23;
                    String string4 = query.isNull(i20) ? null : query.getString(i20);
                    columnIndexOrThrow23 = i20;
                    int i21 = columnIndexOrThrow24;
                    int i22 = query.getInt(i21);
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i22);
                    columnIndexOrThrow24 = i21;
                    int i23 = columnIndexOrThrow25;
                    byte[] blob = query.getBlob(i23);
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                    columnIndexOrThrow25 = i23;
                    int i24 = columnIndexOrThrow26;
                    boolean z2 = query.getInt(i24) != 0;
                    columnIndexOrThrow26 = i24;
                    int i25 = columnIndexOrThrow27;
                    boolean z3 = query.getInt(i25) != 0;
                    columnIndexOrThrow27 = i25;
                    int i26 = columnIndexOrThrow28;
                    boolean z4 = query.getInt(i26) != 0;
                    columnIndexOrThrow28 = i26;
                    int i27 = columnIndexOrThrow29;
                    boolean z5 = query.getInt(i27) != 0;
                    columnIndexOrThrow29 = i27;
                    int i28 = columnIndexOrThrow30;
                    long j9 = query.getLong(i28);
                    columnIndexOrThrow30 = i28;
                    int i29 = columnIndexOrThrow31;
                    long j10 = query.getLong(i29);
                    columnIndexOrThrow31 = i29;
                    int i30 = columnIndexOrThrow32;
                    byte[] blob2 = query.getBlob(i30);
                    WorkTypeConverters workTypeConverters6 = WorkTypeConverters.INSTANCE;
                    WorkSpec workSpec = new WorkSpec(string, intToState, string2, string3, fromByteArray, fromByteArray2, j, j2, j3, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z2, z3, z4, z5, j9, j10, WorkTypeConverters.byteArrayToSetOfTriggers(blob2)), i3, intToBackoffPolicy, j4, j5, j6, j7, z, intToOutOfQuotaPolicy, i12, i14, j8, i17, i19, string4);
                    columnIndexOrThrow32 = i30;
                    arrayList.add(workSpec);
                    columnIndexOrThrow = i6;
                    i = i5;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getScheduledWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override_generation");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "stop_reason");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "trace_tag");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "required_network_request");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    int i2 = query.getInt(columnIndexOrThrow2);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    WorkInfo.State intToState = WorkTypeConverters.intToState(i2);
                    String string2 = query.getString(columnIndexOrThrow3);
                    String string3 = query.getString(columnIndexOrThrow4);
                    Data fromByteArray = Data.fromByteArray(query.getBlob(columnIndexOrThrow5));
                    Data fromByteArray2 = Data.fromByteArray(query.getBlob(columnIndexOrThrow6));
                    long j = query.getLong(columnIndexOrThrow7);
                    long j2 = query.getLong(columnIndexOrThrow8);
                    long j3 = query.getLong(columnIndexOrThrow9);
                    int i3 = query.getInt(columnIndexOrThrow10);
                    int i4 = query.getInt(columnIndexOrThrow11);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i4);
                    long j4 = query.getLong(columnIndexOrThrow12);
                    long j5 = query.getLong(columnIndexOrThrow13);
                    int i5 = i;
                    long j6 = query.getLong(i5);
                    int i6 = columnIndexOrThrow;
                    int i7 = columnIndexOrThrow15;
                    long j7 = query.getLong(i7);
                    columnIndexOrThrow15 = i7;
                    int i8 = columnIndexOrThrow16;
                    boolean z = query.getInt(i8) != 0;
                    columnIndexOrThrow16 = i8;
                    int i9 = columnIndexOrThrow17;
                    int i10 = query.getInt(i9);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(i10);
                    columnIndexOrThrow17 = i9;
                    int i11 = columnIndexOrThrow18;
                    int i12 = query.getInt(i11);
                    columnIndexOrThrow18 = i11;
                    int i13 = columnIndexOrThrow19;
                    int i14 = query.getInt(i13);
                    columnIndexOrThrow19 = i13;
                    int i15 = columnIndexOrThrow20;
                    long j8 = query.getLong(i15);
                    columnIndexOrThrow20 = i15;
                    int i16 = columnIndexOrThrow21;
                    int i17 = query.getInt(i16);
                    columnIndexOrThrow21 = i16;
                    int i18 = columnIndexOrThrow22;
                    int i19 = query.getInt(i18);
                    columnIndexOrThrow22 = i18;
                    int i20 = columnIndexOrThrow23;
                    String string4 = query.isNull(i20) ? null : query.getString(i20);
                    columnIndexOrThrow23 = i20;
                    int i21 = columnIndexOrThrow24;
                    int i22 = query.getInt(i21);
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i22);
                    columnIndexOrThrow24 = i21;
                    int i23 = columnIndexOrThrow25;
                    byte[] blob = query.getBlob(i23);
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                    columnIndexOrThrow25 = i23;
                    int i24 = columnIndexOrThrow26;
                    boolean z2 = query.getInt(i24) != 0;
                    columnIndexOrThrow26 = i24;
                    int i25 = columnIndexOrThrow27;
                    boolean z3 = query.getInt(i25) != 0;
                    columnIndexOrThrow27 = i25;
                    int i26 = columnIndexOrThrow28;
                    boolean z4 = query.getInt(i26) != 0;
                    columnIndexOrThrow28 = i26;
                    int i27 = columnIndexOrThrow29;
                    boolean z5 = query.getInt(i27) != 0;
                    columnIndexOrThrow29 = i27;
                    int i28 = columnIndexOrThrow30;
                    long j9 = query.getLong(i28);
                    columnIndexOrThrow30 = i28;
                    int i29 = columnIndexOrThrow31;
                    long j10 = query.getLong(i29);
                    columnIndexOrThrow31 = i29;
                    int i30 = columnIndexOrThrow32;
                    byte[] blob2 = query.getBlob(i30);
                    WorkTypeConverters workTypeConverters6 = WorkTypeConverters.INSTANCE;
                    WorkSpec workSpec = new WorkSpec(string, intToState, string2, string3, fromByteArray, fromByteArray2, j, j2, j3, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z2, z3, z4, z5, j9, j10, WorkTypeConverters.byteArrayToSetOfTriggers(blob2)), i3, intToBackoffPolicy, j4, j5, j6, j7, z, intToOutOfQuotaPolicy, i12, i14, j8, i17, i19, string4);
                    columnIndexOrThrow32 = i30;
                    arrayList.add(workSpec);
                    columnIndexOrThrow = i6;
                    i = i5;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getRunningWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override_generation");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "stop_reason");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "trace_tag");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "required_network_request");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    int i2 = query.getInt(columnIndexOrThrow2);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    WorkInfo.State intToState = WorkTypeConverters.intToState(i2);
                    String string2 = query.getString(columnIndexOrThrow3);
                    String string3 = query.getString(columnIndexOrThrow4);
                    Data fromByteArray = Data.fromByteArray(query.getBlob(columnIndexOrThrow5));
                    Data fromByteArray2 = Data.fromByteArray(query.getBlob(columnIndexOrThrow6));
                    long j = query.getLong(columnIndexOrThrow7);
                    long j2 = query.getLong(columnIndexOrThrow8);
                    long j3 = query.getLong(columnIndexOrThrow9);
                    int i3 = query.getInt(columnIndexOrThrow10);
                    int i4 = query.getInt(columnIndexOrThrow11);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i4);
                    long j4 = query.getLong(columnIndexOrThrow12);
                    long j5 = query.getLong(columnIndexOrThrow13);
                    int i5 = i;
                    long j6 = query.getLong(i5);
                    int i6 = columnIndexOrThrow;
                    int i7 = columnIndexOrThrow15;
                    long j7 = query.getLong(i7);
                    columnIndexOrThrow15 = i7;
                    int i8 = columnIndexOrThrow16;
                    boolean z = query.getInt(i8) != 0;
                    columnIndexOrThrow16 = i8;
                    int i9 = columnIndexOrThrow17;
                    int i10 = query.getInt(i9);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(i10);
                    columnIndexOrThrow17 = i9;
                    int i11 = columnIndexOrThrow18;
                    int i12 = query.getInt(i11);
                    columnIndexOrThrow18 = i11;
                    int i13 = columnIndexOrThrow19;
                    int i14 = query.getInt(i13);
                    columnIndexOrThrow19 = i13;
                    int i15 = columnIndexOrThrow20;
                    long j8 = query.getLong(i15);
                    columnIndexOrThrow20 = i15;
                    int i16 = columnIndexOrThrow21;
                    int i17 = query.getInt(i16);
                    columnIndexOrThrow21 = i16;
                    int i18 = columnIndexOrThrow22;
                    int i19 = query.getInt(i18);
                    columnIndexOrThrow22 = i18;
                    int i20 = columnIndexOrThrow23;
                    String string4 = query.isNull(i20) ? null : query.getString(i20);
                    columnIndexOrThrow23 = i20;
                    int i21 = columnIndexOrThrow24;
                    int i22 = query.getInt(i21);
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i22);
                    columnIndexOrThrow24 = i21;
                    int i23 = columnIndexOrThrow25;
                    byte[] blob = query.getBlob(i23);
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                    columnIndexOrThrow25 = i23;
                    int i24 = columnIndexOrThrow26;
                    boolean z2 = query.getInt(i24) != 0;
                    columnIndexOrThrow26 = i24;
                    int i25 = columnIndexOrThrow27;
                    boolean z3 = query.getInt(i25) != 0;
                    columnIndexOrThrow27 = i25;
                    int i26 = columnIndexOrThrow28;
                    boolean z4 = query.getInt(i26) != 0;
                    columnIndexOrThrow28 = i26;
                    int i27 = columnIndexOrThrow29;
                    boolean z5 = query.getInt(i27) != 0;
                    columnIndexOrThrow29 = i27;
                    int i28 = columnIndexOrThrow30;
                    long j9 = query.getLong(i28);
                    columnIndexOrThrow30 = i28;
                    int i29 = columnIndexOrThrow31;
                    long j10 = query.getLong(i29);
                    columnIndexOrThrow31 = i29;
                    int i30 = columnIndexOrThrow32;
                    byte[] blob2 = query.getBlob(i30);
                    WorkTypeConverters workTypeConverters6 = WorkTypeConverters.INSTANCE;
                    WorkSpec workSpec = new WorkSpec(string, intToState, string2, string3, fromByteArray, fromByteArray2, j, j2, j3, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z2, z3, z4, z5, j9, j10, WorkTypeConverters.byteArrayToSetOfTriggers(blob2)), i3, intToBackoffPolicy, j4, j5, j6, j7, z, intToOutOfQuotaPolicy, i12, i14, j8, i17, i19, string4);
                    columnIndexOrThrow32 = i30;
                    arrayList.add(workSpec);
                    columnIndexOrThrow = i6;
                    i = i5;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getRecentlyCompletedWork(final long startingAt) {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC", 1);
        acquire.bindLong(1, startingAt);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "next_schedule_time_override_generation");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "stop_reason");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "trace_tag");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "required_network_request");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow);
                    int i2 = query.getInt(columnIndexOrThrow2);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    WorkInfo.State intToState = WorkTypeConverters.intToState(i2);
                    String string2 = query.getString(columnIndexOrThrow3);
                    String string3 = query.getString(columnIndexOrThrow4);
                    Data fromByteArray = Data.fromByteArray(query.getBlob(columnIndexOrThrow5));
                    Data fromByteArray2 = Data.fromByteArray(query.getBlob(columnIndexOrThrow6));
                    long j = query.getLong(columnIndexOrThrow7);
                    long j2 = query.getLong(columnIndexOrThrow8);
                    long j3 = query.getLong(columnIndexOrThrow9);
                    int i3 = query.getInt(columnIndexOrThrow10);
                    int i4 = query.getInt(columnIndexOrThrow11);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i4);
                    long j4 = query.getLong(columnIndexOrThrow12);
                    long j5 = query.getLong(columnIndexOrThrow13);
                    int i5 = i;
                    long j6 = query.getLong(i5);
                    int i6 = columnIndexOrThrow;
                    int i7 = columnIndexOrThrow15;
                    long j7 = query.getLong(i7);
                    columnIndexOrThrow15 = i7;
                    int i8 = columnIndexOrThrow16;
                    boolean z = query.getInt(i8) != 0;
                    columnIndexOrThrow16 = i8;
                    int i9 = columnIndexOrThrow17;
                    int i10 = query.getInt(i9);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(i10);
                    columnIndexOrThrow17 = i9;
                    int i11 = columnIndexOrThrow18;
                    int i12 = query.getInt(i11);
                    columnIndexOrThrow18 = i11;
                    int i13 = columnIndexOrThrow19;
                    int i14 = query.getInt(i13);
                    columnIndexOrThrow19 = i13;
                    int i15 = columnIndexOrThrow20;
                    long j8 = query.getLong(i15);
                    columnIndexOrThrow20 = i15;
                    int i16 = columnIndexOrThrow21;
                    int i17 = query.getInt(i16);
                    columnIndexOrThrow21 = i16;
                    int i18 = columnIndexOrThrow22;
                    int i19 = query.getInt(i18);
                    columnIndexOrThrow22 = i18;
                    int i20 = columnIndexOrThrow23;
                    String string4 = query.isNull(i20) ? null : query.getString(i20);
                    columnIndexOrThrow23 = i20;
                    int i21 = columnIndexOrThrow24;
                    int i22 = query.getInt(i21);
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i22);
                    columnIndexOrThrow24 = i21;
                    int i23 = columnIndexOrThrow25;
                    byte[] blob = query.getBlob(i23);
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(blob);
                    columnIndexOrThrow25 = i23;
                    int i24 = columnIndexOrThrow26;
                    boolean z2 = query.getInt(i24) != 0;
                    columnIndexOrThrow26 = i24;
                    int i25 = columnIndexOrThrow27;
                    boolean z3 = query.getInt(i25) != 0;
                    columnIndexOrThrow27 = i25;
                    int i26 = columnIndexOrThrow28;
                    boolean z4 = query.getInt(i26) != 0;
                    columnIndexOrThrow28 = i26;
                    int i27 = columnIndexOrThrow29;
                    boolean z5 = query.getInt(i27) != 0;
                    columnIndexOrThrow29 = i27;
                    int i28 = columnIndexOrThrow30;
                    long j9 = query.getLong(i28);
                    columnIndexOrThrow30 = i28;
                    int i29 = columnIndexOrThrow31;
                    long j10 = query.getLong(i29);
                    columnIndexOrThrow31 = i29;
                    int i30 = columnIndexOrThrow32;
                    byte[] blob2 = query.getBlob(i30);
                    WorkTypeConverters workTypeConverters6 = WorkTypeConverters.INSTANCE;
                    WorkSpec workSpec = new WorkSpec(string, intToState, string2, string3, fromByteArray, fromByteArray2, j, j2, j3, new Constraints(networkRequest$work_runtime_release, intToNetworkType, z2, z3, z4, z5, j9, j10, WorkTypeConverters.byteArrayToSetOfTriggers(blob2)), i3, intToBackoffPolicy, j4, j5, j6, j7, z, intToOutOfQuotaPolicy, i12, i14, j8, i17, i19, string4);
                    columnIndexOrThrow32 = i30;
                    arrayList.add(workSpec);
                    columnIndexOrThrow = i6;
                    i = i5;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int countNonFinishedContentUriTriggerWorkers() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("Select COUNT(*) FROM workspec WHERE LENGTH(content_uri_triggers)<>0 AND state NOT IN (2, 3, 5)", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            return query.moveToFirst() ? query.getInt(0) : 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipWorkTagAsjavaLangString(final HashMap<String, ArrayList<String>> _map) {
        Set<String> keySet = _map.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        if (_map.size() > 999) {
            RelationUtil.recursiveFetchHashMap(_map, true, new Function1() { // from class: androidx.work.impl.model.WorkSpecDao_Impl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WorkSpecDao_Impl.this.m7605x1b70a561((HashMap) obj);
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int size = keySet.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        Iterator<String> it = keySet.iterator();
        int i = 1;
        while (it.hasNext()) {
            acquire.bindString(i, it.next());
            i++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                ArrayList<String> arrayList = _map.get(query.getString(columnIndex));
                if (arrayList != null) {
                    arrayList.add(query.getString(0));
                }
            }
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$__fetchRelationshipWorkTagAsjavaLangString$0$androidx-work-impl-model-WorkSpecDao_Impl, reason: not valid java name */
    public /* synthetic */ Unit m7605x1b70a561(HashMap hashMap) {
        __fetchRelationshipWorkTagAsjavaLangString(hashMap);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipWorkProgressAsandroidxWorkData(final HashMap<String, ArrayList<Data>> _map) {
        Set<String> keySet = _map.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        if (_map.size() > 999) {
            RelationUtil.recursiveFetchHashMap(_map, true, new Function1() { // from class: androidx.work.impl.model.WorkSpecDao_Impl$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WorkSpecDao_Impl.this.m7604xd91acf84((HashMap) obj);
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int size = keySet.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        Iterator<String> it = keySet.iterator();
        int i = 1;
        while (it.hasNext()) {
            acquire.bindString(i, it.next());
            i++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                ArrayList<Data> arrayList = _map.get(query.getString(columnIndex));
                if (arrayList != null) {
                    arrayList.add(Data.fromByteArray(query.getBlob(0)));
                }
            }
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$__fetchRelationshipWorkProgressAsandroidxWorkData$1$androidx-work-impl-model-WorkSpecDao_Impl, reason: not valid java name */
    public /* synthetic */ Unit m7604xd91acf84(HashMap hashMap) {
        __fetchRelationshipWorkProgressAsandroidxWorkData(hashMap);
        return Unit.INSTANCE;
    }
}
