package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextLayoutHelperKt;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;

/* compiled from: MultiWidgetSelectionDelegate.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\n\u0010%\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\u001d\u0010)\u001a\u00020*2\u0006\u0010\u001a\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,J\n\u0010-\u001a\u0004\u0018\u00010 H\u0016J\b\u0010.\u001a\u00020/H\u0016J\n\u00100\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u00020\u000b*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"Landroidx/compose/foundation/text/selection/MultiWidgetSelectionDelegate;", "Landroidx/compose/foundation/text/selection/Selectable;", "selectableId", "", "coordinatesCallback", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutResultCallback", "Landroidx/compose/ui/text/TextLayoutResult;", "(JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "_previousLastVisibleOffset", "", "_previousTextLayoutResult", "lock", "", "getSelectableId", "()J", "lastVisibleOffset", "getLastVisibleOffset", "(Landroidx/compose/ui/text/TextLayoutResult;)I", "appendSelectableInfoToBuilder", "", "builder", "Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;", "getBoundingBox", "Landroidx/compose/ui/geometry/Rect;", TypedValues.CycleType.S_WAVE_OFFSET, "getCenterYForOffset", "", "getHandlePosition", "Landroidx/compose/ui/geometry/Offset;", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "isStartHandle", "", "getHandlePosition-dBAh8RU", "(Landroidx/compose/foundation/text/selection/Selection;Z)J", "getLayoutCoordinates", "getLineHeight", "getLineLeft", "getLineRight", "getRangeOfLineContaining", "Landroidx/compose/ui/text/TextRange;", "getRangeOfLineContaining--jx7JFs", "(I)J", "getSelectAllSelection", "getText", "Landroidx/compose/ui/text/AnnotatedString;", "textLayoutResult", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MultiWidgetSelectionDelegate implements Selectable {
    public static final int $stable = 8;
    private TextLayoutResult _previousTextLayoutResult;
    private final Function0<LayoutCoordinates> coordinatesCallback;
    private final Function0<TextLayoutResult> layoutResultCallback;
    private final long selectableId;
    private final Object lock = this;
    private int _previousLastVisibleOffset = -1;

    /* JADX WARN: Multi-variable type inference failed */
    public MultiWidgetSelectionDelegate(long j, Function0<? extends LayoutCoordinates> function0, Function0<TextLayoutResult> function02) {
        this.selectableId = j;
        this.coordinatesCallback = function0;
        this.layoutResultCallback = function02;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public long getSelectableId() {
        return this.selectableId;
    }

    private final int getLastVisibleOffset(TextLayoutResult textLayoutResult) {
        int i;
        int lineCount;
        synchronized (this.lock) {
            if (this._previousTextLayoutResult != textLayoutResult) {
                if (textLayoutResult.getDidOverflowHeight() && !textLayoutResult.getMultiParagraph().getDidExceedMaxLines()) {
                    int coerceAtMost = RangesKt.coerceAtMost(textLayoutResult.getLineForVerticalPosition((int) (textLayoutResult.getSize() & 4294967295L)), textLayoutResult.getLineCount() - 1);
                    while (coerceAtMost >= 0 && textLayoutResult.getLineTop(coerceAtMost) >= ((int) (textLayoutResult.getSize() & 4294967295L))) {
                        coerceAtMost--;
                    }
                    lineCount = RangesKt.coerceAtLeast(coerceAtMost, 0);
                    this._previousLastVisibleOffset = textLayoutResult.getLineEnd(lineCount, true);
                    this._previousTextLayoutResult = textLayoutResult;
                }
                lineCount = textLayoutResult.getLineCount() - 1;
                this._previousLastVisibleOffset = textLayoutResult.getLineEnd(lineCount, true);
                this._previousTextLayoutResult = textLayoutResult;
            }
            i = this._previousLastVisibleOffset;
        }
        return i;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public void appendSelectableInfoToBuilder(SelectionLayoutBuilder builder) {
        TextLayoutResult invoke;
        long m4129minusMKHz9U;
        LayoutCoordinates layoutCoordinates = getLayoutCoordinates();
        if (layoutCoordinates == null || (invoke = this.layoutResultCallback.invoke()) == null) {
            return;
        }
        long mo5741localPositionOfR5De75A = builder.getContainerCoordinates().mo5741localPositionOfR5De75A(layoutCoordinates, Offset.INSTANCE.m4141getZeroF1C5BW0());
        long m4129minusMKHz9U2 = Offset.m4129minusMKHz9U(builder.getCurrentPosition(), mo5741localPositionOfR5De75A);
        if ((builder.getPreviousHandlePosition() & 9223372034707292159L) == InlineClassHelperKt.UnspecifiedPackedFloats) {
            m4129minusMKHz9U = Offset.INSTANCE.m4140getUnspecifiedF1C5BW0();
        } else {
            m4129minusMKHz9U = Offset.m4129minusMKHz9U(builder.getPreviousHandlePosition(), mo5741localPositionOfR5De75A);
        }
        MultiWidgetSelectionDelegateKt.m1759appendSelectableInfoParwq6A(builder, invoke, m4129minusMKHz9U2, m4129minusMKHz9U, getSelectableId());
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public Selection getSelectAllSelection() {
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke == null) {
            return null;
        }
        int length = invoke.getLayoutInput().getText().length();
        return new Selection(new Selection.AnchorInfo(invoke.getBidiRunDirection(0), 0, getSelectableId()), new Selection.AnchorInfo(invoke.getBidiRunDirection(Math.max(length - 1, 0)), length, getSelectableId()), false);
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    /* renamed from: getHandlePosition-dBAh8RU, reason: not valid java name */
    public long mo1757getHandlePositiondBAh8RU(Selection selection, boolean isStartHandle) {
        TextLayoutResult invoke;
        if ((isStartHandle && selection.getStart().getSelectableId() != getSelectableId()) || (!isStartHandle && selection.getEnd().getSelectableId() != getSelectableId())) {
            return Offset.INSTANCE.m4140getUnspecifiedF1C5BW0();
        }
        if (getLayoutCoordinates() != null && (invoke = this.layoutResultCallback.invoke()) != null) {
            return TextSelectionDelegateKt.getSelectionHandleCoordinates(invoke, RangesKt.coerceIn((isStartHandle ? selection.getStart() : selection.getEnd()).getOffset(), 0, getLastVisibleOffset(invoke)), isStartHandle, selection.getHandlesCrossed());
        }
        return Offset.INSTANCE.m4140getUnspecifiedF1C5BW0();
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates invoke = this.coordinatesCallback.invoke();
        if (invoke == null || !invoke.isAttached()) {
            return null;
        }
        return invoke;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public TextLayoutResult textLayoutResult() {
        return this.layoutResultCallback.invoke();
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public AnnotatedString getText() {
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        return invoke == null ? new AnnotatedString("", null, 2, null) : invoke.getLayoutInput().getText();
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public Rect getBoundingBox(int offset) {
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke == null) {
            return Rect.INSTANCE.getZero();
        }
        int length = invoke.getLayoutInput().getText().length();
        if (length < 1) {
            return Rect.INSTANCE.getZero();
        }
        return invoke.getBoundingBox(RangesKt.coerceIn(offset, 0, length - 1));
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float getLineLeft(int offset) {
        int lineForOffset;
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke != null && (lineForOffset = invoke.getLineForOffset(offset)) < invoke.getLineCount()) {
            return invoke.getLineLeft(lineForOffset);
        }
        return -1.0f;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float getLineRight(int offset) {
        int lineForOffset;
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke != null && (lineForOffset = invoke.getLineForOffset(offset)) < invoke.getLineCount()) {
            return invoke.getLineRight(lineForOffset);
        }
        return -1.0f;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float getCenterYForOffset(int offset) {
        int lineForOffset;
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke == null || (lineForOffset = invoke.getLineForOffset(offset)) >= invoke.getLineCount()) {
            return -1.0f;
        }
        float lineTop = invoke.getLineTop(lineForOffset);
        return ((invoke.getLineBottom(lineForOffset) - lineTop) / 2.0f) + lineTop;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    /* renamed from: getRangeOfLineContaining--jx7JFs, reason: not valid java name */
    public long mo1758getRangeOfLineContainingjx7JFs(int offset) {
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke == null) {
            return TextRange.INSTANCE.m6440getZerod9O1mEE();
        }
        int lastVisibleOffset = getLastVisibleOffset(invoke);
        if (lastVisibleOffset < 1) {
            return TextRange.INSTANCE.m6440getZerod9O1mEE();
        }
        int lineForOffset = invoke.getLineForOffset(RangesKt.coerceIn(offset, 0, lastVisibleOffset - 1));
        return TextRangeKt.TextRange(invoke.getLineStart(lineForOffset), invoke.getLineEnd(lineForOffset, true));
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public int getLastVisibleOffset() {
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke == null) {
            return 0;
        }
        return getLastVisibleOffset(invoke);
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float getLineHeight(int offset) {
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke != null) {
            return TextLayoutHelperKt.getLineHeight(invoke, offset);
        }
        return 0.0f;
    }
}
