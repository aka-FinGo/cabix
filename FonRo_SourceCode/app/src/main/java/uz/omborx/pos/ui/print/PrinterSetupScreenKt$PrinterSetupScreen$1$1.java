package uz.FonRo.pos.ui.print;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.print.BluetoothPrinter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PrinterSetupScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.ui.print.PrinterSetupScreenKt$PrinterSetupScreen$1$1", f = "PrinterSetupScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes7.dex */
public final class PrinterSetupScreenKt$PrinterSetupScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<List<BluetoothPrinter.Device>> $devices$delegate;
    final /* synthetic */ MutableState<Boolean> $granted$delegate;
    final /* synthetic */ boolean $supported;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrinterSetupScreenKt$PrinterSetupScreen$1$1(boolean z, Context context, MutableState<Boolean> mutableState, MutableState<List<BluetoothPrinter.Device>> mutableState2, Continuation<? super PrinterSetupScreenKt$PrinterSetupScreen$1$1> continuation) {
        super(2, continuation);
        this.$supported = z;
        this.$context = context;
        this.$granted$delegate = mutableState;
        this.$devices$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PrinterSetupScreenKt$PrinterSetupScreen$1$1(this.$supported, this.$context, this.$granted$delegate, this.$devices$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PrinterSetupScreenKt$PrinterSetupScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean PrinterSetupScreen$lambda$14;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        MutableState<List<BluetoothPrinter.Device>> mutableState = this.$devices$delegate;
        PrinterSetupScreen$lambda$14 = PrinterSetupScreenKt.PrinterSetupScreen$lambda$14(this.$granted$delegate);
        mutableState.setValue((PrinterSetupScreen$lambda$14 && this.$supported) ? BluetoothPrinter.INSTANCE.pairedDevices(this.$context) : CollectionsKt.emptyList());
        return Unit.INSTANCE;
    }
}
