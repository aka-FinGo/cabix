package uz.FonRo.pos.print;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LabelSheet.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Luz/FonRo/pos/print/SheetKind;", "", "<init>", "(Ljava/lang/String;I)V", "A4", "ROLL", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class SheetKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SheetKind[] $VALUES;
    public static final SheetKind A4 = new SheetKind("A4", 0);
    public static final SheetKind ROLL = new SheetKind("ROLL", 1);

    private static final /* synthetic */ SheetKind[] $values() {
        return new SheetKind[]{A4, ROLL};
    }

    public static EnumEntries<SheetKind> getEntries() {
        return $ENTRIES;
    }

    public static SheetKind valueOf(String str) {
        return (SheetKind) Enum.valueOf(SheetKind.class, str);
    }

    public static SheetKind[] values() {
        return (SheetKind[]) $VALUES.clone();
    }

    static {
        SheetKind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private SheetKind(String str, int i) {
    }
}
