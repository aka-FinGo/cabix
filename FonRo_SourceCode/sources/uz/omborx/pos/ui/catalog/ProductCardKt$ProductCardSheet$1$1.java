package uz.FonRo.pos.ui.catalog;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.model.SaleRow;
import uz.FonRo.pos.data.model.SalesHistoryResponse;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.net.ApiService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProductCard.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.catalog.ProductCardKt$ProductCardSheet$1$1", f = "ProductCard.kt", i = {0, 0}, l = {128}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "$this$invokeSuspend_u24lambda_u240"}, nl = {127}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes7.dex */
public final class ProductCardKt$ProductCardSheet$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $loadError$delegate;
    final /* synthetic */ MutableState<Boolean> $loading$delegate;
    final /* synthetic */ Product $product;
    final /* synthetic */ MutableState<List<SaleRow>> $sales$delegate;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductCardKt$ProductCardSheet$1$1(MutableState<Boolean> mutableState, MutableState<String> mutableState2, Product product, MutableState<List<SaleRow>> mutableState3, Continuation<? super ProductCardKt$ProductCardSheet$1$1> continuation) {
        super(2, continuation);
        this.$loading$delegate = mutableState;
        this.$loadError$delegate = mutableState2;
        this.$product = product;
        this.$sales$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProductCardKt$ProductCardSheet$1$1 productCardKt$ProductCardSheet$1$1 = new ProductCardKt$ProductCardSheet$1$1(this.$loading$delegate, this.$loadError$delegate, this.$product, this.$sales$delegate, continuation);
        productCardKt$ProductCardSheet$1$1.L$0 = obj;
        return productCardKt$ProductCardSheet$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProductCardKt$ProductCardSheet$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                ProductCardKt.ProductCardSheet$lambda$18(this.$loading$delegate, true);
                this.$loadError$delegate.setValue(null);
                Result.Companion companion = Result.INSTANCE;
                ApiClient apiClient2 = ApiClient.INSTANCE;
                ApiService api = ApiClient.INSTANCE.api();
                Map<String, String> mapOf = MapsKt.mapOf(TuplesKt.to(TypedValues.CycleType.S_WAVE_PERIOD, "all"));
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$2 = apiClient2;
                this.label = 1;
                Object salesHistory = api.salesHistory(mapOf, this);
                if (salesHistory == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiClient = apiClient2;
                obj = salesHistory;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                apiClient = (ApiClient) this.L$2;
                ResultKt.throwOnFailure(obj);
            }
            m7870constructorimpl = Result.m7870constructorimpl(((SalesHistoryResponse) ApiClient.unwrap$default(apiClient, (Response) obj, false, 2, null)).getItems());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        Product product = this.$product;
        MutableState<List<SaleRow>> mutableState = this.$sales$delegate;
        if (Result.m7877isSuccessimpl(m7870constructorimpl)) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : (List) m7870constructorimpl) {
                SaleRow saleRow = (SaleRow) obj2;
                if (saleRow.getProductId() == product.getId() || StringsKt.equals(saleRow.getTitle(), product.getName(), true)) {
                    arrayList.add(obj2);
                }
            }
            mutableState.setValue(arrayList);
        }
        MutableState<String> mutableState2 = this.$loadError$delegate;
        Throwable m7873exceptionOrNullimpl = Result.m7873exceptionOrNullimpl(m7870constructorimpl);
        if (m7873exceptionOrNullimpl != null) {
            mutableState2.setValue(ApiClient.INSTANCE.asApiError(m7873exceptionOrNullimpl).getMessage());
        }
        ProductCardKt.ProductCardSheet$lambda$18(this.$loading$delegate, false);
        return Unit.INSTANCE;
    }
}
