package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzgl extends zzg {
    private static final String[] zza = {"app_version", "ALTER TABLE messages ADD COLUMN app_version TEXT;", "app_version_int", "ALTER TABLE messages ADD COLUMN app_version_int INTEGER;"};
    private final zzgj zzb;
    private boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgl(zzic zzicVar) {
        super(zzicVar);
        Context zzaZ = this.zzu.zzaZ();
        this.zzu.zzc();
        this.zzb = new zzgj(this, zzaZ, "google_app_measurement_local.db");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x017c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x017c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0122 A[Catch: all -> 0x015b, TRY_ENTER, TryCatch #16 {all -> 0x015b, blocks: (B:89:0x0078, B:91:0x007e, B:61:0x009e, B:63:0x00c2, B:66:0x00cc, B:69:0x00d4, B:70:0x00e9, B:39:0x0122, B:41:0x0128, B:42:0x012b, B:31:0x0162, B:20:0x014b), top: B:88:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x017c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zzs(int r19, byte[] r20) {
        /*
            Method dump skipped, instructions count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgl.zzs(int, byte[]):boolean");
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return false;
    }

    public final void zzh() {
        int delete;
        zzg();
        try {
            SQLiteDatabase zzp = zzp();
            if (zzp == null || (delete = zzp.delete("messages", null, null)) <= 0) {
                return;
            }
            this.zzu.zzaW().zzk().zzb("Reset local analytics data. records", Integer.valueOf(delete));
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzb("Error resetting local analytics data. error", e);
        }
    }

    public final boolean zzi(zzbh zzbhVar) {
        Parcel obtain = Parcel.obtain();
        zzbi.zza(zzbhVar, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            this.zzu.zzaW().zzc().zza("Event is too long for local database. Sending event directly to service");
            return false;
        }
        return zzs(0, marshall);
    }

    public final boolean zzj(zzpl zzplVar) {
        Parcel obtain = Parcel.obtain();
        zzpm.zza(zzplVar, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            this.zzu.zzaW().zzc().zza("User property too long for local database. Sending directly to service");
            return false;
        }
        return zzs(1, marshall);
    }

    public final boolean zzk(zzah zzahVar) {
        zzic zzicVar = this.zzu;
        byte[] zzah = zzicVar.zzk().zzah(zzahVar);
        if (zzah.length > 131072) {
            zzicVar.zzaW().zzc().zza("Conditional user property too long for local database. Sending directly to service");
            return false;
        }
        return zzs(2, zzah);
    }

    public final boolean zzl(zzbf zzbfVar) {
        zzic zzicVar = this.zzu;
        byte[] zzah = zzicVar.zzk().zzah(zzbfVar);
        if (zzah == null) {
            zzicVar.zzaW().zzc().zza("Null default event parameters; not writing to database");
            return false;
        }
        if (zzah.length > 131072) {
            zzicVar.zzaW().zzc().zza("Default event parameters too long for local database. Sending directly to service");
            return false;
        }
        return zzs(4, zzah);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01d0 A[Catch: SQLiteException -> 0x0224, SQLiteFullException -> 0x0226, SQLiteDatabaseLockedException -> 0x026e, all -> 0x0360, TryCatch #0 {all -> 0x0360, blocks: (B:77:0x00b8, B:79:0x00be, B:82:0x00d1, B:84:0x00d7, B:173:0x00f0, B:182:0x0108, B:184:0x010d, B:20:0x0350, B:48:0x0325, B:50:0x032b, B:51:0x032e, B:39:0x036c, B:197:0x0137, B:198:0x013a, B:195:0x012d, B:89:0x0156, B:92:0x016a, B:98:0x0185, B:101:0x018e, B:102:0x0191, B:104:0x017f, B:107:0x0199, B:115:0x01af, B:117:0x01d0, B:127:0x01da, B:128:0x01dd, B:133:0x01ca, B:140:0x01e3, B:148:0x01f7, B:150:0x0216, B:157:0x0220, B:158:0x0223, B:161:0x0210, B:168:0x022c, B:170:0x023c, B:217:0x027b, B:219:0x0298, B:220:0x02a7), top: B:19:0x0350 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0216 A[Catch: SQLiteException -> 0x02b6, SQLiteFullException -> 0x02b9, SQLiteDatabaseLockedException -> 0x034f, all -> 0x0360, TryCatch #0 {all -> 0x0360, blocks: (B:77:0x00b8, B:79:0x00be, B:82:0x00d1, B:84:0x00d7, B:173:0x00f0, B:182:0x0108, B:184:0x010d, B:20:0x0350, B:48:0x0325, B:50:0x032b, B:51:0x032e, B:39:0x036c, B:197:0x0137, B:198:0x013a, B:195:0x012d, B:89:0x0156, B:92:0x016a, B:98:0x0185, B:101:0x018e, B:102:0x0191, B:104:0x017f, B:107:0x0199, B:115:0x01af, B:117:0x01d0, B:127:0x01da, B:128:0x01dd, B:133:0x01ca, B:140:0x01e3, B:148:0x01f7, B:150:0x0216, B:157:0x0220, B:158:0x0223, B:161:0x0210, B:168:0x022c, B:170:0x023c, B:217:0x027b, B:219:0x0298, B:220:0x02a7), top: B:19:0x0350 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0384 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0384 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0325 A[Catch: all -> 0x0360, TRY_ENTER, TryCatch #0 {all -> 0x0360, blocks: (B:77:0x00b8, B:79:0x00be, B:82:0x00d1, B:84:0x00d7, B:173:0x00f0, B:182:0x0108, B:184:0x010d, B:20:0x0350, B:48:0x0325, B:50:0x032b, B:51:0x032e, B:39:0x036c, B:197:0x0137, B:198:0x013a, B:195:0x012d, B:89:0x0156, B:92:0x016a, B:98:0x0185, B:101:0x018e, B:102:0x0191, B:104:0x017f, B:107:0x0199, B:115:0x01af, B:117:0x01d0, B:127:0x01da, B:128:0x01dd, B:133:0x01ca, B:140:0x01e3, B:148:0x01f7, B:150:0x0216, B:157:0x0220, B:158:0x0223, B:161:0x0210, B:168:0x022c, B:170:0x023c, B:217:0x027b, B:219:0x0298, B:220:0x02a7), top: B:19:0x0350 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0384 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List zzm(int r30) {
        /*
            Method dump skipped, instructions count: 944
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgl.zzm(int):java.util.List");
    }

    public final boolean zzn() {
        return zzs(3, new byte[0]);
    }

    public final boolean zzo() {
        zzg();
        if (!this.zzc && zzq()) {
            int i = 5;
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    this.zzu.zzaW().zze().zza("Error deleting app launch break from local database in reasonable time");
                    break;
                }
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    try {
                        try {
                            SQLiteDatabase zzp = zzp();
                            if (zzp != null) {
                                zzp.beginTransaction();
                                zzp.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                                zzp.setTransactionSuccessful();
                                zzp.endTransaction();
                                zzp.close();
                                return true;
                            }
                            this.zzc = true;
                        } catch (SQLiteFullException e) {
                            this.zzu.zzaW().zzb().zzb("Error deleting app launch break from local database", e);
                            this.zzc = true;
                            if (0 == 0) {
                            }
                            sQLiteDatabase.close();
                        }
                    } catch (SQLiteException e2) {
                        if (0 != 0) {
                            try {
                                if (sQLiteDatabase.inTransaction()) {
                                    sQLiteDatabase.endTransaction();
                                }
                            } catch (Throwable th) {
                                if (0 != 0) {
                                    sQLiteDatabase.close();
                                }
                                throw th;
                            }
                        }
                        this.zzu.zzaW().zzb().zzb("Error deleting app launch break from local database", e2);
                        this.zzc = true;
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                    }
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep(i);
                    i += 20;
                    if (0 == 0) {
                    }
                    sQLiteDatabase.close();
                }
                i2++;
            }
        }
        return false;
    }

    final SQLiteDatabase zzp() throws SQLiteException {
        if (this.zzc) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzb.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzc = true;
        return null;
    }

    final boolean zzq() {
        zzic zzicVar = this.zzu;
        Context zzaZ = zzicVar.zzaZ();
        zzicVar.zzc();
        return zzaZ.getDatabasePath("google_app_measurement_local.db").exists();
    }
}
