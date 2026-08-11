package uz.FonRo.pos.ui.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* compiled from: PageHead.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ai\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\r2 \b\u0002\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007b\u0002\b\u0011b\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016¢\u0006\u0002\u0010\u0013\"\u001f\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0017"}, d2 = {"LocalPageClose", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lkotlin/Function0;", "", "getLocalPageClose", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "OxPageHead", "title", "", "modifier", "Landroidx/compose/ui/Modifier;", "subtitle", "closable", "", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/runtime/ComposableInferredTarget;", "scheme", "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]", "app"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class PageHeadKt {
    private static final ProvidableCompositionLocal<Function0<Unit>> LocalPageClose = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: uz.FonRo.pos.ui.components.PageHeadKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return PageHeadKt.LocalPageClose$lambda$0();
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Function0 LocalPageClose$lambda$0() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit OxPageHead$lambda$1(String str, Modifier modifier, String str2, boolean z, Function3 function3, int i, int i2, Composer composer, int i3) {
        OxPageHead(str, modifier, str2, z, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final ProvidableCompositionLocal<Function0<Unit>> getLocalPageClose() {
        return LocalPageClose;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OxPageHead(final java.lang.String r34, androidx.compose.ui.Modifier r35, java.lang.String r36, boolean r37, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 975
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.components.PageHeadKt.OxPageHead(java.lang.String, androidx.compose.ui.Modifier, java.lang.String, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
