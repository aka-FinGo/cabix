package uz.FonRo.pos.print;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BluetoothPrinter.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "uz.FonRo.pos.print.BluetoothPrinter$print$2", f = "BluetoothPrinter.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {119, 123}, m = "invokeSuspend", n = {"$this$withContext", "adapter", "socket", "device", "stream", TypedValues.CycleType.S_WAVE_OFFSET, "size", "$this$withContext", "adapter", "socket", "device", "stream", TypedValues.CycleType.S_WAVE_OFFSET}, nl = {123, 124}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 2)
/* loaded from: classes5.dex */
public final class BluetoothPrinter$print$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ byte[] $bytes;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $mac;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BluetoothPrinter$print$2(Context context, String str, byte[] bArr, Continuation<? super BluetoothPrinter$print$2> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$mac = str;
        this.$bytes = bArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BluetoothPrinter$print$2 bluetoothPrinter$print$2 = new BluetoothPrinter$print$2(this.$context, this.$mac, this.$bytes, continuation);
        bluetoothPrinter$print$2.L$0 = obj;
        return bluetoothPrinter$print$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<Unit>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return ((BluetoothPrinter$print$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0187, code lost:
    
        r1.L$0 = r2;
        r1.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12);
        r1.L$2 = r10;
        r1.L$3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11);
        r1.L$4 = r9;
        r1.I$0 = r0;
        r1.I$1 = r13;
        r1.label = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01a8, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(30, r1) != r3) goto L65;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0248 A[Catch: all -> 0x01ef, TRY_LEAVE, TryCatch #8 {all -> 0x01ef, blocks: (B:10:0x01dc, B:12:0x01e4, B:13:0x01eb, B:30:0x0219, B:32:0x0221, B:22:0x0240, B:24:0x0248), top: B:2:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0221 A[Catch: all -> 0x01ef, TRY_LEAVE, TryCatch #8 {all -> 0x01ef, blocks: (B:10:0x01dc, B:12:0x01e4, B:13:0x01eb, B:30:0x0219, B:32:0x0221, B:22:0x0240, B:24:0x0248), top: B:2:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0171 A[Catch: all -> 0x01fa, SecurityException -> 0x01fd, CancellationException -> 0x01ff, TryCatch #9 {SecurityException -> 0x01fd, CancellationException -> 0x01ff, all -> 0x01fa, blocks: (B:42:0x016c, B:44:0x0171, B:47:0x0187, B:53:0x01ad, B:81:0x00f1, B:83:0x00f7, B:95:0x0132, B:98:0x0150, B:101:0x0147), top: B:80:0x00f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01ad A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v25, types: [android.bluetooth.BluetoothSocket, T] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, kotlinx.coroutines.CoroutineScope, kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x01a8 -> B:40:0x01ab). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.print.BluetoothPrinter$print$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
