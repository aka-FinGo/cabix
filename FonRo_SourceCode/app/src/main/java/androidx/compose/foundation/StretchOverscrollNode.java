package androidx.compose.foundation;

import android.graphics.Canvas;
import android.graphics.RenderNode;
import android.widget.EdgeEffect;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: AndroidOverscroll.android.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002J\u001c\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002J\u001c\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002J\u001c\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002J$\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002J\b\u0010 \u001a\u00020\u0010H\u0002J\b\u0010!\u001a\u00020\u0010H\u0002J\f\u0010\"\u001a\u00020#*\u00020$H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006%"}, d2 = {"Landroidx/compose/foundation/StretchOverscrollNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "pointerInputNode", "Landroidx/compose/ui/node/DelegatableNode;", "overscrollEffect", "Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;Landroidx/compose/foundation/EdgeEffectWrapper;)V", "_renderNode", "Landroid/graphics/RenderNode;", "renderNode", "getRenderNode", "()Landroid/graphics/RenderNode;", "drawBottomStretch", "", "bottom", "Landroid/widget/EdgeEffect;", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawLeftStretch", "left", "drawRightStretch", "right", "drawTopStretch", "top", "drawWithRotation", "rotationDegrees", "", "edgeEffect", "shouldDrawHorizontalStretch", "shouldDrawVerticalStretch", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class StretchOverscrollNode extends DelegatingNode implements DrawModifierNode {
    private RenderNode _renderNode;
    private final EdgeEffectWrapper edgeEffectWrapper;
    private final AndroidEdgeEffectOverscrollEffect overscrollEffect;

    public StretchOverscrollNode(DelegatableNode delegatableNode, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, EdgeEffectWrapper edgeEffectWrapper) {
        this.overscrollEffect = androidEdgeEffectOverscrollEffect;
        this.edgeEffectWrapper = edgeEffectWrapper;
        delegate(delegatableNode);
    }

    private final RenderNode getRenderNode() {
        RenderNode renderNode = this._renderNode;
        if (renderNode != null) {
            return renderNode;
        }
        RenderNode m = ComponentDialog$$ExternalSyntheticApiModelOutline0.m("AndroidEdgeEffectOverscrollEffect");
        this._renderNode = m;
        return m;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01f5  */
    @Override // androidx.compose.ui.node.DrawModifierNode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(androidx.compose.ui.graphics.drawscope.ContentDrawScope r20) {
        /*
            Method dump skipped, instructions count: 706
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.StretchOverscrollNode.draw(androidx.compose.ui.graphics.drawscope.ContentDrawScope):void");
    }

    private final boolean shouldDrawVerticalStretch() {
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        return edgeEffectWrapper.isTopAnimating() || edgeEffectWrapper.isTopNegationStretched() || edgeEffectWrapper.isBottomAnimating() || edgeEffectWrapper.isBottomNegationStretched();
    }

    private final boolean shouldDrawHorizontalStretch() {
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        return edgeEffectWrapper.isLeftAnimating() || edgeEffectWrapper.isLeftNegationStretched() || edgeEffectWrapper.isRightAnimating() || edgeEffectWrapper.isRightNegationStretched();
    }

    private final boolean drawLeftStretch(EdgeEffect left, Canvas canvas) {
        return drawWithRotation(270.0f, left, canvas);
    }

    private final boolean drawTopStretch(EdgeEffect top, Canvas canvas) {
        return drawWithRotation(0.0f, top, canvas);
    }

    private final boolean drawRightStretch(EdgeEffect right, Canvas canvas) {
        return drawWithRotation(90.0f, right, canvas);
    }

    private final boolean drawBottomStretch(EdgeEffect bottom, Canvas canvas) {
        return drawWithRotation(180.0f, bottom, canvas);
    }

    private final boolean drawWithRotation(float rotationDegrees, EdgeEffect edgeEffect, Canvas canvas) {
        if (rotationDegrees == 0.0f) {
            return edgeEffect.draw(canvas);
        }
        int save = canvas.save();
        canvas.rotate(rotationDegrees);
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }
}
