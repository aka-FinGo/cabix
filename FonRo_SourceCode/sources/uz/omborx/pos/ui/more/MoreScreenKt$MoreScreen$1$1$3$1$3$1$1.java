package uz.FonRo.pos.ui.more;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.data.model.CodeBody;
import uz.FonRo.pos.data.model.Coupon;
import uz.FonRo.pos.data.model.CouponResponse;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.ui.Toaster;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoreScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.more.MoreScreenKt$MoreScreen$1$1$3$1$3$1$1", f = "MoreScreen.kt", i = {}, l = {268}, m = "invokeSuspend", n = {}, nl = {267}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class MoreScreenKt$MoreScreen$1$1$3$1$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $billingBusy$delegate;
    final /* synthetic */ String $code;
    final /* synthetic */ MutableState<Coupon> $coupon$delegate;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreScreenKt$MoreScreen$1$1$3$1$3$1$1(String str, MutableState<Coupon> mutableState, MutableState<Boolean> mutableState2, Continuation<? super MoreScreenKt$MoreScreen$1$1$3$1$3$1$1> continuation) {
        super(2, continuation);
        this.$code = str;
        this.$coupon$delegate = mutableState;
        this.$billingBusy$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MoreScreenKt$MoreScreen$1$1$3$1$3$1$1(this.$code, this.$coupon$delegate, this.$billingBusy$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MoreScreenKt$MoreScreen$1$1$3$1$3$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                Object checkCoupon = ApiClient.INSTANCE.api().checkCoupon(new CodeBody(this.$code), this);
                if (checkCoupon == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apiClient = apiClient2;
                obj = checkCoupon;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                apiClient = (ApiClient) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            Coupon coupon = ((CouponResponse) ApiClient.unwrap$default(apiClient, (Response) obj, false, 2, null)).getCoupon();
            if (coupon == null) {
                Toaster.INSTANCE.error(LangKt.tx("Промокод не найден", new Object[0]));
            } else {
                this.$coupon$delegate.setValue(coupon);
                Toaster.INSTANCE.ok(LangKt.tx("Промокод применён: −%s%%", Fmt.INSTANCE.nf(Boxing.boxDouble(coupon.getPercent()))));
            }
        } finally {
            try {
                MoreScreenKt.MoreScreen$lambda$51(this.$billingBusy$delegate, false);
                return Unit.INSTANCE;
            } catch (Throwable th) {
            }
        }
        MoreScreenKt.MoreScreen$lambda$51(this.$billingBusy$delegate, false);
        return Unit.INSTANCE;
    }
}
