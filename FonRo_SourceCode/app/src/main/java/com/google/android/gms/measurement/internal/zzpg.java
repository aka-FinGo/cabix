package com.google.android.gms.measurement.internal;

import android.app.BroadcastOptions;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.camera.video.AudioStats;
import androidx.collection.ArrayMap;
import androidx.collection.SieveCacheKt;
import androidx.work.WorkRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzaeh;
import com.google.android.gms.internal.measurement.zzahh;
import com.google.android.gms.internal.measurement.zzaif;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.time.DurationKt;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzpg implements zzjg {
    private static volatile zzpg zzb;
    private List zzA;
    private long zzB;
    private final Map zzC;
    private final Map zzD;
    private final Map zzE;
    private zzlu zzG;
    private String zzH;
    private zzaz zzI;
    private long zzJ;
    long zza;
    private final zzht zzc;
    private final zzgz zzd;
    private zzaw zze;
    private zzhb zzf;
    private zzok zzg;
    private zzad zzh;
    private final zzpk zzi;
    private zzlp zzj;
    private zznn zzk;
    private final zzou zzl;
    private zzhk zzm;
    private final zzic zzn;
    private boolean zzp;
    private List zzq;
    private int zzs;
    private int zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private FileLock zzx;
    private FileChannel zzy;
    private List zzz;
    private final AtomicBoolean zzo = new AtomicBoolean(false);
    private final Deque zzr = new LinkedList();
    private final Map zzF = new HashMap();
    private final zzpo zzK = new zzpb(this);

    zzpg(zzph zzphVar, zzic zzicVar) {
        Preconditions.checkNotNull(zzphVar);
        this.zzn = zzic.zzy(zzphVar.zza, null, null, null);
        this.zzB = -1L;
        this.zzl = new zzou(this);
        zzpk zzpkVar = new zzpk(this);
        zzpkVar.zzaz();
        this.zzi = zzpkVar;
        zzgz zzgzVar = new zzgz(this);
        zzgzVar.zzaz();
        this.zzd = zzgzVar;
        zzht zzhtVar = new zzht(this);
        zzhtVar.zzaz();
        this.zzc = zzhtVar;
        this.zzC = new HashMap();
        this.zzD = new HashMap();
        this.zzE = new HashMap();
        zzaX().zzj(new zzov(this, zzphVar));
    }

    public static zzpg zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzpg.class) {
                if (zzb == null) {
                    zzb = new zzpg((zzph) Preconditions.checkNotNull(new zzph(context)), null);
                }
            }
        }
        return zzb;
    }

    static final void zzaB(com.google.android.gms.internal.measurement.zzhr zzhrVar, int i, String str) {
        List zza = zzhrVar.zza();
        for (int i2 = 0; i2 < zza.size(); i2++) {
            if ("_err".equals(((com.google.android.gms.internal.measurement.zzhw) zza.get(i2)).zzb())) {
                return;
            }
        }
        com.google.android.gms.internal.measurement.zzhv zzn = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzn.zzb("_err");
        long j = i;
        Long.valueOf(j).getClass();
        zzn.zzf(j);
        com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) zzn.zzbd();
        com.google.android.gms.internal.measurement.zzhv zzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzn2.zzb("_ev");
        zzn2.zzd(str);
        com.google.android.gms.internal.measurement.zzhw zzhwVar2 = (com.google.android.gms.internal.measurement.zzhw) zzn2.zzbd();
        zzhrVar.zzf(zzhwVar);
        zzhrVar.zzf(zzhwVar2);
    }

    static final void zzaC(com.google.android.gms.internal.measurement.zzhr zzhrVar, String str) {
        List zza = zzhrVar.zza();
        for (int i = 0; i < zza.size(); i++) {
            if (str.equals(((com.google.android.gms.internal.measurement.zzhw) zza.get(i)).zzb())) {
                zzhrVar.zzj(i);
                return;
            }
        }
    }

    private final int zzaD(String str, zzan zzanVar) {
        zzjk zzjkVar;
        zzji zzB;
        zzht zzhtVar = this.zzc;
        if (zzhtVar.zzy(str) == null) {
            zzanVar.zzc(zzjk.AD_PERSONALIZATION, zzam.FAILSAFE);
            return 1;
        }
        zzh zzu = zzj().zzu(str);
        if (zzu != null && zze.zzc(zzu.zzaH()).zza() == zzji.POLICY && (zzB = zzhtVar.zzB(str, (zzjkVar = zzjk.AD_PERSONALIZATION))) != zzji.UNINITIALIZED) {
            zzanVar.zzc(zzjkVar, zzam.REMOTE_ENFORCED_DEFAULT);
            return zzB == zzji.GRANTED ? 0 : 1;
        }
        zzjk zzjkVar2 = zzjk.AD_PERSONALIZATION;
        zzanVar.zzc(zzjkVar2, zzam.REMOTE_DEFAULT);
        return zzhtVar.zzw(str, zzjkVar2) ? 0 : 1;
    }

    private final Map zzaE(com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        HashMap hashMap = new HashMap();
        zzp();
        for (Map.Entry entry : zzpk.zzL(zzhsVar, "gad_").entrySet()) {
            hashMap.put((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        return hashMap;
    }

    private final zzaz zzaF() {
        if (this.zzI == null) {
            this.zzI = new zzoy(this, this.zzn);
        }
        return this.zzI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzaG, reason: merged with bridge method [inline-methods] */
    public final void zzaw() {
        zzaX().zzg();
        if (this.zzr.isEmpty() || zzaF().zzc()) {
            return;
        }
        long max = Math.max(0L, ((Integer) zzfy.zzaA.zzb(null)).intValue() - (zzba().elapsedRealtime() - this.zzJ));
        zzaW().zzk().zzb("Scheduling notify next app runnable, delay in ms", Long.valueOf(max));
        zzaF().zzb(max);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    private final boolean zzaH(java.lang.String r44, long r45) {
        /*
            Method dump skipped, instructions count: 3656
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzaH(java.lang.String, long):boolean");
    }

    private final void zzaI(com.google.android.gms.internal.measurement.zzic zzicVar, long j, boolean z) {
        String str;
        zzpn zzpnVar;
        Object obj;
        if (true != z) {
            str = "_lte";
        } else {
            str = "_se";
        }
        String str2 = str;
        zzpn zzm = zzj().zzm(zzicVar.zzK(), str2);
        if (zzm == null || (obj = zzm.zze) == null) {
            zzpnVar = new zzpn(zzicVar.zzK(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str2, zzba().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzpnVar = new zzpn(zzicVar.zzK(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str2, zzba().currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j));
        }
        com.google.android.gms.internal.measurement.zzit zzm2 = com.google.android.gms.internal.measurement.zziu.zzm();
        zzm2.zzb(str2);
        zzm2.zza(zzba().currentTimeMillis());
        Object obj2 = zzpnVar.zze;
        zzm2.zze(((Long) obj2).longValue());
        com.google.android.gms.internal.measurement.zziu zziuVar = (com.google.android.gms.internal.measurement.zziu) zzm2.zzbd();
        int zzx = zzpk.zzx(zzicVar, str2);
        if (zzx < 0) {
            zzicVar.zzo(zziuVar);
        } else {
            zzicVar.zzn(zzx, zziuVar);
        }
        if (j > 0) {
            zzj().zzl(zzpnVar);
            zzaW().zzk().zzc("Updated engagement user property. scope, value", true != z ? "lifetime" : "session-scoped", obj2);
        }
    }

    private final boolean zzaJ(com.google.android.gms.internal.measurement.zzhr zzhrVar, com.google.android.gms.internal.measurement.zzhr zzhrVar2) {
        Preconditions.checkArgument("_e".equals(zzhrVar.zzk()));
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzI = zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbd(), "_sc");
        String zzd = zzI == null ? null : zzI.zzd();
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzI2 = zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar2.zzbd(), "_pc");
        String zzd2 = zzI2 != null ? zzI2.zzd() : null;
        if (zzd2 == null || !zzd2.equals(zzd)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzhrVar.zzk()));
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzI3 = zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbd(), "_et");
        if (zzI3 == null || !zzI3.zze() || zzI3.zzf() <= 0) {
            return true;
        }
        long zzf = zzI3.zzf();
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzI4 = zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar2.zzbd(), "_et");
        if (zzI4 != null && zzI4.zzf() > 0) {
            zzf += zzI4.zzf();
        }
        zzp();
        zzpk.zzF(zzhrVar2, "_et", Long.valueOf(zzf));
        zzp();
        zzpk.zzF(zzhrVar, "_fr", 1L);
        return true;
    }

    private final void zzaK(com.google.android.gms.internal.measurement.zzhr zzhrVar, String str, String str2) {
        ArrayList arrayList = new ArrayList(zzhrVar.zza());
        int i = 0;
        while (true) {
            if (i >= arrayList.size()) {
                i = -1;
                break;
            } else if (str.equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i)).zzb())) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        double zzk = zzhrVar.zzc(i).zzk() * 1000000.0d;
        if (zzk == AudioStats.AUDIO_AMPLITUDE_NONE) {
            zzk = zzhrVar.zzc(i).zzf() * 1000000.0d;
        }
        if (zzk <= 9.223372036854776E18d && zzk >= -9.223372036854776E18d) {
            zzhrVar.zzj(i);
            com.google.android.gms.internal.measurement.zzhv zzn = com.google.android.gms.internal.measurement.zzhw.zzn();
            zzn.zzb(str);
            zzn.zzf(Math.round(zzk));
            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzn.zzbd());
            return;
        }
        zzaW().zze().zzc("Data lost. Purchase " + str + " is too big. appId", zzgu.zzl(str2), Double.valueOf(zzk));
    }

    private final boolean zzaL() {
        zzaX().zzg();
        zzu();
        return zzj().zzP() || !TextUtils.isEmpty(zzj().zzF());
    }

    private final void zzaM() {
        long max;
        long j;
        zzaX().zzg();
        zzu();
        if (this.zza > 0) {
            long abs = DurationKt.MILLIS_IN_HOUR - Math.abs(zzba().elapsedRealtime() - this.zza);
            if (abs > 0) {
                zzaW().zzk().zzb("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                zzk().zzb();
                zzl().zzf();
                return;
            }
            this.zza = 0L;
        }
        if (this.zzn.zzH() && zzaL()) {
            long currentTimeMillis = zzba().currentTimeMillis();
            zzd();
            long max2 = Math.max(0L, ((Long) zzfy.zzO.zzb(null)).longValue());
            boolean z = true;
            if (!zzj().zzR() && !zzj().zzG()) {
                z = false;
            }
            if (z) {
                String zzA = zzd().zzA();
                if (!TextUtils.isEmpty(zzA) && !".none.".equals(zzA)) {
                    zzd();
                    max = Math.max(0L, ((Long) zzfy.zzJ.zzb(null)).longValue());
                } else {
                    zzd();
                    max = Math.max(0L, ((Long) zzfy.zzI.zzb(null)).longValue());
                }
            } else {
                zzd();
                max = Math.max(0L, ((Long) zzfy.zzH.zzb(null)).longValue());
            }
            long zza = this.zzk.zzd.zza();
            long zza2 = this.zzk.zze.zza();
            long j2 = 0;
            boolean z2 = z;
            long max3 = Math.max(zzj().zzM(), zzj().zzO());
            if (max3 == 0) {
                j = 0;
            } else {
                long abs2 = currentTimeMillis - Math.abs(max3 - currentTimeMillis);
                long abs3 = currentTimeMillis - Math.abs(zza - currentTimeMillis);
                long abs4 = currentTimeMillis - Math.abs(zza2 - currentTimeMillis);
                j = max2 + abs2;
                long max4 = Math.max(abs3, abs4);
                if (z2 && max4 > 0) {
                    j = Math.min(abs2, max4) + max;
                }
                if (!zzp().zzs(max4, max)) {
                    j = max4 + max;
                }
                if (abs4 != 0 && abs4 >= abs2) {
                    int i = 0;
                    while (true) {
                        zzd();
                        if (i >= Math.min(20, Math.max(0, ((Integer) zzfy.zzQ.zzb(null)).intValue()))) {
                            j = 0;
                            break;
                        }
                        zzd();
                        j += Math.max(j2, ((Long) zzfy.zzP.zzb(null)).longValue()) * (1 << i);
                        if (j > abs4) {
                            break;
                        }
                        i++;
                        j2 = 0;
                    }
                }
                j2 = 0;
            }
            if (j == j2) {
                zzaW().zzk().zza("Next upload time is 0");
                zzk().zzb();
                zzl().zzf();
                return;
            }
            if (zzi().zzb()) {
                long zza3 = this.zzk.zzc.zza();
                zzd();
                long max5 = Math.max(0L, ((Long) zzfy.zzF.zzb(null)).longValue());
                if (!zzp().zzs(zza3, max5)) {
                    j = Math.max(j, zza3 + max5);
                }
                zzk().zzb();
                long currentTimeMillis2 = j - zzba().currentTimeMillis();
                if (currentTimeMillis2 <= 0) {
                    zzd();
                    currentTimeMillis2 = Math.max(0L, ((Long) zzfy.zzK.zzb(null)).longValue());
                    this.zzk.zzd.zzb(zzba().currentTimeMillis());
                }
                zzaW().zzk().zzb("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
                zzl().zzd(currentTimeMillis2);
                return;
            }
            zzaW().zzk().zza("No network");
            zzk().zza();
            zzl().zzf();
            return;
        }
        zzaW().zzk().zza("Nothing to upload or uploading impossible");
        zzk().zzb();
        zzl().zzf();
    }

    private final void zzaN() {
        zzaX().zzg();
        if (!this.zzu && !this.zzv && !this.zzw) {
            zzaW().zzk().zza("Stopping uploading service(s)");
            List list = this.zzq;
            if (list == null) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            ((List) Preconditions.checkNotNull(this.zzq)).clear();
            return;
        }
        zzaW().zzk().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw));
    }

    private final Boolean zzaO(zzh zzhVar) {
        try {
            long zzt = zzhVar.zzt();
            zzic zzicVar = this.zzn;
            if (zzt == SieveCacheKt.NodeMetaAndPreviousMask) {
                String str = Wrappers.packageManager(zzicVar.zzaZ()).getPackageInfo(zzhVar.zzc(), 0).versionName;
                String zzr = zzhVar.zzr();
                if (zzr != null && zzr.equals(str)) {
                    return true;
                }
            } else {
                if (zzhVar.zzt() == Wrappers.packageManager(zzicVar.zzaZ()).getPackageInfo(zzhVar.zzc(), 0).versionCode) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final zzr zzaP(String str) {
        zzh zzu = zzj().zzu(str);
        if (zzu == null || TextUtils.isEmpty(zzu.zzr())) {
            zzaW().zzj().zzb("No app data available; dropping", str);
            return null;
        }
        Boolean zzaO = zzaO(zzu);
        if (zzaO != null && !zzaO.booleanValue()) {
            zzaW().zzb().zzb("App version does not match; dropping. appId", zzgu.zzl(str));
            return null;
        }
        return new zzr(str, zzu.zzf(), zzu.zzr(), zzu.zzt(), zzu.zzv(), zzu.zzx(), zzu.zzz(), (String) null, zzu.zzD(), false, zzu.zzl(), 0L, 0, zzu.zzac(), false, zzu.zzae(), zzu.zzB(), zzu.zzag(), zzB(str).zzl(), "", (String) null, zzu.zzai(), zzu.zzak(), zzB(str).zzb(), zzx(str).zze(), zzu.zzao(), zzu.zzaw(), zzu.zzay(), zzu.zzaH(), 0L, zzu.zzaL(), 0L);
    }

    private final boolean zzaQ(String str, String str2) {
        zzbd zzf = zzj().zzf(str, str2);
        return zzf == null || zzf.zzc < 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzaR(Context context, Intent intent) {
        BroadcastOptions makeBasic;
        BroadcastOptions shareIdentityEnabled;
        Bundle bundle;
        if (Build.VERSION.SDK_INT < 34) {
            context.sendBroadcast(intent);
            return;
        }
        makeBasic = BroadcastOptions.makeBasic();
        shareIdentityEnabled = makeBasic.setShareIdentityEnabled(true);
        bundle = shareIdentityEnabled.toBundle();
        context.sendBroadcast(intent, null, bundle);
    }

    private static final boolean zzaS(zzr zzrVar) {
        return !TextUtils.isEmpty(zzrVar.zzb);
    }

    private static final zzos zzaT(zzos zzosVar) {
        if (zzosVar != null) {
            if (zzosVar.zzax()) {
                return zzosVar;
            }
            String valueOf = String.valueOf(zzosVar.getClass());
            String.valueOf(valueOf);
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(valueOf)));
        }
        throw new IllegalStateException("Upload Component not created");
    }

    private static final Boolean zzaU(zzr zzrVar) {
        Boolean bool = zzrVar.zzp;
        String str = zzrVar.zzC;
        if (!TextUtils.isEmpty(str)) {
            zzji zza = zze.zzc(str).zza();
            zzji zzjiVar = zzji.UNINITIALIZED;
            int ordinal = zza.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                return null;
            }
            if (ordinal == 2) {
                return true;
            }
            if (ordinal == 3) {
                return false;
            }
        }
        return bool;
    }

    final void zzA(String str, zzjl zzjlVar) {
        zzaX().zzg();
        zzu();
        this.zzC.put(str, zzjlVar);
        zzj().zzaa(str, zzjlVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzjl zzB(String str) {
        zzjl zzjlVar = zzjl.zza;
        zzaX().zzg();
        zzu();
        zzjl zzjlVar2 = (zzjl) this.zzC.get(str);
        if (zzjlVar2 == null) {
            zzjlVar2 = zzj().zzY(str);
            if (zzjlVar2 == null) {
                zzjlVar2 = zzjl.zza;
            }
            zzA(str, zzjlVar2);
        }
        return zzjlVar2;
    }

    final long zzC() {
        long currentTimeMillis = zzba().currentTimeMillis();
        zznn zznnVar = this.zzk;
        zznnVar.zzay();
        zznnVar.zzg();
        zzhe zzheVar = zznnVar.zzf;
        long zza = zzheVar.zza();
        if (zza == 0) {
            zza = zznnVar.zzu.zzk().zzf().nextInt(86400000) + 1;
            zzheVar.zzb(zza);
        }
        return ((((currentTimeMillis + zza) / 1000) / 60) / 60) / 24;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzD(zzbh zzbhVar, String str) {
        zzh zzu = zzj().zzu(str);
        if (zzu == null || TextUtils.isEmpty(zzu.zzr())) {
            zzaW().zzj().zzb("No app data available; dropping event", str);
            return;
        }
        Boolean zzaO = zzaO(zzu);
        if (zzaO == null) {
            if (!"_ui".equals(zzbhVar.zza)) {
                zzaW().zze().zzb("Could not find package. appId", zzgu.zzl(str));
            }
        } else if (!zzaO.booleanValue()) {
            zzaW().zzb().zzb("App version does not match; dropping event. appId", zzgu.zzl(str));
            return;
        }
        zzE(zzbhVar, new zzr(str, zzu.zzf(), zzu.zzr(), zzu.zzt(), zzu.zzv(), zzu.zzx(), zzu.zzz(), (String) null, zzu.zzD(), false, zzu.zzl(), 0L, 0, zzu.zzac(), false, zzu.zzae(), zzu.zzB(), zzu.zzag(), zzB(str).zzl(), "", (String) null, zzu.zzai(), zzu.zzak(), zzB(str).zzb(), zzx(str).zze(), zzu.zzao(), zzu.zzaw(), zzu.zzay(), zzu.zzaH(), 0L, zzu.zzaL(), 0L));
    }

    final void zzE(zzbh zzbhVar, zzr zzrVar) {
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzgv zza = zzgv.zza(zzbhVar);
        zzt().zzK(zza.zze, zzj().zzV(str));
        zzt().zzI(zza, zzd().zzd(str));
        zzbh zzb2 = zza.zzb();
        if (!zzd().zzp(null, zzfy.zzaZ) && "_cmp".equals(zzb2.zza)) {
            zzbf zzbfVar = zzb2.zzb;
            if ("referrer API v2".equals(zzbfVar.zzd("_cis"))) {
                String zzd = zzbfVar.zzd("gclid");
                if (!TextUtils.isEmpty(zzd)) {
                    zzad(new zzpl("_lgclid", zzb2.zzd, zzd, DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzrVar);
                }
            }
        }
        zzF(zzb2, zzrVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzF(zzbh zzbhVar, zzr zzrVar) {
        long j;
        List<zzah> zzt;
        List zzt2;
        List<zzah> zzt3;
        long j2;
        String str;
        Preconditions.checkNotNull(zzrVar);
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        zzaX().zzg();
        zzu();
        long j3 = zzbhVar.zzd;
        long j4 = zzbhVar.zze;
        zzgv zza = zzgv.zza(zzbhVar);
        zzaX().zzg();
        zzlu zzluVar = this.zzG;
        if (zzluVar == null || (str = this.zzH) == null || !str.equals(str2)) {
            zzluVar = null;
        }
        zzpp.zzay(zzluVar, zza.zze, false);
        zzbh zzb2 = zza.zzb();
        zzp();
        if (zzpk.zzG(zzb2, zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            List list = zzrVar.zzr;
            if (list != null) {
                String str3 = zzb2.zza;
                if (list.contains(str3)) {
                    Bundle zzf = zzb2.zzb.zzf();
                    j = j3;
                    zzf.putLong("ga_safelisted", 1L);
                    zzb2 = new zzbh(str3, new zzbf(zzf), zzb2.zzc, zzb2.zzd, zzb2.zze);
                } else {
                    zzaW().zzj().zzd("Dropping non-safelisted event. appId, event name, origin", str2, str3, zzb2.zzc);
                    return;
                }
            } else {
                j = j3;
            }
            zzj().zzb();
            try {
                String str4 = zzb2.zza;
                if ("_s".equals(str4) && !zzj().zzQ(str2, "_s") && zzb2.zzb.zzb("_sid").longValue() != 0) {
                    if (!zzj().zzQ(str2, "_f") && !zzj().zzQ(str2, "_v")) {
                        zzj().zzX(str2, Long.valueOf(zzba().currentTimeMillis() - 15000), "_sid", zzG(str2, zzb2));
                    }
                    zzj().zzX(str2, null, "_sid", zzG(str2, zzb2));
                }
                zzaw zzj = zzj();
                Preconditions.checkNotEmpty(str2);
                zzj.zzg();
                zzj.zzay();
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i < 0) {
                    zzj.zzu.zzaW().zze().zzc("Invalid time querying timed out conditional properties", zzgu.zzl(str2), Long.valueOf(j));
                    zzt = Collections.EMPTY_LIST;
                } else {
                    zzt = zzj.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
                }
                for (zzah zzahVar : zzt) {
                    if (zzahVar != null) {
                        zzaW().zzk().zzd("User property timed out", zzahVar.zza, this.zzn.zzl().zzc(zzahVar.zzc.zzb), zzahVar.zzc.zza());
                        zzbh zzbhVar2 = zzahVar.zzg;
                        if (zzbhVar2 != null) {
                            j2 = j;
                            zzH(new zzbh(zzbhVar2, j2, j4), zzrVar);
                        } else {
                            j2 = j;
                        }
                        zzj().zzr(str2, zzahVar.zzc.zzb);
                        j = j2;
                    }
                }
                long j5 = j;
                zzaw zzj2 = zzj();
                Preconditions.checkNotEmpty(str2);
                zzj2.zzg();
                zzj2.zzay();
                if (i < 0) {
                    zzj2.zzu.zzaW().zze().zzc("Invalid time querying expired conditional properties", zzgu.zzl(str2), Long.valueOf(j5));
                    zzt2 = Collections.EMPTY_LIST;
                } else {
                    zzt2 = zzj2.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j5)});
                }
                ArrayList arrayList = new ArrayList(zzt2.size());
                Iterator it = zzt2.iterator();
                while (it.hasNext()) {
                    zzah zzahVar2 = (zzah) it.next();
                    if (zzahVar2 != null) {
                        Iterator it2 = it;
                        int i2 = i;
                        zzaW().zzk().zzd("User property expired", zzahVar2.zza, this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                        zzj().zzk(str2, zzahVar2.zzc.zzb);
                        zzbh zzbhVar3 = zzahVar2.zzk;
                        if (zzbhVar3 != null) {
                            arrayList.add(zzbhVar3);
                        }
                        zzj().zzr(str2, zzahVar2.zzc.zzb);
                        it = it2;
                        i = i2;
                    }
                }
                int i3 = i;
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    zzH(new zzbh((zzbh) it3.next(), j5, j4), zzrVar);
                    j4 = j4;
                }
                long j6 = j4;
                zzaw zzj3 = zzj();
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str4);
                zzj3.zzg();
                zzj3.zzay();
                if (i3 < 0) {
                    zzic zzicVar = zzj3.zzu;
                    zzicVar.zzaW().zze().zzd("Invalid time querying triggered conditional properties", zzgu.zzl(str2), zzicVar.zzl().zza(str4), Long.valueOf(j5));
                    zzt3 = Collections.EMPTY_LIST;
                } else {
                    zzt3 = zzj3.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str4, String.valueOf(j5)});
                }
                ArrayList arrayList2 = new ArrayList(zzt3.size());
                for (zzah zzahVar3 : zzt3) {
                    if (zzahVar3 != null) {
                        zzpl zzplVar = zzahVar3.zzc;
                        long j7 = j5;
                        zzpn zzpnVar = new zzpn((String) Preconditions.checkNotNull(zzahVar3.zza), zzahVar3.zzb, zzplVar.zzb, j7, Preconditions.checkNotNull(zzplVar.zza()));
                        j5 = j7;
                        if (zzj().zzl(zzpnVar)) {
                            zzaW().zzk().zzd("User property triggered", zzahVar3.zza, this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                        } else {
                            zzaW().zzb().zzd("Too many active user properties, ignoring", zzgu.zzl(zzahVar3.zza), this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                        }
                        zzbh zzbhVar4 = zzahVar3.zzi;
                        if (zzbhVar4 != null) {
                            arrayList2.add(zzbhVar4);
                        }
                        zzahVar3.zzc = new zzpl(zzpnVar);
                        zzahVar3.zze = true;
                        zzj().zzp(zzahVar3);
                    }
                }
                zzH(zzb2, zzrVar);
                Iterator it4 = arrayList2.iterator();
                while (it4.hasNext()) {
                    long j8 = j6;
                    zzH(new zzbh((zzbh) it4.next(), j5, j8), zzrVar);
                    j6 = j8;
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    final Bundle zzG(String str, zzbh zzbhVar) {
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", zzbhVar.zzb.zzb("_sid").longValue());
        zzpn zzm = zzj().zzm(str, "_sno");
        if (zzm != null) {
            Object obj = zzm.zze;
            if (obj instanceof Long) {
                bundle.putLong("_sno", ((Long) obj).longValue());
            }
        }
        return bundle;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:321|(10:326|327|328|(1:330)|58|(0)(0)|61|(0)(0)|67|68)|331|332|333|334|335|327|328|(0)|58|(0)(0)|61|(0)(0)|67|68) */
    /* JADX WARN: Can't wrap try/catch for region: R(63:(2:70|(3:72|(1:74)|75))|76|(2:78|(3:80|(1:82)|83))(1:292)|84|85|(1:87)|88|(2:92|(1:94))|95|96|97|98|99|(1:101)|102|(2:104|(1:110)(1:109))(1:288)|111|(1:113)|114|(1:116)|117|(1:119)|120|(1:122)|123|(1:125)|126|(1:128)|129|(1:287)(6:133|(1:137)|138|(1:140)(1:286)|141|(1:143)(15:257|(1:259)(1:285)|260|(1:262)(1:284)|263|(1:265)(1:283)|266|(1:268)(1:282)|269|(1:271)(1:281)|272|(1:274)(1:280)|275|(1:277)(1:279)|278))|144|(1:146)|147|(1:149)|150|(1:154)|155|(2:159|(28:162|(1:164)|165|(28:173|(1:175)(1:254)|176|(1:178)|179|180|(2:182|(1:184))|185|(3:187|(1:189)|190)(1:253)|191|(1:195)|196|(1:198)|199|(4:202|(2:212|213)(2:206|(2:208|209)(1:211))|210|200)|214|215|216|217|218|(2:219|(2:221|(1:223)(1:238))(3:239|240|(1:245)(1:244)))|225|226|227|(1:229)(2:234|235)|230|231|232)|255|180|(0)|185|(0)(0)|191|(2:193|195)|196|(0)|199|(1:200)|214|215|216|217|218|(3:219|(0)(0)|238)|225|226|227|(0)(0)|230|231|232))|256|255|180|(0)|185|(0)(0)|191|(0)|196|(0)|199|(1:200)|214|215|216|217|218|(3:219|(0)(0)|238)|225|226|227|(0)(0)|230|231|232) */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x09ab, code lost:
    
        r13 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0a6c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0a6d, code lost:
    
        r2.zzu.zzaW().zzb().zzc("Error storing raw event. appId", com.google.android.gms.measurement.internal.zzgu.zzl(r8.zza), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x0a9c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0a9d, code lost:
    
        zzaW().zzb().zzc("Data loss. Failed to insert raw event metadata. appId", com.google.android.gms.measurement.internal.zzgu.zzl(r8.zzK()), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x028b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x028c, code lost:
    
        r13.zzu.zzaW().zzb().zzc("Error pruning currencies. appId", com.google.android.gms.measurement.internal.zzgu.zzl(r10), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0821 A[Catch: all -> 0x0ae3, TryCatch #0 {all -> 0x0ae3, blocks: (B:43:0x0155, B:46:0x0164, B:48:0x016c, B:52:0x0176, B:58:0x02ef, B:61:0x0325, B:63:0x0366, B:65:0x036b, B:66:0x0382, B:70:0x038d, B:72:0x03a6, B:74:0x03ab, B:75:0x03c2, B:78:0x03e4, B:82:0x0407, B:83:0x041e, B:84:0x042a, B:87:0x0447, B:88:0x045b, B:90:0x0463, B:92:0x046f, B:94:0x0475, B:95:0x047c, B:97:0x0489, B:101:0x04cb, B:102:0x04e0, B:104:0x050a, B:107:0x0521, B:109:0x052b, B:110:0x0566, B:111:0x0591, B:113:0x05c9, B:114:0x05cc, B:116:0x05d4, B:117:0x05d7, B:119:0x05df, B:120:0x05e2, B:122:0x05ea, B:123:0x05ed, B:125:0x05f6, B:126:0x05fa, B:128:0x0608, B:129:0x060b, B:131:0x063d, B:133:0x0647, B:137:0x065e, B:141:0x066b, B:144:0x06e2, B:146:0x06e8, B:147:0x06eb, B:149:0x06ff, B:150:0x0709, B:152:0x0716, B:154:0x0720, B:155:0x0723, B:157:0x073f, B:159:0x0743, B:162:0x0757, B:164:0x0762, B:165:0x076d, B:167:0x0779, B:169:0x0785, B:171:0x078f, B:173:0x0795, B:175:0x07a7, B:176:0x07c5, B:178:0x07cb, B:179:0x07d4, B:180:0x07e7, B:182:0x0821, B:184:0x082b, B:185:0x082e, B:187:0x0838, B:189:0x0854, B:190:0x085d, B:191:0x0893, B:193:0x089b, B:195:0x08a5, B:196:0x08b2, B:198:0x08bc, B:199:0x08c9, B:200:0x08d2, B:202:0x08d8, B:204:0x0914, B:206:0x091e, B:208:0x0930, B:215:0x093b, B:217:0x0980, B:218:0x098b, B:219:0x0998, B:221:0x099e, B:225:0x09ec, B:227:0x0a42, B:229:0x0a53, B:230:0x0ab2, B:235:0x0a69, B:237:0x0a6d, B:240:0x09ad, B:242:0x09d9, B:248:0x0a84, B:249:0x0a9b, B:252:0x0a9d, B:257:0x0674, B:260:0x0681, B:263:0x068f, B:266:0x069d, B:269:0x06ab, B:272:0x06b9, B:275:0x06c5, B:278:0x06d3, B:288:0x0583, B:291:0x04b2, B:293:0x0303, B:294:0x030a, B:296:0x0310, B:299:0x031f, B:304:0x018a, B:307:0x019a, B:309:0x01af, B:314:0x01cb, B:317:0x01ff, B:319:0x0205, B:321:0x0213, B:323:0x0228, B:326:0x022f, B:328:0x02b8, B:330:0x02c2, B:331:0x0256, B:333:0x0278, B:335:0x02a0, B:338:0x028c, B:339:0x01d7, B:341:0x01f5), top: B:42:0x0155, inners: #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0838 A[Catch: all -> 0x0ae3, TryCatch #0 {all -> 0x0ae3, blocks: (B:43:0x0155, B:46:0x0164, B:48:0x016c, B:52:0x0176, B:58:0x02ef, B:61:0x0325, B:63:0x0366, B:65:0x036b, B:66:0x0382, B:70:0x038d, B:72:0x03a6, B:74:0x03ab, B:75:0x03c2, B:78:0x03e4, B:82:0x0407, B:83:0x041e, B:84:0x042a, B:87:0x0447, B:88:0x045b, B:90:0x0463, B:92:0x046f, B:94:0x0475, B:95:0x047c, B:97:0x0489, B:101:0x04cb, B:102:0x04e0, B:104:0x050a, B:107:0x0521, B:109:0x052b, B:110:0x0566, B:111:0x0591, B:113:0x05c9, B:114:0x05cc, B:116:0x05d4, B:117:0x05d7, B:119:0x05df, B:120:0x05e2, B:122:0x05ea, B:123:0x05ed, B:125:0x05f6, B:126:0x05fa, B:128:0x0608, B:129:0x060b, B:131:0x063d, B:133:0x0647, B:137:0x065e, B:141:0x066b, B:144:0x06e2, B:146:0x06e8, B:147:0x06eb, B:149:0x06ff, B:150:0x0709, B:152:0x0716, B:154:0x0720, B:155:0x0723, B:157:0x073f, B:159:0x0743, B:162:0x0757, B:164:0x0762, B:165:0x076d, B:167:0x0779, B:169:0x0785, B:171:0x078f, B:173:0x0795, B:175:0x07a7, B:176:0x07c5, B:178:0x07cb, B:179:0x07d4, B:180:0x07e7, B:182:0x0821, B:184:0x082b, B:185:0x082e, B:187:0x0838, B:189:0x0854, B:190:0x085d, B:191:0x0893, B:193:0x089b, B:195:0x08a5, B:196:0x08b2, B:198:0x08bc, B:199:0x08c9, B:200:0x08d2, B:202:0x08d8, B:204:0x0914, B:206:0x091e, B:208:0x0930, B:215:0x093b, B:217:0x0980, B:218:0x098b, B:219:0x0998, B:221:0x099e, B:225:0x09ec, B:227:0x0a42, B:229:0x0a53, B:230:0x0ab2, B:235:0x0a69, B:237:0x0a6d, B:240:0x09ad, B:242:0x09d9, B:248:0x0a84, B:249:0x0a9b, B:252:0x0a9d, B:257:0x0674, B:260:0x0681, B:263:0x068f, B:266:0x069d, B:269:0x06ab, B:272:0x06b9, B:275:0x06c5, B:278:0x06d3, B:288:0x0583, B:291:0x04b2, B:293:0x0303, B:294:0x030a, B:296:0x0310, B:299:0x031f, B:304:0x018a, B:307:0x019a, B:309:0x01af, B:314:0x01cb, B:317:0x01ff, B:319:0x0205, B:321:0x0213, B:323:0x0228, B:326:0x022f, B:328:0x02b8, B:330:0x02c2, B:331:0x0256, B:333:0x0278, B:335:0x02a0, B:338:0x028c, B:339:0x01d7, B:341:0x01f5), top: B:42:0x0155, inners: #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x089b A[Catch: all -> 0x0ae3, TryCatch #0 {all -> 0x0ae3, blocks: (B:43:0x0155, B:46:0x0164, B:48:0x016c, B:52:0x0176, B:58:0x02ef, B:61:0x0325, B:63:0x0366, B:65:0x036b, B:66:0x0382, B:70:0x038d, B:72:0x03a6, B:74:0x03ab, B:75:0x03c2, B:78:0x03e4, B:82:0x0407, B:83:0x041e, B:84:0x042a, B:87:0x0447, B:88:0x045b, B:90:0x0463, B:92:0x046f, B:94:0x0475, B:95:0x047c, B:97:0x0489, B:101:0x04cb, B:102:0x04e0, B:104:0x050a, B:107:0x0521, B:109:0x052b, B:110:0x0566, B:111:0x0591, B:113:0x05c9, B:114:0x05cc, B:116:0x05d4, B:117:0x05d7, B:119:0x05df, B:120:0x05e2, B:122:0x05ea, B:123:0x05ed, B:125:0x05f6, B:126:0x05fa, B:128:0x0608, B:129:0x060b, B:131:0x063d, B:133:0x0647, B:137:0x065e, B:141:0x066b, B:144:0x06e2, B:146:0x06e8, B:147:0x06eb, B:149:0x06ff, B:150:0x0709, B:152:0x0716, B:154:0x0720, B:155:0x0723, B:157:0x073f, B:159:0x0743, B:162:0x0757, B:164:0x0762, B:165:0x076d, B:167:0x0779, B:169:0x0785, B:171:0x078f, B:173:0x0795, B:175:0x07a7, B:176:0x07c5, B:178:0x07cb, B:179:0x07d4, B:180:0x07e7, B:182:0x0821, B:184:0x082b, B:185:0x082e, B:187:0x0838, B:189:0x0854, B:190:0x085d, B:191:0x0893, B:193:0x089b, B:195:0x08a5, B:196:0x08b2, B:198:0x08bc, B:199:0x08c9, B:200:0x08d2, B:202:0x08d8, B:204:0x0914, B:206:0x091e, B:208:0x0930, B:215:0x093b, B:217:0x0980, B:218:0x098b, B:219:0x0998, B:221:0x099e, B:225:0x09ec, B:227:0x0a42, B:229:0x0a53, B:230:0x0ab2, B:235:0x0a69, B:237:0x0a6d, B:240:0x09ad, B:242:0x09d9, B:248:0x0a84, B:249:0x0a9b, B:252:0x0a9d, B:257:0x0674, B:260:0x0681, B:263:0x068f, B:266:0x069d, B:269:0x06ab, B:272:0x06b9, B:275:0x06c5, B:278:0x06d3, B:288:0x0583, B:291:0x04b2, B:293:0x0303, B:294:0x030a, B:296:0x0310, B:299:0x031f, B:304:0x018a, B:307:0x019a, B:309:0x01af, B:314:0x01cb, B:317:0x01ff, B:319:0x0205, B:321:0x0213, B:323:0x0228, B:326:0x022f, B:328:0x02b8, B:330:0x02c2, B:331:0x0256, B:333:0x0278, B:335:0x02a0, B:338:0x028c, B:339:0x01d7, B:341:0x01f5), top: B:42:0x0155, inners: #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x08bc A[Catch: all -> 0x0ae3, TryCatch #0 {all -> 0x0ae3, blocks: (B:43:0x0155, B:46:0x0164, B:48:0x016c, B:52:0x0176, B:58:0x02ef, B:61:0x0325, B:63:0x0366, B:65:0x036b, B:66:0x0382, B:70:0x038d, B:72:0x03a6, B:74:0x03ab, B:75:0x03c2, B:78:0x03e4, B:82:0x0407, B:83:0x041e, B:84:0x042a, B:87:0x0447, B:88:0x045b, B:90:0x0463, B:92:0x046f, B:94:0x0475, B:95:0x047c, B:97:0x0489, B:101:0x04cb, B:102:0x04e0, B:104:0x050a, B:107:0x0521, B:109:0x052b, B:110:0x0566, B:111:0x0591, B:113:0x05c9, B:114:0x05cc, B:116:0x05d4, B:117:0x05d7, B:119:0x05df, B:120:0x05e2, B:122:0x05ea, B:123:0x05ed, B:125:0x05f6, B:126:0x05fa, B:128:0x0608, B:129:0x060b, B:131:0x063d, B:133:0x0647, B:137:0x065e, B:141:0x066b, B:144:0x06e2, B:146:0x06e8, B:147:0x06eb, B:149:0x06ff, B:150:0x0709, B:152:0x0716, B:154:0x0720, B:155:0x0723, B:157:0x073f, B:159:0x0743, B:162:0x0757, B:164:0x0762, B:165:0x076d, B:167:0x0779, B:169:0x0785, B:171:0x078f, B:173:0x0795, B:175:0x07a7, B:176:0x07c5, B:178:0x07cb, B:179:0x07d4, B:180:0x07e7, B:182:0x0821, B:184:0x082b, B:185:0x082e, B:187:0x0838, B:189:0x0854, B:190:0x085d, B:191:0x0893, B:193:0x089b, B:195:0x08a5, B:196:0x08b2, B:198:0x08bc, B:199:0x08c9, B:200:0x08d2, B:202:0x08d8, B:204:0x0914, B:206:0x091e, B:208:0x0930, B:215:0x093b, B:217:0x0980, B:218:0x098b, B:219:0x0998, B:221:0x099e, B:225:0x09ec, B:227:0x0a42, B:229:0x0a53, B:230:0x0ab2, B:235:0x0a69, B:237:0x0a6d, B:240:0x09ad, B:242:0x09d9, B:248:0x0a84, B:249:0x0a9b, B:252:0x0a9d, B:257:0x0674, B:260:0x0681, B:263:0x068f, B:266:0x069d, B:269:0x06ab, B:272:0x06b9, B:275:0x06c5, B:278:0x06d3, B:288:0x0583, B:291:0x04b2, B:293:0x0303, B:294:0x030a, B:296:0x0310, B:299:0x031f, B:304:0x018a, B:307:0x019a, B:309:0x01af, B:314:0x01cb, B:317:0x01ff, B:319:0x0205, B:321:0x0213, B:323:0x0228, B:326:0x022f, B:328:0x02b8, B:330:0x02c2, B:331:0x0256, B:333:0x0278, B:335:0x02a0, B:338:0x028c, B:339:0x01d7, B:341:0x01f5), top: B:42:0x0155, inners: #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x08d8 A[Catch: all -> 0x0ae3, TryCatch #0 {all -> 0x0ae3, blocks: (B:43:0x0155, B:46:0x0164, B:48:0x016c, B:52:0x0176, B:58:0x02ef, B:61:0x0325, B:63:0x0366, B:65:0x036b, B:66:0x0382, B:70:0x038d, B:72:0x03a6, B:74:0x03ab, B:75:0x03c2, B:78:0x03e4, B:82:0x0407, B:83:0x041e, B:84:0x042a, B:87:0x0447, B:88:0x045b, B:90:0x0463, B:92:0x046f, B:94:0x0475, B:95:0x047c, B:97:0x0489, B:101:0x04cb, B:102:0x04e0, B:104:0x050a, B:107:0x0521, B:109:0x052b, B:110:0x0566, B:111:0x0591, B:113:0x05c9, B:114:0x05cc, B:116:0x05d4, B:117:0x05d7, B:119:0x05df, B:120:0x05e2, B:122:0x05ea, B:123:0x05ed, B:125:0x05f6, B:126:0x05fa, B:128:0x0608, B:129:0x060b, B:131:0x063d, B:133:0x0647, B:137:0x065e, B:141:0x066b, B:144:0x06e2, B:146:0x06e8, B:147:0x06eb, B:149:0x06ff, B:150:0x0709, B:152:0x0716, B:154:0x0720, B:155:0x0723, B:157:0x073f, B:159:0x0743, B:162:0x0757, B:164:0x0762, B:165:0x076d, B:167:0x0779, B:169:0x0785, B:171:0x078f, B:173:0x0795, B:175:0x07a7, B:176:0x07c5, B:178:0x07cb, B:179:0x07d4, B:180:0x07e7, B:182:0x0821, B:184:0x082b, B:185:0x082e, B:187:0x0838, B:189:0x0854, B:190:0x085d, B:191:0x0893, B:193:0x089b, B:195:0x08a5, B:196:0x08b2, B:198:0x08bc, B:199:0x08c9, B:200:0x08d2, B:202:0x08d8, B:204:0x0914, B:206:0x091e, B:208:0x0930, B:215:0x093b, B:217:0x0980, B:218:0x098b, B:219:0x0998, B:221:0x099e, B:225:0x09ec, B:227:0x0a42, B:229:0x0a53, B:230:0x0ab2, B:235:0x0a69, B:237:0x0a6d, B:240:0x09ad, B:242:0x09d9, B:248:0x0a84, B:249:0x0a9b, B:252:0x0a9d, B:257:0x0674, B:260:0x0681, B:263:0x068f, B:266:0x069d, B:269:0x06ab, B:272:0x06b9, B:275:0x06c5, B:278:0x06d3, B:288:0x0583, B:291:0x04b2, B:293:0x0303, B:294:0x030a, B:296:0x0310, B:299:0x031f, B:304:0x018a, B:307:0x019a, B:309:0x01af, B:314:0x01cb, B:317:0x01ff, B:319:0x0205, B:321:0x0213, B:323:0x0228, B:326:0x022f, B:328:0x02b8, B:330:0x02c2, B:331:0x0256, B:333:0x0278, B:335:0x02a0, B:338:0x028c, B:339:0x01d7, B:341:0x01f5), top: B:42:0x0155, inners: #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x099e A[Catch: all -> 0x0ae3, TryCatch #0 {all -> 0x0ae3, blocks: (B:43:0x0155, B:46:0x0164, B:48:0x016c, B:52:0x0176, B:58:0x02ef, B:61:0x0325, B:63:0x0366, B:65:0x036b, B:66:0x0382, B:70:0x038d, B:72:0x03a6, B:74:0x03ab, B:75:0x03c2, B:78:0x03e4, B:82:0x0407, B:83:0x041e, B:84:0x042a, B:87:0x0447, B:88:0x045b, B:90:0x0463, B:92:0x046f, B:94:0x0475, B:95:0x047c, B:97:0x0489, B:101:0x04cb, B:102:0x04e0, B:104:0x050a, B:107:0x0521, B:109:0x052b, B:110:0x0566, B:111:0x0591, B:113:0x05c9, B:114:0x05cc, B:116:0x05d4, B:117:0x05d7, B:119:0x05df, B:120:0x05e2, B:122:0x05ea, B:123:0x05ed, B:125:0x05f6, B:126:0x05fa, B:128:0x0608, B:129:0x060b, B:131:0x063d, B:133:0x0647, B:137:0x065e, B:141:0x066b, B:144:0x06e2, B:146:0x06e8, B:147:0x06eb, B:149:0x06ff, B:150:0x0709, B:152:0x0716, B:154:0x0720, B:155:0x0723, B:157:0x073f, B:159:0x0743, B:162:0x0757, B:164:0x0762, B:165:0x076d, B:167:0x0779, B:169:0x0785, B:171:0x078f, B:173:0x0795, B:175:0x07a7, B:176:0x07c5, B:178:0x07cb, B:179:0x07d4, B:180:0x07e7, B:182:0x0821, B:184:0x082b, B:185:0x082e, B:187:0x0838, B:189:0x0854, B:190:0x085d, B:191:0x0893, B:193:0x089b, B:195:0x08a5, B:196:0x08b2, B:198:0x08bc, B:199:0x08c9, B:200:0x08d2, B:202:0x08d8, B:204:0x0914, B:206:0x091e, B:208:0x0930, B:215:0x093b, B:217:0x0980, B:218:0x098b, B:219:0x0998, B:221:0x099e, B:225:0x09ec, B:227:0x0a42, B:229:0x0a53, B:230:0x0ab2, B:235:0x0a69, B:237:0x0a6d, B:240:0x09ad, B:242:0x09d9, B:248:0x0a84, B:249:0x0a9b, B:252:0x0a9d, B:257:0x0674, B:260:0x0681, B:263:0x068f, B:266:0x069d, B:269:0x06ab, B:272:0x06b9, B:275:0x06c5, B:278:0x06d3, B:288:0x0583, B:291:0x04b2, B:293:0x0303, B:294:0x030a, B:296:0x0310, B:299:0x031f, B:304:0x018a, B:307:0x019a, B:309:0x01af, B:314:0x01cb, B:317:0x01ff, B:319:0x0205, B:321:0x0213, B:323:0x0228, B:326:0x022f, B:328:0x02b8, B:330:0x02c2, B:331:0x0256, B:333:0x0278, B:335:0x02a0, B:338:0x028c, B:339:0x01d7, B:341:0x01f5), top: B:42:0x0155, inners: #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0a53 A[Catch: SQLiteException -> 0x0a6c, all -> 0x0ae3, TRY_LEAVE, TryCatch #3 {SQLiteException -> 0x0a6c, blocks: (B:227:0x0a42, B:229:0x0a53), top: B:226:0x0a42, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0a67  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x09ad A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0892  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0303 A[Catch: all -> 0x0ae3, TryCatch #0 {all -> 0x0ae3, blocks: (B:43:0x0155, B:46:0x0164, B:48:0x016c, B:52:0x0176, B:58:0x02ef, B:61:0x0325, B:63:0x0366, B:65:0x036b, B:66:0x0382, B:70:0x038d, B:72:0x03a6, B:74:0x03ab, B:75:0x03c2, B:78:0x03e4, B:82:0x0407, B:83:0x041e, B:84:0x042a, B:87:0x0447, B:88:0x045b, B:90:0x0463, B:92:0x046f, B:94:0x0475, B:95:0x047c, B:97:0x0489, B:101:0x04cb, B:102:0x04e0, B:104:0x050a, B:107:0x0521, B:109:0x052b, B:110:0x0566, B:111:0x0591, B:113:0x05c9, B:114:0x05cc, B:116:0x05d4, B:117:0x05d7, B:119:0x05df, B:120:0x05e2, B:122:0x05ea, B:123:0x05ed, B:125:0x05f6, B:126:0x05fa, B:128:0x0608, B:129:0x060b, B:131:0x063d, B:133:0x0647, B:137:0x065e, B:141:0x066b, B:144:0x06e2, B:146:0x06e8, B:147:0x06eb, B:149:0x06ff, B:150:0x0709, B:152:0x0716, B:154:0x0720, B:155:0x0723, B:157:0x073f, B:159:0x0743, B:162:0x0757, B:164:0x0762, B:165:0x076d, B:167:0x0779, B:169:0x0785, B:171:0x078f, B:173:0x0795, B:175:0x07a7, B:176:0x07c5, B:178:0x07cb, B:179:0x07d4, B:180:0x07e7, B:182:0x0821, B:184:0x082b, B:185:0x082e, B:187:0x0838, B:189:0x0854, B:190:0x085d, B:191:0x0893, B:193:0x089b, B:195:0x08a5, B:196:0x08b2, B:198:0x08bc, B:199:0x08c9, B:200:0x08d2, B:202:0x08d8, B:204:0x0914, B:206:0x091e, B:208:0x0930, B:215:0x093b, B:217:0x0980, B:218:0x098b, B:219:0x0998, B:221:0x099e, B:225:0x09ec, B:227:0x0a42, B:229:0x0a53, B:230:0x0ab2, B:235:0x0a69, B:237:0x0a6d, B:240:0x09ad, B:242:0x09d9, B:248:0x0a84, B:249:0x0a9b, B:252:0x0a9d, B:257:0x0674, B:260:0x0681, B:263:0x068f, B:266:0x069d, B:269:0x06ab, B:272:0x06b9, B:275:0x06c5, B:278:0x06d3, B:288:0x0583, B:291:0x04b2, B:293:0x0303, B:294:0x030a, B:296:0x0310, B:299:0x031f, B:304:0x018a, B:307:0x019a, B:309:0x01af, B:314:0x01cb, B:317:0x01ff, B:319:0x0205, B:321:0x0213, B:323:0x0228, B:326:0x022f, B:328:0x02b8, B:330:0x02c2, B:331:0x0256, B:333:0x0278, B:335:0x02a0, B:338:0x028c, B:339:0x01d7, B:341:0x01f5), top: B:42:0x0155, inners: #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x019a A[Catch: all -> 0x0ae3, TRY_ENTER, TryCatch #0 {all -> 0x0ae3, blocks: (B:43:0x0155, B:46:0x0164, B:48:0x016c, B:52:0x0176, B:58:0x02ef, B:61:0x0325, B:63:0x0366, B:65:0x036b, B:66:0x0382, B:70:0x038d, B:72:0x03a6, B:74:0x03ab, B:75:0x03c2, B:78:0x03e4, B:82:0x0407, B:83:0x041e, B:84:0x042a, B:87:0x0447, B:88:0x045b, B:90:0x0463, B:92:0x046f, B:94:0x0475, B:95:0x047c, B:97:0x0489, B:101:0x04cb, B:102:0x04e0, B:104:0x050a, B:107:0x0521, B:109:0x052b, B:110:0x0566, B:111:0x0591, B:113:0x05c9, B:114:0x05cc, B:116:0x05d4, B:117:0x05d7, B:119:0x05df, B:120:0x05e2, B:122:0x05ea, B:123:0x05ed, B:125:0x05f6, B:126:0x05fa, B:128:0x0608, B:129:0x060b, B:131:0x063d, B:133:0x0647, B:137:0x065e, B:141:0x066b, B:144:0x06e2, B:146:0x06e8, B:147:0x06eb, B:149:0x06ff, B:150:0x0709, B:152:0x0716, B:154:0x0720, B:155:0x0723, B:157:0x073f, B:159:0x0743, B:162:0x0757, B:164:0x0762, B:165:0x076d, B:167:0x0779, B:169:0x0785, B:171:0x078f, B:173:0x0795, B:175:0x07a7, B:176:0x07c5, B:178:0x07cb, B:179:0x07d4, B:180:0x07e7, B:182:0x0821, B:184:0x082b, B:185:0x082e, B:187:0x0838, B:189:0x0854, B:190:0x085d, B:191:0x0893, B:193:0x089b, B:195:0x08a5, B:196:0x08b2, B:198:0x08bc, B:199:0x08c9, B:200:0x08d2, B:202:0x08d8, B:204:0x0914, B:206:0x091e, B:208:0x0930, B:215:0x093b, B:217:0x0980, B:218:0x098b, B:219:0x0998, B:221:0x099e, B:225:0x09ec, B:227:0x0a42, B:229:0x0a53, B:230:0x0ab2, B:235:0x0a69, B:237:0x0a6d, B:240:0x09ad, B:242:0x09d9, B:248:0x0a84, B:249:0x0a9b, B:252:0x0a9d, B:257:0x0674, B:260:0x0681, B:263:0x068f, B:266:0x069d, B:269:0x06ab, B:272:0x06b9, B:275:0x06c5, B:278:0x06d3, B:288:0x0583, B:291:0x04b2, B:293:0x0303, B:294:0x030a, B:296:0x0310, B:299:0x031f, B:304:0x018a, B:307:0x019a, B:309:0x01af, B:314:0x01cb, B:317:0x01ff, B:319:0x0205, B:321:0x0213, B:323:0x0228, B:326:0x022f, B:328:0x02b8, B:330:0x02c2, B:331:0x0256, B:333:0x0278, B:335:0x02a0, B:338:0x028c, B:339:0x01d7, B:341:0x01f5), top: B:42:0x0155, inners: #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0205 A[Catch: all -> 0x0ae3, TryCatch #0 {all -> 0x0ae3, blocks: (B:43:0x0155, B:46:0x0164, B:48:0x016c, B:52:0x0176, B:58:0x02ef, B:61:0x0325, B:63:0x0366, B:65:0x036b, B:66:0x0382, B:70:0x038d, B:72:0x03a6, B:74:0x03ab, B:75:0x03c2, B:78:0x03e4, B:82:0x0407, B:83:0x041e, B:84:0x042a, B:87:0x0447, B:88:0x045b, B:90:0x0463, B:92:0x046f, B:94:0x0475, B:95:0x047c, B:97:0x0489, B:101:0x04cb, B:102:0x04e0, B:104:0x050a, B:107:0x0521, B:109:0x052b, B:110:0x0566, B:111:0x0591, B:113:0x05c9, B:114:0x05cc, B:116:0x05d4, B:117:0x05d7, B:119:0x05df, B:120:0x05e2, B:122:0x05ea, B:123:0x05ed, B:125:0x05f6, B:126:0x05fa, B:128:0x0608, B:129:0x060b, B:131:0x063d, B:133:0x0647, B:137:0x065e, B:141:0x066b, B:144:0x06e2, B:146:0x06e8, B:147:0x06eb, B:149:0x06ff, B:150:0x0709, B:152:0x0716, B:154:0x0720, B:155:0x0723, B:157:0x073f, B:159:0x0743, B:162:0x0757, B:164:0x0762, B:165:0x076d, B:167:0x0779, B:169:0x0785, B:171:0x078f, B:173:0x0795, B:175:0x07a7, B:176:0x07c5, B:178:0x07cb, B:179:0x07d4, B:180:0x07e7, B:182:0x0821, B:184:0x082b, B:185:0x082e, B:187:0x0838, B:189:0x0854, B:190:0x085d, B:191:0x0893, B:193:0x089b, B:195:0x08a5, B:196:0x08b2, B:198:0x08bc, B:199:0x08c9, B:200:0x08d2, B:202:0x08d8, B:204:0x0914, B:206:0x091e, B:208:0x0930, B:215:0x093b, B:217:0x0980, B:218:0x098b, B:219:0x0998, B:221:0x099e, B:225:0x09ec, B:227:0x0a42, B:229:0x0a53, B:230:0x0ab2, B:235:0x0a69, B:237:0x0a6d, B:240:0x09ad, B:242:0x09d9, B:248:0x0a84, B:249:0x0a9b, B:252:0x0a9d, B:257:0x0674, B:260:0x0681, B:263:0x068f, B:266:0x069d, B:269:0x06ab, B:272:0x06b9, B:275:0x06c5, B:278:0x06d3, B:288:0x0583, B:291:0x04b2, B:293:0x0303, B:294:0x030a, B:296:0x0310, B:299:0x031f, B:304:0x018a, B:307:0x019a, B:309:0x01af, B:314:0x01cb, B:317:0x01ff, B:319:0x0205, B:321:0x0213, B:323:0x0228, B:326:0x022f, B:328:0x02b8, B:330:0x02c2, B:331:0x0256, B:333:0x0278, B:335:0x02a0, B:338:0x028c, B:339:0x01d7, B:341:0x01f5), top: B:42:0x0155, inners: #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:330:0x02c2 A[Catch: all -> 0x0ae3, TryCatch #0 {all -> 0x0ae3, blocks: (B:43:0x0155, B:46:0x0164, B:48:0x016c, B:52:0x0176, B:58:0x02ef, B:61:0x0325, B:63:0x0366, B:65:0x036b, B:66:0x0382, B:70:0x038d, B:72:0x03a6, B:74:0x03ab, B:75:0x03c2, B:78:0x03e4, B:82:0x0407, B:83:0x041e, B:84:0x042a, B:87:0x0447, B:88:0x045b, B:90:0x0463, B:92:0x046f, B:94:0x0475, B:95:0x047c, B:97:0x0489, B:101:0x04cb, B:102:0x04e0, B:104:0x050a, B:107:0x0521, B:109:0x052b, B:110:0x0566, B:111:0x0591, B:113:0x05c9, B:114:0x05cc, B:116:0x05d4, B:117:0x05d7, B:119:0x05df, B:120:0x05e2, B:122:0x05ea, B:123:0x05ed, B:125:0x05f6, B:126:0x05fa, B:128:0x0608, B:129:0x060b, B:131:0x063d, B:133:0x0647, B:137:0x065e, B:141:0x066b, B:144:0x06e2, B:146:0x06e8, B:147:0x06eb, B:149:0x06ff, B:150:0x0709, B:152:0x0716, B:154:0x0720, B:155:0x0723, B:157:0x073f, B:159:0x0743, B:162:0x0757, B:164:0x0762, B:165:0x076d, B:167:0x0779, B:169:0x0785, B:171:0x078f, B:173:0x0795, B:175:0x07a7, B:176:0x07c5, B:178:0x07cb, B:179:0x07d4, B:180:0x07e7, B:182:0x0821, B:184:0x082b, B:185:0x082e, B:187:0x0838, B:189:0x0854, B:190:0x085d, B:191:0x0893, B:193:0x089b, B:195:0x08a5, B:196:0x08b2, B:198:0x08bc, B:199:0x08c9, B:200:0x08d2, B:202:0x08d8, B:204:0x0914, B:206:0x091e, B:208:0x0930, B:215:0x093b, B:217:0x0980, B:218:0x098b, B:219:0x0998, B:221:0x099e, B:225:0x09ec, B:227:0x0a42, B:229:0x0a53, B:230:0x0ab2, B:235:0x0a69, B:237:0x0a6d, B:240:0x09ad, B:242:0x09d9, B:248:0x0a84, B:249:0x0a9b, B:252:0x0a9d, B:257:0x0674, B:260:0x0681, B:263:0x068f, B:266:0x069d, B:269:0x06ab, B:272:0x06b9, B:275:0x06c5, B:278:0x06d3, B:288:0x0583, B:291:0x04b2, B:293:0x0303, B:294:0x030a, B:296:0x0310, B:299:0x031f, B:304:0x018a, B:307:0x019a, B:309:0x01af, B:314:0x01cb, B:317:0x01ff, B:319:0x0205, B:321:0x0213, B:323:0x0228, B:326:0x022f, B:328:0x02b8, B:330:0x02c2, B:331:0x0256, B:333:0x0278, B:335:0x02a0, B:338:0x028c, B:339:0x01d7, B:341:0x01f5), top: B:42:0x0155, inners: #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:341:0x01f5 A[Catch: all -> 0x0ae3, TryCatch #0 {all -> 0x0ae3, blocks: (B:43:0x0155, B:46:0x0164, B:48:0x016c, B:52:0x0176, B:58:0x02ef, B:61:0x0325, B:63:0x0366, B:65:0x036b, B:66:0x0382, B:70:0x038d, B:72:0x03a6, B:74:0x03ab, B:75:0x03c2, B:78:0x03e4, B:82:0x0407, B:83:0x041e, B:84:0x042a, B:87:0x0447, B:88:0x045b, B:90:0x0463, B:92:0x046f, B:94:0x0475, B:95:0x047c, B:97:0x0489, B:101:0x04cb, B:102:0x04e0, B:104:0x050a, B:107:0x0521, B:109:0x052b, B:110:0x0566, B:111:0x0591, B:113:0x05c9, B:114:0x05cc, B:116:0x05d4, B:117:0x05d7, B:119:0x05df, B:120:0x05e2, B:122:0x05ea, B:123:0x05ed, B:125:0x05f6, B:126:0x05fa, B:128:0x0608, B:129:0x060b, B:131:0x063d, B:133:0x0647, B:137:0x065e, B:141:0x066b, B:144:0x06e2, B:146:0x06e8, B:147:0x06eb, B:149:0x06ff, B:150:0x0709, B:152:0x0716, B:154:0x0720, B:155:0x0723, B:157:0x073f, B:159:0x0743, B:162:0x0757, B:164:0x0762, B:165:0x076d, B:167:0x0779, B:169:0x0785, B:171:0x078f, B:173:0x0795, B:175:0x07a7, B:176:0x07c5, B:178:0x07cb, B:179:0x07d4, B:180:0x07e7, B:182:0x0821, B:184:0x082b, B:185:0x082e, B:187:0x0838, B:189:0x0854, B:190:0x085d, B:191:0x0893, B:193:0x089b, B:195:0x08a5, B:196:0x08b2, B:198:0x08bc, B:199:0x08c9, B:200:0x08d2, B:202:0x08d8, B:204:0x0914, B:206:0x091e, B:208:0x0930, B:215:0x093b, B:217:0x0980, B:218:0x098b, B:219:0x0998, B:221:0x099e, B:225:0x09ec, B:227:0x0a42, B:229:0x0a53, B:230:0x0ab2, B:235:0x0a69, B:237:0x0a6d, B:240:0x09ad, B:242:0x09d9, B:248:0x0a84, B:249:0x0a9b, B:252:0x0a9d, B:257:0x0674, B:260:0x0681, B:263:0x068f, B:266:0x069d, B:269:0x06ab, B:272:0x06b9, B:275:0x06c5, B:278:0x06d3, B:288:0x0583, B:291:0x04b2, B:293:0x0303, B:294:0x030a, B:296:0x0310, B:299:0x031f, B:304:0x018a, B:307:0x019a, B:309:0x01af, B:314:0x01cb, B:317:0x01ff, B:319:0x0205, B:321:0x0213, B:323:0x0228, B:326:0x022f, B:328:0x02b8, B:330:0x02c2, B:331:0x0256, B:333:0x0278, B:335:0x02a0, B:338:0x028c, B:339:0x01d7, B:341:0x01f5), top: B:42:0x0155, inners: #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0366 A[Catch: all -> 0x0ae3, TryCatch #0 {all -> 0x0ae3, blocks: (B:43:0x0155, B:46:0x0164, B:48:0x016c, B:52:0x0176, B:58:0x02ef, B:61:0x0325, B:63:0x0366, B:65:0x036b, B:66:0x0382, B:70:0x038d, B:72:0x03a6, B:74:0x03ab, B:75:0x03c2, B:78:0x03e4, B:82:0x0407, B:83:0x041e, B:84:0x042a, B:87:0x0447, B:88:0x045b, B:90:0x0463, B:92:0x046f, B:94:0x0475, B:95:0x047c, B:97:0x0489, B:101:0x04cb, B:102:0x04e0, B:104:0x050a, B:107:0x0521, B:109:0x052b, B:110:0x0566, B:111:0x0591, B:113:0x05c9, B:114:0x05cc, B:116:0x05d4, B:117:0x05d7, B:119:0x05df, B:120:0x05e2, B:122:0x05ea, B:123:0x05ed, B:125:0x05f6, B:126:0x05fa, B:128:0x0608, B:129:0x060b, B:131:0x063d, B:133:0x0647, B:137:0x065e, B:141:0x066b, B:144:0x06e2, B:146:0x06e8, B:147:0x06eb, B:149:0x06ff, B:150:0x0709, B:152:0x0716, B:154:0x0720, B:155:0x0723, B:157:0x073f, B:159:0x0743, B:162:0x0757, B:164:0x0762, B:165:0x076d, B:167:0x0779, B:169:0x0785, B:171:0x078f, B:173:0x0795, B:175:0x07a7, B:176:0x07c5, B:178:0x07cb, B:179:0x07d4, B:180:0x07e7, B:182:0x0821, B:184:0x082b, B:185:0x082e, B:187:0x0838, B:189:0x0854, B:190:0x085d, B:191:0x0893, B:193:0x089b, B:195:0x08a5, B:196:0x08b2, B:198:0x08bc, B:199:0x08c9, B:200:0x08d2, B:202:0x08d8, B:204:0x0914, B:206:0x091e, B:208:0x0930, B:215:0x093b, B:217:0x0980, B:218:0x098b, B:219:0x0998, B:221:0x099e, B:225:0x09ec, B:227:0x0a42, B:229:0x0a53, B:230:0x0ab2, B:235:0x0a69, B:237:0x0a6d, B:240:0x09ad, B:242:0x09d9, B:248:0x0a84, B:249:0x0a9b, B:252:0x0a9d, B:257:0x0674, B:260:0x0681, B:263:0x068f, B:266:0x069d, B:269:0x06ab, B:272:0x06b9, B:275:0x06c5, B:278:0x06d3, B:288:0x0583, B:291:0x04b2, B:293:0x0303, B:294:0x030a, B:296:0x0310, B:299:0x031f, B:304:0x018a, B:307:0x019a, B:309:0x01af, B:314:0x01cb, B:317:0x01ff, B:319:0x0205, B:321:0x0213, B:323:0x0228, B:326:0x022f, B:328:0x02b8, B:330:0x02c2, B:331:0x0256, B:333:0x0278, B:335:0x02a0, B:338:0x028c, B:339:0x01d7, B:341:0x01f5), top: B:42:0x0155, inners: #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x038b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void zzH(com.google.android.gms.measurement.internal.zzbh r46, com.google.android.gms.measurement.internal.zzr r47) {
        /*
            Method dump skipped, instructions count: 2796
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzH(com.google.android.gms.measurement.internal.zzbh, com.google.android.gms.measurement.internal.zzr):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzI(zzh zzhVar, com.google.android.gms.internal.measurement.zzic zzicVar) {
        com.google.android.gms.internal.measurement.zziu zziuVar;
        zzaX().zzg();
        zzu();
        zzan zzd = zzan.zzd(zzicVar.zzaA());
        String zzc = zzhVar.zzc();
        zzaX().zzg();
        zzu();
        zzjl zzB = zzB(zzc);
        zzji zzjiVar = zzji.UNINITIALIZED;
        int ordinal = zzB.zzp().ordinal();
        if (ordinal == 1) {
            zzd.zzc(zzjk.AD_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        } else if (ordinal == 2 || ordinal == 3) {
            zzd.zzb(zzjk.AD_STORAGE, zzB.zzb());
        } else {
            zzd.zzc(zzjk.AD_STORAGE, zzam.FAILSAFE);
        }
        int ordinal2 = zzB.zzq().ordinal();
        if (ordinal2 == 1) {
            zzd.zzc(zzjk.ANALYTICS_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        } else if (ordinal2 == 2 || ordinal2 == 3) {
            zzd.zzb(zzjk.ANALYTICS_STORAGE, zzB.zzb());
        } else {
            zzd.zzc(zzjk.ANALYTICS_STORAGE, zzam.FAILSAFE);
        }
        String zzc2 = zzhVar.zzc();
        zzaX().zzg();
        zzu();
        zzba zzz = zzz(zzc2, zzx(zzc2), zzB(zzc2), zzd);
        zzicVar.zzaD(((Boolean) Preconditions.checkNotNull(zzz.zzj())).booleanValue());
        if (!TextUtils.isEmpty(zzz.zzk())) {
            zzicVar.zzaF(zzz.zzk());
        }
        zzaX().zzg();
        zzu();
        Iterator it = zzicVar.zzk().iterator();
        while (true) {
            if (it.hasNext()) {
                zziuVar = (com.google.android.gms.internal.measurement.zziu) it.next();
                if ("_npa".equals(zziuVar.zzc())) {
                    break;
                }
            } else {
                zziuVar = null;
                break;
            }
        }
        if (zziuVar != null) {
            zzjk zzjkVar = zzjk.AD_PERSONALIZATION;
            if (zzd.zza(zzjkVar) == zzam.UNSET) {
                zzpn zzm = zzj().zzm(zzhVar.zzc(), "_npa");
                if (zzm != null) {
                    String str = zzm.zzb;
                    if ("tcf".equals(str)) {
                        zzd.zzc(zzjkVar, zzam.TCF);
                    } else if ("app".equals(str)) {
                        zzd.zzc(zzjkVar, zzam.API);
                    } else {
                        zzd.zzc(zzjkVar, zzam.MANIFEST);
                    }
                } else {
                    Boolean zzae = zzhVar.zzae();
                    if (zzae == null || ((zzae.booleanValue() && zziuVar.zzh() != 1) || (!zzae.booleanValue() && zziuVar.zzh() != 0))) {
                        zzd.zzc(zzjkVar, zzam.API);
                    } else {
                        zzd.zzc(zzjkVar, zzam.MANIFEST);
                    }
                }
            }
        } else {
            int zzaD = zzaD(zzhVar.zzc(), zzd);
            com.google.android.gms.internal.measurement.zzit zzm2 = com.google.android.gms.internal.measurement.zziu.zzm();
            zzm2.zzb("_npa");
            zzm2.zza(zzba().currentTimeMillis());
            zzm2.zze(zzaD);
            zzicVar.zzo((com.google.android.gms.internal.measurement.zziu) zzm2.zzbd());
            zzaW().zzk().zzc("Setting user property", "non_personalized_ads(_npa)", Integer.valueOf(zzaD));
        }
        zzicVar.zzaB(zzd.toString());
        boolean zzz2 = this.zzc.zzz(zzhVar.zzc());
        List zzb2 = zzicVar.zzb();
        int i = 0;
        for (int i2 = 0; i2 < zzb2.size(); i2++) {
            if ("_tcf".equals(((com.google.android.gms.internal.measurement.zzhs) zzb2.get(i2)).zzd())) {
                com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) ((com.google.android.gms.internal.measurement.zzhs) zzb2.get(i2)).zzco();
                List zza = zzhrVar.zza();
                int i3 = 0;
                while (true) {
                    if (i3 >= zza.size()) {
                        break;
                    }
                    if ("_tcfd".equals(((com.google.android.gms.internal.measurement.zzhw) zza.get(i3)).zzb())) {
                        String zzd2 = ((com.google.android.gms.internal.measurement.zzhw) zza.get(i3)).zzd();
                        if (zzz2 && zzd2.length() > 4) {
                            char[] charArray = zzd2.toCharArray();
                            int i4 = 1;
                            while (true) {
                                if (i4 >= 64) {
                                    break;
                                }
                                if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i4)) {
                                    i = i4;
                                    break;
                                }
                                i4++;
                            }
                            charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i | 1);
                            zzd2 = String.valueOf(charArray);
                        }
                        com.google.android.gms.internal.measurement.zzhv zzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                        zzn.zzb("_tcfd");
                        zzn.zzd(zzd2);
                        zzhrVar.zze(i3, zzn);
                    } else {
                        i3++;
                    }
                }
                zzicVar.zzf(i2, zzhrVar);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzJ(zzh zzhVar, com.google.android.gms.internal.measurement.zzic zzicVar) {
        zzaX().zzg();
        zzu();
        com.google.android.gms.internal.measurement.zzgx zzt = com.google.android.gms.internal.measurement.zzha.zzt();
        byte[] zzaJ = zzhVar.zzaJ();
        if (zzaJ != null) {
            try {
                zzt = (com.google.android.gms.internal.measurement.zzgx) zzpk.zzw(zzt, zzaJ);
            } catch (zzaeh unused) {
                zzaW().zze().zzb("Failed to parse locally stored ad campaign info. appId", zzgu.zzl(zzhVar.zzc()));
            }
        }
        for (com.google.android.gms.internal.measurement.zzhs zzhsVar : zzicVar.zzb()) {
            if (zzhsVar.zzd().equals("_cmp")) {
                String str = (String) zzpk.zzN(zzhsVar, "gclid", "");
                String str2 = (String) zzpk.zzN(zzhsVar, "gbraid", "");
                String str3 = (String) zzpk.zzN(zzhsVar, "gad_source", "");
                String str4 = (String) zzpk.zzN(zzhsVar, "deep_link_url", "");
                String[] split = ((String) zzfy.zzbb.zzb(null)).split(",");
                zzp();
                if (!zzpk.zzK(zzhsVar, split).isEmpty()) {
                    long longValue = ((Long) zzpk.zzN(zzhsVar, "click_timestamp", 0L)).longValue();
                    if (longValue <= 0) {
                        longValue = zzhsVar.zzf();
                    }
                    if ("referrer API v2".equals(zzpk.zzM(zzhsVar, "_cis"))) {
                        if (longValue > zzt.zzo()) {
                            if (str.isEmpty()) {
                                zzt.zzj();
                            } else {
                                zzt.zzi(str);
                            }
                            if (str2.isEmpty()) {
                                zzt.zzl();
                            } else {
                                zzt.zzk(str2);
                            }
                            if (str3.isEmpty()) {
                                zzt.zzn();
                            } else {
                                zzt.zzm(str3);
                            }
                            zzt.zzp(longValue);
                            zzt.zzs();
                            zzt.zzt(zzaE(zzhsVar));
                        }
                    } else if (longValue > zzt.zzg()) {
                        if (str.isEmpty()) {
                            zzt.zzb();
                        } else {
                            zzt.zza(str);
                        }
                        if (str2.isEmpty()) {
                            zzt.zzd();
                        } else {
                            zzt.zzc(str2);
                        }
                        if (str3.isEmpty()) {
                            zzt.zzf();
                        } else {
                            zzt.zze(str3);
                        }
                        if (zzd().zzp(null, zzfy.zzba)) {
                            if (str4.isEmpty()) {
                                zzt.zzv();
                            } else {
                                zzt.zzu(str4);
                            }
                        }
                        zzt.zzh(longValue);
                        zzt.zzq();
                        zzt.zzr(zzaE(zzhsVar));
                    }
                }
            }
        }
        if (!((com.google.android.gms.internal.measurement.zzha) zzt.zzbd()).equals(com.google.android.gms.internal.measurement.zzha.zzu())) {
            zzicVar.zzaM((com.google.android.gms.internal.measurement.zzha) zzt.zzbd());
        }
        zzhVar.zzaI(((com.google.android.gms.internal.measurement.zzha) zzt.zzbd()).zzcd());
        if (zzhVar.zza()) {
            zzj().zzv(zzhVar, false, false);
        }
        if (zzd().zzp(null, zzfy.zzba)) {
            for (int i = 0; i < zzicVar.zzc(); i++) {
                com.google.android.gms.internal.measurement.zzhs zzd = zzicVar.zzd(i);
                if ("_cmp".equals(zzd.zzd())) {
                    com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzd.zzco();
                    List zza = zzhrVar.zza();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= zza.size()) {
                            break;
                        }
                        if ("deep_link_url".equals(((com.google.android.gms.internal.measurement.zzhw) zza.get(i2)).zzb())) {
                            zzhrVar.zzj(i2);
                            zzicVar.zzf(i, zzhrVar);
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
        if (zzd().zzp(null, zzfy.zzaZ)) {
            zzj().zzk(zzhVar.zzc(), "_lgclid");
        }
    }

    final String zzK(zzjl zzjlVar) {
        if (!zzjlVar.zzo(zzjk.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzt().zzf().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    final void zzL(List list) {
        Preconditions.checkArgument(!list.isEmpty());
        if (this.zzz != null) {
            zzaW().zzb().zza("Set uploading progress before finishing the previous upload");
        } else {
            this.zzz = new ArrayList(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0128, code lost:
    
        r11.zzB = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0110, code lost:
    
        if (r7 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0125, code lost:
    
        if (r7 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0171, code lost:
    
        if (r1 != 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0173, code lost:
    
        r1.close();
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0198, code lost:
    
        r1 = android.text.TextUtils.isEmpty(r7);
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x019c, code lost:
    
        if (r1 != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x019e, code lost:
    
        r1 = zzj().zzu(r7);
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01a6, code lost:
    
        if (r1 == null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01a8, code lost:
    
        zzX(r1);
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x017b, code lost:
    
        if (r1 != 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0195, code lost:
    
        if (r1 != 0) goto L56;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r1v12, types: [long] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v27, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.google.android.gms.measurement.internal.zzgs] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0195 -> B:60:0x0173). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0195 -> B:61:0x0198). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzM() {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzM():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:269:0x0479, code lost:
    
        if (r23 != null) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x044e, code lost:
    
        r23.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x044c, code lost:
    
        if (r23 != null) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x0224, code lost:
    
        if (r10 != null) goto L110;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:226:0x09b1  */
    /* JADX WARN: Removed duplicated region for block: B:231:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:340:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:368:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x09ff  */
    /* JADX WARN: Type inference failed for: r23v19 */
    /* JADX WARN: Type inference failed for: r23v26 */
    /* JADX WARN: Type inference failed for: r23v3, types: [long] */
    /* JADX WARN: Type inference failed for: r23v30 */
    /* JADX WARN: Type inference failed for: r23v31 */
    /* JADX WARN: Type inference failed for: r23v32 */
    /* JADX WARN: Type inference failed for: r23v35 */
    /* JADX WARN: Type inference failed for: r23v36 */
    /* JADX WARN: Type inference failed for: r23v9 */
    /* JADX WARN: Type inference failed for: r32v0, types: [com.google.android.gms.measurement.internal.zzpg] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void zzN(java.lang.String r33, long r34) {
        /*
            Method dump skipped, instructions count: 2563
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzN(java.lang.String, long):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzO(String str, String str2) {
        zzh zzu = zzj().zzu(str);
        if (zzu != null && zzt().zzad(str, zzu.zzay())) {
            this.zzF.remove(str2);
            return true;
        }
        zzpe zzpeVar = (zzpe) this.zzF.get(str2);
        if (zzpeVar == null) {
            return true;
        }
        return zzpeVar.zzb();
    }

    final void zzP(String str) {
        com.google.android.gms.internal.measurement.zzib zzd;
        zzaX().zzg();
        zzu();
        this.zzw = true;
        try {
            zzic zzicVar = this.zzn;
            zzicVar.zzaV();
            Boolean zzJ = zzicVar.zzt().zzJ();
            if (zzJ == null) {
                zzaW().zze().zza("Upload data called on the client side before use of service was decided");
            } else if (zzJ.booleanValue()) {
                zzaW().zzb().zza("Upload called in the client side when service should be used");
            } else if (this.zza > 0) {
                zzaM();
            } else if (!zzi().zzb()) {
                zzaW().zzk().zza("Network not connected, ignoring upload request");
                zzaM();
            } else if (!zzj().zzD(str)) {
                zzaW().zzk().zzb("[sgtm] Upload queue has no batches for appId", str);
            } else {
                zzaw zzj = zzj();
                Preconditions.checkNotEmpty(str);
                zzj.zzg();
                zzj.zzay();
                List zzC = zzj.zzC(str, zzoo.zza(zzls.GOOGLE_SIGNAL), 1);
                zzpj zzpjVar = zzC.isEmpty() ? null : (zzpj) zzC.get(0);
                if (zzpjVar != null && (zzd = zzpjVar.zzd()) != null) {
                    zzaW().zzk().zzd("[sgtm] Uploading data from upload queue. appId, type, url", str, zzpjVar.zzf(), zzpjVar.zze());
                    byte[] zzcd = zzd.zzcd();
                    if (Log.isLoggable(zzaW().zzn(), 2)) {
                        zzaW().zzk().zzd("[sgtm] Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(zzcd.length), zzp().zzi(zzd));
                    }
                    zzot zza = zzpjVar.zza();
                    this.zzv = true;
                    zzi().zzc(str, zza, zzd, new zzox(this, str, zzpjVar));
                }
            }
        } finally {
            this.zzw = false;
            zzaN();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x007f  */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzQ(java.lang.String r4, int r5, java.lang.Throwable r6, byte[] r7, com.google.android.gms.measurement.internal.zzpj r8) {
        /*
            r3 = this;
            com.google.android.gms.measurement.internal.zzhz r0 = r3.zzaX()
            r0.zzg()
            r3.zzu()
            r0 = 0
            if (r7 != 0) goto L13
            byte[] r7 = new byte[r0]     // Catch: java.lang.Throwable -> L10
            goto L13
        L10:
            r4 = move-exception
            goto L9b
        L13:
            r1 = 200(0xc8, float:2.8E-43)
            if (r5 == r1) goto L1c
            r1 = 204(0xcc, float:2.86E-43)
            if (r5 != r1) goto L5a
            r5 = r1
        L1c:
            if (r6 != 0) goto L5a
            com.google.android.gms.measurement.internal.zzaw r6 = r3.zzj()     // Catch: java.lang.Throwable -> L10
            long r7 = r8.zzc()     // Catch: java.lang.Throwable -> L10
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> L10
            r6.zzE(r7)     // Catch: java.lang.Throwable -> L10
            com.google.android.gms.measurement.internal.zzgu r6 = r3.zzaW()     // Catch: java.lang.Throwable -> L10
            com.google.android.gms.measurement.internal.zzgs r6 = r6.zzk()     // Catch: java.lang.Throwable -> L10
            java.lang.String r7 = "Successfully uploaded batch from upload queue. appId, status"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L10
            r6.zzc(r7, r4, r5)     // Catch: java.lang.Throwable -> L10
            com.google.android.gms.measurement.internal.zzgz r5 = r3.zzi()     // Catch: java.lang.Throwable -> L10
            boolean r5 = r5.zzb()     // Catch: java.lang.Throwable -> L10
            if (r5 == 0) goto L56
            com.google.android.gms.measurement.internal.zzaw r5 = r3.zzj()     // Catch: java.lang.Throwable -> L10
            boolean r5 = r5.zzD(r4)     // Catch: java.lang.Throwable -> L10
            if (r5 == 0) goto L56
            r3.zzP(r4)     // Catch: java.lang.Throwable -> L10
            goto L95
        L56:
            r3.zzaM()     // Catch: java.lang.Throwable -> L10
            goto L95
        L5a:
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> L10
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L10
            r1.<init>(r7, r2)     // Catch: java.lang.Throwable -> L10
            int r7 = r1.length()     // Catch: java.lang.Throwable -> L10
            r2 = 32
            int r7 = java.lang.Math.min(r2, r7)     // Catch: java.lang.Throwable -> L10
            java.lang.String r7 = r1.substring(r0, r7)     // Catch: java.lang.Throwable -> L10
            com.google.android.gms.measurement.internal.zzgu r1 = r3.zzaW()     // Catch: java.lang.Throwable -> L10
            com.google.android.gms.measurement.internal.zzgs r1 = r1.zzh()     // Catch: java.lang.Throwable -> L10
            java.lang.String r2 = "Network upload failed. Will retry later. appId, status, error"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L10
            if (r6 != 0) goto L80
            r6 = r7
        L80:
            r1.zzd(r2, r4, r5, r6)     // Catch: java.lang.Throwable -> L10
            com.google.android.gms.measurement.internal.zzaw r4 = r3.zzj()     // Catch: java.lang.Throwable -> L10
            long r5 = r8.zzc()     // Catch: java.lang.Throwable -> L10
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L10
            r4.zzK(r5)     // Catch: java.lang.Throwable -> L10
            r3.zzaM()     // Catch: java.lang.Throwable -> L10
        L95:
            r3.zzv = r0
            r3.zzaN()
            return
        L9b:
            r3.zzv = r0
            r3.zzaN()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzQ(java.lang.String, int, java.lang.Throwable, byte[], com.google.android.gms.measurement.internal.zzpj):void");
    }

    final void zzR(String str, boolean z, Long l, Long l2) {
        zzh zzu = zzj().zzu(str);
        if (zzu != null) {
            zzu.zzar(z);
            zzu.zzat(l);
            zzu.zzav(l2);
            if (zzu.zza()) {
                zzj().zzv(zzu, false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzS(String str, com.google.android.gms.internal.measurement.zzic zzicVar) {
        int zzx;
        int indexOf;
        Set zzl = zzh().zzl(str);
        if (zzl != null) {
            zzicVar.zzaw(zzl);
        }
        if (zzh().zzq(str)) {
            zzicVar.zzG();
        }
        if (zzh().zzr(str)) {
            String zzD = zzicVar.zzD();
            if (!TextUtils.isEmpty(zzD) && (indexOf = zzD.indexOf(".")) != -1) {
                zzicVar.zzE(zzD.substring(0, indexOf));
            }
        }
        if (zzh().zzs(str) && (zzx = zzpk.zzx(zzicVar, "_id")) != -1) {
            zzicVar.zzr(zzx);
        }
        if (zzh().zzt(str)) {
            zzicVar.zzan();
        }
        if (zzh().zzu(str)) {
            zzicVar.zzX();
            if (zzB(str).zzo(zzjk.ANALYTICS_STORAGE)) {
                Map map = this.zzE;
                zzpd zzpdVar = (zzpd) map.get(str);
                if (zzpdVar == null || zzpdVar.zzb + zzd().zzl(str, zzfy.zzaj) < zzba().elapsedRealtime()) {
                    zzpdVar = new zzpd(this, (byte[]) null);
                    map.put(str, zzpdVar);
                }
                zzicVar.zzax(zzpdVar.zza);
            }
        }
        if (zzh().zzv(str)) {
            zzicVar.zzav();
        }
    }

    final void zzT(com.google.android.gms.internal.measurement.zzic zzicVar, zzpc zzpcVar) {
        for (int i = 0; i < zzicVar.zzc(); i++) {
            com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzicVar.zzd(i).zzco();
            Iterator it = zzhrVar.zza().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if ("_c".equals(((com.google.android.gms.internal.measurement.zzhw) it.next()).zzb())) {
                    if (zzpcVar.zza.zzar() >= zzd().zzm(zzpcVar.zza.zzA(), zzfy.zzak)) {
                        int zzm = zzd().zzm(zzpcVar.zza.zzA(), zzfy.zzax);
                        String str = null;
                        if (zzm <= 0) {
                            if (zzd().zzp(zzpcVar.zza.zzA(), zzfy.zzaQ)) {
                                str = zzt().zzaz();
                                com.google.android.gms.internal.measurement.zzhv zzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzn.zzb("_tu");
                                zzn.zzd(str);
                                zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzn.zzbd());
                            }
                            com.google.android.gms.internal.measurement.zzhv zzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzn2.zzb("_tr");
                            zzn2.zzf(1L);
                            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzn2.zzbd());
                            zzoh zzf = zzp().zzf(zzpcVar.zza.zzA(), zzicVar, zzhrVar, str);
                            if (zzf != null) {
                                zzaW().zzk().zzc("Generated trigger URI. appId, uri", zzpcVar.zza.zzA(), zzf.zza);
                                zzj().zzZ(zzpcVar.zza.zzA(), zzf);
                                Deque deque = this.zzr;
                                if (!deque.contains(zzpcVar.zza.zzA())) {
                                    deque.add(zzpcVar.zza.zzA());
                                }
                            }
                        } else if (zzj().zzw(zzC(), zzpcVar.zza.zzA(), false, false, false, false, false, false, true).zzg > zzm) {
                            com.google.android.gms.internal.measurement.zzhv zzn3 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzn3.zzb("_tnr");
                            zzn3.zzf(1L);
                            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzn3.zzbd());
                        } else {
                            if (zzd().zzp(zzpcVar.zza.zzA(), zzfy.zzaQ)) {
                                str = zzt().zzaz();
                                com.google.android.gms.internal.measurement.zzhv zzn4 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzn4.zzb("_tu");
                                zzn4.zzd(str);
                                zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzn4.zzbd());
                            }
                            com.google.android.gms.internal.measurement.zzhv zzn5 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzn5.zzb("_tr");
                            zzn5.zzf(1L);
                            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzn5.zzbd());
                            zzoh zzf2 = zzp().zzf(zzpcVar.zza.zzA(), zzicVar, zzhrVar, str);
                            if (zzf2 != null) {
                                zzaW().zzk().zzc("Generated trigger URI. appId, uri", zzpcVar.zza.zzA(), zzf2.zza);
                                zzj().zzZ(zzpcVar.zza.zzA(), zzf2);
                                Deque deque2 = this.zzr;
                                if (!deque2.contains(zzpcVar.zza.zzA())) {
                                    deque2.add(zzpcVar.zza.zzA());
                                }
                            }
                        }
                    }
                    zzicVar.zze(i, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbd());
                }
            }
        }
    }

    final void zzU(String str, com.google.android.gms.internal.measurement.zzhv zzhvVar, Bundle bundle, String str2) {
        List listOf;
        int zzf;
        if (zzd().zzp(str2, zzfy.zzba)) {
            listOf = CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si", "deep_link_url"});
        } else {
            listOf = CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
        }
        if (!zzpp.zzac(zzhvVar.zza()) && !zzpp.zzac(str)) {
            zzf = zzd().zze(str2, true);
        } else {
            zzf = zzd().zzf(str2, true);
        }
        long j = zzf;
        long codePointCount = zzhvVar.zzc().codePointCount(0, zzhvVar.zzc().length());
        zzpp zzt = zzt();
        String zza = zzhvVar.zza();
        zzd();
        String zzE = zzt.zzE(zza, 40, true);
        if (codePointCount <= j || listOf.contains(zzhvVar.zza())) {
            return;
        }
        if ("_ev".equals(zzhvVar.zza())) {
            bundle.putString("_ev", zzt().zzE(zzhvVar.zzc(), zzd().zzf(str2, true), true));
            return;
        }
        zzaW().zzh().zzc("Param value is too long; discarded. Name, value length", zzE, Long.valueOf(codePointCount));
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", 4L);
            if (bundle.getString("_ev") == null) {
                bundle.putString("_ev", zzE);
                bundle.putLong("_el", codePointCount);
            }
        }
        bundle.remove(zzhvVar.zza());
    }

    final boolean zzV(com.google.android.gms.internal.measurement.zzhr zzhrVar) {
        ArrayList arrayList = new ArrayList(zzhrVar.zza());
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if ("value".equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i3)).zzb())) {
                i = i3;
            } else if (FirebaseAnalytics.Param.CURRENCY.equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i3)).zzb())) {
                i2 = i3;
            }
        }
        if (i == -1) {
            if (!zzd().zzp(null, zzfy.zzbf) || !"_iap".equals(zzhrVar.zzk())) {
                return true;
            }
            zzaC(zzhrVar, "_c");
            zzaB(zzhrVar, 18, "value");
            return false;
        }
        if (!((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i)).zze() && !((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i)).zzj()) {
            zzaW().zzh().zza("Value must be specified with a numeric type.");
            zzhrVar.zzj(i);
            zzaC(zzhrVar, "_c");
            zzaB(zzhrVar, 18, "value");
            return false;
        }
        if (i2 != -1) {
            String zzd = ((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i2)).zzd();
            if (zzd.length() == 3) {
                int i4 = 0;
                while (i4 < zzd.length()) {
                    int codePointAt = zzd.codePointAt(i4);
                    if (Character.isLetter(codePointAt)) {
                        i4 += Character.charCount(codePointAt);
                    }
                }
                return true;
            }
        }
        zzaW().zzh().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
        zzhrVar.zzj(i);
        zzaC(zzhrVar, "_c");
        zzaB(zzhrVar, 19, FirebaseAnalytics.Param.CURRENCY);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0044, code lost:
    
        if (r21 != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzW(boolean r19, int r20, java.lang.Throwable r21, byte[] r22, java.lang.String r23, java.util.List r24, java.util.Map r25) {
        /*
            Method dump skipped, instructions count: 683
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzW(boolean, int, java.lang.Throwable, byte[], java.lang.String, java.util.List, java.util.Map):void");
    }

    final void zzX(zzh zzhVar) {
        zzaX().zzg();
        if (TextUtils.isEmpty(zzhVar.zzf())) {
            zzY((String) Preconditions.checkNotNull(zzhVar.zzc()), 204, null, null, null);
            return;
        }
        String str = (String) Preconditions.checkNotNull(zzhVar.zzc());
        zzaW().zzk().zzb("Fetching remote configuration", str);
        com.google.android.gms.internal.measurement.zzgl zzb2 = zzh().zzb(str);
        String zzd = zzh().zzd(str);
        ArrayMap arrayMap = null;
        if (zzb2 != null) {
            if (!TextUtils.isEmpty(zzd)) {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put(HttpHeaders.IF_MODIFIED_SINCE, zzd);
                arrayMap = arrayMap2;
            }
            String zze = zzh().zze(str);
            if (!TextUtils.isEmpty(zze)) {
                if (arrayMap == null) {
                    arrayMap = new ArrayMap();
                }
                arrayMap.put(HttpHeaders.IF_NONE_MATCH, zze);
            }
        }
        this.zzu = true;
        zzi().zzd(zzhVar, arrayMap, new zzgw() { // from class: com.google.android.gms.measurement.internal.zzpf
            @Override // com.google.android.gms.measurement.internal.zzgw
            public final /* synthetic */ void zza(String str2, int i, Throwable th, byte[] bArr, Map map) {
                zzpg.this.zzY(str2, i, th, bArr, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005b A[Catch: all -> 0x0178, TryCatch #1 {all -> 0x0178, blocks: (B:8:0x003f, B:16:0x005b, B:17:0x0164, B:27:0x0075, B:31:0x00c5, B:32:0x00b6, B:33:0x00ca, B:37:0x00e1, B:38:0x00fa, B:40:0x010e, B:41:0x012d, B:43:0x0137, B:45:0x013d, B:46:0x0141, B:48:0x014b, B:50:0x0159, B:51:0x0161, B:52:0x011c, B:53:0x00e9, B:55:0x00f3), top: B:7:0x003f, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010e A[Catch: all -> 0x0178, TryCatch #1 {all -> 0x0178, blocks: (B:8:0x003f, B:16:0x005b, B:17:0x0164, B:27:0x0075, B:31:0x00c5, B:32:0x00b6, B:33:0x00ca, B:37:0x00e1, B:38:0x00fa, B:40:0x010e, B:41:0x012d, B:43:0x0137, B:45:0x013d, B:46:0x0141, B:48:0x014b, B:50:0x0159, B:51:0x0161, B:52:0x011c, B:53:0x00e9, B:55:0x00f3), top: B:7:0x003f, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011c A[Catch: all -> 0x0178, TryCatch #1 {all -> 0x0178, blocks: (B:8:0x003f, B:16:0x005b, B:17:0x0164, B:27:0x0075, B:31:0x00c5, B:32:0x00b6, B:33:0x00ca, B:37:0x00e1, B:38:0x00fa, B:40:0x010e, B:41:0x012d, B:43:0x0137, B:45:0x013d, B:46:0x0141, B:48:0x014b, B:50:0x0159, B:51:0x0161, B:52:0x011c, B:53:0x00e9, B:55:0x00f3), top: B:7:0x003f, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzY(java.lang.String r8, int r9, java.lang.Throwable r10, byte[] r11, java.util.Map r12) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzY(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzZ(Runnable runnable) {
        zzaX().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaA(long j) {
        this.zzJ = j;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzae zzaV() {
        return this.zzn.zzaV();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzgu zzaW() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzaW();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzhz zzaX() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzaX();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Context zzaZ() {
        return this.zzn.zzaZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaa() {
        zzaX().zzg();
        zzu();
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        if (zzab()) {
            FileChannel fileChannel = this.zzy;
            zzaX().zzg();
            int i = 0;
            if (fileChannel == null || !fileChannel.isOpen()) {
                zzaW().zzb().zza("Bad channel to read from");
            } else {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                try {
                    fileChannel.position(0L);
                    int read = fileChannel.read(allocate);
                    if (read == 4) {
                        allocate.flip();
                        i = allocate.getInt();
                    } else if (read != -1) {
                        zzaW().zze().zzb("Unexpected data length. Bytes read", Integer.valueOf(read));
                    }
                } catch (IOException e) {
                    zzaW().zzb().zzb("Failed to read from channel", e);
                }
            }
            int zzm = this.zzn.zzv().zzm();
            zzaX().zzg();
            if (i > zzm) {
                zzaW().zzb().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzm));
                return;
            }
            if (i < zzm) {
                FileChannel fileChannel2 = this.zzy;
                zzaX().zzg();
                if (fileChannel2 == null || !fileChannel2.isOpen()) {
                    zzaW().zzb().zza("Bad channel to read from");
                } else {
                    ByteBuffer allocate2 = ByteBuffer.allocate(4);
                    allocate2.putInt(zzm);
                    allocate2.flip();
                    try {
                        fileChannel2.truncate(0L);
                        fileChannel2.write(allocate2);
                        fileChannel2.force(true);
                        if (fileChannel2.size() != 4) {
                            zzaW().zzb().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                        }
                        zzaW().zzk().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzm));
                        return;
                    } catch (IOException e2) {
                        zzaW().zzb().zzb("Failed to write to channel", e2);
                    }
                }
                zzaW().zzb().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzm));
            }
        }
    }

    final boolean zzab() {
        zzaX().zzg();
        FileLock fileLock = this.zzx;
        if (fileLock != null && fileLock.isValid()) {
            zzaW().zzk().zza("Storage concurrent access okay");
            return true;
        }
        this.zze.zzu.zzc();
        File filesDir = this.zzn.zzaZ().getFilesDir();
        com.google.android.gms.internal.measurement.zzby.zza();
        int i = com.google.android.gms.internal.measurement.zzcd.zza;
        try {
            FileChannel channel = new RandomAccessFile(new File(new File(filesDir, "google_app_measurement.db").getPath()), "rw").getChannel();
            this.zzy = channel;
            FileLock tryLock = channel.tryLock();
            this.zzx = tryLock;
            if (tryLock != null) {
                zzaW().zzk().zza("Storage concurrent access okay");
                return true;
            }
            zzaW().zzb().zza("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            zzaW().zzb().zzb("Failed to acquire storage lock", e);
            return false;
        } catch (IOException e2) {
            zzaW().zzb().zzb("Failed to access storage lock file", e2);
            return false;
        } catch (OverlappingFileLockException e3) {
            zzaW().zze().zzb("Storage lock already acquired", e3);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzac(zzr zzrVar) {
        if (this.zzz != null) {
            ArrayList arrayList = new ArrayList();
            this.zzA = arrayList;
            arrayList.addAll(this.zzz);
        }
        zzaw zzj = zzj();
        String str = (String) Preconditions.checkNotNull(zzrVar.zza);
        Preconditions.checkNotEmpty(str);
        zzj.zzg();
        zzj.zzay();
        try {
            SQLiteDatabase zze = zzj.zze();
            String[] strArr = {str};
            int delete = zze.delete("apps", "app_id=?", strArr) + zze.delete("events", "app_id=?", strArr) + zze.delete("events_snapshot", "app_id=?", strArr) + zze.delete("user_attributes", "app_id=?", strArr) + zze.delete("conditional_properties", "app_id=?", strArr) + zze.delete("raw_events", "app_id=?", strArr) + zze.delete("raw_events_metadata", "app_id=?", strArr) + zze.delete("queue", "app_id=?", strArr) + zze.delete("audience_filter_values", "app_id=?", strArr) + zze.delete("main_event_params", "app_id=?", strArr) + zze.delete("default_event_params", "app_id=?", strArr) + zze.delete("trigger_uris", "app_id=?", strArr) + zze.delete("upload_queue", "app_id=?", strArr);
            zzahh.zza();
            zzic zzicVar = zzj.zzu;
            if (zzicVar.zzc().zzp(null, zzfy.zzbc)) {
                delete += zze.delete("no_data_mode_events", "app_id=?", strArr);
            }
            int delete2 = delete + zze.delete("diagnostic_signals", "app_id=?", strArr);
            if (delete2 > 0) {
                zzicVar.zzaW().zzk().zzc("Reset analytics data. app, records", str, Integer.valueOf(delete2));
            }
        } catch (SQLiteException e) {
            zzj.zzu.zzaW().zzb().zzc("Error resetting analytics data. appId, error", zzgu.zzl(str), e);
        }
        if (zzrVar.zzh) {
            zzai(zzrVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzad(zzpl zzplVar, zzr zzrVar) {
        zzpn zzm;
        long j;
        zzaX().zzg();
        zzu();
        if (zzaS(zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            zzpp zzt = zzt();
            String str = zzplVar.zzb;
            int zzs = zzt.zzs(str);
            if (zzs != 0) {
                zzpp zzt2 = zzt();
                zzd();
                zzt().zzP(this.zzK, zzrVar.zza, zzs, "_ev", zzt2.zzE(str, 24, true), str != null ? str.length() : 0);
                return;
            }
            int zzM = zzt().zzM(str, zzplVar.zza());
            if (zzM != 0) {
                zzpp zzt3 = zzt();
                zzd();
                String zzE = zzt3.zzE(str, 24, true);
                Object zza = zzplVar.zza();
                if (zza != null && ((zza instanceof String) || (zza instanceof CharSequence))) {
                    r13 = zza.toString().length();
                }
                zzt().zzP(this.zzK, zzrVar.zza, zzM, "_ev", zzE, r13);
                return;
            }
            Object zzN = zzt().zzN(str, zzplVar.zza());
            if (zzN != null) {
                if ("_sid".equals(str)) {
                    long j2 = zzplVar.zzc;
                    String str2 = zzplVar.zzf;
                    String str3 = (String) Preconditions.checkNotNull(zzrVar.zza);
                    zzpn zzm2 = zzj().zzm(str3, "_sno");
                    if (zzm2 != null) {
                        Object obj = zzm2.zze;
                        if (obj instanceof Long) {
                            j = ((Long) obj).longValue();
                            zzad(new zzpl("_sno", j2, Long.valueOf(j + 1), str2), zzrVar);
                        }
                    }
                    if (zzm2 != null) {
                        zzaW().zze().zzb("Retrieved last session number from database does not contain a valid (long) value", zzm2.zze);
                    }
                    zzbd zzf = zzj().zzf(str3, "_s");
                    if (zzf != null) {
                        zzgs zzk = zzaW().zzk();
                        long j3 = zzf.zzc;
                        zzk.zzb("Backfill the session number. Last used session number", Long.valueOf(j3));
                        j = j3;
                    } else {
                        j = 0;
                    }
                    zzad(new zzpl("_sno", j2, Long.valueOf(j + 1), str2), zzrVar);
                }
                String str4 = zzrVar.zza;
                zzpn zzpnVar = new zzpn((String) Preconditions.checkNotNull(str4), (String) Preconditions.checkNotNull(zzplVar.zzf), str, zzplVar.zzc, zzN);
                zzgs zzk2 = zzaW().zzk();
                zzic zzicVar = this.zzn;
                String str5 = zzpnVar.zzc;
                zzk2.zzc("Setting user property", zzicVar.zzl().zzc(str5), zzN);
                zzj().zzb();
                try {
                    if ("_id".equals(str5) && (zzm = zzj().zzm(str4, "_id")) != null && !zzpnVar.zze.equals(zzm.zze)) {
                        zzj().zzk(str4, "_lair");
                    }
                    zzap(zzrVar);
                    boolean zzl = zzj().zzl(zzpnVar);
                    if ("_sid".equals(str)) {
                        long zzu = zzp().zzu(zzrVar.zzu);
                        zzh zzu2 = zzj().zzu(str4);
                        if (zzu2 != null) {
                            zzu2.zzan(zzu);
                            if (zzu2.zza()) {
                                zzj().zzv(zzu2, false, false);
                            }
                        }
                    }
                    zzj().zzc();
                    if (!zzl) {
                        zzaW().zzb().zzc("Too many unique user properties are set. Ignoring user property", zzicVar.zzl().zzc(str5), zzpnVar.zze);
                        zzt().zzP(this.zzK, str4, 9, null, null, 0);
                    }
                } finally {
                    zzj().zzd();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzae(String str, zzr zzrVar) {
        zzaX().zzg();
        zzu();
        if (zzaS(zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            Boolean zzaU = zzaU(zzrVar);
            if ("_npa".equals(str) && zzaU != null) {
                zzaW().zzj().zza("Falling back to manifest metadata value for ad personalization");
                zzad(new zzpl("_npa", zzba().currentTimeMillis(), Long.valueOf(true != zzaU.booleanValue() ? 0L : 1L), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzrVar);
                return;
            }
            zzgs zzj = zzaW().zzj();
            zzic zzicVar = this.zzn;
            zzj.zzb("Removing user property", zzicVar.zzl().zzc(str));
            zzj().zzb();
            try {
                zzap(zzrVar);
                if ("_id".equals(str)) {
                    zzj().zzk((String) Preconditions.checkNotNull(zzrVar.zza), "_lair");
                }
                zzj().zzk((String) Preconditions.checkNotNull(zzrVar.zza), str);
                zzj().zzc();
                zzaW().zzj().zzb("User property removed", zzicVar.zzl().zzc(str));
            } finally {
                zzj().zzd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaf() {
        this.zzs++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzag() {
        this.zzt++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzic zzah() {
        return this.zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x00eb, code lost:
    
        if (true == r14.booleanValue()) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x00ed, code lost:
    
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x00f1, code lost:
    
        r18 = new com.google.android.gms.measurement.internal.zzpl("_npa", r20, java.lang.Long.valueOf(r14), kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        r14 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x00fe, code lost:
    
        if (r13 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0108, code lost:
    
        if (r13.zze.equals(r18.zzd) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x010a, code lost:
    
        zzad(r18, r35);
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x00f0, code lost:
    
        r14 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0434 A[Catch: all -> 0x0467, TryCatch #2 {all -> 0x0467, blocks: (B:31:0x00c1, B:33:0x00d3, B:37:0x0115, B:39:0x0122, B:40:0x012b, B:42:0x0130, B:44:0x0149, B:47:0x015e, B:49:0x0183, B:52:0x018b, B:54:0x019a, B:55:0x027f, B:57:0x02ab, B:58:0x02ae, B:60:0x02d6, B:64:0x03ae, B:65:0x03b1, B:66:0x0458, B:71:0x02eb, B:73:0x030e, B:75:0x0316, B:77:0x0320, B:81:0x0333, B:82:0x034a, B:85:0x0356, B:87:0x036a, B:98:0x037b, B:89:0x038f, B:91:0x0397, B:92:0x039f, B:94:0x03a5, B:101:0x0340, B:106:0x02fa, B:107:0x01ab, B:109:0x01d6, B:110:0x01e5, B:112:0x01ec, B:114:0x01f2, B:116:0x01fc, B:118:0x0206, B:120:0x020c, B:122:0x0212, B:124:0x0217, B:127:0x0235, B:131:0x023a, B:132:0x024e, B:133:0x025e, B:134:0x026e, B:135:0x03d7, B:137:0x040e, B:138:0x0411, B:139:0x0434, B:141:0x043a, B:142:0x013c, B:143:0x0128, B:145:0x00e3, B:148:0x00f1, B:150:0x0100, B:152:0x010a, B:156:0x0112), top: B:30:0x00c1, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x013c A[Catch: all -> 0x0467, TryCatch #2 {all -> 0x0467, blocks: (B:31:0x00c1, B:33:0x00d3, B:37:0x0115, B:39:0x0122, B:40:0x012b, B:42:0x0130, B:44:0x0149, B:47:0x015e, B:49:0x0183, B:52:0x018b, B:54:0x019a, B:55:0x027f, B:57:0x02ab, B:58:0x02ae, B:60:0x02d6, B:64:0x03ae, B:65:0x03b1, B:66:0x0458, B:71:0x02eb, B:73:0x030e, B:75:0x0316, B:77:0x0320, B:81:0x0333, B:82:0x034a, B:85:0x0356, B:87:0x036a, B:98:0x037b, B:89:0x038f, B:91:0x0397, B:92:0x039f, B:94:0x03a5, B:101:0x0340, B:106:0x02fa, B:107:0x01ab, B:109:0x01d6, B:110:0x01e5, B:112:0x01ec, B:114:0x01f2, B:116:0x01fc, B:118:0x0206, B:120:0x020c, B:122:0x0212, B:124:0x0217, B:127:0x0235, B:131:0x023a, B:132:0x024e, B:133:0x025e, B:134:0x026e, B:135:0x03d7, B:137:0x040e, B:138:0x0411, B:139:0x0434, B:141:0x043a, B:142:0x013c, B:143:0x0128, B:145:0x00e3, B:148:0x00f1, B:150:0x0100, B:152:0x010a, B:156:0x0112), top: B:30:0x00c1, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0128 A[Catch: all -> 0x0467, TryCatch #2 {all -> 0x0467, blocks: (B:31:0x00c1, B:33:0x00d3, B:37:0x0115, B:39:0x0122, B:40:0x012b, B:42:0x0130, B:44:0x0149, B:47:0x015e, B:49:0x0183, B:52:0x018b, B:54:0x019a, B:55:0x027f, B:57:0x02ab, B:58:0x02ae, B:60:0x02d6, B:64:0x03ae, B:65:0x03b1, B:66:0x0458, B:71:0x02eb, B:73:0x030e, B:75:0x0316, B:77:0x0320, B:81:0x0333, B:82:0x034a, B:85:0x0356, B:87:0x036a, B:98:0x037b, B:89:0x038f, B:91:0x0397, B:92:0x039f, B:94:0x03a5, B:101:0x0340, B:106:0x02fa, B:107:0x01ab, B:109:0x01d6, B:110:0x01e5, B:112:0x01ec, B:114:0x01f2, B:116:0x01fc, B:118:0x0206, B:120:0x020c, B:122:0x0212, B:124:0x0217, B:127:0x0235, B:131:0x023a, B:132:0x024e, B:133:0x025e, B:134:0x026e, B:135:0x03d7, B:137:0x040e, B:138:0x0411, B:139:0x0434, B:141:0x043a, B:142:0x013c, B:143:0x0128, B:145:0x00e3, B:148:0x00f1, B:150:0x0100, B:152:0x010a, B:156:0x0112), top: B:30:0x00c1, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0122 A[Catch: all -> 0x0467, TryCatch #2 {all -> 0x0467, blocks: (B:31:0x00c1, B:33:0x00d3, B:37:0x0115, B:39:0x0122, B:40:0x012b, B:42:0x0130, B:44:0x0149, B:47:0x015e, B:49:0x0183, B:52:0x018b, B:54:0x019a, B:55:0x027f, B:57:0x02ab, B:58:0x02ae, B:60:0x02d6, B:64:0x03ae, B:65:0x03b1, B:66:0x0458, B:71:0x02eb, B:73:0x030e, B:75:0x0316, B:77:0x0320, B:81:0x0333, B:82:0x034a, B:85:0x0356, B:87:0x036a, B:98:0x037b, B:89:0x038f, B:91:0x0397, B:92:0x039f, B:94:0x03a5, B:101:0x0340, B:106:0x02fa, B:107:0x01ab, B:109:0x01d6, B:110:0x01e5, B:112:0x01ec, B:114:0x01f2, B:116:0x01fc, B:118:0x0206, B:120:0x020c, B:122:0x0212, B:124:0x0217, B:127:0x0235, B:131:0x023a, B:132:0x024e, B:133:0x025e, B:134:0x026e, B:135:0x03d7, B:137:0x040e, B:138:0x0411, B:139:0x0434, B:141:0x043a, B:142:0x013c, B:143:0x0128, B:145:0x00e3, B:148:0x00f1, B:150:0x0100, B:152:0x010a, B:156:0x0112), top: B:30:0x00c1, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0130 A[Catch: all -> 0x0467, TryCatch #2 {all -> 0x0467, blocks: (B:31:0x00c1, B:33:0x00d3, B:37:0x0115, B:39:0x0122, B:40:0x012b, B:42:0x0130, B:44:0x0149, B:47:0x015e, B:49:0x0183, B:52:0x018b, B:54:0x019a, B:55:0x027f, B:57:0x02ab, B:58:0x02ae, B:60:0x02d6, B:64:0x03ae, B:65:0x03b1, B:66:0x0458, B:71:0x02eb, B:73:0x030e, B:75:0x0316, B:77:0x0320, B:81:0x0333, B:82:0x034a, B:85:0x0356, B:87:0x036a, B:98:0x037b, B:89:0x038f, B:91:0x0397, B:92:0x039f, B:94:0x03a5, B:101:0x0340, B:106:0x02fa, B:107:0x01ab, B:109:0x01d6, B:110:0x01e5, B:112:0x01ec, B:114:0x01f2, B:116:0x01fc, B:118:0x0206, B:120:0x020c, B:122:0x0212, B:124:0x0217, B:127:0x0235, B:131:0x023a, B:132:0x024e, B:133:0x025e, B:134:0x026e, B:135:0x03d7, B:137:0x040e, B:138:0x0411, B:139:0x0434, B:141:0x043a, B:142:0x013c, B:143:0x0128, B:145:0x00e3, B:148:0x00f1, B:150:0x0100, B:152:0x010a, B:156:0x0112), top: B:30:0x00c1, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0149 A[Catch: all -> 0x0467, TRY_LEAVE, TryCatch #2 {all -> 0x0467, blocks: (B:31:0x00c1, B:33:0x00d3, B:37:0x0115, B:39:0x0122, B:40:0x012b, B:42:0x0130, B:44:0x0149, B:47:0x015e, B:49:0x0183, B:52:0x018b, B:54:0x019a, B:55:0x027f, B:57:0x02ab, B:58:0x02ae, B:60:0x02d6, B:64:0x03ae, B:65:0x03b1, B:66:0x0458, B:71:0x02eb, B:73:0x030e, B:75:0x0316, B:77:0x0320, B:81:0x0333, B:82:0x034a, B:85:0x0356, B:87:0x036a, B:98:0x037b, B:89:0x038f, B:91:0x0397, B:92:0x039f, B:94:0x03a5, B:101:0x0340, B:106:0x02fa, B:107:0x01ab, B:109:0x01d6, B:110:0x01e5, B:112:0x01ec, B:114:0x01f2, B:116:0x01fc, B:118:0x0206, B:120:0x020c, B:122:0x0212, B:124:0x0217, B:127:0x0235, B:131:0x023a, B:132:0x024e, B:133:0x025e, B:134:0x026e, B:135:0x03d7, B:137:0x040e, B:138:0x0411, B:139:0x0434, B:141:0x043a, B:142:0x013c, B:143:0x0128, B:145:0x00e3, B:148:0x00f1, B:150:0x0100, B:152:0x010a, B:156:0x0112), top: B:30:0x00c1, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02ab A[Catch: all -> 0x0467, TryCatch #2 {all -> 0x0467, blocks: (B:31:0x00c1, B:33:0x00d3, B:37:0x0115, B:39:0x0122, B:40:0x012b, B:42:0x0130, B:44:0x0149, B:47:0x015e, B:49:0x0183, B:52:0x018b, B:54:0x019a, B:55:0x027f, B:57:0x02ab, B:58:0x02ae, B:60:0x02d6, B:64:0x03ae, B:65:0x03b1, B:66:0x0458, B:71:0x02eb, B:73:0x030e, B:75:0x0316, B:77:0x0320, B:81:0x0333, B:82:0x034a, B:85:0x0356, B:87:0x036a, B:98:0x037b, B:89:0x038f, B:91:0x0397, B:92:0x039f, B:94:0x03a5, B:101:0x0340, B:106:0x02fa, B:107:0x01ab, B:109:0x01d6, B:110:0x01e5, B:112:0x01ec, B:114:0x01f2, B:116:0x01fc, B:118:0x0206, B:120:0x020c, B:122:0x0212, B:124:0x0217, B:127:0x0235, B:131:0x023a, B:132:0x024e, B:133:0x025e, B:134:0x026e, B:135:0x03d7, B:137:0x040e, B:138:0x0411, B:139:0x0434, B:141:0x043a, B:142:0x013c, B:143:0x0128, B:145:0x00e3, B:148:0x00f1, B:150:0x0100, B:152:0x010a, B:156:0x0112), top: B:30:0x00c1, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02d6 A[Catch: all -> 0x0467, TRY_LEAVE, TryCatch #2 {all -> 0x0467, blocks: (B:31:0x00c1, B:33:0x00d3, B:37:0x0115, B:39:0x0122, B:40:0x012b, B:42:0x0130, B:44:0x0149, B:47:0x015e, B:49:0x0183, B:52:0x018b, B:54:0x019a, B:55:0x027f, B:57:0x02ab, B:58:0x02ae, B:60:0x02d6, B:64:0x03ae, B:65:0x03b1, B:66:0x0458, B:71:0x02eb, B:73:0x030e, B:75:0x0316, B:77:0x0320, B:81:0x0333, B:82:0x034a, B:85:0x0356, B:87:0x036a, B:98:0x037b, B:89:0x038f, B:91:0x0397, B:92:0x039f, B:94:0x03a5, B:101:0x0340, B:106:0x02fa, B:107:0x01ab, B:109:0x01d6, B:110:0x01e5, B:112:0x01ec, B:114:0x01f2, B:116:0x01fc, B:118:0x0206, B:120:0x020c, B:122:0x0212, B:124:0x0217, B:127:0x0235, B:131:0x023a, B:132:0x024e, B:133:0x025e, B:134:0x026e, B:135:0x03d7, B:137:0x040e, B:138:0x0411, B:139:0x0434, B:141:0x043a, B:142:0x013c, B:143:0x0128, B:145:0x00e3, B:148:0x00f1, B:150:0x0100, B:152:0x010a, B:156:0x0112), top: B:30:0x00c1, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x03ae A[Catch: all -> 0x0467, TryCatch #2 {all -> 0x0467, blocks: (B:31:0x00c1, B:33:0x00d3, B:37:0x0115, B:39:0x0122, B:40:0x012b, B:42:0x0130, B:44:0x0149, B:47:0x015e, B:49:0x0183, B:52:0x018b, B:54:0x019a, B:55:0x027f, B:57:0x02ab, B:58:0x02ae, B:60:0x02d6, B:64:0x03ae, B:65:0x03b1, B:66:0x0458, B:71:0x02eb, B:73:0x030e, B:75:0x0316, B:77:0x0320, B:81:0x0333, B:82:0x034a, B:85:0x0356, B:87:0x036a, B:98:0x037b, B:89:0x038f, B:91:0x0397, B:92:0x039f, B:94:0x03a5, B:101:0x0340, B:106:0x02fa, B:107:0x01ab, B:109:0x01d6, B:110:0x01e5, B:112:0x01ec, B:114:0x01f2, B:116:0x01fc, B:118:0x0206, B:120:0x020c, B:122:0x0212, B:124:0x0217, B:127:0x0235, B:131:0x023a, B:132:0x024e, B:133:0x025e, B:134:0x026e, B:135:0x03d7, B:137:0x040e, B:138:0x0411, B:139:0x0434, B:141:0x043a, B:142:0x013c, B:143:0x0128, B:145:0x00e3, B:148:0x00f1, B:150:0x0100, B:152:0x010a, B:156:0x0112), top: B:30:0x00c1, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzai(com.google.android.gms.measurement.internal.zzr r35) {
        /*
            Method dump skipped, instructions count: 1136
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzai(com.google.android.gms.measurement.internal.zzr):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaj(zzr zzrVar) {
        zzaX().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        int i = 0;
        if (zzd().zzp(null, zzfy.zzay)) {
            long currentTimeMillis = zzba().currentTimeMillis();
            int zzm = zzd().zzm(null, zzfy.zzah);
            zzd();
            long zzF = currentTimeMillis - zzal.zzF();
            while (i < zzm && zzaH(null, zzF)) {
                i++;
            }
        } else {
            zzd();
            long zzH = zzal.zzH();
            while (i < zzH && zzaH(str, 0L)) {
                i++;
            }
        }
        if (zzd().zzp(null, zzfy.zzaz)) {
            zzaX().zzg();
            zzaw();
        }
        if (this.zzl.zzc(str, com.google.android.gms.internal.measurement.zzin.zzb(zzrVar.zzE))) {
            zzaW().zzk().zzb("[sgtm] Going background, trigger client side upload. appId", str);
            zzN(str, zzba().currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzak(zzah zzahVar) {
        zzr zzaP = zzaP((String) Preconditions.checkNotNull(zzahVar.zza));
        if (zzaP != null) {
            zzal(zzahVar, zzaP);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzal(zzah zzahVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzahVar);
        Preconditions.checkNotEmpty(zzahVar.zza);
        Preconditions.checkNotNull(zzahVar.zzb);
        Preconditions.checkNotNull(zzahVar.zzc);
        Preconditions.checkNotEmpty(zzahVar.zzc.zzb);
        zzaX().zzg();
        zzu();
        if (zzaS(zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            zzah zzahVar2 = new zzah(zzahVar);
            boolean z = false;
            zzahVar2.zze = false;
            zzj().zzb();
            try {
                zzah zzq = zzj().zzq((String) Preconditions.checkNotNull(zzahVar2.zza), zzahVar2.zzc.zzb);
                if (zzq != null && !zzq.zzb.equals(zzahVar2.zzb)) {
                    zzaW().zze().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzb, zzq.zzb);
                }
                if (zzq == null || !zzq.zze) {
                    if (TextUtils.isEmpty(zzahVar2.zzf)) {
                        zzpl zzplVar = zzahVar2.zzc;
                        zzahVar2.zzc = new zzpl(zzplVar.zzb, zzahVar2.zzd, zzplVar.zza(), zzahVar2.zzc.zzf);
                        zzahVar2.zze = true;
                        z = true;
                    }
                } else {
                    zzahVar2.zzb = zzq.zzb;
                    zzahVar2.zzd = zzq.zzd;
                    zzahVar2.zzh = zzq.zzh;
                    zzahVar2.zzf = zzq.zzf;
                    zzahVar2.zzi = zzq.zzi;
                    zzahVar2.zze = true;
                    zzpl zzplVar2 = zzahVar2.zzc;
                    zzahVar2.zzc = new zzpl(zzplVar2.zzb, zzq.zzc.zzc, zzplVar2.zza(), zzq.zzc.zzf);
                }
                if (zzahVar2.zze) {
                    zzpl zzplVar3 = zzahVar2.zzc;
                    zzpn zzpnVar = new zzpn((String) Preconditions.checkNotNull(zzahVar2.zza), zzahVar2.zzb, zzplVar3.zzb, zzplVar3.zzc, Preconditions.checkNotNull(zzplVar3.zza()));
                    if (zzj().zzl(zzpnVar)) {
                        zzaW().zzj().zzd("User property updated immediately", zzahVar2.zza, this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                    } else {
                        zzaW().zzb().zzd("(2)Too many active user properties, ignoring", zzgu.zzl(zzahVar2.zza), this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                    }
                    if (z && zzahVar2.zzi != null) {
                        zzH(new zzbh(zzahVar2.zzi, zzahVar2.zzd, 0L), zzrVar);
                    }
                }
                if (zzj().zzp(zzahVar2)) {
                    zzaW().zzj().zzd("Conditional property added", zzahVar2.zza, this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                } else {
                    zzaW().zzb().zzd("Too many conditional properties, ignoring", zzgu.zzl(zzahVar2.zza), this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzam(zzah zzahVar) {
        zzr zzaP = zzaP((String) Preconditions.checkNotNull(zzahVar.zza));
        if (zzaP != null) {
            zzan(zzahVar, zzaP);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzan(zzah zzahVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzahVar);
        Preconditions.checkNotEmpty(zzahVar.zza);
        Preconditions.checkNotNull(zzahVar.zzc);
        Preconditions.checkNotEmpty(zzahVar.zzc.zzb);
        zzaX().zzg();
        zzu();
        if (zzaS(zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            zzj().zzb();
            try {
                zzap(zzrVar);
                String str = (String) Preconditions.checkNotNull(zzahVar.zza);
                zzah zzq = zzj().zzq(str, zzahVar.zzc.zzb);
                if (zzq != null) {
                    zzaW().zzj().zzc("Removing conditional user property", zzahVar.zza, this.zzn.zzl().zzc(zzahVar.zzc.zzb));
                    zzj().zzr(str, zzahVar.zzc.zzb);
                    if (zzq.zze) {
                        zzj().zzk(str, zzahVar.zzc.zzb);
                    }
                    zzbh zzbhVar = zzahVar.zzk;
                    if (zzbhVar != null) {
                        zzbf zzbfVar = zzbhVar.zzb;
                        zzH((zzbh) Preconditions.checkNotNull(zzt().zzaf(str, ((zzbh) Preconditions.checkNotNull(zzbhVar)).zza, zzbfVar != null ? zzbfVar.zzf() : null, zzq.zzb, zzbhVar.zzd, zzbhVar.zze, true, true)), zzrVar);
                    }
                } else {
                    zzaW().zze().zzc("Conditional user property doesn't exist", zzgu.zzl(zzahVar.zza), this.zzn.zzl().zzc(zzahVar.zzc.zzb));
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    final void zzao(zzr zzrVar, long j) {
        zzh zzu = zzj().zzu((String) Preconditions.checkNotNull(zzrVar.zza));
        if (zzu != null && zzt().zzD(zzrVar.zzb, zzu.zzf())) {
            zzaW().zze().zzb("New GMP App Id passed in. Removing cached database data. appId", zzgu.zzl(zzu.zzc()));
            zzaw zzj = zzj();
            String zzc = zzu.zzc();
            zzj.zzay();
            zzj.zzg();
            Preconditions.checkNotEmpty(zzc);
            try {
                SQLiteDatabase zze = zzj.zze();
                String[] strArr = {zzc};
                int delete = zze.delete("events", "app_id=?", strArr) + zze.delete("user_attributes", "app_id=?", strArr) + zze.delete("conditional_properties", "app_id=?", strArr) + zze.delete("apps", "app_id=?", strArr) + zze.delete("raw_events", "app_id=?", strArr) + zze.delete("raw_events_metadata", "app_id=?", strArr) + zze.delete("event_filters", "app_id=?", strArr) + zze.delete("property_filters", "app_id=?", strArr) + zze.delete("audience_filter_values", "app_id=?", strArr) + zze.delete("consent_settings", "app_id=?", strArr) + zze.delete("default_event_params", "app_id=?", strArr) + zze.delete("trigger_uris", "app_id=?", strArr) + zze.delete("diagnostic_signals", "app_id=?", strArr);
                zzahh.zza();
                zzic zzicVar = zzj.zzu;
                if (zzicVar.zzc().zzp(null, zzfy.zzbc)) {
                    delete += zze.delete("no_data_mode_events", "app_id=?", strArr);
                }
                if (delete > 0) {
                    zzicVar.zzaW().zzk().zzc("Deleted application data. app, records", zzc, Integer.valueOf(delete));
                }
            } catch (SQLiteException e) {
                zzj.zzu.zzaW().zzb().zzc("Error deleting application data. appId, error", zzgu.zzl(zzc), e);
            }
            zzu = null;
        }
        if (zzu != null) {
            boolean z = (zzu.zzt() == SieveCacheKt.NodeMetaAndPreviousMask || zzu.zzt() == zzrVar.zzj) ? false : true;
            String zzr = zzu.zzr();
            if (z || ((zzu.zzt() != SieveCacheKt.NodeMetaAndPreviousMask || zzr == null || zzr.equals(zzrVar.zzc)) ? false : true)) {
                Bundle bundle = new Bundle();
                bundle.putString("_pv", zzr);
                zzbh zzbhVar = new zzbh("_au", new zzbf(bundle), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j, 0L);
                if (zzd().zzp(null, zzfy.zzaX)) {
                    zzE(zzbhVar, zzrVar);
                } else {
                    zzF(zzbhVar, zzrVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x018d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzh zzap(com.google.android.gms.measurement.internal.zzr r13) {
        /*
            Method dump skipped, instructions count: 479
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzap(com.google.android.gms.measurement.internal.zzr):com.google.android.gms.measurement.internal.zzh");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzaq(zzr zzrVar) {
        try {
            return (String) zzaX().zzh(new zzoz(this, zzrVar)).get(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzaW().zzb().zzc("Failed to get app instance id. appId", zzgu.zzl(zzrVar.zza), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List zzar(zzr zzrVar, Bundle bundle) {
        zzaX().zzg();
        zzaif.zza();
        zzal zzd = zzd();
        String str = zzrVar.zza;
        if (zzd.zzp(str, zzfy.zzaO) && str != null) {
            if (bundle != null) {
                int[] intArray = bundle.getIntArray("uriSources");
                long[] longArray = bundle.getLongArray("uriTimestamps");
                if (intArray != null) {
                    if (longArray == null || longArray.length != intArray.length) {
                        zzaW().zzb().zza("Uri sources and timestamps do not match");
                    } else {
                        for (int i = 0; i < intArray.length; i++) {
                            zzaw zzj = zzj();
                            int i2 = intArray[i];
                            long j = longArray[i];
                            Preconditions.checkNotEmpty(str);
                            zzj.zzg();
                            zzj.zzay();
                            try {
                                int delete = zzj.zze().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i2), String.valueOf(j)});
                                zzgs zzk = zzj.zzu.zzaW().zzk();
                                StringBuilder sb = new StringBuilder(String.valueOf(delete).length() + 46);
                                sb.append("Pruned ");
                                sb.append(delete);
                                sb.append(" trigger URIs. appId, source, timestamp");
                                zzk.zzd(sb.toString(), str, Integer.valueOf(i2), Long.valueOf(j));
                            } catch (SQLiteException e) {
                                zzj.zzu.zzaW().zzb().zzc("Error pruning trigger URIs. appId", zzgu.zzl(str), e);
                            }
                        }
                    }
                }
            }
            zzaw zzj2 = zzj();
            String str2 = zzrVar.zza;
            Preconditions.checkNotEmpty(str2);
            zzj2.zzg();
            zzj2.zzay();
            List arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    cursor = zzj2.zze().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", FirebaseAnalytics.Param.SOURCE}, "app_id=?", new String[]{str2}, null, null, "rowid", null);
                    if (cursor.moveToFirst()) {
                        do {
                            String string = cursor.getString(0);
                            if (string == null) {
                                string = "";
                            }
                            arrayList.add(new zzoh(string, cursor.getLong(1), cursor.getInt(2)));
                        } while (cursor.moveToNext());
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                zzj2.zzu.zzaW().zzb().zzc("Error querying trigger uris. appId", zzgu.zzl(str2), e2);
                arrayList = Collections.EMPTY_LIST;
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzas(String str, zzaf zzafVar) {
        zzaX().zzg();
        zzu();
        zzaw zzj = zzj();
        long j = zzafVar.zza;
        zzpj zzB = zzj.zzB(j);
        if (zzB == null) {
            zzaW().zze().zzc("[sgtm] Queued batch doesn't exist. appId, rowId", str, Long.valueOf(j));
            return;
        }
        String zze = zzB.zze();
        if (zzafVar.zzb == zzlr.SUCCESS.zza()) {
            Map map = this.zzF;
            if (map.containsKey(zze)) {
                map.remove(zze);
            }
            zzaw zzj2 = zzj();
            Long valueOf = Long.valueOf(j);
            zzj2.zzE(valueOf);
            zzaW().zzk().zzc("[sgtm] queued batch deleted after successful client upload. appId, rowId", str, valueOf);
            long j2 = zzafVar.zzc;
            if (j2 > 0) {
                zzaw zzj3 = zzj();
                zzj3.zzg();
                zzj3.zzay();
                Long valueOf2 = Long.valueOf(j2);
                Preconditions.checkNotNull(valueOf2);
                ContentValues contentValues = new ContentValues();
                contentValues.put("upload_type", Integer.valueOf(zzls.GOOGLE_SIGNAL.zza()));
                zzic zzicVar = zzj3.zzu;
                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzicVar.zzba().currentTimeMillis()));
                try {
                    if (zzj3.zze().update("upload_queue", contentValues, "rowid=? AND app_id=? AND upload_type=?", new String[]{String.valueOf(j2), str, String.valueOf(zzls.GOOGLE_SIGNAL_PENDING.zza())}) != 1) {
                        zzicVar.zzaW().zze().zzc("Google Signal pending batch not updated. appId, rowId", str, valueOf2);
                    }
                    zzaW().zzk().zzc("[sgtm] queued Google Signal batch updated. appId, signalRowId", str, Long.valueOf(zzafVar.zzc));
                    zzP(str);
                    return;
                } catch (SQLiteException e) {
                    zzj3.zzu.zzaW().zzb().zzd("Failed to update google Signal pending batch. appid, rowId", str, Long.valueOf(j2), e);
                    throw e;
                }
            }
            return;
        }
        if (zzafVar.zzb == zzlr.BACKOFF.zza()) {
            Map map2 = this.zzF;
            zzpe zzpeVar = (zzpe) map2.get(zze);
            if (zzpeVar == null) {
                zzpeVar = new zzpe(this);
                map2.put(zze, zzpeVar);
            } else {
                zzpeVar.zza();
            }
            zzaW().zzk().zzd("[sgtm] Putting sGTM server in backoff mode. appId, destination, nextRetryInSeconds", str, zze, Long.valueOf((zzpeVar.zzc() - zzba().currentTimeMillis()) / 1000));
        }
        zzaw zzj4 = zzj();
        Long valueOf3 = Long.valueOf(zzafVar.zza);
        zzj4.zzK(valueOf3);
        zzaW().zzk().zzc("[sgtm] increased batch retry count after failed client upload. appId, rowId", str, valueOf3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzat(boolean z) {
        zzaM();
    }

    public final void zzau(String str, zzlu zzluVar) {
        zzaX().zzg();
        String str2 = this.zzH;
        if (str2 == null || str2.equals(str) || zzluVar != null) {
            this.zzH = str;
            this.zzG = zzluVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzav(zzph zzphVar) {
        zzaX().zzg();
        this.zzm = new zzhk(this);
        zzaw zzawVar = new zzaw(this);
        zzawVar.zzaz();
        this.zze = zzawVar;
        zzd().zza((zzak) Preconditions.checkNotNull(this.zzc));
        zznn zznnVar = new zznn(this);
        zznnVar.zzaz();
        this.zzk = zznnVar;
        zzad zzadVar = new zzad(this);
        zzadVar.zzaz();
        this.zzh = zzadVar;
        zzlp zzlpVar = new zzlp(this);
        zzlpVar.zzaz();
        this.zzj = zzlpVar;
        zzok zzokVar = new zzok(this);
        zzokVar.zzaz();
        this.zzg = zzokVar;
        this.zzf = new zzhb(this);
        if (this.zzs != this.zzt) {
            zzaW().zzb().zzc("Not all upload components initialized", Integer.valueOf(this.zzs), Integer.valueOf(this.zzt));
        }
        this.zzo.set(true);
        zzaW().zzk().zza("UploadController is now fully initialized");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzic zzay() {
        return this.zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Deque zzaz() {
        return this.zzr;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Clock zzba() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzba();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzc() {
        zzaX().zzg();
        zzj().zzI();
        zzaw zzj = zzj();
        zzj.zzg();
        zzj.zzay();
        if (zzj.zzai()) {
            zzfx zzfxVar = zzfy.zzau;
            if (((Long) zzfxVar.zzb(null)).longValue() != 0) {
                SQLiteDatabase zze = zzj.zze();
                zzic zzicVar = zzj.zzu;
                int delete = zze.delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(zzicVar.zzba().currentTimeMillis()), String.valueOf(zzfxVar.zzb(null))});
                if (delete > 0) {
                    zzicVar.zzaW().zzk().zzb("Deleted stale trigger uris. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
        if (this.zzk.zzd.zza() == 0) {
            this.zzk.zzd.zzb(zzba().currentTimeMillis());
        }
        zzaM();
    }

    public final zzal zzd() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzc();
    }

    public final zzou zzf() {
        return this.zzl;
    }

    public final zzht zzh() {
        zzht zzhtVar = this.zzc;
        zzaT(zzhtVar);
        return zzhtVar;
    }

    public final zzgz zzi() {
        zzgz zzgzVar = this.zzd;
        zzaT(zzgzVar);
        return zzgzVar;
    }

    public final zzaw zzj() {
        zzaw zzawVar = this.zze;
        zzaT(zzawVar);
        return zzawVar;
    }

    public final zzhb zzk() {
        zzhb zzhbVar = this.zzf;
        if (zzhbVar != null) {
            return zzhbVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzok zzl() {
        zzok zzokVar = this.zzg;
        zzaT(zzokVar);
        return zzokVar;
    }

    public final zzad zzm() {
        zzad zzadVar = this.zzh;
        zzaT(zzadVar);
        return zzadVar;
    }

    public final zzlp zzn() {
        zzlp zzlpVar = this.zzj;
        zzaT(zzlpVar);
        return zzlpVar;
    }

    public final zzpk zzp() {
        zzpk zzpkVar = this.zzi;
        zzaT(zzpkVar);
        return zzpkVar;
    }

    public final zznn zzq() {
        return this.zzk;
    }

    public final zzgn zzs() {
        return this.zzn.zzl();
    }

    public final zzpp zzt() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzu() {
        if (!this.zzo.get()) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzv(zzr zzrVar) {
        zzaX().zzg();
        zzu();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzjl zzf = zzjl.zzf(zzrVar.zzs, zzrVar.zzx);
        zzB(str);
        zzaW().zzk().zzc("Setting storage consent for package", str, zzf);
        zzA(str, zzf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzw(zzr zzrVar) {
        zzaX().zzg();
        zzu();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzba zzg = zzba.zzg(zzrVar.zzy);
        zzaW().zzk().zzc("Setting DMA consent for package", str, zzg);
        zzaX().zzg();
        zzu();
        zzji zzc = zzba.zzh(zzy(str), 100).zzc();
        this.zzD.put(str, zzg);
        zzj().zzad(str, zzg);
        zzji zzc2 = zzba.zzh(zzy(str), 100).zzc();
        zzaX().zzg();
        zzu();
        zzji zzjiVar = zzji.DENIED;
        boolean z = zzc == zzjiVar && zzc2 == zzji.GRANTED;
        boolean z2 = zzc == zzji.GRANTED && zzc2 == zzjiVar;
        if (z || z2) {
            zzaW().zzk().zzb("Generated _dcu event for", str);
            Bundle bundle = new Bundle();
            if (zzj().zzw(zzC(), str, false, false, false, false, false, false, false).zzf < zzd().zzm(str, zzfy.zzal)) {
                bundle.putLong("_r", 1L);
                zzaW().zzk().zzc("_dcu realtime event count", str, Long.valueOf(zzj().zzw(zzC(), str, false, false, false, false, false, true, false).zzf));
            }
            this.zzK.zza(str, "_dcu", bundle);
        }
    }

    final zzba zzx(String str) {
        zzaX().zzg();
        zzu();
        Map map = this.zzD;
        zzba zzbaVar = (zzba) map.get(str);
        if (zzbaVar != null) {
            return zzbaVar;
        }
        zzba zzab = zzj().zzab(str);
        map.put(str, zzab);
        return zzab;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Bundle zzy(String str) {
        int i;
        String str2;
        zzaX().zzg();
        zzu();
        if (zzh().zzy(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        zzjl zzB = zzB(str);
        bundle.putAll(zzB.zzn());
        bundle.putAll(zzz(str, zzx(str), zzB, new zzan()).zzf());
        zzpn zzm = zzj().zzm(str, "_npa");
        if (zzm != null) {
            i = zzm.zze.equals(1L);
        } else {
            i = zzaD(str, new zzan());
        }
        if (1 != i) {
            str2 = "granted";
        } else {
            str2 = "denied";
        }
        bundle.putString("ad_personalization", str2);
        return bundle;
    }

    final zzba zzz(String str, zzba zzbaVar, zzjl zzjlVar, zzan zzanVar) {
        zzji zzjiVar;
        int i = 90;
        if (zzh().zzy(str) == null) {
            if (zzbaVar.zzc() == zzji.DENIED) {
                i = zzbaVar.zzb();
                zzanVar.zzb(zzjk.AD_USER_DATA, i);
            } else {
                zzanVar.zzc(zzjk.AD_USER_DATA, zzam.FAILSAFE);
            }
            return new zzba((Boolean) false, i, (Boolean) true, "-");
        }
        zzji zzc = zzbaVar.zzc();
        zzji zzjiVar2 = zzji.GRANTED;
        if (zzc == zzjiVar2 || zzc == (zzjiVar = zzji.DENIED)) {
            i = zzbaVar.zzb();
            zzanVar.zzb(zzjk.AD_USER_DATA, i);
        } else {
            if (zzc == zzji.POLICY) {
                zzht zzhtVar = this.zzc;
                zzjk zzjkVar = zzjk.AD_USER_DATA;
                zzji zzB = zzhtVar.zzB(str, zzjkVar);
                if (zzB != zzji.UNINITIALIZED) {
                    zzanVar.zzc(zzjkVar, zzam.REMOTE_ENFORCED_DEFAULT);
                    zzc = zzB;
                }
            }
            zzht zzhtVar2 = this.zzc;
            zzjk zzjkVar2 = zzjk.AD_USER_DATA;
            zzjk zzx = zzhtVar2.zzx(str, zzjkVar2);
            zzji zzp = zzjlVar.zzp();
            boolean z = zzp == zzjiVar2 || zzp == zzjiVar;
            if (zzx == zzjk.AD_STORAGE && z) {
                zzanVar.zzc(zzjkVar2, zzam.REMOTE_DELEGATION);
                zzc = zzp;
            } else {
                zzanVar.zzc(zzjkVar2, zzam.REMOTE_DEFAULT);
                zzc = true != zzhtVar2.zzw(str, zzjkVar2) ? zzjiVar : zzjiVar2;
            }
        }
        boolean zzz = this.zzc.zzz(str);
        SortedSet zzA = zzh().zzA(str);
        if (zzc == zzji.DENIED || zzA.isEmpty()) {
            return new zzba((Boolean) false, i, Boolean.valueOf(zzz), "-");
        }
        return new zzba((Boolean) true, i, Boolean.valueOf(zzz), zzz ? TextUtils.join("", zzA) : "");
    }
}
