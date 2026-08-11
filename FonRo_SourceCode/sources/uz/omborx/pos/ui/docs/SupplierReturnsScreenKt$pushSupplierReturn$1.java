package uz.FonRo.pos.ui.docs;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SupplierReturnsScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt", f = "SupplierReturnsScreen.kt", i = {0}, l = {375}, m = "pushSupplierReturn", n = {"doc"}, nl = {374}, s = {"L$0"}, v = 2)
/* loaded from: classes7.dex */
public final class SupplierReturnsScreenKt$pushSupplierReturn$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SupplierReturnsScreenKt$pushSupplierReturn$1(Continuation<? super SupplierReturnsScreenKt$pushSupplierReturn$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object pushSupplierReturn;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        pushSupplierReturn = SupplierReturnsScreenKt.pushSupplierReturn(null, this);
        return pushSupplierReturn;
    }
}
