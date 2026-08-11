package uz.FonRo.pos.ui.print;

import android.content.Context;
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
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.print.ReceiptDoc;
import uz.FonRo.pos.print.ReceiptPrinter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PrinterSetupScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.print.PrinterSetupScreenKt$PrinterSetupScreen$2$6$1$1$1", f = "PrinterSetupScreen.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, nl = {242}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class PrinterSetupScreenKt$PrinterSetupScreen$2$6$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FonRoApp $app;
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    final /* synthetic */ Context $context;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrinterSetupScreenKt$PrinterSetupScreen$2$6$1$1$1(Context context, FonRoApp FonRoApp, MutableState<Boolean> mutableState, Continuation<? super PrinterSetupScreenKt$PrinterSetupScreen$2$6$1$1$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$app = FonRoApp;
        this.$busy$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PrinterSetupScreenKt$PrinterSetupScreen$2$6$1$1$1(this.$context, this.$app, this.$busy$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PrinterSetupScreenKt$PrinterSetupScreen$2$6$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4, types: [kotlin.Unit, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ReceiptDoc sampleReceipt;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ReceiptPrinter receiptPrinter = ReceiptPrinter.INSTANCE;
                Context context = this.$context;
                FonRoApp FonRoApp = this.$app;
                sampleReceipt = PrinterSetupScreenKt.sampleReceipt(FonRoApp);
                this.label = 1;
                if (receiptPrinter.printSaleReceipt(context, FonRoApp, sampleReceipt, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            PrinterSetupScreenKt.PrinterSetupScreen$lambda$21(this.$busy$delegate, false);
            this = Unit.INSTANCE;
            return this;
        } catch (Throwable th) {
            PrinterSetupScreenKt.PrinterSetupScreen$lambda$21(this.$busy$delegate, false);
            throw th;
        }
    }
}
