package uz.FonRo.pos.ui.docs;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.data.model.SaleRow;
import uz.FonRo.pos.ui.Toaster;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReturnsScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.docs.ReturnsScreenKt$ReturnFormSheet$find$1", f = "ReturnsScreen.kt", i = {}, l = {482}, m = "invokeSuspend", n = {}, nl = {483}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class ReturnsScreenKt$ReturnFormSheet$find$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $number;
    final /* synthetic */ MutableState<Map<Long, Double>> $qty$delegate;
    final /* synthetic */ MutableState<List<SaleRow>> $rows$delegate;
    final /* synthetic */ MutableState<Boolean> $searched$delegate;
    final /* synthetic */ MutableState<Boolean> $searching$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReturnsScreenKt$ReturnFormSheet$find$1(String str, MutableState<List<SaleRow>> mutableState, MutableState<Map<Long, Double>> mutableState2, MutableState<Boolean> mutableState3, MutableState<Boolean> mutableState4, Continuation<? super ReturnsScreenKt$ReturnFormSheet$find$1> continuation) {
        super(2, continuation);
        this.$number = str;
        this.$rows$delegate = mutableState;
        this.$qty$delegate = mutableState2;
        this.$searched$delegate = mutableState3;
        this.$searching$delegate = mutableState4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReturnsScreenKt$ReturnFormSheet$find$1(this.$number, this.$rows$delegate, this.$qty$delegate, this.$searched$delegate, this.$searching$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ReturnsScreenKt$ReturnFormSheet$find$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = ReturnsScreenKt.loadReceiptRows(this.$number, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            List list = (List) obj;
            this.$rows$delegate.setValue(list);
            this.$qty$delegate.setValue(MapsKt.emptyMap());
            ReturnsScreenKt.ReturnFormSheet$lambda$17(this.$searched$delegate, true);
            if (list.isEmpty()) {
                Toaster.INSTANCE.error(LangKt.tx("Чек не найден. Проверьте номер.", new Object[0]));
            }
        } catch (Throwable th) {
            try {
                Toaster.INSTANCE.error(th);
            } catch (Throwable th2) {
                ReturnsScreenKt.ReturnFormSheet$lambda$14(this.$searching$delegate, false);
                throw th2;
            }
        }
        ReturnsScreenKt.ReturnFormSheet$lambda$14(this.$searching$delegate, false);
        return Unit.INSTANCE;
    }
}
