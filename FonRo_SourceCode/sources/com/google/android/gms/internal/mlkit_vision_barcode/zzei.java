package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.1 */
/* loaded from: classes5.dex */
final class zzei implements Runnable {
    final Future zza;
    final zzeh zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzei(Future future, zzeh zzehVar) {
        this.zza = future;
        this.zzb = zzehVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Throwable zza = zzey.zza((zzex) this.zza);
        if (zza == null) {
            try {
                Future future = this.zza;
                if (future.isDone()) {
                    boolean z = false;
                    while (true) {
                        try {
                            obj = future.get();
                            break;
                        } catch (InterruptedException unused) {
                            z = true;
                        } catch (Throwable th) {
                            if (z) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    }
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    this.zzb.zzb(obj);
                    return;
                }
                throw new IllegalStateException(zzba.zzb("Future was expected to be done: %s", future));
            } catch (ExecutionException e) {
                this.zzb.zza(e.getCause());
                return;
            } catch (Throwable th2) {
                this.zzb.zza(th2);
                return;
            }
        }
        this.zzb.zza(zza);
    }

    public final String toString() {
        zzav zza = zzaw.zza(this);
        zza.zza(this.zzb);
        return zza.toString();
    }
}
