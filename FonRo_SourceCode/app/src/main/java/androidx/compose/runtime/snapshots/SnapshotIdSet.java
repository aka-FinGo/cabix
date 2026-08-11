package androidx.compose.runtime.snapshots;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: SnapshotIdSet.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 &2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001&B3\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003\u0012\u000e\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000J\u0012\u0010\u000e\u001a\u00020\u00002\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u0003J>\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00002+\u0010\u0012\u001a'\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00000\u0013H\u0082\bJ!\u0010\u0017\u001a\u00020\u00182\u0016\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00180\u001aH\u0086\bJ\u0012\u0010\u001b\u001a\u00020\u001c2\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u0003J\u0013\u0010\u001d\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001eH\u0096\u0002J\u0016\u0010\u001f\u001a\u00060\u0002j\u0002`\u00032\n\u0010 \u001a\u00060\u0002j\u0002`\u0003J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0000J\u0012\u0010#\u001a\u00020\u00002\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u0003J\b\u0010$\u001a\u00020%H\u0016R\u0016\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "upperSet", "lowerSet", "lowerBound", "belowBound", "", "Landroidx/compose/runtime/snapshots/SnapshotIdArray;", "(JJJ[J)V", "and", "ids", "andNot", "clear", "id", "fastFold", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "fastForEach", "", "block", "Lkotlin/Function1;", "get", "", "iterator", "", "lowest", "default", "or", "bits", "set", "toString", "", "Companion", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class SnapshotIdSet implements Iterable<Long>, KMappedMarker {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SnapshotIdSet EMPTY = new SnapshotIdSet(0, 0, 0, null);
    private final long[] belowBound;
    private final long lowerBound;
    private final long lowerSet;
    private final long upperSet;

    private SnapshotIdSet(long j, long j2, long j3, long[] jArr) {
        this.upperSet = j;
        this.lowerSet = j2;
        this.lowerBound = j3;
        this.belowBound = jArr;
    }

    public final boolean get(long id) {
        long[] jArr;
        long j = id - this.lowerBound;
        return (j < 0 || j >= 64) ? (j < 64 || j >= 128) ? j <= 0 && (jArr = this.belowBound) != null && SnapshotId_jvmKt.binarySearch(jArr, id) >= 0 : ((1 << (((int) j) + (-64))) & this.upperSet) != 0 : ((1 << ((int) j)) & this.lowerSet) != 0;
    }

    public final SnapshotIdSet set(long id) {
        long j;
        long j2;
        long[] jArr;
        SnapshotIdArrayBuilder snapshotIdArrayBuilder;
        int i;
        long j3;
        long j4 = this.lowerBound;
        long j5 = id - j4;
        long j6 = 0;
        long j7 = 64;
        if (j5 >= 0 && j5 < 64) {
            long j8 = 1 << ((int) j5);
            long j9 = this.lowerSet;
            if ((j9 & j8) == 0) {
                return new SnapshotIdSet(this.upperSet, j9 | j8, j4, this.belowBound);
            }
        } else if (j5 >= 64 && j5 < 128) {
            long j10 = 1 << (((int) j5) - 64);
            long j11 = this.upperSet;
            if ((j11 & j10) == 0) {
                return new SnapshotIdSet(j10 | j11, this.lowerSet, j4, this.belowBound);
            }
        } else if (j5 >= 128) {
            if (!get(id)) {
                long j12 = this.upperSet;
                int i2 = 0;
                long j13 = this.lowerSet;
                long j14 = this.lowerBound;
                long j15 = ((id + 1) / 64) * 64;
                if (j15 < 0) {
                    j15 = 9223372036854775680L;
                }
                SnapshotIdArrayBuilder snapshotIdArrayBuilder2 = null;
                long j16 = j12;
                while (true) {
                    if (j14 >= j15) {
                        j = j14;
                        j2 = j13;
                        break;
                    }
                    if (j13 != j6) {
                        if (snapshotIdArrayBuilder2 == null) {
                            j2 = j6;
                            snapshotIdArrayBuilder = new SnapshotIdArrayBuilder(this.belowBound);
                        } else {
                            j2 = j6;
                            snapshotIdArrayBuilder = snapshotIdArrayBuilder2;
                        }
                        int i3 = i2;
                        while (i3 < 64) {
                            if ((j13 & (1 << i3)) != j2) {
                                i = i2;
                                j3 = j7;
                                snapshotIdArrayBuilder.add(i3 + j14);
                            } else {
                                i = i2;
                                j3 = j7;
                            }
                            i3++;
                            i2 = i;
                            j7 = j3;
                        }
                        snapshotIdArrayBuilder2 = snapshotIdArrayBuilder;
                    } else {
                        j2 = j6;
                    }
                    int i4 = i2;
                    long j17 = j7;
                    if (j16 == j2) {
                        j = j15;
                        break;
                    }
                    j14 += j17;
                    i2 = i4;
                    j13 = j16;
                    j6 = j2;
                    j16 = j6;
                    j7 = j17;
                }
                if (snapshotIdArrayBuilder2 == null || (jArr = snapshotIdArrayBuilder2.toArray()) == null) {
                    jArr = this.belowBound;
                }
                return new SnapshotIdSet(j16, j2, j, jArr).set(id);
            }
        } else {
            long[] jArr2 = this.belowBound;
            if (jArr2 == null) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, j4, new long[]{id});
            }
            int binarySearch = SnapshotId_jvmKt.binarySearch(jArr2, id);
            if (binarySearch < 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, SnapshotId_jvmKt.withIdInsertedAt(jArr2, -(binarySearch + 1), id));
            }
        }
        return this;
    }

    public final SnapshotIdSet clear(long id) {
        long[] jArr;
        int binarySearch;
        long j = this.lowerBound;
        long j2 = id - j;
        if (j2 >= 0 && j2 < 64) {
            long j3 = 1 << ((int) j2);
            long j4 = this.lowerSet;
            if ((j4 & j3) != 0) {
                return new SnapshotIdSet(this.upperSet, j4 & (~j3), j, this.belowBound);
            }
        } else if (j2 >= 64 && j2 < 128) {
            long j5 = 1 << (((int) j2) - 64);
            long j6 = this.upperSet;
            if ((j6 & j5) != 0) {
                return new SnapshotIdSet(j6 & (~j5), this.lowerSet, j, this.belowBound);
            }
        } else if (j2 < 0 && (jArr = this.belowBound) != null && (binarySearch = SnapshotId_jvmKt.binarySearch(jArr, id)) >= 0) {
            return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, SnapshotId_jvmKt.withIdRemovedAt(jArr, binarySearch));
        }
        return this;
    }

    public final SnapshotIdSet andNot(SnapshotIdSet ids) {
        SnapshotIdSet snapshotIdSet = EMPTY;
        if (ids == snapshotIdSet) {
            return this;
        }
        if (this == snapshotIdSet) {
            return snapshotIdSet;
        }
        long j = ids.lowerBound;
        long j2 = this.lowerBound;
        if (j == j2) {
            long[] jArr = ids.belowBound;
            long[] jArr2 = this.belowBound;
            if (jArr == jArr2) {
                return new SnapshotIdSet((~ids.upperSet) & this.upperSet, this.lowerSet & (~ids.lowerSet), j2, jArr2);
            }
        }
        long[] jArr3 = ids.belowBound;
        if (jArr3 != null) {
            for (long j3 : jArr3) {
                this = this.clear(j3);
            }
        }
        if (ids.lowerSet != 0) {
            for (int i = 0; i < 64; i++) {
                if ((ids.lowerSet & (1 << i)) != 0) {
                    this = this.clear(ids.lowerBound + i);
                }
            }
        }
        if (ids.upperSet != 0) {
            for (int i2 = 0; i2 < 64; i2++) {
                if ((ids.upperSet & (1 << i2)) != 0) {
                    this = this.clear(ids.lowerBound + i2 + 64);
                }
            }
        }
        return this;
    }

    public final SnapshotIdSet and(SnapshotIdSet ids) {
        SnapshotIdSet snapshotIdSet = EMPTY;
        if (!Intrinsics.areEqual(ids, snapshotIdSet) && !Intrinsics.areEqual(this, snapshotIdSet)) {
            long j = ids.lowerBound;
            long j2 = this.lowerBound;
            if (j == j2) {
                long[] jArr = ids.belowBound;
                long[] jArr2 = this.belowBound;
                if (jArr == jArr2) {
                    long j3 = this.upperSet;
                    long j4 = ids.upperSet;
                    long j5 = j3 & j4;
                    long j6 = this.lowerSet;
                    long j7 = ids.lowerSet;
                    long j8 = j6 & j7;
                    if (j5 != 0 || j8 != 0 || jArr2 != null) {
                        return new SnapshotIdSet(j3 & j4, j6 & j7, j2, jArr2);
                    }
                }
            }
            int i = 0;
            if (this.belowBound == null) {
                long[] jArr3 = this.belowBound;
                if (jArr3 != null) {
                    for (long j9 : jArr3) {
                        if (ids.get(j9)) {
                            snapshotIdSet = snapshotIdSet.set(j9);
                        }
                    }
                }
                if (this.lowerSet != 0) {
                    for (int i2 = 0; i2 < 64; i2++) {
                        if ((this.lowerSet & (1 << i2)) != 0) {
                            long j10 = this.lowerBound + i2;
                            if (ids.get(j10)) {
                                snapshotIdSet = snapshotIdSet.set(j10);
                            }
                        }
                    }
                }
                if (this.upperSet != 0) {
                    while (i < 64) {
                        if ((this.upperSet & (1 << i)) != 0) {
                            long j11 = this.lowerBound + i + 64;
                            if (ids.get(j11)) {
                                snapshotIdSet = snapshotIdSet.set(j11);
                            }
                        }
                        i++;
                    }
                }
                return snapshotIdSet;
            }
            long[] jArr4 = ids.belowBound;
            if (jArr4 != null) {
                for (long j12 : jArr4) {
                    if (get(j12)) {
                        snapshotIdSet = snapshotIdSet.set(j12);
                    }
                }
            }
            if (ids.lowerSet != 0) {
                for (int i3 = 0; i3 < 64; i3++) {
                    if ((ids.lowerSet & (1 << i3)) != 0) {
                        long j13 = ids.lowerBound + i3;
                        if (get(j13)) {
                            snapshotIdSet = snapshotIdSet.set(j13);
                        }
                    }
                }
            }
            if (ids.upperSet != 0) {
                while (i < 64) {
                    if ((ids.upperSet & (1 << i)) != 0) {
                        long j14 = ids.lowerBound + i + 64;
                        if (get(j14)) {
                            snapshotIdSet = snapshotIdSet.set(j14);
                        }
                    }
                    i++;
                }
            }
            return snapshotIdSet;
        }
        return snapshotIdSet;
    }

    public final SnapshotIdSet or(SnapshotIdSet bits) {
        SnapshotIdSet snapshotIdSet = EMPTY;
        if (bits == snapshotIdSet) {
            return this;
        }
        if (this == snapshotIdSet) {
            return bits;
        }
        long j = bits.lowerBound;
        long j2 = this.lowerBound;
        if (j == j2) {
            long[] jArr = bits.belowBound;
            long[] jArr2 = this.belowBound;
            if (jArr == jArr2) {
                return new SnapshotIdSet(bits.upperSet | this.upperSet, this.lowerSet | bits.lowerSet, j2, jArr2);
            }
        }
        int i = 0;
        if (this.belowBound == null) {
            long[] jArr3 = this.belowBound;
            if (jArr3 != null) {
                for (long j3 : jArr3) {
                    bits = bits.set(j3);
                }
            }
            if (this.lowerSet != 0) {
                for (int i2 = 0; i2 < 64; i2++) {
                    if ((this.lowerSet & (1 << i2)) != 0) {
                        bits = bits.set(this.lowerBound + i2);
                    }
                }
            }
            if (this.upperSet != 0) {
                while (i < 64) {
                    if ((this.upperSet & (1 << i)) != 0) {
                        bits = bits.set(this.lowerBound + i + 64);
                    }
                    i++;
                }
            }
            return bits;
        }
        long[] jArr4 = bits.belowBound;
        if (jArr4 != null) {
            for (long j4 : jArr4) {
                this = this.set(j4);
            }
        }
        if (bits.lowerSet != 0) {
            for (int i3 = 0; i3 < 64; i3++) {
                if ((bits.lowerSet & (1 << i3)) != 0) {
                    this = this.set(bits.lowerBound + i3);
                }
            }
        }
        if (bits.upperSet != 0) {
            while (i < 64) {
                if ((bits.upperSet & (1 << i)) != 0) {
                    this = this.set(bits.lowerBound + i + 64);
                }
                i++;
            }
        }
        return this;
    }

    @Override // java.lang.Iterable
    public Iterator<Long> iterator() {
        return SequencesKt.sequence(new SnapshotIdSet$iterator$1(this, null)).iterator();
    }

    public final void fastForEach(Function1<? super Long, Unit> block) {
        long[] jArr = this.belowBound;
        if (jArr != null) {
            for (long j : jArr) {
                block.invoke(Long.valueOf(j));
            }
        }
        if (this.lowerSet != 0) {
            for (int i = 0; i < 64; i++) {
                if ((this.lowerSet & (1 << i)) != 0) {
                    block.invoke(Long.valueOf(this.lowerBound + i));
                }
            }
        }
        if (this.upperSet != 0) {
            for (int i2 = 0; i2 < 64; i2++) {
                if ((this.upperSet & (1 << i2)) != 0) {
                    block.invoke(Long.valueOf(this.lowerBound + i2 + 64));
                }
            }
        }
    }

    public final long lowest(long r6) {
        long[] jArr = this.belowBound;
        if (jArr == null) {
            if (this.lowerSet != 0) {
                return this.lowerBound + Long.numberOfTrailingZeros(r0);
            }
            return this.upperSet != 0 ? this.lowerBound + 64 + Long.numberOfTrailingZeros(r0) : r6;
        }
        return jArr[0];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" [");
        SnapshotIdSet snapshotIdSet = this;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(snapshotIdSet, 10));
        Iterator<Long> it = snapshotIdSet.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next().longValue()));
        }
        sb.append(ListUtilsKt.fastJoinToString$default(arrayList, null, null, null, 0, null, null, 63, null));
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    /* compiled from: SnapshotIdSet.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getEMPTY", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.EMPTY;
        }
    }

    private final SnapshotIdSet fastFold(SnapshotIdSet initial, Function2<? super SnapshotIdSet, ? super Long, SnapshotIdSet> operation) {
        long[] jArr = this.belowBound;
        if (jArr != null) {
            for (long j : jArr) {
                initial = operation.invoke(initial, Long.valueOf(j));
            }
        }
        if (this.lowerSet != 0) {
            for (int i = 0; i < 64; i++) {
                if ((this.lowerSet & (1 << i)) != 0) {
                    initial = operation.invoke(initial, Long.valueOf(this.lowerBound + i));
                }
            }
        }
        if (this.upperSet != 0) {
            for (int i2 = 0; i2 < 64; i2++) {
                if ((this.upperSet & (1 << i2)) != 0) {
                    initial = operation.invoke(initial, Long.valueOf(this.lowerBound + i2 + 64));
                }
            }
        }
        return initial;
    }
}
