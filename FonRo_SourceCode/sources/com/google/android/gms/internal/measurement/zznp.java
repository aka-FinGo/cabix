package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public abstract class zznp implements zzom {
    private final String zza;
    private final zzph zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznp(String str, String str2, zzph zzphVar) {
        this.zza = str2;
        this.zzb = zzphVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzom, com.google.common.base.Supplier
    public final Object get() {
        return Preconditions.checkNotNull(zzb(zzlk.zzb()));
    }

    protected Object zza() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d A[Catch: all -> 0x00f3, TryCatch #0 {, blocks: (B:10:0x0014, B:12:0x001b, B:13:0x0030, B:15:0x003a, B:17:0x0050, B:22:0x0067, B:24:0x007d, B:25:0x0083, B:27:0x008d, B:29:0x009d, B:31:0x00a5, B:32:0x00b5, B:45:0x00c1, B:48:0x00c9, B:34:0x00d4, B:38:0x00df, B:40:0x00e5, B:41:0x00eb, B:51:0x006f, B:53:0x00ed), top: B:9:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00df A[Catch: all -> 0x00f3, TryCatch #0 {, blocks: (B:10:0x0014, B:12:0x001b, B:13:0x0030, B:15:0x003a, B:17:0x0050, B:22:0x0067, B:24:0x007d, B:25:0x0083, B:27:0x008d, B:29:0x009d, B:31:0x00a5, B:32:0x00b5, B:45:0x00c1, B:48:0x00c9, B:34:0x00d4, B:38:0x00df, B:40:0x00e5, B:41:0x00eb, B:51:0x006f, B:53:0x00ed), top: B:9:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e5 A[Catch: all -> 0x00f3, TryCatch #0 {, blocks: (B:10:0x0014, B:12:0x001b, B:13:0x0030, B:15:0x003a, B:17:0x0050, B:22:0x0067, B:24:0x007d, B:25:0x0083, B:27:0x008d, B:29:0x009d, B:31:0x00a5, B:32:0x00b5, B:45:0x00c1, B:48:0x00c9, B:34:0x00d4, B:38:0x00df, B:40:0x00e5, B:41:0x00eb, B:51:0x006f, B:53:0x00ed), top: B:9:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzaA(com.google.android.gms.internal.measurement.zznw r9, final com.google.android.gms.internal.measurement.zzlk r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zznp.zzaA(com.google.android.gms.internal.measurement.zznw, com.google.android.gms.internal.measurement.zzlk, java.lang.String):java.lang.Object");
    }

    protected abstract Object zzb(zzlk zzlkVar);

    protected abstract Object zzc(String str) throws IOException;

    protected abstract Object zzd(Object obj) throws IOException;
}
