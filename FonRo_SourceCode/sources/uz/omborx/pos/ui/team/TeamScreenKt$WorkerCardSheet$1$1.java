package uz.FonRo.pos.ui.team;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.data.model.Worker;
import uz.FonRo.pos.data.model.WorkerDevice;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TeamScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.team.TeamScreenKt$WorkerCardSheet$1$1", f = "TeamScreen.kt", i = {}, l = {356}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class TeamScreenKt$WorkerCardSheet$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FonRoApp $app;
    final /* synthetic */ MutableState<List<WorkerDevice>> $devices$delegate;
    final /* synthetic */ MutableState<Boolean> $devicesLoading$delegate;
    final /* synthetic */ boolean $isOwner;
    final /* synthetic */ Worker $worker;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TeamScreenKt$WorkerCardSheet$1$1(boolean z, MutableState<Boolean> mutableState, FonRoApp FonRoApp, Worker worker, MutableState<List<WorkerDevice>> mutableState2, Continuation<? super TeamScreenKt$WorkerCardSheet$1$1> continuation) {
        super(2, continuation);
        this.$isOwner = z;
        this.$devicesLoading$delegate = mutableState;
        this.$app = FonRoApp;
        this.$worker = worker;
        this.$devices$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TeamScreenKt$WorkerCardSheet$1$1(this.$isOwner, this.$devicesLoading$delegate, this.$app, this.$worker, this.$devices$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TeamScreenKt$WorkerCardSheet$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object WorkerCardSheet$loadDevices;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            WorkerCardSheet$loadDevices = TeamScreenKt.WorkerCardSheet$loadDevices(this.$isOwner, this.$devicesLoading$delegate, this.$app, this.$worker, this.$devices$delegate, this);
            if (WorkerCardSheet$loadDevices == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
