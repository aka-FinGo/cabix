package uz.FonRo.pos.ui.catalog;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
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
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.net.ApiService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CatalogScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.catalog.CatalogScreenKt$CatalogScreen$2$1", f = "CatalogScreen.kt", i = {0, 0}, l = {152}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "$this$invokeSuspend_u24lambda_u240"}, nl = {152}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes7.dex */
public final class CatalogScreenKt$CatalogScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $archiveOpen$delegate;
    final /* synthetic */ MutableState<List<Product>> $archived$delegate;
    final /* synthetic */ MutableState<Boolean> $archivedLoaded$delegate;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CatalogScreenKt$CatalogScreen$2$1(MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, MutableState<List<Product>> mutableState3, Continuation<? super CatalogScreenKt$CatalogScreen$2$1> continuation) {
        super(2, continuation);
        this.$archiveOpen$delegate = mutableState;
        this.$archivedLoaded$delegate = mutableState2;
        this.$archived$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CatalogScreenKt$CatalogScreen$2$1 catalogScreenKt$CatalogScreen$2$1 = new CatalogScreenKt$CatalogScreen$2$1(this.$archiveOpen$delegate, this.$archivedLoaded$delegate, this.$archived$delegate, continuation);
        catalogScreenKt$CatalogScreen$2$1.L$0 = obj;
        return catalogScreenKt$CatalogScreen$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CatalogScreenKt$CatalogScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m7870constructorimpl;
        boolean CatalogScreen$lambda$25;
        ApiClient apiClient;
        boolean CatalogScreen$lambda$16;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CatalogScreen$lambda$25 = CatalogScreenKt.CatalogScreen$lambda$25(this.$archiveOpen$delegate);
                if (!CatalogScreen$lambda$25) {
                    CatalogScreen$lambda$16 = CatalogScreenKt.CatalogScreen$lambda$16(this.$archivedLoaded$delegate);
                    if (CatalogScreen$lambda$16) {
                        return Unit.INSTANCE;
                    }
                }
                Result.Companion companion = Result.INSTANCE;
                ApiClient apiClient2 = ApiClient.INSTANCE;
                ApiService api = ApiClient.INSTANCE.api();
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$2 = apiClient2;
                this.label = 1;
                Object products = api.products(1, this);
                if (products == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiClient = apiClient2;
                obj = products;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                apiClient = (ApiClient) this.L$2;
                ResultKt.throwOnFailure(obj);
            }
            m7870constructorimpl = Result.m7870constructorimpl((List) ApiClient.unwrap$default(apiClient, (Response) obj, false, 2, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        MutableState<List<Product>> mutableState = this.$archived$delegate;
        MutableState<Boolean> mutableState2 = this.$archivedLoaded$delegate;
        if (Result.m7877isSuccessimpl(m7870constructorimpl)) {
            mutableState.setValue((List) m7870constructorimpl);
            CatalogScreenKt.CatalogScreen$lambda$17(mutableState2, true);
        }
        return Unit.INSTANCE;
    }
}
