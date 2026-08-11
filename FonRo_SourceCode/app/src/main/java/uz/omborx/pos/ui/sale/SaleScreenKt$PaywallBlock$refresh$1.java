package uz.FonRo.pos.ui.sale;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.data.model.Paywall;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.ui.Toaster;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SaleScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.sale.SaleScreenKt$PaywallBlock$refresh$1", f = "SaleScreen.kt", i = {}, l = {613}, m = "invokeSuspend", n = {}, nl = {614}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class SaleScreenKt$PaywallBlock$refresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FonRoApp $app;
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleScreenKt$PaywallBlock$refresh$1(FonRoApp FonRoApp, MutableState<Boolean> mutableState, Continuation<? super SaleScreenKt$PaywallBlock$refresh$1> continuation) {
        super(2, continuation);
        this.$app = FonRoApp;
        this.$busy$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SaleScreenKt$PaywallBlock$refresh$1(this.$app, this.$busy$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SaleScreenKt$PaywallBlock$refresh$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                Object entitlement = ApiClient.INSTANCE.api().entitlement(this);
                if (entitlement == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiClient = apiClient2;
                obj = entitlement;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                apiClient = (ApiClient) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            Paywall paywall = (Paywall) ApiClient.unwrap$default(apiClient, (Response) obj, false, 2, null);
            this.$app.getRepo().updatePaywall(paywall);
            if (paywall.isLocked()) {
                Toaster.show$default(Toaster.INSTANCE, LangKt.tx("Оплата ещё не подтверждена. Если только что оплатили — подождите минуту и нажмите ещё раз.", new Object[0]), null, null, null, null, 30, null);
            } else {
                Toaster.INSTANCE.ok(LangKt.tx("Подписка активна. Спасибо!", new Object[0]));
            }
        } finally {
            try {
                SaleScreenKt.PaywallBlock$lambda$2(this.$busy$delegate, false);
                return Unit.INSTANCE;
            } catch (Throwable th) {
            }
        }
        SaleScreenKt.PaywallBlock$lambda$2(this.$busy$delegate, false);
        return Unit.INSTANCE;
    }
}
