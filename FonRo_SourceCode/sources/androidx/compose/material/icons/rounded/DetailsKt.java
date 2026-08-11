package androidx.compose.material.icons.rounded;

import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Details.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_details", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Details", "Landroidx/compose/material/icons/Icons$Rounded;", "getDetails", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DetailsKt {
    private static ImageVector _details;

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getDetails(androidx.compose.material.icons.Icons.Rounded r19) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.rounded.DetailsKt._details
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
            java.lang.String r2 = "Rounded.Details"
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
            r0 = 1093801083(0x4132147b, float:11.13)
            r2 = 1083325809(0x40923d71, float:4.57)
            r12.moveTo(r0, r2)
            r0 = 1097796157(0x416f0a3d, float:14.94)
            r2 = -1056650035(0xffffffffc104cccd, float:-8.3)
            r12.lineToRelative(r2, r0)
            r17 = 1080872141(0x406ccccd, float:3.7)
            r18 = 1101529088(0x41a80000, float:21.0)
            r13 = 1075671204(0x401d70a4, float:2.46)
            r14 = 1101099172(0x41a170a4, float:20.18)
            r15 = 1077684470(0x403c28f6, float:2.94)
            r16 = 1101529088(0x41a80000, float:21.0)
            r12.curveTo(r13, r14, r15, r16, r17, r18)
            r0 = 1099222221(0x4184cccd, float:16.6)
            r12.horizontalLineToRelative(r0)
            r17 = 1063172178(0x3f5eb852, float:0.87)
            r18 = -1078020014(0xffffffffbfbeb852, float:-1.49)
            r13 = 1061326684(0x3f428f5c, float:0.76)
            r14 = 0
            r15 = 1067366482(0x3f9eb852, float:1.24)
            r16 = -1085150331(0xffffffffbf51eb85, float:-0.82)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = -1049687491(0xffffffffc16f0a3d, float:-14.94)
            r12.lineToRelative(r2, r0)
            r17 = 1093801083(0x4132147b, float:11.13)
            r18 = 1083325809(0x40923d71, float:4.57)
            r13 = 1095227146(0x4147d70a, float:12.49)
            r14 = 1081669059(0x4078f5c3, float:3.89)
            r15 = 1094199542(0x413828f6, float:11.51)
            r16 = 1081669059(0x4078f5c3, float:3.89)
            r12.curveTo(r13, r14, r15, r16, r17, r18)
            r12.close()
            r0 = 1095761920(0x41500000, float:13.0)
            r2 = 1091483730(0x410eb852, float:8.92)
            r12.moveTo(r0, r2)
            r4 = 1100270797(0x4194cccd, float:18.6)
            r6 = 1100480512(0x41980000, float:19.0)
            r12.lineTo(r4, r6)
            r12.horizontalLineTo(r0)
            r12.verticalLineTo(r2)
            r12.close()
            r0 = 1093664768(0x41300000, float:11.0)
            r12.moveTo(r0, r2)
            r12.verticalLineTo(r6)
            r4 = 1085066445(0x40accccd, float:5.4)
            r12.horizontalLineTo(r4)
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
            androidx.compose.material.icons.rounded.DetailsKt._details = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.rounded.DetailsKt.getDetails(androidx.compose.material.icons.Icons$Rounded):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
