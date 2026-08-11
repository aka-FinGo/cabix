package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.1 */
/* loaded from: classes5.dex */
class zzbn implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzbo zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbn(zzbo zzboVar) {
        Iterator it;
        this.zzc = zzboVar;
        this.zzb = zzboVar.zzb;
        Collection collection = zzboVar.zzb;
        if (collection instanceof List) {
            it = ((List) collection).listIterator();
        } else {
            it = collection.iterator();
        }
        this.zza = it;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbn(zzbo zzboVar, Iterator it) {
        this.zzc = zzboVar;
        this.zzb = zzboVar.zzb;
        this.zza = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        zza();
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i;
        this.zza.remove();
        zzbr zzbrVar = this.zzc.zze;
        i = zzbrVar.zzb;
        zzbrVar.zzb = i - 1;
        this.zzc.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        this.zzc.zzb();
        if (this.zzc.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }
}
