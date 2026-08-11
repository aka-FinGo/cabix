package androidx.compose.material.icons.sharp;

import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Texture.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_texture", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Texture", "Landroidx/compose/material/icons/Icons$Sharp;", "getTexture", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextureKt {
    private static ImageVector _texture;

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getTexture(androidx.compose.material.icons.Icons.Sharp r18) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.sharp.TextureKt._texture
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
            java.lang.String r2 = "Sharp.Texture"
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
            r2 = 1100826542(0x419d47ae, float:19.66)
            r4 = 1077936128(0x40400000, float:3.0)
            r0.moveTo(r2, r4)
            r2 = 1100789842(0x419cb852, float:19.59)
            r6 = 1078229729(0x40447ae1, float:3.07)
            r0.lineTo(r6, r2)
            r2 = 1101529088(0x41a80000, float:21.0)
            r0.lineTo(r6, r2)
            r7 = 1068792545(0x3fb47ae1, float:1.41)
            r0.horizontalLineToRelative(r7)
            r7 = 1083011236(0x408d70a4, float:4.42)
            r8 = 1101565788(0x41a88f5c, float:21.07)
            r0.lineTo(r8, r7)
            r0.lineTo(r8, r4)
            r0.close()
            r7 = 1094660915(0x413f3333, float:11.95)
            r0.moveTo(r7, r4)
            r7 = -1056041861(0xffffffffc10e147b, float:-8.88)
            r9 = 1091441787(0x410e147b, float:8.88)
            r0.lineToRelative(r7, r9)
            r12 = 1077223096(0x40351eb8, float:2.83)
            r0.verticalLineToRelative(r12)
            r12 = 1097628385(0x416c7ae1, float:14.78)
            r0.lineTo(r12, r4)
            r0.close()
            r0.moveTo(r6, r4)
            r4 = 1082130432(0x40800000, float:4.0)
            r0.verticalLineToRelative(r4)
            r6 = -1065353216(0xffffffffc0800000, float:-4.0)
            r0.lineToRelative(r4, r6)
            r0.close()
            r0.moveTo(r8, r2)
            r0.verticalLineToRelative(r6)
            r0.lineToRelative(r6, r4)
            r0.close()
            r4 = 1094912573(0x41430a3d, float:12.19)
            r0.moveTo(r4, r2)
            r0.lineToRelative(r9, r7)
            r4 = 1091871703(0x4114a3d7, float:9.29)
            r0.lineTo(r8, r4)
            r4 = 1091945103(0x4115c28f, float:9.36)
            r0.lineTo(r4, r2)
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
            androidx.compose.material.icons.sharp.TextureKt._texture = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.sharp.TextureKt.getTexture(androidx.compose.material.icons.Icons$Sharp):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
