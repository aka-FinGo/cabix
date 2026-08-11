package uz.FonRo.pos.ui.more;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.data.repo.SaleRepository;
import uz.FonRo.pos.ui.Toaster;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OutboxScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.more.OutboxScreenKt$OutboxScreen$1$1$1$1$1$1", f = "OutboxScreen.kt", i = {0, 0}, l = {122}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240"}, nl = {122}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes7.dex */
public final class OutboxScreenKt$OutboxScreen$1$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FonRoApp $app;
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutboxScreenKt$OutboxScreen$1$1$1$1$1$1(FonRoApp FonRoApp, MutableState<Boolean> mutableState, Continuation<? super OutboxScreenKt$OutboxScreen$1$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$app = FonRoApp;
        this.$busy$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OutboxScreenKt$OutboxScreen$1$1$1$1$1$1 outboxScreenKt$OutboxScreen$1$1$1$1$1$1 = new OutboxScreenKt$OutboxScreen$1$1$1$1$1$1(this.$app, this.$busy$delegate, continuation);
        outboxScreenKt$OutboxScreen$1$1$1$1$1$1.L$0 = obj;
        return outboxScreenKt$OutboxScreen$1$1$1$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OutboxScreenKt$OutboxScreen$1$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m7870constructorimpl;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FonRoApp FonRoApp = this.$app;
                Result.Companion companion = Result.INSTANCE;
                SaleRepository sales = FonRoApp.getSales();
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.label = 1;
                obj = sales.flushOutbox(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            m7870constructorimpl = Result.m7870constructorimpl(Boxing.boxInt(((Number) obj).intValue()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        Integer boxInt = Boxing.boxInt(0);
        if (Result.m7876isFailureimpl(m7870constructorimpl)) {
            m7870constructorimpl = boxInt;
        }
        int intValue = ((Number) m7870constructorimpl).intValue();
        OutboxScreenKt.OutboxScreen$lambda$3(this.$busy$delegate, false);
        if (intValue > 0) {
            Toaster.INSTANCE.ok(LangKt.tx("Отправлено: ", new Object[0]) + Fmt.INSTANCE.plural(intValue, LangKt.tx("чек", new Object[0]), LangKt.tx("чека", new Object[0]), LangKt.tx("чеков", new Object[0])));
        } else {
            Toaster.show$default(Toaster.INSTANCE, LangKt.tx("Пока не получилось. Чеки останутся в очереди и уйдут сами, как только появится связь.", new Object[0]), null, null, null, null, 30, null);
        }
        return Unit.INSTANCE;
    }
}
