package coil.memory;

import android.graphics.Bitmap;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.memory.MemoryCache;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: WeakMemoryCache.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u0000 (2\u00020\u0001:\u0002'(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J4\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\u0006\u0010\u001e\u001a\u00020\rH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\rH\u0016J\b\u0010$\u001a\u00020\u0017H\u0002J\r\u0010%\u001a\u00020\u0017H\u0001¢\u0006\u0002\b&R.\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u000e\u001a\r\u0012\t\u0012\u00070\u0006¢\u0006\u0002\b\u00100\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Lcoil/memory/RealWeakMemoryCache;", "Lcoil/memory/WeakMemoryCache;", "<init>", "()V", "cache", "Ljava/util/LinkedHashMap;", "Lcoil/memory/MemoryCache$Key;", "Ljava/util/ArrayList;", "Lcoil/memory/RealWeakMemoryCache$InternalValue;", "getCache$coil_base_release$annotations", "getCache$coil_base_release", "()Ljava/util/LinkedHashMap;", "operationsSinceCleanUp", "", "keys", "", "Lkotlin/jvm/internal/EnhancedNullability;", "getKeys", "()Ljava/util/Set;", "get", "Lcoil/memory/MemoryCache$Value;", "key", "set", "", "bitmap", "Landroid/graphics/Bitmap;", "extras", "", "", "", "size", "remove", "", "clearMemory", "trimMemory", FirebaseAnalytics.Param.LEVEL, "cleanUpIfNecessary", "cleanUp", "cleanUp$coil_base_release", "InternalValue", "Companion", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class RealWeakMemoryCache implements WeakMemoryCache {
    private static final int CLEAN_UP_INTERVAL = 10;
    private final LinkedHashMap<MemoryCache.Key, ArrayList<InternalValue>> cache = new LinkedHashMap<>();
    private int operationsSinceCleanUp;

    public static /* synthetic */ void getCache$coil_base_release$annotations() {
    }

    public final LinkedHashMap<MemoryCache.Key, ArrayList<InternalValue>> getCache$coil_base_release() {
        return this.cache;
    }

    @Override // coil.memory.WeakMemoryCache
    public synchronized Set<MemoryCache.Key> getKeys() {
        return CollectionsKt.toSet(this.cache.keySet());
    }

    @Override // coil.memory.WeakMemoryCache
    public synchronized MemoryCache.Value get(MemoryCache.Key key) {
        ArrayList<InternalValue> arrayList = this.cache.get(key);
        MemoryCache.Value value = null;
        if (arrayList == null) {
            return null;
        }
        ArrayList<InternalValue> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            InternalValue internalValue = arrayList2.get(i);
            Bitmap bitmap = internalValue.getBitmap().get();
            MemoryCache.Value value2 = bitmap != null ? new MemoryCache.Value(bitmap, internalValue.getExtras()) : null;
            if (value2 != null) {
                value = value2;
                break;
            }
            i++;
        }
        cleanUpIfNecessary();
        return value;
    }

    @Override // coil.memory.WeakMemoryCache
    public synchronized void set(MemoryCache.Key key, Bitmap bitmap, Map<String, ? extends Object> extras, int size) {
        LinkedHashMap<MemoryCache.Key, ArrayList<InternalValue>> linkedHashMap = this.cache;
        ArrayList<InternalValue> arrayList = linkedHashMap.get(key);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            linkedHashMap.put(key, arrayList);
        }
        ArrayList<InternalValue> arrayList2 = arrayList;
        RealWeakMemoryCache realWeakMemoryCache = this;
        int identityHashCode = System.identityHashCode(bitmap);
        InternalValue internalValue = new InternalValue(identityHashCode, new WeakReference(bitmap), extras, size);
        int size2 = arrayList2.size();
        int i = 0;
        while (true) {
            if (i < size2) {
                InternalValue internalValue2 = arrayList2.get(i);
                if (size < internalValue2.getSize()) {
                    i++;
                } else if (internalValue2.getIdentityHashCode() == identityHashCode && internalValue2.getBitmap().get() == bitmap) {
                    arrayList2.set(i, internalValue);
                } else {
                    arrayList2.add(i, internalValue);
                }
            } else {
                arrayList2.add(internalValue);
                break;
            }
        }
        cleanUpIfNecessary();
    }

    @Override // coil.memory.WeakMemoryCache
    public synchronized boolean remove(MemoryCache.Key key) {
        return this.cache.remove(key) != null;
    }

    @Override // coil.memory.WeakMemoryCache
    public synchronized void clearMemory() {
        this.operationsSinceCleanUp = 0;
        this.cache.clear();
    }

    @Override // coil.memory.WeakMemoryCache
    public synchronized void trimMemory(int level) {
        if (level >= 10 && level != 20) {
            cleanUp$coil_base_release();
        }
    }

    private final void cleanUpIfNecessary() {
        int i = this.operationsSinceCleanUp;
        this.operationsSinceCleanUp = i + 1;
        if (i >= 10) {
            cleanUp$coil_base_release();
        }
    }

    public final void cleanUp$coil_base_release() {
        WeakReference<Bitmap> bitmap;
        this.operationsSinceCleanUp = 0;
        Iterator<ArrayList<InternalValue>> it = this.cache.values().iterator();
        while (it.hasNext()) {
            ArrayList<InternalValue> next = it.next();
            if (next.size() <= 1) {
                InternalValue internalValue = (InternalValue) CollectionsKt.firstOrNull((List) next);
                if (((internalValue == null || (bitmap = internalValue.getBitmap()) == null) ? null : bitmap.get()) == null) {
                    it.remove();
                }
            } else {
                ArrayList<InternalValue> arrayList = next;
                int size = arrayList.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    int i3 = i2 - i;
                    if (arrayList.get(i3).getBitmap().get() == null) {
                        arrayList.remove(i3);
                        i++;
                    }
                }
                if (next.isEmpty()) {
                    it.remove();
                }
            }
        }
    }

    /* compiled from: WeakMemoryCache.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcoil/memory/RealWeakMemoryCache$InternalValue;", "", "identityHashCode", "", "bitmap", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/Bitmap;", "extras", "", "", "size", "<init>", "(ILjava/lang/ref/WeakReference;Ljava/util/Map;I)V", "getIdentityHashCode", "()I", "getBitmap", "()Ljava/lang/ref/WeakReference;", "getExtras", "()Ljava/util/Map;", "getSize", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class InternalValue {
        private final WeakReference<Bitmap> bitmap;
        private final Map<String, Object> extras;
        private final int identityHashCode;
        private final int size;

        public InternalValue(int i, WeakReference<Bitmap> weakReference, Map<String, ? extends Object> map, int i2) {
            this.identityHashCode = i;
            this.bitmap = weakReference;
            this.extras = map;
            this.size = i2;
        }

        public final int getIdentityHashCode() {
            return this.identityHashCode;
        }

        public final WeakReference<Bitmap> getBitmap() {
            return this.bitmap;
        }

        public final Map<String, Object> getExtras() {
            return this.extras;
        }

        public final int getSize() {
            return this.size;
        }
    }
}
