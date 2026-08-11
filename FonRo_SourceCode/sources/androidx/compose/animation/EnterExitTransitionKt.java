package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: EnterExitTransition.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001aQ\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122#\b\u0002\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001aQ\u0010\u0019\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\u00122#\b\u0002\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00060\u0014H\u0007\u001aQ\u0010\u001d\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u001e2\b\b\u0002\u0010\u0011\u001a\u00020\u00122#\b\u0002\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001a\"\u0010!\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u0002H\u0007\u001a\"\u0010#\u001a\u00020$2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u0002H\u0007\u001a6\u0010&\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u00022\b\b\u0002\u0010(\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a6\u0010+\u001a\u00020$2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u00022\b\b\u0002\u0010(\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001aQ\u0010/\u001a\u00020$2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0002\u00100\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122#\b\u0002\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001aQ\u00102\u001a\u00020$2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0002\u00100\u001a\u00020\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\u00122#\b\u0002\u00103\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00060\u0014H\u0007\u001aQ\u00104\u001a\u00020$2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0002\u00100\u001a\u00020\u001e2\b\b\u0002\u0010\u0011\u001a\u00020\u00122#\b\u0002\u00105\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001a;\u00106\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2!\u00107\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00040\u0014H\u0007\u001a=\u00108\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2#\b\u0002\u00109\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001a=\u0010:\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2#\b\u0002\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001a;\u0010<\u001a\u00020$2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2!\u0010=\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00040\u0014H\u0007\u001a=\u0010>\u001a\u00020$2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2#\b\u0002\u0010?\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001a=\u0010@\u001a\u00020$2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2#\b\u0002\u0010A\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00150\u0014H\u0007\u001a/\u0010B\u001a\u00020C*\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020IH\u0003¢\u0006\u0002\u0010J\u001a?\u0010K\u001a\u00020L*\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020$2\u000e\b\u0002\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00120N2\u0006\u0010H\u001a\u00020IH\u0001¢\u0006\u0002\u0010O\u001a,\u0010P\u001a\u0004\u0018\u0001HQ\"\b\b\u0000\u0010Q*\u00020R*\u00020\f2\f\u0010S\u001a\b\u0012\u0004\u0012\u0002HQ0TH\u0080\u0002¢\u0006\u0002\u0010U\u001a,\u0010P\u001a\u0004\u0018\u0001HQ\"\b\b\u0000\u0010Q*\u00020R*\u00020$2\f\u0010S\u001a\b\u0012\u0004\u0012\u0002HQ0TH\u0080\u0002¢\u0006\u0002\u0010V\u001a\f\u0010W\u001a\u00020\u001a*\u00020\u0010H\u0002\u001a\f\u0010W\u001a\u00020\u001a*\u00020\u001eH\u0002\u001a\u001f\u0010X\u001a\u00020\f*\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020\fH\u0001¢\u0006\u0002\u0010Y\u001a\u001f\u0010Z\u001a\u00020$*\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010G\u001a\u00020$H\u0001¢\u0006\u0002\u0010[\u001a\u0015\u0010\\\u001a\u00020\f*\u00020\f2\u0006\u0010]\u001a\u00020RH\u0080\u0004\u001a\u0015\u0010\\\u001a\u00020$*\u00020$2\u0006\u0010]\u001a\u00020RH\u0080\u0004\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006^²\u0006\n\u0010_\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010`\u001a\u00020$X\u008a\u008e\u0002"}, d2 = {"DefaultAlphaAndScaleSpring", "Landroidx/compose/animation/core/SpringSpec;", "", "DefaultOffsetAnimationSpec", "Landroidx/compose/ui/unit/IntOffset;", "DefaultSizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "TransformOriginVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/graphics/TransformOrigin;", "Landroidx/compose/animation/core/AnimationVector2D;", "expandHorizontally", "Landroidx/compose/animation/EnterTransition;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "expandFrom", "Landroidx/compose/ui/Alignment$Horizontal;", "clip", "", "initialWidth", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "fullWidth", "expandIn", "Landroidx/compose/ui/Alignment;", "initialSize", "fullSize", "expandVertically", "Landroidx/compose/ui/Alignment$Vertical;", "initialHeight", "fullHeight", "fadeIn", "initialAlpha", "fadeOut", "Landroidx/compose/animation/ExitTransition;", "targetAlpha", "scaleIn", "initialScale", "transformOrigin", "scaleIn-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/EnterTransition;", "scaleOut", "targetScale", "scaleOut-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/ExitTransition;", "shrinkHorizontally", "shrinkTowards", "targetWidth", "shrinkOut", "targetSize", "shrinkVertically", "targetHeight", "slideIn", "initialOffset", "slideInHorizontally", "initialOffsetX", "slideInVertically", "initialOffsetY", "slideOut", "targetOffset", "slideOutHorizontally", "targetOffsetX", "slideOutVertically", "targetOffsetY", "createGraphicsLayerBlock", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "enter", "exit", "label", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "createModifier", "Landroidx/compose/ui/Modifier;", "isEnabled", "Lkotlin/Function0;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "get", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/animation/TransitionEffect;", "key", "Landroidx/compose/animation/TransitionEffectKey;", "(Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/TransitionEffectKey;)Landroidx/compose/animation/TransitionEffect;", "(Landroidx/compose/animation/ExitTransition;Landroidx/compose/animation/TransitionEffectKey;)Landroidx/compose/animation/TransitionEffect;", "toAlignment", "trackActiveEnter", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterTransition;", "trackActiveExit", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/ExitTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/ExitTransition;", "withEffect", "effect", "animation_release", "activeEnter", "activeExit"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EnterExitTransitionKt {
    private static final TwoWayConverter<TransformOrigin, AnimationVector2D> TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter(new Function1<TransformOrigin, AnimationVector2D>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ AnimationVector2D invoke(TransformOrigin transformOrigin) {
            return m403invoke__ExYCQ(transformOrigin.getPackedValue());
        }

        /* renamed from: invoke-__ExYCQ, reason: not valid java name */
        public final AnimationVector2D m403invoke__ExYCQ(long j) {
            return new AnimationVector2D(TransformOrigin.m4770getPivotFractionXimpl(j), TransformOrigin.m4771getPivotFractionYimpl(j));
        }
    }, new Function1<AnimationVector2D, TransformOrigin>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TransformOrigin invoke(AnimationVector2D animationVector2D) {
            return TransformOrigin.m4762boximpl(m404invokeLIALnN8(animationVector2D));
        }

        /* renamed from: invoke-LIALnN8, reason: not valid java name */
        public final long m404invokeLIALnN8(AnimationVector2D animationVector2D) {
            return TransformOriginKt.TransformOrigin(animationVector2D.getV1(), animationVector2D.getV2());
        }
    });
    private static final SpringSpec<Float> DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
    private static final SpringSpec<IntOffset> DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m7108boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
    private static final SpringSpec<IntSize> DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m7152boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);

    public static final EnterTransition withEffect(EnterTransition enterTransition, TransitionEffect transitionEffect) {
        return new EnterTransitionImpl(new TransitionData(null, null, null, null, false, MapsKt.mapOf(TuplesKt.to(transitionEffect.getKey$animation_release(), transitionEffect)), 31, null));
    }

    public static final ExitTransition withEffect(ExitTransition exitTransition, TransitionEffect transitionEffect) {
        return new ExitTransitionImpl(new TransitionData(null, null, null, null, false, MapsKt.mapOf(TuplesKt.to(transitionEffect.getKey$animation_release(), transitionEffect)), 31, null));
    }

    public static /* synthetic */ EnterTransition fadeIn$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeIn(finiteAnimationSpec, f);
    }

    public static final EnterTransition fadeIn(FiniteAnimationSpec<Float> finiteAnimationSpec, float f) {
        return new EnterTransitionImpl(new TransitionData(new Fade(f, finiteAnimationSpec), null, null, null, false, null, 62, null));
    }

    public static /* synthetic */ ExitTransition fadeOut$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeOut(finiteAnimationSpec, f);
    }

    public static final ExitTransition fadeOut(FiniteAnimationSpec<Float> finiteAnimationSpec, float f) {
        return new ExitTransitionImpl(new TransitionData(new Fade(f, finiteAnimationSpec), null, null, null, false, null, 62, null));
    }

    public static /* synthetic */ EnterTransition slideIn$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m7108boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        return slideIn(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideIn(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super IntSize, IntOffset> function1) {
        return new EnterTransitionImpl(new TransitionData(null, new Slide(function1, finiteAnimationSpec), null, null, false, null, 61, null));
    }

    public static /* synthetic */ ExitTransition slideOut$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m7108boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        return slideOut(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOut(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super IntSize, IntOffset> function1) {
        return new ExitTransitionImpl(new TransitionData(null, new Slide(function1, finiteAnimationSpec), null, null, false, null, 61, null));
    }

    /* renamed from: scaleIn-L8ZKh-E$default, reason: not valid java name */
    public static /* synthetic */ EnterTransition m400scaleInL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.INSTANCE.m4775getCenterSzJe1aQ();
        }
        return m399scaleInL8ZKhE(finiteAnimationSpec, f, j);
    }

    /* renamed from: scaleIn-L8ZKh-E, reason: not valid java name */
    public static final EnterTransition m399scaleInL8ZKhE(FiniteAnimationSpec<Float> finiteAnimationSpec, float f, long j) {
        return new EnterTransitionImpl(new TransitionData(null, null, null, new Scale(f, j, finiteAnimationSpec, null), false, null, 55, null));
    }

    /* renamed from: scaleOut-L8ZKh-E$default, reason: not valid java name */
    public static /* synthetic */ ExitTransition m402scaleOutL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.INSTANCE.m4775getCenterSzJe1aQ();
        }
        return m401scaleOutL8ZKhE(finiteAnimationSpec, f, j);
    }

    /* renamed from: scaleOut-L8ZKh-E, reason: not valid java name */
    public static final ExitTransition m401scaleOutL8ZKhE(FiniteAnimationSpec<Float> finiteAnimationSpec, float f, long j) {
        return new ExitTransitionImpl(new TransitionData(null, null, null, new Scale(f, j, finiteAnimationSpec, null), false, null, 55, null));
    }

    public static /* synthetic */ EnterTransition expandIn$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m7152boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.INSTANCE.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandIn$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                    return IntSize.m7152boximpl(m407invokemzRDjE0(intSize.m7164unboximpl()));
                }

                /* renamed from: invoke-mzRDjE0, reason: not valid java name */
                public final long m407invokemzRDjE0(long j) {
                    return IntSize.m7155constructorimpl(0L);
                }
            };
        }
        return expandIn(finiteAnimationSpec, alignment, z, function1);
    }

    public static final EnterTransition expandIn(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment alignment, boolean z, Function1<? super IntSize, IntSize> function1) {
        return new EnterTransitionImpl(new TransitionData(null, null, new ChangeSize(alignment, function1, finiteAnimationSpec, z), null, false, null, 59, null));
    }

    public static /* synthetic */ ExitTransition shrinkOut$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m7152boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.INSTANCE.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkOut$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                    return IntSize.m7152boximpl(m410invokemzRDjE0(intSize.m7164unboximpl()));
                }

                /* renamed from: invoke-mzRDjE0, reason: not valid java name */
                public final long m410invokemzRDjE0(long j) {
                    return IntSize.m7155constructorimpl(0L);
                }
            };
        }
        return shrinkOut(finiteAnimationSpec, alignment, z, function1);
    }

    public static final ExitTransition shrinkOut(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment alignment, boolean z, Function1<? super IntSize, IntSize> function1) {
        return new ExitTransitionImpl(new TransitionData(null, null, new ChangeSize(alignment, function1, finiteAnimationSpec, z), null, false, null, 59, null));
    }

    public static /* synthetic */ EnterTransition expandHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m7152boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.INSTANCE.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandHorizontally$1
                public final Integer invoke(int i2) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return expandHorizontally(finiteAnimationSpec, horizontal, z, function1);
    }

    public static final EnterTransition expandHorizontally(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, final Function1<? super Integer, Integer> function1) {
        return expandIn(finiteAnimationSpec, toAlignment(horizontal), z, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandHorizontally$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m7152boximpl(m406invokemzRDjE0(intSize.m7164unboximpl()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m406invokemzRDjE0(long j) {
                return IntSize.m7155constructorimpl((((int) (j & 4294967295L)) & 4294967295L) | (function1.invoke(Integer.valueOf((int) (j >> 32))).intValue() << 32));
            }
        });
    }

    public static /* synthetic */ EnterTransition expandVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m7152boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.INSTANCE.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandVertically$1
                public final Integer invoke(int i2) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return expandVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final EnterTransition expandVertically(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Vertical vertical, boolean z, final Function1<? super Integer, Integer> function1) {
        return expandIn(finiteAnimationSpec, toAlignment(vertical), z, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandVertically$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m7152boximpl(m408invokemzRDjE0(intSize.m7164unboximpl()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m408invokemzRDjE0(long j) {
                return IntSize.m7155constructorimpl((((int) (j >> 32)) << 32) | (function1.invoke(Integer.valueOf((int) (j & 4294967295L))).intValue() & 4294967295L));
            }
        });
    }

    public static /* synthetic */ ExitTransition shrinkHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m7152boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.INSTANCE.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkHorizontally$1
                public final Integer invoke(int i2) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return shrinkHorizontally(finiteAnimationSpec, horizontal, z, function1);
    }

    public static final ExitTransition shrinkHorizontally(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, final Function1<? super Integer, Integer> function1) {
        return shrinkOut(finiteAnimationSpec, toAlignment(horizontal), z, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkHorizontally$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m7152boximpl(m409invokemzRDjE0(intSize.m7164unboximpl()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m409invokemzRDjE0(long j) {
                return IntSize.m7155constructorimpl((((int) (j & 4294967295L)) & 4294967295L) | (function1.invoke(Integer.valueOf((int) (j >> 32))).intValue() << 32));
            }
        });
    }

    public static /* synthetic */ ExitTransition shrinkVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m7152boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.INSTANCE.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$1
                public final Integer invoke(int i2) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return shrinkVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final ExitTransition shrinkVertically(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Vertical vertical, boolean z, final Function1<? super Integer, Integer> function1) {
        return shrinkOut(finiteAnimationSpec, toAlignment(vertical), z, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m7152boximpl(m411invokemzRDjE0(intSize.m7164unboximpl()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m411invokemzRDjE0(long j) {
                return IntSize.m7155constructorimpl((((int) (j >> 32)) << 32) | (function1.invoke(Integer.valueOf((int) (j & 4294967295L))).intValue() & 4294967295L));
            }
        });
    }

    public static /* synthetic */ EnterTransition slideInHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m7108boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInHorizontally$1
                public final Integer invoke(int i2) {
                    return Integer.valueOf((-i2) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideInHorizontally(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideInHorizontally(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final Function1<? super Integer, Integer> function1) {
        return slideIn(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInHorizontally$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m7108boximpl(m412invokemHKZG7I(intSize.m7164unboximpl()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m412invokemHKZG7I(long j) {
                return IntOffset.m7111constructorimpl(function1.invoke(Integer.valueOf((int) (j >> 32))).intValue() << 32);
            }
        });
    }

    public static /* synthetic */ EnterTransition slideInVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m7108boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInVertically$1
                public final Integer invoke(int i2) {
                    return Integer.valueOf((-i2) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideInVertically(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideInVertically(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final Function1<? super Integer, Integer> function1) {
        return slideIn(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInVertically$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m7108boximpl(m413invokemHKZG7I(intSize.m7164unboximpl()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m413invokemHKZG7I(long j) {
                return IntOffset.m7111constructorimpl(function1.invoke(Integer.valueOf((int) (j & 4294967295L))).intValue() & 4294967295L);
            }
        });
    }

    public static /* synthetic */ ExitTransition slideOutHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m7108boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutHorizontally$1
                public final Integer invoke(int i2) {
                    return Integer.valueOf((-i2) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideOutHorizontally(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOutHorizontally(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final Function1<? super Integer, Integer> function1) {
        return slideOut(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutHorizontally$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m7108boximpl(m414invokemHKZG7I(intSize.m7164unboximpl()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m414invokemHKZG7I(long j) {
                return IntOffset.m7111constructorimpl(function1.invoke(Integer.valueOf((int) (j >> 32))).intValue() << 32);
            }
        });
    }

    public static /* synthetic */ ExitTransition slideOutVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m7108boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutVertically$1
                public final Integer invoke(int i2) {
                    return Integer.valueOf((-i2) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideOutVertically(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOutVertically(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final Function1<? super Integer, Integer> function1) {
        return slideOut(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutVertically$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m7108boximpl(m415invokemHKZG7I(intSize.m7164unboximpl()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m415invokemHKZG7I(long j) {
                return IntOffset.m7111constructorimpl(function1.invoke(Integer.valueOf((int) (j & 4294967295L))).intValue() & 4294967295L);
            }
        });
    }

    private static final Alignment toAlignment(Alignment.Horizontal horizontal) {
        return Intrinsics.areEqual(horizontal, Alignment.INSTANCE.getStart()) ? Alignment.INSTANCE.getCenterStart() : Intrinsics.areEqual(horizontal, Alignment.INSTANCE.getEnd()) ? Alignment.INSTANCE.getCenterEnd() : Alignment.INSTANCE.getCenter();
    }

    private static final Alignment toAlignment(Alignment.Vertical vertical) {
        return Intrinsics.areEqual(vertical, Alignment.INSTANCE.getTop()) ? Alignment.INSTANCE.getTopCenter() : Intrinsics.areEqual(vertical, Alignment.INSTANCE.getBottom()) ? Alignment.INSTANCE.getBottomCenter() : Alignment.INSTANCE.getCenter();
    }

    public static final <T extends TransitionEffect> T get(EnterTransition enterTransition, TransitionEffectKey<T> transitionEffectKey) {
        TransitionEffect transitionEffect = enterTransition.getData().getEffectsMap().get(transitionEffectKey);
        if (transitionEffect instanceof TransitionEffect) {
            return (T) transitionEffect;
        }
        return null;
    }

    public static final <T extends TransitionEffect> T get(ExitTransition exitTransition, TransitionEffectKey<T> transitionEffectKey) {
        TransitionEffect transitionEffect = exitTransition.getData().getEffectsMap().get(transitionEffectKey);
        if (transitionEffect instanceof TransitionEffect) {
            return (T) transitionEffect;
        }
        return null;
    }

    public static final Modifier createModifier(Transition<EnterExitState> transition, EnterTransition enterTransition, ExitTransition exitTransition, Function0<Boolean> function0, String str, Composer composer, int i, int i2) {
        String str2;
        Transition.DeferredAnimation deferredAnimation;
        Transition.DeferredAnimation deferredAnimation2;
        ChangeSize changeSize;
        ComposerKt.sourceInformationMarkerStart(composer, 28261782, "C(createModifier)861@38434L31,862@38487L28,891@39539L56,892@39630L38:EnterExitTransition.kt#xbi5r1");
        final Function0<Boolean> function02 = (i2 & 4) != 0 ? new Function0<Boolean>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return true;
            }
        } : function0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(28261782, i, -1, "androidx.compose.animation.createModifier (EnterExitTransition.kt:860)");
        }
        int i3 = i & 14;
        EnterTransition trackActiveEnter = trackActiveEnter(transition, enterTransition, composer, i & WebSocketProtocol.PAYLOAD_SHORT);
        int i4 = i >> 3;
        ExitTransition trackActiveExit = trackActiveExit(transition, exitTransition, composer, (i4 & 112) | i3);
        boolean z = (trackActiveEnter.getData().getSlide() == null && trackActiveExit.getData().getSlide() == null) ? false : true;
        boolean z2 = (trackActiveEnter.getData().getChangeSize() == null && trackActiveExit.getData().getChangeSize() == null) ? false : true;
        Transition.DeferredAnimation deferredAnimation3 = null;
        if (!z) {
            str2 = "CC(remember):EnterExitTransition.kt#9igjgp";
            composer.startReplaceGroup(-821053656);
            composer.endReplaceGroup();
            deferredAnimation = null;
        } else {
            composer.startReplaceGroup(-821159459);
            ComposerKt.sourceInformation(composer, "870@38849L27,870@38798L79");
            TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composer, -165034343, "CC(remember):EnterExitTransition.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = str + " slide";
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            str2 = "CC(remember):EnterExitTransition.kt#9igjgp";
            Transition.DeferredAnimation createDeferredAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition, vectorConverter, (String) rememberedValue, composer, i3 | 384, 0);
            composer.endReplaceGroup();
            deferredAnimation = createDeferredAnimation;
        }
        if (z2) {
            composer.startReplaceGroup(-820961865);
            ComposerKt.sourceInformation(composer, "876@39046L35,876@38997L85");
            TwoWayConverter<IntSize, AnimationVector2D> vectorConverter2 = VectorConvertersKt.getVectorConverter(IntSize.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composer, -165028031, str2);
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = str + " shrink/expand";
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Transition.DeferredAnimation createDeferredAnimation2 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition, vectorConverter2, (String) rememberedValue2, composer, i3 | 384, 0);
            composer.endReplaceGroup();
            deferredAnimation2 = createDeferredAnimation2;
        } else {
            composer.startReplaceGroup(-820851041);
            composer.endReplaceGroup();
            deferredAnimation2 = null;
        }
        if (z2) {
            composer.startReplaceGroup(-820777446);
            ComposerKt.sourceInformation(composer, "883@39265L48,881@39181L146");
            TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter3 = VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composer, -165021010, str2);
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = str + " InterruptionHandlingOffset";
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            deferredAnimation3 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition, vectorConverter3, (String) rememberedValue3, composer, i3 | 384, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-820608001);
            composer.endReplaceGroup();
        }
        ChangeSize changeSize2 = trackActiveEnter.getData().getChangeSize();
        final boolean z3 = ((changeSize2 == null || changeSize2.getClip()) && ((changeSize = trackActiveExit.getData().getChangeSize()) == null || changeSize.getClip()) && z2) ? false : true;
        GraphicsLayerBlockForEnterExit createGraphicsLayerBlock = createGraphicsLayerBlock(transition, trackActiveEnter, trackActiveExit, str, composer, i3 | (i4 & 7168));
        Modifier.Companion companion = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -165009340, str2);
        boolean changed = composer.changed(z3) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(function02)) || (i & 3072) == 2048);
        Object rememberedValue4 = composer.rememberedValue();
        if (changed || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                    invoke2(graphicsLayerScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                    graphicsLayerScope.setClip(!z3 && function02.invoke().booleanValue());
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier then = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) rememberedValue4).then(new EnterExitTransitionElement(transition, deferredAnimation2, deferredAnimation3, deferredAnimation, trackActiveEnter, trackActiveExit, function02, createGraphicsLayerBlock));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return then;
    }

    public static final EnterTransition trackActiveEnter(Transition<EnterExitState> transition, EnterTransition enterTransition, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 21614502, "C(trackActiveEnter)913@40506L40:EnterExitTransition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(21614502, i, -1, "androidx.compose.animation.trackActiveEnter (EnterExitTransition.kt:908)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1583267014, "CC(remember):EnterExitTransition.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(transition)) || (i & 6) == 4;
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(enterTransition, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableState mutableState = (MutableState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (transition.getCurrentState() == transition.getTargetState() && transition.getCurrentState() == EnterExitState.Visible) {
            if (transition.isSeeking()) {
                mutableState.setValue(enterTransition);
            } else {
                mutableState.setValue(EnterTransition.INSTANCE.getNone());
            }
        } else if (transition.getTargetState() == EnterExitState.Visible) {
            mutableState.setValue(trackActiveEnter$lambda$5(mutableState).plus(enterTransition));
        }
        EnterTransition trackActiveEnter$lambda$5 = trackActiveEnter$lambda$5(mutableState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return trackActiveEnter$lambda$5;
    }

    private static final EnterTransition trackActiveEnter$lambda$5(MutableState<EnterTransition> mutableState) {
        return mutableState.getValue();
    }

    public static final ExitTransition trackActiveExit(Transition<EnterExitState> transition, ExitTransition exitTransition, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1363864804, "C(trackActiveExit)933@41487L39:EnterExitTransition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1363864804, i, -1, "androidx.compose.animation.trackActiveExit (EnterExitTransition.kt:928)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1483151723, "CC(remember):EnterExitTransition.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(transition)) || (i & 6) == 4;
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(exitTransition, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableState mutableState = (MutableState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (transition.getCurrentState() == transition.getTargetState() && transition.getCurrentState() == EnterExitState.Visible) {
            if (transition.isSeeking()) {
                mutableState.setValue(exitTransition);
            } else {
                mutableState.setValue(ExitTransition.INSTANCE.getNone());
            }
        } else if (transition.getTargetState() != EnterExitState.Visible) {
            mutableState.setValue(trackActiveExit$lambda$8(mutableState).plus(exitTransition));
        }
        ExitTransition trackActiveExit$lambda$8 = trackActiveExit$lambda$8(mutableState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return trackActiveExit$lambda$8;
    }

    private static final ExitTransition trackActiveExit$lambda$8(MutableState<ExitTransition> mutableState) {
        return mutableState.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0144, code lost:
    
        if (r3.changed(r1) == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x015f, code lost:
    
        if (r3.changed(r2) == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x017e, code lost:
    
        if (r3.changed(r4) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0187, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0188, code lost:
    
        r0 = (r0 | r8) | r3.changedInstance(r12);
        r5 = r3.rememberedValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0192, code lost:
    
        if (r0 != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x019a, code lost:
    
        if (r5 != androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01ad, code lost:
    
        r5 = (androidx.compose.animation.GraphicsLayerBlockForEnterExit) r5;
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01b6, code lost:
    
        if (androidx.compose.runtime.ComposerKt.isTraceInProgress() == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01b8, code lost:
    
        androidx.compose.runtime.ComposerKt.traceEventEnd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01bb, code lost:
    
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01be, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x019c, code lost:
    
        r17 = r1;
        r18 = r2;
        r16 = r4;
        r19 = r12;
        r13 = new androidx.compose.animation.EnterExitTransitionKt$$ExternalSyntheticLambda0(r14, r15, r16, r17, r18, r19);
        r3.updateRememberedValue(r13);
        r5 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0185, code lost:
    
        if ((r25 & 6) == 4) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0162  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final androidx.compose.animation.GraphicsLayerBlockForEnterExit createGraphicsLayerBlock(androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r20, androidx.compose.animation.EnterTransition r21, androidx.compose.animation.ExitTransition r22, java.lang.String r23, androidx.compose.runtime.Composer r24, int r25) {
        /*
            Method dump skipped, instructions count: 447
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt.createGraphicsLayerBlock(androidx.compose.animation.core.Transition, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, androidx.compose.runtime.Composer, int):androidx.compose.animation.GraphicsLayerBlockForEnterExit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Function1 createGraphicsLayerBlock$lambda$13$lambda$12(Transition.DeferredAnimation deferredAnimation, Transition.DeferredAnimation deferredAnimation2, Transition transition, final EnterTransition enterTransition, final ExitTransition exitTransition, Transition.DeferredAnimation deferredAnimation3) {
        final TransformOrigin m4762boximpl;
        final State animate = deferredAnimation != null ? deferredAnimation.animate(new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FiniteAnimationSpec<Float> invoke(Transition.Segment<EnterExitState> segment) {
                SpringSpec springSpec;
                SpringSpec springSpec2;
                FiniteAnimationSpec<Float> animationSpec;
                SpringSpec springSpec3;
                FiniteAnimationSpec<Float> animationSpec2;
                if (segment.isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
                    Fade fade = EnterTransition.this.getData().getFade();
                    if (fade != null && (animationSpec2 = fade.getAnimationSpec()) != null) {
                        return animationSpec2;
                    }
                    springSpec3 = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                    return springSpec3;
                }
                if (!segment.isTransitioningTo(EnterExitState.Visible, EnterExitState.PostExit)) {
                    springSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                    return springSpec;
                }
                Fade fade2 = exitTransition.getData().getFade();
                if (fade2 != null && (animationSpec = fade2.getAnimationSpec()) != null) {
                    return animationSpec;
                }
                springSpec2 = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                return springSpec2;
            }
        }, new Function1<EnterExitState, Float>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$2

            /* compiled from: EnterExitTransition.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[EnterExitState.values().length];
                    try {
                        iArr[EnterExitState.Visible.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnterExitState.PreEnter.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[EnterExitState.PostExit.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Float invoke(EnterExitState enterExitState) {
                int i = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
                float f = 1.0f;
                if (i != 1) {
                    if (i == 2) {
                        Fade fade = EnterTransition.this.getData().getFade();
                        if (fade != null) {
                            f = fade.getAlpha();
                        }
                    } else {
                        if (i != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Fade fade2 = exitTransition.getData().getFade();
                        if (fade2 != null) {
                            f = fade2.getAlpha();
                        }
                    }
                }
                return Float.valueOf(f);
            }
        }) : null;
        final State animate2 = deferredAnimation2 != null ? deferredAnimation2.animate(new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FiniteAnimationSpec<Float> invoke(Transition.Segment<EnterExitState> segment) {
                SpringSpec springSpec;
                SpringSpec springSpec2;
                FiniteAnimationSpec<Float> animationSpec;
                SpringSpec springSpec3;
                FiniteAnimationSpec<Float> animationSpec2;
                if (segment.isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
                    Scale scale = EnterTransition.this.getData().getScale();
                    if (scale != null && (animationSpec2 = scale.getAnimationSpec()) != null) {
                        return animationSpec2;
                    }
                    springSpec3 = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                    return springSpec3;
                }
                if (!segment.isTransitioningTo(EnterExitState.Visible, EnterExitState.PostExit)) {
                    springSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                    return springSpec;
                }
                Scale scale2 = exitTransition.getData().getScale();
                if (scale2 != null && (animationSpec = scale2.getAnimationSpec()) != null) {
                    return animationSpec;
                }
                springSpec2 = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                return springSpec2;
            }
        }, new Function1<EnterExitState, Float>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$2

            /* compiled from: EnterExitTransition.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[EnterExitState.values().length];
                    try {
                        iArr[EnterExitState.Visible.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnterExitState.PreEnter.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[EnterExitState.PostExit.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Float invoke(EnterExitState enterExitState) {
                int i = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
                float f = 1.0f;
                if (i != 1) {
                    if (i == 2) {
                        Scale scale = EnterTransition.this.getData().getScale();
                        if (scale != null) {
                            f = scale.getScale();
                        }
                    } else {
                        if (i != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Scale scale2 = exitTransition.getData().getScale();
                        if (scale2 != null) {
                            f = scale2.getScale();
                        }
                    }
                }
                return Float.valueOf(f);
            }
        }) : null;
        if (transition.getCurrentState() == EnterExitState.PreEnter) {
            Scale scale = enterTransition.getData().getScale();
            if (scale != null || (scale = exitTransition.getData().getScale()) != null) {
                m4762boximpl = TransformOrigin.m4762boximpl(scale.m427getTransformOriginSzJe1aQ());
            }
            m4762boximpl = null;
        } else {
            Scale scale2 = exitTransition.getData().getScale();
            if (scale2 != null || (scale2 = enterTransition.getData().getScale()) != null) {
                m4762boximpl = TransformOrigin.m4762boximpl(scale2.m427getTransformOriginSzJe1aQ());
            }
            m4762boximpl = null;
        }
        final State animate3 = deferredAnimation3 != null ? deferredAnimation3.animate(new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<TransformOrigin>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1
            @Override // kotlin.jvm.functions.Function1
            public final FiniteAnimationSpec<TransformOrigin> invoke(Transition.Segment<EnterExitState> segment) {
                return AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            }
        }, new Function1<EnterExitState, TransformOrigin>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$2

            /* compiled from: EnterExitTransition.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[EnterExitState.values().length];
                    try {
                        iArr[EnterExitState.Visible.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnterExitState.PreEnter.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[EnterExitState.PostExit.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TransformOrigin invoke(EnterExitState enterExitState) {
                return TransformOrigin.m4762boximpl(m405invokeLIALnN8(enterExitState));
            }

            /* renamed from: invoke-LIALnN8, reason: not valid java name */
            public final long m405invokeLIALnN8(EnterExitState enterExitState) {
                TransformOrigin transformOrigin;
                long m427getTransformOriginSzJe1aQ;
                long m427getTransformOriginSzJe1aQ2;
                int i = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
                if (i != 1) {
                    transformOrigin = null;
                    if (i == 2) {
                        Scale scale3 = enterTransition.getData().getScale();
                        if (scale3 != null) {
                            m427getTransformOriginSzJe1aQ = scale3.m427getTransformOriginSzJe1aQ();
                        } else {
                            Scale scale4 = exitTransition.getData().getScale();
                            if (scale4 != null) {
                                m427getTransformOriginSzJe1aQ = scale4.m427getTransformOriginSzJe1aQ();
                            }
                        }
                        transformOrigin = TransformOrigin.m4762boximpl(m427getTransformOriginSzJe1aQ);
                    } else {
                        if (i != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Scale scale5 = exitTransition.getData().getScale();
                        if (scale5 != null) {
                            m427getTransformOriginSzJe1aQ2 = scale5.m427getTransformOriginSzJe1aQ();
                        } else {
                            Scale scale6 = enterTransition.getData().getScale();
                            if (scale6 != null) {
                                m427getTransformOriginSzJe1aQ2 = scale6.m427getTransformOriginSzJe1aQ();
                            }
                        }
                        transformOrigin = TransformOrigin.m4762boximpl(m427getTransformOriginSzJe1aQ2);
                    }
                } else {
                    transformOrigin = TransformOrigin.this;
                }
                if (transformOrigin != null) {
                    return transformOrigin.getPackedValue();
                }
                return TransformOrigin.INSTANCE.m4775getCenterSzJe1aQ();
            }
        }) : null;
        return new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$block$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                invoke2(graphicsLayerScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                State<Float> state = animate;
                graphicsLayerScope.setAlpha(state != null ? state.getValue().floatValue() : 1.0f);
                State<Float> state2 = animate2;
                graphicsLayerScope.setScaleX(state2 != null ? state2.getValue().floatValue() : 1.0f);
                State<Float> state3 = animate2;
                graphicsLayerScope.setScaleY(state3 != null ? state3.getValue().floatValue() : 1.0f);
                State<TransformOrigin> state4 = animate3;
                graphicsLayerScope.mo4576setTransformOrigin__ExYCQ(state4 != null ? state4.getValue().getPackedValue() : TransformOrigin.INSTANCE.m4775getCenterSzJe1aQ());
            }
        };
    }
}
