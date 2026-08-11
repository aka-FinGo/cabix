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
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Size.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020 H\u0016J\u001c\u0010%\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010&\u001a\u00020 H\u0016J&\u0010'\u001a\u00020(*\u00020)2\u0006\u0010\"\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u001c\u0010.\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020 H\u0016J\u001c\u0010/\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010&\u001a\u00020 H\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0007\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0005\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012R\"\u0010\u0003\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u001e\u0010\u001a\u001a\u00020\u001b*\u00020\u001c8BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00060"}, d2 = {"Landroidx/compose/foundation/layout/SizeNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxWidth", "maxHeight", "enforceIncoming", "", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEnforceIncoming", "()Z", "setEnforceIncoming", "(Z)V", "getMaxHeight-D9Ej5fM", "()F", "setMaxHeight-0680j_4", "(F)V", "F", "getMaxWidth-D9Ej5fM", "setMaxWidth-0680j_4", "getMinHeight-D9Ej5fM", "setMinHeight-0680j_4", "getMinWidth-D9Ej5fM", "setMinWidth-0680j_4", "targetConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/unit/Density;", "getTargetConstraints-OenEA2s", "(Landroidx/compose/ui/unit/Density;)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class SizeNode extends Modifier.Node implements LayoutModifierNode {
    private boolean enforceIncoming;
    private float maxHeight;
    private float maxWidth;
    private float minHeight;
    private float minWidth;

    public /* synthetic */ SizeNode(float f, float f2, float f3, float f4, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z);
    }

    public /* synthetic */ SizeNode(float f, float f2, float f3, float f4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.INSTANCE.m7009getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Dp.INSTANCE.m7009getUnspecifiedD9Ej5fM() : f2, (i & 4) != 0 ? Dp.INSTANCE.m7009getUnspecifiedD9Ej5fM() : f3, (i & 8) != 0 ? Dp.INSTANCE.m7009getUnspecifiedD9Ej5fM() : f4, z, null);
    }

    /* renamed from: getMinWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMinWidth() {
        return this.minWidth;
    }

    /* renamed from: setMinWidth-0680j_4, reason: not valid java name */
    public final void m1112setMinWidth0680j_4(float f) {
        this.minWidth = f;
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMinHeight() {
        return this.minHeight;
    }

    /* renamed from: setMinHeight-0680j_4, reason: not valid java name */
    public final void m1111setMinHeight0680j_4(float f) {
        this.minHeight = f;
    }

    /* renamed from: getMaxWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMaxWidth() {
        return this.maxWidth;
    }

    /* renamed from: setMaxWidth-0680j_4, reason: not valid java name */
    public final void m1110setMaxWidth0680j_4(float f) {
        this.maxWidth = f;
    }

    /* renamed from: getMaxHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMaxHeight() {
        return this.maxHeight;
    }

    /* renamed from: setMaxHeight-0680j_4, reason: not valid java name */
    public final void m1109setMaxHeight0680j_4(float f) {
        this.maxHeight = f;
    }

    public final boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    public final void setEnforceIncoming(boolean z) {
        this.enforceIncoming = z;
    }

    private SizeNode(float f, float f2, float f3, float f4, boolean z) {
        this.minWidth = f;
        this.minHeight = f2;
        this.maxWidth = f3;
        this.maxHeight = f4;
        this.enforceIncoming = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
    
        if (r4 != Integer.MAX_VALUE) goto L24;
     */
    /* renamed from: getTargetConstraints-OenEA2s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long m1104getTargetConstraintsOenEA2s(androidx.compose.ui.unit.Density r7) {
        /*
            r6 = this;
            float r0 = r6.maxWidth
            boolean r0 = java.lang.Float.isNaN(r0)
            r1 = 2147483647(0x7fffffff, float:NaN)
            r2 = 0
            if (r0 != 0) goto L16
            float r0 = r6.maxWidth
            int r0 = r7.mo694roundToPx0680j_4(r0)
            if (r0 >= 0) goto L17
            r0 = r2
            goto L17
        L16:
            r0 = r1
        L17:
            float r3 = r6.maxHeight
            boolean r3 = java.lang.Float.isNaN(r3)
            if (r3 != 0) goto L29
            float r3 = r6.maxHeight
            int r3 = r7.mo694roundToPx0680j_4(r3)
            if (r3 >= 0) goto L2a
            r3 = r2
            goto L2a
        L29:
            r3 = r1
        L2a:
            float r4 = r6.minWidth
            boolean r4 = java.lang.Float.isNaN(r4)
            if (r4 != 0) goto L41
            float r4 = r6.minWidth
            int r4 = r7.mo694roundToPx0680j_4(r4)
            if (r4 >= 0) goto L3b
            r4 = r2
        L3b:
            if (r4 <= r0) goto L3e
            r4 = r0
        L3e:
            if (r4 == r1) goto L41
            goto L42
        L41:
            r4 = r2
        L42:
            float r5 = r6.minHeight
            boolean r5 = java.lang.Float.isNaN(r5)
            if (r5 != 0) goto L59
            float r6 = r6.minHeight
            int r6 = r7.mo694roundToPx0680j_4(r6)
            if (r6 >= 0) goto L53
            r6 = r2
        L53:
            if (r6 <= r3) goto L56
            r6 = r3
        L56:
            if (r6 == r1) goto L59
            r2 = r6
        L59:
            long r6 = androidx.compose.ui.unit.ConstraintsKt.Constraints(r4, r0, r2, r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.SizeNode.m1104getTargetConstraintsOenEA2s(androidx.compose.ui.unit.Density):long");
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo384measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int m6944getMinWidthimpl;
        int m6942getMaxWidthimpl;
        int m6943getMinHeightimpl;
        int m6941getMaxHeightimpl;
        long Constraints;
        long m1104getTargetConstraintsOenEA2s = m1104getTargetConstraintsOenEA2s(measureScope);
        if (this.enforceIncoming) {
            Constraints = ConstraintsKt.m6957constrainN9IONVI(j, m1104getTargetConstraintsOenEA2s);
        } else {
            if (!Float.isNaN(this.minWidth)) {
                m6944getMinWidthimpl = Constraints.m6944getMinWidthimpl(m1104getTargetConstraintsOenEA2s);
            } else {
                m6944getMinWidthimpl = Constraints.m6944getMinWidthimpl(j);
                int m6942getMaxWidthimpl2 = Constraints.m6942getMaxWidthimpl(m1104getTargetConstraintsOenEA2s);
                if (m6944getMinWidthimpl > m6942getMaxWidthimpl2) {
                    m6944getMinWidthimpl = m6942getMaxWidthimpl2;
                }
            }
            if (!Float.isNaN(this.maxWidth)) {
                m6942getMaxWidthimpl = Constraints.m6942getMaxWidthimpl(m1104getTargetConstraintsOenEA2s);
            } else {
                m6942getMaxWidthimpl = Constraints.m6942getMaxWidthimpl(j);
                int m6944getMinWidthimpl2 = Constraints.m6944getMinWidthimpl(m1104getTargetConstraintsOenEA2s);
                if (m6942getMaxWidthimpl < m6944getMinWidthimpl2) {
                    m6942getMaxWidthimpl = m6944getMinWidthimpl2;
                }
            }
            if (!Float.isNaN(this.minHeight)) {
                m6943getMinHeightimpl = Constraints.m6943getMinHeightimpl(m1104getTargetConstraintsOenEA2s);
            } else {
                m6943getMinHeightimpl = Constraints.m6943getMinHeightimpl(j);
                int m6941getMaxHeightimpl2 = Constraints.m6941getMaxHeightimpl(m1104getTargetConstraintsOenEA2s);
                if (m6943getMinHeightimpl > m6941getMaxHeightimpl2) {
                    m6943getMinHeightimpl = m6941getMaxHeightimpl2;
                }
            }
            if (!Float.isNaN(this.maxHeight)) {
                m6941getMaxHeightimpl = Constraints.m6941getMaxHeightimpl(m1104getTargetConstraintsOenEA2s);
            } else {
                m6941getMaxHeightimpl = Constraints.m6941getMaxHeightimpl(j);
                int m6943getMinHeightimpl2 = Constraints.m6943getMinHeightimpl(m1104getTargetConstraintsOenEA2s);
                if (m6941getMaxHeightimpl < m6943getMinHeightimpl2) {
                    m6941getMaxHeightimpl = m6943getMinHeightimpl2;
                }
            }
            Constraints = ConstraintsKt.Constraints(m6944getMinWidthimpl, m6942getMaxWidthimpl, m6943getMinHeightimpl, m6941getMaxHeightimpl);
        }
        final Placeable mo5732measureBRTryo0 = measurable.mo5732measureBRTryo0(Constraints);
        return MeasureScope.layout$default(measureScope, mo5732measureBRTryo0.getWidth(), mo5732measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.SizeNode$measure$1
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
        long m1104getTargetConstraintsOenEA2s = m1104getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m6940getHasFixedWidthimpl(m1104getTargetConstraintsOenEA2s)) {
            return Constraints.m6942getMaxWidthimpl(m1104getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m6958constrainHeightK40F9xA(m1104getTargetConstraintsOenEA2s, i);
        }
        return ConstraintsKt.m6959constrainWidthK40F9xA(m1104getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long m1104getTargetConstraintsOenEA2s = m1104getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m6939getHasFixedHeightimpl(m1104getTargetConstraintsOenEA2s)) {
            return Constraints.m6941getMaxHeightimpl(m1104getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m6959constrainWidthK40F9xA(m1104getTargetConstraintsOenEA2s, i);
        }
        return ConstraintsKt.m6958constrainHeightK40F9xA(m1104getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long m1104getTargetConstraintsOenEA2s = m1104getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m6940getHasFixedWidthimpl(m1104getTargetConstraintsOenEA2s)) {
            return Constraints.m6942getMaxWidthimpl(m1104getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m6958constrainHeightK40F9xA(m1104getTargetConstraintsOenEA2s, i);
        }
        return ConstraintsKt.m6959constrainWidthK40F9xA(m1104getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long m1104getTargetConstraintsOenEA2s = m1104getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m6939getHasFixedHeightimpl(m1104getTargetConstraintsOenEA2s)) {
            return Constraints.m6941getMaxHeightimpl(m1104getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m6959constrainWidthK40F9xA(m1104getTargetConstraintsOenEA2s, i);
        }
        return ConstraintsKt.m6958constrainHeightK40F9xA(m1104getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicHeight(i));
    }
}
