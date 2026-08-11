package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzjl {
    public static final zzjl zza = new zzjl(null, null, 100);
    private final EnumMap zzb;
    private final int zzc;

    public zzjl(Boolean bool, Boolean bool2, int i) {
        EnumMap enumMap = new EnumMap(zzjk.class);
        this.zzb = enumMap;
        enumMap.put((EnumMap) zzjk.AD_STORAGE, (zzjk) zzh(null));
        enumMap.put((EnumMap) zzjk.ANALYTICS_STORAGE, (zzjk) zzh(null));
        this.zzc = i;
    }

    public static zzjl zza(zzji zzjiVar, zzji zzjiVar2, int i) {
        EnumMap enumMap = new EnumMap(zzjk.class);
        enumMap.put((EnumMap) zzjk.AD_STORAGE, (zzjk) zzjiVar);
        enumMap.put((EnumMap) zzjk.ANALYTICS_STORAGE, (zzjk) zzjiVar2);
        return new zzjl(enumMap, -10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzd(int i) {
        return i != -30 ? i != -20 ? i != -10 ? i != 0 ? i != 30 ? i != 90 ? i != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API" : "TCF";
    }

    public static zzjl zze(Bundle bundle, int i) {
        if (bundle == null) {
            return new zzjl(null, null, i);
        }
        EnumMap enumMap = new EnumMap(zzjk.class);
        for (zzjk zzjkVar : zzjj.STORAGE.zzb()) {
            enumMap.put((EnumMap) zzjkVar, (zzjk) zzg(bundle.getString(zzjkVar.zze)));
        }
        return new zzjl(enumMap, i);
    }

    public static zzjl zzf(String str, int i) {
        EnumMap enumMap = new EnumMap(zzjk.class);
        zzjk[] zza2 = zzjj.STORAGE.zza();
        for (int i2 = 0; i2 < zza2.length; i2++) {
            String str2 = str == null ? "" : str;
            zzjk zzjkVar = zza2[i2];
            int i3 = i2 + 2;
            if (i3 < str2.length()) {
                enumMap.put((EnumMap) zzjkVar, (zzjk) zzj(str2.charAt(i3)));
            } else {
                enumMap.put((EnumMap) zzjkVar, (zzjk) zzji.UNINITIALIZED);
            }
        }
        return new zzjl(enumMap, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzji zzg(String str) {
        if (str == null) {
            return zzji.UNINITIALIZED;
        }
        if (str.equals("granted")) {
            return zzji.GRANTED;
        }
        if (str.equals("denied")) {
            return zzji.DENIED;
        }
        return zzji.UNINITIALIZED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzji zzh(Boolean bool) {
        if (bool == null) {
            return zzji.UNINITIALIZED;
        }
        if (bool.booleanValue()) {
            return zzji.GRANTED;
        }
        return zzji.DENIED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzi(zzji zzjiVar) {
        int ordinal = zzjiVar.ordinal();
        if (ordinal == 2) {
            return "denied";
        }
        if (ordinal != 3) {
            return null;
        }
        return "granted";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static char zzm(zzji zzjiVar) {
        if (zzjiVar == null) {
            return '-';
        }
        int ordinal = zzjiVar.ordinal();
        if (ordinal == 1) {
            return '+';
        }
        if (ordinal != 2) {
            return ordinal != 3 ? '-' : '1';
        }
        return '0';
    }

    public static boolean zzu(int i, int i2) {
        int i3 = -30;
        if (i == -20) {
            if (i2 == -30) {
                return true;
            }
            i = -20;
        }
        if (i != -30) {
            i3 = i;
        } else if (i2 == -20) {
            return true;
        }
        return i3 == i2 || i < i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzjl)) {
            return false;
        }
        zzjl zzjlVar = (zzjl) obj;
        for (zzjk zzjkVar : zzjj.STORAGE.zzb()) {
            if (this.zzb.get(zzjkVar) != zzjlVar.zzb.get(zzjkVar)) {
                return false;
            }
        }
        return this.zzc == zzjlVar.zzc;
    }

    public final int hashCode() {
        Iterator it = this.zzb.values().iterator();
        int i = this.zzc * 17;
        while (it.hasNext()) {
            i = (i * 31) + ((zzji) it.next()).hashCode();
        }
        return i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zzd(this.zzc));
        for (zzjk zzjkVar : zzjj.STORAGE.zzb()) {
            sb.append(",");
            sb.append(zzjkVar.zze);
            sb.append("=");
            zzji zzjiVar = (zzji) this.zzb.get(zzjkVar);
            if (zzjiVar == null) {
                zzjiVar = zzji.UNINITIALIZED;
            }
            sb.append(zzjiVar);
        }
        return sb.toString();
    }

    public final int zzb() {
        return this.zzc;
    }

    public final boolean zzc() {
        Iterator it = this.zzb.values().iterator();
        while (it.hasNext()) {
            if (((zzji) it.next()) != zzji.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final String zzk() {
        int ordinal;
        StringBuilder sb = new StringBuilder("G1");
        for (zzjk zzjkVar : zzjj.STORAGE.zza()) {
            zzji zzjiVar = (zzji) this.zzb.get(zzjkVar);
            char c = '-';
            if (zzjiVar != null && (ordinal = zzjiVar.ordinal()) != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        c = '0';
                    } else if (ordinal != 3) {
                    }
                }
                c = '1';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public final String zzl() {
        StringBuilder sb = new StringBuilder("G1");
        for (zzjk zzjkVar : zzjj.STORAGE.zza()) {
            sb.append(zzm((zzji) this.zzb.get(zzjkVar)));
        }
        return sb.toString();
    }

    public final Bundle zzn() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.zzb.entrySet()) {
            String zzi = zzi((zzji) entry.getValue());
            if (zzi != null) {
                bundle.putString(((zzjk) entry.getKey()).zze, zzi);
            }
        }
        return bundle;
    }

    public final boolean zzo(zzjk zzjkVar) {
        return ((zzji) this.zzb.get(zzjkVar)) != zzji.DENIED;
    }

    public final zzji zzp() {
        zzji zzjiVar = (zzji) this.zzb.get(zzjk.AD_STORAGE);
        return zzjiVar == null ? zzji.UNINITIALIZED : zzjiVar;
    }

    public final zzji zzq() {
        zzji zzjiVar = (zzji) this.zzb.get(zzjk.ANALYTICS_STORAGE);
        return zzjiVar == null ? zzji.UNINITIALIZED : zzjiVar;
    }

    public final boolean zzr(zzjl zzjlVar) {
        EnumMap enumMap = this.zzb;
        for (zzjk zzjkVar : (zzjk[]) enumMap.keySet().toArray(new zzjk[0])) {
            zzji zzjiVar = (zzji) enumMap.get(zzjkVar);
            zzji zzjiVar2 = (zzji) zzjlVar.zzb.get(zzjkVar);
            zzji zzjiVar3 = zzji.DENIED;
            if (zzjiVar == zzjiVar3 && zzjiVar2 != zzjiVar3) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzjl zzs(com.google.android.gms.measurement.internal.zzjl r9) {
        /*
            r8 = this;
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<com.google.android.gms.measurement.internal.zzjk> r1 = com.google.android.gms.measurement.internal.zzjk.class
            r0.<init>(r1)
            com.google.android.gms.measurement.internal.zzjj r1 = com.google.android.gms.measurement.internal.zzjj.STORAGE
            com.google.android.gms.measurement.internal.zzjk[] r1 = r1.zzb()
            int r2 = r1.length
            r3 = 0
        Lf:
            if (r3 >= r2) goto L4a
            r4 = r1[r3]
            java.util.EnumMap r5 = r8.zzb
            java.lang.Object r5 = r5.get(r4)
            com.google.android.gms.measurement.internal.zzji r5 = (com.google.android.gms.measurement.internal.zzji) r5
            java.util.EnumMap r6 = r9.zzb
            java.lang.Object r6 = r6.get(r4)
            com.google.android.gms.measurement.internal.zzji r6 = (com.google.android.gms.measurement.internal.zzji) r6
            if (r5 != 0) goto L26
            goto L33
        L26:
            if (r6 == 0) goto L42
            com.google.android.gms.measurement.internal.zzji r7 = com.google.android.gms.measurement.internal.zzji.UNINITIALIZED
            if (r5 != r7) goto L2d
            goto L33
        L2d:
            if (r6 == r7) goto L42
            com.google.android.gms.measurement.internal.zzji r7 = com.google.android.gms.measurement.internal.zzji.POLICY
            if (r5 != r7) goto L35
        L33:
            r5 = r6
            goto L42
        L35:
            if (r6 == r7) goto L42
            com.google.android.gms.measurement.internal.zzji r7 = com.google.android.gms.measurement.internal.zzji.DENIED
            if (r5 == r7) goto L41
            if (r6 != r7) goto L3e
            goto L41
        L3e:
            com.google.android.gms.measurement.internal.zzji r5 = com.google.android.gms.measurement.internal.zzji.GRANTED
            goto L42
        L41:
            r5 = r7
        L42:
            if (r5 == 0) goto L47
            r0.put(r4, r5)
        L47:
            int r3 = r3 + 1
            goto Lf
        L4a:
            com.google.android.gms.measurement.internal.zzjl r8 = new com.google.android.gms.measurement.internal.zzjl
            r9 = 100
            r8.<init>(r0, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjl.zzs(com.google.android.gms.measurement.internal.zzjl):com.google.android.gms.measurement.internal.zzjl");
    }

    public final zzjl zzt(zzjl zzjlVar) {
        EnumMap enumMap = new EnumMap(zzjk.class);
        for (zzjk zzjkVar : zzjj.STORAGE.zzb()) {
            zzji zzjiVar = (zzji) this.zzb.get(zzjkVar);
            if (zzjiVar == zzji.UNINITIALIZED) {
                zzjiVar = (zzji) zzjlVar.zzb.get(zzjkVar);
            }
            if (zzjiVar != null) {
                enumMap.put((EnumMap) zzjkVar, (zzjk) zzjiVar);
            }
        }
        return new zzjl(enumMap, this.zzc);
    }

    private zzjl(EnumMap enumMap, int i) {
        EnumMap enumMap2 = new EnumMap(zzjk.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzc = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzji zzj(char c) {
        if (c == '+') {
            return zzji.POLICY;
        }
        if (c == '0') {
            return zzji.DENIED;
        }
        if (c == '1') {
            return zzji.GRANTED;
        }
        return zzji.UNINITIALIZED;
    }
}
