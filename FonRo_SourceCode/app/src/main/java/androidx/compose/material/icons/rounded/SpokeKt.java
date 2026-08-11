package androidx.compose.material.icons.rounded;

import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Spoke.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_spoke", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Spoke", "Landroidx/compose/material/icons/Icons$Rounded;", "getSpoke", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SpokeKt {
    private static ImageVector _spoke;

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getSpoke(androidx.compose.material.icons.Icons.Rounded r19) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.rounded.SpokeKt._spoke
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
            java.lang.String r2 = "Rounded.Spoke"
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
            r0 = 1098907648(0x41800000, float:16.0)
            r2 = 1088421888(0x40e00000, float:7.0)
            r12.moveTo(r0, r2)
            r17 = -1065353216(0xffffffffc0800000, float:-4.0)
            r18 = 1082130432(0x40800000, float:4.0)
            r13 = 0
            r14 = 1074622628(0x400d70a4, float:2.21)
            r15 = -1075503432(0xffffffffbfe51eb8, float:-1.79)
            r16 = 1082130432(0x40800000, float:4.0)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r4 = 1090519040(0x41000000, float:8.0)
            r6 = 1091787817(0x41135c29, float:9.21)
            r12.reflectiveCurveTo(r4, r6, r4, r2)
            r4 = 1071980216(0x3fe51eb8, float:1.79)
            r7 = -1065353216(0xffffffffc0800000, float:-4.0)
            r8 = 1082130432(0x40800000, float:4.0)
            r12.reflectiveCurveToRelative(r4, r7, r8, r7)
            r9 = 1083787182(0x409947ae, float:4.79)
            r12.reflectiveCurveTo(r0, r9, r0, r2)
            r12.close()
            r0 = 1095761920(0x41500000, float:13.0)
            r12.moveTo(r2, r0)
            r13 = -1072861020(0xffffffffc00d70a4, float:-2.21)
            r14 = 0
            r15 = -1065353216(0xffffffffc0800000, float:-4.0)
            r16 = 1071980216(0x3fe51eb8, float:1.79)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r12.reflectiveCurveToRelative(r4, r8, r8, r8)
            r9 = -1075503432(0xffffffffbfe51eb8, float:-1.79)
            r12.reflectiveCurveToRelative(r8, r9, r8, r7)
            r12.reflectiveCurveTo(r6, r0, r2, r0)
            r12.close()
            r2 = 1099431936(0x41880000, float:17.0)
            r12.moveTo(r2, r0)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r12.reflectiveCurveToRelative(r4, r8, r8, r8)
            r12.reflectiveCurveToRelative(r8, r9, r8, r7)
            r4 = 1100590612(0x4199ae14, float:19.21)
            r12.reflectiveCurveTo(r4, r0, r2, r0)
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
            androidx.compose.material.icons.rounded.SpokeKt._spoke = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.rounded.SpokeKt.getSpoke(androidx.compose.material.icons.Icons$Rounded):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
