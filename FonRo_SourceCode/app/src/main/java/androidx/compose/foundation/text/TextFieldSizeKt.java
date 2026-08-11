package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;

/* compiled from: TextFieldSize.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004²\u0006\n\u0010\u0005\u001a\u00020\u0006X\u008a\u0084\u0002"}, d2 = {"textFieldMinSize", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "foundation_release", "typeface", ""}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldSizeKt {
    public static final Modifier textFieldMinSize(Modifier modifier, final TextStyle textStyle) {
        return ComposedModifierKt.composed$default(modifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceGroup(1582736677);
                ComposerKt.sourceInformation(composer, "C37@1534L7,38@1595L7,39@1650L7,41@1683L76,43@1788L340,52@2153L101,58@2372L487:TextFieldSize.kt#423gt5");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1582736677, i, -1, "androidx.compose.foundation.text.textFieldMinSize.<anonymous> (TextFieldSize.kt:37)");
                }
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = composer.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Density density = (Density) consume;
                ProvidableCompositionLocal<FontFamily.Resolver> localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume2 = composer.consume(localFontFamilyResolver);
                ComposerKt.sourceInformationMarkerEnd(composer);
                FontFamily.Resolver resolver = (FontFamily.Resolver) consume2;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume3 = composer.consume(localLayoutDirection);
                ComposerKt.sourceInformationMarkerEnd(composer);
                LayoutDirection layoutDirection = (LayoutDirection) consume3;
                ComposerKt.sourceInformationMarkerStart(composer, 979653560, "CC(remember):TextFieldSize.kt#9igjgp");
                boolean changed = composer.changed(TextStyle.this) | composer.changed(layoutDirection);
                TextStyle textStyle2 = TextStyle.this;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = TextStyleKt.resolveDefaults(textStyle2, layoutDirection);
                    composer.updateRememberedValue(rememberedValue);
                }
                TextStyle textStyle3 = (TextStyle) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 979657184, "CC(remember):TextFieldSize.kt#9igjgp");
                boolean changed2 = composer.changed(resolver) | composer.changed(textStyle3);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    FontFamily fontFamily = textStyle3.getFontFamily();
                    FontWeight fontWeight = textStyle3.getFontWeight();
                    if (fontWeight == null) {
                        fontWeight = FontWeight.INSTANCE.getNormal();
                    }
                    FontStyle m6467getFontStyle4Lr2A7w = textStyle3.m6467getFontStyle4Lr2A7w();
                    int m6569unboximpl = m6467getFontStyle4Lr2A7w != null ? m6467getFontStyle4Lr2A7w.m6569unboximpl() : FontStyle.INSTANCE.m6573getNormal_LCdwA();
                    FontSynthesis m6468getFontSynthesisZQGJjVo = textStyle3.m6468getFontSynthesisZQGJjVo();
                    rememberedValue2 = resolver.mo6539resolveDPcqOEQ(fontFamily, fontWeight, m6569unboximpl, m6468getFontSynthesisZQGJjVo != null ? m6468getFontSynthesisZQGJjVo.getValue() : FontSynthesis.INSTANCE.m6583getAllGVVA2EU());
                    composer.updateRememberedValue(rememberedValue2);
                }
                State state = (State) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 979668625, "CC(remember):TextFieldSize.kt#9igjgp");
                TextStyle textStyle4 = TextStyle.this;
                Object rememberedValue3 = composer.rememberedValue();
                if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    Object textFieldSize = new TextFieldSize(layoutDirection, density, resolver, textStyle4, state.getValue());
                    composer.updateRememberedValue(textFieldSize);
                    rememberedValue3 = textFieldSize;
                }
                final TextFieldSize textFieldSize2 = (TextFieldSize) rememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer);
                textFieldSize2.update(layoutDirection, density, resolver, textStyle3, state.getValue());
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, 979676019, "CC(remember):TextFieldSize.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(textFieldSize2);
                Object rememberedValue4 = composer.rememberedValue();
                if (changedInstance || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                            return m1484invoke3p2s80s(measureScope, measurable, constraints.getValue());
                        }

                        /* renamed from: invoke-3p2s80s, reason: not valid java name */
                        public final MeasureResult m1484invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                            long minSize = TextFieldSize.this.getMinSize();
                            final Placeable mo5732measureBRTryo0 = measurable.mo5732measureBRTryo0(Constraints.m6932copyZbe2FdA$default(j, RangesKt.coerceIn((int) (minSize >> 32), Constraints.m6944getMinWidthimpl(j), Constraints.m6942getMaxWidthimpl(j)), 0, RangesKt.coerceIn((int) (minSize & 4294967295L), Constraints.m6943getMinHeightimpl(j), Constraints.m6941getMaxHeightimpl(j)), 0, 10, null));
                            return MeasureScope.layout$default(measureScope, mo5732measureBRTryo0.getWidth(), mo5732measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1$1$1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                    invoke2(placementScope);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                                }
                            }, 4, null);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier layout = LayoutModifierKt.layout(companion, (Function3) rememberedValue4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return layout;
            }
        }, 1, null);
    }
}
