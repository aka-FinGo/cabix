package uz.FonRo.pos.ui.catalog;

import androidx.camera.video.AudioStats;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
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
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.data.model.AuditDoc;
import uz.FonRo.pos.data.model.AuditItem;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.model.ReturnDoc;
import uz.FonRo.pos.data.model.ReturnLine;
import uz.FonRo.pos.data.model.SaleRow;
import uz.FonRo.pos.data.model.StockInDoc;
import uz.FonRo.pos.data.model.StockInItem;
import uz.FonRo.pos.data.model.SyncData;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.nav.Routes;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: ProductCard.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001am\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000bH\u0001b\u0002\b\rb\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\f\u001aC\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0003b\u0002\b\rb\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\u0018\u001a=\u0010\u0019\u001a\u00020\u0001*\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cH\u0003b\u0002\b\rb\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¢\u0006\u0004\b\u001d\u0010\u001e\u001aO\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130$H\u0003b\u0002\b\rb\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¢\u0006\u0004\b%\u0010&\u001a\f\u0010'\u001a\u00020(*\u00020)H\u0002\u001a>\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0$2\u001e\u0010.\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002010/0$2\u0006\u0010'\u001a\u00020(H\u0002\u001a8\u00102\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002010/0$2\u000e\u00104\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010$2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a&\u00105\u001a\b\u0012\u0004\u0012\u0002060$2\u000e\u00104\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010$2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a8\u00108\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002010/0$2\u000e\u00104\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010$2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0002²\u0006\f\u00109\u001a\u0004\u0018\u00010:X\u008a\u0084\u0002²\u0006\n\u0010;\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\n\u0010<\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\n\u0010=\u001a\u00020)X\u008a\u008e\u0002²\u0006\n\u0010>\u001a\u00020?X\u008a\u008e\u0002²\u0006\u0010\u0010,\u001a\b\u0012\u0004\u0012\u00020-0$X\u008a\u008e\u0002²\u0006\n\u0010@\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\f\u0010A\u001a\u0004\u0018\u00010\u0013X\u008a\u008e\u0002"}, d2 = {"ProductCardSheet", "", "app", "Luz/FonRo/pos/FonRoApp;", "product", "Luz/FonRo/pos/data/model/Product;", "onDismiss", "Lkotlin/Function0;", "onEdit", "onArchived", "onRestored", "Lkotlin/Function1;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/data/model/Product;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "InfoLine", "label", "", "value", "mono", "", "divider", "(Ljava/lang/String;Ljava/lang/String;ZZLandroidx/compose/runtime/Composer;II)V", "MetricTile", "Landroidx/compose/foundation/layout/RowScope;", "tint", "Landroidx/compose/ui/graphics/Color;", "MetricTile-Bx497Mc", "(Landroidx/compose/foundation/layout/RowScope;Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/runtime/Composer;I)V", "EventCard", "icon", "title", "date", "lines", "", "EventCard-sW7UJKQ", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "range", "Luz/FonRo/pos/ui/catalog/CardRange;", "Luz/FonRo/pos/ui/catalog/CardPeriod;", "statsOf", "Luz/FonRo/pos/ui/catalog/CardStats;", "sales", "Luz/FonRo/pos/data/model/SaleRow;", Routes.RETURNS, "Lkotlin/Triple;", "Luz/FonRo/pos/data/model/ReturnDoc;", "", "stockInsOf", "Luz/FonRo/pos/data/model/StockInDoc;", "docs", "auditsOf", "Luz/FonRo/pos/ui/catalog/AuditRow;", "Luz/FonRo/pos/data/model/AuditDoc;", "returnsOf", "sync", "Luz/FonRo/pos/data/model/SyncData;", "confirmArchive", "busy", TypedValues.CycleType.S_WAVE_PERIOD, "tab", "Luz/FonRo/pos/ui/catalog/CardTab;", "loading", "loadError"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ProductCardKt {

    /* compiled from: ProductCard.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes7.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CardTab.values().length];
            try {
                iArr[CardTab.CHART.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CardTab.HISTORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CardTab.AUDIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CardTab.RETURNS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CardPeriod.values().length];
            try {
                iArr2[CardPeriod.WEEK.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[CardPeriod.MONTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[CardPeriod.YEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit EventCard_sW7UJKQ$lambda$1(String str, long j, String str2, String str3, List list, int i, Composer composer, int i2) {
        m9801EventCardsW7UJKQ(str, j, str2, str3, list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit InfoLine$lambda$1(String str, String str2, boolean z, boolean z2, int i, int i2, Composer composer, int i3) {
        InfoLine(str, str2, z, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MetricTile_Bx497Mc$lambda$1(RowScope rowScope, String str, String str2, long j, int i, Composer composer, int i2) {
        m9802MetricTileBx497Mc(rowScope, str, str2, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ProductCardSheet$lambda$31(FonRoApp FonRoApp, Product product, Function0 function0, Function0 function02, Function0 function03, Function1 function1, int i, Composer composer, int i2) {
        ProductCardSheet(FonRoApp, product, function0, function02, function03, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ProductCardSheet(final FonRoApp app, final Product product, final Function0<Unit> onDismiss, final Function0<Unit> onEdit, final Function0<Unit> onArchived, final Function1<? super Product, Unit> onRestored, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Object mutableStateOf$default;
        Object mutableStateOf$default2;
        int i3;
        MutableState mutableState;
        Composer composer3;
        MutableState mutableState2;
        int i4;
        Repo repo;
        int i5;
        Object obj;
        String str;
        Object mutableStateOf$default3;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onEdit, "onEdit");
        Intrinsics.checkNotNullParameter(onArchived, "onArchived");
        Intrinsics.checkNotNullParameter(onRestored, "onRestored");
        Composer startRestartGroup = composer.startRestartGroup(1440006644);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProductCardSheet)P(!1,5,2,3)103@3837L24,104@3888L29,111@4124L34,112@4175L34,114@4229L44,115@4289L42,117@4350L67,118@4437L45,119@4504L54,121@4591L554,121@4564L581,135@5237L65,136@5320L71,137@5410L64,139@5492L35,140@5544L66,198@7735L10451,198@7669L10517:ProductCard.kt#i65cod");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(product) : startRestartGroup.changedInstance(product) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(onEdit) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(onArchived) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(onRestored) ? 131072 : 65536;
        }
        if (!startRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1440006644, i2, -1, "uz.FonRo.pos.ui.catalog.ProductCardSheet (ProductCard.kt:101)");
            }
            Repo repo2 = app.getRepo();
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
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(repo2.getSync(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            final boolean z = product.isArchived() == 1;
            final String currency = repo2.currency();
            final boolean can = repo2.can(Perm.VIEW_PURCHASE_PRICE);
            final boolean can2 = repo2.can(Perm.VIEW_PROFIT);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 866931862, "CC(remember):ProductCard.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(mutableStateOf$default3);
                rememberedValue2 = mutableStateOf$default3;
            }
            final MutableState mutableState3 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 866933494, "CC(remember):ProductCard.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 866935232, "CC(remember):ProductCard.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CardPeriod.WEEK, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState5 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 866937150, "CC(remember):ProductCard.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CardTab.CHART, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState6 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            long id = product.getId();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 866939127, "CC(remember):ProductCard.kt#9igjgp");
            boolean changed = startRestartGroup.changed(id);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
                startRestartGroup.updateRememberedValue(mutableStateOf$default);
                rememberedValue6 = mutableStateOf$default;
            }
            MutableState mutableState7 = (MutableState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            long id2 = product.getId();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 866941889, "CC(remember):ProductCard.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(id2);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                startRestartGroup.updateRememberedValue(mutableStateOf$default2);
                rememberedValue7 = mutableStateOf$default2;
            }
            MutableState mutableState8 = (MutableState) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            long id3 = product.getId();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 866944042, "CC(remember):ProductCard.kt#9igjgp");
            boolean changed3 = startRestartGroup.changed(id3);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            final MutableState mutableState9 = (MutableState) rememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Long valueOf = Long.valueOf(product.getId());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 866947326, "CC(remember):ProductCard.kt#9igjgp");
            boolean changed4 = startRestartGroup.changed(mutableState8) | startRestartGroup.changed(mutableState9) | startRestartGroup.changed(mutableState7);
            int i6 = i2 & 112;
            boolean z2 = changed4 | (i6 == 32 || ((i2 & 64) != 0 && startRestartGroup.changedInstance(product)));
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                i3 = i2;
                mutableState = mutableState8;
                composer3 = startRestartGroup;
                mutableState2 = mutableState7;
                i4 = i6;
                repo = repo2;
                i5 = 0;
                obj = (Function2) new ProductCardKt$ProductCardSheet$1$1(mutableState, mutableState9, product, mutableState2, null);
                composer3.updateRememberedValue(obj);
            } else {
                i3 = i2;
                mutableState = mutableState8;
                repo = repo2;
                obj = rememberedValue9;
                i5 = 0;
                composer3 = startRestartGroup;
                mutableState2 = mutableState7;
                i4 = i6;
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) obj, composer3, i5);
            Object ProductCardSheet$lambda$0 = ProductCardSheet$lambda$0(collectAsStateWithLifecycle);
            long id4 = product.getId();
            ComposerKt.sourceInformationMarkerStart(composer3, 866967509, "CC(remember):ProductCard.kt#9igjgp");
            boolean changed5 = composer3.changed(ProductCardSheet$lambda$0) | composer3.changed(id4);
            Object rememberedValue10 = composer3.rememberedValue();
            if (changed5 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                SyncData ProductCardSheet$lambda$02 = ProductCardSheet$lambda$0(collectAsStateWithLifecycle);
                rememberedValue10 = stockInsOf(ProductCardSheet$lambda$02 != null ? ProductCardSheet$lambda$02.getStockIn() : null, product);
                composer3.updateRememberedValue(rememberedValue10);
            }
            final List list = (List) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            Object ProductCardSheet$lambda$03 = ProductCardSheet$lambda$0(collectAsStateWithLifecycle);
            long id5 = product.getId();
            ComposerKt.sourceInformationMarkerStart(composer3, 866970171, "CC(remember):ProductCard.kt#9igjgp");
            boolean changed6 = composer3.changed(ProductCardSheet$lambda$03) | composer3.changed(id5);
            Object rememberedValue11 = composer3.rememberedValue();
            if (changed6 || rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                SyncData ProductCardSheet$lambda$04 = ProductCardSheet$lambda$0(collectAsStateWithLifecycle);
                rememberedValue11 = auditsOf(ProductCardSheet$lambda$04 != null ? ProductCardSheet$lambda$04.getInventoryAudits() : null, product);
                composer3.updateRememberedValue(rememberedValue11);
            }
            final List list2 = (List) rememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            Object ProductCardSheet$lambda$05 = ProductCardSheet$lambda$0(collectAsStateWithLifecycle);
            long id6 = product.getId();
            ComposerKt.sourceInformationMarkerStart(composer3, 866973044, "CC(remember):ProductCard.kt#9igjgp");
            boolean changed7 = composer3.changed(ProductCardSheet$lambda$05) | composer3.changed(id6);
            Object rememberedValue12 = composer3.rememberedValue();
            if (changed7 || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                SyncData ProductCardSheet$lambda$06 = ProductCardSheet$lambda$0(collectAsStateWithLifecycle);
                rememberedValue12 = returnsOf(ProductCardSheet$lambda$06 != null ? ProductCardSheet$lambda$06.getReturns() : null, product);
                composer3.updateRememberedValue(rememberedValue12);
            }
            final List list3 = (List) rememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            CardPeriod ProductCardSheet$lambda$8 = ProductCardSheet$lambda$8(mutableState5);
            ComposerKt.sourceInformationMarkerStart(composer3, 866975639, "CC(remember):ProductCard.kt#9igjgp");
            boolean changed8 = composer3.changed(ProductCardSheet$lambda$8.ordinal());
            Object rememberedValue13 = composer3.rememberedValue();
            if (changed8 || rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                rememberedValue13 = range(ProductCardSheet$lambda$8(mutableState5));
                composer3.updateRememberedValue(rememberedValue13);
            }
            CardRange cardRange = (CardRange) rememberedValue13;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            Object ProductCardSheet$lambda$14 = ProductCardSheet$lambda$14(mutableState2);
            ComposerKt.sourceInformationMarkerStart(composer3, 866977334, "CC(remember):ProductCard.kt#9igjgp");
            boolean changed9 = composer3.changed(ProductCardSheet$lambda$14) | composer3.changed(list3) | composer3.changed(cardRange);
            Object rememberedValue14 = composer3.rememberedValue();
            if (changed9 || rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                rememberedValue14 = statsOf(ProductCardSheet$lambda$14(mutableState2), list3, cardRange);
                composer3.updateRememberedValue(rememberedValue14);
            }
            final CardStats cardStats = (CardStats) rememberedValue14;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            final MutableState mutableState10 = mutableState;
            Composer composer4 = composer3;
            int i7 = i3;
            final Repo repo3 = repo;
            boolean z3 = true;
            SheetsKt.OxCardSheet(LangKt.tx("Карточка товара", new Object[0]), onDismiss, null, false, false, false, null, ComposableLambdaKt.rememberComposableLambda(1566142480, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.ProductCardKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return ProductCardKt.ProductCardSheet$lambda$28(CardStats.this, list, list2, list3, product, z, can2, currency, repo3, coroutineScope, onRestored, onDismiss, onEdit, mutableState4, mutableState3, can, mutableState5, mutableState10, mutableState9, mutableState6, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composer4, 54), composer4, ((i7 >> 3) & 112) | 12582912, 124);
            composer2 = composer4;
            if (ProductCardSheet$lambda$2(mutableState3)) {
                composer2.startReplaceGroup(1119068234);
                ComposerKt.sourceInformation(composer2, "428@18455L13,429@18494L26,424@18222L308");
                String tx = LangKt.tx("Архивировать товар?", new Object[0]);
                String tx2 = LangKt.tx("«%s» будет скрыт из продажи. Остаток и история сохранятся.", product.getName());
                String tx3 = LangKt.tx("Архивировать", new Object[0]);
                ComposerKt.sourceInformationMarkerStart(composer2, 867390433, "CC(remember):ProductCard.kt#9igjgp");
                boolean changedInstance = composer2.changedInstance(coroutineScope) | (i4 == 32 || ((i7 & 64) != 0 && composer2.changedInstance(product))) | composer2.changedInstance(repo3) | ((57344 & i7) == 16384);
                if ((i7 & 896) != 256) {
                    z3 = false;
                }
                boolean z4 = changedInstance | z3;
                Object rememberedValue15 = composer2.rememberedValue();
                if (z4 || rememberedValue15 == Composer.INSTANCE.getEmpty()) {
                    str = "CC(remember):ProductCard.kt#9igjgp";
                    Object obj2 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.ProductCardKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProductCardSheet$lambda$29$0;
                            ProductCardSheet$lambda$29$0 = ProductCardKt.ProductCardSheet$lambda$29$0(CoroutineScope.this, mutableState4, product, repo3, onArchived, onDismiss);
                            return ProductCardSheet$lambda$29$0;
                        }
                    };
                    composer2.updateRememberedValue(obj2);
                    rememberedValue15 = obj2;
                } else {
                    str = "CC(remember):ProductCard.kt#9igjgp";
                }
                Function0 function0 = (Function0) rememberedValue15;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, 867391694, str);
                Object rememberedValue16 = composer2.rememberedValue();
                if (rememberedValue16 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue16 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.ProductCardKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProductCardSheet$lambda$30$0;
                            ProductCardSheet$lambda$30$0 = ProductCardKt.ProductCardSheet$lambda$30$0(MutableState.this);
                            return ProductCardSheet$lambda$30$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue16);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                SheetsKt.OxConfirmSheet(tx, tx2, tx3, null, function0, (Function0) rememberedValue16, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 8);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(1119379598);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.ProductCardKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return ProductCardKt.ProductCardSheet$lambda$31(FonRoApp.this, product, onDismiss, onEdit, onArchived, onRestored, i, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    private static final boolean ProductCardSheet$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ProductCardSheet$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean ProductCardSheet$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProductCardSheet$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final CardPeriod ProductCardSheet$lambda$8(MutableState<CardPeriod> mutableState) {
        return mutableState.getValue();
    }

    private static final CardTab ProductCardSheet$lambda$11(MutableState<CardTab> mutableState) {
        return mutableState.getValue();
    }

    private static final List<SaleRow> ProductCardSheet$lambda$14(MutableState<List<SaleRow>> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ProductCardSheet$lambda$17(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProductCardSheet$lambda$18(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String ProductCardSheet$lambda$20(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final void ProductCardSheet$archive(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, Product product, Repo repo, Function0<Unit> function0, Function0<Unit> function02) {
        if (ProductCardSheet$lambda$5(mutableState)) {
            return;
        }
        ProductCardSheet$lambda$6(mutableState, true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ProductCardKt$ProductCardSheet$archive$1(product, repo, function0, function02, mutableState, null), 3, null);
    }

    private static final void ProductCardSheet$restore(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, Product product, Repo repo, Function1<? super Product, Unit> function1, Function0<Unit> function0) {
        if (ProductCardSheet$lambda$5(mutableState)) {
            return;
        }
        ProductCardSheet$lambda$6(mutableState, true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ProductCardKt$ProductCardSheet$restore$1(product, repo, function1, function0, mutableState, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x05fe, code lost:
    
        if (r1 != null) goto L124;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit ProductCardSheet$lambda$28(uz.FonRo.pos.ui.catalog.CardStats r32, java.util.List r33, java.util.List r34, java.util.List r35, final uz.FonRo.pos.data.model.Product r36, final boolean r37, final boolean r38, final java.lang.String r39, final uz.FonRo.pos.data.repo.Repo r40, final kotlinx.coroutines.CoroutineScope r41, final kotlin.jvm.functions.Function1 r42, final kotlin.jvm.functions.Function0 r43, final kotlin.jvm.functions.Function0 r44, final androidx.compose.runtime.MutableState r45, final androidx.compose.runtime.MutableState r46, final boolean r47, final androidx.compose.runtime.MutableState r48, androidx.compose.runtime.MutableState r49, androidx.compose.runtime.MutableState r50, androidx.compose.runtime.MutableState r51, androidx.compose.foundation.layout.ColumnScope r52, androidx.compose.runtime.Composer r53, int r54) {
        /*
            Method dump skipped, instructions count: 2680
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.catalog.ProductCardKt.ProductCardSheet$lambda$28(uz.FonRo.pos.ui.catalog.CardStats, java.util.List, java.util.List, java.util.List, uz.FonRo.pos.data.model.Product, boolean, boolean, java.lang.String, uz.FonRo.pos.data.repo.Repo, kotlinx.coroutines.CoroutineScope, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, boolean, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductCardSheet$lambda$28$0$0(final Product product, boolean z, boolean z2, String str, final Repo repo, final CoroutineScope coroutineScope, final Function1 function1, final Function0 function0, final Function0 function02, final MutableState mutableState, final MutableState mutableState2, ColumnScope OxSoftCard, Composer composer, int i) {
        int i2;
        RowScopeInstance rowScopeInstance;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C205@8033L1313,237@9364L11,238@9392L1325:ProductCard.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-941934452, i, -1, "uz.FonRo.pos.ui.catalog.ProductCardSheet.<anonymous>.<anonymous>.<anonymous> (ProductCard.kt:205)");
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
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 530995080, "C210@8261L184,215@8466L679,231@9166L162:ProductCard.kt#i65cod");
            Ox ox = Ox.INSTANCE;
            CatalogScreenKt.m9774ProductThumbRFCenO8(product, z ? ox.m10223getPurple0d7_KjU() : ox.m10192getCyan0d7_KjU(), Dp.m6989constructorimpl(64.0f), composer, Product.$stable | 384);
            Modifier weight$default = RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1406364638, "C216@8520L223,222@8768L10,223@8803L320:ProductCard.kt#i65cod");
            TextKt.m2798Text4IGK_g(product.getName(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 3, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH2(), composer, 0, 3120, 55294);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(4.0f), composer, 6);
            String tx = LangKt.tx("Наценка с единицы: ", new Object[0]);
            TextKt.m2798Text4IGK_g(tx + Fmt.INSTANCE.money(Double.valueOf(z2 ? product.getSalePrice() - product.getPurchasePrice() : AudioStats.AUDIO_AMPLITUDE_NONE), str), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            String tx2 = z ? LangKt.tx("В архиве", new Object[0]) : LangKt.tx("Активен", new Object[0]);
            Ox ox2 = Ox.INSTANCE;
            Composer composer2 = composer;
            CatalogScreenKt.m9775TagPill3IgeMak(tx2, z ? ox2.m10223getPurple0d7_KjU() : ox2.m10211getOk0d7_KjU(), null, composer2, 0, 4);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer2, 6);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(9.0f));
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), composer2, 6);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, fillMaxWidth$default2);
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
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 1452007085, "C:ProductCard.kt#i65cod");
            if (z) {
                composer2.startReplaceGroup(1451997443);
                ComposerKt.sourceInformation(composer2, "");
                if (repo.can(Perm.EDIT_PRODUCT)) {
                    composer2.startReplaceGroup(1452053460);
                    ComposerKt.sourceInformation(composer2, "245@9729L13,244@9667L239");
                    String tx3 = LangKt.tx("Восстановить", new Object[0]);
                    ComposerKt.sourceInformationMarkerStart(composer2, -91704236, "CC(remember):ProductCard.kt#9igjgp");
                    boolean changedInstance = composer2.changedInstance(coroutineScope) | composer2.changedInstance(product) | composer2.changedInstance(repo) | composer2.changed(function1) | composer2.changed(function0);
                    Object rememberedValue = composer2.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        Function0 function03 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.ProductCardKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit ProductCardSheet$lambda$28$0$0$1$0$0;
                                ProductCardSheet$lambda$28$0$0$1$0$0 = ProductCardKt.ProductCardSheet$lambda$28$0$0$1$0$0(CoroutineScope.this, mutableState, product, repo, function1, function0);
                                return ProductCardSheet$lambda$28$0$0$1$0$0;
                            }
                        };
                        composer2.updateRememberedValue(function03);
                        rememberedValue = function03;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    BasicsKt.OxButton(tx3, (Function0) rememberedValue, RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.OK, null, !ProductCardSheet$lambda$5(mutableState), false, null, composer2, 3072, 208);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(1452336955);
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(1452387640);
                ComposerKt.sourceInformation(composer2, "");
                if (repo.can(Perm.EDIT_PRODUCT)) {
                    composer2.startReplaceGroup(1452432311);
                    ComposerKt.sourceInformation(composer2, "253@10107L12,252@10049L236");
                    String tx4 = LangKt.tx("Изменить", new Object[0]);
                    ComposerKt.sourceInformationMarkerStart(composer2, -91692141, "CC(remember):ProductCard.kt#9igjgp");
                    boolean changed = composer2.changed(function02);
                    Object rememberedValue2 = composer2.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.ProductCardKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit ProductCardSheet$lambda$28$0$0$1$1$0;
                                ProductCardSheet$lambda$28$0$0$1$1$0 = ProductCardKt.ProductCardSheet$lambda$28$0$0$1$1$0(Function0.this);
                                return ProductCardSheet$lambda$28$0$0$1$1$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    rowScopeInstance = rowScopeInstance3;
                    i2 = 0;
                    BasicsKt.OxButton(tx4, (Function0) rememberedValue2, RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.CYAN, null, !ProductCardSheet$lambda$5(mutableState), false, null, composer, 3072, 208);
                    composer2 = composer;
                    composer2.endReplaceGroup();
                } else {
                    i2 = 0;
                    rowScopeInstance = rowScopeInstance3;
                    composer2.startReplaceGroup(1452712923);
                    composer2.endReplaceGroup();
                }
                if (repo.can(Perm.DELETE_PRODUCT)) {
                    composer2.startReplaceGroup(1452781929);
                    ComposerKt.sourceInformation(composer2, "260@10458L25,259@10401L250");
                    String tx5 = LangKt.tx("В архив", new Object[i2]);
                    ComposerKt.sourceInformationMarkerStart(composer2, -91680896, "CC(remember):ProductCard.kt#9igjgp");
                    Object rememberedValue3 = composer2.rememberedValue();
                    if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.catalog.ProductCardKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit ProductCardSheet$lambda$28$0$0$1$2$0;
                                ProductCardSheet$lambda$28$0$0$1$2$0 = ProductCardKt.ProductCardSheet$lambda$28$0$0$1$2$0(MutableState.this);
                                return ProductCardSheet$lambda$28$0$0$1$2$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    BasicsKt.OxButton(tx5, (Function0) rememberedValue3, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.DANGER, null, !ProductCardSheet$lambda$5(mutableState), false, null, composer2, 3120, 208);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(1453075995);
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
    public static final Unit ProductCardSheet$lambda$28$0$0$1$0$0(CoroutineScope coroutineScope, MutableState mutableState, Product product, Repo repo, Function1 function1, Function0 function0) {
        ProductCardSheet$restore(coroutineScope, mutableState, product, repo, function1, function0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductCardSheet$lambda$28$0$0$1$1$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductCardSheet$lambda$28$0$0$1$2$0(MutableState mutableState) {
        ProductCardSheet$lambda$3(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
    
        if (r2 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0073, code lost:
    
        if (r2 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0259, code lost:
    
        if (r1 != null) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit ProductCardSheet$lambda$28$0$1(uz.FonRo.pos.data.model.Product r20, uz.FonRo.pos.data.repo.Repo r21, boolean r22, boolean r23, java.lang.String r24, androidx.compose.foundation.layout.ColumnScope r25, androidx.compose.runtime.Composer r26, int r27) {
        /*
            Method dump skipped, instructions count: 631
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.catalog.ProductCardKt.ProductCardSheet$lambda$28$0$1(uz.FonRo.pos.data.model.Product, uz.FonRo.pos.data.repo.Repo, boolean, boolean, java.lang.String, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductCardSheet$lambda$28$0$3$0(MutableState mutableState, String key) {
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        Iterator<E> it = CardPeriod.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((CardPeriod) obj).getKey(), key)) {
                break;
            }
        }
        CardPeriod cardPeriod = (CardPeriod) obj;
        if (cardPeriod != null) {
            mutableState.setValue(cardPeriod);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductCardSheet$lambda$28$0$6$0(MutableState mutableState, String key) {
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        Iterator<E> it = CardTab.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((CardTab) obj).getKey(), key)) {
                break;
            }
        }
        CardTab cardTab = (CardTab) obj;
        if (cardTab != null) {
            mutableState.setValue(cardTab);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductCardSheet$lambda$29$0(CoroutineScope coroutineScope, MutableState mutableState, Product product, Repo repo, Function0 function0, Function0 function02) {
        ProductCardSheet$archive(coroutineScope, mutableState, product, repo, function0, function02);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductCardSheet$lambda$30$0(MutableState mutableState) {
        ProductCardSheet$lambda$3(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void InfoLine(final java.lang.String r66, final java.lang.String r67, boolean r68, boolean r69, androidx.compose.runtime.Composer r70, final int r71, final int r72) {
        /*
            Method dump skipped, instructions count: 895
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.catalog.ProductCardKt.InfoLine(java.lang.String, java.lang.String, boolean, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: MetricTile-Bx497Mc, reason: not valid java name */
    private static final void m9802MetricTileBx497Mc(final RowScope rowScope, final String str, final String str2, final long j, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1629463255);
        ComposerKt.sourceInformation(startRestartGroup, "C(MetricTile)P(!1,2,1:c#ui.graphics.Color)468@19658L525:ProductCard.kt#i65cod");
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
                ComposerKt.traceEventStart(-1629463255, i2, -1, "uz.FonRo.pos.ui.catalog.MetricTile (ProductCard.kt:467)");
            }
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), OxShape.INSTANCE.getTile()), Ox.INSTANCE.m10241tintBg5vOe2sY(j, 0.12f), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10242tintBorderl2rxGTc(j), OxShape.INSTANCE.getTile()), Dp.m6989constructorimpl(11.0f), Dp.m6989constructorimpl(10.0f));
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1338932017, "C476@19934L72,477@20015L162:ProductCard.kt#i65cod");
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.ProductCardKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductCardKt.MetricTile_Bx497Mc$lambda$1(RowScope.this, str, str2, j, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* renamed from: EventCard-sW7UJKQ, reason: not valid java name */
    private static final void m9801EventCardsW7UJKQ(final String str, final long j, final String str2, final String str3, final List<String> list, Composer composer, final int i) {
        String str4;
        int i2;
        String str5;
        String str6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(246231968);
        ComposerKt.sourceInformation(startRestartGroup, "C(EventCard)P(1,3:c#ui.graphics.Color,4)495@20478L1223,495@20406L1295:ProductCard.kt#i65cod");
        if ((i & 6) == 0) {
            str4 = str;
            i2 = (startRestartGroup.changed(str4) ? 4 : 2) | i;
        } else {
            str4 = str;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            str5 = str2;
            i2 |= startRestartGroup.changed(str5) ? 256 : 128;
        } else {
            str5 = str2;
        }
        if ((i & 3072) == 0) {
            str6 = str3;
            i2 |= startRestartGroup.changed(str6) ? 2048 : 1024;
        } else {
            str6 = str3;
        }
        if ((i & 24576) == 0) {
            i2 |= (32768 & i) == 0 ? startRestartGroup.changed(list) : startRestartGroup.changedInstance(list) ? 16384 : 8192;
        }
        if (!startRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(246231968, i2, -1, "uz.FonRo.pos.ui.catalog.EventCard (ProductCard.kt:494)");
            }
            final String str7 = str5;
            final String str8 = str4;
            final String str9 = str6;
            composer2 = startRestartGroup;
            BasicsKt.m9833OxSoftCardCe4qNIY(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(8.0f), 7, null), Dp.m6989constructorimpl(12.0f), null, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-579016666, true, new Function3() { // from class: uz.FonRo.pos.ui.catalog.ProductCardKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ProductCardKt.EventCard_sW7UJKQ$lambda$0(j, str8, list, str7, str9, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), composer2, 1572918, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.catalog.ProductCardKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductCardKt.EventCard_sW7UJKQ$lambda$1(str, j, str2, str3, list, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit EventCard_sW7UJKQ$lambda$0(long j, String str, List list, String str2, String str3, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C496@20488L1207:ProductCard.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-579016666, i, -1, "uz.FonRo.pos.ui.catalog.EventCard.<anonymous> (ProductCard.kt:496)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -568539992, "C501@20676L307,510@20996L689:ProductCard.kt#i65cod");
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(34.0f)), OxShape.INSTANCE.getIconChip()), Ox.INSTANCE.m10241tintBg5vOe2sY(j, 0.14f), null, 2, null);
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
            ComposerKt.sourceInformationMarkerStart(composer, -28602543, "C508@20935L34:ProductCard.kt#i65cod");
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
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
            ComposerKt.sourceInformationMarkerStart(composer, -257403666, "C511@21042L382:ProductCard.kt#i65cod");
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            Alignment.Vertical top2 = Alignment.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, top2, composer, 54);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1614378998, "C516@21269L68,517@21358L48:ProductCard.kt#i65cod");
            TextKt.m2798Text4IGK_g(str2, RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), composer, 0, 0, 65532);
            TextKt.m2798Text4IGK_g(str3, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 3072, 57342);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.startReplaceGroup(1238635200);
            ComposerKt.sourceInformation(composer, "*520@21485L168");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                TextKt.m2798Text4IGK_g((String) it.next(), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(2.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 48, 0, 65532);
            }
            composer.endReplaceGroup();
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

    private static final CardRange range(CardPeriod cardPeriod) {
        String str = Fmt.INSTANCE.todayISO();
        int i = WhenMappings.$EnumSwitchMapping$1[cardPeriod.ordinal()];
        if (i == 1) {
            IntProgression downTo = RangesKt.downTo(6, 0);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(downTo, 10));
            Iterator<Integer> it = downTo.iterator();
            while (it.hasNext()) {
                arrayList.add(Fmt.INSTANCE.daysAgo(((IntIterator) it).nextInt()));
            }
            ArrayList arrayList2 = arrayList;
            String str2 = (String) CollectionsKt.first((List) arrayList2);
            ArrayList<String> arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            for (String str3 : arrayList3) {
                arrayList4.add(TuplesKt.to(str3, Fmt.INSTANCE.shortWeekday(str3)));
            }
            return new CardRange(str2, str, arrayList4, false);
        }
        if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            List reversed = CollectionsKt.reversed(Fmt.INSTANCE.lastMonths(12));
            String str4 = CollectionsKt.first((List<? extends Object>) reversed) + "-01";
            List<String> list = reversed;
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (String str5 : list) {
                arrayList5.add(TuplesKt.to(str5, StringsKt.take(Fmt.INSTANCE.monthTitle(str5), 3)));
            }
            return new CardRange(str4, str, arrayList5, true);
        }
        IntProgression downTo2 = RangesKt.downTo(29, 0);
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(downTo2, 10));
        Iterator<Integer> it2 = downTo2.iterator();
        while (it2.hasNext()) {
            arrayList6.add(Fmt.INSTANCE.daysAgo(((IntIterator) it2).nextInt()));
        }
        ArrayList arrayList7 = arrayList6;
        String str6 = (String) CollectionsKt.first((List) arrayList7);
        ArrayList<String> arrayList8 = arrayList7;
        ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList8, 10));
        for (String str7 : arrayList8) {
            String substring = str7.substring(8);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            arrayList9.add(TuplesKt.to(str7, substring));
        }
        return new CardRange(str6, str, arrayList9, false);
    }

    private static final String statsOf$bucketKey(CardRange cardRange, String str) {
        String dayOf = Fmt.INSTANCE.dayOf(str);
        return cardRange.getByMonth() ? StringsKt.take(dayOf, 7) : dayOf;
    }

    private static final CardStats statsOf(List<SaleRow> list, List<Triple<ReturnDoc, Double, Double>> list2, CardRange cardRange) {
        ArrayList<SaleRow> arrayList = new ArrayList();
        for (Object obj : list) {
            String dayOf = Fmt.INSTANCE.dayOf(((SaleRow) obj).getSoldAt());
            if (dayOf.length() > 0 && dayOf.compareTo(cardRange.getFrom()) >= 0 && dayOf.compareTo(cardRange.getTo()) <= 0) {
                arrayList.add(obj);
            }
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        for (SaleRow saleRow : arrayList) {
            double returnedShare = 1.0d - saleRow.getReturnedShare();
            double max = Math.max(saleRow.getQuantity() - saleRow.getReturnedQuantity(), AudioStats.AUDIO_AMPLITUDE_NONE);
            double totalAmount = saleRow.getTotalAmount() * returnedShare;
            d += max;
            d2 += totalAmount;
            d3 += saleRow.getProfit() * returnedShare;
            String statsOf$bucketKey = statsOf$bucketKey(cardRange, saleRow.getSoldAt());
            HashMap hashMap3 = hashMap;
            Double d4 = (Double) hashMap.get(statsOf$bucketKey);
            hashMap3.put(statsOf$bucketKey, Double.valueOf((d4 != null ? d4.doubleValue() : 0.0d) + max));
            HashMap hashMap4 = hashMap2;
            Double d5 = (Double) hashMap2.get(statsOf$bucketKey);
            hashMap4.put(statsOf$bucketKey, Double.valueOf((d5 != null ? d5.doubleValue() : 0.0d) + totalAmount));
        }
        Iterator<T> it = list2.iterator();
        double d6 = 0.0d;
        while (it.hasNext()) {
            Triple triple = (Triple) it.next();
            String dayOf2 = Fmt.INSTANCE.dayOf(((ReturnDoc) triple.getFirst()).getCreatedAt());
            if (dayOf2.length() > 0 && dayOf2.compareTo(cardRange.getFrom()) >= 0 && dayOf2.compareTo(cardRange.getTo()) <= 0) {
                d6 += ((Number) triple.getSecond()).doubleValue();
            }
        }
        List<Pair<String, String>> buckets = cardRange.getBuckets();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(buckets, 10));
        Iterator<T> it2 = buckets.iterator();
        while (it2.hasNext()) {
            Pair pair = (Pair) it2.next();
            String str = (String) pair.component1();
            String str2 = (String) pair.component2();
            Double d7 = (Double) hashMap.get(str);
            arrayList2.add(TuplesKt.to(str2, Double.valueOf(d7 != null ? d7.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE)));
        }
        ArrayList arrayList3 = arrayList2;
        List<Pair<String, String>> buckets2 = cardRange.getBuckets();
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(buckets2, 10));
        Iterator<T> it3 = buckets2.iterator();
        while (it3.hasNext()) {
            Pair pair2 = (Pair) it3.next();
            String str3 = (String) pair2.component1();
            String str4 = (String) pair2.component2();
            Double d8 = (Double) hashMap2.get(str3);
            arrayList4.add(TuplesKt.to(str4, Double.valueOf(d8 != null ? d8.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE)));
        }
        return new CardStats(d, d2, d3, d6, arrayList3, arrayList4);
    }

    private static final List<Triple<StockInDoc, Double, Double>> stockInsOf(List<StockInDoc> list, Product product) {
        Triple triple;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (StockInDoc stockInDoc : list) {
            List<StockInItem> items = stockInDoc.getItems();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : items) {
                StockInItem stockInItem = (StockInItem) obj;
                if (stockInItem.getProductId() == product.getId() || stockInItem.getProductServerId() == product.getId() || StringsKt.equals(stockInItem.getProductName(), product.getName(), true)) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = arrayList2;
            if (arrayList3.isEmpty()) {
                triple = null;
            } else {
                ArrayList arrayList4 = arrayList3;
                Iterator it = arrayList4.iterator();
                double d = AudioStats.AUDIO_AMPLITUDE_NONE;
                while (it.hasNext()) {
                    d += ((StockInItem) it.next()).getQuantity();
                }
                Double valueOf = Double.valueOf(d);
                Iterator it2 = arrayList4.iterator();
                if (!it2.hasNext()) {
                    throw new NoSuchElementException();
                }
                double purchasePrice = ((StockInItem) it2.next()).getPurchasePrice();
                while (it2.hasNext()) {
                    purchasePrice = Math.max(purchasePrice, ((StockInItem) it2.next()).getPurchasePrice());
                }
                triple = new Triple(stockInDoc, valueOf, Double.valueOf(purchasePrice));
            }
            if (triple != null) {
                arrayList.add(triple);
            }
        }
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: uz.FonRo.pos.ui.catalog.ProductCardKt$stockInsOf$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((StockInDoc) ((Triple) t2).getFirst()).getCreatedAt(), ((StockInDoc) ((Triple) t).getFirst()).getCreatedAt());
            }
        });
    }

    private static final List<AuditRow> auditsOf(List<AuditDoc> list, Product product) {
        AuditRow auditRow;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (AuditDoc auditDoc : list) {
            List<AuditItem> items = auditDoc.getItems();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : items) {
                AuditItem auditItem = (AuditItem) obj;
                if (auditItem.getProductId() == product.getId() || StringsKt.equals(auditItem.getProductName(), product.getName(), true)) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = arrayList2;
            if (arrayList3.isEmpty()) {
                auditRow = null;
            } else {
                ArrayList arrayList4 = arrayList3;
                Iterator it = arrayList4.iterator();
                double d = AudioStats.AUDIO_AMPLITUDE_NONE;
                double d2 = 0.0d;
                while (it.hasNext()) {
                    d += ((AuditItem) it.next()).getSystemQty();
                }
                Iterator it2 = arrayList4.iterator();
                double d3 = 0.0d;
                while (it2.hasNext()) {
                    d2 += ((AuditItem) it2.next()).getActualQty();
                }
                Iterator it3 = arrayList4.iterator();
                while (it3.hasNext()) {
                    d3 += ((AuditItem) it3.next()).getDiff();
                }
                auditRow = new AuditRow(auditDoc, d, d2, d3);
            }
            if (auditRow != null) {
                arrayList.add(auditRow);
            }
        }
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: uz.FonRo.pos.ui.catalog.ProductCardKt$auditsOf$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((AuditRow) t2).getDoc().getCreatedAt(), ((AuditRow) t).getDoc().getCreatedAt());
            }
        });
    }

    private static final List<Triple<ReturnDoc, Double, Double>> returnsOf(List<ReturnDoc> list, Product product) {
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (ReturnDoc returnDoc : list) {
            List<ReturnLine> lines = returnDoc.getLines();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : lines) {
                if (((ReturnLine) obj).getProductId() == product.getId()) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = arrayList2;
            Triple triple = null;
            if (!arrayList3.isEmpty()) {
                ArrayList arrayList4 = arrayList3;
                Iterator it = arrayList4.iterator();
                double d = 0.0d;
                while (it.hasNext()) {
                    d += ((ReturnLine) it.next()).getQuantity();
                }
                Iterator it2 = arrayList4.iterator();
                double d2 = 0.0d;
                while (it2.hasNext()) {
                    d2 += ((ReturnLine) it2.next()).getAmount();
                }
                Double valueOf = Double.valueOf(d2);
                Double d3 = valueOf.doubleValue() > AudioStats.AUDIO_AMPLITUDE_NONE ? valueOf : null;
                triple = new Triple(returnDoc, Double.valueOf(d), Double.valueOf(d3 != null ? d3.doubleValue() : Math.min(returnDoc.getAmount(), product.getSalePrice() * d)));
            }
            if (triple != null) {
                arrayList.add(triple);
            }
        }
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: uz.FonRo.pos.ui.catalog.ProductCardKt$returnsOf$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((ReturnDoc) ((Triple) t2).getFirst()).getCreatedAt(), ((ReturnDoc) ((Triple) t).getFirst()).getCreatedAt());
            }
        });
    }

    private static final SyncData ProductCardSheet$lambda$0(State<SyncData> state) {
        return state.getValue();
    }
}
