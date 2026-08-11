package uz.FonRo.pos.ui.money;

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
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
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
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
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
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.data.model.Customer;
import uz.FonRo.pos.data.model.DebtPayment;
import uz.FonRo.pos.data.model.DebtSale;
import uz.FonRo.pos.data.model.DebtSaleItem;
import uz.FonRo.pos.data.model.DebtsResponse;
import uz.FonRo.pos.data.model.PayType;
import uz.FonRo.pos.data.model.SyncData;
import uz.FonRo.pos.data.model.SyncSale;
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
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.PeriodKind;
import uz.FonRo.pos.ui.components.PeriodPickersKt;
import uz.FonRo.pos.ui.components.PeriodState;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.nav.Routes;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxDim;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: DebtsScreen.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0006\u001a(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\fH\u0002\u001a@\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001aG\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010%\u001aC\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\b-\u0010.\u001a;\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00112\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000102H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u00103\u001aU\u00104\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u00112\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0001022\b\b\u0002\u0010+\u001a\u00020,H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u00106\u001a9\u00107\u001a\u00020\u00012\u0006\u0010)\u001a\u00020*2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020*H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\b;\u0010<\u001a5\u0010=\u001a\u00020\u00012\u0006\u0010>\u001a\u00020\r2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00010@H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010A\u001a5\u0010B\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u00152\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00010@H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010D\u001a7\u0010E\u001a\u00020\u00012\u0006\u0010F\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\"H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010H\u001a'\u0010I\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u001aH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010J\u001aM\u0010K\u001a\u00020\u00012\u0006\u0010>\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00010@2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00010@H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010N\u001aI\u0010O\u001a\u00020\u00012\u0006\u0010P\u001a\u00020\u00152\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00010@2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000102H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010R\u001aK\u0010S\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\r2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00010@2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00010@H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010U\u001aO\u0010V\u001a\u00020\u00012\u0006\u00108\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00112\u0006\u00100\u001a\u00020W2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00010@2\b\b\u0002\u0010+\u001a\u00020,H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010X\u001a/\u0010Y\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0011H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010Z\u001a'\u0010[\u001a\u00020\u00012\u0006\u0010\\\u001a\u00020\u0011H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010]\u001a?\u0010^\u001a\u00020\u00012\u0006\u0010\\\u001a\u00020\u00112\u0006\u0010_\u001a\u00020\u00112\u0006\u0010`\u001a\u00020\u00112\u0006\u0010a\u001a\u00020\u0011H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010b\u001a\u0010\u0010c\u001a\u00020\u00112\u0006\u0010d\u001a\u00020\u0011H\u0002¨\u0006\u0002²\u0006\f\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u008a\u0084\u0002²\u0006\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\fX\u008a\u0084\u0002²\u0006\f\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u008a\u008e\u0002²\u0006\f\u0010e\u001a\u0004\u0018\u00010\u0011X\u008a\u008e\u0002²\u0006\n\u0010f\u001a\u00020\"X\u008a\u008e\u0002²\u0006\n\u0010g\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010h\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010i\u001a\u00020WX\u008a\u008e\u0002²\u0006\n\u0010j\u001a\u00020WX\u008a\u008e\u0002²\u0006\f\u0010k\u001a\u0004\u0018\u00010\rX\u008a\u008e\u0002²\u0006\f\u0010l\u001a\u0004\u0018\u00010\u0015X\u008a\u008e\u0002²\u0006\f\u0010m\u001a\u0004\u0018\u00010\rX\u008a\u008e\u0002²\u0006\n\u0010n\u001a\u00020oX\u008a\u008e\u0002²\u0006\n\u0010_\u001a\u00020pX\u008a\u008e\u0002²\u0006\n\u0010q\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010r\u001a\u00020WX\u008a\u008e\u0002²\u0006\n\u0010s\u001a\u00020WX\u008a\u008e\u0002"}, d2 = {"DebtsScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "filterDebtSales", "", "Luz/FonRo/pos/data/model/DebtSale;", "data", "Luz/FonRo/pos/data/model/DebtsResponse;", FirebaseAnalytics.Event.SEARCH, "", TypedValues.CycleType.S_WAVE_PERIOD, "Luz/FonRo/pos/ui/components/PeriodState;", "buildDebtCustomers", "Luz/FonRo/pos/ui/money/DebtCustomer;", "sales", "customers", "Luz/FonRo/pos/data/model/Customer;", "buildClosures", "Luz/FonRo/pos/ui/money/DebtClosure;", "sync", "Luz/FonRo/pos/data/model/SyncData;", "openDebts", "DebtHero", "total", "periodTitle", "salesCount", "", "customersCount", "rowsCount", "(Ljava/lang/String;Ljava/lang/String;IIILandroidx/compose/runtime/Composer;I)V", "DebtStat", "value", "label", "tint", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "DebtStat-cf5BqRc", "(Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DebtTabs", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "onSelect", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "DebtTab", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DebtIco", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ink", "DebtIco-M3jwhU8", "(JLandroidx/compose/ui/graphics/vector/ImageVector;JLandroidx/compose/runtime/Composer;I)V", "DebtSaleCard", Routes.SALE, "onClick", "Lkotlin/Function0;", "(Luz/FonRo/pos/data/model/DebtSale;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DebtCustomerCard", "c", "(Luz/FonRo/pos/ui/money/DebtCustomer;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ClosuresHead", "totalText", "money", "(Ljava/lang/String;Ljava/lang/String;ILandroidx/compose/runtime/Composer;I)V", "ClosureCard", "(Luz/FonRo/pos/ui/money/DebtClosure;Landroidx/compose/runtime/Composer;I)V", "DebtDetailSheet", "onDismiss", "onClose", "(Luz/FonRo/pos/data/model/DebtSale;Luz/FonRo/pos/data/model/SyncData;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DebtCustomerSheet", "customer", "onOpenSale", "(Luz/FonRo/pos/ui/money/DebtCustomer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "DebtPaySheet", "onPaid", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/data/model/DebtSale;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "PayTypeButton", "", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DdRow", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "DdSection", "title", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "PaymentRow", "amount", "firstSub", "secondSub", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "payLabel", "code", "error", "reloadKey", "searchInput", "tab", "monthSheet", "dateSheet", "detailSale", "customerSheet", "paySale", "payType", "Luz/FonRo/pos/data/model/PayType;", "", "note", "pad", "busy"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class DebtsScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClosureCard$lambda$2(DebtClosure debtClosure, int i, Composer composer, int i2) {
        ClosureCard(debtClosure, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClosuresHead$lambda$1(String str, String str2, int i, int i2, Composer composer, int i3) {
        ClosuresHead(str, str2, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DdRow$lambda$1(String str, String str2, int i, Composer composer, int i2) {
        DdRow(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DdSection$lambda$0(String str, int i, Composer composer, int i2) {
        DdSection(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebtCustomerCard$lambda$2(DebtCustomer debtCustomer, Function0 function0, int i, Composer composer, int i2) {
        DebtCustomerCard(debtCustomer, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebtCustomerSheet$lambda$2(DebtCustomer debtCustomer, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        DebtCustomerSheet(debtCustomer, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebtDetailSheet$lambda$4(DebtSale debtSale, SyncData syncData, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        DebtDetailSheet(debtSale, syncData, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebtHero$lambda$1(String str, String str2, int i, int i2, int i3, int i4, Composer composer, int i5) {
        DebtHero(str, str2, i, i2, i3, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebtIco_M3jwhU8$lambda$1(long j, ImageVector imageVector, long j2, int i, Composer composer, int i2) {
        m9988DebtIcoM3jwhU8(j, imageVector, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebtPaySheet$lambda$19(FonRoApp FonRoApp, DebtSale debtSale, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        DebtPaySheet(FonRoApp, debtSale, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebtSaleCard$lambda$2(DebtSale debtSale, Function0 function0, int i, Composer composer, int i2) {
        DebtSaleCard(debtSale, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebtStat_cf5BqRc$lambda$1(String str, String str2, long j, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m9989DebtStatcf5BqRc(str, str2, j, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebtTab$lambda$2(String str, String str2, String str3, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DebtTab(str, str2, str3, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebtTabs$lambda$1(String str, Function1 function1, int i, Composer composer, int i2) {
        DebtTabs(str, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebtsScreen$lambda$52(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        DebtsScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PayTypeButton$lambda$1(String str, String str2, boolean z, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PayTypeButton(str, str2, z, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PaymentRow$lambda$1(String str, String str2, String str3, String str4, int i, Composer composer, int i2) {
        PaymentRow(str, str2, str3, str4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void DebtsScreen(FonRoApp FonRoApp, final AppNavigator nav, Composer composer, final int i) {
        int i2;
        Composer composer2;
        final State state;
        final MutableState mutableState;
        final MutableState mutableState2;
        final MutableState mutableState3;
        final MutableState mutableState4;
        final MutableState mutableState5;
        final MutableState mutableState6;
        final FonRoApp app = FonRoApp;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(nav, "nav");
        Composer startRestartGroup = composer.startRestartGroup(-53230880);
        ComposerKt.sourceInformation(startRestartGroup, "C(DebtsScreen)94@3918L24,95@3969L29,96@4035L29,98@4082L49,99@4149L42,100@4213L30,102@4268L31,103@4318L31,104@4368L63,105@4447L36,107@4507L34,108@4563L34,109@4620L44,110@4690L48,111@4758L44,113@4834L414,113@4808L440,129@5404L55,129@5376L83,134@5477L72,135@5574L67,136@5661L116,147@6048L4429,144@5896L4581:DebtsScreen.kt#fh874k");
        if ((i & 6) == 0) {
            i2 = i | ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-53230880, i2, -1, "uz.FonRo.pos.ui.money.DebtsScreen (DebtsScreen.kt:92)");
            }
            final Repo repo = app.getRepo();
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
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(repo.getSync(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            State collectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(repo.getCustomers(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 384740145, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState7 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 384742282, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            MutableState mutableState8 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 384744318, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState9 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 384746079, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState10 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 384747679, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            int i3 = i2;
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            MutableState mutableState11 = (MutableState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 384749311, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PeriodState(PeriodKind.ALL, null, null, 6, null), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final MutableState mutableState12 = (MutableState) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 384751812, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("sales", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            final MutableState mutableState13 = (MutableState) rememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 384753730, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                rememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            final MutableState mutableState14 = (MutableState) rememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 384755522, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                rememberedValue10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            final MutableState mutableState15 = (MutableState) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 384757356, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                rememberedValue11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            final MutableState mutableState16 = (MutableState) rememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 384759600, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue12 = startRestartGroup.rememberedValue();
            if (rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                rememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            final MutableState mutableState17 = (MutableState) rememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 384761772, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue13 = startRestartGroup.rememberedValue();
            if (rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                rememberedValue13 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue13);
            }
            MutableState mutableState18 = (MutableState) rememberedValue13;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Integer valueOf = Integer.valueOf(DebtsScreen$lambda$9(mutableState9));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 384764574, "CC(remember):DebtsScreen.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(repo);
            Object rememberedValue14 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                rememberedValue14 = (Function2) new DebtsScreenKt$DebtsScreen$1$1(mutableState7, mutableState8, repo, null);
                startRestartGroup.updateRememberedValue(rememberedValue14);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue14, startRestartGroup, 0);
            String DebtsScreen$lambda$12 = DebtsScreen$lambda$12(mutableState10);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 384782455, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue15 = startRestartGroup.rememberedValue();
            if (rememberedValue15 == Composer.INSTANCE.getEmpty()) {
                rememberedValue15 = (Function2) new DebtsScreenKt$DebtsScreen$2$1(mutableState10, mutableState11, null);
                startRestartGroup.updateRememberedValue(rememberedValue15);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(DebtsScreen$lambda$12, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue15, startRestartGroup, 0);
            Object DebtsScreen$lambda$3 = DebtsScreen$lambda$3(mutableState7);
            Object DebtsScreen$lambda$15 = DebtsScreen$lambda$15(mutableState11);
            Object DebtsScreen$lambda$18 = DebtsScreen$lambda$18(mutableState12);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 384784808, "CC(remember):DebtsScreen.kt#9igjgp");
            boolean changed = startRestartGroup.changed(DebtsScreen$lambda$3) | startRestartGroup.changed(DebtsScreen$lambda$15) | startRestartGroup.changed(DebtsScreen$lambda$18);
            Object rememberedValue16 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue16 == Composer.INSTANCE.getEmpty()) {
                rememberedValue16 = filterDebtSales(DebtsScreen$lambda$3(mutableState7), DebtsScreen$lambda$15(mutableState11), DebtsScreen$lambda$18(mutableState12));
                startRestartGroup.updateRememberedValue(rememberedValue16);
            }
            final List list = (List) rememberedValue16;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Object DebtsScreen$lambda$1 = DebtsScreen$lambda$1(collectAsStateWithLifecycle2);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 384787907, "CC(remember):DebtsScreen.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(DebtsScreen$lambda$1) | startRestartGroup.changed(list);
            Object rememberedValue17 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue17 == Composer.INSTANCE.getEmpty()) {
                rememberedValue17 = buildDebtCustomers(list, DebtsScreen$lambda$1(collectAsStateWithLifecycle2));
                startRestartGroup.updateRememberedValue(rememberedValue17);
            }
            final List list2 = (List) rememberedValue17;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Object DebtsScreen$lambda$0 = DebtsScreen$lambda$0(collectAsStateWithLifecycle);
            Object DebtsScreen$lambda$32 = DebtsScreen$lambda$3(mutableState7);
            Object DebtsScreen$lambda$13 = DebtsScreen$lambda$1(collectAsStateWithLifecycle2);
            Object DebtsScreen$lambda$152 = DebtsScreen$lambda$15(mutableState11);
            Object DebtsScreen$lambda$182 = DebtsScreen$lambda$18(mutableState12);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 384790740, "CC(remember):DebtsScreen.kt#9igjgp");
            boolean changed3 = startRestartGroup.changed(DebtsScreen$lambda$0) | startRestartGroup.changed(DebtsScreen$lambda$32) | startRestartGroup.changed(DebtsScreen$lambda$13) | startRestartGroup.changed(DebtsScreen$lambda$152) | startRestartGroup.changed(DebtsScreen$lambda$182);
            Object rememberedValue18 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue18 == Composer.INSTANCE.getEmpty()) {
                rememberedValue18 = buildClosures(DebtsScreen$lambda$0(collectAsStateWithLifecycle), DebtsScreen$lambda$3(mutableState7), DebtsScreen$lambda$1(collectAsStateWithLifecycle2), DebtsScreen$lambda$15(mutableState11), DebtsScreen$lambda$18(mutableState12));
                startRestartGroup.updateRememberedValue(rememberedValue18);
            }
            final List list3 = (List) rememberedValue18;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Iterator it = list.iterator();
            double d = AudioStats.AUDIO_AMPLITUDE_NONE;
            while (it.hasNext()) {
                d += ((DebtSale) it.next()).getDebtAmount();
            }
            String DebtsScreen$lambda$6 = DebtsScreen$lambda$6(mutableState8);
            if (DebtsScreen$lambda$6 == null) {
                DebtsScreen$lambda$6 = "";
            }
            boolean z = DebtsScreen$lambda$3(mutableState7) != null;
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), OxDim.INSTANCE.m10245getPagePadD9Ej5fM(), 0.0f, 2, null);
            PaddingValues m1046PaddingValuesa9UjIt4$default = PaddingKt.m1046PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(28.0f), 7, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 384807437, "CC(remember):DebtsScreen.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(repo) | startRestartGroup.changed(d) | startRestartGroup.changedInstance(list) | startRestartGroup.changed(DebtsScreen$lambda$6) | startRestartGroup.changed(z) | startRestartGroup.changedInstance(list2) | startRestartGroup.changed(collectAsStateWithLifecycle) | startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(list3);
            Object rememberedValue19 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue19 == Composer.INSTANCE.getEmpty()) {
                final String str = DebtsScreen$lambda$6;
                state = collectAsStateWithLifecycle;
                final double d2 = d;
                final boolean z2 = z;
                rememberedValue19 = new Function1() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DebtsScreen$lambda$44$0;
                        DebtsScreen$lambda$44$0 = DebtsScreenKt.DebtsScreen$lambda$44$0(str, z2, list, list2, list3, repo, d2, mutableState12, mutableState10, mutableState14, mutableState15, mutableState13, mutableState16, mutableState17, state, coroutineScope, (LazyListScope) obj);
                        return DebtsScreen$lambda$44$0;
                    }
                };
                mutableState = mutableState12;
                mutableState2 = mutableState14;
                mutableState3 = mutableState15;
                mutableState4 = mutableState16;
                mutableState5 = mutableState17;
                startRestartGroup.updateRememberedValue(rememberedValue19);
            } else {
                state = collectAsStateWithLifecycle;
                mutableState = mutableState12;
                mutableState2 = mutableState14;
                mutableState3 = mutableState15;
                mutableState4 = mutableState16;
                mutableState5 = mutableState17;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LazyDslKt.LazyColumn(m1051paddingVpY3zN4$default, null, m1046PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) rememberedValue19, startRestartGroup, 384, TypedValues.PositionType.TYPE_PERCENT_X);
            Composer composer3 = startRestartGroup;
            if (DebtsScreen$lambda$24(mutableState2)) {
                composer3.startReplaceGroup(-951584907);
                ComposerKt.sourceInformation(composer3, "269@10583L22,270@10628L124,267@10509L253");
                String month = DebtsScreen$lambda$18(mutableState).getMonth();
                ComposerKt.sourceInformationMarkerStart(composer3, 384948150, "CC(remember):DebtsScreen.kt#9igjgp");
                Object rememberedValue20 = composer3.rememberedValue();
                if (rememberedValue20 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue20 = new Function0() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit DebtsScreen$lambda$45$0;
                            DebtsScreen$lambda$45$0 = DebtsScreenKt.DebtsScreen$lambda$45$0(MutableState.this);
                            return DebtsScreen$lambda$45$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue20);
                }
                Function0 function0 = (Function0) rememberedValue20;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, 384949692, "CC(remember):DebtsScreen.kt#9igjgp");
                Object rememberedValue21 = composer3.rememberedValue();
                if (rememberedValue21 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue21 = new Function1() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda31
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit DebtsScreen$lambda$46$0;
                            DebtsScreen$lambda$46$0 = DebtsScreenKt.DebtsScreen$lambda$46$0(MutableState.this, mutableState2, (String) obj);
                            return DebtsScreen$lambda$46$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue21);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                PeriodPickersKt.OxMonthSheet(month, function0, (Function1) rememberedValue21, composer3, 432);
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(-951326398);
                composer3.endReplaceGroup();
            }
            if (DebtsScreen$lambda$27(mutableState3)) {
                composer3.startReplaceGroup(-951297227);
                ComposerKt.sourceInformation(composer3, "280@10877L21,281@10921L121,278@10799L253");
                String date = DebtsScreen$lambda$18(mutableState).getDate();
                ComposerKt.sourceInformationMarkerStart(composer3, 384957557, "CC(remember):DebtsScreen.kt#9igjgp");
                Object rememberedValue22 = composer3.rememberedValue();
                if (rememberedValue22 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue22 = new Function0() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda32
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit DebtsScreen$lambda$47$0;
                            DebtsScreen$lambda$47$0 = DebtsScreenKt.DebtsScreen$lambda$47$0(MutableState.this);
                            return DebtsScreen$lambda$47$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue22);
                }
                Function0 function02 = (Function0) rememberedValue22;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, 384959065, "CC(remember):DebtsScreen.kt#9igjgp");
                Object rememberedValue23 = composer3.rememberedValue();
                if (rememberedValue23 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue23 = new Function1() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda34
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit DebtsScreen$lambda$48$0;
                            DebtsScreen$lambda$48$0 = DebtsScreenKt.DebtsScreen$lambda$48$0(MutableState.this, mutableState3, (String) obj);
                            return DebtsScreen$lambda$48$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue23);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                PeriodPickersKt.OxDayPickerDialog(date, function02, (Function1) rememberedValue23, composer3, 432);
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(-951038718);
                composer3.endReplaceGroup();
            }
            final DebtSale DebtsScreen$lambda$30 = DebtsScreen$lambda$30(mutableState4);
            if (DebtsScreen$lambda$30 != null) {
                composer3.startReplaceGroup(-951014321);
                ComposerKt.sourceInformation(composer3, "*292@11189L21,293@11234L37,289@11098L183");
                SyncData DebtsScreen$lambda$02 = DebtsScreen$lambda$0(state);
                ComposerKt.sourceInformationMarkerStart(composer3, -2053312502, "CC(remember):DebtsScreen.kt#9igjgp");
                Object rememberedValue24 = composer3.rememberedValue();
                if (rememberedValue24 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue24 = new Function0() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda35
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit DebtsScreen$lambda$49$0$0;
                            DebtsScreen$lambda$49$0$0 = DebtsScreenKt.DebtsScreen$lambda$49$0$0(MutableState.this);
                            return DebtsScreen$lambda$49$0$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue24);
                }
                Function0 function03 = (Function0) rememberedValue24;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -2053311046, "CC(remember):DebtsScreen.kt#9igjgp");
                boolean changedInstance3 = composer3.changedInstance(DebtsScreen$lambda$30);
                Object rememberedValue25 = composer3.rememberedValue();
                if (changedInstance3 || rememberedValue25 == Composer.INSTANCE.getEmpty()) {
                    mutableState6 = mutableState18;
                    rememberedValue25 = new Function0() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda36
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit DebtsScreen$lambda$49$1$0;
                            DebtsScreen$lambda$49$1$0 = DebtsScreenKt.DebtsScreen$lambda$49$1$0(DebtSale.this, mutableState4, mutableState6);
                            return DebtsScreen$lambda$49$1$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue25);
                } else {
                    mutableState6 = mutableState18;
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                DebtDetailSheet(DebtsScreen$lambda$30, DebtsScreen$lambda$02, function03, (Function0) rememberedValue25, composer3, DebtSale.$stable | 384 | (SyncData.$stable << 3));
                Unit unit = Unit.INSTANCE;
                composer3.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            } else {
                composer3.startReplaceGroup(-951014322);
                composer3.endReplaceGroup();
                mutableState6 = mutableState18;
            }
            DebtCustomer DebtsScreen$lambda$33 = DebtsScreen$lambda$33(mutableState5);
            if (DebtsScreen$lambda$33 != null) {
                composer3.startReplaceGroup(-950784332);
                ComposerKt.sourceInformation(composer3, "*300@11396L24,301@11447L51,298@11327L181");
                ComposerKt.sourceInformationMarkerStart(composer3, 516946527, "CC(remember):DebtsScreen.kt#9igjgp");
                Object rememberedValue26 = composer3.rememberedValue();
                if (rememberedValue26 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue26 = new Function0() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda37
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit DebtsScreen$lambda$50$0$0;
                            DebtsScreen$lambda$50$0$0 = DebtsScreenKt.DebtsScreen$lambda$50$0$0(MutableState.this);
                            return DebtsScreen$lambda$50$0$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue26);
                }
                Function0 function04 = (Function0) rememberedValue26;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, 516948186, "CC(remember):DebtsScreen.kt#9igjgp");
                Object rememberedValue27 = composer3.rememberedValue();
                if (rememberedValue27 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue27 = new Function1() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda38
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit DebtsScreen$lambda$50$1$0;
                            DebtsScreen$lambda$50$1$0 = DebtsScreenKt.DebtsScreen$lambda$50$1$0(MutableState.this, mutableState4, (DebtSale) obj);
                            return DebtsScreen$lambda$50$1$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue27);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                DebtCustomerSheet(DebtsScreen$lambda$33, function04, (Function1) rememberedValue27, composer3, 432);
                Unit unit3 = Unit.INSTANCE;
                composer3.endReplaceGroup();
                Unit unit4 = Unit.INSTANCE;
            } else {
                composer3.startReplaceGroup(-950784333);
                composer3.endReplaceGroup();
            }
            DebtSale DebtsScreen$lambda$36 = DebtsScreen$lambda$36(mutableState6);
            if (DebtsScreen$lambda$36 != null) {
                composer3.startReplaceGroup(-950565906);
                ComposerKt.sourceInformation(composer3, "*309@11637L18,310@11678L15,306@11551L152");
                ComposerKt.sourceInformationMarkerStart(composer3, 208255407, "CC(remember):DebtsScreen.kt#9igjgp");
                Object rememberedValue28 = composer3.rememberedValue();
                if (rememberedValue28 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue28 = new Function0() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda39
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit DebtsScreen$lambda$51$0$0;
                            DebtsScreen$lambda$51$0$0 = DebtsScreenKt.DebtsScreen$lambda$51$0$0(MutableState.this);
                            return DebtsScreen$lambda$51$0$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue28);
                }
                Function0 function05 = (Function0) rememberedValue28;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, 208256716, "CC(remember):DebtsScreen.kt#9igjgp");
                Object rememberedValue29 = composer3.rememberedValue();
                if (rememberedValue29 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue29 = new Function0() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda28
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit DebtsScreen$lambda$51$1$0;
                            DebtsScreen$lambda$51$1$0 = DebtsScreenKt.DebtsScreen$lambda$51$1$0(MutableState.this);
                            return DebtsScreen$lambda$51$1$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue29);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                app = FonRoApp;
                DebtPaySheet(app, DebtsScreen$lambda$36, function05, (Function0) rememberedValue29, composer3, FonRoApp.$stable | 3456 | (i3 & 14) | (DebtSale.$stable << 3));
                Unit unit5 = Unit.INSTANCE;
                composer3.endReplaceGroup();
                Unit unit6 = Unit.INSTANCE;
            } else {
                composer3.startReplaceGroup(-950565907);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DebtsScreenKt.DebtsScreen$lambda$52(FonRoApp.this, nav, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final DebtsResponse DebtsScreen$lambda$3(MutableState<DebtsResponse> mutableState) {
        return mutableState.getValue();
    }

    private static final String DebtsScreen$lambda$6(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final void DebtsScreen$lambda$10(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final int DebtsScreen$lambda$9(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String DebtsScreen$lambda$12(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String DebtsScreen$lambda$15(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final PeriodState DebtsScreen$lambda$18(MutableState<PeriodState> mutableState) {
        return mutableState.getValue();
    }

    private static final String DebtsScreen$lambda$21(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean DebtsScreen$lambda$24(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void DebtsScreen$lambda$25(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean DebtsScreen$lambda$27(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void DebtsScreen$lambda$28(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final DebtSale DebtsScreen$lambda$30(MutableState<DebtSale> mutableState) {
        return mutableState.getValue();
    }

    private static final DebtCustomer DebtsScreen$lambda$33(MutableState<DebtCustomer> mutableState) {
        return mutableState.getValue();
    }

    private static final DebtSale DebtsScreen$lambda$36(MutableState<DebtSale> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$44$0(final String str, boolean z, final List list, final List list2, final List list3, final Repo repo, final double d, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, State state, final CoroutineScope coroutineScope, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$DebtsScreenKt.INSTANCE.getLambda$1750416939$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1966279508, true, new Function3() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit DebtsScreen$lambda$44$0$0;
                DebtsScreen$lambda$44$0$0 = DebtsScreenKt.DebtsScreen$lambda$44$0$0(Repo.this, d, list, mutableState, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return DebtsScreen$lambda$44$0$0;
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-642787853, true, new Function3() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit DebtsScreen$lambda$44$0$1;
                DebtsScreen$lambda$44$0$1 = DebtsScreenKt.DebtsScreen$lambda$44$0$1(MutableState.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return DebtsScreen$lambda$44$0$1;
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1043112082, true, new Function3() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit DebtsScreen$lambda$44$0$2;
                DebtsScreen$lambda$44$0$2 = DebtsScreenKt.DebtsScreen$lambda$44$0$2(MutableState.this, mutableState3, mutableState4, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return DebtsScreen$lambda$44$0$2;
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1565955279, true, new Function3() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit DebtsScreen$lambda$44$0$3;
                DebtsScreen$lambda$44$0$3 = DebtsScreenKt.DebtsScreen$lambda$44$0$3(MutableState.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return DebtsScreen$lambda$44$0$3;
            }
        }), 3, null);
        if (str.length() > 0) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-887748301, true, new Function3() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit DebtsScreen$lambda$44$0$4;
                    DebtsScreen$lambda$44$0$4 = DebtsScreenKt.DebtsScreen$lambda$44$0$4(str, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return DebtsScreen$lambda$44$0$4;
                }
            }), 3, null);
        } else if (!z) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$DebtsScreenKt.INSTANCE.getLambda$1363793258$app(), 3, null);
        } else if (Intrinsics.areEqual(DebtsScreen$lambda$21(mutableState5), "sales")) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(479057451, true, new Function3() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit DebtsScreen$lambda$44$0$5;
                    DebtsScreen$lambda$44$0$5 = DebtsScreenKt.DebtsScreen$lambda$44$0$5(list, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return DebtsScreen$lambda$44$0$5;
                }
            }), 3, null);
            if (list.isEmpty()) {
                LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$DebtsScreenKt.INSTANCE.m9970getLambda$291656976$app(), 3, null);
            } else {
                final Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Object DebtsScreen$lambda$44$0$6;
                        DebtsScreen$lambda$44$0$6 = DebtsScreenKt.DebtsScreen$lambda$44$0$6((DebtSale) obj);
                        return DebtsScreen$lambda$44$0$6;
                    }
                };
                final DebtsScreenKt$DebtsScreen$lambda$44$0$$inlined$items$default$1 debtsScreenKt$DebtsScreen$lambda$44$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$DebtsScreen$lambda$44$0$$inlined$items$default$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(DebtSale debtSale) {
                        return null;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke((DebtSale) obj);
                    }
                };
                LazyColumn.items(list.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$DebtsScreen$lambda$44$0$$inlined$items$default$2
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
                }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$DebtsScreen$lambda$44$0$$inlined$items$default$3
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
                }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$DebtsScreen$lambda$44$0$$inlined$items$default$4
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
                        final DebtSale debtSale = (DebtSale) list.get(i);
                        composer.startReplaceGroup(1121953728);
                        ComposerKt.sourceInformation(composer, "C*207@8180L21,207@8161L40:DebtsScreen.kt#fh874k");
                        ComposerKt.sourceInformationMarkerStart(composer, -656544016, "CC(remember):DebtsScreen.kt#9igjgp");
                        boolean changedInstance = composer.changedInstance(debtSale);
                        Object rememberedValue = composer.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            final MutableState mutableState8 = mutableState6;
                            rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$DebtsScreen$3$1$8$1$1
                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    mutableState8.setValue(DebtSale.this);
                                }
                            };
                            composer.updateRememberedValue(rememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        DebtsScreenKt.DebtSaleCard(debtSale, (Function0) rememberedValue, composer, DebtSale.$stable);
                        composer.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
            }
        } else if (Intrinsics.areEqual(DebtsScreen$lambda$21(mutableState5), "customers")) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-405678356, true, new Function3() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit DebtsScreen$lambda$44$0$8;
                    DebtsScreen$lambda$44$0$8 = DebtsScreenKt.DebtsScreen$lambda$44$0$8(list2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return DebtsScreen$lambda$44$0$8;
                }
            }), 3, null);
            if (list2.isEmpty()) {
                LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$DebtsScreenKt.INSTANCE.m9968getLambda$1176392783$app(), 3, null);
            } else {
                final Function1 function12 = new Function1() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Object DebtsScreen$lambda$44$0$9;
                        DebtsScreen$lambda$44$0$9 = DebtsScreenKt.DebtsScreen$lambda$44$0$9((DebtCustomer) obj);
                        return DebtsScreen$lambda$44$0$9;
                    }
                };
                final DebtsScreenKt$DebtsScreen$lambda$44$0$$inlined$items$default$5 debtsScreenKt$DebtsScreen$lambda$44$0$$inlined$items$default$5 = new Function1() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$DebtsScreen$lambda$44$0$$inlined$items$default$5
                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(DebtCustomer debtCustomer) {
                        return null;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke((DebtCustomer) obj);
                    }
                };
                LazyColumn.items(list2.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$DebtsScreen$lambda$44$0$$inlined$items$default$6
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
                }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$DebtsScreen$lambda$44$0$$inlined$items$default$7
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
                }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$DebtsScreen$lambda$44$0$$inlined$items$default$8
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
                        final DebtCustomer debtCustomer = (DebtCustomer) list2.get(i);
                        composer.startReplaceGroup(189922421);
                        ComposerKt.sourceInformation(composer, "C*225@8900L21,225@8880L41:DebtsScreen.kt#fh874k");
                        ComposerKt.sourceInformationMarkerStart(composer, 421769146, "CC(remember):DebtsScreen.kt#9igjgp");
                        boolean changedInstance = composer.changedInstance(debtCustomer);
                        Object rememberedValue = composer.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            final MutableState mutableState8 = mutableState7;
                            rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$DebtsScreen$3$1$11$1$1
                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    mutableState8.setValue(DebtCustomer.this);
                                }
                            };
                            composer.updateRememberedValue(rememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        DebtsScreenKt.DebtCustomerCard(debtCustomer, (Function0) rememberedValue, composer, 0);
                        composer.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
            }
        } else if (DebtsScreen$lambda$0(state) == null) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1615629041, true, new Function3() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit DebtsScreen$lambda$44$0$11;
                    DebtsScreen$lambda$44$0$11 = DebtsScreenKt.DebtsScreen$lambda$44$0$11(CoroutineScope.this, repo, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return DebtsScreen$lambda$44$0$11;
                }
            }), 3, null);
        } else {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1549313370, true, new Function3() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit DebtsScreen$lambda$44$0$12;
                    DebtsScreen$lambda$44$0$12 = DebtsScreenKt.DebtsScreen$lambda$44$0$12(list3, repo, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return DebtsScreen$lambda$44$0$12;
                }
            }), 3, null);
            if (list3.isEmpty()) {
                LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$DebtsScreenKt.INSTANCE.m9969getLambda$1937423125$app(), 3, null);
            } else {
                final Function1 function13 = new Function1() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Object DebtsScreen$lambda$44$0$13;
                        DebtsScreen$lambda$44$0$13 = DebtsScreenKt.DebtsScreen$lambda$44$0$13((DebtClosure) obj);
                        return DebtsScreen$lambda$44$0$13;
                    }
                };
                final DebtsScreenKt$DebtsScreen$lambda$44$0$$inlined$items$default$9 debtsScreenKt$DebtsScreen$lambda$44$0$$inlined$items$default$9 = new Function1() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$DebtsScreen$lambda$44$0$$inlined$items$default$9
                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(DebtClosure debtClosure) {
                        return null;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke((DebtClosure) obj);
                    }
                };
                LazyColumn.items(list3.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$DebtsScreen$lambda$44$0$$inlined$items$default$10
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int i) {
                        return Function1.this.invoke(list3.get(i));
                    }
                }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$DebtsScreen$lambda$44$0$$inlined$items$default$11
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int i) {
                        return Function1.this.invoke(list3.get(i));
                    }
                }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$DebtsScreen$lambda$44$0$$inlined$items$default$12
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
                        DebtClosure debtClosure = (DebtClosure) list3.get(i);
                        composer.startReplaceGroup(936709973);
                        ComposerKt.sourceInformation(composer, "C*259@10391L14:DebtsScreen.kt#fh874k");
                        DebtsScreenKt.ClosureCard(debtClosure, composer, 0);
                        composer.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$44$0$0(Repo repo, double d, List list, MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C153@6139L438:DebtsScreen.kt#fh874k");
        int i2 = 0;
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1966279508, i, -1, "uz.FonRo.pos.ui.money.DebtsScreen.<anonymous>.<anonymous>.<anonymous> (DebtsScreen.kt:153)");
            }
            String money = repo.money(Double.valueOf(d));
            String title = DebtsScreen$lambda$18(mutableState).title();
            int size = list.size();
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((DebtSale) it.next()).getCustomerId()));
            }
            int size2 = CollectionsKt.toSet(arrayList).size();
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                i2 += Math.max(1, ((DebtSale) it2.next()).getItems().size());
            }
            DebtHero(money, title, size, size2, i2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$44$0$1(final MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C167@6698L20,165@6616L230:DebtsScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-642787853, i, -1, "uz.FonRo.pos.ui.money.DebtsScreen.<anonymous>.<anonymous>.<anonymous> (DebtsScreen.kt:165)");
            }
            String DebtsScreen$lambda$12 = DebtsScreen$lambda$12(mutableState);
            String tx = LangKt.tx("Поиск по долгам", new Object[0]);
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null);
            ComposerKt.sourceInformationMarkerStart(composer, 756166983, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DebtsScreen$lambda$44$0$1$0$0;
                        DebtsScreen$lambda$44$0$1$0$0 = DebtsScreenKt.DebtsScreen$lambda$44$0$1$0$0(MutableState.this, (String) obj);
                        return DebtsScreen$lambda$44$0$1$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.OxSearchBox(DebtsScreen$lambda$12, (Function1) rememberedValue, m1053paddingqDBjuR0$default, tx, null, composer, 432, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$44$0$1$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$44$0$2(final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C176@6959L15,183@7259L21,184@7311L20,174@6885L460:DebtsScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1043112082, i, -1, "uz.FonRo.pos.ui.money.DebtsScreen.<anonymous>.<anonymous>.<anonymous> (DebtsScreen.kt:174)");
            }
            PeriodState DebtsScreen$lambda$18 = DebtsScreen$lambda$18(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 1703333665, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DebtsScreen$lambda$44$0$2$0$0;
                        DebtsScreen$lambda$44$0$2$0$0 = DebtsScreenKt.DebtsScreen$lambda$44$0$2$0$0(MutableState.this, (PeriodState) obj);
                        return DebtsScreen$lambda$44$0$2$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function1 function1 = (Function1) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipTint chipTint = ChipTint.ORANGE;
            List listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(LangKt.tx("Все", new Object[0]), PeriodKind.ALL), TuplesKt.to(LangKt.tx("Сегодня", new Object[0]), PeriodKind.TODAY), TuplesKt.to(LangKt.tx("10 дней", new Object[0]), PeriodKind.DAYS_10)});
            ComposerKt.sourceInformationMarkerStart(composer, 1703343271, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DebtsScreen$lambda$44$0$2$1$0;
                        DebtsScreen$lambda$44$0$2$1$0 = DebtsScreenKt.DebtsScreen$lambda$44$0$2$1$0(MutableState.this);
                        return DebtsScreen$lambda$44$0$2$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            Function0 function0 = (Function0) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1703344934, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda33
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DebtsScreen$lambda$44$0$2$2$0;
                        DebtsScreen$lambda$44$0$2$2$0 = DebtsScreenKt.DebtsScreen$lambda$44$0$2$2$0(MutableState.this);
                        return DebtsScreen$lambda$44$0$2$2$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.OxPeriodChips(DebtsScreen$lambda$18, function1, null, chipTint, listOf, function0, (Function0) rememberedValue3, composer, PeriodState.$stable | 1772592, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$44$0$2$0$0(MutableState mutableState, PeriodState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$44$0$2$1$0(MutableState mutableState) {
        DebtsScreen$lambda$25(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$44$0$2$2$0(MutableState mutableState) {
        DebtsScreen$lambda$28(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$44$0$3(final MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C188@7386L12,188@7372L26:DebtsScreen.kt#fh874k");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1565955279, i, -1, "uz.FonRo.pos.ui.money.DebtsScreen.<anonymous>.<anonymous>.<anonymous> (DebtsScreen.kt:188)");
            }
            String DebtsScreen$lambda$21 = DebtsScreen$lambda$21(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, -1644468995, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DebtsScreen$lambda$44$0$3$0$0;
                        DebtsScreen$lambda$44$0$3$0$0 = DebtsScreenKt.DebtsScreen$lambda$44$0$3$0$0(MutableState.this, (String) obj);
                        return DebtsScreen$lambda$44$0$3$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            DebtTabs(DebtsScreen$lambda$21, (Function1) rememberedValue, composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$44$0$3$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$44$0$4(String str, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C191@7462L22:DebtsScreen.kt#fh874k");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-887748301, i, -1, "uz.FonRo.pos.ui.money.DebtsScreen.<anonymous>.<anonymous>.<anonymous> (DebtsScreen.kt:191)");
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
    public static final Unit DebtsScreen$lambda$44$0$5(List list, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C196@7631L278:DebtsScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(479057451, i, -1, "uz.FonRo.pos.ui.money.DebtsScreen.<anonymous>.<anonymous>.<anonymous> (DebtsScreen.kt:196)");
            }
            BasicsKt.OxSectionHead(LangKt.tx("Продажи в долг", new Object[0]), null, LangKt.tx("Нажмите продажу, чтобы посмотреть состав", new Object[0]), String.valueOf(list.size()), ChipTone.WARN, null, composer, 24576, 34);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object DebtsScreen$lambda$44$0$6(DebtSale it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$44$0$8(List list, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C214@8336L281:DebtsScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-405678356, i, -1, "uz.FonRo.pos.ui.money.DebtsScreen.<anonymous>.<anonymous>.<anonymous> (DebtsScreen.kt:214)");
            }
            BasicsKt.OxSectionHead(LangKt.tx("Клиенты с долгами", new Object[0]), null, LangKt.tx("Сумма по всем непогашенным чекам", new Object[0]), String.valueOf(list.size()), ChipTone.WARN, null, composer, 24576, 34);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object DebtsScreen$lambda$44$0$9(DebtCustomer it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getCustomerId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$44$0$11(final CoroutineScope coroutineScope, final Repo repo, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C233@9086L661:DebtsScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1615629041, i, -1, "uz.FonRo.pos.ui.money.DebtsScreen.<anonymous>.<anonymous>.<anonymous> (DebtsScreen.kt:233)");
            }
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(8.0f), 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m1051paddingVpY3zN4$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1839246839, "C234@9158L85,237@9363L282,235@9272L449:DebtsScreen.kt#fh874k");
            BasicsKt.OxEmptyNote(LangKt.tx("Справочник ещё не загружен — закрытия долгов приедут вместе с ним.", new Object[0]), null, composer, 0, 2);
            String tx = LangKt.tx("Повторить", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, 1029168147, "CC(remember):DebtsScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(repo);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda45
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DebtsScreen$lambda$44$0$11$0$0$0;
                        DebtsScreen$lambda$44$0$11$0$0$0 = DebtsScreenKt.DebtsScreen$lambda$44$0$11$0$0$0(CoroutineScope.this, repo);
                        return DebtsScreen$lambda$44$0$11$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, null, null, null, false, true, null, composer, 1572864, 188);
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
    public static final Unit DebtsScreen$lambda$44$0$11$0$0$0(CoroutineScope coroutineScope, Repo repo) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DebtsScreenKt$DebtsScreen$3$1$12$1$1$1$1(repo, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$44$0$12(List list, Repo repo, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C250@9912L235:DebtsScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1549313370, i, -1, "uz.FonRo.pos.ui.money.DebtsScreen.<anonymous>.<anonymous>.<anonymous> (DebtsScreen.kt:249)");
            }
            List list2 = list;
            Iterator it = list2.iterator();
            double d = AudioStats.AUDIO_AMPLITUDE_NONE;
            while (it.hasNext()) {
                d += ((DebtClosure) it.next()).getAmount();
            }
            String nf = Fmt.INSTANCE.nf(Double.valueOf(d));
            String money = repo.money(Double.valueOf(d));
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(Long.valueOf(((DebtClosure) it2.next()).getCustomerId()));
            }
            ClosuresHead(nf, money, CollectionsKt.toSet(arrayList).size(), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object DebtsScreen$lambda$44$0$13(DebtClosure it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$45$0(MutableState mutableState) {
        DebtsScreen$lambda$25(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$46$0(MutableState mutableState, MutableState mutableState2, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(PeriodState.copy$default(DebtsScreen$lambda$18(mutableState), PeriodKind.MONTH, it, null, 4, null));
        DebtsScreen$lambda$25(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$47$0(MutableState mutableState) {
        DebtsScreen$lambda$28(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$48$0(MutableState mutableState, MutableState mutableState2, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(PeriodState.copy$default(DebtsScreen$lambda$18(mutableState), PeriodKind.DATE, null, it, 2, null));
        DebtsScreen$lambda$28(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$49$0$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$49$1$0(DebtSale debtSale, MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(null);
        mutableState2.setValue(debtSale);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$50$0$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$50$1$0(MutableState mutableState, MutableState mutableState2, DebtSale sale) {
        Intrinsics.checkNotNullParameter(sale, "sale");
        mutableState.setValue(null);
        mutableState2.setValue(sale);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$51$0$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtsScreen$lambda$51$1$0(MutableState mutableState) {
        DebtsScreen$lambda$10(mutableState, DebtsScreen$lambda$9(mutableState) + 1);
        return Unit.INSTANCE;
    }

    private static final List<DebtSale> filterDebtSales(DebtsResponse debtsResponse, String str, PeriodState periodState) {
        List<DebtSale> emptyList;
        String lowerCase = StringsKt.trim((CharSequence) str).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (debtsResponse == null || (emptyList = debtsResponse.getSales()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : emptyList) {
            DebtSale debtSale = (DebtSale) obj;
            if (periodState.contains(debtSale.getSoldAt())) {
                String str2 = lowerCase;
                if (str2.length() != 0) {
                    String customerName = debtSale.getCustomerName();
                    if (customerName == null) {
                        customerName = "";
                    }
                    String lowerCase2 = customerName.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    if (!StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) str2, false, 2, (Object) null)) {
                        String lowerCase3 = debtSale.getTransactionId().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                        if (!StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) str2, false, 2, (Object) null)) {
                            String cashierName = debtSale.getCashierName();
                            String lowerCase4 = (cashierName != null ? cashierName : "").toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                            if (StringsKt.contains$default((CharSequence) lowerCase4, (CharSequence) str2, false, 2, (Object) null)) {
                            }
                        }
                    }
                }
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
    
        if (r6 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.util.List<uz.FonRo.pos.ui.money.DebtCustomer> buildDebtCustomers(java.util.List<uz.FonRo.pos.data.model.DebtSale> r14, java.util.List<uz.FonRo.pos.data.model.Customer> r15) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.money.DebtsScreenKt.buildDebtCustomers(java.util.List, java.util.List):java.util.List");
    }

    private static final List<DebtClosure> buildClosures(SyncData syncData, DebtsResponse debtsResponse, List<Customer> list, String str, PeriodState periodState) {
        List<DebtSale> emptyList;
        String tx;
        if (syncData == null) {
            return CollectionsKt.emptyList();
        }
        List<DebtPayment> debtPayments = syncData.getDebtPayments();
        if (debtPayments.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        HashMap hashMap = new HashMap(syncData.getSales().size());
        for (SyncSale syncSale : syncData.getSales()) {
            hashMap.put(Long.valueOf(syncSale.getId()), Long.valueOf(syncSale.getCustomerId()));
        }
        HashMap hashMap2 = new HashMap(list.size());
        for (Customer customer : list) {
            hashMap2.put(Long.valueOf(customer.getId()), customer.getFullName());
        }
        if (debtsResponse == null || (emptyList = debtsResponse.getSales()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        HashSet hashSet = new HashSet();
        Iterator<T> it = emptyList.iterator();
        while (it.hasNext()) {
            hashSet.add(Long.valueOf(((DebtSale) it.next()).getId()));
        }
        HashSet hashSet2 = hashSet;
        String lowerCase = StringsKt.trim((CharSequence) str).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : debtPayments) {
            if (periodState.contains(((DebtPayment) obj).getCreatedAt())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        int i = 0;
        for (Object obj2 : arrayList2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DebtPayment debtPayment = (DebtPayment) obj2;
            boolean containsKey = hashMap.containsKey(Long.valueOf(debtPayment.getSaleId()));
            Long l = (Long) hashMap.get(Long.valueOf(debtPayment.getSaleId()));
            long longValue = l != null ? l.longValue() : 0L;
            String str2 = debtPayment.getSaleId() + ":" + debtPayment.getCreatedAt() + ":" + i;
            double amount = debtPayment.getAmount();
            double cashAmount = debtPayment.getCashAmount();
            double cardAmount = debtPayment.getCardAmount();
            String createdAt = debtPayment.getCreatedAt();
            String transactionId = debtPayment.getTransactionId();
            String paymentType = debtPayment.getPaymentType();
            String str3 = paymentType == null ? "" : paymentType;
            String paidByName = debtPayment.getPaidByName();
            String str4 = paidByName == null ? "" : paidByName;
            String str5 = (String) hashMap2.get(Long.valueOf(longValue));
            if (str5 != null) {
                tx = !StringsKt.isBlank(str5) ? str5 : null;
                if (tx != null) {
                    arrayList3.add(new DebtClosure(str2, amount, cashAmount, cardAmount, createdAt, transactionId, str3, str4, longValue, tx, !hashSet2.contains(Long.valueOf(debtPayment.getSaleId()))));
                    i = i2;
                }
            }
            tx = containsKey ? LangKt.tx("Чек №%s", Long.valueOf(debtPayment.getSaleId())) : LangKt.tx("Без клиента", new Object[0]);
            arrayList3.add(new DebtClosure(str2, amount, cashAmount, cardAmount, createdAt, transactionId, str3, str4, longValue, tx, !hashSet2.contains(Long.valueOf(debtPayment.getSaleId()))));
            i = i2;
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : arrayList3) {
            DebtClosure debtClosure = (DebtClosure) obj3;
            String str6 = lowerCase;
            if (str6.length() != 0) {
                String lowerCase2 = debtClosure.getName().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (!StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) str6, false, 2, (Object) null)) {
                    String lowerCase3 = debtClosure.getTransactionId().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                    if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) str6, false, 2, (Object) null)) {
                    }
                }
            }
            arrayList4.add(obj3);
        }
        return CollectionsKt.sortedWith(arrayList4, new Comparator() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$buildClosures$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((DebtClosure) t2).getCreatedAt(), ((DebtClosure) t).getCreatedAt());
            }
        });
    }

    private static final void DebtHero(final String str, final String str2, int i, final int i2, final int i3, Composer composer, final int i4) {
        int i5;
        String str3;
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1129091732);
        ComposerKt.sourceInformation(startRestartGroup, "C(DebtHero)P(4,1,3)459@16352L1925:DebtsScreen.kt#fh874k");
        if ((i4 & 6) == 0) {
            i5 = (startRestartGroup.changed(str) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            str3 = str2;
            i5 |= startRestartGroup.changed(str3) ? 32 : 16;
        } else {
            str3 = str2;
        }
        if ((i4 & 384) == 0) {
            i6 = i;
            i5 |= startRestartGroup.changed(i6) ? 256 : 128;
        } else {
            i6 = i;
        }
        if ((i4 & 3072) == 0) {
            i5 |= startRestartGroup.changed(i2) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i5 |= startRestartGroup.changed(i3) ? 16384 : 8192;
        }
        if (!startRestartGroup.shouldExecute((i5 & 9363) != 9362, i5 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1129091732, i5, -1, "uz.FonRo.pos.ui.money.DebtHero (DebtsScreen.kt:458)");
            }
            Modifier m1049padding3ABfNKs = PaddingKt.m1049padding3ABfNKs(BorderKt.m569borderxT4_qwU(BackgroundKt.background$default(ClipKt.clip(PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(14.0f), 7, null), OxShape.INSTANCE.getHero()), Brush.Companion.m4336linearGradientmHitzGk$default(Brush.INSTANCE, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10213getOrange0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null))), TuplesKt.to(Float.valueOf(0.55f), Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10219getPink0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null))), TuplesKt.to(Float.valueOf(1.0f), Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10223getPurple0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null)))}, 0L, 0L, 0, 14, (Object) null), null, 0.0f, 6, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10205getHeroEdge0d7_KjU(), OxShape.INSTANCE.getHero()), Dp.m6989constructorimpl(16.0f));
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -307544930, "C474@16848L819,496@17676L244,503@17929L342:DebtsScreen.kt#fh874k");
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -450857519, "C479@17049L250,486@17312L345:DebtsScreen.kt#fh874k");
            TextKt.m2798Text4IGK_g(LangKt.tx("Общий долг", new Object[0]), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), TextUnitKt.getSp(13.5d), FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), startRestartGroup, 0, 0, 65532);
            TextKt.m2798Text4IGK_g(str3, PaddingKt.m1050paddingVpY3zN4(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, OxShape.INSTANCE.getPill()), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10213getOrange0d7_KjU(), 0.2f), null, 2, null), Dp.m6989constructorimpl(12.0f), Dp.m6989constructorimpl(6.0f)), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getChip(), Ox.INSTANCE.m10215getOrangeInk0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), startRestartGroup, (i5 >> 3) & 14, 3072, 57340);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            TextKt.m2798Text4IGK_g(str, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(10.0f), 0.0f, Dp.m6989constructorimpl(14.0f), 5, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getAmountXl(), 0L, 0L, null, null, null, null, null, TextUnitKt.getSp(-1.5d), null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777087, null), startRestartGroup, (i5 & 14) | 48, 3120, 55292);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(7.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), startRestartGroup, 6);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1305854626, "C504@17999L77,505@18089L84,506@18186L75:DebtsScreen.kt#fh874k");
            m9989DebtStatcf5BqRc(String.valueOf(i6), LangKt.tx("Продаж", new Object[0]), Ox.INSTANCE.m10213getOrange0d7_KjU(), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), startRestartGroup, 0, 0);
            composer2 = startRestartGroup;
            m9989DebtStatcf5BqRc(String.valueOf(i2), LangKt.tx("Клиентов", new Object[0]), Ox.INSTANCE.m10220getPrimary0d7_KjU(), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), startRestartGroup, 0, 0);
            m9989DebtStatcf5BqRc(String.valueOf(i3), LangKt.tx("Строк", new Object[0]), Ox.INSTANCE.m10223getPurple0d7_KjU(), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), startRestartGroup, 0, 0);
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final int i7 = i6;
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda60
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DebtsScreenKt.DebtHero$lambda$1(str, str2, i7, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x006e  */
    /* renamed from: DebtStat-cf5BqRc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m9989DebtStatcf5BqRc(final java.lang.String r40, final java.lang.String r41, final long r42, androidx.compose.ui.Modifier r44, androidx.compose.runtime.Composer r45, final int r46, final int r47) {
        /*
            Method dump skipped, instructions count: 578
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.money.DebtsScreenKt.m9989DebtStatcf5BqRc(java.lang.String, java.lang.String, long, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void DebtTabs(String str, Function1<? super String, Unit> function1, Composer composer, final int i) {
        int i2;
        final String str2 = str;
        final Function1<? super String, Unit> function12 = function1;
        Composer startRestartGroup = composer.startRestartGroup(1531950379);
        ComposerKt.sourceInformation(startRestartGroup, "C(DebtTabs)536@19030L396:DebtsScreen.kt#fh874k");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1531950379, i2, -1, "uz.FonRo.pos.ui.money.DebtTabs (DebtsScreen.kt:535)");
            }
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(16.0f), 7, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), startRestartGroup, 6);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 381633539, "C540@19179L77,541@19265L74,542@19348L72:DebtsScreen.kt#fh874k");
            int i3 = i2 << 6;
            int i4 = (i3 & 896) | 48 | (i3 & 7168);
            DebtTab(LangKt.tx("Продажи в долг", new Object[0]), "sales", str2, function12, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), startRestartGroup, i4, 0);
            str2 = str;
            function12 = function1;
            DebtTab(LangKt.tx("Клиенты", new Object[0]), "customers", str2, function12, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), startRestartGroup, i4, 0);
            DebtTab(LangKt.tx("Закрытия", new Object[0]), "closed", str2, function12, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), startRestartGroup, i4, 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda62
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DebtsScreenKt.DebtTabs$lambda$1(str2, function12, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void DebtTab(final java.lang.String r47, final java.lang.String r48, final java.lang.String r49, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r50, androidx.compose.ui.Modifier r51, androidx.compose.runtime.Composer r52, final int r53, final int r54) {
        /*
            Method dump skipped, instructions count: 646
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.money.DebtsScreenKt.DebtTab(java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtTab$lambda$0$0(boolean z, Function1 function1, String str) {
        if (!z) {
            function1.invoke(str);
        }
        return Unit.INSTANCE;
    }

    /* renamed from: DebtIco-M3jwhU8, reason: not valid java name */
    private static final void m9988DebtIcoM3jwhU8(final long j, final ImageVector imageVector, final long j2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(716203580);
        ComposerKt.sourceInformation(startRestartGroup, "C(DebtIco)P(2:c#ui.graphics.Color!,1:c#ui.graphics.Color)583@20478L219:DebtsScreen.kt#fh874k");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(imageVector) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(716203580, i2, -1, "uz.FonRo.pos.ui.money.DebtIco (DebtsScreen.kt:582)");
            }
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(52.0f)), OxShape.INSTANCE.getTile()), j, null, 2, null);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1060795567, "C587@20609L82:DebtsScreen.kt#fh874k");
            IconKt.m2255Iconww6aTOc(imageVector, (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(22.0f)), j2, startRestartGroup, ((i2 >> 3) & 14) | 432 | ((i2 << 3) & 7168), 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda41
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DebtsScreenKt.DebtIco_M3jwhU8$lambda$1(j, imageVector, j2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DebtSaleCard(final DebtSale debtSale, final Function0<Unit> function0, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1941026566);
        ComposerKt.sourceInformation(startRestartGroup, "C(DebtSaleCard)P(1)605@21202L2196,600@21046L2352:DebtsScreen.kt#fh874k");
        int i2 = (i & 6) == 0 ? ((i & 8) == 0 ? startRestartGroup.changed(debtSale) : startRestartGroup.changedInstance(debtSale) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1941026566, i2, -1, "uz.FonRo.pos.ui.money.DebtSaleCard (DebtsScreen.kt:592)");
            }
            final boolean z = debtSale.getPaidAmount() > 0.001d;
            String transactionId = debtSale.getTransactionId();
            String dt$default = Fmt.dt$default(Fmt.INSTANCE, debtSale.getSoldAt(), false, 2, null);
            String cashierName = debtSale.getCashierName();
            List listOf = CollectionsKt.listOf((Object[]) new String[]{transactionId, dt$default, (cashierName == null || StringsKt.isBlank(cashierName)) ? "" : LangKt.tx("Продал: %s", debtSale.getCashierName())});
            ArrayList arrayList = new ArrayList();
            for (Object obj : listOf) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList.add(obj);
                }
            }
            final String joinToString$default = CollectionsKt.joinToString$default(arrayList, " · ", null, null, 0, null, null, 62, null);
            BasicsKt.m9833OxSoftCardCe4qNIY(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(10.0f), 7, null), Dp.m6989constructorimpl(12.0f), OxShape.INSTANCE.getCardSoft(), 0L, 0L, function0, ComposableLambdaKt.rememberComposableLambda(-1244391808, true, new Function3() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return DebtsScreenKt.DebtSaleCard$lambda$1(z, debtSale, joinToString$default, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 << 12) & 458752) | 1572918, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return DebtsScreenKt.DebtSaleCard$lambda$2(DebtSale.this, function0, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x02a1, code lost:
    
        if (r2 == null) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit DebtSaleCard$lambda$1(boolean r63, uz.FonRo.pos.data.model.DebtSale r64, java.lang.String r65, androidx.compose.foundation.layout.ColumnScope r66, androidx.compose.runtime.Composer r67, int r68) {
        /*
            Method dump skipped, instructions count: 1488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.money.DebtsScreenKt.DebtSaleCard$lambda$1(boolean, uz.FonRo.pos.data.model.DebtSale, java.lang.String, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DebtCustomerCard(final DebtCustomer debtCustomer, final Function0<Unit> function0, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(438075610);
        ComposerKt.sourceInformation(startRestartGroup, "C(DebtCustomerCard)668@23792L1396,663@23636L1552:DebtsScreen.kt#fh874k");
        int i2 = (i & 6) == 0 ? ((i & 8) == 0 ? startRestartGroup.changed(debtCustomer) : startRestartGroup.changedInstance(debtCustomer) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(438075610, i2, -1, "uz.FonRo.pos.ui.money.DebtCustomerCard (DebtsScreen.kt:659)");
            }
            List listOf = CollectionsKt.listOf((Object[]) new String[]{debtCustomer.getPhone(), Fmt.INSTANCE.plural(debtCustomer.getSalesCount(), LangKt.tx("чек", new Object[0]), LangKt.tx("чека", new Object[0]), LangKt.tx("чеков", new Object[0]))});
            ArrayList arrayList = new ArrayList();
            for (Object obj : listOf) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList.add(obj);
                }
            }
            final String joinToString$default = CollectionsKt.joinToString$default(arrayList, " · ", null, null, 0, null, null, 62, null);
            BasicsKt.m9833OxSoftCardCe4qNIY(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(10.0f), 7, null), Dp.m6989constructorimpl(12.0f), OxShape.INSTANCE.getCardSoft(), 0L, 0L, function0, ComposableLambdaKt.rememberComposableLambda(1465346144, true, new Function3() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return DebtsScreenKt.DebtCustomerCard$lambda$1(joinToString$default, debtCustomer, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 << 12) & 458752) | 1572918, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return DebtsScreenKt.DebtCustomerCard$lambda$2(DebtCustomer.this, function0, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebtCustomerCard$lambda$1(String str, DebtCustomer debtCustomer, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C669@23802L1380:DebtsScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1465346144, i, -1, "uz.FonRo.pos.ui.money.DebtCustomerCard.<anonymous> (DebtsScreen.kt:669)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 930358561, "C674@23990L63,675@24066L1106:DebtsScreen.kt#fh874k");
            m9988DebtIcoM3jwhU8(Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10220getPrimary0d7_KjU(), 0.14f), OxIcons.INSTANCE.getUser(), Ox.INSTANCE.m10220getPrimary0d7_KjU(), composer, 0);
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
            ComposerKt.sourceInformationMarkerStart(composer, -253048845, "C676@24112L790,694@24919L239:DebtsScreen.kt#fh874k");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1104664517, "C681@24340L311,688@24672L212:DebtsScreen.kt#fh874k");
            TextKt.m2798Text4IGK_g(debtCustomer.getName(), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH3(), 0L, TextUnitKt.getSp(15), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 0, 3120, 55292);
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.nf(Double.valueOf(debtCustomer.getDebtTotal())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), 0L, TextUnitKt.getSp(16), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 0, 3072, 57342);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m2798Text4IGK_g(str, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(3.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 48, 3120, 55292);
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

    private static final void ClosuresHead(String str, String str2, final int i, Composer composer, final int i2) {
        int i3;
        final String str3;
        final String str4;
        Composer startRestartGroup = composer.startRestartGroup(-405419823);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClosuresHead)P(2,1)708@25285L565:DebtsScreen.kt#fh874k");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(str) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= startRestartGroup.changed(i) ? 256 : 128;
        }
        int i4 = i3;
        if (!startRestartGroup.shouldExecute((i4 & 147) != 146, i4 & 1)) {
            str3 = str2;
            str4 = str;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-405419823, i4, -1, "uz.FonRo.pos.ui.money.ClosuresHead (DebtsScreen.kt:707)");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 776088426, "C709@25302L208,715@25519L325:DebtsScreen.kt#fh874k");
            BasicsKt.OxSectionHead(LangKt.tx("Закрытия долгов", new Object[0]), null, LangKt.tx("Кто и сколько оплатил по выбранному периоду", new Object[0]), str, ChipTone.OK, null, startRestartGroup, ((i4 << 9) & 7168) | 24576, 34);
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(7.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m1053paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1793758731, "C719@25683L62,720@25758L76:DebtsScreen.kt#fh874k");
            str3 = str2;
            m9989DebtStatcf5BqRc(str3, LangKt.tx("Оплачено", new Object[0]), Ox.INSTANCE.m10201getGreen0d7_KjU(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), startRestartGroup, (i4 >> 3) & 14, 0);
            startRestartGroup = startRestartGroup;
            str4 = str;
            m9989DebtStatcf5BqRc(String.valueOf(i), LangKt.tx("Клиентов", new Object[0]), Ox.INSTANCE.m10192getCyan0d7_KjU(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), startRestartGroup, 0, 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda40
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DebtsScreenKt.ClosuresHead$lambda$1(str4, str3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ClosureCard(final DebtClosure debtClosure, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1655863839);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClosureCard)737@26329L2811,731@26099L3041:DebtsScreen.kt#fh874k");
        int i2 = (i & 6) == 0 ? (startRestartGroup.changed(debtClosure) ? 4 : 2) | i : i;
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1655863839, i2, -1, "uz.FonRo.pos.ui.money.ClosureCard (DebtsScreen.kt:727)");
            }
            List listOf = CollectionsKt.listOf((Object[]) new String[]{debtClosure.getTransactionId(), Fmt.dt$default(Fmt.INSTANCE, debtClosure.getCreatedAt(), false, 2, null)});
            ArrayList arrayList = new ArrayList();
            for (Object obj : listOf) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList.add(obj);
                }
            }
            final String joinToString$default = CollectionsKt.joinToString$default(arrayList, " · ", null, null, 0, null, null, 62, null);
            BasicsKt.m9833OxSoftCardCe4qNIY(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(10.0f), 7, null), Dp.m6989constructorimpl(12.0f), OxShape.INSTANCE.getCardSoft(), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10201getGreen0d7_KjU(), 0.07f), Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10201getGreen0d7_KjU(), 0.25f, 0.0f, 0.0f, 0.0f, 14, null), null, ComposableLambdaKt.rememberComposableLambda(-949733017, true, new Function3() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda42
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return DebtsScreenKt.ClosureCard$lambda$1(DebtClosure.this, joinToString$default, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, 1572918, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda43
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return DebtsScreenKt.ClosureCard$lambda$2(DebtClosure.this, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClosureCard$lambda$1(DebtClosure debtClosure, String str, ColumnScope OxSoftCard, Composer composer, int i) {
        int i2;
        String tx;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C738@26339L1909,784@28257L877:DebtsScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-949733017, i, -1, "uz.FonRo.pos.ui.money.ClosureCard.<anonymous> (DebtsScreen.kt:738)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -477046071, "C743@26527L54,744@26594L1644:DebtsScreen.kt#fh874k");
            m9988DebtIcoM3jwhU8(Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10201getGreen0d7_KjU(), 0.16f), OxIcons.INSTANCE.getOk(), Ox.INSTANCE.m10211getOk0d7_KjU(), composer, 0);
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
            ComposerKt.sourceInformationMarkerStart(composer, -691252558, "C745@26640L856,765@27513L711:DebtsScreen.kt#fh874k");
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
            ComposerKt.sourceInformationMarkerStart(composer, -944840356, "C750@26868L311,757@27200L278:DebtsScreen.kt#fh874k");
            TextKt.m2798Text4IGK_g(debtClosure.getName(), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH3(), 0L, TextUnitKt.getSp(15), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 0, 3120, 55292);
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.nf(Double.valueOf(debtClosure.getAmount())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10211getOk0d7_KjU(), TextUnitKt.getSp(16), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 0, 3072, 57342);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(3.0f), 0.0f, 0.0f, 13, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_43 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
            Alignment.Vertical top3 = Alignment.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m930spacedBy0680j_43, top3, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, m1053paddingqDBjuR0$default);
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
            Updater.m3815setimpl(m3808constructorimpl4, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl4.getInserting() || !Intrinsics.areEqual(m3808constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m3808constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m3808constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3815setimpl(m3808constructorimpl4, materializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -394259382, "C770@27761L254,777@28036L170:DebtsScreen.kt#fh874k");
            TextKt.m2798Text4IGK_g(str, RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 0, 3120, 55292);
            if (debtClosure.getClosed()) {
                i2 = 0;
                tx = LangKt.tx("Закрыт", new Object[0]);
            } else {
                i2 = 0;
                tx = LangKt.tx("Частично", new Object[0]);
            }
            BasicsKt.OxChip(tx, debtClosure.getClosed() ? ChipTone.OK : ChipTone.WARN, null, composer, 0, 4);
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
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier m1053paddingqDBjuR0$default2 = PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(10.0f), 0.0f, 0.0f, 13, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_44 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(m930spacedBy0680j_44, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer, i2);
            CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer, m1053paddingqDBjuR0$default2);
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
            Updater.m3815setimpl(m3808constructorimpl5, rowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl5.getInserting() || !Intrinsics.areEqual(m3808constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                m3808constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                m3808constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m3815setimpl(m3808constructorimpl5, materializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1480391200, "C788@28419L367:DebtsScreen.kt#fh874k");
            TextKt.m2798Text4IGK_g(LangKt.tx("%s · Наличные: %s", payLabel(debtClosure.getPaymentType()), Fmt.INSTANCE.nf(Double.valueOf(debtClosure.getCashAmount()))) + LangKt.tx(" · Карта: %s", Fmt.INSTANCE.nf(Double.valueOf(debtClosure.getCardAmount()))), RowScope.weight$default(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), TextUnitKt.getSp(12.5d), FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 0, 0, 65532);
            Composer composer2 = composer;
            if (!StringsKt.isBlank(debtClosure.getPaidBy())) {
                composer2.startReplaceGroup(1480799190);
                ComposerKt.sourceInformation(composer2, "797@28844L266");
                TextKt.m2798Text4IGK_g(LangKt.tx("Принял: %s", debtClosure.getPaidBy()), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), TextUnitKt.getSp(12.5d), FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 0, 3072, 57342);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(1481068704);
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
        return Unit.INSTANCE;
    }

    private static final void DebtDetailSheet(final DebtSale debtSale, final SyncData syncData, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
        Function0<Unit> function03;
        List<DebtPayment> emptyList;
        Composer startRestartGroup = composer.startRestartGroup(816769432);
        ComposerKt.sourceInformation(startRestartGroup, "C(DebtDetailSheet)P(2,3,1)818@29333L159,831@29855L227,840@30089L4048,828@29758L4379:DebtsScreen.kt#fh874k");
        int i2 = (i & 6) == 0 ? ((i & 8) == 0 ? startRestartGroup.changed(debtSale) : startRestartGroup.changedInstance(debtSale) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(syncData) : startRestartGroup.changedInstance(syncData) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            function03 = function0;
            i2 |= startRestartGroup.changedInstance(function03) ? 256 : 128;
        } else {
            function03 = function0;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
        }
        if (!startRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(816769432, i2, -1, "uz.FonRo.pos.ui.money.DebtDetailSheet (DebtsScreen.kt:817)");
            }
            long id = debtSale.getId();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1063586505, "CC(remember):DebtsScreen.kt#9igjgp");
            boolean changed = ((i2 & 112) == 32 || ((i2 & 64) != 0 && startRestartGroup.changed(syncData))) | startRestartGroup.changed(id);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                if (syncData == null || (emptyList = syncData.getDebtPayments()) == null) {
                    emptyList = CollectionsKt.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : emptyList) {
                    if (((DebtPayment) obj).getSaleId() == debtSale.getId()) {
                        arrayList.add(obj);
                    }
                }
                rememberedValue = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$DebtDetailSheet$lambda$0$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((DebtPayment) t).getCreatedAt(), ((DebtPayment) t2).getCreatedAt());
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final List list = (List) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Iterator it = list.iterator();
            double d = 0.0d;
            while (it.hasNext()) {
                d += ((DebtPayment) it.next()).getAmount();
            }
            final double max = Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, debtSale.getPaidAmount() - d);
            SheetsKt.OxCardSheet(LangKt.tx("Детали долга", new Object[0]), function03, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(1129848837, true, new Function3() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return DebtsScreenKt.DebtDetailSheet$lambda$2(Function0.this, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(412412668, true, new Function3() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return DebtsScreenKt.DebtDetailSheet$lambda$3(DebtSale.this, max, list, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 >> 3) & 112) | 14155776, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return DebtsScreenKt.DebtDetailSheet$lambda$4(DebtSale.this, syncData, function0, function02, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebtDetailSheet$lambda$2(Function0 function0, RowScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C832@29869L203:DebtsScreen.kt#fh874k");
        if ((i & 6) == 0) {
            i |= composer.changed(OxCardSheet) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1129848837, i, -1, "uz.FonRo.pos.ui.money.DebtDetailSheet.<anonymous> (DebtsScreen.kt:832)");
            }
            BasicsKt.OxButton(LangKt.tx("Закрыть долг", new Object[0]), function0, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.OK, BtnSize.LG, false, false, null, composer, 27648, 224);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebtDetailSheet$lambda$3(final DebtSale debtSale, double d, List list, ColumnScope OxCardSheet, Composer composer, int i) {
        String tx;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C841@30130L21,841@30099L4032:DebtsScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(412412668, i, -1, "uz.FonRo.pos.ui.money.DebtDetailSheet.<anonymous> (DebtsScreen.kt:841)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -442456596, "C842@30222L2144,842@30168L2198,884@32379L11,886@32404L38,889@32546L23,901@32949L31,926@34111L10:DebtsScreen.kt#fh874k");
            BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(12.0f), OxShape.INSTANCE.getCardSoft(), 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1691614720, true, new Function3() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda46
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit DebtDetailSheet$lambda$3$0$0;
                    DebtDetailSheet$lambda$3$0$0 = DebtsScreenKt.DebtDetailSheet$lambda$3$0$0(DebtSale.this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return DebtDetailSheet$lambda$3$0$0;
                }
            }, composer, 54), composer, 1572912, 57);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            DdRow(LangKt.tx("Дата", new Object[0]), Fmt.dt$default(Fmt.INSTANCE, debtSale.getSoldAt(), false, 2, null), composer, 0);
            String cashierName = debtSale.getCashierName();
            if (cashierName == null || StringsKt.isBlank(cashierName)) {
                cashierName = null;
            }
            if (cashierName == null) {
                composer.startReplaceGroup(-440263844);
            } else {
                composer.startReplaceGroup(-440263843);
                ComposerKt.sourceInformation(composer, "*887@32507L23");
                DdRow(LangKt.tx("Кассир", new Object[0]), cashierName, composer, 0);
            }
            composer.endReplaceGroup();
            DdSection(LangKt.tx("Товары", new Object[0]), composer, 0);
            if (debtSale.getItems().isEmpty()) {
                composer.startReplaceGroup(-440156180);
                ComposerKt.sourceInformation(composer, "891@32626L48");
                BasicsKt.OxEmptyNote(LangKt.tx("Состав чека сервер не прислал", new Object[0]), null, composer, 0, 2);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-440065877);
                ComposerKt.sourceInformation(composer, "*894@32761L142");
                for (DebtSaleItem debtSaleItem : debtSale.getItems()) {
                    DdRow(debtSaleItem.getName(), Fmt.INSTANCE.qf(Double.valueOf(debtSaleItem.getQuantity())) + " × " + Fmt.INSTANCE.nf(Double.valueOf(debtSaleItem.getSalePrice())), composer, 0);
                }
                composer.endReplaceGroup();
            }
            DdSection(LangKt.tx("История оплаты", new Object[0]), composer, 0);
            if (d <= 0.001d && list.isEmpty()) {
                composer.startReplaceGroup(-439727016);
                ComposerKt.sourceInformation(composer, "903@33059L36");
                BasicsKt.OxEmptyNote(LangKt.tx("Оплат ещё не было", new Object[0]), null, composer, 0, 2);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-439661668);
                composer.endReplaceGroup();
            }
            if (d > 0.001d) {
                composer.startReplaceGroup(-439615168);
                ComposerKt.sourceInformation(composer, "906@33165L252");
                String tx2 = LangKt.tx("Первичная оплата", new Object[0]);
                String nf = Fmt.INSTANCE.nf(Double.valueOf(d));
                String dt$default = Fmt.dt$default(Fmt.INSTANCE, debtSale.getSoldAt(), false, 2, null);
                String paymentType = debtSale.getPaymentType();
                if (paymentType == null) {
                    paymentType = "";
                }
                PaymentRow(tx2, nf, dt$default, payLabel(paymentType), composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-439342244);
                composer.endReplaceGroup();
            }
            composer.startReplaceGroup(540018347);
            ComposerKt.sourceInformation(composer, "*918@33716L368");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                DebtPayment debtPayment = (DebtPayment) it.next();
                if (debtPayment.getCashAmount() <= 0.001d && debtPayment.getCardAmount() <= 0.001d) {
                    tx = "";
                } else {
                    tx = LangKt.tx(" · Наличные: %s · Карта: %s", Fmt.INSTANCE.nf(Double.valueOf(debtPayment.getCashAmount())), Fmt.INSTANCE.nf(Double.valueOf(debtPayment.getCardAmount())));
                }
                String tx3 = LangKt.tx("Погашение долга", new Object[0]);
                String str = "+" + Fmt.INSTANCE.nf(Double.valueOf(debtPayment.getAmount()));
                String dt$default2 = Fmt.dt$default(Fmt.INSTANCE, debtPayment.getCreatedAt(), false, 2, null);
                String paidByName = debtPayment.getPaidByName();
                String str2 = dt$default2 + ((paidByName == null || StringsKt.isBlank(paidByName)) ? "" : LangKt.tx(" · Принял: %s", debtPayment.getPaidByName()));
                String paymentType2 = debtPayment.getPaymentType();
                if (paymentType2 == null) {
                    paymentType2 = "";
                }
                PaymentRow(tx3, str, str2, payLabel(paymentType2) + tx, composer, 0);
            }
            composer.endReplaceGroup();
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
    /* JADX WARN: Code restructure failed: missing block: B:44:0x02a1, code lost:
    
        if (r2 == null) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit DebtDetailSheet$lambda$3$0$0(uz.FonRo.pos.data.model.DebtSale r64, androidx.compose.foundation.layout.ColumnScope r65, androidx.compose.runtime.Composer r66, int r67) {
        /*
            Method dump skipped, instructions count: 1387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.money.DebtsScreenKt.DebtDetailSheet$lambda$3$0$0(uz.FonRo.pos.data.model.DebtSale, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    private static final void DebtCustomerSheet(final DebtCustomer debtCustomer, final Function0<Unit> function0, final Function1<? super DebtSale, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1589349270);
        ComposerKt.sourceInformation(startRestartGroup, "C(DebtCustomerSheet)937@34294L70,939@34428L1865,939@34370L1923:DebtsScreen.kt#fh874k");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(debtCustomer) : startRestartGroup.changedInstance(debtCustomer) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        boolean z = false;
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1589349270, i2, -1, "uz.FonRo.pos.ui.money.DebtCustomerSheet (DebtsScreen.kt:936)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1643704580, "CC(remember):DebtsScreen.kt#9igjgp");
            if ((i2 & 14) == 4 || ((i2 & 8) != 0 && startRestartGroup.changed(debtCustomer))) {
                z = true;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = CollectionsKt.sortedWith(debtCustomer.getSales(), new Comparator() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$DebtCustomerSheet$lambda$0$$inlined$sortedByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((DebtSale) t2).getSoldAt(), ((DebtSale) t).getSoldAt());
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final List list = (List) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SheetsKt.OxCardSheet(debtCustomer.getName(), function0, null, false, false, false, null, ComposableLambdaKt.rememberComposableLambda(868197554, true, new Function3() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda44
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DebtsScreenKt.DebtCustomerSheet$lambda$1(list, debtCustomer, function1, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, (i2 & 112) | 12582912, 124);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda55
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DebtsScreenKt.DebtCustomerSheet$lambda$2(DebtCustomer.this, function0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebtCustomerSheet$lambda$1(List list, final DebtCustomer debtCustomer, final Function1 function1, ColumnScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C940@34469L21,940@34438L1849:DebtsScreen.kt#fh874k");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(868197554, i, -1, "uz.FonRo.pos.ui.money.DebtCustomerSheet.<anonymous> (DebtsScreen.kt:940)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1346144497, "C941@34561L1438,941@34507L1492,971@36013L31,977@36267L10:DebtsScreen.kt#fh874k");
            BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(12.0f), OxShape.INSTANCE.getCardSoft(), 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1958932434, true, new Function3() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda47
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit DebtCustomerSheet$lambda$1$0$0;
                    DebtCustomerSheet$lambda$1$0$0 = DebtsScreenKt.DebtCustomerSheet$lambda$1$0$0(DebtCustomer.this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return DebtCustomerSheet$lambda$1$0$0;
                }
            }, composer, 54), composer, 1572912, 57);
            DdSection(LangKt.tx("Покупки в долг", new Object[0]), composer, 0);
            if (list.isEmpty()) {
                composer.startReplaceGroup(1347650321);
                ComposerKt.sourceInformation(composer, "973@36096L41");
                BasicsKt.OxEmptyNote(LangKt.tx("Открытых долгов нет 🎉", new Object[0]), null, composer, 0, 2);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1347729433);
                ComposerKt.sourceInformation(composer, "*975@36218L20,975@36199L39");
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    final DebtSale debtSale = (DebtSale) it.next();
                    ComposerKt.sourceInformationMarkerStart(composer, 384929465, "CC(remember):DebtsScreen.kt#9igjgp");
                    boolean changed = composer.changed(function1) | composer.changedInstance(debtSale);
                    Object rememberedValue = composer.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda48
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit DebtCustomerSheet$lambda$1$0$1$0$0;
                                DebtCustomerSheet$lambda$1$0$1$0$0 = DebtsScreenKt.DebtCustomerSheet$lambda$1$0$1$0$0(Function1.this, debtSale);
                                return DebtCustomerSheet$lambda$1$0$1$0$0;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    DebtSaleCard(debtSale, (Function0) rememberedValue, composer, DebtSale.$stable);
                }
                composer.endReplaceGroup();
            }
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
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtCustomerSheet$lambda$1$0$0(DebtCustomer debtCustomer, ColumnScope OxSoftCard, Composer composer, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C942@34579L887,961@35483L502:DebtsScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1958932434, i, -1, "uz.FonRo.pos.ui.money.DebtCustomerSheet.<anonymous>.<anonymous>.<anonymous> (DebtsScreen.kt:942)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
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
            ComposerKt.sourceInformationMarkerStart(composer, 1998371453, "C947@34820L63,948@34904L544:DebtsScreen.kt#fh874k");
            m9988DebtIcoM3jwhU8(Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10220getPrimary0d7_KjU(), 0.14f), OxIcons.INSTANCE.getUser(), Ox.INSTANCE.m10220getPrimary0d7_KjU(), composer, 0);
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
            ComposerKt.sourceInformationMarkerStart(composer, -204856217, "C949@34958L282,955@35265L161:DebtsScreen.kt#fh874k");
            TextKt.m2798Text4IGK_g(debtCustomer.getName(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH3(), 0L, TextUnitKt.getSp(15), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 0, 3120, 55294);
            String phone = debtCustomer.getPhone();
            if (StringsKt.isBlank(phone)) {
                z = false;
                phone = LangKt.tx("Телефон не указан", new Object[0]);
            } else {
                z = false;
            }
            TextKt.m2798Text4IGK_g(phone, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 0, 0, 65534);
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
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(12.0f), 0.0f, 0.0f, 13, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(7.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, m1053paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1465228841, "C965@35676L80,966@35777L86,967@35884L83:DebtsScreen.kt#fh874k");
            m9989DebtStatcf5BqRc(Fmt.INSTANCE.nf(Double.valueOf(debtCustomer.getDebtTotal())), LangKt.tx("Долг", new Object[0]), Ox.INSTANCE.m10213getOrange0d7_KjU(), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0, 0);
            m9989DebtStatcf5BqRc(String.valueOf(debtCustomer.getSalesCount()), LangKt.tx("Чеков", new Object[0]), Ox.INSTANCE.m10220getPrimary0d7_KjU(), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0, 0);
            m9989DebtStatcf5BqRc(Fmt.INSTANCE.nf(Double.valueOf(debtCustomer.getPaidTotal())), LangKt.tx("Оплачено", new Object[0]), Ox.INSTANCE.m10201getGreen0d7_KjU(), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0, 0);
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
    public static final Unit DebtCustomerSheet$lambda$1$0$1$0$0(Function1 function1, DebtSale debtSale) {
        function1.invoke(debtSale);
        return Unit.INSTANCE;
    }

    private static final void DebtPaySheet(final FonRoApp FonRoApp, final DebtSale debtSale, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
        int i2;
        Function0<Unit> function03;
        final Function0<Unit> function04;
        Composer composer2;
        MutableState mutableStateOf$default;
        final DebtSale debtSale2 = debtSale;
        Composer startRestartGroup = composer.startRestartGroup(2039454306);
        ComposerKt.sourceInformation(startRestartGroup, "C(DebtPaySheet)P(!1,3)990@36469L24,994@36654L41,995@36714L44,996@36775L31,997@36822L34,998@36873L34,1052@38978L401,1063@39386L2804,1048@38855L3335:DebtsScreen.kt#fh874k");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(FonRoApp) : startRestartGroup.changedInstance(FonRoApp) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(debtSale2) : startRestartGroup.changedInstance(debtSale2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            function03 = function0;
            i2 |= startRestartGroup.changedInstance(function03) ? 256 : 128;
        } else {
            function03 = function0;
        }
        if ((i & 3072) == 0) {
            function04 = function02;
            i2 |= startRestartGroup.changedInstance(function04) ? 2048 : 1024;
        } else {
            function04 = function02;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2039454306, i3, -1, "uz.FonRo.pos.ui.money.DebtPaySheet (DebtsScreen.kt:988)");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1410511915, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PayType.CASH, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1410513838, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Double.valueOf(debtSale2.getDebtAmount()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1410515777, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1410517284, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(mutableStateOf$default);
                rememberedValue5 = mutableStateOf$default;
            }
            final MutableState mutableState4 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1410518916, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final MutableState mutableState5 = (MutableState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Function0<Unit> function05 = function03;
            debtSale2 = debtSale;
            SheetsKt.OxCardSheet(LangKt.tx("Погашение долга", new Object[0]), function0, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(1878886415, true, new Function3() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda54
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DebtsScreenKt.DebtPaySheet$lambda$15(Function0.this, coroutineScope, debtSale, repo, function04, mutableState5, mutableState2, mutableState, mutableState3, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1158587590, true, new Function3() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda56
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DebtsScreenKt.DebtPaySheet$lambda$16(DebtSale.this, repo, mutableState, mutableState2, mutableState4, mutableState3, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i3 >> 3) & 112) | 14352384, 28);
            composer2 = startRestartGroup;
            if (DebtPaySheet$lambda$10(mutableState4)) {
                composer2.startReplaceGroup(781711772);
                ComposerKt.sourceInformation(composer2, "1139@42425L47,1140@42498L15,1135@42215L308");
                String tx = LangKt.tx("Сумма оплаты (долг %s)", Fmt.INSTANCE.nf(Double.valueOf(debtSale2.getDebtAmount())));
                double DebtPaySheet$lambda$4 = DebtPaySheet$lambda$4(mutableState2);
                ComposerKt.sourceInformationMarkerStart(composer2, 1410696593, "CC(remember):DebtsScreen.kt#9igjgp");
                boolean z = (i3 & 112) == 32 || ((i3 & 64) != 0 && composer2.changedInstance(debtSale2));
                Object rememberedValue7 = composer2.rememberedValue();
                if (z || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue7 = new Function1() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda57
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit DebtPaySheet$lambda$17$0;
                            DebtPaySheet$lambda$17$0 = DebtsScreenKt.DebtPaySheet$lambda$17$0(DebtSale.this, mutableState2, ((Double) obj).doubleValue());
                            return DebtPaySheet$lambda$17$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue7);
                }
                Function1 function1 = (Function1) rememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, 1410698897, "CC(remember):DebtsScreen.kt#9igjgp");
                Object rememberedValue8 = composer2.rememberedValue();
                if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue8 = new Function0() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda58
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit DebtPaySheet$lambda$18$0;
                            DebtPaySheet$lambda$18$0 = DebtsScreenKt.DebtPaySheet$lambda$18$0(MutableState.this);
                            return DebtPaySheet$lambda$18$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                NumpadKt.NumpadSheet(tx, DebtPaySheet$lambda$4, function1, (Function0) rememberedValue8, false, composer2, 3072, 16);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(782023136);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda59
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DebtsScreenKt.DebtPaySheet$lambda$19(FonRoApp.this, debtSale2, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PayType DebtPaySheet$lambda$1(MutableState<PayType> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double DebtPaySheet$lambda$4(MutableState<Double> mutableState) {
        return mutableState.getValue().doubleValue();
    }

    private static final void DebtPaySheet$lambda$5(MutableState<Double> mutableState, double d) {
        mutableState.setValue(Double.valueOf(d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String DebtPaySheet$lambda$7(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean DebtPaySheet$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void DebtPaySheet$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean DebtPaySheet$lambda$13(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DebtPaySheet$lambda$14(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void DebtPaySheet$submit(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, MutableState<Double> mutableState2, DebtSale debtSale, Repo repo, Function0<Unit> function0, Function0<Unit> function02, MutableState<PayType> mutableState3, MutableState<String> mutableState4) {
        if (DebtPaySheet$lambda$13(mutableState)) {
            return;
        }
        if (DebtPaySheet$lambda$4(mutableState2) <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            Toaster.INSTANCE.error(LangKt.tx("Укажите сумму", new Object[0]));
        } else {
            DebtPaySheet$lambda$14(mutableState, true);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DebtsScreenKt$DebtPaySheet$submit$1(debtSale, repo, function0, function02, mutableState2, mutableState3, mutableState4, mutableState, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebtPaySheet$lambda$15(final Function0 function0, final CoroutineScope coroutineScope, final DebtSale debtSale, final Repo repo, final Function0 function02, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C1053@38992L89,1056@39183L12,1054@39094L275:DebtsScreen.kt#fh874k");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1878886415, i2, -1, "uz.FonRo.pos.ui.money.DebtPaySheet.<anonymous> (DebtsScreen.kt:1053)");
            }
            BasicsKt.OxButton(LangKt.tx("Отмена", new Object[0]), function0, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.GHOST, null, false, false, null, composer, 3072, 240);
            String tx = DebtPaySheet$lambda$13(mutableState) ? LangKt.tx("Принимаем…", new Object[0]) : LangKt.tx("Принять", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, 1723587067, "CC(remember):DebtsScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(debtSale) | composer.changedInstance(repo) | composer.changed(function02) | composer.changed(function0);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                Function0 function03 = new Function0() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DebtPaySheet$lambda$15$0$0;
                        DebtPaySheet$lambda$15$0$0 = DebtsScreenKt.DebtPaySheet$lambda$15$0$0(CoroutineScope.this, mutableState, mutableState2, debtSale, repo, function02, function0, mutableState3, mutableState4);
                        return DebtPaySheet$lambda$15$0$0;
                    }
                };
                composer.updateRememberedValue(function03);
                rememberedValue = function03;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.6f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, !DebtPaySheet$lambda$13(mutableState), false, null, composer, 27648, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtPaySheet$lambda$15$0$0(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, DebtSale debtSale, Repo repo, Function0 function0, Function0 function02, MutableState mutableState3, MutableState mutableState4) {
        DebtPaySheet$submit(coroutineScope, mutableState, mutableState2, debtSale, repo, function0, function02, mutableState3, mutableState4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DebtPaySheet$lambda$16(final DebtSale debtSale, Repo repo, MutableState mutableState, MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, ColumnScope OxCardSheet, Composer composer, int i) {
        final MutableState mutableState5;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C1064@39427L21,1064@39396L2788:DebtsScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1158587590, i, -1, "uz.FonRo.pos.ui.money.DebtPaySheet.<anonymous> (DebtsScreen.kt:1064)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1389072706, "C1065@39465L746,1106@41325L436,1116@41774L11,1121@41920L14,1118@41799L149,1123@41961L11,1128@42096L13,1125@41986L188:DebtsScreen.kt#fh874k");
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null);
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, m1053paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -573394521, "C1070@39701L67,1071@39785L76:DebtsScreen.kt#fh874k");
            boolean z = true;
            TextKt.m2798Text4IGK_g(LangKt.tx("Долг клиента ", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            TextKt.m2798Text4IGK_g(repo.money(Double.valueOf(debtSale.getDebtAmount())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH3(), Ox.INSTANCE.m10196getDanger0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            Composer composer2 = composer;
            String customerName = debtSale.getCustomerName();
            if (customerName != null && !StringsKt.isBlank(customerName)) {
                composer2.startReplaceGroup(-573165401);
                ComposerKt.sourceInformation(composer2, "1073@39940L239");
                TextKt.m2798Text4IGK_g(" · " + debtSale.getCustomerName(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 3120, 55294);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-572917866);
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (!debtSale.getItems().isEmpty()) {
                composer2.startReplaceGroup(-1388341231);
                ComposerKt.sourceInformation(composer2, "1083@40326L943,1083@40272L997,1103@41286L11");
                BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(12.0f), OxShape.INSTANCE.getCardSoft(), 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1440798193, true, new Function3() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda49
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit DebtPaySheet$lambda$16$0$1;
                        DebtPaySheet$lambda$16$0$1 = DebtsScreenKt.DebtPaySheet$lambda$16$0$1(DebtSale.this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return DebtPaySheet$lambda$16$0$1;
                    }
                }, composer2, 54), composer, 1572912, 57);
                composer2 = composer;
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer2, 6);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1387325454);
                composer2.endReplaceGroup();
            }
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer2, 6);
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
            ComposerKt.sourceInformationMarkerStart(composer2, -1182980686, "C1109@41501L26,1107@41399L167,1113@41682L26,1111@41583L164:DebtsScreen.kt#fh874k");
            String tx = LangKt.tx("Наличные", new Object[0]);
            boolean z2 = DebtPaySheet$lambda$1(mutableState) == PayType.CASH;
            ComposerKt.sourceInformationMarkerStart(composer2, 377484271, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue = composer2.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableState5 = mutableState;
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda50
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DebtPaySheet$lambda$16$0$2$0$0;
                        DebtPaySheet$lambda$16$0$2$0$0 = DebtsScreenKt.DebtPaySheet$lambda$16$0$2$0$0(MutableState.this);
                        return DebtPaySheet$lambda$16$0$2$0$0;
                    }
                };
                composer2.updateRememberedValue(rememberedValue);
            } else {
                mutableState5 = mutableState;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            PayTypeButton("💵", tx, z2, (Function0) rememberedValue, RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 3078, 0);
            String tx2 = LangKt.tx("Карта", new Object[0]);
            if (DebtPaySheet$lambda$1(mutableState5) != PayType.CARD) {
                z = false;
            }
            ComposerKt.sourceInformationMarkerStart(composer, 377490063, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda51
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DebtPaySheet$lambda$16$0$2$1$0;
                        DebtPaySheet$lambda$16$0$2$1$0 = DebtsScreenKt.DebtPaySheet$lambda$16$0$2$1$0(MutableState.this);
                        return DebtPaySheet$lambda$16$0$2$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            PayTypeButton("💳", tx2, z, (Function0) rememberedValue2, RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 3078, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            String tx3 = LangKt.tx("Принять:", new Object[0]);
            String nf = Fmt.INSTANCE.nf(Double.valueOf(DebtPaySheet$lambda$4(mutableState2)));
            ComposerKt.sourceInformationMarkerStart(composer, -2122942914, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda52
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DebtPaySheet$lambda$16$0$3$0;
                        DebtPaySheet$lambda$16$0$3$0 = DebtsScreenKt.DebtPaySheet$lambda$16$0$3$0(MutableState.this);
                        return DebtPaySheet$lambda$16$0$3$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9849OxValueButtonFHprtrg(tx3, nf, (Function0) rememberedValue3, null, 0L, null, composer, 384, 56);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            String tx4 = LangKt.tx("Заметка", new Object[0]);
            String DebtPaySheet$lambda$7 = DebtPaySheet$lambda$7(mutableState4);
            ComposerKt.sourceInformationMarkerStart(composer, -2122937283, "CC(remember):DebtsScreen.kt#9igjgp");
            Object rememberedValue4 = composer.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda53
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DebtPaySheet$lambda$16$0$4$0;
                        DebtPaySheet$lambda$16$0$4$0 = DebtsScreenKt.DebtPaySheet$lambda$16$0$4$0(MutableState.this, (String) obj);
                        return DebtPaySheet$lambda$16$0$4$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9846OxFieldDfSPO0(tx4, DebtPaySheet$lambda$7, (Function1) rememberedValue4, null, LangKt.tx("необязательно", new Object[0]), 0, 0, null, false, false, false, false, false, null, null, composer, 384, 0, 32744);
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
    public static final Unit DebtPaySheet$lambda$16$0$1(DebtSale debtSale, ColumnScope OxSoftCard, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer2, "C*1085@40401L828:DebtsScreen.kt#fh874k");
        int i2 = 0;
        int i3 = 1;
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1440798193, i, -1, "uz.FonRo.pos.ui.money.DebtPaySheet.<anonymous>.<anonymous>.<anonymous> (DebtsScreen.kt:1084)");
            }
            for (DebtSaleItem debtSaleItem : debtSale.getItems()) {
                Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, i3, null), 0.0f, Dp.m6989constructorimpl(5.0f), i3, null);
                Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer2, 6);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, i2);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m1051paddingVpY3zN4$default);
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
                Updater.m3815setimpl(m3808constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 1196893664, "C1089@40631L359,1096@41019L184:DebtsScreen.kt#fh874k");
                TextKt.m2798Text4IGK_g(debtSaleItem.getName() + " × " + Fmt.INSTANCE.qf(Double.valueOf(debtSaleItem.getQuantity())), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 3120, 55292);
                TextKt.m2798Text4IGK_g(Fmt.INSTANCE.nf(Double.valueOf(debtSaleItem.getTotalAmount())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowTitle(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 0, 0, 65534);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer2 = composer;
                i2 = i2;
                i3 = i3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtPaySheet$lambda$16$0$2$0$0(MutableState mutableState) {
        mutableState.setValue(PayType.CASH);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtPaySheet$lambda$16$0$2$1$0(MutableState mutableState) {
        mutableState.setValue(PayType.CARD);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtPaySheet$lambda$16$0$3$0(MutableState mutableState) {
        DebtPaySheet$lambda$11(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtPaySheet$lambda$16$0$4$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtPaySheet$lambda$17$0(DebtSale debtSale, MutableState mutableState, double d) {
        DebtPaySheet$lambda$5(mutableState, Math.min(debtSale.getDebtAmount(), Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, d)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebtPaySheet$lambda$18$0(MutableState mutableState) {
        DebtPaySheet$lambda$11(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void PayTypeButton(final java.lang.String r62, final java.lang.String r63, final boolean r64, final kotlin.jvm.functions.Function0<kotlin.Unit> r65, androidx.compose.ui.Modifier r66, androidx.compose.runtime.Composer r67, final int r68, final int r69) {
        /*
            Method dump skipped, instructions count: 729
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.money.DebtsScreenKt.PayTypeButton(java.lang.String, java.lang.String, boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void DdRow(final String str, String str2, Composer composer, final int i) {
        int i2;
        final String str3;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1586109004);
        ComposerKt.sourceInformation(startRestartGroup, "C(DdRow)1177@43536L845:DebtsScreen.kt#fh874k");
        if ((i & 6) == 0) {
            i2 = i | (startRestartGroup.changed(str) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            str3 = str2;
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1586109004, i2, -1, "uz.FonRo.pos.ui.money.DdRow (DebtsScreen.kt:1176)");
            }
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(9.0f), 7, null), OxShape.INSTANCE.getTileSm()), Ox.INSTANCE.m10218getPanel20d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getTileSm()), Dp.m6989constructorimpl(15.0f), Dp.m6989constructorimpl(13.0f));
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 720205439, "C1188@43947L287,1197@44243L132:DebtsScreen.kt#fh874k");
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), TextUnitKt.getSp(13.5d), FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer2, i2 & 14, 3120, 55292);
            str3 = str2;
            TextKt.m2798Text4IGK_g(str3, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowTitle(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6874getEnde0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744443, null), composer2, (i2 >> 3) & 14, 0, 65534);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DebtsScreenKt.DdRow$lambda$1(str, str3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void DdSection(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(525261478);
        ComposerKt.sourceInformation(startRestartGroup, "C(DdSection)1207@44466L117:DebtsScreen.kt#fh874k");
        if ((i & 6) == 0) {
            i2 = i | (startRestartGroup.changed(str) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(525261478, i2, -1, "uz.FonRo.pos.ui.money.DdSection (DebtsScreen.kt:1206)");
            }
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(14.0f), 0.0f, Dp.m6989constructorimpl(8.0f), 5, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH2(), composer2, (i2 & 14) | 48, 0, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DebtsScreenKt.DdSection$lambda$0(str, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void PaymentRow(final String str, final String str2, final String str3, final String str4, Composer composer, final int i) {
        String str5;
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(952035050);
        ComposerKt.sourceInformation(startRestartGroup, "C(PaymentRow)P(3)1217@44728L1057:DebtsScreen.kt#fh874k");
        if ((i & 6) == 0) {
            str5 = str;
            i2 = (startRestartGroup.changed(str5) ? 4 : 2) | i;
        } else {
            str5 = str;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(str3) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(str4) ? 2048 : 1024;
        }
        if (!startRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(952035050, i2, -1, "uz.FonRo.pos.ui.money.PaymentRow (DebtsScreen.kt:1216)");
            }
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(9.0f), 7, null), OxShape.INSTANCE.getTileSm()), Ox.INSTANCE.m10218getPanel20d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getTileSm()), Dp.m6989constructorimpl(15.0f), Dp.m6989constructorimpl(12.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1873154467, "C1226@45025L476:DebtsScreen.kt#fh874k");
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2141879562, "C1231@45226L165,1236@45404L87:DebtsScreen.kt#fh874k");
            int i3 = i2;
            TextKt.m2798Text4IGK_g(str5, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowTitle(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), startRestartGroup, i2 & 14, 0, 65532);
            TextKt.m2798Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowTitle(), Ox.INSTANCE.m10211getOk0d7_KjU(), 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), startRestartGroup, (i3 >> 3) & 14, 0, 65534);
            composer2 = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (!StringsKt.isBlank(str3)) {
                composer2.startReplaceGroup(-1872653632);
                ComposerKt.sourceInformation(composer2, "1239@45551L78");
                TextKt.m2798Text4IGK_g(str3, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(3.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer2, ((i3 >> 6) & 14) | 48, 0, 65532);
                composer2 = composer2;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1872568754);
                composer2.endReplaceGroup();
            }
            if (!StringsKt.isBlank(str4)) {
                composer2.startReplaceGroup(-1872515713);
                ComposerKt.sourceInformation(composer2, "1242@45690L79");
                Composer composer3 = composer2;
                TextKt.m2798Text4IGK_g(str4, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(3.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer3, ((i3 >> 9) & 14) | 48, 0, 65532);
                composer2 = composer3;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1872429874);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.DebtsScreenKt$$ExternalSyntheticLambda61
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DebtsScreenKt.PaymentRow$lambda$1(str, str2, str3, str4, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String payLabel(String str) {
        return StringsKt.isBlank(str) ? "—" : PayType.INSTANCE.of(str).getLabel();
    }

    private static final SyncData DebtsScreen$lambda$0(State<SyncData> state) {
        return state.getValue();
    }

    private static final List<Customer> DebtsScreen$lambda$1(State<? extends List<Customer>> state) {
        return state.getValue();
    }
}
