package uz.FonRo.pos.ui.more;

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
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.data.model.Paywall;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoreScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.more.MoreScreenKt$MoreScreen$1$1$3$1$5$1$1", f = "MoreScreen.kt", i = {}, l = {289}, m = "invokeSuspend", n = {}, nl = {290}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class MoreScreenKt$MoreScreen$1$1$3$1$5$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $billingBusy$delegate;
    final /* synthetic */ Repo $repo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreScreenKt$MoreScreen$1$1$3$1$5$1$1(Repo repo, MutableState<Boolean> mutableState, Continuation<? super MoreScreenKt$MoreScreen$1$1$3$1$5$1$1> continuation) {
        super(2, continuation);
        this.$repo = repo;
        this.$billingBusy$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MoreScreenKt$MoreScreen$1$1$3$1$5$1$1(this.$repo, this.$billingBusy$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MoreScreenKt$MoreScreen$1$1$3$1$5$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = MoreScreenKt.MoreScreen$pullEntitlement(this.$repo, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Paywall paywall = (Paywall) obj;
        MoreScreenKt.MoreScreen$lambda$51(this.$billingBusy$delegate, false);
        if (paywall == null || !paywall.getSubscribed()) {
            Toaster.show$default(Toaster.INSTANCE, LangKt.tx("Оплата ещё не подтверждена. Если только что оплатили — подождите минуту.", new Object[0]), null, null, null, null, 30, null);
        } else {
            Toaster.INSTANCE.ok(LangKt.tx("Премиум активен. Спасибо!", new Object[0]));
        }
        return Unit.INSTANCE;
    }
}
