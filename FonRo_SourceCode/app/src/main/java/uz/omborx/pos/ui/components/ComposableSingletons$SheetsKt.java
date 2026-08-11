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

/* compiled from: Sheets.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$SheetsKt {
    public static final ComposableSingletons$SheetsKt INSTANCE = new ComposableSingletons$SheetsKt();

    /* renamed from: lambda$-2048009993, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f75lambda$2048009993 = ComposableLambdaKt.composableLambdaInstance(-2048009993, false, new Function2() { // from class: uz.FonRo.pos.ui.components.ComposableSingletons$SheetsKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SheetsKt.lambda__2048009993$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-240228486, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f76lambda$240228486 = ComposableLambdaKt.composableLambdaInstance(-240228486, false, new Function2() { // from class: uz.FonRo.pos.ui.components.ComposableSingletons$SheetsKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SheetsKt.lambda__240228486$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$905512013 = ComposableLambdaKt.composableLambdaInstance(905512013, false, new Function2() { // from class: uz.FonRo.pos.ui.components.ComposableSingletons$SheetsKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SheetsKt.lambda_905512013$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-703948767, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f77lambda$703948767 = ComposableLambdaKt.composableLambdaInstance(-703948767, false, new Function2() { // from class: uz.FonRo.pos.ui.components.ComposableSingletons$SheetsKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SheetsKt.lambda__703948767$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-847571286, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f78lambda$847571286 = ComposableLambdaKt.composableLambdaInstance(-847571286, false, new Function2() { // from class: uz.FonRo.pos.ui.components.ComposableSingletons$SheetsKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SheetsKt.lambda__847571286$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: getLambda$-2048009993$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9840getLambda$2048009993$app() {
        return f75lambda$2048009993;
    }

    /* renamed from: getLambda$-240228486$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9841getLambda$240228486$app() {
        return f76lambda$240228486;
    }

    /* renamed from: getLambda$-703948767$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9842getLambda$703948767$app() {
        return f77lambda$703948767;
    }

    /* renamed from: getLambda$-847571286$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9843getLambda$847571286$app() {
        return f78lambda$847571286;
    }

    public final Function2<Composer, Integer, Unit> getLambda$905512013$app() {
        return lambda$905512013;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__2048009993$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C106@4647L8:Sheets.kt#r5y9fm");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2048009993, i, -1, "uz.FonRo.pos.ui.components.ComposableSingletons$SheetsKt.lambda$-2048009993.<anonymous> (Sheets.kt:106)");
            }
            SheetsKt.OxGrip(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__240228486$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C131@5494L173:Sheets.kt#r5y9fm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-240228486, i, -1, "uz.FonRo.pos.ui.components.ComposableSingletons$SheetsKt.lambda$-240228486.<anonymous> (Sheets.kt:131)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getClose(), LangKt.tx("Закрыть", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(18.0f)), Ox.INSTANCE.m10199getDim0d7_KjU(), composer, 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_905512013$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C244@10530L209:Sheets.kt#r5y9fm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(905512013, i, -1, "uz.FonRo.pos.ui.components.ComposableSingletons$SheetsKt.lambda$905512013.<anonymous> (Sheets.kt:244)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getClose(), LangKt.tx("Закрыть", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(18.0f)), Ox.INSTANCE.m10199getDim0d7_KjU(), composer, 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__703948767$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C296@12439L8:Sheets.kt#r5y9fm");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-703948767, i, -1, "uz.FonRo.pos.ui.components.ComposableSingletons$SheetsKt.lambda$-703948767.<anonymous> (Sheets.kt:296)");
            }
            SheetsKt.OxGrip(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__847571286$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C322@13545L185:Sheets.kt#r5y9fm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-847571286, i, -1, "uz.FonRo.pos.ui.components.ComposableSingletons$SheetsKt.lambda$-847571286.<anonymous> (Sheets.kt:322)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getClose(), LangKt.tx("Закрыть", new Object[0]), SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(18.0f)), Ox.INSTANCE.m10199getDim0d7_KjU(), composer, 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
