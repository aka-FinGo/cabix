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
import uz.FonRo.pos.data.model.Worker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TeamScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.team.TeamScreenKt$TeamScreen$3$3$1$1", f = "TeamScreen.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class TeamScreenKt$TeamScreen$3$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Worker> $cardWorker$delegate;
    final /* synthetic */ MutableState<Boolean> $failed$delegate;
    final /* synthetic */ MutableState<Boolean> $loading$delegate;
    final /* synthetic */ MutableState<List<Worker>> $workers$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TeamScreenKt$TeamScreen$3$3$1$1(MutableState<Boolean> mutableState, MutableState<List<Worker>> mutableState2, MutableState<Boolean> mutableState3, MutableState<Worker> mutableState4, Continuation<? super TeamScreenKt$TeamScreen$3$3$1$1> continuation) {
        super(2, continuation);
        this.$loading$delegate = mutableState;
        this.$workers$delegate = mutableState2;
        this.$failed$delegate = mutableState3;
        this.$cardWorker$delegate = mutableState4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TeamScreenKt$TeamScreen$3$3$1$1(this.$loading$delegate, this.$workers$delegate, this.$failed$delegate, this.$cardWorker$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TeamScreenKt$TeamScreen$3$3$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object TeamScreen$load;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            TeamScreen$load = TeamScreenKt.TeamScreen$load(this.$loading$delegate, this.$workers$delegate, this.$failed$delegate, this.$cardWorker$delegate, this);
            if (TeamScreen$load == coroutine_suspended) {
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
