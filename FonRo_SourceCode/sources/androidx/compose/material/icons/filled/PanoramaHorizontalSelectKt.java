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

/* compiled from: PanoramaHorizontalSelect.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_panoramaHorizontalSelect", "Landroidx/compose/ui/graphics/vector/ImageVector;", "PanoramaHorizontalSelect", "Landroidx/compose/material/icons/Icons$Filled;", "getPanoramaHorizontalSelect", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PanoramaHorizontalSelectKt {
    private static ImageVector _panoramaHorizontalSelect;

    public static final ImageVector getPanoramaHorizontalSelect(Icons.Filled filled) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _panoramaHorizontalSelect;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.PanoramaHorizontalSelect", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(21.43f, 4.0f);
        pathBuilder.curveToRelative(-0.1f, 0.0f, -0.2f, 0.02f, -0.31f, 0.06f);
        pathBuilder.curveTo(18.18f, 5.16f, 15.09f, 5.7f, 12.0f, 5.7f);
        pathBuilder.reflectiveCurveToRelative(-6.18f, -0.55f, -9.12f, -1.64f);
        pathBuilder.curveTo(2.77f, 4.02f, 2.66f, 4.0f, 2.57f, 4.0f);
        pathBuilder.curveToRelative(-0.34f, 0.0f, -0.57f, 0.23f, -0.57f, 0.63f);
        pathBuilder.verticalLineToRelative(14.75f);
        pathBuilder.curveToRelative(0.0f, 0.39f, 0.23f, 0.62f, 0.57f, 0.62f);
        pathBuilder.curveToRelative(0.1f, 0.0f, 0.2f, -0.02f, 0.31f, -0.06f);
        pathBuilder.curveToRelative(2.94f, -1.1f, 6.03f, -1.64f, 9.12f, -1.64f);
        pathBuilder.reflectiveCurveToRelative(6.18f, 0.55f, 9.12f, 1.64f);
        pathBuilder.curveToRelative(0.11f, 0.04f, 0.21f, 0.06f, 0.31f, 0.06f);
        pathBuilder.curveToRelative(0.33f, 0.0f, 0.57f, -0.23f, 0.57f, -0.63f);
        pathBuilder.verticalLineTo(4.63f);
        pathBuilder.curveToRelative(0.0f, -0.4f, -0.24f, -0.63f, -0.57f, -0.63f);
        pathBuilder.close();
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _panoramaHorizontalSelect = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
