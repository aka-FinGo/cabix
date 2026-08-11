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

/* compiled from: NoFlash.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_noFlash", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoFlash", "Landroidx/compose/material/icons/Icons$Filled;", "getNoFlash", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NoFlashKt {
    private static ImageVector _noFlash;

    public static final ImageVector getNoFlash(Icons.Filled filled) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _noFlash;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.NoFlash", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(13.93f, 13.93f);
        pathBuilder.lineTo(2.45f, 2.45f);
        pathBuilder.lineTo(1.04f, 3.87f);
        pathBuilder.lineToRelative(5.3f, 5.3f);
        pathBuilder.lineTo(6.14f, 9.4f);
        pathBuilder.horizontalLineTo(3.6f);
        pathBuilder.curveTo(2.72f, 9.4f, 2.0f, 10.12f, 2.0f, 11.0f);
        pathBuilder.verticalLineToRelative(9.4f);
        pathBuilder.curveTo(2.0f, 21.28f, 2.72f, 22.0f, 3.6f, 22.0f);
        pathBuilder.horizontalLineToRelative(12.8f);
        pathBuilder.curveToRelative(0.75f, 0.0f, 1.38f, -0.52f, 1.55f, -1.22f);
        pathBuilder.lineToRelative(2.18f, 2.18f);
        pathBuilder.lineToRelative(1.41f, -1.41f);
        pathBuilder.lineTo(18.0f, 18.0f);
        pathBuilder.lineTo(13.93f, 13.93f);
        pathBuilder.close();
        pathBuilder.moveTo(10.0f, 20.0f);
        pathBuilder.curveToRelative(-2.21f, 0.0f, -4.0f, -1.79f, -4.0f, -4.0f);
        pathBuilder.curveToRelative(0.0f, -1.95f, 1.4f, -3.57f, 3.25f, -3.92f);
        pathBuilder.lineToRelative(1.57f, 1.57f);
        pathBuilder.curveToRelative(-0.26f, -0.09f, -0.53f, -0.15f, -0.82f, -0.15f);
        pathBuilder.curveToRelative(-1.38f, 0.0f, -2.5f, 1.12f, -2.5f, 2.5f);
        pathBuilder.curveToRelative(0.0f, 1.38f, 1.12f, 2.5f, 2.5f, 2.5f);
        pathBuilder.curveToRelative(1.38f, 0.0f, 2.5f, -1.12f, 2.5f, -2.5f);
        pathBuilder.curveToRelative(0.0f, -0.29f, -0.06f, -0.56f, -0.15f, -0.82f);
        pathBuilder.lineToRelative(1.57f, 1.57f);
        pathBuilder.curveTo(13.57f, 18.6f, 11.95f, 20.0f, 10.0f, 20.0f);
        pathBuilder.close();
        pathBuilder.moveTo(18.0f, 15.17f);
        pathBuilder.lineTo(10.83f, 8.0f);
        pathBuilder.horizontalLineToRelative(1.75f);
        pathBuilder.lineToRelative(1.28f, 1.4f);
        pathBuilder.horizontalLineToRelative(2.54f);
        pathBuilder.curveToRelative(0.88f, 0.0f, 1.6f, 0.72f, 1.6f, 1.6f);
        pathBuilder.verticalLineTo(15.17f);
        pathBuilder.close();
        pathBuilder.moveTo(20.4f, 5.6f);
        pathBuilder.horizontalLineTo(22.0f);
        pathBuilder.lineTo(19.0f, 11.0f);
        pathBuilder.verticalLineTo(7.0f);
        pathBuilder.horizontalLineToRelative(-1.0f);
        pathBuilder.verticalLineTo(2.0f);
        pathBuilder.horizontalLineToRelative(4.0f);
        pathBuilder.lineTo(20.4f, 5.6f);
        pathBuilder.close();
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _noFlash = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
