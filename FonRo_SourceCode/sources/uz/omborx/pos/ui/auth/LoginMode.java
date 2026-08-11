package uz.FonRo.pos.ui.auth;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AuthScreen.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Luz/FonRo/pos/ui/auth/LoginMode;", "", "<init>", "(Ljava/lang/String;I)V", "EMAIL", "KEY", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class LoginMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LoginMode[] $VALUES;
    public static final LoginMode EMAIL = new LoginMode("EMAIL", 0);
    public static final LoginMode KEY = new LoginMode("KEY", 1);

    private static final /* synthetic */ LoginMode[] $values() {
        return new LoginMode[]{EMAIL, KEY};
    }

    public static EnumEntries<LoginMode> getEntries() {
        return $ENTRIES;
    }

    public static LoginMode valueOf(String str) {
        return (LoginMode) Enum.valueOf(LoginMode.class, str);
    }

    public static LoginMode[] values() {
        return (LoginMode[]) $VALUES.clone();
    }

    static {
        LoginMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private LoginMode(String str, int i) {
    }
}
