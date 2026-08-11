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

/* compiled from: ExtensionOff.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_extensionOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ExtensionOff", "Landroidx/compose/material/icons/Icons$Outlined;", "getExtensionOff", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ExtensionOffKt {
    private static ImageVector _extensionOff;

    public static final ImageVector getExtensionOff(Icons.Outlined outlined) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _extensionOff;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.ExtensionOff", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(1.39f, 4.22f);
        pathBuilder.lineToRelative(1.62f, 1.62f);
        pathBuilder.curveToRelative(0.0f, 0.05f, -0.01f, 0.1f, -0.01f, 0.16f);
        pathBuilder.verticalLineToRelative(3.8f);
        pathBuilder.curveTo(5.7f, 9.8f, 6.0f, 11.96f, 6.0f, 12.5f);
        pathBuilder.curveToRelative(0.0f, 0.54f, -0.29f, 2.7f, -3.0f, 2.7f);
        pathBuilder.verticalLineTo(19.0f);
        pathBuilder.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        pathBuilder.horizontalLineToRelative(3.8f);
        pathBuilder.curveToRelative(0.0f, -2.71f, 2.16f, -3.0f, 2.7f, -3.0f);
        pathBuilder.curveToRelative(0.54f, 0.0f, 2.7f, 0.29f, 2.7f, 3.0f);
        pathBuilder.horizontalLineTo(18.0f);
        pathBuilder.curveToRelative(0.06f, 0.0f, 0.11f, 0.0f, 0.16f, -0.01f);
        pathBuilder.lineToRelative(1.61f, 1.61f);
        pathBuilder.lineToRelative(1.41f, -1.41f);
        pathBuilder.lineTo(2.81f, 2.81f);
        pathBuilder.lineTo(1.39f, 4.22f);
        pathBuilder.close();
        pathBuilder.moveTo(11.5f, 16.0f);
        pathBuilder.curveToRelative(-1.5f, 0.0f, -3.57f, 0.83f, -4.37f, 3.0f);
        pathBuilder.horizontalLineTo(5.0f);
        pathBuilder.verticalLineToRelative(-2.13f);
        pathBuilder.curveToRelative(2.17f, -0.8f, 3.0f, -2.87f, 3.0f, -4.37f);
        pathBuilder.curveToRelative(0.0f, -0.69f, -0.18f, -1.5f, -0.58f, -2.25f);
        pathBuilder.lineToRelative(6.33f, 6.33f);
        pathBuilder.curveTo(13.0f, 16.18f, 12.19f, 16.0f, 11.5f, 16.0f);
        pathBuilder.close();
        pathBuilder.moveTo(8.83f, 6.0f);
        pathBuilder.lineToRelative(-2.0f, -2.0f);
        pathBuilder.horizontalLineTo(9.0f);
        pathBuilder.curveToRelative(0.0f, -1.38f, 1.12f, -2.5f, 2.5f, -2.5f);
        pathBuilder.reflectiveCurveTo(14.0f, 2.62f, 14.0f, 4.0f);
        pathBuilder.horizontalLineToRelative(4.0f);
        pathBuilder.curveToRelative(1.1f, 0.0f, 2.0f, 0.9f, 2.0f, 2.0f);
        pathBuilder.verticalLineToRelative(4.0f);
        pathBuilder.curveToRelative(1.38f, 0.0f, 2.5f, 1.12f, 2.5f, 2.5f);
        pathBuilder.reflectiveCurveTo(21.38f, 15.0f, 20.0f, 15.0f);
        pathBuilder.verticalLineToRelative(2.17f);
        pathBuilder.lineToRelative(-2.0f, -2.0f);
        pathBuilder.verticalLineTo(13.0f);
        pathBuilder.horizontalLineToRelative(2.0f);
        pathBuilder.curveToRelative(0.28f, 0.0f, 0.5f, -0.22f, 0.5f, -0.5f);
        pathBuilder.reflectiveCurveTo(20.28f, 12.0f, 20.0f, 12.0f);
        pathBuilder.horizontalLineToRelative(-2.0f);
        pathBuilder.verticalLineTo(6.0f);
        pathBuilder.horizontalLineToRelative(-6.0f);
        pathBuilder.verticalLineTo(4.0f);
        pathBuilder.curveToRelative(0.0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f);
        pathBuilder.reflectiveCurveTo(11.0f, 3.72f, 11.0f, 4.0f);
        pathBuilder.verticalLineToRelative(2.0f);
        pathBuilder.horizontalLineTo(8.83f);
        pathBuilder.close();
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _extensionOff = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
