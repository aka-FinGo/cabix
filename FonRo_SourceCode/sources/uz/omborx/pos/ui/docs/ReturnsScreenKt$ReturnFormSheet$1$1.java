package uz.FonRo.pos.ui.docs;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.data.model.SaleRow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReturnsScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.docs.ReturnsScreenKt$ReturnFormSheet$1$1", f = "ReturnsScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class ReturnsScreenKt$ReturnFormSheet$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $initialTid;
    final /* synthetic */ MutableState<Map<Long, Double>> $qty$delegate;
    final /* synthetic */ MutableState<List<SaleRow>> $rows$delegate;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ MutableState<Boolean> $searched$delegate;
    final /* synthetic */ MutableState<Boolean> $searching$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReturnsScreenKt$ReturnFormSheet$1$1(String str, CoroutineScope coroutineScope, MutableState<Boolean> mutableState, MutableState<List<SaleRow>> mutableState2, MutableState<Map<Long, Double>> mutableState3, MutableState<Boolean> mutableState4, Continuation<? super ReturnsScreenKt$ReturnFormSheet$1$1> continuation) {
        super(2, continuation);
        this.$initialTid = str;
        this.$scope = coroutineScope;
        this.$searching$delegate = mutableState;
        this.$rows$delegate = mutableState2;
        this.$qty$delegate = mutableState3;
        this.$searched$delegate = mutableState4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReturnsScreenKt$ReturnFormSheet$1$1(this.$initialTid, this.$scope, this.$searching$delegate, this.$rows$delegate, this.$qty$delegate, this.$searched$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ReturnsScreenKt$ReturnFormSheet$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String str = this.$initialTid;
        if (str != null) {
            if (StringsKt.isBlank(str)) {
                str = null;
            }
            String str2 = str;
            if (str2 != null) {
                ReturnsScreenKt.ReturnFormSheet$find(this.$scope, this.$searching$delegate, this.$rows$delegate, this.$qty$delegate, this.$searched$delegate, str2);
            }
        }
        return Unit.INSTANCE;
    }
}
