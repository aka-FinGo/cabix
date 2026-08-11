package com.google.android.gms.internal.measurement;

import android.net.Uri;
import android.system.Os;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes5.dex */
public final class zzux {
    public static IOException zza(zzru zzruVar, Uri uri, IOException iOException, String str) {
        try {
            zzsr zzb = zzsr.zzb();
            zzb.zzc();
            File file = (File) zzruVar.zza(uri, zzb);
            if (file.exists()) {
                if (file.isFile()) {
                    if (file.canRead()) {
                        if (file.canWrite()) {
                            return zzb(file, iOException, str);
                        }
                        return zzb(file, iOException, str);
                    }
                    if (file.canWrite()) {
                        return zzb(file, iOException, str);
                    }
                    return zzb(file, iOException, str);
                }
                if (file.canRead()) {
                    if (file.canWrite()) {
                        return zzb(file, iOException, str);
                    }
                    return zzb(file, iOException, str);
                }
                if (file.canWrite()) {
                    return zzb(file, iOException, str);
                }
                return zzb(file, iOException, str);
            }
            return zzb(file, iOException, str);
        } catch (IOException unused) {
            return new IOException(iOException);
        }
    }

    private static IOException zzb(File file, IOException iOException, String str) {
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return zzc(file, iOException, str);
        }
        if (parentFile.exists()) {
            if (parentFile.isDirectory()) {
                if (parentFile.canRead()) {
                    if (parentFile.canWrite()) {
                        return zzc(file, iOException, str);
                    }
                    return zzc(file, iOException, str);
                }
                if (parentFile.canWrite()) {
                    return zzc(file, iOException, str);
                }
                return zzc(file, iOException, str);
            }
            if (parentFile.canRead()) {
                if (parentFile.canWrite()) {
                    return zzc(file, iOException, str);
                }
                return zzc(file, iOException, str);
            }
            if (parentFile.canWrite()) {
                return zzc(file, iOException, str);
            }
            return zzc(file, iOException, str);
        }
        return zzc(file, iOException, str);
    }

    private static IOException zzc(File file, IOException iOException, String str) {
        String concat;
        try {
            String format = String.format(Locale.US, " canonical[%s] freeSpace[%d] protoName[%s]", file.getCanonicalPath(), Long.valueOf(file.getFreeSpace()), str);
            StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 16);
            sb.append("Inoperable file:");
            sb.append(format);
            concat = sb.toString();
            try {
                String format2 = String.format(Locale.US, " mode[%d]", Integer.valueOf(Os.stat(file.getCanonicalPath()).st_mode));
                StringBuilder sb2 = new StringBuilder(concat.length() + String.valueOf(format2).length());
                sb2.append(concat);
                sb2.append(format2);
                concat = sb2.toString();
            } catch (Exception unused) {
            }
        } catch (IOException unused2) {
            concat = "Inoperable file:".concat(" failed");
        }
        return new IOException(concat, iOException);
    }
}
