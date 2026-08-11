package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import androidx.work.WorkRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzabw;
import com.google.android.gms.internal.measurement.zzabx;
import com.google.android.gms.internal.measurement.zzaif;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.time.DurationKt;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzlj extends zzg {
    protected zzky zza;
    final zzx zzb;
    protected boolean zzc;
    private zzjp zzd;
    private final Set zze;
    private boolean zzf;
    private final AtomicReference zzg;
    private final Object zzh;
    private boolean zzi;
    private int zzj;
    private zzaz zzk;
    private zzaz zzl;
    private PriorityQueue zzm;
    private zzjl zzn;
    private final AtomicLong zzo;
    private long zzp;
    private zzaz zzq;
    private SharedPreferences.OnSharedPreferenceChangeListener zzr;
    private zzaz zzs;
    private final zzpo zzt;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzlj(zzic zzicVar) {
        super(zzicVar);
        this.zze = new CopyOnWriteArraySet();
        this.zzh = new Object();
        this.zzi = false;
        this.zzj = 1;
        this.zzc = true;
        this.zzt = new zzkn(this);
        this.zzg = new AtomicReference();
        this.zzn = zzjl.zza;
        this.zzp = -1L;
        this.zzo = new AtomicLong(0L);
        this.zzb = new zzx(zzicVar);
    }

    private final zzlr zzap(final zzom zzomVar) {
        try {
            URL url = new URI(zzomVar.zzc).toURL();
            final AtomicReference atomicReference = new AtomicReference();
            String zzl = this.zzu.zzv().zzl();
            zzic zzicVar = this.zzu;
            zzgs zzk = zzicVar.zzaW().zzk();
            Long valueOf = Long.valueOf(zzomVar.zza);
            zzk.zzd("[sgtm] Uploading data from app. row_id, url, uncompressed size", valueOf, zzomVar.zzc, Integer.valueOf(zzomVar.zzb.length));
            if (!TextUtils.isEmpty(zzomVar.zzg)) {
                zzicVar.zzaW().zzk().zzc("[sgtm] Uploading data from app. row_id", valueOf, zzomVar.zzg);
            }
            HashMap hashMap = new HashMap();
            Bundle bundle = zzomVar.zzd;
            for (String str : bundle.keySet()) {
                String string = bundle.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put(str, string);
                }
            }
            zzlo zzn = zzicVar.zzn();
            byte[] bArr = zzomVar.zzb;
            zzll zzllVar = new zzll() { // from class: com.google.android.gms.measurement.internal.zzkz
                /* JADX WARN: Removed duplicated region for block: B:10:0x0064  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
                @Override // com.google.android.gms.measurement.internal.zzll
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final /* synthetic */ void zza(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map r11) {
                    /*
                        r6 = this;
                        com.google.android.gms.measurement.internal.zzlj r7 = com.google.android.gms.measurement.internal.zzlj.this
                        r7.zzg()
                        com.google.android.gms.measurement.internal.zzom r10 = r3
                        r11 = 200(0xc8, float:2.8E-43)
                        if (r8 == r11) goto L14
                        r11 = 204(0xcc, float:2.86E-43)
                        if (r8 == r11) goto L14
                        r11 = 304(0x130, float:4.26E-43)
                        if (r8 != r11) goto L2e
                        r8 = r11
                    L14:
                        if (r9 != 0) goto L2e
                        com.google.android.gms.measurement.internal.zzic r8 = r7.zzu
                        com.google.android.gms.measurement.internal.zzgu r8 = r8.zzaW()
                        com.google.android.gms.measurement.internal.zzgs r8 = r8.zzk()
                        long r0 = r10.zza
                        java.lang.Long r9 = java.lang.Long.valueOf(r0)
                        java.lang.String r11 = "[sgtm] Upload succeeded for row_id"
                        r8.zzb(r11, r9)
                        com.google.android.gms.measurement.internal.zzlr r8 = com.google.android.gms.measurement.internal.zzlr.SUCCESS
                        goto L69
                    L2e:
                        com.google.android.gms.measurement.internal.zzic r11 = r7.zzu
                        com.google.android.gms.measurement.internal.zzgu r11 = r11.zzaW()
                        com.google.android.gms.measurement.internal.zzgs r11 = r11.zze()
                        long r0 = r10.zza
                        java.lang.Long r0 = java.lang.Long.valueOf(r0)
                        java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
                        java.lang.String r2 = "[sgtm] Upload failed for row_id. response, exception"
                        r11.zzd(r2, r0, r1, r9)
                        com.google.android.gms.measurement.internal.zzfx r9 = com.google.android.gms.measurement.internal.zzfy.zzt
                        r11 = 0
                        java.lang.Object r9 = r9.zzb(r11)
                        java.lang.String r9 = (java.lang.String) r9
                        java.lang.String r11 = ","
                        java.lang.String[] r9 = r9.split(r11)
                        java.util.List r9 = java.util.Arrays.asList(r9)
                        java.lang.String r8 = java.lang.String.valueOf(r8)
                        boolean r8 = r9.contains(r8)
                        if (r8 == 0) goto L67
                        com.google.android.gms.measurement.internal.zzlr r8 = com.google.android.gms.measurement.internal.zzlr.BACKOFF
                        goto L69
                    L67:
                        com.google.android.gms.measurement.internal.zzlr r8 = com.google.android.gms.measurement.internal.zzlr.FAILURE
                    L69:
                        java.util.concurrent.atomic.AtomicReference r6 = r2
                        com.google.android.gms.measurement.internal.zzic r9 = r7.zzu
                        com.google.android.gms.measurement.internal.zznl r9 = r9.zzt()
                        com.google.android.gms.measurement.internal.zzaf r0 = new com.google.android.gms.measurement.internal.zzaf
                        long r1 = r10.zza
                        int r3 = r8.zza()
                        long r4 = r10.zzf
                        r0.<init>(r1, r3, r4)
                        r9.zzy(r0)
                        com.google.android.gms.measurement.internal.zzic r7 = r7.zzu
                        com.google.android.gms.measurement.internal.zzgu r7 = r7.zzaW()
                        com.google.android.gms.measurement.internal.zzgs r7 = r7.zzk()
                        java.lang.Long r9 = java.lang.Long.valueOf(r1)
                        java.lang.String r10 = "[sgtm] Updated status for row_id"
                        r7.zzc(r10, r9, r8)
                        monitor-enter(r6)
                        r6.set(r8)     // Catch: java.lang.Throwable -> L9d
                        r6.notifyAll()     // Catch: java.lang.Throwable -> L9d
                        monitor-exit(r6)     // Catch: java.lang.Throwable -> L9d
                        return
                    L9d:
                        r0 = move-exception
                        r7 = r0
                        monitor-exit(r6)     // Catch: java.lang.Throwable -> L9d
                        throw r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkz.zza(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
                }
            };
            zzn.zzw();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(bArr);
            Preconditions.checkNotNull(zzllVar);
            zzn.zzu.zzaX().zzm(new zzln(zzn, zzl, url, bArr, hashMap, zzllVar));
            try {
                zzic zzicVar2 = zzicVar.zzk().zzu;
                long currentTimeMillis = zzicVar2.zzba().currentTimeMillis();
                long j = currentTimeMillis + DurationKt.MILLIS_IN_MINUTE;
                synchronized (atomicReference) {
                    for (long j2 = DurationKt.MILLIS_IN_MINUTE; atomicReference.get() == null && j2 > 0; j2 = j - zzicVar2.zzba().currentTimeMillis()) {
                        atomicReference.wait(j2);
                    }
                }
            } catch (InterruptedException unused) {
                this.zzu.zzaW().zze().zza("[sgtm] Interrupted waiting for uploading batch");
            }
            return atomicReference.get() == null ? zzlr.UNKNOWN : (zzlr) atomicReference.get();
        } catch (MalformedURLException | URISyntaxException e) {
            this.zzu.zzaW().zzb().zzd("[sgtm] Bad upload url for row_id", zzomVar.zzc, Long.valueOf(zzomVar.zza), e);
            return zzlr.FAILURE;
        }
    }

    private final void zzaq(Boolean bool, boolean z) {
        zzg();
        zzb();
        zzic zzicVar = this.zzu;
        zzicVar.zzaW().zzj().zzb("Setting app measurement enabled (FE)", bool);
        zzicVar.zzd().zzh(bool);
        if (z) {
            zzhh zzd = zzicVar.zzd();
            zzic zzicVar2 = zzd.zzu;
            zzd.zzg();
            SharedPreferences.Editor edit = zzd.zzd().edit();
            if (bool != null) {
                edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit.remove("measurement_enabled_from_api");
            }
            edit.apply();
        }
        if (this.zzu.zzE() || !(bool == null || bool.booleanValue())) {
            zzak();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzar, reason: merged with bridge method [inline-methods] */
    public final void zzak() {
        zzlj zzljVar;
        zzg();
        zzic zzicVar = this.zzu;
        String zza = zzicVar.zzd().zzh.zza();
        if (zza == null) {
            zzljVar = this;
        } else if ("unset".equals(zza)) {
            zzljVar = this;
            zzljVar.zzM("app", "_npa", null, zzicVar.zzba().currentTimeMillis());
        } else {
            zzljVar = this;
            zzljVar.zzM("app", "_npa", Long.valueOf(true != "true".equals(zza) ? 0L : 1L), zzicVar.zzba().currentTimeMillis());
        }
        if (!zzljVar.zzu.zzB() || !zzljVar.zzc) {
            zzicVar.zzaW().zzj().zza("Updating Scion state (FE)");
            zzljVar.zzu.zzt().zzi();
        } else {
            zzicVar.zzaW().zzj().zza("Recording app launch after enabling measurement for the first time (FE)");
            zzljVar.zzT();
            zzljVar.zzu.zzh().zza.zza();
            zzicVar.zzaX().zzj(new zzjz(zzljVar));
        }
    }

    public final void zzA(String str, String str2, Bundle bundle) {
        zzic zzicVar = this.zzu;
        zzB(str, str2, bundle, true, true, zzicVar.zzba().currentTimeMillis(), zzicVar.zzc().zzp(null, zzfy.zzbe) ? zzicVar.zzba().elapsedRealtime() : 0L);
    }

    public final void zzB(String str, String str2, Bundle bundle, boolean z, boolean z2, long j, long j2) {
        long j3;
        zzmb zzmbVar;
        long j4;
        Bundle bundle2;
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle3 = bundle;
        if (Objects.equals(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
            zzic zzicVar = this.zzu;
            zzic zzicVar2 = this.zzu;
            zzmb zzs = zzicVar.zzs();
            if (true != zzicVar2.zzc().zzp(null, zzfy.zzbe)) {
                j3 = 0;
                j4 = j;
                bundle2 = bundle3;
                zzmbVar = zzs;
            } else {
                j3 = j2;
                zzmbVar = zzs;
                j4 = j;
                bundle2 = bundle3;
            }
            zzmbVar.zzj(bundle2, j4, j3);
            return;
        }
        boolean z3 = !z2 || this.zzd == null || zzpp.zzac(str2);
        if (str == null) {
            str = "app";
        }
        zzI(str, str2, j, true != this.zzu.zzc().zzp(null, zzfy.zzbe) ? 0L : j2, bundle3, z2, z3, z, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzC() {
        zzod zzodVar;
        zzabx zzabxVar;
        zzg();
        zzic zzicVar = this.zzu;
        zzicVar.zzaW().zzj().zza("Handle tcf update.");
        SharedPreferences zze = zzicVar.zzd().zze();
        int i = zzof.zzb;
        zzabw zzabwVar = zzabw.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
        zzoe zzoeVar = zzoe.CONSENT;
        zzabw zzabwVar2 = zzabw.IAB_TCF_PURPOSE_SELECT_BASIC_ADS;
        zzoe zzoeVar2 = zzoe.FLEXIBLE_LEGITIMATE_INTEREST;
        ImmutableMap of = ImmutableMap.of(zzabwVar, zzoeVar, zzabwVar2, zzoeVar2, zzabw.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE, zzoeVar, zzabw.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS, zzoeVar, zzabw.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE, zzoeVar2, zzabw.IAB_TCF_PURPOSE_APPLY_MARKET_RESEARCH_TO_GENERATE_AUDIENCE_INSIGHTS, zzoeVar2, zzabw.IAB_TCF_PURPOSE_DEVELOP_AND_IMPROVE_PRODUCTS, zzoeVar2);
        ImmutableSet of2 = ImmutableSet.of("CH");
        char[] cArr = new char[5];
        boolean contains = zze.contains("IABTCF_TCString");
        int zzb = zzof.zzb(zze, "IABTCF_CmpSdkID");
        int zzb2 = zzof.zzb(zze, "IABTCF_PolicyVersion");
        int zzb3 = zzof.zzb(zze, "IABTCF_gdprApplies");
        int zzb4 = zzof.zzb(zze, "IABTCF_PurposeOneTreatment");
        int zzb5 = zzof.zzb(zze, "IABTCF_EnableAdvertiserConsentMode");
        String zza = zzof.zza(zze, "IABTCF_PublisherCC");
        ImmutableMap.Builder builder = ImmutableMap.builder();
        UnmodifiableIterator it = of.keySet().iterator();
        while (it.hasNext()) {
            zzabw zzabwVar3 = (zzabw) it.next();
            int zza2 = zzabwVar3.zza();
            StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 28);
            sb.append("IABTCF_PublisherRestrictions");
            sb.append(zza2);
            String zza3 = zzof.zza(zze, sb.toString());
            if (TextUtils.isEmpty(zza3) || zza3.length() < 755) {
                zzabxVar = zzabx.PURPOSE_RESTRICTION_UNDEFINED;
            } else {
                int digit = Character.digit(zza3.charAt(754), 10);
                zzabxVar = (digit < 0 || digit > zzabx.values().length || digit == 0) ? zzabx.PURPOSE_RESTRICTION_NOT_ALLOWED : digit != 1 ? digit != 2 ? zzabx.PURPOSE_RESTRICTION_UNDEFINED : zzabx.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST : zzabx.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
            }
            builder.put(zzabwVar3, zzabxVar);
        }
        ImmutableMap buildOrThrow = builder.buildOrThrow();
        String zza4 = zzof.zza(zze, "IABTCF_PurposeConsents");
        String zza5 = zzof.zza(zze, "IABTCF_VendorConsents");
        boolean z = !TextUtils.isEmpty(zza5) && zza5.length() >= 755 && zza5.charAt(754) == '1';
        String zza6 = zzof.zza(zze, "IABTCF_PurposeLegitimateInterests");
        String zza7 = zzof.zza(zze, "IABTCF_VendorLegitimateInterests");
        boolean z2 = !TextUtils.isEmpty(zza7) && zza7.length() >= 755 && zza7.charAt(754) == '1';
        cArr[0] = '2';
        zzod zzodVar2 = new zzod(zzof.zzd(of, buildOrThrow, of2, cArr, zzb, zzb5, zzb3, zzb2, zzb4, zza, zza4, zza6, z, z2, contains));
        zzicVar.zzaW().zzk().zzb("Tcf preferences read", zzodVar2);
        zzhh zzd = zzicVar.zzd();
        zzd.zzg();
        String string = zzd.zzd().getString("stored_tcf_param", "");
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(string)) {
            zzodVar = new zzod(hashMap);
        } else {
            for (String str : string.split(";")) {
                String[] split = str.split("=");
                if (split.length >= 2 && zzof.zza.contains(split[0])) {
                    hashMap.put(split[0], split[1]);
                }
            }
            zzodVar = new zzod(hashMap);
        }
        zzhh zzd2 = zzicVar.zzd();
        zzd2.zzg();
        String string2 = zzd2.zzd().getString("stored_tcf_param", "");
        String zza8 = zzodVar2.zza();
        if (zza8.equals(string2)) {
            return;
        }
        SharedPreferences.Editor edit = zzd2.zzd().edit();
        edit.putString("stored_tcf_param", zza8);
        edit.apply();
        Bundle zzb6 = zzodVar2.zzb();
        zzicVar.zzaW().zzk().zzb("Consent generated from Tcf", zzb6);
        if (zzb6 != Bundle.EMPTY) {
            zzp(zzb6, -30, zzicVar.zzba().currentTimeMillis());
        }
        Bundle bundle = new Bundle();
        bundle.putString("_tcfm", zzodVar2.zzd(zzodVar));
        bundle.putString("_tcfd2", zzodVar2.zzc());
        bundle.putString("_tcfd", zzodVar2.zze());
        zzE(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_tcf", bundle);
    }

    public final void zzD() {
        zzg();
        zzic zzicVar = this.zzu;
        zzicVar.zzaW().zzj().zza("Register tcfPrefChangeListener.");
        if (this.zzr == null) {
            this.zzs = new zzkb(this, this.zzu);
            this.zzr = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.measurement.internal.zzle
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final /* synthetic */ void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    zzlj.this.zzaf(sharedPreferences, str);
                }
            };
        }
        zzicVar.zzd().zze().registerOnSharedPreferenceChangeListener(this.zzr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzE(String str, String str2, Bundle bundle) {
        zzg();
        zzic zzicVar = this.zzu;
        zzF(str, str2, zzicVar.zzba().currentTimeMillis(), zzicVar.zzc().zzp(null, zzfy.zzbe) ? zzicVar.zzba().elapsedRealtime() : 0L, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzF(String str, String str2, long j, long j2, Bundle bundle) {
        zzg();
        boolean z = true;
        if (this.zzd != null && !zzpp.zzac(str2)) {
            z = false;
        }
        zzG(str, str2, j, j2, bundle, true, z, true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0137  */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX WARN: Type inference failed for: r22v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzG(java.lang.String r26, java.lang.String r27, long r28, long r30, android.os.Bundle r32, boolean r33, boolean r34, boolean r35, java.lang.String r36) {
        /*
            Method dump skipped, instructions count: 1238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlj.zzG(java.lang.String, java.lang.String, long, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void zzH(String str, String str2, Bundle bundle, String str3) {
        zzic.zzL();
        zzic zzicVar = this.zzu;
        zzI(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str2, zzicVar.zzba().currentTimeMillis(), zzicVar.zzc().zzp(null, zzfy.zzbe) ? zzicVar.zzba().elapsedRealtime() : 0L, bundle, false, true, true, str3);
    }

    protected final void zzI(String str, String str2, long j, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        int i = zzpp.zza;
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i2 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i2 < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i2];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i2] = new Bundle((Bundle) parcelable);
                        }
                        i2++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i2 < list.size()) {
                        Object obj2 = list.get(i2);
                        if (obj2 instanceof Bundle) {
                            list.set(i2, new Bundle((Bundle) obj2));
                        }
                        i2++;
                    }
                }
            }
        }
        this.zzu.zzaX().zzj(new zzkc(this, str, str2, j, j2, bundle2, z, z2, z3, str3));
    }

    public final void zzJ(String str, String str2, Object obj, boolean z) {
        zzK(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ldl", obj, true, this.zzu.zzba().currentTimeMillis());
    }

    final void zzL(String str, String str2, long j, Object obj) {
        this.zzu.zzaX().zzj(new zzkd(this, str, str2, obj, j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzM(String str, String str2, Object obj, long j) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzb();
        if (FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS.equals(str2)) {
            if (obj instanceof String) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    long j2 = true != "false".equals(str3.toLowerCase(Locale.ENGLISH)) ? 0L : 1L;
                    zzic zzicVar = this.zzu;
                    Long valueOf = Long.valueOf(j2);
                    zzicVar.zzd().zzh.zzb(valueOf.longValue() == 1 ? "true" : "false");
                    obj = valueOf;
                    str2 = "_npa";
                    this.zzu.zzaW().zzk().zzc("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
                }
            }
            if (obj == null) {
                this.zzu.zzd().zzh.zzb("unset");
                str2 = "_npa";
            }
            this.zzu.zzaW().zzk().zzc("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
        }
        String str4 = str2;
        Object obj2 = obj;
        zzic zzicVar2 = this.zzu;
        if (!zzicVar2.zzB()) {
            this.zzu.zzaW().zzk().zza("User property not set since app measurement is disabled");
        } else if (zzicVar2.zzH()) {
            this.zzu.zzt().zzA(new zzpl(str4, j, obj2, str));
        }
    }

    public final List zzN(boolean z) {
        zzb();
        zzic zzicVar = this.zzu;
        zzicVar.zzaW().zzk().zza("Getting user properties (FE)");
        if (!zzicVar.zzaX().zze()) {
            zzicVar.zzaV();
            if (zzae.zza()) {
                zzicVar.zzaW().zzb().zza("Cannot get all user properties from main thread");
                return Collections.EMPTY_LIST;
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzaX().zzk(atomicReference, CoroutineLiveDataKt.DEFAULT_TIMEOUT, "get user properties", new zzkf(this, atomicReference, z));
            List list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzicVar.zzaW().zzb().zzb("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.EMPTY_LIST;
        }
        zzicVar.zzaW().zzb().zza("Cannot get all user properties from analytics worker thread");
        return Collections.EMPTY_LIST;
    }

    public final Map zzO(String str, String str2, boolean z) {
        zzic zzicVar = this.zzu;
        if (!zzicVar.zzaX().zze()) {
            zzicVar.zzaV();
            if (zzae.zza()) {
                zzicVar.zzaW().zzb().zza("Cannot get user properties from main thread");
                return Collections.EMPTY_MAP;
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzaX().zzk(atomicReference, CoroutineLiveDataKt.DEFAULT_TIMEOUT, "get user properties", new zzkl(this, atomicReference, null, str, str2, z));
            List<zzpl> list = (List) atomicReference.get();
            if (list == null) {
                zzicVar.zzaW().zzb().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.EMPTY_MAP;
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzpl zzplVar : list) {
                Object zza = zzplVar.zza();
                if (zza != null) {
                    arrayMap.put(zzplVar.zzb, zza);
                }
            }
            return arrayMap;
        }
        zzicVar.zzaW().zzb().zza("Cannot get user properties from analytics worker thread");
        return Collections.EMPTY_MAP;
    }

    public final String zzP() {
        return (String) this.zzg.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzQ(String str) {
        this.zzg.set(str);
    }

    public final void zzR() {
        zzg();
        zzic zzicVar = this.zzu;
        if (!zzicVar.zzd().zzo.zza()) {
            long zza = zzicVar.zzd().zzp.zza();
            zzicVar.zzd().zzp.zzb(1 + zza);
            zzicVar.zzc();
            if (zza >= 5) {
                zzicVar.zzaW().zze().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                zzicVar.zzd().zzo.zzb(true);
                return;
            } else {
                if (this.zzq == null) {
                    this.zzq = new zzkg(this, this.zzu);
                }
                this.zzq.zzb(0L);
                return;
            }
        }
        zzicVar.zzaW().zzj().zza("Deferred Deep Link already retrieved. Not fetching again.");
    }

    public final void zzS(long j, long j2) {
        this.zzg.set(null);
        this.zzu.zzaX().zzj(new zzkh(this, j));
    }

    public final void zzT() {
        zzg();
        zzb();
        if (this.zzu.zzH()) {
            zzic zzicVar = this.zzu;
            zzal zzc = zzicVar.zzc();
            zzc.zzu.zzaV();
            Boolean zzr = zzc.zzr("google_analytics_deferred_deep_link_enabled");
            if (zzr != null && zzr.booleanValue()) {
                zzicVar.zzaW().zzj().zza("Deferred Deep Link feature enabled.");
                zzicVar.zzaX().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlh
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzlj.this.zzR();
                    }
                });
            }
            this.zzu.zzt().zzE();
            this.zzc = false;
            zzhh zzd = zzicVar.zzd();
            zzd.zzg();
            String string = zzd.zzd().getString("previous_os_version", null);
            zzd.zzu.zzu().zzw();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = zzd.zzd().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            zzicVar.zzu().zzw();
            if (string.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            zzE(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ou", bundle);
        }
    }

    public final void zzU(zzjp zzjpVar) {
        zzjp zzjpVar2;
        zzg();
        zzb();
        if (zzjpVar != null && zzjpVar != (zzjpVar2 = this.zzd)) {
            Preconditions.checkState(zzjpVar2 == null, "EventInterceptor already set.");
        }
        this.zzd = zzjpVar;
    }

    public final void zzV(zzjq zzjqVar) {
        zzb();
        Preconditions.checkNotNull(zzjqVar);
        if (this.zze.add(zzjqVar)) {
            return;
        }
        this.zzu.zzaW().zze().zza("OnEventListener already registered");
    }

    public final void zzW(zzjq zzjqVar) {
        zzb();
        Preconditions.checkNotNull(zzjqVar);
        if (this.zze.remove(zzjqVar)) {
            return;
        }
        this.zzu.zzaW().zze().zza("OnEventListener had not been registered");
    }

    public final int zzX(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzu.zzc();
        return 25;
    }

    public final void zzY(Bundle bundle) {
        zzZ(bundle, this.zzu.zzba().currentTimeMillis());
    }

    public final void zzZ(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.zzu.zzaW().zze().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzjh.zzb(bundle2, "app_id", String.class, null);
        zzjh.zzb(bundle2, "origin", String.class, null);
        zzjh.zzb(bundle2, "name", String.class, null);
        zzjh.zzb(bundle2, "value", Object.class, null);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzjh.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        zzic zzicVar = this.zzu;
        if (zzicVar.zzk().zzs(string) == 0) {
            if (zzicVar.zzk().zzM(string, obj) == 0) {
                Object zzN = zzicVar.zzk().zzN(string, obj);
                if (zzN == null) {
                    zzicVar.zzaW().zzb().zzc("Unable to normalize conditional user property value", zzicVar.zzl().zzc(string), obj);
                    return;
                }
                zzjh.zza(bundle2, zzN);
                long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
                if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME))) {
                    zzicVar.zzc();
                    if (j2 > 15552000000L || j2 < 1) {
                        zzicVar.zzaW().zzb().zzc("Invalid conditional user property timeout", zzicVar.zzl().zzc(string), Long.valueOf(j2));
                        return;
                    }
                }
                long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                zzicVar.zzc();
                if (j3 > 15552000000L || j3 < 1) {
                    zzicVar.zzaW().zzb().zzc("Invalid conditional user property time to live", zzicVar.zzl().zzc(string), Long.valueOf(j3));
                    return;
                } else {
                    zzicVar.zzaX().zzj(new zzki(this, bundle2));
                    return;
                }
            }
            zzicVar.zzaW().zzb().zzc("Invalid conditional user property value", zzicVar.zzl().zzc(string), obj);
            return;
        }
        zzicVar.zzaW().zzb().zzb("Invalid conditional user property name", zzicVar.zzl().zzc(string));
    }

    public final void zzaa(String str, String str2, Bundle bundle) {
        zzic zzicVar = this.zzu;
        long currentTimeMillis = zzicVar.zzba().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzicVar.zzaX().zzj(new zzkj(this, bundle2));
    }

    public final ArrayList zzab(String str, String str2) {
        zzic zzicVar = this.zzu;
        if (!zzicVar.zzaX().zze()) {
            zzicVar.zzaV();
            if (zzae.zza()) {
                zzicVar.zzaW().zzb().zza("Cannot get conditional user properties from main thread");
                return new ArrayList(0);
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzu.zzaX().zzk(atomicReference, CoroutineLiveDataKt.DEFAULT_TIMEOUT, "get conditional user properties", new zzkk(this, atomicReference, null, str, str2));
            List list = (List) atomicReference.get();
            if (list == null) {
                zzicVar.zzaW().zzb().zzb("Timed out waiting for get conditional user properties", null);
                return new ArrayList();
            }
            return zzpp.zzav(list);
        }
        zzicVar.zzaW().zzb().zza("Cannot get conditional user properties from analytics worker thread");
        return new ArrayList(0);
    }

    public final String zzac() {
        zzlu zzl = this.zzu.zzs().zzl();
        if (zzl != null) {
            return zzl.zza;
        }
        return null;
    }

    public final String zzad() {
        zzlu zzl = this.zzu.zzs().zzl();
        if (zzl != null) {
            return zzl.zzb;
        }
        return null;
    }

    public final String zzae() {
        try {
            return zzlt.zza(this.zzu.zzaZ(), "google_app_id", this.zzu.zzq());
        } catch (IllegalStateException e) {
            this.zzu.zzaW().zzb().zzb("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaf(SharedPreferences sharedPreferences, String str) {
        if (Objects.equals(str, "IABTCF_TCString") || Objects.equals(str, "IABTCF_gdprApplies") || Objects.equals(str, "IABTCF_EnableAdvertiserConsentMode")) {
            this.zzu.zzaW().zzk().zza("IABTCF_TCString change picked up in listener.");
            ((zzaz) Preconditions.checkNotNull(this.zzs)).zzb(500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzag(Bundle bundle) {
        int i;
        if (!bundle.isEmpty()) {
            zzic zzicVar = this.zzu;
            Bundle bundle2 = new Bundle(zzicVar.zzd().zzt.zza());
            Iterator<String> it = bundle.keySet().iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                Object obj = bundle.get(next);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    if (zzicVar.zzk().zzz(obj)) {
                        zzicVar.zzk().zzP(this.zzt, null, 27, null, null, 0);
                    }
                    zzicVar.zzaW().zzh().zzc("Invalid default event parameter type. Name, value", next, obj);
                } else if (zzpp.zzac(next)) {
                    zzicVar.zzaW().zzh().zzb("Invalid default event parameter name. Name", next);
                } else if (obj == null) {
                    bundle2.remove(next);
                } else if (zzicVar.zzk().zzA("param", next, zzicVar.zzc().zze(null, false), obj)) {
                    zzicVar.zzk().zzO(bundle2, next, obj);
                }
            }
            zzicVar.zzk();
            int zzc = zzicVar.zzc().zzc();
            if (bundle2.size() > zzc) {
                for (String str : new TreeSet(bundle2.keySet())) {
                    i++;
                    if (i > zzc) {
                        bundle2.remove(str);
                    }
                }
                zzicVar.zzk().zzP(this.zzt, null, 26, null, null, 0);
                zzicVar.zzaW().zzh().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
            bundle = bundle2;
        }
        this.zzu.zzd().zzt.zzb(bundle);
        this.zzu.zzt().zzH(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzah(int i) {
        if (this.zzk == null) {
            this.zzk = new zzjx(this, this.zzu);
        }
        this.zzk.zzb(i * 1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzai(Boolean bool, boolean z) {
        zzaq(bool, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaj(zzjl zzjlVar, long j, boolean z, boolean z2) {
        zzg();
        zzb();
        zzic zzicVar = this.zzu;
        zzjl zzl = zzicVar.zzd().zzl();
        if (j <= this.zzp && zzjl.zzu(zzl.zzb(), zzjlVar.zzb())) {
            zzicVar.zzaW().zzi().zzb("Dropped out-of-date consent setting, proposed settings", zzjlVar);
            return;
        }
        zzhh zzd = zzicVar.zzd();
        zzic zzicVar2 = zzd.zzu;
        zzd.zzg();
        int zzb = zzjlVar.zzb();
        if (zzd.zzk(zzb)) {
            zzic zzicVar3 = this.zzu;
            SharedPreferences.Editor edit = zzd.zzd().edit();
            edit.putString("consent_settings", zzjlVar.zzl());
            edit.putInt("consent_source", zzb);
            edit.apply();
            zzicVar.zzaW().zzk().zzb("Setting storage consent(FE)", zzjlVar);
            this.zzp = j;
            if (!zzicVar3.zzt().zzP()) {
                zzicVar3.zzt().zzj(z);
            } else {
                zzicVar3.zzt().zzk(z);
            }
            if (z2) {
                zzicVar3.zzt().zzC(new AtomicReference());
                return;
            }
            return;
        }
        zzicVar.zzaW().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzjlVar.zzb()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzal(boolean z) {
        this.zzi = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ int zzam() {
        return this.zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzan(int i) {
        this.zzj = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzaz zzao() {
        return this.zzq;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return false;
    }

    public final void zzh() {
        zzic zzicVar = this.zzu;
        if (!(zzicVar.zzaZ().getApplicationContext() instanceof Application) || this.zza == null) {
            return;
        }
        ((Application) zzicVar.zzaZ().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
    }

    public final Boolean zzi() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.zzu.zzaX().zzk(atomicReference, 15000L, "boolean test flag value", new zzke(this, atomicReference));
    }

    public final String zzj() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.zzu.zzaX().zzk(atomicReference, 15000L, "String test flag value", new zzko(this, atomicReference));
    }

    public final Long zzk() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.zzu.zzaX().zzk(atomicReference, 15000L, "long test flag value", new zzkp(this, atomicReference));
    }

    public final Integer zzl() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.zzu.zzaX().zzk(atomicReference, 15000L, "int test flag value", new zzkq(this, atomicReference));
    }

    public final Double zzm() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.zzu.zzaX().zzk(atomicReference, 15000L, "double test flag value", new zzkr(this, atomicReference));
    }

    public final void zzn(Boolean bool) {
        zzb();
        this.zzu.zzaX().zzj(new zzks(this, bool));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzp(Bundle bundle, int i, long j) {
        Object obj;
        String string;
        zzb();
        zzjl zzjlVar = zzjl.zza;
        zzjk[] zzb = zzjj.STORAGE.zzb();
        int length = zzb.length;
        int i2 = 0;
        while (true) {
            obj = null;
            if (i2 >= length) {
                break;
            }
            String str = zzb[i2].zze;
            if (bundle.containsKey(str) && (string = bundle.getString(str)) != null) {
                if (string.equals("granted")) {
                    obj = true;
                } else if (string.equals("denied")) {
                    obj = false;
                }
                if (obj == null) {
                    obj = string;
                    break;
                }
            }
            i2++;
        }
        if (obj != null) {
            zzic zzicVar = this.zzu;
            zzicVar.zzaW().zzh().zzb("Ignoring invalid consent setting", obj);
            zzicVar.zzaW().zzh().zza("Valid consent values are 'granted', 'denied'");
        }
        boolean zze = this.zzu.zzaX().zze();
        zzjl zze2 = zzjl.zze(bundle, i);
        if (zze2.zzc()) {
            zzs(zze2, zze);
        }
        zzba zzh = zzba.zzh(bundle, i);
        if (zzh.zzd()) {
            zzq(zzh, zze);
        }
        Boolean zzi = zzba.zzi(bundle);
        if (zzi != null) {
            String str2 = i == -30 ? "tcf" : "app";
            if (zze) {
                zzM(str2, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, zzi.toString(), j);
            } else {
                zzK(str2, FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, zzi.toString(), false, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzq(zzba zzbaVar, boolean z) {
        zzkt zzktVar = new zzkt(this, zzbaVar);
        if (!z) {
            this.zzu.zzaX().zzj(zzktVar);
        } else {
            zzg();
            zzktVar.run();
        }
    }

    public final void zzs(zzjl zzjlVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        zzjl zzjlVar2;
        zzb();
        int zzb = zzjlVar.zzb();
        if (zzb != -10) {
            zzji zzp = zzjlVar.zzp();
            zzji zzjiVar = zzji.UNINITIALIZED;
            if (zzp == zzjiVar && zzjlVar.zzq() == zzjiVar) {
                this.zzu.zzaW().zzh().zza("Ignoring empty consent settings");
                return;
            }
        }
        synchronized (this.zzh) {
            z2 = false;
            if (zzjl.zzu(zzb, this.zzn.zzb())) {
                z3 = zzjlVar.zzr(this.zzn);
                zzjk zzjkVar = zzjk.ANALYTICS_STORAGE;
                if (zzjlVar.zzo(zzjkVar) && !this.zzn.zzo(zzjkVar)) {
                    z2 = true;
                }
                zzjlVar = zzjlVar.zzt(this.zzn);
                this.zzn = zzjlVar;
                z4 = z2;
                z2 = true;
            } else {
                z3 = false;
                z4 = false;
            }
            zzjlVar2 = zzjlVar;
        }
        if (!z2) {
            this.zzu.zzaW().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", zzjlVar2);
            return;
        }
        long andIncrement = this.zzo.getAndIncrement();
        if (z3) {
            this.zzg.set(null);
            zzku zzkuVar = new zzku(this, zzjlVar2, andIncrement, z4);
            if (!z) {
                this.zzu.zzaX().zzl(zzkuVar);
                return;
            } else {
                zzg();
                zzkuVar.run();
                return;
            }
        }
        zzkv zzkvVar = new zzkv(this, zzjlVar2, andIncrement, z4);
        if (z) {
            zzg();
            zzkvVar.run();
        } else if (zzb == 30 || zzb == -10) {
            this.zzu.zzaX().zzl(zzkvVar);
        } else {
            this.zzu.zzaX().zzj(zzkvVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzt(Runnable runnable) {
        zzb();
        zzic zzicVar = this.zzu;
        if (!zzicVar.zzaX().zze()) {
            if (!zzicVar.zzaX().zzf()) {
                zzicVar.zzaV();
                if (!zzae.zza()) {
                    zzicVar.zzaW().zzk().zza("[sgtm] Started client-side batch upload work.");
                    boolean z = false;
                    int i = 0;
                    int i2 = 0;
                    while (!z) {
                        zzicVar.zzaW().zzk().zza("[sgtm] Getting upload batches from service (FE)");
                        final AtomicReference atomicReference = new AtomicReference();
                        zzicVar.zzaX().zzk(atomicReference, WorkRequest.MIN_BACKOFF_MILLIS, "[sgtm] Getting upload batches", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzli
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzlj.this.zzu.zzt().zzx(atomicReference, zzoo.zza(zzls.SGTM_CLIENT));
                            }
                        });
                        zzoq zzoqVar = (zzoq) atomicReference.get();
                        if (zzoqVar == null) {
                            break;
                        }
                        List list = zzoqVar.zza;
                        if (!list.isEmpty()) {
                            zzicVar.zzaW().zzk().zzb("[sgtm] Retrieved upload batches. count", Integer.valueOf(list.size()));
                            i += list.size();
                            Iterator it = list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z = false;
                                    break;
                                }
                                zzlr zzap = zzap((zzom) it.next());
                                if (zzap == zzlr.SUCCESS) {
                                    i2++;
                                } else if (zzap == zzlr.BACKOFF) {
                                    z = true;
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                    }
                    zzicVar.zzaW().zzk().zzc("[sgtm] Completed client-side batch upload work. total, success", Integer.valueOf(i), Integer.valueOf(i2));
                    runnable.run();
                    return;
                }
                zzicVar.zzaW().zzb().zza("Cannot retrieve and upload batches from main thread");
                return;
            }
            zzicVar.zzaW().zzb().zza("Cannot retrieve and upload batches from analytics network thread");
            return;
        }
        zzicVar.zzaW().zzb().zza("Cannot retrieve and upload batches from analytics worker thread");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzu(long j) {
        zzg();
        if (this.zzl == null) {
            this.zzl = new zzju(this, this.zzu);
        }
        this.zzl.zzb(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzv() {
        zzg();
        zzaz zzazVar = this.zzl;
        if (zzazVar != null) {
            zzazVar.zzd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzw() {
        zzaif.zza();
        zzic zzicVar = this.zzu;
        if (zzicVar.zzc().zzp(null, zzfy.zzaP)) {
            if (!zzicVar.zzaX().zze()) {
                zzicVar.zzaV();
                if (!zzae.zza()) {
                    zzb();
                    zzicVar.zzaW().zzk().zza("Getting trigger URIs (FE)");
                    final AtomicReference atomicReference = new AtomicReference();
                    zzicVar.zzaX().zzk(atomicReference, WorkRequest.MIN_BACKOFF_MILLIS, "get trigger URIs", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzla
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzlj zzljVar = zzlj.this;
                            zzljVar.zzu.zzt().zzw(atomicReference, zzljVar.zzu.zzd().zzi.zza());
                        }
                    });
                    final List list = (List) atomicReference.get();
                    if (list == null) {
                        zzicVar.zzaW().zzd().zza("Timed out waiting for get trigger URIs");
                        return;
                    } else {
                        zzicVar.zzaX().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlb
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                boolean contains;
                                zzlj zzljVar = zzlj.this;
                                zzljVar.zzg();
                                if (Build.VERSION.SDK_INT < 30) {
                                    return;
                                }
                                List<zzoh> list2 = list;
                                SparseArray zzf = zzljVar.zzu.zzd().zzf();
                                for (zzoh zzohVar : list2) {
                                    int i = zzohVar.zzc;
                                    contains = zzf.contains(i);
                                    if (!contains || ((Long) zzf.get(i)).longValue() < zzohVar.zzb) {
                                        zzljVar.zzx().add(zzohVar);
                                    }
                                }
                                zzljVar.zzy();
                            }
                        });
                        return;
                    }
                }
                zzicVar.zzaW().zzb().zza("Cannot get trigger URIs from main thread");
                return;
            }
            zzicVar.zzaW().zzb().zza("Cannot get trigger URIs from analytics worker thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PriorityQueue zzx() {
        PriorityQueue priorityQueue = this.zzm;
        if (priorityQueue != null) {
            return priorityQueue;
        }
        PriorityQueue priorityQueue2 = new PriorityQueue(Comparator.comparing(zzlc.zza, zzld.zza));
        this.zzm = priorityQueue2;
        return priorityQueue2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzy() {
        zzoh zzohVar;
        zzg();
        if (zzx().isEmpty() || this.zzi || (zzohVar = (zzoh) zzx().poll()) == null) {
            return;
        }
        zzic zzicVar = this.zzu;
        MeasurementManagerFutures zzV = zzicVar.zzk().zzV();
        if (zzV != null) {
            this.zzi = true;
            zzgs zzk = zzicVar.zzaW().zzk();
            String str = zzohVar.zza;
            zzk.zzb("Registering trigger URI", str);
            ListenableFuture<Unit> registerTriggerAsync = zzV.registerTriggerAsync(Uri.parse(str));
            if (registerTriggerAsync == null) {
                this.zzi = false;
                zzx().add(zzohVar);
            } else {
                Futures.addCallback(registerTriggerAsync, new zzjw(this, zzohVar), new zzjv(this));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzz(zzjl zzjlVar) {
        zzg();
        boolean z = (zzjlVar.zzo(zzjk.ANALYTICS_STORAGE) && zzjlVar.zzo(zzjk.AD_STORAGE)) || this.zzu.zzt().zzO();
        zzic zzicVar = this.zzu;
        if (z != zzicVar.zzE()) {
            zzicVar.zzD(z);
            zzhh zzd = this.zzu.zzd();
            zzic zzicVar2 = zzd.zzu;
            zzd.zzg();
            Boolean valueOf = zzd.zzd().contains("measurement_enabled_from_api") ? Boolean.valueOf(zzd.zzd().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z || valueOf == null || valueOf.booleanValue()) {
                zzaq(Boolean.valueOf(z), false);
            }
        }
    }

    public final void zzK(String str, String str2, Object obj, boolean z, long j) {
        int i;
        if (!z) {
            zzpp zzk = this.zzu.zzk();
            if (zzk.zzk("user property", str2)) {
                if (zzk.zzm("user property", zzjo.zza, null, str2)) {
                    zzk.zzu.zzc();
                    if (zzk.zzn("user property", 24, str2)) {
                        i = 0;
                    }
                } else {
                    i = 15;
                }
            }
            i = 6;
        } else {
            i = this.zzu.zzk().zzs(str2);
        }
        if (i != 0) {
            zzic zzicVar = this.zzu;
            zzpp zzk2 = zzicVar.zzk();
            zzicVar.zzc();
            this.zzu.zzk().zzP(this.zzt, null, i, "_ev", zzk2.zzE(str2, 24, true), str2 != null ? str2.length() : 0);
            return;
        }
        String str3 = str == null ? "app" : str;
        if (obj != null) {
            zzic zzicVar2 = this.zzu;
            int zzM = zzicVar2.zzk().zzM(str2, obj);
            if (zzM == 0) {
                Object zzN = zzicVar2.zzk().zzN(str2, obj);
                if (zzN != null) {
                    zzL(str3, str2, j, zzN);
                    return;
                }
                return;
            }
            zzpp zzk3 = zzicVar2.zzk();
            zzicVar2.zzc();
            this.zzu.zzk().zzP(this.zzt, null, zzM, "_ev", zzk3.zzE(str2, 24, true), ((obj instanceof String) || (obj instanceof CharSequence)) ? obj.toString().length() : 0);
            return;
        }
        zzL(str3, str2, j, null);
    }
}
