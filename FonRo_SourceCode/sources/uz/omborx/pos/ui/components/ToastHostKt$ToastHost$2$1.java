package uz.FonRo.pos.ui.components;

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
import kotlinx.coroutines.DelayKt;
import uz.FonRo.pos.ui.Toaster;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ToastHost.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.components.ToastHostKt$ToastHost$2$1", f = "ToastHost.kt", i = {0}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m = "invokeSuspend", n = {"message"}, nl = {56}, s = {"L$0"}, v = 2)
/* loaded from: classes7.dex */
public final class ToastHostKt$ToastHost$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Toaster.Message> $current$delegate;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToastHostKt$ToastHost$2$1(MutableState<Toaster.Message> mutableState, Continuation<? super ToastHostKt$ToastHost$2$1> continuation) {
        super(2, continuation);
        this.$current$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ToastHostKt$ToastHost$2$1(this.$current$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ToastHostKt$ToastHost$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Toaster.Message ToastHost$lambda$1;
        Toaster.Message message;
        Toaster.Message ToastHost$lambda$12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ToastHost$lambda$1 = ToastHostKt.ToastHost$lambda$1(this.$current$delegate);
            if (ToastHost$lambda$1 == null) {
                return Unit.INSTANCE;
            }
            this.L$0 = ToastHost$lambda$1;
            this.label = 1;
            if (DelayKt.delay(ToastHost$lambda$1.getDurationMs(), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            message = ToastHost$lambda$1;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            message = (Toaster.Message) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        ToastHost$lambda$12 = ToastHostKt.ToastHost$lambda$1(this.$current$delegate);
        if (ToastHost$lambda$12 != null && ToastHost$lambda$12.getId() == message.getId()) {
            this.$current$delegate.setValue(null);
        }
        return Unit.INSTANCE;
    }
}
