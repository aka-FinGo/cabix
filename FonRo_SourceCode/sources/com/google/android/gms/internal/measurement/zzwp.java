package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
final class zzwp {
    private final int[] zza;
    private final zzwn zzb;
    private zzwn zzc;
    private int zzd;
    private int zze;
    private int zzf;

    private zzwp(int[] iArr) {
        this.zza = iArr;
        zzwn zzwnVar = new zzwn(-1, -1, null);
        this.zzb = zzwnVar;
        this.zzc = zzwnVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0021, code lost:
    
        r6 = r7.zzd;
        r7 = java.lang.Integer.valueOf(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x002b, code lost:
    
        if (r6.containsKey(r7) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x002d, code lost:
    
        r0.zzc.zzd.put(r7, new com.google.android.gms.internal.measurement.zzwn(r1, 1073741824, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0039, code lost:
    
        if (r5 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003b, code lost:
    
        r5.zzc = r0.zzc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0049, code lost:
    
        if (r5 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004b, code lost:
    
        r5.zzc = r0.zzc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x004f, code lost:
    
        r0.zzd = r1;
        r0.zze++;
        r0.zzb();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.measurement.zzwp zza(int[] r12) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzwp.zza(int[]):com.google.android.gms.internal.measurement.zzwp");
    }

    private final void zze(zzwn zzwnVar, StringBuilder sb) {
        for (zzwn zzwnVar2 : zzwnVar.zzd.values()) {
            sb.append("  ");
            sb.append(zzwnVar);
            sb.append(" -> ");
            sb.append(zzwnVar2);
            sb.append(" [label=\"");
            int[] iArr = this.zza;
            sb.append(Arrays.toString(Arrays.copyOfRange(iArr, zzwnVar2.zza, Math.min(iArr.length, zzwnVar2.zzb + 1))));
            sb.append("\"]\n");
            zze(zzwnVar2, sb);
        }
    }

    private final boolean zzf(int i, int i2, int i3, int i4) {
        if (i >= 0 && i3 >= 0) {
            int[] iArr = this.zza;
            int length = iArr.length;
            int min = Math.min(length, i2);
            if (min - i == Math.min(length, i4) - i3) {
                for (int i5 = i; i5 <= min; i5++) {
                    if (iArr[i5] != iArr[(i3 + i5) - i]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("digraph {\n");
        zze(this.zzb, sb);
        sb.append("}");
        return sb.toString();
    }

    final void zzb() {
        if (this.zze == 0) {
            return;
        }
        Map map = this.zzc.zzd;
        int[] iArr = this.zza;
        zzwn zzwnVar = (zzwn) map.get(Integer.valueOf(iArr[this.zzd]));
        while (true) {
            int i = (zzwnVar.zzb - zzwnVar.zza) + 1;
            int i2 = this.zze;
            if (i > i2) {
                return;
            }
            int i3 = this.zzd + i;
            this.zzd = i3;
            this.zzc = zzwnVar;
            int i4 = i2 - i;
            this.zze = i4;
            if (i4 > 0) {
                zzwnVar = (zzwn) zzwnVar.zzd.get(Integer.valueOf(iArr[i3]));
            }
        }
    }

    final void zzc() {
        zzwn zzwnVar = this.zzc.zzc;
        if (zzwnVar != null) {
            this.zzc = zzwnVar;
        } else {
            this.zzc = this.zzb;
            int i = this.zze;
            if (i > 0) {
                this.zze = i - 1;
            }
            if (this.zzf > 0) {
                this.zzd++;
            }
        }
        zzb();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0058, code lost:
    
        if (zzf(r9, r10, r5, (r5 + r10) - r9) != false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0077 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.measurement.zzwo zzd() {
        /*
            r12 = this;
            java.util.ArrayDeque r0 = new java.util.ArrayDeque
            r0.<init>()
            com.google.android.gms.internal.measurement.zzwm r1 = new com.google.android.gms.internal.measurement.zzwm
            com.google.android.gms.internal.measurement.zzwn r2 = r12.zzb
            r5 = -1
            r6 = 0
            r3 = 0
            r4 = -1
            r1.<init>(r2, r3, r4, r5, r6)
            r0.push(r1)
        L13:
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L7b
            java.lang.Object r3 = r0.pop()
            com.google.android.gms.internal.measurement.zzwm r3 = (com.google.android.gms.internal.measurement.zzwm) r3
            com.google.android.gms.internal.measurement.zzwn r4 = r3.zzd
            java.util.Map r4 = r4.zzd
            java.util.Collection r4 = r4.values()
            java.util.Iterator r4 = r4.iterator()
        L2b:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L13
            java.lang.Object r5 = r4.next()
            r7 = r5
            com.google.android.gms.internal.measurement.zzwn r7 = (com.google.android.gms.internal.measurement.zzwn) r7
            int r9 = r3.zzb
            int r10 = r3.zzc
            int r5 = r7.zza
            r6 = r10
            int r10 = r7.zzb
            boolean r5 = r12.zzf(r9, r6, r5, r10)
            if (r5 != 0) goto L65
            java.util.Map r5 = r7.zzd
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L5b
            int r5 = r7.zza
            int r8 = r5 + r6
            int r8 = r8 - r9
            boolean r5 = r12.zzf(r9, r6, r5, r8)
            if (r5 == 0) goto L5b
            goto L65
        L5b:
            com.google.android.gms.internal.measurement.zzwm r6 = new com.google.android.gms.internal.measurement.zzwm
            int r9 = r7.zza
            r11 = 0
            r8 = 1
            r6.<init>(r7, r8, r9, r10, r11)
            goto L70
        L65:
            r10 = r6
            com.google.android.gms.internal.measurement.zzwm r6 = new com.google.android.gms.internal.measurement.zzwm
            int r5 = r3.zza
            int r8 = r5 + 1
            r11 = 0
            r6.<init>(r7, r8, r9, r10, r11)
        L70:
            int r5 = r1.zza
            int r7 = r6.zza
            if (r5 >= r7) goto L77
            r1 = r6
        L77:
            r0.push(r6)
            goto L2b
        L7b:
            int[] r12 = r12.zza
            int r0 = r1.zzc
            int r0 = r0 + 1
            int r3 = r12.length
            int r0 = java.lang.Math.min(r3, r0)
            r3 = 0
        L87:
            int r4 = r1.zzb
            int r5 = r0 - r4
            int r6 = r3 % r5
            int r6 = r6 + r4
            r6 = r12[r6]
            java.util.Map r2 = r2.zzd
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r2 = r2.get(r6)
            com.google.android.gms.internal.measurement.zzwn r2 = (com.google.android.gms.internal.measurement.zzwn) r2
            if (r2 != 0) goto L9f
            goto Lb8
        L9f:
            int r6 = r2.zza
        La1:
            int r7 = r2.zzb
            int r7 = r7 + 1
            if (r6 >= r7) goto L87
            int r7 = r12.length
            if (r6 >= r7) goto L87
            int r7 = r3 % r5
            int r7 = r7 + r4
            r7 = r12[r7]
            r8 = r12[r6]
            if (r7 != r8) goto Lb8
            int r3 = r3 + 1
            int r6 = r6 + 1
            goto La1
        Lb8:
            com.google.android.gms.internal.measurement.zzwo r12 = new com.google.android.gms.internal.measurement.zzwo
            int r3 = r3 / r5
            r12.<init>(r4, r0, r3)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzwp.zzd():com.google.android.gms.internal.measurement.zzwo");
    }
}
