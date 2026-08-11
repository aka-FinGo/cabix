package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.1 */
/* loaded from: classes5.dex */
public final class zzft {
    private final zzrb zza;
    private final Boolean zzc;
    private final zzvz zze;
    private final zzcs zzf;
    private final zzcs zzg;
    private final Boolean zzb = null;
    private final zzqk zzd = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzft(zzfr zzfrVar, zzfs zzfsVar) {
        this.zza = zzfr.zzi(zzfrVar);
        this.zzc = zzfr.zzk(zzfrVar);
        this.zze = zzfr.zzj(zzfrVar);
        this.zzf = zzfr.zza(zzfrVar);
        this.zzg = zzfr.zzb(zzfrVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzft)) {
            return false;
        }
        zzft zzftVar = (zzft) obj;
        if (Objects.equal(this.zza, zzftVar.zza)) {
            Boolean bool = zzftVar.zzb;
            if (Objects.equal(null, null) && Objects.equal(this.zzc, zzftVar.zzc)) {
                zzqk zzqkVar = zzftVar.zzd;
                if (Objects.equal(null, null) && Objects.equal(this.zze, zzftVar.zze) && Objects.equal(this.zzf, zzftVar.zzf) && Objects.equal(this.zzg, zzftVar.zzg)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, this.zzc, null, this.zze, this.zzf, this.zzg);
    }

    public final zzcs zza() {
        return this.zzf;
    }

    public final zzcs zzb() {
        return this.zzg;
    }

    public final zzrb zzc() {
        return this.zza;
    }

    public final zzvz zzd() {
        return this.zze;
    }

    public final Boolean zze() {
        return this.zzc;
    }
}
