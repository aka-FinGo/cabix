package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.DebugKt;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzic implements zzjg {
    private static volatile zzic zzc;
    private long zzA;
    private volatile Boolean zzB;
    private volatile boolean zzC;
    private int zzD;
    private int zzE;
    final long zza;
    final long zzb;
    private final Context zzd;
    private final boolean zze;
    private final zzae zzf;
    private final zzal zzg;
    private final zzhh zzh;
    private final zzgu zzi;
    private final zzhz zzj;
    private final zzoc zzk;
    private final zzpp zzl;
    private final zzgn zzm;
    private final Clock zzn;
    private final zzmb zzo;
    private final zzlj zzp;
    private final zzd zzq;
    private final zzlo zzr;
    private final String zzs;
    private zzgl zzt;
    private zznl zzu;
    private zzbb zzv;
    private zzgi zzw;
    private zzlq zzx;
    private Boolean zzz;
    private boolean zzy = false;
    private final AtomicInteger zzF = new AtomicInteger(0);

    zzic(zzjs zzjsVar) {
        long currentTimeMillis;
        long elapsedRealtime;
        Preconditions.checkNotNull(zzjsVar);
        Context context = zzjsVar.zza;
        zzae zzaeVar = new zzae(context);
        this.zzf = zzaeVar;
        zzfr.zza = zzaeVar;
        this.zzd = context;
        this.zze = zzjsVar.zze;
        this.zzB = zzjsVar.zzb;
        this.zzs = zzjsVar.zzh;
        this.zzC = true;
        com.google.android.gms.internal.measurement.zzlw.zza(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.zzn = defaultClock;
        com.google.android.gms.internal.measurement.zzkk zza = com.google.android.gms.internal.measurement.zzjx.zza(context);
        String packageName = context.getPackageName();
        String.valueOf(packageName);
        zza.zza("com.google.android.gms.measurement#".concat(String.valueOf(packageName)), 0, new String[0], null);
        com.google.android.gms.internal.measurement.zzlk.zza(context);
        Long l = zzjsVar.zzf;
        if (l != null) {
            currentTimeMillis = l.longValue();
        } else {
            currentTimeMillis = defaultClock.currentTimeMillis();
        }
        this.zza = currentTimeMillis;
        Long l2 = zzjsVar.zzg;
        if (l2 != null) {
            elapsedRealtime = l2.longValue();
        } else {
            elapsedRealtime = defaultClock.elapsedRealtime();
        }
        this.zzb = elapsedRealtime;
        this.zzg = new zzal(this);
        zzhh zzhhVar = new zzhh(this);
        zzhhVar.zzx();
        this.zzh = zzhhVar;
        zzgu zzguVar = new zzgu(this);
        zzguVar.zzx();
        this.zzi = zzguVar;
        zzpp zzppVar = new zzpp(this);
        zzppVar.zzx();
        this.zzl = zzppVar;
        this.zzm = new zzgn(new zzjr(zzjsVar, this));
        this.zzq = new zzd(this);
        zzmb zzmbVar = new zzmb(this);
        zzmbVar.zzc();
        this.zzo = zzmbVar;
        zzlj zzljVar = new zzlj(this);
        zzljVar.zzc();
        this.zzp = zzljVar;
        zzoc zzocVar = new zzoc(this);
        zzocVar.zzc();
        this.zzk = zzocVar;
        zzlo zzloVar = new zzlo(this);
        zzloVar.zzx();
        this.zzr = zzloVar;
        zzhz zzhzVar = new zzhz(this);
        zzhzVar.zzx();
        this.zzj = zzhzVar;
        com.google.android.gms.internal.measurement.zzdb zzdbVar = zzjsVar.zzd;
        boolean z = zzdbVar == null || zzdbVar.zzb == 0;
        if (!(context.getApplicationContext() instanceof Application)) {
            zzP(zzguVar);
            zzguVar.zze().zza("Application context is not an Application");
        } else {
            zzO(zzljVar);
            if (zzljVar.zzu.zzd.getApplicationContext() instanceof Application) {
                Application application = (Application) zzljVar.zzu.zzd.getApplicationContext();
                if (zzljVar.zza == null) {
                    zzljVar.zza = new zzky(zzljVar);
                }
                if (z) {
                    application.unregisterActivityLifecycleCallbacks(zzljVar.zza);
                    application.registerActivityLifecycleCallbacks(zzljVar.zza);
                    zzgu zzguVar2 = zzljVar.zzu.zzi;
                    zzP(zzguVar2);
                    zzguVar2.zzk().zza("Registered activity lifecycle callback");
                }
            }
        }
        zzhzVar.zzj(new zzia(this, zzjsVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void zzL() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void zzM(zzf zzfVar) {
        if (zzfVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void zzN(zzje zzjeVar) {
        if (zzjeVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void zzO(zzg zzgVar) {
        if (zzgVar != null) {
            if (zzgVar.zza()) {
                return;
            }
            String valueOf = String.valueOf(zzgVar.getClass());
            String.valueOf(valueOf);
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(valueOf)));
        }
        throw new IllegalStateException("Component not created");
    }

    private static final void zzP(zzjf zzjfVar) {
        if (zzjfVar != null) {
            if (zzjfVar.zzv()) {
                return;
            }
            String valueOf = String.valueOf(zzjfVar.getClass());
            String.valueOf(valueOf);
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(valueOf)));
        }
        throw new IllegalStateException("Component not created");
    }

    public static zzic zzy(Context context, com.google.android.gms.internal.measurement.zzdb zzdbVar, Long l, Long l2) {
        Bundle bundle;
        if (zzdbVar != null) {
            Bundle bundle2 = zzdbVar.zzd;
            zzdbVar = new com.google.android.gms.internal.measurement.zzdb(zzdbVar.zza, zzdbVar.zzb, zzdbVar.zzc, bundle2, null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzc == null) {
            synchronized (zzic.class) {
                if (zzc == null) {
                    zzc = new zzic(new zzjs(context, zzdbVar, l, l2));
                }
            }
        } else if (zzdbVar != null && (bundle = zzdbVar.zzd) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            Preconditions.checkNotNull(zzc);
            zzc.zzB = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzc);
        return zzc;
    }

    public final boolean zzA() {
        return this.zzB != null && this.zzB.booleanValue();
    }

    public final boolean zzB() {
        return zzC() == 0;
    }

    public final int zzC() {
        zzhz zzhzVar = this.zzj;
        zzP(zzhzVar);
        zzhzVar.zzg();
        zzal zzalVar = this.zzg;
        if (zzalVar.zzt()) {
            return 1;
        }
        zzP(zzhzVar);
        zzhzVar.zzg();
        if (!this.zzC) {
            return 8;
        }
        zzhh zzhhVar = this.zzh;
        zzN(zzhhVar);
        Boolean zzi = zzhhVar.zzi();
        if (zzi != null) {
            return zzi.booleanValue() ? 0 : 3;
        }
        zzae zzaeVar = zzalVar.zzu.zzf;
        Boolean zzr = zzalVar.zzr("firebase_analytics_collection_enabled");
        return zzr != null ? zzr.booleanValue() ? 0 : 4 : (this.zzB == null || this.zzB.booleanValue()) ? 0 : 7;
    }

    public final void zzD(boolean z) {
        zzhz zzhzVar = this.zzj;
        zzP(zzhzVar);
        zzhzVar.zzg();
        this.zzC = z;
    }

    public final boolean zzE() {
        zzhz zzhzVar = this.zzj;
        zzP(zzhzVar);
        zzhzVar.zzg();
        return this.zzC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzF() {
        this.zzD++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzG() {
        this.zzF.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzH() {
        if (this.zzy) {
            zzhz zzhzVar = this.zzj;
            zzP(zzhzVar);
            zzhzVar.zzg();
            Boolean bool = this.zzz;
            if (bool == null || this.zzA == 0 || (!bool.booleanValue() && Math.abs(this.zzn.elapsedRealtime() - this.zzA) > 1000)) {
                this.zzA = this.zzn.elapsedRealtime();
                zzpp zzppVar = this.zzl;
                zzN(zzppVar);
                boolean z = false;
                if (zzppVar.zzab("android.permission.INTERNET")) {
                    zzN(zzppVar);
                    if (zzppVar.zzab("android.permission.ACCESS_NETWORK_STATE")) {
                        Context context = this.zzd;
                        if (Wrappers.packageManager(context).isCallerInstantApp() || this.zzg.zzE() || (zzpp.zzax(context) && zzpp.zzS(context, false))) {
                            z = true;
                        }
                    }
                }
                Boolean valueOf = Boolean.valueOf(z);
                this.zzz = valueOf;
                if (valueOf.booleanValue()) {
                    zzN(zzppVar);
                    this.zzz = Boolean.valueOf(zzppVar.zzC(zzv().zzk()));
                }
            }
            return this.zzz.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0087, code lost:
    
        if (r3.zzak() >= 234200) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzI() {
        /*
            Method dump skipped, instructions count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzic.zzI():boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzJ(String str, int i, Throwable th, byte[] bArr, Map map) {
        int i2;
        BroadcastOptions makeBasic;
        BroadcastOptions shareIdentityEnabled;
        Bundle bundle;
        if (i == 200 || i == 204) {
            i2 = i;
        } else {
            i2 = 304;
            if (i != 304) {
                i2 = i;
                zzgu zzguVar = this.zzi;
                zzP(zzguVar);
                zzguVar.zze().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
            }
        }
        if (th == null) {
            zzhh zzhhVar = this.zzh;
            zzN(zzhhVar);
            zzhhVar.zzo.zzb(true);
            if (bArr == null || bArr.length == 0) {
                zzgu zzguVar2 = this.zzi;
                zzP(zzguVar2);
                zzguVar2.zzj().zza("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String optString = jSONObject.optString("deeplink", "");
                if (TextUtils.isEmpty(optString)) {
                    zzgu zzguVar3 = this.zzi;
                    zzP(zzguVar3);
                    zzguVar3.zzj().zza("Deferred Deep Link is empty.");
                    return;
                }
                String optString2 = jSONObject.optString("gclid", "");
                String optString3 = jSONObject.optString("gbraid", "");
                String optString4 = jSONObject.optString("gad_source", "");
                double optDouble = jSONObject.optDouble("timestamp", AudioStats.AUDIO_AMPLITUDE_NONE);
                Bundle bundle2 = new Bundle();
                zzpp zzppVar = this.zzl;
                zzN(zzppVar);
                zzic zzicVar = zzppVar.zzu;
                if (!TextUtils.isEmpty(optString)) {
                    Context context = zzicVar.zzd;
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0);
                    if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                        if (!TextUtils.isEmpty(optString3)) {
                            bundle2.putString("gbraid", optString3);
                        }
                        if (!TextUtils.isEmpty(optString4)) {
                            bundle2.putString("gad_source", optString4);
                        }
                        bundle2.putString("gclid", optString2);
                        bundle2.putString("_cis", "ddp");
                        this.zzp.zzE(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_cmp", bundle2);
                        zzN(zzppVar);
                        if (TextUtils.isEmpty(optString)) {
                            return;
                        }
                        try {
                            SharedPreferences.Editor edit = context.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                            edit.putString("deeplink", optString);
                            edit.putLong("timestamp", Double.doubleToRawLongBits(optDouble));
                            if (edit.commit()) {
                                Intent intent = new Intent("android.google.analytics.action.DEEPLINK_ACTION");
                                Context context2 = zzppVar.zzu.zzd;
                                if (Build.VERSION.SDK_INT < 34) {
                                    context2.sendBroadcast(intent);
                                    return;
                                }
                                makeBasic = BroadcastOptions.makeBasic();
                                shareIdentityEnabled = makeBasic.setShareIdentityEnabled(true);
                                bundle = shareIdentityEnabled.toBundle();
                                context2.sendBroadcast(intent, null, bundle);
                                return;
                            }
                            return;
                        } catch (RuntimeException e) {
                            zzgu zzguVar4 = zzppVar.zzu.zzi;
                            zzP(zzguVar4);
                            zzguVar4.zzb().zzb("Failed to persist Deferred Deep Link. exception", e);
                            return;
                        }
                    }
                }
                zzgu zzguVar5 = this.zzi;
                zzP(zzguVar5);
                zzguVar5.zze().zzd("Deferred Deep Link validation failed. gclid, gbraid, deep link", optString2, optString3, optString);
                return;
            } catch (JSONException e2) {
                zzgu zzguVar6 = this.zzi;
                zzP(zzguVar6);
                zzguVar6.zzb().zzb("Failed to parse the Deferred Deep Link response. exception", e2);
                return;
            }
        }
        zzgu zzguVar7 = this.zzi;
        zzP(zzguVar7);
        zzguVar7.zze().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzK(zzjs zzjsVar) {
        Bundle bundle;
        zzhz zzhzVar = this.zzj;
        zzP(zzhzVar);
        zzhzVar.zzg();
        zzal zzalVar = this.zzg;
        zzalVar.zzb();
        zzbb zzbbVar = new zzbb(this);
        zzbbVar.zzx();
        this.zzv = zzbbVar;
        com.google.android.gms.internal.measurement.zzdb zzdbVar = zzjsVar.zzd;
        long j = zzdbVar == null ? 0L : zzdbVar.zza;
        String str = "";
        if (zzdbVar != null && (bundle = zzdbVar.zzd) != null) {
            str = bundle.getString("runtime_google_app_id", "");
        }
        zzgi zzgiVar = new zzgi(this, zzjsVar.zzc, j, str);
        zzgiVar.zzc();
        this.zzw = zzgiVar;
        zzgl zzglVar = new zzgl(this);
        zzglVar.zzc();
        this.zzt = zzglVar;
        zznl zznlVar = new zznl(this);
        zznlVar.zzc();
        this.zzu = zznlVar;
        zzpp zzppVar = this.zzl;
        zzppVar.zzy();
        this.zzh.zzy();
        this.zzw.zzd();
        zzlq zzlqVar = new zzlq(this);
        zzlqVar.zzc();
        this.zzx = zzlqVar;
        zzlqVar.zzd();
        zzgu zzguVar = this.zzi;
        zzP(zzguVar);
        zzgs zzi = zzguVar.zzi();
        zzalVar.zzi();
        zzi.zzb("App measurement initialized, version", 161000L);
        zzP(zzguVar);
        zzguVar.zzi().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzj = zzgiVar.zzj();
        zzN(zzppVar);
        if (!zzppVar.zzad(zzj, zzalVar.zzz())) {
            zzP(zzguVar);
            zzgs zzi2 = zzguVar.zzi();
            String.valueOf(zzj);
            zzi2.zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(zzj)));
        } else {
            zzP(zzguVar);
            zzguVar.zzi().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
        }
        zzP(zzguVar);
        zzguVar.zzj().zza("Debug-level message logging enabled");
        int i = this.zzD;
        AtomicInteger atomicInteger = this.zzF;
        if (i != atomicInteger.get()) {
            zzP(zzguVar);
            zzguVar.zzb().zzc("Not all components initialized", Integer.valueOf(this.zzD), Integer.valueOf(atomicInteger.get()));
        }
        this.zzy = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0030, code lost:
    
        if (r0.zzU() == false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0228  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.internal.measurement.zzdb r13) {
        /*
            Method dump skipped, instructions count: 999
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzic.zza(com.google.android.gms.internal.measurement.zzdb):void");
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    @Pure
    public final zzae zzaV() {
        return this.zzf;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    @Pure
    public final zzgu zzaW() {
        zzgu zzguVar = this.zzi;
        zzP(zzguVar);
        return zzguVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    @Pure
    public final zzhz zzaX() {
        zzhz zzhzVar = this.zzj;
        zzP(zzhzVar);
        return zzhzVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    @Pure
    public final Context zzaZ() {
        return this.zzd;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    @Pure
    public final Clock zzba() {
        return this.zzn;
    }

    @Pure
    public final zzal zzc() {
        return this.zzg;
    }

    @Pure
    public final zzhh zzd() {
        zzhh zzhhVar = this.zzh;
        zzN(zzhhVar);
        return zzhhVar;
    }

    public final zzgu zzf() {
        zzgu zzguVar = this.zzi;
        if (zzguVar == null || !zzguVar.zzv()) {
            return null;
        }
        return zzguVar;
    }

    @Pure
    public final zzoc zzh() {
        zzoc zzocVar = this.zzk;
        zzO(zzocVar);
        return zzocVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SideEffectFree
    public final zzhz zzi() {
        return this.zzj;
    }

    @Pure
    public final zzlj zzj() {
        zzlj zzljVar = this.zzp;
        zzO(zzljVar);
        return zzljVar;
    }

    @Pure
    public final zzpp zzk() {
        zzpp zzppVar = this.zzl;
        zzN(zzppVar);
        return zzppVar;
    }

    @Pure
    public final zzgn zzl() {
        return this.zzm;
    }

    @Pure
    public final zzgl zzm() {
        zzO(this.zzt);
        return this.zzt;
    }

    @Pure
    public final zzlo zzn() {
        zzlo zzloVar = this.zzr;
        zzP(zzloVar);
        return zzloVar;
    }

    @Pure
    public final boolean zzp() {
        return this.zze;
    }

    @Pure
    public final String zzq() {
        return this.zzs;
    }

    @Pure
    public final zzmb zzs() {
        zzmb zzmbVar = this.zzo;
        zzO(zzmbVar);
        return zzmbVar;
    }

    @Pure
    public final zznl zzt() {
        zzO(this.zzu);
        return this.zzu;
    }

    @Pure
    public final zzbb zzu() {
        zzP(this.zzv);
        return this.zzv;
    }

    @Pure
    public final zzgi zzv() {
        zzO(this.zzw);
        return this.zzw;
    }

    @Pure
    public final zzd zzw() {
        zzd zzdVar = this.zzq;
        zzM(zzdVar);
        return zzdVar;
    }

    @Pure
    public final zzlq zzx() {
        zzM(this.zzx);
        return this.zzx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzz(boolean z) {
        this.zzB = Boolean.valueOf(z);
    }
}
