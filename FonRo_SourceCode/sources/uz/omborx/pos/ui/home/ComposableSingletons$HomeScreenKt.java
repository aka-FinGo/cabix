package uz.FonRo.pos.ui.home;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.ui.components.OxIcons;

/* compiled from: HomeScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$HomeScreenKt {
    public static final ComposableSingletons$HomeScreenKt INSTANCE = new ComposableSingletons$HomeScreenKt();

    /* renamed from: lambda$-363836815, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f87lambda$363836815 = ComposableLambdaKt.composableLambdaInstance(-363836815, false, new Function2() { // from class: uz.FonRo.pos.ui.home.ComposableSingletons$HomeScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$HomeScreenKt.lambda__363836815$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-748387686, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f88lambda$748387686 = ComposableLambdaKt.composableLambdaInstance(-748387686, false, new Function2() { // from class: uz.FonRo.pos.ui.home.ComposableSingletons$HomeScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$HomeScreenKt.lambda__748387686$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$433845049 = ComposableLambdaKt.composableLambdaInstance(433845049, false, new Function2() { // from class: uz.FonRo.pos.ui.home.ComposableSingletons$HomeScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$HomeScreenKt.lambda_433845049$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: getLambda$-363836815$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9951getLambda$363836815$app() {
        return f87lambda$363836815;
    }

    /* renamed from: getLambda$-748387686$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9952getLambda$748387686$app() {
        return f88lambda$748387686;
    }

    public final Function2<Composer, Integer, Unit> getLambda$433845049$app() {
        return lambda$433845049;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__363836815$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C265@10373L91:HomeScreen.kt#1sln1x");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-363836815, i, -1, "uz.FonRo.pos.ui.home.ComposableSingletons$HomeScreenKt.lambda$-363836815.<anonymous> (HomeScreen.kt:265)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getBell(), LangKt.tx("Уведомления", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(20.0f)), 0L, composer, 384, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__748387686$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C268@10539L87:HomeScreen.kt#1sln1x");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-748387686, i, -1, "uz.FonRo.pos.ui.home.ComposableSingletons$HomeScreenKt.lambda$-748387686.<anonymous> (HomeScreen.kt:268)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getClock(), LangKt.tx("Журнал", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(20.0f)), 0L, composer, 384, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_433845049$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C271@10702L89:HomeScreen.kt#1sln1x");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(433845049, i, -1, "uz.FonRo.pos.ui.home.ComposableSingletons$HomeScreenKt.lambda$433845049.<anonymous> (HomeScreen.kt:271)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getGear(), LangKt.tx("Настройки", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(20.0f)), 0L, composer, 384, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
