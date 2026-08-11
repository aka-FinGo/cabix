package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public abstract class zzabp extends zzabn {
    private static final String zza;

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
    
        if (r0.matches("\\n|\\r(?:\\n)?") == false) goto L4;
     */
    static {
        /*
            java.lang.String r0 = "line.separator"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch: java.lang.SecurityException -> Le
            java.lang.String r1 = "\\n|\\r(?:\\n)?"
            boolean r1 = r0.matches(r1)     // Catch: java.lang.SecurityException -> Le
            if (r1 != 0) goto L10
        Le:
            java.lang.String r0 = "\n"
        L10:
            com.google.android.gms.internal.measurement.zzabp.zza = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzabp.<clinit>():void");
    }

    static int zze(String str, int i) throws zzabo {
        while (i < str.length()) {
            int i2 = i + 1;
            if (str.charAt(i) != '%') {
                i = i2;
            } else if (i2 < str.length()) {
                char charAt = str.charAt(i2);
                if (charAt != '%' && charAt != 'n') {
                    return i;
                }
                i += 2;
            } else {
                throw zzabo.zzc("trailing unquoted '%' character", str, i);
            }
        }
        return -1;
    }

    abstract int zzb(zzabm zzabmVar, int i, String str, int i2, int i3, int i4) throws zzabo;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ad, code lost:
    
        r0 = r14;
        r4 = zze(r3, r0.zzb(r15, r2, r3, r4, r5, r6));
        r14 = r0;
        r1 = r2;
        r0 = r9;
     */
    @Override // com.google.android.gms.internal.measurement.zzabn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzc(com.google.android.gms.internal.measurement.zzabm r15) throws com.google.android.gms.internal.measurement.zzabo {
        /*
            Method dump skipped, instructions count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzabp.zzc(com.google.android.gms.internal.measurement.zzabm):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzabn
    public final void zzd(StringBuilder sb, String str, int i, int i2) {
        int i3 = i;
        while (i < i2) {
            int i4 = i + 1;
            if (str.charAt(i) == '%') {
                if (i4 == i2) {
                    break;
                }
                char charAt = str.charAt(i4);
                if (charAt == '%') {
                    sb.append((CharSequence) str, i3, i4);
                } else if (charAt == 'n') {
                    sb.append((CharSequence) str, i3, i);
                    sb.append(zza);
                }
                i3 = i + 2;
                i = i3;
            }
            i = i4;
        }
        if (i3 < i2) {
            sb.append((CharSequence) str, i3, i2);
        }
    }
}
