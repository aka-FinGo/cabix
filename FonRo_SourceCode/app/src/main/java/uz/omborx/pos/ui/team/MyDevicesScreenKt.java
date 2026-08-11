package uz.FonRo.pos.ui.team;

import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.data.model.WorkerDevice;
import uz.FonRo.pos.data.repo.AuthRepository;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnSize;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.ChipTone;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.nav.AppNavigator;
import uz.FonRo.pos.ui.theme.OxDim;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: MyDevicesScreen.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0006\u001a\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001aI\u0010\u000f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0001b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\u0010\u0016¨\u0006\u0002²\u0006\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0018X\u008a\u008e\u0002²\u0006\n\u0010\u0019\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010\u001a\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\f\u0010\u001b\u001a\u0004\u0018\u00010\u000eX\u008a\u008e\u0002"}, d2 = {"MyDevicesScreen", "", "app", "Luz/FonRo/pos/FonRoApp;", "nav", "Luz/FonRo/pos/ui/nav/AppNavigator;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/nav/AppNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "deviceTitle", "", "device", "Luz/FonRo/pos/data/model/WorkerDevice;", "DeviceCard", "isThisDevice", "", "onRevoke", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Luz/FonRo/pos/data/model/WorkerDevice;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "devices", "", "loading", "failed", "confirmRevoke"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class MyDevicesScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DeviceCard$lambda$1(WorkerDevice workerDevice, boolean z, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DeviceCard(workerDevice, z, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MyDevicesScreen$lambda$19(FonRoApp FonRoApp, AppNavigator appNavigator, int i, Composer composer, int i2) {
        MyDevicesScreen(FonRoApp, appNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void MyDevicesScreen(final FonRoApp app, final AppNavigator nav, Composer composer, final int i) {
        int i2;
        final MutableState mutableState;
        final MutableState mutableState2;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(nav, "nav");
        Composer startRestartGroup = composer.startRestartGroup(136876695);
        ComposerKt.sourceInformation(startRestartGroup, "C(MyDevicesScreen)53@2109L24,55@2154L60,56@2234L33,57@2286L34,58@2346L48,60@2417L32,82@3015L10,82@2994L31,87@3183L1567,84@3031L1719:MyDevicesScreen.kt#1se6wn");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(136876695, i2, -1, "uz.FonRo.pos.ui.team.MyDevicesScreen (MyDevicesScreen.kt:50)");
            }
            Repo repo = app.getRepo();
            final AuthRepository auth = app.getAuth();
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1605476909, "CC(remember):MyDevicesScreen.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1605474376, "CC(remember):MyDevicesScreen.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1605472711, "CC(remember):MyDevicesScreen.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState5 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1605470777, "CC(remember):MyDevicesScreen.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            MutableState mutableState6 = (MutableState) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1605468521, "CC(remember):MyDevicesScreen.kt#9igjgp");
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = repo.getPrefs().getDeviceId();
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            final String str = (String) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1605449407, "CC(remember):MyDevicesScreen.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(auth);
            MyDevicesScreenKt$MyDevicesScreen$1$1 rememberedValue7 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                MyDevicesScreenKt$MyDevicesScreen$1$1 myDevicesScreenKt$MyDevicesScreen$1$1 = new MyDevicesScreenKt$MyDevicesScreen$1$1(mutableState4, auth, mutableState3, mutableState5, null);
                mutableState3 = mutableState3;
                mutableState5 = mutableState5;
                rememberedValue7 = myDevicesScreenKt$MyDevicesScreen$1$1;
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue7, startRestartGroup, 6);
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), OxDim.INSTANCE.m10245getPagePadD9Ej5fM(), 0.0f, 2, null);
            PaddingValues m1046PaddingValuesa9UjIt4$default = PaddingKt.m1046PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(28.0f), 7, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1605442474, "CC(remember):MyDevicesScreen.kt#9igjgp");
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState6;
                Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.team.MyDevicesScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit MyDevicesScreen$lambda$17$0;
                        MyDevicesScreen$lambda$17$0 = MyDevicesScreenKt.MyDevicesScreen$lambda$17$0(MutableState.this, mutableState3, mutableState5, str, mutableState, (LazyListScope) obj);
                        return MyDevicesScreen$lambda$17$0;
                    }
                };
                mutableState2 = mutableState4;
                startRestartGroup.updateRememberedValue(function1);
                rememberedValue8 = function1;
            } else {
                mutableState = mutableState6;
                mutableState2 = mutableState4;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final MutableState mutableState7 = mutableState;
            LazyDslKt.LazyColumn(m1051paddingVpY3zN4$default, null, m1046PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) rememberedValue8, startRestartGroup, 805306752, TypedValues.PositionType.TYPE_PERCENT_X);
            final WorkerDevice MyDevicesScreen$lambda$10 = MyDevicesScreen$lambda$10(mutableState7);
            if (MyDevicesScreen$lambda$10 != null) {
                startRestartGroup.startReplaceGroup(1772430103);
                ComposerKt.sourceInformation(startRestartGroup, "*141@5091L18,142@5135L24,136@4795L374");
                String tx = LangKt.tx("Отвязать устройство?", new Object[0]);
                String str2 = LangKt.tx("«%s» сразу потеряет доступ. ", deviceTitle(MyDevicesScreen$lambda$10)) + LangKt.tx("Войти с него снова можно будет тем же ключом — слот освободится.", new Object[0]);
                String tx2 = LangKt.tx("Отвязать", new Object[0]);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2101454670, "CC(remember):MyDevicesScreen.kt#9igjgp");
                boolean changedInstance2 = startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(auth) | startRestartGroup.changedInstance(MyDevicesScreen$lambda$10);
                Object rememberedValue9 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState8 = mutableState3;
                    final MutableState mutableState9 = mutableState5;
                    Function0 function0 = new Function0() { // from class: uz.FonRo.pos.ui.team.MyDevicesScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit MyDevicesScreen$lambda$18$0$0;
                            MyDevicesScreen$lambda$18$0$0 = MyDevicesScreenKt.MyDevicesScreen$lambda$18$0$0(WorkerDevice.this, coroutineScope, auth, mutableState2, mutableState8, mutableState9);
                            return MyDevicesScreen$lambda$18$0$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(function0);
                    rememberedValue9 = function0;
                }
                Function0 function02 = (Function0) rememberedValue9;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2101456084, "CC(remember):MyDevicesScreen.kt#9igjgp");
                Object rememberedValue10 = startRestartGroup.rememberedValue();
                if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue10 = new Function0() { // from class: uz.FonRo.pos.ui.team.MyDevicesScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit MyDevicesScreen$lambda$18$1$0;
                            MyDevicesScreen$lambda$18$1$0 = MyDevicesScreenKt.MyDevicesScreen$lambda$18$1$0(MutableState.this);
                            return MyDevicesScreen$lambda$18$1$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue10);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                SheetsKt.OxConfirmSheet(tx, str2, tx2, null, function02, (Function0) rememberedValue10, startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 8);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1772430102);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.team.MyDevicesScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MyDevicesScreenKt.MyDevicesScreen$lambda$19(FonRoApp.this, nav, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final List<WorkerDevice> MyDevicesScreen$lambda$1(MutableState<List<WorkerDevice>> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean MyDevicesScreen$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void MyDevicesScreen$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean MyDevicesScreen$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void MyDevicesScreen$lambda$8(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final WorkerDevice MyDevicesScreen$lambda$10(MutableState<WorkerDevice> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(11:5|6|7|(1:(2:10|11)(2:23|24))(3:25|26|(1:28))|12|13|(1:15)|16|(1:18)|19|20))|31|6|7|(0)(0)|12|13|(0)|16|(0)|19|20) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0068, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0069, code lost:
    
        r8 = kotlin.Result.INSTANCE;
        r5 = kotlin.Result.m7870constructorimpl(kotlin.ResultKt.createFailure(r5));
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object MyDevicesScreen$load(androidx.compose.runtime.MutableState<java.lang.Boolean> r4, uz.FonRo.pos.data.repo.AuthRepository r5, androidx.compose.runtime.MutableState<java.util.List<uz.FonRo.pos.data.model.WorkerDevice>> r6, androidx.compose.runtime.MutableState<java.lang.Boolean> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof uz.FonRo.pos.ui.team.MyDevicesScreenKt$MyDevicesScreen$load$1
            if (r0 == 0) goto L14
            r0 = r8
            uz.FonRo.pos.ui.team.MyDevicesScreenKt$MyDevicesScreen$load$1 r0 = (uz.FonRo.pos.ui.team.MyDevicesScreenKt$MyDevicesScreen$load$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            uz.FonRo.pos.ui.team.MyDevicesScreenKt$MyDevicesScreen$load$1 r0 = new uz.FonRo.pos.ui.team.MyDevicesScreenKt$MyDevicesScreen$load$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r4 = r0.L$3
            r7 = r4
            androidx.compose.runtime.MutableState r7 = (androidx.compose.runtime.MutableState) r7
            java.lang.Object r4 = r0.L$2
            r6 = r4
            androidx.compose.runtime.MutableState r6 = (androidx.compose.runtime.MutableState) r6
            java.lang.Object r4 = r0.L$1
            uz.FonRo.pos.data.repo.AuthRepository r4 = (uz.FonRo.pos.data.repo.AuthRepository) r4
            java.lang.Object r4 = r0.L$0
            androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L68
            goto L61
        L3c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L44:
            kotlin.ResultKt.throwOnFailure(r8)
            MyDevicesScreen$lambda$5(r4, r3)
            kotlin.Result$Companion r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L68
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L68
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)     // Catch: java.lang.Throwable -> L68
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L68
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L68
            r0.L$3 = r7     // Catch: java.lang.Throwable -> L68
            r0.label = r3     // Catch: java.lang.Throwable -> L68
            java.lang.Object r8 = r5.myDevices(r0)     // Catch: java.lang.Throwable -> L68
            if (r8 != r1) goto L61
            return r1
        L61:
            java.util.List r8 = (java.util.List) r8     // Catch: java.lang.Throwable -> L68
            java.lang.Object r5 = kotlin.Result.m7870constructorimpl(r8)     // Catch: java.lang.Throwable -> L68
            goto L73
        L68:
            r5 = move-exception
            kotlin.Result$Companion r8 = kotlin.Result.INSTANCE
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m7870constructorimpl(r5)
        L73:
            boolean r8 = kotlin.Result.m7877isSuccessimpl(r5)
            r0 = 0
            if (r8 == 0) goto L83
            r8 = r5
            java.util.List r8 = (java.util.List) r8
            MyDevicesScreen$lambda$2(r6, r8)
            MyDevicesScreen$lambda$8(r7, r0)
        L83:
            java.lang.Throwable r5 = kotlin.Result.m7873exceptionOrNullimpl(r5)
            if (r5 == 0) goto L91
            MyDevicesScreen$lambda$8(r7, r3)
            uz.FonRo.pos.ui.Toaster r6 = uz.FonRo.pos.ui.Toaster.INSTANCE
            r6.error(r5)
        L91:
            MyDevicesScreen$lambda$5(r4, r0)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.team.MyDevicesScreenKt.MyDevicesScreen$load(androidx.compose.runtime.MutableState, uz.FonRo.pos.data.repo.AuthRepository, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final void MyDevicesScreen$revoke(CoroutineScope coroutineScope, AuthRepository authRepository, MutableState<Boolean> mutableState, MutableState<List<WorkerDevice>> mutableState2, MutableState<Boolean> mutableState3, WorkerDevice workerDevice) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MyDevicesScreenKt$MyDevicesScreen$revoke$1(authRepository, workerDevice, mutableState, mutableState2, mutableState3, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MyDevicesScreen$lambda$17$0(final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final String str, final MutableState mutableState4, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$MyDevicesScreenKt.INSTANCE.getLambda$2031017196$app(), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1651466333, true, new Function3() { // from class: uz.FonRo.pos.ui.team.MyDevicesScreenKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit MyDevicesScreen$lambda$17$0$0;
                MyDevicesScreen$lambda$17$0$0 = MyDevicesScreenKt.MyDevicesScreen$lambda$17$0$0(MutableState.this, mutableState2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return MyDevicesScreen$lambda$17$0$0;
            }
        }), 3, null);
        if (MyDevicesScreen$lambda$1(mutableState2).isEmpty()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1578937287, true, new Function3() { // from class: uz.FonRo.pos.ui.team.MyDevicesScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit MyDevicesScreen$lambda$17$0$1;
                    MyDevicesScreen$lambda$17$0$1 = MyDevicesScreenKt.MyDevicesScreen$lambda$17$0$1(MutableState.this, mutableState3, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return MyDevicesScreen$lambda$17$0$1;
                }
            }), 3, null);
        }
        final List<WorkerDevice> MyDevicesScreen$lambda$1 = MyDevicesScreen$lambda$1(mutableState2);
        final Function1 function1 = new Function1() { // from class: uz.FonRo.pos.ui.team.MyDevicesScreenKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object MyDevicesScreen$lambda$17$0$2;
                MyDevicesScreen$lambda$17$0$2 = MyDevicesScreenKt.MyDevicesScreen$lambda$17$0$2((WorkerDevice) obj);
                return MyDevicesScreen$lambda$17$0$2;
            }
        };
        final MyDevicesScreenKt$MyDevicesScreen$lambda$17$0$$inlined$items$default$1 myDevicesScreenKt$MyDevicesScreen$lambda$17$0$$inlined$items$default$1 = new Function1() { // from class: uz.FonRo.pos.ui.team.MyDevicesScreenKt$MyDevicesScreen$lambda$17$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(WorkerDevice workerDevice) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((WorkerDevice) obj);
            }
        };
        LazyColumn.items(MyDevicesScreen$lambda$1.size(), new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.team.MyDevicesScreenKt$MyDevicesScreen$lambda$17$0$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(MyDevicesScreen$lambda$1.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: uz.FonRo.pos.ui.team.MyDevicesScreenKt$MyDevicesScreen$lambda$17$0$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return Function1.this.invoke(MyDevicesScreen$lambda$1.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: uz.FonRo.pos.ui.team.MyDevicesScreenKt$MyDevicesScreen$lambda$17$0$$inlined$items$default$4
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
                final WorkerDevice workerDevice = (WorkerDevice) MyDevicesScreen$lambda$1.get(i);
                composer.startReplaceGroup(-1918202073);
                ComposerKt.sourceInformation(composer, "C*118@4149L26,115@4015L234:MyDevicesScreen.kt#1se6wn");
                boolean areEqual = Intrinsics.areEqual(workerDevice.getDeviceId(), str);
                ComposerKt.sourceInformationMarkerStart(composer, -1862988724, "CC(remember):MyDevicesScreen.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(workerDevice);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState5 = mutableState4;
                    rememberedValue = (Function0) new Function0<Unit>() { // from class: uz.FonRo.pos.ui.team.MyDevicesScreenKt$MyDevicesScreen$2$1$4$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            mutableState5.setValue(WorkerDevice.this);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                MyDevicesScreenKt.DeviceCard(workerDevice, areEqual, (Function0) rememberedValue, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(8.0f), 7, null), composer, WorkerDevice.$stable | 3072, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$MyDevicesScreenKt.INSTANCE.m10165getLambda$1479052252$app(), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MyDevicesScreen$lambda$17$0$0(MutableState mutableState, MutableState mutableState2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C96@3384L144:MyDevicesScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1651466333, i, -1, "uz.FonRo.pos.ui.team.MyDevicesScreen.<anonymous>.<anonymous>.<anonymous> (MyDevicesScreen.kt:96)");
            }
            BasicsKt.OxSectionHead(LangKt.tx("Активные входы", new Object[0]), null, null, MyDevicesScreen$lambda$4(mutableState) ? "…" : String.valueOf(MyDevicesScreen$lambda$1(mutableState2).size()), null, null, composer, 0, 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MyDevicesScreen$lambda$17$0$1(MutableState mutableState, MutableState mutableState2, LazyItemScope item, Composer composer, int i) {
        String tx;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C104@3608L317:MyDevicesScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1578937287, i, -1, "uz.FonRo.pos.ui.team.MyDevicesScreen.<anonymous>.<anonymous>.<anonymous> (MyDevicesScreen.kt:104)");
            }
            if (MyDevicesScreen$lambda$4(mutableState)) {
                tx = LangKt.tx("Загружаем список…", new Object[0]);
            } else {
                tx = MyDevicesScreen$lambda$7(mutableState2) ? LangKt.tx("Список устройств не загрузился. Проверьте соединение.", new Object[0]) : LangKt.tx("Устройств нет — ключ ещё нигде не активирован.", new Object[0]);
            }
            BasicsKt.OxEmptyNote(tx, null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object MyDevicesScreen$lambda$17$0$2(WorkerDevice it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MyDevicesScreen$lambda$18$0$0(WorkerDevice workerDevice, CoroutineScope coroutineScope, AuthRepository authRepository, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        MyDevicesScreen$revoke(coroutineScope, authRepository, mutableState, mutableState2, mutableState3, workerDevice);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MyDevicesScreen$lambda$18$1$0(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    public static final String deviceTitle(WorkerDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        String deviceName = device.getDeviceName();
        if (deviceName != null) {
            if (StringsKt.isBlank(deviceName)) {
                deviceName = null;
            }
            if (deviceName != null) {
                return deviceName;
            }
        }
        return LangKt.tx("Устройство", new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void DeviceCard(final uz.FonRo.pos.data.model.WorkerDevice r16, final boolean r17, final kotlin.jvm.functions.Function0<kotlin.Unit> r18, androidx.compose.ui.Modifier r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.team.MyDevicesScreenKt.DeviceCard(uz.FonRo.pos.data.model.WorkerDevice, boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DeviceCard$lambda$0(boolean z, Function0 function0, WorkerDevice workerDevice, ColumnScope OxCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCard, "$this$OxCard");
        ComposerKt.sourceInformation(composer, "C163@5742L1041:MyDevicesScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1852577418, i, -1, "uz.FonRo.pos.ui.team.DeviceCard.<anonymous> (MyDevicesScreen.kt:163)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1825427177, "C168@5943L490:MyDevicesScreen.kt#1se6wn");
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
            ComposerKt.sourceInformationMarkerStart(composer, -1955725455, "C169@5989L196,175@6202L217:MyDevicesScreen.kt#1se6wn");
            TextKt.m2798Text4IGK_g(deviceTitle(workerDevice), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowTitle(), composer, 0, 3120, 55294);
            TextKt.m2798Text4IGK_g(LangKt.tx("Заходили: ", new Object[0]) + Fmt.dt$default(Fmt.INSTANCE, workerDevice.getLastSeen(), false, 2, null), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6925getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getRowSub(), composer, 0, 3120, 55294);
            Composer composer2 = composer;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (z) {
                composer2.startReplaceGroup(-1824933813);
                ComposerKt.sourceInformation(composer2, "183@6482L41");
                BasicsKt.OxChip(LangKt.tx("Это устройство", new Object[0]), ChipTone.OK, null, composer2, 48, 4);
                composer2.endReplaceGroup();
            } else if (function0 != null) {
                composer2.startReplaceGroup(-1824829436);
                ComposerKt.sourceInformation(composer2, "185@6583L176");
                BasicsKt.OxButton(LangKt.tx("Отвязать", new Object[0]), function0, null, BtnStyle.DANGER, BtnSize.SM, false, false, null, composer, 27648, 228);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-1824629548);
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
}
