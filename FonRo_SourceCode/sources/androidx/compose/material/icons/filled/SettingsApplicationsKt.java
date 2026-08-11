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

/* compiled from: SettingsApplications.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_settingsApplications", "Landroidx/compose/ui/graphics/vector/ImageVector;", "SettingsApplications", "Landroidx/compose/material/icons/Icons$Filled;", "getSettingsApplications", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SettingsApplicationsKt {
    private static ImageVector _settingsApplications;

    public static final ImageVector getSettingsApplications(Icons.Filled filled) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _settingsApplications;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.SettingsApplications", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(12.0f, 10.0f);
        pathBuilder.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        pathBuilder.reflectiveCurveToRelative(0.9f, 2.0f, 2.0f, 2.0f);
        pathBuilder.reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f);
        pathBuilder.reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f);
        pathBuilder.close();
        pathBuilder.moveTo(19.0f, 3.0f);
        pathBuilder.lineTo(5.0f, 3.0f);
        pathBuilder.curveToRelative(-1.11f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        pathBuilder.verticalLineToRelative(14.0f);
        pathBuilder.curveToRelative(0.0f, 1.1f, 0.89f, 2.0f, 2.0f, 2.0f);
        pathBuilder.horizontalLineToRelative(14.0f);
        pathBuilder.curveToRelative(1.11f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        pathBuilder.lineTo(21.0f, 5.0f);
        pathBuilder.curveToRelative(0.0f, -1.1f, -0.89f, -2.0f, -2.0f, -2.0f);
        pathBuilder.close();
        pathBuilder.moveTo(17.25f, 12.0f);
        pathBuilder.curveToRelative(0.0f, 0.23f, -0.02f, 0.46f, -0.05f, 0.68f);
        pathBuilder.lineToRelative(1.48f, 1.16f);
        pathBuilder.curveToRelative(0.13f, 0.11f, 0.17f, 0.3f, 0.08f, 0.45f);
        pathBuilder.lineToRelative(-1.4f, 2.42f);
        pathBuilder.curveToRelative(-0.09f, 0.15f, -0.27f, 0.21f, -0.43f, 0.15f);
        pathBuilder.lineToRelative(-1.74f, -0.7f);
        pathBuilder.curveToRelative(-0.36f, 0.28f, -0.76f, 0.51f, -1.18f, 0.69f);
        pathBuilder.lineToRelative(-0.26f, 1.85f);
        pathBuilder.curveToRelative(-0.03f, 0.17f, -0.18f, 0.3f, -0.35f, 0.3f);
        pathBuilder.horizontalLineToRelative(-2.8f);
        pathBuilder.curveToRelative(-0.17f, 0.0f, -0.32f, -0.13f, -0.35f, -0.29f);
        pathBuilder.lineToRelative(-0.26f, -1.85f);
        pathBuilder.curveToRelative(-0.43f, -0.18f, -0.82f, -0.41f, -1.18f, -0.69f);
        pathBuilder.lineToRelative(-1.74f, 0.7f);
        pathBuilder.curveToRelative(-0.16f, 0.06f, -0.34f, 0.0f, -0.43f, -0.15f);
        pathBuilder.lineToRelative(-1.4f, -2.42f);
        pathBuilder.curveToRelative(-0.09f, -0.15f, -0.05f, -0.34f, 0.08f, -0.45f);
        pathBuilder.lineToRelative(1.48f, -1.16f);
        pathBuilder.curveToRelative(-0.03f, -0.23f, -0.05f, -0.46f, -0.05f, -0.69f);
        pathBuilder.curveToRelative(0.0f, -0.23f, 0.02f, -0.46f, 0.05f, -0.68f);
        pathBuilder.lineToRelative(-1.48f, -1.16f);
        pathBuilder.curveToRelative(-0.13f, -0.11f, -0.17f, -0.3f, -0.08f, -0.45f);
        pathBuilder.lineToRelative(1.4f, -2.42f);
        pathBuilder.curveToRelative(0.09f, -0.15f, 0.27f, -0.21f, 0.43f, -0.15f);
        pathBuilder.lineToRelative(1.74f, 0.7f);
        pathBuilder.curveToRelative(0.36f, -0.28f, 0.76f, -0.51f, 1.18f, -0.69f);
        pathBuilder.lineToRelative(0.26f, -1.85f);
        pathBuilder.curveToRelative(0.03f, -0.17f, 0.18f, -0.3f, 0.35f, -0.3f);
        pathBuilder.horizontalLineToRelative(2.8f);
        pathBuilder.curveToRelative(0.17f, 0.0f, 0.32f, 0.13f, 0.35f, 0.29f);
        pathBuilder.lineToRelative(0.26f, 1.85f);
        pathBuilder.curveToRelative(0.43f, 0.18f, 0.82f, 0.41f, 1.18f, 0.69f);
        pathBuilder.lineToRelative(1.74f, -0.7f);
        pathBuilder.curveToRelative(0.16f, -0.06f, 0.34f, 0.0f, 0.43f, 0.15f);
        pathBuilder.lineToRelative(1.4f, 2.42f);
        pathBuilder.curveToRelative(0.09f, 0.15f, 0.05f, 0.34f, -0.08f, 0.45f);
        pathBuilder.lineToRelative(-1.48f, 1.16f);
        pathBuilder.curveToRelative(0.03f, 0.23f, 0.05f, 0.46f, 0.05f, 0.69f);
        pathBuilder.close();
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _settingsApplications = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
