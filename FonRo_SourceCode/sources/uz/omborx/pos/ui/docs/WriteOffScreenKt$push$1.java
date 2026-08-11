package uz.FonRo.pos.ui.docs;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WriteOffScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.docs.WriteOffScreenKt", f = "WriteOffScreen.kt", i = {0}, l = {329}, m = "push", n = {"doc"}, nl = {330}, s = {"L$0"}, v = 2)
/* loaded from: classes7.dex */
public final class WriteOffScreenKt$push$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WriteOffScreenKt$push$1(Continuation<? super WriteOffScreenKt$push$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object push;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        push = WriteOffScreenKt.push(null, this);
        return push;
    }
}
