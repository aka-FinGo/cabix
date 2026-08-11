package uz.FonRo.pos.ui.catalog;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProductCard.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.catalog.ProductCardKt$ProductCardSheet$archive$1", f = "ProductCard.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, nl = {149}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class ProductCardKt$ProductCardSheet$archive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    final /* synthetic */ Function0<Unit> $onArchived;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ Product $product;
    final /* synthetic */ Repo $repo;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductCardKt$ProductCardSheet$archive$1(Product product, Repo repo, Function0<Unit> function0, Function0<Unit> function02, MutableState<Boolean> mutableState, Continuation<? super ProductCardKt$ProductCardSheet$archive$1> continuation) {
        super(2, continuation);
        this.$product = product;
        this.$repo = repo;
        this.$onArchived = function0;
        this.$onDismiss = function02;
        this.$busy$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProductCardKt$ProductCardSheet$archive$1(this.$product, this.$repo, this.$onArchived, this.$onDismiss, this.$busy$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProductCardKt$ProductCardSheet$archive$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ApiClient apiClient;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ApiClient apiClient2 = ApiClient.INSTANCE;
                this.L$0 = apiClient2;
                this.label = 1;
                Object productArchive = ApiClient.INSTANCE.api().productArchive(this.$product.getId(), this);
                if (productArchive == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiClient = apiClient2;
                obj = productArchive;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                apiClient = (ApiClient) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            ApiClient.unwrapVoid$default(apiClient, (Response) obj, false, 2, null);
            this.$repo.removeProduct(this.$product.getId());
            this.$repo.invalidate();
            Toaster.INSTANCE.ok(LangKt.tx("Товар в архиве", new Object[0]));
            this.$onArchived.invoke();
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
