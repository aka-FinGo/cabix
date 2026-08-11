package androidx.compose.material.icons.rounded;

import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: FilterAlt.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_filterAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FilterAlt", "Landroidx/compose/material/icons/Icons$Rounded;", "getFilterAlt", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FilterAltKt {
    private static ImageVector _filterAlt;

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getFilterAlt(androidx.compose.material.icons.Icons.Rounded r19) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.rounded.FilterAltKt._filterAlt
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
            java.lang.String r2 = "Rounded.FilterAlt"
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
            r0 = 1082654720(0x40880000, float:4.25)
            r2 = 1085506847(0x40b3851f, float:5.61)
            r12.moveTo(r0, r2)
            r17 = 1092616192(0x41200000, float:10.0)
            r18 = 1095761920(0x41500000, float:13.0)
            r13 = 1087520113(0x40d23d71, float:6.57)
            r14 = 1091137700(0x410970a4, float:8.59)
            r15 = 1092616192(0x41200000, float:10.0)
            r16 = 1095761920(0x41500000, float:13.0)
            r12.curveTo(r13, r14, r15, r16, r17, r18)
            r0 = 1084227584(0x40a00000, float:5.0)
            r12.verticalLineToRelative(r0)
            r17 = 1073741824(0x40000000, float:2.0)
            r18 = 1073741824(0x40000000, float:2.0)
            r13 = 0
            r14 = 1066192077(0x3f8ccccd, float:1.1)
            r15 = 1063675494(0x3f666666, float:0.9)
            r16 = 1073741824(0x40000000, float:2.0)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = 0
            r12.horizontalLineToRelative(r0)
            r18 = -1073741824(0xffffffffc0000000, float:-2.0)
            r13 = 1066192077(0x3f8ccccd, float:1.1)
            r14 = 0
            r15 = 1073741824(0x40000000, float:2.0)
            r16 = -1083808154(0xffffffffbf666666, float:-0.9)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = -1063256064(0xffffffffc0a00000, float:-5.0)
            r12.verticalLineToRelative(r0)
            r17 = 1085800448(0x40b80000, float:5.75)
            r18 = -1058243871(0xffffffffc0ec7ae1, float:-7.39)
            r13 = 0
            r15 = 1079739679(0x405b851f, float:3.43)
            r16 = -1064493384(0xffffffffc08d1eb8, float:-4.41)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r17 = 1100454298(0x4197999a, float:18.95)
            r18 = 1082130432(0x40800000, float:4.0)
            r13 = 1101141115(0x41a2147b, float:20.26)
            r14 = 1084122726(0x409e6666, float:4.95)
            r15 = 1100894700(0x419e51ec, float:19.79)
            r16 = 1082130432(0x40800000, float:4.0)
            r12.curveTo(r13, r14, r15, r16, r17, r18)
            r0 = 1084311470(0x40a147ae, float:5.04)
            r12.horizontalLineTo(r0)
            r17 = 1082654720(0x40880000, float:4.25)
            r18 = 1085506847(0x40b3851f, float:5.61)
            r13 = 1082570834(0x4086b852, float:4.21)
            r14 = 1082130432(0x40800000, float:4.0)
            r15 = 1081039913(0x406f5c29, float:3.74)
            r16 = 1084122726(0x409e6666, float:4.95)
            r12.curveTo(r13, r14, r15, r16, r17, r18)
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
            androidx.compose.material.icons.rounded.FilterAltKt._filterAlt = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.rounded.FilterAltKt.getFilterAlt(androidx.compose.material.icons.Icons$Rounded):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
