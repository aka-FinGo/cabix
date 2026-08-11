package uz.FonRo.pos.ui.docs;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.material3.MenuKt;
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
import androidx.compose.runtime.State;
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
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
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
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.data.model.StockInDoc;
import uz.FonRo.pos.data.model.Supplier;
import uz.FonRo.pos.data.model.SyncData;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnSize;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.ChipTone;
import uz.FonRo.pos.ui.components.FieldsKt;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.nav.Routes;
import uz.FonRo.pos.ui.shell.MainShellKt;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxDim;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: SuppliersScreen.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a/\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007b\u0002\b\rb\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\f\u001aO\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0003b\u0002\b\rb\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\u0018\u001a]\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0003b\u0002\b\rb\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\u001e\u001a5\u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0003b\u0002\b\rb\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010 ¨\u0006\b²\u0006\u0010\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bX\u008a\u0084\u0002²\u0006\f\u0010\"\u001a\u0004\u0018\u00010#X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010%\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\f\u0010&\u001a\u0004\u0018\u00010\u0003X\u008a\u008e\u0002²\u0006\n\u0010'\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010(\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010)\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010*\u001a\u00020\u0001X\u008a\u008e\u0002"}, d2 = {"supplierMatches", "", "supplier", "Luz/FonRo/pos/data/model/Supplier;", SearchIntents.EXTRA_QUERY, "", "SuppliersScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "SupplierCard", "stat", "Luz/FonRo/pos/ui/docs/SupplierStat;", FirebaseAnalytics.Param.CURRENCY, "canPurchase", "onClick", "Lkotlin/Function0;", "(Luz/FonRo/pos/data/model/Supplier;Luz/FonRo/pos/ui/docs/SupplierStat;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SupplierDetailSheet", "docs", "", "Luz/FonRo/pos/data/model/StockInDoc;", "onDismiss", "(Luz/FonRo/pos/data/model/Supplier;Luz/FonRo/pos/ui/docs/SupplierStat;ZLjava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SupplierFormSheet", "(Luz/FonRo/pos/FonRoApp;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", Routes.SUPPLIERS, "sync", "Luz/FonRo/pos/data/model/SyncData;", FirebaseAnalytics.Event.SEARCH, "formOpen", "detail", "name", HintConstants.AUTOFILL_HINT_PHONE, "note", "busy"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class SuppliersScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SupplierCard$lambda$2(Supplier supplier, SupplierStat supplierStat, String str, boolean z, Function0 function0, int i, Composer composer, int i2) {
        SupplierCard(supplier, supplierStat, str, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SupplierDetailSheet$lambda$2(Supplier supplier, SupplierStat supplierStat, boolean z, List list, String str, Function0 function0, int i, Composer composer, int i2) {
        SupplierDetailSheet(supplier, supplierStat, z, list, str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SupplierFormSheet$lambda$14(FonRoApp FonRoApp, Function0 function0, int i, Composer composer, int i2) {
        SupplierFormSheet(FonRoApp, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SuppliersScreen$lambda$18(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        SuppliersScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final boolean supplierMatches(Supplier supplier, String str) {
        String lowerCase = StringsKt.trim((CharSequence) str).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str2 = lowerCase;
        if (str2.length() == 0) {
            return true;
        }
        String lowerCase2 = supplier.getName().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) str2, false, 2, (Object) null)) {
            return true;
        }
        String phone = supplier.getPhone();
        if (phone != null) {
            String lowerCase3 = phone.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
            if (lowerCase3 != null && StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) str2, false, 2, (Object) null)) {
                return true;
            }
        }
        String note = supplier.getNote();
        if (note != null) {
            String lowerCase4 = note.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
            if (lowerCase4 != null && StringsKt.contains$default((CharSequence) lowerCase4, (CharSequence) str2, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public static final void SuppliersScreen(final FonRoApp app, final AppNavigator nav, Composer composer, final int i) {
        final FonRoApp FonRoApp;
        Composer composer2;
        List<StockInDoc> emptyList;
        MutableState mutableState;
        MutableState mutableState2;
        MutableState mutableState3;
        Iterator it;
        MutableState mutableState4;
        MutableState mutableState5;
        MutableState mutableState6;
        Object obj;
        int i2;
        Modifier modifier;
        String str;
        Composer composer3;
        boolean z;
        String str2;
        List<StockInDoc> emptyList2;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(nav, "nav");
        Composer startRestartGroup = composer.startRestartGroup(1135929909);
        ComposerKt.sourceInformation(startRestartGroup, "C(SuppliersScreen)89@3721L29,90@3777L29,95@3907L31,96@3959L34,97@4012L44,99@4083L52,99@4062L73,105@4214L502,119@4736L125,127@5078L4716,124@4926L4868:SuppliersScreen.kt#1so789");
        int i3 = (i & 6) == 0 ? i | ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2) : i;
        if ((i & 48) == 0) {
            i3 |= (i & 64) == 0 ? startRestartGroup.changed(nav) : startRestartGroup.changedInstance(nav) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            FonRoApp = app;
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1135929909, i3, -1, "uz.FonRo.pos.ui.docs.SuppliersScreen (SuppliersScreen.kt:87)");
            }
            Repo repo = app.getRepo();
            final State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(repo.getSuppliers(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            State collectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(repo.getSync(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            final String currency = repo.currency();
            final boolean can = repo.can(Perm.STOCK_IN);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 706959092, "CC(remember):SuppliersScreen.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState7 = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 706960759, "CC(remember):SuppliersScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState8 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 706962465, "CC(remember):SuppliersScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            int i4 = i3;
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            MutableState mutableState9 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 706964745, "CC(remember):SuppliersScreen.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(repo);
            SuppliersScreenKt$SuppliersScreen$1$1 rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new SuppliersScreenKt$SuppliersScreen$1$1(repo, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue4, startRestartGroup, 6);
            final boolean can2 = repo.can(Perm.VIEW_PURCHASE_PRICE);
            SyncData SuppliersScreen$lambda$1 = SuppliersScreen$lambda$1(collectAsStateWithLifecycle2);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 706969387, "CC(remember):SuppliersScreen.kt#9igjgp");
            boolean changed = startRestartGroup.changed(SuppliersScreen$lambda$1);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                HashMap hashMap = new HashMap();
                SyncData SuppliersScreen$lambda$12 = SuppliersScreen$lambda$1(collectAsStateWithLifecycle2);
                if (SuppliersScreen$lambda$12 == null || (emptyList = SuppliersScreen$lambda$12.getStockIn()) == null) {
                    emptyList = CollectionsKt.emptyList();
                }
                Iterator it2 = emptyList.iterator();
                while (it2.hasNext()) {
                    StockInDoc stockInDoc = (StockInDoc) it2.next();
                    if (stockInDoc.getSupplierId() != 0) {
                        it = it2;
                        SupplierStat supplierStat = (SupplierStat) hashMap.get(Long.valueOf(stockInDoc.getSupplierId()));
                        mutableState4 = mutableState8;
                        mutableState5 = mutableState9;
                        mutableState6 = mutableState7;
                        hashMap.put(Long.valueOf(stockInDoc.getSupplierId()), new SupplierStat((supplierStat != null ? supplierStat.getCount() : 0) + 1, (supplierStat != null ? supplierStat.getTotal() : 0.0d) + StockInScreenKt.docTotal(stockInDoc)));
                    } else {
                        it = it2;
                        mutableState4 = mutableState8;
                        mutableState5 = mutableState9;
                        mutableState6 = mutableState7;
                    }
                    it2 = it;
                    mutableState8 = mutableState4;
                    mutableState7 = mutableState6;
                    mutableState9 = mutableState5;
                }
                mutableState = mutableState8;
                mutableState2 = mutableState9;
                mutableState3 = mutableState7;
                startRestartGroup.updateRememberedValue(hashMap);
                obj = hashMap;
            } else {
                mutableState = mutableState8;
                mutableState2 = mutableState9;
                mutableState3 = mutableState7;
                obj = rememberedValue5;
            }
            final HashMap hashMap2 = (HashMap) obj;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            List<Supplier> SuppliersScreen$lambda$0 = SuppliersScreen$lambda$0(collectAsStateWithLifecycle);
            String SuppliersScreen$lambda$3 = SuppliersScreen$lambda$3(mutableState3);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 706985714, "CC(remember):SuppliersScreen.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(SuppliersScreen$lambda$0) | startRestartGroup.changed(SuppliersScreen$lambda$3);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                List<Supplier> SuppliersScreen$lambda$02 = SuppliersScreen$lambda$0(collectAsStateWithLifecycle);
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : SuppliersScreen$lambda$02) {
                    if (supplierMatches((Supplier) obj2, SuppliersScreen$lambda$3(mutableState3))) {
                        arrayList.add(obj2);
                    }
                }
                rememberedValue6 = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$SuppliersScreen$lambda$13$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        String lowerCase = ((Supplier) t).getName().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        String lowerCase2 = ((Supplier) t2).getName().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final List list = (List) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Collection values = hashMap2.values();
            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
            Iterator it3 = values.iterator();
            double d = 0.0d;
            while (it3.hasNext()) {
                d += ((SupplierStat) it3.next()).getTotal();
            }
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), OxDim.INSTANCE.m10245getPagePadD9Ej5fM(), 0.0f, 2, null);
            PaddingValues m1046PaddingValuesa9UjIt4$default = PaddingKt.m1046PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(30.0f), 7, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 707001249, "CC(remember):SuppliersScreen.kt#9igjgp");
            int i5 = i4 & 14;
            boolean changed3 = startRestartGroup.changed(can2) | startRestartGroup.changed(d) | startRestartGroup.changed(currency) | startRestartGroup.changed(collectAsStateWithLifecycle) | startRestartGroup.changedInstance(hashMap2) | startRestartGroup.changed(can) | (i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(app))) | ((i4 & 112) == 32 || ((i4 & 64) != 0 && startRestartGroup.changedInstance(nav))) | startRestartGroup.changedInstance(list);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                i2 = i5;
                final double d2 = d;
                modifier = m1051paddingVpY3zN4$default;
                final MutableState mutableState10 = mutableState2;
                str = "CC(remember):SuppliersScreen.kt#9igjgp";
                composer3 = startRestartGroup;
                final MutableState mutableState11 = mutableState;
                final MutableState mutableState12 = mutableState3;
                Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        Unit SuppliersScreen$lambda$15$0;
                        SuppliersScreen$lambda$15$0 = SuppliersScreenKt.SuppliersScreen$lambda$15$0(list, can2, d2, currency, can, app, nav, collectAsStateWithLifecycle, hashMap2, mutableState11, mutableState12, mutableState10, (LazyListScope) obj3);
                        return SuppliersScreen$lambda$15$0;
                    }
                };
                z = can2;
                str2 = currency;
                composer3.updateRememberedValue(function1);
                rememberedValue7 = function1;
            } else {
                i2 = i5;
                z = can2;
                composer3 = startRestartGroup;
                str2 = currency;
                modifier = m1051paddingVpY3zN4$default;
                str = "CC(remember):SuppliersScreen.kt#9igjgp";
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            FonRoApp = app;
            Composer composer4 = composer3;
            LazyDslKt.LazyColumn(modifier, null, m1046PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) rememberedValue7, composer4, 384, TypedValues.PositionType.TYPE_PERCENT_X);
            if (SuppliersScreen$lambda$6(mutableState)) {
                composer4.startReplaceGroup(446756575);
                ComposerKt.sourceInformation(composer4, "244@9865L20,244@9824L62");
                ComposerKt.sourceInformationMarkerStart(composer4, 707149737, str);
                Object rememberedValue8 = composer4.rememberedValue();
                if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState13 = mutableState;
                    rememberedValue8 = new Function0() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SuppliersScreen$lambda$16$0;
                            SuppliersScreen$lambda$16$0 = SuppliersScreenKt.SuppliersScreen$lambda$16$0(MutableState.this);
                            return SuppliersScreen$lambda$16$0;
                        }
                    };
                    composer4.updateRememberedValue(rememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composer4);
                SupplierFormSheet(FonRoApp, (Function0) rememberedValue8, composer4, FonRoApp.$stable | 48 | i2);
                composer4.endReplaceGroup();
            } else {
                composer4.startReplaceGroup(446831533);
                composer4.endReplaceGroup();
            }
            Supplier SuppliersScreen$lambda$9 = SuppliersScreen$lambda$9(mutableState2);
            if (SuppliersScreen$lambda$9 != null) {
                composer4.startReplaceGroup(446858193);
                ComposerKt.sourceInformation(composer4, "*256@10285L17,248@9932L380");
                SupplierStat supplierStat2 = (SupplierStat) hashMap2.get(Long.valueOf(SuppliersScreen$lambda$9.getId()));
                SyncData SuppliersScreen$lambda$13 = SuppliersScreen$lambda$1(collectAsStateWithLifecycle2);
                if (SuppliersScreen$lambda$13 == null || (emptyList2 = SuppliersScreen$lambda$13.getStockIn()) == null) {
                    emptyList2 = CollectionsKt.emptyList();
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj3 : emptyList2) {
                    if (((StockInDoc) obj3).getSupplierId() == SuppliersScreen$lambda$9.getId()) {
                        arrayList2.add(obj3);
                    }
                }
                List sortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$SuppliersScreen$lambda$17$$inlined$sortedByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((StockInDoc) t2).getCreatedAt(), ((StockInDoc) t).getCreatedAt());
                    }
                });
                ComposerKt.sourceInformationMarkerStart(composer4, 2081589411, str);
                Object rememberedValue9 = composer4.rememberedValue();
                if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState14 = mutableState2;
                    rememberedValue9 = new Function0() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SuppliersScreen$lambda$17$2$0;
                            SuppliersScreen$lambda$17$2$0 = SuppliersScreenKt.SuppliersScreen$lambda$17$2$0(MutableState.this);
                            return SuppliersScreen$lambda$17$2$0;
                        }
                    };
                    composer4.updateRememberedValue(rememberedValue9);
                }
                ComposerKt.sourceInformationMarkerEnd(composer4);
                SupplierDetailSheet(SuppliersScreen$lambda$9, supplierStat2, z, sortedWith, str2, (Function0) rememberedValue9, composer4, Supplier.$stable | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                composer2 = composer4;
                Unit unit2 = Unit.INSTANCE;
                composer2.endReplaceGroup();
                Unit unit3 = Unit.INSTANCE;
            } else {
                composer4.startReplaceGroup(446858192);
                composer4.endReplaceGroup();
                composer2 = composer4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    return SuppliersScreenKt.SuppliersScreen$lambda$18(FonRoApp.this, nav, i, (Composer) obj4, ((Integer) obj5).intValue());
                }
            });
        }
    }

    private static final String SuppliersScreen$lambda$3(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean SuppliersScreen$lambda$6(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void SuppliersScreen$lambda$7(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Supplier SuppliersScreen$lambda$9(MutableState<Supplier> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SuppliersScreen$lambda$15$0(final List list, final boolean z, final double d, final String str, final boolean z2, final FonRoApp FonRoApp, final AppNavigator appNavigator, final State state, final HashMap hashMap, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, LazyListScope LazyColumn) {
        LazyListScope lazyListScope;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, "head", null, ComposableSingletons$SuppliersScreenKt.INSTANCE.m9886getLambda$1264896886$app(), 2, null);
        LazyListScope.item$default(LazyColumn, "hero", null, ComposableLambdaKt.composableLambdaInstance(-652413119, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit SuppliersScreen$lambda$15$0$0;
                SuppliersScreen$lambda$15$0$0 = SuppliersScreenKt.SuppliersScreen$lambda$15$0$0(z, d, str, z2, FonRoApp, appNavigator, state, hashMap, mutableState, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return SuppliersScreen$lambda$15$0$0;
            }
        }), 2, null);
        LazyListScope.item$default(LazyColumn, FirebaseAnalytics.Event.SEARCH, null, ComposableLambdaKt.composableLambdaInstance(-479999038, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit SuppliersScreen$lambda$15$0$1;
                SuppliersScreen$lambda$15$0$1 = SuppliersScreenKt.SuppliersScreen$lambda$15$0$1(MutableState.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return SuppliersScreen$lambda$15$0$1;
            }
        }), 2, null);
        LazyListScope.item$default(LazyColumn, "list-head", null, ComposableLambdaKt.composableLambdaInstance(-307584957, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit SuppliersScreen$lambda$15$0$2;
                SuppliersScreen$lambda$15$0$2 = SuppliersScreenKt.SuppliersScreen$lambda$15$0$2(list, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return SuppliersScreen$lambda$15$0$2;
            }
        }), 2, null);
        if (list.isEmpty()) {
            lazyListScope = LazyColumn;
            LazyListScope.item$default(lazyListScope, "list-empty", null, ComposableLambdaKt.composableLambdaInstance(-1716976795, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SuppliersScreen$lambda$15$0$3;
                    SuppliersScreen$lambda$15$0$3 = SuppliersScreenKt.SuppliersScreen$lambda$15$0$3(State.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SuppliersScreen$lambda$15$0$3;
                }
            }), 2, null);
        } else {
            lazyListScope = LazyColumn;
        }
        final Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object SuppliersScreen$lambda$15$0$4;
                SuppliersScreen$lambda$15$0$4 = SuppliersScreenKt.SuppliersScreen$lambda$15$0$4((Supplier) obj);
                return SuppliersScreen$lambda$15$0$4;
            }
        };
        final SuppliersScreenKt$SuppliersScreen$lambda$15$0$$inlined$items$default$1 suppliersScreenKt$SuppliersScreen$lambda$15$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$SuppliersScreen$lambda$15$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Supplier supplier) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Supplier) obj);
            }
        };
        lazyListScope.items(list.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$SuppliersScreen$lambda$15$0$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(list.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$SuppliersScreen$lambda$15$0$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$SuppliersScreen$lambda$15$0$$inlined$items$default$4
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
                final Supplier supplier = (Supplier) list.get(i);
                composer.startReplaceGroup(-2106635859);
                ComposerKt.sourceInformation(composer, "C*238@9743L21,233@9540L238:SuppliersScreen.kt#1so789");
                SupplierStat supplierStat = (SupplierStat) hashMap.get(Long.valueOf(supplier.getId()));
                String str2 = str;
                boolean z3 = z;
                ComposerKt.sourceInformationMarkerStart(composer, 1594618269, "CC(remember):SuppliersScreen.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(supplier);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState4 = mutableState3;
                    rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$SuppliersScreen$2$1$6$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            mutableState4.setValue(Supplier.this);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                SuppliersScreenKt.SupplierCard(supplier, supplierStat, str2, z3, (Function0) rememberedValue, composer, Supplier.$stable);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SuppliersScreen$lambda$15$0$0(final boolean z, final double d, final String str, final boolean z2, final FonRoApp FonRoApp, final AppNavigator appNavigator, final State state, final HashMap hashMap, final MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C142@5686L2904,136@5417L3173:SuppliersScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-652413119, i, -1, "uz.FonRo.pos.ui.docs.SuppliersScreen.<anonymous>.<anonymous>.<anonymous> (SuppliersScreen.kt:136)");
            }
            BasicsKt.m9833OxSoftCardCe4qNIY(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null), Dp.m6989constructorimpl(14.0f), OxShape.INSTANCE.getHero(), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10201getGreen0d7_KjU(), 0.1f), Ox.INSTANCE.m10242tintBorderl2rxGTc(Ox.INSTANCE.m10201getGreen0d7_KjU()), null, ComposableLambdaKt.rememberComposableLambda(1177452871, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SuppliersScreen$lambda$15$0$0$0;
                    SuppliersScreen$lambda$15$0$0$0 = SuppliersScreenKt.SuppliersScreen$lambda$15$0$0$0(z, d, str, z2, FonRoApp, appNavigator, state, hashMap, mutableState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SuppliersScreen$lambda$15$0$0$0;
                }
            }, composer, 54), composer, 1572918, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SuppliersScreen$lambda$15$0$0$0(boolean z, double d, String str, boolean z2, final FonRoApp FonRoApp, final AppNavigator appNavigator, State state, HashMap hashMap, final MutableState mutableState, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C143@5704L407,154@6361L334,161@6712L394:SuppliersScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1177452871, i, -1, "uz.FonRo.pos.ui.docs.SuppliersScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SuppliersScreen.kt:143)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1094591190, "C144@5803L232,149@6056L37:SuppliersScreen.kt#1so789");
            TextKt.m2798Text4IGK_g(z ? LangKt.tx("Оборот по приходам", new Object[0]) : LangKt.tx("Поставщиков в справочнике", new Object[0]), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getLabel(), composer, 0, 0, 65532);
            BasicsKt.OxChip(LangKt.tx("Справочник", new Object[0]), ChipTone.OK, null, composer, 48, 4);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m2798Text4IGK_g(z ? Fmt.INSTANCE.money(Double.valueOf(d), str) : String.valueOf(SuppliersScreen$lambda$0(state).size()), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(6.0f), 0.0f, Dp.m6989constructorimpl(12.0f), 5, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getAmount(), composer, 48, 3120, 55292);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, fillMaxWidth$default2);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1691452336, "C162@6815L71,163@6907L181:SuppliersScreen.kt#1so789");
            StockInScreenKt.m9919DocMiniStatuDo3WH8(rowScopeInstance2, String.valueOf(SuppliersScreen$lambda$0(state).size()), LangKt.tx("Поставщиков", new Object[0]), Ox.INSTANCE.m10202getGreenDeep0d7_KjU(), null, composer, 6, 8);
            Collection values = hashMap.values();
            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
            Iterator it = values.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                i2 += ((SupplierStat) it.next()).getCount();
            }
            StockInScreenKt.m9919DocMiniStatuDo3WH8(rowScopeInstance2, String.valueOf(i2), LangKt.tx("Приходов", new Object[0]), Ox.INSTANCE.m10193getCyanDeep0d7_KjU(), null, composer, 6, 8);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (z2) {
                composer.startReplaceGroup(502059454);
                ComposerKt.sourceInformation(composer, "170@7161L11,173@7278L19,171@7193L520,184@7734L10,190@8074L48,188@7990L568");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
                String tx = LangKt.tx("Добавить поставщика", new Object[0]);
                BtnStyle btnStyle = BtnStyle.PRIMARY;
                BtnSize btnSize = BtnSize.LG;
                ComposerKt.sourceInformationMarkerStart(composer, 1955861146, "CC(remember):SuppliersScreen.kt#9igjgp");
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SuppliersScreen$lambda$15$0$0$0$2$0;
                            SuppliersScreen$lambda$15$0$0$0$2$0 = SuppliersScreenKt.SuppliersScreen$lambda$15$0$0$0$2$0(MutableState.this);
                            return SuppliersScreen$lambda$15$0$0$0$2$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                BasicsKt.OxButton(tx, (Function0) rememberedValue, null, btnStyle, btnSize, false, true, ComposableSingletons$SuppliersScreenKt.INSTANCE.getLambda$1739393649$app(), composer, 14183472, 36);
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer, 6);
                String tx2 = LangKt.tx("Возврат поставщику", new Object[0]);
                BtnStyle btnStyle2 = BtnStyle.PLAIN;
                BtnSize btnSize2 = BtnSize.LG;
                ComposerKt.sourceInformationMarkerStart(composer, 1955886647, "CC(remember):SuppliersScreen.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(FonRoApp) | composer.changedInstance(appNavigator);
                Object rememberedValue2 = composer.rememberedValue();
                if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SuppliersScreen$lambda$15$0$0$0$3$0;
                            SuppliersScreen$lambda$15$0$0$0$3$0 = SuppliersScreenKt.SuppliersScreen$lambda$15$0$0$0$3$0(FonRoApp.this, appNavigator);
                            return SuppliersScreen$lambda$15$0$0$0$3$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                BasicsKt.OxButton(tx2, (Function0) rememberedValue2, null, btnStyle2, btnSize2, false, true, ComposableSingletons$SuppliersScreenKt.INSTANCE.getLambda$1907929256$app(), composer, 14183424, 36);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(503440411);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SuppliersScreen$lambda$15$0$0$0$2$0(MutableState mutableState) {
        SuppliersScreen$lambda$7(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SuppliersScreen$lambda$15$0$0$0$3$0(FonRoApp FonRoApp, AppNavigator appNavigator) {
        MainShellKt.openRoute(FonRoApp, appNavigator, Routes.SUPPLIER_RETURNS);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SuppliersScreen$lambda$15$0$1(final MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C208@8716L15,206@8639L244:SuppliersScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-479999038, i, -1, "uz.FonRo.pos.ui.docs.SuppliersScreen.<anonymous>.<anonymous>.<anonymous> (SuppliersScreen.kt:206)");
            }
            String SuppliersScreen$lambda$3 = SuppliersScreen$lambda$3(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, -1717571919, "CC(remember):SuppliersScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SuppliersScreen$lambda$15$0$1$0$0;
                        SuppliersScreen$lambda$15$0$1$0$0 = SuppliersScreenKt.SuppliersScreen$lambda$15$0$1$0$0(MutableState.this, (String) obj);
                        return SuppliersScreen$lambda$15$0$1$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.OxSearchBox(SuppliersScreen$lambda$3, (Function1) rememberedValue, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null), LangKt.tx("Поиск по названию, телефону или заметке", new Object[0]), null, composer, 432, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SuppliersScreen$lambda$15$0$1$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SuppliersScreen$lambda$15$0$2(List list, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C215@8935L233:SuppliersScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-307584957, i, -1, "uz.FonRo.pos.ui.docs.SuppliersScreen.<anonymous>.<anonymous>.<anonymous> (SuppliersScreen.kt:215)");
            }
            BasicsKt.OxSectionHead(LangKt.tx("Список поставщиков", new Object[0]), null, LangKt.tx("Поставщики и оборот по приходам", new Object[0]), String.valueOf(list.size()), ChipTone.OK, null, composer, 24576, 34);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SuppliersScreen$lambda$15$0$3(State state, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C225@9262L172:SuppliersScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1716976795, i, -1, "uz.FonRo.pos.ui.docs.SuppliersScreen.<anonymous>.<anonymous>.<anonymous> (SuppliersScreen.kt:225)");
            }
            BasicsKt.OxEmptyNote(SuppliersScreen$lambda$0(state).isEmpty() ? LangKt.tx("Поставщиков пока нет — добавьте первого.", new Object[0]) : LangKt.tx("Ничего не найдено.", new Object[0]), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SuppliersScreen$lambda$15$0$4(Supplier it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "supplier-" + it.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SuppliersScreen$lambda$16$0(MutableState mutableState) {
        SuppliersScreen$lambda$7(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SuppliersScreen$lambda$17$2$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SupplierCard(final Supplier supplier, final SupplierStat supplierStat, final String str, final boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        String str2;
        boolean z2;
        Composer startRestartGroup = composer.startRestartGroup(1244269351);
        ComposerKt.sourceInformation(startRestartGroup, "C(SupplierCard)P(4,3,1)272@10700L1990,272@10613L2077:SuppliersScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(supplier) : startRestartGroup.changedInstance(supplier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(supplierStat) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            str2 = str;
            i2 |= startRestartGroup.changed(str2) ? 256 : 128;
        } else {
            str2 = str;
        }
        if ((i & 3072) == 0) {
            z2 = z;
            i2 |= startRestartGroup.changed(z2) ? 2048 : 1024;
        } else {
            z2 = z;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1244269351, i3, -1, "uz.FonRo.pos.ui.docs.SupplierCard (SuppliersScreen.kt:270)");
            }
            String upperCase = StringsKt.take(StringsKt.trim((CharSequence) supplier.getName()).toString(), 1).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            String str3 = upperCase;
            if (str3.length() == 0) {
                str3 = "?";
            }
            final String str4 = str3;
            final boolean z3 = z2;
            final String str5 = str2;
            BasicsKt.m9829OxCardEOp_iR4(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(9.0f), 7, null), Dp.m6989constructorimpl(12.0f), 0L, null, function0, ComposableLambdaKt.rememberComposableLambda(666952076, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SuppliersScreenKt.SupplierCard$lambda$1(str4, supplier, z3, supplierStat, str5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, (57344 & i3) | 196662, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SuppliersScreenKt.SupplierCard$lambda$2(Supplier.this, supplierStat, str, z, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0502  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x05a1  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x05c6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x05ce  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x05cb  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x05a6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0594  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x04a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit SupplierCard$lambda$1(java.lang.String r66, uz.FonRo.pos.data.model.Supplier r67, boolean r68, uz.FonRo.pos.ui.docs.SupplierStat r69, java.lang.String r70, androidx.compose.foundation.layout.ColumnScope r71, androidx.compose.runtime.Composer r72, int r73) {
        /*
            Method dump skipped, instructions count: 1561
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.SuppliersScreenKt.SupplierCard$lambda$1(java.lang.String, uz.FonRo.pos.data.model.Supplier, boolean, uz.FonRo.pos.ui.docs.SupplierStat, java.lang.String, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    private static final void SupplierDetailSheet(final Supplier supplier, final SupplierStat supplierStat, final boolean z, final List<StockInDoc> list, final String str, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        final boolean z2;
        String str2;
        Composer startRestartGroup = composer.startRestartGroup(-723091517);
        ComposerKt.sourceInformation(startRestartGroup, "C(SupplierDetailSheet)P(5,4!1,2)339@12990L116,342@13113L2067,336@12898L2282:SuppliersScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(supplier) : startRestartGroup.changedInstance(supplier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(supplierStat) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            z2 = z;
            i2 |= startRestartGroup.changed(z2) ? 256 : 128;
        } else {
            z2 = z;
        }
        if ((i & 3072) == 0) {
            i2 |= (i & 4096) == 0 ? startRestartGroup.changed(list) : startRestartGroup.changedInstance(list) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            str2 = str;
            i2 |= startRestartGroup.changed(str2) ? 16384 : 8192;
        } else {
            str2 = str;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-723091517, i3, -1, "uz.FonRo.pos.ui.docs.SupplierDetailSheet (SuppliersScreen.kt:335)");
            }
            final String str3 = str2;
            SheetsKt.OxCardSheet(supplier.getName(), function0, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-1305772170, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SuppliersScreenKt.SupplierDetailSheet$lambda$0(Function0.this, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(179832031, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SuppliersScreenKt.SupplierDetailSheet$lambda$1(Supplier.this, supplierStat, z2, str3, list, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i3 >> 12) & 112) | 14155776, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SuppliersScreenKt.SupplierDetailSheet$lambda$2(Supplier.this, supplierStat, z, list, str, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SupplierDetailSheet$lambda$0(Function0 function0, RowScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C340@13004L92:SuppliersScreen.kt#1so789");
        if ((i & 6) == 0) {
            i |= composer.changed(OxCardSheet) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1305772170, i, -1, "uz.FonRo.pos.ui.docs.SupplierDetailSheet.<anonymous> (SuppliersScreen.kt:340)");
            }
            BasicsKt.OxButton(LangKt.tx("Закрыть", new Object[0]), function0, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.PRIMARY, null, false, false, null, composer, 3072, 240);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x011a, code lost:
    
        if (r2 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0400, code lost:
    
        if (r11 == null) goto L87;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0551  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x056a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x016e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit SupplierDetailSheet$lambda$1(uz.FonRo.pos.data.model.Supplier r45, uz.FonRo.pos.ui.docs.SupplierStat r46, boolean r47, java.lang.String r48, java.util.List r49, androidx.compose.foundation.layout.ColumnScope r50, androidx.compose.runtime.Composer r51, int r52) {
        /*
            Method dump skipped, instructions count: 1437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.SuppliersScreenKt.SupplierDetailSheet$lambda$1(uz.FonRo.pos.data.model.Supplier, uz.FonRo.pos.ui.docs.SupplierStat, boolean, java.lang.String, java.util.List, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    private static final void SupplierFormSheet(final FonRoApp FonRoApp, Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        final Function0<Unit> function02 = function0;
        Composer startRestartGroup = composer.startRestartGroup(1819008597);
        ComposerKt.sourceInformation(startRestartGroup, "C(SupplierFormSheet)395@15352L24,398@15439L31,399@15488L31,400@15536L31,401@15584L34,451@17210L434,462@17651L926,448@17110L1467:SuppliersScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(FonRoApp) : startRestartGroup.changedInstance(FonRoApp) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1819008597, i3, -1, "uz.FonRo.pos.ui.docs.SupplierFormSheet (SuppliersScreen.kt:393)");
            }
            final Repo repo = FonRoApp.getRepo();
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
            final boolean can = repo.can(Perm.STOCK_IN);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 15578356, "CC(remember):SuppliersScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 15579924, "CC(remember):SuppliersScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 15581460, "CC(remember):SuppliersScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 15582999, "CC(remember):SuppliersScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            composer2 = startRestartGroup;
            function02 = function0;
            SheetsKt.OxCardSheet(LangKt.tx("Новый поставщик", new Object[0]), function02, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(684309192, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SuppliersScreenKt.SupplierFormSheet$lambda$12(Function0.this, can, coroutineScope, repo, mutableState4, mutableState, mutableState2, mutableState3, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-647271823, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SuppliersScreenKt.SupplierFormSheet$lambda$13(MutableState.this, mutableState2, mutableState3, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), composer2, (i3 & 112) | 14155776, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SuppliersScreenKt.SupplierFormSheet$lambda$14(FonRoApp.this, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String SupplierFormSheet$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SupplierFormSheet$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SupplierFormSheet$lambda$7(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean SupplierFormSheet$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SupplierFormSheet$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void SupplierFormSheet$create(boolean z, CoroutineScope coroutineScope, MutableState<Boolean> mutableState, MutableState<String> mutableState2, Function0<Unit> function0, MutableState<String> mutableState3, MutableState<String> mutableState4, Repo repo) {
        if (SupplierFormSheet$lambda$10(mutableState)) {
            return;
        }
        if (!z) {
            Toaster.INSTANCE.error(LangKt.tx("Нет права на приход", new Object[0]));
            return;
        }
        String obj = StringsKt.trim((CharSequence) SupplierFormSheet$lambda$1(mutableState2)).toString();
        if (obj.length() == 0) {
            Toaster.INSTANCE.error(LangKt.tx("Введите название", new Object[0]));
        } else {
            SupplierFormSheet$lambda$11(mutableState, true);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SuppliersScreenKt$SupplierFormSheet$create$1(obj, function0, mutableState3, mutableState4, repo, mutableState, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SupplierFormSheet$lambda$12(final Function0 function0, final boolean z, final CoroutineScope coroutineScope, final Repo repo, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C452@17224L89,455@17415L12,453@17326L308:SuppliersScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(684309192, i2, -1, "uz.FonRo.pos.ui.docs.SupplierFormSheet.<anonymous> (SuppliersScreen.kt:452)");
            }
            BasicsKt.OxButton(LangKt.tx("Отмена", new Object[0]), function0, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.GHOST, null, false, false, null, composer, 3072, 240);
            String tx = SupplierFormSheet$lambda$10(mutableState) ? LangKt.tx("Сохраняем…", new Object[0]) : LangKt.tx("Создать", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, 491143796, "CC(remember):SuppliersScreen.kt#9igjgp");
            boolean changed = composer.changed(z) | composer.changedInstance(coroutineScope) | composer.changedInstance(repo) | composer.changed(function0);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                Function0 function02 = new Function0() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SupplierFormSheet$lambda$12$0$0;
                        SupplierFormSheet$lambda$12$0$0 = SuppliersScreenKt.SupplierFormSheet$lambda$12$0$0(z, coroutineScope, mutableState, mutableState2, function0, mutableState3, mutableState4, repo);
                        return SupplierFormSheet$lambda$12$0$0;
                    }
                };
                composer.updateRememberedValue(function02);
                rememberedValue = function02;
            }
            Function0 function03 = (Function0) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, function03, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 2.0f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, (!z || SupplierFormSheet$lambda$10(mutableState) || StringsKt.isBlank(SupplierFormSheet$lambda$1(mutableState2))) ? false : true, false, null, composer, 27648, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierFormSheet$lambda$12$0$0(boolean z, CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, Function0 function0, MutableState mutableState3, MutableState mutableState4, Repo repo) {
        SupplierFormSheet$create(z, coroutineScope, mutableState, mutableState2, function0, mutableState3, mutableState4, repo);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SupplierFormSheet$lambda$13(final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, ColumnScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C463@17692L21,463@17661L910:SuppliersScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-647271823, i, -1, "uz.FonRo.pos.ui.docs.SupplierFormSheet.<anonymous> (SuppliersScreen.kt:463)");
            }
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
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
            ComposerKt.sourceInformationMarkerStart(composer, -271812195, "C467@17843L13,464@17730L232,474@18086L14,471@17975L273,482@18371L13,479@18261L277,487@18551L10:SuppliersScreen.kt#1so789");
            String tx = LangKt.tx("Название *", new Object[0]);
            String SupplierFormSheet$lambda$1 = SupplierFormSheet$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 1515255316, "CC(remember):SuppliersScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SupplierFormSheet$lambda$13$0$0$0;
                        SupplierFormSheet$lambda$13$0$0$0 = SuppliersScreenKt.SupplierFormSheet$lambda$13$0$0$0(MutableState.this, (String) obj);
                        return SupplierFormSheet$lambda$13$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9846OxFieldDfSPO0(tx, SupplierFormSheet$lambda$1, (Function1) rememberedValue, null, LangKt.tx("Например: Ойбек Трейд", new Object[0]), 0, 0, null, false, false, false, false, false, Integer.valueOf(MenuKt.InTransitionDuration), null, composer, 384, 3072, 24552);
            String tx2 = LangKt.tx("Телефон", new Object[0]);
            String SupplierFormSheet$lambda$4 = SupplierFormSheet$lambda$4(mutableState2);
            ComposerKt.sourceInformationMarkerStart(composer, 1515263093, "CC(remember):SuppliersScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SupplierFormSheet$lambda$13$0$1$0;
                        SupplierFormSheet$lambda$13$0$1$0 = SuppliersScreenKt.SupplierFormSheet$lambda$13$0$1$0(MutableState.this, (String) obj);
                        return SupplierFormSheet$lambda$13$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9846OxFieldDfSPO0(tx2, SupplierFormSheet$lambda$4, (Function1) rememberedValue2, null, "+998 90 123 45 67", KeyboardType.INSTANCE.m6694getPhonePjHm6EE(), 0, null, false, false, false, false, false, 32, null, composer, 221568, 3072, 24520);
            String tx3 = LangKt.tx("Заметка", new Object[0]);
            String SupplierFormSheet$lambda$7 = SupplierFormSheet$lambda$7(mutableState3);
            ComposerKt.sourceInformationMarkerStart(composer, 1515272212, "CC(remember):SuppliersScreen.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: uz.FonRo.pos.ui.docs.SuppliersScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SupplierFormSheet$lambda$13$0$2$0;
                        SupplierFormSheet$lambda$13$0$2$0 = SuppliersScreenKt.SupplierFormSheet$lambda$13$0$2$0(MutableState.this, (String) obj);
                        return SupplierFormSheet$lambda$13$0$2$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9846OxFieldDfSPO0(tx3, SupplierFormSheet$lambda$7, (Function1) rememberedValue3, null, LangKt.tx("Например: возит воду по вторникам", new Object[0]), 0, 0, null, false, false, false, false, false, 240, null, composer, 805306752, 3072, 24040);
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
    public static final Unit SupplierFormSheet$lambda$13$0$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierFormSheet$lambda$13$0$1$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierFormSheet$lambda$13$0$2$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    private static final List<Supplier> SuppliersScreen$lambda$0(State<? extends List<Supplier>> state) {
        return state.getValue();
    }

    private static final SyncData SuppliersScreen$lambda$1(State<SyncData> state) {
        return state.getValue();
    }
}
