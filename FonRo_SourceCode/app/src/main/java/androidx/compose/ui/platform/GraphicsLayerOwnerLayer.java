package androidx.compose.ui.platform;

import android.os.Build;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.Fields;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.MatrixKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GraphicsLayerOwnerLayer.android.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002Bg\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00128\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\n\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0002\u0010\u0013J\b\u0010@\u001a\u00020\u0010H\u0016J\u001a\u0010A\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0017\u0010B\u001a\u0004\u0018\u00010\u0019H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010?J\u0015\u0010D\u001a\u00020\u0019H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010?J\b\u0010F\u001a\u00020\u0010H\u0016J\u001a\u0010G\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ\u001a\u0010K\u001a\u00020\u00172\u0006\u0010L\u001a\u00020MH\u0016ø\u0001\u0000¢\u0006\u0004\bN\u0010OJ\u0018\u0010P\u001a\u00020\u00102\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0017H\u0016J\"\u0010T\u001a\u00020M2\u0006\u0010U\u001a\u00020M2\u0006\u0010S\u001a\u00020\u0017H\u0016ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ\u001a\u0010X\u001a\u00020\u00102\u0006\u0010L\u001a\u00020YH\u0016ø\u0001\u0000¢\u0006\u0004\bZ\u0010[J\u001a\u0010\\\u001a\u00020\u00102\u0006\u00106\u001a\u000207H\u0016ø\u0001\u0000¢\u0006\u0004\b]\u0010[JP\u0010^\u001a\u00020\u001028\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0016J\u001a\u0010_\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\b`\u0010JJ\b\u0010a\u001a\u00020\u0010H\u0002J\b\u0010b\u001a\u00020\u0010H\u0016J\u0010\u0010c\u001a\u00020\u00102\u0006\u00104\u001a\u00020dH\u0016J\b\u0010e\u001a\u00020\u0010H\u0002J\b\u0010f\u001a\u00020\u0010H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010\t\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\u00020\u0019X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010&R\u001f\u00100\u001a\u0013\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u001001¢\u0006\u0002\b3X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00106\u001a\u000207X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00108R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010;\u001a\u00020<X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00108R\u001a\u0010=\u001a\u00020\u00198VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b>\u0010?\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006g"}, d2 = {"Landroidx/compose/ui/platform/GraphicsLayerOwnerLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "context", "Landroidx/compose/ui/graphics/GraphicsContext;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "canvas", "parentLayer", "", "invalidateParentLayer", "Lkotlin/Function0;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "density", "Landroidx/compose/ui/unit/Density;", "drawnWithEnabledZ", "", "inverseMatrixCache", "Landroidx/compose/ui/graphics/Matrix;", "[F", "isDestroyed", "value", "isDirty", "setDirty", "(Z)V", "isIdentity", "isInverseMatrixDirty", "isMatrixDirty", "layerId", "", "getLayerId", "()J", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "matrixCache", "mutatedFields", "", "outline", "Landroidx/compose/ui/graphics/Outline;", "ownerViewId", "getOwnerViewId", "recordLambda", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "scope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "underlyingMatrix", "getUnderlyingMatrix-sQKQjiQ", "()[F", "destroy", "drawLayer", "getInverseMatrix", "getInverseMatrix-3i98HWw", "getMatrix", "getMatrix-sQKQjiQ", "invalidate", "inverseTransform", "matrix", "inverseTransform-58bKbWc", "([F)V", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "resize-ozmzZPI", "reuseLayer", "transform", "transform-58bKbWc", "triggerRepaint", "updateDisplayList", "updateLayerProperties", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "updateMatrix", "updateOutline", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class GraphicsLayerOwnerLayer implements OwnedLayer, GraphicLayerInfo {
    public static final int $stable = 8;
    private final GraphicsContext context;
    private Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock;
    private boolean drawnWithEnabledZ;
    private GraphicsLayer graphicsLayer;
    private Function0<Unit> invalidateParentLayer;
    private float[] inverseMatrixCache;
    private boolean isDestroyed;
    private boolean isDirty;
    private boolean isInverseMatrixDirty;
    private boolean isMatrixDirty;
    private int mutatedFields;
    private Outline outline;
    private final AndroidComposeView ownerView;
    private Paint softwareLayerPaint;
    private long size = IntSize.m7155constructorimpl(9223372034707292159L);
    private final float[] matrixCache = Matrix.m4614constructorimpl$default(null, 1, null);
    private Density density = DensityKt.Density$default(1.0f, 0.0f, 2, null);
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private final CanvasDrawScope scope = new CanvasDrawScope();
    private long transformOrigin = TransformOrigin.INSTANCE.m4775getCenterSzJe1aQ();
    private boolean isIdentity = true;
    private final Function1<DrawScope, Unit> recordLambda = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.platform.GraphicsLayerOwnerLayer$recordLambda$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
            invoke2(drawScope);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DrawScope drawScope) {
            Function2 function2;
            GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = GraphicsLayerOwnerLayer.this;
            Canvas canvas = drawScope.getDrawContext().getCanvas();
            function2 = graphicsLayerOwnerLayer.drawBlock;
            if (function2 != null) {
                function2.invoke(canvas, drawScope.getDrawContext().getGraphicsLayer());
            }
        }
    };

    public GraphicsLayerOwnerLayer(GraphicsLayer graphicsLayer, GraphicsContext graphicsContext, AndroidComposeView androidComposeView, Function2<? super Canvas, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0) {
        this.graphicsLayer = graphicsLayer;
        this.context = graphicsContext;
        this.ownerView = androidComposeView;
        this.drawBlock = function2;
        this.invalidateParentLayer = function0;
    }

    private final void setDirty(boolean z) {
        if (z != this.isDirty) {
            this.isDirty = z;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateLayerProperties(ReusableGraphicsLayerScope scope) {
        int m5016getModulateAlphake2Ky5w;
        Function0<Unit> function0;
        int mutatedFields = scope.getMutatedFields() | this.mutatedFields;
        this.layoutDirection = scope.getLayoutDirection();
        this.density = scope.getGraphicsDensity();
        int i = mutatedFields & 4096;
        if (i != 0) {
            this.transformOrigin = scope.getTransformOrigin();
        }
        if ((mutatedFields & 1) != 0) {
            this.graphicsLayer.setScaleX(scope.getScaleX());
        }
        if ((mutatedFields & 2) != 0) {
            this.graphicsLayer.setScaleY(scope.getScaleY());
        }
        if ((mutatedFields & 4) != 0) {
            this.graphicsLayer.setAlpha(scope.getAlpha());
        }
        if ((mutatedFields & 8) != 0) {
            this.graphicsLayer.setTranslationX(scope.getTranslationX());
        }
        if ((mutatedFields & 16) != 0) {
            this.graphicsLayer.setTranslationY(scope.getTranslationY());
        }
        if ((mutatedFields & 32) != 0) {
            this.graphicsLayer.setShadowElevation(scope.getShadowElevation());
            if (scope.getShadowElevation() > 0.0f && !this.drawnWithEnabledZ && (function0 = this.invalidateParentLayer) != null) {
                function0.invoke();
            }
        }
        if ((mutatedFields & 64) != 0) {
            this.graphicsLayer.m5030setAmbientShadowColor8_81llA(scope.getAmbientShadowColor());
        }
        if ((mutatedFields & 128) != 0) {
            this.graphicsLayer.m5036setSpotShadowColor8_81llA(scope.getSpotShadowColor());
        }
        if ((mutatedFields & 1024) != 0) {
            this.graphicsLayer.setRotationZ(scope.getRotationZ());
        }
        if ((mutatedFields & 256) != 0) {
            this.graphicsLayer.setRotationX(scope.getRotationX());
        }
        if ((mutatedFields & 512) != 0) {
            this.graphicsLayer.setRotationY(scope.getRotationY());
        }
        if ((mutatedFields & 2048) != 0) {
            this.graphicsLayer.setCameraDistance(scope.getCameraDistance());
        }
        if (i != 0) {
            boolean m4769equalsimpl0 = TransformOrigin.m4769equalsimpl0(this.transformOrigin, TransformOrigin.INSTANCE.m4775getCenterSzJe1aQ());
            GraphicsLayer graphicsLayer = this.graphicsLayer;
            if (m4769equalsimpl0) {
                graphicsLayer.m5033setPivotOffsetk4lQ0M(Offset.INSTANCE.m4140getUnspecifiedF1C5BW0());
            } else {
                float m4770getPivotFractionXimpl = TransformOrigin.m4770getPivotFractionXimpl(this.transformOrigin) * ((int) (this.size >> 32));
                graphicsLayer.m5033setPivotOffsetk4lQ0M(Offset.m4117constructorimpl((Float.floatToRawIntBits(TransformOrigin.m4771getPivotFractionYimpl(this.transformOrigin) * ((int) (this.size & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits(m4770getPivotFractionXimpl) << 32)));
            }
        }
        if ((mutatedFields & 16384) != 0) {
            this.graphicsLayer.setClip(scope.getClip());
        }
        if ((131072 & mutatedFields) != 0) {
            this.graphicsLayer.setRenderEffect(scope.getRenderEffect());
        }
        if ((32768 & mutatedFields) != 0) {
            GraphicsLayer graphicsLayer2 = this.graphicsLayer;
            int compositingStrategy = scope.getCompositingStrategy();
            if (CompositingStrategy.m4468equalsimpl0(compositingStrategy, CompositingStrategy.INSTANCE.m4472getAutoNrFUSI())) {
                m5016getModulateAlphake2Ky5w = androidx.compose.ui.graphics.layer.CompositingStrategy.INSTANCE.m5015getAutoke2Ky5w();
            } else if (CompositingStrategy.m4468equalsimpl0(compositingStrategy, CompositingStrategy.INSTANCE.m4474getOffscreenNrFUSI())) {
                m5016getModulateAlphake2Ky5w = androidx.compose.ui.graphics.layer.CompositingStrategy.INSTANCE.m5017getOffscreenke2Ky5w();
            } else {
                if (!CompositingStrategy.m4468equalsimpl0(compositingStrategy, CompositingStrategy.INSTANCE.m4473getModulateAlphaNrFUSI())) {
                    throw new IllegalStateException("Not supported composition strategy");
                }
                m5016getModulateAlphake2Ky5w = androidx.compose.ui.graphics.layer.CompositingStrategy.INSTANCE.m5016getModulateAlphake2Ky5w();
            }
            graphicsLayer2.m5032setCompositingStrategyWpw9cng(m5016getModulateAlphake2Ky5w);
        }
        boolean z = true;
        if ((mutatedFields & Fields.MatrixAffectingFields) != 0) {
            this.isMatrixDirty = true;
            this.isInverseMatrixDirty = true;
        }
        if (Intrinsics.areEqual(this.outline, scope.getOutline())) {
            z = false;
        } else {
            this.outline = scope.getOutline();
            updateOutline();
        }
        this.mutatedFields = scope.getMutatedFields();
        if (mutatedFields != 0 || z) {
            triggerRepaint();
        }
    }

    private final void triggerRepaint() {
        if (Build.VERSION.SDK_INT >= 26) {
            WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(this.ownerView);
        } else {
            this.ownerView.invalidate();
        }
    }

    private final void updateOutline() {
        Function0<Unit> function0;
        Outline outline = this.outline;
        if (outline == null) {
            return;
        }
        GraphicsLayerKt.setOutline(this.graphicsLayer, outline);
        if (!(outline instanceof Outline.Generic) || Build.VERSION.SDK_INT >= 33 || (function0 = this.invalidateParentLayer) == null) {
            return;
        }
        function0.invoke();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: move--gyyYBs */
    public void mo6049movegyyYBs(long position) {
        this.graphicsLayer.m5037setTopLeftgyyYBs(position);
        triggerRepaint();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: resize-ozmzZPI */
    public void mo6050resizeozmzZPI(long size) {
        if (IntSize.m7158equalsimpl0(size, this.size)) {
            return;
        }
        this.size = size;
        invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void drawLayer(Canvas canvas, GraphicsLayer parentLayer) {
        updateDisplayList();
        this.drawnWithEnabledZ = this.graphicsLayer.getShadowElevation() > 0.0f;
        DrawContext drawContext = this.scope.getDrawContext();
        drawContext.setCanvas(canvas);
        drawContext.setGraphicsLayer(parentLayer);
        GraphicsLayerKt.drawLayer(this.scope, this.graphicsLayer);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateDisplayList() {
        if (this.isDirty) {
            if (!TransformOrigin.m4769equalsimpl0(this.transformOrigin, TransformOrigin.INSTANCE.m4775getCenterSzJe1aQ()) && !IntSize.m7158equalsimpl0(this.graphicsLayer.getSize(), this.size)) {
                GraphicsLayer graphicsLayer = this.graphicsLayer;
                float m4770getPivotFractionXimpl = TransformOrigin.m4770getPivotFractionXimpl(this.transformOrigin) * ((int) (this.size >> 32));
                float m4771getPivotFractionYimpl = TransformOrigin.m4771getPivotFractionYimpl(this.transformOrigin) * ((int) (this.size & 4294967295L));
                graphicsLayer.m5033setPivotOffsetk4lQ0M(Offset.m4117constructorimpl((Float.floatToRawIntBits(m4771getPivotFractionYimpl) & 4294967295L) | (Float.floatToRawIntBits(m4770getPivotFractionXimpl) << 32)));
            }
            this.graphicsLayer.m5029recordmLhObY(this.density, this.layoutDirection, this.size, this.recordLambda);
            setDirty(false);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void invalidate() {
        if (this.isDirty || this.isDestroyed) {
            return;
        }
        this.ownerView.invalidate();
        setDirty(true);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
        GraphicsContext graphicsContext = this.context;
        if (graphicsContext != null) {
            graphicsContext.releaseGraphicsLayer(this.graphicsLayer);
            this.ownerView.recycle$ui_release(this);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: mapOffset-8S9VItk */
    public long mo6048mapOffset8S9VItk(long point, boolean inverse) {
        float[] m6142getMatrixsQKQjiQ;
        if (inverse) {
            m6142getMatrixsQKQjiQ = m6141getInverseMatrix3i98HWw();
            if (m6142getMatrixsQKQjiQ == null) {
                return Offset.INSTANCE.m4139getInfiniteF1C5BW0();
            }
        } else {
            m6142getMatrixsQKQjiQ = m6142getMatrixsQKQjiQ();
        }
        return this.isIdentity ? point : Matrix.m4620mapMKHz9U(m6142getMatrixsQKQjiQ, point);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void mapBounds(MutableRect rect, boolean inverse) {
        float[] m6141getInverseMatrix3i98HWw = inverse ? m6141getInverseMatrix3i98HWw() : m6142getMatrixsQKQjiQ();
        if (this.isIdentity) {
            return;
        }
        if (m6141getInverseMatrix3i98HWw == null) {
            rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            Matrix.m4622mapimpl(m6141getInverseMatrix3i98HWw, rect);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void reuseLayer(Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        GraphicsContext graphicsContext = this.context;
        if (graphicsContext != null) {
            if (!this.graphicsLayer.getIsReleased()) {
                InlineClassHelperKt.throwIllegalArgumentException("layer should have been released before reuse");
            }
            this.graphicsLayer = graphicsContext.createGraphicsLayer();
            this.isDestroyed = false;
            this.drawBlock = drawBlock;
            this.invalidateParentLayer = invalidateParentLayer;
            this.isMatrixDirty = false;
            this.isInverseMatrixDirty = false;
            this.isIdentity = true;
            Matrix.m4623resetimpl(this.matrixCache);
            float[] fArr = this.inverseMatrixCache;
            if (fArr != null) {
                Matrix.m4623resetimpl(fArr);
            }
            this.transformOrigin = TransformOrigin.INSTANCE.m4775getCenterSzJe1aQ();
            this.drawnWithEnabledZ = false;
            this.size = IntSize.m7155constructorimpl(9223372034707292159L);
            this.outline = null;
            this.mutatedFields = 0;
            return;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("currently reuse is only supported when we manage the layer lifecycle");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: transform-58bKbWc */
    public void mo6051transform58bKbWc(float[] matrix) {
        Matrix.m4633timesAssign58bKbWc(matrix, m6142getMatrixsQKQjiQ());
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: inverseTransform-58bKbWc */
    public void mo6046inverseTransform58bKbWc(float[] matrix) {
        float[] m6141getInverseMatrix3i98HWw = m6141getInverseMatrix3i98HWw();
        if (m6141getInverseMatrix3i98HWw != null) {
            Matrix.m4633timesAssign58bKbWc(matrix, m6141getInverseMatrix3i98HWw);
        }
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getLayerId() {
        return this.graphicsLayer.getLayerId();
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getOwnerViewId() {
        return this.graphicsLayer.getOwnerViewId();
    }

    /* renamed from: getMatrix-sQKQjiQ, reason: not valid java name */
    private final float[] m6142getMatrixsQKQjiQ() {
        updateMatrix();
        return this.matrixCache;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: getUnderlyingMatrix-sQKQjiQ */
    public float[] mo6045getUnderlyingMatrixsQKQjiQ() {
        return m6142getMatrixsQKQjiQ();
    }

    /* renamed from: getInverseMatrix-3i98HWw, reason: not valid java name */
    private final float[] m6141getInverseMatrix3i98HWw() {
        float[] fArr = this.inverseMatrixCache;
        if (fArr == null) {
            fArr = Matrix.m4614constructorimpl$default(null, 1, null);
            this.inverseMatrixCache = fArr;
        }
        if (!this.isInverseMatrixDirty) {
            if (Float.isNaN(fArr[0])) {
                return null;
            }
        } else {
            this.isInverseMatrixDirty = false;
            float[] m6142getMatrixsQKQjiQ = m6142getMatrixsQKQjiQ();
            if (this.isIdentity) {
                return m6142getMatrixsQKQjiQ;
            }
            if (!InvertMatrixKt.m6143invertToJiSxe2E(m6142getMatrixsQKQjiQ, fArr)) {
                fArr[0] = Float.NaN;
                return null;
            }
        }
        return fArr;
    }

    private final void updateMatrix() {
        long pivotOffset;
        if (this.isMatrixDirty) {
            GraphicsLayer graphicsLayer = this.graphicsLayer;
            if ((graphicsLayer.getPivotOffset() & 9223372034707292159L) == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
                pivotOffset = SizeKt.m4204getCenteruvyYCjk(IntSizeKt.m7172toSizeozmzZPI(this.size));
            } else {
                pivotOffset = graphicsLayer.getPivotOffset();
            }
            Matrix.m4624resetToPivotedTransformimpl(this.matrixCache, Float.intBitsToFloat((int) (pivotOffset >> 32)), Float.intBitsToFloat((int) (pivotOffset & 4294967295L)), graphicsLayer.getTranslationX(), graphicsLayer.getTranslationY(), 1.0f, graphicsLayer.getRotationX(), graphicsLayer.getRotationY(), graphicsLayer.getRotationZ(), graphicsLayer.getScaleX(), graphicsLayer.getScaleY(), 1.0f);
            this.isMatrixDirty = false;
            this.isIdentity = MatrixKt.m4639isIdentity58bKbWc(this.matrixCache);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: isInLayer-k-4lQ0M */
    public boolean mo6047isInLayerk4lQ0M(long position) {
        float intBitsToFloat = Float.intBitsToFloat((int) (position >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (position & 4294967295L));
        if (this.graphicsLayer.getClip()) {
            return ShapeContainingUtilKt.isInOutline$default(this.graphicsLayer.getOutline(), intBitsToFloat, intBitsToFloat2, null, null, 24, null);
        }
        return true;
    }
}
