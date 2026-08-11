package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkConstraintsTracker.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\tJ\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R,\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t0\u00048\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/work/impl/constraints/SharedNetworkCallback;", "Landroid/net/ConnectivityManager$NetworkCallback;", "()V", "requests", "", "Landroid/net/NetworkRequest;", "Lkotlin/Function1;", "Landroidx/work/impl/constraints/ConstraintsState;", "", "Landroidx/work/impl/constraints/OnConstraintState;", "requestsLock", "", "addCallback", "Lkotlin/Function0;", "connManager", "Landroid/net/ConnectivityManager;", "networkRequest", "onConstraintState", "onCapabilitiesChanged", "network", "Landroid/net/Network;", "networkCapabilities", "Landroid/net/NetworkCapabilities;", "onLost", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
final class SharedNetworkCallback extends ConnectivityManager.NetworkCallback {
    public static final SharedNetworkCallback INSTANCE = new SharedNetworkCallback();
    private static final Object requestsLock = new Object();
    private static final Map<NetworkRequest, Function1<ConstraintsState, Unit>> requests = new LinkedHashMap();

    private SharedNetworkCallback() {
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        String str;
        List<Map.Entry> list;
        boolean canBeSatisfiedBy;
        ConstraintsState constraintsNotMet;
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
        Logger logger = Logger.get();
        str = WorkConstraintsTrackerKt.TAG;
        logger.debug(str, "NetworkRequestConstraintController onCapabilitiesChanged callback");
        synchronized (requestsLock) {
            list = CollectionsKt.toList(requests.entrySet());
        }
        for (Map.Entry entry : list) {
            NetworkRequest networkRequest = (NetworkRequest) entry.getKey();
            Function1 function1 = (Function1) entry.getValue();
            canBeSatisfiedBy = networkRequest.canBeSatisfiedBy(networkCapabilities);
            if (canBeSatisfiedBy) {
                constraintsNotMet = ConstraintsState.ConstraintsMet.INSTANCE;
            } else {
                constraintsNotMet = new ConstraintsState.ConstraintsNotMet(7);
            }
            function1.invoke(constraintsNotMet);
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        String str;
        List list;
        Intrinsics.checkNotNullParameter(network, "network");
        Logger logger = Logger.get();
        str = WorkConstraintsTrackerKt.TAG;
        logger.debug(str, "NetworkRequestConstraintController onLost callback");
        synchronized (requestsLock) {
            list = CollectionsKt.toList(requests.values());
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(new ConstraintsState.ConstraintsNotMet(7));
        }
    }

    public final Function0<Unit> addCallback(final ConnectivityManager connManager, final NetworkRequest networkRequest, Function1<? super ConstraintsState, Unit> onConstraintState) {
        String str;
        Intrinsics.checkNotNullParameter(connManager, "connManager");
        Intrinsics.checkNotNullParameter(networkRequest, "networkRequest");
        Intrinsics.checkNotNullParameter(onConstraintState, "onConstraintState");
        synchronized (requestsLock) {
            Map<NetworkRequest, Function1<ConstraintsState, Unit>> map = requests;
            boolean isEmpty = map.isEmpty();
            map.put(networkRequest, onConstraintState);
            if (isEmpty) {
                Logger logger = Logger.get();
                str = WorkConstraintsTrackerKt.TAG;
                logger.debug(str, "NetworkRequestConstraintController register shared callback");
                connManager.registerDefaultNetworkCallback(this);
            }
            Unit unit = Unit.INSTANCE;
        }
        return new Function0<Unit>() { // from class: androidx.work.impl.constraints.SharedNetworkCallback$addCallback$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Object obj;
                Map map2;
                Map map3;
                String str2;
                obj = SharedNetworkCallback.requestsLock;
                NetworkRequest networkRequest2 = networkRequest;
                ConnectivityManager connectivityManager = connManager;
                SharedNetworkCallback sharedNetworkCallback = this;
                synchronized (obj) {
                    map2 = SharedNetworkCallback.requests;
                    map2.remove(networkRequest2);
                    map3 = SharedNetworkCallback.requests;
                    if (map3.isEmpty()) {
                        Logger logger2 = Logger.get();
                        str2 = WorkConstraintsTrackerKt.TAG;
                        logger2.debug(str2, "NetworkRequestConstraintController unregister shared callback");
                        connectivityManager.unregisterNetworkCallback(sharedNetworkCallback);
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        };
    }
}
