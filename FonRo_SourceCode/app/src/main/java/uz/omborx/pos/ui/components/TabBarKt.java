package uz.FonRo.pos.ui.components;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteractionKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxDim;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: TabBar.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a_\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0007b\u0002\b\rb\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\f\u001aA\u0010\u0011\u001a\u00020\u0001*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0003b\u0002\b\rb\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\u0018\u001a=\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0003b\u0002\b\rb\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\u001a¨\u0006\u001b²\u0006\n\u0010\u001c\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\n\u0010\u001c\u001a\u00020\u0015X\u008a\u0084\u0002"}, d2 = {"OxTabBar", "", "tabs", "", "Luz/FonRo/pos/ui/components/TabItem;", "activeKey", "", "onSelect", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "centerKey", "(Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "PlainTab", "Landroidx/compose/foundation/layout/RowScope;", "tab", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/foundation/layout/RowScope;Luz/FonRo/pos/ui/components/TabItem;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "CenterTab", "(Luz/FonRo/pos/ui/components/TabItem;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app", "pressed"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class TabBarKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CenterTab$lambda$3(TabItem tabItem, boolean z, Function0 function0, int i, Composer composer, int i2) {
        CenterTab(tabItem, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxTabBar$lambda$2(List list, String str, Function1 function1, Modifier modifier, String str2, int i, int i2, Composer composer, int i3) {
        OxTabBar(list, str, function1, modifier, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PlainTab$lambda$3(RowScope rowScope, TabItem tabItem, boolean z, Function0 function0, int i, Composer composer, int i2) {
        PlainTab(rowScope, tabItem, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00f2, code lost:
    
        if (r5 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OxTabBar(final java.util.List<uz.FonRo.pos.ui.components.TabItem> r27, final java.lang.String r28, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r29, androidx.compose.ui.Modifier r30, java.lang.String r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 1139
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.TabBarKt.OxTabBar(java.util.List, java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxTabBar$lambda$1$0$0$0$0(Function1 function1, TabItem tabItem) {
        function1.invoke(tabItem.getKey());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxTabBar$lambda$1$0$0$1$0(Function1 function1, TabItem tabItem) {
        function1.invoke(tabItem.getKey());
        return Unit.INSTANCE;
    }

    private static final void PlainTab(final RowScope rowScope, TabItem tabItem, final boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        final TabItem tabItem2;
        Function0<Unit> function02;
        Composer startRestartGroup = composer.startRestartGroup(-125935983);
        ComposerKt.sourceInformation(startRestartGroup, "C(PlainTab)P(2)101@3720L39,102@3791L25,105@3872L1021:TabBar.kt#r5y9fm");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(rowScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            tabItem2 = tabItem;
            i2 |= startRestartGroup.changed(tabItem2) ? 32 : 16;
        } else {
            tabItem2 = tabItem;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function02 = function0;
            i2 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
        } else {
            function02 = function0;
        }
        if (!startRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-125935983, i2, -1, "uz.FonRo.pos.ui.components.PlainTab (TabBar.kt:100)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -765392200, "CC(remember):TabBar.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            State<Boolean> collectIsPressedAsState = PressInteractionKt.collectIsPressedAsState(mutableInteractionSource, startRestartGroup, 6);
            Ox ox = Ox.INSTANCE;
            long m10220getPrimary0d7_KjU = z ? ox.m10220getPrimary0d7_KjU() : ox.m10233getText0d7_KjU();
            Modifier scale = ScaleKt.scale(SizeKt.m1103widthInVpY3zN4$default(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), 0.0f, Dp.m6989constructorimpl(100.0f), 1, null), PlainTab$lambda$1(collectIsPressedAsState) ? 0.95f : 1.0f);
            float m6989constructorimpl = Dp.m6989constructorimpl(10.0f);
            RoundedCornerShape tab = OxShape.INSTANCE.getTab();
            Ox ox2 = Ox.INSTANCE;
            long m10220getPrimary0d7_KjU2 = z ? ox2.m10220getPrimary0d7_KjU() : ox2.m10233getText0d7_KjU();
            Ox ox3 = Ox.INSTANCE;
            Modifier m1052paddingqDBjuR0 = PaddingKt.m1052paddingqDBjuR0(ModifiersKt.oxClickable$default(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(ShadowKt.m4001shadows4CzXII$default(scale, m6989constructorimpl, tab, false, m10220getPrimary0d7_KjU2, z ? ox3.m10220getPrimary0d7_KjU() : ox3.m10233getText0d7_KjU(), 4, null), OxShape.INSTANCE.getTab()), Ox.INSTANCE.m10217getPanel0d7_KjU(), null, 2, null), false, mutableInteractionSource, 120L, function02, 1, null), Dp.m6989constructorimpl(2.0f), Dp.m6989constructorimpl(10.0f), Dp.m6989constructorimpl(2.0f), Dp.m6989constructorimpl(9.0f));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(3.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m930spacedBy0680j_4, centerHorizontally, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m1052paddingqDBjuR0);
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
            Updater.m3815setimpl(m3808constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1762859220, "C123@4623L91,124@4723L164:TabBar.kt#r5y9fm");
            long j = m10220getPrimary0d7_KjU;
            IconKt.m2255Iconww6aTOc(tabItem2.getIcon(), tabItem2.getTitle(), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(22.0f)), j, startRestartGroup, 384, 0);
            TextKt.m2798Text4IGK_g(tabItem2.getTitle(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getTabLabel(), j, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), startRestartGroup, 0, 3120, 55294);
            startRestartGroup = startRestartGroup;
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.components.TabBarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabBarKt.PlainTab$lambda$3(RowScope.this, tabItem2, z, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void CenterTab(final TabItem tabItem, final boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(994091378);
        ComposerKt.sourceInformation(startRestartGroup, "C(CenterTab)P(2)135@5007L39,136@5078L25,138@5109L925:TabBar.kt#r5y9fm");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(tabItem) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(994091378, i2, -1, "uz.FonRo.pos.ui.components.CenterTab (TabBar.kt:134)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1839077465, "CC(remember):TabBar.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier scale = ScaleKt.scale(OffsetKt.m1009offsetVpY3zN4$default(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, OxDim.INSTANCE.m10243getCenterTabD9Ej5fM()), 0.0f, Dp.m6989constructorimpl(-8.0f), 1, null), CenterTab$lambda$1(PressInteractionKt.collectIsPressedAsState(mutableInteractionSource, startRestartGroup, 6)) ? 0.94f : 1.0f);
            float m6989constructorimpl = Dp.m6989constructorimpl(14.0f);
            RoundedCornerShape pill = OxShape.INSTANCE.getPill();
            Ox ox = Ox.INSTANCE;
            long m10220getPrimary0d7_KjU = z ? ox.m10220getPrimary0d7_KjU() : ox.m10233getText0d7_KjU();
            Ox ox2 = Ox.INSTANCE;
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(ShadowKt.m4001shadows4CzXII$default(scale, m6989constructorimpl, pill, false, m10220getPrimary0d7_KjU, z ? ox2.m10220getPrimary0d7_KjU() : ox2.m10233getText0d7_KjU(), 4, null), OxShape.INSTANCE.getPill()), Ox.INSTANCE.m10217getPanel0d7_KjU(), null, 2, null);
            Modifier.Companion companion = Modifier.INSTANCE;
            if (z) {
                companion = BorderKt.m569borderxT4_qwU(companion, Dp.m6989constructorimpl(3.0f), Ox.INSTANCE.m10222getPrimarySoft0d7_KjU(), OxShape.INSTANCE.getPill());
            }
            Modifier oxClickable$default = ModifiersKt.oxClickable$default(m558backgroundbw27NRU$default.then(companion), false, mutableInteractionSource, 120L, function0, 1, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, oxClickable$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1769438026, "C157@5847L181:TabBar.kt#r5y9fm");
            composer2 = startRestartGroup;
            ImageVector icon = tabItem.getIcon();
            String title = tabItem.getTitle();
            Ox ox3 = Ox.INSTANCE;
            IconKt.m2255Iconww6aTOc(icon, title, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(30.0f)), z ? ox3.m10220getPrimary0d7_KjU() : ox3.m10233getText0d7_KjU(), composer2, 384, 0);
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
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.components.TabBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabBarKt.CenterTab$lambda$3(TabItem.this, z, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean PlainTab$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean CenterTab$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
