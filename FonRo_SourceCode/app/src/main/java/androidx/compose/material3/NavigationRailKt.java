package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.tokens.NavigationRailTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: NavigationRail.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001az\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2 \b\u0002\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001e¢\u0006\u0002\b ¢\u0006\u0002\b!2\b\b\u0002\u0010\"\u001a\u00020#2\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00170\u001e¢\u0006\u0002\b ¢\u0006\u0002\b!H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u0081\u0001\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00170+2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010+¢\u0006\u0002\b 2\b\b\u0002\u0010/\u001a\u00020)2\b\b\u0002\u00100\u001a\u0002012\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0007¢\u0006\u0002\u00104\u001aq\u00105\u001a\u00020\u00172\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\b 2\u0013\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010+¢\u0006\u0002\b 2\u0006\u0010/\u001a\u00020)2\f\u00108\u001a\b\u0012\u0004\u0012\u0002090+H\u0003¢\u0006\u0002\u0010:\u001a8\u0010;\u001a\u00020<*\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010?2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001aP\u0010F\u001a\u00020<*\u00020=2\u0006\u0010G\u001a\u00020?2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010?2\u0006\u0010B\u001a\u00020C2\u0006\u0010/\u001a\u00020)2\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0000¢\u0006\u0004\bH\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\r\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u000e\u0010\u000f\"\u0016\u0010\u0010\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0011\u0010\u000f\"\u0016\u0010\u0012\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0013\u0010\u000f\"\u0016\u0010\u0014\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0015\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006J²\u0006\n\u0010K\u001a\u00020\u001bX\u008a\u0084\u0002²\u0006\n\u0010L\u001a\u00020\u001bX\u008a\u0084\u0002"}, d2 = {"IconLayoutIdTag", "", "IndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "IndicatorLayoutIdTag", "IndicatorRippleLayoutIdTag", "IndicatorVerticalPaddingNoLabel", "IndicatorVerticalPaddingWithLabel", "ItemAnimationDurationMillis", "", "LabelLayoutIdTag", "NavigationRailHeaderPadding", "NavigationRailItemHeight", "getNavigationRailItemHeight", "()F", "NavigationRailItemVerticalPadding", "getNavigationRailItemVerticalPadding", "NavigationRailItemWidth", "getNavigationRailItemWidth", "NavigationRailVerticalPadding", "getNavigationRailVerticalPadding", "NavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", FirebaseAnalytics.Param.CONTENT, "NavigationRail-qi6gXK8", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", NavigationRailKt.IconLayoutIdTag, "enabled", NavigationRailKt.LabelLayoutIdTag, "alwaysShowLabel", "colors", "Landroidx/compose/material3/NavigationRailItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationRailItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItemLayout", NavigationRailKt.IndicatorRippleLayoutIdTag, NavigationRailKt.IndicatorLayoutIdTag, "animationProgress", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "material3_release", "iconColor", "textColor"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class NavigationRailKt {
    private static final String IconLayoutIdTag = "icon";
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final int ItemAnimationDurationMillis = 150;
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationRailVerticalPadding = Dp.m6989constructorimpl(4.0f);
    private static final float NavigationRailHeaderPadding = Dp.m6989constructorimpl(8.0f);
    private static final float NavigationRailItemWidth = NavigationRailTokens.INSTANCE.m3458getContainerWidthD9Ej5fM();
    private static final float NavigationRailItemHeight = NavigationRailTokens.INSTANCE.m3461getNoLabelActiveIndicatorHeightD9Ej5fM();
    private static final float NavigationRailItemVerticalPadding = Dp.m6989constructorimpl(4.0f);
    private static final float IndicatorHorizontalPadding = Dp.m6989constructorimpl(Dp.m6989constructorimpl(NavigationRailTokens.INSTANCE.m3456getActiveIndicatorWidthD9Ej5fM() - NavigationRailTokens.INSTANCE.m3459getIconSizeD9Ej5fM()) / 2.0f);
    private static final float IndicatorVerticalPaddingWithLabel = Dp.m6989constructorimpl(Dp.m6989constructorimpl(NavigationRailTokens.INSTANCE.m3455getActiveIndicatorHeightD9Ej5fM() - NavigationRailTokens.INSTANCE.m3459getIconSizeD9Ej5fM()) / 2.0f);
    private static final float IndicatorVerticalPaddingNoLabel = Dp.m6989constructorimpl(Dp.m6989constructorimpl(NavigationRailTokens.INSTANCE.m3461getNoLabelActiveIndicatorHeightD9Ej5fM() - NavigationRailTokens.INSTANCE.m3459getIconSizeD9Ej5fM()) / 2.0f);

    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0099  */
    /* renamed from: NavigationRail-qi6gXK8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2440NavigationRailqi6gXK8(androidx.compose.ui.Modifier r23, long r24, long r26, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.foundation.layout.WindowInsets r29, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationRailKt.m2440NavigationRailqi6gXK8(androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0418  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void NavigationRailItem(final boolean r23, final kotlin.jvm.functions.Function0<kotlin.Unit> r24, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.ui.Modifier r26, boolean r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, boolean r29, androidx.compose.material3.NavigationRailItemColors r30, androidx.compose.foundation.interaction.MutableInteractionSource r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 1086
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationRailKt.NavigationRailItem(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.NavigationRailItemColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NavigationRailItemLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, final boolean z, final Function0<Float> function0, Composer composer, final int i) {
        int i2;
        final Function2<? super Composer, ? super Integer, Unit> function25 = function24;
        Composer startRestartGroup = composer.startRestartGroup(1498399348);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationRailItemLayout)P(4,3,2,5)530@23300L1924,515@22904L2320:NavigationRail.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function25) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1498399348, i2, -1, "androidx.compose.material3.NavigationRailItemLayout (NavigationRail.kt:514)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1881815062, "CC(remember):NavigationRail.kt#9igjgp");
            int i3 = 458752 & i2;
            int i4 = 57344 & i2;
            boolean z2 = (i3 == 131072) | ((i2 & 7168) == 2048) | (i4 == 16384);
            MeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItemLayout$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo356measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        float f;
                        Measurable measurable;
                        Placeable placeable;
                        MeasureResult m2444placeLabelAndIconzUg2_y0;
                        MeasureResult m2443placeIconX9ElhV4;
                        MeasureScope measureScope2 = measureScope;
                        float floatValue = function0.invoke().floatValue();
                        long m6932copyZbe2FdA$default = Constraints.m6932copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                        int size = list.size();
                        int i5 = 0;
                        while (i5 < size) {
                            Measurable measurable2 = list.get(i5);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "icon")) {
                                Placeable mo5732measureBRTryo0 = measurable2.mo5732measureBRTryo0(m6932copyZbe2FdA$default);
                                int width = mo5732measureBRTryo0.getWidth();
                                f = NavigationRailKt.IndicatorHorizontalPadding;
                                int i6 = width + measureScope2.mo694roundToPx0680j_4(Dp.m6989constructorimpl(f * 2.0f));
                                int roundToInt = MathKt.roundToInt(i6 * floatValue);
                                int height = mo5732measureBRTryo0.getHeight() + measureScope2.mo694roundToPx0680j_4(Dp.m6989constructorimpl((function25 == null ? NavigationRailKt.IndicatorVerticalPaddingNoLabel : NavigationRailKt.IndicatorVerticalPaddingWithLabel) * 2.0f));
                                int size2 = list.size();
                                int i7 = 0;
                                while (i7 < size2) {
                                    Measurable measurable3 = list.get(i7);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "indicatorRipple")) {
                                        Placeable mo5732measureBRTryo02 = measurable3.mo5732measureBRTryo0(Constraints.INSTANCE.m6952fixedJhjzzOo(i6, height));
                                        int size3 = list.size();
                                        int i8 = 0;
                                        while (true) {
                                            if (i8 >= size3) {
                                                measurable = null;
                                                break;
                                            }
                                            measurable = list.get(i8);
                                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "indicator")) {
                                                break;
                                            }
                                            i8++;
                                        }
                                        Measurable measurable4 = measurable;
                                        Placeable mo5732measureBRTryo03 = measurable4 != null ? measurable4.mo5732measureBRTryo0(Constraints.INSTANCE.m6952fixedJhjzzOo(roundToInt, height)) : null;
                                        if (function25 != null) {
                                            int size4 = list.size();
                                            for (int i9 = 0; i9 < size4; i9++) {
                                                Measurable measurable5 = list.get(i9);
                                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable5), "label")) {
                                                    placeable = measurable5.mo5732measureBRTryo0(m6932copyZbe2FdA$default);
                                                }
                                            }
                                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                        }
                                        placeable = null;
                                        if (function25 == null) {
                                            m2443placeIconX9ElhV4 = NavigationRailKt.m2443placeIconX9ElhV4(measureScope2, mo5732measureBRTryo0, mo5732measureBRTryo02, mo5732measureBRTryo03, j);
                                            return m2443placeIconX9ElhV4;
                                        }
                                        Intrinsics.checkNotNull(placeable);
                                        m2444placeLabelAndIconzUg2_y0 = NavigationRailKt.m2444placeLabelAndIconzUg2_y0(measureScope, placeable, mo5732measureBRTryo0, mo5732measureBRTryo02, mo5732measureBRTryo03, j, z, floatValue);
                                        return m2444placeLabelAndIconzUg2_y0;
                                    }
                                    i7++;
                                    measureScope2 = measureScope;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            i5++;
                            measureScope2 = measureScope;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.INSTANCE;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i5 = i2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3808constructorimpl = Updater.m3808constructorimpl(startRestartGroup);
            Updater.m3815setimpl(m3808constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2082816907, "C516@22921L17,517@22947L11,519@22968L50:NavigationRail.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf(i5 & 14));
            function22.invoke(startRestartGroup, Integer.valueOf((i5 >> 3) & 14));
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, IconLayoutIdTag);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3808constructorimpl2 = Updater.m3808constructorimpl(startRestartGroup);
            Updater.m3815setimpl(m3808constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 402566553, "C519@23010L6:NavigationRail.kt#uh7d8r");
            function23.invoke(startRestartGroup, Integer.valueOf((i5 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.startReplaceGroup(2145400941);
            ComposerKt.sourceInformation(startRestartGroup, "523@23132L96,522@23061L221");
            if (function24 != null) {
                Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, LabelLayoutIdTag);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2145404101, "CC(remember):NavigationRail.kt#9igjgp");
                boolean z3 = (i4 == 16384) | (i3 == 131072);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItemLayout$1$2$1
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
                            graphicsLayerScope.setAlpha(z ? 1.0f : function0.invoke().floatValue());
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(layoutId2, (Function1) rememberedValue2);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, graphicsLayer);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3808constructorimpl3 = Updater.m3808constructorimpl(startRestartGroup);
                Updater.m3815setimpl(m3808constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 402815576, "C527@23261L7:NavigationRail.kt#uh7d8r");
                function25 = function24;
                function25.invoke(startRestartGroup, Integer.valueOf((i5 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            } else {
                function25 = function24;
            }
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItemLayout$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    NavigationRailKt.NavigationRailItemLayout(function2, function22, function23, function25, z, function0, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m2443placeIconX9ElhV4(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, long j) {
        final int m6959constrainWidthK40F9xA = ConstraintsKt.m6959constrainWidthK40F9xA(j, Math.max(placeable.getWidth(), Math.max(placeable2.getWidth(), placeable3 != null ? placeable3.getWidth() : 0)));
        final int m6958constrainHeightK40F9xA = ConstraintsKt.m6958constrainHeightK40F9xA(j, measureScope.mo694roundToPx0680j_4(NavigationRailItemHeight));
        final int width = (m6959constrainWidthK40F9xA - placeable.getWidth()) / 2;
        final int height = (m6958constrainHeightK40F9xA - placeable.getHeight()) / 2;
        final int width2 = (m6959constrainWidthK40F9xA - placeable2.getWidth()) / 2;
        final int height2 = (m6958constrainHeightK40F9xA - placeable2.getHeight()) / 2;
        return MeasureScope.layout$default(measureScope, m6959constrainWidthK40F9xA, m6958constrainHeightK40F9xA, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$placeIcon$1
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
                Placeable.PlacementScope placementScope2;
                Placeable placeable4 = Placeable.this;
                if (placeable4 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, (m6959constrainWidthK40F9xA - placeable4.getWidth()) / 2, (m6958constrainHeightK40F9xA - placeable4.getHeight()) / 2, 0.0f, 4, null);
                    placementScope2 = placementScope;
                } else {
                    placementScope2 = placementScope;
                }
                Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, width, height, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(placementScope2, placeable2, width2, height2, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-zUg2_y0, reason: not valid java name */
    public static final MeasureResult m2444placeLabelAndIconzUg2_y0(final MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j, final boolean z, final float f) {
        float height = placeable2.getHeight();
        float f2 = IndicatorVerticalPaddingWithLabel;
        float f3 = height + measureScope.mo700toPx0680j_4(f2);
        float f4 = NavigationRailItemVerticalPadding;
        float f5 = f3 + measureScope.mo700toPx0680j_4(f4) + placeable.getHeight();
        final float coerceAtLeast = RangesKt.coerceAtLeast((Constraints.m6943getMinHeightimpl(j) - f5) / 2.0f, measureScope.mo700toPx0680j_4(f2));
        float f6 = f5 + (coerceAtLeast * 2.0f);
        final float height2 = ((z ? coerceAtLeast : (f6 - placeable2.getHeight()) / 2.0f) - coerceAtLeast) * (1.0f - f);
        final float height3 = placeable2.getHeight() + coerceAtLeast + measureScope.mo700toPx0680j_4(f2) + measureScope.mo700toPx0680j_4(f4);
        final int m6959constrainWidthK40F9xA = ConstraintsKt.m6959constrainWidthK40F9xA(j, Math.max(placeable2.getWidth(), Math.max(placeable.getWidth(), placeable4 != null ? placeable4.getWidth() : 0)));
        final int width = (m6959constrainWidthK40F9xA - placeable.getWidth()) / 2;
        final int width2 = (m6959constrainWidthK40F9xA - placeable2.getWidth()) / 2;
        final int width3 = (m6959constrainWidthK40F9xA - placeable3.getWidth()) / 2;
        final float f7 = coerceAtLeast - measureScope.mo700toPx0680j_4(f2);
        return MeasureScope.layout$default(measureScope, m6959constrainWidthK40F9xA, MathKt.roundToInt(f6), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationRailKt$placeLabelAndIcon$1
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
                Placeable.PlacementScope placementScope2;
                float f8;
                Placeable placeable5 = Placeable.this;
                if (placeable5 != null) {
                    int i = m6959constrainWidthK40F9xA;
                    float f9 = coerceAtLeast;
                    MeasureScope measureScope2 = measureScope;
                    float f10 = height2;
                    int width4 = (i - placeable5.getWidth()) / 2;
                    f8 = NavigationRailKt.IndicatorVerticalPaddingWithLabel;
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, width4, MathKt.roundToInt((f9 - measureScope2.mo700toPx0680j_4(f8)) + f10), 0.0f, 4, null);
                    placementScope2 = placementScope;
                } else {
                    placementScope2 = placementScope;
                }
                if (z || f != 0.0f) {
                    Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, width, MathKt.roundToInt(height3 + height2), 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default(placementScope2, placeable2, width2, MathKt.roundToInt(coerceAtLeast + height2), 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(placementScope2, placeable3, width3, MathKt.roundToInt(f7 + height2), 0.0f, 4, null);
            }
        }, 4, null);
    }

    public static final float getNavigationRailVerticalPadding() {
        return NavigationRailVerticalPadding;
    }

    public static final float getNavigationRailItemWidth() {
        return NavigationRailItemWidth;
    }

    public static final float getNavigationRailItemHeight() {
        return NavigationRailItemHeight;
    }

    public static final float getNavigationRailItemVerticalPadding() {
        return NavigationRailItemVerticalPadding;
    }
}
