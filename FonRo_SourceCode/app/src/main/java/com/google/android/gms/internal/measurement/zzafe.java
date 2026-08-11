package com.google.android.gms.internal.measurement;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzafe {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzafc zzafcVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzc(zzafcVar, sb, 0);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(StringBuilder sb, int i, String str, Object obj) {
        String replace;
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zzd(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (Character.isUpperCase(charAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(charAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            String str2 = (String) obj;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i3 = 0; i3 < str2.length(); i3++) {
                char charAt2 = str2.charAt(i3);
                if (charAt2 < ' ' || charAt2 > '~') {
                    replace = zzafx.zza(str2.getBytes(StandardCharsets.UTF_8));
                    break;
                }
                if (charAt2 == '\"') {
                    z3 = true;
                } else if (charAt2 == '\'') {
                    z2 = true;
                } else if (charAt2 == '\\') {
                    z = true;
                }
            }
            if (z) {
                str2 = str2.replace("\\", "\\\\");
            }
            replace = z2 ? str2.replace("'", "\\'") : str2;
            if (z3) {
                replace = replace.replace("\"", "\\\"");
            }
            sb.append(replace);
            sb.append('\"');
            return;
        }
        if (obj instanceof zzacr) {
            sb.append(": \"");
            sb.append(zzafx.zza(((zzacr) obj).zzm()));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzadu) {
            sb.append(" {");
            zzc((zzadu) obj, sb, i + 2);
            sb.append("\n");
            zzd(i, sb);
            sb.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            int i4 = i + 2;
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            zzb(sb, i4, "key", entry.getKey());
            zzb(sb, i4, "value", entry.getValue());
            sb.append("\n");
            zzd(i, sb);
            sb.append("}");
            return;
        }
        sb.append(": ");
        sb.append(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x018f, code lost:
    
        if (((java.lang.Boolean) r7).booleanValue() == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0191, code lost:
    
        r13 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x019f, code lost:
    
        if (((java.lang.Integer) r7).intValue() == 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01b1, code lost:
    
        if (java.lang.Float.floatToRawIntBits(((java.lang.Float) r7).floatValue()) == 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01c7, code lost:
    
        if (java.lang.Double.doubleToRawLongBits(((java.lang.Double) r7).doubleValue()) == 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01df, code lost:
    
        if (r13 != false) goto L65;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zzc(com.google.android.gms.internal.measurement.zzafc r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instructions count: 576
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzafe.zzc(com.google.android.gms.internal.measurement.zzafc, java.lang.StringBuilder, int):void");
    }

    private static void zzd(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zza, 0, i2);
            i -= i2;
        }
    }
}
