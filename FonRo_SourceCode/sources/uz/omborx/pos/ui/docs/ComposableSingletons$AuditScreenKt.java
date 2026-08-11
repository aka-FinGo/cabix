package uz.FonRo.pos.ui.docs;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.PageHeadKt;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: AuditScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$AuditScreenKt {
    public static final ComposableSingletons$AuditScreenKt INSTANCE = new ComposableSingletons$AuditScreenKt();

    /* renamed from: lambda$-110449440, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f79lambda$110449440 = ComposableLambdaKt.composableLambdaInstance(-110449440, false, new Function3() { // from class: uz.FonRo.pos.ui.docs.ComposableSingletons$AuditScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AuditScreenKt.lambda__110449440$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$2006641445 = ComposableLambdaKt.composableLambdaInstance(2006641445, false, new Function3() { // from class: uz.FonRo.pos.ui.docs.ComposableSingletons$AuditScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AuditScreenKt.lambda_2006641445$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$968251550 = ComposableLambdaKt.composableLambdaInstance(968251550, false, new Function2() { // from class: uz.FonRo.pos.ui.docs.ComposableSingletons$AuditScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AuditScreenKt.lambda_968251550$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: getLambda$-110449440$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m9879getLambda$110449440$app() {
        return f79lambda$110449440;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$2006641445$app() {
        return lambda$2006641445;
    }

    public final Function2<Composer, Integer, Unit> getLambda$968251550$app() {
        return lambda$968251550;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__110449440$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C325@12707L23:AuditScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-110449440, i, -1, "uz.FonRo.pos.ui.docs.ComposableSingletons$AuditScreenKt.lambda$-110449440.<anonymous> (AuditScreen.kt:325)");
            }
            PageHeadKt.OxPageHead(LangKt.tx("Аудит", new Object[0]), null, null, false, null, composer, 0, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_2006641445$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C352@13737L232:AuditScreen.kt#1so789");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2006641445, i, -1, "uz.FonRo.pos.ui.docs.ComposableSingletons$AuditScreenKt.lambda$2006641445.<anonymous> (AuditScreen.kt:352)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Аудит доступен сотрудникам с правом «Аудит». Историю проверок видно всем.", new Object[0]), PaddingKt.m1053paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6989constructorimpl(12.0f), 7, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getCaption(), composer, 48, 0, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_968251550$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C733@26912L176:AuditScreen.kt#1so789");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(968251550, i, -1, "uz.FonRo.pos.ui.docs.ComposableSingletons$AuditScreenKt.lambda$968251550.<anonymous> (AuditScreen.kt:733)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getAdd(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(18.0f)), Ox.INSTANCE.m10217getPanel0d7_KjU(), composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
