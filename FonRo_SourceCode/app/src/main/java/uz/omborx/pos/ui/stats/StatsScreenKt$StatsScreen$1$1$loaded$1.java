package uz.FonRo.pos.ui.stats;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import uz.FonRo.pos.data.model.SaleRow;
import uz.FonRo.pos.data.model.StoreStats;

/* compiled from: StatsScreen.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Luz/FonRo/pos/data/model/StoreStats;", "", "Luz/FonRo/pos/data/model/SaleRow;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.stats.StatsScreenKt$StatsScreen$1$1$loaded$1", f = "StatsScreen.kt", i = {0, 0, 0, 1, 1, 1}, l = {192, 192}, m = "invokeSuspend", n = {"$this$coroutineScope", "statsJob", "historyJob", "$this$coroutineScope", "statsJob", "historyJob"}, nl = {192, -1}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 2)
/* loaded from: classes7.dex */
final class StatsScreenKt$StatsScreen$1$1$loaded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends StoreStats, ? extends List<? extends SaleRow>>>, Object> {
    final /* synthetic */ String $from;
    final /* synthetic */ String $to;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatsScreenKt$StatsScreen$1$1$loaded$1(String str, String str2, Continuation<? super StatsScreenKt$StatsScreen$1$1$loaded$1> continuation) {
        super(2, continuation);
        this.$from = str;
        this.$to = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StatsScreenKt$StatsScreen$1$1$loaded$1 statsScreenKt$StatsScreen$1$1$loaded$1 = new StatsScreenKt$StatsScreen$1$1$loaded$1(this.$from, this.$to, continuation);
        statsScreenKt$StatsScreen$1$1$loaded$1.L$0 = obj;
        return statsScreenKt$StatsScreen$1$1$loaded$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends StoreStats, ? extends List<? extends SaleRow>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<StoreStats, ? extends List<SaleRow>>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<StoreStats, ? extends List<SaleRow>>> continuation) {
        return ((StatsScreenKt$StatsScreen$1$1$loaded$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Deferred async$default;
        Deferred async$default2;
        Deferred deferred;
        Object obj2;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new StatsScreenKt$StatsScreen$1$1$loaded$1$statsJob$1(this.$from, this.$to, null), 3, null);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new StatsScreenKt$StatsScreen$1$1$loaded$1$historyJob$1(this.$from, this.$to, null), 3, null);
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(async$default);
            this.L$2 = async$default2;
            this.label = 1;
            Object await = async$default.await(this);
            if (await != coroutine_suspended) {
                deferred = async$default;
                obj = await;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj2 = this.L$3;
            ResultKt.throwOnFailure(obj);
            return TuplesKt.to(obj2, obj);
        }
        async$default2 = (Deferred) this.L$2;
        deferred = (Deferred) this.L$1;
        ResultKt.throwOnFailure(obj);
        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
        this.L$1 = SpillingKt.nullOutSpilledVariable(deferred);
        this.L$2 = SpillingKt.nullOutSpilledVariable(async$default2);
        this.L$3 = obj;
        this.label = 2;
        Object await2 = async$default2.await(this);
        if (await2 != coroutine_suspended) {
            obj2 = obj;
            obj = await2;
            return TuplesKt.to(obj2, obj);
        }
        return coroutine_suspended;
    }
}
