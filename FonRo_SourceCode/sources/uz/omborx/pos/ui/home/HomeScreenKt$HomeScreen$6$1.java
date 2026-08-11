package uz.FonRo.pos.ui.home;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.StoreStats;
import uz.FonRo.pos.data.repo.Repo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.home.HomeScreenKt$HomeScreen$6$1", f = "HomeScreen.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class HomeScreenKt$HomeScreen$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $canStats;
    final /* synthetic */ MutableState<Double> $debtToday$delegate;
    final /* synthetic */ MutableState<Double> $paid$delegate;
    final /* synthetic */ Repo $repo;
    final /* synthetic */ MutableState<StoreStats> $today$delegate;
    final /* synthetic */ MutableState<StoreStats> $week$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeScreenKt$HomeScreen$6$1(boolean z, Repo repo, MutableState<StoreStats> mutableState, MutableState<StoreStats> mutableState2, MutableState<Double> mutableState3, MutableState<Double> mutableState4, Continuation<? super HomeScreenKt$HomeScreen$6$1> continuation) {
        super(2, continuation);
        this.$canStats = z;
        this.$repo = repo;
        this.$today$delegate = mutableState;
        this.$week$delegate = mutableState2;
        this.$paid$delegate = mutableState3;
        this.$debtToday$delegate = mutableState4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeScreenKt$HomeScreen$6$1(this.$canStats, this.$repo, this.$today$delegate, this.$week$delegate, this.$paid$delegate, this.$debtToday$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeScreenKt$HomeScreen$6$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object HomeScreen$load;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            HomeScreen$load = HomeScreenKt.HomeScreen$load(this.$canStats, this.$repo, this.$today$delegate, this.$week$delegate, this.$paid$delegate, this.$debtToday$delegate, this);
            if (HomeScreen$load == coroutine_suspended) {
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
