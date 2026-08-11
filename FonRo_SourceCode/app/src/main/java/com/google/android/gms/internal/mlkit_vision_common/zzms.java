package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@17.3.0 */
/* loaded from: classes5.dex */
public final class zzms {
    private static zzmr zza;

    public static synchronized zzmj zza(zzme zzmeVar) {
        zzmj zzmjVar;
        synchronized (zzms.class) {
            zzmr zzmrVar = zza;
            if (zzmrVar == null) {
                zzmrVar = new zzmr(null);
                zza = zzmrVar;
            }
            zzmjVar = (zzmj) zzmrVar.get(zzmeVar);
        }
        return zzmjVar;
    }

    public static synchronized zzmj zzb(String str) {
        zzmj zza2;
        synchronized (zzms.class) {
            zza2 = zza(zzme.zzd("vision-common").zzd());
        }
        return zza2;
    }
}
