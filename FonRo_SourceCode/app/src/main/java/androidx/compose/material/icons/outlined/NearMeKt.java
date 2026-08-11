package androidx.compose.material.icons.outlined;

import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: NearMe.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_nearMe", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NearMe", "Landroidx/compose/material/icons/Icons$Outlined;", "getNearMe", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NearMeKt {
    private static ImageVector _nearMe;

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getNearMe(androidx.compose.material.icons.Icons.Outlined r18) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.outlined.NearMeKt._nearMe
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
            java.lang.String r2 = "Outlined.NearMe"
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
            r2 = 1099573494(0x418a28f6, float:17.27)
            r4 = 1087855657(0x40d75c29, float:6.73)
            r0.moveTo(r2, r4)
            r2 = -1064849900(0xffffffffc087ae14, float:-4.24)
            r4 = 1092752507(0x4122147b, float:10.13)
            r0.lineToRelative(r2, r4)
            r2 = -1079446077(0xffffffffbfa8f5c3, float:-1.32)
            r6 = -1067785912(0xffffffffc05ae148, float:-3.42)
            r0.lineToRelative(r2, r6)
            r2 = -1084982559(0xffffffffbf547ae1, float:-0.83)
            r6 = -1096558838(0xffffffffbea3d70a, float:-0.32)
            r0.lineToRelative(r6, r2)
            r2 = -1085150331(0xffffffffbf51eb85, float:-0.82)
            r0.lineToRelative(r2, r6)
            r2 = -1067743969(0xffffffffc05b851f, float:-3.43)
            r6 = -1079362191(0xffffffffbfaa3d71, float:-1.33)
            r0.lineToRelative(r2, r6)
            r2 = -1064870871(0xffffffffc0875c29, float:-4.23)
            r0.lineToRelative(r4, r2)
            r2 = 1101529088(0x41a80000, float:21.0)
            r4 = 1077936128(0x40400000, float:3.0)
            r0.moveTo(r2, r4)
            r6 = 1093171937(0x41287ae1, float:10.53)
            r0.lineTo(r4, r6)
            r6 = 1065017672(0x3f7ae148, float:0.98)
            r0.verticalLineToRelative(r6)
            r7 = 1088086344(0x40dae148, float:6.84)
            r8 = 1076468122(0x4029999a, float:2.65)
            r0.lineToRelative(r7, r8)
            r7 = 1095216660(0x4147ae14, float:12.48)
            r0.lineTo(r7, r2)
            r0.horizontalLineToRelative(r6)
            r0.lineTo(r2, r4)
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
            androidx.compose.material.icons.outlined.NearMeKt._nearMe = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.outlined.NearMeKt.getNearMe(androidx.compose.material.icons.Icons$Outlined):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
