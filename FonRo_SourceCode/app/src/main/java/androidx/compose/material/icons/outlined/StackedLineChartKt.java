package androidx.compose.material.icons.outlined;

import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: StackedLineChart.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_stackedLineChart", "Landroidx/compose/ui/graphics/vector/ImageVector;", "StackedLineChart", "Landroidx/compose/material/icons/Icons$Outlined;", "getStackedLineChart", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class StackedLineChartKt {
    private static ImageVector _stackedLineChart;

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getStackedLineChart(androidx.compose.material.icons.Icons.Outlined r18) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.outlined.StackedLineChartKt._stackedLineChart
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
            java.lang.String r2 = "Outlined.StackedLineChart"
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
            androidx.compose.ui.graphics.vector.PathBuilder r0 = new androidx.compose.ui.graphics.vector.PathBuilder
            r0.<init>()
            r2 = 1073741824(0x40000000, float:2.0)
            r4 = 1100999557(0x419feb85, float:19.99)
            r0.moveTo(r2, r4)
            r6 = 1089470464(0x40f00000, float:7.5)
            r7 = -1057992212(0xffffffffc0f051ec, float:-7.51)
            r0.lineToRelative(r6, r7)
            r6 = 1082130432(0x40800000, float:4.0)
            r0.lineToRelative(r6, r6)
            r7 = 1088610632(0x40e2e148, float:7.09)
            r8 = -1057027523(0xffffffffc0ff0a3d, float:-7.97)
            r0.lineToRelative(r7, r8)
            r7 = 1092532306(0x411eb852, float:9.92)
            r8 = 1102053376(0x41b00000, float:22.0)
            r0.lineTo(r8, r7)
            r7 = -1056440320(0xffffffffc1080000, float:-8.5)
            r9 = 1092154819(0x4118f5c3, float:9.56)
            r0.lineToRelative(r7, r9)
            r7 = -1065353216(0xffffffffc0800000, float:-4.0)
            r0.lineToRelative(r7, r7)
            r9 = -1061158912(0xffffffffc0c00000, float:-6.0)
            r12 = 1086345708(0x40c051ec, float:6.01)
            r0.lineToRelative(r9, r12)
            r0.lineTo(r2, r4)
            r0.close()
            r4 = 1080033280(0x40600000, float:3.5)
            r9 = 1098372874(0x4177d70a, float:15.49)
            r0.moveTo(r4, r9)
            r12 = 1086324736(0x40c00000, float:6.0)
            r13 = -1061137940(0xffffffffc0c051ec, float:-6.01)
            r0.lineToRelative(r12, r13)
            r0.lineToRelative(r6, r6)
            r6 = 1081794888(0x407ae148, float:3.92)
            r0.lineTo(r8, r6)
            r6 = -1078691103(0xffffffffbfb47ae1, float:-1.41)
            r0.lineToRelative(r6, r6)
            r6 = -1058873016(0xffffffffc0e2e148, float:-7.09)
            r8 = 1090456125(0x40ff0a3d, float:7.97)
            r0.lineToRelative(r6, r8)
            r0.lineToRelative(r7, r7)
            r6 = 1096800010(0x415fd70a, float:13.99)
            r0.lineTo(r2, r6)
            r0.lineTo(r4, r9)
            r0.close()
            java.util.List r2 = r0.getNodes()
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
            androidx.compose.material.icons.outlined.StackedLineChartKt._stackedLineChart = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.outlined.StackedLineChartKt.getStackedLineChart(androidx.compose.material.icons.Icons$Outlined):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
