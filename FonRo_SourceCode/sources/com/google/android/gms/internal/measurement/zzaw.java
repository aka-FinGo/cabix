package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzaw {
    final Map zza = new HashMap();
    final zzbi zzb = new zzbi();

    public zzaw() {
        zza(new zzau());
        zza(new zzax());
        zza(new zzay());
        zza(new zzbb());
        zza(new zzbg());
        zza(new zzbh());
        zza(new zzbj());
    }

    final void zza(zzav zzavVar) {
        Iterator it = zzavVar.zza.iterator();
        while (it.hasNext()) {
            this.zza.put(((zzbk) it.next()).zzb().toString(), zzavVar);
        }
    }

    public final zzao zzb(zzg zzgVar, zzao zzaoVar) {
        zzav zzavVar;
        zzh.zzl(zzgVar);
        if (!(zzaoVar instanceof zzap)) {
            return zzaoVar;
        }
        zzap zzapVar = (zzap) zzaoVar;
        ArrayList zzg = zzapVar.zzg();
        String zzb = zzapVar.zzb();
        Map map = this.zza;
        if (map.containsKey(zzb)) {
            zzavVar = (zzav) map.get(zzb);
        } else {
            zzavVar = this.zzb;
        }
        return zzavVar.zza(zzb, zzgVar, zzg);
    }
}
