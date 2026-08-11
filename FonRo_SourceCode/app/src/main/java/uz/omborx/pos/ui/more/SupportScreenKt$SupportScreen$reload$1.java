package uz.FonRo.pos.ui.more;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SupportScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.more.SupportScreenKt", f = "SupportScreen.kt", i = {0, 0, 0, 0}, l = {102}, m = "SupportScreen$reload", n = {"messages$delegate", "error$delegate", "repo", "loaded$delegate"}, nl = {103}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
/* loaded from: classes7.dex */
public final class SupportScreenKt$SupportScreen$reload$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SupportScreenKt$SupportScreen$reload$1(Continuation<? super SupportScreenKt$SupportScreen$reload$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object SupportScreen$reload;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        SupportScreen$reload = SupportScreenKt.SupportScreen$reload(null, null, null, null, this);
        return SupportScreen$reload;
    }
}
