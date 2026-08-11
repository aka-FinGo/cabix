package kotlin.ranges;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: ULongRange.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 &2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001&B\u0019\bF\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0096\u0082\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\n\u0010\u001e\u001a\u00020\u001aH\u0096\u0080\u0004J\u0014\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0082\u0004J\n\u0010\"\u001a\u00020#H\u0096\u0080\u0004J\n\u0010$\u001a\u00020%H\u0096\u0080\u0004R\u0015\u0010\u0005\u001a\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u00020\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nRI\u0010\f\u001a\u00020\u00038VX\u0097\u0084\br\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015r\u0010\b\u0016\u0012\f\b\u0017\u0012\b\b\fJ\u0004\b\t0\u0018¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\nÊ\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b((¨\u0006'"}, d2 = {"Lkotlin/ranges/ULongRange;", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ULong;", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-s-VKNKU", "()J", "getEndInclusive-s-VKNKU", "endExclusive", "getEndExclusive-s-VKNKU$annotations", "()V", "getEndExclusive-s-VKNKU", "Lkotlin/Deprecated;", "message", "Can throw an exception when it's impossible to represent the value with ULong type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.", "Lkotlin/SinceKotlin;", "version", "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/ExperimentalStdlibApi;", "contains", "", "value", "contains-VKZWuLQ", "(J)Z", "isEmpty", "equals", WriteOffReason.OTHER, "", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib", "1.5"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes6.dex */
public final class ULongRange extends ULongProgression implements ClosedRange<ULong>, OpenEndRange<ULong> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ULongRange EMPTY = new ULongRange(-1, 0, null);

    public /* synthetic */ ULongRange(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with ULong type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    /* renamed from: getEndExclusive-s-VKNKU$annotations, reason: not valid java name */
    public static /* synthetic */ void m9184getEndExclusivesVKNKU$annotations() {
    }

    private ULongRange(long j, long j2) {
        super(j, j2, 1L, null);
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(ULong uLong) {
        return m9185containsVKZWuLQ(uLong.getData());
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ ULong getEndExclusive() {
        return ULong.m8043boximpl(m9186getEndExclusivesVKNKU());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ ULong getEndInclusive() {
        return ULong.m8043boximpl(m9187getEndInclusivesVKNKU());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ ULong getStart() {
        return ULong.m8043boximpl(m9188getStartsVKNKU());
    }

    /* renamed from: getStart-s-VKNKU, reason: not valid java name */
    public long m9188getStartsVKNKU() {
        return getFirst();
    }

    /* renamed from: getEndInclusive-s-VKNKU, reason: not valid java name */
    public long m9187getEndInclusivesVKNKU() {
        return getLast();
    }

    /* renamed from: getEndExclusive-s-VKNKU, reason: not valid java name */
    public long m9186getEndExclusivesVKNKU() {
        if (getLast() == -1) {
            throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
        }
        return ULong.m8049constructorimpl(getLast() + ULong.m8049constructorimpl(1L));
    }

    /* renamed from: contains-VKZWuLQ, reason: not valid java name */
    public boolean m9185containsVKZWuLQ(long value) {
        int compare;
        int compare2;
        compare = Long.compare(getFirst() ^ Long.MIN_VALUE, value ^ Long.MIN_VALUE);
        if (compare > 0) {
            return false;
        }
        compare2 = Long.compare(value ^ Long.MIN_VALUE, getLast() ^ Long.MIN_VALUE);
        return compare2 <= 0;
    }

    @Override // kotlin.ranges.ULongProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        int compare;
        compare = Long.compare(getFirst() ^ Long.MIN_VALUE, getLast() ^ Long.MIN_VALUE);
        return compare > 0;
    }

    @Override // kotlin.ranges.ULongProgression
    public boolean equals(Object other) {
        if (!(other instanceof ULongRange)) {
            return false;
        }
        if (isEmpty() && ((ULongRange) other).isEmpty()) {
            return true;
        }
        ULongRange uLongRange = (ULongRange) other;
        return getFirst() == uLongRange.getFirst() && getLast() == uLongRange.getLast();
    }

    @Override // kotlin.ranges.ULongProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((int) ULong.m8049constructorimpl(getFirst() ^ ULong.m8049constructorimpl(getFirst() >>> 32))) * 31) + ((int) ULong.m8049constructorimpl(getLast() ^ ULong.m8049constructorimpl(getLast() >>> 32)));
    }

    @Override // kotlin.ranges.ULongProgression
    public String toString() {
        return ((Object) ULong.m8095toStringimpl(getFirst())) + ".." + ((Object) ULong.m8095toStringimpl(getLast()));
    }

    /* compiled from: ULongRange.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/ranges/ULongRange$Companion;", "", "<init>", "()V", "EMPTY", "Lkotlin/ranges/ULongRange;", "getEMPTY", "()Lkotlin/ranges/ULongRange;", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ULongRange getEMPTY() {
            return ULongRange.EMPTY;
        }
    }
}
