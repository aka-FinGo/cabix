package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzhz extends zzadp implements zzafd {
    private zzhz() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ zzhz(byte[] r1) {
        /*
            r0 = this;
            com.google.android.gms.internal.measurement.zzib r1 = com.google.android.gms.internal.measurement.zzib.zzq()
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhz.<init>(byte[]):void");
    }

    public final List zza() {
        return Collections.unmodifiableList(((zzib) this.zza).zza());
    }

    public final int zzb() {
        return ((zzib) this.zza).zzb();
    }

    public final zzid zzc(int i) {
        return ((zzib) this.zza).zzc(i);
    }

    public final zzhz zzd(int i, zzic zzicVar) {
        zzaY();
        ((zzib) this.zza).zzk(i, (zzid) zzicVar.zzbd());
        return this;
    }

    public final zzhz zze(zzic zzicVar) {
        zzaY();
        ((zzib) this.zza).zzl((zzid) zzicVar.zzbd());
        return this;
    }

    public final zzhz zzf(Iterable iterable) {
        zzaY();
        ((zzib) this.zza).zzm(iterable);
        return this;
    }

    public final zzhz zzg() {
        zzaY();
        ((zzib) this.zza).zzn();
        return this;
    }

    public final String zzh() {
        return ((zzib) this.zza).zze();
    }

    public final zzhz zzi(String str) {
        zzaY();
        ((zzib) this.zza).zzo(str);
        return this;
    }

    public final zzhz zzj(String str) {
        zzaY();
        ((zzib) this.zza).zzp(str);
        return this;
    }
}
