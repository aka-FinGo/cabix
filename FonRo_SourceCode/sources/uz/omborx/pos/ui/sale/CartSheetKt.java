package uz.FonRo.pos.ui.sale;

import androidx.autofill.HintConstants;
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
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Num;
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.core.Units;
import uz.FonRo.pos.data.model.Customer;
import uz.FonRo.pos.data.model.PayType;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnSize;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.ChipsKt;
import uz.FonRo.pos.ui.components.FieldsKt;
import uz.FonRo.pos.ui.components.ModifiersKt;
import uz.FonRo.pos.ui.components.NumpadKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: CartSheet.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u001a5\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0007b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¢\u0006\u0002\u0010\u000b\u001aI\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00060\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0003b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¢\u0006\u0002\u0010\u0016\u001a_\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060\u0014H\u0003b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¢\u0006\u0002\u0010\u001d\u001a\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020 H\u0002\u001a=\u0010\"\u001a\u00020\u0006*\u00020#2\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'H\u0003b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¢\u0006\u0004\b(\u0010)\u001aC\u0010*\u001a\u00020\u0006*\u00020#2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0003b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¢\u0006\u0004\b-\u0010.\u001a9\u0010/\u001a\u00020\u0006*\u00020#2\u0006\u00100\u001a\u0002012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0003b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¢\u0006\u0002\u00102\u001aQ\u00103\u001a\u00020\u0006*\u00020#2\u0006\u00104\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00192\u0006\u00105\u001a\u0002012\u0006\u00100\u001a\u0002012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0003b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¢\u0006\u0002\u00106\u001a9\u00107\u001a\u00020\u0006*\u00020#2\u0006\u0010+\u001a\u00020\u00192\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0003b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¢\u0006\u0002\u00108\u001a7\u00109\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\u0006\u0010:\u001a\u000201H\u0003b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¢\u0006\u0002\u0010;\u001a'\u0010<\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0019H\u0003b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¢\u0006\u0002\u0010=\u001aA\u0010>\u001a\u00020\u00062\b\u0010?\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010@\u001a\u00020A2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0003b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¢\u0006\u0002\u0010B\u001aM\u0010C\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\b\b\u0002\u0010D\u001a\u00020'2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nH\u0003b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¢\u0006\u0004\bE\u0010F\u001aw\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010 2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0003b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¢\u0006\u0002\u0010P\u001aG\u0010Q\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00192\u0006\u0010R\u001a\u00020'2\u0006\u0010S\u001a\u00020'2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0003b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¢\u0006\u0004\bT\u0010U\u001aR\u0010V\u001a\u00020\u00062\u0006\u0010R\u001a\u00020'2\u0006\u0010W\u001a\u00020'2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0011\u0010X\u001a\r\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\b\fH\u0003b\u0002\b\fb\f\b[\u0012\b\b\\\u0012\u0004\b\b(]¢\u0006\u0004\bY\u0010Z\u001aI\u0010^\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010_\u001a\u000e\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020\u00060\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0007b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¢\u0006\u0002\u0010a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007²\u0006\n\u0010b\u001a\u00020cX\u008a\u0084\u0002²\u0006\u0010\u0010d\u001a\b\u0012\u0004\u0012\u00020`0\u001fX\u008a\u0084\u0002²\u0006\f\u0010e\u001a\u0004\u0018\u00010IX\u008a\u008e\u0002²\u0006\f\u0010f\u001a\u0004\u0018\u00010IX\u008a\u008e\u0002²\u0006\n\u0010g\u001a\u000201X\u008a\u008e\u0002²\u0006\n\u0010h\u001a\u000201X\u008a\u008e\u0002²\u0006\n\u0010i\u001a\u000201X\u008a\u008e\u0002²\u0006\n\u0010j\u001a\u000201X\u008a\u008e\u0002²\u0006\n\u0010k\u001a\u000201X\u008a\u008e\u0002²\u0006\n\u0010l\u001a\u00020mX\u008a\u008e\u0002²\u0006\f\u0010n\u001a\u0004\u0018\u00010\u001cX\u008a\u008e\u0002²\u0006\n\u0010o\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\n\u0010%\u001a\u00020 X\u008a\u008e\u0002²\u0006\n\u0010p\u001a\u000201X\u008a\u008e\u0002²\u0006\n\u0010b\u001a\u00020cX\u008a\u0084\u0002²\u0006\u0010\u0010d\u001a\b\u0012\u0004\u0012\u00020`0\u001fX\u008a\u0084\u0002²\u0006\n\u0010q\u001a\u00020rX\u008a\u008e\u0002²\u0006\n\u0010s\u001a\u00020 X\u008a\u008e\u0002²\u0006\n\u0010t\u001a\u00020 X\u008a\u008e\u0002²\u0006\n\u0010u\u001a\u00020 X\u008a\u008e\u0002²\u0006\n\u0010v\u001a\u000201X\u008a\u008e\u0002²\u0006\f\u0010p\u001a\u0004\u0018\u00010\u0019X\u008a\u008e\u0002²\u0006\n\u0010g\u001a\u000201X\u008a\u008e\u0002²\u0006\n\u0010w\u001a\u000201X\u008a\u008e\u0002²\u0006\u0010\u0010d\u001a\b\u0012\u0004\u0012\u00020`0\u001fX\u008a\u0084\u0002²\u0006\n\u0010x\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\n\u0010y\u001a\u000201X\u008a\u008e\u0002²\u0006\n\u0010?\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\n\u0010z\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\n\u0010w\u001a\u000201X\u008a\u008e\u0002"}, d2 = {"CartCardShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "StepPillShape", "StepKeyShape", "ToolShape", "CartSheet", "", "app", "Luz/FonRo/pos/FonRoApp;", "onClose", "Lkotlin/Function0;", "(Luz/FonRo/pos/FonRoApp;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "ReceiptDiscountSheet", "current", "Luz/FonRo/pos/ui/sale/CartDiscount;", "onApply", "Lkotlin/Function1;", "onDismiss", "(Luz/FonRo/pos/ui/sale/CartDiscount;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "PaySheet", "tid", "", "onBack", "onDone", "Luz/FonRo/pos/ui/sale/SaleDone;", "(Luz/FonRo/pos/FonRoApp;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "quickCashSuggestions", "", "", "total", "CartMiniStat", "Landroidx/compose/foundation/layout/RowScope;", "label", "value", "tint", "Landroidx/compose/ui/graphics/Color;", "CartMiniStat-Bx497Mc", "(Landroidx/compose/foundation/layout/RowScope;Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/runtime/Composer;I)V", "CartSoftButton", "text", "onClick", "CartSoftButton-FNF3uiM", "(Landroidx/compose/foundation/layout/RowScope;Ljava/lang/String;JLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ClearButton", "enabled", "", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "PayTypeTile", "icon", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "(Landroidx/compose/foundation/layout/RowScope;Ljava/lang/String;Ljava/lang/String;ZZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "QuickCashButton", "(Landroidx/compose/foundation/layout/RowScope;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "PayHint", "negative", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/runtime/Composer;I)V", "PayNote", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "CustomerRowButton", "name", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "CartLineRow", "valueColor", "CartLineRow-cf5BqRc", "(Ljava/lang/String;Ljava/lang/String;JLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "CartItemCard", "line", "Luz/FonRo/pos/ui/sale/CartLine;", "profit", "onMinus", "onPlus", "onQty", "onDiscount", "onDelete", "(Luz/FonRo/pos/ui/sale/CartLine;Ljava/lang/Double;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "StepButton", "background", "ink", "StepButton-RIQooxk", "(Ljava/lang/String;JJLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ToolButton", "border", FirebaseAnalytics.Param.CONTENT, "ToolButton-Klgx-Pg", "(JJLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/ComposableInferredTarget;", "scheme", "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]", "CustomerPickerSheet", "onPick", "Luz/FonRo/pos/data/model/Customer;", "(Luz/FonRo/pos/FonRoApp;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "cart", "Luz/FonRo/pos/ui/sale/CartState;", "customers", "qtyFor", "discountFor", "showCustomerPicker", "showReceiptDiscount", "showHeld", "showPay", "confirmClear", "heldTick", "", "done", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "pad", "payType", "Luz/FonRo/pos/data/model/PayType;", "received", "cashPart", "debtPaid", "debtByCard", "busy", SearchIntents.EXTRA_QUERY, "adding", HintConstants.AUTOFILL_HINT_PHONE}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class CartSheetKt {
    private static final RoundedCornerShape CartCardShape = RoundedCornerShapeKt.m1342RoundedCornerShape0680j_4(Dp.m6989constructorimpl(16.0f));
    private static final RoundedCornerShape StepPillShape = RoundedCornerShapeKt.m1342RoundedCornerShape0680j_4(Dp.m6989constructorimpl(12.0f));
    private static final RoundedCornerShape StepKeyShape = RoundedCornerShapeKt.m1342RoundedCornerShape0680j_4(Dp.m6989constructorimpl(9.0f));
    private static final RoundedCornerShape ToolShape = RoundedCornerShapeKt.m1342RoundedCornerShape0680j_4(Dp.m6989constructorimpl(11.0f));

    /* compiled from: CartSheet.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes7.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PayType.values().length];
            try {
                iArr[PayType.CASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PayType.CARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PayType.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PayType.DEBT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CartItemCard$lambda$1(CartLine cartLine, Double d, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, int i, Composer composer, int i2) {
        CartItemCard(cartLine, d, function0, function02, function03, function04, function05, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CartLineRow_cf5BqRc$lambda$1(String str, String str2, long j, Function0 function0, int i, int i2, Composer composer, int i3) {
        m10122CartLineRowcf5BqRc(str, str2, j, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CartMiniStat_Bx497Mc$lambda$1(RowScope rowScope, String str, String str2, long j, int i, Composer composer, int i2) {
        m10123CartMiniStatBx497Mc(rowScope, str, str2, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CartSheet$lambda$34(FonRoApp FonRoApp, Function0 function0, int i, Composer composer, int i2) {
        CartSheet(FonRoApp, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CartSheet$lambda$37(FonRoApp FonRoApp, Function0 function0, int i, Composer composer, int i2) {
        CartSheet(FonRoApp, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CartSheet$lambda$50(FonRoApp FonRoApp, Function0 function0, int i, Composer composer, int i2) {
        CartSheet(FonRoApp, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CartSoftButton_FNF3uiM$lambda$1(RowScope rowScope, String str, long j, Function0 function0, int i, Composer composer, int i2) {
        m10124CartSoftButtonFNF3uiM(rowScope, str, j, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClearButton$lambda$1(RowScope rowScope, boolean z, Function0 function0, int i, Composer composer, int i2) {
        ClearButton(rowScope, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CustomerPickerSheet$lambda$18(FonRoApp FonRoApp, Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        CustomerPickerSheet(FonRoApp, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CustomerRowButton$lambda$1(String str, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        CustomerRowButton(str, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PayHint$lambda$1(String str, String str2, boolean z, int i, Composer composer, int i2) {
        PayHint(str, str2, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PayNote$lambda$0(String str, int i, Composer composer, int i2) {
        PayNote(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PaySheet$lambda$32(FonRoApp FonRoApp, String str, Function0 function0, Function0 function02, Function1 function1, int i, Composer composer, int i2) {
        PaySheet(FonRoApp, str, function0, function02, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PayTypeTile$lambda$1(RowScope rowScope, String str, String str2, boolean z, boolean z2, Function0 function0, int i, Composer composer, int i2) {
        PayTypeTile(rowScope, str, str2, z, z2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit QuickCashButton$lambda$1(RowScope rowScope, String str, Function0 function0, int i, Composer composer, int i2) {
        QuickCashButton(rowScope, str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReceiptDiscountSheet$lambda$13(CartDiscount cartDiscount, Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        ReceiptDiscountSheet(cartDiscount, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit StepButton_RIQooxk$lambda$1(String str, long j, long j2, Function0 function0, int i, Composer composer, int i2) {
        m10125StepButtonRIQooxk(str, j, j2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ToolButton_Klgx_Pg$lambda$1(long j, long j2, Function0 function0, Function2 function2, int i, Composer composer, int i2) {
        m10126ToolButtonKlgxPg(j, j2, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void CartSheet(final FonRoApp app, Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        final FonRoApp FonRoApp;
        Composer composer2;
        Object obj;
        MutableState mutableState;
        int i3;
        MutableState mutableState2;
        int i4;
        String str;
        int i5;
        final MutableState mutableState3;
        final MutableState mutableState4;
        Object mutableStateOf$default;
        final Function0<Unit> onClose = function0;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Composer startRestartGroup = composer.startRestartGroup(-1829660571);
        ComposerKt.sourceInformation(startRestartGroup, "C(CartSheet)108@4458L16,109@4511L16,113@4648L44,114@4716L44,115@4791L34,116@4857L34,117@4912L34,118@4966L34,119@5025L34,122@5205L30,123@5256L44,125@5318L44,137@5896L41,186@7447L472,198@7926L5990,182@7329L6587:CartSheet.kt#1sewlp");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onClose) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            FonRoApp = app;
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1829660571, i2, -1, "uz.FonRo.pos.ui.sale.CartSheet (CartSheet.kt:106)");
            }
            final Repo repo = app.getRepo();
            final State collectAsState = SnapshotStateKt.collectAsState(CartStore.INSTANCE.getState(), null, startRestartGroup, 0, 1);
            State collectAsState2 = SnapshotStateKt.collectAsState(repo.getCustomers(), null, startRestartGroup, 0, 1);
            final CartTotals cartTotals = CartSheet$lambda$0(collectAsState).totals();
            Iterator<T> it = CartSheet$lambda$1(collectAsState2).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((Customer) obj).getId() == CartSheet$lambda$0(collectAsState).getCustomerId()) {
                        break;
                    }
                }
            }
            final Customer customer = (Customer) obj;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1662174735, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState5 = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1662172559, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState6 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1662170169, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState7 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1662168057, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(mutableStateOf$default);
                rememberedValue4 = mutableStateOf$default;
            }
            final MutableState mutableState8 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1662166297, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState5;
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            } else {
                mutableState = mutableState5;
            }
            MutableState mutableState9 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1662164569, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                i3 = i2;
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            } else {
                i3 = i2;
            }
            final MutableState mutableState10 = (MutableState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1662162681, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                mutableState2 = mutableState9;
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            } else {
                mutableState2 = mutableState9;
            }
            final MutableState mutableState11 = (MutableState) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1662156925, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            final MutableState mutableState12 = (MutableState) rememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int CartSheet$lambda$25 = CartSheet$lambda$25(mutableState12);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1662155279, "CC(remember):CartSheet.kt#9igjgp");
            boolean changed = startRestartGroup.changed(CartSheet$lambda$25);
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                rememberedValue9 = Integer.valueOf(HeldCarts.INSTANCE.count(repo));
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            int intValue = ((Number) rememberedValue9).intValue();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1662153295, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                i4 = intValue;
                rememberedValue10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            } else {
                i4 = intValue;
            }
            final MutableState mutableState13 = (MutableState) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1662134802, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                rememberedValue11 = app.getSales().newTransactionId();
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            String str2 = (String) rememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final boolean can = repo.can(Perm.VIEW_PROFIT);
            Iterator<T> it2 = CartSheet$lambda$0(collectAsState).getItems().iterator();
            double d = AudioStats.AUDIO_AMPLITUDE_NONE;
            while (it2.hasNext()) {
                d += ((CartLine) it2.next()).getQty();
            }
            Iterator<T> it3 = CartSheet$lambda$0(collectAsState).getItems().iterator();
            double d2 = AudioStats.AUDIO_AMPLITUDE_NONE;
            while (it3.hasNext()) {
                d2 += CartSheet$profitOf(repo, (CartLine) it3.next());
            }
            final double max = Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, d2 - cartTotals.getDiscount());
            SaleDone CartSheet$lambda$29 = CartSheet$lambda$29(mutableState13);
            if (CartSheet$lambda$29 != null) {
                startRestartGroup.startReplaceGroup(14458760);
                ComposerKt.sourceInformation(startRestartGroup, "163@6943L54");
                SaleSubmitKt.DoneSheet(app, CartSheet$lambda$29, onClose, startRestartGroup, FonRoApp.$stable | (i3 & 14) | (SaleDone.$stable << 3) | ((i3 << 3) & 896));
                startRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return CartSheetKt.CartSheet$lambda$34(FonRoApp.this, onClose, i, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            startRestartGroup.startReplaceGroup(14540445);
            startRestartGroup.endReplaceGroup();
            if (CartSheet$lambda$19(mutableState10)) {
                startRestartGroup.startReplaceGroup(14602538);
                ComposerKt.sourceInformation(startRestartGroup, "173@7168L19,175@7241L13,170@7084L180");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1662094120, "CC(remember):CartSheet.kt#9igjgp");
                Object rememberedValue12 = startRestartGroup.rememberedValue();
                if (rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue12 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CartSheet$lambda$35$0;
                            CartSheet$lambda$35$0 = CartSheetKt.CartSheet$lambda$35$0(MutableState.this);
                            return CartSheet$lambda$35$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue12);
                }
                Function0 function02 = (Function0) rememberedValue12;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1662091790, "CC(remember):CartSheet.kt#9igjgp");
                Object rememberedValue13 = startRestartGroup.rememberedValue();
                if (rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue13 = new Function1() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda31
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit CartSheet$lambda$36$0;
                            CartSheet$lambda$36$0 = CartSheetKt.CartSheet$lambda$36$0(MutableState.this, (SaleDone) obj2);
                            return CartSheet$lambda$36$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue13);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                PaySheet(app, str2, function02, onClose, (Function1) rememberedValue13, startRestartGroup, FonRoApp.$stable | 25008 | (i3 & 14) | ((i3 << 6) & 7168));
                startRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
                if (endRestartGroup2 != null) {
                    endRestartGroup2.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda32
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return CartSheetKt.CartSheet$lambda$37(FonRoApp.this, onClose, i, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            startRestartGroup.startReplaceGroup(14805309);
            startRestartGroup.endReplaceGroup();
            String tx = LangKt.tx("Корзина", new Object[0]);
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1320818152, true, new Function3() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return CartSheetKt.CartSheet$lambda$38(Repo.this, cartTotals, collectAsState, mutableState11, mutableState10, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, startRestartGroup, 54);
            final int i6 = i4;
            final MutableState mutableState14 = mutableState;
            final MutableState mutableState15 = mutableState2;
            final double d3 = d;
            ComposableLambda rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-995867263, true, new Function3() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return CartSheetKt.CartSheet$lambda$39(i6, cartTotals, can, max, d3, collectAsState, repo, onClose, mutableState12, mutableState15, mutableState14, mutableState6, customer, mutableState7, mutableState8, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, startRestartGroup, 54);
            int i7 = i3 & 112;
            onClose = function0;
            SheetsKt.OxCardSheet(tx, onClose, null, true, false, false, rememberComposableLambda, rememberComposableLambda2, startRestartGroup, 14158848 | i7, 52);
            Composer composer3 = startRestartGroup;
            final CartLine CartSheet$lambda$4 = CartSheet$lambda$4(mutableState14);
            if (CartSheet$lambda$4 != null) {
                composer3.startReplaceGroup(21456793);
                ComposerKt.sourceInformation(composer3, "");
                Product productById = repo.productById(CartSheet$lambda$4.getProductId());
                final double CartSheet$availableFor = CartSheet$availableFor(repo, CartSheet$lambda$4);
                if (productById == null || !Units.INSTANCE.isMeasurable(productById.getUnit())) {
                    str = "CC(remember):CartSheet.kt#9igjgp";
                    composer3.startReplaceGroup(1580058444);
                    ComposerKt.sourceInformation(composer3, "353@14598L63,354@14691L17,350@14466L318");
                    String tx2 = LangKt.tx("%s — количество", CartSheet$lambda$4.getName());
                    double qty = CartSheet$lambda$4.getQty();
                    ComposerKt.sourceInformationMarkerStart(composer3, -1195951969, str);
                    boolean changedInstance = composer3.changedInstance(CartSheet$lambda$4) | composer3.changed(CartSheet$availableFor);
                    Object rememberedValue14 = composer3.rememberedValue();
                    if (changedInstance || rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue14 = new Function1() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda38
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                Unit CartSheet$lambda$40$2$0;
                                CartSheet$lambda$40$2$0 = CartSheetKt.CartSheet$lambda$40$2$0(CartLine.this, CartSheet$availableFor, ((Double) obj2).doubleValue());
                                return CartSheet$lambda$40$2$0;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue14);
                    }
                    Function1 function1 = (Function1) rememberedValue14;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1195949039, str);
                    Object rememberedValue15 = composer3.rememberedValue();
                    if (rememberedValue15 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue15 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda39
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit CartSheet$lambda$40$3$0;
                                CartSheet$lambda$40$3$0 = CartSheetKt.CartSheet$lambda$40$3$0(MutableState.this);
                                return CartSheet$lambda$40$3$0;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue15);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    NumpadKt.NumpadSheet(tx2, qty, function1, (Function0) rememberedValue15, Units.INSTANCE.isMeasurable(CartSheet$lambda$4.getUnit()), composer3, 3072, 0);
                    composer3.endReplaceGroup();
                } else {
                    composer3.startReplaceGroup(1579748785);
                    ComposerKt.sourceInformation(composer3, "346@14312L63,347@14405L17,342@14155L281");
                    double qty2 = CartSheet$lambda$4.getQty();
                    String currency = repo.currency();
                    str = "CC(remember):CartSheet.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(composer3, -1195961121, str);
                    boolean changedInstance2 = composer3.changedInstance(CartSheet$lambda$4) | composer3.changed(CartSheet$availableFor);
                    Object rememberedValue16 = composer3.rememberedValue();
                    if (changedInstance2 || rememberedValue16 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue16 = new Function1() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda36
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                Unit CartSheet$lambda$40$0$0;
                                CartSheet$lambda$40$0$0 = CartSheetKt.CartSheet$lambda$40$0$0(CartLine.this, CartSheet$availableFor, ((Double) obj2).doubleValue());
                                return CartSheet$lambda$40$0$0;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue16);
                    }
                    Function1 function12 = (Function1) rememberedValue16;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1195958191, str);
                    Object rememberedValue17 = composer3.rememberedValue();
                    if (rememberedValue17 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue17 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda37
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit CartSheet$lambda$40$1$0;
                                CartSheet$lambda$40$1$0 = CartSheetKt.CartSheet$lambda$40$1$0(MutableState.this);
                                return CartSheet$lambda$40$1$0;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue17);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    NumpadKt.MeasurePadSheet(productById, qty2, currency, function12, (Function0) rememberedValue17, composer3, Product.$stable | 24576);
                    composer3.endReplaceGroup();
                }
                Unit unit = Unit.INSTANCE;
                composer3.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            } else {
                composer3.startReplaceGroup(21456792);
                composer3.endReplaceGroup();
                str = "CC(remember):CartSheet.kt#9igjgp";
            }
            final CartLine CartSheet$lambda$7 = CartSheet$lambda$7(mutableState6);
            if (CartSheet$lambda$7 != null) {
                composer3.startReplaceGroup(22287717);
                ComposerKt.sourceInformation(composer3, "*364@14964L71,365@15061L22,361@14841L252");
                String tx3 = LangKt.tx("Скидка на позицию, сумма", new Object[0]);
                double discount = CartSheet$lambda$7.getDiscount();
                ComposerKt.sourceInformationMarkerStart(composer3, -978394704, str);
                boolean changedInstance3 = composer3.changedInstance(CartSheet$lambda$7);
                Object rememberedValue18 = composer3.rememberedValue();
                if (changedInstance3 || rememberedValue18 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue18 = new Function1() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit CartSheet$lambda$41$0$0;
                            CartSheet$lambda$41$0$0 = CartSheetKt.CartSheet$lambda$41$0$0(CartLine.this, ((Double) obj2).doubleValue());
                            return CartSheet$lambda$41$0$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue18);
                }
                Function1 function13 = (Function1) rememberedValue18;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -978391649, str);
                Object rememberedValue19 = composer3.rememberedValue();
                if (rememberedValue19 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue19 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CartSheet$lambda$41$1$0;
                            CartSheet$lambda$41$1$0 = CartSheetKt.CartSheet$lambda$41$1$0(MutableState.this);
                            return CartSheet$lambda$41$1$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue19);
                }
                Function0 function03 = (Function0) rememberedValue19;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                i5 = 0;
                NumpadKt.NumpadSheet(tx3, discount, function13, function03, false, composer3, 3072, 16);
                Unit unit3 = Unit.INSTANCE;
                composer3.endReplaceGroup();
                Unit unit4 = Unit.INSTANCE;
            } else {
                composer3.startReplaceGroup(22287716);
                composer3.endReplaceGroup();
                i5 = 0;
            }
            if (CartSheet$lambda$13(mutableState8)) {
                composer3.startReplaceGroup(22595764);
                ComposerKt.sourceInformation(composer3, "372@15221L101,376@15348L31,370@15140L249");
                CartDiscount discount2 = CartSheet$lambda$0(collectAsState).getDiscount();
                ComposerKt.sourceInformationMarkerStart(composer3, -1661836342, str);
                Object rememberedValue20 = composer3.rememberedValue();
                if (rememberedValue20 == Composer.INSTANCE.getEmpty()) {
                    mutableState4 = mutableState8;
                    rememberedValue20 = new Function1() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit CartSheet$lambda$42$0;
                            CartSheet$lambda$42$0 = CartSheetKt.CartSheet$lambda$42$0(MutableState.this, (CartDiscount) obj2);
                            return CartSheet$lambda$42$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue20);
                } else {
                    mutableState4 = mutableState8;
                }
                Function1 function14 = (Function1) rememberedValue20;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1661832348, str);
                Object rememberedValue21 = composer3.rememberedValue();
                if (rememberedValue21 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue21 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CartSheet$lambda$43$0;
                            CartSheet$lambda$43$0 = CartSheetKt.CartSheet$lambda$43$0(MutableState.this);
                            return CartSheet$lambda$43$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue21);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ReceiptDiscountSheet(discount2, function14, (Function0) rememberedValue21, composer3, CartDiscount.$stable | 432);
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(22850429);
                composer3.endReplaceGroup();
            }
            if (CartSheet$lambda$10(mutableState7)) {
                composer3.startReplaceGroup(22888373);
                ComposerKt.sourceInformation(composer3, "383@15500L117,387@15643L30,381@15435L248");
                ComposerKt.sourceInformationMarkerStart(composer3, -1661827398, str);
                Object rememberedValue22 = composer3.rememberedValue();
                if (rememberedValue22 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue22 = new Function1() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda23
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit CartSheet$lambda$44$0;
                            CartSheet$lambda$44$0 = CartSheetKt.CartSheet$lambda$44$0(MutableState.this, (Customer) obj2);
                            return CartSheet$lambda$44$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue22);
                }
                Function1 function15 = (Function1) rememberedValue22;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1661822909, str);
                Object rememberedValue23 = composer3.rememberedValue();
                if (rememberedValue23 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue23 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CartSheet$lambda$45$0;
                            CartSheet$lambda$45$0 = CartSheetKt.CartSheet$lambda$45$0(MutableState.this);
                            return CartSheet$lambda$45$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue23);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                FonRoApp = app;
                CustomerPickerSheet(FonRoApp, function15, (Function0) rememberedValue23, composer3, FonRoApp.$stable | 432 | (i3 & 14));
                composer3.endReplaceGroup();
            } else {
                FonRoApp = app;
                composer3.startReplaceGroup(23142077);
                composer3.endReplaceGroup();
            }
            if (CartSheet$lambda$16(mutableState2)) {
                composer3.startReplaceGroup(23170132);
                ComposerKt.sourceInformation(composer3, "394@15782L75,398@15883L75,392@15719L249");
                ComposerKt.sourceInformationMarkerStart(composer3, -1661818416, str);
                Object rememberedValue24 = composer3.rememberedValue();
                if (rememberedValue24 == Composer.INSTANCE.getEmpty()) {
                    mutableState3 = mutableState2;
                    rememberedValue24 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda25
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CartSheet$lambda$46$0;
                            CartSheet$lambda$46$0 = CartSheetKt.CartSheet$lambda$46$0(MutableState.this, mutableState12);
                            return CartSheet$lambda$46$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue24);
                } else {
                    mutableState3 = mutableState2;
                }
                Function0 function04 = (Function0) rememberedValue24;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1661815184, str);
                Object rememberedValue25 = composer3.rememberedValue();
                if (rememberedValue25 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue25 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda26
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CartSheet$lambda$47$0;
                            CartSheet$lambda$47$0 = CartSheetKt.CartSheet$lambda$47$0(MutableState.this, mutableState12);
                            return CartSheet$lambda$47$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue25);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                HeldCartsKt.HeldCartsSheet(FonRoApp, function04, (Function0) rememberedValue25, composer3, FonRoApp.$stable | 432 | (i3 & 14));
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(23424797);
                composer3.endReplaceGroup();
            }
            if (CartSheet$lambda$22(mutableState11)) {
                composer3.startReplaceGroup(23464446);
                ComposerKt.sourceInformation(composer3, "412@16368L75,416@16469L24,408@16169L334");
                String tx4 = LangKt.tx("Очистить чек?", new Object[i5]);
                String tx5 = LangKt.tx("Все позиции, скидка и клиент будут сброшены.", new Object[i5]);
                String tx6 = LangKt.tx("Да, очистить", new Object[i5]);
                ComposerKt.sourceInformationMarkerStart(composer3, -1661799664, str);
                int i8 = i7 == 32 ? 1 : i5;
                Object rememberedValue26 = composer3.rememberedValue();
                if (i8 != 0 || rememberedValue26 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue26 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CartSheet$lambda$48$0;
                            CartSheet$lambda$48$0 = CartSheetKt.CartSheet$lambda$48$0(Function0.this);
                            return CartSheet$lambda$48$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue26);
                }
                Function0 function05 = (Function0) rememberedValue26;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1661796483, str);
                Object rememberedValue27 = composer3.rememberedValue();
                if (rememberedValue27 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue27 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda28
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CartSheet$lambda$49$0;
                            CartSheet$lambda$49$0 = CartSheetKt.CartSheet$lambda$49$0(MutableState.this);
                            return CartSheet$lambda$49$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue27);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                SheetsKt.OxConfirmSheet(tx4, tx5, tx6, null, function05, (Function0) rememberedValue27, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 8);
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(23955517);
                composer3.endReplaceGroup();
            }
            composer2 = composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                composer2 = composer3;
            }
        }
        ScopeUpdateScope endRestartGroup3 = composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            endRestartGroup3.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return CartSheetKt.CartSheet$lambda$50(FonRoApp.this, onClose, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final CartLine CartSheet$lambda$4(MutableState<CartLine> mutableState) {
        return mutableState.getValue();
    }

    private static final CartLine CartSheet$lambda$7(MutableState<CartLine> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean CartSheet$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CartSheet$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean CartSheet$lambda$13(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CartSheet$lambda$14(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean CartSheet$lambda$16(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CartSheet$lambda$17(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean CartSheet$lambda$19(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CartSheet$lambda$20(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean CartSheet$lambda$22(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CartSheet$lambda$23(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final int CartSheet$lambda$25(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void CartSheet$lambda$26(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final SaleDone CartSheet$lambda$29(MutableState<SaleDone> mutableState) {
        return mutableState.getValue();
    }

    private static final double CartSheet$profitOf(Repo repo, CartLine cartLine) {
        Product productById = repo.productById(cartLine.getProductId());
        return (Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, cartLine.getPrice() - (productById != null ? productById.getPurchasePrice() : 0.0d)) * cartLine.getQty()) - cartLine.getDiscount();
    }

    private static final double CartSheet$availableFor(Repo repo, CartLine cartLine) {
        Product productById = repo.productById(cartLine.getProductId());
        return Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, productById != null ? productById.getQuantity() : cartLine.getQty());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$35$0(MutableState mutableState) {
        CartSheet$lambda$20(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$36$0(MutableState mutableState, SaleDone it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CartSheet$lambda$38(Repo repo, CartTotals cartTotals, State state, final MutableState mutableState, final MutableState mutableState2, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        String str;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C187@7508L23,187@7461L70,191@7699L18,188@7544L365:CartSheet.kt#1sewlp");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1320818152, i2, -1, "uz.FonRo.pos.ui.sale.CartSheet.<anonymous> (CartSheet.kt:187)");
            }
            boolean z = !CartSheet$lambda$0(state).getItems().isEmpty();
            ComposerKt.sourceInformationMarkerStart(composer, 2004077519, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda88
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CartSheet$lambda$38$0$0;
                        CartSheet$lambda$38$0$0 = CartSheetKt.CartSheet$lambda$38$0$0(MutableState.this);
                        return CartSheet$lambda$38$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ClearButton(OxCardSheet, z, (Function0) rememberedValue, composer, (i2 & 14) | 384);
            if (CartSheet$lambda$0(state).getItems().isEmpty()) {
                str = LangKt.tx("Оплата →", new Object[0]);
            } else {
                str = LangKt.tx("Оплатить ·", new Object[0]) + " " + repo.money(Double.valueOf(cartTotals.getTotal()));
            }
            ComposerKt.sourceInformationMarkerStart(composer, 2004083626, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CartSheet$lambda$38$1$0;
                        CartSheet$lambda$38$1$0 = CartSheetKt.CartSheet$lambda$38$1$0(MutableState.this);
                        return CartSheet$lambda$38$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(str, (Function0) rememberedValue2, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 3.4f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, !CartSheet$lambda$0(state).getItems().isEmpty(), false, null, composer, 27696, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$38$0$0(MutableState mutableState) {
        CartSheet$lambda$23(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$38$1$0(MutableState mutableState) {
        CartSheet$lambda$20(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CartSheet$lambda$39(int i, final CartTotals cartTotals, boolean z, double d, double d2, State state, final Repo repo, final Function0 function0, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, Customer customer, final MutableState mutableState5, final MutableState mutableState6, ColumnScope OxCardSheet, Composer composer, int i2) {
        RowScopeInstance rowScopeInstance;
        String str;
        String str2;
        String str3;
        int i3;
        Double d3;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C201@8048L497,233@9442L11,235@9509L21,235@9463L4447:CartSheet.kt#1sewlp");
        if (!composer.shouldExecute((i2 & 17) != 16, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-995867263, i2, -1, "uz.FonRo.pos.ui.sale.CartSheet.<anonymous> (CartSheet.kt:201)");
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
            String str4 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
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
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -603123018, "C202@8143L60,205@8382L87,206@8482L53:CartSheet.kt#1sewlp");
            m10123CartMiniStatBx497Mc(rowScopeInstance2, LangKt.tx("Сумма", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(cartTotals.getTotal())), Ox.INSTANCE.m10193getCyanDeep0d7_KjU(), composer, 6);
            m10123CartMiniStatBx497Mc(rowScopeInstance2, LangKt.tx("Прибыль", new Object[0]), z ? Fmt.INSTANCE.nf(Double.valueOf(d)) : "•••", Ox.INSTANCE.m10202getGreenDeep0d7_KjU(), composer, 6);
            m10123CartMiniStatBx497Mc(rowScopeInstance2, LangKt.tx("Штук", new Object[0]), Fmt.INSTANCE.qf(Double.valueOf(d2)), Ox.INSTANCE.m10215getOrangeInk0d7_KjU(), composer, 6);
            Composer composer2 = composer;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (!CartSheet$lambda$0(state).getItems().isEmpty() || i > 0) {
                composer2.startReplaceGroup(1753144098);
                ComposerKt.sourceInformation(composer2, "210@8615L11,211@8639L783");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer2, 6);
                Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), composer2, 6);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, fillMaxWidth$default2);
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
                Updater.m3815setimpl(m3808constructorimpl2, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3815setimpl(m3808constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3808constructorimpl2.getInserting() || !Intrinsics.areEqual(m3808constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m3808constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m3808constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3815setimpl(m3808constructorimpl2, materializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -1063830299, "C:CartSheet.kt#1sewlp");
                if (!CartSheet$lambda$0(state).getItems().isEmpty()) {
                    composer2.startReplaceGroup(-1063811111);
                    ComposerKt.sourceInformation(composer2, "216@8935L153,213@8789L321");
                    String tx = LangKt.tx("Отложить чек", new Object[0]);
                    long m10215getOrangeInk0d7_KjU = Ox.INSTANCE.m10215getOrangeInk0d7_KjU();
                    ComposerKt.sourceInformationMarkerStart(composer2, 519878009, "CC(remember):CartSheet.kt#9igjgp");
                    boolean changedInstance = composer2.changedInstance(repo) | composer2.changed(function0);
                    Object rememberedValue = composer2.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda49
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit CartSheet$lambda$39$1$0$0;
                                CartSheet$lambda$39$1$0$0 = CartSheetKt.CartSheet$lambda$39$1$0$0(Repo.this, function0, mutableState);
                                return CartSheet$lambda$39$1$0$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    Function0 function02 = (Function0) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    str2 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                    rowScopeInstance = rowScopeInstance3;
                    i3 = 693286680;
                    str = "CC(remember):CartSheet.kt#9igjgp";
                    str3 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                    m10124CartSoftButtonFNF3uiM(rowScopeInstance, tx, m10215getOrangeInk0d7_KjU, function02, composer2, 6);
                    composer2.endReplaceGroup();
                } else {
                    rowScopeInstance = rowScopeInstance3;
                    str = "CC(remember):CartSheet.kt#9igjgp";
                    str2 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                    str3 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                    i3 = 693286680;
                    composer2.startReplaceGroup(-1063464190);
                    composer2.endReplaceGroup();
                }
                if (i > 0) {
                    composer2.startReplaceGroup(-1063420914);
                    ComposerKt.sourceInformation(composer2, "227@9349L19,224@9186L204");
                    String str5 = LangKt.tx("Отложенные", new Object[0]) + " · " + i;
                    long m10193getCyanDeep0d7_KjU = Ox.INSTANCE.m10193getCyanDeep0d7_KjU();
                    ComposerKt.sourceInformationMarkerStart(composer2, 519891123, str);
                    Object rememberedValue2 = composer2.rememberedValue();
                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda50
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit CartSheet$lambda$39$1$1$0;
                                CartSheet$lambda$39$1$1$0 = CartSheetKt.CartSheet$lambda$39$1$1$0(MutableState.this);
                                return CartSheet$lambda$39$1$1$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    m10124CartSoftButtonFNF3uiM(rowScopeInstance, str5, m10193getCyanDeep0d7_KjU, (Function0) rememberedValue2, composer2, 3078);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-1063186430);
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
                composer2.startReplaceGroup(1753942689);
                composer2.endReplaceGroup();
                str = "CC(remember):CartSheet.kt#9igjgp";
                str2 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
                str3 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                i3 = 693286680;
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer2, 6);
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composer2, 0, 1), false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str3);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, verticalScroll$default);
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
            Updater.m3815setimpl(m3808constructorimpl3, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -619119540, "C332@13890L10:CartSheet.kt#1sewlp");
            if (CartSheet$lambda$0(state).getItems().isEmpty()) {
                composer2.startReplaceGroup(-619226832);
                ComposerKt.sourceInformation(composer2, "238@9592L27");
                BasicsKt.OxEmptyNote(LangKt.tx("Чек пуст", new Object[0]), null, composer2, 0, 2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-619170133);
                composer2.endReplaceGroup();
            }
            composer2.startReplaceGroup(1226954946);
            ComposerKt.sourceInformation(composer2, "*245@9853L215,249@10099L214,253@10343L17,254@10395L22,255@10450L563,242@9706L1325");
            Iterator it = CartSheet$lambda$0(state).getItems().iterator();
            final int i4 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final CartLine cartLine = (CartLine) next;
                Double valueOf = z ? Double.valueOf(CartSheet$profitOf(repo, cartLine)) : null;
                ComposerKt.sourceInformationMarkerStart(composer2, -2107458127, str);
                boolean changedInstance2 = composer2.changedInstance(repo) | composer2.changedInstance(cartLine);
                Object rememberedValue3 = composer2.rememberedValue();
                if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda51
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CartSheet$lambda$39$2$0$0$0;
                            CartSheet$lambda$39$2$0$0$0 = CartSheetKt.CartSheet$lambda$39$2$0$0$0(Repo.this, cartLine);
                            return CartSheet$lambda$39$2$0$0$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue3);
                }
                Function0 function03 = (Function0) rememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -2107450256, str);
                boolean changedInstance3 = composer2.changedInstance(repo) | composer2.changedInstance(cartLine);
                Object rememberedValue4 = composer2.rememberedValue();
                if (changedInstance3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda52
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CartSheet$lambda$39$2$0$1$0;
                            CartSheet$lambda$39$2$0$1$0 = CartSheetKt.CartSheet$lambda$39$2$0$1$0(Repo.this, cartLine);
                            return CartSheet$lambda$39$2$0$1$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue4);
                }
                Function0 function04 = (Function0) rememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -2107442645, str);
                boolean changedInstance4 = composer2.changedInstance(cartLine);
                Object rememberedValue5 = composer2.rememberedValue();
                if (changedInstance4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue5 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda53
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CartSheet$lambda$39$2$0$2$0;
                            CartSheet$lambda$39$2$0$2$0 = CartSheetKt.CartSheet$lambda$39$2$0$2$0(CartLine.this, mutableState3);
                            return CartSheet$lambda$39$2$0$2$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue5);
                }
                Function0 function05 = (Function0) rememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -2107440976, str);
                boolean changedInstance5 = composer2.changedInstance(cartLine);
                Iterator it2 = it;
                Object rememberedValue6 = composer2.rememberedValue();
                if (changedInstance5 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue6 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda54
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CartSheet$lambda$39$2$0$3$0;
                            CartSheet$lambda$39$2$0$3$0 = CartSheetKt.CartSheet$lambda$39$2$0$3$0(CartLine.this, mutableState4);
                            return CartSheet$lambda$39$2$0$3$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue6);
                }
                Function0 function06 = (Function0) rememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -2107438675, str);
                boolean changedInstance6 = composer2.changedInstance(cartLine) | composer2.changed(i4);
                Object rememberedValue7 = composer2.rememberedValue();
                if (changedInstance6) {
                    d3 = valueOf;
                } else {
                    d3 = valueOf;
                    if (rememberedValue7 != Composer.INSTANCE.getEmpty()) {
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Composer composer3 = composer2;
                        CartItemCard(cartLine, d3, function03, function04, function05, function06, (Function0) rememberedValue7, composer3, CartLine.$stable);
                        composer2 = composer3;
                        i4 = i5;
                        str4 = str4;
                        it = it2;
                    }
                }
                rememberedValue7 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda56
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CartSheet$lambda$39$2$0$4$0;
                        CartSheet$lambda$39$2$0$4$0 = CartSheetKt.CartSheet$lambda$39$2$0$4$0(CartLine.this, i4);
                        return CartSheet$lambda$39$2$0$4$0;
                    }
                };
                composer2.updateRememberedValue(rememberedValue7);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Composer composer32 = composer2;
                CartItemCard(cartLine, d3, function03, function04, function05, function06, (Function0) rememberedValue7, composer32, CartLine.$stable);
                composer2 = composer32;
                i4 = i5;
                str4 = str4;
                it = it2;
            }
            String str6 = str4;
            int i6 = i3;
            composer2.endReplaceGroup();
            if (!CartSheet$lambda$0(state).getItems().isEmpty()) {
                composer2.startReplaceGroup(-617640345);
                ComposerKt.sourceInformation(composer2, "271@11155L10,272@11182L1368,303@12568L11,306@12695L1167,306@12644L1218");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(5.0f), composer2, 6);
                Modifier fillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical m930spacedBy0680j_43 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer2, i6, str2);
                MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m930spacedBy0680j_43, centerVertically, composer2, 54);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str3);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, fillMaxWidth$default3);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str6);
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
                ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 897471584, "C280@11582L29,277@11422L211:CartSheet.kt#1sewlp");
                String fullName = customer != null ? customer.getFullName() : null;
                Modifier weight$default = RowScope.weight$default(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composer2, -1217971254, str);
                Object rememberedValue8 = composer2.rememberedValue();
                if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue8 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda57
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CartSheet$lambda$39$2$1$0$0;
                            CartSheet$lambda$39$2$1$0$0 = CartSheetKt.CartSheet$lambda$39$2$1$0$0(MutableState.this);
                            return CartSheet$lambda$39$2$1$0$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                CustomerRowButton(fullName, weight$default, (Function0) rememberedValue8, composer2, 384, 0);
                if (customer != null) {
                    composer2.startReplaceGroup(897715677);
                    ComposerKt.sourceInformation(composer2, "290@12066L28,290@12060L34,283@11702L808");
                    Modifier m569borderxT4_qwU = BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1082height3ABfNKs(SizeKt.m1101width3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(46.0f)), Dp.m6989constructorimpl(58.0f)), OxShape.INSTANCE.getField()), Ox.INSTANCE.m10217getPanel0d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getField());
                    ComposerKt.sourceInformationMarkerStart(composer2, -1217955767, str);
                    Object rememberedValue9 = composer2.rememberedValue();
                    if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue9 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda58
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit CartSheet$lambda$39$2$1$1$0;
                                CartSheet$lambda$39$2$1$1$0 = CartSheetKt.CartSheet$lambda$39$2$1$1$0();
                                return CartSheet$lambda$39$2$1$1$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue9);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier oxTap = ModifiersKt.oxTap(m569borderxT4_qwU, false, (Function0) rememberedValue9, composer2, 384, 1);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str3);
                    int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer2, oxTap);
                    Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str6);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor5);
                    } else {
                        composer2.useNode();
                    }
                    Composer m3808constructorimpl5 = Updater.m3808constructorimpl(composer2);
                    Updater.m3815setimpl(m3808constructorimpl5, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3815setimpl(m3808constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3808constructorimpl5.getInserting() || !Intrinsics.areEqual(m3808constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                        m3808constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                        m3808constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                    }
                    Updater.m3815setimpl(m3808constructorimpl5, materializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 657417577, "C293@12216L268:CartSheet.kt#1sewlp");
                    IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getClose(), LangKt.tx("Убрать клиента", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(17.0f)), Ox.INSTANCE.m10199getDim0d7_KjU(), composer2, 384, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(898538293);
                    composer2.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer2, 6);
                BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(13.0f), CartCardShape, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(739113807, true, new Function3() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda59
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit CartSheet$lambda$39$2$2;
                        CartSheet$lambda$39$2$2 = CartSheetKt.CartSheet$lambda$39$2$2(CartTotals.this, mutableState6, repo, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return CartSheet$lambda$39$2$2;
                    }
                }, composer2, 54), composer2, 1573296, 57);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-614961077);
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
    public static final Unit CartSheet$lambda$39$1$0$0(Repo repo, Function0 function0, MutableState mutableState) {
        HeldCarts.hold$default(HeldCarts.INSTANCE, repo, false, 2, null);
        CartSheet$lambda$26(mutableState, CartSheet$lambda$25(mutableState) + 1);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$39$1$1$0(MutableState mutableState) {
        CartSheet$lambda$17(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$39$2$0$0$0(Repo repo, CartLine cartLine) {
        Product productById = repo.productById(cartLine.getProductId());
        CartStore.INSTANCE.changeQty(cartLine.getProductId(), -(productById != null ? CartStore.INSTANCE.stepOf(productById) : 1.0d), CartSheet$availableFor(repo, cartLine));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$39$2$0$1$0(Repo repo, CartLine cartLine) {
        Product productById = repo.productById(cartLine.getProductId());
        CartStore.INSTANCE.changeQty(cartLine.getProductId(), productById != null ? CartStore.INSTANCE.stepOf(productById) : 1.0d, CartSheet$availableFor(repo, cartLine));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$39$2$0$2$0(CartLine cartLine, MutableState mutableState) {
        mutableState.setValue(cartLine);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$39$2$0$3$0(CartLine cartLine, MutableState mutableState) {
        mutableState.setValue(cartLine);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$39$2$0$4$0(final CartLine cartLine, final int i) {
        CartStore.INSTANCE.remove(cartLine.getProductId());
        Toaster.show$default(Toaster.INSTANCE, LangKt.tx("Удалено: %s", cartLine.getName()), null, null, LangKt.tx("Отменить", new Object[0]), new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit CartSheet$lambda$39$2$0$4$0$0;
                CartSheet$lambda$39$2$0$4$0$0 = CartSheetKt.CartSheet$lambda$39$2$0$4$0$0(i, cartLine);
                return CartSheet$lambda$39$2$0$4$0$0;
            }
        }, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$39$2$0$4$0$0(int i, CartLine cartLine) {
        CartStore.INSTANCE.insert(i, cartLine);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$39$2$1$0$0(MutableState mutableState) {
        CartSheet$lambda$11(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$39$2$1$1$0() {
        CartStore.INSTANCE.setCustomer(0L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$39$2$2(CartTotals cartTotals, final MutableState mutableState, Repo repo, ColumnScope OxSoftCard, Composer composer, int i) {
        String tx;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C307@12717L51,312@13050L30,308@12789L313,314@13123L10,315@13154L20,316@13195L11,317@13227L617:CartSheet.kt#1sewlp");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(739113807, i, -1, "uz.FonRo.pos.ui.sale.CartSheet.<anonymous>.<anonymous>.<anonymous> (CartSheet.kt:307)");
            }
            m10122CartLineRowcf5BqRc(LangKt.tx("Подытог", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(cartTotals.getSubtotal())), 0L, null, composer, 0, 12);
            String tx2 = LangKt.tx("Скидка на чек", new Object[0]);
            if (cartTotals.getDiscount() > 0.005d) {
                tx = "−" + Fmt.INSTANCE.nf(Double.valueOf(cartTotals.getDiscount()));
            } else {
                tx = LangKt.tx("добавить", new Object[0]);
            }
            long m10220getPrimary0d7_KjU = Ox.INSTANCE.m10220getPrimary0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(composer, 1618776077, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda40
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CartSheet$lambda$39$2$2$0$0;
                        CartSheet$lambda$39$2$2$0$0 = CartSheetKt.CartSheet$lambda$39$2$2$0$0(MutableState.this);
                        return CartSheet$lambda$39$2$2$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m10122CartLineRowcf5BqRc(tx2, tx, m10220getPrimary0d7_KjU, (Function0) rememberedValue, composer, 3072, 0);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer, 6);
            BasicsKt.m9830OxDivideriPRSM58(Ox.INSTANCE.m10189getBorder0d7_KjU(), 0.0f, composer, 0, 2);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer, 6);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1129920708, "C318@13330L236,323@13591L231:CartSheet.kt#1sewlp");
            TextKt.m2798Text4IGK_g(LangKt.tx("Итого", new Object[0]), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH2(), 0L, TextUnitKt.getSp(17), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 0, 0, 65532);
            TextKt.m2798Text4IGK_g(repo.money(Double.valueOf(cartTotals.getTotal())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH2(), 0L, TextUnitKt.getSp(17), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 0, 3072, 57342);
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
    public static final Unit CartSheet$lambda$39$2$2$0$0(MutableState mutableState) {
        CartSheet$lambda$14(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$40$0$0(CartLine cartLine, double d, double d2) {
        CartStore.INSTANCE.setQty(cartLine.getProductId(), d2, d);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$40$1$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$40$2$0(CartLine cartLine, double d, double d2) {
        CartStore.INSTANCE.setQty(cartLine.getProductId(), d2, d);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$40$3$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$41$0$0(CartLine cartLine, double d) {
        CartStore.INSTANCE.setLineDiscount(cartLine.getProductId(), Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, d));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$41$1$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$42$0(MutableState mutableState, CartDiscount it) {
        Intrinsics.checkNotNullParameter(it, "it");
        CartStore.INSTANCE.setDiscount(it);
        CartSheet$lambda$14(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$43$0(MutableState mutableState) {
        CartSheet$lambda$14(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$44$0(MutableState mutableState, Customer picked) {
        Intrinsics.checkNotNullParameter(picked, "picked");
        CartStore.INSTANCE.setCustomer(picked.getId());
        CartSheet$lambda$11(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$45$0(MutableState mutableState) {
        CartSheet$lambda$11(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$46$0(MutableState mutableState, MutableState mutableState2) {
        CartSheet$lambda$17(mutableState, false);
        CartSheet$lambda$26(mutableState2, CartSheet$lambda$25(mutableState2) + 1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$47$0(MutableState mutableState, MutableState mutableState2) {
        CartSheet$lambda$17(mutableState, false);
        CartSheet$lambda$26(mutableState2, CartSheet$lambda$25(mutableState2) + 1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$48$0(Function0 function0) {
        CartStore.INSTANCE.clear();
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CartSheet$lambda$49$0(MutableState mutableState) {
        CartSheet$lambda$23(mutableState, false);
        return Unit.INSTANCE;
    }

    private static final void ReceiptDiscountSheet(final CartDiscount cartDiscount, final Function1<? super CartDiscount, Unit> function1, Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function02;
        Composer startRestartGroup = composer.startRestartGroup(-1344226020);
        ComposerKt.sourceInformation(startRestartGroup, "C(ReceiptDiscountSheet)433@16898L41,434@16957L42,435@17015L34,444@17302L485,459@17794L528,437@17055L1267:CartSheet.kt#1sewlp");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(cartDiscount) : startRestartGroup.changedInstance(cartDiscount) ? 4 : 2) | i;
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
            function02 = function0;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1344226020, i2, -1, "uz.FonRo.pos.ui.sale.ReceiptDiscountSheet (CartSheet.kt:432)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 983955269, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(cartDiscount.getType(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 983957158, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Double.valueOf(cartDiscount.getValue()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 983959006, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SheetsKt.OxCardSheet(LangKt.tx("Скидка на чек", new Object[0]), function0, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-933763633, true, new Function3() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CartSheetKt.ReceiptDiscountSheet$lambda$9(Function1.this, mutableState, mutableState2, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-2065377736, true, new Function3() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CartSheetKt.ReceiptDiscountSheet$lambda$10(MutableState.this, mutableState2, mutableState3, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, 14376960 | ((i2 >> 3) & 112), 12);
            function02 = function0;
            startRestartGroup = startRestartGroup;
            if (ReceiptDiscountSheet$lambda$7(mutableState3)) {
                startRestartGroup.startReplaceGroup(439275895);
                ComposerKt.sourceInformation(startRestartGroup, "478@18495L24,479@18545L15,475@18347L223");
                String tx = Intrinsics.areEqual(ReceiptDiscountSheet$lambda$1(mutableState), "percent") ? LangKt.tx("Скидка, %", new Object[0]) : LangKt.tx("Скидка, сумма", new Object[0]);
                double ReceiptDiscountSheet$lambda$4 = ReceiptDiscountSheet$lambda$4(mutableState2);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 984006356, "CC(remember):CartSheet.kt#9igjgp");
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit ReceiptDiscountSheet$lambda$11$0;
                            ReceiptDiscountSheet$lambda$11$0 = CartSheetKt.ReceiptDiscountSheet$lambda$11$0(MutableState.this, ((Double) obj).doubleValue());
                            return ReceiptDiscountSheet$lambda$11$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                Function1 function12 = (Function1) rememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 984007947, "CC(remember):CartSheet.kt#9igjgp");
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue5 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ReceiptDiscountSheet$lambda$12$0;
                            ReceiptDiscountSheet$lambda$12$0 = CartSheetKt.ReceiptDiscountSheet$lambda$12$0(MutableState.this);
                            return ReceiptDiscountSheet$lambda$12$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                NumpadKt.NumpadSheet(tx, ReceiptDiscountSheet$lambda$4, function12, (Function0) rememberedValue5, false, startRestartGroup, 3456, 16);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(439505574);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CartSheetKt.ReceiptDiscountSheet$lambda$13(CartDiscount.this, function1, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String ReceiptDiscountSheet$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final double ReceiptDiscountSheet$lambda$4(MutableState<Double> mutableState) {
        return mutableState.getValue().doubleValue();
    }

    private static final void ReceiptDiscountSheet$lambda$5(MutableState<Double> mutableState, double d) {
        mutableState.setValue(Double.valueOf(d));
    }

    private static final boolean ReceiptDiscountSheet$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ReceiptDiscountSheet$lambda$8(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReceiptDiscountSheet$lambda$9(final Function1 function1, final MutableState mutableState, final MutableState mutableState2, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C447@17372L27,445@17316L185,453@17573L63,451@17514L263:CartSheet.kt#1sewlp");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-933763633, i2, -1, "uz.FonRo.pos.ui.sale.ReceiptDiscountSheet.<anonymous> (CartSheet.kt:445)");
            }
            String tx = LangKt.tx("Убрать", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, 301315818, "CC(remember):CartSheet.kt#9igjgp");
            boolean changed = composer.changed(function1);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda46
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ReceiptDiscountSheet$lambda$9$0$0;
                        ReceiptDiscountSheet$lambda$9$0$0 = CartSheetKt.ReceiptDiscountSheet$lambda$9$0$0(Function1.this);
                        return ReceiptDiscountSheet$lambda$9$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.GHOST, null, false, false, null, composer, 3072, 240);
            String tx2 = LangKt.tx("Применить", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, 301322286, "CC(remember):CartSheet.kt#9igjgp");
            boolean changed2 = composer.changed(function1);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda47
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ReceiptDiscountSheet$lambda$9$1$0;
                        ReceiptDiscountSheet$lambda$9$1$0 = CartSheetKt.ReceiptDiscountSheet$lambda$9$1$0(Function1.this, mutableState, mutableState2);
                        return ReceiptDiscountSheet$lambda$9$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx2, (Function0) rememberedValue2, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.4f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, false, false, null, composer, 27648, 224);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptDiscountSheet$lambda$9$0$0(Function1 function1) {
        function1.invoke(new CartDiscount((String) null, AudioStats.AUDIO_AMPLITUDE_NONE, 3, (DefaultConstructorMarker) null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptDiscountSheet$lambda$9$1$0(Function1 function1, MutableState mutableState, MutableState mutableState2) {
        function1.invoke(new CartDiscount(ReceiptDiscountSheet$lambda$1(mutableState), Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, ReceiptDiscountSheet$lambda$4(mutableState2))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReceiptDiscountSheet$lambda$10(final MutableState mutableState, MutableState mutableState2, final MutableState mutableState3, ColumnScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C460@17804L269,464@18082L11,467@18194L14,465@18102L195,471@18306L10:CartSheet.kt#1sewlp");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2065377736, i, -1, "uz.FonRo.pos.ui.sale.ReceiptDiscountSheet.<anonymous> (CartSheet.kt:460)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1676935939, "C461@17954L19,461@17899L74,462@18043L20,462@17986L77:CartSheet.kt#1sewlp");
            String tx = LangKt.tx("Сумма", new Object[0]);
            boolean areEqual = Intrinsics.areEqual(ReceiptDiscountSheet$lambda$1(mutableState), "amount");
            ComposerKt.sourceInformationMarkerStart(composer, 469738319, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ReceiptDiscountSheet$lambda$10$0$0$0;
                        ReceiptDiscountSheet$lambda$10$0$0$0 = CartSheetKt.ReceiptDiscountSheet$lambda$10$0$0$0(MutableState.this);
                        return ReceiptDiscountSheet$lambda$10$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            PayTypeTile(rowScopeInstance, "💵", tx, areEqual, true, (Function0) rememberedValue, composer, 221238);
            String tx2 = LangKt.tx("Процент", new Object[0]);
            boolean areEqual2 = Intrinsics.areEqual(ReceiptDiscountSheet$lambda$1(mutableState), "percent");
            ComposerKt.sourceInformationMarkerStart(composer, 469741168, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ReceiptDiscountSheet$lambda$10$0$1$0;
                        ReceiptDiscountSheet$lambda$10$0$1$0 = CartSheetKt.ReceiptDiscountSheet$lambda$10$0$1$0(MutableState.this);
                        return ReceiptDiscountSheet$lambda$10$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            PayTypeTile(rowScopeInstance, "%", tx2, areEqual2, true, (Function0) rememberedValue2, composer, 221238);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            String nf = ReceiptDiscountSheet$lambda$4(mutableState2) > AudioStats.AUDIO_AMPLITUDE_NONE ? Fmt.INSTANCE.nf(Double.valueOf(ReceiptDiscountSheet$lambda$4(mutableState2))) : LangKt.tx("Указать значение", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -553100730, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ReceiptDiscountSheet$lambda$10$1$0;
                        ReceiptDiscountSheet$lambda$10$1$0 = CartSheetKt.ReceiptDiscountSheet$lambda$10$1$0(MutableState.this);
                        return ReceiptDiscountSheet$lambda$10$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(nf, (Function0) rememberedValue3, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, BtnSize.LG, false, false, null, composer, 25008, 232);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptDiscountSheet$lambda$10$0$0$0(MutableState mutableState) {
        mutableState.setValue("amount");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptDiscountSheet$lambda$10$0$1$0(MutableState mutableState) {
        mutableState.setValue("percent");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptDiscountSheet$lambda$10$1$0(MutableState mutableState) {
        ReceiptDiscountSheet$lambda$8(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptDiscountSheet$lambda$11$0(MutableState mutableState, double d) {
        ReceiptDiscountSheet$lambda$5(mutableState, Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, d));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptDiscountSheet$lambda$12$0(MutableState mutableState) {
        ReceiptDiscountSheet$lambda$8(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x038e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void PaySheet(final uz.FonRo.pos.FonRoApp r37, final java.lang.String r38, final kotlin.jvm.functions.Function0<kotlin.Unit> r39, final kotlin.jvm.functions.Function0<kotlin.Unit> r40, final kotlin.jvm.functions.Function1<? super uz.FonRo.pos.ui.sale.SaleDone, kotlin.Unit> r41, androidx.compose.runtime.Composer r42, final int r43) {
        /*
            Method dump skipped, instructions count: 1187
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.sale.CartSheetKt.PaySheet(uz.FonRo.pos.FonRoApp, java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PayType PaySheet$lambda$4(MutableState<PayType> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double PaySheet$lambda$7(MutableState<Double> mutableState) {
        return mutableState.getValue().doubleValue();
    }

    private static final void PaySheet$lambda$8(MutableState<Double> mutableState, double d) {
        mutableState.setValue(Double.valueOf(d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double PaySheet$lambda$10(MutableState<Double> mutableState) {
        return mutableState.getValue().doubleValue();
    }

    private static final void PaySheet$lambda$11(MutableState<Double> mutableState, double d) {
        mutableState.setValue(Double.valueOf(d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double PaySheet$lambda$13(MutableState<Double> mutableState) {
        return mutableState.getValue().doubleValue();
    }

    private static final void PaySheet$lambda$14(MutableState<Double> mutableState, double d) {
        mutableState.setValue(Double.valueOf(d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PaySheet$lambda$16(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PaySheet$lambda$17(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String PaySheet$lambda$19(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean PaySheet$lambda$22(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void PaySheet$lambda$23(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean PaySheet$lambda$25(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PaySheet$lambda$26(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void PaySheet$provide(double d, CoroutineScope coroutineScope, MutableState<Boolean> mutableState, State<CartState> state, MutableState<PayType> mutableState2, MutableState<Double> mutableState3, FonRoApp FonRoApp, String str, CartTotals cartTotals, double d2, Function1<? super SaleDone, Unit> function1, MutableState<Double> mutableState4, MutableState<Double> mutableState5, MutableState<Boolean> mutableState6) {
        double d3;
        if (PaySheet$lambda$25(mutableState)) {
            return;
        }
        if (PaySheet$lambda$0(state).getItems().isEmpty()) {
            Toaster.INSTANCE.error(LangKt.tx("Чек пуст", new Object[0]));
            return;
        }
        if (PaySheet$lambda$4(mutableState2) == PayType.CASH) {
            d3 = d;
            if (!Num.INSTANCE.gte(PaySheet$lambda$7(mutableState3), d3)) {
                Toaster.INSTANCE.error(LangKt.tx("Получено меньше суммы чека", new Object[0]));
                return;
            }
        } else {
            d3 = d;
        }
        if (PaySheet$lambda$4(mutableState2) == PayType.DEBT && PaySheet$lambda$0(state).getCustomerId() <= 0) {
            Toaster.INSTANCE.error(LangKt.tx("Для долга выберите клиента", new Object[0]));
        } else {
            PaySheet$lambda$26(mutableState, true);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CartSheetKt$PaySheet$provide$1(FonRoApp, str, cartTotals, d3, d2, function1, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6, mutableState, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PaySheet$lambda$27(Function0 function0, final State state, final MutableState mutableState, final double d, final CoroutineScope coroutineScope, final FonRoApp FonRoApp, final String str, final CartTotals cartTotals, final MutableState mutableState2, final double d2, final Function1 function1, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C593@22868L85,596@23055L13,601@23283L127,594@22966L458:CartSheet.kt#1sewlp");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1150885960, i2, -1, "uz.FonRo.pos.ui.sale.PaySheet.<anonymous> (CartSheet.kt:593)");
            }
            BasicsKt.OxButton(LangKt.tx("Назад", new Object[0]), function0, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.GHOST, null, false, false, null, composer, 3072, 240);
            String tx = PaySheet$lambda$25(mutableState3) ? LangKt.tx("Проводим…", new Object[0]) : LangKt.tx("Провести", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -2100148363, "CC(remember):CartSheet.kt#9igjgp");
            boolean changed = composer.changed(state) | composer.changed(mutableState) | composer.changed(d) | composer.changedInstance(coroutineScope) | composer.changedInstance(FonRoApp) | composer.changed(str) | composer.changedInstance(cartTotals) | composer.changed(mutableState2) | composer.changed(d2) | composer.changed(function1);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                Function0 function02 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda76
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PaySheet$lambda$27$0$0;
                        PaySheet$lambda$27$0$0 = CartSheetKt.PaySheet$lambda$27$0$0(d, coroutineScope, mutableState3, state, mutableState4, mutableState, FonRoApp, str, cartTotals, d2, function1, mutableState2, mutableState5, mutableState6);
                        return PaySheet$lambda$27$0$0;
                    }
                };
                composer.updateRememberedValue(function02);
                rememberedValue = function02;
            }
            Function0 function03 = (Function0) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, function03, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.8f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, (PaySheet$lambda$25(mutableState3) || PaySheet$lambda$0(state).getItems().isEmpty()) ? false : true, false, ComposableLambdaKt.rememberComposableLambda(1878960386, true, new Function2() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda78
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PaySheet$lambda$27$1;
                    PaySheet$lambda$27$1 = CartSheetKt.PaySheet$lambda$27$1(MutableState.this, (Composer) obj, ((Integer) obj2).intValue());
                    return PaySheet$lambda$27$1;
                }
            }, composer, 54), composer, 12610560, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaySheet$lambda$27$0$0(double d, CoroutineScope coroutineScope, MutableState mutableState, State state, MutableState mutableState2, MutableState mutableState3, FonRoApp FonRoApp, String str, CartTotals cartTotals, double d2, Function1 function1, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6) {
        PaySheet$provide(d, coroutineScope, mutableState, state, mutableState2, mutableState3, FonRoApp, str, cartTotals, d2, function1, mutableState4, mutableState5, mutableState6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaySheet$lambda$27$1(MutableState mutableState, Composer composer, int i) {
        Composer composer2;
        ComposerKt.sourceInformation(composer, "C:CartSheet.kt#1sewlp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1878960386, i, -1, "uz.FonRo.pos.ui.sale.PaySheet.<anonymous>.<anonymous> (CartSheet.kt:602)");
            }
            if (PaySheet$lambda$25(mutableState)) {
                composer2 = composer;
                composer2.startReplaceGroup(-199801312);
            } else {
                composer.startReplaceGroup(1794667758);
                ComposerKt.sourceInformation(composer, "602@23316L76");
                composer2 = composer;
                IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getOk(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(18.0f)), 0L, composer2, 432, 8);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit PaySheet$lambda$28(Repo repo, double d, double d2, Customer customer, final MutableState mutableState, final boolean z, final MutableState mutableState2, final MutableState mutableState3, double d3, MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, MutableState mutableState7, ColumnScope OxCardSheet, Composer composer, int i) {
        Composer composer2;
        int i2;
        int i3;
        String str;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C607@23497L21,607@23451L5224:CartSheet.kt#1sewlp");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(296458865, i, -1, "uz.FonRo.pos.ui.sale.PaySheet.<anonymous> (CartSheet.kt:607)");
            }
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
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
            ComposerKt.sourceInformationMarkerStart(composer, 701843755, "C609@23592L245,616@23851L381,624@24245L10,625@24268L480,635@24762L11,724@28655L10:CartSheet.kt#1sewlp");
            TextKt.m2798Text4IGK_g(repo.money(Double.valueOf(d)), PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(6.0f), 0.0f, Dp.m6989constructorimpl(12.0f), 5, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getAmount(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6873getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), composer, 48, 3072, 57340);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
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
            ComposerKt.sourceInformationMarkerStart(composer, 219865868, "C617@24015L62,617@23950L127,620@24156L62,620@24094L124:CartSheet.kt#1sewlp");
            String tx = LangKt.tx("Наличные", new Object[0]);
            boolean z2 = PaySheet$lambda$4(mutableState) == PayType.CASH;
            ComposerKt.sourceInformationMarkerStart(composer, -270000343, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda64
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PaySheet$lambda$28$0$0$0$0;
                        PaySheet$lambda$28$0$0$0$0 = CartSheetKt.PaySheet$lambda$28$0$0$0$0(MutableState.this);
                        return PaySheet$lambda$28$0$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            PayTypeTile(rowScopeInstance, "💵", tx, z2, true, (Function0) rememberedValue, composer, 221238);
            String tx2 = LangKt.tx("Карта", new Object[0]);
            boolean z3 = PaySheet$lambda$4(mutableState) == PayType.CARD;
            ComposerKt.sourceInformationMarkerStart(composer, -269995831, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda67
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PaySheet$lambda$28$0$0$1$0;
                        PaySheet$lambda$28$0$0$1$0 = CartSheetKt.PaySheet$lambda$28$0$0$1$0(MutableState.this);
                        return PaySheet$lambda$28$0$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            PayTypeTile(rowScopeInstance, "💳", tx2, z3, true, (Function0) rememberedValue2, composer, 221238);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1497290766, "C626@24435L63,626@24367L131,629@24581L153,629@24515L219:CartSheet.kt#1sewlp");
            String tx3 = LangKt.tx("Смешанно", new Object[0]);
            boolean z4 = PaySheet$lambda$4(mutableState) == PayType.MIXED;
            ComposerKt.sourceInformationMarkerStart(composer, -879581823, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda68
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PaySheet$lambda$28$0$1$0$0;
                        PaySheet$lambda$28$0$1$0$0 = CartSheetKt.PaySheet$lambda$28$0$1$0$0(MutableState.this);
                        return PaySheet$lambda$28$0$1$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            PayTypeTile(rowScopeInstance2, "💵💳", tx3, z4, true, (Function0) rememberedValue3, composer, 221238);
            String tx4 = LangKt.tx("В долг", new Object[0]);
            boolean z5 = PaySheet$lambda$4(mutableState) == PayType.DEBT;
            ComposerKt.sourceInformationMarkerStart(composer, -879577061, "CC(remember):CartSheet.kt#9igjgp");
            boolean changed = composer.changed(z);
            Object rememberedValue4 = composer.rememberedValue();
            if (changed || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda69
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PaySheet$lambda$28$0$1$1$0;
                        PaySheet$lambda$28$0$1$1$0 = CartSheetKt.PaySheet$lambda$28$0$1$1$0(z, mutableState);
                        return PaySheet$lambda$28$0$1$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            PayTypeTile(rowScopeInstance2, "📒", tx4, z5, z, (Function0) rememberedValue4, composer, 54);
            Composer composer3 = composer;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(14.0f), composer3, 6);
            int i4 = WhenMappings.$EnumSwitchMapping$0[PaySheet$lambda$4(mutableState).ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    composer3.startReplaceGroup(704437586);
                    ComposerKt.sourceInformation(composer3, "671@26385L33");
                    PayNote(LangKt.tx("Вся сумма — картой", new Object[0]), composer3, 0);
                    composer3.endReplaceGroup();
                    Unit unit = Unit.INSTANCE;
                } else if (i4 == 3) {
                    composer3.startReplaceGroup(704566825);
                    ComposerKt.sourceInformation(composer3, "675@26493L649,689@27163L11,690@27195L44");
                    Modifier fillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical m930spacedBy0680j_43 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
                    ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m930spacedBy0680j_43, Alignment.INSTANCE.getTop(), composer3, 6);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                    Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer3, fillMaxWidth$default3);
                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor4);
                    } else {
                        composer3.useNode();
                    }
                    Composer m3808constructorimpl4 = Updater.m3808constructorimpl(composer3);
                    Updater.m3815setimpl(m3808constructorimpl4, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3815setimpl(m3808constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3808constructorimpl4.getInserting() || !Intrinsics.areEqual(m3808constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        m3808constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        m3808constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    Updater.m3815setimpl(m3808constructorimpl4, materializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, -128335439, "C678@26705L16,676@26601L253,684@26971L16,682@26879L241:CartSheet.kt#1sewlp");
                    String str2 = "💵 " + Fmt.INSTANCE.nf(Double.valueOf(Math.min(PaySheet$lambda$10(mutableState4), d)));
                    ComposerKt.sourceInformationMarkerStart(composer3, -1112515685, "CC(remember):CartSheet.kt#9igjgp");
                    Object rememberedValue5 = composer3.rememberedValue();
                    if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue5 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda72
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit PaySheet$lambda$28$0$5$0$0;
                                PaySheet$lambda$28$0$5$0$0 = CartSheetKt.PaySheet$lambda$28$0$5$0$0(MutableState.this);
                                return PaySheet$lambda$28$0$5$0$0;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    BasicsKt.OxButton(str2, (Function0) rememberedValue5, RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), null, BtnSize.LG, false, false, null, composer3, 24624, 232);
                    String str3 = "💳 " + Fmt.INSTANCE.nf(Double.valueOf(d3));
                    ComposerKt.sourceInformationMarkerStart(composer3, -1112507173, "CC(remember):CartSheet.kt#9igjgp");
                    Object rememberedValue6 = composer3.rememberedValue();
                    if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue6 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda73
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit PaySheet$lambda$28$0$5$1$0;
                                PaySheet$lambda$28$0$5$1$0 = CartSheetKt.PaySheet$lambda$28$0$5$1$0(MutableState.this);
                                return PaySheet$lambda$28$0$5$1$0;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    BasicsKt.OxButton(str3, (Function0) rememberedValue6, RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), null, BtnSize.LG, false, false, null, composer3, 24624, 232);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer3, 6);
                    PayNote(LangKt.tx("Наличные + карта = сумма чека", new Object[0]), composer3, 0);
                    composer3.endReplaceGroup();
                    Unit unit2 = Unit.INSTANCE;
                } else {
                    if (i4 != 4) {
                        composer3.startReplaceGroup(-1085701515);
                        composer3.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composer3.startReplaceGroup(705397315);
                    ComposerKt.sourceInformation(composer3, "697@27494L29,694@27313L383,701@27717L11,702@27749L51,703@27821L10,707@28062L29,704@27852L298,710@28171L11,714@28357L16,711@28203L192,716@28416L193");
                    if (customer != null) {
                        str = "👤 " + customer.getFullName();
                        i3 = 0;
                    } else {
                        i3 = 0;
                        str = "👤 " + LangKt.tx("Выберите клиента (обязательно)", new Object[0]);
                    }
                    ComposerKt.sourceInformationMarkerStart(composer3, -1085618716, "CC(remember):CartSheet.kt#9igjgp");
                    Object rememberedValue7 = composer3.rememberedValue();
                    if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue7 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda74
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit PaySheet$lambda$28$0$6$0;
                                PaySheet$lambda$28$0$6$0 = CartSheetKt.PaySheet$lambda$28$0$6$0(MutableState.this);
                                return PaySheet$lambda$28$0$6$0;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue7);
                    }
                    Function0 function0 = (Function0) rememberedValue7;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    BasicsKt.OxButton(str, function0, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), customer != null ? BtnStyle.PLAIN : BtnStyle.DANGER, null, false, false, null, composer3, 432, 240);
                    BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer3, 6);
                    TextKt.m2798Text4IGK_g(LangKt.tx("Чем внесли сейчас", new Object[i3]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getLabel(), composer3, 0, 0, 65534);
                    BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer3, 6);
                    Pair[] pairArr = new Pair[2];
                    pairArr[i3] = TuplesKt.to("cash", LangKt.tx("Наличные", new Object[i3]));
                    pairArr[1] = TuplesKt.to("card", LangKt.tx("Карта", new Object[i3]));
                    List listOf = CollectionsKt.listOf((Object[]) pairArr);
                    String str4 = PaySheet$lambda$16(mutableState6) ? "card" : "cash";
                    ComposerKt.sourceInformationMarkerStart(composer3, -1085600540, "CC(remember):CartSheet.kt#9igjgp");
                    Object rememberedValue8 = composer3.rememberedValue();
                    if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue8 = new Function1() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda75
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit PaySheet$lambda$28$0$7$0;
                                PaySheet$lambda$28$0$7$0 = CartSheetKt.PaySheet$lambda$28$0$7$0(MutableState.this, (String) obj);
                                return PaySheet$lambda$28$0$7$0;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ChipsKt.OxSegControl(listOf, str4, (Function1) rememberedValue8, null, true, composer3, 24960, 8);
                    composer3 = composer3;
                    BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer3, 6);
                    String tx5 = LangKt.tx("Внесено сейчас:", new Object[i3]);
                    String nf = Fmt.INSTANCE.nf(Double.valueOf(PaySheet$lambda$13(mutableState7)));
                    ComposerKt.sourceInformationMarkerStart(composer3, -1085591113, "CC(remember):CartSheet.kt#9igjgp");
                    Object rememberedValue9 = composer3.rememberedValue();
                    if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue9 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda65
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit PaySheet$lambda$28$0$8$0;
                                PaySheet$lambda$28$0$8$0 = CartSheetKt.PaySheet$lambda$28$0$8$0(MutableState.this);
                                return PaySheet$lambda$28$0$8$0;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue9);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    FieldsKt.m9849OxValueButtonFHprtrg(tx5, nf, (Function0) rememberedValue9, null, 0L, null, composer3, 384, 56);
                    PayHint(LangKt.tx("Останется долг:", new Object[i3]), Fmt.INSTANCE.nf(Double.valueOf(Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, d - PaySheet$lambda$13(mutableState7)))), true, composer3, 384);
                    composer3.endReplaceGroup();
                    Unit unit3 = Unit.INSTANCE;
                }
                composer2 = composer3;
            } else {
                float f = 0.0f;
                composer3.startReplaceGroup(702966822);
                ComposerKt.sourceInformation(composer3, "642@25006L20,639@24858L190,646@25207L47,663@26136L175");
                String tx6 = LangKt.tx("Получено:", new Object[0]);
                String nf2 = Fmt.INSTANCE.nf(Double.valueOf(PaySheet$lambda$7(mutableState2)));
                ComposerKt.sourceInformationMarkerStart(composer3, -1085698341, "CC(remember):CartSheet.kt#9igjgp");
                Object rememberedValue10 = composer3.rememberedValue();
                if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue10 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda70
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit PaySheet$lambda$28$0$2$0;
                            PaySheet$lambda$28$0$2$0 = CartSheetKt.PaySheet$lambda$28$0$2$0(MutableState.this);
                            return PaySheet$lambda$28$0$2$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue10);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                int i5 = 1;
                int i6 = 6;
                FieldsKt.m9849OxValueButtonFHprtrg(tx6, nf2, (Function0) rememberedValue10, null, 0L, null, composer3, 384, 56);
                composer2 = composer3;
                ComposerKt.sourceInformationMarkerStart(composer2, -1085691882, "CC(remember):CartSheet.kt#9igjgp");
                boolean changed2 = composer2.changed(d);
                Object rememberedValue11 = composer2.rememberedValue();
                if (changed2 || rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue11 = quickCashSuggestions(d);
                    composer2.updateRememberedValue(rememberedValue11);
                }
                List list = (List) rememberedValue11;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (list.isEmpty()) {
                    i2 = 1;
                    composer2.startReplaceGroup(704189307);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(703405131);
                    ComposerKt.sourceInformation(composer2, "648@25325L11,*650@25424L643");
                    BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer2, 6);
                    for (List list2 : CollectionsKt.chunked(list, 2)) {
                        Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, f, i5, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(8.0f), 7, null);
                        Arrangement.HorizontalOrVertical m930spacedBy0680j_44 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
                        ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(m930spacedBy0680j_44, Alignment.INSTANCE.getTop(), composer2, i6);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer2, m1053paddingqDBjuR0$default);
                        Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor5);
                        } else {
                            composer2.useNode();
                        }
                        Composer m3808constructorimpl5 = Updater.m3808constructorimpl(composer2);
                        Updater.m3815setimpl(m3808constructorimpl5, rowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3815setimpl(m3808constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3808constructorimpl5.getInserting() || !Intrinsics.areEqual(m3808constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                            m3808constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                            m3808constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                        }
                        Updater.m3815setimpl(m3808constructorimpl5, materializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1890732909, "C:CartSheet.kt#1sewlp");
                        composer2.startReplaceGroup(216103199);
                        ComposerKt.sourceInformation(composer2, "*655@25747L20,655@25716L51");
                        Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            final double doubleValue = ((Number) it.next()).doubleValue();
                            String nf3 = Fmt.INSTANCE.nf(Double.valueOf(doubleValue));
                            ComposerKt.sourceInformationMarkerStart(composer2, -815761545, "CC(remember):CartSheet.kt#9igjgp");
                            boolean changed3 = composer2.changed(mutableState2) | composer2.changed(doubleValue);
                            Object rememberedValue12 = composer2.rememberedValue();
                            if (changed3 || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue12 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda71
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit PaySheet$lambda$28$0$4$0$0$0$0;
                                        PaySheet$lambda$28$0$4$0$0$0$0 = CartSheetKt.PaySheet$lambda$28$0$4$0$0$0$0(doubleValue, mutableState2);
                                        return PaySheet$lambda$28$0$4$0$0$0$0;
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue12);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            QuickCashButton(rowScopeInstance4, nf3, (Function0) rememberedValue12, composer2, 6);
                        }
                        composer2.endReplaceGroup();
                        if (list2.size() == 1) {
                            composer2.startReplaceGroup(216114254);
                            ComposerKt.sourceInformation(composer2, "659@26010L27");
                            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null), composer2, 0);
                        } else {
                            composer2.startReplaceGroup(-1890366769);
                        }
                        composer2.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        i5 = 1;
                        i6 = 6;
                        f = 0.0f;
                    }
                    i2 = i5;
                    composer2.endReplaceGroup();
                }
                PayHint(LangKt.tx("Сдача:", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(d2)), d2 < -0.005d ? i2 : 0, composer2, 0);
                composer2.endReplaceGroup();
                Unit unit4 = Unit.INSTANCE;
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(4.0f), composer2, 6);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaySheet$lambda$28$0$0$0$0(MutableState mutableState) {
        mutableState.setValue(PayType.CASH);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaySheet$lambda$28$0$0$1$0(MutableState mutableState) {
        mutableState.setValue(PayType.CARD);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaySheet$lambda$28$0$1$0$0(MutableState mutableState) {
        mutableState.setValue(PayType.MIXED);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaySheet$lambda$28$0$1$1$0(boolean z, MutableState mutableState) {
        if (!z) {
            Toaster.INSTANCE.error(LangKt.tx("Нет доступа для этого действия.", new Object[0]));
        } else {
            mutableState.setValue(PayType.DEBT);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaySheet$lambda$28$0$2$0(MutableState mutableState) {
        mutableState.setValue("received");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaySheet$lambda$28$0$4$0$0$0$0(double d, MutableState mutableState) {
        PaySheet$lambda$8(mutableState, d);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaySheet$lambda$28$0$5$0$0(MutableState mutableState) {
        mutableState.setValue("cash");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaySheet$lambda$28$0$5$1$0(MutableState mutableState) {
        mutableState.setValue("card");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaySheet$lambda$28$0$6$0(MutableState mutableState) {
        PaySheet$lambda$23(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaySheet$lambda$28$0$7$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        PaySheet$lambda$17(mutableState, Intrinsics.areEqual(it, "card"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaySheet$lambda$28$0$8$0(MutableState mutableState) {
        mutableState.setValue("debt");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaySheet$lambda$29$0$0(String str, double d, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, double d2) {
        int hashCode = str.hashCode();
        if (hashCode == -808719903) {
            if (str.equals("received")) {
                PaySheet$lambda$8(mutableState, Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, d2));
            }
            PaySheet$lambda$14(mutableState3, Math.min(d, Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, d2)));
        } else if (hashCode == 3046160) {
            if (str.equals("card")) {
                PaySheet$lambda$11(mutableState2, Math.min(d, Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, d - d2)));
            }
            PaySheet$lambda$14(mutableState3, Math.min(d, Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, d2)));
        } else {
            if (hashCode == 3046195 && str.equals("cash")) {
                PaySheet$lambda$11(mutableState2, Math.min(d, Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, d2)));
            }
            PaySheet$lambda$14(mutableState3, Math.min(d, Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, d2)));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaySheet$lambda$29$1$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaySheet$lambda$30$0(MutableState mutableState, Customer picked) {
        Intrinsics.checkNotNullParameter(picked, "picked");
        CartStore.INSTANCE.setCustomer(picked.getId());
        PaySheet$lambda$23(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaySheet$lambda$31$0(MutableState mutableState) {
        PaySheet$lambda$23(mutableState, false);
        return Unit.INSTANCE;
    }

    private static final List<Double> quickCashSuggestions(double d) {
        double money = Num.INSTANCE.money(d);
        if (money <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            return CollectionsKt.emptyList();
        }
        List mutableListOf = CollectionsKt.mutableListOf(Double.valueOf(Math.ceil(money)));
        Iterator it = CollectionsKt.listOf((Object[]) new Double[]{Double.valueOf(1000.0d), Double.valueOf(5000.0d), Double.valueOf(10000.0d), Double.valueOf(50000.0d), Double.valueOf(100000.0d)}).iterator();
        while (it.hasNext()) {
            double doubleValue = ((Number) it.next()).doubleValue();
            double ceil = Math.ceil(money / doubleValue) * doubleValue;
            if (ceil > money) {
                List list = mutableListOf;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        if (((Number) it2.next()).doubleValue() == ceil) {
                            break;
                        }
                    }
                }
                mutableListOf.add(Double.valueOf(ceil));
            }
        }
        return CollectionsKt.take(mutableListOf, 4);
    }

    /* renamed from: CartMiniStat-Bx497Mc, reason: not valid java name */
    private static final void m10123CartMiniStatBx497Mc(final RowScope rowScope, final String str, final String str2, final long j, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-64914434);
        ComposerKt.sourceInformation(startRestartGroup, "C(CartMiniStat)P(!1,2,1:c#ui.graphics.Color)792@30999L463:CartSheet.kt#1sewlp");
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
                ComposerKt.traceEventStart(-64914434, i2, -1, "uz.FonRo.pos.ui.sale.CartMiniStat (CartSheet.kt:791)");
            }
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), OxShape.INSTANCE.getTile()), Ox.INSTANCE.m10241tintBg5vOe2sY(j, 0.13f), null, 2, null), Dp.m6989constructorimpl(10.0f), Dp.m6989constructorimpl(9.0f));
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1115942168, "C799@31213L162,805@31384L72:CartSheet.kt#1sewlp");
            int i3 = i2;
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getStatValue(), j, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer2, (i3 >> 6) & 14, 3120, 55294);
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getTileLabel(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer2, (i3 >> 3) & 14, 3072, 57342);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CartSheetKt.CartMiniStat_Bx497Mc$lambda$1(RowScope.this, str, str2, j, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* renamed from: CartSoftButton-FNF3uiM, reason: not valid java name */
    private static final void m10124CartSoftButtonFNF3uiM(final RowScope rowScope, final String str, final long j, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Function0<Unit> function02;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(531080080);
        ComposerKt.sourceInformation(startRestartGroup, "C(CartSoftButton)P(1,2:c#ui.graphics.Color)818@31832L24,812@31647L528:CartSheet.kt#1sewlp");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(rowScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function02 = function0;
            i2 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
        } else {
            function02 = function0;
        }
        if (!startRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(531080080, i2, -1, "uz.FonRo.pos.ui.sale.CartSoftButton (CartSheet.kt:811)");
            }
            int i3 = i2 >> 3;
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(ModifiersKt.oxTap(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1084heightInVpY3zN4$default(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m6989constructorimpl(46.0f), 0.0f, 2, null), OxShape.INSTANCE.getTile()), Ox.INSTANCE.m10241tintBg5vOe2sY(j, 0.16f), null, 2, null), false, function02, startRestartGroup, i3 & 896, 1), Dp.m6989constructorimpl(10.0f), Dp.m6989constructorimpl(12.0f));
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1034253011, "C822@31977L192:CartSheet.kt#1sewlp");
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getLabel(), j, 0L, FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composer2, i3 & 14, 3120, 55294);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CartSheetKt.CartSoftButton_FNF3uiM$lambda$1(RowScope.this, str, j, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ClearButton(RowScope rowScope, boolean z, Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        final boolean z2;
        final Function0<Unit> function02;
        final RowScope rowScope2 = rowScope;
        Composer startRestartGroup = composer.startRestartGroup(-247267483);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClearButton)834@32331L564:CartSheet.kt#1sewlp");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(rowScope2) ? 4 : 2) | i;
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
            z2 = z;
            function02 = function0;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-247267483, i2, -1, "uz.FonRo.pos.ui.sale.ClearButton (CartSheet.kt:833)");
            }
            z2 = z;
            function02 = function0;
            Modifier oxClickable$default = ModifiersKt.oxClickable$default(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(AlphaKt.alpha(SizeKt.m1084heightInVpY3zN4$default(RowScope.weight$default(rowScope2, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m6989constructorimpl(50.0f), 0.0f, 2, null), z ? 1.0f : 0.5f), OxShape.INSTANCE.getBtnLg()), Ox.INSTANCE.m10198getDangerSoft0d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10197getDangerBorder0d7_KjU(), OxShape.INSTANCE.getBtnLg()), z2, null, 0L, function02, 6, null);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 872119314, "C845@32723L166:CartSheet.kt#1sewlp");
            rowScope2 = rowScope;
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getDelete(), LangKt.tx("Очистить", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(20.0f)), Ox.INSTANCE.m10196getDanger0d7_KjU(), startRestartGroup, 384, 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CartSheetKt.ClearButton$lambda$1(RowScope.this, z2, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void PayTypeTile(final RowScope rowScope, final String str, final String str2, final boolean z, final boolean z2, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        String str3;
        String str4;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-260916968);
        ComposerKt.sourceInformation(startRestartGroup, "C(PayTypeTile)P(2,3)875@33520L24,867@33202L874:CartSheet.kt#1sewlp");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(rowScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            str3 = str;
            i2 |= startRestartGroup.changed(str3) ? 32 : 16;
        } else {
            str3 = str;
        }
        if ((i & 384) == 0) {
            str4 = str2;
            i2 |= startRestartGroup.changed(str4) ? 256 : 128;
        } else {
            str4 = str2;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if (!startRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-260916968, i2, -1, "uz.FonRo.pos.ui.sale.PayTypeTile (CartSheet.kt:865)");
            }
            RoundedCornerShape tile = OxShape.INSTANCE.getTile();
            Modifier clip = ClipKt.clip(SizeKt.m1084heightInVpY3zN4$default(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m6989constructorimpl(56.0f), 0.0f, 2, null), tile);
            Ox ox = Ox.INSTANCE;
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(clip, z ? ox.m10222getPrimarySoft0d7_KjU() : ox.m10217getPanel0d7_KjU(), null, 2, null);
            float m6989constructorimpl = Dp.m6989constructorimpl(2.0f);
            Ox ox2 = Ox.INSTANCE;
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(ModifiersKt.oxTap(AlphaKt.alpha(BorderKt.m569borderxT4_qwU(m558backgroundbw27NRU$default, m6989constructorimpl, z ? ox2.m10220getPrimary0d7_KjU() : ox2.m10189getBorder0d7_KjU(), tile), z2 ? 1.0f : 0.45f), false, function0, startRestartGroup, (i2 >> 9) & 896, 1), Dp.m6989constructorimpl(8.0f), Dp.m6989constructorimpl(8.0f));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, startRestartGroup, 54);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -525329185, "C880@33728L68,881@33805L265:CartSheet.kt#1sewlp");
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str3, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), 0L, TextUnitKt.getSp(19), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), composer2, (i2 >> 3) & 14, 3072, 57342);
            TextStyle button = OxType.INSTANCE.getButton();
            Ox ox3 = Ox.INSTANCE;
            TextKt.m2798Text4IGK_g(str4, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(button, z ? ox3.m10220getPrimary0d7_KjU() : ox3.m10199getDim0d7_KjU(), 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composer2, (i2 >> 6) & 14, 3120, 55294);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda60
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CartSheetKt.PayTypeTile$lambda$1(RowScope.this, str, str2, z, z2, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void QuickCashButton(final RowScope rowScope, String str, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        final String str2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(454642001);
        ComposerKt.sourceInformation(startRestartGroup, "C(QuickCashButton)P(1)903@34446L24,896@34221L531:CartSheet.kt#1sewlp");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(rowScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            str2 = str;
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(454642001, i3, -1, "uz.FonRo.pos.ui.sale.QuickCashButton (CartSheet.kt:895)");
            }
            Modifier m1084heightInVpY3zN4$default = SizeKt.m1084heightInVpY3zN4$default(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m6989constructorimpl(46.0f), 0.0f, 2, null);
            RoundedCornerShape roundedCornerShape = StepPillShape;
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(ModifiersKt.oxTap(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(m1084heightInVpY3zN4$default, roundedCornerShape), Ox.INSTANCE.m10218getPanel20d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10189getBorder0d7_KjU(), roundedCornerShape), false, function0, startRestartGroup, i3 & 896, 1), Dp.m6989constructorimpl(8.0f), 0.0f, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -70829078, "C907@34572L174:CartSheet.kt#1sewlp");
            str2 = str;
            TextKt.m2798Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getButton(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), startRestartGroup, (i3 >> 3) & 14, 3120, 55294);
            composer2 = startRestartGroup;
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CartSheetKt.QuickCashButton$lambda$1(RowScope.this, str2, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void PayHint(final String str, String str2, final boolean z, Composer composer, final int i) {
        int i2;
        final String str3;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(2024684233);
        ComposerKt.sourceInformation(startRestartGroup, "C(PayHint)P(!1,2)919@34905L516:CartSheet.kt#1sewlp");
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
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            str3 = str2;
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2024684233, i2, -1, "uz.FonRo.pos.ui.sale.PayHint (CartSheet.kt:918)");
            }
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(6.0f), 0.0f, Dp.m6989constructorimpl(4.0f), 5, null);
            Arrangement.Horizontal m931spacedByD5KLDUw = Arrangement.INSTANCE.m931spacedByD5KLDUw(Dp.m6989constructorimpl(6.0f), Alignment.INSTANCE.getCenterHorizontally());
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m931spacedByD5KLDUw, centerVertically, startRestartGroup, 54);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1738606037, "C924@35150L53,925@35212L203:CartSheet.kt#1sewlp");
            composer2 = startRestartGroup;
            int i3 = i2;
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer2, i2 & 14, 0, 65534);
            TextStyle h2 = OxType.INSTANCE.getH2();
            long sp = TextUnitKt.getSp(16);
            Ox ox = Ox.INSTANCE;
            str3 = str2;
            TextKt.m2798Text4IGK_g(str3, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(h2, z ? ox.m10196getDanger0d7_KjU() : ox.m10211getOk0d7_KjU(), sp, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), composer2, (i3 >> 3) & 14, 3072, 57342);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CartSheetKt.PayHint$lambda$1(str, str3, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void PayNote(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1110636829);
        ComposerKt.sourceInformation(startRestartGroup, "C(PayNote)939@35547L173:CartSheet.kt#1sewlp");
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
                ComposerKt.traceEventStart(1110636829, i2, -1, "uz.FonRo.pos.ui.sale.PayNote (CartSheet.kt:938)");
            }
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str, PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(6.0f), 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6873getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744446, null), composer2, (i2 & 14) | 48, 0, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CartSheetKt.PayNote$lambda$0(str, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void CustomerRowButton(final java.lang.String r49, androidx.compose.ui.Modifier r50, final kotlin.jvm.functions.Function0<kotlin.Unit> r51, androidx.compose.runtime.Composer r52, final int r53, final int r54) {
        /*
            Method dump skipped, instructions count: 1207
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.sale.CartSheetKt.CustomerRowButton(java.lang.String, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0079  */
    /* renamed from: CartLineRow-cf5BqRc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m10122CartLineRowcf5BqRc(final java.lang.String r49, final java.lang.String r50, long r51, kotlin.jvm.functions.Function0<kotlin.Unit> r53, androidx.compose.runtime.Composer r54, final int r55, final int r56) {
        /*
            Method dump skipped, instructions count: 736
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.sale.CartSheetKt.m10122CartLineRowcf5BqRc(java.lang.String, java.lang.String, long, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void CartItemCard(final CartLine cartLine, final Double d, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, final Function0<Unit> function05, Composer composer, final int i) {
        int i2;
        final Double d2;
        final Function0<Unit> function06;
        final Function0<Unit> function07;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(152947132);
        ComposerKt.sourceInformation(startRestartGroup, "C(CartItemCard)P(!1,6,3,4,5,2)1036@38711L4151,1032@38586L4276:CartSheet.kt#1sewlp");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(cartLine) : startRestartGroup.changedInstance(cartLine) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            d2 = d;
            i2 |= startRestartGroup.changed(d2) ? 32 : 16;
        } else {
            d2 = d;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function03) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            function06 = function04;
            i2 |= startRestartGroup.changedInstance(function06) ? 131072 : 65536;
        } else {
            function06 = function04;
        }
        if ((1572864 & i) == 0) {
            function07 = function05;
            i2 |= startRestartGroup.changedInstance(function07) ? 1048576 : 524288;
        } else {
            function07 = function05;
        }
        if (!startRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(152947132, i2, -1, "uz.FonRo.pos.ui.sale.CartItemCard (CartSheet.kt:1030)");
            }
            final String name = Units.INSTANCE.name(cartLine.getUnit());
            composer2 = startRestartGroup;
            BasicsKt.m9833OxSoftCardCe4qNIY(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(9.0f), 7, null), Dp.m6989constructorimpl(12.0f), CartCardShape, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1795810882, true, new Function3() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda62
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CartSheetKt.CartItemCard$lambda$0(CartLine.this, name, d2, function06, function07, function0, function03, function02, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), composer2, 1573302, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda63
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CartSheetKt.CartItemCard$lambda$1(CartLine.this, d, function0, function02, function03, function04, function05, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CartItemCard$lambda$0(final CartLine cartLine, String str, Double d, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, ColumnScope OxSoftCard, Composer composer, int i) {
        String str2;
        String str3;
        String str4;
        String str5;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C1037@38721L1945,1087@40676L11,1089@40697L2159:CartSheet.kt#1sewlp");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1795810882, i, -1, "uz.FonRo.pos.ui.sale.CartItemCard.<anonymous> (CartSheet.kt:1037)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
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
            ComposerKt.sourceInformationMarkerStart(composer, 735357546, "C1042@38909L541,1055@39463L1193:CartSheet.kt#1sewlp");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1080174438, "C1043@38955L226,1049@39198L238:CartSheet.kt#1sewlp");
            TextKt.m2798Text4IGK_g(cartLine.getName(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowTitle(), 0L, 0L, FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 0, 3120, 55294);
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.qf(Double.valueOf(cartLine.getQty())) + " " + str + " × " + Fmt.INSTANCE.nf(Double.valueOf(cartLine.getPrice())), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(2.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowSub(), 0L, 0L, FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 48, 0, 65532);
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
            ComposerKt.sourceInformationMarkerStart(composer, 582354899, "C1068@40027L197:CartSheet.kt#1sewlp");
            if (cartLine.getDiscount() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                composer.startReplaceGroup(582377993);
                ComposerKt.sourceInformation(composer, "1057@39570L422");
                str2 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                str3 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                TextKt.m2798Text4IGK_g(Fmt.INSTANCE.nf(Double.valueOf(cartLine.getPrice() * cartLine.getQty())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), Ox.INSTANCE.m10200getDim20d7_KjU(), TextUnitKt.getSp(11.5d), FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, TextDecoration.INSTANCE.getLineThrough(), null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16773112, null), composer, 0, 3072, 57342);
                composer.endReplaceGroup();
            } else {
                str2 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                str3 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                composer.startReplaceGroup(582801391);
                composer.endReplaceGroup();
            }
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.nf(Double.valueOf(cartLine.getSum())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowPrice(), 0L, TextUnitKt.getSp(15), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 0, 3072, 57342);
            Composer composer2 = composer;
            if (d != null) {
                composer2.startReplaceGroup(583082778);
                ComposerKt.sourceInformation(composer2, "1074@40283L341");
                str4 = " ";
                str5 = str2;
                TextKt.m2798Text4IGK_g(Fmt.INSTANCE.nf(d), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getChip(), Ox.INSTANCE.m10202getGreenDeep0d7_KjU(), TextUnitKt.getSp(11.5d), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 0, 3072, 57342);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                str4 = " ";
                str5 = str2;
                composer2.startReplaceGroup(583428335);
                composer2.endReplaceGroup();
            }
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
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer2, 6);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, centerVertically, composer2, 54);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str5);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, fillMaxWidth$default2);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            String str6 = str3;
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str6);
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
            Updater.m3815setimpl(m3808constructorimpl4, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl4.getInserting() || !Intrinsics.areEqual(m3808constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m3808constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m3808constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3815setimpl(m3808constructorimpl4, materializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1795259171, "C1095@40981L1118,1124@42244L267,1124@42168L343,1133@42524L322:CartSheet.kt#1sewlp");
            Modifier m1049padding3ABfNKs = PaddingKt.m1049padding3ABfNKs(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), StepPillShape), Ox.INSTANCE.m10237getTrackPill0d7_KjU(), null, 2, null), Dp.m6989constructorimpl(3.0f));
            Arrangement.HorizontalOrVertical m930spacedBy0680j_43 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(4.0f));
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m930spacedBy0680j_43, centerVertically2, composer2, 54);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str5);
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer2, m1049padding3ABfNKs);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str6);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor5);
            } else {
                composer2.useNode();
            }
            Composer m3808constructorimpl5 = Updater.m3808constructorimpl(composer2);
            Updater.m3815setimpl(m3808constructorimpl5, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl5.getInserting() || !Intrinsics.areEqual(m3808constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                m3808constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                m3808constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m3815setimpl(m3808constructorimpl5, materializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -654908071, "C1104@41340L43,1109@41550L22,1105@41400L623,1120@42040L45:CartSheet.kt#1sewlp");
            m10125StepButtonRIQooxk("−", Ox.INSTANCE.m10217getPanel0d7_KjU(), Ox.INSTANCE.m10233getText0d7_KjU(), function03, composer2, 6);
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(ModifiersKt.oxTap(ClipKt.clip(RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), StepKeyShape), false, function04, composer, 0, 1), 0.0f, Dp.m6989constructorimpl(11.0f), 1, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, str5);
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(composer, m1051paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, str6);
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
            Updater.m3815setimpl(m3808constructorimpl6, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl6.getInserting() || !Intrinsics.areEqual(m3808constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                m3808constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                m3808constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
            }
            Updater.m3815setimpl(m3808constructorimpl6, materializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -669423040, "C1113@41721L284:CartSheet.kt#1sewlp");
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.qf(Double.valueOf(cartLine.getQty())) + str4 + str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowPrice(), 0L, TextUnitKt.getSp(13.5d), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 0, 3120, 55294);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            m10125StepButtonRIQooxk("+", Ox.INSTANCE.m10220getPrimary0d7_KjU(), Ox.INSTANCE.m10217getPanel0d7_KjU(), function05, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            m10126ToolButtonKlgxPg(Ox.INSTANCE.m10217getPanel0d7_KjU(), Ox.INSTANCE.m10189getBorder0d7_KjU(), function0, ComposableLambdaKt.rememberComposableLambda(1103962647, true, new Function2() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda48
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CartItemCard$lambda$0$1$1;
                    CartItemCard$lambda$0$1$1 = CartSheetKt.CartItemCard$lambda$0$1$1(CartLine.this, (Composer) obj, ((Integer) obj2).intValue());
                    return CartItemCard$lambda$0$1$1;
                }
            }, composer, 54), composer, 3072);
            m10126ToolButtonKlgxPg(Ox.INSTANCE.m10198getDangerSoft0d7_KjU(), Ox.INSTANCE.m10197getDangerBorder0d7_KjU(), function02, ComposableSingletons$CartSheetKt.INSTANCE.m10127getLambda$525702002$app(), composer, 3072);
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
    public static final Unit CartItemCard$lambda$0$1$1(CartLine cartLine, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1125@42262L235:CartSheet.kt#1sewlp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1103962647, i, -1, "uz.FonRo.pos.ui.sale.CartItemCard.<anonymous>.<anonymous>.<anonymous> (CartSheet.kt:1125)");
            }
            TextKt.m2798Text4IGK_g("%", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getButton(), cartLine.getDiscount() > AudioStats.AUDIO_AMPLITUDE_NONE ? Ox.INSTANCE.m10219getPink0d7_KjU() : Ox.INSTANCE.m10199getDim0d7_KjU(), TextUnitKt.getSp(15), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), composer, 6, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* renamed from: StepButton-RIQooxk, reason: not valid java name */
    private static final void m10125StepButtonRIQooxk(final String str, final long j, final long j2, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1488568029);
        ComposerKt.sourceInformation(startRestartGroup, "C(StepButton)P(3,0:c#ui.graphics.Color,1:c#ui.graphics.Color)1152@43112L24,1147@42973L335:CartSheet.kt#1sewlp");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1488568029, i3, -1, "uz.FonRo.pos.ui.sale.StepButton (CartSheet.kt:1146)");
            }
            Modifier oxTap = ModifiersKt.oxTap(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(42.0f)), StepKeyShape), j, null, 2, null), false, function0, startRestartGroup, (i3 >> 3) & 896, 1);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1530373154, "C1155@43198L104:CartSheet.kt#1sewlp");
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getNumpad(), j2, TextUnitKt.getSp(18), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), startRestartGroup, i3 & 14, 0, 65534);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda42
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CartSheetKt.StepButton_RIQooxk$lambda$1(str, j, j2, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* renamed from: ToolButton-Klgx-Pg, reason: not valid java name */
    private static final void m10126ToolButtonKlgxPg(final long j, final long j2, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-679626731);
        ComposerKt.sourceInformation(startRestartGroup, "C(ToolButton)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)1172@43640L24,1166@43459L282:CartSheet.kt#1sewlp");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if (!startRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-679626731, i2, -1, "uz.FonRo.pos.ui.sale.ToolButton (CartSheet.kt:1165)");
            }
            Modifier m1096size3ABfNKs = SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(42.0f));
            RoundedCornerShape roundedCornerShape = ToolShape;
            Modifier oxTap = ModifiersKt.oxTap(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(m1096size3ABfNKs, roundedCornerShape), j, null, 2, null), Dp.m6989constructorimpl(1.0f), j2, roundedCornerShape), false, function0, startRestartGroup, i2 & 896, 1);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 124413151, "C1175@43726L9:CartSheet.kt#1sewlp");
            function2.invoke(startRestartGroup, Integer.valueOf((i2 >> 9) & 14));
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda61
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CartSheetKt.ToolButton_Klgx_Pg$lambda$1(j, j2, function0, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void CustomerPickerSheet(final FonRoApp app, final Function1<? super Customer, Unit> onPick, final Function0<Unit> function0, Composer composer, final int i) {
        Composer composer2;
        final Function1<? super Customer, Unit> function1;
        final Function0<Unit> onDismiss = function0;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(onPick, "onPick");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(1029421668);
        ComposerKt.sourceInformation(startRestartGroup, "C(CustomerPickerSheet)P(!1,2)1190@44071L24,1191@44132L16,1193@44167L31,1194@44217L34,1195@44268L31,1196@44317L31,1197@44365L34,1199@44416L78,1235@46005L2621,1235@45897L2729:CartSheet.kt#1sewlp");
        int i2 = (i & 6) == 0 ? ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onPick) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 256 : 128;
        }
        int i3 = i2;
        if (startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1029421668, i3, -1, "uz.FonRo.pos.ui.sale.CustomerPickerSheet (CartSheet.kt:1188)");
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
            State collectAsState = SnapshotStateKt.collectAsState(repo.getCustomers(), null, startRestartGroup, 0, 1);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1431752675, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1431754278, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1431755907, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1431757475, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1431759014, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final MutableState mutableState5 = (MutableState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            List<Customer> CustomerPickerSheet$lambda$0 = CustomerPickerSheet$lambda$0(collectAsState);
            String CustomerPickerSheet$lambda$2 = CustomerPickerSheet$lambda$2(mutableState);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1431760690, "CC(remember):CartSheet.kt#9igjgp");
            boolean changed = startRestartGroup.changed(CustomerPickerSheet$lambda$0) | startRestartGroup.changed(CustomerPickerSheet$lambda$2);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                List<Customer> CustomerPickerSheet$lambda$02 = CustomerPickerSheet$lambda$0(collectAsState);
                ArrayList arrayList = new ArrayList();
                for (Object obj : CustomerPickerSheet$lambda$02) {
                    if (((Customer) obj).matches(CustomerPickerSheet$lambda$2(mutableState))) {
                        arrayList.add(obj);
                    }
                }
                rememberedValue7 = CollectionsKt.take(arrayList, 60);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final List list = (List) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            String tx = CustomerPickerSheet$lambda$5(mutableState2) ? LangKt.tx("Новый клиент", new Object[0]) : LangKt.tx("Клиент", new Object[0]);
            onDismiss = function0;
            composer2 = startRestartGroup;
            function1 = onPick;
            SheetsKt.OxCardSheet(tx, onDismiss, null, false, false, false, null, ComposableLambdaKt.rememberComposableLambda(1622196608, true, new Function3() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return CartSheetKt.CustomerPickerSheet$lambda$17(list, mutableState2, mutableState3, mutableState4, coroutineScope, repo, onPick, function0, mutableState5, mutableState, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, startRestartGroup, 54), composer2, ((i3 >> 3) & 112) | 12779520, 92);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            function1 = onPick;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return CartSheetKt.CustomerPickerSheet$lambda$18(FonRoApp.this, function1, onDismiss, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final String CustomerPickerSheet$lambda$2(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean CustomerPickerSheet$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CustomerPickerSheet$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CustomerPickerSheet$lambda$8(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CustomerPickerSheet$lambda$11(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean CustomerPickerSheet$lambda$14(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CustomerPickerSheet$lambda$15(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void CustomerPickerSheet$create(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, MutableState<String> mutableState2, Repo repo, Function1<? super Customer, Unit> function1, Function0<Unit> function0, MutableState<String> mutableState3) {
        if (CustomerPickerSheet$lambda$14(mutableState) || StringsKt.isBlank(CustomerPickerSheet$lambda$8(mutableState2))) {
            return;
        }
        CustomerPickerSheet$lambda$15(mutableState, true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CartSheetKt$CustomerPickerSheet$create$1(repo, function1, function0, mutableState2, mutableState3, mutableState, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CustomerPickerSheet$lambda$17(final List list, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final CoroutineScope coroutineScope, final Repo repo, final Function1 function1, final Function0 function0, final MutableState mutableState4, final MutableState mutableState5, ColumnScope OxCardSheet, Composer composer, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C1270@47163L807,1289@47979L11:CartSheet.kt#1sewlp");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1622196608, i, -1, "uz.FonRo.pos.ui.sale.CustomerPickerSheet.<anonymous> (CartSheet.kt:1236)");
            }
            if (CustomerPickerSheet$lambda$5(mutableState)) {
                composer.startReplaceGroup(-112808932);
                ComposerKt.sourceInformation(composer, "1240@46148L13,1237@46041L195,1246@46360L14,1243@46249L272,1251@46534L555,1266@47102L10");
                String tx = LangKt.tx("Имя*", new Object[0]);
                String CustomerPickerSheet$lambda$8 = CustomerPickerSheet$lambda$8(mutableState2);
                ComposerKt.sourceInformationMarkerStart(composer, -142183571, "CC(remember):CartSheet.kt#9igjgp");
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda80
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit CustomerPickerSheet$lambda$17$0$0;
                            CustomerPickerSheet$lambda$17$0$0 = CartSheetKt.CustomerPickerSheet$lambda$17$0$0(MutableState.this, (String) obj);
                            return CustomerPickerSheet$lambda$17$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                FieldsKt.m9846OxFieldDfSPO0(tx, CustomerPickerSheet$lambda$8, (Function1) rememberedValue, null, LangKt.tx("Как записать покупателя", new Object[0]), 0, 0, null, false, false, false, false, false, null, null, composer, 384, 0, 32744);
                String tx2 = LangKt.tx("Телефон", new Object[0]);
                String CustomerPickerSheet$lambda$11 = CustomerPickerSheet$lambda$11(mutableState3);
                ComposerKt.sourceInformationMarkerStart(composer, -142176786, "CC(remember):CartSheet.kt#9igjgp");
                Object rememberedValue2 = composer.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda81
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit CustomerPickerSheet$lambda$17$1$0;
                            CustomerPickerSheet$lambda$17$1$0 = CartSheetKt.CustomerPickerSheet$lambda$17$1$0(MutableState.this, (String) obj);
                            return CustomerPickerSheet$lambda$17$1$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                FieldsKt.m9846OxFieldDfSPO0(tx2, CustomerPickerSheet$lambda$11, (Function1) rememberedValue2, null, "+998", KeyboardType.INSTANCE.m6694getPhonePjHm6EE(), ImeAction.INSTANCE.m6635getDoneeUduSuo(), null, false, false, false, false, false, null, null, composer, 1794432, 0, 32648);
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
                ComposerKt.sourceInformationMarkerStart(composer, 384227666, "C1254@46673L18,1252@46609L196,1260@46889L12,1258@46822L253:CartSheet.kt#1sewlp");
                String tx3 = LangKt.tx("Отмена", new Object[0]);
                ComposerKt.sourceInformationMarkerStart(composer, 289490705, "CC(remember):CartSheet.kt#9igjgp");
                Object rememberedValue3 = composer.rememberedValue();
                if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda82
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CustomerPickerSheet$lambda$17$2$0$0;
                            CustomerPickerSheet$lambda$17$2$0$0 = CartSheetKt.CustomerPickerSheet$lambda$17$2$0$0(MutableState.this);
                            return CustomerPickerSheet$lambda$17$2$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                BasicsKt.OxButton(tx3, (Function0) rememberedValue3, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.GHOST, null, false, false, null, composer, 3120, 240);
                String tx4 = LangKt.tx("Сохранить", new Object[0]);
                ComposerKt.sourceInformationMarkerStart(composer, 289497611, "CC(remember):CartSheet.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(repo) | composer.changed(function1) | composer.changed(function0);
                Object rememberedValue4 = composer.rememberedValue();
                if (changedInstance || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    z = false;
                    Function0 function02 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda83
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CustomerPickerSheet$lambda$17$2$1$0;
                            CustomerPickerSheet$lambda$17$2$1$0 = CartSheetKt.CustomerPickerSheet$lambda$17$2$1$0(CoroutineScope.this, mutableState4, mutableState2, repo, function1, function0, mutableState3);
                            return CustomerPickerSheet$lambda$17$2$1$0;
                        }
                    };
                    composer.updateRememberedValue(function02);
                    rememberedValue4 = function02;
                } else {
                    z = false;
                }
                Function0 function03 = (Function0) rememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composer);
                BasicsKt.OxButton(tx4, function03, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.PRIMARY, null, (CustomerPickerSheet$lambda$14(mutableState4) || StringsKt.isBlank(CustomerPickerSheet$lambda$8(mutableState2))) ? z : true, false, null, composer, 3072, 208);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer, 6);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
            composer.startReplaceGroup(-111726846);
            composer.endReplaceGroup();
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, centerVertically, composer, 54);
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
            ComposerKt.sourceInformationMarkerStart(composer, -887712470, "C1277@47439L14,1275@47363L203:CartSheet.kt#1sewlp");
            String CustomerPickerSheet$lambda$2 = CustomerPickerSheet$lambda$2(mutableState5);
            ComposerKt.sourceInformationMarkerStart(composer, -859918030, "CC(remember):CartSheet.kt#9igjgp");
            Object rememberedValue5 = composer.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda84
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit CustomerPickerSheet$lambda$17$3$0$0;
                        CustomerPickerSheet$lambda$17$3$0$0 = CartSheetKt.CustomerPickerSheet$lambda$17$3$0$0(MutableState.this, (String) obj);
                        return CustomerPickerSheet$lambda$17$3$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Composer composer2 = composer;
            FieldsKt.OxSearchBox(CustomerPickerSheet$lambda$2, (Function1) rememberedValue5, RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), LangKt.tx("Поиск клиента", new Object[0]), null, composer2, 48, 16);
            if (repo.can(Perm.MANAGE_CUSTOMERS)) {
                composer2.startReplaceGroup(-887335759);
                ComposerKt.sourceInformation(composer2, "1284@47796L17,1284@47773L173");
                ComposerKt.sourceInformationMarkerStart(composer2, -859906603, "CC(remember):CartSheet.kt#9igjgp");
                Object rememberedValue6 = composer2.rememberedValue();
                if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue6 = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda85
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CustomerPickerSheet$lambda$17$3$1$0;
                            CustomerPickerSheet$lambda$17$3$1$0 = CartSheetKt.CustomerPickerSheet$lambda$17$3$1$0(MutableState.this);
                            return CustomerPickerSheet$lambda$17$3$1$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BasicsKt.m9831OxIconButtonhGBTI10((Function0) rememberedValue6, null, null, 0.0f, ComposableSingletons$CartSheetKt.INSTANCE.getLambda$931192740$app(), composer, 24582, 14);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-887138754);
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer2, 6);
            if (list.isEmpty()) {
                composer2.startReplaceGroup(-110864922);
                ComposerKt.sourceInformation(composer2, "1292@48034L36");
                BasicsKt.OxEmptyNote(LangKt.tx("Никого не нашлось", new Object[0]), null, composer2, 0, 2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-110784756);
                ComposerKt.sourceInformation(composer2, "1294@48146L21,1294@48100L510");
                Modifier verticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composer2, 0, 1), false, null, false, 14, null);
                ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, verticalScroll$default);
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
                Updater.m3815setimpl(m3808constructorimpl3, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -1590927238, "C1295@48195L374,1295@48188L381,1305@48586L10:CartSheet.kt#1sewlp");
                BasicsKt.OxList(null, ComposableLambdaKt.rememberComposableLambda(-1365497578, true, new Function3() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda86
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit CustomerPickerSheet$lambda$17$4$0;
                        CustomerPickerSheet$lambda$17$4$0 = CartSheetKt.CustomerPickerSheet$lambda$17$4$0(list, function1, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return CustomerPickerSheet$lambda$17$4$0;
                    }
                }, composer2, 54), composer2, 48, 1);
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer2, 6);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomerPickerSheet$lambda$17$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomerPickerSheet$lambda$17$1$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomerPickerSheet$lambda$17$2$0$0(MutableState mutableState) {
        CustomerPickerSheet$lambda$6(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomerPickerSheet$lambda$17$2$1$0(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, Repo repo, Function1 function1, Function0 function0, MutableState mutableState3) {
        CustomerPickerSheet$create(coroutineScope, mutableState, mutableState2, repo, function1, function0, mutableState3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomerPickerSheet$lambda$17$3$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomerPickerSheet$lambda$17$3$1$0(MutableState mutableState) {
        CustomerPickerSheet$lambda$6(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomerPickerSheet$lambda$17$4$0(List list, final Function1 function1, ColumnScope OxList, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(OxList, "$this$OxList");
        ComposerKt.sourceInformation(composer2, "C*1300@48425L16,1297@48278L251:CartSheet.kt#1sewlp");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1365497578, i, -1, "uz.FonRo.pos.ui.sale.CustomerPickerSheet.<anonymous>.<anonymous>.<anonymous> (CartSheet.kt:1296)");
            }
            int i2 = 0;
            for (Object obj : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final Customer customer = (Customer) obj;
                String fullName = customer.getFullName();
                String phone = customer.getPhone();
                ComposerKt.sourceInformationMarkerStart(composer2, -503402977, "CC(remember):CartSheet.kt#9igjgp");
                boolean changed = composer2.changed(function1) | composer2.changedInstance(customer);
                Object rememberedValue = composer2.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.sale.CartSheetKt$$ExternalSyntheticLambda79
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CustomerPickerSheet$lambda$17$4$0$0$0$0;
                            CustomerPickerSheet$lambda$17$4$0$0$0$0 = CartSheetKt.CustomerPickerSheet$lambda$17$4$0$0$0$0(Function1.this, customer);
                            return CustomerPickerSheet$lambda$17$4$0$0$0$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                Function0 function0 = (Function0) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BasicsKt.m9832OxRow1YH7lEI(fullName, null, phone, function0, i2 < CollectionsKt.getLastIndex(list), 0L, null, null, composer2, 0, 226);
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
    public static final Unit CustomerPickerSheet$lambda$17$4$0$0$0$0(Function1 function1, Customer customer) {
        function1.invoke(customer);
        return Unit.INSTANCE;
    }

    private static final CartState CartSheet$lambda$0(State<CartState> state) {
        return state.getValue();
    }

    private static final List<Customer> CartSheet$lambda$1(State<? extends List<Customer>> state) {
        return state.getValue();
    }

    private static final CartState PaySheet$lambda$0(State<CartState> state) {
        return state.getValue();
    }

    private static final List<Customer> PaySheet$lambda$1(State<? extends List<Customer>> state) {
        return state.getValue();
    }

    private static final List<Customer> CustomerPickerSheet$lambda$0(State<? extends List<Customer>> state) {
        return state.getValue();
    }
}
