package uz.FonRo.pos.ui.money;

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
import uz.FonRo.pos.data.model.Expense;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExpensesScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.money.ExpensesScreenKt$ExpenseSheet$cancel$1", f = "ExpensesScreen.kt", i = {}, l = {473}, m = "invokeSuspend", n = {}, nl = {474}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class ExpensesScreenKt$ExpenseSheet$cancel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    final /* synthetic */ Expense $expense;
    final /* synthetic */ Function0<Unit> $onChanged;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ Repo $repo;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpensesScreenKt$ExpenseSheet$cancel$1(Expense expense, Repo repo, Function0<Unit> function0, Function0<Unit> function02, MutableState<Boolean> mutableState, Continuation<? super ExpensesScreenKt$ExpenseSheet$cancel$1> continuation) {
        super(2, continuation);
        this.$expense = expense;
        this.$repo = repo;
        this.$onChanged = function0;
        this.$onDismiss = function02;
        this.$busy$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExpensesScreenKt$ExpenseSheet$cancel$1(this.$expense, this.$repo, this.$onChanged, this.$onDismiss, this.$busy$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ExpensesScreenKt$ExpenseSheet$cancel$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                Object expenseCancel = ApiClient.INSTANCE.api().expenseCancel(this.$expense.getId(), this);
                if (expenseCancel == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiClient = apiClient2;
                obj = expenseCancel;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                apiClient = (ApiClient) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            ApiClient.unwrapVoid$default(apiClient, (Response) obj, false, 2, null);
            this.$repo.invalidate();
            Toaster.INSTANCE.ok(LangKt.tx("Расход отменён", new Object[0]));
            this.$onChanged.invoke();
            this.$onDismiss.invoke();
        } finally {
            try {
                ExpensesScreenKt.ExpenseSheet$lambda$5(this.$busy$delegate, false);
                return Unit.INSTANCE;
            } catch (Throwable th) {
            }
        }
        ExpensesScreenKt.ExpenseSheet$lambda$5(this.$busy$delegate, false);
        return Unit.INSTANCE;
    }
}
