package uz.FonRo.pos.print;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReceiptPrinter.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.print.ReceiptPrinter", f = "ReceiptPrinter.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG, ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE, 56, 64}, m = "printSaleReceipt", n = {"context", "app", "doc", "prefs", "store", "widthMm", "context", "app", "doc", "prefs", "store", "blocks", "mac", "widthMm", "context", "app", "doc", "prefs", "store", "blocks", "mac", "bytes", "widthMm", "context", "app", "doc", "prefs", "store", "blocks", "mac", "widthMm"}, nl = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF, 56, 57, 74}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"}, v = 2)
/* loaded from: classes5.dex */
public final class ReceiptPrinter$printSaleReceipt$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReceiptPrinter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReceiptPrinter$printSaleReceipt$1(ReceiptPrinter receiptPrinter, Continuation<? super ReceiptPrinter$printSaleReceipt$1> continuation) {
        super(continuation);
        this.this$0 = receiptPrinter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.printSaleReceipt(null, null, null, this);
    }
}
