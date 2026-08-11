package uz.FonRo.pos.ui.team;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TeamScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.team.TeamScreenKt", f = "TeamScreen.kt", i = {0, 0, 0, 0, 0}, l = {350}, m = "WorkerCardSheet$loadDevices", n = {"devicesLoading$delegate", "$app", "$worker", "devices$delegate", "isOwner"}, nl = {350}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
/* loaded from: classes7.dex */
public final class TeamScreenKt$WorkerCardSheet$loadDevices$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TeamScreenKt$WorkerCardSheet$loadDevices$1(Continuation<? super TeamScreenKt$WorkerCardSheet$loadDevices$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object WorkerCardSheet$loadDevices;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        WorkerCardSheet$loadDevices = TeamScreenKt.WorkerCardSheet$loadDevices(false, null, null, null, null, this);
        return WorkerCardSheet$loadDevices;
    }
}
