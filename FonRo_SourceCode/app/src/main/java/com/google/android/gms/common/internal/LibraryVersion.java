package com.google.android.gms.common.internal;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-basement@@18.9.0 */
@Deprecated
/* loaded from: classes5.dex */
public class LibraryVersion {
    private static final GmsLogger zza = new GmsLogger("LibraryVersion", "");
    private static final LibraryVersion zzb = new LibraryVersion();
    private final ConcurrentHashMap zzc = new ConcurrentHashMap();

    protected LibraryVersion() {
    }

    public static LibraryVersion getInstance() {
        return zzb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b9  */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v9 */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getVersion(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = "LibraryVersion"
            java.lang.String r1 = "Please provide a valid libraryName"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10, r1)
            java.lang.String r1 = " version is "
            java.lang.String r2 = "Failed to get app version for libraryName: "
            java.util.concurrent.ConcurrentHashMap r3 = r9.zzc
            boolean r4 = r3.containsKey(r10)
            if (r4 == 0) goto L1a
            java.lang.Object r9 = r3.get(r10)
            java.lang.String r9 = (java.lang.String) r9
            return r9
        L1a:
            java.util.Properties r3 = new java.util.Properties
            r3.<init>()
            r4 = 0
            java.lang.String r5 = "/%s.properties"
            java.lang.Object[] r6 = new java.lang.Object[]{r10}     // Catch: java.lang.Throwable -> L8c java.io.IOException -> L8e
            java.lang.String r5 = java.lang.String.format(r5, r6)     // Catch: java.lang.Throwable -> L8c java.io.IOException -> L8e
            java.lang.Class<com.google.android.gms.common.internal.LibraryVersion> r6 = com.google.android.gms.common.internal.LibraryVersion.class
            java.io.InputStream r5 = r6.getResourceAsStream(r5)     // Catch: java.lang.Throwable -> L8c java.io.IOException -> L8e
            if (r5 == 0) goto L66
            r3.load(r5)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            java.lang.String r6 = "version"
            java.lang.String r4 = r3.getProperty(r6, r4)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            com.google.android.gms.common.internal.GmsLogger r3 = com.google.android.gms.common.internal.LibraryVersion.zza     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            java.lang.String r6 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            int r6 = r6.length()     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            int r6 = r6 + 12
            java.lang.String r7 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            int r7 = r7.length()     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            int r6 = r6 + r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            r7.append(r10)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            r7.append(r1)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            r7.append(r4)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            java.lang.String r1 = r7.toString()     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            r3.v(r0, r1)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            goto Lb2
        L66:
            com.google.android.gms.common.internal.GmsLogger r3 = com.google.android.gms.common.internal.LibraryVersion.zza     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            java.lang.String r1 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            int r1 = r1.length()     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            int r1 = r1 + 43
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            r6.append(r2)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            r6.append(r10)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            java.lang.String r1 = r6.toString()     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            r3.w(r0, r1)     // Catch: java.lang.Throwable -> L85 java.io.IOException -> L88
            goto Lb2
        L85:
            r9 = move-exception
            r4 = r5
            goto Lc6
        L88:
            r1 = move-exception
            r3 = r4
            r4 = r5
            goto L90
        L8c:
            r9 = move-exception
            goto Lc6
        L8e:
            r1 = move-exception
            r3 = r4
        L90:
            com.google.android.gms.common.internal.GmsLogger r5 = com.google.android.gms.common.internal.LibraryVersion.zza     // Catch: java.lang.Throwable -> L8c
            java.lang.String r6 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L8c
            int r6 = r6.length()     // Catch: java.lang.Throwable -> L8c
            int r6 = r6 + 43
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8c
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L8c
            r7.append(r2)     // Catch: java.lang.Throwable -> L8c
            r7.append(r10)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r2 = r7.toString()     // Catch: java.lang.Throwable -> L8c
            r5.e(r0, r2, r1)     // Catch: java.lang.Throwable -> L8c
            r8 = r4
            r4 = r3
            r3 = r5
            r5 = r8
        Lb2:
            if (r5 == 0) goto Lb7
            com.google.android.gms.common.util.IOUtils.closeQuietly(r5)
        Lb7:
            if (r4 != 0) goto Lc0
            java.lang.String r1 = ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used"
            r3.d(r0, r1)
            java.lang.String r4 = "UNKNOWN"
        Lc0:
            java.util.concurrent.ConcurrentHashMap r9 = r9.zzc
            r9.put(r10, r4)
            return r4
        Lc6:
            if (r4 == 0) goto Lcb
            com.google.android.gms.common.util.IOUtils.closeQuietly(r4)
        Lcb:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.LibraryVersion.getVersion(java.lang.String):java.lang.String");
    }
}
