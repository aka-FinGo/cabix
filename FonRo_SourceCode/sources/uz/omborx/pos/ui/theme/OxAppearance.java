package uz.FonRo.pos.ui.theme;

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
/* compiled from: Color.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0013"}, d2 = {"Luz/FonRo/pos/ui/theme/OxAppearance;", "", "key", "", "rawTitle", "rawHint", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "SYSTEM", "LIGHT", "BLUE", "DARK", "title", "getTitle", "hint", "getHint", "Companion", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class OxAppearance {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ OxAppearance[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String key;
    private final String rawHint;
    private final String rawTitle;
    public static final OxAppearance SYSTEM = new OxAppearance("SYSTEM", 0, "system", "Системная", "Как в настройках телефона");
    public static final OxAppearance LIGHT = new OxAppearance("LIGHT", 1, "light", "Светлая", "Белые карточки, как раньше");
    public static final OxAppearance BLUE = new OxAppearance("BLUE", 2, "blue", "Blue", "Тёмно-синяя, как на iPhone");
    public static final OxAppearance DARK = new OxAppearance("DARK", 3, "dark", "Тёмная", "Чёрная — на OLED экономит батарею");

    private static final /* synthetic */ OxAppearance[] $values() {
        return new OxAppearance[]{SYSTEM, LIGHT, BLUE, DARK};
    }

    public static EnumEntries<OxAppearance> getEntries() {
        return $ENTRIES;
    }

    public static OxAppearance valueOf(String str) {
        return (OxAppearance) Enum.valueOf(OxAppearance.class, str);
    }

    public static OxAppearance[] values() {
        return (OxAppearance[]) $VALUES.clone();
    }

    private OxAppearance(String str, int i, String str2, String str3, String str4) {
        this.key = str2;
        this.rawTitle = str3;
        this.rawHint = str4;
    }

    public final String getKey() {
        return this.key;
    }

    static {
        OxAppearance[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    public final String getTitle() {
        return LangKt.tx(this.rawTitle, new Object[0]);
    }

    public final String getHint() {
        return LangKt.tx(this.rawHint, new Object[0]);
    }

    /* compiled from: Color.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Luz/FonRo/pos/ui/theme/OxAppearance$Companion;", "", "<init>", "()V", "of", "Luz/FonRo/pos/ui/theme/OxAppearance;", "key", "", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OxAppearance of(String key) {
            Object obj;
            Iterator<E> it = OxAppearance.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (StringsKt.equals(((OxAppearance) obj).getKey(), key, true)) {
                    break;
                }
            }
            OxAppearance oxAppearance = (OxAppearance) obj;
            return oxAppearance == null ? OxAppearance.SYSTEM : oxAppearance;
        }
    }
}
