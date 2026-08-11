package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.1 */
/* loaded from: classes5.dex */
public final class zzxb {
    private static zzxb zza;

    private zzxb() {
    }

    public static synchronized zzxb zza() {
        zzxb zzxbVar;
        synchronized (zzxb.class) {
            zzxbVar = zza;
            if (zzxbVar == null) {
                zzxbVar = new zzxb();
                zza = zzxbVar;
            }
        }
        return zzxbVar;
    }
}
