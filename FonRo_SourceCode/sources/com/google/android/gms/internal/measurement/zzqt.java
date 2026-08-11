package com.google.android.gms.internal.measurement;

import android.net.Uri;
import android.os.Build;
import android.os.Process;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.logging.Level;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzqt {
    private static Boolean zza;
    private final zzlk zzb;
    private final Uri zzc;
    private final String zzd;
    private final String zze = "";

    public zzqt(zzlk zzlkVar, String str, String str2, boolean z) {
        this.zzb = zzlkVar;
        this.zzd = str;
        zzrz zza2 = zzsa.zza(zzlkVar.zzc());
        zza2.zzb("phenotype");
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4);
        sb.append("/");
        sb.append(str);
        sb.append(".pb");
        zza2.zzc(sb.toString());
        this.zzc = zza2.zzd();
    }

    private static boolean zzf() {
        boolean isIsolated;
        Boolean bool = zza;
        if (bool == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                isIsolated = Process.isIsolated();
                bool = Boolean.valueOf(isIsolated);
                zza = bool;
            } else {
                try {
                    bool = (Boolean) Preconditions.checkNotNull(Process.class.getMethod("isIsolated", null).invoke(Process.class, null));
                    bool.booleanValue();
                    zza = bool;
                } catch (ReflectiveOperationException unused) {
                    bool = false;
                    zza = bool;
                }
            }
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.measurement.zzqs zza() {
        /*
            Method dump skipped, instructions count: 617
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzqt.zza():com.google.android.gms.internal.measurement.zzqs");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzb() {
        return this.zzb.zzd().zzb(false, zzabz.FILE);
    }

    public final ListenableFuture zzc(final zzqv zzqvVar) {
        return Futures.submit(new Callable() { // from class: com.google.android.gms.internal.measurement.zzqq
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                zzqt.this.zze(zzqvVar);
                return null;
            }
        }, this.zzb.zzg());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ListenableFuture zzd(String str) {
        zzlk zzlkVar = this.zzb;
        return Futures.transform(zzlkVar.zzh().zza(this.zzd, ""), zzqp.zza, zzlkVar.zzg());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void zze(zzqv zzqvVar) {
        zzse zzseVar = new zzse();
        try {
            zzru zzi = this.zzb.zzi();
            Uri uri = this.zzc;
            zzsv zzb = zzsv.zzb(zzqvVar);
            zzb.zzc(zzseVar);
            return null;
        } catch (IOException | RuntimeException e) {
            zzlz.zzb(Level.WARNING, this.zzb.zzg(), e, "Failed to update snapshot for %s flags may be stale.", this.zzd);
            return null;
        }
    }
}
