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

/* compiled from: Motorcycle.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_motorcycle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Motorcycle", "Landroidx/compose/material/icons/Icons$Filled;", "getMotorcycle", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MotorcycleKt {
    private static ImageVector _motorcycle;

    public static final ImageVector getMotorcycle(Icons.Filled filled) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _motorcycle;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Motorcycle", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(17.5f, 10.0f);
        pathBuilder.curveToRelative(-0.03f, 0.0f, -0.05f, 0.01f, -0.08f, 0.01f);
        pathBuilder.lineTo(13.41f, 6.0f);
        pathBuilder.lineTo(9.0f, 6.0f);
        pathBuilder.verticalLineToRelative(2.0f);
        pathBuilder.horizontalLineToRelative(3.59f);
        pathBuilder.lineToRelative(2.0f, 2.0f);
        pathBuilder.horizontalLineToRelative(-8.1f);
        pathBuilder.curveTo(4.01f, 10.0f, 2.0f, 12.02f, 2.0f, 14.5f);
        pathBuilder.curveTo(2.0f, 16.99f, 4.01f, 19.0f, 6.5f, 19.0f);
        pathBuilder.curveToRelative(2.22f, 0.0f, 4.06f, -1.62f, 4.42f, -3.73f);
        pathBuilder.lineTo(13.04f, 14.0f);
        pathBuilder.curveToRelative(-0.02f, 0.17f, -0.04f, 0.33f, -0.04f, 0.5f);
        pathBuilder.curveToRelative(0.0f, 2.49f, 2.01f, 4.5f, 4.5f, 4.5f);
        pathBuilder.reflectiveCurveToRelative(4.5f, -2.01f, 4.5f, -4.5f);
        pathBuilder.reflectiveCurveToRelative(-2.01f, -4.5f, -4.5f, -4.5f);
        pathBuilder.close();
        pathBuilder.moveTo(8.84f, 15.26f);
        pathBuilder.curveTo(8.52f, 16.27f, 7.58f, 17.0f, 6.47f, 17.0f);
        pathBuilder.curveToRelative(-1.38f, 0.0f, -2.5f, -1.12f, -2.5f, -2.5f);
        pathBuilder.reflectiveCurveTo(5.09f, 12.0f, 6.47f, 12.0f);
        pathBuilder.curveToRelative(1.12f, 0.0f, 2.05f, 0.74f, 2.37f, 1.75f);
        pathBuilder.lineTo(6.0f, 13.75f);
        pathBuilder.verticalLineToRelative(1.5f);
        pathBuilder.lineToRelative(2.84f, 0.01f);
        pathBuilder.close();
        pathBuilder.moveTo(17.47f, 17.0f);
        pathBuilder.curveToRelative(-1.38f, 0.0f, -2.5f, -1.12f, -2.5f, -2.5f);
        pathBuilder.reflectiveCurveToRelative(1.12f, -2.5f, 2.5f, -2.5f);
        pathBuilder.reflectiveCurveToRelative(2.5f, 1.12f, 2.5f, 2.5f);
        pathBuilder.reflectiveCurveToRelative(-1.12f, 2.5f, -2.5f, 2.5f);
        pathBuilder.close();
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _motorcycle = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
