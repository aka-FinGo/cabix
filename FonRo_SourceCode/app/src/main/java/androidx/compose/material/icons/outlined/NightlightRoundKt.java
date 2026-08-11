package androidx.compose.material.icons.outlined;

import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: NightlightRound.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_nightlightRound", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NightlightRound", "Landroidx/compose/material/icons/Icons$Outlined;", "getNightlightRound", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NightlightRoundKt {
    private static ImageVector _nightlightRound;

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getNightlightRound(androidx.compose.material.icons.Icons.Outlined r19) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.outlined.NightlightRoundKt._nightlightRound
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
            java.lang.String r2 = "Outlined.NightlightRound"
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
            r0 = 1098383360(0x41780000, float:15.5)
            r2 = 1102053376(0x41b00000, float:22.0)
            r12.moveTo(r0, r2)
            r17 = 1077936128(0x40400000, float:3.0)
            r18 = -1091861217(0xffffffffbeeb851f, float:-0.46)
            r13 = 1065772646(0x3f866666, float:1.05)
            r14 = 0
            r15 = 1073951539(0x40033333, float:2.05)
            r16 = -1104947446(0xffffffffbe23d70a, float:-0.16)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r17 = -1059061760(0xffffffffc0e00000, float:-7.0)
            r18 = -1055349801(0xffffffffc118a3d7, float:-9.54)
            r13 = -1065227387(0xffffffffc081eb85, float:-4.06)
            r14 = -1079865508(0xffffffffbfa28f5c, float:-1.27)
            r15 = -1059061760(0xffffffffc0e00000, float:-7.0)
            r16 = -1063130235(0xffffffffc0a1eb85, float:-5.06)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r4 = 1088421888(0x40e00000, float:7.0)
            r6 = -1055349801(0xffffffffc118a3d7, float:-9.54)
            r7 = 1077684470(0x403c28f6, float:2.94)
            r8 = -1056681492(0xffffffffc10451ec, float:-8.27)
            r12.reflectiveCurveToRelative(r7, r8, r4, r6)
            r17 = 1098383360(0x41780000, float:15.5)
            r18 = 1073741824(0x40000000, float:2.0)
            r13 = 1099720294(0x418c6666, float:17.55)
            r14 = 1074412913(0x400a3d71, float:2.16)
            r15 = 1099196006(0x41846666, float:16.55)
            r16 = 1073741824(0x40000000, float:2.0)
            r12.curveTo(r13, r14, r15, r16, r17, r18)
            r17 = -1054867456(0xffffffffc1200000, float:-10.0)
            r18 = 1092616192(0x41200000, float:10.0)
            r13 = -1062165545(0xffffffffc0b0a3d7, float:-5.52)
            r14 = 0
            r15 = -1054867456(0xffffffffc1200000, float:-10.0)
            r16 = 1083137065(0x408f5c29, float:4.48)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r4 = 1092595220(0x411fae14, float:9.98)
            r12.reflectiveCurveTo(r4, r2, r0, r2)
            r12.lineTo(r0, r2)
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
            r15 = 0
            androidx.compose.ui.graphics.vector.ImageVector$Builder r0 = androidx.compose.ui.graphics.vector.ImageVector.Builder.m5069addPathoIyEayM$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            androidx.compose.ui.graphics.vector.ImageVector r0 = r0.build()
            androidx.compose.material.icons.outlined.NightlightRoundKt._nightlightRound = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.outlined.NightlightRoundKt.getNightlightRound(androidx.compose.material.icons.Icons$Outlined):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
