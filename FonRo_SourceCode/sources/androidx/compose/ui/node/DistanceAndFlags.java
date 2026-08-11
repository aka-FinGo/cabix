package androidx.compose.ui.node;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: HitTestResult.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0088\u0001\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"Landroidx/compose/ui/node/DistanceAndFlags;", "", "packedValue", "", "constructor-impl", "(J)J", "distance", "", "getDistance-impl", "(J)F", "isInExpandedBounds", "", "isInExpandedBounds-impl", "(J)Z", "isInLayer", "isInLayer-impl", "getPackedValue", "()J", "compareTo", "", WriteOffReason.OTHER, "compareTo-9YPOF3E", "(JJ)I", "equals", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
/* loaded from: classes4.dex */
public final class DistanceAndFlags {
    private final long packedValue;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DistanceAndFlags m5869boximpl(long j) {
        return new DistanceAndFlags(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m5871constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5872equalsimpl(long j, Object obj) {
        return (obj instanceof DistanceAndFlags) && j == ((DistanceAndFlags) obj).m5879unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5873equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5875hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: isInExpandedBounds-impl, reason: not valid java name */
    public static final boolean m5876isInExpandedBoundsimpl(long j) {
        return (j & 2) != 0;
    }

    /* renamed from: isInLayer-impl, reason: not valid java name */
    public static final boolean m5877isInLayerimpl(long j) {
        return (j & 1) != 0;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5878toStringimpl(long j) {
        return "DistanceAndFlags(packedValue=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m5872equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5875hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m5878toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m5879unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ DistanceAndFlags(long j) {
        this.packedValue = j;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    /* renamed from: compareTo-9YPOF3E, reason: not valid java name */
    public static final int m5870compareTo9YPOF3E(long j, long j2) {
        boolean m5877isInLayerimpl = m5877isInLayerimpl(j);
        if (m5877isInLayerimpl != m5877isInLayerimpl(j2)) {
            return m5877isInLayerimpl ? -1 : 1;
        }
        return (Math.min(m5874getDistanceimpl(j), m5874getDistanceimpl(j2)) >= 0.0f && m5876isInExpandedBoundsimpl(j) != m5876isInExpandedBoundsimpl(j2)) ? m5876isInExpandedBoundsimpl(j) ? -1 : 1 : (int) Math.signum(m5874getDistanceimpl(j) - m5874getDistanceimpl(j2));
    }

    /* renamed from: getDistance-impl, reason: not valid java name */
    public static final float m5874getDistanceimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }
}
