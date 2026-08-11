package com.google.android.gms.common.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-basement@@18.9.0 */
/* loaded from: classes5.dex */
public final class DeviceProperties {
    private static Boolean zza;
    private static Boolean zzb;
    private static Boolean zzc;
    private static Boolean zzd;
    private static Boolean zze;
    private static Boolean zzf;
    private static Boolean zzg;
    private static Boolean zzh;
    private static Boolean zzi;
    private static Boolean zzj;
    private static Boolean zzk;
    private static Boolean zzl;
    private static Boolean zzm;
    private static Boolean zzn;
    private static Boolean zzo;
    private static Boolean zzp;
    private static Boolean zzq;

    private DeviceProperties() {
    }

    public static boolean isAuto(Context context) {
        return zze(context.getPackageManager());
    }

    public static boolean isBstar(Context context) {
        Boolean bool = zzo;
        if (bool == null) {
            boolean z = false;
            if (PlatformVersion.isAtLeastR() && context.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")) {
                z = true;
            }
            bool = Boolean.valueOf(z);
            zzo = bool;
        }
        return bool.booleanValue();
    }

    public static boolean isFoldable(Context context) {
        Boolean bool = zzd;
        if (bool == null) {
            boolean z = false;
            if (PlatformVersion.isAtLeastR() && context.getPackageManager().hasSystemFeature("android.hardware.sensor.hinge_angle")) {
                z = true;
            }
            bool = Boolean.valueOf(z);
            zzd = bool;
        }
        return bool.booleanValue();
    }

