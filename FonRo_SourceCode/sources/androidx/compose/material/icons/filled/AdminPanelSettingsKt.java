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

/* compiled from: AdminPanelSettings.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_adminPanelSettings", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AdminPanelSettings", "Landroidx/compose/material/icons/Icons$Filled;", "getAdminPanelSettings", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AdminPanelSettingsKt {
    private static ImageVector _adminPanelSettings;

    public static final ImageVector getAdminPanelSettings(Icons.Filled filled) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _adminPanelSettings;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.AdminPanelSettings", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(17.0f, 11.0f);
        pathBuilder.curveToRelative(0.34f, 0.0f, 0.67f, 0.04f, 1.0f, 0.09f);
        pathBuilder.verticalLineTo(6.27f);
        pathBuilder.lineTo(10.5f, 3.0f);
        pathBuilder.lineTo(3.0f, 6.27f);
        pathBuilder.verticalLineToRelative(4.91f);
        pathBuilder.curveToRelative(0.0f, 4.54f, 3.2f, 8.79f, 7.5f, 9.82f);
        pathBuilder.curveToRelative(0.55f, -0.13f, 1.08f, -0.32f, 1.6f, -0.55f);
        pathBuilder.curveTo(11.41f, 19.47f, 11.0f, 18.28f, 11.0f, 17.0f);
        pathBuilder.curveTo(11.0f, 13.69f, 13.69f, 11.0f, 17.0f, 11.0f);
        pathBuilder.close();
        builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw2 = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk82 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(17.0f, 13.0f);
        pathBuilder2.curveToRelative(-2.21f, 0.0f, -4.0f, 1.79f, -4.0f, 4.0f);
        pathBuilder2.curveToRelative(0.0f, 2.21f, 1.79f, 4.0f, 4.0f, 4.0f);
        pathBuilder2.reflectiveCurveToRelative(4.0f, -1.79f, 4.0f, -4.0f);
        pathBuilder2.curveTo(21.0f, 14.79f, 19.21f, 13.0f, 17.0f, 13.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(17.0f, 14.38f);
        pathBuilder2.curveToRelative(0.62f, 0.0f, 1.12f, 0.51f, 1.12f, 1.12f);
        pathBuilder2.reflectiveCurveToRelative(-0.51f, 1.12f, -1.12f, 1.12f);
        pathBuilder2.reflectiveCurveToRelative(-1.12f, -0.51f, -1.12f, -1.12f);
        pathBuilder2.reflectiveCurveTo(16.38f, 14.38f, 17.0f, 14.38f);
        pathBuilder2.close();
        pathBuilder2.moveTo(17.0f, 19.75f);
        pathBuilder2.curveToRelative(-0.93f, 0.0f, -1.74f, -0.46f, -2.24f, -1.17f);
        pathBuilder2.curveToRelative(0.05f, -0.72f, 1.51f, -1.08f, 2.24f, -1.08f);
        pathBuilder2.reflectiveCurveToRelative(2.19f, 0.36f, 2.24f, 1.08f);
        pathBuilder2.curveTo(18.74f, 19.29f, 17.93f, 19.75f, 17.0f, 19.75f);
        pathBuilder2.close();
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk82, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _adminPanelSettings = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
