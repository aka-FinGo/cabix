package uz.FonRo.pos.ui.clients;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.PointerIconCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.enums.EnumEntries;
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
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.data.model.Customer;
import uz.FonRo.pos.data.model.DebtPayment;
import uz.FonRo.pos.data.model.DebtSale;
import uz.FonRo.pos.data.model.PayType;
import uz.FonRo.pos.data.model.SaleRow;
import uz.FonRo.pos.data.model.SyncData;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnSize;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.ChipsKt;
import uz.FonRo.pos.ui.components.FieldsKt;
import uz.FonRo.pos.ui.components.ModifiersKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.nav.Routes;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxDim;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: ClientsScreen.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007b\u0002\b\u0005b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0004\u001a=\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0003b\u0002\b\u0005b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0010\u001a;\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0003b\u0002\b\u0005b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b\u0018\u0010\u0019\u001aG\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0003b\u0002\b\u0005b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010 \u001a\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0013H\u0002\u001a;\u0010#\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\r2\b\b\u0002\u0010%\u001a\u00020&H\u0003b\u0002\b\u0005b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b'\u0010(\u001a\u0018\u0010)\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0013H\u0002\u001aa\u0010-\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/2\u0006\u0010\f\u001a\u00020\r2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0003b\u0002\b\u0005b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u00103\u001a0\u00104\u001a\b\u0012\u0004\u0012\u0002050/2\f\u00106\u001a\b\u0012\u0004\u0012\u0002070/2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u001e09H\u0002\u001a/\u0010;\u001a\u00020\u00012\u0006\u0010<\u001a\u0002052\u0006\u0010=\u001a\u00020\u0013H\u0003b\u0002\b\u0005b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010>\u001a/\u0010?\u001a\u00020\u00012\u0006\u0010@\u001a\u00020A2\u0006\u0010=\u001a\u00020\u0013H\u0003b\u0002\b\u0005b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010B\u001a=\u0010C\u001a\u00020\u0001*\u00020D2\u0006\u0010E\u001a\u00020\u00132\u0006\u0010F\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0003b\u0002\b\u0005b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\bG\u0010H\u001a9\u0010I\u001a\u00020\u00012\u0006\u0010E\u001a\u00020\u00132\u0006\u0010F\u001a\u00020\u00132\b\b\u0002\u0010J\u001a\u00020\rH\u0003b\u0002\b\u0005b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010K\u001a?\u0010L\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0003b\u0002\b\u0005b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010M¨\u0006\u0002²\u0006\u0010\u0010N\u001a\b\u0012\u0004\u0012\u00020\u001c0/X\u008a\u0084\u0002²\u0006\n\u0010O\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010P\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\u0010\u0010Q\u001a\b\u0012\u0004\u0012\u0002000/X\u008a\u008e\u0002²\u0006\f\u0010R\u001a\u0004\u0018\u00010:X\u008a\u008e\u0002²\u0006\n\u0010S\u001a\u00020\rX\u008a\u008e\u0002²\u0006\f\u0010T\u001a\u0004\u0018\u00010\u001cX\u008a\u008e\u0002²\u0006\f\u0010U\u001a\u0004\u0018\u00010VX\u008a\u0084\u0002²\u0006\u0012\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010/X\u008a\u008e\u0002²\u0006\n\u0010W\u001a\u00020\rX\u008a\u008e\u0002²\u0006\n\u0010X\u001a\u00020YX\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010,\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010Z\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010[\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010\\\u001a\u00020\rX\u008a\u008e\u0002"}, d2 = {"ClientsScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "(Luz/FonRo/pos/FonRoApp;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "ClientsHero", "count", "", "canManage", "", "onAdd", "Lkotlin/Function0;", "(IZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ClientPill", "text", "", "tint", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "ClientPill-3IgeMak", "(Ljava/lang/String;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ClientRow", "customer", "Luz/FonRo/pos/data/model/Customer;", "debt", "", "onClick", "(Luz/FonRo/pos/data/model/Customer;DLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "initialsOf", "name", "ClientAvatar", "hasDebt", "size", "Landroidx/compose/ui/unit/Dp;", "ClientAvatar-6a0pyJM", "(Ljava/lang/String;ZFLandroidx/compose/runtime/Composer;II)V", "dial", "context", "Landroid/content/Context;", HintConstants.AUTOFILL_HINT_PHONE, "ClientCardSheet", Routes.DEBTS, "", "Luz/FonRo/pos/data/model/DebtSale;", "onDismiss", "onEdit", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/data/model/Customer;Ljava/util/List;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "receiptsOf", "Luz/FonRo/pos/ui/clients/ClientReceipt;", "rows", "Luz/FonRo/pos/data/model/SaleRow;", "debtBySale", "", "", "ReceiptCard", "receipt", FirebaseAnalytics.Param.CURRENCY, "(Luz/FonRo/pos/ui/clients/ClientReceipt;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "PaymentCard", "payment", "Luz/FonRo/pos/data/model/DebtPayment;", "(Luz/FonRo/pos/data/model/DebtPayment;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "MetricTile", "Landroidx/compose/foundation/layout/RowScope;", "label", "value", "MetricTile-Bx497Mc", "(Landroidx/compose/foundation/layout/RowScope;Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/runtime/Composer;I)V", "InfoLine", "divider", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/runtime/Composer;II)V", "ClientFormSheet", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/data/model/Customer;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "customers", SearchIntents.EXTRA_QUERY, "applied", "debtSales", "cardId", "formOpen", "formCustomer", "sync", "Luz/FonRo/pos/data/model/SyncData;", "loading", "tab", "Luz/FonRo/pos/ui/clients/ClientTab;", "address", "note", "busy"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ClientsScreenKt {

    /* compiled from: ClientsScreen.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes7.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ClientTab.values().length];
            try {
                iArr[ClientTab.PURCHASES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ClientTab.PAYMENTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClientAvatar_6a0pyJM$lambda$1(String str, boolean z, float f, int i, int i2, Composer composer, int i3) {
        m9825ClientAvatar6a0pyJM(str, z, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClientCardSheet$lambda$20(FonRoApp FonRoApp, Customer customer, List list, boolean z, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        ClientCardSheet(FonRoApp, customer, list, z, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClientFormSheet$lambda$17(FonRoApp FonRoApp, Customer customer, Function0 function0, int i, Composer composer, int i2) {
        ClientFormSheet(FonRoApp, customer, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClientPill_3IgeMak$lambda$0(String str, long j, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m9826ClientPill3IgeMak(str, j, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClientRow$lambda$2(Customer customer, double d, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ClientRow(customer, d, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClientsHero$lambda$1(int i, boolean z, Function0 function0, int i2, Composer composer, int i3) {
        ClientsHero(i, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClientsScreen$lambda$29(FonRoApp FonRoApp, int i, Composer composer, int i2) {
        ClientsScreen(FonRoApp, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit InfoLine$lambda$1(String str, String str2, boolean z, int i, int i2, Composer composer, int i3) {
        InfoLine(str, str2, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MetricTile_Bx497Mc$lambda$1(RowScope rowScope, String str, String str2, long j, int i, Composer composer, int i2) {
        m9827MetricTileBx497Mc(rowScope, str, str2, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PaymentCard$lambda$1(DebtPayment debtPayment, String str, int i, Composer composer, int i2) {
        PaymentCard(debtPayment, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReceiptCard$lambda$1(ClientReceipt clientReceipt, String str, int i, Composer composer, int i2) {
        ReceiptCard(clientReceipt, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ClientsScreen(FonRoApp FonRoApp, Composer composer, final int i) {
        Composer composer2;
        boolean z;
        Object obj;
        Customer customer;
        MutableState mutableState;
        boolean z2;
        State state;
        final MutableState mutableState2;
        final MutableState mutableState3;
        final Customer customer2;
        MutableState mutableState4;
        int i2;
        final MutableState mutableState5;
        Object obj2;
        final FonRoApp app = FonRoApp;
        Intrinsics.checkNotNullParameter(app, "app");
        Composer startRestartGroup = composer.startRestartGroup(-1861928142);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClientsScreen)92@3838L29,97@3982L31,98@4033L31,100@4172L50,100@4150L72,115@4798L56,116@4880L182,122@5089L565,122@5068L586,135@5739L275,143@6034L40,144@6095L34,145@6154L44,150@6356L1431,147@6204L1583:ClientsScreen.kt#n7o21o");
        int i3 = (i & 6) == 0 ? i | ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2) : i;
        boolean z3 = false;
        if (!startRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1861928142, i3, -1, "uz.FonRo.pos.ui.clients.ClientsScreen (ClientsScreen.kt:90)");
            }
            Repo repo = app.getRepo();
            final State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(repo.getCustomers(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            final boolean can = repo.can(Perm.MANAGE_CUSTOMERS);
            boolean can2 = repo.can(Perm.SELL_DEBT);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1688425681, "CC(remember):ClientsScreen.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState6 = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1688427313, "CC(remember):ClientsScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState7 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            String ClientsScreen$lambda$2 = ClientsScreen$lambda$2(mutableState6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1688431780, "CC(remember):ClientsScreen.kt#9igjgp");
            ClientsScreenKt$ClientsScreen$1$1 rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new ClientsScreenKt$ClientsScreen$1$1(mutableState6, mutableState7, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(ClientsScreen$lambda$2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1688451818, "CC(remember):ClientsScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            MutableState mutableState8 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            List<DebtSale> ClientsScreen$lambda$9 = ClientsScreen$lambda$9(mutableState8);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1688454568, "CC(remember):ClientsScreen.kt#9igjgp");
            boolean changed = startRestartGroup.changed(ClientsScreen$lambda$9);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                List<DebtSale> ClientsScreen$lambda$92 = ClientsScreen$lambda$9(mutableState8);
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : ClientsScreen$lambda$92) {
                    boolean z4 = z3;
                    if (((DebtSale) obj3).getCustomerId() > 0) {
                        arrayList.add(obj3);
                    }
                    z3 = z4;
                }
                z = z3;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj4 : arrayList) {
                    Long valueOf = Long.valueOf(((DebtSale) obj4).getCustomerId());
                    Object obj5 = linkedHashMap.get(valueOf);
                    if (obj5 == null) {
                        ArrayList arrayList2 = new ArrayList();
                        linkedHashMap.put(valueOf, arrayList2);
                        obj5 = arrayList2;
                    }
                    ((List) obj5).add(obj4);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    Object key = entry.getKey();
                    Iterator it = ((List) entry.getValue()).iterator();
                    double d = AudioStats.AUDIO_AMPLITUDE_NONE;
                    while (it.hasNext()) {
                        d += ((DebtSale) it.next()).getDebtAmount();
                    }
                    linkedHashMap2.put(key, Double.valueOf(d));
                }
                startRestartGroup.updateRememberedValue(linkedHashMap2);
                obj = linkedHashMap2;
            } else {
                z = false;
                obj = rememberedValue5;
            }
            final Map map = (Map) obj;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1688461639, "CC(remember):ClientsScreen.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(repo) | startRestartGroup.changed(can2);
            ClientsScreenKt$ClientsScreen$2$1 rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = new ClientsScreenKt$ClientsScreen$2$1(can2, repo, mutableState8, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue6, startRestartGroup, 6);
            List<Customer> ClientsScreen$lambda$0 = ClientsScreen$lambda$0(collectAsStateWithLifecycle);
            String ClientsScreen$lambda$5 = ClientsScreen$lambda$5(mutableState7);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1688482149, "CC(remember):ClientsScreen.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(ClientsScreen$lambda$0) | startRestartGroup.changed(ClientsScreen$lambda$5) | startRestartGroup.changed(map);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                List<Customer> ClientsScreen$lambda$02 = ClientsScreen$lambda$0(collectAsStateWithLifecycle);
                ArrayList arrayList3 = new ArrayList();
                for (Object obj6 : ClientsScreen$lambda$02) {
                    if (((Customer) obj6).matches(ClientsScreen$lambda$5(mutableState7))) {
                        arrayList3.add(obj6);
                    }
                }
                final Comparator comparator = new Comparator() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$ClientsScreen$lambda$13$$inlined$compareByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        Double d2 = (Double) map.get(Long.valueOf(((Customer) t2).getId()));
                        Double valueOf2 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
                        Double d3 = d2 != null ? d2 : valueOf2;
                        Double d4 = (Double) map.get(Long.valueOf(((Customer) t).getId()));
                        return ComparisonsKt.compareValues(d3, d4 != null ? d4 : valueOf2);
                    }
                };
                rememberedValue7 = CollectionsKt.sortedWith(arrayList3, new Comparator() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$ClientsScreen$lambda$13$$inlined$thenBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int compare = comparator.compare(t, t2);
                        if (compare != 0) {
                            return compare;
                        }
                        String lowerCase = ((Customer) t).getFullName().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        String lowerCase2 = ((Customer) t2).getFullName().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final List list = (List) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1688491354, "CC(remember):ClientsScreen.kt#9igjgp");
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            final MutableState mutableState9 = (MutableState) rememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1688493300, "CC(remember):ClientsScreen.kt#9igjgp");
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                rememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            final MutableState mutableState10 = (MutableState) rememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1688495198, "CC(remember):ClientsScreen.kt#9igjgp");
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                customer = null;
                rememberedValue10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            } else {
                customer = null;
            }
            final MutableState mutableState11 = (MutableState) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, customer), OxDim.INSTANCE.m10245getPagePadD9Ej5fM(), 0.0f, 2, customer);
            PaddingValues m1046PaddingValuesa9UjIt4$default = PaddingKt.m1046PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(28.0f), 7, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1688503049, "CC(remember):ClientsScreen.kt#9igjgp");
            boolean changed3 = startRestartGroup.changed(collectAsStateWithLifecycle) | startRestartGroup.changed(can) | startRestartGroup.changedInstance(list) | startRestartGroup.changedInstance(map);
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj7) {
                        Unit ClientsScreen$lambda$23$0;
                        ClientsScreen$lambda$23$0 = ClientsScreenKt.ClientsScreen$lambda$23$0(list, can, collectAsStateWithLifecycle, mutableState11, mutableState10, mutableState6, map, mutableState9, (LazyListScope) obj7);
                        return ClientsScreen$lambda$23$0;
                    }
                };
                mutableState = mutableState8;
                rememberedValue11 = function1;
                z2 = can;
                state = collectAsStateWithLifecycle;
                mutableState2 = mutableState10;
                mutableState3 = mutableState9;
                startRestartGroup.updateRememberedValue(rememberedValue11);
            } else {
                state = collectAsStateWithLifecycle;
                mutableState3 = mutableState9;
                mutableState = mutableState8;
                z2 = can;
                mutableState2 = mutableState10;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LazyDslKt.LazyColumn(m1051paddingVpY3zN4$default, null, m1046PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) rememberedValue11, startRestartGroup, 384, TypedValues.PositionType.TYPE_PERCENT_X);
            Composer composer3 = startRestartGroup;
            Long ClientsScreen$lambda$15 = ClientsScreen$lambda$15(mutableState3);
            if (ClientsScreen$lambda$15 != null) {
                long longValue = ClientsScreen$lambda$15.longValue();
                Iterator<T> it2 = ClientsScreen$lambda$0(state).iterator();
                while (true) {
                    if (it2.hasNext()) {
                        obj2 = it2.next();
                        if (((Customer) obj2).getId() == longValue) {
                            break;
                        }
                    } else {
                        obj2 = customer;
                        break;
                    }
                }
                customer2 = (Customer) obj2;
            } else {
                customer2 = customer;
            }
            if (customer2 != null) {
                composer3.startReplaceGroup(805555197);
                ComposerKt.sourceInformation(composer3, "208@8181L17,209@8221L42,203@7982L291");
                List<DebtSale> ClientsScreen$lambda$93 = ClientsScreen$lambda$9(mutableState);
                ArrayList arrayList4 = new ArrayList();
                for (Object obj7 : ClientsScreen$lambda$93) {
                    if (((DebtSale) obj7).getCustomerId() == customer2.getId()) {
                        arrayList4.add(obj7);
                    }
                }
                ArrayList arrayList5 = arrayList4;
                ComposerKt.sourceInformationMarkerStart(composer3, 1688560035, "CC(remember):ClientsScreen.kt#9igjgp");
                Object rememberedValue12 = composer3.rememberedValue();
                if (rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue12 = new Function0() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ClientsScreen$lambda$26$0;
                            ClientsScreen$lambda$26$0 = ClientsScreenKt.ClientsScreen$lambda$26$0(MutableState.this);
                            return ClientsScreen$lambda$26$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue12);
                }
                Function0 function0 = (Function0) rememberedValue12;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, 1688561340, "CC(remember):ClientsScreen.kt#9igjgp");
                boolean changedInstance2 = composer3.changedInstance(customer2);
                Object rememberedValue13 = composer3.rememberedValue();
                if (changedInstance2 || rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue13 = new Function0() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ClientsScreen$lambda$27$0;
                            ClientsScreen$lambda$27$0 = ClientsScreenKt.ClientsScreen$lambda$27$0(Customer.this, mutableState11, mutableState2);
                            return ClientsScreen$lambda$27$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue13);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                mutableState4 = mutableState11;
                mutableState5 = mutableState2;
                app = FonRoApp;
                i2 = i3;
                ClientCardSheet(app, customer2, arrayList5, z2, function0, (Function0) rememberedValue13, composer3, FonRoApp.$stable | 24576 | (i3 & 14) | (Customer.$stable << 3));
                composer3.endReplaceGroup();
            } else {
                mutableState4 = mutableState11;
                i2 = i3;
                mutableState5 = mutableState2;
                app = FonRoApp;
                composer3.startReplaceGroup(805850224);
                composer3.endReplaceGroup();
            }
            if (ClientsScreen$lambda$18(mutableState5)) {
                composer3.startReplaceGroup(805874621);
                ComposerKt.sourceInformation(composer3, "217@8410L20,214@8309L131");
                Customer ClientsScreen$lambda$21 = ClientsScreen$lambda$21(mutableState4);
                ComposerKt.sourceInformationMarkerStart(composer3, 1688567366, "CC(remember):ClientsScreen.kt#9igjgp");
                Object rememberedValue14 = composer3.rememberedValue();
                if (rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue14 = new Function0() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ClientsScreen$lambda$28$0;
                            ClientsScreen$lambda$28$0 = ClientsScreenKt.ClientsScreen$lambda$28$0(MutableState.this);
                            return ClientsScreen$lambda$28$0;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue14);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ClientFormSheet(app, ClientsScreen$lambda$21, (Function0) rememberedValue14, composer3, FonRoApp.$stable | 384 | (i2 & 14) | (Customer.$stable << 3));
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(806015888);
                composer3.endReplaceGroup();
            }
            composer2 = composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                composer2 = composer3;
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj8, Object obj9) {
                    return ClientsScreenKt.ClientsScreen$lambda$29(FonRoApp.this, i, (Composer) obj8, ((Integer) obj9).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ClientsScreen$lambda$2(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String ClientsScreen$lambda$5(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final List<DebtSale> ClientsScreen$lambda$9(MutableState<List<DebtSale>> mutableState) {
        return mutableState.getValue();
    }

    private static final Long ClientsScreen$lambda$15(MutableState<Long> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ClientsScreen$lambda$18(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ClientsScreen$lambda$19(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Customer ClientsScreen$lambda$21(MutableState<Customer> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClientsScreen$lambda$23$0(final List list, final boolean z, final State state, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final Map map, final MutableState mutableState4, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$ClientsScreenKt.INSTANCE.getLambda$1201212999$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1878274754, true, new Function3() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit ClientsScreen$lambda$23$0$0;
                ClientsScreen$lambda$23$0$0 = ClientsScreenKt.ClientsScreen$lambda$23$0$0(z, state, mutableState, mutableState2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return ClientsScreen$lambda$23$0$0;
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(482486143, true, new Function3() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit ClientsScreen$lambda$23$0$1;
                ClientsScreen$lambda$23$0$1 = ClientsScreenKt.ClientsScreen$lambda$23$0$1(MutableState.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return ClientsScreen$lambda$23$0$1;
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1451720256, true, new Function3() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit ClientsScreen$lambda$23$0$2;
                ClientsScreen$lambda$23$0$2 = ClientsScreenKt.ClientsScreen$lambda$23$0$2(list, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return ClientsScreen$lambda$23$0$2;
            }
        }), 3, null);
        if (list.isEmpty()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-67622814, true, new Function3() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ClientsScreen$lambda$23$0$3;
                    ClientsScreen$lambda$23$0$3 = ClientsScreenKt.ClientsScreen$lambda$23$0$3(State.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ClientsScreen$lambda$23$0$3;
                }
            }), 3, null);
        }
        final Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object ClientsScreen$lambda$23$0$4;
                ClientsScreen$lambda$23$0$4 = ClientsScreenKt.ClientsScreen$lambda$23$0$4((Customer) obj);
                return ClientsScreen$lambda$23$0$4;
            }
        };
        final ClientsScreenKt$ClientsScreen$lambda$23$0$$inlined$items$default$1 clientsScreenKt$ClientsScreen$lambda$23$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$ClientsScreen$lambda$23$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Customer customer) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Customer) obj);
            }
        };
        LazyColumn.items(list.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$ClientsScreen$lambda$23$0$$inlined$items$default$2
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
        }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$ClientsScreen$lambda$23$0$$inlined$items$default$3
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
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$ClientsScreen$lambda$23$0$$inlined$items$default$4
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
                final Customer customer = (Customer) list.get(i);
                composer.startReplaceGroup(1300412794);
                ComposerKt.sourceInformation(composer, "C*194@7680L17,191@7561L210:ClientsScreen.kt#n7o21o");
                Double d = (Double) map.get(Long.valueOf(customer.getId()));
                double doubleValue = d != null ? d.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
                ComposerKt.sourceInformationMarkerStart(composer, 1427425736, "CC(remember):ClientsScreen.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(customer);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState5 = mutableState4;
                    rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$ClientsScreen$3$1$6$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            mutableState5.setValue(Long.valueOf(Customer.this.getId()));
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ClientsScreenKt.ClientRow(customer, doubleValue, (Function0) rememberedValue, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(8.0f), 7, null), composer, Customer.$stable | 3072, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClientsScreen$lambda$23$0$0(boolean z, State state, final MutableState mutableState, final MutableState mutableState2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C154@6429L259:ClientsScreen.kt#n7o21o");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1878274754, i, -1, "uz.FonRo.pos.ui.clients.ClientsScreen.<anonymous>.<anonymous>.<anonymous> (ClientsScreen.kt:154)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -488461163, "C158@6616L40,155@6488L186:ClientsScreen.kt#n7o21o");
            int size = ClientsScreen$lambda$0(state).size();
            ComposerKt.sourceInformationMarkerStart(composer, 1923909788, "CC(remember):ClientsScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ClientsScreen$lambda$23$0$0$0$0$0;
                        ClientsScreen$lambda$23$0$0$0$0$0 = ClientsScreenKt.ClientsScreen$lambda$23$0$0$0$0$0(MutableState.this, mutableState2);
                        return ClientsScreen$lambda$23$0$0$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ClientsHero(size, z, (Function0) rememberedValue, composer, 384);
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
    public static final Unit ClientsScreen$lambda$23$0$0$0$0$0(MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(null);
        ClientsScreen$lambda$19(mutableState2, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClientsScreen$lambda$23$0$1(final MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C164@6727L257:ClientsScreen.kt#n7o21o");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(482486143, i, -1, "uz.FonRo.pos.ui.clients.ClientsScreen.<anonymous>.<anonymous>.<anonymous> (ClientsScreen.kt:164)");
            }
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(4.0f), 7, null);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1150050667, "C167@6869L14,165@6785L185:ClientsScreen.kt#n7o21o");
            String ClientsScreen$lambda$2 = ClientsScreen$lambda$2(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, -1422569213, "CC(remember):ClientsScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda38
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ClientsScreen$lambda$23$0$1$0$0$0;
                        ClientsScreen$lambda$23$0$1$0$0$0 = ClientsScreenKt.ClientsScreen$lambda$23$0$1$0$0$0(MutableState.this, (String) obj);
                        return ClientsScreen$lambda$23$0$1$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.OxSearchBox(ClientsScreen$lambda$2, (Function1) rememberedValue, null, LangKt.tx("Поиск по имени или телефону", new Object[0]), null, composer, 48, 20);
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
    public static final Unit ClientsScreen$lambda$23$0$1$0$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClientsScreen$lambda$23$0$2(List list, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C174@7023L190:ClientsScreen.kt#n7o21o");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1451720256, i, -1, "uz.FonRo.pos.ui.clients.ClientsScreen.<anonymous>.<anonymous>.<anonymous> (ClientsScreen.kt:174)");
            }
            BasicsKt.OxSectionHead(LangKt.tx("Список клиентов", new Object[0]), null, LangKt.tx("Карточка клиента — тап по строке", new Object[0]), String.valueOf(list.size()), null, null, composer, 0, 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClientsScreen$lambda$23$0$3(State state, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C183@7293L183:ClientsScreen.kt#n7o21o");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-67622814, i, -1, "uz.FonRo.pos.ui.clients.ClientsScreen.<anonymous>.<anonymous>.<anonymous> (ClientsScreen.kt:183)");
            }
            BasicsKt.OxEmptyNote(ClientsScreen$lambda$0(state).isEmpty() ? LangKt.tx("Клиентов пока нет. Добавьте первого кнопкой выше.", new Object[0]) : LangKt.tx("Клиентов не найдено.", new Object[0]), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ClientsScreen$lambda$23$0$4(Customer it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClientsScreen$lambda$26$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClientsScreen$lambda$27$0(Customer customer, MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(customer);
        ClientsScreen$lambda$19(mutableState2, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClientsScreen$lambda$28$0(MutableState mutableState) {
        ClientsScreen$lambda$19(mutableState, false);
        return Unit.INSTANCE;
    }

    private static final void ClientsHero(final int i, boolean z, Function0<Unit> function0, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        final boolean z2 = z;
        final Function0<Unit> function02 = function0;
        Composer startRestartGroup = composer.startRestartGroup(663284359);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClientsHero)P(1)231@8761L1933:ClientsScreen.kt#n7o21o");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(663284359, i3, -1, "uz.FonRo.pos.ui.clients.ClientsHero (ClientsScreen.kt:225)");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1655296289, "C239@8985L577,255@9571L11,256@9591L1097:ClientsScreen.kt#n7o21o");
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1248721516, "C244@9186L318,253@9517L35:ClientsScreen.kt#n7o21o");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -426128566, "C245@9232L41,246@9290L200:ClientsScreen.kt#n7o21o");
            TextKt.m2798Text4IGK_g(LangKt.tx("Клиенты", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getLabel(), startRestartGroup, 0, 0, 65534);
            TextKt.m2798Text4IGK_g(String.valueOf(i), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(2.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getAmountXl(), startRestartGroup, 48, 3072, 57340);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            m9826ClientPill3IgeMak(LangKt.tx("Список", new Object[0]), Ox.INSTANCE.m10196getDanger0d7_KjU(), null, startRestartGroup, 0, 4);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(14.0f), startRestartGroup, 6);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default2);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -894152297, "C267@10053L43,257@9634L1044:ClientsScreen.kt#n7o21o");
            z2 = z;
            function02 = function0;
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(SizeKt.m1084heightInVpY3zN4$default(ModifiersKt.oxTap(BorderKt.m569borderxT4_qwU(BackgroundKt.background$default(ClipKt.clip(RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), OxShape.INSTANCE.getTile()), Brush.Companion.m4333horizontalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10192getCyan0d7_KjU(), 0.34f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10186getBlue0d7_KjU(), 0.28f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10234getTileEdge0d7_KjU(), OxShape.INSTANCE.getTile()), z2, function02, startRestartGroup, i3 & PointerIconCompat.TYPE_TEXT, 0), OxDim.INSTANCE.m10249getTapD9Ej5fM(), 0.0f, 2, null), Dp.m6989constructorimpl(12.0f), Dp.m6989constructorimpl(10.0f));
            Arrangement.Horizontal m931spacedByD5KLDUw = Arrangement.INSTANCE.m931spacedByD5KLDUw(Dp.m6989constructorimpl(7.0f), Alignment.INSTANCE.getCenterHorizontally());
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m931spacedByD5KLDUw, centerVertically2, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, m1050paddingVpY3zN4);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1579631396, "C273@10405L155,277@10577L87:ClientsScreen.kt#n7o21o");
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getAdd(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(19.0f)), Ox.INSTANCE.m10193getCyanDeep0d7_KjU(), startRestartGroup, 432, 0);
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(LangKt.tx("Добавить клиента", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getButton(), Ox.INSTANCE.m10233getText0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer2, 0, 3072, 57342);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda39
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ClientsScreenKt.ClientsHero$lambda$1(i, z2, function02, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005a  */
    /* renamed from: ClientPill-3IgeMak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m9826ClientPill3IgeMak(final java.lang.String r36, final long r37, androidx.compose.ui.Modifier r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.clients.ClientsScreenKt.m9826ClientPill3IgeMak(java.lang.String, long, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ClientRow(final uz.FonRo.pos.data.model.Customer r19, final double r20, final kotlin.jvm.functions.Function0<kotlin.Unit> r22, androidx.compose.ui.Modifier r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.clients.ClientsScreenKt.ClientRow(uz.FonRo.pos.data.model.Customer, double, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClientRow$lambda$1(Customer customer, boolean z, double d, boolean z2, final Context context, final String str, ColumnScope OxCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCard, "$this$OxCard");
        ComposerKt.sourceInformation(composer, "C311@11513L1697:ClientsScreen.kt#n7o21o");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(149541608, i, -1, "uz.FonRo.pos.ui.clients.ClientRow.<anonymous> (ClientsScreen.kt:311)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1596105807, "C316@11714L40,317@11767L1167,346@13057L143:ClientsScreen.kt#n7o21o");
            m9825ClientAvatar6a0pyJM(customer.getFullName(), z, 0.0f, composer, 0, 4);
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
            ComposerKt.sourceInformationMarkerStart(composer, -540579902, "C318@11813L236,324@12066L10,326@12164L24,326@12138L50,325@12093L827:ClientsScreen.kt#n7o21o");
            String fullName = customer.getFullName();
            if (StringsKt.isBlank(fullName)) {
                fullName = LangKt.tx("Клиент #%s", Long.valueOf(customer.getId()));
            }
            TextKt.m2798Text4IGK_g(fullName, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), composer, 0, 3120, 55294);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(3.0f), composer, 6);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1679995898, "CC(remember):ClientsScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(context) | composer.changed(str);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda37
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ClientRow$lambda$1$0$0$1$0;
                        ClientRow$lambda$1$0$0$1$0 = ClientsScreenKt.ClientRow$lambda$1$0$0$1$0(context, str);
                        return ClientRow$lambda$1$0$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier oxTap = ModifiersKt.oxTap(companion, z2, (Function0) rememberedValue, composer, 6, 0);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(6.0f));
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, centerVertically2, composer, 54);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1650443812, "C330@12369L216,335@12606L296:ClientsScreen.kt#n7o21o");
            ImageVector phone = OxIcons.INSTANCE.getPhone();
            Ox ox = Ox.INSTANCE;
            IconKt.m2255Iconww6aTOc(phone, (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(14.0f)), z2 ? ox.m10192getCyan0d7_KjU() : ox.m10200getDim20d7_KjU(), composer, 432, 0);
            String tx = z2 ? str : LangKt.tx("телефон не указан", new Object[0]);
            TextStyle rowSub = OxType.INSTANCE.getRowSub();
            Ox ox2 = Ox.INSTANCE;
            TextKt.m2798Text4IGK_g(tx, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(rowSub, z2 ? ox2.m10193getCyanDeep0d7_KjU() : ox2.m10200getDim20d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 3120, 55294);
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
            if (z) {
                composer.startReplaceGroup(-1594913238);
                ComposerKt.sourceInformation(composer, "344@12978L52");
                m9826ClientPill3IgeMak(LangKt.tx("Долг ", new Object[0]) + Fmt.INSTANCE.compact(Double.valueOf(d)), Ox.INSTANCE.m10238getWarn0d7_KjU(), null, composer, 0, 4);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1594832514);
                composer.endReplaceGroup();
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getChevron(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(18.0f)), Ox.INSTANCE.m10200getDim20d7_KjU(), composer, 432, 0);
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
    public static final Unit ClientRow$lambda$1$0$0$1$0(Context context, String str) {
        dial(context, str);
        return Unit.INSTANCE;
    }

    private static final String initialsOf(String str) {
        String str2;
        Character firstOrNull;
        Character firstOrNull2;
        String obj = StringsKt.trim((CharSequence) str).toString();
        if (obj.length() == 0) {
            return LangKt.tx("КЛ", new Object[0]);
        }
        List split$default = StringsKt.split$default((CharSequence) obj, new String[]{" "}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : split$default) {
            if (!StringsKt.isBlank((String) obj2)) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = arrayList;
        String str3 = (String) CollectionsKt.firstOrNull((List) arrayList2);
        String str4 = null;
        if (str3 == null || (firstOrNull2 = StringsKt.firstOrNull(str3)) == null) {
            str2 = null;
        } else {
            String valueOf = String.valueOf(firstOrNull2.charValue());
            Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
            str2 = valueOf.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str2, "toUpperCase(...)");
        }
        if (str2 == null) {
            str2 = "";
        }
        String str5 = (String) CollectionsKt.getOrNull(arrayList2, 1);
        if (str5 != null && (firstOrNull = StringsKt.firstOrNull(str5)) != null) {
            String valueOf2 = String.valueOf(firstOrNull.charValue());
            Intrinsics.checkNotNull(valueOf2, "null cannot be cast to non-null type java.lang.String");
            str4 = valueOf2.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str4, "toUpperCase(...)");
        }
        String str6 = str2 + (str4 != null ? str4 : "");
        if (StringsKt.isBlank(str6)) {
            str6 = LangKt.tx("КЛ", new Object[0]);
        }
        return str6;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x005b  */
    /* renamed from: ClientAvatar-6a0pyJM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m9825ClientAvatar6a0pyJM(final java.lang.String r39, final boolean r40, float r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instructions count: 500
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.clients.ClientsScreenKt.m9825ClientAvatar6a0pyJM(java.lang.String, boolean, float, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void ClientCardSheet(final FonRoApp FonRoApp, final Customer customer, final List<DebtSale> list, final boolean z, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
        boolean z2;
        Composer composer2;
        ClientsScreenKt$ClientCardSheet$1$1 clientsScreenKt$ClientCardSheet$1$1;
        int i2;
        final boolean z3;
        Composer startRestartGroup = composer.startRestartGroup(1451661494);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClientCardSheet)P(!1,2,3)426@15578L7,428@15647L29,430@15694L62,431@15776L46,432@15838L48,434@15920L405,434@15892L433,449@16492L67,451@16580L69,452@16669L220,467@17254L5241,467@17187L5308:ClientsScreen.kt#n7o21o");
        int i3 = (i & 6) == 0 ? ((i & 8) == 0 ? startRestartGroup.changed(FonRoApp) : startRestartGroup.changedInstance(FonRoApp) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i3 |= (i & 64) == 0 ? startRestartGroup.changed(customer) : startRestartGroup.changedInstance(customer) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= (i & 512) == 0 ? startRestartGroup.changed(list) : startRestartGroup.changedInstance(list) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            z2 = z;
            i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
        } else {
            z2 = z;
        }
        if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
        }
        if (startRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1451661494, i3, -1, "uz.FonRo.pos.ui.clients.ClientCardSheet (ClientsScreen.kt:424)");
            }
            Repo repo = FonRoApp.getRepo();
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Context context = (Context) consume;
            final String currency = repo.currency();
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(repo.getSync(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            long id = customer.getId();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -817664492, "CC(remember):ClientsScreen.kt#9igjgp");
            boolean changed = startRestartGroup.changed(id);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int i4 = i3;
            long id2 = customer.getId();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -817661884, "CC(remember):ClientsScreen.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(id2);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -817659898, "CC(remember):ClientsScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ClientTab.PURCHASES, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Long valueOf = Long.valueOf(customer.getId());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -817656917, "CC(remember):ClientsScreen.kt#9igjgp");
            boolean changed3 = startRestartGroup.changed(mutableState2) | ((i4 & 112) == 32 || ((i4 & 64) != 0 && startRestartGroup.changedInstance(customer))) | startRestartGroup.changed(mutableState);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                clientsScreenKt$ClientCardSheet$1$1 = new ClientsScreenKt$ClientCardSheet$1$1(mutableState2, customer, mutableState, null);
                startRestartGroup.updateRememberedValue(clientsScreenKt$ClientCardSheet$1$1);
            } else {
                clientsScreenKt$ClientCardSheet$1$1 = rememberedValue4;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) clientsScreenKt$ClientCardSheet$1$1, startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -817638951, "CC(remember):ClientsScreen.kt#9igjgp");
            boolean z4 = (i4 & 896) == 256 || ((i4 & 512) != 0 && startRestartGroup.changed(list));
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                List<DebtSale> list2 = list;
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
                for (DebtSale debtSale : list2) {
                    linkedHashMap.put(Long.valueOf(debtSale.getId()), Double.valueOf(debtSale.getDebtAmount()));
                }
                startRestartGroup.updateRememberedValue(linkedHashMap);
                rememberedValue5 = linkedHashMap;
            }
            Map map = (Map) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            List<SaleRow> ClientCardSheet$lambda$2 = ClientCardSheet$lambda$2(mutableState);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -817636133, "CC(remember):ClientsScreen.kt#9igjgp");
            boolean changed4 = startRestartGroup.changed(ClientCardSheet$lambda$2) | startRestartGroup.changed(map);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changed4 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                List<SaleRow> ClientCardSheet$lambda$22 = ClientCardSheet$lambda$2(mutableState);
                if (ClientCardSheet$lambda$22 == null) {
                    ClientCardSheet$lambda$22 = CollectionsKt.emptyList();
                }
                rememberedValue6 = receiptsOf(ClientCardSheet$lambda$22, map);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final List list3 = (List) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SyncData ClientCardSheet$lambda$0 = ClientCardSheet$lambda$0(collectAsStateWithLifecycle);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -817633134, "CC(remember):ClientsScreen.kt#9igjgp");
            boolean changed5 = startRestartGroup.changed(ClientCardSheet$lambda$0) | startRestartGroup.changed(list3);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changed5 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                List list4 = list3;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                Iterator it = list4.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((ClientReceipt) it.next()).getSaleId()));
                }
                Set set = CollectionsKt.toSet(arrayList);
                SyncData ClientCardSheet$lambda$02 = ClientCardSheet$lambda$0(collectAsStateWithLifecycle);
                List<DebtPayment> debtPayments = ClientCardSheet$lambda$02 != null ? ClientCardSheet$lambda$02.getDebtPayments() : null;
                if (debtPayments == null) {
                    debtPayments = CollectionsKt.emptyList();
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : debtPayments) {
                    if (set.contains(Long.valueOf(((DebtPayment) obj).getSaleId()))) {
                        arrayList2.add(obj);
                    }
                }
                rememberedValue7 = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$ClientCardSheet$lambda$13$$inlined$sortedByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((DebtPayment) t2).getCreatedAt(), ((DebtPayment) t).getCreatedAt());
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final List list5 = (List) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            List list6 = list3;
            Iterator it2 = list6.iterator();
            double d = 0.0d;
            int i5 = 0;
            final double d2 = 0.0d;
            while (it2.hasNext()) {
                d2 += ((ClientReceipt) it2.next()).getNet();
            }
            Iterator it3 = list6.iterator();
            final double d3 = 0.0d;
            while (it3.hasNext()) {
                d3 += ((ClientReceipt) it3.next()).getPaid();
            }
            Iterator it4 = list6.iterator();
            final double d4 = 0.0d;
            while (it4.hasNext()) {
                d4 += ((ClientReceipt) it4.next()).getReturned();
            }
            Iterator<T> it5 = list.iterator();
            while (it5.hasNext()) {
                d += ((DebtSale) it5.next()).getDebtAmount();
            }
            String phone = customer.getPhone();
            String obj2 = phone != null ? StringsKt.trim((CharSequence) phone).toString() : null;
            if (obj2 == null) {
                obj2 = "";
            }
            String str = obj2;
            while (true) {
                if (i5 >= str.length()) {
                    i2 = i4;
                    z3 = false;
                    break;
                } else {
                    if (Character.isDigit(str.charAt(i5))) {
                        i2 = i4;
                        z3 = true;
                        break;
                    }
                    i5++;
                }
            }
            final double d5 = d;
            int i6 = i2;
            final boolean z5 = z2;
            final String str2 = obj2;
            SheetsKt.OxCardSheet(LangKt.tx("Карточка клиента", new Object[0]), function0, null, false, false, false, null, ComposableLambdaKt.rememberComposableLambda(1373407514, true, new Function3() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                    return ClientsScreenKt.ClientCardSheet$lambda$19(z5, function0, function02, list3, list5, customer, d5, z3, context, str2, mutableState2, d2, d3, d4, mutableState3, currency, (ColumnScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i6 >> 9) & 112) | 12582912, 124);
            composer2 = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return ClientsScreenKt.ClientCardSheet$lambda$20(FonRoApp.this, customer, list, z, function0, function02, i, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    private static final List<SaleRow> ClientCardSheet$lambda$2(MutableState<List<SaleRow>> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ClientCardSheet$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ClientCardSheet$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final ClientTab ClientCardSheet$lambda$8(MutableState<ClientTab> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClientCardSheet$lambda$19(boolean z, final Function0 function0, final Function0 function02, List list, List list2, final Customer customer, final double d, final boolean z2, final Context context, final String str, MutableState mutableState, double d2, double d3, double d4, MutableState mutableState2, String str2, ColumnScope OxCardSheet, Composer composer, int i) {
        int i2;
        final MutableState mutableState3;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C469@17319L21,468@17264L5225:ClientsScreen.kt#n7o21o");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1373407514, i, -1, "uz.FonRo.pos.ui.clients.ClientCardSheet.<anonymous> (ClientsScreen.kt:468)");
            }
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer, 6);
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
            ComposerKt.sourceInformationMarkerStart(composer, -2074955068, "C473@17514L1154,473@17460L1208,501@18744L1439,501@18716L1467,546@20515L140,550@20668L287,554@20968L10,555@20991L269,559@21273L10,560@21296L236,569@21727L76,566@21579L238,585@22469L10:ClientsScreen.kt#n7o21o");
            BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(13.0f), OxShape.INSTANCE.getCardSoft(), 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-2008653026, true, new Function3() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ClientCardSheet$lambda$19$0$0;
                    ClientCardSheet$lambda$19$0$0 = ClientsScreenKt.ClientCardSheet$lambda$19$0$0(Customer.this, d, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ClientCardSheet$lambda$19$0$0;
                }
            }, composer, 54), composer, 1572912, 57);
            BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(14.0f), null, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1139858055, true, new Function3() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ClientCardSheet$lambda$19$0$1;
                    ClientCardSheet$lambda$19$0$1 = ClientsScreenKt.ClientCardSheet$lambda$19$0$1(z2, context, str, customer, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ClientCardSheet$lambda$19$0$1;
                }
            }, composer, 54), composer, 1572912, 61);
            if (z) {
                composer.startReplaceGroup(-2072355843);
                ComposerKt.sourceInformation(composer, "538@20296L25,536@20230L225");
                i2 = 0;
                String tx = LangKt.tx("Изменить", new Object[0]);
                BtnStyle btnStyle = BtnStyle.CYAN;
                BtnSize btnSize = BtnSize.LG;
                ComposerKt.sourceInformationMarkerStart(composer, 1595719709, "CC(remember):ClientsScreen.kt#9igjgp");
                boolean changed = composer.changed(function0) | composer.changed(function02);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ClientCardSheet$lambda$19$0$2$0;
                            ClientCardSheet$lambda$19$0$2$0 = ClientsScreenKt.ClientCardSheet$lambda$19$0$2$0(Function0.this, function02);
                            return ClientCardSheet$lambda$19$0$2$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                BasicsKt.OxButton(tx, (Function0) rememberedValue, null, btnStyle, btnSize, false, true, null, composer, 1600512, 164);
                composer.endReplaceGroup();
            } else {
                i2 = 0;
                composer.startReplaceGroup(-2072125730);
                composer.endReplaceGroup();
            }
            BasicsKt.OxSectionHead(LangKt.tx("Сводка", new Object[i2]), null, ClientCardSheet$lambda$5(mutableState) ? LangKt.tx("считаем по чекам…", new Object[i2]) : null, null, null, null, composer, 0, 58);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(9.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, i2);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1080449835, "C551@20767L80,552@20864L77:ClientsScreen.kt#n7o21o");
            m9827MetricTileBx497Mc(rowScopeInstance, LangKt.tx("Чеков", new Object[i2]), ClientCardSheet$lambda$5(mutableState) ? "…" : String.valueOf(list.size()), Ox.INSTANCE.m10192getCyan0d7_KjU(), composer, 6);
            m9827MetricTileBx497Mc(rowScopeInstance, LangKt.tx("Сумма", new Object[i2]), ClientCardSheet$lambda$5(mutableState) ? "…" : Fmt.INSTANCE.compact(Double.valueOf(d2)), Ox.INSTANCE.m10186getBlue0d7_KjU(), composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(9.0f), composer, 6);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_43 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(9.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_43, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, i2);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1050376418, "C556@21090L57,557@21164L82:ClientsScreen.kt#n7o21o");
            m9827MetricTileBx497Mc(rowScopeInstance2, LangKt.tx("Долг", new Object[i2]), Fmt.INSTANCE.compact(Double.valueOf(d)), Ox.INSTANCE.m10213getOrange0d7_KjU(), composer, 6);
            m9827MetricTileBx497Mc(rowScopeInstance2, LangKt.tx("Оплачено", new Object[i2]), ClientCardSheet$lambda$5(mutableState) ? "…" : Fmt.INSTANCE.compact(Double.valueOf(d3)), Ox.INSTANCE.m10201getGreen0d7_KjU(), composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(9.0f), composer, 6);
            Modifier fillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_44 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(9.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m930spacedBy0680j_44, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, i2);
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, fillMaxWidth$default3);
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
            ComposerKt.sourceInformationMarkerStart(composer, 897352992, "C561@21395L82,562@21494L24:ClientsScreen.kt#n7o21o");
            m9827MetricTileBx497Mc(rowScopeInstance3, LangKt.tx("Возврат", new Object[i2]), ClientCardSheet$lambda$5(mutableState) ? "…" : Fmt.INSTANCE.compact(Double.valueOf(d4)), Ox.INSTANCE.m10226getRose0d7_KjU(), composer, 6);
            BoxKt.Box(RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), composer, i2);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            EnumEntries<ClientTab> entries = ClientTab.getEntries();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries, 10));
            for (ClientTab clientTab : entries) {
                arrayList.add(TuplesKt.to(clientTab.getKey(), clientTab.getLabel()));
            }
            ArrayList arrayList2 = arrayList;
            String key = ClientCardSheet$lambda$8(mutableState2).getKey();
            ComposerKt.sourceInformationMarkerStart(composer, 1595765552, "CC(remember):ClientsScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                mutableState3 = mutableState2;
                rememberedValue2 = new Function1() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ClientCardSheet$lambda$19$0$7$0;
                        ClientCardSheet$lambda$19$0$7$0 = ClientsScreenKt.ClientCardSheet$lambda$19$0$7$0(MutableState.this, (String) obj);
                        return ClientCardSheet$lambda$19$0$7$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            } else {
                mutableState3 = mutableState2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.OxSegControl(arrayList2, key, (Function1) rememberedValue2, null, false, composer, 384, 24);
            int i3 = WhenMappings.$EnumSwitchMapping$0[ClientCardSheet$lambda$8(mutableState3).ordinal()];
            if (i3 == 1) {
                if (ClientCardSheet$lambda$5(mutableState)) {
                    composer.startReplaceGroup(1595771721);
                    ComposerKt.sourceInformation(composer, "574@21921L37");
                    BasicsKt.OxEmptyNote(LangKt.tx("Загружаем покупки…", new Object[i2]), null, composer, i2, 2);
                    composer.endReplaceGroup();
                } else if (list.isEmpty()) {
                    composer.startReplaceGroup(1595774299);
                    ComposerKt.sourceInformation(composer, "575@22001L55");
                    BasicsKt.OxEmptyNote(LangKt.tx("Покупок у этого клиента ещё не было.", new Object[i2]), null, composer, i2, 2);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-2070512583);
                    ComposerKt.sourceInformation(composer, "*576@22104L25");
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ReceiptCard((ClientReceipt) it.next(), str2, composer, i2);
                    }
                    composer.endReplaceGroup();
                }
                Unit unit = Unit.INSTANCE;
            } else {
                if (i3 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                if (ClientCardSheet$lambda$5(mutableState)) {
                    composer.startReplaceGroup(1595781512);
                    ComposerKt.sourceInformation(composer, "580@22227L36");
                    BasicsKt.OxEmptyNote(LangKt.tx("Загружаем оплаты…", new Object[i2]), null, composer, i2, 2);
                    composer.endReplaceGroup();
                } else if (list2.isEmpty()) {
                    composer.startReplaceGroup(1595784047);
                    ComposerKt.sourceInformation(composer, "581@22306L43");
                    BasicsKt.OxEmptyNote(LangKt.tx("Погашений долга не было.", new Object[i2]), null, composer, i2, 2);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-2070221927);
                    ComposerKt.sourceInformation(composer, "*582@22397L25");
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        PaymentCard((DebtPayment) it2.next(), str2, composer, DebtPayment.$stable);
                    }
                    composer.endReplaceGroup();
                }
                Unit unit2 = Unit.INSTANCE;
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
    public static final Unit ClientCardSheet$lambda$19$0$0(Customer customer, double d, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C474@17532L1122:ClientsScreen.kt#n7o21o");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2008653026, i, -1, "uz.FonRo.pos.ui.clients.ClientCardSheet.<anonymous>.<anonymous>.<anonymous> (ClientsScreen.kt:474)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(11.0f));
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
            ComposerKt.sourceInformationMarkerStart(composer, 1525893341, "C479@17760L64,480@17845L583,493@18449L187:ClientsScreen.kt#n7o21o");
            m9825ClientAvatar6a0pyJM(customer.getFullName(), d > 0.001d, Dp.m6989constructorimpl(46.0f), composer, 384, 0);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1839128540, "C481@17899L270,487@18194L212:ClientsScreen.kt#n7o21o");
            String fullName = customer.getFullName();
            if (StringsKt.isBlank(fullName)) {
                fullName = LangKt.tx("Клиент #%s", Long.valueOf(customer.getId()));
            }
            TextKt.m2798Text4IGK_g(fullName, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH3(), composer, 0, 3120, 55294);
            TextKt.m2798Text4IGK_g(LangKt.tx("Карточка клиента магазина", new Object[0]), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(3.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 48, 0, 65532);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            String tx = d > 0.001d ? LangKt.tx("Есть долг", new Object[0]) : LangKt.tx("Клиент", new Object[0]);
            Ox ox = Ox.INSTANCE;
            m9826ClientPill3IgeMak(tx, d > 0.001d ? ox.m10238getWarn0d7_KjU() : ox.m10193getCyanDeep0d7_KjU(), null, composer, 0, 4);
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
    /* JADX WARN: Removed duplicated region for block: B:41:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x02d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit ClientCardSheet$lambda$19$0$1(boolean r61, final android.content.Context r62, final java.lang.String r63, uz.FonRo.pos.data.model.Customer r64, androidx.compose.foundation.layout.ColumnScope r65, androidx.compose.runtime.Composer r66, int r67) {
        /*
            Method dump skipped, instructions count: 735
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.clients.ClientsScreenKt.ClientCardSheet$lambda$19$0$1(boolean, android.content.Context, java.lang.String, uz.FonRo.pos.data.model.Customer, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClientCardSheet$lambda$19$0$1$0$0(Context context, String str) {
        dial(context, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClientCardSheet$lambda$19$0$2$0(Function0 function0, Function0 function02) {
        function0.invoke();
        function02.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClientCardSheet$lambda$19$0$7$0(MutableState mutableState, String key) {
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        Iterator<E> it = ClientTab.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ClientTab) obj).getKey(), key)) {
                break;
            }
        }
        ClientTab clientTab = (ClientTab) obj;
        if (clientTab != null) {
            mutableState.setValue(clientTab);
        }
        return Unit.INSTANCE;
    }

    private static final List<ClientReceipt> receiptsOf(List<SaleRow> list, Map<Long, Double> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            SaleRow saleRow = (SaleRow) obj;
            String transactionId = saleRow.getTransactionId();
            if (StringsKt.isBlank(transactionId)) {
                transactionId = "sale-" + saleRow.getSaleId();
            }
            String str = transactionId;
            Object obj2 = linkedHashMap.get(str);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(str, obj2);
            }
            ((List) obj2).add(obj);
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str2 = (String) entry.getKey();
            List list2 = (List) entry.getValue();
            SaleRow saleRow2 = (SaleRow) CollectionsKt.first(list2);
            List<SaleRow> list3 = list2;
            Iterator it2 = list3.iterator();
            double d = 0.0d;
            while (it2.hasNext()) {
                d += ((SaleRow) it2.next()).getTotalAmount();
            }
            double d2 = 0.0d;
            for (SaleRow saleRow3 : list3) {
                d2 += saleRow3.getTotalAmount() * saleRow3.getReturnedShare();
            }
            double max = Math.max(d - d2, AudioStats.AUDIO_AMPLITUDE_NONE);
            long saleId = saleRow2.getSaleId();
            String soldAt = saleRow2.getSoldAt();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator it3 = list3.iterator();
            while (it3.hasNext()) {
                arrayList2.add(((SaleRow) it3.next()).getTitle());
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : arrayList2) {
                if (!StringsKt.isBlank((String) obj3)) {
                    arrayList3.add(obj3);
                }
            }
            ArrayList arrayList4 = arrayList3;
            double min = Math.min(saleRow2.getPaidAmount(), max);
            Iterator it4 = it;
            Double d3 = map.get(Long.valueOf(saleRow2.getSaleId()));
            arrayList.add(new ClientReceipt(str2, saleId, soldAt, arrayList4, d, d2, min, d3 != null ? d3.doubleValue() : Math.max(max - saleRow2.getPaidAmount(), AudioStats.AUDIO_AMPLITUDE_NONE)));
            it = it4;
        }
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$receiptsOf$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((ClientReceipt) t2).getSoldAt(), ((ClientReceipt) t).getSoldAt());
            }
        });
    }

    private static final void ReceiptCard(final ClientReceipt clientReceipt, final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        String tx;
        final long m10211getOk0d7_KjU;
        Composer startRestartGroup = composer.startRestartGroup(-1428555678);
        ComposerKt.sourceInformation(startRestartGroup, "C(ReceiptCard)P(1)629@24049L2748,629@23977L2820:ClientsScreen.kt#n7o21o");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(clientReceipt) : startRestartGroup.changedInstance(clientReceipt) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1428555678, i2, -1, "uz.FonRo.pos.ui.clients.ReceiptCard (ClientsScreen.kt:617)");
            }
            if (clientReceipt.isReturned()) {
                tx = LangKt.tx("Возвращён", new Object[0]);
            } else {
                tx = clientReceipt.isPaid() ? LangKt.tx("Оплачен", new Object[0]) : LangKt.tx("Открыт", new Object[0]);
            }
            final String str2 = tx;
            if (clientReceipt.isReturned()) {
                m10211getOk0d7_KjU = Ox.INSTANCE.m10226getRose0d7_KjU();
            } else {
                m10211getOk0d7_KjU = clientReceipt.isPaid() ? Ox.INSTANCE.m10211getOk0d7_KjU() : Ox.INSTANCE.m10238getWarn0d7_KjU();
            }
            composer2 = startRestartGroup;
            BasicsKt.m9833OxSoftCardCe4qNIY(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(8.0f), 7, null), Dp.m6989constructorimpl(12.0f), null, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1653976732, true, new Function3() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ClientsScreenKt.ReceiptCard$lambda$0(ClientReceipt.this, str, m10211getOk0d7_KjU, str2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), composer2, 1572918, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ClientsScreenKt.ReceiptCard$lambda$1(ClientReceipt.this, str, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ReceiptCard$lambda$0(ClientReceipt clientReceipt, String str, long j, String str2, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C630@24059L1741,685@26172L10,686@26191L600:ClientsScreen.kt#n7o21o");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1653976732, i, -1, "uz.FonRo.pos.ui.clients.ReceiptCard.<anonymous> (ClientsScreen.kt:630)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -961077660, "C635@24247L580,649@24840L608,664@25461L329:ClientsScreen.kt#n7o21o");
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(42.0f)), OxShape.INSTANCE.getTile()), Ox.INSTANCE.m10241tintBg5vOe2sY(clientReceipt.isReturned() ? Ox.INSTANCE.m10226getRose0d7_KjU() : Ox.INSTANCE.m10192getCyan0d7_KjU(), 0.14f), null, 2, null);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1391390690, "C642@24542L271:ClientsScreen.kt#n7o21o");
            IconKt.m2255Iconww6aTOc(clientReceipt.isReturned() ? OxIcons.INSTANCE.getUndo() : OxIcons.INSTANCE.getCart(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(19.0f)), clientReceipt.isReturned() ? Ox.INSTANCE.m10226getRose0d7_KjU() : Ox.INSTANCE.m10192getCyan0d7_KjU(), composer, 432, 0);
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
            ComposerKt.sourceInformationMarkerStart(composer, 2098574813, "C650@24886L220,656@25123L311:ClientsScreen.kt#n7o21o");
            TextKt.m2798Text4IGK_g(LangKt.tx("Чек ", new Object[0]) + StringsKt.take(clientReceipt.getTransactionId(), 14), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), composer, 0, 3120, 55294);
            TextKt.m2798Text4IGK_g(Fmt.dt$default(Fmt.INSTANCE, clientReceipt.getSoldAt(), false, 2, null) + " · " + Fmt.INSTANCE.plural(clientReceipt.getItemNames().size(), LangKt.tx("позиция", new Object[0]), LangKt.tx("позиции", new Object[0]), LangKt.tx("позиций", new Object[0])), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 0, 3120, 55294);
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
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, companion);
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
            ComposerKt.sourceInformationMarkerStart(composer, 906079963, "C665@25523L77,666@25617L159:ClientsScreen.kt#n7o21o");
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.money(Double.valueOf(clientReceipt.getNet()), str), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowPrice(), composer, 0, 3072, 57342);
            TextKt.m2798Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getTileLabel(), j, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 3072, 57342);
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
            String str3 = (String) CollectionsKt.firstOrNull((List) clientReceipt.getItemNames());
            if (str3 != null) {
                composer2.startReplaceGroup(1757792839);
                ComposerKt.sourceInformation(composer2, "*675@25870L10,676@25893L259");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(7.0f), composer2, 6);
                if (clientReceipt.getItemNames().size() != 1) {
                    str3 = str3 + " +" + (clientReceipt.getItemNames().size() - 1);
                }
                TextKt.m2798Text4IGK_g(str3, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 3120, 55294);
                composer2 = composer;
                Unit unit = Unit.INSTANCE;
                composer2.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            } else {
                composer2.startReplaceGroup(1757792838);
                composer2.endReplaceGroup();
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer2, 6);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(6.0f));
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), composer2, 6);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer2, companion2);
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
            Updater.m3815setimpl(m3808constructorimpl5, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl5.getInserting() || !Intrinsics.areEqual(m3808constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                m3808constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                m3808constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m3815setimpl(m3808constructorimpl5, materializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 59765754, "C:ClientsScreen.kt#n7o21o");
            if (clientReceipt.isReturned()) {
                composer2.startReplaceGroup(59776510);
                ComposerKt.sourceInformation(composer2, "688@26303L67");
                m9826ClientPill3IgeMak(LangKt.tx("Возврат ", new Object[0]) + Fmt.INSTANCE.compact(Double.valueOf(clientReceipt.getReturned())), Ox.INSTANCE.m10226getRose0d7_KjU(), null, composer2, 0, 4);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(59889722);
                ComposerKt.sourceInformation(composer2, "690@26408L62");
                m9826ClientPill3IgeMak(LangKt.tx("Оплачено ", new Object[0]) + Fmt.INSTANCE.compact(Double.valueOf(clientReceipt.getPaid())), Ox.INSTANCE.m10211getOk0d7_KjU(), null, composer2, 0, 4);
                if (clientReceipt.getReturned() > 0.001d) {
                    composer2.startReplaceGroup(60006902);
                    ComposerKt.sourceInformation(composer2, "692@26539L67");
                    m9826ClientPill3IgeMak(LangKt.tx("Возврат ", new Object[0]) + Fmt.INSTANCE.compact(Double.valueOf(clientReceipt.getReturned())), Ox.INSTANCE.m10226getRose0d7_KjU(), null, composer2, 0, 4);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(60109729);
                    composer2.endReplaceGroup();
                }
                if (clientReceipt.getDebt() > 0.001d) {
                    composer2.startReplaceGroup(60155485);
                    ComposerKt.sourceInformation(composer2, "695@26689L60");
                    m9826ClientPill3IgeMak(LangKt.tx("Долг ", new Object[0]) + Fmt.INSTANCE.compact(Double.valueOf(clientReceipt.getDebt())), Ox.INSTANCE.m10238getWarn0d7_KjU(), null, composer2, 0, 4);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(60251585);
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

    private static final void PaymentCard(final DebtPayment debtPayment, final String str, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(273723278);
        ComposerKt.sourceInformation(startRestartGroup, "C(PaymentCard)P(1)704@26955L1589,704@26883L1661:ClientsScreen.kt#n7o21o");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(debtPayment) : startRestartGroup.changedInstance(debtPayment) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(273723278, i2, -1, "uz.FonRo.pos.ui.clients.PaymentCard (ClientsScreen.kt:703)");
            }
            BasicsKt.m9833OxSoftCardCe4qNIY(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(8.0f), 7, null), Dp.m6989constructorimpl(12.0f), null, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(437824584, true, new Function3() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ClientsScreenKt.PaymentCard$lambda$0(DebtPayment.this, str, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, 1572918, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ClientsScreenKt.PaymentCard$lambda$1(DebtPayment.this, str, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PaymentCard$lambda$0(DebtPayment debtPayment, String str, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C705@26965L1573:ClientsScreen.kt#n7o21o");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(437824584, i, -1, "uz.FonRo.pos.ui.clients.PaymentCard.<anonymous> (ClientsScreen.kt:705)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -863361971, "C710@27166L428,722@27607L746,740@28366L162:ClientsScreen.kt#n7o21o");
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(40.0f)), OxShape.INSTANCE.getTile()), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10201getGreen0d7_KjU(), 0.14f), null, 2, null);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1293240106, "C717@27425L155:ClientsScreen.kt#n7o21o");
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getOk(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(19.0f)), Ox.INSTANCE.m10202getGreenDeep0d7_KjU(), composer, 432, 0);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1132820505, "C723@27653L253,729@27923L416:ClientsScreen.kt#n7o21o");
            String tx = LangKt.tx("Чек ", new Object[0]);
            String take = StringsKt.take(debtPayment.getTransactionId(), 14);
            if (StringsKt.isBlank(take)) {
                take = "#" + debtPayment.getSaleId();
            }
            TextKt.m2798Text4IGK_g(tx + ((Object) take), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), composer, 0, 3120, 55294);
            String dt$default = Fmt.dt$default(Fmt.INSTANCE, debtPayment.getCreatedAt(), false, 2, null);
            String label = PayType.INSTANCE.of(debtPayment.getPaymentType()).getLabel();
            String paidByName = debtPayment.getPaidByName();
            if (paidByName == null || StringsKt.isBlank(paidByName)) {
                paidByName = null;
            }
            TextKt.m2798Text4IGK_g(CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{dt$default, label, paidByName}), " · ", null, null, 0, null, null, 62, null), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 0, 3120, 55294);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.money(Double.valueOf(debtPayment.getAmount()), str), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowPrice(), Ox.INSTANCE.m10211getOk0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 3072, 57342);
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

    /* renamed from: MetricTile-Bx497Mc, reason: not valid java name */
    private static final void m9827MetricTileBx497Mc(final RowScope rowScope, final String str, final String str2, final long j, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1502464637);
        ComposerKt.sourceInformation(startRestartGroup, "C(MetricTile)P(!1,2,1:c#ui.graphics.Color)751@28641L464:ClientsScreen.kt#n7o21o");
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
                ComposerKt.traceEventStart(-1502464637, i2, -1, "uz.FonRo.pos.ui.clients.MetricTile (ClientsScreen.kt:750)");
            }
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), OxShape.INSTANCE.getTile()), Ox.INSTANCE.m10241tintBg5vOe2sY(j, 0.12f), null, 2, null), Dp.m6989constructorimpl(12.0f), Dp.m6989constructorimpl(11.0f));
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1945469463, "C758@28856L72,759@28937L162:ClientsScreen.kt#n7o21o");
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getTileLabel(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), startRestartGroup, (i2 >> 3) & 14, 3072, 57342);
            TextKt.m2798Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getStatValue(), j, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), startRestartGroup, (i2 >> 6) & 14, 3120, 55294);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ClientsScreenKt.MetricTile_Bx497Mc$lambda$1(RowScope.this, str, str2, j, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void InfoLine(final java.lang.String r63, final java.lang.String r64, boolean r65, androidx.compose.runtime.Composer r66, final int r67, final int r68) {
        /*
            Method dump skipped, instructions count: 777
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.clients.ClientsScreenKt.InfoLine(java.lang.String, java.lang.String, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void ClientFormSheet(final FonRoApp FonRoApp, final Customer customer, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        final Customer customer2;
        final Function0<Unit> function02 = function0;
        Composer startRestartGroup = composer.startRestartGroup(-650207888);
        ComposerKt.sourceInformation(startRestartGroup, "C(ClientFormSheet)799@30042L24,802@30117L57,803@30192L54,804@30266L56,805@30339L53,806@30409L34,856@32350L397,867@32754L1163,853@32214L1703:ClientsScreen.kt#n7o21o");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(FonRoApp) : startRestartGroup.changedInstance(FonRoApp) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(customer) : startRestartGroup.changedInstance(customer) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composer2 = startRestartGroup;
            customer2 = customer;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-650207888, i3, -1, "uz.FonRo.pos.ui.clients.ClientFormSheet (ClientsScreen.kt:797)");
            }
            final Repo repo = FonRoApp.getRepo();
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
            final boolean z = customer == null;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2079515639, "CC(remember):ClientsScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                String fullName = customer != null ? customer.getFullName() : null;
                if (fullName == null) {
                    fullName = "";
                }
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fullName, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2079513242, "CC(remember):ClientsScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                String phone = customer != null ? customer.getPhone() : null;
                if (phone == null) {
                    phone = "";
                }
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(phone, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2079510872, "CC(remember):ClientsScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                String address = customer != null ? customer.getAddress() : null;
                if (address == null) {
                    address = "";
                }
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(address, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2079508539, "CC(remember):ClientsScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                String note = customer != null ? customer.getNote() : null;
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(note != null ? note : "", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2079506318, "CC(remember):ClientsScreen.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final MutableState mutableState5 = (MutableState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            function02 = function0;
            composer2 = startRestartGroup;
            customer2 = customer;
            SheetsKt.OxCardSheet(z ? LangKt.tx("Новый клиент", new Object[0]) : LangKt.tx("Изменить клиента", new Object[0]), function02, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(1388205795, true, new Function3() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ClientsScreenKt.ClientFormSheet$lambda$15(Function0.this, z, coroutineScope, customer, repo, mutableState5, mutableState, mutableState2, mutableState3, mutableState4, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(2070826380, true, new Function3() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ClientsScreenKt.ClientFormSheet$lambda$16(CoroutineScope.this, customer, repo, function0, mutableState, mutableState5, mutableState2, mutableState3, mutableState4, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), composer2, ((i3 >> 3) & 112) | 14155776, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ClientsScreenKt.ClientFormSheet$lambda$17(FonRoApp.this, customer2, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String ClientFormSheet$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ClientFormSheet$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ClientFormSheet$lambda$7(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ClientFormSheet$lambda$10(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ClientFormSheet$lambda$13(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ClientFormSheet$lambda$14(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void ClientFormSheet$save(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, MutableState<String> mutableState2, Customer customer, Repo repo, Function0<Unit> function0, MutableState<String> mutableState3, MutableState<String> mutableState4, MutableState<String> mutableState5) {
        if (ClientFormSheet$lambda$13(mutableState)) {
            return;
        }
        String obj = StringsKt.trim((CharSequence) ClientFormSheet$lambda$1(mutableState2)).toString();
        if (obj.length() == 0) {
            Toaster.INSTANCE.error(LangKt.tx("Введите имя клиента", new Object[0]));
        } else {
            ClientFormSheet$lambda$14(mutableState, true);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ClientsScreenKt$ClientFormSheet$save$1(obj, customer, repo, function0, mutableState3, mutableState4, mutableState5, mutableState, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClientFormSheet$lambda$15(final Function0 function0, boolean z, final CoroutineScope coroutineScope, final Customer customer, final Repo repo, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C857@32364L89,860@32555L10,858@32466L271:ClientsScreen.kt#n7o21o");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1388205795, i2, -1, "uz.FonRo.pos.ui.clients.ClientFormSheet.<anonymous> (ClientsScreen.kt:857)");
            }
            BasicsKt.OxButton(LangKt.tx("Отмена", new Object[0]), function0, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.GHOST, null, false, false, null, composer, 3072, 240);
            String tx = z ? LangKt.tx("Создать", new Object[0]) : LangKt.tx("Сохранить", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -1669053491, "CC(remember):ClientsScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(customer) | composer.changedInstance(repo) | composer.changed(function0);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                Function0 function02 = new Function0() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ClientFormSheet$lambda$15$0$0;
                        ClientFormSheet$lambda$15$0$0 = ClientsScreenKt.ClientFormSheet$lambda$15$0$0(CoroutineScope.this, mutableState, mutableState2, customer, repo, function0, mutableState3, mutableState4, mutableState5);
                        return ClientFormSheet$lambda$15$0$0;
                    }
                };
                composer.updateRememberedValue(function02);
                rememberedValue = function02;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, !ClientFormSheet$lambda$13(mutableState), false, null, composer, 27648, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClientFormSheet$lambda$15$0$0(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, Customer customer, Repo repo, Function0 function0, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5) {
        ClientFormSheet$save(coroutineScope, mutableState, mutableState2, customer, repo, function0, mutableState3, mutableState4, mutableState5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClientFormSheet$lambda$16(final CoroutineScope coroutineScope, final Customer customer, final Repo repo, final Function0 function0, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, MutableState mutableState5, ColumnScope OxCardSheet, Composer composer, int i) {
        final MutableState mutableState6;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C868@32795L21,868@32764L1147:ClientsScreen.kt#n7o21o");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2070826380, i, -1, "uz.FonRo.pos.ui.clients.ClientFormSheet.<anonymous> (ClientsScreen.kt:868)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1577275563, "C872@32941L13,869@32833L227,879@33184L14,876@33073L270,887@33467L16,884@33356L225,894@33704L13,897@33844L10,891@33594L307:ClientsScreen.kt#n7o21o");
            String tx = LangKt.tx("Имя *", new Object[0]);
            String ClientFormSheet$lambda$1 = ClientFormSheet$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, -1159256113, "CC(remember):ClientsScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ClientFormSheet$lambda$16$0$0$0;
                        ClientFormSheet$lambda$16$0$0$0 = ClientsScreenKt.ClientFormSheet$lambda$16$0$0$0(MutableState.this, (String) obj);
                        return ClientFormSheet$lambda$16$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9846OxFieldDfSPO0(tx, ClientFormSheet$lambda$1, (Function1) rememberedValue, null, LangKt.tx("Например: Ali Valiyev", new Object[0]), 0, 0, null, false, false, !ClientFormSheet$lambda$13(mutableState2), false, false, null, null, composer, 384, 0, 31720);
            String tx2 = LangKt.tx("Телефон", new Object[0]);
            String ClientFormSheet$lambda$4 = ClientFormSheet$lambda$4(mutableState3);
            ComposerKt.sourceInformationMarkerStart(composer, -1159248336, "CC(remember):ClientsScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ClientFormSheet$lambda$16$0$1$0;
                        ClientFormSheet$lambda$16$0$1$0 = ClientsScreenKt.ClientFormSheet$lambda$16$0$1$0(MutableState.this, (String) obj);
                        return ClientFormSheet$lambda$16$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9846OxFieldDfSPO0(tx2, ClientFormSheet$lambda$4, (Function1) rememberedValue2, null, "+998901234567", KeyboardType.INSTANCE.m6694getPhonePjHm6EE(), 0, null, false, false, !ClientFormSheet$lambda$13(mutableState2), false, false, null, null, composer, 221568, 0, 31688);
            String tx3 = LangKt.tx("Адрес", new Object[0]);
            String ClientFormSheet$lambda$7 = ClientFormSheet$lambda$7(mutableState4);
            ComposerKt.sourceInformationMarkerStart(composer, -1159239278, "CC(remember):ClientsScreen.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ClientFormSheet$lambda$16$0$2$0;
                        ClientFormSheet$lambda$16$0$2$0 = ClientsScreenKt.ClientFormSheet$lambda$16$0$2$0(MutableState.this, (String) obj);
                        return ClientFormSheet$lambda$16$0$2$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9846OxFieldDfSPO0(tx3, ClientFormSheet$lambda$7, (Function1) rememberedValue3, null, LangKt.tx("Необязательно", new Object[0]), 0, 0, null, false, false, !ClientFormSheet$lambda$13(mutableState2), false, false, null, null, composer, 384, 0, 31720);
            String tx4 = LangKt.tx("Заметка", new Object[0]);
            String ClientFormSheet$lambda$10 = ClientFormSheet$lambda$10(mutableState5);
            ComposerKt.sourceInformationMarkerStart(composer, -1159231697, "CC(remember):ClientsScreen.kt#9igjgp");
            Object rememberedValue4 = composer.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                mutableState6 = mutableState5;
                rememberedValue4 = new Function1() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ClientFormSheet$lambda$16$0$3$0;
                        ClientFormSheet$lambda$16$0$3$0 = ClientsScreenKt.ClientFormSheet$lambda$16$0$3$0(MutableState.this, (String) obj);
                        return ClientFormSheet$lambda$16$0$3$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue4);
            } else {
                mutableState6 = mutableState5;
            }
            Function1 function1 = (Function1) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            String tx5 = LangKt.tx("Необязательно", new Object[0]);
            int m6635getDoneeUduSuo = ImeAction.INSTANCE.m6635getDoneeUduSuo();
            ComposerKt.sourceInformationMarkerStart(composer, -1159227220, "CC(remember):ClientsScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(customer) | composer.changedInstance(repo) | composer.changed(function0);
            Object rememberedValue5 = composer.rememberedValue();
            if (changedInstance || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: uz.FonRo.pos.ui.clients.ClientsScreenKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ClientFormSheet$lambda$16$0$4$0;
                        ClientFormSheet$lambda$16$0$4$0 = ClientsScreenKt.ClientFormSheet$lambda$16$0$4$0(CoroutineScope.this, mutableState2, mutableState, customer, repo, function0, mutableState3, mutableState4, mutableState6);
                        return ClientFormSheet$lambda$16$0$4$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9846OxFieldDfSPO0(tx4, ClientFormSheet$lambda$10, function1, null, tx5, 0, m6635getDoneeUduSuo, (Function0) rememberedValue5, false, false, !ClientFormSheet$lambda$13(mutableState2), false, false, null, null, composer, 1573248, 0, 31528);
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
    public static final Unit ClientFormSheet$lambda$16$0$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClientFormSheet$lambda$16$0$1$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClientFormSheet$lambda$16$0$2$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClientFormSheet$lambda$16$0$3$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClientFormSheet$lambda$16$0$4$0(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, Customer customer, Repo repo, Function0 function0, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5) {
        ClientFormSheet$save(coroutineScope, mutableState, mutableState2, customer, repo, function0, mutableState3, mutableState4, mutableState5);
        return Unit.INSTANCE;
    }

    private static final void dial(Context context, String str) {
        Object m7870constructorimpl;
        String str2 = str;
        StringBuilder sb = new StringBuilder();
        int length = str2.length();
        for (int i = 0; i < length; i++) {
            char charAt = str2.charAt(i);
            if (Character.isDigit(charAt) || charAt == '+') {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        if (StringsKt.isBlank(sb2)) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            context.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + sb2)));
            m7870constructorimpl = Result.m7870constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7873exceptionOrNullimpl(m7870constructorimpl) != null) {
            Toaster.INSTANCE.error(LangKt.tx("Не удалось открыть звонилку", new Object[0]));
        }
    }

    private static final List<Customer> ClientsScreen$lambda$0(State<? extends List<Customer>> state) {
        return state.getValue();
    }

    private static final SyncData ClientCardSheet$lambda$0(State<SyncData> state) {
        return state.getValue();
    }
}
