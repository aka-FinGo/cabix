package uz.FonRo.pos.ui.components;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Chips.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Luz/FonRo/pos/ui/components/PeriodKind;", "", "<init>", "(Ljava/lang/String;I)V", "ALL", "TODAY", "DAYS_10", "MONTH", "DATE", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class PeriodKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PeriodKind[] $VALUES;
    public static final PeriodKind ALL = new PeriodKind("ALL", 0);
    public static final PeriodKind TODAY = new PeriodKind("TODAY", 1);
    public static final PeriodKind DAYS_10 = new PeriodKind("DAYS_10", 2);
    public static final PeriodKind MONTH = new PeriodKind("MONTH", 3);
    public static final PeriodKind DATE = new PeriodKind("DATE", 4);

    private static final /* synthetic */ PeriodKind[] $values() {
        return new PeriodKind[]{ALL, TODAY, DAYS_10, MONTH, DATE};
    }

    public static EnumEntries<PeriodKind> getEntries() {
        return $ENTRIES;
    }

    public static PeriodKind valueOf(String str) {
        return (PeriodKind) Enum.valueOf(PeriodKind.class, str);
    }

    public static PeriodKind[] values() {
        return (PeriodKind[]) $VALUES.clone();
    }

    static {
        PeriodKind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private PeriodKind(String str, int i) {
    }
}
