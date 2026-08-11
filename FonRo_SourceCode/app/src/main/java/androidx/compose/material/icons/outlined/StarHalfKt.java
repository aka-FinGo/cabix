package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* compiled from: StarHalf.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"_starHalf", "Landroidx/compose/ui/graphics/vector/ImageVector;", "StarHalf", "Landroidx/compose/material/icons/Icons$Outlined;", "getStarHalf$annotations", "(Landroidx/compose/material/icons/Icons$Outlined;)V", "getStarHalf", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class StarHalfKt {
    private static ImageVector _starHalf;

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Outlined.StarHalf", replaceWith = @ReplaceWith(expression = "Icons.AutoMirrored.Outlined.StarHalf", imports = {"androidx.compose.material.icons.automirrored.outlined.StarHalf"}))
    public static /* synthetic */ void getStarHalf$annotations(Icons.Outlined outlined) {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getStarHalf(androidx.compose.material.icons.Icons.Outlined r18) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.outlined.StarHalfKt._starHalf
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
            java.lang.String r2 = "Outlined.StarHalf"
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
            r2 = 1102053376(0x41b00000, float:22.0)
            r4 = 1091819274(0x4113d70a, float:9.24)
            r0.moveTo(r2, r4)
            r6 = -1058663301(0xffffffffc0e6147b, float:-7.19)
            r7 = -1088505774(0xffffffffbf1eb852, float:-0.62)
            r0.lineToRelative(r6, r7)
            r6 = 1094713344(0x41400000, float:12.0)
            r7 = 1073741824(0x40000000, float:2.0)
            r0.lineTo(r6, r7)
            r8 = 1091766845(0x41130a3d, float:9.19)
            r9 = 1091179643(0x410a147b, float:8.63)
            r0.lineTo(r8, r9)
            r0.lineTo(r7, r4)
            r7 = 1085192274(0x40aeb852, float:5.46)
            r8 = 1083661353(0x40975c29, float:4.73)
            r0.lineToRelative(r7, r8)
            r7 = 1085947249(0x40ba3d71, float:5.82)
            r8 = 1101529088(0x41a80000, float:21.0)
            r0.lineTo(r7, r8)
            r7 = 1099573494(0x418a28f6, float:17.27)
            r0.lineTo(r6, r7)
            r7 = 1100050596(0x419170a4, float:18.18)
            r0.lineTo(r7, r8)
            r7 = -1076845609(0xffffffffbfd0a3d7, float:-1.63)
            r8 = -1058998845(0xffffffffc0e0f5c3, float:-7.03)
            r0.lineToRelative(r7, r8)
            r0.lineTo(r2, r4)
            r0.close()
            r2 = 1098278502(0x41766666, float:15.4)
            r0.moveTo(r6, r2)
            r4 = 1086534451(0x40c33333, float:6.1)
            r0.verticalLineTo(r4)
            r4 = 1071309128(0x3fdae148, float:1.71)
            r7 = 1082214318(0x408147ae, float:4.04)
            r0.lineToRelative(r4, r7)
            r4 = 1082927350(0x408c28f6, float:4.38)
            r7 = 1052938076(0x3ec28f5c, float:0.38)
            r0.lineToRelative(r4, r7)
            r4 = -1068205343(0xffffffffc0547ae1, float:-3.32)
            r7 = 1077432812(0x403851ec, float:2.88)
            r0.lineToRelative(r4, r7)
            r4 = 1065353216(0x3f800000, float:1.0)
            r7 = 1082717635(0x4088f5c3, float:4.28)
            r0.lineToRelative(r4, r7)
            r0.lineTo(r6, r2)
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
            androidx.compose.material.icons.outlined.StarHalfKt._starHalf = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.outlined.StarHalfKt.getStarHalf(androidx.compose.material.icons.Icons$Outlined):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
