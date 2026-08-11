package uz.FonRo.pos.data.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.core.Lang;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bÊ\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Luz/FonRo/pos/data/model/CatalogLangs;", "", "<init>", "()V", "CODES", "", "", "getCODES", "()Ljava/util/List;", "title", "code", "fromDevice", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class CatalogLangs {
    public static final int $stable = 0;
    public static final CatalogLangs INSTANCE = new CatalogLangs();
    private static final List<String> CODES = CollectionsKt.listOf((Object[]) new String[]{"uz", Lang.DEFAULT, "en", "kk", "ky", "tg"});

    private CatalogLangs() {
    }

    public final List<String> getCODES() {
        return CODES;
    }

    public final String title(String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        int hashCode = code.hashCode();
        if (hashCode != 3241) {
            if (hashCode != 3424) {
                if (hashCode != 3438) {
                    if (hashCode != 3651) {
                        if (hashCode != 3699) {
                            if (hashCode == 3749 && code.equals("uz")) {
                                return "O‘zbekcha";
                            }
                        } else if (code.equals("tg")) {
                            return "Тоҷикӣ";
                        }
                    } else if (code.equals(Lang.DEFAULT)) {
                        return "Русский";
                    }
                } else if (code.equals("ky")) {
                    return "Кыргызча";
                }
            } else if (code.equals("kk")) {
                return "Қазақша";
            }
        } else if (code.equals("en")) {
            return "English";
        }
        return code;
    }

    public final String fromDevice() {
        String language = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        String lowerCase = language.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, "kz")) {
            lowerCase = "kk";
        }
        return CODES.contains(lowerCase) ? lowerCase : "en";
    }
}
