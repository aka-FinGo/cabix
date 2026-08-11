package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.internal.ToCharArray_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: TextFieldCharSequence.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007\u0012\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\r\u0018\u00010\n¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0001J\u0013\u0010!\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\"H\u0096\u0002J\u0011\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0016H\u0096\u0002J\b\u0010&\u001a\u00020\u0016H\u0016J\u0006\u0010'\u001a\u00020\u001fJ\u0018\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u0016H\u0016J&\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u0016J\b\u00102\u001a\u000203H\u0016R#\u0010\t\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\r\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00064"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "", "text", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "highlight", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/input/TextHighlightType;", "composingAnnotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "(Ljava/lang/CharSequence;JLandroidx/compose/ui/text/TextRange;Lkotlin/Pair;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getComposingAnnotations", "()Ljava/util/List;", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "getHighlight", "()Lkotlin/Pair;", "length", "", "getLength", "()I", "getSelection-d9O1mEE", "()J", "J", "getText", "()Ljava/lang/CharSequence;", "contentEquals", "", WriteOffReason.OTHER, "equals", "", "get", "", FirebaseAnalytics.Param.INDEX, "hashCode", "shouldShowSelection", "subSequence", "startIndex", "endIndex", "toCharArray", "", FirebaseAnalytics.Param.DESTINATION, "", "destinationOffset", "sourceStartIndex", "sourceEndIndex", "toString", "", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldCharSequence implements CharSequence {
    public static final int $stable = 8;
    private final List<AnnotatedString.Range<AnnotatedString.Annotation>> composingAnnotations;
    private final TextRange composition;
    private final Pair<TextHighlightType, TextRange> highlight;
    private final long selection;
    private final CharSequence text;

    public /* synthetic */ TextFieldCharSequence(CharSequence charSequence, long j, TextRange textRange, Pair pair, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, j, textRange, pair, list);
    }

    private TextFieldCharSequence(CharSequence charSequence, long j, TextRange textRange, Pair<TextHighlightType, TextRange> pair, List<AnnotatedString.Range<AnnotatedString.Annotation>> list) {
        this.composingAnnotations = list;
        this.text = charSequence instanceof TextFieldCharSequence ? ((TextFieldCharSequence) charSequence).text : charSequence;
        this.selection = TextRangeKt.m6441coerceIn8ffj60Q(j, 0, charSequence.length());
        this.composition = textRange != null ? TextRange.m6423boximpl(TextRangeKt.m6441coerceIn8ffj60Q(textRange.getPackedValue(), 0, charSequence.length())) : null;
        this.highlight = pair != null ? Pair.copy$default(pair, null, TextRange.m6423boximpl(TextRangeKt.m6441coerceIn8ffj60Q(pair.getSecond().getPackedValue(), 0, charSequence.length())), 1, null) : null;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ TextFieldCharSequence(java.lang.CharSequence r8, long r9, androidx.compose.ui.text.TextRange r11, kotlin.Pair r12, java.util.List r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r0 = r14 & 1
            if (r0 == 0) goto L9
            java.lang.String r0 = ""
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            goto La
        L9:
            r0 = r8
        La:
            r1 = r14 & 2
            if (r1 == 0) goto L15
            androidx.compose.ui.text.TextRange$Companion r1 = androidx.compose.ui.text.TextRange.INSTANCE
            long r1 = r1.m6440getZerod9O1mEE()
            goto L16
        L15:
            r1 = r9
        L16:
            r3 = r14 & 4
            r4 = 0
            if (r3 == 0) goto L1d
            r3 = r4
            goto L1e
        L1d:
            r3 = r11
        L1e:
            r5 = r14 & 8
            if (r5 == 0) goto L24
            r5 = r4
            goto L25
        L24:
            r5 = r12
        L25:
            r6 = r14 & 16
            if (r6 == 0) goto L2a
            goto L2b
        L2a:
            r4 = r13
        L2b:
            r6 = 0
            r8 = r7
            r9 = r0
            r10 = r1
            r12 = r3
            r14 = r4
            r13 = r5
            r15 = r6
            r8.<init>(r9, r10, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.TextFieldCharSequence.<init>(java.lang.CharSequence, long, androidx.compose.ui.text.TextRange, kotlin.Pair, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<AnnotatedString.Range<AnnotatedString.Annotation>> getComposingAnnotations() {
        return this.composingAnnotations;
    }

    public int getLength() {
        return this.text.length();
    }

    public final CharSequence getText() {
        return this.text;
    }

    /* renamed from: getSelection-d9O1mEE, reason: not valid java name and from getter */
    public final long getSelection() {
        return this.selection;
    }

    /* renamed from: getComposition-MzsxiRA, reason: not valid java name and from getter */
    public final TextRange getComposition() {
        return this.composition;
    }

    public final Pair<TextHighlightType, TextRange> getHighlight() {
        return this.highlight;
    }

    public char get(int index) {
        return this.text.charAt(index);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int startIndex, int endIndex) {
        return this.text.subSequence(startIndex, endIndex);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.text.toString();
    }

    public final boolean contentEquals(CharSequence other) {
        return StringsKt.contentEquals(this.text, other);
    }

    public final void toCharArray(char[] destination, int destinationOffset, int sourceStartIndex, int sourceEndIndex) {
        ToCharArray_androidKt.toCharArray(this.text, destination, destinationOffset, sourceStartIndex, sourceEndIndex);
    }

    public final boolean shouldShowSelection() {
        return this.highlight == null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        TextFieldCharSequence textFieldCharSequence = (TextFieldCharSequence) other;
        return TextRange.m6428equalsimpl0(this.selection, textFieldCharSequence.selection) && Intrinsics.areEqual(this.composition, textFieldCharSequence.composition) && Intrinsics.areEqual(this.highlight, textFieldCharSequence.highlight) && Intrinsics.areEqual(this.composingAnnotations, textFieldCharSequence.composingAnnotations) && contentEquals(textFieldCharSequence.text);
    }

    public int hashCode() {
        int hashCode = ((this.text.hashCode() * 31) + TextRange.m6436hashCodeimpl(this.selection)) * 31;
        TextRange textRange = this.composition;
        int m6436hashCodeimpl = (hashCode + (textRange != null ? TextRange.m6436hashCodeimpl(textRange.getPackedValue()) : 0)) * 31;
        Pair<TextHighlightType, TextRange> pair = this.highlight;
        int hashCode2 = (m6436hashCodeimpl + (pair != null ? pair.hashCode() : 0)) * 31;
        List<AnnotatedString.Range<AnnotatedString.Annotation>> list = this.composingAnnotations;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }
}
