package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import j$.time.Duration;
import j$.time.TimeConversions;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes4.dex */
public final /* synthetic */ class AccessibilityNodeInfoCompat$Api34Impl$$ExternalSyntheticAPIConversion0 {
    public static /* synthetic */ Duration m(AccessibilityNodeInfo accessibilityNodeInfo) {
        return TimeConversions.convert(accessibilityNodeInfo.getMinDurationBetweenContentChanges());
    }

    public static /* synthetic */ void m(AccessibilityNodeInfo accessibilityNodeInfo, Duration duration) {
        accessibilityNodeInfo.setMinDurationBetweenContentChanges(TimeConversions.convert(duration));
    }
}
