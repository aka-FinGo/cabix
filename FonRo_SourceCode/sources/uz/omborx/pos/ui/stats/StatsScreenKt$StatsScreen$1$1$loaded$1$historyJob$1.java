package uz.FonRo.pos.ui.stats;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
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
import uz.FonRo.pos.data.net.ApiService;

/* compiled from: StatsScreen.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Luz/FonRo/pos/data/model/SaleRow;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.stats.StatsScreenKt$StatsScreen$1$1$loaded$1$historyJob$1", f = "StatsScreen.kt", i = {}, l = {187}, m = "invokeSuspend", n = {}, nl = {186}, s = {}, v = 2)
/* loaded from: classes7.dex */
final class StatsScreenKt$StatsScreen$1$1$loaded$1$historyJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends SaleRow>>, Object> {
    final /* synthetic */ String $from;
    final /* synthetic */ String $to;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatsScreenKt$StatsScreen$1$1$loaded$1$historyJob$1(String str, String str2, Continuation<? super StatsScreenKt$StatsScreen$1$1$loaded$1$historyJob$1> continuation) {
        super(2, continuation);
        this.$from = str;
        this.$to = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StatsScreenKt$StatsScreen$1$1$loaded$1$historyJob$1(this.$from, this.$to, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends SaleRow>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<SaleRow>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<SaleRow>> continuation) {
        return ((StatsScreenKt$StatsScreen$1$1$loaded$1$historyJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ApiClient apiClient;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ApiClient apiClient2 = ApiClient.INSTANCE;
            ApiService api = ApiClient.INSTANCE.api();
            Pair[] pairArr = {TuplesKt.to(TypedValues.CycleType.S_WAVE_PERIOD, "custom"), TuplesKt.to(TypedValues.TransitionType.S_FROM, this.$from), TuplesKt.to(TypedValues.TransitionType.S_TO, this.$to)};
            this.L$0 = apiClient2;
            this.label = 1;
            Object salesHistory = api.salesHistory(MapsKt.mapOf(pairArr), this);
            if (salesHistory == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = salesHistory;
            apiClient = apiClient2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            apiClient = (ApiClient) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return ((SalesHistoryResponse) ApiClient.unwrap$default(apiClient, (Response) obj, false, 2, null)).getItems();
    }
}
