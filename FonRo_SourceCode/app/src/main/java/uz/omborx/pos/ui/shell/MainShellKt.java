package uz.FonRo.pos.ui.shell;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.Lang;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.data.model.User;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.AppRootKt;
import uz.FonRo.pos.ui.Toaster;
import uz.FonRo.pos.ui.catalog.CatalogScreenKt;
import uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt;
import uz.FonRo.pos.ui.clients.ClientsScreenKt;
import uz.FonRo.pos.ui.components.PageHeadKt;
import uz.FonRo.pos.ui.components.PageSurfaceKt;
import uz.FonRo.pos.ui.components.TabBarKt;
import uz.FonRo.pos.ui.components.TabItem;
import uz.FonRo.pos.ui.docs.AuditScreenKt;
import uz.FonRo.pos.ui.docs.ReturnsScreenKt;
import uz.FonRo.pos.ui.docs.StockInScreenKt;
import uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt;
import uz.FonRo.pos.ui.docs.SuppliersScreenKt;
import uz.FonRo.pos.ui.docs.WriteOffScreenKt;
import uz.FonRo.pos.ui.home.HomeScreenKt;
import uz.FonRo.pos.ui.money.DebtsScreenKt;
import uz.FonRo.pos.ui.money.ExpensesScreenKt;
import uz.FonRo.pos.ui.money.HistoryScreenKt;
import uz.FonRo.pos.ui.more.LogScreenKt;
import uz.FonRo.pos.ui.more.MoreScreenKt;
import uz.FonRo.pos.ui.more.OutboxScreenKt;
import uz.FonRo.pos.ui.more.SupportScreenKt;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.nav.PendingRoute;
import uz.FonRo.pos.ui.nav.Routes;
import uz.FonRo.pos.ui.orders.OrdersScreenKt;
import uz.FonRo.pos.ui.print.PrintLabelsScreenKt;
import uz.FonRo.pos.ui.print.PrinterSetupScreenKt;
import uz.FonRo.pos.ui.sale.SaleScreenKt;
import uz.FonRo.pos.ui.stats.StatsScreenKt;
import uz.FonRo.pos.ui.team.MyDevicesScreenKt;
import uz.FonRo.pos.ui.team.TeamScreenKt;
import uz.FonRo.pos.ui.theme.Ox;

