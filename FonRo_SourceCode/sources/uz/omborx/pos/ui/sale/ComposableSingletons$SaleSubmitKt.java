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
import uz.FonRo.pos.ui.components.OxIcons;

/* compiled from: SaleSubmit.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$SaleSubmitKt {
    public static final ComposableSingletons$SaleSubmitKt INSTANCE = new ComposableSingletons$SaleSubmitKt();
    private static Function2<Composer, Integer, Unit> lambda$1801921236 = ComposableLambdaKt.composableLambdaInstance(1801921236, false, new Function2() { // from class: uz.FonRo.pos.ui.sale.ComposableSingletons$SaleSubmitKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SaleSubmitKt.lambda_1801921236$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1801921236$app() {
        return lambda$1801921236;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1801921236$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C216@7472L81:SaleSubmit.kt#1sewlp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1801921236, i, -1, "uz.FonRo.pos.ui.sale.ComposableSingletons$SaleSubmitKt.lambda$1801921236.<anonymous> (SaleSubmit.kt:216)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getPrinter(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(18.0f)), 0L, composer, 432, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
