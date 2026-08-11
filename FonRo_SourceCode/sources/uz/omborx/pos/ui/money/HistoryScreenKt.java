package uz.FonRo.pos.ui.money;

import android.content.Context;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
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
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
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
import okhttp3.internal.ws.WebSocketProtocol;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Num;
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.core.Units;
import uz.FonRo.pos.data.model.PayType;
import uz.FonRo.pos.data.model.ReturnDoc;
import uz.FonRo.pos.data.model.ReturnLine;
import uz.FonRo.pos.data.model.SaleRow;
import uz.FonRo.pos.data.model.SyncData;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.print.ReceiptDoc;
import uz.FonRo.pos.print.ReceiptLine;
import uz.FonRo.pos.print.ReceiptPay;
import uz.FonRo.pos.print.ReceiptTotal;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.ChipTone;
import uz.FonRo.pos.ui.components.ChipsKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.PeriodKind;
import uz.FonRo.pos.ui.components.PeriodPickersKt;
import uz.FonRo.pos.ui.components.PeriodState;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.docs.ReturnsHandoff;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.nav.Routes;
import uz.FonRo.pos.ui.shell.MainShellKt;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxDim;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: HistoryScreen.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0006\u001a/\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0010\u001aC\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\b\u0019\u0010\u001a\u001a<\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u0007H\u0003b\u0002\b\u0007b\f\b \u0012\b\b!\u0012\u0004\b\b(\"¢\u0006\u0004\b\u001e\u0010\u001f\u001a=\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010\u001dH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010'\u001a$\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020%0)2\u0006\u0010,\u001a\u00020\u0013H\u0002\u001aE\u0010-\u001a\u00020\u00012\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020*2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010\u001dH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u00101\u001aK\u00102\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\b4\u00105\u001aQ\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u00020*2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010:H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010;\u001aM\u0010<\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010=\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00010\u001dH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010>\u001a7\u0010?\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%2\u0006\u0010@\u001a\u00020A2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010B\u001a2\u0010C\u001a\u00020\u00012\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u0007H\u0003b\u0002\b\u0007b\f\b \u0012\b\b!\u0012\u0004\b\b(\"¢\u0006\u0002\u0010D\u001a\u001f\u0010E\u001a\u00020\u0001H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010F\u001a;\u0010G\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u00103\u001a\u00020\u0016H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\bH\u0010I\u001a \u0010J\u001a\u00020K2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u0010\u0010L\u001a\u00020\u00132\u0006\u0010M\u001a\u00020\u0013H\u0002¨\u0006\u0002²\u0006\f\u0010N\u001a\u0004\u0018\u00010OX\u008a\u0084\u0002²\u0006\u0012\u0010P\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010)X\u008a\u008e\u0002²\u0006\f\u0010Q\u001a\u0004\u0018\u00010\u0013X\u008a\u008e\u0002²\u0006\n\u0010R\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010S\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\f\u0010T\u001a\u0004\u0018\u00010%X\u008a\u008e\u0002²\u0006\f\u0010U\u001a\u0004\u0018\u00010*X\u008a\u008e\u0002"}, d2 = {"HistoryScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "HistoryTiles", "t", "Luz/FonRo/pos/ui/money/ReceiptTotals;", "canProfit", "", "(Luz/FonRo/pos/ui/money/ReceiptTotals;ZLandroidx/compose/runtime/Composer;I)V", "MiniStat", "value", "", "label", "tint", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "MiniStat-cf5BqRc", "(Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "IcoBox", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "IcoBox-Iv8Zu3U", "(JLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/ComposableInferredTarget;", "scheme", "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]", "ReceiptCard", "r", "Luz/FonRo/pos/ui/money/Receipt;", "onClick", "(Luz/FonRo/pos/ui/money/Receipt;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "aggregateItems", "", "Luz/FonRo/pos/ui/money/ItemAgg;", "receipts", "sort", "ItemCard", FirebaseAnalytics.Param.INDEX, "", "a", "(ILuz/FonRo/pos/ui/money/ItemAgg;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "RcTile", "valueColor", "RcTile-t6yy7ic", "(Ljava/lang/String;Ljava/lang/String;JJLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ProductSalesSheet", "agg", "onDismiss", "onOpenReceipt", "Lkotlin/Function1;", "(Luz/FonRo/pos/ui/money/ItemAgg;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ReceiptSheet", "receipt", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Luz/FonRo/pos/ui/money/Receipt;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ReceiptItemBlock", "row", "Luz/FonRo/pos/data/model/SaleRow;", "(Luz/FonRo/pos/ui/money/Receipt;Luz/FonRo/pos/data/model/SaleRow;ZLandroidx/compose/runtime/Composer;I)V", "PdCard", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "PdSep", "(Landroidx/compose/runtime/Composer;I)V", "PayLine", "PayLine-FNF3uiM", "(Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/runtime/Composer;II)V", "buildReceiptDoc", "Luz/FonRo/pos/print/ReceiptDoc;", "shortTid", "tid", "sync", "Luz/FonRo/pos/data/model/SyncData;", "rows", "error", "monthSheet", "dateSheet", "openReceipt", "openItem"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class HistoryScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit HistoryScreen$lambda$32(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        HistoryScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit HistoryTiles$lambda$1(ReceiptTotals receiptTotals, boolean z, int i, Composer composer, int i2) {
        HistoryTiles(receiptTotals, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit IcoBox_Iv8Zu3U$lambda$1(long j, Function2 function2, int i, Composer composer, int i2) {
        m10011IcoBoxIv8Zu3U(j, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ItemCard$lambda$1(int i, ItemAgg itemAgg, boolean z, Function0 function0, int i2, Composer composer, int i3) {
        ItemCard(i, itemAgg, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MiniStat_cf5BqRc$lambda$1(String str, String str2, long j, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m10012MiniStatcf5BqRc(str, str2, j, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PayLine_FNF3uiM$lambda$1(String str, String str2, long j, int i, int i2, Composer composer, int i3) {
        m10013PayLineFNF3uiM(str, str2, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PdCard$lambda$1(Function2 function2, int i, Composer composer, int i2) {
        PdCard(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PdSep$lambda$1(int i, Composer composer, int i2) {
        PdSep(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ProductSalesSheet$lambda$2(ItemAgg itemAgg, boolean z, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        ProductSalesSheet(itemAgg, z, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit RcTile_t6yy7ic$lambda$1(String str, String str2, long j, long j2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m10014RcTilet6yy7ic(str, str2, j, j2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReceiptCard$lambda$3(Receipt receipt, boolean z, Function0 function0, int i, Composer composer, int i2) {
        ReceiptCard(receipt, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReceiptItemBlock$lambda$2(Receipt receipt, SaleRow saleRow, boolean z, int i, Composer composer, int i2) {
        ReceiptItemBlock(receipt, saleRow, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReceiptSheet$lambda$2(FonRoApp FonRoApp, AppNavigator appNavigator, Receipt receipt, boolean z, Function0 function0, int i, Composer composer, int i2) {
        ReceiptSheet(FonRoApp, appNavigator, receipt, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void HistoryScreen(FonRoApp FonRoApp, final AppNavigator nav, Composer composer, final int i) {
        int i2;
        Composer composer2;
        final boolean z;
        final MutableState mutableState;
        final MutableState mutableState2;
        final MutableState mutableState3;
        final FonRoApp app = FonRoApp;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(nav, "nav");
        Composer startRestartGroup = composer.startRestartGroup(1746294648);
        ComposerKt.sourceInformation(startRestartGroup, "C(HistoryScreen)115@4700L24,116@4751L29,118@4798L49,119@4865L42,120@4930L34,121@4986L34,122@5044L43,123@5108L43,130@5451L26,149@6052L10,149@6016L46,151@6089L242,151@6068L263,157@6352L92,160@6462L48,161@6526L105,171@6856L2718,168@6704L2870:HistoryScreen.kt#fh874k");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(nav) : startRestartGroup.changedInstance(nav) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1746294648, i2, -1, "uz.FonRo.pos.ui.money.HistoryScreen (HistoryScreen.kt:113)");
            }
            Repo repo = app.getRepo();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)558@25470L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -954203484, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(repo.getSync(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1143049783, "CC(remember):HistoryScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState4 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1143047646, "CC(remember):HistoryScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            MutableState mutableState5 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1143045574, "CC(remember):HistoryScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState6 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1143043782, "CC(remember):HistoryScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState7 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1143041917, "CC(remember):HistoryScreen.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final MutableState mutableState8 = (MutableState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1143039869, "CC(remember):HistoryScreen.kt#9igjgp");
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final MutableState mutableState9 = (MutableState) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            boolean can = repo.can(Perm.VIEW_PROFIT);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1143028910, "CC(remember):HistoryScreen.kt#9igjgp");
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            Object obj = rememberedValue8;
            if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                int[] iArr = {0};
                startRestartGroup.updateRememberedValue(iArr);
                obj = iArr;
            }
            int[] iArr2 = (int[]) obj;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            PeriodState period = HistoryState.INSTANCE.getPeriod();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1143009694, "CC(remember):HistoryScreen.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(iArr2) | startRestartGroup.changedInstance(coroutineScope);
            HistoryScreenKt$HistoryScreen$1$1 rememberedValue9 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                rememberedValue9 = new HistoryScreenKt$HistoryScreen$1$1(iArr2, coroutineScope, mutableState4, mutableState5, null);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(period, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue9, startRestartGroup, PeriodState.$stable);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1143008278, "CC(remember):HistoryScreen.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(repo);
            HistoryScreenKt$HistoryScreen$2$1 rememberedValue10 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                rememberedValue10 = new HistoryScreenKt$HistoryScreen$2$1(repo, null);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue10, startRestartGroup, 6);
            List<SaleRow> HistoryScreen$lambda$2 = HistoryScreen$lambda$2(mutableState4);
            SyncData HistoryScreen$lambda$0 = HistoryScreen$lambda$0(collectAsStateWithLifecycle);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1143000012, "CC(remember):HistoryScreen.kt#9igjgp");
            boolean changed = startRestartGroup.changed(HistoryScreen$lambda$2) | startRestartGroup.changed(HistoryScreen$lambda$0);
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                Receipts receipts = Receipts.INSTANCE;
                List<SaleRow> HistoryScreen$lambda$22 = HistoryScreen$lambda$2(mutableState4);
                if (HistoryScreen$lambda$22 == null) {
                    HistoryScreen$lambda$22 = CollectionsKt.emptyList();
                }
                List<SaleRow> list = HistoryScreen$lambda$22;
                SyncData HistoryScreen$lambda$02 = HistoryScreen$lambda$0(collectAsStateWithLifecycle);
                List<ReturnDoc> returns = HistoryScreen$lambda$02 != null ? HistoryScreen$lambda$02.getReturns() : null;
                if (returns == null) {
                    returns = CollectionsKt.emptyList();
                }
                rememberedValue11 = Receipts.group$default(receipts, list, returns, null, 4, null);
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            final List<Receipt> list2 = (List) rememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1142996536, "CC(remember):HistoryScreen.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(list2);
            Object rememberedValue12 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                rememberedValue12 = Receipts.INSTANCE.totals(list2);
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            final ReceiptTotals receiptTotals = (ReceiptTotals) rememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            String itemSort = HistoryState.INSTANCE.getItemSort();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1142994431, "CC(remember):HistoryScreen.kt#9igjgp");
            boolean changed3 = startRestartGroup.changed(itemSort) | startRestartGroup.changed(list2);
            Object rememberedValue13 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                rememberedValue13 = aggregateItems(list2, HistoryState.INSTANCE.getItemSort());
                startRestartGroup.updateRememberedValue(rememberedValue13);
            }
            final List list3 = (List) rememberedValue13;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            String HistoryScreen$lambda$5 = HistoryScreen$lambda$5(mutableState5);
            if (HistoryScreen$lambda$5 == null) {
                HistoryScreen$lambda$5 = "";
            }
            boolean z2 = HistoryScreen$lambda$2(mutableState4) != null;
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), OxDim.INSTANCE.m10245getPagePadD9Ej5fM(), 0.0f, 2, null);
            PaddingValues m1046PaddingValuesa9UjIt4$default = PaddingKt.m1046PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(28.0f), 7, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1142981258, "CC(remember):HistoryScreen.kt#9igjgp");
            boolean changedInstance3 = startRestartGroup.changedInstance(receiptTotals) | startRestartGroup.changed(can) | startRestartGroup.changed(HistoryScreen$lambda$5) | startRestartGroup.changed(z2) | startRestartGroup.changedInstance(list3) | startRestartGroup.changedInstance(list2);
            Object rememberedValue14 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                final String str = HistoryScreen$lambda$5;
                z = can;
                final boolean z3 = z2;
                rememberedValue14 = new Function1() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit HistoryScreen$lambda$25$0;
                        HistoryScreen$lambda$25$0 = HistoryScreenKt.HistoryScreen$lambda$25$0(str, z3, list3, list2, mutableState6, mutableState7, receiptTotals, z, mutableState9, mutableState8, (LazyListScope) obj2);
                        return HistoryScreen$lambda$25$0;
                    }
                };
                mutableState = mutableState6;
                mutableState2 = mutableState7;
                mutableState3 = mutableState8;
                startRestartGroup.updateRememberedValue(rememberedValue14);
            } else {
                z = can;
                mutableState = mutableState6;
                mutableState2 = mutableState7;
                mutableState3 = mutableState8;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LazyDslKt.LazyColumn(m1051paddingVpY3zN4$default, null, m1046PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) rememberedValue14, startRestartGroup, 384, TypedValues.PositionType.TYPE_PERCENT_X);
            Composer composer3 = startRestartGroup;
            if (HistoryScreen$lambda$8(mutableState)) {
                composer3.startReplaceGroup(-1070036638);
                ComposerKt.sourceInformation(composer3, "246@9693L22,247@9738L170,244@9606L312");
                String month = HistoryState.INSTANCE.getPeriod().getMonth();
                ComposerKt.sourceInformationMarkerStart(composer3, -1142893170, "CC(remember):HistoryScreen.kt#9igjgp");
                Object rememberedValue15 = composer3.rememberedValue();
                if (rememberedValue15 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue15 = new Function0() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit HistoryScreen$lambda$26$0;
                            HistoryScreen$lambda$26$0 = HistoryScreenKt.HistoryScreen$lambda$26$0(MutableState.this);
                            return HistoryScreen$lambda$26$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue15);
                }
                Function0 function0 = (Function0) rememberedValue15;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1142891582, "CC(remember):HistoryScreen.kt#9igjgp");
                Object rememberedValue16 = composer3.rememberedValue();
                if (rememberedValue16 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue16 = new Function1() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit HistoryScreen$lambda$27$0;
                            HistoryScreen$lambda$27$0 = HistoryScreenKt.HistoryScreen$lambda$27$0(MutableState.this, (String) obj2);
                            return HistoryScreen$lambda$27$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue16);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                PeriodPickersKt.OxMonthSheet(month, function0, (Function1) rememberedValue16, composer3, 432);
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(-1069721430);
                composer3.endReplaceGroup();
            }
            if (HistoryScreen$lambda$11(mutableState2)) {
                composer3.startReplaceGroup(-1069690430);
                ComposerKt.sourceInformation(composer3, "258@10046L21,259@10090L167,256@9955L312");
                String date = HistoryState.INSTANCE.getPeriod().getDate();
                ComposerKt.sourceInformationMarkerStart(composer3, -1142881875, "CC(remember):HistoryScreen.kt#9igjgp");
                Object rememberedValue17 = composer3.rememberedValue();
                if (rememberedValue17 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue17 = new Function0() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit HistoryScreen$lambda$28$0;
                            HistoryScreen$lambda$28$0 = HistoryScreenKt.HistoryScreen$lambda$28$0(MutableState.this);
                            return HistoryScreen$lambda$28$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue17);
                }
                Function0 function02 = (Function0) rememberedValue17;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1142880321, "CC(remember):HistoryScreen.kt#9igjgp");
                Object rememberedValue18 = composer3.rememberedValue();
                if (rememberedValue18 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue18 = new Function1() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit HistoryScreen$lambda$29$0;
                            HistoryScreen$lambda$29$0 = HistoryScreenKt.HistoryScreen$lambda$29$0(MutableState.this, (String) obj2);
                            return HistoryScreen$lambda$29$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue18);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                PeriodPickersKt.OxDayPickerDialog(date, function02, (Function1) rememberedValue18, composer3, 432);
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(-1069375222);
                composer3.endReplaceGroup();
            }
            ItemAgg HistoryScreen$lambda$17 = HistoryScreen$lambda$17(mutableState9);
            if (HistoryScreen$lambda$17 != null) {
                composer3.startReplaceGroup(-1069352282);
                ComposerKt.sourceInformation(composer3, "*271@10411L19,272@10460L41,268@10310L201");
                ComposerKt.sourceInformationMarkerStart(composer3, -1908904222, "CC(remember):HistoryScreen.kt#9igjgp");
                Object rememberedValue19 = composer3.rememberedValue();
                if (rememberedValue19 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue19 = new Function0() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit HistoryScreen$lambda$30$0$0;
                            HistoryScreen$lambda$30$0$0 = HistoryScreenKt.HistoryScreen$lambda$30$0$0(MutableState.this);
                            return HistoryScreen$lambda$30$0$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue19);
                }
                Function0 function03 = (Function0) rememberedValue19;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1908902632, "CC(remember):HistoryScreen.kt#9igjgp");
                Object rememberedValue20 = composer3.rememberedValue();
                if (rememberedValue20 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue20 = new Function1() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit HistoryScreen$lambda$30$1$0;
                            HistoryScreen$lambda$30$1$0 = HistoryScreenKt.HistoryScreen$lambda$30$1$0(MutableState.this, mutableState3, (Receipt) obj2);
                            return HistoryScreen$lambda$30$1$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue20);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ProductSalesSheet(HistoryScreen$lambda$17, z, function03, (Function1) rememberedValue20, composer3, 3456);
                Unit unit2 = Unit.INSTANCE;
                composer3.endReplaceGroup();
                Unit unit3 = Unit.INSTANCE;
            } else {
                composer3.startReplaceGroup(-1069352283);
                composer3.endReplaceGroup();
            }
            Receipt HistoryScreen$lambda$14 = HistoryScreen$lambda$14(mutableState3);
            if (HistoryScreen$lambda$14 != null) {
                composer3.startReplaceGroup(-1069108095);
                ComposerKt.sourceInformation(composer3, "*282@10699L22,277@10555L176");
                ComposerKt.sourceInformationMarkerStart(composer3, -391033436, "CC(remember):HistoryScreen.kt#9igjgp");
                Object rememberedValue21 = composer3.rememberedValue();
                if (rememberedValue21 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue21 = new Function0() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit HistoryScreen$lambda$31$0$0;
                            HistoryScreen$lambda$31$0$0 = HistoryScreenKt.HistoryScreen$lambda$31$0$0(MutableState.this);
                            return HistoryScreen$lambda$31$0$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue21);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                app = FonRoApp;
                ReceiptSheet(app, nav, HistoryScreen$lambda$14, z, (Function0) rememberedValue21, composer3, FonRoApp.$stable | 24576 | (i2 & 14) | (AppNavigator.$stable << 3) | (i2 & 112) | (Receipt.$stable << 6));
                Unit unit4 = Unit.INSTANCE;
                composer3.endReplaceGroup();
                Unit unit5 = Unit.INSTANCE;
            } else {
                composer3.startReplaceGroup(-1069108096);
                composer3.endReplaceGroup();
                app = FonRoApp;
            }
            composer2 = composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                composer2 = composer3;
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return HistoryScreenKt.HistoryScreen$lambda$32(FonRoApp.this, nav, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final List<SaleRow> HistoryScreen$lambda$2(MutableState<List<SaleRow>> mutableState) {
        return mutableState.getValue();
    }

    private static final String HistoryScreen$lambda$5(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean HistoryScreen$lambda$8(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void HistoryScreen$lambda$9(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean HistoryScreen$lambda$11(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void HistoryScreen$lambda$12(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Receipt HistoryScreen$lambda$14(MutableState<Receipt> mutableState) {
        return mutableState.getValue();
    }

    private static final ItemAgg HistoryScreen$lambda$17(MutableState<ItemAgg> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HistoryScreen$load(int[] iArr, CoroutineScope coroutineScope, MutableState<List<SaleRow>> mutableState, MutableState<String> mutableState2) {
        int i = iArr[0] + 1;
        iArr[0] = i;
        mutableState.setValue(null);
        mutableState2.setValue(null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new HistoryScreenKt$HistoryScreen$load$1(i, iArr, mutableState, mutableState2, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryScreen$lambda$25$0(final String str, boolean z, final List list, final List list2, final MutableState mutableState, final MutableState mutableState2, final ReceiptTotals receiptTotals, final boolean z2, final MutableState mutableState3, final MutableState mutableState4, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$HistoryScreenKt.INSTANCE.m9976getLambda$192727741$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$HistoryScreenKt.INSTANCE.m9975getLambda$1779153428$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-2084787957, true, new Function3() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit HistoryScreen$lambda$25$0$0;
                HistoryScreen$lambda$25$0$0 = HistoryScreenKt.HistoryScreen$lambda$25$0$0(MutableState.this, mutableState2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return HistoryScreen$lambda$25$0$0;
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1904544810, true, new Function3() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit HistoryScreen$lambda$25$0$1;
                HistoryScreen$lambda$25$0$1 = HistoryScreenKt.HistoryScreen$lambda$25$0$1(ReceiptTotals.this, z2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return HistoryScreen$lambda$25$0$1;
            }
        }), 3, null);
        if (str.length() > 0) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(609696843, true, new Function3() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit HistoryScreen$lambda$25$0$2;
                    HistoryScreen$lambda$25$0$2 = HistoryScreenKt.HistoryScreen$lambda$25$0$2(str, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return HistoryScreen$lambda$25$0$2;
                }
            }), 3, null);
        } else if (!z) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$HistoryScreenKt.INSTANCE.m9974getLambda$1765010174$app(), 3, null);
        } else if (Intrinsics.areEqual(HistoryState.INSTANCE.getTab(), FirebaseAnalytics.Param.ITEMS)) {
            if (list.isEmpty()) {
                LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$HistoryScreenKt.INSTANCE.getLambda$328054664$app(), 3, null);
            } else {
                LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$HistoryScreenKt.INSTANCE.getLambda$539629087$app(), 3, null);
                final Function2 function2 = new Function2() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda32
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Object HistoryScreen$lambda$25$0$3;
                        HistoryScreen$lambda$25$0$3 = HistoryScreenKt.HistoryScreen$lambda$25$0$3(((Integer) obj).intValue(), (ItemAgg) obj2);
                        return HistoryScreen$lambda$25$0$3;
                    }
                };
                LazyColumn.items(list.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$HistoryScreen$lambda$25$0$$inlined$itemsIndexed$default$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int i) {
                        return Function2.this.invoke(Integer.valueOf(i), list.get(i));
                    }
                }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$HistoryScreen$lambda$25$0$$inlined$itemsIndexed$default$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int i) {
                        list.get(i);
                        return null;
                    }
                }, ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$HistoryScreen$lambda$25$0$$inlined$itemsIndexed$default$3
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
                        ComposerKt.sourceInformation(composer, "C214@10657L26:LazyDsl.kt#428nma");
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
                            ComposerKt.traceEventStart(-1091073711, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                        }
                        Object obj = list.get(i);
                        int i4 = i3 & WebSocketProtocol.PAYLOAD_SHORT;
                        final ItemAgg itemAgg = (ItemAgg) obj;
                        composer.startReplaceGroup(-67422920);
                        ComposerKt.sourceInformation(composer, "CP(1)*226@9132L18,226@9100L50:HistoryScreen.kt#fh874k");
                        boolean z3 = z2;
                        ComposerKt.sourceInformationMarkerStart(composer, -2173941, "CC(remember):HistoryScreen.kt#9igjgp");
                        boolean changedInstance = composer.changedInstance(itemAgg);
                        Object rememberedValue = composer.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            final MutableState mutableState5 = mutableState3;
                            rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$HistoryScreen$3$1$5$1$1
                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    mutableState5.setValue(ItemAgg.this);
                                }
                            };
                            composer.updateRememberedValue(rememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        HistoryScreenKt.ItemCard(i, itemAgg, z3, (Function0) rememberedValue, composer, (i4 >> 3) & 14);
                        composer.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
            }
        } else if (list2.isEmpty()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$HistoryScreenKt.INSTANCE.getLambda$1382242855$app(), 3, null);
        } else {
            final Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object HistoryScreen$lambda$25$0$5;
                    HistoryScreen$lambda$25$0$5 = HistoryScreenKt.HistoryScreen$lambda$25$0$5((Receipt) obj);
                    return HistoryScreen$lambda$25$0$5;
                }
            };
            final HistoryScreenKt$HistoryScreen$lambda$25$0$$inlined$items$default$1 historyScreenKt$HistoryScreen$lambda$25$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$HistoryScreen$lambda$25$0$$inlined$items$default$1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(Receipt receipt) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((Receipt) obj);
                }
            };
            LazyColumn.items(list2.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$HistoryScreen$lambda$25$0$$inlined$items$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i) {
                    return Function1.this.invoke(list2.get(i));
                }
            }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$HistoryScreen$lambda$25$0$$inlined$items$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i) {
                    return Function1.this.invoke(list2.get(i));
                }
            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$HistoryScreen$lambda$25$0$$inlined$items$default$4
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
                    final Receipt receipt = (Receipt) list2.get(i);
                    composer.startReplaceGroup(534143210);
                    ComposerKt.sourceInformation(composer, "C*236@9485L19,236@9459L45:HistoryScreen.kt#fh874k");
                    boolean z3 = z2;
                    ComposerKt.sourceInformationMarkerStart(composer, -1091147425, "CC(remember):HistoryScreen.kt#9igjgp");
                    boolean changedInstance = composer.changedInstance(receipt);
                    Object rememberedValue = composer.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        final MutableState mutableState5 = mutableState4;
                        rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$HistoryScreen$3$1$7$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                mutableState5.setValue(Receipt.this);
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    HistoryScreenKt.ReceiptCard(receipt, z3, (Function0) rememberedValue, composer, Receipt.$stable);
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
    public static final Unit HistoryScreen$lambda$25$0$0(final MutableState mutableState, final MutableState mutableState2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C194@7732L28,201@8065L21,202@8117L20,192@7645L506:HistoryScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2084787957, i, -1, "uz.FonRo.pos.ui.money.HistoryScreen.<anonymous>.<anonymous>.<anonymous> (HistoryScreen.kt:192)");
            }
            PeriodState period = HistoryState.INSTANCE.getPeriod();
            ComposerKt.sourceInformationMarkerStart(composer, -2026463481, "CC(remember):HistoryScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit HistoryScreen$lambda$25$0$0$0$0;
                        HistoryScreen$lambda$25$0$0$0$0 = HistoryScreenKt.HistoryScreen$lambda$25$0$0$0$0((PeriodState) obj);
                        return HistoryScreen$lambda$25$0$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function1 function1 = (Function1) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(4.0f), 7, null);
            List listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(LangKt.tx("Сегодня", new Object[0]), PeriodKind.TODAY), TuplesKt.to(LangKt.tx("10 дней", new Object[0]), PeriodKind.DAYS_10), TuplesKt.to(LangKt.tx("Все", new Object[0]), PeriodKind.ALL)});
            ComposerKt.sourceInformationMarkerStart(composer, -2026452832, "CC(remember):HistoryScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit HistoryScreen$lambda$25$0$0$1$0;
                        HistoryScreen$lambda$25$0$0$1$0 = HistoryScreenKt.HistoryScreen$lambda$25$0$0$1$0(MutableState.this);
                        return HistoryScreen$lambda$25$0$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            Function0 function0 = (Function0) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -2026451169, "CC(remember):HistoryScreen.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit HistoryScreen$lambda$25$0$0$2$0;
                        HistoryScreen$lambda$25$0$0$2$0 = HistoryScreenKt.HistoryScreen$lambda$25$0$0$2$0(MutableState.this);
                        return HistoryScreen$lambda$25$0$0$2$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.OxPeriodChips(period, function1, m1053paddingqDBjuR0$default, null, listOf, function0, (Function0) rememberedValue3, composer, PeriodState.$stable | 1769904, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryScreen$lambda$25$0$0$0$0(PeriodState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        HistoryState.INSTANCE.setPeriod(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryScreen$lambda$25$0$0$1$0(MutableState mutableState) {
        HistoryScreen$lambda$9(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryScreen$lambda$25$0$0$2$0(MutableState mutableState) {
        HistoryScreen$lambda$12(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryScreen$lambda$25$0$1(ReceiptTotals receiptTotals, boolean z, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C206@8178L31:HistoryScreen.kt#fh874k");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1904544810, i, -1, "uz.FonRo.pos.ui.money.HistoryScreen.<anonymous>.<anonymous>.<anonymous> (HistoryScreen.kt:206)");
            }
            HistoryTiles(receiptTotals, z, composer, ReceiptTotals.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryScreen$lambda$25$0$2(String str, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C209@8273L22:HistoryScreen.kt#fh874k");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(609696843, i, -1, "uz.FonRo.pos.ui.money.HistoryScreen.<anonymous>.<anonymous>.<anonymous> (HistoryScreen.kt:209)");
            }
            BasicsKt.OxEmptyNote(str, null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object HistoryScreen$lambda$25$0$3(int i, ItemAgg a) {
        Intrinsics.checkNotNullParameter(a, "a");
        return a.getKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object HistoryScreen$lambda$25$0$5(Receipt it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getTransactionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryScreen$lambda$26$0(MutableState mutableState) {
        HistoryScreen$lambda$9(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryScreen$lambda$27$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        HistoryState.INSTANCE.setPeriod(PeriodState.copy$default(HistoryState.INSTANCE.getPeriod(), PeriodKind.MONTH, it, null, 4, null));
        HistoryScreen$lambda$9(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryScreen$lambda$28$0(MutableState mutableState) {
        HistoryScreen$lambda$12(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryScreen$lambda$29$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        HistoryState.INSTANCE.setPeriod(PeriodState.copy$default(HistoryState.INSTANCE.getPeriod(), PeriodKind.DATE, null, it, 2, null));
        HistoryScreen$lambda$12(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryScreen$lambda$30$0$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryScreen$lambda$30$1$0(MutableState mutableState, MutableState mutableState2, Receipt r) {
        Intrinsics.checkNotNullParameter(r, "r");
        mutableState.setValue(null);
        mutableState2.setValue(r);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryScreen$lambda$31$0$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    private static final void HistoryTiles(final ReceiptTotals receiptTotals, final boolean z, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(759443658);
        ComposerKt.sourceInformation(startRestartGroup, "C(HistoryTiles)P(1)291@10855L1182:HistoryScreen.kt#fh874k");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(receiptTotals) : startRestartGroup.changedInstance(receiptTotals) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(759443658, i2, -1, "uz.FonRo.pos.ui.money.HistoryTiles (HistoryScreen.kt:290)");
            }
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(14.0f), 7, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m1053paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -344945276, "C296@11188L496,305@11693L10,306@11712L319:HistoryScreen.kt#fh874k");
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(7.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
            Updater.m3815setimpl(m3808constructorimpl2, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -609212429, "C297@11258L92,298@11363L70:HistoryScreen.kt#fh874k");
            m10012MiniStatcf5BqRc(receiptTotals.getCount() + " / " + Fmt.INSTANCE.qf(Double.valueOf(receiptTotals.getQty())), LangKt.tx("Чек / товары", new Object[0]), Ox.INSTANCE.m10201getGreen0d7_KjU(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), startRestartGroup, 0, 0);
            m10012MiniStatcf5BqRc(Fmt.INSTANCE.nf(Double.valueOf(receiptTotals.getTotal())), LangKt.tx("Сумма", new Object[0]), Ox.INSTANCE.m10213getOrange0d7_KjU(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), startRestartGroup, 0, 0);
            if (z) {
                startRestartGroup.startReplaceGroup(-609020726);
                ComposerKt.sourceInformation(startRestartGroup, "300@11479L72");
                m10012MiniStatcf5BqRc(Fmt.INSTANCE.nf(Double.valueOf(receiptTotals.getProfit())), LangKt.tx("Прибыль", new Object[0]), Ox.INSTANCE.m10201getGreen0d7_KjU(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), startRestartGroup, 0, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-608911637);
                ComposerKt.sourceInformation(startRestartGroup, "302@11589L71");
                m10012MiniStatcf5BqRc(String.valueOf(receiptTotals.getCount()), LangKt.tx("Чеков", new Object[0]), Ox.INSTANCE.m10192getCyan0d7_KjU(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), startRestartGroup, 0, 0);
                startRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(7.0f), startRestartGroup, 6);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(7.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
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
            Updater.m3815setimpl(m3808constructorimpl3, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -320686213, "C307@11782L72,308@11867L74,309@11954L67:HistoryScreen.kt#fh874k");
            m10012MiniStatcf5BqRc(Fmt.INSTANCE.nf(Double.valueOf(receiptTotals.getDiscount())), LangKt.tx("Скидка", new Object[0]), Ox.INSTANCE.m10219getPink0d7_KjU(), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), startRestartGroup, 0, 0);
            m10012MiniStatcf5BqRc(Fmt.INSTANCE.nf(Double.valueOf(receiptTotals.getReturned())), LangKt.tx("Возвраты", new Object[0]), Ox.INSTANCE.m10219getPink0d7_KjU(), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), startRestartGroup, 0, 0);
            m10012MiniStatcf5BqRc(Fmt.INSTANCE.nf(Double.valueOf(receiptTotals.getDebt())), LangKt.tx("Долги", new Object[0]), Ox.INSTANCE.m10219getPink0d7_KjU(), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), startRestartGroup, 0, 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda45
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HistoryScreenKt.HistoryTiles$lambda$1(ReceiptTotals.this, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x006e  */
    /* renamed from: MiniStat-cf5BqRc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m10012MiniStatcf5BqRc(final java.lang.String r40, final java.lang.String r41, final long r42, androidx.compose.ui.Modifier r44, androidx.compose.runtime.Composer r45, final int r46, final int r47) {
        /*
            Method dump skipped, instructions count: 582
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.money.HistoryScreenKt.m10012MiniStatcf5BqRc(java.lang.String, java.lang.String, long, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: IcoBox-Iv8Zu3U, reason: not valid java name */
    private static final void m10011IcoBoxIv8Zu3U(long j, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final long j2;
        Composer startRestartGroup = composer.startRestartGroup(1289107374);
        ComposerKt.sourceInformation(startRestartGroup, "C(IcoBox)P(1:c#ui.graphics.Color)339@12860L134:HistoryScreen.kt#fh874k");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            j2 = j;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1289107374, i2, -1, "uz.FonRo.pos.ui.money.IcoBox (HistoryScreen.kt:338)");
            }
            j2 = j;
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(52.0f)), OxShape.INSTANCE.getTile()), j2, null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -370797454, "C342@12983L9:HistoryScreen.kt#fh874k");
            function2.invoke(startRestartGroup, Integer.valueOf((i2 >> 3) & 14));
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda44
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HistoryScreenKt.IcoBox_Iv8Zu3U$lambda$1(j2, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ReceiptCard(final Receipt receipt, final boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1041152190);
        ComposerKt.sourceInformation(startRestartGroup, "C(ReceiptCard)P(2)367@13896L2531,362@13646L2781:HistoryScreen.kt#fh874k");
        int i2 = (i & 6) == 0 ? ((i & 8) == 0 ? startRestartGroup.changed(receipt) : startRestartGroup.changedInstance(receipt) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1041152190, i2, -1, "uz.FonRo.pos.ui.money.ReceiptCard (HistoryScreen.kt:348)");
            }
            final boolean hasReturn = receipt.getHasReturn();
            List listOf = CollectionsKt.listOf((Object[]) new String[]{LangKt.tx("%s поз.", Integer.valueOf(receipt.getItems().size())), Fmt.dt$default(Fmt.INSTANCE, receipt.getSoldAt(), false, 2, null), !StringsKt.isBlank(receipt.getCashierName()) ? LangKt.tx("Кассир: %s", receipt.getCashierName()) : ""});
            ArrayList arrayList = new ArrayList();
            for (Object obj : listOf) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList.add(obj);
                }
            }
            final String joinToString$default = CollectionsKt.joinToString$default(arrayList, " · ", null, null, 0, null, null, 62, null);
            List listOf2 = CollectionsKt.listOf((Object[]) new String[]{z ? LangKt.tx("Прибыль %s", Fmt.INSTANCE.nf(Double.valueOf(receipt.getNetProfit()))) : "", hasReturn ? LangKt.tx("Возврат −%s", Fmt.INSTANCE.nf(Double.valueOf(receipt.getReturnedTotal()))) : "", LangKt.tx("%s шт", Fmt.INSTANCE.qf(Double.valueOf(receipt.getNetQty())))});
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : listOf2) {
                if (!StringsKt.isBlank((String) obj2)) {
                    arrayList2.add(obj2);
                }
            }
            final String joinToString$default2 = CollectionsKt.joinToString$default(arrayList2, " · ", null, null, 0, null, null, 62, null);
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(11.0f), 7, null);
            Ox ox = Ox.INSTANCE;
            long m10241tintBg5vOe2sY = hasReturn ? ox.m10241tintBg5vOe2sY(Ox.INSTANCE.m10213getOrange0d7_KjU(), 0.07f) : ox.m10218getPanel20d7_KjU();
            Ox ox2 = Ox.INSTANCE;
            BasicsKt.m9833OxSoftCardCe4qNIY(m1053paddingqDBjuR0$default, 0.0f, null, m10241tintBg5vOe2sY, hasReturn ? Color.m4383copywmQWz5c$default(ox2.m10213getOrange0d7_KjU(), 0.45f, 0.0f, 0.0f, 0.0f, 14, null) : ox2.m10189getBorder0d7_KjU(), function0, ComposableLambdaKt.rememberComposableLambda(-13881656, true, new Function3() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                    return HistoryScreenKt.ReceiptCard$lambda$2(joinToString$default2, hasReturn, joinToString$default, receipt, (ColumnScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 << 9) & 458752) | 1572870, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return HistoryScreenKt.ReceiptCard$lambda$3(Receipt.this, z, function0, i, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReceiptCard$lambda$2(String str, final boolean z, String str2, Receipt receipt, ColumnScope OxSoftCard, Composer composer, int i) {
        String str3;
        long m10241tintBg5vOe2sY;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C368@13906L2285,420@16200L221:HistoryScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-13881656, i, -1, "uz.FonRo.pos.ui.money.ReceiptCard.<anonymous> (HistoryScreen.kt:368)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
            Alignment.Vertical top = Alignment.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, top, composer, 54);
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
            ComposerKt.sourceInformationMarkerStart(composer, -380546224, "C373@14172L281,373@14094L359,381@14466L1715:HistoryScreen.kt#fh874k");
            if (z) {
                str3 = "C101@5232L9:Row.kt#2w3rfo";
                m10241tintBg5vOe2sY = Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10213getOrange0d7_KjU(), 0.16f);
            } else {
                str3 = "C101@5232L9:Row.kt#2w3rfo";
                m10241tintBg5vOe2sY = Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10201getGreen0d7_KjU(), 0.16f);
            }
            m10011IcoBoxIv8Zu3U(m10241tintBg5vOe2sY, ComposableLambdaKt.rememberComposableLambda(-1228238544, true, new Function2() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ReceiptCard$lambda$2$0$0;
                    ReceiptCard$lambda$2$0$0 = HistoryScreenKt.ReceiptCard$lambda$2$0$0(z, (Composer) obj, ((Integer) obj2).intValue());
                    return ReceiptCard$lambda$2$0$0;
                }
            }, composer, 54), composer, 48);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1563962806, "C382@14512L1348,411@15877L290:HistoryScreen.kt#fh874k");
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
            Alignment.Vertical top2 = Alignment.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, top2, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, fillMaxWidth$default2);
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
            Updater.m3815setimpl(m3808constructorimpl3, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, str3);
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -206251025, "C387@14740L345,394@15106L736:HistoryScreen.kt#fh874k");
            TextKt.m2798Text4IGK_g(LangKt.tx("Чек #%s", shortTid(receipt.getTransactionId())), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH3(), 0L, TextUnitKt.getSp(15), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 0, 3120, 55292);
            Alignment.Horizontal end = Alignment.INSTANCE.getEnd();
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), end, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, companion);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor4);
            } else {
                composer.useNode();
            }
            Composer m3808constructorimpl4 = Updater.m3808constructorimpl(composer);
            Updater.m3815setimpl(m3808constructorimpl4, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl4.getInserting() || !Intrinsics.areEqual(m3808constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m3808constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m3808constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3815setimpl(m3808constructorimpl4, materializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -266693309, "C395@15176L433,404@15634L10,405@15669L151:HistoryScreen.kt#fh874k");
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.nf(Double.valueOf(receipt.getNetTotal())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), 0L, TextUnitKt.getSp(16), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 0, 3072, 57342);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(2.0f), composer, 6);
            BasicsKt.OxChip(receipt.getPaymentStatus(), receipt.isDebt() ? ChipTone.WARN : ChipTone.OK, null, composer, 0, 4);
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
            TextStyle rowSub = OxType.INSTANCE.getRowSub();
            Ox ox = Ox.INSTANCE;
            TextKt.m2798Text4IGK_g(str2, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(3.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(rowSub, z ? ox.m10214getOrangeDeep0d7_KjU() : ox.m10200getDim20d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 48, 3120, 55292);
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
            TextKt.m2798Text4IGK_g(str, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(10.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), TextUnitKt.getSp(12.5d), FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 48, 0, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptCard$lambda$2$0$0(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C374@14190L249:HistoryScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1228238544, i, -1, "uz.FonRo.pos.ui.money.ReceiptCard.<anonymous>.<anonymous>.<anonymous> (HistoryScreen.kt:374)");
            }
            OxIcons oxIcons = OxIcons.INSTANCE;
            IconKt.m2255Iconww6aTOc(z ? oxIcons.getUndo() : oxIcons.getReceipt(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(22.0f)), z ? Ox.INSTANCE.m10215getOrangeInk0d7_KjU() : Ox.INSTANCE.m10211getOk0d7_KjU(), composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final List<ItemAgg> aggregateItems(List<Receipt> list, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Receipt receipt : list) {
            for (SaleRow saleRow : receipt.getItems()) {
                String str2 = saleRow.getProductId() != 0 ? "id:" + saleRow.getProductId() : "nm:" + saleRow.getTitle();
                LinkedHashMap linkedHashMap2 = linkedHashMap;
                Object obj = linkedHashMap2.get(str2);
                if (obj == null) {
                    String title = saleRow.getTitle();
                    if (StringsKt.isBlank(title)) {
                        title = LangKt.tx("Товар", new Object[0]);
                    }
                    ItemAccum itemAccum = new ItemAccum(str2, title, saleRow.getUnitCode());
                    linkedHashMap2.put(str2, itemAccum);
                    obj = itemAccum;
                }
                ItemAccum itemAccum2 = (ItemAccum) obj;
                double returnedShare = saleRow.getReturnedShare();
                itemAccum2.setQty(itemAccum2.getQty() + saleRow.getQuantity());
                itemAccum2.setRetQty(itemAccum2.getRetQty() + saleRow.getReturnedQuantity());
                itemAccum2.setRevenue(itemAccum2.getRevenue() + saleRow.getTotalAmount());
                itemAccum2.setRetAmount(itemAccum2.getRetAmount() + (saleRow.getTotalAmount() * returnedShare));
                itemAccum2.setProfit(itemAccum2.getProfit() + saleRow.getProfit());
                itemAccum2.setRetProfit(itemAccum2.getRetProfit() + (saleRow.getProfit() * returnedShare));
                itemAccum2.getSales().add(new ItemSale(receipt, saleRow));
            }
        }
        Collection values = linkedHashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(values, 10));
        for (Iterator it = r0.iterator(); it.hasNext(); it = it) {
            ItemAccum itemAccum3 = (ItemAccum) it.next();
            arrayList.add(new ItemAgg(itemAccum3.getKey(), itemAccum3.getName(), itemAccum3.getUnit(), itemAccum3.getQty(), itemAccum3.getRetQty(), itemAccum3.getRevenue(), Num.INSTANCE.money(itemAccum3.getRetAmount()), itemAccum3.getProfit(), Num.INSTANCE.qty(itemAccum3.getQty() - itemAccum3.getRetQty()), Num.INSTANCE.money(itemAccum3.getRevenue() - itemAccum3.getRetAmount()), Num.INSTANCE.money(itemAccum3.getProfit() - itemAccum3.getRetProfit()), itemAccum3.getSales()));
        }
        ArrayList arrayList2 = arrayList;
        if (Intrinsics.areEqual(str, "qty")) {
            return CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$aggregateItems$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Double.valueOf(((ItemAgg) t2).getNetQty()), Double.valueOf(((ItemAgg) t).getNetQty()));
                }
            });
        }
        return CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$aggregateItems$$inlined$sortedByDescending$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Double.valueOf(((ItemAgg) t2).getNetRevenue()), Double.valueOf(((ItemAgg) t).getNetRevenue()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ItemCard(final int i, final ItemAgg itemAgg, final boolean z, final Function0<Unit> function0, Composer composer, final int i2) {
        final int i3;
        int i4;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(345533714);
        ComposerKt.sourceInformation(startRestartGroup, "C(ItemCard)P(2)520@19695L3332,515@19431L3596:HistoryScreen.kt#fh874k");
        if ((i2 & 6) == 0) {
            i3 = i;
            i4 = (startRestartGroup.changed(i3) ? 4 : 2) | i2;
        } else {
            i3 = i;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= (i2 & 64) == 0 ? startRestartGroup.changed(itemAgg) : startRestartGroup.changedInstance(itemAgg) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        int i5 = i4;
        if (!startRestartGroup.shouldExecute((i5 & 1171) != 1170, i5 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(345533714, i5, -1, "uz.FonRo.pos.ui.money.ItemCard (HistoryScreen.kt:510)");
            }
            final String name = Units.INSTANCE.name(itemAgg.getUnit());
            final String str = Fmt.INSTANCE.plural(itemAgg.getSales().size(), LangKt.tx("продажа", new Object[0]), LangKt.tx("продажи", new Object[0]), LangKt.tx("продаж", new Object[0])) + LangKt.tx(" · продано %s %s", Fmt.INSTANCE.qf(Double.valueOf(itemAgg.getNetQty())), name);
            composer2 = startRestartGroup;
            BasicsKt.m9833OxSoftCardCe4qNIY(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(11.0f), 7, null), 0.0f, null, itemAgg.getHasReturn() ? Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10213getOrange0d7_KjU(), 0.07f) : Ox.INSTANCE.m10218getPanel20d7_KjU(), itemAgg.getHasReturn() ? Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10213getOrange0d7_KjU(), 0.45f, 0.0f, 0.0f, 0.0f, 14, null) : Ox.INSTANCE.m10189getBorder0d7_KjU(), function0, ComposableLambdaKt.rememberComposableLambda(2126149196, true, new Function3() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return HistoryScreenKt.ItemCard$lambda$0(i3, str, itemAgg, name, z, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), composer2, (458752 & (i5 << 6)) | 1572870, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda37
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HistoryScreenKt.ItemCard$lambda$1(i, itemAgg, z, function0, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ItemCard$lambda$0(final int i, String str, ItemAgg itemAgg, String str2, boolean z, ColumnScope OxSoftCard, Composer composer, int i2) {
        String str3;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C521@19705L2685,585@22451L570:HistoryScreen.kt#fh874k");
        if (!composer.shouldExecute((i2 & 17) != 16, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2126149196, i2, -1, "uz.FonRo.pos.ui.money.ItemCard.<anonymous> (HistoryScreen.kt:521)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
            Alignment.Vertical top = Alignment.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, top, composer, 54);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1457907452, "C526@19930L626,526@19893L663,542@20569L1811:HistoryScreen.kt#fh874k");
            m10011IcoBoxIv8Zu3U(Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10220getPrimary0d7_KjU(), 0.14f), ComposableLambdaKt.rememberComposableLambda(-1159175964, true, new Function2() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ItemCard$lambda$0$0$0;
                    ItemCard$lambda$0$0$0 = HistoryScreenKt.ItemCard$lambda$0$0$0(i, (Composer) obj, ((Integer) obj2).intValue());
                    return ItemCard$lambda$0$0$0;
                }
            }, composer, 54), composer, 48);
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
            ComposerKt.sourceInformationMarkerStart(composer, 511157466, "C543@20615L1495,575@22127L239:HistoryScreen.kt#fh874k");
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
            Alignment.Vertical top2 = Alignment.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, top2, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, fillMaxWidth$default2);
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
            Updater.m3815setimpl(m3808constructorimpl3, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -349053452, "C548@20843L311,555@21175L917:HistoryScreen.kt#fh874k");
            TextKt.m2798Text4IGK_g(itemAgg.getName(), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH3(), 0L, TextUnitKt.getSp(15), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 0, 3120, 55292);
            Alignment.Horizontal end = Alignment.INSTANCE.getEnd();
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), end, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, companion);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor4);
            } else {
                composer.useNode();
            }
            Composer m3808constructorimpl4 = Updater.m3808constructorimpl(composer);
            Updater.m3815setimpl(m3808constructorimpl4, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl4.getInserting() || !Intrinsics.areEqual(m3808constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m3808constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m3808constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3815setimpl(m3808constructorimpl4, materializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 2072510994, "C556@21245L291,563@21561L509:HistoryScreen.kt#fh874k");
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.nf(Double.valueOf(itemAgg.getNetRevenue())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), 0L, TextUnitKt.getSp(16), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 0, 3072, 57342);
            if (itemAgg.getHasReturn()) {
                str3 = LangKt.tx("Возврат -%s", Fmt.INSTANCE.nf(Double.valueOf(itemAgg.getRetAmount())));
            } else {
                str3 = Fmt.INSTANCE.qf(Double.valueOf(itemAgg.getNetQty())) + " " + str2;
            }
            TextKt.m2798Text4IGK_g(str3, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), itemAgg.getHasReturn() ? Ox.INSTANCE.m10214getOrangeDeep0d7_KjU() : Ox.INSTANCE.m10194getCyanInk0d7_KjU(), TextUnitKt.getSp(13.5d), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 0, 3072, 57342);
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
            TextKt.m2798Text4IGK_g(str, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(3.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 48, 3120, 55292);
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
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(11.0f), 0.0f, 0.0f, 13, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_43 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(7.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m930spacedBy0680j_43, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer, m1053paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor5);
            } else {
                composer.useNode();
            }
            Composer m3808constructorimpl5 = Updater.m3808constructorimpl(composer);
            Updater.m3815setimpl(m3808constructorimpl5, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl5.getInserting() || !Intrinsics.areEqual(m3808constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                m3808constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                m3808constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m3815setimpl(m3808constructorimpl5, materializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1299110435, "C589@22612L95:HistoryScreen.kt#fh874k");
            m10014RcTilet6yy7ic(LangKt.tx("Продано", new Object[0]), Fmt.INSTANCE.qf(Double.valueOf(itemAgg.getNetQty())) + " " + str2, Ox.INSTANCE.m10220getPrimary0d7_KjU(), Ox.INSTANCE.m10194getCyanInk0d7_KjU(), RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0, 0);
            if (z) {
                composer.startReplaceGroup(1299223770);
                ComposerKt.sourceInformation(composer, "591@22753L87");
                m10014RcTilet6yy7ic(LangKt.tx("Прибыль", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(itemAgg.getNetProfit())), Ox.INSTANCE.m10201getGreen0d7_KjU(), Ox.INSTANCE.m10202getGreenDeep0d7_KjU(), RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1299338129);
                composer.endReplaceGroup();
            }
            if (itemAgg.getHasReturn()) {
                composer.startReplaceGroup(1299371826);
                ComposerKt.sourceInformation(composer, "594@22902L95");
                m10014RcTilet6yy7ic(LangKt.tx("Возврат", new Object[0]), "-" + Fmt.INSTANCE.nf(Double.valueOf(itemAgg.getRetAmount())), Ox.INSTANCE.m10213getOrange0d7_KjU(), Ox.INSTANCE.m10214getOrangeDeep0d7_KjU(), RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1299493873);
                composer.endReplaceGroup();
            }
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
    public static final Unit ItemCard$lambda$0$0$0(int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C:HistoryScreen.kt#fh874k");
        if (composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1159175964, i2, -1, "uz.FonRo.pos.ui.money.ItemCard.<anonymous>.<anonymous>.<anonymous> (HistoryScreen.kt:528)");
            }
            if (i < 9) {
                composer.startReplaceGroup(-1473964611);
                ComposerKt.sourceInformation(composer, "529@20063L249");
                TextKt.m2798Text4IGK_g(String.valueOf(i + 1), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH3(), Ox.INSTANCE.m10220getPrimary0d7_KjU(), TextUnitKt.getSp(20), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 0, 0, 65534);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1473653960);
                ComposerKt.sourceInformation(composer, "536@20358L166");
                IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getBox(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(22.0f)), Ox.INSTANCE.m10220getPrimary0d7_KjU(), composer, 432, 0);
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

    /* JADX WARN: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0083  */
    /* renamed from: RcTile-t6yy7ic, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m10014RcTilet6yy7ic(final java.lang.String r43, final java.lang.String r44, final long r45, final long r47, androidx.compose.ui.Modifier r49, androidx.compose.runtime.Composer r50, final int r51, final int r52) {
        /*
            Method dump skipped, instructions count: 665
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.money.HistoryScreenKt.m10014RcTilet6yy7ic(java.lang.String, java.lang.String, long, long, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void ProductSalesSheet(final ItemAgg itemAgg, final boolean z, final Function0<Unit> function0, final Function1<? super Receipt, Unit> function1, Composer composer, final int i) {
        int i2;
        final boolean z2;
        final Function1<? super Receipt, Unit> function12;
        Composer startRestartGroup = composer.startRestartGroup(-533890721);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProductSalesSheet)641@24153L68,643@24280L4872,643@24227L4925:HistoryScreen.kt#fh874k");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(itemAgg) : startRestartGroup.changedInstance(itemAgg) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            z2 = z;
            i2 |= startRestartGroup.changed(z2) ? 32 : 16;
        } else {
            z2 = z;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function12 = function1;
            i2 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
        } else {
            function12 = function1;
        }
        int i3 = i2;
        boolean z3 = false;
        if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-533890721, i3, -1, "uz.FonRo.pos.ui.money.ProductSalesSheet (HistoryScreen.kt:639)");
            }
            final String name = Units.INSTANCE.name(itemAgg.getUnit());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1967868669, "CC(remember):HistoryScreen.kt#9igjgp");
            if ((i3 & 14) == 4 || ((i3 & 8) != 0 && startRestartGroup.changed(itemAgg))) {
                z3 = true;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = CollectionsKt.sortedWith(itemAgg.getSales(), new Comparator() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$ProductSalesSheet$lambda$0$$inlined$sortedByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((ItemSale) t2).getReceipt().getSoldAt(), ((ItemSale) t).getReceipt().getSoldAt());
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final List list = (List) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SheetsKt.OxCardSheet(itemAgg.getName(), function0, null, false, false, false, null, ComposableLambdaKt.rememberComposableLambda(1721283011, true, new Function3() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda42
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return HistoryScreenKt.ProductSalesSheet$lambda$1(ItemAgg.this, list, name, z2, function12, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i3 >> 3) & 112) | 12582912, 124);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda43
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HistoryScreenKt.ProductSalesSheet$lambda$2(ItemAgg.this, z, function0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ProductSalesSheet$lambda$1(ItemAgg itemAgg, List list, String str, boolean z, final Function1 function1, ColumnScope OxCardSheet, Composer composer, int i) {
        Composer composer2;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C644@24321L21,644@24290L4856:HistoryScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1721283011, i, -1, "uz.FonRo.pos.ui.money.ProductSalesSheet.<anonymous> (HistoryScreen.kt:644)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 461665293, "C645@24359L276,650@24648L540,659@25201L11,733@29126L10:HistoryScreen.kt#fh874k");
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.plural(itemAgg.getSales().size(), LangKt.tx("продажа", new Object[0]), LangKt.tx("продажи", new Object[0]), LangKt.tx("продаж", new Object[0])) + LangKt.tx(" за период", new Object[0]), PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(14.0f), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6873getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), composer, 48, 0, 65532);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(7.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer, 6);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1642816822, "C651@24722L87,652@24826L77:HistoryScreen.kt#fh874k");
            String qf = Fmt.INSTANCE.qf(Double.valueOf(itemAgg.getNetQty()));
            StringBuilder sb = new StringBuilder();
            sb.append(qf);
            sb.append(" ");
            String str2 = str;
            sb.append(str2);
            m10012MiniStatcf5BqRc(sb.toString(), LangKt.tx("Продано", new Object[0]), Ox.INSTANCE.m10220getPrimary0d7_KjU(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0, 0);
            m10012MiniStatcf5BqRc(Fmt.INSTANCE.nf(Double.valueOf(itemAgg.getNetRevenue())), LangKt.tx("Сумма", new Object[0]), Ox.INSTANCE.m10213getOrange0d7_KjU(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0, 0);
            if (z) {
                composer.startReplaceGroup(1643017732);
                ComposerKt.sourceInformation(composer, "654@24957L77");
                m10012MiniStatcf5BqRc(Fmt.INSTANCE.nf(Double.valueOf(itemAgg.getNetProfit())), LangKt.tx("Прибыль", new Object[0]), Ox.INSTANCE.m10201getGreen0d7_KjU(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0, 0);
                composer.endReplaceGroup();
                composer2 = composer;
            } else {
                composer.startReplaceGroup(1643139717);
                ComposerKt.sourceInformation(composer, "656@25080L76");
                m10012MiniStatcf5BqRc(Fmt.INSTANCE.nf(Double.valueOf(itemAgg.getRetAmount())), LangKt.tx("Возврат", new Object[0]), Ox.INSTANCE.m10219getPink0d7_KjU(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0, 0);
                composer2 = composer;
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(14.0f), composer2, 6);
            composer2.startReplaceGroup(1400392790);
            ComposerKt.sourceInformation(composer2, "*669@25710L31,670@25760L3339,665@25422L3677");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final ItemSale itemSale = (ItemSale) it.next();
                final SaleRow row = itemSale.getRow();
                final boolean z2 = row.getReturnedQuantity() > 0.001d;
                final double quantity = row.getQuantity() - row.getReturnedQuantity();
                Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(11.0f), 7, null);
                Ox ox = Ox.INSTANCE;
                long m10241tintBg5vOe2sY = z2 ? ox.m10241tintBg5vOe2sY(Ox.INSTANCE.m10213getOrange0d7_KjU(), 0.07f) : ox.m10218getPanel20d7_KjU();
                Ox ox2 = Ox.INSTANCE;
                long m4383copywmQWz5c$default = z2 ? Color.m4383copywmQWz5c$default(ox2.m10213getOrange0d7_KjU(), 0.45f, 0.0f, 0.0f, 0.0f, 14, null) : ox2.m10189getBorder0d7_KjU();
                ComposerKt.sourceInformationMarkerStart(composer2, -691888749, "CC(remember):HistoryScreen.kt#9igjgp");
                boolean changed = composer2.changed(function1) | composer2.changedInstance(itemSale);
                Object rememberedValue = composer2.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProductSalesSheet$lambda$1$0$1$0$0;
                            ProductSalesSheet$lambda$1$0$1$0$0 = HistoryScreenKt.ProductSalesSheet$lambda$1$0$1$0$0(Function1.this, itemSale);
                            return ProductSalesSheet$lambda$1$0$1$0$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                Function0 function0 = (Function0) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                final String str3 = str2;
                BasicsKt.m9833OxSoftCardCe4qNIY(m1053paddingqDBjuR0$default, 0.0f, null, m10241tintBg5vOe2sY, m4383copywmQWz5c$default, function0, ComposableLambdaKt.rememberComposableLambda(242994362, true, new Function3() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit ProductSalesSheet$lambda$1$0$1$1;
                        ProductSalesSheet$lambda$1$0$1$1 = HistoryScreenKt.ProductSalesSheet$lambda$1$0$1$1(z2, itemSale, row, quantity, str3, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return ProductSalesSheet$lambda$1$0$1$1;
                    }
                }, composer2, 54), composer, 1572870, 6);
                str2 = str;
                composer2 = composer;
            }
            Composer composer3 = composer2;
            composer3.endReplaceGroup();
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer3, 6);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductSalesSheet$lambda$1$0$1$0$0(Function1 function1, ItemSale itemSale) {
        function1.invoke(itemSale.getReceipt());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductSalesSheet$lambda$1$0$1$1(final boolean z, ItemSale itemSale, SaleRow saleRow, double d, String str, ColumnScope OxSoftCard, Composer composer, int i) {
        String str2;
        long m10241tintBg5vOe2sY;
        String str3;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C671@25782L3299:HistoryScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(242994362, i, -1, "uz.FonRo.pos.ui.money.ProductSalesSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HistoryScreen.kt:671)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
            Alignment.Vertical top = Alignment.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, top, composer, 54);
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
            ComposerKt.sourceInformationMarkerStart(composer, 819898288, "C678@26166L371,676@26030L507,686@26562L2497:HistoryScreen.kt#fh874k");
            if (z) {
                str2 = "C101@5232L9:Row.kt#2w3rfo";
                m10241tintBg5vOe2sY = Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10213getOrange0d7_KjU(), 0.16f);
            } else {
                str2 = "C101@5232L9:Row.kt#2w3rfo";
                m10241tintBg5vOe2sY = Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10220getPrimary0d7_KjU(), 0.14f);
            }
            m10011IcoBoxIv8Zu3U(m10241tintBg5vOe2sY, ComposableLambdaKt.rememberComposableLambda(-1867531998, true, new Function2() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProductSalesSheet$lambda$1$0$1$1$0$0;
                    ProductSalesSheet$lambda$1$0$1$1$0$0 = HistoryScreenKt.ProductSalesSheet$lambda$1$0$1$1$0$0(z, (Composer) obj, ((Integer) obj2).intValue());
                    return ProductSalesSheet$lambda$1$0$1$1$0$0;
                }
            }, composer, 54), composer, 48);
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
            ComposerKt.sourceInformationMarkerStart(composer, -828154142, "C687@26620L1883,720@28532L501:HistoryScreen.kt#fh874k");
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
            Alignment.Vertical top2 = Alignment.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, top2, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, fillMaxWidth$default2);
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
            Updater.m3815setimpl(m3808constructorimpl3, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, str2);
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1332474830, "C692@26908L506,701@27447L1026:HistoryScreen.kt#fh874k");
            TextKt.m2798Text4IGK_g(LangKt.tx("Чек #%s", shortTid(itemSale.getReceipt().getTransactionId())), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH3(), 0L, TextUnitKt.getSp(15), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 0, 3120, 55292);
            Alignment.Horizontal end = Alignment.INSTANCE.getEnd();
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), end, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, companion);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor4);
            } else {
                composer.useNode();
            }
            Composer m3808constructorimpl4 = Updater.m3808constructorimpl(composer);
            Updater.m3815setimpl(m3808constructorimpl4, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl4.getInserting() || !Intrinsics.areEqual(m3808constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m3808constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m3808constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3815setimpl(m3808constructorimpl4, materializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1186481095, "C702@27529L366,709@27932L507:HistoryScreen.kt#fh874k");
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.nf(Double.valueOf(saleRow.getTotalAmount())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), 0L, TextUnitKt.getSp(16), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 0, 3072, 57342);
            String str4 = Fmt.INSTANCE.qf(Double.valueOf(d)) + " " + str;
            TextStyle body = OxType.INSTANCE.getBody();
            long sp = TextUnitKt.getSp(13.5d);
            FontWeight extraBold = FontWeight.INSTANCE.getExtraBold();
            Ox ox = Ox.INSTANCE;
            TextKt.m2798Text4IGK_g(str4, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(body, z ? ox.m10214getOrangeDeep0d7_KjU() : ox.m10194getCyanInk0d7_KjU(), sp, extraBold, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 0, 3072, 57342);
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
            String dt$default = Fmt.dt$default(Fmt.INSTANCE, itemSale.getReceipt().getSoldAt(), false, 2, null);
            if (StringsKt.isBlank(itemSale.getReceipt().getCustomerName())) {
                str3 = "";
            } else {
                str3 = " · " + itemSale.getReceipt().getCustomerName();
            }
            TextKt.m2798Text4IGK_g(dt$default + str3, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(3.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 48, 3120, 55292);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductSalesSheet$lambda$1$0$1$1$0$0(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C679@26196L315:HistoryScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1867531998, i, -1, "uz.FonRo.pos.ui.money.ProductSalesSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HistoryScreen.kt:679)");
            }
            OxIcons oxIcons = OxIcons.INSTANCE;
            IconKt.m2255Iconww6aTOc(z ? oxIcons.getUndo() : oxIcons.getCart(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(22.0f)), z ? Ox.INSTANCE.m10215getOrangeInk0d7_KjU() : Ox.INSTANCE.m10220getPrimary0d7_KjU(), composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void ReceiptSheet(final FonRoApp FonRoApp, final AppNavigator appNavigator, Receipt receipt, boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        final Receipt receipt2 = receipt;
        final boolean z2 = z;
        Composer startRestartGroup = composer.startRestartGroup(1789781225);
        ComposerKt.sourceInformation(startRestartGroup, "C(ReceiptSheet)P(!1,2,4)749@29406L7,750@29430L24,758@29656L1090,786@30753L6699,755@29558L7894:HistoryScreen.kt#fh874k");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(FonRoApp) : startRestartGroup.changedInstance(FonRoApp) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(appNavigator) : startRestartGroup.changedInstance(appNavigator) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? startRestartGroup.changed(receipt2) : startRestartGroup.changedInstance(receipt2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1789781225, i3, -1, "uz.FonRo.pos.ui.money.ReceiptSheet (HistoryScreen.kt:747)");
            }
            final Repo repo = FonRoApp.getRepo();
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Context context = (Context) consume;
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
            final boolean hasReturn = receipt2.getHasReturn();
            final String label = PayType.INSTANCE.of(receipt2.getPaymentType()).getLabel();
            String tx = LangKt.tx("Проданный чек", new Object[0]);
            Function3 function3 = new Function3() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda38
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return HistoryScreenKt.ReceiptSheet$lambda$0(Repo.this, receipt2, function0, FonRoApp, appNavigator, coroutineScope, context, z2, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            receipt2 = receipt2;
            z2 = z2;
            composer2 = startRestartGroup;
            SheetsKt.OxCardSheet(tx, function0, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-1590970602, true, function3, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(958167373, true, new Function3() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda39
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return HistoryScreenKt.ReceiptSheet$lambda$1(hasReturn, receipt2, z2, label, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), composer2, ((i3 >> 9) & 112) | 14155776, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda40
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HistoryScreenKt.ReceiptSheet$lambda$2(FonRoApp.this, appNavigator, receipt2, z2, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReceiptSheet$lambda$0(Repo repo, final Receipt receipt, final Function0 function0, final FonRoApp FonRoApp, final AppNavigator appNavigator, final CoroutineScope coroutineScope, final Context context, final boolean z, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        int i3;
        String str;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C775@30353L282,773@30288L448:HistoryScreen.kt#fh874k");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1590970602, i2, -1, "uz.FonRo.pos.ui.money.ReceiptSheet.<anonymous> (HistoryScreen.kt:759)");
            }
            if (repo.can(Perm.MANAGE_RETURNS)) {
                composer.startReplaceGroup(-1641026542);
                ComposerKt.sourceInformation(composer, "762@29795L351,760@29723L538");
                String tx = LangKt.tx("Возврат товара", new Object[0]);
                ComposerKt.sourceInformationMarkerStart(composer, 85613653, "CC(remember):HistoryScreen.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(receipt) | composer.changed(function0) | composer.changedInstance(FonRoApp) | composer.changedInstance(appNavigator);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda33
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ReceiptSheet$lambda$0$0$0;
                            ReceiptSheet$lambda$0$0$0 = HistoryScreenKt.ReceiptSheet$lambda$0$0$0(Receipt.this, function0, FonRoApp, appNavigator);
                            return ReceiptSheet$lambda$0$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                i3 = 0;
                str = "CC(remember):HistoryScreen.kt#9igjgp";
                BasicsKt.OxButton(tx, (Function0) rememberedValue, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.DANGER, null, false, false, null, composer, 3072, 240);
                composer.endReplaceGroup();
            } else {
                i3 = 0;
                str = "CC(remember):HistoryScreen.kt#9igjgp";
                composer.startReplaceGroup(-1640478772);
                composer.endReplaceGroup();
            }
            String tx2 = LangKt.tx("Распечатать чек", new Object[i3]);
            ComposerKt.sourceInformationMarkerStart(composer, 85631440, str);
            boolean changedInstance2 = composer.changedInstance(coroutineScope) | composer.changedInstance(context) | composer.changedInstance(FonRoApp) | composer.changedInstance(receipt) | composer.changed(z);
            Object rememberedValue2 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Function0 function02 = new Function0() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda41
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ReceiptSheet$lambda$0$1$0;
                        ReceiptSheet$lambda$0$1$0 = HistoryScreenKt.ReceiptSheet$lambda$0$1$0(CoroutineScope.this, context, FonRoApp, receipt, z);
                        return ReceiptSheet$lambda$0$1$0;
                    }
                };
                composer.updateRememberedValue(function02);
                rememberedValue2 = function02;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx2, (Function0) rememberedValue2, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.CYAN, null, false, false, null, composer, 3072, 240);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptSheet$lambda$0$0$0(Receipt receipt, Function0 function0, FonRoApp FonRoApp, AppNavigator appNavigator) {
        ReturnsHandoff.INSTANCE.setPendingTransactionId(receipt.getTransactionId());
        function0.invoke();
        MainShellKt.openRoute(FonRoApp, appNavigator, Routes.RETURNS);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptSheet$lambda$0$1$0(CoroutineScope coroutineScope, Context context, FonRoApp FonRoApp, Receipt receipt, boolean z) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new HistoryScreenKt$ReceiptSheet$1$2$1$1(context, FonRoApp, receipt, z, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReceiptSheet$lambda$1(final boolean z, final Receipt receipt, final boolean z2, final String str, ColumnScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C787@30794L21,787@30763L6683:HistoryScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(958167373, i, -1, "uz.FonRo.pos.ui.money.ReceiptSheet.<anonymous> (HistoryScreen.kt:787)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1811742690, "C790@30869L2027,790@30862L2034,836@32947L1897,836@32940L1904,907@37002L411,907@36995L418,918@37426L10:HistoryScreen.kt#fh874k");
            PdCard(ComposableLambdaKt.rememberComposableLambda(-976795642, true, new Function2() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ReceiptSheet$lambda$1$0$0;
                    ReceiptSheet$lambda$1$0$0 = HistoryScreenKt.ReceiptSheet$lambda$1$0$0(z, receipt, (Composer) obj, ((Integer) obj2).intValue());
                    return ReceiptSheet$lambda$1$0$0;
                }
            }, composer, 54), composer, 6);
            PdCard(ComposableLambdaKt.rememberComposableLambda(1323753263, true, new Function2() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ReceiptSheet$lambda$1$0$1;
                    ReceiptSheet$lambda$1$0$1 = HistoryScreenKt.ReceiptSheet$lambda$1$0$1(Receipt.this, z2, str, (Composer) obj, ((Integer) obj2).intValue());
                    return ReceiptSheet$lambda$1$0$1;
                }
            }, composer, 54), composer, 6);
            if (z) {
                composer.startReplaceGroup(-1807877425);
                ComposerKt.sourceInformation(composer, "867@34925L435,867@34918L442");
                PdCard(ComposableLambdaKt.rememberComposableLambda(970288011, true, new Function2() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ReceiptSheet$lambda$1$0$2;
                        ReceiptSheet$lambda$1$0$2 = HistoryScreenKt.ReceiptSheet$lambda$1$0$2(Receipt.this, (Composer) obj, ((Integer) obj2).intValue());
                        return ReceiptSheet$lambda$1$0$2;
                    }
                }, composer, 54), composer, 6);
                if (!receipt.getReturns().isEmpty()) {
                    composer.startReplaceGroup(-1807392554);
                    ComposerKt.sourceInformation(composer, "877@35434L1478,877@35427L1485");
                    PdCard(ComposableLambdaKt.rememberComposableLambda(329559248, true, new Function2() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda25
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ReceiptSheet$lambda$1$0$3;
                            ReceiptSheet$lambda$1$0$3 = HistoryScreenKt.ReceiptSheet$lambda$1$0$3(Receipt.this, (Composer) obj, ((Integer) obj2).intValue());
                            return ReceiptSheet$lambda$1$0$3;
                        }
                    }, composer, 54), composer, 6);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-1805927029);
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1805913141);
                composer.endReplaceGroup();
            }
            PdCard(ComposableLambdaKt.rememberComposableLambda(-2070146098, true, new Function2() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ReceiptSheet$lambda$1$0$4;
                    ReceiptSheet$lambda$1$0$4 = HistoryScreenKt.ReceiptSheet$lambda$1$0$4(Receipt.this, z2, (Composer) obj, ((Integer) obj2).intValue());
                    return ReceiptSheet$lambda$1$0$4;
                }
            }, composer, 54), composer, 6);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer, 6);
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
    public static final Unit ReceiptSheet$lambda$1$0$0(final boolean z, Receipt receipt, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C791@30887L1394,820@32298L584:HistoryScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-976795642, i, -1, "uz.FonRo.pos.ui.money.ReceiptSheet.<anonymous>.<anonymous>.<anonymous> (HistoryScreen.kt:791)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
            Alignment.Vertical top = Alignment.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, top, composer, 54);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1118672923, "C796@31193L337,796@31115L415,804@31551L712:HistoryScreen.kt#fh874k");
            Ox ox = Ox.INSTANCE;
            Ox ox2 = Ox.INSTANCE;
            m10011IcoBoxIv8Zu3U(ox.m10241tintBg5vOe2sY(z ? ox2.m10213getOrange0d7_KjU() : ox2.m10201getGreen0d7_KjU(), 0.16f), ComposableLambdaKt.rememberComposableLambda(114087582, true, new Function2() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ReceiptSheet$lambda$1$0$0$0$0;
                    ReceiptSheet$lambda$1$0$0$0$0 = HistoryScreenKt.ReceiptSheet$lambda$1$0$0$0$0(z, (Composer) obj, ((Integer) obj2).intValue());
                    return ReceiptSheet$lambda$1$0$0$0$0;
                }
            }, composer, 54), composer, 48);
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
            ComposerKt.sourceInformationMarkerStart(composer, 117354459, "C805@31605L274,811@31904L45:HistoryScreen.kt#fh874k");
            TextKt.m2798Text4IGK_g(LangKt.tx("Чек #%s", shortTid(receipt.getTransactionId())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH2(), 0L, TextUnitKt.getSp(19), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), composer, 0, 3120, 55294);
            TextKt.m2798Text4IGK_g(Fmt.dt$default(Fmt.INSTANCE, receipt.getSoldAt(), false, 2, null), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 0, 0, 65534);
            Composer composer2 = composer;
            if (!StringsKt.isBlank(receipt.getCashierName())) {
                composer2.startReplaceGroup(117739819);
                ComposerKt.sourceInformation(composer2, "813@32036L179");
                TextKt.m2798Text4IGK_g(LangKt.tx("Кассир: %s", receipt.getCashierName()), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowSub(), Ox.INSTANCE.m10194getCyanInk0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(117965654);
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(11.0f), 0.0f, 0.0f, 13, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), composer2, 6);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, m1053paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(composer2, -1177202045, "C830@32742L52:HistoryScreen.kt#fh874k");
            if (z) {
                composer2.startReplaceGroup(-1177196869);
                ComposerKt.sourceInformation(composer2, "825@32527L172");
                BasicsKt.OxChip(receipt.getFullReturn() ? LangKt.tx("Полный возврат", new Object[0]) : LangKt.tx("Частичный возврат", new Object[0]), ChipTone.WARN, null, composer2, 48, 4);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1176985449);
                composer2.endReplaceGroup();
            }
            BasicsKt.OxChip(LangKt.tx("%s шт", Fmt.INSTANCE.qf(Double.valueOf(receipt.getNetQty()))), ChipTone.BLUE, null, composer2, 48, 4);
            if (receipt.isDebt()) {
                composer2.startReplaceGroup(-453605778);
                ComposerKt.sourceInformation(composer2, "831@32829L35");
                BasicsKt.OxChip(LangKt.tx("В долг", new Object[0]), ChipTone.WARN, null, composer2, 48, 4);
            } else {
                composer2.startReplaceGroup(-1176843593);
            }
            composer2.endReplaceGroup();
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
    public static final Unit ReceiptSheet$lambda$1$0$0$0$0(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C797@31219L289:HistoryScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(114087582, i, -1, "uz.FonRo.pos.ui.money.ReceiptSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HistoryScreen.kt:797)");
            }
            OxIcons oxIcons = OxIcons.INSTANCE;
            IconKt.m2255Iconww6aTOc(z ? oxIcons.getUndo() : oxIcons.getReceipt(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(22.0f)), z ? Ox.INSTANCE.m10215getOrangeInk0d7_KjU() : Ox.INSTANCE.m10211getOk0d7_KjU(), composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptSheet$lambda$1$0$1(Receipt receipt, boolean z, String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C837@32965L482,849@33778L75,853@34025L52,855@34176L7,858@34396L69,862@34778L52:HistoryScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1323753263, i, -1, "uz.FonRo.pos.ui.money.ReceiptSheet.<anonymous>.<anonymous>.<anonymous> (HistoryScreen.kt:837)");
            }
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(10.0f), 7, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m1053paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -300296143, "C842@33230L109,843@33360L69:HistoryScreen.kt#fh874k");
            TextKt.m2798Text4IGK_g(LangKt.tx("Оплата", new Object[0]), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH3(), 0L, 0L, FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 0, 0, 65532);
            BasicsKt.OxChip(receipt.getPaymentStatus(), receipt.isDebt() ? ChipTone.WARN : ChipTone.OK, null, composer, 0, 4);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            m10013PayLineFNF3uiM(LangKt.tx("Сумма продажи", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(Num.INSTANCE.money(receipt.getTotal() + receipt.getDiscountAmount()))), 0L, composer, 0, 4);
            if (receipt.getDiscountAmount() > 0.001d) {
                composer.startReplaceGroup(-455305113);
                ComposerKt.sourceInformation(composer, "851@33922L68");
                m10013PayLineFNF3uiM(LangKt.tx("Скидка", new Object[0]), "-" + Fmt.INSTANCE.nf(Double.valueOf(receipt.getDiscountAmount())), Ox.INSTANCE.m10214getOrangeDeep0d7_KjU(), composer, 0, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-455201325);
                composer.endReplaceGroup();
            }
            m10013PayLineFNF3uiM(LangKt.tx("К оплате", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(receipt.getTotal())), Ox.INSTANCE.m10194getCyanInk0d7_KjU(), composer, 0, 0);
            if (z) {
                composer.startReplaceGroup(816603361);
                ComposerKt.sourceInformation(composer, "854@34109L50");
                m10013PayLineFNF3uiM(LangKt.tx("Прибыль", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(receipt.getNetProfit())), Ox.INSTANCE.m10211getOk0d7_KjU(), composer, 0, 0);
            } else {
                composer.startReplaceGroup(-455051533);
            }
            composer.endReplaceGroup();
            PdSep(composer, 0);
            if (StringsKt.isBlank(receipt.getCashierName())) {
                composer.startReplaceGroup(-454931501);
            } else {
                composer.startReplaceGroup(816607295);
                ComposerKt.sourceInformation(composer, "856@34232L48");
                m10013PayLineFNF3uiM(LangKt.tx("Кассир", new Object[0]), receipt.getCashierName(), Ox.INSTANCE.m10194getCyanInk0d7_KjU(), composer, 0, 0);
            }
            composer.endReplaceGroup();
            if (StringsKt.isBlank(receipt.getCustomerName())) {
                composer.startReplaceGroup(-454833293);
            } else {
                composer.startReplaceGroup(816610432);
                ComposerKt.sourceInformation(composer, "857@34330L49");
                m10013PayLineFNF3uiM(LangKt.tx("Клиент", new Object[0]), receipt.getCustomerName(), Ox.INSTANCE.m10194getCyanInk0d7_KjU(), composer, 0, 0);
            }
            composer.endReplaceGroup();
            m10013PayLineFNF3uiM(LangKt.tx("Оплачено", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(receipt.getPaidAmount())) + " (" + str + ")", Ox.INSTANCE.m10211getOk0d7_KjU(), composer, 0, 0);
            if (receipt.getReceivedAmount() > 0.001d) {
                composer.startReplaceGroup(816616268);
                ComposerKt.sourceInformation(composer, "859@34512L61");
                m10013PayLineFNF3uiM(LangKt.tx("Получено", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(receipt.getReceivedAmount())), Ox.INSTANCE.m10194getCyanInk0d7_KjU(), composer, 0, 0);
            } else {
                composer.startReplaceGroup(-454640845);
            }
            composer.endReplaceGroup();
            if (receipt.getChangeAmount() > 0.001d) {
                composer.startReplaceGroup(816619655);
                ComposerKt.sourceInformation(composer, "860@34618L56");
                m10013PayLineFNF3uiM(LangKt.tx("Сдача", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(receipt.getChangeAmount())), Ox.INSTANCE.m10194getCyanInk0d7_KjU(), composer, 0, 0);
            } else {
                composer.startReplaceGroup(-454540653);
            }
            composer.endReplaceGroup();
            if (receipt.isDebt()) {
                composer.startReplaceGroup(816622439);
                ComposerKt.sourceInformation(composer, "861@34705L56");
                m10013PayLineFNF3uiM(LangKt.tx("Долг", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(receipt.getDebtAmount())), Ox.INSTANCE.m10214getOrangeDeep0d7_KjU(), composer, 0, 0);
            } else {
                composer.startReplaceGroup(-454454349);
            }
            composer.endReplaceGroup();
            m10013PayLineFNF3uiM(LangKt.tx("Итого", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(receipt.getNetTotal())), Ox.INSTANCE.m10194getCyanInk0d7_KjU(), composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptSheet$lambda$1$0$2(Receipt receipt, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C868@34947L217,873@35185L75,874@35281L61:HistoryScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(970288011, i, -1, "uz.FonRo.pos.ui.money.ReceiptSheet.<anonymous>.<anonymous>.<anonymous> (HistoryScreen.kt:868)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Возврат", new Object[0]), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(10.0f), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH3(), 0L, 0L, FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 48, 0, 65532);
            m10013PayLineFNF3uiM(LangKt.tx("Сумма возврата", new Object[0]), "-" + Fmt.INSTANCE.nf(Double.valueOf(receipt.getReturnedTotal())), Ox.INSTANCE.m10214getOrangeDeep0d7_KjU(), composer, 0, 0);
            m10013PayLineFNF3uiM(LangKt.tx("Осталось", new Object[0]), LangKt.tx("%s шт", Fmt.INSTANCE.qf(Double.valueOf(receipt.getNetQty()))), Ox.INSTANCE.m10211getOk0d7_KjU(), composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x01da, code lost:
    
        if (r1 == null) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit ReceiptSheet$lambda$1$0$3(uz.FonRo.pos.ui.money.Receipt r62, androidx.compose.runtime.Composer r63, int r64) {
        /*
            Method dump skipped, instructions count: 883
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.money.HistoryScreenKt.ReceiptSheet$lambda$1$0$3(uz.FonRo.pos.ui.money.Receipt, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptSheet$lambda$1$0$4(Receipt receipt, boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C908@37020L207,*915@37346L35:HistoryScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2070146098, i, -1, "uz.FonRo.pos.ui.money.ReceiptSheet.<anonymous>.<anonymous>.<anonymous> (HistoryScreen.kt:908)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Товары в чеке", new Object[0]), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(10.0f), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH3(), 0L, 0L, FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 48, 0, 65532);
            int i2 = 0;
            for (Object obj : receipt.getItems()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SaleRow saleRow = (SaleRow) obj;
                if (i2 > 0) {
                    composer.startReplaceGroup(1762018977);
                    ComposerKt.sourceInformation(composer, "914@37318L7");
                    PdSep(composer, 0);
                } else {
                    composer.startReplaceGroup(-1211979832);
                }
                composer.endReplaceGroup();
                ReceiptItemBlock(receipt, saleRow, z, composer, Receipt.$stable | (SaleRow.$stable << 3));
                i2 = i3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void ReceiptItemBlock(final Receipt receipt, final SaleRow saleRow, final boolean z, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(297015635);
        ComposerKt.sourceInformation(startRestartGroup, "C(ReceiptItemBlock)P(1,2)928@37628L407,939@38040L87:HistoryScreen.kt#fh874k");
        int i2 = (i & 6) == 0 ? ((i & 8) == 0 ? startRestartGroup.changed(receipt) : startRestartGroup.changedInstance(receipt) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(saleRow) : startRestartGroup.changedInstance(saleRow) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(297015635, i2, -1, "uz.FonRo.pos.ui.money.ReceiptItemBlock (HistoryScreen.kt:924)");
            }
            String name = Units.INSTANCE.name(saleRow.getUnitCode());
            double returnedQuantity = saleRow.getReturnedQuantity();
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(5.0f), 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), startRestartGroup, 6);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1190405799, "C932@37778L153,937@37940L89:HistoryScreen.kt#fh874k");
            TextKt.m2798Text4IGK_g(saleRow.getTitle(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowTitle(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), startRestartGroup, 0, 0, 65532);
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.nf(Double.valueOf(saleRow.getTotalAmount())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowTitle(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), startRestartGroup, 0, 0, 65534);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.qf(Double.valueOf(saleRow.getQuantity())) + " " + name + " x " + Fmt.INSTANCE.nf(Double.valueOf(saleRow.getSalePrice())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), startRestartGroup, 0, 0, 65534);
            startRestartGroup = startRestartGroup;
            if (returnedQuantity > 0.001d) {
                startRestartGroup.startReplaceGroup(760851298);
                ComposerKt.sourceInformation(startRestartGroup, "942@38163L65,943@38237L72,944@38318L152");
                m10013PayLineFNF3uiM(LangKt.tx("Возврат", new Object[0]), "-" + Fmt.INSTANCE.qf(Double.valueOf(returnedQuantity)) + " " + name, Ox.INSTANCE.m10214getOrangeDeep0d7_KjU(), startRestartGroup, 0, 0);
                m10013PayLineFNF3uiM(LangKt.tx("Осталось", new Object[0]), Fmt.INSTANCE.qf(Double.valueOf(saleRow.getQuantity() - returnedQuantity)) + " " + name, Ox.INSTANCE.m10211getOk0d7_KjU(), startRestartGroup, 0, 0);
                m10013PayLineFNF3uiM(LangKt.tx("Сумма возврата", new Object[0]), "-" + Fmt.INSTANCE.nf(Double.valueOf(Num.INSTANCE.money(saleRow.getTotalAmount() * saleRow.getReturnedShare()))), Ox.INSTANCE.m10214getOrangeDeep0d7_KjU(), startRestartGroup, 0, 0);
                for (ReturnDoc returnDoc : receipt.getReturns()) {
                    startRestartGroup.startReplaceGroup(1964217849);
                    ComposerKt.sourceInformation(startRestartGroup, "*954@38789L211");
                    for (ReturnLine returnLine : returnDoc.getLines()) {
                        if (returnLine.getSaleItemId() == saleRow.getId() || returnLine.getProductId() == saleRow.getProductId()) {
                            m10013PayLineFNF3uiM(LangKt.tx("Возврат от %s", Fmt.INSTANCE.dt(returnDoc.getCreatedAt(), false)), "-" + Fmt.INSTANCE.qf(Double.valueOf(returnLine.getQuantity())) + " " + name + " · " + Fmt.INSTANCE.nf(Double.valueOf(returnLine.getAmount())), Ox.INSTANCE.m10214getOrangeDeep0d7_KjU(), startRestartGroup, 0, 0);
                        }
                    }
                    startRestartGroup.endReplaceGroup();
                }
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(761694095);
                startRestartGroup.endReplaceGroup();
            }
            if (z) {
                startRestartGroup.startReplaceGroup(1964234116);
                ComposerKt.sourceInformation(startRestartGroup, "962@39050L49");
                m10013PayLineFNF3uiM(LangKt.tx("Прибыль", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(saleRow.getProfit())), Ox.INSTANCE.m10211getOk0d7_KjU(), startRestartGroup, 0, 0);
            } else {
                startRestartGroup.startReplaceGroup(761762543);
            }
            startRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HistoryScreenKt.ReceiptItemBlock$lambda$2(Receipt.this, saleRow, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void PdCard(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-2018964859);
        ComposerKt.sourceInformation(startRestartGroup, "C(PdCard)968@39243L263:HistoryScreen.kt#fh874k");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2018964859, i2, -1, "uz.FonRo.pos.ui.money.PdCard (HistoryScreen.kt:967)");
            }
            Modifier m1049padding3ABfNKs = PaddingKt.m1049padding3ABfNKs(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null), OxShape.INSTANCE.getCardSoft()), Ox.INSTANCE.m10218getPanel20d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getCardSoft()), Dp.m6989constructorimpl(14.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m1049padding3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 621585195, "C976@39495L9:HistoryScreen.kt#fh874k");
            function2.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HistoryScreenKt.PdCard$lambda$1(Function2.this, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void PdSep(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1444058820);
        ComposerKt.sourceInformation(startRestartGroup, "C(PdSep)981@39548L79:HistoryScreen.kt#fh874k");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1444058820, i, -1, "uz.FonRo.pos.ui.money.PdSep (HistoryScreen.kt:980)");
            }
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(10.0f), 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -760001287, "C981@39605L20:HistoryScreen.kt#fh874k");
            BasicsKt.m9830OxDivideriPRSM58(Ox.INSTANCE.m10189getBorder0d7_KjU(), 0.0f, startRestartGroup, 0, 2);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.HistoryScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HistoryScreenKt.PdSep$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
    
        if ((r71 & 4) != 0) goto L45;
     */
    /* renamed from: PayLine-FNF3uiM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m10013PayLineFNF3uiM(final java.lang.String r65, final java.lang.String r66, long r67, androidx.compose.runtime.Composer r69, final int r70, final int r71) {
        /*
            Method dump skipped, instructions count: 633
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.money.HistoryScreenKt.m10013PayLineFNF3uiM(java.lang.String, java.lang.String, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReceiptDoc buildReceiptDoc(FonRoApp FonRoApp, Receipt receipt, boolean z) {
        Repo repo = FonRoApp.getRepo();
        List createListBuilder = CollectionsKt.createListBuilder();
        if (receipt.getDiscountAmount() > 0.001d) {
            createListBuilder.add(new ReceiptTotal(LangKt.tx("Подытог", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(Num.INSTANCE.money(receipt.getTotal() + receipt.getDiscountAmount()))), false, false, 12, null));
            createListBuilder.add(new ReceiptTotal(LangKt.tx("Скидка", new Object[0]), "−" + Fmt.INSTANCE.nf(Double.valueOf(receipt.getDiscountAmount())), false, false, 12, null));
        }
        if (receipt.getReturnedTotal() > 0.001d) {
            createListBuilder.add(new ReceiptTotal(LangKt.tx("Возврат", new Object[0]), "−" + Fmt.INSTANCE.nf(Double.valueOf(receipt.getReturnedTotal())), false, false, 12, null));
        }
        createListBuilder.add(new ReceiptTotal(LangKt.tx("ИТОГО", new Object[0]), repo.money(Double.valueOf(receipt.getNetTotal())), true, true));
        if (z) {
            createListBuilder.add(new ReceiptTotal(LangKt.tx("Прибыль", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(receipt.getNetProfit())), false, false, 12, null));
        }
        List build = CollectionsKt.build(createListBuilder);
        List createListBuilder2 = CollectionsKt.createListBuilder();
        createListBuilder2.add(new ReceiptPay(LangKt.tx("Оплачено", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(receipt.getPaidAmount()))));
        if (receipt.getReceivedAmount() > 0.001d) {
            createListBuilder2.add(new ReceiptPay(LangKt.tx("Получено", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(receipt.getReceivedAmount()))));
        }
        if (receipt.getChangeAmount() > 0.001d) {
            createListBuilder2.add(new ReceiptPay(LangKt.tx("Сдача", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(receipt.getChangeAmount()))));
        }
        if (receipt.isDebt()) {
            createListBuilder2.add(new ReceiptPay(LangKt.tx("Долг", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(receipt.getDebtAmount()))));
        }
        List build2 = CollectionsKt.build(createListBuilder2);
        String transactionId = receipt.getTransactionId();
        String dt$default = Fmt.dt$default(Fmt.INSTANCE, receipt.getSoldAt(), false, 2, null);
        String raw = PayType.INSTANCE.of(receipt.getPaymentType()).getRaw();
        String paymentStatus = receipt.getPaymentStatus();
        boolean z2 = !receipt.isDebt();
        String customerName = receipt.getCustomerName();
        String str = !StringsKt.isBlank(customerName) ? customerName : null;
        String valueOf = String.valueOf(receipt.getItems().size());
        List<SaleRow> items = receipt.getItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
        for (SaleRow saleRow : items) {
            arrayList.add(new ReceiptLine(saleRow.getTitle(), Fmt.INSTANCE.qf(Double.valueOf(saleRow.getQuantity())) + " " + Units.INSTANCE.name(saleRow.getUnitCode()), saleRow.getSalePrice(), saleRow.getTotalAmount()));
        }
        return new ReceiptDoc(transactionId, dt$default, raw, paymentStatus, z2, str, valueOf, arrayList, build, build2, receipt.getTransactionId(), null, 2048, null);
    }

    private static final String shortTid(String str) {
        return StringsKt.take(str, 8);
    }

    private static final SyncData HistoryScreen$lambda$0(State<SyncData> state) {
        return state.getValue();
    }
}
