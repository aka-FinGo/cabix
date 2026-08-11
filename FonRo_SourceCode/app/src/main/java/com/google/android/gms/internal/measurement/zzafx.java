package com.google.android.gms.internal.measurement;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes5.dex */
final class zzafx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length);
        for (byte b : bArr) {
            if (b != 34) {
                if (b != 39) {
                    if (b == 92) {
                        sb.append("\\\\");
                    } else {
                        switch (b) {
                            case 7:
                                sb.append("\\a");
                                break;
                            case 8:
                                sb.append("\\b");
                                break;
                            case 9:
                                sb.append("\\t");
                                break;
                            case 10:
                                sb.append("\\n");
                                break;
                            case 11:
                                sb.append("\\v");
                                break;
                            case 12:
                                sb.append("\\f");
                                break;
                            case 13:
                                sb.append("\\r");
                                break;
                            default:
                                if (b < 32 || b > 126) {
                                    sb.append(AbstractJsonLexerKt.STRING_ESC);
                                    sb.append((char) (((b >>> 6) & 3) + 48));
                                    sb.append((char) (((b >>> 3) & 7) + 48));
                                    sb.append((char) ((b & 7) + 48));
                                    break;
                                } else {
                                    sb.append((char) b);
                                    break;
                                }
                        }
                    }
                } else {
                    sb.append("\\'");
                }
            } else {
                sb.append("\\\"");
            }
        }
        return sb.toString();
    }
}
