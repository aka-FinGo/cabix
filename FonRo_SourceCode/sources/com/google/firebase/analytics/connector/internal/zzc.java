package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzjo;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-api@@23.2.0 */
/* loaded from: classes6.dex */
public final class zzc {
    public static final /* synthetic */ int zza = 0;
    private static final ImmutableSet zzb = ImmutableSet.of("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", FirebaseAnalytics.Event.CAMPAIGN_DETAILS, "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire");
    private static final ImmutableList zzc = ImmutableList.of("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");
    private static final ImmutableList zzd = ImmutableList.of(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "app", "am");
    private static final ImmutableList zze = ImmutableList.of("_r", "_dbg");
    private static final ImmutableList zzf = new ImmutableList.Builder().add((Object[]) zzjo.zza).add((Object[]) zzjo.zzb).build();
    private static final ImmutableList zzg = ImmutableList.of("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    public static boolean zza(String str) {
        return !zzd.contains(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean zzb(String str, Bundle bundle) {
        if (zzc.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        ImmutableList immutableList = zze;
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            boolean containsKey = bundle.containsKey((String) immutableList.get(i));
            i++;
            if (containsKey) {
                return false;
            }
        }
        return true;
    }

    public static boolean zzc(String str) {
        return !zzb.contains(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean zze(String str, String str2, Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!zza(str) || bundle == null) {
            return false;
        }
        ImmutableList immutableList = zze;
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            boolean containsKey = bundle.containsKey((String) immutableList.get(i));
            i++;
            if (containsKey) {
                return false;
            }
        }
        int hashCode = str.hashCode();
        if (hashCode != 101200) {
            if (hashCode != 101230) {
                if (hashCode == 3142703 && str.equals(AppMeasurement.FIAM_ORIGIN)) {
                    bundle.putString("_cis", "fiam_integration");
                    return true;
                }
            } else if (str.equals("fdl")) {
                bundle.putString("_cis", "fdl_integration");
                return true;
            }
        } else if (str.equals(AppMeasurement.FCM_ORIGIN)) {
            bundle.putString("_cis", "fcm_integration");
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean zzd(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals(AppMeasurement.FCM_ORIGIN) || str.equals("frc");
        }
        if ("_ln".equals(str2)) {
            return str.equals(AppMeasurement.FCM_ORIGIN) || str.equals(AppMeasurement.FIAM_ORIGIN);
        }
        if (zzf.contains(str2)) {
            return false;
        }
        ImmutableList immutableList = zzg;
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            boolean matches = str2.matches((String) immutableList.get(i));
            i++;
            if (matches) {
                return false;
            }
        }
        return true;
    }
}
