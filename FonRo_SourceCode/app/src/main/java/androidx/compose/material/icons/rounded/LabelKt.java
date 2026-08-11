package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* compiled from: Label.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"_label", "Landroidx/compose/ui/graphics/vector/ImageVector;", TextFieldImplKt.LabelId, "Landroidx/compose/material/icons/Icons$Rounded;", "getLabel$annotations", "(Landroidx/compose/material/icons/Icons$Rounded;)V", "getLabel", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LabelKt {
    private static ImageVector _label;

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Rounded.Label", replaceWith = @ReplaceWith(expression = "Icons.AutoMirrored.Rounded.Label", imports = {"androidx.compose.material.icons.automirrored.rounded.Label"}))
    public static /* synthetic */ void getLabel$annotations(Icons.Rounded rounded) {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getLabel(androidx.compose.material.icons.Icons.Rounded r19) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.rounded.LabelKt._label
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
            java.lang.String r2 = "Rounded.Label"
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
            r0 = 1099762237(0x418d0a3d, float:17.63)
            r2 = 1085989192(0x40bae148, float:5.84)
            r12.moveTo(r0, r2)
            r17 = 1098907648(0x41800000, float:16.0)
            r18 = 1084227584(0x40a00000, float:5.0)
            r13 = 1099573494(0x418a28f6, float:17.27)
            r14 = 1084919644(0x40aa8f5c, float:5.33)
            r15 = 1099258921(0x41855c29, float:16.67)
            r16 = 1084227584(0x40a00000, float:5.0)
            r12.curveTo(r13, r14, r15, r16, r17, r18)
            r0 = 1084227584(0x40a00000, float:5.0)
            r2 = 1084248556(0x40a051ec, float:5.01)
            r12.lineTo(r0, r2)
            r17 = 1077936128(0x40400000, float:3.0)
            r18 = 1088421888(0x40e00000, float:7.0)
            r13 = 1081711002(0x4079999a, float:3.9)
            r14 = 1084248556(0x40a051ec, float:5.01)
            r15 = 1077936128(0x40400000, float:3.0)
            r16 = 1086115021(0x40bccccd, float:5.9)
            r12.curveTo(r13, r14, r15, r16, r17, r18)
            r0 = 1092616192(0x41200000, float:10.0)
            r12.verticalLineToRelative(r0)
            r17 = 1073741824(0x40000000, float:2.0)
            r18 = 1073657938(0x3ffeb852, float:1.99)
            r13 = 0
            r14 = 1066192077(0x3f8ccccd, float:1.1)
            r15 = 1063675494(0x3f666666, float:0.9)
            r16 = 1073657938(0x3ffeb852, float:1.99)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = 1098907648(0x41800000, float:16.0)
            r2 = 1100480512(0x41980000, float:19.0)
            r12.lineTo(r0, r2)
            r17 = 1070638039(0x3fd0a3d7, float:1.63)
            r18 = -1084814787(0xffffffffbf570a3d, float:-0.84)
            r13 = 1059816735(0x3f2b851f, float:0.67)
            r14 = 0
            r15 = 1067618140(0x3fa28f5c, float:1.27)
            r16 = -1096223293(0xffffffffbea8f5c3, float:-0.33)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = 1081962660(0x407d70a4, float:3.96)
            r2 = -1062039716(0xffffffffc0b28f5c, float:-5.58)
            r12.lineToRelative(r0, r2)
            r17 = 0
            r18 = -1080788255(0xffffffffbf947ae1, float:-1.16)
            r13 = 1048576000(0x3e800000, float:0.25)
            r14 = -1095552205(0xffffffffbeb33333, float:-0.35)
            r15 = 1048576000(0x3e800000, float:0.25)
            r16 = -1085318103(0xffffffffbf4f5c29, float:-0.81)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r0 = -1065520988(0xffffffffc07d70a4, float:-3.96)
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
            androidx.compose.material.icons.rounded.LabelKt._label = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.rounded.LabelKt.getLabel(androidx.compose.material.icons.Icons$Rounded):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
