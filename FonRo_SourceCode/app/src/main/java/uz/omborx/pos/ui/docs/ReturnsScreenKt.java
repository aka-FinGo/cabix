package uz.FonRo.pos.ui.docs;

import androidx.camera.video.AudioStats;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
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
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Num;
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.core.Units;
import uz.FonRo.pos.data.model.ReturnDoc;
import uz.FonRo.pos.data.model.ReturnLine;
import uz.FonRo.pos.data.model.ReturnLineBody;
import uz.FonRo.pos.data.model.SaleRow;
import uz.FonRo.pos.data.model.SyncData;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnSize;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.ChipTint;
import uz.FonRo.pos.ui.components.ChipTone;
import uz.FonRo.pos.ui.components.ChipsKt;
import uz.FonRo.pos.ui.components.FieldsKt;
import uz.FonRo.pos.ui.components.ModifiersKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.PeriodKind;
import uz.FonRo.pos.ui.components.PeriodPickersKt;
import uz.FonRo.pos.ui.components.PeriodState;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.scan.ScannerSheetKt;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxDim;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: ReturnsScreen.kt */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0006\u001a\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002\u001a=\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0014\u001aE\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\r\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010\u001d\u001a\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001cH\u0002\u001a?\u0010!\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010#\u001aE\u0010$\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010(¨\u0006\u0002²\u0006\f\u0010)\u001a\u0004\u0018\u00010*X\u008a\u0084\u0002²\u0006\n\u0010+\u001a\u00020,X\u008a\u008e\u0002²\u0006\f\u0010-\u001a\u0004\u0018\u00010\fX\u008a\u008e\u0002²\u0006\f\u0010.\u001a\u0004\u0018\u00010\u0010X\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u000200X\u008a\u008e\u0002²\u0006\n\u00101\u001a\u00020,X\u008a\u008e\u0002²\u0006\n\u00102\u001a\u00020,X\u008a\u008e\u0002²\u0006\n\u0010\r\u001a\u00020\fX\u008a\u008e\u0002²\u0006\u0010\u00103\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u008a\u008e\u0002²\u0006\u0016\u00104\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u001f05X\u008a\u008e\u0002²\u0006\n\u00107\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u00108\u001a\u00020,X\u008a\u008e\u0002²\u0006\n\u00109\u001a\u00020,X\u008a\u008e\u0002²\u0006\n\u0010:\u001a\u00020,X\u008a\u008e\u0002²\u0006\n\u0010;\u001a\u00020,X\u008a\u008e\u0002²\u0006\f\u0010<\u001a\u0004\u0018\u00010=X\u008a\u008e\u0002²\u0006\n\u0010>\u001a\u00020,X\u008a\u008e\u0002"}, d2 = {"ReturnsScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "shortTid", "", "tid", "ReturnCard", "doc", "Luz/FonRo/pos/data/model/ReturnDoc;", FirebaseAnalytics.Param.CURRENCY, "onClick", "Lkotlin/Function0;", "(Luz/FonRo/pos/data/model/ReturnDoc;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ReturnDetailSheet", "repo", "Luz/FonRo/pos/data/repo/Repo;", "onDismiss", "(Luz/FonRo/pos/data/model/ReturnDoc;Luz/FonRo/pos/data/repo/Repo;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "loadReceiptRows", "", "Luz/FonRo/pos/data/model/SaleRow;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "returnableOf", "", "row", "ReturnFormSheet", "initialTid", "(Luz/FonRo/pos/FonRoApp;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ReturnLineRow", "available", "take", "onPick", "(Luz/FonRo/pos/data/model/SaleRow;DDLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "sync", "Luz/FonRo/pos/data/model/SyncData;", "formOpen", "", "formTid", "detail", TypedValues.CycleType.S_WAVE_PERIOD, "Luz/FonRo/pos/ui/components/PeriodState;", "monthSheet", "dateSheet", "rows", "qty", "", "", "reason", "searching", "searched", "busy", "scanOpen", "pad", "Luz/FonRo/pos/ui/docs/NumPadRequest;", "confirm"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ReturnsScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReturnCard$lambda$2(ReturnDoc returnDoc, String str, Function0 function0, int i, Composer composer, int i2) {
        ReturnCard(returnDoc, str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReturnDetailSheet$lambda$3(ReturnDoc returnDoc, Repo repo, String str, Function0 function0, int i, Composer composer, int i2) {
        ReturnDetailSheet(returnDoc, repo, str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReturnFormSheet$lambda$41(FonRoApp FonRoApp, String str, Function0 function0, int i, Composer composer, int i2) {
        ReturnFormSheet(FonRoApp, str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReturnLineRow$lambda$1(SaleRow saleRow, double d, double d2, Function0 function0, int i, Composer composer, int i2) {
        ReturnLineRow(saleRow, d, d2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReturnsScreen$lambda$31(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        ReturnsScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ReturnsScreen(final FonRoApp app, final AppNavigator nav, Composer composer, final int i) {
        List<ReturnDoc> emptyList;
        Repo repo;
        Object next;
        Iterator it;
        final String str;
        final MutableState mutableState;
        final MutableState mutableState2;
        final MutableState mutableState3;
        final MutableState mutableState4;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(nav, "nav");
        Composer startRestartGroup = composer.startRestartGroup(932929397);
        ComposerKt.sourceInformation(startRestartGroup, "C(ReturnsScreen)105@4254L29,109@4390L34,110@4444L42,111@4505L45,115@4709L67,116@4799L34,117@4855L34,119@4916L348,119@4895L369,130@5287L941,151@6384L96,163@6864L3301,160@6712L3453:ReturnsScreen.kt#1so789");
        int i2 = (i & 6) == 0 ? i | ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2) : i;
        if (startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(932929397, i2, -1, "uz.FonRo.pos.ui.docs.ReturnsScreen (ReturnsScreen.kt:103)");
            }
            Repo repo2 = app.getRepo();
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(repo2.getSync(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            String currency = repo2.currency();
            final boolean can = repo2.can(Perm.MANAGE_RETURNS);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1103006601, "CC(remember):ReturnsScreen.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState5 = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1103004865, "CC(remember):ReturnsScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState6 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1103002910, "CC(remember):ReturnsScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState7 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1102996360, "CC(remember):ReturnsScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PeriodState(PeriodKind.DAYS_10, null, null, 6, null), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState8 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1102993513, "CC(remember):ReturnsScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState9 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1102991721, "CC(remember):ReturnsScreen.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final MutableState mutableState10 = (MutableState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1102989455, "CC(remember):ReturnsScreen.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(repo2);
            ReturnsScreenKt$ReturnsScreen$1$1 rememberedValue7 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = new ReturnsScreenKt$ReturnsScreen$1$1(mutableState6, mutableState5, repo2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue7, startRestartGroup, 6);
            SyncData ReturnsScreen$lambda$0 = ReturnsScreen$lambda$0(collectAsStateWithLifecycle);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1102976990, "CC(remember):ReturnsScreen.kt#9igjgp");
            boolean changed = startRestartGroup.changed(ReturnsScreen$lambda$0);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                SyncData ReturnsScreen$lambda$02 = ReturnsScreen$lambda$0(collectAsStateWithLifecycle);
                if (ReturnsScreen$lambda$02 == null || (emptyList = ReturnsScreen$lambda$02.getReturns()) == null) {
                    emptyList = CollectionsKt.emptyList();
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator it2 = emptyList.iterator();
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    ReturnDoc returnDoc = (ReturnDoc) next2;
                    String obj = StringsKt.trim((CharSequence) returnDoc.getTransactionId()).toString();
                    Repo repo3 = repo2;
                    if (obj.length() == 0) {
                        it = it2;
                        obj = "return-" + returnDoc.getId();
                    } else {
                        it = it2;
                    }
                    String str2 = obj;
                    Object obj2 = linkedHashMap.get(str2);
                    if (obj2 == null) {
                        obj2 = (List) new ArrayList();
                        linkedHashMap.put(str2, obj2);
                    }
                    ((List) obj2).add(next2);
                    it2 = it;
                    repo2 = repo3;
                }
                repo = repo2;
                ArrayList arrayList = new ArrayList(linkedHashMap.size());
                Iterator it3 = linkedHashMap.entrySet().iterator();
                while (it3.hasNext()) {
                    List list = (List) ((Map.Entry) it3.next()).getValue();
                    Iterator it4 = list.iterator();
                    if (it4.hasNext()) {
                        next = it4.next();
                        if (it4.hasNext()) {
                            long id = ((ReturnDoc) next).getId();
                            do {
                                Object next3 = it4.next();
                                long id2 = ((ReturnDoc) next3).getId();
                                if (id > id2) {
                                    next = next3;
                                    id = id2;
                                }
                            } while (it4.hasNext());
                        }
                    } else {
                        next = null;
                    }
                    ReturnDoc returnDoc2 = (ReturnDoc) next;
                    if (returnDoc2 == null) {
                        returnDoc2 = (ReturnDoc) CollectionsKt.first(list);
                    }
                    arrayList.add(returnDoc2);
                }
                rememberedValue8 = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$ReturnsScreen$lambda$20$$inlined$sortedByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((ReturnDoc) t2).getCreatedAt(), ((ReturnDoc) t).getCreatedAt());
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue8);
            } else {
                repo = repo2;
            }
            final List list2 = (List) rememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            PeriodState ReturnsScreen$lambda$11 = ReturnsScreen$lambda$11(mutableState8);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1102942731, "CC(remember):ReturnsScreen.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(ReturnsScreen$lambda$11) | startRestartGroup.changed(list2);
            ArrayList rememberedValue9 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj3 : list2) {
                    if (ReturnsScreen$lambda$11(mutableState8).contains(((ReturnDoc) obj3).getCreatedAt())) {
                        arrayList2.add(obj3);
                    }
                }
                rememberedValue9 = arrayList2;
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            final List list3 = (List) rememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            List<ReturnDoc> list4 = list3;
            Iterator it5 = list4.iterator();
            double d = AudioStats.AUDIO_AMPLITUDE_NONE;
            while (it5.hasNext()) {
                d += ((ReturnDoc) it5.next()).getAmount();
            }
            double d2 = 0.0d;
            for (ReturnDoc returnDoc3 : list4) {
                Iterator<T> it6 = returnDoc3.getLines().iterator();
                double d3 = 0.0d;
                while (it6.hasNext()) {
                    d3 += ((ReturnLine) it6.next()).getQuantity();
                }
                if (returnDoc3.getQuantity() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    d3 = returnDoc3.getQuantity();
                }
                d2 += d3;
            }
            int i3 = i2;
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), OxDim.INSTANCE.m10245getPagePadD9Ej5fM(), 0.0f, 2, null);
            PaddingValues m1046PaddingValuesa9UjIt4$default = PaddingKt.m1046PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(30.0f), 7, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1102924166, "CC(remember):ReturnsScreen.kt#9igjgp");
            boolean changed3 = startRestartGroup.changed(d) | startRestartGroup.changed(currency) | startRestartGroup.changedInstance(list3) | startRestartGroup.changed(d2) | startRestartGroup.changed(can) | startRestartGroup.changedInstance(list2);
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                final double d4 = d;
                str = currency;
                final double d5 = d2;
                Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        Unit ReturnsScreen$lambda$24$0;
                        ReturnsScreen$lambda$24$0 = ReturnsScreenKt.ReturnsScreen$lambda$24$0(list3, d4, str, can, mutableState8, d5, mutableState6, mutableState5, mutableState9, mutableState10, list2, mutableState7, (LazyListScope) obj4);
                        return ReturnsScreen$lambda$24$0;
                    }
                };
                mutableState = mutableState5;
                startRestartGroup.updateRememberedValue(function1);
                rememberedValue10 = function1;
            } else {
                str = currency;
                mutableState = mutableState5;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LazyDslKt.LazyColumn(m1051paddingVpY3zN4$default, null, m1046PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) rememberedValue10, startRestartGroup, 384, TypedValues.PositionType.TYPE_PERCENT_X);
            startRestartGroup = startRestartGroup;
            if (ReturnsScreen$lambda$14(mutableState9)) {
                startRestartGroup.startReplaceGroup(172291648);
                ComposerKt.sourceInformation(startRestartGroup, "256@10271L22,257@10316L124,254@10197L253");
                String month = ReturnsScreen$lambda$11(mutableState8).getMonth();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1102818421, "CC(remember):ReturnsScreen.kt#9igjgp");
                Object rememberedValue11 = startRestartGroup.rememberedValue();
                if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                    mutableState4 = mutableState9;
                    rememberedValue11 = new Function0() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ReturnsScreen$lambda$25$0;
                            ReturnsScreen$lambda$25$0 = ReturnsScreenKt.ReturnsScreen$lambda$25$0(MutableState.this);
                            return ReturnsScreen$lambda$25$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue11);
                } else {
                    mutableState4 = mutableState9;
                }
                Function0 function0 = (Function0) rememberedValue11;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1102816879, "CC(remember):ReturnsScreen.kt#9igjgp");
                Object rememberedValue12 = startRestartGroup.rememberedValue();
                if (rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                    mutableState2 = mutableState8;
                    rememberedValue12 = new Function1() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj4) {
                            Unit ReturnsScreen$lambda$26$0;
                            ReturnsScreen$lambda$26$0 = ReturnsScreenKt.ReturnsScreen$lambda$26$0(MutableState.this, mutableState4, (String) obj4);
                            return ReturnsScreen$lambda$26$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue12);
                } else {
                    mutableState2 = mutableState8;
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                PeriodPickersKt.OxMonthSheet(month, function0, (Function1) rememberedValue12, startRestartGroup, 432);
                startRestartGroup.endReplaceGroup();
            } else {
                mutableState2 = mutableState8;
                startRestartGroup.startReplaceGroup(172550157);
                startRestartGroup.endReplaceGroup();
            }
            if (ReturnsScreen$lambda$17(mutableState10)) {
                startRestartGroup.startReplaceGroup(172579328);
                ComposerKt.sourceInformation(startRestartGroup, "267@10565L21,268@10609L121,265@10487L253");
                String date = ReturnsScreen$lambda$11(mutableState2).getDate();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1102809014, "CC(remember):ReturnsScreen.kt#9igjgp");
                Object rememberedValue13 = startRestartGroup.rememberedValue();
                if (rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                    mutableState3 = mutableState10;
                    rememberedValue13 = new Function0() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda33
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ReturnsScreen$lambda$27$0;
                            ReturnsScreen$lambda$27$0 = ReturnsScreenKt.ReturnsScreen$lambda$27$0(MutableState.this);
                            return ReturnsScreen$lambda$27$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue13);
                } else {
                    mutableState3 = mutableState10;
                }
                Function0 function02 = (Function0) rememberedValue13;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1102807506, "CC(remember):ReturnsScreen.kt#9igjgp");
                Object rememberedValue14 = startRestartGroup.rememberedValue();
                if (rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue14 = new Function1() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda37
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj4) {
                            Unit ReturnsScreen$lambda$28$0;
                            ReturnsScreen$lambda$28$0 = ReturnsScreenKt.ReturnsScreen$lambda$28$0(MutableState.this, mutableState3, (String) obj4);
                            return ReturnsScreen$lambda$28$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue14);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                PeriodPickersKt.OxDayPickerDialog(date, function02, (Function1) rememberedValue14, startRestartGroup, 432);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(172837837);
                startRestartGroup.endReplaceGroup();
            }
            if (ReturnsScreen$lambda$2(mutableState)) {
                startRestartGroup.startReplaceGroup(172862637);
                ComposerKt.sourceInformation(startRestartGroup, "279@10874L36,276@10776L144");
                String ReturnsScreen$lambda$5 = ReturnsScreen$lambda$5(mutableState6);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1102799111, "CC(remember):ReturnsScreen.kt#9igjgp");
                Object rememberedValue15 = startRestartGroup.rememberedValue();
                if (rememberedValue15 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue15 = new Function0() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda38
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ReturnsScreen$lambda$29$0;
                            ReturnsScreen$lambda$29$0 = ReturnsScreenKt.ReturnsScreen$lambda$29$0(MutableState.this, mutableState6);
                            return ReturnsScreen$lambda$29$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue15);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ReturnFormSheet(app, ReturnsScreen$lambda$5, (Function0) rememberedValue15, startRestartGroup, FonRoApp.$stable | 384 | (i3 & 14));
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(173016397);
                startRestartGroup.endReplaceGroup();
            }
            ReturnDoc ReturnsScreen$lambda$8 = ReturnsScreen$lambda$8(mutableState7);
            if (ReturnsScreen$lambda$8 == null) {
                startRestartGroup.startReplaceGroup(173035802);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(173035803);
                ComposerKt.sourceInformation(startRestartGroup, "*288@11085L17,284@10961L151");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1376203607, "CC(remember):ReturnsScreen.kt#9igjgp");
                Object rememberedValue16 = startRestartGroup.rememberedValue();
                if (rememberedValue16 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue16 = new Function0() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda39
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ReturnsScreen$lambda$30$0$0;
                            ReturnsScreen$lambda$30$0$0 = ReturnsScreenKt.ReturnsScreen$lambda$30$0$0(MutableState.this);
                            return ReturnsScreen$lambda$30$0$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue16);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ReturnDetailSheet(ReturnsScreen$lambda$8, repo, str, (Function0) rememberedValue16, startRestartGroup, ReturnDoc.$stable | 3072 | (Repo.$stable << 3));
                Unit unit2 = Unit.INSTANCE;
                startRestartGroup.endReplaceGroup();
                Unit unit3 = Unit.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda40
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    return ReturnsScreenKt.ReturnsScreen$lambda$31(FonRoApp.this, nav, i, (Composer) obj4, ((Integer) obj5).intValue());
                }
            });
        }
    }

    private static final boolean ReturnsScreen$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ReturnsScreen$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String ReturnsScreen$lambda$5(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final ReturnDoc ReturnsScreen$lambda$8(MutableState<ReturnDoc> mutableState) {
        return mutableState.getValue();
    }

    private static final PeriodState ReturnsScreen$lambda$11(MutableState<PeriodState> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ReturnsScreen$lambda$14(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ReturnsScreen$lambda$15(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean ReturnsScreen$lambda$17(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ReturnsScreen$lambda$18(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnsScreen$lambda$24$0(final List list, final double d, final String str, final boolean z, final MutableState mutableState, final double d2, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final List list2, final MutableState mutableState6, LazyListScope LazyColumn) {
        LazyListScope lazyListScope;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, "head", null, ComposableSingletons$ReturnsScreenKt.INSTANCE.m9880getLambda$930735030$app(), 2, null);
        LazyListScope.item$default(LazyColumn, "hero", null, ComposableLambdaKt.composableLambdaInstance(265015937, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit ReturnsScreen$lambda$24$0$0;
                ReturnsScreen$lambda$24$0$0 = ReturnsScreenKt.ReturnsScreen$lambda$24$0$0(d, str, z, mutableState, list, d2, mutableState2, mutableState3, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return ReturnsScreen$lambda$24$0$0;
            }
        }), 2, null);
        LazyListScope.item$default(LazyColumn, "history-period", null, ComposableLambdaKt.composableLambdaInstance(-437579902, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit ReturnsScreen$lambda$24$0$1;
                ReturnsScreen$lambda$24$0$1 = ReturnsScreenKt.ReturnsScreen$lambda$24$0$1(MutableState.this, mutableState4, mutableState5, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return ReturnsScreen$lambda$24$0$1;
            }
        }), 2, null);
        LazyListScope.item$default(LazyColumn, "history-head", null, ComposableLambdaKt.composableLambdaInstance(-1140175741, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit ReturnsScreen$lambda$24$0$2;
                ReturnsScreen$lambda$24$0$2 = ReturnsScreenKt.ReturnsScreen$lambda$24$0$2(list, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return ReturnsScreen$lambda$24$0$2;
            }
        }), 2, null);
        if (list.isEmpty()) {
            LazyListScope.item$default(LazyColumn, "history-empty", null, ComposableLambdaKt.composableLambdaInstance(-1066692443, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ReturnsScreen$lambda$24$0$3;
                    ReturnsScreen$lambda$24$0$3 = ReturnsScreenKt.ReturnsScreen$lambda$24$0$3(list2, mutableState, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ReturnsScreen$lambda$24$0$3;
                }
            }), 2, null);
            lazyListScope = LazyColumn;
        } else {
            lazyListScope = LazyColumn;
        }
        final ReturnsScreenKt$ReturnsScreen$lambda$24$0$$inlined$items$default$1 returnsScreenKt$ReturnsScreen$lambda$24$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$ReturnsScreen$lambda$24$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(ReturnDoc returnDoc) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((ReturnDoc) obj);
            }
        };
        lazyListScope.items(list.size(), null, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$ReturnsScreen$lambda$24$0$$inlined$items$default$3
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
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$ReturnsScreen$lambda$24$0$$inlined$items$default$4
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
                final ReturnDoc returnDoc = (ReturnDoc) list.get(i);
                composer.startReplaceGroup(1952097681);
                ComposerKt.sourceInformation(composer, "C*249@10132L16,249@10079L70:ReturnsScreen.kt#1so789");
                String str2 = str;
                ComposerKt.sourceInformationMarkerStart(composer, 1309898524, "CC(remember):ReturnsScreen.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(returnDoc);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState7 = mutableState6;
                    rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$ReturnsScreen$2$1$5$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            mutableState7.setValue(ReturnDoc.this);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ReturnsScreenKt.ReturnCard(returnDoc, str2, (Function0) rememberedValue, composer, ReturnDoc.$stable);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnsScreen$lambda$24$0$0(final double d, final String str, final boolean z, final MutableState mutableState, final List list, final double d2, final MutableState mutableState2, final MutableState mutableState3, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C174@7203L1666,169@6974L1895:ReturnsScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(265015937, i, -1, "uz.FonRo.pos.ui.docs.ReturnsScreen.<anonymous>.<anonymous>.<anonymous> (ReturnsScreen.kt:169)");
            }
            BasicsKt.m9833OxSoftCardCe4qNIY(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null), Dp.m6989constructorimpl(14.0f), null, Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10226getRose0d7_KjU(), 0.1f), Ox.INSTANCE.m10242tintBorderl2rxGTc(Ox.INSTANCE.m10226getRose0d7_KjU()), null, ComposableLambdaKt.rememberComposableLambda(-1265676409, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda42
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ReturnsScreen$lambda$24$0$0$0;
                    ReturnsScreen$lambda$24$0$0$0 = ReturnsScreenKt.ReturnsScreen$lambda$24$0$0$0(d, str, z, mutableState, list, d2, mutableState2, mutableState3, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ReturnsScreen$lambda$24$0$0$0;
                }
            }, composer, 54), composer, 1572918, 36);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnsScreen$lambda$24$0$0$0(double d, String str, final boolean z, MutableState mutableState, List list, double d2, final MutableState mutableState2, final MutableState mutableState3, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C175@7221L255,179@7493L284,186@7794L483,195@8294L11,198@8396L281,196@8322L533:ReturnsScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1265676409, i, -1, "uz.FonRo.pos.ui.docs.ReturnsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ReturnsScreen.kt:175)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1786345426, "C176@7320L81,177@7422L36:ReturnsScreen.kt#1so789");
            TextKt.m2798Text4IGK_g(LangKt.tx("Сумма возвратов", new Object[0]), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getLabel(), composer, 0, 0, 65532);
            BasicsKt.OxChip(ReturnsScreen$lambda$11(mutableState).title(), ChipTone.BAD, null, composer, 48, 4);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.money(Double.valueOf(d), str), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(6.0f), 0.0f, Dp.m6989constructorimpl(12.0f), 5, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getAmount(), composer, 48, 3120, 55292);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1257643337, "C187@7897L64,188@7982L57,189@8060L199:ReturnsScreen.kt#1so789");
            StockInScreenKt.m9919DocMiniStatuDo3WH8(rowScopeInstance2, String.valueOf(list.size()), LangKt.tx("Возвратов", new Object[0]), Ox.INSTANCE.m10196getDanger0d7_KjU(), null, composer, 6, 8);
            StockInScreenKt.m9919DocMiniStatuDo3WH8(rowScopeInstance2, Fmt.INSTANCE.qf(Double.valueOf(d2)), LangKt.tx("Товаров", new Object[0]), Ox.INSTANCE.m10187getBlueDeep0d7_KjU(), null, composer, 6, 8);
            StockInScreenKt.m9919DocMiniStatuDo3WH8(rowScopeInstance2, Fmt.INSTANCE.nf(Double.valueOf(list.isEmpty() ? AudioStats.AUDIO_AMPLITUDE_NONE : d / list.size())), LangKt.tx("Средний", new Object[0]), Ox.INSTANCE.m10223getPurple0d7_KjU(), null, composer, 6, 8);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            String tx = LangKt.tx("Добавить возврат", new Object[0]);
            BtnStyle btnStyle = BtnStyle.PRIMARY;
            BtnSize btnSize = BtnSize.LG;
            ComposerKt.sourceInformationMarkerStart(composer, -839245824, "CC(remember):ReturnsScreen.kt#9igjgp");
            boolean changed = composer.changed(z);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ReturnsScreen$lambda$24$0$0$0$2$0;
                        ReturnsScreen$lambda$24$0$0$0$2$0 = ReturnsScreenKt.ReturnsScreen$lambda$24$0$0$0$2$0(z, mutableState2, mutableState3);
                        return ReturnsScreen$lambda$24$0$0$0$2$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, null, btnStyle, btnSize, z, true, null, composer, 1600512, 132);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnsScreen$lambda$24$0$0$0$2$0(boolean z, MutableState mutableState, MutableState mutableState2) {
        if (!z) {
            Toaster.INSTANCE.error(LangKt.tx("Нет права на возвраты", new Object[0]));
        } else {
            mutableState.setValue(null);
            ReturnsScreen$lambda$3(mutableState2, true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnsScreen$lambda$24$0$1(final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C217@9000L15,225@9357L21,226@9409L20,215@8926L517:ReturnsScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-437579902, i, -1, "uz.FonRo.pos.ui.docs.ReturnsScreen.<anonymous>.<anonymous>.<anonymous> (ReturnsScreen.kt:215)");
            }
            PeriodState ReturnsScreen$lambda$11 = ReturnsScreen$lambda$11(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 392512017, "CC(remember):ReturnsScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ReturnsScreen$lambda$24$0$1$0$0;
                        ReturnsScreen$lambda$24$0$1$0$0 = ReturnsScreenKt.ReturnsScreen$lambda$24$0$1$0$0(MutableState.this, (PeriodState) obj);
                        return ReturnsScreen$lambda$24$0$1$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function1 function1 = (Function1) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(4.0f), 7, null);
            ChipTint chipTint = ChipTint.RED;
            List listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(LangKt.tx("Сегодня", new Object[0]), PeriodKind.TODAY), TuplesKt.to(LangKt.tx("10 дней", new Object[0]), PeriodKind.DAYS_10), TuplesKt.to(LangKt.tx("Все", new Object[0]), PeriodKind.ALL)});
            ComposerKt.sourceInformationMarkerStart(composer, 392523447, "CC(remember):ReturnsScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ReturnsScreen$lambda$24$0$1$1$0;
                        ReturnsScreen$lambda$24$0$1$1$0 = ReturnsScreenKt.ReturnsScreen$lambda$24$0$1$1$0(MutableState.this);
                        return ReturnsScreen$lambda$24$0$1$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            Function0 function0 = (Function0) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 392525110, "CC(remember):ReturnsScreen.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ReturnsScreen$lambda$24$0$1$2$0;
                        ReturnsScreen$lambda$24$0$1$2$0 = ReturnsScreenKt.ReturnsScreen$lambda$24$0$1$2$0(MutableState.this);
                        return ReturnsScreen$lambda$24$0$1$2$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.OxPeriodChips(ReturnsScreen$lambda$11, function1, m1053paddingqDBjuR0$default, chipTint, listOf, function0, (Function0) rememberedValue3, composer, 1772976 | PeriodState.$stable, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnsScreen$lambda$24$0$1$0$0(MutableState mutableState, PeriodState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnsScreen$lambda$24$0$1$1$0(MutableState mutableState) {
        ReturnsScreen$lambda$15(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnsScreen$lambda$24$0$1$2$0(MutableState mutableState) {
        ReturnsScreen$lambda$18(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnsScreen$lambda$24$0$2(List list, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C231@9498L242:ReturnsScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1140175741, i, -1, "uz.FonRo.pos.ui.docs.ReturnsScreen.<anonymous>.<anonymous>.<anonymous> (ReturnsScreen.kt:231)");
            }
            BasicsKt.OxSectionHead(LangKt.tx("История возвратов", new Object[0]), null, LangKt.tx("Нажмите возврат, чтобы посмотреть детали", new Object[0]), String.valueOf(list.size()), ChipTone.BAD, null, composer, 24576, 34);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnsScreen$lambda$24$0$3(List list, MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C241@9837L172:ReturnsScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1066692443, i, -1, "uz.FonRo.pos.ui.docs.ReturnsScreen.<anonymous>.<anonymous>.<anonymous> (ReturnsScreen.kt:241)");
            }
            BasicsKt.OxEmptyNote(list.isEmpty() ? LangKt.tx("Возвратов пока нет.", new Object[0]) : LangKt.tx("За «%s» возвратов нет.", ReturnsScreen$lambda$11(mutableState).title()), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnsScreen$lambda$25$0(MutableState mutableState) {
        ReturnsScreen$lambda$15(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnsScreen$lambda$26$0(MutableState mutableState, MutableState mutableState2, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(PeriodState.copy$default(ReturnsScreen$lambda$11(mutableState), PeriodKind.MONTH, it, null, 4, null));
        ReturnsScreen$lambda$15(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnsScreen$lambda$27$0(MutableState mutableState) {
        ReturnsScreen$lambda$18(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnsScreen$lambda$28$0(MutableState mutableState, MutableState mutableState2, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(PeriodState.copy$default(ReturnsScreen$lambda$11(mutableState), PeriodKind.DATE, null, it, 2, null));
        ReturnsScreen$lambda$18(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnsScreen$lambda$29$0(MutableState mutableState, MutableState mutableState2) {
        ReturnsScreen$lambda$3(mutableState, false);
        mutableState2.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnsScreen$lambda$30$0$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    private static final String shortTid(String str) {
        return str.length() <= 10 ? str : StringsKt.take(str, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ReturnCard(final ReturnDoc returnDoc, final String str, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        final double d;
        Composer startRestartGroup = composer.startRestartGroup(1711471283);
        ComposerKt.sourceInformation(startRestartGroup, "C(ReturnCard)P(1)301@11545L1928,301@11458L2015:ReturnsScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(returnDoc) : startRestartGroup.changedInstance(returnDoc) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1711471283, i2, -1, "uz.FonRo.pos.ui.docs.ReturnCard (ReturnsScreen.kt:299)");
            }
            double quantity = returnDoc.getQuantity();
            double d2 = AudioStats.AUDIO_AMPLITUDE_NONE;
            if (quantity > AudioStats.AUDIO_AMPLITUDE_NONE) {
                d = returnDoc.getQuantity();
            } else {
                Iterator<T> it = returnDoc.getLines().iterator();
                while (it.hasNext()) {
                    d2 += ((ReturnLine) it.next()).getQuantity();
                }
                d = d2;
            }
            BasicsKt.m9829OxCardEOp_iR4(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(9.0f), 7, null), Dp.m6989constructorimpl(12.0f), 0L, null, function0, ComposableLambdaKt.rememberComposableLambda(-564498408, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ReturnsScreenKt.ReturnCard$lambda$1(ReturnDoc.this, str, d, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 << 6) & 57344) | 196662, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ReturnsScreenKt.ReturnCard$lambda$2(ReturnDoc.this, str, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0522, code lost:
    
        if (r9 == null) goto L76;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit ReturnCard$lambda$1(uz.FonRo.pos.data.model.ReturnDoc r69, java.lang.String r70, double r71, androidx.compose.foundation.layout.ColumnScope r73, androidx.compose.runtime.Composer r74, int r75) {
        /*
            Method dump skipped, instructions count: 1398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.ReturnsScreenKt.ReturnCard$lambda$1(uz.FonRo.pos.data.model.ReturnDoc, java.lang.String, double, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    private static final void ReturnDetailSheet(final ReturnDoc returnDoc, final Repo repo, final String str, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        String str2;
        double d;
        Composer startRestartGroup = composer.startRestartGroup(-1540202029);
        ComposerKt.sourceInformation(startRestartGroup, "C(ReturnDetailSheet)P(1,3)368@13840L116,371@13963L1994,365@13703L2254:ReturnsScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(returnDoc) : startRestartGroup.changedInstance(returnDoc) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(repo) : startRestartGroup.changedInstance(repo) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            str2 = str;
            i2 |= startRestartGroup.changed(str2) ? 256 : 128;
        } else {
            str2 = str;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1540202029, i3, -1, "uz.FonRo.pos.ui.docs.ReturnDetailSheet (ReturnsScreen.kt:363)");
            }
            double quantity = returnDoc.getQuantity();
            double d2 = AudioStats.AUDIO_AMPLITUDE_NONE;
            if (quantity > AudioStats.AUDIO_AMPLITUDE_NONE) {
                d = returnDoc.getQuantity();
            } else {
                Iterator<T> it = returnDoc.getLines().iterator();
                while (it.hasNext()) {
                    d2 += ((ReturnLine) it.next()).getQuantity();
                }
                d = d2;
            }
            final String str3 = str2;
            final double d3 = d;
            SheetsKt.OxCardSheet(LangKt.tx("Возврат · ", new Object[0]) + Fmt.INSTANCE.dt(returnDoc.getCreatedAt(), false), function0, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-1129739642, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ReturnsScreenKt.ReturnDetailSheet$lambda$1(Function0.this, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(2033613551, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ReturnsScreenKt.ReturnDetailSheet$lambda$2(ReturnDoc.this, str3, d3, repo, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i3 >> 6) & 112) | 14155776, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ReturnsScreenKt.ReturnDetailSheet$lambda$3(ReturnDoc.this, repo, str, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReturnDetailSheet$lambda$1(Function0 function0, RowScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C369@13854L92:ReturnsScreen.kt#1so789");
        if ((i & 6) == 0) {
            i |= composer.changed(OxCardSheet) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1129739642, i, -1, "uz.FonRo.pos.ui.docs.ReturnDetailSheet.<anonymous> (ReturnsScreen.kt:369)");
            }
            BasicsKt.OxButton(LangKt.tx("Закрыть", new Object[0]), function0, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.PRIMARY, null, false, false, null, composer, 3072, 240);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x01d7, code lost:
    
        if (r5 == null) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x056e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x05b1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0588  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit ReturnDetailSheet$lambda$2(uz.FonRo.pos.data.model.ReturnDoc r76, java.lang.String r77, double r78, uz.FonRo.pos.data.repo.Repo r80, androidx.compose.foundation.layout.ColumnScope r81, androidx.compose.runtime.Composer r82, int r83) {
        /*
            Method dump skipped, instructions count: 1467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.ReturnsScreenKt.ReturnDetailSheet$lambda$2(uz.FonRo.pos.data.model.ReturnDoc, java.lang.String, double, uz.FonRo.pos.data.repo.Repo, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ec A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object loadReceiptRows(java.lang.String r12, kotlin.coroutines.Continuation<? super java.util.List<uz.FonRo.pos.data.model.SaleRow>> r13) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.ReturnsScreenKt.loadReceiptRows(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final double returnableOf(SaleRow saleRow) {
        return Num.INSTANCE.qty(Math.max(saleRow.getQuantity() - saleRow.getReturnedQuantity(), AudioStats.AUDIO_AMPLITUDE_NONE));
    }

    private static final void ReturnFormSheet(FonRoApp FonRoApp, final String str, final Function0<Unit> function0, Composer composer, final int i) {
        final FonRoApp FonRoApp2;
        final Function0<Unit> function02;
        Composer composer2;
        Unit unit;
        Repo repo;
        String str2;
        CoroutineScope coroutineScope;
        MutableState mutableState;
        final MutableState mutableState2;
        CoroutineScope coroutineScope2;
        String str3;
        Object obj;
        final MutableState mutableState3;
        Composer startRestartGroup = composer.startRestartGroup(1551796426);
        ComposerKt.sourceInformation(startRestartGroup, "C(ReturnFormSheet)455@17421L24,459@17547L49,460@17613L55,461@17684L58,462@17761L31,464@17815L34,465@17870L34,466@17921L34,467@17976L34,468@18026L49,469@18095L34,494@18820L142,494@18799L163,572@21840L474,583@22321L6378,569@21742L6957,744@28979L14,744@28963L30:ReturnsScreen.kt#1so789");
        int i2 = (i & 6) == 0 ? ((i & 8) == 0 ? startRestartGroup.changed(FonRoApp) : startRestartGroup.changedInstance(FonRoApp) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            FonRoApp2 = FonRoApp;
            function02 = function0;
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1551796426, i3, -1, "uz.FonRo.pos.ui.docs.ReturnFormSheet (ReturnsScreen.kt:453)");
            }
            Repo repo2 = FonRoApp.getRepo();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)558@25470L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -954203484, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            CoroutineScope coroutineScope3 = (CoroutineScope) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final String currency = repo2.currency();
            final boolean can = repo2.can(Perm.MANAGE_RETURNS);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 922722107, "CC(remember):ReturnsScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str == null ? "" : str, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 922724225, "CC(remember):ReturnsScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState5 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 922726500, "CC(remember):ReturnsScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState6 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 922728937, "CC(remember):ReturnsScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState7 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 922730668, "CC(remember):ReturnsScreen.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            MutableState mutableState8 = (MutableState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 922732428, "CC(remember):ReturnsScreen.kt#9igjgp");
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            MutableState mutableState9 = (MutableState) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 922734060, "CC(remember):ReturnsScreen.kt#9igjgp");
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            final MutableState mutableState10 = (MutableState) rememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 922735820, "CC(remember):ReturnsScreen.kt#9igjgp");
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                rememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            final MutableState mutableState11 = (MutableState) rememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 922737435, "CC(remember):ReturnsScreen.kt#9igjgp");
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                rememberedValue10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            final MutableState mutableState12 = (MutableState) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 922739628, "CC(remember):ReturnsScreen.kt#9igjgp");
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                rememberedValue11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            final MutableState mutableState13 = (MutableState) rememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 922762936, "CC(remember):ReturnsScreen.kt#9igjgp");
            boolean changedInstance = ((i3 & 112) == 32) | startRestartGroup.changedInstance(coroutineScope3);
            ReturnsScreenKt$ReturnFormSheet$1$1 rememberedValue12 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                unit = unit2;
                repo = repo2;
                str2 = "CC(remember):ReturnsScreen.kt#9igjgp";
                ReturnsScreenKt$ReturnFormSheet$1$1 returnsScreenKt$ReturnFormSheet$1$1 = new ReturnsScreenKt$ReturnFormSheet$1$1(str, coroutineScope3, mutableState8, mutableState5, mutableState6, mutableState9, null);
                coroutineScope = coroutineScope3;
                mutableState = mutableState8;
                mutableState2 = mutableState9;
                rememberedValue12 = returnsScreenKt$ReturnFormSheet$1$1;
                startRestartGroup.updateRememberedValue(rememberedValue12);
            } else {
                repo = repo2;
                coroutineScope = coroutineScope3;
                unit = unit2;
                str2 = "CC(remember):ReturnsScreen.kt#9igjgp";
                mutableState2 = mutableState9;
                mutableState = mutableState8;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue12, startRestartGroup, 6);
            final SaleRow saleRow = (SaleRow) CollectionsKt.firstOrNull((List) ReturnFormSheet$lambda$4(mutableState5));
            Iterator<T> it = ReturnFormSheet$lambda$4(mutableState5).iterator();
            final double d = 0.0d;
            while (it.hasNext()) {
                d += ((SaleRow) it.next()).getTotalAmount();
            }
            final double d2 = 0.0d;
            for (SaleRow saleRow2 : ReturnFormSheet$lambda$4(mutableState5)) {
                Double d3 = ReturnFormSheet$lambda$7(mutableState6).get(Long.valueOf(saleRow2.getId()));
                d2 += saleRow2.getQuantity() > AudioStats.AUDIO_AMPLITUDE_NONE ? saleRow2.getTotalAmount() * ((d3 != null ? d3.doubleValue() : 0.0d) / saleRow2.getQuantity()) : 0.0d;
            }
            List<SaleRow> ReturnFormSheet$lambda$4 = ReturnFormSheet$lambda$4(mutableState5);
            ArrayList arrayList = new ArrayList();
            for (SaleRow saleRow3 : ReturnFormSheet$lambda$4) {
                Double d4 = ReturnFormSheet$lambda$7(mutableState6).get(Long.valueOf(saleRow3.getId()));
                double doubleValue = d4 != null ? d4.doubleValue() : 0.0d;
                ReturnLineBody returnLineBody = doubleValue <= AudioStats.AUDIO_AMPLITUDE_NONE ? null : new ReturnLineBody(saleRow3.getId(), saleRow3.getProductId(), Num.INSTANCE.qty(doubleValue));
                if (returnLineBody != null) {
                    arrayList.add(returnLineBody);
                }
            }
            final ArrayList arrayList2 = arrayList;
            final double d5 = d2;
            final MutableState mutableState14 = mutableState;
            final CoroutineScope coroutineScope4 = coroutineScope;
            double d6 = d2;
            composer2 = startRestartGroup;
            final Repo repo3 = repo;
            SheetsKt.OxCardSheet(LangKt.tx("Новый возврат", new Object[0]), function0, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-885558409, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return ReturnsScreenKt.ReturnFormSheet$lambda$34(Function0.this, d5, can, arrayList2, mutableState10, mutableState13, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1697630418, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return ReturnsScreenKt.ReturnFormSheet$lambda$35(CoroutineScope.this, saleRow, can, mutableState4, mutableState14, mutableState5, mutableState6, mutableState2, mutableState11, d, mutableState12, mutableState7, d2, currency, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, startRestartGroup, 54), composer2, ((i3 >> 3) & 112) | 14155776, 60);
            if (ReturnFormSheet$lambda$22(mutableState11)) {
                composer2.startReplaceGroup(-1449297270);
                ComposerKt.sourceInformation(composer2, "735@28788L20,736@28831L110,733@28729L222");
                str3 = str2;
                ComposerKt.sourceInformationMarkerStart(composer2, 923081790, str3);
                Object rememberedValue13 = composer2.rememberedValue();
                if (rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                    mutableState3 = mutableState11;
                    rememberedValue13 = new Function0() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda26
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ReturnFormSheet$lambda$36$0;
                            ReturnFormSheet$lambda$36$0 = ReturnsScreenKt.ReturnFormSheet$lambda$36$0(MutableState.this);
                            return ReturnFormSheet$lambda$36$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue13);
                } else {
                    mutableState3 = mutableState11;
                }
                Function0 function03 = (Function0) rememberedValue13;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, 923083256, str3);
                boolean changedInstance2 = composer2.changedInstance(coroutineScope4);
                Object rememberedValue14 = composer2.rememberedValue();
                if (changedInstance2 || rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState15 = mutableState3;
                    final MutableState mutableState16 = mutableState2;
                    rememberedValue14 = new Function1() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit ReturnFormSheet$lambda$37$0;
                            ReturnFormSheet$lambda$37$0 = ReturnsScreenKt.ReturnFormSheet$lambda$37$0(MutableState.this, coroutineScope4, mutableState14, mutableState5, mutableState6, mutableState16, mutableState15, (String) obj2);
                            return ReturnFormSheet$lambda$37$0;
                        }
                    };
                    coroutineScope2 = coroutineScope4;
                    composer2.updateRememberedValue(rememberedValue14);
                } else {
                    coroutineScope2 = coroutineScope4;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ScannerSheetKt.ScannerSheet(FonRoApp, function03, null, (Function1) rememberedValue14, composer2, FonRoApp.$stable | 48 | (i3 & 14), 4);
                FonRoApp2 = FonRoApp;
                composer2.endReplaceGroup();
            } else {
                FonRoApp2 = FonRoApp;
                coroutineScope2 = coroutineScope4;
                str3 = str2;
                composer2.startReplaceGroup(-1449068552);
                composer2.endReplaceGroup();
            }
            NumPadRequest ReturnFormSheet$lambda$25 = ReturnFormSheet$lambda$25(mutableState12);
            ComposerKt.sourceInformationMarkerStart(composer2, 923087896, str3);
            Object rememberedValue15 = composer2.rememberedValue();
            if (rememberedValue15 == Composer.INSTANCE.getEmpty()) {
                rememberedValue15 = new Function0() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ReturnFormSheet$lambda$38$0;
                        ReturnFormSheet$lambda$38$0 = ReturnsScreenKt.ReturnFormSheet$lambda$38$0(MutableState.this);
                        return ReturnFormSheet$lambda$38$0;
                    }
                };
                composer2.updateRememberedValue(rememberedValue15);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            StockInScreenKt.NumPadHost(ReturnFormSheet$lambda$25, (Function0) rememberedValue15, composer2, NumPadRequest.$stable | 48);
            if (ReturnFormSheet$lambda$28(mutableState13)) {
                composer2.startReplaceGroup(-1449000321);
                ComposerKt.sourceInformation(composer2, "753@29380L12,754@29418L19,747@29022L425");
                String tx = LangKt.tx("Провести возврат?", new Object[0]);
                String transactionId = saleRow != null ? saleRow.getTransactionId() : null;
                if (transactionId == null) {
                    transactionId = "";
                }
                String str4 = LangKt.tx("Чек %s. Позиций: %s. ", transactionId, Integer.valueOf(arrayList2.size())) + LangKt.tx("К возврату %s. ", Fmt.INSTANCE.money(Double.valueOf(Num.INSTANCE.money(d6)), currency)) + LangKt.tx("Товар вернётся на склад.", new Object[0]);
                String tx2 = LangKt.tx("Да, вернуть", new Object[0]);
                ComposerKt.sourceInformationMarkerStart(composer2, 923100726, str3);
                boolean changed = composer2.changed(can) | composer2.changedInstance(saleRow) | composer2.changedInstance(arrayList2) | composer2.changedInstance(coroutineScope2) | composer2.changedInstance(repo3) | ((i3 & 896) == 256);
                Object rememberedValue16 = composer2.rememberedValue();
                if (changed || rememberedValue16 == Composer.INSTANCE.getEmpty()) {
                    final CoroutineScope coroutineScope5 = coroutineScope2;
                    obj = new Function0() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ReturnFormSheet$lambda$39$0;
                            ReturnFormSheet$lambda$39$0 = ReturnsScreenKt.ReturnFormSheet$lambda$39$0(can, saleRow, arrayList2, coroutineScope5, mutableState10, repo3, function0, mutableState7);
                            return ReturnFormSheet$lambda$39$0;
                        }
                    };
                    function02 = function0;
                    composer2.updateRememberedValue(obj);
                } else {
                    obj = rememberedValue16;
                    function02 = function0;
                }
                Function0 function04 = (Function0) obj;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, 923101949, str3);
                Object rememberedValue17 = composer2.rememberedValue();
                if (rememberedValue17 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue17 = new Function0() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ReturnFormSheet$lambda$40$0;
                            ReturnFormSheet$lambda$40$0 = ReturnsScreenKt.ReturnFormSheet$lambda$40$0(MutableState.this);
                            return ReturnFormSheet$lambda$40$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue17);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                SheetsKt.OxConfirmSheet(tx, str4, tx2, null, function04, (Function0) rememberedValue17, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 8);
                composer2 = composer2;
                composer2.endReplaceGroup();
            } else {
                function02 = function0;
                composer2.startReplaceGroup(-1448576520);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ReturnsScreenKt.ReturnFormSheet$lambda$41(FonRoApp.this, str, function02, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final String ReturnFormSheet$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final List<SaleRow> ReturnFormSheet$lambda$4(MutableState<List<SaleRow>> mutableState) {
        return mutableState.getValue();
    }

    private static final Map<Long, Double> ReturnFormSheet$lambda$7(MutableState<Map<Long, Double>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ReturnFormSheet$lambda$10(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ReturnFormSheet$lambda$13(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ReturnFormSheet$lambda$14(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean ReturnFormSheet$lambda$16(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ReturnFormSheet$lambda$17(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean ReturnFormSheet$lambda$19(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ReturnFormSheet$lambda$20(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean ReturnFormSheet$lambda$22(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ReturnFormSheet$lambda$23(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final NumPadRequest ReturnFormSheet$lambda$25(MutableState<NumPadRequest> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ReturnFormSheet$lambda$28(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ReturnFormSheet$lambda$29(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ReturnFormSheet$find(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, MutableState<List<SaleRow>> mutableState2, MutableState<Map<Long, Double>> mutableState3, MutableState<Boolean> mutableState4, String str) {
        String obj = StringsKt.trim((CharSequence) str).toString();
        if (obj.length() == 0) {
            Toaster.INSTANCE.error(LangKt.tx("Введите номер чека", new Object[0]));
        } else {
            if (ReturnFormSheet$lambda$13(mutableState)) {
                return;
            }
            ReturnFormSheet$lambda$14(mutableState, true);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ReturnsScreenKt$ReturnFormSheet$find$1(obj, mutableState2, mutableState3, mutableState4, mutableState, null), 3, null);
        }
    }

    private static final void ReturnFormSheet$submit(boolean z, SaleRow saleRow, List<ReturnLineBody> list, CoroutineScope coroutineScope, MutableState<Boolean> mutableState, Repo repo, Function0<Unit> function0, MutableState<String> mutableState2) {
        if (ReturnFormSheet$lambda$19(mutableState)) {
            return;
        }
        if (!z) {
            Toaster.INSTANCE.error(LangKt.tx("Нет права на возвраты", new Object[0]));
            return;
        }
        String transactionId = saleRow != null ? saleRow.getTransactionId() : null;
        if (transactionId == null) {
            transactionId = "";
        }
        String str = transactionId;
        long saleId = saleRow != null ? saleRow.getSaleId() : 0L;
        if (StringsKt.isBlank(str) || list.isEmpty()) {
            Toaster.INSTANCE.error(LangKt.tx("Укажите количество хотя бы по одной позиции", new Object[0]));
        } else {
            ReturnFormSheet$lambda$20(mutableState, true);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ReturnsScreenKt$ReturnFormSheet$submit$1(saleId, str, list, repo, function0, mutableState2, mutableState, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReturnFormSheet$lambda$34(Function0 function0, double d, boolean z, List list, MutableState mutableState, final MutableState mutableState2, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        String str;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C573@21854L89,576@22080L18,574@21956L348:ReturnsScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-885558409, i2, -1, "uz.FonRo.pos.ui.docs.ReturnFormSheet.<anonymous> (ReturnsScreen.kt:573)");
            }
            BasicsKt.OxButton(LangKt.tx("Отмена", new Object[0]), function0, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.GHOST, null, false, false, null, composer, 3072, 240);
            if (ReturnFormSheet$lambda$19(mutableState)) {
                str = LangKt.tx("Проводим…", new Object[0]);
            } else {
                str = LangKt.tx("Вернуть · ", new Object[0]) + Fmt.INSTANCE.nf(Double.valueOf(Num.INSTANCE.money(d)));
            }
            ComposerKt.sourceInformationMarkerStart(composer, -618098743, "CC(remember):ReturnsScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ReturnFormSheet$lambda$34$0$0;
                        ReturnFormSheet$lambda$34$0$0 = ReturnsScreenKt.ReturnFormSheet$lambda$34$0$0(MutableState.this);
                        return ReturnFormSheet$lambda$34$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function0 function02 = (Function0) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(str, function02, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 2.0f, false, 2, null), BtnStyle.DANGER, BtnSize.LG, (!z || ReturnFormSheet$lambda$19(mutableState) || list.isEmpty()) ? false : true, false, null, composer, 27696, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnFormSheet$lambda$34$0$0(MutableState mutableState) {
        ReturnFormSheet$lambda$29(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit ReturnFormSheet$lambda$35(final CoroutineScope coroutineScope, final SaleRow saleRow, boolean z, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final double d, final MutableState mutableState7, final MutableState mutableState8, final double d2, final String str, ColumnScope OxCardSheet, Composer composer, int i) {
        final MutableState mutableState9;
        Object obj;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z2;
        String str6;
        CoroutineScope coroutineScope2;
        int i2;
        String tx;
        Object obj2;
        String str7;
        String str8;
        String str9;
        boolean z3;
        String str10;
        int i3;
        boolean z4;
        final MutableState mutableState10;
        final MutableState mutableState11;
        final MutableState mutableState12;
        String tx2;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C584@22362L21,584@22331L6362:ReturnsScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1697630418, i, -1, "uz.FonRo.pos.ui.docs.ReturnFormSheet.<anonymous> (ReturnsScreen.kt:584)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1635259872, "C585@22400L43,586@22456L10,587@22479L1403,618@23895L11,621@24010L13,619@23919L206,625@24138L11,728@28672L11:ReturnsScreen.kt#1so789");
            TextKt.m2798Text4IGK_g(LangKt.tx("Найти чек", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getLabel(), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer, 6);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, fillMaxWidth$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 201093566, "C594@22777L50,598@23017L13,592@22699L387,609@23542L19,609@23536L25,601@23103L765:ReturnsScreen.kt#1so789");
            String ReturnFormSheet$lambda$1 = ReturnFormSheet$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, -132059066, "CC(remember):ReturnsScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableState9 = mutableState;
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        Unit ReturnFormSheet$lambda$35$0$0$0$0;
                        ReturnFormSheet$lambda$35$0$0$0$0 = ReturnsScreenKt.ReturnFormSheet$lambda$35$0$0$0$0(MutableState.this, (String) obj3);
                        return ReturnFormSheet$lambda$35$0$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            } else {
                mutableState9 = mutableState;
            }
            Function1 function1 = (Function1) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            String tx3 = LangKt.tx("Номер чека", new Object[0]);
            int m6640getSearcheUduSuo = ImeAction.INSTANCE.m6640getSearcheUduSuo();
            ComposerKt.sourceInformationMarkerStart(composer, -132051423, "CC(remember):ReturnsScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(coroutineScope);
            Object rememberedValue2 = composer.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                str2 = "Найти чек";
                str3 = "CC(remember):ReturnsScreen.kt#9igjgp";
                str4 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                final MutableState mutableState13 = mutableState9;
                str5 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                z2 = true;
                str6 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                obj = new Function0() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ReturnFormSheet$lambda$35$0$0$1$0;
                        ReturnFormSheet$lambda$35$0$0$1$0 = ReturnsScreenKt.ReturnFormSheet$lambda$35$0$0$1$0(MutableState.this, coroutineScope, mutableState2, mutableState3, mutableState4, mutableState5);
                        return ReturnFormSheet$lambda$35$0$0$1$0;
                    }
                };
                coroutineScope2 = coroutineScope;
                composer.updateRememberedValue(obj);
            } else {
                str5 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                str3 = "CC(remember):ReturnsScreen.kt#9igjgp";
                str6 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                str4 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                obj = rememberedValue2;
                z2 = true;
                str2 = "Найти чек";
                coroutineScope2 = coroutineScope;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            String str11 = str2;
            String str12 = str6;
            FieldsKt.m9847OxInputWwzLCwM(ReturnFormSheet$lambda$1, function1, weight$default, tx3, 0, m6640getSearcheUduSuo, (Function0) obj, false, false, false, true, false, null, null, composer, 196656, 6, 15248);
            Modifier m569borderxT4_qwU = BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, OxDim.INSTANCE.m10249getTapD9Ej5fM()), OxShape.INSTANCE.getField()), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10192getCyan0d7_KjU(), 0.14f), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10242tintBorderl2rxGTc(Ox.INSTANCE.m10192getCyan0d7_KjU()), OxShape.INSTANCE.getField());
            String str13 = str3;
            ComposerKt.sourceInformationMarkerStart(composer, -132034617, str13);
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ReturnFormSheet$lambda$35$0$0$2$0;
                        ReturnFormSheet$lambda$35$0$0$2$0 = ReturnsScreenKt.ReturnFormSheet$lambda$35$0$0$2$0(MutableState.this);
                        return ReturnFormSheet$lambda$35$0$0$2$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier oxTap = ModifiersKt.oxTap(m569borderxT4_qwU, false, (Function0) rememberedValue3, composer, 384, 1);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            String str14 = str4;
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, str14);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, oxTap);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            String str15 = str5;
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, str15);
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
            Updater.m3815setimpl(m3808constructorimpl3, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1487153622, "C612@23659L191:ReturnsScreen.kt#1so789");
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getQrCode(), LangKt.tx("Сканировать QR чека", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(21.0f)), Ox.INSTANCE.m10193getCyanDeep0d7_KjU(), composer, 384, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer, 6);
            if (ReturnFormSheet$lambda$13(mutableState2)) {
                i2 = 0;
                tx = LangKt.tx("Ищем…", new Object[0]);
            } else {
                i2 = 0;
                tx = LangKt.tx(str11, new Object[0]);
            }
            String str16 = tx;
            int i4 = (ReturnFormSheet$lambda$13(mutableState2) || StringsKt.isBlank(ReturnFormSheet$lambda$1(mutableState))) ? i2 : 1;
            ComposerKt.sourceInformationMarkerStart(composer, 1609862917, str13);
            boolean changedInstance2 = composer.changedInstance(coroutineScope2);
            Object rememberedValue4 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                str7 = "C101@5232L9:Row.kt#2w3rfo";
                str8 = str12;
                str9 = str14;
                z3 = 693286680;
                final CoroutineScope coroutineScope3 = coroutineScope2;
                str10 = str13;
                i3 = i2;
                z4 = -407735110;
                obj2 = new Function0() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ReturnFormSheet$lambda$35$0$1$0;
                        ReturnFormSheet$lambda$35$0$1$0 = ReturnsScreenKt.ReturnFormSheet$lambda$35$0$1$0(MutableState.this, coroutineScope3, mutableState2, mutableState3, mutableState4, mutableState5);
                        return ReturnFormSheet$lambda$35$0$1$0;
                    }
                };
                mutableState10 = mutableState3;
                composer.updateRememberedValue(obj2);
            } else {
                str7 = "C101@5232L9:Row.kt#2w3rfo";
                str9 = str14;
                z3 = 693286680;
                str10 = str13;
                i3 = i2;
                mutableState10 = mutableState3;
                z4 = -407735110;
                obj2 = rememberedValue4;
                str8 = str12;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            String str17 = str8;
            String str18 = str7;
            BasicsKt.OxButton(str16, (Function0) obj2, null, null, null, i4, true, null, composer, 1572864, 156);
            Composer composer2 = composer;
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(14.0f), composer2, 6);
            if (saleRow == null) {
                composer2.startReplaceGroup(-1633675773);
                ComposerKt.sourceInformation(composer2, "628@24201L295");
                if (ReturnFormSheet$lambda$13(mutableState2)) {
                    tx2 = LangKt.tx("Ищем чек…", new Object[i3]);
                } else {
                    tx2 = ReturnFormSheet$lambda$16(mutableState5) ? LangKt.tx("Чек не найден. Проверьте номер.", new Object[i3]) : LangKt.tx("Введите номер чека или отсканируйте QR-код с чека.", new Object[i3]);
                }
                BasicsKt.OxEmptyNote(tx2, null, composer2, i3, 2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1633227141);
                ComposerKt.sourceInformation(composer2, "636@24562L909,636@24534L937,656@25489L11,657@25517L601,671@26135L10,700@27507L11,704@27659L15,701@27535L305,710@27886L492,710@27858L520");
                String str19 = str10;
                BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(13.0f), null, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-236320242, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj3, Object obj4, Object obj5) {
                        Unit ReturnFormSheet$lambda$35$0$2;
                        ReturnFormSheet$lambda$35$0$2 = ReturnsScreenKt.ReturnFormSheet$lambda$35$0$2(SaleRow.this, d, mutableState10, (ColumnScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                        return ReturnFormSheet$lambda$35$0$2;
                    }
                }, composer2, 54), composer2, 1572912, 61);
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer2, 6);
                Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, str17);
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer2, 48);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str9);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, fillMaxWidth$default2);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str15);
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
                ComposerKt.sourceInformationMarkerStart(composer2, -407735110, str18);
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 830381972, "C661@25685L75,664@25858L172,662@25781L319:ReturnsScreen.kt#1so789");
                TextKt.m2798Text4IGK_g(LangKt.tx("Позиции чека", new Object[0]), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH2(), composer, 0, 0, 65532);
                String tx4 = LangKt.tx("Вернуть всё", new Object[0]);
                ComposerKt.sourceInformationMarkerStart(composer, -111755524, str19);
                Object rememberedValue5 = composer.rememberedValue();
                if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    mutableState11 = mutableState3;
                    mutableState12 = mutableState4;
                    rememberedValue5 = new Function0() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ReturnFormSheet$lambda$35$0$3$0$0;
                            ReturnFormSheet$lambda$35$0$3$0$0 = ReturnsScreenKt.ReturnFormSheet$lambda$35$0$3$0$0(MutableState.this, mutableState12);
                            return ReturnFormSheet$lambda$35$0$3$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue5);
                } else {
                    mutableState11 = mutableState3;
                    mutableState12 = mutableState4;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                BasicsKt.OxButton(tx4, (Function0) rememberedValue5, null, BtnStyle.GHOST, null, false, false, null, composer, 3120, 244);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(4.0f), composer, 6);
                composer.startReplaceGroup(1609933281);
                ComposerKt.sourceInformation(composer, "*680@26476L973,676@26309L1162");
                for (final SaleRow saleRow2 : ReturnFormSheet$lambda$4(mutableState11)) {
                    final double returnableOf = returnableOf(saleRow2);
                    Double d3 = ReturnFormSheet$lambda$7(mutableState12).get(Long.valueOf(saleRow2.getId()));
                    double doubleValue = d3 != null ? d3.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
                    ComposerKt.sourceInformationMarkerStart(composer, -1484138779, str19);
                    boolean changed = composer.changed(returnableOf) | composer.changedInstance(saleRow2) | composer.changed(doubleValue);
                    Object rememberedValue6 = composer.rememberedValue();
                    if (changed || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        final double d4 = doubleValue;
                        final MutableState mutableState14 = mutableState12;
                        rememberedValue6 = new Function0() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit ReturnFormSheet$lambda$35$0$4$0$0;
                                ReturnFormSheet$lambda$35$0$4$0$0 = ReturnsScreenKt.ReturnFormSheet$lambda$35$0$4$0$0(returnableOf, saleRow2, d4, mutableState14, mutableState7);
                                return ReturnFormSheet$lambda$35$0$4$0$0;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ReturnLineRow(saleRow2, returnableOf, doubleValue, (Function0) rememberedValue6, composer, SaleRow.$stable);
                    mutableState12 = mutableState4;
                }
                composer.endReplaceGroup();
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
                String tx5 = LangKt.tx("Причина", new Object[0]);
                String ReturnFormSheet$lambda$10 = ReturnFormSheet$lambda$10(mutableState8);
                ComposerKt.sourceInformationMarkerStart(composer, 1609979687, str19);
                Object rememberedValue7 = composer.rememberedValue();
                if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue7 = new Function1() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            Unit ReturnFormSheet$lambda$35$0$5$0;
                            ReturnFormSheet$lambda$35$0$5$0 = ReturnsScreenKt.ReturnFormSheet$lambda$35$0$5$0(MutableState.this, (String) obj3);
                            return ReturnFormSheet$lambda$35$0$5$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                FieldsKt.m9846OxFieldDfSPO0(tx5, ReturnFormSheet$lambda$10, (Function1) rememberedValue7, null, LangKt.tx("Например: клиент вернул товар", new Object[0]), 0, 0, null, false, false, false, false, false, 240, null, composer, 805306752, 3072, 24040);
                composer2 = composer;
                BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(13.0f), null, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-128872457, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj3, Object obj4, Object obj5) {
                        Unit ReturnFormSheet$lambda$35$0$6;
                        ReturnFormSheet$lambda$35$0$6 = ReturnsScreenKt.ReturnFormSheet$lambda$35$0$6(d2, str, (ColumnScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                        return ReturnFormSheet$lambda$35$0$6;
                    }
                }, composer2, 54), composer2, 1572912, 61);
                if (!z) {
                    composer2.startReplaceGroup(-1629484480);
                    ComposerKt.sourceInformation(composer2, "721@28433L10,722@28464L163");
                    BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer2, 6);
                    TextKt.m2798Text4IGK_g(LangKt.tx("Возвраты доступны сотрудникам с правом «Приём возвратов».", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
                    composer2 = composer;
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-1629259606);
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer2, 6);
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
    public static final Unit ReturnFormSheet$lambda$35$0$0$1$0(MutableState mutableState, CoroutineScope coroutineScope, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5) {
        ReturnFormSheet$find(coroutineScope, mutableState2, mutableState3, mutableState4, mutableState5, ReturnFormSheet$lambda$1(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnFormSheet$lambda$35$0$0$2$0(MutableState mutableState) {
        ReturnFormSheet$lambda$23(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnFormSheet$lambda$35$0$1$0(MutableState mutableState, CoroutineScope coroutineScope, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5) {
        ReturnFormSheet$find(coroutineScope, mutableState2, mutableState3, mutableState4, mutableState5, ReturnFormSheet$lambda$1(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnFormSheet$lambda$35$0$2(SaleRow saleRow, double d, MutableState mutableState, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C637@24584L224,643@24829L10,644@24860L166,648@25047L11,649@25079L374:ReturnsScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-236320242, i, -1, "uz.FonRo.pos.ui.docs.ReturnFormSheet.<anonymous>.<anonymous>.<anonymous> (ReturnsScreen.kt:637)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Чек ", new Object[0]) + saleRow.getTransactionId(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH3(), composer, 0, 3120, 55294);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(2.0f), composer, 6);
            String dt$default = Fmt.dt$default(Fmt.INSTANCE, saleRow.getSoldAt(), false, 2, null);
            String cashierName = saleRow.getCashierName();
            if (cashierName == null) {
                cashierName = LangKt.tx("касса", new Object[0]);
            }
            TextKt.m2798Text4IGK_g(dt$default + " · " + cashierName, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer, 6);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer, 6);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1240311548, "C650@25186L64,651@25275L61,652@25361L70:ReturnsScreen.kt#1so789");
            StockInScreenKt.m9919DocMiniStatuDo3WH8(rowScopeInstance, Fmt.INSTANCE.nf(Double.valueOf(d)), LangKt.tx("Сумма чека", new Object[0]), Ox.INSTANCE.m10193getCyanDeep0d7_KjU(), null, composer, 6, 8);
            StockInScreenKt.m9919DocMiniStatuDo3WH8(rowScopeInstance, String.valueOf(ReturnFormSheet$lambda$4(mutableState).size()), LangKt.tx("Позиций", new Object[0]), Ox.INSTANCE.m10187getBlueDeep0d7_KjU(), null, composer, 6, 8);
            StockInScreenKt.m9919DocMiniStatuDo3WH8(rowScopeInstance, Fmt.INSTANCE.nf(Double.valueOf(saleRow.getDiscountAmount())), LangKt.tx("Скидка", new Object[0]), Ox.INSTANCE.m10215getOrangeInk0d7_KjU(), null, composer, 6, 8);
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
    public static final Unit ReturnFormSheet$lambda$35$0$3$0$0(MutableState mutableState, MutableState mutableState2) {
        List<SaleRow> ReturnFormSheet$lambda$4 = ReturnFormSheet$lambda$4(mutableState);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(ReturnFormSheet$lambda$4, 10)), 16));
        for (SaleRow saleRow : ReturnFormSheet$lambda$4) {
            Pair pair = TuplesKt.to(Long.valueOf(saleRow.getId()), Double.valueOf(returnableOf(saleRow)));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((Number) entry.getValue()).doubleValue() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        mutableState2.setValue(linkedHashMap2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnFormSheet$lambda$35$0$4$0$0(final double d, final SaleRow saleRow, double d2, final MutableState mutableState, MutableState mutableState2) {
        if (d <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            Toaster.INSTANCE.error(LangKt.tx("По этой позиции возвращать нечего", new Object[0]));
        } else {
            mutableState2.setValue(new NumPadRequest(saleRow.getTitle() + LangKt.tx(" — сколько вернуть", new Object[0]), d2, Units.INSTANCE.isMeasurable(saleRow.getUnitCode()), new Function1() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda41
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit ReturnFormSheet$lambda$35$0$4$0$0$0;
                    ReturnFormSheet$lambda$35$0$4$0$0$0 = ReturnsScreenKt.ReturnFormSheet$lambda$35$0$4$0$0$0(d, saleRow, mutableState, ((Double) obj).doubleValue());
                    return ReturnFormSheet$lambda$35$0$4$0$0$0;
                }
            }));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnFormSheet$lambda$35$0$4$0$0$0(double d, SaleRow saleRow, MutableState mutableState, double d2) {
        mutableState.setValue(MapsKt.plus(ReturnFormSheet$lambda$7(mutableState), TuplesKt.to(Long.valueOf(saleRow.getId()), Double.valueOf(Num.INSTANCE.qty(Math.min(Math.max(d2, AudioStats.AUDIO_AMPLITUDE_NONE), d))))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnFormSheet$lambda$35$0$5$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnFormSheet$lambda$35$0$6(double d, String str, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C711@27908L452:ReturnsScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-128872457, i, -1, "uz.FonRo.pos.ui.docs.ReturnFormSheet.<anonymous>.<anonymous>.<anonymous> (ReturnsScreen.kt:711)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1144561815, "C712@28011L80,713@28116L222:ReturnsScreen.kt#1so789");
            TextKt.m2798Text4IGK_g(LangKt.tx("Сумма возврата", new Object[0]), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getLabel(), composer, 0, 0, 65532);
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.money(Double.valueOf(Num.INSTANCE.money(d)), str), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowPrice(), Ox.INSTANCE.m10196getDanger0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 3072, 57342);
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
    public static final Unit ReturnFormSheet$lambda$36$0(MutableState mutableState) {
        ReturnFormSheet$lambda$23(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnFormSheet$lambda$37$0(MutableState mutableState, CoroutineScope coroutineScope, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        mutableState.setValue(code);
        ReturnFormSheet$find(coroutineScope, mutableState2, mutableState3, mutableState4, mutableState5, code);
        ReturnFormSheet$lambda$23(mutableState6, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnFormSheet$lambda$38$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnFormSheet$lambda$39$0(boolean z, SaleRow saleRow, List list, CoroutineScope coroutineScope, MutableState mutableState, Repo repo, Function0 function0, MutableState mutableState2) {
        ReturnFormSheet$submit(z, saleRow, list, coroutineScope, mutableState, repo, function0, mutableState2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnFormSheet$lambda$40$0(MutableState mutableState) {
        ReturnFormSheet$lambda$29(mutableState, false);
        return Unit.INSTANCE;
    }

    private static final void ReturnLineRow(final SaleRow saleRow, final double d, final double d2, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Function0<Unit> function02;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-417608145);
        ComposerKt.sourceInformation(startRestartGroup, "C(ReturnLineRow)P(2!1,3)772@29872L2033,767@29626L2279:ReturnsScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(saleRow) : startRestartGroup.changedInstance(saleRow) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(d) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(d2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function02 = function0;
            i2 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
        } else {
            function02 = function0;
        }
        if (!startRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-417608145, i2, -1, "uz.FonRo.pos.ui.docs.ReturnLineRow (ReturnsScreen.kt:765)");
            }
            final String name = Units.INSTANCE.name(saleRow.getUnitCode());
            final Function0<Unit> function03 = function02;
            composer2 = startRestartGroup;
            BasicsKt.m9833OxSoftCardCe4qNIY(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(9.0f), 7, null), Dp.m6989constructorimpl(12.0f), null, d2 > AudioStats.AUDIO_AMPLITUDE_NONE ? Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10226getRose0d7_KjU(), 0.08f) : Ox.INSTANCE.m10218getPanel20d7_KjU(), d2 > AudioStats.AUDIO_AMPLITUDE_NONE ? Ox.INSTANCE.m10242tintBorderl2rxGTc(Ox.INSTANCE.m10226getRose0d7_KjU()) : Ox.INSTANCE.m10189getBorder0d7_KjU(), null, ComposableLambdaKt.rememberComposableLambda(-1006861335, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ReturnsScreenKt.ReturnLineRow$lambda$0(d2, d, function03, saleRow, name, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), composer2, 1572918, 36);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.ReturnsScreenKt$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ReturnsScreenKt.ReturnLineRow$lambda$1(SaleRow.this, d, d2, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReturnLineRow$lambda$0(double d, double d2, Function0 function0, SaleRow saleRow, String str, ColumnScope OxSoftCard, Composer composer, int i) {
        boolean z;
        String tx;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C773@29882L2017:ReturnsScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1006861335, i, -1, "uz.FonRo.pos.ui.docs.ReturnLineRow.<anonymous> (ReturnsScreen.kt:773)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -72098608, "C778@30083L846,807@31290L48,798@30942L947:ReturnsScreen.kt#1so789");
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, weight$default);
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
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 683464130, "C779@30129L186,785@30332L269,791@30618L297:ReturnsScreen.kt#1so789");
            TextKt.m2798Text4IGK_g(saleRow.getTitle(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), composer, 0, 3120, 55294);
            TextKt.m2798Text4IGK_g(LangKt.tx("Куплено %s %s · уже вернули %s", Fmt.INSTANCE.qf(Double.valueOf(saleRow.getQuantity())), str, Fmt.INSTANCE.qf(Double.valueOf(saleRow.getReturnedQuantity()))), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 0, 3120, 55294);
            if (d2 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                tx = LangKt.tx("Доступно к возврату: %s %s", Fmt.INSTANCE.qf(Double.valueOf(d2)), str);
                z = false;
            } else {
                z = false;
                tx = LangKt.tx("Всё возвращено", new Object[0]);
            }
            TextStyle rowSub = OxType.INSTANCE.getRowSub();
            Ox ox = Ox.INSTANCE;
            TextKt.m2798Text4IGK_g(tx, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(rowSub, d2 > AudioStats.AUDIO_AMPLITUDE_NONE ? ox.m10211getOk0d7_KjU() : ox.m10196getDanger0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 3072, 57342);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, OxShape.INSTANCE.getTileSm()), Ox.INSTANCE.m10217getPanel0d7_KjU(), null, 2, null);
            float m6989constructorimpl = Dp.m6989constructorimpl(1.5f);
            Ox ox2 = Ox.INSTANCE;
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(SizeKt.m1084heightInVpY3zN4$default(ModifiersKt.oxTap(BorderKt.m569borderxT4_qwU(m558backgroundbw27NRU$default, m6989constructorimpl, d > AudioStats.AUDIO_AMPLITUDE_NONE ? ox2.m10242tintBorderl2rxGTc(Ox.INSTANCE.m10226getRose0d7_KjU()) : ox2.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getTileSm()), d2 > AudioStats.AUDIO_AMPLITUDE_NONE, function0, composer, 0, 0), Dp.m6989constructorimpl(54.0f), 0.0f, 2, null), Dp.m6989constructorimpl(14.0f), Dp.m6989constructorimpl(8.0f));
            Alignment.Horizontal end = Alignment.INSTANCE.getEnd();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(center, end, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, m1050paddingVpY3zN4);
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
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 498171119, "C813@31591L80,814@31688L187:ReturnsScreen.kt#1so789");
            TextKt.m2798Text4IGK_g(LangKt.tx("Вернуть", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getTileLabel(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 3072, 57342);
            String qf = Fmt.INSTANCE.qf(Double.valueOf(d));
            TextStyle statValue = OxType.INSTANCE.getStatValue();
            Ox ox3 = Ox.INSTANCE;
            TextKt.m2798Text4IGK_g(qf, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(statValue, d > AudioStats.AUDIO_AMPLITUDE_NONE ? ox3.m10196getDanger0d7_KjU() : ox3.m10200getDim20d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 3072, 57342);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
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

    private static final SyncData ReturnsScreen$lambda$0(State<SyncData> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnFormSheet$lambda$35$0$0$0$0(MutableState mutableState, String raw) {
        Intrinsics.checkNotNullParameter(raw, "raw");
        String str = raw;
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (!CharsKt.isWhitespace(charAt)) {
                sb.append(charAt);
            }
        }
        mutableState.setValue(sb.toString());
        return Unit.INSTANCE;
    }
}
