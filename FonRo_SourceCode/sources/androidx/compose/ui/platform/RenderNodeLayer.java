package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Fields;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.IntOffset;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: RenderNodeLayer.android.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0002XYBU\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00128\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\u0010\u0010J\u0010\u00103\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0007H\u0002J\b\u00104\u001a\u00020\rH\u0016J\u001a\u00105\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u00106\u001a\u00020\rH\u0016J\u001a\u00107\u001a\u00020\r2\u0006\u00108\u001a\u000200H\u0016ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001a\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020=H\u0016ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u0018\u0010@\u001a\u00020\r2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0014H\u0016J\"\u0010D\u001a\u00020=2\u0006\u0010E\u001a\u00020=2\u0006\u0010C\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001a\u0010H\u001a\u00020\r2\u0006\u0010<\u001a\u00020IH\u0016ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ\u001a\u0010L\u001a\u00020\r2\u0006\u0010M\u001a\u00020NH\u0016ø\u0001\u0000¢\u0006\u0004\bO\u0010KJP\u0010P\u001a\u00020\r28\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0016J\u001a\u0010Q\u001a\u00020\r2\u0006\u00108\u001a\u000200H\u0016ø\u0001\u0000¢\u0006\u0004\bR\u0010:J\b\u0010S\u001a\u00020\rH\u0002J\b\u0010T\u001a\u00020\rH\u0016J\u0010\u0010U\u001a\u00020\r2\u0006\u0010V\u001a\u00020WH\u0016R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u0005\u001a6\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u001dR\u000e\u0010)\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\u00020-X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010.R\u001a\u0010/\u001a\u0002008VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b1\u00102\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "canvas", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentLayer", "", "invalidateParentLayer", "Lkotlin/Function0;", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "drawnWithZ", "", "isDestroyed", "value", "isDirty", "setDirty", "(Z)V", "layerId", "", "getLayerId", "()J", "matrixCache", "Landroidx/compose/ui/platform/LayerMatrixCache;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "mutatedFields", "", "outlineResolver", "Landroidx/compose/ui/platform/OutlineResolver;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "ownerViewId", "getOwnerViewId", "renderNode", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "underlyingMatrix", "Landroidx/compose/ui/graphics/Matrix;", "getUnderlyingMatrix-sQKQjiQ", "()[F", "clipRenderNode", "destroy", "drawLayer", "invalidate", "inverseTransform", "matrix", "inverseTransform-58bKbWc", "([F)V", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "reuseLayer", "transform", "transform-58bKbWc", "triggerRepaint", "updateDisplayList", "updateLayerProperties", "scope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "Companion", "UniqueDrawingIdApi29", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class RenderNodeLayer implements OwnedLayer, GraphicLayerInfo {
    private Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock;
    private boolean drawnWithZ;
    private Function0<Unit> invalidateParentLayer;
    private boolean isDestroyed;
    private boolean isDirty;
    private int mutatedFields;
    private final AndroidComposeView ownerView;
    private final DeviceRenderNode renderNode;
    private Paint softwareLayerPaint;
    public static final int $stable = 8;
    private static final Function2<DeviceRenderNode, Matrix, Unit> getMatrix = new Function2<DeviceRenderNode, Matrix, Unit>() { // from class: androidx.compose.ui.platform.RenderNodeLayer$Companion$getMatrix$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(DeviceRenderNode deviceRenderNode, Matrix matrix) {
            invoke2(deviceRenderNode, matrix);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DeviceRenderNode deviceRenderNode, Matrix matrix) {
            deviceRenderNode.getMatrix(matrix);
        }
    };
    private final OutlineResolver outlineResolver = new OutlineResolver();
    private final LayerMatrixCache<DeviceRenderNode> matrixCache = new LayerMatrixCache<>(getMatrix);
    private final CanvasHolder canvasHolder = new CanvasHolder();
    private long transformOrigin = TransformOrigin.INSTANCE.m4775getCenterSzJe1aQ();

    public RenderNodeLayer(AndroidComposeView androidComposeView, Function2<? super Canvas, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0) {
        RenderNodeApi23 renderNodeApi23;
        this.ownerView = androidComposeView;
        this.drawBlock = function2;
        this.invalidateParentLayer = function0;
        if (Build.VERSION.SDK_INT >= 29) {
            renderNodeApi23 = new RenderNodeApi29(androidComposeView);
        } else {
            renderNodeApi23 = new RenderNodeApi23(androidComposeView);
        }
        renderNodeApi23.setHasOverlappingRendering(true);
        renderNodeApi23.setClipToBounds(false);
        this.renderNode = renderNodeApi23;
    }

    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    private final void setDirty(boolean z) {
        if (z != this.isDirty) {
            this.isDirty = z;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z);
        }
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getLayerId() {
        return this.renderNode.getUniqueId();
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(this.ownerView);
        }
        return -1L;
    }

    /* compiled from: RenderNodeLayer.android.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeLayer$UniqueDrawingIdApi29;", "", "()V", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    private static final class UniqueDrawingIdApi29 {
        public static final UniqueDrawingIdApi29 INSTANCE = new UniqueDrawingIdApi29();

        private UniqueDrawingIdApi29() {
        }

        @JvmStatic
        public static final long getUniqueDrawingId(View view) {
            long uniqueDrawingId;
            uniqueDrawingId = view.getUniqueDrawingId();
            return uniqueDrawingId;
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateLayerProperties(ReusableGraphicsLayerScope scope) {
        Function0<Unit> function0;
        int mutatedFields = scope.getMutatedFields() | this.mutatedFields;
        int i = mutatedFields & 4096;
        if (i != 0) {
            this.transformOrigin = scope.getTransformOrigin();
        }
        boolean z = false;
        boolean z2 = this.renderNode.getClipToOutline() && !this.outlineResolver.getOutlineClipSupported();
        if ((mutatedFields & 1) != 0) {
            this.renderNode.setScaleX(scope.getScaleX());
        }
        if ((mutatedFields & 2) != 0) {
            this.renderNode.setScaleY(scope.getScaleY());
        }
        if ((mutatedFields & 4) != 0) {
            this.renderNode.setAlpha(scope.getAlpha());
        }
        if ((mutatedFields & 8) != 0) {
            this.renderNode.setTranslationX(scope.getTranslationX());
        }
        if ((mutatedFields & 16) != 0) {
            this.renderNode.setTranslationY(scope.getTranslationY());
        }
        if ((mutatedFields & 32) != 0) {
            this.renderNode.setElevation(scope.getShadowElevation());
        }
        if ((mutatedFields & 64) != 0) {
            this.renderNode.setAmbientShadowColor(ColorKt.m4438toArgb8_81llA(scope.getAmbientShadowColor()));
        }
        if ((mutatedFields & 128) != 0) {
            this.renderNode.setSpotShadowColor(ColorKt.m4438toArgb8_81llA(scope.getSpotShadowColor()));
        }
        if ((mutatedFields & 1024) != 0) {
            this.renderNode.setRotationZ(scope.getRotationZ());
        }
        if ((mutatedFields & 256) != 0) {
            this.renderNode.setRotationX(scope.getRotationX());
        }
        if ((mutatedFields & 512) != 0) {
            this.renderNode.setRotationY(scope.getRotationY());
        }
        if ((mutatedFields & 2048) != 0) {
            this.renderNode.setCameraDistance(scope.getCameraDistance());
        }
        if (i != 0) {
            this.renderNode.setPivotX(TransformOrigin.m4770getPivotFractionXimpl(this.transformOrigin) * this.renderNode.getWidth());
            this.renderNode.setPivotY(TransformOrigin.m4771getPivotFractionYimpl(this.transformOrigin) * this.renderNode.getHeight());
        }
        boolean z3 = scope.getClip() && scope.getShape() != RectangleShapeKt.getRectangleShape();
        if ((mutatedFields & 24576) != 0) {
            this.renderNode.setClipToOutline(z3);
            this.renderNode.setClipToBounds(scope.getClip() && scope.getShape() == RectangleShapeKt.getRectangleShape());
        }
        if ((131072 & mutatedFields) != 0) {
            this.renderNode.setRenderEffect(scope.getRenderEffect());
        }
        if ((32768 & mutatedFields) != 0) {
            this.renderNode.mo6129setCompositingStrategyaDBOjCE(scope.getCompositingStrategy());
        }
        boolean m6174updateS_szKao = this.outlineResolver.m6174updateS_szKao(scope.getOutline(), scope.getAlpha(), z3, scope.getShadowElevation(), scope.getSize());
        if (this.outlineResolver.getCacheIsDirty()) {
            this.renderNode.setOutline(this.outlineResolver.getAndroidOutline());
        }
        if (z3 && !this.outlineResolver.getOutlineClipSupported()) {
            z = true;
        }
        if (z2 != z || (z && m6174updateS_szKao)) {
            invalidate();
        } else {
            triggerRepaint();
        }
        if (!this.drawnWithZ && this.renderNode.getElevation() > 0.0f && (function0 = this.invalidateParentLayer) != null) {
            function0.invoke();
        }
        if ((mutatedFields & Fields.MatrixAffectingFields) != 0) {
            this.matrixCache.invalidate();
        }
        this.mutatedFields = scope.getMutatedFields();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: resize-ozmzZPI */
    public void mo6050resizeozmzZPI(long size) {
        int i = (int) (size >> 32);
        int i2 = (int) (size & 4294967295L);
        this.renderNode.setPivotX(TransformOrigin.m4770getPivotFractionXimpl(this.transformOrigin) * i);
        this.renderNode.setPivotY(TransformOrigin.m4771getPivotFractionYimpl(this.transformOrigin) * i2);
        DeviceRenderNode deviceRenderNode = this.renderNode;
        if (deviceRenderNode.setPosition(deviceRenderNode.getLeft(), this.renderNode.getTop(), this.renderNode.getLeft() + i, this.renderNode.getTop() + i2)) {
            this.renderNode.setOutline(this.outlineResolver.getAndroidOutline());
            invalidate();
            this.matrixCache.invalidate();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: move--gyyYBs */
    public void mo6049movegyyYBs(long position) {
        int left = this.renderNode.getLeft();
        int top = this.renderNode.getTop();
        int m7117getXimpl = IntOffset.m7117getXimpl(position);
        int m7118getYimpl = IntOffset.m7118getYimpl(position);
        if (left == m7117getXimpl && top == m7118getYimpl) {
            return;
        }
        if (left != m7117getXimpl) {
            this.renderNode.offsetLeftAndRight(m7117getXimpl - left);
        }
        if (top != m7118getYimpl) {
            this.renderNode.offsetTopAndBottom(m7118getYimpl - top);
        }
        triggerRepaint();
        this.matrixCache.invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void invalidate() {
        if (this.isDirty || this.isDestroyed) {
            return;
        }
        this.ownerView.invalidate();
        setDirty(true);
    }

    private final void triggerRepaint() {
        if (Build.VERSION.SDK_INT >= 26) {
            WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(this.ownerView);
        } else {
            this.ownerView.invalidate();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void drawLayer(Canvas canvas, GraphicsLayer parentLayer) {
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (nativeCanvas.isHardwareAccelerated()) {
            updateDisplayList();
            boolean z = this.renderNode.getElevation() > 0.0f;
            this.drawnWithZ = z;
            if (z) {
                canvas.enableZ();
            }
            this.renderNode.drawInto(nativeCanvas);
            if (this.drawnWithZ) {
                canvas.disableZ();
                return;
            }
            return;
        }
        float left = this.renderNode.getLeft();
        float top = this.renderNode.getTop();
        float right = this.renderNode.getRight();
        float bottom = this.renderNode.getBottom();
        if (this.renderNode.getAlpha() < 1.0f) {
            Paint paint = this.softwareLayerPaint;
            if (paint == null) {
                paint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = paint;
            }
            paint.setAlpha(this.renderNode.getAlpha());
            nativeCanvas.saveLayer(left, top, right, bottom, paint.getInternalPaint());
        } else {
            canvas.save();
        }
        canvas.translate(left, top);
        canvas.mo4221concat58bKbWc(this.matrixCache.m6146calculateMatrixGrdbGEg(this.renderNode));
        clipRenderNode(canvas);
        Function2<? super Canvas, ? super GraphicsLayer, Unit> function2 = this.drawBlock;
        if (function2 != null) {
            function2.invoke(canvas, null);
        }
        canvas.restore();
        setDirty(false);
    }

    private final void clipRenderNode(Canvas canvas) {
        if (this.renderNode.getClipToOutline() || this.renderNode.getClipToBounds()) {
            this.outlineResolver.clipToOutline(canvas);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateDisplayList() {
        if (this.isDirty || !this.renderNode.getHasDisplayList()) {
            Path clipPath = (!this.renderNode.getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) ? null : this.outlineResolver.getClipPath();
            final Function2<? super Canvas, ? super GraphicsLayer, Unit> function2 = this.drawBlock;
            if (function2 != null) {
                this.renderNode.record(this.canvasHolder, clipPath, new Function1<Canvas, Unit>() { // from class: androidx.compose.ui.platform.RenderNodeLayer$updateDisplayList$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                        invoke2(canvas);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Canvas canvas) {
                        function2.invoke(canvas, null);
                    }
                });
            }
            setDirty(false);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        if (this.renderNode.getHasDisplayList()) {
            this.renderNode.discardDisplayList();
        }
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
        this.ownerView.requestClearInvalidObservations();
        this.ownerView.recycle$ui_release(this);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: getUnderlyingMatrix-sQKQjiQ */
    public float[] mo6045getUnderlyingMatrixsQKQjiQ() {
        return this.matrixCache.m6146calculateMatrixGrdbGEg(this.renderNode);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: mapOffset-8S9VItk */
    public long mo6048mapOffset8S9VItk(long point, boolean inverse) {
        LayerMatrixCache<DeviceRenderNode> layerMatrixCache = this.matrixCache;
        if (inverse) {
            return layerMatrixCache.m6148mapInverseR5De75A(this.renderNode, point);
        }
        return layerMatrixCache.m6147mapR5De75A(this.renderNode, point);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void mapBounds(MutableRect rect, boolean inverse) {
        LayerMatrixCache<DeviceRenderNode> layerMatrixCache = this.matrixCache;
        if (inverse) {
            layerMatrixCache.mapInverse(this.renderNode, rect);
        } else {
            layerMatrixCache.map(this.renderNode, rect);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void reuseLayer(Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        this.matrixCache.reset();
        setDirty(false);
        this.isDestroyed = false;
        this.drawnWithZ = false;
        this.transformOrigin = TransformOrigin.INSTANCE.m4775getCenterSzJe1aQ();
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: transform-58bKbWc */
    public void mo6051transform58bKbWc(float[] matrix) {
        androidx.compose.ui.graphics.Matrix.m4633timesAssign58bKbWc(matrix, this.matrixCache.m6146calculateMatrixGrdbGEg(this.renderNode));
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: inverseTransform-58bKbWc */
    public void mo6046inverseTransform58bKbWc(float[] matrix) {
        float[] m6145calculateInverseMatrixbWbORWo = this.matrixCache.m6145calculateInverseMatrixbWbORWo(this.renderNode);
        if (m6145calculateInverseMatrixbWbORWo != null) {
            androidx.compose.ui.graphics.Matrix.m4633timesAssign58bKbWc(matrix, m6145calculateInverseMatrixbWbORWo);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: isInLayer-k-4lQ0M */
    public boolean mo6047isInLayerk4lQ0M(long position) {
        float intBitsToFloat = Float.intBitsToFloat((int) (position >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (4294967295L & position));
        if (this.renderNode.getClipToBounds()) {
            return 0.0f <= intBitsToFloat && intBitsToFloat < ((float) this.renderNode.getWidth()) && 0.0f <= intBitsToFloat2 && intBitsToFloat2 < ((float) this.renderNode.getHeight());
        }
        if (this.renderNode.getClipToOutline()) {
            return this.outlineResolver.m6173isInOutlinek4lQ0M(position);
        }
        return true;
    }
}
