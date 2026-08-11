package uz.FonRo.pos.ui.catalog;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.ContentScale;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.compose.SingletonAsyncImageKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.TextScaleKt;
import uz.FonRo.pos.core.Units;
import uz.FonRo.pos.data.local.CacheStore;
import uz.FonRo.pos.data.model.CatalogLangs;
import uz.FonRo.pos.data.model.GlobalCatalogCategory;
import uz.FonRo.pos.data.model.GlobalCatalogProduct;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.model.User;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnSize;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.ChipsKt;
import uz.FonRo.pos.ui.components.FieldsKt;
import uz.FonRo.pos.ui.components.ModifiersKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.PageHeadKt;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxDim;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: GlobalCatalogScreen.kt */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\b\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0006\u001aE\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0015\"\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0017X\u008a\u008e\u0002²\u0006\u0010\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u008a\u008e\u0002²\u0006\u0010\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0019X\u008a\u008e\u0002²\u0006\u0010\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u008a\u008e\u0002²\u0006\u0010\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u008a\u008e\u0002²\u0006\n\u0010\u001f\u001a\u00020\u001eX\u008a\u008e\u0002²\u0006\n\u0010 \u001a\u00020\u0017X\u008a\u008e\u0002²\u0006\n\u0010!\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010#\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010$\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\f\u0010%\u001a\u0004\u0018\u00010\u0017X\u008a\u008e\u0002²\u0006\n\u0010&\u001a\u00020\u0011X\u008a\u008e\u0002"}, d2 = {"GlobalCatalogScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "LIMIT", "", "GlobalCatalogRow", "product", "Luz/FonRo/pos/data/model/GlobalCatalogProduct;", "taken", "", "selected", "onToggle", "Lkotlin/Function0;", "(Luz/FonRo/pos/data/model/GlobalCatalogProduct;ZZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "lang", "", CacheStore.CATEGORIES, "", "Luz/FonRo/pos/data/model/GlobalCatalogCategory;", FirebaseAnalytics.Param.ITEMS, "importedIds", "", "", "categoryId", FirebaseAnalytics.Event.SEARCH, "total", "loading", "didLoad", "importing", "error", "catMenuOpen"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class GlobalCatalogScreenKt {
    private static final int LIMIT = 100;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit GlobalCatalogRow$lambda$1(GlobalCatalogProduct globalCatalogProduct, boolean z, boolean z2, Function0 function0, int i, Composer composer, int i2) {
        GlobalCatalogRow(globalCatalogProduct, z, z2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit GlobalCatalogScreen$lambda$45(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        GlobalCatalogScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit GlobalCatalogScreen$lambda$5(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        GlobalCatalogScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void GlobalCatalogScreen(final FonRoApp app, final AppNavigator nav, Composer composer, final int i) {
        final int i2;
        final FonRoApp FonRoApp;
        ScopeUpdateScope endRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        int i3;
        int i4;
        String obj;
        MutableState mutableState;
        final MutableState mutableState2;
        MutableState mutableState3;
        final CoroutineScope coroutineScope;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(nav, "nav");
        Composer startRestartGroup = composer.startRestartGroup(1847079053);
        ComposerKt.sourceInformation(startRestartGroup, "C(GlobalCatalogScreen)81@3445L24,85@3634L89,98@4260L60,99@4338L59,100@4421L42,101@4484L42,102@4549L31,103@4599L31,104@4648L30,105@4698L34,106@4752L34,107@4808L34,108@4860L42,109@4926L34,113@5121L345,154@6471L66,154@6430L107,187@7722L7732:GlobalCatalogScreen.kt#i65cod");
        int i5 = (i & 6) == 0 ? i | ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2) : i;
        if ((i & 48) == 0) {
            i5 |= (i & 64) == 0 ? startRestartGroup.changed(nav) : startRestartGroup.changedInstance(nav) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i5 & 19) != 18, i5 & 1)) {
            i2 = i;
            FonRoApp = app;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1847079053, i5, -1, "uz.FonRo.pos.ui.catalog.GlobalCatalogScreen (GlobalCatalogScreen.kt:79)");
            }
            final Repo repo = app.getRepo();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)558@25470L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -954203484, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final CoroutineScope coroutineScope2 = (CoroutineScope) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1221486054, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                String catalogLang = repo.getPrefs().getCatalogLang();
                if (StringsKt.isBlank(catalogLang)) {
                    catalogLang = CatalogLangs.INSTANCE.fromDevice();
                }
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(catalogLang, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            User value = repo.getUser().getValue();
            if (value == null) {
                i3 = 0;
            } else if (StringsKt.equals(value.getRole(), "owner", true) || value.isSuperAdmin()) {
                startRestartGroup.startReplaceGroup(-788043563);
                startRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1221506057, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                final MutableState mutableState5 = (MutableState) rememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1221508552, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                final MutableState mutableState6 = (MutableState) rememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1221511191, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(SetsKt.emptySet(), null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                final MutableState mutableState7 = (MutableState) rememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1221513207, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(SetsKt.emptySet(), null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                MutableState mutableState8 = (MutableState) rememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1221515276, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
                Object rememberedValue7 = startRestartGroup.rememberedValue();
                if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue7);
                }
                final MutableState mutableState9 = (MutableState) rememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1221516876, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
                Object rememberedValue8 = startRestartGroup.rememberedValue();
                if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue8);
                }
                final MutableState mutableState10 = (MutableState) rememberedValue8;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1221518443, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
                Object rememberedValue9 = startRestartGroup.rememberedValue();
                if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue9);
                }
                final MutableState mutableState11 = (MutableState) rememberedValue9;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1221520047, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
                Object rememberedValue10 = startRestartGroup.rememberedValue();
                if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue10);
                }
                final MutableState mutableState12 = (MutableState) rememberedValue10;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1221521775, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
                Object rememberedValue11 = startRestartGroup.rememberedValue();
                if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue11);
                }
                final MutableState mutableState13 = (MutableState) rememberedValue11;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1221523567, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
                Object rememberedValue12 = startRestartGroup.rememberedValue();
                if (rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue12);
                }
                final MutableState mutableState14 = (MutableState) rememberedValue12;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1221525239, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
                Object rememberedValue13 = startRestartGroup.rememberedValue();
                if (rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue13 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue13);
                }
                MutableState mutableState15 = (MutableState) rememberedValue13;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1221527343, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
                Object rememberedValue14 = startRestartGroup.rememberedValue();
                if (rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue14 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue14);
                }
                final MutableState mutableState16 = (MutableState) rememberedValue14;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                List<Product> value2 = repo.getProducts().getValue();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1221533894, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
                boolean changed = startRestartGroup.changed(value2);
                Object rememberedValue15 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue15 == Composer.INSTANCE.getEmpty()) {
                    Set createSetBuilder = SetsKt.createSetBuilder();
                    for (Product product : repo.getProducts().getValue()) {
                        String barcode = product.getBarcode();
                        if (barcode != null && (obj = StringsKt.trim((CharSequence) barcode).toString()) != null) {
                            String str = obj.length() > 0 ? obj : null;
                            if (str != null) {
                                Boolean.valueOf(createSetBuilder.add(str));
                            }
                        }
                        Iterator<T> it = product.getBarcodeAliases().iterator();
                        while (it.hasNext()) {
                            String obj2 = StringsKt.trim((CharSequence) it.next()).toString();
                            int i6 = i5;
                            String str2 = obj2.length() > 0 ? obj2 : null;
                            if (str2 != null) {
                                createSetBuilder.add(str2);
                                Unit unit = Unit.INSTANCE;
                                Unit unit2 = Unit.INSTANCE;
                            }
                            i5 = i6;
                        }
                    }
                    i4 = i5;
                    rememberedValue15 = SetsKt.build(createSetBuilder);
                    startRestartGroup.updateRememberedValue(rememberedValue15);
                } else {
                    i4 = i5;
                }
                final Set set = (Set) rememberedValue15;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                String GlobalCatalogScreen$lambda$22 = GlobalCatalogScreen$lambda$22(mutableState10);
                Long valueOf = Long.valueOf(GlobalCatalogScreen$lambda$19(mutableState9));
                String GlobalCatalogScreen$lambda$1 = GlobalCatalogScreen$lambda$1(mutableState4);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1221576815, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
                GlobalCatalogScreenKt$GlobalCatalogScreen$3$1 rememberedValue16 = startRestartGroup.rememberedValue();
                if (rememberedValue16 == Composer.INSTANCE.getEmpty()) {
                    GlobalCatalogScreenKt$GlobalCatalogScreen$3$1 globalCatalogScreenKt$GlobalCatalogScreen$3$1 = new GlobalCatalogScreenKt$GlobalCatalogScreen$3$1(mutableState13, mutableState12, mutableState15, mutableState6, mutableState11, mutableState4, mutableState9, mutableState10, mutableState5, mutableState7, null);
                    mutableState = mutableState15;
                    mutableState12 = mutableState12;
                    mutableState4 = mutableState4;
                    mutableState9 = mutableState9;
                    rememberedValue16 = globalCatalogScreenKt$GlobalCatalogScreen$3$1;
                    startRestartGroup.updateRememberedValue(rememberedValue16);
                } else {
                    mutableState = mutableState15;
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final MutableState mutableState17 = mutableState;
                EffectsKt.LaunchedEffect(GlobalCatalogScreen$lambda$22, valueOf, GlobalCatalogScreen$lambda$1, (Function2) rememberedValue16, startRestartGroup, 0);
                Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), OxDim.INSTANCE.m10245getPagePadD9Ej5fM(), 0.0f, 2, null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 906697291, "C191@7924L7048,188@7799L7173,341@15210L15,339@15059L389:GlobalCatalogScreen.kt#i65cod");
                Modifier weight$default = ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                PaddingValues m1046PaddingValuesa9UjIt4$default = PaddingKt.m1046PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(10.0f), 7, null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 444893695, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
                boolean changedInstance = startRestartGroup.changedInstance(repo) | startRestartGroup.changedInstance(coroutineScope2) | startRestartGroup.changedInstance(set);
                Object rememberedValue17 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue17 == Composer.INSTANCE.getEmpty()) {
                    mutableState2 = mutableState8;
                    rememberedValue17 = new Function1() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            Unit GlobalCatalogScreen$lambda$44$0$0;
                            GlobalCatalogScreen$lambda$44$0$0 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$44$0$0(Repo.this, mutableState4, mutableState12, mutableState10, mutableState5, mutableState9, mutableState16, mutableState13, mutableState17, mutableState6, coroutineScope2, mutableState11, mutableState7, set, mutableState2, (LazyListScope) obj3);
                            return GlobalCatalogScreen$lambda$44$0$0;
                        }
                    };
                    mutableState3 = mutableState4;
                    coroutineScope = coroutineScope2;
                    startRestartGroup.updateRememberedValue(rememberedValue17);
                } else {
                    coroutineScope = coroutineScope2;
                    mutableState3 = mutableState4;
                    mutableState2 = mutableState8;
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LazyDslKt.LazyColumn(weight$default, null, m1046PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) rememberedValue17, startRestartGroup, 384, TypedValues.PositionType.TYPE_PERCENT_X);
                String tx = GlobalCatalogScreen$lambda$16(mutableState2).isEmpty() ? LangKt.tx("Добавить выбранные", new Object[0]) : LangKt.tx("Добавить выбранные (%s)", Integer.valueOf(GlobalCatalogScreen$lambda$16(mutableState2).size()));
                Modifier m1051paddingVpY3zN4$default2 = PaddingKt.m1051paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(10.0f), 1, null);
                BtnStyle btnStyle = BtnStyle.PRIMARY;
                BtnSize btnSize = BtnSize.LG;
                boolean z = (GlobalCatalogScreen$lambda$16(mutableState2).isEmpty() || GlobalCatalogScreen$lambda$34(mutableState14)) ? false : true;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 445119814, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
                boolean changedInstance2 = startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(repo) | ((i4 & 112) == 32 || ((i4 & 64) != 0 && startRestartGroup.changedInstance(nav)));
                Object rememberedValue18 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue18 == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState18 = mutableState3;
                    final MutableState mutableState19 = mutableState2;
                    Function0 function0 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit GlobalCatalogScreen$lambda$44$1$0;
                            GlobalCatalogScreen$lambda$44$1$0 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$44$1$0(CoroutineScope.this, mutableState19, mutableState14, nav, mutableState18, repo);
                            return GlobalCatalogScreen$lambda$44$1$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(function0);
                    rememberedValue18 = function0;
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                BasicsKt.OxButton(tx, (Function0) rememberedValue18, m1051paddingVpY3zN4$default2, btnStyle, btnSize, z, true, null, startRestartGroup, 1600896, 128);
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
                FonRoApp = app;
                i2 = i;
            } else {
                i3 = 0;
            }
            startRestartGroup.startReplaceGroup(-788262671);
            ComposerKt.sourceInformation(startRestartGroup, "91@4018L197");
            Modifier m1051paddingVpY3zN4$default3 = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), OxDim.INSTANCE.m10245getPagePadD9Ej5fM(), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, i3);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, i3);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m1051paddingVpY3zN4$default3);
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
            Updater.m3815setimpl(m3808constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1419451773, "C92@4099L40,93@4152L53:GlobalCatalogScreen.kt#i65cod");
            PageHeadKt.OxPageHead(LangKt.tx("Каталог FonRo", new Object[i3]), null, null, false, null, startRestartGroup, 0, 30);
            BasicsKt.OxEmptyNote(LangKt.tx("Доступно только владельцу магазина", new Object[i3]), null, startRestartGroup, i3, 2);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                function2 = new Function2() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        return GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$5(FonRoApp.this, nav, i, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                };
                endRestartGroup.updateScope(function2);
            }
            return;
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            function2 = new Function2() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$45(FonRoApp.this, nav, i2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            };
            endRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String GlobalCatalogScreen$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final List<GlobalCatalogCategory> GlobalCatalogScreen$lambda$7(MutableState<List<GlobalCatalogCategory>> mutableState) {
        return mutableState.getValue();
    }

    private static final List<GlobalCatalogProduct> GlobalCatalogScreen$lambda$10(MutableState<List<GlobalCatalogProduct>> mutableState) {
        return mutableState.getValue();
    }

    private static final Set<Long> GlobalCatalogScreen$lambda$13(MutableState<Set<Long>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set<Long> GlobalCatalogScreen$lambda$16(MutableState<Set<Long>> mutableState) {
        return mutableState.getValue();
    }

    private static final long GlobalCatalogScreen$lambda$19(MutableState<Long> mutableState) {
        return mutableState.getValue().longValue();
    }

    private static final void GlobalCatalogScreen$lambda$20(MutableState<Long> mutableState, long j) {
        mutableState.setValue(Long.valueOf(j));
    }

    private static final String GlobalCatalogScreen$lambda$22(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final int GlobalCatalogScreen$lambda$25(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void GlobalCatalogScreen$lambda$26(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final boolean GlobalCatalogScreen$lambda$28(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void GlobalCatalogScreen$lambda$29(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean GlobalCatalogScreen$lambda$31(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void GlobalCatalogScreen$lambda$32(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean GlobalCatalogScreen$lambda$34(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void GlobalCatalogScreen$lambda$35(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String GlobalCatalogScreen$lambda$37(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean GlobalCatalogScreen$lambda$40(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void GlobalCatalogScreen$lambda$41(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(9:5|6|(1:(4:9|10|11|12)(2:30|31))(2:32|(2:34|35)(15:36|(1:38)|39|40|41|42|43|(1:45)(1:62)|46|47|48|49|50|51|(1:53)(1:54)))|13|14|(1:16)(1:22)|17|18|19))|68|6|(0)(0)|13|14|(0)(0)|17|18|19|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0151, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0152, code lost:
    
        r3 = r0;
        r0 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0131 A[Catch: all -> 0x0151, TryCatch #0 {all -> 0x0151, blocks: (B:14:0x010d, B:16:0x0131, B:17:0x0146, B:22:0x0136), top: B:13:0x010d }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0136 A[Catch: all -> 0x0151, TryCatch #0 {all -> 0x0151, blocks: (B:14:0x010d, B:16:0x0131, B:17:0x0146, B:22:0x0136), top: B:13:0x010d }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object GlobalCatalogScreen$load(androidx.compose.runtime.MutableState<java.lang.Boolean> r18, androidx.compose.runtime.MutableState<java.lang.String> r19, androidx.compose.runtime.MutableState<java.util.List<uz.FonRo.pos.data.model.GlobalCatalogProduct>> r20, androidx.compose.runtime.MutableState<java.lang.Integer> r21, androidx.compose.runtime.MutableState<java.lang.String> r22, androidx.compose.runtime.MutableState<java.lang.Long> r23, androidx.compose.runtime.MutableState<java.lang.String> r24, androidx.compose.runtime.MutableState<java.util.List<uz.FonRo.pos.data.model.GlobalCatalogCategory>> r25, androidx.compose.runtime.MutableState<java.util.Set<java.lang.Long>> r26, androidx.compose.runtime.MutableState<java.lang.Boolean> r27, boolean r28, kotlin.coroutines.Continuation<? super kotlin.Unit> r29) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt.GlobalCatalogScreen$load(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean GlobalCatalogScreen$isTaken(Set<String> set, MutableState<Set<Long>> mutableState, GlobalCatalogProduct globalCatalogProduct) {
        if (GlobalCatalogScreen$lambda$13(mutableState).contains(Long.valueOf(globalCatalogProduct.getId()))) {
            return true;
        }
        return StringsKt.trim((CharSequence) globalCatalogProduct.getBarcode()).toString().length() > 0 && set.contains(StringsKt.trim((CharSequence) globalCatalogProduct.getBarcode()).toString());
    }

    private static final void GlobalCatalogScreen$runImport(CoroutineScope coroutineScope, MutableState<Set<Long>> mutableState, MutableState<Boolean> mutableState2, AppNavigator appNavigator, MutableState<String> mutableState3, Repo repo) {
        if (GlobalCatalogScreen$lambda$16(mutableState).isEmpty() || GlobalCatalogScreen$lambda$34(mutableState2)) {
            return;
        }
        GlobalCatalogScreen$lambda$35(mutableState2, true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new GlobalCatalogScreenKt$GlobalCatalogScreen$runImport$1(appNavigator, mutableState, mutableState3, repo, mutableState2, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GlobalCatalogScreen$lambda$44$0$0(final Repo repo, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, final MutableState mutableState8, final MutableState mutableState9, final CoroutineScope coroutineScope, final MutableState mutableState10, final MutableState mutableState11, final Set set, final MutableState mutableState12, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$GlobalCatalogScreenKt.INSTANCE.getLambda$1242273378$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1974687947, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit GlobalCatalogScreen$lambda$44$0$0$0;
                GlobalCatalogScreen$lambda$44$0$0$0 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$44$0$0$0(Repo.this, mutableState, mutableState2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return GlobalCatalogScreen$lambda$44$0$0$0;
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1086650410, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit GlobalCatalogScreen$lambda$44$0$0$1;
                GlobalCatalogScreen$lambda$44$0$0$1 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$44$0$0$1(MutableState.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return GlobalCatalogScreen$lambda$44$0$0$1;
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(198612873, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit GlobalCatalogScreen$lambda$44$0$0$2;
                GlobalCatalogScreen$lambda$44$0$0$2 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$44$0$0$2(MutableState.this, mutableState5, mutableState2, mutableState6, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return GlobalCatalogScreen$lambda$44$0$0$2;
            }
        }), 3, null);
        if (!GlobalCatalogScreen$lambda$31(mutableState7)) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$GlobalCatalogScreenKt.INSTANCE.getLambda$628774951$app(), 3, null);
        } else if (GlobalCatalogScreen$lambda$37(mutableState8) != null && GlobalCatalogScreen$lambda$10(mutableState9).isEmpty()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(420346078, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit GlobalCatalogScreen$lambda$44$0$0$3;
                    GlobalCatalogScreen$lambda$44$0$0$3 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$44$0$0$3(CoroutineScope.this, mutableState8, mutableState2, mutableState9, mutableState10, mutableState, mutableState5, mutableState3, mutableState4, mutableState11, mutableState7, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return GlobalCatalogScreen$lambda$44$0$0$3;
                }
            }), 3, null);
        } else if (GlobalCatalogScreen$lambda$10(mutableState9).isEmpty()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1892624671, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit GlobalCatalogScreen$lambda$44$0$0$4;
                    GlobalCatalogScreen$lambda$44$0$0$4 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$44$0$0$4(MutableState.this, mutableState5, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return GlobalCatalogScreen$lambda$44$0$0$4;
                }
            }), 3, null);
        } else {
            final List<GlobalCatalogProduct> GlobalCatalogScreen$lambda$10 = GlobalCatalogScreen$lambda$10(mutableState9);
            final Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object GlobalCatalogScreen$lambda$44$0$0$5;
                    GlobalCatalogScreen$lambda$44$0$0$5 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$44$0$0$5((GlobalCatalogProduct) obj);
                    return GlobalCatalogScreen$lambda$44$0$0$5;
                }
            };
            final GlobalCatalogScreenKt$GlobalCatalogScreen$lambda$44$0$0$$inlined$items$default$1 globalCatalogScreenKt$GlobalCatalogScreen$lambda$44$0$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$GlobalCatalogScreen$lambda$44$0$0$$inlined$items$default$1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(GlobalCatalogProduct globalCatalogProduct) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((GlobalCatalogProduct) obj);
                }
            };
            LazyColumn.items(GlobalCatalogScreen$lambda$10.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$GlobalCatalogScreen$lambda$44$0$0$$inlined$items$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i) {
                    return Function1.this.invoke(GlobalCatalogScreen$lambda$10.get(i));
                }
            }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$GlobalCatalogScreen$lambda$44$0$0$$inlined$items$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i) {
                    return Function1.this.invoke(GlobalCatalogScreen$lambda$10.get(i));
                }
            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$GlobalCatalogScreen$lambda$44$0$0$$inlined$items$default$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                    int i3;
                    boolean GlobalCatalogScreen$isTaken;
                    Set GlobalCatalogScreen$lambda$16;
                    ComposerKt.sourceInformation(composer, "C178@8826L22:LazyDsl.kt#428nma");
                    if ((i2 & 6) == 0) {
                        i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                    } else {
                        i3 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        i3 |= composer.changed(i) ? 32 : 16;
                    }
                    if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                    }
                    final GlobalCatalogProduct globalCatalogProduct = (GlobalCatalogProduct) GlobalCatalogScreen$lambda$10.get(i);
                    composer.startReplaceGroup(696666256);
                    ComposerKt.sourceInformation(composer, "C*314@14142L278,310@13930L512:GlobalCatalogScreen.kt#i65cod");
                    GlobalCatalogScreen$isTaken = GlobalCatalogScreenKt.GlobalCatalogScreen$isTaken(set, mutableState11, globalCatalogProduct);
                    GlobalCatalogScreen$lambda$16 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$16(mutableState12);
                    boolean contains = GlobalCatalogScreen$lambda$16.contains(Long.valueOf(globalCatalogProduct.getId()));
                    ComposerKt.sourceInformationMarkerStart(composer, -2055730327, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
                    boolean changedInstance = composer.changedInstance(globalCatalogProduct);
                    Object rememberedValue = composer.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        final MutableState mutableState13 = mutableState12;
                        rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$GlobalCatalogScreen$4$1$1$7$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Set GlobalCatalogScreen$lambda$162;
                                Set GlobalCatalogScreen$lambda$163;
                                Set plus;
                                Set GlobalCatalogScreen$lambda$164;
                                MutableState<Set<Long>> mutableState14 = mutableState13;
                                GlobalCatalogScreen$lambda$162 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$16(mutableState14);
                                boolean contains2 = GlobalCatalogScreen$lambda$162.contains(Long.valueOf(GlobalCatalogProduct.this.getId()));
                                MutableState<Set<Long>> mutableState15 = mutableState13;
                                if (contains2) {
                                    GlobalCatalogScreen$lambda$164 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$16(mutableState15);
                                    plus = SetsKt.minus((Set<? extends Long>) GlobalCatalogScreen$lambda$164, Long.valueOf(GlobalCatalogProduct.this.getId()));
                                } else {
                                    GlobalCatalogScreen$lambda$163 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$16(mutableState15);
                                    plus = SetsKt.plus((Set<? extends Long>) GlobalCatalogScreen$lambda$163, Long.valueOf(GlobalCatalogProduct.this.getId()));
                                }
                                mutableState14.setValue(plus);
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    GlobalCatalogScreenKt.GlobalCatalogRow(globalCatalogProduct, GlobalCatalogScreen$isTaken, contains, (Function0) rememberedValue, composer, GlobalCatalogProduct.$stable);
                    composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            if (GlobalCatalogScreen$lambda$10(mutableState9).size() < GlobalCatalogScreen$lambda$25(mutableState10)) {
                LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1957271043, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit GlobalCatalogScreen$lambda$44$0$0$7;
                        GlobalCatalogScreen$lambda$44$0$0$7 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$44$0$0$7(CoroutineScope.this, mutableState10, mutableState9, mutableState2, mutableState8, mutableState, mutableState5, mutableState3, mutableState4, mutableState11, mutableState7, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return GlobalCatalogScreen$lambda$44$0$0$7;
                    }
                }), 3, null);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GlobalCatalogScreen$lambda$44$0$0$0(final Repo repo, final MutableState mutableState, final MutableState mutableState2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C202@8389L774:GlobalCatalogScreen.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1974687947, i, -1, "uz.FonRo.pos.ui.catalog.GlobalCatalogScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GlobalCatalogScreen.kt:202)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1791092375, "C203@8418L91,204@8540L605,204@8530L615:GlobalCatalogScreen.kt#i65cod");
            TextKt.m2798Text4IGK_g(LangKt.tx("Язык каталога", new Object[0]), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(6.0f), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getLabel(), composer, 48, 0, 65532);
            ChipsKt.OxChipRow(null, ComposableLambdaKt.rememberComposableLambda(2101360740, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit GlobalCatalogScreen$lambda$44$0$0$0$0$0;
                    GlobalCatalogScreen$lambda$44$0$0$0$0$0 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$44$0$0$0$0$0(Repo.this, mutableState, mutableState2, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return GlobalCatalogScreen$lambda$44$0$0$0$0$0;
                }
            }, composer, 54), composer, 48, 1);
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
    public static final Unit GlobalCatalogScreen$lambda$44$0$0$0$0$0(final Repo repo, final MutableState mutableState, final MutableState mutableState2, RowScope OxChipRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxChipRow, "$this$OxChipRow");
        ComposerKt.sourceInformation(composer, "C*209@8804L263,206@8631L466:GlobalCatalogScreen.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2101360740, i, -1, "uz.FonRo.pos.ui.catalog.GlobalCatalogScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GlobalCatalogScreen.kt:205)");
            }
            for (final String str : CatalogLangs.INSTANCE.getCODES()) {
                String title = CatalogLangs.INSTANCE.title(str);
                boolean areEqual = Intrinsics.areEqual(GlobalCatalogScreen$lambda$1(mutableState), str);
                ComposerKt.sourceInformationMarkerStart(composer, 1933317243, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
                boolean changed = composer.changed(str) | composer.changedInstance(repo);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit GlobalCatalogScreen$lambda$44$0$0$0$0$0$0$0$0;
                            GlobalCatalogScreen$lambda$44$0$0$0$0$0$0$0$0 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$44$0$0$0$0$0$0$0$0(str, repo, mutableState, mutableState2);
                            return GlobalCatalogScreen$lambda$44$0$0$0$0$0$0$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ChipsKt.m9837OxCatChipFV1VA1c(title, areEqual, (Function0) rememberedValue, null, null, null, composer, 0, 56);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GlobalCatalogScreen$lambda$44$0$0$0$0$0$0$0$0(String str, Repo repo, MutableState mutableState, MutableState mutableState2) {
        if (!Intrinsics.areEqual(GlobalCatalogScreen$lambda$1(mutableState), str) && !GlobalCatalogScreen$lambda$28(mutableState2)) {
            mutableState.setValue(str);
            repo.getPrefs().setCatalogLang(str);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GlobalCatalogScreen$lambda$44$0$0$1(final MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C224@9299L15,222@9214L257:GlobalCatalogScreen.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1086650410, i, -1, "uz.FonRo.pos.ui.catalog.GlobalCatalogScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GlobalCatalogScreen.kt:222)");
            }
            String GlobalCatalogScreen$lambda$22 = GlobalCatalogScreen$lambda$22(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 593994393, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit GlobalCatalogScreen$lambda$44$0$0$1$0$0;
                        GlobalCatalogScreen$lambda$44$0$0$1$0$0 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$44$0$0$1$0$0(MutableState.this, (String) obj);
                        return GlobalCatalogScreen$lambda$44$0$0$1$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.OxSearchBox(GlobalCatalogScreen$lambda$22, (Function1) rememberedValue, PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(10.0f), 7, null), LangKt.tx("Поиск в каталоге…", new Object[0]), null, composer, 432, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GlobalCatalogScreen$lambda$44$0$0$1$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit GlobalCatalogScreen$lambda$44$0$0$2(final androidx.compose.runtime.MutableState r36, final androidx.compose.runtime.MutableState r37, androidx.compose.runtime.MutableState r38, final androidx.compose.runtime.MutableState r39, androidx.compose.foundation.lazy.LazyItemScope r40, androidx.compose.runtime.Composer r41, int r42) {
        /*
            Method dump skipped, instructions count: 1248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$44$0$0$2(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GlobalCatalogScreen$lambda$44$0$0$2$3$0$0$0(MutableState mutableState) {
        GlobalCatalogScreen$lambda$41(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GlobalCatalogScreen$lambda$44$0$0$2$3$0$2$0(MutableState mutableState) {
        GlobalCatalogScreen$lambda$41(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GlobalCatalogScreen$lambda$44$0$0$2$3$0$3(final String str, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, ColumnScope DropdownMenu, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer, "C274@12198L776,274@12185L789:GlobalCatalogScreen.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1815650568, i, -1, "uz.FonRo.pos.ui.catalog.GlobalCatalogScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GlobalCatalogScreen.kt:274)");
            }
            TextScaleKt.OxTextScaled(ComposableLambdaKt.rememberComposableLambda(-115445115, true, new Function2() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0;
                    GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0(str, mutableState, mutableState2, mutableState3, (Composer) obj, ((Integer) obj2).intValue());
                    return GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0;
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0(final String str, final MutableState mutableState, final MutableState mutableState2, MutableState mutableState3, Composer composer, int i) {
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C276@12285L42,277@12371L40,275@12228L213,*282@12725L67,283@12840L42,281@12664L252:GlobalCatalogScreen.kt#i65cod");
        if (!composer2.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-115445115, i, -1, "uz.FonRo.pos.ui.catalog.GlobalCatalogScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GlobalCatalogScreen.kt:275)");
            }
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1631584683, true, new Function2() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0$0;
                    GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0$0 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0$0(str, (Composer) obj, ((Integer) obj2).intValue());
                    return GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0$0;
                }
            }, composer2, 54);
            ComposerKt.sourceInformationMarkerStart(composer2, 726399757, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
            Object rememberedValue = composer2.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0$1$0;
                        GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0$1$0 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0$1$0(MutableState.this, mutableState2);
                        return GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0$1$0;
                    }
                };
                composer2.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            String str2 = "CC(remember):GlobalCatalogScreen.kt#9igjgp";
            AndroidMenu_androidKt.DropdownMenuItem(rememberComposableLambda, (Function0) rememberedValue, null, null, null, false, null, null, null, composer2, 54, TypedValues.PositionType.TYPE_CURVE_FIT);
            List<GlobalCatalogCategory> GlobalCatalogScreen$lambda$7 = GlobalCatalogScreen$lambda$7(mutableState3);
            ArrayList<GlobalCatalogCategory> arrayList = new ArrayList();
            for (Object obj : GlobalCatalogScreen$lambda$7) {
                GlobalCatalogCategory globalCatalogCategory = (GlobalCatalogCategory) obj;
                if (globalCatalogCategory.getProductsCount() > 0 || globalCatalogCategory.getId() == GlobalCatalogScreen$lambda$19(mutableState2)) {
                    arrayList.add(obj);
                }
            }
            for (final GlobalCatalogCategory globalCatalogCategory2 : arrayList) {
                ComposableLambda rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-49123886, true, new Function2() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0$3$0;
                        GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0$3$0 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0$3$0(GlobalCatalogCategory.this, (Composer) obj2, ((Integer) obj3).intValue());
                        return GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0$3$0;
                    }
                }, composer2, 54);
                String str3 = str2;
                ComposerKt.sourceInformationMarkerStart(composer2, -1026338676, str3);
                boolean changedInstance = composer2.changedInstance(globalCatalogCategory2);
                Object rememberedValue2 = composer2.rememberedValue();
                if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0$3$1$0;
                            GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0$3$1$0 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0$3$1$0(GlobalCatalogCategory.this, mutableState, mutableState2);
                            return GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0$3$1$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                str2 = str3;
                AndroidMenu_androidKt.DropdownMenuItem(rememberComposableLambda2, (Function0) rememberedValue2, null, null, null, false, null, null, null, composer2, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
                composer2 = composer;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0$0(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C276@12287L38:GlobalCatalogScreen.kt#i65cod");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1631584683, i, -1, "uz.FonRo.pos.ui.catalog.GlobalCatalogScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GlobalCatalogScreen.kt:276)");
            }
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), composer, 0, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0$1$0(MutableState mutableState, MutableState mutableState2) {
        GlobalCatalogScreen$lambda$41(mutableState, false);
        GlobalCatalogScreen$lambda$20(mutableState2, 0L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0$3$0(GlobalCatalogCategory globalCatalogCategory, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C282@12727L63:GlobalCatalogScreen.kt#i65cod");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-49123886, i, -1, "uz.FonRo.pos.ui.catalog.GlobalCatalogScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GlobalCatalogScreen.kt:282)");
            }
            TextKt.m2798Text4IGK_g(globalCatalogCategory.getName() + " (" + globalCatalogCategory.getProductsCount() + ")", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), composer, 0, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GlobalCatalogScreen$lambda$44$0$0$2$3$0$3$0$3$1$0(GlobalCatalogCategory globalCatalogCategory, MutableState mutableState, MutableState mutableState2) {
        GlobalCatalogScreen$lambda$41(mutableState, false);
        GlobalCatalogScreen$lambda$20(mutableState2, globalCatalogCategory.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GlobalCatalogScreen$lambda$44$0$0$3(final CoroutineScope coroutineScope, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, final MutableState mutableState8, final MutableState mutableState9, final MutableState mutableState10, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C296@13240L289:GlobalCatalogScreen.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(420346078, i, -1, "uz.FonRo.pos.ui.catalog.GlobalCatalogScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GlobalCatalogScreen.kt:296)");
            }
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer, 48);
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
            ComposerKt.sourceInformationMarkerStart(composer, -605538487, "C297@13361L34,298@13456L31,298@13420L87:GlobalCatalogScreen.kt#i65cod");
            String GlobalCatalogScreen$lambda$37 = GlobalCatalogScreen$lambda$37(mutableState);
            if (GlobalCatalogScreen$lambda$37 == null) {
                GlobalCatalogScreen$lambda$37 = LangKt.tx("Ошибка", new Object[0]);
            }
            BasicsKt.OxEmptyNote(GlobalCatalogScreen$lambda$37, null, composer, 0, 2);
            String tx = LangKt.tx("Повторить", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, 1781584743, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(coroutineScope);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                Function0 function0 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit GlobalCatalogScreen$lambda$44$0$0$3$0$0$0;
                        GlobalCatalogScreen$lambda$44$0$0$3$0$0$0 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$44$0$0$3$0$0$0(CoroutineScope.this, mutableState2, mutableState, mutableState3, mutableState4, mutableState5, mutableState6, mutableState7, mutableState8, mutableState9, mutableState10);
                        return GlobalCatalogScreen$lambda$44$0$0$3$0$0$0;
                    }
                };
                composer.updateRememberedValue(function0);
                rememberedValue = function0;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, null, null, BtnSize.SM, false, false, null, composer, 24576, 236);
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
    public static final Unit GlobalCatalogScreen$lambda$44$0$0$3$0$0$0(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7, MutableState mutableState8, MutableState mutableState9, MutableState mutableState10) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new GlobalCatalogScreenKt$GlobalCatalogScreen$4$1$1$4$1$1$1$1(mutableState, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6, mutableState7, mutableState8, mutableState9, mutableState10, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GlobalCatalogScreen$lambda$44$0$0$4(MutableState mutableState, MutableState mutableState2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C303@13633L178:GlobalCatalogScreen.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1892624671, i, -1, "uz.FonRo.pos.ui.catalog.GlobalCatalogScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GlobalCatalogScreen.kt:303)");
            }
            BasicsKt.OxEmptyNote((StringsKt.isBlank(GlobalCatalogScreen$lambda$22(mutableState)) && GlobalCatalogScreen$lambda$19(mutableState2) == 0) ? LangKt.tx("Каталог пока пуст.", new Object[0]) : LangKt.tx("Ничего не найдено", new Object[0]), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object GlobalCatalogScreen$lambda$44$0$0$5(GlobalCatalogProduct it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GlobalCatalogScreen$lambda$44$0$0$7(final CoroutineScope coroutineScope, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, final MutableState mutableState8, final MutableState mutableState9, final MutableState mutableState10, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C328@14683L40,326@14555L353:GlobalCatalogScreen.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1957271043, i, -1, "uz.FonRo.pos.ui.catalog.GlobalCatalogScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GlobalCatalogScreen.kt:326)");
            }
            String tx = LangKt.tx("Показать ещё (%s)", Integer.valueOf(GlobalCatalogScreen$lambda$25(mutableState) - GlobalCatalogScreen$lambda$10(mutableState2).size()));
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(8.0f), 0.0f, 0.0f, 13, null);
            boolean z = !GlobalCatalogScreen$lambda$28(mutableState3);
            ComposerKt.sourceInformationMarkerStart(composer, -258198357, "CC(remember):GlobalCatalogScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(coroutineScope);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                Function0 function0 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit GlobalCatalogScreen$lambda$44$0$0$7$0$0;
                        GlobalCatalogScreen$lambda$44$0$0$7$0$0 = GlobalCatalogScreenKt.GlobalCatalogScreen$lambda$44$0$0$7$0$0(CoroutineScope.this, mutableState3, mutableState4, mutableState2, mutableState, mutableState5, mutableState6, mutableState7, mutableState8, mutableState9, mutableState10);
                        return GlobalCatalogScreen$lambda$44$0$0$7$0$0;
                    }
                };
                composer.updateRememberedValue(function0);
                rememberedValue = function0;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, m1053paddingqDBjuR0$default, null, null, z, true, null, composer, 1573248, 152);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GlobalCatalogScreen$lambda$44$0$0$7$0$0(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7, MutableState mutableState8, MutableState mutableState9, MutableState mutableState10) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new GlobalCatalogScreenKt$GlobalCatalogScreen$4$1$1$8$1$1$1(mutableState, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6, mutableState7, mutableState8, mutableState9, mutableState10, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GlobalCatalogScreen$lambda$44$1$0(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, AppNavigator appNavigator, MutableState mutableState3, Repo repo) {
        GlobalCatalogScreen$runImport(coroutineScope, mutableState, mutableState2, appNavigator, mutableState3, repo);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void GlobalCatalogRow(final GlobalCatalogProduct globalCatalogProduct, final boolean z, final boolean z2, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1532805082);
        ComposerKt.sourceInformation(startRestartGroup, "C(GlobalCatalogRow)P(1,3,2)364@15754L43,360@15642L2349:GlobalCatalogScreen.kt#i65cod");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(globalCatalogProduct) : startRestartGroup.changedInstance(globalCatalogProduct) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if (!startRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1532805082, i2, -1, "uz.FonRo.pos.ui.catalog.GlobalCatalogRow (GlobalCatalogScreen.kt:359)");
            }
            Modifier oxTap = ModifiersKt.oxTap(PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(4.0f), 1, null), !z, function0, startRestartGroup, ((i2 >> 3) & 896) | 6, 0);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, oxTap);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1570424193, "C368@15939L546,368@15931L554,385@16495L938:GlobalCatalogScreen.kt#i65cod");
            BasicsKt.m9834OxThumbPZHvWI(null, 0.0f, 0L, ComposableLambdaKt.rememberComposableLambda(1978734438, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit GlobalCatalogRow$lambda$0$0;
                    GlobalCatalogRow$lambda$0$0 = GlobalCatalogScreenKt.GlobalCatalogRow$lambda$0$0(GlobalCatalogProduct.this, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return GlobalCatalogRow$lambda$0$0;
                }
            }, startRestartGroup, 54), startRestartGroup, 3072, 7);
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1503442397, "C389@16739L187,394@16939L484:GlobalCatalogScreen.kt#i65cod");
            String name = globalCatalogProduct.getName();
            TextStyle m6448copyp1EtxEg$default = TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getLabel(), 0L, TextUnitKt.getSp(12.5d), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(16), null, null, null, 0, 0, null, 16646141, null);
            Ox ox = Ox.INSTANCE;
            TextKt.m2798Text4IGK_g(name, (Modifier) null, z ? ox.m10199getDim0d7_KjU() : ox.m10233getText0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, m6448copyp1EtxEg$default, startRestartGroup, 0, 0, 65530);
            Composer composer2 = startRestartGroup;
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(6.0f));
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), composer2, 6);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, companion);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            Updater.m3815setimpl(m3808constructorimpl3, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -445111777, "C403@17355L54:GlobalCatalogScreen.kt#i65cod");
            if (!StringsKt.isBlank(globalCatalogProduct.getBarcode())) {
                composer2.startReplaceGroup(-445060721);
                ComposerKt.sourceInformation(composer2, "396@17069L251");
                TextKt.m2798Text4IGK_g(globalCatalogProduct.getBarcode(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), 0L, 0L, null, null, null, FontFamily.INSTANCE.getMonospace(), null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777183, null), composer2, 0, 3120, 55294);
                composer2 = composer2;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-444801654);
                composer2.endReplaceGroup();
            }
            Composer composer3 = composer2;
            TextKt.m2798Text4IGK_g(Units.INSTANCE.name(globalCatalogProduct.getUnit()), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer3, 0, 0, 65534);
            startRestartGroup = composer3;
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
            if (z) {
                startRestartGroup.startReplaceGroup(-1568974944);
                ComposerKt.sourceInformation(startRestartGroup, "408@17468L44");
                TextKt.m2798Text4IGK_g(LangKt.tx("уже есть", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), startRestartGroup, 0, 0, 65534);
                startRestartGroup = startRestartGroup;
                startRestartGroup.endReplaceGroup();
            } else if (z2) {
                startRestartGroup.startReplaceGroup(-1568871435);
                ComposerKt.sourceInformation(startRestartGroup, "410@17556L143");
                IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getOk(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(26.0f)), Ox.INSTANCE.m10202getGreenDeep0d7_KjU(), startRestartGroup, 432, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1568709770);
                ComposerKt.sourceInformation(startRestartGroup, "416@17800L175");
                BoxKt.Box(BorderKt.m569borderxT4_qwU(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(24.0f)), OxShape.INSTANCE.getPill()), Dp.m6989constructorimpl(2.0f), Ox.INSTANCE.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getPill()), startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            }
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.GlobalCatalogScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GlobalCatalogScreenKt.GlobalCatalogRow$lambda$1(GlobalCatalogProduct.this, z, z2, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GlobalCatalogRow$lambda$0$0(GlobalCatalogProduct globalCatalogProduct, BoxScope OxThumb, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxThumb, "$this$OxThumb");
        ComposerKt.sourceInformation(composer, "C:GlobalCatalogScreen.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1978734438, i, -1, "uz.FonRo.pos.ui.catalog.GlobalCatalogRow.<anonymous>.<anonymous> (GlobalCatalogScreen.kt:369)");
            }
            String imageUrl = globalCatalogProduct.getImageUrl();
            if (imageUrl != null && !StringsKt.isBlank(imageUrl)) {
                composer.startReplaceGroup(51624737);
                ComposerKt.sourceInformation(composer, "371@16053L219");
                SingletonAsyncImageKt.m7640AsyncImagegl8XCv8(imageUrl, null, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, false, null, composer, 1573296, 0, 4024);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(51877573);
                ComposerKt.sourceInformation(composer, "378@16310L151");
                IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getBox(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(22.0f)), Ox.INSTANCE.m10200getDim20d7_KjU(), composer, 432, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
