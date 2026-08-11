package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes5.dex */
final class zzadk {
    private static final zzadk zzd = new zzadk(true);
    final zzafv zza = new zzafr();
    boolean zzb;
    boolean zzc;

    private zzadk() {
    }

    public static zzadk zza() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzf(zzada zzadaVar, zzagm zzagmVar, int i, Object obj) throws IOException {
        if (zzagmVar != zzagm.GROUP) {
            zzadaVar.zzb(i, zzagmVar.zzb());
            zzagn zzagnVar = zzagn.INT;
            switch (zzagmVar) {
                case DOUBLE:
                    zzadaVar.zzu(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                    return;
                case FLOAT:
                    zzadaVar.zzs(Float.floatToRawIntBits(((Float) obj).floatValue()));
                    return;
                case INT64:
                    zzadaVar.zzt(((Long) obj).longValue());
                    return;
                case UINT64:
                    zzadaVar.zzt(((Long) obj).longValue());
                    return;
                case INT32:
                    zzadaVar.zzq(((Integer) obj).intValue());
                    return;
                case FIXED64:
                    zzadaVar.zzu(((Long) obj).longValue());
                    return;
                case FIXED32:
                    zzadaVar.zzs(((Integer) obj).intValue());
                    return;
                case BOOL:
                    zzadaVar.zzp(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                    return;
                case STRING:
                    if (obj instanceof zzacr) {
                        zzadaVar.zzk((zzacr) obj);
                        return;
                    } else {
                        zzadaVar.zzw((String) obj);
                        return;
                    }
                case GROUP:
                    ((zzafc) obj).zzcH(zzadaVar);
                    return;
                case MESSAGE:
                    zzadaVar.zzo((zzafc) obj);
                    return;
                case BYTES:
                    if (obj instanceof zzacr) {
                        zzadaVar.zzk((zzacr) obj);
                        return;
                    } else {
                        byte[] bArr = (byte[]) obj;
                        zzadaVar.zzl(bArr, 0, bArr.length);
                        return;
                    }
                case UINT32:
                    zzadaVar.zzr(((Integer) obj).intValue());
                    return;
                case ENUM:
                    if (obj instanceof zzady) {
                        zzadaVar.zzq(((zzady) obj).zza());
                        return;
                    } else {
                        zzadaVar.zzq(((Integer) obj).intValue());
                        return;
                    }
                case SFIXED32:
                    zzadaVar.zzs(((Integer) obj).intValue());
                    return;
                case SFIXED64:
                    zzadaVar.zzu(((Long) obj).longValue());
                    return;
                case SINT32:
                    int intValue = ((Integer) obj).intValue();
                    zzadaVar.zzr((intValue >> 31) ^ (intValue + intValue));
                    return;
                case SINT64:
                    long longValue = ((Long) obj).longValue();
                    zzadaVar.zzt((longValue >> 63) ^ (longValue + longValue));
                    return;
                default:
                    return;
            }
        }
        zzadaVar.zzb(i, 3);
        ((zzafc) obj).zzcH(zzadaVar);
        zzadaVar.zzb(i, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(zzagm zzagmVar, int i, Object obj) {
        int zzE = zzada.zzE(i << 3);
        if (zzagmVar == zzagm.GROUP) {
            zzE += zzE;
        }
        return zzE + zzi(zzagmVar, obj);
    }

    static int zzi(zzagm zzagmVar, Object obj) {
        int zzb;
        int zzE;
        zzagm zzagmVar2 = zzagm.DOUBLE;
        zzagn zzagnVar = zzagn.INT;
        switch (zzagmVar) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                int i = zzada.zzb;
                return 8;
            case FLOAT:
                ((Float) obj).floatValue();
                int i2 = zzada.zzb;
                return 4;
            case INT64:
                return zzada.zzF(((Long) obj).longValue());
            case UINT64:
                return zzada.zzF(((Long) obj).longValue());
            case INT32:
                return zzada.zzF(((Integer) obj).intValue());
            case FIXED64:
                ((Long) obj).longValue();
                int i3 = zzada.zzb;
                return 8;
            case FIXED32:
                ((Integer) obj).intValue();
                int i4 = zzada.zzb;
                return 4;
            case BOOL:
                ((Boolean) obj).booleanValue();
                int i5 = zzada.zzb;
                return 1;
            case STRING:
                if (obj instanceof zzacr) {
                    int i6 = zzada.zzb;
                    zzb = ((zzacr) obj).zzb();
                    zzE = zzada.zzE(zzb);
                    break;
                } else {
                    int i7 = zzada.zzb;
                    zzb = zzagl.zzb((String) obj);
                    zzE = zzada.zzE(zzb);
                    break;
                }
            case GROUP:
                return ((zzafc) obj).zzcq();
            case MESSAGE:
                if (obj instanceof zzael) {
                    zzb = ((zzael) obj).zzb();
                    zzE = zzada.zzE(zzb);
                    break;
                } else {
                    return zzada.zzG((zzafc) obj);
                }
            case BYTES:
                if (obj instanceof zzacr) {
                    int i8 = zzada.zzb;
                    zzb = ((zzacr) obj).zzb();
                    zzE = zzada.zzE(zzb);
                    break;
                } else {
                    int i9 = zzada.zzb;
                    zzb = ((byte[]) obj).length;
                    zzE = zzada.zzE(zzb);
                    break;
                }
            case UINT32:
                return zzada.zzE(((Integer) obj).intValue());
            case ENUM:
                if (obj instanceof zzady) {
                    return zzada.zzF(((zzady) obj).zza());
                }
                return zzada.zzF(((Integer) obj).intValue());
            case SFIXED32:
                ((Integer) obj).intValue();
                int i10 = zzada.zzb;
                return 4;
            case SFIXED64:
                ((Long) obj).longValue();
                int i11 = zzada.zzb;
                return 8;
            case SINT32:
                int intValue = ((Integer) obj).intValue();
                return zzada.zzE((intValue >> 31) ^ (intValue + intValue));
            case SINT64:
                long longValue = ((Long) obj).longValue();
                return zzada.zzF((longValue >> 63) ^ (longValue + longValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return zzE + zzb;
    }

    public static int zzj(zzadj zzadjVar, Object obj) {
        zzagm zzb = zzadjVar.zzb();
        int zza = zzadjVar.zza();
        if (zzadjVar.zzd()) {
            List list = (List) obj;
            int size = list.size();
            int i = 0;
            if (!zzadjVar.zze()) {
                int i2 = 0;
                while (i < size) {
                    i2 += zzh(zzb, zza, list.get(i));
                    i++;
                }
                return i2;
            }
            if (list.isEmpty()) {
                return 0;
            }
            int i3 = 0;
            while (i < size) {
                i3 += zzi(zzb, list.get(i));
                i++;
            }
            return zzada.zzE(zza << 3) + i3 + zzada.zzE(i3);
        }
        return zzh(zzb, zza, obj);
    }

    private static boolean zzk(Map.Entry entry) {
        zzadj zzadjVar = (zzadj) entry.getKey();
        if (zzadjVar.zzc() != zzagn.MESSAGE) {
            return true;
        }
        if (zzadjVar.zzd()) {
            List list = (List) entry.getValue();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (!zzl(list.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return zzl(entry.getValue());
    }

    private static boolean zzl(Object obj) {
        if (obj instanceof zzafd) {
            return ((zzafd) obj).zzcJ();
        }
        if (obj instanceof zzael) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzm(Map.Entry entry) {
        int i;
        int zzE;
        int zzE2;
        zzadj zzadjVar = (zzadj) entry.getKey();
        Object value = entry.getValue();
        if (zzadjVar.zzc() != zzagn.MESSAGE || zzadjVar.zzd() || zzadjVar.zze()) {
            return zzj(zzadjVar, value);
        }
        if (value instanceof zzael) {
            int zza = ((zzadj) entry.getKey()).zza();
            int zzE3 = zzada.zzE(8);
            i = zzE3 + zzE3;
            zzE = zzada.zzE(16) + zzada.zzE(zza);
            int zzE4 = zzada.zzE(24);
            int zzb = ((zzael) value).zzb();
            zzE2 = zzE4 + zzada.zzE(zzb) + zzb;
        } else {
            int zza2 = ((zzadj) entry.getKey()).zza();
            int zzE5 = zzada.zzE(8);
            i = zzE5 + zzE5;
            zzE = zzada.zzE(16) + zzada.zzE(zza2);
            zzE2 = zzada.zzE(24) + zzada.zzG((zzafc) value);
        }
        return i + zzE + zzE2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0013. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void zzn(com.google.android.gms.internal.measurement.zzadj r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.zzagm r0 = r2.zzb()
            r3.getClass()
            com.google.android.gms.internal.measurement.zzagm r1 = com.google.android.gms.internal.measurement.zzagm.DOUBLE
            com.google.android.gms.internal.measurement.zzagn r1 = com.google.android.gms.internal.measurement.zzagn.INT
            com.google.android.gms.internal.measurement.zzagn r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L41;
                case 1: goto L3e;
                case 2: goto L3b;
                case 3: goto L38;
                case 4: goto L35;
                case 5: goto L32;
                case 6: goto L29;
                case 7: goto L20;
                case 8: goto L17;
                default: goto L16;
            }
        L16:
            goto L46
        L17:
            boolean r0 = r3 instanceof com.google.android.gms.internal.measurement.zzafc
            if (r0 != 0) goto L45
            boolean r0 = r3 instanceof com.google.android.gms.internal.measurement.zzael
            if (r0 == 0) goto L46
            goto L45
        L20:
            boolean r0 = r3 instanceof java.lang.Integer
            if (r0 != 0) goto L45
            boolean r0 = r3 instanceof com.google.android.gms.internal.measurement.zzady
            if (r0 == 0) goto L46
            goto L45
        L29:
            boolean r0 = r3 instanceof com.google.android.gms.internal.measurement.zzacr
            if (r0 != 0) goto L45
            boolean r0 = r3 instanceof byte[]
            if (r0 == 0) goto L46
            goto L45
        L32:
            boolean r0 = r3 instanceof java.lang.String
            goto L43
        L35:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L43
        L38:
            boolean r0 = r3 instanceof java.lang.Double
            goto L43
        L3b:
            boolean r0 = r3 instanceof java.lang.Float
            goto L43
        L3e:
            boolean r0 = r3 instanceof java.lang.Long
            goto L43
        L41:
            boolean r0 = r3 instanceof java.lang.Integer
        L43:
            if (r0 == 0) goto L46
        L45:
            return
        L46:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r2.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.measurement.zzagm r2 = r2.zzb()
            com.google.android.gms.internal.measurement.zzagn r2 = r2.zza()
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getName()
            java.lang.Object[] r2 = new java.lang.Object[]{r1, r2, r3}
            java.lang.String r3 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzadk.zzn(com.google.android.gms.internal.measurement.zzadj, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzadk zzadkVar = new zzadk();
        zzafv zzafvVar = this.zza;
        int zzc = zzafvVar.zzc();
        for (int i = 0; i < zzc; i++) {
            Map.Entry zzd2 = zzafvVar.zzd(i);
            zzadkVar.zzd((zzadj) ((zzafs) zzd2).zza(), zzd2.getValue());
        }
        for (Map.Entry entry : zzafvVar.zze()) {
            zzadkVar.zzd((zzadj) entry.getKey(), entry.getValue());
        }
        zzadkVar.zzc = this.zzc;
        return zzadkVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzadk) {
            return this.zza.equals(((zzadk) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        zzafv zzafvVar = this.zza;
        int zzc = zzafvVar.zzc();
        for (int i = 0; i < zzc; i++) {
            Object value = zzafvVar.zzd(i).getValue();
            if (value instanceof zzadu) {
                ((zzadu) value).zzcm();
            }
        }
        Iterator it = zzafvVar.zze().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzadu) {
                ((zzadu) value2).zzcm();
            }
        }
        zzafvVar.zza();
        this.zzb = true;
    }

    public final Iterator zzc() {
        zzafv zzafvVar = this.zza;
        if (zzafvVar.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzc) {
            return new zzaek(zzafvVar.entrySet().iterator());
        }
        return zzafvVar.entrySet().iterator();
    }

    public final void zzd(zzadj zzadjVar, Object obj) {
        if (zzadjVar.zzd()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzn(zzadjVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        } else {
            zzn(zzadjVar, obj);
        }
        if (obj instanceof zzael) {
            this.zzc = true;
        }
        this.zza.put(zzadjVar, obj);
    }

    public final boolean zze() {
        zzafv zzafvVar = this.zza;
        int zzc = zzafvVar.zzc();
        for (int i = 0; i < zzc; i++) {
            if (!zzk(zzafvVar.zzd(i))) {
                return false;
            }
        }
        Iterator it = zzafvVar.zze().iterator();
        while (it.hasNext()) {
            if (!zzk((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int zzg() {
        zzafv zzafvVar = this.zza;
        int zzc = zzafvVar.zzc();
        int i = 0;
        for (int i2 = 0; i2 < zzc; i2++) {
            i += zzm(zzafvVar.zzd(i2));
        }
        Iterator it = zzafvVar.zze().iterator();
        while (it.hasNext()) {
            i += zzm((Map.Entry) it.next());
        }
        return i;
    }

    private zzadk(boolean z) {
        zzb();
        zzb();
    }
}
