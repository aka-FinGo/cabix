package androidx.datastore.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: DataStoreImpl.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u0005H¤@¢\u0006\u0002\u0010\tJ\u000e\u0010\u000b\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/datastore/core/RunOnce;", "", "()V", "didRun", "Lkotlinx/coroutines/CompletableDeferred;", "", "runMutex", "Lkotlinx/coroutines/sync/Mutex;", "awaitComplete", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doRun", "runIfNeeded", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public abstract class RunOnce {
    private final Mutex runMutex = MutexKt.Mutex$default(false, 1, null);
    private final CompletableDeferred<Unit> didRun = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);

    protected abstract Object doRun(Continuation<? super Unit> continuation);

    public final Object awaitComplete(Continuation<? super Unit> continuation) {
        Object await = this.didRun.await(continuation);
        return await == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? await : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0068, code lost:
    
        if (r8.lock(null, r0) == r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073 A[Catch: all -> 0x0095, TRY_LEAVE, TryCatch #0 {all -> 0x0095, blocks: (B:25:0x006b, B:27:0x0073, B:30:0x0079), top: B:24:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0079 A[Catch: all -> 0x0095, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0095, blocks: (B:25:0x006b, B:27:0x0073, B:30:0x0079), top: B:24:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runIfNeeded(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.datastore.core.RunOnce$runIfNeeded$1
            if (r0 == 0) goto L14
            r0 = r8
            androidx.datastore.core.RunOnce$runIfNeeded$1 r0 = (androidx.datastore.core.RunOnce$runIfNeeded$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.datastore.core.RunOnce$runIfNeeded$1 r0 = new androidx.datastore.core.RunOnce$runIfNeeded$1
            r0.<init>(r7, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4e
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.RunOnce r0 = (androidx.datastore.core.RunOnce) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L36
            goto L88
        L36:
            r8 = move-exception
            goto L99
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L40:
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.RunOnce r2 = (androidx.datastore.core.RunOnce) r2
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r7
            r7 = r2
            goto L6b
        L4e:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.CompletableDeferred<kotlin.Unit> r8 = r7.didRun
            boolean r8 = r8.isCompleted()
            if (r8 == 0) goto L5c
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L5c:
            kotlinx.coroutines.sync.Mutex r8 = r7.runMutex
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r2 = r8.lock(r5, r0)
            if (r2 != r1) goto L6b
            goto L85
        L6b:
            kotlinx.coroutines.CompletableDeferred<kotlin.Unit> r2 = r7.didRun     // Catch: java.lang.Throwable -> L95
            boolean r2 = r2.isCompleted()     // Catch: java.lang.Throwable -> L95
            if (r2 == 0) goto L79
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L95
            r8.unlock(r5)
            return r7
        L79:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L95
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L95
            r0.label = r3     // Catch: java.lang.Throwable -> L95
            java.lang.Object r0 = r7.doRun(r0)     // Catch: java.lang.Throwable -> L95
            if (r0 != r1) goto L86
        L85:
            return r1
        L86:
            r0 = r7
            r7 = r8
        L88:
            kotlinx.coroutines.CompletableDeferred<kotlin.Unit> r8 = r0.didRun     // Catch: java.lang.Throwable -> L36
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L36
            r8.complete(r0)     // Catch: java.lang.Throwable -> L36
            r7.unlock(r5)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L95:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L99:
            r7.unlock(r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.RunOnce.runIfNeeded(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
