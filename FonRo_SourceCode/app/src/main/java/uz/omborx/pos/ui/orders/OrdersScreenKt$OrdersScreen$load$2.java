package uz.FonRo.pos.ui.orders;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
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
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Luz/FonRo/pos/data/model/ShopOrder;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$load$2", f = "OrdersScreen.kt", i = {0, 0, 0, 1, 1, 1}, l = {135, 138}, m = "invokeSuspend", n = {"$this$coroutineScope", "infoJob", "ordersJob", "$this$coroutineScope", "infoJob", "ordersJob"}, nl = {136, 139}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 2)
/* loaded from: classes7.dex */
public final class OrdersScreenKt$OrdersScreen$load$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends ShopOrder>>>, Object> {
    final /* synthetic */ MutableState<List<ShopOrder>> $allOrders$delegate;
    final /* synthetic */ MutableState<Boolean> $failed$delegate;
    final /* synthetic */ MutableState<ShopStoreInfo> $info$delegate;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrdersScreenKt$OrdersScreen$load$2(MutableState<ShopStoreInfo> mutableState, MutableState<List<ShopOrder>> mutableState2, MutableState<Boolean> mutableState3, Continuation<? super OrdersScreenKt$OrdersScreen$load$2> continuation) {
        super(2, continuation);
        this.$info$delegate = mutableState;
        this.$allOrders$delegate = mutableState2;
        this.$failed$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OrdersScreenKt$OrdersScreen$load$2 ordersScreenKt$OrdersScreen$load$2 = new OrdersScreenKt$OrdersScreen$load$2(this.$info$delegate, this.$allOrders$delegate, this.$failed$delegate, continuation);
        ordersScreenKt$OrdersScreen$load$2.L$0 = obj;
        return ordersScreenKt$OrdersScreen$load$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends List<? extends ShopOrder>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<? extends List<ShopOrder>>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<? extends List<ShopOrder>>> continuation) {
        return ((OrdersScreenKt$OrdersScreen$load$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ac, code lost:
    
        if (r12 == r0) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = r11.L$0
            r1 = r0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r11.label
            r7 = 2
            r8 = 1
            if (r2 == 0) goto L34
            if (r2 == r8) goto L28
            if (r2 != r7) goto L20
            java.lang.Object r0 = r11.L$2
            kotlinx.coroutines.Deferred r0 = (kotlinx.coroutines.Deferred) r0
            java.lang.Object r0 = r11.L$1
            kotlinx.coroutines.Deferred r0 = (kotlinx.coroutines.Deferred) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto Laf
        L20:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L28:
            java.lang.Object r2 = r11.L$2
            kotlinx.coroutines.Deferred r2 = (kotlinx.coroutines.Deferred) r2
            java.lang.Object r3 = r11.L$1
            kotlinx.coroutines.Deferred r3 = (kotlinx.coroutines.Deferred) r3
            kotlin.ResultKt.throwOnFailure(r12)
            goto L72
        L34:
            kotlin.ResultKt.throwOnFailure(r12)
            uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$load$2$infoJob$1 r12 = new uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$load$2$infoJob$1
            r9 = 0
            r12.<init>(r9)
            r4 = r12
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r5 = 3
            r6 = 0
            r2 = 0
            r3 = 0
            kotlinx.coroutines.Deferred r12 = kotlinx.coroutines.BuildersKt.async$default(r1, r2, r3, r4, r5, r6)
            uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$load$2$ordersJob$1 r2 = new uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$load$2$ordersJob$1
            r2.<init>(r9)
            r4 = r2
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r2 = 0
            kotlinx.coroutines.Deferred r2 = kotlinx.coroutines.BuildersKt.async$default(r1, r2, r3, r4, r5, r6)
            r3 = r11
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r11.L$0 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r11.L$1 = r4
            r11.L$2 = r2
            r11.label = r8
            java.lang.Object r3 = r12.await(r3)
            if (r3 != r0) goto L6f
            goto Lae
        L6f:
            r10 = r3
            r3 = r12
            r12 = r10
        L72:
            kotlin.Result r12 = (kotlin.Result) r12
            java.lang.Object r12 = r12.getValue()
            androidx.compose.runtime.MutableState<uz.FonRo.pos.data.model.ShopStoreInfo> r4 = r11.$info$delegate
            boolean r5 = kotlin.Result.m7877isSuccessimpl(r12)
            if (r5 == 0) goto L86
            r5 = r12
            uz.FonRo.pos.data.model.ShopStoreInfo r5 = (uz.FonRo.pos.data.model.ShopStoreInfo) r5
            uz.FonRo.pos.ui.orders.OrdersScreenKt.access$OrdersScreen$lambda$2(r4, r5)
        L86:
            java.lang.Throwable r12 = kotlin.Result.m7873exceptionOrNullimpl(r12)
            if (r12 == 0) goto L91
            uz.FonRo.pos.ui.Toaster r4 = uz.FonRo.pos.ui.Toaster.INSTANCE
            r4.error(r12)
        L91:
            r12 = r11
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r11.L$0 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r11.L$1 = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r11.L$2 = r1
            r11.label = r7
            java.lang.Object r12 = r2.await(r12)
            if (r12 != r0) goto Laf
        Lae:
            return r0
        Laf:
            kotlin.Result r12 = (kotlin.Result) r12
            java.lang.Object r12 = r12.getValue()
            androidx.compose.runtime.MutableState<java.util.List<uz.FonRo.pos.data.model.ShopOrder>> r0 = r11.$allOrders$delegate
            androidx.compose.runtime.MutableState<java.lang.Boolean> r1 = r11.$failed$delegate
            boolean r2 = kotlin.Result.m7877isSuccessimpl(r12)
            if (r2 == 0) goto Lc9
            r2 = r12
            java.util.List r2 = (java.util.List) r2
            uz.FonRo.pos.ui.orders.OrdersScreenKt.access$OrdersScreen$lambda$11(r0, r2)
            r0 = 0
            uz.FonRo.pos.ui.orders.OrdersScreenKt.access$OrdersScreen$lambda$17(r1, r0)
        Lc9:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r11 = r11.$failed$delegate
            java.lang.Throwable r0 = kotlin.Result.m7873exceptionOrNullimpl(r12)
            if (r0 == 0) goto Ld9
            uz.FonRo.pos.ui.orders.OrdersScreenKt.access$OrdersScreen$lambda$17(r11, r8)
            uz.FonRo.pos.ui.Toaster r11 = uz.FonRo.pos.ui.Toaster.INSTANCE
            r11.error(r0)
        Ld9:
            kotlin.Result r11 = kotlin.Result.m7869boximpl(r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$load$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