    public static boolean isLatchsky(Context context) {
        Boolean bool = zzh;
        if (bool == null) {
            PackageManager packageManager = context.getPackageManager();
            boolean z = false;
            if (packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services")) {
                z = true;
            }
            bool = Boolean.valueOf(z);
            zzh = bool;
        }
        return bool.booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0082, code lost:
    
        if (r0.booleanValue() == false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isPhone(android.content.Context r4) {
        /*
            java.lang.Boolean r0 = com.google.android.gms.common.util.DeviceProperties.zza
            if (r0 != 0) goto L8c
            boolean r0 = isFoldable(r4)
            r1 = 1
            if (r0 != 0) goto L86
            boolean r0 = isTablet(r4)
            r2 = 0
            if (r0 != 0) goto L85
            boolean r0 = isWearable(r4)
            if (r0 != 0) goto L85
            boolean r0 = zzd(r4)
            if (r0 != 0) goto L85
            java.lang.Boolean r0 = com.google.android.gms.common.util.DeviceProperties.zzk
            if (r0 != 0) goto L32
            android.content.pm.PackageManager r0 = r4.getPackageManager()
            java.lang.String r3 = "org.chromium.arc"
            boolean r0 = r0.hasSystemFeature(r3)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            com.google.android.gms.common.util.DeviceProperties.zzk = r0
        L32:
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L85
            boolean r0 = isAuto(r4)
            if (r0 != 0) goto L85
            boolean r0 = isTv(r4)
            if (r0 != 0) goto L85
            java.lang.Boolean r0 = com.google.android.gms.common.util.DeviceProperties.zzn
            if (r0 != 0) goto L58
            android.content.pm.PackageManager r0 = r4.getPackageManager()
            java.lang.String r3 = "com.google.android.feature.AMATI_EXPERIENCE"
            boolean r0 = r0.hasSystemFeature(r3)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            com.google.android.gms.common.util.DeviceProperties.zzn = r0
        L58:
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L85
            boolean r0 = isBstar(r4)
            if (r0 != 0) goto L85
            boolean r0 = isXr(r4)
            if (r0 != 0) goto L85
            java.lang.Boolean r0 = com.google.android.gms.common.util.DeviceProperties.zzq
            if (r0 != 0) goto L7e
            android.content.pm.PackageManager r4 = r4.getPackageManager()
            java.lang.String r0 = "com.google.desktop.gms"
            boolean r4 = r4.hasSystemFeature(r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)
            com.google.android.gms.common.util.DeviceProperties.zzq = r0
        L7e:
            boolean r4 = r0.booleanValue()
            if (r4 != 0) goto L85
            goto L86
        L85:
            r1 = r2
        L86:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            com.google.android.gms.common.util.DeviceProperties.zza = r0
        L8c:
            boolean r4 = r0.booleanValue()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.DeviceProperties.isPhone(android.content.Context):boolean");
    }

    public static boolean isPhoneGo(Context context) {
        ActivityManager activityManager;
        boolean z = false;
        if (context == null) {
            return false;
        }
        Boolean bool = zzb;
        if (bool == null) {
            if (isPhone(context)) {
                if (zzi == null && (activityManager = (ActivityManager) context.getSystemService("activity")) != null) {
                    zzi = Boolean.valueOf(activityManager.isLowRamDevice());
                }
                if (Objects.equal(zzi, true) && Build.VERSION.SDK_INT >= 27) {
                    z = true;
                }
            }
            bool = Boolean.valueOf(z);
            zzb = bool;
        }
        return bool.booleanValue();
    }

    public static boolean isSevenInchTablet(Context context) {
        return zza(context.getResources());
    }

    public static boolean isSidewinder(Context context) {
        return zzc(context);
    }

    public static boolean isTablet(Context context) {
        return isTablet(context.getResources());
    }

    public static boolean isTv(Context context) {
        return zzf(context.getPackageManager());
    }

    public static boolean isUserBuild() {
        int i = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        return "user".equals(Build.TYPE);
    }

    public static boolean isWearable(Context context) {
        return zzb(context.getPackageManager());
    }

    public static boolean isWearableWithoutPlayStore(Context context) {
        if (isWearable(context) && !PlatformVersion.isAtLeastN()) {
            return true;
        }
        if (zzc(context)) {
            return !PlatformVersion.isAtLeastO() || PlatformVersion.isAtLeastR();
        }
        return false;
    }

    public static boolean isXr(Context context) {
        return zzg(context.getPackageManager());
    }

    public static boolean zza(Resources resources) {
        boolean z = false;
        if (resources == null) {
            return false;
        }
        Boolean bool = zze;
        if (bool == null) {
            Configuration configuration = resources.getConfiguration();
            if ((configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600) {
                z = true;
            }
            bool = Boolean.valueOf(z);
            zze = bool;
        }
        return bool.booleanValue();
    }

    public static boolean zzb(PackageManager packageManager) {
        Boolean bool = zzf;
        if (bool == null) {
            bool = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
            zzf = bool;
        }
        return bool.booleanValue();
    }

    public static boolean zzc(Context context) {
        Boolean bool = zzg;
        if (bool == null) {
            bool = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
            zzg = bool;
        }
        return bool.booleanValue();
    }

    public static boolean zzd(Context context) {
        Boolean bool = zzj;
        if (bool == null) {
            bool = Boolean.valueOf(PlatformVersion.isAtLeastO() ? context.getPackageManager().hasSystemFeature("android.hardware.type.embedded") : context.getPackageManager().hasSystemFeature("android.hardware.type.iot"));
            zzj = bool;
        }
        return bool.booleanValue();
    }

    public static boolean zze(PackageManager packageManager) {
        Boolean bool = zzl;
        if (bool == null) {
            boolean z = false;
            if (PlatformVersion.isAtLeastO() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z = true;
            }
            bool = Boolean.valueOf(z);
            zzl = bool;
        }
        return bool.booleanValue();
    }

    public static boolean zzf(PackageManager packageManager) {
        Boolean bool = zzm;
        if (bool == null) {
            boolean z = true;
            if (!packageManager.hasSystemFeature("com.google.android.tv") && !packageManager.hasSystemFeature("android.hardware.type.television") && !packageManager.hasSystemFeature("android.software.leanback") && !packageManager.hasSystemFeature("com.google.android.feature.AMATI_EXPERIENCE")) {
                z = false;
            }
            bool = Boolean.valueOf(z);
            zzm = bool;
        }
        return bool.booleanValue();
    }

    public static boolean zzg(PackageManager packageManager) {
        Boolean bool = zzp;
        if (bool == null) {
            bool = Boolean.valueOf(packageManager.hasSystemFeature("android.software.xr.api.spatial"));
            zzp = bool;
        }
        return bool.booleanValue();
    }

    public static boolean isTablet(Resources resources) {
        if (resources == null) {
            return false;
        }
        Boolean bool = zzc;
        if (bool == null) {
            bool = Boolean.valueOf((resources.getConfiguration().screenLayout & 15) > 3 || zza(resources));
            zzc = bool;
        }
        return bool.booleanValue();
    }
}
