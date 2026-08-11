package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Label.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\b\u001a^\u0010\t\u001a\u00020\u00012\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00032\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"HandleInteractions", "", "enabled", "", "state", "Landroidx/compose/material3/TooltipState;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLandroidx/compose/material3/TooltipState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", TextFieldImplKt.LabelId, "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TooltipScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "isPersistent", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class LabelKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x004f  */
    /* JADX WARN: Type inference failed for: r8v11, types: [T, androidx.compose.runtime.MutableState] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Label(final kotlin.jvm.functions.Function3<? super androidx.compose.material3.TooltipScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, androidx.compose.ui.Modifier r21, androidx.compose.foundation.interaction.MutableInteractionSource r22, boolean r23, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 525
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.LabelKt.Label(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.foundation.interaction.MutableInteractionSource, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HandleInteractions(final boolean z, final TooltipState tooltipState, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-627258109);
        ComposerKt.sourceInformation(startRestartGroup, "C(HandleInteractions)P(!1,2)110@4384L587,110@4350L621:Label.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(tooltipState) : startRestartGroup.changedInstance(tooltipState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(mutableInteractionSource) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-627258109, i2, -1, "androidx.compose.material3.HandleInteractions (Label.kt:108)");
            }
            if (z) {
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 354570583, "CC(remember):Label.kt#9igjgp");
                boolean z2 = true;
                boolean z3 = (i2 & 896) == 256;
                if ((i2 & 112) != 32 && ((i2 & 64) == 0 || !startRestartGroup.changedInstance(tooltipState))) {
                    z2 = false;
                }
                boolean z4 = z3 | z2;
                LabelKt$HandleInteractions$1$1 rememberedValue = startRestartGroup.rememberedValue();
                if (z4 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new LabelKt$HandleInteractions$1$1(mutableInteractionSource, tooltipState, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, (i2 >> 6) & 14);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.LabelKt$HandleInteractions$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    LabelKt.HandleInteractions(z, tooltipState, mutableInteractionSource, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
