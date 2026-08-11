package uz.FonRo.pos.print;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BluetoothPrinter.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.print.BluetoothPrinter", f = "BluetoothPrinter.kt", i = {0, 0, 0}, l = {79}, m = "print-BWLJW6A", n = {"context", "mac", "bytes"}, nl = {136}, s = {"L$0", "L$1", "L$2"}, v = 2)
/* loaded from: classes5.dex */
public final class BluetoothPrinter$print$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BluetoothPrinter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BluetoothPrinter$print$1(BluetoothPrinter bluetoothPrinter, Continuation<? super BluetoothPrinter$print$1> continuation) {
        super(continuation);
        this.this$0 = bluetoothPrinter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m9748printBWLJW6A = this.this$0.m9748printBWLJW6A(null, null, null, this);
        return m9748printBWLJW6A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m9748printBWLJW6A : Result.m7869boximpl(m9748printBWLJW6A);
    }
}
