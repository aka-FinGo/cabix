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
import java.util.ArrayList;
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
import uz.FonRo.pos.data.model.SyncData;
import uz.FonRo.pos.data.model.WriteOffDoc;
import uz.FonRo.pos.data.model.WriteOffItem;
import uz.FonRo.pos.data.model.WriteOffReason;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnSize;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.ChipTint;
import uz.FonRo.pos.ui.components.ChipsKt;
import uz.FonRo.pos.ui.components.FieldsKt;
import uz.FonRo.pos.ui.components.NumpadKt;
import uz.FonRo.pos.ui.components.PeriodKind;
import uz.FonRo.pos.ui.components.PeriodState;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: WriteOffScreen.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0006\u001a\u0016\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u000e\u001aC\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\b\u0017\u0010\u0018\u001aE\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u0014H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\b\u001b\u0010\u001c\u001aE\u0010\u001d\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010#H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010$\u001a[\u0010%\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\u0006\u0010&\u001a\u00020!2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010#2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010#H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010)\u001a´\u0001\u0010*\u001a\u00020\u00012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0,2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\u0006\u00100\u001a\u00020!2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010#2Q\u00101\u001aM\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(6\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002070,¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u000102H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u00109¨\u0006\u0002²\u0006\u0010\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,X\u008a\u0084\u0002²\u0006\u0010\u0010.\u001a\b\u0012\u0004\u0012\u00020/0,X\u008a\u0084\u0002²\u0006\f\u0010:\u001a\u0004\u0018\u00010;X\u008a\u0084\u0002²\u0006\n\u0010<\u001a\u00020=X\u008a\u008e\u0002²\u0006\n\u0010>\u001a\u00020!X\u008a\u008e\u0002²\u0006\n\u0010?\u001a\u00020!X\u008a\u008e\u0002²\u0006\n\u0010@\u001a\u00020!X\u008a\u008e\u0002²\u0006\f\u0010A\u001a\u0004\u0018\u00010\u001eX\u008a\u008e\u0002²\u0006\f\u0010B\u001a\u0004\u0018\u00010\u001eX\u008a\u008e\u0002²\u0006\n\u00100\u001a\u00020!X\u008a\u008e\u0002²\u0006\n\u00105\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u00106\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010C\u001a\u00020!X\u008a\u008e\u0002²\u0006\f\u0010D\u001a\u0004\u0018\u00010-X\u008a\u008e\u0002"}, d2 = {"WriteOffScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "push", "doc", "Luz/FonRo/pos/data/model/WriteOffPush;", "(Luz/FonRo/pos/data/model/WriteOffPush;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MiniTile", "label", "", "value", "tint", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "MiniTile-cf5BqRc", "(Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Metric", "valueColor", "Metric-ww6aTOc", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "WriteOffRow", "Luz/FonRo/pos/data/model/WriteOffDoc;", FirebaseAnalytics.Param.CURRENCY, "showCost", "", "onClick", "Lkotlin/Function0;", "(Luz/FonRo/pos/data/model/WriteOffDoc;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "WriteOffDetailSheet", "canCancel", "onCancelAsk", "onDismiss", "(Luz/FonRo/pos/data/model/WriteOffDoc;Ljava/lang/String;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "WriteOffCreateSheet", CacheStore.PRODUCTS, "", "Luz/FonRo/pos/data/model/Product;", CacheStore.CATEGORIES, "Luz/FonRo/pos/data/model/Category;", "busy", "onSubmit", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "reason", "note", "Luz/FonRo/pos/ui/docs/WriteOffLine;", "lines", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "sync", "Luz/FonRo/pos/data/model/SyncData;", TypedValues.CycleType.S_WAVE_PERIOD, "Luz/FonRo/pos/ui/components/PeriodState;", "monthSheet", "daySheet", "createOpen", "detail", "cancelAsk", "picker", "qtyFor"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class WriteOffScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Metric_ww6aTOc$lambda$1(String str, String str2, Modifier modifier, long j, int i, int i2, Composer composer, int i3) {
        m9949Metricww6aTOc(str, str2, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MiniTile_cf5BqRc$lambda$1(String str, String str2, long j, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m9950MiniTilecf5BqRc(str, str2, j, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WriteOffCreateSheet$lambda$19(List list, List list2, String str, boolean z, boolean z2, Function0 function0, Function3 function3, int i, Composer composer, int i2) {
        WriteOffCreateSheet(list, list2, str, z, z2, function0, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WriteOffDetailSheet$lambda$2(WriteOffDoc writeOffDoc, String str, boolean z, boolean z2, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        WriteOffDetailSheet(writeOffDoc, str, z, z2, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WriteOffRow$lambda$3(WriteOffDoc writeOffDoc, String str, boolean z, Function0 function0, int i, Composer composer, int i2) {
        WriteOffRow(writeOffDoc, str, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WriteOffScreen$lambda$36(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        WriteOffScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x067b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x070d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x07c5  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x084b  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x083c  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x071e  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0688  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x066c  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x05fe  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x045e A[LOOP:1: B:87:0x0458->B:89:0x045e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0477 A[LOOP:2: B:92:0x0471->B:94:0x0477, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void WriteOffScreen(final uz.FonRo.pos.FonRoApp r47, final uz.FonRo.pos.ui.nav.AppNavigator r48, androidx.compose.runtime.Composer r49, final int r50) {
        /*
            Method dump skipped, instructions count: 2151
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.WriteOffScreenKt.WriteOffScreen(uz.FonRo.pos.FonRoApp, uz.FonRo.pos.ui.nav.AppNavigator, androidx.compose.runtime.Composer, int):void");
    }

    private static final PeriodState WriteOffScreen$lambda$4(MutableState<PeriodState> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean WriteOffScreen$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void WriteOffScreen$lambda$8(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean WriteOffScreen$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void WriteOffScreen$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean WriteOffScreen$lambda$13(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void WriteOffScreen$lambda$14(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final WriteOffDoc WriteOffScreen$lambda$16(MutableState<WriteOffDoc> mutableState) {
        return mutableState.getValue();
    }

    private static final WriteOffDoc WriteOffScreen$lambda$19(MutableState<WriteOffDoc> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean WriteOffScreen$lambda$22(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void WriteOffScreen$lambda$23(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffScreen$lambda$27$0$0(MutableState mutableState, PeriodState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffScreen$lambda$27$1$0(MutableState mutableState) {
        WriteOffScreen$lambda$8(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffScreen$lambda$27$2$0(MutableState mutableState) {
        WriteOffScreen$lambda$11(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffScreen$lambda$27$5(boolean z, double d, String str, double d2, boolean z2, boolean z3, List list, final MutableState mutableState, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C160@6904L146,164@7063L250,170@7326L11,171@7350L255:WriteOffScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1761882433, i, -1, "uz.FonRo.pos.ui.docs.WriteOffScreen.<anonymous>.<anonymous> (WriteOffScreen.kt:160)");
            }
            TextKt.m2798Text4IGK_g(z ? LangKt.tx("Убыток по себестоимости", new Object[0]) : LangKt.tx("Списано единиц", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getLabel(), composer, 0, 0, 65534);
            Fmt fmt = Fmt.INSTANCE;
            TextKt.m2798Text4IGK_g(z ? fmt.money(Double.valueOf(d), str) : fmt.qf(Double.valueOf(d2)), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getAmount(), Ox.INSTANCE.m10196getDanger0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 3120, 55294);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer, 6);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer, 6);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1492755224, "C172@7425L78,173@7520L71:WriteOffScreen.kt#1so789");
            m9950MiniTilecf5BqRc(LangKt.tx("Документов", new Object[0]), String.valueOf(list.size()), Ox.INSTANCE.m10219getPink0d7_KjU(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0, 0);
            m9950MiniTilecf5BqRc(LangKt.tx("Единиц", new Object[0]), Fmt.INSTANCE.qf(Double.valueOf(d2)), Ox.INSTANCE.m10186getBlue0d7_KjU(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (z2 && z3) {
                composer.startReplaceGroup(-555001272);
                ComposerKt.sourceInformation(composer, "176@7666L11,179@7767L21,177@7694L253");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
                String tx = LangKt.tx("＋ Списать товар", new Object[0]);
                ComposerKt.sourceInformationMarkerStart(composer, 951931574, "CC(remember):WriteOffScreen.kt#9igjgp");
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit WriteOffScreen$lambda$27$5$1$0;
                            WriteOffScreen$lambda$27$5$1$0 = WriteOffScreenKt.WriteOffScreen$lambda$27$5$1$0(MutableState.this);
                            return WriteOffScreen$lambda$27$5$1$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                BasicsKt.OxButton(tx, (Function0) rememberedValue, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), BtnStyle.PRIMARY, BtnSize.LG, false, false, null, composer, 28080, 224);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-554700479);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffScreen$lambda$27$5$1$0(MutableState mutableState) {
        WriteOffScreen$lambda$14(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffScreen$lambda$27$6$0(boolean z, final List list, final String str, final boolean z2, final MutableState mutableState, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        if (!z) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$WriteOffScreenKt.INSTANCE.getLambda$1121406443$app(), 3, null);
        } else if (list.isEmpty()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$WriteOffScreenKt.INSTANCE.getLambda$200921044$app(), 3, null);
        } else {
            final Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object WriteOffScreen$lambda$27$6$0$0;
                    WriteOffScreen$lambda$27$6$0$0 = WriteOffScreenKt.WriteOffScreen$lambda$27$6$0$0((WriteOffDoc) obj);
                    return WriteOffScreen$lambda$27$6$0$0;
                }
            };
            final WriteOffScreenKt$WriteOffScreen$lambda$27$6$0$$inlined$items$default$1 writeOffScreenKt$WriteOffScreen$lambda$27$6$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$WriteOffScreen$lambda$27$6$0$$inlined$items$default$1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(WriteOffDoc writeOffDoc) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((WriteOffDoc) obj);
                }
            };
            LazyColumn.items(list.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$WriteOffScreen$lambda$27$6$0$$inlined$items$default$2
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
            }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$WriteOffScreen$lambda$27$6$0$$inlined$items$default$3
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
            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$WriteOffScreen$lambda$27$6$0$$inlined$items$default$4
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
                    final WriteOffDoc writeOffDoc = (WriteOffDoc) list.get(i);
                    composer.startReplaceGroup(-325478696);
                    ComposerKt.sourceInformation(composer, "C*206@8791L16,202@8616L213:WriteOffScreen.kt#1so789");
                    String str2 = str;
                    boolean z3 = z2;
                    ComposerKt.sourceInformationMarkerStart(composer, -149041242, "CC(remember):WriteOffScreen.kt#9igjgp");
                    boolean changedInstance = composer.changedInstance(writeOffDoc);
                    Object rememberedValue = composer.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        final MutableState mutableState2 = mutableState;
                        rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$WriteOffScreen$2$5$1$2$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                mutableState2.setValue(WriteOffDoc.this);
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    WriteOffScreenKt.WriteOffRow(writeOffDoc, str2, z3, (Function0) rememberedValue, composer, WriteOffDoc.$stable);
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
    public static final Object WriteOffScreen$lambda$27$6$0$0(WriteOffDoc it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffScreen$lambda$28$0(MutableState mutableState) {
        WriteOffScreen$lambda$8(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffScreen$lambda$29$0(MutableState mutableState, MutableState mutableState2, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(PeriodState.copy$default(WriteOffScreen$lambda$4(mutableState), PeriodKind.MONTH, it, null, 4, null));
        WriteOffScreen$lambda$8(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffScreen$lambda$30$0(MutableState mutableState) {
        WriteOffScreen$lambda$11(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffScreen$lambda$31$0(MutableState mutableState, MutableState mutableState2, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(PeriodState.copy$default(WriteOffScreen$lambda$4(mutableState), PeriodKind.DATE, null, it, 2, null));
        WriteOffScreen$lambda$11(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffScreen$lambda$32$0$0(WriteOffDoc writeOffDoc, MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(null);
        mutableState2.setValue(writeOffDoc);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffScreen$lambda$32$1$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffScreen$lambda$33$0$0(WriteOffDoc writeOffDoc, CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, Repo repo) {
        mutableState.setValue(null);
        if (WriteOffScreen$lambda$22(mutableState2)) {
            return Unit.INSTANCE;
        }
        WriteOffScreen$lambda$23(mutableState2, true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new WriteOffScreenKt$WriteOffScreen$8$1$1$1(writeOffDoc, repo, mutableState2, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffScreen$lambda$33$1$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffScreen$lambda$34$0(MutableState mutableState) {
        WriteOffScreen$lambda$14(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffScreen$lambda$35$0(CoroutineScope coroutineScope, MutableState mutableState, Repo repo, MutableState mutableState2, String reason, String note, List lines) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(lines, "lines");
        if (WriteOffScreen$lambda$22(mutableState)) {
            return Unit.INSTANCE;
        }
        WriteOffScreen$lambda$23(mutableState, true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new WriteOffScreenKt$WriteOffScreen$10$1$1(reason, note, lines, repo, mutableState2, mutableState, null), 3, null);
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
    public static final java.lang.Object push(uz.FonRo.pos.data.model.WriteOffPush r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            boolean r0 = r14 instanceof uz.FonRo.pos.ui.docs.WriteOffScreenKt$push$1
            if (r0 == 0) goto L14
            r0 = r14
            uz.FonRo.pos.ui.docs.WriteOffScreenKt$push$1 r0 = (uz.FonRo.pos.ui.docs.WriteOffScreenKt$push$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            uz.FonRo.pos.ui.docs.WriteOffScreenKt$push$1 r0 = new uz.FonRo.pos.ui.docs.WriteOffScreenKt$push$1
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
            uz.FonRo.pos.data.model.WriteOffPush r0 = (uz.FonRo.pos.data.model.WriteOffPush) r0
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
            java.util.List r9 = kotlin.collections.CollectionsKt.listOf(r13)
            r10 = 15
            r11 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
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
            java.lang.String r14 = "Списание появится после обновления серверной части."
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r14 = uz.FonRo.pos.core.LangKt.tx(r14, r0)
            r13.<init>(r14)
            throw r13
        La0:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.WriteOffScreenKt.push(uz.FonRo.pos.data.model.WriteOffPush, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x006d  */
    /* renamed from: MiniTile-cf5BqRc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m9950MiniTilecf5BqRc(final java.lang.String r61, final java.lang.String r62, final long r63, androidx.compose.ui.Modifier r65, androidx.compose.runtime.Composer r66, final int r67, final int r68) {
        /*
            Method dump skipped, instructions count: 595
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.WriteOffScreenKt.m9950MiniTilecf5BqRc(java.lang.String, java.lang.String, long, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x006c  */
    /* renamed from: Metric-ww6aTOc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m9949Metricww6aTOc(final java.lang.String r66, final java.lang.String r67, androidx.compose.ui.Modifier r68, long r69, androidx.compose.runtime.Composer r71, final int r72, final int r73) {
        /*
            Method dump skipped, instructions count: 621
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.WriteOffScreenKt.m9949Metricww6aTOc(java.lang.String, java.lang.String, androidx.compose.ui.Modifier, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void WriteOffRow(final WriteOffDoc writeOffDoc, final String str, final boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1845858334);
        ComposerKt.sourceInformation(startRestartGroup, "C(WriteOffRow)P(1!1,3)381@15401L1464,378@15290L1575:WriteOffScreen.kt#1so789");
        int i2 = (i & 6) == 0 ? ((i & 8) == 0 ? startRestartGroup.changed(writeOffDoc) : startRestartGroup.changedInstance(writeOffDoc) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if (!startRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1845858334, i2, -1, "uz.FonRo.pos.ui.docs.WriteOffRow (WriteOffScreen.kt:376)");
            }
            List<WriteOffItem> items = writeOffDoc.getItems();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = items.iterator();
            while (it.hasNext()) {
                String productName = ((WriteOffItem) it.next()).getProductName();
                if (productName != null) {
                    arrayList.add(productName);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList2.add(obj);
                }
            }
            final ArrayList arrayList3 = arrayList2;
            BasicsKt.m9833OxSoftCardCe4qNIY(PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(8.0f), 7, null), 0.0f, null, 0L, 0L, function0, ComposableLambdaKt.rememberComposableLambda(-608118568, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return WriteOffScreenKt.WriteOffRow$lambda$2(arrayList3, writeOffDoc, z, str, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, (458752 & (i2 << 6)) | 1572870, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return WriteOffScreenKt.WriteOffRow$lambda$3(WriteOffDoc.this, str, z, function0, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x03db, code lost:
    
        if (r3 == null) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit WriteOffRow$lambda$2(java.util.List r60, uz.FonRo.pos.data.model.WriteOffDoc r61, boolean r62, java.lang.String r63, androidx.compose.foundation.layout.ColumnScope r64, androidx.compose.runtime.Composer r65, int r66) {
        /*
            Method dump skipped, instructions count: 1111
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.WriteOffScreenKt.WriteOffRow$lambda$2(java.util.List, uz.FonRo.pos.data.model.WriteOffDoc, boolean, java.lang.String, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    private static final void WriteOffDetailSheet(final WriteOffDoc writeOffDoc, final String str, final boolean z, final boolean z2, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
        int i2;
        String str2;
        Composer startRestartGroup = composer.startRestartGroup(913922962);
        ComposerKt.sourceInformation(startRestartGroup, "C(WriteOffDetailSheet)P(2,1,5)433@17247L434,446@17688L2721,430@17068L3341:WriteOffScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(writeOffDoc) : startRestartGroup.changedInstance(writeOffDoc) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
        }
        if (!startRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(913922962, i2, -1, "uz.FonRo.pos.ui.docs.WriteOffDetailSheet (WriteOffScreen.kt:429)");
            }
            String tx = LangKt.tx("Акт списания", new Object[0]);
            if (writeOffDoc.getDocNumber() > 0) {
                str2 = " #" + StringsKt.padStart(String.valueOf(writeOffDoc.getDocNumber()), 4, '0');
            } else {
                str2 = "";
            }
            SheetsKt.OxCardSheet(tx + str2, function02, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-696436091, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return WriteOffScreenKt.WriteOffDetailSheet$lambda$0(z2, function0, function02, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1040058798, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return WriteOffScreenKt.WriteOffDetailSheet$lambda$1(WriteOffDoc.this, z, str, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 >> 12) & 112) | 14155776, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WriteOffScreenKt.WriteOffDetailSheet$lambda$2(WriteOffDoc.this, str, z, z2, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WriteOffDetailSheet$lambda$0(boolean z, Function0 function0, Function0 function02, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C:WriteOffScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-696436091, i2, -1, "uz.FonRo.pos.ui.docs.WriteOffDetailSheet.<anonymous> (WriteOffScreen.kt:434)");
            }
            if (z) {
                composer.startReplaceGroup(1459457197);
                ComposerKt.sourceInformation(composer, "435@17294L240");
                BasicsKt.OxButton(LangKt.tx("Отменить списание", new Object[0]), function0, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.DANGER, BtnSize.LG, false, false, null, composer, 27648, 224);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1459728168);
                ComposerKt.sourceInformation(composer, "443@17572L85");
                BasicsKt.OxButton(LangKt.tx("Закрыть", new Object[0]), function02, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), null, BtnSize.LG, false, false, null, composer, 24576, 232);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x012f, code lost:
    
        if (r1 == null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit WriteOffDetailSheet$lambda$1(uz.FonRo.pos.data.model.WriteOffDoc r75, boolean r76, java.lang.String r77, androidx.compose.foundation.layout.ColumnScope r78, androidx.compose.runtime.Composer r79, int r80) {
        /*
            Method dump skipped, instructions count: 2251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.WriteOffScreenKt.WriteOffDetailSheet$lambda$1(uz.FonRo.pos.data.model.WriteOffDoc, boolean, java.lang.String, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    private static final void WriteOffCreateSheet(final List<Product> list, final List<Category> list2, final String str, final boolean z, final boolean z2, final Function0<Unit> function0, final Function3<? super String, ? super String, ? super List<WriteOffLine>, Unit> function3, Composer composer, final int i) {
        Function3<? super String, ? super String, ? super List<WriteOffLine>, Unit> function32;
        MutableState mutableState;
        String str2;
        final SnapshotStateList snapshotStateList;
        double d;
        Object obj;
        Object obj2;
        Composer startRestartGroup = composer.startRestartGroup(264148348);
        ComposerKt.sourceInformation(startRestartGroup, "C(WriteOffCreateSheet)P(5,1,2,6)525@20862L51,526@20930L31,527@20978L47,528@21044L34,529@21097L43,536@21313L539,550@21859L2770,533@21213L3416:WriteOffScreen.kt#1so789");
        int i2 = (i & 6) == 0 ? ((i & 8) == 0 ? startRestartGroup.changed(list) : startRestartGroup.changedInstance(list) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(list2) : startRestartGroup.changedInstance(list2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(str) ? 256 : 128;
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
            function32 = function3;
            i2 |= startRestartGroup.changedInstance(function32) ? 1048576 : 524288;
        } else {
            function32 = function3;
        }
        if (!startRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(264148348, i2, -1, "uz.FonRo.pos.ui.docs.WriteOffCreateSheet (WriteOffScreen.kt:524)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 443501743, "CC(remember):WriteOffScreen.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(WriteOffReason.SPOILED, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 443503899, "CC(remember):WriteOffScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 443505451, "CC(remember):WriteOffScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt.mutableStateListOf();
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final SnapshotStateList snapshotStateList2 = (SnapshotStateList) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 443507550, "CC(remember):WriteOffScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 443509255, "CC(remember):WriteOffScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState5 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SnapshotStateList<WriteOffLine> snapshotStateList3 = snapshotStateList2;
            double d2 = AudioStats.AUDIO_AMPLITUDE_NONE;
            for (WriteOffLine writeOffLine : snapshotStateList3) {
                d2 += writeOffLine.getQty() * writeOffLine.getProduct().getPurchasePrice();
            }
            final Function3<? super String, ? super String, ? super List<WriteOffLine>, Unit> function33 = function32;
            final double d3 = d2;
            SheetsKt.OxCardSheet(LangKt.tx("Списание товара", new Object[0]), function0, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-318532305, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                    return WriteOffScreenKt.WriteOffCreateSheet$lambda$14(Function0.this, function33, snapshotStateList2, z2, mutableState2, mutableState3, (RowScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1167071896, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                    return WriteOffScreenKt.WriteOffCreateSheet$lambda$15(SnapshotStateList.this, z, d3, str, mutableState2, mutableState4, mutableState5, mutableState3, (ColumnScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 >> 12) & 112) | 14155776, 60);
            if (!WriteOffCreateSheet$lambda$8(mutableState4)) {
                mutableState = mutableState5;
                str2 = "CC(remember):WriteOffScreen.kt#9igjgp";
                snapshotStateList = snapshotStateList2;
                d = AudioStats.AUDIO_AMPLITUDE_NONE;
                obj = null;
                startRestartGroup.startReplaceGroup(868296102);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(867433124);
                ComposerKt.sourceInformation(startRestartGroup, "627@24804L18,631@25031L498,623@24657L882");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 443627854, "CC(remember):WriteOffScreen.kt#9igjgp");
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue6 = new Function0() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit WriteOffCreateSheet$lambda$16$0;
                            WriteOffCreateSheet$lambda$16$0 = WriteOffScreenKt.WriteOffCreateSheet$lambda$16$0(MutableState.this);
                            return WriteOffCreateSheet$lambda$16$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                Function0 function02 = (Function0) rememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 443635598, "CC(remember):WriteOffScreen.kt#9igjgp");
                Object rememberedValue7 = startRestartGroup.rememberedValue();
                if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue7 = new Function1() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            Unit WriteOffCreateSheet$lambda$17$0;
                            WriteOffCreateSheet$lambda$17$0 = WriteOffScreenKt.WriteOffCreateSheet$lambda$17$0(SnapshotStateList.this, mutableState4, mutableState5, (Product) obj3);
                            return WriteOffCreateSheet$lambda$17$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                int i3 = i2 >> 3;
                str2 = "CC(remember):WriteOffScreen.kt#9igjgp";
                snapshotStateList = snapshotStateList2;
                d = AudioStats.AUDIO_AMPLITUDE_NONE;
                obj = null;
                mutableState = mutableState5;
                StockInScreenKt.ProductPickerSheet(list, str, z, function02, list2, null, false, (Function1) rememberedValue7, null, startRestartGroup, ((i2 << 9) & 57344) | (i2 & 14) | 12585984 | (i3 & 112) | (i3 & 896), 352);
                startRestartGroup = startRestartGroup;
                startRestartGroup.endReplaceGroup();
            }
            final Product WriteOffCreateSheet$lambda$11 = WriteOffCreateSheet$lambda$11(mutableState);
            if (WriteOffCreateSheet$lambda$11 != null) {
                startRestartGroup.startReplaceGroup(868338169);
                ComposerKt.sourceInformation(startRestartGroup, "*650@25874L535,661@26435L17,647@25713L749");
                final double qty = Num.INSTANCE.qty(Math.max(d, WriteOffCreateSheet$lambda$11.getQuantity()));
                Iterator<T> it = snapshotStateList3.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj2 = it.next();
                        if (((WriteOffLine) obj2).getProduct().getId() == WriteOffCreateSheet$lambda$11.getId()) {
                            break;
                        }
                    } else {
                        obj2 = obj;
                        break;
                    }
                }
                WriteOffLine writeOffLine2 = (WriteOffLine) obj2;
                String str3 = WriteOffCreateSheet$lambda$11.getName() + LangKt.tx(" — списать (макс. ", new Object[0]) + Fmt.INSTANCE.qf(Double.valueOf(qty)) + ")";
                double qty2 = writeOffLine2 != null ? writeOffLine2.getQty() : d;
                String str4 = str2;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1722000663, str4);
                boolean changed = startRestartGroup.changed(qty) | startRestartGroup.changedInstance(WriteOffCreateSheet$lambda$11);
                Object rememberedValue8 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue8 = new Function1() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            Unit WriteOffCreateSheet$lambda$18$1$0;
                            WriteOffCreateSheet$lambda$18$1$0 = WriteOffScreenKt.WriteOffCreateSheet$lambda$18$1$0(qty, snapshotStateList, WriteOffCreateSheet$lambda$11, ((Double) obj3).doubleValue());
                            return WriteOffCreateSheet$lambda$18$1$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue8);
                }
                Function1 function1 = (Function1) rememberedValue8;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1721983229, str4);
                Object rememberedValue9 = startRestartGroup.rememberedValue();
                if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState6 = mutableState;
                    rememberedValue9 = new Function0() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit WriteOffCreateSheet$lambda$18$2$0;
                            WriteOffCreateSheet$lambda$18$2$0 = WriteOffScreenKt.WriteOffCreateSheet$lambda$18$2$0(MutableState.this);
                            return WriteOffCreateSheet$lambda$18$2$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue9);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                NumpadKt.NumpadSheet(str3, qty2, function1, (Function0) rememberedValue9, false, startRestartGroup, 3072, 16);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(868338168);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return WriteOffScreenKt.WriteOffCreateSheet$lambda$19(list, list2, str, z, z2, function0, function3, i, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    private static final String WriteOffCreateSheet$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String WriteOffCreateSheet$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean WriteOffCreateSheet$lambda$8(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void WriteOffCreateSheet$lambda$9(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Product WriteOffCreateSheet$lambda$11(MutableState<Product> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WriteOffCreateSheet$lambda$14(Function0 function0, final Function3 function3, final SnapshotStateList snapshotStateList, boolean z, final MutableState mutableState, final MutableState mutableState2, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C537@21327L84,540@21481L167,538@21424L418:WriteOffScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-318532305, i2, -1, "uz.FonRo.pos.ui.docs.WriteOffCreateSheet.<anonymous> (WriteOffScreen.kt:537)");
            }
            BasicsKt.OxButton(LangKt.tx("Отмена", new Object[0]), function0, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), null, BtnSize.LG, false, false, null, composer, 24576, 232);
            String tx = LangKt.tx("Списать", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -1166861546, "CC(remember):WriteOffScreen.kt#9igjgp");
            boolean changed = composer.changed(function3);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit WriteOffCreateSheet$lambda$14$0$0;
                        WriteOffCreateSheet$lambda$14$0$0 = WriteOffScreenKt.WriteOffCreateSheet$lambda$14$0$0(SnapshotStateList.this, function3, mutableState, mutableState2);
                        return WriteOffCreateSheet$lambda$14$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function0 function02 = (Function0) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, function02, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, (snapshotStateList.isEmpty() || z) ? false : true, false, null, composer, 27648, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffCreateSheet$lambda$14$0$0(SnapshotStateList snapshotStateList, Function3 function3, MutableState mutableState, MutableState mutableState2) {
        if (snapshotStateList.isEmpty()) {
            Toaster.INSTANCE.error(LangKt.tx("Добавьте товар", new Object[0]));
        } else {
            function3.invoke(WriteOffCreateSheet$lambda$1(mutableState), StringsKt.trim((CharSequence) WriteOffCreateSheet$lambda$4(mutableState2)).toString(), snapshotStateList.toList());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WriteOffCreateSheet$lambda$15(final SnapshotStateList snapshotStateList, boolean z, double d, String str, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, ColumnScope OxCardSheet, Composer composer, int i) {
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C551@21900L21,551@21869L2754:WriteOffScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1167071896, i, -1, "uz.FonRo.pos.ui.docs.WriteOffCreateSheet.<anonymous> (WriteOffScreen.kt:551)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 985215202, "C552@21938L50,553@22001L10,554@22034L335,554@22024L345,567@22449L17,565@22383L179,571@22575L11,602@24049L11,606@24183L13,603@24073L207,618@24603L10:WriteOffScreen.kt#1so789");
            Object obj = null;
            String str5 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            String str6 = "C89@4556L9:Column.kt#2w3rfo";
            String str7 = "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo";
            String str8 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            TextKt.m2798Text4IGK_g(LangKt.tx("Причина списания", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getLabel(), composer, 0, 0, 65534);
            Composer composer2 = composer;
            char c = 6;
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer2, 6);
            ChipsKt.OxChipRow(null, ComposableLambdaKt.rememberComposableLambda(1355564383, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    Unit WriteOffCreateSheet$lambda$15$0$0;
                    WriteOffCreateSheet$lambda$15$0$0 = WriteOffScreenKt.WriteOffCreateSheet$lambda$15$0$0(MutableState.this, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return WriteOffCreateSheet$lambda$15$0$0;
                }
            }, composer2, 54), composer2, 48, 1);
            String tx = LangKt.tx("+ Добавить товар", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer2, 1694362815, "CC(remember):WriteOffScreen.kt#9igjgp");
            Object rememberedValue = composer2.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit WriteOffCreateSheet$lambda$15$0$1$0;
                        WriteOffCreateSheet$lambda$15$0$1$0 = WriteOffScreenKt.WriteOffCreateSheet$lambda$15$0$1$0(MutableState.this);
                        return WriteOffCreateSheet$lambda$15$0$1$0;
                    }
                };
                composer2.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            String str9 = "CC(remember):WriteOffScreen.kt#9igjgp";
            int i2 = 0;
            float f = 0.0f;
            BasicsKt.OxButton(tx, (Function0) rememberedValue, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, false, true, null, composer2, 1573296, 184);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer2, 6);
            if (snapshotStateList.isEmpty()) {
                composer2.startReplaceGroup(985811920);
                ComposerKt.sourceInformation(composer2, "574@22639L36");
                BasicsKt.OxEmptyNote(LangKt.tx("Товары не выбраны", new Object[0]), null, composer2, 0, 2);
                composer2.endReplaceGroup();
                str2 = str9;
            } else {
                composer2.startReplaceGroup(985924760);
                ComposerKt.sourceInformation(composer2, "*577@22757L1214,598@23992L11");
                Iterator<T> it = snapshotStateList.iterator();
                while (it.hasNext()) {
                    final WriteOffLine writeOffLine = (WriteOffLine) it.next();
                    Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, f, 1, obj), f, Dp.m6989constructorimpl(6.0f), 1, obj);
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str8);
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, i2);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, m1051paddingVpY3zN4$default);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    String str10 = str5;
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str10);
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
                    ComposerKt.sourceInformationMarkerStart(composer2, 2081790346, "C578@22885L420,587@23452L25,585@23330L220,596@23883L22,596@23869L80:WriteOffScreen.kt#1so789");
                    Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                    String str11 = str7;
                    ComposerKt.sourceInformationMarkerStart(composer2, -483455358, str11);
                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, i2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str8);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, i2);
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, weight$default);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
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
                    String str12 = str6;
                    ComposerKt.sourceInformationMarkerStart(composer2, -384672921, str12);
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -2015727784, "C579@22943L96,580@23068L211:WriteOffScreen.kt#1so789");
                    str7 = str11;
                    TextKt.m2798Text4IGK_g(writeOffLine.getProduct().getName(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), composer, 0, 3120, 55294);
                    TextKt.m2798Text4IGK_g(LangKt.tx("на складе: ", new Object[0]) + Fmt.INSTANCE.qf(Double.valueOf(writeOffLine.getProduct().getQuantity())) + " " + Units.INSTANCE.name(writeOffLine.getProduct().getUnit()), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
                    Composer composer3 = composer;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    String str13 = Fmt.INSTANCE.qf(Double.valueOf(writeOffLine.getQty())) + " " + Units.INSTANCE.name(writeOffLine.getProduct().getUnit());
                    String str14 = str9;
                    ComposerKt.sourceInformationMarkerStart(composer3, 2006834282, str14);
                    boolean changedInstance = composer3.changedInstance(writeOffLine);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$$ExternalSyntheticLambda27
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit WriteOffCreateSheet$lambda$15$0$2$0$1$0;
                                WriteOffCreateSheet$lambda$15$0$2$0$1$0 = WriteOffScreenKt.WriteOffCreateSheet$lambda$15$0$2$0$1$0(WriteOffLine.this, mutableState3);
                                return WriteOffCreateSheet$lambda$15$0$2$0$1$0;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    BasicsKt.OxButton(str13, (Function0) rememberedValue2, null, null, BtnSize.SM, false, false, null, composer3, 24576, 236);
                    if (z) {
                        composer3.startReplaceGroup(2082463634);
                        ComposerKt.sourceInformation(composer3, "591@23619L199");
                        str3 = str8;
                        str4 = str14;
                        TextKt.m2798Text4IGK_g("  " + Fmt.INSTANCE.money(Double.valueOf(Num.INSTANCE.money(writeOffLine.getQty() * writeOffLine.getProduct().getPurchasePrice())), str), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 0, 0, 65534);
                        composer3 = composer;
                        composer3.endReplaceGroup();
                    } else {
                        str3 = str8;
                        str4 = str14;
                        composer3.startReplaceGroup(2082708689);
                        composer3.endReplaceGroup();
                    }
                    BtnSize btnSize = BtnSize.SM;
                    BtnStyle btnStyle = BtnStyle.GHOST;
                    ComposerKt.sourceInformationMarkerStart(composer3, 2006848071, str4);
                    boolean changedInstance2 = composer3.changedInstance(writeOffLine);
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$$ExternalSyntheticLambda28
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit WriteOffCreateSheet$lambda$15$0$2$0$2$0;
                                WriteOffCreateSheet$lambda$15$0$2$0$2$0 = WriteOffScreenKt.WriteOffCreateSheet$lambda$15$0$2$0$2$0(SnapshotStateList.this, writeOffLine);
                                return WriteOffCreateSheet$lambda$15$0$2$0$2$0;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    BasicsKt.OxButton("✕", (Function0) rememberedValue3, null, btnStyle, btnSize, false, false, null, composer3, 27654, 228);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    BasicsKt.m9830OxDivideriPRSM58(0L, 0.0f, composer, 0, 3);
                    str9 = str4;
                    composer2 = composer;
                    str5 = str10;
                    str6 = str12;
                    i2 = 0;
                    c = 6;
                    obj = null;
                    f = 0.0f;
                    str8 = str3;
                }
                str2 = str9;
                composer2.endReplaceGroup();
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer2, 6);
            String tx2 = LangKt.tx("Заметка", new Object[0]);
            String WriteOffCreateSheet$lambda$4 = WriteOffCreateSheet$lambda$4(mutableState4);
            ComposerKt.sourceInformationMarkerStart(composer2, 1694418299, str2);
            Object rememberedValue4 = composer2.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit WriteOffCreateSheet$lambda$15$0$3$0;
                        WriteOffCreateSheet$lambda$15$0$3$0 = WriteOffScreenKt.WriteOffCreateSheet$lambda$15$0$3$0(MutableState.this, (String) obj2);
                        return WriteOffCreateSheet$lambda$15$0$3$0;
                    }
                };
                composer2.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            FieldsKt.m9846OxFieldDfSPO0(tx2, WriteOffCreateSheet$lambda$4, (Function1) rememberedValue4, null, LangKt.tx("помидоры с базара, не продались…", new Object[0]), 0, 0, null, false, false, false, false, false, null, null, composer, 384, 0, 32744);
            Composer composer4 = composer;
            if (z) {
                composer4.startReplaceGroup(987492058);
                ComposerKt.sourceInformation(composer4, "611@24326L10,612@24353L223");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer4, 6);
                TextKt.m2798Text4IGK_g(LangKt.tx("Убыток: ", new Object[0]) + Fmt.INSTANCE.money(Double.valueOf(Num.INSTANCE.money(d)), str), SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowPrice(), Ox.INSTANCE.m10196getDanger0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 48, 0, 65532);
                composer4 = composer;
                composer4.endReplaceGroup();
            } else {
                composer4.startReplaceGroup(987763060);
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
    public static final Unit WriteOffCreateSheet$lambda$15$0$0(final MutableState mutableState, RowScope OxChipRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxChipRow, "$this$OxChipRow");
        ComposerKt.sourceInformation(composer, "C*560@22298L17,556@22118L219:WriteOffScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1355564383, i, -1, "uz.FonRo.pos.ui.docs.WriteOffCreateSheet.<anonymous>.<anonymous>.<anonymous> (WriteOffScreen.kt:555)");
            }
            Iterator<T> it = WriteOffReason.INSTANCE.getALL().iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                final String str = (String) pair.component1();
                String str2 = (String) pair.component2();
                boolean areEqual = Intrinsics.areEqual(WriteOffCreateSheet$lambda$1(mutableState), str);
                ChipTint chipTint = ChipTint.ORANGE;
                ComposerKt.sourceInformationMarkerStart(composer, 695458089, "CC(remember):WriteOffScreen.kt#9igjgp");
                boolean changed = composer.changed(str);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.docs.WriteOffScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit WriteOffCreateSheet$lambda$15$0$0$0$0$0;
                            WriteOffCreateSheet$lambda$15$0$0$0$0$0 = WriteOffScreenKt.WriteOffCreateSheet$lambda$15$0$0$0$0$0(str, mutableState);
                            return WriteOffCreateSheet$lambda$15$0$0$0$0$0;
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
    public static final Unit WriteOffCreateSheet$lambda$15$0$0$0$0$0(String str, MutableState mutableState) {
        mutableState.setValue(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffCreateSheet$lambda$15$0$1$0(MutableState mutableState) {
        WriteOffCreateSheet$lambda$9(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffCreateSheet$lambda$15$0$2$0$1$0(WriteOffLine writeOffLine, MutableState mutableState) {
        mutableState.setValue(writeOffLine.getProduct());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffCreateSheet$lambda$15$0$2$0$2$0(SnapshotStateList snapshotStateList, WriteOffLine writeOffLine) {
        snapshotStateList.remove(writeOffLine);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffCreateSheet$lambda$15$0$3$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffCreateSheet$lambda$16$0(MutableState mutableState) {
        WriteOffCreateSheet$lambda$9(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffCreateSheet$lambda$17$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2, Product product) {
        Intrinsics.checkNotNullParameter(product, "product");
        WriteOffCreateSheet$lambda$9(mutableState, false);
        SnapshotStateList snapshotStateList2 = snapshotStateList;
        if (!(snapshotStateList2 instanceof Collection) || !snapshotStateList2.isEmpty()) {
            Iterator<T> it = snapshotStateList2.iterator();
            while (it.hasNext()) {
                if (((WriteOffLine) it.next()).getProduct().getId() == product.getId()) {
                    Toaster.INSTANCE.error(LangKt.tx("Товар уже в списке", new Object[0]));
                    break;
                }
            }
        }
        if (product.getQuantity() <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            Toaster.INSTANCE.error(LangKt.tx("«%s»: на складе ноль — списывать нечего", product.getName()));
        } else {
            mutableState2.setValue(product);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffCreateSheet$lambda$18$1$0(double d, SnapshotStateList snapshotStateList, Product product, double d2) {
        int i = 0;
        if (d2 > d) {
            Toaster.INSTANCE.error(LangKt.tx("Больше остатка списать нельзя", new Object[0]));
        }
        double qty = Num.INSTANCE.qty(Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, Math.min(d, d2)));
        Iterator<T> it = snapshotStateList.iterator();
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (((WriteOffLine) it.next()).getProduct().getId() == product.getId()) {
                break;
            }
            i++;
        }
        if (qty <= AudioStats.AUDIO_AMPLITUDE_NONE && i >= 0) {
            snapshotStateList.remove(i);
        } else if (qty > AudioStats.AUDIO_AMPLITUDE_NONE) {
            if (i >= 0) {
                snapshotStateList.set(i, new WriteOffLine(product, qty));
            } else {
                snapshotStateList.add(new WriteOffLine(product, qty));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WriteOffCreateSheet$lambda$18$2$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    private static final List<Product> WriteOffScreen$lambda$0(State<? extends List<Product>> state) {
        return state.getValue();
    }

    private static final List<Category> WriteOffScreen$lambda$1(State<? extends List<Category>> state) {
        return state.getValue();
    }

    private static final SyncData WriteOffScreen$lambda$2(State<SyncData> state) {
        return state.getValue();
    }
}
