package androidx.compose.material.icons.rounded;

import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: BookmarkBorder.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_bookmarkBorder", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BookmarkBorder", "Landroidx/compose/material/icons/Icons$Rounded;", "getBookmarkBorder", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BookmarkBorderKt {
    private static ImageVector _bookmarkBorder;

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getBookmarkBorder(androidx.compose.material.icons.Icons.Rounded r19) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.rounded.BookmarkBorderKt._bookmarkBorder
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
            java.lang.String r2 = "Rounded.BookmarkBorder"
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
            r0 = 1099431936(0x41880000, float:17.0)
            r2 = 1077936128(0x40400000, float:3.0)
            r12.moveTo(r0, r2)
            r4 = 1088421888(0x40e00000, float:7.0)
            r12.lineTo(r4, r2)
            r17 = -1073741824(0xffffffffc0000000, float:-2.0)
            r18 = 1073741824(0x40000000, float:2.0)
            r13 = -1081291571(0xffffffffbf8ccccd, float:-1.1)
            r14 = 0
            r15 = -1073741824(0xffffffffc0000000, float:-2.0)
            r16 = 1063675494(0x3f666666, float:0.9)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r6 = 1098907648(0x41800000, float:16.0)
            r12.verticalLineToRelative(r6)
            r6 = -1069547520(0xffffffffc0400000, float:-3.0)
            r12.lineToRelative(r4, r6)
            r12.lineToRelative(r4, r2)
            r2 = 1100480512(0x41980000, float:19.0)
            r6 = 1084227584(0x40a00000, float:5.0)
            r12.lineTo(r2, r6)
            r18 = -1073741824(0xffffffffc0000000, float:-2.0)
            r13 = 0
            r14 = -1081291571(0xffffffffbf8ccccd, float:-1.1)
            r15 = -1083808154(0xffffffffbf666666, float:-0.9)
            r16 = -1073741824(0xffffffffc0000000, float:-2.0)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r12.close()
            r2 = 1099956224(0x41900000, float:18.0)
            r12.moveTo(r0, r2)
            r0 = -1063256064(0xffffffffc0a00000, float:-5.0)
            r6 = -1072986849(0xffffffffc00b851f, float:-2.18)
            r12.lineToRelative(r0, r6)
            r12.lineTo(r4, r2)
            r0 = 1086324736(0x40c00000, float:6.0)
            r12.lineTo(r4, r0)
            r17 = 1065353216(0x3f800000, float:1.0)
            r18 = -1082130432(0xffffffffbf800000, float:-1.0)
            r14 = -1089680179(0xffffffffbf0ccccd, float:-0.55)
            r15 = 1055286886(0x3ee66666, float:0.45)
            r16 = -1082130432(0xffffffffbf800000, float:-1.0)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = 1090519040(0x41000000, float:8.0)
            r12.horizontalLineToRelative(r0)
            r18 = 1065353216(0x3f800000, float:1.0)
            r13 = 1057803469(0x3f0ccccd, float:0.55)
            r14 = 0
            r15 = 1065353216(0x3f800000, float:1.0)
            r16 = 1055286886(0x3ee66666, float:0.45)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = 1094713344(0x41400000, float:12.0)
            r12.verticalLineToRelative(r0)
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
            androidx.compose.material.icons.rounded.BookmarkBorderKt._bookmarkBorder = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.rounded.BookmarkBorderKt.getBookmarkBorder(androidx.compose.material.icons.Icons$Rounded):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
