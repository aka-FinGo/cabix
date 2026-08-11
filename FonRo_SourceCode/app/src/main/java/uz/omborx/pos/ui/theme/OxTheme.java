package uz.FonRo.pos.ui.theme;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.prefs.AppPrefs;

/* compiled from: Color.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0005R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\bR\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019Ê\u0001\f\b!\u0012\b\b\"\u0012\u0004\b\u0003\u0010\u0002¨\u0006 "}, d2 = {"Luz/FonRo/pos/ui/theme/OxTheme;", "", "<init>", "()V", "<set-?>", "Luz/FonRo/pos/ui/theme/OxAppearance;", "mode", "getMode", "()Luz/FonRo/pos/ui/theme/OxAppearance;", "setMode", "(Luz/FonRo/pos/ui/theme/OxAppearance;)V", "mode$delegate", "Landroidx/compose/runtime/MutableState;", "", "systemDark", "getSystemDark", "()Z", "setSystemDark", "(Z)V", "systemDark$delegate", "resolved", "getResolved", "palette", "Luz/FonRo/pos/ui/theme/OxPalette;", "getPalette", "()Luz/FonRo/pos/ui/theme/OxPalette;", "load", "", "prefs", "Luz/FonRo/pos/data/prefs/AppPrefs;", "apply", "value", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class OxTheme {
    public static final int $stable = 0;
    public static final OxTheme INSTANCE = new OxTheme();

    /* renamed from: mode$delegate, reason: from kotlin metadata */
    private static final MutableState mode;

    /* renamed from: systemDark$delegate, reason: from kotlin metadata */
    private static final MutableState systemDark;

    /* compiled from: Color.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes7.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OxAppearance.values().length];
            try {
                iArr[OxAppearance.SYSTEM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OxAppearance.BLUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OxAppearance.DARK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private OxTheme() {
    }

    static {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(OxAppearance.SYSTEM, null, 2, null);
        mode = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        systemDark = mutableStateOf$default2;
    }

    private final void setMode(OxAppearance oxAppearance) {
        mode.setValue(oxAppearance);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final OxAppearance getMode() {
        return (OxAppearance) mode.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getSystemDark() {
        return ((Boolean) systemDark.getValue()).booleanValue();
    }

    public final void setSystemDark(boolean z) {
        systemDark.setValue(Boolean.valueOf(z));
    }

    public final OxAppearance getResolved() {
        if (WhenMappings.$EnumSwitchMapping$0[getMode().ordinal()] == 1) {
            return getSystemDark() ? OxAppearance.BLUE : OxAppearance.LIGHT;
        }
        return getMode();
    }

    public final OxPalette getPalette() {
        OxPalette oxPalette;
        OxPalette oxPalette2;
        OxPalette oxPalette3;
        int i = WhenMappings.$EnumSwitchMapping$0[getResolved().ordinal()];
        if (i == 2) {
            oxPalette = ColorKt.BluePalette;
            return oxPalette;
        }
        if (i != 3) {
            oxPalette3 = ColorKt.LightPalette;
            return oxPalette3;
        }
        oxPalette2 = ColorKt.DarkPalette;
        return oxPalette2;
    }

    public final void load(AppPrefs prefs) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        setMode(OxAppearance.INSTANCE.of(prefs.getAppearance()));
    }

    public final void apply(AppPrefs prefs, OxAppearance value) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(value, "value");
        setMode(value);
        prefs.setAppearance(value.getKey());
    }
}
