package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* loaded from: classes5.dex */
final class zzgq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzdf zzdfVar) {
        StringBuilder sb = new StringBuilder(zzdfVar.zzd());
        for (int i = 0; i < zzdfVar.zzd(); i++) {
            byte zza = zzdfVar.zza(i);
            if (zza != 34) {
                if (zza != 39) {
                    if (zza == 92) {
                        sb.append("\\\\");
                    } else {
                        switch (zza) {
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
                                if (zza < 32 || zza > 126) {
                                    sb.append(AbstractJsonLexerKt.STRING_ESC);
                                    sb.append((char) (((zza >>> 6) & 3) + 48));
                                    sb.append((char) (((zza >>> 3) & 7) + 48));
                                    sb.append((char) ((zza & 7) + 48));
                                    break;
                                } else {
                                    sb.append((char) zza);
                                    break;
                                }
                                break;
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
