package androidx.compose.material.icons.rounded;

import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Pentagon.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_pentagon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Pentagon", "Landroidx/compose/material/icons/Icons$Rounded;", "getPentagon", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PentagonKt {
    private static ImageVector _pentagon;

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getPentagon(androidx.compose.material.icons.Icons.Rounded r19) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.rounded.PentagonKt._pentagon
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
            java.lang.String r2 = "Rounded.Pentagon"
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
            r0 = 1075713147(0x401e147b, float:2.47)
            r2 = 1093056594(0x4126b852, float:10.42)
            r12.moveTo(r0, r2)
            r0 = 1091798303(0x4113851f, float:9.22)
            r2 = 1078229729(0x40447ae1, float:3.07)
            r12.lineToRelative(r2, r0)
            r17 = 1089344635(0x40ee147b, float:7.44)
            r18 = 1101529088(0x41a80000, float:21.0)
            r13 = 1085947249(0x40ba3d71, float:5.82)
            r14 = 1101240730(0x41a3999a, float:20.45)
            r15 = 1087541084(0x40d28f5c, float:6.58)
            r16 = 1101529088(0x41a80000, float:21.0)
            r12.curveTo(r13, r14, r15, r16, r17, r18)
            r0 = 1091693445(0x4111eb85, float:9.12)
            r12.horizontalLineToRelative(r0)
            r17 = 1072902963(0x3ff33333, float:1.9)
            r18 = -1079026647(0xffffffffbfaf5c29, float:-1.37)
            r13 = 1063004406(0x3f5c28f6, float:0.86)
            r14 = 0
            r15 = 1070638039(0x3fd0a3d7, float:1.63)
            r16 = -1089680179(0xffffffffbf0ccccd, float:-0.55)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = -1055685345(0xffffffffc113851f, float:-9.22)
            r12.lineToRelative(r2, r0)
            r17 = -1086324736(0xffffffffbf400000, float:-0.75)
            r18 = -1072609362(0xffffffffc01147ae, float:-2.27)
            r13 = 1049582633(0x3e8f5c29, float:0.28)
            r14 = -1084814787(0xffffffffbf570a3d, float:-0.84)
            r15 = -1124744561(0xffffffffbcf5c28f, float:-0.03)
            r16 = -1075755090(0xffffffffbfe147ae, float:-1.76)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = 1095919206(0x41526666, float:13.15)
            r2 = 1077097267(0x40333333, float:2.8)
            r12.lineTo(r0, r2)
            r17 = -1072525476(0xffffffffc0128f5c, float:-2.29)
            r18 = 0
            r13 = -1087331369(0xffffffffbf30a3d7, float:-0.69)
            r14 = -1091190129(0xffffffffbef5c28f, float:-0.48)
            r15 = -1077013381(0xffffffffbfce147b, float:-1.61)
            r16 = -1091190129(0xffffffffbef5c28f, float:-0.48)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = 1078858875(0x404e147b, float:3.22)
            r2 = 1090665841(0x41023d71, float:8.14)
            r12.lineTo(r0, r2)
            r17 = 1075713147(0x401e147b, float:2.47)
            r18 = 1093056594(0x4126b852, float:10.42)
            r13 = 1075838976(0x40200000, float:2.5)
            r14 = 1091200614(0x410a6666, float:8.65)
            r15 = 1074538742(0x400c28f6, float:2.19)
            r16 = 1092175790(0x411947ae, float:9.58)
            r12.curveTo(r13, r14, r15, r16, r17, r18)
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
            androidx.compose.material.icons.rounded.PentagonKt._pentagon = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.rounded.PentagonKt.getPentagon(androidx.compose.material.icons.Icons$Rounded):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
