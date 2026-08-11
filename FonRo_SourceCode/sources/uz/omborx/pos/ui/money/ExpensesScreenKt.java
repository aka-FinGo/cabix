package uz.FonRo.pos.ui.money;

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
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
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
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
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
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.data.model.Expense;
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
import uz.FonRo.pos.ui.components.NumpadKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.PeriodKind;
import uz.FonRo.pos.ui.components.PeriodPickersKt;
import uz.FonRo.pos.ui.components.PeriodState;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxDim;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: ExpensesScreen.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a/\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010\b\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a=\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0003b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010\u0017\u001a5\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0003b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010\u001a\u001a\u001f\u0010\u001b\u001a\u00020\u0003H\u0003b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010\u001c\u001aY\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00102\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0003b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010\"\u001a/\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013H\u0003b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010&\u001aM\u0010'\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00102\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0003b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010)\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0004²\u0006\u0012\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010+X\u008a\u008e\u0002²\u0006\f\u0010,\u001a\u0004\u0018\u00010\u0013X\u008a\u008e\u0002²\u0006\n\u0010-\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010.\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\f\u00100\u001a\u0004\u0018\u00010\u0010X\u008a\u008e\u0002²\u0006\f\u00101\u001a\u0004\u0018\u00010\u0010X\u008a\u008e\u0002²\u0006\n\u00102\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u00103\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u00104\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u00105\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u00106\u001a\u000207X\u008a\u008e\u0002²\u0006\n\u00108\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u00109\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u00104\u001a\u00020\u000eX\u008a\u008e\u0002"}, d2 = {"EXP_LIMIT", "", "ExpensesScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "isSameDay", "", "x", "Luz/FonRo/pos/data/model/Expense;", "ExpenseHero", "total", "", "periodTitle", "onAdd", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ExpenseCard", "onClick", "(Luz/FonRo/pos/data/model/Expense;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ExpensesEmpty", "(Landroidx/compose/runtime/Composer;I)V", "ExpenseSheet", "expense", "onDismiss", "onEdit", "onChanged", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/data/model/Expense;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ExpenseRow", "label", "value", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "ExpenseFormSheet", "onSaved", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/data/model/Expense;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "data", "", "error", "reloadKey", "monthSheet", "dateSheet", "openExpense", "formExpense", "formOpen", "confirm", "busy", "title", "amount", "", "note", "pad"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ExpensesScreenKt {
    private static final int EXP_LIMIT = 200;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExpenseCard$lambda$2(Expense expense, Function0 function0, int i, Composer composer, int i2) {
        ExpenseCard(expense, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExpenseFormSheet$lambda$19(FonRoApp FonRoApp, Expense expense, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        ExpenseFormSheet(FonRoApp, expense, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExpenseHero$lambda$1(String str, String str2, Function0 function0, int i, Composer composer, int i2) {
        ExpenseHero(str, str2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExpenseRow$lambda$1(String str, String str2, int i, Composer composer, int i2) {
        ExpenseRow(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExpenseSheet$lambda$10(FonRoApp FonRoApp, Expense expense, Function0 function0, Function0 function02, Function0 function03, int i, Composer composer, int i2) {
        ExpenseSheet(FonRoApp, expense, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExpensesEmpty$lambda$1(int i, Composer composer, int i2) {
        ExpensesEmpty(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExpensesScreen$lambda$35(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        ExpensesScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ExpensesScreen(FonRoApp FonRoApp, final AppNavigator nav, Composer composer, final int i) {
        final MutableState mutableState;
        boolean z;
        MutableState mutableState2;
        MutableState mutableState3;
        final MutableState mutableState4;
        final MutableState mutableState5;
        final MutableState mutableState6;
        final MutableState mutableState7;
        final MutableState mutableState8;
        final MutableState mutableState9;
        String str;
        final FonRoApp app = FonRoApp;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(nav, "nav");
        Composer startRestartGroup = composer.startRestartGroup(756359186);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExpensesScreen)100@3995L49,101@4062L42,102@4126L30,104@4180L34,105@4236L34,106@4294L43,107@4361L43,108@4425L34,112@4543L408,112@4517L434,125@4972L456,158@6296L2358,155@6144L2510:ExpensesScreen.kt#fh874k");
        int i2 = (i & 6) == 0 ? ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2) | i : i;
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(756359186, i2, -1, "uz.FonRo.pos.ui.money.ExpensesScreen (ExpensesScreen.kt:97)");
            }
            final Repo repo = app.getRepo();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1011707875, "CC(remember):ExpensesScreen.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState10 = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1011710012, "CC(remember):ExpensesScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState11 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1011712048, "CC(remember):ExpensesScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState12 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1011713780, "CC(remember):ExpensesScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState13 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1011715572, "CC(remember):ExpensesScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState14 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1011717437, "CC(remember):ExpensesScreen.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final MutableState mutableState15 = (MutableState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1011719581, "CC(remember):ExpensesScreen.kt#9igjgp");
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final MutableState mutableState16 = (MutableState) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1011721620, "CC(remember):ExpensesScreen.kt#9igjgp");
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            MutableState mutableState17 = (MutableState) rememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final boolean can = repo.can(Perm.MANAGE_EXPENSES);
            Integer valueOf = Integer.valueOf(ExpensesScreen$lambda$7(mutableState12));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1011725770, "CC(remember):ExpensesScreen.kt#9igjgp");
            ExpensesScreenKt$ExpensesScreen$1$1 rememberedValue9 = startRestartGroup.rememberedValue();
            if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                rememberedValue9 = new ExpensesScreenKt$ExpensesScreen$1$1(mutableState11, mutableState10, null);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue9, startRestartGroup, 0);
            List<Expense> ExpensesScreen$lambda$1 = ExpensesScreen$lambda$1(mutableState10);
            PeriodState period = ExpensesState.INSTANCE.getPeriod();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1011739546, "CC(remember):ExpensesScreen.kt#9igjgp");
            boolean changed = startRestartGroup.changed(ExpensesScreen$lambda$1) | startRestartGroup.changed(period);
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                List<Expense> ExpensesScreen$lambda$12 = ExpensesScreen$lambda$1(mutableState10);
                if (ExpensesScreen$lambda$12 == null) {
                    ExpensesScreen$lambda$12 = CollectionsKt.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : ExpensesScreen$lambda$12) {
                    Expense expense = (Expense) obj;
                    if (!expense.isCanceled() && !expense.isCancellation()) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : arrayList) {
                    if (ExpensesState.INSTANCE.getPeriod().contains(((Expense) obj2).getExpenseDate())) {
                        arrayList2.add(obj2);
                    }
                }
                final Comparator comparator = new Comparator() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$ExpensesScreen$lambda$25$$inlined$compareByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((Expense) t2).getExpenseDate(), ((Expense) t).getExpenseDate());
                    }
                };
                rememberedValue10 = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$ExpensesScreen$lambda$25$$inlined$thenByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int compare = comparator.compare(t, t2);
                        return compare != 0 ? compare : ComparisonsKt.compareValues(Long.valueOf(((Expense) t2).getId()), Long.valueOf(((Expense) t).getId()));
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            final List list = (List) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            List list2 = list;
            Iterator it = list2.iterator();
            double d = 0.0d;
            while (it.hasNext()) {
                d += ((Expense) it.next()).getAmount();
            }
            final List take = CollectionsKt.take(list2, 200);
            String ExpensesScreen$lambda$4 = ExpensesScreen$lambda$4(mutableState11);
            if (ExpensesScreen$lambda$4 == null) {
                ExpensesScreen$lambda$4 = "";
            }
            boolean z2 = ExpensesScreen$lambda$1(mutableState10) != null;
            int i3 = i2;
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), OxDim.INSTANCE.m10245getPagePadD9Ej5fM(), 0.0f, 2, null);
            PaddingValues m1046PaddingValuesa9UjIt4$default = PaddingKt.m1046PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(28.0f), 7, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1011783816, "CC(remember):ExpensesScreen.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(repo) | startRestartGroup.changed(d) | startRestartGroup.changed(can) | startRestartGroup.changedInstance(list) | startRestartGroup.changed(ExpensesScreen$lambda$4) | startRestartGroup.changed(z2) | startRestartGroup.changedInstance(take);
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState17;
                final double d2 = d;
                final String str2 = ExpensesScreen$lambda$4;
                final boolean z3 = z2;
                rememberedValue11 = new Function1() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda39
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        Unit ExpensesScreen$lambda$27$0;
                        ExpensesScreen$lambda$27$0 = ExpensesScreenKt.ExpensesScreen$lambda$27$0(str2, z3, list, take, repo, d2, can, mutableState12, mutableState16, mutableState, mutableState13, mutableState14, mutableState15, (LazyListScope) obj3);
                        return ExpensesScreen$lambda$27$0;
                    }
                };
                z = can;
                mutableState2 = mutableState12;
                mutableState3 = mutableState16;
                mutableState4 = mutableState13;
                mutableState5 = mutableState14;
                mutableState6 = mutableState15;
                startRestartGroup.updateRememberedValue(rememberedValue11);
            } else {
                z = can;
                mutableState2 = mutableState12;
                mutableState3 = mutableState16;
                mutableState = mutableState17;
                mutableState4 = mutableState13;
                mutableState5 = mutableState14;
                mutableState6 = mutableState15;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final boolean z4 = z;
            LazyDslKt.LazyColumn(m1051paddingVpY3zN4$default, null, m1046PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) rememberedValue11, startRestartGroup, 384, TypedValues.PositionType.TYPE_PERCENT_X);
            if (ExpensesScreen$lambda$10(mutableState4)) {
                startRestartGroup.startReplaceGroup(1302825907);
                ComposerKt.sourceInformation(startRestartGroup, "229@8774L22,230@8819L190,227@8686L333");
                String month = ExpensesState.INSTANCE.getPeriod().getMonth();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1011860776, "CC(remember):ExpensesScreen.kt#9igjgp");
                Object rememberedValue12 = startRestartGroup.rememberedValue();
                if (rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue12 = new Function0() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda41
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ExpensesScreen$lambda$28$0;
                            ExpensesScreen$lambda$28$0 = ExpensesScreenKt.ExpensesScreen$lambda$28$0(MutableState.this);
                            return ExpensesScreen$lambda$28$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue12);
                }
                Function0 function0 = (Function0) rememberedValue12;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1011862384, "CC(remember):ExpensesScreen.kt#9igjgp");
                Object rememberedValue13 = startRestartGroup.rememberedValue();
                if (rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue13 = new Function1() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda42
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            Unit ExpensesScreen$lambda$29$0;
                            ExpensesScreen$lambda$29$0 = ExpensesScreenKt.ExpensesScreen$lambda$29$0(MutableState.this, (String) obj3);
                            return ExpensesScreen$lambda$29$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue13);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                PeriodPickersKt.OxMonthSheet(month, function0, (Function1) rememberedValue13, startRestartGroup, 432);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1303161296);
                startRestartGroup.endReplaceGroup();
            }
            if (ExpensesScreen$lambda$13(mutableState5)) {
                startRestartGroup.startReplaceGroup(1303192947);
                ComposerKt.sourceInformation(startRestartGroup, "242@9148L21,243@9192L187,240@9056L333");
                String date = ExpensesState.INSTANCE.getPeriod().getDate();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1011872743, "CC(remember):ExpensesScreen.kt#9igjgp");
                Object rememberedValue14 = startRestartGroup.rememberedValue();
                if (rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue14 = new Function0() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ExpensesScreen$lambda$30$0;
                            ExpensesScreen$lambda$30$0 = ExpensesScreenKt.ExpensesScreen$lambda$30$0(MutableState.this);
                            return ExpensesScreen$lambda$30$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue14);
                }
                Function0 function02 = (Function0) rememberedValue14;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1011874317, "CC(remember):ExpensesScreen.kt#9igjgp");
                Object rememberedValue15 = startRestartGroup.rememberedValue();
                if (rememberedValue15 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue15 = new Function1() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            Unit ExpensesScreen$lambda$31$0;
                            ExpensesScreen$lambda$31$0 = ExpensesScreenKt.ExpensesScreen$lambda$31$0(MutableState.this, (String) obj3);
                            return ExpensesScreen$lambda$31$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue15);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                PeriodPickersKt.OxDayPickerDialog(date, function02, (Function1) rememberedValue15, startRestartGroup, 432);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1303528336);
                startRestartGroup.endReplaceGroup();
            }
            final Expense ExpensesScreen$lambda$16 = ExpensesScreen$lambda$16(mutableState6);
            if (ExpensesScreen$lambda$16 != null) {
                startRestartGroup.startReplaceGroup(1303554624);
                ComposerKt.sourceInformation(startRestartGroup, "*256@9531L22,257@9576L21,258@9623L15,253@9439L209");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 76168309, "CC(remember):ExpensesScreen.kt#9igjgp");
                Object rememberedValue16 = startRestartGroup.rememberedValue();
                if (rememberedValue16 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue16 = new Function0() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ExpensesScreen$lambda$32$0$0;
                            ExpensesScreen$lambda$32$0$0 = ExpensesScreenKt.ExpensesScreen$lambda$32$0$0(MutableState.this);
                            return ExpensesScreen$lambda$32$0$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue16);
                }
                Function0 function03 = (Function0) rememberedValue16;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 76169748, "CC(remember):ExpensesScreen.kt#9igjgp");
                boolean changed2 = startRestartGroup.changed(z4) | startRestartGroup.changedInstance(ExpensesScreen$lambda$16);
                Object rememberedValue17 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue17 == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState18 = mutableState2;
                    mutableState7 = mutableState3;
                    final MutableState mutableState19 = mutableState;
                    Function0 function04 = new Function0() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ExpensesScreen$lambda$32$1$0;
                            ExpensesScreen$lambda$32$1$0 = ExpensesScreenKt.ExpensesScreen$lambda$32$1$0(Expense.this, z4, mutableState18, mutableState7, mutableState19);
                            return ExpensesScreen$lambda$32$1$0;
                        }
                    };
                    mutableState8 = mutableState18;
                    mutableState9 = mutableState19;
                    startRestartGroup.updateRememberedValue(function04);
                    rememberedValue17 = function04;
                } else {
                    mutableState8 = mutableState2;
                    mutableState7 = mutableState3;
                    mutableState9 = mutableState;
                }
                Function0 function05 = (Function0) rememberedValue17;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 76171246, "CC(remember):ExpensesScreen.kt#9igjgp");
                Object rememberedValue18 = startRestartGroup.rememberedValue();
                if (rememberedValue18 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue18 = new Function0() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ExpensesScreen$lambda$32$2$0;
                            ExpensesScreen$lambda$32$2$0 = ExpensesScreenKt.ExpensesScreen$lambda$32$2$0(MutableState.this);
                            return ExpensesScreen$lambda$32$2$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue18);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                str = "CC(remember):ExpensesScreen.kt#9igjgp";
                ExpenseSheet(FonRoApp, ExpensesScreen$lambda$16, function03, function05, (Function0) rememberedValue18, startRestartGroup, FonRoApp.$stable | 24960 | (i3 & 14) | (Expense.$stable << 3));
                startRestartGroup = startRestartGroup;
                Unit unit = Unit.INSTANCE;
                startRestartGroup.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            } else {
                startRestartGroup.startReplaceGroup(1303554623);
                startRestartGroup.endReplaceGroup();
                mutableState8 = mutableState2;
                str = "CC(remember):ExpensesScreen.kt#9igjgp";
                mutableState7 = mutableState3;
                startRestartGroup = startRestartGroup;
                mutableState9 = mutableState;
            }
            if (ExpensesScreen$lambda$22(mutableState9)) {
                startRestartGroup.startReplaceGroup(1303810839);
                ComposerKt.sourceInformation(startRestartGroup, "266@9784L20,267@9828L15,263@9684L169");
                Expense ExpensesScreen$lambda$19 = ExpensesScreen$lambda$19(mutableState7);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1011893094, str);
                Object rememberedValue19 = startRestartGroup.rememberedValue();
                if (rememberedValue19 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue19 = new Function0() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ExpensesScreen$lambda$33$0;
                            ExpensesScreen$lambda$33$0 = ExpensesScreenKt.ExpensesScreen$lambda$33$0(MutableState.this);
                            return ExpensesScreen$lambda$33$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue19);
                }
                Function0 function06 = (Function0) rememberedValue19;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1011894497, str);
                Object rememberedValue20 = startRestartGroup.rememberedValue();
                if (rememberedValue20 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue20 = new Function0() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ExpensesScreen$lambda$34$0;
                            ExpensesScreen$lambda$34$0 = ExpensesScreenKt.ExpensesScreen$lambda$34$0(MutableState.this);
                            return ExpensesScreen$lambda$34$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue20);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                app = FonRoApp;
                ExpenseFormSheet(app, ExpensesScreen$lambda$19, function06, (Function0) rememberedValue20, startRestartGroup, (Expense.$stable << 3) | FonRoApp.$stable | 3456 | (i3 & 14));
                startRestartGroup.endReplaceGroup();
            } else {
                app = FonRoApp;
                startRestartGroup.startReplaceGroup(1303988624);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda40
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return ExpensesScreenKt.ExpensesScreen$lambda$35(FonRoApp.this, nav, i, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    private static final List<Expense> ExpensesScreen$lambda$1(MutableState<List<Expense>> mutableState) {
        return mutableState.getValue();
    }

    private static final String ExpensesScreen$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final int ExpensesScreen$lambda$7(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void ExpensesScreen$lambda$8(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final boolean ExpensesScreen$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ExpensesScreen$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean ExpensesScreen$lambda$13(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ExpensesScreen$lambda$14(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Expense ExpensesScreen$lambda$16(MutableState<Expense> mutableState) {
        return mutableState.getValue();
    }

    private static final Expense ExpensesScreen$lambda$19(MutableState<Expense> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ExpensesScreen$lambda$22(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ExpensesScreen$lambda$23(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void ExpensesScreen$openForm(boolean z, MutableState<Integer> mutableState, MutableState<Expense> mutableState2, MutableState<Boolean> mutableState3, Expense expense) {
        if (!z) {
            Toaster.INSTANCE.error(LangKt.tx("Нет права на расходы", new Object[0]));
            return;
        }
        if (expense != null && !isSameDay(expense)) {
            Toaster.INSTANCE.error(LangKt.tx("День закрыт: изменить и отменить можно только расход за сегодня.", new Object[0]));
            ExpensesScreen$lambda$8(mutableState, ExpensesScreen$lambda$7(mutableState) + 1);
        } else {
            mutableState2.setValue(expense);
            ExpensesScreen$lambda$23(mutableState3, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpensesScreen$lambda$27$0(final String str, boolean z, final List list, final List list2, final Repo repo, final double d, final boolean z2, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, LazyListScope LazyColumn) {
        LazyListScope lazyListScope;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$ExpensesScreenKt.INSTANCE.getLambda$1371649821$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1529954694, true, new Function3() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit ExpensesScreen$lambda$27$0$0;
                ExpensesScreen$lambda$27$0$0 = ExpensesScreenKt.ExpensesScreen$lambda$27$0$0(Repo.this, d, z2, mutableState, mutableState2, mutableState3, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return ExpensesScreen$lambda$27$0$0;
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$ExpensesScreenKt.INSTANCE.m9971getLambda$127051547$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1784057788, true, new Function3() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit ExpensesScreen$lambda$27$0$1;
                ExpensesScreen$lambda$27$0$1 = ExpensesScreenKt.ExpensesScreen$lambda$27$0$1(MutableState.this, mutableState5, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return ExpensesScreen$lambda$27$0$1;
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(853903267, true, new Function3() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit ExpensesScreen$lambda$27$0$2;
                ExpensesScreen$lambda$27$0$2 = ExpensesScreenKt.ExpensesScreen$lambda$27$0$2(list, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return ExpensesScreen$lambda$27$0$2;
            }
        }), 3, null);
        if (str.length() > 0) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-592438235, true, new Function3() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ExpensesScreen$lambda$27$0$3;
                    ExpensesScreen$lambda$27$0$3 = ExpensesScreenKt.ExpensesScreen$lambda$27$0$3(str, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ExpensesScreen$lambda$27$0$3;
                }
            }), 3, null);
        } else if (!z) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$ExpensesScreenKt.INSTANCE.m9973getLambda$2058247396$app(), 3, null);
        } else if (list.isEmpty()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$ExpensesScreenKt.INSTANCE.m9972getLambda$1356312803$app(), 3, null);
        } else {
            if (list.size() > 200) {
                lazyListScope = LazyColumn;
                LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-1205062911, true, new Function3() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda35
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit ExpensesScreen$lambda$27$0$4;
                        ExpensesScreen$lambda$27$0$4 = ExpensesScreenKt.ExpensesScreen$lambda$27$0$4(list, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return ExpensesScreen$lambda$27$0$4;
                    }
                }), 3, null);
            } else {
                lazyListScope = LazyColumn;
            }
            final Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object ExpensesScreen$lambda$27$0$5;
                    ExpensesScreen$lambda$27$0$5 = ExpensesScreenKt.ExpensesScreen$lambda$27$0$5((Expense) obj);
                    return ExpensesScreen$lambda$27$0$5;
                }
            };
            final ExpensesScreenKt$ExpensesScreen$lambda$27$0$$inlined$items$default$1 expensesScreenKt$ExpensesScreen$lambda$27$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$ExpensesScreen$lambda$27$0$$inlined$items$default$1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(Expense expense) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((Expense) obj);
                }
            };
            lazyListScope.items(list2.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$ExpensesScreen$lambda$27$0$$inlined$items$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i) {
                    return Function1.this.invoke(list2.get(i));
                }
            }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$ExpensesScreen$lambda$27$0$$inlined$items$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i) {
                    return Function1.this.invoke(list2.get(i));
                }
            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$ExpensesScreen$lambda$27$0$$inlined$items$default$4
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
                    final Expense expense = (Expense) list2.get(i);
                    composer.startReplaceGroup(1532877931);
                    ComposerKt.sourceInformation(composer, "C*220@8581L25,220@8560L46:ExpensesScreen.kt#fh874k");
                    ComposerKt.sourceInformationMarkerStart(composer, 1019279651, "CC(remember):ExpensesScreen.kt#9igjgp");
                    boolean changedInstance = composer.changedInstance(expense);
                    Object rememberedValue = composer.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        final MutableState mutableState7 = mutableState6;
                        rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$ExpensesScreen$2$1$7$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                mutableState7.setValue(Expense.this);
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ExpensesScreenKt.ExpenseCard(expense, (Function0) rememberedValue, composer, Expense.$stable);
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
    public static final Unit ExpensesScreen$lambda$27$0$0(Repo repo, double d, final boolean z, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C167@6529L18,164@6389L172:ExpensesScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1529954694, i, -1, "uz.FonRo.pos.ui.money.ExpensesScreen.<anonymous>.<anonymous>.<anonymous> (ExpensesScreen.kt:164)");
            }
            String money = repo.money(Double.valueOf(d));
            String title = ExpensesState.INSTANCE.getPeriod().title();
            ComposerKt.sourceInformationMarkerStart(composer, 1407650648, "CC(remember):ExpensesScreen.kt#9igjgp");
            boolean changed = composer.changed(z);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ExpensesScreen$lambda$27$0$0$0$0;
                        ExpensesScreen$lambda$27$0$0$0$0 = ExpensesScreenKt.ExpensesScreen$lambda$27$0$0$0$0(z, mutableState, mutableState2, mutableState3);
                        return ExpensesScreen$lambda$27$0$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ExpenseHero(money, title, (Function0) rememberedValue, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpensesScreen$lambda$27$0$0$0$0(boolean z, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        ExpensesScreen$openForm(z, mutableState, mutableState2, mutableState3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpensesScreen$lambda$27$0$1(final MutableState mutableState, final MutableState mutableState2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C182@6990L29,189@7301L21,190@7353L20,180@6902L485:ExpensesScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1784057788, i, -1, "uz.FonRo.pos.ui.money.ExpensesScreen.<anonymous>.<anonymous>.<anonymous> (ExpensesScreen.kt:180)");
            }
            PeriodState period = ExpensesState.INSTANCE.getPeriod();
            ComposerKt.sourceInformationMarkerStart(composer, -787579871, "CC(remember):ExpensesScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ExpensesScreen$lambda$27$0$1$0$0;
                        ExpensesScreen$lambda$27$0$1$0$0 = ExpensesScreenKt.ExpensesScreen$lambda$27$0$1$0$0((PeriodState) obj);
                        return ExpensesScreen$lambda$27$0$1$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function1 function1 = (Function1) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipTint chipTint = ChipTint.RED;
            List listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(LangKt.tx("Все", new Object[0]), PeriodKind.ALL), TuplesKt.to(LangKt.tx("Сегодня", new Object[0]), PeriodKind.TODAY), TuplesKt.to(LangKt.tx("10 дней", new Object[0]), PeriodKind.DAYS_10)});
            ComposerKt.sourceInformationMarkerStart(composer, -787569927, "CC(remember):ExpensesScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ExpensesScreen$lambda$27$0$1$1$0;
                        ExpensesScreen$lambda$27$0$1$1$0 = ExpensesScreenKt.ExpensesScreen$lambda$27$0$1$1$0(MutableState.this);
                        return ExpensesScreen$lambda$27$0$1$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            Function0 function0 = (Function0) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -787568264, "CC(remember):ExpensesScreen.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ExpensesScreen$lambda$27$0$1$2$0;
                        ExpensesScreen$lambda$27$0$1$2$0 = ExpensesScreenKt.ExpensesScreen$lambda$27$0$1$2$0(MutableState.this);
                        return ExpensesScreen$lambda$27$0$1$2$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.OxPeriodChips(period, function1, null, chipTint, listOf, function0, (Function0) rememberedValue3, composer, PeriodState.$stable | 1772592, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpensesScreen$lambda$27$0$1$0$0(PeriodState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ExpensesState.INSTANCE.setPeriod(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpensesScreen$lambda$27$0$1$1$0(MutableState mutableState) {
        ExpensesScreen$lambda$11(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpensesScreen$lambda$27$0$1$2$0(MutableState mutableState) {
        ExpensesScreen$lambda$14(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpensesScreen$lambda$27$0$2(List list, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C195@7426L167:ExpensesScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(853903267, i, -1, "uz.FonRo.pos.ui.money.ExpensesScreen.<anonymous>.<anonymous>.<anonymous> (ExpensesScreen.kt:195)");
            }
            BasicsKt.OxSectionHead(LangKt.tx("История расходов", new Object[0]), null, null, String.valueOf(list.size()), ChipTone.BAD, null, composer, 24576, 38);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpensesScreen$lambda$27$0$3(String str, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C203@7665L22:ExpensesScreen.kt#fh874k");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-592438235, i, -1, "uz.FonRo.pos.ui.money.ExpensesScreen.<anonymous>.<anonymous>.<anonymous> (ExpensesScreen.kt:203)");
            }
            BasicsKt.OxEmptyNote(str, null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpensesScreen$lambda$27$0$4(List list, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C211@8096L342:ExpensesScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1205062911, i, -1, "uz.FonRo.pos.ui.money.ExpensesScreen.<anonymous>.<anonymous>.<anonymous> (ExpensesScreen.kt:211)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Показаны последние %s из %s —", 200, Integer.valueOf(list.size())) + LangKt.tx(" итог в шапке посчитан по всем.", new Object[0]), PaddingKt.m1051paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(10.0f), 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), Ox.INSTANCE.m10200getDim20d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 48, 0, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ExpensesScreen$lambda$27$0$5(Expense it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpensesScreen$lambda$28$0(MutableState mutableState) {
        ExpensesScreen$lambda$11(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpensesScreen$lambda$29$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ExpensesState.INSTANCE.setPeriod(PeriodState.copy$default(ExpensesState.INSTANCE.getPeriod(), PeriodKind.MONTH, it, null, 4, null));
        ExpensesScreen$lambda$11(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpensesScreen$lambda$30$0(MutableState mutableState) {
        ExpensesScreen$lambda$14(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpensesScreen$lambda$31$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ExpensesState.INSTANCE.setPeriod(PeriodState.copy$default(ExpensesState.INSTANCE.getPeriod(), PeriodKind.DATE, null, it, 2, null));
        ExpensesScreen$lambda$14(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpensesScreen$lambda$32$0$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpensesScreen$lambda$32$1$0(Expense expense, boolean z, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        ExpensesScreen$openForm(z, mutableState, mutableState2, mutableState3, expense);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpensesScreen$lambda$32$2$0(MutableState mutableState) {
        ExpensesScreen$lambda$8(mutableState, ExpensesScreen$lambda$7(mutableState) + 1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpensesScreen$lambda$33$0(MutableState mutableState) {
        ExpensesScreen$lambda$23(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpensesScreen$lambda$34$0(MutableState mutableState) {
        ExpensesScreen$lambda$8(mutableState, ExpensesScreen$lambda$7(mutableState) + 1);
        return Unit.INSTANCE;
    }

    private static final boolean isSameDay(Expense expense) {
        if (expense.isCanceled() || expense.isCancellation()) {
            return false;
        }
        return Intrinsics.areEqual(StringsKt.take(expense.getExpenseDate(), 10), Fmt.INSTANCE.todayISO());
    }

    private static final void ExpenseHero(String str, final String str2, Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        final String str3 = str;
        final Function0<Unit> function02 = function0;
        Composer startRestartGroup = composer.startRestartGroup(1563357187);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExpenseHero)P(2,1)285@10297L2445:ExpensesScreen.kt#fh874k");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str3) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1563357187, i2, -1, "uz.FonRo.pos.ui.money.ExpenseHero (ExpensesScreen.kt:284)");
            }
            Modifier m1049padding3ABfNKs = PaddingKt.m1049padding3ABfNKs(BorderKt.m569borderxT4_qwU(BackgroundKt.background$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), OxShape.INSTANCE.getHero()), Brush.Companion.m4336linearGradientmHitzGk$default(Brush.INSTANCE, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10224getRed0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null))), TuplesKt.to(Float.valueOf(0.55f), Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10213getOrange0d7_KjU(), 0.13f, 0.0f, 0.0f, 0.0f, 14, null))), TuplesKt.to(Float.valueOf(1.0f), Color.m4374boximpl(Color.m4383copywmQWz5c$default(Ox.INSTANCE.m10223getPurple0d7_KjU(), 0.09f, 0.0f, 0.0f, 0.0f, 14, null)))}, 0L, 0L, 0, 14, (Object) null), null, 0.0f, 6, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10205getHeroEdge0d7_KjU(), OxShape.INSTANCE.getHero()), Dp.m6989constructorimpl(16.0f));
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -636668103, "C299@10755L823,321@11587L244,328@11840L896:ExpensesScreen.kt#fh874k");
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -916628650, "C304@10956L257,311@11226L342:ExpensesScreen.kt#fh874k");
            int i3 = i2;
            TextKt.m2798Text4IGK_g(LangKt.tx("Расходы за период", new Object[0]), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), TextUnitKt.getSp(13.5d), FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), startRestartGroup, 0, 0, 65532);
            TextKt.m2798Text4IGK_g(str2, PaddingKt.m1050paddingVpY3zN4(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, OxShape.INSTANCE.getPill()), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10196getDanger0d7_KjU(), 0.14f), null, 2, null), Dp.m6989constructorimpl(12.0f), Dp.m6989constructorimpl(6.0f)), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getChip(), Ox.INSTANCE.m10196getDanger0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), startRestartGroup, (i3 >> 3) & 14, 3072, 57340);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            TextKt.m2798Text4IGK_g(str3, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(10.0f), 0.0f, Dp.m6989constructorimpl(13.0f), 5, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getAmountXl(), 0L, 0L, null, null, null, null, null, TextUnitKt.getSp(-1.5d), null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777087, null), startRestartGroup, (i3 & 14) | 48, 3120, 55292);
            function02 = function0;
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(ModifiersKt.oxClickable$default(BackgroundKt.background$default(ClipKt.clip(SizeKt.m1084heightInVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6989constructorimpl(52.0f), 0.0f, 2, null), OxShape.INSTANCE.getCardSoft()), Brush.Companion.m4333horizontalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m4374boximpl(ColorKt.Color(4284201205L)), Color.m4374boximpl(ColorKt.Color(4286553333L))}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), false, null, 0L, function0, 7, null), Dp.m6989constructorimpl(14.0f), 0.0f, 2, null);
            Arrangement.Horizontal m931spacedByD5KLDUw = Arrangement.INSTANCE.m931spacedByD5KLDUw(Dp.m6989constructorimpl(9.0f), Alignment.INSTANCE.getCenterHorizontally());
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m931spacedByD5KLDUw, centerVertically2, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m1051paddingVpY3zN4$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1484423456, "C339@12357L143,343@12513L213:ExpensesScreen.kt#fh874k");
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getAdd(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(20.0f)), Color.INSTANCE.m4421getWhite0d7_KjU(), startRestartGroup, 3504, 0);
            composer2 = startRestartGroup;
            str3 = str;
            TextKt.m2798Text4IGK_g(LangKt.tx("Добавить расход", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Color.INSTANCE.m4421getWhite0d7_KjU(), TextUnitKt.getSp(15.5d), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer2, 0, 0, 65534);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExpensesScreenKt.ExpenseHero$lambda$1(str3, str2, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ExpenseCard(final Expense expense, final Function0<Unit> function0, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-838278143);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExpenseCard)P(1)360@13082L1852,360@13007L1927:ExpensesScreen.kt#fh874k");
        int i2 = (i & 6) == 0 ? ((i & 8) == 0 ? startRestartGroup.changed(expense) : startRestartGroup.changedInstance(expense) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-838278143, i2, -1, "uz.FonRo.pos.ui.money.ExpenseCard (ExpensesScreen.kt:356)");
            }
            String dt = Fmt.INSTANCE.dt(expense.getExpenseDate(), false);
            String createdByName = expense.getCreatedByName();
            if (createdByName == null) {
                createdByName = "";
            }
            String note = expense.getNote();
            List listOf = CollectionsKt.listOf((Object[]) new String[]{dt, createdByName, note != null ? note : ""});
            ArrayList arrayList = new ArrayList();
            for (Object obj : listOf) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList.add(obj);
                }
            }
            final String joinToString$default = CollectionsKt.joinToString$default(arrayList, " · ", null, null, 0, null, null, 62, null);
            BasicsKt.m9833OxSoftCardCe4qNIY(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(11.0f), 7, null), 0.0f, null, 0L, 0L, function0, ComposableLambdaKt.rememberComposableLambda(-717437125, true, new Function3() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return ExpensesScreenKt.ExpenseCard$lambda$1(joinToString$default, expense, (ColumnScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i2 << 12) & 458752) | 1572870, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ExpensesScreenKt.ExpenseCard$lambda$2(Expense.this, function0, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExpenseCard$lambda$1(String str, Expense expense, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C361@13092L1836:ExpensesScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-717437125, i, -1, "uz.FonRo.pos.ui.money.ExpenseCard.<anonymous> (ExpensesScreen.kt:361)");
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
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1676039450, "C366@13280L356,375@13649L1269:ExpensesScreen.kt#fh874k");
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(52.0f)), OxShape.INSTANCE.getTile()), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10196getDanger0d7_KjU(), 0.12f), null, 2, null);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1740876298, "C370@13466L156:ExpensesScreen.kt#fh874k");
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getWallet(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(22.0f)), Ox.INSTANCE.m10196getDanger0d7_KjU(), composer, 432, 0);
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
            ComposerKt.sourceInformationMarkerStart(composer, 13054441, "C376@13695L867:ExpensesScreen.kt#fh874k");
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
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
            ComposerKt.sourceInformationMarkerStart(composer, -277871463, "C381@13923L312,388@14256L288:ExpensesScreen.kt#fh874k");
            TextKt.m2798Text4IGK_g(expense.getTitle(), RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH3(), 0L, TextUnitKt.getSp(15), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 0, 3120, 55292);
            TextKt.m2798Text4IGK_g("-" + Fmt.INSTANCE.nf(Double.valueOf(expense.getAmount())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10196getDanger0d7_KjU(), TextUnitKt.getSp(16), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 0, 3072, 57342);
            Composer composer2 = composer;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (!StringsKt.isBlank(str)) {
                composer2.startReplaceGroup(13945690);
                ComposerKt.sourceInformation(composer2, "397@14623L263");
                TextKt.m2798Text4IGK_g(str, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(3.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 48, 3120, 55292);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(14216289);
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ExpensesEmpty(Composer composer, final int i) {
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-635244589);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExpensesEmpty)413@15020L710:ExpensesScreen.kt#fh874k");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-635244589, i, -1, "uz.FonRo.pos.ui.money.ExpensesEmpty (ExpensesScreen.kt:412)");
            }
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), OxShape.INSTANCE.getCard()), Ox.INSTANCE.m10218getPanel20d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getCard()), Dp.m6989constructorimpl(20.0f), Dp.m6989constructorimpl(44.0f));
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 409288631, "C422@15337L54,423@15400L11,424@15420L66,425@15495L10,426@15514L210:ExpensesScreen.kt#fh874k");
            TextKt.m2798Text4IGK_g("👛", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), 0L, TextUnitKt.getSp(44), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), startRestartGroup, 6, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), startRestartGroup, 6);
            TextKt.m2798Text4IGK_g(LangKt.tx("Расходов нет", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH2(), 0L, TextUnitKt.getSp(17), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), startRestartGroup, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), startRestartGroup, 6);
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(LangKt.tx("Для выбранного периода расходы не найдены.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), TextUnitKt.getSp(13.5d), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6873getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744444, null), composer2, 0, 0, 65534);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExpensesScreenKt.ExpensesEmpty$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ExpenseSheet(final FonRoApp FonRoApp, final Expense expense, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, Composer composer, final int i) {
        int i2;
        Function0<Unit> function04;
        MutableState mutableState;
        ComposableLambda composableLambda;
        Composer startRestartGroup = composer.startRestartGroup(-1695614838);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExpenseSheet)P(!2,3,4)446@15976L24,447@16020L34,448@16071L34,502@18091L2144,502@18016L2219:ExpensesScreen.kt#fh874k");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(FonRoApp) : startRestartGroup.changedInstance(FonRoApp) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(expense) : startRestartGroup.changedInstance(expense) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            function04 = function0;
            i2 |= startRestartGroup.changedInstance(function04) ? 256 : 128;
        } else {
            function04 = function0;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function03) ? 16384 : 8192;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1695614838, i3, -1, "uz.FonRo.pos.ui.money.ExpenseSheet (ExpensesScreen.kt:444)");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1693246900, "CC(remember):ExpensesScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1693245268, "CC(remember):ExpensesScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final boolean can = repo.can(Perm.MANAGE_EXPENSES);
            boolean isSameDay = isSameDay(expense);
            final boolean z = can && isSameDay && expense.getCanEdit();
            final boolean z2 = can && isSameDay && expense.getCanCancel();
            final boolean z3 = (expense.isCanceled() || expense.isCancellation() || isSameDay) ? false : true;
            if (!z && !z2) {
                startRestartGroup.startReplaceGroup(-949547373);
                startRestartGroup.endReplaceGroup();
                composableLambda = null;
                mutableState = mutableState2;
            } else {
                startRestartGroup.startReplaceGroup(-1693197484);
                ComposerKt.sourceInformation(startRestartGroup, "487@17551L458");
                final Function0<Unit> function05 = function04;
                mutableState = mutableState2;
                ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1725966619, true, new Function3() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ExpensesScreenKt.ExpenseSheet$lambda$6(z, function05, function02, z2, mutableState2, mutableState3, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, startRestartGroup, 54);
                startRestartGroup.endReplaceGroup();
                composableLambda = rememberComposableLambda;
            }
            final boolean z4 = z;
            final boolean z5 = z2;
            final MutableState mutableState4 = mutableState;
            SheetsKt.OxCardSheet(LangKt.tx("Расход", new Object[0]), function0, null, false, false, false, composableLambda, ComposableLambdaKt.rememberComposableLambda(1767738606, true, new Function3() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ExpensesScreenKt.ExpenseSheet$lambda$7(Expense.this, can, z4, z5, z3, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i3 >> 3) & 112) | 12582912, 60);
            startRestartGroup = startRestartGroup;
            if (ExpenseSheet$lambda$1(mutableState4)) {
                startRestartGroup.startReplaceGroup(-946837817);
                ComposerKt.sourceInformation(startRestartGroup, "557@20486L12,558@20524L19,553@20264L289");
                String tx = LangKt.tx("Отменить расход?", new Object[0]);
                String tx2 = LangKt.tx("«%s» на %s будет отменён.", expense.getTitle(), repo.money(Double.valueOf(expense.getAmount())));
                String tx3 = LangKt.tx("Отменить", new Object[0]);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1693104010, "CC(remember):ExpensesScreen.kt#9igjgp");
                boolean changedInstance = ((57344 & i3) == 16384) | ((i3 & 112) == 32 || ((i3 & 64) != 0 && startRestartGroup.changedInstance(expense))) | ((i3 & 896) == 256) | startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(repo);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    Function0 function06 = new Function0() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ExpenseSheet$lambda$8$0;
                            ExpenseSheet$lambda$8$0 = ExpensesScreenKt.ExpenseSheet$lambda$8$0(Expense.this, function03, function0, coroutineScope, mutableState3, repo);
                            return ExpenseSheet$lambda$8$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(function06);
                    rememberedValue4 = function06;
                }
                Function0 function07 = (Function0) rememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1693102787, "CC(remember):ExpensesScreen.kt#9igjgp");
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue5 = new Function0() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ExpenseSheet$lambda$9$0;
                            ExpenseSheet$lambda$9$0 = ExpensesScreenKt.ExpenseSheet$lambda$9$0(MutableState.this);
                            return ExpenseSheet$lambda$9$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                SheetsKt.OxConfirmSheet(tx, tx2, tx3, null, function07, (Function0) rememberedValue5, startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 8);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-946544712);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExpensesScreenKt.ExpenseSheet$lambda$10(FonRoApp.this, expense, function0, function02, function03, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean ExpenseSheet$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ExpenseSheet$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean ExpenseSheet$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ExpenseSheet$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void ExpenseSheet$cancel(Expense expense, Function0<Unit> function0, Function0<Unit> function02, CoroutineScope coroutineScope, MutableState<Boolean> mutableState, Repo repo) {
        if (ExpenseSheet$lambda$4(mutableState)) {
            return;
        }
        if (!isSameDay(expense)) {
            Toaster.INSTANCE.error(LangKt.tx("День закрыт: изменить и отменить можно только расход за сегодня.", new Object[0]));
            function0.invoke();
            function02.invoke();
        } else {
            ExpenseSheet$lambda$5(mutableState, true);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ExpensesScreenKt$ExpenseSheet$cancel$1(expense, repo, function0, function02, mutableState, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExpenseSheet$lambda$6(boolean z, final Function0 function0, final Function0 function02, boolean z2, final MutableState mutableState, MutableState mutableState2, RowScope rowScope, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(rowScope, "<this>");
        ComposerKt.sourceInformation(composer, "C:ExpensesScreen.kt#fh874k");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(rowScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1725966619, i2, -1, "uz.FonRo.pos.ui.money.ExpenseSheet.<anonymous> (ExpensesScreen.kt:488)");
            }
            if (z) {
                composer.startReplaceGroup(-1076889740);
                ComposerKt.sourceInformation(composer, "489@17622L25,489@17597L83");
                String tx = LangKt.tx("Изменить", new Object[0]);
                ComposerKt.sourceInformationMarkerStart(composer, 796546900, "CC(remember):ExpensesScreen.kt#9igjgp");
                boolean changed = composer.changed(function0) | composer.changed(function02);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda33
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ExpenseSheet$lambda$6$0$0;
                            ExpenseSheet$lambda$6$0$0 = ExpensesScreenKt.ExpenseSheet$lambda$6$0$0(Function0.this, function02);
                            return ExpenseSheet$lambda$6$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                BasicsKt.OxButton(tx, (Function0) rememberedValue, RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), null, null, false, false, null, composer, 0, 248);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1076779225);
                composer.endReplaceGroup();
            }
            if (z2) {
                composer.startReplaceGroup(-1076740940);
                ComposerKt.sourceInformation(composer, "494@17815L18,492@17742L243");
                String tx2 = LangKt.tx("Отменить расход", new Object[0]);
                ComposerKt.sourceInformationMarkerStart(composer, 796553069, "CC(remember):ExpensesScreen.kt#9igjgp");
                Object rememberedValue2 = composer.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda37
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ExpenseSheet$lambda$6$1$0;
                            ExpenseSheet$lambda$6$1$0 = ExpensesScreenKt.ExpenseSheet$lambda$6$1$0(MutableState.this);
                            return ExpenseSheet$lambda$6$1$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                BasicsKt.OxButton(tx2, (Function0) rememberedValue2, RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.DANGER, null, !ExpenseSheet$lambda$4(mutableState2), false, null, composer, 3120, 208);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1076476665);
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
    public static final Unit ExpenseSheet$lambda$6$0$0(Function0 function0, Function0 function02) {
        function0.invoke();
        function02.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpenseSheet$lambda$6$1$0(MutableState mutableState) {
        ExpenseSheet$lambda$2(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExpenseSheet$lambda$7(final Expense expense, boolean z, boolean z2, boolean z3, boolean z4, ColumnScope OxCardSheet, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer2, "C503@18132L21,503@18101L2128:ExpensesScreen.kt#fh874k");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1767738606, i, -1, "uz.FonRo.pos.ui.money.ExpenseSheet.<anonymous> (ExpensesScreen.kt:503)");
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
            ComposerKt.sourceInformationMarkerStart(composer2, -116677462, "C504@18224L1356,504@18170L1410,535@19593L11,537@19618L58,548@20209L10:ExpensesScreen.kt#fh874k");
            BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(14.0f), OxShape.INSTANCE.getCardSoft(), 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-5002510, true, new Function3() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ExpenseSheet$lambda$7$0$0;
                    ExpenseSheet$lambda$7$0$0 = ExpensesScreenKt.ExpenseSheet$lambda$7$0$0(Expense.this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ExpenseSheet$lambda$7$0$0;
                }
            }, composer2, 54), composer2, 1572912, 57);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(12.0f), composer2, 6);
            ExpenseRow(LangKt.tx("Дата", new Object[0]), Fmt.INSTANCE.dt(expense.getExpenseDate(), false), composer2, 0);
            String createdByName = expense.getCreatedByName();
            String str = null;
            if (createdByName == null || StringsKt.isBlank(createdByName)) {
                createdByName = null;
            }
            if (createdByName == null) {
                composer2.startReplaceGroup(-115182272);
            } else {
                composer2.startReplaceGroup(-115182271);
                ComposerKt.sourceInformation(composer2, "*538@19746L33");
                ExpenseRow(LangKt.tx("Кто записал", new Object[0]), createdByName, composer2, 0);
            }
            composer2.endReplaceGroup();
            String note = expense.getNote();
            if (note != null && !StringsKt.isBlank(note)) {
                str = note;
            }
            if (str == null) {
                composer2.startReplaceGroup(-115087164);
            } else {
                composer2.startReplaceGroup(-115087163);
                ComposerKt.sourceInformation(composer2, "*539@19842L29");
                ExpenseRow(LangKt.tx("Заметка", new Object[0]), str, composer2, 0);
            }
            composer2.endReplaceGroup();
            if (z && !z2 && !z3 && z4) {
                composer2.startReplaceGroup(-114956498);
                ComposerKt.sourceInformation(composer2, "542@19962L220");
                TextKt.m2798Text4IGK_g(LangKt.tx("День закрыт: изменить и отменить можно только расход за сегодня.", new Object[0]), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(10.0f), 0.0f, 0.0f, 13, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 48, 0, 65532);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-114731190);
                composer2.endReplaceGroup();
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer2, 6);
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
    public static final Unit ExpenseSheet$lambda$7$0$0(Expense expense, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C505@18242L1324:ExpensesScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-5002510, i, -1, "uz.FonRo.pos.ui.money.ExpenseSheet.<anonymous>.<anonymous>.<anonymous> (ExpensesScreen.kt:505)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -194069652, "C510@18483L449,520@18953L318,527@19292L256:ExpensesScreen.kt#fh874k");
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(52.0f)), OxShape.INSTANCE.getTile()), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10196getDanger0d7_KjU(), 0.12f), null, 2, null);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1262417351, "C515@18730L180:ExpensesScreen.kt#fh874k");
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getWallet(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(22.0f)), Ox.INSTANCE.m10196getDanger0d7_KjU(), composer, 432, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m2798Text4IGK_g(expense.getTitle(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 3, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH3(), 0L, TextUnitKt.getSp(15), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 0, 3120, 55292);
            TextKt.m2798Text4IGK_g("-" + Fmt.INSTANCE.nf(Double.valueOf(expense.getAmount())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10196getDanger0d7_KjU(), TextUnitKt.getSp(16), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer, 0, 0, 65534);
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
    public static final Unit ExpenseSheet$lambda$8$0(Expense expense, Function0 function0, Function0 function02, CoroutineScope coroutineScope, MutableState mutableState, Repo repo) {
        ExpenseSheet$cancel(expense, function0, function02, coroutineScope, mutableState, repo);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpenseSheet$lambda$9$0(MutableState mutableState) {
        ExpenseSheet$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    private static final void ExpenseRow(final String str, String str2, Composer composer, final int i) {
        int i2;
        final String str3;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(406293763);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExpenseRow)566@20667L889:ExpensesScreen.kt#fh874k");
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
                ComposerKt.traceEventStart(406293763, i2, -1, "uz.FonRo.pos.ui.money.ExpenseRow (ExpensesScreen.kt:565)");
            }
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(9.0f), 7, null), OxShape.INSTANCE.getTileSm()), Ox.INSTANCE.m10218getPanel20d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getTileSm()), Dp.m6989constructorimpl(15.0f), Dp.m6989constructorimpl(13.0f));
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(12.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, startRestartGroup, 54);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 115900964, "C577@21078L215,584@21302L248:ExpensesScreen.kt#fh874k");
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), TextUnitKt.getSp(13.5d), FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777208, null), composer2, i2 & 14, 0, 65532);
            TextStyle m6448copyp1EtxEg$default = TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowTitle(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6874getEnde0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744443, null);
            str3 = str2;
            TextKt.m2798Text4IGK_g(str3, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 3, 0, (Function1<? super TextLayoutResult, Unit>) null, m6448copyp1EtxEg$default, composer2, (i2 >> 3) & 14, 3120, 55292);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExpensesScreenKt.ExpenseRow$lambda$1(str, str3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ExpenseFormSheet(final FonRoApp FonRoApp, final Expense expense, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i) {
        int i2;
        Function0<Unit> function03;
        Composer composer2;
        MutableState mutableStateOf$default;
        Composer startRestartGroup = composer.startRestartGroup(630656058);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExpenseFormSheet)605@21857L24,608@21932L53,609@22004L51,610@22072L52,611@22140L34,612@22191L34,660@23944L411,671@24362L879,657@23809L1432:ExpensesScreen.kt#fh874k");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(FonRoApp) : startRestartGroup.changedInstance(FonRoApp) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(expense) : startRestartGroup.changedInstance(expense) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            function03 = function0;
            i2 |= startRestartGroup.changedInstance(function03) ? 256 : 128;
        } else {
            function03 = function0;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(630656058, i3, -1, "uz.FonRo.pos.ui.money.ExpenseFormSheet (ExpensesScreen.kt:603)");
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
            final boolean z = expense == null;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 470090575, "CC(remember):ExpensesScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                String title = expense != null ? expense.getTitle() : null;
                if (title == null) {
                    title = "";
                }
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(title, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 470092877, "CC(remember):ExpensesScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Double.valueOf(expense != null ? expense.getAmount() : AudioStats.AUDIO_AMPLITUDE_NONE), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 470095054, "CC(remember):ExpensesScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                String note = expense != null ? expense.getNote() : null;
                if (note == null) {
                    note = "";
                }
                mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(note, null, 2, null);
                startRestartGroup.updateRememberedValue(mutableStateOf$default);
                rememberedValue4 = mutableStateOf$default;
            }
            final MutableState mutableState3 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 470097212, "CC(remember):ExpensesScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 470098844, "CC(remember):ExpensesScreen.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final MutableState mutableState5 = (MutableState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Function0<Unit> function04 = function03;
            SheetsKt.OxCardSheet(z ? LangKt.tx("Новый расход", new Object[0]) : LangKt.tx("Изменить расход", new Object[0]), function0, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-1162525657, true, new Function3() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ExpensesScreenKt.ExpenseFormSheet$lambda$15(Function0.this, z, coroutineScope, expense, repo, function02, mutableState5, mutableState, mutableState2, mutableState3, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1105871970, true, new Function3() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ExpensesScreenKt.ExpenseFormSheet$lambda$16(MutableState.this, mutableState2, mutableState4, mutableState3, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i3 >> 3) & 112) | 14155776, 60);
            composer2 = startRestartGroup;
            if (ExpenseFormSheet$lambda$10(mutableState4)) {
                composer2.startReplaceGroup(1691207811);
                ComposerKt.sourceInformation(composer2, "702@25371L25,703@25422L15,699@25266L181");
                String tx = LangKt.tx("Сумма расхода", new Object[0]);
                double ExpenseFormSheet$lambda$4 = ExpenseFormSheet$lambda$4(mutableState2);
                ComposerKt.sourceInformationMarkerStart(composer2, 470200595, "CC(remember):ExpensesScreen.kt#9igjgp");
                Object rememberedValue7 = composer2.rememberedValue();
                if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue7 = new Function1() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit ExpenseFormSheet$lambda$17$0;
                            ExpenseFormSheet$lambda$17$0 = ExpensesScreenKt.ExpenseFormSheet$lambda$17$0(MutableState.this, ((Double) obj).doubleValue());
                            return ExpenseFormSheet$lambda$17$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue7);
                }
                Function1 function1 = (Function1) rememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, 470202217, "CC(remember):ExpensesScreen.kt#9igjgp");
                Object rememberedValue8 = composer2.rememberedValue();
                if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue8 = new Function0() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda23
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ExpenseFormSheet$lambda$18$0;
                            ExpenseFormSheet$lambda$18$0 = ExpensesScreenKt.ExpenseFormSheet$lambda$18$0(MutableState.this);
                            return ExpenseFormSheet$lambda$18$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                NumpadKt.NumpadSheet(tx, ExpenseFormSheet$lambda$4, function1, (Function0) rememberedValue8, false, composer2, 3456, 16);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(1691397128);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExpensesScreenKt.ExpenseFormSheet$lambda$19(FonRoApp.this, expense, function0, function02, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String ExpenseFormSheet$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double ExpenseFormSheet$lambda$4(MutableState<Double> mutableState) {
        return mutableState.getValue().doubleValue();
    }

    private static final void ExpenseFormSheet$lambda$5(MutableState<Double> mutableState, double d) {
        mutableState.setValue(Double.valueOf(d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ExpenseFormSheet$lambda$7(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean ExpenseFormSheet$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ExpenseFormSheet$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean ExpenseFormSheet$lambda$13(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ExpenseFormSheet$lambda$14(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void ExpenseFormSheet$save(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, MutableState<String> mutableState2, MutableState<Double> mutableState3, Expense expense, Repo repo, boolean z, Function0<Unit> function0, Function0<Unit> function02, MutableState<String> mutableState4) {
        if (ExpenseFormSheet$lambda$13(mutableState)) {
            return;
        }
        String obj = StringsKt.trim((CharSequence) ExpenseFormSheet$lambda$1(mutableState2)).toString();
        if (obj.length() == 0) {
            Toaster.INSTANCE.error(LangKt.tx("Введите название", new Object[0]));
        } else if (ExpenseFormSheet$lambda$4(mutableState3) <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            Toaster.INSTANCE.error(LangKt.tx("Укажите сумму", new Object[0]));
        } else {
            ExpenseFormSheet$lambda$14(mutableState, true);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ExpensesScreenKt$ExpenseFormSheet$save$1(obj, expense, repo, z, function0, function02, mutableState3, mutableState4, mutableState, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExpenseFormSheet$lambda$15(final Function0 function0, final boolean z, final CoroutineScope coroutineScope, final Expense expense, final Repo repo, final Function0 function02, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C661@23958L89,664@24161L10,662@24060L285:ExpensesScreen.kt#fh874k");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1162525657, i2, -1, "uz.FonRo.pos.ui.money.ExpenseFormSheet.<anonymous> (ExpensesScreen.kt:661)");
            }
            BasicsKt.OxButton(LangKt.tx("Отмена", new Object[0]), function0, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.GHOST, null, false, false, null, composer, 3072, 240);
            String tx = z ? LangKt.tx("Сохранить", new Object[0]) : LangKt.tx("Сохранить изменения", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -495652463, "CC(remember):ExpensesScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(expense) | composer.changedInstance(repo) | composer.changed(z) | composer.changed(function02) | composer.changed(function0);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                Function0 function03 = new Function0() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda38
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ExpenseFormSheet$lambda$15$0$0;
                        ExpenseFormSheet$lambda$15$0$0 = ExpensesScreenKt.ExpenseFormSheet$lambda$15$0$0(CoroutineScope.this, mutableState, mutableState2, mutableState3, expense, repo, z, function02, function0, mutableState4);
                        return ExpenseFormSheet$lambda$15$0$0;
                    }
                };
                composer.updateRememberedValue(function03);
                rememberedValue = function03;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.6f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, !ExpenseFormSheet$lambda$13(mutableState), false, null, composer, 27648, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpenseFormSheet$lambda$15$0$0(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, Expense expense, Repo repo, boolean z, Function0 function0, Function0 function02, MutableState mutableState4) {
        ExpenseFormSheet$save(coroutineScope, mutableState, mutableState2, mutableState3, expense, repo, z, function0, function02, mutableState4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExpenseFormSheet$lambda$16(final MutableState mutableState, MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, ColumnScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C672@24403L21,672@24372L863:ExpensesScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1105871970, i, -1, "uz.FonRo.pos.ui.money.ExpenseFormSheet.<anonymous> (ExpensesScreen.kt:672)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1461079883, "C676@24555L14,673@24441L192,682@24765L14,679@24646L147,684@24806L218,692@25147L13,689@25037L188:ExpensesScreen.kt#fh874k");
            String tx = LangKt.tx("Название *", new Object[0]);
            String ExpenseFormSheet$lambda$1 = ExpenseFormSheet$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, -1061244170, "CC(remember):ExpensesScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ExpenseFormSheet$lambda$16$0$0$0;
                        ExpenseFormSheet$lambda$16$0$0$0 = ExpensesScreenKt.ExpenseFormSheet$lambda$16$0$0$0(MutableState.this, (String) obj);
                        return ExpenseFormSheet$lambda$16$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9846OxFieldDfSPO0(tx, ExpenseFormSheet$lambda$1, (Function1) rememberedValue, null, LangKt.tx("напр. Аренда", new Object[0]), 0, 0, null, false, false, false, false, false, null, null, composer, 384, 0, 32744);
            String tx2 = LangKt.tx("Сумма:", new Object[0]);
            String nf = Fmt.INSTANCE.nf(Double.valueOf(ExpenseFormSheet$lambda$4(mutableState2)));
            ComposerKt.sourceInformationMarkerStart(composer, -1061237450, "CC(remember):ExpensesScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ExpenseFormSheet$lambda$16$0$1$0;
                        ExpenseFormSheet$lambda$16$0$1$0 = ExpensesScreenKt.ExpenseFormSheet$lambda$16$0$1$0(MutableState.this);
                        return ExpenseFormSheet$lambda$16$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9849OxValueButtonFHprtrg(tx2, nf, (Function0) rememberedValue2, null, 0L, null, composer, 384, 56);
            TextKt.m2798Text4IGK_g(LangKt.tx("Дата ставится автоматически: %s", Fmt.INSTANCE.dt(Fmt.INSTANCE.todayISO(), false)), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(10.0f), 0.0f, Dp.m6989constructorimpl(12.0f), 5, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 48, 0, 65532);
            String tx3 = LangKt.tx("Заметка", new Object[0]);
            String ExpenseFormSheet$lambda$7 = ExpenseFormSheet$lambda$7(mutableState4);
            ComposerKt.sourceInformationMarkerStart(composer, -1061225227, "CC(remember):ExpensesScreen.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: uz.FonRo.pos.ui.money.ExpensesScreenKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ExpenseFormSheet$lambda$16$0$2$0;
                        ExpenseFormSheet$lambda$16$0$2$0 = ExpensesScreenKt.ExpenseFormSheet$lambda$16$0$2$0(MutableState.this, (String) obj);
                        return ExpenseFormSheet$lambda$16$0$2$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9846OxFieldDfSPO0(tx3, ExpenseFormSheet$lambda$7, (Function1) rememberedValue3, null, LangKt.tx("необязательно", new Object[0]), 0, 0, null, false, false, false, false, false, null, null, composer, 384, 0, 32744);
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
    public static final Unit ExpenseFormSheet$lambda$16$0$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpenseFormSheet$lambda$16$0$1$0(MutableState mutableState) {
        ExpenseFormSheet$lambda$11(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpenseFormSheet$lambda$16$0$2$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpenseFormSheet$lambda$17$0(MutableState mutableState, double d) {
        ExpenseFormSheet$lambda$5(mutableState, Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, d));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpenseFormSheet$lambda$18$0(MutableState mutableState) {
        ExpenseFormSheet$lambda$11(mutableState, false);
        return Unit.INSTANCE;
    }
}
