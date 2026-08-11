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

/* compiled from: Update.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_update", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Update", "Landroidx/compose/material/icons/Icons$Filled;", "getUpdate", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class UpdateKt {
    private static ImageVector _update;

    public static final ImageVector getUpdate(Icons.Filled filled) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _update;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Update", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(21.0f, 10.12f);
        pathBuilder.horizontalLineToRelative(-6.78f);
        pathBuilder.lineToRelative(2.74f, -2.82f);
        pathBuilder.curveToRelative(-2.73f, -2.7f, -7.15f, -2.8f, -9.88f, -0.1f);
        pathBuilder.curveToRelative(-2.73f, 2.71f, -2.73f, 7.08f, 0.0f, 9.79f);
        pathBuilder.reflectiveCurveToRelative(7.15f, 2.71f, 9.88f, 0.0f);
        pathBuilder.curveTo(18.32f, 15.65f, 19.0f, 14.08f, 19.0f, 12.1f);
        pathBuilder.horizontalLineToRelative(2.0f);
        pathBuilder.curveToRelative(0.0f, 1.98f, -0.88f, 4.55f, -2.64f, 6.29f);
        pathBuilder.curveToRelative(-3.51f, 3.48f, -9.21f, 3.48f, -12.72f, 0.0f);
        pathBuilder.curveToRelative(-3.5f, -3.47f, -3.53f, -9.11f, -0.02f, -12.58f);
        pathBuilder.reflectiveCurveToRelative(9.14f, -3.47f, 12.65f, 0.0f);
        pathBuilder.lineTo(21.0f, 3.0f);
        pathBuilder.verticalLineTo(10.12f);
        pathBuilder.close();
        pathBuilder.moveTo(12.5f, 8.0f);
        pathBuilder.verticalLineToRelative(4.25f);
        pathBuilder.lineToRelative(3.5f, 2.08f);
        pathBuilder.lineToRelative(-0.72f, 1.21f);
        pathBuilder.lineTo(11.0f, 13.0f);
        pathBuilder.verticalLineTo(8.0f);
        pathBuilder.horizontalLineTo(12.5f);
        pathBuilder.close();
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _update = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
