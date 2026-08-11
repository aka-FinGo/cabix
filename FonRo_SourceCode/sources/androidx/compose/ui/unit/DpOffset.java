package androidx.compose.ui.unit;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: Dp.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 &2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010 \u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001fJ\u000f\u0010\"\u001a\u00020#H\u0017¢\u0006\u0004\b$\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u00020\t8FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\u00020\t8FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u0088\u0001\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"Landroidx/compose/ui/unit/DpOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "x", "Landroidx/compose/ui/unit/Dp;", "getX-D9Ej5fM$annotations", "()V", "getX-D9Ej5fM", "(J)F", "y", "getY-D9Ej5fM$annotations", "getY-D9Ej5fM", "copy", "copy-tPigGR8", "(JFF)J", "equals", "", WriteOffReason.OTHER, "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "minus", "minus-CB-Mgk4", "(JJ)J", "plus", "plus-CB-Mgk4", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
/* loaded from: classes4.dex */
public final class DpOffset {
    private final long packedValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m7045constructorimpl(0);
    private static final long Unspecified = m7045constructorimpl(androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpOffset m7044boximpl(long j) {
        return new DpOffset(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m7045constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m7048equalsimpl(long j, Object obj) {
        return (obj instanceof DpOffset) && j == ((DpOffset) obj).m7058unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7049equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getX-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m7051getXD9Ej5fM$annotations() {
    }

    /* renamed from: getY-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m7053getYD9Ej5fM$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m7054hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m7048equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m7054hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m7058unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ DpOffset(long j) {
        this.packedValue = j;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    /* renamed from: copy-tPigGR8$default, reason: not valid java name */
    public static /* synthetic */ long m7047copytPigGR8$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m7050getXD9Ej5fM(j);
        }
        if ((i & 2) != 0) {
            f2 = m7052getYD9Ej5fM(j);
        }
        return m7046copytPigGR8(j, f, f2);
    }

    /* renamed from: minus-CB-Mgk4, reason: not valid java name */
    public static final long m7055minusCBMgk4(long j, long j2) {
        float m6989constructorimpl = Dp.m6989constructorimpl(m7050getXD9Ej5fM(j) - m7050getXD9Ej5fM(j2));
        float m6989constructorimpl2 = Dp.m6989constructorimpl(m7052getYD9Ej5fM(j) - m7052getYD9Ej5fM(j2));
        return m7045constructorimpl((Float.floatToRawIntBits(m6989constructorimpl) << 32) | (4294967295L & Float.floatToRawIntBits(m6989constructorimpl2)));
    }

    /* renamed from: plus-CB-Mgk4, reason: not valid java name */
    public static final long m7056plusCBMgk4(long j, long j2) {
        float m6989constructorimpl = Dp.m6989constructorimpl(m7050getXD9Ej5fM(j) + m7050getXD9Ej5fM(j2));
        float m6989constructorimpl2 = Dp.m6989constructorimpl(m7052getYD9Ej5fM(j) + m7052getYD9Ej5fM(j2));
        return m7045constructorimpl((Float.floatToRawIntBits(m6989constructorimpl) << 32) | (4294967295L & Float.floatToRawIntBits(m6989constructorimpl2)));
    }

    public String toString() {
        return m7057toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m7057toStringimpl(long j) {
        if (j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
            return "(" + ((Object) Dp.m7000toStringimpl(m7050getXD9Ej5fM(j))) + ", " + ((Object) Dp.m7000toStringimpl(m7052getYD9Ej5fM(j))) + ')';
        }
        return "DpOffset.Unspecified";
    }

    /* compiled from: Dp.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/ui/unit/DpOffset$Companion;", "", "()V", "Unspecified", "Landroidx/compose/ui/unit/DpOffset;", "getUnspecified-RKDOV3M", "()J", "J", "Zero", "getZero-RKDOV3M", "ui-unit_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getZero-RKDOV3M, reason: not valid java name */
        public final long m7060getZeroRKDOV3M() {
            return DpOffset.Zero;
        }

        /* renamed from: getUnspecified-RKDOV3M, reason: not valid java name */
        public final long m7059getUnspecifiedRKDOV3M() {
            return DpOffset.Unspecified;
        }
    }

    /* renamed from: getX-D9Ej5fM, reason: not valid java name */
    public static final float m7050getXD9Ej5fM(long j) {
        return Dp.m6989constructorimpl(Float.intBitsToFloat((int) (j >> 32)));
    }

    /* renamed from: getY-D9Ej5fM, reason: not valid java name */
    public static final float m7052getYD9Ej5fM(long j) {
        return Dp.m6989constructorimpl(Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    /* renamed from: copy-tPigGR8, reason: not valid java name */
    public static final long m7046copytPigGR8(long j, float f, float f2) {
        return m7045constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L));
    }
}
