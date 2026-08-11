package uz.FonRo.pos.ui.orders;

import androidx.compose.runtime.MutableState;
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
@DebugMetadata(c = "uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$finishOrder$1", f = "OrdersScreen.kt", i = {}, l = {226, 232}, m = "invokeSuspend", n = {}, nl = {225, 233}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class OrdersScreenKt$OrdersScreen$finishOrder$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<List<ShopOrder>> $allOrders$delegate;
    final /* synthetic */ MutableState<Boolean> $failed$delegate;
    final /* synthetic */ MutableState<ShopStoreInfo> $info$delegate;
    final /* synthetic */ MutableState<Boolean> $loading$delegate;
    final /* synthetic */ MutableState<Long> $openId$delegate;
    final /* synthetic */ ShopOrder $order;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrdersScreenKt$OrdersScreen$finishOrder$1(ShopOrder shopOrder, MutableState<Long> mutableState, MutableState<Boolean> mutableState2, MutableState<ShopStoreInfo> mutableState3, MutableState<List<ShopOrder>> mutableState4, MutableState<Boolean> mutableState5, Continuation<? super OrdersScreenKt$OrdersScreen$finishOrder$1> continuation) {
        super(2, continuation);
        this.$order = shopOrder;
        this.$openId$delegate = mutableState;
        this.$loading$delegate = mutableState2;
        this.$info$delegate = mutableState3;
        this.$allOrders$delegate = mutableState4;
        this.$failed$delegate = mutableState5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OrdersScreenKt$OrdersScreen$finishOrder$1(this.$order, this.$openId$delegate, this.$loading$delegate, this.$info$delegate, this.$allOrders$delegate, this.$failed$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OrdersScreenKt$OrdersScreen$finishOrder$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0086, code lost:
    
        if (r12 == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L23
            if (r1 == r2) goto L1b
            if (r1 != r3) goto L13
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Throwable -> L89
            goto L90
        L13:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L1b:
            java.lang.Object r1 = r12.L$0
            uz.FonRo.pos.data.net.ApiClient r1 = (uz.FonRo.pos.data.net.ApiClient) r1
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Throwable -> L89
            goto L52
        L23:
            kotlin.ResultKt.throwOnFailure(r13)
            uz.FonRo.pos.data.net.ApiClient r1 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> L89
            uz.FonRo.pos.data.net.ApiClient r13 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> L89
            uz.FonRo.pos.data.net.ApiService r13 = r13.api()     // Catch: java.lang.Throwable -> L89
            uz.FonRo.pos.data.model.OrderIdBody r4 = new uz.FonRo.pos.data.model.OrderIdBody     // Catch: java.lang.Throwable -> L89
            uz.FonRo.pos.data.model.ShopOrder r5 = r12.$order     // Catch: java.lang.Throwable -> L89
            long r5 = r5.getId()     // Catch: java.lang.Throwable -> L89
            r7 = 0
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7)     // Catch: java.lang.Throwable -> L89
            java.lang.String r9 = ""
            r10 = 2
            r11 = 0
            r7 = 0
            r4.<init>(r5, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L89
            r5 = r12
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Throwable -> L89
            r12.L$0 = r1     // Catch: java.lang.Throwable -> L89
            r12.label = r2     // Catch: java.lang.Throwable -> L89
            java.lang.Object r13 = r13.shopOrderDone(r4, r5)     // Catch: java.lang.Throwable -> L89
            if (r13 != r0) goto L52
            goto L88
        L52:
            retrofit2.Response r13 = (retrofit2.Response) r13     // Catch: java.lang.Throwable -> L89
            r2 = 0
            r4 = 0
            uz.FonRo.pos.data.net.ApiClient.unwrapVoid$default(r1, r13, r2, r3, r4)     // Catch: java.lang.Throwable -> L89
            uz.FonRo.pos.ui.Toaster r13 = uz.FonRo.pos.ui.Toaster.INSTANCE     // Catch: java.lang.Throwable -> L89
            java.lang.String r1 = "Заказ %s выполнен"
            uz.FonRo.pos.data.model.ShopOrder r2 = r12.$order     // Catch: java.lang.Throwable -> L89
            java.lang.String r2 = r2.getOrderNumber()     // Catch: java.lang.Throwable -> L89
            java.lang.Object[] r2 = new java.lang.Object[]{r2}     // Catch: java.lang.Throwable -> L89
            java.lang.String r1 = uz.FonRo.pos.core.LangKt.tx(r1, r2)     // Catch: java.lang.Throwable -> L89
            r13.ok(r1)     // Catch: java.lang.Throwable -> L89
            androidx.compose.runtime.MutableState<java.lang.Long> r13 = r12.$openId$delegate     // Catch: java.lang.Throwable -> L89
            uz.FonRo.pos.ui.orders.OrdersScreenKt.access$OrdersScreen$lambda$30(r13, r4)     // Catch: java.lang.Throwable -> L89
            androidx.compose.runtime.MutableState<java.lang.Boolean> r13 = r12.$loading$delegate     // Catch: java.lang.Throwable -> L89
            androidx.compose.runtime.MutableState<uz.FonRo.pos.data.model.ShopStoreInfo> r1 = r12.$info$delegate     // Catch: java.lang.Throwable -> L89
            androidx.compose.runtime.MutableState<java.util.List<uz.FonRo.pos.data.model.ShopOrder>> r2 = r12.$allOrders$delegate     // Catch: java.lang.Throwable -> L89
            androidx.compose.runtime.MutableState<java.lang.Boolean> r5 = r12.$failed$delegate     // Catch: java.lang.Throwable -> L89
            r6 = r12
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.lang.Throwable -> L89
            r12.L$0 = r4     // Catch: java.lang.Throwable -> L89
            r12.label = r3     // Catch: java.lang.Throwable -> L89
            java.lang.Object r12 = uz.FonRo.pos.ui.orders.OrdersScreenKt.access$OrdersScreen$load(r13, r1, r2, r5, r6)     // Catch: java.lang.Throwable -> L89
            if (r12 != r0) goto L90
        L88:
            return r0
        L89:
            r0 = move-exception
            r12 = r0
            uz.FonRo.pos.ui.Toaster r13 = uz.FonRo.pos.ui.Toaster.INSTANCE
            r13.error(r12)
        L90:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$finishOrder$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
