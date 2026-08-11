package androidx.compose.ui.unit;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

/* compiled from: Constraints.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\u001a5\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003H\u0082\b\u001a\u0011\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0082\b\u001a\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H\u0000\u001a-\u0010!\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0019\u001a\u0011\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H\u0082\b\u001a\u0011\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0082\b\u001a\u0011\u0010&\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H\u0082\b\u001a\u0011\u0010'\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H\u0082\b\u001a\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0003H\u0000\u001a\u0010\u0010,\u001a\u00020-2\u0006\u0010 \u001a\u00020\u0003H\u0000\u001a\u0011\u0010.\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H\u0082\b\u001a\u001c\u0010/\u001a\u00020\u0014*\u00020\u00142\u0006\u00100\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a\u001e\u0010/\u001a\u000203*\u00020\u00142\u0006\u0010 \u001a\u000203H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00102\u001a\u001e\u00105\u001a\u00020\u0003*\u00020\u00142\u0006\u00106\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a\u001e\u00109\u001a\u00020\u0003*\u00020\u00142\u0006\u0010:\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b;\u00108\u001a\u001e\u0010<\u001a\u00020=*\u00020\u00142\u0006\u0010 \u001a\u000203H\u0007ø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001a*\u0010@\u001a\u00020\u0014*\u00020\u00142\b\b\u0002\u0010A\u001a\u00020\u00032\b\b\u0002\u0010B\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\bC\u0010D\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\b\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006E"}, d2 = {"FocusMask", "", "Infinity", "", "MaxAllowedForMaxFocusBits", "MaxAllowedForMaxNonFocusBits", "MaxAllowedForMinFocusBits", "MaxAllowedForMinNonFocusBits", "MaxDimensionsAndFocusMask", "getMaxDimensionsAndFocusMask$annotations", "()V", "MaxFocusBits", "MaxFocusMask", "MaxNonFocusBits", "MaxNonFocusMask", "MinFocusBits", "MinFocusMask", "MinNonFocusBits", "MinNonFocusMask", androidx.constraintlayout.widget.Constraints.TAG, "Landroidx/compose/ui/unit/Constraints;", "minWidth", "maxWidth", "minHeight", "maxHeight", "(IIII)J", "addMaxWithMinimum", "max", "value", "bitOffsetToIndex", "bits", "bitsNeedForSizeUnchecked", "size", "createConstraints", "heightMask", "bitOffset", "indexToBitOffset", FirebaseAnalytics.Param.INDEX, "maxAllowedForSize", "minHeightOffsets", "throwInvalidConstraintException", "", "widthVal", "heightVal", "throwInvalidConstraintsSizeException", "", "widthMask", "constrain", "otherConstraints", "constrain-N9IONVI", "(JJ)J", "Landroidx/compose/ui/unit/IntSize;", "constrain-4WqzIAM", "constrainHeight", "height", "constrainHeight-K40F9xA", "(JI)I", "constrainWidth", "width", "constrainWidth-K40F9xA", "isSatisfiedBy", "", "isSatisfiedBy-4WqzIAM", "(JJ)Z", TypedValues.CycleType.S_WAVE_OFFSET, "horizontal", "vertical", "offset-NN6Ew-U", "(JII)J", "ui-unit_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class ConstraintsKt {
    private static final long FocusMask = 3;
    private static final int Infinity = Integer.MAX_VALUE;
    private static final int MaxAllowedForMaxFocusBits = 8190;
    private static final int MaxAllowedForMaxNonFocusBits = 262142;
    private static final int MaxAllowedForMinFocusBits = 32766;
    private static final int MaxAllowedForMinNonFocusBits = 65534;
    public static final long MaxDimensionsAndFocusMask = -8589934589L;
    private static final int MaxFocusBits = 18;
    private static final int MaxFocusMask = 262143;
    private static final int MaxNonFocusBits = 13;
    private static final int MaxNonFocusMask = 8191;
    private static final int MinFocusBits = 16;
    private static final int MinFocusMask = 65535;
    private static final int MinNonFocusBits = 15;
    private static final int MinNonFocusMask = 32767;

    private static final int addMaxWithMinimum(int i, int i2) {
        if (i == Integer.MAX_VALUE) {
            return i;
        }
        int i3 = i + i2;
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }

    private static final int bitOffsetToIndex(int i) {
        return (i >> 1) + (i & 1);
    }

    public static final int bitsNeedForSizeUnchecked(int i) {
        if (i < MaxNonFocusMask) {
            return 13;
        }
        if (i < 32767) {
            return 15;
        }
        if (i < 65535) {
            return 16;
        }
        return i < MaxFocusMask ? 18 : 255;
    }

    public static /* synthetic */ void getMaxDimensionsAndFocusMask$annotations() {
    }

    private static final int heightMask(int i) {
        return (1 << (18 - i)) - 1;
    }

    private static final int indexToBitOffset(int i) {
        return ((i & 1) << 1) + (((i & 2) >> 1) * 3);
    }

    private static final int minHeightOffsets(int i) {
        return i + 15;
    }

    private static final int widthMask(int i) {
        return (1 << (i + 13)) - 1;
    }

    public static final void throwInvalidConstraintException(int i, int i2) {
        throw new IllegalArgumentException("Can't represent a width of " + i + " and height of " + i2 + " in Constraints");
    }

    public static final Void throwInvalidConstraintsSizeException(int i) {
        throw new IllegalArgumentException("Can't represent a size of " + i + " in Constraints");
    }

    public static final long createConstraints(int i, int i2, int i3, int i4) {
        int i5 = i4 == Integer.MAX_VALUE ? i3 : i4;
        int bitsNeedForSizeUnchecked = bitsNeedForSizeUnchecked(i5);
        int i6 = i2 == Integer.MAX_VALUE ? i : i2;
        int bitsNeedForSizeUnchecked2 = bitsNeedForSizeUnchecked(i6);
        if (bitsNeedForSizeUnchecked + bitsNeedForSizeUnchecked2 > 31) {
            throwInvalidConstraintException(i6, i5);
        }
        int i7 = i2 + 1;
        int i8 = i4 + 1;
        int i9 = bitsNeedForSizeUnchecked2 - 13;
        return Constraints.m6930constructorimpl(((i7 & (~(i7 >> 31))) << 33) | ((i9 >> 1) + (i9 & 1)) | (i << 2) | (i3 << (bitsNeedForSizeUnchecked2 + 2)) | ((i8 & (~(i8 >> 31))) << (bitsNeedForSizeUnchecked2 + 33)));
    }

    private static final int maxAllowedForSize(int i) {
        if (i < MaxNonFocusMask) {
            return MaxAllowedForMaxNonFocusBits;
        }
        if (i < 32767) {
            return MaxAllowedForMinNonFocusBits;
        }
        if (i < 65535) {
            return MaxAllowedForMinFocusBits;
        }
        if (i < MaxFocusMask) {
            return MaxAllowedForMaxFocusBits;
        }
        throwInvalidConstraintsSizeException(i);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ long Constraints$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return Constraints(i, i2, i3, i4);
    }

    public static final long Constraints(int i, int i2, int i3, int i4) {
        if (!((i3 >= 0) & (i2 >= i) & (i4 >= i3) & (i >= 0))) {
            InlineClassHelperKt.throwIllegalArgumentException("maxWidth must be >= than minWidth,\nmaxHeight must be >= than minHeight,\nminWidth and minHeight must be >= 0");
        }
        return createConstraints(i, i2, i3, i4);
    }

    /* renamed from: constrain-N9IONVI, reason: not valid java name */
    public static final long m6957constrainN9IONVI(long j, long j2) {
        int m6944getMinWidthimpl = Constraints.m6944getMinWidthimpl(j);
        int m6942getMaxWidthimpl = Constraints.m6942getMaxWidthimpl(j);
        int m6943getMinHeightimpl = Constraints.m6943getMinHeightimpl(j);
        int m6941getMaxHeightimpl = Constraints.m6941getMaxHeightimpl(j);
        int m6944getMinWidthimpl2 = Constraints.m6944getMinWidthimpl(j2);
        if (m6944getMinWidthimpl2 < m6944getMinWidthimpl) {
            m6944getMinWidthimpl2 = m6944getMinWidthimpl;
        }
        if (m6944getMinWidthimpl2 > m6942getMaxWidthimpl) {
            m6944getMinWidthimpl2 = m6942getMaxWidthimpl;
        }
        int m6942getMaxWidthimpl2 = Constraints.m6942getMaxWidthimpl(j2);
        if (m6942getMaxWidthimpl2 >= m6944getMinWidthimpl) {
            m6944getMinWidthimpl = m6942getMaxWidthimpl2;
        }
        if (m6944getMinWidthimpl <= m6942getMaxWidthimpl) {
            m6942getMaxWidthimpl = m6944getMinWidthimpl;
        }
        int m6943getMinHeightimpl2 = Constraints.m6943getMinHeightimpl(j2);
        if (m6943getMinHeightimpl2 < m6943getMinHeightimpl) {
            m6943getMinHeightimpl2 = m6943getMinHeightimpl;
        }
        if (m6943getMinHeightimpl2 > m6941getMaxHeightimpl) {
            m6943getMinHeightimpl2 = m6941getMaxHeightimpl;
        }
        int m6941getMaxHeightimpl2 = Constraints.m6941getMaxHeightimpl(j2);
        if (m6941getMaxHeightimpl2 >= m6943getMinHeightimpl) {
            m6943getMinHeightimpl = m6941getMaxHeightimpl2;
        }
        if (m6943getMinHeightimpl <= m6941getMaxHeightimpl) {
            m6941getMaxHeightimpl = m6943getMinHeightimpl;
        }
        return Constraints(m6944getMinWidthimpl2, m6942getMaxWidthimpl, m6943getMinHeightimpl2, m6941getMaxHeightimpl);
    }

    /* renamed from: constrain-4WqzIAM, reason: not valid java name */
    public static final long m6956constrain4WqzIAM(long j, long j2) {
        int i = (int) (j2 >> 32);
        int m6944getMinWidthimpl = Constraints.m6944getMinWidthimpl(j);
        int m6942getMaxWidthimpl = Constraints.m6942getMaxWidthimpl(j);
        if (i < m6944getMinWidthimpl) {
            i = m6944getMinWidthimpl;
        }
        if (i <= m6942getMaxWidthimpl) {
            m6942getMaxWidthimpl = i;
        }
        int i2 = (int) (j2 & 4294967295L);
        int m6943getMinHeightimpl = Constraints.m6943getMinHeightimpl(j);
        int m6941getMaxHeightimpl = Constraints.m6941getMaxHeightimpl(j);
        if (i2 < m6943getMinHeightimpl) {
            i2 = m6943getMinHeightimpl;
        }
        if (i2 <= m6941getMaxHeightimpl) {
            m6941getMaxHeightimpl = i2;
        }
        return IntSize.m7155constructorimpl((m6942getMaxWidthimpl << 32) | (m6941getMaxHeightimpl & 4294967295L));
    }

    /* renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final int m6959constrainWidthK40F9xA(long j, int i) {
        int m6944getMinWidthimpl = Constraints.m6944getMinWidthimpl(j);
        int m6942getMaxWidthimpl = Constraints.m6942getMaxWidthimpl(j);
        if (i < m6944getMinWidthimpl) {
            i = m6944getMinWidthimpl;
        }
        return i > m6942getMaxWidthimpl ? m6942getMaxWidthimpl : i;
    }

    /* renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final int m6958constrainHeightK40F9xA(long j, int i) {
        int m6943getMinHeightimpl = Constraints.m6943getMinHeightimpl(j);
        int m6941getMaxHeightimpl = Constraints.m6941getMaxHeightimpl(j);
        if (i < m6943getMinHeightimpl) {
            i = m6943getMinHeightimpl;
        }
        return i > m6941getMaxHeightimpl ? m6941getMaxHeightimpl : i;
    }

    /* renamed from: isSatisfiedBy-4WqzIAM, reason: not valid java name */
    public static final boolean m6960isSatisfiedBy4WqzIAM(long j, long j2) {
        int m6944getMinWidthimpl = Constraints.m6944getMinWidthimpl(j);
        int m6942getMaxWidthimpl = Constraints.m6942getMaxWidthimpl(j);
        int i = (int) (j2 >> 32);
        if (m6944getMinWidthimpl > i || i > m6942getMaxWidthimpl) {
            return false;
        }
        int i2 = (int) (j2 & 4294967295L);
        return Constraints.m6943getMinHeightimpl(j) <= i2 && i2 <= Constraints.m6941getMaxHeightimpl(j);
    }

    /* renamed from: offset-NN6Ew-U$default, reason: not valid java name */
    public static /* synthetic */ long m6962offsetNN6EwU$default(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return m6961offsetNN6EwU(j, i, i2);
    }

    /* renamed from: offset-NN6Ew-U, reason: not valid java name */
    public static final long m6961offsetNN6EwU(long j, int i, int i2) {
        int m6944getMinWidthimpl = Constraints.m6944getMinWidthimpl(j) + i;
        if (m6944getMinWidthimpl < 0) {
            m6944getMinWidthimpl = 0;
        }
        int m6942getMaxWidthimpl = Constraints.m6942getMaxWidthimpl(j);
        if (m6942getMaxWidthimpl != Integer.MAX_VALUE && (m6942getMaxWidthimpl = m6942getMaxWidthimpl + i) < 0) {
            m6942getMaxWidthimpl = 0;
        }
        int m6943getMinHeightimpl = Constraints.m6943getMinHeightimpl(j) + i2;
        if (m6943getMinHeightimpl < 0) {
            m6943getMinHeightimpl = 0;
        }
        int m6941getMaxHeightimpl = Constraints.m6941getMaxHeightimpl(j);
        return Constraints(m6944getMinWidthimpl, m6942getMaxWidthimpl, m6943getMinHeightimpl, (m6941getMaxHeightimpl == Integer.MAX_VALUE || (m6941getMaxHeightimpl = m6941getMaxHeightimpl + i2) >= 0) ? m6941getMaxHeightimpl : 0);
    }
}
