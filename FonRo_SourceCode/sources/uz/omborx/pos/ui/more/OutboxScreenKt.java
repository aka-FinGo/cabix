package uz.FonRo.pos.ui.more;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
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
import j$.time.Instant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
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
import uz.FonRo.pos.data.local.SaleOutbox;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.Toaster;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnSize;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.ChipTone;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxDim;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;
import uz.FonRo.pos.work.BackgroundWork;

/* compiled from: OutboxScreen.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0006\u001a\u001f\u0010\u000b\u001a\u00020\u0001H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\f\u001a=\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0003b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0014\u001a\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¨\u0006\u0002²\u0006\u0010\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0019X\u008a\u0084\u0002²\u0006\n\u0010\u001a\u001a\u00020\u001bX\u008a\u008e\u0002²\u0006\f\u0010\u001c\u001a\u0004\u0018\u00010\u000fX\u008a\u008e\u0002"}, d2 = {"OutboxScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "EmptyOutbox", "(Landroidx/compose/runtime/Composer;I)V", "PendingCard", "pending", "Luz/FonRo/pos/data/local/SaleOutbox$Pending;", "money", "", "onRemove", "Lkotlin/Function0;", "(Luz/FonRo/pos/data/local/SaleOutbox$Pending;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "createdText", "millis", "", "queue", "", "busy", "", "removeTarget"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class OutboxScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit EmptyOutbox$lambda$1(int i, Composer composer, int i2) {
        EmptyOutbox(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OutboxScreen$lambda$9(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        OutboxScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PendingCard$lambda$1(SaleOutbox.Pending pending, String str, Function0 function0, int i, Composer composer, int i2) {
        PendingCard(pending, str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void OutboxScreen(final FonRoApp app, final AppNavigator nav, Composer composer, final int i) {
        int i2;
        final Repo repo;
        final MutableState mutableState;
        int i3;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(nav, "nav");
        Composer startRestartGroup = composer.startRestartGroup(-1057446191);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutboxScreen)67@2810L7,68@2834L24,70@2895L29,72@2942L34,73@3001L54,78@3213L3381,75@3061L3533:OutboxScreen.kt#1sifzz");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1057446191, i2, -1, "uz.FonRo.pos.ui.more.OutboxScreen (OutboxScreen.kt:65)");
            }
            Repo repo2 = app.getRepo();
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Context context = (Context) consume;
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
            final State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(repo2.getOutbox().getQueue(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1701467347, "CC(remember):OutboxScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1701469255, "CC(remember):OutboxScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            MutableState mutableState3 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int i4 = i2;
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), OxDim.INSTANCE.m10245getPagePadD9Ej5fM(), 0.0f, 2, null);
            PaddingValues m1046PaddingValuesa9UjIt4$default = PaddingKt.m1046PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(28.0f), 7, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1701479366, "CC(remember):OutboxScreen.kt#9igjgp");
            boolean changed = startRestartGroup.changed(collectAsStateWithLifecycle) | startRestartGroup.changedInstance(context) | startRestartGroup.changedInstance(coroutineScope) | ((i4 & 14) == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(app))) | startRestartGroup.changedInstance(repo2);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                repo = repo2;
                mutableState = mutableState3;
                i3 = 0;
                Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.more.OutboxScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit OutboxScreen$lambda$7$0;
                        OutboxScreen$lambda$7$0 = OutboxScreenKt.OutboxScreen$lambda$7$0(context, coroutineScope, app, mutableState2, collectAsStateWithLifecycle, repo, mutableState, (LazyListScope) obj);
                        return OutboxScreen$lambda$7$0;
                    }
                };
                startRestartGroup.updateRememberedValue(function1);
                rememberedValue4 = function1;
            } else {
                i3 = 0;
                repo = repo2;
                mutableState = mutableState3;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int i5 = i3;
            LazyDslKt.LazyColumn(m1051paddingVpY3zN4$default, null, m1046PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) rememberedValue4, startRestartGroup, 384, TypedValues.PositionType.TYPE_PERCENT_X);
            startRestartGroup = startRestartGroup;
            final SaleOutbox.Pending OutboxScreen$lambda$5 = OutboxScreen$lambda$5(mutableState);
            if (OutboxScreen$lambda$5 != null) {
                startRestartGroup.startReplaceGroup(1209540470);
                ComposerKt.sourceInformation(startRestartGroup, "*167@7019L133,171@7178L23,163@6638L573");
                String tx = LangKt.tx("Удалить чек %s?", OutboxScreen$lambda$5.getBody().getTransactionId());
                String tx2 = LangKt.tx("Чек исчезнет с устройства и на сервер больше не попадёт: продажи в отчётах магазина не будет, а списанный остаток останется списанным. Удаляйте только тот чек, который сервер уже отверг по существу.", new Object[i5]);
                String tx3 = LangKt.tx("Да, удалить", new Object[i5]);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1269051176, "CC(remember):OutboxScreen.kt#9igjgp");
                boolean changedInstance = startRestartGroup.changedInstance(repo) | startRestartGroup.changedInstance(OutboxScreen$lambda$5);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue5 = new Function0() { // from class: uz.FonRo.pos.ui.more.OutboxScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit OutboxScreen$lambda$8$0$0;
                            OutboxScreen$lambda$8$0$0 = OutboxScreenKt.OutboxScreen$lambda$8$0$0(Repo.this, OutboxScreen$lambda$5);
                            return OutboxScreen$lambda$8$0$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                Function0 function0 = (Function0) rememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1269056154, "CC(remember):OutboxScreen.kt#9igjgp");
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue6 = new Function0() { // from class: uz.FonRo.pos.ui.more.OutboxScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit OutboxScreen$lambda$8$1$0;
                            OutboxScreen$lambda$8$1$0 = OutboxScreenKt.OutboxScreen$lambda$8$1$0(MutableState.this);
                            return OutboxScreen$lambda$8$1$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                SheetsKt.OxConfirmSheet(tx, tx2, tx3, null, function0, (Function0) rememberedValue6, startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 8);
                startRestartGroup = startRestartGroup;
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1209540469);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.more.OutboxScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OutboxScreenKt.OutboxScreen$lambda$9(FonRoApp.this, nav, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean OutboxScreen$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OutboxScreen$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final SaleOutbox.Pending OutboxScreen$lambda$5(MutableState<SaleOutbox.Pending> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OutboxScreen$lambda$7$0(final Context context, final CoroutineScope coroutineScope, final FonRoApp FonRoApp, final MutableState mutableState, final State state, final Repo repo, final MutableState mutableState2, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$OutboxScreenKt.INSTANCE.m10023getLambda$978938650$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$OutboxScreenKt.INSTANCE.getLambda$1417833693$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(2141124126, true, new Function3() { // from class: uz.FonRo.pos.ui.more.OutboxScreenKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit OutboxScreen$lambda$7$0$0;
                OutboxScreen$lambda$7$0$0 = OutboxScreenKt.OutboxScreen$lambda$7$0$0(context, coroutineScope, FonRoApp, mutableState, state, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return OutboxScreen$lambda$7$0$0;
            }
        }), 3, null);
        if (OutboxScreen$lambda$0(state).isEmpty()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$OutboxScreenKt.INSTANCE.getLambda$1099129857$app(), 3, null);
        } else {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1594198154, true, new Function3() { // from class: uz.FonRo.pos.ui.more.OutboxScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OutboxScreen$lambda$7$0$1;
                    OutboxScreen$lambda$7$0$1 = OutboxScreenKt.OutboxScreen$lambda$7$0$1(State.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OutboxScreen$lambda$7$0$1;
                }
            }), 3, null);
            final List<SaleOutbox.Pending> OutboxScreen$lambda$0 = OutboxScreen$lambda$0(state);
            final Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.more.OutboxScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object OutboxScreen$lambda$7$0$2;
                    OutboxScreen$lambda$7$0$2 = OutboxScreenKt.OutboxScreen$lambda$7$0$2((SaleOutbox.Pending) obj);
                    return OutboxScreen$lambda$7$0$2;
                }
            };
            final OutboxScreenKt$OutboxScreen$lambda$7$0$$inlined$items$default$1 outboxScreenKt$OutboxScreen$lambda$7$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.more.OutboxScreenKt$OutboxScreen$lambda$7$0$$inlined$items$default$1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(SaleOutbox.Pending pending) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((SaleOutbox.Pending) obj);
                }
            };
            LazyColumn.items(OutboxScreen$lambda$0.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.more.OutboxScreenKt$OutboxScreen$lambda$7$0$$inlined$items$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i) {
                    return Function1.this.invoke(OutboxScreen$lambda$0.get(i));
                }
            }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.more.OutboxScreenKt$OutboxScreen$lambda$7$0$$inlined$items$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i) {
                    return Function1.this.invoke(OutboxScreen$lambda$0.get(i));
                }
            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.more.OutboxScreenKt$OutboxScreen$lambda$7$0$$inlined$items$default$4
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
                    final SaleOutbox.Pending pending = (SaleOutbox.Pending) OutboxScreen$lambda$0.get(i);
                    composer.startReplaceGroup(-1709537838);
                    ComposerKt.sourceInformation(composer, "C*156@6520L26,153@6382L182:OutboxScreen.kt#1sifzz");
                    String money = repo.money(Double.valueOf(pending.getTotal()));
                    ComposerKt.sourceInformationMarkerStart(composer, -1163520779, "CC(remember):OutboxScreen.kt#9igjgp");
                    boolean changedInstance = composer.changedInstance(pending);
                    Object rememberedValue = composer.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        final MutableState mutableState3 = mutableState2;
                        rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.more.OutboxScreenKt$OutboxScreen$1$1$4$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                mutableState3.setValue(SaleOutbox.Pending.this);
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    OutboxScreenKt.PendingCard(pending, money, (Function0) rememberedValue, composer, SaleOutbox.Pending.$stable);
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
    public static final Unit OutboxScreen$lambda$7$0$0(final Context context, final CoroutineScope coroutineScope, final FonRoApp FonRoApp, final MutableState mutableState, State state, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C112@4602L1105,110@4486L1397,138@5896L11:OutboxScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2141124126, i, -1, "uz.FonRo.pos.ui.more.OutboxScreen.<anonymous>.<anonymous>.<anonymous> (OutboxScreen.kt:110)");
            }
            String tx = OutboxScreen$lambda$2(mutableState) ? LangKt.tx("Отправляем…", new Object[0]) : LangKt.tx("Отправить сейчас", new Object[0]);
            BtnStyle btnStyle = BtnStyle.PRIMARY;
            BtnSize btnSize = BtnSize.LG;
            boolean z = (OutboxScreen$lambda$2(mutableState) || OutboxScreen$lambda$0(state).isEmpty()) ? false : true;
            ComposerKt.sourceInformationMarkerStart(composer, 330955567, "CC(remember):OutboxScreen.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(context) | composer.changedInstance(coroutineScope) | composer.changedInstance(FonRoApp);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.more.OutboxScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit OutboxScreen$lambda$7$0$0$0$0;
                        OutboxScreen$lambda$7$0$0$0$0 = OutboxScreenKt.OutboxScreen$lambda$7$0$0$0$0(context, coroutineScope, mutableState, FonRoApp);
                        return OutboxScreen$lambda$7$0$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, null, btnStyle, btnSize, z, true, null, composer, 1600512, 132);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(16.0f), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OutboxScreen$lambda$7$0$0$0$0(Context context, CoroutineScope coroutineScope, MutableState mutableState, FonRoApp FonRoApp) {
        if (!OutboxScreen$lambda$2(mutableState)) {
            OutboxScreen$lambda$3(mutableState, true);
            BackgroundWork.INSTANCE.flushNow(context);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new OutboxScreenKt$OutboxScreen$1$1$1$1$1$1(FonRoApp, mutableState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OutboxScreen$lambda$7$0$1(State state, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C145@6037L243:OutboxScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1594198154, i, -1, "uz.FonRo.pos.ui.more.OutboxScreen.<anonymous>.<anonymous>.<anonymous> (OutboxScreen.kt:145)");
            }
            BasicsKt.OxSectionHead(LangKt.tx("В очереди", new Object[0]), null, LangKt.tx("Уйдут сами при появлении связи", new Object[0]), String.valueOf(OutboxScreen$lambda$0(state).size()), ChipTone.WARN, null, composer, 24576, 34);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object OutboxScreen$lambda$7$0$2(SaleOutbox.Pending it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getBody().getTransactionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OutboxScreen$lambda$8$0$0(Repo repo, SaleOutbox.Pending pending) {
        repo.getOutbox().remove(pending.getBody().getTransactionId());
        Toaster.INSTANCE.ok(LangKt.tx("Чек удалён из очереди", new Object[0]));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OutboxScreen$lambda$8$1$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EmptyOutbox(Composer composer, final int i) {
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1902486682);
        ComposerKt.sourceInformation(startRestartGroup, "C(EmptyOutbox)178@7265L732:OutboxScreen.kt#1sifzz");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1902486682, i, -1, "uz.FonRo.pos.ui.more.EmptyOutbox (OutboxScreen.kt:177)");
            }
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6989constructorimpl(26.0f), 1, null);
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, startRestartGroup, 48);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -535534526, "C182@7418L349,194@7776L11,195@7796L51,196@7856L10,197@7875L116:OutboxScreen.kt#1sifzz");
            Modifier m558backgroundbw27NRU$default = BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(58.0f)), OxShape.INSTANCE.getPill()), Ox.INSTANCE.m10212getOkSoft0d7_KjU(), null, 2, null);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -643302819, "C189@7621L136:OutboxScreen.kt#1sifzz");
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getOk(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(32.0f)), Ox.INSTANCE.m10211getOk0d7_KjU(), startRestartGroup, 432, 0);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), startRestartGroup, 6);
            composer2 = startRestartGroup;
            TextKt.m2798Text4IGK_g(LangKt.tx("Все чеки отправлены.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH3(), composer2, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(4.0f), composer2, 6);
            TextKt.m2798Text4IGK_g(LangKt.tx("Очередь пуста — ни одна продажа не потерялась.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer2, 0, 0, 65534);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.more.OutboxScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OutboxScreenKt.EmptyOutbox$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PendingCard(final SaleOutbox.Pending pending, final String str, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(307225583);
        ComposerKt.sourceInformation(startRestartGroup, "C(PendingCard)P(2)210@8179L1367,210@8123L1423:OutboxScreen.kt#1sifzz");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(pending) : startRestartGroup.changedInstance(pending) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(307225583, i2, -1, "uz.FonRo.pos.ui.more.PendingCard (OutboxScreen.kt:209)");
            }
            BasicsKt.m9833OxSoftCardCe4qNIY(PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(10.0f), 7, null), 0.0f, null, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-905209303, true, new Function3() { // from class: uz.FonRo.pos.ui.more.OutboxScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OutboxScreenKt.PendingCard$lambda$0(SaleOutbox.Pending.this, function0, str, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, 1572870, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.more.OutboxScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OutboxScreenKt.PendingCard$lambda$1(SaleOutbox.Pending.this, str, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PendingCard$lambda$0(SaleOutbox.Pending pending, Function0 function0, String str, ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C211@8189L484,223@8683L10,224@8702L402,242@9338L11,243@9358L182:OutboxScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-905209303, i, -1, "uz.FonRo.pos.ui.more.PendingCard.<anonymous> (OutboxScreen.kt:211)");
            }
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
            ComposerKt.sourceInformationMarkerStart(composer, -1707810234, "C212@8255L359,220@8627L36:OutboxScreen.kt#1sifzz");
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
            ComposerKt.sourceInformationMarkerStart(composer, 1351869705, "C213@8301L223,218@8541L59:OutboxScreen.kt#1sifzz");
            TextKt.m2798Text4IGK_g(pending.getBody().getTransactionId(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowTitle(), 0L, 0L, FontWeight.INSTANCE.getExtraBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 0, 3120, 55294);
            TextKt.m2798Text4IGK_g(createdText(pending.getCreatedAt()), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 0, 0, 65534);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m2798Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowPrice(), composer, 0, 0, 65534);
            Composer composer2 = composer;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer2, 6);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(6.0f));
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer2, 6);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, companion2);
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
            ComposerKt.sourceInformationMarkerStart(composer2, -686937773, "C225@8772L97:OutboxScreen.kt#1sifzz");
            BasicsKt.OxChip(Fmt.INSTANCE.plural(pending.getItemsCount(), LangKt.tx("позиция", new Object[0]), LangKt.tx("позиции", new Object[0]), LangKt.tx("позиций", new Object[0])), ChipTone.DIM, null, composer2, 48, 4);
            if (pending.getAttempts() > 0) {
                composer2.startReplaceGroup(-686807078);
                ComposerKt.sourceInformation(composer2, "227@8926L154");
                BasicsKt.OxChip(Fmt.INSTANCE.plural(pending.getAttempts(), LangKt.tx("попытка", new Object[0]), LangKt.tx("попытки", new Object[0]), LangKt.tx("попыток", new Object[0])), ChipTone.WARN, null, composer2, 48, 4);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-686628332);
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            String lastError = pending.getLastError();
            if (lastError != null && !StringsKt.isBlank(lastError)) {
                composer2.startReplaceGroup(1010278507);
                ComposerKt.sourceInformation(composer2, "235@9168L10,236@9191L127");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer2, 6);
                String lastError2 = pending.getLastError();
                if (lastError2 == null) {
                    lastError2 = "";
                }
                TextKt.m2798Text4IGK_g(lastError2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), Ox.INSTANCE.m10196getDanger0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(1010445721);
                composer2.endReplaceGroup();
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer2, 6);
            BasicsKt.OxButton(LangKt.tx("Удалить чек", new Object[0]), function0, null, BtnStyle.DANGER, BtnSize.SM, false, true, null, composer, 1600512, 164);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final String createdText(long j) {
        Object m7870constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(Fmt.dt$default(Fmt.INSTANCE, Instant.ofEpochMilli(j).atZone(Fmt.INSTANCE.getSTORE_ZONE()).toLocalDateTime().toString(), false, 2, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7876isFailureimpl(m7870constructorimpl)) {
            m7870constructorimpl = "—";
        }
        return (String) m7870constructorimpl;
    }

    private static final List<SaleOutbox.Pending> OutboxScreen$lambda$0(State<? extends List<SaleOutbox.Pending>> state) {
        return state.getValue();
    }
}
