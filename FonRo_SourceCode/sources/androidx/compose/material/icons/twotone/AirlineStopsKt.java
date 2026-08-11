package androidx.compose.material.icons.twotone;

import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: AirlineStops.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_airlineStops", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AirlineStops", "Landroidx/compose/material/icons/Icons$TwoTone;", "getAirlineStops", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AirlineStopsKt {
    private static ImageVector _airlineStops;

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getAirlineStops(androidx.compose.material.icons.Icons.TwoTone r19) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.twotone.AirlineStopsKt._airlineStops
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
            java.lang.String r2 = "TwoTone.AirlineStops"
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
            r0 = 1100066324(0x4191ae14, float:18.21)
            r2 = 1091787817(0x41135c29, float:9.21)
            r12.moveTo(r0, r2)
            r17 = 1095761920(0x41500000, float:13.0)
            r18 = 1099431936(0x41880000, float:17.0)
            r13 = 1098834248(0x417ee148, float:15.93)
            r14 = 1093434081(0x412c7ae1, float:10.78)
            r15 = 1096233779(0x41573333, float:13.45)
            r16 = 1096076493(0x4154cccd, float:13.3)
            r12.curveTo(r13, r14, r15, r16, r17, r18)
            r4 = 1073741824(0x40000000, float:2.0)
            r12.horizontalLineToRelative(r4)
            r12.verticalLineToRelative(r4)
            r6 = 1091567616(0x41100000, float:9.0)
            r12.horizontalLineTo(r6)
            r6 = -1073741824(0xffffffffc0000000, float:-2.0)
            r12.verticalLineToRelative(r6)
            r12.horizontalLineToRelative(r4)
            r17 = -1055916032(0xffffffffc1100000, float:-9.0)
            r18 = -1056964608(0xffffffffc1000000, float:-8.0)
            r13 = -1090519040(0xffffffffbf000000, float:-0.5)
            r14 = -1064304640(0xffffffffc0900000, float:-4.5)
            r15 = -1064577270(0xffffffffc08bd70a, float:-4.37)
            r16 = -1056964608(0xffffffffc1000000, float:-8.0)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r4 = 1088421888(0x40e00000, float:7.0)
            r12.verticalLineTo(r4)
            r17 = 1092616192(0x41200000, float:10.0)
            r18 = 1086953882(0x40c9999a, float:6.3)
            r13 = 1082948321(0x408c7ae1, float:4.39)
            r14 = 0
            r15 = 1090749727(0x4103851f, float:8.22)
            r16 = 1076048691(0x40233333, float:2.55)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r17 = 1083766211(0x4098f5c3, float:4.78)
            r18 = -1062165545(0xffffffffc0b0a3d7, float:-5.52)
            r13 = 1066443735(0x3f90a3d7, float:1.13)
            r14 = -1071938273(0xffffffffc01b851f, float:-2.43)
            r15 = 1077894185(0x403f5c29, float:2.99)
            r16 = -1064828928(0xffffffffc0880000, float:-4.25)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r6 = 1096810496(0x41600000, float:14.0)
            r7 = 1084227584(0x40a00000, float:5.0)
            r12.lineTo(r6, r7)
            r12.horizontalLineToRelative(r4)
            r12.verticalLineToRelative(r4)
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
            r14 = 0
            r15 = 0
            androidx.compose.ui.graphics.vector.ImageVector$Builder r0 = androidx.compose.ui.graphics.vector.ImageVector.Builder.m5069addPathoIyEayM$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            androidx.compose.ui.graphics.vector.ImageVector r0 = r0.build()
            androidx.compose.material.icons.twotone.AirlineStopsKt._airlineStops = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.twotone.AirlineStopsKt.getAirlineStops(androidx.compose.material.icons.Icons$TwoTone):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
