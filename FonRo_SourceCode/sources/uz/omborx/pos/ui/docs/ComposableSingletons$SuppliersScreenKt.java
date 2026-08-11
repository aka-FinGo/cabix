package uz.FonRo.pos.ui.docs;

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
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.PageHeadKt;
import uz.FonRo.pos.ui.theme.Ox;

/* compiled from: SuppliersScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$SuppliersScreenKt {
    public static final ComposableSingletons$SuppliersScreenKt INSTANCE = new ComposableSingletons$SuppliersScreenKt();

    /* renamed from: lambda$-1264896886, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f86lambda$1264896886 = ComposableLambdaKt.composableLambdaInstance(-1264896886, false, new Function3() { // from class: uz.FonRo.pos.ui.docs.ComposableSingletons$SuppliersScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SuppliersScreenKt.lambda__1264896886$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1739393649 = ComposableLambdaKt.composableLambdaInstance(1739393649, false, new Function2() { // from class: uz.FonRo.pos.ui.docs.ComposableSingletons$SuppliersScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SuppliersScreenKt.lambda_1739393649$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1907929256 = ComposableLambdaKt.composableLambdaInstance(1907929256, false, new Function2() { // from class: uz.FonRo.pos.ui.docs.ComposableSingletons$SuppliersScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SuppliersScreenKt.lambda_1907929256$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: getLambda$-1264896886$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m9886getLambda$1264896886$app() {
        return f86lambda$1264896886;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1739393649$app() {
        return lambda$1739393649;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1907929256$app() {
        return lambda$1907929256;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1264896886$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C132@5342L28:SuppliersScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1264896886, i, -1, "uz.FonRo.pos.ui.docs.ComposableSingletons$SuppliersScreenKt.lambda$-1264896886.<anonymous> (SuppliersScreen.kt:132)");
            }
            PageHeadKt.OxPageHead(LangKt.tx("Поставщики", new Object[0]), null, null, false, null, composer, 0, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1739393649$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C178@7494L171:SuppliersScreen.kt#1so789");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1739393649, i, -1, "uz.FonRo.pos.ui.docs.ComposableSingletons$SuppliersScreenKt.lambda$1739393649.<anonymous> (SuppliersScreen.kt:178)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getAdd(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(19.0f)), 0L, composer, 432, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1907929256$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C195@8317L193:SuppliersScreen.kt#1so789");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1907929256, i, -1, "uz.FonRo.pos.ui.docs.ComposableSingletons$SuppliersScreenKt.lambda$1907929256.<anonymous> (SuppliersScreen.kt:195)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getUndo(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(19.0f)), Ox.INSTANCE.m10215getOrangeInk0d7_KjU(), composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
