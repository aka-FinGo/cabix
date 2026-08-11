package uz.FonRo.pos.ui.orders;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.SliderDefaults;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.SwitchDefaults;
import androidx.compose.material3.SwitchKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
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
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Units;
import uz.FonRo.pos.data.model.ShopOrder;
import uz.FonRo.pos.data.model.ShopOrderItem;
import uz.FonRo.pos.data.model.ShopReview;
import uz.FonRo.pos.data.model.ShopStoreInfo;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnSize;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.ChipTint;
import uz.FonRo.pos.ui.components.ChipTone;
import uz.FonRo.pos.ui.components.ChipsKt;
import uz.FonRo.pos.ui.components.FieldsKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.PageHeadKt;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.sale.CartStore;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxDim;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: OrdersScreen.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0006\u001aC\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0016\u001ae\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\b#\u0010$\u001aG\u0010%\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020 2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010'\u001a7\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010+\u001aI\u0010,\u001a\u00020\u00012\u0006\u0010-\u001a\u00020.2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u000e002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u00102\u001a\u0081\u0001\u00103\u001a\u00020\u00012\u0006\u0010-\u001a\u00020.2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u000e002\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u00109\u001a'\u0010:\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u000eH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010;\u001a/\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\u000eH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010?\u001a'\u0010@\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u000eH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010;\u001a'\u0010A\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u000eH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010;\u001aI\u0010B\u001a\u00020\u00012\u0006\u0010-\u001a\u00020.2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000100H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010C\u001a5\u0010D\u001a\u00020\u00012\u0006\u0010E\u001a\u00020F2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010H\u001a'\u0010I\u001a\u00020\u00012\u0006\u0010J\u001a\u00020KH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010L\u001aI\u0010M\u001a\u00020\u00012\u0006\u0010E\u001a\u00020F2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000100H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010O\u001aI\u0010P\u001a\u00020\u00012\u0006\u0010Q\u001a\u00020R2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020\u000100H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010S\u001aW\u0010T\u001a\u00020\u00012\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010V\u001a\u00020\u000e2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000100H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010X\u001a\u0010\u0010Y\u001a\u00020\u000e2\u0006\u0010>\u001a\u000201H\u0002\u001a\u0010\u0010Z\u001a\u0002012\u0006\u0010[\u001a\u00020\u000eH\u0002\u001a\u0010\u0010\\\u001a\u00020\u000e2\u0006\u0010]\u001a\u00020\u000eH\u0002\u001a\u0010\u0010^\u001a\u00020_2\u0006\u0010]\u001a\u00020\u000eH\u0002\"&\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r0\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0002²\u0006\f\u0010Q\u001a\u0004\u0018\u00010RX\u008a\u008e\u0002²\u0006\n\u0010`\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010]\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\u0010\u0010a\u001a\b\u0012\u0004\u0012\u00020.0\fX\u008a\u008e\u0002²\u0006\n\u0010b\u001a\u00020 X\u008a\u008e\u0002²\u0006\n\u0010c\u001a\u00020 X\u008a\u008e\u0002²\u0006\u0010\u0010d\u001a\b\u0012\u0004\u0012\u00020F0\fX\u008a\u008e\u0002²\u0006\n\u0010e\u001a\u00020 X\u008a\u008e\u0002²\u0006\f\u0010f\u001a\u0004\u0018\u00010FX\u008a\u008e\u0002²\u0006\f\u0010g\u001a\u0004\u0018\u00010hX\u008a\u008e\u0002²\u0006\f\u0010i\u001a\u0004\u0018\u00010.X\u008a\u008e\u0002²\u0006\f\u0010j\u001a\u0004\u0018\u00010.X\u008a\u008e\u0002²\u0006\n\u0010k\u001a\u00020 X\u008a\u008e\u0002²\u0006\n\u0010l\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u0018\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010m\u001a\u00020 X\u008a\u008e\u0002²\u0006\n\u0010n\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010o\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010p\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010q\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010r\u001a\u00020 X\u008a\u008e\u0002²\u0006\n\u0010s\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010t\u001a\u00020uX\u008a\u008e\u0002²\u0006\n\u0010v\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\f\u0010w\u001a\u0004\u0018\u000101X\u008a\u008e\u0002²\u0006\f\u0010x\u001a\u0004\u0018\u000101X\u008a\u008e\u0002²\u0006\n\u0010y\u001a\u00020 X\u008a\u008e\u0002"}, d2 = {"OrdersScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "STATUS_FILTERS", "", "Lkotlin/Pair;", "", "getSTATUS_FILTERS", "()Ljava/util/List;", "ShopLinkCard", ImagesContract.URL, "onOpen", "Lkotlin/Function0;", "onShare", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SoftButton", "text", "background", "Landroidx/compose/ui/graphics/Color;", "foreground", "onClick", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "height", "Landroidx/compose/ui/unit/Dp;", "SoftButton-j4UnuUM", "(Ljava/lang/String;JJLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZFLandroidx/compose/runtime/Composer;II)V", "ShopTab", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ShopEmpty", "icon", "title", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "OrderCard", "order", "Luz/FonRo/pos/data/model/ShopOrder;", "money", "Lkotlin/Function1;", "", "(Luz/FonRo/pos/data/model/ShopOrder;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "OrderSheet", "onDismiss", "onConfirm", "onCancel", "onMoveToCart", "onFinish", "(Luz/FonRo/pos/data/model/ShopOrder;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SectionCaption", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "DetailRow", "label", "value", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "ShopLine", "LinkLine", "CancelSheet", "(Luz/FonRo/pos/data/model/ShopOrder;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ReviewCard", "review", "Luz/FonRo/pos/data/model/ShopReview;", "onReply", "(Luz/FonRo/pos/data/model/ShopReview;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Stars", "rating", "", "(ILandroidx/compose/runtime/Composer;I)V", "ReplySheet", "onSave", "(Luz/FonRo/pos/data/model/ShopReview;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ShopSettingsSheet", "info", "Luz/FonRo/pos/data/model/ShopStoreInfo;", "(Luz/FonRo/pos/data/model/ShopStoreInfo;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "CurrencyPickerSheet", "currencies", "selected", "onPick", "(Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "plainAmount", "parseAmount", "raw", "statusLabel", NotificationCompat.CATEGORY_STATUS, "statusTone", "Luz/FonRo/pos/ui/components/ChipTone;", "mode", "allOrders", "loading", "failed", "reviews", "reviewsLoading", "replyFor", "openId", "", "cancelFor", "replaceCartFor", "showSettings", "reason", "isEnabled", "name", "slug", "description", FirebaseAnalytics.Param.CURRENCY, "deliveryEnabled", "deliveryPrice", "deliveryRadius", "", "deliveryMinAmount", "lat", "lng", "pickCurrency"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class OrdersScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CancelSheet$lambda$5(ShopOrder shopOrder, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        CancelSheet(shopOrder, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CurrencyPickerSheet$lambda$1(List list, String str, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        CurrencyPickerSheet(list, str, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DetailRow$lambda$1(String str, String str2, int i, Composer composer, int i2) {
        DetailRow(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LinkLine$lambda$0(String str, int i, Composer composer, int i2) {
        LinkLine(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OrderCard$lambda$2(ShopOrder shopOrder, Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        OrderCard(shopOrder, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OrderSheet$lambda$4(ShopOrder shopOrder, Function1 function1, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, int i, Composer composer, int i2) {
        OrderSheet(shopOrder, function1, function0, function02, function03, function04, function05, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OrdersScreen$lambda$56(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        OrdersScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReplySheet$lambda$5(ShopReview shopReview, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        ReplySheet(shopReview, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReviewCard$lambda$1(ShopReview shopReview, Function0 function0, int i, Composer composer, int i2) {
        ReviewCard(shopReview, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SectionCaption$lambda$0(String str, int i, Composer composer, int i2) {
        SectionCaption(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ShopEmpty$lambda$1(String str, String str2, String str3, int i, Composer composer, int i2) {
        ShopEmpty(str, str2, str3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ShopLine$lambda$0(String str, int i, Composer composer, int i2) {
        ShopLine(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ShopLinkCard$lambda$1(String str, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        ShopLinkCard(str, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ShopSettingsSheet$lambda$41(ShopStoreInfo shopStoreInfo, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        ShopSettingsSheet(shopStoreInfo, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ShopTab$lambda$0(String str, boolean z, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ShopTab(str, z, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SoftButton_j4UnuUM$lambda$1(String str, long j, long j2, Function0 function0, Modifier modifier, boolean z, float f, int i, int i2, Composer composer, int i3) {
        m10077SoftButtonj4UnuUM(str, j, j2, function0, modifier, z, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Stars$lambda$0(int i, int i2, Composer composer, int i3) {
        Stars(i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void OrdersScreen(final FonRoApp app, final AppNavigator nav, Composer composer, final int i) {
        int i2;
        final MutableState mutableState;
        String str;
        MutableState mutableState2;
        final MutableState mutableState3;
        final MutableState mutableState4;
        final MutableState mutableState5;
        final MutableState mutableState6;
        Repo repo;
        OrdersScreenKt$OrdersScreen$1$1 ordersScreenKt$OrdersScreen$1$1;
        Object obj;
        MutableState mutableState7;
        MutableState mutableState8;
        final Repo repo2;
        final MutableState mutableState9;
        MutableState mutableState10;
        MutableState mutableState11;
        final ShopOrder shopOrder;
        CoroutineScope coroutineScope;
        MutableState mutableState12;
        MutableState mutableState13;
        MutableState mutableState14;
        MutableState mutableState15;
        int i3;
        Object obj2;
        MutableState mutableState16;
        final ShopOrder shopOrder2;
        String str2;
        String str3;
        final MutableState mutableState17;
        Object obj3;
        final ShopOrder shopOrder3;
        int i4;
        int i5;
        CoroutineScope coroutineScope2;
        MutableState mutableState18;
        MutableState mutableState19;
        MutableState mutableState20;
        final MutableState mutableState21;
        final MutableState mutableState22;
        final MutableState mutableState23;
        final MutableState mutableState24;
        CoroutineScope coroutineScope3;
        final MutableState mutableState25;
        MutableState mutableState26;
        CoroutineScope coroutineScope4;
        final MutableState mutableState27;
        final MutableState mutableState28;
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(nav, "nav");
        Composer startRestartGroup = composer.startRestartGroup(-1434240911);
        ComposerKt.sourceInformation(startRestartGroup, "C(OrdersScreen)104@4393L24,105@4449L7,107@4474L49,108@4540L37,109@4618L31,110@4689L57,111@4766L33,112@4818L34,114@4873L58,115@4958L34,116@5013L46,118@5078L121,122@5219L40,123@5281L45,124@5353L45,125@5423L34,152@6501L176,152@6480L197,161@6833L40,161@6812L61,284@11445L4423,279@11267L4601:OrdersScreen.kt#ge60a7");
        if ((i & 6) == 0) {
            i2 = i | ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(nav) : startRestartGroup.changedInstance(nav) ? 32 : 16;
        }
        if (startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1434240911, i2, -1, "uz.FonRo.pos.ui.orders.OrdersScreen (OrdersScreen.kt:102)");
            }
            Repo repo3 = app.getRepo();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)558@25470L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -954203484, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final CoroutineScope coroutineScope5 = (CoroutineScope) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Context context = (Context) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 378992194, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState29 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 378994294, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("checks", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState30 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 378996784, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState31 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 378999082, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            MutableState mutableState32 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 379001522, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            MutableState mutableState33 = (MutableState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 379003187, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            MutableState mutableState34 = (MutableState) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 379004971, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            final MutableState mutableState35 = (MutableState) rememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 379007667, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                rememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            final MutableState mutableState36 = (MutableState) rememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 379009439, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            int i6 = i2;
            if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                rememberedValue10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            final MutableState mutableState37 = (MutableState) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            List<ShopOrder> OrdersScreen$lambda$10 = OrdersScreen$lambda$10(mutableState32);
            String OrdersScreen$lambda$7 = OrdersScreen$lambda$7(mutableState31);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 379011594, "CC(remember):OrdersScreen.kt#9igjgp");
            boolean changed = startRestartGroup.changed(OrdersScreen$lambda$10) | startRestartGroup.changed(OrdersScreen$lambda$7);
            ArrayList rememberedValue11 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                if (StringsKt.isBlank(OrdersScreen$lambda$7(mutableState31))) {
                    rememberedValue11 = OrdersScreen$lambda$10(mutableState32);
                } else {
                    List<ShopOrder> OrdersScreen$lambda$102 = OrdersScreen$lambda$10(mutableState32);
                    ArrayList arrayList = new ArrayList();
                    Iterator it = OrdersScreen$lambda$102.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        Iterator it2 = it;
                        if (Intrinsics.areEqual(((ShopOrder) next).getStatus(), OrdersScreen$lambda$7(mutableState31))) {
                            arrayList.add(next);
                        }
                        it = it2;
                    }
                    rememberedValue11 = arrayList;
                }
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            final List list = (List) rememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 379016025, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue12 = startRestartGroup.rememberedValue();
            if (rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                rememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            MutableState mutableState38 = (MutableState) rememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 379018014, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue13 = startRestartGroup.rememberedValue();
            if (rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState38;
                mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(mutableStateOf$default2);
                rememberedValue13 = mutableStateOf$default2;
            } else {
                mutableState = mutableState38;
            }
            final MutableState mutableState39 = (MutableState) rememberedValue13;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 379020318, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue14 = startRestartGroup.rememberedValue();
            if (rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                str = "";
                mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(mutableStateOf$default);
                rememberedValue14 = mutableStateOf$default;
            } else {
                str = "";
            }
            MutableState mutableState40 = (MutableState) rememberedValue14;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 379022547, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue15 = startRestartGroup.rememberedValue();
            if (rememberedValue15 == Composer.INSTANCE.getEmpty()) {
                mutableState2 = mutableState40;
                rememberedValue15 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue15);
            } else {
                mutableState2 = mutableState40;
            }
            MutableState mutableState41 = (MutableState) rememberedValue15;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 379057185, "CC(remember):OrdersScreen.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(repo3) | startRestartGroup.changedInstance(context);
            Object rememberedValue16 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue16 == Composer.INSTANCE.getEmpty()) {
                mutableState3 = mutableState33;
                mutableState4 = mutableState29;
                mutableState5 = mutableState32;
                mutableState6 = mutableState34;
                OrdersScreenKt$OrdersScreen$1$1 ordersScreenKt$OrdersScreen$1$12 = new OrdersScreenKt$OrdersScreen$1$1(repo3, context, mutableState3, mutableState4, mutableState5, mutableState6, null);
                repo = repo3;
                ordersScreenKt$OrdersScreen$1$1 = ordersScreenKt$OrdersScreen$1$12;
                startRestartGroup.updateRememberedValue(ordersScreenKt$OrdersScreen$1$1);
            } else {
                ordersScreenKt$OrdersScreen$1$1 = rememberedValue16;
                repo = repo3;
                mutableState3 = mutableState33;
                mutableState4 = mutableState29;
                mutableState5 = mutableState32;
                mutableState6 = mutableState34;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final MutableState mutableState42 = mutableState41;
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) ordersScreenKt$OrdersScreen$1$1, startRestartGroup, 6);
            String OrdersScreen$lambda$4 = OrdersScreen$lambda$4(mutableState30);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 379067673, "CC(remember):OrdersScreen.kt#9igjgp");
            OrdersScreenKt$OrdersScreen$2$1 rememberedValue17 = startRestartGroup.rememberedValue();
            if (rememberedValue17 == Composer.INSTANCE.getEmpty()) {
                rememberedValue17 = new OrdersScreenKt$OrdersScreen$2$1(mutableState30, mutableState36, mutableState35, null);
                startRestartGroup.updateRememberedValue(rememberedValue17);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(OrdersScreen$lambda$4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue17, startRestartGroup, 0);
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), OxDim.INSTANCE.m10245getPagePadD9Ej5fM(), 0.0f, 2, null);
            PaddingValues m1046PaddingValuesa9UjIt4$default = PaddingKt.m1046PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(28.0f), 7, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 379219640, "CC(remember):OrdersScreen.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(coroutineScope5) | startRestartGroup.changedInstance(context) | startRestartGroup.changedInstance(list) | startRestartGroup.changedInstance(repo);
            Object rememberedValue18 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue18 == Composer.INSTANCE.getEmpty()) {
                obj = null;
                final Repo repo4 = repo;
                Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda37
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        Unit OrdersScreen$lambda$50$0;
                        OrdersScreen$lambda$50$0 = OrdersScreenKt.OrdersScreen$lambda$50$0(list, coroutineScope5, mutableState3, mutableState4, mutableState5, mutableState6, context, mutableState42, mutableState30, mutableState31, repo4, mutableState, mutableState36, mutableState35, mutableState37, (LazyListScope) obj4);
                        return OrdersScreen$lambda$50$0;
                    }
                };
                mutableState7 = mutableState3;
                mutableState8 = mutableState5;
                mutableState42 = mutableState42;
                repo2 = repo4;
                mutableState9 = mutableState;
                mutableState10 = mutableState6;
                mutableState11 = mutableState4;
                startRestartGroup.updateRememberedValue(function1);
                rememberedValue18 = function1;
            } else {
                repo2 = repo;
                obj = null;
                mutableState7 = mutableState3;
                mutableState8 = mutableState5;
                mutableState10 = mutableState6;
                mutableState9 = mutableState;
                mutableState11 = mutableState4;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            MutableState mutableState43 = mutableState42;
            final MutableState mutableState44 = mutableState7;
            String str4 = str;
            LazyDslKt.LazyColumn(m1051paddingVpY3zN4$default, null, m1046PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) rememberedValue18, startRestartGroup, 384, TypedValues.PositionType.TYPE_PERCENT_X);
            startRestartGroup = startRestartGroup;
            Long OrdersScreen$lambda$29 = OrdersScreen$lambda$29(mutableState9);
            if (OrdersScreen$lambda$29 == null) {
                startRestartGroup.startReplaceGroup(-1124679453);
                startRestartGroup.endReplaceGroup();
                mutableState19 = mutableState39;
                mutableState18 = mutableState9;
                coroutineScope2 = coroutineScope5;
                str2 = str4;
                mutableState13 = mutableState11;
                mutableState14 = mutableState8;
                mutableState15 = mutableState10;
                mutableState12 = mutableState44;
                mutableState20 = mutableState37;
                mutableState17 = mutableState2;
                i5 = 4;
                str3 = "CC(remember):OrdersScreen.kt#9igjgp";
                i4 = 32;
            } else {
                startRestartGroup.startReplaceGroup(-1124679452);
                ComposerKt.sourceInformation(startRestartGroup, str4);
                long longValue = OrdersScreen$lambda$29.longValue();
                Iterator<T> it3 = OrdersScreen$lambda$10(mutableState8).iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    Object next2 = it3.next();
                    if (((ShopOrder) next2).getId() == longValue) {
                        obj = next2;
                        break;
                    }
                }
                final ShopOrder shopOrder4 = (ShopOrder) obj;
                if (shopOrder4 == null) {
                    startRestartGroup.startReplaceGroup(-1566827721);
                    startRestartGroup.endReplaceGroup();
                    mutableState19 = mutableState39;
                    mutableState18 = mutableState9;
                    coroutineScope2 = coroutineScope5;
                    str2 = str4;
                    mutableState13 = mutableState11;
                    mutableState14 = mutableState8;
                    mutableState15 = mutableState10;
                    mutableState12 = mutableState44;
                    mutableState20 = mutableState37;
                    mutableState17 = mutableState2;
                    i5 = 4;
                    str3 = "CC(remember):OrdersScreen.kt#9igjgp";
                    i4 = 32;
                } else {
                    startRestartGroup.startReplaceGroup(-1566827720);
                    ComposerKt.sourceInformation(startRestartGroup, "*410@16171L18,411@16219L17,412@16266L23,413@16318L21,414@16372L26,415@16427L22,408@16104L359");
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2123274557, "CC(remember):OrdersScreen.kt#9igjgp");
                    boolean changedInstance3 = startRestartGroup.changedInstance(repo2);
                    Object rememberedValue19 = startRestartGroup.rememberedValue();
                    if (changedInstance3 || rememberedValue19 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue19 = new Function1() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda45
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj4) {
                                String OrdersScreen$lambda$51$1$0$0;
                                OrdersScreen$lambda$51$1$0$0 = OrdersScreenKt.OrdersScreen$lambda$51$1$0$0(Repo.this, ((Double) obj4).doubleValue());
                                return OrdersScreen$lambda$51$1$0$0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue19);
                    }
                    Function1 function12 = (Function1) rememberedValue19;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2123276092, "CC(remember):OrdersScreen.kt#9igjgp");
                    Object rememberedValue20 = startRestartGroup.rememberedValue();
                    if (rememberedValue20 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue20 = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda46
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit OrdersScreen$lambda$51$1$1$0;
                                OrdersScreen$lambda$51$1$1$0 = OrdersScreenKt.OrdersScreen$lambda$51$1$1$0(MutableState.this);
                                return OrdersScreen$lambda$51$1$1$0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue20);
                    }
                    Function0 function0 = (Function0) rememberedValue20;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2123277602, "CC(remember):OrdersScreen.kt#9igjgp");
                    boolean changedInstance4 = startRestartGroup.changedInstance(coroutineScope5) | startRestartGroup.changedInstance(shopOrder4);
                    Object rememberedValue21 = startRestartGroup.rememberedValue();
                    if (changedInstance4 || rememberedValue21 == Composer.INSTANCE.getEmpty()) {
                        final MutableState mutableState45 = mutableState9;
                        final MutableState mutableState46 = mutableState11;
                        final MutableState mutableState47 = mutableState8;
                        final MutableState mutableState48 = mutableState10;
                        Function0 function02 = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda47
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit OrdersScreen$lambda$51$1$2$0;
                                OrdersScreen$lambda$51$1$2$0 = OrdersScreenKt.OrdersScreen$lambda$51$1$2$0(ShopOrder.this, coroutineScope5, mutableState45, mutableState44, mutableState46, mutableState47, mutableState48);
                                return OrdersScreen$lambda$51$1$2$0;
                            }
                        };
                        shopOrder = shopOrder4;
                        coroutineScope = coroutineScope5;
                        mutableState12 = mutableState44;
                        mutableState13 = mutableState46;
                        mutableState14 = mutableState47;
                        mutableState15 = mutableState48;
                        startRestartGroup.updateRememberedValue(function02);
                        rememberedValue21 = function02;
                    } else {
                        coroutineScope = coroutineScope5;
                        shopOrder = shopOrder4;
                        mutableState13 = mutableState11;
                        mutableState14 = mutableState8;
                        mutableState15 = mutableState10;
                        mutableState12 = mutableState44;
                    }
                    Function0 function03 = (Function0) rememberedValue21;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2123279264, "CC(remember):OrdersScreen.kt#9igjgp");
                    boolean changedInstance5 = startRestartGroup.changedInstance(shopOrder);
                    Object rememberedValue22 = startRestartGroup.rememberedValue();
                    if (changedInstance5 || rememberedValue22 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue22 = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda48
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit OrdersScreen$lambda$51$1$3$0;
                                OrdersScreen$lambda$51$1$3$0 = OrdersScreenKt.OrdersScreen$lambda$51$1$3$0(ShopOrder.this, mutableState39);
                                return OrdersScreen$lambda$51$1$3$0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue22);
                    }
                    Function0 function04 = (Function0) rememberedValue22;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2123280997, "CC(remember):OrdersScreen.kt#9igjgp");
                    boolean changedInstance6 = startRestartGroup.changedInstance(repo2) | ((i6 & 14) == 4 || ((i6 & 8) != 0 && startRestartGroup.changedInstance(app))) | ((i6 & 112) == 32 || ((i6 & 64) != 0 && startRestartGroup.changedInstance(nav))) | startRestartGroup.changedInstance(shopOrder);
                    Object rememberedValue23 = startRestartGroup.rememberedValue();
                    if (changedInstance6 || rememberedValue23 == Composer.INSTANCE.getEmpty()) {
                        i3 = 32;
                        mutableState16 = mutableState39;
                        shopOrder2 = shopOrder;
                        str2 = str4;
                        str3 = "CC(remember):OrdersScreen.kt#9igjgp";
                        mutableState17 = mutableState2;
                        obj2 = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda49
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit OrdersScreen$lambda$51$1$4$0;
                                OrdersScreen$lambda$51$1$4$0 = OrdersScreenKt.OrdersScreen$lambda$51$1$4$0(ShopOrder.this, repo2, app, nav, mutableState9, mutableState17);
                                return OrdersScreen$lambda$51$1$4$0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(obj2);
                    } else {
                        i3 = 32;
                        mutableState16 = mutableState39;
                        shopOrder2 = shopOrder;
                        str2 = str4;
                        obj2 = rememberedValue23;
                        str3 = "CC(remember):OrdersScreen.kt#9igjgp";
                        mutableState17 = mutableState2;
                    }
                    Function0 function05 = (Function0) obj2;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2123282753, str3);
                    boolean changedInstance7 = startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(shopOrder2);
                    Object rememberedValue24 = startRestartGroup.rememberedValue();
                    if (changedInstance7 || rememberedValue24 == Composer.INSTANCE.getEmpty()) {
                        shopOrder3 = shopOrder2;
                        final CoroutineScope coroutineScope6 = coroutineScope;
                        final MutableState mutableState49 = mutableState15;
                        i4 = i3;
                        i5 = 4;
                        final MutableState mutableState50 = mutableState14;
                        final MutableState mutableState51 = mutableState13;
                        final MutableState mutableState52 = mutableState12;
                        final MutableState mutableState53 = mutableState9;
                        obj3 = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda50
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit OrdersScreen$lambda$51$1$5$0;
                                OrdersScreen$lambda$51$1$5$0 = OrdersScreenKt.OrdersScreen$lambda$51$1$5$0(ShopOrder.this, coroutineScope6, mutableState53, mutableState52, mutableState51, mutableState50, mutableState49);
                                return OrdersScreen$lambda$51$1$5$0;
                            }
                        };
                        coroutineScope2 = coroutineScope6;
                        mutableState18 = mutableState53;
                        mutableState12 = mutableState52;
                        mutableState13 = mutableState51;
                        mutableState14 = mutableState50;
                        mutableState15 = mutableState49;
                        startRestartGroup.updateRememberedValue(obj3);
                    } else {
                        obj3 = rememberedValue24;
                        shopOrder3 = shopOrder2;
                        mutableState18 = mutableState9;
                        coroutineScope2 = coroutineScope;
                        i4 = i3;
                        i5 = 4;
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    mutableState19 = mutableState16;
                    mutableState20 = mutableState37;
                    OrderSheet(shopOrder3, function12, function0, function03, function04, function05, (Function0) obj3, startRestartGroup, ShopOrder.$stable | 384);
                    startRestartGroup = startRestartGroup;
                    Unit unit2 = Unit.INSTANCE;
                    startRestartGroup.endReplaceGroup();
                    Unit unit3 = Unit.INSTANCE;
                }
                startRestartGroup.endReplaceGroup();
            }
            final ShopOrder OrdersScreen$lambda$32 = OrdersScreen$lambda$32(mutableState19);
            if (OrdersScreen$lambda$32 == null) {
                startRestartGroup.startReplaceGroup(-1124211818);
                startRestartGroup.endReplaceGroup();
                coroutineScope3 = coroutineScope2;
                mutableState26 = mutableState12;
                mutableState22 = mutableState14;
                mutableState23 = mutableState15;
                mutableState25 = mutableState18;
                mutableState24 = mutableState13;
            } else {
                startRestartGroup.startReplaceGroup(-1124211817);
                ComposerKt.sourceInformation(startRestartGroup, "*423@16583L20,424@16629L101,421@16519L221");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -711345617, str3);
                Object rememberedValue25 = startRestartGroup.rememberedValue();
                if (rememberedValue25 == Composer.INSTANCE.getEmpty()) {
                    mutableState21 = mutableState19;
                    rememberedValue25 = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda51
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit OrdersScreen$lambda$52$0$0;
                            OrdersScreen$lambda$52$0$0 = OrdersScreenKt.OrdersScreen$lambda$52$0$0(MutableState.this);
                            return OrdersScreen$lambda$52$0$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue25);
                } else {
                    mutableState21 = mutableState19;
                }
                Function0 function06 = (Function0) rememberedValue25;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -711344064, str3);
                boolean changedInstance8 = startRestartGroup.changedInstance(coroutineScope2) | startRestartGroup.changedInstance(OrdersScreen$lambda$32);
                Object rememberedValue26 = startRestartGroup.rememberedValue();
                if (changedInstance8 || rememberedValue26 == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState54 = mutableState21;
                    mutableState22 = mutableState14;
                    mutableState23 = mutableState15;
                    final MutableState mutableState55 = mutableState12;
                    mutableState24 = mutableState13;
                    final MutableState mutableState56 = mutableState18;
                    final CoroutineScope coroutineScope7 = coroutineScope2;
                    Function1 function13 = new Function1() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda52
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj4) {
                            Unit OrdersScreen$lambda$52$1$0;
                            OrdersScreen$lambda$52$1$0 = OrdersScreenKt.OrdersScreen$lambda$52$1$0(ShopOrder.this, mutableState54, coroutineScope7, mutableState56, mutableState55, mutableState24, mutableState22, mutableState23, (String) obj4);
                            return OrdersScreen$lambda$52$1$0;
                        }
                    };
                    coroutineScope3 = coroutineScope7;
                    mutableState25 = mutableState56;
                    mutableState26 = mutableState55;
                    startRestartGroup.updateRememberedValue(function13);
                    rememberedValue26 = function13;
                } else {
                    coroutineScope3 = coroutineScope2;
                    mutableState26 = mutableState12;
                    mutableState22 = mutableState14;
                    mutableState23 = mutableState15;
                    mutableState25 = mutableState18;
                    mutableState24 = mutableState13;
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                CancelSheet(OrdersScreen$lambda$32, function06, (Function1) rememberedValue26, startRestartGroup, ShopOrder.$stable | 48);
                Unit unit4 = Unit.INSTANCE;
                startRestartGroup.endReplaceGroup();
                Unit unit5 = Unit.INSTANCE;
            }
            final ShopOrder OrdersScreen$lambda$35 = OrdersScreen$lambda$35(mutableState17);
            if (OrdersScreen$lambda$35 == null) {
                startRestartGroup.startReplaceGroup(-1123934802);
                startRestartGroup.endReplaceGroup();
                coroutineScope4 = coroutineScope3;
            } else {
                startRestartGroup.startReplaceGroup(-1123934801);
                ComposerKt.sourceInformation(startRestartGroup, "*437@17100L83,441@17209L25,432@16791L453");
                boolean z = false;
                String tx = LangKt.tx("Заменить корзину?", new Object[0]);
                String str5 = LangKt.tx("В кассе уже набран чек: позиций — %s. ", Integer.valueOf(CartStore.INSTANCE.getCurrent().getItems().size())) + LangKt.tx("Перенос заказа очистит корзину и положит в неё товары заказа.", new Object[0]);
                String tx2 = LangKt.tx("Заменить", new Object[0]);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 89197839, str3);
                boolean changedInstance9 = ((i6 & 14) == i5 || ((i6 & 8) != 0 && startRestartGroup.changedInstance(app))) | startRestartGroup.changedInstance(repo2);
                if ((i6 & 112) == i4 || ((i6 & 64) != 0 && startRestartGroup.changedInstance(nav))) {
                    z = true;
                }
                boolean changedInstance10 = changedInstance9 | z | startRestartGroup.changedInstance(OrdersScreen$lambda$35);
                Object rememberedValue27 = startRestartGroup.rememberedValue();
                if (changedInstance10 || rememberedValue27 == Composer.INSTANCE.getEmpty()) {
                    Function0 function07 = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda53
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit OrdersScreen$lambda$53$0$0;
                            OrdersScreen$lambda$53$0$0 = OrdersScreenKt.OrdersScreen$lambda$53$0$0(ShopOrder.this, repo2, app, nav, mutableState25, mutableState17);
                            return OrdersScreen$lambda$53$0$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(function07);
                    rememberedValue27 = function07;
                }
                Function0 function08 = (Function0) rememberedValue27;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 89201269, str3);
                Object rememberedValue28 = startRestartGroup.rememberedValue();
                if (rememberedValue28 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue28 = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda38
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit OrdersScreen$lambda$53$1$0;
                            OrdersScreen$lambda$53$1$0 = OrdersScreenKt.OrdersScreen$lambda$53$1$0(MutableState.this);
                            return OrdersScreen$lambda$53$1$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue28);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                coroutineScope4 = coroutineScope3;
                SheetsKt.OxConfirmSheet(tx, str5, tx2, null, function08, (Function0) rememberedValue28, startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 8);
                Unit unit6 = Unit.INSTANCE;
                startRestartGroup.endReplaceGroup();
                Unit unit7 = Unit.INSTANCE;
            }
            final ShopReview OrdersScreen$lambda$25 = OrdersScreen$lambda$25(mutableState20);
            if (OrdersScreen$lambda$25 == null) {
                startRestartGroup.startReplaceGroup(-1123432106);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1123432105);
                ComposerKt.sourceInformation(startRestartGroup, "*448@17355L19,449@17397L615,446@17290L732");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 530711484, str3);
                Object rememberedValue29 = startRestartGroup.rememberedValue();
                if (rememberedValue29 == Composer.INSTANCE.getEmpty()) {
                    mutableState27 = mutableState20;
                    rememberedValue29 = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda39
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit OrdersScreen$lambda$54$0$0;
                            OrdersScreen$lambda$54$0$0 = OrdersScreenKt.OrdersScreen$lambda$54$0$0(MutableState.this);
                            return OrdersScreen$lambda$54$0$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue29);
                } else {
                    mutableState27 = mutableState20;
                }
                Function0 function09 = (Function0) rememberedValue29;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 530713424, str3);
                boolean changedInstance11 = startRestartGroup.changedInstance(coroutineScope4) | startRestartGroup.changedInstance(OrdersScreen$lambda$25);
                Object rememberedValue30 = startRestartGroup.rememberedValue();
                if (changedInstance11 || rememberedValue30 == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState57 = mutableState27;
                    final CoroutineScope coroutineScope8 = coroutineScope4;
                    Function1 function14 = new Function1() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda40
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj4) {
                            Unit OrdersScreen$lambda$54$1$0;
                            OrdersScreen$lambda$54$1$0 = OrdersScreenKt.OrdersScreen$lambda$54$1$0(CoroutineScope.this, OrdersScreen$lambda$25, mutableState57, mutableState36, mutableState35, (String) obj4);
                            return OrdersScreen$lambda$54$1$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(function14);
                    rememberedValue30 = function14;
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ReplySheet(OrdersScreen$lambda$25, function09, (Function1) rememberedValue30, startRestartGroup, ShopReview.$stable | 48);
                Unit unit8 = Unit.INSTANCE;
                startRestartGroup.endReplaceGroup();
                Unit unit9 = Unit.INSTANCE;
            }
            if (OrdersScreen$lambda$38(mutableState43)) {
                startRestartGroup.startReplaceGroup(379429601);
                ComposerKt.sourceInformation(startRestartGroup, str2);
                final ShopStoreInfo OrdersScreen$lambda$1 = OrdersScreen$lambda$1(mutableState24);
                if (OrdersScreen$lambda$1 == null) {
                    startRestartGroup.startReplaceGroup(-1122584256);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-1122584255);
                    ComposerKt.sourceInformation(startRestartGroup, "*472@18176L24,473@18227L2265,470@18097L2409");
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 446797400, str3);
                    Object rememberedValue31 = startRestartGroup.rememberedValue();
                    if (rememberedValue31 == Composer.INSTANCE.getEmpty()) {
                        mutableState28 = mutableState43;
                        rememberedValue31 = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda41
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit OrdersScreen$lambda$55$0$0;
                                OrdersScreen$lambda$55$0$0 = OrdersScreenKt.OrdersScreen$lambda$55$0$0(MutableState.this);
                                return OrdersScreen$lambda$55$0$0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue31);
                    } else {
                        mutableState28 = mutableState43;
                    }
                    Function0 function010 = (Function0) rememberedValue31;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 446801273, str3);
                    boolean changedInstance12 = startRestartGroup.changedInstance(coroutineScope4) | startRestartGroup.changedInstance(OrdersScreen$lambda$1);
                    Object rememberedValue32 = startRestartGroup.rememberedValue();
                    if (changedInstance12 || rememberedValue32 == Composer.INSTANCE.getEmpty()) {
                        final CoroutineScope coroutineScope9 = coroutineScope4;
                        final MutableState mutableState58 = mutableState28;
                        final MutableState mutableState59 = mutableState24;
                        final MutableState mutableState60 = mutableState22;
                        final MutableState mutableState61 = mutableState23;
                        final MutableState mutableState62 = mutableState26;
                        Function1 function15 = new Function1() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda42
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj4) {
                                Unit OrdersScreen$lambda$55$1$0;
                                OrdersScreen$lambda$55$1$0 = OrdersScreenKt.OrdersScreen$lambda$55$1$0(CoroutineScope.this, OrdersScreen$lambda$1, mutableState58, mutableState62, mutableState59, mutableState60, mutableState61, (ShopStoreInfo) obj4);
                                return OrdersScreen$lambda$55$1$0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(function15);
                        rememberedValue32 = function15;
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ShopSettingsSheet(OrdersScreen$lambda$1, function010, (Function1) rememberedValue32, startRestartGroup, ShopStoreInfo.$stable | 48);
                    Unit unit10 = Unit.INSTANCE;
                    startRestartGroup.endReplaceGroup();
                    Unit unit11 = Unit.INSTANCE;
                }
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1120225775);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda43
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    return OrdersScreenKt.OrdersScreen$lambda$56(FonRoApp.this, nav, i, (Composer) obj4, ((Integer) obj5).intValue());
                }
            });
        }
    }

    private static final ShopStoreInfo OrdersScreen$lambda$1(MutableState<ShopStoreInfo> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String OrdersScreen$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String OrdersScreen$lambda$7(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final List<ShopOrder> OrdersScreen$lambda$10(MutableState<List<ShopOrder>> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean OrdersScreen$lambda$13(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void OrdersScreen$lambda$14(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean OrdersScreen$lambda$16(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OrdersScreen$lambda$17(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final List<ShopReview> OrdersScreen$lambda$19(MutableState<List<ShopReview>> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean OrdersScreen$lambda$22(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void OrdersScreen$lambda$23(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final ShopReview OrdersScreen$lambda$25(MutableState<ShopReview> mutableState) {
        return mutableState.getValue();
    }

    private static final Long OrdersScreen$lambda$29(MutableState<Long> mutableState) {
        return mutableState.getValue();
    }

    private static final ShopOrder OrdersScreen$lambda$32(MutableState<ShopOrder> mutableState) {
        return mutableState.getValue();
    }

    private static final ShopOrder OrdersScreen$lambda$35(MutableState<ShopOrder> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean OrdersScreen$lambda$38(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OrdersScreen$lambda$39(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object OrdersScreen$load(androidx.compose.runtime.MutableState<java.lang.Boolean> r4, androidx.compose.runtime.MutableState<uz.FonRo.pos.data.model.ShopStoreInfo> r5, androidx.compose.runtime.MutableState<java.util.List<uz.FonRo.pos.data.model.ShopOrder>> r6, androidx.compose.runtime.MutableState<java.lang.Boolean> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$load$1
            if (r0 == 0) goto L14
            r0 = r8
            uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$load$1 r0 = (uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$load$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$load$1 r0 = new uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$load$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L42
            if (r2 != r3) goto L3a
            java.lang.Object r4 = r0.L$3
            androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
            java.lang.Object r4 = r0.L$2
            androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
            java.lang.Object r4 = r0.L$1
            androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
            java.lang.Object r4 = r0.L$0
            androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6d
        L3a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L42:
            kotlin.ResultKt.throwOnFailure(r8)
            OrdersScreen$lambda$14(r4, r3)
            uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$load$2 r8 = new uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$load$2
            r2 = 0
            r8.<init>(r5, r6, r7, r2)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r0.L$0 = r4
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$1 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$2 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$3 = r5
            r0.label = r3
            java.lang.Object r5 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r8, r0)
            if (r5 != r1) goto L6d
            return r1
        L6d:
            r5 = 0
            OrdersScreen$lambda$14(r4, r5)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.orders.OrdersScreenKt.OrdersScreen$load(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object OrdersScreen$loadReviews(androidx.compose.runtime.MutableState<java.lang.Boolean> r6, androidx.compose.runtime.MutableState<java.util.List<uz.FonRo.pos.data.model.ShopReview>> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$loadReviews$1
            if (r0 == 0) goto L14
            r0 = r8
            uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$loadReviews$1 r0 = (uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$loadReviews$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$loadReviews$1 r0 = new uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$loadReviews$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 != r4) goto L39
            java.lang.Object r6 = r0.L$2
            uz.FonRo.pos.data.net.ApiClient r6 = (uz.FonRo.pos.data.net.ApiClient) r6
            java.lang.Object r7 = r0.L$1
            androidx.compose.runtime.MutableState r7 = (androidx.compose.runtime.MutableState) r7
            java.lang.Object r0 = r0.L$0
            androidx.compose.runtime.MutableState r0 = (androidx.compose.runtime.MutableState) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L37
            goto L64
        L37:
            r6 = move-exception
            goto L7a
        L39:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L41:
            kotlin.ResultKt.throwOnFailure(r8)
            OrdersScreen$lambda$23(r6, r4)
            kotlin.Result$Companion r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L77
            uz.FonRo.pos.data.net.ApiClient r8 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> L77
            uz.FonRo.pos.data.net.ApiClient r2 = uz.FonRo.pos.data.net.ApiClient.INSTANCE     // Catch: java.lang.Throwable -> L77
            uz.FonRo.pos.data.net.ApiService r2 = r2.api()     // Catch: java.lang.Throwable -> L77
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L77
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L77
            r0.L$2 = r8     // Catch: java.lang.Throwable -> L77
            r0.label = r4     // Catch: java.lang.Throwable -> L77
            java.lang.Object r0 = r2.shopReviews(r0)     // Catch: java.lang.Throwable -> L77
            if (r0 != r1) goto L60
            return r1
        L60:
            r5 = r0
            r0 = r6
            r6 = r8
            r8 = r5
        L64:
            retrofit2.Response r8 = (retrofit2.Response) r8     // Catch: java.lang.Throwable -> L37
            r1 = 2
            r2 = 0
            java.lang.Object r6 = uz.FonRo.pos.data.net.ApiClient.unwrap$default(r6, r8, r3, r1, r2)     // Catch: java.lang.Throwable -> L37
            uz.FonRo.pos.data.model.ShopReviewsResponse r6 = (uz.FonRo.pos.data.model.ShopReviewsResponse) r6     // Catch: java.lang.Throwable -> L37
            java.util.List r6 = r6.getReviews()     // Catch: java.lang.Throwable -> L37
            java.lang.Object r6 = kotlin.Result.m7870constructorimpl(r6)     // Catch: java.lang.Throwable -> L37
            goto L84
        L77:
            r8 = move-exception
            r0 = r6
            r6 = r8
        L7a:
            kotlin.Result$Companion r8 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m7870constructorimpl(r6)
        L84:
            boolean r8 = kotlin.Result.m7877isSuccessimpl(r6)
            if (r8 == 0) goto L90
            r8 = r6
            java.util.List r8 = (java.util.List) r8
            OrdersScreen$lambda$20(r7, r8)
        L90:
            java.lang.Throwable r6 = kotlin.Result.m7873exceptionOrNullimpl(r6)
            if (r6 == 0) goto L9b
            uz.FonRo.pos.ui.Toaster r7 = uz.FonRo.pos.ui.Toaster.INSTANCE
            r7.error(r6)
        L9b:
            OrdersScreen$lambda$23(r0, r3)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.orders.OrdersScreenKt.OrdersScreen$loadReviews(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final String OrdersScreen$shopUrl(String str) {
        if (StringsKt.isBlank(str)) {
            return "";
        }
        return "https://FonRo.uz/" + str;
    }

    private static final void OrdersScreen$shareLink(Context context, String str) {
        String OrdersScreen$shopUrl = OrdersScreen$shopUrl(str);
        if (OrdersScreen$shopUrl.length() == 0) {
            Toaster.INSTANCE.error(LangKt.tx("Задайте адрес витрины в настройках", new Object[0]));
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", OrdersScreen$shopUrl);
        context.startActivity(Intent.createChooser(intent, LangKt.tx("Поделиться ссылкой", new Object[0])));
    }

    private static final void OrdersScreen$openLink(Context context, String str) {
        Object m7870constructorimpl;
        String OrdersScreen$shopUrl = OrdersScreen$shopUrl(str);
        if (OrdersScreen$shopUrl.length() == 0) {
            Toaster.INSTANCE.error(LangKt.tx("Задайте адрес витрины в настройках", new Object[0]));
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(OrdersScreen$shopUrl)));
            m7870constructorimpl = Result.m7870constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7873exceptionOrNullimpl(m7870constructorimpl) != null) {
            Toaster.INSTANCE.error(LangKt.tx("Не удалось открыть ссылку", new Object[0]));
        }
    }

    private static final void OrdersScreen$confirmOrder(CoroutineScope coroutineScope, MutableState<Long> mutableState, MutableState<Boolean> mutableState2, MutableState<ShopStoreInfo> mutableState3, MutableState<List<ShopOrder>> mutableState4, MutableState<Boolean> mutableState5, ShopOrder shopOrder) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new OrdersScreenKt$OrdersScreen$confirmOrder$1(shopOrder, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, null), 3, null);
    }

    private static final void OrdersScreen$cancelOrder(CoroutineScope coroutineScope, MutableState<Long> mutableState, MutableState<Boolean> mutableState2, MutableState<ShopStoreInfo> mutableState3, MutableState<List<ShopOrder>> mutableState4, MutableState<Boolean> mutableState5, ShopOrder shopOrder, String str) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new OrdersScreenKt$OrdersScreen$cancelOrder$1(shopOrder, str, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, null), 3, null);
    }

    private static final void OrdersScreen$finishOrder(CoroutineScope coroutineScope, MutableState<Long> mutableState, MutableState<Boolean> mutableState2, MutableState<ShopStoreInfo> mutableState3, MutableState<List<ShopOrder>> mutableState4, MutableState<Boolean> mutableState5, ShopOrder shopOrder) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new OrdersScreenKt$OrdersScreen$finishOrder$1(shopOrder, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, null), 3, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
    
        if (r3 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void OrdersScreen$moveToCart(uz.FonRo.pos.data.repo.Repo r16, uz.FonRo.pos.FonRoApp r17, uz.FonRo.pos.ui.nav.AppNavigator r18, androidx.compose.runtime.MutableState<java.lang.Long> r19, androidx.compose.runtime.MutableState<uz.FonRo.pos.data.model.ShopOrder> r20, uz.FonRo.pos.data.model.ShopOrder r21) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.orders.OrdersScreenKt.OrdersScreen$moveToCart(uz.FonRo.pos.data.repo.Repo, uz.FonRo.pos.FonRoApp, uz.FonRo.pos.ui.nav.AppNavigator, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, uz.FonRo.pos.data.model.ShopOrder):void");
    }

    private static final void OrdersScreen$startMoveToCart(Repo repo, FonRoApp FonRoApp, AppNavigator appNavigator, MutableState<Long> mutableState, MutableState<ShopOrder> mutableState2, ShopOrder shopOrder) {
        if (CartStore.INSTANCE.getCurrent().getItems().isEmpty()) {
            OrdersScreen$moveToCart(repo, FonRoApp, appNavigator, mutableState, mutableState2, shopOrder);
        } else {
            mutableState2.setValue(shopOrder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$50$0(final List list, final CoroutineScope coroutineScope, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final Context context, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, final Repo repo, final MutableState mutableState8, MutableState mutableState9, MutableState mutableState10, final MutableState mutableState11, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(997061958, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit OrdersScreen$lambda$50$0$0;
                OrdersScreen$lambda$50$0$0 = OrdersScreenKt.OrdersScreen$lambda$50$0$0(CoroutineScope.this, mutableState, mutableState2, mutableState3, mutableState4, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return OrdersScreen$lambda$50$0$0;
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-2102154371, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit OrdersScreen$lambda$50$0$1;
                OrdersScreen$lambda$50$0$1 = OrdersScreenKt.OrdersScreen$lambda$50$0$1(context, mutableState2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return OrdersScreen$lambda$50$0$1;
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1490217086, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit OrdersScreen$lambda$50$0$2;
                OrdersScreen$lambda$50$0$2 = OrdersScreenKt.OrdersScreen$lambda$50$0$2(MutableState.this, mutableState5, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return OrdersScreen$lambda$50$0$2;
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(787621247, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit OrdersScreen$lambda$50$0$3;
                OrdersScreen$lambda$50$0$3 = OrdersScreenKt.OrdersScreen$lambda$50$0$3(MutableState.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return OrdersScreen$lambda$50$0$3;
            }
        }), 3, null);
        if (Intrinsics.areEqual(OrdersScreen$lambda$4(mutableState6), "checks")) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(861104545, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OrdersScreen$lambda$50$0$4;
                    OrdersScreen$lambda$50$0$4 = OrdersScreenKt.OrdersScreen$lambda$50$0$4(MutableState.this, mutableState7, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OrdersScreen$lambda$50$0$4;
                }
            }), 3, null);
            if (OrdersScreen$lambda$13(mutableState) && OrdersScreen$lambda$10(mutableState3).isEmpty()) {
                LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$OrdersScreenKt.INSTANCE.m10054getLambda$549230532$app(), 3, null);
            } else if (list.isEmpty()) {
                LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1037917275, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit OrdersScreen$lambda$50$0$5;
                        OrdersScreen$lambda$50$0$5 = OrdersScreenKt.OrdersScreen$lambda$50$0$5(MutableState.this, mutableState7, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return OrdersScreen$lambda$50$0$5;
                    }
                }), 3, null);
            } else {
                final Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Object OrdersScreen$lambda$50$0$6;
                        OrdersScreen$lambda$50$0$6 = OrdersScreenKt.OrdersScreen$lambda$50$0$6((ShopOrder) obj);
                        return OrdersScreen$lambda$50$0$6;
                    }
                };
                final OrdersScreenKt$OrdersScreen$lambda$50$0$$inlined$items$default$1 ordersScreenKt$OrdersScreen$lambda$50$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$lambda$50$0$$inlined$items$default$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(ShopOrder shopOrder) {
                        return null;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke((ShopOrder) obj);
                    }
                };
                LazyColumn.items(list.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$lambda$50$0$$inlined$items$default$2
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
                }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$lambda$50$0$$inlined$items$default$3
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
                }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$lambda$50$0$$inlined$items$default$4
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
                        final ShopOrder shopOrder = (ShopOrder) list.get(i);
                        composer.startReplaceGroup(-1356323826);
                        ComposerKt.sourceInformation(composer, "C*372@14808L286:OrdersScreen.kt#ge60a7");
                        ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
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
                        ComposerKt.sourceInformationMarkerStart(composer, -1271055537, "C375@14931L18,376@14989L21,373@14841L195,378@15061L11:OrdersScreen.kt#ge60a7");
                        ComposerKt.sourceInformationMarkerStart(composer, -456641121, "CC(remember):OrdersScreen.kt#9igjgp");
                        boolean changedInstance = composer.changedInstance(repo);
                        Object rememberedValue = composer.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            final Repo repo2 = repo;
                            rememberedValue = (Function1) new Function1<Double, String>() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$3$1$8$1$1$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ String invoke(Double d) {
                                    return invoke(d.doubleValue());
                                }

                                public final String invoke(double d) {
                                    return Repo.this.money(Double.valueOf(d));
                                }
                            };
                            composer.updateRememberedValue(rememberedValue);
                        }
                        Function1 function12 = (Function1) rememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerStart(composer, -456639262, "CC(remember):OrdersScreen.kt#9igjgp");
                        boolean changedInstance2 = composer.changedInstance(shopOrder);
                        Object rememberedValue2 = composer.rememberedValue();
                        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            final MutableState mutableState12 = mutableState8;
                            rememberedValue2 = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$3$1$8$1$2$1
                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    mutableState12.setValue(Long.valueOf(ShopOrder.this.getId()));
                                }
                            };
                            composer.updateRememberedValue(rememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        OrdersScreenKt.OrderCard(shopOrder, function12, (Function0) rememberedValue2, composer, ShopOrder.$stable);
                        BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(11.0f), composer, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        composer.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
            }
        } else if (OrdersScreen$lambda$22(mutableState9) && OrdersScreen$lambda$19(mutableState10).isEmpty()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$OrdersScreenKt.INSTANCE.m10052getLambda$228361915$app(), 3, null);
        } else if (OrdersScreen$lambda$19(mutableState10).isEmpty()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$OrdersScreenKt.INSTANCE.m10051getLambda$1216578834$app(), 3, null);
        } else {
            final List<ShopReview> OrdersScreen$lambda$19 = OrdersScreen$lambda$19(mutableState10);
            final Function1 function12 = new Function1() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object OrdersScreen$lambda$50$0$8;
                    OrdersScreen$lambda$50$0$8 = OrdersScreenKt.OrdersScreen$lambda$50$0$8((ShopReview) obj);
                    return OrdersScreen$lambda$50$0$8;
                }
            };
            final OrdersScreenKt$OrdersScreen$lambda$50$0$$inlined$items$default$5 ordersScreenKt$OrdersScreen$lambda$50$0$$inlined$items$default$5 = new Function1() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$lambda$50$0$$inlined$items$default$5
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(ShopReview shopReview) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((ShopReview) obj);
                }
            };
            LazyColumn.items(OrdersScreen$lambda$19.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$lambda$50$0$$inlined$items$default$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i) {
                    return Function1.this.invoke(OrdersScreen$lambda$19.get(i));
                }
            }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$lambda$50$0$$inlined$items$default$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i) {
                    return Function1.this.invoke(OrdersScreen$lambda$19.get(i));
                }
            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$lambda$50$0$$inlined$items$default$8
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
                    final ShopReview shopReview = (ShopReview) OrdersScreen$lambda$19.get(i);
                    composer.startReplaceGroup(-1958743554);
                    ComposerKt.sourceInformation(composer, "C*395@15669L151:OrdersScreen.kt#ge60a7");
                    ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
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
                    ComposerKt.sourceInformationMarkerStart(composer, -847621749, "C396@15740L21,396@15702L60,397@15787L11:OrdersScreen.kt#ge60a7");
                    ComposerKt.sourceInformationMarkerStart(composer, 1219584493, "CC(remember):OrdersScreen.kt#9igjgp");
                    boolean changedInstance = composer.changedInstance(shopReview);
                    Object rememberedValue = composer.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        final MutableState mutableState12 = mutableState11;
                        rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$OrdersScreen$3$1$10$1$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                mutableState12.setValue(ShopReview.this);
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    OrdersScreenKt.ReviewCard(shopReview, (Function0) rememberedValue, composer, ShopReview.$stable);
                    BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(11.0f), composer, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
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
    public static final Unit OrdersScreen$lambda$50$0$0(final CoroutineScope coroutineScope, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C286@11515L352,286@11474L393:OrdersScreen.kt#ge60a7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(997061958, i, -1, "uz.FonRo.pos.ui.orders.OrdersScreen.<anonymous>.<anonymous>.<anonymous> (OrdersScreen.kt:286)");
            }
            PageHeadKt.OxPageHead(LangKt.tx("Онлайн-магазин", new Object[0]), null, null, false, ComposableLambdaKt.rememberComposableLambda(-1065577961, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OrdersScreen$lambda$50$0$0$0;
                    OrdersScreen$lambda$50$0$0$0 = OrdersScreenKt.OrdersScreen$lambda$50$0$0$0(CoroutineScope.this, mutableState, mutableState2, mutableState3, mutableState4, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OrdersScreen$lambda$50$0$0$0;
                }
            }, composer, 54), composer, 24576, 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$50$0$0$0(final CoroutineScope coroutineScope, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, RowScope OxPageHead, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxPageHead, "$this$OxPageHead");
        ComposerKt.sourceInformation(composer, "C287@11556L27,287@11533L320:OrdersScreen.kt#ge60a7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1065577961, i, -1, "uz.FonRo.pos.ui.orders.OrdersScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OrdersScreen.kt:287)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -1818202734, "CC(remember):OrdersScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(coroutineScope);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                Function0 function0 = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit OrdersScreen$lambda$50$0$0$0$0$0;
                        OrdersScreen$lambda$50$0$0$0$0$0 = OrdersScreenKt.OrdersScreen$lambda$50$0$0$0$0$0(CoroutineScope.this, mutableState, mutableState2, mutableState3, mutableState4);
                        return OrdersScreen$lambda$50$0$0$0$0$0;
                    }
                };
                composer.updateRememberedValue(function0);
                rememberedValue = function0;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9831OxIconButtonhGBTI10((Function0) rememberedValue, null, null, 0.0f, ComposableSingletons$OrdersScreenKt.INSTANCE.m10053getLambda$318095790$app(), composer, 24576, 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$50$0$0$0$0$0(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new OrdersScreenKt$OrdersScreen$3$1$1$1$1$1$1(mutableState, mutableState2, mutableState3, mutableState4, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$50$0$1(final Context context, final MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C299@11906L286:OrdersScreen.kt#ge60a7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2102154371, i, -1, "uz.FonRo.pos.ui.orders.OrdersScreen.<anonymous>.<anonymous>.<anonymous> (OrdersScreen.kt:299)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1585767641, "C302@12031L34,303@12097L35,300@11931L219,305@12167L11:OrdersScreen.kt#ge60a7");
            ShopStoreInfo OrdersScreen$lambda$1 = OrdersScreen$lambda$1(mutableState);
            String slug = OrdersScreen$lambda$1 != null ? OrdersScreen$lambda$1.getSlug() : null;
            if (slug == null) {
                slug = "";
            }
            String OrdersScreen$shopUrl = OrdersScreen$shopUrl(slug);
            ComposerKt.sourceInformationMarkerStart(composer, -780127211, "CC(remember):OrdersScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(context);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit OrdersScreen$lambda$50$0$1$0$0$0;
                        OrdersScreen$lambda$50$0$1$0$0$0 = OrdersScreenKt.OrdersScreen$lambda$50$0$1$0$0$0(MutableState.this, context);
                        return OrdersScreen$lambda$50$0$1$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -780125098, "CC(remember):OrdersScreen.kt#9igjgp");
            boolean changedInstance2 = composer.changedInstance(context);
            Object rememberedValue2 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit OrdersScreen$lambda$50$0$1$0$1$0;
                        OrdersScreen$lambda$50$0$1$0$1$0 = OrdersScreenKt.OrdersScreen$lambda$50$0$1$0$1$0(MutableState.this, context);
                        return OrdersScreen$lambda$50$0$1$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ShopLinkCard(OrdersScreen$shopUrl, function0, (Function0) rememberedValue2, composer, 0);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
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
    public static final Unit OrdersScreen$lambda$50$0$1$0$0$0(MutableState mutableState, Context context) {
        ShopStoreInfo OrdersScreen$lambda$1 = OrdersScreen$lambda$1(mutableState);
        String slug = OrdersScreen$lambda$1 != null ? OrdersScreen$lambda$1.getSlug() : null;
        if (slug == null) {
            slug = "";
        }
        OrdersScreen$openLink(context, slug);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$50$0$1$0$1$0(MutableState mutableState, Context context) {
        ShopStoreInfo OrdersScreen$lambda$1 = OrdersScreen$lambda$1(mutableState);
        String slug = OrdersScreen$lambda$1 != null ? OrdersScreen$lambda$1.getSlug() : null;
        if (slug == null) {
            slug = "";
        }
        OrdersScreen$shareLink(context, slug);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$50$0$2(MutableState mutableState, final MutableState mutableState2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C310@12231L428:OrdersScreen.kt#ge60a7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1490217086, i, -1, "uz.FonRo.pos.ui.orders.OrdersScreen.<anonymous>.<anonymous>.<anonymous> (OrdersScreen.kt:310)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
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
            ComposerKt.sourceInformationMarkerStart(composer, -71234198, "C316@12520L23,311@12256L361,319@12634L11:OrdersScreen.kt#ge60a7");
            String tx = LangKt.tx("⚙️ Настройки магазина", new Object[0]);
            long m10241tintBg5vOe2sY = Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10223getPurple0d7_KjU(), 0.16f);
            long m10240inkl2rxGTc = Ox.INSTANCE.m10240inkl2rxGTc(ColorKt.Color(4285343961L));
            boolean z = OrdersScreen$lambda$1(mutableState) != null;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, -1664857781, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit OrdersScreen$lambda$50$0$2$0$0$0;
                        OrdersScreen$lambda$50$0$2$0$0$0 = OrdersScreenKt.OrdersScreen$lambda$50$0$2$0$0$0(MutableState.this);
                        return OrdersScreen$lambda$50$0$2$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m10077SoftButtonj4UnuUM(tx, m10241tintBg5vOe2sY, m10240inkl2rxGTc, (Function0) rememberedValue, fillMaxWidth$default, z, 0.0f, composer, 27648, 64);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
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
    public static final Unit OrdersScreen$lambda$50$0$2$0$0$0(MutableState mutableState) {
        OrdersScreen$lambda$39(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$50$0$3(final MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C324@12698L446:OrdersScreen.kt#ge60a7");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(787621247, i, -1, "uz.FonRo.pos.ui.orders.OrdersScreen.<anonymous>.<anonymous>.<anonymous> (OrdersScreen.kt:324)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1728239881, "C325@12723L379,332@13119L11:OrdersScreen.kt#ge60a7");
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(11.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, fillMaxWidth$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 853114126, "C329@12937L19,329@12896L82,330@13042L20,330@12999L85:OrdersScreen.kt#ge60a7");
            String tx = LangKt.tx("🧾 Чеки", new Object[0]);
            boolean areEqual = Intrinsics.areEqual(OrdersScreen$lambda$4(mutableState), "checks");
            ComposerKt.sourceInformationMarkerStart(composer, -1496499700, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda78
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit OrdersScreen$lambda$50$0$3$0$0$0$0;
                        OrdersScreen$lambda$50$0$3$0$0$0$0 = OrdersScreenKt.OrdersScreen$lambda$50$0$3$0$0$0$0(MutableState.this);
                        return OrdersScreen$lambda$50$0$3$0$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ShopTab(tx, areEqual, (Function0) rememberedValue, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 384, 0);
            String tx2 = LangKt.tx("⭐ Отзывы", new Object[0]);
            boolean areEqual2 = Intrinsics.areEqual(OrdersScreen$lambda$4(mutableState), "reviews");
            ComposerKt.sourceInformationMarkerStart(composer, -1496496339, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda79
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit OrdersScreen$lambda$50$0$3$0$0$1$0;
                        OrdersScreen$lambda$50$0$3$0$0$1$0 = OrdersScreenKt.OrdersScreen$lambda$50$0$3$0$0$1$0(MutableState.this);
                        return OrdersScreen$lambda$50$0$3$0$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ShopTab(tx2, areEqual2, (Function0) rememberedValue2, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 384, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
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
    public static final Unit OrdersScreen$lambda$50$0$3$0$0$0$0(MutableState mutableState) {
        mutableState.setValue("checks");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$50$0$3$0$0$1$0(MutableState mutableState) {
        mutableState.setValue("reviews");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$50$0$4(final MutableState mutableState, final MutableState mutableState2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C338@13223L614:OrdersScreen.kt#ge60a7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(861104545, i, -1, "uz.FonRo.pos.ui.orders.OrdersScreen.<anonymous>.<anonymous>.<anonymous> (OrdersScreen.kt:338)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1280601995, "C339@13262L526,339@13252L536,350@13809L10:OrdersScreen.kt#ge60a7");
            ChipsKt.OxChipRow(null, ComposableLambdaKt.rememberComposableLambda(1179851176, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda71
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OrdersScreen$lambda$50$0$4$0$0;
                    OrdersScreen$lambda$50$0$4$0$0 = OrdersScreenKt.OrdersScreen$lambda$50$0$4$0$0(MutableState.this, mutableState2, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OrdersScreen$lambda$50$0$4$0$0;
                }
            }, composer, 54), composer, 48, 1);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(4.0f), composer, 6);
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
    public static final Unit OrdersScreen$lambda$50$0$4$0$0(MutableState mutableState, final MutableState mutableState2, RowScope OxChipRow, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxChipRow, "$this$OxChipRow");
        ComposerKt.sourceInformation(composer, "C*345@13640L16,342@13473L267:OrdersScreen.kt#ge60a7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1179851176, i, -1, "uz.FonRo.pos.ui.orders.OrdersScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OrdersScreen.kt:340)");
            }
            Iterator<T> it = getSTATUS_FILTERS().iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                final String str = (String) pair.component1();
                String str2 = (String) pair.component2();
                if (StringsKt.isBlank(str)) {
                    i2 = OrdersScreen$lambda$10(mutableState).size();
                } else {
                    List<ShopOrder> OrdersScreen$lambda$10 = OrdersScreen$lambda$10(mutableState);
                    if ((OrdersScreen$lambda$10 instanceof Collection) && OrdersScreen$lambda$10.isEmpty()) {
                        i2 = 0;
                    } else {
                        Iterator<T> it2 = OrdersScreen$lambda$10.iterator();
                        int i3 = 0;
                        while (it2.hasNext()) {
                            if (Intrinsics.areEqual(((ShopOrder) it2.next()).getStatus(), str) && (i3 = i3 + 1) < 0) {
                                CollectionsKt.throwCountOverflow();
                            }
                        }
                        i2 = i3;
                    }
                }
                String str3 = str2 + " · " + i2;
                boolean areEqual = Intrinsics.areEqual(OrdersScreen$lambda$7(mutableState2), str);
                ComposerKt.sourceInformationMarkerStart(composer, 893415345, "CC(remember):OrdersScreen.kt#9igjgp");
                boolean changed = composer.changed(str);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit OrdersScreen$lambda$50$0$4$0$0$0$1$0;
                            OrdersScreen$lambda$50$0$4$0$0$0$1$0 = OrdersScreenKt.OrdersScreen$lambda$50$0$4$0$0$0$1$0(str, mutableState2);
                            return OrdersScreen$lambda$50$0$4$0$0$0$1$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ChipsKt.m9837OxCatChipFV1VA1c(str3, areEqual, (Function0) rememberedValue, null, ChipTint.CYAN, null, composer, 24576, 40);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$50$0$4$0$0$0$1$0(String str, MutableState mutableState) {
        mutableState.setValue(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$50$0$5(MutableState mutableState, MutableState mutableState2, LazyItemScope item, Composer composer, int i) {
        String tx;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C360@14199L491:OrdersScreen.kt#ge60a7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1037917275, i, -1, "uz.FonRo.pos.ui.orders.OrdersScreen.<anonymous>.<anonymous>.<anonymous> (OrdersScreen.kt:360)");
            }
            String str = OrdersScreen$lambda$16(mutableState) ? "📡" : "🛍️";
            String tx2 = OrdersScreen$lambda$16(mutableState) ? LangKt.tx("Заказы не загрузились", new Object[0]) : LangKt.tx("Заказов нет", new Object[0]);
            if (OrdersScreen$lambda$16(mutableState)) {
                tx = LangKt.tx("Проверьте соединение и обновите.", new Object[0]);
            } else {
                tx = StringsKt.isBlank(OrdersScreen$lambda$7(mutableState2)) ? LangKt.tx("Поделитесь ссылкой магазина с покупателями.", new Object[0]) : LangKt.tx("В этом статусе пусто.", new Object[0]);
            }
            ShopEmpty(str, tx2, tx, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object OrdersScreen$lambda$50$0$6(ShopOrder it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object OrdersScreen$lambda$50$0$8(ShopReview it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String OrdersScreen$lambda$51$1$0$0(Repo repo, double d) {
        return repo.money(Double.valueOf(d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$51$1$1$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$51$1$2$0(ShopOrder shopOrder, CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5) {
        OrdersScreen$confirmOrder(coroutineScope, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, shopOrder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$51$1$3$0(ShopOrder shopOrder, MutableState mutableState) {
        mutableState.setValue(shopOrder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$51$1$4$0(ShopOrder shopOrder, Repo repo, FonRoApp FonRoApp, AppNavigator appNavigator, MutableState mutableState, MutableState mutableState2) {
        OrdersScreen$startMoveToCart(repo, FonRoApp, appNavigator, mutableState, mutableState2, shopOrder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$51$1$5$0(ShopOrder shopOrder, CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5) {
        OrdersScreen$finishOrder(coroutineScope, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, shopOrder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$52$0$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$52$1$0(ShopOrder shopOrder, MutableState mutableState, CoroutineScope coroutineScope, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        mutableState.setValue(null);
        OrdersScreen$cancelOrder(coroutineScope, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6, shopOrder, reason);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$53$0$0(ShopOrder shopOrder, Repo repo, FonRoApp FonRoApp, AppNavigator appNavigator, MutableState mutableState, MutableState mutableState2) {
        CartStore.INSTANCE.clear();
        OrdersScreen$moveToCart(repo, FonRoApp, appNavigator, mutableState, mutableState2, shopOrder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$53$1$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$54$0$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$54$1$0(CoroutineScope coroutineScope, ShopReview shopReview, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new OrdersScreenKt$OrdersScreen$7$2$1$1(shopReview, text, mutableState, mutableState2, mutableState3, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$55$0$0(MutableState mutableState) {
        OrdersScreen$lambda$39(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrdersScreen$lambda$55$1$0(CoroutineScope coroutineScope, ShopStoreInfo shopStoreInfo, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, ShopStoreInfo updated) {
        Intrinsics.checkNotNullParameter(updated, "updated");
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new OrdersScreenKt$OrdersScreen$8$2$1$1(updated, shopStoreInfo, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, null), 3, null);
        return Unit.INSTANCE;
    }

    private static final List<Pair<String, String>> getSTATUS_FILTERS() {
        return CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("", LangKt.tx("Все", new Object[0])), TuplesKt.to("new", LangKt.tx("Новые", new Object[0])), TuplesKt.to("confirmed", LangKt.tx("Готовятся", new Object[0])), TuplesKt.to("done", LangKt.tx("Выполненные", new Object[0])), TuplesKt.to("cancelled", LangKt.tx("Отменённые", new Object[0]))});
    }

    private static final void ShopLinkCard(final String str, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-410459783);
        ComposerKt.sourceInformation(startRestartGroup, "C(ShopLinkCard)P(2)528@21050L1513,528@21026L1537:OrdersScreen.kt#ge60a7");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-410459783, i2, -1, "uz.FonRo.pos.ui.orders.ShopLinkCard (OrdersScreen.kt:527)");
            }
            BasicsKt.m9829OxCardEOp_iR4(null, Dp.m6989constructorimpl(14.0f), 0L, null, null, ComposableLambdaKt.rememberComposableLambda(825177588, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda75
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OrdersScreenKt.ShopLinkCard$lambda$0(str, function0, function02, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, 196656, 29);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda76
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OrdersScreenKt.ShopLinkCard$lambda$1(str, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ShopLinkCard$lambda$0(String str, Function0 function0, Function0 function02, ColumnScope OxCard, Composer composer, int i) {
        boolean z;
        String str2;
        Intrinsics.checkNotNullParameter(OxCard, "$this$OxCard");
        ComposerKt.sourceInformation(composer, "C529@21060L796,548@21865L11,549@21885L672:OrdersScreen.kt#ge60a7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(825177588, i, -1, "uz.FonRo.pos.ui.orders.ShopLinkCard.<anonymous> (OrdersScreen.kt:529)");
            }
            Alignment.Vertical top = Alignment.INSTANCE.getTop();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(11.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, top, composer, 54);
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
            ComposerKt.sourceInformationMarkerStart(composer, 140679491, "C530@21166L301,539@21480L366:OrdersScreen.kt#ge60a7");
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(44.0f)), OxShape.INSTANCE.getTile()), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10201getGreen0d7_KjU(), 0.14f), null, 2, null);
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
            ComposerKt.sourceInformationMarkerStart(composer, 53837449, "C537@21425L28:OrdersScreen.kt#ge60a7");
            TextKt.m2798Text4IGK_g("🌐", (Modifier) null, 0L, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 3078, 0, 131062);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, weight$default);
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
            Updater.m3815setimpl(m3808constructorimpl3, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 501451203, "C540@21526L51,541@21594L10,542@21621L211:OrdersScreen.kt#ge60a7");
            TextKt.m2798Text4IGK_g(LangKt.tx("Ссылка магазина", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(2.0f), composer, 6);
            if (str.length() == 0) {
                z = false;
                str2 = LangKt.tx("адрес не настроен", new Object[0]);
            } else {
                z = false;
                str2 = str;
            }
            TextKt.m2798Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10233getText0d7_KjU(), TextUnitKt.getSp(15), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 0, 0, 65534);
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
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(11.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, fillMaxWidth$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1723032427, "C553@22026L260,560@22299L248:OrdersScreen.kt#ge60a7");
            m10077SoftButtonj4UnuUM(LangKt.tx("🧭 Открыть", new Object[0]), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10201getGreen0d7_KjU(), 0.2f), Ox.INSTANCE.m10240inkl2rxGTc(ColorKt.Color(4279522093L)), function0, RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), false, 0.0f, composer, 0, 96);
            m10077SoftButtonj4UnuUM(LangKt.tx("📤 Поделиться", new Object[0]), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10192getCyan0d7_KjU(), 0.16f), Ox.INSTANCE.m10194getCyanInk0d7_KjU(), function02, RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), false, 0.0f, composer, 0, 96);
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

    /* JADX WARN: Removed duplicated region for block: B:34:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x007c  */
    /* renamed from: SoftButton-j4UnuUM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m10077SoftButtonj4UnuUM(final java.lang.String r47, final long r48, final long r50, final kotlin.jvm.functions.Function0<kotlin.Unit> r52, androidx.compose.ui.Modifier r53, boolean r54, float r55, androidx.compose.runtime.Composer r56, final int r57, final int r58) {
        /*
            Method dump skipped, instructions count: 680
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.orders.OrdersScreenKt.m10077SoftButtonj4UnuUM(java.lang.String, long, long, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void ShopTab(final java.lang.String r24, final boolean r25, final kotlin.jvm.functions.Function0<kotlin.Unit> r26, androidx.compose.ui.Modifier r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.orders.OrdersScreenKt.ShopTab(java.lang.String, boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ShopEmpty(final String str, final String str2, String str3, Composer composer, final int i) {
        int i2;
        final String str4;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1100687354);
        ComposerKt.sourceInformation(startRestartGroup, "C(ShopEmpty)P(!1,2)621@24056L587:OrdersScreen.kt#ge60a7");
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
                ComposerKt.traceEventStart(-1100687354, i2, -1, "uz.FonRo.pos.ui.orders.ShopEmpty (OrdersScreen.kt:620)");
            }
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), OxShape.INSTANCE.getCard()), Ox.INSTANCE.m10218getPanel20d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getCard()), Dp.m6989constructorimpl(20.0f), Dp.m6989constructorimpl(40.0f));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, startRestartGroup, 48);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1694487317, "C630@24373L28,631@24410L11,632@24430L107,633@24546L10,634@24565L72:OrdersScreen.kt#ge60a7");
            int i3 = i2;
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, TextUnitKt.getSp(40), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, (i2 & 14) | 3072, 0, 131062);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer2, 6);
            TextKt.m2798Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10233getText0d7_KjU(), TextUnitKt.getSp(17), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer2, (i3 >> 3) & 14, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer2, 6);
            str4 = str3;
            TextKt.m2798Text4IGK_g(str4, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), TextUnitKt.getSp(13.5d), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), composer2, (i3 >> 6) & 14, 0, 65534);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda82
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OrdersScreenKt.ShopEmpty$lambda$1(str, str2, str4, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009b, code lost:
    
        if (r2 == null) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OrderCard(final uz.FonRo.pos.data.model.ShopOrder r13, final kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.String> r14, final kotlin.jvm.functions.Function0<kotlin.Unit> r15, androidx.compose.runtime.Composer r16, final int r17) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.orders.OrdersScreenKt.OrderCard(uz.FonRo.pos.data.model.ShopOrder, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0612, code lost:
    
        if (r10 == null) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit OrderCard$lambda$1(java.lang.String r68, uz.FonRo.pos.data.model.ShopOrder r69, java.lang.String r70, kotlin.jvm.functions.Function1 r71, androidx.compose.foundation.layout.ColumnScope r72, androidx.compose.runtime.Composer r73, int r74) {
        /*
            Method dump skipped, instructions count: 1876
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.orders.OrdersScreenKt.OrderCard$lambda$1(java.lang.String, uz.FonRo.pos.data.model.ShopOrder, java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    private static final void OrderSheet(final ShopOrder shopOrder, final Function1<? super Double, String> function1, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, final Function0<Unit> function05, Composer composer, final int i) {
        int i2;
        Function0<Unit> function06;
        Composer composer2;
        ComposableLambda composableLambda;
        Composer startRestartGroup = composer.startRestartGroup(-1494379826);
        ComposerKt.sourceInformation(startRestartGroup, "C(OrderSheet)P(6!1,3,2!1,5)757@28993L6230,752@28818L6405:OrdersScreen.kt#ge60a7");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(shopOrder) : startRestartGroup.changedInstance(shopOrder) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            function06 = function0;
            i2 |= startRestartGroup.changedInstance(function06) ? 256 : 128;
        } else {
            function06 = function0;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
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
        if (!startRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1494379826, i2, -1, "uz.FonRo.pos.ui.orders.OrderSheet (OrdersScreen.kt:721)");
            }
            String status = shopOrder.getStatus();
            if (Intrinsics.areEqual(status, "new")) {
                startRestartGroup.startReplaceGroup(-1733062828);
                ComposerKt.sourceInformation(startRestartGroup, "724@27945L392");
                composableLambda = ComposableLambdaKt.rememberComposableLambda(-763283975, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda33
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return OrdersScreenKt.OrderSheet$lambda$0(Function0.this, function02, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, startRestartGroup, 54);
                startRestartGroup.endReplaceGroup();
            } else if (Intrinsics.areEqual(status, "confirmed")) {
                startRestartGroup.startReplaceGroup(-1732625480);
                ComposerKt.sourceInformation(startRestartGroup, "737@28386L388");
                composableLambda = ComposableLambdaKt.rememberComposableLambda(1267275298, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda44
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return OrdersScreenKt.OrderSheet$lambda$1(Function0.this, function04, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, startRestartGroup, 54);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1732211569);
                startRestartGroup.endReplaceGroup();
                composableLambda = null;
            }
            ComposableLambda composableLambda2 = composableLambda;
            String orderNumber = shopOrder.getOrderNumber();
            if (StringsKt.isBlank(orderNumber)) {
                orderNumber = LangKt.tx("Заказ #%s", Long.valueOf(shopOrder.getId()));
            }
            composer2 = startRestartGroup;
            SheetsKt.OxCardSheet(orderNumber, function06, null, true, false, false, composableLambda2, ComposableLambdaKt.rememberComposableLambda(1088830442, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda55
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OrdersScreenKt.OrderSheet$lambda$3(ShopOrder.this, function1, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), composer2, ((i2 >> 3) & 112) | 12585984, 52);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda66
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OrdersScreenKt.OrderSheet$lambda$4(ShopOrder.this, function1, function0, function02, function03, function04, function05, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OrderSheet$lambda$0(Function0 function0, Function0 function02, RowScope rowScope, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(rowScope, "<this>");
        ComposerKt.sourceInformation(composer, "C725@27963L168,729@28148L175:OrdersScreen.kt#ge60a7");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(rowScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-763283975, i2, -1, "uz.FonRo.pos.ui.orders.OrderSheet.<anonymous> (OrdersScreen.kt:725)");
            }
            BasicsKt.OxButton(LangKt.tx("Отменить", new Object[0]), function0, RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.DANGER, BtnSize.LG, false, false, null, composer, 27648, 224);
            BasicsKt.OxButton(LangKt.tx("✓ Подтвердить", new Object[0]), function02, RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, false, false, null, composer, 27648, 224);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OrderSheet$lambda$1(Function0 function0, Function0 function02, RowScope rowScope, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(rowScope, "<this>");
        ComposerKt.sourceInformation(composer, "C738@28404L164,742@28585L175:OrdersScreen.kt#ge60a7");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(rowScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1267275298, i2, -1, "uz.FonRo.pos.ui.orders.OrderSheet.<anonymous> (OrdersScreen.kt:738)");
            }
            BasicsKt.OxButton(LangKt.tx("Выполнен", new Object[0]), function0, RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.OK, BtnSize.LG, false, false, null, composer, 27648, 224);
            BasicsKt.OxButton(LangKt.tx("💵 В кассу", new Object[0]), function02, RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, false, false, null, composer, 27648, 224);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OrderSheet$lambda$3(final ShopOrder shopOrder, final Function1 function1, ColumnScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C758@29034L21,758@29003L6214:OrdersScreen.kt#ge60a7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1088830442, i, -1, "uz.FonRo.pos.ui.orders.OrderSheet.<anonymous> (OrdersScreen.kt:758)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 2115698162, "C761@29134L1355,761@29110L1379,788@30502L11,791@30578L475,791@30554L499,800@31066L11,803@31148L490,803@31124L514,812@31651L11,815@31730L3454,815@31706L3478,883@35197L10:OrdersScreen.kt#ge60a7");
            BasicsKt.m9829OxCardEOp_iR4(null, Dp.m6989constructorimpl(14.0f), 0L, null, null, ComposableLambdaKt.rememberComposableLambda(-843306981, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda56
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OrderSheet$lambda$3$0$0;
                    OrderSheet$lambda$3$0$0 = OrdersScreenKt.OrderSheet$lambda$3$0$0(ShopOrder.this, function1, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OrderSheet$lambda$3$0$0;
                }
            }, composer, 54), composer, 196656, 29);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            BasicsKt.m9829OxCardEOp_iR4(null, Dp.m6989constructorimpl(14.0f), 0L, null, null, ComposableLambdaKt.rememberComposableLambda(-2081109038, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda57
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OrderSheet$lambda$3$0$1;
                    OrderSheet$lambda$3$0$1 = OrdersScreenKt.OrderSheet$lambda$3$0$1(ShopOrder.this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OrderSheet$lambda$3$0$1;
                }
            }, composer, 54), composer, 196656, 29);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            BasicsKt.m9829OxCardEOp_iR4(null, Dp.m6989constructorimpl(14.0f), 0L, null, null, ComposableLambdaKt.rememberComposableLambda(2100247763, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda58
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OrderSheet$lambda$3$0$2;
                    OrderSheet$lambda$3$0$2 = OrdersScreenKt.OrderSheet$lambda$3$0$2(ShopOrder.this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OrderSheet$lambda$3$0$2;
                }
            }, composer, 54), composer, 196656, 29);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            BasicsKt.m9829OxCardEOp_iR4(null, Dp.m6989constructorimpl(14.0f), 0L, null, null, ComposableLambdaKt.rememberComposableLambda(1986637268, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda59
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OrderSheet$lambda$3$0$3;
                    OrderSheet$lambda$3$0$3 = OrdersScreenKt.OrderSheet$lambda$3$0$3(ShopOrder.this, function1, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OrderSheet$lambda$3$0$3;
                }
            }, composer, 54), composer, 196656, 29);
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
    public static final Unit OrderSheet$lambda$3$0$0(ShopOrder shopOrder, Function1 function1, ColumnScope OxCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCard, "$this$OxCard");
        ComposerKt.sourceInformation(composer, "C762@29152L728,779@29897L10,780@29924L48:OrdersScreen.kt#ge60a7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-843306981, i, -1, "uz.FonRo.pos.ui.orders.OrderSheet.<anonymous>.<anonymous>.<anonymous> (OrdersScreen.kt:762)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -333265, "C767@29393L59,768@29473L24,769@29518L344:OrdersScreen.kt#ge60a7");
            BasicsKt.OxChip(statusLabel(shopOrder.getStatus()), statusTone(shopOrder.getStatus()), null, composer, 0, 4);
            BoxKt.Box(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0);
            TextKt.m2798Text4IGK_g((String) function1.invoke(Double.valueOf(shopOrder.getTotalAmount())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10233getText0d7_KjU(), TextUnitKt.getSp(20), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 0, 3072, 57342);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer, 6);
            DetailRow(LangKt.tx("Создан", new Object[0]), Fmt.dt$default(Fmt.INSTANCE, shopOrder.getCreatedAt(), false, 2, null), composer, 0);
            String confirmedAt = shopOrder.getConfirmedAt();
            if (confirmedAt == null || StringsKt.isBlank(confirmedAt)) {
                confirmedAt = null;
            }
            if (confirmedAt == null) {
                composer.startReplaceGroup(-1693660394);
            } else {
                composer.startReplaceGroup(-1693660393);
                ComposerKt.sourceInformation(composer, "*781@30042L40");
                DetailRow(LangKt.tx("Подтверждён", new Object[0]), Fmt.dt$default(Fmt.INSTANCE, confirmedAt, false, 2, null), composer, 0);
            }
            composer.endReplaceGroup();
            String completedAt = shopOrder.getCompletedAt();
            if (completedAt == null || StringsKt.isBlank(completedAt)) {
                completedAt = null;
            }
            if (completedAt == null) {
                composer.startReplaceGroup(-1693549383);
            } else {
                composer.startReplaceGroup(-1693549382);
                ComposerKt.sourceInformation(composer, "*782@30154L37");
                DetailRow(LangKt.tx("Выполнен", new Object[0]), Fmt.dt$default(Fmt.INSTANCE, completedAt, false, 2, null), composer, 0);
            }
            composer.endReplaceGroup();
            String cancelledAt = shopOrder.getCancelledAt();
            if (cancelledAt == null || StringsKt.isBlank(cancelledAt)) {
                cancelledAt = null;
            }
            if (cancelledAt == null) {
                composer.startReplaceGroup(-1693441286);
            } else {
                composer.startReplaceGroup(-1693441285);
                ComposerKt.sourceInformation(composer, "*783@30263L36");
                DetailRow(LangKt.tx("Отменён", new Object[0]), Fmt.dt$default(Fmt.INSTANCE, cancelledAt, false, 2, null), composer, 0);
            }
            composer.endReplaceGroup();
            if (Intrinsics.areEqual(shopOrder.getStatus(), "cancelled")) {
                composer.startReplaceGroup(1330851423);
                ComposerKt.sourceInformation(composer, "");
                String cancelReason = shopOrder.getCancelReason();
                if (cancelReason == null || StringsKt.isBlank(cancelReason)) {
                    cancelReason = null;
                }
                if (cancelReason == null) {
                    composer.startReplaceGroup(-1693278846);
                } else {
                    composer.startReplaceGroup(-1693278845);
                    ComposerKt.sourceInformation(composer, "*785@30427L28");
                    DetailRow(LangKt.tx("Причина", new Object[0]), cancelReason, composer, 0);
                }
                composer.endReplaceGroup();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1693226393);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0050, code lost:
    
        if (r1 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit OrderSheet$lambda$3$0$1(uz.FonRo.pos.data.model.ShopOrder r58, androidx.compose.foundation.layout.ColumnScope r59, androidx.compose.runtime.Composer r60, int r61) {
        /*
            Method dump skipped, instructions count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.orders.OrdersScreenKt.OrderSheet$lambda$3$0$1(uz.FonRo.pos.data.model.ShopOrder, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrderSheet$lambda$3$0$2(ShopOrder shopOrder, ColumnScope OxCard, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxCard, "$this$OxCard");
        ComposerKt.sourceInformation(composer, "C804@31166L38,805@31221L234:OrdersScreen.kt#ge60a7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2100247763, i, -1, "uz.FonRo.pos.ui.orders.OrderSheet.<anonymous>.<anonymous>.<anonymous> (OrdersScreen.kt:804)");
            }
            SectionCaption(LangKt.tx("Способ получения", new Object[0]), composer, 0);
            TextKt.m2798Text4IGK_g(Intrinsics.areEqual(shopOrder.getDeliveryType(), "delivery") ? LangKt.tx("🚗 Доставка", new Object[0]) : LangKt.tx("🏬 Самовывоз", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10233getText0d7_KjU(), TextUnitKt.getSp(16), FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 0, 0, 65534);
            String address = shopOrder.getAddress();
            String str = null;
            if (address == null || StringsKt.isBlank(address)) {
                address = null;
            }
            if (address == null) {
                composer.startReplaceGroup(-602095724);
                composer.endReplaceGroup();
                i2 = 0;
            } else {
                composer.startReplaceGroup(-602095723);
                ComposerKt.sourceInformation(composer, "*809@31521L18");
                i2 = 0;
                ShopLine("📍 " + address, composer, 0);
                composer.endReplaceGroup();
            }
            String note = shopOrder.getNote();
            if (note != null && !StringsKt.isBlank(note)) {
                str = note;
            }
            if (str == null) {
                composer.startReplaceGroup(-602013388);
            } else {
                composer.startReplaceGroup(-602013387);
                ComposerKt.sourceInformation(composer, "*810@31604L18");
                ShopLine("💬 " + str, composer, i2);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrderSheet$lambda$3$0$3(ShopOrder shopOrder, Function1 function1, ColumnScope OxCard, Composer composer, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(OxCard, "$this$OxCard");
        ComposerKt.sourceInformation(composer2, "C816@31748L58:OrdersScreen.kt#ge60a7");
        int i2 = 1;
        int i3 = 0;
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1986637268, i, -1, "uz.FonRo.pos.ui.orders.OrderSheet.<anonymous>.<anonymous>.<anonymous> (OrdersScreen.kt:816)");
            }
            SectionCaption(LangKt.tx("Состав заказа · %s", Integer.valueOf(shopOrder.getItems().size())), composer2, 0);
            Object obj = null;
            if (shopOrder.getItems().isEmpty()) {
                composer2.startReplaceGroup(-738366370);
                ComposerKt.sourceInformation(composer2, "818@31872L40");
                BasicsKt.OxEmptyNote(LangKt.tx("В заказе нет позиций.", new Object[0]), null, composer2, 0, 2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-738183284);
                ComposerKt.sourceInformation(composer2, "867@34473L10,868@34504L648");
                composer2.startReplaceGroup(-2102022949);
                ComposerKt.sourceInformation(composer2, "*822@32114L1377");
                for (ShopOrderItem shopOrderItem : shopOrder.getItems()) {
                    double amount = shopOrderItem.getAmount() > AudioStats.AUDIO_AMPLITUDE_NONE ? shopOrderItem.getAmount() : shopOrderItem.getPrice() * shopOrderItem.getQuantity();
                    Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, i2, obj), 0.0f, Dp.m6989constructorimpl(7.0f), i2, obj);
                    Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
                    Alignment.Vertical top = Alignment.INSTANCE.getTop();
                    ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, top, composer2, 54);
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
                    ComposerKt.sourceInformationMarkerStart(composer2, -818235533, "C829@32473L905,845@33407L58:OrdersScreen.kt#ge60a7");
                    Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, i3);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, i3);
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
                    ComposerKt.sourceInformationMarkerStart(composer2, -33448944, "C830@32535L565,840@33133L215:OrdersScreen.kt#ge60a7");
                    String productName = shopOrderItem.getProductName();
                    if (productName != null) {
                        if (StringsKt.isBlank(productName)) {
                            productName = null;
                        }
                        if (productName != null) {
                            TextKt.m2798Text4IGK_g(productName, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10233getText0d7_KjU(), TextUnitKt.getSp(14), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 0, 3120, 55294);
                            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.nf(Double.valueOf(shopOrderItem.getPrice())) + " × " + Fmt.INSTANCE.qf(Double.valueOf(shopOrderItem.getQuantity())) + " " + Units.INSTANCE.name(shopOrderItem.getUnit()), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 0, 0, 65534);
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            composer.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            TextKt.m2798Text4IGK_g((String) function1.invoke(Double.valueOf(amount)), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowPrice(), composer, 0, 3072, 57342);
                            composer2 = composer;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            obj = null;
                            i2 = 1;
                            i3 = 0;
                        }
                    }
                    productName = LangKt.tx("Товар #%s", Long.valueOf(shopOrderItem.getProductId()));
                    TextKt.m2798Text4IGK_g(productName, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10233getText0d7_KjU(), TextUnitKt.getSp(14), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 0, 3120, 55294);
                    TextKt.m2798Text4IGK_g(Fmt.INSTANCE.nf(Double.valueOf(shopOrderItem.getPrice())) + " × " + Fmt.INSTANCE.qf(Double.valueOf(shopOrderItem.getQuantity())) + " " + Units.INSTANCE.name(shopOrderItem.getUnit()), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 0, 0, 65534);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    TextKt.m2798Text4IGK_g((String) function1.invoke(Double.valueOf(amount)), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowPrice(), composer, 0, 3072, 57342);
                    composer2 = composer;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    obj = null;
                    i2 = 1;
                    i3 = 0;
                }
                composer2.endReplaceGroup();
                if (shopOrder.getDeliveryPrice() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    composer2.startReplaceGroup(-736641995);
                    ComposerKt.sourceInformation(composer2, "849@33589L841");
                    Modifier m1051paddingVpY3zN4$default2 = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(7.0f), 1, null);
                    Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
                    ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), composer2, 6);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, m1051paddingVpY3zN4$default2);
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
                    ComposerKt.sourceInformationMarkerStart(composer2, -1837222011, "C855@33885L419,864@34333L71:OrdersScreen.kt#ge60a7");
                    str3 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                    str4 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                    str = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                    str2 = "C101@5232L9:Row.kt#2w3rfo";
                    TextKt.m2798Text4IGK_g(LangKt.tx("🚚 Доставка", new Object[0]), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10233getText0d7_KjU(), TextUnitKt.getSp(14), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 0, 0, 65532);
                    TextKt.m2798Text4IGK_g((String) function1.invoke(Double.valueOf(shopOrder.getDeliveryPrice())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowPrice(), composer, 0, 3072, 57342);
                    composer2 = composer;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceGroup();
                } else {
                    str = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                    str2 = "C101@5232L9:Row.kt#2w3rfo";
                    str3 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                    str4 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                    composer2.startReplaceGroup(-735787666);
                    composer2.endReplaceGroup();
                }
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer2, 6);
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, str3);
                MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(spaceBetween, Alignment.INSTANCE.getTop(), composer2, 6);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, fillMaxWidth$default);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str4);
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
                Updater.m3815setimpl(m3808constructorimpl4, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3815setimpl(m3808constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3808constructorimpl4.getInserting() || !Intrinsics.areEqual(m3808constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m3808constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m3808constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m3815setimpl(m3808constructorimpl4, materializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -407735110, str2);
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 140872623, "C872@34690L207,876@34922L208:OrdersScreen.kt#ge60a7");
                TextKt.m2798Text4IGK_g(LangKt.tx("Итого · наличными", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10233getText0d7_KjU(), TextUnitKt.getSp(15), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 0, 0, 65534);
                TextKt.m2798Text4IGK_g((String) function1.invoke(Double.valueOf(shopOrder.getTotalAmount())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10233getText0d7_KjU(), TextUnitKt.getSp(15), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 0, 0, 65534);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void SectionCaption(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(247081984);
        ComposerKt.sourceInformation(startRestartGroup, "C(SectionCaption)890@35286L216,899@35507L10:OrdersScreen.kt#ge60a7");
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
                ComposerKt.traceEventStart(247081984, i2, -1, "uz.FonRo.pos.ui.orders.SectionCaption (OrdersScreen.kt:889)");
            }
            String upperCase = str.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            TextKt.m2798Text4IGK_g(upperCase, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), TextUnitKt.getSp(12), FontWeight.INSTANCE.getBold(), null, null, null, null, TextUnitKt.getSp(0.6d), null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777080, null), startRestartGroup, 0, 0, 65534);
            composer2 = startRestartGroup;
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(7.0f), composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda61
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OrdersScreenKt.SectionCaption$lambda$0(str, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void DetailRow(final String str, String str2, Composer composer, final int i) {
        int i2;
        final String str3;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-811706187);
        ComposerKt.sourceInformation(startRestartGroup, "C(DetailRow)904@35591L595:OrdersScreen.kt#ge60a7");
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
                ComposerKt.traceEventStart(-811706187, i2, -1, "uz.FonRo.pos.ui.orders.DetailRow (OrdersScreen.kt:903)");
            }
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(4.0f), 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
            Alignment.Vertical top = Alignment.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, top, startRestartGroup, 54);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -502756392, "C911@35810L107,912@35926L254:OrdersScreen.kt#ge60a7");
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), TextUnitKt.getSp(13.5d), FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer2, i2 & 14, 0, 65534);
            str3 = str2;
            TextKt.m2798Text4IGK_g(str3, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 3, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10233getText0d7_KjU(), TextUnitKt.getSp(13.5d), FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer2, (i2 >> 3) & 14, 3120, 55292);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda80
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OrdersScreenKt.DetailRow$lambda$1(str, str3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ShopLine(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(446835031);
        ComposerKt.sourceInformation(startRestartGroup, "C(ShopLine)924@36243L177:OrdersScreen.kt#ge60a7");
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
                ComposerKt.traceEventStart(446835031, i2, -1, "uz.FonRo.pos.ui.orders.ShopLine (OrdersScreen.kt:923)");
            }
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(5.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), TextUnitKt.getSp(13.5d), FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer2, (i2 & 14) | 48, 0, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OrdersScreenKt.ShopLine$lambda$0(str, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void LinkLine(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(791024851);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinkLine)933@36477L182:OrdersScreen.kt#ge60a7");
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
                ComposerKt.traceEventStart(791024851, i2, -1, "uz.FonRo.pos.ui.orders.LinkLine (OrdersScreen.kt:932)");
            }
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str, PaddingKt.m1051paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(5.0f), 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10192getCyan0d7_KjU(), TextUnitKt.getSp(15), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer2, (i2 & 14) | 48, 0, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda62
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OrdersScreenKt.LinkLine$lambda$0(str, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void CancelSheet(final ShopOrder shopOrder, final Function0<Unit> function0, final Function1<? super String, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(377247638);
        ComposerKt.sourceInformation(startRestartGroup, "C(CancelSheet)P(2,1)944@36858L31,951@37046L348,961@37401L482,946@36895L988:OrdersScreen.kt#ge60a7");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(shopOrder) : startRestartGroup.changedInstance(shopOrder) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(377247638, i2, -1, "uz.FonRo.pos.ui.orders.CancelSheet (OrdersScreen.kt:943)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1757730677, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SheetsKt.OxCardSheet(LangKt.tx("Отменить заказ?", new Object[0]), function0, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-2060107197, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda72
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OrdersScreenKt.CancelSheet$lambda$3(Function0.this, function1, mutableState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1422788090, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda73
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OrdersScreenKt.CancelSheet$lambda$4(ShopOrder.this, mutableState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, (i2 & 112) | 14376960, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda74
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OrdersScreenKt.CancelSheet$lambda$5(ShopOrder.this, function0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String CancelSheet$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CancelSheet$lambda$3(Function0 function0, final Function1 function1, final MutableState mutableState, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C952@37060L88,955@37225L21,953@37161L223:OrdersScreen.kt#ge60a7");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2060107197, i2, -1, "uz.FonRo.pos.ui.orders.CancelSheet.<anonymous> (OrdersScreen.kt:952)");
            }
            BasicsKt.OxButton(LangKt.tx("Назад", new Object[0]), function0, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.GHOST, null, false, false, null, composer, 3072, 240);
            String tx = LangKt.tx("Отменить заказ", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, 216912888, "CC(remember):OrdersScreen.kt#9igjgp");
            boolean changed = composer.changed(function1);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda60
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CancelSheet$lambda$3$0$0;
                        CancelSheet$lambda$3$0$0 = OrdersScreenKt.CancelSheet$lambda$3$0$0(Function1.this, mutableState);
                        return CancelSheet$lambda$3$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.DANGER, BtnSize.LG, false, false, null, composer, 27648, 224);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CancelSheet$lambda$3$0$0(Function1 function1, MutableState mutableState) {
        function1.invoke(CancelSheet$lambda$1(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CancelSheet$lambda$4(ShopOrder shopOrder, final MutableState mutableState, ColumnScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C962@37411L216,967@37636L11,971@37756L15,968@37656L221:OrdersScreen.kt#ge60a7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1422788090, i, -1, "uz.FonRo.pos.ui.orders.CancelSheet.<anonymous> (OrdersScreen.kt:962)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Покупатель увидит отмену заказа %s. ", shopOrder.getOrderNumber()) + LangKt.tx("Причину он тоже прочитает — напишите её понятно.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            String tx = LangKt.tx("Причина", new Object[0]);
            String CancelSheet$lambda$1 = CancelSheet$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 1499765737, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit CancelSheet$lambda$4$0$0;
                        CancelSheet$lambda$4$0$0 = OrdersScreenKt.CancelSheet$lambda$4$0$0(MutableState.this, (String) obj);
                        return CancelSheet$lambda$4$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9846OxFieldDfSPO0(tx, CancelSheet$lambda$1, (Function1) rememberedValue, null, LangKt.tx("Например: товара нет в наличии", new Object[0]), 0, 0, null, false, false, false, false, false, null, null, composer, 805306752, 0, 32232);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CancelSheet$lambda$4$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ReviewCard(final ShopReview shopReview, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(341683138);
        ComposerKt.sourceInformation(startRestartGroup, "C(ReviewCard)P(1)982@38081L2043,982@38031L2093:OrdersScreen.kt#ge60a7");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(shopReview) : startRestartGroup.changedInstance(shopReview) ? 4 : 2) | i;
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
                ComposerKt.traceEventStart(341683138, i2, -1, "uz.FonRo.pos.ui.orders.ReviewCard (OrdersScreen.kt:981)");
            }
            BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(14.0f), OxShape.INSTANCE.getCard(), 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-207212600, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OrdersScreenKt.ReviewCard$lambda$0(ShopReview.this, function0, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, 1572912, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OrdersScreenKt.ReviewCard$lambda$1(ShopReview.this, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReviewCard$lambda$0(ShopReview shopReview, Function0 function0, ColumnScope OxSoftCard, Composer composer, int i) {
        String tx;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C983@38091L570,997@38670L89,1005@39032L140,1027@39900L11,1028@39920L198:OrdersScreen.kt#ge60a7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-207212600, i, -1, "uz.FonRo.pos.ui.orders.ReviewCard.<anonymous> (OrdersScreen.kt:983)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -795924976, "C988@38292L326,995@38631L20:OrdersScreen.kt#ge60a7");
            String customerName = shopReview.getCustomerName();
            if (StringsKt.isBlank(customerName)) {
                customerName = LangKt.tx("Покупатель", new Object[0]);
            }
            TextKt.m2798Text4IGK_g(customerName, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10233getText0d7_KjU(), TextUnitKt.getSp(14.5d), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 0, 3120, 55292);
            Stars(shopReview.getRating(), composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (shopReview.isProduct()) {
                tx = "📦 " + shopReview.getProductName();
            } else {
                tx = LangKt.tx("🏬 Отзыв о магазине", new Object[0]);
            }
            ShopLine(tx, composer, 0);
            if (!StringsKt.isBlank(shopReview.getText())) {
                composer.startReplaceGroup(-1201830863);
                ComposerKt.sourceInformation(composer, "999@38812L201");
                TextKt.m2798Text4IGK_g(shopReview.getText(), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(7.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10233getText0d7_KjU(), TextUnitKt.getSp(14), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(20), null, null, null, 0, 0, null, 16646140, null), composer, 48, 0, 65532);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1201627782);
                composer.endReplaceGroup();
            }
            TextKt.m2798Text4IGK_g(Fmt.dt$default(Fmt.INSTANCE, shopReview.getCreatedAt(), false, 2, null), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(6.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 48, 0, 65532);
            Composer composer2 = composer;
            if (!StringsKt.isBlank(shopReview.getReplyText())) {
                composer2.startReplaceGroup(-1201415401);
                ComposerKt.sourceInformation(composer2, "1011@39230L651");
                Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(10.0f), 0.0f, 0.0f, 13, null), RoundedCornerShapeKt.m1342RoundedCornerShape0680j_4(Dp.m6989constructorimpl(13.0f))), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10192getCyan0d7_KjU(), 0.08f), null, 2, null), Dp.m6989constructorimpl(12.0f), Dp.m6989constructorimpl(10.0f));
                ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, m1050paddingVpY3zN4);
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
                ComposerKt.sourceInformationMarkerStart(composer2, -1443208317, "C1019@39563L175,1023@39755L10,1024@39782L85:OrdersScreen.kt#ge60a7");
                TextKt.m2798Text4IGK_g(LangKt.tx("Ваш ответ", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10194getCyanInk0d7_KjU(), TextUnitKt.getSp(12.5d), FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 0, 0, 65534);
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(3.0f), composer, 6);
                TextKt.m2798Text4IGK_g(shopReview.getReplyText(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10233getText0d7_KjU(), TextUnitKt.getSp(13.5d), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), composer, 0, 0, 65534);
                composer2 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1200766726);
                composer2.endReplaceGroup();
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer2, 6);
            BasicsKt.OxButton(StringsKt.isBlank(shopReview.getReplyText()) ? LangKt.tx("💬 Ответить", new Object[0]) : LangKt.tx("✏️ Изменить ответ", new Object[0]), function0, null, BtnStyle.PLAIN, BtnSize.SM, false, false, null, composer2, 27648, 228);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void Stars(final int i, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1091737200);
        ComposerKt.sourceInformation(startRestartGroup, "C(Stars)1040@40215L153:OrdersScreen.kt#ge60a7");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if (!startRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1091737200, i3, -1, "uz.FonRo.pos.ui.orders.Stars (OrdersScreen.kt:1038)");
            }
            int coerceIn = RangesKt.coerceIn(i, 0, 5);
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(StringsKt.repeat("★", coerceIn) + StringsKt.repeat("☆", 5 - coerceIn), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10184getAmber0d7_KjU(), TextUnitKt.getSp(15), null, null, null, null, null, TextUnitKt.getSp(1), null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777084, null), composer2, 0, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OrdersScreenKt.Stars$lambda$0(i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ReplySheet(final ShopReview shopReview, final Function0<Unit> function0, final Function1<? super String, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-322877022);
        ComposerKt.sourceInformation(startRestartGroup, "C(ReplySheet)P(2)1048@40494L45,1055@40695L238,1064@40940L229,1050@40545L624:OrdersScreen.kt#ge60a7");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(shopReview) : startRestartGroup.changedInstance(shopReview) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-322877022, i2, -1, "uz.FonRo.pos.ui.orders.ReplySheet (OrdersScreen.kt:1047)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1047169521, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(shopReview.getReplyText(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SheetsKt.OxCardSheet(LangKt.tx("Ответ на отзыв", new Object[0]), function0, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(1534735439, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda77
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OrdersScreenKt.ReplySheet$lambda$3(Function1.this, mutableState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(722663430, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda88
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OrdersScreenKt.ReplySheet$lambda$4(MutableState.this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, (i2 & 112) | 14376960, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda89
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OrdersScreenKt.ReplySheet$lambda$5(ShopReview.this, function0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String ReplySheet$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReplySheet$lambda$3(final Function1 function1, final MutableState mutableState, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C1058@40768L16,1056@40709L214:OrdersScreen.kt#ge60a7");
        if ((i & 6) == 0) {
            i2 = (composer.changed(OxCardSheet) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1534735439, i2, -1, "uz.FonRo.pos.ui.orders.ReplySheet.<anonymous> (OrdersScreen.kt:1056)");
            }
            String tx = LangKt.tx("Сохранить", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, 1706976703, "CC(remember):OrdersScreen.kt#9igjgp");
            boolean changed = composer.changed(function1);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ReplySheet$lambda$3$0$0;
                        ReplySheet$lambda$3$0$0 = OrdersScreenKt.ReplySheet$lambda$3$0$0(Function1.this, mutableState);
                        return ReplySheet$lambda$3$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, false, false, null, composer, 27648, 224);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReplySheet$lambda$3$0$0(Function1 function1, MutableState mutableState) {
        function1.invoke(ReplySheet$lambda$1(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReplySheet$lambda$4(final MutableState mutableState, ColumnScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C1068@41057L13,1065@40950L213:OrdersScreen.kt#ge60a7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(722663430, i, -1, "uz.FonRo.pos.ui.orders.ReplySheet.<anonymous> (OrdersScreen.kt:1065)");
            }
            String tx = LangKt.tx("Ответ покупателю", new Object[0]);
            String ReplySheet$lambda$1 = ReplySheet$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, -1305141965, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ReplySheet$lambda$4$0$0;
                        ReplySheet$lambda$4$0$0 = OrdersScreenKt.ReplySheet$lambda$4$0$0(MutableState.this, (String) obj);
                        return ReplySheet$lambda$4$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9846OxFieldDfSPO0(tx, ReplySheet$lambda$1, (Function1) rememberedValue, null, LangKt.tx("Спасибо за отзыв!", new Object[0]), 0, 0, null, false, false, false, false, false, null, null, composer, 805306752, 0, 32232);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReplySheet$lambda$4$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    private static final void ShopSettingsSheet(final ShopStoreInfo shopStoreInfo, Function0<Unit> function0, final Function1<? super ShopStoreInfo, Unit> function1, Composer composer, final int i) {
        int i2;
        final Function1<? super ShopStoreInfo, Unit> function12;
        final ShopStoreInfo shopStoreInfo2;
        Composer composer2;
        final Function0<Unit> function02;
        Composer startRestartGroup = composer.startRestartGroup(266112984);
        ComposerKt.sourceInformation(startRestartGroup, "C(ShopSettingsSheet)1083@41403L43,1084@41463L38,1085@41518L38,1086@41580L51,1087@41652L52,1088@41732L49,1089@41807L60,1090@41894L76,1091@42000L64,1092@42080L37,1093@42133L37,1094@42195L34,1102@42458L1236,1131@43701L8853,1098@42327L10227:OrdersScreen.kt#ge60a7");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(shopStoreInfo) : startRestartGroup.changedInstance(shopStoreInfo) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            function12 = function1;
            shopStoreInfo2 = shopStoreInfo;
            composer2 = startRestartGroup;
            function02 = function0;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(266112984, i2, -1, "uz.FonRo.pos.ui.orders.ShopSettingsSheet (OrdersScreen.kt:1082)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1963455741, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(shopStoreInfo.isEnabled()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1963453826, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(shopStoreInfo.getName(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1963452066, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(shopStoreInfo.getSlug(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1963450069, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                String description = shopStoreInfo.getDescription();
                if (description == null) {
                    description = "";
                }
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(description, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1963447764, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                String currency = shopStoreInfo.getCurrency();
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(currency != null ? currency : "", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState5 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1963445207, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(shopStoreInfo.getDeliveryEnabled()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final MutableState mutableState6 = (MutableState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1963442796, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(plainAmount(shopStoreInfo.getDeliveryPrice()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final MutableState mutableState7 = (MutableState) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1963439996, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(RangesKt.coerceIn((float) shopStoreInfo.getDeliveryRadius(), 0.0f, 30.0f)), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            final MutableState mutableState8 = (MutableState) rememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1963436616, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                rememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(plainAmount(shopStoreInfo.getDeliveryMinAmount()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            final MutableState mutableState9 = (MutableState) rememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1963434083, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                rememberedValue10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(shopStoreInfo.getLat(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            final MutableState mutableState10 = (MutableState) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1963432387, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                rememberedValue11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(shopStoreInfo.getLng(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            final MutableState mutableState11 = (MutableState) rememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1963430406, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue12 = startRestartGroup.rememberedValue();
            if (rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                rememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            final MutableState mutableState12 = (MutableState) rememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            List<String> allowedCurrencies = shopStoreInfo.getAllowedCurrencies();
            if (allowedCurrencies.isEmpty()) {
                String ShopSettingsSheet$lambda$13 = ShopSettingsSheet$lambda$13(mutableState5);
                if (StringsKt.isBlank(ShopSettingsSheet$lambda$13)) {
                    ShopSettingsSheet$lambda$13 = "UZS";
                }
                allowedCurrencies = CollectionsKt.listOf(ShopSettingsSheet$lambda$13);
            }
            List<String> list = allowedCurrencies;
            String tx = LangKt.tx("Настройки магазина", new Object[0]);
            Function3 function3 = new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda83
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OrdersScreenKt.ShopSettingsSheet$lambda$37(Function1.this, shopStoreInfo, mutableState2, mutableState, mutableState3, mutableState4, mutableState5, mutableState6, mutableState7, mutableState8, mutableState9, mutableState10, mutableState11, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            function12 = function1;
            shopStoreInfo2 = shopStoreInfo;
            SheetsKt.OxCardSheet(tx, function0, null, true, false, false, ComposableLambdaKt.rememberComposableLambda(579192389, true, function3, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-138243780, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda84
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OrdersScreenKt.ShopSettingsSheet$lambda$38(MutableState.this, mutableState2, mutableState3, mutableState4, mutableState5, mutableState12, mutableState6, mutableState7, mutableState8, mutableState9, mutableState10, mutableState11, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, (i2 & 112) | 14158848, 52);
            function02 = function0;
            composer2 = startRestartGroup;
            if (ShopSettingsSheet$lambda$34(mutableState12)) {
                composer2.startReplaceGroup(-726494521);
                ComposerKt.sourceInformation(composer2, "1337@52703L24,1338@52750L39,1334@52588L211");
                String ShopSettingsSheet$lambda$132 = ShopSettingsSheet$lambda$13(mutableState5);
                ComposerKt.sourceInformationMarkerStart(composer2, -1963094160, "CC(remember):OrdersScreen.kt#9igjgp");
                Object rememberedValue13 = composer2.rememberedValue();
                if (rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue13 = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda85
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ShopSettingsSheet$lambda$39$0;
                            ShopSettingsSheet$lambda$39$0 = OrdersScreenKt.ShopSettingsSheet$lambda$39$0(MutableState.this);
                            return ShopSettingsSheet$lambda$39$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue13);
                }
                Function0 function03 = (Function0) rememberedValue13;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -1963092641, "CC(remember):OrdersScreen.kt#9igjgp");
                Object rememberedValue14 = composer2.rememberedValue();
                if (rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue14 = new Function1() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda86
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit ShopSettingsSheet$lambda$40$0;
                            ShopSettingsSheet$lambda$40$0 = OrdersScreenKt.ShopSettingsSheet$lambda$40$0(MutableState.this, mutableState12, (String) obj);
                            return ShopSettingsSheet$lambda$40$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue14);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                CurrencyPickerSheet(list, ShopSettingsSheet$lambda$132, function03, (Function1) rememberedValue14, composer2, 3456);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-726276374);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda87
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OrdersScreenKt.ShopSettingsSheet$lambda$41(ShopStoreInfo.this, function02, function12, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean ShopSettingsSheet$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ShopSettingsSheet$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String ShopSettingsSheet$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String ShopSettingsSheet$lambda$7(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String ShopSettingsSheet$lambda$10(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String ShopSettingsSheet$lambda$13(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ShopSettingsSheet$lambda$16(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ShopSettingsSheet$lambda$17(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String ShopSettingsSheet$lambda$19(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final float ShopSettingsSheet$lambda$22(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    private static final void ShopSettingsSheet$lambda$23(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    private static final String ShopSettingsSheet$lambda$25(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final Double ShopSettingsSheet$lambda$28(MutableState<Double> mutableState) {
        return mutableState.getValue();
    }

    private static final Double ShopSettingsSheet$lambda$31(MutableState<Double> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ShopSettingsSheet$lambda$34(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ShopSettingsSheet$lambda$35(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ShopSettingsSheet$lambda$37(final Function1 function1, final ShopStoreInfo shopStoreInfo, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, final MutableState mutableState8, final MutableState mutableState9, final MutableState mutableState10, final MutableState mutableState11, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C1105@42531L1014,1103@42472L1212:OrdersScreen.kt#ge60a7");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(579192389, i2, -1, "uz.FonRo.pos.ui.orders.ShopSettingsSheet.<anonymous> (OrdersScreen.kt:1103)");
            }
            String tx = LangKt.tx("Сохранить", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -1741859301, "CC(remember):OrdersScreen.kt#9igjgp");
            boolean changed = composer.changed(function1) | composer.changedInstance(shopStoreInfo);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                Function0 function0 = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ShopSettingsSheet$lambda$37$0$0;
                        ShopSettingsSheet$lambda$37$0$0 = OrdersScreenKt.ShopSettingsSheet$lambda$37$0$0(Function1.this, shopStoreInfo, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6, mutableState7, mutableState8, mutableState9, mutableState10, mutableState11);
                        return ShopSettingsSheet$lambda$37$0$0;
                    }
                };
                composer.updateRememberedValue(function0);
                rememberedValue = function0;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, false, false, null, composer, 27648, 224);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopSettingsSheet$lambda$37$0$0(Function1 function1, ShopStoreInfo shopStoreInfo, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7, MutableState mutableState8, MutableState mutableState9, MutableState mutableState10, MutableState mutableState11) {
        if (StringsKt.trim((CharSequence) ShopSettingsSheet$lambda$4(mutableState)).toString().length() < 2) {
            Toaster.INSTANCE.error(LangKt.tx("Название — минимум 2 символа", new Object[0]));
        } else {
            boolean ShopSettingsSheet$lambda$1 = ShopSettingsSheet$lambda$1(mutableState2);
            String obj = StringsKt.trim((CharSequence) ShopSettingsSheet$lambda$4(mutableState)).toString();
            String obj2 = StringsKt.trim((CharSequence) ShopSettingsSheet$lambda$7(mutableState3)).toString();
            String obj3 = StringsKt.trim((CharSequence) ShopSettingsSheet$lambda$10(mutableState4)).toString();
            String ShopSettingsSheet$lambda$13 = ShopSettingsSheet$lambda$13(mutableState5);
            if (StringsKt.isBlank(ShopSettingsSheet$lambda$13)) {
                ShopSettingsSheet$lambda$13 = null;
            }
            function1.invoke(ShopStoreInfo.copy$default(shopStoreInfo, ShopSettingsSheet$lambda$1, obj, obj2, obj3, ShopSettingsSheet$lambda$13, ShopSettingsSheet$lambda$16(mutableState6), parseAmount(ShopSettingsSheet$lambda$19(mutableState7)), ShopSettingsSheet$lambda$22(mutableState8), parseAmount(ShopSettingsSheet$lambda$25(mutableState9)), ShopSettingsSheet$lambda$28(mutableState10), ShopSettingsSheet$lambda$31(mutableState11), null, 0, 0, 0, 0, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, null, 522240, null));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ShopSettingsSheet$lambda$38(final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, final MutableState mutableState7, final MutableState mutableState8, final MutableState mutableState9, final MutableState mutableState10, final MutableState mutableState11, final MutableState mutableState12, ColumnScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C1132@43742L21,1132@43711L8837:OrdersScreen.kt#ge60a7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-138243780, i, -1, "uz.FonRo.pos.ui.orders.ShopSettingsSheet.<anonymous> (OrdersScreen.kt:1132)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1726564917, "C1138@43969L1161,1135@43826L1304,1165@45143L11,1170@45288L13,1167@45168L196,1174@45378L50,1175@45441L10,1176@45464L623,1192@46100L11,1197@46259L20,1194@46125L387,1204@46611L827,1204@46557L881,1222@47451L11,1225@47555L3373,1225@47501L3427,1294@50941L11,1297@51053L1462,1297@50999L1516,1329@52528L10:OrdersScreen.kt#ge60a7");
            BasicsKt.m9829OxCardEOp_iR4(null, Dp.m6989constructorimpl(14.0f), ShopSettingsSheet$lambda$1(mutableState) ? Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10201getGreen0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null) : Ox.INSTANCE.m10218getPanel20d7_KjU(), null, null, ComposableLambdaKt.rememberComposableLambda(1785194347, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda63
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ShopSettingsSheet$lambda$38$0$0;
                    ShopSettingsSheet$lambda$38$0$0 = OrdersScreenKt.ShopSettingsSheet$lambda$38$0$0(MutableState.this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ShopSettingsSheet$lambda$38$0$0;
                }
            }, composer, 54), composer, 196656, 25);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(14.0f), composer, 6);
            String tx = LangKt.tx("Название магазина", new Object[0]);
            String ShopSettingsSheet$lambda$4 = ShopSettingsSheet$lambda$4(mutableState2);
            ComposerKt.sourceInformationMarkerStart(composer, -359908269, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda64
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ShopSettingsSheet$lambda$38$0$1$0;
                        ShopSettingsSheet$lambda$38$0$1$0 = OrdersScreenKt.ShopSettingsSheet$lambda$38$0$1$0(MutableState.this, (String) obj);
                        return ShopSettingsSheet$lambda$38$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9846OxFieldDfSPO0(tx, ShopSettingsSheet$lambda$4, (Function1) rememberedValue, null, LangKt.tx("Мой магазин", new Object[0]), 0, 0, null, false, false, false, false, false, null, null, composer, 384, 0, 32744);
            TextKt.m2798Text4IGK_g(LangKt.tx("🔗 Адрес витрины", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getLabel(), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer, 6);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(9.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, fillMaxWidth$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -323899908, "C1181@45684L154,1187@45934L20,1185@45855L218:OrdersScreen.kt#ge60a7");
            TextKt.m2798Text4IGK_g("FonRo.uz/", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10233getText0d7_KjU(), 0L, FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composer, 6, 0, 65534);
            String ShopSettingsSheet$lambda$7 = ShopSettingsSheet$lambda$7(mutableState3);
            ComposerKt.sourceInformationMarkerStart(composer, -841724746, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda65
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ShopSettingsSheet$lambda$38$0$2$0$0;
                        ShopSettingsSheet$lambda$38$0$2$0$0 = OrdersScreenKt.ShopSettingsSheet$lambda$38$0$2$0$0(MutableState.this, (String) obj);
                        return ShopSettingsSheet$lambda$38$0$2$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9847OxInputWwzLCwM(ShopSettingsSheet$lambda$7, (Function1) rememberedValue2, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), "moy-magazin", 0, 0, null, false, false, false, false, false, null, null, composer, 3120, 0, 16368);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(13.0f), composer, 6);
            String tx2 = LangKt.tx("Описание для покупателей", new Object[0]);
            String ShopSettingsSheet$lambda$10 = ShopSettingsSheet$lambda$10(mutableState4);
            ComposerKt.sourceInformationMarkerStart(composer, -359877190, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda67
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ShopSettingsSheet$lambda$38$0$3$0;
                        ShopSettingsSheet$lambda$38$0$3$0 = OrdersScreenKt.ShopSettingsSheet$lambda$38$0$3$0(MutableState.this, (String) obj);
                        return ShopSettingsSheet$lambda$38$0$3$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9846OxFieldDfSPO0(tx2, ShopSettingsSheet$lambda$10, (Function1) rememberedValue3, null, LangKt.tx("Пара слов о магазине", new Object[0]), 0, 0, null, false, false, false, false, false, null, LangKt.tx("Покупатели увидят это на странице «О магазине» витрины вместе с адресом, телефоном и отзывами.", new Object[0]), composer, 805306752, 0, 15848);
            BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(14.0f), OxShape.INSTANCE.getCardSoft(), 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1140958272, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda68
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ShopSettingsSheet$lambda$38$0$4;
                    ShopSettingsSheet$lambda$38$0$4 = OrdersScreenKt.ShopSettingsSheet$lambda$38$0$4(MutableState.this, mutableState6, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ShopSettingsSheet$lambda$38$0$4;
                }
            }, composer, 54), composer, 1572912, 57);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(14.0f), OxShape.INSTANCE.getCardSoft(), 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1319064553, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda69
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ShopSettingsSheet$lambda$38$0$5;
                    ShopSettingsSheet$lambda$38$0$5 = OrdersScreenKt.ShopSettingsSheet$lambda$38$0$5(MutableState.this, mutableState8, mutableState9, mutableState10, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ShopSettingsSheet$lambda$38$0$5;
                }
            }, composer, 54), composer, 1572912, 57);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(14.0f), OxShape.INSTANCE.getCardSoft(), 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(431027016, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda70
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ShopSettingsSheet$lambda$38$0$6;
                    ShopSettingsSheet$lambda$38$0$6 = OrdersScreenKt.ShopSettingsSheet$lambda$38$0$6(MutableState.this, mutableState12, mutableState7, mutableState9, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ShopSettingsSheet$lambda$38$0$6;
                }
            }, composer, 54), composer, 1572912, 57);
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
    public static final Unit ShopSettingsSheet$lambda$38$0$0(final MutableState mutableState, ColumnScope OxCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCard, "$this$OxCard");
        ComposerKt.sourceInformation(composer, "C1139@43987L842,1158@44846L10,1159@44873L243:OrdersScreen.kt#ge60a7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1785194347, i, -1, "uz.FonRo.pos.ui.orders.ShopSettingsSheet.<anonymous>.<anonymous>.<anonymous> (OrdersScreen.kt:1139)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1699265291, "C1144@44228L226,1151@44570L18,1152@44638L151,1149@44475L336:OrdersScreen.kt#ge60a7");
            TextKt.m2798Text4IGK_g(LangKt.tx("🌐 Онлайн-магазин ", new Object[0]) + (ShopSettingsSheet$lambda$1(mutableState) ? LangKt.tx("включён", new Object[0]) : LangKt.tx("выключен", new Object[0])), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH2(), composer, 0, 0, 65532);
            boolean ShopSettingsSheet$lambda$1 = ShopSettingsSheet$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, -608993959, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda54
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ShopSettingsSheet$lambda$38$0$0$0$0$0;
                        ShopSettingsSheet$lambda$38$0$0$0$0$0 = OrdersScreenKt.ShopSettingsSheet$lambda$38$0$0$0$0$0(MutableState.this, ((Boolean) obj).booleanValue());
                        return ShopSettingsSheet$lambda$38$0$0$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SwitchKt.Switch(ShopSettingsSheet$lambda$1, (Function1) rememberedValue, null, null, false, SwitchDefaults.INSTANCE.m2680colorsV1nXRL4(Color.INSTANCE.m4421getWhite0d7_KjU(), Ox.INSTANCE.m10201getGreen0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 6, 1572864, 65532), null, composer, 48, 92);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(4.0f), composer, 6);
            TextKt.m2798Text4IGK_g(ShopSettingsSheet$lambda$1(mutableState) ? LangKt.tx("Витрина открыта: покупатели видят товары и делают заказы.", new Object[0]) : LangKt.tx("Витрина закрыта: покупатели не видят магазин.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopSettingsSheet$lambda$38$0$0$0$0$0(MutableState mutableState, boolean z) {
        ShopSettingsSheet$lambda$2(mutableState, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopSettingsSheet$lambda$38$0$1$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopSettingsSheet$lambda$38$0$2$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(StringsKt.trim((CharSequence) it).toString());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopSettingsSheet$lambda$38$0$3$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopSettingsSheet$lambda$38$0$4(MutableState mutableState, final MutableState mutableState2, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C1205@46629L663,1219@47309L10,1220@47336L88:OrdersScreen.kt#ge60a7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1140958272, i, -1, "uz.FonRo.pos.ui.orders.ShopSettingsSheet.<anonymous>.<anonymous>.<anonymous> (OrdersScreen.kt:1205)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1689258925, "C1210@46870L80,1215@47189L23,1211@46971L303:OrdersScreen.kt#ge60a7");
            TextKt.m2798Text4IGK_g(LangKt.tx("💱 Валюта витрины", new Object[0]), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH2(), composer, 0, 0, 65532);
            String ShopSettingsSheet$lambda$13 = ShopSettingsSheet$lambda$13(mutableState);
            if (StringsKt.isBlank(ShopSettingsSheet$lambda$13)) {
                ShopSettingsSheet$lambda$13 = "UZS";
            }
            String str = ShopSettingsSheet$lambda$13;
            long m10241tintBg5vOe2sY = Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10192getCyan0d7_KjU(), 0.14f);
            long m10194getCyanInk0d7_KjU = Ox.INSTANCE.m10194getCyanInk0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(composer, -608671725, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ShopSettingsSheet$lambda$38$0$4$0$1$0;
                        ShopSettingsSheet$lambda$38$0$4$0$1$0 = OrdersScreenKt.ShopSettingsSheet$lambda$38$0$4$0$1$0(MutableState.this);
                        return ShopSettingsSheet$lambda$38$0$4$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m10077SoftButtonj4UnuUM(str, m10241tintBg5vOe2sY, m10194getCyanInk0d7_KjU, (Function0) rememberedValue, null, false, Dp.m6989constructorimpl(42.0f), composer, 1575936, 48);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(4.0f), composer, 6);
            TextKt.m2798Text4IGK_g(LangKt.tx("Покупатели увидят все цены на витрине в этой валюте.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopSettingsSheet$lambda$38$0$4$0$1$0(MutableState mutableState) {
        ShopSettingsSheet$lambda$35(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopSettingsSheet$lambda$38$0$5(final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C1226@47573L718:OrdersScreen.kt#ge60a7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1319064553, i, -1, "uz.FonRo.pos.ui.orders.ShopSettingsSheet.<anonymous>.<anonymous>.<anonymous> (OrdersScreen.kt:1226)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 129480115, "C1231@47814L91,1234@48027L24,1235@48101L150,1232@47926L347:OrdersScreen.kt#ge60a7");
            TextKt.m2798Text4IGK_g(LangKt.tx("🚚 Магазин доставляет заказы", new Object[0]), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH2(), composer, 0, 0, 65532);
            boolean ShopSettingsSheet$lambda$16 = ShopSettingsSheet$lambda$16(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, -1935479491, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ShopSettingsSheet$lambda$38$0$5$0$0$0;
                        ShopSettingsSheet$lambda$38$0$5$0$0$0 = OrdersScreenKt.ShopSettingsSheet$lambda$38$0$5$0$0$0(MutableState.this, ((Boolean) obj).booleanValue());
                        return ShopSettingsSheet$lambda$38$0$5$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SwitchKt.Switch(ShopSettingsSheet$lambda$16, (Function1) rememberedValue, null, null, false, SwitchDefaults.INSTANCE.m2680colorsV1nXRL4(Color.INSTANCE.m4421getWhite0d7_KjU(), Ox.INSTANCE.m10192getCyan0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 6, 1572864, 65532), null, composer, 48, 92);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ShopSettingsSheet$lambda$16(mutableState)) {
                composer.startReplaceGroup(1597156225);
                ComposerKt.sourceInformation(composer, "1243@48352L11,1247@48549L22,1244@48384L269,1251@48675L729,1268@49521L23,1274@49902L491,1266@49425L990,1284@50436L10,1288@50668L26,1285@50467L429");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer, 6);
                String tx = LangKt.tx("Цена доставки (0 — бесплатно)", new Object[0]);
                String ShopSettingsSheet$lambda$19 = ShopSettingsSheet$lambda$19(mutableState2);
                ComposerKt.sourceInformationMarkerStart(composer, 605714943, "CC(remember):OrdersScreen.kt#9igjgp");
                Object rememberedValue2 = composer.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda32
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit ShopSettingsSheet$lambda$38$0$5$1$0;
                            ShopSettingsSheet$lambda$38$0$5$1$0 = OrdersScreenKt.ShopSettingsSheet$lambda$38$0$5$1$0(MutableState.this, (String) obj);
                            return ShopSettingsSheet$lambda$38$0$5$1$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                FieldsKt.m9846OxFieldDfSPO0(tx, ShopSettingsSheet$lambda$19, (Function1) rememberedValue2, null, null, KeyboardType.INSTANCE.m6691getNumberPjHm6EE(), 0, null, false, false, false, false, false, null, null, composer, 196992, 0, 32728);
                Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, centerVertically2, composer, 54);
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
                ComposerKt.sourceInformationMarkerStart(composer, 346058811, "C1256@48936L222,1261@49183L199:OrdersScreen.kt#ge60a7");
                TextKt.m2798Text4IGK_g(LangKt.tx("Радиус бесплатной доставки, км (0 — выключено)", new Object[0]), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getLabel(), composer, 0, 0, 65532);
                TextKt.m2798Text4IGK_g(Fmt.INSTANCE.qf(Double.valueOf(ShopSettingsSheet$lambda$22(mutableState3))), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10233getText0d7_KjU(), 0L, FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composer, 0, 0, 65534);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                float ShopSettingsSheet$lambda$22 = ShopSettingsSheet$lambda$22(mutableState3);
                ComposerKt.sourceInformationMarkerStart(composer, 605746048, "CC(remember):OrdersScreen.kt#9igjgp");
                Object rememberedValue3 = composer.rememberedValue();
                if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda34
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit ShopSettingsSheet$lambda$38$0$5$3$0;
                            ShopSettingsSheet$lambda$38$0$5$3$0 = OrdersScreenKt.ShopSettingsSheet$lambda$38$0$5$3$0(MutableState.this, ((Float) obj).floatValue());
                            return ShopSettingsSheet$lambda$38$0$5$3$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                SliderKt.Slider(ShopSettingsSheet$lambda$22, (Function1) rememberedValue3, null, false, RangesKt.rangeTo(0.0f, 30.0f), 59, null, SliderDefaults.INSTANCE.m2600colorsq0g_0yA(Ox.INSTANCE.m10192getCyan0d7_KjU(), Ox.INSTANCE.m10192getCyan0d7_KjU(), Color.INSTANCE.m4419getTransparent0d7_KjU(), Ox.INSTANCE.m10236getTrack0d7_KjU(), Color.INSTANCE.m4419getTransparent0d7_KjU(), 0L, 0L, 0L, 0L, 0L, composer, 24960, 6, 992), null, composer, 196656, 332);
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer, 6);
                String tx2 = LangKt.tx("Мин. сумма товаров для бесплатной доставки (0 — без минимума)", new Object[0]);
                String ShopSettingsSheet$lambda$25 = ShopSettingsSheet$lambda$25(mutableState4);
                ComposerKt.sourceInformationMarkerStart(composer, 605782755, "CC(remember):OrdersScreen.kt#9igjgp");
                Object rememberedValue4 = composer.rememberedValue();
                if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda35
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit ShopSettingsSheet$lambda$38$0$5$4$0;
                            ShopSettingsSheet$lambda$38$0$5$4$0 = OrdersScreenKt.ShopSettingsSheet$lambda$38$0$5$4$0(MutableState.this, (String) obj);
                            return ShopSettingsSheet$lambda$38$0$5$4$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                FieldsKt.m9846OxFieldDfSPO0(tx2, ShopSettingsSheet$lambda$25, (Function1) rememberedValue4, null, null, KeyboardType.INSTANCE.m6691getNumberPjHm6EE(), 0, null, false, false, false, false, false, null, LangKt.tx("Действует, когда указана локация магазина, а покупатель отправил свою при заказе.", new Object[0]), composer, 196992, 0, 16344);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1599639449);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopSettingsSheet$lambda$38$0$5$0$0$0(MutableState mutableState, boolean z) {
        ShopSettingsSheet$lambda$17(mutableState, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopSettingsSheet$lambda$38$0$5$1$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopSettingsSheet$lambda$38$0$5$3$0(MutableState mutableState, float f) {
        ShopSettingsSheet$lambda$23(mutableState, f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopSettingsSheet$lambda$38$0$5$4$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopSettingsSheet$lambda$38$0$6(final MutableState mutableState, final MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, ColumnScope OxSoftCard, Composer composer, int i) {
        final MutableState mutableState5;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C1298@51071L50,1299@51138L10,1300@51165L177,1304@51359L11,1309@51584L60,1305@51387L376,1313@51780L11,1314@51808L279,1319@52104L11,1325@52401L26,1320@52132L369:OrdersScreen.kt#ge60a7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(431027016, i, -1, "uz.FonRo.pos.ui.orders.ShopSettingsSheet.<anonymous>.<anonymous>.<anonymous> (OrdersScreen.kt:1298)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("📍 Локация магазина", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH2(), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer, 6);
            TextKt.m2798Text4IGK_g(LangKt.tx("Нажмите на карту, чтобы поставить точку. Голубой круг — радиус бесплатной доставки.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer, 6);
            Double ShopSettingsSheet$lambda$28 = ShopSettingsSheet$lambda$28(mutableState);
            Double ShopSettingsSheet$lambda$31 = ShopSettingsSheet$lambda$31(mutableState2);
            double ShopSettingsSheet$lambda$22 = ShopSettingsSheet$lambda$16(mutableState3) ? ShopSettingsSheet$lambda$22(mutableState4) : AudioStats.AUDIO_AMPLITUDE_NONE;
            ComposerKt.sourceInformationMarkerStart(composer, 1900119012, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableState5 = mutableState;
                rememberedValue = new Function2() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ShopSettingsSheet$lambda$38$0$6$0$0;
                        ShopSettingsSheet$lambda$38$0$6$0$0 = OrdersScreenKt.ShopSettingsSheet$lambda$38$0$6$0$0(MutableState.this, mutableState2, ((Double) obj).doubleValue(), ((Double) obj2).doubleValue());
                        return ShopSettingsSheet$lambda$38$0$6$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            } else {
                mutableState5 = mutableState;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            StoreLocationMapKt.m10080StoreLocationMapHYR8e34(ShopSettingsSheet$lambda$28, ShopSettingsSheet$lambda$31, ShopSettingsSheet$lambda$22, (Function2) rememberedValue, ClipKt.clip(Modifier.INSTANCE, OxShape.INSTANCE.getCardSoft()), Dp.m6989constructorimpl(230.0f), composer, 199680, 0);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer, 6);
            TextKt.m2798Text4IGK_g((ShopSettingsSheet$lambda$28(mutableState5) == null || ShopSettingsSheet$lambda$31(mutableState2) == null) ? LangKt.tx("Точка не задана — нажмите на карту.", new Object[0]) : LangKt.tx("✅ Точка задана", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), TextUnitKt.getSp(13.5d), FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer, 6);
            String tx = LangKt.tx("Убрать точку", new Object[0]);
            long m10241tintBg5vOe2sY = Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10213getOrange0d7_KjU(), 0.2f);
            long m10240inkl2rxGTc = Ox.INSTANCE.m10240inkl2rxGTc(ColorKt.Color(4288295954L));
            boolean z = (ShopSettingsSheet$lambda$28(mutableState) == null || ShopSettingsSheet$lambda$31(mutableState2) == null) ? false : true;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1900145122, "CC(remember):OrdersScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ShopSettingsSheet$lambda$38$0$6$1$0;
                        ShopSettingsSheet$lambda$38$0$6$1$0 = OrdersScreenKt.ShopSettingsSheet$lambda$38$0$6$1$0(MutableState.this, mutableState2);
                        return ShopSettingsSheet$lambda$38$0$6$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m10077SoftButtonj4UnuUM(tx, m10241tintBg5vOe2sY, m10240inkl2rxGTc, (Function0) rememberedValue2, fillMaxWidth$default, z, 0.0f, composer, 27648, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopSettingsSheet$lambda$38$0$6$0$0(MutableState mutableState, MutableState mutableState2, double d, double d2) {
        mutableState.setValue(Double.valueOf(d));
        mutableState2.setValue(Double.valueOf(d2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopSettingsSheet$lambda$38$0$6$1$0(MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(null);
        mutableState2.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopSettingsSheet$lambda$39$0(MutableState mutableState) {
        ShopSettingsSheet$lambda$35(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopSettingsSheet$lambda$40$0(MutableState mutableState, MutableState mutableState2, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        ShopSettingsSheet$lambda$35(mutableState2, false);
        return Unit.INSTANCE;
    }

    private static final void CurrencyPickerSheet(final List<String> list, final String str, final Function0<Unit> function0, final Function1<? super String, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1054910328);
        ComposerKt.sourceInformation(startRestartGroup, "C(CurrencyPickerSheet)P(!1,3)1357@53267L666,1352@53129L804:OrdersScreen.kt#ge60a7");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(list) : startRestartGroup.changedInstance(list) ? 4 : 2) | i;
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
            i2 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if (!startRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1054910328, i2, -1, "uz.FonRo.pos.ui.orders.CurrencyPickerSheet (OrdersScreen.kt:1349)");
            }
            SheetsKt.OxCardSheet(LangKt.tx("Валюта витрины", new Object[0]), function0, null, false, false, false, null, ComposableLambdaKt.rememberComposableLambda(650553564, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OrdersScreenKt.CurrencyPickerSheet$lambda$0(list, function1, str, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 >> 3) & 112) | 12804096, 76);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OrdersScreenKt.CurrencyPickerSheet$lambda$1(list, str, function0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CurrencyPickerSheet$lambda$0(List list, final Function1 function1, final String str, ColumnScope OxCardSheet, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer2, "C1358@53308L21,1358@53277L650:OrdersScreen.kt#ge60a7");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(650553564, i, -1, "uz.FonRo.pos.ui.orders.CurrencyPickerSheet.<anonymous> (OrdersScreen.kt:1358)");
            }
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, composer2, 0, 1), false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, verticalScroll$default);
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
            ComposerKt.sourceInformationMarkerStart(composer2, -1273101694, "C:OrdersScreen.kt#ge60a7");
            composer2.startReplaceGroup(1760047862);
            ComposerKt.sourceInformation(composer2, "*1362@53462L16,1363@53511L374,1360@53391L512");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final String str2 = (String) it.next();
                ComposerKt.sourceInformationMarkerStart(composer2, 219322246, "CC(remember):OrdersScreen.kt#9igjgp");
                boolean changed = composer2.changed(function1) | composer2.changed(str2);
                Object rememberedValue = composer2.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CurrencyPickerSheet$lambda$0$0$0$0$0;
                            CurrencyPickerSheet$lambda$0$0$0$0$0 = OrdersScreenKt.CurrencyPickerSheet$lambda$0$0$0$0$0(Function1.this, str2);
                            return CurrencyPickerSheet$lambda$0$0$0$0$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BasicsKt.m9832OxRow1YH7lEI(str2, null, null, (Function0) rememberedValue, false, 0L, null, ComposableLambdaKt.rememberComposableLambda(-725387763, true, new Function3() { // from class: uz.FonRo.pos.ui.orders.OrdersScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit CurrencyPickerSheet$lambda$0$0$0$1;
                        CurrencyPickerSheet$lambda$0$0$0$1 = OrdersScreenKt.CurrencyPickerSheet$lambda$0$0$0$1(str2, str, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return CurrencyPickerSheet$lambda$0$0$0$1;
                    }
                }, composer2, 54), composer2, 12582912, 118);
                composer2 = composer;
            }
            composer.endReplaceGroup();
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
    public static final Unit CurrencyPickerSheet$lambda$0$0$0$0$0(Function1 function1, String str) {
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CurrencyPickerSheet$lambda$0$0$0$1(String str, String str2, RowScope OxRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxRow, "$this$OxRow");
        ComposerKt.sourceInformation(composer, "C:OrdersScreen.kt#ge60a7");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-725387763, i, -1, "uz.FonRo.pos.ui.orders.CurrencyPickerSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OrdersScreen.kt:1364)");
            }
            if (Intrinsics.areEqual(str, str2)) {
                composer.startReplaceGroup(-2046324315);
                ComposerKt.sourceInformation(composer, "1365@53589L248");
                IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getOk(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(18.0f)), Ox.INSTANCE.m10211getOk0d7_KjU(), composer, 432, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-2046032171);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final String plainAmount(double d) {
        long j = (long) d;
        return d == ((double) j) ? String.valueOf(j) : String.valueOf(d);
    }

    private static final double parseAmount(String str) {
        String replace$default = StringsKt.replace$default(str, ",", ".", false, 4, (Object) null);
        StringBuilder sb = new StringBuilder();
        int length = replace$default.length();
        for (int i = 0; i < length; i++) {
            char charAt = replace$default.charAt(i);
            if (Character.isDigit(charAt) || charAt == '.') {
                sb.append(charAt);
            }
        }
        Double doubleOrNull = StringsKt.toDoubleOrNull(sb.toString());
        return doubleOrNull != null ? doubleOrNull.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    private static final String statusLabel(String str) {
        switch (str.hashCode()) {
            case -804109473:
                if (str.equals("confirmed")) {
                    return LangKt.tx("Готовится", new Object[0]);
                }
                break;
            case 108960:
                if (str.equals("new")) {
                    return LangKt.tx("Новый", new Object[0]);
                }
                break;
            case 3089282:
                if (str.equals("done")) {
                    return LangKt.tx("Выполнен", new Object[0]);
                }
                break;
            case 476588369:
                if (str.equals("cancelled")) {
                    return LangKt.tx("Отменён", new Object[0]);
                }
                break;
        }
        String str2 = str;
        if (StringsKt.isBlank(str2)) {
            str2 = "—";
        }
        return str2;
    }

    private static final ChipTone statusTone(String str) {
        switch (str.hashCode()) {
            case -804109473:
                if (str.equals("confirmed")) {
                    return ChipTone.BLUE;
                }
                break;
            case 108960:
                if (str.equals("new")) {
                    return ChipTone.WARN;
                }
                break;
            case 3089282:
                if (str.equals("done")) {
                    return ChipTone.OK;
                }
                break;
            case 476588369:
                if (str.equals("cancelled")) {
                    return ChipTone.BAD;
                }
                break;
        }
        return ChipTone.DIM;
    }
}
