package uz.FonRo.pos.ui.catalog;

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
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.core.Units;
import uz.FonRo.pos.data.local.CacheStore;
import uz.FonRo.pos.data.model.Category;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnSize;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.FieldsKt;
import uz.FonRo.pos.ui.components.ModifiersKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: CategorySheets.kt */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0004\u001aK\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00050\u000bH\u0001b\u0002\b\u000eb\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\u0002\u0010\r\u001aC\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0003b\u0002\b\u000eb\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\u0002\u0010\u0018\u001a9\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001dH\u0003b\u0002\b\u000eb\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0081\u0001\u0010 \u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00012\u0006\u0010!\u001a\u00020\"2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0003b\u0002\b\u000eb\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\u0002\u0010&\u001a=\u0010'\u001a\u00020\u0005*\u00020(2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001dH\u0003b\u0002\b\u000eb\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\u0004\b)\u0010*\u001ao\u0010+\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00140\u00012\u0006\u0010-\u001a\u00020\"2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00012\u0006\u0010!\u001a\u00020\"2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0003b\u0002\b\u000eb\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\u0002\u0010/\u001aQ\u00100\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00101\u001a\u00020\f2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0001b\u0002\b\u000eb\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\u0002\u00103\u001aI\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u00010\u001d2\u0006\u00107\u001a\u00020\"2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0003b\u0002\b\u000eb\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\u0004\b8\u00109\u001aS\u0010:\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\u000bH\u0001b\u0002\b\u000eb\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\u0002\u0010<\u001a=\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\"2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0003b\u0002\b\u000eb\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\u0002\u0010@\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006²\u0006\u0010\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00140\u0001X\u008a\u0084\u0002²\u0006\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0001X\u008a\u0084\u0002²\u0006\f\u0010A\u001a\u0004\u0018\u00010\u0014X\u008a\u008e\u0002²\u0006\n\u0010B\u001a\u00020\"X\u008a\u008e\u0002²\u0006\f\u0010C\u001a\u0004\u0018\u00010\u0014X\u008a\u008e\u0002²\u0006\n\u0010D\u001a\u00020\"X\u008a\u008e\u0002²\u0006\u0010\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00140\u0001X\u008a\u008e\u0002²\u0006\n\u0010F\u001a\u00020\"X\u008a\u008e\u0002²\u0006\n\u0010G\u001a\u00020HX\u008a\u008e\u0002²\u0006\n\u0010I\u001a\u00020\u0002X\u008a\u008e\u0002²\u0006\n\u0010J\u001a\u00020\"X\u008a\u008e\u0002²\u0006\n\u0010K\u001a\u00020\"X\u008a\u008e\u0002²\u0006\f\u0010C\u001a\u0004\u0018\u00010\u0014X\u008a\u008e\u0002²\u0006\u0010\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00140\u0001X\u008a\u0084\u0002²\u0006\n\u00105\u001a\u00020\u0002X\u008a\u008e\u0002²\u0006\n\u00106\u001a\u00020\u0002X\u008a\u008e\u0002²\u0006\n\u0010L\u001a\u00020\"X\u008a\u008e\u0002²\u0006\n\u0010K\u001a\u00020\"X\u008a\u008e\u0002"}, d2 = {"CATEGORY_COLORS", "", "", "CATEGORY_FALLBACK_COLOR", "CategoriesSheet", "", "app", "Luz/FonRo/pos/FonRoApp;", "onDismiss", "Lkotlin/Function0;", "onPickCategory", "Lkotlin/Function1;", "", "(Luz/FonRo/pos/FonRoApp;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "CategoryCard", "category", "Luz/FonRo/pos/data/model/Category;", CacheStore.PRODUCTS, "Luz/FonRo/pos/data/model/Product;", "onClick", "(Luz/FonRo/pos/data/model/Category;Ljava/util/List;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "CategoryStat", "label", "value", "tint", "Landroidx/compose/ui/graphics/Color;", "CategoryStat-XO-JAsU", "(Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/runtime/Composer;I)V", "CategoryCardSheet", "canManage", "", "onEdit", "onShowProducts", "onChanged", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/data/model/Category;Ljava/util/List;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "CategoryTile", "Landroidx/compose/foundation/layout/RowScope;", "CategoryTile-Bx497Mc", "(Landroidx/compose/foundation/layout/RowScope;Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/runtime/Composer;I)V", "CategoryArchiveSheet", CacheStore.CATEGORIES, "loaded", "onRestored", "(Luz/FonRo/pos/FonRoApp;Ljava/util/List;ZLjava/util/List;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "CategoryPickerSheet", "selectedId", "onPick", "(Luz/FonRo/pos/FonRoApp;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "CategoryPickRow", "name", TypedValues.Custom.S_COLOR, "selected", "CategoryPickRow-BAq54LU", "(Ljava/lang/String;Landroidx/compose/ui/graphics/Color;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "CategoryFormSheet", "onSaved", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/data/model/Category;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ColorDot", "hex", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "formFor", "formOpen", "card", "archiveOpen", "archived", "archivedLoaded", "reload", "", SearchIntents.EXTRA_QUERY, "busy", "confirmArchive", "saving"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class CategorySheetsKt {
    private static final String CATEGORY_FALLBACK_COLOR = "#22C55E";
    private static final List<String> CATEGORY_COLORS = CollectionsKt.listOf((Object[]) new String[]{CATEGORY_FALLBACK_COLOR, "#06B6D4", "#2563EB", "#A855F7", "#EC4899", "#F97316", "#EAB308", "#EF4444", "#64748B"});

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CategoriesSheet$lambda$31(FonRoApp FonRoApp, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        CategoriesSheet(FonRoApp, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CategoryArchiveSheet$lambda$5(FonRoApp FonRoApp, List list, boolean z, List list2, boolean z2, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        CategoryArchiveSheet(FonRoApp, list, z, list2, z2, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CategoryCard$lambda$3(Category category, List list, Function0 function0, int i, Composer composer, int i2) {
        CategoryCard(category, list, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CategoryCardSheet$lambda$16(FonRoApp FonRoApp, Category category, List list, boolean z, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i, Composer composer, int i2) {
        CategoryCardSheet(FonRoApp, category, list, z, function0, function02, function03, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CategoryFormSheet$lambda$16(FonRoApp FonRoApp, Category category, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        CategoryFormSheet(FonRoApp, category, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CategoryPickRow_BAq54LU$lambda$1(String str, Color color, boolean z, Function0 function0, int i, Composer composer, int i2) {
        m9787CategoryPickRowBAq54LU(str, color, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CategoryPickerSheet$lambda$3(FonRoApp FonRoApp, long j, Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        CategoryPickerSheet(FonRoApp, j, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CategoryStat_XO_JAsU$lambda$1(String str, String str2, long j, int i, Composer composer, int i2) {
        m9788CategoryStatXOJAsU(str, str2, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CategoryTile_Bx497Mc$lambda$1(RowScope rowScope, String str, String str2, long j, int i, Composer composer, int i2) {
        m9789CategoryTileBx497Mc(rowScope, str, str2, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ColorDot$lambda$0(String str, boolean z, Function0 function0, int i, Composer composer, int i2) {
        ColorDot(str, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x02b7, code lost:
    
        if (r6 == null) goto L88;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void CategoriesSheet(uz.FonRo.pos.FonRoApp r30, kotlin.jvm.functions.Function0<kotlin.Unit> r31, kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, final int r34) {
        /*
            Method dump skipped, instructions count: 1187
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.catalog.CategorySheetsKt.CategoriesSheet(uz.FonRo.pos.FonRoApp, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    private static final Category CategoriesSheet$lambda$3(MutableState<Category> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean CategoriesSheet$lambda$6(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CategoriesSheet$lambda$7(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Category CategoriesSheet$lambda$9(MutableState<Category> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean CategoriesSheet$lambda$12(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CategoriesSheet$lambda$13(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final List<Category> CategoriesSheet$lambda$15(MutableState<List<Category>> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean CategoriesSheet$lambda$18(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CategoriesSheet$lambda$19(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final int CategoriesSheet$lambda$21(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void CategoriesSheet$lambda$22(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CategoriesSheet$lambda$25(List list, boolean z, final MutableState mutableState, MutableState mutableState2, MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, State state, final MutableState mutableState6, ColumnScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C116@4587L21,116@4556L4244:CategorySheets.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1616290439, i, -1, "uz.FonRo.pos.ui.catalog.CategoriesSheet.<anonymous> (CategorySheets.kt:116)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1135871609, "C118@4667L3530,194@8210L11,196@8235L186,213@8780L10:CategorySheets.kt#i65cod");
            Modifier m1049padding3ABfNKs = PaddingKt.m1049padding3ABfNKs(BorderKt.m569borderxT4_qwU(BackgroundKt.background$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), OxShape.INSTANCE.getHero()), Brush.Companion.m4336linearGradientmHitzGk$default(Brush.INSTANCE, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10224getRed0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null))), TuplesKt.to(Float.valueOf(0.52f), Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10213getOrange0d7_KjU(), 0.13f, 0.0f, 0.0f, 0.0f, 14, null))), TuplesKt.to(Float.valueOf(1.0f), Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10223getPurple0d7_KjU(), 0.09f, 0.0f, 0.0f, 0.0f, 14, null)))}, 0L, 0L, 0, 14, (Object) null), null, 0.0f, 6, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10205getHeroEdge0d7_KjU(), OxShape.INSTANCE.getHero()), Dp.m6989constructorimpl(16.0f));
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
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
            Updater.m3815setimpl(m3808constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1873286660, "C132@5237L1488,163@6742L11,174@7260L35,174@7233L62,164@6770L1149:CategorySheets.kt#i65cod");
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, fillMaxWidth$default);
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
            Updater.m3815setimpl(m3808constructorimpl3, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 2012338093, "C137@5478L399,152@6231L22,152@6225L28,147@5979L728:CategorySheets.kt#i65cod");
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
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
            Updater.m3815setimpl(m3808constructorimpl4, columnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl4.getInserting() || !Intrinsics.areEqual(m3808constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m3808constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m3808constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3815setimpl(m3808constructorimpl4, materializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 943807553, "C138@5532L52,139@5609L246:CategorySheets.kt#i65cod");
            TextKt.m2798Text4IGK_g(LangKt.tx("Активные категории", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getLabel(), composer, 0, 0, 65534);
            TextKt.m2798Text4IGK_g(String.valueOf(list.size()), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(2.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getAmountXl(), composer, 48, 3072, 57340);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1084heightInVpY3zN4$default(Modifier.INSTANCE, Dp.m6989constructorimpl(44.0f), 0.0f, 2, null), OxShape.INSTANCE.getTile()), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10223getPurple0d7_KjU(), 0.14f), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, -2013272961, "CC(remember):CategorySheets.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda35
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CategoriesSheet$lambda$25$0$0$0$1$0;
                        CategoriesSheet$lambda$25$0$0$0$1$0 = CategorySheetsKt.CategoriesSheet$lambda$25$0$0$0$1$0(MutableState.this);
                        return CategoriesSheet$lambda$25$0$0$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(ModifiersKt.oxTap(m558backgroundbw27NRU$default, false, (Function0) rememberedValue, composer, 384, 1), Dp.m6989constructorimpl(13.0f), Dp.m6989constructorimpl(10.0f));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer, m1050paddingVpY3zN4);
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
            Updater.m3815setimpl(m3808constructorimpl5, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl5.getInserting() || !Intrinsics.areEqual(m3808constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                m3808constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                m3808constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m3815setimpl(m3808constructorimpl5, materializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1140804227, "C156@6438L247:CategorySheets.kt#i65cod");
            TextKt.m2798Text4IGK_g(LangKt.tx("Архив · ", new Object[0]) + (CategoriesSheet$lambda$18(mutableState2) ? String.valueOf(CategoriesSheet$lambda$15(mutableState3).size()) : "…"), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getChip(), Ox.INSTANCE.m10223getPurple0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 3072, 57342);
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
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(14.0f), composer, 6);
            Modifier m569borderxT4_qwU = BorderKt.m569borderxT4_qwU(BackgroundKt.background$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), OxShape.INSTANCE.getTile()), Brush.Companion.m4333horizontalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10192getCyan0d7_KjU(), 0.34f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10186getBlue0d7_KjU(), 0.28f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10234getTileEdge0d7_KjU(), OxShape.INSTANCE.getTile());
            ComposerKt.sourceInformationMarkerStart(composer, 1048011880, "CC(remember):CategorySheets.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda36
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CategoriesSheet$lambda$25$0$0$1$0;
                        CategoriesSheet$lambda$25$0$0$1$0 = CategorySheetsKt.CategoriesSheet$lambda$25$0$0$1$0(MutableState.this, mutableState5);
                        return CategoriesSheet$lambda$25$0$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier m1050paddingVpY3zN42 = PaddingKt.m1050paddingVpY3zN4(SizeKt.m1084heightInVpY3zN4$default(ModifiersKt.oxTap(m569borderxT4_qwU, z, (Function0) rememberedValue2, composer, 384, 0), Dp.m6989constructorimpl(48.0f), 0.0f, 2, null), Dp.m6989constructorimpl(12.0f), Dp.m6989constructorimpl(10.0f));
            Arrangement.Horizontal m931spacedByD5KLDUw = Arrangement.INSTANCE.m931spacedByD5KLDUw(Dp.m6989constructorimpl(7.0f), Alignment.INSTANCE.getCenterHorizontally());
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m931spacedByD5KLDUw, centerVertically2, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(composer, m1050paddingVpY3zN42);
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
            Updater.m3815setimpl(m3808constructorimpl6, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl6.getInserting() || !Intrinsics.areEqual(m3808constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                m3808constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                m3808constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
            }
            Updater.m3815setimpl(m3808constructorimpl6, materializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 70758670, "C180@7624L167,184@7812L89:CategorySheets.kt#i65cod");
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getAdd(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(19.0f)), Ox.INSTANCE.m10193getCyanDeep0d7_KjU(), composer, 432, 0);
            String str = "CC(remember):CategorySheets.kt#9igjgp";
            TextKt.m2798Text4IGK_g(LangKt.tx("Добавить категорию", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getButton(), Ox.INSTANCE.m10233getText0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 3072, 57342);
            Composer composer2 = composer;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (!z) {
                composer2.startReplaceGroup(-1870677546);
                ComposerKt.sourceInformation(composer2, "187@7974L10,188@8005L160");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer2, 6);
                TextKt.m2798Text4IGK_g(LangKt.tx("Категориями управляют сотрудники с правом «Категории».", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1870455555);
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(14.0f), composer2, 6);
            BasicsKt.OxSectionHead(LangKt.tx("Активные категории", new Object[0]), null, LangKt.tx("Текущие категории магазина", new Object[0]), String.valueOf(list.size()), null, null, composer, 0, 50);
            if (list.isEmpty()) {
                composer.startReplaceGroup(1139505769);
                ComposerKt.sourceInformation(composer, "203@8475L42");
                BasicsKt.OxEmptyNote(LangKt.tx("Активных категорий нет.", new Object[0]), null, composer, 0, 2);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1139576883);
                composer.endReplaceGroup();
            }
            composer.startReplaceGroup(-1625806554);
            ComposerKt.sourceInformation(composer, "*210@8716L19,207@8590L163");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final Category category = (Category) it.next();
                List<Product> CategoriesSheet$lambda$1 = CategoriesSheet$lambda$1(state);
                String str2 = str;
                ComposerKt.sourceInformationMarkerStart(composer, -160138113, str2);
                boolean changedInstance = composer.changedInstance(category);
                Object rememberedValue3 = composer.rememberedValue();
                if (changedInstance || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda37
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CategoriesSheet$lambda$25$0$1$0$0;
                            CategoriesSheet$lambda$25$0$1$0$0 = CategorySheetsKt.CategoriesSheet$lambda$25$0$1$0$0(Category.this, mutableState6);
                            return CategoriesSheet$lambda$25$0$1$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                CategoryCard(category, CategoriesSheet$lambda$1, (Function0) rememberedValue3, composer, Category.$stable);
                str = str2;
            }
            composer.endReplaceGroup();
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
    public static final Unit CategoriesSheet$lambda$25$0$0$0$1$0(MutableState mutableState) {
        CategoriesSheet$lambda$13(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoriesSheet$lambda$25$0$0$1$0(MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(null);
        CategoriesSheet$lambda$7(mutableState2, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoriesSheet$lambda$25$0$1$0$0(Category category, MutableState mutableState) {
        mutableState.setValue(category);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoriesSheet$lambda$26$2$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoriesSheet$lambda$26$3$0(Category category, MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(category);
        CategoriesSheet$lambda$7(mutableState2, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoriesSheet$lambda$26$4$0(Function1 function1, Category category, Function0 function0, MutableState mutableState) {
        function1.invoke(Long.valueOf(category.getId()));
        mutableState.setValue(null);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoriesSheet$lambda$26$5$0(MutableState mutableState, MutableState mutableState2) {
        CategoriesSheet$lambda$22(mutableState, CategoriesSheet$lambda$21(mutableState) + 1);
        mutableState2.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoriesSheet$lambda$27$0(MutableState mutableState) {
        CategoriesSheet$lambda$13(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoriesSheet$lambda$28$0(MutableState mutableState) {
        CategoriesSheet$lambda$22(mutableState, CategoriesSheet$lambda$21(mutableState) + 1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoriesSheet$lambda$29$0(MutableState mutableState) {
        CategoriesSheet$lambda$7(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoriesSheet$lambda$30$0(MutableState mutableState, Category it) {
        Intrinsics.checkNotNullParameter(it, "it");
        CategoriesSheet$lambda$22(mutableState, CategoriesSheet$lambda$21(mutableState) + 1);
        return Unit.INSTANCE;
    }

    private static final void CategoryCard(final Category category, final List<Product> list, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(853966823);
        ComposerKt.sourceInformation(startRestartGroup, "C(CategoryCard)P(!1,2)274@10581L24,267@10353L1735:CategorySheets.kt#i65cod");
        int i3 = (i & 6) == 0 ? ((i & 8) == 0 ? startRestartGroup.changed(category) : startRestartGroup.changedInstance(category) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i3 |= (i & 64) == 0 ? startRestartGroup.changed(list) : startRestartGroup.changedInstance(list) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(853966823, i3, -1, "uz.FonRo.pos.ui.catalog.CategoryCard (CategorySheets.kt:262)");
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((Product) obj).getCategoryId() == category.getId()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            Iterator it = arrayList2.iterator();
            double d = 0.0d;
            while (it.hasNext()) {
                d += Math.max(((Product) it.next()).getQuantity(), AudioStats.AUDIO_AMPLITUDE_NONE);
            }
            Color parseHexColor = CatalogScreenKt.parseHexColor(category.getColor());
            long m4394unboximpl = parseHexColor != null ? parseHexColor.m4394unboximpl() : Ox.INSTANCE.m10201getGreen0d7_KjU();
            Modifier m1049padding3ABfNKs = PaddingKt.m1049padding3ABfNKs(ModifiersKt.oxTap(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(8.0f), 7, null), OxShape.INSTANCE.getCard()), Ox.INSTANCE.m10218getPanel20d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getCard()), false, function0, startRestartGroup, i3 & 896, 1), Dp.m6989constructorimpl(12.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, startRestartGroup, 54);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 678722005, "C279@10767L302,288@11078L864,310@11951L131:CategorySheets.kt#i65cod");
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(52.0f)), OxShape.INSTANCE.getTile()), Color.m4383copywmQWz5c$default(m4394unboximpl, 0.2f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m558backgroundbw27NRU$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 632201044, "C286@10997L62:CategorySheets.kt#i65cod");
            BoxKt.Box(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(16.0f)), OxShape.INSTANCE.getPill()), m4394unboximpl, null, 2, null), startRestartGroup, 0);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -523269194, "C289@11120L562,304@11695L10,305@11718L214:CategorySheets.kt#i65cod");
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, centerVertically2, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
            Updater.m3815setimpl(m3808constructorimpl4, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl4.getInserting() || !Intrinsics.areEqual(m3808constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m3808constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m3808constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3815setimpl(m3808constructorimpl4, materializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1685508354, "C293@11288L250:CategorySheets.kt#i65cod");
            TextKt.m2798Text4IGK_g(category.getName(), rowScopeInstance2.weight(Modifier.INSTANCE, 1.0f, false), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH3(), startRestartGroup, 0, 3120, 55292);
            if (category.isArchived() == 1) {
                startRestartGroup.startReplaceGroup(1685793770);
                ComposerKt.sourceInformation(startRestartGroup, "301@11607L43");
                i2 = 0;
                m9788CategoryStatXOJAsU(LangKt.tx("В архиве", new Object[0]), "", Ox.INSTANCE.m10223getPurple0d7_KjU(), startRestartGroup, 48);
                startRestartGroup.endReplaceGroup();
            } else {
                i2 = 0;
                startRestartGroup.startReplaceGroup(1685873533);
                startRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(5.0f), startRestartGroup, 6);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_43 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(7.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m930spacedBy0680j_43, Alignment.INSTANCE.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, i2);
            CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
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
            Updater.m3815setimpl(m3808constructorimpl5, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl5.getInserting() || !Intrinsics.areEqual(m3808constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                m3808constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                m3808constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m3815setimpl(m3808constructorimpl5, materializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -655982615, "C306@11792L63,307@11872L46:CategorySheets.kt#i65cod");
            m9788CategoryStatXOJAsU(LangKt.tx("Товаров", new Object[i2]), String.valueOf(arrayList2.size()), Ox.INSTANCE.m10193getCyanDeep0d7_KjU(), startRestartGroup, 0);
            m9788CategoryStatXOJAsU(LangKt.tx("Штук", new Object[i2]), Fmt.INSTANCE.qf(Double.valueOf(d)), Ox.INSTANCE.m10211getOk0d7_KjU(), startRestartGroup, 0);
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
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getChevron(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(20.0f)), Ox.INSTANCE.m10200getDim20d7_KjU(), startRestartGroup, 432, 0);
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
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return CategorySheetsKt.CategoryCard$lambda$3(Category.this, list, function0, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* renamed from: CategoryStat-XO-JAsU, reason: not valid java name */
    private static final void m9788CategoryStatXOJAsU(final String str, final String str2, final long j, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1587567096);
        ComposerKt.sourceInformation(startRestartGroup, "C(CategoryStat)P(!1,2,1:c#ui.graphics.Color)320@12235L446:CategorySheets.kt#i65cod");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(j) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1587567096, i2, -1, "uz.FonRo.pos.ui.catalog.CategoryStat (CategorySheets.kt:319)");
            }
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, OxShape.INSTANCE.getPill()), Ox.INSTANCE.m10241tintBg5vOe2sY(j, 0.12f), null, 2, null), Dp.m6989constructorimpl(8.0f), Dp.m6989constructorimpl(4.0f));
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(4.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), startRestartGroup, 6);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -888635291, "C327@12481L72:CategorySheets.kt#i65cod");
            int i3 = i2;
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getTileLabel(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), startRestartGroup, i2 & 14, 3072, 57342);
            composer2 = startRestartGroup;
            if (!StringsKt.isBlank(str2)) {
                composer2.startReplaceGroup(-888521243);
                ComposerKt.sourceInformation(composer2, "329@12600L65");
                TextKt.m2798Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getChip(), j, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer2, (i3 >> 3) & 14, 3072, 57342);
                composer2 = composer2;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-888448858);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CategorySheetsKt.CategoryStat_XO_JAsU$lambda$1(str, str2, j, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void CategoryCardSheet(final FonRoApp FonRoApp, final Category category, final List<Product> list, final boolean z, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, Composer composer, final int i) {
        boolean z2;
        Composer composer2;
        Repo repo;
        MutableState mutableState;
        MutableState mutableStateOf$default;
        Composer startRestartGroup = composer.startRestartGroup(-1197942340);
        ComposerKt.sourceInformation(startRestartGroup, "C(CategoryCardSheet)P(!1,2,7!1,4,5,6)353@13328L24,359@13561L31,360@13609L34,361@13670L34,363@13722L129,415@15634L6633,415@15550L6717:CategorySheets.kt#i65cod");
        int i2 = (i & 6) == 0 ? ((i & 8) == 0 ? startRestartGroup.changed(FonRoApp) : startRestartGroup.changedInstance(FonRoApp) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(category) : startRestartGroup.changedInstance(category) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? startRestartGroup.changed(list) : startRestartGroup.changedInstance(list) ? 256 : 128;
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
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function03) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function04) ? 8388608 : 4194304;
        }
        if (!startRestartGroup.shouldExecute((i2 & 4793491) != 4793490, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1197942340, i2, -1, "uz.FonRo.pos.ui.catalog.CategoryCardSheet (CategorySheets.kt:351)");
            }
            Repo repo2 = FonRoApp.getRepo();
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
            final String currency = repo2.currency();
            final boolean can = repo2.can(Perm.VIEW_PURCHASE_PRICE);
            final boolean z3 = category.isArchived() == 1;
            Color parseHexColor = CatalogScreenKt.parseHexColor(category.getColor());
            long m4394unboximpl = parseHexColor != null ? parseHexColor.m4394unboximpl() : Ox.INSTANCE.m10201getGreen0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -171336197, "CC(remember):CategorySheets.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(mutableStateOf$default);
                rememberedValue2 = mutableStateOf$default;
            }
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -171334658, "CC(remember):CategorySheets.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                repo = repo2;
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            } else {
                repo = repo2;
            }
            MutableState mutableState3 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -171332706, "CC(remember):CategorySheets.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState3;
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            } else {
                mutableState = mutableState3;
            }
            final MutableState mutableState4 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            long id = category.getId();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -171330947, "CC(remember):CategorySheets.kt#9igjgp");
            boolean changed = startRestartGroup.changed(id) | ((i2 & 896) == 256 || ((i2 & 512) != 0 && startRestartGroup.changed(list)));
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (((Product) obj).getCategoryId() == category.getId()) {
                        arrayList.add(obj);
                    }
                }
                rememberedValue5 = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$CategoryCardSheet$lambda$9$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        String lowerCase = ((Product) t).getName().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        String lowerCase2 = ((Product) t2).getName().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            List list2 = (List) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            List list3 = list2;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : list3) {
                List list4 = list3;
                List list5 = list2;
                if (((Product) obj2).matches(CategoryCardSheet$lambda$1(mutableState2))) {
                    arrayList2.add(obj2);
                }
                list3 = list4;
                list2 = list5;
            }
            List<Product> list6 = list3;
            final List list7 = list2;
            final ArrayList arrayList3 = arrayList2;
            Iterator it = list6.iterator();
            long j = m4394unboximpl;
            final double d = 0.0d;
            while (it.hasNext()) {
                d += Math.max(((Product) it.next()).getQuantity(), AudioStats.AUDIO_AMPLITUDE_NONE);
                j = j;
            }
            final long j2 = j;
            final double d2 = 0.0d;
            for (Product product : list6) {
                d2 += Math.max(can ? product.getPurchasePrice() : product.getSalePrice(), AudioStats.AUDIO_AMPLITUDE_NONE) * Math.max(product.getQuantity(), AudioStats.AUDIO_AMPLITUDE_NONE);
            }
            int i3 = i2;
            final MutableState mutableState5 = mutableState;
            final Repo repo3 = repo;
            final boolean z4 = z2;
            SheetsKt.OxCardSheet(LangKt.tx("Карточка категории", new Object[0]), function0, null, false, false, false, null, ComposableLambdaKt.rememberComposableLambda(-1271875368, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                    return CategorySheetsKt.CategoryCardSheet$lambda$13(j2, function03, arrayList3, list7, z4, z3, category, d, d2, function02, function0, coroutineScope, repo3, function04, mutableState5, mutableState4, mutableState2, currency, can, (ColumnScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i3 >> 9) & 112) | 12779520, 92);
            composer2 = startRestartGroup;
            if (CategoryCardSheet$lambda$7(mutableState4)) {
                composer2.startReplaceGroup(-1007779397);
                ComposerKt.sourceInformation(composer2, "581@22671L13,582@22710L26,575@22303L443");
                String tx = LangKt.tx("Архивировать категорию?", new Object[0]);
                String str = LangKt.tx("«%s» исчезнет из фильтров. ", category.getName()) + Fmt.INSTANCE.plural(list7.size(), LangKt.tx("товар", new Object[0]), LangKt.tx("товара", new Object[0]), LangKt.tx("товаров", new Object[0])) + LangKt.tx(" останутся на складе — просто без категории в списке.", new Object[0]);
                String tx2 = LangKt.tx("Архивировать", new Object[0]);
                ComposerKt.sourceInformationMarkerStart(composer2, -171044695, "CC(remember):CategorySheets.kt#9igjgp");
                boolean changedInstance = composer2.changedInstance(coroutineScope) | ((i3 & 112) == 32 || ((i3 & 64) != 0 && composer2.changedInstance(category))) | composer2.changedInstance(repo3) | ((i3 & 29360128) == 8388608) | ((i3 & 57344) == 16384);
                Object rememberedValue6 = composer2.rememberedValue();
                if (changedInstance || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    Function0 function05 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CategoryCardSheet$lambda$14$0;
                            CategoryCardSheet$lambda$14$0 = CategorySheetsKt.CategoryCardSheet$lambda$14$0(CoroutineScope.this, mutableState5, category, repo3, function04, function0);
                            return CategoryCardSheet$lambda$14$0;
                        }
                    };
                    composer2.updateRememberedValue(function05);
                    rememberedValue6 = function05;
                }
                Function0 function06 = (Function0) rememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -171043434, "CC(remember):CategorySheets.kt#9igjgp");
                Object rememberedValue7 = composer2.rememberedValue();
                if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue7 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CategoryCardSheet$lambda$15$0;
                            CategoryCardSheet$lambda$15$0 = CategorySheetsKt.CategoryCardSheet$lambda$15$0(MutableState.this);
                            return CategoryCardSheet$lambda$15$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                SheetsKt.OxConfirmSheet(tx, str, tx2, null, function06, (Function0) rememberedValue7, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 8);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1007338298);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return CategorySheetsKt.CategoryCardSheet$lambda$16(FonRoApp.this, category, list, z, function0, function02, function03, function04, i, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    private static final String CategoryCardSheet$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean CategoryCardSheet$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CategoryCardSheet$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean CategoryCardSheet$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CategoryCardSheet$lambda$8(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void CategoryCardSheet$archive(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, Category category, Repo repo, Function0<Unit> function0, Function0<Unit> function02) {
        if (CategoryCardSheet$lambda$4(mutableState)) {
            return;
        }
        CategoryCardSheet$lambda$5(mutableState, true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CategorySheetsKt$CategoryCardSheet$archive$1(category, repo, function0, function02, mutableState, null), 3, null);
    }

    private static final void CategoryCardSheet$restore(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, Category category, Repo repo, Function0<Unit> function0, Function0<Unit> function02) {
        if (CategoryCardSheet$lambda$4(mutableState)) {
            return;
        }
        CategoryCardSheet$lambda$5(mutableState, true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CategorySheetsKt$CategoryCardSheet$restore$1(category, repo, function0, function02, mutableState, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit CategoryCardSheet$lambda$13(long j, Function0 function0, List list, List list2, boolean z, boolean z2, final Category category, double d, double d2, final Function0 function02, final Function0 function03, final CoroutineScope coroutineScope, final Repo repo, final Function0 function04, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, String str, boolean z3, ColumnScope OxCardSheet, Composer composer, int i) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Modifier modifier;
        int i2;
        int i3;
        float f;
        String str7;
        int i4;
        String str8;
        boolean z4;
        float f2;
        Modifier modifier2;
        int i5;
        Object obj;
        String str9;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C416@15675L21,416@15644L6617:CategorySheets.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1271875368, i, -1, "uz.FonRo.pos.ui.catalog.CategoryCardSheet.<anonymous> (CategorySheets.kt:416)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -367646262, "C418@15744L3626,497@19383L11,515@19952L206,522@20247L14,520@20171L163,525@20347L11,570@22241L10:CategorySheets.kt#i65cod");
            Modifier m1049padding3ABfNKs = PaddingKt.m1049padding3ABfNKs(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), OxShape.INSTANCE.getHero()), Color.m4383copywmQWz5c$default(j, 0.1f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m6989constructorimpl(1.0f), Color.m4383copywmQWz5c$default(j, 0.28f, 0.0f, 0.0f, 0.0f, 14, null), OxShape.INSTANCE.getHero()), Dp.m6989constructorimpl(15.0f));
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
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
            Updater.m3815setimpl(m3808constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1769863653, "C426@16066L1360,456@17444L11,457@17472L331:CategorySheets.kt#i65cod");
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
            Alignment.Vertical top = Alignment.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, top, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, fillMaxWidth$default);
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
            Updater.m3815setimpl(m3808constructorimpl3, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -2099711, "C431@16294L398,440@16713L573,453@17307L101:CategorySheets.kt#i65cod");
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(58.0f)), OxShape.INSTANCE.getTile()), Color.m4383copywmQWz5c$default(j, 0.2f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, m558backgroundbw27NRU$default);
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
            Updater.m3815setimpl(m3808constructorimpl4, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl4.getInserting() || !Intrinsics.areEqual(m3808constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m3808constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m3808constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3815setimpl(m3808constructorimpl4, materializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 105339991, "C438@16608L62:CategorySheets.kt#i65cod");
            BoxKt.Box(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(18.0f)), OxShape.INSTANCE.getPill()), j, null, 2, null), composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer, weight$default);
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
            Updater.m3815setimpl(m3808constructorimpl5, columnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl5.getInserting() || !Intrinsics.areEqual(m3808constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                m3808constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                m3808constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m3815setimpl(m3808constructorimpl5, materializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1270999404, "C441@16767L224,447@17016L248:CategorySheets.kt#i65cod");
            TextKt.m2798Text4IGK_g(category.getName(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH2(), composer, 0, 3120, 55294);
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.plural(list2.size(), LangKt.tx("позиция", new Object[0]), LangKt.tx("позиции", new Object[0]), LangKt.tx("позиций", new Object[0])), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(3.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 48, 0, 65532);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            String tx = z2 ? LangKt.tx("В архиве", new Object[0]) : LangKt.tx("Активна", new Object[0]);
            Ox ox = Ox.INSTANCE;
            m9788CategoryStatXOJAsU(tx, "", z2 ? ox.m10223getPurple0d7_KjU() : ox.m10211getOk0d7_KjU(), composer, 48);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(composer, fillMaxWidth$default2);
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
            Updater.m3815setimpl(m3808constructorimpl6, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl6.getInserting() || !Intrinsics.areEqual(m3808constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                m3808constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                m3808constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
            }
            Updater.m3815setimpl(m3808constructorimpl6, materializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1996211278, "C458@17575L59,459@17655L49,460@17725L60:CategorySheets.kt#i65cod");
            m9789CategoryTileBx497Mc(rowScopeInstance2, String.valueOf(list2.size()), LangKt.tx("Товаров", new Object[0]), Ox.INSTANCE.m10192getCyan0d7_KjU(), composer, 6);
            Composer composer2 = composer;
            m9789CategoryTileBx497Mc(rowScopeInstance2, Fmt.INSTANCE.qf(Double.valueOf(d)), LangKt.tx("Штук", new Object[0]), Ox.INSTANCE.m10201getGreen0d7_KjU(), composer2, 6);
            m9789CategoryTileBx497Mc(rowScopeInstance2, Fmt.INSTANCE.compact(Double.valueOf(d2)), LangKt.tx("Стоимость", new Object[0]), Ox.INSTANCE.m10213getOrange0d7_KjU(), composer2, 6);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (z) {
                composer2.startReplaceGroup(1771564622);
                ComposerKt.sourceInformation(composer2, "464@17858L11,465@17890L1448");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer2, 6);
                Modifier fillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical m930spacedBy0680j_43 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(9.0f));
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m930spacedBy0680j_43, Alignment.INSTANCE.getTop(), composer2, 6);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap7 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier7 = ComposedModifierKt.materializeModifier(composer2, fillMaxWidth$default3);
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
                Updater.m3815setimpl(m3808constructorimpl7, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3815setimpl(m3808constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3808constructorimpl7.getInserting() || !Intrinsics.areEqual(m3808constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                    m3808constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                    m3808constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
                }
                Updater.m3815setimpl(m3808constructorimpl7, materializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 1713462645, "C:CategorySheets.kt#i65cod");
                if (function02 != null) {
                    composer2.startReplaceGroup(1713457870);
                    ComposerKt.sourceInformation(composer2, "471@18293L25,469@18203L313");
                    String tx2 = LangKt.tx("Изменить", new Object[0]);
                    ComposerKt.sourceInformationMarkerStart(composer2, 1717844316, "CC(remember):CategorySheets.kt#9igjgp");
                    boolean changed = composer2.changed(function03) | composer2.changed(function02);
                    Object rememberedValue = composer2.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit CategoryCardSheet$lambda$13$0$0$2$0$0;
                                CategoryCardSheet$lambda$13$0$0$2$0$0 = CategorySheetsKt.CategoryCardSheet$lambda$13$0$0$2$0$0(Function0.this, function02);
                                return CategoryCardSheet$lambda$13$0$0$2$0$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    z4 = -407735110;
                    i5 = 1;
                    f2 = 0.0f;
                    str6 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                    modifier2 = null;
                    BasicsKt.OxButton(tx2, (Function0) rememberedValue, RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.CYAN, null, !CategoryCardSheet$lambda$4(mutableState), false, null, composer, 3072, 208);
                    composer2 = composer;
                    composer2.endReplaceGroup();
                } else {
                    z4 = -407735110;
                    str6 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                    f2 = 0.0f;
                    modifier2 = null;
                    i5 = 1;
                    composer2.startReplaceGroup(1713812479);
                    composer2.endReplaceGroup();
                }
                if (z2) {
                    composer2.startReplaceGroup(1713862296);
                    ComposerKt.sourceInformation(composer2, "480@18705L13,478@18611L303");
                    String tx3 = LangKt.tx("Восстановить", new Object[0]);
                    ComposerKt.sourceInformationMarkerStart(composer2, 1717857488, "CC(remember):CategorySheets.kt#9igjgp");
                    boolean changedInstance = composer2.changedInstance(coroutineScope) | composer2.changedInstance(category) | composer2.changedInstance(repo) | composer2.changed(function04) | composer2.changed(function03);
                    Object rememberedValue2 = composer2.rememberedValue();
                    if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        str3 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                        str7 = "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo";
                        str5 = "CC(remember):CategorySheets.kt#9igjgp";
                        str9 = tx3;
                        f = f2;
                        modifier = modifier2;
                        str4 = "C101@5232L9:Row.kt#2w3rfo";
                        i3 = 0;
                        str2 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                        i2 = i5;
                        obj = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit CategoryCardSheet$lambda$13$0$0$2$1$0;
                                CategoryCardSheet$lambda$13$0$0$2$1$0 = CategorySheetsKt.CategoryCardSheet$lambda$13$0$0$2$1$0(CoroutineScope.this, mutableState, category, repo, function04, function03);
                                return CategoryCardSheet$lambda$13$0$0$2$1$0;
                            }
                        };
                        composer2.updateRememberedValue(obj);
                    } else {
                        str3 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                        str4 = "C101@5232L9:Row.kt#2w3rfo";
                        str5 = "CC(remember):CategorySheets.kt#9igjgp";
                        str9 = tx3;
                        i3 = 0;
                        obj = rememberedValue2;
                        f = f2;
                        modifier = modifier2;
                        i2 = i5;
                        str2 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                        str7 = "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo";
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    BasicsKt.OxButton(str9, (Function0) obj, RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.OK, null, (CategoryCardSheet$lambda$4(mutableState) ? 1 : 0) ^ i2, false, null, composer2, 3072, 208);
                    composer2.endReplaceGroup();
                } else {
                    str2 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                    str3 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                    str7 = "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo";
                    str4 = "C101@5232L9:Row.kt#2w3rfo";
                    str5 = "CC(remember):CategorySheets.kt#9igjgp";
                    f = f2;
                    modifier = modifier2;
                    i2 = i5;
                    i3 = 0;
                    composer2.startReplaceGroup(1714224717);
                    ComposerKt.sourceInformation(composer2, "488@19065L25,486@18976L314");
                    String tx4 = LangKt.tx("В архив", new Object[0]);
                    ComposerKt.sourceInformationMarkerStart(composer2, 1717869020, str5);
                    Object rememberedValue3 = composer2.rememberedValue();
                    if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda31
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit CategoryCardSheet$lambda$13$0$0$2$2$0;
                                CategoryCardSheet$lambda$13$0$0$2$2$0 = CategorySheetsKt.CategoryCardSheet$lambda$13$0$0$2$2$0(MutableState.this);
                                return CategoryCardSheet$lambda$13$0$0$2$2$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    BasicsKt.OxButton(tx4, (Function0) rememberedValue3, RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.DANGER, null, (CategoryCardSheet$lambda$4(mutableState) ? 1 : 0) ^ i2, false, null, composer2, 3120, 208);
                    composer2.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            } else {
                str2 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                str3 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                str4 = "C101@5232L9:Row.kt#2w3rfo";
                str5 = "CC(remember):CategorySheets.kt#9igjgp";
                str6 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                modifier = null;
                i2 = 1;
                i3 = 0;
                f = 0.0f;
                str7 = "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo";
                composer2.startReplaceGroup(1773025342);
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer2, 6);
            if (function0 != null) {
                composer2.startReplaceGroup(-364169954);
                ComposerKt.sourceInformation(composer2, "500@19454L442,512@19913L11");
                BasicsKt.OxButton(LangKt.tx("Показать товары категории", new Object[i3]), function0, null, null, BtnSize.LG, false, true, ComposableSingletons$CategorySheetsKt.INSTANCE.m9790getLambda$2114367880$app(), composer2, 14180352, 44);
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(14.0f), composer2, 6);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-363687532);
                composer2.endReplaceGroup();
            }
            BasicsKt.OxSectionHead(LangKt.tx("Товары категории", new Object[i3]), null, StringsKt.isBlank(CategoryCardSheet$lambda$1(mutableState3)) ? modifier : LangKt.tx("найдено по запросу", new Object[i3]), String.valueOf(list.size()), null, null, composer2, 0, 50);
            String CategoryCardSheet$lambda$1 = CategoryCardSheet$lambda$1(mutableState3);
            ComposerKt.sourceInformationMarkerStart(composer2, 2066488028, str5);
            Object rememberedValue4 = composer2.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda32
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit CategoryCardSheet$lambda$13$0$1$0;
                        CategoryCardSheet$lambda$13$0$1$0 = CategorySheetsKt.CategoryCardSheet$lambda$13$0$1$0(MutableState.this, (String) obj2);
                        return CategoryCardSheet$lambda$13$0$1$0;
                    }
                };
                composer2.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            FieldsKt.OxSearchBox(CategoryCardSheet$lambda$1, (Function1) rememberedValue4, null, LangKt.tx("Поиск товара или кода", new Object[i3]), null, composer2, 48, 20);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer2, 6);
            if (list.isEmpty()) {
                composer2.startReplaceGroup(-363230158);
                ComposerKt.sourceInformation(composer2, "528@20411L162");
                BasicsKt.OxEmptyNote(list2.isEmpty() ? LangKt.tx("В этой категории пока нет товаров.", new Object[i3]) : LangKt.tx("Ничего не найдено.", new Object[i3]), modifier, composer2, i3, 2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-363043724);
                composer2.endReplaceGroup();
            }
            composer2.startReplaceGroup(2066501155);
            ComposerKt.sourceInformation(composer2, "*535@20644L1570");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Product product = (Product) it.next();
                Modifier m1049padding3ABfNKs2 = PaddingKt.m1049padding3ABfNKs(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, f, i2, modifier), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(8.0f), 7, null), OxShape.INSTANCE.getCardSoft()), Ox.INSTANCE.m10218getPanel20d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getCardSoft()), Dp.m6989constructorimpl(11.0f));
                Arrangement.HorizontalOrVertical m930spacedBy0680j_44 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(11.0f));
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                String str10 = str6;
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, str10);
                MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(m930spacedBy0680j_44, centerVertically, composer2, 54);
                String str11 = str3;
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str11);
                int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(composer2, i3);
                CompositionLocalMap currentCompositionLocalMap8 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier8 = ComposedModifierKt.materializeModifier(composer2, m1049padding3ABfNKs2);
                Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str2);
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
                ComposerKt.sourceInformationMarkerStart(composer2, -407735110, str4);
                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -222744147, "C546@21160L59,547@21240L758,563@22019L177:CategorySheets.kt#i65cod");
                CatalogScreenKt.m9774ProductThumbRFCenO8(product, j, Dp.m6989constructorimpl(42.0f), composer2, Product.$stable | 384);
                Modifier weight$default2 = RowScope.weight$default(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composer2, -483455358, str7);
                MeasurePolicy columnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, i3);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str11);
                int currentCompositeKeyHash9 = ComposablesKt.getCurrentCompositeKeyHash(composer2, i3);
                CompositionLocalMap currentCompositionLocalMap9 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier9 = ComposedModifierKt.materializeModifier(composer2, weight$default2);
                Function0<ComposeUiNode> constructor9 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str2);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor9);
                } else {
                    composer2.useNode();
                }
                Composer m3808constructorimpl9 = Updater.m3808constructorimpl(composer2);
                Updater.m3815setimpl(m3808constructorimpl9, columnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3815setimpl(m3808constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash9 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3808constructorimpl9.getInserting() || !Intrinsics.areEqual(m3808constructorimpl9.rememberedValue(), Integer.valueOf(currentCompositeKeyHash9))) {
                    m3808constructorimpl9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash9));
                    m3808constructorimpl9.apply(Integer.valueOf(currentCompositeKeyHash9), setCompositeKeyHash9);
                }
                Updater.m3815setimpl(m3808constructorimpl9, materializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 1415636761, "C548@21294L229,554@21548L428:CategorySheets.kt#i65cod");
                String str12 = str7;
                str3 = str11;
                String str13 = str4;
                String str14 = str2;
                float f3 = f;
                TextKt.m2798Text4IGK_g(product.getName(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), composer, 0, 3120, 55294);
                String qf = Fmt.INSTANCE.qf(Double.valueOf(product.getQuantity()));
                String name = Units.INSTANCE.name(product.getUnit());
                if (z3) {
                    i4 = 0;
                    str8 = LangKt.tx(" · закуп ", new Object[0]) + Fmt.INSTANCE.nf(Double.valueOf(product.getPurchasePrice()));
                } else {
                    i4 = 0;
                    str8 = "";
                }
                TextKt.m2798Text4IGK_g(qf + " " + name + str8, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 0, 3120, 55294);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                TextKt.m2798Text4IGK_g(Fmt.INSTANCE.money(Double.valueOf(product.getSalePrice()), str), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowPrice(), composer, 0, 3072, 57342);
                composer2 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                str4 = str13;
                str7 = str12;
                i2 = 1;
                i3 = i4;
                f = f3;
                modifier = null;
                str2 = str14;
                str6 = str10;
            }
            composer2.endReplaceGroup();
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
    public static final Unit CategoryCardSheet$lambda$13$0$0$2$0$0(Function0 function0, Function0 function02) {
        function0.invoke();
        function02.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoryCardSheet$lambda$13$0$0$2$1$0(CoroutineScope coroutineScope, MutableState mutableState, Category category, Repo repo, Function0 function0, Function0 function02) {
        CategoryCardSheet$restore(coroutineScope, mutableState, category, repo, function0, function02);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoryCardSheet$lambda$13$0$0$2$2$0(MutableState mutableState) {
        CategoryCardSheet$lambda$8(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoryCardSheet$lambda$13$0$1$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoryCardSheet$lambda$14$0(CoroutineScope coroutineScope, MutableState mutableState, Category category, Repo repo, Function0 function0, Function0 function02) {
        CategoryCardSheet$archive(coroutineScope, mutableState, category, repo, function0, function02);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoryCardSheet$lambda$15$0(MutableState mutableState) {
        CategoryCardSheet$lambda$8(mutableState, false);
        return Unit.INSTANCE;
    }

    /* renamed from: CategoryTile-Bx497Mc, reason: not valid java name */
    private static final void m9789CategoryTileBx497Mc(final RowScope rowScope, final String str, final String str2, final long j, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1609625990);
        ComposerKt.sourceInformation(startRestartGroup, "C(CategoryTile)P(2!,1:c#ui.graphics.Color)589@22851L463:CategorySheets.kt#i65cod");
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
        if (!startRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1609625990, i2, -1, "uz.FonRo.pos.ui.catalog.CategoryTile (CategorySheets.kt:588)");
            }
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), OxShape.INSTANCE.getTile()), Ox.INSTANCE.m10241tintBg5vOe2sY(j, 0.12f), null, 2, null), Dp.m6989constructorimpl(10.0f), Dp.m6989constructorimpl(9.0f));
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1427998112, "C596@23065L162,602@23236L72:CategorySheets.kt#i65cod");
            int i3 = i2;
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getStatValue(), j, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer2, (i3 >> 3) & 14, 3120, 55294);
            TextKt.m2798Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getTileLabel(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer2, (i3 >> 6) & 14, 3072, 57342);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CategorySheetsKt.CategoryTile_Bx497Mc$lambda$1(RowScope.this, str, str2, j, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void CategoryArchiveSheet(final FonRoApp FonRoApp, final List<Category> list, final boolean z, final List<Product> list2, final boolean z2, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-775925014);
        ComposerKt.sourceInformation(startRestartGroup, "C(CategoryArchiveSheet)P(!1,2,3,6)617@23645L44,620@23847L721,620@23766L802:CategorySheets.kt#i65cod");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(FonRoApp) : startRestartGroup.changedInstance(FonRoApp) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(list) : startRestartGroup.changedInstance(list) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= (i & 4096) == 0 ? startRestartGroup.changed(list2) : startRestartGroup.changedInstance(list2) ? 2048 : 1024;
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
                ComposerKt.traceEventStart(-775925014, i2, -1, "uz.FonRo.pos.ui.catalog.CategoryArchiveSheet (CategorySheets.kt:616)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1660379126, "CC(remember):CategorySheets.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SheetsKt.OxCardSheet(LangKt.tx("Архив категорий", new Object[0]), function0, null, false, false, false, null, ComposableLambdaKt.rememberComposableLambda(-138406322, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CategorySheetsKt.CategoryArchiveSheet$lambda$3(list, z, list2, mutableState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 >> 12) & 112) | 12779520, 92);
            Category CategoryArchiveSheet$lambda$1 = CategoryArchiveSheet$lambda$1(mutableState);
            if (CategoryArchiveSheet$lambda$1 != null) {
                startRestartGroup.startReplaceGroup(-66918041);
                ComposerKt.sourceInformation(startRestartGroup, "*647@24769L15,650@24872L29,642@24604L307");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1272200184, "CC(remember):CategorySheets.kt#9igjgp");
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CategoryArchiveSheet$lambda$4$0$0;
                            CategoryArchiveSheet$lambda$4$0$0 = CategorySheetsKt.CategoryArchiveSheet$lambda$4$0$0(MutableState.this);
                            return CategoryArchiveSheet$lambda$4$0$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                Function0 function03 = (Function0) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1272196874, "CC(remember):CategorySheets.kt#9igjgp");
                boolean z3 = (3670016 & i2) == 1048576;
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda25
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CategoryArchiveSheet$lambda$4$1$0;
                            CategoryArchiveSheet$lambda$4$1$0 = CategorySheetsKt.CategoryArchiveSheet$lambda$4$1$0(Function0.this, mutableState);
                            return CategoryArchiveSheet$lambda$4$1$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                int i3 = i2 >> 3;
                CategoryCardSheet(FonRoApp, CategoryArchiveSheet$lambda$1, list2, z2, function03, null, null, (Function0) rememberedValue3, startRestartGroup, 1794048 | FonRoApp.$stable | (i2 & 14) | (Category.$stable << 3) | (i3 & 896) | (i3 & 7168));
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-66918042);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CategorySheetsKt.CategoryArchiveSheet$lambda$5(FonRoApp.this, list, z, list2, z2, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final Category CategoryArchiveSheet$lambda$1(MutableState<Category> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CategoryArchiveSheet$lambda$3(List list, boolean z, List list2, final MutableState mutableState, ColumnScope OxCardSheet, Composer composer, int i) {
        int i2;
        String tx;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C621@23888L21,621@23857L705:CategorySheets.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-138406322, i, -1, "uz.FonRo.pos.ui.catalog.CategoryArchiveSheet.<anonymous> (CategorySheets.kt:621)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1329389191, "C622@23926L199,626@24138L11,637@24542L10:CategorySheets.kt#i65cod");
            TextKt.m2798Text4IGK_g(LangKt.tx("Архивная категория не показывается в фильтрах и в форме товара. Товары при этом остаются на складе.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            if (list.isEmpty()) {
                composer.startReplaceGroup(-1329145532);
                ComposerKt.sourceInformation(composer, "628@24206L70");
                if (z) {
                    i2 = 0;
                    tx = LangKt.tx("Архив пуст.", new Object[0]);
                } else {
                    i2 = 0;
                    tx = LangKt.tx("Загружаем архив…", new Object[0]);
                }
                BasicsKt.OxEmptyNote(tx, null, composer, i2, 2);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1329047510);
                composer.endReplaceGroup();
            }
            composer.startReplaceGroup(372770479);
            ComposerKt.sourceInformation(composer, "*634@24478L19,631@24352L163");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final Category category = (Category) it.next();
                ComposerKt.sourceInformationMarkerStart(composer, 1104368206, "CC(remember):CategorySheets.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(category);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CategoryArchiveSheet$lambda$3$0$0$0$0;
                            CategoryArchiveSheet$lambda$3$0$0$0$0 = CategorySheetsKt.CategoryArchiveSheet$lambda$3$0$0$0$0(Category.this, mutableState);
                            return CategoryArchiveSheet$lambda$3$0$0$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                CategoryCard(category, list2, (Function0) rememberedValue, composer, Category.$stable);
            }
            composer.endReplaceGroup();
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
    public static final Unit CategoryArchiveSheet$lambda$3$0$0$0$0(Category category, MutableState mutableState) {
        mutableState.setValue(category);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoryArchiveSheet$lambda$4$0$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoryArchiveSheet$lambda$4$1$0(Function0 function0, MutableState mutableState) {
        function0.invoke();
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    public static final void CategoryPickerSheet(final FonRoApp app, final long j, final Function1<? super Long, Unit> onPick, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(onPick, "onPick");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(-888371361);
        ComposerKt.sourceInformation(startRestartGroup, "C(CategoryPickerSheet)P(!1,3,2)664@25170L29,665@25217L68,668@25433L726,668@25358L801:CategorySheets.kt#i65cod");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(onPick) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 2048 : 1024;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-888371361, i3, -1, "uz.FonRo.pos.ui.catalog.CategoryPickerSheet (CategorySheets.kt:662)");
            }
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(app.getRepo().getCategories(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            List<Category> CategoryPickerSheet$lambda$0 = CategoryPickerSheet$lambda$0(collectAsStateWithLifecycle);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 973621539, "CC(remember):CategorySheets.kt#9igjgp");
            boolean changed = startRestartGroup.changed(CategoryPickerSheet$lambda$0);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = CollectionsKt.sortedWith(CategoryPickerSheet$lambda$0(collectAsStateWithLifecycle), new Comparator() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$CategoryPickerSheet$lambda$1$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        String lowerCase = ((Category) t).getName().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        String lowerCase2 = ((Category) t2).getName().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final List list = (List) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SheetsKt.OxCardSheet(LangKt.tx("Категория", new Object[0]), onDismiss, null, false, false, false, null, ComposableLambdaKt.rememberComposableLambda(1050471875, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CategorySheetsKt.CategoryPickerSheet$lambda$2(j, onPick, onDismiss, list, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i3 >> 6) & 112) | 12779520, 92);
            startRestartGroup = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CategorySheetsKt.CategoryPickerSheet$lambda$3(FonRoApp.this, j, onPick, onDismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CategoryPickerSheet$lambda$2(long j, final Function1 function1, final Function0 function0, List list, ColumnScope OxCardSheet, Composer composer, int i) {
        String str;
        Color color;
        boolean z;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C669@25474L21,669@25443L710:CategorySheets.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1050471875, i, -1, "uz.FonRo.pos.ui.catalog.CategoryPickerSheet.<anonymous> (CategorySheets.kt:669)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1369691903, "C674@25674L27,670@25512L203,685@26133L10:CategorySheets.kt#i65cod");
            String tx = LangKt.tx("Без категории", new Object[0]);
            boolean z2 = j == 0;
            ComposerKt.sourceInformationMarkerStart(composer, -1756927128, "CC(remember):CategorySheets.kt#9igjgp");
            boolean changed = composer.changed(function1) | composer.changed(function0);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CategoryPickerSheet$lambda$2$0$0$0;
                        CategoryPickerSheet$lambda$2$0$0$0 = CategorySheetsKt.CategoryPickerSheet$lambda$2$0$0$0(Function1.this, function0);
                        return CategoryPickerSheet$lambda$2$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m9787CategoryPickRowBAq54LU(tx, null, z2, (Function0) rememberedValue, composer, 48);
            composer.startReplaceGroup(-1756924891);
            ComposerKt.sourceInformation(composer, "*681@25979L36,677@25773L260");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final Category category = (Category) it.next();
                String name = category.getName();
                Color parseHexColor = CatalogScreenKt.parseHexColor(category.getColor());
                if (j == category.getId()) {
                    str = name;
                    color = parseHexColor;
                    z = true;
                } else {
                    str = name;
                    color = parseHexColor;
                    z = false;
                }
                ComposerKt.sourceInformationMarkerStart(composer, -938747308, "CC(remember):CategorySheets.kt#9igjgp");
                boolean changed2 = composer.changed(function1) | composer.changedInstance(category) | composer.changed(function0);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CategoryPickerSheet$lambda$2$0$1$0$0;
                            CategoryPickerSheet$lambda$2$0$1$0$0 = CategorySheetsKt.CategoryPickerSheet$lambda$2$0$1$0$0(Function1.this, category, function0);
                            return CategoryPickerSheet$lambda$2$0$1$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                m9787CategoryPickRowBAq54LU(str, color, z, (Function0) rememberedValue2, composer, 0);
            }
            composer.endReplaceGroup();
            if (list.isEmpty()) {
                composer.startReplaceGroup(-1756914061);
                ComposerKt.sourceInformation(composer, "684@26082L38");
                BasicsKt.OxEmptyNote(LangKt.tx("Категорий пока нет.", new Object[0]), null, composer, 0, 2);
            } else {
                composer.startReplaceGroup(1370275477);
            }
            composer.endReplaceGroup();
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
    public static final Unit CategoryPickerSheet$lambda$2$0$0$0(Function1 function1, Function0 function0) {
        function1.invoke(0L);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoryPickerSheet$lambda$2$0$1$0$0(Function1 function1, Category category, Function0 function0) {
        function1.invoke(Long.valueOf(category.getId()));
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: CategoryPickRow-BAq54LU, reason: not valid java name */
    private static final void m9787CategoryPickRowBAq54LU(final String str, final Color color, final boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        String str2;
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(2016688840);
        ComposerKt.sourceInformation(startRestartGroup, "C(CategoryPickRow)P(1,0:c#ui.graphics.Color,3)697@26296L1073:CategorySheets.kt#i65cod");
        if ((i & 6) == 0) {
            str2 = str;
            i2 = (startRestartGroup.changed(str2) ? 4 : 2) | i;
        } else {
            str2 = str;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(color) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2016688840, i3, -1, "uz.FonRo.pos.ui.catalog.CategoryPickRow (CategorySheets.kt:696)");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 398143332, "C701@26424L24,698@26338L1005,727@27352L11:CategorySheets.kt#i65cod");
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.m1084heightInVpY3zN4$default(ModifiersKt.oxTap(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, function0, startRestartGroup, ((i3 >> 3) & 896) | 6, 1), Dp.m6989constructorimpl(52.0f), 0.0f, 2, null), 0.0f, Dp.m6989constructorimpl(10.0f), 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, startRestartGroup, 54);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -376743436, "C707@26680L167,713@26860L261:CategorySheets.kt#i65cod");
            BoxKt.Box(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(12.0f)), OxShape.INSTANCE.getPill()), color != null ? color.m4394unboximpl() : Ox.INSTANCE.m10236getTrack0d7_KjU(), null, 2, null), startRestartGroup, 0);
            TextStyle rowTitle = OxType.INSTANCE.getRowTitle();
            Ox ox = Ox.INSTANCE;
            TextKt.m2798Text4IGK_g(str2, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(rowTitle, z ? ox.m10220getPrimary0d7_KjU() : ox.m10233getText0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), startRestartGroup, i3 & 14, 3120, 55292);
            startRestartGroup = startRestartGroup;
            if (z) {
                startRestartGroup.startReplaceGroup(-376276825);
                ComposerKt.sourceInformation(startRestartGroup, "721@27166L153");
                IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getOk(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(20.0f)), Ox.INSTANCE.m10220getPrimary0d7_KjU(), startRestartGroup, 432, 0);
                startRestartGroup = startRestartGroup;
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-376115904);
                startRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            BasicsKt.m9830OxDivideriPRSM58(0L, 0.0f, startRestartGroup, 0, 3);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CategorySheetsKt.CategoryPickRow_BAq54LU$lambda$1(str, color, z, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0121, code lost:
    
        if (r10 == null) goto L71;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void CategoryFormSheet(final uz.FonRo.pos.FonRoApp r20, final uz.FonRo.pos.data.model.Category r21, final kotlin.jvm.functions.Function0<kotlin.Unit> r22, final kotlin.jvm.functions.Function1<? super uz.FonRo.pos.data.model.Category, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, final int r25) {
        /*
            Method dump skipped, instructions count: 714
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.catalog.CategorySheetsKt.CategoryFormSheet(uz.FonRo.pos.FonRoApp, uz.FonRo.pos.data.model.Category, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    private static final String CategoryFormSheet$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CategoryFormSheet$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean CategoryFormSheet$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CategoryFormSheet$lambda$8(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean CategoryFormSheet$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CategoryFormSheet$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void CategoryFormSheet$save(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, MutableState<String> mutableState2, Category category, Repo repo, Function1<? super Category, Unit> function1, boolean z, Function0<Unit> function0, MutableState<String> mutableState3) {
        if (CategoryFormSheet$lambda$7(mutableState)) {
            return;
        }
        String obj = StringsKt.trim((CharSequence) CategoryFormSheet$lambda$1(mutableState2)).toString();
        if (obj.length() == 0) {
            Toaster.INSTANCE.error(LangKt.tx("Введите название", new Object[0]));
        } else {
            CategoryFormSheet$lambda$8(mutableState, true);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CategorySheetsKt$CategoryFormSheet$save$1(obj, category, repo, function1, z, function0, mutableState3, mutableState, null), 3, null);
        }
    }

    private static final void CategoryFormSheet$archive(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, Repo repo, Function0<Unit> function0, Category category) {
        if (CategoryFormSheet$lambda$7(mutableState)) {
            return;
        }
        CategoryFormSheet$lambda$8(mutableState, true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CategorySheetsKt$CategoryFormSheet$archive$1(category, repo, function0, mutableState, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CategoryFormSheet$lambda$12(final Category category, final boolean z, final CoroutineScope coroutineScope, final Repo repo, final Function1 function1, final Function0 function0, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C843@31697L10,841@31608L273:CategorySheets.kt#i65cod");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1252086356, i2, -1, "uz.FonRo.pos.ui.catalog.CategoryFormSheet.<anonymous> (CategorySheets.kt:832)");
            }
            if (category != null) {
                composer.startReplaceGroup(-886289894);
                ComposerKt.sourceInformation(composer, "835@31402L25,833@31337L244");
                String tx = LangKt.tx("В архив", new Object[0]);
                ComposerKt.sourceInformationMarkerStart(composer, 664149069, "CC(remember):CategorySheets.kt#9igjgp");
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CategoryFormSheet$lambda$12$0$0;
                            CategoryFormSheet$lambda$12$0$0 = CategorySheetsKt.CategoryFormSheet$lambda$12$0$0(MutableState.this);
                            return CategoryFormSheet$lambda$12$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                BasicsKt.OxButton(tx, (Function0) rememberedValue, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.DANGER, null, !CategoryFormSheet$lambda$7(mutableState2), false, null, composer, 3120, 208);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2 = composer;
                composer2.startReplaceGroup(-886024658);
                composer2.endReplaceGroup();
            }
            String tx2 = z ? LangKt.tx("Создать", new Object[0]) : LangKt.tx("Сохранить", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer2, 664158494, "CC(remember):CategorySheets.kt#9igjgp");
            boolean changedInstance = composer2.changedInstance(coroutineScope) | composer2.changedInstance(category) | composer2.changedInstance(repo) | composer2.changed(function1) | composer2.changed(z) | composer2.changed(function0);
            Object rememberedValue2 = composer2.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Function0 function02 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CategoryFormSheet$lambda$12$1$0;
                        CategoryFormSheet$lambda$12$1$0 = CategorySheetsKt.CategoryFormSheet$lambda$12$1$0(CoroutineScope.this, mutableState2, mutableState3, category, repo, function1, z, function0, mutableState4);
                        return CategoryFormSheet$lambda$12$1$0;
                    }
                };
                composer2.updateRememberedValue(function02);
                rememberedValue2 = function02;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            BasicsKt.OxButton(tx2, (Function0) rememberedValue2, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 2.0f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, !CategoryFormSheet$lambda$7(mutableState2), false, null, composer2, 27648, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoryFormSheet$lambda$12$0$0(MutableState mutableState) {
        CategoryFormSheet$lambda$11(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoryFormSheet$lambda$12$1$0(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, Category category, Repo repo, Function1 function1, boolean z, Function0 function0, MutableState mutableState3) {
        CategoryFormSheet$save(coroutineScope, mutableState, mutableState2, category, repo, function1, z, function0, mutableState3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CategoryFormSheet$lambda$13(final MutableState mutableState, final MutableState mutableState2, ColumnScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C851@31908L189,858@32174L13,856@32106L142,861@32257L11,863@32278L185,868@32472L237,874@32718L11,875@32738L237,881@32984L11:CategorySheets.kt#i65cod");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(830158411, i, -1, "uz.FonRo.pos.ui.catalog.CategoryFormSheet.<anonymous> (CategorySheets.kt:851)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Название", new Object[0]), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(8.0f), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), 0L, TextUnitKt.getSp(14), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 48, 0, 65532);
            String CategoryFormSheet$lambda$1 = CategoryFormSheet$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, -1081675240, "CC(remember):CategorySheets.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit CategoryFormSheet$lambda$13$0$0;
                        CategoryFormSheet$lambda$13$0$0 = CategorySheetsKt.CategoryFormSheet$lambda$13$0$0(MutableState.this, (String) obj);
                        return CategoryFormSheet$lambda$13$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9848OxSolidInputYxU46PI(CategoryFormSheet$lambda$1, (Function1) rememberedValue, null, LangKt.tx("Например: Напитки", new Object[0]), 0, false, composer, 48, 52);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(16.0f), composer, 6);
            String str = "CC(remember):CategorySheets.kt#9igjgp";
            TextKt.m2798Text4IGK_g(LangKt.tx("Цвет", new Object[0]), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(8.0f), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), 0L, TextUnitKt.getSp(14), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 48, 0, 65532);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
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
            ComposerKt.sourceInformationMarkerStart(composer, 937320166, "C:CategorySheets.kt#i65cod");
            composer.startReplaceGroup(-1355236443);
            ComposerKt.sourceInformation(composer, "*872@32682L15,872@32654L43");
            for (final String str2 : CollectionsKt.take(CATEGORY_COLORS, 5)) {
                boolean areEqual = Intrinsics.areEqual(CategoryFormSheet$lambda$4(mutableState2), str2);
                String str3 = str;
                ComposerKt.sourceInformationMarkerStart(composer, -230527738, str3);
                boolean changed = composer.changed(str2);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CategoryFormSheet$lambda$13$1$0$0$0;
                            CategoryFormSheet$lambda$13$1$0$0$0 = CategorySheetsKt.CategoryFormSheet$lambda$13$1$0$0$0(str2, mutableState2);
                            return CategoryFormSheet$lambda$13$1$0$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ColorDot(str2, areEqual, (Function0) rememberedValue2, composer, 0);
                str = str3;
            }
            String str4 = str;
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer, 6);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
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
            ComposerKt.sourceInformationMarkerStart(composer, -227329635, "C:CategorySheets.kt#i65cod");
            composer.startReplaceGroup(131214862);
            ComposerKt.sourceInformation(composer, "*879@32948L15,879@32920L43");
            for (final String str5 : CollectionsKt.drop(CATEGORY_COLORS, 5)) {
                boolean areEqual2 = Intrinsics.areEqual(CategoryFormSheet$lambda$4(mutableState2), str5);
                ComposerKt.sourceInformationMarkerStart(composer, -1355402385, str4);
                boolean changed2 = composer.changed(str5);
                Object rememberedValue3 = composer.rememberedValue();
                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CategoryFormSheet$lambda$13$2$0$0$0;
                            CategoryFormSheet$lambda$13$2$0$0$0 = CategorySheetsKt.CategoryFormSheet$lambda$13$2$0$0$0(str5, mutableState2);
                            return CategoryFormSheet$lambda$13$2$0$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ColorDot(str5, areEqual2, (Function0) rememberedValue3, composer, 0);
            }
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoryFormSheet$lambda$13$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoryFormSheet$lambda$13$1$0$0$0(String str, MutableState mutableState) {
        mutableState.setValue(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoryFormSheet$lambda$13$2$0$0$0(String str, MutableState mutableState) {
        mutableState.setValue(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoryFormSheet$lambda$14$0(Category category, CoroutineScope coroutineScope, MutableState mutableState, Repo repo, Function0 function0) {
        CategoryFormSheet$archive(coroutineScope, mutableState, repo, function0, category);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoryFormSheet$lambda$15$0(MutableState mutableState) {
        CategoryFormSheet$lambda$11(mutableState, false);
        return Unit.INSTANCE;
    }

    private static final void ColorDot(final String str, final boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1025974758);
        ComposerKt.sourceInformation(startRestartGroup, "C(ColorDot)P(1)908@33881L24,898@33563L348:CategorySheets.kt#i65cod");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
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
                ComposerKt.traceEventStart(1025974758, i2, -1, "uz.FonRo.pos.ui.catalog.ColorDot (CategorySheets.kt:896)");
            }
            Color parseHexColor = CatalogScreenKt.parseHexColor(str);
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(44.0f)), OxShape.INSTANCE.getPill()), (parseHexColor == null && (parseHexColor = CatalogScreenKt.parseHexColor(CATEGORY_FALLBACK_COLOR)) == null) ? Ox.INSTANCE.m10201getGreen0d7_KjU() : parseHexColor.m4394unboximpl(), null, 2, null);
            float m6989constructorimpl = Dp.m6989constructorimpl(z ? 3.0f : 1.0f);
            Ox ox = Ox.INSTANCE;
            BoxKt.Box(ModifiersKt.oxTap(BorderKt.m569borderxT4_qwU(m558backgroundbw27NRU$default, m6989constructorimpl, z ? ox.m10233getText0d7_KjU() : ox.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getPill()), false, function0, startRestartGroup, i2 & 896, 1), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.CategorySheetsKt$$ExternalSyntheticLambda38
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CategorySheetsKt.ColorDot$lambda$0(str, z, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final List<Category> CategoriesSheet$lambda$0(State<? extends List<Category>> state) {
        return state.getValue();
    }

    private static final List<Product> CategoriesSheet$lambda$1(State<? extends List<Product>> state) {
        return state.getValue();
    }

    private static final List<Category> CategoryPickerSheet$lambda$0(State<? extends List<Category>> state) {
        return state.getValue();
    }
}
