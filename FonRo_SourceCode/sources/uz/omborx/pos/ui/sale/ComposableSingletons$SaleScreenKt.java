package uz.FonRo.pos.ui.sale;

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

/* compiled from: SaleScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$SaleScreenKt {
    public static final ComposableSingletons$SaleScreenKt INSTANCE = new ComposableSingletons$SaleScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$12704211 = ComposableLambdaKt.composableLambdaInstance(12704211, false, new Function2() { // from class: uz.FonRo.pos.ui.sale.ComposableSingletons$SaleScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SaleScreenKt.lambda_12704211$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1485491900 = ComposableLambdaKt.composableLambdaInstance(1485491900, false, new Function2() { // from class: uz.FonRo.pos.ui.sale.ComposableSingletons$SaleScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SaleScreenKt.lambda_1485491900$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$12704211$app() {
        return lambda$12704211;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1485491900$app() {
        return lambda$1485491900;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_12704211$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C213@8334L100:SaleScreen.kt#1sewlp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(12704211, i, -1, "uz.FonRo.pos.ui.sale.ComposableSingletons$SaleScreenKt.lambda$12704211.<anonymous> (SaleScreen.kt:213)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getScan(), LangKt.tx("Сканировать штрихкод", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(21.0f)), 0L, composer, 384, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1485491900$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C219@8652L98:SaleScreen.kt#1sewlp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1485491900, i, -1, "uz.FonRo.pos.ui.sale.ComposableSingletons$SaleScreenKt.lambda$1485491900.<anonymous> (SaleScreen.kt:219)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getReceipt(), LangKt.tx("Отложенные чеки", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(21.0f)), 0L, composer, 384, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
