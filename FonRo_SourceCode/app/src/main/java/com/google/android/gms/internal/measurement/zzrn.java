package com.google.android.gms.internal.measurement;

import android.os.Handler;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzrn {
    private static final Object zza = new Object();
    private static Thread zzb;
    private static volatile Handler zzc;

    public static boolean zza(Thread thread) {
        Thread thread2 = zzb;
        if (thread2 == null) {
            thread2 = Looper.getMainLooper().getThread();
            zzb = thread2;
        }
        return thread == thread2;
    }

    public static Handler zzb() {
        if (zzc == null) {
            synchronized (zza) {
                if (zzc == null) {
                    zzc = new Handler(Looper.getMainLooper());
                }
            }
        }
        return zzc;
    }
}
