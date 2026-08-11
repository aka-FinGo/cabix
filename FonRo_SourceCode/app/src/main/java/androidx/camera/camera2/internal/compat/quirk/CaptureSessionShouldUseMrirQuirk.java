package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* loaded from: classes.dex */
public class CaptureSessionShouldUseMrirQuirk implements Quirk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean load() {
        return "google".equalsIgnoreCase(Build.BRAND) && Build.VERSION.SDK_INT >= 35;
    }
}
