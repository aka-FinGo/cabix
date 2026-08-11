package androidx.compose.material3;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.tokens.ProgressIndicatorTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* compiled from: ProgressIndicator.kt */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\u001aR\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\\\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a0\u0010%\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001aD\u0010%\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a8\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001aL\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010;\u001aH\u0010<\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001am\u0010<\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020\u00052\u0019\b\u0002\u0010?\u001a\u0013\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020&0@¢\u0006\u0002\bBH\u0007ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a0\u0010<\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+H\u0007ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a:\u0010<\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\bG\u0010H\u001aD\u0010<\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\bI\u0010J\u001a8\u0010<\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+H\u0007ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001aB\u0010<\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b=\u0010M\u001a6\u0010N\u001a\u00020&*\u00020A2\u0006\u0010O\u001a\u00020\u00012\u0006\u0010P\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010Q\u001a\u00020RH\u0002ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a&\u0010U\u001a\u00020&*\u00020A2\u0006\u0010*\u001a\u00020+2\u0006\u0010Q\u001a\u00020RH\u0002ø\u0001\u0000¢\u0006\u0004\bV\u0010W\u001a6\u0010X\u001a\u00020&*\u00020A2\u0006\u0010O\u001a\u00020\u00012\u0006\u0010P\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010Q\u001a\u00020RH\u0002ø\u0001\u0000¢\u0006\u0004\bY\u0010T\u001a>\u0010Z\u001a\u00020&*\u00020A2\u0006\u0010O\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010Q\u001a\u00020RH\u0002ø\u0001\u0000¢\u0006\u0004\b[\u0010\\\u001a>\u0010]\u001a\u00020&*\u00020A2\u0006\u0010^\u001a\u00020\u00012\u0006\u0010_\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00012\u0006\u0010.\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\b`\u0010a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0016\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0017\u0010\u0007\"\u0016\u0010\u0018\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0019\u0010\u0007\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010#\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u000e\u0010$\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006b"}, d2 = {"BaseRotationAngle", "", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "CircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "getCircularIndicatorDiameter", "()F", "F", "FirstLineHeadDelay", "", "FirstLineHeadDuration", "FirstLineHeadEasing", "FirstLineTailDelay", "FirstLineTailDuration", "FirstLineTailEasing", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "IncreaseSemanticsBounds", "Landroidx/compose/ui/Modifier;", "JumpRotationAngle", "LinearAnimationDuration", "LinearIndicatorHeight", "getLinearIndicatorHeight", "LinearIndicatorWidth", "getLinearIndicatorWidth", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "SecondLineHeadDelay", "SecondLineHeadDuration", "SecondLineHeadEasing", "SecondLineTailDelay", "SecondLineTailDuration", "SecondLineTailEasing", "SemanticsBoundsPadding", "StartAngleOffset", "CircularProgressIndicator", "", "progress", "Lkotlin/Function0;", "modifier", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "trackColor", "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "CircularProgressIndicator-DUhRLBM", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "gapSize", "CircularProgressIndicator-IyT6zlY", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JFJIFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-LxG7B9w", "(Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "LinearProgressIndicator-_5eSR-E", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "drawStopIndicator", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "LinearProgressIndicator-GJbTh5U", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJIFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-2cYBFYY", "(Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-rIrjwxo", "(Landroidx/compose/ui/Modifier;JJIFLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCircularIndicatorTrack", "drawCircularIndicatorTrack-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawLinearIndicator", "startFraction", "endFraction", "drawLinearIndicator-qYKTg0g", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJFI)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    private static final CubicBezierEasing CircularEasing;
    private static final float CircularIndicatorDiameter;
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;
    private static final CubicBezierEasing FirstLineHeadEasing;
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;
    private static final CubicBezierEasing FirstLineTailEasing;
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final Modifier IncreaseSemanticsBounds;
    private static final float JumpRotationAngle = 290.0f;
    private static final int LinearAnimationDuration = 1800;
    private static final float LinearIndicatorHeight;
    private static final float LinearIndicatorWidth;
    private static final float RotationAngleOffset = 216.0f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;
    private static final CubicBezierEasing SecondLineHeadEasing;
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;
    private static final CubicBezierEasing SecondLineTailEasing;
    private static final float SemanticsBoundsPadding;
    private static final float StartAngleOffset = -90.0f;

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0060  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize` and `drawStopIndicator`, see `LegacyLinearProgressIndicatorSample` on how to restore the previous behavior", replaceWith = @kotlin.ReplaceWith(expression = "LinearProgressIndicator(progress, modifier, color, trackColor, strokeCap, gapSize, drawStopIndicator)", imports = {}))
    /* renamed from: LinearProgressIndicator-_5eSR-E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m2479LinearProgressIndicator_5eSRE(final kotlin.jvm.functions.Function0 r21, androidx.compose.ui.Modifier r22, long r23, long r25, int r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2479LinearProgressIndicator_5eSRE(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0270  */
    /* renamed from: LinearProgressIndicator-GJbTh5U, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2476LinearProgressIndicatorGJbTh5U(final kotlin.jvm.functions.Function0<java.lang.Float> r30, androidx.compose.ui.Modifier r31, long r32, long r34, int r36, float r37, kotlin.jvm.functions.Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 728
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2476LinearProgressIndicatorGJbTh5U(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, long, int, float, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bd  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize`, see `LegacyIndeterminateLinearProgressIndicatorSample` on how to restore the previous behavior", replaceWith = @kotlin.ReplaceWith(expression = "LinearProgressIndicator(modifier, color, trackColor, strokeCap, gapSize)", imports = {}))
    /* renamed from: LinearProgressIndicator-2cYBFYY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m2475LinearProgressIndicator2cYBFYY(androidx.compose.ui.Modifier r18, long r19, long r21, int r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2475LinearProgressIndicator2cYBFYY(androidx.compose.ui.Modifier, long, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00f7  */
    /* renamed from: LinearProgressIndicator-rIrjwxo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2481LinearProgressIndicatorrIrjwxo(androidx.compose.ui.Modifier r28, long r29, long r31, int r33, float r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instructions count: 764
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2481LinearProgressIndicatorrIrjwxo(androidx.compose.ui.Modifier, long, long, int, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x005d  */
    @kotlin.Deprecated(message = "Use the overload that takes `progress` as a lambda", replaceWith = @kotlin.ReplaceWith(expression = "LinearProgressIndicator(\nprogress = { progress },\nmodifier = modifier,\ncolor = color,\ntrackColor = trackColor,\nstrokeCap = strokeCap,\n)", imports = {}))
    /* renamed from: LinearProgressIndicator-_5eSR-E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2478LinearProgressIndicator_5eSRE(final float r21, androidx.compose.ui.Modifier r22, long r23, long r25, int r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2478LinearProgressIndicator_5eSRE(float, androidx.compose.ui.Modifier, long, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0060  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: LinearProgressIndicator-eaDK9VM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m2480LinearProgressIndicatoreaDK9VM(final float r18, androidx.compose.ui.Modifier r19, long r20, long r22, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2480LinearProgressIndicatoreaDK9VM(float, androidx.compose.ui.Modifier, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: LinearProgressIndicator-RIQooxk, reason: not valid java name */
    public static final /* synthetic */ void m2477LinearProgressIndicatorRIQooxk(Modifier modifier, long j, long j2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j3;
        long j4;
        long j5;
        Modifier modifier3;
        final Modifier modifier4;
        final long j6;
        final long j7;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(585576195);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinearProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.graphics.Color)418@16922L11,419@16985L16,421@17011L146:ProgressIndicator.kt#uh7d8r");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i5 = 32;
                    i3 |= i5;
                }
            } else {
                j3 = j;
            }
            i5 = 16;
            i3 |= i5;
        } else {
            j3 = j;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                j4 = j2;
                if (startRestartGroup.changed(j4)) {
                    i4 = 256;
                    i3 |= i4;
                }
            } else {
                j4 = j2;
            }
            i4 = 128;
            i3 |= i4;
        } else {
            j4 = j2;
        }
        if ((i3 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier4 = modifier2;
            j6 = j3;
            j7 = j4;
        } else {
            startRestartGroup.startDefaults();
            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i2 & 2) != 0) {
                    j3 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(startRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    j4 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(startRestartGroup, 6);
                    i3 &= -897;
                }
                j5 = j4;
                modifier3 = companion;
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                j5 = j4;
                modifier3 = modifier2;
            }
            long j8 = j3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(585576195, i3, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:421)");
            }
            m2481LinearProgressIndicatorrIrjwxo(modifier3, j8, j5, ProgressIndicatorDefaults.INSTANCE.m2467getLinearStrokeCapKaPHkGw(), 0.0f, startRestartGroup, (i3 & 14) | 3072 | (i3 & 112) | (i3 & 896), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            j6 = j8;
            j7 = j5;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$12
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

                public final void invoke(Composer composer2, int i7) {
                    ProgressIndicatorKt.m2477LinearProgressIndicatorRIQooxk(Modifier.this, j6, j7, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawLinearIndicator-qYKTg0g, reason: not valid java name */
    public static final void m2491drawLinearIndicatorqYKTg0g(DrawScope drawScope, float f, float f2, long j, float f3, int i) {
        float m4194getWidthimpl = Size.m4194getWidthimpl(drawScope.mo4935getSizeNHjbRc());
        float m4191getHeightimpl = Size.m4191getHeightimpl(drawScope.mo4935getSizeNHjbRc());
        float f4 = m4191getHeightimpl / 2.0f;
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Ltr;
        float f5 = (z ? f : 1.0f - f2) * m4194getWidthimpl;
        float f6 = (z ? f2 : 1.0f - f) * m4194getWidthimpl;
        if (StrokeCap.m4733equalsimpl0(i, StrokeCap.INSTANCE.m4737getButtKaPHkGw()) || m4191getHeightimpl > m4194getWidthimpl) {
            DrawScope.m4921drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(f5, f4), OffsetKt.Offset(f6, f4), f3, 0, null, 0.0f, null, 0, 496, null);
            return;
        }
        float f7 = f3 / 2.0f;
        ClosedFloatingPointRange<Float> rangeTo = RangesKt.rangeTo(f7, m4194getWidthimpl - f7);
        float floatValue = ((Number) RangesKt.coerceIn(Float.valueOf(f5), rangeTo)).floatValue();
        float floatValue2 = ((Number) RangesKt.coerceIn(Float.valueOf(f6), rangeTo)).floatValue();
        if (Math.abs(f2 - f) > 0.0f) {
            DrawScope.m4921drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(floatValue, f4), OffsetKt.Offset(floatValue2, f4), f3, i, null, 0.0f, null, 0, 480, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0060  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize`, see `LegacyCircularProgressIndicatorSample` on how to restore the previous behavior", replaceWith = @kotlin.ReplaceWith(expression = "CircularProgressIndicator(progress, modifier, color, strokeWidth, trackColor, strokeCap, gapSize)", imports = {}))
    /* renamed from: CircularProgressIndicator-DUhRLBM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m2470CircularProgressIndicatorDUhRLBM(final kotlin.jvm.functions.Function0 r22, androidx.compose.ui.Modifier r23, long r24, float r26, long r27, int r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2470CircularProgressIndicatorDUhRLBM(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, float, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0298  */
    /* renamed from: CircularProgressIndicator-IyT6zlY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2471CircularProgressIndicatorIyT6zlY(final kotlin.jvm.functions.Function0<java.lang.Float> r32, androidx.compose.ui.Modifier r33, long r34, float r36, long r37, int r39, float r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 698
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2471CircularProgressIndicatorIyT6zlY(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, float, long, int, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0083  */
    /* renamed from: CircularProgressIndicator-LxG7B9w, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2472CircularProgressIndicatorLxG7B9w(androidx.compose.ui.Modifier r32, long r33, float r35, long r36, int r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 815
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2472CircularProgressIndicatorLxG7B9w(androidx.compose.ui.Modifier, long, float, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0067  */
    @kotlin.Deprecated(message = "Use the overload that takes `progress` as a lambda", replaceWith = @kotlin.ReplaceWith(expression = "CircularProgressIndicator(\nprogress = { progress },\nmodifier = modifier,\ncolor = color,\nstrokeWidth = strokeWidth,\ntrackColor = trackColor,\nstrokeCap = strokeCap,\n)", imports = {}))
    /* renamed from: CircularProgressIndicator-DUhRLBM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2469CircularProgressIndicatorDUhRLBM(final float r22, androidx.compose.ui.Modifier r23, long r24, float r26, long r27, int r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2469CircularProgressIndicatorDUhRLBM(float, androidx.compose.ui.Modifier, long, float, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0061  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: CircularProgressIndicator-MBs18nI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m2473CircularProgressIndicatorMBs18nI(final float r20, androidx.compose.ui.Modifier r21, long r22, float r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2473CircularProgressIndicatorMBs18nI(float, androidx.compose.ui.Modifier, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009b  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: CircularProgressIndicator-aM-cp0Q, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m2474CircularProgressIndicatoraMcp0Q(androidx.compose.ui.Modifier r16, long r17, float r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m2474CircularProgressIndicatoraMcp0Q(androidx.compose.ui.Modifier, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawCircularIndicator-42QJj7c, reason: not valid java name */
    public static final void m2487drawCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        float width = stroke.getWidth() / 2.0f;
        float m4194getWidthimpl = Size.m4194getWidthimpl(drawScope.mo4935getSizeNHjbRc()) - (2.0f * width);
        DrawScope.m4914drawArcyD3GUKo$default(drawScope, j, f, f2, false, OffsetKt.Offset(width, width), SizeKt.Size(m4194getWidthimpl, m4194getWidthimpl), 0.0f, stroke, null, 0, 832, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawCircularIndicatorTrack-bw27NRU, reason: not valid java name */
    public static final void m2488drawCircularIndicatorTrackbw27NRU(DrawScope drawScope, long j, Stroke stroke) {
        m2487drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawDeterminateCircularIndicator-42QJj7c, reason: not valid java name */
    public static final void m2489drawDeterminateCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        m2487drawCircularIndicator42QJj7c(drawScope, f, f2, j, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawIndeterminateCircularIndicator-hrjfTZI, reason: not valid java name */
    public static final void m2490drawIndeterminateCircularIndicatorhrjfTZI(DrawScope drawScope, float f, float f2, float f3, long j, Stroke stroke) {
        m2487drawCircularIndicator42QJj7c(drawScope, f + (StrokeCap.m4733equalsimpl0(stroke.getCap(), StrokeCap.INSTANCE.m4737getButtKaPHkGw()) ? 0.0f : ((f2 / Dp.m6989constructorimpl(CircularIndicatorDiameter / 2.0f)) * 57.29578f) / 2.0f), Math.max(f3, 0.1f), j, stroke);
    }

    public static final float getLinearIndicatorWidth() {
        return LinearIndicatorWidth;
    }

    public static final float getLinearIndicatorHeight() {
        return LinearIndicatorHeight;
    }

    public static final float getCircularIndicatorDiameter() {
        return CircularIndicatorDiameter;
    }

    static {
        float m6989constructorimpl = Dp.m6989constructorimpl(10.0f);
        SemanticsBoundsPadding = m6989constructorimpl;
        IncreaseSemanticsBounds = PaddingKt.m1051paddingVpY3zN4$default(SemanticsModifierKt.semantics(LayoutModifierKt.layout(Modifier.INSTANCE, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.ProgressIndicatorKt$IncreaseSemanticsBounds$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m2492invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m2492invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                float f;
                f = ProgressIndicatorKt.SemanticsBoundsPadding;
                final int i = measureScope.mo694roundToPx0680j_4(f);
                int i2 = i * 2;
                final Placeable mo5732measureBRTryo0 = measurable.mo5732measureBRTryo0(ConstraintsKt.m6961offsetNN6EwU(j, 0, i2));
                return MeasureScope.layout$default(measureScope, mo5732measureBRTryo0.getWidth(), mo5732measureBRTryo0.getHeight() - i2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$IncreaseSemanticsBounds$1.1
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
                        Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, -i, 0.0f, 4, null);
                    }
                }, 4, null);
            }
        }), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$IncreaseSemanticsBounds$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }
        }), 0.0f, m6989constructorimpl, 1, null);
        LinearIndicatorWidth = Dp.m6989constructorimpl(240.0f);
        LinearIndicatorHeight = ProgressIndicatorTokens.INSTANCE.m3594getTrackThicknessD9Ej5fM();
        CircularIndicatorDiameter = Dp.m6989constructorimpl(ProgressIndicatorTokens.INSTANCE.m3591getSizeD9Ej5fM() - Dp.m6989constructorimpl(ProgressIndicatorTokens.INSTANCE.m3594getTrackThicknessD9Ej5fM() * 2.0f));
        FirstLineHeadEasing = new CubicBezierEasing(0.2f, 0.0f, 0.8f, 1.0f);
        FirstLineTailEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
        SecondLineHeadEasing = new CubicBezierEasing(0.0f, 0.0f, 0.65f, 1.0f);
        SecondLineTailEasing = new CubicBezierEasing(0.1f, 0.0f, 0.45f, 1.0f);
        CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);
    }
}
