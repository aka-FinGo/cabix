package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TapGestureDetector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$2", f = "TapGestureDetector.kt", i = {0, 1}, l = {386, 409}, m = "invokeSuspend", n = {"$this$withTimeout", "$this$withTimeout"}, s = {"L$0", "L$0"})
/* loaded from: classes.dex */
public final class TapGestureDetectorKt$waitForLongPress$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PointerEventPass $pass;
    final /* synthetic */ Ref.ObjectRef<LongPressResult> $result;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapGestureDetectorKt$waitForLongPress$2(PointerEventPass pointerEventPass, Ref.ObjectRef<LongPressResult> objectRef, Continuation<? super TapGestureDetectorKt$waitForLongPress$2> continuation) {
        super(2, continuation);
        this.$pass = pointerEventPass;
        this.$result = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TapGestureDetectorKt$waitForLongPress$2 tapGestureDetectorKt$waitForLongPress$2 = new TapGestureDetectorKt$waitForLongPress$2(this.$pass, this.$result, continuation);
        tapGestureDetectorKt$waitForLongPress$2.L$0 = obj;
        return tapGestureDetectorKt$waitForLongPress$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((TapGestureDetectorKt$waitForLongPress$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x00cd, code lost:
    
        r13.$result.element = androidx.compose.foundation.gestures.LongPressResult.Canceled.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00f3, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
    
        if (androidx.compose.foundation.gestures.TapGestureDetector_androidKt.isDeepPress(r14) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0066, code lost:
    
        r13.$result.element = androidx.compose.foundation.gestures.LongPressResult.Success.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006e, code lost:
    
        r14 = r14.getChanges();
        r5 = r14.size();
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007a, code lost:
    
        if (r6 >= r5) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        r7 = r14.get(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0086, code lost:
    
        if (r7.isConsumed() != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0094, code lost:
    
        if (androidx.compose.ui.input.pointer.PointerEventKt.m5552isOutOfBoundsjwHxaWs(r7, r1.mo5516getSizeYbymL2g(), r1.mo5515getExtendedTouchPaddingNHjbRc()) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0097, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009a, code lost:
    
        r13.$result.element = androidx.compose.foundation.gestures.LongPressResult.Canceled.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a1, code lost:
    
        r13.L$0 = r1;
        r13.label = 2;
        r14 = r1.awaitPointerEvent(androidx.compose.ui.input.pointer.PointerEventPass.Final, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ae, code lost:
    
        if (r14 != r0) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00de A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, androidx.compose.foundation.gestures.LongPressResult$Released] */
    /* JADX WARN: Type inference failed for: r14v11, types: [T, androidx.compose.foundation.gestures.LongPressResult$Canceled] */
    /* JADX WARN: Type inference failed for: r14v12, types: [androidx.compose.foundation.gestures.LongPressResult$Success, T] */
    /* JADX WARN: Type inference failed for: r14v19, types: [T, androidx.compose.foundation.gestures.LongPressResult$Canceled] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00ae -> B:6:0x00b1). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
