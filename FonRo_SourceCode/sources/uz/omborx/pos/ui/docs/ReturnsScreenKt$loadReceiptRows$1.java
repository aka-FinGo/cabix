package uz.FonRo.pos.ui.docs;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReturnsScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.docs.ReturnsScreenKt", f = "ReturnsScreen.kt", i = {0, 1, 1, 1}, l = {433, 440}, m = "loadReceiptRows", n = {"tid", "tid", "direct", "exact"}, nl = {432, 439}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 2)
/* loaded from: classes7.dex */
public final class ReturnsScreenKt$loadReceiptRows$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReturnsScreenKt$loadReceiptRows$1(Continuation<? super ReturnsScreenKt$loadReceiptRows$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loadReceiptRows;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadReceiptRows = ReturnsScreenKt.loadReceiptRows(null, this);
        return loadReceiptRows;
    }
}
