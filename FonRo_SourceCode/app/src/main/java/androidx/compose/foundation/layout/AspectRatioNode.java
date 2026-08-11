package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: AspectRatio.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010\u001b\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J&\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\u0018\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u001c\u0010$\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010%\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J\u001e\u0010&\u001a\u00020\u0011*\u00020\u00122\u0006\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u001e\u0010*\u001a\u00020\u0011*\u00020\u00122\u0006\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010)J\u001e\u0010,\u001a\u00020\u0011*\u00020\u00122\u0006\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010)J\u001e\u0010.\u001a\u00020\u0011*\u00020\u00122\u0006\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u0010)R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"Landroidx/compose/foundation/layout/AspectRatioNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "aspectRatio", "", "matchHeightConstraintsFirst", "", "(FZ)V", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "getMatchHeightConstraintsFirst", "()Z", "setMatchHeightConstraintsFirst", "(Z)V", "findSize", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/Constraints;", "findSize-ToXhtMw", "(J)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "tryMaxHeight", "enforceConstraints", "tryMaxHeight-JN-0ABg", "(JZ)J", "tryMaxWidth", "tryMaxWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {
    private float aspectRatio;
    private boolean matchHeightConstraintsFirst;

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final void setAspectRatio(float f) {
        this.aspectRatio = f;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    public final void setMatchHeightConstraintsFirst(boolean z) {
        this.matchHeightConstraintsFirst = z;
    }

    public AspectRatioNode(float f, boolean z) {
        this.aspectRatio = f;
        this.matchHeightConstraintsFirst = z;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo384measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long m948findSizeToXhtMw = m948findSizeToXhtMw(j);
        if (!IntSize.m7158equalsimpl0(m948findSizeToXhtMw, IntSize.INSTANCE.m7165getZeroYbymL2g())) {
            j = Constraints.INSTANCE.m6952fixedJhjzzOo((int) (m948findSizeToXhtMw >> 32), (int) (m948findSizeToXhtMw & 4294967295L));
        }
        final Placeable mo5732measureBRTryo0 = measurable.mo5732measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, mo5732measureBRTryo0.getWidth(), mo5732measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AspectRatioNode$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        return Math.round(i * this.aspectRatio);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }
        return Math.round(i * this.aspectRatio);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        return Math.round(i / this.aspectRatio);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }
        return Math.round(i / this.aspectRatio);
    }

    /* renamed from: findSize-ToXhtMw, reason: not valid java name */
    private final long m948findSizeToXhtMw(long j) {
        if (!this.matchHeightConstraintsFirst) {
            long m950tryMaxWidthJN0ABg = m950tryMaxWidthJN0ABg(j, true);
            if (!IntSize.m7158equalsimpl0(m950tryMaxWidthJN0ABg, IntSize.INSTANCE.m7165getZeroYbymL2g())) {
                return m950tryMaxWidthJN0ABg;
            }
            long m949tryMaxHeightJN0ABg = m949tryMaxHeightJN0ABg(j, true);
            if (!IntSize.m7158equalsimpl0(m949tryMaxHeightJN0ABg, IntSize.INSTANCE.m7165getZeroYbymL2g())) {
                return m949tryMaxHeightJN0ABg;
            }
            long m952tryMinWidthJN0ABg = m952tryMinWidthJN0ABg(j, true);
            if (!IntSize.m7158equalsimpl0(m952tryMinWidthJN0ABg, IntSize.INSTANCE.m7165getZeroYbymL2g())) {
                return m952tryMinWidthJN0ABg;
            }
            long m951tryMinHeightJN0ABg = m951tryMinHeightJN0ABg(j, true);
            if (!IntSize.m7158equalsimpl0(m951tryMinHeightJN0ABg, IntSize.INSTANCE.m7165getZeroYbymL2g())) {
                return m951tryMinHeightJN0ABg;
            }
            long m950tryMaxWidthJN0ABg2 = m950tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m7158equalsimpl0(m950tryMaxWidthJN0ABg2, IntSize.INSTANCE.m7165getZeroYbymL2g())) {
                return m950tryMaxWidthJN0ABg2;
            }
            long m949tryMaxHeightJN0ABg2 = m949tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m7158equalsimpl0(m949tryMaxHeightJN0ABg2, IntSize.INSTANCE.m7165getZeroYbymL2g())) {
                return m949tryMaxHeightJN0ABg2;
            }
            long m952tryMinWidthJN0ABg2 = m952tryMinWidthJN0ABg(j, false);
            if (!IntSize.m7158equalsimpl0(m952tryMinWidthJN0ABg2, IntSize.INSTANCE.m7165getZeroYbymL2g())) {
                return m952tryMinWidthJN0ABg2;
            }
            long m951tryMinHeightJN0ABg2 = m951tryMinHeightJN0ABg(j, false);
            if (!IntSize.m7158equalsimpl0(m951tryMinHeightJN0ABg2, IntSize.INSTANCE.m7165getZeroYbymL2g())) {
                return m951tryMinHeightJN0ABg2;
            }
        } else {
            long m949tryMaxHeightJN0ABg3 = m949tryMaxHeightJN0ABg(j, true);
            if (!IntSize.m7158equalsimpl0(m949tryMaxHeightJN0ABg3, IntSize.INSTANCE.m7165getZeroYbymL2g())) {
                return m949tryMaxHeightJN0ABg3;
            }
            long m950tryMaxWidthJN0ABg3 = m950tryMaxWidthJN0ABg(j, true);
            if (!IntSize.m7158equalsimpl0(m950tryMaxWidthJN0ABg3, IntSize.INSTANCE.m7165getZeroYbymL2g())) {
                return m950tryMaxWidthJN0ABg3;
            }
            long m951tryMinHeightJN0ABg3 = m951tryMinHeightJN0ABg(j, true);
            if (!IntSize.m7158equalsimpl0(m951tryMinHeightJN0ABg3, IntSize.INSTANCE.m7165getZeroYbymL2g())) {
                return m951tryMinHeightJN0ABg3;
            }
            long m952tryMinWidthJN0ABg3 = m952tryMinWidthJN0ABg(j, true);
            if (!IntSize.m7158equalsimpl0(m952tryMinWidthJN0ABg3, IntSize.INSTANCE.m7165getZeroYbymL2g())) {
                return m952tryMinWidthJN0ABg3;
            }
            long m949tryMaxHeightJN0ABg4 = m949tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m7158equalsimpl0(m949tryMaxHeightJN0ABg4, IntSize.INSTANCE.m7165getZeroYbymL2g())) {
                return m949tryMaxHeightJN0ABg4;
            }
            long m950tryMaxWidthJN0ABg4 = m950tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m7158equalsimpl0(m950tryMaxWidthJN0ABg4, IntSize.INSTANCE.m7165getZeroYbymL2g())) {
                return m950tryMaxWidthJN0ABg4;
            }
            long m951tryMinHeightJN0ABg4 = m951tryMinHeightJN0ABg(j, false);
            if (!IntSize.m7158equalsimpl0(m951tryMinHeightJN0ABg4, IntSize.INSTANCE.m7165getZeroYbymL2g())) {
                return m951tryMinHeightJN0ABg4;
            }
            long m952tryMinWidthJN0ABg4 = m952tryMinWidthJN0ABg(j, false);
            if (!IntSize.m7158equalsimpl0(m952tryMinWidthJN0ABg4, IntSize.INSTANCE.m7165getZeroYbymL2g())) {
                return m952tryMinWidthJN0ABg4;
            }
        }
        return IntSize.INSTANCE.m7165getZeroYbymL2g();
    }

    /* renamed from: tryMaxWidth-JN-0ABg, reason: not valid java name */
    private final long m950tryMaxWidthJN0ABg(long j, boolean z) {
        int round;
        int m6942getMaxWidthimpl = Constraints.m6942getMaxWidthimpl(j);
        if (m6942getMaxWidthimpl == Integer.MAX_VALUE || (round = Math.round(m6942getMaxWidthimpl / this.aspectRatio)) <= 0 || (z && !AspectRatioKt.m947isSatisfiedByNN6EwU(j, m6942getMaxWidthimpl, round))) {
            return IntSize.INSTANCE.m7165getZeroYbymL2g();
        }
        return IntSize.m7155constructorimpl((m6942getMaxWidthimpl << 32) | (round & 4294967295L));
    }

    /* renamed from: tryMaxHeight-JN-0ABg, reason: not valid java name */
    private final long m949tryMaxHeightJN0ABg(long j, boolean z) {
        int round;
        int m6941getMaxHeightimpl = Constraints.m6941getMaxHeightimpl(j);
        if (m6941getMaxHeightimpl == Integer.MAX_VALUE || (round = Math.round(m6941getMaxHeightimpl * this.aspectRatio)) <= 0 || (z && !AspectRatioKt.m947isSatisfiedByNN6EwU(j, round, m6941getMaxHeightimpl))) {
            return IntSize.INSTANCE.m7165getZeroYbymL2g();
        }
        return IntSize.m7155constructorimpl((round << 32) | (m6941getMaxHeightimpl & 4294967295L));
    }

    /* renamed from: tryMinWidth-JN-0ABg, reason: not valid java name */
    private final long m952tryMinWidthJN0ABg(long j, boolean z) {
        int m6944getMinWidthimpl = Constraints.m6944getMinWidthimpl(j);
        int round = Math.round(m6944getMinWidthimpl / this.aspectRatio);
        if (round <= 0 || (z && !AspectRatioKt.m947isSatisfiedByNN6EwU(j, m6944getMinWidthimpl, round))) {
            return IntSize.INSTANCE.m7165getZeroYbymL2g();
        }
        return IntSize.m7155constructorimpl((m6944getMinWidthimpl << 32) | (round & 4294967295L));
    }

    /* renamed from: tryMinHeight-JN-0ABg, reason: not valid java name */
    private final long m951tryMinHeightJN0ABg(long j, boolean z) {
        int m6943getMinHeightimpl = Constraints.m6943getMinHeightimpl(j);
        int round = Math.round(m6943getMinHeightimpl * this.aspectRatio);
        if (round <= 0 || (z && !AspectRatioKt.m947isSatisfiedByNN6EwU(j, round, m6943getMinHeightimpl))) {
            return IntSize.INSTANCE.m7165getZeroYbymL2g();
        }
        return IntSize.m7155constructorimpl((round << 32) | (m6943getMinHeightimpl & 4294967295L));
    }
}
