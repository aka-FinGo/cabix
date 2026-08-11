package uz.FonRo.pos.ui.team;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import androidx.autofill.HintConstants;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
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
import androidx.compose.material3.SwitchKt;
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
import androidx.compose.ui.graphics.vector.ImageVector;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
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
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.data.model.User;
import uz.FonRo.pos.data.model.Worker;
import uz.FonRo.pos.data.model.WorkerDevice;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnSize;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.FieldsKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxDim;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: TeamScreen.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0006\u001a?\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0012\u001a;\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\b\u0019\u0010\u001a\u001a9\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\b\"\u0010#\u001ai\u0010$\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\u0014\u0010(\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00010)H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010*\u001a7\u0010+\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\u0006\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u001dH\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010.\u001aM\u0010/\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\u0014\u00100\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00010)H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u00101\u001a\u0010\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u001dH\u0000¨\u0006\u0002²\u0006\u0010\u00104\u001a\b\u0012\u0004\u0012\u00020\r05X\u008a\u008e\u0002²\u0006\n\u00106\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u00107\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\f\u00108\u001a\u0004\u0018\u00010\rX\u008a\u008e\u0002²\u0006\n\u00109\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\f\u0010:\u001a\u0004\u0018\u00010\rX\u008a\u008e\u0002²\u0006\u0010\u0010;\u001a\b\u0012\u0004\u0012\u00020<05X\u008a\u008e\u0002²\u0006\n\u0010=\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010>\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\f\u0010?\u001a\u0004\u0018\u00010<X\u008a\u008e\u0002²\u0006\n\u0010@\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\f\u0010A\u001a\u0004\u0018\u00010BX\u008a\u0084\u0002²\u0006\n\u0010C\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010D\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u0010E\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010@\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\u0016\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020H0GX\u008a\u008e\u0002"}, d2 = {"TeamScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "WorkerRow", "worker", "Luz/FonRo/pos/data/model/Worker;", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Luz/FonRo/pos/data/model/Worker;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "WorkerAvatar", "isOwner", "", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "size", "Landroidx/compose/ui/unit/Dp;", "WorkerAvatar-6a0pyJM", "(ZZFLandroidx/compose/runtime/Composer;II)V", "WorkerBadge", "text", "", "tint", "Landroidx/compose/ui/graphics/Color;", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "WorkerBadge-iJQMabo", "(Ljava/lang/String;JLandroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;I)V", "WorkerCardSheet", "canManage", "onDismiss", "onEdit", "onWorkerChanged", "Lkotlin/Function1;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/data/model/Worker;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "WorkerInfoRow", "label", "value", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "WorkerFormSheet", "onSaved", "(Luz/FonRo/pos/data/model/Worker;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "formatAccessKey", "key", "workers", "", "loading", "failed", "cardWorker", "formOpen", "formWorker", "devices", "Luz/FonRo/pos/data/model/WorkerDevice;", "devicesLoading", "confirmRegenerate", "confirmRevoke", "busy", "viewer", "Luz/FonRo/pos/data/model/User;", "selfAccessOpen", "name", HintConstants.AUTOFILL_HINT_PHONE, "perms", "", ""}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class TeamScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TeamScreen$lambda$28(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        TeamScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WorkerAvatar_6a0pyJM$lambda$1(boolean z, boolean z2, float f, int i, int i2, Composer composer, int i3) {
        m10181WorkerAvatar6a0pyJM(z, z2, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WorkerBadge_iJQMabo$lambda$1(String str, long j, ImageVector imageVector, int i, Composer composer, int i2) {
        m10182WorkerBadgeiJQMabo(str, j, imageVector, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WorkerCardSheet$lambda$30(FonRoApp FonRoApp, Worker worker, boolean z, Function0 function0, Function0 function02, Function1 function1, int i, Composer composer, int i2) {
        WorkerCardSheet(FonRoApp, worker, z, function0, function02, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WorkerFormSheet$lambda$18(Worker worker, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        WorkerFormSheet(worker, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WorkerInfoRow$lambda$1(ImageVector imageVector, String str, String str2, int i, Composer composer, int i2) {
        WorkerInfoRow(imageVector, str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WorkerRow$lambda$3(Worker worker, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        WorkerRow(worker, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void TeamScreen(FonRoApp FonRoApp, final AppNavigator nav, Composer composer, final int i) {
        Composer composer2;
        MutableState mutableState;
        MutableState mutableState2;
        MutableState mutableState3;
        final MutableState mutableState4;
        Object obj;
        final MutableState mutableState5;
        boolean z;
        MutableState mutableState6;
        MutableState mutableState7;
        final MutableState mutableState8;
        Object obj2;
        final MutableState mutableState9;
        final MutableState mutableState10;
        final MutableState mutableState11;
        Composer composer3;
        final MutableState mutableState12;
        MutableState mutableState13;
        Worker worker;
        final CoroutineScope coroutineScope;
        MutableState mutableState14;
        String str;
        MutableState mutableState15;
        final MutableState mutableState16;
        final FonRoApp app = FonRoApp;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(nav, "nav");
        Composer startRestartGroup = composer.startRestartGroup(1252363977);
        ComposerKt.sourceInformation(startRestartGroup, "C(TeamScreen)95@4064L24,98@4157L54,99@4231L33,100@4283L34,105@4578L42,106@4641L34,107@4698L42,122@5252L10,122@5231L31,125@5336L193,136@5752L1943,133@5600L2095:TeamScreen.kt#1se6wn");
        int i2 = (i & 6) == 0 ? ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2) | i : i;
        int i3 = 1;
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1252363977, i2, -1, "uz.FonRo.pos.ui.team.TeamScreen (TeamScreen.kt:93)");
            }
            Repo repo = app.getRepo();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)558@25470L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -954203484, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final boolean can = repo.can(Perm.MANAGE_USERS);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 930944991, "CC(remember):TeamScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState17 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 930947338, "CC(remember):TeamScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            MutableState mutableState18 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 930949003, "CC(remember):TeamScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            MutableState mutableState19 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 930958451, "CC(remember):TeamScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState20 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 930960459, "CC(remember):TeamScreen.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            MutableState mutableState21 = (MutableState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 930962291, "CC(remember):TeamScreen.kt#9igjgp");
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            MutableState mutableState22 = (MutableState) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 930979987, "CC(remember):TeamScreen.kt#9igjgp");
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                Object teamScreenKt$TeamScreen$1$1 = new TeamScreenKt$TeamScreen$1$1(mutableState18, mutableState17, mutableState19, mutableState20, null);
                mutableState2 = mutableState18;
                mutableState = mutableState17;
                mutableState3 = mutableState19;
                rememberedValue8 = (Function2) teamScreenKt$TeamScreen$1$1;
                startRestartGroup.updateRememberedValue(rememberedValue8);
            } else {
                mutableState = mutableState17;
                mutableState2 = mutableState18;
                mutableState3 = mutableState19;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue8, startRestartGroup, 6);
            Object TeamScreen$lambda$1 = TeamScreen$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 930982858, "CC(remember):TeamScreen.kt#9igjgp");
            boolean changed = startRestartGroup.changed(TeamScreen$lambda$1);
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                List<Worker> TeamScreen$lambda$12 = TeamScreen$lambda$1(mutableState);
                final Comparator comparator = new Comparator() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$TeamScreen$lambda$22$$inlined$compareBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(StringsKt.equals(((Worker) t).getRole(), "owner", true) ? (Comparable) 0 : (Comparable) 1, StringsKt.equals(((Worker) t2).getRole(), "owner", true) ? (Comparable) 0 : (Comparable) 1);
                    }
                };
                rememberedValue9 = CollectionsKt.sortedWith(TeamScreen$lambda$12, new Comparator() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$TeamScreen$lambda$22$$inlined$thenBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int compare = comparator.compare(t, t2);
                        if (compare != 0) {
                            return compare;
                        }
                        String lowerCase = ((Worker) t).getFullName().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        String lowerCase2 = ((Worker) t2).getFullName().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            final List list = (List) rememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ArrayList arrayList = new ArrayList();
            for (Object obj3 : list) {
                MutableState mutableState23 = mutableState21;
                int i4 = i2;
                if (!StringsKt.equals(((Worker) obj3).getRole(), "owner", true)) {
                    arrayList.add(obj3);
                }
                i3 = 1;
                mutableState21 = mutableState23;
                i2 = i4;
            }
            MutableState mutableState24 = mutableState21;
            int i5 = i2;
            final ArrayList arrayList2 = arrayList;
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, i3, null), OxDim.INSTANCE.m10245getPagePadD9Ej5fM(), 0.0f, 2, null);
            PaddingValues m1046PaddingValuesa9UjIt4$default = PaddingKt.m1046PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(28.0f), 7, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 930997920, "CC(remember):TeamScreen.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(can) | startRestartGroup.changedInstance(arrayList2) | startRestartGroup.changedInstance(list);
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                final MutableState mutableState25 = mutableState3;
                mutableState4 = mutableState24;
                final MutableState mutableState26 = mutableState2;
                mutableState5 = mutableState22;
                obj = new Function1() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        Unit TeamScreen$lambda$24$0;
                        TeamScreen$lambda$24$0 = TeamScreenKt.TeamScreen$lambda$24$0(can, list, mutableState5, mutableState4, arrayList2, mutableState26, mutableState25, mutableState20, (LazyListScope) obj4);
                        return TeamScreen$lambda$24$0;
                    }
                };
                z = can;
                mutableState6 = mutableState26;
                mutableState7 = mutableState25;
                mutableState8 = mutableState20;
                startRestartGroup.updateRememberedValue(obj);
            } else {
                obj = rememberedValue10;
                mutableState5 = mutableState22;
                z = can;
                mutableState6 = mutableState2;
                mutableState7 = mutableState3;
                mutableState4 = mutableState24;
                mutableState8 = mutableState20;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final MutableState mutableState27 = mutableState5;
            final MutableState mutableState28 = mutableState4;
            LazyDslKt.LazyColumn(m1051paddingVpY3zN4$default, null, m1046PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) obj, startRestartGroup, 384, TypedValues.PositionType.TYPE_PERCENT_X);
            final Worker TeamScreen$lambda$10 = TeamScreen$lambda$10(mutableState8);
            if (TeamScreen$lambda$10 != null) {
                startRestartGroup.startReplaceGroup(-1201937823);
                ComposerKt.sourceInformation(startRestartGroup, "*199@7865L21,200@7909L40,201@7981L124,195@7737L378");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1254003341, "CC(remember):TeamScreen.kt#9igjgp");
                Object rememberedValue11 = startRestartGroup.rememberedValue();
                if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue11 = new Function0() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit TeamScreen$lambda$25$0$0;
                            TeamScreen$lambda$25$0$0 = TeamScreenKt.TeamScreen$lambda$25$0$0(MutableState.this);
                            return TeamScreen$lambda$25$0$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue11);
                }
                Function0 function0 = (Function0) rememberedValue11;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1254004768, "CC(remember):TeamScreen.kt#9igjgp");
                boolean changedInstance = startRestartGroup.changedInstance(TeamScreen$lambda$10);
                Object rememberedValue12 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue12 = new Function0() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit TeamScreen$lambda$25$1$0;
                            TeamScreen$lambda$25$1$0 = TeamScreenKt.TeamScreen$lambda$25$1$0(Worker.this, mutableState27, mutableState28);
                            return TeamScreen$lambda$25$1$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue12);
                }
                Function0 function02 = (Function0) rememberedValue12;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1254007156, "CC(remember):TeamScreen.kt#9igjgp");
                boolean changedInstance2 = startRestartGroup.changedInstance(coroutineScope2);
                Object rememberedValue13 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                    mutableState9 = mutableState6;
                    mutableState10 = mutableState7;
                    mutableState11 = mutableState8;
                    composer3 = startRestartGroup;
                    mutableState12 = mutableState;
                    mutableState13 = mutableState27;
                    worker = TeamScreen$lambda$10;
                    coroutineScope = coroutineScope2;
                    obj2 = new Function1() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj4) {
                            Unit TeamScreen$lambda$25$2$0;
                            TeamScreen$lambda$25$2$0 = TeamScreenKt.TeamScreen$lambda$25$2$0(CoroutineScope.this, mutableState11, mutableState9, mutableState12, mutableState10, (Worker) obj4);
                            return TeamScreen$lambda$25$2$0;
                        }
                    };
                    composer3.updateRememberedValue(obj2);
                } else {
                    mutableState9 = mutableState6;
                    composer3 = startRestartGroup;
                    obj2 = rememberedValue13;
                    mutableState10 = mutableState7;
                    mutableState11 = mutableState8;
                    mutableState12 = mutableState;
                    mutableState13 = mutableState27;
                    worker = TeamScreen$lambda$10;
                    coroutineScope = coroutineScope2;
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                mutableState14 = mutableState11;
                str = "CC(remember):TeamScreen.kt#9igjgp";
                Composer composer4 = composer3;
                mutableState15 = mutableState13;
                mutableState16 = mutableState28;
                app = FonRoApp;
                WorkerCardSheet(app, worker, z, function0, function02, (Function1) obj2, composer4, (Worker.$stable << 3) | FonRoApp.$stable | 3072 | (i5 & 14));
                composer2 = composer4;
                Unit unit2 = Unit.INSTANCE;
                composer2.endReplaceGroup();
                Unit unit3 = Unit.INSTANCE;
            } else {
                startRestartGroup.startReplaceGroup(-1201937824);
                startRestartGroup.endReplaceGroup();
                mutableState15 = mutableState27;
                mutableState9 = mutableState6;
                coroutineScope = coroutineScope2;
                mutableState10 = mutableState7;
                str = "CC(remember):TeamScreen.kt#9igjgp";
                mutableState14 = mutableState8;
                composer2 = startRestartGroup;
                mutableState12 = mutableState;
                mutableState16 = mutableState28;
                app = FonRoApp;
            }
            if (TeamScreen$lambda$13(mutableState16)) {
                composer2.startReplaceGroup(-1201513743);
                ComposerKt.sourceInformation(composer2, "211@8225L20,212@8269L248,209@8151L376");
                Worker TeamScreen$lambda$16 = TeamScreen$lambda$16(mutableState15);
                ComposerKt.sourceInformationMarkerStart(composer2, 931075133, str);
                Object rememberedValue14 = composer2.rememberedValue();
                if (rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue14 = new Function0() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit TeamScreen$lambda$26$0;
                            TeamScreen$lambda$26$0 = TeamScreenKt.TeamScreen$lambda$26$0(MutableState.this);
                            return TeamScreen$lambda$26$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue14);
                }
                Function0 function03 = (Function0) rememberedValue14;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, 931076769, str);
                boolean changedInstance3 = composer2.changedInstance(coroutineScope);
                Object rememberedValue15 = composer2.rememberedValue();
                if (changedInstance3 || rememberedValue15 == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState29 = mutableState14;
                    Object obj4 = new Function1() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj5) {
                            Unit TeamScreen$lambda$27$0;
                            TeamScreen$lambda$27$0 = TeamScreenKt.TeamScreen$lambda$27$0(CoroutineScope.this, mutableState29, mutableState9, mutableState12, mutableState10, (Worker) obj5);
                            return TeamScreen$lambda$27$0;
                        }
                    };
                    composer2.updateRememberedValue(obj4);
                    rememberedValue15 = obj4;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                WorkerFormSheet(TeamScreen$lambda$16, function03, (Function1) rememberedValue15, composer2, Worker.$stable | 48);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1201137031);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj5, Object obj6) {
                    return TeamScreenKt.TeamScreen$lambda$28(FonRoApp.this, nav, i, (Composer) obj5, ((Integer) obj6).intValue());
                }
            });
        }
    }

    private static final List<Worker> TeamScreen$lambda$1(MutableState<List<Worker>> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean TeamScreen$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void TeamScreen$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean TeamScreen$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void TeamScreen$lambda$8(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Worker TeamScreen$lambda$10(MutableState<Worker> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean TeamScreen$lambda$13(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void TeamScreen$lambda$14(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Worker TeamScreen$lambda$16(MutableState<Worker> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object TeamScreen$load(androidx.compose.runtime.MutableState<java.lang.Boolean> r11, androidx.compose.runtime.MutableState<java.util.List<uz.FonRo.pos.data.model.Worker>> r12, androidx.compose.runtime.MutableState<java.lang.Boolean> r13, androidx.compose.runtime.MutableState<uz.FonRo.pos.data.model.Worker> r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.team.TeamScreenKt.TeamScreen$load(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TeamScreen$lambda$24$0(boolean z, final List list, final MutableState mutableState, final MutableState mutableState2, final List list2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$TeamScreenKt.INSTANCE.getLambda$507498334$app(), 3, null);
        if (z) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-83991559, true, new Function3() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda38
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit TeamScreen$lambda$24$0$0;
                    TeamScreen$lambda$24$0$0 = TeamScreenKt.TeamScreen$lambda$24$0$0(MutableState.this, mutableState2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return TeamScreen$lambda$24$0$0;
                }
            }), 3, null);
        }
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1622948565, true, new Function3() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda39
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit TeamScreen$lambda$24$0$1;
                TeamScreen$lambda$24$0$1 = TeamScreenKt.TeamScreen$lambda$24$0$1(list2, list, mutableState3, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return TeamScreen$lambda$24$0$1;
            }
        }), 3, null);
        if (list.isEmpty()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(136844464, true, new Function3() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda40
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit TeamScreen$lambda$24$0$2;
                    TeamScreen$lambda$24$0$2 = TeamScreenKt.TeamScreen$lambda$24$0$2(MutableState.this, mutableState4, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return TeamScreen$lambda$24$0$2;
                }
            }), 3, null);
        }
        final Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object TeamScreen$lambda$24$0$3;
                TeamScreen$lambda$24$0$3 = TeamScreenKt.TeamScreen$lambda$24$0$3((Worker) obj);
                return TeamScreen$lambda$24$0$3;
            }
        };
        final TeamScreenKt$TeamScreen$lambda$24$0$$inlined$items$default$1 teamScreenKt$TeamScreen$lambda$24$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$TeamScreen$lambda$24$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Worker worker) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Worker) obj);
            }
        };
        LazyColumn.items(list.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$TeamScreen$lambda$24$0$$inlined$items$default$2
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
        }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$TeamScreen$lambda$24$0$$inlined$items$default$3
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
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$TeamScreen$lambda$24$0$$inlined$items$default$4
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
                final Worker worker = (Worker) list.get(i);
                composer.startReplaceGroup(1440712696);
                ComposerKt.sourceInformation(composer, "C*188@7587L18,186@7522L157:TeamScreen.kt#1se6wn");
                ComposerKt.sourceInformationMarkerStart(composer, 46476544, "CC(remember):TeamScreen.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(worker);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState6 = mutableState5;
                    rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$TeamScreen$2$1$5$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            mutableState6.setValue(Worker.this);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                TeamScreenKt.WorkerRow(worker, (Function0) rememberedValue, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(8.0f), 7, null), composer, Worker.$stable | 384, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TeamScreen$lambda$24$0$0$0(final MutableState mutableState, final MutableState mutableState2, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C149@6170L38,147@6078L560:TeamScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2094446463, i, -1, "uz.FonRo.pos.ui.team.TeamScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TeamScreen.kt:147)");
            }
            String tx = LangKt.tx("Добавить нового сотрудника", new Object[0]);
            BtnStyle btnStyle = BtnStyle.CYAN;
            BtnSize btnSize = BtnSize.LG;
            ComposerKt.sourceInformationMarkerStart(composer, -1576607195, "CC(remember):TeamScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda33
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit TeamScreen$lambda$24$0$0$0$0$0;
                        TeamScreen$lambda$24$0$0$0$0$0 = TeamScreenKt.TeamScreen$lambda$24$0$0$0$0$0(MutableState.this, mutableState2);
                        return TeamScreen$lambda$24$0$0$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, null, btnStyle, btnSize, false, true, ComposableSingletons$TeamScreenKt.INSTANCE.m10167getLambda$1358247346$app(), composer, 14183472, 36);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TeamScreen$lambda$24$0$0$0$0$0(MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(null);
        TeamScreen$lambda$14(mutableState2, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TeamScreen$lambda$24$0$1(List list, List list2, MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        int i2;
        String str;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C165@6709L325:TeamScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1622948565, i, -1, "uz.FonRo.pos.ui.team.TeamScreen.<anonymous>.<anonymous>.<anonymous> (TeamScreen.kt:165)");
            }
            String tx = LangKt.tx("Команда магазина", new Object[0]);
            if (list.isEmpty()) {
                str = LangKt.tx("Кроме владельца пока никого нет", new Object[0]);
            } else {
                String tx2 = LangKt.tx("Активны: ", new Object[0]);
                List list3 = list;
                if ((list3 instanceof Collection) && list3.isEmpty()) {
                    i2 = 0;
                } else {
                    Iterator it = list3.iterator();
                    i2 = 0;
                    while (it.hasNext()) {
                        if (((Worker) it.next()).isActive() && (i2 = i2 + 1) < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                str = tx2 + i2 + LangKt.tx(" из ", new Object[0]) + list.size();
            }
            BasicsKt.OxSectionHead(tx, null, str, TeamScreen$lambda$4(mutableState) ? "…" : String.valueOf(list2.size()), null, null, composer, 0, 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TeamScreen$lambda$24$0$2(MutableState mutableState, MutableState mutableState2, LazyItemScope item, Composer composer, int i) {
        String tx;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C175@7113L325:TeamScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(136844464, i, -1, "uz.FonRo.pos.ui.team.TeamScreen.<anonymous>.<anonymous>.<anonymous> (TeamScreen.kt:175)");
            }
            if (TeamScreen$lambda$4(mutableState)) {
                tx = LangKt.tx("Загружаем список…", new Object[0]);
            } else {
                tx = TeamScreen$lambda$7(mutableState2) ? LangKt.tx("Список сотрудников не загрузился. Проверьте соединение.", new Object[0]) : LangKt.tx("Сотрудников пока нет. Добавьте первого кнопкой выше.", new Object[0]);
            }
            BasicsKt.OxEmptyNote(tx, null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TeamScreen$lambda$24$0$3(Worker it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TeamScreen$lambda$25$0$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TeamScreen$lambda$25$1$0(Worker worker, MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(worker);
        TeamScreen$lambda$14(mutableState2, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TeamScreen$lambda$25$2$0(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, Worker worker) {
        if (worker != null) {
            mutableState.setValue(worker);
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new TeamScreenKt$TeamScreen$3$3$1$1(mutableState2, mutableState3, mutableState4, mutableState, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TeamScreen$lambda$26$0(MutableState mutableState) {
        TeamScreen$lambda$14(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TeamScreen$lambda$27$0(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, Worker worker) {
        if (worker != null) {
            mutableState.setValue(worker);
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new TeamScreenKt$TeamScreen$5$1$1(mutableState2, mutableState3, mutableState4, mutableState, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void WorkerRow(final uz.FonRo.pos.data.model.Worker r22, final kotlin.jvm.functions.Function0<kotlin.Unit> r23, androidx.compose.ui.Modifier r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.team.TeamScreenKt.WorkerRow(uz.FonRo.pos.data.model.Worker, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WorkerRow$lambda$2(boolean z, Worker worker, String str, ColumnScope OxCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCard, "$this$OxCard");
        ComposerKt.sourceInformation(composer, "C234@9054L1066:TeamScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(918712224, i, -1, "uz.FonRo.pos.ui.team.WorkerRow.<anonymous> (TeamScreen.kt:234)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1542578504, "C239@9255L68,240@9336L490,257@9967L143:TeamScreen.kt#1se6wn");
            m10181WorkerAvatar6a0pyJM(z, worker.isActive() || z, 0.0f, composer, 0, 4);
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
            ComposerKt.sourceInformationMarkerStart(composer, 2049095067, "C241@9382L214,247@9613L199:TeamScreen.kt#1se6wn");
            String fullName = worker.getFullName();
            if (StringsKt.isBlank(fullName)) {
                fullName = LangKt.tx("Без имени", new Object[0]);
            }
            TextKt.m2798Text4IGK_g(fullName, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH3(), composer, 0, 3120, 55294);
            String str2 = str;
            if (StringsKt.isBlank(str2)) {
                str2 = "—";
            }
            TextKt.m2798Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 0, 3120, 55294);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (!z && !worker.isActive()) {
                composer.startReplaceGroup(1543167565);
                ComposerKt.sourceInformation(composer, "255@9891L49");
                m10182WorkerBadgeiJQMabo(LangKt.tx("Отключён", new Object[0]), Ox.INSTANCE.m10199getDim0d7_KjU(), OxIcons.INSTANCE.getLock(), composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1543245406);
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

    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0059  */
    /* renamed from: WorkerAvatar-6a0pyJM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void m10181WorkerAvatar6a0pyJM(final boolean r20, final boolean r21, float r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.team.TeamScreenKt.m10181WorkerAvatar6a0pyJM(boolean, boolean, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: WorkerBadge-iJQMabo, reason: not valid java name */
    private static final void m10182WorkerBadgeiJQMabo(final String str, final long j, final ImageVector imageVector, Composer composer, final int i) {
        int i2;
        ImageVector imageVector2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1820370703);
        ComposerKt.sourceInformation(startRestartGroup, "C(WorkerBadge)P(1,2:c#ui.graphics.Color)292@10960L485:TeamScreen.kt#1se6wn");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            imageVector2 = imageVector;
            i2 |= startRestartGroup.changed(imageVector2) ? 256 : 128;
        } else {
            imageVector2 = imageVector;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1820370703, i3, -1, "uz.FonRo.pos.ui.team.WorkerBadge (TeamScreen.kt:291)");
            }
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, OxShape.INSTANCE.getPill()), Ox.INSTANCE.m10241tintBg5vOe2sY(j, 0.14f), null, 2, null), Dp.m6989constructorimpl(11.0f), Dp.m6989constructorimpl(6.0f));
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(5.0f));
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 690399206, "C300@11263L83,301@11355L84:TeamScreen.kt#1se6wn");
            IconKt.m2255Iconww6aTOc(imageVector2, (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(13.0f)), j, startRestartGroup, ((i3 << 6) & 7168) | ((i3 >> 6) & 14) | 432, 0);
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getChip(), j, TextUnitKt.getSp(11.5d), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777212, null), composer2, i3 & 14, 3072, 57342);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda46
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TeamScreenKt.WorkerBadge_iJQMabo$lambda$1(str, j, imageVector, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    private static final void WorkerCardSheet(uz.FonRo.pos.FonRoApp r36, uz.FonRo.pos.data.model.Worker r37, boolean r38, kotlin.jvm.functions.Function0<kotlin.Unit> r39, kotlin.jvm.functions.Function0<kotlin.Unit> r40, kotlin.jvm.functions.Function1<? super uz.FonRo.pos.data.model.Worker, kotlin.Unit> r41, androidx.compose.runtime.Composer r42, int r43) {
        /*
            Method dump skipped, instructions count: 1675
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.team.TeamScreenKt.WorkerCardSheet(uz.FonRo.pos.FonRoApp, uz.FonRo.pos.data.model.Worker, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    private static final List<WorkerDevice> WorkerCardSheet$lambda$1(MutableState<List<WorkerDevice>> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean WorkerCardSheet$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void WorkerCardSheet$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean WorkerCardSheet$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void WorkerCardSheet$lambda$8(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final WorkerDevice WorkerCardSheet$lambda$10(MutableState<WorkerDevice> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean WorkerCardSheet$lambda$13(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void WorkerCardSheet$lambda$14(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean WorkerCardSheet$lambda$17(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void WorkerCardSheet$lambda$18(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(11:5|6|7|(1:(2:10|11)(2:23|24))(2:25|(2:27|28)(3:29|30|(1:32)))|12|13|(1:15)|16|(1:18)|19|20))|35|6|7|(0)(0)|12|13|(0)|16|(0)|19|20) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x003f, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0083, code lost:
    
        r9 = kotlin.Result.INSTANCE;
        r7 = kotlin.Result.m7870constructorimpl(kotlin.ResultKt.createFailure(r7));
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object WorkerCardSheet$loadDevices(boolean r7, androidx.compose.runtime.MutableState<java.lang.Boolean> r8, uz.FonRo.pos.FonRoApp r9, uz.FonRo.pos.data.model.Worker r10, androidx.compose.runtime.MutableState<java.util.List<uz.FonRo.pos.data.model.WorkerDevice>> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            boolean r0 = r12 instanceof uz.FonRo.pos.ui.team.TeamScreenKt$WorkerCardSheet$loadDevices$1
            if (r0 == 0) goto L14
            r0 = r12
            uz.FonRo.pos.ui.team.TeamScreenKt$WorkerCardSheet$loadDevices$1 r0 = (uz.FonRo.pos.ui.team.TeamScreenKt$WorkerCardSheet$loadDevices$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            uz.FonRo.pos.ui.team.TeamScreenKt$WorkerCardSheet$loadDevices$1 r0 = new uz.FonRo.pos.ui.team.TeamScreenKt$WorkerCardSheet$loadDevices$1
            r0.<init>(r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L49
            if (r2 != r4) goto L41
            boolean r7 = r0.Z$0
            java.lang.Object r7 = r0.L$3
            r11 = r7
            androidx.compose.runtime.MutableState r11 = (androidx.compose.runtime.MutableState) r11
            java.lang.Object r7 = r0.L$2
            uz.FonRo.pos.data.model.Worker r7 = (uz.FonRo.pos.data.model.Worker) r7
            java.lang.Object r7 = r0.L$1
            uz.FonRo.pos.FonRoApp r7 = (uz.FonRo.pos.FonRoApp) r7
            java.lang.Object r7 = r0.L$0
            r8 = r7
            androidx.compose.runtime.MutableState r8 = (androidx.compose.runtime.MutableState) r8
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Throwable -> L3f
            goto L7c
        L3f:
            r7 = move-exception
            goto L83
        L41:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L49:
            kotlin.ResultKt.throwOnFailure(r12)
            if (r7 == 0) goto L54
            WorkerCardSheet$lambda$5(r8, r3)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L54:
            WorkerCardSheet$lambda$5(r8, r4)
            kotlin.Result$Companion r12 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3f
            uz.FonRo.pos.data.repo.AuthRepository r12 = r9.getAuth()     // Catch: java.lang.Throwable -> L3f
            long r5 = r10.getId()     // Catch: java.lang.Throwable -> L3f
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L3f
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)     // Catch: java.lang.Throwable -> L3f
            r0.L$1 = r9     // Catch: java.lang.Throwable -> L3f
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)     // Catch: java.lang.Throwable -> L3f
            r0.L$2 = r9     // Catch: java.lang.Throwable -> L3f
            r0.L$3 = r11     // Catch: java.lang.Throwable -> L3f
            r0.Z$0 = r7     // Catch: java.lang.Throwable -> L3f
            r0.label = r4     // Catch: java.lang.Throwable -> L3f
            java.lang.Object r12 = r12.workerDevices(r5, r0)     // Catch: java.lang.Throwable -> L3f
            if (r12 != r1) goto L7c
            return r1
        L7c:
            java.util.List r12 = (java.util.List) r12     // Catch: java.lang.Throwable -> L3f
            java.lang.Object r7 = kotlin.Result.m7870constructorimpl(r12)     // Catch: java.lang.Throwable -> L3f
            goto L8d
        L83:
            kotlin.Result$Companion r9 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)
            java.lang.Object r7 = kotlin.Result.m7870constructorimpl(r7)
        L8d:
            boolean r9 = kotlin.Result.m7877isSuccessimpl(r7)
            if (r9 == 0) goto L99
            r9 = r7
            java.util.List r9 = (java.util.List) r9
            WorkerCardSheet$lambda$2(r11, r9)
        L99:
            java.lang.Throwable r7 = kotlin.Result.m7873exceptionOrNullimpl(r7)
            if (r7 == 0) goto La4
            uz.FonRo.pos.ui.Toaster r9 = uz.FonRo.pos.ui.Toaster.INSTANCE
            r9.error(r7)
        La4:
            WorkerCardSheet$lambda$5(r8, r3)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.team.TeamScreenKt.WorkerCardSheet$loadDevices(boolean, androidx.compose.runtime.MutableState, uz.FonRo.pos.FonRoApp, uz.FonRo.pos.data.model.Worker, androidx.compose.runtime.MutableState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final void WorkerCardSheet$copyKey(Context context, String str) {
        ClipboardManager clipboardManager = (ClipboardManager) ContextCompat.getSystemService(context, ClipboardManager.class);
        if (clipboardManager == null) {
            Toaster.INSTANCE.error(LangKt.tx("Буфер обмена недоступен", new Object[0]));
        } else {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(LangKt.tx("Ключ доступа FonRo", new Object[0]), str));
            Toaster.INSTANCE.ok(LangKt.tx("Ключ скопирован", new Object[0]));
        }
    }

    private static final void WorkerCardSheet$regenerate(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, Worker worker, Function1<? super Worker, Unit> function1, boolean z, MutableState<Boolean> mutableState2, FonRoApp FonRoApp, MutableState<List<WorkerDevice>> mutableState3) {
        if (WorkerCardSheet$lambda$13(mutableState)) {
            return;
        }
        WorkerCardSheet$lambda$14(mutableState, true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new TeamScreenKt$WorkerCardSheet$regenerate$1(worker, function1, z, mutableState2, FonRoApp, mutableState3, mutableState, null), 3, null);
    }

    private static final void WorkerCardSheet$revoke(CoroutineScope coroutineScope, FonRoApp FonRoApp, boolean z, MutableState<Boolean> mutableState, Worker worker, MutableState<List<WorkerDevice>> mutableState2, WorkerDevice workerDevice) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new TeamScreenKt$WorkerCardSheet$revoke$1(FonRoApp, workerDevice, z, mutableState, worker, mutableState2, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WorkerCardSheet$lambda$25(final boolean z, boolean z2, final Worker worker, final List list, final List list2, final State state, final MutableState mutableState, final boolean z3, final String str, final Context context, final Function0 function0, final Function0 function02, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, ColumnScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C410@15469L21,409@15414L9793:TeamScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-777672606, i, -1, "uz.FonRo.pos.ui.team.WorkerCardSheet.<anonymous> (TeamScreen.kt:409)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -804842726, "C414@15694L1426,414@15644L1476,444@17197L613,444@17169L641,585@23656L1518,585@23628L1546,617@25187L10:TeamScreen.kt#1se6wn");
            BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(18.0f), OxShape.INSTANCE.getHero(), 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-112874274, true, new Function3() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda49
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit WorkerCardSheet$lambda$25$0$0;
                    WorkerCardSheet$lambda$25$0$0 = TeamScreenKt.WorkerCardSheet$lambda$25$0$0(z, worker, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return WorkerCardSheet$lambda$25$0$0;
                }
            }, composer, 54), composer, 1572912, 57);
            BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(14.0f), null, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1627362837, true, new Function3() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit WorkerCardSheet$lambda$25$0$1;
                    WorkerCardSheet$lambda$25$0$1 = TeamScreenKt.WorkerCardSheet$lambda$25$0$1(z, worker, list, list2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return WorkerCardSheet$lambda$25$0$1;
                }
            }, composer, 54), composer, 1572912, 61);
            if (z) {
                composer.startReplaceGroup(-802893819);
                ComposerKt.sourceInformation(composer, "461@17893L393");
                BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(14.0f), null, 0L, 0L, null, ComposableSingletons$TeamScreenKt.INSTANCE.getLambda$111754809$app(), composer, 1572912, 61);
                if (z2) {
                    composer.startReplaceGroup(-802397416);
                    ComposerKt.sourceInformation(composer, "472@18421L451,472@18414L458");
                    BasicsKt.OxList(null, ComposableLambdaKt.rememberComposableLambda(-1229413165, true, new Function3() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit WorkerCardSheet$lambda$25$0$2;
                            WorkerCardSheet$lambda$25$0$2 = TeamScreenKt.WorkerCardSheet$lambda$25$0$2(State.this, mutableState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            return WorkerCardSheet$lambda$25$0$2;
                        }
                    }, composer, 54), composer, 48, 1);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-801918838);
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-801754135);
                ComposerKt.sourceInformation(composer, "484@18956L2864,484@18928L2892,548@21906L1663,548@21878L1691");
                BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(14.0f), null, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1560596866, true, new Function3() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit WorkerCardSheet$lambda$25$0$3;
                        WorkerCardSheet$lambda$25$0$3 = TeamScreenKt.WorkerCardSheet$lambda$25$0$3(z3, str, context, function0, function02, mutableState2, mutableState3, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return WorkerCardSheet$lambda$25$0$3;
                    }
                }, composer, 54), composer, 1572912, 61);
                BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(14.0f), null, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(528061369, true, new Function3() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit WorkerCardSheet$lambda$25$0$4;
                        WorkerCardSheet$lambda$25$0$4 = TeamScreenKt.WorkerCardSheet$lambda$25$0$4(MutableState.this, mutableState5, z3, mutableState6, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return WorkerCardSheet$lambda$25$0$4;
                    }
                }, composer, 54), composer, 1572912, 61);
                composer.endReplaceGroup();
            }
            BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(14.0f), null, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1069378774, true, new Function3() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit WorkerCardSheet$lambda$25$0$5;
                    WorkerCardSheet$lambda$25$0$5 = TeamScreenKt.WorkerCardSheet$lambda$25$0$5(z, list, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return WorkerCardSheet$lambda$25$0$5;
                }
            }, composer, 54), composer, 1572912, 61);
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
    public static final Unit WorkerCardSheet$lambda$25$0$0(boolean z, Worker worker, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C415@15712L1394:TeamScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-112874274, i, -1, "uz.FonRo.pos.ui.team.WorkerCardSheet.<anonymous>.<anonymous>.<anonymous> (TeamScreen.kt:415)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(11.0f));
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m930spacedBy0680j_4, centerHorizontally, composer, 54);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1153678661, "C420@15958L71,421@16050L331,428@16402L686:TeamScreen.kt#1se6wn");
            m10181WorkerAvatar6a0pyJM(z, worker.isActive(), Dp.m6989constructorimpl(88.0f), composer, 384, 0);
            String fullName = worker.getFullName();
            if (StringsKt.isBlank(fullName)) {
                fullName = LangKt.tx("Без имени", new Object[0]);
            }
            TextKt.m2798Text4IGK_g(fullName, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6866boximpl(TextAlign.INSTANCE.m6873getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH1(), 0L, TextUnitKt.getSp(22), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.getSp(27), null, null, null, 0, 0, null, 16646141, null), composer, 0, 3120, 54782);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion);
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
            ComposerKt.sourceInformationMarkerStart(composer, 737764741, "C429@16484L254,434@16763L303:TeamScreen.kt#1se6wn");
            String tx = z ? LangKt.tx("Владелец", new Object[0]) : LangKt.tx("Сотрудник", new Object[0]);
            Ox ox = Ox.INSTANCE;
            long m10213getOrange0d7_KjU = z ? ox.m10213getOrange0d7_KjU() : ox.m10192getCyan0d7_KjU();
            OxIcons oxIcons = OxIcons.INSTANCE;
            m10182WorkerBadgeiJQMabo(tx, m10213getOrange0d7_KjU, z ? oxIcons.getCrown() : oxIcons.getUser(), composer, 0);
            m10182WorkerBadgeiJQMabo((worker.isActive() || z) ? LangKt.tx("Активен", new Object[0]) : LangKt.tx("Отключён", new Object[0]), (worker.isActive() || z) ? Ox.INSTANCE.m10211getOk0d7_KjU() : Ox.INSTANCE.m10231getSlate0d7_KjU(), (worker.isActive() || z) ? OxIcons.INSTANCE.getOk() : OxIcons.INSTANCE.getLock(), composer, 0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerCardSheet$lambda$25$0$1(boolean z, Worker worker, List list, List list2, ColumnScope OxSoftCard, Composer composer, int i) {
        String str;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C445@17215L101,450@17515L11,451@17543L253:TeamScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1627362837, i, -1, "uz.FonRo.pos.ui.team.WorkerCardSheet.<anonymous>.<anonymous>.<anonymous> (TeamScreen.kt:445)");
            }
            WorkerInfoRow(OxIcons.INSTANCE.getCrown(), LangKt.tx("Роль", new Object[0]), z ? LangKt.tx("Владелец", new Object[0]) : Perm.INSTANCE.roleName(worker.getRole()), composer, 0);
            String phone = worker.getPhone();
            String str2 = (phone == null || StringsKt.isBlank(phone)) ? null : phone;
            if (str2 != null) {
                composer.startReplaceGroup(-824379790);
                ComposerKt.sourceInformation(composer, "*447@17401L11,448@17433L47");
                BasicsKt.m9830OxDivideriPRSM58(0L, 0.0f, composer, 0, 3);
                WorkerInfoRow(OxIcons.INSTANCE.getPhone(), LangKt.tx("Телефон", new Object[0]), str2, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-824379791);
                composer.endReplaceGroup();
            }
            BasicsKt.m9830OxDivideriPRSM58(0L, 0.0f, composer, 0, 3);
            ImageVector clipboard = OxIcons.INSTANCE.getClipboard();
            String tx = LangKt.tx("Прав выдано", new Object[0]);
            if (z) {
                str = LangKt.tx("Полный доступ", new Object[0]);
            } else {
                str = list.size() + " / " + list2.size();
            }
            WorkerInfoRow(clipboard, tx, str, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerCardSheet$lambda$25$0$2(State state, final MutableState mutableState, ColumnScope OxList, Composer composer, int i) {
        Map<String, Integer> selfLimits;
        Intrinsics.checkNotNullParameter(OxList, "$this$OxList");
        ComposerKt.sourceInformation(composer, "C479@18799L25,473@18447L403:TeamScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1229413165, i, -1, "uz.FonRo.pos.ui.team.WorkerCardSheet.<anonymous>.<anonymous>.<anonymous> (TeamScreen.kt:473)");
            }
            String tx = LangKt.tx("Мой доступ", new Object[0]);
            User WorkerCardSheet$lambda$15 = WorkerCardSheet$lambda$15(state);
            int size = (WorkerCardSheet$lambda$15 == null || (selfLimits = WorkerCardSheet$lambda$15.getSelfLimits()) == null) ? 0 : selfLimits.size();
            String tx2 = size > 0 ? LangKt.tx("скрыто разделов: %s", Integer.valueOf(size)) : LangKt.tx("открыто всё", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -350033044, "CC(remember):TeamScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit WorkerCardSheet$lambda$25$0$2$1$0;
                        WorkerCardSheet$lambda$25$0$2$1$0 = TeamScreenKt.WorkerCardSheet$lambda$25$0$2$1$0(MutableState.this);
                        return WorkerCardSheet$lambda$25$0$2$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9832OxRow1YH7lEI(tx, null, tx2, (Function0) rememberedValue, false, 0L, null, null, composer, 27648, 226);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerCardSheet$lambda$25$0$2$1$0(MutableState mutableState) {
        WorkerCardSheet$lambda$18(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerCardSheet$lambda$25$0$3(boolean z, final String str, final Context context, final Function0 function0, final Function0 function02, MutableState mutableState, final MutableState mutableState2, ColumnScope OxSoftCard, Composer composer, int i) {
        int i2;
        int i3;
        String str2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C485@18978L43,486@19042L11,489@19221L1046,511@20288L11,512@20320L807:TeamScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1560596866, i, -1, "uz.FonRo.pos.ui.team.WorkerCardSheet.<anonymous>.<anonymous>.<anonymous> (TeamScreen.kt:485)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Ключ доступа", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH3(), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer, 6);
            Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), OxShape.INSTANCE.getField()), Ox.INSTANCE.m10217getPanel0d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getField()), Dp.m6989constructorimpl(12.0f), Dp.m6989constructorimpl(12.0f));
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(10.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m1050paddingVpY3zN4);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1399151793, "C499@19753L176,503@19954L291:TeamScreen.kt#1se6wn");
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getLock(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(18.0f)), Ox.INSTANCE.m10192getCyan0d7_KjU(), composer, 432, 0);
            String str3 = str;
            TextKt.m2798Text4IGK_g(StringsKt.isBlank(str3) ? "—" : str3, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH3(), 0L, 0L, null, null, null, FontFamily.INSTANCE.getMonospace(), null, TextUnitKt.getSp(1), null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777055, null), composer, 0, 0, 65534);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer, 6);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(9.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), composer, 6);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1974802351, "C517@20564L13,516@20508L220:TeamScreen.kt#1se6wn");
            String tx = LangKt.tx("Копировать", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -340796758, "CC(remember):TeamScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(context) | composer.changed(str);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda35
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit WorkerCardSheet$lambda$25$0$3$1$0$0;
                        WorkerCardSheet$lambda$25$0$3$1$0$0 = TeamScreenKt.WorkerCardSheet$lambda$25$0$3$1$0$0(context, str);
                        return WorkerCardSheet$lambda$25$0$3$1$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), null, null, !StringsKt.isBlank(str3), false, null, composer, 0, 216);
            if (z) {
                composer.startReplaceGroup(-1974552492);
                ComposerKt.sourceInformation(composer, "523@20856L25,522@20798L281");
                String tx2 = LangKt.tx("Изменить", new Object[0]);
                ComposerKt.sourceInformationMarkerStart(composer, -340787402, "CC(remember):TeamScreen.kt#9igjgp");
                boolean changed = composer.changed(function0) | composer.changed(function02);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda36
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit WorkerCardSheet$lambda$25$0$3$1$1$0;
                            WorkerCardSheet$lambda$25$0$3$1$1$0 = TeamScreenKt.WorkerCardSheet$lambda$25$0$3$1$1$0(Function0.this, function02);
                            return WorkerCardSheet$lambda$25$0$3$1$1$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                str2 = "CC(remember):TeamScreen.kt#9igjgp";
                i3 = 0;
                i2 = 6;
                composer2 = composer;
                BasicsKt.OxButton(tx2, (Function0) rememberedValue2, RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.CYAN, null, !WorkerCardSheet$lambda$13(mutableState), false, null, composer2, 3072, 208);
                composer2.endReplaceGroup();
            } else {
                i2 = 6;
                i3 = 0;
                str2 = "CC(remember):TeamScreen.kt#9igjgp";
                composer2 = composer;
                composer2.startReplaceGroup(-1974228635);
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (z) {
                composer2.startReplaceGroup(-1277535039);
                ComposerKt.sourceInformation(composer2, "531@21189L10,534@21316L28,532@21224L286,539@21535L10,540@21570L210");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(9.0f), composer2, i2);
                String tx3 = LangKt.tx("Перевыпустить ключ", new Object[i3]);
                BtnStyle btnStyle = BtnStyle.DANGER;
                boolean z2 = !WorkerCardSheet$lambda$13(mutableState);
                ComposerKt.sourceInformationMarkerStart(composer2, 790077470, str2);
                Object rememberedValue3 = composer2.rememberedValue();
                if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda37
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit WorkerCardSheet$lambda$25$0$3$2$0;
                            WorkerCardSheet$lambda$25$0$3$2$0 = TeamScreenKt.WorkerCardSheet$lambda$25$0$3$2$0(MutableState.this);
                            return WorkerCardSheet$lambda$25$0$3$2$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BasicsKt.OxButton(tx3, (Function0) rememberedValue3, null, btnStyle, null, z2, true, null, composer2, 1575984, 148);
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer2, i2);
                TextKt.m2798Text4IGK_g(LangKt.tx("Старый ключ перестанет работать сразу: сотрудник останется без входа, пока не получит новый.", new Object[i3]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
                composer.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1276920960);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerCardSheet$lambda$25$0$3$1$0$0(Context context, String str) {
        WorkerCardSheet$copyKey(context, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerCardSheet$lambda$25$0$3$1$1$0(Function0 function0, Function0 function02) {
        function0.invoke();
        function02.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerCardSheet$lambda$25$0$3$2$0(MutableState mutableState) {
        WorkerCardSheet$lambda$8(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerCardSheet$lambda$25$0$4(MutableState mutableState, MutableState mutableState2, boolean z, final MutableState mutableState3, ColumnScope OxSoftCard, Composer composer, int i) {
        Function0 function0;
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C549@21928L485,559@22434L11:TeamScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(528061369, i, -1, "uz.FonRo.pos.ui.team.WorkerCardSheet.<anonymous>.<anonymous>.<anonymous> (TeamScreen.kt:549)");
            }
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
            ComposerKt.sourceInformationMarkerStart(composer, 705260111, "C553@22112L73,554@22210L181:TeamScreen.kt#1se6wn");
            TextKt.m2798Text4IGK_g(LangKt.tx("Устройства", new Object[0]), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH3(), composer, 0, 0, 65532);
            TextKt.m2798Text4IGK_g(WorkerCardSheet$lambda$4(mutableState) ? "…" : String.valueOf(WorkerCardSheet$lambda$1(mutableState2).size()), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH3(), Ox.INSTANCE.m10200getDim20d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            Composer composer2 = composer;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer2, 6);
            if (WorkerCardSheet$lambda$4(mutableState)) {
                composer2.startReplaceGroup(660854214);
                ComposerKt.sourceInformation(composer2, "561@22515L45");
                TextKt.m2798Text4IGK_g(LangKt.tx("Загрузка…", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
                composer.endReplaceGroup();
            } else if (WorkerCardSheet$lambda$1(mutableState2).isEmpty()) {
                composer2.startReplaceGroup(660857229);
                ComposerKt.sourceInformation(composer2, "562@22606L148");
                TextKt.m2798Text4IGK_g(LangKt.tx("Ключ ещё нигде не активирован.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
                composer.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-988064413);
                ComposerKt.sourceInformation(composer2, "575@23273L230");
                composer2.startReplaceGroup(660864508);
                ComposerKt.sourceInformation(composer2, "*568@22877L337");
                for (final WorkerDevice workerDevice : WorkerCardSheet$lambda$1(mutableState2)) {
                    if (z) {
                        composer2.startReplaceGroup(-552620389);
                        ComposerKt.sourceInformation(composer2, "571@23063L26");
                        ComposerKt.sourceInformationMarkerStart(composer2, -849110457, "CC(remember):TeamScreen.kt#9igjgp");
                        boolean changedInstance = composer2.changedInstance(workerDevice);
                        Object rememberedValue = composer2.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda22
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit WorkerCardSheet$lambda$25$0$4$1$0$0;
                                    WorkerCardSheet$lambda$25$0$4$1$0$0 = TeamScreenKt.WorkerCardSheet$lambda$25$0$4$1$0$0(WorkerDevice.this, mutableState3);
                                    return WorkerCardSheet$lambda$25$0$4$1$0$0;
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        function0 = (Function0) rememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-552588336);
                        composer2.endReplaceGroup();
                        function0 = null;
                    }
                    MyDevicesScreenKt.DeviceCard(workerDevice, false, function0, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(8.0f), 7, null), composer2, WorkerDevice.$stable | 3120, 0);
                    composer2 = composer;
                }
                composer.endReplaceGroup();
                TextKt.m2798Text4IGK_g(LangKt.tx("«Выйти» на устройстве освобождает место само. Отвяжите устройство, если оно незнакомое или потеряно.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65534);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerCardSheet$lambda$25$0$4$1$0$0(WorkerDevice workerDevice, MutableState mutableState) {
        mutableState.setValue(workerDevice);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerCardSheet$lambda$25$0$5(boolean z, List list, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C586@23674L44,587@23735L11:TeamScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1069378774, i, -1, "uz.FonRo.pos.ui.team.WorkerCardSheet.<anonymous>.<anonymous>.<anonymous> (TeamScreen.kt:586)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Права доступа", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH3(), composer, 0, 0, 65534);
            Composer composer2 = composer;
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer2, 6);
            if (z) {
                composer2.startReplaceGroup(1175822880);
                ComposerKt.sourceInformation(composer2, "589@23801L170");
                TextKt.m2798Text4IGK_g(LangKt.tx("Владелец имеет полный доступ ко всем разделам.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
                composer.endReplaceGroup();
            } else {
                int i2 = 0;
                if (list.isEmpty()) {
                    composer2.startReplaceGroup(1175829986);
                    ComposerKt.sourceInformation(composer2, "593@24024L140");
                    TextKt.m2798Text4IGK_g(LangKt.tx("Права не выданы.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
                    composer.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(2091202186);
                    ComposerKt.sourceInformation(composer2, "*598@24260L860");
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        String str = (String) ((Pair) it.next()).component2();
                        Modifier m1050paddingVpY3zN4 = PaddingKt.m1050paddingVpY3zN4(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(6.0f), 7, null), OxShape.INSTANCE.getIconChip()), Ox.INSTANCE.m10241tintBg5vOe2sY(Ox.INSTANCE.m10201getGreen0d7_KjU(), 0.12f), null, 2, null), Dp.m6989constructorimpl(10.0f), Dp.m6989constructorimpl(8.0f));
                        Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(7.0f));
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, centerVertically, composer2, 54);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, i2);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m1050paddingVpY3zN4);
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
                        ComposerKt.sourceInformationMarkerStart(composer2, 497924180, "C608@24835L184,612@25048L46:TeamScreen.kt#1se6wn");
                        IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getOk(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(15.0f)), Ox.INSTANCE.m10211getOk0d7_KjU(), composer2, 432, 0);
                        TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getChip(), composer, 0, 3072, 57342);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        composer2 = composer;
                        i2 = i2;
                    }
                    composer.endReplaceGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerCardSheet$lambda$26$0(CoroutineScope coroutineScope, MutableState mutableState, Worker worker, Function1 function1, boolean z, MutableState mutableState2, FonRoApp FonRoApp, MutableState mutableState3) {
        WorkerCardSheet$regenerate(coroutineScope, mutableState, worker, function1, z, mutableState2, FonRoApp, mutableState3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerCardSheet$lambda$27$0(MutableState mutableState) {
        WorkerCardSheet$lambda$8(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerCardSheet$lambda$28$0$0(WorkerDevice workerDevice, CoroutineScope coroutineScope, FonRoApp FonRoApp, boolean z, MutableState mutableState, Worker worker, MutableState mutableState2) {
        WorkerCardSheet$revoke(coroutineScope, FonRoApp, z, mutableState, worker, mutableState2, workerDevice);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerCardSheet$lambda$28$1$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerCardSheet$lambda$29$0(MutableState mutableState) {
        WorkerCardSheet$lambda$18(mutableState, false);
        return Unit.INSTANCE;
    }

    private static final void WorkerInfoRow(final ImageVector imageVector, final String str, String str2, Composer composer, final int i) {
        int i2;
        Composer composer2;
        final String str3;
        Composer startRestartGroup = composer.startRestartGroup(960113628);
        ComposerKt.sourceInformation(startRestartGroup, "C(WorkerInfoRow)652@26478L640:TeamScreen.kt#1se6wn");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(imageVector) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(str2) ? 256 : 128;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composer2 = startRestartGroup;
            str3 = str2;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(960113628, i3, -1, "uz.FonRo.pos.ui.team.WorkerInfoRow (TeamScreen.kt:651)");
            }
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(11.0f), 1, null);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1657221064, "C657@26685L86,658@26780L35,659@26824L24,660@26857L255:TeamScreen.kt#1se6wn");
            IconKt.m2255Iconww6aTOc(imageVector, (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(18.0f)), Ox.INSTANCE.m10192getCyan0d7_KjU(), startRestartGroup, (i3 & 14) | 432, 0);
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer2, (i3 >> 3) & 14, 0, 65534);
            BoxKt.Box(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer2, 0);
            str3 = str2;
            TextKt.m2798Text4IGK_g(str3, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowTitle(), 0L, 0L, FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6874getEnde0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744443, null), composer2, (i3 >> 6) & 14, 3120, 55294);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda47
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TeamScreenKt.WorkerInfoRow$lambda$1(ImageVector.this, str, str3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void WorkerFormSheet(final Worker worker, Function0<Unit> function0, final Function1<? super Worker, Unit> function1, Composer composer, final int i) {
        int i2;
        final Worker worker2;
        Composer composer2;
        final Function1<? super Worker, Unit> function12;
        final Function0<Unit> function02 = function0;
        Composer startRestartGroup = composer.startRestartGroup(1929362198);
        ComposerKt.sourceInformation(startRestartGroup, "C(WorkerFormSheet)P(2)680@27305L24,683@27378L55,684@27451L52,687@27650L103,690@27772L53,691@27842L34,695@28037L390,758@30582L397,769@30986L2992,755@30446L3532:TeamScreen.kt#1se6wn");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(worker) : startRestartGroup.changedInstance(worker) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            worker2 = worker;
            composer2 = startRestartGroup;
            function12 = function1;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1929362198, i3, -1, "uz.FonRo.pos.ui.team.WorkerFormSheet (TeamScreen.kt:679)");
            }
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
            final boolean z = worker == null;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1308793363, "CC(remember):TeamScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                String fullName = worker != null ? worker.getFullName() : null;
                if (fullName == null) {
                    fullName = "";
                }
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fullName, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1308791030, "CC(remember):TeamScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                String phone = worker != null ? worker.getPhone() : null;
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(phone != null ? phone : "", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Long valueOf = worker != null ? Long.valueOf(worker.getId()) : null;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1308784611, "CC(remember):TeamScreen.kt#9igjgp");
            boolean changed = startRestartGroup.changed(valueOf);
            String rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = StringsKt.equals(worker != null ? worker.getRole() : null, "manager", true) ? "manager" : "cashier";
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final String str = (String) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1308780757, "CC(remember):TeamScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(worker != null ? worker.isActive() : true), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1308778536, "CC(remember):TeamScreen.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Long valueOf2 = worker != null ? Long.valueOf(worker.getId()) : null;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1308771940, "CC(remember):TeamScreen.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(valueOf2);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                Map<String, Integer> new_worker_defaults = worker == null ? Perm.INSTANCE.getNEW_WORKER_DEFAULTS() : MapsKt.emptyMap();
                Map<String, Integer> permissions = worker != null ? worker.getPermissions() : null;
                if (permissions == null) {
                    permissions = MapsKt.emptyMap();
                }
                List<Pair<String, List<Pair<String, String>>>> groups = Perm.INSTANCE.getGROUPS();
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = groups.iterator();
                while (it.hasNext()) {
                    CollectionsKt.addAll(arrayList, (Iterable) ((Pair) it.next()).getSecond());
                }
                ArrayList arrayList2 = arrayList;
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    String str2 = (String) ((Pair) it2.next()).component1();
                    Integer num = permissions.get(str2);
                    Pair pair = TuplesKt.to(str2, Integer.valueOf((num == null && (num = new_worker_defaults.get(str2)) == null) ? 0 : num.intValue()));
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(linkedHashMap, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final MutableState mutableState5 = (MutableState) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final boolean z2 = z;
            worker2 = worker;
            function02 = function0;
            composer2 = startRestartGroup;
            function12 = function1;
            SheetsKt.OxCardSheet(z ? LangKt.tx("Новый сотрудник", new Object[0]) : LangKt.tx("Права доступа", new Object[0]), function02, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(794662793, true, new Function3() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TeamScreenKt.WorkerFormSheet$lambda$16(Function0.this, z2, coroutineScope, worker, str, mutableState5, function1, mutableState4, mutableState, mutableState2, mutableState3, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-536918222, true, new Function3() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TeamScreenKt.WorkerFormSheet$lambda$17(z, mutableState, mutableState4, mutableState2, mutableState3, mutableState5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), composer2, (i3 & 112) | 14155776, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TeamScreenKt.WorkerFormSheet$lambda$18(Worker.this, function02, function12, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String WorkerFormSheet$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String WorkerFormSheet$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean WorkerFormSheet$lambda$8(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void WorkerFormSheet$lambda$9(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean WorkerFormSheet$lambda$11(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void WorkerFormSheet$lambda$12(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<String, Integer> WorkerFormSheet$lambda$14(MutableState<Map<String, Integer>> mutableState) {
        return mutableState.getValue();
    }

    private static final void WorkerFormSheet$save(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, MutableState<String> mutableState2, Worker worker, String str, Function1<? super Worker, Unit> function1, Function0<Unit> function0, MutableState<String> mutableState3, MutableState<Boolean> mutableState4, MutableState<Map<String, Integer>> mutableState5) {
        if (WorkerFormSheet$lambda$11(mutableState)) {
            return;
        }
        String obj = StringsKt.trim((CharSequence) WorkerFormSheet$lambda$1(mutableState2)).toString();
        if (obj.length() == 0) {
            Toaster.INSTANCE.error(LangKt.tx("Введите имя сотрудника", new Object[0]));
        } else {
            WorkerFormSheet$lambda$12(mutableState, true);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new TeamScreenKt$WorkerFormSheet$save$1(worker, obj, str, function1, function0, mutableState3, mutableState4, mutableState5, mutableState, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WorkerFormSheet$lambda$16(final Function0 function0, boolean z, final CoroutineScope coroutineScope, final Worker worker, final String str, final MutableState mutableState, final Function1 function1, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C759@30596L89,762@30787L10,760@30698L271:TeamScreen.kt#1se6wn");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(794662793, i2, -1, "uz.FonRo.pos.ui.team.WorkerFormSheet.<anonymous> (TeamScreen.kt:759)");
            }
            BasicsKt.OxButton(LangKt.tx("Отмена", new Object[0]), function0, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.GHOST, null, false, false, null, composer, 3072, 240);
            String tx = z ? LangKt.tx("Создать", new Object[0]) : LangKt.tx("Сохранить", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -833228045, "CC(remember):TeamScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(worker) | composer.changed(str) | composer.changed(mutableState) | composer.changed(function1) | composer.changed(function0);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                Function0 function02 = new Function0() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit WorkerFormSheet$lambda$16$0$0;
                        WorkerFormSheet$lambda$16$0$0 = TeamScreenKt.WorkerFormSheet$lambda$16$0$0(CoroutineScope.this, mutableState2, mutableState3, worker, str, function1, function0, mutableState4, mutableState5, mutableState);
                        return WorkerFormSheet$lambda$16$0$0;
                    }
                };
                composer.updateRememberedValue(function02);
                rememberedValue = function02;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, !WorkerFormSheet$lambda$11(mutableState2), false, null, composer, 27648, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerFormSheet$lambda$16$0$0(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, Worker worker, String str, Function1 function1, Function0 function0, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5) {
        WorkerFormSheet$save(coroutineScope, mutableState, mutableState2, worker, str, function1, function0, mutableState3, mutableState4, mutableState5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WorkerFormSheet$lambda$17(boolean z, final MutableState mutableState, MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, ColumnScope OxCardSheet, Composer composer, int i) {
        int i2;
        Composer composer2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C770@31027L21,770@30996L2976:TeamScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-536918222, i, -1, "uz.FonRo.pos.ui.team.WorkerFormSheet.<anonymous> (TeamScreen.kt:770)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1622397802, "C774@31173L13,771@31065L227,781@31416L14,778@31305L318,793@31999L463,793@31992L470,805@32475L11:TeamScreen.kt#1se6wn");
            String tx = LangKt.tx("Имя *", new Object[0]);
            String WorkerFormSheet$lambda$1 = WorkerFormSheet$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 190883317, "CC(remember):TeamScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit WorkerFormSheet$lambda$17$0$0$0;
                        WorkerFormSheet$lambda$17$0$0$0 = TeamScreenKt.WorkerFormSheet$lambda$17$0$0$0(MutableState.this, (String) obj);
                        return WorkerFormSheet$lambda$17$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9846OxFieldDfSPO0(tx, WorkerFormSheet$lambda$1, (Function1) rememberedValue, null, LangKt.tx("Например: Ali Valiyev", new Object[0]), 0, 0, null, false, false, !WorkerFormSheet$lambda$11(mutableState2), false, false, null, null, composer, 384, 0, 31720);
            String tx2 = LangKt.tx("Телефон", new Object[0]);
            String WorkerFormSheet$lambda$4 = WorkerFormSheet$lambda$4(mutableState3);
            ComposerKt.sourceInformationMarkerStart(composer, 190891094, "CC(remember):TeamScreen.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit WorkerFormSheet$lambda$17$0$1$0;
                        WorkerFormSheet$lambda$17$0$1$0 = TeamScreenKt.WorkerFormSheet$lambda$17$0$1$0(MutableState.this, (String) obj);
                        return WorkerFormSheet$lambda$17$0$1$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FieldsKt.m9846OxFieldDfSPO0(tx2, WorkerFormSheet$lambda$4, (Function1) rememberedValue2, null, LangKt.tx("Необязательно", new Object[0]), KeyboardType.INSTANCE.m6694getPhonePjHm6EE(), ImeAction.INSTANCE.m6635getDoneeUduSuo(), null, false, false, !WorkerFormSheet$lambda$11(mutableState2), false, false, null, null, composer, 1769856, 0, 31624);
            BasicsKt.OxList(null, ComposableLambdaKt.rememberComposableLambda(-279788883, true, new Function3() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit WorkerFormSheet$lambda$17$0$2;
                    WorkerFormSheet$lambda$17$0$2 = TeamScreenKt.WorkerFormSheet$lambda$17$0$2(MutableState.this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return WorkerFormSheet$lambda$17$0$2;
                }
            }, composer, 54), composer, 48, 1);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(16.0f), composer, 6);
            if (z) {
                composer.startReplaceGroup(1623753245);
                ComposerKt.sourceInformation(composer, "808@32529L289,814@32835L11");
                i2 = 6;
                composer2 = composer;
                i3 = 48;
                BasicsKt.m9833OxSoftCardCe4qNIY(null, Dp.m6989constructorimpl(13.0f), null, 0L, 0L, null, ComposableSingletons$TeamScreenKt.INSTANCE.m10166getLambda$1175636599$app(), composer2, 1572912, 61);
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(16.0f), composer2, 6);
                composer2.endReplaceGroup();
            } else {
                i2 = 6;
                composer2 = composer;
                i3 = 48;
                composer2.startReplaceGroup(1624088634);
                composer2.endReplaceGroup();
            }
            composer2.startReplaceGroup(190939196);
            ComposerKt.sourceInformation(composer2, "*819@33017L66,820@33107L813,820@33100L820,838@33937L11");
            Iterator<T> it = Perm.INSTANCE.getGROUPS().iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                String str = (String) pair.component1();
                final List list = (List) pair.component2();
                List list2 = list;
                if ((list2 instanceof Collection) && list2.isEmpty()) {
                    i4 = 0;
                } else {
                    Iterator it2 = list2.iterator();
                    i4 = 0;
                    while (it2.hasNext()) {
                        Integer num = WorkerFormSheet$lambda$14(mutableState5).get((String) ((Pair) it2.next()).component1());
                        if ((num != null ? num.intValue() : 0) == 1 && (i4 = i4 + 1) < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                BasicsKt.OxSectionHead(str, null, null, i4 + "/" + list.size(), null, null, composer2, 0, 54);
                BasicsKt.OxList(null, ComposableLambdaKt.rememberComposableLambda(1075616220, true, new Function3() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit WorkerFormSheet$lambda$17$0$3$1;
                        WorkerFormSheet$lambda$17$0$3$1 = TeamScreenKt.WorkerFormSheet$lambda$17$0$3$1(list, mutableState5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return WorkerFormSheet$lambda$17$0$3$1;
                    }
                }, composer2, 54), composer2, i3, 1);
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(16.0f), composer2, i2);
            }
            composer2.endReplaceGroup();
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
    public static final Unit WorkerFormSheet$lambda$17$0$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerFormSheet$lambda$17$0$1$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerFormSheet$lambda$17$0$2(final MutableState mutableState, ColumnScope OxList, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxList, "$this$OxList");
        ComposerKt.sourceInformation(composer, "C799@32270L20,800@32323L107,794@32017L431:TeamScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-279788883, i, -1, "uz.FonRo.pos.ui.team.WorkerFormSheet.<anonymous>.<anonymous>.<anonymous> (TeamScreen.kt:794)");
            }
            String tx = LangKt.tx("Активен", new Object[0]);
            String tx2 = WorkerFormSheet$lambda$8(mutableState) ? LangKt.tx("Вход по ключу работает", new Object[0]) : LangKt.tx("Вход выключен, права сохранятся", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, 1705831777, "CC(remember):TeamScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda44
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit WorkerFormSheet$lambda$17$0$2$0$0;
                        WorkerFormSheet$lambda$17$0$2$0$0 = TeamScreenKt.WorkerFormSheet$lambda$17$0$2$0$0(MutableState.this);
                        return WorkerFormSheet$lambda$17$0$2$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9832OxRow1YH7lEI(tx, null, tx2, (Function0) rememberedValue, false, 0L, null, ComposableLambdaKt.rememberComposableLambda(51181284, true, new Function3() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda45
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit WorkerFormSheet$lambda$17$0$2$1;
                    WorkerFormSheet$lambda$17$0$2$1 = TeamScreenKt.WorkerFormSheet$lambda$17$0$2$1(MutableState.this, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return WorkerFormSheet$lambda$17$0$2$1;
                }
            }, composer, 54), composer, 12610560, 98);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerFormSheet$lambda$17$0$2$0$0(MutableState mutableState) {
        WorkerFormSheet$lambda$9(mutableState, !WorkerFormSheet$lambda$8(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerFormSheet$lambda$17$0$2$1(final MutableState mutableState, RowScope OxRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxRow, "$this$OxRow");
        ComposerKt.sourceInformation(composer, "C801@32392L15,801@32349L59:TeamScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(51181284, i, -1, "uz.FonRo.pos.ui.team.WorkerFormSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TeamScreen.kt:801)");
            }
            boolean WorkerFormSheet$lambda$8 = WorkerFormSheet$lambda$8(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 1940575891, "CC(remember):TeamScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda48
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit WorkerFormSheet$lambda$17$0$2$1$0$0;
                        WorkerFormSheet$lambda$17$0$2$1$0$0 = TeamScreenKt.WorkerFormSheet$lambda$17$0$2$1$0$0(MutableState.this, ((Boolean) obj).booleanValue());
                        return WorkerFormSheet$lambda$17$0$2$1$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SwitchKt.Switch(WorkerFormSheet$lambda$8, (Function1) rememberedValue, null, null, false, null, null, composer, 48, 124);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerFormSheet$lambda$17$0$2$1$0$0(MutableState mutableState, boolean z) {
        WorkerFormSheet$lambda$9(mutableState, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerFormSheet$lambda$17$0$3$1(List list, final MutableState mutableState, ColumnScope OxList, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(OxList, "$this$OxList");
        ComposerKt.sourceInformation(composer2, "C*826@33415L50,827@33506L348,823@33262L618:TeamScreen.kt#1se6wn");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1075616220, i, -1, "uz.FonRo.pos.ui.team.WorkerFormSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TeamScreen.kt:821)");
            }
            int i2 = 0;
            for (Object obj : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Pair pair = (Pair) obj;
                final String str = (String) pair.component1();
                String str2 = (String) pair.component2();
                Integer num = WorkerFormSheet$lambda$14(mutableState).get(str);
                final boolean z = (num != null ? num.intValue() : 0) == 1;
                boolean z2 = i2 < CollectionsKt.getLastIndex(list);
                ComposerKt.sourceInformationMarkerStart(composer2, 383913617, "CC(remember):TeamScreen.kt#9igjgp");
                boolean changed = composer2.changed(mutableState) | composer2.changed(str) | composer2.changed(z);
                Object rememberedValue = composer2.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda42
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit WorkerFormSheet$lambda$17$0$3$1$0$0$0;
                            WorkerFormSheet$lambda$17$0$3$1$0$0$0 = TeamScreenKt.WorkerFormSheet$lambda$17$0$3$1$0$0$0(str, z, mutableState);
                            return WorkerFormSheet$lambda$17$0$3$1$0$0$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BasicsKt.m9832OxRow1YH7lEI(str2, null, null, (Function0) rememberedValue, z2, 0L, null, ComposableLambdaKt.rememberComposableLambda(1096641384, true, new Function3() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda43
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        Unit WorkerFormSheet$lambda$17$0$3$1$0$1;
                        WorkerFormSheet$lambda$17$0$3$1$0$1 = TeamScreenKt.WorkerFormSheet$lambda$17$0$3$1$0$1(z, mutableState, str, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        return WorkerFormSheet$lambda$17$0$3$1$0$1;
                    }
                }, composer2, 54), composer2, 12582912, 102);
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
    public static final Unit WorkerFormSheet$lambda$17$0$3$1$0$0$0(String str, boolean z, MutableState mutableState) {
        mutableState.setValue(MapsKt.plus(WorkerFormSheet$lambda$14(mutableState), TuplesKt.to(str, Integer.valueOf(!z ? 1 : 0))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerFormSheet$lambda$17$0$3$1$0$1(boolean z, final MutableState mutableState, final String str, RowScope OxRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxRow, "$this$OxRow");
        ComposerKt.sourceInformation(composer, "C830@33657L133,828@33540L284:TeamScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1096641384, i, -1, "uz.FonRo.pos.ui.team.WorkerFormSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TeamScreen.kt:828)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1605387469, "CC(remember):TeamScreen.kt#9igjgp");
            boolean changed = composer.changed(mutableState) | composer.changed(str);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit WorkerFormSheet$lambda$17$0$3$1$0$1$0$0;
                        WorkerFormSheet$lambda$17$0$3$1$0$1$0$0 = TeamScreenKt.WorkerFormSheet$lambda$17$0$3$1$0$1$0$0(str, mutableState, ((Boolean) obj).booleanValue());
                        return WorkerFormSheet$lambda$17$0$3$1$0$1$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SwitchKt.Switch(z, (Function1) rememberedValue, null, null, false, null, null, composer, 0, 124);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WorkerFormSheet$lambda$17$0$3$1$0$1$0$0(String str, MutableState mutableState, boolean z) {
        mutableState.setValue(MapsKt.plus(WorkerFormSheet$lambda$14(mutableState), TuplesKt.to(str, Integer.valueOf(z ? 1 : 0))));
        return Unit.INSTANCE;
    }

    public static final String formatAccessKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String upperCase = key.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String str = upperCase;
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isDigit(charAt) || ('A' <= charAt && charAt < '[')) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        int i2 = 2;
        if (sb2.length() <= 2) {
            return sb2;
        }
        String substring = sb2.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        StringBuilder sb3 = new StringBuilder(substring);
        while (i2 < sb2.length()) {
            sb3.append('-');
            int i3 = i2 + 4;
            String substring2 = sb2.substring(i2, Math.min(i3, sb2.length()));
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            sb3.append(substring2);
            i2 = i3;
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "toString(...)");
        return sb4;
    }

    private static final User WorkerCardSheet$lambda$15(State<User> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TeamScreen$lambda$24$0$0(final MutableState mutableState, final MutableState mutableState2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C146@6056L600,146@5983L673:TeamScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-83991559, i, -1, "uz.FonRo.pos.ui.team.TeamScreen.<anonymous>.<anonymous>.<anonymous> (TeamScreen.kt:146)");
            }
            BasicsKt.m9833OxSoftCardCe4qNIY(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null), Dp.m6989constructorimpl(13.0f), null, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(2094446463, true, new Function3() { // from class: uz.FonRo.pos.ui.team.TeamScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit TeamScreen$lambda$24$0$0$0;
                    TeamScreen$lambda$24$0$0$0 = TeamScreenKt.TeamScreen$lambda$24$0$0$0(MutableState.this, mutableState2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return TeamScreen$lambda$24$0$0$0;
                }
            }, composer, 54), composer, 1572918, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
