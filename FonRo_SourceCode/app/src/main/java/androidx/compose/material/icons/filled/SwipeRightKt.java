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

/* compiled from: SwipeRight.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_swipeRight", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SwipeRight", "Landroidx/compose/material/icons/Icons$Filled;", "getSwipeRight", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SwipeRightKt {
    private static ImageVector _swipeRight;

    public static final ImageVector getSwipeRight(Icons.Filled filled) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _swipeRight;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.SwipeRight", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(19.98f, 16.82f);
        pathBuilder.lineToRelative(-0.63f, 4.46f);
        pathBuilder.curveTo(19.21f, 22.27f, 18.36f, 23.0f, 17.37f, 23.0f);
        pathBuilder.horizontalLineToRelative(-6.16f);
        pathBuilder.curveToRelative(-0.53f, 0.0f, -1.29f, -0.21f, -1.66f, -0.59f);
        pathBuilder.lineTo(5.0f, 17.62f);
        pathBuilder.lineToRelative(0.83f, -0.84f);
        pathBuilder.curveToRelative(0.24f, -0.24f, 0.58f, -0.35f, 0.92f, -0.28f);
        pathBuilder.lineTo(10.0f, 17.24f);
        pathBuilder.verticalLineTo(6.5f);
        pathBuilder.curveTo(10.0f, 5.67f, 10.67f, 5.0f, 11.5f, 5.0f);
        pathBuilder.reflectiveCurveTo(13.0f, 5.67f, 13.0f, 6.5f);
        pathBuilder.verticalLineToRelative(6.0f);
        pathBuilder.horizontalLineToRelative(0.91f);
        pathBuilder.curveToRelative(0.31f, 0.0f, 0.62f, 0.07f, 0.89f, 0.21f);
        pathBuilder.lineToRelative(4.09f, 2.04f);
        pathBuilder.curveTo(19.66f, 15.14f, 20.1f, 15.97f, 19.98f, 16.82f);
        pathBuilder.close();
        pathBuilder.moveTo(19.91f, 5.5f);
        pathBuilder.horizontalLineTo(17.0f);
        pathBuilder.verticalLineTo(7.0f);
        pathBuilder.horizontalLineToRelative(5.0f);
        pathBuilder.verticalLineTo(2.0f);
        pathBuilder.horizontalLineToRelative(-1.5f);
        pathBuilder.verticalLineToRelative(2.02f);
        pathBuilder.curveTo(18.18f, 2.13f, 15.22f, 1.0f, 12.0f, 1.0f);
        pathBuilder.curveTo(6.51f, 1.0f, 2.73f, 4.12f, 2.0f, 7.0f);
        pathBuilder.horizontalLineToRelative(1.57f);
        pathBuilder.curveTo(4.33f, 5.02f, 7.26f, 2.5f, 12.0f, 2.5f);
        pathBuilder.curveTo(15.03f, 2.5f, 17.79f, 3.64f, 19.91f, 5.5f);
        pathBuilder.close();
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _swipeRight = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
