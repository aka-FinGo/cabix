package com.google.android.gms.internal.measurement;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzabq {
    private static final String[] zza = {"com.google.common.flogger.util.StackWalkerStackGetter", "com.google.common.flogger.util.JavaLangAccessStackGetter"};
    private static final zzabu zzb;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.measurement.zzabu] */
    static {
        zzabv zzabvVar;
        int i = 0;
        while (true) {
            if (i >= 2) {
                zzabvVar = new zzabv();
                break;
            }
            zzabvVar = null;
            try {
                zzabvVar = (zzabu) Class.forName(zza[i]).asSubclass(zzabu.class).getDeclaredConstructor(null).newInstance(null);
            } catch (Throwable unused) {
            }
            if (zzabvVar != null) {
                break;
            } else {
                i++;
            }
        }
        zzb = zzabvVar;
    }

    public static StackTraceElement zza(Class cls, int i) {
        zzabr.zza(cls, TypedValues.AttributesType.S_TARGET);
        return zzb.zza(cls, 2);
    }

    public static StackTraceElement[] zzb(Class cls, int i, int i2) {
        if (i > 0 || i == -1) {
            return zzb.zzb(cls, i, 2);
        }
        throw new IllegalArgumentException("invalid maximum depth: 0");
    }
}
