package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: EditingBuffer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", TypedValues.AttributesType.S_TARGET, "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m6617updateRangeAfterDeletepWDy79M(long j, long j2) {
        int m6431getLengthimpl;
        int m6433getMinimpl = TextRange.m6433getMinimpl(j);
        int m6432getMaximpl = TextRange.m6432getMaximpl(j);
        if (TextRange.m6437intersects5zctL8(j2, j)) {
            if (TextRange.m6425contains5zctL8(j2, j)) {
                m6433getMinimpl = TextRange.m6433getMinimpl(j2);
                m6432getMaximpl = m6433getMinimpl;
            } else {
                if (TextRange.m6425contains5zctL8(j, j2)) {
                    m6431getLengthimpl = TextRange.m6431getLengthimpl(j2);
                } else if (TextRange.m6426containsimpl(j2, m6433getMinimpl)) {
                    m6433getMinimpl = TextRange.m6433getMinimpl(j2);
                    m6431getLengthimpl = TextRange.m6431getLengthimpl(j2);
                } else {
                    m6432getMaximpl = TextRange.m6433getMinimpl(j2);
                }
                m6432getMaximpl -= m6431getLengthimpl;
            }
        } else if (m6432getMaximpl > TextRange.m6433getMinimpl(j2)) {
            m6433getMinimpl -= TextRange.m6431getLengthimpl(j2);
            m6431getLengthimpl = TextRange.m6431getLengthimpl(j2);
            m6432getMaximpl -= m6431getLengthimpl;
        }
        return TextRangeKt.TextRange(m6433getMinimpl, m6432getMaximpl);
    }
}
