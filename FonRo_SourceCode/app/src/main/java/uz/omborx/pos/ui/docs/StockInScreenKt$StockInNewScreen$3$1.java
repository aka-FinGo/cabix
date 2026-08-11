package uz.FonRo.pos.ui.docs;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
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
import uz.FonRo.pos.data.model.SyncData;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StockInScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.docs.StockInScreenKt$StockInNewScreen$3$1", f = "StockInScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class StockInScreenKt$StockInNewScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $invoice$delegate;
    final /* synthetic */ MutableState<Boolean> $invoiceEdited$delegate;
    final /* synthetic */ State<SyncData> $sync$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StockInScreenKt$StockInNewScreen$3$1(MutableState<Boolean> mutableState, State<SyncData> state, MutableState<String> mutableState2, Continuation<? super StockInScreenKt$StockInNewScreen$3$1> continuation) {
        super(2, continuation);
        this.$invoiceEdited$delegate = mutableState;
        this.$sync$delegate = state;
        this.$invoice$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StockInScreenKt$StockInNewScreen$3$1(this.$invoiceEdited$delegate, this.$sync$delegate, this.$invoice$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StockInScreenKt$StockInNewScreen$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean StockInNewScreen$lambda$13;
        SyncData StockInNewScreen$lambda$5;
        String nextInvoiceNumber;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            StockInNewScreen$lambda$13 = StockInScreenKt.StockInNewScreen$lambda$13(this.$invoiceEdited$delegate);
            if (!StockInNewScreen$lambda$13) {
                MutableState<String> mutableState = this.$invoice$delegate;
                StockInNewScreen$lambda$5 = StockInScreenKt.StockInNewScreen$lambda$5(this.$sync$delegate);
                nextInvoiceNumber = StockInScreenKt.nextInvoiceNumber(StockInNewScreen$lambda$5);
                mutableState.setValue(nextInvoiceNumber);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
