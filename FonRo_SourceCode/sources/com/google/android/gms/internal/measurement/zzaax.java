package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
final class zzaax implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        zzabd zza = zzabd.zza(obj);
        zzabd zza2 = zzabd.zza(obj2);
        if (zza == zza2) {
            int ordinal = zza.ordinal();
            if (ordinal == 0) {
                return ((Boolean) obj).compareTo((Boolean) obj2);
            }
            if (ordinal == 1) {
                return ((String) obj).compareTo((String) obj2);
            }
            if (ordinal == 2) {
                return ((Long) obj).compareTo((Long) obj2);
            }
            if (ordinal != 3) {
                throw null;
            }
            return ((Double) obj).compareTo((Double) obj2);
        }
        return zza.compareTo(zza2);
    }
}
