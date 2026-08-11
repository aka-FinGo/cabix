package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.UserManager;
import android.util.Log;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzky {
    public static final /* synthetic */ int zza = 0;
    private static UserManager zzb;
    private static volatile boolean zzc = !zza();

    private zzky() {
    }

    public static boolean zza() {
        return true;
    }

    public static boolean zzb(Context context) {
        return zza() && !zzi(context);
    }

    public static boolean zzc(Context context) {
        return !zza() || zzi(context);
    }

    public static ListenableFuture zzd(Context context, final Callable callable, Executor executor) {
        return zze(context, new AsyncCallable() { // from class: com.google.android.gms.internal.measurement.zzkx
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final /* synthetic */ ListenableFuture call() {
                int i = zzky.zza;
                return Futures.submit(callable, MoreExecutors.directExecutor());
            }
        }, executor);
    }

    public static ListenableFuture zze(final Context context, AsyncCallable asyncCallable, Executor executor) {
        if (zzc(context)) {
            return Futures.submitAsync(asyncCallable, executor);
        }
        final SettableFuture create = SettableFuture.create();
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        final zzkv zzkvVar = new zzkv(atomicBoolean, context, create, asyncCallable, executor);
        context.registerReceiver(zzkvVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
        if (zzc(context) && atomicBoolean.compareAndSet(false, true)) {
            zzh(context, zzkvVar);
            create.setFuture(Futures.submitAsync(asyncCallable, executor));
            return create;
        }
        create.addListener(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzkw
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzky.zzj(SettableFuture.this, atomicBoolean, context, zzkvVar);
            }
        }, MoreExecutors.directExecutor());
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzh(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException e) {
            Log.w("DirectBootUtils", "Failed to unregister receiver", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void zzj(SettableFuture settableFuture, AtomicBoolean atomicBoolean, Context context, BroadcastReceiver broadcastReceiver) {
        if (settableFuture.isCancelled() && atomicBoolean.compareAndSet(false, true)) {
            zzh(context, broadcastReceiver);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0035, code lost:
    
        if (r3.isUserRunning(android.os.Process.myUserHandle()) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:
    
        r5 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean zzi(android.content.Context r7) {
        /*
            boolean r0 = com.google.android.gms.internal.measurement.zzky.zzc
            r1 = 1
            if (r0 == 0) goto L6
            return r1
        L6:
            java.lang.Class<com.google.android.gms.internal.measurement.zzky> r0 = com.google.android.gms.internal.measurement.zzky.class
            monitor-enter(r0)
            boolean r2 = com.google.android.gms.internal.measurement.zzky.zzc     // Catch: java.lang.Throwable -> L50
            if (r2 == 0) goto Lf
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L50
            return r1
        Lf:
            r2 = r1
        L10:
            r3 = 2
            r4 = 0
            r5 = 0
            if (r2 > r3) goto L46
            android.os.UserManager r3 = com.google.android.gms.internal.measurement.zzky.zzb     // Catch: java.lang.Throwable -> L50
            if (r3 != 0) goto L23
            java.lang.Class<android.os.UserManager> r3 = android.os.UserManager.class
            java.lang.Object r3 = r7.getSystemService(r3)     // Catch: java.lang.Throwable -> L50
            android.os.UserManager r3 = (android.os.UserManager) r3     // Catch: java.lang.Throwable -> L50
            com.google.android.gms.internal.measurement.zzky.zzb = r3     // Catch: java.lang.Throwable -> L50
        L23:
            if (r3 != 0) goto L27
            r5 = r1
            goto L4a
        L27:
            boolean r6 = r3.isUserUnlocked()     // Catch: java.lang.NullPointerException -> L39 java.lang.Throwable -> L50
            if (r6 != 0) goto L37
            android.os.UserHandle r6 = android.os.Process.myUserHandle()     // Catch: java.lang.NullPointerException -> L39 java.lang.Throwable -> L50
            boolean r7 = r3.isUserRunning(r6)     // Catch: java.lang.NullPointerException -> L39 java.lang.Throwable -> L50
            if (r7 != 0) goto L46
        L37:
            r5 = r1
            goto L46
        L39:
            r3 = move-exception
            java.lang.String r5 = "DirectBootUtils"
            java.lang.String r6 = "Failed to check if user is unlocked."
            android.util.Log.w(r5, r6, r3)     // Catch: java.lang.Throwable -> L50
            com.google.android.gms.internal.measurement.zzky.zzb = r4     // Catch: java.lang.Throwable -> L50
            int r2 = r2 + 1
            goto L10
        L46:
            if (r5 == 0) goto L4a
            com.google.android.gms.internal.measurement.zzky.zzb = r4     // Catch: java.lang.Throwable -> L50
        L4a:
            if (r5 == 0) goto L4e
            com.google.android.gms.internal.measurement.zzky.zzc = r1     // Catch: java.lang.Throwable -> L50
        L4e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L50
            return r5
        L50:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L50
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzky.zzi(android.content.Context):boolean");
    }
}
