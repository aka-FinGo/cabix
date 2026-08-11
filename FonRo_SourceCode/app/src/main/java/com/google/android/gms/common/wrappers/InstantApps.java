package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: com.google.android.gms:play-services-basement@@18.9.0 */
/* loaded from: classes5.dex */
public class InstantApps {
    private static Context zza;
    private static Boolean zzb;

    public static synchronized boolean isInstantApp(Context context) {
        Boolean bool;
        boolean isInstantApp;
        Boolean bool2;
        synchronized (InstantApps.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = zza;
            if (context2 != null && (bool2 = zzb) != null && context2 == applicationContext) {
                return bool2.booleanValue();
            }
            zzb = null;
            if (PlatformVersion.isAtLeastO()) {
                isInstantApp = applicationContext.getPackageManager().isInstantApp();
                bool = Boolean.valueOf(isInstantApp);
                zzb = bool;
            } else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    bool = true;
                    zzb = bool;
                } catch (ClassNotFoundException unused) {
                    bool = false;
                    zzb = bool;
                }
            }
            zza = applicationContext;
            return bool.booleanValue();
        }
    }
}
