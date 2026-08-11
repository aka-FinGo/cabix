package androidx.datastore.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: DataStoreImpl.kt */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\u008a@"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$transformAndWrite$2", f = "DataStoreImpl.kt", i = {1, 2}, l = {330, 331, 337}, m = "invokeSuspend", n = {"curData", "newData"}, s = {"L$0", "L$0"})
/* loaded from: classes4.dex */
public final class DataStoreImpl$transformAndWrite$2<T> extends SuspendLambda implements Function1<Continuation<? super T>, Object> {
    final /* synthetic */ CoroutineContext $callerContext;
    final /* synthetic */ Function2<T, Continuation<? super T>, Object> $transform;
    Object L$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DataStoreImpl$transformAndWrite$2(DataStoreImpl<T> dataStoreImpl, CoroutineContext coroutineContext, Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super DataStoreImpl$transformAndWrite$2> continuation) {
        super(1, continuation);
        this.this$0 = dataStoreImpl;
        this.$callerContext = coroutineContext;
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new DataStoreImpl$transformAndWrite$2(this.this$0, this.$callerContext, this.$transform, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super T> continuation) {
        return ((DataStoreImpl$transformAndWrite$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0056, code lost:
    
        if (r9 == r0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        if (r9 == r0) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2b
            if (r1 == r4) goto L27
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r8 = r8.L$0
            kotlin.ResultKt.throwOnFailure(r9)
            return r8
        L17:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L1f:
            java.lang.Object r1 = r8.L$0
            androidx.datastore.core.Data r1 = (androidx.datastore.core.Data) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L59
        L27:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L3c
        L2b:
            kotlin.ResultKt.throwOnFailure(r9)
            androidx.datastore.core.DataStoreImpl<T> r9 = r8.this$0
            r1 = r8
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r8.label = r4
            java.lang.Object r9 = androidx.datastore.core.DataStoreImpl.access$readDataOrHandleCorruption(r9, r4, r1)
            if (r9 != r0) goto L3c
            goto L75
        L3c:
            r1 = r9
            androidx.datastore.core.Data r1 = (androidx.datastore.core.Data) r1
            kotlin.coroutines.CoroutineContext r9 = r8.$callerContext
            androidx.datastore.core.DataStoreImpl$transformAndWrite$2$newData$1 r5 = new androidx.datastore.core.DataStoreImpl$transformAndWrite$2$newData$1
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super T>, java.lang.Object> r6 = r8.$transform
            r7 = 0
            r5.<init>(r6, r1, r7)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6 = r8
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r8.L$0 = r1
            r8.label = r3
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r9, r5, r6)
            if (r9 != r0) goto L59
            goto L75
        L59:
            r1.checkHashCode()
            java.lang.Object r1 = r1.getValue()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r9)
            if (r1 != 0) goto L76
            androidx.datastore.core.DataStoreImpl<T> r1 = r8.this$0
            r3 = r8
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r8.L$0 = r9
            r8.label = r2
            java.lang.Object r8 = r1.writeData$datastore_core_release(r9, r4, r3)
            if (r8 != r0) goto L76
        L75:
            return r0
        L76:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$transformAndWrite$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
