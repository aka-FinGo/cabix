package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: OffsetMappingCalculator.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J%\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0011J=\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007R\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "", "()V", "ops", "Landroidx/compose/foundation/text/input/internal/OpArray;", "[I", "opsSize", "", "map", "Landroidx/compose/ui/text/TextRange;", TypedValues.CycleType.S_WAVE_OFFSET, "fromSource", "", "map-fzxv0v0", "(IZ)J", "mapFromDest", "mapFromDest--jx7JFs", "(I)J", "mapFromSource", "mapFromSource--jx7JFs", "mapStep", "opOffset", "untransformedLen", "transformedLen", "mapStep-C6u-MEY", "(IIIIZ)J", "recordEditOperation", "", "sourceStart", "sourceEnd", "newLength", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class OffsetMappingCalculator {
    public static final int $stable = 8;
    private int[] ops = OpArray.m1588constructorimpl(10);
    private int opsSize;

    public final void recordEditOperation(int sourceStart, int sourceEnd, int newLength) {
        if (!(newLength >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("Expected newLen to be ≥ 0, was " + newLength);
        }
        int min = Math.min(sourceStart, sourceEnd);
        int max = Math.max(min, sourceEnd) - min;
        if (max >= 2 || max != newLength) {
            int i = this.opsSize + 1;
            if (i > OpArray.m1595getSizeimpl(this.ops)) {
                this.ops = OpArray.m1590copyOfpSmdads(this.ops, Math.max(i * 2, OpArray.m1595getSizeimpl(this.ops) * 2));
            }
            OpArray.m1597setimpl(this.ops, this.opsSize, min, max, newLength);
            this.opsSize = i;
        }
    }

    /* renamed from: mapFromSource--jx7JFs, reason: not valid java name */
    public final long m1586mapFromSourcejx7JFs(int offset) {
        return m1583mapfzxv0v0(offset, true);
    }

    /* renamed from: mapFromDest--jx7JFs, reason: not valid java name */
    public final long m1585mapFromDestjx7JFs(int offset) {
        return m1583mapfzxv0v0(offset, false);
    }

    /* renamed from: map-fzxv0v0, reason: not valid java name */
    private final long m1583mapfzxv0v0(int offset, boolean fromSource) {
        int i;
        int i2;
        int[] iArr = this.ops;
        int i3 = this.opsSize;
        if (i3 >= 0) {
            if (fromSource) {
                i2 = offset;
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = i4 * 3;
                    int i6 = iArr[i5];
                    int i7 = iArr[i5 + 1];
                    int i8 = iArr[i5 + 2];
                    long m1584mapStepC6uMEY = m1584mapStepC6uMEY(i2, i6, i7, i8, fromSource);
                    long m1584mapStepC6uMEY2 = m1584mapStepC6uMEY(offset, i6, i7, i8, fromSource);
                    i2 = Math.min(TextRange.m6435getStartimpl(m1584mapStepC6uMEY), TextRange.m6435getStartimpl(m1584mapStepC6uMEY2));
                    offset = Math.max(TextRange.m6430getEndimpl(m1584mapStepC6uMEY), TextRange.m6430getEndimpl(m1584mapStepC6uMEY2));
                }
            } else {
                int i9 = i3 - 1;
                i2 = offset;
                while (-1 < i9) {
                    int i10 = i9 * 3;
                    int i11 = iArr[i10];
                    int i12 = iArr[i10 + 1];
                    int i13 = iArr[i10 + 2];
                    OffsetMappingCalculator offsetMappingCalculator = this;
                    boolean z = fromSource;
                    long m1584mapStepC6uMEY3 = offsetMappingCalculator.m1584mapStepC6uMEY(i2, i11, i12, i13, z);
                    long m1584mapStepC6uMEY4 = offsetMappingCalculator.m1584mapStepC6uMEY(offset, i11, i12, i13, z);
                    i2 = Math.min(TextRange.m6435getStartimpl(m1584mapStepC6uMEY3), TextRange.m6435getStartimpl(m1584mapStepC6uMEY4));
                    offset = Math.max(TextRange.m6430getEndimpl(m1584mapStepC6uMEY3), TextRange.m6430getEndimpl(m1584mapStepC6uMEY4));
                    i9--;
                    this = offsetMappingCalculator;
                    fromSource = z;
                }
            }
            i = offset;
            offset = i2;
        } else {
            i = offset;
        }
        return TextRangeKt.TextRange(offset, i);
    }

    /* renamed from: mapStep-C6u-MEY, reason: not valid java name */
    private final long m1584mapStepC6uMEY(int offset, int opOffset, int untransformedLen, int transformedLen, boolean fromSource) {
        int i = fromSource ? untransformedLen : transformedLen;
        if (fromSource) {
            untransformedLen = transformedLen;
        }
        if (offset < opOffset) {
            return TextRangeKt.TextRange(offset);
        }
        if (offset == opOffset) {
            if (i == 0) {
                return TextRangeKt.TextRange(opOffset, untransformedLen + opOffset);
            }
            return TextRangeKt.TextRange(opOffset);
        }
        if (offset >= opOffset + i) {
            return TextRangeKt.TextRange((offset - i) + untransformedLen);
        }
        if (untransformedLen == 0) {
            return TextRangeKt.TextRange(opOffset);
        }
        return TextRangeKt.TextRange(opOffset, untransformedLen + opOffset);
    }
}
