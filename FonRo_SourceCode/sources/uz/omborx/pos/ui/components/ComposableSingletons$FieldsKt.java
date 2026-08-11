package uz.FonRo.pos.ui.components;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.rounded.SearchKt;
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
import uz.FonRo.pos.ui.theme.Ox;

/* compiled from: Fields.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$FieldsKt {
    public static final ComposableSingletons$FieldsKt INSTANCE = new ComposableSingletons$FieldsKt();

    /* renamed from: lambda$-33304736, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f73lambda$33304736 = ComposableLambdaKt.composableLambdaInstance(-33304736, false, new Function2() { // from class: uz.FonRo.pos.ui.components.ComposableSingletons$FieldsKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$FieldsKt.lambda__33304736$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: getLambda$-33304736$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9838getLambda$33304736$app() {
        return f73lambda$33304736;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__33304736$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C187@6692L148:Fields.kt#r5y9fm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-33304736, i, -1, "uz.FonRo.pos.ui.components.ComposableSingletons$FieldsKt.lambda$-33304736.<anonymous> (Fields.kt:187)");
            }
            IconKt.m2255Iconww6aTOc(SearchKt.getSearch(Icons.Rounded.INSTANCE), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(20.0f)), Ox.INSTANCE.m10200getDim20d7_KjU(), composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
