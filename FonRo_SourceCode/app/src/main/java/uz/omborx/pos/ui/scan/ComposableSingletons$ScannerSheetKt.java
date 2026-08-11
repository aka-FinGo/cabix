package uz.FonRo.pos.ui.scan;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.rounded.ShoppingCartKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.core.LangKt;

/* compiled from: ScannerSheet.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$ScannerSheetKt {
    public static final ComposableSingletons$ScannerSheetKt INSTANCE = new ComposableSingletons$ScannerSheetKt();
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$538319603 = ComposableLambdaKt.composableLambdaInstance(538319603, false, new Function3() { // from class: uz.FonRo.pos.ui.scan.ComposableSingletons$ScannerSheetKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ScannerSheetKt.lambda_538319603$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$538319603$app() {
        return lambda$538319603;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_538319603$lambda$0(BoxScope BadgedBox, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
        ComposerKt.sourceInformation(composer, "C270@11968L47:ScannerSheet.kt#1sevdj");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(538319603, i, -1, "uz.FonRo.pos.ui.scan.ComposableSingletons$ScannerSheetKt.lambda$538319603.<anonymous> (ScannerSheet.kt:270)");
            }
            IconKt.m2255Iconww6aTOc(ShoppingCartKt.getShoppingCart(Icons.Rounded.INSTANCE), LangKt.tx("Корзина", new Object[0]), (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
