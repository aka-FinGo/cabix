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

/* compiled from: NoiseControlOff.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_noiseControlOff", "Landroidx/compose/ui/graphics/vector/ImageVector;", "NoiseControlOff", "Landroidx/compose/material/icons/Icons$Filled;", "getNoiseControlOff", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NoiseControlOffKt {
    private static ImageVector _noiseControlOff;

    public static final ImageVector getNoiseControlOff(Icons.Filled filled) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _noiseControlOff;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.NoiseControlOff", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(12.0f, 4.0f);
        pathBuilder.curveToRelative(1.44f, 0.0f, 2.79f, 0.38f, 3.95f, 1.05f);
        pathBuilder.lineToRelative(1.45f, -1.45f);
        pathBuilder.curveTo(15.85f, 2.59f, 13.99f, 2.0f, 12.0f, 2.0f);
        pathBuilder.reflectiveCurveTo(8.15f, 2.59f, 6.59f, 3.59f);
        pathBuilder.lineToRelative(1.45f, 1.45f);
        pathBuilder.curveTo(9.21f, 4.38f, 10.56f, 4.0f, 12.0f, 4.0f);
        pathBuilder.close();
        builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw2 = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk82 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(20.0f, 12.0f);
        pathBuilder2.curveToRelative(0.0f, 1.44f, -0.38f, 2.79f, -1.05f, 3.95f);
        pathBuilder2.lineToRelative(1.45f, 1.45f);
        pathBuilder2.curveTo(21.41f, 15.85f, 22.0f, 13.99f, 22.0f, 12.0f);
        pathBuilder2.reflectiveCurveToRelative(-0.59f, -3.85f, -1.59f, -5.41f);
        pathBuilder2.lineToRelative(-1.45f, 1.45f);
        pathBuilder2.curveTo(19.62f, 9.21f, 20.0f, 10.56f, 20.0f, 12.0f);
        pathBuilder2.close();
        builder.m5070addPathoIyEayM(pathBuilder2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk82, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        int defaultFillType3 = VectorKt.getDefaultFillType();
        SolidColor solidColor3 = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw3 = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk83 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder3 = new PathBuilder();
        pathBuilder3.moveTo(12.0f, 20.0f);
        pathBuilder3.curveToRelative(-1.44f, 0.0f, -2.79f, -0.38f, -3.95f, -1.05f);
        pathBuilder3.lineToRelative(-1.45f, 1.45f);
        pathBuilder3.curveTo(8.15f, 21.41f, 10.01f, 22.0f, 12.0f, 22.0f);
        pathBuilder3.reflectiveCurveToRelative(3.85f, -0.59f, 5.41f, -1.59f);
        pathBuilder3.lineToRelative(-1.45f, -1.45f);
        pathBuilder3.curveTo(14.79f, 19.62f, 13.44f, 20.0f, 12.0f, 20.0f);
        pathBuilder3.close();
        builder.m5070addPathoIyEayM(pathBuilder3.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType3, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor3, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw3, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk83, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        int defaultFillType4 = VectorKt.getDefaultFillType();
        SolidColor solidColor4 = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw4 = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk84 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder4 = new PathBuilder();
        pathBuilder4.moveTo(4.0f, 12.0f);
        pathBuilder4.curveToRelative(0.0f, -1.44f, 0.38f, -2.79f, 1.05f, -3.95f);
        pathBuilder4.lineTo(3.59f, 6.59f);
        pathBuilder4.curveTo(2.59f, 8.15f, 2.0f, 10.01f, 2.0f, 12.0f);
        pathBuilder4.reflectiveCurveToRelative(0.59f, 3.85f, 1.59f, 5.41f);
        pathBuilder4.lineToRelative(1.45f, -1.45f);
        pathBuilder4.curveTo(4.38f, 14.79f, 4.0f, 13.44f, 4.0f, 12.0f);
        pathBuilder4.close();
        builder.m5070addPathoIyEayM(pathBuilder4.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType4, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor4, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw4, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk84, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        int defaultFillType5 = VectorKt.getDefaultFillType();
        SolidColor solidColor5 = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw5 = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk85 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder5 = new PathBuilder();
        pathBuilder5.moveTo(11.5f, 6.0f);
        pathBuilder5.curveTo(9.02f, 6.0f, 7.0f, 8.02f, 7.0f, 10.5f);
        pathBuilder5.curveToRelative(0.0f, 1.22f, 0.49f, 2.41f, 1.35f, 3.27f);
        pathBuilder5.lineToRelative(1.36f, 1.36f);
        pathBuilder5.curveToRelative(0.17f, 0.17f, 0.31f, 0.44f, 0.44f, 0.82f);
        pathBuilder5.curveTo(10.56f, 17.17f, 11.71f, 18.0f, 13.0f, 18.0f);
        pathBuilder5.curveToRelative(1.65f, 0.0f, 3.0f, -1.35f, 3.0f, -3.0f);
        pathBuilder5.horizontalLineToRelative(-2.0f);
        pathBuilder5.curveToRelative(0.0f, 0.55f, -0.45f, 1.0f, -1.0f, 1.0f);
        pathBuilder5.curveToRelative(-0.43f, 0.0f, -0.81f, -0.27f, -0.95f, -0.68f);
        pathBuilder5.curveToRelative(-0.15f, -0.44f, -0.4f, -1.08f, -0.93f, -1.61f);
        pathBuilder5.lineToRelative(-1.36f, -1.36f);
        pathBuilder5.curveTo(9.28f, 11.87f, 9.0f, 11.19f, 9.0f, 10.5f);
        pathBuilder5.curveTo(9.0f, 9.12f, 10.12f, 8.0f, 11.5f, 8.0f);
        pathBuilder5.curveToRelative(1.21f, 0.0f, 2.22f, 0.86f, 2.45f, 2.0f);
        pathBuilder5.horizontalLineToRelative(2.02f);
        pathBuilder5.curveTo(15.72f, 7.75f, 13.81f, 6.0f, 11.5f, 6.0f);
        pathBuilder5.close();
        builder.m5070addPathoIyEayM(pathBuilder5.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType5, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor5, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw5, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk85, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        int defaultFillType6 = VectorKt.getDefaultFillType();
        SolidColor solidColor6 = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw6 = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk86 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder6 = new PathBuilder();
        pathBuilder6.moveTo(13.5f, 12.5f);
        pathBuilder6.moveToRelative(-1.5f, 0.0f);
        pathBuilder6.arcToRelative(1.5f, 1.5f, 0.0f, true, true, 3.0f, 0.0f);
        pathBuilder6.arcToRelative(1.5f, 1.5f, 0.0f, true, true, -3.0f, 0.0f);
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder6.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType6, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor6, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw6, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk86, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _noiseControlOff = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
