package uz.FonRo.pos.data.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import uz.FonRo.pos.core.LangKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Sales.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0012"}, d2 = {"Luz/FonRo/pos/data/model/PayType;", "", "code", "", "raw", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "CASH", "CARD", "MIXED", "DEBT", "label", "getLabel", "rawLabel", "getRawLabel", "Companion", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class PayType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PayType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String code;
    private final String raw;
    public static final PayType CASH = new PayType("CASH", 0, "cash", "Наличные");
    public static final PayType CARD = new PayType("CARD", 1, "card", "Карта");
    public static final PayType MIXED = new PayType("MIXED", 2, "mixed", "Смешанная");
    public static final PayType DEBT = new PayType("DEBT", 3, "debt", "В долг");

    private static final /* synthetic */ PayType[] $values() {
        return new PayType[]{CASH, CARD, MIXED, DEBT};
    }

    public static EnumEntries<PayType> getEntries() {
        return $ENTRIES;
    }

    public static PayType valueOf(String str) {
        return (PayType) Enum.valueOf(PayType.class, str);
    }

    public static PayType[] values() {
        return (PayType[]) $VALUES.clone();
    }

    private PayType(String str, int i, String str2, String str3) {
        this.code = str2;
        this.raw = str3;
    }

    public final String getCode() {
        return this.code;
    }

    static {
        PayType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    public final String getLabel() {
        return LangKt.tx(this.raw, new Object[0]);
    }

    /* renamed from: getRawLabel, reason: from getter */
    public final String getRaw() {
        return this.raw;
    }

    /* compiled from: Sales.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Luz/FonRo/pos/data/model/PayType$Companion;", "", "<init>", "()V", "of", "Luz/FonRo/pos/data/model/PayType;", "code", "", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PayType of(String code) {
            Object obj;
            Iterator<E> it = PayType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (StringsKt.equals(((PayType) obj).getCode(), code, true)) {
                    break;
                }
            }
            PayType payType = (PayType) obj;
            return payType == null ? PayType.CASH : payType;
        }
    }
}
