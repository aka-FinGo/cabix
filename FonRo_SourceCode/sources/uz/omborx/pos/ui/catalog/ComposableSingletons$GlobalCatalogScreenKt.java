package uz.FonRo.pos.ui.catalog;

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

/* compiled from: GlobalCatalogScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$GlobalCatalogScreenKt {
    public static final ComposableSingletons$GlobalCatalogScreenKt INSTANCE = new ComposableSingletons$GlobalCatalogScreenKt();
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1242273378 = ComposableLambdaKt.composableLambdaInstance(1242273378, false, new Function3() { // from class: uz.FonRo.pos.ui.catalog.ComposableSingletons$GlobalCatalogScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$GlobalCatalogScreenKt.lambda_1242273378$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$628774951 = ComposableLambdaKt.composableLambdaInstance(628774951, false, new Function3() { // from class: uz.FonRo.pos.ui.catalog.ComposableSingletons$GlobalCatalogScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$GlobalCatalogScreenKt.lambda_628774951$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1242273378$app() {
        return lambda$1242273378;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$628774951$app() {
        return lambda$628774951;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1242273378$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C193@7961L219:GlobalCatalogScreen.kt#i65cod");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1242273378, i, -1, "uz.FonRo.pos.ui.catalog.ComposableSingletons$GlobalCatalogScreenKt.lambda$1242273378.<anonymous> (GlobalCatalogScreen.kt:193)");
            }
            PageHeadKt.OxPageHead(LangKt.tx("Каталог FonRo", new Object[0]), null, LangKt.tx("Выберите готовые товары — они добавятся в магазин с фото и штрихкодом. Цены и остатки заполнит приход.", new Object[0]), false, null, composer, 0, 26);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_628774951$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C293@13107L28:GlobalCatalogScreen.kt#i65cod");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(628774951, i, -1, "uz.FonRo.pos.ui.catalog.ComposableSingletons$GlobalCatalogScreenKt.lambda$628774951.<anonymous> (GlobalCatalogScreen.kt:293)");
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
}
