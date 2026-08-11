package uz.FonRo.pos.ui.catalog;

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
import uz.FonRo.pos.ui.theme.Ox;

/* compiled from: CategorySheets.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$CategorySheetsKt {
    public static final ComposableSingletons$CategorySheetsKt INSTANCE = new ComposableSingletons$CategorySheetsKt();

    /* renamed from: lambda$-2114367880, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f72lambda$2114367880 = ComposableLambdaKt.composableLambdaInstance(-2114367880, false, new Function2() { // from class: uz.FonRo.pos.ui.catalog.ComposableSingletons$CategorySheetsKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CategorySheetsKt.lambda__2114367880$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: getLambda$-2114367880$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9790getLambda$2114367880$app() {
        return f72lambda$2114367880;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__2114367880$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C506@19682L174:CategorySheets.kt#i65cod");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2114367880, i, -1, "uz.FonRo.pos.ui.catalog.ComposableSingletons$CategorySheetsKt.lambda$-2114367880.<anonymous> (CategorySheets.kt:506)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getBox(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(18.0f)), Ox.INSTANCE.m10199getDim0d7_KjU(), composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
