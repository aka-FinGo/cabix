package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* compiled from: LayoutUtils.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u001a2\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a2\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, d2 = {"isEllipsis", "", "Landroidx/compose/ui/text/style/TextOverflow;", "isEllipsis-MW5-ApA", "(I)Z", "finalConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "softWrap", "overflow", "maxIntrinsicWidth", "", "finalConstraints-tfFHcEY", "(JZIF)J", "finalMaxLines", "", "maxLinesIn", "finalMaxLines-xdlQI24", "(ZII)I", "finalMaxWidth", "finalMaxWidth-tfFHcEY", "(JZIF)I", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LayoutUtilsKt {
    /* renamed from: finalConstraints-tfFHcEY, reason: not valid java name */
    public static final long m1719finalConstraintstfFHcEY(long j, boolean z, int i, float f) {
        return Constraints.INSTANCE.m6951fitPrioritizingWidthZbe2FdA(0, m1721finalMaxWidthtfFHcEY(j, z, i, f), 0, Constraints.m6941getMaxHeightimpl(j));
    }

    /* renamed from: finalMaxWidth-tfFHcEY, reason: not valid java name */
    public static final int m1721finalMaxWidthtfFHcEY(long j, boolean z, int i, float f) {
        int m6942getMaxWidthimpl = ((z || m1722isEllipsisMW5ApA(i)) && Constraints.m6938getHasBoundedWidthimpl(j)) ? Constraints.m6942getMaxWidthimpl(j) : Integer.MAX_VALUE;
        return Constraints.m6944getMinWidthimpl(j) == m6942getMaxWidthimpl ? m6942getMaxWidthimpl : RangesKt.coerceIn(TextDelegateKt.ceilToIntPx(f), Constraints.m6944getMinWidthimpl(j), m6942getMaxWidthimpl);
    }

    /* renamed from: finalMaxLines-xdlQI24, reason: not valid java name */
    public static final int m1720finalMaxLinesxdlQI24(boolean z, int i, int i2) {
        if (z || !m1722isEllipsisMW5ApA(i)) {
            return RangesKt.coerceAtLeast(i2, 1);
        }
        return 1;
    }

    /* renamed from: isEllipsis-MW5-ApA, reason: not valid java name */
    public static final boolean m1722isEllipsisMW5ApA(int i) {
        return TextOverflow.m6915equalsimpl0(i, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8()) || TextOverflow.m6915equalsimpl0(i, TextOverflow.INSTANCE.m6927getStartEllipsisgIe3tQ8()) || TextOverflow.m6915equalsimpl0(i, TextOverflow.INSTANCE.m6926getMiddleEllipsisgIe3tQ8());
    }
}
