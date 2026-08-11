package androidx.compose.material.icons.outlined;

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

/* compiled from: ChangeCircle.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_changeCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ChangeCircle", "Landroidx/compose/material/icons/Icons$Outlined;", "getChangeCircle", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ChangeCircleKt {
    private static ImageVector _changeCircle;

    public static final ImageVector getChangeCircle(Icons.Outlined outlined) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _changeCircle;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.ChangeCircle", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(12.0f, 2.0f);
        pathBuilder.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        pathBuilder.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
        pathBuilder.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
        pathBuilder.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
        pathBuilder.close();
        pathBuilder.moveTo(12.0f, 20.0f);
        pathBuilder.curveToRelative(-4.41f, 0.0f, -8.0f, -3.59f, -8.0f, -8.0f);
        pathBuilder.reflectiveCurveToRelative(3.59f, -8.0f, 8.0f, -8.0f);
        pathBuilder.reflectiveCurveToRelative(8.0f, 3.59f, 8.0f, 8.0f);
        pathBuilder.reflectiveCurveTo(16.41f, 20.0f, 12.0f, 20.0f);
        pathBuilder.close();
        pathBuilder.moveTo(16.17f, 14.76f);
        pathBuilder.lineToRelative(-1.1f, -1.1f);
        pathBuilder.curveToRelative(0.71f, -1.33f, 0.53f, -3.01f, -0.59f, -4.13f);
        pathBuilder.curveTo(13.79f, 8.84f, 12.9f, 8.5f, 12.0f, 8.5f);
        pathBuilder.curveToRelative(-0.03f, 0.0f, -0.06f, 0.01f, -0.09f, 0.01f);
        pathBuilder.lineTo(13.0f, 9.6f);
        pathBuilder.lineToRelative(-1.06f, 1.06f);
        pathBuilder.lineTo(9.11f, 7.83f);
        pathBuilder.lineTo(11.94f, 5.0f);
        pathBuilder.lineTo(13.0f, 6.06f);
        pathBuilder.lineToRelative(-0.96f, 0.96f);
        pathBuilder.curveToRelative(1.27f, 0.01f, 2.53f, 0.48f, 3.5f, 1.44f);
        pathBuilder.curveTo(17.24f, 10.17f, 17.45f, 12.82f, 16.17f, 14.76f);
        pathBuilder.close();
        pathBuilder.moveTo(14.89f, 16.17f);
        pathBuilder.lineTo(12.06f, 19.0f);
        pathBuilder.lineTo(11.0f, 17.94f);
        pathBuilder.lineToRelative(0.95f, -0.95f);
        pathBuilder.curveToRelative(-1.26f, -0.01f, -2.52f, -0.5f, -3.48f, -1.46f);
        pathBuilder.curveToRelative(-1.71f, -1.71f, -1.92f, -4.35f, -0.64f, -6.29f);
        pathBuilder.lineToRelative(1.1f, 1.1f);
        pathBuilder.curveToRelative(-0.71f, 1.33f, -0.53f, 3.01f, 0.59f, 4.13f);
        pathBuilder.curveToRelative(0.7f, 0.7f, 1.63f, 1.04f, 2.56f, 1.01f);
        pathBuilder.lineTo(11.0f, 14.4f);
        pathBuilder.lineToRelative(1.06f, -1.06f);
        pathBuilder.lineTo(14.89f, 16.17f);
        pathBuilder.close();
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _changeCircle = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
