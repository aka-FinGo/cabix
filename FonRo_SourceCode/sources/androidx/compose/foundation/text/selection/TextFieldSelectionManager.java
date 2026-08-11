package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursor_androidKt;
import androidx.compose.foundation.text.TextLayoutHelperKt;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.ValidatingOffsetMappingKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: TextFieldSelectionManager.kt */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\r\u0010|\u001a\u00020LH\u0000¢\u0006\u0002\b}J\r\u0010~\u001a\u00020LH\u0000¢\u0006\u0002\b\u007fJ\u001d\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u00012\t\b\u0002\u0010\u0082\u0001\u001a\u00020'H\u0000¢\u0006\u0003\b\u0083\u0001J(\u0010\u0084\u0001\u001a\u00020I2\u0007\u0010\u0085\u0001\u001a\u00020k2\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u000f\u0010\u008a\u0001\u001a\u00020gH\u0000¢\u0006\u0003\b\u008b\u0001J\u0012\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0000¢\u0006\u0003\b\u008d\u0001J\u001f\u0010\u008e\u0001\u001a\u00020L2\u000b\b\u0002\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0012H\u0000ø\u0001\u0000¢\u0006\u0003\b\u0090\u0001J\u001a\u0010\u0091\u0001\u001a\u00020L2\t\b\u0002\u0010\u0092\u0001\u001a\u00020'H\u0000¢\u0006\u0003\b\u0093\u0001J\u000f\u0010\u0094\u0001\u001a\u00020LH\u0000¢\u0006\u0003\b\u0095\u0001J\n\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0002J\"\u0010\u0098\u0001\u001a\u00020\u00122\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J\u0019\u0010\u009d\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020'H\u0000¢\u0006\u0003\b \u0001J!\u0010¡\u0001\u001a\u00020\u00122\u0007\u0010\u009f\u0001\u001a\u00020'H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u0018\u0010¤\u0001\u001a\u00020g2\u0007\u0010\u009f\u0001\u001a\u00020'H\u0000¢\u0006\u0003\b¥\u0001J\u000f\u0010¦\u0001\u001a\u00020LH\u0000¢\u0006\u0003\b§\u0001J\u000f\u0010¨\u0001\u001a\u00020'H\u0000¢\u0006\u0003\b©\u0001J\u0012\u0010ª\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0000¢\u0006\u0003\b«\u0001J\u000f\u0010¬\u0001\u001a\u00020LH\u0000¢\u0006\u0003\b\u00ad\u0001J\u001c\u0010®\u0001\u001a\u00020L2\u0007\u0010\u008f\u0001\u001a\u00020\u0012ø\u0001\u0000¢\u0006\u0006\b¯\u0001\u0010°\u0001J\u001f\u0010±\u0001\u001a\u00020L2\b\u0010²\u0001\u001a\u00030\u0087\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b³\u0001\u0010°\u0001J\u0013\u0010´\u0001\u001a\u00020L2\b\u0010µ\u0001\u001a\u00030¶\u0001H\u0002J\u001f\u0010·\u0001\u001a\u00020L2\b\u0010²\u0001\u001a\u00030\u0087\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b¸\u0001\u0010°\u0001J\u0012\u0010¹\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0000¢\u0006\u0003\bº\u0001J\u0012\u0010»\u0001\u001a\u00020L2\u0007\u0010¼\u0001\u001a\u00020'H\u0002JL\u0010½\u0001\u001a\u00030\u0087\u00012\u0006\u0010p\u001a\u00020I2\u0007\u0010¾\u0001\u001a\u00020\u00122\u0007\u0010¿\u0001\u001a\u00020'2\u0007\u0010\u009f\u0001\u001a\u00020'2\b\u0010À\u0001\u001a\u00030Á\u00012\u0007\u0010Â\u0001\u001a\u00020'H\u0002ø\u0001\u0000¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R5\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u0012X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u0012X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001eR/\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u0011\u001a\u0004\u0018\u00010 8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0019\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R+\u0010(\u001a\u00020'2\u0006\u0010\u0011\u001a\u00020'8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010\u0019\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R+\u0010.\u001a\u00020'2\u0006\u0010\u0011\u001a\u00020'8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0019\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020?X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020CX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020IX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010J\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020L0KX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u000e\u0010Q\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010T\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010UX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001c\u0010Z\u001a\u0004\u0018\u00010[X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001c\u0010`\u001a\u0004\u0018\u00010aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0014\u0010f\u001a\u00020gX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0016\u0010j\u001a\u0004\u0018\u00010k8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR+\u0010p\u001a\u00020I2\u0006\u0010\u0011\u001a\u00020I8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bu\u0010\u0019\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001a\u0010v\u001a\u00020wX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Å\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "(Landroidx/compose/foundation/text/UndoManager;)V", "clipboard", "Landroidx/compose/ui/platform/Clipboard;", "getClipboard$foundation_release", "()Landroidx/compose/ui/platform/Clipboard;", "setClipboard$foundation_release", "(Landroidx/compose/ui/platform/Clipboard;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$foundation_release", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope$foundation_release", "(Lkotlinx/coroutines/CoroutineScope;)V", "<set-?>", "Landroidx/compose/ui/geometry/Offset;", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "currentDragPosition$delegate", "Landroidx/compose/runtime/MutableState;", "dragBeginOffsetInText", "", "Ljava/lang/Integer;", "dragBeginPosition", "J", "dragTotalDistance", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "", "editable", "getEditable", "()Z", "setEditable", "(Z)V", "editable$delegate", "enabled", "getEnabled", "setEnabled", "enabled$delegate", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "getMouseSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "getOffsetMapping$foundation_release", "()Landroidx/compose/ui/text/input/OffsetMapping;", "setOffsetMapping$foundation_release", "(Landroidx/compose/ui/text/input/OffsetMapping;)V", "oldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "", "getOnValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "previousRawDragOffset", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "requestAutofillAction", "Lkotlin/Function0;", "getRequestAutofillAction$foundation_release", "()Lkotlin/jvm/functions/Function0;", "setRequestAutofillAction$foundation_release", "(Lkotlin/jvm/functions/Function0;)V", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "getState$foundation_release", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "setState$foundation_release", "(Landroidx/compose/foundation/text/LegacyTextFieldState;)V", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "touchSelectionObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "getTouchSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/TextDragObserver;", "transformedText", "Landroidx/compose/ui/text/AnnotatedString;", "getTransformedText$foundation_release", "()Landroidx/compose/ui/text/AnnotatedString;", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "value", "getValue$foundation_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue$foundation_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "value$delegate", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation$foundation_release", "()Landroidx/compose/ui/text/input/VisualTransformation;", "setVisualTransformation$foundation_release", "(Landroidx/compose/ui/text/input/VisualTransformation;)V", "autofill", "autofill$foundation_release", "clearPreviewHighlight", "clearPreviewHighlight$foundation_release", "copy", "Lkotlinx/coroutines/Job;", "cancelSelection", "copy$foundation_release", "createTextFieldValue", "annotatedString", "selection", "Landroidx/compose/ui/text/TextRange;", "createTextFieldValue-FDrldGo", "(Landroidx/compose/ui/text/AnnotatedString;J)Landroidx/compose/ui/text/input/TextFieldValue;", "cursorDragObserver", "cursorDragObserver$foundation_release", "cut", "cut$foundation_release", "deselect", "position", "deselect-_kEHs6E$foundation_release", "enterSelectionMode", "showFloatingToolbar", "enterSelectionMode$foundation_release", "exitSelectionMode", "exitSelectionMode$foundation_release", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getCursorPosition", "density", "Landroidx/compose/ui/unit/Density;", "getCursorPosition-tuRUvjQ$foundation_release", "(Landroidx/compose/ui/unit/Density;)J", "getHandleLineHeight", "", "isStartHandle", "getHandleLineHeight$foundation_release", "getHandlePosition", "getHandlePosition-tuRUvjQ$foundation_release", "(Z)J", "handleDragObserver", "handleDragObserver$foundation_release", "hideSelectionToolbar", "hideSelectionToolbar$foundation_release", "isTextChanged", "isTextChanged$foundation_release", "paste", "paste$foundation_release", "selectAll", "selectAll$foundation_release", "selectWordAtPositionIfNotAlreadySelected", "selectWordAtPositionIfNotAlreadySelected-k-4lQ0M", "(J)V", "setDeletionPreviewHighlight", "range", "setDeletionPreviewHighlight-5zc-tL8$foundation_release", "setHandleState", "handleState", "Landroidx/compose/foundation/text/HandleState;", "setSelectionPreviewHighlight", "setSelectionPreviewHighlight-5zc-tL8$foundation_release", "showSelectionToolbar", "showSelectionToolbar$foundation_release", "updateFloatingToolbar", "show", "updateSelection", "currentPosition", "isStartOfSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "isTouchBasedSelection", "updateSelection-8UEBfa8", "(Landroidx/compose/ui/text/input/TextFieldValue;JZZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldSelectionManager {
    public static final int $stable = 8;
    private Clipboard clipboard;
    private CoroutineScope coroutineScope;

    /* renamed from: currentDragPosition$delegate, reason: from kotlin metadata */
    private final MutableState currentDragPosition;
    private Integer dragBeginOffsetInText;
    private long dragBeginPosition;
    private long dragTotalDistance;

    /* renamed from: draggingHandle$delegate, reason: from kotlin metadata */
    private final MutableState draggingHandle;

    /* renamed from: editable$delegate, reason: from kotlin metadata */
    private final MutableState editable;

    /* renamed from: enabled$delegate, reason: from kotlin metadata */
    private final MutableState enabled;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;
    private final MouseSelectionObserver mouseSelectionObserver;
    private OffsetMapping offsetMapping;
    private TextFieldValue oldValue;
    private Function1<? super TextFieldValue, Unit> onValueChange;
    private int previousRawDragOffset;
    private SelectionLayout previousSelectionLayout;
    private Function0<Unit> requestAutofillAction;
    private LegacyTextFieldState state;
    private TextToolbar textToolbar;
    private final TextDragObserver touchSelectionObserver;
    private final UndoManager undoManager;

    /* renamed from: value$delegate, reason: from kotlin metadata */
    private final MutableState value;
    private VisualTransformation visualTransformation;

    /* JADX WARN: Multi-variable type inference failed */
    public TextFieldSelectionManager() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public TextFieldSelectionManager(UndoManager undoManager) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        this.undoManager = undoManager;
        this.offsetMapping = ValidatingOffsetMappingKt.getValidatingEmptyOffsetMappingIdentity();
        this.onValueChange = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$onValueChange$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldValue textFieldValue) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                invoke2(textFieldValue);
                return Unit.INSTANCE;
            }
        };
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null), null, 2, null);
        this.value = mutableStateOf$default;
        this.visualTransformation = VisualTransformation.INSTANCE.getNone();
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this.editable = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this.enabled = mutableStateOf$default3;
        this.dragBeginPosition = Offset.INSTANCE.m4141getZeroF1C5BW0();
        this.dragTotalDistance = Offset.INSTANCE.m4141getZeroF1C5BW0();
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggingHandle = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition = mutableStateOf$default5;
        this.previousRawDragOffset = -1;
        this.oldValue = new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null);
        this.touchSelectionObserver = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo1455onDownk4lQ0M(long point) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo1457onStartk4lQ0M(long startPoint) {
                long j;
                TextLayoutResultProxy layoutResult;
                TextFieldValue m1821createTextFieldValueFDrldGo;
                long j2;
                TextLayoutResultProxy layoutResult2;
                long m1824updateSelection8UEBfa8;
                if (TextFieldSelectionManager.this.getEnabled() && TextFieldSelectionManager.this.getDraggingHandle() == null) {
                    TextFieldSelectionManager.this.setDraggingHandle(Handle.SelectionEnd);
                    TextFieldSelectionManager.this.previousRawDragOffset = -1;
                    TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                    LegacyTextFieldState state = TextFieldSelectionManager.this.getState();
                    if (state == null || (layoutResult2 = state.getLayoutResult()) == null || !layoutResult2.m1490isPositionOnTextk4lQ0M(startPoint)) {
                        j = startPoint;
                        LegacyTextFieldState state2 = TextFieldSelectionManager.this.getState();
                        if (state2 != null && (layoutResult = state2.getLayoutResult()) != null) {
                            TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                            int transformedToOriginal = textFieldSelectionManager.getOffsetMapping().transformedToOriginal(TextLayoutResultProxy.m1488getOffsetForPosition3MmeM6k$default(layoutResult, j, false, 2, null));
                            m1821createTextFieldValueFDrldGo = textFieldSelectionManager.m1821createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(transformedToOriginal, transformedToOriginal));
                            textFieldSelectionManager.enterSelectionMode$foundation_release(false);
                            HapticFeedback hapticFeedBack = textFieldSelectionManager.getHapticFeedBack();
                            if (hapticFeedBack != null) {
                                hapticFeedBack.mo5106performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m5122getTextHandleMove5zf0vsI());
                            }
                            textFieldSelectionManager.getOnValueChange$foundation_release().invoke(m1821createTextFieldValueFDrldGo);
                        }
                    } else {
                        if (TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) {
                            return;
                        }
                        TextFieldSelectionManager.this.enterSelectionMode$foundation_release(false);
                        TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                        m1824updateSelection8UEBfa8 = textFieldSelectionManager2.m1824updateSelection8UEBfa8(TextFieldValue.m6698copy3r_uNRQ$default(textFieldSelectionManager2.getValue$foundation_release(), (AnnotatedString) null, TextRange.INSTANCE.m6440getZerod9O1mEE(), (TextRange) null, 5, (Object) null), startPoint, true, false, SelectionAdjustment.INSTANCE.getWord(), true);
                        j = startPoint;
                        TextFieldSelectionManager.this.dragBeginOffsetInText = Integer.valueOf(TextRange.m6435getStartimpl(m1824updateSelection8UEBfa8));
                    }
                    TextFieldSelectionManager.this.setHandleState(HandleState.None);
                    TextFieldSelectionManager.this.dragBeginPosition = j;
                    TextFieldSelectionManager textFieldSelectionManager3 = TextFieldSelectionManager.this;
                    j2 = textFieldSelectionManager3.dragBeginPosition;
                    textFieldSelectionManager3.m1823setCurrentDragPosition_kEHs6E(Offset.m4114boximpl(j2));
                    TextFieldSelectionManager.this.dragTotalDistance = Offset.INSTANCE.m4141getZeroF1C5BW0();
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo1456onDragk4lQ0M(long delta) {
                long j;
                TextLayoutResultProxy layoutResult;
                long j2;
                long j3;
                Integer num;
                Integer num2;
                long j4;
                int m1489getOffsetForPosition3MmeM6k;
                Integer num3;
                long m1824updateSelection8UEBfa8;
                long j5;
                SelectionAdjustment word;
                if (!TextFieldSelectionManager.this.getEnabled() || TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m4130plusMKHz9U(j, delta);
                LegacyTextFieldState state = TextFieldSelectionManager.this.getState();
                if (state != null && (layoutResult = state.getLayoutResult()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                    j2 = textFieldSelectionManager2.dragBeginPosition;
                    j3 = textFieldSelectionManager2.dragTotalDistance;
                    textFieldSelectionManager2.m1823setCurrentDragPosition_kEHs6E(Offset.m4114boximpl(Offset.m4130plusMKHz9U(j2, j3)));
                    num = textFieldSelectionManager2.dragBeginOffsetInText;
                    if (num == null) {
                        Offset m1826getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m1826getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(m1826getCurrentDragPosition_m7T9E);
                        if (!layoutResult.m1490isPositionOnTextk4lQ0M(m1826getCurrentDragPosition_m7T9E.m4135unboximpl())) {
                            OffsetMapping offsetMapping = textFieldSelectionManager2.getOffsetMapping();
                            j5 = textFieldSelectionManager2.dragBeginPosition;
                            int transformedToOriginal = offsetMapping.transformedToOriginal(TextLayoutResultProxy.m1488getOffsetForPosition3MmeM6k$default(layoutResult, j5, false, 2, null));
                            OffsetMapping offsetMapping2 = textFieldSelectionManager2.getOffsetMapping();
                            Offset m1826getCurrentDragPosition_m7T9E2 = textFieldSelectionManager2.m1826getCurrentDragPosition_m7T9E();
                            Intrinsics.checkNotNull(m1826getCurrentDragPosition_m7T9E2);
                            if (transformedToOriginal == offsetMapping2.transformedToOriginal(TextLayoutResultProxy.m1488getOffsetForPosition3MmeM6k$default(layoutResult, m1826getCurrentDragPosition_m7T9E2.m4135unboximpl(), false, 2, null))) {
                                word = SelectionAdjustment.INSTANCE.getNone();
                            } else {
                                word = SelectionAdjustment.INSTANCE.getWord();
                            }
                            SelectionAdjustment selectionAdjustment = word;
                            TextFieldValue value$foundation_release = textFieldSelectionManager2.getValue$foundation_release();
                            Offset m1826getCurrentDragPosition_m7T9E3 = textFieldSelectionManager2.m1826getCurrentDragPosition_m7T9E();
                            Intrinsics.checkNotNull(m1826getCurrentDragPosition_m7T9E3);
                            m1824updateSelection8UEBfa8 = textFieldSelectionManager2.m1824updateSelection8UEBfa8(value$foundation_release, m1826getCurrentDragPosition_m7T9E3.m4135unboximpl(), false, false, selectionAdjustment, true);
                            TextRange.m6423boximpl(m1824updateSelection8UEBfa8);
                        }
                    }
                    num2 = textFieldSelectionManager2.dragBeginOffsetInText;
                    if (num2 != null) {
                        m1489getOffsetForPosition3MmeM6k = num2.intValue();
                    } else {
                        j4 = textFieldSelectionManager2.dragBeginPosition;
                        m1489getOffsetForPosition3MmeM6k = layoutResult.m1489getOffsetForPosition3MmeM6k(j4, false);
                    }
                    Offset m1826getCurrentDragPosition_m7T9E4 = textFieldSelectionManager2.m1826getCurrentDragPosition_m7T9E();
                    Intrinsics.checkNotNull(m1826getCurrentDragPosition_m7T9E4);
                    int m1489getOffsetForPosition3MmeM6k2 = layoutResult.m1489getOffsetForPosition3MmeM6k(m1826getCurrentDragPosition_m7T9E4.m4135unboximpl(), false);
                    num3 = textFieldSelectionManager2.dragBeginOffsetInText;
                    if (num3 == null && m1489getOffsetForPosition3MmeM6k == m1489getOffsetForPosition3MmeM6k2) {
                        return;
                    }
                    TextFieldValue value$foundation_release2 = textFieldSelectionManager2.getValue$foundation_release();
                    Offset m1826getCurrentDragPosition_m7T9E5 = textFieldSelectionManager2.m1826getCurrentDragPosition_m7T9E();
                    Intrinsics.checkNotNull(m1826getCurrentDragPosition_m7T9E5);
                    m1824updateSelection8UEBfa8 = textFieldSelectionManager2.m1824updateSelection8UEBfa8(value$foundation_release2, m1826getCurrentDragPosition_m7T9E5.m4135unboximpl(), false, false, SelectionAdjustment.INSTANCE.getWord(), true);
                    TextRange.m6423boximpl(m1824updateSelection8UEBfa8);
                }
                TextFieldSelectionManager.this.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                onEnd();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
                onEnd();
            }

            private final void onEnd() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m1823setCurrentDragPosition_kEHs6E(null);
                TextFieldSelectionManager.this.updateFloatingToolbar(true);
                TextFieldSelectionManager.this.dragBeginOffsetInText = null;
                boolean m6429getCollapsedimpl = TextRange.m6429getCollapsedimpl(TextFieldSelectionManager.this.getValue$foundation_release().getSelection());
                TextFieldSelectionManager.this.setHandleState(m6429getCollapsedimpl ? HandleState.Cursor : HandleState.Selection);
                LegacyTextFieldState state = TextFieldSelectionManager.this.getState();
                if (state != null) {
                    state.setShowSelectionHandleStart(!m6429getCollapsedimpl && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(TextFieldSelectionManager.this, true));
                }
                LegacyTextFieldState state2 = TextFieldSelectionManager.this.getState();
                if (state2 != null) {
                    state2.setShowSelectionHandleEnd(!m6429getCollapsedimpl && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(TextFieldSelectionManager.this, false));
                }
                LegacyTextFieldState state3 = TextFieldSelectionManager.this.getState();
                if (state3 == null) {
                    return;
                }
                state3.setShowCursorHandle(m6429getCollapsedimpl && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(TextFieldSelectionManager.this, true));
            }
        };
        this.mouseSelectionObserver = new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$mouseSelectionObserver$1
            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public void onDragDone() {
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtend-k-4lQ0M */
            public boolean mo1693onExtendk4lQ0M(long downPosition) {
                LegacyTextFieldState state = TextFieldSelectionManager.this.getState();
                if (state == null || state.getLayoutResult() == null || !TextFieldSelectionManager.this.getEnabled()) {
                    return false;
                }
                TextFieldSelectionManager.this.previousRawDragOffset = -1;
                updateMouseSelection(TextFieldSelectionManager.this.getValue$foundation_release(), downPosition, false, SelectionAdjustment.INSTANCE.getNone());
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtendDrag-k-4lQ0M */
            public boolean mo1694onExtendDragk4lQ0M(long dragPosition) {
                LegacyTextFieldState state;
                if (!TextFieldSelectionManager.this.getEnabled() || TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0 || (state = TextFieldSelectionManager.this.getState()) == null || state.getLayoutResult() == null) {
                    return false;
                }
                updateMouseSelection(TextFieldSelectionManager.this.getValue$foundation_release(), dragPosition, false, SelectionAdjustment.INSTANCE.getNone());
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onStart-3MmeM6k */
            public boolean mo1695onStart3MmeM6k(long downPosition, SelectionAdjustment adjustment) {
                LegacyTextFieldState state;
                long j;
                if (!TextFieldSelectionManager.this.getEnabled() || TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0 || (state = TextFieldSelectionManager.this.getState()) == null || state.getLayoutResult() == null) {
                    return false;
                }
                FocusRequester focusRequester = TextFieldSelectionManager.this.getFocusRequester();
                if (focusRequester != null) {
                    FocusRequester.m4036requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
                }
                TextFieldSelectionManager.this.dragBeginPosition = downPosition;
                TextFieldSelectionManager.this.previousRawDragOffset = -1;
                TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                TextFieldValue value$foundation_release = TextFieldSelectionManager.this.getValue$foundation_release();
                j = TextFieldSelectionManager.this.dragBeginPosition;
                updateMouseSelection(value$foundation_release, j, true, adjustment);
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onDrag-3MmeM6k */
            public boolean mo1692onDrag3MmeM6k(long dragPosition, SelectionAdjustment adjustment) {
                LegacyTextFieldState state;
                if (!TextFieldSelectionManager.this.getEnabled() || TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0 || (state = TextFieldSelectionManager.this.getState()) == null || state.getLayoutResult() == null) {
                    return false;
                }
                updateMouseSelection(TextFieldSelectionManager.this.getValue$foundation_release(), dragPosition, false, adjustment);
                return true;
            }

            public final void updateMouseSelection(TextFieldValue value, long currentPosition, boolean isStartOfSelection, SelectionAdjustment adjustment) {
                long m1824updateSelection8UEBfa8;
                m1824updateSelection8UEBfa8 = TextFieldSelectionManager.this.m1824updateSelection8UEBfa8(value, currentPosition, isStartOfSelection, false, adjustment, false);
                TextFieldSelectionManager.this.setHandleState(TextRange.m6429getCollapsedimpl(m1824updateSelection8UEBfa8) ? HandleState.Cursor : HandleState.Selection);
            }
        };
    }

    public /* synthetic */ TextFieldSelectionManager(UndoManager undoManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : undoManager);
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    /* renamed from: getOffsetMapping$foundation_release, reason: from getter */
    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final void setOffsetMapping$foundation_release(OffsetMapping offsetMapping) {
        this.offsetMapping = offsetMapping;
    }

    public final Function1<TextFieldValue, Unit> getOnValueChange$foundation_release() {
        return this.onValueChange;
    }

    public final void setOnValueChange$foundation_release(Function1<? super TextFieldValue, Unit> function1) {
        this.onValueChange = function1;
    }

    /* renamed from: getState$foundation_release, reason: from getter */
    public final LegacyTextFieldState getState() {
        return this.state;
    }

    public final void setState$foundation_release(LegacyTextFieldState legacyTextFieldState) {
        this.state = legacyTextFieldState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TextFieldValue getValue$foundation_release() {
        return (TextFieldValue) this.value.getValue();
    }

    public final void setValue$foundation_release(TextFieldValue textFieldValue) {
        this.value.setValue(textFieldValue);
    }

    public final AnnotatedString getTransformedText$foundation_release() {
        TextDelegate textDelegate;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (textDelegate = legacyTextFieldState.getTextDelegate()) == null) {
            return null;
        }
        return textDelegate.getText();
    }

    /* renamed from: getVisualTransformation$foundation_release, reason: from getter */
    public final VisualTransformation getVisualTransformation() {
        return this.visualTransformation;
    }

    public final void setVisualTransformation$foundation_release(VisualTransformation visualTransformation) {
        this.visualTransformation = visualTransformation;
    }

    public final Function0<Unit> getRequestAutofillAction$foundation_release() {
        return this.requestAutofillAction;
    }

    public final void setRequestAutofillAction$foundation_release(Function0<Unit> function0) {
        this.requestAutofillAction = function0;
    }

    /* renamed from: getClipboard$foundation_release, reason: from getter */
    public final Clipboard getClipboard() {
        return this.clipboard;
    }

    public final void setClipboard$foundation_release(Clipboard clipboard) {
        this.clipboard = clipboard;
    }

    /* renamed from: getCoroutineScope$foundation_release, reason: from getter */
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final void setCoroutineScope$foundation_release(CoroutineScope coroutineScope) {
        this.coroutineScope = coroutineScope;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final void setTextToolbar(TextToolbar textToolbar) {
        this.textToolbar = textToolbar;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final void setFocusRequester(FocusRequester focusRequester) {
        this.focusRequester = focusRequester;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getEditable() {
        return ((Boolean) this.editable.getValue()).booleanValue();
    }

    public final void setEditable(boolean z) {
        this.editable.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getEnabled() {
        return ((Boolean) this.enabled.getValue()).booleanValue();
    }

    public final void setEnabled(boolean z) {
        this.enabled.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle.setValue(handle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    public final void m1823setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition.setValue(offset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getCurrentDragPosition-_m7T9-E, reason: not valid java name */
    public final Offset m1826getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition.getValue();
    }

    /* renamed from: getTouchSelectionObserver$foundation_release, reason: from getter */
    public final TextDragObserver getTouchSelectionObserver() {
        return this.touchSelectionObserver;
    }

    /* renamed from: getMouseSelectionObserver$foundation_release, reason: from getter */
    public final MouseSelectionObserver getMouseSelectionObserver() {
        return this.mouseSelectionObserver;
    }

    public final TextDragObserver handleDragObserver$foundation_release(final boolean isStartHandle) {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$handleDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo1457onStartk4lQ0M(long startPoint) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo1455onDownk4lQ0M(long point) {
                TextLayoutResultProxy layoutResult;
                TextFieldSelectionManager.this.setDraggingHandle(isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
                long m1771getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m1771getAdjustedCoordinatesk4lQ0M(TextFieldSelectionManager.this.m1828getHandlePositiontuRUvjQ$foundation_release(isStartHandle));
                LegacyTextFieldState state = TextFieldSelectionManager.this.getState();
                if (state == null || (layoutResult = state.getLayoutResult()) == null) {
                    return;
                }
                long m1492translateInnerToDecorationCoordinatesMKHz9U$foundation_release = layoutResult.m1492translateInnerToDecorationCoordinatesMKHz9U$foundation_release(m1771getAdjustedCoordinatesk4lQ0M);
                TextFieldSelectionManager.this.dragBeginPosition = m1492translateInnerToDecorationCoordinatesMKHz9U$foundation_release;
                TextFieldSelectionManager.this.m1823setCurrentDragPosition_kEHs6E(Offset.m4114boximpl(m1492translateInnerToDecorationCoordinatesMKHz9U$foundation_release));
                TextFieldSelectionManager.this.dragTotalDistance = Offset.INSTANCE.m4141getZeroF1C5BW0();
                TextFieldSelectionManager.this.previousRawDragOffset = -1;
                LegacyTextFieldState state2 = TextFieldSelectionManager.this.getState();
                if (state2 != null) {
                    state2.setInTouchMode(true);
                }
                TextFieldSelectionManager.this.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m1823setCurrentDragPosition_kEHs6E(null);
                TextFieldSelectionManager.this.updateFloatingToolbar(true);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo1456onDragk4lQ0M(long delta) {
                long j;
                long j2;
                long j3;
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m4130plusMKHz9U(j, delta);
                TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                j2 = textFieldSelectionManager2.dragBeginPosition;
                j3 = TextFieldSelectionManager.this.dragTotalDistance;
                textFieldSelectionManager2.m1823setCurrentDragPosition_kEHs6E(Offset.m4114boximpl(Offset.m4130plusMKHz9U(j2, j3)));
                TextFieldSelectionManager textFieldSelectionManager3 = TextFieldSelectionManager.this;
                TextFieldValue value$foundation_release = textFieldSelectionManager3.getValue$foundation_release();
                Offset m1826getCurrentDragPosition_m7T9E = TextFieldSelectionManager.this.m1826getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(m1826getCurrentDragPosition_m7T9E);
                textFieldSelectionManager3.m1824updateSelection8UEBfa8(value$foundation_release, m1826getCurrentDragPosition_m7T9E.m4135unboximpl(), false, isStartHandle, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate(), true);
                TextFieldSelectionManager.this.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m1823setCurrentDragPosition_kEHs6E(null);
                TextFieldSelectionManager.this.updateFloatingToolbar(true);
            }
        };
    }

    public final TextDragObserver cursorDragObserver$foundation_release() {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$cursorDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo1455onDownk4lQ0M(long point) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m1823setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo1457onStartk4lQ0M(long startPoint) {
                TextLayoutResultProxy layoutResult;
                long m1771getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m1771getAdjustedCoordinatesk4lQ0M(TextFieldSelectionManager.this.m1828getHandlePositiontuRUvjQ$foundation_release(true));
                LegacyTextFieldState state = TextFieldSelectionManager.this.getState();
                if (state == null || (layoutResult = state.getLayoutResult()) == null) {
                    return;
                }
                long m1492translateInnerToDecorationCoordinatesMKHz9U$foundation_release = layoutResult.m1492translateInnerToDecorationCoordinatesMKHz9U$foundation_release(m1771getAdjustedCoordinatesk4lQ0M);
                TextFieldSelectionManager.this.dragBeginPosition = m1492translateInnerToDecorationCoordinatesMKHz9U$foundation_release;
                TextFieldSelectionManager.this.m1823setCurrentDragPosition_kEHs6E(Offset.m4114boximpl(m1492translateInnerToDecorationCoordinatesMKHz9U$foundation_release));
                TextFieldSelectionManager.this.dragTotalDistance = Offset.INSTANCE.m4141getZeroF1C5BW0();
                TextFieldSelectionManager.this.setDraggingHandle(Handle.Cursor);
                TextFieldSelectionManager.this.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo1456onDragk4lQ0M(long delta) {
                long j;
                TextLayoutResultProxy layoutResult;
                long j2;
                long j3;
                HapticFeedback hapticFeedBack;
                TextFieldValue m1821createTextFieldValueFDrldGo;
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m4130plusMKHz9U(j, delta);
                LegacyTextFieldState state = TextFieldSelectionManager.this.getState();
                if (state == null || (layoutResult = state.getLayoutResult()) == null) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                j2 = textFieldSelectionManager2.dragBeginPosition;
                j3 = textFieldSelectionManager2.dragTotalDistance;
                textFieldSelectionManager2.m1823setCurrentDragPosition_kEHs6E(Offset.m4114boximpl(Offset.m4130plusMKHz9U(j2, j3)));
                OffsetMapping offsetMapping = textFieldSelectionManager2.getOffsetMapping();
                Offset m1826getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m1826getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(m1826getCurrentDragPosition_m7T9E);
                int transformedToOriginal = offsetMapping.transformedToOriginal(TextLayoutResultProxy.m1488getOffsetForPosition3MmeM6k$default(layoutResult, m1826getCurrentDragPosition_m7T9E.m4135unboximpl(), false, 2, null));
                long TextRange = TextRangeKt.TextRange(transformedToOriginal, transformedToOriginal);
                if (TextRange.m6428equalsimpl0(TextRange, textFieldSelectionManager2.getValue$foundation_release().getSelection())) {
                    return;
                }
                LegacyTextFieldState state2 = textFieldSelectionManager2.getState();
                if ((state2 == null || state2.isInTouchMode()) && (hapticFeedBack = textFieldSelectionManager2.getHapticFeedBack()) != null) {
                    hapticFeedBack.mo5106performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m5122getTextHandleMove5zf0vsI());
                }
                Function1<TextFieldValue, Unit> onValueChange$foundation_release = textFieldSelectionManager2.getOnValueChange$foundation_release();
                m1821createTextFieldValueFDrldGo = textFieldSelectionManager2.m1821createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation_release().getAnnotatedString(), TextRange);
                onValueChange$foundation_release.invoke(m1821createTextFieldValueFDrldGo);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m1823setCurrentDragPosition_kEHs6E(null);
            }
        };
    }

    public static /* synthetic */ void enterSelectionMode$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionManager.enterSelectionMode$foundation_release(z);
    }

    public final void enterSelectionMode$foundation_release(boolean showFloatingToolbar) {
        FocusRequester focusRequester;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null && !legacyTextFieldState.getHasFocus() && (focusRequester = this.focusRequester) != null) {
            FocusRequester.m4036requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        }
        this.oldValue = getValue$foundation_release();
        updateFloatingToolbar(showFloatingToolbar);
        setHandleState(HandleState.Selection);
    }

    public final void exitSelectionMode$foundation_release() {
        updateFloatingToolbar(false);
        setHandleState(HandleState.None);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release$default, reason: not valid java name */
    public static /* synthetic */ void m1822deselect_kEHs6E$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, Offset offset, int i, Object obj) {
        if ((i & 1) != 0) {
            offset = null;
        }
        textFieldSelectionManager.m1825deselect_kEHs6E$foundation_release(offset);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release, reason: not valid java name */
    public final void m1825deselect_kEHs6E$foundation_release(Offset position) {
        int m6432getMaximpl;
        if (!TextRange.m6429getCollapsedimpl(getValue$foundation_release().getSelection())) {
            LegacyTextFieldState legacyTextFieldState = this.state;
            TextLayoutResultProxy layoutResult = legacyTextFieldState != null ? legacyTextFieldState.getLayoutResult() : null;
            if (position != null && layoutResult != null) {
                m6432getMaximpl = this.offsetMapping.transformedToOriginal(TextLayoutResultProxy.m1488getOffsetForPosition3MmeM6k$default(layoutResult, position.m4135unboximpl(), false, 2, null));
            } else {
                m6432getMaximpl = TextRange.m6432getMaximpl(getValue$foundation_release().getSelection());
            }
            this.onValueChange.invoke(TextFieldValue.m6698copy3r_uNRQ$default(getValue$foundation_release(), (AnnotatedString) null, TextRangeKt.TextRange(m6432getMaximpl), (TextRange) null, 5, (Object) null));
        }
        setHandleState((position == null || getValue$foundation_release().getText().length() <= 0) ? HandleState.None : HandleState.Cursor);
        updateFloatingToolbar(false);
    }

    /* renamed from: setSelectionPreviewHighlight-5zc-tL8$foundation_release, reason: not valid java name */
    public final void m1831setSelectionPreviewHighlight5zctL8$foundation_release(long range) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m1399setSelectionPreviewHighlightRange5zctL8(range);
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m1396setDeletionPreviewHighlightRange5zctL8(TextRange.INSTANCE.m6440getZerod9O1mEE());
        }
        if (TextRange.m6429getCollapsedimpl(range)) {
            return;
        }
        exitSelectionMode$foundation_release();
    }

    /* renamed from: setDeletionPreviewHighlight-5zc-tL8$foundation_release, reason: not valid java name */
    public final void m1830setDeletionPreviewHighlight5zctL8$foundation_release(long range) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m1396setDeletionPreviewHighlightRange5zctL8(range);
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m1399setSelectionPreviewHighlightRange5zctL8(TextRange.INSTANCE.m6440getZerod9O1mEE());
        }
        if (TextRange.m6429getCollapsedimpl(range)) {
            return;
        }
        exitSelectionMode$foundation_release();
    }

    public final void clearPreviewHighlight$foundation_release() {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m1396setDeletionPreviewHighlightRange5zctL8(TextRange.INSTANCE.m6440getZerod9O1mEE());
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 == null) {
            return;
        }
        legacyTextFieldState2.m1399setSelectionPreviewHighlightRange5zctL8(TextRange.INSTANCE.m6440getZerod9O1mEE());
    }

    public static /* synthetic */ Job copy$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return textFieldSelectionManager.copy$foundation_release(z);
    }

    public final Job copy$foundation_release(boolean cancelSelection) {
        Job launch$default;
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope == null) {
            return null;
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$copy$1(this, cancelSelection, null), 1, null);
        return launch$default;
    }

    public final Job paste$foundation_release() {
        Job launch$default;
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope == null) {
            return null;
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$paste$1(this, null), 1, null);
        return launch$default;
    }

    public final Job cut$foundation_release() {
        Job launch$default;
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope == null) {
            return null;
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$cut$1(this, null), 1, null);
        return launch$default;
    }

    public final void selectAll$foundation_release() {
        TextFieldValue m1821createTextFieldValueFDrldGo = m1821createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(0, getValue$foundation_release().getText().length()));
        this.onValueChange.invoke(m1821createTextFieldValueFDrldGo);
        this.oldValue = TextFieldValue.m6698copy3r_uNRQ$default(this.oldValue, (AnnotatedString) null, m1821createTextFieldValueFDrldGo.getSelection(), (TextRange) null, 5, (Object) null);
        enterSelectionMode$foundation_release(true);
    }

    public final void autofill$foundation_release() {
        Function0<Unit> function0 = this.requestAutofillAction;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* renamed from: getHandlePosition-tuRUvjQ$foundation_release, reason: not valid java name */
    public final long m1828getHandlePositiontuRUvjQ$foundation_release(boolean isStartHandle) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null) {
            return Offset.INSTANCE.m4140getUnspecifiedF1C5BW0();
        }
        AnnotatedString transformedText$foundation_release = getTransformedText$foundation_release();
        if (transformedText$foundation_release == null) {
            return Offset.INSTANCE.m4140getUnspecifiedF1C5BW0();
        }
        if (!Intrinsics.areEqual(transformedText$foundation_release.getText(), value.getLayoutInput().getText().getText())) {
            return Offset.INSTANCE.m4140getUnspecifiedF1C5BW0();
        }
        long selection = getValue$foundation_release().getSelection();
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(value, this.offsetMapping.originalToTransformed(isStartHandle ? TextRange.m6435getStartimpl(selection) : TextRange.m6430getEndimpl(selection)), isStartHandle, TextRange.m6434getReversedimpl(getValue$foundation_release().getSelection()));
    }

    public final float getHandleLineHeight$foundation_release(boolean isStartHandle) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        int m6435getStartimpl = isStartHandle ? TextRange.m6435getStartimpl(getValue$foundation_release().getSelection()) : TextRange.m6430getEndimpl(getValue$foundation_release().getSelection());
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null) {
            return 0.0f;
        }
        return TextLayoutHelperKt.getLineHeight(value, m6435getStartimpl);
    }

    /* renamed from: getCursorPosition-tuRUvjQ$foundation_release, reason: not valid java name */
    public final long m1827getCursorPositiontuRUvjQ$foundation_release(Density density) {
        int originalToTransformed = this.offsetMapping.originalToTransformed(TextRange.m6435getStartimpl(getValue$foundation_release().getSelection()));
        LegacyTextFieldState legacyTextFieldState = this.state;
        TextLayoutResultProxy layoutResult = legacyTextFieldState != null ? legacyTextFieldState.getLayoutResult() : null;
        Intrinsics.checkNotNull(layoutResult);
        TextLayoutResult value = layoutResult.getValue();
        float left = value.getCursorRect(RangesKt.coerceIn(originalToTransformed, 0, value.getLayoutInput().getText().length())).getLeft() + (density.mo700toPx0680j_4(TextFieldCursor_androidKt.getDefaultCursorThickness()) / 2.0f);
        return Offset.m4117constructorimpl((Float.floatToRawIntBits(r4.getBottom()) & 4294967295L) | (Float.floatToRawIntBits(left) << 32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFloatingToolbar(boolean show) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.setShowFloatingToolbar(show);
        }
        if (show) {
            showSelectionToolbar$foundation_release();
        } else {
            hideSelectionToolbar$foundation_release();
        }
    }

    public final Job showSelectionToolbar$foundation_release() {
        Job launch$default;
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope == null) {
            return null;
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$showSelectionToolbar$1(this, null), 1, null);
        return launch$default;
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar;
        TextToolbar textToolbar2 = this.textToolbar;
        if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
            return;
        }
        textToolbar.hide();
    }

    /* renamed from: selectWordAtPositionIfNotAlreadySelected-k-4lQ0M, reason: not valid java name */
    public final void m1829selectWordAtPositionIfNotAlreadySelectedk4lQ0M(long position) {
        TextLayoutResultProxy layoutResult;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null || TextLayoutHelperKt.m1486isPositionInsideSelectionuaM50fQ(layoutResult.getValue(), layoutResult.m1491translateDecorationToInnerCoordinatesMKHz9U$foundation_release(position), TextRange.m6423boximpl(getValue$foundation_release().getSelection()))) {
            return;
        }
        m1824updateSelection8UEBfa8(getValue$foundation_release(), position, true, false, SelectionAdjustment.INSTANCE.getWord(), false);
    }

    public final boolean isTextChanged$foundation_release() {
        return !Intrinsics.areEqual(this.oldValue.getText(), getValue$foundation_release().getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect getContentRect() {
        char c;
        long j;
        float f;
        LayoutCoordinates layoutCoordinates;
        TextLayoutResult value;
        Rect cursorRect;
        LayoutCoordinates layoutCoordinates2;
        TextLayoutResult value2;
        Rect cursorRect2;
        LayoutCoordinates layoutCoordinates3;
        LayoutCoordinates layoutCoordinates4;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            if (legacyTextFieldState.getIsLayoutResultStale()) {
                legacyTextFieldState = null;
            }
            if (legacyTextFieldState != null) {
                int originalToTransformed = this.offsetMapping.originalToTransformed(TextRange.m6435getStartimpl(getValue$foundation_release().getSelection()));
                int originalToTransformed2 = this.offsetMapping.originalToTransformed(TextRange.m6430getEndimpl(getValue$foundation_release().getSelection()));
                LegacyTextFieldState legacyTextFieldState2 = this.state;
                long m4141getZeroF1C5BW0 = (legacyTextFieldState2 == null || (layoutCoordinates4 = legacyTextFieldState2.getLayoutCoordinates()) == null) ? Offset.INSTANCE.m4141getZeroF1C5BW0() : layoutCoordinates4.mo5743localToRootMKHz9U(m1828getHandlePositiontuRUvjQ$foundation_release(true));
                LegacyTextFieldState legacyTextFieldState3 = this.state;
                long m4141getZeroF1C5BW02 = (legacyTextFieldState3 == null || (layoutCoordinates3 = legacyTextFieldState3.getLayoutCoordinates()) == null) ? Offset.INSTANCE.m4141getZeroF1C5BW0() : layoutCoordinates3.mo5743localToRootMKHz9U(m1828getHandlePositiontuRUvjQ$foundation_release(false));
                LegacyTextFieldState legacyTextFieldState4 = this.state;
                float f2 = 0.0f;
                if (legacyTextFieldState4 == null || (layoutCoordinates2 = legacyTextFieldState4.getLayoutCoordinates()) == null) {
                    c = ' ';
                    j = 4294967295L;
                    f = 0.0f;
                } else {
                    TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                    c = ' ';
                    j = 4294967295L;
                    f = Float.intBitsToFloat((int) (layoutCoordinates2.mo5743localToRootMKHz9U(Offset.m4117constructorimpl((Float.floatToRawIntBits((layoutResult == null || (value2 = layoutResult.getValue()) == null || (cursorRect2 = value2.getCursorRect(originalToTransformed)) == null) ? 0.0f : cursorRect2.getTop()) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32))) & 4294967295L));
                }
                LegacyTextFieldState legacyTextFieldState5 = this.state;
                if (legacyTextFieldState5 != null && (layoutCoordinates = legacyTextFieldState5.getLayoutCoordinates()) != null) {
                    TextLayoutResultProxy layoutResult2 = legacyTextFieldState.getLayoutResult();
                    f2 = Float.intBitsToFloat((int) (layoutCoordinates.mo5743localToRootMKHz9U(Offset.m4117constructorimpl((Float.floatToRawIntBits(0.0f) << c) | (Float.floatToRawIntBits((layoutResult2 == null || (value = layoutResult2.getValue()) == null || (cursorRect = value.getCursorRect(originalToTransformed2)) == null) ? 0.0f : cursorRect.getTop()) & j))) & j));
                }
                int i = (int) (m4141getZeroF1C5BW0 >> c);
                int i2 = (int) (m4141getZeroF1C5BW02 >> c);
                return new Rect(Math.min(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.min(f, f2), Math.max(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.max(Float.intBitsToFloat((int) (m4141getZeroF1C5BW0 & j)), Float.intBitsToFloat((int) (m4141getZeroF1C5BW02 & j))) + (Dp.m6989constructorimpl(25.0f) * legacyTextFieldState.getTextDelegate().getDensity().getDensity()));
            }
        }
        return Rect.INSTANCE.getZero();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateSelection-8UEBfa8, reason: not valid java name */
    public final long m1824updateSelection8UEBfa8(TextFieldValue value, long currentPosition, boolean isStartOfSelection, boolean isStartHandle, SelectionAdjustment adjustment, boolean isTouchBasedSelection) {
        TextLayoutResultProxy layoutResult;
        int i;
        HapticFeedback hapticFeedback;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null) {
            return TextRange.INSTANCE.m6440getZerod9O1mEE();
        }
        long TextRange = TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.m6435getStartimpl(value.getSelection())), this.offsetMapping.originalToTransformed(TextRange.m6430getEndimpl(value.getSelection())));
        boolean z = false;
        int m1489getOffsetForPosition3MmeM6k = layoutResult.m1489getOffsetForPosition3MmeM6k(currentPosition, false);
        int m6435getStartimpl = (isStartHandle || isStartOfSelection) ? m1489getOffsetForPosition3MmeM6k : TextRange.m6435getStartimpl(TextRange);
        int m6430getEndimpl = (!isStartHandle || isStartOfSelection) ? m1489getOffsetForPosition3MmeM6k : TextRange.m6430getEndimpl(TextRange);
        SelectionLayout selectionLayout = this.previousSelectionLayout;
        if (isStartOfSelection || selectionLayout == null || (i = this.previousRawDragOffset) == -1) {
            i = -1;
        }
        SelectionLayout m1774getTextFieldSelectionLayoutRcvTLA = SelectionLayoutKt.m1774getTextFieldSelectionLayoutRcvTLA(layoutResult.getValue(), m6435getStartimpl, m6430getEndimpl, i, TextRange, isStartOfSelection, isStartHandle);
        if (!m1774getTextFieldSelectionLayoutRcvTLA.shouldRecomputeSelection(selectionLayout)) {
            return value.getSelection();
        }
        this.previousSelectionLayout = m1774getTextFieldSelectionLayoutRcvTLA;
        this.previousRawDragOffset = m1489getOffsetForPosition3MmeM6k;
        Selection adjust = adjustment.adjust(m1774getTextFieldSelectionLayoutRcvTLA);
        long TextRange2 = TextRangeKt.TextRange(this.offsetMapping.transformedToOriginal(adjust.getStart().getOffset()), this.offsetMapping.transformedToOriginal(adjust.getEnd().getOffset()));
        if (TextRange.m6428equalsimpl0(TextRange2, value.getSelection())) {
            return value.getSelection();
        }
        boolean z2 = TextRange.m6434getReversedimpl(TextRange2) != TextRange.m6434getReversedimpl(value.getSelection()) && TextRange.m6428equalsimpl0(TextRangeKt.TextRange(TextRange.m6430getEndimpl(TextRange2), TextRange.m6435getStartimpl(TextRange2)), value.getSelection());
        boolean z3 = TextRange.m6429getCollapsedimpl(TextRange2) && TextRange.m6429getCollapsedimpl(value.getSelection());
        if (isTouchBasedSelection && value.getText().length() > 0 && !z2 && !z3 && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.mo5106performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m5122getTextHandleMove5zf0vsI());
        }
        this.onValueChange.invoke(m1821createTextFieldValueFDrldGo(value.getAnnotatedString(), TextRange2));
        if (!isTouchBasedSelection) {
            updateFloatingToolbar(!TextRange.m6429getCollapsedimpl(TextRange2));
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.setInTouchMode(isTouchBasedSelection);
        }
        LegacyTextFieldState legacyTextFieldState3 = this.state;
        if (legacyTextFieldState3 != null) {
            legacyTextFieldState3.setShowSelectionHandleStart(!TextRange.m6429getCollapsedimpl(TextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true));
        }
        LegacyTextFieldState legacyTextFieldState4 = this.state;
        if (legacyTextFieldState4 != null) {
            legacyTextFieldState4.setShowSelectionHandleEnd(!TextRange.m6429getCollapsedimpl(TextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, false));
        }
        LegacyTextFieldState legacyTextFieldState5 = this.state;
        if (legacyTextFieldState5 == null) {
            return TextRange2;
        }
        if (TextRange.m6429getCollapsedimpl(TextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true)) {
            z = true;
        }
        legacyTextFieldState5.setShowCursorHandle(z);
        return TextRange2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHandleState(HandleState handleState) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            if (legacyTextFieldState.getHandleState() == handleState) {
                legacyTextFieldState = null;
            }
            if (legacyTextFieldState != null) {
                legacyTextFieldState.setHandleState(handleState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createTextFieldValue-FDrldGo, reason: not valid java name */
    public final TextFieldValue m1821createTextFieldValueFDrldGo(AnnotatedString annotatedString, long selection) {
        return new TextFieldValue(annotatedString, selection, (TextRange) null, 4, (DefaultConstructorMarker) null);
    }
}
