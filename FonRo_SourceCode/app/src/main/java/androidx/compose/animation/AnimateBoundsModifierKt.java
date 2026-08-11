package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: AnimateBoundsModifier.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a2\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003¨\u0006\f"}, d2 = {"DefaultBoundsTransform", "Landroidx/compose/animation/BoundsTransform;", "getDefaultBoundsTransform$annotations", "()V", "animateBounds", "Landroidx/compose/ui/Modifier;", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "modifier", "boundsTransform", "animateMotionFrameOfReference", "", "animation_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AnimateBoundsModifierKt {
    private static final BoundsTransform DefaultBoundsTransform = new BoundsTransform() { // from class: androidx.compose.animation.AnimateBoundsModifierKt$$ExternalSyntheticLambda0
        @Override // androidx.compose.animation.BoundsTransform
        public final FiniteAnimationSpec transform(Rect rect, Rect rect2) {
            FiniteAnimationSpec spring;
            spring = AnimationSpecKt.spring(1.0f, 400.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.INSTANCE));
            return spring;
        }
    };

    private static /* synthetic */ void getDefaultBoundsTransform$annotations() {
    }

    public static /* synthetic */ Modifier animateBounds$default(Modifier modifier, LookaheadScope lookaheadScope, Modifier modifier2, BoundsTransform boundsTransform, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            modifier2 = Modifier.INSTANCE;
        }
        if ((i & 4) != 0) {
            boundsTransform = DefaultBoundsTransform;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return animateBounds(modifier, lookaheadScope, modifier2, boundsTransform, z);
    }

    public static final Modifier animateBounds(Modifier modifier, LookaheadScope lookaheadScope, Modifier modifier2, BoundsTransform boundsTransform, boolean z) {
        return modifier.then(new BoundsAnimationElement(lookaheadScope, boundsTransform, new Function2<IntSize, Constraints, Constraints>() { // from class: androidx.compose.animation.AnimateBoundsModifierKt$animateBounds$1
            /* renamed from: invoke-2pbfIzA, reason: not valid java name */
            public final long m352invoke2pbfIzA(long j, long j2) {
                return j2;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Constraints invoke(IntSize intSize, Constraints constraints) {
                return Constraints.m6929boximpl(m352invoke2pbfIzA(intSize.m7164unboximpl(), constraints.getValue()));
            }
        }, z)).then(modifier2).then(new BoundsAnimationElement(lookaheadScope, boundsTransform, new Function2<IntSize, Constraints, Constraints>() { // from class: androidx.compose.animation.AnimateBoundsModifierKt$animateBounds$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Constraints invoke(IntSize intSize, Constraints constraints) {
                return Constraints.m6929boximpl(m353invoke2pbfIzA(intSize.m7164unboximpl(), constraints.getValue()));
            }

            /* renamed from: invoke-2pbfIzA, reason: not valid java name */
            public final long m353invoke2pbfIzA(long j, long j2) {
                return Constraints.INSTANCE.m6952fixedJhjzzOo((int) (j >> 32), (int) (j & 4294967295L));
            }
        }, z));
    }
}
