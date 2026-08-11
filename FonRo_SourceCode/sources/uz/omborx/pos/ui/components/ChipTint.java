package uz.FonRo.pos.ui.components;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Chips.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Luz/FonRo/pos/ui/components/ChipTint;", "", "<init>", "(Ljava/lang/String;I)V", "PRIMARY", "CYAN", "ORANGE", "RED", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ChipTint {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ChipTint[] $VALUES;
    public static final ChipTint PRIMARY = new ChipTint("PRIMARY", 0);
    public static final ChipTint CYAN = new ChipTint("CYAN", 1);
    public static final ChipTint ORANGE = new ChipTint("ORANGE", 2);
    public static final ChipTint RED = new ChipTint("RED", 3);

    private static final /* synthetic */ ChipTint[] $values() {
        return new ChipTint[]{PRIMARY, CYAN, ORANGE, RED};
    }

    public static EnumEntries<ChipTint> getEntries() {
        return $ENTRIES;
    }

    public static ChipTint valueOf(String str) {
        return (ChipTint) Enum.valueOf(ChipTint.class, str);
    }

    public static ChipTint[] values() {
        return (ChipTint[]) $VALUES.clone();
    }

    static {
        ChipTint[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private ChipTint(String str, int i) {
    }
}
