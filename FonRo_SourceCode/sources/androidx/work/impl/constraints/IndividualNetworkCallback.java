package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: WorkConstraintsTracker.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001f\b\u0002\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016R\u001e\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/work/impl/constraints/IndividualNetworkCallback;", "Landroid/net/ConnectivityManager$NetworkCallback;", "onConstraintState", "Lkotlin/Function1;", "Landroidx/work/impl/constraints/ConstraintsState;", "", "Landroidx/work/impl/constraints/OnConstraintState;", "(Lkotlin/jvm/functions/Function1;)V", "onCapabilitiesChanged", "network", "Landroid/net/Network;", "networkCapabilities", "Landroid/net/NetworkCapabilities;", "onLost", "Companion", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
final class IndividualNetworkCallback extends ConnectivityManager.NetworkCallback {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Function1<ConstraintsState, Unit> onConstraintState;

    public /* synthetic */ IndividualNetworkCallback(Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private IndividualNetworkCallback(Function1<? super ConstraintsState, Unit> function1) {
        this.onConstraintState = function1;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        String str;
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
        Logger logger = Logger.get();
        str = WorkConstraintsTrackerKt.TAG;
        logger.debug(str, "NetworkRequestConstraintController onCapabilitiesChanged callback");
        this.onConstraintState.invoke(ConstraintsState.ConstraintsMet.INSTANCE);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        String str;
        Intrinsics.checkNotNullParameter(network, "network");
        Logger logger = Logger.get();
        str = WorkConstraintsTrackerKt.TAG;
        logger.debug(str, "NetworkRequestConstraintController onLost callback");
        this.onConstraintState.invoke(new ConstraintsState.ConstraintsNotMet(7));
    }

    /* compiled from: WorkConstraintsTracker.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u000bj\u0002`\r¨\u0006\u000e"}, d2 = {"Landroidx/work/impl/constraints/IndividualNetworkCallback$Companion;", "", "()V", "addCallback", "Lkotlin/Function0;", "", "connManager", "Landroid/net/ConnectivityManager;", "networkRequest", "Landroid/net/NetworkRequest;", "onConstraintState", "Lkotlin/Function1;", "Landroidx/work/impl/constraints/ConstraintsState;", "Landroidx/work/impl/constraints/OnConstraintState;", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function0<Unit> addCallback(final ConnectivityManager connManager, NetworkRequest networkRequest, Function1<? super ConstraintsState, Unit> onConstraintState) {
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(connManager, "connManager");
            Intrinsics.checkNotNullParameter(networkRequest, "networkRequest");
            Intrinsics.checkNotNullParameter(onConstraintState, "onConstraintState");
            final IndividualNetworkCallback individualNetworkCallback = new IndividualNetworkCallback(onConstraintState, null);
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            try {
                Logger logger = Logger.get();
                str2 = WorkConstraintsTrackerKt.TAG;
                logger.debug(str2, "NetworkRequestConstraintController register callback");
                connManager.registerNetworkCallback(networkRequest, individualNetworkCallback);
                booleanRef.element = true;
            } catch (RuntimeException e) {
                String name = e.getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name, "ex.javaClass.name");
                if (StringsKt.endsWith$default(name, "TooManyRequestsException", false, 2, (Object) null)) {
                    Logger logger2 = Logger.get();
                    str = WorkConstraintsTrackerKt.TAG;
                    logger2.debug(str, "NetworkRequestConstraintController couldn't register callback", e);
                    onConstraintState.invoke(new ConstraintsState.ConstraintsNotMet(7));
                } else {
                    throw e;
                }
            }
            return new Function0<Unit>() { // from class: androidx.work.impl.constraints.IndividualNetworkCallback$Companion$addCallback$1
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
                    String str3;
                    if (Ref.BooleanRef.this.element) {
                        Logger logger3 = Logger.get();
                        str3 = WorkConstraintsTrackerKt.TAG;
                        logger3.debug(str3, "NetworkRequestConstraintController unregister callback");
                        connManager.unregisterNetworkCallback(individualNetworkCallback);
                    }
                }
            };
        }
    }
}
