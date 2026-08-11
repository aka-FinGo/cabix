package coil.compose;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactor;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* compiled from: ContentPainterModifier.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010(\u001a\u00020)*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u001c\u00101\u001a\u000202*\u0002032\u0006\u0010+\u001a\u0002042\u0006\u00105\u001a\u000202H\u0016J\u001c\u00106\u001a\u000202*\u0002032\u0006\u0010+\u001a\u0002042\u0006\u00105\u001a\u000202H\u0016J\u001c\u00107\u001a\u000202*\u0002032\u0006\u0010+\u001a\u0002042\u0006\u00108\u001a\u000202H\u0016J\u001c\u00109\u001a\u000202*\u0002032\u0006\u0010+\u001a\u0002042\u0006\u00108\u001a\u000202H\u0016J\u0017\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;H\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020.2\u0006\u0010-\u001a\u00020.H\u0002¢\u0006\u0004\b@\u0010>J\f\u0010A\u001a\u00020B*\u00020CH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006D"}, d2 = {"Lcoil/compose/ContentPainterNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "modifyConstraints-ZezNO4M", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "coil-compose-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class ContentPainterNode extends Modifier.Node implements DrawModifierNode, LayoutModifierNode {
    public static final int $stable = 8;
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final Painter getPainter() {
        return this.painter;
    }

    public final void setPainter(Painter painter) {
        this.painter = painter;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final void setContentScale(ContentScale contentScale) {
        this.contentScale = contentScale;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    public ContentPainterNode(Painter painter, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        this.painter = painter;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo384measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable mo5732measureBRTryo0 = measurable.mo5732measureBRTryo0(m7626modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measureScope, mo5732measureBRTryo0.getWidth(), mo5732measureBRTryo0.getHeight(), null, new Function1() { // from class: coil.compose.ContentPainterNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ContentPainterNode.measure_3p2s80s$lambda$0(Placeable.this, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize() != Size.INSTANCE.m4202getUnspecifiedNHjbRc()) {
            int minIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(Constraints.m6941getMaxHeightimpl(m7626modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null))));
            return Math.max(MathKt.roundToInt(Size.m4194getWidthimpl(m7625calculateScaledSizeE7KxVPU(SizeKt.Size(minIntrinsicWidth, i)))), minIntrinsicWidth);
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize() != Size.INSTANCE.m4202getUnspecifiedNHjbRc()) {
            int maxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(Constraints.m6941getMaxHeightimpl(m7626modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null))));
            return Math.max(MathKt.roundToInt(Size.m4194getWidthimpl(m7625calculateScaledSizeE7KxVPU(SizeKt.Size(maxIntrinsicWidth, i)))), maxIntrinsicWidth);
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize() != Size.INSTANCE.m4202getUnspecifiedNHjbRc()) {
            int minIntrinsicHeight = intrinsicMeasurable.minIntrinsicHeight(Constraints.m6942getMaxWidthimpl(m7626modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null))));
            return Math.max(MathKt.roundToInt(Size.m4191getHeightimpl(m7625calculateScaledSizeE7KxVPU(SizeKt.Size(i, minIntrinsicHeight)))), minIntrinsicHeight);
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize() != Size.INSTANCE.m4202getUnspecifiedNHjbRc()) {
            int maxIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(Constraints.m6942getMaxWidthimpl(m7626modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null))));
            return Math.max(MathKt.roundToInt(Size.m4191getHeightimpl(m7625calculateScaledSizeE7KxVPU(SizeKt.Size(i, maxIntrinsicHeight)))), maxIntrinsicHeight);
        }
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    /* renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m7625calculateScaledSizeE7KxVPU(long dstSize) {
        if (Size.m4196isEmptyimpl(dstSize)) {
            return Size.INSTANCE.m4203getZeroNHjbRc();
        }
        long intrinsicSize = this.painter.getIntrinsicSize();
        if (intrinsicSize == Size.INSTANCE.m4202getUnspecifiedNHjbRc()) {
            return dstSize;
        }
        float m4194getWidthimpl = Size.m4194getWidthimpl(intrinsicSize);
        if (Float.isInfinite(m4194getWidthimpl) || Float.isNaN(m4194getWidthimpl)) {
            m4194getWidthimpl = Size.m4194getWidthimpl(dstSize);
        }
        float m4191getHeightimpl = Size.m4191getHeightimpl(intrinsicSize);
        if (Float.isInfinite(m4191getHeightimpl) || Float.isNaN(m4191getHeightimpl)) {
            m4191getHeightimpl = Size.m4191getHeightimpl(dstSize);
        }
        long Size = SizeKt.Size(m4194getWidthimpl, m4191getHeightimpl);
        long mo5725computeScaleFactorH7hwNQA = this.contentScale.mo5725computeScaleFactorH7hwNQA(Size, dstSize);
        float m5821getScaleXimpl = ScaleFactor.m5821getScaleXimpl(mo5725computeScaleFactorH7hwNQA);
        if (!Float.isInfinite(m5821getScaleXimpl) && !Float.isNaN(m5821getScaleXimpl)) {
            float m5822getScaleYimpl = ScaleFactor.m5822getScaleYimpl(mo5725computeScaleFactorH7hwNQA);
            if (!Float.isInfinite(m5822getScaleYimpl) && !Float.isNaN(m5822getScaleYimpl)) {
                return ScaleFactorKt.m5837timesmw2e94(mo5725computeScaleFactorH7hwNQA, Size);
            }
        }
        return dstSize;
    }

    /* renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m7626modifyConstraintsZezNO4M(long constraints) {
        float m6944getMinWidthimpl;
        int m6943getMinHeightimpl;
        float m7655constrainHeightK40F9xA;
        boolean m6940getHasFixedWidthimpl = Constraints.m6940getHasFixedWidthimpl(constraints);
        boolean m6939getHasFixedHeightimpl = Constraints.m6939getHasFixedHeightimpl(constraints);
        if (!m6940getHasFixedWidthimpl || !m6939getHasFixedHeightimpl) {
            boolean z = Constraints.m6938getHasBoundedWidthimpl(constraints) && Constraints.m6937getHasBoundedHeightimpl(constraints);
            long intrinsicSize = this.painter.getIntrinsicSize();
            if (intrinsicSize != Size.INSTANCE.m4202getUnspecifiedNHjbRc()) {
                if (z && (m6940getHasFixedWidthimpl || m6939getHasFixedHeightimpl)) {
                    m6944getMinWidthimpl = Constraints.m6942getMaxWidthimpl(constraints);
                    m6943getMinHeightimpl = Constraints.m6941getMaxHeightimpl(constraints);
                } else {
                    float m4194getWidthimpl = Size.m4194getWidthimpl(intrinsicSize);
                    float m4191getHeightimpl = Size.m4191getHeightimpl(intrinsicSize);
                    m6944getMinWidthimpl = (Float.isInfinite(m4194getWidthimpl) || Float.isNaN(m4194getWidthimpl)) ? Constraints.m6944getMinWidthimpl(constraints) : UtilsKt.m7656constrainWidthK40F9xA(constraints, m4194getWidthimpl);
                    if (Float.isInfinite(m4191getHeightimpl) || Float.isNaN(m4191getHeightimpl)) {
                        m6943getMinHeightimpl = Constraints.m6943getMinHeightimpl(constraints);
                    } else {
                        m7655constrainHeightK40F9xA = UtilsKt.m7655constrainHeightK40F9xA(constraints, m4191getHeightimpl);
                        long m7625calculateScaledSizeE7KxVPU = m7625calculateScaledSizeE7KxVPU(SizeKt.Size(m6944getMinWidthimpl, m7655constrainHeightK40F9xA));
                        return Constraints.m6932copyZbe2FdA$default(constraints, ConstraintsKt.m6959constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.m4194getWidthimpl(m7625calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m6958constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.m4191getHeightimpl(m7625calculateScaledSizeE7KxVPU))), 0, 10, null);
                    }
                }
                m7655constrainHeightK40F9xA = m6943getMinHeightimpl;
                long m7625calculateScaledSizeE7KxVPU2 = m7625calculateScaledSizeE7KxVPU(SizeKt.Size(m6944getMinWidthimpl, m7655constrainHeightK40F9xA));
                return Constraints.m6932copyZbe2FdA$default(constraints, ConstraintsKt.m6959constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.m4194getWidthimpl(m7625calculateScaledSizeE7KxVPU2))), 0, ConstraintsKt.m6958constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.m4191getHeightimpl(m7625calculateScaledSizeE7KxVPU2))), 0, 10, null);
            }
            if (z) {
                return Constraints.m6932copyZbe2FdA$default(constraints, Constraints.m6942getMaxWidthimpl(constraints), 0, Constraints.m6941getMaxHeightimpl(constraints), 0, 10, null);
            }
        }
        return constraints;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        long m7625calculateScaledSizeE7KxVPU = m7625calculateScaledSizeE7KxVPU(contentDrawScope.mo4935getSizeNHjbRc());
        long mo3942alignKFBX0sM = this.alignment.mo3942alignKFBX0sM(UtilsKt.m7658toIntSizeuvyYCjk(m7625calculateScaledSizeE7KxVPU), UtilsKt.m7658toIntSizeuvyYCjk(contentDrawScope.mo4935getSizeNHjbRc()), contentDrawScope.getLayoutDirection());
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        float m7109component1impl = IntOffset.m7109component1impl(mo3942alignKFBX0sM);
        float m7110component2impl = IntOffset.m7110component2impl(mo3942alignKFBX0sM);
        contentDrawScope2.getDrawContext().getTransform().translate(m7109component1impl, m7110component2impl);
        this.painter.m5061drawx_KDEd0(contentDrawScope2, m7625calculateScaledSizeE7KxVPU, this.alpha, this.colorFilter);
        contentDrawScope2.getDrawContext().getTransform().translate(-m7109component1impl, -m7110component2impl);
        contentDrawScope.drawContent();
    }
}
