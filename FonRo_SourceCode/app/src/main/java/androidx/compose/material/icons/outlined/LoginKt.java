package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* compiled from: Login.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"_login", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Login", "Landroidx/compose/material/icons/Icons$Outlined;", "getLogin$annotations", "(Landroidx/compose/material/icons/Icons$Outlined;)V", "getLogin", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LoginKt {
    private static ImageVector _login;

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Outlined.Login", replaceWith = @ReplaceWith(expression = "Icons.AutoMirrored.Outlined.Login", imports = {"androidx.compose.material.icons.automirrored.outlined.Login"}))
    public static /* synthetic */ void getLogin$annotations(Icons.Outlined outlined) {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getLogin(androidx.compose.material.icons.Icons.Outlined r19) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.outlined.LoginKt._login
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
            java.lang.String r2 = "Outlined.Login"
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
            r2 = 1088421888(0x40e00000, float:7.0)
            r12.moveTo(r0, r2)
            r4 = 1092196762(0x4119999a, float:9.6)
            r6 = 1090938470(0x41066666, float:8.4)
            r12.lineTo(r4, r6)
            r4 = 1076258406(0x40266666, float:2.6)
            r12.lineToRelative(r4, r4)
            r6 = 1073741824(0x40000000, float:2.0)
            r12.horizontalLineTo(r6)
            r12.verticalLineToRelative(r6)
            r7 = 1092825907(0x41233333, float:10.2)
            r12.horizontalLineToRelative(r7)
            r7 = -1071225242(0xffffffffc0266666, float:-2.6)
            r12.lineToRelative(r7, r4)
            r4 = 1099431936(0x41880000, float:17.0)
            r12.lineTo(r0, r4)
            r4 = -1063256064(0xffffffffc0a00000, float:-5.0)
            r7 = 1084227584(0x40a00000, float:5.0)
            r12.lineToRelative(r7, r4)
            r12.lineTo(r0, r2)
            r12.close()
            r0 = 1101004800(0x41a00000, float:20.0)
            r2 = 1100480512(0x41980000, float:19.0)
            r12.moveTo(r0, r2)
            r0 = -1056964608(0xffffffffc1000000, float:-8.0)
            r12.horizontalLineToRelative(r0)
            r12.verticalLineToRelative(r6)
            r4 = 1090519040(0x41000000, float:8.0)
            r12.horizontalLineToRelative(r4)
            r17 = 1073741824(0x40000000, float:2.0)
            r18 = -1073741824(0xffffffffc0000000, float:-2.0)
            r13 = 1066192077(0x3f8ccccd, float:1.1)
            r14 = 0
            r15 = 1073741824(0x40000000, float:2.0)
            r16 = -1083808154(0xffffffffbf666666, float:-0.9)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r12.verticalLineTo(r7)
            r17 = -1073741824(0xffffffffc0000000, float:-2.0)
            r13 = 0
            r14 = -1081291571(0xffffffffbf8ccccd, float:-1.1)
            r15 = -1083808154(0xffffffffbf666666, float:-0.9)
            r16 = -1073741824(0xffffffffc0000000, float:-2.0)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r12.horizontalLineToRelative(r0)
            r12.verticalLineToRelative(r6)
            r12.horizontalLineToRelative(r4)
            r12.verticalLineTo(r2)
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
            r14 = 0
            r15 = 0
            androidx.compose.ui.graphics.vector.ImageVector$Builder r0 = androidx.compose.ui.graphics.vector.ImageVector.Builder.m5069addPathoIyEayM$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            androidx.compose.ui.graphics.vector.ImageVector r0 = r0.build()
            androidx.compose.material.icons.outlined.LoginKt._login = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.outlined.LoginKt.getLogin(androidx.compose.material.icons.Icons$Outlined):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
