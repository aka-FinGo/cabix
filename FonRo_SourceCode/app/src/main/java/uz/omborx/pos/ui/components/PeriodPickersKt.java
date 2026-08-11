package uz.FonRo.pos.ui.components;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.DatePickerDialog_androidKt;
import androidx.compose.material3.DatePickerKt;
import androidx.compose.material3.DatePickerState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
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
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.ZoneOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.TextScaleKt;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: PeriodPickers.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aI\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007H\u0007b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010\b\u001aI\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007H\u0007b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¢\u0006\u0002\u0010\b¨\u0006\u000e"}, d2 = {"OxMonthSheet", "", "current", "", "onDismiss", "Lkotlin/Function0;", "onPick", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "OxDayPickerDialog", "app"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class PeriodPickersKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxDayPickerDialog$lambda$4(String str, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        OxDayPickerDialog(str, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxMonthSheet$lambda$1(String str, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        OxMonthSheet(str, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void OxMonthSheet(final String current, Function0<Unit> onDismiss, final Function1<? super String, Unit> onPick, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onPick, "onPick");
        Composer startRestartGroup = composer.startRestartGroup(-2047131976);
        ComposerKt.sourceInformation(startRestartGroup, "C(OxMonthSheet)36@1512L772,36@1451L833:PeriodPickers.kt#r5y9fm");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(current) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(onPick) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            function0 = onDismiss;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2047131976, i2, -1, "uz.FonRo.pos.ui.components.OxMonthSheet (PeriodPickers.kt:35)");
            }
            function0 = onDismiss;
            SheetsKt.OxSheet(LangKt.tx("Выберите месяц", new Object[0]), function0, null, false, null, ComposableLambdaKt.rememberComposableLambda(-2093975134, true, new Function3() { // from class: uz.FonRo.pos.ui.components.PeriodPickersKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PeriodPickersKt.OxMonthSheet$lambda$0(Function1.this, current, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, (i2 & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.components.PeriodPickersKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PeriodPickersKt.OxMonthSheet$lambda$1(current, function0, onPick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxMonthSheet$lambda$0(final Function1 function1, final String str, ColumnScope OxSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSheet, "$this$OxSheet");
        ComposerKt.sourceInformation(composer, "C41@1703L21,38@1602L657,57@2268L10:PeriodPickers.kt#r5y9fm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2093975134, i, -1, "uz.FonRo.pos.ui.components.OxMonthSheet.<anonymous> (PeriodPickers.kt:38)");
            }
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.m1084heightInVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m6989constructorimpl(420.0f), 1, null), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
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
            ComposerKt.sourceInformationMarkerStart(composer, -563110376, "C:PeriodPickers.kt#r5y9fm");
            List<String> lastMonths = Fmt.INSTANCE.lastMonths(18);
            composer.startReplaceGroup(2060046712);
            ComposerKt.sourceInformation(composer, "*47@1932L14,49@2035L182,45@1847L388");
            int i2 = 0;
            for (Object obj : lastMonths) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final String str2 = (String) obj;
                String monthTitle = Fmt.INSTANCE.monthTitle(str2);
                ComposerKt.sourceInformationMarkerStart(composer, -346610292, "CC(remember):PeriodPickers.kt#9igjgp");
                boolean changed = composer.changed(function1) | composer.changed(str2);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.components.PeriodPickersKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit OxMonthSheet$lambda$0$0$0$0$0;
                            OxMonthSheet$lambda$0$0$0$0$0 = PeriodPickersKt.OxMonthSheet$lambda$0$0$0$0$0(Function1.this, str2);
                            return OxMonthSheet$lambda$0$0$0$0$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                Function0 function0 = (Function0) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                BasicsKt.m9832OxRow1YH7lEI(monthTitle, null, null, function0, i2 < CollectionsKt.getLastIndex(lastMonths), 0L, null, ComposableLambdaKt.rememberComposableLambda(377932725, true, new Function3() { // from class: uz.FonRo.pos.ui.components.PeriodPickersKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        Unit OxMonthSheet$lambda$0$0$0$1;
                        OxMonthSheet$lambda$0$0$0$1 = PeriodPickersKt.OxMonthSheet$lambda$0$0$0$1(str2, str, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        return OxMonthSheet$lambda$0$0$0$1;
                    }
                }, composer, 54), composer, 12582912, 102);
                i2 = i3;
            }
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxMonthSheet$lambda$0$0$0$0$0(Function1 function1, String str) {
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxMonthSheet$lambda$0$0$0$1(String str, String str2, RowScope OxRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxRow, "$this$OxRow");
        ComposerKt.sourceInformation(composer, "C:PeriodPickers.kt#r5y9fm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(377932725, i, -1, "uz.FonRo.pos.ui.components.OxMonthSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PeriodPickers.kt:50)");
            }
            if (Intrinsics.areEqual(str, str2)) {
                composer.startReplaceGroup(1884575866);
                ComposerKt.sourceInformation(composer, "51@2110L59");
                TextKt.m2798Text4IGK_g("✓", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getRowPrice(), Ox.INSTANCE.m10220getPrimary0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 6, 0, 65534);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1884686381);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void OxDayPickerDialog(final String current, final Function0<Unit> onDismiss, final Function1<? super String, Unit> onPick, Composer composer, final int i) {
        int i2;
        Object m7870constructorimpl;
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onPick, "onPick");
        Composer startRestartGroup = composer.startRestartGroup(1114245341);
        ComposerKt.sourceInformation(startRestartGroup, "C(OxDayPickerDialog)67@2655L162,72@2834L60,76@2980L299,83@3305L61,84@3373L156,74@2900L629:PeriodPickers.kt#r5y9fm");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(current) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(onPick) ? 256 : 128;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1114245341, i3, -1, "uz.FonRo.pos.ui.components.OxDayPickerDialog (PeriodPickers.kt:64)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1342924287, "CC(remember):PeriodPickers.kt#9igjgp");
            boolean z = (i3 & 14) == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    m7870constructorimpl = Result.m7870constructorimpl(Long.valueOf(LocalDate.parse(current).atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m7870constructorimpl = Result.m7870constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m7876isFailureimpl(m7870constructorimpl)) {
                    m7870constructorimpl = null;
                }
                rememberedValue = (Long) m7870constructorimpl;
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final DatePickerState m2137rememberDatePickerStateEU0dCGE = DatePickerKt.m2137rememberDatePickerStateEU0dCGE((Long) rememberedValue, null, null, 0, null, startRestartGroup, 0, 30);
            DatePickerDialog_androidKt.m2129DatePickerDialogGmEhDVc(onDismiss, ComposableLambdaKt.rememberComposableLambda(-1477518097, true, new Function2() { // from class: uz.FonRo.pos.ui.components.PeriodPickersKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PeriodPickersKt.OxDayPickerDialog$lambda$1(DatePickerState.this, onDismiss, onPick, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, startRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-2022390671, true, new Function2() { // from class: uz.FonRo.pos.ui.components.PeriodPickersKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PeriodPickersKt.OxDayPickerDialog$lambda$2(Function0.this, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, startRestartGroup, 54), null, 0.0f, null, null, ComposableLambdaKt.rememberComposableLambda(1044726470, true, new Function3() { // from class: uz.FonRo.pos.ui.components.PeriodPickersKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PeriodPickersKt.OxDayPickerDialog$lambda$3(DatePickerState.this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i3 >> 3) & 14) | 100666416, 244);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.components.PeriodPickersKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PeriodPickersKt.OxDayPickerDialog$lambda$4(current, onDismiss, onPick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxDayPickerDialog$lambda$1(final DatePickerState datePickerState, final Function0 function0, final Function1 function1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C77@3019L223,77@2994L275:PeriodPickers.kt#r5y9fm");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1477518097, i, -1, "uz.FonRo.pos.ui.components.OxDayPickerDialog.<anonymous> (PeriodPickers.kt:77)");
            }
            String tx = LangKt.tx("Показать", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, 1739285230, "CC(remember):PeriodPickers.kt#9igjgp");
            boolean changed = composer.changed(datePickerState) | composer.changed(function0) | composer.changed(function1);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.components.PeriodPickersKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit OxDayPickerDialog$lambda$1$0$0;
                        OxDayPickerDialog$lambda$1$0$0 = PeriodPickersKt.OxDayPickerDialog$lambda$1$0$0(DatePickerState.this, function0, function1);
                        return OxDayPickerDialog$lambda$1$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, null, BtnStyle.PRIMARY, null, false, false, null, composer, 3072, 244);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxDayPickerDialog$lambda$1$0$0(DatePickerState datePickerState, Function0 function0, Function1 function1) {
        Long selectedDateMillis = datePickerState.getSelectedDateMillis();
        if (selectedDateMillis == null) {
            function0.invoke();
        } else {
            String localDate = Instant.ofEpochMilli(selectedDateMillis.longValue()).atZone(ZoneOffset.UTC).toLocalDate().toString();
            Intrinsics.checkNotNullExpressionValue(localDate, "toString(...)");
            function1.invoke(localDate);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxDayPickerDialog$lambda$2(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C83@3307L57:PeriodPickers.kt#r5y9fm");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2022390671, i, -1, "uz.FonRo.pos.ui.components.OxDayPickerDialog.<anonymous> (PeriodPickers.kt:83)");
            }
            BasicsKt.OxButton(LangKt.tx("Отмена", new Object[0]), function0, null, BtnStyle.GHOST, null, false, false, null, composer, 3072, 244);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxDayPickerDialog$lambda$3(final DatePickerState datePickerState, ColumnScope DatePickerDialog, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DatePickerDialog, "$this$DatePickerDialog");
        ComposerKt.sourceInformation(composer, "C86@3474L49,86@3461L62:PeriodPickers.kt#r5y9fm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1044726470, i, -1, "uz.FonRo.pos.ui.components.OxDayPickerDialog.<anonymous> (PeriodPickers.kt:86)");
            }
            TextScaleKt.OxTextScaled(ComposableLambdaKt.rememberComposableLambda(664468163, true, new Function2() { // from class: uz.FonRo.pos.ui.components.PeriodPickersKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OxDayPickerDialog$lambda$3$0;
                    OxDayPickerDialog$lambda$3$0 = PeriodPickersKt.OxDayPickerDialog$lambda$3$0(DatePickerState.this, (Composer) obj, ((Integer) obj2).intValue());
                    return OxDayPickerDialog$lambda$3$0;
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxDayPickerDialog$lambda$3$0(DatePickerState datePickerState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C87@3488L25:PeriodPickers.kt#r5y9fm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(664468163, i, -1, "uz.FonRo.pos.ui.components.OxDayPickerDialog.<anonymous>.<anonymous> (PeriodPickers.kt:87)");
            }
            DatePickerKt.DatePicker(datePickerState, null, null, null, null, false, null, composer, 0, WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
