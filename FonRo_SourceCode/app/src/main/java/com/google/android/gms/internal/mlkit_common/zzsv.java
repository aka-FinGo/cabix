package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.11.0 */
/* loaded from: classes5.dex */
public final class zzsv {
    private static zzsv zza;

    private zzsv() {
    }

    public static synchronized zzsv zza() {
        zzsv zzsvVar;
        synchronized (zzsv.class) {
            zzsvVar = zza;
            if (zzsvVar == null) {
                zzsvVar = new zzsv();
                zza = zzsvVar;
            }
        }
        return zzsvVar;
    }

    public static void zzb() {
        zzsu.zza();
    }
}
