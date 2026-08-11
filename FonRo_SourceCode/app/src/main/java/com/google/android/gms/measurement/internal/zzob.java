package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzob {
    final /* synthetic */ zzoc zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzob(zzoc zzocVar) {
        Objects.requireNonNull(zzocVar);
        this.zza = zzocVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        zzoc zzocVar = this.zza;
        zzocVar.zzg();
        zzic zzicVar = zzocVar.zzu;
        if (zzicVar.zzd().zzo(zzicVar.zzba().currentTimeMillis())) {
            zzicVar.zzd().zzg.zzb(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                zzicVar.zzaW().zzk().zza("Detected application was in foreground");
                zzc(zzicVar.zzba().currentTimeMillis(), zzicVar.zzc().zzp(null, zzfy.zzbe) ? zzicVar.zzba().elapsedRealtime() : 0L, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(long j, long j2, boolean z) {
        zzoc zzocVar = this.zza;
        zzocVar.zzg();
        zzocVar.zzj();
        zzic zzicVar = zzocVar.zzu;
        if (zzicVar.zzd().zzo(j)) {
            zzicVar.zzd().zzg.zzb(true);
            zzocVar.zzu.zzv().zzi();
        }
        zzicVar.zzd().zzk.zzb(j);
        if (zzicVar.zzd().zzg.zza()) {
            zzc(j, j2, z);
        }
    }

    final void zzc(long j, long j2, boolean z) {
        zzoc zzocVar = this.zza;
        zzocVar.zzg();
        if (zzocVar.zzu.zzB()) {
            zzic zzicVar = zzocVar.zzu;
            zzicVar.zzd().zzk.zzb(j);
            zzicVar.zzaW().zzk().zzb("Session started, time", Long.valueOf(zzicVar.zzba().elapsedRealtime()));
            long j3 = j / 1000;
            zzic zzicVar2 = zzocVar.zzu;
            Long valueOf = Long.valueOf(j3);
            zzicVar2.zzj().zzM(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sid", valueOf, j);
            zzhe zzheVar = zzicVar.zzd().zzl;
            valueOf.getClass();
            zzheVar.zzb(j3);
            zzicVar.zzd().zzg.zzb(false);
            Bundle bundle = new Bundle();
            valueOf.getClass();
            bundle.putLong("_sid", j3);
            zzicVar2.zzj().zzF(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_s", j, j2, bundle);
            String zza = zzicVar.zzd().zzq.zza();
            if (TextUtils.isEmpty(zza)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", zza);
            zzicVar2.zzj().zzF(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ssr", j, j2, bundle2);
        }
    }
}
