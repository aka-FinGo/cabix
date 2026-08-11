package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzi {
    public static zzao zza(Object obj) {
        if (obj == null) {
            return zzao.zzg;
        }
        if (obj instanceof String) {
            return new zzas((String) obj);
        }
        if (obj instanceof Double) {
            return new zzah((Double) obj);
        }
        if (obj instanceof Long) {
            return new zzah(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new zzah(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new zzaf((Boolean) obj);
        }
        if (obj instanceof Map) {
            zzal zzalVar = new zzal();
            Map map = (Map) obj;
            for (Object obj2 : map.keySet()) {
                zzao zza = zza(map.get(obj2));
                if (obj2 != null) {
                    if (!(obj2 instanceof String)) {
                        obj2 = obj2.toString();
                    }
                    zzalVar.zzm((String) obj2, zza);
                }
            }
            return zzalVar;
        }
        if (obj instanceof List) {
            zzae zzaeVar = new zzae();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzaeVar.zzn(zzaeVar.zzh(), zza(it.next()));
            }
            return zzaeVar;
        }
        throw new IllegalArgumentException("Invalid value type");
    }

    public static zzao zzb(zzje zzjeVar) {
        if (zzjeVar == null) {
            return zzao.zzf;
        }
        int zzk = zzjeVar.zzk() - 1;
        if (zzk == 1) {
            if (zzjeVar.zzc()) {
                return new zzas(zzjeVar.zzd());
            }
            return zzao.zzm;
        }
        if (zzk == 2) {
            if (zzjeVar.zzh()) {
                return new zzah(Double.valueOf(zzjeVar.zzi()));
            }
            return new zzah(null);
        }
        if (zzk == 3) {
            if (zzjeVar.zze()) {
                return new zzaf(Boolean.valueOf(zzjeVar.zzf()));
            }
            return new zzaf(null);
        }
        if (zzk == 4) {
            List zza = zzjeVar.zza();
            ArrayList arrayList = new ArrayList();
            Iterator it = zza.iterator();
            while (it.hasNext()) {
                arrayList.add(zzb((zzje) it.next()));
            }
            return new zzap(zzjeVar.zzb(), arrayList);
        }
        throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
    }
}
