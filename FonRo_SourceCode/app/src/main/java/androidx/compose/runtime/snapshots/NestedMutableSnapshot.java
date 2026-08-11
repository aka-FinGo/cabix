package androidx.compose.runtime.snapshots;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Snapshot.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BM\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\u0001¢\u0006\u0002\u0010\rJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\nH\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/snapshots/NestedMutableSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "parent", "(JLandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/snapshots/MutableSnapshot;)V", "deactivated", "", "getParent", "()Landroidx/compose/runtime/snapshots/MutableSnapshot;", "root", "Landroidx/compose/runtime/snapshots/Snapshot;", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "deactivate", "dispose", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class NestedMutableSnapshot extends MutableSnapshot {
    public static final int $stable = 8;
    private boolean deactivated;
    private final MutableSnapshot parent;

    public final MutableSnapshot getParent() {
        return this.parent;
    }

    public NestedMutableSnapshot(long j, SnapshotIdSet snapshotIdSet, Function1<Object, Unit> function1, Function1<Object, Unit> function12, MutableSnapshot mutableSnapshot) {
        super(j, snapshotIdSet, function1, function12);
        this.parent = mutableSnapshot;
        mutableSnapshot.mo3924nestedActivated$runtime_release(this);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public Snapshot getRoot() {
        return this.parent.getRoot();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed()) {
            return;
        }
        super.dispose();
        deactivate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0070, code lost:
    
        if (r10 == null) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0089 A[Catch: all -> 0x00da, TryCatch #0 {, blocks: (B:11:0x0038, B:13:0x0040, B:16:0x0047, B:21:0x0062, B:23:0x006a, B:25:0x007f, B:27:0x0089, B:28:0x008e, B:33:0x0072, B:34:0x007b), top: B:10:0x0038 }] */
    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.compose.runtime.snapshots.SnapshotApplyResult apply() {
        /*
            r10 = this;
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r10.parent
            boolean r0 = r0.getApplied()
            if (r0 != 0) goto Lde
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r10.parent
            boolean r0 = r0.getDisposed()
            if (r0 == 0) goto L12
            goto Lde
        L12:
            androidx.collection.MutableScatterSet r4 = r10.getModified$runtime_release()
            long r7 = r10.getSnapshotId()
            r0 = 0
            if (r4 == 0) goto L32
            androidx.compose.runtime.snapshots.MutableSnapshot r1 = r10.parent
            long r1 = r1.getSnapshotId()
            r3 = r10
            androidx.compose.runtime.snapshots.MutableSnapshot r3 = (androidx.compose.runtime.snapshots.MutableSnapshot) r3
            androidx.compose.runtime.snapshots.MutableSnapshot r5 = r10.parent
            androidx.compose.runtime.snapshots.SnapshotIdSet r5 = r5.getInvalid()
            java.util.Map r1 = androidx.compose.runtime.snapshots.SnapshotKt.access$optimisticMerges(r1, r3, r5)
            r5 = r1
            goto L33
        L32:
            r5 = r0
        L33:
            java.lang.Object r9 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r9)
            r1 = r10
            androidx.compose.runtime.snapshots.Snapshot r1 = (androidx.compose.runtime.snapshots.Snapshot) r1     // Catch: java.lang.Throwable -> Lda
            androidx.compose.runtime.snapshots.SnapshotKt.access$validateOpen(r1)     // Catch: java.lang.Throwable -> Lda
            if (r4 == 0) goto L7b
            int r1 = r4.get_size()     // Catch: java.lang.Throwable -> Lda
            if (r1 != 0) goto L47
            goto L7b
        L47:
            androidx.compose.runtime.snapshots.MutableSnapshot r1 = r10.parent     // Catch: java.lang.Throwable -> Lda
            long r2 = r1.getSnapshotId()     // Catch: java.lang.Throwable -> Lda
            androidx.compose.runtime.snapshots.MutableSnapshot r1 = r10.parent     // Catch: java.lang.Throwable -> Lda
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r1.getInvalid()     // Catch: java.lang.Throwable -> Lda
            r1 = r10
            androidx.compose.runtime.snapshots.SnapshotApplyResult r10 = r1.innerApplyLocked$runtime_release(r2, r4, r5, r6)     // Catch: java.lang.Throwable -> Lda
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r2 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE     // Catch: java.lang.Throwable -> Lda
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r2)     // Catch: java.lang.Throwable -> Lda
            if (r2 != 0) goto L62
            monitor-exit(r9)
            return r10
        L62:
            androidx.compose.runtime.snapshots.MutableSnapshot r10 = r1.parent     // Catch: java.lang.Throwable -> Lda
            androidx.collection.MutableScatterSet r10 = r10.getModified$runtime_release()     // Catch: java.lang.Throwable -> Lda
            if (r10 == 0) goto L72
            r2 = r4
            androidx.collection.ScatterSet r2 = (androidx.collection.ScatterSet) r2     // Catch: java.lang.Throwable -> Lda
            r10.addAll(r2)     // Catch: java.lang.Throwable -> Lda
            if (r10 != 0) goto L7f
        L72:
            androidx.compose.runtime.snapshots.MutableSnapshot r10 = r1.parent     // Catch: java.lang.Throwable -> Lda
            r10.setModified(r4)     // Catch: java.lang.Throwable -> Lda
            r1.setModified(r0)     // Catch: java.lang.Throwable -> Lda
            goto L7f
        L7b:
            r1 = r10
            r1.closeAndReleasePinning$runtime_release()     // Catch: java.lang.Throwable -> Lda
        L7f:
            androidx.compose.runtime.snapshots.MutableSnapshot r10 = r1.parent     // Catch: java.lang.Throwable -> Lda
            long r2 = r10.getSnapshotId()     // Catch: java.lang.Throwable -> Lda
            int r10 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r10 >= 0) goto L8e
            androidx.compose.runtime.snapshots.MutableSnapshot r10 = r1.parent     // Catch: java.lang.Throwable -> Lda
            r10.advance$runtime_release()     // Catch: java.lang.Throwable -> Lda
        L8e:
            androidx.compose.runtime.snapshots.MutableSnapshot r10 = r1.parent     // Catch: java.lang.Throwable -> Lda
            androidx.compose.runtime.snapshots.SnapshotIdSet r0 = r10.getInvalid()     // Catch: java.lang.Throwable -> Lda
            androidx.compose.runtime.snapshots.SnapshotIdSet r0 = r0.clear(r7)     // Catch: java.lang.Throwable -> Lda
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r1.getPreviousIds()     // Catch: java.lang.Throwable -> Lda
            androidx.compose.runtime.snapshots.SnapshotIdSet r0 = r0.andNot(r2)     // Catch: java.lang.Throwable -> Lda
            r10.setInvalid$runtime_release(r0)     // Catch: java.lang.Throwable -> Lda
            androidx.compose.runtime.snapshots.MutableSnapshot r10 = r1.parent     // Catch: java.lang.Throwable -> Lda
            r10.recordPrevious$runtime_release(r7)     // Catch: java.lang.Throwable -> Lda
            androidx.compose.runtime.snapshots.MutableSnapshot r10 = r1.parent     // Catch: java.lang.Throwable -> Lda
            int r0 = r1.takeoverPinnedSnapshot$runtime_release()     // Catch: java.lang.Throwable -> Lda
            r10.recordPreviousPinnedSnapshot$runtime_release(r0)     // Catch: java.lang.Throwable -> Lda
            androidx.compose.runtime.snapshots.MutableSnapshot r10 = r1.parent     // Catch: java.lang.Throwable -> Lda
            androidx.compose.runtime.snapshots.SnapshotIdSet r0 = r1.getPreviousIds()     // Catch: java.lang.Throwable -> Lda
            r10.recordPreviousList$runtime_release(r0)     // Catch: java.lang.Throwable -> Lda
            androidx.compose.runtime.snapshots.MutableSnapshot r10 = r1.parent     // Catch: java.lang.Throwable -> Lda
            int[] r0 = r1.getPreviousPinnedSnapshots()     // Catch: java.lang.Throwable -> Lda
            r10.recordPreviousPinnedSnapshots$runtime_release(r0)     // Catch: java.lang.Throwable -> Lda
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lda
            monitor-exit(r9)
            r10 = 1
            r1.setApplied$runtime_release(r10)
            r1.deactivate()
            r10 = r1
            androidx.compose.runtime.snapshots.Snapshot r10 = (androidx.compose.runtime.snapshots.Snapshot) r10
            androidx.collection.ScatterSet r4 = (androidx.collection.ScatterSet) r4
            androidx.compose.runtime.snapshots.tooling.SnapshotObserverKt.dispatchObserverOnApplied(r10, r4)
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r10 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE
            androidx.compose.runtime.snapshots.SnapshotApplyResult r10 = (androidx.compose.runtime.snapshots.SnapshotApplyResult) r10
            return r10
        Lda:
            r0 = move-exception
            r10 = r0
            monitor-exit(r9)
            throw r10
        Lde:
            r1 = r10
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Failure r10 = new androidx.compose.runtime.snapshots.SnapshotApplyResult$Failure
            r0 = r1
            androidx.compose.runtime.snapshots.Snapshot r0 = (androidx.compose.runtime.snapshots.Snapshot) r0
            r10.<init>(r0)
            androidx.compose.runtime.snapshots.SnapshotApplyResult r10 = (androidx.compose.runtime.snapshots.SnapshotApplyResult) r10
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.NestedMutableSnapshot.apply():androidx.compose.runtime.snapshots.SnapshotApplyResult");
    }

    private final void deactivate() {
        if (this.deactivated) {
            return;
        }
        this.deactivated = true;
        this.parent.mo3925nestedDeactivated$runtime_release(this);
    }
}
