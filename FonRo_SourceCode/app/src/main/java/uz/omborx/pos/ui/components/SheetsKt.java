package uz.FonRo.pos.ui.components;

import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogWindowProvider;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.TextScaleKt;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: Sheets.kt */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ai\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000fH\u0007b\u0002\b\u000eb\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013¢\u0006\u0002\u0010\u0010\u001a\u009f\u0001\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\b\u001a\u00020\t2 \b\u0002\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000fH\u0007b\u0002\b\u000eb\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001c¢\u0006\u0002\u0010\u001b\u001a\u008b\u0001\u0010\u001d\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\t2 \b\u0002\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000fH\u0007b\u0002\b\u000eb\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001c¢\u0006\u0002\u0010\u001e\u001a\u001f\u0010\u001f\u001a\u00020\u0003H\u0003b\u0002\b\u000eb\f\b!\u0012\b\b\"\u0012\u0004\b\b(#¢\u0006\u0002\u0010 \u001a_\u0010$\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00162\b\b\u0002\u0010&\u001a\u00020\u00162\b\b\u0002\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0007b\u0002\b\u000eb\f\b!\u0012\b\b\"\u0012\u0004\b\b(#¢\u0006\u0002\u0010*\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"ZeroInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "OxFullSheet", "", "onDismiss", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "scrim", "", "closeButton", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/runtime/ComposableInferredTarget;", "scheme", "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]", "OxCardSheet", "title", "", "centerTitle", "fillHeight", "footer", "Landroidx/compose/foundation/layout/RowScope;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZZZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]", "OxSheet", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OxGrip", "(Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "OxConfirmSheet", "text", "confirmLabel", "confirmStyle", "Luz/FonRo/pos/ui/components/BtnStyle;", "onConfirm", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Luz/FonRo/pos/ui/components/BtnStyle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class SheetsKt {
    private static final WindowInsets ZeroInsets = WindowInsetsKt.WindowInsets(0, 0, 0, 0);

    /* JADX INFO: Access modifiers changed from: private */
    public static final int OxCardSheet$lambda$3$1$0$0$0(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int OxCardSheet$lambda$3$1$0$1$0(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxCardSheet$lambda$4(String str, Function0 function0, Modifier modifier, boolean z, boolean z2, boolean z3, Function3 function3, Function3 function32, int i, int i2, Composer composer, int i3) {
        OxCardSheet(str, function0, modifier, z, z2, z3, function3, function32, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxConfirmSheet$lambda$2(String str, String str2, String str3, BtnStyle btnStyle, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        OxConfirmSheet(str, str2, str3, btnStyle, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxFullSheet$lambda$1(Function0 function0, Modifier modifier, boolean z, boolean z2, Function3 function3, int i, int i2, Composer composer, int i3) {
        OxFullSheet(function0, modifier, z, z2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxGrip$lambda$1(int i, Composer composer, int i2) {
        OxGrip(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxSheet$lambda$2(String str, Function0 function0, Modifier modifier, boolean z, Function3 function3, Function3 function32, int i, int i2, Composer composer, int i3) {
        OxSheet(str, function0, modifier, z, function3, function32, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OxFullSheet(final kotlin.jvm.functions.Function0<kotlin.Unit> r22, androidx.compose.ui.Modifier r23, boolean r24, boolean r25, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.SheetsKt.OxFullSheet(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxFullSheet$lambda$0(final Function3 function3, final boolean z, final Function0 function0, ColumnScope ModalBottomSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ModalBottomSheet, "$this$ModalBottomSheet");
        ComposerKt.sourceInformation(composer, "C111@4867L852,111@4854L865:Sheets.kt#r5y9fm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(451485239, i, -1, "uz.FonRo.pos.ui.components.OxFullSheet.<anonymous> (Sheets.kt:111)");
            }
            TextScaleKt.OxTextScaled(ComposableLambdaKt.rememberComposableLambda(-539935692, true, new Function2() { // from class: uz.FonRo.pos.ui.components.SheetsKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OxFullSheet$lambda$0$0;
                    OxFullSheet$lambda$0$0 = SheetsKt.OxFullSheet$lambda$0$0(Function3.this, z, function0, (Composer) obj, ((Integer) obj2).intValue());
                    return OxFullSheet$lambda$0$0;
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxFullSheet$lambda$0$0(Function3 function3, boolean z, Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C112@4877L832:Sheets.kt#r5y9fm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-539935692, i, -1, "uz.FonRo.pos.ui.components.OxFullSheet.<anonymous>.<anonymous> (Sheets.kt:112)");
            }
            Modifier fillMaxHeight = SizeKt.fillMaxHeight(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.9f);
            Alignment bottomCenter = Alignment.INSTANCE.getBottomCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(bottomCenter, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, fillMaxHeight);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m3808constructorimpl = Updater.m3808constructorimpl(composer);
            Updater.m3815setimpl(m3808constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 216939085, "C118@5063L106:Sheets.kt#r5y9fm");
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, fillMaxSize$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer m3808constructorimpl2 = Updater.m3808constructorimpl(composer);
            Updater.m3815setimpl(m3808constructorimpl2, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            function3.invoke(ColumnScopeInstance.INSTANCE, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (z) {
                composer.startReplaceGroup(217070741);
                ComposerKt.sourceInformation(composer, "124@5218L467");
                BasicsKt.m9831OxIconButtonhGBTI10(function0, boxScopeInstance.align(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(6.0f), Dp.m6989constructorimpl(10.0f), 0.0f, 9, null), Alignment.INSTANCE.getTopEnd()), null, Dp.m6989constructorimpl(36.0f), ComposableSingletons$SheetsKt.INSTANCE.m9841getLambda$240228486$app(), composer, 27648, 4);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(217550280);
                composer.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OxCardSheet(final java.lang.String r24, final kotlin.jvm.functions.Function0<kotlin.Unit> r25, androidx.compose.ui.Modifier r26, boolean r27, boolean r28, boolean r29, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.SheetsKt.OxCardSheet(java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, boolean, boolean, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxCardSheet$lambda$1$0(MutableTransitionState mutableTransitionState) {
        mutableTransitionState.setTargetState$animation_core_release(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxCardSheet$lambda$3(final boolean z, final MutableTransitionState mutableTransitionState, final Modifier modifier, final boolean z2, final Function3 function3, final Function3 function32, final String str, final boolean z3, final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C200@8338L7,201@8365L88,201@8354L99,207@8627L3134,207@8614L3147:Sheets.kt#r5y9fm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1632161245, i, -1, "uz.FonRo.pos.ui.components.OxCardSheet.<anonymous> (Sheets.kt:200)");
            }
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(composer);
            final View view = (View) consume;
            ComposerKt.sourceInformationMarkerStart(composer, -843884997, "CC(remember):Sheets.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(view);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.components.SheetsKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit OxCardSheet$lambda$3$0$0;
                        OxCardSheet$lambda$3$0$0 = SheetsKt.OxCardSheet$lambda$3$0$0(view);
                        return OxCardSheet$lambda$3$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.SideEffect((Function0) rememberedValue, composer, 0);
            TextScaleKt.OxTextScaled(ComposableLambdaKt.rememberComposableLambda(-690406240, true, new Function2() { // from class: uz.FonRo.pos.ui.components.SheetsKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OxCardSheet$lambda$3$1;
                    OxCardSheet$lambda$3$1 = SheetsKt.OxCardSheet$lambda$3$1(z, mutableTransitionState, modifier, z2, function3, function32, str, z3, function0, (Composer) obj, ((Integer) obj2).intValue());
                    return OxCardSheet$lambda$3$1;
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxCardSheet$lambda$3$0$0(View view) {
        Window window;
        ViewParent parent = view.getParent();
        DialogWindowProvider dialogWindowProvider = parent instanceof DialogWindowProvider ? (DialogWindowProvider) parent : null;
        if (dialogWindowProvider != null && (window = dialogWindowProvider.getWindow()) != null) {
            window.setDimAmount(0.0f);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxCardSheet$lambda$3$1(final boolean z, final MutableTransitionState mutableTransitionState, final Modifier modifier, final boolean z2, final Function3 function3, final Function3 function32, final String str, final boolean z3, final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C208@8727L3024,208@8641L3110:Sheets.kt#r5y9fm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-690406240, i, -1, "uz.FonRo.pos.ui.components.OxCardSheet.<anonymous>.<anonymous> (Sheets.kt:208)");
            }
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getBottomCenter(), false, ComposableLambdaKt.rememberComposableLambda(-1933112202, true, new Function3() { // from class: uz.FonRo.pos.ui.components.SheetsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OxCardSheet$lambda$3$1$0;
                    OxCardSheet$lambda$3$1$0 = SheetsKt.OxCardSheet$lambda$3$1$0(z, mutableTransitionState, modifier, z2, function3, function32, str, z3, function0, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OxCardSheet$lambda$3$1$0;
                }
            }, composer, 54), composer, 3126, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxCardSheet$lambda$3$1$0(boolean z, MutableTransitionState mutableTransitionState, final Modifier modifier, final boolean z2, final Function3 function3, final Function3 function32, final String str, final boolean z3, final Function0 function0, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation(composer, "C211@8790L199,219@9145L6,220@9248L6,221@9295L2442,217@9007L2730:Sheets.kt#r5y9fm");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(BoxWithConstraints) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1933112202, i2, -1, "uz.FonRo.pos.ui.components.OxCardSheet.<anonymous>.<anonymous>.<anonymous> (Sheets.kt:209)");
            }
            final float m6989constructorimpl = Dp.m6989constructorimpl(BoxWithConstraints.mo955getMaxHeightD9Ej5fM() * 0.9f);
            BoxKt.Box(BackgroundKt.m558backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), z ? Ox.INSTANCE.m10228getScrim0d7_KjU() : Color.INSTANCE.m4419getTransparent0d7_KjU(), null, 2, null), composer, 0);
            TweenSpec tween$default = AnimationSpecKt.tween$default(220, 0, null, 6, null);
            ComposerKt.sourceInformationMarkerStart(composer, 2000026428, "CC(remember):Sheets.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.components.SheetsKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        int OxCardSheet$lambda$3$1$0$0$0;
                        OxCardSheet$lambda$3$1$0$0$0 = SheetsKt.OxCardSheet$lambda$3$1$0$0$0(((Integer) obj).intValue());
                        return Integer.valueOf(OxCardSheet$lambda$3$1$0$0$0);
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EnterTransition plus = EnterExitTransitionKt.slideInVertically(tween$default, (Function1) rememberedValue).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(160, 0, null, 6, null), 0.0f, 2, null));
            TweenSpec tween$default2 = AnimationSpecKt.tween$default(180, 0, null, 6, null);
            ComposerKt.sourceInformationMarkerStart(composer, 2000029724, "CC(remember):Sheets.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: uz.FonRo.pos.ui.components.SheetsKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        int OxCardSheet$lambda$3$1$0$1$0;
                        OxCardSheet$lambda$3$1$0$1$0 = SheetsKt.OxCardSheet$lambda$3$1$0$1$0(((Integer) obj).intValue());
                        return Integer.valueOf(OxCardSheet$lambda$3$1$0$1$0);
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AnimatedVisibilityKt.AnimatedVisibility((MutableTransitionState<Boolean>) mutableTransitionState, (Modifier) null, plus, EnterExitTransitionKt.slideOutVertically(tween$default2, (Function1) rememberedValue2).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(MenuKt.InTransitionDuration, 0, null, 6, null), 0.0f, 2, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(-1347467442, true, new Function3() { // from class: uz.FonRo.pos.ui.components.SheetsKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OxCardSheet$lambda$3$1$0$2;
                    OxCardSheet$lambda$3$1$0$2 = SheetsKt.OxCardSheet$lambda$3$1$0$2(Modifier.this, z2, m6989constructorimpl, function3, function32, str, z3, function0, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OxCardSheet$lambda$3$1$0$2;
                }
            }, composer, 54), composer, MutableTransitionState.$stable | 200064, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxCardSheet$lambda$3$1$0$2(Modifier modifier, boolean z, float f, Function3 function3, Function3 function32, String str, boolean z2, Function0 function0, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C228@9680L14,222@9317L2402:Sheets.kt#r5y9fm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1347467442, i, -1, "uz.FonRo.pos.ui.components.OxCardSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Sheets.kt:222)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null);
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier imePadding = WindowInsetsPadding_androidKt.imePadding(WindowInsetsPaddingKt.windowInsetsPadding(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(fillMaxWidth$default.then(z ? SizeKt.m1082height3ABfNKs(companion, f) : SizeKt.m1084heightInVpY3zN4$default(companion, 0.0f, f, 1, null)), OxShape.INSTANCE.getSheet()), Ox.INSTANCE.m10217getPanel0d7_KjU(), null, 2, null), WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composer, 6)));
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, imePadding);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m3808constructorimpl = Updater.m3808constructorimpl(composer);
            Updater.m3815setimpl(m3808constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 249646696, "C231@9786L1009,251@10821L369:Sheets.kt#r5y9fm");
            Modifier m1052paddingqDBjuR0 = PaddingKt.m1052paddingqDBjuR0(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6989constructorimpl(20.0f), Dp.m6989constructorimpl(14.0f), Dp.m6989constructorimpl(18.0f), Dp.m6989constructorimpl(10.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, m1052paddingqDBjuR0);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer m3808constructorimpl2 = Updater.m3808constructorimpl(composer);
            Updater.m3815setimpl(m3808constructorimpl2, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1276240497, "C237@10117L306,243@10452L317:Sheets.kt#r5y9fm");
            String str2 = str == null ? "" : str;
            TextStyle sheetTitle = OxType.INSTANCE.getSheetTitle();
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            TextAlign.Companion companion2 = TextAlign.INSTANCE;
            TextKt.m2798Text4IGK_g(str2, weight$default, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6866boximpl(z2 ? companion2.m6873getCentere0LSkKk() : companion2.m6878getStarte0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, sheetTitle, composer, 0, 0, 65020);
            BasicsKt.m9831OxIconButtonhGBTI10(function0, null, null, Dp.m6989constructorimpl(36.0f), ComposableSingletons$SheetsKt.INSTANCE.getLambda$905512013$app(), composer, 27648, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(PaddingKt.m1051paddingVpY3zN4$default(columnScopeInstance.weight(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, z), Dp.m6989constructorimpl(18.0f), 0.0f, 2, null), 0.0f, Dp.m6989constructorimpl(4.0f), 0.0f, Dp.m6989constructorimpl(16.0f), 5, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, m1053paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer m3808constructorimpl3 = Updater.m3808constructorimpl(composer);
            Updater.m3815setimpl(m3808constructorimpl3, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            function3.invoke(ColumnScopeInstance.INSTANCE, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (function32 != null) {
                composer.startReplaceGroup(251040145);
                ComposerKt.sourceInformation(composer, "261@11266L20,262@11315L356");
                BasicsKt.m9830OxDivideriPRSM58(Ox.INSTANCE.m10189getBorder0d7_KjU(), 0.0f, composer, 0, 2);
                Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6989constructorimpl(18.0f), Dp.m6989constructorimpl(12.0f));
                Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
                ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer, 6);
                ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, m1050paddingVpY3zN4);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor4);
                } else {
                    composer.useNode();
                }
                Composer m3808constructorimpl4 = Updater.m3808constructorimpl(composer);
                Updater.m3815setimpl(m3808constructorimpl4, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3815setimpl(m3808constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3808constructorimpl4.getInserting() || !Intrinsics.areEqual(m3808constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m3808constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m3808constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m3815setimpl(m3808constructorimpl4, materializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                function32.invoke(RowScopeInstance.INSTANCE, composer, 6);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(251483166);
                composer.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OxSheet(final java.lang.String r27, final kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.ui.Modifier r29, boolean r30, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.SheetsKt.OxSheet(java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final WindowInsets OxSheet$lambda$0(Composer composer, int i) {
        composer.startReplaceGroup(-1062501715);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1062501715, i, -1, "uz.FonRo.pos.ui.components.OxSheet.<anonymous> (Sheets.kt:297)");
        }
        WindowInsets windowInsets = ZeroInsets;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return windowInsets;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxSheet$lambda$1(final String str, final Function3 function3, final Function3 function32, final boolean z, final Function0 function0, ColumnScope ModalBottomSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ModalBottomSheet, "$this$ModalBottomSheet");
        ComposerKt.sourceInformation(composer, "C302@12705L1780,302@12692L1793:Sheets.kt#r5y9fm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(16001761, i, -1, "uz.FonRo.pos.ui.components.OxSheet.<anonymous> (Sheets.kt:302)");
            }
            TextScaleKt.OxTextScaled(ComposableLambdaKt.rememberComposableLambda(1112978244, true, new Function2() { // from class: uz.FonRo.pos.ui.components.SheetsKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OxSheet$lambda$1$0;
                    OxSheet$lambda$1$0 = SheetsKt.OxSheet$lambda$1$0(str, function3, function32, z, function0, (Composer) obj, ((Integer) obj2).intValue());
                    return OxSheet$lambda$1$0;
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxSheet$lambda$1$0(String str, Function3 function3, Function3 function32, boolean z, Function0 function0, Composer composer, int i) {
        String str2;
        Object obj;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        ColumnScopeInstance columnScopeInstance;
        int i2;
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C306@12826L14,303@12715L1760:Sheets.kt#r5y9fm");
        if (!composer2.shouldExecute((i & 3) != 2, i & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1112978244, i, -1, "uz.FonRo.pos.ui.components.OxSheet.<anonymous>.<anonymous> (Sheets.kt:303)");
            }
            Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composer2, 6));
            ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, windowInsetsPadding);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer m3808constructorimpl = Updater.m3808constructorimpl(composer2);
            Updater.m3815setimpl(m3808constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1789583466, "C330@13798L280:Sheets.kt#r5y9fm");
            String str8 = str;
            if (str8 != null && !StringsKt.isBlank(str8)) {
                composer2.startReplaceGroup(-1789577670);
                ComposerKt.sourceInformation(composer2, "309@12912L858");
                Modifier m1052paddingqDBjuR0 = PaddingKt.m1052paddingqDBjuR0(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6989constructorimpl(20.0f), Dp.m6989constructorimpl(4.0f), Dp.m6989constructorimpl(18.0f), Dp.m6989constructorimpl(10.0f));
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, m1052paddingqDBjuR0);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer m3808constructorimpl2 = Updater.m3808constructorimpl(composer2);
                Updater.m3815setimpl(m3808constructorimpl2, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 420660550, "C315@13194L256,321@13471L281:Sheets.kt#r5y9fm");
                TextStyle sheetTitle = OxType.INSTANCE.getSheetTitle();
                Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                TextAlign.Companion companion = TextAlign.INSTANCE;
                i2 = 6;
                columnScopeInstance = columnScopeInstance2;
                str2 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                obj = null;
                str3 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                str4 = "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo";
                str5 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                str6 = "C101@5232L9:Row.kt#2w3rfo";
                str7 = "C89@4556L9:Column.kt#2w3rfo";
                TextKt.m2798Text4IGK_g(str, weight$default, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6866boximpl(z ? companion.m6873getCentere0LSkKk() : companion.m6878getStarte0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, sheetTitle, composer, 0, 0, 65020);
                BasicsKt.m9831OxIconButtonhGBTI10(function0, null, null, Dp.m6989constructorimpl(36.0f), ComposableSingletons$SheetsKt.INSTANCE.m9843getLambda$847571286$app(), composer, 27648, 6);
                composer2 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            } else {
                str2 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                obj = null;
                str3 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                str4 = "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo";
                str5 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                str6 = "C101@5232L9:Row.kt#2w3rfo";
                str7 = "C89@4556L9:Column.kt#2w3rfo";
                columnScopeInstance = columnScopeInstance2;
                i2 = 6;
                composer2.startReplaceGroup(-1788722380);
                composer2.endReplaceGroup();
            }
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(PaddingKt.m1051paddingVpY3zN4$default(columnScopeInstance.weight(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, obj), 1.0f, false), Dp.m6989constructorimpl(18.0f), 0.0f, 2, obj), 0.0f, Dp.m6989constructorimpl(4.0f), 0.0f, Dp.m6989constructorimpl(16.0f), 5, null);
            ComposerKt.sourceInformationMarkerStart(composer2, -483455358, str4);
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
            String str9 = str5;
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str9);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, m1053paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            String str10 = str3;
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str10);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor3);
            } else {
                composer2.useNode();
            }
            Composer m3808constructorimpl3 = Updater.m3808constructorimpl(composer2);
            Updater.m3815setimpl(m3808constructorimpl3, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -384672921, str7);
            function3.invoke(ColumnScopeInstance.INSTANCE, composer2, Integer.valueOf(i2));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (function32 != null) {
                composer2.startReplaceGroup(-1788386061);
                ComposerKt.sourceInformation(composer2, "340@14130L20,341@14167L284");
                BasicsKt.m9830OxDivideriPRSM58(Ox.INSTANCE.m10189getBorder0d7_KjU(), 0.0f, composer2, 0, 2);
                Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, obj), Dp.m6989constructorimpl(18.0f), Dp.m6989constructorimpl(12.0f));
                Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, str2);
                int i3 = i2;
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer2, i3);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str9);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, m1050paddingVpY3zN4);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str10);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor4);
                } else {
                    composer2.useNode();
                }
                Composer m3808constructorimpl4 = Updater.m3808constructorimpl(composer2);
                Updater.m3815setimpl(m3808constructorimpl4, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3815setimpl(m3808constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3808constructorimpl4.getInserting() || !Intrinsics.areEqual(m3808constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m3808constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m3808constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m3815setimpl(m3808constructorimpl4, materializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -407735110, str6);
                function32.invoke(RowScopeInstance.INSTANCE, composer2, Integer.valueOf(i3));
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1788046828);
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OxGrip(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1843348927);
        ComposerKt.sourceInformation(startRestartGroup, "C(OxGrip)356@14534L297:Sheets.kt#r5y9fm");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1843348927, i, -1, "uz.FonRo.pos.ui.components.OxGrip (Sheets.kt:355)");
            }
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(8.0f), 1, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m1051paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            Updater.m3815setimpl(m3808constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1378287348, "C360@14657L168:Sheets.kt#r5y9fm");
            BoxKt.Box(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1082height3ABfNKs(SizeKt.m1101width3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(42.0f)), Dp.m6989constructorimpl(5.0f)), OxShape.INSTANCE.getPill()), Ox.INSTANCE.m10204getGrip0d7_KjU(), null, 2, null), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.components.SheetsKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SheetsKt.OxGrip$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OxConfirmSheet(final java.lang.String r15, final java.lang.String r16, java.lang.String r17, uz.FonRo.pos.ui.components.BtnStyle r18, final kotlin.jvm.functions.Function0<kotlin.Unit> r19, final kotlin.jvm.functions.Function0<kotlin.Unit> r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.SheetsKt.OxConfirmSheet(java.lang.String, java.lang.String, java.lang.String, uz.FonRo.pos.ui.components.BtnStyle, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxConfirmSheet$lambda$0(final Function0 function0, String str, final Function0 function02, BtnStyle btnStyle, RowScope OxSheet, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxSheet, "$this$OxSheet");
        ComposerKt.sourceInformation(composer, "C384@15218L89,387@15376L28,385@15320L184:Sheets.kt#r5y9fm");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(708323001, i2, -1, "uz.FonRo.pos.ui.components.OxConfirmSheet.<anonymous> (Sheets.kt:384)");
            }
            BasicsKt.OxButton(LangKt.tx("Отмена", new Object[0]), function0, RowScope.weight$default(OxSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.GHOST, null, false, false, null, composer, 3072, 240);
            ComposerKt.sourceInformationMarkerStart(composer, 2093576725, "CC(remember):Sheets.kt#9igjgp");
            boolean changed = composer.changed(function0) | composer.changed(function02);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.components.SheetsKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit OxConfirmSheet$lambda$0$0$0;
                        OxConfirmSheet$lambda$0$0$0 = SheetsKt.OxConfirmSheet$lambda$0$0$0(Function0.this, function02);
                        return OxConfirmSheet$lambda$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(str, (Function0) rememberedValue, RowScope.weight$default(OxSheet, Modifier.INSTANCE, 1.0f, false, 2, null), btnStyle, null, false, false, null, composer, 0, 240);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxConfirmSheet$lambda$0$0$0(Function0 function0, Function0 function02) {
        function0.invoke();
        function02.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxConfirmSheet$lambda$1(String str, ColumnScope OxSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSheet, "$this$OxSheet");
        ComposerKt.sourceInformation(composer, "C393@15531L52,394@15592L10:Sheets.kt#r5y9fm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(556165090, i, -1, "uz.FonRo.pos.ui.components.OxConfirmSheet.<anonymous> (Sheets.kt:393)");
            }
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
