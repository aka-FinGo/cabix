package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.Constraints;
import androidx.work.impl.constraints.IndividualNetworkCallback;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: WorkConstraintsTracker.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroidx/work/impl/constraints/ConstraintsState;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.work.impl.constraints.NetworkRequestConstraintController$track$1", f = "WorkConstraintsTracker.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class NetworkRequestConstraintController$track$1 extends SuspendLambda implements Function2<ProducerScope<? super ConstraintsState>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Constraints $constraints;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NetworkRequestConstraintController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkRequestConstraintController$track$1(Constraints constraints, NetworkRequestConstraintController networkRequestConstraintController, Continuation<? super NetworkRequestConstraintController$track$1> continuation) {
        super(2, continuation);
        this.$constraints = constraints;
        this.this$0 = networkRequestConstraintController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NetworkRequestConstraintController$track$1 networkRequestConstraintController$track$1 = new NetworkRequestConstraintController$track$1(this.$constraints, this.this$0, continuation);
        networkRequestConstraintController$track$1.L$0 = obj;
        return networkRequestConstraintController$track$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super ConstraintsState> producerScope, Continuation<? super Unit> continuation) {
        return ((NetworkRequestConstraintController$track$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final Job launch$default;
        ConnectivityManager connectivityManager;
        final Function0<Unit> addCallback;
        ConnectivityManager connectivityManager2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            NetworkRequest requiredNetworkRequest = this.$constraints.getRequiredNetworkRequest();
            if (requiredNetworkRequest != null) {
                launch$default = BuildersKt__Builders_commonKt.launch$default(producerScope, null, null, new NetworkRequestConstraintController$track$1$timeoutJob$1(this.this$0, producerScope, null), 3, null);
                Function1<ConstraintsState, Unit> function1 = new Function1<ConstraintsState, Unit>() { // from class: androidx.work.impl.constraints.NetworkRequestConstraintController$track$1$onConstraintState$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ConstraintsState constraintsState) {
                        invoke2(constraintsState);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ConstraintsState it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        Job.DefaultImpls.cancel$default(Job.this, (CancellationException) null, 1, (Object) null);
                        producerScope.mo9440trySendJP2dKIU(it);
                    }
                };
                if (Build.VERSION.SDK_INT >= 30) {
                    SharedNetworkCallback sharedNetworkCallback = SharedNetworkCallback.INSTANCE;
                    connectivityManager2 = this.this$0.connManager;
                    addCallback = sharedNetworkCallback.addCallback(connectivityManager2, requiredNetworkRequest, function1);
                } else {
                    IndividualNetworkCallback.Companion companion = IndividualNetworkCallback.INSTANCE;
                    connectivityManager = this.this$0.connManager;
                    addCallback = companion.addCallback(connectivityManager, requiredNetworkRequest, function1);
                }
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, new Function0<Unit>() { // from class: androidx.work.impl.constraints.NetworkRequestConstraintController$track$1.1
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
                        addCallback.invoke();
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                SendChannel.DefaultImpls.close$default(producerScope.getChannel(), null, 1, null);
                return Unit.INSTANCE;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
