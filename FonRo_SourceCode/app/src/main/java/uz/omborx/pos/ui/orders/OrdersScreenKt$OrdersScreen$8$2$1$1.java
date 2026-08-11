package uz.FonRo.pos.ui.orders;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.ShopOrder;
import uz.FonRo.pos.data.model.ShopStoreInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OrdersScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$8$2$1$1", f = "OrdersScreen.kt", i = {1, 2}, l = {478, 500, TypedValues.PositionType.TYPE_PERCENT_HEIGHT}, m = "invokeSuspend", n = {"newSlug", "newSlug"}, nl = {477, TypedValues.PositionType.TYPE_DRAWPATH, TypedValues.PositionType.TYPE_SIZE_PERCENT}, s = {"L$0", "L$0"}, v = 2)
/* loaded from: classes7.dex */
public final class OrdersScreenKt$OrdersScreen$8$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<List<ShopOrder>> $allOrders$delegate;
    final /* synthetic */ ShopStoreInfo $current;
    final /* synthetic */ MutableState<Boolean> $failed$delegate;
    final /* synthetic */ MutableState<ShopStoreInfo> $info$delegate;
    final /* synthetic */ MutableState<Boolean> $loading$delegate;
    final /* synthetic */ MutableState<Boolean> $showSettings$delegate;
    final /* synthetic */ ShopStoreInfo $updated;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrdersScreenKt$OrdersScreen$8$2$1$1(ShopStoreInfo shopStoreInfo, ShopStoreInfo shopStoreInfo2, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, MutableState<ShopStoreInfo> mutableState3, MutableState<List<ShopOrder>> mutableState4, MutableState<Boolean> mutableState5, Continuation<? super OrdersScreenKt$OrdersScreen$8$2$1$1> continuation) {
        super(2, continuation);
        this.$updated = shopStoreInfo;
        this.$current = shopStoreInfo2;
        this.$showSettings$delegate = mutableState;
        this.$loading$delegate = mutableState2;
        this.$info$delegate = mutableState3;
        this.$allOrders$delegate = mutableState4;
        this.$failed$delegate = mutableState5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OrdersScreenKt$OrdersScreen$8$2$1$1(this.$updated, this.$current, this.$showSettings$delegate, this.$loading$delegate, this.$info$delegate, this.$allOrders$delegate, this.$failed$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OrdersScreenKt$OrdersScreen$8$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x016b, code lost:
    
        if (r0 != r1) goto L54;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$8$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
