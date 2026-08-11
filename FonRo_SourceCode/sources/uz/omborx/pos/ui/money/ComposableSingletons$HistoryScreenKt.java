package uz.FonRo.pos.ui.money;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.ChipsKt;
import uz.FonRo.pos.ui.components.PageHeadKt;

/* compiled from: HistoryScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$HistoryScreenKt {
    public static final ComposableSingletons$HistoryScreenKt INSTANCE = new ComposableSingletons$HistoryScreenKt();

    /* renamed from: lambda$-192727741, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f97lambda$192727741 = ComposableLambdaKt.composableLambdaInstance(-192727741, false, new Function3() { // from class: uz.FonRo.pos.ui.money.ComposableSingletons$HistoryScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$HistoryScreenKt.lambda__192727741$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1779153428, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f96lambda$1779153428 = ComposableLambdaKt.composableLambdaInstance(-1779153428, false, new Function3() { // from class: uz.FonRo.pos.ui.money.ComposableSingletons$HistoryScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$HistoryScreenKt.lambda__1779153428$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1765010174, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f95lambda$1765010174 = ComposableLambdaKt.composableLambdaInstance(-1765010174, false, new Function3() { // from class: uz.FonRo.pos.ui.money.ComposableSingletons$HistoryScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$HistoryScreenKt.lambda__1765010174$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$328054664 = ComposableLambdaKt.composableLambdaInstance(328054664, false, new Function3() { // from class: uz.FonRo.pos.ui.money.ComposableSingletons$HistoryScreenKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$HistoryScreenKt.lambda_328054664$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$539629087 = ComposableLambdaKt.composableLambdaInstance(539629087, false, new Function3() { // from class: uz.FonRo.pos.ui.money.ComposableSingletons$HistoryScreenKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$HistoryScreenKt.lambda_539629087$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1382242855 = ComposableLambdaKt.composableLambdaInstance(1382242855, false, new Function3() { // from class: uz.FonRo.pos.ui.money.ComposableSingletons$HistoryScreenKt$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$HistoryScreenKt.lambda_1382242855$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-1765010174$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m9974getLambda$1765010174$app() {
        return f95lambda$1765010174;
    }

    /* renamed from: getLambda$-1779153428$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m9975getLambda$1779153428$app() {
        return f96lambda$1779153428;
    }

    /* renamed from: getLambda$-192727741$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m9976getLambda$192727741$app() {
        return f97lambda$192727741;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1382242855$app() {
        return lambda$1382242855;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$328054664$app() {
        return lambda$328054664;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$539629087$app() {
        return lambda$539629087;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__192727741$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C173@6885L26:HistoryScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-192727741, i, -1, "uz.FonRo.pos.ui.money.ComposableSingletons$HistoryScreenKt.lambda$-192727741.<anonymous> (HistoryScreen.kt:173)");
            }
            PageHeadKt.OxPageHead(LangKt.tx("Все чеки", new Object[0]), null, null, false, null, composer, 0, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1779153428$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C182@7266L25,179@7076L530:HistoryScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1779153428, i, -1, "uz.FonRo.pos.ui.money.ComposableSingletons$HistoryScreenKt.lambda$-1779153428.<anonymous> (HistoryScreen.kt:179)");
            }
            List listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("receipts", LangKt.tx("Проданные чеки", new Object[0])), TuplesKt.to(FirebaseAnalytics.Param.ITEMS, LangKt.tx("Проданные товары", new Object[0]))});
            String tab = HistoryState.INSTANCE.getTab();
            ComposerKt.sourceInformationMarkerStart(composer, -369449915, "CC(remember):HistoryScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.money.ComposableSingletons$HistoryScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit lambda__1779153428$lambda$0$0$0;
                        lambda__1779153428$lambda$0$0$0 = ComposableSingletons$HistoryScreenKt.lambda__1779153428$lambda$0$0$0((String) obj);
                        return lambda__1779153428$lambda$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.OxSegControl(listOf, tab, (Function1) rememberedValue, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null), true, composer, 28032, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1779153428$lambda$0$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        HistoryState.INSTANCE.setTab(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1765010174$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C210@8328L28:HistoryScreen.kt#fh874k");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1765010174, i, -1, "uz.FonRo.pos.ui.money.ComposableSingletons$HistoryScreenKt.lambda$-1765010174.<anonymous> (HistoryScreen.kt:210)");
            }
            BasicsKt.OxEmptyNote(LangKt.tx("Загрузка…", new Object[0]), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_328054664$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C214@8470L39:HistoryScreen.kt#fh874k");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(328054664, i, -1, "uz.FonRo.pos.ui.money.ComposableSingletons$HistoryScreenKt.lambda$328054664.<anonymous> (HistoryScreen.kt:214)");
            }
            BasicsKt.OxEmptyNote(LangKt.tx("Продаж за период нет", new Object[0]), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_539629087$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C220@8803L30,217@8588L385:HistoryScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(539629087, i, -1, "uz.FonRo.pos.ui.money.ComposableSingletons$HistoryScreenKt.lambda$539629087.<anonymous> (HistoryScreen.kt:217)");
            }
            List listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("sum", LangKt.tx("По сумме", new Object[0])), TuplesKt.to("qty", LangKt.tx("По количеству", new Object[0]))});
            String itemSort = HistoryState.INSTANCE.getItemSort();
            ComposerKt.sourceInformationMarkerStart(composer, -1107482467, "CC(remember):HistoryScreen.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: uz.FonRo.pos.ui.money.ComposableSingletons$HistoryScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit lambda_539629087$lambda$0$0$0;
                        lambda_539629087$lambda$0$0$0 = ComposableSingletons$HistoryScreenKt.lambda_539629087$lambda$0$0$0((String) obj);
                        return lambda_539629087$lambda$0$0$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChipsKt.OxSegControl(listOf, itemSort, (Function1) rememberedValue, PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null), true, composer, 28032, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_539629087$lambda$0$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        HistoryState.INSTANCE.setItemSort(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1382242855$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C233@9297L39:HistoryScreen.kt#fh874k");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1382242855, i, -1, "uz.FonRo.pos.ui.money.ComposableSingletons$HistoryScreenKt.lambda$1382242855.<anonymous> (HistoryScreen.kt:233)");
            }
            BasicsKt.OxEmptyNote(LangKt.tx("Продаж за период нет", new Object[0]), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
