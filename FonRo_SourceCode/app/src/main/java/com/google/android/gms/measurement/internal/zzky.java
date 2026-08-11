package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzky implements Application.ActivityLifecycleCallbacks, zzkw {
    final /* synthetic */ zzlj zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzky(zzlj zzljVar) {
        Objects.requireNonNull(zzljVar);
        this.zza = zzljVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(com.google.android.gms.internal.measurement.zzdd.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzb(com.google.android.gms.internal.measurement.zzdd.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zzc(com.google.android.gms.internal.measurement.zzdd.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzd(com.google.android.gms.internal.measurement.zzdd.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zze(com.google.android.gms.internal.measurement.zzdd.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0052  */
    @Override // com.google.android.gms.measurement.internal.zzkw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.internal.measurement.zzdd r8, android.os.Bundle r9) {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.zzlj r0 = r7.zza     // Catch: java.lang.Throwable -> L7b java.lang.RuntimeException -> L7e
            com.google.android.gms.measurement.internal.zzic r1 = r0.zzu     // Catch: java.lang.Throwable -> L7b java.lang.RuntimeException -> L7e
            com.google.android.gms.measurement.internal.zzgu r2 = r1.zzaW()     // Catch: java.lang.Throwable -> L7b java.lang.RuntimeException -> L7e
            com.google.android.gms.measurement.internal.zzgs r2 = r2.zzk()     // Catch: java.lang.Throwable -> L7b java.lang.RuntimeException -> L7e
            java.lang.String r3 = "onActivityCreated"
            r2.zza(r3)     // Catch: java.lang.Throwable -> L7b java.lang.RuntimeException -> L7e
            android.content.Intent r2 = r8.zzc     // Catch: java.lang.Throwable -> L7b java.lang.RuntimeException -> L7e
            if (r2 == 0) goto L71
            android.net.Uri r3 = r2.getData()     // Catch: java.lang.Throwable -> L7b java.lang.RuntimeException -> L7e
            if (r3 == 0) goto L24
            boolean r4 = r3.isHierarchical()     // Catch: java.lang.Throwable -> L7b java.lang.RuntimeException -> L7e
            if (r4 != 0) goto L22
            goto L24
        L22:
            r4 = r3
            goto L3c
        L24:
            android.os.Bundle r3 = r2.getExtras()     // Catch: java.lang.Throwable -> L7b java.lang.RuntimeException -> L7e
            r4 = 0
            if (r3 == 0) goto L3c
            java.lang.String r5 = "com.android.vending.referral_url"
            java.lang.String r3 = r3.getString(r5)     // Catch: java.lang.Throwable -> L7b java.lang.RuntimeException -> L7e
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L7b java.lang.RuntimeException -> L7e
            if (r5 != 0) goto L3c
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch: java.lang.Throwable -> L7b java.lang.RuntimeException -> L7e
            goto L22
        L3c:
            if (r4 == 0) goto L71
            boolean r3 = r4.isHierarchical()     // Catch: java.lang.Throwable -> L7b java.lang.RuntimeException -> L7e
            if (r3 != 0) goto L45
            goto L71
        L45:
            com.google.android.gms.measurement.internal.zzpp r0 = r1.zzk()     // Catch: java.lang.Throwable -> L7b java.lang.RuntimeException -> L7e
            boolean r0 = r0.zzj(r2)     // Catch: java.lang.Throwable -> L7b java.lang.RuntimeException -> L7e
            if (r0 == 0) goto L52
            java.lang.String r0 = "gs"
            goto L54
        L52:
            java.lang.String r0 = "auto"
        L54:
            r5 = r0
            java.lang.String r0 = "referrer"
            java.lang.String r6 = r4.getQueryParameter(r0)     // Catch: java.lang.Throwable -> L7b java.lang.RuntimeException -> L7e
            if (r9 != 0) goto L5f
            r0 = 1
            goto L60
        L5f:
            r0 = 0
        L60:
            r3 = r0
            com.google.android.gms.measurement.internal.zzhz r0 = r1.zzaX()     // Catch: java.lang.Throwable -> L7b java.lang.RuntimeException -> L7e
            com.google.android.gms.measurement.internal.zzkx r1 = new com.google.android.gms.measurement.internal.zzkx     // Catch: java.lang.Throwable -> L7b java.lang.RuntimeException -> L7e
            r2 = r7
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.RuntimeException -> L6f java.lang.Throwable -> L96
            r0.zzj(r1)     // Catch: java.lang.RuntimeException -> L6f java.lang.Throwable -> L96
            goto L91
        L6f:
            r0 = move-exception
            goto L80
        L71:
            com.google.android.gms.measurement.internal.zzic r7 = r0.zzu
        L73:
            com.google.android.gms.measurement.internal.zzmb r7 = r7.zzs()
            r7.zzn(r8, r9)
            return
        L7b:
            r0 = move-exception
            r2 = r7
            goto L97
        L7e:
            r0 = move-exception
            r2 = r7
        L80:
            com.google.android.gms.measurement.internal.zzlj r7 = r2.zza     // Catch: java.lang.Throwable -> L96
            com.google.android.gms.measurement.internal.zzic r7 = r7.zzu     // Catch: java.lang.Throwable -> L96
            com.google.android.gms.measurement.internal.zzgu r7 = r7.zzaW()     // Catch: java.lang.Throwable -> L96
            com.google.android.gms.measurement.internal.zzgs r7 = r7.zzb()     // Catch: java.lang.Throwable -> L96
            java.lang.String r1 = "Throwable caught in onActivityCreated"
            r7.zzb(r1, r0)     // Catch: java.lang.Throwable -> L96
        L91:
            com.google.android.gms.measurement.internal.zzlj r7 = r2.zza
            com.google.android.gms.measurement.internal.zzic r7 = r7.zzu
            goto L73
        L96:
            r0 = move-exception
        L97:
            com.google.android.gms.measurement.internal.zzlj r7 = r2.zza
            com.google.android.gms.measurement.internal.zzic r7 = r7.zzu
            com.google.android.gms.measurement.internal.zzmb r7 = r7.zzs()
            r7.zzn(r8, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzky.zza(com.google.android.gms.internal.measurement.zzdd, android.os.Bundle):void");
    }

    @Override // com.google.android.gms.measurement.internal.zzkw
    public final void zzb(com.google.android.gms.internal.measurement.zzdd zzddVar) {
        this.zza.zzu.zzs().zzt(zzddVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzkw
    public final void zzc(com.google.android.gms.internal.measurement.zzdd zzddVar) {
        zzic zzicVar = this.zza.zzu;
        zzicVar.zzs().zzq(zzddVar);
        zzoc zzh = zzicVar.zzh();
        zzic zzicVar2 = zzh.zzu;
        zzicVar2.zzaX().zzj(new zznv(zzh, zzicVar2.zzba().elapsedRealtime()));
    }

    @Override // com.google.android.gms.measurement.internal.zzkw
    public final void zzd(com.google.android.gms.internal.measurement.zzdd zzddVar) {
        zzic zzicVar = this.zza.zzu;
        zzoc zzh = zzicVar.zzh();
        zzic zzicVar2 = zzh.zzu;
        zzicVar2.zzaX().zzj(new zznu(zzh, zzicVar2.zzba().elapsedRealtime()));
        zzicVar.zzs().zzp(zzddVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzkw
    public final void zze(com.google.android.gms.internal.measurement.zzdd zzddVar, Bundle bundle) {
        this.zza.zzu.zzs().zzs(zzddVar, bundle);
    }
}
