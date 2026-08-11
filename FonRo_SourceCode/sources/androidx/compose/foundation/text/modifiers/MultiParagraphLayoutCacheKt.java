package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: MultiParagraphLayoutCache.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001f\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0082\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0007"}, d2 = {"DefaultFontSize", "Landroidx/compose/ui/unit/TextUnit;", "J", "times", WriteOffReason.OTHER, "times-NB67dxo", "(JJ)J", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class MultiParagraphLayoutCacheKt {
    private static final long DefaultFontSize = TextUnitKt.getSp(14);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: times-NB67dxo, reason: not valid java name */
    public static final long m1736timesNB67dxo(long j, long j2) {
        if (TextUnit.m7185isEmimpl(j2)) {
            if (TextUnit.m7185isEmimpl(j)) {
                throw new IllegalStateException("Cannot convert Em to Px when style.fontSize is Em (" + ((Object) TextUnit.m7190toStringimpl(j2)) + "). Please declare the style.fontSize with Sp units instead.");
            }
            if (TextUnit.m7181getRawTypeimpl(j) == 0) {
                long j3 = DefaultFontSize;
                float m7183getValueimpl = TextUnit.m7183getValueimpl(j2);
                TextUnitKt.m7196checkArithmeticR2X_6o(j3);
                return TextUnitKt.pack(TextUnit.m7181getRawTypeimpl(j3), TextUnit.m7183getValueimpl(j3) * m7183getValueimpl);
            }
            float m7183getValueimpl2 = TextUnit.m7183getValueimpl(j2);
            TextUnitKt.m7196checkArithmeticR2X_6o(j);
            return TextUnitKt.pack(TextUnit.m7181getRawTypeimpl(j), TextUnit.m7183getValueimpl(j) * m7183getValueimpl2);
        }
        throw new IllegalArgumentException("The multiplier must be in em, but was " + ((Object) TextUnit.m7190toStringimpl(j2)) + '.');
    }
}
