package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: _UCollections.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a+\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0004\u001a+\u0010\t\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0002\u0010\f\u001a+\u0010\r\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u000f0\u0002H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0010\u001a+\u0010\u0011\u001a\u00020\u0012*\b\u0012\u0004\u0012\u00020\u00130\u0002H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0014\u001a7\u0010\u0015\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0087\u0080\u0004b\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0017b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001b¢\u0006\u0004\b\u0017\u0010\u0018\u001a7\u0010\u0015\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u000f0\u0016H\u0087\u0080\u0004b\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001cb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001b¢\u0006\u0004\b\u001c\u0010\u001d\u001a7\u0010\u0015\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0087\u0080\u0004b\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001eb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001b¢\u0006\u0004\b\u001e\u0010\u0018\u001a7\u0010\u0015\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00130\u0016H\u0087\u0080\u0004b\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001fb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001b¢\u0006\u0004\b\u001f\u0010\u0018¨\u0006 "}, d2 = {"toUByteArray", "Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "(Ljava/util/Collection;)[B", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/ExperimentalUnsignedTypes;", "toUIntArray", "Lkotlin/UIntArray;", "Lkotlin/UInt;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "Lkotlin/ULong;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "Lkotlin/UShort;", "(Ljava/util/Collection;)[S", "sum", "", "sumOfUInt", "(Ljava/lang/Iterable;)I", "Lkotlin/jvm/JvmName;", "name", "1.5", "sumOfULong", "(Ljava/lang/Iterable;)J", "sumOfUByte", "sumOfUShort", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/collections/UCollectionsKt")
/* loaded from: classes6.dex */
class UCollectionsKt___UCollectionsKt {
    public static final byte[] toUByteArray(Collection<UByte> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        byte[] m7945constructorimpl = UByteArray.m7945constructorimpl(collection.size());
        Iterator<UByte> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            UByteArray.m7956setVurrAj0(m7945constructorimpl, i, it.next().getData());
            i++;
        }
        return m7945constructorimpl;
    }

    public static final int[] toUIntArray(Collection<UInt> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] m8024constructorimpl = UIntArray.m8024constructorimpl(collection.size());
        Iterator<UInt> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            UIntArray.m8035setVXSXFK8(m8024constructorimpl, i, it.next().getData());
            i++;
        }
        return m8024constructorimpl;
    }

    public static final long[] toULongArray(Collection<ULong> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] m8103constructorimpl = ULongArray.m8103constructorimpl(collection.size());
        Iterator<ULong> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            ULongArray.m8114setk8EXiF4(m8103constructorimpl, i, it.next().getData());
            i++;
        }
        return m8103constructorimpl;
    }

    public static final short[] toUShortArray(Collection<UShort> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        short[] m8208constructorimpl = UShortArray.m8208constructorimpl(collection.size());
        Iterator<UShort> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            UShortArray.m8219set01HTLdE(m8208constructorimpl, i, it.next().getData());
            i++;
        }
        return m8208constructorimpl;
    }

    public static final int sumOfUInt(Iterable<UInt> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UInt> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = UInt.m7970constructorimpl(i + it.next().getData());
        }
        return i;
    }

    public static final long sumOfULong(Iterable<ULong> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<ULong> it = iterable.iterator();
        long j = 0;
        while (it.hasNext()) {
            j = ULong.m8049constructorimpl(j + it.next().getData());
        }
        return j;
    }

    public static final int sumOfUByte(Iterable<UByte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UByte> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = UInt.m7970constructorimpl(i + UInt.m7970constructorimpl(it.next().getData() & 255));
        }
        return i;
    }

    public static final int sumOfUShort(Iterable<UShort> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UShort> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = UInt.m7970constructorimpl(i + UInt.m7970constructorimpl(it.next().getData() & UShort.MAX_VALUE));
        }
        return i;
    }
}
