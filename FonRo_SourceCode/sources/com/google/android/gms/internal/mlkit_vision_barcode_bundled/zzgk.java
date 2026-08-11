package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* loaded from: classes5.dex */
final class zzgk implements Iterator {
    final /* synthetic */ zzgo zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgk(zzgo zzgoVar, zzgj zzgjVar) {
        this.zza = zzgoVar;
    }

    private final Iterator zza() {
        Map map;
        Iterator it = this.zzd;
        if (it != null) {
            return it;
        }
        map = this.zza.zzc;
        Iterator it2 = map.entrySet().iterator();
        this.zzd = it2;
        return it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        Map map;
        int i2 = this.zzb + 1;
        zzgo zzgoVar = this.zza;
        i = zzgoVar.zzb;
        if (i2 < i) {
            return true;
        }
        map = zzgoVar.zzc;
        return !map.isEmpty() && zza().hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int i;
        Object[] objArr;
        this.zzc = true;
        int i2 = this.zzb + 1;
        this.zzb = i2;
        zzgo zzgoVar = this.zza;
        i = zzgoVar.zzb;
        if (i2 >= i) {
            return (Map.Entry) zza().next();
        }
        objArr = zzgoVar.zza;
        return (zzgi) objArr[i2];
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i;
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        this.zza.zzo();
        int i2 = this.zzb;
        zzgo zzgoVar = this.zza;
        i = zzgoVar.zzb;
        if (i2 < i) {
            this.zzb = i2 - 1;
            zzgoVar.zzm(i2);
        } else {
            zza().remove();
        }
    }
}
