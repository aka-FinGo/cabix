package androidx.compose.material.icons.sharp;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* compiled from: ScreenShare.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"_screenShare", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ScreenShare", "Landroidx/compose/material/icons/Icons$Sharp;", "getScreenShare$annotations", "(Landroidx/compose/material/icons/Icons$Sharp;)V", "getScreenShare", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ScreenShareKt {
    private static ImageVector _screenShare;

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Sharp.ScreenShare", replaceWith = @ReplaceWith(expression = "Icons.AutoMirrored.Sharp.ScreenShare", imports = {"androidx.compose.material.icons.automirrored.sharp.ScreenShare"}))
    public static /* synthetic */ void getScreenShare$annotations(Icons.Sharp sharp) {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getScreenShare(androidx.compose.material.icons.Icons.Sharp r19) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.sharp.ScreenShareKt._screenShare
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
            java.lang.String r2 = "Sharp.ScreenShare"
            r5 = 1103101952(0x41c00000, float:24.0)
            r6 = 1103101952(0x41c00000, float:24.0)
            r7 = 0
            r9 = 0
            r10 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7, r9, r10, r11, r12)
            int r3 = androidx.compose.ui.graphics.vector.VectorKt.getDefaultFillType()
            androidx.compose.ui.graphics.SolidColor r2 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.INSTANCE
            long r4 = r4.m4410getBlack0d7_KjU()
            r6 = 0
            r2.<init>(r4, r6)
            r5 = r2
            androidx.compose.ui.graphics.Brush r5 = (androidx.compose.ui.graphics.Brush) r5
            androidx.compose.ui.graphics.StrokeCap$Companion r2 = androidx.compose.ui.graphics.StrokeCap.INSTANCE
            int r10 = r2.m4737getButtKaPHkGw()
            androidx.compose.ui.graphics.StrokeJoin$Companion r2 = androidx.compose.ui.graphics.StrokeJoin.INSTANCE
            int r11 = r2.m4747getBevelLxFBmk8()
            androidx.compose.ui.graphics.vector.PathBuilder r12 = new androidx.compose.ui.graphics.vector.PathBuilder
            r12.<init>()
            r2 = 1101004800(0x41a00000, float:20.0)
            r4 = 1099956224(0x41900000, float:18.0)
            r12.moveTo(r2, r4)
            r2 = 1073741824(0x40000000, float:2.0)
            r6 = -1073741824(0xffffffffc0000000, float:-2.0)
            r12.lineToRelative(r2, r6)
            r7 = 1102053376(0x41b00000, float:22.0)
            r8 = 1082130432(0x40800000, float:4.0)
            r12.lineTo(r7, r8)
            r12.lineTo(r2, r8)
            r7 = 1094713344(0x41400000, float:12.0)
            r12.verticalLineToRelative(r7)
            r12.lineToRelative(r2, r2)
            r7 = 0
            r12.lineTo(r7, r4)
            r12.verticalLineToRelative(r2)
            r12.horizontalLineToRelative(r0)
            r12.verticalLineToRelative(r6)
            r0 = -1065353216(0xffffffffc0800000, float:-4.0)
            r12.horizontalLineToRelative(r0)
            r12.close()
            r2 = 1097303327(0x4167851f, float:14.47)
            r4 = 1095761920(0x41500000, float:13.0)
            r12.moveTo(r4, r2)
            r2 = -1072944906(0xffffffffc00c28f6, float:-2.19)
            r12.verticalLineToRelative(r2)
            r17 = -1061158912(0xffffffffc0c00000, float:-6.0)
            r18 = 1076761723(0x402e147b, float:2.72)
            r13 = -1070470267(0xffffffffc031eb85, float:-2.78)
            r14 = 0
            r15 = -1064073953(0xffffffffc093851f, float:-4.61)
            r16 = 1062836634(0x3f59999a, float:0.85)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r17 = 1086324736(0x40c00000, float:6.0)
            r18 = -1061431542(0xffffffffc0bbd70a, float:-5.87)
            r13 = 1057971241(0x3f0f5c29, float:0.56)
            r14 = -1070931640(0xffffffffc02ae148, float:-2.67)
            r15 = 1074203197(0x40070a3d, float:2.11)
            r16 = -1062564004(0xffffffffc0aa8f5c, float:-5.33)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r2 = 1088421888(0x40e00000, float:7.0)
            r12.lineTo(r4, r2)
            r2 = 1080997970(0x406eb852, float:3.73)
            r12.lineToRelative(r8, r2)
            r2 = 1081039913(0x406f5c29, float:3.74)
            r12.lineToRelative(r0, r2)
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
            androidx.compose.material.icons.sharp.ScreenShareKt._screenShare = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.sharp.ScreenShareKt.getScreenShare(androidx.compose.material.icons.Icons$Sharp):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
