package androidx.datastore.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: DataStoreImpl.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Landroidx/datastore/core/State;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$readState$2", f = "DataStoreImpl.kt", i = {}, l = {218, 226}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class DataStoreImpl$readState$2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super State<T>>, Object> {
    final /* synthetic */ boolean $requireLock;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readState$2(DataStoreImpl<T> dataStoreImpl, boolean z, Continuation<? super DataStoreImpl$readState$2> continuation) {
        super(2, continuation);
        this.this$0 = dataStoreImpl;
        this.$requireLock = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DataStoreImpl$readState$2(this.this$0, this.$requireLock, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super State<T>> continuation) {
        return ((DataStoreImpl$readState$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0053, code lost:
    
        if (r5 == r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0043, code lost:
    
        if (r5 == r0) goto L20;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r5)
            goto L56
        L12:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L1a:
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L59
            goto L46
        L1e:
            kotlin.ResultKt.throwOnFailure(r5)
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
            androidx.datastore.core.DataStoreInMemoryCache r5 = androidx.datastore.core.DataStoreImpl.access$getInMemoryCache$p(r5)
            androidx.datastore.core.State r5 = r5.getCurrentState()
            boolean r5 = r5 instanceof androidx.datastore.core.Final
            androidx.datastore.core.DataStoreImpl<T> r1 = r4.this$0
            if (r5 == 0) goto L3a
            androidx.datastore.core.DataStoreInMemoryCache r4 = androidx.datastore.core.DataStoreImpl.access$getInMemoryCache$p(r1)
            androidx.datastore.core.State r4 = r4.getCurrentState()
            return r4
        L3a:
            r5 = r4
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Throwable -> L59
            r4.label = r3     // Catch: java.lang.Throwable -> L59
            java.lang.Object r5 = androidx.datastore.core.DataStoreImpl.access$readAndInitOrPropagateAndThrowFailure(r1, r5)     // Catch: java.lang.Throwable -> L59
            if (r5 != r0) goto L46
            goto L55
        L46:
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
            boolean r1 = r4.$requireLock
            r3 = r4
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4.label = r2
            java.lang.Object r5 = androidx.datastore.core.DataStoreImpl.access$readDataAndUpdateCache(r5, r1, r3)
            if (r5 != r0) goto L56
        L55:
            return r0
        L56:
            androidx.datastore.core.State r5 = (androidx.datastore.core.State) r5
            return r5
        L59:
            r4 = move-exception
            androidx.datastore.core.ReadException r5 = new androidx.datastore.core.ReadException
            r0 = -1
            r5.<init>(r4, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$readState$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
