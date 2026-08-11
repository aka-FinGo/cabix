package coil.compose;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: AsyncImage.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
final class AsyncImageKt$Content$2 implements MeasurePolicy {
    public static final AsyncImageKt$Content$2 INSTANCE = new AsyncImageKt$Content$2();

    AsyncImageKt$Content$2() {
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo356measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        return MeasureScope.layout$default(measureScope, Constraints.m6944getMinWidthimpl(j), Constraints.m6943getMinHeightimpl(j), null, new Function1() { // from class: coil.compose.AsyncImageKt$Content$2$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 4, null);
    }
}
