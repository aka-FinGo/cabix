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

/* compiled from: NetworkCheck.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_networkCheck", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NetworkCheck", "Landroidx/compose/material/icons/Icons$Filled;", "getNetworkCheck", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NetworkCheckKt {
    private static ImageVector _networkCheck;

    public static final ImageVector getNetworkCheck(Icons.Filled filled) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _networkCheck;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.NetworkCheck", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(15.9f, 5.0f);
        pathBuilder.curveToRelative(-0.17f, 0.0f, -0.32f, 0.09f, -0.41f, 0.23f);
        pathBuilder.lineToRelative(-0.07f, 0.15f);
        pathBuilder.lineToRelative(-5.18f, 11.65f);
        pathBuilder.curveToRelative(-0.16f, 0.29f, -0.26f, 0.61f, -0.26f, 0.96f);
        pathBuilder.curveToRelative(0.0f, 1.11f, 0.9f, 2.01f, 2.01f, 2.01f);
        pathBuilder.curveToRelative(0.96f, 0.0f, 1.77f, -0.68f, 1.96f, -1.59f);
        pathBuilder.lineToRelative(0.01f, -0.03f);
        pathBuilder.lineTo(16.4f, 5.5f);
        pathBuilder.curveToRelative(0.0f, -0.28f, -0.22f, -0.5f, -0.5f, -0.5f);
        pathBuilder.close();
        pathBuilder.moveTo(1.0f, 9.0f);
        pathBuilder.lineToRelative(2.0f, 2.0f);
        pathBuilder.curveToRelative(2.88f, -2.88f, 6.79f, -4.08f, 10.53f, -3.62f);
        pathBuilder.lineToRelative(1.19f, -2.68f);
        pathBuilder.curveTo(9.89f, 3.84f, 4.74f, 5.27f, 1.0f, 9.0f);
        pathBuilder.close();
        pathBuilder.moveTo(21.0f, 11.0f);
        pathBuilder.lineToRelative(2.0f, -2.0f);
        pathBuilder.curveToRelative(-1.64f, -1.64f, -3.55f, -2.82f, -5.59f, -3.57f);
        pathBuilder.lineToRelative(-0.53f, 2.82f);
        pathBuilder.curveToRelative(1.5f, 0.62f, 2.9f, 1.53f, 4.12f, 2.75f);
        pathBuilder.close();
        pathBuilder.moveTo(17.0f, 15.0f);
        pathBuilder.lineToRelative(2.0f, -2.0f);
        pathBuilder.curveToRelative(-0.8f, -0.8f, -1.7f, -1.42f, -2.66f, -1.89f);
        pathBuilder.lineToRelative(-0.55f, 2.92f);
        pathBuilder.curveToRelative(0.42f, 0.27f, 0.83f, 0.59f, 1.21f, 0.97f);
        pathBuilder.close();
        pathBuilder.moveTo(5.0f, 13.0f);
        pathBuilder.lineToRelative(2.0f, 2.0f);
        pathBuilder.curveToRelative(1.13f, -1.13f, 2.56f, -1.79f, 4.03f, -2.0f);
        pathBuilder.lineToRelative(1.28f, -2.88f);
        pathBuilder.curveToRelative(-2.63f, -0.08f, -5.3f, 0.87f, -7.31f, 2.88f);
        pathBuilder.close();
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _networkCheck = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
