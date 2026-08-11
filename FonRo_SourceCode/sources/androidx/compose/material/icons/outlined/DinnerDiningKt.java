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

/* compiled from: DinnerDining.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_dinnerDining", "Landroidx/compose/ui/graphics/vector/ImageVector;", "DinnerDining", "Landroidx/compose/material/icons/Icons$Outlined;", "getDinnerDining", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DinnerDiningKt {
    private static ImageVector _dinnerDining;

    public static final ImageVector getDinnerDining(Icons.Outlined outlined) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _dinnerDining;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Outlined.DinnerDining", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(2.0f, 19.0f);
        pathBuilder.lineToRelative(2.0f, 2.0f);
        pathBuilder.lineToRelative(16.0f, 0.0f);
        pathBuilder.lineToRelative(2.0f, -2.0f);
        pathBuilder.close();
        builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw2 = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk82 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(3.0f, 18.0f);
        pathBuilder2.horizontalLineToRelative(16.97f);
        pathBuilder2.curveToRelative(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        pathBuilder2.curveToRelative(0.29f, -3.26f, -2.28f, -6.0f, -5.48f, -6.0f);
        pathBuilder2.curveToRelative(-2.35f, 0.0f, -4.35f, 1.48f, -5.14f, 3.55f);
        pathBuilder2.curveTo(8.94f, 15.32f, 8.48f, 15.17f, 8.0f, 15.08f);
        pathBuilder2.verticalLineTo(9.0f);
        pathBuilder2.horizontalLineToRelative(1.75f);
        pathBuilder2.curveTo(10.99f, 9.0f, 12.0f, 7.99f, 12.0f, 6.75f);
        pathBuilder2.horizontalLineToRelative(9.0f);
        pathBuilder2.verticalLineToRelative(-1.5f);
        pathBuilder2.horizontalLineToRelative(-9.0f);
        pathBuilder2.curveTo(12.0f, 4.01f, 10.99f, 3.0f, 9.75f, 3.0f);
        pathBuilder2.horizontalLineTo(3.0f);
        pathBuilder2.verticalLineToRelative(1.5f);
        pathBuilder2.horizontalLineToRelative(1.0f);
        pathBuilder2.verticalLineToRelative(0.75f);
        pathBuilder2.horizontalLineTo(3.0f);
        pathBuilder2.verticalLineToRelative(1.5f);
        pathBuilder2.horizontalLineToRelative(1.0f);
        pathBuilder2.verticalLineTo(7.5f);
        pathBuilder2.horizontalLineTo(3.0f);
        pathBuilder2.verticalLineTo(9.0f);
        pathBuilder2.horizontalLineToRelative(1.0f);
        pathBuilder2.verticalLineToRelative(7.39f);
        pathBuilder2.curveTo(3.56f, 16.85f, 3.22f, 17.39f, 3.0f, 18.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(14.5f, 14.0f);
        pathBuilder2.curveToRelative(0.99f, 0.0f, 1.91f, 0.4f, 2.58f, 1.14f);
        pathBuilder2.curveToRelative(0.24f, 0.26f, 0.44f, 0.55f, 0.58f, 0.86f);
        pathBuilder2.horizontalLineToRelative(-6.32f);
        pathBuilder2.curveTo(11.92f, 14.79f, 13.15f, 14.0f, 14.5f, 14.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(8.0f, 4.5f);
        pathBuilder2.horizontalLineToRelative(2.0f);
        pathBuilder2.verticalLineToRelative(0.75f);
        pathBuilder2.horizontalLineTo(8.0f);
        pathBuilder2.verticalLineTo(4.5f);
        pathBuilder2.close();
        pathBuilder2.moveTo(8.0f, 6.75f);
        pathBuilder2.horizontalLineToRelative(2.0f);
        pathBuilder2.verticalLineTo(7.5f);
        pathBuilder2.horizontalLineTo(8.0f);
        pathBuilder2.verticalLineTo(6.75f);
        pathBuilder2.close();
        pathBuilder2.moveTo(5.5f, 4.5f);
        pathBuilder2.horizontalLineToRelative(1.0f);
        pathBuilder2.verticalLineToRelative(0.75f);
        pathBuilder2.horizontalLineToRelative(-1.0f);
        pathBuilder2.verticalLineTo(4.5f);
        pathBuilder2.close();
        pathBuilder2.moveTo(5.5f, 6.75f);
        pathBuilder2.horizontalLineToRelative(1.0f);
        pathBuilder2.verticalLineTo(7.5f);
        pathBuilder2.horizontalLineToRelative(-1.0f);
        pathBuilder2.verticalLineTo(6.75f);
        pathBuilder2.close();
        pathBuilder2.moveTo(5.5f, 9.0f);
        pathBuilder2.horizontalLineToRelative(1.0f);
        pathBuilder2.verticalLineToRelative(6.06f);
        pathBuilder2.curveToRelative(-0.35f, 0.06f, -0.68f, 0.17f, -1.0f, 0.3f);
        pathBuilder2.verticalLineTo(9.0f);
        pathBuilder2.close();
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk82, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _dinnerDining = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
