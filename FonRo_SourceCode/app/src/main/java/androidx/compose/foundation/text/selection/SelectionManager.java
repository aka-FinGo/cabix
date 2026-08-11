package androidx.compose.foundation.text.selection;

import androidx.collection.LongIntMapKt;
import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongIntMap;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectionManager.kt */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010w\u001a\u00020\u00122\u0006\u0010x\u001a\u00020\u000b2\u0006\u0010y\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\bz\u0010{J\r\u0010|\u001a\u00020OH\u0000¢\u0006\u0002\b}J\u001a\u0010~\u001a\u0004\u0018\u00010\u007f2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0000¢\u0006\u0003\b\u0082\u0001J\f\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001H\u0002J\u0011\u0010\u0085\u0001\u001a\u0004\u0018\u00010NH\u0000¢\u0006\u0003\b\u0086\u0001J2\u0010\u0087\u0001\u001a\u0004\u0018\u00010Z2\u0007\u0010\u0088\u0001\u001a\u00020\u00122\u0007\u0010\u0089\u0001\u001a\u00020\u00122\u0007\u0010\u008a\u0001\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0011\u0010\u008d\u0001\u001a\u00030\u008e\u00012\u0007\u0010\u008a\u0001\u001a\u00020\u0007J\u000f\u0010\u008f\u0001\u001a\u00020\u0007H\u0000¢\u0006\u0003\b\u0090\u0001J\u000f\u0010\u0091\u0001\u001a\u00020\u0007H\u0000¢\u0006\u0003\b\u0092\u0001J\u000f\u0010\u0093\u0001\u001a\u00020\u0007H\u0000¢\u0006\u0003\b\u0094\u0001J\u0007\u0010\u0095\u0001\u001a\u00020OJ\u000f\u0010\u0096\u0001\u001a\u00020\u000bH\u0000¢\u0006\u0003\b\u0097\u0001J\u000f\u0010\u0098\u0001\u001a\u00020OH\u0000¢\u0006\u0003\b\u0099\u0001J:\u0010\u009a\u0001\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\t0\u009c\u00010\u009b\u00012\b\u0010\u009d\u0001\u001a\u00030\u009e\u00012\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0003\b \u0001J\u001b\u0010¡\u0001\u001a\u00020O2\u0007\u0010\u0088\u0001\u001a\u00020\u0012ø\u0001\u0000¢\u0006\u0005\b¢\u0001\u0010\u001eJ\u001b\u0010£\u0001\u001a\u00020O2\u0007\u0010¤\u0001\u001a\u00020Z2\u0007\u0010¥\u0001\u001a\u00020\tH\u0002J\u000f\u0010¦\u0001\u001a\u00020\u0007H\u0001¢\u0006\u0003\b§\u0001J1\u0010¨\u0001\u001a\u00020O2\u0007\u0010\u0088\u0001\u001a\u00020\u00122\u0007\u0010\u008a\u0001\u001a\u00020\u00072\b\u0010©\u0001\u001a\u00030ª\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\b«\u0001\u0010¬\u0001J\t\u0010\u00ad\u0001\u001a\u00020OH\u0002J\t\u0010®\u0001\u001a\u00020OH\u0002J:\u0010¯\u0001\u001a\u00020\u00072\u0007\u0010\u0088\u0001\u001a\u00020\u00122\u0007\u0010\u0089\u0001\u001a\u00020\u00122\u0007\u0010\u008a\u0001\u001a\u00020\u00072\b\u0010©\u0001\u001a\u00030ª\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b°\u0001\u0010±\u0001J;\u0010¯\u0001\u001a\u00020\u00072\t\u0010²\u0001\u001a\u0004\u0018\u00010\u00122\u0006\u0010X\u001a\u00020\u00122\u0007\u0010\u008a\u0001\u001a\u00020\u00072\b\u0010©\u0001\u001a\u00030ª\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b³\u0001\u0010´\u0001J\t\u0010µ\u0001\u001a\u00020OH\u0002J\u001d\u0010¶\u0001\u001a\u00020I*\u00020I2\u000e\u0010·\u0001\u001a\t\u0012\u0004\u0012\u00020O0¸\u0001H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R5\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R1\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128@@BX\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR1\u0010 \u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128@@BX\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b#\u0010\u0019\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR/\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\u0011\u001a\u0004\u0018\u00010$8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010\u0019\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0011\u0010+\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R5\u0010/\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b2\u0010\u0019\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017R\u001a\u00103\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R+\u0010?\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bD\u0010\u0019\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0014\u0010E\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010AR$\u0010F\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bF\u0010A\"\u0004\bG\u0010CR\u0011\u0010H\u001a\u00020I8F¢\u0006\u0006\u001a\u0004\bJ\u0010KR(\u0010L\u001a\u0010\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020O\u0018\u00010MX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR@\u0010U\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020O0M2\u0014\u0010T\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020O0M@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010Q\"\u0004\bW\u0010SR\u0016\u0010X\u001a\u0004\u0018\u00010\u0012X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R&\u0010Y\u001a\u0004\u0018\u00010Z8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R(\u0010a\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010f\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bg\u0010AR$\u0010h\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010A\"\u0004\bj\u0010CR\u0011\u0010k\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\bl\u0010.R5\u0010m\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bp\u0010\u0019\u001a\u0004\bn\u0010\u0015\"\u0004\bo\u0010\u0017R\u001c\u0010q\u001a\u0004\u0018\u00010rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010v\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¹\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionManager;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "(Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;)V", "_isInTouchMode", "Landroidx/compose/runtime/MutableState;", "", "_selection", "Landroidx/compose/foundation/text/selection/Selection;", "value", "Landroidx/compose/ui/layout/LayoutCoordinates;", "containerLayoutCoordinates", "getContainerLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setContainerLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "<set-?>", "Landroidx/compose/ui/geometry/Offset;", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "currentDragPosition$delegate", "Landroidx/compose/runtime/MutableState;", "dragBeginPosition", "getDragBeginPosition-F1C5BW0$foundation_release", "()J", "setDragBeginPosition-k-4lQ0M", "(J)V", "dragBeginPosition$delegate", "dragTotalDistance", "getDragTotalDistance-F1C5BW0$foundation_release", "setDragTotalDistance-k-4lQ0M", "dragTotalDistance$delegate", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "endHandleLineHeight", "", "getEndHandleLineHeight", "()F", "endHandlePosition", "getEndHandlePosition-_m7T9-E", "setEndHandlePosition-_kEHs6E", "endHandlePosition$delegate", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", "isDraggingInProgress", "isInTouchMode", "setInTouchMode", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "onCopyHandler", "Lkotlin/Function1;", "Landroidx/compose/ui/text/AnnotatedString;", "", "getOnCopyHandler", "()Lkotlin/jvm/functions/Function1;", "setOnCopyHandler", "(Lkotlin/jvm/functions/Function1;)V", "newOnSelectionChange", "onSelectionChange", "getOnSelectionChange", "setOnSelectionChange", "previousPosition", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "getPreviousSelectionLayout$foundation_release$annotations", "()V", "getPreviousSelectionLayout$foundation_release", "()Landroidx/compose/foundation/text/selection/SelectionLayout;", "setPreviousSelectionLayout$foundation_release", "(Landroidx/compose/foundation/text/selection/SelectionLayout;)V", "selection", "getSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "setSelection", "(Landroidx/compose/foundation/text/selection/Selection;)V", "shouldShowMagnifier", "getShouldShowMagnifier", "showToolbar", "getShowToolbar$foundation_release", "setShowToolbar$foundation_release", "startHandleLineHeight", "getStartHandleLineHeight", "startHandlePosition", "getStartHandlePosition-_m7T9-E", "setStartHandlePosition-_kEHs6E", "startHandlePosition$delegate", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "convertToContainerCoordinates", "layoutCoordinates", TypedValues.CycleType.S_WAVE_OFFSET, "convertToContainerCoordinates-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "copy", "copy$foundation_release", "getAnchorSelectable", "Landroidx/compose/foundation/text/selection/Selectable;", "anchor", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "getAnchorSelectable$foundation_release", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getSelectedText", "getSelectedText$foundation_release", "getSelectionLayout", "position", "previousHandlePosition", "isStartHandle", "getSelectionLayout-Wko1d7g", "(JJZ)Landroidx/compose/foundation/text/selection/SelectionLayout;", "handleDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "isEntireContainerSelected", "isEntireContainerSelected$foundation_release", "isNonEmptySelection", "isNonEmptySelection$foundation_release", "isTriviallyCollapsedSelection", "isTriviallyCollapsedSelection$foundation_release", "onRelease", "requireContainerCoordinates", "requireContainerCoordinates$foundation_release", "selectAll", "selectAll$foundation_release", "selectAllInSelectable", "Lkotlin/Pair;", "Landroidx/collection/LongObjectMap;", "selectableId", "", "previousSelection", "selectAllInSelectable$foundation_release", "selectWordAtPositionIfNotAlreadySelected", "selectWordAtPositionIfNotAlreadySelected-k-4lQ0M", "selectionChanged", "selectionLayout", "newSelection", "shouldPerformHaptics", "shouldPerformHaptics$foundation_release", "startSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "startSelection-9KIMszo", "(JZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)V", "toolbarCopy", "updateHandleOffsets", "updateSelection", "updateSelection-jyLRC_s$foundation_release", "(JJZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "newPosition", "updateSelection-qNKwrvQ$foundation_release", "(Landroidx/compose/ui/geometry/Offset;JZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "updateSelectionToolbar", "onClearSelectionRequested", "block", "Lkotlin/Function0;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SelectionManager {
    public static final int $stable = 8;
    private final MutableState<Boolean> _isInTouchMode;
    private final MutableState<Selection> _selection;
    private LayoutCoordinates containerLayoutCoordinates;

    /* renamed from: currentDragPosition$delegate, reason: from kotlin metadata */
    private final MutableState currentDragPosition;

    /* renamed from: dragBeginPosition$delegate, reason: from kotlin metadata */
    private final MutableState dragBeginPosition;

    /* renamed from: dragTotalDistance$delegate, reason: from kotlin metadata */
    private final MutableState dragTotalDistance;

    /* renamed from: draggingHandle$delegate, reason: from kotlin metadata */
    private final MutableState draggingHandle;

    /* renamed from: endHandlePosition$delegate, reason: from kotlin metadata */
    private final MutableState endHandlePosition;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;

    /* renamed from: hasFocus$delegate, reason: from kotlin metadata */
    private final MutableState hasFocus;
    private Function1<? super AnnotatedString, Unit> onCopyHandler;
    private Function1<? super Selection, Unit> onSelectionChange;
    private Offset previousPosition;
    private SelectionLayout previousSelectionLayout;
    private final SelectionRegistrarImpl selectionRegistrar;
    private boolean showToolbar;

    /* renamed from: startHandlePosition$delegate, reason: from kotlin metadata */
    private final MutableState startHandlePosition;
    private TextToolbar textToolbar;

    public static /* synthetic */ void getPreviousSelectionLayout$foundation_release$annotations() {
    }

    public SelectionManager(SelectionRegistrarImpl selectionRegistrarImpl) {
        MutableState<Selection> mutableStateOf$default;
        MutableState<Boolean> mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        MutableState mutableStateOf$default7;
        MutableState mutableStateOf$default8;
        MutableState mutableStateOf$default9;
        this.selectionRegistrar = selectionRegistrarImpl;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this._selection = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this._isInTouchMode = mutableStateOf$default2;
        this.onSelectionChange = new Function1<Selection, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$onSelectionChange$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Selection selection) {
                invoke2(selection);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Selection selection) {
                SelectionManager.this.setSelection(selection);
            }
        };
        this.focusRequester = new FocusRequester();
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.hasFocus = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m4114boximpl(Offset.INSTANCE.m4141getZeroF1C5BW0()), null, 2, null);
        this.dragBeginPosition = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m4114boximpl(Offset.INSTANCE.m4141getZeroF1C5BW0()), null, 2, null);
        this.dragTotalDistance = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.startHandlePosition = mutableStateOf$default6;
        mutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.endHandlePosition = mutableStateOf$default7;
        mutableStateOf$default8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggingHandle = mutableStateOf$default8;
        mutableStateOf$default9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition = mutableStateOf$default9;
        selectionRegistrarImpl.setOnPositionChangeCallback$foundation_release(new Function1<Long, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                if (SelectionManager.this.selectionRegistrar.getSubselections().containsKey(j)) {
                    SelectionManager.this.updateHandleOffsets();
                    SelectionManager.this.updateSelectionToolbar();
                }
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateStartCallback$foundation_release(new Function4<Boolean, LayoutCoordinates, Offset, SelectionAdjustment, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.2
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, LayoutCoordinates layoutCoordinates, Offset offset, SelectionAdjustment selectionAdjustment) {
                m1803invokeRg1IO4c(bool.booleanValue(), layoutCoordinates, offset.m4135unboximpl(), selectionAdjustment);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-Rg1IO4c, reason: not valid java name */
            public final void m1803invokeRg1IO4c(boolean z, LayoutCoordinates layoutCoordinates, long j, SelectionAdjustment selectionAdjustment) {
                long mo5740getSizeYbymL2g = layoutCoordinates.mo5740getSizeYbymL2g();
                Rect rect = new Rect(0.0f, 0.0f, (int) (mo5740getSizeYbymL2g >> 32), (int) (mo5740getSizeYbymL2g & 4294967295L));
                if (!SelectionManagerKt.m1807containsInclusiveUv8p0NA(rect, j)) {
                    j = TextLayoutStateKt.m1627coerceIn3MmeM6k(j, rect);
                }
                long m1787convertToContainerCoordinatesR5De75A = SelectionManager.this.m1787convertToContainerCoordinatesR5De75A(layoutCoordinates, j);
                if ((9223372034707292159L & m1787convertToContainerCoordinatesR5De75A) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    SelectionManager.this.setInTouchMode(z);
                    SelectionManager.this.m1794startSelection9KIMszo(m1787convertToContainerCoordinatesR5De75A, false, selectionAdjustment);
                    FocusRequester.m4036requestFocus3ESFkO8$default(SelectionManager.this.getFocusRequester(), 0, 1, null);
                    SelectionManager.this.setShowToolbar$foundation_release(false);
                }
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateSelectAll$foundation_release(new Function2<Boolean, Long, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Long l) {
                invoke(bool.booleanValue(), l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z, long j) {
                SelectionManager selectionManager = SelectionManager.this;
                Pair<Selection, LongObjectMap<Selection>> selectAllInSelectable$foundation_release = selectionManager.selectAllInSelectable$foundation_release(j, selectionManager.getSelection());
                Selection component1 = selectAllInSelectable$foundation_release.component1();
                LongObjectMap<Selection> component2 = selectAllInSelectable$foundation_release.component2();
                if (!Intrinsics.areEqual(component1, SelectionManager.this.getSelection())) {
                    SelectionManager.this.selectionRegistrar.setSubselections(component2);
                    SelectionManager.this.getOnSelectionChange().invoke(component1);
                }
                SelectionManager.this.setInTouchMode(z);
                FocusRequester.m4036requestFocus3ESFkO8$default(SelectionManager.this.getFocusRequester(), 0, 1, null);
                SelectionManager.this.setShowToolbar$foundation_release(false);
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateCallback$foundation_release(new Function6<Boolean, LayoutCoordinates, Offset, Offset, Boolean, SelectionAdjustment, Boolean>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.4
            {
                super(6);
            }

            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool, LayoutCoordinates layoutCoordinates, Offset offset, Offset offset2, Boolean bool2, SelectionAdjustment selectionAdjustment) {
                return m1804invokepGV3PM0(bool.booleanValue(), layoutCoordinates, offset.m4135unboximpl(), offset2.m4135unboximpl(), bool2.booleanValue(), selectionAdjustment);
            }

            /* renamed from: invoke-pGV3PM0, reason: not valid java name */
            public final Boolean m1804invokepGV3PM0(boolean z, LayoutCoordinates layoutCoordinates, long j, long j2, boolean z2, SelectionAdjustment selectionAdjustment) {
                long m1787convertToContainerCoordinatesR5De75A = SelectionManager.this.m1787convertToContainerCoordinatesR5De75A(layoutCoordinates, j);
                long m1787convertToContainerCoordinatesR5De75A2 = SelectionManager.this.m1787convertToContainerCoordinatesR5De75A(layoutCoordinates, j2);
                SelectionManager.this.setInTouchMode(z);
                return Boolean.valueOf(SelectionManager.this.m1802updateSelectionqNKwrvQ$foundation_release(Offset.m4114boximpl(m1787convertToContainerCoordinatesR5De75A), m1787convertToContainerCoordinatesR5De75A2, z2, selectionAdjustment));
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateEndCallback$foundation_release(new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SelectionManager.this.setShowToolbar$foundation_release(true);
                SelectionManager.this.setDraggingHandle(null);
                SelectionManager.this.m1789setCurrentDragPosition_kEHs6E(null);
            }
        });
        selectionRegistrarImpl.setOnSelectableChangeCallback$foundation_release(new Function1<Long, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                if (SelectionManager.this.selectionRegistrar.getSubselections().containsKey(j)) {
                    SelectionManager.this.onRelease();
                    SelectionManager.this.setSelection(null);
                }
            }
        });
        selectionRegistrarImpl.setAfterSelectableUnsubscribe$foundation_release(new Function1<Long, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                Selection.AnchorInfo end;
                Selection.AnchorInfo start;
                Selection selection = SelectionManager.this.getSelection();
                if (selection != null && (start = selection.getStart()) != null && j == start.getSelectableId()) {
                    SelectionManager.this.m1793setStartHandlePosition_kEHs6E(null);
                }
                Selection selection2 = SelectionManager.this.getSelection();
                if (selection2 != null && (end = selection2.getEnd()) != null && j == end.getSelectableId()) {
                    SelectionManager.this.m1792setEndHandlePosition_kEHs6E(null);
                }
                if (SelectionManager.this.selectionRegistrar.getSubselections().containsKey(j)) {
                    SelectionManager.this.updateSelectionToolbar();
                }
            }
        });
    }

    public final Selection getSelection() {
        return this._selection.getValue();
    }

    public final void setSelection(Selection selection) {
        this._selection.setValue(selection);
        if (selection != null) {
            updateHandleOffsets();
        }
    }

    public final boolean isInTouchMode() {
        return this._isInTouchMode.getValue().booleanValue();
    }

    public final void setInTouchMode(boolean z) {
        if (this._isInTouchMode.getValue().booleanValue() != z) {
            this._isInTouchMode.setValue(Boolean.valueOf(z));
            updateSelectionToolbar();
        }
    }

    public final Function1<Selection, Unit> getOnSelectionChange() {
        return this.onSelectionChange;
    }

    public final void setOnSelectionChange(final Function1<? super Selection, Unit> function1) {
        this.onSelectionChange = new Function1<Selection, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$onSelectionChange$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Selection selection) {
                invoke2(selection);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Selection selection) {
                SelectionManager.this.setSelection(selection);
                function1.invoke(selection);
            }
        };
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final Function1<AnnotatedString, Unit> getOnCopyHandler() {
        return this.onCopyHandler;
    }

    public final void setOnCopyHandler(Function1<? super AnnotatedString, Unit> function1) {
        this.onCopyHandler = function1;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final void setTextToolbar(TextToolbar textToolbar) {
        this.textToolbar = textToolbar;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final void setFocusRequester(FocusRequester focusRequester) {
        this.focusRequester = focusRequester;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus.getValue()).booleanValue();
    }

    public final void setHasFocus(boolean z) {
        this.hasFocus.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDraggingInProgress() {
        return getDraggingHandle() != null;
    }

    public final Modifier getModifier() {
        return KeyInputModifierKt.onKeyEvent(SelectionGesturesKt.updateSelectionTouchMode(FocusableKt.focusable$default(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(OnGloballyPositionedModifierKt.onGloballyPositioned(onClearSelectionRequested(Modifier.INSTANCE, new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SelectionManager.this.onRelease();
            }
        }), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                SelectionManager.this.setContainerLayoutCoordinates(layoutCoordinates);
            }
        }), this.focusRequester), new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                invoke2(focusState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FocusState focusState) {
                if (!focusState.getHasFocus() && SelectionManager.this.getHasFocus()) {
                    SelectionManager.this.onRelease();
                }
                SelectionManager.this.setHasFocus(focusState.getHasFocus());
            }
        }), false, null, 3, null), new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                SelectionManager.this.setInTouchMode(z);
            }
        }), new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m1805invokeZmokQxo(keyEvent.m5452unboximpl());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m1805invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean z;
                if (SelectionManager_androidKt.m1809isCopyKeyEventZmokQxo(keyEvent)) {
                    SelectionManager.this.copy$foundation_release();
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }).then(getShouldShowMagnifier() ? SelectionManager_androidKt.selectionMagnifier(Modifier.INSTANCE, this) : Modifier.INSTANCE);
    }

    public final LayoutCoordinates getContainerLayoutCoordinates() {
        return this.containerLayoutCoordinates;
    }

    public final void setContainerLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this.containerLayoutCoordinates = layoutCoordinates;
        if (!getHasFocus() || getSelection() == null) {
            return;
        }
        Offset m4114boximpl = layoutCoordinates != null ? Offset.m4114boximpl(LayoutCoordinatesKt.positionInWindow(layoutCoordinates)) : null;
        if (Intrinsics.areEqual(this.previousPosition, m4114boximpl)) {
            return;
        }
        this.previousPosition = m4114boximpl;
        updateHandleOffsets();
        updateSelectionToolbar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setDragBeginPosition-k-4lQ0M, reason: not valid java name */
    public final void m1790setDragBeginPositionk4lQ0M(long j) {
        this.dragBeginPosition.setValue(Offset.m4114boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getDragBeginPosition-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m1796getDragBeginPositionF1C5BW0$foundation_release() {
        return ((Offset) this.dragBeginPosition.getValue()).m4135unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setDragTotalDistance-k-4lQ0M, reason: not valid java name */
    public final void m1791setDragTotalDistancek4lQ0M(long j) {
        this.dragTotalDistance.setValue(Offset.m4114boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getDragTotalDistance-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m1797getDragTotalDistanceF1C5BW0$foundation_release() {
        return ((Offset) this.dragTotalDistance.getValue()).m4135unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setStartHandlePosition-_kEHs6E, reason: not valid java name */
    public final void m1793setStartHandlePosition_kEHs6E(Offset offset) {
        this.startHandlePosition.setValue(offset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getStartHandlePosition-_m7T9-E, reason: not valid java name */
    public final Offset m1799getStartHandlePosition_m7T9E() {
        return (Offset) this.startHandlePosition.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setEndHandlePosition-_kEHs6E, reason: not valid java name */
    public final void m1792setEndHandlePosition_kEHs6E(Offset offset) {
        this.endHandlePosition.setValue(offset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getEndHandlePosition-_m7T9-E, reason: not valid java name */
    public final Offset m1798getEndHandlePosition_m7T9E() {
        return (Offset) this.endHandlePosition.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle.setValue(handle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle.getValue();
    }

    public final float getStartHandleLineHeight() {
        Selectable anchorSelectable$foundation_release;
        Selection selection = getSelection();
        if (selection == null || (anchorSelectable$foundation_release = getAnchorSelectable$foundation_release(selection.getStart())) == null) {
            return 0.0f;
        }
        return anchorSelectable$foundation_release.getLineHeight(selection.getStart().getOffset());
    }

    public final float getEndHandleLineHeight() {
        Selectable anchorSelectable$foundation_release;
        Selection selection = getSelection();
        if (selection == null || (anchorSelectable$foundation_release = getAnchorSelectable$foundation_release(selection.getEnd())) == null) {
            return 0.0f;
        }
        return anchorSelectable$foundation_release.getLineHeight(selection.getEnd().getOffset());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    public final void m1789setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition.setValue(offset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getCurrentDragPosition-_m7T9-E, reason: not valid java name */
    public final Offset m1795getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition.getValue();
    }

    private final boolean getShouldShowMagnifier() {
        return isDraggingInProgress() && isInTouchMode() && !isTriviallyCollapsedSelection$foundation_release();
    }

    /* renamed from: getPreviousSelectionLayout$foundation_release, reason: from getter */
    public final SelectionLayout getPreviousSelectionLayout() {
        return this.previousSelectionLayout;
    }

    public final void setPreviousSelectionLayout$foundation_release(SelectionLayout selectionLayout) {
        this.previousSelectionLayout = selectionLayout;
    }

    public final Selectable getAnchorSelectable$foundation_release(Selection.AnchorInfo anchor) {
        return this.selectionRegistrar.getSelectableMap$foundation_release().get(anchor.getSelectableId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0078, code lost:
    
        if (androidx.compose.foundation.text.selection.SelectionManagerKt.m1807containsInclusiveUv8p0NA(r8, r13) == false) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void updateHandleOffsets() {
        /*
            r17 = this;
            r0 = r17
            androidx.compose.foundation.text.selection.Selection r1 = r0.getSelection()
            androidx.compose.ui.layout.LayoutCoordinates r2 = r0.containerLayoutCoordinates
            r3 = 0
            if (r1 == 0) goto L16
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r4 = r1.getStart()
            if (r4 == 0) goto L16
            androidx.compose.foundation.text.selection.Selectable r4 = r0.getAnchorSelectable$foundation_release(r4)
            goto L17
        L16:
            r4 = r3
        L17:
            if (r1 == 0) goto L24
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r5 = r1.getEnd()
            if (r5 == 0) goto L24
            androidx.compose.foundation.text.selection.Selectable r5 = r0.getAnchorSelectable$foundation_release(r5)
            goto L25
        L24:
            r5 = r3
        L25:
            if (r4 == 0) goto L2c
            androidx.compose.ui.layout.LayoutCoordinates r6 = r4.getLayoutCoordinates()
            goto L2d
        L2c:
            r6 = r3
        L2d:
            if (r5 == 0) goto L34
            androidx.compose.ui.layout.LayoutCoordinates r7 = r5.getLayoutCoordinates()
            goto L35
        L34:
            r7 = r3
        L35:
            if (r1 == 0) goto Lab
            if (r2 == 0) goto Lab
            boolean r8 = r2.isAttached()
            if (r8 == 0) goto Lab
            if (r6 != 0) goto L44
            if (r7 != 0) goto L44
            goto Lab
        L44:
            androidx.compose.ui.geometry.Rect r8 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r2)
            r9 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            r11 = 9223372034707292159(0x7fffffff7fffffff, double:NaN)
            if (r6 == 0) goto L7b
            r13 = 1
            long r13 = r4.mo1757getHandlePositiondBAh8RU(r1, r13)
            long r15 = r13 & r11
            int r4 = (r15 > r9 ? 1 : (r15 == r9 ? 0 : -1))
            if (r4 != 0) goto L60
            goto L7b
        L60:
            long r13 = r2.mo5741localPositionOfR5De75A(r6, r13)
            androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m4114boximpl(r13)
            long r13 = r4.m4135unboximpl()
            androidx.compose.foundation.text.Handle r6 = r0.getDraggingHandle()
            androidx.compose.foundation.text.Handle r15 = androidx.compose.foundation.text.Handle.SelectionStart
            if (r6 == r15) goto L7c
            boolean r6 = androidx.compose.foundation.text.selection.SelectionManagerKt.m1807containsInclusiveUv8p0NA(r8, r13)
            if (r6 == 0) goto L7b
            goto L7c
        L7b:
            r4 = r3
        L7c:
            r0.m1793setStartHandlePosition_kEHs6E(r4)
            if (r7 == 0) goto La7
            r4 = 0
            long r4 = r5.mo1757getHandlePositiondBAh8RU(r1, r4)
            long r11 = r11 & r4
            int r1 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r1 != 0) goto L8c
            goto La7
        L8c:
            long r1 = r2.mo5741localPositionOfR5De75A(r7, r4)
            androidx.compose.ui.geometry.Offset r1 = androidx.compose.ui.geometry.Offset.m4114boximpl(r1)
            long r4 = r1.m4135unboximpl()
            androidx.compose.foundation.text.Handle r2 = r0.getDraggingHandle()
            androidx.compose.foundation.text.Handle r6 = androidx.compose.foundation.text.Handle.SelectionEnd
            if (r2 == r6) goto La6
            boolean r2 = androidx.compose.foundation.text.selection.SelectionManagerKt.m1807containsInclusiveUv8p0NA(r8, r4)
            if (r2 == 0) goto La7
        La6:
            r3 = r1
        La7:
            r0.m1792setEndHandlePosition_kEHs6E(r3)
            return
        Lab:
            r0.m1793setStartHandlePosition_kEHs6E(r3)
            r0.m1792setEndHandlePosition_kEHs6E(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.updateHandleOffsets():void");
    }

    public final LayoutCoordinates requireContainerCoordinates$foundation_release() {
        LayoutCoordinates layoutCoordinates = this.containerLayoutCoordinates;
        if (layoutCoordinates != null) {
            if (!layoutCoordinates.isAttached()) {
                androidx.compose.foundation.internal.InlineClassHelperKt.throwIllegalArgumentException("unattached coordinates");
            }
            return layoutCoordinates;
        }
        androidx.compose.foundation.internal.InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null coordinates");
        throw new KotlinNothingValueException();
    }

    public final Pair<Selection, LongObjectMap<Selection>> selectAllInSelectable$foundation_release(long selectableId, Selection previousSelection) {
        HapticFeedback hapticFeedback;
        MutableLongObjectMap mutableLongObjectMapOf = LongObjectMapKt.mutableLongObjectMapOf();
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = sort.size();
        Selection selection = null;
        for (int i = 0; i < size; i++) {
            Selectable selectable = sort.get(i);
            Selection selectAllSelection = selectable.getSelectableId() == selectableId ? selectable.getSelectAllSelection() : null;
            if (selectAllSelection != null) {
                mutableLongObjectMapOf.set(selectable.getSelectableId(), selectAllSelection);
            }
            selection = SelectionManagerKt.merge(selection, selectAllSelection);
        }
        if (isInTouchMode() && !Intrinsics.areEqual(selection, previousSelection) && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.mo5106performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m5122getTextHandleMove5zf0vsI());
        }
        return new Pair<>(selection, mutableLongObjectMapOf);
    }

    public final boolean isEntireContainerSelected$foundation_release() {
        Selection selection;
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        if (sort.isEmpty()) {
            return true;
        }
        int size = sort.size();
        for (int i = 0; i < size; i++) {
            Selectable selectable = sort.get(i);
            AnnotatedString text = selectable.getText();
            if (text.length() != 0 && ((selection = this.selectionRegistrar.getSubselections().get(selectable.getSelectableId())) == null || Math.abs(selection.getStart().getOffset() - selection.getEnd().getOffset()) != text.length())) {
                return false;
            }
        }
        return true;
    }

    public final void selectAll$foundation_release() {
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        if (sort.isEmpty()) {
            return;
        }
        MutableLongObjectMap mutableLongObjectMapOf = LongObjectMapKt.mutableLongObjectMapOf();
        int size = sort.size();
        Selection selection = null;
        Selection selection2 = null;
        for (int i = 0; i < size; i++) {
            Selectable selectable = sort.get(i);
            Selection selectAllSelection = selectable.getSelectAllSelection();
            if (selectAllSelection != null) {
                if (selection == null) {
                    selection = selectAllSelection;
                }
                mutableLongObjectMapOf.put(selectable.getSelectableId(), selectAllSelection);
                selection2 = selectAllSelection;
            }
        }
        if (mutableLongObjectMapOf.isEmpty()) {
            return;
        }
        if (selection != selection2) {
            Intrinsics.checkNotNull(selection);
            Selection.AnchorInfo start = selection.getStart();
            Intrinsics.checkNotNull(selection2);
            selection = new Selection(start, selection2.getEnd(), false);
        }
        this.selectionRegistrar.setSubselections(mutableLongObjectMapOf);
        this.onSelectionChange.invoke(selection);
        this.previousSelectionLayout = null;
    }

    public final boolean isTriviallyCollapsedSelection$foundation_release() {
        Selection selection = getSelection();
        if (selection == null) {
            return true;
        }
        return Intrinsics.areEqual(selection.getStart(), selection.getEnd());
    }

    public final boolean isNonEmptySelection$foundation_release() {
        Selection selection = getSelection();
        if (selection == null || Intrinsics.areEqual(selection.getStart(), selection.getEnd())) {
            return false;
        }
        if (selection.getStart().getSelectableId() == selection.getEnd().getSelectableId()) {
            return true;
        }
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = sort.size();
        for (int i = 0; i < size; i++) {
            Selection selection2 = this.selectionRegistrar.getSubselections().get(sort.get(i).getSelectableId());
            if (selection2 != null && selection2.getStart().getOffset() != selection2.getEnd().getOffset()) {
                return true;
            }
        }
        return false;
    }

    public final AnnotatedString getSelectedText$foundation_release() {
        AnnotatedString subSequence;
        if (getSelection() == null || this.selectionRegistrar.getSubselections().isEmpty()) {
            return null;
        }
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = sort.size();
        for (int i = 0; i < size; i++) {
            Selectable selectable = sort.get(i);
            Selection selection = this.selectionRegistrar.getSubselections().get(selectable.getSelectableId());
            if (selection != null) {
                AnnotatedString text = selectable.getText();
                if (selection.getHandlesCrossed()) {
                    subSequence = text.subSequence(selection.getEnd().getOffset(), selection.getStart().getOffset());
                } else {
                    subSequence = text.subSequence(selection.getStart().getOffset(), selection.getEnd().getOffset());
                }
                builder.append(subSequence);
            }
        }
        return builder.toAnnotatedString();
    }

    public final void copy$foundation_release() {
        Function1<? super AnnotatedString, Unit> function1;
        AnnotatedString selectedText$foundation_release = getSelectedText$foundation_release();
        if (selectedText$foundation_release != null) {
            if (selectedText$foundation_release.length() <= 0) {
                selectedText$foundation_release = null;
            }
            if (selectedText$foundation_release == null || (function1 = this.onCopyHandler) == null) {
                return;
            }
            function1.invoke(selectedText$foundation_release);
        }
    }

    /* renamed from: getShowToolbar$foundation_release, reason: from getter */
    public final boolean getShowToolbar() {
        return this.showToolbar;
    }

    public final void setShowToolbar$foundation_release(boolean z) {
        this.showToolbar = z;
        updateSelectionToolbar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toolbarCopy() {
        copy$foundation_release();
        onRelease();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectionToolbar() {
        TextToolbar textToolbar;
        if (getHasFocus() && (textToolbar = this.textToolbar) != null) {
            if (this.showToolbar && isInTouchMode()) {
                Rect contentRect = getContentRect();
                if (contentRect == null) {
                    return;
                }
                TextToolbar.showMenu$default(textToolbar, contentRect, isNonEmptySelection$foundation_release() ? new SelectionManager$updateSelectionToolbar$1(this) : null, null, null, isEntireContainerSelected$foundation_release() ? null : new SelectionManager$updateSelectionToolbar$2(this), null, 12, null);
                return;
            }
            if (textToolbar.getStatus() == TextToolbarStatus.Shown) {
                textToolbar.hide();
            }
        }
    }

    private final Rect getContentRect() {
        LayoutCoordinates layoutCoordinates;
        List firstAndLast;
        Rect rect;
        if (getSelection() == null || (layoutCoordinates = this.containerLayoutCoordinates) == null || !layoutCoordinates.isAttached()) {
            return null;
        }
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        ArrayList arrayList = new ArrayList(sort.size());
        int size = sort.size();
        for (int i = 0; i < size; i++) {
            Selectable selectable = sort.get(i);
            Selection selection = this.selectionRegistrar.getSubselections().get(selectable.getSelectableId());
            Pair pair = selection != null ? TuplesKt.to(selectable, selection) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        firstAndLast = SelectionManagerKt.firstAndLast(arrayList);
        if (firstAndLast.isEmpty()) {
            return null;
        }
        Rect selectedRegionRect = SelectionManagerKt.getSelectedRegionRect(firstAndLast, layoutCoordinates);
        rect = SelectionManagerKt.invertedInfiniteRect;
        if (Intrinsics.areEqual(selectedRegionRect, rect)) {
            return null;
        }
        Rect intersect = SelectionManagerKt.visibleBounds(layoutCoordinates).intersect(selectedRegionRect);
        if (intersect.getRight() - intersect.getLeft() < 0.0f || intersect.getBottom() - intersect.getTop() < 0.0f) {
            return null;
        }
        Rect m4162translatek4lQ0M = intersect.m4162translatek4lQ0M(LayoutCoordinatesKt.positionInRoot(layoutCoordinates));
        return Rect.copy$default(m4162translatek4lQ0M, 0.0f, 0.0f, 0.0f, m4162translatek4lQ0M.getBottom() + (SelectionHandlesKt.getHandleHeight() * 4.0f), 7, null);
    }

    public final void onRelease() {
        HapticFeedback hapticFeedback;
        this.selectionRegistrar.setSubselections(LongObjectMapKt.emptyLongObjectMap());
        setShowToolbar$foundation_release(false);
        if (getSelection() != null) {
            this.onSelectionChange.invoke(null);
            if (!isInTouchMode() || (hapticFeedback = this.hapticFeedBack) == null) {
                return;
            }
            hapticFeedback.mo5106performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m5122getTextHandleMove5zf0vsI());
        }
    }

    public final TextDragObserver handleDragObserver(final boolean isStartHandle) {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.SelectionManager$handleDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo1455onDownk4lQ0M(long point) {
                LayoutCoordinates layoutCoordinates;
                boolean z = isStartHandle;
                SelectionManager selectionManager = this;
                Offset m1799getStartHandlePosition_m7T9E = z ? selectionManager.m1799getStartHandlePosition_m7T9E() : selectionManager.m1798getEndHandlePosition_m7T9E();
                if (m1799getStartHandlePosition_m7T9E != null) {
                    m1799getStartHandlePosition_m7T9E.m4135unboximpl();
                    Selection selection = this.getSelection();
                    if (selection == null) {
                        return;
                    }
                    Selectable anchorSelectable$foundation_release = this.getAnchorSelectable$foundation_release(isStartHandle ? selection.getStart() : selection.getEnd());
                    if (anchorSelectable$foundation_release == null || (layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates()) == null) {
                        return;
                    }
                    long mo1757getHandlePositiondBAh8RU = anchorSelectable$foundation_release.mo1757getHandlePositiondBAh8RU(selection, isStartHandle);
                    if ((9223372034707292159L & mo1757getHandlePositiondBAh8RU) == InlineClassHelperKt.UnspecifiedPackedFloats) {
                        return;
                    }
                    long m1771getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m1771getAdjustedCoordinatesk4lQ0M(mo1757getHandlePositiondBAh8RU);
                    SelectionManager selectionManager2 = this;
                    selectionManager2.m1789setCurrentDragPosition_kEHs6E(Offset.m4114boximpl(selectionManager2.requireContainerCoordinates$foundation_release().mo5741localPositionOfR5De75A(layoutCoordinates, m1771getAdjustedCoordinatesk4lQ0M)));
                    this.setDraggingHandle(isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
                    this.setShowToolbar$foundation_release(false);
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo1457onStartk4lQ0M(long startPoint) {
                if (this.getDraggingHandle() == null) {
                    return;
                }
                Selection selection = this.getSelection();
                Intrinsics.checkNotNull(selection);
                Selectable selectable = this.selectionRegistrar.getSelectableMap$foundation_release().get((isStartHandle ? selection.getStart() : selection.getEnd()).getSelectableId());
                if (selectable != null) {
                    Selectable selectable2 = selectable;
                    LayoutCoordinates layoutCoordinates = selectable2.getLayoutCoordinates();
                    if (layoutCoordinates != null) {
                        long mo1757getHandlePositiondBAh8RU = selectable2.mo1757getHandlePositiondBAh8RU(selection, isStartHandle);
                        if ((9223372034707292159L & mo1757getHandlePositiondBAh8RU) == InlineClassHelperKt.UnspecifiedPackedFloats) {
                            return;
                        }
                        long m1771getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m1771getAdjustedCoordinatesk4lQ0M(mo1757getHandlePositiondBAh8RU);
                        SelectionManager selectionManager = this;
                        selectionManager.m1790setDragBeginPositionk4lQ0M(selectionManager.requireContainerCoordinates$foundation_release().mo5741localPositionOfR5De75A(layoutCoordinates, m1771getAdjustedCoordinatesk4lQ0M));
                        this.m1791setDragTotalDistancek4lQ0M(Offset.INSTANCE.m4141getZeroF1C5BW0());
                        return;
                    }
                    androidx.compose.foundation.internal.InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Current selectable should have layout coordinates.");
                    throw new KotlinNothingValueException();
                }
                androidx.compose.foundation.internal.InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("SelectionRegistrar should contain the current selection's selectableIds");
                throw new KotlinNothingValueException();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo1456onDragk4lQ0M(long delta) {
                if (this.getDraggingHandle() == null) {
                    return;
                }
                SelectionManager selectionManager = this;
                selectionManager.m1791setDragTotalDistancek4lQ0M(Offset.m4130plusMKHz9U(selectionManager.m1797getDragTotalDistanceF1C5BW0$foundation_release(), delta));
                long m4130plusMKHz9U = Offset.m4130plusMKHz9U(this.m1796getDragBeginPositionF1C5BW0$foundation_release(), this.m1797getDragTotalDistanceF1C5BW0$foundation_release());
                if (this.m1802updateSelectionqNKwrvQ$foundation_release(Offset.m4114boximpl(m4130plusMKHz9U), this.m1796getDragBeginPositionF1C5BW0$foundation_release(), isStartHandle, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate())) {
                    this.m1790setDragBeginPositionk4lQ0M(m4130plusMKHz9U);
                    this.m1791setDragTotalDistancek4lQ0M(Offset.INSTANCE.m4141getZeroF1C5BW0());
                }
            }

            private final void done() {
                this.setShowToolbar$foundation_release(true);
                this.setDraggingHandle(null);
                this.m1789setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                done();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                done();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
                done();
            }
        };
    }

    private final Modifier onClearSelectionRequested(Modifier modifier, final Function0<Unit> function0) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, Unit.INSTANCE, new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.selection.SelectionManager$onClearSelectionRequested$1

            /* compiled from: SelectionManager.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionManager$onClearSelectionRequested$1$1", f = "SelectionManager.kt", i = {0}, l = {754, 760}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"})
            /* renamed from: androidx.compose.foundation.text.selection.SelectionManager$onClearSelectionRequested$1$1, reason: invalid class name */
            /* loaded from: classes.dex */
            static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function0<Unit> $block;
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ SelectionManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(SelectionManager selectionManager, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = selectionManager;
                    this.$block = function0;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$block, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
                
                    if (r11 == r0) goto L16;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                    /*
                        r10 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r10.label
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L23
                        if (r1 == r3) goto L1b
                        if (r1 != r2) goto L12
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto L51
                    L12:
                        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                        java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                        r10.<init>(r11)
                        throw r10
                    L1b:
                        java.lang.Object r1 = r10.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto L3e
                    L23:
                        kotlin.ResultKt.throwOnFailure(r11)
                        java.lang.Object r11 = r10.L$0
                        r4 = r11
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
                        r7 = r10
                        kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                        r10.L$0 = r4
                        r10.label = r3
                        r5 = 0
                        r6 = 0
                        r8 = 2
                        r9 = 0
                        java.lang.Object r11 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitPrimaryFirstDown$default(r4, r5, r6, r7, r8, r9)
                        if (r11 != r0) goto L3d
                        goto L50
                    L3d:
                        r1 = r4
                    L3e:
                        androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
                        androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                        r4 = r10
                        kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                        r5 = 0
                        r10.L$0 = r5
                        r10.label = r2
                        java.lang.Object r11 = androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitAllPointersUpWithSlopDetection(r1, r11, r3, r4)
                        if (r11 != r0) goto L51
                    L50:
                        return r0
                    L51:
                        java.lang.Boolean r11 = (java.lang.Boolean) r11
                        boolean r11 = r11.booleanValue()
                        if (r11 != 0) goto L66
                        androidx.compose.foundation.text.selection.SelectionManager r11 = r10.this$0
                        boolean r11 = androidx.compose.foundation.text.selection.SelectionManager.access$isDraggingInProgress(r11)
                        if (r11 != 0) goto L66
                        kotlin.jvm.functions.Function0<kotlin.Unit> r10 = r10.$block
                        r10.invoke()
                    L66:
                        kotlin.Unit r10 = kotlin.Unit.INSTANCE
                        return r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager$onClearSelectionRequested$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass1(SelectionManager.this, function0, null), continuation);
                return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: convertToContainerCoordinates-R5De75A, reason: not valid java name */
    public final long m1787convertToContainerCoordinatesR5De75A(LayoutCoordinates layoutCoordinates, long offset) {
        LayoutCoordinates layoutCoordinates2 = this.containerLayoutCoordinates;
        if (layoutCoordinates2 == null || !layoutCoordinates2.isAttached()) {
            return Offset.INSTANCE.m4140getUnspecifiedF1C5BW0();
        }
        return requireContainerCoordinates$foundation_release().mo5741localPositionOfR5De75A(layoutCoordinates, offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startSelection-9KIMszo, reason: not valid java name */
    public final void m1794startSelection9KIMszo(long position, boolean isStartHandle, SelectionAdjustment adjustment) {
        this.previousSelectionLayout = null;
        m1801updateSelectionjyLRC_s$foundation_release(position, Offset.INSTANCE.m4140getUnspecifiedF1C5BW0(), isStartHandle, adjustment);
    }

    /* renamed from: updateSelection-qNKwrvQ$foundation_release, reason: not valid java name */
    public final boolean m1802updateSelectionqNKwrvQ$foundation_release(Offset newPosition, long previousPosition, boolean isStartHandle, SelectionAdjustment adjustment) {
        if (newPosition == null) {
            return false;
        }
        return m1801updateSelectionjyLRC_s$foundation_release(newPosition.m4135unboximpl(), previousPosition, isStartHandle, adjustment);
    }

    /* renamed from: updateSelection-jyLRC_s$foundation_release, reason: not valid java name */
    public final boolean m1801updateSelectionjyLRC_s$foundation_release(long position, long previousHandlePosition, boolean isStartHandle, SelectionAdjustment adjustment) {
        setDraggingHandle(isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
        m1789setCurrentDragPosition_kEHs6E(Offset.m4114boximpl(position));
        SelectionLayout m1788getSelectionLayoutWko1d7g = m1788getSelectionLayoutWko1d7g(position, previousHandlePosition, isStartHandle);
        if (m1788getSelectionLayoutWko1d7g == null || !m1788getSelectionLayoutWko1d7g.shouldRecomputeSelection(this.previousSelectionLayout)) {
            return false;
        }
        Selection adjust = adjustment.adjust(m1788getSelectionLayoutWko1d7g);
        if (!Intrinsics.areEqual(adjust, getSelection())) {
            selectionChanged(m1788getSelectionLayoutWko1d7g, adjust);
        }
        this.previousSelectionLayout = m1788getSelectionLayoutWko1d7g;
        return true;
    }

    /* renamed from: getSelectionLayout-Wko1d7g, reason: not valid java name */
    private final SelectionLayout m1788getSelectionLayoutWko1d7g(long position, long previousHandlePosition, boolean isStartHandle) {
        LayoutCoordinates requireContainerCoordinates$foundation_release = requireContainerCoordinates$foundation_release();
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release);
        final MutableLongIntMap mutableLongIntMapOf = LongIntMapKt.mutableLongIntMapOf();
        List<Selectable> list = sort;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mutableLongIntMapOf.set(sort.get(i).getSelectableId(), i);
        }
        SelectionLayoutBuilder selectionLayoutBuilder = new SelectionLayoutBuilder(position, previousHandlePosition, requireContainerCoordinates$foundation_release, isStartHandle, (previousHandlePosition & 9223372034707292159L) == InlineClassHelperKt.UnspecifiedPackedFloats ? null : getSelection(), new Comparator() { // from class: androidx.compose.foundation.text.selection.SelectionManager$getSelectionLayout-Wko1d7g$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(MutableLongIntMap.this.get(((Number) t).longValue())), Integer.valueOf(MutableLongIntMap.this.get(((Number) t2).longValue())));
            }
        }, null);
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            sort.get(i2).appendSelectableInfoToBuilder(selectionLayoutBuilder);
        }
        return selectionLayoutBuilder.build();
    }

    private final void selectionChanged(SelectionLayout selectionLayout, Selection newSelection) {
        HapticFeedback hapticFeedback;
        if (shouldPerformHaptics$foundation_release() && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.mo5106performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m5122getTextHandleMove5zf0vsI());
        }
        this.selectionRegistrar.setSubselections(selectionLayout.createSubSelections(newSelection));
        this.onSelectionChange.invoke(newSelection);
    }

    public final boolean shouldPerformHaptics$foundation_release() {
        if (isInTouchMode()) {
            List<Selectable> selectables$foundation_release = this.selectionRegistrar.getSelectables$foundation_release();
            int size = selectables$foundation_release.size();
            for (int i = 0; i < size; i++) {
                if (selectables$foundation_release.get(i).getText().length() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0058 A[LOOP:0: B:8:0x001b->B:13:0x0058, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0057 A[SYNTHETIC] */
    /* renamed from: selectWordAtPositionIfNotAlreadySelected-k-4lQ0M, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m1800selectWordAtPositionIfNotAlreadySelectedk4lQ0M(long r12) {
        /*
            r11 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r11.containerLayoutCoordinates
            if (r0 != 0) goto L5
            goto Lb
        L5:
            boolean r1 = r0.isAttached()
            if (r1 != 0) goto Lc
        Lb:
            return
        Lc:
            androidx.compose.foundation.text.selection.SelectionRegistrarImpl r1 = r11.selectionRegistrar
            java.util.List r1 = r1.getSelectables$foundation_release()
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            int r2 = r2.size()
            r3 = 0
            r4 = r3
        L1b:
            if (r4 >= r2) goto L5b
            java.lang.Object r5 = r1.get(r4)
            androidx.compose.foundation.text.selection.Selectable r5 = (androidx.compose.foundation.text.selection.Selectable) r5
            androidx.compose.foundation.text.selection.SelectionRegistrarImpl r6 = r11.selectionRegistrar
            androidx.collection.LongObjectMap r6 = r6.getSubselections()
            long r7 = r5.getSelectableId()
            java.lang.Object r6 = r6.get(r7)
            androidx.compose.foundation.text.selection.Selection r6 = (androidx.compose.foundation.text.selection.Selection) r6
            if (r6 != 0) goto L37
        L35:
            r5 = r3
            goto L55
        L37:
            androidx.compose.ui.layout.LayoutCoordinates r7 = r5.getLayoutCoordinates()
            if (r7 != 0) goto L3e
            goto L35
        L3e:
            long r7 = r7.mo5741localPositionOfR5De75A(r0, r12)
            androidx.compose.ui.text.TextLayoutResult r5 = r5.textLayoutResult()
            if (r5 != 0) goto L49
            goto L35
        L49:
            long r9 = r6.m1763toTextRanged9O1mEE()
            androidx.compose.ui.text.TextRange r6 = androidx.compose.ui.text.TextRange.m6423boximpl(r9)
            boolean r5 = androidx.compose.foundation.text.TextLayoutHelperKt.m1486isPositionInsideSelectionuaM50fQ(r5, r7, r6)
        L55:
            if (r5 == 0) goto L58
            return
        L58:
            int r4 = r4 + 1
            goto L1b
        L5b:
            androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r0 = androidx.compose.foundation.text.selection.SelectionAdjustment.INSTANCE
            androidx.compose.foundation.text.selection.SelectionAdjustment r0 = r0.getWord()
            r1 = 1
            r11.m1794startSelection9KIMszo(r12, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.m1800selectWordAtPositionIfNotAlreadySelectedk4lQ0M(long):void");
    }
}
