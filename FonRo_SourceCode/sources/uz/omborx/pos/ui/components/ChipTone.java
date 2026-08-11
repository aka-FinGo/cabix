package uz.FonRo.pos.ui.components;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Basics.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Luz/FonRo/pos/ui/components/ChipTone;", "", "<init>", "(Ljava/lang/String;I)V", "OK", "WARN", "BAD", "DIM", "BLUE", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ChipTone {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ChipTone[] $VALUES;
    public static final ChipTone OK = new ChipTone("OK", 0);
    public static final ChipTone WARN = new ChipTone("WARN", 1);
    public static final ChipTone BAD = new ChipTone("BAD", 2);
    public static final ChipTone DIM = new ChipTone("DIM", 3);
    public static final ChipTone BLUE = new ChipTone("BLUE", 4);

    private static final /* synthetic */ ChipTone[] $values() {
        return new ChipTone[]{OK, WARN, BAD, DIM, BLUE};
    }

    public static EnumEntries<ChipTone> getEntries() {
        return $ENTRIES;
    }

    public static ChipTone valueOf(String str) {
        return (ChipTone) Enum.valueOf(ChipTone.class, str);
    }

    public static ChipTone[] values() {
        return (ChipTone[]) $VALUES.clone();
    }

    static {
        ChipTone[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private ChipTone(String str, int i) {
    }
}
