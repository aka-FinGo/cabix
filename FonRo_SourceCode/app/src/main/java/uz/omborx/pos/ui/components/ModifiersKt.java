package uz.FonRo.pos.ui.components;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.RippleKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Modifiers.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u001a-\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007b\u0002\b\r¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"oxClickable", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "debounceMs", "", "onClick", "Lkotlin/Function0;", "", "oxTap", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/Composable;", "app"}, k = 2, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ModifiersKt {
    public static /* synthetic */ Modifier oxClickable$default(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, long j, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            mutableInteractionSource = null;
        }
        if ((i & 4) != 0) {
            j = 400;
        }
        return oxClickable(modifier, z, mutableInteractionSource, j, function0);
    }

    public static final Modifier oxClickable(Modifier modifier, final boolean z, final MutableInteractionSource mutableInteractionSource, final long j, final Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ComposedModifierKt.composed$default(modifier, null, new Function3() { // from class: uz.FonRo.pos.ui.components.ModifiersKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ModifiersKt.oxClickable$lambda$0(MutableInteractionSource.this, z, j, onClick, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, null);
    }

    public static final Modifier oxClickable$lambda$0(MutableInteractionSource mutableInteractionSource, boolean z, final long j, final Function0 function0, Modifier composed, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        composer.startReplaceGroup(-230827466);
        ComposerKt.sourceInformation(composer, "C23@860L28,28@1030L153:Modifiers.kt#r5y9fm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-230827466, i, -1, "uz.FonRo.pos.ui.components.oxClickable.<anonymous> (Modifiers.kt:22)");
        }
        if (mutableInteractionSource == null) {
            composer.startReplaceGroup(-338357819);
            ComposerKt.sourceInformation(composer, "22@805L39");
            ComposerKt.sourceInformationMarkerStart(composer, 1513105885, "CC(remember):Modifiers.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(rememberedValue);
            }
            mutableInteractionSource = (MutableInteractionSource) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        } else {
            composer.startReplaceGroup(1513105234);
        }
        composer.endReplaceGroup();
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        ComposerKt.sourceInformationMarkerStart(composer, 1513107634, "CC(remember):Modifiers.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        Object obj = rememberedValue2;
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            long[] jArr = {0};
            composer.updateRememberedValue(jArr);
            obj = jArr;
        }
        final long[] jArr2 = (long[]) obj;
        ComposerKt.sourceInformationMarkerEnd(composer);
        IndicationNodeFactory m2509rippleH2RKhps$default = RippleKt.m2509rippleH2RKhps$default(false, 0.0f, 0L, 7, null);
        ComposerKt.sourceInformationMarkerStart(composer, 1513113199, "CC(remember):Modifiers.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(jArr2) | composer.changed(j) | composer.changed(function0);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = new Function0() { // from class: uz.FonRo.pos.ui.components.ModifiersKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit oxClickable$lambda$0$2$0;
                    oxClickable$lambda$0$2$0 = ModifiersKt.oxClickable$lambda$0$2$0(jArr2, j, function0);
                    return oxClickable$lambda$0$2$0;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier m590clickableO2vRcR0$default = ClickableKt.m590clickableO2vRcR0$default(composed, mutableInteractionSource2, m2509rippleH2RKhps$default, z, null, null, (Function0) rememberedValue3, 24, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return m590clickableO2vRcR0$default;
    }

    public static final Unit oxClickable$lambda$0$2$0(long[] jArr, long j, Function0 function0) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - jArr[0] >= j) {
            jArr[0] = currentTimeMillis;
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    public static final Modifier oxTap(Modifier modifier, boolean z, Function0<Unit> onClick, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        ComposerKt.sourceInformationMarkerStart(composer, 861656146, "C(oxTap)41@1415L39:Modifiers.kt#r5y9fm");
        boolean z2 = (i2 & 1) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(861656146, i, -1, "uz.FonRo.pos.ui.components.oxTap (Modifiers.kt:39)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -877127303, "CC(remember):Modifiers.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier m590clickableO2vRcR0$default = ClickableKt.m590clickableO2vRcR0$default(modifier, (MutableInteractionSource) rememberedValue, RippleKt.m2509rippleH2RKhps$default(false, 0.0f, 0L, 7, null), z2, null, null, onClick, 24, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m590clickableO2vRcR0$default;
    }
}
