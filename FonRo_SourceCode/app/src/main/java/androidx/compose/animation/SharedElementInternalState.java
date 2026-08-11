package androidx.compose.animation;

import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharedElement.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BE\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0013\u0010d\u001a\u00020eø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bf\u00106J\u0010\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020jH\u0016J\b\u0010k\u001a\u00020hH\u0016J\b\u0010l\u001a\u00020hH\u0016J\b\u0010m\u001a\u00020hH\u0016R+\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R/\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\u0013\u001a\u0004\u0018\u00010%8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0019\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0017\u00103\u001a\u0002048Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b5\u00106R+\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b;\u0010\u0019\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010<\u001a\u0004\u0018\u00010\u0000X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R+\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010\u0019\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR+\u0010\r\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010\u0019\u001a\u0004\bF\u0010\"\"\u0004\bG\u0010$R+\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010\u0019\u001a\u0004\bI\u0010\"\"\u0004\bJ\u0010$R+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bP\u0010\u0019\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0014\u0010Q\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010\"R\u0014\u0010S\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bT\u0010\"R\u0011\u0010U\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bV\u0010\"R\u0011\u0010W\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bX\u0010\"R+\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b]\u0010\u0019\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R+\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00118V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\b^\u0010_\"\u0004\b`\u0010a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006n"}, d2 = {"Landroidx/compose/animation/SharedElementInternalState;", "Landroidx/compose/animation/LayerRenderer;", "Landroidx/compose/runtime/RememberObserver;", "sharedElement", "Landroidx/compose/animation/SharedElement;", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "placeHolderSize", "Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "renderOnlyWhenVisible", "", "overlayClip", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "renderInOverlayDuringTransition", "userState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "zIndex", "", "(Landroidx/compose/animation/SharedElement;Landroidx/compose/animation/BoundsAnimation;Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;ZLandroidx/compose/animation/SharedTransitionScope$OverlayClip;ZLandroidx/compose/animation/SharedTransitionScope$SharedContentState;F)V", "<set-?>", "getBoundsAnimation", "()Landroidx/compose/animation/BoundsAnimation;", "setBoundsAnimation", "(Landroidx/compose/animation/BoundsAnimation;)V", "boundsAnimation$delegate", "Landroidx/compose/runtime/MutableState;", "clipPathInOverlay", "Landroidx/compose/ui/graphics/Path;", "getClipPathInOverlay$animation_release", "()Landroidx/compose/ui/graphics/Path;", "setClipPathInOverlay$animation_release", "(Landroidx/compose/ui/graphics/Path;)V", "firstFrameDrawn", "getFirstFrameDrawn$animation_release", "()Z", "setFirstFrameDrawn$animation_release", "(Z)V", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "setLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "layer$delegate", "lookaheadCoords", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getLookaheadCoords", "()Lkotlin/jvm/functions/Function0;", "setLookaheadCoords", "(Lkotlin/jvm/functions/Function0;)V", "nonNullLookaheadSize", "Landroidx/compose/ui/geometry/Size;", "getNonNullLookaheadSize-NH-jbRc", "()J", "getOverlayClip", "()Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "setOverlayClip", "(Landroidx/compose/animation/SharedTransitionScope$OverlayClip;)V", "overlayClip$delegate", "parentState", "getParentState", "()Landroidx/compose/animation/SharedElementInternalState;", "setParentState", "(Landroidx/compose/animation/SharedElementInternalState;)V", "getPlaceHolderSize", "()Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;", "setPlaceHolderSize", "(Landroidx/compose/animation/SharedTransitionScope$PlaceHolderSize;)V", "placeHolderSize$delegate", "getRenderInOverlayDuringTransition", "setRenderInOverlayDuringTransition", "renderInOverlayDuringTransition$delegate", "getRenderOnlyWhenVisible", "setRenderOnlyWhenVisible", "renderOnlyWhenVisible$delegate", "getSharedElement", "()Landroidx/compose/animation/SharedElement;", "setSharedElement", "(Landroidx/compose/animation/SharedElement;)V", "sharedElement$delegate", "shouldRenderBasedOnTarget", "getShouldRenderBasedOnTarget", "shouldRenderInOverlay", "getShouldRenderInOverlay$animation_release", "shouldRenderInPlace", "getShouldRenderInPlace", TypedValues.AttributesType.S_TARGET, "getTarget", "getUserState", "()Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "setUserState", "(Landroidx/compose/animation/SharedTransitionScope$SharedContentState;)V", "userState$delegate", "getZIndex", "()F", "setZIndex", "(F)V", "zIndex$delegate", "Landroidx/compose/runtime/MutableFloatState;", "calculateLookaheadOffset", "Landroidx/compose/ui/geometry/Offset;", "calculateLookaheadOffset-F1C5BW0", "drawInOverlay", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "onAbandoned", "onForgotten", "onRemembered", "animation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SharedElementInternalState implements LayerRenderer, RememberObserver {
    public static final int $stable = 8;

    /* renamed from: boundsAnimation$delegate, reason: from kotlin metadata */
    private final MutableState boundsAnimation;
    private Path clipPathInOverlay;
    private boolean firstFrameDrawn;

    /* renamed from: layer$delegate, reason: from kotlin metadata */
    private final MutableState layer;
    private Function0<? extends LayoutCoordinates> lookaheadCoords;

    /* renamed from: overlayClip$delegate, reason: from kotlin metadata */
    private final MutableState overlayClip;
    private SharedElementInternalState parentState;

    /* renamed from: placeHolderSize$delegate, reason: from kotlin metadata */
    private final MutableState placeHolderSize;

    /* renamed from: renderInOverlayDuringTransition$delegate, reason: from kotlin metadata */
    private final MutableState renderInOverlayDuringTransition;

    /* renamed from: renderOnlyWhenVisible$delegate, reason: from kotlin metadata */
    private final MutableState renderOnlyWhenVisible;

    /* renamed from: sharedElement$delegate, reason: from kotlin metadata */
    private final MutableState sharedElement;

    /* renamed from: userState$delegate, reason: from kotlin metadata */
    private final MutableState userState;

    /* renamed from: zIndex$delegate, reason: from kotlin metadata */
    private final MutableFloatState zIndex;

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
    }

    public SharedElementInternalState(SharedElement sharedElement, BoundsAnimation boundsAnimation, SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean z, SharedTransitionScope.OverlayClip overlayClip, boolean z2, SharedTransitionScope.SharedContentState sharedContentState, float f) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        MutableState mutableStateOf$default7;
        MutableState mutableStateOf$default8;
        this.zIndex = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z2), null, 2, null);
        this.renderInOverlayDuringTransition = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(sharedElement, null, 2, null);
        this.sharedElement = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(boundsAnimation, null, 2, null);
        this.boundsAnimation = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(placeHolderSize, null, 2, null);
        this.placeHolderSize = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), null, 2, null);
        this.renderOnlyWhenVisible = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(overlayClip, null, 2, null);
        this.overlayClip = mutableStateOf$default6;
        mutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(sharedContentState, null, 2, null);
        this.userState = mutableStateOf$default7;
        this.lookaheadCoords = new Function0() { // from class: androidx.compose.animation.SharedElementInternalState$lookaheadCoords$1
            @Override // kotlin.jvm.functions.Function0
            public final Void invoke() {
                return null;
            }
        };
        mutableStateOf$default8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.layer = mutableStateOf$default8;
    }

    /* renamed from: getFirstFrameDrawn$animation_release, reason: from getter */
    public final boolean getFirstFrameDrawn() {
        return this.firstFrameDrawn;
    }

    public final void setFirstFrameDrawn$animation_release(boolean z) {
        this.firstFrameDrawn = z;
    }

    @Override // androidx.compose.animation.LayerRenderer
    public float getZIndex() {
        return this.zIndex.getFloatValue();
    }

    public void setZIndex(float f) {
        this.zIndex.setFloatValue(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getRenderInOverlayDuringTransition() {
        return ((Boolean) this.renderInOverlayDuringTransition.getValue()).booleanValue();
    }

    public final void setRenderInOverlayDuringTransition(boolean z) {
        this.renderInOverlayDuringTransition.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SharedElement getSharedElement() {
        return (SharedElement) this.sharedElement.getValue();
    }

    public final void setSharedElement(SharedElement sharedElement) {
        this.sharedElement.setValue(sharedElement);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final BoundsAnimation getBoundsAnimation() {
        return (BoundsAnimation) this.boundsAnimation.getValue();
    }

    public final void setBoundsAnimation(BoundsAnimation boundsAnimation) {
        this.boundsAnimation.setValue(boundsAnimation);
    }

    public final SharedTransitionScope.PlaceHolderSize getPlaceHolderSize() {
        return (SharedTransitionScope.PlaceHolderSize) this.placeHolderSize.getValue();
    }

    public final void setPlaceHolderSize(SharedTransitionScope.PlaceHolderSize placeHolderSize) {
        this.placeHolderSize.setValue(placeHolderSize);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getRenderOnlyWhenVisible() {
        return ((Boolean) this.renderOnlyWhenVisible.getValue()).booleanValue();
    }

    public final void setRenderOnlyWhenVisible(boolean z) {
        this.renderOnlyWhenVisible.setValue(Boolean.valueOf(z));
    }

    public final SharedTransitionScope.OverlayClip getOverlayClip() {
        return (SharedTransitionScope.OverlayClip) this.overlayClip.getValue();
    }

    public final void setOverlayClip(SharedTransitionScope.OverlayClip overlayClip) {
        this.overlayClip.setValue(overlayClip);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SharedTransitionScope.SharedContentState getUserState() {
        return (SharedTransitionScope.SharedContentState) this.userState.getValue();
    }

    public final void setUserState(SharedTransitionScope.SharedContentState sharedContentState) {
        this.userState.setValue(sharedContentState);
    }

    /* renamed from: getClipPathInOverlay$animation_release, reason: from getter */
    public final Path getClipPathInOverlay() {
        return this.clipPathInOverlay;
    }

    public final void setClipPathInOverlay$animation_release(Path path) {
        this.clipPathInOverlay = path;
    }

    @Override // androidx.compose.animation.LayerRenderer
    public void drawInOverlay(DrawScope drawScope) {
        GraphicsLayer layer = getLayer();
        if (layer != null && this.firstFrameDrawn && getShouldRenderInOverlay$animation_release()) {
            if (getSharedElement().getCurrentBounds() == null) {
                throw new IllegalArgumentException("Error: current bounds not set yet.".toString());
            }
            Rect currentBounds = getSharedElement().getCurrentBounds();
            Unit unit = null;
            Offset m4114boximpl = currentBounds != null ? Offset.m4114boximpl(currentBounds.m4160getTopLeftF1C5BW0()) : null;
            Intrinsics.checkNotNull(m4114boximpl);
            long m4135unboximpl = m4114boximpl.m4135unboximpl();
            float intBitsToFloat = Float.intBitsToFloat((int) (m4135unboximpl >> 32));
            float intBitsToFloat2 = Float.intBitsToFloat((int) (m4135unboximpl & 4294967295L));
            Path path = this.clipPathInOverlay;
            if (path != null) {
                int m4373getIntersectrtfAjoo = ClipOp.INSTANCE.m4373getIntersectrtfAjoo();
                DrawContext drawContext = drawScope.getDrawContext();
                long mo4856getSizeNHjbRc = drawContext.mo4856getSizeNHjbRc();
                drawContext.getCanvas().save();
                try {
                    drawContext.getTransform().mo4858clipPathmtrdDE(path, m4373getIntersectrtfAjoo);
                    drawScope.getDrawContext().getTransform().translate(intBitsToFloat, intBitsToFloat2);
                    try {
                        GraphicsLayerKt.drawLayer(drawScope, layer);
                        drawContext.getCanvas().restore();
                        drawContext.mo4857setSizeuvyYCjk(mo4856getSizeNHjbRc);
                        unit = Unit.INSTANCE;
                    } finally {
                    }
                } catch (Throwable th) {
                    drawContext.getCanvas().restore();
                    drawContext.mo4857setSizeuvyYCjk(mo4856getSizeNHjbRc);
                    throw th;
                }
            }
            if (unit == null) {
                drawScope.getDrawContext().getTransform().translate(intBitsToFloat, intBitsToFloat2);
                try {
                    GraphicsLayerKt.drawLayer(drawScope, layer);
                } finally {
                }
            }
        }
    }

    /* renamed from: getNonNullLookaheadSize-NH-jbRc, reason: not valid java name */
    public final long m430getNonNullLookaheadSizeNHjbRc() {
        LayoutCoordinates invoke = this.lookaheadCoords.invoke();
        if (invoke == null) {
            throw new IllegalArgumentException(("Error: lookahead coordinates is null for " + getSharedElement().getKey() + '.').toString());
        }
        return IntSizeKt.m7172toSizeozmzZPI(invoke.mo5740getSizeYbymL2g());
    }

    public final Function0<LayoutCoordinates> getLookaheadCoords() {
        return this.lookaheadCoords;
    }

    public final void setLookaheadCoords(Function0<? extends LayoutCoordinates> function0) {
        this.lookaheadCoords = function0;
    }

    @Override // androidx.compose.animation.LayerRenderer
    public SharedElementInternalState getParentState() {
        return this.parentState;
    }

    public void setParentState(SharedElementInternalState sharedElementInternalState) {
        this.parentState = sharedElementInternalState;
    }

    /* renamed from: calculateLookaheadOffset-F1C5BW0, reason: not valid java name */
    public final long m429calculateLookaheadOffsetF1C5BW0() {
        LayoutCoordinates invoke = this.lookaheadCoords.invoke();
        if (invoke == null) {
            throw new IllegalArgumentException("Error: lookahead coordinates is null.".toString());
        }
        return getSharedElement().getScope().getLookaheadRoot$animation_release().mo5741localPositionOfR5De75A(invoke, Offset.INSTANCE.m4141getZeroF1C5BW0());
    }

    public final boolean getTarget() {
        return getBoundsAnimation().getTarget();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final GraphicsLayer getLayer() {
        return (GraphicsLayer) this.layer.getValue();
    }

    public final void setLayer(GraphicsLayer graphicsLayer) {
        this.layer.setValue(graphicsLayer);
    }

    private final boolean getShouldRenderBasedOnTarget() {
        return Intrinsics.areEqual(getSharedElement().getTargetBoundsProvider(), this) || !getRenderOnlyWhenVisible();
    }

    public final boolean getShouldRenderInOverlay$animation_release() {
        return getShouldRenderBasedOnTarget() && getSharedElement().getFoundMatch() && getRenderInOverlayDuringTransition();
    }

    public final boolean getShouldRenderInPlace() {
        if (getSharedElement().getFoundMatch()) {
            return !getShouldRenderInOverlay$animation_release() && getShouldRenderBasedOnTarget();
        }
        return true;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        getSharedElement().getScope().onStateAdded$animation_release(this);
        getSharedElement().updateTargetBoundsProvider();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        getSharedElement().getScope().onStateRemoved$animation_release(this);
        getSharedElement().updateTargetBoundsProvider();
    }
}
