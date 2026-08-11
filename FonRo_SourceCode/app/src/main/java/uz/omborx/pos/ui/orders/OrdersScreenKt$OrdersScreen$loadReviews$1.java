package uz.FonRo.pos.ui.orders;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OrdersScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.orders.OrdersScreenKt", f = "OrdersScreen.kt", i = {0, 0}, l = {147}, m = "OrdersScreen$loadReviews", n = {"reviewsLoading$delegate", "reviews$delegate"}, nl = {147}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes7.dex */
public final class OrdersScreenKt$OrdersScreen$loadReviews$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OrdersScreenKt$OrdersScreen$loadReviews$1(Continuation<? super OrdersScreenKt$OrdersScreen$loadReviews$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object OrdersScreen$loadReviews;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        OrdersScreen$loadReviews = OrdersScreenKt.OrdersScreen$loadReviews(null, null, this);
        return OrdersScreen$loadReviews;
    }
}
