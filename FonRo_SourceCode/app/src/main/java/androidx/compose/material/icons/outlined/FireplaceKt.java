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

/* compiled from: Fireplace.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_fireplace", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Fireplace", "Landroidx/compose/material/icons/Icons$Outlined;", "getFireplace", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FireplaceKt {
    private static ImageVector _fireplace;

    public static final ImageVector getFireplace(Icons.Outlined outlined) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _fireplace;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.Fireplace", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(12.01f, 12.46f);
        pathBuilder.curveToRelative(-0.15f, 0.42f, -0.15f, 0.82f, -0.08f, 1.28f);
        pathBuilder.curveToRelative(0.1f, 0.55f, 0.33f, 1.04f, 0.2f, 1.6f);
        pathBuilder.curveToRelative(-0.13f, 0.59f, -0.77f, 1.38f, -1.53f, 1.63f);
        pathBuilder.curveToRelative(1.28f, 1.05f, 3.2f, 0.37f, 3.39f, -1.32f);
        pathBuilder.curveTo(14.16f, 14.11f, 12.55f, 13.67f, 12.01f, 12.46f);
        pathBuilder.close();
        builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw2 = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk82 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(2.0f, 2.0f);
        pathBuilder2.verticalLineToRelative(20.0f);
        pathBuilder2.horizontalLineToRelative(20.0f);
        pathBuilder2.verticalLineTo(2.0f);
        pathBuilder2.horizontalLineTo(2.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(12.0f, 18.0f);
        pathBuilder2.curveToRelative(-1.58f, 0.0f, -2.97f, -1.88f, -3.0f, -3.06f);
        pathBuilder2.curveToRelative(0.0f, -0.05f, -0.01f, -0.13f, -0.01f, -0.22f);
        pathBuilder2.curveToRelative(-0.13f, -1.73f, 1.0f, -3.2f, 2.47f, -4.37f);
        pathBuilder2.curveToRelative(0.47f, 1.01f, 1.27f, 2.03f, 2.57f, 2.92f);
        pathBuilder2.curveTo(14.61f, 13.69f, 15.0f, 14.13f, 15.0f, 15.0f);
        pathBuilder2.curveTo(15.0f, 16.65f, 13.65f, 18.0f, 12.0f, 18.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(20.0f, 20.0f);
        pathBuilder2.horizontalLineToRelative(-2.0f);
        pathBuilder2.verticalLineToRelative(-2.0f);
        pathBuilder2.horizontalLineToRelative(-2.02f);
        pathBuilder2.curveToRelative(0.63f, -0.84f, 1.02f, -1.87f, 1.02f, -3.0f);
        pathBuilder2.curveToRelative(0.0f, -1.89f, -1.09f, -2.85f, -1.85f, -3.37f);
        pathBuilder2.curveTo(12.2f, 9.61f, 13.0f, 7.0f, 13.0f, 7.0f);
        pathBuilder2.curveToRelative(-6.73f, 3.57f, -6.02f, 7.47f, -6.0f, 8.0f);
        pathBuilder2.curveToRelative(0.03f, 0.96f, 0.49f, 2.07f, 1.23f, 3.0f);
        pathBuilder2.horizontalLineTo(6.0f);
        pathBuilder2.verticalLineToRelative(2.0f);
        pathBuilder2.horizontalLineTo(4.0f);
        pathBuilder2.verticalLineTo(4.0f);
        pathBuilder2.horizontalLineToRelative(16.0f);
        pathBuilder2.verticalLineTo(20.0f);
        pathBuilder2.close();
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk82, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _fireplace = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
