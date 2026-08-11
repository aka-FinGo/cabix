package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Snapshot.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0001\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\b\u00102\u001a\u00020\u0006H\u0016J\b\u00103\u001a\u00020\bH\u0016J\u0015\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0001H\u0010¢\u0006\u0002\b7J\u0015\u00108\u001a\u0002052\u0006\u00106\u001a\u00020\u0001H\u0010¢\u0006\u0002\b9J\r\u0010:\u001a\u00020\u0006H\u0010¢\u0006\u0002\b;J\u0015\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u0016H\u0010¢\u0006\u0002\b>J\u001e\u0010?\u001a\u00020\u00012\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8P@PX\u0090\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158P@VX\u0090\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004@VX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\rR,\u0010)\u001a\u00060'j\u0002`(2\n\u0010\u000e\u001a\u00060'j\u0002`(8V@PX\u0096\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020'X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\"\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001f¨\u0006@"}, d2 = {"Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "previousSnapshot", "specifiedReadObserver", "Lkotlin/Function1;", "", "", "mergeParentObservers", "", "ownsPreviousSnapshot", "(Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;ZZ)V", "currentSnapshot", "getCurrentSnapshot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "value", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invalid", "getInvalid$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "modified", "getModified$runtime_release", "()Landroidx/collection/MutableScatterSet;", "setModified", "(Landroidx/collection/MutableScatterSet;)V", "<set-?>", "readObserver", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "setReadObserver", "(Lkotlin/jvm/functions/Function1;)V", "readOnly", "getReadOnly", "()Z", "root", "getRoot", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "snapshotId", "getSnapshotId", "()J", "setSnapshotId$runtime_release", "(J)V", "threadId", "getThreadId$runtime_release", "writeObserver", "getWriteObserver$runtime_release", "dispose", "hasPendingChanges", "nestedActivated", "", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "takeNestedSnapshot", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class TransparentObserverSnapshot extends Snapshot {
    public static final int $stable = 8;
    private final boolean mergeParentObservers;
    private final boolean ownsPreviousSnapshot;
    private final Snapshot previousSnapshot;
    private Function1<Object, Unit> readObserver;
    private final Snapshot root;
    private final long threadId;
    private final Function1<Object, Unit> writeObserver;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TransparentObserverSnapshot(androidx.compose.runtime.snapshots.Snapshot r5, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r6, boolean r7, boolean r8) {
        /*
            r4 = this;
            long r0 = androidx.compose.runtime.snapshots.SnapshotKt.access$getINVALID_SNAPSHOT$p()
            androidx.compose.runtime.snapshots.SnapshotIdSet$Companion r2 = androidx.compose.runtime.snapshots.SnapshotIdSet.INSTANCE
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r2.getEMPTY()
            r3 = 0
            r4.<init>(r0, r2, r3)
            r4.previousSnapshot = r5
            r4.mergeParentObservers = r7
            r4.ownsPreviousSnapshot = r8
            if (r5 == 0) goto L1c
            kotlin.jvm.functions.Function1 r5 = r5.getReadObserver()
            if (r5 != 0) goto L24
        L1c:
            androidx.compose.runtime.snapshots.GlobalSnapshot r5 = androidx.compose.runtime.snapshots.SnapshotKt.access$getGlobalSnapshot$p()
            kotlin.jvm.functions.Function1 r5 = r5.getReadObserver()
        L24:
            kotlin.jvm.functions.Function1 r5 = androidx.compose.runtime.snapshots.SnapshotKt.access$mergedReadObserver(r6, r5, r7)
            r4.readObserver = r5
            long r5 = androidx.compose.runtime.internal.Thread_jvmKt.currentThreadId()
            r4.threadId = r5
            r5 = r4
            androidx.compose.runtime.snapshots.Snapshot r5 = (androidx.compose.runtime.snapshots.Snapshot) r5
            r4.root = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.TransparentObserverSnapshot.<init>(androidx.compose.runtime.snapshots.Snapshot, kotlin.jvm.functions.Function1, boolean, boolean):void");
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: getReadObserver$runtime_release, reason: merged with bridge method [inline-methods] */
    public Function1<Object, Unit> getReadObserver() {
        return this.readObserver;
    }

    public void setReadObserver(Function1<Object, Unit> function1) {
        this.readObserver = function1;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    /* renamed from: getThreadId$runtime_release, reason: from getter */
    public final long getThreadId() {
        return this.threadId;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot getRoot() {
        return this.root;
    }

    private final Snapshot getCurrentSnapshot() {
        GlobalSnapshot globalSnapshot;
        Snapshot snapshot = this.previousSnapshot;
        if (snapshot != null) {
            return snapshot;
        }
        globalSnapshot = SnapshotKt.globalSnapshot;
        return globalSnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        Snapshot snapshot;
        setDisposed$runtime_release(true);
        if (!this.ownsPreviousSnapshot || (snapshot = this.previousSnapshot) == null) {
            return;
        }
        snapshot.dispose();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public long getSnapshotId() {
        return getCurrentSnapshot().getSnapshotId();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setSnapshotId$runtime_release(long j) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: getInvalid$runtime_release */
    public SnapshotIdSet getInvalid() {
        return getCurrentSnapshot().getInvalid();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setInvalid$runtime_release(SnapshotIdSet snapshotIdSet) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        return getCurrentSnapshot().hasPendingChanges();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public MutableScatterSet<StateObject> getModified$runtime_release() {
        return getCurrentSnapshot().getModified$runtime_release();
    }

    public void setModified(MutableScatterSet<StateObject> mutableScatterSet) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return getCurrentSnapshot().getReadOnly();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: recordModified$runtime_release */
    public void mo3926recordModified$runtime_release(StateObject state) {
        getCurrentSnapshot().mo3926recordModified$runtime_release(state);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot takeNestedSnapshot(Function1<Object, Unit> readObserver) {
        Snapshot createTransparentSnapshotWithNoParentReadObserver;
        Function1<Object, Unit> mergedReadObserver$default = SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver(), false, 4, null);
        if (!this.mergeParentObservers) {
            createTransparentSnapshotWithNoParentReadObserver = SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(getCurrentSnapshot().takeNestedSnapshot(null), mergedReadObserver$default, true);
            return createTransparentSnapshotWithNoParentReadObserver;
        }
        return getCurrentSnapshot().takeNestedSnapshot(mergedReadObserver$default);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        getCurrentSnapshot().notifyObjectsInitialized$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedActivated$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void mo3924nestedActivated$runtime_release(Snapshot snapshot) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedDeactivated$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void mo3925nestedDeactivated$runtime_release(Snapshot snapshot) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }
}
