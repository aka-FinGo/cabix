package uz.FonRo.pos.ui.more;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MoreScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.more.MoreScreenKt", f = "MoreScreen.kt", i = {0}, l = {190}, m = "MoreScreen$pullEntitlement", n = {"repo"}, nl = {190}, s = {"L$0"}, v = 2)
/* loaded from: classes7.dex */
public final class MoreScreenKt$MoreScreen$pullEntitlement$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MoreScreenKt$MoreScreen$pullEntitlement$1(Continuation<? super MoreScreenKt$MoreScreen$pullEntitlement$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object MoreScreen$pullEntitlement;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        MoreScreen$pullEntitlement = MoreScreenKt.MoreScreen$pullEntitlement(null, this);
        return MoreScreen$pullEntitlement;
    }
}
