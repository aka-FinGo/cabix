package uz.FonRo.pos.ui.stats;

import androidx.camera.video.AudioStats;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
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
import androidx.compose.ui.graphics.ColorKt;
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
import com.google.firebase.analytics.FirebaseAnalytics;
import j$.time.LocalDate;
import j$.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Num;
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.data.local.CacheStore;
import uz.FonRo.pos.data.model.AuditDoc;
import uz.FonRo.pos.data.model.AuditItem;
import uz.FonRo.pos.data.model.DebtPayment;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.model.ReturnDoc;
import uz.FonRo.pos.data.model.SaleRow;
import uz.FonRo.pos.data.model.StatsAmount;
import uz.FonRo.pos.data.model.StatsCategory;
import uz.FonRo.pos.data.model.StatsDay;
import uz.FonRo.pos.data.model.StatsEmployee;
import uz.FonRo.pos.data.model.StatsInventory;
import uz.FonRo.pos.data.model.StatsProduct;
import uz.FonRo.pos.data.model.StatsReturnDay;
import uz.FonRo.pos.data.model.StoreStats;
import uz.FonRo.pos.data.model.SyncData;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.catalog.CatalogScreenKt;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.ChipTint;
import uz.FonRo.pos.ui.components.ChipsKt;
import uz.FonRo.pos.ui.components.PeriodKind;
import uz.FonRo.pos.ui.components.PeriodPickersKt;
import uz.FonRo.pos.ui.components.PeriodState;
import uz.FonRo.pos.ui.money.Receipt;
import uz.FonRo.pos.ui.money.Receipts;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.nav.Routes;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxDim;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: StatsScreen.kt */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a/\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007b\u0002\b\u001eb\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!¢\u0006\u0002\u0010\u001d\u001a5\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00180&H\u0003b\u0002\b\u001eb\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!¢\u0006\u0002\u0010'\u001a\u0012\u0010(\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010$H\u0002\u001a\u0010\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020$H\u0002\u001a>\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u0010/\u001a\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u0002020-2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0002\u001av\u00109\u001a\u00020:2\u0006\u0010/\u001a\u0002002\f\u0010;\u001a\b\u0012\u0004\u0012\u00020<0-2\b\u00103\u001a\u0004\u0018\u0001042\f\u0010=\u001a\b\u0012\u0004\u0012\u00020>0-2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@2\u0006\u00107\u001a\u0002082\u0006\u00105\u001a\u0002062\u0006\u0010B\u001a\u0002062\u0006\u0010C\u001a\u0002062\u0006\u0010D\u001a\u0002062\u0006\u0010E\u001a\u000206H\u0002\u001al\u0010F\u001a\u00020\u0018*\u00020G2\u0006\u0010H\u001a\u00020:2\u0006\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020$2\u0006\u00105\u001a\u0002062\u0006\u0010B\u001a\u0002062\u0006\u0010K\u001a\u00020$2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00180M2\u0006\u0010N\u001a\u00020$2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00180MH\u0002\u001a[\u0010P\u001a\u00020\u00182\u0006\u0010J\u001a\u00020$2\b\b\u0002\u0010Q\u001a\u00020R2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010$2\u001c\u0010T\u001a\u0018\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020\u00180M¢\u0006\u0002\b\u001e¢\u0006\u0002\bVH\u0003b\u0002\b\u001eb\f\bX\u0012\b\bY\u0012\u0004\b\b(Z¢\u0006\u0002\u0010W\u001aC\u0010[\u001a\u00020\u00182\u0006\u0010)\u001a\u00020$2\u0006\u0010\\\u001a\u00020$2\u0006\u0010]\u001a\u00020\u00012\b\b\u0002\u0010Q\u001a\u00020RH\u0003b\u0002\b\u001eb\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!¢\u0006\u0004\b^\u0010_\u001aI\u0010`\u001a\u00020\u00182\u0006\u0010H\u001a\u00020:2\u0006\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020$2\u0006\u0010B\u001a\u0002062\b\b\u0002\u0010Q\u001a\u00020RH\u0003b\u0002\b\u001eb\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!¢\u0006\u0002\u0010a\u001a1\u0010b\u001a\u00020\u00182\u0006\u0010H\u001a\u00020:2\b\b\u0002\u0010Q\u001a\u00020RH\u0003b\u0002\b\u001eb\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!¢\u0006\u0002\u0010c\u001a1\u0010d\u001a\u00020\u00182\u0006\u0010e\u001a\u00020f2\b\b\u0002\u0010Q\u001a\u00020RH\u0003b\u0002\b\u001eb\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!¢\u0006\u0002\u0010g\u001as\u0010h\u001a\u00020\u00182\u0006\u0010J\u001a\u00020$2\u0006\u0010S\u001a\u00020$2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020.0-2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020@0M2\u0006\u0010j\u001a\u00020\u00122\u0006\u0010]\u001a\u00020\u00012\u0006\u00105\u001a\u0002062\u0006\u0010k\u001a\u00020lH\u0003b\u0002\b\u001eb\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!¢\u0006\u0004\bm\u0010n\u001aY\u0010o\u001a\u00020\u00182\f\u0010p\u001a\b\u0012\u0004\u0012\u00020q0-2\u0006\u0010J\u001a\u00020$2\u0006\u0010B\u001a\u0002062\u0006\u0010r\u001a\u00020$2\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00180MH\u0003b\u0002\b\u001eb\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!¢\u0006\u0002\u0010t\u001a\u0018\u0010u\u001a\u00020@2\u0006\u0010v\u001a\u00020q2\u0006\u0010r\u001a\u00020$H\u0002\u001a\u0010\u0010w\u001a\u00020$2\u0006\u0010v\u001a\u00020qH\u0002\u001a\u0010\u0010x\u001a\u00020$2\u0006\u0010v\u001a\u00020qH\u0002\u001a\u0016\u0010y\u001a\b\u0012\u0004\u0012\u00020z0-2\u0006\u0010v\u001a\u00020qH\u0002\u001a7\u0010{\u001a\u00020\u00182\u0006\u0010v\u001a\u00020q2\u0006\u0010|\u001a\u00020@2\u0006\u0010B\u001a\u000206H\u0003b\u0002\b\u001eb\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!¢\u0006\u0002\u0010}\u001a\u0018\u0010~\u001a\u00020$2\u0006\u0010v\u001a\u00020q2\u0006\u0010B\u001a\u000206H\u0002\u001aZ\u0010\u007f\u001a\u00020\u00182\r\u0010=\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010-2\u0006\u0010J\u001a\u00020$2\u0006\u0010B\u001a\u0002062\u0006\u0010r\u001a\u00020$2\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00180MH\u0003b\u0002\b\u001eb\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!¢\u0006\u0002\u0010t\u001a\u001b\u0010\u0081\u0001\u001a\u00020@2\b\u0010\u0082\u0001\u001a\u00030\u0080\u00012\u0006\u0010r\u001a\u00020$H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0010\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0013\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019²\u0006\u0010\u0010=\u001a\b\u0012\u0004\u0012\u00020>0-X\u008a\u0084\u0002²\u0006\f\u00103\u001a\u0004\u0018\u000104X\u008a\u0084\u0002²\u0006\f\u0010/\u001a\u0004\u0018\u000100X\u008a\u008e\u0002²\u0006\u0010\u0010;\u001a\b\u0012\u0004\u0012\u00020<0-X\u008a\u008e\u0002²\u0006\u000b\u0010\u0083\u0001\u001a\u000206X\u008a\u008e\u0002²\u0006\r\u0010\u0084\u0001\u001a\u0004\u0018\u00010$X\u008a\u008e\u0002²\u0006\u000b\u0010\u0085\u0001\u001a\u00020lX\u008a\u008e\u0002²\u0006\u000b\u0010\u0086\u0001\u001a\u000206X\u008a\u008e\u0002²\u0006\u000b\u0010\u0087\u0001\u001a\u000206X\u008a\u008e\u0002²\u0006\n\u0010K\u001a\u00020$X\u008a\u008e\u0002²\u0006\n\u0010N\u001a\u00020$X\u008a\u008e\u0002"}, d2 = {"CSale", "Landroidx/compose/ui/graphics/Color;", "J", "CDiscount", "CProfit", "CCash", "CCard", "CPaid", "CDebtIn", "CAmber", "CReturn", "CExpense", "CExpenseBar", "COther", "CCategory", "TintCyan", "TintYellow", "SalesBrush", "Landroidx/compose/ui/graphics/Brush;", "ProfitBrush", "getProfitBrush", "()Landroidx/compose/ui/graphics/Brush;", "ReturnBrush", "StatsScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "LoadFailure", "message", "", "onRetry", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "hourKey", "value", "dayLabel", "iso", "buildBuckets", "", "Luz/FonRo/pos/ui/stats/Bucket;", Routes.STATS, "Luz/FonRo/pos/data/model/StoreStats;", "receipts", "Luz/FonRo/pos/ui/money/Receipt;", "sync", "Luz/FonRo/pos/data/model/SyncData;", "hourly", "", TypedValues.CycleType.S_WAVE_PERIOD, "Luz/FonRo/pos/ui/components/PeriodState;", "buildModel", "Luz/FonRo/pos/ui/stats/StatsModel;", "rows", "Luz/FonRo/pos/data/model/SaleRow;", CacheStore.PRODUCTS, "Luz/FonRo/pos/data/model/Product;", "stockUnits", "", "lowLimit", "canProfit", "canCash", "canCard", "canPurchase", "statsSections", "Landroidx/compose/foundation/lazy/LazyListScope;", "model", FirebaseAnalytics.Param.CURRENCY, "title", "empMetric", "onEmpMetric", "Lkotlin/Function1;", "topMetric", "onTopMetric", "PdCard", "modifier", "Landroidx/compose/ui/Modifier;", "subtitle", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/runtime/ComposableInferredTarget;", "scheme", "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]", "MiniStat", "label", "tint", "MiniStat-cf5BqRc", "(Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "HeroCard", "(Luz/FonRo/pos/ui/stats/StatsModel;Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SummaryGrid", "(Luz/FonRo/pos/ui/stats/StatsModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SummaryTileView", "tile", "Luz/FonRo/pos/ui/stats/SummaryTile;", "(Luz/FonRo/pos/ui/stats/SummaryTile;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ChartCard", "buckets", "brush", "periodDays", "", "ChartCard-cd68TDI", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Brush;JZILandroidx/compose/runtime/Composer;I)V", "EmployeesCard", "employees", "Luz/FonRo/pos/data/model/StatsEmployee;", "metric", "onMetric", "(Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "employeeMetric", "e", "employeeName", "employeeRole", "paySegments", "Luz/FonRo/pos/ui/stats/PaySegment;", "EmployeeRow", "maxRevenue", "(Luz/FonRo/pos/data/model/StatsEmployee;DZLandroidx/compose/runtime/Composer;I)V", "employeeSubtitle", "TopProductsCard", "Luz/FonRo/pos/data/model/StatsProduct;", "productMetric", "p", "loading", "failure", "retry", "monthOpen", "dateOpen"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class StatsScreenKt {
    private static final long CSale = Ox.INSTANCE.m10201getGreen0d7_KjU();
    private static final long CDiscount = Ox.INSTANCE.m10226getRose0d7_KjU();
    private static final long CProfit = Ox.INSTANCE.m10230getSkyBar0d7_KjU();
    private static final long CCash = Ox.INSTANCE.m10201getGreen0d7_KjU();
    private static final long CCard = Ox.INSTANCE.m10186getBlue0d7_KjU();
    private static final long CPaid = Ox.INSTANCE.m10232getTeal0d7_KjU();
    private static final long CDebtIn = Ox.INSTANCE.m10195getCyanLight0d7_KjU();
    private static final long CAmber = Ox.INSTANCE.m10184getAmber0d7_KjU();
    private static final long CReturn = Ox.INSTANCE.m10216getOrangeLight0d7_KjU();
    private static final long CExpense = Ox.INSTANCE.m10224getRed0d7_KjU();
    private static final long CExpenseBar = Ox.INSTANCE.m10225getRedLight0d7_KjU();
    private static final long COther = Ox.INSTANCE.m10231getSlate0d7_KjU();
    private static final long CCategory = Ox.INSTANCE.m10223getPurple0d7_KjU();
    private static final long TintCyan = ColorKt.Color(4278630100L);
    private static final long TintYellow = ColorKt.Color(4293571336L);
    private static final Brush SalesBrush = Brush.Companion.m4341verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m4374boximpl(Ox.INSTANCE.m10203getGreenLight0d7_KjU()), Color.m4374boximpl(Ox.INSTANCE.m10202getGreenDeep0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null);
    private static final Brush ReturnBrush = Brush.Companion.m4341verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m4374boximpl(ColorKt.Color(4294688548L)), Color.m4374boximpl(Ox.INSTANCE.m10213getOrange0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ChartCard_cd68TDI$lambda$3(String str, String str2, List list, Function1 function1, Brush brush, long j, boolean z, int i, int i2, Composer composer, int i3) {
        m10161ChartCardcd68TDI(str, str2, list, function1, brush, j, z, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit EmployeeRow$lambda$1(StatsEmployee statsEmployee, double d, boolean z, int i, Composer composer, int i2) {
        EmployeeRow(statsEmployee, d, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit EmployeesCard$lambda$1(List list, String str, boolean z, String str2, Function1 function1, int i, Composer composer, int i2) {
        EmployeesCard(list, str, z, str2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit HeroCard$lambda$1(StatsModel statsModel, String str, String str2, boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        HeroCard(statsModel, str, str2, z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LoadFailure$lambda$1(String str, Function0 function0, int i, Composer composer, int i2) {
        LoadFailure(str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MiniStat_cf5BqRc$lambda$1(String str, String str2, long j, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m10162MiniStatcf5BqRc(str, str2, j, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PdCard$lambda$1(String str, Modifier modifier, String str2, Function3 function3, int i, int i2, Composer composer, int i3) {
        PdCard(str, modifier, str2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit StatsScreen$lambda$38(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        StatsScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SummaryGrid$lambda$2(StatsModel statsModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SummaryGrid(statsModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SummaryTileView$lambda$1(SummaryTile summaryTile, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SummaryTileView(summaryTile, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TopProductsCard$lambda$1(List list, String str, boolean z, String str2, Function1 function1, int i, Composer composer, int i2) {
        TopProductsCard(list, str, z, str2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final Brush getProfitBrush() {
        return Brush.Companion.m4341verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m4374boximpl(Ox.INSTANCE.m10230getSkyBar0d7_KjU()), Color.m4374boximpl(Ox.INSTANCE.m10220getPrimary0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null);
    }

    public static final void StatsScreen(final FonRoApp app, final AppNavigator nav, Composer composer, final int i) {
        int i2;
        MutableState mutableState;
        MutableState mutableState2;
        Repo repo;
        MutableState mutableState3;
        boolean z;
        boolean z2;
        StatsModel statsModel;
        final MutableState mutableState4;
        final MutableState mutableState5;
        final PeriodState periodState;
        final MutableState mutableState6;
        final MutableState mutableState7;
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(nav, "nav");
        Composer startRestartGroup = composer.startRestartGroup(-1795079871);
        ComposerKt.sourceInformation(startRestartGroup, "C(StatsScreen)136@5866L29,137@5922L29,144@6209L43,153@6637L46,154@6700L55,155@6775L33,156@6828L42,157@6888L30,159@6941L34,160@6996L34,165@7258L38,166@7318L38,168@7392L1536,168@7362L1566,206@8951L45,207@9013L432,221@9603L1156,218@9451L1308:StatsScreen.kt#fklwc3");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1795079871, i2, -1, "uz.FonRo.pos.ui.stats.StatsScreen (StatsScreen.kt:133)");
            }
            Repo repo2 = app.getRepo();
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(repo2.getProducts(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            State collectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(repo2.getSync(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            boolean can = repo2.can(Perm.VIEW_PROFIT);
            boolean can2 = repo2.can(Perm.VIEW_CASH_SALES);
            boolean can3 = repo2.can(Perm.VIEW_CARD_SALES);
            boolean can4 = repo2.can(Perm.VIEW_PURCHASE_PRICE);
            final String currency = repo2.currency();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1505111564, "CC(remember):StatsScreen.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = Double.valueOf(repo2.getPrefs().getLowStock());
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            double doubleValue = ((Number) rememberedValue).doubleValue();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final PeriodState state = StatsPeriod.INSTANCE.getState();
            boolean z3 = state.getKind() == PeriodKind.TODAY || state.getKind() == PeriodKind.DATE;
            final String title = state.title();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1505125263, "CC(remember):StatsScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState8 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1505127288, "CC(remember):StatsScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            MutableState mutableState9 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1505129666, "CC(remember):StatsScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState10 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1505131371, "CC(remember):StatsScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            MutableState mutableState11 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1505133279, "CC(remember):StatsScreen.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            MutableState mutableState12 = (MutableState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1505134979, "CC(remember):StatsScreen.kt#9igjgp");
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            MutableState mutableState13 = (MutableState) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1505136739, "CC(remember):StatsScreen.kt#9igjgp");
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(mutableStateOf$default);
                rememberedValue8 = mutableStateOf$default;
            }
            MutableState mutableState14 = (MutableState) rememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1505145127, "CC(remember):StatsScreen.kt#9igjgp");
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState12;
                rememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("revenue", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            } else {
                mutableState = mutableState12;
            }
            MutableState mutableState15 = (MutableState) rememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1505147047, "CC(remember):StatsScreen.kt#9igjgp");
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                mutableState2 = mutableState15;
                rememberedValue10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("revenue", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            } else {
                mutableState2 = mutableState15;
            }
            final MutableState mutableState16 = (MutableState) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Integer valueOf = Integer.valueOf(StatsScreen$lambda$16(mutableState));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1505150913, "CC(remember):StatsScreen.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(state) | startRestartGroup.changedInstance(repo2);
            StatsScreenKt$StatsScreen$1$1 rememberedValue11 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                repo = repo2;
                mutableState3 = mutableState11;
                rememberedValue11 = new StatsScreenKt$StatsScreen$1$1(state, repo, mutableState10, mutableState3, mutableState8, mutableState9, null);
                startRestartGroup.updateRememberedValue(rememberedValue11);
            } else {
                repo = repo2;
                mutableState3 = mutableState11;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(state, valueOf, (Function2) rememberedValue11, startRestartGroup, PeriodState.$stable);
            List<Product> StatsScreen$lambda$0 = StatsScreen$lambda$0(collectAsStateWithLifecycle);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1505199310, "CC(remember):StatsScreen.kt#9igjgp");
            boolean changed = startRestartGroup.changed(StatsScreen$lambda$0);
            Object rememberedValue12 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                rememberedValue12 = Double.valueOf(repo.wholeStockUnits());
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            double doubleValue2 = ((Number) rememberedValue12).doubleValue();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            StoreStats StatsScreen$lambda$4 = StatsScreen$lambda$4(mutableState8);
            List<SaleRow> StatsScreen$lambda$7 = StatsScreen$lambda$7(mutableState9);
            SyncData StatsScreen$lambda$1 = StatsScreen$lambda$1(collectAsStateWithLifecycle2);
            List<Product> StatsScreen$lambda$02 = StatsScreen$lambda$0(collectAsStateWithLifecycle);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1505201681, "CC(remember):StatsScreen.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(StatsScreen$lambda$4) | startRestartGroup.changed(StatsScreen$lambda$7) | startRestartGroup.changed(StatsScreen$lambda$1) | startRestartGroup.changed(StatsScreen$lambda$02) | startRestartGroup.changed(state) | startRestartGroup.changed(z3) | startRestartGroup.changed(doubleValue2);
            Object rememberedValue13 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                StoreStats StatsScreen$lambda$42 = StatsScreen$lambda$4(mutableState8);
                if (StatsScreen$lambda$42 != null) {
                    boolean z4 = z3;
                    statsModel = buildModel(StatsScreen$lambda$42, StatsScreen$lambda$7(mutableState9), StatsScreen$lambda$1(collectAsStateWithLifecycle2), StatsScreen$lambda$0(collectAsStateWithLifecycle), doubleValue2, doubleValue, state, z4, can, can2, can3, can4);
                    z = z4;
                    z2 = can;
                } else {
                    z = z3;
                    z2 = can;
                    statsModel = null;
                }
                startRestartGroup.updateRememberedValue(statsModel);
                rememberedValue13 = statsModel;
            } else {
                z = z3;
                z2 = can;
            }
            final StatsModel statsModel2 = (StatsModel) rememberedValue13;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), OxDim.INSTANCE.m10245getPagePadD9Ej5fM(), 0.0f, 2, null);
            PaddingValues m1046PaddingValuesa9UjIt4$default = PaddingKt.m1046PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(28.0f), 7, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1505221285, "CC(remember):StatsScreen.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(state) | startRestartGroup.changedInstance(statsModel2) | startRestartGroup.changed(currency) | startRestartGroup.changed(title) | startRestartGroup.changed(z) | startRestartGroup.changed(z2);
            Object rememberedValue14 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                final boolean z5 = z2;
                final boolean z6 = z;
                mutableState4 = mutableState14;
                final MutableState mutableState17 = mutableState3;
                mutableState5 = mutableState13;
                final MutableState mutableState18 = mutableState;
                final MutableState mutableState19 = mutableState2;
                rememberedValue14 = new Function1() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda40
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit StatsScreen$lambda$33$0;
                        StatsScreen$lambda$33$0 = StatsScreenKt.StatsScreen$lambda$33$0(StatsModel.this, currency, title, z6, z5, state, mutableState5, mutableState4, mutableState17, mutableState18, mutableState10, mutableState19, mutableState16, (LazyListScope) obj);
                        return StatsScreen$lambda$33$0;
                    }
                };
                periodState = state;
                startRestartGroup.updateRememberedValue(rememberedValue14);
            } else {
                periodState = state;
                mutableState4 = mutableState14;
                mutableState5 = mutableState13;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            MutableState mutableState20 = mutableState5;
            LazyDslKt.LazyColumn(m1051paddingVpY3zN4$default, null, m1046PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) rememberedValue14, startRestartGroup, 384, TypedValues.PositionType.TYPE_PERCENT_X);
            startRestartGroup = startRestartGroup;
            if (StatsScreen$lambda$19(mutableState20)) {
                startRestartGroup.startReplaceGroup(-581640053);
                ComposerKt.sourceInformation(startRestartGroup, "261@10864L21,262@10908L134,259@10790L262");
                String month = periodState.getMonth();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1505260502, "CC(remember):StatsScreen.kt#9igjgp");
                Object rememberedValue15 = startRestartGroup.rememberedValue();
                if (rememberedValue15 == Composer.INSTANCE.getEmpty()) {
                    mutableState7 = mutableState20;
                    rememberedValue15 = new Function0() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda41
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit StatsScreen$lambda$34$0;
                            StatsScreen$lambda$34$0 = StatsScreenKt.StatsScreen$lambda$34$0(MutableState.this);
                            return StatsScreen$lambda$34$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue15);
                } else {
                    mutableState7 = mutableState20;
                }
                Function0 function0 = (Function0) rememberedValue15;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1505262023, "CC(remember):StatsScreen.kt#9igjgp");
                boolean changedInstance3 = startRestartGroup.changedInstance(periodState);
                Object rememberedValue16 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue16 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue16 = new Function1() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda42
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit StatsScreen$lambda$35$0;
                            StatsScreen$lambda$35$0 = StatsScreenKt.StatsScreen$lambda$35$0(PeriodState.this, mutableState7, (String) obj);
                            return StatsScreen$lambda$35$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue16);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                PeriodPickersKt.OxMonthSheet(month, function0, (Function1) rememberedValue16, startRestartGroup, 48);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-581372895);
                startRestartGroup.endReplaceGroup();
            }
            if (StatsScreen$lambda$22(mutableState4)) {
                startRestartGroup.startReplaceGroup(-581344437);
                ComposerKt.sourceInformation(startRestartGroup, "272@11166L20,273@11209L131,270@11088L262");
                String date = periodState.getDate();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1505270165, "CC(remember):StatsScreen.kt#9igjgp");
                Object rememberedValue17 = startRestartGroup.rememberedValue();
                if (rememberedValue17 == Composer.INSTANCE.getEmpty()) {
                    mutableState6 = mutableState4;
                    rememberedValue17 = new Function0() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda43
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit StatsScreen$lambda$36$0;
                            StatsScreen$lambda$36$0 = StatsScreenKt.StatsScreen$lambda$36$0(MutableState.this);
                            return StatsScreen$lambda$36$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue17);
                } else {
                    mutableState6 = mutableState4;
                }
                Function0 function02 = (Function0) rememberedValue17;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1505271652, "CC(remember):StatsScreen.kt#9igjgp");
                boolean changedInstance4 = startRestartGroup.changedInstance(periodState);
                Object rememberedValue18 = startRestartGroup.rememberedValue();
                if (changedInstance4 || rememberedValue18 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue18 = new Function1() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda45
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit StatsScreen$lambda$37$0;
                            StatsScreen$lambda$37$0 = StatsScreenKt.StatsScreen$lambda$37$0(PeriodState.this, mutableState6, (String) obj);
                            return StatsScreen$lambda$37$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue18);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                PeriodPickersKt.OxDayPickerDialog(date, function02, (Function1) rememberedValue18, startRestartGroup, 48);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-581077279);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda46
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatsScreenKt.StatsScreen$lambda$38(FonRoApp.this, nav, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final StoreStats StatsScreen$lambda$4(MutableState<StoreStats> mutableState) {
        return mutableState.getValue();
    }

    private static final List<SaleRow> StatsScreen$lambda$7(MutableState<List<SaleRow>> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean StatsScreen$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StatsScreen$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String StatsScreen$lambda$13(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final int StatsScreen$lambda$16(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void StatsScreen$lambda$17(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final boolean StatsScreen$lambda$19(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void StatsScreen$lambda$20(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean StatsScreen$lambda$22(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void StatsScreen$lambda$23(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String StatsScreen$lambda$25(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String StatsScreen$lambda$28(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatsScreen$lambda$33$0(StatsModel statsModel, String str, String str2, boolean z, boolean z2, final PeriodState periodState, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$StatsScreenKt.INSTANCE.getLambda$8567948$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(224430517, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda44
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit StatsScreen$lambda$33$0$0;
                StatsScreen$lambda$33$0$0 = StatsScreenKt.StatsScreen$lambda$33$0$0(PeriodState.this, mutableState, mutableState2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return StatsScreen$lambda$33$0$0;
            }
        }), 3, null);
        if (StatsScreen$lambda$13(mutableState3) != null) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1183981073, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda47
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit StatsScreen$lambda$33$0$1;
                    StatsScreen$lambda$33$0$1 = StatsScreenKt.StatsScreen$lambda$33$0$1(MutableState.this, mutableState4, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return StatsScreen$lambda$33$0$1;
                }
            }), 3, null);
        } else if (statsModel == null) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(82414600, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda48
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit StatsScreen$lambda$33$0$2;
                    StatsScreen$lambda$33$0$2 = StatsScreenKt.StatsScreen$lambda$33$0$2(MutableState.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return StatsScreen$lambda$33$0$2;
                }
            }), 3, null);
        } else {
            statsSections(LazyColumn, statsModel, str, str2, z, z2, StatsScreen$lambda$25(mutableState6), new Function1() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda49
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit StatsScreen$lambda$33$0$3;
                    StatsScreen$lambda$33$0$3 = StatsScreenKt.StatsScreen$lambda$33$0$3(MutableState.this, (String) obj);
                    return StatsScreen$lambda$33$0$3;
                }
            }, StatsScreen$lambda$28(mutableState7), new Function1() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda50
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit StatsScreen$lambda$33$0$4;
                    StatsScreen$lambda$33$0$4 = StatsScreenKt.StatsScreen$lambda$33$0$4(MutableState.this, (String) obj);
                    return StatsScreen$lambda$33$0$4;
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatsScreen$lambda$33$0$0(PeriodState periodState, final MutableState mutableState, final MutableState mutableState2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C229@9773L26,232@9975L20,233@10026L19,227@9699L360:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(224430517, i, -1, "uz.FonRo.pos.ui.stats.StatsScreen.<anonymous>.<anonymous>.<anonymous> (StatsScreen.kt:227)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 929364879, "CC(remember):StatsScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit StatsScreen$lambda$33$0$0$0$0;
                        StatsScreen$lambda$33$0$0$0$0 = StatsScreenKt.StatsScreen$lambda$33$0$0$0$0((PeriodState) obj);
                        return StatsScreen$lambda$33$0$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function1 function1 = (Function1) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipTint chipTint = ChipTint.CYAN;
            List listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(LangKt.tx("Сегодня", new Object[0]), PeriodKind.TODAY), TuplesKt.to(LangKt.tx("10 дней", new Object[0]), PeriodKind.DAYS_10)});
            ComposerKt.sourceInformationMarkerStart(composer, 929371337, "CC(remember):StatsScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit StatsScreen$lambda$33$0$0$1$0;
                        StatsScreen$lambda$33$0$0$1$0 = StatsScreenKt.StatsScreen$lambda$33$0$0$1$0(MutableState.this);
                        return StatsScreen$lambda$33$0$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            Function0 function0 = (Function0) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 929372968, "CC(remember):StatsScreen.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit StatsScreen$lambda$33$0$0$2$0;
                        StatsScreen$lambda$33$0$0$2$0 = StatsScreenKt.StatsScreen$lambda$33$0$0$2$0(MutableState.this);
                        return StatsScreen$lambda$33$0$0$2$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.OxPeriodChips(periodState, function1, null, chipTint, listOf, function0, (Function0) rememberedValue3, composer, PeriodState.$stable | 1772592, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatsScreen$lambda$33$0$0$0$0(PeriodState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StatsPeriod.INSTANCE.setState(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatsScreen$lambda$33$0$0$1$0(MutableState mutableState) {
        StatsScreen$lambda$20(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatsScreen$lambda$33$0$0$2$0(MutableState mutableState) {
        StatsScreen$lambda$23(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatsScreen$lambda$33$0$1(MutableState mutableState, final MutableState mutableState2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C238@10152L11,238@10121L42:StatsScreen.kt#fklwc3");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1183981073, i, -1, "uz.FonRo.pos.ui.stats.StatsScreen.<anonymous>.<anonymous>.<anonymous> (StatsScreen.kt:238)");
            }
            String StatsScreen$lambda$13 = StatsScreen$lambda$13(mutableState);
            if (StatsScreen$lambda$13 == null) {
                StatsScreen$lambda$13 = "";
            }
            ComposerKt.sourceInformationMarkerStart(composer, -360521220, "CC(remember):StatsScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda39
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit StatsScreen$lambda$33$0$1$0$0;
                        StatsScreen$lambda$33$0$1$0$0 = StatsScreenKt.StatsScreen$lambda$33$0$1$0$0(MutableState.this);
                        return StatsScreen$lambda$33$0$1$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            LoadFailure(StatsScreen$lambda$13, (Function0) rememberedValue, composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatsScreen$lambda$33$0$1$0$0(MutableState mutableState) {
        StatsScreen$lambda$17(mutableState, StatsScreen$lambda$16(mutableState) + 1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatsScreen$lambda$33$0$2(MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C241@10237L86:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(82414600, i, -1, "uz.FonRo.pos.ui.stats.StatsScreen.<anonymous>.<anonymous>.<anonymous> (StatsScreen.kt:241)");
            }
            BasicsKt.OxEmptyNote(StatsScreen$lambda$10(mutableState) ? LangKt.tx("Загружаем статистику…", new Object[0]) : LangKt.tx("Данных за период нет.", new Object[0]), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatsScreen$lambda$33$0$3(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatsScreen$lambda$33$0$4(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatsScreen$lambda$34$0(MutableState mutableState) {
        StatsScreen$lambda$20(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatsScreen$lambda$35$0(PeriodState periodState, MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StatsScreen$lambda$20(mutableState, false);
        StatsPeriod.INSTANCE.setState(PeriodState.copy$default(periodState, PeriodKind.MONTH, it, null, 4, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatsScreen$lambda$36$0(MutableState mutableState) {
        StatsScreen$lambda$23(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StatsScreen$lambda$37$0(PeriodState periodState, MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        StatsScreen$lambda$23(mutableState, false);
        StatsPeriod.INSTANCE.setState(PeriodState.copy$default(periodState, PeriodKind.DATE, null, it, 2, null));
        return Unit.INSTANCE;
    }

    private static final void LoadFailure(final String str, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1658482163);
        ComposerKt.sourceInformation(startRestartGroup, "C(LoadFailure)283@11494L177,283@11440L231:StatsScreen.kt#fklwc3");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1658482163, i2, -1, "uz.FonRo.pos.ui.stats.LoadFailure (StatsScreen.kt:282)");
            }
            BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(14.0f), OxShape.INSTANCE.getCardSoft(), 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1856306733, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StatsScreenKt.LoadFailure$lambda$0(str, function0, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, 1572912, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatsScreenKt.LoadFailure$lambda$1(str, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LoadFailure$lambda$0(String str, Function0 function0, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C284@11504L58,285@11571L11,286@11591L74:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1856306733, i, -1, "uz.FonRo.pos.ui.stats.LoadFailure.<anonymous> (StatsScreen.kt:284)");
            }
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10196getDanger0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            BasicsKt.OxButton(LangKt.tx("Повторить", new Object[0]), function0, null, BtnStyle.PRIMARY, null, false, true, null, composer, 1575936, 180);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final String hourKey(String str) {
        if (str == null) {
            str = "";
        }
        return StringsKt.take(StringsKt.drop(str, 11), 2) + ":00";
    }

    private static final String dayLabel(String str) {
        return StringsKt.take(StringsKt.drop(str, 8), 2) + "." + StringsKt.take(StringsKt.drop(str, 5), 2);
    }

    private static final List<Bucket> buildBuckets(StoreStats storeStats, List<Receipt> list, SyncData syncData, boolean z, PeriodState periodState) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (z) {
            for (Receipt receipt : list) {
                Bucket buildBuckets$bucket$default = buildBuckets$bucket$default(linkedHashMap, hourKey(receipt.getSoldAt()), null, 4, null);
                buildBuckets$bucket$default.setSale(buildBuckets$bucket$default.getSale() + receipt.getTotal());
                buildBuckets$bucket$default.setProfit(buildBuckets$bucket$default.getProfit() + receipt.getProfit());
            }
            List<ReturnDoc> returns = syncData != null ? syncData.getReturns() : null;
            if (returns == null) {
                returns = CollectionsKt.emptyList();
            }
            for (ReturnDoc returnDoc : returns) {
                if (periodState.contains(returnDoc.getCreatedAt())) {
                    Bucket buildBuckets$bucket$default2 = buildBuckets$bucket$default(linkedHashMap, hourKey(returnDoc.getCreatedAt()), null, 4, null);
                    buildBuckets$bucket$default2.setRet(buildBuckets$bucket$default2.getRet() + returnDoc.getAmount());
                    buildBuckets$bucket$default2.setSale(buildBuckets$bucket$default2.getSale() - returnDoc.getAmount());
                    buildBuckets$bucket$default2.setProfit(buildBuckets$bucket$default2.getProfit() - returnDoc.getProfit());
                }
            }
        } else {
            for (StatsDay statsDay : storeStats.getDays()) {
                String date = statsDay.getDate();
                Bucket buildBuckets$bucket = buildBuckets$bucket(linkedHashMap, dayLabel(date), StringsKt.take(date, 10));
                buildBuckets$bucket.setSale(buildBuckets$bucket.getSale() + statsDay.getRevenue());
                buildBuckets$bucket.setProfit(buildBuckets$bucket.getProfit() + statsDay.getProfit());
            }
            for (StatsReturnDay statsReturnDay : storeStats.getReturnDays()) {
                String date2 = statsReturnDay.getDate();
                Bucket buildBuckets$bucket2 = buildBuckets$bucket(linkedHashMap, dayLabel(date2), StringsKt.take(date2, 10));
                buildBuckets$bucket2.setSale(buildBuckets$bucket2.getSale() - statsReturnDay.getAmount());
                buildBuckets$bucket2.setProfit(buildBuckets$bucket2.getProfit() - statsReturnDay.getProfit());
                buildBuckets$bucket2.setRet(buildBuckets$bucket2.getRet() + statsReturnDay.getAmount());
            }
            for (StatsAmount statsAmount : storeStats.getExpenseDays()) {
                String date3 = statsAmount.getDate();
                Bucket buildBuckets$bucket3 = buildBuckets$bucket(linkedHashMap, dayLabel(date3), StringsKt.take(date3, 10));
                buildBuckets$bucket3.setExpense(buildBuckets$bucket3.getExpense() + statsAmount.getValue());
            }
        }
        Collection values = linkedHashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        return CollectionsKt.sortedWith(values, new Comparator() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$buildBuckets$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((Bucket) t).getSortKey(), ((Bucket) t2).getSortKey());
            }
        });
    }

    static /* synthetic */ Bucket buildBuckets$bucket$default(LinkedHashMap linkedHashMap, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = str;
        }
        return buildBuckets$bucket(linkedHashMap, str, str2);
    }

    private static final Bucket buildBuckets$bucket(LinkedHashMap<String, Bucket> linkedHashMap, String str, String str2) {
        LinkedHashMap<String, Bucket> linkedHashMap2 = linkedHashMap;
        Bucket bucket = linkedHashMap2.get(str);
        if (bucket == null) {
            bucket = new Bucket(str, str2);
            linkedHashMap2.put(str, bucket);
        }
        return bucket;
    }

    private static final StatsModel buildModel(StoreStats storeStats, List<SaleRow> list, SyncData syncData, List<Product> list2, double d, double d2, PeriodState periodState, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        double d3;
        Object m7870constructorimpl;
        int i;
        Receipts receipts = Receipts.INSTANCE;
        List<ReturnDoc> returns = syncData != null ? syncData.getReturns() : null;
        if (returns == null) {
            returns = CollectionsKt.emptyList();
        }
        List group$default = Receipts.group$default(receipts, list, returns, null, 4, null);
        double revenue = storeStats.getSales().getRevenue() - storeStats.getReturns().getAmount();
        double profit = storeStats.getSales().getProfit() - storeStats.getReturns().getProfit();
        double revenue2 = storeStats.getSales().getCount() > 0 ? storeStats.getSales().getRevenue() / storeStats.getSales().getCount() : AudioStats.AUDIO_AMPLITUDE_NONE;
        List<DebtPayment> debtPayments = syncData != null ? syncData.getDebtPayments() : null;
        if (debtPayments == null) {
            debtPayments = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : debtPayments) {
            if (periodState.contains(((DebtPayment) obj).getCreatedAt())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        List list3 = group$default;
        Iterator it = list3.iterator();
        double d4 = AudioStats.AUDIO_AMPLITUDE_NONE;
        while (it.hasNext()) {
            d4 += ((Receipt) it.next()).getPaidAmount();
        }
        Iterator it2 = list3.iterator();
        double d5 = AudioStats.AUDIO_AMPLITUDE_NONE;
        while (it2.hasNext()) {
            d5 += ((Receipt) it2.next()).getDebtAmount();
        }
        Iterator it3 = list3.iterator();
        double d6 = AudioStats.AUDIO_AMPLITUDE_NONE;
        while (it3.hasNext()) {
            d6 += ((Receipt) it3.next()).getDiscountAmount();
        }
        Iterator it4 = list3.iterator();
        double d7 = AudioStats.AUDIO_AMPLITUDE_NONE;
        while (it4.hasNext()) {
            d7 += ((Receipt) it4.next()).getCashAmount();
        }
        ArrayList arrayList3 = arrayList2;
        Iterator it5 = arrayList3.iterator();
        double d8 = AudioStats.AUDIO_AMPLITUDE_NONE;
        while (it5.hasNext()) {
            d8 += ((DebtPayment) it5.next()).getCashAmount();
        }
        double d9 = d7 + d8;
        Iterator it6 = list3.iterator();
        double d10 = AudioStats.AUDIO_AMPLITUDE_NONE;
        while (it6.hasNext()) {
            d10 += ((Receipt) it6.next()).getCardAmount();
        }
        Iterator it7 = arrayList3.iterator();
        double d11 = AudioStats.AUDIO_AMPLITUDE_NONE;
        while (it7.hasNext()) {
            d11 += ((DebtPayment) it7.next()).getCardAmount();
        }
        double d12 = d10 + d11;
        if (Num.INSTANCE.isZero(storeStats.getDebtReceived().getValue())) {
            Iterator it8 = arrayList3.iterator();
            double d13 = AudioStats.AUDIO_AMPLITUDE_NONE;
            while (it8.hasNext()) {
                d13 += ((DebtPayment) it8.next()).getAmount();
            }
            d3 = d13;
        } else {
            d3 = storeStats.getDebtReceived().getValue();
        }
        double value = storeStats.getExpenses().getValue();
        List createListBuilder = CollectionsKt.createListBuilder();
        int i2 = 0;
        createListBuilder.add(new SummaryRow(LangKt.tx("Продажа", new Object[0]), revenue, CSale, null));
        createListBuilder.add(new SummaryRow(LangKt.tx("Скидка", new Object[0]), d6, CDiscount, null));
        if (z2) {
            createListBuilder.add(new SummaryRow(LangKt.tx("Прибыль", new Object[0]), profit, CProfit, null));
        }
        if (z3) {
            createListBuilder.add(new SummaryRow(LangKt.tx("Наличные", new Object[0]), d9, CCash, null));
        }
        if (z4) {
            createListBuilder.add(new SummaryRow(LangKt.tx("Карта", new Object[0]), d12, CCard, null));
        }
        createListBuilder.add(new SummaryRow(LangKt.tx("Оплачено", new Object[0]), d4, CPaid, null));
        createListBuilder.add(new SummaryRow(LangKt.tx("Получено долгов", new Object[0]), d3, CDebtIn, null));
        String tx = LangKt.tx("Долг", new Object[0]);
        long j = CAmber;
        createListBuilder.add(new SummaryRow(tx, d5, j, null));
        createListBuilder.add(new SummaryRow(LangKt.tx("Возврат", new Object[0]), storeStats.getReturns().getAmount(), CReturn, null));
        createListBuilder.add(new SummaryRow(LangKt.tx("Расходы", new Object[0]), value, CExpense, null));
        if (z2) {
            createListBuilder.add(new SummaryRow(LangKt.tx("Прибыль после расходов", new Object[0]), profit - value, j, null));
        }
        List build = CollectionsKt.build(createListBuilder);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : list3) {
            if (((Receipt) obj2).getDebtAmount() > 0.001d) {
                arrayList4.add(obj2);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj3 : arrayList4) {
            String customerName = ((Receipt) obj3).getCustomerName();
            if (StringsKt.isBlank(customerName)) {
                customerName = LangKt.tx("Без клиента", new Object[0]);
            }
            String str = customerName;
            Object obj4 = linkedHashMap.get(str);
            if (obj4 == null) {
                obj4 = (List) new ArrayList();
                linkedHashMap.put(str, obj4);
            }
            ((List) obj4).add(obj3);
        }
        ArrayList arrayList5 = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            Iterator it9 = ((List) entry.getValue()).iterator();
            double d14 = 0.0d;
            while (it9.hasNext()) {
                d14 += ((Receipt) it9.next()).getDebtAmount();
            }
            arrayList5.add(TuplesKt.to(str2, Double.valueOf(d14)));
        }
        List take = CollectionsKt.take(CollectionsKt.sortedWith(arrayList5, new Comparator() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$buildModel$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((Double) ((Pair) t2).getSecond(), (Double) ((Pair) t).getSecond());
            }
        }), 6);
        List<AuditDoc> inventoryAudits = syncData != null ? syncData.getInventoryAudits() : null;
        if (inventoryAudits == null) {
            inventoryAudits = CollectionsKt.emptyList();
        }
        ArrayList arrayList6 = new ArrayList();
        for (Object obj5 : inventoryAudits) {
            if (periodState.contains(((AuditDoc) obj5).getCreatedAt())) {
                arrayList6.add(obj5);
            }
        }
        ArrayList arrayList7 = new ArrayList();
        Iterator it10 = arrayList6.iterator();
        while (it10.hasNext()) {
            CollectionsKt.addAll(arrayList7, ((AuditDoc) it10.next()).getItems());
        }
        Iterator it11 = arrayList7.iterator();
        double d15 = 0.0d;
        while (it11.hasNext()) {
            d15 += ((AuditItem) it11.next()).getDiff();
        }
        Pair<String, String> range = periodState.range();
        String component1 = range.component1();
        String component2 = range.component2();
        try {
            Result.Companion companion = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(Integer.valueOf(((int) ChronoUnit.DAYS.between(LocalDate.parse(component1), LocalDate.parse(component2))) + 1));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7876isFailureimpl(m7870constructorimpl)) {
            m7870constructorimpl = 1;
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(((Number) m7870constructorimpl).intValue(), 1);
        List<Bucket> buildBuckets = buildBuckets(storeStats, group$default, syncData, z, periodState);
        Iterator it12 = list3.iterator();
        double d16 = 0.0d;
        while (it12.hasNext()) {
            d16 += ((Receipt) it12.next()).getQty();
        }
        List<Product> list4 = list2;
        boolean z6 = list4 instanceof Collection;
        if (z6 && list4.isEmpty()) {
            i = 0;
        } else {
            int i3 = 0;
            for (Product product : list4) {
                if (product.getQuantity() > AudioStats.AUDIO_AMPLITUDE_NONE && product.getQuantity() <= d2 && (i3 = i3 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
            i = i3;
        }
        if (!z6 || !list4.isEmpty()) {
            Iterator<T> it13 = list4.iterator();
            while (it13.hasNext()) {
                if (((Product) it13.next()).getQuantity() <= AudioStats.AUDIO_AMPLITUDE_NONE && (i2 = i2 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        int i4 = i2;
        StatsInventory inventory = storeStats.getInventory();
        return new StatsModel(storeStats, buildBuckets, build, take, d16, i, i4, d, z5 ? inventory.getStockPurchase() : inventory.getStockSale(), z5, d15, revenue, profit, revenue2, coerceAtLeast);
    }

    private static final void statsSections(LazyListScope lazyListScope, final StatsModel statsModel, final String str, final String str2, final boolean z, final boolean z2, final String str3, final Function1<? super String, Unit> function1, final String str4, final Function1<? super String, Unit> function12) {
        final StoreStats stats = statsModel.getStats();
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(795163610, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StatsScreenKt.statsSections$lambda$0(StatsModel.this, str, str2, z2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(lazyListScope, null, null, ComposableSingletons$StatsScreenKt.INSTANCE.m10156getLambda$2016974397$app(), 3, null);
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(1884993954, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StatsScreenKt.statsSections$lambda$1(StatsModel.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(1491995009, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StatsScreenKt.statsSections$lambda$2(StatsModel.this, str2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(1098996064, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StatsScreenKt.statsSections$lambda$3(str2, statsModel, z2, z, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(705997119, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StatsScreenKt.statsSections$lambda$4(str2, z, statsModel, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        if (z2) {
            LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(1900034847, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StatsScreenKt.statsSections$lambda$5(str2, z, statsModel, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(312998174, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StatsScreenKt.statsSections$lambda$6(str2, z, statsModel, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-80000771, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StatsScreenKt.statsSections$lambda$7(str2, statsModel, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-472999716, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StatsScreenKt.statsSections$lambda$8(StoreStats.this, str2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-865998661, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StatsScreenKt.statsSections$lambda$9(StoreStats.this, str2, z2, str3, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(1236544577, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StatsScreenKt.statsSections$lambda$10(StoreStats.this, str2, z2, str4, function12, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit statsSections$lambda$0(StatsModel statsModel, String str, String str2, boolean z, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C507@19961L77:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(795163610, i, -1, "uz.FonRo.pos.ui.stats.statsSections.<anonymous> (StatsScreen.kt:507)");
            }
            HeroCard(statsModel, str, str2, z, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(14.0f), 7, null), composer, 24576, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit statsSections$lambda$1(StatsModel statsModel, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C521@20375L52:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1884993954, i, -1, "uz.FonRo.pos.ui.stats.statsSections.<anonymous> (StatsScreen.kt:521)");
            }
            SummaryGrid(statsModel, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(14.0f), 7, null), composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit statsSections$lambda$2(final StatsModel statsModel, String str, LazyItemScope item, Composer composer, int i) {
        Double valueOf;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C528@20774L129,528@20698L205:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1491995009, i, -1, "uz.FonRo.pos.ui.stats.statsSections.<anonymous> (StatsScreen.kt:527)");
            }
            Iterator<T> it = statsModel.getSummary().iterator();
            if (it.hasNext()) {
                double abs = Math.abs(((SummaryRow) it.next()).getValue());
                while (it.hasNext()) {
                    abs = Math.max(abs, Math.abs(((SummaryRow) it.next()).getValue()));
                }
                valueOf = Double.valueOf(abs);
            } else {
                valueOf = null;
            }
            final double coerceAtLeast = valueOf != null ? RangesKt.coerceAtLeast(valueOf.doubleValue(), 1.0d) : 1.0d;
            PdCard(LangKt.tx("Сводка %s", str), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null), null, ComposableLambdaKt.rememberComposableLambda(158604093, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit statsSections$lambda$2$1;
                    statsSections$lambda$2$1 = StatsScreenKt.statsSections$lambda$2$1(StatsModel.this, coerceAtLeast, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return statsSections$lambda$2$1;
                }
            }, composer, 54), composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit statsSections$lambda$2$1(StatsModel statsModel, double d, ColumnScope PdCard, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(PdCard, "$this$PdCard");
        ComposerKt.sourceInformation(composer2, "C*530@20835L44:StatsScreen.kt#fklwc3");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(158604093, i, -1, "uz.FonRo.pos.ui.stats.statsSections.<anonymous>.<anonymous> (StatsScreen.kt:529)");
            }
            for (SummaryRow summaryRow : statsModel.getSummary()) {
                ChartsKt.m10153OxHBarfWhpE4E(summaryRow.getLabel(), summaryRow.getValue(), d, summaryRow.getColor(), null, null, composer2, 0, 48);
                composer2 = composer;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit statsSections$lambda$3(String str, final StatsModel statsModel, final boolean z, final boolean z2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C536@21008L952,536@20930L1030:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1098996064, i, -1, "uz.FonRo.pos.ui.stats.statsSections.<anonymous> (StatsScreen.kt:536)");
            }
            PdCard(LangKt.tx("Динамика %s", str), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null), null, ComposableLambdaKt.rememberComposableLambda(-234394852, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit statsSections$lambda$3$0;
                    statsSections$lambda$3$0 = StatsScreenKt.statsSections$lambda$3$0(StatsModel.this, z, z2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return statsSections$lambda$3$0;
                }
            }, composer, 54), composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit statsSections$lambda$3$0(StatsModel statsModel, final boolean z, final boolean z2, ColumnScope PdCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(PdCard, "$this$PdCard");
        ComposerKt.sourceInformation(composer, "C537@21032L493,537@21022L503,546@21538L412:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-234394852, i, -1, "uz.FonRo.pos.ui.stats.statsSections.<anonymous>.<anonymous> (StatsScreen.kt:537)");
            }
            ChipsKt.OxChipRow(null, ComposableLambdaKt.rememberComposableLambda(14735723, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit statsSections$lambda$3$0$0;
                    statsSections$lambda$3$0$0 = StatsScreenKt.statsSections$lambda$3$0$0(z, z2, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return statsSections$lambda$3$0$0;
                }
            }, composer, 54), composer, 48, 1);
            List<Bucket> buckets = statsModel.getBuckets();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(buckets, 10));
            for (Bucket bucket : buckets) {
                String key = bucket.getKey();
                ChartBar[] chartBarArr = new ChartBar[4];
                chartBarArr[0] = new ChartBar(bucket.getSale(), CSale, null);
                chartBarArr[1] = z ? new ChartBar(bucket.getProfit(), CProfit, null) : null;
                chartBarArr[2] = !z2 ? new ChartBar(bucket.getExpense(), CExpenseBar, null) : null;
                chartBarArr[3] = new ChartBar(bucket.getRet(), CReturn, null);
                arrayList.add(TuplesKt.to(key, CollectionsKt.listOfNotNull((Object[]) chartBarArr)));
            }
            ChartsKt.OxGroupedVChart(arrayList, null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit statsSections$lambda$3$0$0(boolean z, boolean z2, RowScope OxChipRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxChipRow, "$this$OxChipRow");
        ComposerKt.sourceInformation(composer, "C538@21050L34,544@21474L37:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(14735723, i, -1, "uz.FonRo.pos.ui.stats.statsSections.<anonymous>.<anonymous>.<anonymous> (StatsScreen.kt:538)");
            }
            ChartsKt.m10154OxLegendChip3IgeMak(LangKt.tx("Продажа", new Object[0]), CSale, null, composer, 48, 4);
            if (z) {
                composer.startReplaceGroup(1276130639);
                ComposerKt.sourceInformation(composer, "539@21116L36");
                ChartsKt.m10154OxLegendChip3IgeMak(LangKt.tx("Прибыль", new Object[0]), CProfit, null, composer, 48, 4);
            } else {
                composer.startReplaceGroup(905378743);
            }
            composer.endReplaceGroup();
            if (z2) {
                composer.startReplaceGroup(905681303);
            } else {
                composer.startReplaceGroup(1276140275);
                ComposerKt.sourceInformation(composer, "543@21417L40");
                ChartsKt.m10154OxLegendChip3IgeMak(LangKt.tx("Расходы", new Object[0]), CExpenseBar, null, composer, 48, 4);
            }
            composer.endReplaceGroup();
            ChartsKt.m10154OxLegendChip3IgeMak(LangKt.tx("Возвраты", new Object[0]), CReturn, null, composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit statsSections$lambda$4(String str, boolean z, StatsModel statsModel, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C564@22192L11,560@21987L359:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(705997119, i, -1, "uz.FonRo.pos.ui.stats.statsSections.<anonymous> (StatsScreen.kt:560)");
            }
            String tx = LangKt.tx("График продаж %s", str);
            String tx2 = z ? LangKt.tx("Продажи по часам", new Object[0]) : LangKt.tx("Продажи по дням", new Object[0]);
            List<Bucket> buckets = statsModel.getBuckets();
            ComposerKt.sourceInformationMarkerStart(composer, -141594518, "CC(remember):StatsScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        double statsSections$lambda$4$0$0;
                        statsSections$lambda$4$0$0 = StatsScreenKt.statsSections$lambda$4$0$0((Bucket) obj);
                        return Double.valueOf(statsSections$lambda$4$0$0);
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m10161ChartCardcd68TDI(tx, tx2, buckets, (Function1) rememberedValue, SalesBrush, Ox.INSTANCE.m10201getGreen0d7_KjU(), z, statsModel.getPeriodDays(), composer, 27648);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double statsSections$lambda$4$0$0(Bucket it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getSale();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit statsSections$lambda$5(String str, boolean z, StatsModel statsModel, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C578@22624L13,574@22402L401:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1900034847, i, -1, "uz.FonRo.pos.ui.stats.statsSections.<anonymous> (StatsScreen.kt:574)");
            }
            String tx = LangKt.tx("График прибыли %s", str);
            String tx2 = z ? LangKt.tx("Прибыль по часам", new Object[0]) : LangKt.tx("Прибыль по дням", new Object[0]);
            List<Bucket> buckets = statsModel.getBuckets();
            ComposerKt.sourceInformationMarkerStart(composer, 572394732, "CC(remember):StatsScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        double statsSections$lambda$5$0$0;
                        statsSections$lambda$5$0$0 = StatsScreenKt.statsSections$lambda$5$0$0((Bucket) obj);
                        return Double.valueOf(statsSections$lambda$5$0$0);
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m10161ChartCardcd68TDI(tx, tx2, buckets, (Function1) rememberedValue, getProfitBrush(), Ox.INSTANCE.m10220getPrimary0d7_KjU(), z, statsModel.getPeriodDays(), composer, 3072);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double statsSections$lambda$5$0$0(Bucket it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getProfit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit statsSections$lambda$6(String str, boolean z, StatsModel statsModel, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C592@23050L10,588@22840L365:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(312998174, i, -1, "uz.FonRo.pos.ui.stats.statsSections.<anonymous> (StatsScreen.kt:588)");
            }
            String tx = LangKt.tx("График возвратов %s", str);
            String tx2 = z ? LangKt.tx("Возвраты по часам", new Object[0]) : LangKt.tx("Возвраты по дням", new Object[0]);
            List<Bucket> buckets = statsModel.getBuckets();
            ComposerKt.sourceInformationMarkerStart(composer, 143541544, "CC(remember):StatsScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        double statsSections$lambda$6$0$0;
                        statsSections$lambda$6$0$0 = StatsScreenKt.statsSections$lambda$6$0$0((Bucket) obj);
                        return Double.valueOf(statsSections$lambda$6$0$0);
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m10161ChartCardcd68TDI(tx, tx2, buckets, (Function1) rememberedValue, ReturnBrush, Ox.INSTANCE.m10213getOrange0d7_KjU(), z, statsModel.getPeriodDays(), composer, 27648);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double statsSections$lambda$6$0$0(Bucket it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getRet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit statsSections$lambda$7(String str, final StatsModel statsModel, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C605@23410L363,601@23232L541:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-80000771, i, -1, "uz.FonRo.pos.ui.stats.statsSections.<anonymous> (StatsScreen.kt:601)");
            }
            PdCard(LangKt.tx("График долгов %s", str), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null), LangKt.tx("Клиенты с самым большим долгом", new Object[0]), ComposableLambdaKt.rememberComposableLambda(-1413391687, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit statsSections$lambda$7$0;
                    statsSections$lambda$7$0 = StatsScreenKt.statsSections$lambda$7$0(StatsModel.this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return statsSections$lambda$7$0;
                }
            }, composer, 54), composer, 3120, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit statsSections$lambda$7$0(StatsModel statsModel, ColumnScope PdCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(PdCard, "$this$PdCard");
        ComposerKt.sourceInformation(composer, "C:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1413391687, i, -1, "uz.FonRo.pos.ui.stats.statsSections.<anonymous>.<anonymous> (StatsScreen.kt:606)");
            }
            if (statsModel.getDebtors().isEmpty()) {
                composer.startReplaceGroup(1507667705);
                ComposerKt.sourceInformation(composer, "607@23471L48");
                ChartsKt.ChartNote(LangKt.tx("Нет долгов за выбранный период.", new Object[0]), null, composer, 0, 2);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1507757481);
                ComposerKt.sourceInformation(composer, "*611@23698L33");
                Iterator<T> it = statsModel.getDebtors().iterator();
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
                double doubleValue = ((Number) ((Pair) it.next()).getSecond()).doubleValue();
                while (it.hasNext()) {
                    doubleValue = Math.max(doubleValue, ((Number) ((Pair) it.next()).getSecond()).doubleValue());
                }
                double coerceAtLeast = RangesKt.coerceAtLeast(doubleValue, 1.0d);
                Iterator<T> it2 = statsModel.getDebtors().iterator();
                while (it2.hasNext()) {
                    Pair pair = (Pair) it2.next();
                    ChartsKt.m10153OxHBarfWhpE4E((String) pair.component1(), ((Number) pair.component2()).doubleValue(), coerceAtLeast, CAmber, null, null, composer, 3072, 48);
                }
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit statsSections$lambda$8(StoreStats storeStats, String str, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C619@23947L366,619@23868L445:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-472999716, i, -1, "uz.FonRo.pos.ui.stats.statsSections.<anonymous> (StatsScreen.kt:618)");
            }
            List<StatsCategory> categories = storeStats.getCategories();
            ArrayList arrayList = new ArrayList();
            for (Object obj : categories) {
                if (((StatsCategory) obj).getRevenue() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    arrayList.add(obj);
                }
            }
            final ArrayList arrayList2 = arrayList;
            PdCard(LangKt.tx("Категории %s", str), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null), null, ComposableLambdaKt.rememberComposableLambda(-1806390632, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    Unit statsSections$lambda$8$1;
                    statsSections$lambda$8$1 = StatsScreenKt.statsSections$lambda$8$1(arrayList2, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return statsSections$lambda$8$1;
                }
            }, composer, 54), composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit statsSections$lambda$8$1(List list, ColumnScope PdCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(PdCard, "$this$PdCard");
        ComposerKt.sourceInformation(composer, "C:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1806390632, i, -1, "uz.FonRo.pos.ui.stats.statsSections.<anonymous>.<anonymous> (StatsScreen.kt:620)");
            }
            if (list.isEmpty()) {
                composer.startReplaceGroup(1756942820);
                ComposerKt.sourceInformation(composer, "621@24005L38");
                ChartsKt.ChartNote(LangKt.tx("Продаж за период нет.", new Object[0]), null, composer, 0, 2);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1757023482);
                ComposerKt.sourceInformation(composer, "*625@24204L67");
                List<StatsCategory> list2 = list;
                Iterator it = list2.iterator();
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
                double revenue = ((StatsCategory) it.next()).getRevenue();
                while (it.hasNext()) {
                    revenue = Math.max(revenue, ((StatsCategory) it.next()).getRevenue());
                }
                double coerceAtLeast = RangesKt.coerceAtLeast(revenue, 1.0d);
                for (StatsCategory statsCategory : list2) {
                    String name = statsCategory.getName();
                    double revenue2 = statsCategory.getRevenue();
                    Color parseHexColor = CatalogScreenKt.parseHexColor(statsCategory.getColor());
                    ChartsKt.m10153OxHBarfWhpE4E(name, revenue2, coerceAtLeast, parseHexColor != null ? parseHexColor.m4394unboximpl() : CCategory, null, null, composer, 0, 48);
                }
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit statsSections$lambda$9(StoreStats storeStats, String str, boolean z, String str2, Function1 function1, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C632@24340L72:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-865998661, i, -1, "uz.FonRo.pos.ui.stats.statsSections.<anonymous> (StatsScreen.kt:632)");
            }
            EmployeesCard(storeStats.getEmployees(), str, z, str2, function1, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit statsSections$lambda$10(StoreStats storeStats, String str, boolean z, String str2, Function1 function1, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C636@24439L76:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1236544577, i, -1, "uz.FonRo.pos.ui.stats.statsSections.<anonymous> (StatsScreen.kt:636)");
            }
            TopProductsCard(storeStats.getTopProducts(), str, z, str2, function1, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void PdCard(final java.lang.String r18, androidx.compose.ui.Modifier r19, java.lang.String r20, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.stats.StatsScreenKt.PdCard(java.lang.String, androidx.compose.ui.Modifier, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PdCard$lambda$0(String str, String str2, Function3 function3, ColumnScope OxSoftCard, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C651@24899L181,661@25205L44,662@25258L9:StatsScreen.kt#fklwc3");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxSoftCard) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1943313163, i2, -1, "uz.FonRo.pos.ui.stats.PdCard.<anonymous> (StatsScreen.kt:651)");
            }
            int i3 = i2;
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), 0L, TextUnitKt.getSp(17), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, TextUnitKt.getSp(-0.3d), null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777081, null), composer, 0, 0, 65534);
            Composer composer2 = composer;
            if (str2 != null) {
                composer2.startReplaceGroup(1378479010);
                ComposerKt.sourceInformation(composer2, "658@25125L10,659@25148L38");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer2, 6);
                TextKt.m2798Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer2, 0, 0, 65534);
                composer2 = composer2;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(1378560695);
                composer2.endReplaceGroup();
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(str2 != null ? 10.0f : 12.0f), composer2, 0);
            function3.invoke(OxSoftCard, composer2, Integer.valueOf(i3 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x006e  */
    /* renamed from: MiniStat-cf5BqRc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m10162MiniStatcf5BqRc(final java.lang.String r39, final java.lang.String r40, final long r41, androidx.compose.ui.Modifier r43, androidx.compose.runtime.Composer r44, final int r45, final int r46) {
        /*
            Method dump skipped, instructions count: 582
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.stats.StatsScreenKt.m10162MiniStatcf5BqRc(java.lang.String, java.lang.String, long, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0661  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0657  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void HeroCard(final uz.FonRo.pos.ui.stats.StatsModel r99, final java.lang.String r100, final java.lang.String r101, final boolean r102, androidx.compose.ui.Modifier r103, androidx.compose.runtime.Composer r104, final int r105, final int r106) {
        /*
            Method dump skipped, instructions count: 1648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.stats.StatsScreenKt.HeroCard(uz.FonRo.pos.ui.stats.StatsModel, java.lang.String, java.lang.String, boolean, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void SummaryGrid(final uz.FonRo.pos.ui.stats.StatsModel r26, androidx.compose.ui.Modifier r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instructions count: 1154
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.stats.StatsScreenKt.SummaryGrid(uz.FonRo.pos.ui.stats.StatsModel, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void SummaryTileView(final uz.FonRo.pos.ui.stats.SummaryTile r63, androidx.compose.ui.Modifier r64, androidx.compose.runtime.Composer r65, final int r66, final int r67) {
        /*
            Method dump skipped, instructions count: 1161
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.stats.StatsScreenKt.SummaryTileView(uz.FonRo.pos.ui.stats.SummaryTile, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: ChartCard-cd68TDI, reason: not valid java name */
    private static final void m10161ChartCardcd68TDI(final String str, final String str2, final List<Bucket> list, final Function1<? super Bucket, Double> function1, final Brush brush, final long j, final boolean z, final int i, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(305259227);
        ComposerKt.sourceInformation(startRestartGroup, "C(ChartCard)P(6,4,1,7!1,5:c#ui.graphics.Color)862@32548L531,862@32468L611:StatsScreen.kt#fklwc3");
        int i6 = (i2 & 6) == 0 ? (startRestartGroup.changed(str) ? 4 : 2) | i2 : i2;
        if ((i2 & 48) == 0) {
            i6 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i6 |= (i2 & 512) == 0 ? startRestartGroup.changed(list) : startRestartGroup.changedInstance(list) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i6 |= startRestartGroup.changed(brush) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i6 |= startRestartGroup.changed(j) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i6 |= startRestartGroup.changed(z) ? 1048576 : 524288;
        }
        if ((12582912 & i2) == 0) {
            i3 = i;
            i6 |= startRestartGroup.changed(i3) ? 8388608 : 4194304;
        } else {
            i3 = i;
        }
        if (!startRestartGroup.shouldExecute((4793491 & i6) != 4793490, i6 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(305259227, i6, -1, "uz.FonRo.pos.ui.stats.ChartCard (StatsScreen.kt:851)");
            }
            List<Bucket> list2 = list;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list2) {
                List<Bucket> list3 = list2;
                if (Math.abs(function1.invoke((Bucket) obj).doubleValue()) > 0.001d) {
                    arrayList.add(obj);
                }
                list2 = list3;
            }
            final ArrayList arrayList2 = arrayList;
            double d = AudioStats.AUDIO_AMPLITUDE_NONE;
            for (Iterator it = list2.iterator(); it.hasNext(); it = it) {
                d += function1.invoke((Bucket) it.next()).doubleValue();
            }
            if (z) {
                i4 = i6;
                i5 = Math.max(1, arrayList2.size());
            } else {
                i4 = i6;
                i5 = i3;
            }
            final double d2 = d / i5;
            final double d3 = d;
            composer2 = startRestartGroup;
            PdCard(str, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null), str2, ComposableLambdaKt.rememberComposableLambda(352863639, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return StatsScreenKt.ChartCard_cd68TDI$lambda$2(arrayList2, list, brush, d3, j, d2, function1, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, startRestartGroup, 54), composer2, (i4 & 14) | 3120 | ((i4 << 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda33
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return StatsScreenKt.ChartCard_cd68TDI$lambda$3(str, str2, list, function1, brush, j, z, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ChartCard_cd68TDI$lambda$2(List list, List list2, Brush brush, double d, long j, double d2, Function1 function1, ColumnScope PdCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(PdCard, "$this$PdCard");
        ComposerKt.sourceInformation(composer, "C863@32558L242,867@32809L11,870@32980L93:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(352863639, i, -1, "uz.FonRo.pos.ui.stats.ChartCard.<anonymous> (StatsScreen.kt:863)");
            }
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(7.0f));
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
            ComposerKt.sourceInformationMarkerStart(composer, 1203459918, "C864@32628L63,865@32704L86:StatsScreen.kt#fklwc3");
            m10162MiniStatcf5BqRc(Fmt.INSTANCE.nf(Double.valueOf(d)), LangKt.tx("Итого", new Object[0]), j, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0, 0);
            m10162MiniStatcf5BqRc(Fmt.INSTANCE.nf(Double.valueOf(Math.rint(d2 * 100.0d) / 100.0d)), LangKt.tx("Среднее", new Object[0]), TintCyan, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 384, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            List<Bucket> list3 = !list.isEmpty() ? list : list2;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (Bucket bucket : list3) {
                arrayList.add(TuplesKt.to(bucket.getKey(), function1.invoke(bucket)));
            }
            ChartsKt.OxVChart(arrayList, brush, null, null, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void EmployeesCard(final List<StatsEmployee> list, final String str, final boolean z, final String str2, final Function1<? super String, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(377325684);
        ComposerKt.sourceInformation(startRestartGroup, "C(EmployeesCard)P(1,4)888@33494L1689,884@33344L1839:StatsScreen.kt#fklwc3");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(list) : startRestartGroup.changedInstance(list) ? 4 : 2) | i;
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
            i2 |= startRestartGroup.changed(str2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if (!startRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(377325684, i2, -1, "uz.FonRo.pos.ui.stats.EmployeesCard (StatsScreen.kt:883)");
            }
            PdCard(LangKt.tx("Сотрудники", new Object[0]), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null), LangKt.tx("Кто сколько продал за %s", str), ComposableLambdaKt.rememberComposableLambda(-1683675856, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StatsScreenKt.EmployeesCard$lambda$0(list, z, str2, function1, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, 3120, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatsScreenKt.EmployeesCard$lambda$1(list, str, z, str2, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit EmployeesCard$lambda$0(List list, boolean z, final String str, Function1 function1, ColumnScope PdCard, Composer composer, int i) {
        final boolean z2;
        final boolean z3;
        Intrinsics.checkNotNullParameter(PdCard, "$this$PdCard");
        ComposerKt.sourceInformation(composer, "C900@33958L250,900@33948L260,915@34559L39,916@34607L11,*925@35056L44:StatsScreen.kt#fklwc3");
        int i2 = 0;
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1683675856, i, -1, "uz.FonRo.pos.ui.stats.EmployeesCard.<anonymous> (StatsScreen.kt:889)");
            }
            if (list.isEmpty()) {
                composer.startReplaceGroup(-1759305958);
                ComposerKt.sourceInformation(composer, "890@33543L38");
                ChartsKt.ChartNote(LangKt.tx("Продаж за период нет.", new Object[0]), null, composer, 0, 2);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
            composer.startReplaceGroup(-1759221390);
            composer.endReplaceGroup();
            List list2 = list;
            boolean z4 = list2 instanceof Collection;
            if (!z4 || !list2.isEmpty()) {
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    if (((StatsEmployee) it.next()).getCash() != null) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            if (!z4 || !list2.isEmpty()) {
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (((StatsEmployee) it2.next()).getCard() != null) {
                        z3 = true;
                        break;
                    }
                }
            }
            z3 = false;
            ChipsKt.OxChipRow(null, ComposableLambdaKt.rememberComposableLambda(1782992447, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit EmployeesCard$lambda$0$2;
                    EmployeesCard$lambda$0$2 = StatsScreenKt.EmployeesCard$lambda$0$2(z2, z3, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return EmployeesCard$lambda$0$2;
                }
            }, composer, 54), composer, 48, 1);
            Pair[] pairArr = new Pair[6];
            pairArr[0] = TuplesKt.to("revenue", LangKt.tx("Продажа", new Object[0]));
            pairArr[1] = z2 ? TuplesKt.to("cash", LangKt.tx("Наличные", new Object[0])) : null;
            pairArr[2] = z3 ? TuplesKt.to("card", LangKt.tx("Карта", new Object[0])) : null;
            pairArr[3] = TuplesKt.to("debt", LangKt.tx("В долг", new Object[0]));
            pairArr[4] = z ? TuplesKt.to("profit", LangKt.tx("Прибыль", new Object[0])) : null;
            pairArr[5] = TuplesKt.to("count", LangKt.tx("Чеков", new Object[0]));
            ChipsKt.OxSegControl(CollectionsKt.listOfNotNull((Object[]) pairArr), str, function1, null, false, composer, 0, 24);
            Composer composer2 = composer;
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer2, 6);
            List sortedWith = CollectionsKt.sortedWith(list2, new Comparator() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$EmployeesCard$lambda$0$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    double employeeMetric;
                    double employeeMetric2;
                    employeeMetric = StatsScreenKt.employeeMetric((StatsEmployee) t2, str);
                    Double valueOf = Double.valueOf(employeeMetric);
                    employeeMetric2 = StatsScreenKt.employeeMetric((StatsEmployee) t, str);
                    return ComparisonsKt.compareValues(valueOf, Double.valueOf(employeeMetric2));
                }
            });
            Iterator it3 = list2.iterator();
            if (!it3.hasNext()) {
                throw new NoSuchElementException();
            }
            double revenue = ((StatsEmployee) it3.next()).getRevenue();
            while (it3.hasNext()) {
                revenue = Math.max(revenue, ((StatsEmployee) it3.next()).getRevenue());
            }
            double coerceAtLeast = RangesKt.coerceAtLeast(revenue, 1.0d);
            for (Object obj : sortedWith) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Composer composer3 = composer2;
                EmployeeRow((StatsEmployee) obj, coerceAtLeast, z, composer3, StatsEmployee.$stable);
                double d = coerceAtLeast;
                composer2 = composer3;
                if (i2 < CollectionsKt.getLastIndex(sortedWith)) {
                    composer2.startReplaceGroup(1627126414);
                    ComposerKt.sourceInformation(composer2, "926@35143L24");
                    BasicsKt.m9830OxDivideriPRSM58(Ox.INSTANCE.m10227getRowDivider0d7_KjU(), 0.0f, composer2, 0, 2);
                } else {
                    composer2.startReplaceGroup(-1098665652);
                }
                composer2.endReplaceGroup();
                i2 = i3;
                coerceAtLeast = d;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmployeesCard$lambda$0$2(boolean z, boolean z2, RowScope OxChipRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxChipRow, "$this$OxChipRow");
        ComposerKt.sourceInformation(composer, "C903@34091L34:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1782992447, i, -1, "uz.FonRo.pos.ui.stats.EmployeesCard.<anonymous>.<anonymous> (StatsScreen.kt:901)");
            }
            if (z) {
                composer.startReplaceGroup(-236208638);
                ComposerKt.sourceInformation(composer, "901@33985L35");
                ChartsKt.m10154OxLegendChip3IgeMak(LangKt.tx("Наличные", new Object[0]), CCash, null, composer, 48, 4);
            } else {
                composer.startReplaceGroup(1267500451);
            }
            composer.endReplaceGroup();
            if (z2) {
                composer.startReplaceGroup(-236206689);
                ComposerKt.sourceInformation(composer, "902@34046L32");
                ChartsKt.m10154OxLegendChip3IgeMak(LangKt.tx("Карта", new Object[0]), CCard, null, composer, 48, 4);
            } else {
                composer.startReplaceGroup(1267557987);
            }
            composer.endReplaceGroup();
            ChartsKt.m10154OxLegendChip3IgeMak(LangKt.tx("В долг", new Object[0]), CAmber, null, composer, 48, 4);
            if (z && z2) {
                composer.startReplaceGroup(1267677027);
            } else {
                composer.startReplaceGroup(-236202911);
                ComposerKt.sourceInformation(composer, "904@34164L34");
                ChartsKt.m10154OxLegendChip3IgeMak(LangKt.tx("Скрыто", new Object[0]), COther, null, composer, 48, 4);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double employeeMetric(StatsEmployee statsEmployee, String str) {
        switch (str.hashCode()) {
            case -979812796:
                if (str.equals("profit")) {
                    return statsEmployee.getProfit();
                }
                break;
            case 3046160:
                if (str.equals("card")) {
                    Double card = statsEmployee.getCard();
                    return card != null ? card.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
                }
                break;
            case 3046195:
                if (str.equals("cash")) {
                    Double cash = statsEmployee.getCash();
                    return cash != null ? cash.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
                }
                break;
            case 3079315:
                if (str.equals("debt")) {
                    return statsEmployee.getDebt();
                }
                break;
            case 94851343:
                if (str.equals("count")) {
                    return statsEmployee.getCount();
                }
                break;
        }
        return statsEmployee.getRevenue();
    }

    private static final String employeeName(StatsEmployee statsEmployee) {
        String name = statsEmployee.getName();
        if (name != null) {
            if (StringsKt.isBlank(name)) {
                name = null;
            }
            if (name != null) {
                return name;
            }
        }
        return LangKt.tx("Автор не указан", new Object[0]);
    }

    private static final String employeeRole(StatsEmployee statsEmployee) {
        String name = statsEmployee.getName();
        if (name == null || StringsKt.isBlank(name)) {
            return "";
        }
        String role = statsEmployee.getRole();
        if (role != null) {
            int hashCode = role.hashCode();
            if (hashCode != 0) {
                if (hashCode != 92668751) {
                    if (hashCode == 106164915 && role.equals("owner")) {
                        return LangKt.tx("владелец", new Object[0]);
                    }
                } else if (role.equals("admin")) {
                    return LangKt.tx("админ", new Object[0]);
                }
            } else if (role.equals("")) {
                return LangKt.tx("уже не в магазине", new Object[0]);
            }
        }
        return LangKt.tx("сотрудник", new Object[0]);
    }

    private static final List<PaySegment> paySegments(StatsEmployee statsEmployee) {
        PaySegment[] paySegmentArr = new PaySegment[3];
        String tx = LangKt.tx("наличные", new Object[0]);
        Double cash = statsEmployee.getCash();
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        paySegmentArr[0] = new PaySegment(tx, cash != null ? cash.doubleValue() : 0.0d, CCash, null);
        String tx2 = LangKt.tx("карта", new Object[0]);
        Double card = statsEmployee.getCard();
        paySegmentArr[1] = new PaySegment(tx2, card != null ? card.doubleValue() : 0.0d, CCard, null);
        paySegmentArr[2] = new PaySegment(LangKt.tx("в долг", new Object[0]), statsEmployee.getDebt(), CAmber, null);
        List listOf = CollectionsKt.listOf((Object[]) paySegmentArr);
        double revenue = statsEmployee.getRevenue();
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            d += ((PaySegment) it.next()).getValue();
        }
        double d2 = revenue - d;
        if (d2 > 0.01d) {
            listOf = CollectionsKt.plus((Collection<? extends PaySegment>) listOf, new PaySegment(LangKt.tx("прочее", new Object[0]), d2, COther, null));
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listOf) {
            if (((PaySegment) obj).getValue() > 0.01d) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private static final void EmployeeRow(StatsEmployee statsEmployee, final double d, boolean z, Composer composer, final int i) {
        Composer composer2;
        final StatsEmployee statsEmployee2 = statsEmployee;
        final boolean z2 = z;
        Composer startRestartGroup = composer.startRestartGroup(-1158209286);
        ComposerKt.sourceInformation(startRestartGroup, "C(EmployeeRow)P(1,2)983@36991L2394:StatsScreen.kt#fklwc3");
        int i2 = (i & 6) == 0 ? ((i & 8) == 0 ? startRestartGroup.changed(statsEmployee2) : startRestartGroup.changedInstance(statsEmployee2) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(d) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1158209286, i2, -1, "uz.FonRo.pos.ui.stats.EmployeeRow (StatsScreen.kt:979)");
            }
            final List<PaySegment> paySegments = paySegments(statsEmployee2);
            String employeeRole = employeeRole(statsEmployee2);
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(9.0f), 1, null);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1536658802, "C984@37058L1046,1011@38114L10,1012@38133L725,1044@39301L10,1045@39320L59:StatsScreen.kt#fklwc3");
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(4.0f));
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 41124084, "C989@37247L274:StatsScreen.kt#fklwc3");
            TextKt.m2798Text4IGK_g(employeeName(statsEmployee2), rowScopeInstance.weight(Modifier.INSTANCE, 1.0f, false), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), 0L, TextUnitKt.getSp(13.5d), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), startRestartGroup, 0, 3120, 55292);
            Composer composer3 = startRestartGroup;
            if (employeeRole.length() > 0) {
                composer3.startReplaceGroup(41438857);
                ComposerKt.sourceInformation(composer3, "996@37575L505");
                TextKt.m2798Text4IGK_g(employeeRole, PaddingKt.m1050paddingVpY3zN4(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, OxShape.INSTANCE.getPill()), Ox.INSTANCE.m10218getPanel20d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getPill()), Dp.m6989constructorimpl(7.0f), Dp.m6989constructorimpl(2.0f)), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10200getDim20d7_KjU(), TextUnitKt.getSp(11.5d), FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer3, 0, 3072, 57340);
                composer3 = composer3;
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(41938050);
                composer3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(7.0f), composer3, 6);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(9.0f));
            ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, centerVertically2, composer3, 54);
            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer3, fillMaxWidth$default2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor3);
            } else {
                composer3.useNode();
            }
            Composer m3808constructorimpl3 = Updater.m3808constructorimpl(composer3);
            Updater.m3815setimpl(m3808constructorimpl3, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer3, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, 1061989260, "C1017@38322L227,1022@38562L286:StatsScreen.kt#fklwc3");
            List<PaySegment> list = paySegments;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (PaySegment paySegment : list) {
                arrayList.add(new ChartBar(paySegment.getValue(), paySegment.getColor(), null));
            }
            Composer composer4 = composer3;
            ChartsKt.OxSplitBar(arrayList, Math.max(0.02f, (float) (statsEmployee.getRevenue() / d)), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, 0, 0);
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.compact(Double.valueOf(statsEmployee.getRevenue())), SizeKt.m1103widthInVpY3zN4$default(Modifier.INSTANCE, Dp.m6989constructorimpl(56.0f), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6866boximpl(TextAlign.INSTANCE.m6874getEnde0LSkKk()), 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), 0L, TextUnitKt.getSp(12.5d), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer4, 48, 3072, 56828);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            if (!paySegments.isEmpty()) {
                composer4.startReplaceGroup(-1534896174);
                ComposerKt.sourceInformation(composer4, "1032@38909L10,1037@39130L151,1033@38932L349");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(7.0f), composer4, 6);
                FlowLayoutKt.FlowRow(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f)), Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(5.0f)), null, 0, 0, ComposableLambdaKt.rememberComposableLambda(320211012, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit EmployeeRow$lambda$0$2;
                        EmployeeRow$lambda$0$2 = StatsScreenKt.EmployeeRow$lambda$0$2(paySegments, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return EmployeeRow$lambda$0$2;
                    }
                }, composer4, 54), composer4, 1573302, 56);
                composer4.endReplaceGroup();
            } else {
                composer4.startReplaceGroup(-1534515618);
                composer4.endReplaceGroup();
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(5.0f), composer4, 6);
            statsEmployee2 = statsEmployee;
            z2 = z;
            composer2 = composer4;
            TextKt.m2798Text4IGK_g(employeeSubtitle(statsEmployee2, z2), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer2, 0, 0, 65534);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatsScreenKt.EmployeeRow$lambda$1(StatsEmployee.this, d, z2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmployeeRow$lambda$0$2(List list, FlowRowScope FlowRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
        ComposerKt.sourceInformation(composer, "C*1039@39192L57:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(320211012, i, -1, "uz.FonRo.pos.ui.stats.EmployeeRow.<anonymous>.<anonymous> (StatsScreen.kt:1038)");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                PaySegment paySegment = (PaySegment) it.next();
                ChartsKt.m10152OxDotLabel3IgeMak(paySegment.getLabel() + " " + Fmt.INSTANCE.compact(Double.valueOf(paySegment.getValue())), paySegment.getColor(), null, composer, 0, 4);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final String employeeSubtitle(StatsEmployee statsEmployee, boolean z) {
        String tx = LangKt.tx("возвраты %s на %s", Integer.valueOf(statsEmployee.getReturnsCount()), Fmt.INSTANCE.nf(Double.valueOf(statsEmployee.getReturnsAmount())));
        if (statsEmployee.getCount() <= 0) {
            return statsEmployee.getReturnsCount() > 0 ? LangKt.tx("Продаж нет · %s", tx) : LangKt.tx("Продаж за период нет", new Object[0]);
        }
        List createListBuilder = CollectionsKt.createListBuilder();
        createListBuilder.add(LangKt.tx("%s чек. · средний %s", Integer.valueOf(statsEmployee.getCount()), Fmt.INSTANCE.nf(Double.valueOf(Math.rint(statsEmployee.getRevenue() / statsEmployee.getCount())))));
        if (z) {
            createListBuilder.add(LangKt.tx("прибыль %s", Fmt.INSTANCE.nf(Double.valueOf(statsEmployee.getProfit()))));
        }
        if (statsEmployee.getReturnsCount() > 0) {
            createListBuilder.add(tx);
        }
        return CollectionsKt.joinToString$default(CollectionsKt.build(createListBuilder), " · ", null, null, 0, null, null, 62, null);
    }

    private static final void TopProductsCard(final List<StatsProduct> list, final String str, final boolean z, final String str2, final Function1<? super String, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1093370656);
        ComposerKt.sourceInformation(startRestartGroup, "C(TopProductsCard)P(3,4)1079@40482L2157,1075@40338L2301:StatsScreen.kt#fklwc3");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(list) : startRestartGroup.changedInstance(list) ? 4 : 2) | i;
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
            i2 |= startRestartGroup.changed(str2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if (!startRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1093370656, i2, -1, "uz.FonRo.pos.ui.stats.TopProductsCard (StatsScreen.kt:1074)");
            }
            PdCard(LangKt.tx("Проданные товары", new Object[0]), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null), LangKt.tx("Топ-10 за %s", str), ComposableLambdaKt.rememberComposableLambda(450814172, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StatsScreenKt.TopProductsCard$lambda$0(list, z, str2, function1, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, 3120, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatsScreenKt.TopProductsCard$lambda$1(list, str, z, str2, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TopProductsCard$lambda$0(List list, final boolean z, final String str, Function1 function1, ColumnScope PdCard, Composer composer, int i) {
        double d;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(PdCard, "$this$PdCard");
        ComposerKt.sourceInformation(composer2, "C1088@40823L180,1088@40813L190,1099@41196L39,1100@41244L11,*1115@41951L605:StatsScreen.kt#fklwc3");
        int i2 = 1;
        int i3 = 0;
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(450814172, i, -1, "uz.FonRo.pos.ui.stats.TopProductsCard.<anonymous> (StatsScreen.kt:1080)");
            }
            Object obj = null;
            if (list.isEmpty()) {
                composer2.startReplaceGroup(-157700082);
                ComposerKt.sourceInformation(composer2, "1081@40530L38");
                ChartsKt.ChartNote(LangKt.tx("Продаж за период нет.", new Object[0]), null, composer2, 0, 2);
                composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
            composer2.startReplaceGroup(-157615514);
            composer2.endReplaceGroup();
            ChipsKt.OxChipRow(null, ComposableLambdaKt.rememberComposableLambda(-975568341, true, new Function3() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    Unit TopProductsCard$lambda$0$0;
                    TopProductsCard$lambda$0$0 = StatsScreenKt.TopProductsCard$lambda$0$0(z, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return TopProductsCard$lambda$0$0;
                }
            }, composer2, 54), composer2, 48, 1);
            Pair[] pairArr = new Pair[3];
            pairArr[0] = TuplesKt.to("revenue", LangKt.tx("Продажа", new Object[0]));
            pairArr[1] = z ? TuplesKt.to("profit", LangKt.tx("Прибыль", new Object[0])) : null;
            pairArr[2] = TuplesKt.to("qty", LangKt.tx("Штук", new Object[0]));
            ChipsKt.OxSegControl(CollectionsKt.listOfNotNull((Object[]) pairArr), str, function1, null, false, composer2, 0, 24);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer2, 6);
            List list2 = list;
            Iterator it = list2.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            double revenue = ((StatsProduct) it.next()).getRevenue();
            while (it.hasNext()) {
                revenue = Math.max(revenue, ((StatsProduct) it.next()).getRevenue());
            }
            double coerceAtLeast = RangesKt.coerceAtLeast(revenue, 1.0d);
            Iterator it2 = list2.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            double abs = Math.abs(((StatsProduct) it2.next()).getProfit());
            while (it2.hasNext()) {
                abs = Math.max(abs, Math.abs(((StatsProduct) it2.next()).getProfit()));
            }
            double coerceAtLeast2 = RangesKt.coerceAtLeast(abs, 1.0d);
            Iterator it3 = list2.iterator();
            if (!it3.hasNext()) {
                throw new NoSuchElementException();
            }
            double qty = ((StatsProduct) it3.next()).getQty();
            while (it3.hasNext()) {
                qty = Math.max(qty, ((StatsProduct) it3.next()).getQty());
            }
            double coerceAtLeast3 = RangesKt.coerceAtLeast(qty, 1.0d);
            List take = CollectionsKt.take(CollectionsKt.sortedWith(list2, new Comparator() { // from class: uz.FonRo.pos.ui.stats.StatsScreenKt$TopProductsCard$lambda$0$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    double productMetric;
                    double productMetric2;
                    productMetric = StatsScreenKt.productMetric((StatsProduct) t2, str);
                    Double valueOf = Double.valueOf(productMetric);
                    productMetric2 = StatsScreenKt.productMetric((StatsProduct) t, str);
                    return ComparisonsKt.compareValues(valueOf, Double.valueOf(productMetric2));
                }
            }), 10);
            int i4 = 0;
            for (Object obj2 : take) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                StatsProduct statsProduct = (StatsProduct) obj2;
                Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, i2, obj), 0.0f, Dp.m6989constructorimpl(9.0f), i2, obj);
                ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, i3);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, i3);
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
                ComposerKt.sourceInformationMarkerStart(composer2, -339973088, "C1116@42026L219,1121@42262L69,1125@42485L57:StatsScreen.kt#fklwc3");
                int i6 = i4;
                int i7 = i2;
                int i8 = i3;
                Object obj3 = obj;
                TextKt.m2798Text4IGK_g(statsProduct.getName(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), 0L, TextUnitKt.getSp(13.5d), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 0, 3120, 55294);
                composer2 = composer;
                double d2 = coerceAtLeast;
                ChartsKt.m10155OxMetricBarT042LqI(statsProduct.getRevenue(), d2, Ox.INSTANCE.m10230getSkyBar0d7_KjU(), Fmt.INSTANCE.compact(Double.valueOf(statsProduct.getRevenue())), null, composer2, 0, 16);
                if (z) {
                    composer2.startReplaceGroup(-339651526);
                    ComposerKt.sourceInformation(composer2, "1123@42385L65");
                    double d3 = coerceAtLeast2;
                    ChartsKt.m10155OxMetricBarT042LqI(statsProduct.getProfit(), d3, Ox.INSTANCE.m10201getGreen0d7_KjU(), Fmt.INSTANCE.compact(Double.valueOf(statsProduct.getProfit())), null, composer2, 0, 16);
                    d = d3;
                    composer2.endReplaceGroup();
                } else {
                    d = coerceAtLeast2;
                    composer2.startReplaceGroup(-339550621);
                    composer2.endReplaceGroup();
                }
                double d4 = coerceAtLeast3;
                ChartsKt.m10155OxMetricBarT042LqI(statsProduct.getQty(), d4, Ox.INSTANCE.m10216getOrangeLight0d7_KjU(), Fmt.INSTANCE.qf(Double.valueOf(statsProduct.getQty())), null, composer2, 0, 16);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (i6 < CollectionsKt.getLastIndex(take)) {
                    composer2.startReplaceGroup(797921549);
                    ComposerKt.sourceInformation(composer2, "1127@42599L24");
                    BasicsKt.m9830OxDivideriPRSM58(Ox.INSTANCE.m10227getRowDivider0d7_KjU(), 0.0f, composer2, 0, 2);
                } else {
                    composer2.startReplaceGroup(-1034212691);
                }
                composer2.endReplaceGroup();
                coerceAtLeast3 = d4;
                coerceAtLeast = d2;
                coerceAtLeast2 = d;
                i4 = i5;
                obj = obj3;
                i2 = i7;
                i3 = i8;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopProductsCard$lambda$0$0(boolean z, RowScope OxChipRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxChipRow, "$this$OxChipRow");
        ComposerKt.sourceInformation(composer, "C1089@40837L38,1091@40953L40:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-975568341, i, -1, "uz.FonRo.pos.ui.stats.TopProductsCard.<anonymous>.<anonymous> (StatsScreen.kt:1089)");
            }
            ChartsKt.m10154OxLegendChip3IgeMak(LangKt.tx("Продажа", new Object[0]), Ox.INSTANCE.m10230getSkyBar0d7_KjU(), null, composer, 0, 4);
            if (z) {
                composer.startReplaceGroup(-1218302576);
                ComposerKt.sourceInformation(composer, "1090@40903L37");
                ChartsKt.m10154OxLegendChip3IgeMak(LangKt.tx("Прибыль", new Object[0]), Ox.INSTANCE.m10201getGreen0d7_KjU(), null, composer, 0, 4);
            } else {
                composer.startReplaceGroup(887361367);
            }
            composer.endReplaceGroup();
            ChartsKt.m10154OxLegendChip3IgeMak(LangKt.tx("Штук", new Object[0]), Ox.INSTANCE.m10216getOrangeLight0d7_KjU(), null, composer, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double productMetric(StatsProduct statsProduct, String str) {
        return Intrinsics.areEqual(str, "profit") ? statsProduct.getProfit() : Intrinsics.areEqual(str, "qty") ? statsProduct.getQty() : statsProduct.getRevenue();
    }

    private static final List<Product> StatsScreen$lambda$0(State<? extends List<Product>> state) {
        return state.getValue();
    }

    private static final SyncData StatsScreen$lambda$1(State<SyncData> state) {
        return state.getValue();
    }
}
