package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzgi extends zzg {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private final long zzh;
    private List zzi;
    private String zzj;
    private final String zzk;
    private int zzl;
    private String zzm;
    private String zzn;
    private long zzo;
    private String zzp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgi(zzic zzicVar, long j, long j2, String str) {
        super(zzicVar);
        this.zzo = 0L;
        this.zzp = null;
        this.zzg = j;
        this.zzh = j2;
        this.zzk = str;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:1|(1:3)(6:63|64|(1:66)(2:81|(1:83))|67|68|(18:70|(1:72)(1:79)|73|74|5|(2:7|(2:9|(2:11|(2:13|(2:15|(2:17|(1:19)(1:56))(1:57))(1:58))(1:59))(1:60))(1:61))(1:62)|20|21|22|(1:24)(1:53)|25|(1:27)(1:52)|28|(1:30)|32|(3:34|(1:36)(3:43|(3:46|(1:48)(1:49)|44)|50)|(2:38|39)(2:41|42))|51|(0)(0)))|4|5|(0)(0)|20|21|22|(0)(0)|25|(0)(0)|28|(0)|32|(0)|51|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01a2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01a3, code lost:
    
        r11.zzu.zzaW().zzb().zzc("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.zzgu.zzl(r1), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0190 A[Catch: IllegalStateException -> 0x01a2, TRY_LEAVE, TryCatch #1 {IllegalStateException -> 0x01a2, blocks: (B:22:0x016d, B:25:0x0184, B:28:0x018c, B:30:0x0190, B:53:0x0176), top: B:21:0x016d }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0176 A[Catch: IllegalStateException -> 0x01a2, TryCatch #1 {IllegalStateException -> 0x01a2, blocks: (B:22:0x016d, B:25:0x0184, B:28:0x018c, B:30:0x0190, B:53:0x0176), top: B:21:0x016d }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00c7  */
    @Override // com.google.android.gms.measurement.internal.zzg
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void zzf() {
        /*
            Method dump skipped, instructions count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgi.zzf():void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v0 com.google.android.gms.measurement.internal.zzr, still in use, count: 2, list:
          (r2v0 com.google.android.gms.measurement.internal.zzr) from 0x033a: MOVE (r3v8 com.google.android.gms.measurement.internal.zzr) = (r2v0 com.google.android.gms.measurement.internal.zzr)
          (r2v0 com.google.android.gms.measurement.internal.zzr) from 0x032e: MOVE (r3v12 com.google.android.gms.measurement.internal.zzr) = (r2v0 com.google.android.gms.measurement.internal.zzr)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:80)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:56)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:447)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    final com.google.android.gms.measurement.internal.zzr zzh(java.lang.String r46) {
        /*
            Method dump skipped, instructions count: 892
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgi.zzh(java.lang.String):com.google.android.gms.measurement.internal.zzr");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzi() {
        String format;
        zzg();
        zzic zzicVar = this.zzu;
        if (!zzicVar.zzd().zzl().zzo(zzjk.ANALYTICS_STORAGE)) {
            zzicVar.zzaW().zzj().zza("Analytics Storage consent is not granted");
            format = null;
        } else {
            byte[] bArr = new byte[16];
            zzicVar.zzk().zzf().nextBytes(bArr);
            format = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        zzicVar.zzaW().zzj().zza(String.format("Resetting session stitching token to %s", format == null ? AbstractJsonLexerKt.NULL : "not null"));
        this.zzn = format;
        this.zzo = zzicVar.zzba().currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzj() {
        zzb();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzk() {
        zzg();
        zzb();
        Preconditions.checkNotNull(this.zzm);
        return this.zzm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzl() {
        zzb();
        Preconditions.checkNotNull(this.zze);
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzm() {
        zzb();
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzn() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzo() {
        zzb();
        return this.zzl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List zzp() {
        return this.zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzq(String str) {
        String str2 = this.zzp;
        boolean z = false;
        if (str2 != null && !str2.equals(str)) {
            z = true;
        }
        this.zzp = str;
        return z;
    }
}
