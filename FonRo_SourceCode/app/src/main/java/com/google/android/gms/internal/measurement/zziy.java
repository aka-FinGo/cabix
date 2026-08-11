package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes5.dex */
public final class zziy extends zzadu implements zzafd {
    private static final zziy zzg;
    private static volatile zzafj zzh;
    private int zzb;
    private String zze = "";
    private zzaef zzf = zzcy();

    static {
        zziy zziyVar = new zziy();
        zzg = zziyVar;
        zzadu.zzcs(zziy.class, zziyVar);
    }

    private zziy() {
    }

    public final String zza() {
        return this.zze;
    }

    public final List zzb() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzafjVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzct(zzg, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzb", "zze", "zzf", zzje.class});
        }
        if (i2 == 3) {
            return new zziy();
        }
        if (i2 == 4) {
            return new zzix(null);
        }
        if (i2 == 5) {
            return zzg;
        }
        if (i2 == 6) {
            zzafj zzafjVar2 = zzh;
            if (zzafjVar2 != null) {
                return zzafjVar2;
            }
            synchronized (zziy.class) {
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
