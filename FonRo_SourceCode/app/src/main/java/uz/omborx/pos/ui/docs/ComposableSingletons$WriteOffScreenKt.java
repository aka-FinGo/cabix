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
import uz.FonRo.pos.ui.components.BasicsKt;

/* compiled from: WriteOffScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$WriteOffScreenKt {
    public static final ComposableSingletons$WriteOffScreenKt INSTANCE = new ComposableSingletons$WriteOffScreenKt();
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1121406443 = ComposableLambdaKt.composableLambdaInstance(1121406443, false, new Function3() { // from class: uz.FonRo.pos.ui.docs.ComposableSingletons$WriteOffScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$WriteOffScreenKt.lambda_1121406443$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$200921044 = ComposableLambdaKt.composableLambdaInstance(200921044, false, new Function3() { // from class: uz.FonRo.pos.ui.docs.ComposableSingletons$WriteOffScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$WriteOffScreenKt.lambda_200921044$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1121406443$app() {
        return lambda$1121406443;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$200921044$app() {
        return lambda$200921044;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1121406443$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C197@8336L70:WriteOffScreen.kt#1so789");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1121406443, i, -1, "uz.FonRo.pos.ui.docs.ComposableSingletons$WriteOffScreenKt.lambda$1121406443.<anonymous> (WriteOffScreen.kt:197)");
            }
            BasicsKt.OxEmptyNote(LangKt.tx("Списание появится после обновления серверной части.", new Object[0]), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_200921044$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C199@8473L45:WriteOffScreen.kt#1so789");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(200921044, i, -1, "uz.FonRo.pos.ui.docs.ComposableSingletons$WriteOffScreenKt.lambda$200921044.<anonymous> (WriteOffScreen.kt:199)");
            }
            BasicsKt.OxEmptyNote(LangKt.tx("Списаний за период не было", new Object[0]), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
