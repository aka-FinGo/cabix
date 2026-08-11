package uz.FonRo.pos.ui.clients;

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

/* compiled from: ClientsScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$ClientsScreenKt {
    public static final ComposableSingletons$ClientsScreenKt INSTANCE = new ComposableSingletons$ClientsScreenKt();
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1201212999 = ComposableLambdaKt.composableLambdaInstance(1201212999, false, new Function3() { // from class: uz.FonRo.pos.ui.clients.ComposableSingletons$ClientsScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ClientsScreenKt.lambda_1201212999$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1201212999$app() {
        return lambda$1201212999;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1201212999$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C151@6373L25:ClientsScreen.kt#n7o21o");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1201212999, i, -1, "uz.FonRo.pos.ui.clients.ComposableSingletons$ClientsScreenKt.lambda$1201212999.<anonymous> (ClientsScreen.kt:151)");
            }
            PageHeadKt.OxPageHead(LangKt.tx("Клиенты", new Object[0]), null, null, false, null, composer, 0, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
