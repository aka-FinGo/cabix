package uz.FonRo.pos.ui.docs;

import android.content.Context;
import android.widget.DatePicker;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
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
import kotlin.random.Random;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Num;
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.core.Units;
import uz.FonRo.pos.data.local.CacheStore;
import uz.FonRo.pos.data.model.Category;
import uz.FonRo.pos.data.model.Paywall;
import uz.FonRo.pos.data.model.Plan;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.model.StockInDoc;
import uz.FonRo.pos.data.model.StockInItem;
import uz.FonRo.pos.data.model.Store;
import uz.FonRo.pos.data.model.Supplier;
import uz.FonRo.pos.data.model.SyncData;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;
import uz.FonRo.pos.ui.catalog.CatalogScreenKt;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnSize;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.ChipTint;
import uz.FonRo.pos.ui.components.ChipTone;
import uz.FonRo.pos.ui.components.ChipsKt;
import uz.FonRo.pos.ui.components.FieldsKt;
import uz.FonRo.pos.ui.components.ModifiersKt;
import uz.FonRo.pos.ui.components.NumpadKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.PageHeadKt;
import uz.FonRo.pos.ui.components.PeriodKind;
import uz.FonRo.pos.ui.components.PeriodPickersKt;
import uz.FonRo.pos.ui.components.PeriodState;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.nav.Routes;
import uz.FonRo.pos.ui.scan.ScannerSheetKt;
import uz.FonRo.pos.ui.shell.MainShellKt;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxDim;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: StockInScreen.kt */
@Metadata(d1 = {"\u0000Î\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a7\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0006\u001a\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0000\u001a\u0014\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002\u001a\u0014\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0000\u001aG\u0010\u0014\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0001b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\b\u001c\u0010\u001d\u001a;\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\u0019H\u0001b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\b \u0010!\u001a\u0012\u0010\"\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002\u001a\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0000\u001a.\u0010)\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\f2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010.H\u0002\u001a/\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0007b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u00104\u001a/\u00105\u001a\u00020\u00012\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0007b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u00104\u001a\u0083\u0001\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\f2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010@\u001aK\u0010A\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\bC\u0010D\u001aM\u0010E\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(2\u0006\u00109\u001a\u00020\f2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020H2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010I\u001aM\u0010J\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(2\u0006\u00109\u001a\u00020\f2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020H2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010I\u001aQ\u0010K\u001a\u00020\u00012\f\u0010L\u001a\b\u0012\u0004\u0012\u00020N0M2\u0014\u0010-\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010N\u0012\u0004\u0012\u00020\u00010.2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010O\u001a?\u0010P\u001a\u00020\u00012\u0006\u0010Q\u001a\u00020\f2\b\u0010R\u001a\u0004\u0018\u00010\f2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010S\u001a«\u0001\u0010T\u001a\u00020\u00012\f\u0010U\u001a\b\u0012\u0004\u0012\u00020V0M2\u0006\u00109\u001a\u00020\f2\u0006\u0010W\u001a\u00020H2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0M2\u000e\b\u0002\u0010Z\u001a\b\u0012\u0004\u0012\u00020\\0[2\b\b\u0002\u0010]\u001a\u00020H2\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020\u0001\u0018\u00010.2\u001c\b\u0002\u0010^\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0M\u0012\u0004\u0012\u00020\u0001\u0018\u00010.H\u0001b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010_\u001aO\u0010b\u001a\u00020\u00012\u0006\u0010Q\u001a\u00020\f2\b\u0010R\u001a\u0004\u0018\u00010\f2\u0006\u0010c\u001a\u00020H2\u0006\u0010d\u001a\u00020H2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010e\u001a/\u0010f\u001a\u00020\u00012\u0006\u00100\u001a\u0002012\u0006\u0010g\u001a\u00020hH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010i\"\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010`\u001a\u00020aX\u0082T¢\u0006\u0002\n\u0000¨\u00060²\u0006\f\u0010j\u001a\u0004\u0018\u00010kX\u008a\u0084\u0002²\u0006\u0010\u0010U\u001a\b\u0012\u0004\u0012\u00020V0MX\u008a\u0084\u0002²\u0006\u0010\u0010L\u001a\b\u0012\u0004\u0012\u00020N0MX\u008a\u0084\u0002²\u0006\f\u0010#\u001a\u0004\u0018\u00010$X\u008a\u0084\u0002²\u0006\f\u0010l\u001a\u0004\u0018\u00010(X\u008a\u008e\u0002²\u0006\n\u0010m\u001a\u00020nX\u008a\u008e\u0002²\u0006\n\u0010o\u001a\u00020HX\u008a\u008e\u0002²\u0006\n\u0010p\u001a\u00020HX\u008a\u008e\u0002²\u0006\f\u0010j\u001a\u0004\u0018\u00010kX\u008a\u0084\u0002²\u0006\u0010\u0010U\u001a\b\u0012\u0004\u0012\u00020V0MX\u008a\u0084\u0002²\u0006\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0MX\u008a\u0084\u0002²\u0006\u0010\u0010L\u001a\b\u0012\u0004\u0012\u00020N0MX\u008a\u0084\u0002²\u0006\f\u0010#\u001a\u0004\u0018\u00010$X\u008a\u0084\u0002²\u0006\f\u0010q\u001a\u0004\u0018\u00010NX\u008a\u008e\u0002²\u0006\n\u0010r\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010s\u001a\u00020HX\u008a\u008e\u0002²\u0006\n\u0010t\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010u\u001a\u00020&X\u008a\u008e\u0002²\u0006\u0010\u0010v\u001a\b\u0012\u0004\u0012\u0002080MX\u008a\u008e\u0002²\u0006\n\u0010w\u001a\u00020HX\u008a\u008e\u0002²\u0006\n\u0010x\u001a\u00020HX\u008a\u008e\u0002²\u0006\n\u0010y\u001a\u00020HX\u008a\u008e\u0002²\u0006\f\u0010z\u001a\u0004\u0018\u00010\u0003X\u008a\u008e\u0002²\u0006\n\u0010{\u001a\u00020HX\u008a\u008e\u0002²\u0006\n\u0010|\u001a\u00020\fX\u008a\u008e\u0002²\u0006\f\u0010}\u001a\u0004\u0018\u00010\\X\u008a\u008e\u0002²\u0006\u0010\u0010~\u001a\b\u0012\u0004\u0012\u00020\\0[X\u008a\u008e\u0002²\u0006\n\u0010{\u001a\u00020HX\u008a\u008e\u0002"}, d2 = {"NumPadHost", "", "request", "Luz/FonRo/pos/ui/docs/NumPadRequest;", "onDismiss", "Lkotlin/Function0;", "(Luz/FonRo/pos/ui/docs/NumPadRequest;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "CLIENT_ID_ALPHABET", "", "docClientId", "prefix", "textOf", "node", "Lkotlinx/serialization/json/JsonElement;", "rejectedReason", "data", "DocMiniStat", "Landroidx/compose/foundation/layout/RowScope;", "value", "label", "tint", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "DocMiniStat-uDo3WH8", "(Landroidx/compose/foundation/layout/RowScope;Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DocLine", "valueColor", "DocLine-FNF3uiM", "(Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/runtime/Composer;II)V", "nextInvoiceNumber", "sync", "Luz/FonRo/pos/data/model/SyncData;", "docTotal", "", "doc", "Luz/FonRo/pos/data/model/StockInDoc;", "pickExpiration", "context", "Landroid/content/Context;", "current", "onPick", "Lkotlin/Function1;", "StockInScreen", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "StockInNewScreen", "StockInLineCard", "line", "Luz/FonRo/pos/ui/docs/StockInLine;", FirebaseAnalytics.Param.CURRENCY, "onQuantity", "onPurchase", "onSale", "onExpiration", "onClearExpiration", "onRemove", "(Luz/FonRo/pos/ui/docs/StockInLine;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "LineNumField", "onClick", "LineNumField-ww6aTOc", "(Landroidx/compose/foundation/layout/RowScope;Ljava/lang/String;Ljava/lang/String;JLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "StockInHistoryCard", "supplierName", "canPurchase", "", "(Luz/FonRo/pos/data/model/StockInDoc;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "StockInDetailSheet", "SupplierPickerSheet", Routes.SUPPLIERS, "", "Luz/FonRo/pos/data/model/Supplier;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "PickerRow", "title", "subtitle", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ProductPickerSheet", CacheStore.PRODUCTS, "Luz/FonRo/pos/data/model/Product;", "showPurchase", CacheStore.CATEGORIES, "Luz/FonRo/pos/data/model/Category;", "alreadyIds", "", "", "scrim", "onPickMany", "(Ljava/util/List;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Ljava/util/List;Ljava/util/Set;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "PICKER_LIMIT", "", "ProductCheckRow", "checked", "locked", "(Ljava/lang/String;Ljava/lang/String;ZZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "StockInPaywall", "paywall", "Luz/FonRo/pos/data/model/Paywall;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/data/model/Paywall;Landroidx/compose/runtime/Composer;I)V", "store", "Luz/FonRo/pos/data/model/Store;", "detail", TypedValues.CycleType.S_WAVE_PERIOD, "Luz/FonRo/pos/ui/components/PeriodState;", "monthSheet", "dateSheet", "supplier", "invoice", "invoiceEdited", "note", "paid", "lines", "supplierPicker", "productPicker", "scanOpen", "pad", "busy", SearchIntents.EXTRA_QUERY, "categoryId", "selected"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class StockInScreenKt {
    private static final String CLIENT_ID_ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final int PICKER_LIMIT = 200;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DocLine_FNF3uiM$lambda$1(String str, String str2, long j, int i, int i2, Composer composer, int i3) {
        m9918DocLineFNF3uiM(str, str2, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DocMiniStat_uDo3WH8$lambda$1(RowScope rowScope, String str, String str2, long j, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m9919DocMiniStatuDo3WH8(rowScope, str, str2, j, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LineNumField_ww6aTOc$lambda$1(RowScope rowScope, String str, String str2, long j, Function0 function0, int i, Composer composer, int i2) {
        m9920LineNumFieldww6aTOc(rowScope, str, str2, j, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NumPadHost$lambda$0(NumPadRequest numPadRequest, Function0 function0, int i, Composer composer, int i2) {
        NumPadHost(numPadRequest, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NumPadHost$lambda$1(NumPadRequest numPadRequest, Function0 function0, int i, Composer composer, int i2) {
        NumPadHost(numPadRequest, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PickerRow$lambda$1(String str, String str2, Function0 function0, int i, Composer composer, int i2) {
        PickerRow(str, str2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ProductCheckRow$lambda$1(String str, String str2, boolean z, boolean z2, Function0 function0, int i, Composer composer, int i2) {
        ProductCheckRow(str, str2, z, z2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ProductPickerSheet$lambda$15(List list, String str, boolean z, Function0 function0, List list2, Set set, boolean z2, Function1 function1, Function1 function12, int i, int i2, Composer composer, int i3) {
        ProductPickerSheet(list, str, z, function0, list2, set, z2, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit StockInDetailSheet$lambda$2(StockInDoc stockInDoc, String str, String str2, boolean z, Function0 function0, int i, Composer composer, int i2) {
        StockInDetailSheet(stockInDoc, str, str2, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit StockInHistoryCard$lambda$2(StockInDoc stockInDoc, String str, String str2, boolean z, Function0 function0, int i, Composer composer, int i2) {
        StockInHistoryCard(stockInDoc, str, str2, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit StockInLineCard$lambda$1(StockInLine stockInLine, String str, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, Function0 function06, int i, Composer composer, int i2) {
        StockInLineCard(stockInLine, str, function0, function02, function03, function04, function05, function06, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit StockInNewScreen$lambda$1(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        StockInNewScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit StockInNewScreen$lambda$54(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        StockInNewScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit StockInPaywall$lambda$8(FonRoApp FonRoApp, Paywall paywall, int i, Composer composer, int i2) {
        StockInPaywall(FonRoApp, paywall, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit StockInScreen$lambda$1(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        StockInScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit StockInScreen$lambda$28(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        StockInScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SupplierPickerSheet$lambda$1(List list, Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        SupplierPickerSheet(list, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void NumPadHost(final NumPadRequest numPadRequest, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(-1542180467);
        ComposerKt.sourceInformation(startRestartGroup, "C(NumPadHost)P(1)123@5156L192:StockInScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(numPadRequest) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 32 : 16;
        }
        if (startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1542180467, i2, -1, "uz.FonRo.pos.ui.docs.NumPadHost (StockInScreen.kt:121)");
            }
            if (numPadRequest == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StockInScreenKt.NumPadHost$lambda$0(NumPadRequest.this, onDismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            function0 = onDismiss;
            NumpadKt.NumpadSheet(numPadRequest.getTitle(), numPadRequest.getInitial(), numPadRequest.getOnDone(), function0, numPadRequest.getAllowDecimal(), startRestartGroup, (i2 << 6) & 7168, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function0 = onDismiss;
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StockInScreenKt.NumPadHost$lambda$1(NumPadRequest.this, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final String docClientId(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(StringsKt.random(CLIENT_ID_ALPHABET, Random.INSTANCE));
        }
        String sb2 = sb.toString();
        return prefix + "-" + System.currentTimeMillis() + "-" + sb2;
    }

    private static final String textOf(JsonElement jsonElement) {
        JsonPrimitive jsonPrimitive = jsonElement instanceof JsonPrimitive ? (JsonPrimitive) jsonElement : null;
        if (jsonPrimitive == null || (jsonPrimitive instanceof JsonNull)) {
            return null;
        }
        String content = jsonPrimitive.getContent();
        if (StringsKt.isBlank(content)) {
            return null;
        }
        return content;
    }

    public static final String rejectedReason(JsonElement jsonElement) {
        JsonElement field = ApiClient.INSTANCE.field(jsonElement, "rejected");
        JsonArray jsonArray = field instanceof JsonArray ? (JsonArray) field : null;
        if (jsonArray == null || jsonArray.isEmpty()) {
            return null;
        }
        JsonElement jsonElement2 = (JsonElement) CollectionsKt.first((List) jsonArray);
        JsonObject jsonObject = jsonElement2 instanceof JsonObject ? (JsonObject) jsonElement2 : null;
        String textOf = textOf(jsonObject != null ? (JsonElement) jsonObject.get((Object) "error") : null);
        if (textOf == null) {
            textOf = textOf(jsonObject != null ? (JsonElement) jsonObject.get((Object) "message") : null);
            if (textOf == null) {
                String textOf2 = textOf(jsonObject != null ? (JsonElement) jsonObject.get((Object) "reason") : null);
                if (textOf2 != null) {
                    return textOf2;
                }
                String textOf3 = textOf(jsonElement2);
                return textOf3 == null ? LangKt.tx("Сервер отклонил документ", new Object[0]) : textOf3;
            }
        }
        return textOf;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x008d  */
    /* renamed from: DocMiniStat-uDo3WH8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m9919DocMiniStatuDo3WH8(final androidx.compose.foundation.layout.RowScope r74, final java.lang.String r75, final java.lang.String r76, final long r77, androidx.compose.ui.Modifier r79, androidx.compose.runtime.Composer r80, final int r81, final int r82) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.StockInScreenKt.m9919DocMiniStatuDo3WH8(androidx.compose.foundation.layout.RowScope, java.lang.String, java.lang.String, long, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x007f, code lost:
    
        if ((r52 & 4) != 0) goto L45;
     */
    /* renamed from: DocLine-FNF3uiM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m9918DocLineFNF3uiM(final java.lang.String r46, final java.lang.String r47, long r48, androidx.compose.runtime.Composer r50, final int r51, final int r52) {
        /*
            Method dump skipped, instructions count: 824
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.StockInScreenKt.m9918DocLineFNF3uiM(java.lang.String, java.lang.String, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String nextInvoiceNumber(SyncData syncData) {
        List<StockInDoc> stockIn;
        String format = String.format("%04d", Arrays.copyOf(new Object[]{Integer.valueOf(((syncData == null || (stockIn = syncData.getStockIn()) == null) ? 0 : stockIn.size()) + 1)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final double docTotal(StockInDoc doc) {
        Intrinsics.checkNotNullParameter(doc, "doc");
        double totalAmount = doc.getTotalAmount();
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (totalAmount > AudioStats.AUDIO_AMPLITUDE_NONE) {
            return doc.getTotalAmount();
        }
        for (StockInItem stockInItem : doc.getItems()) {
            d += stockInItem.getQuantity() * stockInItem.getPurchasePrice();
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
    
        if (r1 != null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void pickExpiration(android.content.Context r9, java.lang.String r10, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r11) {
        /*
            if (r10 == 0) goto L3f
            int r0 = r10.length()
            r1 = 0
            r2 = 10
            if (r0 < r2) goto Lc
            goto Ld
        Lc:
            r10 = r1
        Ld:
            if (r10 == 0) goto L3f
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L26
            r0 = 0
            java.lang.String r10 = r10.substring(r0, r2)     // Catch: java.lang.Throwable -> L26
            java.lang.String r0 = "substring(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)     // Catch: java.lang.Throwable -> L26
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch: java.lang.Throwable -> L26
            j$.time.LocalDate r10 = j$.time.LocalDate.parse(r10)     // Catch: java.lang.Throwable -> L26
            java.lang.Object r10 = kotlin.Result.m7870constructorimpl(r10)     // Catch: java.lang.Throwable -> L26
            goto L32
        L26:
            r0 = move-exception
            r10 = r0
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m7870constructorimpl(r10)
        L32:
            boolean r0 = kotlin.Result.m7876isFailureimpl(r10)
            if (r0 == 0) goto L39
            goto L3a
        L39:
            r1 = r10
        L3a:
            j$.time.LocalDate r1 = (j$.time.LocalDate) r1
            if (r1 == 0) goto L3f
            goto L49
        L3f:
            uz.FonRo.pos.core.Fmt r10 = uz.FonRo.pos.core.Fmt.INSTANCE
            j$.time.ZoneId r10 = r10.getSTORE_ZONE()
            j$.time.LocalDate r1 = j$.time.LocalDate.now(r10)
        L49:
            uz.FonRo.pos.ui.theme.Ox r10 = uz.FonRo.pos.ui.theme.Ox.INSTANCE
            boolean r10 = r10.isDark()
            if (r10 == 0) goto L55
            r10 = 16974545(0x10302d1, float:2.406292E-38)
            goto L58
        L55:
            r10 = 16974546(0x10302d2, float:2.4062923E-38)
        L58:
            r4 = r10
            android.app.DatePickerDialog r2 = new android.app.DatePickerDialog
            uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda27 r5 = new uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda27
            r5.<init>()
            int r6 = r1.getYear()
            int r10 = r1.getMonthValue()
            int r7 = r10 + (-1)
            int r8 = r1.getDayOfMonth()
            r3 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r2.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.StockInScreenKt.pickExpiration(android.content.Context, java.lang.String, kotlin.jvm.functions.Function1):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void pickExpiration$lambda$2(Function1 function1, DatePicker datePicker, int i, int i2, int i3) {
        String format = String.format("%04d-%02d-%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(i3)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        function1.invoke(format);
    }

    public static final void StockInScreen(final FonRoApp app, final AppNavigator nav, Composer composer, final int i) {
        final FonRoApp FonRoApp;
        final AppNavigator appNavigator;
        List<StockInDoc> emptyList;
        MutableState mutableState;
        MutableState mutableState2;
        MutableState mutableState3;
        List list;
        Object obj;
        String str;
        final MutableState mutableState4;
        final MutableState mutableState5;
        boolean z;
        State state;
        Composer composer2;
        String str2;
        final MutableState mutableState6;
        String str3;
        final MutableState mutableState7;
        final MutableState mutableState8;
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(nav, "nav");
        Composer startRestartGroup = composer.startRestartGroup(-1749175179);
        ComposerKt.sourceInformation(startRestartGroup, "C(StockInScreen)279@10804L29,289@11139L29,290@11205L29,291@11261L29,297@11448L46,301@11670L67,302@11760L34,303@11816L34,305@11877L279,305@11856L300,313@12179L229,319@12428L96,323@12547L172,337@13082L4240,334@12930L4392:StockInScreen.kt#1so789");
        int i2 = (i & 6) == 0 ? ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(nav) : startRestartGroup.changedInstance(nav) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            FonRoApp = app;
            appNavigator = nav;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1749175179, i2, -1, "uz.FonRo.pos.ui.docs.StockInScreen (StockInScreen.kt:277)");
            }
            final Repo repo = app.getRepo();
            Store StockInScreen$lambda$0 = StockInScreen$lambda$0(FlowExtKt.collectAsStateWithLifecycle(repo.getStore(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7));
            Paywall paywall = StockInScreen$lambda$0 != null ? StockInScreen$lambda$0.getPaywall() : null;
            if (paywall != null && paywall.isLocked()) {
                startRestartGroup.startReplaceGroup(1160790834);
                ComposerKt.sourceInformation(startRestartGroup, "285@11054L28");
                StockInPaywall(app, paywall, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (Paywall.$stable << 3));
                startRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda41
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return StockInScreenKt.StockInScreen$lambda$1(FonRoApp.this, nav, i, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            startRestartGroup.startReplaceGroup(1160847533);
            startRestartGroup.endReplaceGroup();
            final State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(repo.getProducts(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            final State collectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(repo.getSuppliers(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            State collectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(repo.getSync(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            final String currency = repo.currency();
            final boolean can = repo.can(Perm.STOCK_IN);
            final boolean can2 = repo.can(Perm.VIEW_PURCHASE_PRICE);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1625110205, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState9 = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1625103080, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PeriodState(PeriodKind.DAYS_10, null, null, 6, null), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState10 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1625100233, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(mutableStateOf$default);
                rememberedValue3 = mutableStateOf$default;
            }
            MutableState mutableState11 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1625098441, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            MutableState mutableState12 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1625096244, "CC(remember):StockInScreen.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(repo);
            int i3 = i2;
            StockInScreenKt$StockInScreen$2$1 rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new StockInScreenKt$StockInScreen$2$1(repo, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue5, startRestartGroup, 6);
            SyncData StockInScreen$lambda$4 = StockInScreen$lambda$4(collectAsStateWithLifecycle3);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1625086630, "CC(remember):StockInScreen.kt#9igjgp");
            boolean changed = startRestartGroup.changed(StockInScreen$lambda$4);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                SyncData StockInScreen$lambda$42 = StockInScreen$lambda$4(collectAsStateWithLifecycle3);
                if (StockInScreen$lambda$42 == null || (emptyList = StockInScreen$lambda$42.getStockIn()) == null) {
                    emptyList = CollectionsKt.emptyList();
                }
                rememberedValue6 = CollectionsKt.sortedWith(emptyList, new Comparator() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$StockInScreen$lambda$18$$inlined$sortedByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((StockInDoc) t2).getCreatedAt(), ((StockInDoc) t).getCreatedAt());
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final List list2 = (List) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            PeriodState StockInScreen$lambda$9 = StockInScreen$lambda$9(mutableState10);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1625078795, "CC(remember):StockInScreen.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(StockInScreen$lambda$9) | startRestartGroup.changed(list2);
            ArrayList rememberedValue7 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    Iterator it2 = it;
                    MutableState mutableState13 = mutableState10;
                    if (StockInScreen$lambda$9(mutableState10).contains(((StockInDoc) next).getCreatedAt())) {
                        arrayList.add(next);
                    }
                    it = it2;
                    mutableState10 = mutableState13;
                }
                mutableState = mutableState10;
                rememberedValue7 = arrayList;
                startRestartGroup.updateRememberedValue(rememberedValue7);
            } else {
                mutableState = mutableState10;
            }
            List list3 = (List) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            List<Product> StockInScreen$lambda$2 = StockInScreen$lambda$2(collectAsStateWithLifecycle);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1625074911, "CC(remember):StockInScreen.kt#9igjgp");
            boolean changed3 = startRestartGroup.changed(StockInScreen$lambda$2) | startRestartGroup.changed(can2);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                mutableState2 = mutableState12;
                MutableState mutableState14 = mutableState11;
                double d = 0.0d;
                for (Product product : StockInScreen$lambda$2(collectAsStateWithLifecycle)) {
                    MutableState mutableState15 = mutableState14;
                    List list4 = list3;
                    d += Math.max(can2 ? product.getPurchasePrice() : product.getSalePrice(), AudioStats.AUDIO_AMPLITUDE_NONE) * Math.max(product.getQuantity(), AudioStats.AUDIO_AMPLITUDE_NONE);
                    list3 = list4;
                    mutableState14 = mutableState15;
                }
                mutableState3 = mutableState14;
                list = list3;
                rememberedValue8 = Double.valueOf(d);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            } else {
                list = list3;
                mutableState2 = mutableState12;
                mutableState3 = mutableState11;
            }
            final double doubleValue = ((Number) rememberedValue8).doubleValue();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            MutableState mutableState16 = mutableState2;
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), OxDim.INSTANCE.m10245getPagePadD9Ej5fM(), 0.0f, 2, null);
            PaddingValues m1046PaddingValuesa9UjIt4$default = PaddingKt.m1046PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(30.0f), 7, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1625053723, "CC(remember):StockInScreen.kt#9igjgp");
            final List list5 = list;
            boolean changed4 = startRestartGroup.changed(can2) | startRestartGroup.changed(doubleValue) | startRestartGroup.changed(currency) | startRestartGroup.changedInstance(list2) | startRestartGroup.changed(collectAsStateWithLifecycle) | startRestartGroup.changedInstance(repo) | ((i3 & 14) == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(app))) | ((i3 & 112) == 32 || ((i3 & 64) != 0 && startRestartGroup.changedInstance(nav))) | startRestartGroup.changed(can) | startRestartGroup.changedInstance(list5) | startRestartGroup.changed(collectAsStateWithLifecycle2);
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (changed4 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                str = "CC(remember):StockInScreen.kt#9igjgp";
                mutableState4 = mutableState16;
                final MutableState mutableState17 = mutableState3;
                mutableState5 = mutableState;
                obj = new Function1() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda42
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit StockInScreen$lambda$22$0;
                        StockInScreen$lambda$22$0 = StockInScreenKt.StockInScreen$lambda$22$0(list5, doubleValue, currency, app, nav, can, can2, list2, repo, collectAsStateWithLifecycle, mutableState5, mutableState17, mutableState4, collectAsStateWithLifecycle2, mutableState9, (LazyListScope) obj2);
                        return StockInScreen$lambda$22$0;
                    }
                };
                FonRoApp = app;
                z = can2;
                state = collectAsStateWithLifecycle2;
                composer2 = startRestartGroup;
                str2 = currency;
                appNavigator = nav;
                composer2.updateRememberedValue(obj);
            } else {
                FonRoApp = app;
                str2 = currency;
                z = can2;
                str = "CC(remember):StockInScreen.kt#9igjgp";
                obj = rememberedValue9;
                state = collectAsStateWithLifecycle2;
                mutableState4 = mutableState16;
                mutableState5 = mutableState;
                appNavigator = nav;
                composer2 = startRestartGroup;
            }
            Function1 function1 = (Function1) obj;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            MutableState mutableState18 = mutableState4;
            MutableState mutableState19 = mutableState5;
            Composer composer3 = composer2;
            State state2 = state;
            LazyDslKt.LazyColumn(m1051paddingVpY3zN4$default, null, m1046PaddingValuesa9UjIt4$default, false, null, null, null, false, null, function1, composer3, 384, TypedValues.PositionType.TYPE_PERCENT_X);
            startRestartGroup = composer3;
            if (StockInScreen$lambda$12(mutableState3)) {
                startRestartGroup.startReplaceGroup(1167046944);
                ComposerKt.sourceInformation(startRestartGroup, "453@17428L22,454@17473L124,451@17354L253");
                String month = StockInScreen$lambda$9(mutableState19).getMonth();
                str3 = str;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1624918869, str3);
                Object rememberedValue10 = startRestartGroup.rememberedValue();
                if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                    mutableState8 = mutableState3;
                    rememberedValue10 = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda43
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit StockInScreen$lambda$23$0;
                            StockInScreen$lambda$23$0 = StockInScreenKt.StockInScreen$lambda$23$0(MutableState.this);
                            return StockInScreen$lambda$23$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue10);
                } else {
                    mutableState8 = mutableState3;
                }
                Function0 function0 = (Function0) rememberedValue10;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1624917327, str3);
                Object rememberedValue11 = startRestartGroup.rememberedValue();
                if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                    mutableState6 = mutableState19;
                    rememberedValue11 = new Function1() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda45
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit StockInScreen$lambda$24$0;
                            StockInScreen$lambda$24$0 = StockInScreenKt.StockInScreen$lambda$24$0(MutableState.this, mutableState8, (String) obj2);
                            return StockInScreen$lambda$24$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue11);
                } else {
                    mutableState6 = mutableState19;
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                PeriodPickersKt.OxMonthSheet(month, function0, (Function1) rememberedValue11, startRestartGroup, 432);
                startRestartGroup.endReplaceGroup();
            } else {
                mutableState6 = mutableState19;
                str3 = str;
                startRestartGroup.startReplaceGroup(1167305453);
                startRestartGroup.endReplaceGroup();
            }
            if (StockInScreen$lambda$15(mutableState18)) {
                startRestartGroup.startReplaceGroup(1167334624);
                ComposerKt.sourceInformation(startRestartGroup, "464@17722L21,465@17766L121,462@17644L253");
                String date = StockInScreen$lambda$9(mutableState6).getDate();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1624909462, str3);
                Object rememberedValue12 = startRestartGroup.rememberedValue();
                if (rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                    mutableState7 = mutableState18;
                    rememberedValue12 = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda46
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit StockInScreen$lambda$25$0;
                            StockInScreen$lambda$25$0 = StockInScreenKt.StockInScreen$lambda$25$0(MutableState.this);
                            return StockInScreen$lambda$25$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue12);
                } else {
                    mutableState7 = mutableState18;
                }
                Function0 function02 = (Function0) rememberedValue12;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1624907954, str3);
                Object rememberedValue13 = startRestartGroup.rememberedValue();
                if (rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue13 = new Function1() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda47
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit StockInScreen$lambda$26$0;
                            StockInScreen$lambda$26$0 = StockInScreenKt.StockInScreen$lambda$26$0(MutableState.this, mutableState7, (String) obj2);
                            return StockInScreen$lambda$26$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue13);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                PeriodPickersKt.OxDayPickerDialog(date, function02, (Function1) rememberedValue13, startRestartGroup, 432);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1167593133);
                startRestartGroup.endReplaceGroup();
            }
            StockInDoc StockInScreen$lambda$6 = StockInScreen$lambda$6(mutableState9);
            if (StockInScreen$lambda$6 != null) {
                startRestartGroup.startReplaceGroup(1167615329);
                ComposerKt.sourceInformation(startRestartGroup, "*478@18152L17,473@17938L241");
                String StockInScreen$supplierName = StockInScreen$supplierName(state2, StockInScreen$lambda$6.getSupplierId(), StockInScreen$lambda$6.getSupplierName());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2081385612, str3);
                Object rememberedValue14 = startRestartGroup.rememberedValue();
                if (rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue14 = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda48
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit StockInScreen$lambda$27$0$0;
                            StockInScreen$lambda$27$0$0 = StockInScreenKt.StockInScreen$lambda$27$0$0(MutableState.this);
                            return StockInScreen$lambda$27$0$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue14);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                StockInDetailSheet(StockInScreen$lambda$6, str2, StockInScreen$supplierName, z, (Function0) rememberedValue14, startRestartGroup, StockInDoc.$stable | 24576);
                Unit unit2 = Unit.INSTANCE;
                startRestartGroup.endReplaceGroup();
                Unit unit3 = Unit.INSTANCE;
            } else {
                startRestartGroup.startReplaceGroup(1167615328);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda49
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return StockInScreenKt.StockInScreen$lambda$28(FonRoApp.this, appNavigator, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final StockInDoc StockInScreen$lambda$6(MutableState<StockInDoc> mutableState) {
        return mutableState.getValue();
    }

    private static final PeriodState StockInScreen$lambda$9(MutableState<PeriodState> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean StockInScreen$lambda$12(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void StockInScreen$lambda$13(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean StockInScreen$lambda$15(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void StockInScreen$lambda$16(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String StockInScreen$supplierName(State<? extends List<Supplier>> state, long j, String str) {
        Object obj;
        String name;
        String str2 = str;
        if (str2 != null && !StringsKt.isBlank(str2)) {
            return str;
        }
        Iterator<T> it = StockInScreen$lambda$3(state).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Supplier) obj).getId() == j) {
                break;
            }
        }
        Supplier supplier = (Supplier) obj;
        return (supplier == null || (name = supplier.getName()) == null) ? LangKt.tx("Без поставщика", new Object[0]) : name;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInScreen$lambda$22$0(final List list, final double d, final String str, final FonRoApp FonRoApp, final AppNavigator appNavigator, final boolean z, final boolean z2, final List list2, final Repo repo, final State state, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final State state2, final MutableState mutableState4, LazyListScope LazyColumn) {
        LazyListScope lazyListScope;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, "head", null, ComposableSingletons$StockInScreenKt.INSTANCE.getLambda$682127690$app(), 2, null);
        LazyListScope.item$default(LazyColumn, "hero", null, ComposableLambdaKt.composableLambdaInstance(1877878657, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda59
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit StockInScreen$lambda$22$0$0;
                StockInScreen$lambda$22$0$0 = StockInScreenKt.StockInScreen$lambda$22$0$0(d, str, FonRoApp, appNavigator, z, z2, list2, repo, state, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return StockInScreen$lambda$22$0$0;
            }
        }), 2, null);
        LazyListScope.item$default(LazyColumn, "history-head", null, ComposableLambdaKt.composableLambdaInstance(1175282818, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda60
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit StockInScreen$lambda$22$0$1;
                StockInScreen$lambda$22$0$1 = StockInScreenKt.StockInScreen$lambda$22$0$1(list, mutableState, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return StockInScreen$lambda$22$0$1;
            }
        }), 2, null);
        LazyListScope.item$default(LazyColumn, "history-period", null, ComposableLambdaKt.composableLambdaInstance(472686979, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda61
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit StockInScreen$lambda$22$0$2;
                StockInScreen$lambda$22$0$2 = StockInScreenKt.StockInScreen$lambda$22$0$2(MutableState.this, mutableState2, mutableState3, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return StockInScreen$lambda$22$0$2;
            }
        }), 2, null);
        if (list.isEmpty()) {
            LazyListScope.item$default(LazyColumn, "history-empty", null, ComposableLambdaKt.composableLambdaInstance(546170277, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda62
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit StockInScreen$lambda$22$0$3;
                    StockInScreen$lambda$22$0$3 = StockInScreenKt.StockInScreen$lambda$22$0$3(list2, mutableState, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return StockInScreen$lambda$22$0$3;
                }
            }), 2, null);
            lazyListScope = LazyColumn;
        } else {
            lazyListScope = LazyColumn;
        }
        final StockInScreenKt$StockInScreen$lambda$22$0$$inlined$items$default$1 stockInScreenKt$StockInScreen$lambda$22$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$StockInScreen$lambda$22$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(StockInDoc stockInDoc) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((StockInDoc) obj);
            }
        };
        lazyListScope.items(list.size(), null, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$StockInScreen$lambda$22$0$$inlined$items$default$3
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
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$StockInScreen$lambda$22$0$$inlined$items$default$4
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
                String StockInScreen$supplierName;
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
                final StockInDoc stockInDoc = (StockInDoc) list.get(i);
                composer.startReplaceGroup(165838340);
                ComposerKt.sourceInformation(composer, "C*445@17276L16,440@17044L262:StockInScreen.kt#1so789");
                String str2 = str;
                StockInScreen$supplierName = StockInScreenKt.StockInScreen$supplierName(state2, stockInDoc.getSupplierId(), stockInDoc.getSupplierName());
                boolean z3 = z2;
                ComposerKt.sourceInformationMarkerStart(composer, -825927191, "CC(remember):StockInScreen.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(stockInDoc);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState5 = mutableState4;
                    rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$StockInScreen$3$1$5$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            mutableState5.setValue(StockInDoc.this);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                StockInScreenKt.StockInHistoryCard(stockInDoc, str2, StockInScreen$supplierName, z3, (Function0) rememberedValue, composer, StockInDoc.$stable);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInScreen$lambda$22$0$0(final double d, final String str, final FonRoApp FonRoApp, final AppNavigator appNavigator, final boolean z, final boolean z2, final List list, final Repo repo, final State state, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C349@13457L2501,343@13190L2768:StockInScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1877878657, i, -1, "uz.FonRo.pos.ui.docs.StockInScreen.<anonymous>.<anonymous>.<anonymous> (StockInScreen.kt:343)");
            }
            BasicsKt.m9833OxSoftCardCe4qNIY(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null), Dp.m6989constructorimpl(14.0f), OxShape.INSTANCE.getHero(), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10192getCyan0d7_KjU(), 0.1f), Ox.INSTANCE.m10242tintBorderl2rxGTc(Ox.INSTANCE.m10192getCyan0d7_KjU()), null, ComposableLambdaKt.rememberComposableLambda(347186311, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit StockInScreen$lambda$22$0$0$0;
                    StockInScreen$lambda$22$0$0$0 = StockInScreenKt.StockInScreen$lambda$22$0$0$0(d, str, FonRoApp, appNavigator, z, z2, list, repo, state, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return StockInScreen$lambda$22$0$0$0;
                }
            }, composer, 54), composer, 1572918, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInScreen$lambda$22$0$0$0(double d, String str, final FonRoApp FonRoApp, final AppNavigator appNavigator, boolean z, boolean z2, List list, Repo repo, State state, ColumnScope OxSoftCard, Composer composer, int i) {
        String tx;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C350@13475L440,359@13932L283,366@14232L512,374@14762L11,377@14858L41,375@14790L400,385@15207L10,388@15307L44,386@15234L453:StockInScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(347186311, i, -1, "uz.FonRo.pos.ui.docs.StockInScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StockInScreen.kt:350)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -792188523, "C351@13574L267,357@13862L35:StockInScreen.kt#1so789");
            if (z2) {
                tx = LangKt.tx("Стоимость склада по закупке", new Object[0]);
            } else {
                tx = LangKt.tx("Стоимость склада по продаже", new Object[0]);
            }
            TextKt.m2798Text4IGK_g(tx, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getLabel(), composer, 0, 0, 65532);
            BasicsKt.OxChip(LangKt.tx("Приход", new Object[0]), ChipTone.BLUE, null, composer, 48, 4);
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
            ComposerKt.sourceInformationMarkerStart(composer, -263354808, "C369@14477L68,370@14566L66,371@14653L73:StockInScreen.kt#1so789");
            m9919DocMiniStatuDo3WH8(rowScopeInstance2, String.valueOf(list.size()), LangKt.tx("Приходов", new Object[0]), Ox.INSTANCE.m10193getCyanDeep0d7_KjU(), null, composer, 6, 8);
            m9919DocMiniStatuDo3WH8(rowScopeInstance2, String.valueOf(StockInScreen$lambda$2(state).size()), LangKt.tx("Товаров", new Object[0]), Ox.INSTANCE.m10202getGreenDeep0d7_KjU(), null, composer, 6, 8);
            m9919DocMiniStatuDo3WH8(rowScopeInstance2, Fmt.INSTANCE.qf(Double.valueOf(repo.wholeStockUnits())), LangKt.tx("Остаток, шт", new Object[0]), Ox.INSTANCE.m10223getPurple0d7_KjU(), null, composer, 6, 8);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            String tx2 = LangKt.tx("Поставщики", new Object[0]);
            BtnStyle btnStyle = BtnStyle.OK;
            BtnSize btnSize = BtnSize.LG;
            ComposerKt.sourceInformationMarkerStart(composer, -1361359344, "CC(remember):StockInScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(FonRoApp) | composer.changedInstance(appNavigator);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda64
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit StockInScreen$lambda$22$0$0$0$2$0;
                        StockInScreen$lambda$22$0$0$0$2$0 = StockInScreenKt.StockInScreen$lambda$22$0$0$0$2$0(FonRoApp.this, appNavigator);
                        return StockInScreen$lambda$22$0$0$0$2$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx2, (Function0) rememberedValue, null, btnStyle, btnSize, false, true, ComposableSingletons$StockInScreenKt.INSTANCE.getLambda$1058676502$app(), composer, 14183424, 36);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer, 6);
            String tx3 = LangKt.tx("Добавить приход", new Object[0]);
            BtnStyle btnStyle2 = BtnStyle.PRIMARY;
            BtnSize btnSize2 = BtnSize.LG;
            ComposerKt.sourceInformationMarkerStart(composer, -1361344973, "CC(remember):StockInScreen.kt#9igjgp");
            boolean changedInstance2 = composer.changedInstance(FonRoApp) | composer.changedInstance(appNavigator);
            Object rememberedValue2 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda65
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit StockInScreen$lambda$22$0$0$0$3$0;
                        StockInScreen$lambda$22$0$0$0$3$0 = StockInScreenKt.StockInScreen$lambda$22$0$0$0$3$0(FonRoApp.this, appNavigator);
                        return StockInScreen$lambda$22$0$0$0$3$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx3, (Function0) rememberedValue2, null, btnStyle2, btnSize2, z, true, ComposableSingletons$StockInScreenKt.INSTANCE.m9883getLambda$878517875$app(), composer, 14183424, 4);
            if (!z) {
                composer.startReplaceGroup(748395036);
                ComposerKt.sourceInformation(composer, "398@15743L10,399@15774L152");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer, 6);
                TextKt.m2798Text4IGK_g(LangKt.tx("Приход доступен сотрудникам с правом «Приход».", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(748609339);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInScreen$lambda$22$0$0$0$2$0(FonRoApp FonRoApp, AppNavigator appNavigator) {
        MainShellKt.openRoute(FonRoApp, appNavigator, Routes.SUPPLIERS);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInScreen$lambda$22$0$0$0$3$0(FonRoApp FonRoApp, AppNavigator appNavigator) {
        MainShellKt.openRoute(FonRoApp, appNavigator, Routes.STOCK_IN_NEW);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInScreen$lambda$22$0$1(List list, MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C408@16013L167:StockInScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1175282818, i, -1, "uz.FonRo.pos.ui.docs.StockInScreen.<anonymous>.<anonymous>.<anonymous> (StockInScreen.kt:408)");
            }
            BasicsKt.OxSectionHead(LangKt.tx("История приходов", new Object[0]), null, StockInScreen$lambda$9(mutableState).title(), String.valueOf(list.size()), null, null, composer, 0, 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInScreen$lambda$22$0$2(final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C418@16311L15,425@16621L21,426@16673L20,416@16237L470:StockInScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(472686979, i, -1, "uz.FonRo.pos.ui.docs.StockInScreen.<anonymous>.<anonymous>.<anonymous> (StockInScreen.kt:416)");
            }
            PeriodState StockInScreen$lambda$9 = StockInScreen$lambda$9(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, -1014343726, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda56
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit StockInScreen$lambda$22$0$2$0$0;
                        StockInScreen$lambda$22$0$2$0$0 = StockInScreenKt.StockInScreen$lambda$22$0$2$0$0(MutableState.this, (PeriodState) obj);
                        return StockInScreen$lambda$22$0$2$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function1 function1 = (Function1) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null);
            ChipTint chipTint = ChipTint.CYAN;
            List listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(LangKt.tx("Сегодня", new Object[0]), PeriodKind.TODAY), TuplesKt.to(LangKt.tx("10 дней", new Object[0]), PeriodKind.DAYS_10)});
            ComposerKt.sourceInformationMarkerStart(composer, -1014333800, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda57
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit StockInScreen$lambda$22$0$2$1$0;
                        StockInScreen$lambda$22$0$2$1$0 = StockInScreenKt.StockInScreen$lambda$22$0$2$1$0(MutableState.this);
                        return StockInScreen$lambda$22$0$2$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            Function0 function0 = (Function0) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1014332137, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda58
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit StockInScreen$lambda$22$0$2$2$0;
                        StockInScreen$lambda$22$0$2$2$0 = StockInScreenKt.StockInScreen$lambda$22$0$2$2$0(MutableState.this);
                        return StockInScreen$lambda$22$0$2$2$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.OxPeriodChips(StockInScreen$lambda$9, function1, m1053paddingqDBjuR0$default, chipTint, listOf, function0, (Function0) rememberedValue3, composer, 1772976 | PeriodState.$stable, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInScreen$lambda$22$0$2$0$0(MutableState mutableState, PeriodState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInScreen$lambda$22$0$2$1$0(MutableState mutableState) {
        StockInScreen$lambda$13(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInScreen$lambda$22$0$2$2$0(MutableState mutableState) {
        StockInScreen$lambda$16(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInScreen$lambda$22$0$3(List list, MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C432@16804L170:StockInScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(546170277, i, -1, "uz.FonRo.pos.ui.docs.StockInScreen.<anonymous>.<anonymous>.<anonymous> (StockInScreen.kt:432)");
            }
            BasicsKt.OxEmptyNote(list.isEmpty() ? LangKt.tx("Приходов пока нет.", new Object[0]) : LangKt.tx("За «%s» приходов нет.", StockInScreen$lambda$9(mutableState).title()), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInScreen$lambda$23$0(MutableState mutableState) {
        StockInScreen$lambda$13(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInScreen$lambda$24$0(MutableState mutableState, MutableState mutableState2, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(PeriodState.copy$default(StockInScreen$lambda$9(mutableState), PeriodKind.MONTH, it, null, 4, null));
        StockInScreen$lambda$13(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInScreen$lambda$25$0(MutableState mutableState) {
        StockInScreen$lambda$16(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInScreen$lambda$26$0(MutableState mutableState, MutableState mutableState2, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(PeriodState.copy$default(StockInScreen$lambda$9(mutableState), PeriodKind.DATE, null, it, 2, null));
        StockInScreen$lambda$16(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInScreen$lambda$27$0$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    public static final void StockInNewScreen(FonRoApp FonRoApp, final AppNavigator nav, Composer composer, final int i) {
        ScopeUpdateScope endRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        final MutableState mutableState;
        final MutableState mutableState2;
        final MutableState mutableState3;
        final MutableState mutableState4;
        final Repo repo;
        boolean z;
        Object obj;
        boolean z2;
        final MutableState mutableState5;
        final MutableState mutableState6;
        Composer composer2;
        boolean z3;
        final MutableState mutableState7;
        final FonRoApp app = FonRoApp;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(nav, "nav");
        Composer startRestartGroup = composer.startRestartGroup(1637897339);
        ComposerKt.sourceInformation(startRestartGroup, "C(StockInNewScreen)502@19124L29,510@19328L29,511@19396L29,512@19462L29,513@19518L29,515@19565L24,516@19621L7,522@19957L7,524@19986L44,525@20050L31,526@20107L34,527@20158L31,528@20206L32,529@20256L59,531@20343L34,532@20403L34,533@20458L34,534@20508L49,535@20574L34,537@20635L95,537@20614L116,543@20839L69,543@20818L90,638@24273L8377,885@34503L14,885@34487L30:StockInScreen.kt#1so789");
        int i2 = (i & 6) == 0 ? ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2) | i : i;
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1637897339, i2, -1, "uz.FonRo.pos.ui.docs.StockInNewScreen (StockInScreen.kt:500)");
            }
            final Repo repo2 = app.getRepo();
            Store StockInNewScreen$lambda$0 = StockInNewScreen$lambda$0(FlowExtKt.collectAsStateWithLifecycle(repo2.getStore(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7));
            Paywall paywall = StockInNewScreen$lambda$0 != null ? StockInNewScreen$lambda$0.getPaywall() : null;
            if (paywall != null && paywall.isLocked()) {
                startRestartGroup.startReplaceGroup(-523604628);
                ComposerKt.sourceInformation(startRestartGroup, "506@19243L28");
                StockInPaywall(app, paywall, startRestartGroup, FonRoApp.$stable | (i2 & 14) | (Paywall.$stable << 3));
                startRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    function2 = new Function2() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda28
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return StockInScreenKt.StockInNewScreen$lambda$1(FonRoApp.this, nav, i, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    };
                    endRestartGroup.updateScope(function2);
                }
                return;
            }
            startRestartGroup.startReplaceGroup(-523547929);
            startRestartGroup.endReplaceGroup();
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(repo2.getProducts(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            State collectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(repo2.getCategories(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            State collectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(repo2.getSuppliers(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            State collectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(repo2.getSync(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
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
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Context context = (Context) consume;
            final String currency = repo2.currency();
            final boolean can = repo2.can(Perm.STOCK_IN);
            boolean can2 = repo2.can(Perm.VIEW_PURCHASE_PRICE);
            ProvidableCompositionLocal<Function0<Unit>> localPageClose = PageHeadKt.getLocalPageClose();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(localPageClose);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Function0 function0 = (Function0) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2061343591, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState8 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2061345626, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState9 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2061347453, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState10 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2061349082, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            MutableState mutableState11 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2061350619, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final MutableState mutableState12 = (MutableState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2061352246, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final MutableState mutableState13 = (MutableState) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2061355005, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            final MutableState mutableState14 = (MutableState) rememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2061356925, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                rememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            final MutableState mutableState15 = (MutableState) rememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2061358685, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                rememberedValue10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            final MutableState mutableState16 = (MutableState) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2061360300, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                rememberedValue11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            final MutableState mutableState17 = (MutableState) rememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2061362397, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue12 = startRestartGroup.rememberedValue();
            if (rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                rememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            MutableState mutableState18 = (MutableState) rememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2061364410, "CC(remember):StockInScreen.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(repo2);
            StockInScreenKt$StockInNewScreen$2$1 rememberedValue13 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                rememberedValue13 = new StockInScreenKt$StockInNewScreen$2$1(repo2, null);
                startRestartGroup.updateRememberedValue(rememberedValue13);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue13, startRestartGroup, 6);
            SyncData StockInNewScreen$lambda$5 = StockInNewScreen$lambda$5(collectAsStateWithLifecycle4);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2061370912, "CC(remember):StockInScreen.kt#9igjgp");
            boolean changed = startRestartGroup.changed(collectAsStateWithLifecycle4);
            StockInScreenKt$StockInNewScreen$3$1 rememberedValue14 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                rememberedValue14 = new StockInScreenKt$StockInNewScreen$3$1(mutableState10, collectAsStateWithLifecycle4, mutableState9, null);
                startRestartGroup.updateRememberedValue(rememberedValue14);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(StockInNewScreen$lambda$5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue14, startRestartGroup, SyncData.$stable);
            final MutableState mutableState19 = mutableState18;
            double d = AudioStats.AUDIO_AMPLITUDE_NONE;
            for (StockInLine stockInLine : StockInNewScreen$lambda$22(mutableState13)) {
                d += stockInLine.getQuantity() * stockInLine.getPurchase();
            }
            Iterator<T> it = StockInNewScreen$lambda$22(mutableState13).iterator();
            double d2 = AudioStats.AUDIO_AMPLITUDE_NONE;
            while (it.hasNext()) {
                d2 += ((StockInLine) it.next()).getQuantity();
            }
            int i3 = i2;
            final double d3 = d2;
            final double max = Math.max(d - StockInNewScreen$lambda$19(mutableState12), AudioStats.AUDIO_AMPLITUDE_NONE);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 680253112, "C639@24350L135,647@24620L6919,644@24495L7044,805@31549L1095:StockInScreen.kt#1so789");
            PageHeadKt.OxPageHead(LangKt.tx("Новый приход", new Object[0]), null, LangKt.tx("Выберите поставщика и товары, которые пришли", new Object[0]), false, null, startRestartGroup, 0, 26);
            Modifier weight$default = ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            PaddingValues m1046PaddingValuesa9UjIt4$default = PaddingKt.m1046PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1779164404, "CC(remember):StockInScreen.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(d3) | startRestartGroup.changed(d) | startRestartGroup.changed(currency) | startRestartGroup.changed(max) | startRestartGroup.changedInstance(context);
            Object rememberedValue15 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue15 == Composer.INSTANCE.getEmpty()) {
                final double d4 = d;
                mutableState = mutableState11;
                rememberedValue15 = new Function1() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit StockInNewScreen$lambda$45$0$0;
                        StockInNewScreen$lambda$45$0$0 = StockInScreenKt.StockInNewScreen$lambda$45$0$0(d3, d4, currency, mutableState13, max, mutableState12, mutableState8, mutableState14, mutableState9, mutableState10, mutableState, mutableState17, mutableState15, mutableState16, context, (LazyListScope) obj2);
                        return StockInNewScreen$lambda$45$0$0;
                    }
                };
                mutableState2 = mutableState14;
                mutableState3 = mutableState15;
                mutableState4 = mutableState16;
                startRestartGroup.updateRememberedValue(rememberedValue15);
            } else {
                mutableState = mutableState11;
                mutableState2 = mutableState14;
                mutableState3 = mutableState15;
                mutableState4 = mutableState16;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LazyDslKt.LazyColumn(weight$default, null, m1046PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) rememberedValue15, startRestartGroup, 384, TypedValues.PositionType.TYPE_PERCENT_X);
            Composer composer3 = startRestartGroup;
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(8.0f), 0.0f, Dp.m6989constructorimpl(12.0f), 5, null);
            ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, m1053paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor2);
            } else {
                composer3.useNode();
            }
            Composer m3808constructorimpl2 = Updater.m3808constructorimpl(composer3);
            Updater.m3815setimpl(m3808constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer3, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, 1889743898, "C806@31616L847:StockInScreen.kt#1so789");
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
            ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer3, 6);
            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer3, fillMaxWidth$default);
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
            Updater.m3815setimpl(m3808constructorimpl3, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer3, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, 785752468, "C821@32211L10,819@32105L344:StockInScreen.kt#1so789");
            if (!StockInNewScreen$lambda$22(mutableState13).isEmpty()) {
                composer3.startReplaceGroup(785764340);
                ComposerKt.sourceInformation(composer3, "813@31893L15,811@31819L251");
                String tx = LangKt.tx("Очистить", new Object[0]);
                ComposerKt.sourceInformationMarkerStart(composer3, 1410823354, "CC(remember):StockInScreen.kt#9igjgp");
                boolean changedInstance2 = composer3.changedInstance(repo2);
                Object rememberedValue16 = composer3.rememberedValue();
                if (changedInstance2 || rememberedValue16 == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState20 = mutableState;
                    Function0 function02 = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda32
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit StockInNewScreen$lambda$45$1$0$0$0;
                            StockInNewScreen$lambda$45$1$0$0$0 = StockInScreenKt.StockInNewScreen$lambda$45$1$0$0$0(Repo.this, mutableState13, mutableState8, mutableState20, mutableState12, mutableState10, mutableState9);
                            return StockInNewScreen$lambda$45$1$0$0$0;
                        }
                    };
                    repo = repo2;
                    composer3.updateRememberedValue(function02);
                    rememberedValue16 = function02;
                } else {
                    repo = repo2;
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                z = true;
                BasicsKt.OxButton(tx, (Function0) rememberedValue16, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), null, BtnSize.LG, !StockInNewScreen$lambda$37(mutableState19), false, null, composer3, 24576, 200);
                composer3 = composer3;
                composer3.endReplaceGroup();
            } else {
                repo = repo2;
                z = true;
                composer3.startReplaceGroup(786043991);
                composer3.endReplaceGroup();
            }
            String tx2 = StockInNewScreen$lambda$37(mutableState19) ? LangKt.tx("Сохраняем…", new Object[0]) : LangKt.tx("Сохранить приход", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer3, 1410833525, "CC(remember):StockInScreen.kt#9igjgp");
            boolean changed3 = composer3.changed(can) | composer3.changedInstance(coroutineScope) | composer3.changedInstance(repo) | composer3.changed(function0);
            Object rememberedValue17 = composer3.rememberedValue();
            if (changed3 || rememberedValue17 == Composer.INSTANCE.getEmpty()) {
                final Repo repo3 = repo;
                final MutableState mutableState21 = mutableState;
                obj = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda34
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit StockInNewScreen$lambda$45$1$0$1$0;
                        StockInNewScreen$lambda$45$1$0$1$0 = StockInScreenKt.StockInNewScreen$lambda$45$1$0$1$0(can, coroutineScope, mutableState19, mutableState13, repo3, function0, mutableState8, mutableState9, mutableState21, mutableState12, mutableState10);
                        return StockInNewScreen$lambda$45$1$0$1$0;
                    }
                };
                z2 = can;
                mutableState19 = mutableState19;
                mutableState5 = mutableState13;
                mutableState6 = mutableState8;
                composer3.updateRememberedValue(obj);
            } else {
                obj = rememberedValue17;
                z2 = can;
                mutableState5 = mutableState13;
                mutableState6 = mutableState8;
            }
            Function0 function03 = (Function0) obj;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            Modifier weight$default2 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 2.0f, false, 2, null);
            BtnStyle btnStyle = BtnStyle.PRIMARY;
            Composer composer4 = composer3;
            BtnSize btnSize = BtnSize.LG;
            if (!z2 || StockInNewScreen$lambda$37(mutableState19) || StockInNewScreen$lambda$22(mutableState5).isEmpty()) {
                composer2 = composer4;
                z3 = false;
            } else {
                composer2 = composer4;
                z3 = z;
            }
            BasicsKt.OxButton(tx2, function03, weight$default2, btnStyle, btnSize, z3, false, null, composer2, 27648, 192);
            startRestartGroup = composer2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (!z2) {
                startRestartGroup.startReplaceGroup(1890586694);
                ComposerKt.sourceInformation(startRestartGroup, "829@32511L10,830@32538L82");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), startRestartGroup, 6);
                TextKt.m2798Text4IGK_g(LangKt.tx("Приход доступен сотрудникам с правом «Приход».", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), startRestartGroup, 0, 0, 65534);
                startRestartGroup = startRestartGroup;
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1890722195);
                startRestartGroup.endReplaceGroup();
            }
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
            if (StockInNewScreen$lambda$25(mutableState2)) {
                startRestartGroup.startReplaceGroup(-510265669);
                ComposerKt.sourceInformation(startRestartGroup, "838@32763L17,839@32806L26,836@32686L156");
                List<Supplier> StockInNewScreen$lambda$4 = StockInNewScreen$lambda$4(collectAsStateWithLifecycle3);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2061752428, "CC(remember):StockInScreen.kt#9igjgp");
                Object rememberedValue18 = startRestartGroup.rememberedValue();
                if (rememberedValue18 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue18 = new Function1() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda35
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit StockInNewScreen$lambda$46$0;
                            StockInNewScreen$lambda$46$0 = StockInScreenKt.StockInNewScreen$lambda$46$0(MutableState.this, (Supplier) obj2);
                            return StockInNewScreen$lambda$46$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue18);
                }
                Function1 function1 = (Function1) rememberedValue18;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2061753813, "CC(remember):StockInScreen.kt#9igjgp");
                Object rememberedValue19 = startRestartGroup.rememberedValue();
                if (rememberedValue19 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue19 = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda36
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit StockInNewScreen$lambda$47$0;
                            StockInNewScreen$lambda$47$0 = StockInScreenKt.StockInNewScreen$lambda$47$0(MutableState.this);
                            return StockInNewScreen$lambda$47$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue19);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                SupplierPickerSheet(StockInNewScreen$lambda$4, function1, (Function0) rememberedValue19, startRestartGroup, 432);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-510100377);
                startRestartGroup.endReplaceGroup();
            }
            if (StockInNewScreen$lambda$28(mutableState3)) {
                startRestartGroup.startReplaceGroup(-510039028);
                ComposerKt.sourceInformation(startRestartGroup, "848@33033L25,854@33403L633,844@32883L1163");
                List<Product> StockInNewScreen$lambda$2 = StockInNewScreen$lambda$2(collectAsStateWithLifecycle);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2061761076, "CC(remember):StockInScreen.kt#9igjgp");
                Object rememberedValue20 = startRestartGroup.rememberedValue();
                if (rememberedValue20 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue20 = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda37
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit StockInNewScreen$lambda$48$0;
                            StockInNewScreen$lambda$48$0 = StockInScreenKt.StockInNewScreen$lambda$48$0(MutableState.this);
                            return StockInNewScreen$lambda$48$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue20);
                }
                Function0 function04 = (Function0) rememberedValue20;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                List<Category> StockInNewScreen$lambda$3 = StockInNewScreen$lambda$3(collectAsStateWithLifecycle2);
                List<StockInLine> StockInNewScreen$lambda$22 = StockInNewScreen$lambda$22(mutableState5);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(StockInNewScreen$lambda$22, 10));
                Iterator<T> it2 = StockInNewScreen$lambda$22.iterator();
                while (it2.hasNext()) {
                    arrayList.add(Long.valueOf(((StockInLine) it2.next()).getProduct().getId()));
                }
                Set set = CollectionsKt.toSet(arrayList);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2061773524, "CC(remember):StockInScreen.kt#9igjgp");
                Object rememberedValue21 = startRestartGroup.rememberedValue();
                if (rememberedValue21 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue21 = new Function1() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda38
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit StockInNewScreen$lambda$50$0;
                            StockInNewScreen$lambda$50$0 = StockInScreenKt.StockInNewScreen$lambda$50$0(MutableState.this, (List) obj2);
                            return StockInNewScreen$lambda$50$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue21);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Composer composer5 = startRestartGroup;
                ProductPickerSheet(StockInNewScreen$lambda$2, currency, can2, function04, StockInNewScreen$lambda$3, set, false, null, (Function1) rememberedValue21, composer5, 100666368, 192);
                startRestartGroup = composer5;
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-508906009);
                startRestartGroup.endReplaceGroup();
            }
            if (StockInNewScreen$lambda$31(mutableState4)) {
                startRestartGroup.startReplaceGroup(-508873490);
                ComposerKt.sourceInformation(startRestartGroup, "873@34141L20,874@34184L281,871@34082L393");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2061796527, "CC(remember):StockInScreen.kt#9igjgp");
                Object rememberedValue22 = startRestartGroup.rememberedValue();
                if (rememberedValue22 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue22 = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda39
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit StockInNewScreen$lambda$51$0;
                            StockInNewScreen$lambda$51$0 = StockInScreenKt.StockInNewScreen$lambda$51$0(MutableState.this);
                            return StockInNewScreen$lambda$51$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue22);
                }
                Function0 function05 = (Function0) rememberedValue22;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2061798164, "CC(remember):StockInScreen.kt#9igjgp");
                boolean changedInstance3 = startRestartGroup.changedInstance(repo);
                Object rememberedValue23 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue23 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue23 = new Function1() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda40
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit StockInNewScreen$lambda$52$0;
                            StockInNewScreen$lambda$52$0 = StockInScreenKt.StockInNewScreen$lambda$52$0(Repo.this, mutableState5, mutableState4, (String) obj2);
                            return StockInNewScreen$lambda$52$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue23);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                mutableState7 = mutableState17;
                app = FonRoApp;
                ScannerSheetKt.ScannerSheet(app, function05, null, (Function1) rememberedValue23, startRestartGroup, FonRoApp.$stable | 48 | (i3 & 14), 4);
                startRestartGroup.endReplaceGroup();
            } else {
                app = FonRoApp;
                mutableState7 = mutableState17;
                startRestartGroup.startReplaceGroup(-508480441);
                startRestartGroup.endReplaceGroup();
            }
            NumPadRequest StockInNewScreen$lambda$34 = StockInNewScreen$lambda$34(mutableState7);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2061808105, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue24 = startRestartGroup.rememberedValue();
            if (rememberedValue24 == Composer.INSTANCE.getEmpty()) {
                rememberedValue24 = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit StockInNewScreen$lambda$53$0;
                        StockInNewScreen$lambda$53$0 = StockInScreenKt.StockInNewScreen$lambda$53$0(MutableState.this);
                        return StockInNewScreen$lambda$53$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue24);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            NumPadHost(StockInNewScreen$lambda$34, (Function0) rememberedValue24, startRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            function2 = new Function2() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return StockInScreenKt.StockInNewScreen$lambda$54(FonRoApp.this, nav, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            endRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Supplier StockInNewScreen$lambda$7(MutableState<Supplier> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String StockInNewScreen$lambda$10(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean StockInNewScreen$lambda$13(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void StockInNewScreen$lambda$14(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String StockInNewScreen$lambda$16(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double StockInNewScreen$lambda$19(MutableState<Double> mutableState) {
        return mutableState.getValue().doubleValue();
    }

    private static final void StockInNewScreen$lambda$20(MutableState<Double> mutableState, double d) {
        mutableState.setValue(Double.valueOf(d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<StockInLine> StockInNewScreen$lambda$22(MutableState<List<StockInLine>> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean StockInNewScreen$lambda$25(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void StockInNewScreen$lambda$26(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean StockInNewScreen$lambda$28(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void StockInNewScreen$lambda$29(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean StockInNewScreen$lambda$31(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void StockInNewScreen$lambda$32(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final NumPadRequest StockInNewScreen$lambda$34(MutableState<NumPadRequest> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean StockInNewScreen$lambda$37(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StockInNewScreen$lambda$38(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void StockInNewScreen$addProduct(MutableState<List<StockInLine>> mutableState, Product product) {
        List<StockInLine> StockInNewScreen$lambda$22 = StockInNewScreen$lambda$22(mutableState);
        if (!(StockInNewScreen$lambda$22 instanceof Collection) || !StockInNewScreen$lambda$22.isEmpty()) {
            Iterator<T> it = StockInNewScreen$lambda$22.iterator();
            while (it.hasNext()) {
                if (((StockInLine) it.next()).getProduct().getId() == product.getId()) {
                    Toaster.INSTANCE.error(LangKt.tx("«%s» уже в документе", product.getName()));
                    return;
                }
            }
        }
        mutableState.setValue(CollectionsKt.plus((Collection<? extends StockInLine>) StockInNewScreen$lambda$22(mutableState), new StockInLine(product, AudioStats.AUDIO_AMPLITUDE_NONE, product.getPurchasePrice(), product.getSalePrice(), null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StockInNewScreen$updateLine(MutableState<List<StockInLine>> mutableState, long j, Function1<? super StockInLine, StockInLine> function1) {
        List<StockInLine> StockInNewScreen$lambda$22 = StockInNewScreen$lambda$22(mutableState);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(StockInNewScreen$lambda$22, 10));
        for (StockInLine stockInLine : StockInNewScreen$lambda$22) {
            if (stockInLine.getProduct().getId() == j) {
                stockInLine = function1.invoke(stockInLine);
            }
            arrayList.add(stockInLine);
        }
        mutableState.setValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StockInNewScreen$clearForm(Repo repo, MutableState<List<StockInLine>> mutableState, MutableState<Supplier> mutableState2, MutableState<String> mutableState3, MutableState<Double> mutableState4, MutableState<Boolean> mutableState5, MutableState<String> mutableState6) {
        mutableState.setValue(CollectionsKt.emptyList());
        mutableState2.setValue(null);
        mutableState3.setValue("");
        StockInNewScreen$lambda$20(mutableState4, AudioStats.AUDIO_AMPLITUDE_NONE);
        StockInNewScreen$lambda$14(mutableState5, false);
        mutableState6.setValue(nextInvoiceNumber(repo.getSync().getValue()));
    }

    private static final void StockInNewScreen$save(boolean z, CoroutineScope coroutineScope, MutableState<Boolean> mutableState, MutableState<List<StockInLine>> mutableState2, Repo repo, Function0<Unit> function0, MutableState<Supplier> mutableState3, MutableState<String> mutableState4, MutableState<String> mutableState5, MutableState<Double> mutableState6, MutableState<Boolean> mutableState7) {
        if (StockInNewScreen$lambda$37(mutableState)) {
            return;
        }
        if (!z) {
            Toaster.INSTANCE.error(LangKt.tx("Нет права на приход", new Object[0]));
        } else if (StockInNewScreen$lambda$22(mutableState2).isEmpty()) {
            Toaster.INSTANCE.error(LangKt.tx("Добавьте хотя бы один товар", new Object[0]));
        } else {
            StockInNewScreen$lambda$38(mutableState, true);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new StockInScreenKt$StockInNewScreen$save$1(repo, function0, mutableState3, mutableState4, mutableState5, mutableState6, mutableState2, mutableState7, mutableState, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInNewScreen$lambda$45$0$0(final double d, final double d2, final String str, final MutableState mutableState, final double d3, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, final MutableState mutableState8, final MutableState mutableState9, final MutableState mutableState10, final Context context, LazyListScope LazyColumn) {
        final MutableState mutableState11;
        LazyListScope lazyListScope;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, "summary", null, ComposableLambdaKt.composableLambdaInstance(1606816208, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda67
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit StockInNewScreen$lambda$45$0$0$0;
                StockInNewScreen$lambda$45$0$0$0 = StockInScreenKt.StockInNewScreen$lambda$45$0$0$0(d, d2, str, mutableState, d3, mutableState2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return StockInNewScreen$lambda$45$0$0$0;
            }
        }), 2, null);
        LazyListScope.item$default(LazyColumn, "form-top", null, ComposableLambdaKt.composableLambdaInstance(1886874041, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda68
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit StockInNewScreen$lambda$45$0$0$1;
                StockInNewScreen$lambda$45$0$0$1 = StockInScreenKt.StockInNewScreen$lambda$45$0$0$1(MutableState.this, mutableState4, mutableState5, mutableState6, mutableState7, mutableState2, mutableState8, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return StockInNewScreen$lambda$45$0$0$1;
            }
        }), 2, null);
        LazyListScope.item$default(LazyColumn, "add", null, ComposableLambdaKt.composableLambdaInstance(-697442408, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda69
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit StockInNewScreen$lambda$45$0$0$2;
                StockInNewScreen$lambda$45$0$0$2 = StockInScreenKt.StockInNewScreen$lambda$45$0$0$2(MutableState.this, mutableState10, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return StockInNewScreen$lambda$45$0$0$2;
            }
        }), 2, null);
        if (StockInNewScreen$lambda$22(mutableState).isEmpty()) {
            LazyListScope.item$default(LazyColumn, "form-empty", null, ComposableSingletons$StockInScreenKt.INSTANCE.m9881getLambda$1239575787$app(), 2, null);
            mutableState11 = mutableState;
            lazyListScope = LazyColumn;
        } else {
            mutableState11 = mutableState;
            LazyListScope.item$default(LazyColumn, "lines-head", null, ComposableLambdaKt.composableLambdaInstance(-1191358804, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda70
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit StockInNewScreen$lambda$45$0$0$3;
                    StockInNewScreen$lambda$45$0$0$3 = StockInScreenKt.StockInNewScreen$lambda$45$0$0$3(MutableState.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return StockInNewScreen$lambda$45$0$0$3;
                }
            }), 2, null);
            lazyListScope = LazyColumn;
        }
        final List<StockInLine> StockInNewScreen$lambda$22 = StockInNewScreen$lambda$22(mutableState11);
        final Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda71
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object StockInNewScreen$lambda$45$0$0$4;
                StockInNewScreen$lambda$45$0$0$4 = StockInScreenKt.StockInNewScreen$lambda$45$0$0$4((StockInLine) obj);
                return StockInNewScreen$lambda$45$0$0$4;
            }
        };
        final StockInScreenKt$StockInNewScreen$lambda$45$0$0$$inlined$items$default$1 stockInScreenKt$StockInNewScreen$lambda$45$0$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$StockInNewScreen$lambda$45$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(StockInLine stockInLine) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((StockInLine) obj);
            }
        };
        final MutableState mutableState12 = mutableState11;
        lazyListScope.items(StockInNewScreen$lambda$22.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$StockInNewScreen$lambda$45$0$0$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(StockInNewScreen$lambda$22.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$StockInNewScreen$lambda$45$0$0$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(StockInNewScreen$lambda$22.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$StockInNewScreen$lambda$45$0$0$$inlined$items$default$4
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
                final StockInLine stockInLine = (StockInLine) StockInNewScreen$lambda$22.get(i);
                composer.startReplaceGroup(1770129653);
                ComposerKt.sourceInformation(composer, "C*773@30000L447,782@30482L249,787@30762L238,792@31037L215,797@31294L106,800@31433L64,770@29876L1639:StockInScreen.kt#1so789");
                String str2 = str;
                ComposerKt.sourceInformationMarkerStart(composer, 1719671718, "CC(remember):StockInScreen.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(stockInLine);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState13 = mutableState12;
                    final MutableState mutableState14 = mutableState8;
                    rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$StockInNewScreen$4$1$1$6$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            MutableState<NumPadRequest> mutableState15 = mutableState14;
                            String str3 = StockInLine.this.getProduct().getName() + LangKt.tx(" — количество", new Object[0]);
                            double quantity = StockInLine.this.getQuantity();
                            boolean isMeasurable = Units.INSTANCE.isMeasurable(StockInLine.this.getProduct().getUnit());
                            final StockInLine stockInLine2 = StockInLine.this;
                            final MutableState<List<StockInLine>> mutableState16 = mutableState13;
                            mutableState15.setValue(new NumPadRequest(str3, quantity, isMeasurable, new Function1<Double, Unit>() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$StockInNewScreen$4$1$1$6$1$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Double d4) {
                                    invoke(d4.doubleValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(final double d4) {
                                    StockInScreenKt.StockInNewScreen$updateLine(mutableState16, StockInLine.this.getProduct().getId(), new Function1<StockInLine, StockInLine>() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt.StockInNewScreen.4.1.1.6.1.1.1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final StockInLine invoke(StockInLine it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            return StockInLine.copy$default(it, null, Num.INSTANCE.qty(Math.max(d4, AudioStats.AUDIO_AMPLITUDE_NONE)), AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, null, 29, null);
                                        }
                                    });
                                }
                            }));
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                Function0 function0 = (Function0) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 1719686944, "CC(remember):StockInScreen.kt#9igjgp");
                boolean changedInstance2 = composer.changedInstance(stockInLine);
                Object rememberedValue2 = composer.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState15 = mutableState12;
                    final MutableState mutableState16 = mutableState8;
                    rememberedValue2 = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$StockInNewScreen$4$1$1$6$2$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            MutableState<NumPadRequest> mutableState17 = mutableState16;
                            String tx = LangKt.tx("Закупочная цена", new Object[0]);
                            double purchase = StockInLine.this.getPurchase();
                            final StockInLine stockInLine2 = StockInLine.this;
                            final MutableState<List<StockInLine>> mutableState18 = mutableState15;
                            mutableState17.setValue(new NumPadRequest(tx, purchase, false, new Function1<Double, Unit>() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$StockInNewScreen$4$1$1$6$2$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Double d4) {
                                    invoke(d4.doubleValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(final double d4) {
                                    StockInScreenKt.StockInNewScreen$updateLine(mutableState18, StockInLine.this.getProduct().getId(), new Function1<StockInLine, StockInLine>() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt.StockInNewScreen.4.1.1.6.2.1.1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final StockInLine invoke(StockInLine it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            return StockInLine.copy$default(it, null, AudioStats.AUDIO_AMPLITUDE_NONE, Num.INSTANCE.money(Math.max(d4, AudioStats.AUDIO_AMPLITUDE_NONE)), AudioStats.AUDIO_AMPLITUDE_NONE, null, 27, null);
                                        }
                                    });
                                }
                            }, 4, null));
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                Function0 function02 = (Function0) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 1719695893, "CC(remember):StockInScreen.kt#9igjgp");
                boolean changedInstance3 = composer.changedInstance(stockInLine);
                Object rememberedValue3 = composer.rememberedValue();
                if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState17 = mutableState12;
                    final MutableState mutableState18 = mutableState8;
                    rememberedValue3 = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$StockInNewScreen$4$1$1$6$3$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            MutableState<NumPadRequest> mutableState19 = mutableState18;
                            String tx = LangKt.tx("Цена продажи", new Object[0]);
                            double sale = StockInLine.this.getSale();
                            final StockInLine stockInLine2 = StockInLine.this;
                            final MutableState<List<StockInLine>> mutableState20 = mutableState17;
                            mutableState19.setValue(new NumPadRequest(tx, sale, false, new Function1<Double, Unit>() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$StockInNewScreen$4$1$1$6$3$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Double d4) {
                                    invoke(d4.doubleValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(final double d4) {
                                    StockInScreenKt.StockInNewScreen$updateLine(mutableState20, StockInLine.this.getProduct().getId(), new Function1<StockInLine, StockInLine>() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt.StockInNewScreen.4.1.1.6.3.1.1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final StockInLine invoke(StockInLine it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            return StockInLine.copy$default(it, null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, Num.INSTANCE.money(Math.max(d4, AudioStats.AUDIO_AMPLITUDE_NONE)), null, 23, null);
                                        }
                                    });
                                }
                            }, 4, null));
                        }
                    };
                    composer.updateRememberedValue(rememberedValue3);
                }
                Function0 function03 = (Function0) rememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 1719704670, "CC(remember):StockInScreen.kt#9igjgp");
                boolean changedInstance4 = composer.changedInstance(context) | composer.changedInstance(stockInLine);
                Object rememberedValue4 = composer.rememberedValue();
                if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    final Context context2 = context;
                    final MutableState mutableState19 = mutableState12;
                    rememberedValue4 = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$StockInNewScreen$4$1$1$6$4$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Context context3 = context2;
                            String expiration = stockInLine.getExpiration();
                            final StockInLine stockInLine2 = stockInLine;
                            final MutableState<List<StockInLine>> mutableState20 = mutableState19;
                            StockInScreenKt.pickExpiration(context3, expiration, new Function1<String, Unit>() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$StockInNewScreen$4$1$1$6$4$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                                    invoke2(str3);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(final String picked) {
                                    Intrinsics.checkNotNullParameter(picked, "picked");
                                    StockInScreenKt.StockInNewScreen$updateLine(mutableState20, StockInLine.this.getProduct().getId(), new Function1<StockInLine, StockInLine>() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt.StockInNewScreen.4.1.1.6.4.1.1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final StockInLine invoke(StockInLine it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            return StockInLine.copy$default(it, null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, picked, 15, null);
                                        }
                                    });
                                }
                            });
                        }
                    };
                    composer.updateRememberedValue(rememberedValue4);
                }
                Function0 function04 = (Function0) rememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 1719712785, "CC(remember):StockInScreen.kt#9igjgp");
                boolean changedInstance5 = composer.changedInstance(stockInLine);
                Object rememberedValue5 = composer.rememberedValue();
                if (changedInstance5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState20 = mutableState12;
                    rememberedValue5 = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$StockInNewScreen$4$1$1$6$5$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            StockInScreenKt.StockInNewScreen$updateLine(mutableState20, StockInLine.this.getProduct().getId(), new Function1<StockInLine, StockInLine>() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$StockInNewScreen$4$1$1$6$5$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public final StockInLine invoke(StockInLine it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    return StockInLine.copy$default(it, null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, null, 15, null);
                                }
                            });
                        }
                    };
                    composer.updateRememberedValue(rememberedValue5);
                }
                Function0 function05 = (Function0) rememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 1719717191, "CC(remember):StockInScreen.kt#9igjgp");
                boolean changedInstance6 = composer.changedInstance(stockInLine);
                Object rememberedValue6 = composer.rememberedValue();
                if (changedInstance6 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState21 = mutableState12;
                    rememberedValue6 = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$StockInNewScreen$4$1$1$6$6$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            List StockInNewScreen$lambda$222;
                            MutableState<List<StockInLine>> mutableState22 = mutableState21;
                            StockInNewScreen$lambda$222 = StockInScreenKt.StockInNewScreen$lambda$22(mutableState22);
                            StockInLine stockInLine2 = stockInLine;
                            ArrayList arrayList = new ArrayList();
                            for (Object obj : StockInNewScreen$lambda$222) {
                                if (((StockInLine) obj).getProduct().getId() != stockInLine2.getProduct().getId()) {
                                    arrayList.add(obj);
                                }
                            }
                            mutableState22.setValue(arrayList);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                StockInScreenKt.StockInLineCard(stockInLine, str2, function0, function02, function03, function04, function05, (Function0) rememberedValue6, composer, Product.$stable);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInNewScreen$lambda$45$0$0$0(final double d, final double d2, final String str, final MutableState mutableState, final double d3, final MutableState mutableState2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C653@24845L1137,649@24668L1314:StockInScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1606816208, i, -1, "uz.FonRo.pos.ui.docs.StockInNewScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StockInScreen.kt:649)");
            }
            BasicsKt.m9833OxSoftCardCe4qNIY(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null), Dp.m6989constructorimpl(12.0f), OxShape.INSTANCE.getCardSoft(), 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1201951606, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit StockInNewScreen$lambda$45$0$0$0$0;
                    StockInNewScreen$lambda$45$0$0$0$0 = StockInScreenKt.StockInNewScreen$lambda$45$0$0$0$0(d, d2, str, mutableState, d3, mutableState2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return StockInNewScreen$lambda$45$0$0$0$0;
                }
            }, composer, 54), composer, 1572918, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInNewScreen$lambda$45$0$0$0$0(double d, double d2, String str, MutableState mutableState, double d3, MutableState mutableState2, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C654@24867L556,666@25444L10,667@25475L489:StockInScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1201951606, i, -1, "uz.FonRo.pos.ui.docs.StockInNewScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StockInScreen.kt:654)");
            }
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
            ComposerKt.sourceInformationMarkerStart(composer, -1719048808, "C658@25044L62,659@25131L58,660@25214L187:StockInScreen.kt#1so789");
            m9919DocMiniStatuDo3WH8(rowScopeInstance, String.valueOf(StockInNewScreen$lambda$22(mutableState).size()), LangKt.tx("Позиций", new Object[0]), Ox.INSTANCE.m10193getCyanDeep0d7_KjU(), null, composer, 6, 8);
            m9919DocMiniStatuDo3WH8(rowScopeInstance, Fmt.INSTANCE.qf(Double.valueOf(d)), LangKt.tx("Количество", new Object[0]), Ox.INSTANCE.m10215getOrangeInk0d7_KjU(), null, composer, 6, 8);
            m9919DocMiniStatuDo3WH8(rowScopeInstance, Fmt.INSTANCE.money(Double.valueOf(Num.INSTANCE.money(d2)), str), LangKt.tx("Сумма", new Object[0]), Ox.INSTANCE.m10202getGreenDeep0d7_KjU(), null, composer, 6, 8);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer, 6);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), composer, 6);
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
            ComposerKt.sourceInformationMarkerStart(composer, 525757874, "C671@25652L50,672@25727L215:StockInScreen.kt#1so789");
            m9919DocMiniStatuDo3WH8(rowScopeInstance2, Fmt.INSTANCE.nf(Double.valueOf(StockInNewScreen$lambda$19(mutableState2))), LangKt.tx("Оплачено", new Object[0]), Ox.INSTANCE.m10186getBlue0d7_KjU(), null, composer, 6, 8);
            m9919DocMiniStatuDo3WH8(rowScopeInstance2, Fmt.INSTANCE.nf(Double.valueOf(Num.INSTANCE.money(d3))), LangKt.tx("Долг поставщику", new Object[0]), d3 > AudioStats.AUDIO_AMPLITUDE_NONE ? Ox.INSTANCE.m10215getOrangeInk0d7_KjU() : Ox.INSTANCE.m10202getGreenDeep0d7_KjU(), null, composer, 6, 8);
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
    public static final Unit StockInNewScreen$lambda$45$0$0$1(final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C686@26222L1529,682@26045L1706:StockInScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1886874041, i, -1, "uz.FonRo.pos.ui.docs.StockInNewScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StockInScreen.kt:682)");
            }
            BasicsKt.m9833OxSoftCardCe4qNIY(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null), Dp.m6989constructorimpl(12.0f), OxShape.INSTANCE.getCardSoft(), 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-99533325, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit StockInNewScreen$lambda$45$0$0$1$0;
                    StockInNewScreen$lambda$45$0$0$1$0 = StockInScreenKt.StockInNewScreen$lambda$45$0$0$1$0(MutableState.this, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6, mutableState7, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return StockInNewScreen$lambda$45$0$0$1$0;
                }
            }, composer, 54), composer, 1572918, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInNewScreen$lambda$45$0$0$1$0(MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, ColumnScope OxSoftCard, Composer composer, int i) {
        String tx;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C690@26410L25,687@26244L363,697@26773L38,694@26628L291,704@27074L13,701@26940L340,712@27445L215,709@27301L432:StockInScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-99533325, i, -1, "uz.FonRo.pos.ui.docs.StockInNewScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StockInScreen.kt:687)");
            }
            String tx2 = LangKt.tx("Поставщик:", new Object[0]);
            Supplier StockInNewScreen$lambda$7 = StockInNewScreen$lambda$7(mutableState);
            if (StockInNewScreen$lambda$7 == null || (tx = StockInNewScreen$lambda$7.getName()) == null) {
                tx = LangKt.tx("не выбран", new Object[0]);
            }
            long m10200getDim20d7_KjU = StockInNewScreen$lambda$7(mutableState) == null ? Ox.INSTANCE.m10200getDim20d7_KjU() : Ox.INSTANCE.m10233getText0d7_KjU();
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null);
            ComposerKt.sourceInformationMarkerStart(composer, -1162238772, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda55
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit StockInNewScreen$lambda$45$0$0$1$0$0$0;
                        StockInNewScreen$lambda$45$0$0$1$0$0$0 = StockInScreenKt.StockInNewScreen$lambda$45$0$0$1$0$0$0(MutableState.this);
                        return StockInNewScreen$lambda$45$0$0$1$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9849OxValueButtonFHprtrg(tx2, tx, (Function0) rememberedValue, m1053paddingqDBjuR0$default, m10200getDim20d7_KjU, null, composer, 3456, 32);
            String tx3 = LangKt.tx("Номер накладной", new Object[0]);
            String StockInNewScreen$lambda$10 = StockInNewScreen$lambda$10(mutableState3);
            ComposerKt.sourceInformationMarkerStart(composer, -1162227143, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda66
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit StockInNewScreen$lambda$45$0$0$1$0$1$0;
                        StockInNewScreen$lambda$45$0$0$1$0$1$0 = StockInScreenKt.StockInNewScreen$lambda$45$0$0$1$0$1$0(MutableState.this, mutableState4, (String) obj);
                        return StockInNewScreen$lambda$45$0$0$1$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9846OxFieldDfSPO0(tx3, StockInNewScreen$lambda$10, (Function1) rememberedValue2, null, "0001", 0, 0, null, false, false, false, false, false, 40, null, composer, 24960, 3072, 24552);
            String tx4 = LangKt.tx("Заметка", new Object[0]);
            String StockInNewScreen$lambda$16 = StockInNewScreen$lambda$16(mutableState5);
            ComposerKt.sourceInformationMarkerStart(composer, -1162217536, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda77
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit StockInNewScreen$lambda$45$0$0$1$0$2$0;
                        StockInNewScreen$lambda$45$0$0$1$0$2$0 = StockInScreenKt.StockInNewScreen$lambda$45$0$0$1$0$2$0(MutableState.this, (String) obj);
                        return StockInNewScreen$lambda$45$0$0$1$0$2$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9846OxFieldDfSPO0(tx4, StockInNewScreen$lambda$16, (Function1) rememberedValue3, null, LangKt.tx("Например: привезли утром, коробка помята", new Object[0]), 0, 0, null, false, false, false, false, false, 240, null, composer, 805306752, 3072, 24040);
            String tx5 = LangKt.tx("Оплачено:", new Object[0]);
            String nf = Fmt.INSTANCE.nf(Double.valueOf(StockInNewScreen$lambda$19(mutableState6)));
            ComposerKt.sourceInformationMarkerStart(composer, -1162205462, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue4 = composer.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda78
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit StockInNewScreen$lambda$45$0$0$1$0$3$0;
                        StockInNewScreen$lambda$45$0$0$1$0$3$0 = StockInScreenKt.StockInNewScreen$lambda$45$0$0$1$0$3$0(MutableState.this, mutableState7);
                        return StockInNewScreen$lambda$45$0$0$1$0$3$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9849OxValueButtonFHprtrg(tx5, nf, (Function0) rememberedValue4, null, Ox.INSTANCE.m10202getGreenDeep0d7_KjU(), null, composer, 384, 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInNewScreen$lambda$45$0$0$1$0$0$0(MutableState mutableState) {
        StockInNewScreen$lambda$26(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInNewScreen$lambda$45$0$0$1$0$1$0(MutableState mutableState, MutableState mutableState2, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        StockInNewScreen$lambda$14(mutableState2, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInNewScreen$lambda$45$0$0$1$0$2$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInNewScreen$lambda$45$0$0$1$0$3$0(final MutableState mutableState, MutableState mutableState2) {
        mutableState2.setValue(new NumPadRequest(LangKt.tx("Оплачено поставщику", new Object[0]), StockInNewScreen$lambda$19(mutableState), false, new Function1() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda76
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit StockInNewScreen$lambda$45$0$0$1$0$3$0$0;
                StockInNewScreen$lambda$45$0$0$1$0$3$0$0 = StockInScreenKt.StockInNewScreen$lambda$45$0$0$1$0$3$0$0(MutableState.this, ((Double) obj).doubleValue());
                return StockInNewScreen$lambda$45$0$0$1$0$3$0$0;
            }
        }, 4, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInNewScreen$lambda$45$0$0$1$0$3$0$0(MutableState mutableState, double d) {
        StockInNewScreen$lambda$20(mutableState, Num.INSTANCE.money(Math.max(d, AudioStats.AUDIO_AMPLITUDE_NONE)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInNewScreen$lambda$45$0$0$2(final MutableState mutableState, final MutableState mutableState2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C723@27809L1413:StockInScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-697442408, i, -1, "uz.FonRo.pos.ui.docs.StockInNewScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StockInScreen.kt:723)");
            }
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
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
            ComposerKt.sourceInformationMarkerStart(composer, 1356886276, "C730@28153L24,728@28073L444,744@28860L19,744@28854L25,738@28538L666:StockInScreen.kt#1so789");
            String tx = LangKt.tx("Добавить товар", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -2034438004, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit StockInNewScreen$lambda$45$0$0$2$0$0$0;
                        StockInNewScreen$lambda$45$0$0$2$0$0$0 = StockInScreenKt.StockInNewScreen$lambda$45$0$0$2$0$0$0(MutableState.this);
                        return StockInNewScreen$lambda$45$0$0$2$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, false, false, ComposableSingletons$StockInScreenKt.INSTANCE.m9882getLambda$1574428027$app(), composer, 12610608, 96);
            Modifier m569borderxT4_qwU = BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(50.0f)), OxShape.INSTANCE.getField()), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10192getCyan0d7_KjU(), 0.14f), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10242tintBorderl2rxGTc(Ox.INSTANCE.m10192getCyan0d7_KjU()), OxShape.INSTANCE.getField());
            ComposerKt.sourceInformationMarkerStart(composer, -2034415385, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit StockInNewScreen$lambda$45$0$0$2$0$1$0;
                        StockInNewScreen$lambda$45$0$0$2$0$1$0 = StockInScreenKt.StockInNewScreen$lambda$45$0$0$2$0$1$0(MutableState.this);
                        return StockInNewScreen$lambda$45$0$0$2$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier oxTap = ModifiersKt.oxTap(m569borderxT4_qwU, false, (Function0) rememberedValue2, composer, 384, 1);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, oxTap);
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
            Updater.m3815setimpl(m3808constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -2073635084, "C747@28989L193:StockInScreen.kt#1so789");
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getScan(), LangKt.tx("Сканировать", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(21.0f)), Ox.INSTANCE.m10193getCyanDeep0d7_KjU(), composer, 384, 0);
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
    public static final Unit StockInNewScreen$lambda$45$0$0$2$0$0$0(MutableState mutableState) {
        StockInNewScreen$lambda$29(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInNewScreen$lambda$45$0$0$2$0$1$0(MutableState mutableState) {
        StockInNewScreen$lambda$32(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInNewScreen$lambda$45$0$0$3(MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C761@29504L252:StockInScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1191358804, i, -1, "uz.FonRo.pos.ui.docs.StockInNewScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StockInScreen.kt:761)");
            }
            BasicsKt.OxSectionHead(LangKt.tx("Позиции документа", new Object[0]), null, LangKt.tx("Количество можно оставить 0 — тогда приход только изменит цены", new Object[0]), String.valueOf(StockInNewScreen$lambda$22(mutableState).size()), null, null, composer, 0, 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object StockInNewScreen$lambda$45$0$0$4(StockInLine it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "line-" + it.getProduct().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInNewScreen$lambda$45$1$0$0$0(Repo repo, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6) {
        StockInNewScreen$clearForm(repo, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInNewScreen$lambda$45$1$0$1$0(boolean z, CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, Repo repo, Function0 function0, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7) {
        StockInNewScreen$save(z, coroutineScope, mutableState, mutableState2, repo, function0, mutableState3, mutableState4, mutableState5, mutableState6, mutableState7);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInNewScreen$lambda$46$0(MutableState mutableState, Supplier supplier) {
        mutableState.setValue(supplier);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInNewScreen$lambda$47$0(MutableState mutableState) {
        StockInNewScreen$lambda$26(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInNewScreen$lambda$48$0(MutableState mutableState) {
        StockInNewScreen$lambda$29(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInNewScreen$lambda$50$0(MutableState mutableState, List chosen) {
        Intrinsics.checkNotNullParameter(chosen, "chosen");
        List<StockInLine> StockInNewScreen$lambda$22 = StockInNewScreen$lambda$22(mutableState);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(StockInNewScreen$lambda$22, 10));
        Iterator<T> it = StockInNewScreen$lambda$22.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((StockInLine) it.next()).getProduct().getId()));
        }
        Set set = CollectionsKt.toSet(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : chosen) {
            if (!set.contains(Long.valueOf(((Product) obj).getId()))) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            StockInNewScreen$addProduct(mutableState, (Product) it2.next());
        }
        if (!arrayList3.isEmpty()) {
            Toaster.INSTANCE.ok(LangKt.tx("Добавлено: ", new Object[0]) + Fmt.INSTANCE.plural(arrayList3.size(), LangKt.tx("товар", new Object[0]), LangKt.tx("товара", new Object[0]), LangKt.tx("товаров", new Object[0])));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInNewScreen$lambda$51$0(MutableState mutableState) {
        StockInNewScreen$lambda$32(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInNewScreen$lambda$52$0(Repo repo, MutableState mutableState, MutableState mutableState2, String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        Product findByBarcode = repo.findByBarcode(code);
        if (findByBarcode != null) {
            StockInNewScreen$addProduct(mutableState, findByBarcode);
            StockInNewScreen$lambda$32(mutableState2, false);
        } else {
            Toaster.INSTANCE.error(LangKt.tx("Товар с кодом %s не найден", code));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInNewScreen$lambda$53$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StockInLineCard(final StockInLine stockInLine, final String str, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, final Function0<Unit> function05, final Function0<Unit> function06, Composer composer, final int i) {
        int i2;
        Function0<Unit> function07;
        Function0<Unit> function08;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1676821577);
        ComposerKt.sourceInformation(startRestartGroup, "C(StockInLineCard)P(1!1,5,4,7,3)905@35072L4187,905@34999L4260:StockInScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(stockInLine) : startRestartGroup.changedInstance(stockInLine) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function07 = function02;
            i2 |= startRestartGroup.changedInstance(function07) ? 2048 : 1024;
        } else {
            function07 = function02;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function03) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function04) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function05) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            function08 = function06;
            i2 |= startRestartGroup.changedInstance(function08) ? 8388608 : 4194304;
        } else {
            function08 = function06;
        }
        if (!startRestartGroup.shouldExecute((4793491 & i2) != 4793490, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1676821577, i2, -1, "uz.FonRo.pos.ui.docs.StockInLineCard (StockInScreen.kt:900)");
            }
            final String name = Units.INSTANCE.name(stockInLine.getProduct().getUnit());
            final double sale = stockInLine.getSale() - stockInLine.getPurchase();
            double purchase = stockInLine.getPurchase();
            double d = AudioStats.AUDIO_AMPLITUDE_NONE;
            if (purchase > AudioStats.AUDIO_AMPLITUDE_NONE) {
                d = 100.0d * (sale / stockInLine.getPurchase());
            }
            final Function0<Unit> function09 = function08;
            final Function0<Unit> function010 = function07;
            final double d2 = d;
            composer2 = startRestartGroup;
            BasicsKt.m9833OxSoftCardCe4qNIY(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(10.0f), 7, null), Dp.m6989constructorimpl(12.0f), null, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-355933745, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StockInScreenKt.StockInLineCard$lambda$0(Function0.this, stockInLine, name, function0, function010, function03, function04, function05, d2, sale, str, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), composer2, 1572918, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StockInScreenKt.StockInLineCard$lambda$1(StockInLine.this, str, function0, function02, function03, function04, function05, function06, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit StockInLineCard$lambda$0(Function0 function0, StockInLine stockInLine, String str, Function0 function02, Function0 function03, Function0 function04, Function0 function05, Function0 function06, double d, double d2, String str2, ColumnScope OxSoftCard, Composer composer, int i) {
        String tx;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C906@35082L1398,945@36490L11,946@36510L355,952@36875L11,953@36895L1687,994@38592L10,995@38611L642:StockInScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-355933745, i, -1, "uz.FonRo.pos.ui.docs.StockInLineCard.<anonymous> (StockInScreen.kt:906)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1089765907, "C911@35283L228,917@35524L449,935@36168L25,930@35986L484:StockInScreen.kt#1so789");
            BasicsKt.m9834OxThumbPZHvWI(null, Dp.m6989constructorimpl(40.0f), Ox.INSTANCE.m10217getPanel0d7_KjU(), ComposableSingletons$StockInScreenKt.INSTANCE.getLambda$563917915$app(), composer, 3120, 1);
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
            ComposerKt.sourceInformationMarkerStart(composer, -2029262187, "C918@35570L194,924@35781L178:StockInScreen.kt#1so789");
            TextKt.m2798Text4IGK_g(stockInLine.getProduct().getName(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), composer, 0, 3120, 55294);
            TextKt.m2798Text4IGK_g(LangKt.tx("Остаток: %s %s", Fmt.INSTANCE.qf(Double.valueOf(stockInLine.getProduct().getQuantity())), str), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 0, 3072, 57342);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier oxTap = ModifiersKt.oxTap(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(36.0f)), OxShape.INSTANCE.getPill()), Ox.INSTANCE.m10198getDangerSoft0d7_KjU(), null, 2, null), false, function0, composer, 0, 1);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, oxTap);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1325401255, "C938@36279L177:StockInScreen.kt#1so789");
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getDelete(), LangKt.tx("Убрать из документа", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(17.0f)), Ox.INSTANCE.m10196getDanger0d7_KjU(), composer, 384, 0);
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
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, fillMaxWidth$default2);
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
            Updater.m3815setimpl(m3808constructorimpl4, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl4.getInserting() || !Intrinsics.areEqual(m3808constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m3808constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m3808constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3815setimpl(m3808constructorimpl4, materializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1705944223, "C947@36605L80,948@36698L76,949@36787L68:StockInScreen.kt#1so789");
            m9920LineNumFieldww6aTOc(rowScopeInstance2, LangKt.tx("Кол-во, %s", str), Fmt.INSTANCE.qf(Double.valueOf(stockInLine.getQuantity())), Ox.INSTANCE.m10233getText0d7_KjU(), function02, composer, 6);
            m9920LineNumFieldww6aTOc(rowScopeInstance2, LangKt.tx("Закупка", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(stockInLine.getPurchase())), Ox.INSTANCE.m10215getOrangeInk0d7_KjU(), function03, composer, 6);
            m9920LineNumFieldww6aTOc(rowScopeInstance2, LangKt.tx("Продажа", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(stockInLine.getSale())), Ox.INSTANCE.m10202getGreenDeep0d7_KjU(), function04, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer, 6);
            Modifier fillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_43 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m930spacedBy0680j_43, centerVertically2, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer, fillMaxWidth$default3);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1571399571, "C964@37334L29,958@37095L928:StockInScreen.kt#1so789");
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(SizeKt.m1084heightInVpY3zN4$default(ModifiersKt.oxTap(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), OxShape.INSTANCE.getTileSm()), Ox.INSTANCE.m10217getPanel0d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getTileSm()), false, function05, composer, 0, 1), Dp.m6989constructorimpl(42.0f), 0.0f, 2, null), Dp.m6989constructorimpl(12.0f), Dp.m6989constructorimpl(8.0f));
            Alignment centerStart = Alignment.INSTANCE.getCenterStart();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(centerStart, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(composer, m1050paddingVpY3zN4);
            Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor6);
            } else {
                composer.useNode();
            }
            Composer m3808constructorimpl6 = Updater.m3808constructorimpl(composer);
            Updater.m3815setimpl(m3808constructorimpl6, maybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl6.getInserting() || !Intrinsics.areEqual(m3808constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                m3808constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                m3808constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
            }
            Updater.m3815setimpl(m3808constructorimpl6, materializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1509622796, "C969@37563L446:StockInScreen.kt#1so789");
            String expiration = stockInLine.getExpiration();
            if (expiration == null || StringsKt.isBlank(expiration)) {
                tx = LangKt.tx("Срок годности: не указан", new Object[0]);
            } else {
                tx = LangKt.tx("Годен до ", new Object[0]) + Fmt.INSTANCE.dt(stockInLine.getExpiration(), false);
            }
            TextStyle caption = OxType.INSTANCE.getCaption();
            String expiration2 = stockInLine.getExpiration();
            TextKt.m2798Text4IGK_g(tx, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(caption, (expiration2 == null || StringsKt.isBlank(expiration2)) ? Ox.INSTANCE.m10200getDim20d7_KjU() : Ox.INSTANCE.m10233getText0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 3120, 55294);
            Composer composer2 = composer;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            String expiration3 = stockInLine.getExpiration();
            if (expiration3 != null && !StringsKt.isBlank(expiration3)) {
                composer2.startReplaceGroup(1572340389);
                ComposerKt.sourceInformation(composer2, "986@38356L34,980@38092L466");
                Modifier oxTap2 = ModifiersKt.oxTap(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(42.0f)), OxShape.INSTANCE.getTileSm()), Ox.INSTANCE.m10217getPanel0d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getTileSm()), false, function06, composer2, 0, 1);
                Alignment center2 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap7 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier7 = ComposedModifierKt.materializeModifier(composer2, oxTap2);
                Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor7);
                } else {
                    composer2.useNode();
                }
                Composer m3808constructorimpl7 = Updater.m3808constructorimpl(composer2);
                Updater.m3815setimpl(m3808constructorimpl7, maybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3815setimpl(m3808constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3808constructorimpl7.getInserting() || !Intrinsics.areEqual(m3808constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                    m3808constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                    m3808constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
                }
                Updater.m3815setimpl(m3808constructorimpl7, materializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 1980905155, "C989@38488L52:StockInScreen.kt#1so789");
                str3 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                str4 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                TextKt.m2798Text4IGK_g("✕", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getLabel(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 6, 0, 65534);
                composer2 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            } else {
                str3 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                str4 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                composer2.startReplaceGroup(1572818967);
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer2, 6);
            Modifier fillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composer2, 48);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str4);
            int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap8 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier8 = ComposedModifierKt.materializeModifier(composer2, fillMaxWidth$default4);
            Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str3);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor8);
            } else {
                composer2.useNode();
            }
            Composer m3808constructorimpl8 = Updater.m3808constructorimpl(composer2);
            Updater.m3815setimpl(m3808constructorimpl8, rowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl8.getInserting() || !Intrinsics.areEqual(m3808constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
                m3808constructorimpl8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                m3808constructorimpl8.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
            }
            Updater.m3815setimpl(m3808constructorimpl8, materializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 1436787866, "C996@38702L360,1005@39075L168:StockInScreen.kt#1so789");
            TextKt.m2798Text4IGK_g(LangKt.tx("Наценка %s%% · прибыль %s", Fmt.INSTANCE.nf(Double.valueOf(d), 1), Fmt.INSTANCE.nf(Double.valueOf(d2))), RowScope.weight$default(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), d2 < AudioStats.AUDIO_AMPLITUDE_NONE ? Ox.INSTANCE.m10196getDanger0d7_KjU() : Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 3120, 55292);
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.money(Double.valueOf(Num.INSTANCE.money(stockInLine.getQuantity() * stockInLine.getPurchase())), str2), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowPrice(), composer, 0, 3072, 57342);
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

    /* renamed from: LineNumField-ww6aTOc, reason: not valid java name */
    private static final void m9920LineNumFieldww6aTOc(final RowScope rowScope, final String str, final String str2, final long j, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Function0<Unit> function02;
        Composer startRestartGroup = composer.startRestartGroup(2076057121);
        ComposerKt.sourceInformation(startRestartGroup, "C(LineNumField)P(!1,3,2:c#ui.graphics.Color)1027@39591L24,1021@39397L627:StockInScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(rowScope) ? 4 : 2) | i;
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
            i2 |= startRestartGroup.changed(j) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            function02 = function0;
            i2 |= startRestartGroup.changedInstance(function02) ? 16384 : 8192;
        } else {
            function02 = function0;
        }
        if (!startRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2076057121, i2, -1, "uz.FonRo.pos.ui.docs.LineNumField (StockInScreen.kt:1020)");
            }
            int i3 = i2 >> 6;
            int i4 = i2;
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(SizeKt.m1084heightInVpY3zN4$default(ModifiersKt.oxTap(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), OxShape.INSTANCE.getTileSm()), Ox.INSTANCE.m10217getPanel0d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getTileSm()), false, function02, startRestartGroup, i3 & 896, 1), Dp.m6989constructorimpl(52.0f), 0.0f, 2, null), Dp.m6989constructorimpl(10.0f), Dp.m6989constructorimpl(8.0f));
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1984025445, "C1032@39775L72,1033@39856L162:StockInScreen.kt#1so789");
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getTileLabel(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), startRestartGroup, (i4 >> 3) & 14, 3072, 57342);
            TextKt.m2798Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getStatValue(), j, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), startRestartGroup, i3 & 14, 3120, 55294);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda72
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StockInScreenKt.LineNumField_ww6aTOc$lambda$1(RowScope.this, str, str2, j, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StockInHistoryCard(final StockInDoc stockInDoc, final String str, final String str2, final boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        String str3;
        boolean z2;
        Composer startRestartGroup = composer.startRestartGroup(1230935360);
        ComposerKt.sourceInformation(startRestartGroup, "C(StockInHistoryCard)P(2,1,4)1053@40374L1865,1053@40287L1952:StockInScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(stockInDoc) : startRestartGroup.changedInstance(stockInDoc) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            str3 = str2;
            i2 |= startRestartGroup.changed(str3) ? 256 : 128;
        } else {
            str3 = str2;
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
                ComposerKt.traceEventStart(1230935360, i3, -1, "uz.FonRo.pos.ui.docs.StockInHistoryCard (StockInScreen.kt:1051)");
            }
            Iterator<T> it = stockInDoc.getItems().iterator();
            double d = AudioStats.AUDIO_AMPLITUDE_NONE;
            while (it.hasNext()) {
                d += ((StockInItem) it.next()).getQuantity();
            }
            final String str4 = str3;
            final boolean z3 = z2;
            final double d2 = d;
            BasicsKt.m9829OxCardEOp_iR4(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(9.0f), 7, null), Dp.m6989constructorimpl(12.0f), 0L, null, function0, ComposableLambdaKt.rememberComposableLambda(653618085, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StockInScreenKt.StockInHistoryCard$lambda$1(StockInDoc.this, str4, z3, str, d2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, (57344 & i3) | 196662, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StockInScreenKt.StockInHistoryCard$lambda$2(StockInDoc.this, str, str2, z, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x01f1, code lost:
    
        if (r6 == null) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit StockInHistoryCard$lambda$1(uz.FonRo.pos.data.model.StockInDoc r39, java.lang.String r40, boolean r41, java.lang.String r42, double r43, androidx.compose.foundation.layout.ColumnScope r45, androidx.compose.runtime.Composer r46, int r47) {
        /*
            Method dump skipped, instructions count: 1185
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.StockInScreenKt.StockInHistoryCard$lambda$1(uz.FonRo.pos.data.model.StockInDoc, java.lang.String, boolean, java.lang.String, double, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    private static final void StockInDetailSheet(final StockInDoc stockInDoc, final String str, final String str2, final boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(182326026);
        ComposerKt.sourceInformation(startRestartGroup, "C(StockInDetailSheet)P(2,1,4)1110@42552L116,1113@42675L2858,1107@42416L3117:StockInScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(stockInDoc) : startRestartGroup.changedInstance(stockInDoc) ? 4 : 2) | i;
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
                ComposerKt.traceEventStart(182326026, i2, -1, "uz.FonRo.pos.ui.docs.StockInDetailSheet (StockInScreen.kt:1106)");
            }
            SheetsKt.OxCardSheet(LangKt.tx("Приход · ", new Object[0]) + Fmt.INSTANCE.dt(stockInDoc.getCreatedAt(), false), function0, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(1735837501, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda73
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StockInScreenKt.StockInDetailSheet$lambda$0(Function0.this, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1540973094, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda74
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StockInScreenKt.StockInDetailSheet$lambda$1(StockInDoc.this, str2, z, str, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 >> 9) & 112) | 14155776, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda75
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StockInScreenKt.StockInDetailSheet$lambda$2(StockInDoc.this, str, str2, z, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit StockInDetailSheet$lambda$0(Function0 function0, RowScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C1111@42566L92:StockInScreen.kt#1so789");
        if ((i & 6) == 0) {
            i |= composer.changed(OxCardSheet) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1735837501, i, -1, "uz.FonRo.pos.ui.docs.StockInDetailSheet.<anonymous> (StockInScreen.kt:1111)");
            }
            BasicsKt.OxButton(LangKt.tx("Закрыть", new Object[0]), function0, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.PRIMARY, null, false, false, null, composer, 3072, 240);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x011d, code lost:
    
        if (r4 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x050e, code lost:
    
        if (r1 != null) goto L97;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit StockInDetailSheet$lambda$1(uz.FonRo.pos.data.model.StockInDoc r43, java.lang.String r44, boolean r45, java.lang.String r46, androidx.compose.foundation.layout.ColumnScope r47, androidx.compose.runtime.Composer r48, int r49) {
        /*
            Method dump skipped, instructions count: 1601
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.StockInScreenKt.StockInDetailSheet$lambda$1(uz.FonRo.pos.data.model.StockInDoc, java.lang.String, boolean, java.lang.String, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    public static final void SupplierPickerSheet(final List<Supplier> suppliers, final Function1<? super Supplier, Unit> onPick, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(suppliers, "suppliers");
        Intrinsics.checkNotNullParameter(onPick, "onPick");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(1712159982);
        ComposerKt.sourceInformation(startRestartGroup, "C(SupplierPickerSheet)P(2,1)1182@45796L723,1182@45736L783:StockInScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(suppliers) : startRestartGroup.changedInstance(suppliers) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onPick) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1712159982, i2, -1, "uz.FonRo.pos.ui.docs.SupplierPickerSheet (StockInScreen.kt:1181)");
            }
            SheetsKt.OxCardSheet(LangKt.tx("Поставщик", new Object[0]), onDismiss, null, false, false, false, null, ComposableLambdaKt.rememberComposableLambda(1454187090, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StockInScreenKt.SupplierPickerSheet$lambda$0(Function1.this, onDismiss, suppliers, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 >> 3) & 112) | 12582912, 124);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StockInScreenKt.SupplierPickerSheet$lambda$1(suppliers, onPick, onDismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SupplierPickerSheet$lambda$0(final Function1 function1, final Function0 function0, List list, ColumnScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C1183@45837L21,1183@45806L707:StockInScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1454187090, i, -1, "uz.FonRo.pos.ui.docs.SupplierPickerSheet.<anonymous> (StockInScreen.kt:1183)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -573150669, "C1187@46026L29,1184@45875L194,1199@46493L10:StockInScreen.kt#1so789");
            String tx = LangKt.tx("Без поставщика", new Object[0]);
            String tx2 = LangKt.tx("Приход без привязки к контрагенту", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -711221159, "CC(remember):StockInScreen.kt#9igjgp");
            boolean changed = composer.changed(function1) | composer.changed(function0);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SupplierPickerSheet$lambda$0$0$0$0;
                        SupplierPickerSheet$lambda$0$0$0$0 = StockInScreenKt.SupplierPickerSheet$lambda$0$0$0$0(Function1.this, function0);
                        return SupplierPickerSheet$lambda$0$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            PickerRow(tx, tx2, (Function0) rememberedValue, composer, 0);
            composer.startReplaceGroup(-711218830);
            ComposerKt.sourceInformation(composer, "*1193@46277L29,1190@46126L198");
            Iterator it = list.iterator();
            while (true) {
                String str = null;
                if (!it.hasNext()) {
                    break;
                }
                final Supplier supplier = (Supplier) it.next();
                String name = supplier.getName();
                String phone = supplier.getPhone();
                if (phone != null) {
                    boolean isBlank = StringsKt.isBlank(phone);
                    Boolean.valueOf(!isBlank).getClass();
                    if (!isBlank) {
                        str = phone;
                    }
                }
                ComposerKt.sourceInformationMarkerStart(composer, -2146571154, "CC(remember):StockInScreen.kt#9igjgp");
                boolean changed2 = composer.changed(function1) | composer.changedInstance(supplier) | composer.changed(function0);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SupplierPickerSheet$lambda$0$0$1$1$0;
                            SupplierPickerSheet$lambda$0$0$1$1$0 = StockInScreenKt.SupplierPickerSheet$lambda$0$0$1$1$0(Function1.this, supplier, function0);
                            return SupplierPickerSheet$lambda$0$0$1$1$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                PickerRow(name, str, (Function0) rememberedValue2, composer, 0);
            }
            composer.endReplaceGroup();
            if (list.isEmpty()) {
                composer.startReplaceGroup(-572669922);
                ComposerKt.sourceInformation(composer, "1197@46394L72");
                BasicsKt.OxEmptyNote(LangKt.tx("Поставщиков нет — добавьте их в разделе «Поставщики».", new Object[0]), null, composer, 0, 2);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-572569978);
                composer.endReplaceGroup();
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer, 6);
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
    public static final Unit SupplierPickerSheet$lambda$0$0$0$0(Function1 function1, Function0 function0) {
        function1.invoke(null);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupplierPickerSheet$lambda$0$0$1$1$0(Function1 function1, Supplier supplier, Function0 function0) {
        function1.invoke(supplier);
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final void PickerRow(final String str, String str2, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        final String str3;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1688568008);
        ComposerKt.sourceInformation(startRestartGroup, "C(PickerRow)P(2,1)1206@46618L597:StockInScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            str3 = str2;
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1688568008, i3, -1, "uz.FonRo.pos.ui.docs.PickerRow (StockInScreen.kt:1205)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -247090708, "C1210@46749L24,1207@46660L529,1220@47198L11:StockInScreen.kt#1so789");
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.m1084heightInVpY3zN4$default(ModifiersKt.oxTap(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, function0, startRestartGroup, (i3 & 896) | 6, 1), Dp.m6989constructorimpl(54.0f), 0.0f, 2, null), 0.0f, Dp.m6989constructorimpl(10.0f), 1, null);
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(center, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m1051paddingVpY3zN4$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 406866962, "C1215@46934L84:StockInScreen.kt#1so789");
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), startRestartGroup, i3 & 14, 3120, 55294);
            Composer composer3 = startRestartGroup;
            String str4 = str2;
            if (str4 != null && !StringsKt.isBlank(str4)) {
                composer3.startReplaceGroup(407006833);
                ComposerKt.sourceInformation(composer3, "1217@47080L85");
                str3 = str2;
                TextKt.m2798Text4IGK_g(str3, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer3, (i3 >> 3) & 14, 3120, 55294);
                composer3 = composer3;
                composer3.endReplaceGroup();
            } else {
                str3 = str2;
                composer3.startReplaceGroup(407102406);
                composer3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer2 = composer3;
            BasicsKt.m9830OxDivideriPRSM58(0L, 0.0f, composer2, 0, 3);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda63
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StockInScreenKt.PickerRow$lambda$1(str, str3, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ProductPickerSheet(final java.util.List<uz.FonRo.pos.data.model.Product> r29, final java.lang.String r30, final boolean r31, final kotlin.jvm.functions.Function0<kotlin.Unit> r32, java.util.List<uz.FonRo.pos.data.model.Category> r33, java.util.Set<java.lang.Long> r34, boolean r35, kotlin.jvm.functions.Function1<? super uz.FonRo.pos.data.model.Product, kotlin.Unit> r36, kotlin.jvm.functions.Function1<? super java.util.List<uz.FonRo.pos.data.model.Product>, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instructions count: 1043
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.StockInScreenKt.ProductPickerSheet(java.util.List, java.lang.String, boolean, kotlin.jvm.functions.Function0, java.util.List, java.util.Set, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final String ProductPickerSheet$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final Long ProductPickerSheet$lambda$4(MutableState<Long> mutableState) {
        return mutableState.getValue();
    }

    private static final Set<Long> ProductPickerSheet$lambda$7(MutableState<Set<Long>> mutableState) {
        return mutableState.getValue();
    }

    private static final void ProductPickerSheet$confirm(List<Product> list, Function1<? super List<Product>, Unit> function1, Function0<Unit> function0) {
        if (list.isEmpty()) {
            Toaster.INSTANCE.error(LangKt.tx("Отметьте хотя бы один товар", new Object[0]));
            return;
        }
        if (function1 != null) {
            function1.invoke(list);
        }
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ProductPickerSheet$lambda$13(final Function0 function0, final List list, final Function1 function1, MutableState mutableState, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        String str;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C1296@49990L89,1299@50225L13,1297@50096L352:StockInScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1986489894, i2, -1, "uz.FonRo.pos.ui.docs.ProductPickerSheet.<anonymous> (StockInScreen.kt:1296)");
            }
            BasicsKt.OxButton(LangKt.tx("Отмена", new Object[0]), function0, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.GHOST, null, false, false, null, composer, 3072, 240);
            if (ProductPickerSheet$lambda$7(mutableState).isEmpty()) {
                str = LangKt.tx("Добавить", new Object[0]);
            } else {
                str = LangKt.tx("Добавить · ", new Object[0]) + ProductPickerSheet$lambda$7(mutableState).size();
            }
            String str2 = str;
            ComposerKt.sourceInformationMarkerStart(composer, 2051316819, "CC(remember):StockInScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(list) | composer.changed(function1) | composer.changed(function0);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda33
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProductPickerSheet$lambda$13$0$0;
                        ProductPickerSheet$lambda$13$0$0 = StockInScreenKt.ProductPickerSheet$lambda$13$0$0(list, function1, function0);
                        return ProductPickerSheet$lambda$13$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(str2, (Function0) rememberedValue, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.4f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, !ProductPickerSheet$lambda$7(mutableState).isEmpty(), false, null, composer, 27648, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductPickerSheet$lambda$13$0$0(List list, Function1 function1, Function0 function0) {
        ProductPickerSheet$confirm(list, function1, function0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r7v45 */
    /* JADX WARN: Type inference failed for: r7v46 */
    /* JADX WARN: Type inference failed for: r7v62 */
    public static final Unit ProductPickerSheet$lambda$14(final List list, boolean z, final MutableState mutableState, final MutableState mutableState2, final List list2, final MutableState mutableState3, List list3, List list4, List list5, String str, boolean z2, Set set, final Function1 function1, final Function0 function0, ColumnScope OxCardSheet, Composer composer, int i) {
        int i2;
        Composer composer2;
        String str2;
        int i3;
        String str3;
        String tx;
        int i4;
        String str4;
        String str5;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C1310@50557L14,1308@50489L151,1355@52343L11,1356@52419L21,1356@52363L1945:StockInScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1098015637, i2, -1, "uz.FonRo.pos.ui.docs.ProductPickerSheet.<anonymous> (StockInScreen.kt:1308)");
            }
            String ProductPickerSheet$lambda$1 = ProductPickerSheet$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 1368930169, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ProductPickerSheet$lambda$14$0$0;
                        ProductPickerSheet$lambda$14$0$0 = StockInScreenKt.ProductPickerSheet$lambda$14$0$0(MutableState.this, (String) obj);
                        return ProductPickerSheet$lambda$14$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.OxSearchBox(ProductPickerSheet$lambda$1, (Function1) rememberedValue, null, LangKt.tx("Название, артикул или код", new Object[0]), null, composer, 48, 20);
            if (!list.isEmpty()) {
                composer.startReplaceGroup(-512707705);
                ComposerKt.sourceInformation(composer, "1314@50698L430,1314@50688L440");
                ChipsKt.OxChipRow(null, ComposableLambdaKt.rememberComposableLambda(198305431, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit ProductPickerSheet$lambda$14$1;
                        ProductPickerSheet$lambda$14$1 = StockInScreenKt.ProductPickerSheet$lambda$14$1(list, mutableState2, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return ProductPickerSheet$lambda$14$1;
                    }
                }, composer, 54), composer, 48, 1);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-512261801);
                composer.endReplaceGroup();
            }
            if (!z) {
                composer2 = composer;
                str2 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                i3 = 0;
                str3 = "CC(remember):StockInScreen.kt#9igjgp";
                composer2.startReplaceGroup(-511076361);
                composer2.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-511992194);
                ComposerKt.sourceInformation(composer, "1331@51394L10,1332@51417L906");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer, 6);
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
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
                ComposerKt.sourceInformationMarkerStart(composer, 203668066, "C1337@51637L224:StockInScreen.kt#1so789");
                if (ProductPickerSheet$lambda$7(mutableState3).isEmpty()) {
                    i4 = false;
                    str4 = LangKt.tx("Ничего не отмечено", new Object[0]);
                } else {
                    i4 = false;
                    str4 = LangKt.tx("Отмечено: ", new Object[0]) + ProductPickerSheet$lambda$7(mutableState3).size();
                }
                int i5 = i4;
                str2 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                TextKt.m2798Text4IGK_g(str4, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getLabel(), composer, 0, 0, 65532);
                composer2 = composer;
                if (ProductPickerSheet$lambda$7(mutableState3).isEmpty()) {
                    str5 = "CC(remember):StockInScreen.kt#9igjgp";
                    composer2.startReplaceGroup(204043041);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(203937734);
                    ComposerKt.sourceInformation(composer2, "1343@51949L25,1343@51927L91");
                    String tx2 = LangKt.tx("Снять", new Object[i5]);
                    BtnSize btnSize = BtnSize.SM;
                    BtnStyle btnStyle = BtnStyle.GHOST;
                    ComposerKt.sourceInformationMarkerStart(composer2, -547610054, "CC(remember):StockInScreen.kt#9igjgp");
                    Object rememberedValue2 = composer2.rememberedValue();
                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit ProductPickerSheet$lambda$14$2$0$0;
                                ProductPickerSheet$lambda$14$2$0$0 = StockInScreenKt.ProductPickerSheet$lambda$14$2$0$0(MutableState.this);
                                return ProductPickerSheet$lambda$14$2$0$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    str5 = "CC(remember):StockInScreen.kt#9igjgp";
                    BasicsKt.OxButton(tx2, (Function0) rememberedValue2, null, btnStyle, btnSize, false, false, null, composer2, 27696, 228);
                    composer2.endReplaceGroup();
                }
                if (!list2.isEmpty()) {
                    composer2.startReplaceGroup(204089944);
                    ComposerKt.sourceInformation(composer2, "1348@52182L44,1346@52098L193");
                    String str6 = LangKt.tx("Все · ", new Object[i5]) + list2.size();
                    String str7 = str5;
                    ComposerKt.sourceInformationMarkerStart(composer2, -547602579, str7);
                    boolean changedInstance = composer2.changedInstance(list2);
                    Object rememberedValue3 = composer2.rememberedValue();
                    if (changedInstance || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit ProductPickerSheet$lambda$14$2$1$0;
                                ProductPickerSheet$lambda$14$2$1$0 = StockInScreenKt.ProductPickerSheet$lambda$14$2$1$0(list2, mutableState3);
                                return ProductPickerSheet$lambda$14$2$1$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    str3 = str7;
                    BasicsKt.OxButton(str6, (Function0) rememberedValue3, null, null, BtnSize.SM, false, false, null, composer2, 24576, 236);
                    composer2.endReplaceGroup();
                } else {
                    str3 = str5;
                    composer2.startReplaceGroup(204313857);
                    composer2.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
                i3 = i5;
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer2, 6);
            boolean z3 = true;
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(OxCardSheet.weight(Modifier.INSTANCE, 1.0f, i3), ScrollKt.rememberScrollState(i3, composer2, i3, 1), false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, i3);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str2);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, i3);
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, verticalScroll$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            Updater.m3815setimpl(m3808constructorimpl2, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 399210033, "C1394@54288L10:StockInScreen.kt#1so789");
            composer2.startReplaceGroup(-956953840);
            ComposerKt.sourceInformation(composer2, "");
            Iterator it = list3.iterator();
            while (it.hasNext()) {
                final Product product = (Product) it.next();
                String str8 = LangKt.tx("Остаток %s %s", Fmt.INSTANCE.qf(Double.valueOf(product.getQuantity())), Units.INSTANCE.name(product.getUnit())) + " · " + Fmt.INSTANCE.money(Double.valueOf(product.getSalePrice()), str) + (z2 ? LangKt.tx(" · закуп %s", Fmt.INSTANCE.nf(Double.valueOf(product.getPurchasePrice()))) : "");
                if (z) {
                    composer2.startReplaceGroup(-2112098725);
                    ComposerKt.sourceInformation(composer2, "1368@53118L376,1363@52865L651");
                    final boolean contains = set.contains(Long.valueOf(product.getId()));
                    String name = product.getName();
                    boolean z4 = (contains || ProductPickerSheet$lambda$7(mutableState3).contains(Long.valueOf(product.getId()))) ? z3 : i3;
                    ComposerKt.sourceInformationMarkerStart(composer2, -68121903, str3);
                    boolean changed = composer2.changed(contains) | composer2.changedInstance(product);
                    Object rememberedValue4 = composer2.rememberedValue();
                    if (changed || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit ProductPickerSheet$lambda$14$3$0$0$0;
                                ProductPickerSheet$lambda$14$3$0$0$0 = StockInScreenKt.ProductPickerSheet$lambda$14$3$0$0$0(contains, product, mutableState3);
                                return ProductPickerSheet$lambda$14$3$0$0$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ProductCheckRow(name, str8, z4, contains, (Function0) rememberedValue4, composer2, 0);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-2111364645);
                    ComposerKt.sourceInformation(composer2, "1381@53698L40,1378@53562L198");
                    String name2 = product.getName();
                    ComposerKt.sourceInformationMarkerStart(composer2, -68103679, str3);
                    boolean changed2 = composer2.changed(function1) | composer2.changedInstance(product) | composer2.changed(function0);
                    Object rememberedValue5 = composer2.rememberedValue();
                    if (changed2 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue5 = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit ProductPickerSheet$lambda$14$3$0$1$0;
                                ProductPickerSheet$lambda$14$3$0$1$0 = StockInScreenKt.ProductPickerSheet$lambda$14$3$0$1$0(Function1.this, product, function0);
                                return ProductPickerSheet$lambda$14$3$0$1$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    PickerRow(name2, str8, (Function0) rememberedValue5, composer2, i3);
                    composer2.endReplaceGroup();
                }
                z3 = true;
            }
            composer2.endReplaceGroup();
            if (list4.isEmpty()) {
                composer2.startReplaceGroup(400520092);
                ComposerKt.sourceInformation(composer2, "1386@53844L261");
                if (list5.isEmpty()) {
                    tx = LangKt.tx("Каталог пуст — сначала добавьте товары.", new Object[i3]);
                } else {
                    tx = ProductPickerSheet$lambda$4(mutableState2) != null ? LangKt.tx("В этой категории ничего не найдено.", new Object[i3]) : LangKt.tx("Ничего не найдено.", new Object[i3]);
                }
                BasicsKt.OxEmptyNote(tx, null, composer2, i3, 2);
                composer2.endReplaceGroup();
            } else if (list4.size() > list3.size()) {
                composer2.startReplaceGroup(400842058);
                ComposerKt.sourceInformation(composer2, "1392@54174L87");
                BasicsKt.OxEmptyNote(LangKt.tx("Показаны первые %s из %s — уточните поиск.", Integer.valueOf(list3.size()), Integer.valueOf(list4.size())), null, composer2, i3, 2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(400956417);
                composer2.endReplaceGroup();
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer2, 6);
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
    public static final Unit ProductPickerSheet$lambda$14$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductPickerSheet$lambda$14$1(List list, final MutableState mutableState, RowScope OxChipRow, Composer composer, int i) {
        String str;
        boolean z;
        Intrinsics.checkNotNullParameter(OxChipRow, "$this$OxChipRow");
        ComposerKt.sourceInformation(composer, "C1315@50776L21,1315@50716L82,*1320@50994L21,1317@50857L239:StockInScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(198305431, i, -1, "uz.FonRo.pos.ui.docs.ProductPickerSheet.<anonymous>.<anonymous> (StockInScreen.kt:1315)");
            }
            String tx = LangKt.tx("Все", new Object[0]);
            boolean z2 = ProductPickerSheet$lambda$4(mutableState) == null;
            ComposerKt.sourceInformationMarkerStart(composer, 1592960684, "CC(remember):StockInScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProductPickerSheet$lambda$14$1$0$0;
                        ProductPickerSheet$lambda$14$1$0$0 = StockInScreenKt.ProductPickerSheet$lambda$14$1$0$0(MutableState.this);
                        return ProductPickerSheet$lambda$14$1$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.m9837OxCatChipFV1VA1c(tx, z2, (Function0) rememberedValue, null, null, null, composer, 384, 56);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final Category category = (Category) it.next();
                String name = category.getName();
                Long ProductPickerSheet$lambda$4 = ProductPickerSheet$lambda$4(mutableState);
                long id = category.getId();
                if (ProductPickerSheet$lambda$4 != null && ProductPickerSheet$lambda$4.longValue() == id) {
                    str = name;
                    z = true;
                } else {
                    str = name;
                    z = false;
                }
                ComposerKt.sourceInformationMarkerStart(composer, -123388951, "CC(remember):StockInScreen.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(category);
                Object rememberedValue2 = composer.rememberedValue();
                if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProductPickerSheet$lambda$14$1$1$0$0;
                            ProductPickerSheet$lambda$14$1$1$0$0 = StockInScreenKt.ProductPickerSheet$lambda$14$1$1$0$0(Category.this, mutableState);
                            return ProductPickerSheet$lambda$14$1$1$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ChipsKt.m9837OxCatChipFV1VA1c(str, z, (Function0) rememberedValue2, null, null, CatalogScreenKt.parseHexColor(category.getColor()), composer, 0, 24);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductPickerSheet$lambda$14$1$0$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductPickerSheet$lambda$14$1$1$0$0(Category category, MutableState mutableState) {
        mutableState.setValue(Long.valueOf(category.getId()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductPickerSheet$lambda$14$2$0$0(MutableState mutableState) {
        mutableState.setValue(SetsKt.emptySet());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductPickerSheet$lambda$14$2$1$0(List list, MutableState mutableState) {
        Set<Long> ProductPickerSheet$lambda$7 = ProductPickerSheet$lambda$7(mutableState);
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((Product) it.next()).getId()));
        }
        mutableState.setValue(SetsKt.plus((Set) ProductPickerSheet$lambda$7, (Iterable) arrayList));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductPickerSheet$lambda$14$3$0$0$0(boolean z, Product product, MutableState mutableState) {
        if (z) {
            Toaster.show$default(Toaster.INSTANCE, LangKt.tx("«%s» уже в документе", product.getName()), null, null, null, null, 30, null);
        } else {
            mutableState.setValue(ProductPickerSheet$lambda$7(mutableState).contains(Long.valueOf(product.getId())) ? SetsKt.minus(ProductPickerSheet$lambda$7(mutableState), Long.valueOf(product.getId())) : SetsKt.plus(ProductPickerSheet$lambda$7(mutableState), Long.valueOf(product.getId())));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductPickerSheet$lambda$14$3$0$1$0(Function1 function1, Product product, Function0 function0) {
        if (function1 != null) {
            function1.invoke(product);
        }
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final void ProductCheckRow(final String str, final String str2, final boolean z, final boolean z2, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        long j;
        long m10189getBorder0d7_KjU;
        String str3;
        String str4;
        Composer startRestartGroup = composer.startRestartGroup(298988379);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProductCheckRow)P(4,3)1426@55148L24,1415@54774L1637:StockInScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str2) ? 32 : 16;
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
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(298988379, i3, -1, "uz.FonRo.pos.ui.docs.ProductCheckRow (StockInScreen.kt:1413)");
            }
            Ox ox = Ox.INSTANCE;
            long m10200getDim20d7_KjU = z2 ? ox.m10200getDim20d7_KjU() : ox.m10192getCyan0d7_KjU();
            Modifier clip = ClipKt.clip(PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(8.0f), 7, null), OxShape.INSTANCE.getTile());
            Ox ox2 = Ox.INSTANCE;
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(clip, z ? ox2.m10241tintBg5vOe2sY(m10200getDim20d7_KjU, 0.1f) : ox2.m10218getPanel20d7_KjU(), null, 2, null);
            float m6989constructorimpl = Dp.m6989constructorimpl(1.0f);
            if (z) {
                j = m10200getDim20d7_KjU;
                m10189getBorder0d7_KjU = Color.m4383copywmQWz5c$default(j, 0.55f, 0.0f, 0.0f, 0.0f, 14, null);
            } else {
                j = m10200getDim20d7_KjU;
                m10189getBorder0d7_KjU = Ox.INSTANCE.m10189getBorder0d7_KjU();
            }
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(SizeKt.m1084heightInVpY3zN4$default(ModifiersKt.oxTap(BorderKt.m569borderxT4_qwU(m558backgroundbw27NRU$default, m6989constructorimpl, m10189getBorder0d7_KjU, OxShape.INSTANCE.getTile()), false, function0, startRestartGroup, (i3 >> 6) & 896, 1), Dp.m6989constructorimpl(56.0f), 0.0f, 2, null), Dp.m6989constructorimpl(12.0f), Dp.m6989constructorimpl(10.0f));
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(11.0f));
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1800502943, "C1432@55400L615,1451@56024L297:StockInScreen.kt#1so789");
            Modifier m569borderxT4_qwU = BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(26.0f)), OxShape.INSTANCE.getIconChip()), z ? j : Color.INSTANCE.m4419getTransparent0d7_KjU(), null, 2, null), Dp.m6989constructorimpl(2.0f), z ? j : Ox.INSTANCE.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getIconChip());
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m569borderxT4_qwU);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1983769810, "C:StockInScreen.kt#1so789");
            if (z) {
                startRestartGroup.startReplaceGroup(-1983740454);
                ComposerKt.sourceInformation(startRestartGroup, "1445@55840L151");
                str4 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                str3 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getOk(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(17.0f)), Ox.INSTANCE.m10217getPanel0d7_KjU(), startRestartGroup, 432, 0);
                startRestartGroup = startRestartGroup;
                startRestartGroup.endReplaceGroup();
            } else {
                str3 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                str4 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                startRestartGroup.startReplaceGroup(-1983581455);
                startRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, str4);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, weight$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, str3);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1420151411, "C1452@56066L84:StockInScreen.kt#1so789");
            Composer composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), composer2, i3 & 14, 3120, 55294);
            startRestartGroup = composer2;
            String str5 = str2;
            if (str5 != null && !StringsKt.isBlank(str5)) {
                startRestartGroup.startReplaceGroup(-1420011540);
                ComposerKt.sourceInformation(startRestartGroup, "1454@56212L85");
                TextKt.m2798Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), startRestartGroup, (i3 >> 3) & 14, 3120, 55294);
                startRestartGroup = startRestartGroup;
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1419915967);
                startRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (z2) {
                startRestartGroup.startReplaceGroup(1801408204);
                ComposerKt.sourceInformation(startRestartGroup, "1458@56356L39");
                BasicsKt.OxChip(LangKt.tx("в документе", new Object[0]), ChipTone.DIM, null, startRestartGroup, 48, 4);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1801468747);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.StockInScreenKt$$ExternalSyntheticLambda44
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StockInScreenKt.ProductCheckRow$lambda$1(str, str2, z, z2, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0488, code lost:
    
        if (r12.changedInstance(r3) != false) goto L100;
     */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0552  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void StockInPaywall(uz.FonRo.pos.FonRoApp r67, final uz.FonRo.pos.data.model.Paywall r68, androidx.compose.runtime.Composer r69, final int r70) {
        /*
            Method dump skipped, instructions count: 1389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.StockInScreenKt.StockInPaywall(uz.FonRo.pos.FonRoApp, uz.FonRo.pos.data.model.Paywall, androidx.compose.runtime.Composer, int):void");
    }

    private static final boolean StockInPaywall$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StockInPaywall$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void StockInPaywall$openCheckout(uz.FonRo.pos.data.model.Paywall r2, android.content.Context r3, java.lang.String r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L13
            r1 = r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            if (r1 != 0) goto Ld
            goto Le
        Ld:
            r4 = r0
        Le:
            if (r4 != 0) goto L11
            goto L13
        L11:
            r0 = r4
            goto L23
        L13:
            java.lang.String r2 = r2.getCheckoutUrl()
            if (r2 == 0) goto L23
            r4 = r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = kotlin.text.StringsKt.isBlank(r4)
            if (r4 != 0) goto L23
            r0 = r2
        L23:
            r2 = 0
            if (r0 != 0) goto L34
            uz.FonRo.pos.ui.Toaster r3 = uz.FonRo.pos.ui.Toaster.INSTANCE
            java.lang.String r4 = "Ссылка на оплату ещё не настроена. Обратитесь в поддержку."
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r2 = uz.FonRo.pos.core.LangKt.tx(r4, r2)
            r3.error(r2)
            return
        L34:
            kotlin.Result$Companion r4 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L51
            android.content.Intent r4 = new android.content.Intent     // Catch: java.lang.Throwable -> L51
            java.lang.String r1 = "android.intent.action.VIEW"
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L51
            r4.<init>(r1, r0)     // Catch: java.lang.Throwable -> L51
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            android.content.Intent r4 = r4.addFlags(r0)     // Catch: java.lang.Throwable -> L51
            r3.startActivity(r4)     // Catch: java.lang.Throwable -> L51
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L51
            java.lang.Object r3 = kotlin.Result.m7870constructorimpl(r3)     // Catch: java.lang.Throwable -> L51
            goto L5c
        L51:
            r3 = move-exception
            kotlin.Result$Companion r4 = kotlin.Result.INSTANCE
            java.lang.Object r3 = kotlin.ResultKt.createFailure(r3)
            java.lang.Object r3 = kotlin.Result.m7870constructorimpl(r3)
        L5c:
            java.lang.Throwable r3 = kotlin.Result.m7873exceptionOrNullimpl(r3)
            if (r3 == 0) goto L6f
            uz.FonRo.pos.ui.Toaster r3 = uz.FonRo.pos.ui.Toaster.INSTANCE
            java.lang.String r4 = "Не удалось открыть страницу оплаты"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r2 = uz.FonRo.pos.core.LangKt.tx(r4, r2)
            r3.error(r2)
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.StockInScreenKt.StockInPaywall$openCheckout(uz.FonRo.pos.data.model.Paywall, android.content.Context, java.lang.String):void");
    }

    private static final void StockInPaywall$refresh(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, FonRoApp FonRoApp) {
        if (StockInPaywall$lambda$1(mutableState)) {
            return;
        }
        StockInPaywall$lambda$2(mutableState, true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new StockInScreenKt$StockInPaywall$refresh$1(FonRoApp, mutableState, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInPaywall$lambda$7$0$0$0(Plan plan, Paywall paywall, Context context) {
        StockInPaywall$openCheckout(paywall, context, plan.getCheckoutUrl());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInPaywall$lambda$7$0$1(Plan plan, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C1541@59302L800:StockInScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(179707515, i, -1, "uz.FonRo.pos.ui.docs.StockInPaywall.<anonymous>.<anonymous>.<anonymous> (StockInScreen.kt:1541)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1846455503, "C1546@59543L407,1555@59971L49,1556@60041L43:StockInScreen.kt#1so789");
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
            ComposerKt.sourceInformationMarkerStart(composer, 210714839, "C1547@59597L34,1548@59656L272:StockInScreen.kt#1so789");
            TextKt.m2798Text4IGK_g(plan.getName(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH3(), composer, 0, 0, 65534);
            TextKt.m2798Text4IGK_g(LangKt.tx("Владелец + ", new Object[0]) + Fmt.INSTANCE.plural(plan.getWorkers(), LangKt.tx("сотрудник", new Object[0]), LangKt.tx("сотрудника", new Object[0]), LangKt.tx("сотрудников", new Object[0])), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.nf(Double.valueOf(plan.getPrice())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowPrice(), composer, 0, 0, 65534);
            TextKt.m2798Text4IGK_g(LangKt.tx("сум/мес", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
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
    public static final Unit StockInPaywall$lambda$7$1$0(Paywall paywall, Context context) {
        StockInPaywall$openCheckout(paywall, context, paywall.getCheckoutUrl());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StockInPaywall$lambda$7$2$0(CoroutineScope coroutineScope, MutableState mutableState, FonRoApp FonRoApp) {
        StockInPaywall$refresh(coroutineScope, mutableState, FonRoApp);
        return Unit.INSTANCE;
    }

    private static final Store StockInScreen$lambda$0(State<Store> state) {
        return state.getValue();
    }

    private static final List<Product> StockInScreen$lambda$2(State<? extends List<Product>> state) {
        return state.getValue();
    }

    private static final List<Supplier> StockInScreen$lambda$3(State<? extends List<Supplier>> state) {
        return state.getValue();
    }

    private static final SyncData StockInScreen$lambda$4(State<SyncData> state) {
        return state.getValue();
    }

    private static final Store StockInNewScreen$lambda$0(State<Store> state) {
        return state.getValue();
    }

    private static final List<Product> StockInNewScreen$lambda$2(State<? extends List<Product>> state) {
        return state.getValue();
    }

    private static final List<Category> StockInNewScreen$lambda$3(State<? extends List<Category>> state) {
        return state.getValue();
    }

    private static final List<Supplier> StockInNewScreen$lambda$4(State<? extends List<Supplier>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SyncData StockInNewScreen$lambda$5(State<SyncData> state) {
        return state.getValue();
    }
}
