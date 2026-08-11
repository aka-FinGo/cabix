package androidx.compose.material.icons.outlined;

import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: StarRate.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_starRate", "Landroidx/compose/ui/graphics/vector/ImageVector;", "StarRate", "Landroidx/compose/material/icons/Icons$Outlined;", "getStarRate", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class StarRateKt {
    private static ImageVector _starRate;

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getStarRate(androidx.compose.material.icons.Icons.Outlined r18) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.outlined.StarRateKt._starRate
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
            java.lang.String r2 = "Outlined.StarRate"
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
            r2 = 1094713344(0x41400000, float:12.0)
            r4 = 1091452273(0x410e3d71, float:8.89)
            r0.moveTo(r2, r4)
            r6 = 1095699005(0x414f0a3d, float:12.94)
            r0.lineTo(r6, r2)
            r6 = 1077181153(0x40347ae1, float:2.82)
            r0.horizontalLineToRelative(r6)
            r7 = -1072609362(0xffffffffc01147ae, float:-2.27)
            r8 = 1070554153(0x3fcf5c29, float:1.62)
            r0.lineToRelative(r7, r8)
            r7 = 1077978071(0x4040a3d7, float:3.01)
            r8 = 1064178811(0x3f6e147b, float:0.93)
            r0.lineToRelative(r8, r7)
            r7 = 1097638871(0x416ca3d7, float:14.79)
            r0.lineTo(r2, r7)
            r7 = 1072399647(0x3feb851f, float:1.84)
            r9 = -1071980216(0xffffffffc01ae148, float:-2.42)
            r0.lineToRelative(r9, r7)
            r7 = -1069505577(0xffffffffc040a3d7, float:-3.01)
            r0.lineToRelative(r8, r7)
            r7 = 1090770698(0x4103d70a, float:8.24)
            r0.lineTo(r7, r2)
            r0.horizontalLineToRelative(r6)
            r0.lineTo(r2, r4)
            r4 = 1073741824(0x40000000, float:2.0)
            r0.moveTo(r2, r4)
            r6 = 1090519040(0x41000000, float:8.0)
            r0.lineToRelative(r9, r6)
            r0.horizontalLineTo(r4)
            r6 = 1086681252(0x40c570a4, float:6.17)
            r7 = 1082990264(0x408d1eb8, float:4.41)
            r0.lineToRelative(r6, r7)
            r6 = 1085968220(0x40ba8f5c, float:5.83)
            r7 = 1102053376(0x41b00000, float:22.0)
            r0.lineTo(r6, r7)
            r6 = 1099594465(0x418a7ae1, float:17.31)
            r0.lineTo(r2, r6)
            r6 = 1100050596(0x419170a4, float:18.18)
            r0.lineTo(r6, r7)
            r6 = -1072273818(0xffffffffc0166666, float:-2.35)
            r8 = -1057824440(0xffffffffc0f2e148, float:-7.59)
            r0.lineToRelative(r6, r8)
            r6 = 1092616192(0x41200000, float:10.0)
            r0.lineTo(r7, r6)
            r6 = -1057845412(0xffffffffc0f28f5c, float:-7.58)
            r0.horizontalLineToRelative(r6)
            r0.lineTo(r2, r4)
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
            androidx.compose.material.icons.outlined.StarRateKt._starRate = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.outlined.StarRateKt.getStarRate(androidx.compose.material.icons.Icons$Outlined):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
