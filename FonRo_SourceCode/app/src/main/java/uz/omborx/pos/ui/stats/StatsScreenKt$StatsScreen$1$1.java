package uz.FonRo.pos.ui.stats;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.SaleRow;
import uz.FonRo.pos.data.model.StoreStats;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.components.PeriodState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StatsScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.stats.StatsScreenKt$StatsScreen$1$1", f = "StatsScreen.kt", i = {0, 0, 0, 1, 1, 1, 1, 1}, l = {181, 197}, m = "invokeSuspend", n = {"$this$LaunchedEffect", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "$this$LaunchedEffect", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "loaded", "$this$invokeSuspend_u24lambda_u240"}, nl = {194, 197}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
/* loaded from: classes7.dex */
public final class StatsScreenKt$StatsScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $failure$delegate;
    final /* synthetic */ MutableState<Boolean> $loading$delegate;
    final /* synthetic */ PeriodState $period;
    final /* synthetic */ Repo $repo;
    final /* synthetic */ MutableState<List<SaleRow>> $rows$delegate;
    final /* synthetic */ MutableState<StoreStats> $stats$delegate;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatsScreenKt$StatsScreen$1$1(PeriodState periodState, Repo repo, MutableState<Boolean> mutableState, MutableState<String> mutableState2, MutableState<StoreStats> mutableState3, MutableState<List<SaleRow>> mutableState4, Continuation<? super StatsScreenKt$StatsScreen$1$1> continuation) {
        super(2, continuation);
        this.$period = periodState;
        this.$repo = repo;
        this.$loading$delegate = mutableState;
        this.$failure$delegate = mutableState2;
        this.$stats$delegate = mutableState3;
        this.$rows$delegate = mutableState4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StatsScreenKt$StatsScreen$1$1 statsScreenKt$StatsScreen$1$1 = new StatsScreenKt$StatsScreen$1$1(this.$period, this.$repo, this.$loading$delegate, this.$failure$delegate, this.$stats$delegate, this.$rows$delegate, continuation);
        statsScreenKt$StatsScreen$1$1.L$0 = obj;
        return statsScreenKt$StatsScreen$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StatsScreenKt$StatsScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00dc, code lost:
    
        if (uz.FonRo.pos.data.repo.Repo.loadDirectory$default(r8, false, r10, 1, null) == r1) goto L25;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.stats.StatsScreenKt$StatsScreen$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
