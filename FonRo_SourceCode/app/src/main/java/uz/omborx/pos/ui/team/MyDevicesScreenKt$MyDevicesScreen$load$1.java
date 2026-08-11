package uz.FonRo.pos.ui.team;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MyDevicesScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.team.MyDevicesScreenKt", f = "MyDevicesScreen.kt", i = {0, 0, 0, 0}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT}, m = "MyDevicesScreen$load", n = {"loading$delegate", "auth", "devices$delegate", "failed$delegate"}, nl = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
/* loaded from: classes7.dex */
public final class MyDevicesScreenKt$MyDevicesScreen$load$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MyDevicesScreenKt$MyDevicesScreen$load$1(Continuation<? super MyDevicesScreenKt$MyDevicesScreen$load$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object MyDevicesScreen$load;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        MyDevicesScreen$load = MyDevicesScreenKt.MyDevicesScreen$load(null, null, null, null, this);
        return MyDevicesScreen$load;
    }
}
