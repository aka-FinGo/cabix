package uz.FonRo.pos.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Barcodes.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\f"}, d2 = {"Luz/FonRo/pos/core/BarcodeKind;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "EAN13", "EAN8", "CODE128", "title", "", "getTitle", "()Ljava/lang/String;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BarcodeKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BarcodeKind[] $VALUES;
    public static final BarcodeKind NONE = new BarcodeKind("NONE", 0);
    public static final BarcodeKind EAN13 = new BarcodeKind("EAN13", 1);
    public static final BarcodeKind EAN8 = new BarcodeKind("EAN8", 2);
    public static final BarcodeKind CODE128 = new BarcodeKind("CODE128", 3);

    /* compiled from: Barcodes.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BarcodeKind.values().length];
            try {
                iArr[BarcodeKind.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BarcodeKind.EAN13.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BarcodeKind.EAN8.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BarcodeKind.CODE128.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ BarcodeKind[] $values() {
        return new BarcodeKind[]{NONE, EAN13, EAN8, CODE128};
    }

    public static EnumEntries<BarcodeKind> getEntries() {
        return $ENTRIES;
    }

    public static BarcodeKind valueOf(String str) {
        return (BarcodeKind) Enum.valueOf(BarcodeKind.class, str);
    }

    public static BarcodeKind[] values() {
        return (BarcodeKind[]) $VALUES.clone();
    }

    private BarcodeKind(String str, int i) {
    }

    static {
        BarcodeKind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public final String getTitle() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return "";
        }
        if (i == 2) {
            return "EAN-13";
        }
        if (i == 3) {
            return "EAN-8";
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return "Code 128";
    }
}
