package uz.FonRo.pos.ui.clients;

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
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import uz.FonRo.pos.data.model.Customer;
import uz.FonRo.pos.data.model.SaleRow;
import uz.FonRo.pos.data.model.SalesHistoryResponse;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.net.ApiService;
import uz.FonRo.pos.ui.Toaster;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ClientsScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.clients.ClientsScreenKt$ClientCardSheet$1$1", f = "ClientsScreen.kt", i = {0, 0}, l = {439}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "$this$invokeSuspend_u24lambda_u240"}, nl = {438}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes7.dex */
public final class ClientsScreenKt$ClientCardSheet$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Customer $customer;
    final /* synthetic */ MutableState<Boolean> $loading$delegate;
    final /* synthetic */ MutableState<List<SaleRow>> $rows$delegate;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClientsScreenKt$ClientCardSheet$1$1(MutableState<Boolean> mutableState, Customer customer, MutableState<List<SaleRow>> mutableState2, Continuation<? super ClientsScreenKt$ClientCardSheet$1$1> continuation) {
        super(2, continuation);
        this.$loading$delegate = mutableState;
        this.$customer = customer;
        this.$rows$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ClientsScreenKt$ClientCardSheet$1$1 clientsScreenKt$ClientCardSheet$1$1 = new ClientsScreenKt$ClientCardSheet$1$1(this.$loading$delegate, this.$customer, this.$rows$delegate, continuation);
        clientsScreenKt$ClientCardSheet$1$1.L$0 = obj;
        return clientsScreenKt$ClientCardSheet$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClientsScreenKt$ClientCardSheet$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                ClientsScreenKt.ClientCardSheet$lambda$6(this.$loading$delegate, true);
                Customer customer = this.$customer;
                Result.Companion companion = Result.INSTANCE;
                ApiClient apiClient2 = ApiClient.INSTANCE;
                ApiService api = ApiClient.INSTANCE.api();
                Map<String, String> mapOf = MapsKt.mapOf(TuplesKt.to(TypedValues.CycleType.S_WAVE_PERIOD, "all"), TuplesKt.to("customer_id", String.valueOf(customer.getId())));
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$2 = apiClient2;
                this.label = 1;
                obj = api.salesHistory(mapOf, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiClient = apiClient2;
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
        Customer customer2 = this.$customer;
        MutableState<List<SaleRow>> mutableState = this.$rows$delegate;
        if (Result.m7877isSuccessimpl(m7870constructorimpl)) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : (List) m7870constructorimpl) {
                if (((SaleRow) obj2).getCustomerId() == customer2.getId()) {
                    arrayList.add(obj2);
                }
            }
            mutableState.setValue(arrayList);
        }
        Throwable m7873exceptionOrNullimpl = Result.m7873exceptionOrNullimpl(m7870constructorimpl);
        if (m7873exceptionOrNullimpl != null) {
            Toaster.INSTANCE.error(m7873exceptionOrNullimpl);
        }
        ClientsScreenKt.ClientCardSheet$lambda$6(this.$loading$delegate, false);
        return Unit.INSTANCE;
    }
}
