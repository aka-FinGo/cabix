package uz.FonRo.pos.ui.more;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
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
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.data.local.CacheStore;
import uz.FonRo.pos.data.model.ActivityEntry;
import uz.FonRo.pos.data.model.Category;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.ChipTint;
import uz.FonRo.pos.ui.components.ChipsKt;
import uz.FonRo.pos.ui.components.PeriodPickersKt;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxDim;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: LogScreen.kt */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0006\u001a\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002\u001a\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0002\u001aG\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u001b\u001a'\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001eH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u001f\u001a\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\fH\u0002\u001a\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000eH\u0002\u001a(\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010&2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002\u001a\u0014\u0010'\u001a\u0004\u0018\u00010\u000e2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002\u001a,\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00152\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u0002²\u0006\u0010\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u008a\u0084\u0002²\u0006\n\u0010)\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\u0010\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015X\u008a\u008e\u0002²\u0006\n\u0010+\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\f\u0010,\u001a\u0004\u0018\u00010\u000eX\u008a\u008e\u0002²\u0006\n\u0010-\u001a\u00020\u0018X\u008a\u008e\u0002"}, d2 = {"LogScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "actionMeta", "Luz/FonRo/pos/ui/more/ActionMeta;", "action", "", "entityName", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "LogCard", "entry", "Luz/FonRo/pos/data/model/ActivityEntry;", CacheStore.CATEGORIES, "", "Luz/FonRo/pos/data/model/Category;", "canSeeCost", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Luz/FonRo/pos/data/model/ActivityEntry;Ljava/util/List;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DiffRow", "row", "Luz/FonRo/pos/ui/more/DiffLine;", "(Luz/FonRo/pos/ui/more/DiffLine;Landroidx/compose/runtime/Composer;I)V", "buildTitle", "meta", "fieldLabel", "field", "fieldValue", "value", "Lkotlinx/serialization/json/JsonElement;", "textOf", "buildDiff", "date", "entries", "loading", "error", "dayPicker"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class LogScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DiffRow$lambda$1(DiffLine diffLine, int i, Composer composer, int i2) {
        DiffRow(diffLine, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LogCard$lambda$3(ActivityEntry activityEntry, List list, boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        LogCard(activityEntry, list, z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LogScreen$lambda$21(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        LogScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void LogScreen(final FonRoApp app, final AppNavigator nav, Composer composer, final int i) {
        int i2;
        MutableState mutableState;
        final MutableState mutableState2;
        LogScreenKt$LogScreen$1$1 logScreenKt$LogScreen$1$1;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(nav, "nav");
        Composer startRestartGroup = composer.startRestartGroup(-1593130769);
        ComposerKt.sourceInformation(startRestartGroup, "C(LogScreen)66@2803L29,73@3091L27,74@3135L34,75@3189L61,76@3270L33,77@3321L42,79@3399L393,79@3369L423,98@4017L34,115@4569L1758,112@4417L1910:LogScreen.kt#1sifzz");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1593130769, i2, -1, "uz.FonRo.pos.ui.more.LogScreen (LogScreen.kt:64)");
            }
            Repo repo = app.getRepo();
            final State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(repo.getCategories(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            final boolean can = repo.can(Perm.MANAGE_SETTINGS);
            final boolean can2 = repo.can(Perm.VIEW_PURCHASE_PRICE);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1990298774, "CC(remember):LogScreen.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = Fmt.INSTANCE.todayISO();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final String str = (String) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1990297359, "CC(remember):LogScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState3 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1990295604, "CC(remember):LogScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1990293040, "CC(remember):LogScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState5 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1990291399, "CC(remember):LogScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            MutableState mutableState6 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            String LogScreen$lambda$3 = LogScreen$lambda$3(mutableState3);
            Boolean valueOf = Boolean.valueOf(can);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1990288552, "CC(remember):LogScreen.kt#9igjgp");
            boolean changed = startRestartGroup.changed(can);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState6;
                mutableState2 = mutableState3;
                logScreenKt$LogScreen$1$1 = new LogScreenKt$LogScreen$1$1(can, mutableState5, mutableState, mutableState3, mutableState4, null);
                startRestartGroup.updateRememberedValue(logScreenKt$LogScreen$1$1);
            } else {
                logScreenKt$LogScreen$1$1 = rememberedValue6;
                mutableState2 = mutableState3;
                mutableState = mutableState6;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(LogScreen$lambda$3, valueOf, (Function2) logScreenKt$LogScreen$1$1, startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1990269135, "CC(remember):LogScreen.kt#9igjgp");
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final MutableState mutableState7 = (MutableState) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (LogScreen$lambda$16(mutableState7)) {
                startRestartGroup.startReplaceGroup(-1568737024);
                ComposerKt.sourceInformation(startRestartGroup, "103@4153L21,104@4197L198,101@4082L323");
                String LogScreen$lambda$32 = LogScreen$lambda$3(mutableState2);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1990264796, "CC(remember):LogScreen.kt#9igjgp");
                Object rememberedValue8 = startRestartGroup.rememberedValue();
                if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue8 = new Function0() { // from class: uz.FonRo.pos.ui.more.LogScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit LogScreen$lambda$18$0;
                            LogScreen$lambda$18$0 = LogScreenKt.LogScreen$lambda$18$0(MutableState.this);
                            return LogScreen$lambda$18$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue8);
                }
                Function0 function0 = (Function0) rememberedValue8;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1990263211, "CC(remember):LogScreen.kt#9igjgp");
                Object rememberedValue9 = startRestartGroup.rememberedValue();
                if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue9 = new Function1() { // from class: uz.FonRo.pos.ui.more.LogScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit LogScreen$lambda$19$0;
                            LogScreen$lambda$19$0 = LogScreenKt.LogScreen$lambda$19$0(str, mutableState2, mutableState7, (String) obj);
                            return LogScreen$lambda$19$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue9);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                PeriodPickersKt.OxDayPickerDialog(LogScreen$lambda$32, function0, (Function1) rememberedValue9, startRestartGroup, 432);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1568411245);
                startRestartGroup.endReplaceGroup();
            }
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), OxDim.INSTANCE.m10245getPagePadD9Ej5fM(), 0.0f, 2, null);
            PaddingValues m1046PaddingValuesa9UjIt4$default = PaddingKt.m1046PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(28.0f), 7, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1990249747, "CC(remember):LogScreen.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(can) | startRestartGroup.changed(collectAsStateWithLifecycle) | startRestartGroup.changed(can2);
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                final MutableState mutableState8 = mutableState;
                final MutableState mutableState9 = mutableState2;
                Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.more.LogScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit LogScreen$lambda$20$0;
                        LogScreen$lambda$20$0 = LogScreenKt.LogScreen$lambda$20$0(can, str, mutableState9, mutableState7, mutableState5, mutableState4, mutableState8, can2, collectAsStateWithLifecycle, (LazyListScope) obj);
                        return LogScreen$lambda$20$0;
                    }
                };
                startRestartGroup.updateRememberedValue(function1);
                rememberedValue10 = function1;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LazyDslKt.LazyColumn(m1051paddingVpY3zN4$default, null, m1046PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) rememberedValue10, startRestartGroup, 384, TypedValues.PositionType.TYPE_PERCENT_X);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.more.LogScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LogScreenKt.LogScreen$lambda$21(FonRoApp.this, nav, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String LogScreen$lambda$3(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final List<ActivityEntry> LogScreen$lambda$6(MutableState<List<ActivityEntry>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LogScreen$lambda$10(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean LogScreen$lambda$9(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final String LogScreen$lambda$12(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean LogScreen$lambda$16(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void LogScreen$lambda$17(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LogScreen$lambda$18$0(MutableState mutableState) {
        LogScreen$lambda$17(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LogScreen$lambda$19$0(String str, MutableState mutableState, MutableState mutableState2, String picked) {
        Intrinsics.checkNotNullParameter(picked, "picked");
        if (picked.compareTo(str) <= 0) {
            str = picked;
        }
        mutableState.setValue(str);
        LogScreen$lambda$17(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LogScreen$lambda$20$0(boolean z, final String str, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final boolean z2, final State state, LazyListScope LazyColumn) {
        LazyListScope lazyListScope;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$LogScreenKt.INSTANCE.getLambda$32907972$app(), 3, null);
        if (!z) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$LogScreenKt.INSTANCE.getLambda$452403743$app(), 3, null);
            return Unit.INSTANCE;
        }
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-122355717, true, new Function3() { // from class: uz.FonRo.pos.ui.more.LogScreenKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit LogScreen$lambda$20$0$0;
                LogScreen$lambda$20$0$0 = LogScreenKt.LogScreen$lambda$20$0$0(str, mutableState, mutableState2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return LogScreen$lambda$20$0$0;
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(826134012, true, new Function3() { // from class: uz.FonRo.pos.ui.more.LogScreenKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit LogScreen$lambda$20$0$1;
                LogScreen$lambda$20$0$1 = LogScreenKt.LogScreen$lambda$20$0$1(str, mutableState, mutableState3, mutableState4, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return LogScreen$lambda$20$0$1;
            }
        }), 3, null);
        if (LogScreen$lambda$9(mutableState3)) {
            lazyListScope = LazyColumn;
            LazyListScope.item$default(lazyListScope, null, null, ComposableSingletons$LogScreenKt.INSTANCE.m10019getLambda$1290497348$app(), 3, null);
        } else if (LogScreen$lambda$12(mutableState5) != null) {
            lazyListScope = LazyColumn;
            LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-1639858139, true, new Function3() { // from class: uz.FonRo.pos.ui.more.LogScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit LogScreen$lambda$20$0$2;
                    LogScreen$lambda$20$0$2 = LogScreenKt.LogScreen$lambda$20$0$2(MutableState.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return LogScreen$lambda$20$0$2;
                }
            }), 3, null);
        } else if (LogScreen$lambda$6(mutableState4).isEmpty()) {
            lazyListScope = LazyColumn;
            LazyListScope.item$default(lazyListScope, null, null, ComposableSingletons$LogScreenKt.INSTANCE.getLambda$46041796$app(), 3, null);
        } else {
            lazyListScope = LazyColumn;
        }
        if (!LogScreen$lambda$9(mutableState3) && LogScreen$lambda$12(mutableState5) == null) {
            final List<ActivityEntry> LogScreen$lambda$6 = LogScreen$lambda$6(mutableState4);
            final Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.more.LogScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object LogScreen$lambda$20$0$3;
                    LogScreen$lambda$20$0$3 = LogScreenKt.LogScreen$lambda$20$0$3((ActivityEntry) obj);
                    return LogScreen$lambda$20$0$3;
                }
            };
            final LogScreenKt$LogScreen$lambda$20$0$$inlined$items$default$1 logScreenKt$LogScreen$lambda$20$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.more.LogScreenKt$LogScreen$lambda$20$0$$inlined$items$default$1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(ActivityEntry activityEntry) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((ActivityEntry) obj);
                }
            };
            lazyListScope.items(LogScreen$lambda$6.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.more.LogScreenKt$LogScreen$lambda$20$0$$inlined$items$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i) {
                    return Function1.this.invoke(LogScreen$lambda$6.get(i));
                }
            }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.more.LogScreenKt$LogScreen$lambda$20$0$$inlined$items$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i) {
                    return Function1.this.invoke(LogScreen$lambda$6.get(i));
                }
            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.more.LogScreenKt$LogScreen$lambda$20$0$$inlined$items$default$4
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
                    List LogScreen$lambda$0;
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
                    ActivityEntry activityEntry = (ActivityEntry) LogScreen$lambda$6.get(i);
                    composer.startReplaceGroup(930402202);
                    ComposerKt.sourceInformation(composer, "C*163@6083L214:LogScreen.kt#1sifzz");
                    LogScreen$lambda$0 = LogScreenKt.LogScreen$lambda$0(state);
                    LogScreenKt.LogCard(activityEntry, LogScreen$lambda$0, z2, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(8.0f), 7, null), composer, ActivityEntry.$stable | 3072, 0);
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
    public static final Unit LogScreen$lambda$20$0$0(final String str, final MutableState mutableState, final MutableState mutableState2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C131@4981L473,131@4971L483:LogScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-122355717, i, -1, "uz.FonRo.pos.ui.more.LogScreen.<anonymous>.<anonymous>.<anonymous> (LogScreen.kt:131)");
            }
            ChipsKt.OxChipRow(null, ComposableLambdaKt.rememberComposableLambda(-850865140, true, new Function3() { // from class: uz.FonRo.pos.ui.more.LogScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit LogScreen$lambda$20$0$0$0;
                    LogScreen$lambda$20$0$0$0 = LogScreenKt.LogScreen$lambda$20$0$0$0(str, mutableState, mutableState2, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return LogScreen$lambda$20$0$0$0;
                }
            }, composer, 54), composer, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LogScreen$lambda$20$0$0$0(final String str, final MutableState mutableState, final MutableState mutableState2, RowScope OxChipRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxChipRow, "$this$OxChipRow");
        ComposerKt.sourceInformation(composer, "C136@5168L16,132@4999L203,142@5402L20,138@5219L221:LogScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-850865140, i, -1, "uz.FonRo.pos.ui.more.LogScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LogScreen.kt:132)");
            }
            String tx = LangKt.tx("Сегодня", new Object[0]);
            boolean areEqual = Intrinsics.areEqual(LogScreen$lambda$3(mutableState), str);
            ChipTint chipTint = ChipTint.CYAN;
            ComposerKt.sourceInformationMarkerStart(composer, -1637607300, "CC(remember):LogScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.more.LogScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit LogScreen$lambda$20$0$0$0$0$0;
                        LogScreen$lambda$20$0$0$0$0$0 = LogScreenKt.LogScreen$lambda$20$0$0$0$0$0(str, mutableState);
                        return LogScreen$lambda$20$0$0$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.m9837OxCatChipFV1VA1c(tx, areEqual, (Function0) rememberedValue, null, chipTint, null, composer, 24960, 40);
            String str2 = "🗓 " + Fmt.INSTANCE.dt(LogScreen$lambda$3(mutableState), false);
            boolean z = !Intrinsics.areEqual(LogScreen$lambda$3(mutableState), str);
            ChipTint chipTint2 = ChipTint.CYAN;
            ComposerKt.sourceInformationMarkerStart(composer, -1637599808, "CC(remember):LogScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.more.LogScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit LogScreen$lambda$20$0$0$0$1$0;
                        LogScreen$lambda$20$0$0$0$1$0 = LogScreenKt.LogScreen$lambda$20$0$0$0$1$0(MutableState.this);
                        return LogScreen$lambda$20$0$0$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.m9837OxCatChipFV1VA1c(str2, z, (Function0) rememberedValue2, null, chipTint2, null, composer, 24960, 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LogScreen$lambda$20$0$0$0$0$0(String str, MutableState mutableState) {
        mutableState.setValue(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LogScreen$lambda$20$0$0$0$1$0(MutableState mutableState) {
        LogScreen$lambda$17(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LogScreen$lambda$20$0$1(String str, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C148@5493L224:LogScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(826134012, i, -1, "uz.FonRo.pos.ui.more.LogScreen.<anonymous>.<anonymous>.<anonymous> (LogScreen.kt:148)");
            }
            BasicsKt.OxSectionHead(LangKt.tx("Действия", new Object[0]), null, Intrinsics.areEqual(LogScreen$lambda$3(mutableState), str) ? LangKt.tx("сегодня", new Object[0]) : Fmt.INSTANCE.dt(LogScreen$lambda$3(mutableState), false), LogScreen$lambda$9(mutableState2) ? "…" : String.valueOf(LogScreen$lambda$6(mutableState3).size()), null, null, composer, 0, 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LogScreen$lambda$20$0$2(MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C157@5842L28:LogScreen.kt#1sifzz");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1639858139, i, -1, "uz.FonRo.pos.ui.more.LogScreen.<anonymous>.<anonymous>.<anonymous> (LogScreen.kt:157)");
            }
            String LogScreen$lambda$12 = LogScreen$lambda$12(mutableState);
            if (LogScreen$lambda$12 == null) {
                LogScreen$lambda$12 = "";
            }
            BasicsKt.OxEmptyNote(LogScreen$lambda$12, null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object LogScreen$lambda$20$0$3(ActivityEntry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getId());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0062, code lost:
    
        return new uz.FonRo.pos.ui.more.ActionMeta(uz.FonRo.pos.core.LangKt.tx("Удалён", new java.lang.Object[0]), "🗑", uz.FonRo.pos.ui.theme.Ox.INSTANCE.m10196getDanger0d7_KjU(), null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        if (r8.equals("delete") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
    
        if (r8.equals("archive") == false) goto L28;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0016. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final uz.FonRo.pos.ui.more.ActionMeta actionMeta(java.lang.String r8) {
        /*
            if (r8 == 0) goto Le
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r8 = r8.toLowerCase(r0)
            java.lang.String r0 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            goto Lf
        Le:
            r8 = 0
        Lf:
            r0 = 0
            if (r8 == 0) goto L83
            int r1 = r8.hashCode()
            switch(r1) {
                case -1352294148: goto L63;
                case -1335458389: goto L43;
                case -838846263: goto L23;
                case -748101438: goto L1a;
                default: goto L19;
            }
        L19:
            goto L83
        L1a:
            java.lang.String r1 = "archive"
            boolean r8 = r8.equals(r1)
            if (r8 != 0) goto L4c
            goto L83
        L23:
            java.lang.String r1 = "update"
            boolean r8 = r8.equals(r1)
            if (r8 != 0) goto L2c
            goto L83
        L2c:
            uz.FonRo.pos.ui.more.ActionMeta r1 = new uz.FonRo.pos.ui.more.ActionMeta
            java.lang.String r8 = "Изменён"
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = uz.FonRo.pos.core.LangKt.tx(r8, r0)
            uz.FonRo.pos.ui.theme.Ox r8 = uz.FonRo.pos.ui.theme.Ox.INSTANCE
            long r4 = r8.m10220getPrimary0d7_KjU()
            r6 = 0
            java.lang.String r3 = "✏️"
            r1.<init>(r2, r3, r4, r6)
            return r1
        L43:
            java.lang.String r1 = "delete"
            boolean r8 = r8.equals(r1)
            if (r8 != 0) goto L4c
            goto L83
        L4c:
            uz.FonRo.pos.ui.more.ActionMeta r1 = new uz.FonRo.pos.ui.more.ActionMeta
            java.lang.String r8 = "Удалён"
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = uz.FonRo.pos.core.LangKt.tx(r8, r0)
            uz.FonRo.pos.ui.theme.Ox r8 = uz.FonRo.pos.ui.theme.Ox.INSTANCE
            long r4 = r8.m10196getDanger0d7_KjU()
            r6 = 0
            java.lang.String r3 = "🗑"
            r1.<init>(r2, r3, r4, r6)
            return r1
        L63:
            java.lang.String r1 = "create"
            boolean r8 = r8.equals(r1)
            if (r8 != 0) goto L6c
            goto L83
        L6c:
            uz.FonRo.pos.ui.more.ActionMeta r1 = new uz.FonRo.pos.ui.more.ActionMeta
            java.lang.String r8 = "Создан"
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = uz.FonRo.pos.core.LangKt.tx(r8, r0)
            uz.FonRo.pos.ui.theme.Ox r8 = uz.FonRo.pos.ui.theme.Ox.INSTANCE
            long r4 = r8.m10211getOk0d7_KjU()
            r6 = 0
            java.lang.String r3 = "➕"
            r1.<init>(r2, r3, r4, r6)
            return r1
        L83:
            uz.FonRo.pos.ui.more.ActionMeta r2 = new uz.FonRo.pos.ui.more.ActionMeta
            java.lang.String r8 = "Действие"
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r3 = uz.FonRo.pos.core.LangKt.tx(r8, r0)
            uz.FonRo.pos.ui.theme.Ox r8 = uz.FonRo.pos.ui.theme.Ox.INSTANCE
            long r5 = r8.m10199getDim0d7_KjU()
            r7 = 0
            java.lang.String r4 = "•"
            r2.<init>(r3, r4, r5, r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.more.LogScreenKt.actionMeta(java.lang.String):uz.FonRo.pos.ui.more.ActionMeta");
    }

    private static final String entityName(String str) {
        String str2;
        if (str != null) {
            str2 = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str2, "toLowerCase(...)");
        } else {
            str2 = null;
        }
        if (str2 != null) {
            switch (str2.hashCode()) {
                case -1309357992:
                    if (str2.equals("expense")) {
                        return LangKt.tx("расход", new Object[0]);
                    }
                    break;
                case -795527995:
                    if (str2.equals("shop_order")) {
                        return LangKt.tx("заказ", new Object[0]);
                    }
                    break;
                case -782085250:
                    if (str2.equals("worker")) {
                        return LangKt.tx("сотрудник", new Object[0]);
                    }
                    break;
                case -373268031:
                    if (str2.equals("store_settings")) {
                        return LangKt.tx("настройки", new Object[0]);
                    }
                    break;
                case -309474065:
                    if (str2.equals("product")) {
                        return LangKt.tx("товар", new Object[0]);
                    }
                    break;
                case 50511102:
                    if (str2.equals("category")) {
                        return LangKt.tx("категория", new Object[0]);
                    }
                    break;
                case 606175198:
                    if (str2.equals("customer")) {
                        return LangKt.tx("клиент", new Object[0]);
                    }
                    break;
                case 921602380:
                    if (str2.equals("store_info")) {
                        return LangKt.tx("магазин", new Object[0]);
                    }
                    break;
                case 921898825:
                    if (str2.equals("store_slug")) {
                        return LangKt.tx("витрину", new Object[0]);
                    }
                    break;
                case 1703484142:
                    if (str2.equals("stock_in")) {
                        return LangKt.tx("приход", new Object[0]);
                    }
                    break;
            }
        }
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b7, code lost:
    
        if (r8 == null) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LogCard(final uz.FonRo.pos.data.model.ActivityEntry r16, final java.util.List<uz.FonRo.pos.data.model.Category> r17, boolean r18, androidx.compose.ui.Modifier r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.more.LogScreenKt.LogCard(uz.FonRo.pos.data.model.ActivityEntry, java.util.List, boolean, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x064f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0640  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit LogCard$lambda$2(java.util.List r49, uz.FonRo.pos.ui.more.ActionMeta r50, uz.FonRo.pos.data.model.ActivityEntry r51, java.lang.String r52, androidx.compose.foundation.layout.ColumnScope r53, androidx.compose.runtime.Composer r54, int r55) {
        /*
            Method dump skipped, instructions count: 1625
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.more.LogScreenKt.LogCard$lambda$2(java.util.List, uz.FonRo.pos.ui.more.ActionMeta, uz.FonRo.pos.data.model.ActivityEntry, java.lang.String, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    private static final void DiffRow(final DiffLine diffLine, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(984263149);
        ComposerKt.sourceInformation(startRestartGroup, "C(DiffRow)269@9722L860:LogScreen.kt#1sifzz");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(diffLine) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(984263149, i2, -1, "uz.FonRo.pos.ui.more.DiffRow (LogScreen.kt:268)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(7.0f));
            Alignment.Vertical top = Alignment.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, top, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1830289411, "C274@9889L73,285@10326L250:LogScreen.kt#1sifzz");
            TextKt.m2798Text4IGK_g(diffLine.getLabel(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 0.9f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), startRestartGroup, 0, 0, 65532);
            Composer composer3 = startRestartGroup;
            if (diffLine.getBefore() != null) {
                composer3.startReplaceGroup(1830383247);
                ComposerKt.sourceInformation(composer3, "276@10009L233,283@10255L52");
                TextKt.m2798Text4IGK_g(diffLine.getBefore(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getChip(), Ox.INSTANCE.m10200getDim20d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer3, 0, 3120, 55292);
                TextKt.m2798Text4IGK_g("→", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getChip(), Ox.INSTANCE.m10200getDim20d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer3, 6, 0, 65534);
                composer3 = composer3;
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(1830692689);
                composer3.endReplaceGroup();
            }
            String after = diffLine.getAfter();
            if (after == null) {
                after = "—";
            }
            composer2 = composer3;
            TextKt.m2798Text4IGK_g(after, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getChip(), diffLine.getBefore() != null ? Ox.INSTANCE.m10211getOk0d7_KjU() : Ox.INSTANCE.m10233getText0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer2, 0, 3120, 55292);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.more.LogScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LogScreenKt.DiffRow$lambda$1(DiffLine.this, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String buildTitle(ActivityEntry activityEntry, ActionMeta actionMeta) {
        String str;
        String str2;
        Object obj;
        JsonObject after = activityEntry.getAfter();
        String str3 = null;
        if (after != null) {
            str = textOf((JsonElement) after.get("name"));
            if (str == null) {
                str = textOf((JsonElement) after.get("title"));
            }
        } else {
            str = null;
        }
        JsonObject before = activityEntry.getBefore();
        if (before != null) {
            str2 = textOf((JsonElement) before.get("name"));
            if (str2 == null) {
                str2 = textOf((JsonElement) before.get("title"));
            }
        } else {
            str2 = null;
        }
        Iterator it = CollectionsKt.listOfNotNull((Object[]) new String[]{str, str2}).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!StringsKt.isBlank((String) obj)) {
                break;
            }
        }
        String str4 = (String) obj;
        if (str4 == null) {
            Long valueOf = Long.valueOf(activityEntry.getEntityId());
            if (valueOf.longValue() <= 0) {
                valueOf = null;
            }
            if (valueOf != null) {
                str3 = "#" + valueOf.longValue();
            }
        } else {
            str3 = str4;
        }
        String entityName = entityName(activityEntry.getEntityType());
        StringBuilder sb = new StringBuilder();
        sb.append(actionMeta.getTitle());
        if (!StringsKt.isBlank(entityName)) {
            sb.append(' ');
            sb.append(entityName);
        }
        String str5 = str3;
        if (str5 != null && !StringsKt.isBlank(str5)) {
            sb.append(" «");
            sb.append(str3);
            sb.append((char) 187);
        }
        return sb.toString();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
    private static final String fieldLabel(String str) {
        switch (str.hashCode()) {
            case -1677176261:
                return !str.equals("full_name") ? str : LangKt.tx("Имя", new Object[0]);
            case -1422950650:
                if (!str.equals(AppMeasurementSdk.ConditionalUserProperty.ACTIVE)) {
                    return str;
                }
                return LangKt.tx("Статус", new Object[0]);
            case -1413853096:
                return !str.equals("amount") ? str : LangKt.tx("Сумма", new Object[0]);
            case -1285004149:
                return !str.equals(FirebaseAnalytics.Param.QUANTITY) ? str : LangKt.tx("Остаток", new Object[0]);
            case -1147692044:
                return !str.equals("address") ? str : LangKt.tx("Адрес", new Object[0]);
            case -958911557:
                if (!str.equals("is_active")) {
                    return str;
                }
                return LangKt.tx("Статус", new Object[0]);
            case -333584256:
                return !str.equals(OptionalModuleUtils.BARCODE) ? str : LangKt.tx("Штрихкод", new Object[0]);
            case 113949:
                return !str.equals("sku") ? str : LangKt.tx("Артикул", new Object[0]);
            case 3373707:
                if (!str.equals("name")) {
                    return str;
                }
                return LangKt.tx("Название", new Object[0]);
            case 3387378:
                return !str.equals("note") ? str : LangKt.tx("Заметка", new Object[0]);
            case 3506294:
                return !str.equals("role") ? str : LangKt.tx("Роль", new Object[0]);
            case 3594628:
                return !str.equals("unit") ? str : LangKt.tx("Единица", new Object[0]);
            case 94851343:
                return !str.equals("count") ? str : LangKt.tx("Позиций", new Object[0]);
            case 106642798:
                return !str.equals(HintConstants.AUTOFILL_HINT_PHONE) ? str : LangKt.tx("Телефон", new Object[0]);
            case 110371416:
                if (!str.equals("title")) {
                    return str;
                }
                return LangKt.tx("Название", new Object[0]);
            case 110549828:
                return !str.equals("total") ? str : LangKt.tx("Сумма", new Object[0]);
            case 1161577297:
                return !str.equals("sale_price") ? str : LangKt.tx("Цена", new Object[0]);
            case 1264342837:
                return !str.equals("expense_date") ? str : LangKt.tx("Дата", new Object[0]);
            case 1537780732:
                return !str.equals("category_id") ? str : LangKt.tx("Категория", new Object[0]);
            case 1907594379:
                return !str.equals("purchase_price") ? str : LangKt.tx("Закуп", new Object[0]);
            default:
                return str;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r5.equals("purchase_price") == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00cd, code lost:
    
        return uz.FonRo.pos.core.Fmt.INSTANCE.nf(kotlin.text.StringsKt.toDoubleOrNull(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008f, code lost:
    
        if (r5.equals("sale_price") == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0099, code lost:
    
        if (r5.equals("total") == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a3, code lost:
    
        if (r5.equals("is_active") == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d7, code lost:
    
        r5 = kotlin.text.StringsKt.toDoubleOrNull(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00db, code lost:
    
        if (r5 == null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e8, code lost:
    
        if (r5.doubleValue() != androidx.camera.video.AudioStats.AUDIO_AMPLITUDE_NONE) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ea, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ed, code lost:
    
        if (r6 != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ef, code lost:
    
        r1 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ec, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f0, code lost:
    
        if (r1 == null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00fa, code lost:
    
        return uz.FonRo.pos.core.LangKt.tx("активен", new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0103, code lost:
    
        return uz.FonRo.pos.core.LangKt.tx("отключён", new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c0, code lost:
    
        if (r5.equals("amount") == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d4, code lost:
    
        if (r5.equals(com.google.android.gms.measurement.api.AppMeasurementSdk.ConditionalUserProperty.ACTIVE) == false) goto L76;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0022. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.lang.String fieldValue(java.lang.String r5, kotlinx.serialization.json.JsonElement r6, java.util.List<uz.FonRo.pos.data.model.Category> r7) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.more.LogScreenKt.fieldValue(java.lang.String, kotlinx.serialization.json.JsonElement, java.util.List):java.lang.String");
    }

    private static final String textOf(JsonElement jsonElement) {
        if (jsonElement == null || (jsonElement instanceof JsonNull)) {
            return null;
        }
        if (!(jsonElement instanceof JsonPrimitive)) {
            return jsonElement.toString();
        }
        String content = ((JsonPrimitive) jsonElement).getContent();
        if (StringsKt.isBlank(content) || Intrinsics.areEqual(content, AbstractJsonLexerKt.NULL)) {
            return null;
        }
        return content;
    }

    private static final List<DiffLine> buildDiff(ActivityEntry activityEntry, List<Category> list, boolean z) {
        Set<String> keySet;
        Set<String> keySet2;
        JsonObject before = activityEntry.getBefore();
        JsonObject after = activityEntry.getAfter();
        if (before == null && after == null) {
            return CollectionsKt.emptyList();
        }
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        if (before != null && (keySet2 = before.keySet()) != null) {
            linkedHashSet.addAll(keySet2);
        }
        if (after != null && (keySet = after.keySet()) != null) {
            linkedHashSet.addAll(keySet);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : linkedHashSet) {
            DiffLine diffLine = null;
            if (!Intrinsics.areEqual(str, "purchase_price") || z) {
                String fieldValue = before != null ? fieldValue(str, (JsonElement) before.get((Object) str), list) : null;
                String fieldValue2 = after != null ? fieldValue(str, (JsonElement) after.get((Object) str), list) : null;
                if (before != null && after != null) {
                    if (!Intrinsics.areEqual(fieldValue, fieldValue2)) {
                        diffLine = new DiffLine(fieldLabel(str), fieldValue, fieldValue2);
                    }
                } else if (!Intrinsics.areEqual(str, "name") && !Intrinsics.areEqual(str, "title")) {
                    if (after != null) {
                        diffLine = new DiffLine(fieldLabel(str), null, fieldValue2);
                    } else {
                        diffLine = new DiffLine(fieldLabel(str), null, fieldValue);
                    }
                }
            }
            if (diffLine != null) {
                arrayList.add(diffLine);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Category> LogScreen$lambda$0(State<? extends List<Category>> state) {
        return state.getValue();
    }
}
