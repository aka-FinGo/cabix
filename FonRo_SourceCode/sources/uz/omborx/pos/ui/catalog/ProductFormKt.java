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
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import coil.disk.DiskLruCache;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.core.Units;
import uz.FonRo.pos.data.model.Category;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnSize;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.ChipTint;
import uz.FonRo.pos.ui.components.ChipsKt;
import uz.FonRo.pos.ui.components.FieldsKt;
import uz.FonRo.pos.ui.components.ModifiersKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: ProductForm.kt */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\tH\u0007b\u0002\b\u000bb\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u0002\u0010\n\u001a\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000\u001a \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0000\u001a\b\u0010\u0017\u001a\u00020\u0012H\u0000\u001a\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0002\u001aM\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000b¢\u0006\u0002\b\u001fH\u0003b\u0002\b\u000bb\f\b!\u0012\b\b\"\u0012\u0004\b\b(#¢\u0006\u0002\u0010 \u001a'\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0012H\u0003b\u0002\b\u000bb\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u0002\u0010&\u001a'\u0010'\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0012H\u0003b\u0002\b\u000bb\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u0002\u0010&\u001a=\u0010(\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003b\u0002\b\u000bb\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u0002\u0010,\u001a5\u0010-\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u00122\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003b\u0002\b\u000bb\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u0002\u0010/\u001aG\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u0002052\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003b\u0002\b\u000bb\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u0004\b6\u00107\u001a9\u00108\u001a\u00020\u00012\u0006\u00109\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00122\u0006\u0010:\u001a\u000205H\u0003b\u0002\b\u000bb\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u0004\b;\u0010<¨\u0006\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010=\u001a\u00020*X\u008a\u008e\u0002²\u0006\n\u0010>\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\u0010\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00120@X\u008a\u008e\u0002²\u0006\n\u0010A\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010B\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010C\u001a\u00020DX\u008a\u008e\u0002²\u0006\n\u0010E\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010F\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010G\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010H\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010I\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010J\u001a\u00020*X\u008a\u008e\u0002²\u0006\n\u0010K\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010L\u001a\u00020*X\u008a\u008e\u0002²\u0006\f\u0010M\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002²\u0006\n\u0010N\u001a\u00020*X\u008a\u008e\u0002²\u0006\n\u0010O\u001a\u00020*X\u008a\u008e\u0002"}, d2 = {"ProductFormSheet", "", "app", "Luz/FonRo/pos/FonRoApp;", "product", "Luz/FonRo/pos/data/model/Product;", "onDismiss", "Lkotlin/Function0;", "onSaved", "Lkotlin/Function1;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/data/model/Product;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "variantParse", "Luz/FonRo/pos/ui/catalog/ProductVariant;", "name", "", "variantCompose", "base", "opt1", "opt2", "newBarcode", "numText", "raw", "PfCard", "number", "title", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/ComposableInferredTarget;", "scheme", "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]", "PfLabel", "text", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "PfHint", "PfToggle", "open", "", "onClick", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "PfPicker", "value", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "PfSquareButton", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "description", "tint", "Landroidx/compose/ui/graphics/Color;", "PfSquareButton-FNF3uiM", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;JLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "MoneyLine", "label", "valueColor", "MoneyLine-XO-JAsU", "(Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/runtime/Composer;I)V", "variantOpen", OptionalModuleUtils.BARCODE, "aliases", "", "aliasDraft", "sku", "categoryId", "", "unit", "step", "qtyText", "purchaseText", "saleText", "advancedOpen", "errorText", "saving", "scanTarget", "pickerOpen", "newCategoryOpen"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ProductFormKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MoneyLine_XO_JAsU$lambda$1(String str, String str2, long j, int i, Composer composer, int i2) {
        m9815MoneyLineXOJAsU(str, str2, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PfCard$lambda$1(String str, String str2, Function3 function3, int i, Composer composer, int i2) {
        PfCard(str, str2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PfHint$lambda$0(String str, int i, Composer composer, int i2) {
        PfHint(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PfLabel$lambda$0(String str, int i, Composer composer, int i2) {
        PfLabel(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PfPicker$lambda$1(String str, Function0 function0, int i, Composer composer, int i2) {
        PfPicker(str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PfSquareButton_FNF3uiM$lambda$1(ImageVector imageVector, String str, long j, Function0 function0, int i, Composer composer, int i2) {
        m9816PfSquareButtonFNF3uiM(imageVector, str, j, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PfToggle$lambda$1(String str, boolean z, Function0 function0, int i, Composer composer, int i2) {
        PfToggle(str, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ProductFormSheet$lambda$70(FonRoApp FonRoApp, Product product, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        ProductFormSheet(FonRoApp, product, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:0x02eb, code lost:
    
        if (r0 == null) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01f7, code lost:
    
        if (r1 == null) goto L104;
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0341  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ProductFormSheet(final uz.FonRo.pos.FonRoApp r54, final uz.FonRo.pos.data.model.Product r55, final kotlin.jvm.functions.Function0<kotlin.Unit> r56, final kotlin.jvm.functions.Function1<? super uz.FonRo.pos.data.model.Product, kotlin.Unit> r57, androidx.compose.runtime.Composer r58, final int r59) {
        /*
            Method dump skipped, instructions count: 1866
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.catalog.ProductFormKt.ProductFormSheet(uz.FonRo.pos.FonRoApp, uz.FonRo.pos.data.model.Product, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    private static final String ProductFormSheet$lambda$2(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String ProductFormSheet$lambda$5(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String ProductFormSheet$lambda$8(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ProductFormSheet$lambda$11(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ProductFormSheet$lambda$12(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProductFormSheet$lambda$14(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<String> ProductFormSheet$lambda$17(MutableState<List<String>> mutableState) {
        return mutableState.getValue();
    }

    private static final String ProductFormSheet$lambda$20(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProductFormSheet$lambda$23(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long ProductFormSheet$lambda$26(MutableState<Long> mutableState) {
        return mutableState.getValue().longValue();
    }

    private static final void ProductFormSheet$lambda$27(MutableState<Long> mutableState, long j) {
        mutableState.setValue(Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProductFormSheet$lambda$29(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String ProductFormSheet$lambda$32(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String ProductFormSheet$lambda$35(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String ProductFormSheet$lambda$38(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String ProductFormSheet$lambda$41(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ProductFormSheet$lambda$44(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ProductFormSheet$lambda$45(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String ProductFormSheet$lambda$47(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ProductFormSheet$lambda$50(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProductFormSheet$lambda$51(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String ProductFormSheet$lambda$53(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ProductFormSheet$lambda$56(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ProductFormSheet$lambda$57(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean ProductFormSheet$lambda$59(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ProductFormSheet$lambda$60(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean ProductFormSheet$addAlias(Repo repo, MutableState<String> mutableState, MutableState<List<String>> mutableState2, Product product, String str) {
        Object obj;
        String obj2 = StringsKt.trim((CharSequence) str).toString();
        if (obj2.length() == 0) {
            Toaster.INSTANCE.error(LangKt.tx("Введите штрихкод", new Object[0]));
            return false;
        }
        if (Intrinsics.areEqual(obj2, StringsKt.trim((CharSequence) ProductFormSheet$lambda$14(mutableState)).toString()) || ProductFormSheet$lambda$17(mutableState2).contains(obj2)) {
            Toaster.INSTANCE.error(LangKt.tx("Такой код уже есть", new Object[0]));
            return false;
        }
        Iterator<T> it = repo.getProducts().getValue().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Product product2 = (Product) obj;
            if (product2.getId() != (product != null ? product.getId() : 0L) && product2.hasBarcode(obj2)) {
                break;
            }
        }
        Product product3 = (Product) obj;
        if (product3 != null) {
            Toaster.INSTANCE.error(LangKt.tx("Этот код уже у товара «%s»", product3.getName()));
            return false;
        }
        mutableState2.setValue(CollectionsKt.plus((Collection<? extends String>) ProductFormSheet$lambda$17(mutableState2), obj2));
        return true;
    }

    private static final void ProductFormSheet$save(boolean z, boolean z2, double d, double d2, CoroutineScope coroutineScope, MutableState<Boolean> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4, MutableState<String> mutableState5, Product product, Repo repo, double d3, boolean z3, double d4, Function1<? super Product, Unit> function1, Function0<Unit> function0, MutableState<String> mutableState6, MutableState<String> mutableState7, MutableState<List<String>> mutableState8, MutableState<Long> mutableState9, MutableState<String> mutableState10) {
        if (ProductFormSheet$lambda$50(mutableState)) {
            return;
        }
        mutableState2.setValue("");
        String obj = StringsKt.trim((CharSequence) ProductFormSheet$lambda$2(mutableState3)).toString();
        if (obj.length() != 0) {
            String variantCompose = variantCompose(obj, ProductFormSheet$lambda$5(mutableState4), ProductFormSheet$lambda$8(mutableState5));
            boolean z4 = z && z2 && d > AudioStats.AUDIO_AMPLITUDE_NONE;
            if (!z4 || d2 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                ProductFormSheet$lambda$51(mutableState, true);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ProductFormKt$ProductFormSheet$save$1(product, repo, variantCompose, d3, d2, z, z3, d4, z4, d, function1, function0, mutableState6, mutableState7, mutableState8, mutableState9, mutableState10, mutableState2, mutableState, null), 3, null);
                return;
            } else {
                mutableState2.setValue(LangKt.tx("Укажите цену продажи — по ней товар будет продаваться.", new Object[0]));
                return;
            }
        }
        mutableState2.setValue(LangKt.tx("Введите название товара.", new Object[0]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ProductFormSheet$lambda$62(final Function0 function0, final boolean z, final boolean z2, final double d, final double d2, final CoroutineScope coroutineScope, final Product product, final Repo repo, final double d3, final boolean z3, final double d4, final Function1 function1, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, final MutableState mutableState8, final MutableState mutableState9, final MutableState mutableState10, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C288@13230L89,291@13421L10,289@13332L273:ProductForm.kt#i65cod");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2009506151, i2, -1, "uz.FonRo.pos.ui.catalog.ProductFormSheet.<anonymous> (ProductForm.kt:288)");
            }
            BasicsKt.OxButton(LangKt.tx("Отмена", new Object[0]), function0, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.GHOST, null, false, false, null, composer, 3072, 240);
            String tx = z ? LangKt.tx("Создать", new Object[0]) : LangKt.tx("Сохранить", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -1599865519, "CC(remember):ProductForm.kt#9igjgp");
            boolean changed = composer.changed(function0) | composer.changed(z) | composer.changed(z2) | composer.changed(d) | composer.changed(d2) | composer.changedInstance(coroutineScope) | composer.changedInstance(product) | composer.changedInstance(repo) | composer.changed(d3) | composer.changed(z3) | composer.changed(d4) | composer.changed(function1);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                Function0 function02 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProductFormSheet$lambda$62$0$0;
                        ProductFormSheet$lambda$62$0$0 = ProductFormKt.ProductFormSheet$lambda$62$0$0(z, z2, d, d2, coroutineScope, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, product, repo, d3, z3, d4, function1, function0, mutableState6, mutableState7, mutableState8, mutableState9, mutableState10);
                        return ProductFormSheet$lambda$62$0$0;
                    }
                };
                composer2 = composer;
                composer2.updateRememberedValue(function02);
                rememberedValue = function02;
            } else {
                composer2 = composer;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 2.0f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, !ProductFormSheet$lambda$50(mutableState), false, null, composer2, 27648, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$62$0$0(boolean z, boolean z2, double d, double d2, CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, Product product, Repo repo, double d3, boolean z3, double d4, Function1 function1, Function0 function0, MutableState mutableState6, MutableState mutableState7, MutableState mutableState8, MutableState mutableState9, MutableState mutableState10) {
        ProductFormSheet$save(z, z2, d, d2, coroutineScope, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, product, repo, d3, z3, d4, function1, function0, mutableState6, mutableState7, mutableState8, mutableState9, mutableState10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ProductFormSheet$lambda$63(boolean z, boolean z2, final boolean z3, final MutableState mutableState, MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, final double d, final double d2, final double d3, final MutableState mutableState8, final MutableState mutableState9, final MutableState mutableState10, final Repo repo, final MutableState mutableState11, final MutableState mutableState12, final MutableState mutableState13, final MutableState mutableState14, MutableState mutableState15, final double d4, final MutableState mutableState16, final MutableState mutableState17, final Product product, final MutableState mutableState18, MutableState mutableState19, ColumnScope OxCardSheet, Composer composer, int i) {
        String tx;
        final MutableState mutableState20;
        final MutableState mutableState21;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C299@13663L21,299@13632L12458:ProductForm.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(625860368, i, -1, "uz.FonRo.pos.ui.catalog.ProductFormSheet.<anonymous> (ProductForm.kt:299)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1378382531, "C301@13702L217,306@13932L11,309@14003L1399,343@15415L11,346@15525L2343,346@15493L2375,457@20672L917,457@20619L970,486@21793L32,483@21652L187,488@21852L11,576@26070L10:ProductForm.kt#i65cod");
            if (z) {
                tx = LangKt.tx("Заполните название и цены — остальное можно позже", new Object[0]);
            } else {
                tx = LangKt.tx("Меняйте что нужно, остальное останется как было", new Object[0]);
            }
            TextKt.m2798Text4IGK_g(tx, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            Modifier m1049padding3ABfNKs = PaddingKt.m1049padding3ABfNKs(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), OxShape.INSTANCE.getCard()), Ox.INSTANCE.m10218getPanel20d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getCard()), Dp.m6989constructorimpl(14.0f));
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
            ComposerKt.sourceInformationMarkerStart(composer, -1732407840, "C317@14293L23,318@14333L349,326@14699L11,327@14727L661:ProductForm.kt#i65cod");
            PfLabel(LangKt.tx("Штрихкод", new Object[0]), composer, 0);
            String ProductFormSheet$lambda$14 = ProductFormSheet$lambda$14(mutableState);
            if (StringsKt.isBlank(ProductFormSheet$lambda$14)) {
                ProductFormSheet$lambda$14 = null;
            }
            if (ProductFormSheet$lambda$14 == null) {
                ProductFormSheet$lambda$14 = LangKt.tx("Штрихкода нет", new Object[0]);
            }
            TextKt.m2798Text4IGK_g(ProductFormSheet$lambda$14, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH3(), StringsKt.isBlank(ProductFormSheet$lambda$14(mutableState)) ? Ox.INSTANCE.m10200getDim20d7_KjU() : Ox.INSTANCE.m10233getText0d7_KjU(), 0L, null, null, null, FontFamily.INSTANCE.getMonospace(), null, TextUnitKt.getSp(1), null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777054, null), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer, 6);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer, 6);
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
            ComposerKt.sourceInformationMarkerStart(composer, 709625422, "C330@14944L23,328@14805L330,337@15231L26,335@15156L214:ProductForm.kt#i65cod");
            String tx2 = StringsKt.isBlank(ProductFormSheet$lambda$14(mutableState)) ? LangKt.tx("Сканировать штрихкод", new Object[0]) : LangKt.tx("Сканировать заново", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -1639672937, "CC(remember):ProductForm.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableState20 = mutableState2;
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProductFormSheet$lambda$63$0$0$1$0$0;
                        ProductFormSheet$lambda$63$0$0$1$0$0 = ProductFormKt.ProductFormSheet$lambda$63$0$0$1$0$0(MutableState.this);
                        return ProductFormSheet$lambda$63$0$0$1$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            } else {
                mutableState20 = mutableState2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx2, (Function0) rememberedValue, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.CYAN, BtnSize.SM, false, false, null, composer, 27696, 224);
            String tx3 = LangKt.tx("Новый код", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -1639663750, "CC(remember):ProductForm.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProductFormSheet$lambda$63$0$0$1$1$0;
                        ProductFormSheet$lambda$63$0$0$1$1$0 = ProductFormKt.ProductFormSheet$lambda$63$0$0$1$1$0(MutableState.this);
                        return ProductFormSheet$lambda$63$0$0$1$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx3, (Function0) rememberedValue2, null, BtnStyle.PLAIN, BtnSize.SM, false, false, null, composer, 27696, 228);
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
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            PfCard(DiskLruCache.VERSION, LangKt.tx("Что за товар", new Object[0]), ComposableLambdaKt.rememberComposableLambda(-845699317, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ProductFormSheet$lambda$63$0$1;
                    ProductFormSheet$lambda$63$0$1 = ProductFormKt.ProductFormSheet$lambda$63$0$1(z3, mutableState3, mutableState4, mutableState5, mutableState6, mutableState7, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ProductFormSheet$lambda$63$0$1;
                }
            }, composer, 54), composer, 390);
            String str = "2";
            if (z2) {
                composer.startReplaceGroup(1382314694);
                ComposerKt.sourceInformation(composer, "406@18024L2516,406@17990L2550");
                PfCard("2", LangKt.tx("Цены и остаток", new Object[0]), ComposableLambdaKt.rememberComposableLambda(1879283238, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit ProductFormSheet$lambda$63$0$2;
                        ProductFormSheet$lambda$63$0$2 = ProductFormKt.ProductFormSheet$lambda$63$0$2(d, d2, d3, mutableState8, mutableState9, mutableState10, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return ProductFormSheet$lambda$63$0$2;
                    }
                }, composer, 54), composer, 390);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1384795996);
                composer.endReplaceGroup();
            }
            if (z2) {
                str = ExifInterface.GPS_MEASUREMENT_3D;
            }
            PfCard(str, LangKt.tx("Где искать", new Object[0]), ComposableLambdaKt.rememberComposableLambda(811599618, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ProductFormSheet$lambda$63$0$3;
                    ProductFormSheet$lambda$63$0$3 = ProductFormKt.ProductFormSheet$lambda$63$0$3(Repo.this, mutableState11, mutableState12, mutableState13, mutableState14, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ProductFormSheet$lambda$63$0$3;
                }
            }, composer, 54), composer, 384);
            String tx4 = LangKt.tx("Дополнительно: шаг продажи, штрихкоды", new Object[0]);
            boolean ProductFormSheet$lambda$44 = ProductFormSheet$lambda$44(mutableState15);
            ComposerKt.sourceInformationMarkerStart(composer, -509478810, "CC(remember):ProductForm.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                mutableState21 = mutableState15;
                rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProductFormSheet$lambda$63$0$4$0;
                        ProductFormSheet$lambda$63$0$4$0 = ProductFormKt.ProductFormSheet$lambda$63$0$4$0(MutableState.this);
                        return ProductFormSheet$lambda$63$0$4$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            } else {
                mutableState21 = mutableState15;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            PfToggle(tx4, ProductFormSheet$lambda$44, (Function0) rememberedValue3, composer, 384);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            int i2 = z2 ? 4 : 3;
            int i3 = i2 + (z3 ? 1 : 0);
            if (ProductFormSheet$lambda$44(mutableState21)) {
                composer.startReplaceGroup(1386504592);
                ComposerKt.sourceInformation(composer, "512@22986L2760,512@22923L2823");
                if (z3) {
                    composer.startReplaceGroup(1386448761);
                    ComposerKt.sourceInformation(composer, "497@22269L618,497@22220L667");
                    PfCard(String.valueOf(i2), LangKt.tx("Шаг продажи", new Object[0]), ComposableLambdaKt.rememberComposableLambda(-1134839304, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit ProductFormSheet$lambda$63$0$5;
                            ProductFormSheet$lambda$63$0$5 = ProductFormKt.ProductFormSheet$lambda$63$0$5(d4, mutableState16, mutableState7, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            return ProductFormSheet$lambda$63$0$5;
                        }
                    }, composer, 54), composer, 384);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(1387128188);
                    composer.endReplaceGroup();
                }
                final MutableState mutableState22 = mutableState20;
                PfCard(String.valueOf(i3), LangKt.tx("Дополнительные штрихкоды", new Object[0]), ComposableLambdaKt.rememberComposableLambda(-410215587, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit ProductFormSheet$lambda$63$0$6;
                        ProductFormSheet$lambda$63$0$6 = ProductFormKt.ProductFormSheet$lambda$63$0$6(MutableState.this, repo, product, mutableState18, mutableState, mutableState22, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return ProductFormSheet$lambda$63$0$6;
                    }
                }, composer, 54), composer, 384);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1389960348);
                composer.endReplaceGroup();
            }
            if (!StringsKt.isBlank(ProductFormSheet$lambda$47(mutableState19))) {
                composer.startReplaceGroup(1390026781);
                ComposerKt.sourceInformation(composer, "570@25820L223");
                TextKt.m2798Text4IGK_g(ProductFormSheet$lambda$47(mutableState19), PaddingKt.m1051paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(4.0f), 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowTitle(), Ox.INSTANCE.m10196getDanger0d7_KjU(), 0L, FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composer, 48, 0, 65532);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1390254972);
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
    public static final Unit ProductFormSheet$lambda$63$0$0$1$0$0(MutableState mutableState) {
        mutableState.setValue("main");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$63$0$0$1$1$0(MutableState mutableState) {
        mutableState.setValue(newBarcode());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$63$0$1(boolean z, MutableState mutableState, MutableState mutableState2, final MutableState mutableState3, MutableState mutableState4, final MutableState mutableState5, ColumnScope PfCard, Composer composer, int i) {
        final MutableState mutableState6;
        final MutableState mutableState7;
        String tx;
        final MutableState mutableState8;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(PfCard, "$this$PfCard");
        ComposerKt.sourceInformation(composer2, "C347@15543L23,350@15667L13,348@15583L176,353@15776L11,357@15948L30,354@15804L192,385@17201L11,387@17230L32,388@17289L356,388@17279L366,398@17662L192:ProductForm.kt#i65cod");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-845699317, i, -1, "uz.FonRo.pos.ui.catalog.ProductFormSheet.<anonymous>.<anonymous>.<anonymous> (ProductForm.kt:347)");
            }
            PfLabel(LangKt.tx("Название", new Object[0]), composer2, 0);
            String ProductFormSheet$lambda$2 = ProductFormSheet$lambda$2(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer2, -968220136, "CC(remember):ProductForm.kt#9igjgp");
            Object rememberedValue = composer2.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableState6 = mutableState;
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ProductFormSheet$lambda$63$0$1$0$0;
                        ProductFormSheet$lambda$63$0$1$0$0 = ProductFormKt.ProductFormSheet$lambda$63$0$1$0$0(MutableState.this, (String) obj);
                        return ProductFormSheet$lambda$63$0$1$0$0;
                    }
                };
                composer2.updateRememberedValue(rememberedValue);
            } else {
                mutableState6 = mutableState;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            FieldsKt.m9848OxSolidInputYxU46PI(ProductFormSheet$lambda$2, (Function1) rememberedValue, null, LangKt.tx("Например: Coca Cola", new Object[0]), 0, false, composer2, 48, 52);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer2, 6);
            String tx2 = LangKt.tx("Вариант: цвет, размер, память", new Object[0]);
            boolean ProductFormSheet$lambda$11 = ProductFormSheet$lambda$11(mutableState2);
            ComposerKt.sourceInformationMarkerStart(composer2, -968211127, "CC(remember):ProductForm.kt#9igjgp");
            Object rememberedValue2 = composer2.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                mutableState7 = mutableState2;
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda32
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProductFormSheet$lambda$63$0$1$1$0;
                        ProductFormSheet$lambda$63$0$1$1$0 = ProductFormKt.ProductFormSheet$lambda$63$0$1$1$0(MutableState.this);
                        return ProductFormSheet$lambda$63$0$1$1$0;
                    }
                };
                composer2.updateRememberedValue(rememberedValue2);
            } else {
                mutableState7 = mutableState2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            PfToggle(tx2, ProductFormSheet$lambda$11, (Function0) rememberedValue2, composer2, 384);
            if (ProductFormSheet$lambda$11(mutableState7)) {
                composer2.startReplaceGroup(50342325);
                ComposerKt.sourceInformation(composer2, "360@16052L11,361@16084L835,379@16940L56,380@17017L149");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer2, 6);
                Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer2, 6);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, companion);
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
                ComposerKt.sourceInformationMarkerStart(composer2, 1104703647, "C362@16167L357,370@16549L348:ProductForm.kt#i65cod");
                Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, weight$default);
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
                ComposerKt.sourceInformationMarkerStart(composer2, 539842450, "C363@16225L25,366@16387L13,364@16279L219:ProductForm.kt#i65cod");
                PfLabel(LangKt.tx("Параметр 1", new Object[0]), composer2, 0);
                String ProductFormSheet$lambda$5 = ProductFormSheet$lambda$5(mutableState3);
                ComposerKt.sourceInformationMarkerStart(composer2, 571608525, "CC(remember):ProductForm.kt#9igjgp");
                Object rememberedValue3 = composer2.rememberedValue();
                if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda34
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit ProductFormSheet$lambda$63$0$1$2$0$0$0;
                            ProductFormSheet$lambda$63$0$1$2$0$0$0 = ProductFormKt.ProductFormSheet$lambda$63$0$1$2$0$0$0(MutableState.this, (String) obj);
                            return ProductFormSheet$lambda$63$0$1$2$0$0$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                FieldsKt.m9848OxSolidInputYxU46PI(ProductFormSheet$lambda$5, (Function1) rememberedValue3, null, LangKt.tx("Чёрный / 64 GB", new Object[0]), 0, false, composer2, 48, 52);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier weight$default2 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, weight$default2);
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
                ComposerKt.sourceInformationMarkerStart(composer2, -1551811100, "C371@16607L25,374@16769L13,372@16661L210:ProductForm.kt#i65cod");
                PfLabel(LangKt.tx("Параметр 2", new Object[0]), composer2, 0);
                String ProductFormSheet$lambda$8 = ProductFormSheet$lambda$8(mutableState4);
                ComposerKt.sourceInformationMarkerStart(composer2, 1751061828, "CC(remember):ProductForm.kt#9igjgp");
                Object rememberedValue4 = composer2.rememberedValue();
                if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    mutableState8 = mutableState4;
                    rememberedValue4 = new Function1() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda35
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit ProductFormSheet$lambda$63$0$1$2$1$0$0;
                            ProductFormSheet$lambda$63$0$1$2$1$0$0 = ProductFormKt.ProductFormSheet$lambda$63$0$1$2$1$0$0(MutableState.this, (String) obj);
                            return ProductFormSheet$lambda$63$0$1$2$1$0$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue4);
                } else {
                    mutableState8 = mutableState4;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                FieldsKt.m9848OxSolidInputYxU46PI(ProductFormSheet$lambda$8, (Function1) rememberedValue4, null, "M / USB-C", 0, false, composer2, 3120, 52);
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
                PfHint(LangKt.tx("Название соберётся так: Чехол · Чёрный · M", new Object[0]), composer2, 0);
                String variantCompose = variantCompose(ProductFormSheet$lambda$2(mutableState6), ProductFormSheet$lambda$5(mutableState3), ProductFormSheet$lambda$8(mutableState8));
                if (StringsKt.isBlank(variantCompose)) {
                    variantCompose = "—";
                }
                TextKt.m2798Text4IGK_g(variantCompose, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), composer, 0, 0, 65534);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(51451319);
                composer2.endReplaceGroup();
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer2, 6);
            PfLabel(LangKt.tx("Единица измерения", new Object[0]), composer2, 0);
            ChipsKt.OxChipRow(null, ComposableLambdaKt.rememberComposableLambda(1411637660, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ProductFormSheet$lambda$63$0$1$4;
                    ProductFormSheet$lambda$63$0$1$4 = ProductFormKt.ProductFormSheet$lambda$63$0$1$4(MutableState.this, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ProductFormSheet$lambda$63$0$1$4;
                }
            }, composer2, 54), composer2, 48, 1);
            if (z) {
                tx = LangKt.tx("Дробный товар: можно продать часть — например 0,5.", new Object[0]);
            } else {
                tx = LangKt.tx("Штучный товар: продаётся целыми единицами.", new Object[0]);
            }
            PfHint(tx, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$63$0$1$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$63$0$1$1$0(MutableState mutableState) {
        ProductFormSheet$lambda$12(mutableState, !ProductFormSheet$lambda$11(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$63$0$1$2$0$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$63$0$1$2$1$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$63$0$1$4(final MutableState mutableState, RowScope OxChipRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxChipRow, "$this$OxChipRow");
        ComposerKt.sourceInformation(composer, "C*394@17564L15,390@17372L233:ProductForm.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1411637660, i, -1, "uz.FonRo.pos.ui.catalog.ProductFormSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProductForm.kt:389)");
            }
            Iterator<T> it = Units.INSTANCE.getALL().iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                final String str = (String) pair.component1();
                String str2 = (String) pair.component2();
                boolean areEqual = Intrinsics.areEqual(ProductFormSheet$lambda$29(mutableState), str);
                ChipTint chipTint = ChipTint.CYAN;
                ComposerKt.sourceInformationMarkerStart(composer, 1990923748, "CC(remember):ProductForm.kt#9igjgp");
                boolean changed = composer.changed(str);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProductFormSheet$lambda$63$0$1$4$0$0$0;
                            ProductFormSheet$lambda$63$0$1$4$0$0$0 = ProductFormKt.ProductFormSheet$lambda$63$0$1$4$0$0$0(str, mutableState);
                            return ProductFormSheet$lambda$63$0$1$4$0$0$0;
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
    public static final Unit ProductFormSheet$lambda$63$0$1$4$0$0$0(String str, MutableState mutableState) {
        mutableState.setValue(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$63$0$2(double d, double d2, double d3, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, ColumnScope PfCard, Composer composer, int i) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(PfCard, "$this$PfCard");
        ComposerKt.sourceInformation(composer, "C407@18046L75,408@18142L25,411@18283L25,409@18188L246,415@18455L11,416@18487L995:ProductForm.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1879283238, i, -1, "uz.FonRo.pos.ui.catalog.ProductFormSheet.<anonymous>.<anonymous>.<anonymous> (ProductForm.kt:407)");
            }
            PfHint(LangKt.tx("Эти цифры создадут приход — он появится на странице «Приход».", new Object[0]), composer, 0);
            PfLabel(LangKt.tx("Количество", new Object[0]), composer, 0);
            String ProductFormSheet$lambda$35 = ProductFormSheet$lambda$35(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 2104935711, "CC(remember):ProductForm.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda42
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ProductFormSheet$lambda$63$0$2$0$0;
                        ProductFormSheet$lambda$63$0$2$0$0 = ProductFormKt.ProductFormSheet$lambda$63$0$2$0$0(MutableState.this, (String) obj);
                        return ProductFormSheet$lambda$63$0$2$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9848OxSolidInputYxU46PI(ProductFormSheet$lambda$35, (Function1) rememberedValue, null, "0", KeyboardType.INSTANCE.m6689getDecimalPjHm6EE(), false, composer, 27696, 36);
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
            ComposerKt.sourceInformationMarkerStart(composer, -328091969, "C417@18570L437,426@19032L428:ProductForm.kt#i65cod");
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
            ComposerKt.sourceInformationMarkerStart(composer, -892955646, "C418@18628L28,421@18801L30,419@18685L296:ProductForm.kt#i65cod");
            PfLabel(LangKt.tx("Себестоимость", new Object[0]), composer, 0);
            String ProductFormSheet$lambda$38 = ProductFormSheet$lambda$38(mutableState2);
            ComposerKt.sourceInformationMarkerStart(composer, 2049410174, "CC(remember):ProductForm.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ProductFormSheet$lambda$63$0$2$1$0$0$0;
                        ProductFormSheet$lambda$63$0$2$1$0$0$0 = ProductFormKt.ProductFormSheet$lambda$63$0$2$1$0$0$0(MutableState.this, (String) obj);
                        return ProductFormSheet$lambda$63$0$2$1$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9848OxSolidInputYxU46PI(ProductFormSheet$lambda$38, (Function1) rememberedValue2, null, "0", KeyboardType.INSTANCE.m6689getDecimalPjHm6EE(), false, composer, 27696, 36);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier weight$default2 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, weight$default2);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1310358100, "C427@19090L27,430@19258L26,428@19146L288:ProductForm.kt#i65cod");
            PfLabel(LangKt.tx("Цена продажи", new Object[0]), composer, 0);
            String ProductFormSheet$lambda$41 = ProductFormSheet$lambda$41(mutableState3);
            ComposerKt.sourceInformationMarkerStart(composer, -1066103983, "CC(remember):ProductForm.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ProductFormSheet$lambda$63$0$2$1$1$0$0;
                        ProductFormSheet$lambda$63$0$2$1$1$0$0 = ProductFormKt.ProductFormSheet$lambda$63$0$2$1$1$0$0(MutableState.this, (String) obj);
                        return ProductFormSheet$lambda$63$0$2$1$1$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9848OxSolidInputYxU46PI(ProductFormSheet$lambda$41, (Function1) rememberedValue3, null, "0", KeyboardType.INSTANCE.m6689getDecimalPjHm6EE(), false, composer, 27696, 36);
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
            if (d > AudioStats.AUDIO_AMPLITUDE_NONE || d2 > AudioStats.AUDIO_AMPLITUDE_NONE || d3 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                composer.startReplaceGroup(829792473);
                ComposerKt.sourceInformation(composer, "437@19585L11,441@19826L384,448@20235L73");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
                double d4 = d3 - d2;
                int roundToInt = d2 > AudioStats.AUDIO_AMPLITUDE_NONE ? MathKt.roundToInt((d4 / d2) * 100.0d) : 0;
                String tx = LangKt.tx("Наценка", new Object[0]);
                if (d3 > AudioStats.AUDIO_AMPLITUDE_NONE && d2 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    String nf = Fmt.INSTANCE.nf(Double.valueOf(d4));
                    if (roundToInt != 0) {
                        str2 = " · " + roundToInt + "%";
                    } else {
                        str2 = "";
                    }
                    str = nf + str2;
                } else {
                    str = "—";
                }
                m9815MoneyLineXOJAsU(tx, str, (d3 <= AudioStats.AUDIO_AMPLITUDE_NONE || d2 <= AudioStats.AUDIO_AMPLITUDE_NONE || d4 >= AudioStats.AUDIO_AMPLITUDE_NONE) ? Ox.INSTANCE.m10233getText0d7_KjU() : Ox.INSTANCE.m10196getDanger0d7_KjU(), composer, 0);
                m9815MoneyLineXOJAsU(LangKt.tx("Сумма прихода", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(d * d2)), Ox.INSTANCE.m10233getText0d7_KjU(), composer, 0);
                if (d3 > AudioStats.AUDIO_AMPLITUDE_NONE && d2 > AudioStats.AUDIO_AMPLITUDE_NONE && d4 < AudioStats.AUDIO_AMPLITUDE_NONE) {
                    composer.startReplaceGroup(830588460);
                    ComposerKt.sourceInformation(composer, "450@20418L56");
                    PfHint(LangKt.tx("Продаёте дешевле закупки — проверьте цены.", new Object[0]), composer, 0);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(830696092);
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(830717916);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$63$0$2$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(numText(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$63$0$2$1$0$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(numText(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$63$0$2$1$1$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(numText(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$63$0$3(Repo repo, MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, ColumnScope PfCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(PfCard, "$this$PfCard");
        ComposerKt.sourceInformation(composer, "C458@20690L24,461@20877L21,459@20731L185,473@21318L11,474@21346L39,477@21485L12,475@21402L173:ProductForm.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(811599618, i, -1, "uz.FonRo.pos.ui.catalog.ProductFormSheet.<anonymous>.<anonymous>.<anonymous> (ProductForm.kt:458)");
            }
            PfLabel(LangKt.tx("Категория", new Object[0]), composer, 0);
            String tx = ProductFormSheet$lambda$26(mutableState) == 0 ? LangKt.tx("Без категории", new Object[0]) : repo.categoryName(ProductFormSheet$lambda$26(mutableState));
            ComposerKt.sourceInformationMarkerStart(composer, -1736808393, "CC(remember):ProductForm.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda38
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProductFormSheet$lambda$63$0$3$0$0;
                        ProductFormSheet$lambda$63$0$3$0$0 = ProductFormKt.ProductFormSheet$lambda$63$0$3$0$0(MutableState.this);
                        return ProductFormSheet$lambda$63$0$3$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            PfPicker(tx, (Function0) rememberedValue, composer, 48);
            if (repo.can(Perm.MANAGE_CATEGORIES)) {
                composer.startReplaceGroup(1993617494);
                ComposerKt.sourceInformation(composer, "464@20993L10,467@21107L26,465@21024L259");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer, 6);
                String tx2 = LangKt.tx("Создать категорию", new Object[0]);
                BtnStyle btnStyle = BtnStyle.CYAN;
                BtnSize btnSize = BtnSize.SM;
                ComposerKt.sourceInformationMarkerStart(composer, -1736801028, "CC(remember):ProductForm.kt#9igjgp");
                Object rememberedValue2 = composer.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda39
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProductFormSheet$lambda$63$0$3$1$0;
                            ProductFormSheet$lambda$63$0$3$1$0 = ProductFormKt.ProductFormSheet$lambda$63$0$3$1$0(MutableState.this);
                            return ProductFormSheet$lambda$63$0$3$1$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                BasicsKt.OxButton(tx2, (Function0) rememberedValue2, null, btnStyle, btnSize, false, true, null, composer, 1600560, 164);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1993934624);
                composer.endReplaceGroup();
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            PfLabel(LangKt.tx("Артикул / внутренний код", new Object[0]), composer, 0);
            String ProductFormSheet$lambda$23 = ProductFormSheet$lambda$23(mutableState4);
            ComposerKt.sourceInformationMarkerStart(composer, -1736788946, "CC(remember):ProductForm.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda40
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ProductFormSheet$lambda$63$0$3$2$0;
                        ProductFormSheet$lambda$63$0$3$2$0 = ProductFormKt.ProductFormSheet$lambda$63$0$3$2$0(MutableState.this, (String) obj);
                        return ProductFormSheet$lambda$63$0$3$2$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9848OxSolidInputYxU46PI(ProductFormSheet$lambda$23, (Function1) rememberedValue3, null, LangKt.tx("Например: COLA-001", new Object[0]), 0, false, composer, 48, 52);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$63$0$3$0$0(MutableState mutableState) {
        ProductFormSheet$lambda$57(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$63$0$3$1$0(MutableState mutableState) {
        ProductFormSheet$lambda$60(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$63$0$3$2$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$63$0$4$0(MutableState mutableState) {
        ProductFormSheet$lambda$45(mutableState, !ProductFormSheet$lambda$44(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$63$0$5(double d, final MutableState mutableState, MutableState mutableState2, ColumnScope PfCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(PfCard, "$this$PfCard");
        ComposerKt.sourceInformation(composer, "C498@22295L79,501@22499L22,499@22399L260,505@22684L181:ProductForm.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1134839304, i, -1, "uz.FonRo.pos.ui.catalog.ProductFormSheet.<anonymous>.<anonymous>.<anonymous> (ProductForm.kt:498)");
            }
            PfHint(LangKt.tx("На сколько кнопки + и − меняют количество этого товара в продаже.", new Object[0]), composer, 0);
            String ProductFormSheet$lambda$32 = ProductFormSheet$lambda$32(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 341129422, "CC(remember):ProductForm.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ProductFormSheet$lambda$63$0$5$0$0;
                        ProductFormSheet$lambda$63$0$5$0$0 = ProductFormKt.ProductFormSheet$lambda$63$0$5$0$0(MutableState.this, (String) obj);
                        return ProductFormSheet$lambda$63$0$5$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9848OxSolidInputYxU46PI(ProductFormSheet$lambda$32, (Function1) rememberedValue, null, DiskLruCache.VERSION, KeyboardType.INSTANCE.m6689getDecimalPjHm6EE(), false, composer, 27696, 36);
            String tx = LangKt.tx("Сейчас: ", new Object[0]);
            PfHint(tx + Fmt.INSTANCE.qf(Double.valueOf(d > AudioStats.AUDIO_AMPLITUDE_NONE ? d : 1.0d)) + " " + Units.INSTANCE.name(ProductFormSheet$lambda$29(mutableState2)), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$63$0$5$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(numText(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit ProductFormSheet$lambda$63$0$6(final MutableState mutableState, final Repo repo, final Product product, MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, ColumnScope PfCard, Composer composer, int i) {
        final MutableState mutableState5;
        Object obj;
        int i2;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(PfCard, "$this$PfCard");
        ComposerKt.sourceInformation(composer2, "C513@23008L164,547@24782L946:ProductForm.kt#i65cod");
        int i3 = 1;
        int i4 = 0;
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-410215587, i, -1, "uz.FonRo.pos.ui.catalog.ProductFormSheet.<anonymous>.<anonymous>.<anonymous> (ProductForm.kt:513)");
            }
            PfHint(LangKt.tx("Добавьте сюда штрихкоды разных партий этого же товара. При продаже сканер найдёт товар по любому из них.", new Object[0]), composer2, 0);
            composer2.startReplaceGroup(919820565);
            ComposerKt.sourceInformation(composer2, "*517@23243L1496");
            for (final String str : ProductFormSheet$lambda$17(mutableState)) {
                Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, i3, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(8.0f), 7, null), OxShape.INSTANCE.getField()), Ox.INSTANCE.m10191getChipDim0d7_KjU(), null, 2, null), Dp.m6989constructorimpl(12.0f), 0.0f, Dp.m6989constructorimpl(4.0f), 0.0f, 10, null);
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, i4);
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
                ComposerKt.sourceInformationMarkerStart(composer2, 592524398, "C526@23709L345,537@24288L46,537@24282L52,533@24083L630:ProductForm.kt#i65cod");
                int i5 = i3;
                TextKt.m2798Text4IGK_g(str, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowTitle(), 0L, 0L, null, null, null, FontFamily.INSTANCE.getMonospace(), null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777183, null), composer, 0, 3120, 55292);
                Modifier clip = ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(40.0f)), OxShape.INSTANCE.getPill());
                ComposerKt.sourceInformationMarkerStart(composer, -1227794729, "CC(remember):ProductForm.kt#9igjgp");
                boolean changed = composer.changed(str);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProductFormSheet$lambda$63$0$6$0$0$0$0;
                            ProductFormSheet$lambda$63$0$6$0$0$0$0 = ProductFormKt.ProductFormSheet$lambda$63$0$6$0$0$0$0(MutableState.this, str);
                            return ProductFormSheet$lambda$63$0$6$0$0$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier oxTap = ModifiersKt.oxTap(clip, false, (Function0) rememberedValue, composer, 0, 1);
                composer2 = composer;
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, oxTap);
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
                Updater.m3815setimpl(m3808constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 932648553, "C540@24468L215:ProductForm.kt#i65cod");
                IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getDelete(), LangKt.tx("Удалить код", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(18.0f)), Ox.INSTANCE.m10200getDim20d7_KjU(), composer2, 384, 0);
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
                i4 = 0;
                i3 = i5;
            }
            int i6 = i4;
            composer2.endReplaceGroup();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically2, composer2, 54);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, i6);
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
            ComposerKt.sourceInformationMarkerStart(composer2, -440244497, "C551@24983L380,559@25447L97,559@25388L156,562@25630L76,562@25569L137:ProductForm.kt#i65cod");
            Modifier weight$default = RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), i6);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, i6);
            CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, weight$default);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            Updater.m3815setimpl(m3808constructorimpl4, maybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl4.getInserting() || !Intrinsics.areEqual(m3808constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m3808constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m3808constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3815setimpl(m3808constructorimpl4, materializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 1761897937, "C554@25152L19,552@25038L299:ProductForm.kt#i65cod");
            String ProductFormSheet$lambda$20 = ProductFormSheet$lambda$20(mutableState2);
            ComposerKt.sourceInformationMarkerStart(composer2, 888122778, "CC(remember):ProductForm.kt#9igjgp");
            Object rememberedValue2 = composer2.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                mutableState5 = mutableState2;
                rememberedValue2 = new Function1() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit ProductFormSheet$lambda$63$0$6$1$0$0$0;
                        ProductFormSheet$lambda$63$0$6$1$0$0$0 = ProductFormKt.ProductFormSheet$lambda$63$0$6$1$0$0$0(MutableState.this, (String) obj2);
                        return ProductFormSheet$lambda$63$0$6$1$0$0$0;
                    }
                };
                composer2.updateRememberedValue(rememberedValue2);
            } else {
                mutableState5 = mutableState2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            FieldsKt.m9848OxSolidInputYxU46PI(ProductFormSheet$lambda$20, (Function1) rememberedValue2, null, LangKt.tx("Новый штрихкод", new Object[i6]), KeyboardType.INSTANCE.m6691getNumberPjHm6EE(), false, composer, 24624, 36);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ImageVector add = OxIcons.INSTANCE.getAdd();
            String tx = LangKt.tx("Добавить код", new Object[i6]);
            long m10213getOrange0d7_KjU = Ox.INSTANCE.m10213getOrange0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(composer, -568376542, "CC(remember):ProductForm.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(repo) | composer.changedInstance(product);
            Object rememberedValue3 = composer.rememberedValue();
            if (changedInstance || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                i2 = i6;
                obj = new Function0() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProductFormSheet$lambda$63$0$6$1$1$0;
                        ProductFormSheet$lambda$63$0$6$1$1$0 = ProductFormKt.ProductFormSheet$lambda$63$0$6$1$1$0(MutableState.this, repo, mutableState3, mutableState, product);
                        return ProductFormSheet$lambda$63$0$6$1$1$0;
                    }
                };
                composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue3;
                i2 = i6;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m9816PfSquareButtonFNF3uiM(add, tx, m10213getOrange0d7_KjU, (Function0) obj, composer, 0);
            ImageVector scan = OxIcons.INSTANCE.getScan();
            String tx2 = LangKt.tx("Сканировать код", new Object[i2]);
            long m10192getCyan0d7_KjU = Ox.INSTANCE.m10192getCyan0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(composer, -568370707, "CC(remember):ProductForm.kt#9igjgp");
            Object rememberedValue4 = composer.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda33
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProductFormSheet$lambda$63$0$6$1$2$0;
                        ProductFormSheet$lambda$63$0$6$1$2$0 = ProductFormKt.ProductFormSheet$lambda$63$0$6$1$2$0(MutableState.this);
                        return ProductFormSheet$lambda$63$0$6$1$2$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m9816PfSquareButtonFNF3uiM(scan, tx2, m10192getCyan0d7_KjU, (Function0) rememberedValue4, composer, 3072);
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
    public static final Unit ProductFormSheet$lambda$63$0$6$0$0$0$0(MutableState mutableState, String str) {
        List<String> ProductFormSheet$lambda$17 = ProductFormSheet$lambda$17(mutableState);
        ArrayList arrayList = new ArrayList();
        for (Object obj : ProductFormSheet$lambda$17) {
            if (!Intrinsics.areEqual((String) obj, str)) {
                arrayList.add(obj);
            }
        }
        mutableState.setValue(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$63$0$6$1$0$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$63$0$6$1$1$0(MutableState mutableState, Repo repo, MutableState mutableState2, MutableState mutableState3, Product product) {
        if (ProductFormSheet$addAlias(repo, mutableState2, mutableState3, product, ProductFormSheet$lambda$20(mutableState))) {
            mutableState.setValue("");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$63$0$6$1$2$0(MutableState mutableState) {
        mutableState.setValue("alias");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$64$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$65$0(String str, Repo repo, MutableState mutableState, MutableState mutableState2, Product product, String code) {
        Object obj;
        Intrinsics.checkNotNullParameter(code, "code");
        if (Intrinsics.areEqual(str, "alias")) {
            ProductFormSheet$addAlias(repo, mutableState, mutableState2, product, code);
        } else {
            Iterator<T> it = repo.getProducts().getValue().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                Product product2 = (Product) next;
                if (product2.getId() != (product != null ? product.getId() : 0L)) {
                    String barcode = product2.getBarcode();
                    if (Intrinsics.areEqual(barcode != null ? StringsKt.trim((CharSequence) barcode).toString() : null, code)) {
                        obj = next;
                        break;
                    }
                }
            }
            Product product3 = (Product) obj;
            if (product3 != null) {
                Toaster.INSTANCE.error(LangKt.tx("Этот код уже у товара «%s»", product3.getName()));
            } else {
                mutableState.setValue(code);
                Toaster.INSTANCE.ok(LangKt.tx("Штрихкод подставлен", new Object[0]));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$66$0(MutableState mutableState, long j) {
        ProductFormSheet$lambda$27(mutableState, j);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$67$0(MutableState mutableState) {
        ProductFormSheet$lambda$57(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$68$0(MutableState mutableState) {
        ProductFormSheet$lambda$60(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductFormSheet$lambda$69$0(MutableState mutableState, Category it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ProductFormSheet$lambda$27(mutableState, it.getId());
        return Unit.INSTANCE;
    }

    public static final ProductVariant variantParse(String str) {
        if (str == null) {
            str = "";
        }
        String str2 = str;
        List split$default = StringsKt.split$default((CharSequence) str2, new String[]{"·"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        Iterator it = split$default.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.size() < 2) {
            return new ProductVariant(StringsKt.trim((CharSequence) str2).toString(), "", "");
        }
        if (arrayList3.size() >= 3) {
            return new ProductVariant(CollectionsKt.joinToString$default(CollectionsKt.dropLast(arrayList3, 2), " · ", null, null, 0, null, null, 62, null), (String) arrayList3.get(arrayList3.size() - 2), (String) arrayList3.get(arrayList3.size() - 1));
        }
        return new ProductVariant((String) arrayList3.get(0), (String) arrayList3.get(1), "");
    }

    public static final String variantCompose(String base, String opt1, String opt2) {
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(opt1, "opt1");
        Intrinsics.checkNotNullParameter(opt2, "opt2");
        List listOf = CollectionsKt.listOf((Object[]) new String[]{StringsKt.trim((CharSequence) base).toString(), StringsKt.trim((CharSequence) opt1).toString(), StringsKt.trim((CharSequence) opt2).toString()});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listOf) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, " · ", null, null, 0, null, null, 62, null);
    }

    public static final String newBarcode() {
        return StringsKt.padStart(String.valueOf(System.currentTimeMillis()), 13, '0') + (Random.INSTANCE.nextInt(90) + 10);
    }

    private static final void PfCard(final String str, final String str2, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1497367534);
        ComposerKt.sourceInformation(startRestartGroup, "C(PfCard)P(1,2)661@29065L509,661@29037L537,677@29579L11:ProductForm.kt#i65cod");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1497367534, i2, -1, "uz.FonRo.pos.ui.catalog.PfCard (ProductForm.kt:660)");
            }
            BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(14.0f), null, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1023105368, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ProductFormKt.PfCard$lambda$0(Function3.this, str2, str, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, 1572912, 61);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductFormKt.PfCard$lambda$1(str, str2, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PfCard$lambda$0(Function3 function3, String str, String str2, ColumnScope OxSoftCard, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C662@29075L455,674@29539L11,675@29559L9:ProductForm.kt#i65cod");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxSoftCard) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1023105368, i2, -1, "uz.FonRo.pos.ui.catalog.PfCard.<anonymous> (ProductForm.kt:662)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(9.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, composer, 54);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1125095302, "C666@29227L250,672@29490L30:ProductForm.kt#i65cod");
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(24.0f)), OxShape.INSTANCE.getPill()), Ox.INSTANCE.m10220getPrimary0d7_KjU(), null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, m558backgroundbw27NRU$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 970529485, "C670@29407L56:ProductForm.kt#i65cod");
            TextKt.m2798Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getChip(), Ox.INSTANCE.m10217getPanel0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH3(), composer, 0, 0, 65534);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            function3.invoke(OxSoftCard, composer, Integer.valueOf(i2 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void PfLabel(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-410200545);
        ComposerKt.sourceInformation(startRestartGroup, "C(PfLabel)682@29646L163:ProductForm.kt#i65cod");
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
                ComposerKt.traceEventStart(-410200545, i2, -1, "uz.FonRo.pos.ui.catalog.PfLabel (ProductForm.kt:681)");
            }
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(8.0f), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), 0L, TextUnitKt.getSp(14), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer2, (14 & i2) | 48, 0, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda37
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductFormKt.PfLabel$lambda$0(str, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void PfHint(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(338595428);
        ComposerKt.sourceInformation(startRestartGroup, "C(PfHint)691@29864L191:ProductForm.kt#i65cod");
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
                ComposerKt.traceEventStart(338595428, i2, -1, "uz.FonRo.pos.ui.catalog.PfHint (ProductForm.kt:690)");
            }
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(8.0f), 0.0f, Dp.m6989constructorimpl(12.0f), 5, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), TextUnitKt.getSp(13), FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer2, (i2 & 14) | 48, 0, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductFormKt.PfHint$lambda$0(str, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void PfToggle(final String str, boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        final boolean z2 = z;
        Composer startRestartGroup = composer.startRestartGroup(-678991521);
        ComposerKt.sourceInformation(startRestartGroup, "C(PfToggle)P(2,1)705@30291L24,700@30148L603:ProductForm.kt#i65cod");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-678991521, i3, -1, "uz.FonRo.pos.ui.catalog.PfToggle (ProductForm.kt:699)");
            }
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.m1084heightInVpY3zN4$default(ModifiersKt.oxTap(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), OxShape.INSTANCE.getField()), Ox.INSTANCE.m10191getChipDim0d7_KjU(), null, 2, null), false, function0, startRestartGroup, i3 & 896, 1), Dp.m6989constructorimpl(46.0f), 0.0f, 2, null), Dp.m6989constructorimpl(14.0f), 0.0f, 2, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1320221401, "C710@30464L204,717@30677L68:ProductForm.kt#i65cod");
            TextKt.m2798Text4IGK_g(str, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getLabel(), Ox.INSTANCE.m10233getText0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), startRestartGroup, i3 & 14, 3120, 55292);
            z2 = z;
            TextKt.m2798Text4IGK_g(z2 ? "−" : "＋", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH3(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), startRestartGroup, 0, 0, 65534);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductFormKt.PfToggle$lambda$1(str, z2, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void PfPicker(final String str, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(105115017);
        ComposerKt.sourceInformation(startRestartGroup, "C(PfPicker)P(1)728@30975L24,723@30830L686:ProductForm.kt#i65cod");
        if ((i & 6) == 0) {
            i2 = i | (startRestartGroup.changed(str) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(105115017, i3, -1, "uz.FonRo.pos.ui.catalog.PfPicker (ProductForm.kt:722)");
            }
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(SizeKt.m1084heightInVpY3zN4$default(ModifiersKt.oxTap(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), OxShape.INSTANCE.getField()), Ox.INSTANCE.m10209getInputFill0d7_KjU(), null, 2, null), false, function0, startRestartGroup, (i3 << 3) & 896, 1), Dp.m6989constructorimpl(52.0f), 0.0f, 2, null), Dp.m6989constructorimpl(15.0f), Dp.m6989constructorimpl(12.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -113443746, "C733@31166L205,740@31380L130:ProductForm.kt#i65cod");
            TextKt.m2798Text4IGK_g(str, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), 0L, TextUnitKt.getSp(16), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), startRestartGroup, i3 & 14, 3120, 55292);
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getChevron(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(20.0f)), Ox.INSTANCE.m10199getDim0d7_KjU(), startRestartGroup, 432, 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda41
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductFormKt.PfPicker$lambda$1(str, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* renamed from: PfSquareButton-FNF3uiM, reason: not valid java name */
    private static final void m9816PfSquareButtonFNF3uiM(final ImageVector imageVector, final String str, final long j, final Function0<Unit> function0, Composer composer, final int i) {
        ImageVector imageVector2;
        int i2;
        String str2;
        Composer startRestartGroup = composer.startRestartGroup(-875643283);
        ComposerKt.sourceInformation(startRestartGroup, "C(PfSquareButton)P(1!1,3:c#ui.graphics.Color)759@31809L24,754@31657L334:ProductForm.kt#i65cod");
        if ((i & 6) == 0) {
            imageVector2 = imageVector;
            i2 = (startRestartGroup.changed(imageVector2) ? 4 : 2) | i;
        } else {
            imageVector2 = imageVector;
            i2 = i;
        }
        if ((i & 48) == 0) {
            str2 = str;
            i2 |= startRestartGroup.changed(str2) ? 32 : 16;
        } else {
            str2 = str;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if (!startRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-875643283, i2, -1, "uz.FonRo.pos.ui.catalog.PfSquareButton (ProductForm.kt:753)");
            }
            Modifier oxTap = ModifiersKt.oxTap(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(52.0f)), OxShape.INSTANCE.getField()), Ox.INSTANCE.m10241tintBg5vOe2sY(j, 0.2f), null, 2, null), false, function0, startRestartGroup, (i2 >> 3) & 896, 1);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1213840682, "C762@31895L90:ProductForm.kt#i65cod");
            IconKt.m2255Iconww6aTOc(imageVector2, str2, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(22.0f)), j, startRestartGroup, (i2 & 14) | 384 | (i2 & 112) | ((i2 << 3) & 7168), 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductFormKt.PfSquareButton_FNF3uiM$lambda$1(ImageVector.this, str, j, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* renamed from: MoneyLine-XO-JAsU, reason: not valid java name */
    private static final void m9815MoneyLineXOJAsU(final String str, final String str2, final long j, Composer composer, final int i) {
        int i2;
        String str3;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1947771223);
        ComposerKt.sourceInformation(startRestartGroup, "C(MoneyLine)P(!,2:c#ui.graphics.Color)768@32084L418:ProductForm.kt#i65cod");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            str3 = str2;
            i2 |= startRestartGroup.changed(str3) ? 32 : 16;
        } else {
            str3 = str2;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(j) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1947771223, i2, -1, "uz.FonRo.pos.ui.catalog.MoneyLine (ProductForm.kt:767)");
            }
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(4.0f), 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, startRestartGroup, 54);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1440313574, "C773@32290L67,774@32366L130:ProductForm.kt#i65cod");
            TextKt.m2798Text4IGK_g(str, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), startRestartGroup, i2 & 14, 0, 65532);
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str3, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowTitle(), j, 0L, FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composer2, (i2 >> 3) & 14, 0, 65534);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.ProductFormKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductFormKt.MoneyLine_XO_JAsU$lambda$1(str, str2, j, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String numText(String str) {
        String str2 = str;
        StringBuilder sb = new StringBuilder();
        int length = str2.length();
        for (int i = 0; i < length; i++) {
            char charAt = str2.charAt(i);
            if (Character.isDigit(charAt) || charAt == ',' || charAt == '.') {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }
}
