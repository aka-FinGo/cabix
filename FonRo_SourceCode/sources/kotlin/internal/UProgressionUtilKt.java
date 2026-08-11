package kotlin.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.UInt;
import kotlin.ULong;

/* compiled from: UProgressionUtil.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a)\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0082\u0080\u0004¢\u0006\u0004\b\b\u0010\t\u001a?\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0081\u0080\u0004b\u0002\b\u0010b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013b\u0002\b\u0014¢\u0006\u0004\b\u000f\u0010\u0006\u001a?\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0015H\u0081\u0080\u0004b\u0002\b\u0010b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013b\u0002\b\u0014¢\u0006\u0004\b\u0016\u0010\t¨\u0006\u0017"}, d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "Lkotlin/PublishedApi;", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/internal/UsedFromCompilerGeneratedCode;", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes6.dex */
public final class UProgressionUtilKt {
    /* renamed from: differenceModulo-WZ9TVnA, reason: not valid java name */
    private static final int m9112differenceModuloWZ9TVnA(int i, int i2, int i3) {
        int compare;
        int m$1 = UByte$$ExternalSyntheticBackport0.m$1(i, i3);
        int m$12 = UByte$$ExternalSyntheticBackport0.m$1(i2, i3);
        compare = Integer.compare(m$1 ^ Integer.MIN_VALUE, m$12 ^ Integer.MIN_VALUE);
        int m7970constructorimpl = UInt.m7970constructorimpl(m$1 - m$12);
        return compare >= 0 ? m7970constructorimpl : UInt.m7970constructorimpl(m7970constructorimpl + i3);
    }

    /* renamed from: differenceModulo-sambcqE, reason: not valid java name */
    private static final long m9113differenceModulosambcqE(long j, long j2, long j3) {
        int compare;
        long m$1 = UByte$$ExternalSyntheticBackport0.m$1(j, j3);
        long m$12 = UByte$$ExternalSyntheticBackport0.m$1(j2, j3);
        compare = Long.compare(m$1 ^ Long.MIN_VALUE, m$12 ^ Long.MIN_VALUE);
        long m8049constructorimpl = ULong.m8049constructorimpl(m$1 - m$12);
        return compare >= 0 ? m8049constructorimpl : ULong.m8049constructorimpl(m8049constructorimpl + j3);
    }

    /* renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m9115getProgressionLastElementNkh28Cs(int i, int i2, int i3) {
        int compare;
        int compare2;
        if (i3 > 0) {
            compare2 = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
            if (compare2 < 0) {
                return UInt.m7970constructorimpl(i2 - m9112differenceModuloWZ9TVnA(i2, i, UInt.m7970constructorimpl(i3)));
            }
        } else if (i3 < 0) {
            compare = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
            if (compare > 0) {
                return UInt.m7970constructorimpl(i2 + m9112differenceModuloWZ9TVnA(i, i2, UInt.m7970constructorimpl(-i3)));
            }
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
        return i2;
    }

    /* renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m9114getProgressionLastElement7ftBX0g(long j, long j2, long j3) {
        int compare;
        int compare2;
        if (j3 > 0) {
            compare2 = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
            return compare2 >= 0 ? j2 : ULong.m8049constructorimpl(j2 - m9113differenceModulosambcqE(j2, j, ULong.m8049constructorimpl(j3)));
        }
        if (j3 < 0) {
            compare = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
            return compare <= 0 ? j2 : ULong.m8049constructorimpl(j2 + m9113differenceModulosambcqE(j, j2, ULong.m8049constructorimpl(-j3)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
