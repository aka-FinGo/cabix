package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* compiled from: ArrowForwardIos.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"_arrowForwardIos", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ArrowForwardIos", "Landroidx/compose/material/icons/Icons$Rounded;", "getArrowForwardIos$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getArrowForwardIos", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ArrowForwardIosKt {
    private static ImageVector _arrowForwardIos;

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Rounded.ArrowForwardIos", replaceWith = @ReplaceWith(expression = "Icons.AutoMirrored.Rounded.ArrowForwardIos", imports = {"androidx.compose.material.icons.automirrored.rounded.ArrowForwardIos"}))
    public static /* synthetic */ void getArrowForwardIos$annotations(Icons.Rounded rounded) {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getArrowForwardIos(androidx.compose.material.icons.Icons.Rounded r19) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.rounded.ArrowForwardIosKt._arrowForwardIos
            if (r0 == 0) goto L8
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        L8:
            androidx.compose.ui.graphics.vector.ImageVector$Builder r1 = new androidx.compose.ui.graphics.vector.ImageVector$Builder
            r0 = 1103101952(0x41c00000, float:24.0)
            float r3 = androidx.compose.ui.unit.Dp.m6989constructorimpl(r0)
            float r4 = androidx.compose.ui.unit.Dp.m6989constructorimpl(r0)
            r11 = 96
            r12 = 0
            java.lang.String r2 = "Rounded.ArrowForwardIos"
            r5 = 1103101952(0x41c00000, float:24.0)
            r6 = 1103101952(0x41c00000, float:24.0)
            r7 = 0
            r9 = 0
            r10 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7, r9, r10, r11, r12)
            int r3 = androidx.compose.ui.graphics.vector.VectorKt.getDefaultFillType()
            androidx.compose.ui.graphics.SolidColor r0 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.INSTANCE
            long r4 = r2.m4410getBlack0d7_KjU()
            r2 = 0
            r0.<init>(r4, r2)
            r5 = r0
            androidx.compose.ui.graphics.Brush r5 = (androidx.compose.ui.graphics.Brush) r5
            androidx.compose.ui.graphics.StrokeCap$Companion r0 = androidx.compose.ui.graphics.StrokeCap.INSTANCE
            int r10 = r0.m4737getButtKaPHkGw()
            androidx.compose.ui.graphics.StrokeJoin$Companion r0 = androidx.compose.ui.graphics.StrokeJoin.INSTANCE
            int r11 = r0.m4747getBevelLxFBmk8()
            androidx.compose.ui.graphics.vector.PathBuilder r12 = new androidx.compose.ui.graphics.vector.PathBuilder
            r12.<init>()
            r0 = 1089218806(0x40ec28f6, float:7.38)
            r2 = 1101534331(0x41a8147b, float:21.01)
            r12.moveTo(r0, r2)
            r17 = 1071812444(0x3fe28f5c, float:1.77)
            r18 = 0
            r13 = 1056629064(0x3efae148, float:0.49)
            r14 = 1056629064(0x3efae148, float:0.49)
            r15 = 1067702026(0x3fa3d70a, float:1.28)
            r16 = 1056629064(0x3efae148, float:0.49)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = 1090844099(0x4104f5c3, float:8.31)
            r2 = -1056639549(0xffffffffc104f5c3, float:-8.31)
            r12.lineToRelative(r0, r2)
            r17 = 0
            r18 = -1078691103(0xffffffffbfb47ae1, float:-1.41)
            r13 = 1053273620(0x3ec7ae14, float:0.39)
            r14 = -1094210028(0xffffffffbec7ae14, float:-0.39)
            r15 = 1053273620(0x3ec7ae14, float:0.39)
            r16 = -1081962660(0xffffffffbf828f5c, float:-1.02)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = 1091724902(0x41126666, float:9.15)
            r2 = 1077852242(0x403eb852, float:2.98)
            r12.lineTo(r0, r2)
            r17 = -1075671204(0xffffffffbfe28f5c, float:-1.77)
            r18 = 0
            r13 = -1090854584(0xffffffffbefae148, float:-0.49)
            r14 = -1090854584(0xffffffffbefae148, float:-0.49)
            r15 = -1079781622(0xffffffffbfa3d70a, float:-1.28)
            r16 = -1090854584(0xffffffffbefae148, float:-0.49)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = 0
            r2 = 1071812444(0x3fe28f5c, float:1.77)
            r4 = -1090854584(0xffffffffbefae148, float:-0.49)
            r6 = 1067702026(0x3fa3d70a, float:1.28)
            r12.reflectiveCurveToRelative(r4, r6, r0, r2)
            r0 = 1097460613(0x4169eb85, float:14.62)
            r2 = 1094713344(0x41400000, float:12.0)
            r12.lineTo(r0, r2)
            r0 = -1058537472(0xffffffffc0e80000, float:-7.25)
            r2 = 1088946176(0x40e80000, float:7.25)
            r12.lineToRelative(r0, r2)
            r17 = 1008981770(0x3c23d70a, float:0.01)
            r18 = 1071728558(0x3fe147ae, float:1.76)
            r13 = -1091190129(0xffffffffbef5c28f, float:-0.48)
            r14 = 1056293519(0x3ef5c28f, float:0.48)
            r15 = -1091190129(0xffffffffbef5c28f, float:-0.48)
            r16 = 1067702026(0x3fa3d70a, float:1.28)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r12.close()
            java.util.List r2 = r12.getNodes()
            r16 = 14336(0x3800, float:2.0089E-41)
            r17 = 0
            java.lang.String r4 = ""
            r6 = 1065353216(0x3f800000, float:1.0)
            r7 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            r9 = 1065353216(0x3f800000, float:1.0)
            r12 = 1065353216(0x3f800000, float:1.0)
            r13 = 0
            r14 = 0
            r15 = 0
            androidx.compose.ui.graphics.vector.ImageVector$Builder r0 = androidx.compose.ui.graphics.vector.ImageVector.Builder.m5069addPathoIyEayM$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            androidx.compose.ui.graphics.vector.ImageVector r0 = r0.build()
            androidx.compose.material.icons.rounded.ArrowForwardIosKt._arrowForwardIos = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.rounded.ArrowForwardIosKt.getArrowForwardIos(androidx.compose.material.icons.Icons$Rounded):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
