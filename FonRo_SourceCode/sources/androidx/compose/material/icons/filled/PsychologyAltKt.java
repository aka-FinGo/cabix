package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PsychologyAlt.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_psychologyAlt", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PsychologyAlt", "Landroidx/compose/material/icons/Icons$Filled;", "getPsychologyAlt", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PsychologyAltKt {
    private static ImageVector _psychologyAlt;

    public static final ImageVector getPsychologyAlt(Icons.Filled filled) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _psychologyAlt;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.PsychologyAlt", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(19.94f, 9.06f);
        pathBuilder.curveTo(19.5f, 5.73f, 16.57f, 3.0f, 13.0f, 3.0f);
        pathBuilder.curveTo(9.47f, 3.0f, 6.57f, 5.61f, 6.08f, 9.0f);
        pathBuilder.lineToRelative(-1.93f, 3.48f);
        pathBuilder.curveTo(3.74f, 13.14f, 4.22f, 14.0f, 5.0f, 14.0f);
        pathBuilder.horizontalLineToRelative(1.0f);
        pathBuilder.lineToRelative(0.0f, 2.0f);
        pathBuilder.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        pathBuilder.horizontalLineToRelative(1.0f);
        pathBuilder.verticalLineToRelative(3.0f);
        pathBuilder.horizontalLineToRelative(7.0f);
        pathBuilder.lineToRelative(0.0f, -4.68f);
        pathBuilder.curveTo(18.62f, 15.07f, 20.35f, 12.24f, 19.94f, 9.06f);
        pathBuilder.close();
        pathBuilder.moveTo(12.5f, 14.0f);
        pathBuilder.curveToRelative(-0.41f, 0.0f, -0.74f, -0.33f, -0.74f, -0.74f);
        pathBuilder.curveToRelative(0.0f, -0.41f, 0.33f, -0.73f, 0.74f, -0.73f);
        pathBuilder.curveToRelative(0.41f, 0.0f, 0.73f, 0.32f, 0.73f, 0.73f);
        pathBuilder.curveTo(13.23f, 13.67f, 12.92f, 14.0f, 12.5f, 14.0f);
        pathBuilder.close();
        pathBuilder.moveTo(14.26f, 9.68f);
        pathBuilder.curveToRelative(-0.44f, 0.65f, -0.86f, 0.85f, -1.09f, 1.27f);
        pathBuilder.curveToRelative(-0.09f, 0.17f, -0.13f, 0.28f, -0.13f, 0.82f);
        pathBuilder.horizontalLineToRelative(-1.06f);
        pathBuilder.curveToRelative(0.0f, -0.29f, -0.04f, -0.75f, 0.18f, -1.16f);
        pathBuilder.curveToRelative(0.28f, -0.51f, 0.83f, -0.81f, 1.14f, -1.26f);
        pathBuilder.curveToRelative(0.33f, -0.47f, 0.15f, -1.36f, -0.8f, -1.36f);
        pathBuilder.curveToRelative(-0.62f, 0.0f, -0.92f, 0.47f, -1.05f, 0.86f);
        pathBuilder.lineToRelative(-0.96f, -0.4f);
        pathBuilder.curveTo(10.76f, 7.67f, 11.46f, 7.0f, 12.5f, 7.0f);
        pathBuilder.curveToRelative(0.86f, 0.0f, 1.45f, 0.39f, 1.75f, 0.88f);
        pathBuilder.curveTo(14.51f, 8.31f, 14.66f, 9.1f, 14.26f, 9.68f);
        pathBuilder.close();
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _psychologyAlt = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
