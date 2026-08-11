package uz.FonRo.pos.ui.more;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.JsonElement;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.Lang;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.OxLanguage;
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.core.TextScale;
import uz.FonRo.pos.data.local.SaleOutbox;
import uz.FonRo.pos.data.model.Coupon;
import uz.FonRo.pos.data.model.Paywall;
import uz.FonRo.pos.data.model.Plan;
import uz.FonRo.pos.data.model.Store;
import uz.FonRo.pos.data.model.User;
import uz.FonRo.pos.data.net.ApiClient;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnSize;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.ChipTone;
import uz.FonRo.pos.ui.components.FieldsKt;
import uz.FonRo.pos.ui.components.ModifiersKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.nav.Routes;
import uz.FonRo.pos.ui.shell.MainShellKt;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxAppearance;
import uz.FonRo.pos.ui.theme.OxDim;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxTheme;
import uz.FonRo.pos.ui.theme.OxType;
import uz.FonRo.pos.work.BackgroundWork;

/* compiled from: MoreScreen.kt */
@Metadata(d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a/\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007b\u0002\b\u000eb\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\u0002\u0010\r\u001a'\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0003H\u0003b\u0002\b\u000eb\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\u0002\u0010\u0014\u001a'\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0003b\u0002\b\u000eb\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\u0002\u0010\u0018\u001a{\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0!2\b\b\u0002\u0010\"\u001a\u00020#2 \b\u0002\u0010$\u001a\u001a\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\b\u0018\u00010%¢\u0006\u0002\b\u000e¢\u0006\u0002\b'H\u0003b\u0002\b\u000eb\f\b*\u0012\b\b+\u0012\u0004\b\b(,¢\u0006\u0004\b(\u0010)\u001a?\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u0003H\u0003b\u0002\b\u000eb\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\u0002\u00102\u001a¿\u0001\u00103\u001a\u00020\b2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020#2\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\u00032\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0%2\u0006\u0010<\u001a\u00020\u00032\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0%2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\b0!2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\b0!2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\b0!2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\b0!2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\b0!H\u0003b\u0002\b\u000eb\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\u0002\u0010C\u001a£\u0001\u0010D\u001a\u00020\b2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020#2\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\u00032\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0%2\u0006\u0010<\u001a\u00020\u00032\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0%2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\b0!2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\b0!2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\b0!H\u0003b\u0002\b\u000eb\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\u0002\u0010E\u001a@\u0010F\u001a\u00020\b2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00012\u0011\u0010H\u001a\r\u0012\u0004\u0012\u00020\b0!¢\u0006\u0002\b\u000eH\u0003b\u0002\b\u000eb\f\b*\u0012\b\b+\u0012\u0004\b\b(J¢\u0006\u0002\u0010I\u001a7\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u0003H\u0003b\u0002\b\u000eb\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\u0002\u0010N\u001a=\u0010O\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010P\u001a\u00020#2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0!H\u0003b\u0002\b\u000eb\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\u0002\u0010Q\u001a1\u0010R\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0003b\u0002\b\u000eb\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\u0004\bS\u0010T\u001a\u0018\u0010U\u001a\u00020\b2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u0003H\u0002\u001a$\u0010Y\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u0001052\u0006\u0010<\u001a\u00020\u00032\b\u00108\u001a\u0004\u0018\u000109H\u0002\u001a\u0014\u0010Z\u001a\u0004\u0018\u0001052\b\u0010[\u001a\u0004\u0018\u00010\\H\u0002\"&\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\" \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t²\u0006\f\u0010]\u001a\u0004\u0018\u00010^X\u008a\u0084\u0002²\u0006\f\u0010_\u001a\u0004\u0018\u00010`X\u008a\u0084\u0002²\u0006\n\u0010a\u001a\u00020bX\u008a\u0084\u0002²\u0006\u0010\u0010c\u001a\b\u0012\u0004\u0012\u00020d0\u0001X\u008a\u0084\u0002²\u0006\n\u0010e\u001a\u00020bX\u008a\u008e\u0002²\u0006\n\u0010f\u001a\u00020bX\u008a\u008e\u0002²\u0006\n\u0010g\u001a\u00020#X\u008a\u008e\u0002²\u0006\n\u0010h\u001a\u00020#X\u008a\u008e\u0002²\u0006\n\u0010i\u001a\u00020#X\u008a\u008e\u0002²\u0006\n\u0010j\u001a\u00020#X\u008a\u008e\u0002²\u0006\n\u0010k\u001a\u00020#X\u008a\u008e\u0002²\u0006\n\u0010l\u001a\u00020#X\u008a\u008e\u0002²\u0006\n\u0010m\u001a\u00020#X\u008a\u008e\u0002²\u0006\n\u0010n\u001a\u00020oX\u008a\u008e\u0002²\u0006\n\u0010p\u001a\u00020#X\u008a\u008e\u0002²\u0006\n\u0010q\u001a\u00020#X\u008a\u008e\u0002²\u0006\n\u0010r\u001a\u00020#X\u008a\u008e\u0002²\u0006\f\u00108\u001a\u0004\u0018\u000109X\u008a\u008e\u0002²\u0006\n\u0010:\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010s\u001a\u00020#X\u008a\u008e\u0002²\u0006\n\u0010<\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"CURRENCIES", "", "Lkotlin/Pair;", "", "getCURRENCIES", "()Ljava/util/List;", "RAW_CURRENCIES", "MoreScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "SetLabel", "text", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "ThemeSwatch", "mode", "Luz/FonRo/pos/ui/theme/OxAppearance;", "(Luz/FonRo/pos/ui/theme/OxAppearance;Landroidx/compose/runtime/Composer;I)V", "SetRow", "title", "value", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "tint", "Landroidx/compose/ui/graphics/Color;", "onClick", "Lkotlin/Function0;", "divider", "", "trailing", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "SetRow-hYmLsZ8", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;JLkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/runtime/ComposableInferredTarget;", "scheme", "[androidx.compose.ui.UiComposable[_]]", "StoreHero", "storeName", "userName", "role", "email", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "SubscriptionBlock", "paywall", "Luz/FonRo/pos/data/model/Paywall;", "canBilling", "busy", FirebaseAnalytics.Param.COUPON, "Luz/FonRo/pos/data/model/Coupon;", "couponInput", "onCouponInput", "planKey", "onPlanKey", "onApplyCoupon", "onCheckout", "onRefresh", "onCancel", "onResume", "(Luz/FonRo/pos/data/model/Paywall;ZZLuz/FonRo/pos/data/model/Coupon;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "OfferCard", "(Luz/FonRo/pos/data/model/Paywall;ZZLuz/FonRo/pos/data/model/Coupon;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "GradientCard", "colors", FirebaseAnalytics.Param.CONTENT, "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]", "GradientHead", "emoji", "subtitle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "GlassButton", "enabled", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "LinkIcon", "LinkIcon-RPmYEkk", "(Landroidx/compose/ui/graphics/vector/ImageVector;JLandroidx/compose/runtime/Composer;I)V", "openExternal", "context", "Landroid/content/Context;", ImagesContract.URL, "checkoutUrl", "paywallFrom", "data", "Lkotlinx/serialization/json/JsonElement;", "user", "Luz/FonRo/pos/data/model/User;", "store", "Luz/FonRo/pos/data/model/Store;", "ordersNew", "", Routes.OUTBOX, "Luz/FonRo/pos/data/local/SaleOutbox$Pending;", "lowStock", "receiptWidth", "autoPrint", "lowStockPad", "currencySheet", "widthSheet", "textSheet", "themeSheet", "langSheet", "textStep", "", "accessSheet", "logoutConfirm", "cancelConfirm", "billingBusy"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class MoreScreenKt {
    private static final List<Pair<String, String>> RAW_CURRENCIES = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("UZS", "сум · Узбекистан"), TuplesKt.to("USD", "доллар США"), TuplesKt.to("EUR", "евро"), TuplesKt.to("RUB", "российский рубль"), TuplesKt.to("KZT", "тенге"), TuplesKt.to("KGS", "сом"), TuplesKt.to("TJS", "сомони"), TuplesKt.to("TRY", "лира"), TuplesKt.to("CNY", "юань"), TuplesKt.to("INR", "рупия · Индия"), TuplesKt.to("VND", "донг"), TuplesKt.to("MYR", "ринггит"), TuplesKt.to("IDR", "рупия · Индонезия"), TuplesKt.to("THB", "бат"), TuplesKt.to("PHP", "песо"), TuplesKt.to("AED", "дирхам"), TuplesKt.to("GBP", "фунт"), TuplesKt.to("JPY", "иена"), TuplesKt.to("KRW", "вона"), TuplesKt.to("AZN", "манат"), TuplesKt.to("NONE", "Не показывать")});

    /* compiled from: MoreScreen.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes7.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OxAppearance.values().length];
            try {
                iArr[OxAppearance.LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OxAppearance.BLUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OxAppearance.DARK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OxAppearance.SYSTEM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit GlassButton$lambda$1(String str, boolean z, Function0 function0, int i, Composer composer, int i2) {
        GlassButton(str, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit GradientCard$lambda$1(List list, Function2 function2, int i, Composer composer, int i2) {
        GradientCard(list, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit GradientHead$lambda$1(String str, String str2, String str3, int i, Composer composer, int i2) {
        GradientHead(str, str2, str3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LinkIcon_RPmYEkk$lambda$1(ImageVector imageVector, long j, int i, Composer composer, int i2) {
        m10045LinkIconRPmYEkk(imageVector, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MoreScreen$lambda$76(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        MoreScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OfferCard$lambda$1(Paywall paywall, boolean z, boolean z2, Coupon coupon, String str, Function1 function1, String str2, Function1 function12, Function0 function0, Function0 function02, Function0 function03, int i, int i2, Composer composer, int i3) {
        OfferCard(paywall, z, z2, coupon, str, function1, str2, function12, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SetLabel$lambda$0(String str, int i, Composer composer, int i2) {
        SetLabel(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SetRow_hYmLsZ8$lambda$1(String str, String str2, ImageVector imageVector, long j, Function0 function0, boolean z, Function3 function3, int i, int i2, Composer composer, int i3) {
        m10046SetRowhYmLsZ8(str, str2, imageVector, j, function0, z, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit StoreHero$lambda$1(String str, String str2, String str3, String str4, int i, Composer composer, int i2) {
        StoreHero(str, str2, str3, str4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SubscriptionBlock$lambda$5(Paywall paywall, boolean z, boolean z2, Coupon coupon, String str, Function1 function1, String str2, Function1 function12, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, int i, int i2, Composer composer, int i3) {
        SubscriptionBlock(paywall, z, z2, coupon, str, function1, str2, function12, function0, function02, function03, function04, function05, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ThemeSwatch$lambda$1(OxAppearance oxAppearance, int i, Composer composer, int i2) {
        ThemeSwatch(oxAppearance, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final List<Pair<String, String>> getCURRENCIES() {
        List<Pair<String, String>> list = RAW_CURRENCIES;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            arrayList.add(TuplesKt.to(pair.getFirst(), LangKt.tx((String) pair.getSecond(), new Object[0])));
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:223:0x03e8, code lost:
    
        if (r1 == null) goto L115;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void MoreScreen(final uz.FonRo.pos.FonRoApp r53, final uz.FonRo.pos.ui.nav.AppNavigator r54, androidx.compose.runtime.Composer r55, final int r56) {
        /*
            Method dump skipped, instructions count: 2535
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.more.MoreScreenKt.MoreScreen(uz.FonRo.pos.FonRoApp, uz.FonRo.pos.ui.nav.AppNavigator, androidx.compose.runtime.Composer, int):void");
    }

    private static final int MoreScreen$lambda$5(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void MoreScreen$lambda$6(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final int MoreScreen$lambda$8(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void MoreScreen$lambda$9(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final boolean MoreScreen$lambda$11(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void MoreScreen$lambda$12(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean MoreScreen$lambda$14(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void MoreScreen$lambda$15(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean MoreScreen$lambda$17(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void MoreScreen$lambda$18(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean MoreScreen$lambda$20(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void MoreScreen$lambda$21(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean MoreScreen$lambda$23(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void MoreScreen$lambda$24(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean MoreScreen$lambda$26(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void MoreScreen$lambda$27(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean MoreScreen$lambda$29(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void MoreScreen$lambda$30(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final float MoreScreen$lambda$32(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    private static final void MoreScreen$lambda$33(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    private static final boolean MoreScreen$lambda$35(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void MoreScreen$lambda$36(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean MoreScreen$lambda$38(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void MoreScreen$lambda$39(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean MoreScreen$lambda$41(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void MoreScreen$lambda$42(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Coupon MoreScreen$lambda$44(MutableState<Coupon> mutableState) {
        return mutableState.getValue();
    }

    private static final String MoreScreen$lambda$47(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean MoreScreen$lambda$50(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MoreScreen$lambda$51(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String MoreScreen$lambda$53(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object MoreScreen$pullEntitlement(uz.FonRo.pos.data.repo.Repo r6, kotlin.coroutines.Continuation<? super uz.FonRo.pos.data.model.Paywall> r7) {
        /*
            boolean r0 = r7 instanceof uz.FonRo.pos.ui.more.MoreScreenKt$MoreScreen$pullEntitlement$1
            if (r0 == 0) goto L14
            r0 = r7
            uz.FonRo.pos.ui.more.MoreScreenKt$MoreScreen$pullEntitlement$1 r0 = (uz.FonRo.pos.ui.more.MoreScreenKt$MoreScreen$pullEntitlement$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            uz.FonRo.pos.ui.more.MoreScreenKt$MoreScreen$pullEntitlement$1 r0 = new uz.FonRo.pos.ui.more.MoreScreenKt$MoreScreen$pullEntitlement$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 != r4) goto L35
            java.lang.Object r6 = r0.L$1
            uz.FonRo.pos.data.net.ApiClient r6 = (uz.FonRo.pos.data.net.ApiClient) r6
            java.lang.Object r0 = r0.L$0
            uz.FonRo.pos.data.repo.Repo r0 = (uz.FonRo.pos.data.repo.Repo) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L33
            goto L5b
        L33:
            r6 = move-exception
            goto L6d
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result$Companion r7 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L6a
            uz.FonRo.pos.data.net.ApiClient r7 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> L6a
            uz.FonRo.pos.data.net.ApiClient r2 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> L6a
            uz.FonRo.pos.data.net.ApiService r2 = r2.api()     // Catch: java.lang.Throwable -> L6a
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L6a
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L6a
            r0.label = r4     // Catch: java.lang.Throwable -> L6a
            java.lang.Object r0 = r2.entitlement(r0)     // Catch: java.lang.Throwable -> L6a
            if (r0 != r1) goto L57
            return r1
        L57:
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
        L5b:
            retrofit2.Response r7 = (retrofit2.Response) r7     // Catch: java.lang.Throwable -> L33
            r1 = 0
            r2 = 2
            java.lang.Object r6 = uz.FonRo.pos.data.net.ApiClient.unwrap$default(r6, r7, r1, r2, r3)     // Catch: java.lang.Throwable -> L33
            uz.FonRo.pos.data.model.Paywall r6 = (uz.FonRo.pos.data.model.Paywall) r6     // Catch: java.lang.Throwable -> L33
            java.lang.Object r6 = kotlin.Result.m7870constructorimpl(r6)     // Catch: java.lang.Throwable -> L33
            goto L77
        L6a:
            r7 = move-exception
            r0 = r6
            r6 = r7
        L6d:
            kotlin.Result$Companion r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m7870constructorimpl(r6)
        L77:
            boolean r7 = kotlin.Result.m7877isSuccessimpl(r6)
            if (r7 == 0) goto L83
            r7 = r6
            uz.FonRo.pos.data.model.Paywall r7 = (uz.FonRo.pos.data.model.Paywall) r7
            r0.updatePaywall(r7)
        L83:
            boolean r7 = kotlin.Result.m7876isFailureimpl(r6)
            if (r7 == 0) goto L8a
            goto L8b
        L8a:
            r3 = r6
        L8b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.more.MoreScreenKt.MoreScreen$pullEntitlement(uz.FonRo.pos.data.repo.Repo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final void MoreScreen$runBilling(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, Repo repo, Function1<? super Continuation<? super JsonElement>, ? extends Object> function1, String str) {
        if (MoreScreen$lambda$50(mutableState)) {
            return;
        }
        MoreScreen$lambda$51(mutableState, true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MoreScreenKt$MoreScreen$runBilling$1(function1, repo, str, mutableState, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0(Paywall paywall, final State state, final State state2, final Repo repo, final MutableState mutableState, final CoroutineScope coroutineScope, final Context context, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final List list, final FonRoApp FonRoApp, final AppNavigator appNavigator, final boolean z, final MutableState mutableState6, final MutableState mutableState7, final MutableState mutableState8, final MutableState mutableState9, final MutableState mutableState10, final MutableState mutableState11, final MutableState mutableState12, final MutableState mutableState13, final MutableState mutableState14, final MutableState mutableState15, final MutableState mutableState16, final MutableState mutableState17, LazyListScope LazyColumn) {
        final Context context2;
        String slug;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$MoreScreenKt.INSTANCE.getLambda$813029750$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1928479981, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit MoreScreen$lambda$58$0$0;
                MoreScreen$lambda$58$0$0 = MoreScreenKt.MoreScreen$lambda$58$0$0(State.this, state2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return MoreScreen$lambda$58$0$0;
            }
        }), 3, null);
        String str = null;
        if (paywall != null) {
            final Paywall paywall2 = (paywall.getEnabled() || paywall.getSubscribed()) ? paywall : null;
            if (paywall2 != null) {
                LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1849256579, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit MoreScreen$lambda$58$0$2$0;
                        MoreScreen$lambda$58$0$2$0 = MoreScreenKt.MoreScreen$lambda$58$0$2$0(Paywall.this, repo, mutableState, coroutineScope, context, mutableState2, mutableState3, mutableState4, mutableState5, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return MoreScreen$lambda$58$0$2$0;
                    }
                }), 3, null);
            }
        }
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1400924498, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit MoreScreen$lambda$58$0$3;
                MoreScreen$lambda$58$0$3 = MoreScreenKt.MoreScreen$lambda$58$0$3(list, FonRoApp, appNavigator, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return MoreScreen$lambda$58$0$3;
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$MoreScreenKt.INSTANCE.m10021getLambda$435361681$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(530201136, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit MoreScreen$lambda$58$0$4;
                MoreScreen$lambda$58$0$4 = MoreScreenKt.MoreScreen$lambda$58$0$4(z, repo, FonRoApp, appNavigator, state, mutableState6, mutableState7, mutableState8, mutableState9, mutableState10, mutableState11, mutableState12, mutableState13, mutableState14, mutableState15, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return MoreScreen$lambda$58$0$4;
            }
        }), 3, null);
        User MoreScreen$lambda$0 = MoreScreen$lambda$0(state2);
        if (MoreScreen$lambda$0 != null && MoreScreen$lambda$0.isOwnerLike()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$MoreScreenKt.INSTANCE.getLambda$221539857$app(), 3, null);
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(834023624, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit MoreScreen$lambda$58$0$5;
                    MoreScreen$lambda$58$0$5 = MoreScreenKt.MoreScreen$lambda$58$0$5(State.this, mutableState16, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return MoreScreen$lambda$58$0$5;
                }
            }), 3, null);
        }
        Store MoreScreen$lambda$1 = MoreScreen$lambda$1(state);
        if (MoreScreen$lambda$1 != null && (slug = MoreScreen$lambda$1.getSlug()) != null) {
            str = StringsKt.trim((CharSequence) slug).toString();
        }
        if (str == null) {
            str = "";
        }
        final String str2 = str;
        if (str2.length() > 0) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$MoreScreenKt.INSTANCE.getLambda$442375880$app(), 3, null);
            context2 = context;
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(628756415, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit MoreScreen$lambda$58$0$6;
                    MoreScreen$lambda$58$0$6 = MoreScreenKt.MoreScreen$lambda$58$0$6(str2, context2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return MoreScreen$lambda$58$0$6;
                }
            }), 3, null);
        } else {
            context2 = context;
        }
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$MoreScreenKt.INSTANCE.getLambda$1495763953$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1833640526, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit MoreScreen$lambda$58$0$7;
                MoreScreen$lambda$58$0$7 = MoreScreenKt.MoreScreen$lambda$58$0$7(context2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return MoreScreen$lambda$58$0$7;
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-868077709, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit MoreScreen$lambda$58$0$8;
                MoreScreen$lambda$58$0$8 = MoreScreenKt.MoreScreen$lambda$58$0$8(MutableState.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return MoreScreen$lambda$58$0$8;
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$MoreScreenKt.INSTANCE.getLambda$97485108$app(), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$0(State state, State state2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C234@9170L224,240@9407L11:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1928479981, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous>.<anonymous> (MoreScreen.kt:234)");
            }
            Store MoreScreen$lambda$1 = MoreScreen$lambda$1(state);
            String name = MoreScreen$lambda$1 != null ? MoreScreen$lambda$1.getName() : null;
            String str = name == null ? "" : name;
            User MoreScreen$lambda$0 = MoreScreen$lambda$0(state2);
            String fullName = MoreScreen$lambda$0 != null ? MoreScreen$lambda$0.getFullName() : null;
            String str2 = fullName == null ? "" : fullName;
            Perm perm = Perm.INSTANCE;
            User MoreScreen$lambda$02 = MoreScreen$lambda$0(state2);
            String roleName = perm.roleName(MoreScreen$lambda$02 != null ? MoreScreen$lambda$02.getRole() : null);
            User MoreScreen$lambda$03 = MoreScreen$lambda$0(state2);
            String email = MoreScreen$lambda$03 != null ? MoreScreen$lambda$03.getEmail() : null;
            StoreHero(str, str2, roleName, email == null ? "" : email, composer, 0);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(16.0f), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0091, code lost:
    
        if (r8 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit MoreScreen$lambda$58$0$2$0(final uz.FonRo.pos.data.model.Paywall r17, final uz.FonRo.pos.data.repo.Repo r18, final androidx.compose.runtime.MutableState r19, final kotlinx.coroutines.CoroutineScope r20, final android.content.Context r21, final androidx.compose.runtime.MutableState r22, final androidx.compose.runtime.MutableState r23, final androidx.compose.runtime.MutableState r24, final androidx.compose.runtime.MutableState r25, androidx.compose.foundation.lazy.LazyItemScope r26, androidx.compose.runtime.Composer r27, int r28) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.more.MoreScreenKt.MoreScreen$lambda$58$0$2$0(uz.FonRo.pos.data.model.Paywall, uz.FonRo.pos.data.repo.Repo, androidx.compose.runtime.MutableState, kotlinx.coroutines.CoroutineScope, android.content.Context, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$2$0$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String upperCase = it.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        mutableState.setValue(upperCase);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$2$0$1$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$2$0$2$0(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        String upperCase = StringsKt.trim((CharSequence) MoreScreen$lambda$47(mutableState)).toString().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        if (!StringsKt.isBlank(upperCase) && !MoreScreen$lambda$50(mutableState2)) {
            MoreScreen$lambda$51(mutableState2, true);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MoreScreenKt$MoreScreen$1$1$3$1$3$1$1(upperCase, mutableState3, mutableState2, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$2$0$3$0(Context context, Paywall paywall, MutableState mutableState, MutableState mutableState2) {
        openExternal(context, checkoutUrl(paywall, MoreScreen$lambda$53(mutableState), MoreScreen$lambda$44(mutableState2)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$2$0$4$0(CoroutineScope coroutineScope, MutableState mutableState, Repo repo) {
        if (!MoreScreen$lambda$50(mutableState)) {
            MoreScreen$lambda$51(mutableState, true);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MoreScreenKt$MoreScreen$1$1$3$1$5$1$1(repo, mutableState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$2$0$5$0(MutableState mutableState) {
        MoreScreen$lambda$42(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$2$0$6$0(CoroutineScope coroutineScope, MutableState mutableState, Repo repo) {
        MoreScreen$runBilling(coroutineScope, mutableState, repo, new MoreScreenKt$MoreScreen$1$1$3$1$7$1$1(null), LangKt.tx("Подписка возобновлена", new Object[0]));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$3(final List list, final FonRoApp FonRoApp, final AppNavigator appNavigator, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C311@12755L906,311@12748L913,332@13674L11:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1400924498, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous>.<anonymous> (MoreScreen.kt:311)");
            }
            BasicsKt.OxList(null, ComposableLambdaKt.rememberComposableLambda(-570728333, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit MoreScreen$lambda$58$0$3$0;
                    MoreScreen$lambda$58$0$3$0 = MoreScreenKt.MoreScreen$lambda$58$0$3$0(list, FonRoApp, appNavigator, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return MoreScreen$lambda$58$0$3$0;
                }
            }, composer, 54), composer, 48, 1);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(18.0f), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$3$0(List list, final FonRoApp FonRoApp, final AppNavigator appNavigator, ColumnScope OxList, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(OxList, "$this$OxList");
        ComposerKt.sourceInformation(composer2, "C*317@13025L35,318@13096L34,319@13167L440,313@12831L798:MoreScreen.kt#1sifzz");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-570728333, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MoreScreen.kt:312)");
            }
            int i2 = 0;
            for (Object obj : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final MoreLink moreLink = (MoreLink) obj;
                String title = moreLink.getTitle();
                String subtitle = moreLink.getSubtitle();
                boolean z = i2 < CollectionsKt.getLastIndex(list);
                ComposerKt.sourceInformationMarkerStart(composer2, -1008697090, "CC(remember):MoreScreen.kt#9igjgp");
                boolean changedInstance = composer2.changedInstance(FonRoApp) | composer2.changedInstance(appNavigator) | composer2.changed(moreLink);
                Object rememberedValue = composer2.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda55
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit MoreScreen$lambda$58$0$3$0$0$0$0;
                            MoreScreen$lambda$58$0$3$0$0$0$0 = MoreScreenKt.MoreScreen$lambda$58$0$3$0$0$0$0(FonRoApp.this, appNavigator, moreLink);
                            return MoreScreen$lambda$58$0$3$0$0$0$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BasicsKt.m9832OxRow1YH7lEI(title, null, subtitle, (Function0) rememberedValue, z, 0L, ComposableLambdaKt.rememberComposableLambda(-268956677, true, new Function2() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda66
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit MoreScreen$lambda$58$0$3$0$0$1;
                        MoreScreen$lambda$58$0$3$0$0$1 = MoreScreenKt.MoreScreen$lambda$58$0$3$0$0$1(MoreLink.this, (Composer) obj2, ((Integer) obj3).intValue());
                        return MoreScreen$lambda$58$0$3$0$0$1;
                    }
                }, composer2, 54), ComposableLambdaKt.rememberComposableLambda(297315250, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda77
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        Unit MoreScreen$lambda$58$0$3$0$0$2;
                        MoreScreen$lambda$58$0$3$0$0$2 = MoreScreenKt.MoreScreen$lambda$58$0$3$0$0$2(MoreLink.this, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        return MoreScreen$lambda$58$0$3$0$0$2;
                    }
                }, composer2, 54), composer2, 14155776, 34);
                composer2 = composer;
                i2 = i3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$3$0$0$0$0(FonRoApp FonRoApp, AppNavigator appNavigator, MoreLink moreLink) {
        MainShellKt.openRoute(FonRoApp, appNavigator, moreLink.getRoute());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$3$0$0$1(MoreLink moreLink, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C318@13098L30:MoreScreen.kt#1sifzz");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-268956677, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MoreScreen.kt:318)");
            }
            m10045LinkIconRPmYEkk(moreLink.getIcon(), moreLink.m10028getTint0d7_KjU(), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$3$0$0$2(MoreLink moreLink, RowScope OxRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxRow, "$this$OxRow");
        ComposerKt.sourceInformation(composer, "C324@13390L191:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(297315250, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MoreScreen.kt:320)");
            }
            if (moreLink.getBadge() != null) {
                composer.startReplaceGroup(1096106308);
                ComposerKt.sourceInformation(composer, "321@13255L33,322@13321L10");
                BasicsKt.OxChip(moreLink.getBadge(), ChipTone.WARN, null, composer, 48, 4);
                BasicsKt.m9828HGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer, 6);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1096240848);
                composer.endReplaceGroup();
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getChevron(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(20.0f)), Ox.INSTANCE.m10200getDim20d7_KjU(), composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$4(final boolean z, final Repo repo, final FonRoApp FonRoApp, final AppNavigator appNavigator, final State state, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, final MutableState mutableState8, final MutableState mutableState9, final MutableState mutableState10, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C343@14106L3760,343@14099L3767,430@17879L11:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(530201136, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous>.<anonymous> (MoreScreen.kt:343)");
            }
            BasicsKt.OxList(null, ComposableLambdaKt.rememberComposableLambda(1360397301, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda53
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit MoreScreen$lambda$58$0$4$0;
                    MoreScreen$lambda$58$0$4$0 = MoreScreenKt.MoreScreen$lambda$58$0$4$0(z, repo, FonRoApp, appNavigator, state, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6, mutableState7, mutableState8, mutableState9, mutableState10, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return MoreScreen$lambda$58$0$4$0;
                }
            }, composer, 54), composer, 48, 1);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(16.0f), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$4$0(boolean z, final Repo repo, final FonRoApp FonRoApp, final AppNavigator appNavigator, State state, final MutableState mutableState, MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, MutableState mutableState8, final MutableState mutableState9, MutableState mutableState10, ColumnScope OxList, Composer composer, int i) {
        String str;
        int i2;
        final MutableState mutableState11;
        String str2;
        Intrinsics.checkNotNullParameter(OxList, "$this$OxList");
        ComposerKt.sourceInformation(composer, "C364@15061L22,359@14832L269,371@15369L146,366@15118L415,381@15773L20,376@15550L261,388@16047L21,383@15828L258,395@16326L21,390@16103L262,404@16763L45,397@16382L444,415@17346L127,419@17506L328,409@17036L816:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1360397301, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MoreScreen.kt:344)");
            }
            if (!z) {
                str = "CC(remember):MoreScreen.kt#9igjgp";
                i2 = 0;
                composer.startReplaceGroup(285292365);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(284644651);
                ComposerKt.sourceInformation(composer, "356@14751L24,346@14243L554");
                Store MoreScreen$lambda$1 = MoreScreen$lambda$1(state);
                if (MoreScreen$lambda$1 == null || (str2 = MoreScreen$lambda$1.getPosCurrency()) == null || StringsKt.isBlank(str2)) {
                    str2 = null;
                }
                String tx = LangKt.tx("Валюта кассы", new Object[0]);
                if (str2 == null) {
                    Store MoreScreen$lambda$12 = MoreScreen$lambda$1(state);
                    String currency = MoreScreen$lambda$12 != null ? MoreScreen$lambda$12.getCurrency() : null;
                    if (currency == null) {
                        currency = "";
                    }
                    String str3 = currency;
                    if (StringsKt.isBlank(str3)) {
                        str3 = "UZS";
                    }
                    str2 = LangKt.tx("Как в приложении (%s)", str3);
                } else if (Intrinsics.areEqual(str2, "NONE")) {
                    str2 = LangKt.tx("Не показывать", new Object[0]);
                }
                ImageVector cash = OxIcons.INSTANCE.getCash();
                long m10201getGreen0d7_KjU = Ox.INSTANCE.m10201getGreen0d7_KjU();
                ComposerKt.sourceInformationMarkerStart(composer, 1671768941, "CC(remember):MoreScreen.kt#9igjgp");
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda41
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit MoreScreen$lambda$58$0$4$0$2$0;
                            MoreScreen$lambda$58$0$4$0$2$0 = MoreScreenKt.MoreScreen$lambda$58$0$4$0$2$0(MutableState.this);
                            return MoreScreen$lambda$58$0$4$0$2$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                i2 = 0;
                str = "CC(remember):MoreScreen.kt#9igjgp";
                m10046SetRowhYmLsZ8(tx, str2, cash, m10201getGreen0d7_KjU, (Function0) rememberedValue, false, null, composer, 24576, 96);
                composer.endReplaceGroup();
            }
            String tx2 = LangKt.tx("Порог «мало на складе»", new Object[i2]);
            String tx3 = LangKt.tx("%s шт", Integer.valueOf(MoreScreen$lambda$5(mutableState2)));
            ImageVector warning = OxIcons.INSTANCE.getWarning();
            long m10213getOrange0d7_KjU = Ox.INSTANCE.m10213getOrange0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(composer, 1671778859, str);
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda42
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MoreScreen$lambda$58$0$4$0$3$0;
                        MoreScreen$lambda$58$0$4$0$3$0 = MoreScreenKt.MoreScreen$lambda$58$0$4$0$3$0(MutableState.this);
                        return MoreScreen$lambda$58$0$4$0$3$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m10046SetRowhYmLsZ8(tx2, tx3, warning, m10213getOrange0d7_KjU, (Function0) rememberedValue2, false, null, composer, 24576, 96);
            String tx4 = LangKt.tx("Размер текста", new Object[i2]);
            String str4 = TextScale.INSTANCE.percent(TextScale.INSTANCE.getCurrent()) + "%";
            ImageVector textSize = OxIcons.INSTANCE.getTextSize();
            long m10192getCyan0d7_KjU = Ox.INSTANCE.m10192getCyan0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(composer, 1671788839, str);
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda43
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MoreScreen$lambda$58$0$4$0$4$0;
                        MoreScreen$lambda$58$0$4$0$4$0 = MoreScreenKt.MoreScreen$lambda$58$0$4$0$4$0(MutableState.this, mutableState5);
                        return MoreScreen$lambda$58$0$4$0$4$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m10046SetRowhYmLsZ8(tx4, str4, textSize, m10192getCyan0d7_KjU, (Function0) rememberedValue3, false, null, composer, 24576, 96);
            String tx5 = LangKt.tx("Язык интерфейса", new Object[i2]);
            String titleOf = Lang.INSTANCE.titleOf(Lang.INSTANCE.getCode());
            ImageVector language = OxIcons.INSTANCE.getLanguage();
            long m10232getTeal0d7_KjU = Ox.INSTANCE.m10232getTeal0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(composer, 1671801641, str);
            Object rememberedValue4 = composer.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda45
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MoreScreen$lambda$58$0$4$0$5$0;
                        MoreScreen$lambda$58$0$4$0$5$0 = MoreScreenKt.MoreScreen$lambda$58$0$4$0$5$0(MutableState.this);
                        return MoreScreen$lambda$58$0$4$0$5$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m10046SetRowhYmLsZ8(tx5, titleOf, language, m10232getTeal0d7_KjU, (Function0) rememberedValue4, false, null, composer, 24576, 96);
            String tx6 = LangKt.tx("Тема оформления", new Object[i2]);
            String title = OxTheme.INSTANCE.getMode().getTitle();
            ImageVector palette = OxIcons.INSTANCE.getPalette();
            long m10223getPurple0d7_KjU = Ox.INSTANCE.m10223getPurple0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(composer, 1671810410, str);
            Object rememberedValue5 = composer.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda46
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MoreScreen$lambda$58$0$4$0$6$0;
                        MoreScreen$lambda$58$0$4$0$6$0 = MoreScreenKt.MoreScreen$lambda$58$0$4$0$6$0(MutableState.this);
                        return MoreScreen$lambda$58$0$4$0$6$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m10046SetRowhYmLsZ8(tx6, title, palette, m10223getPurple0d7_KjU, (Function0) rememberedValue5, false, null, composer, 24576, 96);
            String tx7 = LangKt.tx("Размер чека", new Object[i2]);
            String tx8 = LangKt.tx("%s мм", Integer.valueOf(MoreScreen$lambda$8(mutableState8)));
            ImageVector printer = OxIcons.INSTANCE.getPrinter();
            long m10220getPrimary0d7_KjU = Ox.INSTANCE.m10220getPrimary0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(composer, 1671819338, str);
            Object rememberedValue6 = composer.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = new Function0() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda47
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MoreScreen$lambda$58$0$4$0$7$0;
                        MoreScreen$lambda$58$0$4$0$7$0 = MoreScreenKt.MoreScreen$lambda$58$0$4$0$7$0(MutableState.this);
                        return MoreScreen$lambda$58$0$4$0$7$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m10046SetRowhYmLsZ8(tx7, tx8, printer, m10220getPrimary0d7_KjU, (Function0) rememberedValue6, false, null, composer, 24576, 96);
            String tx9 = LangKt.tx("Принтер чеков", new Object[i2]);
            String obj = StringsKt.trim((CharSequence) repo.getPrefs().getPrinterName()).toString();
            if (obj.length() <= 0) {
                obj = null;
            }
            if (obj == null) {
                String obj2 = StringsKt.trim((CharSequence) repo.getPrefs().getPrinterMac()).toString();
                String str5 = obj2.length() > 0 ? obj2 : null;
                obj = str5 == null ? LangKt.tx("Не выбран", new Object[i2]) : str5;
            }
            ImageVector bluetooth = OxIcons.INSTANCE.getBluetooth();
            long m10186getBlue0d7_KjU = Ox.INSTANCE.m10186getBlue0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(composer, 1671833346, str);
            boolean changedInstance = composer.changedInstance(FonRoApp) | composer.changedInstance(appNavigator);
            Object rememberedValue7 = composer.rememberedValue();
            if (changedInstance || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = new Function0() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda48
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MoreScreen$lambda$58$0$4$0$10$0;
                        MoreScreen$lambda$58$0$4$0$10$0 = MoreScreenKt.MoreScreen$lambda$58$0$4$0$10$0(FonRoApp.this, appNavigator);
                        return MoreScreen$lambda$58$0$4$0$10$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m10046SetRowhYmLsZ8(tx9, obj, bluetooth, m10186getBlue0d7_KjU, (Function0) rememberedValue7, false, null, composer, 0, 96);
            String tx10 = LangKt.tx("Печатать чек сразу после продажи", new Object[i2]);
            String tx11 = LangKt.tx("Чек уходит на принтер, как только продажа проведена", new Object[i2]);
            ImageVector receipt = OxIcons.INSTANCE.getReceipt();
            long m10232getTeal0d7_KjU2 = Ox.INSTANCE.m10232getTeal0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(composer, 1671852084, str);
            boolean changedInstance2 = composer.changedInstance(repo);
            Object rememberedValue8 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                mutableState11 = mutableState10;
                rememberedValue8 = new Function0() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda49
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MoreScreen$lambda$58$0$4$0$11$0;
                        MoreScreen$lambda$58$0$4$0$11$0 = MoreScreenKt.MoreScreen$lambda$58$0$4$0$11$0(Repo.this, mutableState11);
                        return MoreScreen$lambda$58$0$4$0$11$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue8);
            } else {
                mutableState11 = mutableState10;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m10046SetRowhYmLsZ8(tx10, tx11, receipt, m10232getTeal0d7_KjU2, (Function0) rememberedValue8, false, ComposableLambdaKt.rememberComposableLambda(578233732, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda50
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                    Unit MoreScreen$lambda$58$0$4$0$12;
                    MoreScreen$lambda$58$0$4$0$12 = MoreScreenKt.MoreScreen$lambda$58$0$4$0$12(Repo.this, mutableState11, (RowScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                    return MoreScreen$lambda$58$0$4$0$12;
                }
            }, composer, 54), composer, 1769472, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$4$0$2$0(MutableState mutableState) {
        MoreScreen$lambda$18(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$4$0$3$0(MutableState mutableState) {
        MoreScreen$lambda$15(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$4$0$4$0(MutableState mutableState, MutableState mutableState2) {
        MoreScreen$lambda$33(mutableState, TextScale.INSTANCE.indexOf(TextScale.INSTANCE.getCurrent()));
        MoreScreen$lambda$24(mutableState2, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$4$0$5$0(MutableState mutableState) {
        MoreScreen$lambda$30(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$4$0$6$0(MutableState mutableState) {
        MoreScreen$lambda$27(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$4$0$7$0(MutableState mutableState) {
        MoreScreen$lambda$21(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$4$0$10$0(FonRoApp FonRoApp, AppNavigator appNavigator) {
        MainShellKt.openRoute(FonRoApp, appNavigator, Routes.PRINTER_SETUP);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$4$0$11$0(Repo repo, MutableState mutableState) {
        MoreScreen$lambda$12(mutableState, !MoreScreen$lambda$11(mutableState));
        repo.getPrefs().setAutoPrint(MoreScreen$lambda$11(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$4$0$12(final Repo repo, final MutableState mutableState, RowScope SetRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(SetRow, "$this$SetRow");
        ComposerKt.sourceInformation(composer, "C422@17635L151,420@17532L280:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(578233732, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MoreScreen.kt:420)");
            }
            boolean MoreScreen$lambda$11 = MoreScreen$lambda$11(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 1631839547, "CC(remember):MoreScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(repo);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit MoreScreen$lambda$58$0$4$0$12$0$0;
                        MoreScreen$lambda$58$0$4$0$12$0$0 = MoreScreenKt.MoreScreen$lambda$58$0$4$0$12$0$0(Repo.this, mutableState, ((Boolean) obj).booleanValue());
                        return MoreScreen$lambda$58$0$4$0$12$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SwitchKt.Switch(MoreScreen$lambda$11, (Function1) rememberedValue, null, null, false, null, null, composer, 0, 124);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$4$0$12$0$0(Repo repo, MutableState mutableState, boolean z) {
        MoreScreen$lambda$12(mutableState, z);
        repo.getPrefs().setAutoPrint(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$5(State state, final MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Map<String, Integer> selfLimits;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C439@18199L410,439@18192L417,449@18626L11:MoreScreen.kt#1sifzz");
        final int i2 = 0;
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(834023624, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous>.<anonymous> (MoreScreen.kt:438)");
            }
            User MoreScreen$lambda$0 = MoreScreen$lambda$0(state);
            if (MoreScreen$lambda$0 != null && (selfLimits = MoreScreen$lambda$0.getSelfLimits()) != null) {
                i2 = selfLimits.size();
            }
            BasicsKt.OxList(null, ComposableLambdaKt.rememberComposableLambda(700991565, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit MoreScreen$lambda$58$0$5$0;
                    MoreScreen$lambda$58$0$5$0 = MoreScreenKt.MoreScreen$lambda$58$0$5$0(i2, mutableState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return MoreScreen$lambda$58$0$5$0;
                }
            }, composer, 54), composer, 48, 1);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(16.0f), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$5$0(int i, final MutableState mutableState, ColumnScope OxList, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(OxList, "$this$OxList");
        ComposerKt.sourceInformation(composer, "C446@18547L22,440@18221L370:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i2 & 17) != 16, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(700991565, i2, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MoreScreen.kt:440)");
            }
            String tx = LangKt.tx("Мой доступ", new Object[0]);
            String tx2 = i > 0 ? LangKt.tx("скрыто разделов: %s", Integer.valueOf(i)) : LangKt.tx("открыто всё", new Object[0]);
            ImageVector lock = OxIcons.INSTANCE.getLock();
            long m10223getPurple0d7_KjU = Ox.INSTANCE.m10223getPurple0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(composer, -656960349, "CC(remember):MoreScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MoreScreen$lambda$58$0$5$0$0$0;
                        MoreScreen$lambda$58$0$5$0$0$0 = MoreScreenKt.MoreScreen$lambda$58$0$5$0$0$0(MutableState.this);
                        return MoreScreen$lambda$58$0$5$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m10046SetRowhYmLsZ8(tx, tx2, lock, m10223getPurple0d7_KjU, (Function0) rememberedValue, false, null, composer, 221184, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$5$0$0$0(MutableState mutableState) {
        MoreScreen$lambda$36(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$6(final String str, final Context context, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C457@18832L394,457@18825L401,467@19243L11:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(628756415, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous>.<anonymous> (MoreScreen.kt:457)");
            }
            BasicsKt.OxList(null, ComposableLambdaKt.rememberComposableLambda(1633966596, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda83
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit MoreScreen$lambda$58$0$6$0;
                    MoreScreen$lambda$58$0$6$0 = MoreScreenKt.MoreScreen$lambda$58$0$6$0(str, context, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return MoreScreen$lambda$58$0$6$0;
                }
            }, composer, 54), composer, 48, 1);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(16.0f), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$6$0(final String str, final Context context, ColumnScope OxList, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxList, "$this$OxList");
        ComposerKt.sourceInformation(composer, "C464@19134L52,458@18854L354:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1633966596, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MoreScreen.kt:458)");
            }
            String tx = LangKt.tx("Мой онлайн-магазин", new Object[0]);
            String str2 = "FonRo.uz/" + str;
            ImageVector store = OxIcons.INSTANCE.getStore();
            long m10223getPurple0d7_KjU = Ox.INSTANCE.m10223getPurple0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(composer, -1716121864, "CC(remember):MoreScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(context) | composer.changed(str);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda36
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MoreScreen$lambda$58$0$6$0$0$0;
                        MoreScreen$lambda$58$0$6$0$0$0 = MoreScreenKt.MoreScreen$lambda$58$0$6$0$0$0(context, str);
                        return MoreScreen$lambda$58$0$6$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m10046SetRowhYmLsZ8(tx, str2, store, m10223getPurple0d7_KjU, (Function0) rememberedValue, false, null, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$6$0$0$0(Context context, String str) {
        openExternal(context, "https://FonRo.uz/" + str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$7(final Context context, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C473@19367L378,473@19360L385,483@19758L11:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1833640526, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous>.<anonymous> (MoreScreen.kt:473)");
            }
            BasicsKt.OxList(null, ComposableLambdaKt.rememberComposableLambda(-1003444361, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda76
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit MoreScreen$lambda$58$0$7$0;
                    MoreScreen$lambda$58$0$7$0 = MoreScreenKt.MoreScreen$lambda$58$0$7$0(context, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return MoreScreen$lambda$58$0$7$0;
                }
            }, composer, 54), composer, 48, 1);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(16.0f), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$7$0(final Context context, ColumnScope OxList, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxList, "$this$OxList");
        ComposerKt.sourceInformation(composer, "C480@19647L66,474@19385L346:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1003444361, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MoreScreen.kt:474)");
            }
            String tx = LangKt.tx("Политика конфиденциальности", new Object[0]);
            ImageVector lock = OxIcons.INSTANCE.getLock();
            long m10199getDim0d7_KjU = Ox.INSTANCE.m10199getDim0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(composer, 2057619705, "CC(remember):MoreScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(context);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda40
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MoreScreen$lambda$58$0$7$0$0$0;
                        MoreScreen$lambda$58$0$7$0$0$0 = MoreScreenKt.MoreScreen$lambda$58$0$7$0$0$0(context);
                        return MoreScreen$lambda$58$0$7$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m10046SetRowhYmLsZ8(tx, "mobile.FonRo.uz", lock, m10199getDim0d7_KjU, (Function0) rememberedValue, false, null, composer, 196656, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$7$0$0$0(Context context) {
        openExternal(context, "https://mobile.FonRo.uz/privacy.html");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$8(final MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C490@19910L24,488@19838L216,495@20067L11:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-868077709, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous>.<anonymous> (MoreScreen.kt:488)");
            }
            String tx = LangKt.tx("Выйти", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -999020149, "CC(remember):MoreScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda81
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MoreScreen$lambda$58$0$8$0$0;
                        MoreScreen$lambda$58$0$8$0$0 = MoreScreenKt.MoreScreen$lambda$58$0$8$0$0(MutableState.this);
                        return MoreScreen$lambda$58$0$8$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, null, BtnStyle.DANGER, BtnSize.LG, false, true, null, composer, 1600560, 164);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(14.0f), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$58$0$8$0$0(MutableState mutableState) {
        MoreScreen$lambda$39(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$59$0(MutableState mutableState) {
        MoreScreen$lambda$36(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$60$0(Repo repo, MutableState mutableState, double d) {
        int coerceAtLeast = RangesKt.coerceAtLeast((int) d, 1);
        MoreScreen$lambda$6(mutableState, coerceAtLeast);
        repo.getPrefs().setLowStock(coerceAtLeast);
        Toaster.INSTANCE.ok(LangKt.tx("Порог сохранён: %s шт", Integer.valueOf(coerceAtLeast)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$61$0(MutableState mutableState) {
        MoreScreen$lambda$15(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$62$0(MutableState mutableState) {
        MoreScreen$lambda$30(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MoreScreen$lambda$63(final Repo repo, ColumnScope OxSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSheet, "$this$OxSheet");
        ComposerKt.sourceInformation(composer, "C535@21542L160,539@21715L11,540@21746L1110,540@21739L1117,563@22869L11:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1459055478, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous> (MoreScreen.kt:535)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Язык кассы на этом устройстве. На чеки и этикетки не влияет.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(14.0f), composer, 6);
            BasicsKt.OxList(null, ComposableLambdaKt.rememberComposableLambda(376391013, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit MoreScreen$lambda$63$0;
                    MoreScreen$lambda$63$0 = MoreScreenKt.MoreScreen$lambda$63$0(Repo.this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return MoreScreen$lambda$63$0;
                }
            }, composer, 54), composer, 48, 1);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$63$0(final Repo repo, ColumnScope OxList, Composer composer, int i) {
        String str;
        boolean z;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(OxList, "$this$OxList");
        ComposerKt.sourceInformation(composer2, "C*551@22392L37,552@22466L336,543@21887L937:MoreScreen.kt#1sifzz");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(376391013, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous> (MoreScreen.kt:541)");
            }
            int i2 = 0;
            for (Object obj : Lang.INSTANCE.getLANGUAGES()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final OxLanguage oxLanguage = (OxLanguage) obj;
                final boolean areEqual = Intrinsics.areEqual(Lang.INSTANCE.getCode(), oxLanguage.getCode());
                String title = oxLanguage.getTitle();
                String tx = LangKt.tx(oxLanguage.getHint(), new Object[0]);
                if (i2 < CollectionsKt.getLastIndex(Lang.INSTANCE.getLANGUAGES())) {
                    str = tx;
                    z = true;
                } else {
                    str = tx;
                    z = false;
                }
                Ox ox = Ox.INSTANCE;
                long m10220getPrimary0d7_KjU = areEqual ? ox.m10220getPrimary0d7_KjU() : ox.m10233getText0d7_KjU();
                ComposerKt.sourceInformationMarkerStart(composer2, 54577588, "CC(remember):MoreScreen.kt#9igjgp");
                boolean changedInstance = composer2.changedInstance(repo) | composer2.changedInstance(oxLanguage);
                Object rememberedValue = composer2.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit MoreScreen$lambda$63$0$0$0$0;
                            MoreScreen$lambda$63$0$0$0$0 = MoreScreenKt.MoreScreen$lambda$63$0$0$0$0(Repo.this, oxLanguage);
                            return MoreScreen$lambda$63$0$0$0$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BasicsKt.m9832OxRow1YH7lEI(title, null, str, (Function0) rememberedValue, z, m10220getPrimary0d7_KjU, null, ComposableLambdaKt.rememberComposableLambda(1340571704, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        Unit MoreScreen$lambda$63$0$0$1;
                        MoreScreen$lambda$63$0$0$1 = MoreScreenKt.MoreScreen$lambda$63$0$0$1(areEqual, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        return MoreScreen$lambda$63$0$0$1;
                    }
                }, composer2, 54), composer2, 12582912, 66);
                composer2 = composer;
                i2 = i3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$63$0$0$0$0(Repo repo, OxLanguage oxLanguage) {
        Lang.INSTANCE.apply(repo.getPrefs(), oxLanguage.getCode());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$63$0$0$1(boolean z, RowScope OxRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxRow, "$this$OxRow");
        ComposerKt.sourceInformation(composer, "C:MoreScreen.kt#1sifzz");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1340571704, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MoreScreen.kt:553)");
            }
            if (z) {
                composer.startReplaceGroup(-1929169922);
                ComposerKt.sourceInformation(composer, "554@22542L204");
                IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getOk(), LangKt.tx("Выбран", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(21.0f)), Ox.INSTANCE.m10211getOk0d7_KjU(), composer, 384, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1928944118);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$64$0(MutableState mutableState) {
        MoreScreen$lambda$27(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MoreScreen$lambda$65(final Repo repo, ColumnScope OxSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSheet, "$this$OxSheet");
        ComposerKt.sourceInformation(composer, "C572@23234L174,576@23421L11,577@23452L870,577@23445L877,597@24335L11:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1844422261, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous> (MoreScreen.kt:572)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Оформление кассы на этом устройстве. На печать чеков и этикеток не влияет.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(14.0f), composer, 6);
            BasicsKt.OxList(null, ComposableLambdaKt.rememberComposableLambda(-8975770, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda75
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit MoreScreen$lambda$65$0;
                    MoreScreen$lambda$65$0 = MoreScreenKt.MoreScreen$lambda$65$0(Repo.this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return MoreScreen$lambda$65$0;
                }
            }, composer, 54), composer, 48, 1);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$65$0(final Repo repo, ColumnScope OxList, Composer composer, int i) {
        String str;
        boolean z;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(OxList, "$this$OxList");
        ComposerKt.sourceInformation(composer2, "C*584@23802L35,585@23873L21,586@23931L337,580@23597L693:MoreScreen.kt#1sifzz");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-8975770, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous> (MoreScreen.kt:578)");
            }
            int i2 = 0;
            for (Object obj : OxAppearance.getEntries()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final OxAppearance oxAppearance = (OxAppearance) obj;
                final boolean z2 = OxTheme.INSTANCE.getMode() == oxAppearance;
                String title = oxAppearance.getTitle();
                String hint = oxAppearance.getHint();
                if (i2 < CollectionsKt.getLastIndex(OxAppearance.getEntries())) {
                    str = hint;
                    z = true;
                } else {
                    str = hint;
                    z = false;
                }
                ComposerKt.sourceInformationMarkerStart(composer2, 699110527, "CC(remember):MoreScreen.kt#9igjgp");
                boolean changedInstance = composer2.changedInstance(repo) | composer2.changed(oxAppearance.ordinal());
                Object rememberedValue = composer2.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda37
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit MoreScreen$lambda$65$0$0$0$0;
                            MoreScreen$lambda$65$0$0$0$0 = MoreScreenKt.MoreScreen$lambda$65$0$0$0$0(Repo.this, oxAppearance);
                            return MoreScreen$lambda$65$0$0$0$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BasicsKt.m9832OxRow1YH7lEI(title, null, str, (Function0) rememberedValue, z, 0L, ComposableLambdaKt.rememberComposableLambda(-551257828, true, new Function2() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda38
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit MoreScreen$lambda$65$0$0$1;
                        MoreScreen$lambda$65$0$0$1 = MoreScreenKt.MoreScreen$lambda$65$0$0$1(OxAppearance.this, (Composer) obj2, ((Integer) obj3).intValue());
                        return MoreScreen$lambda$65$0$0$1;
                    }
                }, composer2, 54), ComposableLambdaKt.rememberComposableLambda(-1979749947, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda39
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        Unit MoreScreen$lambda$65$0$0$2;
                        MoreScreen$lambda$65$0$0$2 = MoreScreenKt.MoreScreen$lambda$65$0$0$2(z2, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        return MoreScreen$lambda$65$0$0$2;
                    }
                }, composer2, 54), composer2, 14155776, 34);
                composer2 = composer;
                i2 = i3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$65$0$0$0$0(Repo repo, OxAppearance oxAppearance) {
        OxTheme.INSTANCE.apply(repo.getPrefs(), oxAppearance);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$65$0$0$1(OxAppearance oxAppearance, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C585@23875L17:MoreScreen.kt#1sifzz");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-551257828, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MoreScreen.kt:585)");
            }
            ThemeSwatch(oxAppearance, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$65$0$0$2(boolean z, RowScope OxRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxRow, "$this$OxRow");
        ComposerKt.sourceInformation(composer, "C:MoreScreen.kt#1sifzz");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1979749947, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MoreScreen.kt:587)");
            }
            if (z) {
                composer.startReplaceGroup(-239680656);
                ComposerKt.sourceInformation(composer, "588@24007L205");
                IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getOk(), LangKt.tx("Выбрана", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(21.0f)), Ox.INSTANCE.m10211getOk0d7_KjU(), composer, 384, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-239453891);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$66$0(Repo repo, MutableState mutableState, MutableState mutableState2) {
        MoreScreen$lambda$24(mutableState, false);
        TextScale.INSTANCE.apply(repo.getPrefs(), MathKt.roundToInt(MoreScreen$lambda$32(mutableState2)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MoreScreen$lambda$67(final MutableState mutableState, ColumnScope OxSheet, Composer composer, int i) {
        boolean z;
        String str;
        Intrinsics.checkNotNullParameter(OxSheet, "$this$OxSheet");
        ComposerKt.sourceInformation(composer, "C612@24816L192,616@25021L11,623@25362L972,640@26393L327,648@26734L11,649@26758L716,668@27487L10:MoreScreen.kt#1sifzz");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2065178252, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous> (MoreScreen.kt:612)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Размер подписей во всём приложении на этом устройстве. На печать чеков и этикеток не влияет.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(14.0f), composer, 6);
            float floatValue = TextScale.INSTANCE.getSTEPS().get(MathKt.roundToInt(MoreScreen$lambda$32(mutableState))).floatValue() / TextScale.INSTANCE.getCurrent();
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
            ComposerKt.sourceInformationMarkerStart(composer, -1072034438, "C626@25613L7,627@25685L7,628@25727L104,631@25930L17,629@25848L351,636@26216L104:MoreScreen.kt#1sifzz");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            long j = ((Density) consume).mo702toSp0xMU5do(Dp.m6989constructorimpl(15.0f));
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd(composer);
            long j2 = ((Density) consume2).mo702toSp0xMU5do(Dp.m6989constructorimpl(27.0f));
            TextKt.m2798Text4IGK_g(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), j, FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 6, 0, 65534);
            float MoreScreen$lambda$32 = MoreScreen$lambda$32(mutableState);
            ClosedFloatingPointRange<Float> rangeTo = RangesKt.rangeTo(0.0f, CollectionsKt.getLastIndex(TextScale.INSTANCE.getSTEPS()));
            int size = TextScale.INSTANCE.getSTEPS().size() - 2;
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m6989constructorimpl(12.0f), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1212354617, "CC(remember):MoreScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit MoreScreen$lambda$67$0$2$0;
                        MoreScreen$lambda$67$0$2$0 = MoreScreenKt.MoreScreen$lambda$67$0$2$0(MutableState.this, ((Float) obj).floatValue());
                        return MoreScreen$lambda$67$0$2$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SliderKt.Slider(MoreScreen$lambda$32, (Function1) rememberedValue, m1051paddingVpY3zN4$default, false, rangeTo, size, null, null, null, composer, 48, 456);
            TextKt.m2798Text4IGK_g(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), j2, FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 6, 0, 65534);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            int roundToInt = MathKt.roundToInt(MoreScreen$lambda$32(mutableState));
            int percent = TextScale.INSTANCE.percent(TextScale.INSTANCE.getSTEPS().get(roundToInt).floatValue());
            if (roundToInt == 4) {
                z = false;
                str = LangKt.tx(" · обычный", new Object[0]);
            } else {
                z = false;
                str = "";
            }
            TextKt.m2798Text4IGK_g(percent + "%" + str, PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(6.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6866boximpl(TextAlign.INSTANCE.m6873getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getLabel(), composer, 48, 0, 65020);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            Modifier m1049padding3ABfNKs = PaddingKt.m1049padding3ABfNKs(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), OxShape.INSTANCE.getCardSoft()), Ox.INSTANCE.m10218getPanel20d7_KjU(), null, 2, null), Dp.m6989constructorimpl(14.0f));
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
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
            ComposerKt.sourceInformationMarkerStart(composer, -907961969, "C656@26982L160,660@27159L301:MoreScreen.kt#1sifzz");
            String tx = LangKt.tx("Размер текста", new Object[0]);
            TextStyle rowTitle = OxType.INSTANCE.getRowTitle();
            long m6466getFontSizeXSAIIZE = OxType.INSTANCE.getRowTitle().m6466getFontSizeXSAIIZE();
            TextUnitKt.m7196checkArithmeticR2X_6o(m6466getFontSizeXSAIIZE);
            TextKt.m2798Text4IGK_g(tx, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(rowTitle, 0L, TextUnitKt.pack(TextUnit.m7181getRawTypeimpl(m6466getFontSizeXSAIIZE), TextUnit.m7183getValueimpl(m6466getFontSizeXSAIIZE) * floatValue), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), composer, 0, 0, 65534);
            String tx2 = LangKt.tx("Так будет выглядеть текст в приложении.", new Object[0]);
            TextStyle rowSub = OxType.INSTANCE.getRowSub();
            long m6466getFontSizeXSAIIZE2 = OxType.INSTANCE.getRowSub().m6466getFontSizeXSAIIZE();
            TextUnitKt.m7196checkArithmeticR2X_6o(m6466getFontSizeXSAIIZE2);
            long pack = TextUnitKt.pack(TextUnit.m7181getRawTypeimpl(m6466getFontSizeXSAIIZE2), TextUnit.m7183getValueimpl(m6466getFontSizeXSAIIZE2) * floatValue);
            long m6474getLineHeightXSAIIZE = OxType.INSTANCE.getRowSub().m6474getLineHeightXSAIIZE();
            TextUnitKt.m7196checkArithmeticR2X_6o(m6474getLineHeightXSAIIZE);
            TextKt.m2798Text4IGK_g(tx2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(rowSub, 0L, pack, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.pack(TextUnit.m7181getRawTypeimpl(m6474getLineHeightXSAIIZE), TextUnit.m7183getValueimpl(m6474getLineHeightXSAIIZE) * floatValue), null, null, null, 0, 0, null, 16646141, null), composer, 0, 0, 65534);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$67$0$2$0(MutableState mutableState, float f) {
        MoreScreen$lambda$33(mutableState, f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$68$0(MutableState mutableState) {
        MoreScreen$lambda$21(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MoreScreen$lambda$69(final Repo repo, final MutableState mutableState, final MutableState mutableState2, ColumnScope OxSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSheet, "$this$OxSheet");
        ComposerKt.sourceInformation(composer, "C674@27630L177,678@27820L11,679@27851L1241,679@27844L1248,708@29105L10:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1679811469, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous> (MoreScreen.kt:674)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Ширина ленты вашего термопринтера. Влияет на печать чеков с этого устройства.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            BasicsKt.OxList(null, ComposableLambdaKt.rememberComposableLambda(-779709336, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit MoreScreen$lambda$69$0;
                    MoreScreen$lambda$69$0 = MoreScreenKt.MoreScreen$lambda$69$0(Repo.this, mutableState, mutableState2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return MoreScreen$lambda$69$0;
                }
            }, composer, 54), composer, 48, 1);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$69$0(final Repo repo, final MutableState mutableState, final MutableState mutableState2, ColumnScope OxList, Composer composer, int i) {
        String str;
        boolean z;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(OxList, "$this$OxList");
        ComposerKt.sourceInformation(composer2, "C*691@28417L246,697@28700L338,686@28165L895:MoreScreen.kt#1sifzz");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-779709336, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous> (MoreScreen.kt:680)");
            }
            int i2 = 0;
            for (Object obj : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(58, LangKt.tx("узкая лента", new Object[0])), TuplesKt.to(72, LangKt.tx("стандарт — как в iOS по умолчанию", new Object[0])), TuplesKt.to(80, LangKt.tx("широкая лента", new Object[0]))})) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Pair pair = (Pair) obj;
                final int intValue = ((Number) pair.component1()).intValue();
                String str2 = (String) pair.component2();
                final boolean z2 = intValue == MoreScreen$lambda$8(mutableState);
                String tx = LangKt.tx("%s мм", Integer.valueOf(intValue));
                if (i2 < 2) {
                    str = tx;
                    z = true;
                } else {
                    str = tx;
                    z = false;
                }
                Ox ox = Ox.INSTANCE;
                long m10220getPrimary0d7_KjU = z2 ? ox.m10220getPrimary0d7_KjU() : ox.m10233getText0d7_KjU();
                ComposerKt.sourceInformationMarkerStart(composer2, 237949537, "CC(remember):MoreScreen.kt#9igjgp");
                boolean changed = composer2.changed(intValue) | composer2.changedInstance(repo);
                Object rememberedValue = composer2.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda78
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit MoreScreen$lambda$69$0$0$0$0;
                            MoreScreen$lambda$69$0$0$0$0 = MoreScreenKt.MoreScreen$lambda$69$0$0$0$0(intValue, repo, mutableState, mutableState2);
                            return MoreScreen$lambda$69$0$0$0$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BasicsKt.m9832OxRow1YH7lEI(str, null, str2, (Function0) rememberedValue, z, m10220getPrimary0d7_KjU, null, ComposableLambdaKt.rememberComposableLambda(1516628212, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda79
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        Unit MoreScreen$lambda$69$0$0$1;
                        MoreScreen$lambda$69$0$0$1 = MoreScreenKt.MoreScreen$lambda$69$0$0$1(z2, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        return MoreScreen$lambda$69$0$0$1;
                    }
                }, composer2, 54), composer2, 12582912, 66);
                composer2 = composer;
                i2 = i3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$69$0$0$0$0(int i, Repo repo, MutableState mutableState, MutableState mutableState2) {
        MoreScreen$lambda$9(mutableState, i);
        repo.getPrefs().setReceiptWidth(i);
        MoreScreen$lambda$21(mutableState2, false);
        Toaster.INSTANCE.ok(LangKt.tx("Размер чека: %s мм", Integer.valueOf(i)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$69$0$0$1(boolean z, RowScope OxRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxRow, "$this$OxRow");
        ComposerKt.sourceInformation(composer, "C:MoreScreen.kt#1sifzz");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1516628212, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MoreScreen.kt:698)");
            }
            if (z) {
                composer.startReplaceGroup(-1184806526);
                ComposerKt.sourceInformation(composer, "699@28778L204");
                IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getOk(), LangKt.tx("Выбран", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(22.0f)), Ox.INSTANCE.m10211getOk0d7_KjU(), composer, 384, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1184580722);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$70$0(MutableState mutableState) {
        MoreScreen$lambda$18(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MoreScreen$lambda$71(final String str, final CoroutineScope coroutineScope, final Repo repo, final MutableState mutableState, ColumnScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C717@29474L21,717@29443L2088:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1075616156, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous> (MoreScreen.kt:717)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1837612312, "C718@29512L188,722@29713L11,723@29744L1750,723@29737L1757,758@31507L10:MoreScreen.kt#1sifzz");
            TextKt.m2798Text4IGK_g(LangKt.tx("Влияет только на то, как касса показывает суммы. У витрины и iOS-приложения валюта своя.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            BasicsKt.OxList(null, ComposableLambdaKt.rememberComposableLambda(-1005901759, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda51
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit MoreScreen$lambda$71$0$0;
                    MoreScreen$lambda$71$0$0 = MoreScreenKt.MoreScreen$lambda$71$0$0(str, coroutineScope, repo, mutableState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return MoreScreen$lambda$71$0$0;
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
    public static final Unit MoreScreen$lambda$71$0$0(String str, final CoroutineScope coroutineScope, final Repo repo, final MutableState mutableState, ColumnScope OxList, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(OxList, "$this$OxList");
        ComposerKt.sourceInformation(composer2, "C*731@30245L819,747@31101L339,726@29883L1579:MoreScreen.kt#1sifzz");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1005901759, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous>.<anonymous> (MoreScreen.kt:724)");
            }
            int i2 = 0;
            for (Object obj : getCURRENCIES()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Pair pair = (Pair) obj;
                final String str2 = (String) pair.component1();
                String str3 = (String) pair.component2();
                final boolean areEqual = Intrinsics.areEqual(str2, str);
                String tx = Intrinsics.areEqual(str2, "NONE") ? LangKt.tx("Не показывать", new Object[0]) : str2;
                if (Intrinsics.areEqual(str2, "NONE")) {
                    str3 = LangKt.tx("Суммы без буквенного кода", new Object[0]);
                }
                boolean z = i2 < CollectionsKt.getLastIndex(getCURRENCIES());
                Ox ox = Ox.INSTANCE;
                long m10220getPrimary0d7_KjU = areEqual ? ox.m10220getPrimary0d7_KjU() : ox.m10233getText0d7_KjU();
                ComposerKt.sourceInformationMarkerStart(composer2, 771776183, "CC(remember):MoreScreen.kt#9igjgp");
                boolean changedInstance = composer2.changedInstance(coroutineScope) | composer2.changed(str2) | composer2.changedInstance(repo);
                Object rememberedValue = composer2.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda33
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit MoreScreen$lambda$71$0$0$0$0$0;
                            MoreScreen$lambda$71$0$0$0$0$0 = MoreScreenKt.MoreScreen$lambda$71$0$0$0$0$0(CoroutineScope.this, mutableState, str2, repo);
                            return MoreScreen$lambda$71$0$0$0$0$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BasicsKt.m9832OxRow1YH7lEI(tx, null, str3, (Function0) rememberedValue, z, m10220getPrimary0d7_KjU, null, ComposableLambdaKt.rememberComposableLambda(1137928397, true, new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda44
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        Unit MoreScreen$lambda$71$0$0$0$1;
                        MoreScreen$lambda$71$0$0$0$1 = MoreScreenKt.MoreScreen$lambda$71$0$0$0$1(areEqual, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        return MoreScreen$lambda$71$0$0$0$1;
                    }
                }, composer2, 54), composer2, 12582912, 66);
                composer2 = composer;
                i2 = i3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$71$0$0$0$0$0(CoroutineScope coroutineScope, MutableState mutableState, String str, Repo repo) {
        MoreScreen$lambda$18(mutableState, false);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MoreScreenKt$MoreScreen$14$1$1$1$1$1$1(str, repo, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$71$0$0$0$1(boolean z, RowScope OxRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxRow, "$this$OxRow");
        ComposerKt.sourceInformation(composer, "C:MoreScreen.kt#1sifzz");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1137928397, i, -1, "uz.FonRo.pos.ui.more.MoreScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MoreScreen.kt:748)");
            }
            if (z) {
                composer.startReplaceGroup(-151908568);
                ComposerKt.sourceInformation(composer, "749@31179L205");
                IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getOk(), LangKt.tx("Выбрана", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(22.0f)), Ox.INSTANCE.m10211getOk0d7_KjU(), composer, 384, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-151681803);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$72$0(CoroutineScope coroutineScope, MutableState mutableState, Repo repo) {
        MoreScreen$runBilling(coroutineScope, mutableState, repo, new MoreScreenKt$MoreScreen$15$1$1(null), LangKt.tx("Подписка отменена. Доступ — до конца периода.", new Object[0]));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$73$0(MutableState mutableState) {
        MoreScreen$lambda$42(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$74$0(Context context, CoroutineScope coroutineScope, Repo repo) {
        BackgroundWork.INSTANCE.cancelAll(context);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MoreScreenKt$MoreScreen$17$1$1(repo, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreScreen$lambda$75$0(MutableState mutableState) {
        MoreScreen$lambda$39(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SetLabel(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1341802481);
        ComposerKt.sourceInformation(startRestartGroup, "C(SetLabel)803@33117L284:MoreScreen.kt#1sifzz");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1341802481, i2, -1, "uz.FonRo.pos.ui.more.SetLabel (MoreScreen.kt:802)");
            }
            String upperCase = str.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(upperCase, PaddingKt.m1052paddingqDBjuR0(Modifier.INSTANCE, Dp.m6989constructorimpl(4.0f), Dp.m6989constructorimpl(2.0f), Dp.m6989constructorimpl(4.0f), Dp.m6989constructorimpl(7.0f)), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, FontWeight.INSTANCE.getExtraBold(), null, null, null, null, TextUnitKt.getSp(0.5d), null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777082, null), composer2, 0, 0, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MoreScreenKt.SetLabel$lambda$0(str, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ThemeSwatch(final OxAppearance oxAppearance, Composer composer, final int i) {
        int i2;
        Pair pair;
        Composer startRestartGroup = composer.startRestartGroup(444688308);
        ComposerKt.sourceInformation(startRestartGroup, "C(ThemeSwatch)831@34132L285:MoreScreen.kt#1sifzz");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(oxAppearance.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(444688308, i2, -1, "uz.FonRo.pos.ui.more.ThemeSwatch (MoreScreen.kt:824)");
            }
            int i3 = WhenMappings.$EnumSwitchMapping$0[oxAppearance.ordinal()];
            if (i3 == 1) {
                pair = TuplesKt.to(Color.m4374boximpl(ColorKt.Color(4294112504L)), Color.m4374boximpl(ColorKt.Color(4294967295L)));
            } else if (i3 == 2) {
                pair = TuplesKt.to(Color.m4374boximpl(ColorKt.Color(4278850601L)), Color.m4374boximpl(ColorKt.Color(4279377976L)));
            } else if (i3 == 3) {
                pair = TuplesKt.to(Color.m4374boximpl(ColorKt.Color(4278190080L)), Color.m4374boximpl(ColorKt.Color(4280032287L)));
            } else {
                if (i3 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                pair = TuplesKt.to(Color.m4374boximpl(ColorKt.Color(4294112504L)), Color.m4374boximpl(ColorKt.Color(4278850601L)));
            }
            long m4394unboximpl = ((Color) pair.component1()).m4394unboximpl();
            long m4394unboximpl2 = ((Color) pair.component2()).m4394unboximpl();
            Modifier m569borderxT4_qwU = BorderKt.m569borderxT4_qwU(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(34.0f)), OxShape.INSTANCE.getPill()), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getPill());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m569borderxT4_qwU);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1123160647, "C837@34289L55,838@34353L58:MoreScreen.kt#1sifzz");
            BoxKt.Box(BackgroundKt.m558backgroundbw27NRU$default(SizeKt.fillMaxHeight$default(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0.0f, 1, null), m4394unboximpl, null, 2, null), startRestartGroup, 0);
            BoxKt.Box(BackgroundKt.m558backgroundbw27NRU$default(SizeKt.fillMaxHeight$default(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0.0f, 1, null), m4394unboximpl2, null, 2, null), startRestartGroup, 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MoreScreenKt.ThemeSwatch$lambda$1(OxAppearance.this, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0091  */
    /* renamed from: SetRow-hYmLsZ8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m10046SetRowhYmLsZ8(final java.lang.String r22, final java.lang.String r23, final androidx.compose.ui.graphics.vector.ImageVector r24, final long r25, final kotlin.jvm.functions.Function0<kotlin.Unit> r27, boolean r28, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.more.MoreScreenKt.m10046SetRowhYmLsZ8(java.lang.String, java.lang.String, androidx.compose.ui.graphics.vector.ImageVector, long, kotlin.jvm.functions.Function0, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SetRow_hYmLsZ8$lambda$0(ImageVector imageVector, long j, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C857@34779L20:MoreScreen.kt#1sifzz");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1305115121, i, -1, "uz.FonRo.pos.ui.more.SetRow.<anonymous> (MoreScreen.kt:857)");
            }
            m10045LinkIconRPmYEkk(imageVector, j, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final void StoreHero(final String str, final String str2, final String str3, final String str4, Composer composer, final int i) {
        int i2;
        String str5;
        Composer startRestartGroup = composer.startRestartGroup(-1488373401);
        ComposerKt.sourceInformation(startRestartGroup, "C(StoreHero)P(2,3,1)870@35201L2156:MoreScreen.kt#1sifzz");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
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
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1488373401, i2, -1, "uz.FonRo.pos.ui.more.StoreHero (MoreScreen.kt:868)");
            }
            String str6 = str2;
            Character firstOrNull = StringsKt.firstOrNull(StringsKt.trim((CharSequence) str6).toString());
            if (firstOrNull == null || (str5 = String.valueOf(Character.toUpperCase(firstOrNull.charValue()))) == null) {
                str5 = "U";
            }
            Modifier m1049padding3ABfNKs = PaddingKt.m1049padding3ABfNKs(BackgroundKt.background$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), OxShape.INSTANCE.getCard()), Brush.Companion.m4335linearGradientmHitzGk$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m4374boximpl(Ox.INSTANCE.m10192getCyan0d7_KjU()), Color.m4374boximpl(Ox.INSTANCE.m10220getPrimary0d7_KjU())}), 0L, 0L, 0, 14, (Object) null), null, 0.0f, 6, null), Dp.m6989constructorimpl(16.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(13.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m1049padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i3 = i2;
            String str7 = str5;
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1669360997, "C879@35530L379,891@35918L1433:MoreScreen.kt#1sifzz");
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(56.0f)), OxShape.INSTANCE.getPill()), Color.m4383copywmQWz5c$default(Color.INSTANCE.m4421getWhite0d7_KjU(), 0.22f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 265607234, "C886@35755L144:MoreScreen.kt#1sifzz");
            TextKt.m2798Text4IGK_g(str7, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH1(), Color.INSTANCE.m4421getWhite0d7_KjU(), TextUnitKt.getSp(24), null, null, null, null, null, TextUnitKt.getSp(0), null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777084, null), startRestartGroup, 0, 0, 65534);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1931056227, "C892@35960L214:MoreScreen.kt#1sifzz");
            String str8 = str;
            if (StringsKt.isBlank(str8)) {
                str8 = LangKt.tx("Магазин", new Object[0]);
            }
            TextKt.m2798Text4IGK_g(str8, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH2(), Color.INSTANCE.m4421getWhite0d7_KjU(), TextUnitKt.getSp(18), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), startRestartGroup, 0, 3120, 55294);
            startRestartGroup = startRestartGroup;
            if (!StringsKt.isBlank(str6)) {
                startRestartGroup.startReplaceGroup(-1930820349);
                ComposerKt.sourceInformation(startRestartGroup, "898@36232L286");
                TextKt.m2798Text4IGK_g(str2, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(1.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Color.m4383copywmQWz5c$default(Color.INSTANCE.m4421getWhite0d7_KjU(), 0.92f, 0.0f, 0.0f, 0.0f, 14, null), TextUnitKt.getSp(13), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), startRestartGroup, ((i3 >> 3) & 14) | 48, 3120, 55292);
                startRestartGroup = startRestartGroup;
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1930531615);
                startRestartGroup.endReplaceGroup();
            }
            if (!StringsKt.isBlank(str4)) {
                startRestartGroup.startReplaceGroup(-1930468747);
                ComposerKt.sourceInformation(startRestartGroup, "906@36587L268");
                Composer composer2 = startRestartGroup;
                TextKt.m2798Text4IGK_g(str4, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(1.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), Color.m4383copywmQWz5c$default(Color.INSTANCE.m4421getWhite0d7_KjU(), 0.82f, 0.0f, 0.0f, 0.0f, 14, null), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer2, ((i3 >> 9) & 14) | 48, 3120, 55292);
                startRestartGroup = composer2;
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1930197311);
                startRestartGroup.endReplaceGroup();
            }
            if (!StringsKt.isBlank(str3)) {
                startRestartGroup.startReplaceGroup(-1930131219);
                ComposerKt.sourceInformation(startRestartGroup, "914@36923L404");
                Composer composer3 = startRestartGroup;
                TextKt.m2798Text4IGK_g(str3, PaddingKt.m1050paddingVpY3zN4(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(6.0f), 0.0f, 0.0f, 13, null), OxShape.INSTANCE.getPill()), Color.m4383copywmQWz5c$default(Color.INSTANCE.m4421getWhite0d7_KjU(), 0.22f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m6989constructorimpl(10.0f), Dp.m6989constructorimpl(3.0f)), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getChip(), Color.INSTANCE.m4421getWhite0d7_KjU(), TextUnitKt.getSp(11.5d), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), composer3, (i3 >> 6) & 14, 0, 65532);
                startRestartGroup = composer3;
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1929729087);
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda80
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MoreScreenKt.StoreHero$lambda$1(str, str2, str3, str4, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01c2  */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void SubscriptionBlock(final uz.FonRo.pos.data.model.Paywall r24, final boolean r25, final boolean r26, final uz.FonRo.pos.data.model.Coupon r27, final java.lang.String r28, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r29, final java.lang.String r30, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r31, final kotlin.jvm.functions.Function0<kotlin.Unit> r32, final kotlin.jvm.functions.Function0<kotlin.Unit> r33, final kotlin.jvm.functions.Function0<kotlin.Unit> r34, final kotlin.jvm.functions.Function0<kotlin.Unit> r35, final kotlin.jvm.functions.Function0<kotlin.Unit> r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instructions count: 772
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.more.MoreScreenKt.SubscriptionBlock(uz.FonRo.pos.data.model.Paywall, boolean, boolean, uz.FonRo.pos.data.model.Coupon, java.lang.String, kotlin.jvm.functions.Function1, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SubscriptionBlock$lambda$2(String str, Composer composer, int i) {
        String tx;
        ComposerKt.sourceInformation(composer, "C951@38051L256:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1244413062, i, -1, "uz.FonRo.pos.ui.more.SubscriptionBlock.<anonymous> (MoreScreen.kt:951)");
            }
            String tx2 = LangKt.tx("Подарок от FonRo", new Object[0]);
            if (str != null) {
                tx = LangKt.tx("Бесплатный полный доступ до %s", str);
            } else {
                tx = LangKt.tx("Бесплатный полный доступ активен", new Object[0]);
            }
            GradientHead("🎁", tx2, tx, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SubscriptionBlock$lambda$3(String str, boolean z, boolean z2, Function0 function0, Composer composer, int i) {
        String tx;
        ComposerKt.sourceInformation(composer, "C961@38471L280:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-978655823, i, -1, "uz.FonRo.pos.ui.more.SubscriptionBlock.<anonymous> (MoreScreen.kt:961)");
            }
            String tx2 = LangKt.tx("Подписка отменена", new Object[0]);
            if (str != null) {
                tx = LangKt.tx("Активна до %s, потом отключится", str);
            } else {
                tx = LangKt.tx("Активна до конца оплаченного периода", new Object[0]);
            }
            GradientHead("⏳", tx2, tx, composer, 6);
            if (z) {
                composer.startReplaceGroup(-897284803);
                ComposerKt.sourceInformation(composer, "968@38806L11,969@38838L76");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
                GlassButton(LangKt.tx("Возобновить подписку", new Object[0]), !z2, function0, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-897142575);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SubscriptionBlock$lambda$4(boolean z, boolean z2, Function0 function0, String str, Paywall paywall, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C974@39046L525:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2018947662, i, -1, "uz.FonRo.pos.ui.more.SubscriptionBlock.<anonymous> (MoreScreen.kt:974)");
            }
            String tx = LangKt.tx("FonRo Премиум активен", new Object[0]);
            StringBuilder sb = new StringBuilder();
            sb.append(str != null ? LangKt.tx("Действует до %s", str) : LangKt.tx("Подписка активна", new Object[0]));
            Plan plan = paywall.getPlan();
            if (plan != null) {
                sb.append(LangKt.tx(" · «%s»: владелец + ", plan.getName()));
                sb.append(Fmt.INSTANCE.plural(plan.getWorkers(), LangKt.tx("сотрудник", new Object[0]), LangKt.tx("сотрудника", new Object[0]), LangKt.tx("сотрудников", new Object[0])));
            }
            Unit unit = Unit.INSTANCE;
            GradientHead("👑", tx, sb.toString(), composer, 6);
            if (z) {
                composer.startReplaceGroup(252782123);
                ComposerKt.sourceInformation(composer, "986@39618L11,987@39646L73");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
                GlassButton(LangKt.tx("Отменить подписку", new Object[0]), !z2, function0, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(252909936);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void OfferCard(final Paywall paywall, final boolean z, final boolean z2, final Coupon coupon, final String str, final Function1<? super String, Unit> function1, final String str2, final Function1<? super String, Unit> function12, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, Composer composer, final int i, final int i2) {
        int i3;
        final boolean z3;
        final boolean z4;
        Function0<Unit> function04;
        Function0<Unit> function05;
        int i4;
        Composer composer2;
        int i5;
        int i6;
        float f;
        Composer startRestartGroup = composer.startRestartGroup(406899116);
        ComposerKt.sourceInformation(startRestartGroup, "C(OfferCard)P(9,1!3,6,10,7)1030@40993L5164,1030@40986L5171:MoreScreen.kt#1sifzz");
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? startRestartGroup.changed(paywall) : startRestartGroup.changedInstance(paywall) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            z3 = z;
            i3 |= startRestartGroup.changed(z3) ? 32 : 16;
        } else {
            z3 = z;
        }
        if ((i & 384) == 0) {
            z4 = z2;
            i3 |= startRestartGroup.changed(z4) ? 256 : 128;
        } else {
            z4 = z2;
        }
        if ((i & 3072) == 0) {
            i3 |= (i & 4096) == 0 ? startRestartGroup.changed(coupon) : startRestartGroup.changedInstance(coupon) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changed(str) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= startRestartGroup.changed(str2) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function12) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            function04 = function0;
            i3 |= startRestartGroup.changedInstance(function04) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            function04 = function0;
        }
        if ((805306368 & i) == 0) {
            function05 = function02;
            i3 |= startRestartGroup.changedInstance(function05) ? 536870912 : 268435456;
        } else {
            function05 = function02;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (startRestartGroup.changedInstance(function03) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if (!startRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i4 & 3) == 2) ? false : true, i3 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(406899116, i3, i4, "uz.FonRo.pos.ui.more.OfferCard (MoreScreen.kt:1020)");
            }
            int coerceAtLeast = RangesKt.coerceAtLeast(paywall.getLimit(), 0);
            int remaining = paywall.getRemaining() > 0 ? paywall.getRemaining() : RangesKt.coerceAtLeast(coerceAtLeast - paywall.getWebSales(), 0);
            final int coerceAtLeast2 = RangesKt.coerceAtLeast(coerceAtLeast - remaining, 0);
            boolean z5 = remaining <= 0;
            if (coerceAtLeast > 0) {
                i6 = remaining;
                i5 = coerceAtLeast;
                f = RangesKt.coerceIn(coerceAtLeast2 / coerceAtLeast, 0.0f, 1.0f);
            } else {
                i5 = coerceAtLeast;
                i6 = remaining;
                f = 1.0f;
            }
            final Function0<Unit> function06 = function05;
            final float f2 = f;
            final boolean z6 = z5;
            final int i7 = i6;
            final int i8 = i5;
            final Function0<Unit> function07 = function04;
            Function3 function3 = new Function3() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MoreScreenKt.OfferCard$lambda$0(z6, i8, coerceAtLeast2, i7, paywall, coupon, function06, z3, z4, function03, f2, str2, function12, str, function1, function07, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            composer2 = startRestartGroup;
            BasicsKt.m9829OxCardEOp_iR4(null, 0.0f, 0L, null, null, ComposableLambdaKt.rememberComposableLambda(-2030397679, true, function3, composer2, 54), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MoreScreenKt.OfferCard$lambda$1(Paywall.this, z, z2, coupon, str, function1, str2, function12, function0, function02, function03, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OfferCard$lambda$0(boolean z, int i, int i2, int i3, Paywall paywall, Coupon coupon, Function0 function0, boolean z2, boolean z3, Function0 function02, float f, String str, final Function1 function1, String str2, Function1 function12, Function0 function03, ColumnScope OxCard, Composer composer, int i4) {
        String tx;
        String str3;
        boolean z4;
        String str4;
        String str5;
        String str6;
        boolean z5;
        Composer composer2;
        float m6989constructorimpl;
        Intrinsics.checkNotNullParameter(OxCard, "$this$OxCard");
        ComposerKt.sourceInformation(composer, "C1031@41003L139,1035@41151L10,1036@41170L342,1043@41521L11,1045@41542L428,1106@44102L10,1137@45302L11,1138@45322L225,1146@45556L10,1147@45575L203,1158@45938L10,1159@45957L194:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i4 & 17) != 16, i4 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2030397679, i4, -1, "uz.FonRo.pos.ui.more.OfferCard.<anonymous> (MoreScreen.kt:1031)");
            }
            TextKt.m2798Text4IGK_g(z ? LangKt.tx("🔒 Бесплатный период закончился", new Object[0]) : LangKt.tx("⭐ FonRo Премиум", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH2(), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(7.0f), composer, 6);
            if (z) {
                tx = LangKt.tx("Бесплатные продажи закончились (%s). Выберите тариф, чтобы продолжать продавать и проводить приход.", Integer.valueOf(i));
            } else {
                tx = LangKt.tx("Использовано %s из %s бесплатных продаж, осталось %s.", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3));
            }
            TextKt.m2798Text4IGK_g(tx, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            Composer composer3 = composer;
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer3, 6);
            float f2 = 0.0f;
            Object obj = null;
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1082height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6989constructorimpl(8.0f)), OxShape.INSTANCE.getPill()), Ox.INSTANCE.m10236getTrack0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            boolean z6 = false;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int i5 = -1323940314;
            String str7 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, m558backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            String str8 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor);
            } else {
                composer3.useNode();
            }
            Composer m3808constructorimpl = Updater.m3808constructorimpl(composer3);
            Updater.m3815setimpl(m3808constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, -1351768656, "C1052@41728L232:MoreScreen.kt#1sifzz");
            Modifier clip = ClipKt.clip(SizeKt.m1082height3ABfNKs(SizeKt.fillMaxWidth(Modifier.INSTANCE, f), Dp.m6989constructorimpl(8.0f)), OxShape.INSTANCE.getPill());
            Ox ox = Ox.INSTANCE;
            BoxKt.Box(BackgroundKt.m558backgroundbw27NRU$default(clip, z ? ox.m10224getRed0d7_KjU() : ox.m10220getPrimary0d7_KjU(), null, 2, null), composer3, 0);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            String str9 = "C101@5232L9:Row.kt#2w3rfo";
            int i6 = 54;
            String str10 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
            int i7 = 693286680;
            if (!paywall.getPlans().isEmpty()) {
                composer3.startReplaceGroup(-1551752733);
                ComposerKt.sourceInformation(composer3, "1062@42026L11,*1076@42691L23,1065@42149L1837");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(14.0f), composer3, 6);
                for (final Plan plan : paywall.getPlans()) {
                    boolean areEqual = Intrinsics.areEqual(plan.getKey(), str);
                    Modifier clip2 = ClipKt.clip(PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, f2, 1, obj), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(8.0f), 7, null), OxShape.INSTANCE.getTile());
                    Ox ox2 = Ox.INSTANCE;
                    Modifier m558backgroundbw27NRU$default2 = BackgroundKt.m558backgroundbw27NRU$default(clip2, areEqual ? ox2.m10222getPrimarySoft0d7_KjU() : ox2.m10217getPanel0d7_KjU(), null, 2, null);
                    if (areEqual) {
                        m6989constructorimpl = Dp.m6989constructorimpl(1.5f);
                    } else {
                        m6989constructorimpl = Dp.m6989constructorimpl(1.0f);
                    }
                    Ox ox3 = Ox.INSTANCE;
                    String str11 = str8;
                    Modifier m569borderxT4_qwU = BorderKt.m569borderxT4_qwU(m558backgroundbw27NRU$default2, m6989constructorimpl, areEqual ? ox3.m10220getPrimary0d7_KjU() : ox3.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getTile());
                    ComposerKt.sourceInformationMarkerStart(composer3, -153222811, "CC(remember):MoreScreen.kt#9igjgp");
                    boolean changed = composer3.changed(function1) | composer3.changedInstance(plan);
                    Object rememberedValue = composer3.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda52
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit OfferCard$lambda$0$1$0$0;
                                OfferCard$lambda$0$1$0$0 = MoreScreenKt.OfferCard$lambda$0$1$0$0(Function1.this, plan);
                                return OfferCard$lambda$0$1$0$0;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(SizeKt.m1084heightInVpY3zN4$default(ModifiersKt.oxClickable$default(m569borderxT4_qwU, false, null, 150L, (Function0) rememberedValue, 3, null), Dp.m6989constructorimpl(56.0f), f2, 2, obj), Dp.m6989constructorimpl(14.0f), Dp.m6989constructorimpl(10.0f));
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
                    ComposerKt.sourceInformationMarkerStart(composer3, i7, str10);
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, composer3, i6);
                    ComposerKt.sourceInformationMarkerStart(composer3, i5, str7);
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, m1050paddingVpY3zN4);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, str11);
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
                    Updater.m3815setimpl(m3808constructorimpl2, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, -407735110, str9);
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, 138483639, "C1082@43014L580,1094@43615L353:MoreScreen.kt#1sifzz");
                    Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                    ComposerKt.sourceInformationMarkerStart(composer3, i5, str7);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer3, weight$default);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, str11);
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
                    Updater.m3815setimpl(m3808constructorimpl3, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, 937360899, "C1083@43068L238,1088@43331L241:MoreScreen.kt#1sifzz");
                    String str12 = str9;
                    String str13 = str7;
                    String str14 = str10;
                    TextKt.m2798Text4IGK_g(plan.getName(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowTitle(), 0L, 0L, FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 0, 3120, 55294);
                    TextKt.m2798Text4IGK_g(LangKt.tx("Владелец + ", new Object[0]) + Fmt.INSTANCE.plural(plan.getWorkers(), LangKt.tx("сотрудник", new Object[0]), LangKt.tx("сотрудника", new Object[0]), LangKt.tx("сотрудников", new Object[0])), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 0, 0, 65534);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    Alignment.Horizontal end = Alignment.INSTANCE.getEnd();
                    ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), end, composer, 48);
                    ComposerKt.sourceInformationMarkerStart(composer, -1323940314, str13);
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
                    Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, companion);
                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer, -692256719, str11);
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
                    ComposerKt.sourceInformationMarkerStart(composer, 1587675199, "C1095@43685L171,1099@43881L65:MoreScreen.kt#1sifzz");
                    TextKt.m2798Text4IGK_g(Fmt.INSTANCE.nf(Double.valueOf(plan.getPrice())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowPrice(), 0L, 0L, FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 0, 0, 65534);
                    TextKt.m2798Text4IGK_g(LangKt.tx("сум/мес", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), Ox.INSTANCE.m10200getDim20d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
                    composer3 = composer;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    z6 = false;
                    str9 = str12;
                    str10 = str14;
                    str8 = str11;
                    str7 = str13;
                    f2 = 0.0f;
                    obj = null;
                    i5 = -1323940314;
                    i6 = 54;
                    i7 = 693286680;
                }
                str3 = str9;
                z4 = z6;
                str4 = str7;
                str5 = str10;
                str6 = str8;
                composer3.endReplaceGroup();
            } else {
                str3 = "C101@5232L9:Row.kt#2w3rfo";
                z4 = false;
                str4 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                str5 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                str6 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                composer3.startReplaceGroup(-1549832655);
                composer3.endReplaceGroup();
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(4.0f), composer3, 6);
            if (coupon != null) {
                composer3.startReplaceGroup(-1549692814);
                ComposerKt.sourceInformation(composer3, "1108@44155L187,1112@44355L10,1113@44378L72");
                TextKt.m2798Text4IGK_g(LangKt.tx("🎟 Промокод %s: −%s%%", coupon.getCode(), Fmt.INSTANCE.nf(Double.valueOf(coupon.getPercent()))), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10211getOk0d7_KjU(), 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composer, 0, 0, 65534);
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(2.0f), composer, 6);
                TextKt.m2798Text4IGK_g(LangKt.tx("Скидка применится на странице оплаты", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
                composer2 = composer;
                composer2.endReplaceGroup();
                z5 = true;
            } else {
                composer3.startReplaceGroup(-1549354697);
                ComposerKt.sourceInformation(composer3, "1115@44480L802");
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer3, 693286680, str5);
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, centerVertically2, composer3, 54);
                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, str4);
                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composer3.getCurrentCompositionLocalMap();
                Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer3, fillMaxWidth$default);
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, str6);
                if (!(composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor5);
                } else {
                    composer3.useNode();
                }
                Composer m3808constructorimpl5 = Updater.m3808constructorimpl(composer3);
                Updater.m3815setimpl(m3808constructorimpl5, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3815setimpl(m3808constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3808constructorimpl5.getInserting() || !Intrinsics.areEqual(m3808constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                    m3808constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                    m3808constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                }
                Updater.m3815setimpl(m3808constructorimpl5, materializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer3, -407735110, str3);
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer3, -854918034, "C1120@44689L379,1129@45085L183:MoreScreen.kt#1sifzz");
                z5 = true;
                FieldsKt.m9847OxInputWwzLCwM(str2, function12, RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), LangKt.tx("Промокод (если есть)", new Object[0]), 0, ImeAction.INSTANCE.m6635getDoneeUduSuo(), function03, false, false, z2 && !z3, false, false, null, null, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 15760);
                composer2 = composer;
                BasicsKt.OxButton("OK", function03, null, null, null, (!z2 || z3 || StringsKt.isBlank(str2)) ? false : true, false, null, composer2, 6, 220);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer2, 6);
            BasicsKt.OxButton(LangKt.tx("Оформить подписку", new Object[0]), function0, null, BtnStyle.PRIMARY, BtnSize.LG, z2, true, null, composer2, 1600512, 132);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer2, 6);
            BasicsKt.OxButton(LangKt.tx("Я оплатил — обновить", new Object[0]), function02, null, BtnStyle.GHOST, null, (!z2 || z3) ? false : z5, true, null, composer2, 1575936, 148);
            if (!z2) {
                composer2.startReplaceGroup(-1548049132);
                ComposerKt.sourceInformation(composer2, "1155@45818L10,1156@45841L78");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer2, 6);
                TextKt.m2798Text4IGK_g(LangKt.tx("Подпиской магазина распоряжается владелец.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1547929007);
                composer2.endReplaceGroup();
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer2, 6);
            TextKt.m2798Text4IGK_g(LangKt.tx("Тариф ограничивает только число сотрудников. Товары, статистика и остальные разделы — без ограничений.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), Ox.INSTANCE.m10200getDim20d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfferCard$lambda$0$1$0$0(Function1 function1, Plan plan) {
        function1.invoke(plan.getKey());
        return Unit.INSTANCE;
    }

    private static final void GradientCard(final List<Color> list, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(750372141);
        ComposerKt.sourceInformation(startRestartGroup, "C(GradientCard)1168@46258L198:MoreScreen.kt#1sifzz");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(list) : startRestartGroup.changedInstance(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(750372141, i3, -1, "uz.FonRo.pos.ui.more.GradientCard (MoreScreen.kt:1167)");
            }
            Modifier m1049padding3ABfNKs = PaddingKt.m1049padding3ABfNKs(BackgroundKt.background$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), OxShape.INSTANCE.getCard()), Brush.Companion.m4335linearGradientmHitzGk$default(Brush.INSTANCE, list, 0L, 0L, 0, 14, (Object) null), null, 0.0f, 6, null), Dp.m6989constructorimpl(16.0f));
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1556391895, "C1175@46441L9:MoreScreen.kt#1sifzz");
            function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 3) & 14));
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda82
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MoreScreenKt.GradientCard$lambda$1(list, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void GradientHead(final String str, final String str2, String str3, Composer composer, final int i) {
        int i2;
        final String str4;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1070891377);
        ComposerKt.sourceInformation(startRestartGroup, "C(GradientHead)P(!1,2)1181@46551L593:MoreScreen.kt#1sifzz");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(str3) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            str4 = str3;
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1070891377, i2, -1, "uz.FonRo.pos.ui.more.GradientHead (MoreScreen.kt:1180)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1718263372, "C1185@46688L75,1186@46772L366:MoreScreen.kt#1sifzz");
            int i3 = i2;
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), 0L, TextUnitKt.getSp(26), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(30), null, null, null, 0, 0, null, 16646141, null), startRestartGroup, i2 & 14, 0, 65534);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
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
            Updater.m3815setimpl(m3808constructorimpl2, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1340380073, "C1187@46793L120,1191@46926L202:MoreScreen.kt#1sifzz");
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH2(), Color.INSTANCE.m4421getWhite0d7_KjU(), TextUnitKt.getSp(17), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), composer2, (i3 >> 3) & 14, 0, 65534);
            str4 = str3;
            TextKt.m2798Text4IGK_g(str4, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(2.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Color.m4383copywmQWz5c$default(Color.INSTANCE.m4421getWhite0d7_KjU(), 0.92f, 0.0f, 0.0f, 0.0f, 14, null), TextUnitKt.getSp(13), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), composer2, ((i3 >> 6) & 14) | 48, 0, 65532);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MoreScreenKt.GradientHead$lambda$1(str, str2, str4, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void GlassButton(final String str, final boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-736334921);
        ComposerKt.sourceInformation(startRestartGroup, "C(GlassButton)P(2)1203@47327L553:MoreScreen.kt#1sifzz");
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
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-736334921, i3, -1, "uz.FonRo.pos.ui.more.GlassButton (MoreScreen.kt:1202)");
            }
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(SizeKt.m1084heightInVpY3zN4$default(ModifiersKt.oxClickable$default(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), OxShape.INSTANCE.getBtn()), Color.m4383copywmQWz5c$default(Color.INSTANCE.m4421getWhite0d7_KjU(), z ? 0.2f : 0.1f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), z, null, 0L, function0, 6, null), OxDim.INSTANCE.m10249getTapD9Ej5fM(), 0.0f, 2, null), Dp.m6989constructorimpl(16.0f), Dp.m6989constructorimpl(10.0f));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326653585, "C1213@47711L163:MoreScreen.kt#1sifzz");
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getButton(), Color.m4383copywmQWz5c$default(Color.INSTANCE.m4421getWhite0d7_KjU(), z ? 1.0f : 0.6f, 0.0f, 0.0f, 0.0f, 14, null), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer2, i3 & 14, 0, 65534);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MoreScreenKt.GlassButton$lambda$1(str, z, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* renamed from: LinkIcon-RPmYEkk, reason: not valid java name */
    private static final void m10045LinkIconRPmYEkk(final ImageVector imageVector, final long j, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(509479972);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinkIcon)P(!,1:c#ui.graphics.Color)1226@47988L281:MoreScreen.kt#1sifzz");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(imageVector) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(509479972, i2, -1, "uz.FonRo.pos.ui.more.LinkIcon (MoreScreen.kt:1225)");
            }
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(38.0f)), OxShape.INSTANCE.getIconChip()), Ox.INSTANCE.m10241tintBg5vOe2sY(j, 0.12f), null, 2, null);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2003747918, "C1233@48180L83:MoreScreen.kt#1sifzz");
            IconKt.m2255Iconww6aTOc(imageVector, (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(20.0f)), j, startRestartGroup, (i2 & 14) | 432 | ((i2 << 6) & 7168), 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.more.MoreScreenKt$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MoreScreenKt.LinkIcon_RPmYEkk$lambda$1(ImageVector.this, j, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void openExternal(Context context, String str) {
        Object m7870constructorimpl;
        if (StringsKt.isBlank(str)) {
            Toaster.INSTANCE.error(LangKt.tx("Ссылка на оплату ещё не настроена. Напишите в поддержку.", new Object[0]));
            return;
        }
        Intent addFlags = new Intent("android.intent.action.VIEW", Uri.parse(str)).addFlags(268435456);
        Intrinsics.checkNotNullExpressionValue(addFlags, "addFlags(...)");
        try {
            Result.Companion companion = Result.INSTANCE;
            context.startActivity(addFlags);
            m7870constructorimpl = Result.m7870constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7873exceptionOrNullimpl(m7870constructorimpl) != null) {
            Toaster.INSTANCE.error(LangKt.tx("Не удалось открыть браузер для оплаты", new Object[0]));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        if (r5 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.lang.String checkoutUrl(uz.FonRo.pos.data.model.Paywall r4, java.lang.String r5, uz.FonRo.pos.data.model.Coupon r6) {
        /*
            r0 = 0
            if (r4 == 0) goto L2b
            java.util.List r1 = r4.getPlans()
            if (r1 == 0) goto L2b
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        Lf:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L27
            java.lang.Object r2 = r1.next()
            r3 = r2
            uz.FonRo.pos.data.model.Plan r3 = (uz.FonRo.pos.data.model.Plan) r3
            java.lang.String r3 = r3.getKey()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r5)
            if (r3 == 0) goto Lf
            goto L28
        L27:
            r2 = r0
        L28:
            uz.FonRo.pos.data.model.Plan r2 = (uz.FonRo.pos.data.model.Plan) r2
            goto L2c
        L2b:
            r2 = r0
        L2c:
            if (r2 == 0) goto L41
            java.lang.String r5 = r2.getCheckoutUrl()
            if (r5 == 0) goto L41
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            if (r1 != 0) goto L3e
            goto L3f
        L3e:
            r5 = r0
        L3f:
            if (r5 != 0) goto L5c
        L41:
            if (r4 == 0) goto L56
            java.lang.String r4 = r4.getCheckoutUrl()
            if (r4 == 0) goto L56
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = kotlin.text.StringsKt.isBlank(r5)
            if (r5 != 0) goto L53
            goto L54
        L53:
            r4 = r0
        L54:
            r5 = r4
            goto L57
        L56:
            r5 = r0
        L57:
            if (r5 != 0) goto L5c
            java.lang.String r4 = ""
            return r4
        L5c:
            if (r6 == 0) goto La0
            java.lang.String r4 = r6.getCode()
            if (r4 == 0) goto La0
            r6 = r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = kotlin.text.StringsKt.isBlank(r6)
            if (r6 != 0) goto L6e
            goto L6f
        L6e:
            r4 = r0
        L6f:
            if (r4 != 0) goto L72
            goto La0
        L72:
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r1 = 0
            r2 = 2
            r3 = 63
            boolean r6 = kotlin.text.StringsKt.contains$default(r6, r3, r1, r2, r0)
            if (r6 == 0) goto L82
            java.lang.String r6 = "&"
            goto L84
        L82:
            java.lang.String r6 = "?"
        L84:
            java.lang.String r4 = android.net.Uri.encode(r4)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            r0.append(r6)
            java.lang.String r5 = "checkout[discount_code]="
            r0.append(r5)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            return r4
        La0:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.more.MoreScreenKt.checkoutUrl(uz.FonRo.pos.data.model.Paywall, java.lang.String, uz.FonRo.pos.data.model.Coupon):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paywall paywallFrom(JsonElement jsonElement) {
        Object m7870constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            JsonElement field = ApiClient.INSTANCE.field(jsonElement, "paywall");
            m7870constructorimpl = Result.m7870constructorimpl(field == null ? null : (Paywall) ApiClient.INSTANCE.getJson().decodeFromJsonElement(Paywall.INSTANCE.serializer(), field));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        return (Paywall) (Result.m7876isFailureimpl(m7870constructorimpl) ? null : m7870constructorimpl);
    }

    private static final User MoreScreen$lambda$0(State<User> state) {
        return state.getValue();
    }

    private static final Store MoreScreen$lambda$1(State<Store> state) {
        return state.getValue();
    }

    private static final List<SaleOutbox.Pending> MoreScreen$lambda$3(State<? extends List<SaleOutbox.Pending>> state) {
        return state.getValue();
    }
}
