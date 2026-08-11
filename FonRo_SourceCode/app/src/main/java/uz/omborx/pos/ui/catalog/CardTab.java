package uz.FonRo.pos.ui.catalog;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.ui.nav.Routes;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ProductCard.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000f"}, d2 = {"Luz/FonRo/pos/ui/catalog/CardTab;", "", "key", "", "raw", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "CHART", "HISTORY", "AUDIT", "RETURNS", "label", "getLabel", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class CardTab {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CardTab[] $VALUES;
    private final String key;
    private final String raw;
    public static final CardTab CHART = new CardTab("CHART", 0, "chart", "График");
    public static final CardTab HISTORY = new CardTab("HISTORY", 1, Routes.HISTORY, "История");
    public static final CardTab AUDIT = new CardTab("AUDIT", 2, Routes.AUDIT, "Аудит");
    public static final CardTab RETURNS = new CardTab("RETURNS", 3, Routes.RETURNS, "Возвраты");

    private static final /* synthetic */ CardTab[] $values() {
        return new CardTab[]{CHART, HISTORY, AUDIT, RETURNS};
    }

    public static EnumEntries<CardTab> getEntries() {
        return $ENTRIES;
    }

    public static CardTab valueOf(String str) {
        return (CardTab) Enum.valueOf(CardTab.class, str);
    }

    public static CardTab[] values() {
        return (CardTab[]) $VALUES.clone();
    }

    private CardTab(String str, int i, String str2, String str3) {
        this.key = str2;
        this.raw = str3;
    }

    public final String getKey() {
        return this.key;
    }

    static {
        CardTab[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public final String getLabel() {
        return LangKt.tx(this.raw, new Object[0]);
    }
}
