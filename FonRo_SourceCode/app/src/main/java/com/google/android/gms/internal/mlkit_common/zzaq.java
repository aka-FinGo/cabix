package com.google.android.gms.internal.mlkit_common;

import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:common@@18.11.0 */
/* loaded from: classes5.dex */
public final class zzaq extends zzai {
    static final zzai zza = new zzaq(null, new Object[0], 0);
    final transient Object[] zzb;

    @CheckForNull
    private final transient Object zzc;
    private final transient int zzd;

    private zzaq(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01de  */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.mlkit_common.zzaq zzg(int r19, java.lang.Object[] r20, com.google.android.gms.internal.mlkit_common.zzah r21) {
        /*
            Method dump skipped, instructions count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaq.zzg(int, java.lang.Object[], com.google.android.gms.internal.mlkit_common.zzah):com.google.android.gms.internal.mlkit_common.zzaq");
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x00a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00a1 A[RETURN] */
    @Override // com.google.android.gms.internal.mlkit_common.zzai, java.util.Map
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L6
        L3:
            r8 = r0
            goto L9e
        L6:
            int r1 = r8.zzd
            java.lang.Object[] r2 = r8.zzb
            r3 = 1
            if (r1 != r3) goto L22
            r8 = 0
            r8 = r2[r8]
            java.lang.Object r8 = java.util.Objects.requireNonNull(r8)
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L3
            r8 = r2[r3]
            java.lang.Object r8 = java.util.Objects.requireNonNull(r8)
            goto L9e
        L22:
            java.lang.Object r8 = r8.zzc
            if (r8 != 0) goto L27
            goto L3
        L27:
            boolean r1 = r8 instanceof byte[]
            r4 = -1
            if (r1 == 0) goto L53
            r1 = r8
            byte[] r1 = (byte[]) r1
            int r8 = r1.length
            int r5 = r8 + (-1)
            int r8 = r9.hashCode()
            int r8 = com.google.android.gms.internal.mlkit_common.zzy.zza(r8)
        L3a:
            r8 = r8 & r5
            r4 = r1[r8]
            r6 = 255(0xff, float:3.57E-43)
            r4 = r4 & r6
            if (r4 != r6) goto L43
            goto L3
        L43:
            r6 = r2[r4]
            boolean r6 = r9.equals(r6)
            if (r6 == 0) goto L50
            r8 = r4 ^ 1
            r8 = r2[r8]
            goto L9e
        L50:
            int r8 = r8 + 1
            goto L3a
        L53:
            boolean r1 = r8 instanceof short[]
            if (r1 == 0) goto L7f
            r1 = r8
            short[] r1 = (short[]) r1
            int r8 = r1.length
            int r5 = r8 + (-1)
            int r8 = r9.hashCode()
            int r8 = com.google.android.gms.internal.mlkit_common.zzy.zza(r8)
        L65:
            r8 = r8 & r5
            short r4 = r1[r8]
            char r4 = (char) r4
            r6 = 65535(0xffff, float:9.1834E-41)
            if (r4 != r6) goto L6f
            goto L3
        L6f:
            r6 = r2[r4]
            boolean r6 = r9.equals(r6)
            if (r6 == 0) goto L7c
            r8 = r4 ^ 1
            r8 = r2[r8]
            goto L9e
        L7c:
            int r8 = r8 + 1
            goto L65
        L7f:
            int[] r8 = (int[]) r8
            int r1 = r8.length
            int r1 = r1 + r4
            int r5 = r9.hashCode()
            int r5 = com.google.android.gms.internal.mlkit_common.zzy.zza(r5)
        L8b:
            r5 = r5 & r1
            r6 = r8[r5]
            if (r6 != r4) goto L92
            goto L3
        L92:
            r7 = r2[r6]
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto La2
            r8 = r6 ^ 1
            r8 = r2[r8]
        L9e:
            if (r8 != 0) goto La1
            return r0
        La1:
            return r8
        La2:
            int r5 = r5 + 1
            goto L8b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaq.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzai
    final zzab zza() {
        return new zzap(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzai
    final zzaj zzd() {
        return new zzan(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzai
    final zzaj zze() {
        return new zzao(this, new zzap(this.zzb, 0, this.zzd));
    }
}
