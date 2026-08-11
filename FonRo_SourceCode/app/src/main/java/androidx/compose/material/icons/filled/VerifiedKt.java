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

/* compiled from: Verified.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_verified", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Verified", "Landroidx/compose/material/icons/Icons$Filled;", "getVerified", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class VerifiedKt {
    private static ImageVector _verified;

    public static final ImageVector getVerified(Icons.Filled filled) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _verified;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Verified", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(23.0f, 12.0f);
        pathBuilder.lineToRelative(-2.44f, -2.79f);
        pathBuilder.lineToRelative(0.34f, -3.69f);
        pathBuilder.lineToRelative(-3.61f, -0.82f);
        pathBuilder.lineTo(15.4f, 1.5f);
        pathBuilder.lineTo(12.0f, 2.96f);
        pathBuilder.lineTo(8.6f, 1.5f);
        pathBuilder.lineTo(6.71f, 4.69f);
        pathBuilder.lineTo(3.1f, 5.5f);
        pathBuilder.lineTo(3.44f, 9.2f);
        pathBuilder.lineTo(1.0f, 12.0f);
        pathBuilder.lineToRelative(2.44f, 2.79f);
        pathBuilder.lineToRelative(-0.34f, 3.7f);
        pathBuilder.lineToRelative(3.61f, 0.82f);
        pathBuilder.lineTo(8.6f, 22.5f);
        pathBuilder.lineToRelative(3.4f, -1.47f);
        pathBuilder.lineToRelative(3.4f, 1.46f);
        pathBuilder.lineToRelative(1.89f, -3.19f);
        pathBuilder.lineToRelative(3.61f, -0.82f);
        pathBuilder.lineToRelative(-0.34f, -3.69f);
        pathBuilder.lineTo(23.0f, 12.0f);
        pathBuilder.close();
        pathBuilder.moveTo(10.09f, 16.72f);
        pathBuilder.lineToRelative(-3.8f, -3.81f);
        pathBuilder.lineToRelative(1.48f, -1.48f);
        pathBuilder.lineToRelative(2.32f, 2.33f);
        pathBuilder.lineToRelative(5.85f, -5.87f);
        pathBuilder.lineToRelative(1.48f, 1.48f);
        pathBuilder.lineTo(10.09f, 16.72f);
        pathBuilder.close();
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _verified = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
