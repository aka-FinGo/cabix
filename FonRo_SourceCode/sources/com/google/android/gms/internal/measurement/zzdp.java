package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzdp extends zzeo {
    final /* synthetic */ Context zza;
    final /* synthetic */ Bundle zzb;
    final /* synthetic */ zzez zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdp(zzez zzezVar, Context context, Bundle bundle) {
        super(zzezVar, true);
        this.zza = context;
        this.zzb = bundle;
        Objects.requireNonNull(zzezVar);
        this.zzc = zzezVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0048 A[Catch: Exception -> 0x00b7, TryCatch #0 {Exception -> 0x00b7, blocks: (B:3:0x0006, B:5:0x0025, B:6:0x0029, B:8:0x0031, B:12:0x003b, B:14:0x0048, B:17:0x0052, B:22:0x006c, B:24:0x0086, B:26:0x00a1), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052 A[Catch: Exception -> 0x00b7, TryCatch #0 {Exception -> 0x00b7, blocks: (B:3:0x0006, B:5:0x0025, B:6:0x0029, B:8:0x0031, B:12:0x003b, B:14:0x0048, B:17:0x0052, B:22:0x006c, B:24:0x0086, B:26:0x00a1), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0086 A[Catch: Exception -> 0x00b7, TryCatch #0 {Exception -> 0x00b7, blocks: (B:3:0x0006, B:5:0x0025, B:6:0x0029, B:8:0x0031, B:12:0x003b, B:14:0x0048, B:17:0x0052, B:22:0x006c, B:24:0x0086, B:26:0x00a1), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1 A[Catch: Exception -> 0x00b7, TRY_LEAVE, TryCatch #0 {Exception -> 0x00b7, blocks: (B:3:0x0006, B:5:0x0025, B:6:0x0029, B:8:0x0031, B:12:0x003b, B:14:0x0048, B:17:0x0052, B:22:0x006c, B:24:0x0086, B:26:0x00a1), top: B:2:0x0006 }] */
    @Override // com.google.android.gms.internal.measurement.zzeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza() {
        /*
            r22 = this;
            r1 = r22
            java.lang.String r0 = "com.google.android.gms.measurement.dynamite"
            r2 = 0
            r3 = 1
            android.content.Context r4 = r1.zza     // Catch: java.lang.Exception -> Lb7
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch: java.lang.Exception -> Lb7
            com.google.firebase.analytics.zzg r5 = com.google.firebase.analytics.zzg.zza()     // Catch: java.lang.Exception -> Lb7
            r5.zzb()     // Catch: java.lang.Exception -> Lb7
            java.lang.String r5 = com.google.android.gms.measurement.internal.zzhu.zza(r4)     // Catch: java.lang.Exception -> Lb7
            java.lang.String r6 = "google_analytics_force_disable_updates"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch: java.lang.Exception -> Lb7
            android.content.res.Resources r7 = r4.getResources()     // Catch: java.lang.Exception -> Lb7
            boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> Lb7
            if (r8 == 0) goto L29
            java.lang.String r5 = com.google.android.gms.measurement.internal.zzhu.zza(r4)     // Catch: java.lang.Exception -> Lb7
        L29:
            java.lang.Boolean r5 = com.google.android.gms.measurement.internal.zzhu.zzc(r6, r7, r5)     // Catch: java.lang.Exception -> Lb7
            com.google.android.gms.internal.measurement.zzez r6 = r1.zzc     // Catch: java.lang.Exception -> Lb7
            if (r5 == 0) goto L3a
            boolean r7 = r5.booleanValue()     // Catch: java.lang.Exception -> Lb7
            if (r7 != 0) goto L38
            goto L3a
        L38:
            r7 = r2
            goto L3b
        L3a:
            r7 = r3
        L3b:
            com.google.android.gms.internal.measurement.zzcp r7 = r6.zzc(r4, r7)     // Catch: java.lang.Exception -> Lb7
            r6.zzT(r7)     // Catch: java.lang.Exception -> Lb7
            com.google.android.gms.internal.measurement.zzcp r7 = r6.zzS()     // Catch: java.lang.Exception -> Lb7
            if (r7 != 0) goto L52
            java.lang.String r0 = r6.zzQ()     // Catch: java.lang.Exception -> Lb7
            java.lang.String r4 = "Failed to connect to measurement client."
            android.util.Log.w(r0, r4)     // Catch: java.lang.Exception -> Lb7
            return
        L52:
            int r7 = com.google.android.gms.dynamite.DynamiteModule.getLocalVersion(r4, r0)     // Catch: java.lang.Exception -> Lb7
            int r0 = com.google.android.gms.dynamite.DynamiteModule.getRemoteVersion(r4, r0)     // Catch: java.lang.Exception -> Lb7
            int r8 = java.lang.Math.max(r7, r0)     // Catch: java.lang.Exception -> Lb7
            java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> Lb7
            boolean r5 = r9.equals(r5)     // Catch: java.lang.Exception -> Lb7
            if (r5 != 0) goto L6b
            if (r0 >= r7) goto L69
            goto L6b
        L69:
            r14 = r2
            goto L6c
        L6b:
            r14 = r3
        L6c:
            long r12 = (long) r8     // Catch: java.lang.Exception -> Lb7
            r6.zzU(r12)     // Catch: java.lang.Exception -> Lb7
            com.google.android.gms.internal.measurement.zzdb r17 = new com.google.android.gms.internal.measurement.zzdb     // Catch: java.lang.Exception -> Lb7
            android.os.Bundle r15 = r1.zzb     // Catch: java.lang.Exception -> Lb7
            java.lang.String r16 = com.google.android.gms.measurement.internal.zzhu.zza(r4)     // Catch: java.lang.Exception -> Lb7
            r10 = 161000(0x274e8, double:7.95446E-319)
            r9 = r17
            r9.<init>(r10, r12, r14, r15, r16)     // Catch: java.lang.Exception -> Lb7
            boolean r0 = r6.zzO()     // Catch: java.lang.Exception -> Lb7
            if (r0 == 0) goto La1
            com.google.android.gms.internal.measurement.zzcp r0 = r6.zzS()     // Catch: java.lang.Exception -> Lb7
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch: java.lang.Exception -> Lb7
            r15 = r0
            com.google.android.gms.internal.measurement.zzcp r15 = (com.google.android.gms.internal.measurement.zzcp) r15     // Catch: java.lang.Exception -> Lb7
            com.google.android.gms.dynamic.IObjectWrapper r16 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r4)     // Catch: java.lang.Exception -> Lb7
            long r4 = r1.zzi     // Catch: java.lang.Exception -> Lb7
            long r6 = r1.zzj     // Catch: java.lang.Exception -> Lb7
            r18 = r4
            r20 = r6
            r15.initializeWithElapsedTime(r16, r17, r18, r20)     // Catch: java.lang.Exception -> Lb7
            return
        La1:
            r9 = r17
            com.google.android.gms.internal.measurement.zzcp r0 = r6.zzS()     // Catch: java.lang.Exception -> Lb7
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch: java.lang.Exception -> Lb7
            com.google.android.gms.internal.measurement.zzcp r0 = (com.google.android.gms.internal.measurement.zzcp) r0     // Catch: java.lang.Exception -> Lb7
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r4)     // Catch: java.lang.Exception -> Lb7
            long r5 = r1.zzi     // Catch: java.lang.Exception -> Lb7
            r0.initialize(r4, r9, r5)     // Catch: java.lang.Exception -> Lb7
            return
        Lb7:
            r0 = move-exception
            com.google.android.gms.internal.measurement.zzez r1 = r1.zzc
            r1.zzN(r0, r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzdp.zza():void");
    }
}
