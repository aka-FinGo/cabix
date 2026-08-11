package uz.FonRo.pos.ui.sale;

import android.content.Context;
import androidx.camera.video.AudioStats;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
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
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import j$.time.LocalDateTime;
import java.util.ArrayList;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import uz.FonRo.pos.FonRoApp;
import uz.FonRo.pos.core.Fmt;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.core.Units;
import uz.FonRo.pos.data.model.PayType;
import uz.FonRo.pos.data.repo.Repo;
import uz.FonRo.pos.print.ReceiptDoc;
import uz.FonRo.pos.print.ReceiptLine;
import uz.FonRo.pos.print.ReceiptPay;
import uz.FonRo.pos.print.ReceiptTotal;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.BtnSize;
import uz.FonRo.pos.ui.components.BtnStyle;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.SheetsKt;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: SaleSubmit.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a^\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0080@¢\u0006\u0002\u0010\u0011\u001a=\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0016H\u0001b\u0002\b\u0018b\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b¢\u0006\u0002\u0010\u0017\u001a\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0001H\u0002¨\u0006\u0002"}, d2 = {"submitSale", "Luz/FonRo/pos/ui/sale/SaleDone;", "app", "Luz/FonRo/pos/FonRoApp;", "payType", "Luz/FonRo/pos/data/model/PayType;", "tid", "", "totals", "Luz/FonRo/pos/ui/sale/CartTotals;", "received", "", "paid", "cash", "card", "change", "debt", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/data/model/PayType;Ljava/lang/String;Luz/FonRo/pos/ui/sale/CartTotals;DDDDDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "DoneSheet", "", "done", "onClose", "Lkotlin/Function0;", "(Luz/FonRo/pos/FonRoApp;Luz/FonRo/pos/ui/sale/SaleDone;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "buildReceipt", "Luz/FonRo/pos/print/ReceiptDoc;"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class SaleSubmitKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DoneSheet$lambda$3(FonRoApp FonRoApp, SaleDone saleDone, Function0 function0, int i, Composer composer, int i2) {
        DoneSheet(FonRoApp, saleDone, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02b6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object submitSale(uz.FonRo.pos.FonRoApp r43, uz.FonRo.pos.data.model.PayType r44, java.lang.String r45, uz.FonRo.pos.ui.sale.CartTotals r46, double r47, double r49, double r51, double r53, double r55, double r57, kotlin.coroutines.Continuation<? super uz.FonRo.pos.ui.sale.SaleDone> r59) {
        /*
            Method dump skipped, instructions count: 832
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.sale.SaleSubmitKt.submitSale(uz.FonRo.pos.FonRoApp, uz.FonRo.pos.data.model.PayType, java.lang.String, uz.FonRo.pos.ui.sale.CartTotals, double, double, double, double, double, double, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final SaleDone submitSale$doneOf(PayType payType, List<CartLine> list, CartTotals cartTotals, double d, double d2, double d3, double d4, double d5, double d6, String str, String str2, double d7, boolean z) {
        return new SaleDone(str2, payType, z, list, cartTotals.getSubtotal(), cartTotals.getDiscount(), d7, d, d2, d3, d4, d5, d6, str);
    }

    public static final void DoneSheet(final FonRoApp app, final SaleDone done, final Function0<Unit> onClose, Composer composer, final int i) {
        int i2;
        final SaleDone saleDone;
        final FonRoApp FonRoApp;
        final Function0<Unit> function0;
        final Repo repo;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(done, "done");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Composer startRestartGroup = composer.startRestartGroup(345743120);
        ComposerKt.sourceInformation(startRestartGroup, "C(DoneSheet)180@6078L7,181@6102L24,183@6167L601,183@6132L636,204@7036L774,227@7817L1404,198@6774L2447:SaleSubmit.kt#1sewlp");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(app) : startRestartGroup.changedInstance(app) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(done) : startRestartGroup.changedInstance(done) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(onClose) ? 256 : 128;
        }
        int i3 = i2;
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            saleDone = done;
            FonRoApp = app;
            function0 = onClose;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(345743120, i3, -1, "uz.FonRo.pos.ui.sale.DoneSheet (SaleSubmit.kt:178)");
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
            String transactionId = done.getTransactionId();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1546664393, "CC(remember):SaleSubmit.kt#9igjgp");
            boolean changedInstance = ((i3 & 14) == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(app))) | ((i3 & 112) == 32 || ((i3 & 64) != 0 && startRestartGroup.changedInstance(done))) | startRestartGroup.changedInstance(context) | startRestartGroup.changedInstance(repo2);
            SaleSubmitKt$DoneSheet$1$1 rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                repo = repo2;
                rememberedValue2 = new SaleSubmitKt$DoneSheet$1$1(done, context, repo2, app, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            } else {
                repo = repo2;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(transactionId, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, 0);
            String tx = LangKt.tx("Готово", new Object[0]);
            Function3 function3 = new Function3() { // from class: uz.FonRo.pos.ui.sale.SaleSubmitKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SaleSubmitKt.DoneSheet$lambda$1(CoroutineScope.this, context, app, done, onClose, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            FonRoApp = app;
            saleDone = done;
            function0 = onClose;
            SheetsKt.OxCardSheet(tx, function0, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-764957437, true, function3, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(631085356, true, new Function3() { // from class: uz.FonRo.pos.ui.sale.SaleSubmitKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SaleSubmitKt.DoneSheet$lambda$2(Repo.this, saleDone, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, ((i3 >> 3) & 112) | 14180352, 44);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: uz.FonRo.pos.ui.sale.SaleSubmitKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SaleSubmitKt.DoneSheet$lambda$3(FonRoApp.this, saleDone, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DoneSheet$lambda$1(final CoroutineScope coroutineScope, final Context context, final FonRoApp FonRoApp, final SaleDone saleDone, Function0 function0, RowScope OxCardSheet, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C207@7103L271,205@7050L535,219@7598L202:SaleSubmit.kt#1sewlp");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(OxCardSheet) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-764957437, i2, -1, "uz.FonRo.pos.ui.sale.DoneSheet.<anonymous> (SaleSubmit.kt:205)");
            }
            String tx = LangKt.tx("Чек", new Object[0]);
            ComposerKt.sourceInformationMarkerStart(composer, -684686926, "CC(remember):SaleSubmit.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(context) | composer.changedInstance(FonRoApp) | composer.changedInstance(saleDone);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: uz.FonRo.pos.ui.sale.SaleSubmitKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DoneSheet$lambda$1$0$0;
                        DoneSheet$lambda$1$0$0 = SaleSubmitKt.DoneSheet$lambda$1$0$0(CoroutineScope.this, context, FonRoApp, saleDone);
                        return DoneSheet$lambda$1$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BasicsKt.OxButton(tx, (Function0) rememberedValue, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), null, null, false, false, ComposableSingletons$SaleSubmitKt.INSTANCE.getLambda$1801921236$app(), composer, 12582912, MenuKt.InTransitionDuration);
            BasicsKt.OxButton(LangKt.tx("Готово", new Object[0]), function0, RowScope.weight$default(OxCardSheet, Modifier.INSTANCE, 1.0f, false, 2, null), BtnStyle.PRIMARY, BtnSize.LG, false, false, null, composer, 27648, 224);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DoneSheet$lambda$1$0$0(CoroutineScope coroutineScope, Context context, FonRoApp FonRoApp, SaleDone saleDone) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SaleSubmitKt$DoneSheet$2$1$1$1(context, FonRoApp, saleDone, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DoneSheet$lambda$2(Repo repo, SaleDone saleDone, ColumnScope OxCardSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxCardSheet, "$this$OxCardSheet");
        ComposerKt.sourceInformation(composer, "C228@7827L1388:SaleSubmit.kt#1sewlp");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(631085356, i, -1, "uz.FonRo.pos.ui.sale.DoneSheet.<anonymous> (SaleSubmit.kt:228)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer, 48);
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
            ComposerKt.sourceInformationMarkerStart(composer, 438416110, "C232@7970L136,236@8119L10,237@8142L51,238@8206L10,239@8229L142,259@9088L11,260@9112L70,261@9195L10:SaleSubmit.kt#1sewlp");
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getOk(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(52.0f)), Ox.INSTANCE.m10211getOk0d7_KjU(), composer, 432, 0);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer, 6);
            TextKt.m2798Text4IGK_g(repo.money(Double.valueOf(saleDone.getTotal())), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getAmount(), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(4.0f), composer, 6);
            TextKt.m2798Text4IGK_g(LangKt.tx("Продажа проведена · %s", saleDone.getPayType().getLabel()), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            Composer composer2 = composer;
            if (saleDone.getChange() > 0.01d) {
                composer2.startReplaceGroup(438816164);
                ComposerKt.sourceInformation(composer2, "244@8426L10,245@8453L65");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer2, 6);
                TextKt.m2798Text4IGK_g(LangKt.tx("Сдача: %s", repo.money(Double.valueOf(saleDone.getChange()))), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH3(), composer, 0, 0, 65534);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(438935328);
                composer2.endReplaceGroup();
            }
            if (saleDone.getDebt() > 0.01d) {
                composer2.startReplaceGroup(438974481);
                ComposerKt.sourceInformation(composer2, "248@8585L10,249@8612L84");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(8.0f), composer2, 6);
                TextKt.m2798Text4IGK_g(LangKt.tx("Долг: %s", repo.money(Double.valueOf(saleDone.getDebt()))), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getH3(), Ox.INSTANCE.m10238getWarn0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(439111904);
                composer2.endReplaceGroup();
            }
            if (saleDone.getQueued()) {
                composer2.startReplaceGroup(439152049);
                ComposerKt.sourceInformation(composer2, "252@8758L11,253@8786L275");
                BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer2, 6);
                TextKt.m2798Text4IGK_g(LangKt.tx("Сети нет — чек сохранён и уйдёт на сервер сам, как только связь появится.", new Object[0]), SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), Ox.INSTANCE.m10238getWarn0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6873getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744446, null), composer, 48, 0, 65532);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(439473984);
                composer2.endReplaceGroup();
            }
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(10.0f), composer2, 6);
            TextKt.m2798Text4IGK_g(saleDone.getTransactionId(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), Ox.INSTANCE.m10200getDim20d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer, 6);
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
    public static final ReceiptDoc buildReceipt(FonRoApp FonRoApp, SaleDone saleDone) {
        Repo repo = FonRoApp.getRepo();
        boolean z = saleDone.getPayType() == PayType.DEBT;
        List createListBuilder = CollectionsKt.createListBuilder();
        if (saleDone.getDiscountAmount() > AudioStats.AUDIO_AMPLITUDE_NONE) {
            createListBuilder.add(new ReceiptTotal(LangKt.tx("Подытог", new Object[0]), Fmt.INSTANCE.nf(Double.valueOf(saleDone.getSubtotal())), false, false, 12, null));
            createListBuilder.add(new ReceiptTotal(LangKt.tx("Скидка", new Object[0]), "−" + Fmt.INSTANCE.nf(Double.valueOf(saleDone.getDiscountAmount())), false, false, 12, null));
        }
        createListBuilder.add(new ReceiptTotal(LangKt.tx("ИТОГО", new Object[0]), repo.money(Double.valueOf(saleDone.getTotal())), true, true));
        List build = CollectionsKt.build(createListBuilder);
        List createListBuilder2 = CollectionsKt.createListBuilder();
        if (saleDone.getPayType() == PayType.MIXED) {
            createListBuilder2.add(new ReceiptPay("Наличные", Fmt.INSTANCE.nf(Double.valueOf(saleDone.getCash()))));
            createListBuilder2.add(new ReceiptPay("Карта", Fmt.INSTANCE.nf(Double.valueOf(saleDone.getCard()))));
        }
        if (saleDone.getPayType() == PayType.CASH && saleDone.getReceived() > AudioStats.AUDIO_AMPLITUDE_NONE) {
            createListBuilder2.add(new ReceiptPay("Получено", Fmt.INSTANCE.nf(Double.valueOf(saleDone.getReceived()))));
        }
        if (saleDone.getChange() > 0.01d) {
            createListBuilder2.add(new ReceiptPay("Сдача", Fmt.INSTANCE.nf(Double.valueOf(saleDone.getChange()))));
        }
        String str = "Долг";
        if (z) {
            createListBuilder2.add(new ReceiptPay("Оплачено сразу", Fmt.INSTANCE.nf(Double.valueOf(saleDone.getPaid()))));
            createListBuilder2.add(new ReceiptPay("Долг", Fmt.INSTANCE.nf(Double.valueOf(saleDone.getDebt()))));
        }
        List build2 = CollectionsKt.build(createListBuilder2);
        String transactionId = saleDone.getTransactionId();
        String dt$default = Fmt.dt$default(Fmt.INSTANCE, LocalDateTime.now(Fmt.INSTANCE.getSTORE_ZONE()).toString(), false, 2, null);
        String raw = saleDone.getPayType().getRaw();
        if (!z) {
            str = "Оплачено";
        }
        String str2 = str;
        boolean z2 = !z;
        String customerName = saleDone.getCustomerName();
        String valueOf = String.valueOf(saleDone.getLines().size());
        List<CartLine> lines = saleDone.getLines();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(lines, 10));
        for (CartLine cartLine : lines) {
            arrayList.add(new ReceiptLine(cartLine.getName(), Fmt.INSTANCE.qf(Double.valueOf(cartLine.getQty())) + " " + Units.INSTANCE.rawName(cartLine.getUnit()), cartLine.getPrice(), cartLine.getSum()));
        }
        return new ReceiptDoc(transactionId, dt$default, raw, str2, z2, customerName, valueOf, arrayList, build, build2, saleDone.getTransactionId(), "Спасибо за покупку!");
    }
}
