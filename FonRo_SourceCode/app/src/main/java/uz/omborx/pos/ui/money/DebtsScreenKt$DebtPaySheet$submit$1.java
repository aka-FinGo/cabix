package uz.FonRo.pos.ui.money;

import androidx.camera.video.AudioStats;
import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.PointerIconCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Num;
import uz.FonRo.pos.data.model.DebtPayBody;
import uz.FonRo.pos.data.model.DebtPayResult;
import uz.FonRo.pos.data.model.DebtSale;
import uz.FonRo.pos.data.model.PayType;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.net.ApiService;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DebtsScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.money.DebtsScreenKt$DebtPaySheet$submit$1", f = "DebtsScreen.kt", i = {0}, l = {PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW}, m = "invokeSuspend", n = {"paidNow"}, nl = {PointerIconCompat.TYPE_ALL_SCROLL}, s = {"D$0"}, v = 2)
/* loaded from: classes7.dex */
public final class DebtsScreenKt$DebtPaySheet$submit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Double> $amount$delegate;
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    final /* synthetic */ MutableState<String> $note$delegate;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ Function0<Unit> $onPaid;
    final /* synthetic */ MutableState<PayType> $payType$delegate;
    final /* synthetic */ Repo $repo;
    final /* synthetic */ DebtSale $sale;
    double D$0;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebtsScreenKt$DebtPaySheet$submit$1(DebtSale debtSale, Repo repo, Function0<Unit> function0, Function0<Unit> function02, MutableState<Double> mutableState, MutableState<PayType> mutableState2, MutableState<String> mutableState3, MutableState<Boolean> mutableState4, Continuation<? super DebtsScreenKt$DebtPaySheet$submit$1> continuation) {
        super(2, continuation);
        this.$sale = debtSale;
        this.$repo = repo;
        this.$onPaid = function0;
        this.$onDismiss = function02;
        this.$amount$delegate = mutableState;
        this.$payType$delegate = mutableState2;
        this.$note$delegate = mutableState3;
        this.$busy$delegate = mutableState4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebtsScreenKt$DebtPaySheet$submit$1(this.$sale, this.$repo, this.$onPaid, this.$onDismiss, this.$amount$delegate, this.$payType$delegate, this.$note$delegate, this.$busy$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DebtsScreenKt$DebtPaySheet$submit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        double DebtPaySheet$lambda$4;
        double money;
        PayType DebtPaySheet$lambda$1;
        PayType DebtPaySheet$lambda$12;
        PayType DebtPaySheet$lambda$13;
        double d;
        String DebtPaySheet$lambda$7;
        Object debtPay;
        ApiClient apiClient;
        String tx;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Num num = Num.INSTANCE;
                DebtPaySheet$lambda$4 = DebtsScreenKt.DebtPaySheet$lambda$4(this.$amount$delegate);
                money = num.money(DebtPaySheet$lambda$4);
                ApiClient apiClient2 = ApiClient.INSTANCE;
                ApiService api = ApiClient.INSTANCE.api();
                long id = this.$sale.getId();
                DebtPaySheet$lambda$1 = DebtsScreenKt.DebtPaySheet$lambda$1(this.$payType$delegate);
                String code = DebtPaySheet$lambda$1.getCode();
                DebtPaySheet$lambda$12 = DebtsScreenKt.DebtPaySheet$lambda$1(this.$payType$delegate);
                double d2 = DebtPaySheet$lambda$12 == PayType.CASH ? money : AudioStats.AUDIO_AMPLITUDE_NONE;
                DebtPaySheet$lambda$13 = DebtsScreenKt.DebtPaySheet$lambda$1(this.$payType$delegate);
                d = AudioStats.AUDIO_AMPLITUDE_NONE;
                double d3 = DebtPaySheet$lambda$13 == PayType.CARD ? money : 0.0d;
                DebtPaySheet$lambda$7 = DebtsScreenKt.DebtPaySheet$lambda$7(this.$note$delegate);
                this.L$0 = apiClient2;
                this.D$0 = money;
                this.label = 1;
                debtPay = api.debtPay(new DebtPayBody(id, money, code, d2, d3, StringsKt.trim((CharSequence) DebtPaySheet$lambda$7).toString()), this);
                if (debtPay == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiClient = apiClient2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                double d4 = this.D$0;
                apiClient = (ApiClient) this.L$0;
                ResultKt.throwOnFailure(obj);
                money = d4;
                d = AudioStats.AUDIO_AMPLITUDE_NONE;
                debtPay = obj;
            }
            double debtAmount = ((DebtPayResult) ApiClient.unwrap$default(apiClient, (Response) debtPay, false, 2, null)).getDebtAmount();
            Toaster toaster = Toaster.INSTANCE;
            if (debtAmount < d) {
                tx = LangKt.tx("Принято: %s", this.$repo.money(Boxing.boxDouble(money)));
            } else if (debtAmount > 0.001d) {
                tx = LangKt.tx("Принято. Остаток: %s", this.$repo.money(Boxing.boxDouble(debtAmount)));
            } else {
                tx = LangKt.tx("Долг полностью закрыт 🎉", new Object[0]);
            }
            toaster.ok(tx);
            this.$repo.invalidate();
            this.$onPaid.invoke();
            this.$onDismiss.invoke();
        } finally {
            try {
                DebtsScreenKt.DebtPaySheet$lambda$14(this.$busy$delegate, false);
                return Unit.INSTANCE;
            } catch (Throwable th) {
            }
        }
        DebtsScreenKt.DebtPaySheet$lambda$14(this.$busy$delegate, false);
        return Unit.INSTANCE;
    }
}
