package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzig extends zzadu implements zzafd {
    private static final zzig zzg;
    private static volatile zzafj zzh;
    private int zzb;
    private int zze = 1;
    private zzaef zzf = zzcy();

    static {
        zzig zzigVar = new zzig();
        zzg = zzigVar;
        zzadu.zzcs(zzig.class, zzigVar);
    }

    private zzig() {
    }

    public static zzie zza() {
        return (zzie) zzg.zzcn();
    }

    public final /* synthetic */ void zzb(zzhu zzhuVar) {
        zzhuVar.getClass();
        zzaef zzaefVar = this.zzf;
        if (!zzaefVar.zza()) {
            this.zzf = zzadu.zzcz(zzaefVar);
        }
        this.zzf.add(zzhuVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzct(zzg, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b", new Object[]{"zzb", "zze", zzif.zza, "zzf", zzhu.class});
        }
        if (i2 == 3) {
            return new zzig();
        }
        if (i2 == 4) {
            return new zzie(null);
        }
        if (i2 == 5) {
            return zzg;
        }
        if (i2 == 6) {
            zzafj zzafjVar2 = zzh;
            if (zzafjVar2 != null) {
                return zzafjVar2;
            }
            synchronized (zzig.class) {
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
