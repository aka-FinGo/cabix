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
import uz.FonRo.pos.data.model.Category;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CategorySheets.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.catalog.CategorySheetsKt$CategoryFormSheet$archive$1", f = "CategorySheets.kt", i = {}, l = {814}, m = "invokeSuspend", n = {}, nl = {815}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class CategorySheetsKt$CategoryFormSheet$archive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ Repo $repo;
    final /* synthetic */ MutableState<Boolean> $saving$delegate;
    final /* synthetic */ Category $target;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategorySheetsKt$CategoryFormSheet$archive$1(Category category, Repo repo, Function0<Unit> function0, MutableState<Boolean> mutableState, Continuation<? super CategorySheetsKt$CategoryFormSheet$archive$1> continuation) {
        super(2, continuation);
        this.$target = category;
        this.$repo = repo;
        this.$onDismiss = function0;
        this.$saving$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CategorySheetsKt$CategoryFormSheet$archive$1(this.$target, this.$repo, this.$onDismiss, this.$saving$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CategorySheetsKt$CategoryFormSheet$archive$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                Object categoryArchive = ApiClient.INSTANCE.api().categoryArchive(this.$target.getId(), this);
                if (categoryArchive == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiClient = apiClient2;
                obj = categoryArchive;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                apiClient = (ApiClient) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            ApiClient.unwrapVoid$default(apiClient, (Response) obj, false, 2, null);
            this.$repo.removeCategory(this.$target.getId());
            this.$repo.invalidate();
            Toaster.INSTANCE.ok(LangKt.tx("Категория в архиве", new Object[0]));
            CategorySheetsKt.CategoryFormSheet$lambda$8(this.$saving$delegate, false);
            this.$onDismiss.invoke();
        } catch (Throwable th) {
            Toaster.INSTANCE.error(th);
            CategorySheetsKt.CategoryFormSheet$lambda$8(this.$saving$delegate, false);
        }
        return Unit.INSTANCE;
    }
}
