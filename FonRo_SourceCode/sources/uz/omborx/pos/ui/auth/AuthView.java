package uz.FonRo.pos.ui.auth;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AuthScreen.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Luz/FonRo/pos/ui/auth/AuthView;", "", "<init>", "(Ljava/lang/String;I)V", "LOGIN", "REGISTER", "OTP", "RESET", "NEWPASS", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class AuthView {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AuthView[] $VALUES;
    public static final AuthView LOGIN = new AuthView("LOGIN", 0);
    public static final AuthView REGISTER = new AuthView("REGISTER", 1);
    public static final AuthView OTP = new AuthView("OTP", 2);
    public static final AuthView RESET = new AuthView("RESET", 3);
    public static final AuthView NEWPASS = new AuthView("NEWPASS", 4);

    private static final /* synthetic */ AuthView[] $values() {
        return new AuthView[]{LOGIN, REGISTER, OTP, RESET, NEWPASS};
    }

    public static EnumEntries<AuthView> getEntries() {
        return $ENTRIES;
    }

    public static AuthView valueOf(String str) {
        return (AuthView) Enum.valueOf(AuthView.class, str);
    }

    public static AuthView[] values() {
        return (AuthView[]) $VALUES.clone();
    }

    static {
        AuthView[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private AuthView(String str, int i) {
    }
}
