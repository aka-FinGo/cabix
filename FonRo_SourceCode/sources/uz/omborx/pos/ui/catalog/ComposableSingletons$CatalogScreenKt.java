package uz.FonRo.pos.ui.catalog;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.theme.Ox;

/* compiled from: CatalogScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$CatalogScreenKt {
    public static final ComposableSingletons$CatalogScreenKt INSTANCE = new ComposableSingletons$CatalogScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$566335622 = ComposableLambdaKt.composableLambdaInstance(566335622, false, new Function2() { // from class: uz.FonRo.pos.ui.catalog.ComposableSingletons$CatalogScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CatalogScreenKt.lambda_566335622$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1586001623 = ComposableLambdaKt.composableLambdaInstance(1586001623, false, new Function3() { // from class: uz.FonRo.pos.ui.catalog.ComposableSingletons$CatalogScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$CatalogScreenKt.lambda_1586001623$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1586001623$app() {
        return lambda$1586001623;
    }

    public final Function2<Composer, Integer, Unit> getLambda$566335622$app() {
        return lambda$566335622;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_566335622$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C197@8791L184:CatalogScreen.kt#i65cod");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(566335622, i, -1, "uz.FonRo.pos.ui.catalog.ComposableSingletons$CatalogScreenKt.lambda$566335622.<anonymous> (CatalogScreen.kt:197)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getArchive(), LangKt.tx("Архив товаров", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(23.0f)), Ox.INSTANCE.m10223getPurple0d7_KjU(), composer, 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1586001623$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C280@11901L31:CatalogScreen.kt#i65cod");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1586001623, i, -1, "uz.FonRo.pos.ui.catalog.ComposableSingletons$CatalogScreenKt.lambda$1586001623.<anonymous> (CatalogScreen.kt:280)");
            }
            BasicsKt.OxEmptyNote(LangKt.tx("Товаров нет.", new Object[0]), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
