package com.google.android.gms.internal.measurement;

import android.os.StrictMode;
import android.util.Log;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzpg {
    public static final /* synthetic */ int zzb = 0;
    private volatile zzqs zzd;
    private final zzlk zze;
    private final String zzf;
    private final String zzg;
    private final boolean zzh;
    private final ImmutableSet zzi;
    private final zzps zzj;
    private final zzqt zzk;
    private static final zzpe zzc = new zzpe(null);
    static final zzon zza = new zzon(zzox.zza, false, false, false, false, ImmutableSet.of());

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpg(zzlk zzlkVar, zzon zzonVar, String str, byte[] bArr) {
        this.zze = zzlkVar;
        String zza2 = zzonVar.zza(zzlkVar.zzc());
        this.zzf = zza2;
        this.zzg = "";
        this.zzh = zzonVar.zzb();
        this.zzi = zzonVar.zzc();
        this.zzd = null;
        this.zzj = new zzps();
        this.zzk = new zzqt(zzlkVar, zza2, "", false);
    }

    public static zzpe zzd() {
        return zzc;
    }

    private final zzqs zzq() {
        zzqs zzqsVar;
        zzqs zzqsVar2 = this.zzd;
        if (zzqsVar2 != null) {
            return zzqsVar2;
        }
        synchronized (this) {
            zzqsVar = this.zzd;
            if (zzqsVar == null) {
                StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
                try {
                    zzqs zza2 = this.zzk.zza();
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    if (!zza2.zzk()) {
                        zzlk zzlkVar = this.zze;
                        zzlkVar.zzd().zza();
                        if (this.zzh || this.zzk.zzb() || !zza2.zzd().isEmpty()) {
                            zzlkVar.zzg().execute(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzoy
                                @Override // java.lang.Runnable
                                public final /* synthetic */ void run() {
                                    zzpg.this.zzf();
                                }
                            });
                            zzlkVar.zzk().zza(zza2.zze(), this.zzi, this.zzf);
                            if (!this.zzg.equals("")) {
                                zzlkVar.zzg().execute(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzoq
                                    @Override // java.lang.Runnable
                                    public final /* synthetic */ void run() {
                                        zzpg.this.zzh();
                                    }
                                });
                            }
                            if (this.zzk.zzb()) {
                                zzlkVar.zzg().execute(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzor
                                    @Override // java.lang.Runnable
                                    public final /* synthetic */ void run() {
                                        zzpg.this.zzi();
                                    }
                                });
                            }
                        } else {
                            zzlkVar.zzg().execute(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzop
                                @Override // java.lang.Runnable
                                public final /* synthetic */ void run() {
                                    zzpg.this.zzg();
                                }
                            });
                            zzqsVar = zzqs.zzb(zzqv.zzi(), zza2);
                            if (this.zzh || !zzqsVar.zzj()) {
                                this.zzd = zzqsVar;
                            }
                        }
                    }
                    zzqsVar = zza2;
                    if (this.zzh) {
                    }
                    this.zzd = zzqsVar;
                } catch (Throwable th) {
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    throw th;
                }
            }
        }
        return zzqsVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzr, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void zzg() {
        final zzqt zzqtVar = this.zzk;
        final ListenableFuture zzd = zzqtVar.zzd(this.zzg);
        Objects.requireNonNull(zzqtVar);
        AsyncFunction asyncFunction = new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzpf
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return zzqt.this.zzc((zzqv) obj);
            }
        };
        zzlk zzlkVar = this.zze;
        Futures.transformAsync(zzd, asyncFunction, zzlkVar.zzg()).addListener(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzov
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzpg.this.zzm(zzd);
            }
        }, zzlkVar.zzg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004b A[Catch: CancellationException | ExecutionException -> 0x006b, ExecutionException -> 0x006d, TRY_LEAVE, TryCatch #3 {CancellationException | ExecutionException -> 0x006b, blocks: (B:2:0x0000, B:4:0x0018, B:6:0x0025, B:8:0x0033, B:10:0x003b, B:14:0x0047, B:16:0x004b, B:19:0x001c, B:30:0x006a, B:24:0x001f, B:27:0x0024, B:21:0x003f, B:22:0x0046), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* renamed from: zzs, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ void zzm(com.google.common.util.concurrent.ListenableFuture r4) {
        /*
            r3 = this;
            java.lang.Object r4 = com.google.common.util.concurrent.Futures.getDone(r4)     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            com.google.android.gms.internal.measurement.zzqv r4 = (com.google.android.gms.internal.measurement.zzqv) r4     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            com.google.android.gms.internal.measurement.zzqr r0 = new com.google.android.gms.internal.measurement.zzqr     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            r1 = 6
            r2 = 2
            r0.<init>(r1, r2)     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            com.google.android.gms.internal.measurement.zzqs r0 = com.google.android.gms.internal.measurement.zzqs.zza(r4, r0)     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            boolean r1 = r3.zzh     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            com.google.common.base.Preconditions.checkNotNull(r0)     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            if (r1 != 0) goto L1c
            com.google.android.gms.internal.measurement.zzqs r2 = r3.zzd     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            if (r2 != 0) goto L25
        L1c:
            monitor-enter(r3)     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            if (r1 != 0) goto L3f
            com.google.android.gms.internal.measurement.zzqs r2 = r3.zzd     // Catch: java.lang.Throwable -> L68
            if (r2 != 0) goto L24
            goto L3f
        L24:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L68
        L25:
            com.google.common.collect.ImmutableMap r1 = r2.zzf()     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            com.google.common.collect.ImmutableMap r0 = r0.zzf()     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            boolean r0 = r1.equals(r0)     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            if (r0 != 0) goto L47
            com.google.android.gms.internal.measurement.zzlk r4 = r3.zze     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            com.google.android.gms.internal.measurement.zzqm r4 = r4.zzj()     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            if (r4 == 0) goto L9d
            r4.zza()     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            return
        L3f:
            r3.zzd = r0     // Catch: java.lang.Throwable -> L68
            com.google.android.gms.internal.measurement.zzps r0 = r3.zzj     // Catch: java.lang.Throwable -> L68
            r0.zzb()     // Catch: java.lang.Throwable -> L68
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L68
        L47:
            boolean r0 = r3.zzh     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            if (r0 == 0) goto L9d
            com.google.android.gms.internal.measurement.zzlk r0 = r3.zze     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            com.google.android.gms.internal.measurement.zzmj r1 = r0.zzh()     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            java.lang.String r4 = r4.zza()     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            com.google.common.util.concurrent.ListenableFuture r4 = r1.zzb(r4)     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            java.lang.Class<java.lang.Throwable> r1 = java.lang.Throwable.class
            com.google.android.gms.internal.measurement.zzow r2 = new com.google.android.gms.internal.measurement.zzow     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            r2.<init>()     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            com.google.common.util.concurrent.ListeningScheduledExecutorService r0 = r0.zzg()     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            com.google.common.util.concurrent.Futures.catching(r4, r1, r2, r0)     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            return
        L68:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L68
            throw r4     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
        L6b:
            r4 = move-exception
            goto L6e
        L6d:
            r4 = move-exception
        L6e:
            java.lang.Throwable r0 = r4.getCause()
            boolean r0 = r0 instanceof java.lang.SecurityException
            if (r0 != 0) goto L9d
            java.lang.String r3 = r3.zzf
            java.lang.String r0 = java.lang.String.valueOf(r3)
            int r0 = r0.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r0 = r0 + 64
            r1.<init>(r0)
            java.lang.String r0 = "Unable to update local snapshot for "
            r1.append(r0)
            r1.append(r3)
            java.lang.String r3 = ", may result in stale flags."
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            java.lang.String r0 = "FlagStore"
            android.util.Log.w(r0, r3, r4)
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzpg.zzm(com.google.common.util.concurrent.ListenableFuture):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object zza(String str, boolean z) {
        return zzq().zzf().get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzb() {
        return this.zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzps zzc() {
        return this.zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzf() {
        ListenableFuture zzb2;
        zzqs zzq = zzq();
        String zzd = zzq.zzd();
        zzlk zzlkVar = this.zze;
        zzqn zzc2 = zzlkVar.zzd().zzc(false);
        if (zzc2.zze()) {
            if (Strings.isNullOrEmpty(zzd) && !zzc2.zzd()) {
                return Futures.immediateVoidFuture();
            }
            zzmb zzb3 = zzme.zzb();
            zzb3.zzb(zzq.zzi());
            if (!Strings.isNullOrEmpty(zzd)) {
                zzb3.zza(zzd);
            }
            if (zzc2.zzd()) {
                zzb3.zzc(this.zzf);
            }
            zzb2 = zzlkVar.zzh().zzc((zzme) zzb3.zzbd());
        } else {
            if (Strings.isNullOrEmpty(zzd)) {
                return Futures.immediateVoidFuture();
            }
            zzb2 = zzlkVar.zzh().zzb(zzd);
        }
        return Futures.catchingAsync(zzb2, zzmk.class, new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzos
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return zzpg.this.zzj((zzmk) obj);
            }
        }, zzlkVar.zzg());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzh() {
        zzlk zzlkVar = this.zze;
        final ListenableFuture zza2 = zzpu.zza(zzlkVar, this.zzf, this.zzg);
        zza2.addListener(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzot
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzpg.this.zzk(zza2);
            }
        }, zzlkVar.zzg());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzi() {
        this.zze.zzf().zza(zzabz.FILE, this.zzh, zzou.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzj(zzmk zzmkVar) {
        int zza2 = zzmkVar.zza();
        if ((zza2 == 29501 || zza2 == 29537 || zza2 == 29538 || zza2 == 29539 || zza2 == 29540 || zza2 == 29541 || zza2 == 29542 || zza2 == 29543 || zza2 == 29544) && !this.zzk.zzb()) {
            zzg();
        }
        return Futures.immediateVoidFuture();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(ListenableFuture listenableFuture) {
        try {
            Futures.getDone(listenableFuture);
        } catch (Exception e) {
            String str = this.zzf;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 73);
            sb.append("Failed to store account on flag read for: ");
            sb.append(str);
            sb.append(" which may lead to stale flags.");
            Log.w("FlagStore", sb.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void zzn(Throwable th) {
        String str = this.zzf;
        String.valueOf(str);
        Log.w("FlagStore", "Failed to commit to updated flags for ".concat(String.valueOf(str)), th);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean zzo() {
        if (!this.zzh) {
            return true;
        }
        zzqs zzqsVar = this.zzd;
        if (zzqsVar == null) {
            return false;
        }
        if (!zzqsVar.zzh() && !zzqsVar.zzg() && !this.zzk.zzb()) {
            return false;
        }
        synchronized (this) {
            zzqs zzqsVar2 = this.zzd;
            if (zzqsVar2 != null && (zzqsVar2.zzh() || zzqsVar2.zzg() || this.zzk.zzb())) {
                this.zzd = null;
                this.zzj.zzb();
            }
        }
        return false;
    }

    final /* synthetic */ String zzp() {
        return this.zzf;
    }
}
