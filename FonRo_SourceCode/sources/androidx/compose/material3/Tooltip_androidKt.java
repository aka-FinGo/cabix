package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Tooltip.android.kt */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ao\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0093\u0001\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aH\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010&H\u0003ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"PlainTooltip", "", "Landroidx/compose/material3/TooltipScope;", "modifier", "Landroidx/compose/ui/Modifier;", "caretSize", "Landroidx/compose/ui/unit/DpSize;", "shape", "Landroidx/compose/ui/graphics/Shape;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "containerColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "PlainTooltip-7QI4Sbk", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "RichTooltip", "title", "action", "colors", "Landroidx/compose/material3/RichTooltipColors;", "text", "RichTooltip-yDvdmqw", "(Landroidx/compose/material3/TooltipScope;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "drawCaretWithPath", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "caretType", "Landroidx/compose/material3/CaretType;", "density", "Landroidx/compose/ui/unit/Density;", "configuration", "Landroid/content/res/Configuration;", "anchorLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "drawCaretWithPath-JKu-mZY", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/material3/CaretType;Landroidx/compose/ui/unit/Density;Landroid/content/res/Configuration;JJLandroidx/compose/ui/layout/LayoutCoordinates;)Landroidx/compose/ui/draw/DrawResult;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class Tooltip_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01f2  */
    /* renamed from: PlainTooltip-7QI4Sbk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2949PlainTooltip7QI4Sbk(final androidx.compose.material3.TooltipScope r28, androidx.compose.ui.Modifier r29, long r30, androidx.compose.ui.graphics.Shape r32, long r33, long r35, float r37, float r38, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instructions count: 760
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.Tooltip_androidKt.m2949PlainTooltip7QI4Sbk(androidx.compose.material3.TooltipScope, androidx.compose.ui.Modifier, long, androidx.compose.ui.graphics.Shape, long, long, float, float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02f7  */
    /* renamed from: RichTooltip-yDvdmqw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2950RichTooltipyDvdmqw(final androidx.compose.material3.TooltipScope r30, androidx.compose.ui.Modifier r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, long r34, androidx.compose.ui.graphics.Shape r36, androidx.compose.material3.RichTooltipColors r37, float r38, float r39, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 900
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.Tooltip_androidKt.m2950RichTooltipyDvdmqw(androidx.compose.material3.TooltipScope, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, long, androidx.compose.ui.graphics.Shape, androidx.compose.material3.RichTooltipColors, float, float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawCaretWithPath-JKu-mZY, reason: not valid java name */
    public static final DrawResult m2952drawCaretWithPathJKumZY(CacheDrawScope cacheDrawScope, CaretType caretType, Density density, Configuration configuration, final long j, long j2, final LayoutCoordinates layoutCoordinates) {
        long j3;
        final Path Path = AndroidPath_androidKt.Path();
        if (layoutCoordinates != null) {
            int mo694roundToPx0680j_4 = density.mo694roundToPx0680j_4(DpSize.m7085getHeightD9Ej5fM(j2));
            int mo694roundToPx0680j_42 = density.mo694roundToPx0680j_4(DpSize.m7087getWidthD9Ej5fM(j2));
            int mo694roundToPx0680j_43 = density.mo694roundToPx0680j_4(Dp.m6989constructorimpl(configuration.screenWidthDp));
            int mo694roundToPx0680j_44 = density.mo694roundToPx0680j_4(TooltipKt.getSpacingBetweenTooltipAndAnchor());
            Rect boundsInWindow = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates);
            float left = boundsInWindow.getLeft();
            float right = boundsInWindow.getRight();
            float top = boundsInWindow.getTop();
            float f = (right + left) / 2.0f;
            float f2 = right - left;
            float m4194getWidthimpl = Size.m4194getWidthimpl(cacheDrawScope.m3986getSizeNHjbRc());
            float m4191getHeightimpl = Size.m4191getHeightimpl(cacheDrawScope.m3986getSizeNHjbRc());
            boolean z = (top - m4191getHeightimpl) - ((float) mo694roundToPx0680j_44) < 0.0f;
            if (z) {
                m4191getHeightimpl = 0.0f;
            }
            if (caretType == CaretType.Plain) {
                float f3 = mo694roundToPx0680j_43;
                if ((m4194getWidthimpl / 2.0f) + f > f3) {
                    j3 = OffsetKt.Offset(m4194getWidthimpl - (f3 - f), m4191getHeightimpl);
                } else {
                    j3 = OffsetKt.Offset(f - Math.max(left - ((Size.m4194getWidthimpl(cacheDrawScope.m3986getSizeNHjbRc()) / 2.0f) - (f2 / 2.0f)), 0.0f), m4191getHeightimpl);
                }
            } else {
                long Offset = OffsetKt.Offset(f - left, m4191getHeightimpl);
                float f4 = mo694roundToPx0680j_43;
                if (left + m4194getWidthimpl > f4) {
                    float f5 = right - m4194getWidthimpl;
                    long Offset2 = OffsetKt.Offset(f - f5, m4191getHeightimpl);
                    if (f5 < 0.0f) {
                        float f6 = m4194getWidthimpl / 2.0f;
                        float f7 = f2 / 2.0f;
                        if ((left - f6) + f7 <= 0.0f) {
                            j3 = OffsetKt.Offset(f, m4191getHeightimpl);
                        } else if ((right + f6) - f7 >= f4) {
                            j3 = OffsetKt.Offset(m4194getWidthimpl - (f4 - f), m4191getHeightimpl);
                        } else {
                            j3 = OffsetKt.Offset(f6, m4191getHeightimpl);
                        }
                    } else {
                        j3 = Offset2;
                    }
                } else {
                    j3 = Offset;
                }
            }
            if (z) {
                Path.moveTo(Offset.m4125getXimpl(j3), Offset.m4126getYimpl(j3));
                float f8 = mo694roundToPx0680j_42 / 2;
                Path.lineTo(Offset.m4125getXimpl(j3) + f8, Offset.m4126getYimpl(j3));
                Path.lineTo(Offset.m4125getXimpl(j3), Offset.m4126getYimpl(j3) - mo694roundToPx0680j_4);
                Path.lineTo(Offset.m4125getXimpl(j3) - f8, Offset.m4126getYimpl(j3));
                Path.close();
            } else {
                Path.moveTo(Offset.m4125getXimpl(j3), Offset.m4126getYimpl(j3));
                float f9 = mo694roundToPx0680j_42 / 2;
                Path.lineTo(Offset.m4125getXimpl(j3) + f9, Offset.m4126getYimpl(j3));
                Path.lineTo(Offset.m4125getXimpl(j3), Offset.m4126getYimpl(j3) + mo694roundToPx0680j_4);
                Path.lineTo(Offset.m4125getXimpl(j3) - f9, Offset.m4126getYimpl(j3));
                Path.close();
            }
        }
        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.Tooltip_androidKt$drawCaretWithPath$4
            /* JADX INFO: Access modifiers changed from: package-private */
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
                if (LayoutCoordinates.this != null) {
                    contentDrawScope.drawContent();
                    DrawScope.m4925drawPathLG529CI$default(contentDrawScope, Path, j, 0.0f, null, null, 0, 60, null);
                }
            }
        });
    }
}
