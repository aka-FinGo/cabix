package kotlin.collections;

import androidx.collection.SieveCacheKt;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.collections.unsigned.UArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import uz.FonRo.pos.data.model.WriteOffReason;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Arrays.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00030\u0003H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0004\u001aK\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0007*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00070\u00060\u0003H\u0086\u0080\u0004¢\u0006\u0002\u0010\b\u001a<\u0010\t\u001a\u00020\n*\b\u0012\u0002\b\u0003\u0018\u00010\u0003H\u0087\u0088\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000eb\u0002\b\u000f\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0002\u0010\u000b\u001a[\u0010\u0010\u001a\u0002H\u0007\"\u0010\b\u0000\u0010\u0011*\u0006\u0012\u0002\b\u00030\u0003*\u0002H\u0007\"\u0004\b\u0001\u0010\u0007*\u0002H\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013H\u0087\u0088\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000eb\u0002\b\u000fø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0014\u001aW\u0010\u0015\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u00032\u0010\u0010\u0016\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0081\u0080\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000eb\u0002\b\u0019b\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0017¢\u0006\u0004\b\u0017\u0010\u0018\u001aE\u0010\u001c\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0081\u0080\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000eb\u0002\b\u0019b\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e¢\u0006\u0004\b\u001e\u0010\u001f\u001aA\u0010 \u001a\u00020!\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\n\u0010\"\u001a\u00060#j\u0002`$2\u0010\u0010%\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030&H\u0082\u0080\u0004¢\u0006\u0004\b'\u0010(\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)"}, d2 = {"flatten", "", ExifInterface.GPS_DIRECTION_TRUE, "", "([[Ljava/lang/Object;)Ljava/util/List;", "unzip", "Lkotlin/Pair;", "R", "([Lkotlin/Pair;)Lkotlin/Pair;", "isNullOrEmpty", "", "([Ljava/lang/Object;)Z", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/internal/InlineOnly;", "ifEmpty", "C", "defaultValue", "Lkotlin/Function0;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "contentDeepEqualsImpl", WriteOffReason.OTHER, "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "Lkotlin/PublishedApi;", "Lkotlin/jvm/JvmName;", "name", "contentDeepToStringImpl", "", "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringInternal", "", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "processed", "", "contentDeepToStringInternal$ArraysKt__ArraysKt", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes6.dex */
public class ArraysKt__ArraysKt extends ArraysKt__ArraysJVMKt {
    public static final <T> List<T> flatten(T[][] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        T[][] tArr2 = tArr;
        long j = 0;
        for (T[] tArr3 : tArr2) {
            j += tArr3.length;
        }
        if (j == 0) {
            return CollectionsKt.emptyList();
        }
        if (j > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException(("Sum of all arrays lengths (" + j + ") exceeds maximum list size (2147483647)").toString());
        }
        Object[] objArr = new Object[(int) j];
        int length = tArr2.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            T[] tArr4 = tArr[i2];
            ArraysKt.copyInto$default(tArr4, objArr, i, 0, 0, 12, (Object) null);
            i += tArr4.length;
        }
        List<T> asList = ArraysKt.asList(objArr);
        Intrinsics.checkNotNull(asList, "null cannot be cast to non-null type kotlin.collections.List<T of kotlin.collections.ArraysKt__ArraysKt.flatten>");
        return asList;
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Pair<? extends T, ? extends R>[] pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "<this>");
        ArrayList arrayList = new ArrayList(pairArr.length);
        ArrayList arrayList2 = new ArrayList(pairArr.length);
        for (Pair<? extends T, ? extends R> pair : pairArr) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return TuplesKt.to(arrayList, arrayList2);
    }

    private static final boolean isNullOrEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    /* JADX WARN: Incorrect types in method signature: <C:[Ljava/lang/Object;:TR;R:Ljava/lang/Object;>(TC;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    private static final Object ifEmpty(Object[] objArr, Function0 defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return objArr.length == 0 ? defaultValue.invoke() : objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean contentDeepEquals(T[] tArr, T[] tArr2) {
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == 0 || tArr2 == 0 || tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            Object[] objArr = tArr[i];
            Object[] objArr2 = tArr2[i];
            if (objArr != objArr2) {
                if (objArr == 0 || objArr2 == 0) {
                    return false;
                }
                if ((objArr instanceof Object[]) && (objArr2 instanceof Object[])) {
                    if (!ArraysKt.contentDeepEquals(objArr, objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof byte[]) && (objArr2 instanceof byte[])) {
                    if (!Arrays.equals((byte[]) objArr, (byte[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof short[]) && (objArr2 instanceof short[])) {
                    if (!Arrays.equals((short[]) objArr, (short[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof int[]) && (objArr2 instanceof int[])) {
                    if (!Arrays.equals((int[]) objArr, (int[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof long[]) && (objArr2 instanceof long[])) {
                    if (!Arrays.equals((long[]) objArr, (long[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof float[]) && (objArr2 instanceof float[])) {
                    if (!Arrays.equals((float[]) objArr, (float[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof double[]) && (objArr2 instanceof double[])) {
                    if (!Arrays.equals((double[]) objArr, (double[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof char[]) && (objArr2 instanceof char[])) {
                    if (!Arrays.equals((char[]) objArr, (char[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof boolean[]) && (objArr2 instanceof boolean[])) {
                    if (!Arrays.equals((boolean[]) objArr, (boolean[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof UByteArray) && (objArr2 instanceof UByteArray)) {
                    if (!UArraysKt.m8451contentEqualskV0jMPg(((UByteArray) objArr).getStorage(), ((UByteArray) objArr2).getStorage())) {
                        return false;
                    }
                } else if ((objArr instanceof UShortArray) && (objArr2 instanceof UShortArray)) {
                    if (!UArraysKt.m8449contentEqualsFGO6Aew(((UShortArray) objArr).getStorage(), ((UShortArray) objArr2).getStorage())) {
                        return false;
                    }
                } else if ((objArr instanceof UIntArray) && (objArr2 instanceof UIntArray)) {
                    if (!UArraysKt.m8450contentEqualsKJPZfPQ(((UIntArray) objArr).getStorage(), ((UIntArray) objArr2).getStorage())) {
                        return false;
                    }
                } else if ((objArr instanceof ULongArray) && (objArr2 instanceof ULongArray)) {
                    if (!UArraysKt.m8452contentEqualslec5QzE(((ULongArray) objArr).getStorage(), ((ULongArray) objArr2).getStorage())) {
                        return false;
                    }
                } else if (!Intrinsics.areEqual(objArr, objArr2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final <T> String contentDeepToString(T[] tArr) {
        if (tArr == null) {
            return AbstractJsonLexerKt.NULL;
        }
        StringBuilder sb = new StringBuilder((RangesKt.coerceAtMost(tArr.length, 429496729) * 5) + 2);
        contentDeepToStringInternal$ArraysKt__ArraysKt(tArr, sb, new ArrayList());
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void contentDeepToStringInternal$ArraysKt__ArraysKt(T[] tArr, StringBuilder sb, List<Object[]> list) {
        if (list.contains(tArr)) {
            sb.append("[...]");
            return;
        }
        list.add(tArr);
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            Object[] objArr = tArr[i];
            if (objArr == 0) {
                sb.append(AbstractJsonLexerKt.NULL);
            } else if (objArr instanceof Object[]) {
                contentDeepToStringInternal$ArraysKt__ArraysKt(objArr, sb, list);
                Unit unit = Unit.INSTANCE;
            } else if (objArr instanceof byte[]) {
                String arrays = Arrays.toString((byte[]) objArr);
                Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
                sb.append(arrays);
            } else if (objArr instanceof short[]) {
                String arrays2 = Arrays.toString((short[]) objArr);
                Intrinsics.checkNotNullExpressionValue(arrays2, "toString(...)");
                sb.append(arrays2);
            } else if (objArr instanceof int[]) {
                String arrays3 = Arrays.toString((int[]) objArr);
                Intrinsics.checkNotNullExpressionValue(arrays3, "toString(...)");
                sb.append(arrays3);
            } else if (objArr instanceof long[]) {
                String arrays4 = Arrays.toString((long[]) objArr);
                Intrinsics.checkNotNullExpressionValue(arrays4, "toString(...)");
                sb.append(arrays4);
            } else if (objArr instanceof float[]) {
                String arrays5 = Arrays.toString((float[]) objArr);
                Intrinsics.checkNotNullExpressionValue(arrays5, "toString(...)");
                sb.append(arrays5);
            } else if (objArr instanceof double[]) {
                String arrays6 = Arrays.toString((double[]) objArr);
                Intrinsics.checkNotNullExpressionValue(arrays6, "toString(...)");
                sb.append(arrays6);
            } else if (objArr instanceof char[]) {
                String arrays7 = Arrays.toString((char[]) objArr);
                Intrinsics.checkNotNullExpressionValue(arrays7, "toString(...)");
                sb.append(arrays7);
            } else if (objArr instanceof boolean[]) {
                String arrays8 = Arrays.toString((boolean[]) objArr);
                Intrinsics.checkNotNullExpressionValue(arrays8, "toString(...)");
                sb.append(arrays8);
            } else if (objArr instanceof UByteArray) {
                UByteArray uByteArray = (UByteArray) objArr;
                sb.append(UArraysKt.m8457contentToString2csIQuQ(uByteArray != null ? uByteArray.getStorage() : null));
            } else if (objArr instanceof UShortArray) {
                UShortArray uShortArray = (UShortArray) objArr;
                sb.append(UArraysKt.m8459contentToStringd6D3K8(uShortArray != null ? uShortArray.getStorage() : null));
            } else if (objArr instanceof UIntArray) {
                UIntArray uIntArray = (UIntArray) objArr;
                sb.append(UArraysKt.m8458contentToStringXUkPCBk(uIntArray != null ? uIntArray.getStorage() : null));
            } else if (objArr instanceof ULongArray) {
                ULongArray uLongArray = (ULongArray) objArr;
                sb.append(UArraysKt.m8460contentToStringuLth9ew(uLongArray != null ? uLongArray.getStorage() : null));
            } else {
                sb.append(objArr.toString());
            }
        }
        sb.append(AbstractJsonLexerKt.END_LIST);
        list.remove(CollectionsKt.getLastIndex(list));
    }
}
