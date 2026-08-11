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

/* compiled from: Paragliding.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_paragliding", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Paragliding", "Landroidx/compose/material/icons/Icons$Filled;", "getParagliding", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ParaglidingKt {
    private static ImageVector _paragliding;

    public static final ImageVector getParagliding(Icons.Filled filled) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _paragliding;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Paragliding", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(12.0f, 17.0f);
        pathBuilder.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
        pathBuilder.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
        pathBuilder.reflectiveCurveToRelative(2.0f, 0.9f, 2.0f, 2.0f);
        pathBuilder.reflectiveCurveTo(13.1f, 17.0f, 12.0f, 17.0f);
        pathBuilder.close();
        pathBuilder.moveTo(8.52f, 17.94f);
        pathBuilder.curveTo(8.04f, 17.55f, 7.0f, 16.76f, 7.0f, 14.0f);
        pathBuilder.horizontalLineTo(5.0f);
        pathBuilder.curveToRelative(0.0f, 2.7f, 0.93f, 4.41f, 2.3f, 5.5f);
        pathBuilder.curveToRelative(0.5f, 0.4f, 1.1f, 0.7f, 1.7f, 0.9f);
        pathBuilder.lineTo(9.0f, 24.0f);
        pathBuilder.horizontalLineToRelative(6.0f);
        pathBuilder.verticalLineToRelative(-3.6f);
        pathBuilder.curveToRelative(0.6f, -0.2f, 1.2f, -0.5f, 1.7f, -0.9f);
        pathBuilder.curveToRelative(1.37f, -1.09f, 2.3f, -2.8f, 2.3f, -5.5f);
        pathBuilder.horizontalLineToRelative(-2.0f);
        pathBuilder.curveToRelative(0.0f, 2.76f, -1.04f, 3.55f, -1.52f, 3.94f);
        pathBuilder.curveTo(14.68f, 18.54f, 14.0f, 19.0f, 12.0f, 19.0f);
        pathBuilder.reflectiveCurveTo(9.32f, 18.54f, 8.52f, 17.94f);
        pathBuilder.close();
        pathBuilder.moveTo(12.0f, 0.0f);
        pathBuilder.curveTo(5.92f, 0.0f, 1.0f, 1.9f, 1.0f, 4.25f);
        pathBuilder.verticalLineToRelative(3.49f);
        pathBuilder.curveTo(1.0f, 8.55f, 1.88f, 9.0f, 2.56f, 8.57f);
        pathBuilder.curveTo(2.7f, 8.48f, 2.84f, 8.39f, 3.0f, 8.31f);
        pathBuilder.lineTo(5.0f, 13.0f);
        pathBuilder.horizontalLineToRelative(2.0f);
        pathBuilder.lineToRelative(1.5f, -6.28f);
        pathBuilder.curveTo(9.6f, 6.58f, 10.78f, 6.5f, 12.0f, 6.5f);
        pathBuilder.reflectiveCurveToRelative(2.4f, 0.08f, 3.5f, 0.22f);
        pathBuilder.lineTo(17.0f, 13.0f);
        pathBuilder.horizontalLineToRelative(2.0f);
        pathBuilder.lineToRelative(2.0f, -4.69f);
        pathBuilder.curveToRelative(0.16f, 0.09f, 0.3f, 0.17f, 0.44f, 0.26f);
        pathBuilder.curveTo(22.12f, 9.0f, 23.0f, 8.55f, 23.0f, 7.74f);
        pathBuilder.verticalLineTo(4.25f);
        pathBuilder.curveTo(23.0f, 1.9f, 18.08f, 0.0f, 12.0f, 0.0f);
        pathBuilder.close();
        pathBuilder.moveTo(5.88f, 11.24f);
        pathBuilder.lineTo(4.37f, 7.69f);
        pathBuilder.curveToRelative(0.75f, -0.28f, 1.6f, -0.52f, 2.53f, -0.71f);
        pathBuilder.lineTo(5.88f, 11.24f);
        pathBuilder.close();
        pathBuilder.moveTo(18.12f, 11.24f);
        pathBuilder.lineTo(17.1f, 6.98f);
        pathBuilder.curveToRelative(0.93f, 0.19f, 1.78f, 0.43f, 2.53f, 0.71f);
        pathBuilder.lineTo(18.12f, 11.24f);
        pathBuilder.close();
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _paragliding = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
