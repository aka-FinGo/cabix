package uz.FonRo.pos.ui.components;

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
import androidx.compose.ui.draw.AlphaKt;
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
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import coil.disk.DiskLruCache;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Num;
import uz.FonRo.pos.core.Units;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxShape;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: Numpad.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u001a[\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007b\u0002\b\rb\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\f\u001a;\u0010\u0011\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007H\u0003b\u0002\b\rb\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\u0013\u001aY\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007b\u0002\b\rb\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\u0018\u001a\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0003H\u0002¨\u0006\u001d²\u0006\n\u0010\u001c\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u001e\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010\u001f\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u001c\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u001e\u001a\u00020\u000bX\u008a\u008e\u0002"}, d2 = {"NumpadSheet", "", "title", "", "initial", "", "onDone", "Lkotlin/Function1;", "onDismiss", "Lkotlin/Function0;", "allowDecimal", "", "(Ljava/lang/String;DLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;II)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "NumpadGrid", "onKey", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "MeasurePadSheet", "product", "Luz/FonRo/pos/data/model/Product;", FirebaseAnalytics.Param.CURRENCY, "(Luz/FonRo/pos/data/model/Product;DLjava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "formatInitial", "value", "parse", "raw", "app", "pristine", "mode"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class NumpadKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MeasurePadSheet$lambda$13(Product product, double d, String str, Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        MeasurePadSheet(product, d, str, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NumpadGrid$lambda$1(boolean z, Function1 function1, int i, Composer composer, int i2) {
        NumpadGrid(z, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NumpadSheet$lambda$10(String str, double d, Function1 function1, Function0 function0, boolean z, int i, int i2, Composer composer, int i3) {
        NumpadSheet(str, d, function1, function0, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void NumpadSheet(final java.lang.String r18, final double r19, final kotlin.jvm.functions.Function1<? super java.lang.Double, kotlin.Unit> r21, final kotlin.jvm.functions.Function0<kotlin.Unit> r22, boolean r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.NumpadKt.NumpadSheet(java.lang.String, double, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final String NumpadSheet$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean NumpadSheet$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void NumpadSheet$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NumpadSheet$press(boolean z, MutableState<Boolean> mutableState, MutableState<String> mutableState2, String str) {
        if (NumpadSheet$lambda$4(mutableState)) {
            mutableState2.setValue("");
            NumpadSheet$lambda$5(mutableState, false);
        }
        if (Intrinsics.areEqual(str, ",")) {
            if (!z || StringsKt.contains$default((CharSequence) NumpadSheet$lambda$1(mutableState2), AbstractJsonLexerKt.COMMA, false, 2, (Object) null)) {
                return;
            }
            String NumpadSheet$lambda$1 = NumpadSheet$lambda$1(mutableState2);
            if (NumpadSheet$lambda$1.length() == 0) {
                NumpadSheet$lambda$1 = "0";
            }
            mutableState2.setValue(((Object) NumpadSheet$lambda$1) + ",");
            return;
        }
        if (!Intrinsics.areEqual(str, "<")) {
            String NumpadSheet$lambda$12 = NumpadSheet$lambda$1(mutableState2);
            int i = 0;
            for (int i2 = 0; i2 < NumpadSheet$lambda$12.length(); i2++) {
                if (Character.isDigit(NumpadSheet$lambda$12.charAt(i2))) {
                    i++;
                }
            }
            if (i < 12) {
                mutableState2.setValue(NumpadSheet$lambda$1(mutableState2) + str);
                return;
            }
            return;
        }
        mutableState2.setValue(StringsKt.dropLast(NumpadSheet$lambda$1(mutableState2), 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NumpadSheet$lambda$8(final Function0 function0, final Function1 function1, final MutableState mutableState, RowScope OxSheet, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxSheet, "$this$OxSheet");
        ComposerKt.sourceInformation(composer, "C72@2467L89,75@2625L35,73@2569L230:Numpad.kt#r5y9fm");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1063327771, i2, -1, "uz.FonRo.pos.ui.components.NumpadSheet.<anonymous> (Numpad.kt:72)");
            }
            BasicsKt.OxButton(LangKt.tx("Отмена", new Object[0]), function0, RowScope.weight$default(OxSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.GHOST, null, false, false, null, composer, 3072, 240);
            String tx = LangKt.tx("Готово", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, 344234056, "CC(remember):Numpad.kt#9igjgp");
            boolean changed = composer.changed(function1) | composer.changed(function0);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.components.NumpadKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit NumpadSheet$lambda$8$0$0;
                        NumpadSheet$lambda$8$0$0 = NumpadKt.NumpadSheet$lambda$8$0$0(Function1.this, function0, mutableState);
                        return NumpadSheet$lambda$8$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, RowScope.weight$default(OxSheet, Modifier.INSTANCE, 2.0f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, false, false, null, composer, 27648, 224);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumpadSheet$lambda$8$0$0(Function1 function1, Function0 function0, MutableState mutableState) {
        function1.invoke(Double.valueOf(parse(NumpadSheet$lambda$1(mutableState))));
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NumpadSheet$lambda$9(String str, boolean z, MutableState mutableState, MutableState mutableState2, ColumnScope OxSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSheet, "$this$OxSheet");
        ComposerKt.sourceInformation(composer, "C82@2826L150,87@2985L439,101@3482L7,101@3434L56,102@3499L10:Numpad.kt#r5y9fm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1376926116, i, -1, "uz.FonRo.pos.ui.components.NumpadSheet.<anonymous> (Numpad.kt:82)");
            }
            TextKt.m2798Text4IGK_g(str, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getLabel(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6873getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), composer, 48, 0, 65532);
            Modifier m1053paddingqDBjuR0$default = PaddingKt.m1053paddingqDBjuR0$default(SizeKt.m1084heightInVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6989constructorimpl(58.0f), 0.0f, 2, null), 0.0f, Dp.m6989constructorimpl(8.0f), 0.0f, Dp.m6989constructorimpl(12.0f), 5, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
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
            Updater.m3815setimpl(m3808constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1729662815, "C94@3208L206:Numpad.kt#r5y9fm");
            String NumpadSheet$lambda$1 = NumpadSheet$lambda$1(mutableState);
            if (NumpadSheet$lambda$1.length() == 0) {
                NumpadSheet$lambda$1 = "0";
            }
            TextKt.m2798Text4IGK_g(NumpadSheet$lambda$1, AlphaKt.alpha(Modifier.INSTANCE, NumpadSheet$lambda$4(mutableState2) ? 0.45f : 1.0f), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getNumpadValue(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6873getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), composer, 0, 0, 65532);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -376048989, "CC(remember):Numpad.kt#9igjgp");
            boolean changed = composer.changed(z);
            NumpadKt$NumpadSheet$2$2$1 rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new NumpadKt$NumpadSheet$2$2$1(z, mutableState2, mutableState);
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            NumpadGrid(z, (Function1) ((KFunction) rememberedValue), composer, 0);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void NumpadGrid(final boolean z, final Function1<? super String, Unit> function1, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-321550313);
        ComposerKt.sourceInformation(startRestartGroup, "C(NumpadGrid)114@3760L1010:Numpad.kt#r5y9fm");
        int i2 = (i & 6) == 0 ? (startRestartGroup.changed(z) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i3 = i2;
        int i4 = 1;
        if (!startRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-321550313, i3, -1, "uz.FonRo.pos.ui.components.NumpadGrid (Numpad.kt:107)");
            }
            String str = ",";
            List<List> listOf = CollectionsKt.listOf((Object[]) new List[]{CollectionsKt.listOf((Object[]) new String[]{"7", "8", "9"}), CollectionsKt.listOf((Object[]) new String[]{"4", "5", "6"}), CollectionsKt.listOf((Object[]) new String[]{DiskLruCache.VERSION, "2", ExifInterface.GPS_MEASUREMENT_3D}), CollectionsKt.listOf((Object[]) new String[]{",", "0", "<"})});
            Arrangement.HorizontalOrVertical m930spacedBy0680j_4 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            int i5 = 6;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m930spacedBy0680j_4, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
            int i6 = -1323940314;
            String str2 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Object obj = "<";
            String str3 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
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
            String str4 = "C:Numpad.kt#r5y9fm";
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -646581319, "C:Numpad.kt#r5y9fm");
            startRestartGroup.startReplaceGroup(-20857307);
            ComposerKt.sourceInformation(startRestartGroup, "*116@3861L893");
            for (List<String> list : listOf) {
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, i4, null);
                Arrangement.HorizontalOrVertical m930spacedBy0680j_42 = Arrangement.INSTANCE.m930spacedBy0680j_4(Dp.m6989constructorimpl(8.0f));
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m930spacedBy0680j_42, Alignment.INSTANCE.getTop(), startRestartGroup, i5);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, i6, str2);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, str3);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1582771619, str4);
                startRestartGroup.startReplaceGroup(-1020888350);
                ComposerKt.sourceInformation(startRestartGroup, "*130@4519L14,130@4494L39,122@4108L614");
                for (final String str5 : list) {
                    boolean z2 = !Intrinsics.areEqual(str5, str) || z;
                    Modifier alpha = AlphaKt.alpha(BorderKt.m569borderxT4_qwU(BackgroundKt.m558backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1084heightInVpY3zN4$default(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m6989constructorimpl(56.0f), 0.0f, 2, null), OxShape.INSTANCE.getTile()), Ox.INSTANCE.m10218getPanel20d7_KjU(), null, 2, null), Dp.m6989constructorimpl(1.0f), Ox.INSTANCE.m10189getBorder0d7_KjU(), OxShape.INSTANCE.getTile()), z2 ? 1.0f : 0.4f);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -825050042, "CC(remember):Numpad.kt#9igjgp");
                    boolean changed = ((i3 & 112) == 32) | startRestartGroup.changed(str5);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.components.NumpadKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit NumpadGrid$lambda$0$0$0$0$0$0;
                                NumpadGrid$lambda$0$0$0$0$0$0 = NumpadKt.NumpadGrid$lambda$0$0$0$0$0$0(Function1.this, str5);
                                return NumpadGrid$lambda$0$0$0$0$0$0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    String str6 = str4;
                    String str7 = str;
                    Object obj2 = obj;
                    Modifier oxTap = ModifiersKt.oxTap(alpha, z2, (Function0) rememberedValue, startRestartGroup, 0, 0);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, str2);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, oxTap);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, str3);
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
                    Updater.m3815setimpl(m3808constructorimpl3, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3815setimpl(m3808constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3808constructorimpl3.getInserting() || !Intrinsics.areEqual(m3808constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m3808constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m3808constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m3815setimpl(m3808constructorimpl3, materializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1165361432, "C133@4643L57:Numpad.kt#r5y9fm");
                    if (Intrinsics.areEqual(str5, obj2)) {
                        str5 = "⌫";
                    }
                    Composer composer2 = startRestartGroup;
                    TextKt.m2798Text4IGK_g(str5, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getNumpad(), composer2, 0, 0, 65534);
                    startRestartGroup = composer2;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    str3 = str3;
                    str4 = str6;
                    str = str7;
                    obj = obj2;
                    str2 = str2;
                }
                startRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                i5 = 6;
                i6 = -1323940314;
                i4 = 1;
            }
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
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
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.components.NumpadKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return NumpadKt.NumpadGrid$lambda$1(z, function1, i, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumpadGrid$lambda$0$0$0$0$0$0(Function1 function1, String str) {
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    public static final void MeasurePadSheet(final Product product, final double d, final String currency, final Function1<? super Double, Unit> onDone, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Composer composer2;
        String str;
        final double d2;
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(onDone, "onDone");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer startRestartGroup = composer.startRestartGroup(305574789);
        ComposerKt.sourceInformation(startRestartGroup, "C(MeasurePadSheet)P(4,1!1,3)157@5234L34,158@5284L51,159@5356L40,178@6014L412,189@6433L1412,175@5935L1910:Numpad.kt#r5y9fm");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(product) : startRestartGroup.changedInstance(product) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(d) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(currency) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(onDone) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(onDismiss) ? 16384 : 8192;
        }
        if (!startRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(305574789, i2, -1, "uz.FonRo.pos.ui.components.MeasurePadSheet (Numpad.kt:155)");
            }
            String name = Units.INSTANCE.name(product.getUnit());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1599602759, "CC(remember):Numpad.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("qty", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1599604376, "CC(remember):Numpad.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(formatInitial(d), null, 2, null);
                startRestartGroup.updateRememberedValue(mutableStateOf$default);
                rememberedValue2 = mutableStateOf$default;
            }
            final MutableState mutableState2 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1599606669, "CC(remember):Numpad.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            Object empty = Composer.INSTANCE.getEmpty();
            double d3 = AudioStats.AUDIO_AMPLITUDE_NONE;
            if (rememberedValue3 == empty) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(d > AudioStats.AUDIO_AMPLITUDE_NONE), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            double parse = parse(MeasurePadSheet$lambda$4(mutableState2));
            if (Intrinsics.areEqual(MeasurePadSheet$lambda$1(mutableState), "qty")) {
                str = name;
                d2 = parse;
            } else {
                if (product.getSalePrice() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    str = name;
                    d3 = Num.INSTANCE.qty(parse / product.getSalePrice());
                } else {
                    str = name;
                }
                d2 = d3;
            }
            if (Intrinsics.areEqual(MeasurePadSheet$lambda$1(mutableState), "qty")) {
                parse *= product.getSalePrice();
            }
            final double d4 = d2;
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1535273116, true, new Function3() { // from class: uz.FonRo.pos.ui.components.NumpadKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NumpadKt.MeasurePadSheet$lambda$11(Function0.this, d2, onDone, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54);
            composer2 = startRestartGroup;
            final String str2 = str;
            int i3 = i2;
            final double d5 = parse;
            SheetsKt.OxSheet(null, onDismiss, null, false, rememberComposableLambda, ComposableLambdaKt.rememberComposableLambda(2042258011, true, new Function3() { // from class: uz.FonRo.pos.ui.components.NumpadKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NumpadKt.MeasurePadSheet$lambda$12(Product.this, str2, d5, currency, d4, mutableState, mutableState2, mutableState3, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, ((i3 >> 9) & 112) | 221190, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.components.NumpadKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NumpadKt.MeasurePadSheet$lambda$13(Product.this, d, currency, onDone, onDismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String MeasurePadSheet$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String MeasurePadSheet$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean MeasurePadSheet$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void MeasurePadSheet$lambda$8(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MeasurePadSheet$press(MutableState<Boolean> mutableState, MutableState<String> mutableState2, String str) {
        if (MeasurePadSheet$lambda$7(mutableState)) {
            mutableState2.setValue("");
            MeasurePadSheet$lambda$8(mutableState, false);
        }
        if (Intrinsics.areEqual(str, ",")) {
            if (StringsKt.contains$default((CharSequence) MeasurePadSheet$lambda$4(mutableState2), AbstractJsonLexerKt.COMMA, false, 2, (Object) null)) {
                return;
            }
            String MeasurePadSheet$lambda$4 = MeasurePadSheet$lambda$4(mutableState2);
            if (MeasurePadSheet$lambda$4.length() == 0) {
                MeasurePadSheet$lambda$4 = "0";
            }
            mutableState2.setValue(((Object) MeasurePadSheet$lambda$4) + ",");
            return;
        }
        if (!Intrinsics.areEqual(str, "<")) {
            String MeasurePadSheet$lambda$42 = MeasurePadSheet$lambda$4(mutableState2);
            int i = 0;
            for (int i2 = 0; i2 < MeasurePadSheet$lambda$42.length(); i2++) {
                if (Character.isDigit(MeasurePadSheet$lambda$42.charAt(i2))) {
                    i++;
                }
            }
            if (i < 12) {
                mutableState2.setValue(MeasurePadSheet$lambda$4(mutableState2) + str);
                return;
            }
            return;
        }
        mutableState2.setValue(StringsKt.dropLast(MeasurePadSheet$lambda$4(mutableState2), 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MeasurePadSheet$lambda$11(final Function0 function0, final double d, final Function1 function1, RowScope OxSheet, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxSheet, "$this$OxSheet");
        ComposerKt.sourceInformation(composer, "C179@6028L89,182@6188L54,180@6130L286:Numpad.kt#r5y9fm");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1535273116, i2, -1, "uz.FonRo.pos.ui.components.MeasurePadSheet.<anonymous> (Numpad.kt:179)");
            }
            BasicsKt.OxButton(LangKt.tx("Отмена", new Object[0]), function0, RowScope.weight$default(OxSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.GHOST, null, false, false, null, composer, 3072, 240);
            String tx = LangKt.tx("Добавить", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, 2071290970, "CC(remember):Numpad.kt#9igjgp");
            boolean changed = composer.changed(d) | composer.changed(function1) | composer.changed(function0);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.components.NumpadKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MeasurePadSheet$lambda$11$0$0;
                        MeasurePadSheet$lambda$11$0$0 = NumpadKt.MeasurePadSheet$lambda$11$0$0(d, function1, function0);
                        return MeasurePadSheet$lambda$11$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function0 function02 = (Function0) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, function02, RowScope.weight$default(OxSheet, Modifier.INSTANCE, 2.0f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, d > AudioStats.AUDIO_AMPLITUDE_NONE, false, null, composer, 27648, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MeasurePadSheet$lambda$11$0$0(double d, Function1 function1, Function0 function0) {
        if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
            function1.invoke(Double.valueOf(Num.INSTANCE.qty(d)));
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MeasurePadSheet$lambda$12(Product product, String str, double d, String str2, double d2, final MutableState mutableState, MutableState mutableState2, final MutableState mutableState3, ColumnScope OxSheet, Composer composer, int i) {
        final MutableState mutableState4;
        String str3;
        Intrinsics.checkNotNullParameter(OxSheet, "$this$OxSheet");
        ComposerKt.sourceInformation(composer, "C190@6443L154,195@6606L10,196@6625L205,201@6839L11,209@7084L41,203@6860L275,212@7145L342,222@7496L266,229@7812L7,229@7772L48,230@7829L10:Numpad.kt#r5y9fm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2042258011, i, -1, "uz.FonRo.pos.ui.components.MeasurePadSheet.<anonymous> (Numpad.kt:190)");
            }
            TextKt.m2798Text4IGK_g(product.getName(), SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH3(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6873getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), composer, 48, 0, 65532);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(2.0f), composer, 6);
            TextKt.m2798Text4IGK_g(LangKt.tx("· остаток %s %s", Fmt.INSTANCE.qf(Double.valueOf(product.getQuantity())), str), SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6873getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), composer, 48, 0, 65532);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer, 6);
            List listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("qty", Units.INSTANCE.measureLabel(product.getUnit()) + " (" + str + ")"), TuplesKt.to("sum", LangKt.tx("Сумма", new Object[0]))});
            String MeasurePadSheet$lambda$1 = MeasurePadSheet$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, -190084828, "CC(remember):Numpad.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableState4 = mutableState2;
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.components.NumpadKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit MeasurePadSheet$lambda$12$0$0;
                        MeasurePadSheet$lambda$12$0$0 = NumpadKt.MeasurePadSheet$lambda$12$0$0(MutableState.this, mutableState4, mutableState3, (String) obj);
                        return MeasurePadSheet$lambda$12$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            } else {
                mutableState4 = mutableState2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.OxSegControl(listOf, MeasurePadSheet$lambda$1, (Function1) rememberedValue, null, false, composer, 384, 24);
            Modifier m1051paddingVpY3zN4$default = PaddingKt.m1051paddingVpY3zN4$default(SizeKt.m1084heightInVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6989constructorimpl(58.0f), 0.0f, 2, null), 0.0f, Dp.m6989constructorimpl(6.0f), 1, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m1051paddingVpY3zN4$default);
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
            Updater.m3815setimpl(m3808constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3815setimpl(m3808constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3808constructorimpl.getInserting() || !Intrinsics.areEqual(m3808constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3808constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3808constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3815setimpl(m3808constructorimpl, materializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1997502525, "C216@7306L171:Numpad.kt#r5y9fm");
            String MeasurePadSheet$lambda$4 = MeasurePadSheet$lambda$4(mutableState4);
            if (MeasurePadSheet$lambda$4.length() == 0) {
                MeasurePadSheet$lambda$4 = "0";
            }
            TextKt.m2798Text4IGK_g(MeasurePadSheet$lambda$4, AlphaKt.alpha(Modifier.INSTANCE, MeasurePadSheet$lambda$7(mutableState3) ? 0.45f : 1.0f), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getNumpadValue(), composer, 0, 0, 65532);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (Intrinsics.areEqual(MeasurePadSheet$lambda$1(mutableState), "qty")) {
                str3 = "= " + Fmt.INSTANCE.money(Double.valueOf(d), str2);
            } else {
                str3 = "= " + Fmt.INSTANCE.qf(Double.valueOf(d2)) + " " + str;
            }
            TextKt.m2798Text4IGK_g(str3, PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(10.0f), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getLabel(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6873getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), composer, 48, 0, 65532);
            ComposerKt.sourceInformationMarkerStart(composer, -190061566, "CC(remember):Numpad.kt#9igjgp");
            NumpadKt$MeasurePadSheet$2$3$1 rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new NumpadKt$MeasurePadSheet$2$3$1(mutableState3, mutableState2);
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            NumpadGrid(true, (Function1) ((KFunction) rememberedValue2), composer, 54);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MeasurePadSheet$lambda$12$0$0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        mutableState2.setValue("");
        MeasurePadSheet$lambda$8(mutableState3, false);
        return Unit.INSTANCE;
    }

    private static final String formatInitial(double d) {
        if (d <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            return "";
        }
        if (d % 1.0d == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return String.valueOf((long) d);
        }
        String plainString = NumpadKt$$ExternalSyntheticBackportWithForwarding0.m(new BigDecimal(d).setScale(3, RoundingMode.HALF_UP)).toPlainString();
        Intrinsics.checkNotNullExpressionValue(plainString, "toPlainString(...)");
        return StringsKt.replace$default(plainString, '.', AbstractJsonLexerKt.COMMA, false, 4, (Object) null);
    }

    private static final double parse(String str) {
        String str2 = str;
        if (StringsKt.isBlank(str2)) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        StringBuilder sb = new StringBuilder();
        int length = str2.length();
        for (int i = 0; i < length; i++) {
            char charAt = str2.charAt(i);
            if (Character.isDigit(charAt) || charAt == ',' || charAt == '.') {
                sb.append(charAt);
            }
        }
        Double doubleOrNull = StringsKt.toDoubleOrNull(StringsKt.replace$default(sb.toString(), AbstractJsonLexerKt.COMMA, '.', false, 4, (Object) null));
        return doubleOrNull != null ? doubleOrNull.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
    }
}
