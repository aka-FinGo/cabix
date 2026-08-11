package androidx.datastore.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: DataStoreInMemoryCache.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006R \u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Landroidx/datastore/core/DataStoreInMemoryCache;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "cachedValue", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/datastore/core/State;", "getCachedValue$annotations", "currentState", "getCurrentState", "()Landroidx/datastore/core/State;", "flow", "Lkotlinx/coroutines/flow/Flow;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "tryUpdate", "newState", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class DataStoreInMemoryCache<T> {
    private final MutableStateFlow<State<T>> cachedValue;

    private static /* synthetic */ void getCachedValue$annotations() {
    }

    public DataStoreInMemoryCache() {
        UnInitialized unInitialized = UnInitialized.INSTANCE;
        Intrinsics.checkNotNull(unInitialized, "null cannot be cast to non-null type androidx.datastore.core.State<T of androidx.datastore.core.DataStoreInMemoryCache>");
        this.cachedValue = StateFlowKt.MutableStateFlow(unInitialized);
    }

    public final State<T> getCurrentState() {
        return this.cachedValue.getValue();
    }

    public final Flow<State<T>> getFlow() {
        return this.cachedValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
    
        if (r5.getVersion() > r1.getVersion()) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.datastore.core.State<T> tryUpdate(androidx.datastore.core.State<T> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "newState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r4 = r4.cachedValue
        L7:
            java.lang.Object r0 = r4.getValue()
            r1 = r0
            androidx.datastore.core.State r1 = (androidx.datastore.core.State) r1
            boolean r2 = r1 instanceof androidx.datastore.core.ReadException
            if (r2 == 0) goto L14
            r2 = 1
            goto L1a
        L14:
            androidx.datastore.core.UnInitialized r2 = androidx.datastore.core.UnInitialized.INSTANCE
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
        L1a:
            if (r2 == 0) goto L1d
            goto L2b
        L1d:
            boolean r2 = r1 instanceof androidx.datastore.core.Data
            if (r2 == 0) goto L2d
            int r2 = r5.getVersion()
            int r3 = r1.getVersion()
            if (r2 <= r3) goto L31
        L2b:
            r1 = r5
            goto L31
        L2d:
            boolean r2 = r1 instanceof androidx.datastore.core.Final
            if (r2 == 0) goto L38
        L31:
            boolean r0 = r4.compareAndSet(r0, r1)
            if (r0 == 0) goto L7
            return r1
        L38:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreInMemoryCache.tryUpdate(androidx.datastore.core.State):androidx.datastore.core.State");
    }
}
