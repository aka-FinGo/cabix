package uz.FonRo.pos.ui.catalog;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.AudioStats;
import androidx.camera.view.PreviewView;
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
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
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
import androidx.compose.ui.graphics.vector.ImageVector;
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
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.profileinstaller.ProfileVerifier;
import coil.compose.SingletonAsyncImageKt;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.data.local.CacheStore;
import uz.FonRo.pos.data.model.Category;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.ChipsKt;
import uz.FonRo.pos.ui.components.FieldsKt;
import uz.FonRo.pos.ui.components.ModifiersKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.PageHeadKt;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.nav.Routes;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxDim;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: CatalogScreen.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0006\u001a\u009d\u0001\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u001f\u001a[\u0010 \u001a\u00020\u0001*\u00020!2\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\b*\u0010+\u001ac\u0010,\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020'2\b\b\u0002\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u00020\u000f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\b4\u00105\u001aW\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u000f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\u001c2\b\b\u0002\u00101\u001a\u000202H\u0001b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010=\u001a9\u0010>\u001a\u00020\u00012\u0006\u00107\u001a\u0002082\u0006\u0010&\u001a\u00020'2\u0006\u0010?\u001a\u00020@H\u0001b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\bA\u0010B\u001a;\u0010C\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'2\b\b\u0002\u00101\u001a\u000202H\u0001b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\bD\u0010E\u001a{\u0010F\u001a\u00020\u00012\f\u0010G\u001a\b\u0012\u0004\u0012\u0002080H2\u0006\u0010I\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u000f2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\u00110\u00182\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00010\u001c2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u0018H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010M\u001aK\u0010N\u001a\u00020\u00012\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00010\u001c2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00182\b\b\u0002\u0010P\u001a\u00020\u000fH\u0001b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010Q\u001a\u0014\u0010R\u001a\u0004\u0018\u00010'2\b\u0010S\u001a\u0004\u0018\u00010\u0011H\u0000¨\u0006\u0002²\u0006\u0010\u0010G\u001a\b\u0012\u0004\u0012\u0002080HX\u008a\u0084\u0002²\u0006\u0010\u0010T\u001a\b\u0012\u0004\u0012\u00020U0HX\u008a\u0084\u0002²\u0006\n\u0010V\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\f\u0010W\u001a\u0004\u0018\u00010JX\u008a\u008e\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\u0010\u0010X\u001a\b\u0012\u0004\u0012\u0002080HX\u008a\u008e\u0002²\u0006\n\u0010Y\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010Z\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010[\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010\\\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\f\u0010]\u001a\u0004\u0018\u000108X\u008a\u008e\u0002²\u0006\n\u0010^\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\f\u0010_\u001a\u0004\u0018\u000108X\u008a\u008e\u0002²\u0006\n\u0010`\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010a\u001a\u00020\u000fX\u008a\u008e\u0002"}, d2 = {"CatalogScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "CatalogHero", "summary", "Luz/FonRo/pos/ui/catalog/CatalogSummary;", "byPurchase", "", FirebaseAnalytics.Param.CURRENCY, "", "lowCount", "", "outCount", "stockFilter", "Luz/FonRo/pos/ui/catalog/StockFilter;", "onFilter", "Lkotlin/Function1;", "canAdd", "isOwner", "onCategories", "Lkotlin/Function0;", "onAddProduct", "onGlobalCatalog", "(Luz/FonRo/pos/ui/catalog/CatalogSummary;ZLjava/lang/String;IILuz/FonRo/pos/ui/catalog/StockFilter;Lkotlin/jvm/functions/Function1;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "KpiTile", "Landroidx/compose/foundation/layout/RowScope;", "value", "label", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "tint", "Landroidx/compose/ui/graphics/Color;", "selected", "onClick", "KpiTile-FHprtrg", "(Landroidx/compose/foundation/layout/RowScope;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;JZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "HeroAction", "text", "fill", "Landroidx/compose/ui/graphics/Brush;", "ink", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "HeroAction-hYmLsZ8", "(Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/ui/graphics/Brush;JLandroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "ProductRow", "product", "Luz/FonRo/pos/data/model/Product;", "categoryName", "lowStock", "", "showPurchase", "(Luz/FonRo/pos/data/model/Product;Ljava/lang/String;DZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ProductThumb", "size", "Landroidx/compose/ui/unit/Dp;", "ProductThumb-RFCenO8", "(Luz/FonRo/pos/data/model/Product;JFLandroidx/compose/runtime/Composer;I)V", "TagPill", "TagPill-3IgeMak", "(Ljava/lang/String;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ProductArchiveSheet", CacheStore.PRODUCTS, "", "loaded", "", "onDismiss", "onOpen", "(Ljava/util/List;ZDZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "BarcodeScanSheet", "onResult", "scrim", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)V", "parseHexColor", "raw", CacheStore.CATEGORIES, "Luz/FonRo/pos/data/model/Category;", FirebaseAnalytics.Event.SEARCH, "categoryId", "archived", "archivedLoaded", "scanOpen", "categoriesOpen", "archiveOpen", "cardProduct", "formOpen", "formProduct", "dataVersion", "granted"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class CatalogScreenKt {

    /* compiled from: CatalogScreen.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes7.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StockFilter.values().length];
            try {
                iArr[StockFilter.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StockFilter.OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviewView BarcodeScanSheet$lambda$8$0$0(PreviewView previewView, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return previewView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BarcodeScanSheet$lambda$9(Function0 function0, Function1 function1, boolean z, int i, int i2, Composer composer, int i3) {
        BarcodeScanSheet(function0, function1, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CatalogHero$lambda$1(CatalogSummary catalogSummary, boolean z, String str, int i, int i2, StockFilter stockFilter, Function1 function1, boolean z2, boolean z3, Function0 function0, Function0 function02, Function0 function03, int i3, int i4, Composer composer, int i5) {
        CatalogHero(catalogSummary, z, str, i, i2, stockFilter, function1, z2, z3, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CatalogScreen$lambda$57(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        CatalogScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit HeroAction_hYmLsZ8$lambda$1(String str, ImageVector imageVector, Brush brush, long j, Modifier modifier, boolean z, Function0 function0, int i, int i2, Composer composer, int i3) {
        m9772HeroActionhYmLsZ8(str, imageVector, brush, j, modifier, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit KpiTile_FHprtrg$lambda$1(RowScope rowScope, String str, String str2, ImageVector imageVector, long j, boolean z, Function0 function0, int i, Composer composer, int i2) {
        m9773KpiTileFHprtrg(rowScope, str, str2, imageVector, j, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ProductArchiveSheet$lambda$1(List list, boolean z, double d, boolean z2, Function1 function1, Function0 function0, Function1 function12, int i, Composer composer, int i2) {
        ProductArchiveSheet(list, z, d, z2, function1, function0, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ProductRow$lambda$3(Product product, String str, double d, boolean z, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ProductRow(product, str, d, z, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ProductThumb_RFCenO8$lambda$1(Product product, long j, float f, int i, Composer composer, int i2) {
        m9774ProductThumbRFCenO8(product, j, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TagPill_3IgeMak$lambda$0(String str, long j, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m9775TagPill3IgeMak(str, j, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0610  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0682  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x06f2  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x078f  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x08bb  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0932  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0921  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x07a0  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0814  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x088e  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0780  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x06e1  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0671  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0494  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void CatalogScreen(uz.FonRo.pos.FonRoApp r48, final uz.FonRo.pos.ui.nav.AppNavigator r49, androidx.compose.runtime.Composer r50, final int r51) {
        /*
            Method dump skipped, instructions count: 2380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.catalog.CatalogScreenKt.CatalogScreen(uz.FonRo.pos.FonRoApp, uz.FonRo.pos.ui.nav.AppNavigator, androidx.compose.runtime.Composer, int):void");
    }

    private static final String CatalogScreen$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final Long CatalogScreen$lambda$7(MutableState<Long> mutableState) {
        return mutableState.getValue();
    }

    private static final StockFilter CatalogScreen$lambda$10(MutableState<StockFilter> mutableState) {
        return mutableState.getValue();
    }

    private static final List<Product> CatalogScreen$lambda$13(MutableState<List<Product>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CatalogScreen$lambda$16(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CatalogScreen$lambda$17(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean CatalogScreen$lambda$19(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CatalogScreen$lambda$20(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean CatalogScreen$lambda$22(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CatalogScreen$lambda$23(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CatalogScreen$lambda$25(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CatalogScreen$lambda$26(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Product CatalogScreen$lambda$28(MutableState<Product> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean CatalogScreen$lambda$31(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CatalogScreen$lambda$32(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Product CatalogScreen$lambda$34(MutableState<Product> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$46$0(final List list, final MutableState mutableState, final MutableState mutableState2, final CatalogSummary catalogSummary, final boolean z, final String str, final int i, final int i2, final Repo repo, final boolean z2, final AppNavigator appNavigator, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, final MutableState mutableState8, final MutableState mutableState9, final State state, final double d, final MutableState mutableState10, LazyListScope LazyColumn) {
        LazyListScope lazyListScope;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1739132178, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit CatalogScreen$lambda$46$0$0;
                CatalogScreen$lambda$46$0$0 = CatalogScreenKt.CatalogScreen$lambda$46$0$0(MutableState.this, mutableState2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return CatalogScreen$lambda$46$0$0;
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1897437051, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit CatalogScreen$lambda$46$0$1;
                CatalogScreen$lambda$46$0$1 = CatalogScreenKt.CatalogScreen$lambda$46$0$1(CatalogSummary.this, z, str, i, i2, repo, z2, appNavigator, mutableState3, mutableState4, mutableState5, mutableState6, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return CatalogScreen$lambda$46$0$1;
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(240430810, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit CatalogScreen$lambda$46$0$2;
                CatalogScreen$lambda$46$0$2 = CatalogScreenKt.CatalogScreen$lambda$46$0$2(MutableState.this, mutableState8, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return CatalogScreen$lambda$46$0$2;
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1416575431, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit CatalogScreen$lambda$46$0$3;
                CatalogScreen$lambda$46$0$3 = CatalogScreenKt.CatalogScreen$lambda$46$0$3(MutableState.this, state, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return CatalogScreen$lambda$46$0$3;
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1221385624, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit CatalogScreen$lambda$46$0$4;
                CatalogScreen$lambda$46$0$4 = CatalogScreenKt.CatalogScreen$lambda$46$0$4(list, mutableState3, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return CatalogScreen$lambda$46$0$4;
            }
        }), 3, null);
        if (list.isEmpty()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$CatalogScreenKt.INSTANCE.getLambda$1586001623$app(), 3, null);
            lazyListScope = LazyColumn;
        } else {
            lazyListScope = LazyColumn;
        }
        final Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object CatalogScreen$lambda$46$0$5;
                CatalogScreen$lambda$46$0$5 = CatalogScreenKt.CatalogScreen$lambda$46$0$5((Product) obj);
                return CatalogScreen$lambda$46$0$5;
            }
        };
        final CatalogScreenKt$CatalogScreen$lambda$46$0$$inlined$items$default$1 catalogScreenKt$CatalogScreen$lambda$46$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$CatalogScreen$lambda$46$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Product product) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Product) obj);
            }
        };
        lazyListScope.items(list.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$CatalogScreen$lambda$46$0$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i3) {
                return Function1.this.invoke(list.get(i3));
            }
        }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$CatalogScreen$lambda$46$0$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i3) {
                return Function1.this.invoke(list.get(i3));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$CatalogScreen$lambda$46$0$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i3, Composer composer, int i4) {
                int i5;
                ComposerKt.sourceInformation(composer, "C178@8826L22:LazyDsl.kt#428nma");
                if ((i4 & 6) == 0) {
                    i5 = i4 | (composer.changed(lazyItemScope) ? 4 : 2);
                } else {
                    i5 = i4;
                }
                if ((i4 & 48) == 0) {
                    i5 |= composer.changed(i3) ? 32 : 16;
                }
                if (!composer.shouldExecute((i5 & 147) != 146, i5 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, i5, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                final Product product = (Product) list.get(i3);
                composer.startReplaceGroup(29356489);
                ComposerKt.sourceInformation(composer, "C*289@12217L19,284@12005L305:CatalogScreen.kt#i65cod");
                String categoryName = repo.categoryName(product.getCategoryId());
                double d2 = d;
                boolean z3 = z;
                ComposerKt.sourceInformationMarkerStart(composer, -1523067172, "CC(remember):CatalogScreen.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(product);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState11 = mutableState10;
                    rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$CatalogScreen$3$1$7$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            mutableState11.setValue(Product.this);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                CatalogScreenKt.ProductRow(product, categoryName, d2, z3, (Function0) rememberedValue, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(8.0f), 7, null), composer, 196992 | Product.$stable, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$46$0$0(final MutableState mutableState, final MutableState mutableState2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C190@8443L564,190@8418L589:CatalogScreen.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1739132178, i, -1, "uz.FonRo.pos.ui.catalog.CatalogScreen.<anonymous>.<anonymous>.<anonymous> (CatalogScreen.kt:190)");
            }
            PageHeadKt.OxPageHead(LangKt.tx("Товары", new Object[0]), null, null, false, ComposableLambdaKt.rememberComposableLambda(1730409121, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda41
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit CatalogScreen$lambda$46$0$0$0;
                    CatalogScreen$lambda$46$0$0$0 = CatalogScreenKt.CatalogScreen$lambda$46$0$0$0(MutableState.this, mutableState2, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return CatalogScreen$lambda$46$0$0$0;
                }
            }, composer, 54), composer, 24576, 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$46$0$0$0(final MutableState mutableState, MutableState mutableState2, RowScope OxPageHead, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxPageHead, "$this$OxPageHead");
        ComposerKt.sourceInformation(composer, "C194@8655L22,193@8611L382:CatalogScreen.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1730409121, i, -1, "uz.FonRo.pos.ui.catalog.CatalogScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CatalogScreen.kt:193)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 770828535, "CC(remember):CatalogScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CatalogScreen$lambda$46$0$0$0$0$0;
                        CatalogScreen$lambda$46$0$0$0$0$0 = CatalogScreenKt.CatalogScreen$lambda$46$0$0$0$0$0(MutableState.this);
                        return CatalogScreen$lambda$46$0$0$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            Integer valueOf = Integer.valueOf(CatalogScreen$lambda$13(mutableState2).size());
            if (valueOf.intValue() <= 0) {
                valueOf = null;
            }
            BasicsKt.m9831OxIconButtonhGBTI10(function0, null, valueOf != null ? String.valueOf(valueOf.intValue()) : null, 0.0f, ComposableSingletons$CatalogScreenKt.INSTANCE.getLambda$566335622$app(), composer, 24582, 10);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$46$0$0$0$0$0(MutableState mutableState) {
        CatalogScreen$lambda$26(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$46$0$1(CatalogSummary catalogSummary, boolean z, String str, int i, int i2, Repo repo, boolean z2, final AppNavigator appNavigator, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C206@9046L714:CatalogScreen.kt#i65cod");
        if (!composer.shouldExecute((i3 & 17) != 16, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1897437051, i3, -1, "uz.FonRo.pos.ui.catalog.CatalogScreen.<anonymous>.<anonymous>.<anonymous> (CatalogScreen.kt:206)");
            }
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
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
            ComposerKt.sourceInformationMarkerStart(composer, 738623485, "C214@9404L20,217@9559L25,218@9621L39,219@9700L28,207@9105L641:CatalogScreen.kt#i65cod");
            StockFilter CatalogScreen$lambda$10 = CatalogScreen$lambda$10(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, -2054374471, "CC(remember):CatalogScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit CatalogScreen$lambda$46$0$1$0$0$0;
                        CatalogScreen$lambda$46$0$1$0$0$0 = CatalogScreenKt.CatalogScreen$lambda$46$0$1$0$0$0(MutableState.this, (StockFilter) obj);
                        return CatalogScreen$lambda$46$0$1$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function1 function1 = (Function1) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            boolean can = repo.can(Perm.ADD_PRODUCT);
            ComposerKt.sourceInformationMarkerStart(composer, -2054369506, "CC(remember):CatalogScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CatalogScreen$lambda$46$0$1$0$1$0;
                        CatalogScreen$lambda$46$0$1$0$1$0 = CatalogScreenKt.CatalogScreen$lambda$46$0$1$0$1$0(MutableState.this);
                        return CatalogScreen$lambda$46$0$1$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            Function0 function0 = (Function0) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -2054367508, "CC(remember):CatalogScreen.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CatalogScreen$lambda$46$0$1$0$2$0;
                        CatalogScreen$lambda$46$0$1$0$2$0 = CatalogScreenKt.CatalogScreen$lambda$46$0$1$0$2$0(MutableState.this, mutableState4);
                        return CatalogScreen$lambda$46$0$1$0$2$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            Function0 function02 = (Function0) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -2054364991, "CC(remember):CatalogScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(appNavigator);
            Object rememberedValue4 = composer.rememberedValue();
            if (changedInstance || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CatalogScreen$lambda$46$0$1$0$3$0;
                        CatalogScreen$lambda$46$0$1$0$3$0 = CatalogScreenKt.CatalogScreen$lambda$46$0$1$0$3$0(AppNavigator.this);
                        return CatalogScreen$lambda$46$0$1$0$3$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CatalogHero(catalogSummary, z, str, i, i2, CatalogScreen$lambda$10, function1, can, z2, function0, function02, (Function0) rememberedValue4, composer, 806879232, 6);
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
    public static final Unit CatalogScreen$lambda$46$0$1$0$0$0(MutableState mutableState, StockFilter it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$46$0$1$0$1$0(MutableState mutableState) {
        CatalogScreen$lambda$23(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$46$0$1$0$2$0(MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(null);
        CatalogScreen$lambda$32(mutableState2, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$46$0$1$0$3$0(AppNavigator appNavigator) {
        appNavigator.open(Routes.CATSHOP);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$46$0$2(final MutableState mutableState, final MutableState mutableState2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C225@9799L1141:CatalogScreen.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(240430810, i, -1, "uz.FonRo.pos.ui.catalog.CatalogScreen.<anonymous>.<anonymous>.<anonymous> (CatalogScreen.kt:225)");
            }
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
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
            ComposerKt.sourceInformationMarkerStart(composer, 505364218, "C232@10128L15,230@10043L243,242@10610L19,242@10604L25,236@10303L623:CatalogScreen.kt#i65cod");
            String CatalogScreen$lambda$4 = CatalogScreen$lambda$4(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 1678871909, "CC(remember):CatalogScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit CatalogScreen$lambda$46$0$2$0$0$0;
                        CatalogScreen$lambda$46$0$2$0$0$0 = CatalogScreenKt.CatalogScreen$lambda$46$0$2$0$0$0(MutableState.this, (String) obj);
                        return CatalogScreen$lambda$46$0$2$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.OxSearchBox(CatalogScreen$lambda$4, (Function1) rememberedValue, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), LangKt.tx("Поиск товара, артикула или кода", new Object[0]), null, composer, 48, 16);
            Modifier m569borderxT4_qwU = BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, OxDim.INSTANCE.m10249getTapD9Ej5fM()), OxShape.INSTANCE.getField()), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10192getCyan0d7_KjU(), 0.14f), null, 2, null), Dp.m6989constructorimpl(1.0f), Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10192getCyan0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), OxShape.INSTANCE.getField());
            ComposerKt.sourceInformationMarkerStart(composer, 1678887337, "CC(remember):CatalogScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CatalogScreen$lambda$46$0$2$0$1$0;
                        CatalogScreen$lambda$46$0$2$0$1$0 = CatalogScreenKt.CatalogScreen$lambda$46$0$2$0$1$0(MutableState.this);
                        return CatalogScreen$lambda$46$0$2$0$1$0;
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
            ComposerKt.sourceInformationMarkerStart(composer, 1791432830, "C245@10727L181:CatalogScreen.kt#i65cod");
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
    public static final Unit CatalogScreen$lambda$46$0$2$0$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$46$0$2$0$1$0(MutableState mutableState) {
        CatalogScreen$lambda$20(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$46$0$3(final MutableState mutableState, final State state, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C254@10989L434,254@10979L444:CatalogScreen.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1416575431, i, -1, "uz.FonRo.pos.ui.catalog.CatalogScreen.<anonymous>.<anonymous>.<anonymous> (CatalogScreen.kt:254)");
            }
            ChipsKt.OxChipRow(null, ComposableLambdaKt.rememberComposableLambda(-321098360, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit CatalogScreen$lambda$46$0$3$0;
                    CatalogScreen$lambda$46$0$3$0 = CatalogScreenKt.CatalogScreen$lambda$46$0$3$0(MutableState.this, state, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return CatalogScreen$lambda$46$0$3$0;
                }
            }, composer, 54), composer, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$46$0$3$0(final MutableState mutableState, State state, RowScope OxChipRow, Composer composer, int i) {
        String str;
        boolean z;
        Intrinsics.checkNotNullParameter(OxChipRow, "$this$OxChipRow");
        ComposerKt.sourceInformation(composer, "C255@11067L21,255@11007L82,*260@11289L21,257@11152L239:CatalogScreen.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-321098360, i, -1, "uz.FonRo.pos.ui.catalog.CatalogScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CatalogScreen.kt:255)");
            }
            String tx = LangKt.tx("Все", new Object[0]);
            boolean z2 = CatalogScreen$lambda$7(mutableState) == null;
            ComposerKt.sourceInformationMarkerStart(composer, 662123869, "CC(remember):CatalogScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda39
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CatalogScreen$lambda$46$0$3$0$0$0;
                        CatalogScreen$lambda$46$0$3$0$0$0 = CatalogScreenKt.CatalogScreen$lambda$46$0$3$0$0$0(MutableState.this);
                        return CatalogScreen$lambda$46$0$3$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.m9837OxCatChipFV1VA1c(tx, z2, (Function0) rememberedValue, null, null, null, composer, 384, 56);
            for (final Category category : CatalogScreen$lambda$1(state)) {
                String name = category.getName();
                Long CatalogScreen$lambda$7 = CatalogScreen$lambda$7(mutableState);
                long id = category.getId();
                if (CatalogScreen$lambda$7 != null && CatalogScreen$lambda$7.longValue() == id) {
                    str = name;
                    z = true;
                } else {
                    str = name;
                    z = false;
                }
                ComposerKt.sourceInformationMarkerStart(composer, 1715139072, "CC(remember):CatalogScreen.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(category);
                Object rememberedValue2 = composer.rememberedValue();
                if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda40
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CatalogScreen$lambda$46$0$3$0$1$0$0;
                            CatalogScreen$lambda$46$0$3$0$1$0$0 = CatalogScreenKt.CatalogScreen$lambda$46$0$3$0$1$0$0(Category.this, mutableState);
                            return CatalogScreen$lambda$46$0$3$0$1$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ChipsKt.m9837OxCatChipFV1VA1c(str, z, (Function0) rememberedValue2, null, null, parseHexColor(category.getColor()), composer, 0, 24);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$46$0$3$0$0$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$46$0$3$0$1$0$0(Category category, MutableState mutableState) {
        mutableState.setValue(Long.valueOf(category.getId()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$46$0$4(List list, MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        String tx;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C268@11462L375:CatalogScreen.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1221385624, i, -1, "uz.FonRo.pos.ui.catalog.CatalogScreen.<anonymous>.<anonymous>.<anonymous> (CatalogScreen.kt:268)");
            }
            int i2 = WhenMappings.$EnumSwitchMapping$0[CatalogScreen$lambda$10(mutableState).ordinal()];
            if (i2 == 1) {
                tx = LangKt.tx("Мало на складе", new Object[0]);
            } else if (i2 == 2) {
                tx = LangKt.tx("Нет в наличии", new Object[0]);
            } else {
                tx = LangKt.tx("Активные товары", new Object[0]);
            }
            BasicsKt.OxSectionHead(tx, null, LangKt.tx("Карточка товара — тап по строке", new Object[0]), String.valueOf(list.size()), null, null, composer, 0, 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object CatalogScreen$lambda$46$0$5(Product it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$47$0(MutableState mutableState) {
        CatalogScreen$lambda$20(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$48$0(Repo repo, MutableState mutableState, MutableState mutableState2, String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        mutableState.setValue(code);
        Product findByBarcode = repo.findByBarcode(code);
        if (findByBarcode == null) {
            Toaster.INSTANCE.error(LangKt.tx("Товар с таким кодом не найден", new Object[0]));
        } else {
            mutableState2.setValue(findByBarcode);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$49$0(MutableState mutableState) {
        CatalogScreen$lambda$23(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$50$0(MutableState mutableState, MutableState mutableState2, Long l) {
        mutableState.setValue(l);
        mutableState2.setValue(StockFilter.ALL);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$52$0(MutableState mutableState) {
        CatalogScreen$lambda$26(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$53$0(MutableState mutableState, MutableState mutableState2, Product p) {
        Intrinsics.checkNotNullParameter(p, "p");
        CatalogScreen$lambda$26(mutableState, false);
        mutableState2.setValue(p);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$54$2$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$54$3$0(Product product, MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(product);
        CatalogScreen$lambda$32(mutableState2, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$54$4$0(Product product, MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(CollectionsKt.plus((Collection<? extends Product>) CatalogScreen$lambda$13(mutableState), Product.copy$default(product, 0L, null, null, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0L, AudioStats.AUDIO_AMPLITUDE_NONE, null, null, null, null, 1, 32767, null)));
        mutableState2.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$54$5$0(MutableState mutableState, MutableState mutableState2, Product restored) {
        Intrinsics.checkNotNullParameter(restored, "restored");
        List<Product> CatalogScreen$lambda$13 = CatalogScreen$lambda$13(mutableState);
        ArrayList arrayList = new ArrayList();
        for (Object obj : CatalogScreen$lambda$13) {
            if (((Product) obj).getId() != restored.getId()) {
                arrayList.add(obj);
            }
        }
        mutableState.setValue(arrayList);
        mutableState2.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$55$0(MutableState mutableState) {
        CatalogScreen$lambda$32(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogScreen$lambda$56$0(MutableState mutableState, MutableState mutableState2, Product saved) {
        Intrinsics.checkNotNullParameter(saved, "saved");
        List<Product> CatalogScreen$lambda$13 = CatalogScreen$lambda$13(mutableState);
        ArrayList arrayList = new ArrayList();
        for (Object obj : CatalogScreen$lambda$13) {
            if (((Product) obj).getId() != saved.getId()) {
                arrayList.add(obj);
            }
        }
        mutableState.setValue(arrayList);
        Product CatalogScreen$lambda$28 = CatalogScreen$lambda$28(mutableState2);
        if (CatalogScreen$lambda$28 != null && CatalogScreen$lambda$28.getId() == saved.getId()) {
            mutableState2.setValue(saved);
        }
        return Unit.INSTANCE;
    }

    private static final void CatalogHero(final CatalogSummary catalogSummary, final boolean z, final String str, final int i, final int i2, final StockFilter stockFilter, final Function1<? super StockFilter, Unit> function1, final boolean z2, final boolean z3, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, Composer composer, final int i3, final int i4) {
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1459113466);
        ComposerKt.sourceInformation(startRestartGroup, "C(CatalogHero)P(11!1,2,4,9,10,7!2,6)398@15605L4579:CatalogScreen.kt#i65cod");
        if ((i3 & 6) == 0) {
            i5 = (startRestartGroup.changed(catalogSummary) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= startRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i5 |= startRestartGroup.changed(i) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= startRestartGroup.changed(i2) ? 16384 : 8192;
        }
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i5 |= startRestartGroup.changed(stockFilter.ordinal()) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i5 |= startRestartGroup.changedInstance(function1) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i5 |= startRestartGroup.changed(z2) ? 8388608 : 4194304;
        }
        if ((i3 & 100663296) == 0) {
            i5 |= startRestartGroup.changed(z3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i3 & 805306368) == 0) {
            i5 |= startRestartGroup.changedInstance(function0) ? 536870912 : 268435456;
        }
        if ((i4 & 6) == 0) {
            i6 = i4 | (startRestartGroup.changedInstance(function02) ? 4 : 2);
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function03) ? 32 : 16;
        }
        int i7 = i6;
        if (!startRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i7 & 19) == 18) ? false : true, i5 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1459113466, i5, i7, "uz.FonRo.pos.ui.catalog.CatalogHero (CatalogScreen.kt:392)");
            }
            Modifier m1049padding3ABfNKs = PaddingKt.m1049padding3ABfNKs(BorderKt.m569borderxT4_qwU(BackgroundKt.background$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), OxShape.INSTANCE.getHero()), Brush.Companion.m4336linearGradientmHitzGk$default(Brush.INSTANCE, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10224getRed0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null))), TuplesKt.to(Float.valueOf(0.52f), Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10213getOrange0d7_KjU(), 0.13f, 0.0f, 0.0f, 0.0f, 14, null))), TuplesKt.to(Float.valueOf(1.0f), Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10223getPurple0d7_KjU(), 0.09f, 0.0f, 0.0f, 0.0f, 14, null)))}, 0L, 0L, 0, 14, (Object) null), null, 0.0f, 6, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10205getHeroEdge0d7_KjU(), OxShape.INSTANCE.getHero()), Dp.m6989constructorimpl(16.0f));
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 704309866, "C406@15829L1213,437@17051L11,439@17072L720,457@17801L10,458@17820L715,476@18544L11,478@18565L911:CatalogScreen.kt#i65cod");
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 50022329, "C411@16030L557,424@16600L432:CatalogScreen.kt#i65cod");
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, weight$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            int i8 = i5;
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
            Updater.m3815setimpl(m3808constructorimpl3, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -196934564, "C412@16076L174,416@16267L306:CatalogScreen.kt#i65cod");
            TextKt.m2798Text4IGK_g(z ? LangKt.tx("Стоимость склада по закупке", new Object[0]) : LangKt.tx("Стоимость склада по продаже", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getLabel(), startRestartGroup, 0, 0, 65534);
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.money(Double.valueOf(catalogSummary.getValue()), str), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(4.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH1(), 0L, OxType.INSTANCE.getAmount().m6466getFontSizeXSAIIZE(), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), startRestartGroup, 48, 3120, 55292);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(52.0f)), OxShape.INSTANCE.getTile()), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10213getOrange0d7_KjU(), 0.16f), null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, m558backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor4);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3808constructorimpl4 = Updater.m3808constructorimpl(startRestartGroup);
            Updater.m3815setimpl(m3808constructorimpl4, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl4.getInserting() || !Intrinsics.areEqual(m3808constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m3808constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m3808constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3815setimpl(m3808constructorimpl4, materializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 135172543, "C431@16860L158:CatalogScreen.kt#i65cod");
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getCash(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(24.0f)), Ox.INSTANCE.m10214getOrangeDeep0d7_KjU(), startRestartGroup, 432, 0);
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
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(14.0f), startRestartGroup, 6);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(9.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default2);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor5);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3808constructorimpl5 = Updater.m3808constructorimpl(startRestartGroup);
            Updater.m3815setimpl(m3808constructorimpl5, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl5.getInserting() || !Intrinsics.areEqual(m3808constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                m3808constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                m3808constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m3815setimpl(m3808constructorimpl5, materializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 307117125, "C446@17430L29,440@17167L306,454@17739L29,448@17486L296:CatalogScreen.kt#i65cod");
            String nf = Fmt.INSTANCE.nf(Double.valueOf(catalogSummary.getProducts()));
            String tx = LangKt.tx("Активные", new Object[0]);
            ImageVector box = OxIcons.INSTANCE.getBox();
            long m10192getCyan0d7_KjU = Ox.INSTANCE.m10192getCyan0d7_KjU();
            boolean z4 = stockFilter == StockFilter.ALL;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2068295148, "CC(remember):CatalogScreen.kt#9igjgp");
            int i9 = i8 & 3670016;
            boolean z5 = i9 == 1048576;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda44
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CatalogHero$lambda$0$1$0$0;
                        CatalogHero$lambda$0$1$0$0 = CatalogScreenKt.CatalogHero$lambda$0$1$0$0(Function1.this);
                        return CatalogHero$lambda$0$1$0$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            m9773KpiTileFHprtrg(rowScopeInstance2, nf, tx, box, m10192getCyan0d7_KjU, z4, (Function0) rememberedValue, startRestartGroup, 6);
            String qf = Fmt.INSTANCE.qf(Double.valueOf(catalogSummary.getUnits()));
            String tx2 = LangKt.tx("Остаток, шт", new Object[0]);
            ImageVector sum = OxIcons.INSTANCE.getSum();
            long m10201getGreen0d7_KjU = Ox.INSTANCE.m10201getGreen0d7_KjU();
            boolean z6 = stockFilter == StockFilter.ALL;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2068285260, "CC(remember):CatalogScreen.kt#9igjgp");
            boolean z7 = i9 == 1048576;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda52
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CatalogHero$lambda$0$1$1$0;
                        CatalogHero$lambda$0$1$1$0 = CatalogScreenKt.CatalogHero$lambda$0$1$1$0(Function1.this);
                        return CatalogHero$lambda$0$1$1$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            m9773KpiTileFHprtrg(rowScopeInstance2, qf, tx2, sum, m10201getGreen0d7_KjU, z6, (Function0) rememberedValue2, startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(9.0f), startRestartGroup, 6);
            Modifier fillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_43 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(9.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m930spacedBy0680j_43, Alignment.INSTANCE.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap6 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default3);
            Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor6);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3808constructorimpl6 = Updater.m3808constructorimpl(startRestartGroup);
            Updater.m3815setimpl(m3808constructorimpl6, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl6.getInserting() || !Intrinsics.areEqual(m3808constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                m3808constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                m3808constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
            }
            Updater.m3815setimpl(m3808constructorimpl6, materializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1258948809, "C465@18173L29,459@17915L301,473@18482L29,467@18229L296:CatalogScreen.kt#i65cod");
            String valueOf = String.valueOf(i);
            String tx3 = LangKt.tx("Мало на складе", new Object[0]);
            ImageVector warning = OxIcons.INSTANCE.getWarning();
            long m10184getAmber0d7_KjU = Ox.INSTANCE.m10184getAmber0d7_KjU();
            boolean z8 = stockFilter == StockFilter.LOW;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1899043723, "CC(remember):CatalogScreen.kt#9igjgp");
            boolean z9 = i9 == 1048576;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z9 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda53
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CatalogHero$lambda$0$2$0$0;
                        CatalogHero$lambda$0$2$0$0 = CatalogScreenKt.CatalogHero$lambda$0$2$0$0(Function1.this);
                        return CatalogHero$lambda$0$2$0$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            m9773KpiTileFHprtrg(rowScopeInstance3, valueOf, tx3, warning, m10184getAmber0d7_KjU, z8, (Function0) rememberedValue3, startRestartGroup, 6);
            String valueOf2 = String.valueOf(i2);
            String tx4 = LangKt.tx("Нет в наличии", new Object[0]);
            ImageVector close = OxIcons.INSTANCE.getClose();
            long m10224getRed0d7_KjU = Ox.INSTANCE.m10224getRed0d7_KjU();
            boolean z10 = stockFilter == StockFilter.OUT;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1899033835, "CC(remember):CatalogScreen.kt#9igjgp");
            boolean z11 = i9 == 1048576;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z11 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda54
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CatalogHero$lambda$0$2$1$0;
                        CatalogHero$lambda$0$2$1$0 = CatalogScreenKt.CatalogHero$lambda$0$2$1$0(Function1.this);
                        return CatalogHero$lambda$0$2$1$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            m9773KpiTileFHprtrg(rowScopeInstance3, valueOf2, tx4, close, m10224getRed0d7_KjU, z10, (Function0) rememberedValue4, startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), startRestartGroup, 6);
            Modifier fillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_44 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(m930spacedBy0680j_44, Alignment.INSTANCE.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap7 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier7 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default4);
            Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor7);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3808constructorimpl7 = Updater.m3808constructorimpl(startRestartGroup);
            Updater.m3815setimpl(m3808constructorimpl7, rowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl7.getInserting() || !Intrinsics.areEqual(m3808constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                m3808constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                m3808constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
            }
            Updater.m3815setimpl(m3808constructorimpl7, materializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2084180603, "C479@18661L377,489@19051L415:CatalogScreen.kt#i65cod");
            m9772HeroActionhYmLsZ8(LangKt.tx("Категории", new Object[0]), OxIcons.INSTANCE.getGrid(), Brush.Companion.m4333horizontalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10201getGreen0d7_KjU(), 0.26f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10202getGreenDeep0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), Ox.INSTANCE.m10211getOk0d7_KjU(), RowScope.weight$default(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null), false, function0, startRestartGroup, (i8 >> 9) & 3670016, 32);
            m9772HeroActionhYmLsZ8(LangKt.tx("Добавить товар", new Object[0]), OxIcons.INSTANCE.getAdd(), Brush.Companion.m4333horizontalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10192getCyan0d7_KjU(), 0.34f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10186getBlue0d7_KjU(), 0.28f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), Ox.INSTANCE.m10193getCyanDeep0d7_KjU(), RowScope.weight$default(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null), z2, function02, startRestartGroup, (458752 & (i8 >> 6)) | ((i7 << 18) & 3670016), 0);
            startRestartGroup = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (z3) {
                startRestartGroup.startReplaceGroup(707978963);
                ComposerKt.sourceInformation(startRestartGroup, "505@19661L11,506@19685L483");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), startRestartGroup, 6);
                Modifier fillMaxWidth$default5 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy5 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap8 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier8 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default5);
                Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor8);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3808constructorimpl8 = Updater.m3808constructorimpl(startRestartGroup);
                Updater.m3815setimpl(m3808constructorimpl8, rowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3815setimpl(m3808constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3808constructorimpl8.getInserting() || !Intrinsics.areEqual(m3808constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
                    m3808constructorimpl8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                    m3808constructorimpl8.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
                }
                Updater.m3815setimpl(m3808constructorimpl8, materializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1411151298, "C507@19732L422:CatalogScreen.kt#i65cod");
                m9772HeroActionhYmLsZ8(LangKt.tx("Каталог FonRo", new Object[0]), OxIcons.INSTANCE.getBag(), Brush.Companion.m4333horizontalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10223getPurple0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10208getIndigo0d7_KjU(), 0.26f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), Ox.INSTANCE.m10208getIndigo0d7_KjU(), RowScope.weight$default(rowScopeInstance5, Modifier.INSTANCE, 1.0f, false, 2, null), false, function03, startRestartGroup, (i7 << 15) & 3670016, 32);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(708489254);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda55
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CatalogScreenKt.CatalogHero$lambda$1(CatalogSummary.this, z, str, i, i2, stockFilter, function1, z2, z3, function0, function02, function03, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogHero$lambda$0$1$0$0(Function1 function1) {
        function1.invoke(StockFilter.ALL);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogHero$lambda$0$1$1$0(Function1 function1) {
        function1.invoke(StockFilter.ALL);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogHero$lambda$0$2$0$0(Function1 function1) {
        function1.invoke(StockFilter.LOW);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CatalogHero$lambda$0$2$1$0(Function1 function1) {
        function1.invoke(StockFilter.OUT);
        return Unit.INSTANCE;
    }

    /* renamed from: KpiTile-FHprtrg, reason: not valid java name */
    private static final void m9773KpiTileFHprtrg(final RowScope rowScope, final String str, final String str2, final ImageVector imageVector, final long j, final boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        int i3;
        long m10242tintBorderl2rxGTc;
        Composer startRestartGroup = composer.startRestartGroup(-1346113179);
        ComposerKt.sourceInformation(startRestartGroup, "C(KpiTile)P(5,1!1,4:c#ui.graphics.Color,3)542@20787L24,532@20439L1227:CatalogScreen.kt#i65cod");
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
            i2 |= startRestartGroup.changed(imageVector) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(j) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(z) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 1048576 : 524288;
        }
        if (!startRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1346113179, i2, -1, "uz.FonRo.pos.ui.catalog.KpiTile (CatalogScreen.kt:531)");
            }
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), OxShape.INSTANCE.getTile()), Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10217getPanel0d7_KjU(), z ? 0.92f : 0.72f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
            float m6989constructorimpl = Dp.m6989constructorimpl(1.0f);
            if (z) {
                i3 = i2;
                m10242tintBorderl2rxGTc = Color.m4383copywmQWz5c$default(j, 0.65f, 0.0f, 0.0f, 0.0f, 14, null);
            } else {
                i3 = i2;
                m10242tintBorderl2rxGTc = Ox.INSTANCE.m10242tintBorderl2rxGTc(j);
            }
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(ModifiersKt.oxTap(BorderKt.m569borderxT4_qwU(m558backgroundbw27NRU$default, m6989constructorimpl, m10242tintBorderl2rxGTc, OxShape.INSTANCE.getTile()), false, function0, startRestartGroup, (i3 >> 12) & 896, 1), Dp.m6989constructorimpl(10.0f), Dp.m6989constructorimpl(9.0f));
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1873042608, "C547@21002L349,556@21360L300:CatalogScreen.kt#i65cod");
            Modifier m558backgroundbw27NRU$default2 = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(32.0f)), OxShape.INSTANCE.getIconChip()), Ox.INSTANCE.m10241tintBg5vOe2sY(j, z ? 0.26f : 0.14f), null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m558backgroundbw27NRU$default2);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1026518603, "C554@21258L83:CatalogScreen.kt#i65cod");
            int i4 = i3 >> 3;
            IconKt.m2255Iconww6aTOc(imageVector, (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(17.0f)), j, startRestartGroup, ((i3 >> 9) & 14) | 432 | (i4 & 7168), 0);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1979302368, "C557@21402L163,563@21578L72:CatalogScreen.kt#i65cod");
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getTileValue(), startRestartGroup, i4 & 14, 3120, 55294);
            TextKt.m2798Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getTileLabel(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), startRestartGroup, (i3 >> 6) & 14, 3072, 57342);
            startRestartGroup = startRestartGroup;
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda33
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CatalogScreenKt.KpiTile_FHprtrg$lambda$1(RowScope.this, str, str2, imageVector, j, z, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x007f  */
    /* renamed from: HeroAction-hYmLsZ8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m9772HeroActionhYmLsZ8(final java.lang.String r68, final androidx.compose.ui.graphics.vector.ImageVector r69, final androidx.compose.ui.graphics.Brush r70, final long r71, androidx.compose.ui.Modifier r73, boolean r74, final kotlin.jvm.functions.Function0<kotlin.Unit> r75, androidx.compose.runtime.Composer r76, final int r77, final int r78) {
        /*
            Method dump skipped, instructions count: 717
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.catalog.CatalogScreenKt.m9772HeroActionhYmLsZ8(java.lang.String, androidx.compose.ui.graphics.vector.ImageVector, androidx.compose.ui.graphics.Brush, long, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ProductRow(final uz.FonRo.pos.data.model.Product r21, final java.lang.String r22, final double r23, final boolean r25, final kotlin.jvm.functions.Function0<kotlin.Unit> r26, androidx.compose.ui.Modifier r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instructions count: 506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.catalog.CatalogScreenKt.ProductRow(uz.FonRo.pos.data.model.Product, java.lang.String, double, boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ProductRow$lambda$2(Product product, long j, String str, int i, boolean z, String str2, ColumnScope OxCard, Composer composer, int i2) {
        boolean z2;
        Intrinsics.checkNotNullParameter(OxCard, "$this$OxCard");
        ComposerKt.sourceInformation(composer, "C631@23807L1610:CatalogScreen.kt#i65cod");
        if (!composer.shouldExecute((i2 & 17) != 16, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-993715334, i2, -1, "uz.FonRo.pos.ui.catalog.ProductRow.<anonymous> (CatalogScreen.kt:631)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -544056927, "C636@23995L63,637@24071L1253,660@25337L70:CatalogScreen.kt#i65cod");
            m9774ProductThumbRFCenO8(product, j, Dp.m6989constructorimpl(50.0f), composer, Product.$stable | 384);
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(4.0f));
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getStart(), composer, 6);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1760877736, "C638@24167L664,651@24848L86,652@24951L233:CatalogScreen.kt#i65cod");
            Arrangement.HorizontalOrVertical m930spacedBy0680j_43 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_43, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, companion);
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
            ComposerKt.sourceInformationMarkerStart(composer, 45411877, "C644@24519L228:CatalogScreen.kt#i65cod");
            TextKt.m2798Text4IGK_g(product.getName(), rowScopeInstance2.weight(Modifier.INSTANCE, 1.0f, false), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowTitle(), 0L, TextUnitKt.getSp(13.5d), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(18), null, null, null, 0, 0, null, 16646141, null), composer, 0, 0, 65532);
            if (z) {
                composer.startReplaceGroup(-1245452937);
                ComposerKt.sourceInformation(composer, "649@24782L31");
                z2 = false;
                m9775TagPill3IgeMak(LangKt.tx("Архив", new Object[0]), Ox.INSTANCE.m10223getPurple0d7_KjU(), null, composer, 0, 4);
            } else {
                z2 = false;
                composer.startReplaceGroup(45694410);
            }
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 0, 3120, 55294);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_44 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(6.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m930spacedBy0680j_44, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, companion2);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1768417653, "C654@25132L34:CatalogScreen.kt#i65cod");
            String sku = product.getSku();
            if (sku == null || StringsKt.isBlank(sku)) {
                sku = null;
            }
            if (sku == null) {
                composer.startReplaceGroup(-1768379959);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1768379958);
                ComposerKt.sourceInformation(composer, "*653@25076L33");
                m9775TagPill3IgeMak(LangKt.tx("Арт: %s", sku), Ox.INSTANCE.m10211getOk0d7_KjU(), null, composer, 0, 4);
                Unit unit = Unit.INSTANCE;
                composer.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            m9775TagPill3IgeMak(str2, Ox.INSTANCE.m10193getCyanDeep0d7_KjU(), null, composer, 0, 4);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (i > 1) {
                composer.startReplaceGroup(-1759867726);
                ComposerKt.sourceInformation(composer, "657@25240L52");
                m9775TagPill3IgeMak(LangKt.tx("Штрихкодов: %s", Integer.valueOf(i)), Ox.INSTANCE.m10215getOrangeInk0d7_KjU(), null, composer, 0, 4);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1759779314);
                composer.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.nf(Double.valueOf(product.getSalePrice())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowPrice(), composer, 0, 3072, 57342);
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

    /* renamed from: ProductThumb-RFCenO8, reason: not valid java name */
    public static final void m9774ProductThumbRFCenO8(final Product product, final long j, final float f, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(product, "product");
        Composer startRestartGroup = composer.startRestartGroup(-1534394551);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProductThumb)P(!1,2:c#ui.graphics.Color,1:c#ui.unit.Dp)668@25608L734:CatalogScreen.kt#i65cod");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(product) : startRestartGroup.changedInstance(product) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(f) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1534394551, i2, -1, "uz.FonRo.pos.ui.catalog.ProductThumb (CatalogScreen.kt:667)");
            }
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, f), OxShape.INSTANCE.getImg()), Ox.INSTANCE.m10241tintBg5vOe2sY(j, 0.16f), null, 2, null);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -319204255, "C:CatalogScreen.kt#i65cod");
            String photo = product.getPhoto();
            if (photo != null) {
                startRestartGroup.startReplaceGroup(-319148084);
                ComposerKt.sourceInformation(startRestartGroup, "677@25872L199");
                SingletonAsyncImageKt.m7640AsyncImagegl8XCv8(photo, null, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, false, null, startRestartGroup, 1573296, 0, 4024);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-318920110);
                ComposerKt.sourceInformation(startRestartGroup, "684@26101L225");
                IconKt.m2255Iconww6aTOc(product.isArchived() == 1 ? OxIcons.INSTANCE.getArchive() : OxIcons.INSTANCE.getBox(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(0.44f * f)), j, startRestartGroup, ((i2 << 6) & 7168) | 48, 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda47
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CatalogScreenKt.ProductThumb_RFCenO8$lambda$1(Product.this, j, f, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005d  */
    /* renamed from: TagPill-3IgeMak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m9775TagPill3IgeMak(final java.lang.String r36, final long r37, androidx.compose.ui.Modifier r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.catalog.CatalogScreenKt.m9775TagPill3IgeMak(java.lang.String, long, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void ProductArchiveSheet(final List<Product> list, final boolean z, final double d, final boolean z2, final Function1<? super Long, String> function1, final Function0<Unit> function0, final Function1<? super Product, Unit> function12, Composer composer, final int i) {
        int i2;
        boolean z3;
        final double d2;
        final boolean z4;
        Function1<? super Long, String> function13;
        Function1<? super Product, Unit> function14;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(252205215);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProductArchiveSheet)P(5,1,2,6)721@27162L1949,721@27098L2013:CatalogScreen.kt#i65cod");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(list) : startRestartGroup.changedInstance(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            z3 = z;
            i2 |= startRestartGroup.changed(z3) ? 32 : 16;
        } else {
            z3 = z;
        }
        if ((i & 384) == 0) {
            d2 = d;
            i2 |= startRestartGroup.changed(d2) ? 256 : 128;
        } else {
            d2 = d;
        }
        if ((i & 3072) == 0) {
            z4 = z2;
            i2 |= startRestartGroup.changed(z4) ? 2048 : 1024;
        } else {
            z4 = z2;
        }
        if ((i & 24576) == 0) {
            function13 = function1;
            i2 |= startRestartGroup.changedInstance(function13) ? 16384 : 8192;
        } else {
            function13 = function1;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            function14 = function12;
            i2 |= startRestartGroup.changedInstance(function14) ? 1048576 : 524288;
        } else {
            function14 = function12;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(252205215, i3, -1, "uz.FonRo.pos.ui.catalog.ProductArchiveSheet (CatalogScreen.kt:720)");
            }
            final boolean z5 = z3;
            final Function1<? super Long, String> function15 = function13;
            final Function1<? super Product, Unit> function16 = function14;
            composer2 = startRestartGroup;
            SheetsKt.OxCardSheet(LangKt.tx("Архив товаров", new Object[0]), function0, null, false, false, false, null, ComposableLambdaKt.rememberComposableLambda(889723907, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CatalogScreenKt.ProductArchiveSheet$lambda$0(list, z5, function15, d2, z4, function16, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), composer2, ((i3 >> 12) & 112) | 12582912, 124);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CatalogScreenKt.ProductArchiveSheet$lambda$1(list, z, d, z2, function1, function0, function12, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ProductArchiveSheet$lambda$0(List list, boolean z, Function1 function1, double d, boolean z2, final Function1 function12, ColumnScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C722@27203L21,722@27172L1933:CatalogScreen.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(889723907, i, -1, "uz.FonRo.pos.ui.catalog.ProductArchiveSheet.<anonymous> (CatalogScreen.kt:722)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 286513240, "C723@27241L1216,753@28470L11,769@29085L10:CatalogScreen.kt#i65cod");
            Modifier m1049padding3ABfNKs = PaddingKt.m1049padding3ABfNKs(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), OxShape.INSTANCE.getCard()), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10223getPurple0d7_KjU(), 0.1f), null, 2, null), Dp.m6989constructorimpl(14.0f));
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, m1049padding3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composer, 363373411, "C732@27620L475,744@28112L331:CatalogScreen.kt#i65cod");
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(48.0f)), OxShape.INSTANCE.getTile()), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10223getPurple0d7_KjU(), 0.16f), null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, m558backgroundbw27NRU$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 2017922615, "C739@27908L169:CatalogScreen.kt#i65cod");
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getArchive(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(22.0f)), Ox.INSTANCE.m10223getPurple0d7_KjU(), composer, 432, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, weight$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 639443465, "C745@28162L48,746@28231L194:CatalogScreen.kt#i65cod");
            TextKt.m2798Text4IGK_g(LangKt.tx("Скрыты из продажи", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH3(), composer, 0, 0, 65534);
            TextKt.m2798Text4IGK_g(LangKt.tx("Всего: ", new Object[0]) + list.size(), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(2.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 48, 0, 65532);
            Composer composer2 = composer;
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
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer2, 6);
            if (list.isEmpty()) {
                composer2.startReplaceGroup(287726703);
                ComposerKt.sourceInformation(composer2, "756@28537L70");
                BasicsKt.OxEmptyNote(z ? LangKt.tx("Архив пуст.", new Object[0]) : LangKt.tx("Загружаем архив…", new Object[0]), null, composer2, 0, 2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(287844472);
                ComposerKt.sourceInformation(composer2, "*764@28937L13,759@28689L351");
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    final Product product = (Product) it.next();
                    String str = (String) function1.invoke(Long.valueOf(product.getCategoryId()));
                    ComposerKt.sourceInformationMarkerStart(composer2, -850886978, "CC(remember):CatalogScreen.kt#9igjgp");
                    boolean changed = composer2.changed(function12) | composer2.changedInstance(product);
                    Object rememberedValue = composer2.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda48
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit ProductArchiveSheet$lambda$0$0$1$0$0;
                                ProductArchiveSheet$lambda$0$0$1$0$0 = CatalogScreenKt.ProductArchiveSheet$lambda$0$0$1$0$0(Function1.this, product);
                                return ProductArchiveSheet$lambda$0$0$1$0$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Composer composer3 = composer2;
                    ProductRow(product, str, d, z2, (Function0) rememberedValue, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(8.0f), 7, null), composer3, Product.$stable | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0);
                    composer2 = composer3;
                }
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
    public static final Unit ProductArchiveSheet$lambda$0$0$1$0$0(Function1 function1, Product product) {
        function1.invoke(product);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void BarcodeScanSheet(final kotlin.jvm.functions.Function0<kotlin.Unit> r17, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r18, boolean r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instructions count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.catalog.CatalogScreenKt.BarcodeScanSheet(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BarcodeScanSheet$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void BarcodeScanSheet$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BarcodeScanSheet$lambda$3$0(MutableState mutableState, boolean z) {
        BarcodeScanSheet$lambda$2(mutableState, z);
        if (!z) {
            Toaster.INSTANCE.error(LangKt.tx("Нет доступа к камере. Разрешите её в настройках телефона.", new Object[0]));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult BarcodeScanSheet$lambda$7$0(Context context, MutableState mutableState, final PreviewView previewView, final AtomicBoolean atomicBoolean, final Function1 function1, final Function0 function0, final LifecycleOwner lifecycleOwner, final DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        if (BarcodeScanSheet$lambda$1(mutableState)) {
            final ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            final BarcodeScanner client = BarcodeScanning.getClient();
            Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
            final ListenableFuture<ProcessCameraProvider> companion = ProcessCameraProvider.INSTANCE.getInstance(context);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            companion.addListener(new Runnable() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CatalogScreenKt.BarcodeScanSheet$lambda$7$0$1(Ref.BooleanRef.this, DisposableEffect, objectRef, previewView, newSingleThreadExecutor, companion, atomicBoolean, client, function1, function0, lifecycleOwner);
                }
            }, ContextCompat.getMainExecutor(context));
            return new DisposableEffectResult() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$BarcodeScanSheet$lambda$7$0$$inlined$onDispose$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    Ref.BooleanRef.this.element = true;
                    ProcessCameraProvider processCameraProvider = (ProcessCameraProvider) objectRef.element;
                    if (processCameraProvider != null) {
                        processCameraProvider.unbindAll();
                    }
                    try {
                        Result.Companion companion2 = Result.INSTANCE;
                        client.close();
                        Result.m7870constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        Result.Companion companion3 = Result.INSTANCE;
                        Result.m7870constructorimpl(ResultKt.createFailure(th));
                    }
                    newSingleThreadExecutor.shutdown();
                }
            };
        }
        return new DisposableEffectResult() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$BarcodeScanSheet$lambda$7$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v7, types: [T, androidx.camera.lifecycle.ProcessCameraProvider] */
    public static final void BarcodeScanSheet$lambda$7$0$1(Ref.BooleanRef booleanRef, final DisposableEffectScope disposableEffectScope, Ref.ObjectRef objectRef, PreviewView previewView, ExecutorService executorService, ListenableFuture listenableFuture, final AtomicBoolean atomicBoolean, final BarcodeScanner barcodeScanner, final Function1 function1, final Function0 function0, LifecycleOwner lifecycleOwner) {
        Object m7870constructorimpl;
        Object m7870constructorimpl2;
        if (booleanRef.element) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl((ProcessCameraProvider) listenableFuture.get());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7876isFailureimpl(m7870constructorimpl)) {
            m7870constructorimpl = null;
        }
        ?? r8 = (ProcessCameraProvider) m7870constructorimpl;
        if (r8 == 0) {
            return;
        }
        objectRef.element = r8;
        Preview build = new Preview.Builder().build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        build.setSurfaceProvider(previewView.getSurfaceProvider());
        ImageAnalysis build2 = new ImageAnalysis.Builder().setBackpressureStrategy(0).build();
        Intrinsics.checkNotNullExpressionValue(build2, "build(...)");
        build2.setAnalyzer(executorService, new ImageAnalysis.Analyzer() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda11
            @Override // androidx.camera.core.ImageAnalysis.Analyzer
            public final void analyze(ImageProxy imageProxy) {
                CatalogScreenKt.BarcodeScanSheet$lambda$7$0$1$1(atomicBoolean, disposableEffectScope, barcodeScanner, function1, function0, imageProxy);
            }
        });
        try {
            Result.Companion companion3 = Result.INSTANCE;
            r8.unbindAll();
            CameraSelector DEFAULT_BACK_CAMERA = CameraSelector.DEFAULT_BACK_CAMERA;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_BACK_CAMERA, "DEFAULT_BACK_CAMERA");
            m7870constructorimpl2 = Result.m7870constructorimpl(r8.bindToLifecycle(lifecycleOwner, DEFAULT_BACK_CAMERA, build, build2));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            m7870constructorimpl2 = Result.m7870constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m7873exceptionOrNullimpl(m7870constructorimpl2) != null) {
            Toaster.INSTANCE.error(LangKt.tx("Камера недоступна. Введите код вручную.", new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BarcodeScanSheet$lambda$7$0$1$1(final AtomicBoolean atomicBoolean, DisposableEffectScope disposableEffectScope, BarcodeScanner barcodeScanner, final Function1 function1, final Function0 function0, final ImageProxy proxy) {
        Object m7870constructorimpl;
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        if (atomicBoolean.get()) {
            proxy.close();
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(proxy.toBitmap());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7876isFailureimpl(m7870constructorimpl)) {
            m7870constructorimpl = null;
        }
        Bitmap bitmap = (Bitmap) m7870constructorimpl;
        if (bitmap == null) {
            proxy.close();
            return;
        }
        InputImage fromBitmap = InputImage.fromBitmap(bitmap, proxy.getImageInfo().getRotationDegrees());
        Intrinsics.checkNotNullExpressionValue(fromBitmap, "fromBitmap(...)");
        Task<List<Barcode>> process = barcodeScanner.process(fromBitmap);
        final Function1 function12 = new Function1() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit BarcodeScanSheet$lambda$7$0$1$1$1;
                BarcodeScanSheet$lambda$7$0$1$1$1 = CatalogScreenKt.BarcodeScanSheet$lambda$7$0$1$1$1(atomicBoolean, function1, function0, (List) obj);
                return BarcodeScanSheet$lambda$7$0$1$1$1;
            }
        };
        process.addOnSuccessListener(new OnSuccessListener() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda37
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                Function1.this.invoke(obj);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda38
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                CatalogScreenKt.BarcodeScanSheet$lambda$7$0$1$1$3(ImageProxy.this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BarcodeScanSheet$lambda$7$0$1$1$1(AtomicBoolean atomicBoolean, Function1 function1, Function0 function0, List list) {
        String str;
        String obj;
        Intrinsics.checkNotNull(list);
        Iterator it = list.iterator();
        do {
            str = null;
            if (!it.hasNext()) {
                break;
            }
            String rawValue = ((Barcode) it.next()).getRawValue();
            if (rawValue != null && (obj = StringsKt.trim((CharSequence) rawValue).toString()) != null && obj.length() > 0) {
                str = obj;
            }
        } while (str == null);
        if (str != null && atomicBoolean.compareAndSet(false, true)) {
            function1.invoke(str);
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BarcodeScanSheet$lambda$7$0$1$1$3(ImageProxy imageProxy, Task it) {
        Intrinsics.checkNotNullParameter(it, "it");
        imageProxy.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BarcodeScanSheet$lambda$8(final PreviewView previewView, final ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, ColumnScope OxCardSheet, Composer composer, int i) {
        Composer composer2;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C893@33871L11:CatalogScreen.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1984254825, i, -1, "uz.FonRo.pos.ui.catalog.BarcodeScanSheet.<anonymous> (CatalogScreen.kt:873)");
            }
            if (BarcodeScanSheet$lambda$1(mutableState)) {
                composer.startReplaceGroup(1300631759);
                ComposerKt.sourceInformation(composer, "875@33202L15,874@33163L262,882@33438L11,883@33462L71");
                ComposerKt.sourceInformationMarkerStart(composer, -96590152, "CC(remember):CatalogScreen.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(previewView);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda50
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            PreviewView BarcodeScanSheet$lambda$8$0$0;
                            BarcodeScanSheet$lambda$8$0$0 = CatalogScreenKt.BarcodeScanSheet$lambda$8$0$0(PreviewView.this, (Context) obj);
                            return BarcodeScanSheet$lambda$8$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                AndroidView_androidKt.AndroidView((Function1) rememberedValue, BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1082height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6989constructorimpl(280.0f)), OxShape.INSTANCE.getCard()), Ox.INSTANCE.m10235getToastInk0d7_KjU(), null, 2, null), null, composer, 0, 4);
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer, 6);
                TextKt.m2798Text4IGK_g(LangKt.tx("Наведите камеру на штрихкод товара.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1301026048);
                ComposerKt.sourceInformation(composer, "885@33563L82,888@33724L42,886@33658L194");
                BasicsKt.OxEmptyNote(LangKt.tx("Чтобы прочитать штрихкод, разрешите приложению доступ к камере.", new Object[0]), null, composer, 0, 2);
                String tx = LangKt.tx("Разрешить камеру", new Object[0]);
                BtnStyle btnStyle = BtnStyle.PRIMARY;
                ComposerKt.sourceInformationMarkerStart(composer, -96573421, "CC(remember):CatalogScreen.kt#9igjgp");
                boolean changedInstance2 = composer.changedInstance(managedActivityResultLauncher);
                Object rememberedValue2 = composer.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CatalogScreenKt$$ExternalSyntheticLambda51
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit BarcodeScanSheet$lambda$8$1$0;
                            BarcodeScanSheet$lambda$8$1$0 = CatalogScreenKt.BarcodeScanSheet$lambda$8$1$0(ManagedActivityResultLauncher.this);
                            return BarcodeScanSheet$lambda$8$1$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                BasicsKt.OxButton(tx, (Function0) rememberedValue2, null, btnStyle, null, false, true, null, composer, 1575936, 180);
                composer2 = composer;
                composer2.endReplaceGroup();
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BarcodeScanSheet$lambda$8$1$0(ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.launch("android.permission.CAMERA");
        return Unit.INSTANCE;
    }

    public static final Color parseHexColor(String str) {
        String obj;
        String removePrefix = (str == null || (obj = StringsKt.trim((CharSequence) str).toString()) == null) ? null : StringsKt.removePrefix(obj, (CharSequence) "#");
        if (removePrefix == null) {
            removePrefix = "";
        }
        if (removePrefix.length() != 6 && removePrefix.length() != 8) {
            return null;
        }
        String str2 = removePrefix;
        for (int i = 0; i < str2.length(); i++) {
            char charAt = str2.charAt(i);
            if (!Character.isDigit(charAt) && (('a' > charAt || charAt >= 'g') && ('A' > charAt || charAt >= 'G'))) {
                return null;
            }
        }
        Long longOrNull = StringsKt.toLongOrNull(removePrefix, 16);
        if (longOrNull == null) {
            return null;
        }
        long longValue = longOrNull.longValue();
        if (removePrefix.length() == 6) {
            longValue |= 4278190080L;
        }
        return Color.m4374boximpl(ColorKt.Color(longValue));
    }

    private static final List<Product> CatalogScreen$lambda$0(State<? extends List<Product>> state) {
        return state.getValue();
    }

    private static final List<Category> CatalogScreen$lambda$1(State<? extends List<Category>> state) {
        return state.getValue();
    }

    private static final int CatalogScreen$lambda$36(State<Integer> state) {
        return state.getValue().intValue();
    }
}
