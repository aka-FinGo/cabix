package uz.FonRo.pos.ui.docs;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.Supplier;
import uz.FonRo.pos.data.repo.Repo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StockInScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.docs.StockInScreenKt$StockInNewScreen$save$1", f = "StockInScreen.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {616, 626, 627}, m = "invokeSuspend", n = {"$this$launch", "body", "$this$launch", "body", "data", "rejected", "$this$invokeSuspend_u24lambda_u241", "$this$launch", "body", "data", "rejected", "$this$invokeSuspend_u24lambda_u242"}, nl = {617, 626, 627}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
/* loaded from: classes7.dex */
public final class StockInScreenKt$StockInNewScreen$save$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    final /* synthetic */ Function0<Unit> $closePage;
    final /* synthetic */ MutableState<String> $invoice$delegate;
    final /* synthetic */ MutableState<Boolean> $invoiceEdited$delegate;
    final /* synthetic */ MutableState<List<StockInLine>> $lines$delegate;
    final /* synthetic */ MutableState<String> $note$delegate;
    final /* synthetic */ MutableState<Double> $paid$delegate;
    final /* synthetic */ Repo $repo;
    final /* synthetic */ MutableState<Supplier> $supplier$delegate;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StockInScreenKt$StockInNewScreen$save$1(Repo repo, Function0<Unit> function0, MutableState<Supplier> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<Double> mutableState4, MutableState<List<StockInLine>> mutableState5, MutableState<Boolean> mutableState6, MutableState<Boolean> mutableState7, Continuation<? super StockInScreenKt$StockInNewScreen$save$1> continuation) {
        super(2, continuation);
        this.$repo = repo;
        this.$closePage = function0;
        this.$supplier$delegate = mutableState;
        this.$invoice$delegate = mutableState2;
        this.$note$delegate = mutableState3;
        this.$paid$delegate = mutableState4;
        this.$lines$delegate = mutableState5;
        this.$invoiceEdited$delegate = mutableState6;
        this.$busy$delegate = mutableState7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StockInScreenKt$StockInNewScreen$save$1 stockInScreenKt$StockInNewScreen$save$1 = new StockInScreenKt$StockInNewScreen$save$1(this.$repo, this.$closePage, this.$supplier$delegate, this.$invoice$delegate, this.$note$delegate, this.$paid$delegate, this.$lines$delegate, this.$invoiceEdited$delegate, this.$busy$delegate, continuation);
        stockInScreenKt$StockInNewScreen$save$1.L$0 = obj;
        return stockInScreenKt$StockInNewScreen$save$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StockInScreenKt$StockInNewScreen$save$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x01d1, code lost:
    
        if (r0.loadDirectory(true, r30) != r3) goto L50;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r31) {
        /*
            Method dump skipped, instructions count: 545
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.StockInScreenKt$StockInNewScreen$save$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
