package com.google.android.gms.common.wrappers;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-basement@@18.9.0 */
/* loaded from: classes5.dex */
public class Wrappers {
    private static final Wrappers zzb = new Wrappers();
    private PackageManagerWrapper zza = null;

    public static PackageManagerWrapper packageManager(Context context) {
        return zzb.zza(context);
    }

    public final synchronized PackageManagerWrapper zza(Context context) {
        PackageManagerWrapper packageManagerWrapper;
        packageManagerWrapper = this.zza;
        if (packageManagerWrapper == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            packageManagerWrapper = new PackageManagerWrapper(context);
            this.zza = packageManagerWrapper;
        }
        return packageManagerWrapper;
    }
}
