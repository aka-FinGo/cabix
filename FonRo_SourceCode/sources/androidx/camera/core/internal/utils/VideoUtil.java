package androidx.camera.core.internal.utils;

/* loaded from: classes.dex */
public final class VideoUtil {
    private static final String TAG = "VideoUtil";

    private VideoUtil() {
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getAbsolutePathFromUri(android.content.ContentResolver r8, android.net.Uri r9) {
        /*
            java.lang.String r0 = "_data"
            r1 = 0
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch: java.lang.RuntimeException -> L31 java.lang.Throwable -> L53
            r6 = 0
            r7 = 0
            r5 = 0
            r2 = r8
            r3 = r9
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.RuntimeException -> L2f java.lang.Throwable -> L53
            java.lang.Object r8 = androidx.core.util.Preconditions.checkNotNull(r1)     // Catch: java.lang.RuntimeException -> L2f java.lang.Throwable -> L53
            android.database.Cursor r8 = (android.database.Cursor) r8     // Catch: java.lang.RuntimeException -> L2f java.lang.Throwable -> L53
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2b
            r8.moveToFirst()     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2b
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2b
            if (r8 == 0) goto L26
            r8.close()
        L26:
            return r9
        L27:
            r0 = move-exception
            r9 = r0
            r1 = r8
            goto L55
        L2b:
            r0 = move-exception
            r9 = r0
            r1 = r8
            goto L34
        L2f:
            r0 = move-exception
            goto L33
        L31:
            r0 = move-exception
            r3 = r9
        L33:
            r9 = r0
        L34:
            java.lang.String r8 = "VideoUtil"
            java.lang.String r0 = "Failed in getting absolute path for Uri %s with Exception %s"
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L53
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L53
            java.lang.Object[] r9 = new java.lang.Object[]{r2, r9}     // Catch: java.lang.Throwable -> L53
            java.lang.String r9 = java.lang.String.format(r0, r9)     // Catch: java.lang.Throwable -> L53
            androidx.camera.core.Logger.e(r8, r9)     // Catch: java.lang.Throwable -> L53
            java.lang.String r8 = ""
            if (r1 == 0) goto L52
            r1.close()
        L52:
            return r8
        L53:
            r0 = move-exception
            r9 = r0
        L55:
            if (r1 == 0) goto L5a
            r1.close()
        L5a:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.internal.utils.VideoUtil.getAbsolutePathFromUri(android.content.ContentResolver, android.net.Uri):java.lang.String");
    }
}
