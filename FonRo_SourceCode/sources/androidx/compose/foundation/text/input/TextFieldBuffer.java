package androidx.compose.foundation.text.input;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.input.internal.ChangeTracker;
import androidx.compose.foundation.text.input.internal.OffsetMappingCalculator;
import androidx.compose.foundation.text.input.internal.PartialGapBuffer;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* compiled from: TextFieldBuffer.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001sB1\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0014\u0010@\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010A\u001a\u00020BH\u0016J\u0016\u0010@\u001a\u00060\u0001j\u0002`\u00022\b\u0010C\u001a\u0004\u0018\u000105H\u0016J&\u0010@\u001a\u00060\u0001j\u0002`\u00022\b\u0010C\u001a\u0004\u0018\u0001052\u0006\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020.H\u0016J\u0006\u0010F\u001a\u000205J\u000e\u0010G\u001a\u00020B2\u0006\u0010H\u001a\u00020.J\b\u0010I\u001a\u00020JH\u0002J\r\u0010K\u001a\u00020JH\u0000¢\u0006\u0002\bLJ\r\u0010M\u001a\u00020JH\u0000¢\u0006\u0002\bNJ\r\u0010O\u001a\u00020&H\u0000¢\u0006\u0002\bPJ \u0010Q\u001a\u00020J2\u0006\u0010R\u001a\u00020.2\u0006\u0010S\u001a\u00020.2\u0006\u0010T\u001a\u00020.H\u0002J\u000e\u0010U\u001a\u00020J2\u0006\u0010H\u001a\u00020.J\u000e\u0010V\u001a\u00020J2\u0006\u0010H\u001a\u00020.J\u001e\u0010W\u001a\u00020J2\u0006\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020.2\u0006\u0010C\u001a\u000205J9\u0010W\u001a\u00020J2\u0006\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020.2\u0006\u0010C\u001a\u0002052\b\b\u0002\u0010X\u001a\u00020.2\b\b\u0002\u0010Y\u001a\u00020.H\u0000¢\u0006\u0002\bZJ \u0010[\u001a\u00020J2\u0006\u0010H\u001a\u00020.2\u0006\u0010\\\u001a\u00020&2\u0006\u0010]\u001a\u00020&H\u0002J\u001a\u0010^\u001a\u00020J2\u0006\u0010_\u001a\u00020\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\b`\u0010=J\u0006\u0010a\u001a\u00020JJ9\u0010b\u001a\u00020J2\u0006\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020.2\u001a\b\u0002\u0010c\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u001a0\u0019j\u0002`e\u0018\u00010dH\u0000¢\u0006\u0002\bfJ*\u0010g\u001a\u00020J2\u0006\u0010h\u001a\u00020)2\u0006\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020.H\u0000ø\u0001\u0000¢\u0006\u0004\bi\u0010jJ\u0015\u0010k\u001a\u00020J2\u0006\u0010l\u001a\u000205H\u0000¢\u0006\u0002\bmJ\b\u0010n\u001a\u00020oH\u0016JD\u0010p\u001a\u00020\u00042\b\b\u0002\u0010:\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\u001a\b\u0002\u0010\u001b\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u001a0\u0019j\u0002`e\u0018\u00010dH\u0000ø\u0001\u0000¢\u0006\u0004\bq\u0010rR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00128FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R:\u0010\u001b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0018\u00010\u00182\u0014\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0018\u00010\u0018@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR.\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f@BX\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020&8G¢\u0006\u0006\u001a\u0004\b%\u0010'R:\u0010*\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u001f\u0018\u00010(2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u001f\u0018\u00010(@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00101\u001a\u00020\u001f8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b2\u00103R\u0011\u00104\u001a\u0002058F¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u0010\u0007\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R*\u0010:\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f8F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b;\u00103\"\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u001fX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010?\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006t"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldBuffer;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "initialValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "initialChanges", "Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "originalValue", "offsetMappingCalculator", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/ChangeTracker;Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)V", "backingChangeTracker", "buffer", "Landroidx/compose/foundation/text/input/internal/PartialGapBuffer;", "changeTracker", "getChangeTracker$foundation_release", "()Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "changes", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "getChanges$annotations", "()V", "getChanges", "()Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "<set-?>", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "composingAnnotations", "getComposingAnnotations$foundation_release", "()Landroidx/compose/runtime/collection/MutableVector;", "value", "Landroidx/compose/ui/text/TextRange;", "composition", "getComposition-MzsxiRA$foundation_release", "()Landroidx/compose/ui/text/TextRange;", "setComposition-OEnZFl4", "(Landroidx/compose/ui/text/TextRange;)V", "hasSelection", "", "()Z", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/input/TextHighlightType;", "highlight", "getHighlight$foundation_release", "()Lkotlin/Pair;", "length", "", "getLength", "()I", "originalSelection", "getOriginalSelection-d9O1mEE", "()J", "originalText", "", "getOriginalText", "()Ljava/lang/CharSequence;", "getOriginalValue$foundation_release", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "selection", "getSelection-d9O1mEE", "setSelection-5zc-tL8", "(J)V", "selectionInChars", "J", "append", "char", "", "text", "start", "end", "asCharSequence", "charAt", FirebaseAnalytics.Param.INDEX, "clearChangeList", "", "clearHighlight", "clearHighlight$foundation_release", "commitComposition", "commitComposition$foundation_release", "hasComposition", "hasComposition$foundation_release", "onTextWillChange", "replaceStart", "replaceEnd", "newLength", "placeCursorAfterCharAt", "placeCursorBeforeCharAt", "replace", "textStart", "textEnd", "replace$foundation_release", "requireValidIndex", "startExclusive", "endExclusive", "requireValidRange", "range", "requireValidRange-5zc-tL8", "revertAllChanges", "setComposition", "annotations", "", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "setComposition$foundation_release", "setHighlight", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "setHighlight-K7f2yys$foundation_release", "(III)V", "setTextIfChanged", "newText", "setTextIfChanged$foundation_release", "toString", "", "toTextFieldCharSequence", "toTextFieldCharSequence-I88jaVs$foundation_release", "(JLandroidx/compose/ui/text/TextRange;Ljava/util/List;)Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "ChangeList", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldBuffer implements Appendable {
    public static final int $stable = 8;
    private ChangeTracker backingChangeTracker;
    private final PartialGapBuffer buffer;
    private MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> composingAnnotations;
    private TextRange composition;
    private Pair<TextHighlightType, TextRange> highlight;
    private final OffsetMappingCalculator offsetMappingCalculator;
    private final TextFieldCharSequence originalValue;
    private long selectionInChars;

    /* compiled from: TextFieldBuffer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "", "changeCount", "", "getChangeCount", "()I", "getOriginalRange", "Landroidx/compose/ui/text/TextRange;", "changeIndex", "getOriginalRange--jx7JFs", "(I)J", "getRange", "getRange--jx7JFs", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public interface ChangeList {
        int getChangeCount();

        /* renamed from: getOriginalRange--jx7JFs, reason: not valid java name */
        long mo1508getOriginalRangejx7JFs(int changeIndex);

        /* renamed from: getRange--jx7JFs, reason: not valid java name */
        long mo1509getRangejx7JFs(int changeIndex);
    }

    public static /* synthetic */ void getChanges$annotations() {
    }

    public TextFieldBuffer(final TextFieldCharSequence textFieldCharSequence, ChangeTracker changeTracker, TextFieldCharSequence textFieldCharSequence2, OffsetMappingCalculator offsetMappingCalculator) {
        this.originalValue = textFieldCharSequence2;
        this.offsetMappingCalculator = offsetMappingCalculator;
        this.buffer = new PartialGapBuffer(textFieldCharSequence);
        MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> mutableVector = null;
        this.backingChangeTracker = changeTracker != null ? new ChangeTracker(changeTracker) : null;
        this.selectionInChars = textFieldCharSequence.getSelection();
        this.composition = textFieldCharSequence.getComposition();
        List<AnnotatedString.Range<AnnotatedString.Annotation>> composingAnnotations = textFieldCharSequence.getComposingAnnotations();
        if (composingAnnotations != null && !composingAnnotations.isEmpty()) {
            int size = textFieldCharSequence.getComposingAnnotations().size();
            Function1<Integer, AnnotatedString.Range<AnnotatedString.Annotation>> function1 = new Function1<Integer, AnnotatedString.Range<AnnotatedString.Annotation>>() { // from class: androidx.compose.foundation.text.input.TextFieldBuffer$composingAnnotations$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ AnnotatedString.Range<AnnotatedString.Annotation> invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final AnnotatedString.Range<AnnotatedString.Annotation> invoke(int i) {
                    return TextFieldCharSequence.this.getComposingAnnotations().get(i);
                }
            };
            AnnotatedString.Range[] rangeArr = new AnnotatedString.Range[size];
            for (int i = 0; i < size; i++) {
                rangeArr[i] = function1.invoke(Integer.valueOf(i));
            }
            mutableVector = new MutableVector<>(rangeArr, size);
        }
        this.composingAnnotations = mutableVector;
    }

    public /* synthetic */ TextFieldBuffer(TextFieldCharSequence textFieldCharSequence, ChangeTracker changeTracker, TextFieldCharSequence textFieldCharSequence2, OffsetMappingCalculator offsetMappingCalculator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textFieldCharSequence, (i & 2) != 0 ? null : changeTracker, (i & 4) != 0 ? textFieldCharSequence : textFieldCharSequence2, (i & 8) != 0 ? null : offsetMappingCalculator);
    }

    /* renamed from: getOriginalValue$foundation_release, reason: from getter */
    public final TextFieldCharSequence getOriginalValue() {
        return this.originalValue;
    }

    public final ChangeTracker getChangeTracker$foundation_release() {
        ChangeTracker changeTracker = this.backingChangeTracker;
        if (changeTracker != null) {
            return changeTracker;
        }
        ChangeTracker changeTracker2 = new ChangeTracker(null, 1, null);
        this.backingChangeTracker = changeTracker2;
        return changeTracker2;
    }

    public final int getLength() {
        return this.buffer.length();
    }

    public final CharSequence getOriginalText() {
        return this.originalValue.getText();
    }

    /* renamed from: getOriginalSelection-d9O1mEE, reason: not valid java name */
    public final long m1503getOriginalSelectiond9O1mEE() {
        return this.originalValue.getSelection();
    }

    public final ChangeList getChanges() {
        return getChangeTracker$foundation_release();
    }

    public final boolean hasSelection() {
        return !TextRange.m6429getCollapsedimpl(getSelectionInChars());
    }

    /* renamed from: getSelection-d9O1mEE, reason: not valid java name and from getter */
    public final long getSelectionInChars() {
        return this.selectionInChars;
    }

    /* renamed from: setSelection-5zc-tL8, reason: not valid java name */
    public final void m1506setSelection5zctL8(long j) {
        m1499requireValidRange5zctL8(j);
        this.selectionInChars = j;
        this.highlight = null;
    }

    /* renamed from: getComposition-MzsxiRA$foundation_release, reason: not valid java name and from getter */
    public final TextRange getComposition() {
        return this.composition;
    }

    /* renamed from: setComposition-OEnZFl4, reason: not valid java name */
    private final void m1500setCompositionOEnZFl4(TextRange textRange) {
        if (textRange == null || TextRange.m6429getCollapsedimpl(textRange.getPackedValue())) {
            this.composition = null;
            MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> mutableVector = this.composingAnnotations;
            if (mutableVector != null) {
                mutableVector.clear();
                return;
            }
            return;
        }
        this.composition = textRange;
    }

    public final MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> getComposingAnnotations$foundation_release() {
        return this.composingAnnotations;
    }

    public final boolean hasComposition$foundation_release() {
        return this.composition != null;
    }

    public final void commitComposition$foundation_release() {
        m1500setCompositionOEnZFl4(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setComposition$foundation_release$default(TextFieldBuffer textFieldBuffer, int i, int i2, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            list = null;
        }
        textFieldBuffer.setComposition$foundation_release(i, i2, list);
    }

    public final void setComposition$foundation_release(int start, int end, List<AnnotatedString.Range<AnnotatedString.Annotation>> annotations) {
        if (start < 0 || start > this.buffer.length()) {
            throw new IndexOutOfBoundsException("start (" + start + ") offset is outside of text region " + this.buffer.length());
        }
        if (end < 0 || end > this.buffer.length()) {
            throw new IndexOutOfBoundsException("end (" + end + ") offset is outside of text region " + this.buffer.length());
        }
        if (start >= end) {
            throw new IllegalArgumentException("Do not set reversed or empty range: " + start + " > " + end);
        }
        m1500setCompositionOEnZFl4(TextRange.m6423boximpl(TextRangeKt.TextRange(start, end)));
        MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> mutableVector = this.composingAnnotations;
        if (mutableVector != null) {
            mutableVector.clear();
        }
        List<AnnotatedString.Range<AnnotatedString.Annotation>> list = annotations;
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.composingAnnotations == null) {
            this.composingAnnotations = new MutableVector<>(new AnnotatedString.Range[16], 0);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<AnnotatedString.Annotation> range = annotations.get(i);
            MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> mutableVector2 = this.composingAnnotations;
            if (mutableVector2 != null) {
                mutableVector2.add(AnnotatedString.Range.copy$default(range, null, range.getStart() + start, range.getEnd() + start, null, 9, null));
            }
        }
    }

    public final Pair<TextHighlightType, TextRange> getHighlight$foundation_release() {
        return this.highlight;
    }

    /* renamed from: setHighlight-K7f2yys$foundation_release, reason: not valid java name */
    public final void m1505setHighlightK7f2yys$foundation_release(int type, int start, int end) {
        if (start >= end) {
            throw new IllegalArgumentException("Do not set reversed or empty range: " + start + " > " + end);
        }
        this.highlight = new Pair<>(TextHighlightType.m1518boximpl(type), TextRange.m6423boximpl(TextRangeKt.TextRange(RangesKt.coerceIn(start, 0, getLength()), RangesKt.coerceIn(end, 0, getLength()))));
    }

    public final void clearHighlight$foundation_release() {
        this.highlight = null;
    }

    public final void replace(int start, int end, CharSequence text) {
        replace$foundation_release(start, end, text, 0, text.length());
    }

    public static /* synthetic */ void replace$foundation_release$default(TextFieldBuffer textFieldBuffer, int i, int i2, CharSequence charSequence, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i3 = 0;
        }
        int i6 = i3;
        if ((i5 & 16) != 0) {
            i4 = charSequence.length();
        }
        textFieldBuffer.replace$foundation_release(i, i2, charSequence, i6, i4);
    }

    public final void replace$foundation_release(int start, int end, CharSequence text, int textStart, int textEnd) {
        if (!(start <= end)) {
            InlineClassHelperKt.throwIllegalArgumentException("Expected start=" + start + " <= end=" + end);
        }
        if (!(textStart <= textEnd)) {
            InlineClassHelperKt.throwIllegalArgumentException("Expected textStart=" + textStart + " <= textEnd=" + textEnd);
        }
        onTextWillChange(start, end, textEnd - textStart);
        this.buffer.replace(start, end, text, textStart, textEnd);
        commitComposition$foundation_release();
        clearHighlight$foundation_release();
    }

    public final void setTextIfChanged$foundation_release(CharSequence newText) {
        int i;
        int i2;
        PartialGapBuffer partialGapBuffer = this.buffer;
        int length = partialGapBuffer.length();
        int length2 = newText.length();
        boolean z = false;
        if (partialGapBuffer.length() <= 0 || newText.length() <= 0) {
            i = 0;
            i2 = 0;
        } else {
            int i3 = 0;
            int i4 = 0;
            boolean z2 = false;
            while (true) {
                if (!z) {
                    if (partialGapBuffer.charAt(i3) == newText.charAt(i4)) {
                        i3++;
                        i4++;
                    } else {
                        z = true;
                    }
                }
                if (!z2) {
                    if (partialGapBuffer.charAt(length - 1) == newText.charAt(length2 - 1)) {
                        length--;
                        length2--;
                    } else {
                        z2 = true;
                    }
                }
                if (i3 >= length || i4 >= length2 || (z && z2)) {
                    break;
                }
            }
            i = i3;
            i2 = i4;
        }
        int i5 = length;
        int i6 = length2;
        if (i < i5 || i2 < i6) {
            replace$foundation_release(i, i5, newText, i2, i6);
        }
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence text) {
        if (text != null) {
            onTextWillChange(getLength(), getLength(), text.length());
            PartialGapBuffer partialGapBuffer = this.buffer;
            PartialGapBuffer.replace$default(partialGapBuffer, partialGapBuffer.length(), this.buffer.length(), text, 0, 0, 24, null);
        }
        return this;
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence text, int start, int end) {
        if (text != null) {
            onTextWillChange(getLength(), getLength(), end - start);
            PartialGapBuffer partialGapBuffer = this.buffer;
            PartialGapBuffer.replace$default(partialGapBuffer, partialGapBuffer.length(), this.buffer.length(), text.subSequence(start, end), 0, 0, 24, null);
        }
        return this;
    }

    @Override // java.lang.Appendable
    public Appendable append(char r12) {
        onTextWillChange(getLength(), getLength(), 1);
        PartialGapBuffer partialGapBuffer = this.buffer;
        PartialGapBuffer.replace$default(partialGapBuffer, partialGapBuffer.length(), this.buffer.length(), String.valueOf(r12), 0, 0, 24, null);
        return this;
    }

    private final void onTextWillChange(int replaceStart, int replaceEnd, int newLength) {
        getChangeTracker$foundation_release().trackChange(replaceStart, replaceEnd, newLength);
        OffsetMappingCalculator offsetMappingCalculator = this.offsetMappingCalculator;
        if (offsetMappingCalculator != null) {
            offsetMappingCalculator.recordEditOperation(replaceStart, replaceEnd, newLength);
        }
        this.selectionInChars = TextFieldBufferKt.m1510adjustTextRangevJH6DeI(getSelectionInChars(), replaceStart, replaceEnd, newLength);
    }

    public final char charAt(int index) {
        return this.buffer.charAt(index);
    }

    public String toString() {
        return this.buffer.toString();
    }

    public final CharSequence asCharSequence() {
        return this.buffer;
    }

    private final void clearChangeList() {
        getChangeTracker$foundation_release().clearChanges();
    }

    public final void revertAllChanges() {
        replace(0, getLength(), this.originalValue.toString());
        m1506setSelection5zctL8(this.originalValue.getSelection());
        clearChangeList();
    }

    public final void placeCursorBeforeCharAt(int index) {
        requireValidIndex(index, true, false);
        this.selectionInChars = TextRangeKt.TextRange(index);
    }

    public final void placeCursorAfterCharAt(int index) {
        requireValidIndex(index, false, true);
        this.selectionInChars = TextRangeKt.TextRange(RangesKt.coerceAtMost(index + 1, getLength()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: toTextFieldCharSequence-I88jaVs$foundation_release$default, reason: not valid java name */
    public static /* synthetic */ TextFieldCharSequence m1501toTextFieldCharSequenceI88jaVs$foundation_release$default(TextFieldBuffer textFieldBuffer, long j, TextRange textRange, List list, int i, Object obj) {
        MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> mutableVector;
        if ((i & 1) != 0) {
            j = textFieldBuffer.getSelectionInChars();
        }
        if ((i & 2) != 0) {
            textRange = textFieldBuffer.composition;
        }
        if ((i & 4) != 0 && ((mutableVector = textFieldBuffer.composingAnnotations) == null || (list = mutableVector.asMutableList()) == null || list.isEmpty())) {
            list = null;
        }
        return textFieldBuffer.m1507toTextFieldCharSequenceI88jaVs$foundation_release(j, textRange, list);
    }

    /* renamed from: toTextFieldCharSequence-I88jaVs$foundation_release, reason: not valid java name */
    public final TextFieldCharSequence m1507toTextFieldCharSequenceI88jaVs$foundation_release(long selection, TextRange composition, List<AnnotatedString.Range<AnnotatedString.Annotation>> composingAnnotations) {
        return new TextFieldCharSequence(this.buffer.toString(), selection, composition, null, composingAnnotations, 8, null);
    }

    private final void requireValidIndex(int index, boolean startExclusive, boolean endExclusive) {
        boolean z = false;
        int i = startExclusive ? 0 : -1;
        int length = getLength();
        if (!endExclusive) {
            length++;
        }
        if (i <= index && index < length) {
            z = true;
        }
        if (z) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Expected " + index + " to be in [" + i + ", " + length + ')');
    }

    /* renamed from: requireValidRange-5zc-tL8, reason: not valid java name */
    private final void m1499requireValidRange5zctL8(long range) {
        long TextRange = TextRangeKt.TextRange(0, getLength());
        if (TextRange.m6425contains5zctL8(TextRange, range)) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Expected " + ((Object) TextRange.m6438toStringimpl(range)) + " to be in " + ((Object) TextRange.m6438toStringimpl(TextRange)));
    }
}
