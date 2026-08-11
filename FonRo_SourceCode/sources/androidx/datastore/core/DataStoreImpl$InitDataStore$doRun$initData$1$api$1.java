package androidx.datastore.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: DataStoreImpl.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001JA\u0010\u0002\u001a\u00028\u000021\u0010\u0003\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004H\u0096@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"androidx/datastore/core/DataStoreImpl$InitDataStore$doRun$initData$1$api$1", "Landroidx/datastore/core/InitializerApi;", "updateData", "transform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "t", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class DataStoreImpl$InitDataStore$doRun$initData$1$api$1<T> implements InitializerApi<T> {
    final /* synthetic */ Ref.ObjectRef<T> $currentData;
    final /* synthetic */ Ref.BooleanRef $initializationComplete;
    final /* synthetic */ Mutex $updateLock;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataStoreImpl$InitDataStore$doRun$initData$1$api$1(Mutex mutex, Ref.BooleanRef booleanRef, Ref.ObjectRef<T> objectRef, DataStoreImpl<T> dataStoreImpl) {
        this.$updateLock = mutex;
        this.$initializationComplete = booleanRef;
        this.$currentData = objectRef;
        this.this$0 = dataStoreImpl;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0092, code lost:
    
        if (r10.lock(null, r0) == r1) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b9 A[Catch: all -> 0x0057, TRY_LEAVE, TryCatch #1 {all -> 0x0057, blocks: (B:27:0x0053, B:28:0x00b1, B:30:0x00b9), top: B:26:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0099 A[Catch: all -> 0x00e1, TRY_LEAVE, TryCatch #0 {all -> 0x00e1, blocks: (B:40:0x0095, B:42:0x0099, B:45:0x00d5, B:46:0x00e0), top: B:39:0x0095 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d5 A[Catch: all -> 0x00e1, TRY_ENTER, TryCatch #0 {all -> 0x00e1, blocks: (B:40:0x0095, B:42:0x0099, B:45:0x00d5, B:46:0x00e0), top: B:39:0x0095 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // androidx.datastore.core.InitializerApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object updateData(kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r9, kotlin.coroutines.Continuation<? super T> r10) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1$api$1.updateData(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
