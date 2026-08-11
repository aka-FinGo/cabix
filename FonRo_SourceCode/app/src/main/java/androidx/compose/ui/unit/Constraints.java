package androidx.compose.ui.unit;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: Constraints.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 22\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J;\u0010#\u001a\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%J\u0016\u0010&\u001a\u00020\u0000H\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010\u0005J\u001a\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b-\u0010\tJ\u000f\u0010.\u001a\u00020/H\u0016¢\u0006\u0004\b0\u00101R\u0015\u0010\u0006\u001a\u00020\u00078Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\rR\u0011\u0010\u001a\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\tR\u0011\u0010\u001c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\tR\u0011\u0010\u001e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\tR\u0011\u0010 \u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b!\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u0012\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00063"}, d2 = {"Landroidx/compose/ui/unit/Constraints;", "", "value", "", "constructor-impl", "(J)J", "focusIndex", "", "getFocusIndex-impl", "(J)I", "hasBoundedHeight", "", "getHasBoundedHeight-impl", "(J)Z", "hasBoundedWidth", "getHasBoundedWidth-impl", "hasFixedHeight", "getHasFixedHeight$annotations", "()V", "getHasFixedHeight-impl", "hasFixedWidth", "getHasFixedWidth$annotations", "getHasFixedWidth-impl", "isZero", "isZero$annotations", "isZero-impl", "maxHeight", "getMaxHeight-impl", "maxWidth", "getMaxWidth-impl", "minHeight", "getMinHeight-impl", "minWidth", "getMinWidth-impl", "getValue$annotations", "copy", "copy-Zbe2FdA", "(JIIII)J", "copyMaxDimensions", "copyMaxDimensions-msEJaDk", "equals", WriteOffReason.OTHER, "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
/* loaded from: classes4.dex */
public final class Constraints {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int Infinity = Integer.MAX_VALUE;
    private final long value;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Constraints m6929boximpl(long j) {
        return new Constraints(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m6930constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m6934equalsimpl(long j, Object obj) {
        return (obj instanceof Constraints) && j == ((Constraints) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6935equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getFocusIndex-impl, reason: not valid java name */
    private static final int m6936getFocusIndeximpl(long j) {
        return (int) (j & 3);
    }

    /* renamed from: getHasBoundedHeight-impl, reason: not valid java name */
    public static final boolean m6937getHasBoundedHeightimpl(long j) {
        int i = (int) (3 & j);
        int i2 = ((i & 1) << 1) + (((i & 2) >> 1) * 3);
        return (((int) (j >> (i2 + 46))) & ((1 << (18 - i2)) - 1)) != 0;
    }

    /* renamed from: getHasBoundedWidth-impl, reason: not valid java name */
    public static final boolean m6938getHasBoundedWidthimpl(long j) {
        int i = (int) (3 & j);
        return (((int) (j >> 33)) & ((1 << ((((i & 1) << 1) + (((i & 2) >> 1) * 3)) + 13)) - 1)) != 0;
    }

    public static /* synthetic */ void getHasFixedHeight$annotations() {
    }

    /* renamed from: getHasFixedHeight-impl, reason: not valid java name */
    public static final boolean m6939getHasFixedHeightimpl(long j) {
        int i = (int) (3 & j);
        int i2 = ((i & 1) << 1) + (((i & 2) >> 1) * 3);
        int i3 = (1 << (18 - i2)) - 1;
        int i4 = ((int) (j >> (i2 + 15))) & i3;
        int i5 = ((int) (j >> (i2 + 46))) & i3;
        return i4 == (i5 == 0 ? Integer.MAX_VALUE : i5 - 1);
    }

    public static /* synthetic */ void getHasFixedWidth$annotations() {
    }

    /* renamed from: getHasFixedWidth-impl, reason: not valid java name */
    public static final boolean m6940getHasFixedWidthimpl(long j) {
        int i = (int) (3 & j);
        int i2 = (1 << ((((i & 1) << 1) + (((i & 2) >> 1) * 3)) + 13)) - 1;
        int i3 = ((int) (j >> 2)) & i2;
        int i4 = ((int) (j >> 33)) & i2;
        return i3 == (i4 == 0 ? Integer.MAX_VALUE : i4 - 1);
    }

    /* renamed from: getMaxHeight-impl, reason: not valid java name */
    public static final int m6941getMaxHeightimpl(long j) {
        int i = (int) (3 & j);
        int i2 = ((i & 1) << 1) + (((i & 2) >> 1) * 3);
        int i3 = ((int) (j >> (i2 + 46))) & ((1 << (18 - i2)) - 1);
        if (i3 == 0) {
            return Integer.MAX_VALUE;
        }
        return i3 - 1;
    }

    /* renamed from: getMaxWidth-impl, reason: not valid java name */
    public static final int m6942getMaxWidthimpl(long j) {
        int i = (int) (3 & j);
        int i2 = ((int) (j >> 33)) & ((1 << ((((i & 1) << 1) + (((i & 2) >> 1) * 3)) + 13)) - 1);
        if (i2 == 0) {
            return Integer.MAX_VALUE;
        }
        return i2 - 1;
    }

    /* renamed from: getMinHeight-impl, reason: not valid java name */
    public static final int m6943getMinHeightimpl(long j) {
        int i = (int) (3 & j);
        int i2 = ((i & 1) << 1) + (((i & 2) >> 1) * 3);
        return ((int) (j >> (i2 + 15))) & ((1 << (18 - i2)) - 1);
    }

    /* renamed from: getMinWidth-impl, reason: not valid java name */
    public static final int m6944getMinWidthimpl(long j) {
        int i = (int) (3 & j);
        return ((int) (j >> 2)) & ((1 << ((((i & 1) << 1) + (((i & 2) >> 1) * 3)) + 13)) - 1);
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m6945hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public static /* synthetic */ void isZero$annotations() {
    }

    /* renamed from: isZero-impl, reason: not valid java name */
    public static final boolean m6946isZeroimpl(long j) {
        int i = (int) (3 & j);
        int i2 = ((i & 1) << 1) + (((i & 2) >> 1) * 3);
        return ((((int) (j >> 33)) & ((1 << (i2 + 13)) - 1)) - 1 == 0) | ((((int) (j >> (i2 + 46))) & ((1 << (18 - i2)) - 1)) - 1 == 0);
    }

    public boolean equals(Object obj) {
        return m6934equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m6945hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getValue() {
        return this.value;
    }

    private /* synthetic */ Constraints(long j) {
        this.value = j;
    }

    /* renamed from: copy-Zbe2FdA$default, reason: not valid java name */
    public static /* synthetic */ long m6932copyZbe2FdA$default(long j, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = m6944getMinWidthimpl(j);
        }
        int i6 = i;
        if ((i5 & 2) != 0) {
            i2 = m6942getMaxWidthimpl(j);
        }
        int i7 = i2;
        if ((i5 & 4) != 0) {
            i3 = m6943getMinHeightimpl(j);
        }
        int i8 = i3;
        if ((i5 & 8) != 0) {
            i4 = m6941getMaxHeightimpl(j);
        }
        return m6931copyZbe2FdA(j, i6, i7, i8, i4);
    }

    /* renamed from: copy-Zbe2FdA, reason: not valid java name */
    public static final long m6931copyZbe2FdA(long j, int i, int i2, int i3, int i4) {
        if (!(i2 >= i && i4 >= i3 && i >= 0 && i3 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("maxWidth must be >= than minWidth,\nmaxHeight must be >= than minHeight,\nminWidth and minHeight must be >= 0");
        }
        return ConstraintsKt.createConstraints(i, i2, i3, i4);
    }

    /* renamed from: copyMaxDimensions-msEJaDk, reason: not valid java name */
    public static final long m6933copyMaxDimensionsmsEJaDk(long j) {
        return m6930constructorimpl(j & ConstraintsKt.MaxDimensionsAndFocusMask);
    }

    public String toString() {
        return m6947toStringimpl(this.value);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m6947toStringimpl(long j) {
        int m6942getMaxWidthimpl = m6942getMaxWidthimpl(j);
        String str = "Infinity";
        String valueOf = m6942getMaxWidthimpl == Integer.MAX_VALUE ? "Infinity" : String.valueOf(m6942getMaxWidthimpl);
        int m6941getMaxHeightimpl = m6941getMaxHeightimpl(j);
        if (m6941getMaxHeightimpl != Integer.MAX_VALUE) {
            str = String.valueOf(m6941getMaxHeightimpl);
        }
        return "Constraints(minWidth = " + m6944getMinWidthimpl(j) + ", maxWidth = " + valueOf + ", minHeight = " + m6943getMinHeightimpl(j) + ", maxHeight = " + str + ')';
    }

    /* compiled from: Constraints.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ5\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\fJ%\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0016J?\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/unit/Constraints$Companion;", "", "()V", "Infinity", "", "fitPrioritizingHeight", "Landroidx/compose/ui/unit/Constraints;", "minWidth", "maxWidth", "minHeight", "maxHeight", "fitPrioritizingHeight-Zbe2FdA", "(IIII)J", "fitPrioritizingWidth", "fitPrioritizingWidth-Zbe2FdA", "fixed", "width", "height", "fixed-JhjzzOo", "(II)J", "fixedHeight", "fixedHeight-OenEA2s", "(I)J", "fixedWidth", "fixedWidth-OenEA2s", "restrictConstraints", "prioritizeWidth", "", "restrictConstraints-xF2OJ5Q", "(IIIIZ)J", "ui-unit_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: fixed-JhjzzOo, reason: not valid java name */
        public final long m6952fixedJhjzzOo(int width, int height) {
            if (!((height >= 0) & (width >= 0))) {
                InlineClassHelperKt.throwIllegalArgumentException("width and height must be >= 0");
            }
            return ConstraintsKt.createConstraints(width, width, height, height);
        }

        /* renamed from: fixedWidth-OenEA2s, reason: not valid java name */
        public final long m6954fixedWidthOenEA2s(int width) {
            if (!(width >= 0)) {
                InlineClassHelperKt.throwIllegalArgumentException("width must be >= 0");
            }
            return ConstraintsKt.createConstraints(width, width, 0, Integer.MAX_VALUE);
        }

        /* renamed from: fixedHeight-OenEA2s, reason: not valid java name */
        public final long m6953fixedHeightOenEA2s(int height) {
            if (!(height >= 0)) {
                InlineClassHelperKt.throwIllegalArgumentException("height must be >= 0");
            }
            return ConstraintsKt.createConstraints(0, Integer.MAX_VALUE, height, height);
        }

        /* renamed from: restrictConstraints-xF2OJ5Q$default, reason: not valid java name */
        public static /* synthetic */ long m6949restrictConstraintsxF2OJ5Q$default(Companion companion, int i, int i2, int i3, int i4, boolean z, int i5, Object obj) {
            if ((i5 & 16) != 0) {
                z = true;
            }
            return companion.m6955restrictConstraintsxF2OJ5Q(i, i2, i3, i4, z);
        }

        @Deprecated(message = "Replace with fitPrioritizingWidth", replaceWith = @ReplaceWith(expression = "Constraints.fitPrioritizingWidth(minWidth, maxWidth, minHeight, maxHeight)", imports = {}))
        /* renamed from: restrictConstraints-xF2OJ5Q, reason: not valid java name */
        public final long m6955restrictConstraintsxF2OJ5Q(int minWidth, int maxWidth, int minHeight, int maxHeight, boolean prioritizeWidth) {
            if (prioritizeWidth) {
                return m6951fitPrioritizingWidthZbe2FdA(minWidth, maxWidth, minHeight, maxHeight);
            }
            return m6950fitPrioritizingHeightZbe2FdA(minWidth, maxWidth, minHeight, maxHeight);
        }

        /* renamed from: fitPrioritizingWidth-Zbe2FdA, reason: not valid java name */
        public final long m6951fitPrioritizingWidthZbe2FdA(int minWidth, int maxWidth, int minHeight, int maxHeight) {
            int i = 262142;
            int min = Math.min(minWidth, 262142);
            int min2 = maxWidth == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(maxWidth, 262142);
            int i2 = min2 == Integer.MAX_VALUE ? min : min2;
            if (i2 >= 8191) {
                if (i2 < 32767) {
                    i = 65534;
                } else if (i2 < 65535) {
                    i = 32766;
                } else {
                    if (i2 >= 262143) {
                        ConstraintsKt.throwInvalidConstraintsSizeException(i2);
                        throw new KotlinNothingValueException();
                    }
                    i = 8190;
                }
            }
            return ConstraintsKt.Constraints(min, min2, Math.min(i, minHeight), maxHeight != Integer.MAX_VALUE ? Math.min(i, maxHeight) : Integer.MAX_VALUE);
        }

        /* renamed from: fitPrioritizingHeight-Zbe2FdA, reason: not valid java name */
        public final long m6950fitPrioritizingHeightZbe2FdA(int minWidth, int maxWidth, int minHeight, int maxHeight) {
            int i = 262142;
            int min = Math.min(minHeight, 262142);
            int min2 = maxHeight == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(maxHeight, 262142);
            int i2 = min2 == Integer.MAX_VALUE ? min : min2;
            if (i2 >= 8191) {
                if (i2 < 32767) {
                    i = 65534;
                } else if (i2 < 65535) {
                    i = 32766;
                } else {
                    if (i2 >= 262143) {
                        ConstraintsKt.throwInvalidConstraintsSizeException(i2);
                        throw new KotlinNothingValueException();
                    }
                    i = 8190;
                }
            }
            return ConstraintsKt.Constraints(Math.min(i, minWidth), maxWidth != Integer.MAX_VALUE ? Math.min(i, maxWidth) : Integer.MAX_VALUE, min, min2);
        }
    }
}
