package uz.FonRo.pos.ui.orders;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import uz.FonRo.pos.data.model.ShopStoreInfo;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.net.ApiService;

/* compiled from: OrdersScreen.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Luz/FonRo/pos/data/model/ShopStoreInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$load$2$infoJob$1", f = "OrdersScreen.kt", i = {0, 0}, l = {131}, m = "invokeSuspend", n = {"$this$async", "$this$invokeSuspend_u24lambda_u240"}, nl = {131}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes7.dex */
final class OrdersScreenKt$OrdersScreen$load$2$infoJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends ShopStoreInfo>>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OrdersScreenKt$OrdersScreen$load$2$infoJob$1(Continuation<? super OrdersScreenKt$OrdersScreen$load$2$infoJob$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OrdersScreenKt$OrdersScreen$load$2$infoJob$1 ordersScreenKt$OrdersScreen$load$2$infoJob$1 = new OrdersScreenKt$OrdersScreen$load$2$infoJob$1(continuation);
        ordersScreenKt$OrdersScreen$load$2$infoJob$1.L$0 = obj;
        return ordersScreenKt$OrdersScreen$load$2$infoJob$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends ShopStoreInfo>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<ShopStoreInfo>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<ShopStoreInfo>> continuation) {
        return ((OrdersScreenKt$OrdersScreen$load$2$infoJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m7870constructorimpl;
        ApiClient apiClient;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result.Companion companion = Result.INSTANCE;
                ApiClient apiClient2 = ApiClient.INSTANCE;
                ApiService api = ApiClient.INSTANCE.api();
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$2 = apiClient2;
                this.label = 1;
                Object shopStoreInfo = api.shopStoreInfo(this);
                if (shopStoreInfo == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiClient = apiClient2;
                obj = shopStoreInfo;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                apiClient = (ApiClient) this.L$2;
                ResultKt.throwOnFailure(obj);
            }
            m7870constructorimpl = Result.m7870constructorimpl((ShopStoreInfo) ApiClient.unwrap$default(apiClient, (Response) obj, false, 2, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m7869boximpl(m7870constructorimpl);
    }
}
