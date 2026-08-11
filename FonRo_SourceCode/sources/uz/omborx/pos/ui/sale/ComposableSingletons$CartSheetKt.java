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
import uz.FonRo.pos.ui.theme.Ox;

/* compiled from: CartSheet.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$CartSheetKt {
    public static final ComposableSingletons$CartSheetKt INSTANCE = new ComposableSingletons$CartSheetKt();

    /* renamed from: lambda$-525702002, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f108lambda$525702002 = ComposableLambdaKt.composableLambdaInstance(-525702002, false, new Function2() { // from class: uz.FonRo.pos.ui.sale.ComposableSingletons$CartSheetKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CartSheetKt.lambda__525702002$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$931192740 = ComposableLambdaKt.composableLambdaInstance(931192740, false, new Function2() { // from class: uz.FonRo.pos.ui.sale.ComposableSingletons$CartSheetKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CartSheetKt.lambda_931192740$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: getLambda$-525702002$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m10127getLambda$525702002$app() {
        return f108lambda$525702002;
    }

    public final Function2<Composer, Integer, Unit> getLambda$931192740$app() {
        return lambda$931192740;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__525702002$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1134@42627L205:CartSheet.kt#1sewlp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-525702002, i, -1, "uz.FonRo.pos.ui.sale.ComposableSingletons$CartSheetKt.lambda$-525702002.<anonymous> (CartSheet.kt:1134)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getDelete(), LangKt.tx("Удалить", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(19.0f)), Ox.INSTANCE.m10196getDanger0d7_KjU(), composer, 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_931192740$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1285@47837L91:CartSheet.kt#1sewlp");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(931192740, i, -1, "uz.FonRo.pos.ui.sale.ComposableSingletons$CartSheetKt.lambda$931192740.<anonymous> (CartSheet.kt:1285)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getAdd(), LangKt.tx("Новый клиент", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(20.0f)), 0L, composer, 384, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
