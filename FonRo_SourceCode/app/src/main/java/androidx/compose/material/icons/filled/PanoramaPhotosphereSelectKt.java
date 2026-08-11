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

/* compiled from: PanoramaPhotosphereSelect.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_panoramaPhotosphereSelect", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PanoramaPhotosphereSelect", "Landroidx/compose/material/icons/Icons$Filled;", "getPanoramaPhotosphereSelect", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PanoramaPhotosphereSelectKt {
    private static ImageVector _panoramaPhotosphereSelect;

    public static final ImageVector getPanoramaPhotosphereSelect(Icons.Filled filled) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _panoramaPhotosphereSelect;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.PanoramaPhotosphereSelect", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(22.49f, 8.51f);
        pathBuilder.curveToRelative(-0.47f, -0.23f, -0.93f, -0.44f, -1.4f, -0.64f);
        pathBuilder.curveTo(19.52f, 4.41f, 16.05f, 2.0f, 12.0f, 2.0f);
        pathBuilder.reflectiveCurveTo(4.47f, 4.41f, 2.9f, 7.88f);
        pathBuilder.curveToRelative(-0.47f, 0.2f, -0.93f, 0.41f, -1.4f, 0.63f);
        pathBuilder.curveToRelative(-0.31f, 0.15f, -0.5f, 0.48f, -0.5f, 0.83f);
        pathBuilder.verticalLineToRelative(5.32f);
        pathBuilder.curveToRelative(0.0f, 0.35f, 0.19f, 0.68f, 0.51f, 0.83f);
        pathBuilder.curveToRelative(0.47f, 0.23f, 0.93f, 0.44f, 1.39f, 0.64f);
        pathBuilder.curveToRelative(3.55f, 7.83f, 14.65f, 7.82f, 18.2f, 0.0f);
        pathBuilder.curveToRelative(0.47f, -0.2f, 0.93f, -0.41f, 1.39f, -0.63f);
        pathBuilder.curveToRelative(0.31f, -0.17f, 0.51f, -0.49f, 0.51f, -0.84f);
        pathBuilder.verticalLineTo(9.34f);
        pathBuilder.curveToRelative(0.0f, -0.35f, -0.19f, -0.68f, -0.51f, -0.83f);
        pathBuilder.close();
        pathBuilder.moveTo(12.0f, 3.8f);
        pathBuilder.curveToRelative(2.6f, 0.0f, 4.91f, 1.23f, 6.41f, 3.12f);
        pathBuilder.curveToRelative(-4.1f, -1.19f, -8.48f, -1.26f, -12.83f, 0.01f);
        pathBuilder.curveTo(7.08f, 5.03f, 9.4f, 3.8f, 12.0f, 3.8f);
        pathBuilder.close();
        pathBuilder.moveTo(5.6f, 17.08f);
        pathBuilder.curveToRelative(4.19f, 1.22f, 8.57f, 1.23f, 12.82f, -0.01f);
        pathBuilder.curveToRelative(-1.54f, 1.97f, -3.9f, 3.13f, -6.41f, 3.13f);
        pathBuilder.curveToRelative(-2.5f, 0.0f, -4.87f, -1.15f, -6.41f, -3.12f);
        pathBuilder.close();
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _panoramaPhotosphereSelect = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
