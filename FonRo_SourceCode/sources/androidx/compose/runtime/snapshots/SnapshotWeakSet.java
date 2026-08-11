package androidx.compose.runtime.snapshots;

import android.R;
import androidx.compose.runtime.internal.Utils_jvmKt;
import androidx.compose.runtime.internal.WeakReference;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;

/* compiled from: SnapshotWeakSet.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\u001d\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u001eJ%\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\"J\r\u0010#\u001a\u00020\u0019H\u0001¢\u0006\u0002\b$J\u001d\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190(H\u0086\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00120\u0011X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006)"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "hashes", "", "getHashes$runtime_release", "()[I", "setHashes$runtime_release", "([I)V", "size", "", "getSize$runtime_release", "()I", "setSize$runtime_release", "(I)V", "values", "", "Landroidx/compose/runtime/internal/WeakReference;", "getValues$runtime_release", "()[Landroidx/compose/runtime/internal/WeakReference;", "setValues$runtime_release", "([Landroidx/compose/runtime/internal/WeakReference;)V", "[Landroidx/compose/runtime/internal/WeakReference;", "add", "", "value", "(Ljava/lang/Object;)Z", "find", "hash", "(Ljava/lang/Object;I)I", "findExactIndex", "midIndex", "valueHash", "(ILjava/lang/Object;I)I", "isValid", "isValid$runtime_release", "removeIf", "", "block", "Lkotlin/Function1;", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class SnapshotWeakSet<T> {
    public static final int $stable = 8;
    private int size;
    private int[] hashes = new int[16];
    private WeakReference<T>[] values = new WeakReference[16];

    /* renamed from: getSize$runtime_release, reason: from getter */
    public final int getSize() {
        return this.size;
    }

    public final void setSize$runtime_release(int i) {
        this.size = i;
    }

    /* renamed from: getHashes$runtime_release, reason: from getter */
    public final int[] getHashes() {
        return this.hashes;
    }

    public final void setHashes$runtime_release(int[] iArr) {
        this.hashes = iArr;
    }

    public final WeakReference<T>[] getValues$runtime_release() {
        return this.values;
    }

    public final void setValues$runtime_release(WeakReference<T>[] weakReferenceArr) {
        this.values = weakReferenceArr;
    }

    public final boolean add(T value) {
        int i;
        int i2 = this.size;
        int identityHashCode = Utils_jvmKt.identityHashCode(value);
        if (i2 > 0) {
            i = find(value, identityHashCode);
            if (i >= 0) {
                return false;
            }
        } else {
            i = -1;
        }
        int i3 = -(i + 1);
        WeakReference<T>[] weakReferenceArr = this.values;
        int length = weakReferenceArr.length;
        if (i2 == length) {
            int i4 = length * 2;
            WeakReference<T>[] weakReferenceArr2 = new WeakReference[i4];
            int[] iArr = new int[i4];
            int i5 = i3 + 1;
            System.arraycopy(weakReferenceArr, i3, weakReferenceArr2, i5, i2 - i3);
            System.arraycopy(this.values, 0, weakReferenceArr2, 0, i3);
            ArraysKt.copyInto(this.hashes, iArr, i5, i3, i2);
            ArraysKt.copyInto$default(this.hashes, iArr, 0, 0, i3, 6, (Object) null);
            this.values = weakReferenceArr2;
            this.hashes = iArr;
        } else {
            int i6 = i3 + 1;
            System.arraycopy(weakReferenceArr, i3, weakReferenceArr, i6, i2 - i3);
            int[] iArr2 = this.hashes;
            ArraysKt.copyInto(iArr2, iArr2, i6, i3, i2);
        }
        this.values[i3] = new WeakReference<>(value);
        this.hashes[i3] = identityHashCode;
        this.size++;
        return true;
    }

    public final void removeIf(Function1<? super T, Boolean> block) {
        int size = getSize();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            WeakReference<T> weakReference = getValues$runtime_release()[i];
            R.animator animatorVar = weakReference != null ? (Object) weakReference.get() : null;
            if (animatorVar != null && !block.invoke(animatorVar).booleanValue()) {
                if (i2 != i) {
                    getValues$runtime_release()[i2] = weakReference;
                    getHashes()[i2] = getHashes()[i];
                }
                i2++;
            }
            i++;
        }
        for (int i3 = i2; i3 < size; i3++) {
            getValues$runtime_release()[i3] = null;
            getHashes()[i3] = 0;
        }
        if (i2 != size) {
            setSize$runtime_release(i2);
        }
    }

    private final int find(T value, int hash) {
        int i = this.size - 1;
        int i2 = 0;
        while (i2 <= i) {
            int i3 = (i2 + i) >>> 1;
            int i4 = this.hashes[i3];
            if (i4 < hash) {
                i2 = i3 + 1;
            } else {
                if (i4 <= hash) {
                    WeakReference<T> weakReference = this.values[i3];
                    return value == (weakReference != null ? weakReference.get() : null) ? i3 : findExactIndex(i3, value, hash);
                }
                i = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    private final int findExactIndex(int midIndex, T value, int valueHash) {
        int i = midIndex - 1;
        while (true) {
            if (-1 >= i || this.hashes[i] != valueHash) {
                break;
            }
            WeakReference<T> weakReference = this.values[i];
            if ((weakReference != null ? weakReference.get() : null) == value) {
                return i;
            }
            i--;
        }
        int i2 = this.size;
        for (int i3 = midIndex + 1; i3 < i2; i3++) {
            if (this.hashes[i3] != valueHash) {
                return -(i3 + 1);
            }
            WeakReference<T> weakReference2 = this.values[i3];
            if ((weakReference2 != null ? weakReference2.get() : null) == value) {
                return i3;
            }
        }
        return -(this.size + 1);
    }

    public final boolean isValid$runtime_release() {
        WeakReference<T> weakReference;
        int i = this.size;
        WeakReference<T>[] weakReferenceArr = this.values;
        int[] iArr = this.hashes;
        int length = weakReferenceArr.length;
        if (i > length) {
            return false;
        }
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < i) {
            int i4 = iArr[i3];
            if (i4 < i2 || (weakReference = weakReferenceArr[i3]) == null) {
                return false;
            }
            Object obj = weakReference.get();
            if (obj != null && i4 != Utils_jvmKt.identityHashCode(obj)) {
                return false;
            }
            i3++;
            i2 = i4;
        }
        while (i < length) {
            if (iArr[i] != 0 || weakReferenceArr[i] != null) {
                return false;
            }
            i++;
        }
        return true;
    }
}
