package androidx.compose.material.icons.outlined;

import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: SensorDoor.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_sensorDoor", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SensorDoor", "Landroidx/compose/material/icons/Icons$Outlined;", "getSensorDoor", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SensorDoorKt {
    private static ImageVector _sensorDoor;

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getSensorDoor(androidx.compose.material.icons.Icons.Outlined r19) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.outlined.SensorDoorKt._sensorDoor
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
            java.lang.String r2 = "Outlined.SensorDoor"
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
            r0 = 1099956224(0x41900000, float:18.0)
            r2 = 1082130432(0x40800000, float:4.0)
            r12.moveTo(r0, r2)
            r4 = 1098907648(0x41800000, float:16.0)
            r12.verticalLineToRelative(r4)
            r6 = 1086324736(0x40c00000, float:6.0)
            r12.horizontalLineTo(r6)
            r12.verticalLineTo(r2)
            r12.horizontalLineTo(r0)
            r7 = 1073741824(0x40000000, float:2.0)
            r12.moveTo(r0, r7)
            r12.horizontalLineTo(r6)
            r17 = 1082130432(0x40800000, float:4.0)
            r18 = 1082130432(0x40800000, float:4.0)
            r13 = 1084017869(0x409ccccd, float:4.9)
            r14 = 1073741824(0x40000000, float:2.0)
            r15 = 1082130432(0x40800000, float:4.0)
            r16 = 1077516698(0x4039999a, float:2.9)
            r12.curveTo(r13, r14, r15, r16, r17, r18)
            r12.verticalLineToRelative(r0)
            r12.horizontalLineToRelative(r4)
            r12.verticalLineTo(r2)
            r17 = 1099956224(0x41900000, float:18.0)
            r18 = 1073741824(0x40000000, float:2.0)
            r13 = 1101004800(0x41a00000, float:20.0)
            r14 = 1077516698(0x4039999a, float:2.9)
            r15 = 1100532941(0x4198cccd, float:19.1)
            r16 = 1073741824(0x40000000, float:2.0)
            r12.curveTo(r13, r14, r15, r16, r17, r18)
            r12.lineTo(r0, r7)
            r12.close()
            r0 = 1098383360(0x41780000, float:15.5)
            r2 = 1093140480(0x41280000, float:10.5)
            r12.moveTo(r0, r2)
            r17 = -1077936128(0xffffffffbfc00000, float:-1.5)
            r18 = 1069547520(0x3fc00000, float:1.5)
            r13 = -1084982559(0xffffffffbf547ae1, float:-0.83)
            r14 = 0
            r15 = -1077936128(0xffffffffbfc00000, float:-1.5)
            r16 = 1059816735(0x3f2b851f, float:0.67)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r4 = 1059816735(0x3f2b851f, float:0.67)
            r6 = 1069547520(0x3fc00000, float:1.5)
            r12.reflectiveCurveToRelative(r4, r6, r6, r6)
            r17 = 1069547520(0x3fc00000, float:1.5)
            r18 = -1077936128(0xffffffffbfc00000, float:-1.5)
            r13 = 1062501089(0x3f547ae1, float:0.83)
            r15 = 1069547520(0x3fc00000, float:1.5)
            r16 = -1087666913(0xffffffffbf2b851f, float:-0.67)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r4 = 1099080663(0x4182a3d7, float:16.33)
            r12.reflectiveCurveTo(r4, r2, r0, r2)
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
            androidx.compose.material.icons.outlined.SensorDoorKt._sensorDoor = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.outlined.SensorDoorKt.getSensorDoor(androidx.compose.material.icons.Icons$Outlined):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
