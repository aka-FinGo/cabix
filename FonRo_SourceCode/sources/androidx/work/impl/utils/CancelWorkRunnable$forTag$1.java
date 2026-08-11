package androidx.work.impl.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CancelWorkRunnable.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class CancelWorkRunnable$forTag$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $tag;
    final /* synthetic */ WorkManagerImpl $workManagerImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CancelWorkRunnable$forTag$1(WorkManagerImpl workManagerImpl, String str) {
        super(0);
        this.$workManagerImpl = workManagerImpl;
        this.$tag = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        final WorkDatabase workDatabase = this.$workManagerImpl.getWorkDatabase();
        Intrinsics.checkNotNullExpressionValue(workDatabase, "workManagerImpl.workDatabase");
        final String str = this.$tag;
        final WorkManagerImpl workManagerImpl = this.$workManagerImpl;
        workDatabase.runInTransaction(new Runnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable$forTag$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CancelWorkRunnable$forTag$1.invoke$lambda$0(WorkDatabase.this, str, workManagerImpl);
            }
        });
        CancelWorkRunnable.reschedulePendingWorkers(this.$workManagerImpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void invoke$lambda$0(WorkDatabase workDatabase, String str, WorkManagerImpl workManagerImpl) {
        Iterator<String> it = workDatabase.workSpecDao().getUnfinishedWorkWithTag(str).iterator();
        while (it.hasNext()) {
            CancelWorkRunnable.cancel(workManagerImpl, it.next());
        }
    }
}
