package uz.FonRo.pos.ui.print;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
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
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.PointerIconCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.BarcodeKind;
import uz.FonRo.pos.core.Barcodes;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Units;
import uz.FonRo.pos.data.local.CacheStore;
import uz.FonRo.pos.data.model.Category;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.model.Store;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.print.LabelDoc;
import uz.FonRo.pos.print.LabelLayout;
import uz.FonRo.pos.print.LabelLayouts;
import uz.FonRo.pos.print.SheetKind;
import uz.FonRo.pos.ui.Toaster;
import uz.FonRo.pos.ui.catalog.CatalogScreenKt;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnSize;
import uz.FonRo.pos.ui.components.ChipTint;
import uz.FonRo.pos.ui.components.ChipTone;
import uz.FonRo.pos.ui.components.ChipsKt;
import uz.FonRo.pos.ui.components.FieldsKt;
import uz.FonRo.pos.ui.components.ModifiersKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: PrintLabelsScreen.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\u001a/\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007b\u0002\b\nb\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r¢\u0006\u0002\u0010\t\u001aM\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u0015H\u0003b\u0002\b\nb\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r¢\u0006\u0002\u0010\u0016\u001a9\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0003b\u0002\b\nb\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r¢\u0006\u0002\u0010\u001c\u001aa\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0003b\u0002\b\nb\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r¢\u0006\u0002\u0010&\u001aQ\u0010'\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0003b\u0002\b\nb\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r¢\u0006\u0002\u0010(\u001a=\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00122\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0003b\u0002\b\nb\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r¢\u0006\u0002\u0010-\u001aI\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u0002002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00040\u00152\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0003b\u0002\b\nb\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r¢\u0006\u0002\u00103\u001aK\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u0002002\u0006\u0010/\u001a\u0002002\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00040\u0015H\u0003b\u0002\b\nb\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r¢\u0006\u0002\u00106\u001aY\u00107\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\u00102\u0006\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0003b\u0002\b\nb\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r¢\u0006\u0002\u0010<\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005²\u0006\u0010\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001f0>X\u008a\u0084\u0002²\u0006\u0010\u0010?\u001a\b\u0012\u0004\u0012\u00020@0>X\u008a\u0084\u0002²\u0006\f\u0010A\u001a\u0004\u0018\u00010BX\u008a\u0084\u0002²\u0006\n\u0010C\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\f\u0010D\u001a\u0004\u0018\u00010EX\u008a\u008e\u0002²\u0006\n\u0010F\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\u0016\u0010 \u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\u00010GX\u008a\u008e\u0002²\u0006\n\u0010H\u001a\u000200X\u008a\u008e\u0002²\u0006\n\u00109\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010:\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010;\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010I\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010J\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\f\u0010K\u001a\u0004\u0018\u00010\u001fX\u008a\u008e\u0002²\u0006\n\u0010L\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010M\u001a\u00020\u0012X\u008a\u008e\u0002"}, d2 = {"LIST_LIMIT", "", "MAX_COPIES", "PrintLabelsScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "ToggleRow", "title", "", "checked", "", "divider", "onChange", "Lkotlin/Function1;", "(Ljava/lang/String;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Tile", "label", "value", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ProductCopiesRow", "product", "Luz/FonRo/pos/data/model/Product;", "copies", FirebaseAnalytics.Param.CURRENCY, "onMinus", "Lkotlin/Function0;", "onPlus", "onExact", "(Luz/FonRo/pos/data/model/Product;ILjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Stepper", "(ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "StepButton", "sign", "enabled", "onClick", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SizeSheet", "current", "Luz/FonRo/pos/print/LabelLayout;", "onPick", "onDismiss", "(Luz/FonRo/pos/print/LabelLayout;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SizeRow", "item", "(Luz/FonRo/pos/print/LabelLayout;Luz/FonRo/pos/print/LabelLayout;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "LabelPreview", "storeName", "showName", "showPrice", "showDigits", "(Luz/FonRo/pos/data/model/Product;Ljava/lang/String;ZZZLjava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", CacheStore.PRODUCTS, "", CacheStore.CATEGORIES, "Luz/FonRo/pos/data/model/Category;", "store", "Luz/FonRo/pos/data/model/Store;", FirebaseAnalytics.Event.SEARCH, "categoryId", "", "onlyNoCode", "", "layout", "showStore", "sizeSheet", "copiesFor", "issueConfirm", "busy"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class PrintLabelsScreenKt {
    private static final int LIST_LIMIT = 200;
    private static final int MAX_COPIES = 999;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LabelPreview$lambda$2(Product product, String str, boolean z, boolean z2, boolean z3, String str2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        LabelPreview(product, str, z, z2, z3, str2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PrintLabelsScreen$lambda$58(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        PrintLabelsScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ProductCopiesRow$lambda$1(Product product, int i, String str, Function0 function0, Function0 function02, Function0 function03, int i2, Composer composer, int i3) {
        ProductCopiesRow(product, i, str, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SizeRow$lambda$2(LabelLayout labelLayout, LabelLayout labelLayout2, boolean z, Function1 function1, int i, Composer composer, int i2) {
        SizeRow(labelLayout, labelLayout2, z, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SizeSheet$lambda$1(LabelLayout labelLayout, Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        SizeSheet(labelLayout, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit StepButton$lambda$1(String str, boolean z, Function0 function0, int i, Composer composer, int i2) {
        StepButton(str, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Stepper$lambda$1(int i, Function0 function0, Function0 function02, Function0 function03, int i2, Composer composer, int i3) {
        Stepper(i, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Tile$lambda$1(String str, String str2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        Tile(str, str2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ToggleRow$lambda$2(String str, boolean z, boolean z2, Function1 function1, int i, int i2, Composer composer, int i3) {
        ToggleRow(str, z, z2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:304:0x03a7, code lost:
    
        if (r20 != r16.longValue()) goto L104;
     */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0afa  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0b66  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0bf3  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0cc8  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0cb9  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0b71  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0b57  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void PrintLabelsScreen(uz.FonRo.pos.FonRoApp r62, final uz.FonRo.pos.ui.nav.AppNavigator r63, androidx.compose.runtime.Composer r64, final int r65) {
        /*
            Method dump skipped, instructions count: 3298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.print.PrintLabelsScreenKt.PrintLabelsScreen(uz.FonRo.pos.FonRoApp, uz.FonRo.pos.ui.nav.AppNavigator, androidx.compose.runtime.Composer, int):void");
    }

    private static final String PrintLabelsScreen$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final Long PrintLabelsScreen$lambda$7(MutableState<Long> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean PrintLabelsScreen$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PrintLabelsScreen$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Map<Long, Integer> PrintLabelsScreen$lambda$13(MutableState<Map<Long, Integer>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LabelLayout PrintLabelsScreen$lambda$16(MutableState<LabelLayout> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean PrintLabelsScreen$lambda$19(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PrintLabelsScreen$lambda$20(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean PrintLabelsScreen$lambda$22(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PrintLabelsScreen$lambda$23(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean PrintLabelsScreen$lambda$25(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PrintLabelsScreen$lambda$26(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean PrintLabelsScreen$lambda$28(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PrintLabelsScreen$lambda$29(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean PrintLabelsScreen$lambda$31(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PrintLabelsScreen$lambda$32(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Product PrintLabelsScreen$lambda$34(MutableState<Product> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean PrintLabelsScreen$lambda$37(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PrintLabelsScreen$lambda$38(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean PrintLabelsScreen$lambda$40(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PrintLabelsScreen$lambda$41(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int PrintLabelsScreen$copiesOf(MutableState<Map<Long, Integer>> mutableState, long j) {
        Integer num = PrintLabelsScreen$lambda$13(mutableState).get(Long.valueOf(j));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PrintLabelsScreen$setCopies(MutableState<Map<Long, Integer>> mutableState, long j, int i) {
        int coerceIn = RangesKt.coerceIn(i, 0, 999);
        mutableState.setValue(coerceIn == 0 ? MapsKt.minus(PrintLabelsScreen$lambda$13(mutableState), Long.valueOf(j)) : MapsKt.plus(PrintLabelsScreen$lambda$13(mutableState), TuplesKt.to(Long.valueOf(j), Integer.valueOf(coerceIn))));
    }

    private static final List<LabelDoc> PrintLabelsScreen$labelsFor(List<Product> list, MutableState<Map<Long, Integer>> mutableState, String str, String str2, MutableState<Boolean> mutableState2, MutableState<Boolean> mutableState3, MutableState<Boolean> mutableState4, MutableState<Boolean> mutableState5) {
        ArrayList arrayList = new ArrayList();
        for (Product product : list) {
            int PrintLabelsScreen$copiesOf = PrintLabelsScreen$copiesOf(mutableState, product.getId());
            ArrayList arrayList2 = new ArrayList(PrintLabelsScreen$copiesOf);
            for (int i = 0; i < PrintLabelsScreen$copiesOf; i++) {
                String str3 = "";
                String name = PrintLabelsScreen$lambda$19(mutableState2) ? product.getName() : "";
                String money = PrintLabelsScreen$lambda$22(mutableState3) ? Fmt.INSTANCE.money(Double.valueOf(product.getSalePrice()), str) : "";
                String barcode = product.getBarcode();
                if (barcode == null) {
                    barcode = "";
                }
                if (PrintLabelsScreen$lambda$28(mutableState4)) {
                    str3 = str2;
                }
                arrayList2.add(new LabelDoc(name, money, barcode, str3, PrintLabelsScreen$lambda$25(mutableState5)));
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        return arrayList;
    }

    private static final void PrintLabelsScreen$print(List<Product> list, CoroutineScope coroutineScope, MutableState<Boolean> mutableState, MutableState<Map<Long, Integer>> mutableState2, String str, String str2, MutableState<Boolean> mutableState3, MutableState<Boolean> mutableState4, MutableState<Boolean> mutableState5, MutableState<Boolean> mutableState6, Context context, FonRoApp FonRoApp, MutableState<LabelLayout> mutableState7) {
        if (PrintLabelsScreen$lambda$40(mutableState)) {
            return;
        }
        if (list.isEmpty()) {
            Toaster.INSTANCE.error(LangKt.tx("Укажите, сколько наклеек напечатать", new Object[0]));
        } else {
            PrintLabelsScreen$lambda$41(mutableState, true);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PrintLabelsScreenKt$PrintLabelsScreen$print$1(context, FonRoApp, PrintLabelsScreen$labelsFor(list, mutableState2, str, str2, mutableState3, mutableState4, mutableState5, mutableState6), mutableState7, mutableState, null), 3, null);
        }
    }

    private static final void PrintLabelsScreen$issueCodes(List<Product> list, CoroutineScope coroutineScope, MutableState<Boolean> mutableState, List<Product> list2, Repo repo) {
        if (PrintLabelsScreen$lambda$40(mutableState) || list.isEmpty()) {
            return;
        }
        PrintLabelsScreen$lambda$41(mutableState, true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PrintLabelsScreenKt$PrintLabelsScreen$issueCodes$1(list2, list, repo, mutableState, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0(final List list, final List list2, final List list3, final List list4, final List list5, final int i, final int i2, final int i3, final int i4, final MutableState mutableState, final MutableState mutableState2, final boolean z, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, final MutableState mutableState8, final MutableState mutableState9, final List list6, final MutableState mutableState10, final MutableState mutableState11, final MutableState mutableState12, String str, final MutableState mutableState13, final String str2, LazyListScope LazyColumn) {
        final String str3;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, "head", null, ComposableSingletons$PrintLabelsScreenKt.INSTANCE.m10082getLambda$1262166966$app(), 2, null);
        LazyListScope.item$default(LazyColumn, "summary", null, ComposableLambdaKt.composableLambdaInstance(543482227, true, new Function3() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit PrintLabelsScreen$lambda$52$0$0$0;
                PrintLabelsScreen$lambda$52$0$0$0 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$0(list5, i, i2, i3, i4, mutableState, mutableState2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return PrintLabelsScreen$lambda$52$0$0$0;
            }
        }), 2, null);
        if (!list.isEmpty()) {
            LazyListScope.item$default(LazyColumn, "issue", null, ComposableLambdaKt.composableLambdaInstance(-205154865, true, new Function3() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit PrintLabelsScreen$lambda$52$0$0$1;
                    PrintLabelsScreen$lambda$52$0$0$1 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$1(list, z, mutableState3, mutableState4, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PrintLabelsScreen$lambda$52$0$0$1;
                }
            }), 2, null);
        }
        LazyListScope.item$default(LazyColumn, "toggles", null, ComposableLambdaKt.composableLambdaInstance(58536978, true, new Function3() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit PrintLabelsScreen$lambda$52$0$0$2;
                PrintLabelsScreen$lambda$52$0$0$2 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$2(MutableState.this, mutableState6, mutableState7, mutableState8, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return PrintLabelsScreen$lambda$52$0$0$2;
            }
        }), 2, null);
        LazyListScope.item$default(LazyColumn, FirebaseAnalytics.Event.SEARCH, null, ComposableLambdaKt.composableLambdaInstance(-426408271, true, new Function3() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit PrintLabelsScreen$lambda$52$0$0$3;
                PrintLabelsScreen$lambda$52$0$0$3 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$3(MutableState.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return PrintLabelsScreen$lambda$52$0$0$3;
            }
        }), 2, null);
        LazyListScope.item$default(LazyColumn, "filters", null, ComposableLambdaKt.composableLambdaInstance(-911353520, true, new Function3() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda39
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit PrintLabelsScreen$lambda$52$0$0$4;
                PrintLabelsScreen$lambda$52$0$0$4 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$4(list6, i4, mutableState10, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return PrintLabelsScreen$lambda$52$0$0$4;
            }
        }), 2, null);
        if (!list2.isEmpty()) {
            LazyListScope.item$default(LazyColumn, CacheStore.CATEGORIES, null, ComposableLambdaKt.composableLambdaInstance(-1575137864, true, new Function3() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda40
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit PrintLabelsScreen$lambda$52$0$0$5;
                    PrintLabelsScreen$lambda$52$0$0$5 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$5(list2, mutableState11, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PrintLabelsScreen$lambda$52$0$0$5;
                }
            }), 2, null);
        }
        LazyListScope.item$default(LazyColumn, "list-head", null, ComposableLambdaKt.composableLambdaInstance(-1396298769, true, new Function3() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit PrintLabelsScreen$lambda$52$0$0$6;
                PrintLabelsScreen$lambda$52$0$0$6 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$6(list4, list5, mutableState12, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return PrintLabelsScreen$lambda$52$0$0$6;
            }
        }), 2, null);
        if (list3.isEmpty()) {
            LazyListScope.item$default(LazyColumn, "list-empty", null, ComposableLambdaKt.composableLambdaInstance(-2060083113, true, new Function3() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda42
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit PrintLabelsScreen$lambda$52$0$0$7;
                    PrintLabelsScreen$lambda$52$0$0$7 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$7(list6, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PrintLabelsScreen$lambda$52$0$0$7;
                }
            }), 2, null);
            str3 = str;
        } else {
            final Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda43
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object PrintLabelsScreen$lambda$52$0$0$8;
                    PrintLabelsScreen$lambda$52$0$0$8 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$8((Product) obj);
                    return PrintLabelsScreen$lambda$52$0$0$8;
                }
            };
            final PrintLabelsScreenKt$PrintLabelsScreen$lambda$52$0$0$$inlined$items$default$1 printLabelsScreenKt$PrintLabelsScreen$lambda$52$0$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$PrintLabelsScreen$lambda$52$0$0$$inlined$items$default$1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(Product product) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((Product) obj);
                }
            };
            str3 = str;
            LazyColumn.items(list3.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$PrintLabelsScreen$lambda$52$0$0$$inlined$items$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i5) {
                    return Function1.this.invoke(list3.get(i5));
                }
            }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$PrintLabelsScreen$lambda$52$0$0$$inlined$items$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i5) {
                    return Function1.this.invoke(list3.get(i5));
                }
            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$PrintLabelsScreen$lambda$52$0$0$$inlined$items$default$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope lazyItemScope, int i5, Composer composer, int i6) {
                    int i7;
                    int PrintLabelsScreen$copiesOf;
                    ComposerKt.sourceInformation(composer, "C178@8826L22:LazyDsl.kt#428nma");
                    if ((i6 & 6) == 0) {
                        i7 = (composer.changed(lazyItemScope) ? 4 : 2) | i6;
                    } else {
                        i7 = i6;
                    }
                    if ((i6 & 48) == 0) {
                        i7 |= composer.changed(i5) ? 32 : 16;
                    }
                    if (!composer.shouldExecute((i7 & 147) != 146, i7 & 1)) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-632812321, i7, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                    }
                    final Product product = (Product) list3.get(i5);
                    composer.startReplaceGroup(-412001471);
                    ComposerKt.sourceInformation(composer, "C*422@17969L51,423@18055L51,424@18142L23,418@17774L413:PrintLabelsScreen.kt#fixedd");
                    PrintLabelsScreen$copiesOf = PrintLabelsScreenKt.PrintLabelsScreen$copiesOf(mutableState12, product.getId());
                    String str4 = str3;
                    ComposerKt.sourceInformationMarkerStart(composer, 125262840, "CC(remember):PrintLabelsScreen.kt#9igjgp");
                    boolean changedInstance = composer.changedInstance(product);
                    Object rememberedValue = composer.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        final MutableState mutableState14 = mutableState12;
                        rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$PrintLabelsScreen$2$1$1$10$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                int PrintLabelsScreen$copiesOf2;
                                MutableState<Map<Long, Integer>> mutableState15 = mutableState14;
                                long id = Product.this.getId();
                                PrintLabelsScreen$copiesOf2 = PrintLabelsScreenKt.PrintLabelsScreen$copiesOf(mutableState14, Product.this.getId());
                                PrintLabelsScreenKt.PrintLabelsScreen$setCopies(mutableState15, id, PrintLabelsScreen$copiesOf2 - 1);
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    Function0 function0 = (Function0) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, 125265592, "CC(remember):PrintLabelsScreen.kt#9igjgp");
                    boolean changedInstance2 = composer.changedInstance(product);
                    Object rememberedValue2 = composer.rememberedValue();
                    if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        final MutableState mutableState15 = mutableState12;
                        rememberedValue2 = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$PrintLabelsScreen$2$1$1$10$2$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                int PrintLabelsScreen$copiesOf2;
                                MutableState<Map<Long, Integer>> mutableState16 = mutableState15;
                                long id = Product.this.getId();
                                PrintLabelsScreen$copiesOf2 = PrintLabelsScreenKt.PrintLabelsScreen$copiesOf(mutableState15, Product.this.getId());
                                PrintLabelsScreenKt.PrintLabelsScreen$setCopies(mutableState16, id, PrintLabelsScreen$copiesOf2 + 1);
                            }
                        };
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    Function0 function02 = (Function0) rememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerStart(composer, 125268348, "CC(remember):PrintLabelsScreen.kt#9igjgp");
                    boolean changedInstance3 = composer.changedInstance(product);
                    Object rememberedValue3 = composer.rememberedValue();
                    if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        final MutableState mutableState16 = mutableState13;
                        rememberedValue3 = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$PrintLabelsScreen$2$1$1$10$3$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                mutableState16.setValue(Product.this);
                            }
                        };
                        composer.updateRememberedValue(rememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    PrintLabelsScreenKt.ProductCopiesRow(product, PrintLabelsScreen$copiesOf, str4, function0, function02, (Function0) rememberedValue3, composer, Product.$stable);
                    composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            if (list4.size() > list3.size()) {
                LazyListScope.item$default(LazyColumn, "list-more", null, ComposableLambdaKt.composableLambdaInstance(-913953741, true, new Function3() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda45
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit PrintLabelsScreen$lambda$52$0$0$10;
                        PrintLabelsScreen$lambda$52$0$0$10 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$10(list3, list4, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return PrintLabelsScreen$lambda$52$0$0$10;
                    }
                }), 2, null);
            }
        }
        LazyListScope.item$default(LazyColumn, "preview", null, ComposableLambdaKt.composableLambdaInstance(-1881244018, true, new Function3() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit PrintLabelsScreen$lambda$52$0$0$11;
                PrintLabelsScreen$lambda$52$0$0$11 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$11(list5, mutableState, str2, str3, mutableState8, mutableState5, mutableState6, mutableState7, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return PrintLabelsScreen$lambda$52$0$0$11;
            }
        }), 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$0(final List list, final int i, final int i2, final int i3, final int i4, final MutableState mutableState, final MutableState mutableState2, LazyItemScope item, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C261@10785L2038,261@10778L2045:PrintLabelsScreen.kt#fixedd");
        if (!composer.shouldExecute((i5 & 17) != 16, i5 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(543482227, i5, -1, "uz.FonRo.pos.ui.print.PrintLabelsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PrintLabelsScreen.kt:261)");
            }
            BasicsKt.m9829OxCardEOp_iR4(null, 0.0f, 0L, null, null, ComposableLambdaKt.rememberComposableLambda(1783251800, true, new Function3() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit PrintLabelsScreen$lambda$52$0$0$0$0;
                    PrintLabelsScreen$lambda$52$0$0$0$0 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$0$0(list, i, i2, i3, i4, mutableState, mutableState2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PrintLabelsScreen$lambda$52$0$0$0$0;
                }
            }, composer, 54), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$0$0(List list, int i, int i2, int i3, int i4, MutableState mutableState, final MutableState mutableState2, ColumnScope OxCard, Composer composer, int i5) {
        int i6;
        String tx;
        Intrinsics.checkNotNullParameter(OxCard, "$this$OxCard");
        ComposerKt.sourceInformation(composer, "C262@10807L543,272@11371L11,273@11403L793,286@12217L11,290@12400L20,287@12249L193:PrintLabelsScreen.kt#fixedd");
        if (!composer.shouldExecute((i5 & 17) != 16, i5 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1783251800, i5, -1, "uz.FonRo.pos.ui.print.PrintLabelsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PrintLabelsScreen.kt:262)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
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
            ComposerKt.sourceInformationMarkerStart(composer, -355013516, "C263@10885L206,267@11116L212:PrintLabelsScreen.kt#fixedd");
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
            ComposerKt.sourceInformationMarkerStart(composer, 861504011, "C264@10943L42,265@11014L51:PrintLabelsScreen.kt#fixedd");
            TextKt.m2798Text4IGK_g(LangKt.tx("К печати", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getLabel(), composer, 0, 0, 65534);
            TextKt.m2798Text4IGK_g(String.valueOf(i), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getAmount(), composer, 0, 0, 65534);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (list.isEmpty()) {
                i6 = 0;
                tx = LangKt.tx("Не готово", new Object[0]);
            } else {
                i6 = 0;
                tx = LangKt.tx("Готово", new Object[0]);
            }
            BasicsKt.OxChip(tx, list.isEmpty() ? ChipTone.DIM : ChipTone.OK, null, composer, 0, 4);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer, 6);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, i6);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, companion2);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1499257099, "C274@11485L64,275@11574L290,280@11889L285:PrintLabelsScreen.kt#fixedd");
            Tile(LangKt.tx("Товаров", new Object[i6]), String.valueOf(list.size()), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0, 0);
            Tile(PrintLabelsScreen$lambda$16(mutableState).getKind() == SheetKind.A4 ? LangKt.tx("Листов A4", new Object[i6]) : LangKt.tx("Наклеек подряд", new Object[i6]), PrintLabelsScreen$lambda$16(mutableState).getKind() == SheetKind.A4 ? String.valueOf(i2) : String.valueOf(i), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0, 0);
            Tile(PrintLabelsScreen$lambda$16(mutableState).getKind() == SheetKind.A4 ? LangKt.tx("На листе", new Object[i6]) : LangKt.tx("Без кода", new Object[i6]), PrintLabelsScreen$lambda$16(mutableState).getKind() == SheetKind.A4 ? String.valueOf(i3) : String.valueOf(i4), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(11.0f), composer, 6);
            String tx2 = LangKt.tx("Размер наклейки:", new Object[i6]);
            String title = PrintLabelsScreen$lambda$16(mutableState).getTitle();
            ComposerKt.sourceInformationMarkerStart(composer, 13080396, "CC(remember):PrintLabelsScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PrintLabelsScreen$lambda$52$0$0$0$0$2$0;
                        PrintLabelsScreen$lambda$52$0$0$0$0$2$0 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$0$0$2$0(MutableState.this);
                        return PrintLabelsScreen$lambda$52$0$0$0$0$2$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9849OxValueButtonFHprtrg(tx2, title, (Function0) rememberedValue, null, 0L, null, composer, 384, 56);
            if (PrintLabelsScreen$lambda$16(mutableState).getKind() == SheetKind.A4) {
                composer.startReplaceGroup(405596469);
                ComposerKt.sourceInformation(composer, "293@12522L10,294@12557L226");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(7.0f), composer, 6);
                TextKt.m2798Text4IGK_g(LangKt.tx("В окне печати поставьте масштаб 100% и снимите поля по умолчанию — иначе наклейки уедут мимо разметки листа.", new Object[i6]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(405893418);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$0$0$2$0(MutableState mutableState) {
        PrintLabelsScreen$lambda$32(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$1(final List list, final boolean z, final MutableState mutableState, final MutableState mutableState2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C309@13199L873,304@12931L1141:PrintLabelsScreen.kt#fixedd");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-205154865, i, -1, "uz.FonRo.pos.ui.print.PrintLabelsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PrintLabelsScreen.kt:304)");
            }
            BasicsKt.m9833OxSoftCardCe4qNIY(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(12.0f), 0.0f, 0.0f, 13, null), Dp.m6989constructorimpl(13.0f), null, Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10184getAmber0d7_KjU(), 0.12f), Ox.INSTANCE.m10242tintBorderl2rxGTc(Ox.INSTANCE.m10184getAmber0d7_KjU()), null, ComposableLambdaKt.rememberComposableLambda(1297251465, true, new Function3() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit PrintLabelsScreen$lambda$52$0$0$1$0;
                    PrintLabelsScreen$lambda$52$0$0$1$0 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$1$0(list, z, mutableState, mutableState2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PrintLabelsScreen$lambda$52$0$0$1$0;
                }
            }, composer, 54), composer, 1572918, 36);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$1$0(List list, final boolean z, MutableState mutableState, final MutableState mutableState2, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C310@13225L75,311@13325L242,315@13592L11,318@13741L185,316@13628L422:PrintLabelsScreen.kt#fixedd");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1297251465, i, -1, "uz.FonRo.pos.ui.print.PrintLabelsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PrintLabelsScreen.kt:310)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Товары без штрихкода: %s", Integer.valueOf(list.size())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), composer, 0, 0, 65534);
            TextKt.m2798Text4IGK_g(LangKt.tx("Каждому присвоим внутренний EAN-13 (начинается на 2 — этот диапазон отведён под коды магазина). Существующие коды не тронем.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer, 6);
            String tx = LangKt.tx("Выдать внутренние коды", new Object[0]);
            boolean z2 = z && !PrintLabelsScreen$lambda$40(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 1118159554, "CC(remember):PrintLabelsScreen.kt#9igjgp");
            boolean changed = composer.changed(z);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PrintLabelsScreen$lambda$52$0$0$1$0$0$0;
                        PrintLabelsScreen$lambda$52$0$0$1$0$0$0 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$1$0$0$0(z, mutableState2);
                        return PrintLabelsScreen$lambda$52$0$0$1$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, null, null, null, z2, true, null, composer, 1572864, 156);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$1$0$0$0(boolean z, MutableState mutableState) {
        if (z) {
            PrintLabelsScreen$lambda$38(mutableState, true);
        } else {
            Toaster.INSTANCE.error(LangKt.tx("Нет права на изменение товаров", new Object[0]));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$2(final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C330@14152L497:PrintLabelsScreen.kt#fixedd");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(58536978, i, -1, "uz.FonRo.pos.ui.print.PrintLabelsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PrintLabelsScreen.kt:330)");
            }
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(12.0f), 0.0f, Dp.m6989constructorimpl(12.0f), 5, null);
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
            ComposerKt.sourceInformationMarkerStart(composer, 904559412, "C331@14235L396,331@14228L403:PrintLabelsScreen.kt#fixedd");
            BasicsKt.OxList(null, ComposableLambdaKt.rememberComposableLambda(1006387703, true, new Function3() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit PrintLabelsScreen$lambda$52$0$0$2$0$0;
                    PrintLabelsScreen$lambda$52$0$0$2$0$0 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$2$0$0(MutableState.this, mutableState2, mutableState3, mutableState4, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PrintLabelsScreen$lambda$52$0$0$2$0$0;
                }
            }, composer, 54), composer, 48, 1);
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
    public static final Unit PrintLabelsScreen$lambda$52$0$0$2$0$0(final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, ColumnScope OxList, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxList, "$this$OxList");
        ComposerKt.sourceInformation(composer, "C332@14304L17,332@14261L60,333@14387L18,333@14346L59,334@14484L19,334@14430L73,335@14591L18,335@14528L81:PrintLabelsScreen.kt#fixedd");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1006387703, i, -1, "uz.FonRo.pos.ui.print.PrintLabelsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PrintLabelsScreen.kt:332)");
            }
            String tx = LangKt.tx("Название товара", new Object[0]);
            boolean PrintLabelsScreen$lambda$19 = PrintLabelsScreen$lambda$19(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 770943208, "CC(remember):PrintLabelsScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PrintLabelsScreen$lambda$52$0$0$2$0$0$0$0;
                        PrintLabelsScreen$lambda$52$0$0$2$0$0$0$0 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$2$0$0$0$0(MutableState.this, ((Boolean) obj).booleanValue());
                        return PrintLabelsScreen$lambda$52$0$0$2$0$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ToggleRow(tx, PrintLabelsScreen$lambda$19, false, (Function1) rememberedValue, composer, 3072, 4);
            String tx2 = LangKt.tx("Цена продажи", new Object[0]);
            boolean PrintLabelsScreen$lambda$22 = PrintLabelsScreen$lambda$22(mutableState2);
            ComposerKt.sourceInformationMarkerStart(composer, 770945865, "CC(remember):PrintLabelsScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PrintLabelsScreen$lambda$52$0$0$2$0$0$1$0;
                        PrintLabelsScreen$lambda$52$0$0$2$0$0$1$0 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$2$0$0$1$0(MutableState.this, ((Boolean) obj).booleanValue());
                        return PrintLabelsScreen$lambda$52$0$0$2$0$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ToggleRow(tx2, PrintLabelsScreen$lambda$22, false, (Function1) rememberedValue2, composer, 3072, 4);
            String tx3 = LangKt.tx("Цифры кода под полосками", new Object[0]);
            boolean PrintLabelsScreen$lambda$25 = PrintLabelsScreen$lambda$25(mutableState3);
            ComposerKt.sourceInformationMarkerStart(composer, 770948970, "CC(remember):PrintLabelsScreen.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PrintLabelsScreen$lambda$52$0$0$2$0$0$2$0;
                        PrintLabelsScreen$lambda$52$0$0$2$0$0$2$0 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$2$0$0$2$0(MutableState.this, ((Boolean) obj).booleanValue());
                        return PrintLabelsScreen$lambda$52$0$0$2$0$0$2$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ToggleRow(tx3, PrintLabelsScreen$lambda$25, false, (Function1) rememberedValue3, composer, 3072, 4);
            String tx4 = LangKt.tx("Название магазина", new Object[0]);
            boolean PrintLabelsScreen$lambda$28 = PrintLabelsScreen$lambda$28(mutableState4);
            ComposerKt.sourceInformationMarkerStart(composer, 770952393, "CC(remember):PrintLabelsScreen.kt#9igjgp");
            Object rememberedValue4 = composer.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PrintLabelsScreen$lambda$52$0$0$2$0$0$3$0;
                        PrintLabelsScreen$lambda$52$0$0$2$0$0$3$0 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$2$0$0$3$0(MutableState.this, ((Boolean) obj).booleanValue());
                        return PrintLabelsScreen$lambda$52$0$0$2$0$0$3$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ToggleRow(tx4, PrintLabelsScreen$lambda$28, false, (Function1) rememberedValue4, composer, 3456, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$2$0$0$0$0(MutableState mutableState, boolean z) {
        PrintLabelsScreen$lambda$20(mutableState, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$2$0$0$1$0(MutableState mutableState, boolean z) {
        PrintLabelsScreen$lambda$23(mutableState, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$2$0$0$2$0(MutableState mutableState, boolean z) {
        PrintLabelsScreen$lambda$26(mutableState, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$2$0$0$3$0(MutableState mutableState, boolean z) {
        PrintLabelsScreen$lambda$29(mutableState, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$3(final MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C343@14795L15,341@14710L256:PrintLabelsScreen.kt#fixedd");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-426408271, i, -1, "uz.FonRo.pos.ui.print.PrintLabelsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PrintLabelsScreen.kt:341)");
            }
            String PrintLabelsScreen$lambda$4 = PrintLabelsScreen$lambda$4(mutableState);
            String tx = LangKt.tx("Поиск товара, кода или артикула", new Object[0]);
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(10.0f), 7, null);
            ComposerKt.sourceInformationMarkerStart(composer, -1756452000, "CC(remember):PrintLabelsScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PrintLabelsScreen$lambda$52$0$0$3$0$0;
                        PrintLabelsScreen$lambda$52$0$0$3$0$0 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$3$0$0(MutableState.this, (String) obj);
                        return PrintLabelsScreen$lambda$52$0$0$3$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.OxSearchBox(PrintLabelsScreen$lambda$4, (Function1) rememberedValue, m1053paddingqDBjuR0$default, tx, null, composer, 432, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$3$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$4(final List list, final int i, final MutableState mutableState, LazyItemScope item, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C350@15038L544,350@15028L554:PrintLabelsScreen.kt#fixedd");
        if (!composer.shouldExecute((i2 & 17) != 16, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-911353520, i2, -1, "uz.FonRo.pos.ui.print.PrintLabelsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PrintLabelsScreen.kt:350)");
            }
            ChipsKt.OxChipRow(null, ComposableLambdaKt.rememberComposableLambda(-2015039521, true, new Function3() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit PrintLabelsScreen$lambda$52$0$0$4$0;
                    PrintLabelsScreen$lambda$52$0$0$4$0 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$4$0(list, i, mutableState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PrintLabelsScreen$lambda$52$0$0$4$0;
                }
            }, composer, 54), composer, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$4$0(List list, int i, final MutableState mutableState, RowScope OxChipRow, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(OxChipRow, "$this$OxChipRow");
        ComposerKt.sourceInformation(composer, "C355@15255L22,351@15060L239,361@15521L21,357@15320L244:PrintLabelsScreen.kt#fixedd");
        if (!composer.shouldExecute((i2 & 17) != 16, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2015039521, i2, -1, "uz.FonRo.pos.ui.print.PrintLabelsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PrintLabelsScreen.kt:351)");
            }
            String tx = LangKt.tx("Все · %s", Integer.valueOf(list.size()));
            boolean z = !PrintLabelsScreen$lambda$10(mutableState);
            ChipTint chipTint = ChipTint.CYAN;
            ComposerKt.sourceInformationMarkerStart(composer, 577277781, "CC(remember):PrintLabelsScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PrintLabelsScreen$lambda$52$0$0$4$0$0$0;
                        PrintLabelsScreen$lambda$52$0$0$4$0$0$0 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$4$0$0$0(MutableState.this);
                        return PrintLabelsScreen$lambda$52$0$0$4$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.m9837OxCatChipFV1VA1c(tx, z, (Function0) rememberedValue, null, chipTint, null, composer, 24960, 40);
            String tx2 = LangKt.tx("Без кода · %s", Integer.valueOf(i));
            boolean PrintLabelsScreen$lambda$10 = PrintLabelsScreen$lambda$10(mutableState);
            ChipTint chipTint2 = ChipTint.CYAN;
            ComposerKt.sourceInformationMarkerStart(composer, 577286292, "CC(remember):PrintLabelsScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PrintLabelsScreen$lambda$52$0$0$4$0$1$0;
                        PrintLabelsScreen$lambda$52$0$0$4$0$1$0 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$4$0$1$0(MutableState.this);
                        return PrintLabelsScreen$lambda$52$0$0$4$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.m9837OxCatChipFV1VA1c(tx2, PrintLabelsScreen$lambda$10, (Function0) rememberedValue2, null, chipTint2, null, composer, 24960, 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$4$0$0$0(MutableState mutableState) {
        PrintLabelsScreen$lambda$11(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$4$0$1$0(MutableState mutableState) {
        PrintLabelsScreen$lambda$11(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$5(final List list, final MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C368@15714L647,368@15704L657:PrintLabelsScreen.kt#fixedd");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1575137864, i, -1, "uz.FonRo.pos.ui.print.PrintLabelsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PrintLabelsScreen.kt:368)");
            }
            ChipsKt.OxChipRow(null, ComposableLambdaKt.rememberComposableLambda(447790471, true, new Function3() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit PrintLabelsScreen$lambda$52$0$0$5$0;
                    PrintLabelsScreen$lambda$52$0$0$5$0 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$5$0(list, mutableState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return PrintLabelsScreen$lambda$52$0$0$5$0;
                }
            }, composer, 54), composer, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$5$0(List list, final MutableState mutableState, RowScope OxChipRow, Composer composer, int i) {
        String str;
        boolean z;
        Intrinsics.checkNotNullParameter(OxChipRow, "$this$OxChipRow");
        ComposerKt.sourceInformation(composer, "C372@15902L21,369@15740L209,*378@16195L21,375@16034L279:PrintLabelsScreen.kt#fixedd");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(447790471, i, -1, "uz.FonRo.pos.ui.print.PrintLabelsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PrintLabelsScreen.kt:369)");
            }
            String tx = LangKt.tx("Все категории", new Object[0]);
            boolean z2 = PrintLabelsScreen$lambda$7(mutableState) == null;
            ComposerKt.sourceInformationMarkerStart(composer, 829919068, "CC(remember):PrintLabelsScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda46
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PrintLabelsScreen$lambda$52$0$0$5$0$0$0;
                        PrintLabelsScreen$lambda$52$0$0$5$0$0$0 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$5$0$0$0(MutableState.this);
                        return PrintLabelsScreen$lambda$52$0$0$5$0$0$0;
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
                Long PrintLabelsScreen$lambda$7 = PrintLabelsScreen$lambda$7(mutableState);
                long id = category.getId();
                if (PrintLabelsScreen$lambda$7 != null && PrintLabelsScreen$lambda$7.longValue() == id) {
                    str = name;
                    z = true;
                } else {
                    str = name;
                    z = false;
                }
                ComposerKt.sourceInformationMarkerStart(composer, 507838655, "CC(remember):PrintLabelsScreen.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(category);
                Object rememberedValue2 = composer.rememberedValue();
                if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda47
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit PrintLabelsScreen$lambda$52$0$0$5$0$1$0$0;
                            PrintLabelsScreen$lambda$52$0$0$5$0$1$0$0 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$5$0$1$0$0(Category.this, mutableState);
                            return PrintLabelsScreen$lambda$52$0$0$5$0$1$0$0;
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
    public static final Unit PrintLabelsScreen$lambda$52$0$0$5$0$0$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$5$0$1$0$0(Category category, MutableState mutableState) {
        mutableState.setValue(Long.valueOf(category.getId()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$6(final List list, final List list2, final MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C391@16659L691,387@16443L925:PrintLabelsScreen.kt#fixedd");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1396298769, i, -1, "uz.FonRo.pos.ui.print.PrintLabelsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PrintLabelsScreen.kt:387)");
            }
            BasicsKt.OxSectionHead(LangKt.tx("Товары", new Object[0]), null, LangKt.tx("Укажите, сколько наклеек напечатать", new Object[0]), String.valueOf(list.size()), null, ComposableLambdaKt.rememberComposableLambda(-403826173, true, new Function2() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PrintLabelsScreen$lambda$52$0$0$6$0;
                    PrintLabelsScreen$lambda$52$0$0$6$0 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$6$0(list2, list, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                    return PrintLabelsScreen$lambda$52$0$0$6$0;
                }
            }, composer, 54), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$6$0(final List list, final List list2, final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C394@16826L368,392@16685L643:PrintLabelsScreen.kt#fixedd");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-403826173, i, -1, "uz.FonRo.pos.ui.print.PrintLabelsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PrintLabelsScreen.kt:392)");
            }
            String tx = list.isEmpty() ? LangKt.tx("По одной", new Object[0]) : LangKt.tx("Очистить", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -1529889901, "CC(remember):PrintLabelsScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(list) | composer.changedInstance(list2);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PrintLabelsScreen$lambda$52$0$0$6$0$0$0;
                        PrintLabelsScreen$lambda$52$0$0$6$0$0$0 = PrintLabelsScreenKt.PrintLabelsScreen$lambda$52$0$0$6$0$0$0(list, list2, mutableState);
                        return PrintLabelsScreen$lambda$52$0$0$6$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, null, null, BtnSize.SM, true ^ list2.isEmpty(), false, null, composer, 24576, 204);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$6$0$0$0(List list, List list2, MutableState mutableState) {
        LinkedHashMap emptyMap;
        if (!list.isEmpty()) {
            emptyMap = MapsKt.emptyMap();
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator it = list2.iterator();
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                String barcode = ((Product) next).getBarcode();
                if (barcode != null && !StringsKt.isBlank(barcode)) {
                    z = false;
                }
                if (!z) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = arrayList;
            emptyMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Pair pair = TuplesKt.to(Long.valueOf(((Product) it2.next()).getId()), 1);
                emptyMap.put(pair.getFirst(), pair.getSecond());
            }
        }
        mutableState.setValue(emptyMap);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$7(List list, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C411@17477L177:PrintLabelsScreen.kt#fixedd");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2060083113, i, -1, "uz.FonRo.pos.ui.print.PrintLabelsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PrintLabelsScreen.kt:411)");
            }
            BasicsKt.OxEmptyNote(list.isEmpty() ? LangKt.tx("Каталог пуст — сначала добавьте товары.", new Object[0]) : LangKt.tx("Ничего не найдено", new Object[0]), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object PrintLabelsScreen$lambda$52$0$0$8(Product it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$10(List list, List list2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C429@18321L313:PrintLabelsScreen.kt#fixedd");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-913953741, i, -1, "uz.FonRo.pos.ui.print.PrintLabelsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PrintLabelsScreen.kt:429)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Показаны первые %s из %s — уточните поиск.", Integer.valueOf(list.size()), Integer.valueOf(list2.size())), PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(10.0f), 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6873getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), composer, 48, 0, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$0$0$11(List list, MutableState mutableState, String str, String str2, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, LazyItemScope item, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer2, "C439@18736L2128:PrintLabelsScreen.kt#fixedd");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1881244018, i, -1, "uz.FonRo.pos.ui.print.PrintLabelsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PrintLabelsScreen.kt:439)");
            }
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(16.0f), 0.0f, 0.0f, 13, null);
            ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
            int i2 = -1323940314;
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m1053paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(composer2, 1673926313, "C440@18796L350:PrintLabelsScreen.kt#fixedd");
            BasicsKt.OxSectionHead(LangKt.tx("Как будет выглядеть", new Object[0]), null, PrintLabelsScreen$lambda$16(mutableState).getKind() == SheetKind.A4 ? PrintLabelsScreen$lambda$16(mutableState).getSubtitle() : PrintLabelsScreen$lambda$16(mutableState).getTitle(), null, null, null, composer2, 0, 58);
            Object obj = null;
            if (list.isEmpty()) {
                composer2.startReplaceGroup(1674256338);
                ComposerKt.sourceInformation(composer2, "447@19215L72");
                BasicsKt.OxEmptyNote(LangKt.tx("Укажите количество — здесь появится образец наклейки.", new Object[0]), null, composer2, 0, 2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(1674425071);
                ComposerKt.sourceInformation(composer2, "449@19341L1083");
                Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
                ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer2, 6);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                String str3 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str3);
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
                Updater.m3815setimpl(m3808constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 788457180, "C:PrintLabelsScreen.kt#fixedd");
                composer2.startReplaceGroup(579624237);
                ComposerKt.sourceInformation(composer2, "*451@19505L863");
                for (List list2 : CollectionsKt.chunked(CollectionsKt.take(list, 6), 2)) {
                    Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
                    ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), composer2, 6);
                    ComposerKt.sourceInformationMarkerStart(composer2, i2, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, companion2);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str3);
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
                    Updater.m3815setimpl(m3808constructorimpl3, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1802466976, "C:PrintLabelsScreen.kt#fixedd");
                    composer2.startReplaceGroup(-1027975347);
                    ComposerKt.sourceInformation(composer2, "*453@19666L549");
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        Composer composer3 = composer2;
                        LabelPreview((Product) it.next(), PrintLabelsScreen$lambda$28(mutableState2) ? str : "", PrintLabelsScreen$lambda$19(mutableState3), PrintLabelsScreen$lambda$22(mutableState4), PrintLabelsScreen$lambda$25(mutableState5), str2, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer3, Product.$stable, 0);
                        composer2 = composer3;
                        obj = obj;
                        str3 = str3;
                    }
                    Object obj2 = obj;
                    String str4 = str3;
                    composer2.endReplaceGroup();
                    if (list2.size() == 1) {
                        composer2.startReplaceGroup(-1027953411);
                        ComposerKt.sourceInformation(composer2, "463@20310L24");
                        BoxKt.Box(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer2, 0);
                    } else {
                        composer2.startReplaceGroup(-1801761603);
                    }
                    composer2.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    obj = obj2;
                    str3 = str4;
                    i2 = -1323940314;
                }
                Object obj3 = obj;
                composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (list.size() > 6) {
                    composer2.startReplaceGroup(1675534344);
                    ComposerKt.sourceInformation(composer2, "468@20500L10,469@20539L259");
                    BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer2, 6);
                    TextKt.m2798Text4IGK_g(LangKt.tx("…и ещё %s", Integer.valueOf(list.size() - 6)), SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, obj3), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6873getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), composer, 48, 0, 65532);
                    composer2 = composer;
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(1675874538);
                    composer2.endReplaceGroup();
                }
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$52$1$1$0(List list, CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, String str, String str2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, Context context, FonRoApp FonRoApp, MutableState mutableState7) {
        PrintLabelsScreen$print(list, coroutineScope, mutableState, mutableState2, str, str2, mutableState3, mutableState4, mutableState5, mutableState6, context, FonRoApp, mutableState7);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$53$0(MutableState mutableState, MutableState mutableState2, LabelLayout it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        PrintLabelsScreen$lambda$32(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$54$0(MutableState mutableState) {
        PrintLabelsScreen$lambda$32(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$55$0$0(Product product, MutableState mutableState, double d) {
        PrintLabelsScreen$setCopies(mutableState, product.getId(), (int) d);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$55$1$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$56$0(MutableState mutableState, List list, CoroutineScope coroutineScope, MutableState mutableState2, List list2, Repo repo) {
        PrintLabelsScreen$lambda$38(mutableState, false);
        PrintLabelsScreen$issueCodes(list, coroutineScope, mutableState2, list2, repo);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrintLabelsScreen$lambda$57$0(MutableState mutableState) {
        PrintLabelsScreen$lambda$38(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void ToggleRow(final java.lang.String r18, final boolean r19, boolean r20, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.print.PrintLabelsScreenKt.ToggleRow(java.lang.String, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToggleRow$lambda$0$0(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ToggleRow$lambda$1(boolean z, Function1 function1, RowScope OxRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxRow, "$this$OxRow");
        ComposerKt.sourceInformation(composer, "C549@23147L53:PrintLabelsScreen.kt#fixedd");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(93559028, i, -1, "uz.FonRo.pos.ui.print.ToggleRow.<anonymous> (PrintLabelsScreen.kt:549)");
            }
            SwitchKt.Switch(z, function1, null, null, false, null, null, composer, 0, 124);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void Tile(final java.lang.String r17, final java.lang.String r18, androidx.compose.ui.Modifier r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            r1 = r17
            r2 = r18
            r4 = r21
            r0 = 2021478728(0x787d5148, float:2.0551558E34)
            r3 = r20
            androidx.compose.runtime.Composer r14 = r3.startRestartGroup(r0)
            java.lang.String r3 = "C(Tile)P(!1,2)555@23356L121,555@23308L169:PrintLabelsScreen.kt#fixedd"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r3)
            r3 = r4 & 6
            if (r3 != 0) goto L23
            boolean r3 = r14.changed(r1)
            if (r3 == 0) goto L20
            r3 = 4
            goto L21
        L20:
            r3 = 2
        L21:
            r3 = r3 | r4
            goto L24
        L23:
            r3 = r4
        L24:
            r5 = r4 & 48
            if (r5 != 0) goto L34
            boolean r5 = r14.changed(r2)
            if (r5 == 0) goto L31
            r5 = 32
            goto L33
        L31:
            r5 = 16
        L33:
            r3 = r3 | r5
        L34:
            r5 = r22 & 4
            if (r5 == 0) goto L3b
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L4e
        L3b:
            r6 = r4 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L4e
            r6 = r19
            boolean r7 = r14.changed(r6)
            if (r7 == 0) goto L4a
            r7 = 256(0x100, float:3.59E-43)
            goto L4c
        L4a:
            r7 = 128(0x80, float:1.794E-43)
        L4c:
            r3 = r3 | r7
            goto L50
        L4e:
            r6 = r19
        L50:
            r7 = r3 & 147(0x93, float:2.06E-43)
            r8 = 146(0x92, float:2.05E-43)
            r9 = 1
            if (r7 == r8) goto L59
            r7 = r9
            goto L5a
        L59:
            r7 = 0
        L5a:
            r8 = r3 & 1
            boolean r7 = r14.shouldExecute(r7, r8)
            if (r7 == 0) goto Lac
            if (r5 == 0) goto L69
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.INSTANCE
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            goto L6a
        L69:
            r5 = r6
        L6a:
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L76
            r6 = -1
            java.lang.String r7 = "uz.FonRo.pos.ui.print.Tile (PrintLabelsScreen.kt:554)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r6, r7)
        L76:
            r0 = 1091567616(0x41100000, float:9.0)
            float r6 = androidx.compose.ui.unit.Dp.m6989constructorimpl(r0)
            uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda31 r0 = new uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda31
            r0.<init>()
            r7 = 54
            r8 = 1472582990(0x57c5d54e, float:4.35039855E14)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r8, r9, r0, r14, r7)
            r13 = r0
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            int r0 = r3 >> 6
            r0 = r0 & 14
            r3 = 1572912(0x180030, float:2.204119E-39)
            r15 = r0 | r3
            r16 = 60
            r7 = 0
            r8 = 0
            r10 = 0
            r12 = 0
            uz.FonRo.pos.ui.components.BasicsKt.m9833OxSoftCardCe4qNIY(r5, r6, r7, r8, r10, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto Laa
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        Laa:
            r3 = r5
            goto Lb0
        Lac:
            r14.skipToGroupEnd()
            r3 = r6
        Lb0:
            androidx.compose.runtime.ScopeUpdateScope r6 = r14.endRestartGroup()
            if (r6 == 0) goto Lc0
            uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda32 r0 = new uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda32
            r5 = r22
            r0.<init>()
            r6.updateScope(r0)
        Lc0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.print.PrintLabelsScreenKt.Tile(java.lang.String, java.lang.String, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Tile$lambda$0(String str, String str2, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C556@23366L37,557@23412L59:PrintLabelsScreen.kt#fixedd");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1472582990, i, -1, "uz.FonRo.pos.ui.print.Tile.<anonymous> (PrintLabelsScreen.kt:556)");
            }
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getTileValue(), composer, 0, 0, 65534);
            TextKt.m2798Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getTileLabel(), Ox.INSTANCE.m10200getDim20d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProductCopiesRow(final Product product, final int i, final String str, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, Composer composer, final int i2) {
        int i3;
        Function0<Unit> function04;
        String str2;
        Composer startRestartGroup = composer.startRestartGroup(34225750);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProductCopiesRow)P(5!2,3,4)575@23856L1354:PrintLabelsScreen.kt#fixedd");
        if ((i2 & 6) == 0) {
            i3 = ((i2 & 8) == 0 ? startRestartGroup.changed(product) : startRestartGroup.changedInstance(product) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= startRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(function02) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            function04 = function03;
            i3 |= startRestartGroup.changedInstance(function04) ? 131072 : 65536;
        } else {
            function04 = function03;
        }
        if (!startRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(34225750, i3, -1, "uz.FonRo.pos.ui.print.ProductCopiesRow (PrintLabelsScreen.kt:570)");
            }
            String barcode = product.getBarcode();
            if (barcode == null) {
                barcode = "";
            }
            String obj = StringsKt.trim((CharSequence) barcode).toString();
            BarcodeKind kindOf = Barcodes.INSTANCE.kindOf(obj);
            boolean z = i > 0 && obj.length() > 0;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i4 = i3;
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1613499875, "C576@23898L1286,608@25193L11:PrintLabelsScreen.kt#fixedd");
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(9.0f), 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -815070023, "C581@24124L733:PrintLabelsScreen.kt#fixedd");
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -748071076, "C582@24170L239,588@24426L417:PrintLabelsScreen.kt#fixedd");
            boolean z2 = z;
            String name = product.getName();
            TextStyle rowTitle = OxType.INSTANCE.getRowTitle();
            Ox ox = Ox.INSTANCE;
            TextKt.m2798Text4IGK_g(name, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(rowTitle, z2 ? ox.m10220getPrimary0d7_KjU() : ox.m10233getText0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), startRestartGroup, 0, 3120, 55294);
            String str3 = obj;
            if (str3.length() == 0) {
                str2 = LangKt.tx("Кода нет · %s %s", Fmt.INSTANCE.qf(Double.valueOf(product.getQuantity())), Units.INSTANCE.name(product.getUnit()));
            } else {
                str2 = obj + " · " + kindOf.getTitle() + " · " + Fmt.INSTANCE.money(Double.valueOf(product.getSalePrice()), str);
            }
            TextKt.m2798Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowSub(), str3.length() == 0 ? Ox.INSTANCE.m10184getAmber0d7_KjU() : Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), startRestartGroup, 0, 3120, 55294);
            startRestartGroup = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (str3.length() == 0) {
                startRestartGroup.startReplaceGroup(-814339571);
                ComposerKt.sourceInformation(startRestartGroup, "598@24909L37");
                BasicsKt.OxChip(LangKt.tx("нет кода", new Object[0]), ChipTone.WARN, null, startRestartGroup, 48, 4);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-814260862);
                ComposerKt.sourceInformation(startRestartGroup, "600@24984L176");
                int i5 = i4 >> 6;
                Stepper(i, function0, function02, function04, startRestartGroup, ((i4 >> 3) & 14) | (i5 & 112) | (i5 & 896) | (i5 & 7168));
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return PrintLabelsScreenKt.ProductCopiesRow$lambda$1(Product.this, i, str, function0, function02, function03, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final void Stepper(final int i, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, Composer composer, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1814968147);
        ComposerKt.sourceInformation(startRestartGroup, "C(Stepper)P(3,1,2)614@25326L761:PrintLabelsScreen.kt#fixedd");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function03) ? 2048 : 1024;
        }
        if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1814968147, i3, -1, "uz.FonRo.pos.ui.print.Stepper (PrintLabelsScreen.kt:613)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(6.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, startRestartGroup, 54);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1311499339, "C615@25440L55,621@25708L24,616@25504L519,630@26032L49:PrintLabelsScreen.kt#fixedd");
            StepButton("−", i > 0, function0, startRestartGroup, ((i3 << 3) & 896) | 6);
            Modifier clip = ClipKt.clip(SizeKt.m1084heightInVpY3zN4$default(Modifier.INSTANCE, Dp.m6989constructorimpl(34.0f), 0.0f, 2, null), OxShape.INSTANCE.getField());
            Ox ox = Ox.INSTANCE;
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(ModifiersKt.oxTap(BackgroundKt.m558backgroundbw27NRU$default(clip, i > 0 ? ox.m10222getPrimarySoft0d7_KjU() : ox.m10218getPanel20d7_KjU(), null, 2, null), false, function03, startRestartGroup, (i3 >> 3) & 896, 1), Dp.m6989constructorimpl(12.0f), Dp.m6989constructorimpl(6.0f));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m1050paddingVpY3zN4);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -46681611, "C625@25868L145:PrintLabelsScreen.kt#fixedd");
            String valueOf = String.valueOf(i);
            TextStyle rowTitle = OxType.INSTANCE.getRowTitle();
            Ox ox2 = Ox.INSTANCE;
            TextKt.m2798Text4IGK_g(valueOf, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(rowTitle, i > 0 ? ox2.m10220getPrimary0d7_KjU() : ox2.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), startRestartGroup, 0, 0, 65534);
            startRestartGroup = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            StepButton("+", true, function02, startRestartGroup, (i3 & 896) | 54);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PrintLabelsScreenKt.Stepper$lambda$1(i, function0, function02, function03, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void StepButton(final String str, final boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-166322918);
        ComposerKt.sourceInformation(startRestartGroup, "C(StepButton)P(2)642@26376L43,636@26185L385:PrintLabelsScreen.kt#fixedd");
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
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-166322918, i3, -1, "uz.FonRo.pos.ui.print.StepButton (PrintLabelsScreen.kt:635)");
            }
            Modifier oxTap = ModifiersKt.oxTap(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(34.0f)), OxShape.INSTANCE.getField()), Ox.INSTANCE.m10218getPanel20d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getField()), z, function0, startRestartGroup, i3 & PointerIconCompat.TYPE_TEXT, 0);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, oxTap);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -365950800, "C645@26481L83:PrintLabelsScreen.kt#fixedd");
            TextStyle rowTitle = OxType.INSTANCE.getRowTitle();
            Ox ox = Ox.INSTANCE;
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(rowTitle, z ? ox.m10233getText0d7_KjU() : ox.m10200getDim20d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), startRestartGroup, i3 & 14, 0, 65534);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PrintLabelsScreenKt.StepButton$lambda$1(str, z, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void SizeSheet(final LabelLayout labelLayout, final Function1<? super LabelLayout, Unit> function1, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1341241892);
        ComposerKt.sourceInformation(startRestartGroup, "C(SizeSheet)P(!1,2)652@26836L907,652@26770L973:PrintLabelsScreen.kt#fixedd");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(labelLayout) : startRestartGroup.changedInstance(labelLayout) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1341241892, i2, -1, "uz.FonRo.pos.ui.print.SizeSheet (PrintLabelsScreen.kt:651)");
            }
            SheetsKt.OxCardSheet(LangKt.tx("Размер наклейки", new Object[0]), function0, null, false, false, false, null, ComposableLambdaKt.rememberComposableLambda(-1757571448, true, new Function3() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PrintLabelsScreenKt.SizeSheet$lambda$0(LabelLayout.this, function1, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 >> 3) & 112) | 12582912, 124);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PrintLabelsScreenKt.SizeSheet$lambda$1(LabelLayout.this, function1, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SizeSheet$lambda$0(final LabelLayout labelLayout, final Function1 function1, ColumnScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C653@26877L21,653@26846L891:PrintLabelsScreen.kt#fixedd");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1757571448, i, -1, "uz.FonRo.pos.ui.print.SizeSheet.<anonymous> (PrintLabelsScreen.kt:653)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1776751365, "C654@26915L256,659@27184L37,660@27241L183,660@27234L190,665@27437L11,666@27461L34,667@27515L189,667@27508L196,672@27717L10:PrintLabelsScreen.kt#fixedd");
            TextKt.m2798Text4IGK_g(LangKt.tx("Листы A4 — обычная самоклейка из канцелярского магазина. Остальные размеры — для этикеточного принтера с рулоном.", new Object[0]), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(10.0f), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 48, 0, 65532);
            BasicsKt.OxSectionHead(LangKt.tx("Листы A4", new Object[0]), null, null, null, null, null, composer, 0, 62);
            BasicsKt.OxList(null, ComposableLambdaKt.rememberComposableLambda(1313491629, true, new Function3() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SizeSheet$lambda$0$0$0;
                    SizeSheet$lambda$0$0$0 = PrintLabelsScreenKt.SizeSheet$lambda$0$0$0(LabelLayout.this, function1, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SizeSheet$lambda$0$0$0;
                }
            }, composer, 54), composer, 48, 1);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            BasicsKt.OxSectionHead(LangKt.tx("Рулон", new Object[0]), null, null, null, null, null, composer, 0, 62);
            BasicsKt.OxList(null, ComposableLambdaKt.rememberComposableLambda(-1042274090, true, new Function3() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SizeSheet$lambda$0$0$1;
                    SizeSheet$lambda$0$0$1 = PrintLabelsScreenKt.SizeSheet$lambda$0$0$1(LabelLayout.this, function1, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SizeSheet$lambda$0$0$1;
                }
            }, composer, 54), composer, 48, 1);
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
    public static final Unit SizeSheet$lambda$0$0$0(LabelLayout labelLayout, Function1 function1, ColumnScope OxList, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxList, "$this$OxList");
        ComposerKt.sourceInformation(composer, "C*662@27327L65:PrintLabelsScreen.kt#fixedd");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1313491629, i, -1, "uz.FonRo.pos.ui.print.SizeSheet.<anonymous>.<anonymous>.<anonymous> (PrintLabelsScreen.kt:661)");
            }
            int i2 = 0;
            for (Object obj : LabelLayouts.INSTANCE.getA4()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SizeRow((LabelLayout) obj, labelLayout, i2 < CollectionsKt.getLastIndex(LabelLayouts.INSTANCE.getA4()), function1, composer, LabelLayout.$stable | (LabelLayout.$stable << 3));
                i2 = i3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SizeSheet$lambda$0$0$1(LabelLayout labelLayout, Function1 function1, ColumnScope OxList, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxList, "$this$OxList");
        ComposerKt.sourceInformation(composer, "C*669@27604L68:PrintLabelsScreen.kt#fixedd");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1042274090, i, -1, "uz.FonRo.pos.ui.print.SizeSheet.<anonymous>.<anonymous>.<anonymous> (PrintLabelsScreen.kt:668)");
            }
            int i2 = 0;
            for (Object obj : LabelLayouts.INSTANCE.getRolls()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SizeRow((LabelLayout) obj, labelLayout, i2 < CollectionsKt.getLastIndex(LabelLayouts.INSTANCE.getRolls()), function1, composer, LabelLayout.$stable | (LabelLayout.$stable << 3));
                i2 = i3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void SizeRow(final LabelLayout labelLayout, final LabelLayout labelLayout2, final boolean z, final Function1<? super LabelLayout, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1733485921);
        ComposerKt.sourceInformation(startRestartGroup, "C(SizeRow)P(2)689@28044L16,691@28135L71,685@27930L282:PrintLabelsScreen.kt#fixedd");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(labelLayout) : startRestartGroup.changedInstance(labelLayout) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(labelLayout2) : startRestartGroup.changedInstance(labelLayout2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if (!startRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1733485921, i2, -1, "uz.FonRo.pos.ui.print.SizeRow (PrintLabelsScreen.kt:683)");
            }
            final boolean areEqual = Intrinsics.areEqual(labelLayout.getKey(), labelLayout2.getKey());
            String title = labelLayout.getTitle();
            String subtitle = labelLayout.getSubtitle();
            Ox ox = Ox.INSTANCE;
            long m10220getPrimary0d7_KjU = areEqual ? ox.m10220getPrimary0d7_KjU() : ox.m10233getText0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -567331887, "CC(remember):PrintLabelsScreen.kt#9igjgp");
            boolean z2 = ((i2 & 7168) == 2048) | ((i2 & 14) == 4 || ((i2 & 8) != 0 && startRestartGroup.changedInstance(labelLayout)));
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SizeRow$lambda$0$0;
                        SizeRow$lambda$0$0 = PrintLabelsScreenKt.SizeRow$lambda$0$0(Function1.this, labelLayout);
                        return SizeRow$lambda$0$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            BasicsKt.m9832OxRow1YH7lEI(title, null, subtitle, (Function0) rememberedValue, z, m10220getPrimary0d7_KjU, null, ComposableLambdaKt.rememberComposableLambda(-329123496, true, new Function3() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda33
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PrintLabelsScreenKt.SizeRow$lambda$1(areEqual, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 << 6) & 57344) | 12582912, 66);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.print.PrintLabelsScreenKt$$ExternalSyntheticLambda44
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PrintLabelsScreenKt.SizeRow$lambda$2(LabelLayout.this, labelLayout2, z, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SizeRow$lambda$0$0(Function1 function1, LabelLayout labelLayout) {
        function1.invoke(labelLayout);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SizeRow$lambda$1(boolean z, RowScope OxRow, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(OxRow, "$this$OxRow");
        ComposerKt.sourceInformation(composer2, "C:PrintLabelsScreen.kt#fixedd");
        if (composer2.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-329123496, i, -1, "uz.FonRo.pos.ui.print.SizeRow.<anonymous> (PrintLabelsScreen.kt:691)");
            }
            if (z) {
                composer2.startReplaceGroup(1539900627);
                ComposerKt.sourceInformation(composer2, "691@28145L59");
                TextKt.m2798Text4IGK_g("✓", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowPrice(), Ox.INSTANCE.m10220getPrimary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 6, 0, 65534);
                composer2 = composer;
            } else {
                composer2.startReplaceGroup(492335882);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void LabelPreview(final uz.FonRo.pos.data.model.Product r22, final java.lang.String r23, final boolean r24, final boolean r25, final boolean r26, final java.lang.String r27, androidx.compose.ui.Modifier r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.print.PrintLabelsScreenKt.LabelPreview(uz.FonRo.pos.data.model.Product, java.lang.String, boolean, boolean, boolean, java.lang.String, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LabelPreview$lambda$1(String str, boolean z, Product product, boolean z2, String str2, boolean z3, String str3, Bitmap bitmap, ColumnScope OxSoftCard, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer2, "C734@29486L10,735@29505L642:PrintLabelsScreen.kt#fixedd");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1438530087, i, -1, "uz.FonRo.pos.ui.print.LabelPreview.<anonymous> (PrintLabelsScreen.kt:716)");
            }
            if (str.length() > 0) {
                composer2.startReplaceGroup(-66082931);
                ComposerKt.sourceInformation(composer2, "717@28912L252");
                TextKt.m2798Text4IGK_g(str, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6873getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), composer, 48, 3120, 55292);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-65830839);
                composer2.endReplaceGroup();
            }
            if (z) {
                composer2.startReplaceGroup(-65786199);
                ComposerKt.sourceInformation(composer2, "726@29211L256");
                TextKt.m2798Text4IGK_g(product.getName(), SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowTitle(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6873getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), composer, 48, 3120, 55292);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-65530263);
                composer2.endReplaceGroup();
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(7.0f), composer2, 6);
            Modifier m1084heightInVpY3zN4$default = SizeKt.m1084heightInVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6989constructorimpl(46.0f), 0.0f, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m1084heightInVpY3zN4$default);
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
            Updater.m3815setimpl(m3808constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1708386881, "C:PrintLabelsScreen.kt#fixedd");
            if (bitmap != null) {
                composer2.startReplaceGroup(-1708374854);
                ComposerKt.sourceInformation(composer2, "740@29690L201");
                ImageKt.m615Image5hnEew(AndroidImageBitmap_androidKt.asImageBitmap(bitmap), null, SizeKt.m1084heightInVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6989constructorimpl(46.0f), 0.0f, 2, null), null, null, 0.0f, null, 0, composer, 432, 248);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1708121119);
                ComposerKt.sourceInformation(composer2, "746@29929L194");
                IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getQrCode(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(40.0f)), Ox.INSTANCE.m10200getDim20d7_KjU(), composer2, 432, 0);
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (z2 && str2.length() > 0) {
                composer2.startReplaceGroup(-64807994);
                ComposerKt.sourceInformation(composer2, "755@30207L10,756@30230L340");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(4.0f), composer2, 6);
                TextKt.m2798Text4IGK_g(str2, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), 0L, 0L, null, null, null, FontFamily.INSTANCE.getMonospace(), null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6873getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744415, null), composer, 48, 3120, 55292);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-64436087);
                composer2.endReplaceGroup();
            }
            if (z3) {
                composer2.startReplaceGroup(-64391199);
                ComposerKt.sourceInformation(composer2, "768@30618L232");
                TextKt.m2798Text4IGK_g(Fmt.INSTANCE.money(Double.valueOf(product.getSalePrice()), str3), SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowPrice(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6873getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), composer, 48, 3072, 57340);
                composer.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-64158327);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final List<Product> PrintLabelsScreen$lambda$0(State<? extends List<Product>> state) {
        return state.getValue();
    }

    private static final List<Category> PrintLabelsScreen$lambda$1(State<? extends List<Category>> state) {
        return state.getValue();
    }

    private static final Store PrintLabelsScreen$lambda$2(State<Store> state) {
        return state.getValue();
    }
}
