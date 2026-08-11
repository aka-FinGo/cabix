package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* compiled from: Shortcut.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"_shortcut", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Shortcut", "Landroidx/compose/material/icons/Icons$Outlined;", "getShortcut$annotations", "(Landroidx/compose/material/icons/Icons$Outlined;)V", "getShortcut", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ShortcutKt {
    private static ImageVector _shortcut;

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Outlined.Shortcut", replaceWith = @ReplaceWith(expression = "Icons.AutoMirrored.Outlined.Shortcut", imports = {"androidx.compose.material.icons.automirrored.outlined.Shortcut"}))
    public static /* synthetic */ void getShortcut$annotations(Icons.Outlined outlined) {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getShortcut(androidx.compose.material.icons.Icons.Outlined r19) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.outlined.ShortcutKt._shortcut
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
            java.lang.String r2 = "Outlined.Shortcut"
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
            r0 = 1097859072(0x41700000, float:15.0)
            r2 = 1084227584(0x40a00000, float:5.0)
            r12.moveTo(r0, r2)
            r4 = -1078691103(0xffffffffbfb47ae1, float:-1.41)
            r6 = 1068792545(0x3fb47ae1, float:1.41)
            r12.lineToRelative(r4, r6)
            r7 = 1090162524(0x40fa8f5c, float:7.83)
            r12.lineTo(r0, r7)
            r7 = 1099521065(0x41895c29, float:17.17)
            r8 = 1092616192(0x41200000, float:10.0)
            r12.lineTo(r7, r8)
            r7 = 1090519040(0x41000000, float:8.0)
            r12.horizontalLineTo(r7)
            r17 = -1063256064(0xffffffffc0a00000, float:-5.0)
            r18 = 1084227584(0x40a00000, float:5.0)
            r13 = -1070554153(0xffffffffc030a3d7, float:-2.76)
            r14 = 0
            r15 = -1063256064(0xffffffffc0a00000, float:-5.0)
            r16 = 1074748457(0x400f5c29, float:2.24)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r7 = 1082130432(0x40800000, float:4.0)
            r12.verticalLineToRelative(r7)
            r7 = 1073741824(0x40000000, float:2.0)
            r12.horizontalLineToRelative(r7)
            r7 = -1065353216(0xffffffffc0800000, float:-4.0)
            r12.verticalLineToRelative(r7)
            r17 = 1077936128(0x40400000, float:3.0)
            r18 = -1069547520(0xffffffffc0400000, float:-3.0)
            r13 = 0
            r14 = -1076677837(0xffffffffbfd33333, float:-1.65)
            r15 = 1068289229(0x3faccccd, float:1.35)
            r16 = -1069547520(0xffffffffc0400000, float:-3.0)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r7 = 1091745874(0x4112b852, float:9.17)
            r12.horizontalLineToRelative(r7)
            r7 = 1096988754(0x4162b852, float:14.17)
            r12.lineTo(r0, r7)
            r12.lineToRelative(r4, r6)
            r4 = 1099431936(0x41880000, float:17.0)
            r12.lineTo(r0, r4)
            r4 = 1086324736(0x40c00000, float:6.0)
            r6 = -1061158912(0xffffffffc0c00000, float:-6.0)
            r12.lineToRelative(r4, r6)
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
            r14 = 0
            r15 = 0
            androidx.compose.ui.graphics.vector.ImageVector$Builder r0 = androidx.compose.ui.graphics.vector.ImageVector.Builder.m5069addPathoIyEayM$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            androidx.compose.ui.graphics.vector.ImageVector r0 = r0.build()
            androidx.compose.material.icons.outlined.ShortcutKt._shortcut = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.outlined.ShortcutKt.getShortcut(androidx.compose.material.icons.Icons$Outlined):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
