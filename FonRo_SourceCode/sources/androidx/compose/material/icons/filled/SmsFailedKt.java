package androidx.compose.material.icons.filled;

import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: SmsFailed.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_smsFailed", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SmsFailed", "Landroidx/compose/material/icons/Icons$Filled;", "getSmsFailed", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SmsFailedKt {
    private static ImageVector _smsFailed;

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1685)
        	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1660)
        	at jadx.core.dex.instructions.args.SSAVar.removeUse(SSAVar.java:140)
        	at jadx.core.dex.instructions.args.SSAVar.use(SSAVar.java:133)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:489)
        	at jadx.core.dex.instructions.mods.TernaryInsn.rebindArgs(TernaryInsn.java:92)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:492)
        	at jadx.core.utils.BlockUtils.replaceInsn(BlockUtils.java:1109)
        	at jadx.core.utils.BlockUtils.replaceInsn(BlockUtils.java:1118)
        	at jadx.core.dex.visitors.InlineMethods.inlineMethod(InlineMethods.java:113)
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:72)
        	... 1 more
        */
    public static final androidx.compose.ui.graphics.vector.ImageVector getSmsFailed(androidx.compose.material.icons.Icons.Filled r19) {
        /*
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.filled.SmsFailedKt._smsFailed
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
            java.lang.String r2 = "Filled.SmsFailed"
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
            r0 = 1101004800(0x41a00000, float:20.0)
            r2 = 1073741824(0x40000000, float:2.0)
            r12.moveTo(r0, r2)
            r0 = 1082130432(0x40800000, float:4.0)
            r12.lineTo(r0, r2)
            r17 = -1073825710(0xffffffffbffeb852, float:-1.99)
            r18 = 1073741824(0x40000000, float:2.0)
            r13 = -1081291571(0xffffffffbf8ccccd, float:-1.1)
            r14 = 0
            r15 = -1073825710(0xffffffffbffeb852, float:-1.99)
            r16 = 1063675494(0x3f666666, float:0.9)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r4 = 1102053376(0x41b00000, float:22.0)
            r12.lineTo(r2, r4)
            r6 = -1065353216(0xffffffffc0800000, float:-4.0)
            r12.lineToRelative(r0, r6)
            r6 = 1096810496(0x41600000, float:14.0)
            r12.horizontalLineToRelative(r6)
            r17 = 1073741824(0x40000000, float:2.0)
            r18 = -1073741824(0xffffffffc0000000, float:-2.0)
            r13 = 1066192077(0x3f8ccccd, float:1.1)
            r15 = 1073741824(0x40000000, float:2.0)
            r16 = -1083808154(0xffffffffbf666666, float:-0.9)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r12.lineTo(r4, r0)
            r17 = -1073741824(0xffffffffc0000000, float:-2.0)
            r13 = 0
            r14 = -1081291571(0xffffffffbf8ccccd, float:-1.1)
            r15 = -1083808154(0xffffffffbf666666, float:-0.9)
            r16 = -1073741824(0xffffffffc0000000, float:-2.0)
            r12.curveToRelative(r13, r14, r15, r16, r17, r18)
            r12.close()
            r4 = 1095761920(0x41500000, float:13.0)
            r12.moveTo(r4, r6)
            r6 = -1073741824(0xffffffffc0000000, float:-2.0)
            r12.horizontalLineToRelative(r6)
            r12.verticalLineToRelative(r6)
            r12.horizontalLineToRelative(r2)
            r12.verticalLineToRelative(r2)
            r12.close()
            r7 = 1092616192(0x41200000, float:10.0)
            r12.moveTo(r4, r7)
            r12.horizontalLineToRelative(r6)
            r4 = 1093664768(0x41300000, float:11.0)
            r6 = 1086324736(0x40c00000, float:6.0)
            r12.lineTo(r4, r6)
            r12.horizontalLineToRelative(r2)
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
            r14 = 0
            r15 = 0
            androidx.compose.ui.graphics.vector.ImageVector$Builder r0 = androidx.compose.ui.graphics.vector.ImageVector.Builder.m5069addPathoIyEayM$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            androidx.compose.ui.graphics.vector.ImageVector r0 = r0.build()
            androidx.compose.material.icons.filled.SmsFailedKt._smsFailed = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.filled.SmsFailedKt.getSmsFailed(androidx.compose.material.icons.Icons$Filled):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
