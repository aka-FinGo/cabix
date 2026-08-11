package com.google.android.gms.internal.measurement;

import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzaas extends zzaag {
    public static final /* synthetic */ int zza = 0;
    private static final Set zzb;
    private static final zzzq zzc;
    private static final zzaaq zzd;
    private final String zze;
    private final Level zzf;
    private final Set zzg;
    private final zzzq zzh;
    private final int zzi;

    static {
        Set unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(zzxx.zza, zzyw.zza, zzyx.zza)));
        zzb = unmodifiableSet;
        zzc = zzzt.zza(unmodifiableSet).zzc();
        zzd = new zzaaq(null);
    }

    public /* synthetic */ zzaas(String str, String str2, boolean z, int i, Level level, Set set, zzzq zzzqVar, byte[] bArr) {
        super(str2);
        this.zze = zzaal.zza("", str2, true);
        this.zzi = 2;
        this.zzf = level;
        this.zzg = set;
        this.zzh = zzzqVar;
    }

    public static zzaaq zze() {
        return zzd;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void zzi(com.google.android.gms.internal.measurement.zzzd r3, java.lang.String r4, int r5, java.util.logging.Level r6, java.util.Set r7, com.google.android.gms.internal.measurement.zzzq r8) {
        /*
            com.google.android.gms.internal.measurement.zzzj r5 = r3.zzl()
            com.google.android.gms.internal.measurement.zzyl r0 = com.google.android.gms.internal.measurement.zzyx.zza
            java.lang.Object r5 = r5.zzd(r0)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            if (r5 == 0) goto L15
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L15
            return
        L15:
            com.google.android.gms.internal.measurement.zzzj r5 = com.google.android.gms.internal.measurement.zzaad.zzj()
            com.google.android.gms.internal.measurement.zzzj r0 = r3.zzl()
            com.google.android.gms.internal.measurement.zzaaa r5 = com.google.android.gms.internal.measurement.zzaaa.zzh(r5, r0)
            java.util.logging.Level r0 = r3.zze()
            int r0 = r0.intValue()
            int r6 = r6.intValue()
            if (r0 >= r6) goto L31
            r6 = 1
            goto L32
        L31:
            r6 = 0
        L32:
            r0 = 2
            if (r6 != 0) goto L5b
            int r1 = com.google.android.gms.internal.measurement.zzaae.zza
            com.google.android.gms.internal.measurement.zzaaf r1 = r3.zzh()
            if (r1 != 0) goto L5b
            int r1 = r5.zzb()
            int r2 = r7.size()
            if (r1 > r2) goto L5b
            java.util.Set r1 = r5.zzc()
            boolean r7 = r7.containsAll(r1)
            if (r7 != 0) goto L52
            goto L5b
        L52:
            java.lang.Object r5 = r3.zzj()
            java.lang.String r5 = com.google.android.gms.internal.measurement.zzzh.zza(r5)
            goto La0
        L5b:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            com.google.android.gms.internal.measurement.zzyc r1 = r3.zzg()
            boolean r1 = com.google.android.gms.internal.measurement.zzze.zza(r0, r1, r7)
            if (r1 == 0) goto L6f
            java.lang.String r1 = " "
            r7.append(r1)
        L6f:
            if (r6 == 0) goto L88
            com.google.android.gms.internal.measurement.zzaaf r6 = r3.zzh()
            if (r6 == 0) goto L88
            java.lang.String r5 = "(REDACTED) "
            r7.append(r5)
            com.google.android.gms.internal.measurement.zzaaf r5 = r3.zzh()
            java.lang.String r5 = r5.zzb()
            r7.append(r5)
            goto L9c
        L88:
            com.google.android.gms.internal.measurement.zzyy.zza(r3, r7)
            int r6 = com.google.android.gms.internal.measurement.zzaae.zza
            com.google.android.gms.internal.measurement.zzzc r6 = new com.google.android.gms.internal.measurement.zzzc
            java.lang.String r1 = "[CONTEXT "
            java.lang.String r2 = " ]"
            r6.<init>(r1, r2, r7)
            r5.zza(r8, r6)
            r6.zzb()
        L9c:
            java.lang.String r5 = r7.toString()
        La0:
            com.google.android.gms.internal.measurement.zzzj r6 = r3.zzl()
            com.google.android.gms.internal.measurement.zzyl r7 = com.google.android.gms.internal.measurement.zzxx.zza
            java.lang.Object r6 = r6.zzd(r7)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            java.util.logging.Level r3 = r3.zze()
            int r3 = com.google.android.gms.internal.measurement.zzaal.zzb(r3)
            if (r3 == r0) goto Lcf
            r7 = 3
            if (r3 == r7) goto Lcb
            r7 = 4
            if (r3 == r7) goto Lc7
            r7 = 5
            if (r3 == r7) goto Lc3
            android.util.Log.e(r4, r5, r6)
            return
        Lc3:
            android.util.Log.w(r4, r5, r6)
            return
        Lc7:
            android.util.Log.i(r4, r5, r6)
            return
        Lcb:
            android.util.Log.d(r4, r5, r6)
            return
        Lcf:
            android.util.Log.v(r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaas.zzi(com.google.android.gms.internal.measurement.zzzd, java.lang.String, int, java.util.logging.Level, java.util.Set, com.google.android.gms.internal.measurement.zzzq):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzzf
    public final boolean zzb(Level level) {
        String str = this.zze;
        int zzb2 = zzaal.zzb(level);
        return Log.isLoggable(str, zzb2) || Log.isLoggable("all", zzb2);
    }

    @Override // com.google.android.gms.internal.measurement.zzzf
    public final void zzc(zzzd zzzdVar) {
        zzi(zzzdVar, this.zze, 2, this.zzf, this.zzg, this.zzh);
    }
}
