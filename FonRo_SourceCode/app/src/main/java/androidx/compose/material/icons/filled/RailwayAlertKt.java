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

/* compiled from: RailwayAlert.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_railwayAlert", "Landroidx/compose/ui/graphics/vector/ImageVector;", "RailwayAlert", "Landroidx/compose/material/icons/Icons$Filled;", "getRailwayAlert", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RailwayAlertKt {
    private static ImageVector _railwayAlert;

    public static final ImageVector getRailwayAlert(Icons.Filled filled) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _railwayAlert;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.RailwayAlert", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(23.0f, 8.0f);
        pathBuilder.arcToRelative(7.0f, 7.0f, 0.0f, false, false, -11.95f, -4.95f);
        pathBuilder.arcTo(33.8f, 33.8f, 0.0f, false, false, 9.0f, 3.0f);
        pathBuilder.curveToRelative(-4.42f, 0.0f, -8.0f, 0.5f, -8.0f, 4.0f);
        pathBuilder.verticalLineToRelative(10.5f);
        pathBuilder.arcTo(3.5f, 3.5f, 0.0f, false, false, 4.5f, 21.0f);
        pathBuilder.lineTo(3.0f, 22.5f);
        pathBuilder.verticalLineToRelative(0.5f);
        pathBuilder.horizontalLineToRelative(12.0f);
        pathBuilder.verticalLineToRelative(-0.5f);
        pathBuilder.lineTo(13.5f, 21.0f);
        pathBuilder.arcToRelative(3.5f, 3.5f, 0.0f, false, false, 3.5f, -3.5f);
        pathBuilder.verticalLineToRelative(-2.58f);
        pathBuilder.arcTo(7.0f, 7.0f, 0.0f, false, false, 23.0f, 8.0f);
        pathBuilder.close();
        pathBuilder.moveTo(3.0f, 12.0f);
        pathBuilder.lineTo(3.0f, 7.0f);
        pathBuilder.horizontalLineToRelative(6.08f);
        pathBuilder.arcToRelative(6.96f, 6.96f, 0.0f, false, false, 1.18f, 5.0f);
        pathBuilder.lineTo(3.0f, 12.0f);
        pathBuilder.close();
        pathBuilder.moveTo(9.0f, 19.0f);
        pathBuilder.curveToRelative(-1.1f, 0.0f, -2.0f, -0.9f, -2.0f, -2.0f);
        pathBuilder.reflectiveCurveToRelative(0.9f, -2.0f, 2.0f, -2.0f);
        pathBuilder.reflectiveCurveToRelative(2.0f, 0.9f, 2.0f, 2.0f);
        pathBuilder.reflectiveCurveToRelative(-0.9f, 2.0f, -2.0f, 2.0f);
        pathBuilder.close();
        pathBuilder.moveTo(16.71f, 12.94f);
        pathBuilder.lineToRelative(-0.2f, 0.03f);
        pathBuilder.lineTo(16.0f, 13.0f);
        pathBuilder.lineToRelative(-0.47f, -0.02f);
        pathBuilder.lineToRelative(-0.16f, -0.02f);
        pathBuilder.lineToRelative(-0.29f, -0.04f);
        pathBuilder.lineToRelative(-0.2f, -0.04f);
        pathBuilder.lineToRelative(-0.22f, -0.06f);
        pathBuilder.arcToRelative(1.55f, 1.55f, 0.0f, false, true, -0.23f, -0.07f);
        pathBuilder.lineToRelative(-0.13f, -0.05f);
        pathBuilder.arcTo(4.99f, 4.99f, 0.0f, false, true, 11.1f, 7.0f);
        pathBuilder.curveToRelative(0.04f, -0.19f, 0.09f, -0.37f, 0.15f, -0.54f);
        pathBuilder.lineToRelative(0.05f, -0.14f);
        pathBuilder.lineToRelative(0.15f, -0.38f);
        pathBuilder.lineToRelative(0.07f, -0.15f);
        pathBuilder.lineToRelative(0.2f, -0.36f);
        pathBuilder.lineToRelative(0.07f, -0.12f);
        pathBuilder.lineToRelative(0.3f, -0.42f);
        pathBuilder.lineToRelative(0.02f, -0.02f);
        pathBuilder.curveToRelative(0.24f, -0.3f, 0.52f, -0.57f, 0.82f, -0.81f);
        pathBuilder.lineToRelative(0.01f, -0.01f);
        pathBuilder.lineToRelative(0.46f, -0.32f);
        pathBuilder.lineToRelative(0.03f, -0.02f);
        pathBuilder.arcTo(5.25f, 5.25f, 0.0f, false, true, 16.0f, 3.0f);
        pathBuilder.arcToRelative(5.0f, 5.0f, 0.0f, false, true, 0.71f, 9.94f);
        pathBuilder.close();
        pathBuilder.moveTo(15.0f, 4.0f);
        pathBuilder.horizontalLineToRelative(2.0f);
        pathBuilder.verticalLineToRelative(5.0f);
        pathBuilder.horizontalLineToRelative(-2.0f);
        pathBuilder.close();
        pathBuilder.moveTo(15.0f, 10.0f);
        pathBuilder.horizontalLineToRelative(2.0f);
        pathBuilder.verticalLineToRelative(2.0f);
        pathBuilder.horizontalLineToRelative(-2.0f);
        pathBuilder.close();
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _railwayAlert = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
