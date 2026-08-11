package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DragGestureDetector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$9", f = "DragGestureDetector.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7}, l = {245, 251, 1061, 1101, 278, 1148, 1190, 1202}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "initialDown", "awaitTouchSlop", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w_u24default$iv", "pointer$iv", "touchSlopDetector$iv", "touchSlop$iv", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w_u24default$iv", "pointer$iv", "touchSlopDetector$iv", "dragEvent$iv", "touchSlop$iv", "$this$awaitEachGesture", "down", "drag", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w$iv", "pointer$iv", "touchSlopDetector$iv", "touchSlop$iv", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w$iv", "pointer$iv", "touchSlopDetector$iv", "dragEvent$iv", "touchSlop$iv", "$this$drag_u2dVnAYq1g$iv", "orientation$iv", "$this$awaitDragOrUp_u2djO51t88$iv$iv", "pointer$iv$iv"}, s = {"L$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "L$4", "L$5", "F$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "F$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$4", "L$5", "F$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "F$0", "L$0", "L$2", "L$3", "L$4"})
/* loaded from: classes.dex */
public final class DragGestureDetectorKt$detectDragGestures$9 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function1<PointerInputChange, Unit> $onDragEnd;
    final /* synthetic */ Function3<PointerInputChange, PointerInputChange, Offset, Unit> $onDragStart;
    final /* synthetic */ Orientation $orientationLock;
    final /* synthetic */ Ref.LongRef $overSlop;
    final /* synthetic */ Function0<Boolean> $shouldAwaitTouchSlop;
    float F$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DragGestureDetectorKt$detectDragGestures$9(Function0<Boolean> function0, Ref.LongRef longRef, Orientation orientation, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function02, Function1<? super PointerInputChange, Unit> function1, Continuation<? super DragGestureDetectorKt$detectDragGestures$9> continuation) {
        super(2, continuation);
        this.$shouldAwaitTouchSlop = function0;
        this.$overSlop = longRef;
        this.$orientationLock = orientation;
        this.$onDragStart = function3;
        this.$onDrag = function2;
        this.$onDragCancel = function02;
        this.$onDragEnd = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectDragGestures$9 dragGestureDetectorKt$detectDragGestures$9 = new DragGestureDetectorKt$detectDragGestures$9(this.$shouldAwaitTouchSlop, this.$overSlop, this.$orientationLock, this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, continuation);
        dragGestureDetectorKt$detectDragGestures$9.L$0 = obj;
        return dragGestureDetectorKt$detectDragGestures$9;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectDragGestures$9) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x03cc, code lost:
    
        if (r6 != r1) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x04cd, code lost:
    
        if (androidx.compose.foundation.gestures.DragGestureDetectorKt.m758isPointerUpDmW0f2w(r10.getCurrentEvent(), r2) != false) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x01e9, code lost:
    
        if (r11 == r1) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0184, code lost:
    
        if (r4 == r1) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x0158, code lost:
    
        if (r3 == r1) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x04fa, code lost:
    
        if (r7 != r1) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0588, code lost:
    
        if (r9 == false) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0307, code lost:
    
        if (r5 == r1) goto L170;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000b. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:35:0x0534, B:48:0x0562], limit reached: 221 */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x05a6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02dd  */
    /* JADX WARN: Type inference failed for: r9v10, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:103:0x0403 -> B:62:0x048b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x040b -> B:62:0x048b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:0x0437 -> B:62:0x048b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:116:0x0491 -> B:95:0x03b1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:122:0x045a -> B:64:0x02c5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:126:0x0483 -> B:60:0x0485). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:130:0x0498 -> B:64:0x02c5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:149:0x01b7 -> B:143:0x02ac). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:160:0x0226 -> B:142:0x02ab). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:180:0x0277 -> B:143:0x02ac). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:184:0x02a2 -> B:139:0x02a4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x04fa -> B:7:0x04fd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x033f -> B:72:0x02ec). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x0397 -> B:63:0x048d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            Method dump skipped, instructions count: 1502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$9.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
