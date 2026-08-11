package uz.FonRo.pos.ui.more;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.core.LangKt;
import uz.FonRo.pos.ui.components.BasicsKt;
import uz.FonRo.pos.ui.components.PageHeadKt;

/* compiled from: LogScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ComposableSingletons$LogScreenKt {
    public static final ComposableSingletons$LogScreenKt INSTANCE = new ComposableSingletons$LogScreenKt();
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$32907972 = ComposableLambdaKt.composableLambdaInstance(32907972, false, new Function3() { // from class: uz.FonRo.pos.ui.more.ComposableSingletons$LogScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LogScreenKt.lambda_32907972$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$452403743 = ComposableLambdaKt.composableLambdaInstance(452403743, false, new Function3() { // from class: uz.FonRo.pos.ui.more.ComposableSingletons$LogScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LogScreenKt.lambda_452403743$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-1290497348, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f98lambda$1290497348 = ComposableLambdaKt.composableLambdaInstance(-1290497348, false, new Function3() { // from class: uz.FonRo.pos.ui.more.ComposableSingletons$LogScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LogScreenKt.lambda__1290497348$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$46041796 = ComposableLambdaKt.composableLambdaInstance(46041796, false, new Function3() { // from class: uz.FonRo.pos.ui.more.ComposableSingletons$LogScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LogScreenKt.lambda_46041796$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-1290497348$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m10019getLambda$1290497348$app() {
        return f98lambda$1290497348;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$32907972$app() {
        return lambda$32907972;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$452403743$app() {
        return lambda$452403743;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$46041796$app() {
        return lambda$46041796;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_32907972$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C117@4598L129:LogScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(32907972, i, -1, "uz.FonRo.pos.ui.more.ComposableSingletons$LogScreenKt.lambda$32907972.<anonymous> (LogScreen.kt:117)");
            }
            PageHeadKt.OxPageHead(LangKt.tx("Журнал", new Object[0]), null, LangKt.tx("Кто и что изменил · было → стало", new Object[0]), false, null, composer, 0, 26);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_452403743$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C125@4798L90:LogScreen.kt#1sifzz");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(452403743, i, -1, "uz.FonRo.pos.ui.more.ComposableSingletons$LogScreenKt.lambda$452403743.<anonymous> (LogScreen.kt:125)");
            }
            BasicsKt.OxEmptyNote(LangKt.tx("Журнал доступен владельцу и сотрудникам с правом на настройки магазина.", new Object[0]), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1290497348$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C156@5774L29:LogScreen.kt#1sifzz");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1290497348, i, -1, "uz.FonRo.pos.ui.more.ComposableSingletons$LogScreenKt.lambda$-1290497348.<anonymous> (LogScreen.kt:156)");
            }
            BasicsKt.OxEmptyNote(LangKt.tx("Загружаем…", new Object[0]), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_46041796$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C158@5913L44:LogScreen.kt#1sifzz");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(46041796, i, -1, "uz.FonRo.pos.ui.more.ComposableSingletons$LogScreenKt.lambda$46041796.<anonymous> (LogScreen.kt:158)");
            }
            BasicsKt.OxEmptyNote(LangKt.tx("За этот день записей нет.", new Object[0]), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
