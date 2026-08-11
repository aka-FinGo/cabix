package uz.FonRo.pos.print;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.location.LocationRequestCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReceiptPrinter.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.print.ReceiptPrinter", f = "ReceiptPrinter.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {96, 114, 117, 128}, m = "printLabels", n = {"context", "app", "labels", "layout", "context", "app", "labels", "layout", "prefs", "mac", "widthMm", "context", "app", "labels", "layout", "prefs", "mac", "bytes", "widthMm", "context", "app", "labels", "layout", "prefs", "mac", "grid", "widthMm"}, nl = {LocationRequestCompat.QUALITY_LOW_POWER, 117, 118, 136}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"}, v = 2)
/* loaded from: classes5.dex */
public final class ReceiptPrinter$printLabels$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReceiptPrinter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReceiptPrinter$printLabels$1(ReceiptPrinter receiptPrinter, Continuation<? super ReceiptPrinter$printLabels$1> continuation) {
        super(continuation);
        this.this$0 = receiptPrinter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.printLabels(null, null, null, null, this);
    }
}
