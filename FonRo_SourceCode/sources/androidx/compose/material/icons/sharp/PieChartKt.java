package androidx.compose.material.icons.sharp;

import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: PieChart.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_pieChart", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PieChart", "Landroidx/compose/material/icons/Icons$Sharp;", "getPieChart", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PieChartKt {
    private static ImageVector _pieChart;

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getPieChart(androidx.compose.material.icons.Icons.Sharp r19) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.sharp.PieChartKt._pieChart
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
            java.lang.String r2 = "Sharp.PieChart"
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
            r0 = 1093664768(0x41300000, float:11.0)
            r2 = 1073741824(0x40000000, float:2.0)
            r12.moveTo(r0, r2)
            r0 = 1101004800(0x41a00000, float:20.0)
            r12.verticalLineToRelative(r0)
            r17 = -1055916032(0xffffffffc1100000, float:-9.0)
            r18 = -1054867456(0xffffffffc1200000, float:-10.0)
            r13 = -1063109263(0xffffffffc0a23d71, float:-5.07)
            r14 = -1090519040(0xffffffffbf000000, float:-0.5)
            r15 = -1055916032(0xffffffffc1100000, float:-9.0)
            r16 = -1063696466(0xffffffffc09947ae, float:-4.79)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = 1091567616(0x41100000, float:9.0)
            r4 = -1054867456(0xffffffffc1200000, float:-10.0)
            r6 = 1081836831(0x407b851f, float:3.93)
            r7 = -1055391744(0xffffffffc1180000, float:-9.5)
            r12.reflectiveCurveToRelative(r6, r7, r0, r4)
            r12.close()
            r0 = 1095793377(0x41507ae1, float:13.03)
            r12.moveTo(r0, r2)
            r2 = 1091557130(0x410fd70a, float:8.99)
            r12.verticalLineToRelative(r2)
            r2 = 1093654282(0x412fd70a, float:10.99)
            r4 = 1102053376(0x41b00000, float:22.0)
            r12.lineTo(r4, r2)
            r17 = -1055947489(0xffffffffc10f851f, float:-8.97)
            r18 = -1055926518(0xffffffffc10fd70a, float:-8.99)
            r13 = -1091525673(0xffffffffbef0a3d7, float:-0.47)
            r14 = -1063801324(0xffffffffc097ae14, float:-4.74)
            r15 = -1064849900(0xffffffffc087ae14, float:-4.24)
            r16 = -1056419348(0xffffffffc10851ec, float:-8.52)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r12.close()
            r2 = 1095772406(0x415028f6, float:13.01)
            r12.moveTo(r0, r2)
            r12.lineTo(r0, r4)
            r17 = 1091536159(0x410f851f, float:8.97)
            r13 = 1083682324(0x4097ae14, float:4.74)
            r14 = -1091525673(0xffffffffbef0a3d7, float:-0.47)
            r15 = 1091043328(0x41080000, float:8.5)
            r16 = -1064828928(0xffffffffc0880000, float:-4.25)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = -1055947489(0xffffffffc10f851f, float:-8.97)
            r12.horizontalLineToRelative(r0)
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
            androidx.compose.material.icons.sharp.PieChartKt._pieChart = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.sharp.PieChartKt.getPieChart(androidx.compose.material.icons.Icons$Sharp):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
