package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzhl;

/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes5.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzhl.zza {
    private zzhl zza;

    public BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }

    @Override // com.google.android.gms.measurement.internal.zzhl.zza
    public void doStartService(Context context, Intent intent) {
        startWakefulService(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        zzhl zzhlVar = this.zza;
        if (zzhlVar == null) {
            zzhlVar = new zzhl(this);
            this.zza = zzhlVar;
        }
        zzhlVar.zza(context, intent);
    }
}
