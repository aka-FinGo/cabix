package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.time.DurationKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zznl extends zzg {
    private final zznf zza;
    private zzgb zzb;
    private volatile Boolean zzc;
    private final zzaz zzd;
    private ScheduledExecutorService zze;
    private final zzog zzf;
    private final List zzg;
    private final zzaz zzh;

    /* JADX INFO: Access modifiers changed from: protected */
    public zznl(zzic zzicVar) {
        super(zzicVar);
        this.zzg = new ArrayList();
        this.zzf = new zzog(zzicVar.zzba());
        this.zza = new zznf(this);
        this.zzd = new zzmm(this, zzicVar);
        this.zzh = new zzmq(this, zzicVar);
    }

    private final boolean zzad() {
        this.zzu.zzaV();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzae, reason: merged with bridge method [inline-methods] */
    public final void zzV() {
        zzg();
        this.zzf.zza();
        this.zzu.zzc();
        this.zzd.zzb(((Long) zzfy.zzY.zzb(null)).longValue());
    }

    private final void zzaf(Runnable runnable) throws IllegalStateException {
        zzg();
        if (zzh()) {
            runnable.run();
            return;
        }
        List list = this.zzg;
        long size = list.size();
        zzic zzicVar = this.zzu;
        zzicVar.zzc();
        if (size >= 1000) {
            zzicVar.zzaW().zzb().zza("Discarding data. Max runnable queue size reached");
            return;
        }
        list.add(runnable);
        this.zzh.zzb(DurationKt.MILLIS_IN_MINUTE);
        zzI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzag, reason: merged with bridge method [inline-methods] */
    public final void zzX() {
        zzg();
        zzgs zzk = this.zzu.zzaW().zzk();
        List list = this.zzg;
        zzk.zzb("Processing queued up service tasks", Integer.valueOf(list.size()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e) {
                this.zzu.zzaW().zzb().zzb("Task exception while flushing queue", e);
            }
        }
        this.zzg.clear();
        this.zzh.zzd();
    }

    private final zzr zzah(boolean z) {
        Pair zzb;
        zzic zzicVar = this.zzu;
        zzicVar.zzaV();
        zzgi zzv = this.zzu.zzv();
        String str = null;
        if (z) {
            zzic zzicVar2 = zzicVar.zzaW().zzu;
            if (zzicVar2.zzd().zzb != null && (zzb = zzicVar2.zzd().zzb.zzb()) != null && zzb != zzhh.zza) {
                String valueOf = String.valueOf(zzb.second);
                String str2 = (String) zzb.first;
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str2).length());
                sb.append(valueOf);
                sb.append(":");
                sb.append(str2);
                str = sb.toString();
            }
        }
        return zzv.zzh(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzA(zzpl zzplVar) {
        zzg();
        zzb();
        zzad();
        zzaf(new zzmg(this, zzah(true), this.zzu.zzm().zzj(zzplVar), zzplVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzB() {
        zzg();
        zzb();
        zzr zzah = zzah(false);
        zzad();
        this.zzu.zzm().zzh();
        zzaf(new zzmh(this, zzah));
    }

    public final void zzC(AtomicReference atomicReference) {
        zzg();
        zzb();
        zzaf(new zzmi(this, atomicReference, zzah(false)));
    }

    public final void zzD(com.google.android.gms.internal.measurement.zzcs zzcsVar) {
        zzg();
        zzb();
        zzaf(new zzmj(this, zzah(false), zzcsVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzE() {
        zzg();
        zzb();
        zzr zzah = zzah(true);
        zzad();
        this.zzu.zzc().zzp(null, zzfy.zzaW);
        this.zzu.zzm().zzn();
        zzaf(new zzmk(this, zzah, true));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzF() {
        zzg();
        zzb();
        zzaf(new zzml(this, zzah(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzG(zzlu zzluVar) {
        zzg();
        zzb();
        zzaf(new zzmn(this, zzluVar));
    }

    public final void zzH(Bundle bundle) {
        zzg();
        zzb();
        zzbf zzbfVar = new zzbf(bundle);
        zzad();
        zzaf(new zzmo(this, true, zzah(false), this.zzu.zzc().zzp(null, zzfy.zzaW) && this.zzu.zzm().zzl(zzbfVar), zzbfVar, bundle));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzI() {
        zzg();
        zzb();
        if (zzh()) {
            return;
        }
        if (!zzK()) {
            zzic zzicVar = this.zzu;
            if (zzicVar.zzc().zzE()) {
                return;
            }
            zzicVar.zzaV();
            List<ResolveInfo> queryIntentServices = zzicVar.zzaZ().getPackageManager().queryIntentServices(new Intent().setClassName(zzicVar.zzaZ(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
            if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                zzicVar.zzaW().zzb().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
                return;
            }
            Intent intent = new Intent("com.google.android.gms.measurement.START");
            Context zzaZ = zzicVar.zzaZ();
            zzicVar.zzaV();
            intent.setComponent(new ComponentName(zzaZ, "com.google.android.gms.measurement.AppMeasurementService"));
            this.zza.zza(intent);
            return;
        }
        this.zza.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean zzJ() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzK() {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznl.zzK():boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzL(zzgb zzgbVar) {
        zzg();
        Preconditions.checkNotNull(zzgbVar);
        this.zzb = zzgbVar;
        zzV();
        zzX();
    }

    public final void zzM() {
        zzg();
        zzb();
        zznf zznfVar = this.zza;
        zznfVar.zzb();
        try {
            ConnectionTracker.getInstance().unbindService(this.zzu.zzaZ(), zznfVar);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    public final void zzN(com.google.android.gms.internal.measurement.zzcs zzcsVar, zzbh zzbhVar, String str) {
        zzg();
        zzb();
        zzic zzicVar = this.zzu;
        if (zzicVar.zzk().zzal(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            zzicVar.zzaW().zze().zza("Not bundling data. Service unavailable or out of date");
            zzicVar.zzk().zzar(zzcsVar, new byte[0]);
        } else {
            zzaf(new zzmp(this, zzbhVar, str, zzcsVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzO() {
        zzg();
        zzb();
        return !zzK() || this.zzu.zzk().zzak() >= ((Integer) zzfy.zzaJ.zzb(null)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzP() {
        zzg();
        zzb();
        return !zzK() || this.zzu.zzk().zzak() >= 241200;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzQ() {
        zzgb zzgbVar = this.zzb;
        if (zzgbVar == null) {
            this.zzu.zzaW().zzb().zza("Failed to send storage consent settings to service");
            return;
        }
        try {
            zzr zzah = zzah(false);
            Preconditions.checkNotNull(zzah);
            zzgbVar.zzy(zzah);
            zzV();
        } catch (RemoteException e) {
            this.zzu.zzaW().zzb().zzb("Failed to send storage consent settings to the service", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzR() {
        zzgb zzgbVar = this.zzb;
        if (zzgbVar == null) {
            this.zzu.zzaW().zzb().zza("Failed to send Dma consent settings to service");
            return;
        }
        try {
            zzr zzah = zzah(false);
            Preconditions.checkNotNull(zzah);
            zzgbVar.zzz(zzah);
            zzV();
        } catch (RemoteException e) {
            this.zzu.zzaW().zzb().zzb("Failed to send Dma consent settings to the service", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzS(AtomicReference atomicReference, zzr zzrVar, Bundle bundle) {
        zzgb zzgbVar;
        synchronized (atomicReference) {
            try {
                zzgbVar = this.zzb;
            } catch (RemoteException e) {
                this.zzu.zzaW().zzb().zzb("Failed to request trigger URIs; remote exception", e);
                atomicReference.notifyAll();
            }
            if (zzgbVar == null) {
                this.zzu.zzaW().zzb().zza("Failed to request trigger URIs; not connected to service");
                return;
            }
            Preconditions.checkNotNull(zzrVar);
            zzgbVar.zzD(zzrVar, bundle, new zzme(this, atomicReference));
            zzV();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzT(AtomicReference atomicReference, zzr zzrVar, zzoo zzooVar) {
        zzgb zzgbVar;
        synchronized (atomicReference) {
            try {
                zzgbVar = this.zzb;
            } catch (RemoteException e) {
                this.zzu.zzaW().zzb().zzb("[sgtm] Failed to get upload batches; remote exception", e);
                atomicReference.notifyAll();
            }
            if (zzgbVar == null) {
                this.zzu.zzaW().zzb().zza("[sgtm] Failed to get upload batches; not connected to service");
                return;
            }
            Preconditions.checkNotNull(zzrVar);
            zzgbVar.zzB(zzrVar, zzooVar, new zzmf(this, atomicReference));
            zzV();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzU(zzr zzrVar, zzaf zzafVar) {
        zzgb zzgbVar = this.zzb;
        if (zzgbVar == null) {
            this.zzu.zzaW().zzb().zza("[sgtm] Discarding data. Failed to update batch upload status.");
            return;
        }
        try {
            zzgbVar.zzC(zzrVar, zzafVar);
            zzV();
        } catch (RemoteException e) {
            this.zzu.zzaW().zzb().zzc("[sgtm] Failed to update batch upload status, rowId, exception", Long.valueOf(zzafVar.zza), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzW(ComponentName componentName) {
        zzg();
        if (this.zzb != null) {
            this.zzb = null;
            this.zzu.zzaW().zzk().zzb("Disconnected from device MeasurementService", componentName);
            zzg();
            zzI();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zznf zzY() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzgb zzZ() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaa(zzgb zzgbVar) {
        this.zzb = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ScheduledExecutorService zzab() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzac(ScheduledExecutorService scheduledExecutorService) {
        this.zze = scheduledExecutorService;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return false;
    }

    public final boolean zzh() {
        zzg();
        zzb();
        return this.zzb != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzi() {
        zzg();
        zzb();
        zzaf(new zzmr(this, zzah(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzj(boolean z) {
        zzg();
        zzb();
        if (zzO()) {
            zzaf(new zzms(this, zzah(false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzk(boolean z) {
        zzg();
        zzb();
        zzaf(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznk
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zznl.this.zzQ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzl() {
        zzg();
        zzb();
        zzaf(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzng
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zznl.this.zzR();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0189  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzm(com.google.android.gms.measurement.internal.zzgb r60, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable r61, com.google.android.gms.measurement.internal.zzr r62) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznl.zzm(com.google.android.gms.measurement.internal.zzgb, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable, com.google.android.gms.measurement.internal.zzr):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzn(zzbh zzbhVar, String str) {
        Preconditions.checkNotNull(zzbhVar);
        zzg();
        zzb();
        zzad();
        zzaf(new zzmt(this, true, zzah(true), this.zzu.zzm().zzi(zzbhVar), zzbhVar, str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzp(zzah zzahVar) {
        Preconditions.checkNotNull(zzahVar);
        zzg();
        zzb();
        this.zzu.zzaV();
        zzaf(new zzmu(this, true, zzah(true), this.zzu.zzm().zzk(zzahVar), new zzah(zzahVar), zzahVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzq(AtomicReference atomicReference, String str, String str2, String str3) {
        zzg();
        zzb();
        zzaf(new zzmv(this, atomicReference, null, str2, str3, zzah(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzs(com.google.android.gms.internal.measurement.zzcs zzcsVar, String str, String str2) {
        zzg();
        zzb();
        zzaf(new zzmw(this, str, str2, zzah(false), zzcsVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzt(AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        zzg();
        zzb();
        zzaf(new zzmx(this, atomicReference, null, str2, str3, zzah(false), z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzu(com.google.android.gms.internal.measurement.zzcs zzcsVar, String str, String str2, boolean z) {
        zzg();
        zzb();
        zzaf(new zzmc(this, str, str2, zzah(false), z, zzcsVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzv(AtomicReference atomicReference, boolean z) {
        zzg();
        zzb();
        zzaf(new zzmd(this, atomicReference, zzah(false), z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzw(final AtomicReference atomicReference, final Bundle bundle) {
        zzg();
        zzb();
        final zzr zzah = zzah(false);
        zzaf(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznh
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zznl.this.zzS(atomicReference, zzah, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzx(final AtomicReference atomicReference, final zzoo zzooVar) {
        zzg();
        zzb();
        final zzr zzah = zzah(false);
        zzaf(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzni
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zznl.this.zzT(atomicReference, zzah, zzooVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzy(final zzaf zzafVar) {
        zzg();
        zzb();
        final zzr zzah = zzah(true);
        Preconditions.checkNotNull(zzah);
        zzaf(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznj
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zznl.this.zzU(zzah, zzafVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzao zzz() {
        zzg();
        zzb();
        zzgb zzgbVar = this.zzb;
        if (zzgbVar == null) {
            zzI();
            this.zzu.zzaW().zzj().zza("Failed to get consents; not connected to service yet.");
            return null;
        }
        zzr zzah = zzah(false);
        Preconditions.checkNotNull(zzah);
        try {
            zzao zzw = zzgbVar.zzw(zzah);
            zzV();
            return zzw;
        } catch (RemoteException e) {
            this.zzu.zzaW().zzb().zzb("Failed to get consents; remote exception", e);
            return null;
        }
    }
}
