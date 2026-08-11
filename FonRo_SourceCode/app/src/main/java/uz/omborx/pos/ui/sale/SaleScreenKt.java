package uz.FonRo.pos.ui.sale;

import android.content.Context;
import androidx.camera.video.AudioStats;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.compose.SingletonAsyncImageKt;
import com.google.android.gms.actions.SearchIntents;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
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
import uz.FonRo.pos.core.Units;
import uz.FonRo.pos.data.local.CacheStore;
import uz.FonRo.pos.data.model.Category;
import uz.FonRo.pos.data.model.Paywall;
import uz.FonRo.pos.data.model.Plan;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.model.Store;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.ChipsKt;
import uz.FonRo.pos.ui.components.ModifiersKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxDim;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: SaleScreen.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0006\u001ao\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0017\u001aC\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u001a\u001aO\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\b$\u0010%\u001aG\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u001d2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010)\u001a\u00020*H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010+\u001a/\u0010,\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010/¨\u0006\u0002²\u0006\f\u00100\u001a\u0004\u0018\u000101X\u008a\u0084\u0002²\u0006\u0010\u00102\u001a\b\u0012\u0004\u0012\u00020\r03X\u008a\u0084\u0002²\u0006\u0010\u00104\u001a\b\u0012\u0004\u0012\u00020503X\u008a\u0084\u0002²\u0006\n\u00106\u001a\u000207X\u008a\u0084\u0002²\u0006\n\u00108\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u00109\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u0010:\u001a\u00020;X\u008a\u008e\u0002²\u0006\n\u0010<\u001a\u00020\u001fX\u008a\u008e\u0002²\u0006\n\u0010=\u001a\u00020\u001fX\u008a\u008e\u0002²\u0006\n\u0010>\u001a\u00020\u001fX\u008a\u008e\u0002²\u0006\f\u0010?\u001a\u0004\u0018\u00010@X\u008a\u008e\u0002²\u0006\n\u0010A\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010B\u001a\u00020\u001fX\u008a\u008e\u0002"}, d2 = {"SaleScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "ProductRow", "product", "Luz/FonRo/pos/data/model/Product;", "inCart", "", "lowStock", "", "onTap", "Lkotlin/Function0;", "onLongTap", "onPlus", "onMinus", "(Luz/FonRo/pos/data/model/Product;DILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "QtyStepper", "value", "(DLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "StepBtn", "sign", "", "enabled", "", "background", "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, "onClick", "StepBtn-eaDK9VM", "(Ljava/lang/String;ZJJLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "CartBar", "count", "totalText", "modifier", "Landroidx/compose/ui/Modifier;", "(ILjava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "PaywallBlock", "paywall", "Luz/FonRo/pos/data/model/Paywall;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/data/model/Paywall;Landroidx/compose/runtime/Composer;I)V", "store", "Luz/FonRo/pos/data/model/Store;", CacheStore.PRODUCTS, "", CacheStore.CATEGORIES, "Luz/FonRo/pos/data/model/Category;", "cart", "Luz/FonRo/pos/ui/sale/CartState;", SearchIntents.EXTRA_QUERY, "applied", "categoryId", "", "showCart", "showHeld", "showScanner", "qtyRequest", "Luz/FonRo/pos/ui/sale/QtyRequest;", "heldTick", "busy"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class SaleScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CartBar$lambda$1(int i, String str, Function0 function0, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        CartBar(i, str, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PaywallBlock$lambda$8(FonRoApp FonRoApp, Paywall paywall, int i, Composer composer, int i2) {
        PaywallBlock(FonRoApp, paywall, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ProductRow$lambda$1(Product product, double d, int i, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i2, Composer composer, int i3) {
        ProductRow(product, d, i, function0, function02, function03, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QtyStepper$lambda$1(double d, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        QtyStepper(d, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SaleScreen$lambda$1(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        SaleScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SaleScreen$lambda$42(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        SaleScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit StepBtn_eaDK9VM$lambda$1(String str, boolean z, long j, long j2, Function0 function0, int i, Composer composer, int i2) {
        m10137StepBtneaDK9VM(str, z, j, j2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x024d, code lost:
    
        if (r9 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SaleScreen(uz.FonRo.pos.FonRoApp r39, final uz.FonRo.pos.ui.nav.AppNavigator r40, androidx.compose.runtime.Composer r41, final int r42) {
        /*
            Method dump skipped, instructions count: 2402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.sale.SaleScreenKt.SaleScreen(uz.FonRo.pos.FonRoApp, uz.FonRo.pos.ui.nav.AppNavigator, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SaleScreen$lambda$6(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String SaleScreen$lambda$9(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final long SaleScreen$lambda$12(MutableState<Long> mutableState) {
        return mutableState.getValue().longValue();
    }

    private static final void SaleScreen$lambda$13(MutableState<Long> mutableState, long j) {
        mutableState.setValue(Long.valueOf(j));
    }

    private static final boolean SaleScreen$lambda$15(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void SaleScreen$lambda$16(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean SaleScreen$lambda$18(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void SaleScreen$lambda$19(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean SaleScreen$lambda$21(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void SaleScreen$lambda$22(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final QtyRequest SaleScreen$lambda$24(MutableState<QtyRequest> mutableState) {
        return mutableState.getValue();
    }

    private static final int SaleScreen$lambda$27(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void SaleScreen$lambda$28(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final void SaleScreen$openQtyPad(MutableState<QtyRequest> mutableState, Product product, boolean z) {
        mutableState.setValue(new QtyRequest(product, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SaleScreen$onTapProduct(MutableState<QtyRequest> mutableState, Product product) {
        if (CartStore.INSTANCE.freeQty(product) <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            Toaster.INSTANCE.error(LangKt.tx("«%s»: нет на складе", product.getName()));
        } else if (Units.INSTANCE.isMeasurable(product.getUnit())) {
            SaleScreen$openQtyPad(mutableState, product, false);
        } else {
            CartStore.add$default(CartStore.INSTANCE, product, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SaleScreen$onLongProduct(MutableState<QtyRequest> mutableState, Product product) {
        if (CartStore.INSTANCE.getCurrent().qtyOf(product.getId()) <= AudioStats.AUDIO_AMPLITUDE_NONE && CartStore.INSTANCE.freeQty(product) <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            Toaster.INSTANCE.error(LangKt.tx("«%s»: нет на складе", product.getName()));
        } else {
            SaleScreen$openQtyPad(mutableState, product, true);
        }
    }

    private static final void SaleScreen$handleCode(Repo repo, MutableState<Boolean> mutableState, MutableState<String> mutableState2, MutableState<QtyRequest> mutableState3, String str) {
        Product findByBarcode = repo.findByBarcode(str);
        if (findByBarcode == null) {
            SaleScreen$lambda$22(mutableState, false);
            mutableState2.setValue(str);
            Toaster.INSTANCE.error(LangKt.tx("Штрихкод %s не найден", str));
        } else if (Units.INSTANCE.isMeasurable(findByBarcode.getUnit())) {
            SaleScreen$lambda$22(mutableState, false);
            SaleScreen$openQtyPad(mutableState3, findByBarcode, false);
        } else {
            CartStore.add$default(CartStore.INSTANCE, findByBarcode, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleScreen$lambda$33$0(Repo repo, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        SaleScreen$handleCode(repo, mutableState, mutableState2, mutableState3, code);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleScreen$lambda$35$0$0(int i, final MutableState mutableState, final MutableState mutableState2, RowScope OxPageHead, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(OxPageHead, "$this$OxPageHead");
        ComposerKt.sourceInformation(composer, "C212@8288L22,212@8265L187,216@8513L19,215@8469L299:SaleScreen.kt#1sewlp");
        if (!composer.shouldExecute((i2 & 17) != 16, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(137692376, i2, -1, "uz.FonRo.pos.ui.sale.SaleScreen.<anonymous>.<anonymous>.<anonymous> (SaleScreen.kt:212)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -821611506, "CC(remember):SaleScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.sale.SaleScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SaleScreen$lambda$35$0$0$0$0;
                        SaleScreen$lambda$35$0$0$0$0 = SaleScreenKt.SaleScreen$lambda$35$0$0$0$0(MutableState.this);
                        return SaleScreen$lambda$35$0$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9831OxIconButtonhGBTI10((Function0) rememberedValue, null, null, 0.0f, ComposableSingletons$SaleScreenKt.INSTANCE.getLambda$12704211$app(), composer, 24582, 14);
            ComposerKt.sourceInformationMarkerStart(composer, -821604309, "CC(remember):SaleScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.sale.SaleScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SaleScreen$lambda$35$0$0$1$0;
                        SaleScreen$lambda$35$0$0$1$0 = SaleScreenKt.SaleScreen$lambda$35$0$0$1$0(MutableState.this);
                        return SaleScreen$lambda$35$0$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            Function0 function0 = (Function0) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9831OxIconButtonhGBTI10(function0, null, i > 0 ? String.valueOf(i) : null, 0.0f, ComposableSingletons$SaleScreenKt.INSTANCE.getLambda$1485491900$app(), composer, 24582, 10);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleScreen$lambda$35$0$0$0$0(MutableState mutableState) {
        SaleScreen$lambda$22(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleScreen$lambda$35$0$0$1$0(MutableState mutableState) {
        SaleScreen$lambda$19(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleScreen$lambda$35$0$1$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleScreen$lambda$35$0$2$0(Repo repo, MutableState mutableState, MutableState mutableState2) {
        Product findByBarcode;
        String obj = StringsKt.trim((CharSequence) SaleScreen$lambda$6(mutableState)).toString();
        if (obj.length() > 0 && (findByBarcode = repo.findByBarcode(obj)) != null) {
            mutableState.setValue("");
            if (CartStore.INSTANCE.freeQty(findByBarcode) <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                Toaster.INSTANCE.error(LangKt.tx("«%s»: нет на складе", findByBarcode.getName()));
            } else if (Units.INSTANCE.isMeasurable(findByBarcode.getUnit())) {
                SaleScreen$openQtyPad(mutableState2, findByBarcode, false);
            } else {
                CartStore.add$default(CartStore.INSTANCE, findByBarcode, null, 2, null);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleScreen$lambda$35$0$3(final MutableState mutableState, State state, RowScope OxChipRow, Composer composer, int i) {
        String str;
        boolean z;
        Intrinsics.checkNotNullParameter(OxChipRow, "$this$OxChipRow");
        ComposerKt.sourceInformation(composer, "C249@9961L19,249@9903L78,*254@10232L28,251@10081L201:SaleScreen.kt#1sewlp");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(973720408, i, -1, "uz.FonRo.pos.ui.sale.SaleScreen.<anonymous>.<anonymous>.<anonymous> (SaleScreen.kt:249)");
            }
            String tx = LangKt.tx("Все", new Object[0]);
            boolean z2 = SaleScreen$lambda$12(mutableState) == 0;
            ComposerKt.sourceInformationMarkerStart(composer, -557555989, "CC(remember):SaleScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.sale.SaleScreenKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SaleScreen$lambda$35$0$3$0$0;
                        SaleScreen$lambda$35$0$3$0$0 = SaleScreenKt.SaleScreen$lambda$35$0$3$0$0(MutableState.this);
                        return SaleScreen$lambda$35$0$3$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.m9837OxCatChipFV1VA1c(tx, z2, (Function0) rememberedValue, null, null, null, composer, 384, 56);
            List<Category> SaleScreen$lambda$3 = SaleScreen$lambda$3(state);
            ArrayList<Category> arrayList = new ArrayList();
            for (Object obj : SaleScreen$lambda$3) {
                if (((Category) obj).isArchived() == 0) {
                    arrayList.add(obj);
                }
            }
            for (final Category category : arrayList) {
                String name = category.getName();
                if (SaleScreen$lambda$12(mutableState) == category.getId()) {
                    str = name;
                    z = true;
                } else {
                    str = name;
                    z = false;
                }
                ComposerKt.sourceInformationMarkerStart(composer, -1587257839, "CC(remember):SaleScreen.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(category);
                Object rememberedValue2 = composer.rememberedValue();
                if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.sale.SaleScreenKt$$ExternalSyntheticLambda25
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SaleScreen$lambda$35$0$3$2$0$0;
                            SaleScreen$lambda$35$0$3$2$0$0 = SaleScreenKt.SaleScreen$lambda$35$0$3$2$0$0(Category.this, mutableState);
                            return SaleScreen$lambda$35$0$3$2$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ChipsKt.m9837OxCatChipFV1VA1c(str, z, (Function0) rememberedValue2, null, null, null, composer, 0, 56);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleScreen$lambda$35$0$3$0$0(MutableState mutableState) {
        SaleScreen$lambda$13(mutableState, 0L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleScreen$lambda$35$0$3$2$0$0(Category category, MutableState mutableState) {
        SaleScreen$lambda$13(mutableState, category.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleScreen$lambda$35$0$4$0(final List list, final MutableState mutableState, final int i, final State state, final MutableState mutableState2, LazyListScope LazyColumn) {
        LazyListScope lazyListScope;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        if (list.isEmpty()) {
            lazyListScope = LazyColumn;
            LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(478359287, true, new Function3() { // from class: uz.FonRo.pos.ui.sale.SaleScreenKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SaleScreen$lambda$35$0$4$0$0;
                    SaleScreen$lambda$35$0$4$0$0 = SaleScreenKt.SaleScreen$lambda$35$0$4$0$0(MutableState.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SaleScreen$lambda$35$0$4$0$0;
                }
            }), 3, null);
        } else {
            lazyListScope = LazyColumn;
        }
        final Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.sale.SaleScreenKt$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object SaleScreen$lambda$35$0$4$0$1;
                SaleScreen$lambda$35$0$4$0$1 = SaleScreenKt.SaleScreen$lambda$35$0$4$0$1((Product) obj);
                return SaleScreen$lambda$35$0$4$0$1;
            }
        };
        final SaleScreenKt$SaleScreen$lambda$35$0$4$0$$inlined$items$default$1 saleScreenKt$SaleScreen$lambda$35$0$4$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.sale.SaleScreenKt$SaleScreen$lambda$35$0$4$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Product product) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Product) obj);
            }
        };
        lazyListScope.items(list.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.sale.SaleScreenKt$SaleScreen$lambda$35$0$4$0$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i2) {
                return Function1.this.invoke(list.get(i2));
            }
        }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.sale.SaleScreenKt$SaleScreen$lambda$35$0$4$0$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i2) {
                return Function1.this.invoke(list.get(i2));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.sale.SaleScreenKt$SaleScreen$lambda$35$0$4$0$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i2, Composer composer, int i3) {
                int i4;
                CartState SaleScreen$lambda$4;
                ComposerKt.sourceInformation(composer, "C178@8826L22:LazyDsl.kt#428nma");
                if ((i3 & 6) == 0) {
                    i4 = (composer.changed(lazyItemScope) ? 4 : 2) | i3;
                } else {
                    i4 = i3;
                }
                if ((i3 & 48) == 0) {
                    i4 |= composer.changed(i2) ? 32 : 16;
                }
                if (!composer.shouldExecute((i4 & 147) != 146, i4 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, i4, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                final Product product = (Product) list.get(i2);
                composer.startReplaceGroup(-2082349632);
                ComposerKt.sourceInformation(composer, "C*278@11272L25,279@11335L26,280@11396L26,281@11458L81,274@11083L478:SaleScreen.kt#1sewlp");
                SaleScreen$lambda$4 = SaleScreenKt.SaleScreen$lambda$4(state);
                double qtyOf = SaleScreen$lambda$4.qtyOf(product.getId());
                int i5 = i;
                ComposerKt.sourceInformationMarkerStart(composer, -205714306, "CC(remember):SaleScreen.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(product);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState3 = mutableState2;
                    rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.sale.SaleScreenKt$SaleScreen$5$1$5$1$3$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            SaleScreenKt.SaleScreen$onTapProduct(mutableState3, Product.this);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                Function0 function0 = (Function0) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -205712289, "CC(remember):SaleScreen.kt#9igjgp");
                boolean changedInstance2 = composer.changedInstance(product);
                Object rememberedValue2 = composer.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState4 = mutableState2;
                    rememberedValue2 = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.sale.SaleScreenKt$SaleScreen$5$1$5$1$3$2$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            SaleScreenKt.SaleScreen$onLongProduct(mutableState4, Product.this);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                Function0 function02 = (Function0) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -205710337, "CC(remember):SaleScreen.kt#9igjgp");
                boolean changedInstance3 = composer.changedInstance(product);
                Object rememberedValue3 = composer.rememberedValue();
                if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.sale.SaleScreenKt$SaleScreen$5$1$5$1$3$3$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            CartStore.add$default(CartStore.INSTANCE, Product.this, null, 2, null);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue3);
                }
                Function0 function03 = (Function0) rememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -205708298, "CC(remember):SaleScreen.kt#9igjgp");
                boolean changedInstance4 = composer.changedInstance(product);
                Object rememberedValue4 = composer.rememberedValue();
                if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.sale.SaleScreenKt$SaleScreen$5$1$5$1$3$4$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            CartStore.INSTANCE.changeQty(Product.this.getId(), -CartStore.INSTANCE.stepOf(Product.this), Product.this.getQuantity());
                        }
                    };
                    composer.updateRememberedValue(rememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                SaleScreenKt.ProductRow(product, qtyOf, i5, function0, function02, function03, (Function0) rememberedValue4, composer, Product.$stable);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleScreen$lambda$35$0$4$0$0(MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C267@10728L232:SaleScreen.kt#1sewlp");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(478359287, i, -1, "uz.FonRo.pos.ui.sale.SaleScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SaleScreen.kt:267)");
            }
            BasicsKt.OxEmptyNote(StringsKt.isBlank(SaleScreen$lambda$9(mutableState)) ? LangKt.tx("Товаров нет. Добавьте их во вкладке «Товары».", new Object[0]) : LangKt.tx("Ничего не найдено. Проверьте название или штрихкод.", new Object[0]), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SaleScreen$lambda$35$0$4$0$1(Product it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleScreen$lambda$35$1$0(MutableState mutableState) {
        SaleScreen$lambda$16(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleScreen$lambda$36$0(MutableState mutableState, MutableState mutableState2) {
        SaleScreen$lambda$16(mutableState, false);
        SaleScreen$lambda$28(mutableState2, SaleScreen$lambda$27(mutableState2) + 1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleScreen$lambda$37$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        SaleScreen$lambda$19(mutableState, false);
        SaleScreen$lambda$28(mutableState2, SaleScreen$lambda$27(mutableState2) + 1);
        if (!CartStore.INSTANCE.getCurrent().getItems().isEmpty()) {
            SaleScreen$lambda$16(mutableState3, true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleScreen$lambda$38$0(MutableState mutableState, MutableState mutableState2) {
        SaleScreen$lambda$19(mutableState, false);
        SaleScreen$lambda$28(mutableState2, SaleScreen$lambda$27(mutableState2) + 1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleScreen$lambda$39$0(MutableState mutableState) {
        SaleScreen$lambda$22(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleScreen$lambda$40$0(MutableState mutableState, MutableState mutableState2) {
        SaleScreen$lambda$22(mutableState, false);
        SaleScreen$lambda$16(mutableState2, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleScreen$lambda$41$0$0(QtyRequest qtyRequest, Product product, double d, double d2) {
        if (qtyRequest.getReplace() && CartStore.INSTANCE.getCurrent().qtyOf(product.getId()) > AudioStats.AUDIO_AMPLITUDE_NONE) {
            CartStore.INSTANCE.setQty(product.getId(), d2, d);
        } else {
            CartStore.INSTANCE.add(product, Double.valueOf(d2));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleScreen$lambda$41$1$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleScreen$lambda$41$2$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProductRow(final Product product, final double d, int i, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, Composer composer, final int i2) {
        int i3;
        double d2;
        Function0<Unit> function05;
        Function0<Unit> function06;
        Composer composer2;
        long m10200getDim20d7_KjU;
        long j;
        final int i4 = i;
        Composer startRestartGroup = composer.startRestartGroup(1483170338);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProductRow)P(6!2,5!1,4)387@14593L2000:SaleScreen.kt#1sewlp");
        if ((i2 & 6) == 0) {
            i3 = ((i2 & 8) == 0 ? startRestartGroup.changed(product) : startRestartGroup.changedInstance(product) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            d2 = d;
            i3 |= startRestartGroup.changed(d2) ? 32 : 16;
        } else {
            d2 = d;
        }
        if ((i2 & 384) == 0) {
            i3 |= startRestartGroup.changed(i4) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            function05 = function0;
            i3 |= startRestartGroup.changedInstance(function05) ? 2048 : 1024;
        } else {
            function05 = function0;
        }
        if ((i2 & 24576) == 0) {
            function06 = function02;
            i3 |= startRestartGroup.changedInstance(function06) ? 16384 : 8192;
        } else {
            function06 = function02;
        }
        if ((196608 & i2) == 0) {
            i3 |= startRestartGroup.changedInstance(function03) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i3 |= startRestartGroup.changedInstance(function04) ? 1048576 : 524288;
        }
        if (!startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1483170338, i3, -1, "uz.FonRo.pos.ui.sale.ProductRow (SaleScreen.kt:380)");
            }
            double max = Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, product.getQuantity());
            if (max <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                j = Ox.INSTANCE.m10196getDanger0d7_KjU();
                i4 = i;
            } else {
                i4 = i;
                if (max <= i4) {
                    m10200getDim20d7_KjU = Ox.INSTANCE.m10213getOrange0d7_KjU();
                } else {
                    m10200getDim20d7_KjU = Ox.INSTANCE.m10200getDim20d7_KjU();
                }
                j = m10200getDim20d7_KjU;
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 837693714, "C388@14610L1957,441@16576L11:SaleScreen.kt#1sewlp");
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.m1084heightInVpY3zN4$default(ClickableKt.m600combinedClickablef5TDLPQ$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, null, null, null, function06, null, false, function05, 111, null), OxDim.INSTANCE.m10247getRowMinD9Ej5fM(), 0.0f, 2, null), 0.0f, Dp.m6989constructorimpl(9.0f), 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -54354261, "C397@15001L571,397@14993L579,412@15585L477,428@16244L175,435@16433L124:SaleScreen.kt#1sewlp");
            BasicsKt.m9834OxThumbPZHvWI(null, 0.0f, 0L, ComposableLambdaKt.rememberComposableLambda(-2080632668, true, new Function3() { // from class: uz.FonRo.pos.ui.sale.SaleScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ProductRow$lambda$0$0$0;
                    ProductRow$lambda$0$0$0 = SaleScreenKt.ProductRow$lambda$0$0$0(Product.this, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ProductRow$lambda$0$0$0;
                }
            }, startRestartGroup, 54), startRestartGroup, 3072, 7);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1130137872, "C413@15631L189,419@15837L211:SaleScreen.kt#1sewlp");
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(product.getName(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), composer2, 0, 3120, 55294);
            TextKt.m2798Text4IGK_g(LangKt.tx("остаток: %s %s", Fmt.INSTANCE.qf(Double.valueOf(max)), Units.INSTANCE.name(product.getUnit())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowSub(), j, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer2, 0, 3072, 57342);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.nf(Double.valueOf(product.getSalePrice())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6866boximpl(TextAlign.INSTANCE.m6874getEnde0LSkKk()), 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowPrice(), composer2, 0, 3072, 56830);
            QtyStepper(d2, function04, function03, composer2, ((i3 >> 3) & 14) | ((i3 >> 15) & 112) | ((i3 >> 9) & 896));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.sale.SaleScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SaleScreenKt.ProductRow$lambda$1(Product.this, d, i4, function0, function02, function03, function04, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductRow$lambda$0$0$0(Product product, BoxScope OxThumb, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxThumb, "$this$OxThumb");
        ComposerKt.sourceInformation(composer, "C398@15019L151:SaleScreen.kt#1sewlp");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxThumb) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2080632668, i2, -1, "uz.FonRo.pos.ui.sale.ProductRow.<anonymous>.<anonymous>.<anonymous> (SaleScreen.kt:398)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getBox(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(22.0f)), Ox.INSTANCE.m10200getDim20d7_KjU(), composer, 432, 0);
            String photo = product.getPhoto();
            String str = photo;
            if (str != null && !StringsKt.isBlank(str)) {
                composer.startReplaceGroup(840487353);
                ComposerKt.sourceInformation(composer, "404@15279L261");
                SingletonAsyncImageKt.m7640AsyncImagegl8XCv8(photo, null, ClipKt.clip(OxThumb.matchParentSize(Modifier.INSTANCE), OxShape.INSTANCE.getImg()), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, false, null, composer, 1572912, 0, 4024);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(840756030);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void QtyStepper(final double d, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
        int i2;
        Function0<Unit> function03;
        Composer startRestartGroup = composer.startRestartGroup(-490202854);
        ComposerKt.sourceInformation(startRestartGroup, "C(QtyStepper)P(2)460@17153L1242:SaleScreen.kt#1sewlp");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(d) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            function03 = function02;
            i2 |= startRestartGroup.changedInstance(function03) ? 256 : 128;
        } else {
            function03 = function02;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-490202854, i2, -1, "uz.FonRo.pos.ui.sale.QtyStepper (SaleScreen.kt:458)");
            }
            boolean z = d > AudioStats.AUDIO_AMPLITUDE_NONE;
            Modifier m1049padding3ABfNKs = PaddingKt.m1049padding3ABfNKs(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, OxShape.INSTANCE.getField()), Ox.INSTANCE.m10229getSegTrack0d7_KjU(), null, 2, null), Dp.m6989constructorimpl(3.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(3.0f));
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 770788215, "C468@17415L387,478@17811L403,487@18223L166:SaleScreen.kt#1sewlp");
            long m10217getPanel0d7_KjU = Ox.INSTANCE.m10217getPanel0d7_KjU();
            Ox ox = Ox.INSTANCE;
            m10137StepBtneaDK9VM("−", z, m10217getPanel0d7_KjU, z ? ox.m10233getText0d7_KjU() : ox.m10200getDim20d7_KjU(), function0, startRestartGroup, ((i2 << 9) & 57344) | 6);
            String qf = z ? Fmt.INSTANCE.qf(Double.valueOf(d)) : "0";
            TextStyle rowTitle = OxType.INSTANCE.getRowTitle();
            Ox ox2 = Ox.INSTANCE;
            TextKt.m2798Text4IGK_g(qf, SizeKt.m1101width3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(38.0f)), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6866boximpl(TextAlign.INSTANCE.m6873getCentere0LSkKk()), 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(rowTitle, z ? ox2.m10220getPrimary0d7_KjU() : ox2.m10200getDim20d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), startRestartGroup, 48, 3072, 56828);
            startRestartGroup = startRestartGroup;
            m10137StepBtneaDK9VM("+", true, Ox.INSTANCE.m10220getPrimary0d7_KjU(), Ox.INSTANCE.m10217getPanel0d7_KjU(), function03, startRestartGroup, ((i2 << 6) & 57344) | 54);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.sale.SaleScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SaleScreenKt.QtyStepper$lambda$1(d, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* renamed from: StepBtn-eaDK9VM, reason: not valid java name */
    private static final void m10137StepBtneaDK9VM(final String str, final boolean z, final long j, final long j2, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(383034079);
        ComposerKt.sourceInformation(startRestartGroup, "C(StepBtn)P(4,2,0:c#ui.graphics.Color,1:c#ui.graphics.Color)505@18545L332:SaleScreen.kt#1sewlp");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 2048 : 1024;
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
                ComposerKt.traceEventStart(383034079, i3, -1, "uz.FonRo.pos.ui.sale.StepBtn (SaleScreen.kt:504)");
            }
            Modifier oxClickable$default = ModifiersKt.oxClickable$default(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(38.0f)), OxShape.INSTANCE.getTile()), z ? j : Ox.INSTANCE.m10236getTrack0d7_KjU(), null, 2, null), z, null, 0L, function0, 6, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, oxClickable$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1722626695, "C513@18822L49:SaleScreen.kt#1sewlp");
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH2(), j2, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer2, i3 & 14, 0, 65534);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.sale.SaleScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SaleScreenKt.StepBtn_eaDK9VM$lambda$1(str, z, j, j2, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void CartBar(final int r65, final java.lang.String r66, final kotlin.jvm.functions.Function0<kotlin.Unit> r67, androidx.compose.ui.Modifier r68, androidx.compose.runtime.Composer r69, final int r70, final int r71) {
        /*
            Method dump skipped, instructions count: 1092
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.sale.SaleScreenKt.CartBar(int, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0488, code lost:
    
        if (r12.changedInstance(r3) != false) goto L100;
     */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0552  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void PaywallBlock(uz.FonRo.pos.FonRoApp r67, final uz.FonRo.pos.data.model.Paywall r68, androidx.compose.runtime.Composer r69, final int r70) {
        /*
            Method dump skipped, instructions count: 1389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.sale.SaleScreenKt.PaywallBlock(uz.FonRo.pos.FonRoApp, uz.FonRo.pos.data.model.Paywall, androidx.compose.runtime.Composer, int):void");
    }

    private static final boolean PaywallBlock$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PaywallBlock$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void PaywallBlock$openCheckout(uz.FonRo.pos.data.model.Paywall r2, android.content.Context r3, java.lang.String r4) {
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
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.sale.SaleScreenKt.PaywallBlock$openCheckout(uz.FonRo.pos.data.model.Paywall, android.content.Context, java.lang.String):void");
    }

    private static final void PaywallBlock$refresh(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, FonRoApp FonRoApp) {
        if (PaywallBlock$lambda$1(mutableState)) {
            return;
        }
        PaywallBlock$lambda$2(mutableState, true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SaleScreenKt$PaywallBlock$refresh$1(FonRoApp, mutableState, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallBlock$lambda$7$0$0$0(Plan plan, Paywall paywall, Context context) {
        PaywallBlock$openCheckout(paywall, context, plan.getCheckoutUrl());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallBlock$lambda$7$0$1(Plan plan, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C657@23859L800:SaleScreen.kt#1sewlp");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1420928847, i, -1, "uz.FonRo.pos.ui.sale.PaywallBlock.<anonymous>.<anonymous>.<anonymous> (SaleScreen.kt:657)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1076804497, "C662@24100L407,671@24528L49,672@24598L43:SaleScreen.kt#1sewlp");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1672786413, "C663@24154L34,664@24213L272:SaleScreen.kt#1sewlp");
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
    public static final Unit PaywallBlock$lambda$7$1$0(Paywall paywall, Context context) {
        PaywallBlock$openCheckout(paywall, context, paywall.getCheckoutUrl());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaywallBlock$lambda$7$2$0(CoroutineScope coroutineScope, MutableState mutableState, FonRoApp FonRoApp) {
        PaywallBlock$refresh(coroutineScope, mutableState, FonRoApp);
        return Unit.INSTANCE;
    }

    private static final Store SaleScreen$lambda$0(State<Store> state) {
        return state.getValue();
    }

    private static final List<Product> SaleScreen$lambda$2(State<? extends List<Product>> state) {
        return state.getValue();
    }

    private static final List<Category> SaleScreen$lambda$3(State<? extends List<Category>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CartState SaleScreen$lambda$4(State<CartState> state) {
        return state.getValue();
    }
}
