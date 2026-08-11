package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.BasicTooltipDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;

/* compiled from: Tooltip.kt */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\u001al\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020!0%¢\u0006\u0002\b'¢\u0006\u0002\b(2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020!01¢\u0006\u0002\b'H\u0007¢\u0006\u0002\u00102\u001a&\u00103\u001a\u00020*2\b\b\u0002\u00104\u001a\u00020.2\b\b\u0002\u00105\u001a\u00020.2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a+\u00108\u001a\u00020*2\b\b\u0002\u00104\u001a\u00020.2\b\b\u0002\u00105\u001a\u00020.2\b\b\u0002\u00106\u001a\u000207H\u0007¢\u0006\u0002\u00109\u001a\u001a\u0010:\u001a\u00020,*\u00020,2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020.0<H\u0000\u001a\u001c\u0010=\u001a\u00020,*\u00020,2\u0006\u0010>\u001a\u00020.2\u0006\u0010?\u001a\u00020.H\u0001\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\b\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\t\u0010\u0003\"\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\"\u0010\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u000f\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\u0003\"\u0010\u0010\u0011\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u0012\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0013\u0010\u0003\"\u0016\u0010\u0014\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0015\u0010\u0003\"\u0016\u0010\u0016\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0017\u0010\u0003\"\u0010\u0010\u0018\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0019\u001a\u00020\u001aX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u001aX\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u001c\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u001d\u0010\u0003\"\u0016\u0010\u001e\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u001f\u0010\u0003¨\u0006@²\u0006\n\u0010A\u001a\u00020BX\u008a\u0084\u0002²\u0006\n\u0010C\u001a\u00020BX\u008a\u0084\u0002"}, d2 = {"ActionLabelBottomPadding", "Landroidx/compose/ui/unit/Dp;", "getActionLabelBottomPadding", "()F", "F", "ActionLabelMinHeight", "getActionLabelMinHeight", "HeightFromSubheadToTextFirstLine", "HeightToSubheadFirstLine", "getHeightToSubheadFirstLine", "PlainTooltipContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getPlainTooltipContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "PlainTooltipHorizontalPadding", "PlainTooltipMaxWidth", "getPlainTooltipMaxWidth", "PlainTooltipVerticalPadding", "RichTooltipHorizontalPadding", "getRichTooltipHorizontalPadding", "RichTooltipMaxWidth", "getRichTooltipMaxWidth", "SpacingBetweenTooltipAndAnchor", "getSpacingBetweenTooltipAndAnchor", "TextBottomPadding", "TooltipFadeInDuration", "", "TooltipFadeOutDuration", "TooltipMinHeight", "getTooltipMinHeight", "TooltipMinWidth", "getTooltipMinWidth", "TooltipBox", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function1;", "Landroidx/compose/material3/TooltipScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/material3/TooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "focusable", "", "enableUserInput", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function3;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipState", "initialIsVisible", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "rememberTooltipState", "(ZZLandroidx/compose/foundation/MutatorMutex;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TooltipState;", "animateTooltip", "transition", "Landroidx/compose/animation/core/Transition;", "textVerticalPadding", "subheadExists", "actionExists", "material3_release", "scale", "", "alpha"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class TooltipKt {
    private static final float ActionLabelBottomPadding;
    private static final float ActionLabelMinHeight;
    private static final float HeightFromSubheadToTextFirstLine;
    private static final float HeightToSubheadFirstLine;
    private static final PaddingValues PlainTooltipContentPadding;
    private static final float PlainTooltipHorizontalPadding;
    private static final float PlainTooltipVerticalPadding;
    private static final float RichTooltipHorizontalPadding;
    private static final float RichTooltipMaxWidth;
    private static final float TextBottomPadding;
    public static final int TooltipFadeInDuration = 150;
    public static final int TooltipFadeOutDuration = 75;
    private static final float SpacingBetweenTooltipAndAnchor = Dp.m6989constructorimpl(4.0f);
    private static final float TooltipMinHeight = Dp.m6989constructorimpl(24.0f);
    private static final float TooltipMinWidth = Dp.m6989constructorimpl(40.0f);
    private static final float PlainTooltipMaxWidth = Dp.m6989constructorimpl(200.0f);

    /* JADX WARN: Removed duplicated region for block: B:16:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TooltipBox(final androidx.compose.ui.window.PopupPositionProvider r17, final kotlin.jvm.functions.Function3<? super androidx.compose.material3.TooltipScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r18, final androidx.compose.material3.TooltipState r19, androidx.compose.ui.Modifier r20, boolean r21, boolean r22, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TooltipKt.TooltipBox(androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function3, androidx.compose.material3.TooltipState, androidx.compose.ui.Modifier, boolean, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final TooltipState rememberTooltipState(boolean z, boolean z2, MutatorMutex mutatorMutex, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1413230530, "C(rememberTooltipState)436@18949L210:Tooltip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1413230530, i, -1, "androidx.compose.material3.rememberTooltipState (Tooltip.kt:436)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1281295952, "CC(remember):Tooltip.kt#9igjgp");
        boolean z3 = ((((i & 112) ^ 48) > 32 && composer.changed(z2)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(mutatorMutex)) || (i & 384) == 256);
        Object rememberedValue = composer.rememberedValue();
        if (z3 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new TooltipStateImpl(z, z2, mutatorMutex);
            composer.updateRememberedValue(rememberedValue);
        }
        TooltipStateImpl tooltipStateImpl = (TooltipStateImpl) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return tooltipStateImpl;
    }

    public static /* synthetic */ TooltipState TooltipState$default(boolean z, boolean z2, MutatorMutex mutatorMutex, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        return TooltipState(z, z2, mutatorMutex);
    }

    public static final TooltipState TooltipState(boolean z, boolean z2, MutatorMutex mutatorMutex) {
        return new TooltipStateImpl(z, z2, mutatorMutex);
    }

    public static final Modifier textVerticalPadding(Modifier modifier, boolean z, boolean z2) {
        if (!z && !z2) {
            return PaddingKt.m1051paddingVpY3zN4$default(modifier, 0.0f, PlainTooltipVerticalPadding, 1, null);
        }
        return PaddingKt.m1053paddingqDBjuR0$default(AlignmentLineKt.m905paddingFromBaselineVpY3zN4$default(modifier, HeightFromSubheadToTextFirstLine, 0.0f, 2, null), 0.0f, 0.0f, 0.0f, TextBottomPadding, 7, null);
    }

    public static final float getSpacingBetweenTooltipAndAnchor() {
        return SpacingBetweenTooltipAndAnchor;
    }

    public static final float getTooltipMinHeight() {
        return TooltipMinHeight;
    }

    public static final float getTooltipMinWidth() {
        return TooltipMinWidth;
    }

    public static final float getPlainTooltipMaxWidth() {
        return PlainTooltipMaxWidth;
    }

    public static final PaddingValues getPlainTooltipContentPadding() {
        return PlainTooltipContentPadding;
    }

    public static final float getRichTooltipMaxWidth() {
        return RichTooltipMaxWidth;
    }

    public static final float getRichTooltipHorizontalPadding() {
        return RichTooltipHorizontalPadding;
    }

    public static final float getHeightToSubheadFirstLine() {
        return HeightToSubheadFirstLine;
    }

    public static final float getActionLabelMinHeight() {
        return ActionLabelMinHeight;
    }

    public static final float getActionLabelBottomPadding() {
        return ActionLabelBottomPadding;
    }

    public static final Modifier animateTooltip(Modifier modifier, final Transition<Boolean> transition) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("animateTooltip");
                inspectorInfo.getProperties().set("transition", Transition.this);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceGroup(-1498516085);
                ComposerKt.sourceInformation(composer, "C585@24638L747,607@25431L561:Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1498516085, i, -1, "androidx.compose.material3.animateTooltip.<anonymous> (Tooltip.kt:584)");
                }
                Transition<Boolean> transition2 = transition;
                TooltipKt$animateTooltip$2$scale$2 tooltipKt$animateTooltip$2$scale$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$2$scale$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                        return invoke(segment, composer2, num.intValue());
                    }

                    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, int i2) {
                        TweenSpec tween$default;
                        composer2.startReplaceGroup(386845748);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(386845748, i2, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:587)");
                        }
                        if (segment.isTransitioningTo(false, true)) {
                            tween$default = AnimationSpecKt.tween$default(150, 0, EasingKt.getLinearOutSlowInEasing(), 2, null);
                        } else {
                            tween$default = AnimationSpecKt.tween$default(75, 0, EasingKt.getLinearOutSlowInEasing(), 2, null);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2.endReplaceGroup();
                        return tween$default;
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
                TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
                boolean booleanValue = transition2.getCurrentState().booleanValue();
                composer.startReplaceGroup(-1553362193);
                ComposerKt.sourceInformation(composer, "C:Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1553362193, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:603)");
                }
                float f = booleanValue ? 1.0f : 0.8f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                Float valueOf = Float.valueOf(f);
                boolean booleanValue2 = transition2.getTargetState().booleanValue();
                composer.startReplaceGroup(-1553362193);
                ComposerKt.sourceInformation(composer, "C:Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1553362193, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:603)");
                }
                float f2 = booleanValue2 ? 1.0f : 0.8f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                State createTransitionAnimation = TransitionKt.createTransitionAnimation(transition2, valueOf, Float.valueOf(f2), tooltipKt$animateTooltip$2$scale$2.invoke((TooltipKt$animateTooltip$2$scale$2) transition2.getSegment(), (Transition.Segment<Boolean>) composer, (Composer) 0), vectorConverter, "tooltip transition: scaling", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Transition<Boolean> transition3 = transition;
                TooltipKt$animateTooltip$2$alpha$2 tooltipKt$animateTooltip$2$alpha$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$2$alpha$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                        return invoke(segment, composer2, num.intValue());
                    }

                    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, int i2) {
                        TweenSpec tween$default;
                        composer2.startReplaceGroup(-281714272);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-281714272, i2, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:609)");
                        }
                        if (segment.isTransitioningTo(false, true)) {
                            tween$default = AnimationSpecKt.tween$default(150, 0, EasingKt.getLinearEasing(), 2, null);
                        } else {
                            tween$default = AnimationSpecKt.tween$default(75, 0, EasingKt.getLinearEasing(), 2, null);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2.endReplaceGroup();
                        return tween$default;
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
                TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
                boolean booleanValue3 = transition3.getCurrentState().booleanValue();
                composer.startReplaceGroup(2073045083);
                ComposerKt.sourceInformation(composer, "C:Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2073045083, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:619)");
                }
                float f3 = booleanValue3 ? 1.0f : 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                Float valueOf2 = Float.valueOf(f3);
                boolean booleanValue4 = transition3.getTargetState().booleanValue();
                composer.startReplaceGroup(2073045083);
                ComposerKt.sourceInformation(composer, "C:Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2073045083, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:619)");
                }
                float f4 = booleanValue4 ? 1.0f : 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                State createTransitionAnimation2 = TransitionKt.createTransitionAnimation(transition3, valueOf2, Float.valueOf(f4), tooltipKt$animateTooltip$2$alpha$2.invoke((TooltipKt$animateTooltip$2$alpha$2) transition3.getSegment(), (Transition.Segment<Boolean>) composer, (Composer) 0), vectorConverter2, "tooltip transition: alpha", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier m4544graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m4544graphicsLayerAp8cVGQ$default(modifier2, invoke$lambda$1(createTransitionAnimation), invoke$lambda$1(createTransitionAnimation), invoke$lambda$3(createTransitionAnimation2), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131064, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return m4544graphicsLayerAp8cVGQ$default;
            }

            private static final float invoke$lambda$1(State<Float> state) {
                return state.getValue().floatValue();
            }

            private static final float invoke$lambda$3(State<Float> state) {
                return state.getValue().floatValue();
            }
        });
    }

    static {
        float m6989constructorimpl = Dp.m6989constructorimpl(4.0f);
        PlainTooltipVerticalPadding = m6989constructorimpl;
        float m6989constructorimpl2 = Dp.m6989constructorimpl(8.0f);
        PlainTooltipHorizontalPadding = m6989constructorimpl2;
        PlainTooltipContentPadding = PaddingKt.m1043PaddingValuesYgX7TsA(m6989constructorimpl2, m6989constructorimpl);
        RichTooltipMaxWidth = Dp.m6989constructorimpl(320.0f);
        RichTooltipHorizontalPadding = Dp.m6989constructorimpl(16.0f);
        HeightToSubheadFirstLine = Dp.m6989constructorimpl(28.0f);
        HeightFromSubheadToTextFirstLine = Dp.m6989constructorimpl(24.0f);
        TextBottomPadding = Dp.m6989constructorimpl(16.0f);
        ActionLabelMinHeight = Dp.m6989constructorimpl(36.0f);
        ActionLabelBottomPadding = Dp.m6989constructorimpl(8.0f);
    }
}
