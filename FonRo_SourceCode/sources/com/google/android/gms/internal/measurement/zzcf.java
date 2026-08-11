package com.google.android.gms.internal.measurement;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzcf {
    private static final Method zza;
    private static final Method zzb;

    static {
        Method method;
        Method method2 = null;
        try {
            method = JobScheduler.class.getDeclaredMethod("scheduleAsPackage", JobInfo.class, String.class, Integer.TYPE, String.class);
        } catch (NoSuchMethodException unused) {
            if (Log.isLoggable("JobSchedulerCompat", 6)) {
                Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
            }
            method = null;
        }
        zza = method;
        try {
            method2 = UserHandle.class.getDeclaredMethod("myUserId", null);
        } catch (NoSuchMethodException unused2) {
            if (Log.isLoggable("JobSchedulerCompat", 6)) {
                Log.e("JobSchedulerCompat", "No myUserId method available");
            }
        }
        zzb = method2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int zza(android.content.Context r3, android.app.job.JobInfo r4, java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.String r5 = "jobscheduler"
            java.lang.Object r5 = r3.getSystemService(r5)
            android.app.job.JobScheduler r5 = (android.app.job.JobScheduler) r5
            java.lang.Object r5 = com.google.common.base.Preconditions.checkNotNull(r5)
            android.app.job.JobScheduler r5 = (android.app.job.JobScheduler) r5
            java.lang.reflect.Method r6 = com.google.android.gms.internal.measurement.zzcf.zza
            if (r6 == 0) goto L6b
            java.lang.String r6 = "android.permission.UPDATE_DEVICE_STATS"
            int r3 = r3.checkSelfPermission(r6)
            if (r3 != 0) goto L6b
            java.lang.reflect.Method r3 = com.google.android.gms.internal.measurement.zzcf.zzb
            r6 = 0
            if (r3 == 0) goto L40
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            r1 = 0
            java.lang.Object r3 = r3.invoke(r0, r1)     // Catch: java.lang.reflect.InvocationTargetException -> L2f java.lang.IllegalAccessException -> L31
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.reflect.InvocationTargetException -> L2f java.lang.IllegalAccessException -> L31
            if (r3 == 0) goto L40
            int r3 = r3.intValue()     // Catch: java.lang.reflect.InvocationTargetException -> L2f java.lang.IllegalAccessException -> L31
            goto L41
        L2f:
            r3 = move-exception
            goto L32
        L31:
            r3 = move-exception
        L32:
            r0 = 6
            java.lang.String r1 = "JobSchedulerCompat"
            boolean r0 = android.util.Log.isLoggable(r1, r0)
            if (r0 == 0) goto L40
            java.lang.String r0 = "myUserId invocation illegal"
            android.util.Log.e(r1, r0, r3)
        L40:
            r3 = r6
        L41:
            java.lang.String r0 = "UploadAlarm"
            java.lang.String r1 = "com.google.android.gms"
            java.lang.reflect.Method r2 = com.google.android.gms.internal.measurement.zzcf.zza
            if (r2 == 0) goto L66
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L60
            java.lang.Object[] r3 = new java.lang.Object[]{r4, r1, r3, r0}     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L60
            java.lang.Object r3 = r2.invoke(r5, r3)     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L60
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L60
            if (r3 == 0) goto L6a
            int r6 = r3.intValue()     // Catch: java.lang.reflect.InvocationTargetException -> L5e java.lang.IllegalAccessException -> L60
            goto L6a
        L5e:
            r3 = move-exception
            goto L61
        L60:
            r3 = move-exception
        L61:
            java.lang.String r6 = "error calling scheduleAsPackage"
            android.util.Log.e(r0, r6, r3)
        L66:
            int r6 = r5.schedule(r4)
        L6a:
            return r6
        L6b:
            int r3 = r5.schedule(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzcf.zza(android.content.Context, android.app.job.JobInfo, java.lang.String, java.lang.String):int");
    }
}
