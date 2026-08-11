package uz.FonRo.pos.ui.theme;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.RippleKt;
import androidx.compose.material3.Shapes;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Theme.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0004\u001a\u00020\u0005H\u0002\u001a2\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\nH\u0007b\u0002\b\nb\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u0002\u0010\u000b\u001a\u0019\u0010\u000f\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"oxColorScheme", "Landroidx/compose/material3/ColorScheme;", "OxShapes", "Landroidx/compose/material3/Shapes;", "oxTypography", "Landroidx/compose/material3/Typography;", "FonRoTheme", "", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/ComposableInferredTarget;", "scheme", "[0[0]]", "ink", "Landroidx/compose/ui/text/TextStyle;", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Color;", "ink-4WTKRHQ", "(Landroidx/compose/ui/text/TextStyle;J)Landroidx/compose/ui/text/TextStyle;", "app"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ThemeKt {
    private static final Shapes OxShapes = new Shapes(OxShape.INSTANCE.getBtnSm(), OxShape.INSTANCE.getTile(), OxShape.INSTANCE.getCardSoft(), OxShape.INSTANCE.getCard(), OxShape.INSTANCE.getHero());

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FonRoTheme$lambda$2(Function2 function2, int i, Composer composer, int i2) {
        FonRoTheme(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final ColorScheme oxColorScheme() {
        ColorScheme m2036darkColorSchemeCXl9yA$default = Ox.INSTANCE.isDark() ? ColorSchemeKt.m2036darkColorSchemeCXl9yA$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15, null) : ColorSchemeKt.m2040lightColorSchemeCXl9yA$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15, null);
        long m10220getPrimary0d7_KjU = Ox.INSTANCE.m10220getPrimary0d7_KjU();
        long m10217getPanel0d7_KjU = Ox.INSTANCE.m10217getPanel0d7_KjU();
        long m10222getPrimarySoft0d7_KjU = Ox.INSTANCE.m10222getPrimarySoft0d7_KjU();
        long m10221getPrimaryDark0d7_KjU = Ox.INSTANCE.m10221getPrimaryDark0d7_KjU();
        long m10192getCyan0d7_KjU = Ox.INSTANCE.m10192getCyan0d7_KjU();
        long m10217getPanel0d7_KjU2 = Ox.INSTANCE.m10217getPanel0d7_KjU();
        long m10185getBg0d7_KjU = Ox.INSTANCE.m10185getBg0d7_KjU();
        long m10233getText0d7_KjU = Ox.INSTANCE.m10233getText0d7_KjU();
        long m10217getPanel0d7_KjU3 = Ox.INSTANCE.m10217getPanel0d7_KjU();
        long m10233getText0d7_KjU2 = Ox.INSTANCE.m10233getText0d7_KjU();
        long m10218getPanel20d7_KjU = Ox.INSTANCE.m10218getPanel20d7_KjU();
        long m10199getDim0d7_KjU = Ox.INSTANCE.m10199getDim0d7_KjU();
        long m10217getPanel0d7_KjU4 = Ox.INSTANCE.m10217getPanel0d7_KjU();
        long m10217getPanel0d7_KjU5 = Ox.INSTANCE.m10217getPanel0d7_KjU();
        long m10218getPanel20d7_KjU2 = Ox.INSTANCE.m10218getPanel20d7_KjU();
        long m10218getPanel20d7_KjU3 = Ox.INSTANCE.m10218getPanel20d7_KjU();
        long m10218getPanel20d7_KjU4 = Ox.INSTANCE.m10218getPanel20d7_KjU();
        return ColorScheme.m1992copyCXl9yA$default(m2036darkColorSchemeCXl9yA$default, m10220getPrimary0d7_KjU, m10217getPanel0d7_KjU, m10222getPrimarySoft0d7_KjU, m10221getPrimaryDark0d7_KjU, 0L, m10192getCyan0d7_KjU, m10217getPanel0d7_KjU2, Ox.INSTANCE.m10222getPrimarySoft0d7_KjU(), Ox.INSTANCE.m10194getCyanInk0d7_KjU(), Ox.INSTANCE.m10223getPurple0d7_KjU(), Ox.INSTANCE.m10217getPanel0d7_KjU(), Ox.INSTANCE.m10222getPrimarySoft0d7_KjU(), Ox.INSTANCE.m10233getText0d7_KjU(), m10185getBg0d7_KjU, m10233getText0d7_KjU, m10217getPanel0d7_KjU3, m10233getText0d7_KjU2, m10218getPanel20d7_KjU, m10199getDim0d7_KjU, Color.INSTANCE.m4419getTransparent0d7_KjU(), Ox.INSTANCE.m10235getToastInk0d7_KjU(), Ox.INSTANCE.m10217getPanel0d7_KjU(), Ox.INSTANCE.m10196getDanger0d7_KjU(), Ox.INSTANCE.m10217getPanel0d7_KjU(), Ox.INSTANCE.m10198getDangerSoft0d7_KjU(), Ox.INSTANCE.m10196getDanger0d7_KjU(), Ox.INSTANCE.m10189getBorder0d7_KjU(), Ox.INSTANCE.m10189getBorder0d7_KjU(), Ox.INSTANCE.m10228getScrim0d7_KjU(), 0L, 0L, m10217getPanel0d7_KjU4, m10217getPanel0d7_KjU5, m10218getPanel20d7_KjU2, m10218getPanel20d7_KjU3, m10218getPanel20d7_KjU4, 1610612752, 0, null);
    }

    private static final Typography oxTypography() {
        return new Typography(null, null, null, null, null, null, OxType.INSTANCE.getH1(), OxType.INSTANCE.getH2(), OxType.INSTANCE.getH3(), OxType.INSTANCE.getBody(), OxType.INSTANCE.getBody(), OxType.INSTANCE.getCaption(), OxType.INSTANCE.getButton(), OxType.INSTANCE.getLabel(), OxType.INSTANCE.getChip(), 63, null);
    }

    public static final void FonRoTheme(final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-703460611);
        ComposerKt.sourceInformation(startRestartGroup, "C(FonRoTheme)124@4449L21,127@4633L35,127@4622L46,133@4797L687,129@4674L810:Theme.kt#fky3vh");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(content) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-703460611, i2, -1, "uz.FonRo.pos.ui.theme.FonRoTheme (Theme.kt:120)");
            }
            final boolean isSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1715766336, "CC(remember):Theme.kt#9igjgp");
            boolean changed = startRestartGroup.changed(isSystemInDarkTheme);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.theme.ThemeKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit FonRoTheme$lambda$0$0;
                        FonRoTheme$lambda$0$0 = ThemeKt.FonRoTheme$lambda$0$0(isSystemInDarkTheme);
                        return FonRoTheme$lambda$0$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
            MaterialThemeKt.MaterialTheme(oxColorScheme(), OxShapes, oxTypography(), ComposableLambdaKt.rememberComposableLambda(-1852734511, true, new Function2() { // from class: uz.FonRo.pos.ui.theme.ThemeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ThemeKt.FonRoTheme$lambda$1(Function2.this, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, 3120, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.theme.ThemeKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ThemeKt.FonRoTheme$lambda$2(Function2.this, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FonRoTheme$lambda$0$0(boolean z) {
        OxTheme.INSTANCE.setSystemDark(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FonRoTheme$lambda$1(final Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C144@5445L33,134@4807L671:Theme.kt#fky3vh");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1852734511, i, -1, "uz.FonRo.pos.ui.theme.FonRoTheme.<anonymous> (Theme.kt:134)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{IndicationKt.getLocalIndication().provides(RippleKt.m2509rippleH2RKhps$default(true, 0.0f, Ox.INSTANCE.m10233getText0d7_KjU(), 2, null)), TextKt.getLocalTextStyle().provides(TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10233getText0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null)), ContentColorKt.getLocalContentColor().provides(Color.m4374boximpl(Ox.INSTANCE.m10233getText0d7_KjU()))}, ComposableLambdaKt.rememberComposableLambda(-972572911, true, new Function2() { // from class: uz.FonRo.pos.ui.theme.ThemeKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FonRoTheme$lambda$1$0;
                    FonRoTheme$lambda$1$0 = ThemeKt.FonRoTheme$lambda$1$0(Function2.this, (Composer) obj, ((Integer) obj2).intValue());
                    return FonRoTheme$lambda$1$0;
                }
            }, composer, 54), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FonRoTheme$lambda$1$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C145@5459L9:Theme.kt#fky3vh");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-972572911, i, -1, "uz.FonRo.pos.ui.theme.FonRoTheme.<anonymous>.<anonymous> (Theme.kt:145)");
            }
            function2.invoke(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* renamed from: ink-4WTKRHQ, reason: not valid java name */
    public static final TextStyle m10322ink4WTKRHQ(TextStyle ink, long j) {
        Intrinsics.checkNotNullParameter(ink, "$this$ink");
        return TextStyle.m6448copyp1EtxEg$default(ink, j, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
    }
}
