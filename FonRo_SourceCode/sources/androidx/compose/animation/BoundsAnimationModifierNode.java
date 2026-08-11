package androidx.compose.animation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: AnimateBoundsModifier.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BU\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00126\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\r0\b\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u001a\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\b\u0010)\u001a\u00020*H\u0016J&\u0010+\u001a\u00020,*\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u000e\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u0014\u00102\u001a\u00020\u0010*\u0002032\u0006\u00104\u001a\u000205H\u0016R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 RJ\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\r0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"Landroidx/compose/animation/BoundsAnimationModifierNode;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "onChooseMeasureConstraints", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "animatedSize", "Landroidx/compose/ui/unit/Constraints;", "constraints", "animateMotionFrameOfReference", "", "(Landroidx/compose/ui/layout/LookaheadScope;Landroidx/compose/animation/BoundsTransform;Lkotlin/jvm/functions/Function2;Z)V", "getAnimateMotionFrameOfReference", "()Z", "setAnimateMotionFrameOfReference", "(Z)V", "boundsAnimation", "Landroidx/compose/animation/BoundsTransformDeferredAnimation;", "getBoundsTransform", "()Landroidx/compose/animation/BoundsTransform;", "setBoundsTransform", "(Landroidx/compose/animation/BoundsTransform;)V", "directManipulationParentsDirty", "getLookaheadScope", "()Landroidx/compose/ui/layout/LookaheadScope;", "setLookaheadScope", "(Landroidx/compose/ui/layout/LookaheadScope;)V", "getOnChooseMeasureConstraints", "()Lkotlin/jvm/functions/Function2;", "setOnChooseMeasureConstraints", "(Lkotlin/jvm/functions/Function2;)V", "isMeasurementApproachInProgress", "lookaheadSize", "isMeasurementApproachInProgress-ozmzZPI", "(J)Z", "onAttach", "", "approachMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "isPlacementApproachInProgress", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "lookaheadCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "animation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BoundsAnimationModifierNode extends Modifier.Node implements ApproachLayoutModifierNode {
    public static final int $stable = 8;
    private boolean animateMotionFrameOfReference;
    private BoundsTransform boundsTransform;
    private LookaheadScope lookaheadScope;
    private Function2<? super IntSize, ? super Constraints, Constraints> onChooseMeasureConstraints;
    private boolean directManipulationParentsDirty = true;
    private final BoundsTransformDeferredAnimation boundsAnimation = new BoundsTransformDeferredAnimation();

    public final LookaheadScope getLookaheadScope() {
        return this.lookaheadScope;
    }

    public final void setLookaheadScope(LookaheadScope lookaheadScope) {
        this.lookaheadScope = lookaheadScope;
    }

    public final BoundsTransform getBoundsTransform() {
        return this.boundsTransform;
    }

    public final void setBoundsTransform(BoundsTransform boundsTransform) {
        this.boundsTransform = boundsTransform;
    }

    public final Function2<IntSize, Constraints, Constraints> getOnChooseMeasureConstraints() {
        return this.onChooseMeasureConstraints;
    }

    public final void setOnChooseMeasureConstraints(Function2<? super IntSize, ? super Constraints, Constraints> function2) {
        this.onChooseMeasureConstraints = function2;
    }

    public final boolean getAnimateMotionFrameOfReference() {
        return this.animateMotionFrameOfReference;
    }

    public final void setAnimateMotionFrameOfReference(boolean z) {
        this.animateMotionFrameOfReference = z;
    }

    public BoundsAnimationModifierNode(LookaheadScope lookaheadScope, BoundsTransform boundsTransform, Function2<? super IntSize, ? super Constraints, Constraints> function2, boolean z) {
        this.lookaheadScope = lookaheadScope;
        this.boundsTransform = boundsTransform;
        this.onChooseMeasureConstraints = function2;
        this.animateMotionFrameOfReference = z;
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    /* renamed from: isMeasurementApproachInProgress-ozmzZPI, reason: not valid java name */
    public boolean mo390isMeasurementApproachInProgressozmzZPI(long lookaheadSize) {
        this.boundsAnimation.m395updateTargetSizeuvyYCjk(IntSizeKt.m7172toSizeozmzZPI(lookaheadSize));
        return !this.boundsAnimation.isIdle();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        this.directManipulationParentsDirty = true;
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    public boolean isPlacementApproachInProgress(Placeable.PlacementScope placementScope, LayoutCoordinates layoutCoordinates) {
        this.boundsAnimation.updateTargetOffsetAndAnimate(this.lookaheadScope, placementScope, getCoroutineScope(), this.directManipulationParentsDirty, this.animateMotionFrameOfReference, this.boundsTransform);
        this.directManipulationParentsDirty = this.animateMotionFrameOfReference;
        return !this.boundsAnimation.isIdle();
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    /* renamed from: approachMeasure-3p2s80s, reason: not valid java name */
    public MeasureResult mo389approachMeasure3p2s80s(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j) {
        long currentSize;
        if (this.boundsAnimation.getCurrentSize() == InlineClassHelperKt.UnspecifiedPackedFloats) {
            currentSize = IntSizeKt.m7172toSizeozmzZPI(approachMeasureScope.mo5709getLookaheadSizeYbymL2g());
        } else {
            currentSize = this.boundsAnimation.getCurrentSize();
        }
        Rect value = this.boundsAnimation.getValue();
        if (value != null) {
            currentSize = value.m4158getSizeNHjbRc();
        }
        long m7168roundToIntSizeuvyYCjk = IntSizeKt.m7168roundToIntSizeuvyYCjk(currentSize);
        long value2 = this.onChooseMeasureConstraints.invoke(IntSize.m7152boximpl(m7168roundToIntSizeuvyYCjk), Constraints.m6929boximpl(j)).getValue();
        final Placeable mo5732measureBRTryo0 = measurable.mo5732measureBRTryo0(value2);
        long m6956constrain4WqzIAM = ConstraintsKt.m6956constrain4WqzIAM(value2, m7168roundToIntSizeuvyYCjk);
        return MeasureScope.layout$default(approachMeasureScope, (int) (m6956constrain4WqzIAM >> 32), (int) (m6956constrain4WqzIAM & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.BoundsAnimationModifierNode$approachMeasure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                BoundsTransformDeferredAnimation boundsTransformDeferredAnimation;
                BoundsTransformDeferredAnimation boundsTransformDeferredAnimation2;
                long m4160getTopLeftF1C5BW0;
                BoundsTransformDeferredAnimation boundsTransformDeferredAnimation3;
                boundsTransformDeferredAnimation = BoundsAnimationModifierNode.this.boundsAnimation;
                Rect value3 = boundsTransformDeferredAnimation.getValue();
                LookaheadScope lookaheadScope = BoundsAnimationModifierNode.this.getLookaheadScope();
                BoundsAnimationModifierNode boundsAnimationModifierNode = BoundsAnimationModifierNode.this;
                LayoutCoordinates coordinates = placementScope.getCoordinates();
                Offset m4114boximpl = coordinates != null ? Offset.m4114boximpl(lookaheadScope.getLookaheadScopeCoordinates(placementScope).mo5742localPositionOfS_NoaFU(coordinates, Offset.INSTANCE.m4141getZeroF1C5BW0(), boundsAnimationModifierNode.getAnimateMotionFrameOfReference())) : null;
                BoundsAnimationModifierNode boundsAnimationModifierNode2 = BoundsAnimationModifierNode.this;
                if (value3 != null) {
                    boundsTransformDeferredAnimation3 = boundsAnimationModifierNode2.boundsAnimation;
                    boundsTransformDeferredAnimation3.m394updateCurrentBoundstz77jQw(value3.m4160getTopLeftF1C5BW0(), value3.m4158getSizeNHjbRc());
                    m4160getTopLeftF1C5BW0 = value3.m4160getTopLeftF1C5BW0();
                } else {
                    boundsTransformDeferredAnimation2 = boundsAnimationModifierNode2.boundsAnimation;
                    Rect currentBounds = boundsTransformDeferredAnimation2.getCurrentBounds();
                    m4160getTopLeftF1C5BW0 = currentBounds != null ? currentBounds.m4160getTopLeftF1C5BW0() : Offset.INSTANCE.m4141getZeroF1C5BW0();
                }
                long m4129minusMKHz9U = m4114boximpl != null ? Offset.m4129minusMKHz9U(m4160getTopLeftF1C5BW0, m4114boximpl.m4135unboximpl()) : Offset.INSTANCE.m4141getZeroF1C5BW0();
                Placeable.PlacementScope.place$default(placementScope, mo5732measureBRTryo0, Math.round(Float.intBitsToFloat((int) (m4129minusMKHz9U >> 32))), Math.round(Float.intBitsToFloat((int) (m4129minusMKHz9U & 4294967295L))), 0.0f, 4, null);
            }
        }, 4, null);
    }
}
