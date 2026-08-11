package uz.FonRo.pos.ui.money;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Num;
import uz.FonRo.pos.data.model.Expense;
import uz.FonRo.pos.data.model.ExpenseBody;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExpensesScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.money.ExpensesScreenKt$ExpenseFormSheet$save$1", f = "ExpensesScreen.kt", i = {0, 1}, l = {642, 644}, m = "invokeSuspend", n = {"body", "body"}, nl = {644, 646}, s = {"L$0", "L$0"}, v = 2)
/* loaded from: classes7.dex */
public final class ExpensesScreenKt$ExpenseFormSheet$save$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Double> $amount$delegate;
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    final /* synthetic */ Expense $expense;
    final /* synthetic */ boolean $isNew;
    final /* synthetic */ String $name;
    final /* synthetic */ MutableState<String> $note$delegate;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ Function0<Unit> $onSaved;
    final /* synthetic */ Repo $repo;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpensesScreenKt$ExpenseFormSheet$save$1(String str, Expense expense, Repo repo, boolean z, Function0<Unit> function0, Function0<Unit> function02, MutableState<Double> mutableState, MutableState<String> mutableState2, MutableState<Boolean> mutableState3, Continuation<? super ExpensesScreenKt$ExpenseFormSheet$save$1> continuation) {
        super(2, continuation);
        this.$name = str;
        this.$expense = expense;
        this.$repo = repo;
        this.$isNew = z;
        this.$onSaved = function0;
        this.$onDismiss = function02;
        this.$amount$delegate = mutableState;
        this.$note$delegate = mutableState2;
        this.$busy$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExpensesScreenKt$ExpenseFormSheet$save$1(this.$name, this.$expense, this.$repo, this.$isNew, this.$onSaved, this.$onDismiss, this.$amount$delegate, this.$note$delegate, this.$busy$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ExpensesScreenKt$ExpenseFormSheet$save$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        double ExpenseFormSheet$lambda$4;
        String ExpenseFormSheet$lambda$7;
        ApiClient apiClient;
        ApiClient apiClient2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String str = this.$name;
                Num num = Num.INSTANCE;
                ExpenseFormSheet$lambda$4 = ExpensesScreenKt.ExpenseFormSheet$lambda$4(this.$amount$delegate);
                double money = num.money(ExpenseFormSheet$lambda$4);
                String str2 = Fmt.INSTANCE.todayISO();
                ExpenseFormSheet$lambda$7 = ExpensesScreenKt.ExpenseFormSheet$lambda$7(this.$note$delegate);
                ExpenseBody expenseBody = new ExpenseBody(str, money, str2, StringsKt.trim((CharSequence) ExpenseFormSheet$lambda$7).toString());
                if (this.$expense == null) {
                    ApiClient apiClient3 = ApiClient.INSTANCE;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(expenseBody);
                    this.L$1 = apiClient3;
                    this.label = 1;
                    Object expenseCreate = ApiClient.INSTANCE.api().expenseCreate(expenseBody, this);
                    if (expenseCreate != coroutine_suspended) {
                        apiClient2 = apiClient3;
                        obj = expenseCreate;
                        ApiClient.unwrapVoid$default(apiClient2, (Response) obj, false, 2, null);
                    }
                } else {
                    ApiClient apiClient4 = ApiClient.INSTANCE;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(expenseBody);
                    this.L$1 = apiClient4;
                    this.label = 2;
                    Object expenseUpdate = ApiClient.INSTANCE.api().expenseUpdate(this.$expense.getId(), expenseBody, this);
                    if (expenseUpdate != coroutine_suspended) {
                        apiClient = apiClient4;
                        obj = expenseUpdate;
                        ApiClient.unwrapVoid$default(apiClient, (Response) obj, false, 2, null);
                    }
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                apiClient2 = (ApiClient) this.L$1;
                ResultKt.throwOnFailure(obj);
                ApiClient.unwrapVoid$default(apiClient2, (Response) obj, false, 2, null);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                apiClient = (ApiClient) this.L$1;
                ResultKt.throwOnFailure(obj);
                ApiClient.unwrapVoid$default(apiClient, (Response) obj, false, 2, null);
            }
            this.$repo.invalidate();
            Toaster.INSTANCE.ok(this.$isNew ? LangKt.tx("Расход записан", new Object[0]) : LangKt.tx("Расход изменён", new Object[0]));
            this.$onSaved.invoke();
            this.$onDismiss.invoke();
        } finally {
            try {
                ExpensesScreenKt.ExpenseFormSheet$lambda$14(this.$busy$delegate, false);
                return Unit.INSTANCE;
            } catch (Throwable th) {
            }
        }
        ExpensesScreenKt.ExpenseFormSheet$lambda$14(this.$busy$delegate, false);
        return Unit.INSTANCE;
    }
}
