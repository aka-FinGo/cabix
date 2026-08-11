package uz.FonRo.pos.ui.team;

import androidx.compose.foundation.layout.ColumnScope;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.OxIcons;
import uz.FonRo.pos.ui.components.PageHeadKt;
import uz.FonRo.pos.ui.theme.Ox;
import uz.FonRo.pos.ui.theme.OxType;

/* compiled from: TeamScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$TeamScreenKt {
    public static final ComposableSingletons$TeamScreenKt INSTANCE = new ComposableSingletons$TeamScreenKt();
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$507498334 = ComposableLambdaKt.composableLambdaInstance(507498334, false, new Function3() { // from class: uz.FonRo.pos.ui.team.ComposableSingletons$TeamScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$TeamScreenKt.lambda_507498334$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1358247346, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f112lambda$1358247346 = ComposableLambdaKt.composableLambdaInstance(-1358247346, false, new Function2() { // from class: uz.FonRo.pos.ui.team.ComposableSingletons$TeamScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TeamScreenKt.lambda__1358247346$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<ColumnScope, Composer, Integer, Unit> lambda$111754809 = ComposableLambdaKt.composableLambdaInstance(111754809, false, new Function3() { // from class: uz.FonRo.pos.ui.team.ComposableSingletons$TeamScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$TeamScreenKt.lambda_111754809$lambda$0((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1175636599, reason: not valid java name */
    private static Function3<ColumnScope, Composer, Integer, Unit> f111lambda$1175636599 = ComposableLambdaKt.composableLambdaInstance(-1175636599, false, new Function3() { // from class: uz.FonRo.pos.ui.team.ComposableSingletons$TeamScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$TeamScreenKt.lambda__1175636599$lambda$0((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-1175636599$app, reason: not valid java name */
    public final Function3<ColumnScope, Composer, Integer, Unit> m10166getLambda$1175636599$app() {
        return f111lambda$1175636599;
    }

    /* renamed from: getLambda$-1358247346$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m10167getLambda$1358247346$app() {
        return f112lambda$1358247346;
    }

    public final Function3<ColumnScope, Composer, Integer, Unit> getLambda$111754809$app() {
        return lambda$111754809;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$507498334$app() {
        return lambda$507498334;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_507498334$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C138@5781L130:TeamScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(507498334, i, -1, "uz.FonRo.pos.ui.team.ComposableSingletons$TeamScreenKt.lambda$507498334.<anonymous> (TeamScreen.kt:138)");
            }
            PageHeadKt.OxPageHead(LangKt.tx("Сотрудники", new Object[0]), null, LangKt.tx("Вход по ключу · права доступа", new Object[0]), false, null, composer, 0, 26);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1358247346$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C154@6402L188:TeamScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1358247346, i, -1, "uz.FonRo.pos.ui.team.ComposableSingletons$TeamScreenKt.lambda$-1358247346.<anonymous> (TeamScreen.kt:154)");
            }
            IconKt.m2255Iconww6aTOc(OxIcons.INSTANCE.getAdd(), (String) null, SizeKt.m1096size3ABfNKs(Modifier.INSTANCE, Dp.m6989constructorimpl(19.0f)), Ox.INSTANCE.m10217getPanel0d7_KjU(), composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_111754809$lambda$0(ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C462@17943L45,463@18009L10,464@18040L228:TeamScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(111754809, i, -1, "uz.FonRo.pos.ui.team.ComposableSingletons$TeamScreenKt.lambda$111754809.<anonymous> (TeamScreen.kt:462)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("Вход владельца", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, OxType.INSTANCE.getH3(), composer, 0, 0, 65534);
            BasicsKt.m9835VGap8Feqmps(Dp.m6989constructorimpl(6.0f), composer, 6);
            TextKt.m2798Text4IGK_g(LangKt.tx("Владелец входит по email и паролю — ключ доступа ему не нужен, а права у него полные и не редактируются.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1175636599$lambda$0(ColumnScope OxSoftCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OxSoftCard, "$this$OxSoftCard");
        ComposerKt.sourceInformation(composer, "C809@32579L221:TeamScreen.kt#1se6wn");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1175636599, i, -1, "uz.FonRo.pos.ui.team.ComposableSingletons$TeamScreenKt.lambda$-1175636599.<anonymous> (TeamScreen.kt:809)");
            }
            TextKt.m2798Text4IGK_g(LangKt.tx("После создания сотрудник получит ключ доступа — по нему он войдёт в приложение на своём телефоне.", new Object[0]), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6448copyp1EtxEg$default(OxType.INSTANCE.getBody(), Ox.INSTANCE.m10199getDim0d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
