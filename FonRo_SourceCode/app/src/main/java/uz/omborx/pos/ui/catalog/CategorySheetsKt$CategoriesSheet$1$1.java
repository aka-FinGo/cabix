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
import uz.FonRo.pos.data.model.Category;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.net.ApiService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CategorySheets.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.catalog.CategorySheetsKt$CategoriesSheet$1$1", f = "CategorySheets.kt", i = {0, 0}, l = {107}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "$this$invokeSuspend_u24lambda_u240"}, nl = {107}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes7.dex */
public final class CategorySheetsKt$CategoriesSheet$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<List<Category>> $archived$delegate;
    final /* synthetic */ MutableState<Boolean> $archivedLoaded$delegate;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategorySheetsKt$CategoriesSheet$1$1(MutableState<List<Category>> mutableState, MutableState<Boolean> mutableState2, Continuation<? super CategorySheetsKt$CategoriesSheet$1$1> continuation) {
        super(2, continuation);
        this.$archived$delegate = mutableState;
        this.$archivedLoaded$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CategorySheetsKt$CategoriesSheet$1$1 categorySheetsKt$CategoriesSheet$1$1 = new CategorySheetsKt$CategoriesSheet$1$1(this.$archived$delegate, this.$archivedLoaded$delegate, continuation);
        categorySheetsKt$CategoriesSheet$1$1.L$0 = obj;
        return categorySheetsKt$CategoriesSheet$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CategorySheetsKt$CategoriesSheet$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                Object categories = api.categories(1, this);
                if (categories == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiClient = apiClient2;
                obj = categories;
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
        MutableState<List<Category>> mutableState = this.$archived$delegate;
        MutableState<Boolean> mutableState2 = this.$archivedLoaded$delegate;
        if (Result.m7877isSuccessimpl(m7870constructorimpl)) {
            mutableState.setValue((List) m7870constructorimpl);
            CategorySheetsKt.CategoriesSheet$lambda$19(mutableState2, true);
        }
        return Unit.INSTANCE;
    }
}
