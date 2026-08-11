package uz.FonRo.pos.ui.components;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.core.Lang;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.data.model.User;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: SelfAccessSheet.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\u001a?\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010\b\u001a'\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0003b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010\u0010¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u008e\u0002"}, d2 = {"SelfAccessSheet", "", "user", "Luz/FonRo/pos/data/model/User;", "repo", "Luz/FonRo/pos/data/repo/Repo;", "onDismiss", "Lkotlin/Function0;", "(Luz/FonRo/pos/data/model/User;Luz/FonRo/pos/data/repo/Repo;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "AccessSectionLabel", "text", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "app", "busy", ""}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class SelfAccessSheetKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AccessSectionLabel$lambda$0(String str, int i, Composer composer, int i2) {
        AccessSectionLabel(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SelfAccessSheet$lambda$7(User user, Repo repo, Function0 function0, int i, Composer composer, int i2) {
        SelfAccessSheet(user, repo, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SelfAccessSheet(final User user, final Repo repo, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        final Repo repo2;
        boolean z;
        Object obj;
        final Function0<Unit> onDismiss = function0;
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(-1722080143);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelfAccessSheet)P(2,1)49@2026L24,50@2067L34,52@2120L35,54@2216L618,94@3766L485,109@4258L1461,91@3671L2048:SelfAccessSheet.kt#r5y9fm");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(user) : startRestartGroup.changedInstance(user) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(repo) : startRestartGroup.changedInstance(repo) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 256 : 128;
        }
        int i3 = i2;
        boolean z2 = true;
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            repo2 = repo;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1722080143, i3, -1, "uz.FonRo.pos.ui.components.SelfAccessSheet (SelfAccessSheet.kt:48)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)558@25470L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -954203484, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1356604365, "CC(remember):SelfAccessSheet.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            String code = Lang.INSTANCE.getCode();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1356602668, "CC(remember):SelfAccessSheet.kt#9igjgp");
            boolean changed = startRestartGroup.changed(code);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = Perm.INSTANCE.getGROUPS();
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final List list = (List) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Map<String, Integer> selfLimits = user != null ? user.getSelfLimits() : null;
            if (selfLimits == null) {
                selfLimits = MapsKt.emptyMap();
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1356599013, "CC(remember):SelfAccessSheet.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                SnapshotStateMap mutableStateMapOf = SnapshotStateKt.mutableStateMapOf();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((List) ((Pair) it.next()).component2()).iterator();
                    while (it2.hasNext()) {
                        mutableStateMapOf.put((String) ((Pair) it2.next()).component1(), Boolean.valueOf(!selfLimits.containsKey(r15)));
                        z2 = z2;
                    }
                }
                z = z2;
                mutableStateMapOf.put(Perm.MANAGE_USERS, Boolean.valueOf(z));
                mutableStateMapOf.put(Perm.MANAGE_SETTINGS, Boolean.valueOf(z));
                startRestartGroup.updateRememberedValue(mutableStateMapOf);
                obj = mutableStateMapOf;
            } else {
                z = true;
                obj = rememberedValue4;
            }
            final SnapshotStateMap snapshotStateMap = (SnapshotStateMap) obj;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            String tx = LangKt.tx("Мой доступ", new Object[0]);
            Function3 function3 = new Function3() { // from class: uz.FonRo.pos.ui.components.SelfAccessSheetKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return SelfAccessSheetKt.SelfAccessSheet$lambda$5(CoroutineScope.this, repo, function0, snapshotStateMap, mutableState, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            };
            repo2 = repo;
            boolean z3 = z;
            onDismiss = function0;
            SheetsKt.OxCardSheet(tx, onDismiss, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(29331300, z3, function3, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(624902797, z3, new Function3() { // from class: uz.FonRo.pos.ui.components.SelfAccessSheetKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return SelfAccessSheetKt.SelfAccessSheet$lambda$6(list, snapshotStateMap, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i3 >> 3) & 112) | 14155776, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.components.SelfAccessSheetKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return SelfAccessSheetKt.SelfAccessSheet$lambda$7(User.this, repo2, onDismiss, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final boolean SelfAccessSheet$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelfAccessSheet$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void SelfAccessSheet$save(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, SnapshotStateMap<String, Boolean> snapshotStateMap, Repo repo, Function0<Unit> function0) {
        if (SelfAccessSheet$lambda$1(mutableState)) {
            return;
        }
        SelfAccessSheet$lambda$2(mutableState, true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SelfAccessSheetKt$SelfAccessSheet$save$1(snapshotStateMap, repo, function0, mutableState, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SelfAccessSheet$lambda$5(final CoroutineScope coroutineScope, final Repo repo, final Function0 function0, final SnapshotStateMap snapshotStateMap, final MutableState mutableState, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C97@3841L52,95@3780L175,102@4059L10,100@3968L273:SelfAccessSheet.kt#r5y9fm");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(29331300, i2, -1, "uz.FonRo.pos.ui.components.SelfAccessSheet.<anonymous> (SelfAccessSheet.kt:95)");
            }
            String tx = LangKt.tx("Открыть всё", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -1877389320, "CC(remember):SelfAccessSheet.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.components.SelfAccessSheetKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SelfAccessSheet$lambda$5$0$0;
                        SelfAccessSheet$lambda$5$0$0 = SelfAccessSheetKt.SelfAccessSheet$lambda$5$0$0(SnapshotStateMap.this);
                        return SelfAccessSheet$lambda$5$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), null, null, false, false, null, composer, 48, 248);
            String tx2 = SelfAccessSheet$lambda$1(mutableState) ? LangKt.tx("Сохраняем…", new Object[0]) : LangKt.tx("Сохранить", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -1877382386, "CC(remember):SelfAccessSheet.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(repo) | composer.changed(function0);
            Object rememberedValue2 = composer.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Function0 function02 = new Function0() { // from class: uz.FonRo.pos.ui.components.SelfAccessSheetKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SelfAccessSheet$lambda$5$1$0;
                        SelfAccessSheet$lambda$5$1$0 = SelfAccessSheetKt.SelfAccessSheet$lambda$5$1$0(CoroutineScope.this, mutableState, snapshotStateMap, repo, function0);
                        return SelfAccessSheet$lambda$5$1$0;
                    }
                };
                composer.updateRememberedValue(function02);
                rememberedValue2 = function02;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx2, (Function0) rememberedValue2, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, !SelfAccessSheet$lambda$1(mutableState), false, null, composer, 27648, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelfAccessSheet$lambda$5$0$0(SnapshotStateMap snapshotStateMap) {
        Iterator it = CollectionsKt.toList(snapshotStateMap.keySet()).iterator();
        while (it.hasNext()) {
            snapshotStateMap.put((String) it.next(), true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelfAccessSheet$lambda$5$1$0(CoroutineScope coroutineScope, MutableState mutableState, SnapshotStateMap snapshotStateMap, Repo repo, Function0 function0) {
        SelfAccessSheet$save(coroutineScope, mutableState, snapshotStateMap, repo, function0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SelfAccessSheet$lambda$6(List list, final SnapshotStateMap snapshotStateMap, ColumnScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C110@4268L239,114@4516L11,115@4582L21,115@4536L1177:SelfAccessSheet.kt#r5y9fm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(624902797, i, -1, "uz.FonRo.pos.ui.components.SelfAccessSheet.<anonymous> (SelfAccessSheet.kt:110)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Выключите разделы, которые не хотите показывать. Вы остаётесь владельцем — вернуть всё можно в один тап. Настройка действует на всех ваших устройствах.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
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
            ComposerKt.sourceInformationMarkerStart(composer, -229636731, "C138@5693L10:SelfAccessSheet.kt#r5y9fm");
            composer.startReplaceGroup(-1531428096);
            ComposerKt.sourceInformation(composer, "*117@4675L27,118@4726L912,118@4719L919,136@5655L11");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                String str = (String) pair.component1();
                final List list2 = (List) pair.component2();
                AccessSectionLabel(str, composer, 0);
                BasicsKt.OxList(null, ComposableLambdaKt.rememberComposableLambda(-1145098185, true, new Function3() { // from class: uz.FonRo.pos.ui.components.SelfAccessSheetKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit SelfAccessSheet$lambda$6$0$0$0;
                        SelfAccessSheet$lambda$6$0$0$0 = SelfAccessSheetKt.SelfAccessSheet$lambda$6$0$0$0(list2, snapshotStateMap, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return SelfAccessSheet$lambda$6$0$0$0;
                    }
                }, composer, 54), composer, 48, 1);
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(14.0f), composer, 6);
            }
            composer.endReplaceGroup();
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer, 6);
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
    public static final Unit SelfAccessSheet$lambda$6$0$0$0(List list, final SnapshotStateMap snapshotStateMap, ColumnScope OxList, Composer composer, int i) {
        Function0 function0;
        boolean z;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(OxList, "$this$OxList");
        ComposerKt.sourceInformation(composer2, "C*126@5247L325,121@4885L713:SelfAccessSheet.kt#r5y9fm");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1145098185, i, -1, "uz.FonRo.pos.ui.components.SelfAccessSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SelfAccessSheet.kt:119)");
            }
            int i2 = 0;
            for (Object obj : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Pair pair = (Pair) obj;
                final String str = (String) pair.component1();
                String str2 = (String) pair.component2();
                final boolean areEqual = Intrinsics.areEqual(str, Perm.MANAGE_SETTINGS);
                String tx = areEqual ? LangKt.tx("нельзя скрыть: отсюда всё и возвращается", new Object[0]) : null;
                if (i2 < CollectionsKt.getLastIndex(list)) {
                    function0 = null;
                    z = true;
                } else {
                    function0 = null;
                    z = false;
                }
                if (areEqual) {
                    composer2.startReplaceGroup(521896867);
                } else {
                    composer2.startReplaceGroup(521908741);
                    ComposerKt.sourceInformation(composer2, "125@5170L35");
                    ComposerKt.sourceInformationMarkerStart(composer2, -814448227, "CC(remember):SelfAccessSheet.kt#9igjgp");
                    boolean changed = composer2.changed(str);
                    Object rememberedValue = composer2.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.components.SelfAccessSheetKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit SelfAccessSheet$lambda$6$0$0$0$0$0$0;
                                SelfAccessSheet$lambda$6$0$0$0$0$0$0 = SelfAccessSheetKt.SelfAccessSheet$lambda$6$0$0$0$0$0$0(SnapshotStateMap.this, str);
                                return SelfAccessSheet$lambda$6$0$0$0$0$0$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    function0 = (Function0) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                }
                composer2.endReplaceGroup();
                BasicsKt.m9832OxRow1YH7lEI(str2, null, tx, function0, z, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1511760957, true, new Function3() { // from class: uz.FonRo.pos.ui.components.SelfAccessSheetKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        Unit SelfAccessSheet$lambda$6$0$0$0$0$1;
                        SelfAccessSheet$lambda$6$0$0$0$0$1 = SelfAccessSheetKt.SelfAccessSheet$lambda$6$0$0$0$0$1(SnapshotStateMap.this, str, areEqual, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        return SelfAccessSheet$lambda$6$0$0$0$0$1;
                    }
                }, composer2, 54), composer2, 12582912, 98);
                composer2 = composer;
                i2 = i3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelfAccessSheet$lambda$6$0$0$0$0$0$0(SnapshotStateMap snapshotStateMap, String str) {
        snapshotStateMap.put(str, Boolean.valueOf(!Intrinsics.areEqual(snapshotStateMap.get(str), (Object) true)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelfAccessSheet$lambda$6$0$0$0$0$1(final SnapshotStateMap snapshotStateMap, final String str, final boolean z, RowScope OxRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxRow, "$this$OxRow");
        ComposerKt.sourceInformation(composer, "C130@5464L44,127@5281L261:SelfAccessSheet.kt#r5y9fm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1511760957, i, -1, "uz.FonRo.pos.ui.components.SelfAccessSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SelfAccessSheet.kt:127)");
            }
            boolean areEqual = Intrinsics.areEqual(snapshotStateMap.get(str), (Object) true);
            boolean z2 = !z;
            ComposerKt.sourceInformationMarkerStart(composer, -1103326641, "CC(remember):SelfAccessSheet.kt#9igjgp");
            boolean changed = composer.changed(z) | composer.changed(str);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.components.SelfAccessSheetKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SelfAccessSheet$lambda$6$0$0$0$0$1$0$0;
                        SelfAccessSheet$lambda$6$0$0$0$0$1$0$0 = SelfAccessSheetKt.SelfAccessSheet$lambda$6$0$0$0$0$1$0$0(z, snapshotStateMap, str, ((Boolean) obj).booleanValue());
                        return SelfAccessSheet$lambda$6$0$0$0$0$1$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SwitchKt.Switch(areEqual, (Function1) rememberedValue, null, null, z2, null, null, composer, 0, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelfAccessSheet$lambda$6$0$0$0$0$1$0$0(boolean z, SnapshotStateMap snapshotStateMap, String str, boolean z2) {
        if (!z) {
            snapshotStateMap.put(str, Boolean.valueOf(z2));
        }
        return Unit.INSTANCE;
    }

    private static final void AccessSectionLabel(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-253291567);
        ComposerKt.sourceInformation(startRestartGroup, "C(AccessSectionLabel)146@5867L284:SelfAccessSheet.kt#r5y9fm");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-253291567, i2, -1, "uz.FonRo.pos.ui.components.AccessSectionLabel (SelfAccessSheet.kt:145)");
            }
            String upperCase = str.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(upperCase, PaddingKt.m1052paddingqDBjuR0(Modifier.INSTANCE, Dp.m6989constructorimpl(4.0f), Dp.m6989constructorimpl(2.0f), Dp.m6989constructorimpl(4.0f), Dp.m6989constructorimpl(7.0f)), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, FontWeight.INSTANCE.getExtraBold(), null, null, null, null, TextUnitKt.getSp(0.5d), null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777082, null), composer2, 0, 0, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.components.SelfAccessSheetKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SelfAccessSheetKt.AccessSectionLabel$lambda$0(str, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
