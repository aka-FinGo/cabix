package uz.FonRo.pos.core;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: Num.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"toAmount", "", "", "app"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class NumKt {
    public static final double toAmount(String str) {
        Double doubleOrNull;
        String str2 = str;
        return (str2 == null || StringsKt.isBlank(str2) || (doubleOrNull = StringsKt.toDoubleOrNull(StringsKt.replace$default(StringsKt.trim((CharSequence) str2).toString(), AbstractJsonLexerKt.COMMA, '.', false, 4, (Object) null))) == null) ? AudioStats.AUDIO_AMPLITUDE_NONE : doubleOrNull.doubleValue();
    }
}
