package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-basement@@18.9.0 */
/* loaded from: classes5.dex */
public abstract class RemoteCreator<T> {
    private final String zza;
    private Object zzb;

    /* compiled from: com.google.android.gms:play-services-basement@@18.9.0 */
    /* loaded from: classes5.dex */
    public static class RemoteCreatorException extends Exception {
        public RemoteCreatorException(String str) {
            super(str);
        }

        public RemoteCreatorException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RemoteCreator(String str) {
        this.zza = str;
    }

    protected abstract T getRemoteCreator(IBinder iBinder);

    /* JADX INFO: Access modifiers changed from: protected */
    public final T getRemoteCreatorInstance(Context context) throws RemoteCreatorException {
        T t = (T) this.zzb;
        if (t != null) {
            return t;
        }
        Preconditions.checkNotNull(context);
        Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
        if (remoteContext == null) {
            throw new RemoteCreatorException("Could not get remote context.");
        }
        try {
            T remoteCreator = getRemoteCreator((IBinder) remoteContext.getClassLoader().loadClass(this.zza).newInstance());
            this.zzb = remoteCreator;
            return remoteCreator;
        } catch (ClassNotFoundException e) {
            throw new RemoteCreatorException("Could not load creator class.", e);
        } catch (IllegalAccessException e2) {
            throw new RemoteCreatorException("Could not access creator.", e2);
        } catch (InstantiationException e3) {
            throw new RemoteCreatorException("Could not instantiate creator.", e3);
        }
    }
}
