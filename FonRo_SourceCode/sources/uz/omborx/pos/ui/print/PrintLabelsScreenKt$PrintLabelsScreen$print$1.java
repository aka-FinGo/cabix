package uz.FonRo.pos.ui.print;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
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
import uz.FonRo.pos.print.LabelDoc;
import uz.FonRo.pos.print.LabelLayout;
import uz.FonRo.pos.print.ReceiptPrinter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PrintLabelsScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.print.PrintLabelsScreenKt$PrintLabelsScreen$print$1", f = "PrintLabelsScreen.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, nl = {198}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class PrintLabelsScreenKt$PrintLabelsScreen$print$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FonRoApp $app;
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    final /* synthetic */ Context $context;
    final /* synthetic */ List<LabelDoc> $docs;
    final /* synthetic */ MutableState<LabelLayout> $layout$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrintLabelsScreenKt$PrintLabelsScreen$print$1(Context context, FonRoApp FonRoApp, List<LabelDoc> list, MutableState<LabelLayout> mutableState, MutableState<Boolean> mutableState2, Continuation<? super PrintLabelsScreenKt$PrintLabelsScreen$print$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$app = FonRoApp;
        this.$docs = list;
        this.$layout$delegate = mutableState;
        this.$busy$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PrintLabelsScreenKt$PrintLabelsScreen$print$1(this.$context, this.$app, this.$docs, this.$layout$delegate, this.$busy$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PrintLabelsScreenKt$PrintLabelsScreen$print$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v4, types: [kotlin.Unit, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LabelLayout PrintLabelsScreen$lambda$16;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ReceiptPrinter receiptPrinter = ReceiptPrinter.INSTANCE;
                Context context = this.$context;
                FonRoApp FonRoApp = this.$app;
                List<LabelDoc> list = this.$docs;
                PrintLabelsScreen$lambda$16 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$16(this.$layout$delegate);
                this.label = 1;
                if (receiptPrinter.printLabels(context, FonRoApp, list, PrintLabelsScreen$lambda$16, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            PrintLabelsScreenKt.PrintLabelsScreen$lambda$41(this.$busy$delegate, false);
            this = Unit.INSTANCE;
            return this;
        } catch (Throwable th) {
            PrintLabelsScreenKt.PrintLabelsScreen$lambda$41(this.$busy$delegate, false);
            throw th;
        }
    }
}
