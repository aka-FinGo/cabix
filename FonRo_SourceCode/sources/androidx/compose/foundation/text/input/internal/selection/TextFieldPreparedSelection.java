package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* compiled from: TextPreparedSelection.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0000\u0018\u0000 W2\u00020\u0001:\u0001WB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ,\u0010$\u001a\u00020\u00002\b\b\u0002\u0010%\u001a\u00020\u00072\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\b)H\u0082\bJ\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0002J\u001f\u0010-\u001a\u00020\u00002\u0017\u0010.\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\b)J\u001f\u0010/\u001a\u00020\u00002\u0017\u0010.\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\b)J\u0006\u00100\u001a\u00020\u0000J\u0006\u00101\u001a\u00020\u0000J\u0006\u00102\u001a\u00020+J\u0006\u00103\u001a\u00020+J\b\u00104\u001a\u00020\u0007H\u0002J\u0010\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020+H\u0002J\u0006\u00107\u001a\u00020\u0000J\u0006\u00108\u001a\u00020\u0000J\u0006\u00109\u001a\u00020\u0000J\u0006\u0010:\u001a\u00020\u0000J\u0006\u0010;\u001a\u00020\u0000J\u0006\u0010<\u001a\u00020\u0000J\u0006\u0010=\u001a\u00020\u0000J\u0006\u0010>\u001a\u00020\u0000J\u0006\u0010?\u001a\u00020\u0000J\u0006\u0010@\u001a\u00020\u0000J\u0006\u0010A\u001a\u00020\u0000J\u0006\u0010B\u001a\u00020\u0000J!\u0010C\u001a\u00020\u00002\b\b\u0002\u0010%\u001a\u00020\u00072\f\u0010D\u001a\b\u0012\u0004\u0012\u00020+0EH\u0082\bJ\u0006\u0010F\u001a\u00020\u0000J\u0006\u0010G\u001a\u00020\u0000J\u0006\u0010H\u001a\u00020\u0000J\u0006\u0010I\u001a\u00020\u0000J\u0006\u0010J\u001a\u00020\u0000J\u0006\u0010K\u001a\u00020\u0000J\u0006\u0010L\u001a\u00020\u0000J\u0006\u0010M\u001a\u00020\u0000J\u0006\u0010N\u001a\u00020\u0000J\u0006\u0010O\u001a\u00020\u0000J\u0016\u0010P\u001a\u00020+*\u00020\u00052\b\b\u0002\u0010Q\u001a\u00020+H\u0002J\u0016\u0010R\u001a\u00020+*\u00020\u00052\b\b\u0002\u0010Q\u001a\u00020+H\u0002J\u0017\u0010S\u001a\u00020+*\u00020\u00052\b\b\u0002\u0010Q\u001a\u00020+H\u0082\u0010J\u0017\u0010T\u001a\u00020+*\u00020\u00052\b\b\u0002\u0010Q\u001a\u00020+H\u0082\u0010J\u0014\u0010U\u001a\u00020+*\u00020\u00052\u0006\u0010V\u001a\u00020+H\u0002R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u00020\u0016X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006X"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelection;", "", "state", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "isFromSoftKeyboard", "", "visibleTextLayoutHeight", "", "textPreparedSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/TextLayoutResult;ZFLandroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;)V", "initialValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getInitialValue", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "initialWedgeAffinity", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "getInitialWedgeAffinity", "()Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "selection", "Landroidx/compose/ui/text/TextRange;", "getSelection-d9O1mEE", "()J", "setSelection-5zc-tL8", "(J)V", "J", "text", "", "wedgeAffinity", "Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "getWedgeAffinity", "()Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "setWedgeAffinity", "(Landroidx/compose/foundation/text/input/internal/WedgeAffinity;)V", "applyIfNotEmpty", "resetCachedX", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "charOffset", "", TypedValues.CycleType.S_WAVE_OFFSET, "collapseLeftOr", "or", "collapseRightOr", "deleteMovement", "deselect", "getNextCharacterIndex", "getPrecedingCharacterIndex", "isLtr", "jumpByPagesOffset", "pagesAmount", "moveCursorDownByLine", "moveCursorDownByPage", "moveCursorLeftByChar", "moveCursorLeftByWord", "moveCursorNextByChar", "moveCursorNextByParagraph", "moveCursorNextByWord", "moveCursorPrevByChar", "moveCursorPrevByParagraph", "moveCursorPrevByWord", "moveCursorRightByChar", "moveCursorRightByWord", "moveCursorTo", "proposedCursorMovement", "Lkotlin/Function0;", "moveCursorToEnd", "moveCursorToHome", "moveCursorToLineEnd", "moveCursorToLineLeftSide", "moveCursorToLineRightSide", "moveCursorToLineStart", "moveCursorUpByLine", "moveCursorUpByPage", "selectAll", "selectMovement", "getLineEndByOffsetForLayout", "currentOffset", "getLineStartByOffsetForLayout", "getNextWordOffsetForLayout", "getPrevWordOffsetForLayout", "jumpByLinesOffset", "linesAmount", "Companion", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldPreparedSelection {
    public static final int NoCharacterFound = -1;
    private final TextFieldCharSequence initialValue;
    private final SelectionWedgeAffinity initialWedgeAffinity;
    private final boolean isFromSoftKeyboard;
    private long selection;
    private final TransformedTextFieldState state;
    private final String text;
    private final TextLayoutResult textLayoutResult;
    private final TextFieldPreparedSelectionState textPreparedSelectionState;
    private final float visibleTextLayoutHeight;
    private WedgeAffinity wedgeAffinity;
    public static final int $stable = 8;

    public TextFieldPreparedSelection(TransformedTextFieldState transformedTextFieldState, TextLayoutResult textLayoutResult, boolean z, float f, TextFieldPreparedSelectionState textFieldPreparedSelectionState) {
        this.state = transformedTextFieldState;
        this.textLayoutResult = textLayoutResult;
        this.isFromSoftKeyboard = z;
        this.visibleTextLayoutHeight = f;
        this.textPreparedSelectionState = textFieldPreparedSelectionState;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            TextFieldCharSequence visualText = transformedTextFieldState.getVisualText();
            this.initialValue = visualText;
            this.initialWedgeAffinity = transformedTextFieldState.getSelectionWedgeAffinity();
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            this.selection = visualText.getSelection();
            this.text = visualText.getText().toString();
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    public final TextFieldCharSequence getInitialValue() {
        return this.initialValue;
    }

    public final SelectionWedgeAffinity getInitialWedgeAffinity() {
        return this.initialWedgeAffinity;
    }

    /* renamed from: getSelection-d9O1mEE, reason: not valid java name and from getter */
    public final long getSelection() {
        return this.selection;
    }

    /* renamed from: setSelection-5zc-tL8, reason: not valid java name */
    public final void m1675setSelection5zctL8(long j) {
        this.selection = j;
    }

    public final WedgeAffinity getWedgeAffinity() {
        return this.wedgeAffinity;
    }

    public final void setWedgeAffinity(WedgeAffinity wedgeAffinity) {
        this.wedgeAffinity = wedgeAffinity;
    }

    private final TextFieldPreparedSelection applyIfNotEmpty(boolean resetCachedX, Function1<? super TextFieldPreparedSelection, Unit> block) {
        if (resetCachedX) {
            this.textPreparedSelectionState.resetCachedX();
        }
        if (this.text.length() > 0) {
            block.invoke(this);
        }
        return this;
    }

    static /* synthetic */ TextFieldPreparedSelection applyIfNotEmpty$default(TextFieldPreparedSelection textFieldPreparedSelection, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if (z) {
            textFieldPreparedSelection.textPreparedSelectionState.resetCachedX();
        }
        if (textFieldPreparedSelection.text.length() > 0) {
            function1.invoke(textFieldPreparedSelection);
        }
        return textFieldPreparedSelection;
    }

    public final TextFieldPreparedSelection moveCursorLeftByChar() {
        if (isLtr()) {
            return moveCursorPrevByChar();
        }
        return moveCursorNextByChar();
    }

    public final TextFieldPreparedSelection moveCursorRightByChar() {
        if (isLtr()) {
            return moveCursorNextByChar();
        }
        return moveCursorPrevByChar();
    }

    public final int getPrecedingCharacterIndex() {
        return StringHelpers_androidKt.findPrecedingBreak(this.text, TextRange.m6430getEndimpl(this.selection));
    }

    public final int getNextCharacterIndex() {
        return StringHelpers_androidKt.findFollowingBreak(this.text, TextRange.m6430getEndimpl(this.selection));
    }

    public final TextFieldPreparedSelection moveCursorLeftByWord() {
        if (isLtr()) {
            return moveCursorPrevByWord();
        }
        return moveCursorNextByWord();
    }

    public final TextFieldPreparedSelection moveCursorRightByWord() {
        if (isLtr()) {
            return moveCursorNextByWord();
        }
        return moveCursorPrevByWord();
    }

    public final TextFieldPreparedSelection moveCursorToLineLeftSide() {
        if (isLtr()) {
            return moveCursorToLineStart();
        }
        return moveCursorToLineEnd();
    }

    public final TextFieldPreparedSelection moveCursorToLineRightSide() {
        if (isLtr()) {
            return moveCursorToLineEnd();
        }
        return moveCursorToLineStart();
    }

    private final boolean isLtr() {
        ResolvedTextDirection paragraphDirection;
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        return textLayoutResult == null || (paragraphDirection = textLayoutResult.getParagraphDirection(TextRange.m6430getEndimpl(this.selection))) == null || paragraphDirection == ResolvedTextDirection.Ltr;
    }

    static /* synthetic */ int getNextWordOffsetForLayout$default(TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = TextRange.m6430getEndimpl(textFieldPreparedSelection.selection);
        }
        return textFieldPreparedSelection.getNextWordOffsetForLayout(textLayoutResult, i);
    }

    private final int getNextWordOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        while (i < this.initialValue.length()) {
            long m6407getWordBoundaryjx7JFs = textLayoutResult.m6407getWordBoundaryjx7JFs(charOffset(i));
            if (TextRange.m6430getEndimpl(m6407getWordBoundaryjx7JFs) > i) {
                return TextRange.m6430getEndimpl(m6407getWordBoundaryjx7JFs);
            }
            i++;
        }
        return this.initialValue.length();
    }

    static /* synthetic */ int getPrevWordOffsetForLayout$default(TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = TextRange.m6430getEndimpl(textFieldPreparedSelection.selection);
        }
        return textFieldPreparedSelection.getPrevWordOffsetForLayout(textLayoutResult, i);
    }

    private final int getPrevWordOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        while (i > 0) {
            long m6407getWordBoundaryjx7JFs = textLayoutResult.m6407getWordBoundaryjx7JFs(charOffset(i));
            if (TextRange.m6435getStartimpl(m6407getWordBoundaryjx7JFs) < i) {
                return TextRange.m6435getStartimpl(m6407getWordBoundaryjx7JFs);
            }
            i--;
        }
        return 0;
    }

    static /* synthetic */ int getLineStartByOffsetForLayout$default(TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = TextRange.m6433getMinimpl(textFieldPreparedSelection.selection);
        }
        return textFieldPreparedSelection.getLineStartByOffsetForLayout(textLayoutResult, i);
    }

    private final int getLineStartByOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        return textLayoutResult.getLineStart(textLayoutResult.getLineForOffset(i));
    }

    static /* synthetic */ int getLineEndByOffsetForLayout$default(TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = TextRange.m6432getMaximpl(textFieldPreparedSelection.selection);
        }
        return textFieldPreparedSelection.getLineEndByOffsetForLayout(textLayoutResult, i);
    }

    private final int getLineEndByOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        return textLayoutResult.getLineEnd(textLayoutResult.getLineForOffset(i), true);
    }

    private final int jumpByLinesOffset(TextLayoutResult textLayoutResult, int i) {
        int m6430getEndimpl = TextRange.m6430getEndimpl(this.selection);
        if (Float.isNaN(this.textPreparedSelectionState.getCachedX())) {
            this.textPreparedSelectionState.setCachedX(textLayoutResult.getCursorRect(m6430getEndimpl).getLeft());
        }
        int lineForOffset = textLayoutResult.getLineForOffset(m6430getEndimpl) + i;
        if (lineForOffset < 0) {
            return 0;
        }
        if (lineForOffset >= textLayoutResult.getLineCount()) {
            return this.text.length();
        }
        float lineBottom = textLayoutResult.getLineBottom(lineForOffset) - 1.0f;
        float cachedX = this.textPreparedSelectionState.getCachedX();
        if ((isLtr() && cachedX >= textLayoutResult.getLineRight(lineForOffset)) || (!isLtr() && cachedX <= textLayoutResult.getLineLeft(lineForOffset))) {
            return textLayoutResult.getLineEnd(lineForOffset, true);
        }
        return textLayoutResult.m6405getOffsetForPositionk4lQ0M(Offset.m4117constructorimpl((Float.floatToRawIntBits(cachedX) << 32) | (Float.floatToRawIntBits(lineBottom) & 4294967295L)));
    }

    private final int jumpByPagesOffset(int pagesAmount) {
        int m6430getEndimpl = TextRange.m6430getEndimpl(this.initialValue.getSelection());
        if (this.textLayoutResult == null || Float.isNaN(this.visibleTextLayoutHeight)) {
            return m6430getEndimpl;
        }
        Rect translate = this.textLayoutResult.getCursorRect(m6430getEndimpl).translate(0.0f, this.visibleTextLayoutHeight * pagesAmount);
        float lineBottom = this.textLayoutResult.getLineBottom(this.textLayoutResult.getLineForVerticalPosition(translate.getTop()));
        float abs = Math.abs(translate.getTop() - lineBottom);
        float abs2 = Math.abs(translate.getBottom() - lineBottom);
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        if (abs > abs2) {
            return textLayoutResult.m6405getOffsetForPositionk4lQ0M(translate.m4160getTopLeftF1C5BW0());
        }
        return textLayoutResult.m6405getOffsetForPositionk4lQ0M(translate.m4153getBottomLeftF1C5BW0());
    }

    private final int charOffset(int offset) {
        return RangesKt.coerceAtMost(offset, this.text.length() - 1);
    }

    public final TextFieldPreparedSelection selectAll() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            this.selection = TextRangeKt.TextRange(0, this.text.length());
        }
        return this;
    }

    public final TextFieldPreparedSelection deselect() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            this.selection = TextRangeKt.TextRange(TextRange.m6430getEndimpl(this.selection));
        }
        return this;
    }

    public final TextFieldPreparedSelection collapseLeftOr(Function1<? super TextFieldPreparedSelection, Unit> or) {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            if (TextRange.m6429getCollapsedimpl(this.selection)) {
                or.invoke(this);
                return this;
            }
            boolean isLtr = isLtr();
            long j = this.selection;
            if (isLtr) {
                this.selection = TextRangeKt.TextRange(TextRange.m6433getMinimpl(j));
                return this;
            }
            this.selection = TextRangeKt.TextRange(TextRange.m6432getMaximpl(j));
        }
        return this;
    }

    public final TextFieldPreparedSelection collapseRightOr(Function1<? super TextFieldPreparedSelection, Unit> or) {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            if (TextRange.m6429getCollapsedimpl(this.selection)) {
                or.invoke(this);
                return this;
            }
            boolean isLtr = isLtr();
            long j = this.selection;
            if (isLtr) {
                this.selection = TextRangeKt.TextRange(TextRange.m6432getMaximpl(j));
                return this;
            }
            this.selection = TextRangeKt.TextRange(TextRange.m6433getMinimpl(j));
        }
        return this;
    }

    private final TextFieldPreparedSelection moveCursorTo(boolean resetCachedX, Function0<Integer> proposedCursorMovement) {
        if (resetCachedX) {
            this.textPreparedSelectionState.resetCachedX();
        }
        if (this.text.length() > 0) {
            int m6430getEndimpl = TextRange.m6430getEndimpl(getSelection());
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(proposedCursorMovement.invoke().intValue(), m6430getEndimpl, this.state);
            int m1648component1impl = CursorAndWedgeAffinity.m1648component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1649component2impl = CursorAndWedgeAffinity.m1649component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1648component1impl != m6430getEndimpl || !TextRange.m6429getCollapsedimpl(getSelection())) {
                m1675setSelection5zctL8(TextRangeKt.TextRange(m1648component1impl));
            }
            if (m1649component2impl != null) {
                setWedgeAffinity(m1649component2impl);
            }
        }
        return this;
    }

    static /* synthetic */ TextFieldPreparedSelection moveCursorTo$default(TextFieldPreparedSelection textFieldPreparedSelection, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if (z) {
            textFieldPreparedSelection.textPreparedSelectionState.resetCachedX();
        }
        if (textFieldPreparedSelection.text.length() > 0) {
            int m6430getEndimpl = TextRange.m6430getEndimpl(textFieldPreparedSelection.getSelection());
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(((Number) function0.invoke()).intValue(), m6430getEndimpl, textFieldPreparedSelection.state);
            int m1648component1impl = CursorAndWedgeAffinity.m1648component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1649component2impl = CursorAndWedgeAffinity.m1649component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1648component1impl != m6430getEndimpl || !TextRange.m6429getCollapsedimpl(textFieldPreparedSelection.getSelection())) {
                textFieldPreparedSelection.m1675setSelection5zctL8(TextRangeKt.TextRange(m1648component1impl));
            }
            if (m1649component2impl != null) {
                textFieldPreparedSelection.setWedgeAffinity(m1649component2impl);
            }
        }
        return textFieldPreparedSelection;
    }

    public final TextFieldPreparedSelection moveCursorPrevByChar() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            int m6430getEndimpl = TextRange.m6430getEndimpl(getSelection());
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(StringHelpers_androidKt.findPrecedingBreak(this.text, TextRange.m6430getEndimpl(this.selection)), m6430getEndimpl, this.state);
            int m1648component1impl = CursorAndWedgeAffinity.m1648component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1649component2impl = CursorAndWedgeAffinity.m1649component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1648component1impl != m6430getEndimpl || !TextRange.m6429getCollapsedimpl(getSelection())) {
                m1675setSelection5zctL8(TextRangeKt.TextRange(m1648component1impl));
            }
            if (m1649component2impl != null) {
                setWedgeAffinity(m1649component2impl);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorNextByChar() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            int m6430getEndimpl = TextRange.m6430getEndimpl(getSelection());
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(StringHelpers_androidKt.findFollowingBreak(this.text, TextRange.m6430getEndimpl(this.selection)), m6430getEndimpl, this.state);
            int m1648component1impl = CursorAndWedgeAffinity.m1648component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1649component2impl = CursorAndWedgeAffinity.m1649component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1648component1impl != m6430getEndimpl || !TextRange.m6429getCollapsedimpl(getSelection())) {
                m1675setSelection5zctL8(TextRangeKt.TextRange(m1648component1impl));
            }
            if (m1649component2impl != null) {
                setWedgeAffinity(m1649component2impl);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorToHome() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            int m6430getEndimpl = TextRange.m6430getEndimpl(getSelection());
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(0, m6430getEndimpl, this.state);
            int m1648component1impl = CursorAndWedgeAffinity.m1648component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1649component2impl = CursorAndWedgeAffinity.m1649component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1648component1impl != m6430getEndimpl || !TextRange.m6429getCollapsedimpl(getSelection())) {
                m1675setSelection5zctL8(TextRangeKt.TextRange(m1648component1impl));
            }
            if (m1649component2impl != null) {
                setWedgeAffinity(m1649component2impl);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorToEnd() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            int m6430getEndimpl = TextRange.m6430getEndimpl(getSelection());
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(this.text.length(), m6430getEndimpl, this.state);
            int m1648component1impl = CursorAndWedgeAffinity.m1648component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1649component2impl = CursorAndWedgeAffinity.m1649component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1648component1impl != m6430getEndimpl || !TextRange.m6429getCollapsedimpl(getSelection())) {
                m1675setSelection5zctL8(TextRangeKt.TextRange(m1648component1impl));
            }
            if (m1649component2impl != null) {
                setWedgeAffinity(m1649component2impl);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorNextByWord() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            int m6430getEndimpl = TextRange.m6430getEndimpl(getSelection());
            TextLayoutResult textLayoutResult = this.textLayoutResult;
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(textLayoutResult != null ? getNextWordOffsetForLayout$default(this, textLayoutResult, 0, 1, null) : this.text.length(), m6430getEndimpl, this.state);
            int m1648component1impl = CursorAndWedgeAffinity.m1648component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1649component2impl = CursorAndWedgeAffinity.m1649component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1648component1impl != m6430getEndimpl || !TextRange.m6429getCollapsedimpl(getSelection())) {
                m1675setSelection5zctL8(TextRangeKt.TextRange(m1648component1impl));
            }
            if (m1649component2impl != null) {
                setWedgeAffinity(m1649component2impl);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorPrevByWord() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            int m6430getEndimpl = TextRange.m6430getEndimpl(getSelection());
            TextLayoutResult textLayoutResult = this.textLayoutResult;
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(textLayoutResult != null ? getPrevWordOffsetForLayout$default(this, textLayoutResult, 0, 1, null) : 0, m6430getEndimpl, this.state);
            int m1648component1impl = CursorAndWedgeAffinity.m1648component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1649component2impl = CursorAndWedgeAffinity.m1649component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1648component1impl != m6430getEndimpl || !TextRange.m6429getCollapsedimpl(getSelection())) {
                m1675setSelection5zctL8(TextRangeKt.TextRange(m1648component1impl));
            }
            if (m1649component2impl != null) {
                setWedgeAffinity(m1649component2impl);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorPrevByParagraph() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            int m6430getEndimpl = TextRange.m6430getEndimpl(getSelection());
            int findParagraphStart = StringHelpersKt.findParagraphStart(this.text, TextRange.m6433getMinimpl(this.selection));
            if (findParagraphStart == TextRange.m6433getMinimpl(this.selection) && findParagraphStart != 0) {
                findParagraphStart = StringHelpersKt.findParagraphStart(this.text, findParagraphStart - 1);
            }
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(findParagraphStart, m6430getEndimpl, this.state);
            int m1648component1impl = CursorAndWedgeAffinity.m1648component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1649component2impl = CursorAndWedgeAffinity.m1649component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1648component1impl != m6430getEndimpl || !TextRange.m6429getCollapsedimpl(getSelection())) {
                m1675setSelection5zctL8(TextRangeKt.TextRange(m1648component1impl));
            }
            if (m1649component2impl != null) {
                setWedgeAffinity(m1649component2impl);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorNextByParagraph() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            int m6430getEndimpl = TextRange.m6430getEndimpl(getSelection());
            int findParagraphEnd = StringHelpersKt.findParagraphEnd(this.text, TextRange.m6432getMaximpl(this.selection));
            if (findParagraphEnd == TextRange.m6432getMaximpl(this.selection) && findParagraphEnd != this.text.length()) {
                findParagraphEnd = StringHelpersKt.findParagraphEnd(this.text, findParagraphEnd + 1);
            }
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(findParagraphEnd, m6430getEndimpl, this.state);
            int m1648component1impl = CursorAndWedgeAffinity.m1648component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1649component2impl = CursorAndWedgeAffinity.m1649component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1648component1impl != m6430getEndimpl || !TextRange.m6429getCollapsedimpl(getSelection())) {
                m1675setSelection5zctL8(TextRangeKt.TextRange(m1648component1impl));
            }
            if (m1649component2impl != null) {
                setWedgeAffinity(m1649component2impl);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorUpByLine() {
        if (this.text.length() > 0) {
            int m6430getEndimpl = TextRange.m6430getEndimpl(getSelection());
            TextLayoutResult textLayoutResult = this.textLayoutResult;
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(textLayoutResult != null ? jumpByLinesOffset(textLayoutResult, -1) : 0, m6430getEndimpl, this.state);
            int m1648component1impl = CursorAndWedgeAffinity.m1648component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1649component2impl = CursorAndWedgeAffinity.m1649component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1648component1impl != m6430getEndimpl || !TextRange.m6429getCollapsedimpl(getSelection())) {
                m1675setSelection5zctL8(TextRangeKt.TextRange(m1648component1impl));
            }
            if (m1649component2impl != null) {
                setWedgeAffinity(m1649component2impl);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorDownByLine() {
        if (this.text.length() > 0) {
            int m6430getEndimpl = TextRange.m6430getEndimpl(getSelection());
            TextLayoutResult textLayoutResult = this.textLayoutResult;
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(textLayoutResult != null ? jumpByLinesOffset(textLayoutResult, 1) : this.text.length(), m6430getEndimpl, this.state);
            int m1648component1impl = CursorAndWedgeAffinity.m1648component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1649component2impl = CursorAndWedgeAffinity.m1649component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1648component1impl != m6430getEndimpl || !TextRange.m6429getCollapsedimpl(getSelection())) {
                m1675setSelection5zctL8(TextRangeKt.TextRange(m1648component1impl));
            }
            if (m1649component2impl != null) {
                setWedgeAffinity(m1649component2impl);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorToLineStart() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            int m6430getEndimpl = TextRange.m6430getEndimpl(getSelection());
            TextLayoutResult textLayoutResult = this.textLayoutResult;
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(textLayoutResult != null ? getLineStartByOffsetForLayout$default(this, textLayoutResult, 0, 1, null) : 0, m6430getEndimpl, this.state);
            int m1648component1impl = CursorAndWedgeAffinity.m1648component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1649component2impl = CursorAndWedgeAffinity.m1649component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1648component1impl != m6430getEndimpl || !TextRange.m6429getCollapsedimpl(getSelection())) {
                m1675setSelection5zctL8(TextRangeKt.TextRange(m1648component1impl));
            }
            if (m1649component2impl != null) {
                setWedgeAffinity(m1649component2impl);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorToLineEnd() {
        this.textPreparedSelectionState.resetCachedX();
        if (this.text.length() > 0) {
            int m6430getEndimpl = TextRange.m6430getEndimpl(getSelection());
            TextLayoutResult textLayoutResult = this.textLayoutResult;
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(textLayoutResult != null ? getLineEndByOffsetForLayout$default(this, textLayoutResult, 0, 1, null) : this.text.length(), m6430getEndimpl, this.state);
            int m1648component1impl = CursorAndWedgeAffinity.m1648component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1649component2impl = CursorAndWedgeAffinity.m1649component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1648component1impl != m6430getEndimpl || !TextRange.m6429getCollapsedimpl(getSelection())) {
                m1675setSelection5zctL8(TextRangeKt.TextRange(m1648component1impl));
            }
            if (m1649component2impl != null) {
                setWedgeAffinity(m1649component2impl);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorUpByPage() {
        if (this.text.length() > 0) {
            int m6430getEndimpl = TextRange.m6430getEndimpl(getSelection());
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(jumpByPagesOffset(-1), m6430getEndimpl, this.state);
            int m1648component1impl = CursorAndWedgeAffinity.m1648component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1649component2impl = CursorAndWedgeAffinity.m1649component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1648component1impl != m6430getEndimpl || !TextRange.m6429getCollapsedimpl(getSelection())) {
                m1675setSelection5zctL8(TextRangeKt.TextRange(m1648component1impl));
            }
            if (m1649component2impl != null) {
                setWedgeAffinity(m1649component2impl);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorDownByPage() {
        if (this.text.length() > 0) {
            int m6430getEndimpl = TextRange.m6430getEndimpl(getSelection());
            long calculateNextCursorPositionAndWedgeAffinity = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(jumpByPagesOffset(1), m6430getEndimpl, this.state);
            int m1648component1impl = CursorAndWedgeAffinity.m1648component1impl(calculateNextCursorPositionAndWedgeAffinity);
            WedgeAffinity m1649component2impl = CursorAndWedgeAffinity.m1649component2impl(calculateNextCursorPositionAndWedgeAffinity);
            if (m1648component1impl != m6430getEndimpl || !TextRange.m6429getCollapsedimpl(getSelection())) {
                m1675setSelection5zctL8(TextRangeKt.TextRange(m1648component1impl));
            }
            if (m1649component2impl != null) {
                setWedgeAffinity(m1649component2impl);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection selectMovement() {
        if (this.text.length() > 0) {
            this.selection = TextRangeKt.TextRange(TextRange.m6435getStartimpl(this.initialValue.getSelection()), TextRange.m6430getEndimpl(this.selection));
        }
        return this;
    }

    public final TextFieldPreparedSelection deleteMovement() {
        if (this.text.length() > 0) {
            boolean m6429getCollapsedimpl = TextRange.m6429getCollapsedimpl(this.initialValue.getSelection());
            TransformedTextFieldState transformedTextFieldState = this.state;
            if (!m6429getCollapsedimpl) {
                transformedTextFieldState.deleteSelectedText();
            } else {
                TransformedTextFieldState.m1633replaceTextM8tDOmk$default(transformedTextFieldState, "", TextRangeKt.TextRange(TextRange.m6435getStartimpl(this.initialValue.getSelection()), TextRange.m6430getEndimpl(this.selection)), null, !this.isFromSoftKeyboard, 4, null);
            }
            this.selection = this.state.getVisualText().getSelection();
            this.wedgeAffinity = WedgeAffinity.Start;
        }
        return this;
    }
}
