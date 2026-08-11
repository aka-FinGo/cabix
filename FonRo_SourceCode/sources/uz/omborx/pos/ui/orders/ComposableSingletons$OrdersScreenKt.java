package uz.FonRo.pos.ui.orders;

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
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.theme.Ox;

/* compiled from: OrdersScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$OrdersScreenKt {
    public static final ComposableSingletons$OrdersScreenKt INSTANCE = new ComposableSingletons$OrdersScreenKt();

    /* renamed from: lambda$-318095790, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f105lambda$318095790 = ComposableLambdaKt.composableLambdaInstance(-318095790, false, new Function2() { // from class: uz.FonRo.pos.ui.orders.ComposableSingletons$OrdersScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$OrdersScreenKt.lambda__318095790$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-549230532, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f106lambda$549230532 = ComposableLambdaKt.composableLambdaInstance(-549230532, false, new Function3() { // from class: uz.FonRo.pos.ui.orders.ComposableSingletons$OrdersScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$OrdersScreenKt.lambda__549230532$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-228361915, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f104lambda$228361915 = ComposableLambdaKt.composableLambdaInstance(-228361915, false, new Function3() { // from class: uz.FonRo.pos.ui.orders.ComposableSingletons$OrdersScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$OrdersScreenKt.lambda__228361915$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1216578834, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f103lambda$1216578834 = ComposableLambdaKt.composableLambdaInstance(-1216578834, false, new Function3() { // from class: uz.FonRo.pos.ui.orders.ComposableSingletons$OrdersScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$OrdersScreenKt.lambda__1216578834$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-1216578834$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m10051getLambda$1216578834$app() {
        return f103lambda$1216578834;
    }

    /* renamed from: getLambda$-228361915$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m10052getLambda$228361915$app() {
        return f104lambda$228361915;
    }

    /* renamed from: getLambda$-318095790$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m10053getLambda$318095790$app() {
        return f105lambda$318095790;
    }

    /* renamed from: getLambda$-549230532$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m10054getLambda$549230532$app() {
        return f106lambda$549230532;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__318095790$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C288@11607L228:OrdersScreen.kt#ge60a7");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-318095790, i, -1, "uz.FonRo.pos.ui.orders.ComposableSingletons$OrdersScreenKt.lambda$-318095790.<anonymous> (OrdersScreen.kt:288)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getRefresh(), LangKt.tx("Обновить", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(20.0f)), Ox.INSTANCE.m10220getPrimary0d7_KjU(), composer, 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__549230532$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C355@13926L28:OrdersScreen.kt#ge60a7");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-549230532, i, -1, "uz.FonRo.pos.ui.orders.ComposableSingletons$OrdersScreenKt.lambda$-549230532.<anonymous> (OrdersScreen.kt:355)");
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__228361915$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C384@15222L28:OrdersScreen.kt#ge60a7");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-228361915, i, -1, "uz.FonRo.pos.ui.orders.ComposableSingletons$OrdersScreenKt.lambda$-228361915.<anonymous> (OrdersScreen.kt:384)");
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1216578834$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C387@15340L208:OrdersScreen.kt#ge60a7");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1216578834, i, -1, "uz.FonRo.pos.ui.orders.ComposableSingletons$OrdersScreenKt.lambda$-1216578834.<anonymous> (OrdersScreen.kt:387)");
            }
            OrdersScreenKt.ShopEmpty("⭐", LangKt.tx("Отзывов пока нет", new Object[0]), LangKt.tx("Покупатели смогут оставлять отзывы на витрине.", new Object[0]), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
