package uz.FonRo.pos.ui.components;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;

/* compiled from: Chips.kt */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a_\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007b\u0002\b\u0010b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013¢\u0006\u0004\b\u000e\u0010\u000f\u001aG\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\u001c\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0018H\u0007b\u0002\b\u0010b\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c¢\u0006\u0002\u0010\u0019\u001ai\u0010\u001d\u001a\u00020\u00012\u0018\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030 0\u001f2\u0006\u0010!\u001a\u00020\u00032\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00162\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010#\u001a\u00020\u0005H\u0007b\u0002\b\u0010b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013¢\u0006\u0002\u0010$\u001a\u0087\u0001\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00010\u00162\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001a\b\u0002\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0 0\u001f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007b\u0002\b\u0010b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013¢\u0006\u0002\u0010,¨\u0006-"}, d2 = {"OxCatChip", "", "text", "", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "tint", "Luz/FonRo/pos/ui/components/ChipTint;", "dotColor", "Landroidx/compose/ui/graphics/Color;", "OxCatChip-FV1VA1c", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Luz/FonRo/pos/ui/components/ChipTint;Landroidx/compose/ui/graphics/Color;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "OxChipRow", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/runtime/ComposableInferredTarget;", "scheme", "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]", "OxSegControl", FirebaseAnalytics.Param.ITEMS, "", "Lkotlin/Pair;", "activeKey", "onChange", "fill", "(Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "OxPeriodChips", "state", "Luz/FonRo/pos/ui/components/PeriodState;", "presets", "Luz/FonRo/pos/ui/components/PeriodKind;", "onPickMonth", "onPickDate", "(Luz/FonRo/pos/ui/components/PeriodState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Luz/FonRo/pos/ui/components/ChipTint;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ChipsKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxCatChip_FV1VA1c$lambda$1(String str, boolean z, Function0 function0, Modifier modifier, ChipTint chipTint, Color color, int i, int i2, Composer composer, int i3) {
        m9837OxCatChipFV1VA1c(str, z, function0, modifier, chipTint, color, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxChipRow$lambda$0(Modifier modifier, Function3 function3, int i, int i2, Composer composer, int i3) {
        OxChipRow(modifier, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxPeriodChips$lambda$1(PeriodState periodState, Function1 function1, Modifier modifier, ChipTint chipTint, List list, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        OxPeriodChips(periodState, function1, modifier, chipTint, list, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxSegControl$lambda$1(List list, String str, Function1 function1, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        OxSegControl(list, str, function1, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0074  */
    /* renamed from: OxCatChip-FV1VA1c, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m9837OxCatChipFV1VA1c(final java.lang.String r58, final boolean r59, final kotlin.jvm.functions.Function0<kotlin.Unit> r60, androidx.compose.ui.Modifier r61, uz.FonRo.pos.ui.components.ChipTint r62, androidx.compose.ui.graphics.Color r63, androidx.compose.runtime.Composer r64, final int r65, final int r66) {
        /*
            Method dump skipped, instructions count: 984
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.ChipsKt.m9837OxCatChipFV1VA1c(java.lang.String, boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, uz.FonRo.pos.ui.components.ChipTint, androidx.compose.ui.graphics.Color, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void OxChipRow(Modifier modifier, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Modifier.Companion companion;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-848137175);
        ComposerKt.sourceInformation(startRestartGroup, "C(OxChipRow)P(1)81@2891L21,82@2917L240:Chips.kt#r5y9fm");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
            companion = modifier2;
        } else {
            companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-848137175, i3, -1, "uz.FonRo.pos.ui.components.OxChipRow (Chips.kt:80)");
            }
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(ScrollKt.horizontalScroll$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, null, false, 14, null), 0.0f, Dp.m6989constructorimpl(2.0f), 0.0f, Dp.m6989constructorimpl(10.0f), 5, null);
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            int i5 = ((i3 << 6) & 7168) | 48;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getTop(), startRestartGroup, 6);
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
            content.invoke(RowScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf(((i5 >> 6) & 112) | 6));
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.components.ChipsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipsKt.OxChipRow$lambda$0(Modifier.this, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OxSegControl(final java.util.List<kotlin.Pair<java.lang.String, java.lang.String>> r68, final java.lang.String r69, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r70, androidx.compose.ui.Modifier r71, boolean r72, androidx.compose.runtime.Composer r73, final int r74, final int r75) {
        /*
            Method dump skipped, instructions count: 1107
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.ChipsKt.OxSegControl(java.util.List, java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxSegControl$lambda$0$0$0$0(boolean z, Function1 function1, String str) {
        if (!z) {
            function1.invoke(str);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OxPeriodChips(final uz.FonRo.pos.ui.components.PeriodState r16, final kotlin.jvm.functions.Function1<? super uz.FonRo.pos.ui.components.PeriodState, kotlin.Unit> r17, androidx.compose.ui.Modifier r18, uz.FonRo.pos.ui.components.ChipTint r19, java.util.List<? extends kotlin.Pair<java.lang.String, ? extends uz.FonRo.pos.ui.components.PeriodKind>> r20, final kotlin.jvm.functions.Function0<kotlin.Unit> r21, final kotlin.jvm.functions.Function0<kotlin.Unit> r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.ChipsKt.OxPeriodChips(uz.FonRo.pos.ui.components.PeriodState, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, uz.FonRo.pos.ui.components.ChipTint, java.util.List, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxPeriodChips$lambda$0(List list, final PeriodState periodState, Function0 function0, ChipTint chipTint, Function0 function02, final Function1 function1, RowScope OxChipRow, Composer composer, int i) {
        String tx;
        String tx2;
        String str;
        boolean z;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(OxChipRow, "$this$OxChipRow");
        ComposerKt.sourceInformation(composer2, "C214@7978L279,221@8266L278:Chips.kt#r5y9fm");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1248320460, i, -1, "uz.FonRo.pos.ui.components.OxPeriodChips.<anonymous> (Chips.kt:206)");
            }
            composer2.startReplaceGroup(-1340085659);
            ComposerKt.sourceInformation(composer2, "*211@7908L37,207@7767L192");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                String str2 = (String) pair.component1();
                final PeriodKind periodKind = (PeriodKind) pair.component2();
                if (periodState.getKind() == periodKind) {
                    str = str2;
                    z = true;
                } else {
                    str = str2;
                    z = false;
                }
                ComposerKt.sourceInformationMarkerStart(composer2, -1091381198, "CC(remember):Chips.kt#9igjgp");
                boolean changed = composer2.changed(function1) | composer2.changed(periodState) | composer2.changed(periodKind.ordinal());
                Object rememberedValue = composer2.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.components.ChipsKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit OxPeriodChips$lambda$0$0$0$0;
                            OxPeriodChips$lambda$0$0$0$0 = ChipsKt.OxPeriodChips$lambda$0$0$0$0(Function1.this, periodState, periodKind);
                            return OxPeriodChips$lambda$0$0$0$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                m9837OxCatChipFV1VA1c(str, z, (Function0) rememberedValue, null, chipTint, null, composer, 0, 40);
                composer2 = composer;
            }
            composer.endReplaceGroup();
            if (periodState.getKind() == PeriodKind.MONTH) {
                tx = "🗓 " + Fmt.INSTANCE.monthTitle(periodState.getMonth());
            } else {
                tx = LangKt.tx("🗓 Месяц", new Object[0]);
            }
            m9837OxCatChipFV1VA1c(tx, periodState.getKind() == PeriodKind.MONTH, function0, null, chipTint, null, composer, 0, 40);
            if (periodState.getKind() == PeriodKind.DATE) {
                tx2 = "🗓 " + Fmt.INSTANCE.dt(periodState.getDate(), false);
            } else {
                tx2 = LangKt.tx("🗓 Календарь", new Object[0]);
            }
            m9837OxCatChipFV1VA1c(tx2, periodState.getKind() == PeriodKind.DATE, function02, null, chipTint, null, composer, 0, 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OxPeriodChips$lambda$0$0$0$0(Function1 function1, PeriodState periodState, PeriodKind periodKind) {
        function1.invoke(PeriodState.copy$default(periodState, periodKind, null, null, 6, null));
        return Unit.INSTANCE;
    }
}
