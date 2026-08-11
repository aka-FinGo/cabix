package uz.FonRo.pos.ui.home;

import androidx.camera.video.AudioStats;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.location.LocationRequestCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.R;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.data.local.CacheStore;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.model.StoreStats;
import uz.FonRo.pos.data.model.User;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.ModifiersKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.nav.Routes;
import uz.FonRo.pos.ui.shell.MainShellKt;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: HomeScreen.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0006\u001aY\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0014\u001aQ\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u001d\u001aC\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\b&\u0010'\u001a?\u0010(\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010)\u001a\u00020\rH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010*\u001a?\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\b1\u00102\u001a-\u00103\u001a\u00020\u00012\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u00104\u001aC\u00105\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u00106\u001a\u0004\u0018\u00010\u0019H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u00107\u001aY\u00108\u001a\u00020\u00012\u0006\u00109\u001a\u00020:2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010$\u001a\u00020%2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\b;\u0010<\u001a)\u0010=\u001a\u00020\u00012\b\u0010>\u001a\u0004\u0018\u00010\u0017H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010?\u001aE\u0010@\u001a\u00020\u0001*\u00020A2\u0006\u0010B\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020%H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010D¨\u0006\u0002²\u0006\u0010\u0010E\u001a\b\u0012\u0004\u0012\u00020G0FX\u008a\u0084\u0002²\u0006\f\u0010H\u001a\u0004\u0018\u00010IX\u008a\u0084\u0002²\u0006\f\u00106\u001a\u0004\u0018\u00010\u0019X\u008a\u0084\u0002²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u0084\u0002²\u0006\n\u0010)\u001a\u00020\rX\u008a\u0084\u0002²\u0006\n\u0010J\u001a\u00020\rX\u008a\u0084\u0002²\u0006\f\u0010K\u001a\u0004\u0018\u00010\u0017X\u008a\u008e\u0002²\u0006\f\u0010>\u001a\u0004\u0018\u00010\u0017X\u008a\u008e\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\n\u0010\u001a\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\n\u0010L\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\f\u0010H\u001a\u0004\u0018\u00010IX\u008a\u0084\u0002"}, d2 = {"HomeScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "TopBar", "ordersNew", "", "hasOther", "", "onNotify", "Lkotlin/Function0;", "onLog", "onMenu", "(IZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SalesCard", Routes.STATS, "Luz/FonRo/pos/data/model/StoreStats;", "paid", "", "debtToday", "canStats", "canProfit", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/data/model/StoreStats;DDZZLandroidx/compose/runtime/Composer;I)V", "MiniTile", "label", "", "value", "tint", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "MiniTile-cf5BqRc", "(Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "QuickActions", "supportUnread", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;IILandroidx/compose/runtime/Composer;I)V", "QuickTile", "action", "Luz/FonRo/pos/ui/home/QuickAction;", "width", "Landroidx/compose/ui/unit/Dp;", "onClick", "QuickTile-rAjV9yQ", "(Luz/FonRo/pos/ui/home/QuickAction;FLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "AllSalesCta", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "KeyMetrics", "debtTotal", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Luz/FonRo/pos/data/model/StoreStats;Ljava/lang/Double;Landroidx/compose/runtime/Composer;I)V", "MetricTile", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "MetricTile-OadGlvw", "(Landroidx/compose/ui/graphics/vector/ImageVector;JLjava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "WeekChart", "week", "(Luz/FonRo/pos/data/model/StoreStats;Landroidx/compose/runtime/Composer;I)V", "WeekColumn", "Landroidx/compose/foundation/layout/RowScope;", "iso", "max", "(Landroidx/compose/foundation/layout/RowScope;Ljava/lang/String;DDLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", CacheStore.PRODUCTS, "", "Luz/FonRo/pos/data/model/Product;", "user", "Luz/FonRo/pos/data/model/User;", "dataVersion", "today", "notifySheet"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class HomeScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AllSalesCta$lambda$1(Function0 function0, int i, Composer composer, int i2) {
        AllSalesCta(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit HomeScreen$lambda$29(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        HomeScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit KeyMetrics$lambda$1(FonRoApp FonRoApp, AppNavigator appNavigator, StoreStats storeStats, Double d, int i, Composer composer, int i2) {
        KeyMetrics(FonRoApp, appNavigator, storeStats, d, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MetricTile_OadGlvw$lambda$1(ImageVector imageVector, long j, String str, String str2, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        m9957MetricTileOadGlvw(imageVector, j, str, str2, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MiniTile_cf5BqRc$lambda$1(String str, String str2, long j, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m9958MiniTilecf5BqRc(str, str2, j, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickActions$lambda$2(FonRoApp FonRoApp, AppNavigator appNavigator, int i, int i2, int i3, Composer composer, int i4) {
        QuickActions(FonRoApp, appNavigator, i, i2, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickActions$lambda$4(FonRoApp FonRoApp, AppNavigator appNavigator, int i, int i2, int i3, Composer composer, int i4) {
        QuickActions(FonRoApp, appNavigator, i, i2, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickTile_rAjV9yQ$lambda$1(QuickAction quickAction, float f, Function0 function0, int i, Composer composer, int i2) {
        m9959QuickTilerAjV9yQ(quickAction, f, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SalesCard$lambda$1(FonRoApp FonRoApp, StoreStats storeStats, double d, double d2, boolean z, boolean z2, int i, Composer composer, int i2) {
        SalesCard(FonRoApp, storeStats, d, d2, z, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TopBar$lambda$1(int i, boolean z, Function0 function0, Function0 function02, Function0 function03, int i2, Composer composer, int i3) {
        TopBar(i, z, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WeekChart$lambda$4(StoreStats storeStats, int i, Composer composer, int i2) {
        WeekChart(storeStats, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WeekColumn$lambda$1(RowScope rowScope, String str, double d, double d2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        WeekColumn(rowScope, str, d, d2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void HomeScreen(FonRoApp FonRoApp, AppNavigator appNavigator, Composer composer, final int i) {
        int i2;
        Composer composer2;
        final MutableState mutableState;
        int i3;
        int i4;
        Repo repo;
        String str;
        List<NotifyItem> list;
        boolean z;
        boolean z2;
        final Repo repo2;
        final FonRoApp app = FonRoApp;
        final AppNavigator nav = appNavigator;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(nav, "nav");
        Composer startRestartGroup = composer.startRestartGroup(1914061315);
        ComposerKt.sourceInformation(startRestartGroup, "C(HomeScreen)82@3494L24,84@3554L29,85@3610L29,86@3676L29,87@3742L29,88@3816L29,90@3956L29,94@4131L103,98@4253L46,99@4316L46,100@4379L32,101@4433L32,102@4489L34,157@6814L54,157@6753L115,161@6915L7,162@6970L279,162@6927L322,170@7286L14,170@7301L17,177@7469L21,178@7538L10,173@7358L1466,226@9135L10,226@9110L35:HomeScreen.kt#1sln1x");
        if ((i & 6) == 0) {
            i2 = i | ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(nav) : startRestartGroup.changedInstance(nav) ? 32 : 16;
        }
        int i5 = i2;
        if (!startRestartGroup.shouldExecute((i5 & 19) != 18, i5 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1914061315, i5, -1, "uz.FonRo.pos.ui.home.HomeScreen (HomeScreen.kt:80)");
            }
            Repo repo3 = app.getRepo();
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
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(repo3.getProducts(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            State collectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(repo3.getUser(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            State collectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(repo3.getDebtTotal(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            State collectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(repo3.getOrdersNew(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            State collectAsStateWithLifecycle5 = FlowExtKt.collectAsStateWithLifecycle(repo3.getSupportUnread(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            State collectAsStateWithLifecycle6 = FlowExtKt.collectAsStateWithLifecycle(repo3.getDataVersion(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            List<Product> HomeScreen$lambda$0 = HomeScreen$lambda$0(collectAsStateWithLifecycle);
            int HomeScreen$lambda$3 = HomeScreen$lambda$3(collectAsStateWithLifecycle4);
            Double HomeScreen$lambda$2 = HomeScreen$lambda$2(collectAsStateWithLifecycle3);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1166944458, "CC(remember):HomeScreen.kt#9igjgp");
            boolean changed = startRestartGroup.changed(HomeScreen$lambda$0) | startRestartGroup.changed(HomeScreen$lambda$3) | startRestartGroup.changed(HomeScreen$lambda$2);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = NotifyCenter.INSTANCE.items(repo3, HomeScreen$lambda$3(collectAsStateWithLifecycle4), HomeScreen$lambda$2(collectAsStateWithLifecycle3));
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            List<NotifyItem> list2 = (List) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1166948305, "CC(remember):HomeScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            MutableState mutableState2 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1166950321, "CC(remember):HomeScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1166952323, "CC(remember):HomeScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1166954051, "CC(remember):HomeScreen.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final MutableState mutableState5 = (MutableState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1166955845, "CC(remember):HomeScreen.kt#9igjgp");
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            MutableState mutableState6 = (MutableState) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            boolean can = repo3.can(Perm.VIEW_STATISTICS);
            boolean can2 = repo3.can(Perm.VIEW_PROFIT);
            Integer valueOf = Integer.valueOf(HomeScreen$lambda$5(collectAsStateWithLifecycle6));
            String current = nav.getCurrent();
            Boolean valueOf2 = Boolean.valueOf(can);
            User HomeScreen$lambda$1 = HomeScreen$lambda$1(collectAsStateWithLifecycle2);
            Object[] objArr = {valueOf, current, valueOf2, HomeScreen$lambda$1 != null ? Long.valueOf(HomeScreen$lambda$1.getId()) : null};
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1167030265, "CC(remember):HomeScreen.kt#9igjgp");
            int i6 = i5 & 112;
            boolean changedInstance = (i6 == 32 || ((i5 & 64) != 0 && startRestartGroup.changedInstance(nav))) | startRestartGroup.changedInstance(repo3) | startRestartGroup.changed(can);
            HomeScreenKt$HomeScreen$1$1 rememberedValue8 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                composer2 = startRestartGroup;
                mutableState = mutableState6;
                i3 = i5;
                i4 = i6;
                repo = repo3;
                str = "CC(remember):HomeScreen.kt#9igjgp";
                list = list2;
                z = can;
                HomeScreenKt$HomeScreen$1$1 homeScreenKt$HomeScreen$1$1 = new HomeScreenKt$HomeScreen$1$1(appNavigator, z, repo, mutableState2, mutableState3, mutableState4, mutableState5, null);
                nav = appNavigator;
                mutableState2 = mutableState2;
                rememberedValue8 = homeScreenKt$HomeScreen$1$1;
                composer2.updateRememberedValue(rememberedValue8);
            } else {
                composer2 = startRestartGroup;
                mutableState = mutableState6;
                z = can;
                i3 = i5;
                i4 = i6;
                repo = repo3;
                list = list2;
                str = "CC(remember):HomeScreen.kt#9igjgp";
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.LaunchedEffect(objArr, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue8, composer2, 0);
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(localLifecycleOwner);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            final LifecycleOwner lifecycleOwner = (LifecycleOwner) consume;
            Boolean valueOf3 = Boolean.valueOf(z);
            ComposerKt.sourceInformationMarkerStart(composer2, 1167035482, str);
            boolean changedInstance2 = composer2.changedInstance(coroutineScope) | composer2.changedInstance(repo) | composer2.changed(z) | composer2.changedInstance(lifecycleOwner);
            Object rememberedValue9 = composer2.rememberedValue();
            if (changedInstance2 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                final MutableState mutableState7 = mutableState2;
                final boolean z3 = z;
                final Repo repo4 = repo;
                rememberedValue9 = new Function1() { // from class: uz.FonRo.pos.ui.home.HomeScreenKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult HomeScreen$lambda$24$0;
                        HomeScreen$lambda$24$0 = HomeScreenKt.HomeScreen$lambda$24$0(LifecycleOwner.this, coroutineScope, z3, repo4, mutableState7, mutableState3, mutableState4, mutableState5, (DisposableEffectScope) obj);
                        return HomeScreen$lambda$24$0;
                    }
                };
                z2 = z3;
                repo2 = repo4;
                mutableState2 = mutableState7;
                mutableState3 = mutableState3;
                mutableState4 = mutableState4;
                mutableState5 = mutableState5;
                composer2.updateRememberedValue(rememberedValue9);
            } else {
                z2 = z;
                repo2 = repo;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.DisposableEffect(lifecycleOwner, valueOf3, (Function1) rememberedValue9, composer2, 0);
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(PaddingKt.m1051paddingVpY3zN4$default(WindowInsetsPaddingKt.windowInsetsPadding(ScrollKt.verticalScroll$default(BackgroundKt.m558backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Ox.INSTANCE.m10185getBg0d7_KjU(), null, 2, null), ScrollKt.rememberScrollState(0, composer2, 0, 1), false, null, false, 14, null), WindowInsets_androidKt.getStatusBars(WindowInsets.INSTANCE, composer2, 6)), Dp.m6989constructorimpl(14.0f), 0.0f, 2, null), 0.0f, Dp.m6989constructorimpl(10.0f), 0.0f, Dp.m6989constructorimpl(Dp.m6989constructorimpl(100.0f) + WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composer2, 6), composer2, 0).getBottom()), 5, null);
            ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m1053paddingqDBjuR0$default);
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
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 49295856, "C188@8002L22,189@8046L180,193@8249L36,182@7672L623,196@8305L11,197@8325L59,199@8394L11,200@8414L48,202@8472L11,203@8504L159,203@8492L171,208@8673L11,209@8693L38:HomeScreen.kt#1sln1x");
            int HomeScreen$lambda$32 = HomeScreen$lambda$3(collectAsStateWithLifecycle4);
            boolean hasOther = NotifyCenter.INSTANCE.hasOther(list);
            ComposerKt.sourceInformationMarkerStart(composer2, -1938063025, str);
            Object rememberedValue10 = composer2.rememberedValue();
            if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                rememberedValue10 = new Function0() { // from class: uz.FonRo.pos.ui.home.HomeScreenKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit HomeScreen$lambda$25$0$0;
                        HomeScreen$lambda$25$0$0 = HomeScreenKt.HomeScreen$lambda$25$0$0(MutableState.this);
                        return HomeScreen$lambda$25$0$0;
                    }
                };
                composer2.updateRememberedValue(rememberedValue10);
            }
            Function0 function0 = (Function0) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, -1938061459, str);
            int i7 = i3 & 14;
            int i8 = i4;
            boolean changedInstance3 = composer2.changedInstance(repo2) | (i7 == 4 || ((i3 & 8) != 0 && composer2.changedInstance(app))) | (i8 == 32 || ((i3 & 64) != 0 && composer2.changedInstance(nav)));
            Object rememberedValue11 = composer2.rememberedValue();
            if (changedInstance3 || rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                rememberedValue11 = new Function0() { // from class: uz.FonRo.pos.ui.home.HomeScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit HomeScreen$lambda$25$1$0;
                        HomeScreen$lambda$25$1$0 = HomeScreenKt.HomeScreen$lambda$25$1$0(Repo.this, app, nav);
                        return HomeScreen$lambda$25$1$0;
                    }
                };
                composer2.updateRememberedValue(rememberedValue11);
            }
            Function0 function02 = (Function0) rememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, -1938055107, str);
            boolean z4 = (i7 == 4 || ((i3 & 8) != 0 && composer2.changedInstance(app))) | (i8 == 32 || ((i3 & 64) != 0 && composer2.changedInstance(nav)));
            Object rememberedValue12 = composer2.rememberedValue();
            if (z4 || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                rememberedValue12 = new Function0() { // from class: uz.FonRo.pos.ui.home.HomeScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit HomeScreen$lambda$25$2$0;
                        HomeScreen$lambda$25$2$0 = HomeScreenKt.HomeScreen$lambda$25$2$0(FonRoApp.this, nav);
                        return HomeScreen$lambda$25$2$0;
                    }
                };
                composer2.updateRememberedValue(rememberedValue12);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Composer composer3 = composer2;
            boolean z5 = true;
            TopBar(HomeScreen$lambda$32, hasOther, function0, function02, (Function0) rememberedValue12, composer3, 384);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(14.0f), composer3, 6);
            StoreStats HomeScreen$lambda$8 = HomeScreen$lambda$8(mutableState2);
            double HomeScreen$lambda$14 = HomeScreen$lambda$14(mutableState4);
            double HomeScreen$lambda$17 = HomeScreen$lambda$17(mutableState5);
            int i9 = FonRoApp.$stable | i7;
            boolean z6 = z2;
            SalesCard(app, HomeScreen$lambda$8, HomeScreen$lambda$14, HomeScreen$lambda$17, z6, can2, composer3, (StoreStats.$stable << 3) | i9);
            startRestartGroup = composer3;
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(14.0f), startRestartGroup, 6);
            app = FonRoApp;
            nav = appNavigator;
            QuickActions(app, nav, HomeScreen$lambda$3(collectAsStateWithLifecycle4), HomeScreen$lambda$4(collectAsStateWithLifecycle5), startRestartGroup, FonRoApp.$stable | i7 | (AppNavigator.$stable << 3) | i8);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(14.0f), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1938046824, str);
            boolean changedInstance4 = startRestartGroup.changedInstance(repo2) | (i7 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(app))) | (i8 == 32 || ((i3 & 64) != 0 && startRestartGroup.changedInstance(nav)));
            Object rememberedValue13 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                rememberedValue13 = new Function0() { // from class: uz.FonRo.pos.ui.home.HomeScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit HomeScreen$lambda$25$3$0;
                        HomeScreen$lambda$25$3$0 = HomeScreenKt.HomeScreen$lambda$25$3$0(Repo.this, app, nav);
                        return HomeScreen$lambda$25$3$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue13);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            AllSalesCta((Function0) rememberedValue13, startRestartGroup, 0);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(14.0f), startRestartGroup, 6);
            KeyMetrics(app, nav, HomeScreen$lambda$8(mutableState2), HomeScreen$lambda$2(collectAsStateWithLifecycle3), startRestartGroup, (StoreStats.$stable << 6) | FonRoApp.$stable | i7 | (AppNavigator.$stable << 3) | i8);
            if (z6) {
                startRestartGroup.startReplaceGroup(50336618);
                ComposerKt.sourceInformation(startRestartGroup, "212@8769L11,213@8793L15");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(14.0f), startRestartGroup, 6);
                WeekChart(HomeScreen$lambda$11(mutableState3), startRestartGroup, StoreStats.$stable);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(50397161);
                startRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (HomeScreen$lambda$20(mutableState)) {
                startRestartGroup.startReplaceGroup(1820220522);
                ComposerKt.sourceInformation(startRestartGroup, "220@8924L39,221@8989L23,218@8857L165");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1167097770, str);
                boolean z7 = i7 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(app));
                if (i8 != 32 && ((i3 & 64) == 0 || !startRestartGroup.changedInstance(nav))) {
                    z5 = false;
                }
                boolean z8 = z7 | z5;
                Object rememberedValue14 = startRestartGroup.rememberedValue();
                if (z8 || rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue14 = new Function1() { // from class: uz.FonRo.pos.ui.home.HomeScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit HomeScreen$lambda$26$0;
                            HomeScreen$lambda$26$0 = HomeScreenKt.HomeScreen$lambda$26$0(FonRoApp.this, nav, (String) obj);
                            return HomeScreen$lambda$26$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue14);
                }
                Function1 function1 = (Function1) rememberedValue14;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1167099834, str);
                Object rememberedValue15 = startRestartGroup.rememberedValue();
                if (rememberedValue15 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue15 = new Function0() { // from class: uz.FonRo.pos.ui.home.HomeScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit HomeScreen$lambda$27$0;
                            HomeScreen$lambda$27$0 = HomeScreenKt.HomeScreen$lambda$27$0(MutableState.this);
                            return HomeScreen$lambda$27$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue15);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                NotifySheetKt.NotifySheet(list, function1, (Function0) rememberedValue15, startRestartGroup, 384);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1820394463);
                startRestartGroup.endReplaceGroup();
            }
            User HomeScreen$lambda$12 = HomeScreen$lambda$1(collectAsStateWithLifecycle2);
            Long valueOf4 = HomeScreen$lambda$12 != null ? Long.valueOf(HomeScreen$lambda$12.getId()) : null;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1167104493, str);
            boolean changedInstance5 = startRestartGroup.changedInstance(repo2) | startRestartGroup.changed(z6);
            HomeScreenKt$HomeScreen$6$1 rememberedValue16 = startRestartGroup.rememberedValue();
            if (changedInstance5 || rememberedValue16 == Composer.INSTANCE.getEmpty()) {
                rememberedValue16 = new HomeScreenKt$HomeScreen$6$1(z6, repo2, mutableState2, mutableState3, mutableState4, mutableState5, null);
                startRestartGroup.updateRememberedValue(rememberedValue16);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(valueOf4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue16, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.home.HomeScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HomeScreenKt.HomeScreen$lambda$29(FonRoApp.this, nav, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final StoreStats HomeScreen$lambda$8(MutableState<StoreStats> mutableState) {
        return mutableState.getValue();
    }

    private static final StoreStats HomeScreen$lambda$11(MutableState<StoreStats> mutableState) {
        return mutableState.getValue();
    }

    private static final double HomeScreen$lambda$14(MutableState<Double> mutableState) {
        return mutableState.getValue().doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HomeScreen$lambda$15(MutableState<Double> mutableState, double d) {
        mutableState.setValue(Double.valueOf(d));
    }

    private static final double HomeScreen$lambda$17(MutableState<Double> mutableState) {
        return mutableState.getValue().doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HomeScreen$lambda$18(MutableState<Double> mutableState, double d) {
        mutableState.setValue(Double.valueOf(d));
    }

    private static final boolean HomeScreen$lambda$20(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void HomeScreen$lambda$21(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|(1:(1:(3:10|11|12)(2:14|15))(4:16|17|18|19))(8:35|36|37|38|39|40|(1:42)|28)|20|21|22|(2:24|25)(1:26)))|49|6|(0)(0)|20|21|22|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e3, code lost:
    
        if (kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r5, r1) == r2) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object HomeScreen$load(boolean r11, uz.FonRo.pos.data.repo.Repo r12, androidx.compose.runtime.MutableState<uz.FonRo.pos.data.model.StoreStats> r13, androidx.compose.runtime.MutableState<uz.FonRo.pos.data.model.StoreStats> r14, androidx.compose.runtime.MutableState<java.lang.Double> r15, androidx.compose.runtime.MutableState<java.lang.Double> r16, kotlin.coroutines.Continuation<? super kotlin.Unit> r17) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.home.HomeScreenKt.HomeScreen$load(boolean, uz.FonRo.pos.data.repo.Repo, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult HomeScreen$lambda$24$0(final LifecycleOwner lifecycleOwner, final CoroutineScope coroutineScope, final boolean z, final Repo repo, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: uz.FonRo.pos.ui.home.HomeScreenKt$$ExternalSyntheticLambda19
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                HomeScreenKt.HomeScreen$lambda$24$0$0(CoroutineScope.this, z, repo, mutableState, mutableState2, mutableState3, mutableState4, lifecycleOwner2, event);
            }
        };
        lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        return new DisposableEffectResult() { // from class: uz.FonRo.pos.ui.home.HomeScreenKt$HomeScreen$lambda$24$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                LifecycleOwner.this.getLifecycle().removeObserver(lifecycleEventObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HomeScreen$lambda$24$0$0(CoroutineScope coroutineScope, boolean z, Repo repo, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new HomeScreenKt$HomeScreen$2$1$observer$1$1(z, repo, mutableState, mutableState2, mutableState3, mutableState4, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$25$0$0(MutableState mutableState) {
        HomeScreen$lambda$21(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$25$1$0(Repo repo, FonRoApp FonRoApp, AppNavigator appNavigator) {
        if (repo.can(Perm.MANAGE_SETTINGS)) {
            MainShellKt.openRoute(FonRoApp, appNavigator, Routes.LOG);
        } else {
            Toaster.INSTANCE.error(LangKt.tx("Журнал доступен владельцу и менеджерам", new Object[0]));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$25$2$0(FonRoApp FonRoApp, AppNavigator appNavigator) {
        MainShellKt.openRoute(FonRoApp, appNavigator, Routes.MENU);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$25$3$0(Repo repo, FonRoApp FonRoApp, AppNavigator appNavigator) {
        if (repo.can(Perm.VIEW_HISTORY)) {
            MainShellKt.openRoute(FonRoApp, appNavigator, Routes.HISTORY);
        } else {
            Toaster.INSTANCE.error(LangKt.tx("Нет доступа к истории продаж", new Object[0]));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$26$0(FonRoApp FonRoApp, AppNavigator appNavigator, String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        MainShellKt.openRoute(FonRoApp, appNavigator, route);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$27$0(MutableState mutableState) {
        HomeScreen$lambda$21(mutableState, false);
        return Unit.INSTANCE;
    }

    private static final void TopBar(final int i, final boolean z, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, Composer composer, final int i2) {
        int i3;
        String str;
        Composer startRestartGroup = composer.startRestartGroup(-126763371);
        ComposerKt.sourceInformation(startRestartGroup, "C(TopBar)P(4!1,3)237@9304L1517:HomeScreen.kt#1sln1x");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(function03) ? 16384 : 8192;
        }
        if (!startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-126763371, i3, -1, "uz.FonRo.pos.ui.home.TopBar (HomeScreen.kt:236)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
            Updater.m3815setimpl(m3808constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 423022136, "C241@9413L496,254@9918L897:HomeScreen.kt#1sln1x");
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically2, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, weight$default);
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
            Updater.m3815setimpl(m3808constructorimpl2, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2000816554, "C247@9632L39,246@9599L254,252@9866L33:HomeScreen.kt#1sln1x");
            int i4 = i3;
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.splash_logo, startRestartGroup, 0), "FonRo", ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(36.0f)), OxShape.INSTANCE.getIconChip()), (Alignment) null, ContentScale.INSTANCE.getFit(), 0.0f, (ColorFilter) null, startRestartGroup, 24624, LocationRequestCompat.QUALITY_LOW_POWER);
            TextKt.m2798Text4IGK_g("FonRo", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH1(), startRestartGroup, 6, 0, 65534);
            startRestartGroup = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(4.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            Updater.m3815setimpl(m3808constructorimpl3, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1273259588, "C255@9988L490,267@10491L149,270@10653L152:HomeScreen.kt#1sln1x");
            if (i > 99) {
                str = "99+";
            } else if (i > 0) {
                str = String.valueOf(i);
            } else {
                str = z ? "•" : null;
            }
            BasicsKt.m9831OxIconButtonhGBTI10(function0, null, str, 0.0f, ComposableSingletons$HomeScreenKt.INSTANCE.m9951getLambda$363836815$app(), startRestartGroup, ((i4 >> 6) & 14) | 24576, 10);
            BasicsKt.m9831OxIconButtonhGBTI10(function02, null, null, 0.0f, ComposableSingletons$HomeScreenKt.INSTANCE.m9952getLambda$748387686$app(), startRestartGroup, ((i4 >> 9) & 14) | 24576, 14);
            BasicsKt.m9831OxIconButtonhGBTI10(function03, null, null, 0.0f, ComposableSingletons$HomeScreenKt.INSTANCE.getLambda$433845049$app(), startRestartGroup, ((i4 >> 12) & 14) | 24576, 14);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.home.HomeScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HomeScreenKt.TopBar$lambda$1(i, z, function0, function02, function03, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x067a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x06bb  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0750  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x075c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x07c9  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x07ff  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0836  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0802  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x07cc  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0760  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x06be  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x067d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void SalesCard(final uz.FonRo.pos.FonRoApp r73, final uz.FonRo.pos.data.model.StoreStats r74, final double r75, final double r77, final boolean r79, final boolean r80, androidx.compose.runtime.Composer r81, final int r82) {
        /*
            Method dump skipped, instructions count: 2225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.home.HomeScreenKt.SalesCard(uz.FonRo.pos.FonRoApp, uz.FonRo.pos.data.model.StoreStats, double, double, boolean, boolean, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x006d  */
    /* renamed from: MiniTile-cf5BqRc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m9958MiniTilecf5BqRc(final java.lang.String r39, final java.lang.String r40, final long r41, androidx.compose.ui.Modifier r43, androidx.compose.runtime.Composer r44, final int r45, final int r46) {
        /*
            Method dump skipped, instructions count: 581
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.home.HomeScreenKt.m9958MiniTilecf5BqRc(java.lang.String, java.lang.String, long, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void QuickActions(final FonRoApp FonRoApp, final AppNavigator appNavigator, final int i, final int i2, Composer composer, final int i3) {
        int i4;
        final FonRoApp FonRoApp2;
        final AppNavigator appNavigator2;
        ScopeUpdateScope endRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        String valueOf;
        String str;
        Composer startRestartGroup = composer.startRestartGroup(-1799357372);
        ComposerKt.sourceInformation(startRestartGroup, "C(QuickActions)416@15447L29,453@17019L690:HomeScreen.kt#1sln1x");
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? startRestartGroup.changed(FonRoApp) : startRestartGroup.changedInstance(FonRoApp) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= (i3 & 64) == 0 ? startRestartGroup.changed(appNavigator) : startRestartGroup.changedInstance(appNavigator) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= startRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i4 |= startRestartGroup.changed(i2) ? 2048 : 1024;
        }
        if (!startRestartGroup.shouldExecute((i4 & 1171) != 1170, i4 & 1)) {
            FonRoApp2 = FonRoApp;
            appNavigator2 = appNavigator;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1799357372, i4, -1, "uz.FonRo.pos.ui.home.QuickActions (HomeScreen.kt:414)");
            }
            Repo repo = FonRoApp.getRepo();
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(repo.getUser(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            List createListBuilder = CollectionsKt.createListBuilder();
            if (repo.can(Perm.ONLINE_SHOP)) {
                String tx = LangKt.tx("Магазин", new Object[0]);
                ImageVector store = OxIcons.INSTANCE.getStore();
                long m10201getGreen0d7_KjU = Ox.INSTANCE.m10201getGreen0d7_KjU();
                if (i <= 0) {
                    str = null;
                } else {
                    if (i > 99) {
                        valueOf = "99+";
                    } else {
                        valueOf = String.valueOf(i);
                    }
                    str = valueOf;
                }
                createListBuilder.add(new QuickAction(tx, store, m10201getGreen0d7_KjU, "orders", str, false, 32, null));
            }
            if (repo.can(Perm.MANAGE_RETURNS)) {
                createListBuilder.add(new QuickAction(LangKt.tx("Возвраты", new Object[0]), OxIcons.INSTANCE.getUndo(), Ox.INSTANCE.m10219getPink0d7_KjU(), Routes.RETURNS, null, false, 48, null));
            }
            if (repo.can(Perm.STOCK_IN)) {
                createListBuilder.add(new QuickAction(LangKt.tx("Списание", new Object[0]), OxIcons.INSTANCE.getDelete(), Ox.INSTANCE.m10213getOrange0d7_KjU(), Routes.WRITEOFF, null, false, 48, null));
            }
            if (repo.can(Perm.MANAGE_USERS)) {
                createListBuilder.add(new QuickAction(LangKt.tx("Сотрудники", new Object[0]), OxIcons.INSTANCE.getUsers(), Ox.INSTANCE.m10208getIndigo0d7_KjU(), Routes.TEAM, null, false, 48, null));
            }
            if (repo.can(Perm.MANAGE_CUSTOMERS)) {
                createListBuilder.add(new QuickAction(LangKt.tx("Клиенты", new Object[0]), OxIcons.INSTANCE.getUser(), Ox.INSTANCE.m10192getCyan0d7_KjU(), Routes.CLIENTS, null, false, 48, null));
            }
            createListBuilder.add(new QuickAction(LangKt.tx("Штрихкоды", new Object[0]), OxIcons.INSTANCE.getPrinter(), Ox.INSTANCE.m10223getPurple0d7_KjU(), Routes.PRINT, null, false, 48, null));
            createListBuilder.add(new QuickAction(LangKt.tx("Поддержка", new Object[0]), OxIcons.INSTANCE.getChat(), Ox.INSTANCE.m10232getTeal0d7_KjU(), "support", null, i2 > 0, 16, null));
            User QuickActions$lambda$0 = QuickActions$lambda$0(collectAsStateWithLifecycle);
            if (QuickActions$lambda$0 != null && !QuickActions$lambda$0.isOwnerLike()) {
                createListBuilder.add(new QuickAction(LangKt.tx("Устройства", new Object[0]), OxIcons.INSTANCE.getPhone(), Ox.INSTANCE.m10186getBlue0d7_KjU(), Routes.MY_DEVICES, null, false, 48, null));
            }
            final List build = CollectionsKt.build(createListBuilder);
            if (build.isEmpty()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    function2 = new Function2() { // from class: uz.FonRo.pos.ui.home.HomeScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return HomeScreenKt.QuickActions$lambda$2(FonRoApp.this, appNavigator, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    endRestartGroup.updateScope(function2);
                }
                return;
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -505219698, "C454@17036L70,455@17115L11,456@17179L524,456@17135L568:HomeScreen.kt#1sln1x");
            TextKt.m2798Text4IGK_g(LangKt.tx("Быстрые действия", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH2(), 0L, TextUnitKt.getSp(15), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), startRestartGroup, 0, 0, 65534);
            startRestartGroup = startRestartGroup;
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), startRestartGroup, 6);
            FonRoApp2 = FonRoApp;
            appNavigator2 = appNavigator;
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, false, ComposableLambdaKt.rememberComposableLambda(-536516080, true, new Function3() { // from class: uz.FonRo.pos.ui.home.HomeScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit QuickActions$lambda$3$0;
                    QuickActions$lambda$3$0 = HomeScreenKt.QuickActions$lambda$3$0(build, FonRoApp2, appNavigator2, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return QuickActions$lambda$3$0;
                }
            }, startRestartGroup, 54), startRestartGroup, 3078, 6);
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
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final FonRoApp FonRoApp3 = FonRoApp2;
            final AppNavigator appNavigator3 = appNavigator2;
            function2 = new Function2() { // from class: uz.FonRo.pos.ui.home.HomeScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HomeScreenKt.QuickActions$lambda$4(FonRoApp.this, appNavigator3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            endRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuickActions$lambda$3$0(List list, final FonRoApp FonRoApp, final AppNavigator appNavigator, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation(composer, "C461@17424L21,460@17377L316:HomeScreen.kt#1sln1x");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(BoxWithConstraints) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-536516080, i2, -1, "uz.FonRo.pos.ui.home.QuickActions.<anonymous>.<anonymous> (HomeScreen.kt:459)");
            }
            float m6989constructorimpl = Dp.m6989constructorimpl(Dp.m6989constructorimpl(BoxWithConstraints.mo956getMaxWidthD9Ej5fM() - Dp.m6989constructorimpl(24.0f)) / 4.0f);
            Modifier horizontalScroll$default = ScrollKt.horizontalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, horizontalScroll$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 668582603, "C:HomeScreen.kt#1sln1x");
            composer.startReplaceGroup(-671169232);
            ComposerKt.sourceInformation(composer, "*465@17624L37,465@17595L66");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final QuickAction quickAction = (QuickAction) it.next();
                ComposerKt.sourceInformationMarkerStart(composer, 434212069, "CC(remember):HomeScreen.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(FonRoApp) | composer.changedInstance(appNavigator) | composer.changed(quickAction);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.home.HomeScreenKt$$ExternalSyntheticLambda23
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit QuickActions$lambda$3$0$0$0$0$0;
                            QuickActions$lambda$3$0$0$0$0$0 = HomeScreenKt.QuickActions$lambda$3$0$0$0$0$0(FonRoApp.this, appNavigator, quickAction);
                            return QuickActions$lambda$3$0$0$0$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                m9959QuickTilerAjV9yQ(quickAction, m6989constructorimpl, (Function0) rememberedValue, composer, 0);
            }
            composer.endReplaceGroup();
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
    public static final Unit QuickActions$lambda$3$0$0$0$0$0(FonRoApp FonRoApp, AppNavigator appNavigator, QuickAction quickAction) {
        MainShellKt.openRoute(FonRoApp, appNavigator, quickAction.getRoute());
        return Unit.INSTANCE;
    }

    /* renamed from: QuickTile-rAjV9yQ, reason: not valid java name */
    private static final void m9959QuickTilerAjV9yQ(final QuickAction quickAction, final float f, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1196604514);
        ComposerKt.sourceInformation(startRestartGroup, "C(QuickTile)P(!1,2:c#ui.unit.Dp)478@17845L2053:HomeScreen.kt#1sln1x");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(quickAction) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1196604514, i2, -1, "uz.FonRo.pos.ui.home.QuickTile (HomeScreen.kt:477)");
            }
            Modifier m1084heightInVpY3zN4$default = SizeKt.m1084heightInVpY3zN4$default(SizeKt.m1101width3ABfNKs(Modifier.INSTANCE, f), Dp.m6989constructorimpl(62.0f), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m1084heightInVpY3zN4$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1079764313, "C479@17904L1098:HomeScreen.kt#1sln1x");
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(ModifiersKt.oxClickable$default(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), OxShape.INSTANCE.getTile()), Color.m4383copywmQWz5c$default(quickAction.m9967getTint0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m6989constructorimpl(1.0f), Color.m4383copywmQWz5c$default(quickAction.m9967getTint0d7_KjU(), 0.28f, 0.0f, 0.0f, 0.0f, 14, null), OxShape.INSTANCE.getTile()), false, null, 200L, function0, 3, null), Dp.m6989constructorimpl(3.0f), Dp.m6989constructorimpl(4.0f));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m1050paddingVpY3zN4);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 90703257, "C490@18408L346,499@18767L10,500@18790L202:HomeScreen.kt#1sln1x");
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(32.0f)), OxShape.INSTANCE.getIconChip()), Ox.INSTANCE.m10206getIconChip0d7_KjU(), null, 2, null);
            Alignment center2 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m558backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 719823753, "C494@18582L158:HomeScreen.kt#1sln1x");
            IconKt.m2255Iconww6aTOc(quickAction.getIcon(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(18.0f)), Ox.INSTANCE.m10207getIconChipInk0d7_KjU(), startRestartGroup, 432, 0);
            composer2 = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(3.0f), composer2, 6);
            TextKt.m2798Text4IGK_g(quickAction.getLabel(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), 0L, TextUnitKt.getSp(11), FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer2, 0, 3120, 55294);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (quickAction.getBadge() != null) {
                composer2.startReplaceGroup(-1078673579);
                ComposerKt.sourceInformation(composer2, "507@19051L469");
                TextKt.m2798Text4IGK_g(quickAction.getBadge(), PaddingKt.m1050paddingVpY3zN4(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m1053paddingqDBjuR0$default(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd()), 0.0f, Dp.m6989constructorimpl(4.0f), Dp.m6989constructorimpl(4.0f), 0.0f, 9, null), OxShape.INSTANCE.getPill()), Ox.INSTANCE.m10196getDanger0d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.5f), Ox.INSTANCE.m10217getPanel0d7_KjU(), OxShape.INSTANCE.getPill()), Dp.m6989constructorimpl(5.0f), Dp.m6989constructorimpl(1.0f)), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getChip(), Ox.INSTANCE.m10217getPanel0d7_KjU(), TextUnitKt.getSp(11), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), composer2, 0, 0, 65532);
                composer2.endReplaceGroup();
            } else if (quickAction.getDot()) {
                composer2.startReplaceGroup(-1078180586);
                ComposerKt.sourceInformation(composer2, "519@19566L316");
                BoxKt.Box(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(PaddingKt.m1053paddingqDBjuR0$default(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd()), 0.0f, Dp.m6989constructorimpl(6.0f), Dp.m6989constructorimpl(6.0f), 0.0f, 9, null), Dp.m6989constructorimpl(9.0f)), OxShape.INSTANCE.getPill()), Ox.INSTANCE.m10196getDanger0d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.5f), Ox.INSTANCE.m10217getPanel0d7_KjU(), OxShape.INSTANCE.getPill()), composer2, 0);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1077853846);
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
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.home.HomeScreenKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HomeScreenKt.QuickTile_rAjV9yQ$lambda$1(QuickAction.this, f, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void AllSalesCta(final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-936950647);
        ComposerKt.sourceInformation(startRestartGroup, "C(AllSalesCta)534@19965L1215:HomeScreen.kt#1sln1x");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-936950647, i2, -1, "uz.FonRo.pos.ui.home.AllSalesCta (HomeScreen.kt:533)");
            }
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(ModifiersKt.oxClickable$default(BackgroundKt.background$default(ClipKt.clip(SizeKt.m1084heightInVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6989constructorimpl(78.0f), 0.0f, 2, null), OxShape.INSTANCE.getCardSoft()), Brush.Companion.m4333horizontalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m4374boximpl(Ox.INSTANCE.m10188getBlueSky0d7_KjU()), Color.m4374boximpl(Ox.INSTANCE.m10187getBlueDeep0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), false, null, 0L, function0, 7, null), Dp.m6989constructorimpl(14.0f), Dp.m6989constructorimpl(12.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(11.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m1050paddingVpY3zN4);
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
            Updater.m3815setimpl(m3808constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -440904491, "C545@20405L303,552@20717L380,562@21106L68:HomeScreen.kt#1sln1x");
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(40.0f)), OxShape.INSTANCE.getIconChip()), Color.m4383copywmQWz5c$default(Color.INSTANCE.m4421getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m558backgroundbw27NRU$default);
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
            Updater.m3815setimpl(m3808constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 513525838, "C550@20600L98:HomeScreen.kt#1sln1x");
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getCart(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(22.0f)), Color.INSTANCE.m4421getWhite0d7_KjU(), startRestartGroup, 3504, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, weight$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            Updater.m3815setimpl(m3808constructorimpl3, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2046427576, "C553@20759L158,557@20930L157:HomeScreen.kt#1sln1x");
            TextKt.m2798Text4IGK_g(LangKt.tx("ВСЕ ПРОДАННЫЕ ТОВАРЫ", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH3(), Color.INSTANCE.m4421getWhite0d7_KjU(), 0L, FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), startRestartGroup, 0, 0, 65534);
            TextKt.m2798Text4IGK_g(LangKt.tx("Смотреть все продажи и товары", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), Color.m4383copywmQWz5c$default(Color.INSTANCE.m4421getWhite0d7_KjU(), 0.85f, 0.0f, 0.0f, 0.0f, 14, null), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), startRestartGroup, 0, 0, 65534);
            startRestartGroup = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getChevron(), (String) null, (Modifier) null, Color.INSTANCE.m4421getWhite0d7_KjU(), startRestartGroup, 3120, 4);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.home.HomeScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HomeScreenKt.AllSalesCta$lambda$1(Function0.this, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x03bb, code lost:
    
        if (r13.changedInstance(r7) != false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0446, code lost:
    
        if (r13.changedInstance(r7) != false) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x04e4, code lost:
    
        if (r13.changedInstance(r3) != false) goto L187;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x04da  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04ec  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void KeyMetrics(final uz.FonRo.pos.FonRoApp r66, final uz.FonRo.pos.ui.nav.AppNavigator r67, final uz.FonRo.pos.data.model.StoreStats r68, final java.lang.Double r69, androidx.compose.runtime.Composer r70, final int r71) {
        /*
            Method dump skipped, instructions count: 1375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.home.HomeScreenKt.KeyMetrics(uz.FonRo.pos.FonRoApp, uz.FonRo.pos.ui.nav.AppNavigator, uz.FonRo.pos.data.model.StoreStats, java.lang.Double, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeyMetrics$lambda$0$0$1$0(Repo repo, FonRoApp FonRoApp, AppNavigator appNavigator) {
        if (repo.can(Perm.SELL_DEBT)) {
            MainShellKt.openRoute(FonRoApp, appNavigator, Routes.DEBTS);
        } else {
            Toaster.INSTANCE.error(LangKt.tx("Нет доступа к долгам", new Object[0]));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeyMetrics$lambda$0$0$2$0(Repo repo, FonRoApp FonRoApp, AppNavigator appNavigator) {
        if (repo.can(Perm.VIEW_HISTORY)) {
            MainShellKt.openRoute(FonRoApp, appNavigator, Routes.HISTORY);
        } else {
            Toaster.INSTANCE.error(LangKt.tx("Нет доступа к истории продаж", new Object[0]));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeyMetrics$lambda$0$0$3$0(FonRoApp FonRoApp, AppNavigator appNavigator) {
        MainShellKt.openRoute(FonRoApp, appNavigator, Routes.CATALOG);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeyMetrics$lambda$0$0$5$0(Repo repo, FonRoApp FonRoApp, AppNavigator appNavigator) {
        if (repo.can(Perm.MANAGE_EXPENSES)) {
            MainShellKt.openRoute(FonRoApp, appNavigator, Routes.EXPENSES);
        } else {
            Toaster.INSTANCE.error(LangKt.tx("Нет доступа к расходам", new Object[0]));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0093  */
    /* renamed from: MetricTile-OadGlvw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m9957MetricTileOadGlvw(final androidx.compose.ui.graphics.vector.ImageVector r63, final long r64, final java.lang.String r66, final java.lang.String r67, androidx.compose.ui.Modifier r68, final kotlin.jvm.functions.Function0<kotlin.Unit> r69, androidx.compose.runtime.Composer r70, final int r71, final int r72) {
        /*
            Method dump skipped, instructions count: 971
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.home.HomeScreenKt.m9957MetricTileOadGlvw(androidx.compose.ui.graphics.vector.ImageVector, long, java.lang.String, java.lang.String, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00fb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void WeekChart(final uz.FonRo.pos.data.model.StoreStats r98, androidx.compose.runtime.Composer r99, final int r100) {
        /*
            Method dump skipped, instructions count: 1504
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.home.HomeScreenKt.WeekChart(uz.FonRo.pos.data.model.StoreStats, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x053a  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x052e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void WeekColumn(final androidx.compose.foundation.layout.RowScope r73, final java.lang.String r74, final double r75, final double r77, androidx.compose.ui.Modifier r79, androidx.compose.runtime.Composer r80, final int r81, final int r82) {
        /*
            Method dump skipped, instructions count: 1353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.home.HomeScreenKt.WeekColumn(androidx.compose.foundation.layout.RowScope, java.lang.String, double, double, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final List<Product> HomeScreen$lambda$0(State<? extends List<Product>> state) {
        return state.getValue();
    }

    private static final User HomeScreen$lambda$1(State<User> state) {
        return state.getValue();
    }

    private static final Double HomeScreen$lambda$2(State<Double> state) {
        return state.getValue();
    }

    private static final int HomeScreen$lambda$3(State<Integer> state) {
        return state.getValue().intValue();
    }

    private static final int HomeScreen$lambda$4(State<Integer> state) {
        return state.getValue().intValue();
    }

    private static final int HomeScreen$lambda$5(State<Integer> state) {
        return state.getValue().intValue();
    }

    private static final User QuickActions$lambda$0(State<User> state) {
        return state.getValue();
    }
}
