package uz.FonRo.pos.ui.print;

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
import uz.FonRo.pos.ui.components.PageHeadKt;

/* compiled from: PrintLabelsScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$PrintLabelsScreenKt {
    public static final ComposableSingletons$PrintLabelsScreenKt INSTANCE = new ComposableSingletons$PrintLabelsScreenKt();

    /* renamed from: lambda$-1262166966, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f107lambda$1262166966 = ComposableLambdaKt.composableLambdaInstance(-1262166966, false, new Function3() { // from class: uz.FonRo.pos.ui.print.ComposableSingletons$PrintLabelsScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$PrintLabelsScreenKt.lambda__1262166966$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-1262166966$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m10082getLambda$1262166966$app() {
        return f107lambda$1262166966;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1262166966$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C254@10549L167:PrintLabelsScreen.kt#fixedd");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1262166966, i, -1, "uz.FonRo.pos.ui.print.ComposableSingletons$PrintLabelsScreenKt.lambda$-1262166966.<anonymous> (PrintLabelsScreen.kt:254)");
            }
            PageHeadKt.OxPageHead(LangKt.tx("Печать штрихкодов", new Object[0]), null, LangKt.tx("Наклейки для товаров, которые приехали без кода", new Object[0]), false, null, composer, 0, 26);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
