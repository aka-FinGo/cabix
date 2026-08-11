package androidx.compose.ui.unit;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: IntSize.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 %2\u00020\u0001:\u0001%B\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\b\u0012\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\b\u0014\u0010\u000bJ\u001e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u000bJ\u001e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u0018J\u000f\u0010!\u001a\u00020\"H\u0017¢\u0006\u0004\b#\u0010$R\u001b\u0010\u0006\u001a\u00020\u00078Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u00078Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\u0088\u0001\u0002\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Landroidx/compose/ui/unit/IntSize;", "", "packedValue", "", "constructor-impl", "(J)J", "height", "", "getHeight$annotations", "()V", "getHeight-impl", "(J)I", "getPackedValue", "()J", "width", "getWidth$annotations", "getWidth-impl", "component1", "component1-impl", "component2", "component2-impl", "div", WriteOffReason.OTHER, "div-YEO4UFw", "(JI)J", "equals", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "times", "times-YEO4UFw", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
/* loaded from: classes4.dex */
public final class IntSize {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m7155constructorimpl(0);
    private final long packedValue;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntSize m7152boximpl(long j) {
        return new IntSize(j);
    }

    /* renamed from: component1-impl, reason: not valid java name */
    public static final int m7153component1impl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: component2-impl, reason: not valid java name */
    public static final int m7154component2impl(long j) {
        return (int) (j & 4294967295L);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m7155constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m7157equalsimpl(long j, Object obj) {
        return (obj instanceof IntSize) && j == ((IntSize) obj).m7164unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7158equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getHeight$annotations() {
    }

    /* renamed from: getHeight-impl, reason: not valid java name */
    public static final int m7159getHeightimpl(long j) {
        return (int) (j & 4294967295L);
    }

    public static /* synthetic */ void getWidth$annotations() {
    }

    /* renamed from: getWidth-impl, reason: not valid java name */
    public static final int m7160getWidthimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m7161hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m7157equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m7161hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m7164unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ IntSize(long j) {
        this.packedValue = j;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    /* renamed from: times-YEO4UFw, reason: not valid java name */
    public static final long m7162timesYEO4UFw(long j, int i) {
        return m7155constructorimpl(((((int) (j >> 32)) * i) << 32) | ((((int) (j & 4294967295L)) * i) & 4294967295L));
    }

    /* renamed from: div-YEO4UFw, reason: not valid java name */
    public static final long m7156divYEO4UFw(long j, int i) {
        return m7155constructorimpl(((((int) (j >> 32)) / i) << 32) | ((((int) (j & 4294967295L)) / i) & 4294967295L));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m7163toStringimpl(long j) {
        return ((int) (j >> 32)) + " x " + ((int) (j & 4294967295L));
    }

    public String toString() {
        return m7163toStringimpl(this.packedValue);
    }

    /* compiled from: IntSize.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Landroidx/compose/ui/unit/IntSize$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/unit/IntSize;", "getZero-YbymL2g", "()J", "J", "ui-unit_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getZero-YbymL2g, reason: not valid java name */
        public final long m7165getZeroYbymL2g() {
            return IntSize.Zero;
        }
    }
}
