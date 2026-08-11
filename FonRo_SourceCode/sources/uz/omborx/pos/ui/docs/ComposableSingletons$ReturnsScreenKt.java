package uz.FonRo.pos.ui.docs;

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

/* compiled from: ReturnsScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$ReturnsScreenKt {
    public static final ComposableSingletons$ReturnsScreenKt INSTANCE = new ComposableSingletons$ReturnsScreenKt();

    /* renamed from: lambda$-930735030, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f80lambda$930735030 = ComposableLambdaKt.composableLambdaInstance(-930735030, false, new Function3() { // from class: uz.FonRo.pos.ui.docs.ComposableSingletons$ReturnsScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ReturnsScreenKt.lambda__930735030$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-930735030$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m9880getLambda$930735030$app() {
        return f80lambda$930735030;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__930735030$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C165@6901L26:ReturnsScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-930735030, i, -1, "uz.FonRo.pos.ui.docs.ComposableSingletons$ReturnsScreenKt.lambda$-930735030.<anonymous> (ReturnsScreen.kt:165)");
            }
            PageHeadKt.OxPageHead(LangKt.tx("Возвраты", new Object[0]), null, null, false, null, composer, 0, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
