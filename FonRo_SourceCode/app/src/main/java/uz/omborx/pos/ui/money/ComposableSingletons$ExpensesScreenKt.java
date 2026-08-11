package uz.FonRo.pos.ui.money;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.PageHeadKt;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: ExpensesScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$ExpensesScreenKt {
    public static final ComposableSingletons$ExpensesScreenKt INSTANCE = new ComposableSingletons$ExpensesScreenKt();
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1371649821 = ComposableLambdaKt.composableLambdaInstance(1371649821, false, new Function3() { // from class: uz.FonRo.pos.ui.money.ComposableSingletons$ExpensesScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ExpensesScreenKt.lambda_1371649821$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-127051547, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f92lambda$127051547 = ComposableLambdaKt.composableLambdaInstance(-127051547, false, new Function3() { // from class: uz.FonRo.pos.ui.money.ComposableSingletons$ExpensesScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ExpensesScreenKt.lambda__127051547$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-2058247396, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f94lambda$2058247396 = ComposableLambdaKt.composableLambdaInstance(-2058247396, false, new Function3() { // from class: uz.FonRo.pos.ui.money.ComposableSingletons$ExpensesScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ExpensesScreenKt.lambda__2058247396$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1356312803, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f93lambda$1356312803 = ComposableLambdaKt.composableLambdaInstance(-1356312803, false, new Function3() { // from class: uz.FonRo.pos.ui.money.ComposableSingletons$ExpensesScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ExpensesScreenKt.lambda__1356312803$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-127051547$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m9971getLambda$127051547$app() {
        return f92lambda$127051547;
    }

    /* renamed from: getLambda$-1356312803$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m9972getLambda$1356312803$app() {
        return f93lambda$1356312803;
    }

    /* renamed from: getLambda$-2058247396$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m9973getLambda$2058247396$app() {
        return f94lambda$2058247396;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1371649821$app() {
        return lambda$1371649821;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1371649821$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C160@6325L25:ExpensesScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1371649821, i, -1, "uz.FonRo.pos.ui.money.ComposableSingletons$ExpensesScreenKt.lambda$1371649821.<anonymous> (ExpensesScreen.kt:160)");
            }
            PageHeadKt.OxPageHead(LangKt.tx("Расходы", new Object[0]), null, null, false, null, composer, 0, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__127051547$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C172@6600L263:ExpensesScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-127051547, i, -1, "uz.FonRo.pos.ui.money.ComposableSingletons$ExpensesScreenKt.lambda$-127051547.<anonymous> (ExpensesScreen.kt:172)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Изменить и отменить можно только расход за сегодня — за прошлые дни цифры закрыты.", new Object[0]), PaddingKt.m1052paddingqDBjuR0(Modifier.INSTANCE, Dp.m6989constructorimpl(2.0f), Dp.m6989constructorimpl(8.0f), Dp.m6989constructorimpl(2.0f), Dp.m6989constructorimpl(12.0f)), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 0, 0, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__2058247396$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C204@7720L28:ExpensesScreen.kt#fh874k");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2058247396, i, -1, "uz.FonRo.pos.ui.money.ComposableSingletons$ExpensesScreenKt.lambda$-2058247396.<anonymous> (ExpensesScreen.kt:204)");
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
    public static final Unit lambda__1356312803$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C205@7792L15:ExpensesScreen.kt#fh874k");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1356312803, i, -1, "uz.FonRo.pos.ui.money.ComposableSingletons$ExpensesScreenKt.lambda$-1356312803.<anonymous> (ExpensesScreen.kt:205)");
            }
            ExpensesScreenKt.ExpensesEmpty(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
