package androidx.compose.material.icons.sharp;

import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: LocalLibrary.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_localLibrary", "Landroidx/compose/ui/graphics/vector/ImageVector;", "LocalLibrary", "Landroidx/compose/material/icons/Icons$Sharp;", "getLocalLibrary", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LocalLibraryKt {
    private static ImageVector _localLibrary;

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getLocalLibrary(androidx.compose.material.icons.Icons.Sharp r19) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.sharp.LocalLibraryKt._localLibrary
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
            java.lang.String r2 = "Sharp.LocalLibrary"
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
            r0 = 1094241485(0x4138cccd, float:11.55)
            r2 = 1094713344(0x41400000, float:12.0)
            r12.moveTo(r2, r0)
            r17 = 1077936128(0x40400000, float:3.0)
            r18 = 1090519040(0x41000000, float:8.0)
            r13 = 1092238705(0x411a3d71, float:9.64)
            r14 = 1091934618(0x4115999a, float:9.35)
            r15 = 1087331369(0x40cf5c29, float:6.48)
            r16 = 1090519040(0x41000000, float:8.0)
            r12.curveTo(r13, r14, r15, r16, r17, r18)
            r0 = 1093664768(0x41300000, float:11.0)
            r12.verticalLineToRelative(r0)
            r17 = 1091567616(0x41100000, float:9.0)
            r18 = 1080242995(0x40633333, float:3.55)
            r13 = 1079949394(0x405eb852, float:3.48)
            r14 = 0
            r15 = 1087666913(0x40d47ae1, float:6.64)
            r16 = 1068289229(0x3faccccd, float:1.35)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r18 = -1067240653(0xffffffffc0633333, float:-3.55)
            r13 = 1075251773(0x40170a3d, float:2.36)
            r14 = -1072944906(0xffffffffc00c28f6, float:-2.19)
            r15 = 1085318103(0x40b0a3d7, float:5.52)
            r16 = -1067240653(0xffffffffc0633333, float:-3.55)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = 1090519040(0x41000000, float:8.0)
            r12.verticalLineTo(r0)
            r17 = -1055916032(0xffffffffc1100000, float:-9.0)
            r18 = 1080242995(0x40633333, float:3.55)
            r13 = -1067534254(0xffffffffc05eb852, float:-3.48)
            r14 = 0
            r15 = -1059816735(0xffffffffc0d47ae1, float:-6.64)
            r16 = 1068289229(0x3faccccd, float:1.35)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r12.close()
            r12.moveTo(r2, r0)
            r17 = 1077936128(0x40400000, float:3.0)
            r18 = -1069547520(0xffffffffc0400000, float:-3.0)
            r13 = 1070889697(0x3fd47ae1, float:1.66)
            r15 = 1077936128(0x40400000, float:3.0)
            r16 = -1079278305(0xffffffffbfab851f, float:-1.34)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = -1079278305(0xffffffffbfab851f, float:-1.34)
            r2 = -1069547520(0xffffffffc0400000, float:-3.0)
            r12.reflectiveCurveToRelative(r0, r2, r2, r2)
            r0 = 1068205343(0x3fab851f, float:1.34)
            r4 = 1077936128(0x40400000, float:3.0)
            r12.reflectiveCurveToRelative(r2, r0, r2, r4)
            r12.reflectiveCurveToRelative(r0, r4, r4, r4)
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
            androidx.compose.material.icons.sharp.LocalLibraryKt._localLibrary = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.sharp.LocalLibraryKt.getLocalLibrary(androidx.compose.material.icons.Icons$Sharp):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
