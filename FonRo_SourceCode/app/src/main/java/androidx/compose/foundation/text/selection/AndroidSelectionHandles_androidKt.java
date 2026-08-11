package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AndroidSelectionHandles.android.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010\t\u001aL\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a+\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u001b\u001a\u00020\rH\u0001¢\u0006\u0002\u0010\u001c\u001a\u0014\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014H\u0000\u001a\"\u0010!\u001a\u00020\u0016*\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u001b\u001a\u00020\rH\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"HandlePopup", "", "positionProvider", "Landroidx/compose/foundation/text/selection/OffsetProvider;", "handleReferencePoint", "Landroidx/compose/ui/Alignment;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/text/selection/OffsetProvider;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionHandle", "offsetProvider", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "handlesCrossed", "minTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "lineHeight", "", "modifier", "Landroidx/compose/ui/Modifier;", "SelectionHandle-wLIcFTc", "(Landroidx/compose/foundation/text/selection/OffsetProvider;ZLandroidx/compose/ui/text/style/ResolvedTextDirection;ZJFLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SelectionHandleIcon", "iconVisible", "isLeft", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "createHandleImage", "Landroidx/compose/ui/graphics/ImageBitmap;", "Landroidx/compose/ui/draw/CacheDrawScope;", "radius", "drawSelectionHandle", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidSelectionHandles_androidKt {
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00e0, code lost:
    
        if ((r28 & 16) != 0) goto L83;
     */
    /* renamed from: SelectionHandle-wLIcFTc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1752SelectionHandlewLIcFTc(final androidx.compose.foundation.text.selection.OffsetProvider r18, final boolean r19, androidx.compose.ui.text.style.ResolvedTextDirection r20, boolean r21, long r22, final float r24, final androidx.compose.ui.Modifier r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt.m1752SelectionHandlewLIcFTc(androidx.compose.foundation.text.selection.OffsetProvider, boolean, androidx.compose.ui.text.style.ResolvedTextDirection, boolean, long, float, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void SelectionHandleIcon(final Modifier modifier, final Function0<Boolean> function0, final boolean z, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(2111672474);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectionHandleIcon)P(2)128@5180L89:AndroidSelectionHandles.android.kt#eksfi3");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if (startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2111672474, i2, -1, "androidx.compose.foundation.text.selection.SelectionHandleIcon (AndroidSelectionHandles.android.kt:127)");
            }
            SpacerKt.Spacer(drawSelectionHandle(SizeKt.m1098sizeVpY3zN4(modifier, SelectionHandlesKt.getHandleWidth(), SelectionHandlesKt.getHandleHeight()), function0, z), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandleIcon$1
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
                    AndroidSelectionHandles_androidKt.SelectionHandleIcon(Modifier.this, function0, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final Modifier drawSelectionHandle(Modifier modifier, final Function0<Boolean> function0, final boolean z) {
        return ComposedModifierKt.composed$default(modifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceGroup(-196777734);
                ComposerKt.sourceInformation(composer, "C133@5438L7,134@5485L678:AndroidSelectionHandles.android.kt#eksfi3");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-196777734, i, -1, "androidx.compose.foundation.text.selection.drawSelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:133)");
                }
                ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = composer.consume(localTextSelectionColors);
                ComposerKt.sourceInformationMarkerEnd(composer);
                final long handleColor = ((TextSelectionColors) consume).getHandleColor();
                ComposerKt.sourceInformationMarkerStart(composer, 1976987148, "CC(remember):AndroidSelectionHandles.android.kt#9igjgp");
                boolean changed = composer.changed(handleColor) | composer.changed(function0) | composer.changed(z);
                final Function0<Boolean> function02 = function0;
                final boolean z2 = z;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final ImageBitmap createHandleImage = AndroidSelectionHandles_androidKt.createHandleImage(cacheDrawScope, Float.intBitsToFloat((int) (cacheDrawScope.m3986getSizeNHjbRc() >> 32)) / 2.0f);
                            final ColorFilter m4425tintxETnrds$default = ColorFilter.Companion.m4425tintxETnrds$default(ColorFilter.INSTANCE, handleColor, 0, 2, null);
                            final Function0<Boolean> function03 = function02;
                            final boolean z3 = z2;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                                    invoke2(contentDrawScope);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ContentDrawScope contentDrawScope) {
                                    contentDrawScope.drawContent();
                                    if (function03.invoke().booleanValue()) {
                                        if (z3) {
                                            ContentDrawScope contentDrawScope2 = contentDrawScope;
                                            ImageBitmap imageBitmap = createHandleImage;
                                            ColorFilter colorFilter = m4425tintxETnrds$default;
                                            long mo4934getCenterF1C5BW0 = contentDrawScope2.mo4934getCenterF1C5BW0();
                                            DrawContext drawContext = contentDrawScope2.getDrawContext();
                                            long mo4856getSizeNHjbRc = drawContext.mo4856getSizeNHjbRc();
                                            drawContext.getCanvas().save();
                                            try {
                                                drawContext.getTransform().mo4863scale0AR0LA0(-1.0f, 1.0f, mo4934getCenterF1C5BW0);
                                                DrawScope.m4919drawImagegbVJVH8$default(contentDrawScope2, imageBitmap, 0L, 0.0f, null, colorFilter, 0, 46, null);
                                                return;
                                            } finally {
                                                drawContext.getCanvas().restore();
                                                drawContext.mo4857setSizeuvyYCjk(mo4856getSizeNHjbRc);
                                            }
                                        }
                                        DrawScope.m4919drawImagegbVJVH8$default(contentDrawScope, createHandleImage, 0L, 0.0f, null, m4425tintxETnrds$default, 0, 46, null);
                                    }
                                }
                            });
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier drawWithCache = DrawModifierKt.drawWithCache(modifier2, (Function1) rememberedValue);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return drawWithCache;
            }
        }, 1, null);
    }

    public static final ImageBitmap createHandleImage(CacheDrawScope cacheDrawScope, float f) {
        int ceil = ((int) Math.ceil(f)) * 2;
        ImageBitmap imageBitmap = HandleImageCache.INSTANCE.getImageBitmap();
        Canvas canvas = HandleImageCache.INSTANCE.getCanvas();
        CanvasDrawScope canvasDrawScope = HandleImageCache.INSTANCE.getCanvasDrawScope();
        if (imageBitmap == null || canvas == null || ceil > imageBitmap.getWidth() || ceil > imageBitmap.getHeight()) {
            imageBitmap = ImageBitmapKt.m4609ImageBitmapx__hDU$default(ceil, ceil, ImageBitmapConfig.INSTANCE.m4603getAlpha8_sVssgQ(), false, null, 24, null);
            HandleImageCache.INSTANCE.setImageBitmap(imageBitmap);
            canvas = CanvasKt.Canvas(imageBitmap);
            HandleImageCache.INSTANCE.setCanvas(canvas);
        }
        ImageBitmap imageBitmap2 = imageBitmap;
        Canvas canvas2 = canvas;
        if (canvasDrawScope == null) {
            canvasDrawScope = new CanvasDrawScope();
            HandleImageCache.INSTANCE.setCanvasDrawScope(canvasDrawScope);
        }
        CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
        LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
        float width = imageBitmap2.getWidth();
        float height = imageBitmap2.getHeight();
        long m4185constructorimpl = Size.m4185constructorimpl((Float.floatToRawIntBits(height) & 4294967295L) | (Float.floatToRawIntBits(width) << 32));
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope2.getDrawParams();
        Density density = drawParams.getDensity();
        LayoutDirection layoutDirection2 = drawParams.getLayoutDirection();
        Canvas canvas3 = drawParams.getCanvas();
        long size = drawParams.getSize();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope2.getDrawParams();
        drawParams2.setDensity(cacheDrawScope);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas2);
        drawParams2.m4855setSizeuvyYCjk(m4185constructorimpl);
        canvas2.save();
        CanvasDrawScope canvasDrawScope3 = canvasDrawScope2;
        DrawScope.m4929drawRectnJ9OG0$default(canvasDrawScope3, Color.INSTANCE.m4410getBlack0d7_KjU(), 0L, canvasDrawScope3.mo4935getSizeNHjbRc(), 0.0f, null, null, BlendMode.INSTANCE.m4299getClear0nO6VwU(), 58, null);
        DrawScope.m4929drawRectnJ9OG0$default(canvasDrawScope3, ColorKt.Color(4278190080L), Offset.INSTANCE.m4141getZeroF1C5BW0(), Size.m4185constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f) & 4294967295L)), 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
        DrawScope.m4916drawCircleVaOC9Bg$default(canvasDrawScope3, ColorKt.Color(4278190080L), f, Offset.m4117constructorimpl((Float.floatToRawIntBits(f) & 4294967295L) | (Float.floatToRawIntBits(f) << 32)), 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
        canvas2.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope2.getDrawParams();
        drawParams3.setDensity(density);
        drawParams3.setLayoutDirection(layoutDirection2);
        drawParams3.setCanvas(canvas3);
        drawParams3.m4855setSizeuvyYCjk(size);
        return imageBitmap2;
    }

    public static final void HandlePopup(final OffsetProvider offsetProvider, final Alignment alignment, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(476043083);
        ComposerKt.sourceInformation(startRestartGroup, "C(HandlePopup)P(2,1)225@8875L135,228@9015L190:AndroidSelectionHandles.android.kt#eksfi3");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(offsetProvider) : startRestartGroup.changedInstance(offsetProvider) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(alignment) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        boolean z = false;
        if (startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(476043083, i2, -1, "androidx.compose.foundation.text.selection.HandlePopup (AndroidSelectionHandles.android.kt:223)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1288572034, "CC(remember):AndroidSelectionHandles.android.kt#9igjgp");
            boolean z2 = (i2 & 112) == 32;
            if ((i2 & 14) == 4 || ((i2 & 8) != 0 && startRestartGroup.changed(offsetProvider))) {
                z = true;
            }
            boolean z3 = z2 | z;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new HandlePositionProvider(alignment, offsetProvider);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            AndroidPopup_androidKt.Popup((HandlePositionProvider) rememberedValue, null, new PopupProperties(false, false, false, (SecureFlagPolicy) null, true, false, 15, (DefaultConstructorMarker) null), function2, startRestartGroup, ((i2 << 3) & 7168) | 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$HandlePopup$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    AndroidSelectionHandles_androidKt.HandlePopup(OffsetProvider.this, alignment, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
