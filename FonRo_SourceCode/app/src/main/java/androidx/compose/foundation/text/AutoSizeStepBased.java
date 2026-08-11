package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.TextAutoSizeLayoutScope;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: TextAutoSize.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\f\u0010\u000e\u001a\u00020\t*\u00020\u000fH\u0002J\f\u0010\u0010\u001a\u00020\t*\u00020\u000fH\u0002J\f\u0010\u0011\u001a\u00020\t*\u00020\u000fH\u0002J&\u0010\u0012\u001a\u00020\u0003*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/text/AutoSizeStepBased;", "Landroidx/compose/foundation/text/TextAutoSize;", "minFontSize", "Landroidx/compose/ui/unit/TextUnit;", "maxFontSize", "stepSize", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "equals", "", WriteOffReason.OTHER, "", "hashCode", "", "didOverflow", "Landroidx/compose/ui/text/TextLayoutResult;", "didOverflowBounds", "didOverflowByEllipsize", "getFontSize", "Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "getFontSize-Ci0_558", "(Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;JLandroidx/compose/ui/text/AnnotatedString;)J", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class AutoSizeStepBased implements TextAutoSize {
    private final long maxFontSize;
    private long minFontSize;
    private final long stepSize;

    public /* synthetic */ AutoSizeStepBased(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    private AutoSizeStepBased(long j, long j2, long j3) {
        this.minFontSize = j;
        this.maxFontSize = j2;
        this.stepSize = j3;
        if (TextUnit.m7180equalsimpl0(j, TextUnit.INSTANCE.m7194getUnspecifiedXSAIIZE())) {
            throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for minFontSize. Try using other values e.g. 10.sp");
        }
        if (TextUnit.m7180equalsimpl0(j2, TextUnit.INSTANCE.m7194getUnspecifiedXSAIIZE())) {
            throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for maxFontSize. Try using other values e.g. 100.sp");
        }
        if (TextUnit.m7180equalsimpl0(j3, TextUnit.INSTANCE.m7194getUnspecifiedXSAIIZE())) {
            throw new IllegalArgumentException("AutoSize.StepBased: TextUnit.Unspecified is not a valid value for stepSize. Try using other values e.g. 0.25.sp");
        }
        if (TextUnitType.m7211equalsimpl0(TextUnit.m7182getTypeUIouoOA(this.minFontSize), TextUnit.m7182getTypeUIouoOA(j2))) {
            long j4 = this.minFontSize;
            TextUnitKt.m7197checkArithmeticNB67dxo(j4, j2);
            if (Float.compare(TextUnit.m7183getValueimpl(j4), TextUnit.m7183getValueimpl(j2)) > 0) {
                this.minFontSize = j2;
            }
        }
        if (TextUnitType.m7211equalsimpl0(TextUnit.m7182getTypeUIouoOA(j3), TextUnitType.INSTANCE.m7216getSpUIouoOA())) {
            long sp = TextUnitKt.getSp(1.0E-4f);
            TextUnitKt.m7197checkArithmeticNB67dxo(j3, sp);
            if (Float.compare(TextUnit.m7183getValueimpl(j3), TextUnit.m7183getValueimpl(sp)) < 0) {
                throw new IllegalArgumentException("AutoSize.StepBased: stepSize must be greater than or equal to 0.0001f.sp");
            }
        }
        if (TextUnit.m7183getValueimpl(this.minFontSize) < 0.0f) {
            throw new IllegalArgumentException("AutoSize.StepBased: minFontSize must not be negative");
        }
        if (TextUnit.m7183getValueimpl(j2) < 0.0f) {
            throw new IllegalArgumentException("AutoSize.StepBased: maxFontSize must not be negative");
        }
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    /* renamed from: getFontSize-Ci0_558, reason: not valid java name */
    public long mo1346getFontSizeCi0_558(TextAutoSizeLayoutScope textAutoSizeLayoutScope, long j, AnnotatedString annotatedString) {
        float f = textAutoSizeLayoutScope.mo699toPxR2X_6o(this.stepSize);
        float f2 = textAutoSizeLayoutScope.mo699toPxR2X_6o(this.minFontSize);
        float f3 = textAutoSizeLayoutScope.mo699toPxR2X_6o(this.maxFontSize);
        float f4 = (f2 + f3) / 2.0f;
        float f5 = f2;
        float f6 = f3;
        while (f6 - f5 >= f) {
            if (didOverflow(textAutoSizeLayoutScope.mo1734performLayout5ZSfY2I(j, annotatedString, textAutoSizeLayoutScope.mo703toSpkPz2Gy4(f4)))) {
                f6 = f4;
            } else {
                f5 = f4;
            }
            f4 = (f5 + f6) / 2.0f;
        }
        float floor = (((float) Math.floor((f5 - f2) / f)) * f) + f2;
        float f7 = f + floor;
        if (f7 <= f3 && !didOverflow(textAutoSizeLayoutScope.mo1734performLayout5ZSfY2I(j, annotatedString, textAutoSizeLayoutScope.mo703toSpkPz2Gy4(f7)))) {
            floor = f7;
        }
        return textAutoSizeLayoutScope.mo703toSpkPz2Gy4(floor);
    }

    private final boolean didOverflow(TextLayoutResult textLayoutResult) {
        int overflow = textLayoutResult.getLayoutInput().getOverflow();
        if (TextOverflow.m6915equalsimpl0(overflow, TextOverflow.INSTANCE.m6924getClipgIe3tQ8()) ? true : TextOverflow.m6915equalsimpl0(overflow, TextOverflow.INSTANCE.m6928getVisiblegIe3tQ8())) {
            return didOverflowBounds(textLayoutResult);
        }
        if (TextOverflow.m6915equalsimpl0(overflow, TextOverflow.INSTANCE.m6927getStartEllipsisgIe3tQ8()) ? true : TextOverflow.m6915equalsimpl0(overflow, TextOverflow.INSTANCE.m6926getMiddleEllipsisgIe3tQ8()) ? true : TextOverflow.m6915equalsimpl0(overflow, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8())) {
            return didOverflowByEllipsize(textLayoutResult);
        }
        throw new IllegalArgumentException("TextOverflow type " + ((Object) TextOverflow.m6917toStringimpl(textLayoutResult.getLayoutInput().getOverflow())) + " is not supported.");
    }

    private final boolean didOverflowBounds(TextLayoutResult textLayoutResult) {
        return textLayoutResult.getDidOverflowWidth() || textLayoutResult.getDidOverflowHeight();
    }

    private final boolean didOverflowByEllipsize(TextLayoutResult textLayoutResult) {
        int lineCount = textLayoutResult.getLineCount();
        if (lineCount == 0) {
            return false;
        }
        if (lineCount == 1) {
            return textLayoutResult.isLineEllipsized(0);
        }
        int overflow = textLayoutResult.getLayoutInput().getOverflow();
        if (TextOverflow.m6915equalsimpl0(overflow, TextOverflow.INSTANCE.m6927getStartEllipsisgIe3tQ8()) ? true : TextOverflow.m6915equalsimpl0(overflow, TextOverflow.INSTANCE.m6926getMiddleEllipsisgIe3tQ8())) {
            return didOverflowBounds(textLayoutResult);
        }
        if (TextOverflow.m6915equalsimpl0(overflow, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8())) {
            return textLayoutResult.isLineEllipsized(textLayoutResult.getLineCount() - 1);
        }
        return false;
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null || !(other instanceof AutoSizeStepBased)) {
            return false;
        }
        AutoSizeStepBased autoSizeStepBased = (AutoSizeStepBased) other;
        return TextUnit.m7180equalsimpl0(autoSizeStepBased.minFontSize, this.minFontSize) && TextUnit.m7180equalsimpl0(autoSizeStepBased.maxFontSize, this.maxFontSize) && TextUnit.m7180equalsimpl0(autoSizeStepBased.stepSize, this.stepSize);
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    public int hashCode() {
        return (((TextUnit.m7184hashCodeimpl(this.minFontSize) * 31) + TextUnit.m7184hashCodeimpl(this.maxFontSize)) * 31) + TextUnit.m7184hashCodeimpl(this.stepSize);
    }
}
