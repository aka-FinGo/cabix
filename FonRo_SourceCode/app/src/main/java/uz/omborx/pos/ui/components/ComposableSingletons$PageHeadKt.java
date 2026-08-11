package uz.FonRo.pos.ui.components;

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
import uz.FonRo.pos.ui.theme.Ox;

/* compiled from: PageHead.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$PageHeadKt {
    public static final ComposableSingletons$PageHeadKt INSTANCE = new ComposableSingletons$PageHeadKt();

    /* renamed from: lambda$-1963063756, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f74lambda$1963063756 = ComposableLambdaKt.composableLambdaInstance(-1963063756, false, new Function2() { // from class: uz.FonRo.pos.ui.components.ComposableSingletons$PageHeadKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PageHeadKt.lambda__1963063756$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: getLambda$-1963063756$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9839getLambda$1963063756$app() {
        return f74lambda$1963063756;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1963063756$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C66@2589L201:PageHead.kt#r5y9fm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1963063756, i, -1, "uz.FonRo.pos.ui.components.ComposableSingletons$PageHeadKt.lambda$-1963063756.<anonymous> (PageHead.kt:66)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getClose(), LangKt.tx("Закрыть", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(21.0f)), Ox.INSTANCE.m10199getDim0d7_KjU(), composer, 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
