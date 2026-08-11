package uz.FonRo.pos.ui.more;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.PageHeadKt;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: MoreScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$MoreScreenKt {
    public static final ComposableSingletons$MoreScreenKt INSTANCE = new ComposableSingletons$MoreScreenKt();
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$813029750 = ComposableLambdaKt.composableLambdaInstance(813029750, false, new Function3() { // from class: uz.FonRo.pos.ui.more.ComposableSingletons$MoreScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$MoreScreenKt.lambda_813029750$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-435361681, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f100lambda$435361681 = ComposableLambdaKt.composableLambdaInstance(-435361681, false, new Function3() { // from class: uz.FonRo.pos.ui.more.ComposableSingletons$MoreScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$MoreScreenKt.lambda__435361681$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$221539857 = ComposableLambdaKt.composableLambdaInstance(221539857, false, new Function3() { // from class: uz.FonRo.pos.ui.more.ComposableSingletons$MoreScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$MoreScreenKt.lambda_221539857$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$442375880 = ComposableLambdaKt.composableLambdaInstance(442375880, false, new Function3() { // from class: uz.FonRo.pos.ui.more.ComposableSingletons$MoreScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$MoreScreenKt.lambda_442375880$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1495763953 = ComposableLambdaKt.composableLambdaInstance(1495763953, false, new Function3() { // from class: uz.FonRo.pos.ui.more.ComposableSingletons$MoreScreenKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$MoreScreenKt.lambda_1495763953$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$97485108 = ComposableLambdaKt.composableLambdaInstance(97485108, false, new Function3() { // from class: uz.FonRo.pos.ui.more.ComposableSingletons$MoreScreenKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$MoreScreenKt.lambda_97485108$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1289207256, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f99lambda$1289207256 = ComposableLambdaKt.composableLambdaInstance(-1289207256, false, new Function3() { // from class: uz.FonRo.pos.ui.more.ComposableSingletons$MoreScreenKt$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$MoreScreenKt.lambda__1289207256$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-1289207256$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m10020getLambda$1289207256$app() {
        return f99lambda$1289207256;
    }

    /* renamed from: getLambda$-435361681$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m10021getLambda$435361681$app() {
        return f100lambda$435361681;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1495763953$app() {
        return lambda$1495763953;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$221539857$app() {
        return lambda$221539857;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$442375880$app() {
        return lambda$442375880;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$813029750$app() {
        return lambda$813029750;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$97485108$app() {
        return lambda$97485108;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_813029750$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C229@9078L21:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(813029750, i, -1, "uz.FonRo.pos.ui.more.ComposableSingletons$MoreScreenKt.lambda$813029750.<anonymous> (MoreScreen.kt:229)");
            }
            PageHeadKt.OxPageHead(LangKt.tx("Ещё", new Object[0]), null, null, false, null, composer, 0, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__435361681$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C341@14043L26:MoreScreen.kt#1sifzz");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-435361681, i, -1, "uz.FonRo.pos.ui.more.ComposableSingletons$MoreScreenKt.lambda$-435361681.<anonymous> (MoreScreen.kt:341)");
            }
            MoreScreenKt.SetLabel(LangKt.tx("Приложение", new Object[0]), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_221539857$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C436@18075L22:MoreScreen.kt#1sifzz");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(221539857, i, -1, "uz.FonRo.pos.ui.more.ComposableSingletons$MoreScreenKt.lambda$221539857.<anonymous> (MoreScreen.kt:436)");
            }
            MoreScreenKt.SetLabel(LangKt.tx("Доступ", new Object[0]), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_442375880$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C455@18764L23:MoreScreen.kt#1sifzz");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(442375880, i, -1, "uz.FonRo.pos.ui.more.ComposableSingletons$MoreScreenKt.lambda$442375880.<anonymous> (MoreScreen.kt:455)");
            }
            MoreScreenKt.SetLabel(LangKt.tx("Магазин", new Object[0]), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1495763953$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C471@19295L35:MoreScreen.kt#1sifzz");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1495763953, i, -1, "uz.FonRo.pos.ui.more.ComposableSingletons$MoreScreenKt.lambda$1495763953.<anonymous> (MoreScreen.kt:471)");
            }
            MoreScreenKt.SetLabel(LangKt.tx("Правовая информация", new Object[0]), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_97485108$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C500@20148L219:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(97485108, i, -1, "uz.FonRo.pos.ui.more.ComposableSingletons$MoreScreenKt.lambda$97485108.<anonymous> (MoreScreen.kt:500)");
            }
            TextKt.m2798Text4IGK_g("FonRo · Android 9.0", PaddingKt.m1053paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(4.0f), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getCaption(), Ox.INSTANCE.m10200getDim20d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 48, 0, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1289207256$lambda$0(RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "<this>");
        ComposerKt.sourceInformation(composer, "C859@34848L143:MoreScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1289207256, i, -1, "uz.FonRo.pos.ui.more.ComposableSingletons$MoreScreenKt.lambda$-1289207256.<anonymous> (MoreScreen.kt:859)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getChevron(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(20.0f)), Ox.INSTANCE.m10200getDim20d7_KjU(), composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
