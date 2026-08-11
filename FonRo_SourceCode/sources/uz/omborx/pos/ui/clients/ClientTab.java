package uz.FonRo.pos.ui.clients;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import uz.FonRo.pos.core.LangKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ClientsScreen.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\r"}, d2 = {"Luz/FonRo/pos/ui/clients/ClientTab;", "", "key", "", "raw", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "PURCHASES", "PAYMENTS", "label", "getLabel", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ClientTab {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ClientTab[] $VALUES;
    private final String key;
    private final String raw;
    public static final ClientTab PURCHASES = new ClientTab("PURCHASES", 0, "purchases", "Покупки");
    public static final ClientTab PAYMENTS = new ClientTab("PAYMENTS", 1, "payments", "Оплаты");

    private static final /* synthetic */ ClientTab[] $values() {
        return new ClientTab[]{PURCHASES, PAYMENTS};
    }

    public static EnumEntries<ClientTab> getEntries() {
        return $ENTRIES;
    }

    public static ClientTab valueOf(String str) {
        return (ClientTab) Enum.valueOf(ClientTab.class, str);
    }

    public static ClientTab[] values() {
        return (ClientTab[]) $VALUES.clone();
    }

    private ClientTab(String str, int i, String str2, String str3) {
        this.key = str2;
        this.raw = str3;
    }

    public final String getKey() {
        return this.key;
    }

    static {
        ClientTab[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public final String getLabel() {
        return LangKt.tx(this.raw, new Object[0]);
    }
}
