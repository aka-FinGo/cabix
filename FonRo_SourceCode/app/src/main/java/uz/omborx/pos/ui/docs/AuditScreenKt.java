package uz.FonRo.pos.ui.docs;

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
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Num;
import uz.FonRo.pos.core.Units;
import uz.FonRo.pos.data.local.CacheStore;
import uz.FonRo.pos.data.model.AuditDoc;
import uz.FonRo.pos.data.model.AuditItem;
import uz.FonRo.pos.data.model.Category;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.model.SyncData;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnSize;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.ChipTint;
import uz.FonRo.pos.ui.components.ChipTone;
import uz.FonRo.pos.ui.components.ChipsKt;
import uz.FonRo.pos.ui.components.FieldsKt;
import uz.FonRo.pos.ui.components.ModifiersKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.PeriodKind;
import uz.FonRo.pos.ui.components.PeriodState;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxDim;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: AuditScreen.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010\b\u001a\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u0016\u001a\u001e\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002\u001a\u0010\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0018H\u0002\u001am\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\"2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050)H\u0003b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010*\u001aç\u0002\u0010+\u001a\u00020\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u001a2\u0006\u0010.\u001a\u00020\u00182\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u000201\u0012\u0006\u0012\u0004\u0018\u00010\u000f002\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u000f002\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0001002\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00012\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005002\u0006\u00108\u001a\u00020\u00012\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005002\u0006\u0010:\u001a\u00020\u00012\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005002\u0006\u0010<\u001a\u00020\"2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00050)2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00050)2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u0005002\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u0005002\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0005002\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0005002\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00050)2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00050)H\u0003b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010E\u001ay\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020-2\b\u0010H\u001a\u0004\u0018\u00010\u000f2\u0006\u0010I\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u00012\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00050)2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00050)2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00050)2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00050)H\u0003b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010L\u001aE\u0010M\u001a\u00020\u0005*\u00020N2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\u00012\u0006\u0010P\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020\u0014H\u0003b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0004\bR\u0010S\u001aM\u0010T\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u000f2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00050)H\u0003b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010W\u001aY\u0010X\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u000f002\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00050)H\u0003b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010Y\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006²\u0006\u0010\u0010Z\u001a\b\u0012\u0004\u0012\u00020-0\u001aX\u008a\u0084\u0002²\u0006\u0010\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0\u001aX\u008a\u0084\u0002²\u0006\f\u0010]\u001a\u0004\u0018\u00010^X\u008a\u0084\u0002²\u0006\n\u00106\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\u0010\u0010_\u001a\b\u0012\u0004\u0012\u00020-0\u001aX\u008a\u008e\u0002²\u0006\n\u0010`\u001a\u00020\"X\u008a\u008e\u0002²\u0006\n\u0010a\u001a\u00020\"X\u008a\u008e\u0002²\u0006\n\u0010:\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u00108\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010b\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010c\u001a\u00020\"X\u008a\u008e\u0002²\u0006\f\u0010d\u001a\u0004\u0018\u00010eX\u008a\u008e\u0002²\u0006\n\u0010f\u001a\u00020\"X\u008a\u008e\u0002²\u0006\f\u0010g\u001a\u0004\u0018\u00010\u001bX\u008a\u008e\u0002²\u0006\n\u0010<\u001a\u00020\"X\u008a\u008e\u0002²\u0006\n\u0010h\u001a\u00020iX\u008a\u008e\u0002²\u0006\n\u0010j\u001a\u00020\"X\u008a\u008e\u0002²\u0006\n\u0010k\u001a\u00020\"X\u008a\u008e\u0002²\u0006\n\u00104\u001a\u000205X\u008a\u0084\u0002"}, d2 = {"FILTER_ALL", "", "FILTER_TODO", "FILTER_DIFF", "AuditScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "(Luz/FonRo/pos/FonRoApp;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "signedQty", "value", "", "signedMoney", FirebaseAnalytics.Param.CURRENCY, "signedNf", "diffColor", "Landroidx/compose/ui/graphics/Color;", AuditScreenKt.FILTER_DIFF, "(D)J", "docNumberOf", "", AuditScreenKt.FILTER_ALL, "", "Luz/FonRo/pos/data/model/AuditDoc;", "doc", "docNumberText", "number", "AuditHero", "stockValue", "byPurchase", "", "checksCount", "productsCount", "diffQty", "draftCount", "enabled", "onStart", "Lkotlin/Function0;", "(DLjava/lang/String;ZIIDIZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "AuditCountSheet", "lines", "Luz/FonRo/pos/data/model/Product;", "total", "actual", "Lkotlin/Function1;", "", "costOf", "categoryNameOf", "summary", "Luz/FonRo/pos/ui/docs/AuditSummary;", "note", "onNote", SearchIntents.EXTRA_QUERY, "onQuery", "filter", "onFilter", "busy", "onAddProducts", "onScan", "onEnter", "onSame", "onClearFact", "onRemove", "onSubmit", "onDismiss", "(Ljava/util/List;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Luz/FonRo/pos/ui/docs/AuditSummary;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "AuditRow", "product", "fact", "cost", "categoryName", "onClear", "(Luz/FonRo/pos/data/model/Product;Ljava/lang/Double;DLjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "AuditTile", "Landroidx/compose/foundation/layout/RowScope;", "label", "valueColor", "background", "AuditTile-ZkgLGzA", "(Landroidx/compose/foundation/layout/RowScope;Ljava/lang/String;Ljava/lang/String;JJLandroidx/compose/runtime/Composer;I)V", "AuditHistoryCard", "diffSum", "onClick", "(Luz/FonRo/pos/data/model/AuditDoc;ILjava/lang/String;DLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "AuditDetailSheet", "(Luz/FonRo/pos/data/model/AuditDoc;ILjava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", CacheStore.PRODUCTS, CacheStore.CATEGORIES, "Luz/FonRo/pos/data/model/Category;", "sync", "Luz/FonRo/pos/data/model/SyncData;", "picked", "countSheet", "productPicker", "applied", "scanOpen", "pad", "Luz/FonRo/pos/ui/docs/NumPadRequest;", "confirm", "detail", TypedValues.CycleType.S_WAVE_PERIOD, "Luz/FonRo/pos/ui/components/PeriodState;", "monthSheet", "dateSheet"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class AuditScreenKt {
    private static final String FILTER_ALL = "all";
    private static final String FILTER_DIFF = "diff";
    private static final String FILTER_TODO = "todo";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AuditCountSheet$lambda$2(List list, int i, Function1 function1, Function1 function12, Function1 function13, String str, AuditSummary auditSummary, String str2, Function1 function14, String str3, Function1 function15, String str4, Function1 function16, boolean z, Function0 function0, Function0 function02, Function1 function17, Function1 function18, Function1 function19, Function1 function110, Function0 function03, Function0 function04, int i2, int i3, int i4, Composer composer, int i5) {
        AuditCountSheet(list, i, function1, function12, function13, str, auditSummary, str2, function14, str3, function15, str4, function16, z, function0, function02, function17, function18, function19, function110, function03, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), RecomposeScopeImplKt.updateChangedFlags(i4));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AuditDetailSheet$lambda$6(AuditDoc auditDoc, int i, String str, Function1 function1, Function0 function0, int i2, Composer composer, int i3) {
        AuditDetailSheet(auditDoc, i, str, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AuditHero$lambda$1(double d, String str, boolean z, int i, int i2, double d2, int i3, boolean z2, Function0 function0, int i4, Composer composer, int i5) {
        AuditHero(d, str, z, i, i2, d2, i3, z2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AuditHistoryCard$lambda$2(AuditDoc auditDoc, int i, String str, double d, Function0 function0, int i2, Composer composer, int i3) {
        AuditHistoryCard(auditDoc, i, str, d, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AuditRow$lambda$1(Product product, Double d, double d2, String str, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i, Composer composer, int i2) {
        AuditRow(product, d, d2, str, function0, function02, function03, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AuditScreen$lambda$93(FonRoApp FonRoApp, int i, Composer composer, int i2) {
        AuditScreen(FonRoApp, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AuditTile_ZkgLGzA$lambda$1(RowScope rowScope, String str, String str2, long j, long j2, int i, Composer composer, int i2) {
        m9878AuditTileZkgLGzA(rowScope, str, str2, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x04a3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void AuditScreen(uz.FonRo.pos.FonRoApp r56, androidx.compose.runtime.Composer r57, final int r58) {
        /*
            Method dump skipped, instructions count: 3472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.AuditScreenKt.AuditScreen(uz.FonRo.pos.FonRoApp, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AuditScreen$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final List<Product> AuditScreen$lambda$7(MutableState<List<Product>> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean AuditScreen$lambda$11(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AuditScreen$lambda$12(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean AuditScreen$lambda$14(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void AuditScreen$lambda$15(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String AuditScreen$lambda$17(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AuditScreen$lambda$20(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String AuditScreen$lambda$23(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean AuditScreen$lambda$26(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void AuditScreen$lambda$27(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final NumPadRequest AuditScreen$lambda$29(MutableState<NumPadRequest> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean AuditScreen$lambda$32(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void AuditScreen$lambda$33(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final AuditDoc AuditScreen$lambda$35(MutableState<AuditDoc> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean AuditScreen$lambda$38(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AuditScreen$lambda$39(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final PeriodState AuditScreen$lambda$41(MutableState<PeriodState> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean AuditScreen$lambda$44(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void AuditScreen$lambda$45(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean AuditScreen$lambda$47(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void AuditScreen$lambda$48(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final double AuditScreen$cost(boolean z, Product product) {
        return (!z || product.getPurchasePrice() <= AudioStats.AUDIO_AMPLITUDE_NONE) ? product.getSalePrice() : product.getPurchasePrice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuditSummary AuditScreen$lambda$52$0(List list, SnapshotStateMap snapshotStateMap, boolean z) {
        Iterator it = list.iterator();
        double d = 0.0d;
        double d2 = 0.0d;
        int i = 0;
        while (it.hasNext()) {
            Product product = (Product) it.next();
            Double d3 = (Double) snapshotStateMap.get(Long.valueOf(product.getId()));
            if (d3 != null) {
                double doubleValue = d3.doubleValue() - product.getQuantity();
                d += doubleValue;
                d2 += doubleValue * AuditScreen$cost(z, product);
                i++;
            }
        }
        return new AuditSummary(i, d, d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double AuditScreen$docDiffSum(Repo repo, boolean z, AuditDoc auditDoc) {
        double d = 0.0d;
        for (AuditItem auditItem : auditDoc.getItems()) {
            double diff = auditItem.getDiff();
            Product productById = repo.productById(auditItem.getProductId());
            d += diff * (productById != null ? AuditScreen$cost(z, productById) : 0.0d);
        }
        return d;
    }

    private static final void AuditScreen$askFact(final SnapshotStateMap<Long, Double> snapshotStateMap, MutableState<NumPadRequest> mutableState, final Product product) {
        String str = product.getName() + LangKt.tx(" — фактический остаток", new Object[0]);
        Double d = snapshotStateMap.get(Long.valueOf(product.getId()));
        mutableState.setValue(new NumPadRequest(str, d != null ? d.doubleValue() : Math.max(product.getQuantity(), AudioStats.AUDIO_AMPLITUDE_NONE), Units.INSTANCE.isMeasurable(product.getUnit()), new Function1() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda53
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AuditScreenKt.AuditScreen$askFact$lambda$60(SnapshotStateMap.this, product, ((Double) obj).doubleValue());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AuditScreen$askFact$lambda$60(SnapshotStateMap snapshotStateMap, Product product, double d) {
        snapshotStateMap.put(Long.valueOf(product.getId()), Double.valueOf(Num.INSTANCE.qty(Math.max(d, AudioStats.AUDIO_AMPLITUDE_NONE))));
        return Unit.INSTANCE;
    }

    private static final void AuditScreen$addProducts(MutableState<List<Product>> mutableState, List<Product> list) {
        Set set = SequencesKt.toSet(SequencesKt.map(CollectionsKt.asSequence(AuditScreen$lambda$7(mutableState)), new Function1() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(AuditScreenKt.AuditScreen$addProducts$lambda$61((Product) obj));
            }
        }));
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!set.contains(Long.valueOf(((Product) obj).getId()))) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return;
        }
        mutableState.setValue(CollectionsKt.plus((Collection) AuditScreen$lambda$7(mutableState), (Iterable) arrayList2));
        Toaster.INSTANCE.ok(LangKt.tx("Добавлено: ", new Object[0]) + Fmt.INSTANCE.plural(arrayList2.size(), LangKt.tx("товар", new Object[0]), LangKt.tx("товара", new Object[0]), LangKt.tx("товаров", new Object[0])));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final long AuditScreen$addProducts$lambda$61(Product it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId();
    }

    private static final void AuditScreen$removeLine(SnapshotStateMap<Long, Double> snapshotStateMap, MutableState<List<Product>> mutableState, long j) {
        List<Product> AuditScreen$lambda$7 = AuditScreen$lambda$7(mutableState);
        ArrayList arrayList = new ArrayList();
        for (Object obj : AuditScreen$lambda$7) {
            if (((Product) obj).getId() != j) {
                arrayList.add(obj);
            }
        }
        mutableState.setValue(arrayList);
        snapshotStateMap.remove(Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AuditScreen$clearDraft(SnapshotStateMap<Long, Double> snapshotStateMap, MutableState<List<Product>> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4) {
        mutableState.setValue(CollectionsKt.emptyList());
        snapshotStateMap.clear();
        mutableState2.setValue("");
        mutableState3.setValue("");
        mutableState4.setValue(FILTER_ALL);
    }

    private static final void AuditScreen$apply(boolean z, List<Product> list, CoroutineScope coroutineScope, MutableState<Boolean> mutableState, SnapshotStateMap<Long, Double> snapshotStateMap, Repo repo, MutableState<String> mutableState2, MutableState<List<Product>> mutableState3, MutableState<String> mutableState4, MutableState<String> mutableState5, MutableState<Boolean> mutableState6) {
        if (AuditScreen$lambda$38(mutableState)) {
            return;
        }
        if (!z) {
            Toaster.INSTANCE.error(LangKt.tx("Нет права на аудит", new Object[0]));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (snapshotStateMap.containsKey(Long.valueOf(((Product) obj).getId()))) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            Toaster.INSTANCE.error(LangKt.tx("Внесите фактический остаток хотя бы по одному товару", new Object[0]));
        } else {
            AuditScreen$lambda$39(mutableState, true);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AuditScreenKt$AuditScreen$apply$1(arrayList2, repo, mutableState2, snapshotStateMap, mutableState3, mutableState4, mutableState5, mutableState6, mutableState, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$65$0(final boolean z, final List list, final double d, final String str, final boolean z2, final List list2, final double d2, final State state, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final Repo repo, final MutableState mutableState6, LazyListScope LazyColumn) {
        final List list3;
        LazyListScope lazyListScope;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, "head", null, ComposableSingletons$AuditScreenKt.INSTANCE.m9879getLambda$110449440$app(), 2, null);
        LazyListScope.item$default(LazyColumn, "hero", null, ComposableLambdaKt.composableLambdaInstance(-694237751, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit AuditScreen$lambda$65$0$0;
                AuditScreen$lambda$65$0$0 = AuditScreenKt.AuditScreen$lambda$65$0$0(d, str, z2, list2, d2, z, state, mutableState, mutableState2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return AuditScreen$lambda$65$0$0;
            }
        }), 2, null);
        if (!z) {
            LazyListScope.item$default(LazyColumn, "no-perm", null, ComposableSingletons$AuditScreenKt.INSTANCE.getLambda$2006641445$app(), 2, null);
        }
        LazyListScope.item$default(LazyColumn, "history-head", null, ComposableLambdaKt.composableLambdaInstance(1662190248, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit AuditScreen$lambda$65$0$1;
                AuditScreen$lambda$65$0$1 = AuditScreenKt.AuditScreen$lambda$65$0$1(list, mutableState3, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return AuditScreen$lambda$65$0$1;
            }
        }), 2, null);
        LazyListScope.item$default(LazyColumn, "history-period", null, ComposableLambdaKt.composableLambdaInstance(-276349049, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit AuditScreen$lambda$65$0$2;
                AuditScreen$lambda$65$0$2 = AuditScreenKt.AuditScreen$lambda$65$0$2(MutableState.this, mutableState4, mutableState5, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return AuditScreen$lambda$65$0$2;
            }
        }), 2, null);
        if (list.isEmpty()) {
            list3 = list2;
            LazyListScope.item$default(LazyColumn, "history-empty", null, ComposableLambdaKt.composableLambdaInstance(-1984395570, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda33
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit AuditScreen$lambda$65$0$3;
                    AuditScreen$lambda$65$0$3 = AuditScreenKt.AuditScreen$lambda$65$0$3(list3, mutableState3, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return AuditScreen$lambda$65$0$3;
                }
            }), 2, null);
            lazyListScope = LazyColumn;
        } else {
            list3 = list2;
            lazyListScope = LazyColumn;
        }
        final Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda44
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object AuditScreen$lambda$65$0$4;
                AuditScreen$lambda$65$0$4 = AuditScreenKt.AuditScreen$lambda$65$0$4((AuditDoc) obj);
                return AuditScreen$lambda$65$0$4;
            }
        };
        final AuditScreenKt$AuditScreen$lambda$65$0$$inlined$items$default$1 auditScreenKt$AuditScreen$lambda$65$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$AuditScreen$lambda$65$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(AuditDoc auditDoc) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((AuditDoc) obj);
            }
        };
        final List list4 = list3;
        lazyListScope.items(list.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$AuditScreen$lambda$65$0$$inlined$items$default$2
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
        }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$AuditScreen$lambda$65$0$$inlined$items$default$3
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
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$AuditScreen$lambda$65$0$$inlined$items$default$4
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
                int docNumberOf;
                double AuditScreen$docDiffSum;
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
                final AuditDoc auditDoc = (AuditDoc) list.get(i);
                composer.startReplaceGroup(740547718);
                ComposerKt.sourceInformation(composer, "C*399@15375L16,394@15169L236:AuditScreen.kt#1so789");
                docNumberOf = AuditScreenKt.docNumberOf(list4, auditDoc);
                String str2 = str;
                AuditScreen$docDiffSum = AuditScreenKt.AuditScreen$docDiffSum(repo, z2, auditDoc);
                ComposerKt.sourceInformationMarkerStart(composer, 1132273665, "CC(remember):AuditScreen.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(auditDoc);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState7 = mutableState6;
                    rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$AuditScreen$3$1$6$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            mutableState7.setValue(AuditDoc.this);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                AuditScreenKt.AuditHistoryCard(auditDoc, docNumberOf, str2, AuditScreen$docDiffSum, (Function0) rememberedValue, composer, AuditDoc.$stable);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$65$0$0(double d, String str, boolean z, List list, double d2, final boolean z2, final State state, MutableState mutableState, final MutableState mutableState2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C338@13177L459,329@12777L873:AuditScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-694237751, i, -1, "uz.FonRo.pos.ui.docs.AuditScreen.<anonymous>.<anonymous>.<anonymous> (AuditScreen.kt:329)");
            }
            int size = list.size();
            int size2 = AuditScreen$lambda$0(state).size();
            int size3 = AuditScreen$lambda$7(mutableState).size();
            boolean z3 = z2 && !AuditScreen$lambda$0(state).isEmpty();
            ComposerKt.sourceInformationMarkerStart(composer, -1442534124, "CC(remember):AuditScreen.kt#9igjgp");
            boolean changed = composer.changed(z2) | composer.changed(state);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda40
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AuditScreen$lambda$65$0$0$0$0;
                        AuditScreen$lambda$65$0$0$0$0 = AuditScreenKt.AuditScreen$lambda$65$0$0$0$0(z2, state, mutableState2);
                        return AuditScreen$lambda$65$0$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AuditHero(d, str, z, size, size2, d2, size3, z3, (Function0) rememberedValue, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$65$0$0$0$0(boolean z, State state, MutableState mutableState) {
        if (!z) {
            Toaster.INSTANCE.error(LangKt.tx("Нет права на аудит", new Object[0]));
        } else if (AuditScreen$lambda$0(state).isEmpty()) {
            Toaster.INSTANCE.error(LangKt.tx("Каталог пуст — пересчитывать нечего", new Object[0]));
        } else {
            AuditScreen$lambda$12(mutableState, true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$65$0$1(List list, MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C361@14038L167:AuditScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1662190248, i, -1, "uz.FonRo.pos.ui.docs.AuditScreen.<anonymous>.<anonymous>.<anonymous> (AuditScreen.kt:361)");
            }
            BasicsKt.OxSectionHead(LangKt.tx("История проверок", new Object[0]), null, AuditScreen$lambda$41(mutableState).title(), String.valueOf(list.size()), null, null, composer, 0, 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$65$0$2(final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C371@14336L15,378@14646L21,379@14698L20,369@14262L470:AuditScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-276349049, i, -1, "uz.FonRo.pos.ui.docs.AuditScreen.<anonymous>.<anonymous>.<anonymous> (AuditScreen.kt:369)");
            }
            PeriodState AuditScreen$lambda$41 = AuditScreen$lambda$41(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 716539094, "CC(remember):AuditScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda54
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit AuditScreen$lambda$65$0$2$0$0;
                        AuditScreen$lambda$65$0$2$0$0 = AuditScreenKt.AuditScreen$lambda$65$0$2$0$0(MutableState.this, (PeriodState) obj);
                        return AuditScreen$lambda$65$0$2$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function1 function1 = (Function1) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null);
            ChipTint chipTint = ChipTint.CYAN;
            List listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(LangKt.tx("Сегодня", new Object[0]), PeriodKind.TODAY), TuplesKt.to(LangKt.tx("10 дней", new Object[0]), PeriodKind.DAYS_10)});
            ComposerKt.sourceInformationMarkerStart(composer, 716549020, "CC(remember):AuditScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda56
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AuditScreen$lambda$65$0$2$1$0;
                        AuditScreen$lambda$65$0$2$1$0 = AuditScreenKt.AuditScreen$lambda$65$0$2$1$0(MutableState.this);
                        return AuditScreen$lambda$65$0$2$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            Function0 function0 = (Function0) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 716550683, "CC(remember):AuditScreen.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda57
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AuditScreen$lambda$65$0$2$2$0;
                        AuditScreen$lambda$65$0$2$2$0 = AuditScreenKt.AuditScreen$lambda$65$0$2$2$0(MutableState.this);
                        return AuditScreen$lambda$65$0$2$2$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.OxPeriodChips(AuditScreen$lambda$41, function1, m1053paddingqDBjuR0$default, chipTint, listOf, function0, (Function0) rememberedValue3, composer, 1772976 | PeriodState.$stable, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$65$0$2$0$0(MutableState mutableState, PeriodState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$65$0$2$1$0(MutableState mutableState) {
        AuditScreen$lambda$45(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$65$0$2$2$0(MutableState mutableState) {
        AuditScreen$lambda$48(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$65$0$3(List list, MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        String tx;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C385@14829L221:AuditScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1984395570, i, -1, "uz.FonRo.pos.ui.docs.AuditScreen.<anonymous>.<anonymous>.<anonymous> (AuditScreen.kt:385)");
            }
            if (list.isEmpty()) {
                tx = LangKt.tx("Аудитов пока не было. Нажмите «Начать аудит».", new Object[0]);
            } else {
                tx = LangKt.tx("За «%s» проверок нет.", AuditScreen$lambda$41(mutableState).title());
            }
            BasicsKt.OxEmptyNote(tx, null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object AuditScreen$lambda$65$0$4(AuditDoc it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "audit-" + it.getId() + "-" + it.getCreatedAt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double AuditScreen$lambda$66$0(SnapshotStateMap snapshotStateMap, long j) {
        return (Double) snapshotStateMap.get(Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double AuditScreen$lambda$67$0(boolean z, Product it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return AuditScreen$cost(z, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$69$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$70$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$71$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$72$0(MutableState mutableState) {
        AuditScreen$lambda$15(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$73$0(MutableState mutableState) {
        AuditScreen$lambda$27(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$74$0(SnapshotStateMap snapshotStateMap, MutableState mutableState, Product it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AuditScreen$askFact(snapshotStateMap, mutableState, it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$75$0(SnapshotStateMap snapshotStateMap, Product p) {
        Intrinsics.checkNotNullParameter(p, "p");
        snapshotStateMap.put(Long.valueOf(p.getId()), Double.valueOf(Num.INSTANCE.qty(Math.max(p.getQuantity(), AudioStats.AUDIO_AMPLITUDE_NONE))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$76$0(SnapshotStateMap snapshotStateMap, long j) {
        snapshotStateMap.remove(Long.valueOf(j));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$77$0(SnapshotStateMap snapshotStateMap, MutableState mutableState, long j) {
        AuditScreen$removeLine(snapshotStateMap, mutableState, j);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$78$0(MutableState mutableState) {
        AuditScreen$lambda$33(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$79$0(MutableState mutableState) {
        AuditScreen$lambda$12(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$80$0(MutableState mutableState) {
        AuditScreen$lambda$15(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long AuditScreen$lambda$81$0(Product it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$82$0(MutableState mutableState, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        AuditScreen$addProducts(mutableState, it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$83$0(MutableState mutableState) {
        AuditScreen$lambda$45(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$84$0(MutableState mutableState, MutableState mutableState2, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(PeriodState.copy$default(AuditScreen$lambda$41(mutableState), PeriodKind.MONTH, it, null, 4, null));
        AuditScreen$lambda$45(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$85$0(MutableState mutableState) {
        AuditScreen$lambda$48(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$86$0(MutableState mutableState, MutableState mutableState2, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(PeriodState.copy$default(AuditScreen$lambda$41(mutableState), PeriodKind.DATE, null, it, 2, null));
        AuditScreen$lambda$48(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$87$0(MutableState mutableState) {
        AuditScreen$lambda$27(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$88$0(Repo repo, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, SnapshotStateMap snapshotStateMap, MutableState mutableState5, MutableState mutableState6, String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        Product findByBarcode = repo.findByBarcode(code);
        if (findByBarcode == null) {
            Toaster.INSTANCE.error(LangKt.tx("Товар с кодом %s не найден", code));
        } else {
            AuditScreen$addProducts(mutableState, CollectionsKt.listOf(findByBarcode));
            mutableState2.setValue("");
            mutableState3.setValue("");
            mutableState4.setValue(FILTER_ALL);
            AuditScreen$askFact(snapshotStateMap, mutableState5, findByBarcode);
            AuditScreen$lambda$27(mutableState6, false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$89$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$90$0(boolean z, List list, CoroutineScope coroutineScope, MutableState mutableState, SnapshotStateMap snapshotStateMap, Repo repo, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6) {
        AuditScreen$apply(z, list, coroutineScope, mutableState, snapshotStateMap, repo, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$91$0(MutableState mutableState) {
        AuditScreen$lambda$33(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double AuditScreen$lambda$92$0$0(Repo repo, boolean z, long j) {
        Product productById = repo.productById(j);
        return productById != null ? AuditScreen$cost(z, productById) : AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditScreen$lambda$92$1$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    private static final String signedQty(double d) {
        return (d > AudioStats.AUDIO_AMPLITUDE_NONE ? "+" : "") + Fmt.INSTANCE.qf(Double.valueOf(d));
    }

    private static final String signedMoney(double d, String str) {
        return (d > AudioStats.AUDIO_AMPLITUDE_NONE ? "+" : "") + Fmt.INSTANCE.money(Double.valueOf(d), str);
    }

    private static final String signedNf(double d) {
        return (d > AudioStats.AUDIO_AMPLITUDE_NONE ? "+" : "") + Fmt.INSTANCE.nf(Double.valueOf(d));
    }

    private static final long diffColor(double d) {
        if (d < -1.0E-4d) {
            return Ox.INSTANCE.m10196getDanger0d7_KjU();
        }
        if (d > 1.0E-4d) {
            return Ox.INSTANCE.m10211getOk0d7_KjU();
        }
        return Ox.INSTANCE.m10199getDim0d7_KjU();
    }

    private static final String docNumberText(int i) {
        if (i <= 0) {
            return "";
        }
        String format = String.format("#%04d", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private static final void AuditHero(final double d, final String str, final boolean z, final int i, int i2, final double d2, final int i3, final boolean z2, final Function0<Unit> function0, Composer composer, final int i4) {
        int i5;
        int i6;
        Composer composer2;
        int i7;
        int i8;
        String tx;
        Composer startRestartGroup = composer.startRestartGroup(681744987);
        ComposerKt.sourceInformation(startRestartGroup, "C(AuditHero)P(8,2!2,7)566@20636L2584:AuditScreen.kt#1so789");
        if ((i4 & 6) == 0) {
            i5 = (startRestartGroup.changed(d) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i4 & 3072) == 0) {
            i5 |= startRestartGroup.changed(i) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i6 = i2;
            i5 |= startRestartGroup.changed(i6) ? 16384 : 8192;
        } else {
            i6 = i2;
        }
        if ((196608 & i4) == 0) {
            i5 |= startRestartGroup.changed(d2) ? 131072 : 65536;
        }
        if ((1572864 & i4) == 0) {
            i5 |= startRestartGroup.changed(i3) ? 1048576 : 524288;
        }
        if ((12582912 & i4) == 0) {
            i5 |= startRestartGroup.changed(z2) ? 8388608 : 4194304;
        }
        if ((100663296 & i4) == 0) {
            i5 |= startRestartGroup.changedInstance(function0) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (!startRestartGroup.shouldExecute((i5 & 38347923) != 38347922, i5 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                i7 = 0;
                ComposerKt.traceEventStart(681744987, i5, -1, "uz.FonRo.pos.ui.docs.AuditHero (AuditScreen.kt:565)");
            } else {
                i7 = 0;
            }
            int i9 = i5;
            Modifier clip = ClipKt.clip(PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null), OxShape.INSTANCE.getHero());
            Brush.Companion companion = Brush.INSTANCE;
            Pair[] pairArr = new Pair[3];
            pairArr[i7] = TuplesKt.to(Float.valueOf(0.0f), Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10192getCyan0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null)));
            pairArr[1] = TuplesKt.to(Float.valueOf(0.55f), Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10186getBlue0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null)));
            pairArr[2] = TuplesKt.to(Float.valueOf(1.0f), Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10223getPurple0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null)));
            Modifier m1049padding3ABfNKs = PaddingKt.m1049padding3ABfNKs(BorderKt.m569borderxT4_qwU(BackgroundKt.background$default(clip, Brush.Companion.m4336linearGradientmHitzGk$default(companion, pairArr, 0L, 0L, 0, 14, (Object) null), null, 0.0f, 6, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10205getHeroEdge0d7_KjU(), OxShape.INSTANCE.getHero()), Dp.m6989constructorimpl(16.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            int i10 = i7;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, i10);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, i10);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1298263854, "C581@21130L361,589@21500L235,596@21744L324,601@22077L11,613@22531L24,602@22097L1117:AuditScreen.kt#1so789");
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 406172138, "C582@21221L210,587@21444L37:AuditScreen.kt#1so789");
            if (z) {
                i8 = 0;
                tx = LangKt.tx("Стоимость склада по закупке", new Object[0]);
            } else {
                i8 = 0;
                tx = LangKt.tx("Стоимость склада по продаже", new Object[0]);
            }
            int i11 = i8;
            TextKt.m2798Text4IGK_g(tx, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getLabel(), startRestartGroup, 0, 0, 65532);
            BasicsKt.OxChip(LangKt.tx("Проверка", new Object[i11]), ChipTone.BLUE, null, startRestartGroup, 48, 4);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            TextKt.m2798Text4IGK_g(Fmt.INSTANCE.money(Double.valueOf(d), str), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(6.0f), 0.0f, Dp.m6989constructorimpl(12.0f), 5, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getAmount(), startRestartGroup, 48, 3120, 55292);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, i11);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default2);
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
            Updater.m3815setimpl(m3808constructorimpl3, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1338234596, "C597@21839L64,598@21916L59,599@21988L70:AuditScreen.kt#1so789");
            StockInScreenKt.m9919DocMiniStatuDo3WH8(rowScopeInstance2, String.valueOf(i), LangKt.tx("Проверок", new Object[0]), Ox.INSTANCE.m10193getCyanDeep0d7_KjU(), null, startRestartGroup, 6, 8);
            StockInScreenKt.m9919DocMiniStatuDo3WH8(rowScopeInstance2, String.valueOf(i6), LangKt.tx("Товаров", new Object[0]), Ox.INSTANCE.m10211getOk0d7_KjU(), null, startRestartGroup, 6, 8);
            StockInScreenKt.m9919DocMiniStatuDo3WH8(rowScopeInstance2, signedQty(d2), LangKt.tx("Разница, шт", new Object[0]), diffColor(d2), null, startRestartGroup, 6, 8);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), startRestartGroup, 6);
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(SizeKt.m1084heightInVpY3zN4$default(ModifiersKt.oxTap(AlphaKt.alpha(BorderKt.m569borderxT4_qwU(BackgroundKt.background$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), OxShape.INSTANCE.getTile()), Brush.Companion.m4333horizontalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10192getCyan0d7_KjU(), 0.34f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10186getBlue0d7_KjU(), 0.28f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10234getTileEdge0d7_KjU(), OxShape.INSTANCE.getTile()), z2 ? 1.0f : 0.55f), false, function0, startRestartGroup, (i9 >> 18) & 896, 1), Dp.m6989constructorimpl(50.0f), 0.0f, 2, null), Dp.m6989constructorimpl(14.0f), Dp.m6989constructorimpl(11.0f));
            Arrangement.Horizontal m931spacedByD5KLDUw = Arrangement.INSTANCE.m931spacedByD5KLDUw(Dp.m6989constructorimpl(8.0f), Alignment.INSTANCE.getCenterHorizontally());
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(m931spacedByD5KLDUw, centerVertically2, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, m1050paddingVpY3zN4);
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
            Updater.m3815setimpl(m3808constructorimpl4, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl4.getInserting() || !Intrinsics.areEqual(m3808constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m3808constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m3808constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3815setimpl(m3808constructorimpl4, materializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1102060154, "C619@22836L149,623@22998L206:AuditScreen.kt#1so789");
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getClipboard(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(20.0f)), Ox.INSTANCE.m10193getCyanDeep0d7_KjU(), startRestartGroup, 432, 0);
            TextKt.m2798Text4IGK_g(i3 > 0 ? LangKt.tx("Продолжить · %s", Integer.valueOf(i3)) : LangKt.tx("Начать аудит", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getButtonLg(), Ox.INSTANCE.m10233getText0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), startRestartGroup, 0, 3072, 57342);
            composer2 = startRestartGroup;
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
            final int i12 = i6;
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda58
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuditScreenKt.AuditHero$lambda$1(d, str, z, i, i12, d2, i3, z2, function0, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void AuditCountSheet(final List<Product> list, final int i, final Function1<? super Long, Double> function1, final Function1<? super Product, Double> function12, final Function1<? super Long, String> function13, final String str, final AuditSummary auditSummary, final String str2, final Function1<? super String, Unit> function14, final String str3, final Function1<? super String, Unit> function15, final String str4, final Function1<? super String, Unit> function16, final boolean z, final Function0<Unit> function0, final Function0<Unit> function02, final Function1<? super Product, Unit> function17, final Function1<? super Product, Unit> function18, final Function1<? super Long, Unit> function19, final Function1<? super Long, Unit> function110, final Function0<Unit> function03, final Function0<Unit> function04, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Function1<? super Long, Double> function111;
        Function1<? super Product, Double> function112;
        Function1<? super Long, String> function113;
        int i6;
        int i7;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1835825447);
        ComposerKt.sourceInformation(startRestartGroup, "C(AuditCountSheet)P(6,21!1,3,2,4,20,7,13,19,14,5,12!2,17,11,16!1,15,18)669@24281L567,684@24855L5558,666@24185L6228:AuditScreen.kt#1so789");
        if ((i2 & 6) == 0) {
            i5 = ((i2 & 8) == 0 ? startRestartGroup.changed(list) : startRestartGroup.changedInstance(list) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= startRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            function111 = function1;
            i5 |= startRestartGroup.changedInstance(function111) ? 256 : 128;
        } else {
            function111 = function1;
        }
        if ((i2 & 3072) == 0) {
            function112 = function12;
            i5 |= startRestartGroup.changedInstance(function112) ? 2048 : 1024;
        } else {
            function112 = function12;
        }
        if ((i2 & 24576) == 0) {
            function113 = function13;
            i5 |= startRestartGroup.changedInstance(function113) ? 16384 : 8192;
        } else {
            function113 = function13;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i5 |= startRestartGroup.changed(str) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i5 |= startRestartGroup.changed(auditSummary) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i5 |= startRestartGroup.changed(str2) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i5 |= startRestartGroup.changedInstance(function14) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i2 & 805306368) == 0) {
            i5 |= startRestartGroup.changed(str3) ? 536870912 : 268435456;
        }
        if ((i3 & 6) == 0) {
            i6 = i3 | (startRestartGroup.changedInstance(function15) ? 4 : 2);
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= startRestartGroup.changed(str4) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function16) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i6 |= startRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
        }
        if ((i3 & 1572864) == 0) {
            i6 |= startRestartGroup.changedInstance(function17) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i6 |= startRestartGroup.changedInstance(function18) ? 8388608 : 4194304;
        }
        if ((i3 & 100663296) == 0) {
            i6 |= startRestartGroup.changedInstance(function19) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i3 & 805306368) == 0) {
            i6 |= startRestartGroup.changedInstance(function110) ? 536870912 : 268435456;
        }
        int i8 = i6;
        if ((i4 & 6) == 0) {
            i7 = i4 | (startRestartGroup.changedInstance(function03) ? 4 : 2);
        } else {
            i7 = i4;
        }
        if ((i4 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(function04) ? 32 : 16;
        }
        int i9 = i7;
        if (!startRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (306783379 & i8) == 306783378 && (i9 & 19) == 18) ? false : true, i5 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1835825447, i5, i8, "uz.FonRo.pos.ui.docs.AuditCountSheet (AuditScreen.kt:662)");
            }
            float counted = i == 0 ? 0.0f : auditSummary.getCounted() / i;
            final int roundToInt = MathKt.roundToInt(100.0f * counted);
            final Function1<? super Product, Double> function114 = function112;
            final Function1<? super Long, String> function115 = function113;
            final float f = counted;
            final Function1<? super Long, Double> function116 = function111;
            composer2 = startRestartGroup;
            SheetsKt.OxCardSheet(LangKt.tx("Новый аудит", new Object[0]), function04, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(341611212, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda50
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AuditScreenKt.AuditCountSheet$lambda$0(Function0.this, z, auditSummary, function03, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-87516939, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda51
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AuditScreenKt.AuditCountSheet$lambda$1(i, str3, function15, list, str4, str2, function14, roundToInt, auditSummary, str, f, function0, function02, function16, function116, function114, function115, function17, function18, function19, function110, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, (i9 & 112) | 14155776, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda52
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuditScreenKt.AuditCountSheet$lambda$2(list, i, function1, function12, function13, str, auditSummary, str2, function14, str3, function15, str4, function16, z, function0, function02, function17, function18, function19, function110, function03, function04, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AuditCountSheet$lambda$0(Function0 function0, boolean z, AuditSummary auditSummary, Function0 function02, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        String tx;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C670@24295L90,671@24398L440:AuditScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(341611212, i2, -1, "uz.FonRo.pos.ui.docs.AuditCountSheet.<anonymous> (AuditScreen.kt:670)");
            }
            BasicsKt.OxButton(LangKt.tx("Закрыть", new Object[0]), function0, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.GHOST, null, false, false, null, composer, 3072, 240);
            if (z) {
                tx = LangKt.tx("Проводим…", new Object[0]);
            } else {
                tx = auditSummary.getCounted() > 0 ? LangKt.tx("Провести · %s", Integer.valueOf(auditSummary.getCounted())) : LangKt.tx("Провести", new Object[0]);
            }
            BasicsKt.OxButton(tx, function02, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.4f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, !z && auditSummary.getCounted() > 0, false, null, composer, 27648, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AuditCountSheet$lambda$1(final int i, String str, Function1 function1, List list, final String str2, String str3, Function1 function12, final int i2, final AuditSummary auditSummary, final String str4, final float f, Function0 function0, Function0 function02, final Function1 function13, Function1 function14, Function1 function15, Function1 function16, final Function1 function17, final Function1 function18, final Function1 function19, final Function1 function110, ColumnScope OxCardSheet, Composer composer, int i3) {
        String tx;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C685@24896L21,685@24865L5542:AuditScreen.kt#1so789");
        if (!composer.shouldExecute((i3 & 17) != 16, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-87516939, i3, -1, "uz.FonRo.pos.ui.docs.AuditCountSheet.<anonymous> (AuditScreen.kt:685)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1766604079, "C691@25182L1315,687@25014L1483,723@26510L11,725@26535L1240,754@27788L11,820@30387L10:AuditScreen.kt#1so789");
            BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(13.0f), null, Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10192getCyan0d7_KjU(), 0.08f), Ox.INSTANCE.m10242tintBorderl2rxGTc(Ox.INSTANCE.m10192getCyan0d7_KjU()), null, ComposableLambdaKt.rememberComposableLambda(1743021425, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda43
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit AuditCountSheet$lambda$1$0$0;
                    AuditCountSheet$lambda$1$0$0 = AuditScreenKt.AuditCountSheet$lambda$1$0$0(i2, auditSummary, i, str4, f, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return AuditCountSheet$lambda$1$0$0;
                }
            }, composer, 54), composer, 1572912, 37);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer, 6);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(9.0f));
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
            ComposerKt.sourceInformationMarkerStart(composer, 2142246413, "C726@26634L494,745@27441L23,739@27145L616:AuditScreen.kt#1so789");
            BasicsKt.OxButton(LangKt.tx("Добавить товары", new Object[0]), function0, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.CYAN, BtnSize.LG, false, false, ComposableSingletons$AuditScreenKt.INSTANCE.getLambda$968251550$app(), composer, 12610560, 96);
            Modifier oxTap = ModifiersKt.oxTap(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, OxDim.INSTANCE.m10249getTapD9Ej5fM()), OxShape.INSTANCE.getField()), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10192getCyan0d7_KjU(), 0.14f), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10242tintBorderl2rxGTc(Ox.INSTANCE.m10192getCyan0d7_KjU()), OxShape.INSTANCE.getField()), false, function02, composer, 0, 1);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1470108345, "C748@27562L181:AuditScreen.kt#1so789");
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getScan(), LangKt.tx("Сканировать", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(21.0f)), Ox.INSTANCE.m10193getCyanDeep0d7_KjU(), composer, 384, 0);
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
            if (i == 0) {
                composer2.startReplaceGroup(-1763973110);
                ComposerKt.sourceInformation(composer2, "757@27847L141");
                BasicsKt.OxEmptyNote(LangKt.tx("Товары ещё не выбраны. Нажмите «Добавить товары» и отметьте всё, что стоит на полке.", new Object[0]), null, composer2, 0, 2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1763727559);
                ComposerKt.sourceInformation(composer2, "761@28026L172,766@28215L11,767@28253L846,767@28243L856,811@30067L10,812@30094L266");
                FieldsKt.OxSearchBox(str, function1, null, LangKt.tx("Поиск среди выбранных", new Object[0]), null, composer, 0, 20);
                composer2 = composer;
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer2, 6);
                ChipsKt.OxChipRow(null, ComposableLambdaKt.rememberComposableLambda(-687200096, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda45
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit AuditCountSheet$lambda$1$0$2;
                        AuditCountSheet$lambda$1$0$2 = AuditScreenKt.AuditCountSheet$lambda$1$0$2(i, str2, function13, auditSummary, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return AuditCountSheet$lambda$1$0$2;
                    }
                }, composer2, 54), composer2, 48, 1);
                if (list.isEmpty()) {
                    composer2.startReplaceGroup(-1762669188);
                    ComposerKt.sourceInformation(composer2, "789@29160L307");
                    if (Intrinsics.areEqual(str2, FILTER_DIFF)) {
                        tx = LangKt.tx("Расхождений нет.", new Object[0]);
                    } else {
                        tx = Intrinsics.areEqual(str2, FILTER_TODO) ? LangKt.tx("Все выбранные товары отмечены.", new Object[0]) : LangKt.tx("Ничего не найдено.", new Object[0]);
                    }
                    BasicsKt.OxEmptyNote(tx, null, composer2, 0, 2);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-1762335721);
                    composer2.endReplaceGroup();
                }
                composer2.startReplaceGroup(-1719416217);
                ComposerKt.sourceInformation(composer2, "*804@29811L20,805@29866L19,806@29921L27,807@29985L24,799@29550L481");
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    final Product product = (Product) it.next();
                    Double d = (Double) function14.invoke(Long.valueOf(product.getId()));
                    double doubleValue = ((Number) function15.invoke(product)).doubleValue();
                    String str5 = (String) function16.invoke(Long.valueOf(product.getCategoryId()));
                    ComposerKt.sourceInformationMarkerStart(composer2, -390579013, "CC(remember):AuditScreen.kt#9igjgp");
                    boolean changed = composer2.changed(function17) | composer2.changedInstance(product);
                    Iterator it2 = it;
                    Object rememberedValue = composer2.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda46
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit AuditCountSheet$lambda$1$0$3$0$0;
                                AuditCountSheet$lambda$1$0$3$0$0 = AuditScreenKt.AuditCountSheet$lambda$1$0$3$0$0(Function1.this, product);
                                return AuditCountSheet$lambda$1$0$3$0$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    Function0 function03 = (Function0) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -390577254, "CC(remember):AuditScreen.kt#9igjgp");
                    boolean changed2 = composer2.changed(function18) | composer2.changedInstance(product);
                    Object rememberedValue2 = composer2.rememberedValue();
                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda47
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit AuditCountSheet$lambda$1$0$3$1$0;
                                AuditCountSheet$lambda$1$0$3$1$0 = AuditScreenKt.AuditCountSheet$lambda$1$0$3$1$0(Function1.this, product);
                                return AuditCountSheet$lambda$1$0$3$1$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    Function0 function04 = (Function0) rememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -390575486, "CC(remember):AuditScreen.kt#9igjgp");
                    boolean changed3 = composer2.changed(function19) | composer2.changedInstance(product);
                    Object rememberedValue3 = composer2.rememberedValue();
                    if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda48
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit AuditCountSheet$lambda$1$0$3$2$0;
                                AuditCountSheet$lambda$1$0$3$2$0 = AuditScreenKt.AuditCountSheet$lambda$1$0$3$2$0(Function1.this, product);
                                return AuditCountSheet$lambda$1$0$3$2$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue3);
                    }
                    Function0 function05 = (Function0) rememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -390573441, "CC(remember):AuditScreen.kt#9igjgp");
                    boolean changed4 = composer2.changed(function110) | composer2.changedInstance(product);
                    Object rememberedValue4 = composer2.rememberedValue();
                    if (changed4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new Function0() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda49
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit AuditCountSheet$lambda$1$0$3$3$0;
                                AuditCountSheet$lambda$1$0$3$3$0 = AuditScreenKt.AuditCountSheet$lambda$1$0$3$3$0(Function1.this, product);
                                return AuditCountSheet$lambda$1$0$3$3$0;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Composer composer3 = composer2;
                    AuditRow(product, d, doubleValue, str5, function03, function04, function05, (Function0) rememberedValue4, composer3, Product.$stable);
                    it = it2;
                    composer2 = composer3;
                }
                composer2.endReplaceGroup();
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(4.0f), composer2, 6);
                FieldsKt.m9846OxFieldDfSPO0(LangKt.tx("Заметка к проверке", new Object[0]), str3, function12, null, LangKt.tx("Например: пересчёт после смены", new Object[0]), 0, 0, null, false, false, false, false, false, 240, null, composer2, 0, 3072, 24552);
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
    public static final Unit AuditCountSheet$lambda$1$0$0(int i, AuditSummary auditSummary, int i2, String str, float f, ColumnScope OxSoftCard, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C692@25200L143,696@25360L11,697@25388L523,706@25928L11,707@25956L527:AuditScreen.kt#1so789");
        if (!composer.shouldExecute((i3 & 17) != 16, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1743021425, i3, -1, "uz.FonRo.pos.ui.docs.AuditCountSheet.<anonymous>.<anonymous>.<anonymous> (AuditScreen.kt:692)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Отметьте «Верно» или внесите фактический остаток.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(11.0f), composer, 6);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1347344380, "C698@25491L88,699@25600L86,700@25707L186:AuditScreen.kt#1so789");
            StockInScreenKt.m9919DocMiniStatuDo3WH8(rowScopeInstance, i + "%", LangKt.tx("Отмечено · %s из %s", Integer.valueOf(auditSummary.getCounted()), Integer.valueOf(i2)), Ox.INSTANCE.m10193getCyanDeep0d7_KjU(), null, composer, 6, 8);
            StockInScreenKt.m9919DocMiniStatuDo3WH8(rowScopeInstance, signedQty(auditSummary.getDiffQty()), LangKt.tx("Разница, шт", new Object[0]), diffColor(auditSummary.getDiffQty()), null, composer, 6, 8);
            StockInScreenKt.m9919DocMiniStatuDo3WH8(rowScopeInstance, signedMoney(auditSummary.getDiffSum(), str), LangKt.tx("Сумма", new Object[0]), diffColor(auditSummary.getDiffSum()), null, composer, 6, 8);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer, 6);
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1082height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6989constructorimpl(5.0f)), OxShape.INSTANCE.getPill()), Ox.INSTANCE.m10236getTrack0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1003958847, "C714@26198L267:AuditScreen.kt#1so789");
            BoxKt.Box(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1082height3ABfNKs(SizeKt.fillMaxWidth(Modifier.INSTANCE, RangesKt.coerceIn(f, 0.0f, 1.0f)), Dp.m6989constructorimpl(5.0f)), OxShape.INSTANCE.getPill()), Ox.INSTANCE.m10192getCyan0d7_KjU(), null, 2, null), composer, 0);
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
    public static final Unit AuditCountSheet$lambda$1$0$2(int i, String str, final Function1 function1, AuditSummary auditSummary, RowScope OxChipRow, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(OxChipRow, "$this$OxChipRow");
        ComposerKt.sourceInformation(composer, "C772@28475L24,768@28275L246,778@28769L25,774@28542L274,784@29034L25,780@28837L244:AuditScreen.kt#1so789");
        if (!composer.shouldExecute((i2 & 17) != 16, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-687200096, i2, -1, "uz.FonRo.pos.ui.docs.AuditCountSheet.<anonymous>.<anonymous>.<anonymous> (AuditScreen.kt:768)");
            }
            String tx = LangKt.tx("Все · %s", Integer.valueOf(i));
            boolean areEqual = Intrinsics.areEqual(str, FILTER_ALL);
            ChipTint chipTint = ChipTint.CYAN;
            ComposerKt.sourceInformationMarkerStart(composer, 1025678456, "CC(remember):AuditScreen.kt#9igjgp");
            boolean changed = composer.changed(function1);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda55
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AuditCountSheet$lambda$1$0$2$0$0;
                        AuditCountSheet$lambda$1$0$2$0$0 = AuditScreenKt.AuditCountSheet$lambda$1$0$2$0$0(Function1.this);
                        return AuditCountSheet$lambda$1$0$2$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.m9837OxCatChipFV1VA1c(tx, areEqual, (Function0) rememberedValue, null, chipTint, null, composer, 24576, 40);
            String tx2 = LangKt.tx("Не отмечено · %s", Integer.valueOf(i - auditSummary.getCounted()));
            boolean areEqual2 = Intrinsics.areEqual(str, FILTER_TODO);
            ChipTint chipTint2 = ChipTint.CYAN;
            ComposerKt.sourceInformationMarkerStart(composer, 1025687865, "CC(remember):AuditScreen.kt#9igjgp");
            boolean changed2 = composer.changed(function1);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda60
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AuditCountSheet$lambda$1$0$2$1$0;
                        AuditCountSheet$lambda$1$0$2$1$0 = AuditScreenKt.AuditCountSheet$lambda$1$0$2$1$0(Function1.this);
                        return AuditCountSheet$lambda$1$0$2$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.m9837OxCatChipFV1VA1c(tx2, areEqual2, (Function0) rememberedValue2, null, chipTint2, null, composer, 24576, 40);
            String tx3 = LangKt.tx("Расхождения", new Object[0]);
            boolean areEqual3 = Intrinsics.areEqual(str, FILTER_DIFF);
            ChipTint chipTint3 = ChipTint.CYAN;
            ComposerKt.sourceInformationMarkerStart(composer, 1025696345, "CC(remember):AuditScreen.kt#9igjgp");
            boolean changed3 = composer.changed(function1);
            Object rememberedValue3 = composer.rememberedValue();
            if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda61
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AuditCountSheet$lambda$1$0$2$2$0;
                        AuditCountSheet$lambda$1$0$2$2$0 = AuditScreenKt.AuditCountSheet$lambda$1$0$2$2$0(Function1.this);
                        return AuditCountSheet$lambda$1$0$2$2$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.m9837OxCatChipFV1VA1c(tx3, areEqual3, (Function0) rememberedValue3, null, chipTint3, null, composer, 24576, 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditCountSheet$lambda$1$0$2$0$0(Function1 function1) {
        function1.invoke(FILTER_ALL);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditCountSheet$lambda$1$0$2$1$0(Function1 function1) {
        function1.invoke(FILTER_TODO);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditCountSheet$lambda$1$0$2$2$0(Function1 function1) {
        function1.invoke(FILTER_DIFF);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditCountSheet$lambda$1$0$3$0$0(Function1 function1, Product product) {
        function1.invoke(product);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditCountSheet$lambda$1$0$3$1$0(Function1 function1, Product product) {
        function1.invoke(product);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditCountSheet$lambda$1$0$3$2$0(Function1 function1, Product product) {
        function1.invoke(Long.valueOf(product.getId()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AuditCountSheet$lambda$1$0$3$3$0(Function1 function1, Product product) {
        function1.invoke(Long.valueOf(product.getId()));
        return Unit.INSTANCE;
    }

    private static final void AuditRow(final Product product, final Double d, final double d2, final String str, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, Composer composer, final int i) {
        int i2;
        final double d3;
        final Function0<Unit> function05;
        Function0<Unit> function06;
        Composer composer2;
        boolean z;
        Composer composer3;
        long m10218getPanel20d7_KjU;
        Composer startRestartGroup = composer.startRestartGroup(979074429);
        ComposerKt.sourceInformation(startRestartGroup, "C(AuditRow)P(7,2,1!1,4,6)846@31051L4037,841@30807L4281:AuditScreen.kt#1so789");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(product) : startRestartGroup.changedInstance(product) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(d) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            d3 = d2;
            i2 |= startRestartGroup.changed(d3) ? 256 : 128;
        } else {
            d3 = d2;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(str) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            function05 = function03;
            i2 |= startRestartGroup.changedInstance(function05) ? 1048576 : 524288;
        } else {
            function05 = function03;
        }
        if ((12582912 & i) == 0) {
            function06 = function04;
            i2 |= startRestartGroup.changedInstance(function06) ? 8388608 : 4194304;
        } else {
            function06 = function04;
        }
        if (!startRestartGroup.shouldExecute((4793491 & i2) != 4793490, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(979074429, i2, -1, "uz.FonRo.pos.ui.docs.AuditRow (AuditScreen.kt:835)");
            }
            boolean z2 = d != null;
            final double doubleValue = (d != null ? d.doubleValue() : product.getQuantity()) - product.getQuantity();
            final long diffColor = diffColor(doubleValue);
            final String name = Units.INSTANCE.name(product.getUnit());
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(9.0f), 7, null);
            float m6989constructorimpl = Dp.m6989constructorimpl(12.0f);
            if (z2) {
                z = z2;
                composer3 = startRestartGroup;
                m10218getPanel20d7_KjU = Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10192getCyan0d7_KjU(), 0.07f);
            } else {
                z = z2;
                composer3 = startRestartGroup;
                m10218getPanel20d7_KjU = Ox.INSTANCE.m10218getPanel20d7_KjU();
            }
            long j = m10218getPanel20d7_KjU;
            Ox ox = Ox.INSTANCE;
            final Function0<Unit> function07 = function06;
            final boolean z3 = z;
            composer2 = composer3;
            BasicsKt.m9833OxSoftCardCe4qNIY(m1053paddingqDBjuR0$default, m6989constructorimpl, null, j, z ? ox.m10242tintBorderl2rxGTc(Ox.INSTANCE.m10192getCyan0d7_KjU()) : ox.m10189getBorder0d7_KjU(), null, ComposableLambdaKt.rememberComposableLambda(368243127, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AuditScreenKt.AuditRow$lambda$0(z3, doubleValue, d3, diffColor, function05, function02, function07, product, str, name, function0, d, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, 1572918, 36);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuditScreenKt.AuditRow$lambda$1(Product.this, d, d2, str, function0, function02, function03, function04, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AuditRow$lambda$0(boolean z, double d, double d2, long j, Function0 function0, Function0 function02, Function0 function03, Product product, String str, String str2, Function0 function04, Double d3, ColumnScope OxSoftCard, Composer composer, int i) {
        String str3;
        String str4;
        String str5;
        String str6;
        long j2;
        long m10217getPanel0d7_KjU;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C847@31061L2143,902@33214L11,903@33234L1601:AuditScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(368243127, i, -1, "uz.FonRo.pos.ui.docs.AuditRow.<anonymous> (AuditScreen.kt:847)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 503791127, "C852@31249L355,892@32892L25,887@32710L484:AuditScreen.kt#1so789");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1690740673, "C853@31295L189,859@31501L89:AuditScreen.kt#1so789");
            TextKt.m2798Text4IGK_g(product.getName(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), composer, 0, 3120, 55294);
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 0, 3120, 55294);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (z) {
                composer.startReplaceGroup(504121896);
                ComposerKt.sourceInformation(composer, "867@31847L24,862@31648L391");
                Modifier oxTap = ModifiersKt.oxTap(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(34.0f)), OxShape.INSTANCE.getPill()), Ox.INSTANCE.m10191getChipDim0d7_KjU(), null, 2, null), false, function0, composer, 0, 1);
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
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
                ComposerKt.sourceInformationMarkerStart(composer, 862323133, "C870@31969L52:AuditScreen.kt#1so789");
                str3 = "C72@3468L9:Box.kt#2w3rfo";
                TextKt.m2798Text4IGK_g("✕", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getLabel(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 6, 0, 65534);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
                str6 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
                str4 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                str5 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            } else {
                composer.startReplaceGroup(504549541);
                ComposerKt.sourceInformation(composer, "877@32238L23,873@32077L458");
                Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.m1084heightInVpY3zN4$default(ModifiersKt.oxTap(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, OxShape.INSTANCE.getPill()), Ox.INSTANCE.m10212getOkSoft0d7_KjU(), null, 2, null), false, function02, composer, 0, 1), Dp.m6989constructorimpl(34.0f), 0.0f, 2, null), Dp.m6989constructorimpl(14.0f), 0.0f, 2, null);
                Alignment center2 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, m1051paddingVpY3zN4$default);
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
                Updater.m3815setimpl(m3808constructorimpl4, maybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3815setimpl(m3808constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3808constructorimpl4.getInserting() || !Intrinsics.areEqual(m3808constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m3808constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m3808constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m3815setimpl(m3808constructorimpl4, materializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, 2004814144, "C882@32459L58:AuditScreen.kt#1so789");
                str3 = "C72@3468L9:Box.kt#2w3rfo";
                str4 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                str5 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                str6 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
                TextKt.m2798Text4IGK_g(LangKt.tx("Верно", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getChip(), Ox.INSTANCE.m10211getOk0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            }
            Modifier oxTap2 = ModifiersKt.oxTap(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(34.0f)), OxShape.INSTANCE.getPill()), Ox.INSTANCE.m10198getDangerSoft0d7_KjU(), null, 2, null), false, function03, composer, 0, 1);
            Alignment center3 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, str6);
            MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
            String str7 = str5;
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, str7);
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer, oxTap2);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
            String str8 = str4;
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, str8);
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
            Updater.m3815setimpl(m3808constructorimpl5, maybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl5.getInserting() || !Intrinsics.areEqual(m3808constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                m3808constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                m3808constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m3815setimpl(m3808constructorimpl5, materializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, str3);
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -311175803, "C895@33003L177:AuditScreen.kt#1so789");
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getDelete(), LangKt.tx("Убрать из документа", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(17.0f)), Ox.INSTANCE.m10196getDanger0d7_KjU(), composer, 384, 0);
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
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, str7);
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(composer, fillMaxWidth$default2);
            Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, str8);
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
            ComposerKt.sourceInformationMarkerStart(composer, -638626257, "C904@33329L196,920@33917L24,910@33538L986,933@34537L288:AuditScreen.kt#1so789");
            m9878AuditTileZkgLGzA(rowScopeInstance2, Fmt.INSTANCE.qf(Double.valueOf(product.getQuantity())), LangKt.tx("Учёт, %s", str2), Ox.INSTANCE.m10233getText0d7_KjU(), Ox.INSTANCE.m10217getPanel0d7_KjU(), composer, 6);
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), OxShape.INSTANCE.getTileSm()), Ox.INSTANCE.m10217getPanel0d7_KjU(), null, 2, null);
            float m6989constructorimpl = Dp.m6989constructorimpl(1.5f);
            Ox ox = Ox.INSTANCE;
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(SizeKt.m1084heightInVpY3zN4$default(ModifiersKt.oxTap(BorderKt.m569borderxT4_qwU(m558backgroundbw27NRU$default, m6989constructorimpl, z ? ox.m10242tintBorderl2rxGTc(Ox.INSTANCE.m10192getCyan0d7_KjU()) : ox.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getTileSm()), false, function04, composer, 0, 1), Dp.m6989constructorimpl(54.0f), 0.0f, 2, null), Dp.m6989constructorimpl(10.0f), Dp.m6989constructorimpl(8.0f));
            Arrangement.HorizontalOrVertical center4 = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(center4, Alignment.INSTANCE.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, str7);
            int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier7 = ComposedModifierKt.materializeModifier(composer, m1050paddingVpY3zN4);
            Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, str8);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor7);
            } else {
                composer.useNode();
            }
            Composer m3808constructorimpl7 = Updater.m3808constructorimpl(composer);
            Updater.m3815setimpl(m3808constructorimpl7, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl7.getInserting() || !Intrinsics.areEqual(m3808constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                m3808constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                m3808constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
            }
            Updater.m3815setimpl(m3808constructorimpl7, materializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -709432788, "C925@34141L83,926@34241L269:AuditScreen.kt#1so789");
            TextKt.m2798Text4IGK_g(LangKt.tx("Фактически", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getTileLabel(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 3072, 57342);
            String qf = d3 != null ? Fmt.INSTANCE.qf(d3) : "—";
            TextStyle statValue = OxType.INSTANCE.getStatValue();
            Ox ox2 = Ox.INSTANCE;
            TextKt.m2798Text4IGK_g(qf, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(statValue, z ? ox2.m10193getCyanDeep0d7_KjU() : ox2.m10200getDim20d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 3120, 55294);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            String signedQty = z ? signedQty(d) : "—";
            String tx = LangKt.tx("Разница", new Object[0]);
            long m10200getDim20d7_KjU = z ? j : Ox.INSTANCE.m10200getDim20d7_KjU();
            if (!z || Math.abs(d) <= 1.0E-4d) {
                j2 = j;
                m10217getPanel0d7_KjU = Ox.INSTANCE.m10217getPanel0d7_KjU();
            } else {
                j2 = j;
                m10217getPanel0d7_KjU = Ox.INSTANCE.m10241tintBg5vOe2sY(j2, 0.12f);
            }
            m9878AuditTileZkgLGzA(rowScopeInstance2, signedQty, tx, m10200getDim20d7_KjU, m10217getPanel0d7_KjU, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (z && Math.abs(d) > 1.0E-4d) {
                composer.startReplaceGroup(988327105);
                ComposerKt.sourceInformation(composer, "942@34894L10,943@34917L155");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer, 6);
                TextKt.m2798Text4IGK_g(LangKt.tx("Сумма расхождения: ", new Object[0]) + signedNf(Num.INSTANCE.money(d * d2)), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), j2, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(988521227);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* renamed from: AuditTile-ZkgLGzA, reason: not valid java name */
    private static final void m9878AuditTileZkgLGzA(final RowScope rowScope, final String str, final String str2, final long j, final long j2, Composer composer, final int i) {
        int i2;
        String str3;
        String str4;
        long j3;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-836908191);
        ComposerKt.sourceInformation(startRestartGroup, "C(AuditTile)P(2,1,3:c#ui.graphics.Color,0:c#ui.graphics.Color)958@35227L544:AuditScreen.kt#1so789");
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
            j3 = j;
            i2 |= startRestartGroup.changed(j3) ? 2048 : 1024;
        } else {
            j3 = j;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 16384 : 8192;
        }
        if (!startRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-836908191, i2, -1, "uz.FonRo.pos.ui.docs.AuditTile (AuditScreen.kt:957)");
            }
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(SizeKt.m1084heightInVpY3zN4$default(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), OxShape.INSTANCE.getTileSm()), j2, null, 2, null), Dp.m6989constructorimpl(54.0f), 0.0f, 2, null), Dp.m6989constructorimpl(10.0f), Dp.m6989constructorimpl(8.0f));
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326453197, "C967@35516L72,968@35597L168:AuditScreen.kt#1so789");
            TextKt.m2798Text4IGK_g(str4, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getTileLabel(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), startRestartGroup, (i2 >> 6) & 14, 3072, 57342);
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str3, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getStatValue(), j3, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer2, (i2 >> 3) & 14, 3120, 55294);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda42
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuditScreenKt.AuditTile_ZkgLGzA$lambda$1(RowScope.this, str, str2, j, j2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AuditHistoryCard(final AuditDoc auditDoc, final int i, final String str, final double d, final Function0<Unit> function0, Composer composer, final int i2) {
        int i3;
        int i4;
        double d2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1089812071);
        ComposerKt.sourceInformation(startRestartGroup, "C(AuditHistoryCard)P(2,3)992@36231L1621,992@36144L1708:AuditScreen.kt#1so789");
        if ((i2 & 6) == 0) {
            i3 = ((i2 & 8) == 0 ? startRestartGroup.changed(auditDoc) : startRestartGroup.changedInstance(auditDoc) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 = i;
            i3 |= startRestartGroup.changed(i4) ? 32 : 16;
        } else {
            i4 = i;
        }
        if ((i2 & 384) == 0) {
            i3 |= startRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            d2 = d;
            i3 |= startRestartGroup.changed(d2) ? 2048 : 1024;
        } else {
            d2 = d;
        }
        if ((i2 & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        int i5 = i3;
        if (!startRestartGroup.shouldExecute((i5 & 9363) != 9362, i5 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1089812071, i5, -1, "uz.FonRo.pos.ui.docs.AuditHistoryCard (AuditScreen.kt:990)");
            }
            Iterator<T> it = auditDoc.getItems().iterator();
            double d3 = AudioStats.AUDIO_AMPLITUDE_NONE;
            while (it.hasNext()) {
                d3 += ((AuditItem) it.next()).getDiff();
            }
            final int i6 = i4;
            final double d4 = d2;
            final double d5 = d3;
            composer2 = startRestartGroup;
            BasicsKt.m9829OxCardEOp_iR4(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(9.0f), 7, null), Dp.m6989constructorimpl(12.0f), 0L, null, function0, ComposableLambdaKt.rememberComposableLambda(239233598, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AuditScreenKt.AuditHistoryCard$lambda$1(AuditDoc.this, i6, d5, d4, str, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), composer2, (57344 & i5) | 196662, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuditScreenKt.AuditHistoryCard$lambda$2(AuditDoc.this, i, str, d, function0, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0439  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit AuditHistoryCard$lambda$1(uz.FonRo.pos.data.model.AuditDoc r39, int r40, double r41, double r43, java.lang.String r45, androidx.compose.foundation.layout.ColumnScope r46, androidx.compose.runtime.Composer r47, int r48) {
        /*
            Method dump skipped, instructions count: 1283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.AuditScreenKt.AuditHistoryCard$lambda$1(uz.FonRo.pos.data.model.AuditDoc, int, double, double, java.lang.String, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    private static final void AuditDetailSheet(final AuditDoc auditDoc, final int i, final String str, final Function1<? super Long, Double> function1, final Function0<Unit> function0, Composer composer, final int i2) {
        int i3;
        String str2;
        Composer composer2;
        int i4;
        final int i5;
        Composer startRestartGroup = composer.startRestartGroup(150869063);
        ComposerKt.sourceInformation(startRestartGroup, "C(AuditDetailSheet)P(2,3,1)1056@38530L116,1059@38653L3347,1053@38406L3594:AuditScreen.kt#1so789");
        int i6 = (i2 & 6) == 0 ? ((i2 & 8) == 0 ? startRestartGroup.changed(auditDoc) : startRestartGroup.changedInstance(auditDoc) ? 4 : 2) | i2 : i2;
        if ((i2 & 48) == 0) {
            i3 = i;
            i6 |= startRestartGroup.changed(i3) ? 32 : 16;
        } else {
            i3 = i;
        }
        if ((i2 & 384) == 0) {
            str2 = str;
            i6 |= startRestartGroup.changed(str2) ? 256 : 128;
        } else {
            str2 = str;
        }
        if ((i2 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        int i7 = i6;
        if (!startRestartGroup.shouldExecute((i7 & 9363) != 9362, i7 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(150869063, i7, -1, "uz.FonRo.pos.ui.docs.AuditDetailSheet (AuditScreen.kt:1047)");
            }
            Iterator<T> it = auditDoc.getItems().iterator();
            double d = 0.0d;
            final double d2 = 0.0d;
            while (it.hasNext()) {
                d2 += ((AuditItem) it.next()).getDiff();
            }
            for (AuditItem auditItem : auditDoc.getItems()) {
                d += auditItem.getDiff() * function1.invoke(Long.valueOf(auditItem.getProductId())).doubleValue();
            }
            List<AuditItem> items = auditDoc.getItems();
            if ((items instanceof Collection) && items.isEmpty()) {
                i4 = 0;
            } else {
                Iterator<T> it2 = items.iterator();
                i4 = 0;
                while (it2.hasNext()) {
                    if (((AuditItem) it2.next()).getDiff() < -1.0E-4d && (i4 = i4 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            List<AuditItem> items2 = auditDoc.getItems();
            if ((items2 instanceof Collection) && items2.isEmpty()) {
                i5 = 0;
            } else {
                Iterator<T> it3 = items2.iterator();
                int i8 = 0;
                while (it3.hasNext()) {
                    if (((AuditItem) it3.next()).getDiff() > 1.0E-4d && (i8 = i8 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
                i5 = i8;
            }
            String tx = LangKt.tx("Аудит ", new Object[0]);
            String docNumberText = docNumberText(i3);
            final int i9 = i4;
            final int i10 = i3;
            final String str3 = str2;
            final double d3 = d;
            composer2 = startRestartGroup;
            SheetsKt.OxCardSheet(StringsKt.trim((CharSequence) (tx + docNumberText)).toString(), function0, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(372466548, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda37
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AuditScreenKt.AuditDetailSheet$lambda$4(Function0.this, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1888924501, true, new Function3() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda38
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AuditScreenKt.AuditDetailSheet$lambda$5(AuditDoc.this, i10, str3, d3, i9, i5, d2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), composer2, ((i7 >> 9) & 112) | 14155776, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.docs.AuditScreenKt$$ExternalSyntheticLambda39
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuditScreenKt.AuditDetailSheet$lambda$6(AuditDoc.this, i, str, function1, function0, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AuditDetailSheet$lambda$4(Function0 function0, RowScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C1057@38544L92:AuditScreen.kt#1so789");
        if ((i & 6) == 0) {
            i |= composer.changed(OxCardSheet) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(372466548, i, -1, "uz.FonRo.pos.ui.docs.AuditDetailSheet.<anonymous> (AuditScreen.kt:1057)");
            }
            BasicsKt.OxButton(LangKt.tx("Закрыть", new Object[0]), function0, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.PRIMARY, null, false, false, null, composer, 3072, 240);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x014b, code lost:
    
        if (r1 == null) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit AuditDetailSheet$lambda$5(uz.FonRo.pos.data.model.AuditDoc r104, int r105, java.lang.String r106, double r107, int r109, int r110, double r111, androidx.compose.foundation.layout.ColumnScope r113, androidx.compose.runtime.Composer r114, int r115) {
        /*
            Method dump skipped, instructions count: 2053
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.docs.AuditScreenKt.AuditDetailSheet$lambda$5(uz.FonRo.pos.data.model.AuditDoc, int, java.lang.String, double, int, int, double, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int docNumberOf(List<AuditDoc> list, AuditDoc auditDoc) {
        Iterator<AuditDoc> it = list.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            AuditDoc next = it.next();
            if (next.getId() == auditDoc.getId() && Intrinsics.areEqual(next.getCreatedAt(), auditDoc.getCreatedAt())) {
                break;
            }
            i++;
        }
        if (i < 0) {
            return 0;
        }
        return list.size() - i;
    }

    private static final List<Product> AuditScreen$lambda$0(State<? extends List<Product>> state) {
        return state.getValue();
    }

    private static final List<Category> AuditScreen$lambda$1(State<? extends List<Category>> state) {
        return state.getValue();
    }

    private static final SyncData AuditScreen$lambda$2(State<SyncData> state) {
        return state.getValue();
    }

    private static final AuditSummary AuditScreen$lambda$53(State<AuditSummary> state) {
        return state.getValue();
    }
}
