package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* loaded from: classes5.dex */
final class zzgg {
    public static final /* synthetic */ int zza = 0;
    private static final zzgs zzb;

    static {
        int i = zzfu.zza;
        zzb = new zzgu();
    }

    public static void zzA(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzC(i, list, z);
    }

    public static void zzB(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzE(i, list, z);
    }

    public static void zzC(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzJ(i, list, z);
    }

    public static void zzD(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzL(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzE(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzei)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzdn.zzB(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        zzei zzeiVar = (zzei) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzdn.zzB(zzeiVar.zze(i));
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzdn.zzA(i << 3) + 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(List list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzdn.zzA(i << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzei)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzdn.zzB(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        zzei zzeiVar = (zzei) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzdn.zzB(zzeiVar.zze(i));
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfb)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzdn.zzB(((Long) list.get(i)).longValue());
                i++;
            }
            return i2;
        }
        zzfb zzfbVar = (zzfb) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzdn.zzB(zzfbVar.zze(i));
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i, Object obj, zzge zzgeVar) {
        int i2 = i << 3;
        if (obj instanceof zzex) {
            int zzA = zzdn.zzA(i2);
            int zza2 = ((zzex) obj).zza();
            return zzA + zzdn.zzA(zza2) + zza2;
        }
        return zzdn.zzA(i2) + zzdn.zzy((zzfm) obj, zzgeVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzei)) {
            int i2 = 0;
            while (i < size) {
                int intValue = ((Integer) list.get(i)).intValue();
                i2 += zzdn.zzA((intValue >> 31) ^ (intValue + intValue));
                i++;
            }
            return i2;
        }
        zzei zzeiVar = (zzei) list;
        int i3 = 0;
        while (i < size) {
            int zze = zzeiVar.zze(i);
            i3 += zzdn.zzA((zze >> 31) ^ (zze + zze));
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfb)) {
            int i2 = 0;
            while (i < size) {
                long longValue = ((Long) list.get(i)).longValue();
                i2 += zzdn.zzB((longValue >> 63) ^ (longValue + longValue));
                i++;
            }
            return i2;
        }
        zzfb zzfbVar = (zzfb) list;
        int i3 = 0;
        while (i < size) {
            long zze = zzfbVar.zze(i);
            i3 += zzdn.zzB((zze >> 63) ^ (zze + zze));
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzei)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzdn.zzA(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        zzei zzeiVar = (zzei) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzdn.zzA(zzeiVar.zze(i));
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfb)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzdn.zzB(((Long) list.get(i)).longValue());
                i++;
            }
            return i2;
        }
        zzfb zzfbVar = (zzfb) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzdn.zzB(zzfbVar.zze(i));
            i++;
        }
        return i3;
    }

    public static zzgs zzm() {
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r5 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object zzn(java.lang.Object r2, int r3, int r4, java.lang.Object r5, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgs r6) {
        /*
            if (r5 != 0) goto L12
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh r2 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh) r2
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt r5 = r2.zzc
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt r6 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt.zzc()
            if (r5 != r6) goto L12
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt r5 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt.zzf()
            r2.zzc = r5
        L12:
            long r0 = (long) r4
            int r2 = r3 << 3
            r3 = r5
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt r3 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt) r3
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
            r3.zzj(r2, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgg.zzn(java.lang.Object, int, int, java.lang.Object, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgs):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzo(zzdt zzdtVar, Object obj, Object obj2) {
        zzdx zzdxVar = ((zzed) obj2).zzb;
        if (zzdxVar.zza.isEmpty()) {
            return;
        }
        ((zzed) obj).zzc().zzh(zzdxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzp(zzgs zzgsVar, Object obj, Object obj2) {
        zzeh zzehVar = (zzeh) obj;
        zzgt zzgtVar = zzehVar.zzc;
        zzgt zzgtVar2 = ((zzeh) obj2).zzc;
        if (!zzgt.zzc().equals(zzgtVar2)) {
            if (zzgt.zzc().equals(zzgtVar)) {
                zzgtVar = zzgt.zze(zzgtVar, zzgtVar2);
            } else {
                zzgtVar.zzd(zzgtVar2);
            }
        }
        zzehVar.zzc = zzgtVar;
    }

    public static void zzq(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzc(i, list, z);
    }

    public static void zzr(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzg(i, list, z);
    }

    public static void zzs(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzj(i, list, z);
    }

    public static void zzt(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzl(i, list, z);
    }

    public static void zzu(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzn(i, list, z);
    }

    public static void zzv(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzp(i, list, z);
    }

    public static void zzw(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzs(i, list, z);
    }

    public static void zzx(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzu(i, list, z);
    }

    public static void zzy(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzy(i, list, z);
    }

    public static void zzz(int i, List list, zzhh zzhhVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhhVar.zzA(i, list, z);
    }
}
