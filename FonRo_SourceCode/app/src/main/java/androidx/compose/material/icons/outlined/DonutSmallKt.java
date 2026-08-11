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

/* compiled from: DonutSmall.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_donutSmall", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DonutSmall", "Landroidx/compose/material/icons/Icons$Outlined;", "getDonutSmall", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DonutSmallKt {
    private static ImageVector _donutSmall;

    public static final ImageVector getDonutSmall(Icons.Outlined outlined) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _donutSmall;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.DonutSmall", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(14.82f, 11.0f);
        pathBuilder.horizontalLineToRelative(7.13f);
        pathBuilder.curveToRelative(-0.47f, -4.72f, -4.23f, -8.48f, -8.95f, -8.95f);
        pathBuilder.verticalLineToRelative(7.13f);
        pathBuilder.curveToRelative(0.85f, 0.31f, 1.51f, 0.97f, 1.82f, 1.82f);
        pathBuilder.close();
        pathBuilder.moveTo(15.0f, 4.58f);
        pathBuilder.curveTo(17.0f, 5.4f, 18.6f, 7.0f, 19.42f, 9.0f);
        pathBuilder.horizontalLineToRelative(-3.43f);
        pathBuilder.curveToRelative(-0.28f, -0.37f, -0.62f, -0.71f, -0.99f, -0.99f);
        pathBuilder.lineTo(15.0f, 4.58f);
        pathBuilder.close();
        pathBuilder.moveTo(2.0f, 12.0f);
        pathBuilder.curveToRelative(0.0f, 5.19f, 3.95f, 9.45f, 9.0f, 9.95f);
        pathBuilder.verticalLineToRelative(-7.13f);
        pathBuilder.curveTo(9.84f, 14.4f, 9.0f, 13.3f, 9.0f, 12.0f);
        pathBuilder.curveToRelative(0.0f, -1.3f, 0.84f, -2.4f, 2.0f, -2.82f);
        pathBuilder.lineTo(11.0f, 2.05f);
        pathBuilder.curveToRelative(-5.05f, 0.5f, -9.0f, 4.76f, -9.0f, 9.95f);
        pathBuilder.close();
        pathBuilder.moveTo(9.0f, 4.58f);
        pathBuilder.verticalLineToRelative(3.44f);
        pathBuilder.curveToRelative(-1.23f, 0.92f, -2.0f, 2.39f, -2.0f, 3.98f);
        pathBuilder.curveToRelative(0.0f, 1.59f, 0.77f, 3.06f, 2.0f, 3.99f);
        pathBuilder.verticalLineToRelative(3.44f);
        pathBuilder.curveTo(6.04f, 18.24f, 4.0f, 15.35f, 4.0f, 12.0f);
        pathBuilder.curveToRelative(0.0f, -3.35f, 2.04f, -6.24f, 5.0f, -7.42f);
        pathBuilder.close();
        pathBuilder.moveTo(13.0f, 14.82f);
        pathBuilder.verticalLineToRelative(7.13f);
        pathBuilder.curveToRelative(4.72f, -0.47f, 8.48f, -4.23f, 8.95f, -8.95f);
        pathBuilder.horizontalLineToRelative(-7.13f);
        pathBuilder.curveToRelative(-0.31f, 0.85f, -0.97f, 1.51f, -1.82f, 1.82f);
        pathBuilder.close();
        pathBuilder.moveTo(15.0f, 15.99f);
        pathBuilder.curveToRelative(0.37f, -0.28f, 0.71f, -0.61f, 0.99f, -0.99f);
        pathBuilder.horizontalLineToRelative(3.43f);
        pathBuilder.curveTo(18.6f, 17.0f, 17.0f, 18.6f, 15.0f, 19.42f);
        pathBuilder.verticalLineToRelative(-3.43f);
        pathBuilder.close();
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _donutSmall = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
