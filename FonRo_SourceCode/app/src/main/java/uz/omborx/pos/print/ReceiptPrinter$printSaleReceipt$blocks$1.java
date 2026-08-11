package uz.FonRo.pos.print;

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
import uz.FonRo.pos.data.model.Store;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReceiptPrinter.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Luz/FonRo/pos/print/ReceiptBlock;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.print.ReceiptPrinter$printSaleReceipt$blocks$1", f = "ReceiptPrinter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes5.dex */
public final class ReceiptPrinter$printSaleReceipt$blocks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends ReceiptBlock>>, Object> {
    final /* synthetic */ ReceiptDoc $doc;
    final /* synthetic */ Store $store;
    final /* synthetic */ int $widthMm;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReceiptPrinter$printSaleReceipt$blocks$1(ReceiptDoc receiptDoc, int i, Store store, Continuation<? super ReceiptPrinter$printSaleReceipt$blocks$1> continuation) {
        super(2, continuation);
        this.$doc = receiptDoc;
        this.$widthMm = i;
        this.$store = store;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReceiptPrinter$printSaleReceipt$blocks$1(this.$doc, this.$widthMm, this.$store, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends ReceiptBlock>> continuation) {
        return ((ReceiptPrinter$printSaleReceipt$blocks$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return ReceiptBuilder.INSTANCE.layout(this.$doc, this.$widthMm, this.$store);
    }
}
