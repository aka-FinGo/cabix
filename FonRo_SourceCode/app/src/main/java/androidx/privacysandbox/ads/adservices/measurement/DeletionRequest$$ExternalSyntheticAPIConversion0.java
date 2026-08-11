package androidx.privacysandbox.ads.adservices.measurement;

import android.adservices.measurement.DeletionRequest;
import j$.time.Instant;
import j$.time.TimeConversions;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes5.dex */
public final /* synthetic */ class DeletionRequest$$ExternalSyntheticAPIConversion0 {
    public static /* synthetic */ DeletionRequest.Builder m(DeletionRequest.Builder builder, Instant instant) {
        return builder.setStart(TimeConversions.convert(instant));
    }

    public static /* synthetic */ DeletionRequest.Builder m$1(DeletionRequest.Builder builder, Instant instant) {
        return builder.setEnd(TimeConversions.convert(instant));
    }
}
