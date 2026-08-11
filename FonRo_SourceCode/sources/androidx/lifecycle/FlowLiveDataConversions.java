package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomTrackingLiveData;
import j$.time.Duration;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: FlowLiveData.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\u001a9\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\t\u0010\n\u001a7\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\r¨\u0006\u000e"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "timeoutInMs", "Landroidx/lifecycle/LiveData;", "asLiveData", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;J)Landroidx/lifecycle/LiveData;", "asFlow", "(Landroidx/lifecycle/LiveData;)Lkotlinx/coroutines/flow/Flow;", "j$/time/Duration", "timeout", "(Lkotlinx/coroutines/flow/Flow;Lj$/time/Duration;Lkotlin/coroutines/CoroutineContext;)Landroidx/lifecycle/LiveData;", "lifecycle-livedata_release"}, k = 2, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class FlowLiveDataConversions {
    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        return asLiveData$default(flow, (CoroutineContext) null, 0L, 3, (Object) null);
    }

    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow, CoroutineContext context) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return asLiveData$default(flow, context, 0L, 2, (Object) null);
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow flow, CoroutineContext coroutineContext, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            j = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        }
        return asLiveData(flow, coroutineContext, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow, CoroutineContext context, long j) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        RoomTrackingLiveData roomTrackingLiveData = (LiveData<T>) CoroutineLiveDataKt.liveData(context, j, new FlowLiveDataConversions$asLiveData$1(flow, null));
        if (flow instanceof StateFlow) {
            if (ArchTaskExecutor.getInstance().isMainThread()) {
                roomTrackingLiveData.setValue(((StateFlow) flow).getValue());
                return roomTrackingLiveData;
            }
            roomTrackingLiveData.postValue(((StateFlow) flow).getValue());
        }
        return roomTrackingLiveData;
    }

    public static final <T> Flow<T> asFlow(LiveData<T> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        return FlowKt.conflate(FlowKt.callbackFlow(new FlowLiveDataConversions$asFlow$1(liveData, null)));
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow flow, Duration duration, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asLiveData(flow, duration, coroutineContext);
    }

    public static final <T> LiveData<T> asLiveData(Flow<? extends T> flow, Duration timeout, CoroutineContext context) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        Intrinsics.checkNotNullParameter(context, "context");
        return asLiveData(flow, context, Api26Impl.INSTANCE.toMillis(timeout));
    }
}
