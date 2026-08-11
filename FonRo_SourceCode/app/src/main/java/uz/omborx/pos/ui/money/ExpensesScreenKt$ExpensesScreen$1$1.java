package uz.FonRo.pos.ui.money;

import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import uz.FonRo.pos.data.model.Expense;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.ui.Toaster;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExpensesScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.money.ExpensesScreenKt$ExpensesScreen$1$1", f = "ExpensesScreen.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, nl = {MenuKt.InTransitionDuration}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class ExpensesScreenKt$ExpensesScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<List<Expense>> $data$delegate;
    final /* synthetic */ MutableState<String> $error$delegate;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpensesScreenKt$ExpensesScreen$1$1(MutableState<String> mutableState, MutableState<List<Expense>> mutableState2, Continuation<? super ExpensesScreenKt$ExpensesScreen$1$1> continuation) {
        super(2, continuation);
        this.$error$delegate = mutableState;
        this.$data$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExpensesScreenKt$ExpensesScreen$1$1(this.$error$delegate, this.$data$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ExpensesScreenKt$ExpensesScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableState<List<Expense>> mutableState;
        ApiClient apiClient;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.$error$delegate.setValue(null);
                this.$data$delegate.setValue(null);
                mutableState = this.$data$delegate;
                ApiClient apiClient2 = ApiClient.INSTANCE;
                this.L$0 = mutableState;
                this.L$1 = apiClient2;
                this.label = 1;
                Object expenses = ApiClient.INSTANCE.api().expenses(this);
                if (expenses == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiClient = apiClient2;
                obj = expenses;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                apiClient = (ApiClient) this.L$1;
                mutableState = (MutableState) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            mutableState.setValue((List) ApiClient.unwrap$default(apiClient, (Response) obj, false, 2, null));
        } catch (Throwable th) {
            this.$error$delegate.setValue(ApiClient.INSTANCE.asApiError(th).getMessage());
            Toaster.INSTANCE.error(th);
        }
        return Unit.INSTANCE;
    }
}
