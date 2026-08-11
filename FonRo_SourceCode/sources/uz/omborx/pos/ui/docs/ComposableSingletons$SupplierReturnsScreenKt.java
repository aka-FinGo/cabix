package uz.FonRo.pos.ui.docs;

import androidx.compose.foundation.layout.BoxScope;
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

/* compiled from: SupplierReturnsScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$SupplierReturnsScreenKt {
    public static final ComposableSingletons$SupplierReturnsScreenKt INSTANCE = new ComposableSingletons$SupplierReturnsScreenKt();

    /* renamed from: lambda$-36148325, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f84lambda$36148325 = ComposableLambdaKt.composableLambdaInstance(-36148325, false, new Function2() { // from class: uz.FonRo.pos.ui.docs.ComposableSingletons$SupplierReturnsScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SupplierReturnsScreenKt.lambda__36148325$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1633014171 = ComposableLambdaKt.composableLambdaInstance(1633014171, false, new Function3() { // from class: uz.FonRo.pos.ui.docs.ComposableSingletons$SupplierReturnsScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SupplierReturnsScreenKt.lambda_1633014171$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-533313596, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f85lambda$533313596 = ComposableLambdaKt.composableLambdaInstance(-533313596, false, new Function3() { // from class: uz.FonRo.pos.ui.docs.ComposableSingletons$SupplierReturnsScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SupplierReturnsScreenKt.lambda__533313596$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$551740903 = ComposableLambdaKt.composableLambdaInstance(551740903, false, new Function3() { // from class: uz.FonRo.pos.ui.docs.ComposableSingletons$SupplierReturnsScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SupplierReturnsScreenKt.lambda_551740903$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-36148325$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9884getLambda$36148325$app() {
        return f84lambda$36148325;
    }

    /* renamed from: getLambda$-533313596$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m9885getLambda$533313596$app() {
        return f85lambda$533313596;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1633014171$app() {
        return lambda$1633014171;
    }

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$551740903$app() {
        return lambda$551740903;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__36148325$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C220@9288L78:SupplierReturnsScreen.kt#1so789");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-36148325, i, -1, "uz.FonRo.pos.ui.docs.ComposableSingletons$SupplierReturnsScreenKt.lambda$-36148325.<anonymous> (SupplierReturnsScreen.kt:220)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getUndo(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(19.0f)), 0L, composer, 432, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1633014171$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C236@9797L80:SupplierReturnsScreen.kt#1so789");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1633014171, i, -1, "uz.FonRo.pos.ui.docs.ComposableSingletons$SupplierReturnsScreenKt.lambda$1633014171.<anonymous> (SupplierReturnsScreen.kt:236)");
            }
            BasicsKt.OxEmptyNote(LangKt.tx("Возврат поставщику появится после обновления серверной части.", new Object[0]), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__533313596$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C238@9944L46:SupplierReturnsScreen.kt#1so789");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-533313596, i, -1, "uz.FonRo.pos.ui.docs.ComposableSingletons$SupplierReturnsScreenKt.lambda$-533313596.<anonymous> (SupplierReturnsScreen.kt:238)");
            }
            BasicsKt.OxEmptyNote(LangKt.tx("Возвратов за период не было", new Object[0]), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_551740903$lambda$0(BoxScope OxThumb, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxThumb, "$this$OxThumb");
        ComposerKt.sourceInformation(composer, "C400@16510L157:SupplierReturnsScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(551740903, i, -1, "uz.FonRo.pos.ui.docs.ComposableSingletons$SupplierReturnsScreenKt.lambda$551740903.<anonymous> (SupplierReturnsScreen.kt:400)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getUndo(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(21.0f)), Ox.INSTANCE.m10215getOrangeInk0d7_KjU(), composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