/* compiled from: MainShell.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007b\u0002\b\u0005b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0004\u001a\u001e\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u001a7\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0003b\u0002\b\u0005b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u000f¨\u0006\u0002²\u0006\f\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u008a\u0084\u0002"}, d2 = {"MainShell", "", "app", "Luz/FonRo/pos/FonRoApp;", "(Luz/FonRo/pos/FonRoApp;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "openRoute", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "route", "", "RouteContent", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "user", "Luz/FonRo/pos/data/model/User;"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class MainShellKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainShell$lambda$8(FonRoApp FonRoApp, int i, Composer composer, int i2) {
        MainShell(FonRoApp, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RouteContent$lambda$0(FonRoApp FonRoApp, AppNavigator appNavigator, String str, int i, Composer composer, int i2) {
        RouteContent(FonRoApp, appNavigator, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void MainShell(final FonRoApp app, Composer composer, final int i) {
        Composer composer2;
        Intrinsics.checkNotNullParameter(app, "app");
        Composer startRestartGroup = composer.startRestartGroup(-619292230);
        ComposerKt.sourceInformation(startRestartGroup, "C(MainShell)68@2808L27,77@3324L29,78@3369L113,84@3672L7,85@3717L282,85@3684L315,93@4026L55,93@4005L76,102@4421L110,102@4396L135,107@4537L1206,140@5795L15,140@5749L61:MainShell.kt#fkeb9g");
        int i2 = (i & 6) == 0 ? ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2) | i : i;
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-619292230, i2, -1, "uz.FonRo.pos.ui.shell.MainShell (MainShell.kt:67)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1860622613, "CC(remember):MainShell.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new AppNavigator();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final AppNavigator appNavigator = (AppNavigator) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Repo repo = app.getRepo();
            Object MainShell$lambda$1 = MainShell$lambda$1(FlowExtKt.collectAsStateWithLifecycle(repo.getUser(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7));
            Object code = Lang.INSTANCE.getCode();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1860640651, "CC(remember):MainShell.kt#9igjgp");
            boolean changed = startRestartGroup.changed(MainShell$lambda$1) | startRestartGroup.changed(code);
            ArrayList rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                List<TabItem> tabs = Routes.INSTANCE.getTABS();
                ArrayList arrayList = new ArrayList();
                for (Object obj : tabs) {
                    TabItem tabItem = (TabItem) obj;
                    if (tabItem.getPermission() == null || repo.can(tabItem.getPermission())) {
                        arrayList.add(obj);
                    }
                }
                rememberedValue2 = arrayList;
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            List list = (List) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final LifecycleOwner lifecycleOwner = (LifecycleOwner) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1860651956, "CC(remember):MainShell.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(repo) | startRestartGroup.changedInstance(lifecycleOwner);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: uz.FonRo.pos.ui.shell.MainShellKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        DisposableEffectResult MainShell$lambda$3$0;
                        MainShell$lambda$3$0 = MainShellKt.MainShell$lambda$3$0(LifecycleOwner.this, repo, (DisposableEffectScope) obj2);
                        return MainShell$lambda$3$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.DisposableEffect(lifecycleOwner, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue3, startRestartGroup, 0);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1860661617, "CC(remember):MainShell.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(repo);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = (Function2) new MainShellKt$MainShell$2$1(repo, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue4, startRestartGroup, 6);
            Integer valueOf = Integer.valueOf(PendingRoute.INSTANCE.getSeq());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1860674312, "CC(remember):MainShell.kt#9igjgp");
            int i3 = i2 & 14;
            boolean changedInstance3 = (i3 == 4 || ((i2 & 8) != 0 && startRestartGroup.changedInstance(app))) | startRestartGroup.changedInstance(appNavigator);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = (Function2) new MainShellKt$MainShell$3$1(app, appNavigator, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue5, startRestartGroup, 0);
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Ox.INSTANCE.m10185getBg0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m558backgroundbw27NRU$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -755837630, "C110@4712L20,112@4742L281:MainShell.kt#fkeb9g");
            HomeScreenKt.HomeScreen(app, appNavigator, startRestartGroup, FonRoApp.$stable | i3 | (AppNavigator.$stable << 3));
            Modifier align = boxScopeInstance.align(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getBottomCenter());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, align);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            Updater.m3815setimpl(m3808constructorimpl2, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 171748459, "C118@4960L39,115@4851L162:MainShell.kt#fkeb9g");
            String activeTab = appNavigator.getActiveTab();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -825740355, "CC(remember):MainShell.kt#9igjgp");
            boolean changedInstance4 = startRestartGroup.changedInstance(appNavigator) | (i3 == 4 || ((i2 & 8) != 0 && startRestartGroup.changedInstance(app)));
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = new Function1() { // from class: uz.FonRo.pos.ui.shell.MainShellKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit MainShell$lambda$6$0$0$0;
                        MainShell$lambda$6$0$0$0 = MainShellKt.MainShell$lambda$6$0$0$0(FonRoApp.this, appNavigator, (String) obj2);
                        return MainShell$lambda$6$0$0$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            TabBarKt.OxTabBar(list, activeTab, (Function1) rememberedValue6, null, null, startRestartGroup, 0, 24);
            composer2 = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.startReplaceGroup(114175734);
            ComposerKt.sourceInformation(composer2, "");
            int i4 = 0;
            for (String str : appNavigator.getStack()) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final String str2 = str;
                composer2.startMovableGroup(-345126299, str2 + i4);
                ComposerKt.sourceInformation(composer2, "124@5137L35,128@5325L388,125@5189L524");
                ComposerKt.sourceInformationMarkerStart(composer2, -345125335, "CC(remember):MainShell.kt#9igjgp");
                boolean changedInstance5 = composer2.changedInstance(appNavigator) | composer2.changed(str2);
                Object rememberedValue7 = composer2.rememberedValue();
                if (changedInstance5 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue7 = new Function0() { // from class: uz.FonRo.pos.ui.shell.MainShellKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit MainShell$lambda$6$1$0$0;
                            MainShell$lambda$6$1$0$0 = MainShellKt.MainShell$lambda$6$1$0$0(AppNavigator.this, str2);
                            return MainShell$lambda$6$1$0$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue7);
                }
                final Function0 function0 = (Function0) rememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Composer composer3 = composer2;
                PageSurfaceKt.OxPageSurface(boxScopeInstance, i4 == 0, ComposableLambdaKt.rememberComposableLambda(2094974240, true, new Function3() { // from class: uz.FonRo.pos.ui.shell.MainShellKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        Unit MainShell$lambda$6$1$1;
                        MainShell$lambda$6$1$1 = MainShellKt.MainShell$lambda$6$1$1(Function0.this, app, appNavigator, str2, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        return MainShell$lambda$6$1$1;
                    }
                }, composer2, 54), composer3, 390, 0);
                composer2 = composer3;
                composer2.endMovableGroup();
                i4 = i5;
            }
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            boolean z = !appNavigator.getStack().isEmpty();
            ComposerKt.sourceInformationMarkerStart(composer2, 1860718185, "CC(remember):MainShell.kt#9igjgp");
            boolean changedInstance6 = composer2.changedInstance(appNavigator);
            Object rememberedValue8 = composer2.rememberedValue();
            if (changedInstance6 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = new Function0() { // from class: uz.FonRo.pos.ui.shell.MainShellKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MainShell$lambda$7$0;
                        MainShell$lambda$7$0 = MainShellKt.MainShell$lambda$7$0(AppNavigator.this);
                        return MainShell$lambda$7$0;
                    }
                };
                composer2.updateRememberedValue(rememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            AppRootKt.BackToClose(z, (Function0) rememberedValue8, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.shell.MainShellKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return MainShellKt.MainShell$lambda$8(FonRoApp.this, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult MainShell$lambda$3$0(final LifecycleOwner lifecycleOwner, final Repo repo, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: uz.FonRo.pos.ui.shell.MainShellKt$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                MainShellKt.MainShell$lambda$3$0$0(Repo.this, lifecycleOwner2, event);
            }
        };
        lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        return new DisposableEffectResult() { // from class: uz.FonRo.pos.ui.shell.MainShellKt$MainShell$lambda$3$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                LifecycleOwner.this.getLifecycle().removeObserver(lifecycleEventObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainShell$lambda$3$0$0(Repo repo, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            Repo.refreshInBackground$default(repo, false, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainShell$lambda$6$0$0$0(FonRoApp FonRoApp, AppNavigator appNavigator, String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        openRoute(FonRoApp, appNavigator, route);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainShell$lambda$6$1$0$0(AppNavigator appNavigator, String str) {
        appNavigator.closeTo(str);
        appNavigator.close();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainShell$lambda$6$1$1(Function0 function0, final FonRoApp FonRoApp, final AppNavigator appNavigator, final String str, ColumnScope OxPageSurface, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxPageSurface, "$this$OxPageSurface");
        ComposerKt.sourceInformation(composer, "C132@5618L77,132@5562L133:MainShell.kt#fkeb9g");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2094974240, i, -1, "uz.FonRo.pos.ui.shell.MainShell.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainShell.kt:132)");
            }
            CompositionLocalKt.CompositionLocalProvider(PageHeadKt.getLocalPageClose().provides(function0), ComposableLambdaKt.rememberComposableLambda(1738635744, true, new Function2() { // from class: uz.FonRo.pos.ui.shell.MainShellKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MainShell$lambda$6$1$1$0;
                    MainShell$lambda$6$1$1$0 = MainShellKt.MainShell$lambda$6$1$1$0(FonRoApp.this, appNavigator, str, (Composer) obj, ((Integer) obj2).intValue());
                    return MainShell$lambda$6$1$1$0;
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainShell$lambda$6$1$1$0(FonRoApp FonRoApp, AppNavigator appNavigator, String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C133@5644L29:MainShell.kt#fkeb9g");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1738635744, i, -1, "uz.FonRo.pos.ui.shell.MainShell.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainShell.kt:133)");
            }
            RouteContent(FonRoApp, appNavigator, str, composer, FonRoApp.$stable | (AppNavigator.$stable << 3));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainShell$lambda$7$0(AppNavigator appNavigator) {
        appNavigator.close();
        return Unit.INSTANCE;
    }

    public static final void openRoute(FonRoApp app, AppNavigator nav, String route) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(nav, "nav");
        Intrinsics.checkNotNullParameter(route, "route");
        String permissionOf = Routes.INSTANCE.permissionOf(route);
        if (permissionOf != null && !app.getRepo().can(permissionOf)) {
            Toaster.INSTANCE.error(LangKt.tx("Нет доступа к этому разделу", new Object[0]));
        } else if (SetsKt.setOf((Object[]) new String[]{Routes.STOCK_IN, Routes.CATALOG, Routes.SALE, Routes.STATS, Routes.AUDIT}).contains(route)) {
            nav.openTab(route);
        } else {
            nav.open(route);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static final void RouteContent(final FonRoApp FonRoApp, final AppNavigator appNavigator, final String str, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-140104534);
        ComposerKt.sourceInformation(startRestartGroup, "C(RouteContent):MainShell.kt#fkeb9g");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(FonRoApp) : startRestartGroup.changedInstance(FonRoApp) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(appNavigator) : startRestartGroup.changedInstance(appNavigator) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(str) ? 256 : 128;
        }
        if (startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-140104534, i2, -1, "uz.FonRo.pos.ui.shell.RouteContent (MainShell.kt:157)");
            }
            switch (str.hashCode()) {
                case -1935391973:
                    if (str.equals(Routes.EXPENSES)) {
                        startRestartGroup.startReplaceGroup(-1496453150);
                        ComposerKt.sourceInformation(startRestartGroup, "168@6891L24");
                        ExpensesScreenKt.ExpensesScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case -1884711237:
                    if (str.equals(Routes.STOCK_IN)) {
                        startRestartGroup.startReplaceGroup(-1496462495);
                        ComposerKt.sourceInformation(startRestartGroup, "162@6599L23");
                        StockInScreenKt.StockInScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case -1854767153:
                    if (str.equals("support")) {
                        startRestartGroup.startReplaceGroup(-1496436831);
                        ComposerKt.sourceInformation(startRestartGroup, "178@7401L23");
                        SupportScreenKt.SupportScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case -1846454992:
                    if (str.equals(Routes.WRITEOFF)) {
                        startRestartGroup.startReplaceGroup(-1496449886);
                        ComposerKt.sourceInformation(startRestartGroup, "170@6993L24");
                        WriteOffScreenKt.WriteOffScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case -1752554063:
                    if (str.equals(Routes.MY_DEVICES)) {
                        startRestartGroup.startReplaceGroup(-1496441437);
                        ComposerKt.sourceInformation(startRestartGroup, "175@7257L25");
                        MyDevicesScreenKt.MyDevicesScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case -1008770331:
                    if (str.equals("orders")) {
                        startRestartGroup.startReplaceGroup(-1496439808);
                        ComposerKt.sourceInformation(startRestartGroup, "176@7308L22");
                        OrdersScreenKt.OrdersScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case -1005526083:
                    if (str.equals(Routes.OUTBOX)) {
                        startRestartGroup.startReplaceGroup(-1496430304);
                        ComposerKt.sourceInformation(startRestartGroup, "182@7605L22");
                        OutboxScreenKt.OutboxScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case -546924004:
                    if (str.equals(Routes.STOCK_IN_NEW)) {
                        startRestartGroup.startReplaceGroup(-1496460732);
                        ComposerKt.sourceInformation(startRestartGroup, "163@6654L26");
                        StockInScreenKt.StockInNewScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case -314718182:
                    if (str.equals(Routes.PRINTER_SETUP)) {
                        startRestartGroup.startReplaceGroup(-1496432026);
                        ComposerKt.sourceInformation(startRestartGroup, "181@7551L28");
                        PrinterSetupScreenKt.PrinterSetupScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case -22855641:
                    if (str.equals(Routes.SUPPLIERS)) {
                        startRestartGroup.startReplaceGroup(-1496448189);
                        ComposerKt.sourceInformation(startRestartGroup, "171@7046L25");
                        SuppliersScreenKt.SuppliersScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case 107332:
                    if (str.equals(Routes.LOG)) {
                        startRestartGroup.startReplaceGroup(-1496435363);
                        ComposerKt.sourceInformation(startRestartGroup, "179@7447L19");
                        LogScreenKt.LogScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case 3347807:
                    if (str.equals(Routes.MENU)) {
                        startRestartGroup.startReplaceGroup(-1496438338);
                        ComposerKt.sourceInformation(startRestartGroup, "177@7354L20");
                        MoreScreenKt.MoreScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case 3522631:
                    if (str.equals(Routes.SALE)) {
                        startRestartGroup.startReplaceGroup(-1496467426);
                        ComposerKt.sourceInformation(startRestartGroup, "159@6445L20");
                        SaleScreenKt.SaleScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case 3555933:
                    if (str.equals(Routes.TEAM)) {
                        startRestartGroup.startReplaceGroup(-1496443042);
                        ComposerKt.sourceInformation(startRestartGroup, "174@7207L20");
                        TeamScreenKt.TeamScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case 93166555:
                    if (str.equals(Routes.AUDIT)) {
                        startRestartGroup.startReplaceGroup(-1496459110);
                        ComposerKt.sourceInformation(startRestartGroup, "164@6705L16");
                        AuditScreenKt.AuditScreen(FonRoApp, startRestartGroup, FonRoApp.$stable | (i2 & 14));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case 95458880:
                    if (str.equals(Routes.DEBTS)) {
                        startRestartGroup.startReplaceGroup(-1496454721);
                        ComposerKt.sourceInformation(startRestartGroup, "167@6842L21");
                        DebtsScreenKt.DebtsScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case 106934957:
                    if (str.equals(Routes.PRINT)) {
                        startRestartGroup.startReplaceGroup(-1496433947);
                        ComposerKt.sourceInformation(startRestartGroup, "180@7491L27");
                        PrintLabelsScreenKt.PrintLabelsScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case 109757599:
                    if (str.equals(Routes.STATS)) {
                        startRestartGroup.startReplaceGroup(-1496457793);
                        ComposerKt.sourceInformation(startRestartGroup, "165@6746L21");
                        StatsScreenKt.StatsScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case 375684560:
                    if (str.equals(Routes.SUPPLIER_RETURNS)) {
                        startRestartGroup.startReplaceGroup(-1496446231);
                        ComposerKt.sourceInformation(startRestartGroup, "172@7107L31");
                        SupplierReturnsScreenKt.SupplierReturnsScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case 555704345:
                    if (str.equals(Routes.CATALOG)) {
                        startRestartGroup.startReplaceGroup(-1496465919);
                        ComposerKt.sourceInformation(startRestartGroup, "160@6492L23");
                        CatalogScreenKt.CatalogScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case 556236748:
                    if (str.equals(Routes.CATSHOP)) {
                        startRestartGroup.startReplaceGroup(-1496464313);
                        ComposerKt.sourceInformation(startRestartGroup, "161@6542L29");
                        GlobalCatalogScreenKt.GlobalCatalogScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case 860587528:
                    if (str.equals(Routes.CLIENTS)) {
                        startRestartGroup.startReplaceGroup(-1496444388);
                        ComposerKt.sourceInformation(startRestartGroup, "173@7165L18");
                        ClientsScreenKt.ClientsScreen(FonRoApp, startRestartGroup, FonRoApp.$stable | (i2 & 14));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case 926934164:
                    if (str.equals(Routes.HISTORY)) {
                        startRestartGroup.startReplaceGroup(-1496456255);
                        ComposerKt.sourceInformation(startRestartGroup, "166@6794L23");
                        HistoryScreenKt.HistoryScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                case 1098475843:
                    if (str.equals(Routes.RETURNS)) {
                        startRestartGroup.startReplaceGroup(-1496451519);
                        ComposerKt.sourceInformation(startRestartGroup, "169@6942L23");
                        ReturnsScreenKt.ReturnsScreen(FonRoApp, appNavigator, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112));
                        startRestartGroup.endReplaceGroup();
                        break;
                    }
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
                default:
                    startRestartGroup.startReplaceGroup(-1496429074);
                    startRestartGroup.endReplaceGroup();
                    break;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.shell.MainShellKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainShellKt.RouteContent$lambda$0(FonRoApp.this, appNavigator, str, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final User MainShell$lambda$1(State<User> state) {
        return state.getValue();
    }
}
