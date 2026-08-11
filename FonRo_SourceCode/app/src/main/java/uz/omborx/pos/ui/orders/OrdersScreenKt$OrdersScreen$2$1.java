package uz.FonRo.pos.ui.orders;

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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.ShopReview;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OrdersScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$2$1", f = "OrdersScreen.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class OrdersScreenKt$OrdersScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $mode$delegate;
    final /* synthetic */ MutableState<List<ShopReview>> $reviews$delegate;
    final /* synthetic */ MutableState<Boolean> $reviewsLoading$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrdersScreenKt$OrdersScreen$2$1(MutableState<String> mutableState, MutableState<Boolean> mutableState2, MutableState<List<ShopReview>> mutableState3, Continuation<? super OrdersScreenKt$OrdersScreen$2$1> continuation) {
        super(2, continuation);
        this.$mode$delegate = mutableState;
        this.$reviewsLoading$delegate = mutableState2;
        this.$reviews$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OrdersScreenKt$OrdersScreen$2$1(this.$mode$delegate, this.$reviewsLoading$delegate, this.$reviews$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OrdersScreenKt$OrdersScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String OrdersScreen$lambda$4;
        Object OrdersScreen$loadReviews;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            OrdersScreen$lambda$4 = OrdersScreenKt.OrdersScreen$lambda$4(this.$mode$delegate);
            if (Intrinsics.areEqual(OrdersScreen$lambda$4, "reviews")) {
                this.label = 1;
                OrdersScreen$loadReviews = OrdersScreenKt.OrdersScreen$loadReviews(this.$reviewsLoading$delegate, this.$reviews$delegate, this);
                if (OrdersScreen$loadReviews == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
