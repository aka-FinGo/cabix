package uz.FonRo.pos.ui.money;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.PageHeadKt;

/* compiled from: DebtsScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$DebtsScreenKt {
    public static final ComposableSingletons$DebtsScreenKt INSTANCE = new ComposableSingletons$DebtsScreenKt();
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1750416939 = ComposableLambdaKt.composableLambdaInstance(1750416939, false, new Function3() { // from class: uz.FonRo.pos.ui.money.ComposableSingletons$DebtsScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DebtsScreenKt.lambda_1750416939$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1363793258 = ComposableLambdaKt.composableLambdaInstance(1363793258, false, new Function3() { // from class: uz.FonRo.pos.ui.money.ComposableSingletons$DebtsScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DebtsScreenKt.lambda_1363793258$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-291656976, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f91lambda$291656976 = ComposableLambdaKt.composableLambdaInstance(-291656976, false, new Function3() { // from class: uz.FonRo.pos.ui.money.ComposableSingletons$DebtsScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DebtsScreenKt.lambda__291656976$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1176392783, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f89lambda$1176392783 = ComposableLambdaKt.composableLambdaInstance(-1176392783, false, new Function3() { // from class: uz.FonRo.pos.ui.money.ComposableSingletons$DebtsScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DebtsScreenKt.lambda__1176392783$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1937423125, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f90lambda$1937423125 = ComposableLambdaKt.composableLambdaInstance(-1937423125, false, new Function3() { // from class: uz.FonRo.pos.ui.money.ComposableSingletons$DebtsScreenKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DebtsScreenKt.lambda__1937423125$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-1176392783$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m9968getLambda$1176392783$app() {
        return f89lambda$1176392783;
    }

    /* renamed from: getLambda$-1937423125$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m9969getLambda$1937423125$app() {
        return f90lambda$1937423125;
    }

    /* renamed from: getLambda$-291656976$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m9970getLambda$291656976$app() {
        return f91lambda$291656976;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1363793258$app() {
        return lambda$1363793258;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1750416939$app() {
        return lambda$1750416939;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1750416939$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C149@6077L23:DebtsScreen.kt#fh874k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1750416939, i, -1, "uz.FonRo.pos.ui.money.ComposableSingletons$DebtsScreenKt.lambda$1750416939.<anonymous> (DebtsScreen.kt:149)");
            }
            PageHeadKt.OxPageHead(LangKt.tx("Долги", new Object[0]), null, null, false, null, composer, 0, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1363793258$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C192@7517L35:DebtsScreen.kt#fh874k");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1363793258, i, -1, "uz.FonRo.pos.ui.money.ComposableSingletons$DebtsScreenKt.lambda$1363793258.<anonymous> (DebtsScreen.kt:192)");
            }
            BasicsKt.OxEmptyNote(LangKt.tx("Загружаем долги…", new Object[0]), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__291656976$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C204@7994L55:DebtsScreen.kt#fh874k");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-291656976, i, -1, "uz.FonRo.pos.ui.money.ComposableSingletons$DebtsScreenKt.lambda$-291656976.<anonymous> (DebtsScreen.kt:204)");
            }
            BasicsKt.OxEmptyNote(LangKt.tx("Непогашенных долгов за период нет 🎉", new Object[0]), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1176392783$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C222@8710L45:DebtsScreen.kt#fh874k");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1176392783, i, -1, "uz.FonRo.pos.ui.money.ComposableSingletons$DebtsScreenKt.lambda$-1176392783.<anonymous> (DebtsScreen.kt:222)");
            }
            BasicsKt.OxEmptyNote(LangKt.tx("Должников за период нет 🎉", new Object[0]), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1937423125$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C257@10247L47:DebtsScreen.kt#fh874k");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1937423125, i, -1, "uz.FonRo.pos.ui.money.ComposableSingletons$DebtsScreenKt.lambda$-1937423125.<anonymous> (DebtsScreen.kt:257)");
            }
            BasicsKt.OxEmptyNote(LangKt.tx("За период долги не погашали.", new Object[0]), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
