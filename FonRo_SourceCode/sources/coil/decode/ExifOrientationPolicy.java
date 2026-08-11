package coil.decode;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ExifOrientationPolicy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcoil/decode/ExifOrientationPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "IGNORE", "RESPECT_PERFORMANCE", "RESPECT_ALL", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class ExifOrientationPolicy {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ExifOrientationPolicy[] $VALUES;
    public static final ExifOrientationPolicy IGNORE = new ExifOrientationPolicy("IGNORE", 0);
    public static final ExifOrientationPolicy RESPECT_PERFORMANCE = new ExifOrientationPolicy("RESPECT_PERFORMANCE", 1);
    public static final ExifOrientationPolicy RESPECT_ALL = new ExifOrientationPolicy("RESPECT_ALL", 2);

    private static final /* synthetic */ ExifOrientationPolicy[] $values() {
        return new ExifOrientationPolicy[]{IGNORE, RESPECT_PERFORMANCE, RESPECT_ALL};
    }

    public static EnumEntries<ExifOrientationPolicy> getEntries() {
        return $ENTRIES;
    }

    private ExifOrientationPolicy(String str, int i) {
    }

    static {
        ExifOrientationPolicy[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ExifOrientationPolicy valueOf(String str) {
        return (ExifOrientationPolicy) Enum.valueOf(ExifOrientationPolicy.class, str);
    }

    public static ExifOrientationPolicy[] values() {
        return (ExifOrientationPolicy[]) $VALUES.clone();
    }
}
