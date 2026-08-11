package uz.FonRo.pos.ui.money;

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
import uz.FonRo.pos.data.model.SaleRow;
import uz.FonRo.pos.data.model.SalesHistoryResponse;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.ui.Toaster;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HistoryScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.money.HistoryScreenKt$HistoryScreen$load$1", f = "HistoryScreen.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, nl = {140}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class HistoryScreenKt$HistoryScreen$load$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $error$delegate;
    final /* synthetic */ int $gen;
    final /* synthetic */ int[] $generation;
    final /* synthetic */ MutableState<List<SaleRow>> $rows$delegate;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryScreenKt$HistoryScreen$load$1(int i, int[] iArr, MutableState<List<SaleRow>> mutableState, MutableState<String> mutableState2, Continuation<? super HistoryScreenKt$HistoryScreen$load$1> continuation) {
        super(2, continuation);
        this.$gen = i;
        this.$generation = iArr;
        this.$rows$delegate = mutableState;
        this.$error$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoryScreenKt$HistoryScreen$load$1(this.$gen, this.$generation, this.$rows$delegate, this.$error$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HistoryScreenKt$HistoryScreen$load$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ApiClient apiClient;
        SalesHistoryResponse salesHistoryResponse;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ApiClient apiClient2 = ApiClient.INSTANCE;
                this.L$0 = apiClient2;
                this.label = 1;
                Object salesHistory = ApiClient.INSTANCE.api().salesHistory(HistoryState.INSTANCE.params(), this);
                if (salesHistory == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiClient = apiClient2;
                obj = salesHistory;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                apiClient = (ApiClient) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            salesHistoryResponse = (SalesHistoryResponse) ApiClient.unwrap$default(apiClient, (Response) obj, false, 2, null);
        } catch (Throwable th) {
            if (this.$gen != this.$generation[0]) {
                return Unit.INSTANCE;
            }
            this.$error$delegate.setValue(ApiClient.INSTANCE.asApiError(th).getMessage());
            Toaster.INSTANCE.error(th);
        }
        if (this.$gen != this.$generation[0]) {
            return Unit.INSTANCE;
        }
        this.$rows$delegate.setValue(salesHistoryResponse.getItems());
        return Unit.INSTANCE;
    }
}
