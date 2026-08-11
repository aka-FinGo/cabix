package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzau {
    final /* synthetic */ zzaw zza;
    private final String zzb;
    private long zzc;

    public zzau(zzaw zzawVar, String str) {
        Objects.requireNonNull(zzawVar);
        this.zza = zzawVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d9 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List zza() {
        /*
            r20 = this;
            r1 = r20
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r0 = r1.zzb
            long r3 = r1.zzc
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String[] r8 = new java.lang.String[]{r0, r3}
            java.lang.String r7 = "app_id = ? and rowid > ?"
            java.lang.String r12 = "1000"
            r3 = 0
            com.google.android.gms.measurement.internal.zzaw r0 = r1.zza     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            android.database.sqlite.SQLiteDatabase r4 = r0.zze()     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            java.lang.String r5 = "raw_events"
            java.lang.String r13 = "rowid"
            java.lang.String r14 = "name"
            java.lang.String r15 = "timestamp"
            java.lang.String r16 = "metadata_fingerprint"
            java.lang.String r17 = "data"
            java.lang.String r18 = "realtime"
            java.lang.String r19 = "elapsed_time"
            java.lang.String[] r6 = new java.lang.String[]{r13, r14, r15, r16, r17, r18, r19}     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            java.lang.String r11 = "rowid"
            r9 = 0
            r10 = 0
            android.database.Cursor r3 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            boolean r0 = r3.moveToFirst()     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            if (r0 == 0) goto Lba
        L40:
            r0 = 0
            long r5 = r3.getLong(r0)     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            r4 = 3
            long r7 = r3.getLong(r4)     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            r4 = 5
            long r9 = r3.getLong(r4)     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            r11 = 1
            int r4 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            r9 = 1
            if (r4 != 0) goto L57
            r0 = r9
        L57:
            r4 = 6
            long r10 = r3.getLong(r4)     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            r4 = 4
            byte[] r4 = r3.getBlob(r4)     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            long r12 = r1.zzc     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            int r12 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r12 <= 0) goto L69
            r1.zzc = r5     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
        L69:
            com.google.android.gms.internal.measurement.zzhr r12 = com.google.android.gms.internal.measurement.zzhs.zzp()     // Catch: java.io.IOException -> L9b java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            com.google.android.gms.internal.measurement.zzafb r4 = com.google.android.gms.measurement.internal.zzpk.zzw(r12, r4)     // Catch: java.io.IOException -> L9b java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            com.google.android.gms.internal.measurement.zzhr r4 = (com.google.android.gms.internal.measurement.zzhr) r4     // Catch: java.io.IOException -> L9b java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            java.lang.String r9 = r3.getString(r9)     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            if (r9 != 0) goto L7b
            java.lang.String r9 = ""
        L7b:
            r4.zzl(r9)     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            r9 = 2
            long r12 = r3.getLong(r9)     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            r4.zzo(r12)     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            r4.zzw(r10)     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            r9 = r4
            com.google.android.gms.measurement.internal.zzat r4 = new com.google.android.gms.measurement.internal.zzat     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            com.google.android.gms.internal.measurement.zzadu r9 = r9.zzbd()     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            r10 = r9
            com.google.android.gms.internal.measurement.zzhs r10 = (com.google.android.gms.internal.measurement.zzhs) r10     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            r9 = r0
            r4.<init>(r5, r7, r9, r10)     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            r2.add(r4)     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            goto Lb3
        L9b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzaw r4 = r1.zza     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            com.google.android.gms.measurement.internal.zzic r4 = r4.zzu     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            com.google.android.gms.measurement.internal.zzgu r4 = r4.zzaW()     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            com.google.android.gms.measurement.internal.zzgs r4 = r4.zzb()     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            java.lang.String r5 = "Data loss. Failed to merge raw event. appId"
            java.lang.String r6 = r1.zzb     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzgu.zzl(r6)     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            r4.zzc(r5, r6, r0)     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
        Lb3:
            boolean r0 = r3.moveToNext()     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            if (r0 != 0) goto L40
            goto Ld7
        Lba:
            java.util.List r2 = java.util.Collections.EMPTY_LIST     // Catch: java.lang.Throwable -> Lbd android.database.sqlite.SQLiteException -> Lbf
            goto Ld7
        Lbd:
            r0 = move-exception
            goto Ldd
        Lbf:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzaw r4 = r1.zza     // Catch: java.lang.Throwable -> Lbd
            com.google.android.gms.measurement.internal.zzic r4 = r4.zzu     // Catch: java.lang.Throwable -> Lbd
            com.google.android.gms.measurement.internal.zzgu r4 = r4.zzaW()     // Catch: java.lang.Throwable -> Lbd
            com.google.android.gms.measurement.internal.zzgs r4 = r4.zzb()     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r5 = "Data loss. Error querying raw events batch. appId"
            java.lang.String r1 = r1.zzb     // Catch: java.lang.Throwable -> Lbd
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzgu.zzl(r1)     // Catch: java.lang.Throwable -> Lbd
            r4.zzc(r5, r1, r0)     // Catch: java.lang.Throwable -> Lbd
        Ld7:
            if (r3 == 0) goto Ldc
            r3.close()
        Ldc:
            return r2
        Ldd:
            if (r3 == 0) goto Le2
            r3.close()
        Le2:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzau.zza():java.util.List");
    }

    public zzau(zzaw zzawVar, String str, long j) {
        Objects.requireNonNull(zzawVar);
        this.zza = zzawVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = zzawVar.zzaj("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j)}, -1L);
    }
}
