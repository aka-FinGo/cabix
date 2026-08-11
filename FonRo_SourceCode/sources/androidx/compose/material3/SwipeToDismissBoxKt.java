package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: SwipeToDismissBox.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ay\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\u0013\u001aR\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\b2#\b\u0002\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00190\bH\u0007¢\u0006\u0002\u0010\u001d\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u001e"}, d2 = {"DismissVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "SwipeToDismissBox", "", "state", "Landroidx/compose/material3/SwipeToDismissBoxState;", "backgroundContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "enableDismissFromStartToEnd", "", "enableDismissFromEndToStart", "gesturesEnabled", FirebaseAnalytics.Param.CONTENT, "(Landroidx/compose/material3/SwipeToDismissBoxState;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ZZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberSwipeToDismissBoxState", "initialValue", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "confirmValueChange", "positionalThreshold", "", "Lkotlin/ParameterName;", "name", "totalDistance", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SwipeToDismissBoxState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class SwipeToDismissBoxKt {
    private static final float DismissVelocityThreshold = Dp.m6989constructorimpl(125.0f);

    public static final /* synthetic */ float access$getDismissVelocityThreshold$p() {
        return DismissVelocityThreshold;
    }

    public static final SwipeToDismissBoxState rememberSwipeToDismissBoxState(final SwipeToDismissBoxValue swipeToDismissBoxValue, final Function1<? super SwipeToDismissBoxValue, Boolean> function1, final Function1<? super Float, Float> function12, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -246335487, "C(rememberSwipeToDismissBoxState)P(1)185@7607L19,187@7687L7,195@7929L102,188@7706L325:SwipeToDismissBox.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            swipeToDismissBoxValue = SwipeToDismissBoxValue.Settled;
        }
        if ((i2 & 2) != 0) {
            function1 = new Function1<SwipeToDismissBoxValue, Boolean>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$rememberSwipeToDismissBoxState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SwipeToDismissBoxValue swipeToDismissBoxValue2) {
                    return true;
                }
            };
        }
        if ((i2 & 4) != 0) {
            function12 = SwipeToDismissBoxDefaults.INSTANCE.getPositionalThreshold(composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-246335487, i, -1, "androidx.compose.material3.rememberSwipeToDismissBoxState (SwipeToDismissBox.kt:186)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) consume;
        Object[] objArr = new Object[0];
        Saver<SwipeToDismissBoxState, SwipeToDismissBoxValue> Saver = SwipeToDismissBoxState.INSTANCE.Saver(function1, function12, density);
        ComposerKt.sourceInformationMarkerStart(composer, -1333458863, "CC(remember):SwipeToDismissBox.kt#9igjgp");
        boolean changed = (((6 ^ (i & 14)) > 4 && composer.changed(swipeToDismissBoxValue)) || (i & 6) == 4) | composer.changed(density) | ((((i & 112) ^ 48) > 32 && composer.changed(function1)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(function12)) || (i & 384) == 256);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = (Function0) new Function0<SwipeToDismissBoxState>() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$rememberSwipeToDismissBoxState$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final SwipeToDismissBoxState invoke() {
                    return new SwipeToDismissBoxState(SwipeToDismissBoxValue.this, density, function1, function12);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SwipeToDismissBoxState swipeToDismissBoxState = (SwipeToDismissBoxState) RememberSaveableKt.m3923rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) rememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return swipeToDismissBoxState;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0391  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SwipeToDismissBox(final androidx.compose.material3.SwipeToDismissBoxState r27, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.ui.Modifier r29, boolean r30, boolean r31, boolean r32, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 1043
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeToDismissBoxKt.SwipeToDismissBox(androidx.compose.material3.SwipeToDismissBoxState, kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, boolean, boolean, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
