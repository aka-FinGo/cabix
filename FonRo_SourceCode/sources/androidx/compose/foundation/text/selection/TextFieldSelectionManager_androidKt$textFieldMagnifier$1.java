package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.PlatformMagnifierFactory;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextFieldSelectionManager.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldSelectionManager_androidKt$textFieldMagnifier$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ TextFieldSelectionManager $manager;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionManager_androidKt$textFieldMagnifier$1(TextFieldSelectionManager textFieldSelectionManager) {
        super(3);
        this.$manager = textFieldSelectionManager;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(1980580247);
        ComposerKt.sourceInformation(composer, "C50@2137L7,51@2174L41,53@2282L68,54@2384L539:TextFieldSelectionManager.android.kt#eksfi3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1980580247, i, -1, "androidx.compose.foundation.text.selection.textFieldMagnifier.<anonymous> (TextFieldSelectionManager.android.kt:50)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(composer, 1684880674, "CC(remember):TextFieldSelectionManager.android.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m7152boximpl(IntSize.INSTANCE.m7165getZeroYbymL2g()), null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1684884157, "CC(remember):TextFieldSelectionManager.android.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(this.$manager);
        final TextFieldSelectionManager textFieldSelectionManager = this.$manager;
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = (Function0) new Function0<Offset>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$textFieldMagnifier$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Offset invoke() {
                    return Offset.m4114boximpl(m1833invokeF1C5BW0());
                }

                /* renamed from: invoke-F1C5BW0, reason: not valid java name */
                public final long m1833invokeF1C5BW0() {
                    long invoke$lambda$1;
                    TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                    invoke$lambda$1 = TextFieldSelectionManager_androidKt$textFieldMagnifier$1.invoke$lambda$1(mutableState);
                    return TextFieldSelectionManagerKt.m1832calculateSelectionMagnifierCenterAndroidO0kMr_c(textFieldSelectionManager2, invoke$lambda$1);
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        Function0 function0 = (Function0) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1684887892, "CC(remember):TextFieldSelectionManager.android.kt#9igjgp");
        boolean changed = composer.changed(density);
        Object rememberedValue3 = composer.rememberedValue();
        if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = (Function1) new Function1<Function0<? extends Offset>, Modifier>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$textFieldMagnifier$1$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Modifier invoke(Function0<? extends Offset> function02) {
                    return invoke2((Function0<Offset>) function02);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Modifier invoke2(final Function0<Offset> function02) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Function1<Density, Offset> function1 = new Function1<Density, Offset>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$textFieldMagnifier$1$2$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Offset invoke(Density density2) {
                            return Offset.m4114boximpl(m1834invoketuRUvjQ(density2));
                        }

                        /* renamed from: invoke-tuRUvjQ, reason: not valid java name */
                        public final long m1834invoketuRUvjQ(Density density2) {
                            return function02.invoke().m4135unboximpl();
                        }
                    };
                    final Density density2 = Density.this;
                    final MutableState<IntSize> mutableState2 = mutableState;
                    return Magnifier_androidKt.m629magnifierjPUL71Q$default(companion, function1, null, new Function1<DpSize, Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$textFieldMagnifier$1$2$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DpSize dpSize) {
                            m1835invokeEaSLcWc(dpSize.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke-EaSLcWc, reason: not valid java name */
                        public final void m1835invokeEaSLcWc(long j) {
                            MutableState<IntSize> mutableState3 = mutableState2;
                            Density density3 = Density.this;
                            TextFieldSelectionManager_androidKt$textFieldMagnifier$1.invoke$lambda$2(mutableState3, IntSize.m7155constructorimpl((density3.mo694roundToPx0680j_4(DpSize.m7087getWidthD9Ej5fM(j)) << 32) | (density3.mo694roundToPx0680j_4(DpSize.m7085getHeightD9Ej5fM(j)) & 4294967295L)));
                        }
                    }, 0.0f, true, 0L, 0.0f, 0.0f, false, PlatformMagnifierFactory.INSTANCE.getForCurrentPlatform(), 490, null);
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier animatedSelectionMagnifier = SelectionMagnifierKt.animatedSelectionMagnifier(modifier, function0, (Function1) rememberedValue3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return animatedSelectionMagnifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long invoke$lambda$1(MutableState<IntSize> mutableState) {
        return mutableState.getValue().m7164unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2(MutableState<IntSize> mutableState, long j) {
        mutableState.setValue(IntSize.m7152boximpl(j));
    }
}
