package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.internal.ViewUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

/* compiled from: PullToRefresh.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0002\u001a(\u0010\u0017\u001a\u00020\u00182\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u007f\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u00192\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\u001e\b\u0002\u0010(\u001a\u0018\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00180)¢\u0006\u0002\b+¢\u0006\u0002\b,2\u001c\u0010-\u001a\u0018\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00180)¢\u0006\u0002\b+¢\u0006\u0002\b,H\u0007¢\u0006\u0002\u0010.\u001a\b\u0010/\u001a\u00020%H\u0007\u001a\r\u00100\u001a\u00020%H\u0007¢\u0006\u0002\u00101\u001aF\u00102\u001a\u00020\u0018*\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a>\u0010=\u001a\u00020\u0018*\u0002032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u00152\u0006\u0010>\u001a\u0002072\u0006\u0010:\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001aH\u0010A\u001a\u00020#*\u00020#2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010B\u001a\u00020 2\b\b\u0002\u0010C\u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001aN\u0010F\u001a\u00020#*\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010C\u001a\u00020\u00042\b\b\u0002\u0010G\u001a\u00020H2\b\b\u0002\u0010I\u001a\u00020\u001b2\b\b\u0002\u0010J\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\bK\u0010L\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u000e\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u000f\u0010\u0010\"\u0016\u0010\u0011\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0012\u0010\u0010\"\u0010\u0010\u0013\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006M²\u0006\n\u0010N\u001a\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"AlphaTween", "Landroidx/compose/animation/core/TweenSpec;", "", "ArcRadius", "Landroidx/compose/ui/unit/Dp;", "F", "ArrowHeight", "ArrowWidth", "CrossfadeDurationMs", "", "DragMultiplier", "MaxAlpha", "MaxProgressArc", "MinAlpha", "SpinnerContainerSize", "getSpinnerContainerSize", "()F", "SpinnerSize", "getSpinnerSize", "StrokeWidth", "ArrowValues", "Landroidx/compose/material3/pulltorefresh/ArrowValues;", "progress", "CircularArrowProgressIndicator", "", "Lkotlin/Function0;", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Color;", "CircularArrowProgressIndicator-RPmYEkk", "(Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "PullToRefreshBox", "isRefreshing", "", "onRefresh", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "indicator", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", FirebaseAnalytics.Param.CONTENT, "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/pulltorefresh/PullToRefreshState;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "PullToRefreshState", "rememberPullToRefreshState", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "drawArrow", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "alpha", "values", "strokeWidth", "drawArrow-uDrxG_w", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;F)V", "drawCircularIndicator", "arcBounds", "drawCircularIndicator-KzyDr3Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;Landroidx/compose/ui/geometry/Rect;F)V", "pullToRefresh", "enabled", "threshold", "pullToRefresh-Z4HSEVQ", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;ZFLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/Modifier;", "pullToRefreshIndicator", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "elevation", "pullToRefreshIndicator-wUdLESc", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/pulltorefresh/PullToRefreshState;ZFLandroidx/compose/ui/graphics/Shape;JF)Landroidx/compose/ui/Modifier;", "material3_release", "targetAlpha"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class PullToRefreshKt {
    private static final int CrossfadeDurationMs = 100;
    private static final float DragMultiplier = 0.5f;
    private static final float MaxAlpha = 1.0f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final float StrokeWidth = Dp.m6989constructorimpl(2.5f);
    private static final float ArcRadius = Dp.m6989constructorimpl(5.5f);
    private static final float SpinnerSize = Dp.m6989constructorimpl(16.0f);
    private static final float SpinnerContainerSize = Dp.m6989constructorimpl(40.0f);
    private static final float ArrowWidth = Dp.m6989constructorimpl(10.0f);
    private static final float ArrowHeight = Dp.m6989constructorimpl(5.0f);
    private static final TweenSpec<Float> AlphaTween = AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null);

    /* JADX WARN: Removed duplicated region for block: B:104:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void PullToRefreshBox(final boolean r16, final kotlin.jvm.functions.Function0<kotlin.Unit> r17, androidx.compose.ui.Modifier r18, androidx.compose.material3.pulltorefresh.PullToRefreshState r19, androidx.compose.ui.Alignment r20, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.BoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.BoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instructions count: 580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshKt.PullToRefreshBox(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.material3.pulltorefresh.PullToRefreshState, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: pullToRefreshIndicator-wUdLESc$default, reason: not valid java name */
    public static /* synthetic */ Modifier m3126pullToRefreshIndicatorwUdLESc$default(Modifier modifier, PullToRefreshState pullToRefreshState, boolean z, float f, Shape shape, long j, float f2, int i, Object obj) {
        if ((i & 4) != 0) {
            f = PullToRefreshDefaults.INSTANCE.m3112getPositionalThresholdD9Ej5fM();
        }
        float f3 = f;
        if ((i & 8) != 0) {
            shape = PullToRefreshDefaults.INSTANCE.getShape();
        }
        Shape shape2 = shape;
        if ((i & 16) != 0) {
            j = Color.INSTANCE.m4420getUnspecified0d7_KjU();
        }
        return m3125pullToRefreshIndicatorwUdLESc(modifier, pullToRefreshState, z, f3, shape2, j, (i & 32) != 0 ? PullToRefreshDefaults.INSTANCE.m3111getElevationD9Ej5fM() : f2);
    }

    /* renamed from: pullToRefreshIndicator-wUdLESc, reason: not valid java name */
    public static final Modifier m3125pullToRefreshIndicatorwUdLESc(Modifier modifier, final PullToRefreshState pullToRefreshState, final boolean z, final float f, final Shape shape, long j, final float f2) {
        return BackgroundKt.m557backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(DrawModifierKt.drawWithContent(SizeKt.m1096size3ABfNKs(modifier, SpinnerContainerSize), new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$pullToRefreshIndicator$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope contentDrawScope) {
                int m4373getIntersectrtfAjoo = ClipOp.INSTANCE.m4373getIntersectrtfAjoo();
                DrawContext drawContext = contentDrawScope.getDrawContext();
                long mo4856getSizeNHjbRc = drawContext.mo4856getSizeNHjbRc();
                drawContext.getCanvas().save();
                try {
                    drawContext.getTransform().mo4859clipRectN_I0leg(-3.4028235E38f, 0.0f, Float.MAX_VALUE, Float.MAX_VALUE, m4373getIntersectrtfAjoo);
                    contentDrawScope.drawContent();
                } finally {
                    drawContext.getCanvas().restore();
                    drawContext.mo4857setSizeuvyYCjk(mo4856getSizeNHjbRc);
                }
            }
        }), new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$pullToRefreshIndicator$2
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
                boolean z2 = PullToRefreshState.this.getDistanceFraction() > 0.0f || z;
                graphicsLayerScope.setTranslationY((PullToRefreshState.this.getDistanceFraction() * graphicsLayerScope.mo694roundToPx0680j_4(f)) - Size.m4191getHeightimpl(graphicsLayerScope.getSize()));
                graphicsLayerScope.setShadowElevation(z2 ? graphicsLayerScope.mo700toPx0680j_4(f2) : 0.0f);
                graphicsLayerScope.setShape(shape);
                graphicsLayerScope.setClip(true);
            }
        }), j, shape);
    }

    /* renamed from: pullToRefresh-Z4HSEVQ$default, reason: not valid java name */
    public static /* synthetic */ Modifier m3124pullToRefreshZ4HSEVQ$default(Modifier modifier, boolean z, PullToRefreshState pullToRefreshState, boolean z2, float f, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        boolean z3 = z2;
        if ((i & 8) != 0) {
            f = PullToRefreshDefaults.INSTANCE.m3112getPositionalThresholdD9Ej5fM();
        }
        return m3123pullToRefreshZ4HSEVQ(modifier, z, pullToRefreshState, z3, f, function0);
    }

    /* renamed from: pullToRefresh-Z4HSEVQ, reason: not valid java name */
    public static final Modifier m3123pullToRefreshZ4HSEVQ(Modifier modifier, boolean z, PullToRefreshState pullToRefreshState, boolean z2, float f, Function0<Unit> function0) {
        return modifier.then(new PullToRefreshElement(z, function0, z2, pullToRefreshState, f, null));
    }

    public static final PullToRefreshState rememberPullToRefreshState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 318623070, "C(rememberPullToRefreshState)513@19156L83:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(318623070, i, -1, "androidx.compose.material3.pulltorefresh.rememberPullToRefreshState (PullToRefresh.kt:512)");
        }
        PullToRefreshStateImpl pullToRefreshStateImpl = (PullToRefreshStateImpl) RememberSaveableKt.m3923rememberSaveable(new Object[0], (Saver) PullToRefreshStateImpl.INSTANCE.getSaver(), (String) null, (Function0) new Function0<PullToRefreshStateImpl>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$rememberPullToRefreshState$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PullToRefreshStateImpl invoke() {
                return new PullToRefreshStateImpl();
            }
        }, composer, 3072, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return pullToRefreshStateImpl;
    }

    public static final PullToRefreshState PullToRefreshState() {
        return new PullToRefreshStateImpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CircularArrowProgressIndicator-RPmYEkk, reason: not valid java name */
    public static final void m3117CircularArrowProgressIndicatorRPmYEkk(final Function0<Float> function0, final long j, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-569718810);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularArrowProgressIndicator)P(1,0:c#ui.graphics.Color)562@20583L61,564@20745L76,565@20843L74,567@20982L98,571@21118L443,566@20922L639:PullToRefresh.kt#djiw08");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-569718810, i2, -1, "androidx.compose.material3.pulltorefresh.CircularArrowProgressIndicator (PullToRefresh.kt:561)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1136642763, "CC(remember):PullToRefresh.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            Object obj = rememberedValue;
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                Path Path = AndroidPath_androidKt.Path();
                Path.mo4259setFillTypeoQ8Xj4U(PathFillType.INSTANCE.m4666getEvenOddRgk1Os());
                startRestartGroup.updateRememberedValue(Path);
                obj = Path;
            }
            final Path path = (Path) obj;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1136647962, "CC(remember):PullToRefresh.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$targetAlpha$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(function0.invoke().floatValue() < 1.0f ? 0.3f : 1.0f);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(CircularArrowProgressIndicator_RPmYEkk$lambda$4((State) rememberedValue2), AlphaTween, 0.0f, null, null, startRestartGroup, 48, 28);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1136655568, "CC(remember):PullToRefresh.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = i3 == 4;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(function0.invoke().floatValue(), RangesKt.rangeTo(0.0f, 1.0f), 0));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier m1096size3ABfNKs = SizeKt.m1096size3ABfNKs(SemanticsModifierKt.semantics(companion, true, (Function1) rememberedValue3), SpinnerSize);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1136660265, "CC(remember):PullToRefresh.kt#9igjgp");
            boolean changed = (i3 == 4) | startRestartGroup.changed(animateFloatAsState) | ((i2 & 112) == 32) | startRestartGroup.changedInstance(path);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ArrowValues ArrowValues;
                        float f;
                        float f2;
                        float f3;
                        float f4;
                        ArrowValues = PullToRefreshKt.ArrowValues(function0.invoke().floatValue());
                        float floatValue = animateFloatAsState.getValue().floatValue();
                        float rotation = ArrowValues.getRotation();
                        long j2 = j;
                        Path path2 = path;
                        long mo4934getCenterF1C5BW0 = drawScope.mo4934getCenterF1C5BW0();
                        DrawContext drawContext = drawScope.getDrawContext();
                        long mo4856getSizeNHjbRc = drawContext.mo4856getSizeNHjbRc();
                        drawContext.getCanvas().save();
                        try {
                            drawContext.getTransform().mo4862rotateUv8p0NA(rotation, mo4934getCenterF1C5BW0);
                            f = PullToRefreshKt.ArcRadius;
                            float f5 = drawScope.mo700toPx0680j_4(f);
                            f2 = PullToRefreshKt.StrokeWidth;
                            Rect m4164Rect3MmeM6k = RectKt.m4164Rect3MmeM6k(androidx.compose.ui.geometry.SizeKt.m4204getCenteruvyYCjk(drawScope.mo4935getSizeNHjbRc()), f5 + (drawScope.mo700toPx0680j_4(f2) / 2.0f));
                            f3 = PullToRefreshKt.StrokeWidth;
                            PullToRefreshKt.m3122drawCircularIndicatorKzyDr3Q(drawScope, j2, floatValue, ArrowValues, m4164Rect3MmeM6k, f3);
                            f4 = PullToRefreshKt.StrokeWidth;
                            PullToRefreshKt.m3121drawArrowuDrxG_w(drawScope, path2, m4164Rect3MmeM6k, j2, floatValue, ArrowValues, f4);
                        } finally {
                            drawContext.getCanvas().restore();
                            drawContext.mo4857setSizeuvyYCjk(mo4856getSizeNHjbRc);
                        }
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CanvasKt.Canvas(m1096size3ABfNKs, (Function1) rememberedValue4, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    PullToRefreshKt.m3117CircularArrowProgressIndicatorRPmYEkk(function0, j, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawCircularIndicator-KzyDr3Q, reason: not valid java name */
    public static final void m3122drawCircularIndicatorKzyDr3Q(DrawScope drawScope, long j, float f, ArrowValues arrowValues, Rect rect, float f2) {
        DrawScope.m4914drawArcyD3GUKo$default(drawScope, j, arrowValues.getStartAngle(), arrowValues.getEndAngle() - arrowValues.getStartAngle(), false, rect.m4160getTopLeftF1C5BW0(), rect.m4158getSizeNHjbRc(), f, new Stroke(drawScope.mo700toPx0680j_4(f2), 0.0f, StrokeCap.INSTANCE.m4737getButtKaPHkGw(), 0, null, 26, null), null, 0, ViewUtils.EDGE_TO_EDGE_FLAGS, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrowValues ArrowValues(float f) {
        float max = (Math.max(Math.min(1.0f, f) - 0.4f, 0.0f) * 5.0f) / 3.0f;
        float coerceIn = RangesKt.coerceIn(Math.abs(f) - 1.0f, 0.0f, 2.0f);
        float pow = (((0.4f * max) - 0.25f) + (coerceIn - (((float) Math.pow(coerceIn, 2.0d)) / 4.0f))) * 0.5f;
        return new ArrowValues(pow, pow * 360.0f, ((0.8f * max) + pow) * 360.0f, Math.min(1.0f, max));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawArrow-uDrxG_w, reason: not valid java name */
    public static final void m3121drawArrowuDrxG_w(DrawScope drawScope, Path path, Rect rect, long j, float f, ArrowValues arrowValues, float f2) {
        path.reset();
        path.moveTo(0.0f, 0.0f);
        float f3 = ArrowWidth;
        path.lineTo((drawScope.mo700toPx0680j_4(f3) * arrowValues.getScale()) / 2.0f, drawScope.mo700toPx0680j_4(ArrowHeight) * arrowValues.getScale());
        path.lineTo(drawScope.mo700toPx0680j_4(f3) * arrowValues.getScale(), 0.0f);
        float min = Math.min(rect.getWidth(), rect.getHeight()) / 2.0f;
        path.mo4261translatek4lQ0M(OffsetKt.Offset((min + Offset.m4125getXimpl(rect.m4155getCenterF1C5BW0())) - ((drawScope.mo700toPx0680j_4(f3) * arrowValues.getScale()) / 2.0f), Offset.m4126getYimpl(rect.m4155getCenterF1C5BW0()) - drawScope.mo700toPx0680j_4(f2)));
        float endAngle = arrowValues.getEndAngle() - drawScope.mo700toPx0680j_4(f2);
        long mo4934getCenterF1C5BW0 = drawScope.mo4934getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long mo4856getSizeNHjbRc = drawContext.mo4856getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo4862rotateUv8p0NA(endAngle, mo4934getCenterF1C5BW0);
            DrawScope.m4925drawPathLG529CI$default(drawScope, path, j, f, new Stroke(drawScope.mo700toPx0680j_4(f2), 0.0f, 0, 0, null, 30, null), null, 0, 48, null);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo4857setSizeuvyYCjk(mo4856getSizeNHjbRc);
        }
    }

    public static final float getSpinnerSize() {
        return SpinnerSize;
    }

    public static final float getSpinnerContainerSize() {
        return SpinnerContainerSize;
    }

    private static final float CircularArrowProgressIndicator_RPmYEkk$lambda$4(State<Float> state) {
        return state.getValue().floatValue();
    }
}
