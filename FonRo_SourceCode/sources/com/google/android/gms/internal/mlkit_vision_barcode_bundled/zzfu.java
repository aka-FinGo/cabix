package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* loaded from: classes5.dex */
public final class zzfu {
    public static final /* synthetic */ int zza = 0;
    private static final zzfu zzb = new zzfu();
    private final ConcurrentMap zzd = new ConcurrentHashMap();
    private final zzgf zzc = new zzfe();

    private zzfu() {
    }

    public static zzfu zza() {
        return zzb;
    }

    public final zzge zzb(Class cls) {
        zzep.zzc(cls, "messageType");
        zzge zzgeVar = (zzge) this.zzd.get(cls);
        if (zzgeVar != null) {
            return zzgeVar;
        }
        zzge zza2 = this.zzc.zza(cls);
        zzep.zzc(cls, "messageType");
        zzge zzgeVar2 = (zzge) this.zzd.putIfAbsent(cls, zza2);
        return zzgeVar2 == null ? zza2 : zzgeVar2;
    }
}
