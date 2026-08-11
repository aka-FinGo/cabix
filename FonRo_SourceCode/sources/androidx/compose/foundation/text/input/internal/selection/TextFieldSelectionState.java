package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursor_androidKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.MathUtilsKt;
import androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionLayout;
import androidx.compose.foundation.text.selection.SelectionLayoutKt;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.foundation.text.selection.TextSelectionDelegateKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: TextFieldSelectionState.kt */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001:\u0006\u00ad\u0001®\u0001¯\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\rJ\u0006\u0010[\u001a\u00020CJ\u0006\u0010\\\u001a\u00020\tJ\u0006\u0010]\u001a\u00020\tJ\u0006\u0010^\u001a\u00020\tJ\u000e\u0010_\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010`J\u0006\u0010a\u001a\u00020\tJ\u0006\u0010b\u001a\u00020CJ\u0018\u0010c\u001a\u00020C2\b\b\u0002\u0010d\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010eJ\u000e\u0010f\u001a\u00020CH\u0086@¢\u0006\u0002\u0010`J\u0006\u0010g\u001a\u00020CJ\u0006\u0010h\u001a\u00020CJ\b\u0010i\u001a\u00020jH\u0002J\u0015\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\tH\u0000¢\u0006\u0002\bnJ\u0006\u0010o\u001a\u00020jJ\u001d\u0010p\u001a\u00020\u00112\u0006\u0010q\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\br\u0010sJ\u001d\u0010t\u001a\u00020l2\u0006\u0010q\u001a\u00020\t2\u0006\u0010m\u001a\u00020\tH\u0000¢\u0006\u0002\buJ<\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u0002032\u0006\u0010y\u001a\u0002032\b\u0010z\u001a\u0004\u0018\u00010w2\u0006\u0010q\u001a\u00020\t2\u0006\u0010{\u001a\u00020|H\u0002ø\u0001\u0000¢\u0006\u0004\b}\u0010~J\b\u0010\u007f\u001a\u00020CH\u0002J\t\u0010\u0080\u0001\u001a\u00020\tH\u0002J\t\u0010\u0081\u0001\u001a\u00020CH\u0002J\u000f\u0010\u0082\u0001\u001a\u00020CH\u0082@¢\u0006\u0002\u0010`J\u000f\u0010\u0083\u0001\u001a\u00020CH\u0082@¢\u0006\u0002\u0010`J\u000f\u0010\u0084\u0001\u001a\u00020CH\u0086@¢\u0006\u0002\u0010`J\u000f\u0010\u0085\u0001\u001a\u00020CH\u0082@¢\u0006\u0002\u0010`J\u001e\u0010\u0086\u0001\u001a\u00020\t2\u0007\u0010\u0087\u0001\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u0007\u0010\u008a\u0001\u001a\u00020CJ\u000f\u0010\u008b\u0001\u001a\u00020CH\u0086@¢\u0006\u0002\u0010`J@\u0010\u008c\u0001\u001a\u00020C2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u000e\u001a\u00020\u000f2\u0007\u0010\u008d\u0001\u001a\u00020S2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ%\u0010\u008e\u0001\u001a\u00020C2\u0007\u0010\u008f\u0001\u001a\u00020\u001d2\u0007\u0010\u0090\u0001\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001JZ\u0010\u0093\u0001\u001a\u00020w2\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\u0007\u0010\u0096\u0001\u001a\u0002032\u0007\u0010\u0097\u0001\u001a\u0002032\u0006\u0010q\u001a\u00020\t2\u0006\u0010{\u001a\u00020|2\t\b\u0002\u0010\u0098\u0001\u001a\u00020\t2\t\b\u0002\u0010\u0099\u0001\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u000f\u0010\u009c\u0001\u001a\u00020C2\u0006\u0010U\u001a\u00020TJ\u0015\u0010\u009d\u0001\u001a\u00020C*\u00030\u009e\u0001H\u0086@¢\u0006\u0003\u0010\u009f\u0001J\u0015\u0010 \u0001\u001a\u00020C*\u00030\u009e\u0001H\u0082@¢\u0006\u0003\u0010\u009f\u0001J\u001d\u0010¡\u0001\u001a\u00020C*\u00030\u009e\u00012\u0006\u0010q\u001a\u00020\tH\u0082@¢\u0006\u0003\u0010¢\u0001J?\u0010£\u0001\u001a\u00020C*\u00030\u009e\u00012\n\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u00012\r\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020C0<2\r\u0010§\u0001\u001a\b\u0012\u0004\u0012\u00020C0<H\u0086@¢\u0006\u0003\u0010¨\u0001J\u0015\u0010©\u0001\u001a\u00020C*\u00030\u009e\u0001H\u0086@¢\u0006\u0003\u0010\u009f\u0001J\u001d\u0010ª\u0001\u001a\u00020C*\u00030\u009e\u00012\u0006\u0010q\u001a\u00020\tH\u0086@¢\u0006\u0003\u0010¢\u0001J$\u0010«\u0001\u001a\u00020C*\u00030\u009e\u00012\r\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020C0<H\u0086@¢\u0006\u0003\u0010¬\u0001R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR/\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001d8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001c\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010'\u001a\u00020\u00118Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b(\u0010\u0013R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010&\"\u0004\b+\u0010,R+\u0010-\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010\u001c\u001a\u0004\b-\u0010&\"\u0004\b.\u0010,R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R1\u00106\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00118B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b:\u0010\u001c\u001a\u0004\b7\u0010\u0013\"\u0004\b8\u00109R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010=\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010B\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010?\"\u0004\bE\u0010AR+\u0010F\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bI\u0010\u001c\u001a\u0004\bG\u0010&\"\u0004\bH\u0010,R1\u0010J\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00118B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bM\u0010\u001c\u001a\u0004\bK\u0010\u0013\"\u0004\bL\u00109R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010N\u001a\u0004\u0018\u00010O8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010U\u001a\u00020T2\u0006\u0010\u0014\u001a\u00020T8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bZ\u0010\u001c\u001a\u0004\bV\u0010W\"\u0004\bX\u0010Y\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006°\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "density", "Landroidx/compose/ui/unit/Density;", "enabled", "", "readOnly", "isFocused", "isPassword", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/unit/Density;ZZZZ)V", "clipboard", "Landroidx/compose/ui/platform/Clipboard;", "currentTextLayoutPositionInWindow", "Landroidx/compose/ui/geometry/Offset;", "getCurrentTextLayoutPositionInWindow-F1C5BW0", "()J", "<set-?>", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "directDragGestureInitiator", "getDirectDragGestureInitiator", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "setDirectDragGestureInitiator", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;)V", "directDragGestureInitiator$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "editable", "getEditable", "()Z", "handleDragPosition", "getHandleDragPosition-F1C5BW0", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setFocused", "(Z)V", "isInTouchMode", "setInTouchMode", "isInTouchMode$delegate", "pressInteraction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "previousRawDragOffset", "", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "rawHandleDragPosition", "getRawHandleDragPosition-F1C5BW0", "setRawHandleDragPosition-k-4lQ0M", "(J)V", "rawHandleDragPosition$delegate", "receiveContentConfiguration", "Lkotlin/Function0;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "getReceiveContentConfiguration", "()Lkotlin/jvm/functions/Function0;", "setReceiveContentConfiguration", "(Lkotlin/jvm/functions/Function0;)V", "requestAutofillAction", "", "getRequestAutofillAction", "setRequestAutofillAction", "showCursorHandle", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle$delegate", "startTextLayoutPositionInWindow", "getStartTextLayoutPositionInWindow-F1C5BW0", "setStartTextLayoutPositionInWindow-k-4lQ0M", "startTextLayoutPositionInWindow$delegate", "textLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getTextLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "textToolbarHandler", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarHandler;", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "textToolbarState", "getTextToolbarState", "()Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "setTextToolbarState", "(Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;)V", "textToolbarState$delegate", "autofill", "canAutofill", "canCopy", "canCut", "canPaste", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canSelectAll", "clearHandleDragging", "copy", "cancelSelection", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cut", "deselect", "dispose", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getCursorHandleState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "includePosition", "getCursorHandleState$foundation_release", "getCursorRect", "getHandlePosition", "isStartHandle", "getHandlePosition-tuRUvjQ", "(Z)J", "getSelectionHandleState", "getSelectionHandleState$foundation_release", "getTextFieldSelection", "Landroidx/compose/ui/text/TextRange;", "rawStartOffset", "rawEndOffset", "previousSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getTextFieldSelection-qeG_v_k", "(IILandroidx/compose/ui/text/TextRange;ZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)J", "hideTextToolbar", "isCursorHandleInVisibleBounds", "markStartContentVisibleOffset", "observeTextChanges", "observeTextToolbarVisibility", "paste", "pasteAsPlainText", "placeCursorAtNearestOffset", TypedValues.CycleType.S_WAVE_OFFSET, "placeCursorAtNearestOffset-k-4lQ0M", "(J)Z", "selectAll", "startToolbarAndHandlesVisibilityObserver", "update", "showTextToolbar", "updateHandleDragging", "handle", "position", "updateHandleDragging-Uv8p0NA", "(Landroidx/compose/foundation/text/Handle;J)V", "updateSelection", "textFieldCharSequence", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "startOffset", "endOffset", "allowPreviousSelectionCollapsed", "isStartOfSelection", "updateSelection-SsL-Rf8", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;IIZLandroidx/compose/foundation/text/selection/SelectionAdjustment;ZZ)J", "updateTextToolbarState", "cursorHandleGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectCursorHandleDragGestures", "detectSelectionHandleDragGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTextFieldTapGestures", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "requestFocus", "showKeyboard", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTouchMode", "selectionHandleGestures", "textFieldSelectionGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "InputType", "TextFieldMouseSelectionObserver", "TextFieldTextDragObserver", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldSelectionState {
    public static final int $stable = 8;
    private Clipboard clipboard;
    private Density density;

    /* renamed from: directDragGestureInitiator$delegate, reason: from kotlin metadata */
    private final MutableState directDragGestureInitiator;

    /* renamed from: draggingHandle$delegate, reason: from kotlin metadata */
    private final MutableState draggingHandle;
    private boolean enabled;
    private HapticFeedback hapticFeedBack;
    private boolean isFocused;

    /* renamed from: isInTouchMode$delegate, reason: from kotlin metadata */
    private final MutableState isInTouchMode;
    private boolean isPassword;
    private PressInteraction.Press pressInteraction;
    private int previousRawDragOffset;
    private SelectionLayout previousSelectionLayout;

    /* renamed from: rawHandleDragPosition$delegate, reason: from kotlin metadata */
    private final MutableState rawHandleDragPosition;
    private boolean readOnly;
    private Function0<? extends ReceiveContentConfiguration> receiveContentConfiguration;
    private Function0<Unit> requestAutofillAction;

    /* renamed from: showCursorHandle$delegate, reason: from kotlin metadata */
    private final MutableState showCursorHandle;

    /* renamed from: startTextLayoutPositionInWindow$delegate, reason: from kotlin metadata */
    private final MutableState startTextLayoutPositionInWindow;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;
    private TextToolbarHandler textToolbarHandler;

    /* renamed from: textToolbarState$delegate, reason: from kotlin metadata */
    private final MutableState textToolbarState;

    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IndexTransformationType.values().length];
            try {
                iArr[IndexTransformationType.Untransformed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IndexTransformationType.Deletion.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IndexTransformationType.Insertion.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IndexTransformationType.Replacement.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TextFieldSelectionState(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, Density density, boolean z, boolean z2, boolean z3, boolean z4) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        MutableState mutableStateOf$default7;
        this.textFieldState = transformedTextFieldState;
        this.textLayoutState = textLayoutState;
        this.density = density;
        this.enabled = z;
        this.readOnly = z2;
        this.isFocused = z3;
        this.isPassword = z4;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this.isInTouchMode = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m4114boximpl(Offset.INSTANCE.m4140getUnspecifiedF1C5BW0()), null, 2, null);
        this.startTextLayoutPositionInWindow = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m4114boximpl(Offset.INSTANCE.m4140getUnspecifiedF1C5BW0()), null, 2, null);
        this.rawHandleDragPosition = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggingHandle = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(InputType.None, null, 2, null);
        this.directDragGestureInitiator = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.showCursorHandle = mutableStateOf$default6;
        mutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TextToolbarState.None, null, 2, null);
        this.textToolbarState = mutableStateOf$default7;
        this.previousRawDragOffset = -1;
    }

    /* renamed from: isFocused, reason: from getter */
    public final boolean getIsFocused() {
        return this.isFocused;
    }

    public final void setFocused(boolean z) {
        this.isFocused = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isInTouchMode() {
        return ((Boolean) this.isInTouchMode.getValue()).booleanValue();
    }

    public final void setInTouchMode(boolean z) {
        this.isInTouchMode.setValue(Boolean.valueOf(z));
    }

    public final Function0<Unit> getRequestAutofillAction() {
        return this.requestAutofillAction;
    }

    public final void setRequestAutofillAction(Function0<Unit> function0) {
        this.requestAutofillAction = function0;
    }

    public final Function0<ReceiveContentConfiguration> getReceiveContentConfiguration() {
        return this.receiveContentConfiguration;
    }

    public final void setReceiveContentConfiguration(Function0<? extends ReceiveContentConfiguration> function0) {
        this.receiveContentConfiguration = function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getStartTextLayoutPositionInWindow-F1C5BW0, reason: not valid java name */
    private final long m1682getStartTextLayoutPositionInWindowF1C5BW0() {
        return ((Offset) this.startTextLayoutPositionInWindow.getValue()).m4135unboximpl();
    }

    /* renamed from: setStartTextLayoutPositionInWindow-k-4lQ0M, reason: not valid java name */
    private final void m1686setStartTextLayoutPositionInWindowk4lQ0M(long j) {
        this.startTextLayoutPositionInWindow.setValue(Offset.m4114boximpl(j));
    }

    /* renamed from: getCurrentTextLayoutPositionInWindow-F1C5BW0, reason: not valid java name */
    private final long m1679getCurrentTextLayoutPositionInWindowF1C5BW0() {
        LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
        return textLayoutCoordinates != null ? LayoutCoordinatesKt.positionInWindow(textLayoutCoordinates) : Offset.INSTANCE.m4140getUnspecifiedF1C5BW0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getRawHandleDragPosition-F1C5BW0, reason: not valid java name */
    private final long m1681getRawHandleDragPositionF1C5BW0() {
        return ((Offset) this.rawHandleDragPosition.getValue()).m4135unboximpl();
    }

    /* renamed from: setRawHandleDragPosition-k-4lQ0M, reason: not valid java name */
    private final void m1685setRawHandleDragPositionk4lQ0M(long j) {
        this.rawHandleDragPosition.setValue(Offset.m4114boximpl(j));
    }

    /* renamed from: getHandleDragPosition-F1C5BW0, reason: not valid java name */
    public final long m1689getHandleDragPositionF1C5BW0() {
        if ((m1681getRawHandleDragPositionF1C5BW0() & 9223372034707292159L) == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return Offset.INSTANCE.m4140getUnspecifiedF1C5BW0();
        }
        if ((m1682getStartTextLayoutPositionInWindowF1C5BW0() & 9223372034707292159L) == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return TextLayoutStateKt.m1628fromDecorationToTextLayoutUv8p0NA(this.textLayoutState, m1681getRawHandleDragPositionF1C5BW0());
        }
        return Offset.m4130plusMKHz9U(m1681getRawHandleDragPositionF1C5BW0(), Offset.m4129minusMKHz9U(m1682getStartTextLayoutPositionInWindowF1C5BW0(), m1679getCurrentTextLayoutPositionInWindowF1C5BW0()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle.getValue();
    }

    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle.setValue(handle);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "", "(Ljava/lang/String;I)V", "None", "Touch", "Mouse", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class InputType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ InputType[] $VALUES;
        public static final InputType None = new InputType("None", 0);
        public static final InputType Touch = new InputType("Touch", 1);
        public static final InputType Mouse = new InputType("Mouse", 2);

        private static final /* synthetic */ InputType[] $values() {
            return new InputType[]{None, Touch, Mouse};
        }

        public static EnumEntries<InputType> getEntries() {
            return $ENTRIES;
        }

        public static InputType valueOf(String str) {
            return (InputType) Enum.valueOf(InputType.class, str);
        }

        public static InputType[] values() {
            return (InputType[]) $VALUES.clone();
        }

        private InputType(String str, int i) {
        }

        static {
            InputType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final InputType getDirectDragGestureInitiator() {
        return (InputType) this.directDragGestureInitiator.getValue();
    }

    public final void setDirectDragGestureInitiator(InputType inputType) {
        this.directDragGestureInitiator.setValue(inputType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getShowCursorHandle() {
        return ((Boolean) this.showCursorHandle.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setShowCursorHandle(boolean z) {
        this.showCursorHandle.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final TextToolbarState getTextToolbarState() {
        return (TextToolbarState) this.textToolbarState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextToolbarState(TextToolbarState textToolbarState) {
        this.textToolbarState.setValue(textToolbarState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getTextLayoutCoordinates() {
        LayoutCoordinates textLayoutNodeCoordinates = this.textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates == null || !textLayoutNodeCoordinates.isAttached()) {
            return null;
        }
        return textLayoutNodeCoordinates;
    }

    private final boolean getEditable() {
        return this.enabled && !this.readOnly;
    }

    public final TextFieldHandleState getCursorHandleState$foundation_release(boolean includePosition) {
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        boolean showCursorHandle = getShowCursorHandle();
        boolean z = getDirectDragGestureInitiator() == InputType.None;
        Handle draggingHandle = getDraggingHandle();
        if (!showCursorHandle || !z || !TextRange.m6429getCollapsedimpl(visualText.getSelection()) || !visualText.shouldShowSelection() || visualText.length() <= 0 || (draggingHandle != Handle.Cursor && !isCursorHandleInVisibleBounds())) {
            return TextFieldHandleState.INSTANCE.getHidden();
        }
        return new TextFieldHandleState(true, includePosition ? getCursorRect().m4152getBottomCenterF1C5BW0() : Offset.INSTANCE.m4140getUnspecifiedF1C5BW0(), 0.0f, ResolvedTextDirection.Ltr, false, null);
    }

    private final boolean isCursorHandleInVisibleBounds() {
        Rect visibleBounds;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            long m4152getBottomCenterF1C5BW0 = getCursorRect().m4152getBottomCenterF1C5BW0();
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            if (textLayoutCoordinates == null || (visibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) {
                return false;
            }
            return SelectionManagerKt.m1807containsInclusiveUv8p0NA(visibleBounds, m4152getBottomCenterF1C5BW0);
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    public final Rect getCursorRect() {
        float right;
        float rint;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Rect.INSTANCE.getZero();
        }
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        if (!TextRange.m6429getCollapsedimpl(visualText.getSelection())) {
            return Rect.INSTANCE.getZero();
        }
        Rect cursorRect = layoutResult.getCursorRect(TextRange.m6435getStartimpl(visualText.getSelection()));
        float coerceAtLeast = RangesKt.coerceAtLeast((float) Math.floor(this.density.mo700toPx0680j_4(TextFieldCursor_androidKt.getDefaultCursorThickness())), 1.0f);
        if (layoutResult.getLayoutInput().getLayoutDirection() == LayoutDirection.Ltr) {
            right = cursorRect.getLeft() + (coerceAtLeast / 2.0f);
        } else {
            right = cursorRect.getRight() - (coerceAtLeast / 2.0f);
        }
        float f = coerceAtLeast / 2.0f;
        float coerceAtLeast2 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(right, ((int) (layoutResult.getSize() >> 32)) - f), f);
        if (((int) coerceAtLeast) % 2 == 1) {
            rint = ((float) Math.floor(coerceAtLeast2)) + 0.5f;
        } else {
            rint = (float) Math.rint(coerceAtLeast2);
        }
        return new Rect(rint - f, cursorRect.getTop(), rint + f, cursorRect.getBottom());
    }

    public final void update(HapticFeedback hapticFeedBack, Clipboard clipboard, TextToolbarHandler showTextToolbar, Density density, boolean enabled, boolean readOnly, boolean isPassword) {
        if (!enabled) {
            hideTextToolbar();
        }
        this.hapticFeedBack = hapticFeedBack;
        this.clipboard = clipboard;
        this.textToolbarHandler = showTextToolbar;
        this.density = density;
        this.enabled = enabled;
        this.readOnly = readOnly;
        this.isPassword = isPassword;
    }

    public final Object cursorHandleGestures(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TextFieldSelectionState$cursorHandleGestures$2(this, pointerInputScope, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public final Object selectionHandleGestures(PointerInputScope pointerInputScope, boolean z, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TextFieldSelectionState$selectionHandleGestures$2(this, pointerInputScope, z, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object startToolbarAndHandlesVisibilityObserver(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1
            if (r0 == 0) goto L14
            r0 = r6
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1 r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1 r0 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1
            r0.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L2f
            java.lang.Object r5 = r0.L$0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r5 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L5f
            goto L4e
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$2 r6 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$2     // Catch: java.lang.Throwable -> L5f
            r2 = 0
            r6.<init>(r5, r2)     // Catch: java.lang.Throwable -> L5f
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch: java.lang.Throwable -> L5f
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L5f
            r0.label = r4     // Catch: java.lang.Throwable -> L5f
            java.lang.Object r6 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r6, r0)     // Catch: java.lang.Throwable -> L5f
            if (r6 != r1) goto L4e
            return r1
        L4e:
            r5.setShowCursorHandle(r3)
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState r6 = r5.getTextToolbarState()
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState r0 = androidx.compose.foundation.text.input.internal.selection.TextToolbarState.None
            if (r6 == r0) goto L5c
            r5.hideTextToolbar()
        L5c:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L5f:
            r6 = move-exception
            r5.setShowCursorHandle(r3)
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState r0 = r5.getTextToolbarState()
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState r1 = androidx.compose.foundation.text.input.internal.selection.TextToolbarState.None
            if (r0 == r1) goto L6e
            r5.hideTextToolbar()
        L6e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.startToolbarAndHandlesVisibilityObserver(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void updateTextToolbarState(TextToolbarState textToolbarState) {
        setTextToolbarState(textToolbarState);
    }

    public final void dispose() {
        hideTextToolbar();
        this.clipboard = null;
        this.hapticFeedBack = null;
    }

    public final Object detectTouchMode(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        Object awaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new TextFieldSelectionState$detectTouchMode$2(this, null), continuation);
        return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
    }

    public final Object detectTextFieldTapGestures(PointerInputScope pointerInputScope, MutableInteractionSource mutableInteractionSource, final Function0<Unit> function0, final Function0<Unit> function02, Continuation<? super Unit> continuation) {
        Object detectTapAndPress = TapGestureDetectorKt.detectTapAndPress(pointerInputScope, new TextFieldSelectionState$detectTextFieldTapGestures$2(mutableInteractionSource, this, null), new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                m1702invokek4lQ0M(offset.m4135unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m1702invokek4lQ0M(long j) {
                boolean z;
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$3.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onTapTextField";
                    }
                });
                function0.invoke();
                if (this.enabled && this.getIsFocused()) {
                    z = this.readOnly;
                    if (!z) {
                        function02.invoke();
                        if (this.textFieldState.getVisualText().length() > 0) {
                            this.setShowCursorHandle(true);
                        }
                    }
                    this.updateTextToolbarState(TextToolbarState.None);
                    long m1621coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release = this.textLayoutState.m1621coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release(j);
                    TextFieldSelectionState textFieldSelectionState = this;
                    textFieldSelectionState.m1684placeCursorAtNearestOffsetk4lQ0M(TextLayoutStateKt.m1628fromDecorationToTextLayoutUv8p0NA(textFieldSelectionState.textLayoutState, m1621coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release));
                }
            }
        }, continuation);
        return detectTapAndPress == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapAndPress : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeCursorAtNearestOffset-k-4lQ0M, reason: not valid java name */
    public final boolean m1684placeCursorAtNearestOffsetk4lQ0M(long offset) {
        int m6405getOffsetForPositionk4lQ0M;
        IndexTransformationType indexTransformationType;
        int m6435getStartimpl;
        SelectionWedgeAffinity selectionWedgeAffinity;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null || (m6405getOffsetForPositionk4lQ0M = layoutResult.m6405getOffsetForPositionk4lQ0M(offset)) == -1) {
            return false;
        }
        TransformedTextFieldState transformedTextFieldState = this.textFieldState;
        long m1635mapFromTransformedjx7JFs = transformedTextFieldState.m1635mapFromTransformedjx7JFs(m6405getOffsetForPositionk4lQ0M);
        long m1638mapToTransformedGEjPoXI = transformedTextFieldState.m1638mapToTransformedGEjPoXI(m1635mapFromTransformedjx7JFs);
        if (TextRange.m6429getCollapsedimpl(m1635mapFromTransformedjx7JFs) && TextRange.m6429getCollapsedimpl(m1638mapToTransformedGEjPoXI)) {
            indexTransformationType = IndexTransformationType.Untransformed;
        } else if (!TextRange.m6429getCollapsedimpl(m1635mapFromTransformedjx7JFs) && !TextRange.m6429getCollapsedimpl(m1638mapToTransformedGEjPoXI)) {
            indexTransformationType = IndexTransformationType.Replacement;
        } else if (TextRange.m6429getCollapsedimpl(m1635mapFromTransformedjx7JFs) && !TextRange.m6429getCollapsedimpl(m1638mapToTransformedGEjPoXI)) {
            indexTransformationType = IndexTransformationType.Insertion;
        } else {
            indexTransformationType = IndexTransformationType.Deletion;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[indexTransformationType.ordinal()];
        SelectionWedgeAffinity selectionWedgeAffinity2 = null;
        if (i == 1) {
            m6435getStartimpl = TextRange.m6435getStartimpl(m1635mapFromTransformedjx7JFs);
        } else if (i == 2) {
            m6435getStartimpl = TextRange.m6435getStartimpl(m1635mapFromTransformedjx7JFs);
        } else if (i == 3) {
            if (MathUtilsKt.m1582findClosestRect9KIMszo(offset, layoutResult.getCursorRect(TextRange.m6435getStartimpl(m1638mapToTransformedGEjPoXI)), layoutResult.getCursorRect(TextRange.m6430getEndimpl(m1638mapToTransformedGEjPoXI))) < 0) {
                selectionWedgeAffinity = new SelectionWedgeAffinity(WedgeAffinity.Start);
            } else {
                selectionWedgeAffinity = new SelectionWedgeAffinity(WedgeAffinity.End);
            }
            selectionWedgeAffinity2 = selectionWedgeAffinity;
            m6435getStartimpl = TextRange.m6435getStartimpl(m1635mapFromTransformedjx7JFs);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            if (MathUtilsKt.m1582findClosestRect9KIMszo(offset, layoutResult.getCursorRect(TextRange.m6435getStartimpl(m1638mapToTransformedGEjPoXI)), layoutResult.getCursorRect(TextRange.m6430getEndimpl(m1638mapToTransformedGEjPoXI))) < 0) {
                m6435getStartimpl = TextRange.m6435getStartimpl(m1635mapFromTransformedjx7JFs);
            } else {
                m6435getStartimpl = TextRange.m6430getEndimpl(m1635mapFromTransformedjx7JFs);
            }
        }
        long TextRange = TextRangeKt.TextRange(m6435getStartimpl);
        if (TextRange.m6428equalsimpl0(TextRange, this.textFieldState.getUntransformedText().getSelection()) && (selectionWedgeAffinity2 == null || Intrinsics.areEqual(selectionWedgeAffinity2, this.textFieldState.getSelectionWedgeAffinity()))) {
            return false;
        }
        this.textFieldState.m1641selectUntransformedCharsIn5zctL8(TextRange);
        if (selectionWedgeAffinity2 != null) {
            this.textFieldState.setSelectionWedgeAffinity(selectionWedgeAffinity2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object detectCursorHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1
            if (r0 == 0) goto L14
            r0 = r10
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1 r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1 r0 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1
            r0.<init>(r8, r10)
        L19:
            r6 = r0
            java.lang.Object r10 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L44
            if (r1 != r2) goto L3b
            java.lang.Object r8 = r6.L$2
            kotlin.jvm.internal.Ref$LongRef r8 = (kotlin.jvm.internal.Ref.LongRef) r8
            java.lang.Object r9 = r6.L$1
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r0 = r6.L$0
            r1 = r0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r1 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r1
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L38
            goto L91
        L38:
            r0 = move-exception
            r10 = r0
            goto L9e
        L3b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L44:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.jvm.internal.Ref$LongRef r10 = new kotlin.jvm.internal.Ref$LongRef
            r10.<init>()
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r3 = r1.m4140getUnspecifiedF1C5BW0()
            r10.element = r3
            kotlin.jvm.internal.Ref$LongRef r7 = new kotlin.jvm.internal.Ref$LongRef
            r7.<init>()
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r3 = r1.m4140getUnspecifiedF1C5BW0()
            r7.element = r3
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$2 r1 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$2     // Catch: java.lang.Throwable -> L97
            r1.<init>()     // Catch: java.lang.Throwable -> L97
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1     // Catch: java.lang.Throwable -> L97
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$3 r3 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$3     // Catch: java.lang.Throwable -> L97
            r3.<init>()     // Catch: java.lang.Throwable -> L97
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3     // Catch: java.lang.Throwable -> L97
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$4 r4 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$4     // Catch: java.lang.Throwable -> L97
            r4.<init>()     // Catch: java.lang.Throwable -> L97
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4     // Catch: java.lang.Throwable -> L97
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$5 r5 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$5     // Catch: java.lang.Throwable -> L97
            r5.<init>()     // Catch: java.lang.Throwable -> L97
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch: java.lang.Throwable -> L97
            r6.L$0 = r8     // Catch: java.lang.Throwable -> L97
            r6.L$1 = r10     // Catch: java.lang.Throwable -> L97
            r6.L$2 = r7     // Catch: java.lang.Throwable -> L97
            r6.label = r2     // Catch: java.lang.Throwable -> L97
            r2 = r1
            r1 = r9
            java.lang.Object r9 = androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L97
            if (r9 != r0) goto L8e
            return r0
        L8e:
            r1 = r8
            r9 = r10
            r8 = r7
        L91:
            detectCursorHandleDragGestures$onDragStop(r9, r8, r1)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L97:
            r0 = move-exception
            r9 = r0
            r1 = r10
            r10 = r9
            r9 = r1
            r1 = r8
            r8 = r7
        L9e:
            detectCursorHandleDragGestures$onDragStop(r9, r8, r1)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectCursorHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectCursorHandleDragGestures$onDragStop(Ref.LongRef longRef, Ref.LongRef longRef2, TextFieldSelectionState textFieldSelectionState) {
        if ((longRef.element & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) {
            longRef.element = Offset.INSTANCE.m4140getUnspecifiedF1C5BW0();
            longRef2.element = Offset.INSTANCE.m4140getUnspecifiedF1C5BW0();
            textFieldSelectionState.clearHandleDragging();
        }
    }

    public final Object textFieldSelectionGestures(PointerInputScope pointerInputScope, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        Object selectionGesturePointerInputBtf2 = SelectionGesturesKt.selectionGesturePointerInputBtf2(pointerInputScope, new TextFieldMouseSelectionObserver(function0), new TextFieldTextDragObserver(function0), continuation);
        return selectionGesturePointerInputBtf2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? selectionGesturePointerInputBtf2 : Unit.INSTANCE;
    }

    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u001a\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016J\"\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0011J*\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\tX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldMouseSelectionObserver;", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "requestFocus", "Lkotlin/Function0;", "", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function0;)V", "dragBeginOffsetInText", "", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "onDrag", "", "dragPosition", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "onDrag-3MmeM6k", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "onDragDone", "onExtend", "downPosition", "onExtend-k-4lQ0M", "(J)Z", "onExtendDrag", "onExtendDrag-k-4lQ0M", "onStart", "onStart-3MmeM6k", "updateSelection", "Landroidx/compose/ui/text/TextRange;", "isStartOfSelection", "updateSelection-r1Wruf4", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    private final class TextFieldMouseSelectionObserver implements MouseSelectionObserver {
        private int dragBeginOffsetInText = -1;
        private long dragBeginPosition = Offset.INSTANCE.m4140getUnspecifiedF1C5BW0();
        private final Function0<Unit> requestFocus;

        public TextFieldMouseSelectionObserver(Function0<Unit> function0) {
            this.requestFocus = function0;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* renamed from: onStart-3MmeM6k, reason: not valid java name */
        public boolean mo1695onStart3MmeM6k(long downPosition, SelectionAdjustment adjustment) {
            if (!TextFieldSelectionState.this.enabled || TextFieldSelectionState.this.textFieldState.getVisualText().length() == 0) {
                return false;
            }
            TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onStart$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Mouse.onStart";
                }
            });
            TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.Mouse);
            this.requestFocus.invoke();
            TextFieldSelectionState.this.previousRawDragOffset = -1;
            this.dragBeginOffsetInText = -1;
            this.dragBeginPosition = downPosition;
            this.dragBeginOffsetInText = TextRange.m6435getStartimpl(m1691updateSelectionr1Wruf4(downPosition, adjustment, true));
            return true;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* renamed from: onDrag-3MmeM6k, reason: not valid java name */
        public boolean mo1692onDrag3MmeM6k(final long dragPosition, SelectionAdjustment adjustment) {
            if (!TextFieldSelectionState.this.enabled || TextFieldSelectionState.this.textFieldState.getVisualText().length() == 0) {
                return false;
            }
            TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onDrag$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Mouse.onDrag " + ((Object) Offset.m4133toStringimpl(dragPosition));
                }
            });
            m1691updateSelectionr1Wruf4(dragPosition, adjustment, false);
            return true;
        }

        /* renamed from: updateSelection-r1Wruf4, reason: not valid java name */
        private final long m1691updateSelectionr1Wruf4(long dragPosition, SelectionAdjustment adjustment, boolean isStartOfSelection) {
            Integer valueOf = Integer.valueOf(this.dragBeginOffsetInText);
            if (valueOf.intValue() < 0) {
                valueOf = null;
            }
            int intValue = valueOf != null ? valueOf.intValue() : TextFieldSelectionState.this.textLayoutState.m1623getOffsetForPosition3MmeM6k(this.dragBeginPosition, false);
            int m1623getOffsetForPosition3MmeM6k = TextFieldSelectionState.this.textLayoutState.m1623getOffsetForPosition3MmeM6k(dragPosition, false);
            TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
            long m1687updateSelectionSsLRf8 = textFieldSelectionState.m1687updateSelectionSsLRf8(textFieldSelectionState.textFieldState.getVisualText(), intValue, m1623getOffsetForPosition3MmeM6k, false, adjustment, false, isStartOfSelection);
            if (this.dragBeginOffsetInText == -1 && !TextRange.m6429getCollapsedimpl(m1687updateSelectionSsLRf8)) {
                this.dragBeginOffsetInText = TextRange.m6435getStartimpl(m1687updateSelectionSsLRf8);
            }
            if (TextRange.m6434getReversedimpl(m1687updateSelectionSsLRf8)) {
                m1687updateSelectionSsLRf8 = TextFieldSelectionStateKt.m1704reverse5zctL8(m1687updateSelectionSsLRf8);
            }
            TextFieldSelectionState.this.textFieldState.m1640selectCharsIn5zctL8(m1687updateSelectionSsLRf8);
            TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
            return m1687updateSelectionSsLRf8;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        public void onDragDone() {
            TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onDragDone$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Mouse.onDragDone";
                }
            });
            TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.None);
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* renamed from: onExtend-k-4lQ0M, reason: not valid java name */
        public boolean mo1693onExtendk4lQ0M(long downPosition) {
            TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onExtend$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Mouse.onExtend";
                }
            });
            return true;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* renamed from: onExtendDrag-k-4lQ0M, reason: not valid java name */
        public boolean mo1694onExtendDragk4lQ0M(long dragPosition) {
            TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onExtendDrag$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Mouse.onExtendDrag";
                }
            });
            return true;
        }
    }

    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0012J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0012J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u000bX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\r\u001a\u00020\u000bX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldTextDragObserver;", "Landroidx/compose/foundation/text/TextDragObserver;", "requestFocus", "Lkotlin/Function0;", "", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function0;)V", "actingHandle", "Landroidx/compose/foundation/text/Handle;", "dragBeginOffsetInText", "", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "dragTotalDistance", "onCancel", "onDown", "point", "onDown-k-4lQ0M", "(J)V", "onDrag", "delta", "onDrag-k-4lQ0M", "onDragStop", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    private final class TextFieldTextDragObserver implements TextDragObserver {
        private final Function0<Unit> requestFocus;
        private int dragBeginOffsetInText = -1;
        private long dragBeginPosition = Offset.INSTANCE.m4140getUnspecifiedF1C5BW0();
        private long dragTotalDistance = Offset.INSTANCE.m4141getZeroF1C5BW0();
        private Handle actingHandle = Handle.SelectionEnd;

        @Override // androidx.compose.foundation.text.TextDragObserver
        /* renamed from: onDown-k-4lQ0M */
        public void mo1455onDownk4lQ0M(long point) {
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onUp() {
        }

        public TextFieldTextDragObserver(Function0<Unit> function0) {
            this.requestFocus = function0;
        }

        private final void onDragStop() {
            if ((this.dragBeginPosition & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldTextDragObserver$onDragStop$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Touch.onDragStop";
                    }
                });
                TextFieldSelectionState.this.clearHandleDragging();
                this.dragBeginOffsetInText = -1;
                this.dragBeginPosition = Offset.INSTANCE.m4140getUnspecifiedF1C5BW0();
                this.dragTotalDistance = Offset.INSTANCE.m4141getZeroF1C5BW0();
                TextFieldSelectionState.this.previousRawDragOffset = -1;
                TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.None);
                this.requestFocus.invoke();
            }
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onStop() {
            onDragStop();
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onCancel() {
            onDragStop();
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        /* renamed from: onStart-k-4lQ0M */
        public void mo1457onStartk4lQ0M(final long startPoint) {
            if (TextFieldSelectionState.this.enabled) {
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldTextDragObserver$onStart$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Touch.onDragStart after longPress at " + ((Object) Offset.m4133toStringimpl(startPoint));
                    }
                });
                TextFieldSelectionState.this.m1690updateHandleDraggingUv8p0NA(this.actingHandle, startPoint);
                TextFieldSelectionState.this.setShowCursorHandle(false);
                TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.Touch);
                this.dragBeginPosition = startPoint;
                this.dragTotalDistance = Offset.INSTANCE.m4141getZeroF1C5BW0();
                TextFieldSelectionState.this.previousRawDragOffset = -1;
                if (TextFieldSelectionState.this.textLayoutState.getLayoutResult() == null) {
                    return;
                }
                boolean m1624isPositionOnTextk4lQ0M = TextFieldSelectionState.this.textLayoutState.m1624isPositionOnTextk4lQ0M(startPoint);
                TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
                if (!m1624isPositionOnTextk4lQ0M) {
                    int m1620getOffsetForPosition3MmeM6k$default = TextLayoutState.m1620getOffsetForPosition3MmeM6k$default(textFieldSelectionState.textLayoutState, startPoint, false, 2, null);
                    HapticFeedback hapticFeedback = TextFieldSelectionState.this.hapticFeedBack;
                    if (hapticFeedback != null) {
                        hapticFeedback.mo5106performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m5122getTextHandleMove5zf0vsI());
                    }
                    TextFieldSelectionState.this.textFieldState.placeCursorBeforeCharAt(m1620getOffsetForPosition3MmeM6k$default);
                    TextFieldSelectionState.this.setShowCursorHandle(true);
                    TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Cursor);
                    return;
                }
                if (textFieldSelectionState.textFieldState.getVisualText().length() == 0) {
                    return;
                }
                int m1620getOffsetForPosition3MmeM6k$default2 = TextLayoutState.m1620getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, startPoint, false, 2, null);
                long m1688updateSelectionSsLRf8$default = TextFieldSelectionState.m1688updateSelectionSsLRf8$default(TextFieldSelectionState.this, new TextFieldCharSequence(TextFieldSelectionState.this.textFieldState.getVisualText(), TextRange.INSTANCE.m6440getZerod9O1mEE(), null, null, null, 28, null), m1620getOffsetForPosition3MmeM6k$default2, m1620getOffsetForPosition3MmeM6k$default2, false, SelectionAdjustment.INSTANCE.getWord(), false, false, 96, null);
                TextFieldSelectionState.this.textFieldState.m1640selectCharsIn5zctL8(m1688updateSelectionSsLRf8$default);
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
                this.dragBeginOffsetInText = TextRange.m6435getStartimpl(m1688updateSelectionSsLRf8$default);
            }
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        /* renamed from: onDrag-k-4lQ0M */
        public void mo1456onDragk4lQ0M(long delta) {
            int intValue;
            int m1623getOffsetForPosition3MmeM6k;
            SelectionAdjustment word;
            Handle handle;
            if (!TextFieldSelectionState.this.enabled || TextFieldSelectionState.this.textLayoutState.getLayoutResult() == null || TextFieldSelectionState.this.textFieldState.getVisualText().length() == 0) {
                return;
            }
            long m4130plusMKHz9U = Offset.m4130plusMKHz9U(this.dragTotalDistance, delta);
            this.dragTotalDistance = m4130plusMKHz9U;
            final long m4130plusMKHz9U2 = Offset.m4130plusMKHz9U(this.dragBeginPosition, m4130plusMKHz9U);
            TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldTextDragObserver$onDrag$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Touch.onDrag at " + ((Object) Offset.m4133toStringimpl(m4130plusMKHz9U2));
                }
            });
            if (this.dragBeginOffsetInText < 0 && !TextFieldSelectionState.this.textLayoutState.m1624isPositionOnTextk4lQ0M(m4130plusMKHz9U2)) {
                intValue = TextLayoutState.m1620getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, this.dragBeginPosition, false, 2, null);
                m1623getOffsetForPosition3MmeM6k = TextLayoutState.m1620getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, m4130plusMKHz9U2, false, 2, null);
                if (intValue == m1623getOffsetForPosition3MmeM6k) {
                    word = SelectionAdjustment.INSTANCE.getNone();
                } else {
                    word = SelectionAdjustment.INSTANCE.getWord();
                }
            } else {
                Integer valueOf = Integer.valueOf(this.dragBeginOffsetInText);
                if (valueOf.intValue() < 0) {
                    valueOf = null;
                }
                intValue = valueOf != null ? valueOf.intValue() : TextFieldSelectionState.this.textLayoutState.m1623getOffsetForPosition3MmeM6k(this.dragBeginPosition, false);
                m1623getOffsetForPosition3MmeM6k = TextFieldSelectionState.this.textLayoutState.m1623getOffsetForPosition3MmeM6k(m4130plusMKHz9U2, false);
                if (this.dragBeginOffsetInText < 0 && intValue == m1623getOffsetForPosition3MmeM6k) {
                    return;
                }
                word = SelectionAdjustment.INSTANCE.getWord();
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
            }
            int i = intValue;
            int i2 = m1623getOffsetForPosition3MmeM6k;
            SelectionAdjustment selectionAdjustment = word;
            long selection = TextFieldSelectionState.this.textFieldState.getVisualText().getSelection();
            TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
            long m1688updateSelectionSsLRf8$default = TextFieldSelectionState.m1688updateSelectionSsLRf8$default(textFieldSelectionState, textFieldSelectionState.textFieldState.getVisualText(), i, i2, false, selectionAdjustment, false, false, 64, null);
            if (this.dragBeginOffsetInText == -1 && !TextRange.m6429getCollapsedimpl(m1688updateSelectionSsLRf8$default)) {
                this.dragBeginOffsetInText = TextRange.m6435getStartimpl(m1688updateSelectionSsLRf8$default);
            }
            if (TextRange.m6434getReversedimpl(m1688updateSelectionSsLRf8$default)) {
                m1688updateSelectionSsLRf8$default = TextFieldSelectionStateKt.m1704reverse5zctL8(m1688updateSelectionSsLRf8$default);
            }
            if (!TextRange.m6428equalsimpl0(m1688updateSelectionSsLRf8$default, selection)) {
                if (TextRange.m6435getStartimpl(m1688updateSelectionSsLRf8$default) != TextRange.m6435getStartimpl(selection) && TextRange.m6430getEndimpl(m1688updateSelectionSsLRf8$default) == TextRange.m6430getEndimpl(selection)) {
                    handle = Handle.SelectionStart;
                } else if (TextRange.m6435getStartimpl(m1688updateSelectionSsLRf8$default) == TextRange.m6435getStartimpl(selection) && TextRange.m6430getEndimpl(m1688updateSelectionSsLRf8$default) != TextRange.m6430getEndimpl(selection)) {
                    handle = Handle.SelectionEnd;
                } else if ((TextRange.m6435getStartimpl(m1688updateSelectionSsLRf8$default) + TextRange.m6430getEndimpl(m1688updateSelectionSsLRf8$default)) / 2.0f > (TextRange.m6435getStartimpl(selection) + TextRange.m6430getEndimpl(selection)) / 2.0f) {
                    handle = Handle.SelectionEnd;
                } else {
                    handle = Handle.SelectionStart;
                }
                this.actingHandle = handle;
            }
            if (TextRange.m6429getCollapsedimpl(selection) || !TextRange.m6429getCollapsedimpl(m1688updateSelectionSsLRf8$default)) {
                TextFieldSelectionState.this.textFieldState.m1640selectCharsIn5zctL8(m1688updateSelectionSsLRf8$default);
            }
            TextFieldSelectionState.this.m1690updateHandleDraggingUv8p0NA(this.actingHandle, m4130plusMKHz9U2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object detectSelectionHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope r15, final boolean r16, kotlin.coroutines.Continuation<? super kotlin.Unit> r17) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectSelectionHandleDragGestures$onDragStop$6(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.LongRef longRef2) {
        if ((longRef.element & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) {
            textFieldSelectionState.clearHandleDragging();
            longRef.element = Offset.INSTANCE.m4140getUnspecifiedF1C5BW0();
            longRef2.element = Offset.INSTANCE.m4141getZeroF1C5BW0();
            textFieldSelectionState.previousRawDragOffset = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object observeTextChanges(Continuation<? super Unit> continuation) {
        Object collect = FlowKt.drop(FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0<TextFieldCharSequence>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextChanges$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextFieldCharSequence invoke() {
                return TextFieldSelectionState.this.textFieldState.getVisualText();
            }
        }), TextFieldSelectionState$observeTextChanges$3.INSTANCE), 1).collect(new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextChanges$4
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((TextFieldCharSequence) obj, (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(TextFieldCharSequence textFieldCharSequence, Continuation<? super Unit> continuation2) {
                TextFieldSelectionState.this.setShowCursorHandle(false);
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.None);
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object observeTextToolbarVisibility(Continuation<? super Unit> continuation) {
        Object collect = SnapshotStateKt.snapshotFlow(new Function0<Rect>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextToolbarVisibility$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Code restructure failed: missing block: B:10:0x0041, code lost:
            
                if (r0 == null) goto L16;
             */
            /* JADX WARN: Code restructure failed: missing block: B:11:0x0043, code lost:
            
                r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:12:0x0049, code lost:
            
                if (r0 == null) goto L31;
             */
            /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
            
                r2 = r6.this$0.getTextLayoutCoordinates();
             */
            /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
            
                if (r2 == null) goto L21;
             */
            /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
            
                r2 = androidx.compose.ui.geometry.Offset.m4114boximpl(r2.mo5743localToRootMKHz9U(r0.m4160getTopLeftF1C5BW0()));
             */
            /* JADX WARN: Code restructure failed: missing block: B:16:0x0061, code lost:
            
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
                r0 = androidx.compose.ui.geometry.RectKt.m4165Recttz77jQw(r2.m4135unboximpl(), r0.m4158getSizeNHjbRc());
                r6 = r6.this$0.getContentRect();
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x007a, code lost:
            
                if (r0.overlaps(r6) == false) goto L25;
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x007c, code lost:
            
                r1 = r6;
             */
            /* JADX WARN: Code restructure failed: missing block: B:19:0x007d, code lost:
            
                if (r1 == null) goto L29;
             */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x007f, code lost:
            
                r6 = r1.intersect(r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x0083, code lost:
            
                if (r6 == null) goto L29;
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x0085, code lost:
            
                return r6;
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x008c, code lost:
            
                return androidx.compose.ui.geometry.Rect.INSTANCE.getZero();
             */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x0060, code lost:
            
                r2 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:28:0x0093, code lost:
            
                return androidx.compose.ui.geometry.Rect.INSTANCE.getZero();
             */
            /* JADX WARN: Code restructure failed: missing block: B:29:0x0048, code lost:
            
                r0 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:34:0x0028, code lost:
            
                if (r0 == androidx.compose.foundation.text.input.internal.selection.TextToolbarState.Selection) goto L9;
             */
            /* JADX WARN: Code restructure failed: missing block: B:4:0x001c, code lost:
            
                if (r1 != androidx.compose.foundation.text.input.internal.selection.TextToolbarState.Cursor) goto L6;
             */
            /* JADX WARN: Code restructure failed: missing block: B:6:0x0030, code lost:
            
                if (r6.this$0.getDraggingHandle() != null) goto L33;
             */
            /* JADX WARN: Code restructure failed: missing block: B:8:0x0038, code lost:
            
                if (r6.this$0.isInTouchMode() == false) goto L33;
             */
            /* JADX WARN: Code restructure failed: missing block: B:9:0x003a, code lost:
            
                r0 = r6.this$0.getTextLayoutCoordinates();
                r1 = null;
             */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final androidx.compose.ui.geometry.Rect invoke() {
                /*
                    r6 = this;
                    androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r0 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.this
                    androidx.compose.foundation.text.input.internal.TransformedTextFieldState r0 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.access$getTextFieldState$p(r0)
                    androidx.compose.foundation.text.input.TextFieldCharSequence r0 = r0.getVisualText()
                    long r0 = r0.getSelection()
                    boolean r0 = androidx.compose.ui.text.TextRange.m6429getCollapsedimpl(r0)
                    if (r0 == 0) goto L1e
                    androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r1 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.this
                    androidx.compose.foundation.text.input.internal.selection.TextToolbarState r1 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.access$getTextToolbarState(r1)
                    androidx.compose.foundation.text.input.internal.selection.TextToolbarState r2 = androidx.compose.foundation.text.input.internal.selection.TextToolbarState.Cursor
                    if (r1 == r2) goto L2a
                L1e:
                    if (r0 != 0) goto L94
                    androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r0 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.this
                    androidx.compose.foundation.text.input.internal.selection.TextToolbarState r0 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.access$getTextToolbarState(r0)
                    androidx.compose.foundation.text.input.internal.selection.TextToolbarState r1 = androidx.compose.foundation.text.input.internal.selection.TextToolbarState.Selection
                    if (r0 != r1) goto L94
                L2a:
                    androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r0 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.this
                    androidx.compose.foundation.text.Handle r0 = r0.getDraggingHandle()
                    if (r0 != 0) goto L94
                    androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r0 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.this
                    boolean r0 = r0.isInTouchMode()
                    if (r0 == 0) goto L94
                    androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r0 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.this
                    androidx.compose.ui.layout.LayoutCoordinates r0 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.access$getTextLayoutCoordinates(r0)
                    r1 = 0
                    if (r0 == 0) goto L48
                    androidx.compose.ui.geometry.Rect r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r0)
                    goto L49
                L48:
                    r0 = r1
                L49:
                    if (r0 == 0) goto L8d
                    androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r2 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.this
                    androidx.compose.ui.layout.LayoutCoordinates r2 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.access$getTextLayoutCoordinates(r2)
                    if (r2 == 0) goto L60
                    long r3 = r0.m4160getTopLeftF1C5BW0()
                    long r2 = r2.mo5743localToRootMKHz9U(r3)
                    androidx.compose.ui.geometry.Offset r2 = androidx.compose.ui.geometry.Offset.m4114boximpl(r2)
                    goto L61
                L60:
                    r2 = r1
                L61:
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                    long r2 = r2.m4135unboximpl()
                    long r4 = r0.m4158getSizeNHjbRc()
                    androidx.compose.ui.geometry.Rect r0 = androidx.compose.ui.geometry.RectKt.m4165Recttz77jQw(r2, r4)
                    androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r6 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.this
                    androidx.compose.ui.geometry.Rect r6 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.access$getContentRect(r6)
                    boolean r2 = r0.overlaps(r6)
                    if (r2 == 0) goto L7d
                    r1 = r6
                L7d:
                    if (r1 == 0) goto L86
                    androidx.compose.ui.geometry.Rect r6 = r1.intersect(r0)
                    if (r6 == 0) goto L86
                    return r6
                L86:
                    androidx.compose.ui.geometry.Rect$Companion r6 = androidx.compose.ui.geometry.Rect.INSTANCE
                    androidx.compose.ui.geometry.Rect r6 = r6.getZero()
                    return r6
                L8d:
                    androidx.compose.ui.geometry.Rect$Companion r6 = androidx.compose.ui.geometry.Rect.INSTANCE
                    androidx.compose.ui.geometry.Rect r6 = r6.getZero()
                    return r6
                L94:
                    androidx.compose.ui.geometry.Rect$Companion r6 = androidx.compose.ui.geometry.Rect.INSTANCE
                    androidx.compose.ui.geometry.Rect r6 = r6.getZero()
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextToolbarVisibility$2.invoke():androidx.compose.ui.geometry.Rect");
            }
        }).collect(new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextToolbarVisibility$3
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((Rect) obj, (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(Rect rect, Continuation<? super Unit> continuation2) {
                TextToolbarHandler textToolbarHandler;
                boolean areEqual = Intrinsics.areEqual(rect, Rect.INSTANCE.getZero());
                TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
                if (areEqual) {
                    textFieldSelectionState.hideTextToolbar();
                } else {
                    textToolbarHandler = textFieldSelectionState.textToolbarHandler;
                    if (textToolbarHandler != null) {
                        Object showTextToolbar = textToolbarHandler.showTextToolbar(TextFieldSelectionState.this, rect, continuation2);
                        return showTextToolbar == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? showTextToolbar : Unit.INSTANCE;
                    }
                }
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect getContentRect() {
        float f;
        Rect cursorRect;
        Rect cursorRect2;
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        if (TextRange.m6429getCollapsedimpl(visualText.getSelection())) {
            Rect cursorRect3 = getCursorRect();
            LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            return RectKt.m4165Recttz77jQw(textLayoutCoordinates != null ? textLayoutCoordinates.mo5743localToRootMKHz9U(cursorRect3.m4160getTopLeftF1C5BW0()) : Offset.INSTANCE.m4141getZeroF1C5BW0(), cursorRect3.m4158getSizeNHjbRc());
        }
        LayoutCoordinates textLayoutCoordinates2 = getTextLayoutCoordinates();
        long mo5743localToRootMKHz9U = textLayoutCoordinates2 != null ? textLayoutCoordinates2.mo5743localToRootMKHz9U(m1680getHandlePositiontuRUvjQ(true)) : Offset.INSTANCE.m4141getZeroF1C5BW0();
        LayoutCoordinates textLayoutCoordinates3 = getTextLayoutCoordinates();
        long mo5743localToRootMKHz9U2 = textLayoutCoordinates3 != null ? textLayoutCoordinates3.mo5743localToRootMKHz9U(m1680getHandlePositiontuRUvjQ(false)) : Offset.INSTANCE.m4141getZeroF1C5BW0();
        LayoutCoordinates textLayoutCoordinates4 = getTextLayoutCoordinates();
        float f2 = 0.0f;
        if (textLayoutCoordinates4 != null) {
            TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
            f = Float.intBitsToFloat((int) (textLayoutCoordinates4.mo5743localToRootMKHz9U(Offset.m4117constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits((layoutResult == null || (cursorRect2 = layoutResult.getCursorRect(TextRange.m6435getStartimpl(visualText.getSelection()))) == null) ? 0.0f : cursorRect2.getTop()) & 4294967295L))) & 4294967295L));
        } else {
            f = 0.0f;
        }
        LayoutCoordinates textLayoutCoordinates5 = getTextLayoutCoordinates();
        if (textLayoutCoordinates5 != null) {
            TextLayoutResult layoutResult2 = this.textLayoutState.getLayoutResult();
            f2 = Float.intBitsToFloat((int) (textLayoutCoordinates5.mo5743localToRootMKHz9U(Offset.m4117constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits((layoutResult2 == null || (cursorRect = layoutResult2.getCursorRect(TextRange.m6430getEndimpl(visualText.getSelection()))) == null) ? 0.0f : cursorRect.getTop()) & 4294967295L))) & 4294967295L));
        }
        int i = (int) (mo5743localToRootMKHz9U >> 32);
        int i2 = (int) (mo5743localToRootMKHz9U2 >> 32);
        return new Rect(Math.min(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.min(f, f2), Math.max(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.max(Float.intBitsToFloat((int) (mo5743localToRootMKHz9U & 4294967295L)), Float.intBitsToFloat((int) (mo5743localToRootMKHz9U2 & 4294967295L))));
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0052, code lost:
    
        if (((r0 == null || (r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r0)) == null) ? false : androidx.compose.foundation.text.selection.SelectionManagerKt.m1807containsInclusiveUv8p0NA(r0, r4)) != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState getSelectionHandleState$foundation_release(boolean r15, boolean r16) {
        /*
            r14 = this;
            if (r15 == 0) goto L5
            androidx.compose.foundation.text.Handle r0 = androidx.compose.foundation.text.Handle.SelectionStart
            goto L7
        L5:
            androidx.compose.foundation.text.Handle r0 = androidx.compose.foundation.text.Handle.SelectionEnd
        L7:
            androidx.compose.foundation.text.input.internal.TextLayoutState r1 = r14.textLayoutState
            androidx.compose.ui.text.TextLayoutResult r1 = r1.getLayoutResult()
            if (r1 != 0) goto L16
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState$Companion r14 = androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState.INSTANCE
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r14 = r14.getHidden()
            return r14
        L16:
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r2 = r14.textFieldState
            androidx.compose.foundation.text.input.TextFieldCharSequence r2 = r2.getVisualText()
            long r2 = r2.getSelection()
            boolean r4 = androidx.compose.ui.text.TextRange.m6429getCollapsedimpl(r2)
            if (r4 == 0) goto L2d
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState$Companion r14 = androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState.INSTANCE
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r14 = r14.getHidden()
            return r14
        L2d:
            long r4 = r14.m1680getHandlePositiontuRUvjQ(r15)
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$InputType r6 = r14.getDirectDragGestureInitiator()
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$InputType r7 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.InputType.None
            if (r6 != r7) goto Lb1
            androidx.compose.foundation.text.Handle r6 = r14.getDraggingHandle()
            r7 = 0
            if (r6 == r0) goto L54
            androidx.compose.ui.layout.LayoutCoordinates r0 = r14.getTextLayoutCoordinates()
            if (r0 == 0) goto L51
            androidx.compose.ui.geometry.Rect r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r0)
            if (r0 == 0) goto L51
            boolean r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.m1807containsInclusiveUv8p0NA(r0, r4)
            goto L52
        L51:
            r0 = r7
        L52:
            if (r0 == 0) goto Lb1
        L54:
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r0 = r14.textFieldState
            androidx.compose.foundation.text.input.TextFieldCharSequence r0 = r0.getVisualText()
            boolean r0 = r0.shouldShowSelection()
            if (r0 != 0) goto L67
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState$Companion r14 = androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState.INSTANCE
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r14 = r14.getHidden()
            return r14
        L67:
            if (r15 == 0) goto L6e
            int r0 = androidx.compose.ui.text.TextRange.m6435getStartimpl(r2)
            goto L78
        L6e:
            int r0 = androidx.compose.ui.text.TextRange.m6430getEndimpl(r2)
            int r0 = r0 + (-1)
            int r0 = java.lang.Math.max(r0, r7)
        L78:
            androidx.compose.ui.text.style.ResolvedTextDirection r11 = r1.getBidiRunDirection(r0)
            boolean r12 = androidx.compose.ui.text.TextRange.m6434getReversedimpl(r2)
            if (r16 == 0) goto L93
            androidx.compose.ui.layout.LayoutCoordinates r14 = r14.getTextLayoutCoordinates()
            if (r14 == 0) goto L99
            androidx.compose.ui.geometry.Rect r14 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r14)
            if (r14 == 0) goto L99
            long r4 = androidx.compose.foundation.text.input.internal.TextLayoutStateKt.m1627coerceIn3MmeM6k(r4, r14)
            goto L99
        L93:
            androidx.compose.ui.geometry.Offset$Companion r14 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r4 = r14.m4140getUnspecifiedF1C5BW0()
        L99:
            r8 = r4
            if (r15 == 0) goto La1
            int r14 = androidx.compose.ui.text.TextRange.m6435getStartimpl(r2)
            goto La5
        La1:
            int r14 = androidx.compose.ui.text.TextRange.m6430getEndimpl(r2)
        La5:
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r6 = new androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState
            float r10 = androidx.compose.foundation.text.TextLayoutHelperKt.getLineHeight(r1, r14)
            r13 = 0
            r7 = 1
            r6.<init>(r7, r8, r10, r11, r12, r13)
            return r6
        Lb1:
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState$Companion r14 = androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState.INSTANCE
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r14 = r14.getHidden()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.getSelectionHandleState$foundation_release(boolean, boolean):androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getHandlePosition-tuRUvjQ, reason: not valid java name */
    public final long m1680getHandlePositiontuRUvjQ(boolean isStartHandle) {
        int m6430getEndimpl;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Offset.INSTANCE.m4141getZeroF1C5BW0();
        }
        long selection = this.textFieldState.getVisualText().getSelection();
        if (isStartHandle) {
            m6430getEndimpl = TextRange.m6435getStartimpl(selection);
        } else {
            m6430getEndimpl = TextRange.m6430getEndimpl(selection);
        }
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(layoutResult, m6430getEndimpl, isStartHandle, TextRange.m6434getReversedimpl(selection));
    }

    /* renamed from: updateHandleDragging-Uv8p0NA, reason: not valid java name */
    public final void m1690updateHandleDraggingUv8p0NA(Handle handle, long position) {
        setDraggingHandle(handle);
        m1685setRawHandleDragPositionk4lQ0M(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markStartContentVisibleOffset() {
        m1686setStartTextLayoutPositionInWindowk4lQ0M(m1679getCurrentTextLayoutPositionInWindowF1C5BW0());
    }

    public final void clearHandleDragging() {
        setDraggingHandle(null);
        m1685setRawHandleDragPositionk4lQ0M(Offset.INSTANCE.m4140getUnspecifiedF1C5BW0());
        m1686setStartTextLayoutPositionInWindowk4lQ0M(Offset.INSTANCE.m4140getUnspecifiedF1C5BW0());
    }

    public final boolean canCut() {
        return (TextRange.m6429getCollapsedimpl(this.textFieldState.getVisualText().getSelection()) || !getEditable() || this.isPassword) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object cut(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cut$1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cut$1 r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cut$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cut$1 r0 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cut$1
            r0.<init>(r6, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2e
            java.lang.Object r6 = r0.L$0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r6 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6f
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r7 = r6.textFieldState
            androidx.compose.foundation.text.input.TextFieldCharSequence r7 = r7.getVisualText()
            long r4 = r7.getSelection()
            boolean r2 = androidx.compose.ui.text.TextRange.m6429getCollapsedimpl(r4)
            if (r2 == 0) goto L4d
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L4d:
            androidx.compose.ui.text.AnnotatedString r2 = new androidx.compose.ui.text.AnnotatedString
            java.lang.CharSequence r7 = androidx.compose.foundation.text.input.TextFieldCharSequenceKt.getSelectedText(r7)
            java.lang.String r7 = r7.toString()
            r4 = 2
            r5 = 0
            r2.<init>(r7, r5, r4, r5)
            androidx.compose.ui.platform.Clipboard r7 = r6.clipboard
            if (r7 == 0) goto L6f
            androidx.compose.ui.platform.ClipEntry r2 = androidx.compose.foundation.internal.ClipboardUtils_androidKt.toClipEntry(r2)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.setClipEntry(r2, r0)
            if (r7 != r1) goto L6f
            return r1
        L6f:
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r6 = r6.textFieldState
            r6.deleteSelectedText()
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.cut(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean canCopy() {
        return (TextRange.m6429getCollapsedimpl(this.textFieldState.getVisualText().getSelection()) || this.isPassword) ? false : true;
    }

    public static /* synthetic */ Object copy$default(TextFieldSelectionState textFieldSelectionState, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return textFieldSelectionState.copy(z, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object copy(boolean r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$copy$1
            if (r0 == 0) goto L14
            r0 = r9
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$copy$1 r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$copy$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$copy$1 r0 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$copy$1
            r0.<init>(r7, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L33
            boolean r7 = r0.Z$0
            java.lang.Object r8 = r0.L$0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r8 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r8
            kotlin.ResultKt.throwOnFailure(r9)
            r6 = r8
            r8 = r7
            r7 = r6
            goto L76
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            kotlin.ResultKt.throwOnFailure(r9)
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r9 = r7.textFieldState
            androidx.compose.foundation.text.input.TextFieldCharSequence r9 = r9.getVisualText()
            long r4 = r9.getSelection()
            boolean r2 = androidx.compose.ui.text.TextRange.m6429getCollapsedimpl(r4)
            if (r2 == 0) goto L52
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L52:
            androidx.compose.ui.text.AnnotatedString r2 = new androidx.compose.ui.text.AnnotatedString
            java.lang.CharSequence r9 = androidx.compose.foundation.text.input.TextFieldCharSequenceKt.getSelectedText(r9)
            java.lang.String r9 = r9.toString()
            r4 = 2
            r5 = 0
            r2.<init>(r9, r5, r4, r5)
            androidx.compose.ui.platform.Clipboard r9 = r7.clipboard
            if (r9 == 0) goto L76
            androidx.compose.ui.platform.ClipEntry r2 = androidx.compose.foundation.internal.ClipboardUtils_androidKt.toClipEntry(r2)
            r0.L$0 = r7
            r0.Z$0 = r8
            r0.label = r3
            java.lang.Object r9 = r9.setClipEntry(r2, r0)
            if (r9 != r1) goto L76
            return r1
        L76:
            if (r8 != 0) goto L7b
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L7b:
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r7 = r7.textFieldState
            r7.collapseSelectionToMax()
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.copy(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x008b, code lost:
    
        if (r7 == r1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008d, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0059, code lost:
    
        if (r7 == r1) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object canPaste(kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$canPaste$1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$canPaste$1 r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$canPaste$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$canPaste$1 r0 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$canPaste$1
            r0.<init>(r6, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L3f
            if (r2 == r5) goto L37
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r7)
            goto L8e
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            java.lang.Object r6 = r0.L$0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r6 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5c
        L3f:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = r6.getEditable()
            if (r7 != 0) goto L4d
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r6
        L4d:
            androidx.compose.ui.platform.Clipboard r7 = r6.clipboard
            if (r7 == 0) goto L68
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r7 = r7.getClipEntry(r0)
            if (r7 != r1) goto L5c
            goto L8d
        L5c:
            androidx.compose.ui.platform.ClipEntry r7 = (androidx.compose.ui.platform.ClipEntry) r7
            if (r7 == 0) goto L68
            boolean r7 = androidx.compose.foundation.internal.ClipboardUtils_androidKt.hasText(r7)
            if (r7 != r5) goto L68
            r7 = r5
            goto L69
        L68:
            r7 = r4
        L69:
            if (r7 == 0) goto L70
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r6
        L70:
            kotlin.jvm.functions.Function0<? extends androidx.compose.foundation.content.internal.ReceiveContentConfiguration> r7 = r6.receiveContentConfiguration
            r2 = 0
            if (r7 == 0) goto L7c
            java.lang.Object r7 = r7.invoke()
            androidx.compose.foundation.content.internal.ReceiveContentConfiguration r7 = (androidx.compose.foundation.content.internal.ReceiveContentConfiguration) r7
            goto L7d
        L7c:
            r7 = r2
        L7d:
            if (r7 == 0) goto L94
            androidx.compose.ui.platform.Clipboard r6 = r6.clipboard
            if (r6 == 0) goto L91
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = r6.getClipEntry(r0)
            if (r7 != r1) goto L8e
        L8d:
            return r1
        L8e:
            r2 = r7
            androidx.compose.ui.platform.ClipEntry r2 = (androidx.compose.ui.platform.ClipEntry) r2
        L91:
            if (r2 == 0) goto L94
            r4 = r5
        L94:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.canPaste(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00be, code lost:
    
        if (r12.pasteAsPlainText(r0) != r1) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ca, code lost:
    
        if (pasteAsPlainText(r0) == r1) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object paste(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instructions count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.paste(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object pasteAsPlainText(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$pasteAsPlainText$1
            if (r0 == 0) goto L14
            r0 = r8
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$pasteAsPlainText$1 r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$pasteAsPlainText$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$pasteAsPlainText$1 r0 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$pasteAsPlainText$1
            r0.<init>(r7, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2e
            java.lang.Object r7 = r0.L$0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r7 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L49
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.compose.ui.platform.Clipboard r8 = r7.clipboard
            if (r8 == 0) goto L66
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r8.getClipEntry(r0)
            if (r8 != r1) goto L49
            return r1
        L49:
            androidx.compose.ui.platform.ClipEntry r8 = (androidx.compose.ui.platform.ClipEntry) r8
            if (r8 == 0) goto L66
            java.lang.String r8 = androidx.compose.foundation.internal.ClipboardUtils_androidKt.readText(r8)
            if (r8 != 0) goto L54
            goto L66
        L54:
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r0 = r7.textFieldState
            r1 = r8
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior r3 = androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior.NeverMerge
            r5 = 10
            r6 = 0
            r2 = 0
            r4 = 0
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState.replaceSelectedText$default(r0, r1, r2, r3, r4, r5, r6)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L66:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.pasteAsPlainText(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean canSelectAll() {
        return TextRange.m6431getLengthimpl(this.textFieldState.getVisualText().getSelection()) != this.textFieldState.getVisualText().length();
    }

    public final void selectAll() {
        this.textFieldState.selectAll();
    }

    public final boolean canAutofill() {
        return getEditable() && TextRange.m6429getCollapsedimpl(this.textFieldState.getVisualText().getSelection());
    }

    public final void autofill() {
        Function0<Unit> function0 = this.requestAutofillAction;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void deselect() {
        if (!TextRange.m6429getCollapsedimpl(this.textFieldState.getVisualText().getSelection())) {
            this.textFieldState.collapseSelectionToEnd();
        }
        setShowCursorHandle(false);
        updateTextToolbarState(TextToolbarState.None);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideTextToolbar() {
        TextToolbarHandler textToolbarHandler = this.textToolbarHandler;
        if (textToolbarHandler != null) {
            textToolbarHandler.hideTextToolbar();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: updateSelection-SsL-Rf8$default, reason: not valid java name */
    public static /* synthetic */ long m1688updateSelectionSsLRf8$default(TextFieldSelectionState textFieldSelectionState, TextFieldCharSequence textFieldCharSequence, int i, int i2, boolean z, SelectionAdjustment selectionAdjustment, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            z2 = false;
        }
        if ((i3 & 64) != 0) {
            z3 = false;
        }
        return textFieldSelectionState.m1687updateSelectionSsLRf8(textFieldCharSequence, i, i2, z, selectionAdjustment, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateSelection-SsL-Rf8, reason: not valid java name */
    public final long m1687updateSelectionSsLRf8(TextFieldCharSequence textFieldCharSequence, int startOffset, int endOffset, boolean isStartHandle, SelectionAdjustment adjustment, boolean allowPreviousSelectionCollapsed, boolean isStartOfSelection) {
        HapticFeedback hapticFeedback;
        TextRange m6423boximpl = TextRange.m6423boximpl(textFieldCharSequence.getSelection());
        long packedValue = m6423boximpl.getPackedValue();
        if (isStartOfSelection || (!allowPreviousSelectionCollapsed && TextRange.m6429getCollapsedimpl(packedValue))) {
            m6423boximpl = null;
        }
        long m1683getTextFieldSelectionqeG_v_k = m1683getTextFieldSelectionqeG_v_k(startOffset, endOffset, m6423boximpl, isStartHandle, adjustment);
        if (!TextRange.m6428equalsimpl0(m1683getTextFieldSelectionqeG_v_k, textFieldCharSequence.getSelection())) {
            boolean z = TextRange.m6434getReversedimpl(m1683getTextFieldSelectionqeG_v_k) != TextRange.m6434getReversedimpl(textFieldCharSequence.getSelection()) && TextRange.m6428equalsimpl0(TextRangeKt.TextRange(TextRange.m6430getEndimpl(m1683getTextFieldSelectionqeG_v_k), TextRange.m6435getStartimpl(m1683getTextFieldSelectionqeG_v_k)), textFieldCharSequence.getSelection());
            if (isInTouchMode() && !z && (hapticFeedback = this.hapticFeedBack) != null) {
                hapticFeedback.mo5106performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m5122getTextHandleMove5zf0vsI());
            }
        }
        return m1683getTextFieldSelectionqeG_v_k;
    }

    /* renamed from: getTextFieldSelection-qeG_v_k, reason: not valid java name */
    private final long m1683getTextFieldSelectionqeG_v_k(int rawStartOffset, int rawEndOffset, TextRange previousSelection, boolean isStartHandle, SelectionAdjustment adjustment) {
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextRange.INSTANCE.m6440getZerod9O1mEE();
        }
        if (previousSelection == null && Intrinsics.areEqual(adjustment, SelectionAdjustment.INSTANCE.getCharacter())) {
            return TextRangeKt.TextRange(rawStartOffset, rawEndOffset);
        }
        SelectionLayout m1774getTextFieldSelectionLayoutRcvTLA = SelectionLayoutKt.m1774getTextFieldSelectionLayoutRcvTLA(layoutResult, rawStartOffset, rawEndOffset, this.previousRawDragOffset, previousSelection != null ? previousSelection.getPackedValue() : TextRange.INSTANCE.m6440getZerod9O1mEE(), previousSelection == null, isStartHandle);
        if (previousSelection != null && !m1774getTextFieldSelectionLayoutRcvTLA.shouldRecomputeSelection(this.previousSelectionLayout)) {
            return previousSelection.getPackedValue();
        }
        long m1763toTextRanged9O1mEE = adjustment.adjust(m1774getTextFieldSelectionLayoutRcvTLA).m1763toTextRanged9O1mEE();
        this.previousSelectionLayout = m1774getTextFieldSelectionLayoutRcvTLA;
        this.previousRawDragOffset = isStartHandle ? rawStartOffset : rawEndOffset;
        return m1763toTextRanged9O1mEE;
    }
}
