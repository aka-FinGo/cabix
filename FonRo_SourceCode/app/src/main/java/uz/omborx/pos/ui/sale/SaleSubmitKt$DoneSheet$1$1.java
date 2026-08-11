package uz.FonRo.pos.ui.sale;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.print.ReceiptDoc;
import uz.FonRo.pos.print.ReceiptPrinter;
import uz.FonRo.pos.ui.Toaster;
import uz.FonRo.pos.work.BackgroundWork;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SaleSubmit.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.sale.SaleSubmitKt$DoneSheet$1$1", f = "SaleSubmit.kt", i = {0, 0}, l = {194}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "$this$invokeSuspend_u24lambda_u240"}, nl = {195}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes7.dex */
public final class SaleSubmitKt$DoneSheet$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FonRoApp $app;
    final /* synthetic */ Context $context;
    final /* synthetic */ SaleDone $done;
    final /* synthetic */ Repo $repo;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleSubmitKt$DoneSheet$1$1(SaleDone saleDone, Context context, Repo repo, FonRoApp FonRoApp, Continuation<? super SaleSubmitKt$DoneSheet$1$1> continuation) {
        super(2, continuation);
        this.$done = saleDone;
        this.$context = context;
        this.$repo = repo;
        this.$app = FonRoApp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SaleSubmitKt$DoneSheet$1$1 saleSubmitKt$DoneSheet$1$1 = new SaleSubmitKt$DoneSheet$1$1(this.$done, this.$context, this.$repo, this.$app, continuation);
        saleSubmitKt$DoneSheet$1$1.L$0 = obj;
        return saleSubmitKt$DoneSheet$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SaleSubmitKt$DoneSheet$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m7870constructorimpl;
        ReceiptDoc buildReceipt;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$done.getQueued()) {
                BackgroundWork.INSTANCE.flushNow(this.$context);
            }
            if (this.$repo.getPrefs().getAutoPrint()) {
                Context context = this.$context;
                FonRoApp FonRoApp = this.$app;
                SaleDone saleDone = this.$done;
                Result.Companion companion2 = Result.INSTANCE;
                ReceiptPrinter receiptPrinter = ReceiptPrinter.INSTANCE;
                buildReceipt = SaleSubmitKt.buildReceipt(FonRoApp, saleDone);
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.label = 1;
                if (receiptPrinter.printSaleReceipt(context, FonRoApp, buildReceipt, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        m7870constructorimpl = Result.m7870constructorimpl(Unit.INSTANCE);
        Throwable m7873exceptionOrNullimpl = Result.m7873exceptionOrNullimpl(m7870constructorimpl);
        if (m7873exceptionOrNullimpl != null) {
            Toaster.INSTANCE.error(m7873exceptionOrNullimpl);
        }
        return Unit.INSTANCE;
    }
}
