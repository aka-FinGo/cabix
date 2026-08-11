package uz.FonRo.pos.ui.sale;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnSize;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: HeldCarts.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007b\u0002\b\bb\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\u0002\u0010\u0007¨\u0006\u0002²\u0006\u0010\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u008a\u008e\u0002"}, d2 = {"HeldCartsSheet", "", "app", "Luz/FonRo/pos/FonRoApp;", "onResumed", "Lkotlin/Function0;", "onDismiss", "(Luz/FonRo/pos/FonRoApp;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "list", "", "Luz/FonRo/pos/ui/sale/HeldCart;"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class HeldCartsKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit HeldCartsSheet$lambda$4(FonRoApp FonRoApp, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        HeldCartsSheet(FonRoApp, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void HeldCartsSheet(final FonRoApp app, final Function0<Unit> onResumed, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(onResumed, "onResumed");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(-266796388);
        ComposerKt.sourceInformation(startRestartGroup, "C(HeldCartsSheet)P(!1,2)176@6283L49,178@6404L2671,178@6338L2737:HeldCarts.kt#1sewlp");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onResumed) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-266796388, i2, -1, "uz.FonRo.pos.ui.sale.HeldCartsSheet (HeldCarts.kt:174)");
            }
            final Repo repo = app.getRepo();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1306713325, "CC(remember):HeldCarts.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(HeldCarts.INSTANCE.load(repo), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SheetsKt.OxCardSheet(LangKt.tx("Отложенные чеки", new Object[0]), onDismiss, null, false, false, false, null, ComposableLambdaKt.rememberComposableLambda(587921920, true, new Function3() { // from class: uz.FonRo.pos.ui.sale.HeldCartsKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return HeldCartsKt.HeldCartsSheet$lambda$3(MutableState.this, repo, onResumed, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 >> 3) & 112) | 12582912, 124);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.sale.HeldCartsKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HeldCartsKt.HeldCartsSheet$lambda$4(FonRoApp.this, onResumed, onDismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final List<HeldCart> HeldCartsSheet$lambda$1(MutableState<List<HeldCart>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit HeldCartsSheet$lambda$3(final MutableState mutableState, final Repo repo, final Function0 function0, ColumnScope OxCardSheet, Composer composer, int i) {
        String tx;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C184@6595L21,184@6538L2531:HeldCarts.kt#1sewlp");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(587921920, i, -1, "uz.FonRo.pos.ui.sale.HeldCartsSheet.<anonymous> (HeldCarts.kt:179)");
            }
            if (HeldCartsSheet$lambda$1(mutableState).isEmpty()) {
                composer.startReplaceGroup(-94681692);
                ComposerKt.sourceInformation(composer, "180@6448L39");
                BasicsKt.OxEmptyNote(LangKt.tx("Отложенных чеков нет", new Object[0]), null, composer, 0, 2);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
            composer.startReplaceGroup(-94591358);
            composer.endReplaceGroup();
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, verticalScroll$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -64139137, "C236@9049L10:HeldCarts.kt#1sewlp");
            composer.startReplaceGroup(552120456);
            ComposerKt.sourceInformation(composer, "*189@6907L2115,189@6835L2187");
            for (final HeldCart heldCart : HeldCartsSheet$lambda$1(mutableState)) {
                HeldItem heldItem = (HeldItem) CollectionsKt.firstOrNull((List) heldCart.getItems());
                if (heldItem == null || (tx = heldItem.getName()) == null) {
                    tx = LangKt.tx("Чек", new Object[0]);
                }
                final String str = tx + (heldCart.getItems().size() > 1 ? " +" + (heldCart.getItems().size() - 1) : "");
                BasicsKt.m9833OxSoftCardCe4qNIY(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(9.0f), 7, null), Dp.m6989constructorimpl(12.0f), null, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-540481828, true, new Function3() { // from class: uz.FonRo.pos.ui.sale.HeldCartsKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit HeldCartsSheet$lambda$3$0$0$0;
                        HeldCartsSheet$lambda$3$0$0$0 = HeldCartsKt.HeldCartsSheet$lambda$3$0$0$0(HeldCart.this, str, repo, function0, mutableState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return HeldCartsSheet$lambda$3$0$0$0;
                    }
                }, composer, 54), composer, 1572918, 60);
            }
            composer.endReplaceGroup();
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(4.0f), composer, 6);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeldCartsSheet$lambda$3$0$0$0(final HeldCart heldCart, String str, final Repo repo, final Function0 function0, final MutableState mutableState, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C190@6929L861,208@7811L249,213@8081L923:HeldCarts.kt#1sewlp");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-540481828, i, -1, "uz.FonRo.pos.ui.sale.HeldCartsSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HeldCarts.kt:190)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, fillMaxWidth$default);
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
            Updater.m3815setimpl(m3808constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1433601407, "C195@7190L177,199@7392L282,206@7699L69:HeldCarts.kt#1sewlp");
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getInbox(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(18.0f)), Ox.INSTANCE.m10238getWarn0d7_KjU(), composer, 432, 0);
            TextKt.m2798Text4IGK_g(str, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), composer, 0, 3120, 55292);
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.nf(Double.valueOf(HeldCarts.INSTANCE.totalOf(repo, heldCart))), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowPrice(), composer, 0, 0, 65534);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m2798Text4IGK_g(LangKt.tx("%s поз. · отложен %s", Integer.valueOf(heldCart.getItems().size()), Fmt.dt$default(Fmt.INSTANCE, heldCart.getCreatedAt(), false, 2, null)), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(2.0f), 0.0f, Dp.m6989constructorimpl(10.0f), 5, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 48, 0, 65532);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion);
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
            Updater.m3815setimpl(m3808constructorimpl2, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 867289817, "C216@8262L137,214@8163L423,226@8702L154,224@8611L371:HeldCarts.kt#1sewlp");
            String tx = LangKt.tx("Вернуть в кассу", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -803304416, "CC(remember):HeldCarts.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(repo) | composer.changedInstance(heldCart) | composer.changed(function0);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.sale.HeldCartsKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit HeldCartsSheet$lambda$3$0$0$0$1$0$0;
                        HeldCartsSheet$lambda$3$0$0$0$1$0$0 = HeldCartsKt.HeldCartsSheet$lambda$3$0$0$0$1$0$0(Repo.this, heldCart, function0);
                        return HeldCartsSheet$lambda$3$0$0$0$1$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.PRIMARY, BtnSize.SM, false, false, null, composer, 27648, 224);
            String tx2 = LangKt.tx("Удалить", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -803290319, "CC(remember):HeldCarts.kt#9igjgp");
            boolean changedInstance2 = composer.changedInstance(repo) | composer.changedInstance(heldCart);
            Object rememberedValue2 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.sale.HeldCartsKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit HeldCartsSheet$lambda$3$0$0$0$1$1$0;
                        HeldCartsSheet$lambda$3$0$0$0$1$1$0 = HeldCartsKt.HeldCartsSheet$lambda$3$0$0$0$1$1$0(Repo.this, heldCart, mutableState);
                        return HeldCartsSheet$lambda$3$0$0$0$1$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx2, (Function0) rememberedValue2, null, BtnStyle.DANGER, BtnSize.SM, false, false, null, composer, 27648, 228);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeldCartsSheet$lambda$3$0$0$0$1$0$0(Repo repo, HeldCart heldCart, Function0 function0) {
        HeldCarts.INSTANCE.resume(repo, heldCart);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeldCartsSheet$lambda$3$0$0$0$1$1$0(Repo repo, HeldCart heldCart, MutableState mutableState) {
        HeldCarts.INSTANCE.drop(repo, heldCart.getId());
        mutableState.setValue(HeldCarts.INSTANCE.load(repo));
        return Unit.INSTANCE;
    }
}
