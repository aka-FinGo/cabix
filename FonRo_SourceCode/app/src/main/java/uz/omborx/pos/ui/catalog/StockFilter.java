package uz.FonRo.pos.ui.catalog;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: CatalogScreen.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/ui/catalog/StockFilter;", "", "<init>", "(Ljava/lang/String;I)V", "ALL", "LOW", "OUT", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class StockFilter {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StockFilter[] $VALUES;
    public static final StockFilter ALL = new StockFilter("ALL", 0);
    public static final StockFilter LOW = new StockFilter("LOW", 1);
    public static final StockFilter OUT = new StockFilter("OUT", 2);

    private static final /* synthetic */ StockFilter[] $values() {
        return new StockFilter[]{ALL, LOW, OUT};
    }

    public static EnumEntries<StockFilter> getEntries() {
        return $ENTRIES;
    }

    public static StockFilter valueOf(String str) {
        return (StockFilter) Enum.valueOf(StockFilter.class, str);
    }

    public static StockFilter[] values() {
        return (StockFilter[]) $VALUES.clone();
    }

    static {
        StockFilter[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private StockFilter(String str, int i) {
    }
}
