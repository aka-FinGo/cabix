package androidx.compose.material.icons.outlined;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* compiled from: ViewQuilt.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"_viewQuilt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ViewQuilt", "Landroidx/compose/material/icons/Icons$Outlined;", "getViewQuilt$annotations", "(Landroidx/compose/material/icons/Icons$Outlined;)V", "getViewQuilt", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ViewQuiltKt {
    private static ImageVector _viewQuilt;

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Outlined.ViewQuilt", replaceWith = @ReplaceWith(expression = "Icons.AutoMirrored.Outlined.ViewQuilt", imports = {"androidx.compose.material.icons.automirrored.outlined.ViewQuilt"}))
    public static /* synthetic */ void getViewQuilt$annotations(Icons.Outlined outlined) {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getViewQuilt(androidx.compose.material.icons.Icons.Outlined r18) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.outlined.ViewQuiltKt._viewQuilt
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
            java.lang.String r2 = "Outlined.ViewQuilt"
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
            r2 = 1077936128(0x40400000, float:3.0)
            r4 = 1084227584(0x40a00000, float:5.0)
            r0.moveTo(r2, r4)
            r6 = 1096810496(0x41600000, float:14.0)
            r0.verticalLineToRelative(r6)
            r6 = 1099956224(0x41900000, float:18.0)
            r0.horizontalLineToRelative(r6)
            r0.verticalLineTo(r4)
            r0.horizontalLineTo(r2)
            r0.close()
            r2 = 1090865070(0x410547ae, float:8.33)
            r6 = 1099431936(0x41880000, float:17.0)
            r0.moveTo(r2, r6)
            r0.horizontalLineTo(r4)
            r2 = 1088421888(0x40e00000, float:7.0)
            r0.verticalLineTo(r2)
            r4 = 1079320248(0x40551eb8, float:3.33)
            r0.horizontalLineToRelative(r4)
            r0.verticalLineTo(r6)
            r0.close()
            r7 = 1096464466(0x415ab852, float:13.67)
            r0.moveTo(r7, r6)
            r7 = -1068163400(0xffffffffc0551eb8, float:-3.33)
            r0.horizontalLineToRelative(r7)
            r8 = -1065353216(0xffffffffc0800000, float:-4.0)
            r0.verticalLineToRelative(r8)
            r0.horizontalLineToRelative(r4)
            r0.verticalLineTo(r6)
            r0.close()
            r4 = 1100480512(0x41980000, float:19.0)
            r0.moveTo(r4, r6)
            r0.horizontalLineToRelative(r7)
            r0.verticalLineToRelative(r8)
            r0.horizontalLineTo(r4)
            r0.verticalLineTo(r6)
            r0.close()
            r6 = 1093664768(0x41300000, float:11.0)
            r0.moveTo(r4, r6)
            r7 = -1056262062(0xffffffffc10ab852, float:-8.67)
            r0.horizontalLineToRelative(r7)
            r0.verticalLineTo(r2)
            r0.horizontalLineTo(r4)
            r0.verticalLineTo(r6)
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
            androidx.compose.material.icons.outlined.ViewQuiltKt._viewQuilt = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.outlined.ViewQuiltKt.getViewQuilt(androidx.compose.material.icons.Icons$Outlined):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
