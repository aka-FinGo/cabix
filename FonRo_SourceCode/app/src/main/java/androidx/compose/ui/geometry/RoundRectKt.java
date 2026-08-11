package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: RoundRect.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\u001a \u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a@\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001c2\b\b\u0002\u0010 \u001a\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a8\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a6\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a\u001e\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u0012\u001a\u001c\u00101\u001a\u00020\u0002*\u00020\u00022\u0006\u00102\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b3\u00104\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b\"\u0015\u0010\f\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b\"\u0015\u0010\r\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\"\u0015\u0010\u000e\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b\"\u0015\u0010\u000f\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b\"\u0015\u0010\u0010\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000b\"\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u0015\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014\"\u0015\u0010\u0017\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"boundingRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/RoundRect;", "getBoundingRect", "(Landroidx/compose/ui/geometry/RoundRect;)Landroidx/compose/ui/geometry/Rect;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter", "(Landroidx/compose/ui/geometry/RoundRect;)J", "isCircle", "", "(Landroidx/compose/ui/geometry/RoundRect;)Z", "isEllipse", "isEmpty", "isFinite", "isRect", "isSimple", "maxDimension", "", "getMaxDimension", "(Landroidx/compose/ui/geometry/RoundRect;)F", "minDimension", "getMinDimension", "safeInnerRect", "getSafeInnerRect", "RoundRect", "rect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "RoundRect-sniSvfs", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/RoundRect;", "topLeft", "topRight", "bottomRight", "bottomLeft", "RoundRect-ZAM2FJo", "(Landroidx/compose/ui/geometry/Rect;JJJJ)Landroidx/compose/ui/geometry/RoundRect;", "radiusX", "radiusY", "left", "top", "right", "bottom", "RoundRect-gG7oq9Y", "(FFFFJ)Landroidx/compose/ui/geometry/RoundRect;", "lerp", "start", "stop", "fraction", "translate", TypedValues.CycleType.S_WAVE_OFFSET, "translate-Uv8p0NA", "(Landroidx/compose/ui/geometry/RoundRect;J)Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class RoundRectKt {
    public static final RoundRect RoundRect(Rect rect, float f, float f2) {
        return RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), f, f2);
    }

    /* renamed from: RoundRect-ZAM2FJo, reason: not valid java name */
    public static final RoundRect m4177RoundRectZAM2FJo(Rect rect, long j, long j2, long j3, long j4) {
        return new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), j, j2, j3, j4, null);
    }

    /* renamed from: translate-Uv8p0NA, reason: not valid java name */
    public static final RoundRect m4181translateUv8p0NA(RoundRect roundRect, long j) {
        int i = (int) (j >> 32);
        int i2 = (int) (4294967295L & j);
        return new RoundRect(roundRect.getLeft() + Float.intBitsToFloat(i), roundRect.getTop() + Float.intBitsToFloat(i2), roundRect.getRight() + Float.intBitsToFloat(i), Float.intBitsToFloat(i2) + roundRect.getBottom(), roundRect.m4175getTopLeftCornerRadiuskKHJgLs(), roundRect.m4176getTopRightCornerRadiuskKHJgLs(), roundRect.m4174getBottomRightCornerRadiuskKHJgLs(), roundRect.m4173getBottomLeftCornerRadiuskKHJgLs(), null);
    }

    public static final Rect getBoundingRect(RoundRect roundRect) {
        return new Rect(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
    }

    public static final Rect getSafeInnerRect(RoundRect roundRect) {
        return new Rect(roundRect.getLeft() + (Math.max(Float.intBitsToFloat((int) (roundRect.m4173getBottomLeftCornerRadiuskKHJgLs() >> 32)), Float.intBitsToFloat((int) (roundRect.m4175getTopLeftCornerRadiuskKHJgLs() >> 32))) * 0.29289323f), roundRect.getTop() + (Math.max(Float.intBitsToFloat((int) (roundRect.m4175getTopLeftCornerRadiuskKHJgLs() & 4294967295L)), Float.intBitsToFloat((int) (roundRect.m4176getTopRightCornerRadiuskKHJgLs() & 4294967295L))) * 0.29289323f), roundRect.getRight() - (Math.max(Float.intBitsToFloat((int) (roundRect.m4176getTopRightCornerRadiuskKHJgLs() >> 32)), Float.intBitsToFloat((int) (roundRect.m4174getBottomRightCornerRadiuskKHJgLs() >> 32))) * 0.29289323f), roundRect.getBottom() - (Math.max(Float.intBitsToFloat((int) (roundRect.m4174getBottomRightCornerRadiuskKHJgLs() & 4294967295L)), Float.intBitsToFloat((int) (roundRect.m4173getBottomLeftCornerRadiuskKHJgLs() & 4294967295L))) * 0.29289323f));
    }

    public static final boolean isEmpty(RoundRect roundRect) {
        return roundRect.getLeft() >= roundRect.getRight() || roundRect.getTop() >= roundRect.getBottom();
    }

    public static final boolean isFinite(RoundRect roundRect) {
        return (Float.floatToRawIntBits(roundRect.getLeft()) & Integer.MAX_VALUE) < 2139095040 && (Float.floatToRawIntBits(roundRect.getTop()) & Integer.MAX_VALUE) < 2139095040 && (Float.floatToRawIntBits(roundRect.getRight()) & Integer.MAX_VALUE) < 2139095040 && (Float.floatToRawIntBits(roundRect.getBottom()) & Integer.MAX_VALUE) < 2139095040;
    }

    public static final boolean isRect(RoundRect roundRect) {
        long m4175getTopLeftCornerRadiuskKHJgLs = roundRect.m4175getTopLeftCornerRadiuskKHJgLs() & 9223372034707292159L;
        if (((~m4175getTopLeftCornerRadiuskKHJgLs) & (m4175getTopLeftCornerRadiuskKHJgLs - InlineClassHelperKt.Uint64Low32) & (-9223372034707292160L)) == 0) {
            return false;
        }
        long m4176getTopRightCornerRadiuskKHJgLs = roundRect.m4176getTopRightCornerRadiuskKHJgLs() & 9223372034707292159L;
        if (((~m4176getTopRightCornerRadiuskKHJgLs) & (m4176getTopRightCornerRadiuskKHJgLs - InlineClassHelperKt.Uint64Low32) & (-9223372034707292160L)) == 0) {
            return false;
        }
        long m4173getBottomLeftCornerRadiuskKHJgLs = roundRect.m4173getBottomLeftCornerRadiuskKHJgLs() & 9223372034707292159L;
        if (((~m4173getBottomLeftCornerRadiuskKHJgLs) & (m4173getBottomLeftCornerRadiuskKHJgLs - InlineClassHelperKt.Uint64Low32) & (-9223372034707292160L)) == 0) {
            return false;
        }
        long m4174getBottomRightCornerRadiuskKHJgLs = roundRect.m4174getBottomRightCornerRadiuskKHJgLs() & 9223372034707292159L;
        return (((~m4174getBottomRightCornerRadiuskKHJgLs) & (m4174getBottomRightCornerRadiuskKHJgLs - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) != 0;
    }

    public static final boolean isEllipse(RoundRect roundRect) {
        return roundRect.m4175getTopLeftCornerRadiuskKHJgLs() == roundRect.m4176getTopRightCornerRadiuskKHJgLs() && roundRect.m4176getTopRightCornerRadiuskKHJgLs() == roundRect.m4174getBottomRightCornerRadiuskKHJgLs() && roundRect.m4174getBottomRightCornerRadiuskKHJgLs() == roundRect.m4173getBottomLeftCornerRadiuskKHJgLs() && ((double) roundRect.getWidth()) <= ((double) Float.intBitsToFloat((int) (roundRect.m4175getTopLeftCornerRadiuskKHJgLs() >> 32))) * 2.0d && ((double) roundRect.getHeight()) <= ((double) Float.intBitsToFloat((int) (roundRect.m4175getTopLeftCornerRadiuskKHJgLs() & 4294967295L))) * 2.0d;
    }

    public static final boolean isCircle(RoundRect roundRect) {
        return roundRect.getWidth() == roundRect.getHeight() && isEllipse(roundRect);
    }

    public static final float getMinDimension(RoundRect roundRect) {
        return Math.min(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final float getMaxDimension(RoundRect roundRect) {
        return Math.max(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
    }

    public static final long getCenter(RoundRect roundRect) {
        float left = roundRect.getLeft() + (roundRect.getWidth() / 2.0f);
        float top = roundRect.getTop() + (roundRect.getHeight() / 2.0f);
        return Offset.m4117constructorimpl((Float.floatToRawIntBits(top) & 4294967295L) | (Float.floatToRawIntBits(left) << 32));
    }

    public static final boolean isSimple(RoundRect roundRect) {
        long m4175getTopLeftCornerRadiuskKHJgLs = roundRect.m4175getTopLeftCornerRadiuskKHJgLs();
        return (m4175getTopLeftCornerRadiuskKHJgLs >>> 32) == (m4175getTopLeftCornerRadiuskKHJgLs & 4294967295L) && roundRect.m4175getTopLeftCornerRadiuskKHJgLs() == roundRect.m4176getTopRightCornerRadiuskKHJgLs() && roundRect.m4175getTopLeftCornerRadiuskKHJgLs() == roundRect.m4174getBottomRightCornerRadiuskKHJgLs() && roundRect.m4175getTopLeftCornerRadiuskKHJgLs() == roundRect.m4173getBottomLeftCornerRadiuskKHJgLs();
    }

    public static final RoundRect lerp(RoundRect roundRect, RoundRect roundRect2, float f) {
        return new RoundRect(MathHelpersKt.lerp(roundRect.getLeft(), roundRect2.getLeft(), f), MathHelpersKt.lerp(roundRect.getTop(), roundRect2.getTop(), f), MathHelpersKt.lerp(roundRect.getRight(), roundRect2.getRight(), f), MathHelpersKt.lerp(roundRect.getBottom(), roundRect2.getBottom(), f), CornerRadiusKt.m4098lerp3Ry4LBc(roundRect.m4175getTopLeftCornerRadiuskKHJgLs(), roundRect2.m4175getTopLeftCornerRadiuskKHJgLs(), f), CornerRadiusKt.m4098lerp3Ry4LBc(roundRect.m4176getTopRightCornerRadiuskKHJgLs(), roundRect2.m4176getTopRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m4098lerp3Ry4LBc(roundRect.m4174getBottomRightCornerRadiuskKHJgLs(), roundRect2.m4174getBottomRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m4098lerp3Ry4LBc(roundRect.m4173getBottomLeftCornerRadiuskKHJgLs(), roundRect2.m4173getBottomLeftCornerRadiuskKHJgLs(), f), null);
    }

    public static final RoundRect RoundRect(float f, float f2, float f3, float f4, float f5, float f6) {
        long m4079constructorimpl = CornerRadius.m4079constructorimpl((Float.floatToRawIntBits(f5) << 32) | (Float.floatToRawIntBits(f6) & 4294967295L));
        return new RoundRect(f, f2, f3, f4, m4079constructorimpl, m4079constructorimpl, m4079constructorimpl, m4079constructorimpl, null);
    }

    /* renamed from: RoundRect-gG7oq9Y, reason: not valid java name */
    public static final RoundRect m4179RoundRectgG7oq9Y(float f, float f2, float f3, float f4, long j) {
        return RoundRect(f, f2, f3, f4, Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    /* renamed from: RoundRect-sniSvfs, reason: not valid java name */
    public static final RoundRect m4180RoundRectsniSvfs(Rect rect, long j) {
        return RoundRect(rect, Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)));
    }
}
