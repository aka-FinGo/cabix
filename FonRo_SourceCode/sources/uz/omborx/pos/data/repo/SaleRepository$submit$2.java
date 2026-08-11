package uz.FonRo.pos.data.repo;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Map;
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
import uz.FonRo.pos.data.model.Paywall;
import uz.FonRo.pos.data.model.SaleBody;
import uz.FonRo.pos.data.model.SaleResult;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.net.ApiException;
import uz.FonRo.pos.data.net.ApiService;
import uz.FonRo.pos.data.repo.SaleRepository;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SaleRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Luz/FonRo/pos/data/repo/SaleRepository$Outcome;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.data.repo.SaleRepository$submit$2", f = "SaleRepository.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, nl = {50}, s = {}, v = 2)
/* loaded from: classes5.dex */
public final class SaleRepository$submit$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SaleRepository.Outcome>, Object> {
    final /* synthetic */ SaleBody $body;
    final /* synthetic */ int $itemsCount;
    final /* synthetic */ Map<Long, Double> $stockDeltas;
    final /* synthetic */ double $total;
    Object L$0;
    int label;
    final /* synthetic */ SaleRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleRepository$submit$2(SaleRepository saleRepository, SaleBody saleBody, double d, int i, Map<Long, Double> map, Continuation<? super SaleRepository$submit$2> continuation) {
        super(2, continuation);
        this.this$0 = saleRepository;
        this.$body = saleBody;
        this.$total = d;
        this.$itemsCount = i;
        this.$stockDeltas = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SaleRepository$submit$2(this.this$0, this.$body, this.$total, this.$itemsCount, this.$stockDeltas, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SaleRepository.Outcome> continuation) {
        return ((SaleRepository$submit$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Repo repo;
        Repo repo2;
        Paywall paywallFrom;
        Repo repo3;
        Repo repo4;
        ApiService api;
        ApiClient apiClient;
        Repo repo5;
        Repo repo6;
        Repo repo7;
        Repo repo8;
        Repo repo9;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.outboxAdd(this.$body, this.$total, this.$itemsCount);
                ApiClient apiClient2 = ApiClient.INSTANCE;
                api = this.this$0.getApi();
                this.L$0 = apiClient2;
                this.label = 1;
                Object saleComplete = api.saleComplete(this.$body, this);
                if (saleComplete == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiClient = apiClient2;
                obj = saleComplete;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                apiClient = (ApiClient) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            SaleResult saleResult = (SaleResult) ApiClient.unwrap$default(apiClient, (Response) obj, false, 2, null);
            repo5 = this.this$0.repo;
            repo5.getOutbox().remove(this.$body.getTransactionId());
            repo6 = this.this$0.repo;
            repo6.invalidate();
            repo7 = this.this$0.repo;
            repo7.updatePaywall(saleResult.getPaywall());
            repo8 = this.this$0.repo;
            repo8.setOnline(true);
            if (!saleResult.getAlreadySynced()) {
                repo9 = this.this$0.repo;
                repo9.applyStockDelta(this.$stockDeltas);
            }
            return new SaleRepository.Outcome.Done(saleResult, saleResult.getAlreadySynced());
        } catch (Throwable th) {
            ApiException asApiError = ApiClient.INSTANCE.asApiError(th);
            boolean offline = asApiError.getOffline();
            SaleRepository saleRepository = this.this$0;
            if (offline) {
                repo3 = saleRepository.repo;
                repo3.setOnline(false);
                repo4 = this.this$0.repo;
                repo4.applyStockDelta(this.$stockDeltas);
                return new SaleRepository.Outcome.Queued(this.$body.getTransactionId(), asApiError.getMessage());
            }
            repo = saleRepository.repo;
            repo.getOutbox().remove(this.$body.getTransactionId());
            repo2 = this.this$0.repo;
            paywallFrom = this.this$0.paywallFrom(asApiError);
            repo2.updatePaywall(paywallFrom);
            throw asApiError;
        }
    }
}
