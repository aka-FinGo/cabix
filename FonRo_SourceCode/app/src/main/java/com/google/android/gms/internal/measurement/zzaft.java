package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes5.dex */
final class zzaft implements Iterator {
    final /* synthetic */ zzafv zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzaft(zzafv zzafvVar, byte[] bArr) {
        Objects.requireNonNull(zzafvVar);
        this.zza = zzafvVar;
        this.zzb = -1;
    }

    private final Iterator zza() {
        Iterator it = this.zzd;
        if (it != null) {
            return it;
        }
        Iterator it2 = this.zza.zzk().entrySet().iterator();
        this.zzd = it2;
        return it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb + 1;
        zzafv zzafvVar = this.zza;
        if (i >= zzafvVar.zzj()) {
            return !zzafvVar.zzk().isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        zzafv zzafvVar = this.zza;
        return i < zzafvVar.zzj() ? (zzafs) zzafvVar.zzi()[i] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzafv zzafvVar = this.zza;
        zzafvVar.zzh();
        int i = this.zzb;
        if (i < zzafvVar.zzj()) {
            this.zzb = i - 1;
            zzafvVar.zzg(i);
        } else {
            zza().remove();
        }
    }
}
