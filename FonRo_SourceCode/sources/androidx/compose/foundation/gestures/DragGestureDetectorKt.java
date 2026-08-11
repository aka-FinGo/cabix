package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* compiled from: DragGestureDetector.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a$\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0080@¢\u0006\u0002\u0010\r\u001a!\u0010\u000e\u001a\u0004\u0018\u00010\n*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a5\u0010\u0013\u001a\u0004\u0018\u00010\n*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u0015H\u0082Hø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a!\u0010\u0018\u001a\u0004\u0018\u00010\n*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0012\u001aa\u0010\u001a\u001a\u0004\u0018\u00010\n*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c26\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#0\u001eH\u0080@ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001aY\u0010&\u001a\u0004\u0018\u00010\n*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u001026\u0010'\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#0\u001eH\u0086@ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a!\u0010*\u001a\u0004\u0018\u00010\n*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0004\b+\u0010\u0012\u001aW\u0010,\u001a\u0004\u0018\u00010\n*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010-\u001a\u0004\u0018\u00010.2\b\b\u0002\u0010\t\u001a\u00020/2\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020#0\u001eH\u0080Hø\u0001\u0000¢\u0006\u0004\b0\u00101\u001aY\u00102\u001a\u0004\u0018\u00010\n*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u001026\u0010'\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110/¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#0\u001eH\u0086@ø\u0001\u0000¢\u0006\u0004\b3\u0010)\u001a!\u00104\u001a\u0004\u0018\u00010\n*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0004\b5\u0010\u0012\u001aa\u00106\u001a\u0004\u0018\u00010\n*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c26\u0010'\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#0\u001eH\u0080@ø\u0001\u0000¢\u0006\u0004\b7\u0010%\u001aY\u00108\u001a\u0004\u0018\u00010\n*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u001026\u0010'\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#0\u001eH\u0086@ø\u0001\u0000¢\u0006\u0004\b9\u0010)\u001a\u0080\u0001\u0010:\u001a\u00020#*\u00020;2\u0014\b\u0002\u0010<\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020#0\u00152\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020#0>2\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020#0>26\u0010@\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110/¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(A\u0012\u0004\u0012\u00020#0\u001eH\u0086@¢\u0006\u0002\u0010B\u001aà\u0001\u0010:\u001a\u00020#*\u00020;2K\u0010<\u001aG\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(D\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(E\u0012\u0013\u0012\u00110/¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(F\u0012\u0004\u0012\u00020#0C2!\u0010=\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020#0\u00152\f\u0010?\u001a\b\u0012\u0004\u0012\u00020#0>2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00070>2\b\u0010H\u001a\u0004\u0018\u00010.26\u0010@\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110/¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(A\u0012\u0004\u0012\u00020#0\u001eH\u0080@¢\u0006\u0002\u0010I\u001a\u0080\u0001\u0010J\u001a\u00020#*\u00020;2\u0014\b\u0002\u0010<\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020#0\u00152\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020#0>2\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020#0>26\u0010@\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110/¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(A\u0012\u0004\u0012\u00020#0\u001eH\u0086@¢\u0006\u0002\u0010B\u001a\u0080\u0001\u0010K\u001a\u00020#*\u00020;2\u0014\b\u0002\u0010<\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020#0\u00152\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020#0>2\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020#0>26\u0010L\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(A\u0012\u0004\u0012\u00020#0\u001eH\u0086@¢\u0006\u0002\u0010B\u001a\u0080\u0001\u0010M\u001a\u00020#*\u00020;2\u0014\b\u0002\u0010<\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020#0\u00152\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020#0>2\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020#0>26\u0010N\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(A\u0012\u0004\u0012\u00020#0\u001eH\u0086@¢\u0006\u0002\u0010B\u001a3\u0010O\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020#0\u0015H\u0086@ø\u0001\u0000¢\u0006\u0004\bP\u0010\u0017\u001aS\u0010O\u001a\u0004\u0018\u00010\n*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020#0\u00152\b\u0010-\u001a\u0004\u0018\u00010.2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u0015H\u0080Hø\u0001\u0000¢\u0006\u0004\bR\u0010S\u001a3\u0010T\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020#0\u0015H\u0086@ø\u0001\u0000¢\u0006\u0004\bU\u0010\u0017\u001a\u001e\u0010V\u001a\u00020\u0007*\u00020W2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\bX\u0010Y\u001a\u001e\u0010Z\u001a\u00020\u0005*\u00020[2\u0006\u0010\u001b\u001a\u00020\u001cH\u0000ø\u0001\u0000¢\u0006\u0004\b\\\u0010]\u001a3\u0010^\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020#0\u0015H\u0086@ø\u0001\u0000¢\u0006\u0004\b_\u0010\u0017\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006`"}, d2 = {"defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", "F", "mouseSlop", "mouseToTouchSlopRatio", "", "awaitAllPointersUpWithSlopDetection", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "initialPositionChange", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrCancellation", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "awaitDragOrCancellation-rnUCldI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrUp", "hasDragged", "Lkotlin/Function1;", "awaitDragOrUp-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalDragOrCancellation", "awaitHorizontalDragOrCancellation-rnUCldI", "awaitHorizontalPointerSlopOrCancellation", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalTouchSlopOrCancellation", "onTouchSlopReached", "awaitHorizontalTouchSlopOrCancellation-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLongPressOrCancellation", "awaitLongPressOrCancellation-rnUCldI", "awaitPointerSlopOrCancellation", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-6ksA65w", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILandroidx/compose/foundation/gestures/Orientation;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitTouchSlopOrCancellation", "awaitTouchSlopOrCancellation-jO51t88", "awaitVerticalDragOrCancellation", "awaitVerticalDragOrCancellation-rnUCldI", "awaitVerticalPointerSlopOrCancellation", "awaitVerticalPointerSlopOrCancellation-gDDlDlE", "awaitVerticalTouchSlopOrCancellation", "awaitVerticalTouchSlopOrCancellation-jO51t88", "detectDragGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDragStart", "onDragEnd", "Lkotlin/Function0;", "onDragCancel", "onDrag", "dragAmount", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function3;", "down", "slopTriggerChange", "overSlopOffset", "shouldAwaitTouchSlop", "orientationLock", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGesturesAfterLongPress", "detectHorizontalDragGestures", "onHorizontalDrag", "detectVerticalDragGestures", "onVerticalDrag", "drag", "drag-jO51t88", "motionConsumed", "drag-VnAYq1g", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "horizontalDrag", "horizontalDrag-jO51t88", "isPointerUp", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "verticalDrag", "verticalDrag-jO51t88", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DragGestureDetectorKt {
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    /* JADX WARN: Removed duplicated region for block: B:13:0x018a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x017e -> B:11:0x0184). Please report as a decompilation issue!!! */
    /* renamed from: awaitTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m750awaitTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r22, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r23) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m750awaitTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x004a -> B:10:0x004d). Please report as a decompilation issue!!! */
    /* renamed from: drag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m756dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r4, long r5, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            if (r0 == 0) goto L14
            r0 = r8
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            kotlin.ResultKt.throwOnFailure(r8)
            r7 = r4
            r4 = r5
            goto L4d
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            kotlin.ResultKt.throwOnFailure(r8)
        L40:
            r0.L$0 = r4
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = m741awaitDragOrCancellationrnUCldI(r4, r5, r0)
            if (r8 != r1) goto L4d
            return r1
        L4d:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L57
            r4 = 0
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        L57:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r8)
            if (r5 == 0) goto L62
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r4
        L62:
            r7.invoke(r8)
            long r5 = r8.getId()
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m756dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d2, code lost:
    
        if (androidx.compose.ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r11) != false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0096 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0069 -> B:10:0x006e). Please report as a decompilation issue!!! */
    /* renamed from: awaitDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m741awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m741awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object detectDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$2
                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m761invokek4lQ0M(long j) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m761invokek4lQ0M(offset.m4135unboximpl());
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function02;
        return detectDragGestures(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, final Function1<? super Offset, Unit> function1, final Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object detectDragGestures = detectDragGestures(pointerInputScope, new Function3<PointerInputChange, PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, Offset offset) {
                m762invoke0AR0LA0(pointerInputChange, pointerInputChange2, offset.m4135unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-0AR0LA0, reason: not valid java name */
            public final void m762invoke0AR0LA0(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, long j) {
                function1.invoke(Offset.m4114boximpl(pointerInputChange2.getPosition()));
            }
        }, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$6
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange) {
                invoke2(pointerInputChange);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PointerInputChange pointerInputChange) {
                function0.invoke();
            }
        }, function02, new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return true;
            }
        }, null, function2, continuation);
        return detectDragGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectDragGestures : Unit.INSTANCE;
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function1<? super PointerInputChange, Unit> function1, Function0<Unit> function0, Function0<Boolean> function02, Orientation orientation, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectDragGestures$9(function02, new Ref.LongRef(), orientation, function3, function2, function0, function1, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectDragGesturesAfterLongPress$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$2
                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m763invokek4lQ0M(long j) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m763invokek4lQ0M(offset.m4135unboximpl());
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function02;
        return detectDragGesturesAfterLongPress(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    public static final Object detectDragGesturesAfterLongPress(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(function1, function0, function02, function2, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0195 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0189 -> B:11:0x018f). Please report as a decompilation issue!!! */
    /* renamed from: awaitVerticalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m753awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r21, long r22, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r24, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r25) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m753awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x018f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0183 -> B:11:0x0189). Please report as a decompilation issue!!! */
    /* renamed from: awaitVerticalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m752awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r21, long r22, int r24, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r25, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r26) {
        /*
            Method dump skipped, instructions count: 407
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m752awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0119, code lost:
    
        if ((r0 == 0.0f) == false) goto L59;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0085 -> B:10:0x008b). Please report as a decompilation issue!!! */
    /* renamed from: verticalDrag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m760verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r20, kotlin.coroutines.Continuation<? super java.lang.Boolean> r21) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m760verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e3, code lost:
    
        if ((java.lang.Float.intBitsToFloat((int) (androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11) & 4294967295L)) == 0.0f ? 1 : 0) == 0) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0096 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0069 -> B:10:0x006e). Please report as a decompilation issue!!! */
    /* renamed from: awaitVerticalDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m751awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m751awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object detectVerticalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$2
                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m765invokek4lQ0M(long j) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m765invokek4lQ0M(offset.m4135unboximpl());
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function02;
        return detectVerticalDragGestures(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    public static final Object detectVerticalDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectVerticalDragGestures$5(function1, function2, function0, function02, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0192 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0186 -> B:11:0x018c). Please report as a decompilation issue!!! */
    /* renamed from: awaitHorizontalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m745awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r21, long r22, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r24, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r25) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m745awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x018c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0180 -> B:11:0x0186). Please report as a decompilation issue!!! */
    /* renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m744awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r21, long r22, int r24, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r25, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r26) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m744awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0119, code lost:
    
        if ((r0 == 0.0f) == false) goto L59;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0085 -> B:10:0x008b). Please report as a decompilation issue!!! */
    /* renamed from: horizontalDrag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m757horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r20, kotlin.coroutines.Continuation<? super java.lang.Boolean> r21) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m757horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e0, code lost:
    
        if ((java.lang.Float.intBitsToFloat((int) (androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11) >> 32)) == 0.0f ? 1 : 0) == 0) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0096 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0069 -> B:10:0x006e). Please report as a decompilation issue!!! */
    /* renamed from: awaitHorizontalDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m743awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m743awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object detectHorizontalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$2
                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m764invokek4lQ0M(long j) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m764invokek4lQ0M(offset.m4135unboximpl());
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function02;
        return detectHorizontalDragGestures(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    public static final Object detectHorizontalDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectHorizontalDragGestures$5(function1, function2, function0, function02, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x012d, code lost:
    
        if ((r0 == 0.0f) == false) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x008f -> B:10:0x0095). Please report as a decompilation issue!!! */
    /* renamed from: drag-VnAYq1g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m754dragVnAYq1g(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r22, androidx.compose.foundation.gestures.Orientation r23, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Boolean> r24, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r25) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m754dragVnAYq1g(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, androidx.compose.foundation.gestures.Orientation, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: drag-VnAYq1g$$forInline, reason: not valid java name */
    private static final Object m755dragVnAYq1g$$forInline(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Orientation orientation, Function1<? super PointerInputChange, Boolean> function12, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        long j2 = j;
        if (m758isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j2)) {
            return null;
        }
        while (true) {
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = j2;
            while (true) {
                PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        pointerInputChange = null;
                        break;
                    }
                    pointerInputChange = changes.get(i);
                    if (Boolean.valueOf(PointerId.m5589equalsimpl0(pointerInputChange.getId(), longRef.element)).booleanValue()) {
                        break;
                    }
                    i++;
                }
                pointerInputChange2 = pointerInputChange;
                if (pointerInputChange2 == null) {
                    pointerInputChange2 = null;
                    break;
                }
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (r9 >= size2) {
                            pointerInputChange3 = null;
                            break;
                        }
                        pointerInputChange3 = changes2.get(r9);
                        if (Boolean.valueOf(pointerInputChange3.getPressed()).booleanValue()) {
                            break;
                        }
                        r9++;
                    }
                    PointerInputChange pointerInputChange4 = pointerInputChange3;
                    if (pointerInputChange4 == null) {
                        break;
                    }
                    longRef.element = pointerInputChange4.getId();
                } else {
                    long positionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange2);
                    if (Boolean.valueOf(1 ^ ((orientation == null ? Offset.m4123getDistanceimpl(positionChangeIgnoreConsumed) : orientation == Orientation.Vertical ? Float.intBitsToFloat((int) (positionChangeIgnoreConsumed & 4294967295L)) : Float.intBitsToFloat((int) (positionChangeIgnoreConsumed >> 32))) == 0.0f ? 1 : 0)).booleanValue()) {
                        break;
                    }
                }
            }
            if (pointerInputChange2 == null || function12.invoke(pointerInputChange2).booleanValue()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                return pointerInputChange2;
            }
            function1.invoke(pointerInputChange2);
            j2 = pointerInputChange2.getId();
        }
    }

    /* renamed from: awaitDragOrUp-jO51t88, reason: not valid java name */
    private static final Object m742awaitDragOrUpjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Boolean> function1, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = j;
        while (true) {
            PointerInputChange pointerInputChange3 = null;
            PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                if (Boolean.valueOf(PointerId.m5589equalsimpl0(pointerInputChange.getId(), longRef.element)).booleanValue()) {
                    break;
                }
                i2++;
            }
            pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 == null) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i >= size2) {
                        break;
                    }
                    PointerInputChange pointerInputChange4 = changes2.get(i);
                    if (Boolean.valueOf(pointerInputChange4.getPressed()).booleanValue()) {
                        pointerInputChange3 = pointerInputChange4;
                        break;
                    }
                    i++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange3;
                if (pointerInputChange5 == null) {
                    break;
                }
                longRef.element = pointerInputChange5.getId();
            } else if (function1.invoke(pointerInputChange2).booleanValue()) {
                break;
            }
        }
        return pointerInputChange2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0187 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x017b -> B:11:0x0181). Please report as a decompilation issue!!! */
    /* renamed from: awaitPointerSlopOrCancellation-6ksA65w, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m747awaitPointerSlopOrCancellation6ksA65w(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, int r22, androidx.compose.foundation.gestures.Orientation r23, long r24, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r26, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r27) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m747awaitPointerSlopOrCancellation6ksA65w(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, androidx.compose.foundation.gestures.Orientation, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: awaitPointerSlopOrCancellation-6ksA65w$default, reason: not valid java name */
    public static /* synthetic */ Object m749awaitPointerSlopOrCancellation6ksA65w$default(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Orientation orientation, long j2, Function2 function2, Continuation continuation, int i2, Object obj) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if ((i2 & 8) != 0) {
            j2 = Offset.INSTANCE.m4141getZeroF1C5BW0();
        }
        if (m758isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        float m759pointerSlopE8SPZFQ = m759pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
        TouchSlopDetector touchSlopDetector = new TouchSlopDetector(orientation, j2, null);
        while (true) {
            PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i4);
                if (PointerId.m5589equalsimpl0(pointerInputChange.getId(), j)) {
                    break;
                }
                i4++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null || pointerInputChange3.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i3 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i3);
                    if (pointerInputChange2.getPressed()) {
                        break;
                    }
                    i3++;
                }
                PointerInputChange pointerInputChange4 = pointerInputChange2;
                if (pointerInputChange4 == null) {
                    return null;
                }
                j = pointerInputChange4.getId();
            } else {
                long m845addPointerInputChangedBAh8RU = touchSlopDetector.m845addPointerInputChangedBAh8RU(pointerInputChange3, m759pointerSlopE8SPZFQ);
                if ((9223372034707292159L & m845addPointerInputChangedBAh8RU) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    function2.invoke(pointerInputChange3, Offset.m4114boximpl(m845addPointerInputChangedBAh8RU));
                    if (pointerInputChange3.isConsumed()) {
                        return pointerInputChange3;
                    }
                    touchSlopDetector.reset();
                } else {
                    awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Final, continuation);
                    if (pointerInputChange3.isConsumed()) {
                        break;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: awaitPointerSlopOrCancellation-6ksA65w$$forInline, reason: not valid java name */
    private static final Object m748awaitPointerSlopOrCancellation6ksA65w$$forInline(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Orientation orientation, long j2, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (m758isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        float m759pointerSlopE8SPZFQ = m759pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = j;
        TouchSlopDetector touchSlopDetector = new TouchSlopDetector(orientation, j2, null);
        while (true) {
            PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i3);
                if (Boolean.valueOf(PointerId.m5589equalsimpl0(pointerInputChange.getId(), longRef.element)).booleanValue()) {
                    break;
                }
                i3++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null || pointerInputChange3.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i2 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i2);
                    if (Boolean.valueOf(pointerInputChange2.getPressed()).booleanValue()) {
                        break;
                    }
                    i2++;
                }
                PointerInputChange pointerInputChange4 = pointerInputChange2;
                if (pointerInputChange4 == null) {
                    return null;
                }
                longRef.element = pointerInputChange4.getId();
            } else {
                long m845addPointerInputChangedBAh8RU = touchSlopDetector.m845addPointerInputChangedBAh8RU(pointerInputChange3, m759pointerSlopE8SPZFQ);
                if ((9223372034707292159L & m845addPointerInputChangedBAh8RU) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    function2.invoke(pointerInputChange3, Offset.m4114boximpl(m845addPointerInputChangedBAh8RU));
                    if (pointerInputChange3.isConsumed()) {
                        return pointerInputChange3;
                    }
                    touchSlopDetector.reset();
                } else {
                    awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Final, continuation);
                    if (pointerInputChange3.isConsumed()) {
                        break;
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0114 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00a0 -> B:10:0x00a5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object awaitAllPointersUpWithSlopDetection(androidx.compose.ui.input.pointer.AwaitPointerEventScope r18, androidx.compose.ui.input.pointer.PointerInputChange r19, androidx.compose.ui.input.pointer.PointerEventPass r20, kotlin.coroutines.Continuation<? super java.lang.Boolean> r21) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitAllPointersUpWithSlopDetection(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object awaitAllPointersUpWithSlopDetection$default(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return awaitAllPointersUpWithSlopDetection(awaitPointerEventScope, pointerInputChange, pointerEventPass, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00b1 A[Catch: PointerEventTimeoutCancellationException -> 0x00ba, TRY_LEAVE, TryCatch #0 {PointerEventTimeoutCancellationException -> 0x00ba, blocks: (B:11:0x0033, B:12:0x00ad, B:14:0x00b1, B:36:0x0091), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r10v3, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r11v3, types: [androidx.compose.ui.input.pointer.PointerInputChange, T, java.lang.Object] */
    /* renamed from: awaitLongPressOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m746awaitLongPressOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r9, long r10, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1
            r0.<init>(r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L41
            if (r2 != r3) goto L38
            java.lang.Object r9 = r0.L$2
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r10 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r0.L$0
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lba
            goto Lad
        L38:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L41:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.compose.ui.input.pointer.PointerEvent r12 = r9.getCurrentEvent()
            boolean r12 = m758isPointerUpDmW0f2w(r12, r10)
            if (r12 == 0) goto L4f
            return r4
        L4f:
            androidx.compose.ui.input.pointer.PointerEvent r12 = r9.getCurrentEvent()
            java.util.List r12 = r12.getChanges()
            r2 = r12
            java.util.Collection r2 = (java.util.Collection) r2
            int r2 = r2.size()
            r5 = 0
        L5f:
            if (r5 >= r2) goto L76
            java.lang.Object r6 = r12.get(r5)
            r7 = r6
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            long r7 = r7.getId()
            boolean r7 = androidx.compose.ui.input.pointer.PointerId.m5589equalsimpl0(r7, r10)
            if (r7 == 0) goto L73
            goto L77
        L73:
            int r5 = r5 + 1
            goto L5f
        L76:
            r6 = r4
        L77:
            r11 = r6
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            if (r11 != 0) goto L7d
            return r4
        L7d:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r12 = new kotlin.jvm.internal.Ref$ObjectRef
            r12.<init>()
            r12.element = r11
            androidx.compose.ui.platform.ViewConfiguration r2 = r9.getViewConfiguration()
            long r5 = r2.getLongPressTimeoutMillis()
            kotlin.jvm.internal.Ref$BooleanRef r2 = new kotlin.jvm.internal.Ref$BooleanRef     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lba
            r2.<init>()     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lba
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2 r7 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lba
            r7.<init>(r2, r12, r10, r4)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lba
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lba
            r0.L$0 = r11     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lba
            r0.L$1 = r10     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lba
            r0.L$2 = r2     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lba
            r0.label = r3     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lba
            java.lang.Object r9 = r9.withTimeout(r5, r7, r0)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lba
            if (r9 != r1) goto Lac
            return r1
        Lac:
            r9 = r2
        Lad:
            boolean r9 = r9.element     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lba
            if (r9 == 0) goto Lb9
            T r9 = r10.element     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lba
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lba
            if (r9 != 0) goto Lb8
            return r11
        Lb8:
            return r9
        Lb9:
            return r4
        Lba:
            T r9 = r10.element
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 != 0) goto Lc1
            goto Lc2
        Lc1:
            r11 = r9
        Lc2:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m746awaitLongPressOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    public static final boolean m758isPointerUpDmW0f2w(PointerEvent pointerEvent, long j) {
        PointerInputChange pointerInputChange;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i);
            if (PointerId.m5589equalsimpl0(pointerInputChange.getId(), j)) {
                break;
            }
            i++;
        }
        PointerInputChange pointerInputChange2 = pointerInputChange;
        if (pointerInputChange2 != null && pointerInputChange2.getPressed()) {
            z = true;
        }
        return true ^ z;
    }

    /* renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m759pointerSlopE8SPZFQ(ViewConfiguration viewConfiguration, int i) {
        return PointerType.m5678equalsimpl0(i, PointerType.INSTANCE.m5683getMouseT8wyACA()) ? viewConfiguration.getTouchSlop() * mouseToTouchSlopRatio : viewConfiguration.getTouchSlop();
    }

    static {
        float m6989constructorimpl = Dp.m6989constructorimpl(0.125f);
        mouseSlop = m6989constructorimpl;
        float m6989constructorimpl2 = Dp.m6989constructorimpl(18.0f);
        defaultTouchSlop = m6989constructorimpl2;
        mouseToTouchSlopRatio = m6989constructorimpl / m6989constructorimpl2;
    }
}
