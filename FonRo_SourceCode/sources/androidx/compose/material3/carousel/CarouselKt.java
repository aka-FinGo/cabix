package androidx.compose.material3.carousel;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: Carousel.kt */
@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a»\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000526\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\f\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u001621\u0010\u0017\u001a-\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0091\u0001\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\f\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u00142\b\b\u0002\u0010\u000e\u001a\u00020\u000f21\u0010\u0017\u001a-\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a}\u0010$\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00142\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\f\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000e\u001a\u00020\u000f21\u0010\u0017\u001a-\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a\u0018\u0010(\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*H\u0000\u001a\u0018\u0010+\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*H\u0001\u001a \u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\bH\u0002\u001a\u0019\u00101\u001a\u00020\b*\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u00102\u001a\u0019\u00103\u001a\u00020\b*\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u00102\u001a:\u00104\u001a\u00020\u0013*\u00020\u00132\u0006\u00105\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006;"}, d2 = {"Carousel", "", "state", "Landroidx/compose/material3/carousel/CarouselState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "keylineList", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "availableSpace", "itemSpacing", "Landroidx/compose/material3/carousel/KeylineList;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "maxNonFocalVisibleItemCount", "", "modifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/Dp;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/material3/carousel/CarouselItemScope;", "itemIndex", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Carousel-V-95POc", "(Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ILandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "HorizontalMultiBrowseCarousel", "preferredItemWidth", "minSmallItemWidth", "maxSmallItemWidth", "HorizontalMultiBrowseCarousel-zCIJ0Nk", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;FFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "HorizontalUncontainedCarousel", "itemWidth", "HorizontalUncontainedCarousel-9QcgTRs", "(Landroidx/compose/material3/carousel/CarouselState;FLandroidx/compose/ui/Modifier;FLandroidx/compose/foundation/gestures/TargetedFlingBehavior;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "calculateCurrentScrollOffset", "strategy", "Landroidx/compose/material3/carousel/Strategy;", "calculateMaxScrollOffset", "getProgress", "before", "Landroidx/compose/material3/carousel/Keyline;", "after", "unadjustedOffset", "calculateAfterContentPadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/runtime/Composer;I)F", "calculateBeforeContentPadding", "carouselItem", FirebaseAnalytics.Param.INDEX, "Lkotlin/Function0;", "carouselItemInfo", "Landroidx/compose/material3/carousel/CarouselItemInfoImpl;", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class CarouselKt {
    /* JADX WARN: Removed duplicated region for block: B:106:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00ff  */
    /* renamed from: HorizontalMultiBrowseCarousel-zCIJ0Nk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2989HorizontalMultiBrowseCarouselzCIJ0Nk(final androidx.compose.material3.carousel.CarouselState r25, final float r26, androidx.compose.ui.Modifier r27, float r28, androidx.compose.foundation.gestures.TargetedFlingBehavior r29, float r30, float r31, androidx.compose.foundation.layout.PaddingValues r32, final kotlin.jvm.functions.Function4<? super androidx.compose.material3.carousel.CarouselItemScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 653
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.CarouselKt.m2989HorizontalMultiBrowseCarouselzCIJ0Nk(androidx.compose.material3.carousel.CarouselState, float, androidx.compose.ui.Modifier, float, androidx.compose.foundation.gestures.TargetedFlingBehavior, float, float, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0067  */
    /* renamed from: HorizontalUncontainedCarousel-9QcgTRs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2990HorizontalUncontainedCarousel9QcgTRs(final androidx.compose.material3.carousel.CarouselState r21, final float r22, androidx.compose.ui.Modifier r23, float r24, androidx.compose.foundation.gestures.TargetedFlingBehavior r25, androidx.compose.foundation.layout.PaddingValues r26, final kotlin.jvm.functions.Function4<? super androidx.compose.material3.carousel.CarouselItemScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.CarouselKt.m2990HorizontalUncontainedCarousel9QcgTRs(androidx.compose.material3.carousel.CarouselState, float, androidx.compose.ui.Modifier, float, androidx.compose.foundation.gestures.TargetedFlingBehavior, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00b7  */
    /* renamed from: Carousel-V-95POc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2988CarouselV95POc(androidx.compose.material3.carousel.CarouselState r32, final androidx.compose.foundation.gestures.Orientation r33, final kotlin.jvm.functions.Function2<? super java.lang.Float, ? super java.lang.Float, androidx.compose.material3.carousel.KeylineList> r34, final androidx.compose.foundation.layout.PaddingValues r35, final int r36, androidx.compose.ui.Modifier r37, float r38, androidx.compose.foundation.gestures.TargetedFlingBehavior r39, final kotlin.jvm.functions.Function4<? super androidx.compose.material3.carousel.CarouselItemScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 764
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.CarouselKt.m2988CarouselV95POc(androidx.compose.material3.carousel.CarouselState, androidx.compose.foundation.gestures.Orientation, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, int, androidx.compose.ui.Modifier, float, androidx.compose.foundation.gestures.TargetedFlingBehavior, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final float calculateBeforeContentPadding(PaddingValues paddingValues, Orientation orientation, Composer composer, int i) {
        float calculateStartPadding;
        ComposerKt.sourceInformationMarkerStart(composer, 1896839347, "C(calculateBeforeContentPadding)*349@15698L7:Carousel.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1896839347, i, -1, "androidx.compose.material3.carousel.calculateBeforeContentPadding (Carousel.kt:341)");
        }
        composer.startReplaceGroup(295830617);
        ComposerKt.sourceInformation(composer, "346@15649L7");
        if (orientation == Orientation.Vertical) {
            calculateStartPadding = paddingValues.getTop();
        } else {
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer);
            calculateStartPadding = PaddingKt.calculateStartPadding(paddingValues, (LayoutDirection) consume);
        }
        composer.endReplaceGroup();
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float mo700toPx0680j_4 = ((Density) consume2).mo700toPx0680j_4(calculateStartPadding);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mo700toPx0680j_4;
    }

    private static final float calculateAfterContentPadding(PaddingValues paddingValues, Orientation orientation, Composer composer, int i) {
        float calculateEndPadding;
        ComposerKt.sourceInformationMarkerStart(composer, 1018496720, "C(calculateAfterContentPadding)*361@16056L7:Carousel.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1018496720, i, -1, "androidx.compose.material3.carousel.calculateAfterContentPadding (Carousel.kt:353)");
        }
        composer.startReplaceGroup(-587616383);
        ComposerKt.sourceInformation(composer, "358@16007L7");
        if (orientation == Orientation.Vertical) {
            calculateEndPadding = paddingValues.getBottom();
        } else {
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer);
            calculateEndPadding = PaddingKt.calculateEndPadding(paddingValues, (LayoutDirection) consume);
        }
        composer.endReplaceGroup();
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float mo700toPx0680j_4 = ((Density) consume2).mo700toPx0680j_4(calculateEndPadding);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mo700toPx0680j_4;
    }

    public static final Modifier carouselItem(Modifier modifier, final int i, final CarouselState carouselState, final Function0<Strategy> function0, final CarouselItemInfoImpl carouselItemInfoImpl, final Shape shape) {
        return LayoutModifierKt.layout(modifier, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.carousel.CarouselKt$carouselItem$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m2991invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m2991invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                long m6931copyZbe2FdA;
                final Strategy invoke = function0.invoke();
                if (!invoke.getIsValid()) {
                    return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.carousel.CarouselKt$carouselItem$1.1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope placementScope) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }
                    }, 4, null);
                }
                final boolean z = carouselState.getPagerState().getLayoutInfo().getOrientation() == Orientation.Vertical;
                final boolean z2 = measureScope.getLayoutDirection() == LayoutDirection.Rtl;
                float itemMainAxisSize = invoke.getItemMainAxisSize();
                if (z) {
                    m6931copyZbe2FdA = Constraints.m6931copyZbe2FdA(j, Constraints.m6944getMinWidthimpl(j), Constraints.m6942getMaxWidthimpl(j), MathKt.roundToInt(itemMainAxisSize), MathKt.roundToInt(itemMainAxisSize));
                } else {
                    m6931copyZbe2FdA = Constraints.m6931copyZbe2FdA(j, MathKt.roundToInt(itemMainAxisSize), MathKt.roundToInt(itemMainAxisSize), Constraints.m6943getMinHeightimpl(j), Constraints.m6941getMaxHeightimpl(j));
                }
                final Placeable mo5732measureBRTryo0 = measurable.mo5732measureBRTryo0(m6931copyZbe2FdA);
                int width = mo5732measureBRTryo0.getWidth();
                int height = mo5732measureBRTryo0.getHeight();
                final CarouselState carouselState2 = carouselState;
                final int i2 = i;
                final CarouselItemInfoImpl carouselItemInfoImpl2 = carouselItemInfoImpl;
                final Shape shape2 = shape;
                return MeasureScope.layout$default(measureScope, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.carousel.CarouselKt$carouselItem$1.2
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
                        Placeable placeable = Placeable.this;
                        final CarouselState carouselState3 = carouselState2;
                        final Strategy strategy = invoke;
                        final int i3 = i2;
                        final boolean z3 = z;
                        final CarouselItemInfoImpl carouselItemInfoImpl3 = carouselItemInfoImpl2;
                        final Shape shape3 = shape2;
                        final boolean z4 = z2;
                        Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, 0, 0, 0.0f, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.carousel.CarouselKt.carouselItem.1.2.1
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
                                float progress;
                                float calculateCurrentScrollOffset = CarouselKt.calculateCurrentScrollOffset(CarouselState.this, strategy);
                                float calculateMaxScrollOffset = CarouselKt.calculateMaxScrollOffset(CarouselState.this, strategy);
                                KeylineList keylineListForScrollOffset$material3_release$default = Strategy.getKeylineListForScrollOffset$material3_release$default(strategy, calculateCurrentScrollOffset, calculateMaxScrollOffset, false, 4, null);
                                KeylineList keylineListForScrollOffset$material3_release = strategy.getKeylineListForScrollOffset$material3_release(calculateCurrentScrollOffset, calculateMaxScrollOffset, true);
                                float itemMainAxisSize2 = ((i3 * (strategy.getItemMainAxisSize() + strategy.getItemSpacing())) + (strategy.getItemMainAxisSize() / 2.0f)) - calculateCurrentScrollOffset;
                                Keyline keylineBefore = keylineListForScrollOffset$material3_release$default.getKeylineBefore(itemMainAxisSize2);
                                Keyline keylineAfter = keylineListForScrollOffset$material3_release$default.getKeylineAfter(itemMainAxisSize2);
                                progress = CarouselKt.getProgress(keylineBefore, keylineAfter, itemMainAxisSize2);
                                Keyline lerp = KeylineListKt.lerp(keylineBefore, keylineAfter, progress);
                                boolean areEqual = Intrinsics.areEqual(keylineBefore, keylineAfter);
                                float m4191getHeightimpl = (z3 ? Size.m4191getHeightimpl(graphicsLayerScope.getSize()) : strategy.getItemMainAxisSize()) / 2.0f;
                                float itemMainAxisSize3 = (z3 ? strategy.getItemMainAxisSize() : Size.m4191getHeightimpl(graphicsLayerScope.getSize())) / 2.0f;
                                float m4194getWidthimpl = (z3 ? Size.m4194getWidthimpl(graphicsLayerScope.getSize()) : lerp.getSize()) / 2.0f;
                                float size = (z3 ? lerp.getSize() : Size.m4191getHeightimpl(graphicsLayerScope.getSize())) / 2.0f;
                                Rect rect = new Rect(m4191getHeightimpl - m4194getWidthimpl, itemMainAxisSize3 - size, m4191getHeightimpl + m4194getWidthimpl, itemMainAxisSize3 + size);
                                carouselItemInfoImpl3.setSizeState(lerp.getSize());
                                CarouselItemInfoImpl carouselItemInfoImpl4 = carouselItemInfoImpl3;
                                Iterator<Keyline> it = keylineListForScrollOffset$material3_release.iterator();
                                if (!it.hasNext()) {
                                    throw new NoSuchElementException();
                                }
                                Keyline next = it.next();
                                if (it.hasNext()) {
                                    float size2 = next.getSize();
                                    do {
                                        Keyline next2 = it.next();
                                        float size3 = next2.getSize();
                                        if (Float.compare(size2, size3) > 0) {
                                            next = next2;
                                            size2 = size3;
                                        }
                                    } while (it.hasNext());
                                }
                                carouselItemInfoImpl4.setMinSizeState(next.getSize());
                                carouselItemInfoImpl3.setMaxSizeState(keylineListForScrollOffset$material3_release.getFirstFocal().getSize());
                                carouselItemInfoImpl3.setMaskRectState(rect);
                                graphicsLayerScope.setClip(!Intrinsics.areEqual(rect, new Rect(0.0f, 0.0f, Size.m4194getWidthimpl(graphicsLayerScope.getSize()), Size.m4191getHeightimpl(graphicsLayerScope.getSize()))));
                                graphicsLayerScope.setShape(shape3);
                                float offset = lerp.getOffset() - itemMainAxisSize2;
                                if (areEqual) {
                                    offset += (itemMainAxisSize2 - lerp.getUnadjustedOffset()) / lerp.getSize();
                                }
                                if (z3) {
                                    graphicsLayerScope.setTranslationY(offset);
                                    return;
                                }
                                if (z4) {
                                    offset = -offset;
                                }
                                graphicsLayerScope.setTranslationX(offset);
                            }
                        }, 4, (Object) null);
                    }
                }, 4, null);
            }
        });
    }

    public static final float calculateCurrentScrollOffset(CarouselState carouselState, Strategy strategy) {
        float itemMainAxisSize = strategy.getItemMainAxisSize() + strategy.getItemSpacing();
        return ((carouselState.getPagerState().getCurrentPage() * itemMainAxisSize) + (carouselState.getPagerState().getCurrentPageOffsetFraction() * itemMainAxisSize)) - KeylineSnapPositionKt.getSnapPositionOffset(strategy, carouselState.getPagerState().getCurrentPage(), carouselState.getPagerState().getPageCount());
    }

    public static final float calculateMaxScrollOffset(CarouselState carouselState, Strategy strategy) {
        float pageCount = carouselState.getPagerState().getPageCount();
        return RangesKt.coerceAtLeast(((strategy.getItemMainAxisSize() * pageCount) + (strategy.getItemSpacing() * (pageCount - 1.0f))) - strategy.getAvailableSpace(), 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float getProgress(Keyline keyline, Keyline keyline2, float f) {
        if (Intrinsics.areEqual(keyline, keyline2)) {
            return 1.0f;
        }
        return (f - keyline.getUnadjustedOffset()) / (keyline2.getUnadjustedOffset() - keyline.getUnadjustedOffset());
    }
}
