package androidx.compose.material3;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tab.kt */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0082\u0001\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u008a\u0001\u0010$\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001az\u0010$\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00120(¢\u0006\u0002\b\u0018¢\u0006\u0002\b*H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a7\u0010-\u001a\u00020\u00122\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u00182\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\b\u0018H\u0003¢\u0006\u0002\u0010.\u001a=\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u00142\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u0018H\u0003ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aD\u00104\u001a\u00020\u0012*\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020\rH\u0002\u001a\u001c\u0010?\u001a\u00020\u0012*\u0002052\u0006\u0010@\u001a\u0002092\u0006\u0010<\u001a\u00020\rH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0010\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006A²\u0006\n\u0010B\u001a\u00020\u001eX\u008a\u0084\u0002"}, d2 = {"DoubleLineTextBaselineWithIcon", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalTextPadding", "getHorizontalTextPadding", "()F", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "LargeTabHeight", "SingleLineTextBaselineWithIcon", "SmallTabHeight", "TabFadeInAnimationDelay", "", "TabFadeInAnimationDuration", "TabFadeOutAnimationDuration", "TextDistanceFromLeadingIcon", "LeadingIconTab", "", "selected", "", "onClick", "Lkotlin/Function0;", "text", "Landroidx/compose/runtime/Composable;", "icon", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "LeadingIconTab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "Tab", "Tab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-bogVsAg", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextAndIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "tabWidth", "tabHeight", "firstBaseline", "lastBaseline", "placeTextOrIcon", "textOrIconPlaceable", "material3_release", TypedValues.Custom.S_COLOR}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class TabKt {
    private static final int TabFadeInAnimationDelay = 100;
    private static final int TabFadeInAnimationDuration = 150;
    private static final int TabFadeOutAnimationDuration = 100;
    private static final float SmallTabHeight = PrimaryNavigationTabTokens.INSTANCE.m3586getContainerHeightD9Ej5fM();
    private static final float LargeTabHeight = Dp.m6989constructorimpl(72.0f);
    private static final float HorizontalTextPadding = Dp.m6989constructorimpl(16.0f);
    private static final float SingleLineTextBaselineWithIcon = Dp.m6989constructorimpl(14.0f);
    private static final float DoubleLineTextBaselineWithIcon = Dp.m6989constructorimpl(6.0f);
    private static final long IconDistanceFromBaseline = TextUnitKt.getSp(20);
    private static final float TextDistanceFromLeadingIcon = Dp.m6989constructorimpl(8.0f);

    /* JADX WARN: Removed duplicated region for block: B:103:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0102  */
    /* renamed from: Tab-wqdebIU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2684TabwqdebIU(final boolean r27, final kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.ui.Modifier r29, boolean r30, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, long r33, long r35, androidx.compose.foundation.interaction.MutableInteractionSource r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instructions count: 603
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabKt.m2684TabwqdebIU(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, long, long, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00a4  */
    /* renamed from: LeadingIconTab-wqdebIU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2682LeadingIconTabwqdebIU(final boolean r20, final kotlin.jvm.functions.Function0<kotlin.Unit> r21, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.ui.Modifier r24, boolean r25, long r26, long r28, androidx.compose.foundation.interaction.MutableInteractionSource r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 547
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabKt.m2682LeadingIconTabwqdebIU(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, long, long, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00b6  */
    /* renamed from: Tab-bogVsAg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2683TabbogVsAg(final boolean r23, final kotlin.jvm.functions.Function0<kotlin.Unit> r24, androidx.compose.ui.Modifier r25, boolean r26, long r27, long r29, androidx.compose.foundation.interaction.MutableInteractionSource r31, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 519
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabKt.m2683TabbogVsAg(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, long, long, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TabTransition-Klgx-Pg, reason: not valid java name */
    public static final void m2685TabTransitionKlgxPg(final long j, final long j2, boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final boolean z2;
        Composer startRestartGroup = composer.startRestartGroup(735731848);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)280@11898L26,282@11961L548,297@12514L77:Tab.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            z2 = z;
            i2 |= startRestartGroup.changed(z2) ? 256 : 128;
        } else {
            z2 = z;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i2 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(735731848, i2, -1, "androidx.compose.material3.TabTransition (Tab.kt:279)");
            }
            int i3 = i2 >> 6;
            Transition updateTransition = TransitionKt.updateTransition(Boolean.valueOf(z2), (String) null, startRestartGroup, i3 & 14, 2);
            TabKt$TabTransition$color$2 tabKt$TabTransition$color$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.TabKt$TabTransition$color$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<Boolean> segment, Composer composer2, int i4) {
                    TweenSpec tween$default;
                    composer2.startReplaceGroup(-899623535);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-899623535, i4, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:284)");
                    }
                    if (segment.isTransitioningTo(false, true)) {
                        tween$default = AnimationSpecKt.tween(150, 100, EasingKt.getLinearEasing());
                    } else {
                        tween$default = AnimationSpecKt.tween$default(100, 0, EasingKt.getLinearEasing(), 2, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return tween$default;
                }
            };
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
            boolean booleanValue = ((Boolean) updateTransition.getTargetState()).booleanValue();
            startRestartGroup.startReplaceGroup(-1997025499);
            ComposerKt.sourceInformation(startRestartGroup, "C:Tab.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997025499, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:295)");
            }
            long j3 = booleanValue ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceGroup();
            ColorSpace m4388getColorSpaceimpl = Color.m4388getColorSpaceimpl(j3);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1918408083, "CC(remember):Transition.kt#9igjgp");
            boolean changed = startRestartGroup.changed(m4388getColorSpaceimpl);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(m4388getColorSpaceimpl);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            TwoWayConverter twoWayConverter = (TwoWayConverter) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
            boolean booleanValue2 = ((Boolean) updateTransition.getCurrentState()).booleanValue();
            startRestartGroup.startReplaceGroup(-1997025499);
            ComposerKt.sourceInformation(startRestartGroup, "C:Tab.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997025499, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:295)");
            }
            long j4 = booleanValue2 ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceGroup();
            Color m4374boximpl = Color.m4374boximpl(j4);
            boolean booleanValue3 = ((Boolean) updateTransition.getTargetState()).booleanValue();
            startRestartGroup.startReplaceGroup(-1997025499);
            ComposerKt.sourceInformation(startRestartGroup, "C:Tab.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1997025499, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:295)");
            }
            long j5 = booleanValue3 ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            startRestartGroup.endReplaceGroup();
            State createTransitionAnimation = TransitionKt.createTransitionAnimation(updateTransition, m4374boximpl, Color.m4374boximpl(j5), tabKt$TabTransition$color$2.invoke((TabKt$TabTransition$color$2) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter, "ColorAnimation", startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4374boximpl(TabTransition_Klgx_Pg$lambda$2(createTransitionAnimation))), function2, startRestartGroup, (i3 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$TabTransition$1
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

                public final void invoke(Composer composer2, int i4) {
                    TabKt.m2685TabTransitionKlgxPg(j, j2, z2, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TabBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(514131524);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabBaselineLayout)P(1)314@13233L2042,307@12989L2286:Tab.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(514131524, i2, -1, "androidx.compose.material3.TabBaselineLayout (Tab.kt:306)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 370960155, "CC(remember):Tab.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = (i3 == 4) | ((i2 & 112) == 32);
            MeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.TabKt$TabBaselineLayout$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo356measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        Placeable placeable;
                        Placeable placeable2;
                        long j2;
                        if (function2 != null) {
                            int size = list.size();
                            for (int i4 = 0; i4 < size; i4++) {
                                Measurable measurable = list.get(i4);
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "text")) {
                                    placeable = measurable.mo5732measureBRTryo0(Constraints.m6932copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        placeable = null;
                        if (function22 != null) {
                            int size2 = list.size();
                            for (int i5 = 0; i5 < size2; i5++) {
                                Measurable measurable2 = list.get(i5);
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "icon")) {
                                    placeable2 = measurable2.mo5732measureBRTryo0(j);
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        placeable2 = null;
                        final int max = Math.max(placeable != null ? placeable.getWidth() : 0, placeable2 != null ? placeable2.getWidth() : 0);
                        int i6 = measureScope.mo694roundToPx0680j_4((placeable == null || placeable2 == null) ? TabKt.SmallTabHeight : TabKt.LargeTabHeight);
                        int height = placeable2 != null ? placeable2.getHeight() : 0;
                        int height2 = placeable != null ? placeable.getHeight() : 0;
                        j2 = TabKt.IconDistanceFromBaseline;
                        final int max2 = Math.max(i6, height + height2 + measureScope.mo693roundToPxR2X_6o(j2));
                        final Integer valueOf = placeable != null ? Integer.valueOf(placeable.get(AlignmentLineKt.getFirstBaseline())) : null;
                        final Integer valueOf2 = placeable != null ? Integer.valueOf(placeable.get(AlignmentLineKt.getLastBaseline())) : null;
                        final Placeable placeable3 = placeable;
                        final Placeable placeable4 = placeable2;
                        return MeasureScope.layout$default(measureScope, max, max2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabKt$TabBaselineLayout$2$1.1
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
                                Placeable placeable5;
                                Placeable placeable6 = Placeable.this;
                                if (placeable6 == null || (placeable5 = placeable4) == null) {
                                    if (placeable6 != null) {
                                        TabKt.placeTextOrIcon(placementScope, placeable6, max2);
                                        return;
                                    }
                                    Placeable placeable7 = placeable4;
                                    if (placeable7 != null) {
                                        TabKt.placeTextOrIcon(placementScope, placeable7, max2);
                                        return;
                                    }
                                    return;
                                }
                                MeasureScope measureScope2 = measureScope;
                                int i7 = max;
                                int i8 = max2;
                                Integer num = valueOf;
                                Intrinsics.checkNotNull(num);
                                int intValue = num.intValue();
                                Integer num2 = valueOf2;
                                Intrinsics.checkNotNull(num2);
                                TabKt.placeTextAndIcon(placementScope, measureScope2, placeable6, placeable5, i7, i8, intValue, num2.intValue());
                            }
                        }, 4, null);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1248753480, "C:Tab.kt#uh7d8r");
            startRestartGroup.startReplaceGroup(871566271);
            ComposerKt.sourceInformation(startRestartGroup, "309@13038L85");
            if (function2 != null) {
                Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "text"), HorizontalTextPadding, 0.0f, 2, null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m1051paddingVpY3zN4$default);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 719667646, "C309@13115L6:Tab.kt#uh7d8r");
                function2.invoke(startRestartGroup, Integer.valueOf(i3));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(871570579);
            ComposerKt.sourceInformation(startRestartGroup, "312@13174L41");
            if (function22 != null) {
                Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "icon");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 719758910, "C312@13207L6:Tab.kt#uh7d8r");
                function22.invoke(startRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$TabBaselineLayout$3
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

                public final void invoke(Composer composer2, int i4) {
                    TabKt.TabBaselineLayout(function2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextOrIcon(Placeable.PlacementScope placementScope, Placeable placeable, int i) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, (i - placeable.getHeight()) / 2, 0.0f, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextAndIcon(Placeable.PlacementScope placementScope, Density density, Placeable placeable, Placeable placeable2, int i, int i2, int i3, int i4) {
        float f;
        if (i3 == i4) {
            f = SingleLineTextBaselineWithIcon;
        } else {
            f = DoubleLineTextBaselineWithIcon;
        }
        int mo694roundToPx0680j_4 = density.mo694roundToPx0680j_4(f) + density.mo694roundToPx0680j_4(PrimaryNavigationTabTokens.INSTANCE.m3584getActiveIndicatorHeightD9Ej5fM());
        int height = (placeable2.getHeight() + density.mo693roundToPxR2X_6o(IconDistanceFromBaseline)) - i3;
        int i5 = (i2 - i4) - mo694roundToPx0680j_4;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (i - placeable.getWidth()) / 2, i5, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, (i - placeable2.getWidth()) / 2, i5 - height, 0.0f, 4, null);
    }

    public static final float getHorizontalTextPadding() {
        return HorizontalTextPadding;
    }

    private static final long TabTransition_Klgx_Pg$lambda$2(State<Color> state) {
        return state.getValue().m4394unboximpl();
    }
}
