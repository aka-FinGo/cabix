package uz.FonRo.pos.ui.components;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Basics.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Luz/FonRo/pos/ui/components/BtnStyle;", "", "<init>", "(Ljava/lang/String;I)V", "PLAIN", "PRIMARY", "GHOST", "DANGER", "OK", "CYAN", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class BtnStyle {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BtnStyle[] $VALUES;
    public static final BtnStyle PLAIN = new BtnStyle("PLAIN", 0);
    public static final BtnStyle PRIMARY = new BtnStyle("PRIMARY", 1);
    public static final BtnStyle GHOST = new BtnStyle("GHOST", 2);
    public static final BtnStyle DANGER = new BtnStyle("DANGER", 3);
    public static final BtnStyle OK = new BtnStyle("OK", 4);
    public static final BtnStyle CYAN = new BtnStyle("CYAN", 5);

    private static final /* synthetic */ BtnStyle[] $values() {
        return new BtnStyle[]{PLAIN, PRIMARY, GHOST, DANGER, OK, CYAN};
    }

    public static EnumEntries<BtnStyle> getEntries() {
        return $ENTRIES;
    }

    public static BtnStyle valueOf(String str) {
        return (BtnStyle) Enum.valueOf(BtnStyle.class, str);
    }

    public static BtnStyle[] values() {
        return (BtnStyle[]) $VALUES.clone();
    }

    static {
        BtnStyle[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private BtnStyle(String str, int i) {
    }
}
