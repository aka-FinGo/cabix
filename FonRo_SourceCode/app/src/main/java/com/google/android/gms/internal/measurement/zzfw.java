package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzfw extends zzadu implements zzafd {
    private static final zzfw zzg;
    private static volatile zzafj zzh;
    private int zzb;
    private int zze;
    private int zzf;

    static {
        zzfw zzfwVar = new zzfw();
        zzg = zzfwVar;
        zzadu.zzcs(zzfw.class, zzfwVar);
    }

    private zzfw() {
    }

    public final int zzb() {
        int zza = zzga.zza(this.zze);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzc() {
        int zza = zzga.zza(this.zzf);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzadz zzadzVar = zzfz.zza;
            return zzct(zzg, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzb", "zze", zzadzVar, "zzf", zzadzVar});
        }
        if (i2 == 3) {
            return new zzfw();
        }
        if (i2 == 4) {
            return new zzfv(null);
        }
        if (i2 == 5) {
            return zzg;
        }
        if (i2 == 6) {
            zzafj zzafjVar2 = zzh;
            if (zzafjVar2 != null) {
                return zzafjVar2;
            }
            synchronized (zzfw.class) {
                zzafjVar = zzh;
                if (zzafjVar == null) {
                    zzafjVar = new zzadq(zzg);
                    zzh = zzafjVar;
                }
            }
            return zzafjVar;
        }
        throw null;
    }
}
