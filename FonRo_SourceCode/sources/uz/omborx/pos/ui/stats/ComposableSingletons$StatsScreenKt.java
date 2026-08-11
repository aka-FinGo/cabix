package uz.FonRo.pos.ui.stats;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.lazy.LazyItemScope;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.ui.components.PageHeadKt;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: StatsScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$StatsScreenKt {
    public static final ComposableSingletons$StatsScreenKt INSTANCE = new ComposableSingletons$StatsScreenKt();
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$8567948 = ComposableLambdaKt.composableLambdaInstance(8567948, false, new Function3() { // from class: uz.FonRo.pos.ui.stats.ComposableSingletons$StatsScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$StatsScreenKt.lambda_8567948$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-2016974397, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f109lambda$2016974397 = ComposableLambdaKt.composableLambdaInstance(-2016974397, false, new Function3() { // from class: uz.FonRo.pos.ui.stats.ComposableSingletons$StatsScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$StatsScreenKt.lambda__2016974397$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-2016974397$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m10156getLambda$2016974397$app() {
        return f109lambda$2016974397;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$8567948$app() {
        return lambda$8567948;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_8567948$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C223@9632L28:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(8567948, i, -1, "uz.FonRo.pos.ui.stats.ComposableSingletons$StatsScreenKt.lambda$8567948.<anonymous> (StatsScreen.kt:223)");
            }
            PageHeadKt.OxPageHead(LangKt.tx("Статистика", new Object[0]), null, null, false, null, composer, 0, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__2016974397$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C511@20065L283:StatsScreen.kt#fklwc3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2016974397, i, -1, "uz.FonRo.pos.ui.stats.ComposableSingletons$StatsScreenKt.lambda$-2016974397.<anonymous> (StatsScreen.kt:511)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Сводка", new Object[0]), PaddingKt.m1052paddingqDBjuR0(Modifier.INSTANCE, Dp.m6989constructorimpl(2.0f), Dp.m6989constructorimpl(4.0f), Dp.m6989constructorimpl(2.0f), Dp.m6989constructorimpl(10.0f)), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), 0L, TextUnitKt.getSp(18), FontWeight.INSTANCE.getExtraBold(), null, null, null, null, TextUnitKt.getSp(-0.3d), null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777081, null), composer, 0, 0, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
