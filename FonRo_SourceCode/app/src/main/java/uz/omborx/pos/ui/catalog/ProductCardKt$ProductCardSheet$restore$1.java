package uz.FonRo.pos.ui.catalog;

import androidx.camera.video.AudioStats;
import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.model.ProductBody;
import uz.FonRo.pos.data.model.ProductResponse;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProductCard.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.catalog.ProductCardKt$ProductCardSheet$restore$1", f = "ProductCard.kt", i = {0}, l = {184}, m = "invokeSuspend", n = {"body"}, nl = {ModuleDescriptor.MODULE_VERSION}, s = {"L$0"}, v = 2)
/* loaded from: classes7.dex */
public final class ProductCardKt$ProductCardSheet$restore$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ Function1<Product, Unit> $onRestored;
    final /* synthetic */ Product $product;
    final /* synthetic */ Repo $repo;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ProductCardKt$ProductCardSheet$restore$1(Product product, Repo repo, Function1<? super Product, Unit> function1, Function0<Unit> function0, MutableState<Boolean> mutableState, Continuation<? super ProductCardKt$ProductCardSheet$restore$1> continuation) {
        super(2, continuation);
        this.$product = product;
        this.$repo = repo;
        this.$onRestored = function1;
        this.$onDismiss = function0;
        this.$busy$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProductCardKt$ProductCardSheet$restore$1(this.$product, this.$repo, this.$onRestored, this.$onDismiss, this.$busy$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProductCardKt$ProductCardSheet$restore$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object productUpdate;
        ApiClient apiClient;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String name = this.$product.getName();
                String barcode = this.$product.getBarcode();
                String str = barcode == null ? "" : barcode;
                String sku = this.$product.getSku();
                String str2 = sku == null ? "" : sku;
                List<String> barcodeAliases = this.$product.getBarcodeAliases();
                long categoryId = this.$product.getCategoryId();
                String unit = this.$product.getUnit();
                double purchasePrice = this.$product.getPurchasePrice();
                double salePrice = this.$product.getSalePrice();
                Double boxDouble = Boxing.boxDouble(this.$product.getQuantity());
                Double boxDouble2 = Boxing.boxDouble(this.$product.getSaleStep());
                ProductBody productBody = new ProductBody(name, str, str2, barcodeAliases, categoryId, unit, purchasePrice, salePrice, boxDouble, boxDouble2.doubleValue() > AudioStats.AUDIO_AMPLITUDE_NONE ? boxDouble2 : null, this.$product.getExpirationDate(), Boxing.boxInt(0), (List) null, 4096, (DefaultConstructorMarker) null);
                ApiClient apiClient2 = ApiClient.INSTANCE;
                this.L$0 = SpillingKt.nullOutSpilledVariable(productBody);
                this.L$1 = apiClient2;
                this.label = 1;
                productUpdate = ApiClient.INSTANCE.api().productUpdate(this.$product.getId(), productBody, this);
                if (productUpdate == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiClient = apiClient2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                apiClient = (ApiClient) this.L$1;
                ResultKt.throwOnFailure(obj);
                productUpdate = obj;
            }
            Product product = ((ProductResponse) ApiClient.unwrap$default(apiClient, (Response) productUpdate, false, 2, null)).getProduct();
            if (product == null) {
                product = Product.copy$default(this.$product, 0L, null, null, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0L, AudioStats.AUDIO_AMPLITUDE_NONE, null, null, null, null, 0, 32767, null);
            }
            this.$repo.upsertProduct(product);
            this.$repo.invalidate();
            Toaster.INSTANCE.ok(LangKt.tx("Товар вернулся в продажу", new Object[0]));
            this.$onRestored.invoke(product);
            this.$onDismiss.invoke();
        } finally {
            try {
                ProductCardKt.ProductCardSheet$lambda$6(this.$busy$delegate, false);
                return Unit.INSTANCE;
            } catch (Throwable th) {
            }
        }
        ProductCardKt.ProductCardSheet$lambda$6(this.$busy$delegate, false);
        return Unit.INSTANCE;
    }
}
