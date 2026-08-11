package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@17.3.0 */
/* loaded from: classes5.dex */
public final class zzmw {
    private static zzmw zza;

    private zzmw() {
    }

    public static synchronized zzmw zza() {
        zzmw zzmwVar;
        synchronized (zzmw.class) {
            zzmwVar = zza;
            if (zzmwVar == null) {
                zzmwVar = new zzmw();
                zza = zzmwVar;
            }
        }
        return zzmwVar;
    }

    public static final boolean zzb() {
        return zzmv.zza("mlkit-dev-profiling");
    }
}
