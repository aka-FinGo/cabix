package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzho extends zzadu implements zzafd {
    private static final zzho zze;
    private static volatile zzafj zzf;
    private zzaef zzb = zzcy();

    static {
        zzho zzhoVar = new zzho();
        zze = zzhoVar;
        zzadu.zzcs(zzho.class, zzhoVar);
    }

    private zzho() {
    }

    public static zzhh zzb() {
        return (zzhh) zze.zzcn();
    }

    public static zzho zzc() {
        return zze;
    }

    public final List zza() {
        return this.zzb;
    }

    public final /* synthetic */ void zzd(Iterable iterable) {
        zzaef zzaefVar = this.zzb;
        if (!zzaefVar.zza()) {
            this.zzb = zzadu.zzcz(zzaefVar);
        }
        zzacb.zzcg(iterable, this.zzb);
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzct(zze, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zzhl.class});
        }
        if (i2 == 3) {
            return new zzho();
        }
        if (i2 == 4) {
            return new zzhh(null);
        }
        if (i2 == 5) {
            return zze;
        }
        if (i2 == 6) {
            zzafj zzafjVar2 = zzf;
            if (zzafjVar2 != null) {
                return zzafjVar2;
            }
            synchronized (zzho.class) {
                zzafjVar = zzf;
                if (zzafjVar == null) {
                    zzafjVar = new zzadq(zze);
                    zzf = zzafjVar;
                }
            }
            return zzafjVar;
        }
        throw null;
    }
}
