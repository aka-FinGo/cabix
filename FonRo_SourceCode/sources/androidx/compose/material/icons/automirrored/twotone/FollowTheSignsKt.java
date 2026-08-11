package androidx.compose.material.icons.automirrored.twotone;

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

/* compiled from: FollowTheSigns.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_followTheSigns", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FollowTheSigns", "Landroidx/compose/material/icons/Icons$AutoMirrored$TwoTone;", "getFollowTheSigns", "(Landroidx/compose/material/icons/Icons$AutoMirrored$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-extended_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FollowTheSignsKt {
    private static ImageVector _followTheSigns;

    public static final ImageVector getFollowTheSigns(Icons.AutoMirrored.TwoTone twoTone) {
        ImageVector.Builder m5070addPathoIyEayM;
        ImageVector imageVector = _followTheSigns;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("AutoMirrored.TwoTone.FollowTheSigns", Dp.m6989constructorimpl(24.0f), Dp.m6989constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, true, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(17.64f, 7.75f);
        pathBuilder.verticalLineTo(6.0f);
        pathBuilder.horizontalLineToRelative(-3.51f);
        pathBuilder.verticalLineTo(4.5f);
        pathBuilder.horizontalLineToRelative(3.51f);
        pathBuilder.verticalLineTo(2.75f);
        pathBuilder.lineToRelative(2.49f, 2.5f);
        pathBuilder.lineTo(17.64f, 7.75f);
        pathBuilder.close();
        builder.m5070addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(Color.INSTANCE.m4410getBlack0d7_KjU(), null);
        int m4737getButtKaPHkGw2 = StrokeCap.INSTANCE.m4737getButtKaPHkGw();
        int m4747getBevelLxFBmk82 = StrokeJoin.INSTANCE.m4747getBevelLxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(9.12f, 5.25f);
        pathBuilder2.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        pathBuilder2.reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f);
        pathBuilder2.reflectiveCurveToRelative(-2.0f, 0.9f, -2.0f, 2.0f);
        pathBuilder2.reflectiveCurveTo(8.02f, 5.25f, 9.12f, 5.25f);
        pathBuilder2.close();
        pathBuilder2.moveTo(5.38f, 8.65f);
        pathBuilder2.lineToRelative(-2.75f, 14.1f);
        pathBuilder2.horizontalLineToRelative(2.1f);
        pathBuilder2.lineToRelative(1.75f, -8.0f);
        pathBuilder2.lineToRelative(2.15f, 2.0f);
        pathBuilder2.verticalLineToRelative(6.0f);
        pathBuilder2.horizontalLineToRelative(2.0f);
        pathBuilder2.verticalLineTo(15.2f);
        pathBuilder2.lineToRelative(-2.05f, -2.05f);
        pathBuilder2.lineToRelative(0.6f, -3.0f);
        pathBuilder2.curveToRelative(1.3f, 1.6f, 3.25f, 2.6f, 5.45f, 2.6f);
        pathBuilder2.verticalLineToRelative(-2.0f);
        pathBuilder2.curveToRelative(-1.85f, 0.0f, -3.45f, -1.0f, -4.35f, -2.45f);
        pathBuilder2.lineTo(9.32f, 6.7f);
        pathBuilder2.curveToRelative(-0.35f, -0.6f, -1.0f, -0.95f, -1.7f, -0.95f);
        pathBuilder2.curveToRelative(-0.25f, 0.0f, -0.5f, 0.05f, -0.75f, 0.15f);
        pathBuilder2.lineTo(1.62f, 8.05f);
        pathBuilder2.verticalLineToRelative(4.7f);
        pathBuilder2.horizontalLineToRelative(2.0f);
        pathBuilder2.verticalLineTo(9.4f);
        pathBuilder2.lineTo(5.38f, 8.65f);
        pathBuilder2.moveTo(12.62f, 1.75f);
        pathBuilder2.verticalLineToRelative(7.0f);
        pathBuilder2.horizontalLineToRelative(3.75f);
        pathBuilder2.verticalLineToRelative(14.0f);
        pathBuilder2.horizontalLineToRelative(1.5f);
        pathBuilder2.verticalLineToRelative(-14.0f);
        pathBuilder2.horizontalLineToRelative(3.75f);
        pathBuilder2.verticalLineToRelative(-7.0f);
        pathBuilder2.horizontalLineTo(12.62f);
        pathBuilder2.close();
        pathBuilder2.moveTo(17.64f, 7.75f);
        pathBuilder2.verticalLineTo(6.0f);
        pathBuilder2.horizontalLineToRelative(-3.51f);
        pathBuilder2.verticalLineTo(4.5f);
        pathBuilder2.horizontalLineToRelative(3.51f);
        pathBuilder2.verticalLineTo(2.75f);
        pathBuilder2.lineToRelative(2.49f, 2.5f);
        pathBuilder2.lineTo(17.64f, 7.75f);
        pathBuilder2.close();
        m5070addPathoIyEayM = builder.m5070addPathoIyEayM(pathBuilder2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m4737getButtKaPHkGw2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m4747getBevelLxFBmk82, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) != 0 ? 0.0f : 0.0f);
        ImageVector build = m5070addPathoIyEayM.build();
        _followTheSigns = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
