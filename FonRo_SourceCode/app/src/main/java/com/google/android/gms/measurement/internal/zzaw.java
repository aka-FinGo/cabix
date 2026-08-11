package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzahk;
import com.google.android.gms.internal.measurement.zzaif;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzaw extends zzos {
    private final zzav zzm;
    private final zzog zzn;
    private static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    static final String[] zza = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;", "last_upload_timestamp", "ALTER TABLE upload_queue ADD COLUMN last_upload_timestamp INTEGER;"};
    private static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;", "gmp_version_for_remote_config", "ALTER TABLE apps ADD COLUMN gmp_version_for_remote_config INTEGER;", "last_diagnostics_signal_upload_timestamp", "ALTER TABLE apps ADD COLUMN last_diagnostics_signal_upload_timestamp INTEGER;"};
    private static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;", "elapsed_time", "ALTER TABLE raw_events ADD COLUMN elapsed_time INTEGER;"};
    private static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzj = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private static final String[] zzk = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    private static final String[] zzl = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaw(zzpg zzpgVar) {
        super(zzpgVar);
        this.zzn = new zzog(this.zzu.zzba());
        this.zzu.zzc();
        this.zzm = new zzav(this, this.zzu.zzaZ(), "google_app_measurement.db");
    }

    private final long zzaA(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = zze().rawQuery(str, strArr);
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e) {
                this.zzu.zzaW().zzb().zzc("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zzaB(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            try {
                cursor = zze().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    j = cursor.getLong(0);
                }
                return j;
            } catch (SQLiteException e) {
                this.zzu.zzaW().zzb().zzc("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private final String zzaC(String str, String[] strArr, String str2) {
        Cursor cursor = null;
        try {
            try {
                cursor = zze().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    return cursor.getString(0);
                }
                if (cursor == null) {
                    return "";
                }
                cursor.close();
                return "";
            } catch (SQLiteException e) {
                this.zzu.zzaW().zzb().zzc("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private final void zzaD(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase zze2 = zze();
            if (contentValues.getAsString("app_id") != null) {
                new StringBuilder(10).append("app_id = ?");
                if (zze2.update("consent_settings", contentValues, r3.toString(), new String[]{r2}) == 0 && zze2.insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                    this.zzu.zzaW().zzb().zzc("Failed to insert/update table (got -1). key", zzgu.zzl("consent_settings"), zzgu.zzl("app_id"));
                    return;
                }
                return;
            }
            this.zzu.zzaW().zzd().zzb("Value of the primary key is not set.", zzgu.zzl("app_id"));
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzd("Error storing into table. key", zzgu.zzl("consent_settings"), zzgu.zzl("app_id"), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.measurement.internal.zzbd zzaE(java.lang.String r30, java.lang.String r31, java.lang.String r32) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaw.zzaE(java.lang.String, java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzbd");
    }

    private final void zzaF(String str, zzbd zzbdVar) {
        Preconditions.checkNotNull(zzbdVar);
        zzg();
        zzay();
        ContentValues contentValues = new ContentValues();
        String str2 = zzbdVar.zza;
        contentValues.put("app_id", str2);
        contentValues.put("name", zzbdVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzbdVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzbdVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzbdVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzbdVar.zzg));
        contentValues.put("last_bundled_day", zzbdVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzbdVar.zzi);
        contentValues.put("last_sampling_rate", zzbdVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzbdVar.zze));
        Boolean bool = zzbdVar.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (zze().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                this.zzu.zzaW().zzb().zzb("Failed to insert/update event aggregates (got -1). appId", zzgu.zzl(str2));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzc("Error storing event aggregates. appId", zzgu.zzl(zzbdVar.zza), e);
        }
    }

    private final void zzaG(String str, String str2) {
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzay();
        try {
            zze().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzc("Error deleting snapshot. appId", zzgu.zzl(str2), e);
        }
    }

    private final zzpj zzaH(String str, long j, byte[] bArr, String str2, String str3, int i, int i2, long j2, long j3, long j4) {
        if (TextUtils.isEmpty(str2)) {
            this.zzu.zzaW().zzj().zza("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            com.google.android.gms.internal.measurement.zzhz zzhzVar = (com.google.android.gms.internal.measurement.zzhz) zzpk.zzw(com.google.android.gms.internal.measurement.zzib.zzi(), bArr);
            zzls zzb2 = zzls.zzb(i);
            if (zzb2 != zzls.GOOGLE_SIGNAL && zzb2 != zzls.GOOGLE_SIGNAL_PENDING && i2 > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it = zzhzVar.zza().iterator();
                while (it.hasNext()) {
                    com.google.android.gms.internal.measurement.zzic zzicVar = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) it.next()).zzco();
                    zzicVar.zzao(i2);
                    arrayList.add((com.google.android.gms.internal.measurement.zzid) zzicVar.zzbd());
                }
                zzhzVar.zzg();
                zzhzVar.zzf(arrayList);
            }
            HashMap hashMap = new HashMap();
            if (str3 != null) {
                String[] split = str3.split("\r\n");
                int length = split.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    String str4 = split[i3];
                    if (str4.isEmpty()) {
                        break;
                    }
                    String[] split2 = str4.split("=", 2);
                    if (split2.length == 2) {
                        hashMap.put(split2[0], split2[1]);
                        i3++;
                    } else {
                        this.zzu.zzaW().zzb().zzb("Invalid upload header: ", str4);
                        break;
                    }
                }
            }
            zzpi zzpiVar = new zzpi();
            zzpiVar.zzb(j);
            zzpiVar.zzc((com.google.android.gms.internal.measurement.zzib) zzhzVar.zzbd());
            zzpiVar.zzd(str2);
            zzpiVar.zze(hashMap);
            zzpiVar.zzf(zzb2);
            zzpiVar.zzg(j2);
            zzpiVar.zzh(j3);
            zzpiVar.zzi(j4);
            zzpiVar.zzj(i2);
            return zzpiVar.zza();
        } catch (IOException e) {
            this.zzu.zzaW().zzb().zzc("Failed to queued MeasurementBatch from upload_queue. appId", str, e);
            return null;
        }
    }

    private final String zzaI() {
        zzic zzicVar = this.zzu;
        long currentTimeMillis = zzicVar.zzba().currentTimeMillis();
        Locale locale = Locale.US;
        zzls zzlsVar = zzls.GOOGLE_SIGNAL;
        Integer valueOf = Integer.valueOf(zzlsVar.zza());
        Long valueOf2 = Long.valueOf(currentTimeMillis);
        zzicVar.zzc();
        Long l = (Long) zzfy.zzS.zzb(null);
        l.longValue();
        String format = String.format(locale, "(upload_type = %d AND ABS(creation_timestamp - %d) > %d)", valueOf, valueOf2, l);
        Locale locale2 = Locale.US;
        Integer valueOf3 = Integer.valueOf(zzlsVar.zza());
        zzicVar.zzc();
        String format2 = String.format(locale2, "(upload_type != %d AND ABS(creation_timestamp - %d) > %d)", valueOf3, valueOf2, Long.valueOf(zzal.zzI()));
        StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 5 + String.valueOf(format2).length() + 1);
        sb.append("(");
        sb.append(format);
        sb.append(" OR ");
        sb.append(format2);
        sb.append(")");
        return sb.toString();
    }

    private static final String zzaJ(List list) {
        return list.isEmpty() ? "" : String.format(" AND (upload_type IN (%s))", TextUtils.join(", ", list));
    }

    static final void zzaw(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty("value");
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            if (obj instanceof Double) {
                contentValues.put("value", (Double) obj);
                return;
            }
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    public final long zzA(String str, com.google.android.gms.internal.measurement.zzib zzibVar, String str2, Map map, zzls zzlsVar, Long l) {
        int delete;
        zzg();
        zzay();
        Preconditions.checkNotNull(zzibVar);
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        if (zzai()) {
            zzpg zzpgVar = this.zzg;
            long zza2 = zzpgVar.zzq().zzb.zza();
            zzic zzicVar = this.zzu;
            long elapsedRealtime = zzicVar.zzba().elapsedRealtime();
            long abs = Math.abs(elapsedRealtime - zza2);
            zzicVar.zzc();
            if (abs > zzal.zzJ()) {
                zzpgVar.zzq().zzb.zzb(elapsedRealtime);
                zzg();
                zzay();
                if (zzai() && (delete = zze().delete("upload_queue", zzaI(), new String[0])) > 0) {
                    zzicVar.zzaW().zzk().zzb("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", Integer.valueOf(delete));
                }
                Preconditions.checkNotEmpty(str);
                zzg();
                zzay();
                try {
                    int zzm = zzicVar.zzc().zzm(str, zzfy.zzz);
                    if (zzm > 0) {
                        zze().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(zzm)});
                    }
                } catch (SQLiteException e) {
                    this.zzu.zzaW().zzb().zzc("Error deleting over the limit queued batches. appId", zzgu.zzl(str), e);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getKey();
            String str4 = (String) entry.getValue();
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 1 + String.valueOf(str4).length());
            sb.append(str3);
            sb.append("=");
            sb.append(str4);
            arrayList.add(sb.toString());
        }
        byte[] zzcd = zzibVar.zzcd();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("measurement_batch", zzcd);
        contentValues.put("upload_uri", str2);
        contentValues.put("upload_headers", TextUtils.join("\r\n", arrayList));
        contentValues.put("upload_type", Integer.valueOf(zzlsVar.zza()));
        zzic zzicVar2 = this.zzu;
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzicVar2.zzba().currentTimeMillis()));
        contentValues.put("retry_count", (Integer) 0);
        if (l != null) {
            contentValues.put("associated_row_id", l);
        }
        try {
            long insert = zze().insert("upload_queue", null, contentValues);
            if (insert != -1) {
                return insert;
            }
            zzicVar2.zzaW().zzb().zzb("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", str);
            return -1L;
        } catch (SQLiteException e2) {
            this.zzu.zzaW().zzb().zzc("Error storing MeasurementBatch to upload_queue. appId", str, e2);
            return -1L;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00a5: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:22:0x00a5 */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzpj zzB(long r19) {
        /*
            r18 = this;
            r18.zzg()
            r18.zzay()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r18.zze()     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            java.lang.String r3 = "upload_queue"
            java.lang.String r4 = "rowId"
            java.lang.String r5 = "app_id"
            java.lang.String r6 = "measurement_batch"
            java.lang.String r7 = "upload_uri"
            java.lang.String r8 = "upload_headers"
            java.lang.String r9 = "upload_type"
            java.lang.String r10 = "retry_count"
            java.lang.String r11 = "creation_timestamp"
            java.lang.String r12 = "associated_row_id"
            java.lang.String r13 = "last_upload_timestamp"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7, r8, r9, r10, r11, r12, r13}     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            java.lang.String r5 = "rowId=?"
            java.lang.String r0 = java.lang.String.valueOf(r19)     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            java.lang.String[] r6 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            java.lang.String r10 = "1"
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            boolean r0 = r2.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> La4
            if (r0 != 0) goto L3f
            goto L9e
        L3f:
            r0 = 1
            java.lang.String r0 = r2.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> La4
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> La4
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> La4
            r0 = 2
            byte[] r7 = r2.getBlob(r0)     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> La4
            r0 = 3
            java.lang.String r8 = r2.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> La4
            r0 = 4
            java.lang.String r9 = r2.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> La4
            r0 = 5
            int r10 = r2.getInt(r0)     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> La4
            r0 = 6
            int r11 = r2.getInt(r0)     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> La4
            r0 = 7
            long r12 = r2.getLong(r0)     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> La4
            r0 = 8
            long r14 = r2.getLong(r0)     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> La4
            r0 = 9
            long r16 = r2.getLong(r0)     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> La4
            r3 = r18
            r5 = r19
            com.google.android.gms.measurement.internal.zzpj r0 = r3.zzaH(r4, r5, r7, r8, r9, r10, r11, r12, r14, r16)     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> La4
            if (r2 == 0) goto L82
            r2.close()
        L82:
            return r0
        L83:
            r0 = move-exception
            goto L89
        L85:
            r0 = move-exception
            goto La6
        L87:
            r0 = move-exception
            r2 = r1
        L89:
            r3 = r18
            com.google.android.gms.measurement.internal.zzic r3 = r3.zzu     // Catch: java.lang.Throwable -> La4
            com.google.android.gms.measurement.internal.zzgu r3 = r3.zzaW()     // Catch: java.lang.Throwable -> La4
            com.google.android.gms.measurement.internal.zzgs r3 = r3.zzb()     // Catch: java.lang.Throwable -> La4
            java.lang.String r4 = "Error to querying MeasurementBatch from upload_queue. rowId"
            java.lang.Long r5 = java.lang.Long.valueOf(r19)     // Catch: java.lang.Throwable -> La4
            r3.zzc(r4, r5, r0)     // Catch: java.lang.Throwable -> La4
        L9e:
            if (r2 == 0) goto La3
            r2.close()
        La3:
            return r1
        La4:
            r0 = move-exception
            r1 = r2
        La6:
            if (r1 == 0) goto Lab
            r1.close()
        Lab:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaw.zzB(long):com.google.android.gms.measurement.internal.zzpj");
    }

    public final List zzC(String str, zzoo zzooVar, int i) {
        List list;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase zze2 = zze();
                String[] strArr = {"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "associated_row_id", "last_upload_timestamp"};
                String zzaJ = zzaJ(zzooVar.zza);
                String zzaI = zzaI();
                StringBuilder sb = new StringBuilder(String.valueOf(zzaJ).length() + 17 + zzaI.length());
                sb.append("app_id=?");
                sb.append(zzaJ);
                sb.append(" AND NOT ");
                sb.append(zzaI);
                cursor = zze2.query("upload_queue", strArr, sb.toString(), new String[]{str}, null, null, "creation_timestamp ASC", i > 0 ? String.valueOf(i) : null);
                list = new ArrayList();
                while (cursor.moveToNext()) {
                    zzpj zzaH = zzaH(str, cursor.getLong(0), cursor.getBlob(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5), cursor.getInt(6), cursor.getLong(7), cursor.getLong(8), cursor.getLong(9));
                    if (zzaH != null) {
                        list.add(zzaH);
                    }
                }
            } catch (SQLiteException e) {
                this.zzu.zzaW().zzb().zzc("Error to querying MeasurementBatch from upload_queue. appId", str, e);
                list = Collections.EMPTY_LIST;
            }
            return list;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final boolean zzD(String str) {
        zzls[] zzlsVarArr = {zzls.GOOGLE_SIGNAL};
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(zzlsVarArr[0].zza()));
        String zzaJ = zzaJ(arrayList);
        String zzaI = zzaI();
        StringBuilder sb = new StringBuilder(String.valueOf(zzaJ).length() + 61 + zzaI.length());
        sb.append("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?");
        sb.append(zzaJ);
        sb.append(" AND NOT ");
        sb.append(zzaI);
        return zzaA(sb.toString(), new String[]{str}) != 0;
    }

    public final void zzE(Long l) {
        zzg();
        zzay();
        Preconditions.checkNotNull(l);
        try {
            if (zze().delete("upload_queue", "rowid=?", new String[]{l.toString()}) != 1) {
                this.zzu.zzaW().zze().zza("Deleted fewer rows from upload_queue than expected");
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzb("Failed to delete a MeasurementBatch in a upload_queue table", e);
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003c  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String zzF() {
        /*
            r4 = this;
            android.database.sqlite.SQLiteDatabase r0 = r4.zze()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L1e android.database.sqlite.SQLiteException -> L20
            boolean r2 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L1c java.lang.Throwable -> L38
            if (r2 == 0) goto L32
            r2 = 0
            java.lang.String r4 = r0.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L1c java.lang.Throwable -> L38
            if (r0 == 0) goto L1b
            r0.close()
        L1b:
            return r4
        L1c:
            r2 = move-exception
            goto L23
        L1e:
            r4 = move-exception
            goto L3a
        L20:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L23:
            com.google.android.gms.measurement.internal.zzic r4 = r4.zzu     // Catch: java.lang.Throwable -> L38
            com.google.android.gms.measurement.internal.zzgu r4 = r4.zzaW()     // Catch: java.lang.Throwable -> L38
            com.google.android.gms.measurement.internal.zzgs r4 = r4.zzb()     // Catch: java.lang.Throwable -> L38
            java.lang.String r3 = "Database error getting next bundle app id"
            r4.zzb(r3, r2)     // Catch: java.lang.Throwable -> L38
        L32:
            if (r0 == 0) goto L37
            r0.close()
        L37:
            return r1
        L38:
            r4 = move-exception
            r1 = r0
        L3a:
            if (r1 == 0) goto L3f
            r1.close()
        L3f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaw.zzF():java.lang.String");
    }

    public final boolean zzG() {
        return zzaA("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    public final void zzH(long j) {
        zzg();
        zzay();
        try {
            if (zze().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) == 1) {
            } else {
                throw new SQLiteException("Deleted fewer rows from queue than expected");
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzb("Failed to delete a bundle in a queue table", e);
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzI() {
        zzg();
        zzay();
        if (zzai()) {
            zzpg zzpgVar = this.zzg;
            long zza2 = zzpgVar.zzq().zza.zza();
            zzic zzicVar = this.zzu;
            long elapsedRealtime = zzicVar.zzba().elapsedRealtime();
            long abs = Math.abs(elapsedRealtime - zza2);
            zzicVar.zzc();
            if (abs > zzal.zzJ()) {
                zzpgVar.zzq().zza.zzb(elapsedRealtime);
                zzg();
                zzay();
                if (zzai()) {
                    SQLiteDatabase zze2 = zze();
                    String valueOf = String.valueOf(zzicVar.zzba().currentTimeMillis());
                    zzicVar.zzc();
                    int delete = zze2.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{valueOf, String.valueOf(zzal.zzI())});
                    if (delete > 0) {
                        zzicVar.zzaW().zzk().zzb("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzJ(List list) {
        zzg();
        zzay();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzai()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(sb2.length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzaA(sb3.toString(), null) > 0) {
                this.zzu.zzaW().zze().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase zze2 = zze();
                StringBuilder sb4 = new StringBuilder(sb2.length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                zze2.execSQL(sb4.toString());
            } catch (SQLiteException e) {
                this.zzu.zzaW().zzb().zzb("Error incrementing retry count. error", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzK(Long l) {
        zzg();
        zzay();
        Preconditions.checkNotNull(l);
        if (zzai()) {
            StringBuilder sb = new StringBuilder(l.toString().length() + 86);
            sb.append("SELECT COUNT(1) FROM upload_queue WHERE rowid = ");
            sb.append(l);
            sb.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzaA(sb.toString(), null) > 0) {
                this.zzu.zzaW().zze().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase zze2 = zze();
                long currentTimeMillis = this.zzu.zzba().currentTimeMillis();
                StringBuilder sb2 = new StringBuilder(String.valueOf(currentTimeMillis).length() + 60);
                sb2.append(" SET retry_count = retry_count + 1, last_upload_timestamp = ");
                sb2.append(currentTimeMillis);
                String sb3 = sb2.toString();
                StringBuilder sb4 = new StringBuilder(sb3.length() + 34 + l.toString().length() + 29);
                sb4.append("UPDATE upload_queue");
                sb4.append(sb3);
                sb4.append(" WHERE rowid = ");
                sb4.append(l);
                sb4.append(" AND retry_count < 2147483647");
                zze2.execSQL(sb4.toString());
            } catch (SQLiteException e) {
                this.zzu.zzaW().zzb().zzb("Error incrementing retry count. error", e);
            }
        }
    }

    final Object zzL(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            this.zzu.zzaW().zzb().zza("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type != 4) {
            this.zzu.zzaW().zzb().zzb("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        this.zzu.zzaW().zzb().zza("Loaded invalid blob type value, ignoring it");
        return null;
    }

    public final long zzM() {
        return zzaB("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(3:2|3|4)|(2:6|(3:8|9|10)(1:14))|15|16|(1:18)(2:21|22)|19|9|10|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a7, code lost:
    
        r13 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a8, code lost:
    
        r2 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ad, code lost:
    
        r11.zzu.zzaW().zzb().zzd("Error inserting column. appId", com.google.android.gms.measurement.internal.zzgu.zzl(r12), "first_open_count", r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c0, code lost:
    
        r5 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zzN(java.lang.String r12, java.lang.String r13) {
        /*
            r11 = this;
            java.lang.String r13 = "select first_open_count from app2 where app_id=?"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            java.lang.String r0 = "first_open_count"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)
            r11.zzg()
            r11.zzay()
            android.database.sqlite.SQLiteDatabase r1 = r11.zze()
            r1.beginTransaction()
            r2 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Laa android.database.sqlite.SQLiteException -> Lac
            r5 = 48
            r4.<init>(r5)     // Catch: java.lang.Throwable -> Laa android.database.sqlite.SQLiteException -> Lac
            r4.append(r13)     // Catch: java.lang.Throwable -> Laa android.database.sqlite.SQLiteException -> Lac
            java.lang.String r13 = r4.toString()     // Catch: java.lang.Throwable -> Laa android.database.sqlite.SQLiteException -> Lac
            java.lang.String[] r4 = new java.lang.String[]{r12}     // Catch: java.lang.Throwable -> Laa android.database.sqlite.SQLiteException -> Lac
            r5 = -1
            long r7 = r11.zzaB(r13, r4, r5)     // Catch: java.lang.Throwable -> Laa android.database.sqlite.SQLiteException -> Lac
            int r13 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            java.lang.String r4 = "app2"
            java.lang.String r9 = "app_id"
            if (r13 != 0) goto L6d
            android.content.ContentValues r13 = new android.content.ContentValues     // Catch: java.lang.Throwable -> Laa android.database.sqlite.SQLiteException -> Lac
            r13.<init>()     // Catch: java.lang.Throwable -> Laa android.database.sqlite.SQLiteException -> Lac
            r13.put(r9, r12)     // Catch: java.lang.Throwable -> Laa android.database.sqlite.SQLiteException -> Lac
            r7 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> Laa android.database.sqlite.SQLiteException -> Lac
            r13.put(r0, r7)     // Catch: java.lang.Throwable -> Laa android.database.sqlite.SQLiteException -> Lac
            java.lang.String r8 = "previous_install_count"
            r13.put(r8, r7)     // Catch: java.lang.Throwable -> Laa android.database.sqlite.SQLiteException -> Lac
            r7 = 0
            r8 = 5
            long r7 = r1.insertWithOnConflict(r4, r7, r13, r8)     // Catch: java.lang.Throwable -> Laa android.database.sqlite.SQLiteException -> Lac
            int r13 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r13 != 0) goto L6c
            com.google.android.gms.measurement.internal.zzic r13 = r11.zzu     // Catch: java.lang.Throwable -> Laa android.database.sqlite.SQLiteException -> Lac
            com.google.android.gms.measurement.internal.zzgu r13 = r13.zzaW()     // Catch: java.lang.Throwable -> Laa android.database.sqlite.SQLiteException -> Lac
            com.google.android.gms.measurement.internal.zzgs r13 = r13.zzb()     // Catch: java.lang.Throwable -> Laa android.database.sqlite.SQLiteException -> Lac
            java.lang.String r4 = "Failed to insert column (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzgu.zzl(r12)     // Catch: java.lang.Throwable -> Laa android.database.sqlite.SQLiteException -> Lac
            r13.zzc(r4, r7, r0)     // Catch: java.lang.Throwable -> Laa android.database.sqlite.SQLiteException -> Lac
            goto Lc1
        L6c:
            r7 = r2
        L6d:
            android.content.ContentValues r13 = new android.content.ContentValues     // Catch: android.database.sqlite.SQLiteException -> La7 java.lang.Throwable -> Laa
            r13.<init>()     // Catch: android.database.sqlite.SQLiteException -> La7 java.lang.Throwable -> Laa
            r13.put(r9, r12)     // Catch: android.database.sqlite.SQLiteException -> La7 java.lang.Throwable -> Laa
            r9 = 1
            long r9 = r9 + r7
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch: android.database.sqlite.SQLiteException -> La7 java.lang.Throwable -> Laa
            r13.put(r0, r9)     // Catch: android.database.sqlite.SQLiteException -> La7 java.lang.Throwable -> Laa
            java.lang.String r9 = "app_id = ?"
            java.lang.String[] r10 = new java.lang.String[]{r12}     // Catch: android.database.sqlite.SQLiteException -> La7 java.lang.Throwable -> Laa
            int r13 = r1.update(r4, r13, r9, r10)     // Catch: android.database.sqlite.SQLiteException -> La7 java.lang.Throwable -> Laa
            long r9 = (long) r13     // Catch: android.database.sqlite.SQLiteException -> La7 java.lang.Throwable -> Laa
            int r13 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r13 != 0) goto La2
            com.google.android.gms.measurement.internal.zzic r13 = r11.zzu     // Catch: android.database.sqlite.SQLiteException -> La7 java.lang.Throwable -> Laa
            com.google.android.gms.measurement.internal.zzgu r13 = r13.zzaW()     // Catch: android.database.sqlite.SQLiteException -> La7 java.lang.Throwable -> Laa
            com.google.android.gms.measurement.internal.zzgs r13 = r13.zzb()     // Catch: android.database.sqlite.SQLiteException -> La7 java.lang.Throwable -> Laa
            java.lang.String r2 = "Failed to update column (got 0). appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgu.zzl(r12)     // Catch: android.database.sqlite.SQLiteException -> La7 java.lang.Throwable -> Laa
            r13.zzc(r2, r3, r0)     // Catch: android.database.sqlite.SQLiteException -> La7 java.lang.Throwable -> Laa
            goto Lc1
        La2:
            r1.setTransactionSuccessful()     // Catch: android.database.sqlite.SQLiteException -> La7 java.lang.Throwable -> Laa
            r5 = r7
            goto Lc1
        La7:
            r13 = move-exception
            r2 = r7
            goto Lad
        Laa:
            r11 = move-exception
            goto Lc5
        Lac:
            r13 = move-exception
        Lad:
            com.google.android.gms.measurement.internal.zzic r11 = r11.zzu     // Catch: java.lang.Throwable -> Laa
            com.google.android.gms.measurement.internal.zzgu r11 = r11.zzaW()     // Catch: java.lang.Throwable -> Laa
            com.google.android.gms.measurement.internal.zzgs r11 = r11.zzb()     // Catch: java.lang.Throwable -> Laa
            java.lang.String r4 = "Error inserting column. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzgu.zzl(r12)     // Catch: java.lang.Throwable -> Laa
            r11.zzd(r4, r12, r0, r13)     // Catch: java.lang.Throwable -> Laa
            r5 = r2
        Lc1:
            r1.endTransaction()
            return r5
        Lc5:
            r1.endTransaction()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaw.zzN(java.lang.String, java.lang.String):long");
    }

    public final long zzO() {
        return zzaB("select max(timestamp) from raw_events", null, 0L);
    }

    public final boolean zzP() {
        return zzaA("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean zzQ(String str, String str2) {
        return zzaA("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0;
    }

    public final boolean zzR() {
        return zzaA("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final void zzS(List list) {
        Preconditions.checkNotNull(list);
        zzg();
        zzay();
        StringBuilder sb = new StringBuilder("rowid in (");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(((Long) list.get(i)).longValue());
        }
        sb.append(")");
        int delete = zze().delete("raw_events", sb.toString(), null);
        if (delete != list.size()) {
            this.zzu.zzaW().zzb().zzc("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    public final long zzT(String str) {
        Preconditions.checkNotEmpty(str);
        return zzaB("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final boolean zzU(String str, Long l, long j, com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        zzg();
        zzay();
        Preconditions.checkNotNull(zzhsVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        zzic zzicVar = this.zzu;
        byte[] zzcd = zzhsVar.zzcd();
        zzicVar.zzaW().zzk().zzc("Saving complex main event, appId, data size", zzicVar.zzl().zza(str), Integer.valueOf(zzcd.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzcd);
        try {
            if (zze().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzicVar.zzaW().zzb().zzb("Failed to insert complex main event (got -1). appId", zzgu.zzl(str));
            return false;
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzc("Error storing complex main event. appId", zzgu.zzl(str), e);
            return false;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0084: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:26:0x0084 */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle zzV(java.lang.String r6) {
        /*
            r5 = this;
            r5.zzg()
            r5.zzay()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.zze()     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6c
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            java.lang.String[] r3 = new java.lang.String[]{r6}     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6c
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L6a android.database.sqlite.SQLiteException -> L6c
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> L83
            if (r2 != 0) goto L2b
            com.google.android.gms.measurement.internal.zzic r6 = r5.zzu     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzgu r6 = r6.zzaW()     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzgs r6 = r6.zzk()     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> L83
            java.lang.String r2 = "Default event parameters not found"
            r6.zza(r2)     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> L83
            goto L7d
        L2b:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> L83
            com.google.android.gms.internal.measurement.zzhr r3 = com.google.android.gms.internal.measurement.zzhs.zzp()     // Catch: java.io.IOException -> L53 android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> L83
            com.google.android.gms.internal.measurement.zzafb r2 = com.google.android.gms.measurement.internal.zzpk.zzw(r3, r2)     // Catch: java.io.IOException -> L53 android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> L83
            com.google.android.gms.internal.measurement.zzhr r2 = (com.google.android.gms.internal.measurement.zzhr) r2     // Catch: java.io.IOException -> L53 android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> L83
            com.google.android.gms.internal.measurement.zzadu r2 = r2.zzbd()     // Catch: java.io.IOException -> L53 android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> L83
            com.google.android.gms.internal.measurement.zzhs r2 = (com.google.android.gms.internal.measurement.zzhs) r2     // Catch: java.io.IOException -> L53 android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzpg r6 = r5.zzg     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> L83
            r6.zzp()     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> L83
            java.util.List r6 = r2.zza()     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> L83
            android.os.Bundle r5 = com.google.android.gms.measurement.internal.zzpk.zzH(r6)     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> L83
            if (r1 == 0) goto L52
            r1.close()
        L52:
            return r5
        L53:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzic r3 = r5.zzu     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzgu r3 = r3.zzaW()     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzgs r3 = r3.zzb()     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> L83
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzgu.zzl(r6)     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> L83
            r3.zzc(r4, r6, r2)     // Catch: android.database.sqlite.SQLiteException -> L68 java.lang.Throwable -> L83
            goto L7d
        L68:
            r6 = move-exception
            goto L6e
        L6a:
            r5 = move-exception
            goto L85
        L6c:
            r6 = move-exception
            r1 = r0
        L6e:
            com.google.android.gms.measurement.internal.zzic r5 = r5.zzu     // Catch: java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzgu r5 = r5.zzaW()     // Catch: java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzgs r5 = r5.zzb()     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = "Error selecting default event parameters"
            r5.zzb(r2, r6)     // Catch: java.lang.Throwable -> L83
        L7d:
            if (r1 == 0) goto L82
            r1.close()
        L82:
            return r0
        L83:
            r5 = move-exception
            r0 = r1
        L85:
            if (r0 == 0) goto L8a
            r0.close()
        L8a:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaw.zzV(java.lang.String):android.os.Bundle");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzW(String str, long j) {
        try {
            if (zzaB("select count(*) from raw_events where app_id=? and timestamp >= ? and name not like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j)}, 0L) > 0) {
                return false;
            }
            return zzaB("select count(*) from raw_events where app_id=? and timestamp >= ? and name like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j)}, 0L) > 0;
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzb("Error checking backfill conditions", e);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x00d3, code lost:
    
        if (r3 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007e, code lost:
    
        if (r3 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0080, code lost:
    
        r3.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02c3 A[Catch: SQLiteException -> 0x02d9, TRY_LEAVE, TryCatch #0 {SQLiteException -> 0x02d9, blocks: (B:77:0x02a8, B:79:0x02c3), top: B:76:0x02a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0124 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzX(java.lang.String r26, java.lang.Long r27, java.lang.String r28, android.os.Bundle r29) {
        /*
            Method dump skipped, instructions count: 768
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaw.zzX(java.lang.String, java.lang.Long, java.lang.String, android.os.Bundle):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
    
        if (r4 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
    
        if (r4 == null) goto L21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzjl zzY(java.lang.String r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            r3.zzg()
            r3.zzay()
            java.lang.String[] r4 = new java.lang.String[]{r4}
            java.lang.String r0 = "select consent_state, consent_source from consent_settings where app_id=? limit 1;"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r3.zze()     // Catch: java.lang.Throwable -> L43 android.database.sqlite.SQLiteException -> L45
            android.database.Cursor r4 = r2.rawQuery(r0, r4)     // Catch: java.lang.Throwable -> L43 android.database.sqlite.SQLiteException -> L45
            boolean r0 = r4.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L41 java.lang.Throwable -> L65
            if (r0 != 0) goto L30
            com.google.android.gms.measurement.internal.zzic r0 = r3.zzu     // Catch: android.database.sqlite.SQLiteException -> L41 java.lang.Throwable -> L65
            com.google.android.gms.measurement.internal.zzgu r0 = r0.zzaW()     // Catch: android.database.sqlite.SQLiteException -> L41 java.lang.Throwable -> L65
            com.google.android.gms.measurement.internal.zzgs r0 = r0.zzk()     // Catch: android.database.sqlite.SQLiteException -> L41 java.lang.Throwable -> L65
            java.lang.String r2 = "No data found"
            r0.zza(r2)     // Catch: android.database.sqlite.SQLiteException -> L41 java.lang.Throwable -> L65
            if (r4 == 0) goto L5c
            goto L59
        L30:
            r0 = 0
            java.lang.String r0 = r4.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L41 java.lang.Throwable -> L65
            r2 = 1
            int r2 = r4.getInt(r2)     // Catch: android.database.sqlite.SQLiteException -> L41 java.lang.Throwable -> L65
            com.google.android.gms.measurement.internal.zzjl r1 = com.google.android.gms.measurement.internal.zzjl.zzf(r0, r2)     // Catch: android.database.sqlite.SQLiteException -> L41 java.lang.Throwable -> L65
            if (r4 == 0) goto L5c
            goto L59
        L41:
            r0 = move-exception
            goto L48
        L43:
            r3 = move-exception
            goto L67
        L45:
            r4 = move-exception
            r0 = r4
            r4 = r1
        L48:
            com.google.android.gms.measurement.internal.zzic r3 = r3.zzu     // Catch: java.lang.Throwable -> L65
            com.google.android.gms.measurement.internal.zzgu r3 = r3.zzaW()     // Catch: java.lang.Throwable -> L65
            com.google.android.gms.measurement.internal.zzgs r3 = r3.zzb()     // Catch: java.lang.Throwable -> L65
            java.lang.String r2 = "Error querying database."
            r3.zzb(r2, r0)     // Catch: java.lang.Throwable -> L65
            if (r4 == 0) goto L5c
        L59:
            r4.close()
        L5c:
            r3 = r1
            com.google.android.gms.measurement.internal.zzjl r3 = (com.google.android.gms.measurement.internal.zzjl) r3
            if (r1 != 0) goto L64
            com.google.android.gms.measurement.internal.zzjl r3 = com.google.android.gms.measurement.internal.zzjl.zza
            return r3
        L64:
            return r1
        L65:
            r3 = move-exception
            r1 = r4
        L67:
            if (r1 == 0) goto L6c
            r1.close()
        L6c:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaw.zzY(java.lang.String):com.google.android.gms.measurement.internal.zzjl");
    }

    public final boolean zzZ(String str, zzoh zzohVar) {
        zzg();
        zzay();
        Preconditions.checkNotNull(zzohVar);
        Preconditions.checkNotEmpty(str);
        zzic zzicVar = this.zzu;
        long currentTimeMillis = zzicVar.zzba().currentTimeMillis();
        zzfx zzfxVar = zzfy.zzau;
        long longValue = currentTimeMillis - ((Long) zzfxVar.zzb(null)).longValue();
        long j = zzohVar.zzb;
        if (j < longValue || j > ((Long) zzfxVar.zzb(null)).longValue() + currentTimeMillis) {
            zzicVar.zzaW().zze().zzd("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzgu.zzl(str), Long.valueOf(currentTimeMillis), Long.valueOf(j));
        }
        zzicVar.zzaW().zzk().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzohVar.zza);
        contentValues.put(FirebaseAnalytics.Param.SOURCE, Integer.valueOf(zzohVar.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(j));
        try {
            if (zze().insert("trigger_uris", null, contentValues) != -1) {
                return true;
            }
            zzicVar.zzaW().zzb().zzb("Failed to insert trigger URI (got -1). appId", zzgu.zzl(str));
            return false;
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzc("Error storing trigger URI. appId", zzgu.zzl(str), e);
            return false;
        }
    }

    public final void zzaa(String str, zzjl zzjlVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjlVar);
        zzg();
        zzay();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzjlVar.zzl());
        contentValues.put("consent_source", Integer.valueOf(zzjlVar.zzb()));
        zzaD("consent_settings", "app_id", contentValues);
    }

    public final zzba zzab(String str) {
        Preconditions.checkNotNull(str);
        zzg();
        zzay();
        return zzba.zzg(zzaC("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final List zzac(String str) {
        zzg();
        zzay();
        List arrayList = new ArrayList();
        try {
            SQLiteDatabase zze2 = zze();
            zze2.beginTransaction();
            Cursor cursor = null;
            try {
                try {
                    cursor = zze2.query("diagnostic_signals", new String[]{"signal_name", "metadata", "count"}, "app_id=?", new String[]{str}, null, null, "rowid", null);
                    if (!cursor.moveToFirst()) {
                        zze2.setTransactionSuccessful();
                    } else {
                        boolean isEmpty = str.isEmpty();
                        do {
                            String string = cursor.getString(0);
                            String str2 = cursor.isNull(1) ? "" : (String) Preconditions.checkNotNull(cursor.getString(1));
                            if (string == null) {
                                this.zzu.zzaW().zzb().zzb("Read null value from diagnostic signals table, ignoring it. appId", zzgu.zzl(str));
                            } else {
                                long j = cursor.getLong(2);
                                com.google.android.gms.internal.measurement.zzfa zza2 = com.google.android.gms.internal.measurement.zzfb.zza();
                                zza2.zza(string);
                                zza2.zzd(j);
                                zza2.zzc(str2);
                                if (isEmpty) {
                                    zza2.zzb(true);
                                }
                                arrayList.add((com.google.android.gms.internal.measurement.zzfb) zza2.zzbd());
                            }
                        } while (cursor.moveToNext());
                        zze2.delete("diagnostic_signals", "app_id=?", new String[]{str});
                        zze2.setTransactionSuccessful();
                    }
                } catch (SQLiteException e) {
                    this.zzu.zzaW().zzb().zzc("Error querying or deleting diagnostic signals. appId", zzgu.zzl(str), e);
                    arrayList = Collections.EMPTY_LIST;
                }
                if (cursor != null) {
                    cursor.close();
                }
                zze2.endTransaction();
                return arrayList;
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                zze2.endTransaction();
                throw th;
            }
        } catch (SQLiteException e2) {
            this.zzu.zzaW().zzb().zzc("Error opening database for diagnostic signals. appId", zzgu.zzl(str), e2);
            return Collections.EMPTY_LIST;
        }
    }

    public final void zzad(String str, zzba zzbaVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzbaVar);
        zzg();
        zzay();
        zzjl zzY = zzY(str);
        zzjl zzjlVar = zzjl.zza;
        if (zzY == zzjlVar) {
            zzaa(str, zzjlVar);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", zzbaVar.zze());
        zzaD("consent_settings", "app_id", contentValues);
    }

    public final void zzae(String str, zzjl zzjlVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjlVar);
        zzg();
        zzay();
        zzaa(str, zzY(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", zzjlVar.zzl());
        zzaD("consent_settings", "app_id", contentValues);
    }

    public final zzjl zzaf(String str) {
        Preconditions.checkNotNull(str);
        zzg();
        zzay();
        return zzjl.zzf(zzaC("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""), 100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x027f, code lost:
    
        r22.zzu.zzaW().zzb().zzc("Error storing event filter. appId", com.google.android.gms.measurement.internal.zzgu.zzl(r23), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0375, code lost:
    
        zzay();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r23);
        r0 = zze();
        r0.delete("property_filters", "app_id=? and audience_id=?", new java.lang.String[]{r23, java.lang.String.valueOf(r10)});
        r0.delete("event_filters", "app_id=? and audience_id=?", new java.lang.String[]{r23, java.lang.String.valueOf(r10)});
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0398, code lost:
    
        r7 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x024e, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0232, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x048b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0490, code lost:
    
        r20.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0493, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01dc, code lost:
    
        r0 = r22.zzu.zzaW().zze();
        r11 = com.google.android.gms.measurement.internal.zzgu.zzl(r23);
        r13 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01f4, code lost:
    
        if (r12.zza() == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01f6, code lost:
    
        r16 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0203, code lost:
    
        r0.zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r11, r13, java.lang.String.valueOf(r16));
        r20 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0201, code lost:
    
        r16 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0294, code lost:
    
        r20 = r7;
        r3 = r19.zzc().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02a2, code lost:
    
        if (r3.hasNext() == false) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x02a4, code lost:
    
        r7 = (com.google.android.gms.internal.measurement.zzfn) r3.next();
        zzay();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r23);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x02be, code lost:
    
        if (r7.zzc().isEmpty() == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02f0, code lost:
    
        r11 = r7.zzcd();
        r12 = new android.content.ContentValues();
        r12.put(r0, r23);
        r19 = r0;
        r12.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0309, code lost:
    
        if (r7.zza() == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x030b, code lost:
    
        r0 = java.lang.Integer.valueOf(r7.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0315, code lost:
    
        r12.put("filter_id", r0);
        r21 = r3;
        r12.put("property_name", r7.zzc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0327, code lost:
    
        if (r7.zzh() == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0329, code lost:
    
        r0 = java.lang.Boolean.valueOf(r7.zzi());
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0333, code lost:
    
        r12.put("session_scoped", r0);
        r12.put("data", r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0345, code lost:
    
        if (zze().insertWithOnConflict("property_filters", null, r12, 5) != (-1)) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x035b, code lost:
    
        r0 = r19;
        r3 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0347, code lost:
    
        r22.zzu.zzaW().zzb().zzb("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.zzgu.zzl(r23));
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0361, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0362, code lost:
    
        r22.zzu.zzaW().zzb().zzc("Error storing property filter. appId", com.google.android.gms.measurement.internal.zzgu.zzl(r23), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0332, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0314, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x02c0, code lost:
    
        r0 = r22.zzu.zzaW().zze();
        r9 = com.google.android.gms.measurement.internal.zzgu.zzl(r23);
        r11 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x02d8, code lost:
    
        if (r7.zza() == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02da, code lost:
    
        r16 = java.lang.Integer.valueOf(r7.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x02e7, code lost:
    
        r0.zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r9, r11, java.lang.String.valueOf(r16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02e5, code lost:
    
        r16 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0171, code lost:
    
        r11 = r0.zzc().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x017d, code lost:
    
        if (r11.hasNext() == false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0189, code lost:
    
        if (((com.google.android.gms.internal.measurement.zzfn) r11.next()).zza() != false) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x018b, code lost:
    
        r22.zzu.zzaW().zze().zzc("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.zzgu.zzl(r23), java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01a4, code lost:
    
        r11 = r0.zzf().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01b0, code lost:
    
        r19 = r0;
        r0 = "app_id";
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01be, code lost:
    
        if (r11.hasNext() == false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01c0, code lost:
    
        r12 = (com.google.android.gms.internal.measurement.zzff) r11.next();
        zzay();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r23);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01da, code lost:
    
        if (r12.zzc().isEmpty() == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x020e, code lost:
    
        r3 = r12.zzcd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0212, code lost:
    
        r20 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0214, code lost:
    
        r7 = new android.content.ContentValues();
        r7.put("app_id", r23);
        r7.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0227, code lost:
    
        if (r12.zza() == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0229, code lost:
    
        r0 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0233, code lost:
    
        r7.put("filter_id", r0);
        r7.put("event_name", r12.zzc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0243, code lost:
    
        if (r12.zzl() == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0245, code lost:
    
        r0 = java.lang.Boolean.valueOf(r12.zzm());
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x024f, code lost:
    
        r7.put("session_scoped", r0);
        r7.put("data", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0261, code lost:
    
        if (zze().insertWithOnConflict("event_filters", null, r7, 5) != (-1)) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0263, code lost:
    
        r22.zzu.zzaW().zzb().zzb("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.zzgu.zzl(r23));
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0276, code lost:
    
        r0 = r19;
        r7 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x027e, code lost:
    
        r0 = move-exception;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzag(java.lang.String r23, java.util.List r24) {
        /*
            Method dump skipped, instructions count: 1172
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaw.zzag(java.lang.String, java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbd zzah(String str, com.google.android.gms.internal.measurement.zzhs zzhsVar, String str2) {
        zzbd zzaE = zzaE("events", str, zzhsVar.zzd());
        if (zzaE == null) {
            zzic zzicVar = this.zzu;
            zzicVar.zzaW().zze().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzgu.zzl(str), zzicVar.zzl().zza(str2));
            return new zzbd(str, zzhsVar.zzd(), 1L, 1L, 1L, zzhsVar.zzf(), 0L, null, null, null, null);
        }
        long j = zzaE.zze + 1;
        long j2 = zzaE.zzd + 1;
        return new zzbd(zzaE.zza, zzaE.zzb, zzaE.zzc + 1, j2, j, zzaE.zzf, zzaE.zzg, zzaE.zzh, zzaE.zzi, zzaE.zzj, zzaE.zzk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzai() {
        zzic zzicVar = this.zzu;
        Context zzaZ = zzicVar.zzaZ();
        zzicVar.zzc();
        return zzaZ.getDatabasePath("google_app_measurement.db").exists();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ long zzaj(String str, String[] strArr, long j) {
        return zzaB("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", strArr, -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzog zzau() {
        return this.zzn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0224 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01c4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01e0 A[Catch: SQLiteException -> 0x0073, all -> 0x0076, TryCatch #3 {SQLiteException -> 0x0073, blocks: (B:24:0x006b, B:25:0x00c3, B:27:0x00e9, B:28:0x00fe, B:30:0x0102, B:31:0x0112, B:33:0x0118, B:34:0x012b, B:43:0x015c, B:44:0x0164, B:46:0x016f, B:48:0x018e, B:50:0x019c, B:51:0x01a6, B:53:0x01d9, B:62:0x01c6, B:63:0x01e0, B:66:0x0149, B:70:0x01f5), top: B:23:0x006b }] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzav(java.lang.String r20, long r21, long r23, com.google.android.gms.measurement.internal.zzpc r25) {
        /*
            Method dump skipped, instructions count: 558
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaw.zzav(java.lang.String, long, long, com.google.android.gms.measurement.internal.zzpc):void");
    }

    public final void zzb() {
        zzay();
        zze().beginTransaction();
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    protected final boolean zzbc() {
        zzic zzicVar = this.zzu;
        if (!zzicVar.zzc().zzp(null, zzfy.zzbe)) {
            return false;
        }
        zzicVar.zzaX().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzas
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzaw zzawVar = zzaw.this;
                try {
                    SQLiteDatabase zze2 = zzawVar.zze();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("elapsed_time", (Long) 0L);
                    zze2.update("raw_events", contentValues, null, null);
                } catch (SQLiteException e) {
                    zzawVar.zzu.zzaW().zzb().zzb("Failed to remove elapsed times from raw events table", e);
                }
            }
        });
        return false;
    }

    public final void zzc() {
        zzay();
        zze().setTransactionSuccessful();
    }

    public final void zzd() {
        zzay();
        zze().endTransaction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SQLiteDatabase zze() {
        zzg();
        try {
            return this.zzm.getWritableDatabase();
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzb("Error opening database", e);
            throw e;
        }
    }

    public final zzbd zzf(String str, String str2) {
        return zzaE("events", str, str2);
    }

    public final void zzh(zzbd zzbdVar) {
        zzaF("events", zzbdVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0044, code lost:
    
        if (r2.moveToNext() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x002d, code lost:
    
        if (r2.moveToFirst() != false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002f, code lost:
    
        r1 = r2.getString(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0033, code lost:
    
        if (r1 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0035, code lost:
    
        r1 = zzaE("events", r13, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003b, code lost:
    
        if (r1 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003d, code lost:
    
        zzaF("events_snapshot", r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzi(java.lang.String r13) {
        /*
            r12 = this;
            java.lang.String r0 = "events_snapshot"
            r12.zzaG(r0, r13)
            java.lang.String r1 = "name"
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r12.zze()     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteException -> L4a
            java.lang.String r4 = "events"
            r11 = 0
            java.lang.String[] r5 = new java.lang.String[r11]     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteException -> L4a
            java.lang.Object[] r1 = r1.toArray(r5)     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteException -> L4a
            r5 = r1
            java.lang.String[] r5 = (java.lang.String[]) r5     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteException -> L4a
            java.lang.String r6 = "app_id=?"
            java.lang.String[] r7 = new java.lang.String[]{r13}     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteException -> L4a
            r9 = 0
            r10 = 0
            r8 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteException -> L4a
            boolean r1 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteException -> L4a
            if (r1 == 0) goto L5e
        L2f:
            java.lang.String r1 = r2.getString(r11)     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteException -> L4a
            if (r1 == 0) goto L40
            java.lang.String r3 = "events"
            com.google.android.gms.measurement.internal.zzbd r1 = r12.zzaE(r3, r13, r1)     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteException -> L4a
            if (r1 == 0) goto L40
            r12.zzaF(r0, r1)     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteException -> L4a
        L40:
            boolean r1 = r2.moveToNext()     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteException -> L4a
            if (r1 != 0) goto L2f
            goto L5e
        L47:
            r0 = move-exception
            r12 = r0
            goto L64
        L4a:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzic r12 = r12.zzu     // Catch: java.lang.Throwable -> L47
            com.google.android.gms.measurement.internal.zzgu r12 = r12.zzaW()     // Catch: java.lang.Throwable -> L47
            com.google.android.gms.measurement.internal.zzgs r12 = r12.zzb()     // Catch: java.lang.Throwable -> L47
            java.lang.String r1 = "Error creating snapshot. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzgu.zzl(r13)     // Catch: java.lang.Throwable -> L47
            r12.zzc(r1, r13, r0)     // Catch: java.lang.Throwable -> L47
        L5e:
            if (r2 == 0) goto L63
            r2.close()
        L63:
            return
        L64:
            if (r2 == 0) goto L69
            r2.close()
        L69:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaw.zzi(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x00c0, code lost:
    
        zzaF("events", r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00be, code lost:
    
        if (r8 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0058, code lost:
    
        if (r8 != null) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzj(java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaw.zzj(java.lang.String):void");
    }

    public final void zzk(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzay();
        try {
            zze().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzic zzicVar = this.zzu;
            zzicVar.zzaW().zzb().zzd("Error deleting user property. appId", zzgu.zzl(str), zzicVar.zzl().zzc(str2), e);
        }
    }

    public final boolean zzl(zzpn zzpnVar) {
        Preconditions.checkNotNull(zzpnVar);
        zzg();
        zzay();
        String str = zzpnVar.zza;
        String str2 = zzpnVar.zzc;
        if (zzm(str, str2) == null) {
            if (zzpp.zzh(str2)) {
                if (zzaA("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str}) >= this.zzu.zzc().zzn(str, zzfy.zzV, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(str2)) {
                long zzaA = zzaA("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str, zzpnVar.zzb});
                this.zzu.zzc();
                if (zzaA >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzpnVar.zzb);
        contentValues.put("name", str2);
        contentValues.put("set_timestamp", Long.valueOf(zzpnVar.zzd));
        zzaw(contentValues, "value", zzpnVar.zze);
        try {
            if (zze().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            this.zzu.zzaW().zzb().zzb("Failed to insert/update user property (got -1). appId", zzgu.zzl(str));
            return true;
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzc("Error storing user property. appId", zzgu.zzl(zzpnVar.zza), e);
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzpn zzm(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r10.zzg()
            r10.zzay()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.zze()     // Catch: java.lang.Throwable -> L71 android.database.sqlite.SQLiteException -> L74
            java.lang.String r3 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r4 = "value"
            java.lang.String r5 = "origin"
            java.lang.String[] r4 = new java.lang.String[]{r0, r4, r5}     // Catch: java.lang.Throwable -> L71 android.database.sqlite.SQLiteException -> L74
            java.lang.String r5 = "app_id=? and name=?"
            java.lang.String[] r6 = new java.lang.String[]{r11, r12}     // Catch: java.lang.Throwable -> L71 android.database.sqlite.SQLiteException -> L74
            r8 = 0
            r9 = 0
            r7 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L71 android.database.sqlite.SQLiteException -> L74
            boolean r0 = r2.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L9a
            if (r0 != 0) goto L32
            goto L94
        L32:
            r0 = 0
            long r7 = r2.getLong(r0)     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L9a
            r0 = 1
            java.lang.Object r9 = r10.zzL(r2, r0)     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L9a
            if (r9 != 0) goto L3f
            goto L94
        L3f:
            r0 = 2
            java.lang.String r5 = r2.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L9a
            com.google.android.gms.measurement.internal.zzpn r3 = new com.google.android.gms.measurement.internal.zzpn     // Catch: android.database.sqlite.SQLiteException -> L6c java.lang.Throwable -> L9a
            r4 = r11
            r6 = r12
            r3.<init>(r4, r5, r6, r7, r9)     // Catch: android.database.sqlite.SQLiteException -> L6a java.lang.Throwable -> L9a
            boolean r11 = r2.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L6a java.lang.Throwable -> L9a
            if (r11 == 0) goto L64
            com.google.android.gms.measurement.internal.zzic r11 = r10.zzu     // Catch: android.database.sqlite.SQLiteException -> L6a java.lang.Throwable -> L9a
            com.google.android.gms.measurement.internal.zzgu r11 = r11.zzaW()     // Catch: android.database.sqlite.SQLiteException -> L6a java.lang.Throwable -> L9a
            com.google.android.gms.measurement.internal.zzgs r11 = r11.zzb()     // Catch: android.database.sqlite.SQLiteException -> L6a java.lang.Throwable -> L9a
            java.lang.String r12 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzgu.zzl(r4)     // Catch: android.database.sqlite.SQLiteException -> L6a java.lang.Throwable -> L9a
            r11.zzb(r12, r0)     // Catch: android.database.sqlite.SQLiteException -> L6a java.lang.Throwable -> L9a
        L64:
            if (r2 == 0) goto L69
            r2.close()
        L69:
            return r3
        L6a:
            r0 = move-exception
            goto L6f
        L6c:
            r0 = move-exception
            r4 = r11
            r6 = r12
        L6f:
            r11 = r0
            goto L79
        L71:
            r0 = move-exception
            r10 = r0
            goto L9d
        L74:
            r0 = move-exception
            r4 = r11
            r6 = r12
            r11 = r0
            r2 = r1
        L79:
            com.google.android.gms.measurement.internal.zzic r10 = r10.zzu     // Catch: java.lang.Throwable -> L9a
            com.google.android.gms.measurement.internal.zzgu r12 = r10.zzaW()     // Catch: java.lang.Throwable -> L9a
            com.google.android.gms.measurement.internal.zzgs r12 = r12.zzb()     // Catch: java.lang.Throwable -> L9a
            java.lang.String r0 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgu.zzl(r4)     // Catch: java.lang.Throwable -> L9a
            com.google.android.gms.measurement.internal.zzgn r10 = r10.zzl()     // Catch: java.lang.Throwable -> L9a
            java.lang.String r10 = r10.zzc(r6)     // Catch: java.lang.Throwable -> L9a
            r12.zzd(r0, r3, r10, r11)     // Catch: java.lang.Throwable -> L9a
        L94:
            if (r2 == 0) goto L99
            r2.close()
        L99:
            return r1
        L9a:
            r0 = move-exception
            r10 = r0
            r1 = r2
        L9d:
            if (r1 == 0) goto La2
            r1.close()
        La2:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaw.zzm(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzpn");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List zzn(java.lang.String r13) {
        /*
            r12 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            r12.zzg()
            r12.zzay()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r9 = "1000"
            r10 = 0
            android.database.sqlite.SQLiteDatabase r1 = r12.zze()     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L84
            java.lang.String r2 = "user_attributes"
            java.lang.String r3 = "name"
            java.lang.String r4 = "origin"
            java.lang.String r5 = "set_timestamp"
            java.lang.String r6 = "value"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5, r6}     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L84
            java.lang.String r4 = "app_id=?"
            java.lang.String[] r5 = new java.lang.String[]{r13}     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L84
            java.lang.String r8 = "rowid"
            com.google.android.gms.measurement.internal.zzic r11 = r12.zzu     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L84
            r11.zzc()     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L84
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L84
            boolean r1 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L81
            if (r1 == 0) goto L9c
        L3c:
            r1 = 0
            java.lang.String r5 = r10.getString(r1)     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L81
            r1 = 1
            java.lang.String r1 = r10.getString(r1)     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L81
            if (r1 != 0) goto L4a
            java.lang.String r1 = ""
        L4a:
            r4 = r1
            r1 = 2
            long r6 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L81
            r1 = 3
            java.lang.Object r8 = r12.zzL(r10, r1)     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L81
            if (r8 != 0) goto L6a
            com.google.android.gms.measurement.internal.zzgu r1 = r11.zzaW()     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L81
            com.google.android.gms.measurement.internal.zzgs r1 = r1.zzb()     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L81
            java.lang.String r2 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgu.zzl(r13)     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L81
            r1.zzb(r2, r3)     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L81
            r3 = r13
            goto L73
        L6a:
            com.google.android.gms.measurement.internal.zzpn r2 = new com.google.android.gms.measurement.internal.zzpn     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L81
            r3 = r13
            r2.<init>(r3, r4, r5, r6, r8)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L7e
            r0.add(r2)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L7e
        L73:
            boolean r13 = r10.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L7e
            if (r13 != 0) goto L7a
            goto L9c
        L7a:
            r13 = r3
            goto L3c
        L7c:
            r0 = move-exception
            goto L87
        L7e:
            r0 = move-exception
            r12 = r0
            goto La2
        L81:
            r0 = move-exception
            r3 = r13
            goto L87
        L84:
            r0 = move-exception
            r3 = r13
            r13 = r0
        L87:
            com.google.android.gms.measurement.internal.zzic r12 = r12.zzu     // Catch: java.lang.Throwable -> L7e
            com.google.android.gms.measurement.internal.zzgu r12 = r12.zzaW()     // Catch: java.lang.Throwable -> L7e
            com.google.android.gms.measurement.internal.zzgs r12 = r12.zzb()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r13 = "Error querying user properties. appId"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzgu.zzl(r3)     // Catch: java.lang.Throwable -> L7e
            r12.zzc(r13, r1, r0)     // Catch: java.lang.Throwable -> L7e
            java.util.List r0 = java.util.Collections.EMPTY_LIST     // Catch: java.lang.Throwable -> L7e
        L9c:
            if (r10 == 0) goto La1
            r10.close()
        La1:
            return r0
        La2:
            if (r10 == 0) goto La7
            r10.close()
        La7:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaw.zzn(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b0, code lost:
    
        r0 = r8.zzaW().zzb();
        r8.zzc();
        r0.zzb("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List zzo(java.lang.String r23, java.lang.String r24, java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaw.zzo(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final boolean zzp(zzah zzahVar) {
        Preconditions.checkNotNull(zzahVar);
        zzg();
        zzay();
        String str = zzahVar.zza;
        Preconditions.checkNotNull(str);
        if (zzm(str, zzahVar.zzc.zzb) == null) {
            long zzaA = zzaA("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.zzu.zzc();
            if (zzaA >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzahVar.zzb);
        contentValues.put("name", zzahVar.zzc.zzb);
        zzaw(contentValues, "value", Preconditions.checkNotNull(zzahVar.zzc.zza()));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzahVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzahVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzahVar.zzh));
        zzic zzicVar = this.zzu;
        contentValues.put("timed_out_event", zzicVar.zzk().zzah(zzahVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzahVar.zzd));
        contentValues.put("triggered_event", zzicVar.zzk().zzah(zzahVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzahVar.zzc.zzc));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzahVar.zzj));
        contentValues.put("expired_event", zzicVar.zzk().zzah(zzahVar.zzk));
        try {
            if (zze().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            zzicVar.zzaW().zzb().zzb("Failed to insert/update conditional user property (got -1)", zzgu.zzl(str));
            return true;
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzc("Error storing conditional user property", zzgu.zzl(str), e);
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzah zzq(java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaw.zzq(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzah");
    }

    public final int zzr(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzay();
        try {
            return zze().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzic zzicVar = this.zzu;
            zzicVar.zzaW().zzb().zzd("Error deleting conditional property", zzgu.zzl(str), zzicVar.zzl().zzc(str2), e);
            return 0;
        }
    }

    public final List zzs(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            String.valueOf(str3);
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zzt(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x008c, code lost:
    
        r20 = r11.getString(5);
        r22 = r11.getLong(6);
        r2 = r28.zzg;
        r21 = (com.google.android.gms.measurement.internal.zzbh) r2.zzp().zzl(r11.getBlob(7), com.google.android.gms.measurement.internal.zzbh.CREATOR);
        r0.add(new com.google.android.gms.measurement.internal.zzah(r14, r15, new com.google.android.gms.measurement.internal.zzpl(r5, r11.getLong(10), r8, r15), r11.getLong(8), r19, r20, r21, r22, (com.google.android.gms.measurement.internal.zzbh) r2.zzp().zzl(r11.getBlob(9), com.google.android.gms.measurement.internal.zzbh.CREATOR), r11.getLong(11), (com.google.android.gms.measurement.internal.zzbh) r2.zzp().zzl(r11.getBlob(12), com.google.android.gms.measurement.internal.zzbh.CREATOR)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x00fc, code lost:
    
        if (r11.moveToNext() != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x008a, code lost:
    
        r19 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0056, code lost:
    
        r2 = r12.zzaW().zzb();
        r12.zzc();
        r2.zzb("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0049, code lost:
    
        if (r11.moveToFirst() != false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x004b, code lost:
    
        r2 = r0.size();
        r12.zzc();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0054, code lost:
    
        if (r2 < 1000) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x006c, code lost:
    
        r14 = r11.getString(0);
        r15 = r11.getString(1);
        r5 = r11.getString(2);
        r8 = zzL(r11, 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0085, code lost:
    
        if (r11.getInt(4) == 0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0087, code lost:
    
        r19 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List zzt(java.lang.String r29, java.lang.String[] r30) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaw.zzt(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01b0 A[Catch: SQLiteException -> 0x02ff, all -> 0x031e, TryCatch #2 {SQLiteException -> 0x02ff, blocks: (B:5:0x0081, B:12:0x0089, B:14:0x00a1, B:15:0x00a8, B:17:0x00bc, B:18:0x00c4, B:20:0x0106, B:24:0x0110, B:27:0x015a, B:29:0x0189, B:33:0x0193, B:36:0x01a5, B:38:0x01b0, B:39:0x01c2, B:41:0x01cc, B:42:0x01d5, B:44:0x01dd, B:47:0x01e6, B:49:0x021e, B:50:0x0230, B:52:0x0238, B:55:0x0241, B:58:0x0259, B:61:0x0283, B:63:0x028e, B:64:0x0299, B:66:0x02a1, B:67:0x02ac, B:69:0x02bd, B:70:0x02c4, B:72:0x02d0, B:74:0x02d8, B:75:0x02df, B:77:0x02e8, B:82:0x0279, B:83:0x024e, B:86:0x0255, B:89:0x01a1, B:91:0x0155), top: B:4:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01cc A[Catch: SQLiteException -> 0x02ff, all -> 0x031e, TryCatch #2 {SQLiteException -> 0x02ff, blocks: (B:5:0x0081, B:12:0x0089, B:14:0x00a1, B:15:0x00a8, B:17:0x00bc, B:18:0x00c4, B:20:0x0106, B:24:0x0110, B:27:0x015a, B:29:0x0189, B:33:0x0193, B:36:0x01a5, B:38:0x01b0, B:39:0x01c2, B:41:0x01cc, B:42:0x01d5, B:44:0x01dd, B:47:0x01e6, B:49:0x021e, B:50:0x0230, B:52:0x0238, B:55:0x0241, B:58:0x0259, B:61:0x0283, B:63:0x028e, B:64:0x0299, B:66:0x02a1, B:67:0x02ac, B:69:0x02bd, B:70:0x02c4, B:72:0x02d0, B:74:0x02d8, B:75:0x02df, B:77:0x02e8, B:82:0x0279, B:83:0x024e, B:86:0x0255, B:89:0x01a1, B:91:0x0155), top: B:4:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01dd A[Catch: SQLiteException -> 0x02ff, all -> 0x031e, TryCatch #2 {SQLiteException -> 0x02ff, blocks: (B:5:0x0081, B:12:0x0089, B:14:0x00a1, B:15:0x00a8, B:17:0x00bc, B:18:0x00c4, B:20:0x0106, B:24:0x0110, B:27:0x015a, B:29:0x0189, B:33:0x0193, B:36:0x01a5, B:38:0x01b0, B:39:0x01c2, B:41:0x01cc, B:42:0x01d5, B:44:0x01dd, B:47:0x01e6, B:49:0x021e, B:50:0x0230, B:52:0x0238, B:55:0x0241, B:58:0x0259, B:61:0x0283, B:63:0x028e, B:64:0x0299, B:66:0x02a1, B:67:0x02ac, B:69:0x02bd, B:70:0x02c4, B:72:0x02d0, B:74:0x02d8, B:75:0x02df, B:77:0x02e8, B:82:0x0279, B:83:0x024e, B:86:0x0255, B:89:0x01a1, B:91:0x0155), top: B:4:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x021e A[Catch: SQLiteException -> 0x02ff, all -> 0x031e, TryCatch #2 {SQLiteException -> 0x02ff, blocks: (B:5:0x0081, B:12:0x0089, B:14:0x00a1, B:15:0x00a8, B:17:0x00bc, B:18:0x00c4, B:20:0x0106, B:24:0x0110, B:27:0x015a, B:29:0x0189, B:33:0x0193, B:36:0x01a5, B:38:0x01b0, B:39:0x01c2, B:41:0x01cc, B:42:0x01d5, B:44:0x01dd, B:47:0x01e6, B:49:0x021e, B:50:0x0230, B:52:0x0238, B:55:0x0241, B:58:0x0259, B:61:0x0283, B:63:0x028e, B:64:0x0299, B:66:0x02a1, B:67:0x02ac, B:69:0x02bd, B:70:0x02c4, B:72:0x02d0, B:74:0x02d8, B:75:0x02df, B:77:0x02e8, B:82:0x0279, B:83:0x024e, B:86:0x0255, B:89:0x01a1, B:91:0x0155), top: B:4:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0238 A[Catch: SQLiteException -> 0x02ff, all -> 0x031e, TryCatch #2 {SQLiteException -> 0x02ff, blocks: (B:5:0x0081, B:12:0x0089, B:14:0x00a1, B:15:0x00a8, B:17:0x00bc, B:18:0x00c4, B:20:0x0106, B:24:0x0110, B:27:0x015a, B:29:0x0189, B:33:0x0193, B:36:0x01a5, B:38:0x01b0, B:39:0x01c2, B:41:0x01cc, B:42:0x01d5, B:44:0x01dd, B:47:0x01e6, B:49:0x021e, B:50:0x0230, B:52:0x0238, B:55:0x0241, B:58:0x0259, B:61:0x0283, B:63:0x028e, B:64:0x0299, B:66:0x02a1, B:67:0x02ac, B:69:0x02bd, B:70:0x02c4, B:72:0x02d0, B:74:0x02d8, B:75:0x02df, B:77:0x02e8, B:82:0x0279, B:83:0x024e, B:86:0x0255, B:89:0x01a1, B:91:0x0155), top: B:4:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x028e A[Catch: SQLiteException -> 0x02ff, all -> 0x031e, TryCatch #2 {SQLiteException -> 0x02ff, blocks: (B:5:0x0081, B:12:0x0089, B:14:0x00a1, B:15:0x00a8, B:17:0x00bc, B:18:0x00c4, B:20:0x0106, B:24:0x0110, B:27:0x015a, B:29:0x0189, B:33:0x0193, B:36:0x01a5, B:38:0x01b0, B:39:0x01c2, B:41:0x01cc, B:42:0x01d5, B:44:0x01dd, B:47:0x01e6, B:49:0x021e, B:50:0x0230, B:52:0x0238, B:55:0x0241, B:58:0x0259, B:61:0x0283, B:63:0x028e, B:64:0x0299, B:66:0x02a1, B:67:0x02ac, B:69:0x02bd, B:70:0x02c4, B:72:0x02d0, B:74:0x02d8, B:75:0x02df, B:77:0x02e8, B:82:0x0279, B:83:0x024e, B:86:0x0255, B:89:0x01a1, B:91:0x0155), top: B:4:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02a1 A[Catch: SQLiteException -> 0x02ff, all -> 0x031e, TryCatch #2 {SQLiteException -> 0x02ff, blocks: (B:5:0x0081, B:12:0x0089, B:14:0x00a1, B:15:0x00a8, B:17:0x00bc, B:18:0x00c4, B:20:0x0106, B:24:0x0110, B:27:0x015a, B:29:0x0189, B:33:0x0193, B:36:0x01a5, B:38:0x01b0, B:39:0x01c2, B:41:0x01cc, B:42:0x01d5, B:44:0x01dd, B:47:0x01e6, B:49:0x021e, B:50:0x0230, B:52:0x0238, B:55:0x0241, B:58:0x0259, B:61:0x0283, B:63:0x028e, B:64:0x0299, B:66:0x02a1, B:67:0x02ac, B:69:0x02bd, B:70:0x02c4, B:72:0x02d0, B:74:0x02d8, B:75:0x02df, B:77:0x02e8, B:82:0x0279, B:83:0x024e, B:86:0x0255, B:89:0x01a1, B:91:0x0155), top: B:4:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02bd A[Catch: SQLiteException -> 0x02ff, all -> 0x031e, TryCatch #2 {SQLiteException -> 0x02ff, blocks: (B:5:0x0081, B:12:0x0089, B:14:0x00a1, B:15:0x00a8, B:17:0x00bc, B:18:0x00c4, B:20:0x0106, B:24:0x0110, B:27:0x015a, B:29:0x0189, B:33:0x0193, B:36:0x01a5, B:38:0x01b0, B:39:0x01c2, B:41:0x01cc, B:42:0x01d5, B:44:0x01dd, B:47:0x01e6, B:49:0x021e, B:50:0x0230, B:52:0x0238, B:55:0x0241, B:58:0x0259, B:61:0x0283, B:63:0x028e, B:64:0x0299, B:66:0x02a1, B:67:0x02ac, B:69:0x02bd, B:70:0x02c4, B:72:0x02d0, B:74:0x02d8, B:75:0x02df, B:77:0x02e8, B:82:0x0279, B:83:0x024e, B:86:0x0255, B:89:0x01a1, B:91:0x0155), top: B:4:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02d0 A[Catch: SQLiteException -> 0x02ff, all -> 0x031e, TryCatch #2 {SQLiteException -> 0x02ff, blocks: (B:5:0x0081, B:12:0x0089, B:14:0x00a1, B:15:0x00a8, B:17:0x00bc, B:18:0x00c4, B:20:0x0106, B:24:0x0110, B:27:0x015a, B:29:0x0189, B:33:0x0193, B:36:0x01a5, B:38:0x01b0, B:39:0x01c2, B:41:0x01cc, B:42:0x01d5, B:44:0x01dd, B:47:0x01e6, B:49:0x021e, B:50:0x0230, B:52:0x0238, B:55:0x0241, B:58:0x0259, B:61:0x0283, B:63:0x028e, B:64:0x0299, B:66:0x02a1, B:67:0x02ac, B:69:0x02bd, B:70:0x02c4, B:72:0x02d0, B:74:0x02d8, B:75:0x02df, B:77:0x02e8, B:82:0x0279, B:83:0x024e, B:86:0x0255, B:89:0x01a1, B:91:0x0155), top: B:4:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02e8 A[Catch: SQLiteException -> 0x02ff, all -> 0x031e, TRY_LEAVE, TryCatch #2 {SQLiteException -> 0x02ff, blocks: (B:5:0x0081, B:12:0x0089, B:14:0x00a1, B:15:0x00a8, B:17:0x00bc, B:18:0x00c4, B:20:0x0106, B:24:0x0110, B:27:0x015a, B:29:0x0189, B:33:0x0193, B:36:0x01a5, B:38:0x01b0, B:39:0x01c2, B:41:0x01cc, B:42:0x01d5, B:44:0x01dd, B:47:0x01e6, B:49:0x021e, B:50:0x0230, B:52:0x0238, B:55:0x0241, B:58:0x0259, B:61:0x0283, B:63:0x028e, B:64:0x0299, B:66:0x02a1, B:67:0x02ac, B:69:0x02bd, B:70:0x02c4, B:72:0x02d0, B:74:0x02d8, B:75:0x02df, B:77:0x02e8, B:82:0x0279, B:83:0x024e, B:86:0x0255, B:89:0x01a1, B:91:0x0155), top: B:4:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0279 A[Catch: SQLiteException -> 0x02ff, all -> 0x031e, TryCatch #2 {SQLiteException -> 0x02ff, blocks: (B:5:0x0081, B:12:0x0089, B:14:0x00a1, B:15:0x00a8, B:17:0x00bc, B:18:0x00c4, B:20:0x0106, B:24:0x0110, B:27:0x015a, B:29:0x0189, B:33:0x0193, B:36:0x01a5, B:38:0x01b0, B:39:0x01c2, B:41:0x01cc, B:42:0x01d5, B:44:0x01dd, B:47:0x01e6, B:49:0x021e, B:50:0x0230, B:52:0x0238, B:55:0x0241, B:58:0x0259, B:61:0x0283, B:63:0x028e, B:64:0x0299, B:66:0x02a1, B:67:0x02ac, B:69:0x02bd, B:70:0x02c4, B:72:0x02d0, B:74:0x02d8, B:75:0x02df, B:77:0x02e8, B:82:0x0279, B:83:0x024e, B:86:0x0255, B:89:0x01a1, B:91:0x0155), top: B:4:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x024e A[Catch: SQLiteException -> 0x02ff, all -> 0x031e, TryCatch #2 {SQLiteException -> 0x02ff, blocks: (B:5:0x0081, B:12:0x0089, B:14:0x00a1, B:15:0x00a8, B:17:0x00bc, B:18:0x00c4, B:20:0x0106, B:24:0x0110, B:27:0x015a, B:29:0x0189, B:33:0x0193, B:36:0x01a5, B:38:0x01b0, B:39:0x01c2, B:41:0x01cc, B:42:0x01d5, B:44:0x01dd, B:47:0x01e6, B:49:0x021e, B:50:0x0230, B:52:0x0238, B:55:0x0241, B:58:0x0259, B:61:0x0283, B:63:0x028e, B:64:0x0299, B:66:0x02a1, B:67:0x02ac, B:69:0x02bd, B:70:0x02c4, B:72:0x02d0, B:74:0x02d8, B:75:0x02df, B:77:0x02e8, B:82:0x0279, B:83:0x024e, B:86:0x0255, B:89:0x01a1, B:91:0x0155), top: B:4:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a1 A[Catch: SQLiteException -> 0x02ff, all -> 0x031e, TryCatch #2 {SQLiteException -> 0x02ff, blocks: (B:5:0x0081, B:12:0x0089, B:14:0x00a1, B:15:0x00a8, B:17:0x00bc, B:18:0x00c4, B:20:0x0106, B:24:0x0110, B:27:0x015a, B:29:0x0189, B:33:0x0193, B:36:0x01a5, B:38:0x01b0, B:39:0x01c2, B:41:0x01cc, B:42:0x01d5, B:44:0x01dd, B:47:0x01e6, B:49:0x021e, B:50:0x0230, B:52:0x0238, B:55:0x0241, B:58:0x0259, B:61:0x0283, B:63:0x028e, B:64:0x0299, B:66:0x02a1, B:67:0x02ac, B:69:0x02bd, B:70:0x02c4, B:72:0x02d0, B:74:0x02d8, B:75:0x02df, B:77:0x02e8, B:82:0x0279, B:83:0x024e, B:86:0x0255, B:89:0x01a1, B:91:0x0155), top: B:4:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0155 A[Catch: SQLiteException -> 0x02ff, all -> 0x031e, TryCatch #2 {SQLiteException -> 0x02ff, blocks: (B:5:0x0081, B:12:0x0089, B:14:0x00a1, B:15:0x00a8, B:17:0x00bc, B:18:0x00c4, B:20:0x0106, B:24:0x0110, B:27:0x015a, B:29:0x0189, B:33:0x0193, B:36:0x01a5, B:38:0x01b0, B:39:0x01c2, B:41:0x01cc, B:42:0x01d5, B:44:0x01dd, B:47:0x01e6, B:49:0x021e, B:50:0x0230, B:52:0x0238, B:55:0x0241, B:58:0x0259, B:61:0x0283, B:63:0x028e, B:64:0x0299, B:66:0x02a1, B:67:0x02ac, B:69:0x02bd, B:70:0x02c4, B:72:0x02d0, B:74:0x02d8, B:75:0x02df, B:77:0x02e8, B:82:0x0279, B:83:0x024e, B:86:0x0255, B:89:0x01a1, B:91:0x0155), top: B:4:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x031a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzh zzu(java.lang.String r53) {
        /*
            Method dump skipped, instructions count: 806
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaw.zzu(java.lang.String):com.google.android.gms.measurement.internal.zzh");
    }

    public final void zzv(zzh zzhVar, boolean z, boolean z2) {
        Preconditions.checkNotNull(zzhVar);
        zzg();
        zzay();
        String zzc2 = zzhVar.zzc();
        Preconditions.checkNotNull(zzc2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzc2);
        if (z) {
            contentValues.put("app_instance_id", (String) null);
        } else if (this.zzg.zzB(zzc2).zzo(zzjk.ANALYTICS_STORAGE)) {
            contentValues.put("app_instance_id", zzhVar.zzd());
        }
        contentValues.put("gmp_app_id", zzhVar.zzf());
        zzpg zzpgVar = this.zzg;
        if (zzpgVar.zzB(zzc2).zzo(zzjk.AD_STORAGE)) {
            contentValues.put("resettable_device_id_hash", zzhVar.zzj());
        }
        contentValues.put("last_bundle_index", Long.valueOf(zzhVar.zzG()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzhVar.zzn()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzhVar.zzp()));
        contentValues.put("app_version", zzhVar.zzr());
        contentValues.put("app_store", zzhVar.zzv());
        contentValues.put("gmp_version", Long.valueOf(zzhVar.zzx()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzhVar.zzz()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzhVar.zzD()));
        contentValues.put("day", Long.valueOf(zzhVar.zzN()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzhVar.zzP()));
        contentValues.put("daily_events_count", Long.valueOf(zzhVar.zzR()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzhVar.zzT()));
        contentValues.put("config_fetched_time", Long.valueOf(zzhVar.zzH()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzhVar.zzJ()));
        contentValues.put("app_version_int", Long.valueOf(zzhVar.zzt()));
        contentValues.put("firebase_instance_id", zzhVar.zzl());
        contentValues.put("daily_error_events_count", Long.valueOf(zzhVar.zzX()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzhVar.zzV()));
        contentValues.put("health_monitor_sample", zzhVar.zzZ());
        contentValues.put("android_id", (Long) 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzhVar.zzac()));
        contentValues.put("dynamite_version", Long.valueOf(zzhVar.zzB()));
        if (zzpgVar.zzB(zzc2).zzo(zzjk.ANALYTICS_STORAGE)) {
            contentValues.put("session_stitching_token", zzhVar.zzh());
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(zzhVar.zzai()));
        contentValues.put("target_os_version", Long.valueOf(zzhVar.zzak()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(zzhVar.zzam()));
        zzaif.zza();
        zzic zzicVar = this.zzu;
        if (zzicVar.zzc().zzp(zzc2, zzfy.zzaO)) {
            contentValues.put("ad_services_version", Integer.valueOf(zzhVar.zzao()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(zzhVar.zzaw()));
        }
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(zzhVar.zzaq()));
        contentValues.put("npa_metadata_value", zzhVar.zzae());
        contentValues.put("bundle_delivery_index", Long.valueOf(zzhVar.zzaF()));
        contentValues.put("sgtm_preview_key", zzhVar.zzay());
        contentValues.put("dma_consent_state", Integer.valueOf(zzhVar.zzaA()));
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(zzhVar.zzaC()));
        contentValues.put("serialized_npa_metadata", zzhVar.zzaH());
        contentValues.put("client_upload_eligibility", Integer.valueOf(zzhVar.zzaL()));
        List zzag = zzhVar.zzag();
        if (zzag != null) {
            if (zzag.isEmpty()) {
                zzicVar.zzaW().zze().zzb("Safelisted events should not be an empty list. appId", zzc2);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzag));
            }
        }
        zzahk.zza();
        if (zzicVar.zzc().zzp(null, zzfy.zzaK) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        contentValues.put("unmatched_pfo", zzhVar.zzas());
        contentValues.put("unmatched_uwa", zzhVar.zzau());
        contentValues.put("ad_campaign_info", zzhVar.zzaJ());
        if (zzicVar.zzc().zzp(zzc2, zzfy.zzbj)) {
            contentValues.put("last_diagnostics_signal_upload_timestamp", Long.valueOf(zzhVar.zzaN()));
        }
        try {
            SQLiteDatabase zze2 = zze();
            if (zze2.update("apps", contentValues, "app_id = ?", new String[]{zzc2}) == 0 && zze2.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzicVar.zzaW().zzb().zzb("Failed to insert/update app (got -1). appId", zzgu.zzl(zzc2));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzc("Error storing app. appId", zzgu.zzl(zzc2), e);
        }
    }

    public final zzar zzw(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        return zzx(j, str, 1L, false, false, z3, false, z5, z6, z7);
    }

    public final zzar zzx(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        String[] strArr = {str};
        zzar zzarVar = new zzar();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase zze2 = zze();
                cursor = zze2.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursor.moveToFirst()) {
                    this.zzu.zzaW().zze().zzb("Not updating daily counts, app is not known. appId", zzgu.zzl(str));
                } else {
                    if (cursor.getLong(0) == j) {
                        zzarVar.zzb = cursor.getLong(1);
                        zzarVar.zza = cursor.getLong(2);
                        zzarVar.zzc = cursor.getLong(3);
                        zzarVar.zzd = cursor.getLong(4);
                        zzarVar.zze = cursor.getLong(5);
                        zzarVar.zzf = cursor.getLong(6);
                        zzarVar.zzg = cursor.getLong(7);
                    }
                    if (z) {
                        zzarVar.zzb += j2;
                    }
                    if (z2) {
                        zzarVar.zza += j2;
                    }
                    if (z3) {
                        zzarVar.zzc += j2;
                    }
                    if (z4) {
                        zzarVar.zzd += j2;
                    }
                    if (z5) {
                        zzarVar.zze += j2;
                    }
                    if (z6) {
                        zzarVar.zzf += j2;
                    }
                    if (z7) {
                        zzarVar.zzg += j2;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(zzarVar.zza));
                    contentValues.put("daily_events_count", Long.valueOf(zzarVar.zzb));
                    contentValues.put("daily_conversions_count", Long.valueOf(zzarVar.zzc));
                    contentValues.put("daily_error_events_count", Long.valueOf(zzarVar.zzd));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(zzarVar.zze));
                    contentValues.put("daily_realtime_dcu_count", Long.valueOf(zzarVar.zzf));
                    contentValues.put("daily_registered_triggers_count", Long.valueOf(zzarVar.zzg));
                    zze2.update("apps", contentValues, "app_id=?", strArr);
                }
            } catch (SQLiteException e) {
                this.zzu.zzaW().zzb().zzc("Error updating daily counts. appId", zzgu.zzl(str), e);
            }
            if (cursor != null) {
                cursor.close();
            }
            return zzarVar;
        } finally {
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0086: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:26:0x0085 */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzaq zzy(java.lang.String r11) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            r10.zzg()
            r10.zzay()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.zze()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L69
            java.lang.String r3 = "apps"
            java.lang.String r0 = "remote_config"
            java.lang.String r4 = "config_last_modified_time"
            java.lang.String r5 = "e_tag"
            java.lang.String[] r4 = new java.lang.String[]{r0, r4, r5}     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L69
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[]{r11}     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L69
            r8 = 0
            r9 = 0
            r7 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L69
            boolean r0 = r2.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L64 java.lang.Throwable -> L84
            if (r0 != 0) goto L2e
            goto L7e
        L2e:
            r0 = 0
            byte[] r0 = r2.getBlob(r0)     // Catch: android.database.sqlite.SQLiteException -> L64 java.lang.Throwable -> L84
            r3 = 1
            java.lang.String r3 = r2.getString(r3)     // Catch: android.database.sqlite.SQLiteException -> L64 java.lang.Throwable -> L84
            r4 = 2
            java.lang.String r4 = r2.getString(r4)     // Catch: android.database.sqlite.SQLiteException -> L64 java.lang.Throwable -> L84
            boolean r5 = r2.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L64 java.lang.Throwable -> L84
            if (r5 == 0) goto L56
            com.google.android.gms.measurement.internal.zzic r5 = r10.zzu     // Catch: android.database.sqlite.SQLiteException -> L64 java.lang.Throwable -> L84
            com.google.android.gms.measurement.internal.zzgu r5 = r5.zzaW()     // Catch: android.database.sqlite.SQLiteException -> L64 java.lang.Throwable -> L84
            com.google.android.gms.measurement.internal.zzgs r5 = r5.zzb()     // Catch: android.database.sqlite.SQLiteException -> L64 java.lang.Throwable -> L84
            java.lang.String r6 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzgu.zzl(r11)     // Catch: android.database.sqlite.SQLiteException -> L64 java.lang.Throwable -> L84
            r5.zzb(r6, r7)     // Catch: android.database.sqlite.SQLiteException -> L64 java.lang.Throwable -> L84
        L56:
            if (r0 != 0) goto L59
            goto L7e
        L59:
            com.google.android.gms.measurement.internal.zzaq r5 = new com.google.android.gms.measurement.internal.zzaq     // Catch: android.database.sqlite.SQLiteException -> L64 java.lang.Throwable -> L84
            r5.<init>(r0, r3, r4)     // Catch: android.database.sqlite.SQLiteException -> L64 java.lang.Throwable -> L84
            if (r2 == 0) goto L63
            r2.close()
        L63:
            return r5
        L64:
            r0 = move-exception
            goto L6b
        L66:
            r0 = move-exception
            r10 = r0
            goto L87
        L69:
            r0 = move-exception
            r2 = r1
        L6b:
            com.google.android.gms.measurement.internal.zzic r10 = r10.zzu     // Catch: java.lang.Throwable -> L84
            com.google.android.gms.measurement.internal.zzgu r10 = r10.zzaW()     // Catch: java.lang.Throwable -> L84
            com.google.android.gms.measurement.internal.zzgs r10 = r10.zzb()     // Catch: java.lang.Throwable -> L84
            java.lang.String r3 = "Error querying remote config. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzgu.zzl(r11)     // Catch: java.lang.Throwable -> L84
            r10.zzc(r3, r11, r0)     // Catch: java.lang.Throwable -> L84
        L7e:
            if (r2 == 0) goto L83
            r2.close()
        L83:
            return r1
        L84:
            r0 = move-exception
            r10 = r0
            r1 = r2
        L87:
            if (r1 == 0) goto L8c
            r1.close()
        L8c:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaw.zzy(java.lang.String):com.google.android.gms.measurement.internal.zzaq");
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0043, code lost:
    
        if (r3 > (com.google.android.gms.measurement.internal.zzal.zzI() + r1)) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzz(com.google.android.gms.internal.measurement.zzid r8, boolean r9) {
        /*
            r7 = this;
            r7.zzg()
            r7.zzay()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)
            java.lang.String r0 = r8.zzA()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)
            boolean r0 = r8.zzn()
            com.google.android.gms.common.internal.Preconditions.checkState(r0)
            r7.zzI()
            com.google.android.gms.measurement.internal.zzic r0 = r7.zzu
            com.google.android.gms.common.util.Clock r1 = r0.zzba()
            long r1 = r1.currentTimeMillis()
            long r3 = r8.zzo()
            r0.zzc()
            long r5 = com.google.android.gms.measurement.internal.zzal.zzI()
            long r5 = r1 - r5
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 < 0) goto L45
            long r3 = r8.zzo()
            r0.zzc()
            long r5 = com.google.android.gms.measurement.internal.zzal.zzI()
            long r5 = r5 + r1
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L66
        L45:
            com.google.android.gms.measurement.internal.zzgu r0 = r0.zzaW()
            com.google.android.gms.measurement.internal.zzgs r0 = r0.zze()
            java.lang.String r3 = r8.zzA()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgu.zzl(r3)
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            long r4 = r8.zzo()
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            java.lang.String r4 = "Storing bundle outside of the max uploading time span. appId, now, timestamp"
            r0.zzd(r4, r3, r1, r2)
        L66:
            byte[] r0 = r8.zzcd()
            r1 = 0
            com.google.android.gms.measurement.internal.zzpg r2 = r7.zzg     // Catch: java.io.IOException -> L107
            com.google.android.gms.measurement.internal.zzpk r2 = r2.zzp()     // Catch: java.io.IOException -> L107
            byte[] r0 = r2.zzv(r0)     // Catch: java.io.IOException -> L107
            com.google.android.gms.measurement.internal.zzic r2 = r7.zzu
            com.google.android.gms.measurement.internal.zzgu r3 = r2.zzaW()
            com.google.android.gms.measurement.internal.zzgs r3 = r3.zzk()
            int r4 = r0.length
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = "Saving bundle, size"
            r3.zzb(r5, r4)
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.String r4 = r8.zzA()
            java.lang.String r5 = "app_id"
            r3.put(r5, r4)
            long r4 = r8.zzo()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.String r5 = "bundle_end_timestamp"
            r3.put(r5, r4)
            java.lang.String r4 = "data"
            r3.put(r4, r0)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r0 = "has_realtime"
            r3.put(r0, r9)
            boolean r9 = r8.zzaa()
            if (r9 == 0) goto Lc5
            int r9 = r8.zzab()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r0 = "retry_count"
            r3.put(r0, r9)
        Lc5:
            android.database.sqlite.SQLiteDatabase r9 = r7.zze()     // Catch: android.database.sqlite.SQLiteException -> Lee
            java.lang.String r0 = "queue"
            r4 = 0
            long r3 = r9.insert(r0, r4, r3)     // Catch: android.database.sqlite.SQLiteException -> Lee
            r5 = -1
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 != 0) goto Lec
            com.google.android.gms.measurement.internal.zzgu r9 = r2.zzaW()     // Catch: android.database.sqlite.SQLiteException -> Lee
            com.google.android.gms.measurement.internal.zzgs r9 = r9.zzb()     // Catch: android.database.sqlite.SQLiteException -> Lee
            java.lang.String r0 = "Failed to insert bundle (got -1). appId"
            java.lang.String r2 = r8.zzA()     // Catch: android.database.sqlite.SQLiteException -> Lee
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzgu.zzl(r2)     // Catch: android.database.sqlite.SQLiteException -> Lee
            r9.zzb(r0, r2)     // Catch: android.database.sqlite.SQLiteException -> Lee
            return r1
        Lec:
            r7 = 1
            return r7
        Lee:
            r9 = move-exception
            com.google.android.gms.measurement.internal.zzic r7 = r7.zzu
            com.google.android.gms.measurement.internal.zzgu r7 = r7.zzaW()
            com.google.android.gms.measurement.internal.zzgs r7 = r7.zzb()
            java.lang.String r8 = r8.zzA()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgu.zzl(r8)
            java.lang.String r0 = "Error storing bundle. appId"
            r7.zzc(r0, r8, r9)
            return r1
        L107:
            r9 = move-exception
            com.google.android.gms.measurement.internal.zzic r7 = r7.zzu
            com.google.android.gms.measurement.internal.zzgu r7 = r7.zzaW()
            com.google.android.gms.measurement.internal.zzgs r7 = r7.zzb()
            java.lang.String r8 = r8.zzA()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgu.zzl(r8)
            java.lang.String r0 = "Data loss. Failed to serialize bundle. appId"
            r7.zzc(r0, r8, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaw.zzz(com.google.android.gms.internal.measurement.zzid, boolean):boolean");
    }
}
