package androidx.compose.ui.graphics;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: AndroidRenderEffect.android.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/graphics/RenderEffectVerificationHelper;", "", "()V", "createBlurEffect", "Landroid/graphics/RenderEffect;", "inputRenderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "radiusX", "", "radiusY", "edgeTreatment", "Landroidx/compose/ui/graphics/TileMode;", "createBlurEffect-8A-3gB4", "(Landroidx/compose/ui/graphics/RenderEffect;FFI)Landroid/graphics/RenderEffect;", "createOffsetEffect", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/geometry/Offset;", "createOffsetEffect-Uv8p0NA", "(Landroidx/compose/ui/graphics/RenderEffect;J)Landroid/graphics/RenderEffect;", "ui-graphics_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
final class RenderEffectVerificationHelper {
    public static final RenderEffectVerificationHelper INSTANCE = new RenderEffectVerificationHelper();

    private RenderEffectVerificationHelper() {
    }

    /* renamed from: createBlurEffect-8A-3gB4, reason: not valid java name */
    public final android.graphics.RenderEffect m4694createBlurEffect8A3gB4(RenderEffect inputRenderEffect, float radiusX, float radiusY, int edgeTreatment) {
        android.graphics.RenderEffect createBlurEffect;
        android.graphics.RenderEffect createBlurEffect2;
        android.graphics.RenderEffect createOffsetEffect;
        if (radiusX == 0.0f && radiusY == 0.0f) {
            createOffsetEffect = android.graphics.RenderEffect.createOffsetEffect(0.0f, 0.0f);
            return createOffsetEffect;
        }
        if (inputRenderEffect == null) {
            createBlurEffect2 = android.graphics.RenderEffect.createBlurEffect(radiusX, radiusY, AndroidTileMode_androidKt.m4271toAndroidTileMode0vamqd0(edgeTreatment));
            return createBlurEffect2;
        }
        createBlurEffect = android.graphics.RenderEffect.createBlurEffect(radiusX, radiusY, inputRenderEffect.asAndroidRenderEffect(), AndroidTileMode_androidKt.m4271toAndroidTileMode0vamqd0(edgeTreatment));
        return createBlurEffect;
    }

    /* renamed from: createOffsetEffect-Uv8p0NA, reason: not valid java name */
    public final android.graphics.RenderEffect m4695createOffsetEffectUv8p0NA(RenderEffect inputRenderEffect, long offset) {
        android.graphics.RenderEffect createOffsetEffect;
        android.graphics.RenderEffect createOffsetEffect2;
        if (inputRenderEffect == null) {
            createOffsetEffect2 = android.graphics.RenderEffect.createOffsetEffect(Float.intBitsToFloat((int) (offset >> 32)), Float.intBitsToFloat((int) (offset & 4294967295L)));
            return createOffsetEffect2;
        }
        createOffsetEffect = android.graphics.RenderEffect.createOffsetEffect(Float.intBitsToFloat((int) (offset >> 32)), Float.intBitsToFloat((int) (offset & 4294967295L)), inputRenderEffect.asAndroidRenderEffect());
        return createOffsetEffect;
    }
}
