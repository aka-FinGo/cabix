package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@18.9.0 */
/* loaded from: classes5.dex */
public class WorkSourceUtil {
    private static final int zza = Process.myUid();
    private static final Method zzb;
    private static final Method zzc;
    private static final Method zzd;
    private static final Method zze;
    private static final Method zzf;
    private static final Method zzg;
    private static final Method zzh;
    private static final Method zzi;
    private static Boolean zzj;

    /* JADX WARN: Removed duplicated region for block: B:28:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = "add"
            java.lang.Class<android.os.WorkSource> r2 = android.os.WorkSource.class
            int r3 = android.os.Process.myUid()
            com.google.android.gms.common.util.WorkSourceUtil.zza = r3
            r3 = 0
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L18
            java.lang.Class[] r4 = new java.lang.Class[]{r4}     // Catch: java.lang.Exception -> L18
            java.lang.reflect.Method r4 = r2.getMethod(r1, r4)     // Catch: java.lang.Exception -> L18
            goto L19
        L18:
            r4 = r3
        L19:
            com.google.android.gms.common.util.WorkSourceUtil.zzb = r4
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L26
            java.lang.Class[] r4 = new java.lang.Class[]{r4, r0}     // Catch: java.lang.Exception -> L26
            java.lang.reflect.Method r1 = r2.getMethod(r1, r4)     // Catch: java.lang.Exception -> L26
            goto L27
        L26:
            r1 = r3
        L27:
            com.google.android.gms.common.util.WorkSourceUtil.zzc = r1
            java.lang.String r1 = "size"
            java.lang.reflect.Method r1 = r2.getMethod(r1, r3)     // Catch: java.lang.Exception -> L30
            goto L31
        L30:
            r1 = r3
        L31:
            com.google.android.gms.common.util.WorkSourceUtil.zzd = r1
            java.lang.String r1 = "get"
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L40
            java.lang.Class[] r4 = new java.lang.Class[]{r4}     // Catch: java.lang.Exception -> L40
            java.lang.reflect.Method r1 = r2.getMethod(r1, r4)     // Catch: java.lang.Exception -> L40
            goto L41
        L40:
            r1 = r3
        L41:
            com.google.android.gms.common.util.WorkSourceUtil.zze = r1
            java.lang.String r1 = "getName"
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L50
            java.lang.Class[] r4 = new java.lang.Class[]{r4}     // Catch: java.lang.Exception -> L50
            java.lang.reflect.Method r1 = r2.getMethod(r1, r4)     // Catch: java.lang.Exception -> L50
            goto L51
        L50:
            r1 = r3
        L51:
            com.google.android.gms.common.util.WorkSourceUtil.zzf = r1
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            java.lang.String r4 = "WorkSourceUtil"
            if (r1 == 0) goto L68
            java.lang.String r1 = "createWorkChain"
            java.lang.reflect.Method r1 = r2.getMethod(r1, r3)     // Catch: java.lang.Exception -> L62
            goto L69
        L62:
            r1 = move-exception
            java.lang.String r5 = "Missing WorkChain API createWorkChain"
            android.util.Log.w(r4, r5, r1)
        L68:
            r1 = r3
        L69:
            com.google.android.gms.common.util.WorkSourceUtil.zzg = r1
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r1 == 0) goto L8a
            java.lang.String r1 = "android.os.WorkSource$WorkChain"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Exception -> L84
            java.lang.String r5 = "addNode"
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L84
            java.lang.Class[] r0 = new java.lang.Class[]{r6, r0}     // Catch: java.lang.Exception -> L84
            java.lang.reflect.Method r0 = r1.getMethod(r5, r0)     // Catch: java.lang.Exception -> L84
            goto L8b
        L84:
            r0 = move-exception
            java.lang.String r1 = "Missing WorkChain class"
            android.util.Log.w(r4, r1, r0)
        L8a:
            r0 = r3
        L8b:
            com.google.android.gms.common.util.WorkSourceUtil.zzh = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r0 == 0) goto L9e
            java.lang.String r0 = "isEmpty"
            java.lang.reflect.Method r0 = r2.getMethod(r0, r3)     // Catch: java.lang.Exception -> L9e
            r1 = 1
            r0.setAccessible(r1)     // Catch: java.lang.Exception -> L9f
            goto L9f
        L9e:
            r0 = r3
        L9f:
            com.google.android.gms.common.util.WorkSourceUtil.zzi = r0
            com.google.android.gms.common.util.WorkSourceUtil.zzj = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.<clinit>():void");
    }

    private WorkSourceUtil() {
    }

    public static void add(WorkSource workSource, int i, String str) {
        Method method = zzc;
        if (method == null) {
            Method method2 = zzb;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, Integer.valueOf(i));
                    return;
                } catch (Exception e) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
                    return;
                }
            }
            return;
        }
        if (str == null) {
            str = "";
        }
        try {
            method.invoke(workSource, Integer.valueOf(i), str);
        } catch (Exception e2) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
        }
    }

    public static WorkSource fromPackage(Context context, String str) {
        if (context != null && context.getPackageManager() != null && str != null) {
            try {
                ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
                if (applicationInfo == null) {
                    Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
                    return null;
                }
                int i = applicationInfo.uid;
                WorkSource workSource = new WorkSource();
                add(workSource, i, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
            }
        }
        return null;
    }

    public static WorkSource fromPackageAndModuleExperimentalPi(Context context, String str, String str2) {
        Method method;
        if (context == null || context.getPackageManager() == null || str2 == null || str == null) {
            Log.w("WorkSourceUtil", "Unexpected null arguments");
            return null;
        }
        int i = -1;
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
            if (applicationInfo == null) {
                Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
            } else {
                i = applicationInfo.uid;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
        }
        if (i < 0) {
            return null;
        }
        WorkSource workSource = new WorkSource();
        Method method2 = zzg;
        if (method2 == null || (method = zzh) == null) {
            add(workSource, i, str);
        } else {
            try {
                Object invoke = method2.invoke(workSource, null);
                int i2 = zza;
                if (i != i2) {
                    method.invoke(invoke, Integer.valueOf(i), str);
                }
                method.invoke(invoke, Integer.valueOf(i2), str2);
            } catch (Exception e) {
                Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", e);
            }
        }
        return workSource;
    }

    public static int get(WorkSource workSource, int i) {
        Method method = zze;
        if (method == null) {
            return 0;
        }
        try {
            Object invoke = method.invoke(workSource, Integer.valueOf(i));
            Preconditions.checkNotNull(invoke);
            return ((Integer) invoke).intValue();
        } catch (Exception e) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            return 0;
        }
    }

    public static String getName(WorkSource workSource, int i) {
        Method method = zzf;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, Integer.valueOf(i));
        } catch (Exception e) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            return null;
        }
    }

    public static List<String> getNames(WorkSource workSource) {
        ArrayList arrayList = new ArrayList();
        int size = workSource == null ? 0 : size(workSource);
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                String name = getName(workSource, i);
                if (!Strings.isEmptyOrWhitespace(name)) {
                    Preconditions.checkNotNull(name);
                    arrayList.add(name);
                }
            }
        }
        return arrayList;
    }

    public static synchronized boolean hasWorkSourcePermission(Context context) {
        synchronized (WorkSourceUtil.class) {
            Boolean bool = zzj;
            if (bool != null) {
                return bool.booleanValue();
            }
            if (context == null) {
                return false;
            }
            boolean z = ContextCompat.checkSelfPermission(context, "android.permission.UPDATE_DEVICE_STATS") == 0;
            Boolean valueOf = Boolean.valueOf(z);
            zzj = valueOf;
            valueOf.getClass();
            return z;
        }
    }

    public static boolean isEmpty(WorkSource workSource) {
        Method method = zzi;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, null);
                Preconditions.checkNotNull(invoke);
                return ((Boolean) invoke).booleanValue();
            } catch (Exception e) {
                Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", e);
            }
        }
        return size(workSource) == 0;
    }

    public static int size(WorkSource workSource) {
        Method method = zzd;
        if (method == null) {
            return 0;
        }
        try {
            Object invoke = method.invoke(workSource, null);
            Preconditions.checkNotNull(invoke);
            return ((Integer) invoke).intValue();
        } catch (Exception e) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            return 0;
        }
    }
}
