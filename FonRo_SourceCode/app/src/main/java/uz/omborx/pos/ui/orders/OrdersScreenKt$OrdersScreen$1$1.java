package uz.FonRo.pos.ui.orders;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.ShopOrder;
import uz.FonRo.pos.data.model.ShopStoreInfo;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.work.Notifier;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OrdersScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$1$1", f = "OrdersScreen.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, nl = {158}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class OrdersScreenKt$OrdersScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<List<ShopOrder>> $allOrders$delegate;
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<Boolean> $failed$delegate;
    final /* synthetic */ MutableState<ShopStoreInfo> $info$delegate;
    final /* synthetic */ MutableState<Boolean> $loading$delegate;
    final /* synthetic */ Repo $repo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrdersScreenKt$OrdersScreen$1$1(Repo repo, Context context, MutableState<Boolean> mutableState, MutableState<ShopStoreInfo> mutableState2, MutableState<List<ShopOrder>> mutableState3, MutableState<Boolean> mutableState4, Continuation<? super OrdersScreenKt$OrdersScreen$1$1> continuation) {
        super(2, continuation);
        this.$repo = repo;
        this.$context = context;
        this.$loading$delegate = mutableState;
        this.$info$delegate = mutableState2;
        this.$allOrders$delegate = mutableState3;
        this.$failed$delegate = mutableState4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OrdersScreenKt$OrdersScreen$1$1(this.$repo, this.$context, this.$loading$delegate, this.$info$delegate, this.$allOrders$delegate, this.$failed$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OrdersScreenKt$OrdersScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object OrdersScreen$load;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.$repo.setOrdersNew(0);
            Notifier.INSTANCE.cancel(this.$context, Notifier.ID_ORDERS);
            this.label = 1;
            OrdersScreen$load = OrdersScreenKt.OrdersScreen$load(this.$loading$delegate, this.$info$delegate, this.$allOrders$delegate, this.$failed$delegate, this);
            if (OrdersScreen$load == coroutine_suspended) {
                return coroutine_suspended;
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
