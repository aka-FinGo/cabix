package uz.FonRo.pos.ui.home;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.SaleRow;
import uz.FonRo.pos.data.model.StoreStats;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeScreen.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Luz/FonRo/pos/data/model/SaleRow;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.home.HomeScreenKt$HomeScreen$load$3", f = "HomeScreen.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {134, 135, 136}, m = "invokeSuspend", n = {"$this$coroutineScope", "todayJob", "weekJob", "historyJob", "$this$coroutineScope", "todayJob", "weekJob", "historyJob", "$this$coroutineScope", "todayJob", "weekJob", "historyJob"}, nl = {767, 767, 140}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 2)
/* loaded from: classes7.dex */
public final class HomeScreenKt$HomeScreen$load$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends SaleRow>>>, Object> {
    final /* synthetic */ MutableState<Double> $debtToday$delegate;
    final /* synthetic */ MutableState<Double> $paid$delegate;
    final /* synthetic */ MutableState<StoreStats> $today$delegate;
    final /* synthetic */ MutableState<StoreStats> $week$delegate;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeScreenKt$HomeScreen$load$3(MutableState<StoreStats> mutableState, MutableState<StoreStats> mutableState2, MutableState<Double> mutableState3, MutableState<Double> mutableState4, Continuation<? super HomeScreenKt$HomeScreen$load$3> continuation) {
        super(2, continuation);
        this.$today$delegate = mutableState;
        this.$week$delegate = mutableState2;
        this.$paid$delegate = mutableState3;
        this.$debtToday$delegate = mutableState4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HomeScreenKt$HomeScreen$load$3 homeScreenKt$HomeScreen$load$3 = new HomeScreenKt$HomeScreen$load$3(this.$today$delegate, this.$week$delegate, this.$paid$delegate, this.$debtToday$delegate, continuation);
        homeScreenKt$HomeScreen$load$3.L$0 = obj;
        return homeScreenKt$HomeScreen$load$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends List<? extends SaleRow>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<? extends List<SaleRow>>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<? extends List<SaleRow>>> continuation) {
        return ((HomeScreenKt$HomeScreen$load$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0111, code lost:
    
        if (r13 == r0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00da, code lost:
    
        if (r13 == r0) goto L30;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.home.HomeScreenKt$HomeScreen$load$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
