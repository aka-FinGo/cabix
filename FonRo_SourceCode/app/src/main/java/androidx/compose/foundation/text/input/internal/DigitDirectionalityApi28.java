package androidx.compose.foundation.text.input.internal;

import android.icu.text.DecimalFormatSymbols;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Locale;
import kotlin.Metadata;

/* compiled from: TextFieldLayoutStateCache.android.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/input/internal/DigitDirectionalityApi28;", "", "()V", "resolve", "", "locale", "Ljava/util/Locale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class DigitDirectionalityApi28 {
    public static final DigitDirectionalityApi28 INSTANCE = new DigitDirectionalityApi28();

    private DigitDirectionalityApi28() {
    }

    public final byte resolve(Locale locale) {
        String[] digitStrings;
        digitStrings = DecimalFormatSymbols.getInstance(locale).getDigitStrings();
        return Character.getDirectionality(CodepointHelpers_jvmKt.codePointAt(digitStrings[0], 0));
    }
}
