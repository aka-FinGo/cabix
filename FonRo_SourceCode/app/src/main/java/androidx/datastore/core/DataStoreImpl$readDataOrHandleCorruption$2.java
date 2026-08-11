package androidx.datastore.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: DataStoreImpl.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Landroidx/datastore/core/Data;", ExifInterface.GPS_DIRECTION_TRUE, "locked", ""}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2", f = "DataStoreImpl.kt", i = {0, 1}, l = {370, 371}, m = "invokeSuspend", n = {"locked", "data"}, s = {"Z$0", "L$0"})
/* loaded from: classes4.dex */
public final class DataStoreImpl$readDataOrHandleCorruption$2<T> extends SuspendLambda implements Function2<Boolean, Continuation<? super Data<T>>, Object> {
    final /* synthetic */ int $preLockVersion;
    Object L$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readDataOrHandleCorruption$2(DataStoreImpl<T> dataStoreImpl, int i, Continuation<? super DataStoreImpl$readDataOrHandleCorruption$2> continuation) {
        super(2, continuation);
        this.this$0 = dataStoreImpl;
        this.$preLockVersion = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DataStoreImpl$readDataOrHandleCorruption$2 dataStoreImpl$readDataOrHandleCorruption$2 = new DataStoreImpl$readDataOrHandleCorruption$2(this.this$0, this.$preLockVersion, continuation);
        dataStoreImpl$readDataOrHandleCorruption$2.Z$0 = ((Boolean) obj).booleanValue();
        return dataStoreImpl$readDataOrHandleCorruption$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Object obj) {
        return invoke(bool.booleanValue(), (Continuation) obj);
    }

    public final Object invoke(boolean z, Continuation<? super Data<T>> continuation) {
        return ((DataStoreImpl$readDataOrHandleCorruption$2) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
    
        if (r7 == r0) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1c
            if (r1 != r2) goto L14
            java.lang.Object r6 = r6.L$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L50
        L14:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1c:
            boolean r1 = r6.Z$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L37
        L22:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r1 = r6.Z$0
            androidx.datastore.core.DataStoreImpl<T> r7 = r6.this$0
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6.Z$0 = r1
            r6.label = r3
            java.lang.Object r7 = androidx.datastore.core.DataStoreImpl.access$readDataFromFileOrDefault(r7, r4)
            if (r7 != r0) goto L37
            goto L4c
        L37:
            if (r1 == 0) goto L57
            androidx.datastore.core.DataStoreImpl<T> r1 = r6.this$0
            androidx.datastore.core.InterProcessCoordinator r1 = androidx.datastore.core.DataStoreImpl.access$getCoordinator(r1)
            r3 = r6
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r6.L$0 = r7
            r6.label = r2
            java.lang.Object r6 = r1.getVersion(r3)
            if (r6 != r0) goto L4d
        L4c:
            return r0
        L4d:
            r5 = r7
            r7 = r6
            r6 = r5
        L50:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            goto L5c
        L57:
            int r6 = r6.$preLockVersion
            r5 = r7
            r7 = r6
            r6 = r5
        L5c:
            androidx.datastore.core.Data r0 = new androidx.datastore.core.Data
            if (r6 == 0) goto L65
            int r1 = r6.hashCode()
            goto L66
        L65:
            r1 = 0
        L66:
            r0.<init>(r6, r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
