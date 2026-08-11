package uz.FonRo.pos.ui.docs;

import androidx.camera.video.AudioStats;
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
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
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
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
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
import uz.FonRo.pos.core.Num;
import uz.FonRo.pos.core.Units;
import uz.FonRo.pos.data.local.CacheStore;
import uz.FonRo.pos.data.model.Category;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.model.Supplier;
import uz.FonRo.pos.data.model.SupplierReturnDoc;
import uz.FonRo.pos.data.model.SupplierReturnItem;
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
import uz.FonRo.pos.ui.components.NumpadKt;
import uz.FonRo.pos.ui.components.PeriodKind;
import uz.FonRo.pos.ui.components.PeriodState;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.nav.Routes;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: SupplierReturnsScreen.kt */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0006\u001a\u0016\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u000e\u001aM\u0010\u000f\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0018\u001ac\u0010\u0019\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u001d\u001aÙ\u0001\u0010\u001e\u001a\u00020\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0 2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172h\u0010'\u001ad\u0012\u0015\u0012\u0013\u0018\u00010%¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020.0 ¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00010(H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u00100¨\u0006\u0002²\u0006\u0010\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u008a\u0084\u0002²\u0006\u0010\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0 X\u008a\u0084\u0002²\u0006\u0010\u0010$\u001a\b\u0012\u0004\u0012\u00020%0 X\u008a\u0084\u0002²\u0006\f\u00101\u001a\u0004\u0018\u000102X\u008a\u0084\u0002²\u0006\n\u00103\u001a\u000204X\u008a\u008e\u0002²\u0006\n\u00105\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u00106\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u00107\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\f\u00108\u001a\u0004\u0018\u00010\u0010X\u008a\u008e\u0002²\u0006\f\u00109\u001a\u0004\u0018\u00010\u0010X\u008a\u008e\u0002²\u0006\n\u0010&\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\f\u0010+\u001a\u0004\u0018\u00010%X\u008a\u008e\u0002²\u0006\n\u0010,\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010-\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010:\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010;\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\f\u0010<\u001a\u0004\u0018\u00010!X\u008a\u008e\u0002"}, d2 = {"SupplierReturnsScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "pushSupplierReturn", "doc", "Luz/FonRo/pos/data/model/SupplierReturnPush;", "(Luz/FonRo/pos/data/model/SupplierReturnPush;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SupplierReturnRow", "Luz/FonRo/pos/data/model/SupplierReturnDoc;", FirebaseAnalytics.Param.CURRENCY, "", "supplierName", "showCost", "", "onClick", "Lkotlin/Function0;", "(Luz/FonRo/pos/data/model/SupplierReturnDoc;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SupplierReturnDetailSheet", "canCancel", "onCancelAsk", "onDismiss", "(Luz/FonRo/pos/data/model/SupplierReturnDoc;Ljava/lang/String;Ljava/lang/String;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SupplierReturnCreateSheet", CacheStore.PRODUCTS, "", "Luz/FonRo/pos/data/model/Product;", CacheStore.CATEGORIES, "Luz/FonRo/pos/data/model/Category;", Routes.SUPPLIERS, "Luz/FonRo/pos/data/model/Supplier;", "busy", "onSubmit", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "supplier", "compensation", "reason", "Luz/FonRo/pos/ui/docs/SupplierReturnLine;", "lines", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "sync", "Luz/FonRo/pos/data/model/SyncData;", TypedValues.CycleType.S_WAVE_PERIOD, "Luz/FonRo/pos/ui/components/PeriodState;", "monthSheet", "daySheet", "createOpen", "detail", "cancelAsk", "supplierPicker", "picker", "qtyFor"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class SupplierReturnsScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SupplierReturnCreateSheet$lambda$27(List list, List list2, List list3, String str, boolean z, boolean z2, Function0 function0, Function4 function4, int i, Composer composer, int i2) {
        SupplierReturnCreateSheet(list, list2, list3, str, z, z2, function0, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SupplierReturnDetailSheet$lambda$2(SupplierReturnDoc supplierReturnDoc, String str, String str2, boolean z, boolean z2, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        SupplierReturnDetailSheet(supplierReturnDoc, str, str2, z, z2, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SupplierReturnRow$lambda$1(SupplierReturnDoc supplierReturnDoc, String str, String str2, boolean z, Function0 function0, int i, Composer composer, int i2) {
        SupplierReturnRow(supplierReturnDoc, str, str2, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SupplierReturnsScreen$lambda$42(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        SupplierReturnsScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0649  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x06b5  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x074c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0804  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x088d  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x087e  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x075d  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x06c2  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x06a6  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0638  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02bd A[LOOP:1: B:68:0x02b7->B:70:0x02bd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02d8 A[LOOP:2: B:73:0x02d2->B:75:0x02d8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0469  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SupplierReturnsScreen(final uz.FonRo.pos.FonRoApp r49, final uz.FonRo.pos.ui.nav.AppNavigator r50, androidx.compose.runtime.Composer r51, final int r52) {
        /*
            Method dump skipped, instructions count: 2217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt.SupplierReturnsScreen(uz.FonRo.pos.FonRoApp, uz.FonRo.pos.ui.nav.AppNavigator, androidx.compose.runtime.Composer, int):void");
    }

    private static final PeriodState SupplierReturnsScreen$lambda$5(MutableState<PeriodState> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean SupplierReturnsScreen$lambda$8(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void SupplierReturnsScreen$lambda$9(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean SupplierReturnsScreen$lambda$11(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void SupplierReturnsScreen$lambda$12(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean SupplierReturnsScreen$lambda$14(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SupplierReturnsScreen$lambda$15(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final SupplierReturnDoc SupplierReturnsScreen$lambda$17(MutableState<SupplierReturnDoc> mutableState) {
        return mutableState.getValue();
    }

    private static final SupplierReturnDoc SupplierReturnsScreen$lambda$20(MutableState<SupplierReturnDoc> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean SupplierReturnsScreen$lambda$23(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SupplierReturnsScreen$lambda$24(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SupplierReturnsScreen$supplierName(State<? extends List<Supplier>> state, SupplierReturnDoc supplierReturnDoc) {
        String name;
        String supplierName = supplierReturnDoc.getSupplierName();
        Object obj = null;
        if (supplierName != null) {
            if (StringsKt.isBlank(supplierName)) {
                supplierName = null;
            }
            if (supplierName != null) {
                return supplierName;
            }
        }
        Iterator<T> it = SupplierReturnsScreen$lambda$2(state).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((Supplier) next).getId() == supplierReturnDoc.getSupplierId()) {
                obj = next;
                break;
            }
        }
        Supplier supplier = (Supplier) obj;
        return (supplier == null || (name = supplier.getName()) == null) ? LangKt.tx("Без поставщика", new Object[0]) : name;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnsScreen$lambda$33$0$0(MutableState mutableState, PeriodState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnsScreen$lambda$33$1$0(MutableState mutableState) {
        SupplierReturnsScreen$lambda$9(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnsScreen$lambda$33$2$0(MutableState mutableState) {
        SupplierReturnsScreen$lambda$12(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnsScreen$lambda$33$3(boolean z, double d, String str, double d2, boolean z2, boolean z3, List list, State state, final MutableState mutableState, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C195@8124L148,199@8285L261,205@8559L11,206@8583L344:SupplierReturnsScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(158279281, i, -1, "uz.FonRo.pos.ui.docs.SupplierReturnsScreen.<anonymous>.<anonymous> (SupplierReturnsScreen.kt:195)");
            }
            TextKt.m2798Text4IGK_g(z ? LangKt.tx("Возвращено поставщикам", new Object[0]) : LangKt.tx("Возвращено единиц", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getLabel(), composer, 0, 0, 65534);
            Fmt fmt = Fmt.INSTANCE;
            TextKt.m2798Text4IGK_g(z ? fmt.money(Double.valueOf(d), str) : fmt.qf(Double.valueOf(d2)), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getAmount(), Ox.INSTANCE.m10215getOrangeInk0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 3120, 55294);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1057782073, "C207@8682L65,208@8764L61,209@8842L71:SupplierReturnsScreen.kt#1so789");
            StockInScreenKt.m9919DocMiniStatuDo3WH8(rowScopeInstance, String.valueOf(list.size()), LangKt.tx("Документов", new Object[0]), Ox.INSTANCE.m10215getOrangeInk0d7_KjU(), null, composer, 6, 8);
            StockInScreenKt.m9919DocMiniStatuDo3WH8(rowScopeInstance, Fmt.INSTANCE.qf(Double.valueOf(d2)), LangKt.tx("Единиц", new Object[0]), Ox.INSTANCE.m10193getCyanDeep0d7_KjU(), null, composer, 6, 8);
            StockInScreenKt.m9919DocMiniStatuDo3WH8(rowScopeInstance, String.valueOf(SupplierReturnsScreen$lambda$2(state).size()), LangKt.tx("Поставщиков", new Object[0]), Ox.INSTANCE.m10202getGreenDeep0d7_KjU(), null, composer, 6, 8);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (z2 && z3) {
                composer.startReplaceGroup(-575165587);
                ComposerKt.sourceInformation(composer, "212@8986L11,215@9090L21,213@9014L392");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
                String tx = LangKt.tx("Возврат поставщику", new Object[0]);
                BtnStyle btnStyle = BtnStyle.PRIMARY;
                BtnSize btnSize = BtnSize.LG;
                ComposerKt.sourceInformationMarkerStart(composer, 1782565062, "CC(remember):SupplierReturnsScreen.kt#9igjgp");
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SupplierReturnsScreen$lambda$33$3$1$0;
                            SupplierReturnsScreen$lambda$33$3$1$0 = SupplierReturnsScreenKt.SupplierReturnsScreen$lambda$33$3$1$0(MutableState.this);
                            return SupplierReturnsScreen$lambda$33$3$1$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                BasicsKt.OxButton(tx, (Function0) rememberedValue, null, btnStyle, btnSize, false, true, ComposableSingletons$SupplierReturnsScreenKt.INSTANCE.m9884getLambda$36148325$app(), composer, 14183472, 36);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-574731215);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnsScreen$lambda$33$3$1$0(MutableState mutableState) {
        SupplierReturnsScreen$lambda$15(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnsScreen$lambda$33$4$0(boolean z, final List list, final String str, final boolean z2, final State state, final MutableState mutableState, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        if (!z) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$SupplierReturnsScreenKt.INSTANCE.getLambda$1633014171$app(), 3, null);
        } else if (list.isEmpty()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$SupplierReturnsScreenKt.INSTANCE.m9885getLambda$533313596$app(), 3, null);
        } else {
            final Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object SupplierReturnsScreen$lambda$33$4$0$0;
                    SupplierReturnsScreen$lambda$33$4$0$0 = SupplierReturnsScreenKt.SupplierReturnsScreen$lambda$33$4$0$0((SupplierReturnDoc) obj);
                    return SupplierReturnsScreen$lambda$33$4$0$0;
                }
            };
            final SupplierReturnsScreenKt$SupplierReturnsScreen$lambda$33$4$0$$inlined$items$default$1 supplierReturnsScreenKt$SupplierReturnsScreen$lambda$33$4$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$SupplierReturnsScreen$lambda$33$4$0$$inlined$items$default$1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(SupplierReturnDoc supplierReturnDoc) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((SupplierReturnDoc) obj);
                }
            };
            LazyColumn.items(list.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$SupplierReturnsScreen$lambda$33$4$0$$inlined$items$default$2
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
            }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$SupplierReturnsScreen$lambda$33$4$0$$inlined$items$default$3
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
            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$SupplierReturnsScreen$lambda$33$4$0$$inlined$items$default$4
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
                    String SupplierReturnsScreen$supplierName;
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
                    final SupplierReturnDoc supplierReturnDoc = (SupplierReturnDoc) list.get(i);
                    composer.startReplaceGroup(-672887756);
                    ComposerKt.sourceInformation(composer, "C*246@10327L16,241@10088L277:SupplierReturnsScreen.kt#1so789");
                    String str2 = str;
                    SupplierReturnsScreen$supplierName = SupplierReturnsScreenKt.SupplierReturnsScreen$supplierName(state, supplierReturnDoc);
                    boolean z3 = z2;
                    ComposerKt.sourceInformationMarkerStart(composer, -298793334, "CC(remember):SupplierReturnsScreen.kt#9igjgp");
                    boolean changedInstance = composer.changedInstance(supplierReturnDoc);
                    Object rememberedValue = composer.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        final MutableState mutableState2 = mutableState;
                        rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$SupplierReturnsScreen$2$5$1$2$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                mutableState2.setValue(SupplierReturnDoc.this);
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    SupplierReturnsScreenKt.SupplierReturnRow(supplierReturnDoc, str2, SupplierReturnsScreen$supplierName, z3, (Function0) rememberedValue, composer, SupplierReturnDoc.$stable);
                    composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SupplierReturnsScreen$lambda$33$4$0$0(SupplierReturnDoc it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnsScreen$lambda$34$0(MutableState mutableState) {
        SupplierReturnsScreen$lambda$9(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnsScreen$lambda$35$0(MutableState mutableState, MutableState mutableState2, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(PeriodState.copy$default(SupplierReturnsScreen$lambda$5(mutableState), PeriodKind.MONTH, it, null, 4, null));
        SupplierReturnsScreen$lambda$9(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnsScreen$lambda$36$0(MutableState mutableState) {
        SupplierReturnsScreen$lambda$12(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnsScreen$lambda$37$0(MutableState mutableState, MutableState mutableState2, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(PeriodState.copy$default(SupplierReturnsScreen$lambda$5(mutableState), PeriodKind.DATE, null, it, 2, null));
        SupplierReturnsScreen$lambda$12(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnsScreen$lambda$38$0$0(SupplierReturnDoc supplierReturnDoc, MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(null);
        mutableState2.setValue(supplierReturnDoc);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnsScreen$lambda$38$1$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnsScreen$lambda$39$0$0(SupplierReturnDoc supplierReturnDoc, CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, Repo repo) {
        mutableState.setValue(null);
        if (SupplierReturnsScreen$lambda$23(mutableState2)) {
            return Unit.INSTANCE;
        }
        SupplierReturnsScreen$lambda$24(mutableState2, true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SupplierReturnsScreenKt$SupplierReturnsScreen$8$1$1$1(supplierReturnDoc, repo, mutableState2, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnsScreen$lambda$39$1$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnsScreen$lambda$40$0(MutableState mutableState) {
        SupplierReturnsScreen$lambda$15(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnsScreen$lambda$41$0(CoroutineScope coroutineScope, MutableState mutableState, Repo repo, MutableState mutableState2, Supplier supplier, String compensation, String reason, List lines) {
        Intrinsics.checkNotNullParameter(compensation, "compensation");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(lines, "lines");
        if (SupplierReturnsScreen$lambda$23(mutableState)) {
            return Unit.INSTANCE;
        }
        SupplierReturnsScreen$lambda$24(mutableState, true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SupplierReturnsScreenKt$SupplierReturnsScreen$10$1$1(supplier, reason, compensation, lines, repo, mutableState2, mutableState, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object pushSupplierReturn(uz.FonRo.pos.data.model.SupplierReturnPush r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            boolean r0 = r14 instanceof uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$pushSupplierReturn$1
            if (r0 == 0) goto L14
            r0 = r14
            uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$pushSupplierReturn$1 r0 = (uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$pushSupplierReturn$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$pushSupplierReturn$1 r0 = new uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$pushSupplierReturn$1
            r0.<init>(r14)
        L19:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r13 = r0.L$1
            uz.FonRo.pos.data.net.ApiClient r13 = (uz.FonRo.pos.data.net.ApiClient) r13
            java.lang.Object r0 = r0.L$0
            uz.FonRo.pos.data.model.SupplierReturnPush r0 = (uz.FonRo.pos.data.model.SupplierReturnPush) r0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L69
        L32:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L3a:
            kotlin.ResultKt.throwOnFailure(r14)
            uz.FonRo.pos.data.net.ApiClient r14 = uz.FonRo.pos.data.net.ApiClient.INSTANCE
            uz.FonRo.pos.data.net.ApiClient r2 = uz.FonRo.pos.data.net.ApiClient.INSTANCE
            uz.FonRo.pos.data.net.ApiService r2 = r2.api()
            uz.FonRo.pos.data.model.SyncPushBody r4 = new uz.FonRo.pos.data.model.SyncPushBody
            java.util.List r8 = kotlin.collections.CollectionsKt.listOf(r13)
            r10 = 23
            r11 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r9 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r0.L$0 = r13
            r0.L$1 = r14
            r0.label = r3
            java.lang.Object r13 = r2.syncPush(r4, r0)
            if (r13 != r1) goto L66
            return r1
        L66:
            r12 = r14
            r14 = r13
            r13 = r12
        L69:
            retrofit2.Response r14 = (retrofit2.Response) r14
            r0 = 2
            r1 = 0
            r2 = 0
            kotlinx.serialization.json.JsonElement r13 = uz.FonRo.pos.data.net.ApiClient.unwrapRaw$default(r13, r14, r1, r0, r2)
            java.lang.String r14 = uz.FonRo.pos.ui.docs.StockInScreenKt.rejectedReason(r13)
            if (r14 != 0) goto La0
            uz.FonRo.pos.data.net.ApiClient r14 = uz.FonRo.pos.data.net.ApiClient.INSTANCE
            java.lang.String r0 = "accepted"
            kotlinx.serialization.json.JsonElement r13 = r14.field(r13, r0)
            boolean r14 = r13 instanceof kotlinx.serialization.json.JsonArray
            if (r14 == 0) goto L87
            r2 = r13
            kotlinx.serialization.json.JsonArray r2 = (kotlinx.serialization.json.JsonArray) r2
        L87:
            if (r2 == 0) goto L92
            boolean r13 = r2.isEmpty()
            if (r13 != 0) goto L92
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L92:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "Возврат поставщику появится после обновления серверной части."
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r14 = uz.FonRo.pos.core.LangKt.tx(r14, r0)
            r13.<init>(r14)
            throw r13
        La0:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt.pushSupplierReturn(uz.FonRo.pos.data.model.SupplierReturnPush, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SupplierReturnRow(final SupplierReturnDoc supplierReturnDoc, final String str, final String str2, final boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(882805070);
        ComposerKt.sourceInformation(startRestartGroup, "C(SupplierReturnRow)P(1!1,4,3)393@16217L1925,393@16130L2012:SupplierReturnsScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(supplierReturnDoc) : startRestartGroup.changedInstance(supplierReturnDoc) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(str2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if (!startRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(882805070, i2, -1, "uz.FonRo.pos.ui.docs.SupplierReturnRow (SupplierReturnsScreen.kt:392)");
            }
            BasicsKt.m9829OxCardEOp_iR4(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(9.0f), 7, null), Dp.m6989constructorimpl(12.0f), 0L, null, function0, ComposableLambdaKt.rememberComposableLambda(1914161907, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SupplierReturnsScreenKt.SupplierReturnRow$lambda$0(str2, supplierReturnDoc, z, str, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, (57344 & i2) | 196662, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SupplierReturnsScreenKt.SupplierReturnRow$lambda$1(SupplierReturnDoc.this, str, str2, z, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SupplierReturnRow$lambda$0(String str, SupplierReturnDoc supplierReturnDoc, boolean z, String str2, ColumnScope OxCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCard, "$this$OxCard");
        ComposerKt.sourceInformation(composer, "C394@16227L1909:SupplierReturnsScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1914161907, i, -1, "uz.FonRo.pos.ui.docs.SupplierReturnRow.<anonymous> (SupplierReturnsScreen.kt:394)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(11.0f));
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
            ComposerKt.sourceInformationMarkerStart(composer, 1243692914, "C399@16428L253,405@16694L781,425@17488L638:SupplierReturnsScreen.kt#1so789");
            BasicsKt.m9834OxThumbPZHvWI(null, Dp.m6989constructorimpl(42.0f), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10213getOrange0d7_KjU(), 0.16f), ComposableSingletons$SupplierReturnsScreenKt.INSTANCE.getLambda$551740903$app(), composer, 3120, 1);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1940171239, "C406@16740L189,412@16946L243,418@17206L255:SupplierReturnsScreen.kt#1so789");
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), composer, 0, 3120, 55294);
            String dt$default = Fmt.dt$default(Fmt.INSTANCE, supplierReturnDoc.getCreatedAt(), false, 2, null);
            String createdByName = supplierReturnDoc.getCreatedByName();
            if (createdByName == null) {
                createdByName = LangKt.tx("возврат", new Object[0]);
            }
            TextKt.m2798Text4IGK_g(dt$default + " · " + createdByName, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 0, 3120, 55294);
            TextKt.m2798Text4IGK_g(SupplierReturnCompensation.INSTANCE.title(supplierReturnDoc.getCompensationType()), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowSub(), Ox.INSTANCE.m10193getCyanDeep0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 3120, 55294);
            Composer composer2 = composer;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Alignment.Horizontal end = Alignment.INSTANCE.getEnd();
            ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), end, composer2, 48);
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
            Updater.m3815setimpl(m3808constructorimpl3, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1486778353, "C434@17877L235:SupplierReturnsScreen.kt#1so789");
            if (z) {
                composer2.startReplaceGroup(-1486772712);
                ComposerKt.sourceInformation(composer2, "427@17586L225,432@17832L10");
                TextKt.m2798Text4IGK_g(Fmt.INSTANCE.money(Double.valueOf(supplierReturnDoc.getAmount()), str2), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowPrice(), supplierReturnDoc.isCanceled() ? Ox.INSTANCE.m10200getDim20d7_KjU() : Ox.INSTANCE.m10233getText0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 3072, 57342);
                composer2 = composer;
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(4.0f), composer2, 6);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1486488256);
                composer2.endReplaceGroup();
            }
            BasicsKt.OxChip(supplierReturnDoc.isCanceled() ? LangKt.tx("отменён", new Object[0]) : LangKt.tx("−%s · %s поз.", Fmt.INSTANCE.qf(Double.valueOf(supplierReturnDoc.getQuantity())), Integer.valueOf(supplierReturnDoc.getItems().size())), supplierReturnDoc.isCanceled() ? ChipTone.DIM : ChipTone.WARN, null, composer2, 0, 4);
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

    private static final void SupplierReturnDetailSheet(final SupplierReturnDoc supplierReturnDoc, final String str, final String str2, final boolean z, final boolean z2, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1487989966);
        ComposerKt.sourceInformation(startRestartGroup, "C(SupplierReturnDetailSheet)P(2,1,6,5)457@18520L528,475@19055L2245,454@18383L2917:SupplierReturnsScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(supplierReturnDoc) : startRestartGroup.changedInstance(supplierReturnDoc) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(str2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 1048576 : 524288;
        }
        if (!startRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1487989966, i2, -1, "uz.FonRo.pos.ui.docs.SupplierReturnDetailSheet (SupplierReturnsScreen.kt:453)");
            }
            SheetsKt.OxCardSheet(LangKt.tx("Возврат · ", new Object[0]) + Fmt.INSTANCE.dt(supplierReturnDoc.getCreatedAt(), false), function02, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(772560997, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SupplierReturnsScreenKt.SupplierReturnDetailSheet$lambda$0(z2, function0, function02, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-267119026, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SupplierReturnsScreenKt.SupplierReturnDetailSheet$lambda$1(str2, supplierReturnDoc, z, str, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 >> 15) & 112) | 14155776, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SupplierReturnsScreenKt.SupplierReturnDetailSheet$lambda$2(SupplierReturnDoc.this, str, str2, z, z2, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SupplierReturnDetailSheet$lambda$0(boolean z, Function0 function0, Function0 function02, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C467@18833L205:SupplierReturnsScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(772560997, i2, -1, "uz.FonRo.pos.ui.docs.SupplierReturnDetailSheet.<anonymous> (SupplierReturnsScreen.kt:458)");
            }
            if (z) {
                composer.startReplaceGroup(-1365040466);
                ComposerKt.sourceInformation(composer, "459@18567L239");
                BasicsKt.OxButton(LangKt.tx("Отменить возврат", new Object[0]), function0, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.DANGER, BtnSize.LG, false, false, null, composer, 27648, 224);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2 = composer;
                composer2.startReplaceGroup(-1364780035);
                composer2.endReplaceGroup();
            }
            BasicsKt.OxButton(LangKt.tx("Закрыть", new Object[0]), function02, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, false, false, null, composer2, 27648, 224);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SupplierReturnDetailSheet$lambda$1(String str, SupplierReturnDoc supplierReturnDoc, boolean z, String str2, ColumnScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C476@19096L21,476@19065L2229:SupplierReturnsScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-267119026, i, -1, "uz.FonRo.pos.ui.docs.SupplierReturnDetailSheet.<anonymous> (SupplierReturnsScreen.kt:476)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 2117459673, "C477@19134L38,478@19185L82,480@19367L47,481@19427L49,482@19489L43,494@19897L11,495@19921L47,496@19981L10,524@21273L11:SupplierReturnsScreen.kt#1so789");
            String str3 = "C89@4556L9:Column.kt#2w3rfo";
            StockInScreenKt.m9918DocLineFNF3uiM(LangKt.tx("Поставщик", new Object[0]), str, 0L, composer, 0, 4);
            StockInScreenKt.m9918DocLineFNF3uiM(LangKt.tx("Компенсация", new Object[0]), SupplierReturnCompensation.INSTANCE.title(supplierReturnDoc.getCompensationType()), 0L, composer, 0, 4);
            String reason = supplierReturnDoc.getReason();
            if (reason == null || StringsKt.isBlank(reason)) {
                reason = null;
            }
            if (reason == null) {
                composer.startReplaceGroup(2117578587);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(2117578588);
                ComposerKt.sourceInformation(composer, "*479@19326L26");
                StockInScreenKt.m9918DocLineFNF3uiM(LangKt.tx("Причина", new Object[0]), reason, 0L, composer, 0, 4);
                Unit unit = Unit.INSTANCE;
                composer.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            String tx = LangKt.tx("Провёл", new Object[0]);
            String createdByName = supplierReturnDoc.getCreatedByName();
            if (createdByName == null) {
                createdByName = "—";
            }
            StockInScreenKt.m9918DocLineFNF3uiM(tx, createdByName, 0L, composer, 0, 4);
            StockInScreenKt.m9918DocLineFNF3uiM(LangKt.tx("Позиций", new Object[0]), String.valueOf(supplierReturnDoc.getItems().size()), 0L, composer, 0, 4);
            StockInScreenKt.m9918DocLineFNF3uiM(LangKt.tx("Единиц", new Object[0]), Fmt.INSTANCE.qf(Double.valueOf(supplierReturnDoc.getQuantity())), 0L, composer, 0, 4);
            if (z) {
                composer.startReplaceGroup(2117820791);
                ComposerKt.sourceInformation(composer, "484@19577L167");
                StockInScreenKt.m9918DocLineFNF3uiM(LangKt.tx("Сумма возврата", new Object[0]), Fmt.INSTANCE.money(Double.valueOf(supplierReturnDoc.getAmount()), str2), Ox.INSTANCE.m10215getOrangeInk0d7_KjU(), composer, 0, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(2118012030);
                composer.endReplaceGroup();
            }
            if (supplierReturnDoc.isCanceled()) {
                composer.startReplaceGroup(2118047618);
                ComposerKt.sourceInformation(composer, "491@19809L60");
                StockInScreenKt.m9918DocLineFNF3uiM(LangKt.tx("Статус", new Object[0]), LangKt.tx("отменён", new Object[0]), Ox.INSTANCE.m10196getDanger0d7_KjU(), composer, 0, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(2118136030);
                composer.endReplaceGroup();
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            String str4 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            String str5 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            String str6 = "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo";
            TextKt.m2798Text4IGK_g(LangKt.tx("Состав документа", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH2(), composer, 0, 0, 65534);
            Composer composer2 = composer;
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer2, 6);
            composer2.startReplaceGroup(-624404340);
            ComposerKt.sourceInformation(composer2, "*498@20048L1084,521@21149L11");
            for (SupplierReturnItem supplierReturnItem : supplierReturnDoc.getItems()) {
                Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(7.0f), 1, null);
                Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, composer2, 54);
                String str7 = str4;
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str7);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, m1051paddingVpY3zN4$default);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                String str8 = str5;
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str8);
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
                ComposerKt.sourceInformationMarkerStart(composer2, 714352629, "C503@20314L653:SupplierReturnsScreen.kt#1so789");
                Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                String str9 = str6;
                ComposerKt.sourceInformationMarkerStart(composer2, -483455358, str9);
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str7);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, weight$default);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str8);
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
                String str10 = str3;
                ComposerKt.sourceInformationMarkerStart(composer2, -384672921, str10);
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 1164800874, "C504@20368L248,510@20641L304:SupplierReturnsScreen.kt#1so789");
                String productName = supplierReturnItem.getProductName();
                if (productName == null) {
                    productName = LangKt.tx("Товар", new Object[0]);
                }
                str4 = str7;
                str3 = str10;
                str5 = str8;
                TextKt.m2798Text4IGK_g(productName, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), composer, 0, 3120, 55294);
                TextKt.m2798Text4IGK_g(Fmt.INSTANCE.qf(Double.valueOf(supplierReturnItem.getQuantity())) + " " + Units.INSTANCE.name(supplierReturnItem.getProductUnit()) + (z ? " × " + Fmt.INSTANCE.nf(Double.valueOf(supplierReturnItem.getPurchasePrice())) : ""), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 0, 3072, 57342);
                Composer composer3 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (z) {
                    composer3.startReplaceGroup(715038100);
                    ComposerKt.sourceInformation(composer3, "518@21028L64");
                    TextKt.m2798Text4IGK_g(Fmt.INSTANCE.nf(Double.valueOf(supplierReturnItem.getAmount())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowPrice(), composer, 0, 3072, 57342);
                    composer3 = composer;
                    composer3.endReplaceGroup();
                } else {
                    composer3.startReplaceGroup(715121428);
                    composer3.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                BasicsKt.m9830OxDivideriPRSM58(0L, 0.0f, composer, 0, 3);
                composer2 = composer;
                str6 = str9;
            }
            composer2.endReplaceGroup();
            if (supplierReturnDoc.getItems().isEmpty()) {
                composer2.startReplaceGroup(-624367116);
                ComposerKt.sourceInformation(composer2, "523@21212L48");
                BasicsKt.OxEmptyNote(LangKt.tx("Позиции не переданы сервером.", new Object[0]), null, composer2, 0, 2);
            } else {
                composer2.startReplaceGroup(2119502014);
            }
            composer2.endReplaceGroup();
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

    private static final void SupplierReturnCreateSheet(final List<Product> list, final List<Category> list2, final List<Supplier> list3, final String str, final boolean z, final boolean z2, final Function0<Unit> function0, final Function4<? super Supplier, ? super String, ? super String, ? super List<SupplierReturnLine>, Unit> function4, Composer composer, final int i) {
        Function4<? super Supplier, ? super String, ? super String, ? super List<SupplierReturnLine>, Unit> function42;
        MutableState mutableState;
        SnapshotStateList snapshotStateList;
        String str2;
        double d;
        Object obj;
        Object obj2;
        Composer startRestartGroup = composer.startRestartGroup(-1441220906);
        ComposerKt.sourceInformation(startRestartGroup, "C(SupplierReturnCreateSheet)P(5,1,7,2,6)550@21890L44,551@21959L67,552@22045L31,553@22093L53,554@22173L34,555@22226L34,556@22279L43,563@22498L599,577@23104L3439,560@22395L4148:SupplierReturnsScreen.kt#1so789");
        int i2 = (i & 6) == 0 ? ((i & 8) == 0 ? startRestartGroup.changed(list) : startRestartGroup.changedInstance(list) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(list2) : startRestartGroup.changedInstance(list2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? startRestartGroup.changed(list3) : startRestartGroup.changedInstance(list3) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(str) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            function42 = function4;
            i2 |= startRestartGroup.changedInstance(function42) ? 8388608 : 4194304;
        } else {
            function42 = function4;
        }
        if (!startRestartGroup.shouldExecute((4793491 & i2) != 4793490, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1441220906, i2, -1, "uz.FonRo.pos.ui.docs.SupplierReturnCreateSheet (SupplierReturnsScreen.kt:549)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2033808798, "CC(remember):SupplierReturnsScreen.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2033806567, "CC(remember):SupplierReturnsScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(SupplierReturnCompensation.REDUCE_DEBT, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2033803851, "CC(remember):SupplierReturnsScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2033802293, "CC(remember):SupplierReturnsScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt.mutableStateListOf();
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final SnapshotStateList snapshotStateList2 = (SnapshotStateList) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2033799752, "CC(remember):SupplierReturnsScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState5 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2033798056, "CC(remember):SupplierReturnsScreen.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final MutableState mutableState6 = (MutableState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2033796351, "CC(remember):SupplierReturnsScreen.kt#9igjgp");
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final MutableState mutableState7 = (MutableState) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SnapshotStateList<SupplierReturnLine> snapshotStateList3 = snapshotStateList2;
            double d2 = AudioStats.AUDIO_AMPLITUDE_NONE;
            for (SupplierReturnLine supplierReturnLine : snapshotStateList3) {
                d2 += supplierReturnLine.getQty() * supplierReturnLine.getProduct().getPurchasePrice();
            }
            String tx = LangKt.tx("Возврат поставщику", new Object[0]);
            final Function4<? super Supplier, ? super String, ? super String, ? super List<SupplierReturnLine>, Unit> function43 = function42;
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1008840759, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                    return SupplierReturnsScreenKt.SupplierReturnCreateSheet$lambda$20(Function0.this, z2, function43, snapshotStateList2, mutableState2, mutableState3, mutableState4, (RowScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, startRestartGroup, 54);
            final double d3 = d2;
            SheetsKt.OxCardSheet(tx, function0, null, false, false, false, rememberComposableLambda, ComposableLambdaKt.rememberComposableLambda(1897245938, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                    return SupplierReturnsScreenKt.SupplierReturnCreateSheet$lambda$21(SnapshotStateList.this, z, d3, str, mutableState2, mutableState5, mutableState3, mutableState6, mutableState7, mutableState4, (ColumnScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 >> 15) & 112) | 14155776, 60);
            if (SupplierReturnCreateSheet$lambda$11(mutableState5)) {
                startRestartGroup.startReplaceGroup(1381082240);
                ComposerKt.sourceInformation(startRestartGroup, "670@26656L17,671@26699L26,668@26579L156");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2033656313, "CC(remember):SupplierReturnsScreen.kt#9igjgp");
                Object rememberedValue8 = startRestartGroup.rememberedValue();
                if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue8 = new Function1() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda23
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            Unit SupplierReturnCreateSheet$lambda$22$0;
                            SupplierReturnCreateSheet$lambda$22$0 = SupplierReturnsScreenKt.SupplierReturnCreateSheet$lambda$22$0(MutableState.this, (Supplier) obj3);
                            return SupplierReturnCreateSheet$lambda$22$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue8);
                }
                Function1 function1 = (Function1) rememberedValue8;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2033654928, "CC(remember):SupplierReturnsScreen.kt#9igjgp");
                Object rememberedValue9 = startRestartGroup.rememberedValue();
                if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue9 = new Function0() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SupplierReturnCreateSheet$lambda$23$0;
                            SupplierReturnCreateSheet$lambda$23$0 = SupplierReturnsScreenKt.SupplierReturnCreateSheet$lambda$23$0(MutableState.this);
                            return SupplierReturnCreateSheet$lambda$23$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue9);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                StockInScreenKt.SupplierPickerSheet(list3, function1, (Function0) rememberedValue9, startRestartGroup, ((i2 >> 6) & 14) | 432);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1381247532);
                startRestartGroup.endReplaceGroup();
            }
            if (!SupplierReturnCreateSheet$lambda$14(mutableState6)) {
                mutableState = mutableState7;
                snapshotStateList = snapshotStateList2;
                str2 = "CC(remember):SupplierReturnsScreen.kt#9igjgp";
                d = AudioStats.AUDIO_AMPLITUDE_NONE;
                obj = null;
                startRestartGroup.startReplaceGroup(1382161164);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1381293381);
                ComposerKt.sourceInformation(startRestartGroup, "680@26916L18,685@27170L476,676@26769L887");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2033647992, "CC(remember):SupplierReturnsScreen.kt#9igjgp");
                Object rememberedValue10 = startRestartGroup.rememberedValue();
                if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue10 = new Function0() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda25
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SupplierReturnCreateSheet$lambda$24$0;
                            SupplierReturnCreateSheet$lambda$24$0 = SupplierReturnsScreenKt.SupplierReturnCreateSheet$lambda$24$0(MutableState.this);
                            return SupplierReturnCreateSheet$lambda$24$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue10);
                }
                Function0 function02 = (Function0) rememberedValue10;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2033639406, "CC(remember):SupplierReturnsScreen.kt#9igjgp");
                Object rememberedValue11 = startRestartGroup.rememberedValue();
                if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue11 = new Function1() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda26
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            Unit SupplierReturnCreateSheet$lambda$25$0;
                            SupplierReturnCreateSheet$lambda$25$0 = SupplierReturnsScreenKt.SupplierReturnCreateSheet$lambda$25$0(SnapshotStateList.this, mutableState6, mutableState7, (Product) obj3);
                            return SupplierReturnCreateSheet$lambda$25$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue11);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                int i3 = i2 >> 6;
                mutableState = mutableState7;
                snapshotStateList = snapshotStateList2;
                obj = null;
                str2 = "CC(remember):SupplierReturnsScreen.kt#9igjgp";
                d = AudioStats.AUDIO_AMPLITUDE_NONE;
                StockInScreenKt.ProductPickerSheet(list, str, z, function02, list2, null, false, (Function1) rememberedValue11, null, startRestartGroup, ((i2 << 9) & 57344) | (i2 & 14) | 14158848 | (i3 & 112) | (i3 & 896), 288);
                startRestartGroup = startRestartGroup;
                startRestartGroup.endReplaceGroup();
            }
            final Product SupplierReturnCreateSheet$lambda$17 = SupplierReturnCreateSheet$lambda$17(mutableState);
            if (SupplierReturnCreateSheet$lambda$17 != null) {
                startRestartGroup.startReplaceGroup(1382203603);
                ComposerKt.sourceInformation(startRestartGroup, "*704@27991L547,715@28564L17,701@27830L761");
                final double qty = Num.INSTANCE.qty(Math.max(d, SupplierReturnCreateSheet$lambda$17.getQuantity()));
                Iterator<T> it = snapshotStateList3.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj2 = it.next();
                        if (((SupplierReturnLine) obj2).getProduct().getId() == SupplierReturnCreateSheet$lambda$17.getId()) {
                            break;
                        }
                    } else {
                        obj2 = obj;
                        break;
                    }
                }
                SupplierReturnLine supplierReturnLine2 = (SupplierReturnLine) obj2;
                String str3 = SupplierReturnCreateSheet$lambda$17.getName() + LangKt.tx(" — вернуть (макс. ", new Object[0]) + Fmt.INSTANCE.qf(Double.valueOf(qty)) + ")";
                double qty2 = supplierReturnLine2 != null ? supplierReturnLine2.getQty() : d;
                String str4 = str2;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 590339151, str4);
                boolean changed = startRestartGroup.changed(qty) | startRestartGroup.changedInstance(SupplierReturnCreateSheet$lambda$17);
                Object rememberedValue12 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                    final SnapshotStateList snapshotStateList4 = snapshotStateList;
                    rememberedValue12 = new Function1() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            Unit SupplierReturnCreateSheet$lambda$26$1$0;
                            SupplierReturnCreateSheet$lambda$26$1$0 = SupplierReturnsScreenKt.SupplierReturnCreateSheet$lambda$26$1$0(qty, snapshotStateList4, SupplierReturnCreateSheet$lambda$17, ((Double) obj3).doubleValue());
                            return SupplierReturnCreateSheet$lambda$26$1$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue12);
                }
                Function1 function12 = (Function1) rememberedValue12;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 590356957, str4);
                Object rememberedValue13 = startRestartGroup.rememberedValue();
                if (rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState8 = mutableState;
                    rememberedValue13 = new Function0() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda28
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SupplierReturnCreateSheet$lambda$26$2$0;
                            SupplierReturnCreateSheet$lambda$26$2$0 = SupplierReturnsScreenKt.SupplierReturnCreateSheet$lambda$26$2$0(MutableState.this);
                            return SupplierReturnCreateSheet$lambda$26$2$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue13);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                NumpadKt.NumpadSheet(str3, qty2, function12, (Function0) rememberedValue13, false, startRestartGroup, 3072, 16);
                Unit unit = Unit.INSTANCE;
                startRestartGroup.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            } else {
                startRestartGroup.startReplaceGroup(1382203602);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return SupplierReturnsScreenKt.SupplierReturnCreateSheet$lambda$27(list, list2, list3, str, z, z2, function0, function4, i, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    private static final Supplier SupplierReturnCreateSheet$lambda$1(MutableState<Supplier> mutableState) {
        return mutableState.getValue();
    }

    private static final String SupplierReturnCreateSheet$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String SupplierReturnCreateSheet$lambda$7(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean SupplierReturnCreateSheet$lambda$11(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void SupplierReturnCreateSheet$lambda$12(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean SupplierReturnCreateSheet$lambda$14(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void SupplierReturnCreateSheet$lambda$15(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Product SupplierReturnCreateSheet$lambda$17(MutableState<Product> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SupplierReturnCreateSheet$lambda$20(Function0 function0, boolean z, final Function4 function4, final SnapshotStateList snapshotStateList, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C564@22512L84,567@22706L185,565@22609L478:SupplierReturnsScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1008840759, i2, -1, "uz.FonRo.pos.ui.docs.SupplierReturnCreateSheet.<anonymous> (SupplierReturnsScreen.kt:564)");
            }
            BasicsKt.OxButton(LangKt.tx("Отмена", new Object[0]), function0, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), null, BtnSize.LG, false, false, null, composer, 24576, 232);
            String tx = z ? LangKt.tx("Проводим…", new Object[0]) : LangKt.tx("Провести возврат", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, 1166646338, "CC(remember):SupplierReturnsScreen.kt#9igjgp");
            boolean changed = composer.changed(function4);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                Function0 function02 = new Function0() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SupplierReturnCreateSheet$lambda$20$0$0;
                        SupplierReturnCreateSheet$lambda$20$0$0 = SupplierReturnsScreenKt.SupplierReturnCreateSheet$lambda$20$0$0(SnapshotStateList.this, function4, mutableState, mutableState2, mutableState3);
                        return SupplierReturnCreateSheet$lambda$20$0$0;
                    }
                };
                composer.updateRememberedValue(function02);
                rememberedValue = function02;
            }
            Function0 function03 = (Function0) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, function03, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.4f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, (snapshotStateList.isEmpty() || z) ? false : true, false, null, composer, 27648, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnCreateSheet$lambda$20$0$0(SnapshotStateList snapshotStateList, Function4 function4, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        if (snapshotStateList.isEmpty()) {
            Toaster.INSTANCE.error(LangKt.tx("Добавьте товар", new Object[0]));
        } else {
            function4.invoke(SupplierReturnCreateSheet$lambda$1(mutableState), SupplierReturnCreateSheet$lambda$4(mutableState2), StringsKt.trim((CharSequence) SupplierReturnCreateSheet$lambda$7(mutableState3)).toString(), snapshotStateList.toList());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SupplierReturnCreateSheet$lambda$21(final SnapshotStateList snapshotStateList, boolean z, double d, String str, MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, ColumnScope OxCardSheet, Composer composer, int i) {
        String tx;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C578@23145L21,578@23114L3423:SupplierReturnsScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1897245938, i, -1, "uz.FonRo.pos.ui.docs.SupplierReturnCreateSheet.<anonymous> (SupplierReturnsScreen.kt:578)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1032706763, "C582@23325L25,579@23183L315,587@23512L55,588@23580L10,589@23613L359,589@23603L369,602@24052L17,600@23986L179,606@24178L11,646@25916L11,650@26052L15,647@25940L243,663@26517L10:SupplierReturnsScreen.kt#1so789");
            String tx2 = LangKt.tx("Поставщик:", new Object[0]);
            Supplier SupplierReturnCreateSheet$lambda$1 = SupplierReturnCreateSheet$lambda$1(mutableState);
            if (SupplierReturnCreateSheet$lambda$1 == null || (tx = SupplierReturnCreateSheet$lambda$1.getName()) == null) {
                tx = LangKt.tx("не выбран", new Object[0]);
            }
            long m10200getDim20d7_KjU = SupplierReturnCreateSheet$lambda$1(mutableState) == null ? Ox.INSTANCE.m10200getDim20d7_KjU() : Ox.INSTANCE.m10233getText0d7_KjU();
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null);
            ComposerKt.sourceInformationMarkerStart(composer, -1352158975, "CC(remember):SupplierReturnsScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SupplierReturnCreateSheet$lambda$21$0$0$0;
                        SupplierReturnCreateSheet$lambda$21$0$0$0 = SupplierReturnsScreenKt.SupplierReturnCreateSheet$lambda$21$0$0$0(MutableState.this);
                        return SupplierReturnCreateSheet$lambda$21$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            String str2 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            String str3 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            String str4 = "C89@4556L9:Column.kt#2w3rfo";
            FieldsKt.m9849OxValueButtonFHprtrg(tx2, tx, (Function0) rememberedValue, m1053paddingqDBjuR0$default, m10200getDim20d7_KjU, null, composer, 3456, 32);
            Object obj = null;
            String str5 = "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo";
            TextKt.m2798Text4IGK_g(LangKt.tx("Чем закрываем возврат", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getLabel(), composer, 0, 0, 65534);
            Composer composer2 = composer;
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer2, 6);
            ChipsKt.OxChipRow(null, ComposableLambdaKt.rememberComposableLambda(2026722297, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    Unit SupplierReturnCreateSheet$lambda$21$0$1;
                    SupplierReturnCreateSheet$lambda$21$0$1 = SupplierReturnsScreenKt.SupplierReturnCreateSheet$lambda$21$0$1(MutableState.this, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return SupplierReturnCreateSheet$lambda$21$0$1;
                }
            }, composer2, 54), composer2, 48, 1);
            String tx3 = LangKt.tx("+ Добавить товар", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer2, -1352135719, "CC(remember):SupplierReturnsScreen.kt#9igjgp");
            Object rememberedValue2 = composer2.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SupplierReturnCreateSheet$lambda$21$0$2$0;
                        SupplierReturnCreateSheet$lambda$21$0$2$0 = SupplierReturnsScreenKt.SupplierReturnCreateSheet$lambda$21$0$2$0(MutableState.this);
                        return SupplierReturnCreateSheet$lambda$21$0$2$0;
                    }
                };
                composer2.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            float f = 0.0f;
            int i2 = 0;
            BasicsKt.OxButton(tx3, (Function0) rememberedValue2, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, false, true, null, composer2, 1573296, 184);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer2, 6);
            if (snapshotStateList.isEmpty()) {
                composer2.startReplaceGroup(1033637878);
                ComposerKt.sourceInformation(composer2, "609@24242L36");
                BasicsKt.OxEmptyNote(LangKt.tx("Товары не выбраны", new Object[0]), null, composer2, 0, 2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(1033758902);
                ComposerKt.sourceInformation(composer2, "*612@24360L1478,642@25859L11");
                Iterator<T> it = snapshotStateList.iterator();
                while (it.hasNext()) {
                    final SupplierReturnLine supplierReturnLine = (SupplierReturnLine) it.next();
                    Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, f, 1, obj), f, Dp.m6989constructorimpl(6.0f), 1, obj);
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
                    String str6 = str2;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str6);
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, i2);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, m1051paddingVpY3zN4$default);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    String str7 = str3;
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str7);
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
                    ComposerKt.sourceInformationMarkerStart(composer2, -1035384222, "C616@24558L614,631@25319L25,629@25197L220,640@25750L22,640@25736L80:SupplierReturnsScreen.kt#1so789");
                    Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                    String str8 = str5;
                    ComposerKt.sourceInformationMarkerStart(composer2, -483455358, str8);
                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, i2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str6);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, i2);
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, weight$default);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str7);
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
                    String str9 = str4;
                    ComposerKt.sourceInformationMarkerStart(composer2, -384672921, str9);
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1504207312, "C617@24616L254,623@24899L247:SupplierReturnsScreen.kt#1so789");
                    str5 = str8;
                    TextKt.m2798Text4IGK_g(supplierReturnLine.getProduct().getName(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), composer, 0, 3120, 55294);
                    TextKt.m2798Text4IGK_g(LangKt.tx("на складе: ", new Object[i2]) + Fmt.INSTANCE.qf(Double.valueOf(supplierReturnLine.getProduct().getQuantity())) + " " + Units.INSTANCE.name(supplierReturnLine.getProduct().getUnit()), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
                    Composer composer3 = composer;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    String str10 = Fmt.INSTANCE.qf(Double.valueOf(supplierReturnLine.getQty())) + " " + Units.INSTANCE.name(supplierReturnLine.getProduct().getUnit());
                    ComposerKt.sourceInformationMarkerStart(composer3, 105170960, "CC(remember):SupplierReturnsScreen.kt#9igjgp");
                    boolean changedInstance = composer3.changedInstance(supplierReturnLine);
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (changedInstance || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit SupplierReturnCreateSheet$lambda$21$0$3$0$1$0;
                                SupplierReturnCreateSheet$lambda$21$0$3$0$1$0 = SupplierReturnsScreenKt.SupplierReturnCreateSheet$lambda$21$0$3$0$1$0(SupplierReturnLine.this, mutableState5);
                                return SupplierReturnCreateSheet$lambda$21$0$3$0$1$0;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    BasicsKt.OxButton(str10, (Function0) rememberedValue3, null, null, BtnSize.SM, false, false, null, composer3, 24576, 236);
                    if (z) {
                        composer3.startReplaceGroup(-1034524500);
                        ComposerKt.sourceInformation(composer3, "635@25486L199");
                        TextKt.m2798Text4IGK_g("  " + Fmt.INSTANCE.money(Double.valueOf(Num.INSTANCE.money(supplierReturnLine.getQty() * supplierReturnLine.getProduct().getPurchasePrice())), str), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 0, 0, 65534);
                        composer3 = composer;
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(-1034279445);
                        composer3.endReplaceGroup();
                    }
                    BtnSize btnSize = BtnSize.SM;
                    BtnStyle btnStyle = BtnStyle.GHOST;
                    ComposerKt.sourceInformationMarkerStart(composer3, 105184749, "CC(remember):SupplierReturnsScreen.kt#9igjgp");
                    boolean changedInstance2 = composer3.changedInstance(supplierReturnLine);
                    Object rememberedValue4 = composer3.rememberedValue();
                    if (changedInstance2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new Function0() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit SupplierReturnCreateSheet$lambda$21$0$3$0$2$0;
                                SupplierReturnCreateSheet$lambda$21$0$3$0$2$0 = SupplierReturnsScreenKt.SupplierReturnCreateSheet$lambda$21$0$3$0$2$0(SnapshotStateList.this, supplierReturnLine);
                                return SupplierReturnCreateSheet$lambda$21$0$3$0$2$0;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    BasicsKt.OxButton("✕", (Function0) rememberedValue4, null, btnStyle, btnSize, false, false, null, composer3, 27654, 228);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    BasicsKt.m9830OxDivideriPRSM58(0L, 0.0f, composer, 0, 3);
                    composer2 = composer;
                    str4 = str9;
                    str3 = str7;
                    str2 = str6;
                    i2 = 0;
                    obj = null;
                    f = 0.0f;
                }
                composer2.endReplaceGroup();
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer2, 6);
            String tx4 = LangKt.tx("Причина", new Object[0]);
            String SupplierReturnCreateSheet$lambda$7 = SupplierReturnCreateSheet$lambda$7(mutableState6);
            ComposerKt.sourceInformationMarkerStart(composer2, -1352071721, "CC(remember):SupplierReturnsScreen.kt#9igjgp");
            Object rememberedValue5 = composer2.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit SupplierReturnCreateSheet$lambda$21$0$4$0;
                        SupplierReturnCreateSheet$lambda$21$0$4$0 = SupplierReturnsScreenKt.SupplierReturnCreateSheet$lambda$21$0$4$0(MutableState.this, (String) obj2);
                        return SupplierReturnCreateSheet$lambda$21$0$4$0;
                    }
                };
                composer2.updateRememberedValue(rememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            FieldsKt.m9846OxFieldDfSPO0(tx4, SupplierReturnCreateSheet$lambda$7, (Function1) rememberedValue5, null, LangKt.tx("Например: брак в трёх упаковках", new Object[0]), 0, 0, null, false, false, false, false, false, 240, null, composer, 384, 3072, 24552);
            Composer composer4 = composer;
            if (z) {
                composer4.startReplaceGroup(1035615957);
                ComposerKt.sourceInformation(composer4, "656@26229L10,657@26256L234");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer4, 6);
                TextKt.m2798Text4IGK_g(LangKt.tx("Сумма возврата: ", new Object[0]) + Fmt.INSTANCE.money(Double.valueOf(Num.INSTANCE.money(d)), str), SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowPrice(), Ox.INSTANCE.m10215getOrangeInk0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 48, 0, 65532);
                composer4 = composer;
                composer4.endReplaceGroup();
            } else {
                composer4.startReplaceGroup(1035897530);
                composer4.endReplaceGroup();
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer4, 6);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnCreateSheet$lambda$21$0$0$0(MutableState mutableState) {
        SupplierReturnCreateSheet$lambda$12(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnCreateSheet$lambda$21$0$1(final MutableState mutableState, RowScope OxChipRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxChipRow, "$this$OxChipRow");
        ComposerKt.sourceInformation(composer, "C*595@23895L23,591@23709L231:SupplierReturnsScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2026722297, i, -1, "uz.FonRo.pos.ui.docs.SupplierReturnCreateSheet.<anonymous>.<anonymous>.<anonymous> (SupplierReturnsScreen.kt:590)");
            }
            Iterator<T> it = SupplierReturnCompensation.INSTANCE.getALL().iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                final String str = (String) pair.component1();
                String str2 = (String) pair.component2();
                boolean areEqual = Intrinsics.areEqual(SupplierReturnCreateSheet$lambda$4(mutableState), str);
                ChipTint chipTint = ChipTint.ORANGE;
                ComposerKt.sourceInformationMarkerStart(composer, 274871753, "CC(remember):SupplierReturnsScreen.kt#9igjgp");
                boolean changed = composer.changed(str);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.docs.SupplierReturnsScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SupplierReturnCreateSheet$lambda$21$0$1$0$0$0;
                            SupplierReturnCreateSheet$lambda$21$0$1$0$0$0 = SupplierReturnsScreenKt.SupplierReturnCreateSheet$lambda$21$0$1$0$0$0(str, mutableState);
                            return SupplierReturnCreateSheet$lambda$21$0$1$0$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ChipsKt.m9837OxCatChipFV1VA1c(str2, areEqual, (Function0) rememberedValue, null, chipTint, null, composer, 24576, 40);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnCreateSheet$lambda$21$0$1$0$0$0(String str, MutableState mutableState) {
        mutableState.setValue(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnCreateSheet$lambda$21$0$2$0(MutableState mutableState) {
        SupplierReturnCreateSheet$lambda$15(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnCreateSheet$lambda$21$0$3$0$1$0(SupplierReturnLine supplierReturnLine, MutableState mutableState) {
        mutableState.setValue(supplierReturnLine.getProduct());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnCreateSheet$lambda$21$0$3$0$2$0(SnapshotStateList snapshotStateList, SupplierReturnLine supplierReturnLine) {
        snapshotStateList.remove(supplierReturnLine);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnCreateSheet$lambda$21$0$4$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnCreateSheet$lambda$22$0(MutableState mutableState, Supplier supplier) {
        mutableState.setValue(supplier);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnCreateSheet$lambda$23$0(MutableState mutableState) {
        SupplierReturnCreateSheet$lambda$12(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnCreateSheet$lambda$24$0(MutableState mutableState) {
        SupplierReturnCreateSheet$lambda$15(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnCreateSheet$lambda$25$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2, Product product) {
        Intrinsics.checkNotNullParameter(product, "product");
        SupplierReturnCreateSheet$lambda$15(mutableState, false);
        SnapshotStateList snapshotStateList2 = snapshotStateList;
        if (!(snapshotStateList2 instanceof Collection) || !snapshotStateList2.isEmpty()) {
            Iterator<T> it = snapshotStateList2.iterator();
            while (it.hasNext()) {
                if (((SupplierReturnLine) it.next()).getProduct().getId() == product.getId()) {
                    Toaster.INSTANCE.error(LangKt.tx("Товар уже в списке", new Object[0]));
                    break;
                }
            }
        }
        if (product.getQuantity() <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            Toaster.INSTANCE.error(LangKt.tx("«%s»: на складе ноль — возвращать нечего", product.getName()));
        } else {
            mutableState2.setValue(product);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnCreateSheet$lambda$26$1$0(double d, SnapshotStateList snapshotStateList, Product product, double d2) {
        int i = 0;
        if (d2 > d) {
            Toaster.INSTANCE.error(LangKt.tx("Больше остатка вернуть нельзя", new Object[0]));
        }
        double qty = Num.INSTANCE.qty(Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, Math.min(d, d2)));
        Iterator<T> it = snapshotStateList.iterator();
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (((SupplierReturnLine) it.next()).getProduct().getId() == product.getId()) {
                break;
            }
            i++;
        }
        if (qty <= AudioStats.AUDIO_AMPLITUDE_NONE && i >= 0) {
            snapshotStateList.remove(i);
        } else if (qty > AudioStats.AUDIO_AMPLITUDE_NONE) {
            if (i >= 0) {
                snapshotStateList.set(i, new SupplierReturnLine(product, qty));
            } else {
                snapshotStateList.add(new SupplierReturnLine(product, qty));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierReturnCreateSheet$lambda$26$2$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    private static final List<Product> SupplierReturnsScreen$lambda$0(State<? extends List<Product>> state) {
        return state.getValue();
    }

    private static final List<Category> SupplierReturnsScreen$lambda$1(State<? extends List<Category>> state) {
        return state.getValue();
    }

    private static final List<Supplier> SupplierReturnsScreen$lambda$2(State<? extends List<Supplier>> state) {
        return state.getValue();
    }

    private static final SyncData SupplierReturnsScreen$lambda$3(State<SyncData> state) {
        return state.getValue();
    }
}
