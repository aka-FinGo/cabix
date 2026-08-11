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

/* compiled from: StrikethroughS.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_strikethroughS", "Landroidx/compose/ui/graphics/vector/ImageVector;", "StrikethroughS", "Landroidx/compose/material/icons/Icons$Filled;", "getStrikethroughS", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class StrikethroughSKt {
    private static ImageVector _strikethroughS;

    public static final ImageVector getStrikethroughS(Icons.Filled filled) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _strikethroughS;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.StrikethroughS", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(6.85f, 7.08f);
        pathBuilder.curveTo(6.85f, 4.37f, 9.45f, 3.0f, 12.24f, 3.0f);
        pathBuilder.curveToRelative(1.64f, 0.0f, 3.0f, 0.49f, 3.9f, 1.28f);
        pathBuilder.curveToRelative(0.77f, 0.65f, 1.46f, 1.73f, 1.46f, 3.24f);
        pathBuilder.horizontalLineToRelative(-3.01f);
        pathBuilder.curveToRelative(0.0f, -0.31f, -0.05f, -0.59f, -0.15f, -0.85f);
        pathBuilder.curveToRelative(-0.29f, -0.86f, -1.2f, -1.28f, -2.25f, -1.28f);
        pathBuilder.curveToRelative(-1.86f, 0.0f, -2.34f, 1.02f, -2.34f, 1.7f);
        pathBuilder.curveToRelative(0.0f, 0.48f, 0.25f, 0.88f, 0.74f, 1.21f);
        pathBuilder.curveTo(10.97f, 8.55f, 11.36f, 8.78f, 12.0f, 9.0f);
        pathBuilder.horizontalLineTo(7.39f);
        pathBuilder.curveTo(7.18f, 8.66f, 6.85f, 8.11f, 6.85f, 7.08f);
        pathBuilder.close();
        pathBuilder.moveTo(21.0f, 12.0f);
        pathBuilder.verticalLineToRelative(-2.0f);
        pathBuilder.horizontalLineTo(3.0f);
        pathBuilder.verticalLineToRelative(2.0f);
        pathBuilder.horizontalLineToRelative(9.62f);
        pathBuilder.curveToRelative(1.15f, 0.45f, 1.96f, 0.75f, 1.96f, 1.97f);
        pathBuilder.curveToRelative(0.0f, 1.0f, -0.81f, 1.67f, -2.28f, 1.67f);
        pathBuilder.curveToRelative(-1.54f, 0.0f, -2.93f, -0.54f, -2.93f, -2.51f);
        pathBuilder.horizontalLineTo(6.4f);
        pathBuilder.curveToRelative(0.0f, 0.55f, 0.08f, 1.13f, 0.24f, 1.58f);
        pathBuilder.curveToRelative(0.81f, 2.29f, 3.29f, 3.3f, 5.67f, 3.3f);
        pathBuilder.curveToRelative(2.27f, 0.0f, 5.3f, -0.89f, 5.3f, -4.05f);
        pathBuilder.curveToRelative(0.0f, -0.3f, -0.01f, -1.16f, -0.48f, -1.94f);
        pathBuilder.horizontalLineTo(21.0f);
        pathBuilder.verticalLineTo(12.0f);
        pathBuilder.close();
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _strikethroughS = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
