package coil.transform;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.constraintlayout.widget.ConstraintLayout;
import coil.decode.DecodeUtils;
import coil.size.Dimension;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import coil.util.Bitmaps;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: RoundedCornersTransformation.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B/\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB\u0013\b\u0016\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\nJ\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J$\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcoil/transform/RoundedCornersTransformation;", "Lcoil/transform/Transformation;", "topLeft", "", "topRight", "bottomLeft", "bottomRight", "<init>", "(FFFF)V", "radius", "(F)V", "cacheKey", "", "getCacheKey", "()Ljava/lang/String;", "transform", "Landroid/graphics/Bitmap;", "input", "size", "Lcoil/size/Size;", "(Landroid/graphics/Bitmap;Lcoil/size/Size;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateOutputSize", "Lkotlin/Pair;", "", "equals", "", WriteOffReason.OTHER, "", "hashCode", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class RoundedCornersTransformation implements Transformation {
    private final float bottomLeft;
    private final float bottomRight;
    private final String cacheKey;
    private final float topLeft;
    private final float topRight;

    public RoundedCornersTransformation() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
    }

    public RoundedCornersTransformation(float f, float f2, float f3, float f4) {
        this.topLeft = f;
        this.topRight = f2;
        this.bottomLeft = f3;
        this.bottomRight = f4;
        if (f < 0.0f || f2 < 0.0f || f3 < 0.0f || f4 < 0.0f) {
            throw new IllegalArgumentException("All radii must be >= 0.".toString());
        }
        this.cacheKey = getClass().getName() + '-' + f + AbstractJsonLexerKt.COMMA + f2 + AbstractJsonLexerKt.COMMA + f3 + AbstractJsonLexerKt.COMMA + f4;
    }

    public /* synthetic */ RoundedCornersTransformation(float f, float f2, float f3, float f4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f2, (i & 4) != 0 ? 0.0f : f3, (i & 8) != 0 ? 0.0f : f4);
    }

    public RoundedCornersTransformation(float f) {
        this(f, f, f, f);
    }

    @Override // coil.transform.Transformation
    public String getCacheKey() {
        return this.cacheKey;
    }

    @Override // coil.transform.Transformation
    public Object transform(Bitmap bitmap, Size size, Continuation<? super Bitmap> continuation) {
        Paint paint = new Paint(3);
        Pair<Integer, Integer> calculateOutputSize = calculateOutputSize(bitmap, size);
        int intValue = calculateOutputSize.component1().intValue();
        int intValue2 = calculateOutputSize.component2().intValue();
        Bitmap createBitmap = Bitmap.createBitmap(intValue, intValue2, Bitmaps.getSafeConfig(bitmap));
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        Matrix matrix = new Matrix();
        float computeSizeMultiplier = (float) DecodeUtils.computeSizeMultiplier(bitmap.getWidth(), bitmap.getHeight(), intValue, intValue2, Scale.FILL);
        matrix.setTranslate((intValue - (bitmap.getWidth() * computeSizeMultiplier)) / 2.0f, (intValue2 - (bitmap.getHeight() * computeSizeMultiplier)) / 2.0f);
        matrix.preScale(computeSizeMultiplier, computeSizeMultiplier);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        float f = this.topLeft;
        float f2 = this.topRight;
        float f3 = this.bottomRight;
        float f4 = this.bottomLeft;
        float[] fArr = {f, f, f2, f2, f3, f3, f4, f4};
        RectF rectF = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        Path path = new Path();
        path.addRoundRect(rectF, fArr, Path.Direction.CW);
        canvas.drawPath(path, paint);
        return createBitmap;
    }

    private final Pair<Integer, Integer> calculateOutputSize(Bitmap input, Size size) {
        if (Sizes.isOriginal(size)) {
            return TuplesKt.to(Integer.valueOf(input.getWidth()), Integer.valueOf(input.getHeight()));
        }
        Dimension width = size.getWidth();
        Dimension height = size.getHeight();
        if ((width instanceof Dimension.Pixels) && (height instanceof Dimension.Pixels)) {
            return TuplesKt.to(Integer.valueOf(((Dimension.Pixels) width).px), Integer.valueOf(((Dimension.Pixels) height).px));
        }
        int width2 = input.getWidth();
        int height2 = input.getHeight();
        Dimension width3 = size.getWidth();
        int i = width3 instanceof Dimension.Pixels ? ((Dimension.Pixels) width3).px : Integer.MIN_VALUE;
        Dimension height3 = size.getHeight();
        double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width2, height2, i, height3 instanceof Dimension.Pixels ? ((Dimension.Pixels) height3).px : Integer.MIN_VALUE, Scale.FILL);
        return TuplesKt.to(Integer.valueOf(MathKt.roundToInt(input.getWidth() * computeSizeMultiplier)), Integer.valueOf(MathKt.roundToInt(computeSizeMultiplier * input.getHeight())));
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoundedCornersTransformation)) {
            return false;
        }
        RoundedCornersTransformation roundedCornersTransformation = (RoundedCornersTransformation) other;
        return this.topLeft == roundedCornersTransformation.topLeft && this.topRight == roundedCornersTransformation.topRight && this.bottomLeft == roundedCornersTransformation.bottomLeft && this.bottomRight == roundedCornersTransformation.bottomRight;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.topLeft) * 31) + Float.hashCode(this.topRight)) * 31) + Float.hashCode(this.bottomLeft)) * 31) + Float.hashCode(this.bottomRight);
    }
}
