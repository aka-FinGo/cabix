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

/* compiled from: BackHand.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_backHand", "Landroidx/compose/ui/graphics/vector/ImageVector;", "BackHand", "Landroidx/compose/material/icons/Icons$Outlined;", "getBackHand", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BackHandKt {
    private static ImageVector _backHand;

    public static final ImageVector getBackHand(Icons.Outlined outlined) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _backHand;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.BackHand", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(21.0f, 7.0f);
        pathBuilder.curveToRelative(0.0f, -1.38f, -1.12f, -2.5f, -2.5f, -2.5f);
        pathBuilder.curveToRelative(-0.17f, 0.0f, -0.34f, 0.02f, -0.5f, 0.05f);
        pathBuilder.verticalLineTo(4.0f);
        pathBuilder.curveToRelative(0.0f, -1.38f, -1.12f, -2.5f, -2.5f, -2.5f);
        pathBuilder.curveToRelative(-0.23f, 0.0f, -0.46f, 0.03f, -0.67f, 0.09f);
        pathBuilder.curveTo(14.46f, 0.66f, 13.56f, 0.0f, 12.5f, 0.0f);
        pathBuilder.curveToRelative(-1.23f, 0.0f, -2.25f, 0.89f, -2.46f, 2.06f);
        pathBuilder.curveTo(9.87f, 2.02f, 9.69f, 2.0f, 9.5f, 2.0f);
        pathBuilder.curveTo(8.12f, 2.0f, 7.0f, 3.12f, 7.0f, 4.5f);
        pathBuilder.verticalLineToRelative(5.89f);
        pathBuilder.curveToRelative(-0.34f, -0.31f, -0.76f, -0.54f, -1.22f, -0.66f);
        pathBuilder.lineTo(5.01f, 9.52f);
        pathBuilder.curveToRelative(-0.83f, -0.23f, -1.7f, 0.09f, -2.19f, 0.83f);
        pathBuilder.curveToRelative(-0.38f, 0.57f, -0.4f, 1.31f, -0.15f, 1.95f);
        pathBuilder.lineToRelative(2.56f, 6.43f);
        pathBuilder.curveTo(6.49f, 21.91f, 9.57f, 24.0f, 13.0f, 24.0f);
        pathBuilder.horizontalLineToRelative(0.0f);
        pathBuilder.curveToRelative(4.42f, 0.0f, 8.0f, -3.58f, 8.0f, -8.0f);
        pathBuilder.verticalLineTo(7.0f);
        pathBuilder.close();
        pathBuilder.moveTo(19.0f, 16.0f);
        pathBuilder.curveToRelative(0.0f, 3.31f, -2.69f, 6.0f, -6.0f, 6.0f);
        pathBuilder.horizontalLineToRelative(0.0f);
        pathBuilder.curveToRelative(-2.61f, 0.0f, -4.95f, -1.59f, -5.91f, -4.01f);
        pathBuilder.lineToRelative(-2.6f, -6.54f);
        pathBuilder.lineToRelative(0.53f, 0.14f);
        pathBuilder.curveToRelative(0.46f, 0.12f, 0.83f, 0.46f, 1.0f, 0.9f);
        pathBuilder.lineTo(7.0f, 15.0f);
        pathBuilder.horizontalLineToRelative(2.0f);
        pathBuilder.verticalLineTo(4.5f);
        pathBuilder.curveTo(9.0f, 4.22f, 9.22f, 4.0f, 9.5f, 4.0f);
        pathBuilder.reflectiveCurveTo(10.0f, 4.22f, 10.0f, 4.5f);
        pathBuilder.verticalLineTo(12.0f);
        pathBuilder.horizontalLineToRelative(2.0f);
        pathBuilder.verticalLineTo(2.5f);
        pathBuilder.curveTo(12.0f, 2.22f, 12.22f, 2.0f, 12.5f, 2.0f);
        pathBuilder.reflectiveCurveTo(13.0f, 2.22f, 13.0f, 2.5f);
        pathBuilder.verticalLineTo(12.0f);
        pathBuilder.horizontalLineToRelative(2.0f);
        pathBuilder.verticalLineTo(4.0f);
        pathBuilder.curveToRelative(0.0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        pathBuilder.reflectiveCurveTo(16.0f, 3.72f, 16.0f, 4.0f);
        pathBuilder.verticalLineToRelative(8.0f);
        pathBuilder.horizontalLineToRelative(2.0f);
        pathBuilder.verticalLineTo(7.0f);
        pathBuilder.curveToRelative(0.0f, -0.28f, 0.22f, -0.5f, 0.5f, -0.5f);
        pathBuilder.reflectiveCurveTo(19.0f, 6.72f, 19.0f, 7.0f);
        pathBuilder.lineTo(19.0f, 16.0f);
        pathBuilder.close();
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _backHand = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
