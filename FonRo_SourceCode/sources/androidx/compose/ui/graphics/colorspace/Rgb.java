package androidx.compose.ui.graphics.colorspace;

import androidx.camera.video.AudioStats;
import androidx.compose.ui.graphics.ColorKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: Rgb.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ^2\u00020\u0001:\u0001^BC\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\nB[\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0002\u0010\u0011B#\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014B+\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0015B/\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018B#\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0002\u0010\u001aB+\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0002\u0010\u001bB?\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u001cB\u001f\b\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0000\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u001fB[\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020 \u0012\u0006\u0010\t\u001a\u00020 \u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\"J\u0013\u0010<\u001a\u00020.2\b\u0010=\u001a\u0004\u0018\u00010>H\u0096\u0002J \u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000fH\u0007J\u0012\u0010?\u001a\u00020\u00052\b\b\u0001\u0010C\u001a\u00020\u0005H\u0007J\u0010\u0010D\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0016J\b\u0010E\u001a\u00020\u0005H\u0007J\u0012\u0010E\u001a\u00020\u00052\b\b\u0001\u0010*\u001a\u00020\u0005H\u0007J\u0010\u0010F\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\u0017H\u0016J\u0010\u0010H\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\u0017H\u0016J\b\u0010I\u001a\u00020\u0005H\u0007J\u0012\u0010I\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\u0005H\u0007J\b\u0010J\u001a\u00020\u0005H\u0007J\u0012\u0010J\u001a\u00020\u00052\b\b\u0001\u0010\u001e\u001a\u00020\u0005H\u0007J\b\u0010K\u001a\u00020\u0017H\u0016J \u0010L\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000fH\u0007J\u0012\u0010L\u001a\u00020\u00052\b\b\u0001\u0010C\u001a\u00020\u0005H\u0007J%\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u000fH\u0010¢\u0006\u0002\bRJ\u0010\u0010S\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0016J%\u0010T\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u000fH\u0010¢\u0006\u0002\bUJ=\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u000f2\u0006\u0010Y\u001a\u00020\u000f2\u0006\u0010Z\u001a\u00020\u000f2\u0006\u0010[\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\\\u0010]R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020 X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020 X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010/R\u0014\u00100\u001a\u00020.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u0010$R\u0014\u00102\u001a\u00020 X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010'R\u0014\u00104\u001a\u00020 X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010'R\u0014\u0010\u000b\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010,R\u0013\u0010!\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0014\u0010\u001e\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010,R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006_"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Rgb;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "toXYZ", "", "oetf", "Lkotlin/Function1;", "", "eotf", "(Ljava/lang/String;[FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "primaries", "whitePoint", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "min", "", "max", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FF)V", "function", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/TransferParameters;)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/TransferParameters;)V", "id", "", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", "gamma", "(Ljava/lang/String;[FD)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;D)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;DFFI)V", "colorSpace", "transform", "(Landroidx/compose/ui/graphics/colorspace/Rgb;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;)V", "Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "transferParameters", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;[FLandroidx/compose/ui/graphics/colorspace/DoubleFunction;Landroidx/compose/ui/graphics/colorspace/DoubleFunction;FFLandroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", "getEotf", "()Lkotlin/jvm/functions/Function1;", "eotfFunc", "getEotfFunc$ui_graphics_release", "()Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "eotfOrig", "getEotfOrig$ui_graphics_release", "inverseTransform", "getInverseTransform$ui_graphics_release", "()[F", "isSrgb", "", "()Z", "isWideGamut", "getOetf", "oetfFunc", "getOetfFunc$ui_graphics_release", "oetfOrig", "getOetfOrig$ui_graphics_release", "getPrimaries$ui_graphics_release", "getTransferParameters", "()Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "getTransform$ui_graphics_release", "getWhitePoint", "()Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "equals", WriteOffReason.OTHER, "", "fromLinear", "r", "g", "b", "v", "fromXyz", "getInverseTransform", "getMaxValue", "component", "getMinValue", "getPrimaries", "getTransform", "hashCode", "toLinear", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toXyz", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", "a", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class Rgb extends ColorSpace {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final DoubleFunction DoubleIdentity = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda2
        @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
        public final double invoke(double d) {
            return Rgb.DoubleIdentity$lambda$8(d);
        }
    };
    private final Function1<Double, Double> eotf;
    private final DoubleFunction eotfFunc;
    private final DoubleFunction eotfOrig;
    private final float[] inverseTransform;
    private final boolean isSrgb;
    private final boolean isWideGamut;
    private final float max;
    private final float min;
    private final Function1<Double, Double> oetf;
    private final DoubleFunction oetfFunc;
    private final DoubleFunction oetfOrig;
    private final float[] primaries;
    private final TransferParameters transferParameters;
    private final float[] transform;
    private final WhitePoint whitePoint;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final double DoubleIdentity$lambda$8(double d) {
        return d;
    }

    public final WhitePoint getWhitePoint() {
        return this.whitePoint;
    }

    public final TransferParameters getTransferParameters() {
        return this.transferParameters;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Rgb(String str, float[] fArr, WhitePoint whitePoint, float[] fArr2, DoubleFunction doubleFunction, DoubleFunction doubleFunction2, float f, float f2, TransferParameters transferParameters, int i) {
        super(str, ColorModel.INSTANCE.m4798getRgbxdoWZVw(), i, null);
        float[] fArr3 = fArr2;
        this.whitePoint = whitePoint;
        this.min = f;
        this.max = f2;
        this.transferParameters = transferParameters;
        this.oetfOrig = doubleFunction;
        this.oetf = new Function1<Double, Double>() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$oetf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Double invoke(double d) {
                float f3;
                float f4;
                double invoke = Rgb.this.getOetfOrig().invoke(d);
                f3 = Rgb.this.min;
                f4 = Rgb.this.max;
                return Double.valueOf(RangesKt.coerceIn(invoke, f3, f4));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        };
        this.oetfFunc = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda0
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double invoke(double d) {
                double coerceIn;
                Rgb rgb = Rgb.this;
                coerceIn = RangesKt.coerceIn(rgb.oetfOrig.invoke(d), rgb.min, rgb.max);
                return coerceIn;
            }
        };
        this.eotfOrig = doubleFunction2;
        this.eotf = new Function1<Double, Double>() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$eotf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Double invoke(double d) {
                float f3;
                float f4;
                DoubleFunction eotfOrig = Rgb.this.getEotfOrig();
                f3 = Rgb.this.min;
                f4 = Rgb.this.max;
                return Double.valueOf(eotfOrig.invoke(RangesKt.coerceIn(d, f3, f4)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        };
        this.eotfFunc = new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda1
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double invoke(double d) {
                double invoke;
                Rgb rgb = Rgb.this;
                invoke = rgb.eotfOrig.invoke(RangesKt.coerceIn(d, rgb.min, rgb.max));
                return invoke;
            }
        };
        if (fArr.length != 6 && fArr.length != 9) {
            throw new IllegalArgumentException("The color space's primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ");
        }
        if (f >= f2) {
            throw new IllegalArgumentException("Invalid range: min=" + f + ", max=" + f2 + "; min must be strictly < max");
        }
        Companion companion = INSTANCE;
        float[] xyPrimaries = companion.xyPrimaries(fArr);
        this.primaries = xyPrimaries;
        if (fArr3 != null) {
            if (fArr3.length != 9) {
                throw new IllegalArgumentException("Transform must have 9 entries! Has " + fArr3.length);
            }
            this.transform = fArr3;
        } else {
            float[] computeXYZMatrix = companion.computeXYZMatrix(xyPrimaries, whitePoint);
            this.transform = computeXYZMatrix;
            fArr3 = computeXYZMatrix;
        }
        this.inverseTransform = ColorSpaceKt.inverse3x3(fArr3);
        this.isWideGamut = companion.isWideGamut(xyPrimaries, f, f2);
        this.isSrgb = companion.isSrgb(xyPrimaries, whitePoint, doubleFunction, doubleFunction2, f, f2, i);
    }

    /* renamed from: getPrimaries$ui_graphics_release, reason: from getter */
    public final float[] getPrimaries() {
        return this.primaries;
    }

    /* renamed from: getTransform$ui_graphics_release, reason: from getter */
    public final float[] getTransform() {
        return this.transform;
    }

    /* renamed from: getInverseTransform$ui_graphics_release, reason: from getter */
    public final float[] getInverseTransform() {
        return this.inverseTransform;
    }

    /* renamed from: getOetfOrig$ui_graphics_release, reason: from getter */
    public final DoubleFunction getOetfOrig() {
        return this.oetfOrig;
    }

    public final Function1<Double, Double> getOetf() {
        return this.oetf;
    }

    /* renamed from: getOetfFunc$ui_graphics_release, reason: from getter */
    public final DoubleFunction getOetfFunc() {
        return this.oetfFunc;
    }

    /* renamed from: getEotfOrig$ui_graphics_release, reason: from getter */
    public final DoubleFunction getEotfOrig() {
        return this.eotfOrig;
    }

    public final Function1<Double, Double> getEotf() {
        return this.eotf;
    }

    /* renamed from: getEotfFunc$ui_graphics_release, reason: from getter */
    public final DoubleFunction getEotfFunc() {
        return this.eotfFunc;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: isWideGamut, reason: from getter */
    public boolean getIsWideGamut() {
        return this.isWideGamut;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: isSrgb, reason: from getter */
    public boolean getIsSrgb() {
        return this.isSrgb;
    }

    public final float[] getPrimaries() {
        float[] fArr = this.primaries;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return copyOf;
    }

    public final float[] getTransform() {
        float[] fArr = this.transform;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return copyOf;
    }

    public final float[] getInverseTransform() {
        float[] fArr = this.inverseTransform;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return copyOf;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Rgb(java.lang.String r13, float[] r14, final kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r15, final kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r16) {
        /*
            r12 = this;
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r0 = androidx.compose.ui.graphics.colorspace.Rgb.INSTANCE
            float[] r3 = r0.computePrimaries$ui_graphics_release(r14)
            androidx.compose.ui.graphics.colorspace.WhitePoint r4 = androidx.compose.ui.graphics.colorspace.Rgb.Companion.access$computeWhitePoint(r0, r14)
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda3 r6 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda3
            r6.<init>()
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda4 r7 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda4
            r14 = r16
            r7.<init>()
            r10 = 0
            r11 = -1
            r5 = 0
            r8 = 0
            r9 = 1065353216(0x3f800000, float:1.0)
            r1 = r12
            r2 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):void");
    }

    public Rgb(String str, float[] fArr, WhitePoint whitePoint, final Function1<? super Double, Double> function1, final Function1<? super Double, Double> function12, float f, float f2) {
        this(str, fArr, whitePoint, null, new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda7
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double invoke(double d) {
                double doubleValue;
                doubleValue = ((Number) Function1.this.invoke(Double.valueOf(d))).doubleValue();
                return doubleValue;
            }
        }, new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda8
            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
            public final double invoke(double d) {
                double doubleValue;
                doubleValue = ((Number) Function1.this.invoke(Double.valueOf(d))).doubleValue();
                return doubleValue;
            }
        }, f, f2, null, -1);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Rgb(java.lang.String r8, float[] r9, androidx.compose.ui.graphics.colorspace.TransferParameters r10) {
        /*
            r7 = this;
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r0 = androidx.compose.ui.graphics.colorspace.Rgb.INSTANCE
            float[] r3 = r0.computePrimaries$ui_graphics_release(r9)
            androidx.compose.ui.graphics.colorspace.WhitePoint r4 = androidx.compose.ui.graphics.colorspace.Rgb.Companion.access$computeWhitePoint(r0, r9)
            r6 = -1
            r1 = r7
            r2 = r8
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.TransferParameters):void");
    }

    public Rgb(String str, float[] fArr, WhitePoint whitePoint, TransferParameters transferParameters) {
        this(str, fArr, whitePoint, transferParameters, -1);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Rgb(java.lang.String r12, float[] r13, androidx.compose.ui.graphics.colorspace.WhitePoint r14, androidx.compose.ui.graphics.colorspace.TransferParameters r15, int r16) {
        /*
            r11 = this;
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r0 = androidx.compose.ui.graphics.colorspace.Rgb.INSTANCE
            androidx.compose.ui.graphics.colorspace.DoubleFunction r5 = androidx.compose.ui.graphics.colorspace.Rgb.Companion.access$generateOetf(r0, r15)
            androidx.compose.ui.graphics.colorspace.DoubleFunction r6 = androidx.compose.ui.graphics.colorspace.Rgb.Companion.access$generateEotf(r0, r15)
            r7 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r9 = r15
            r10 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.WhitePoint, androidx.compose.ui.graphics.colorspace.TransferParameters, int):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Rgb(java.lang.String r11, float[] r12, double r13) {
        /*
            r10 = this;
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r0 = androidx.compose.ui.graphics.colorspace.Rgb.INSTANCE
            float[] r3 = r0.computePrimaries$ui_graphics_release(r12)
            androidx.compose.ui.graphics.colorspace.WhitePoint r4 = androidx.compose.ui.graphics.colorspace.Rgb.Companion.access$computeWhitePoint(r0, r12)
            r8 = 1065353216(0x3f800000, float:1.0)
            r9 = -1
            r7 = 0
            r1 = r10
            r2 = r11
            r5 = r13
            r1.<init>(r2, r3, r4, r5, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], double):void");
    }

    public Rgb(String str, float[] fArr, WhitePoint whitePoint, double d) {
        this(str, fArr, whitePoint, d, 0.0f, 1.0f, -1);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Rgb(java.lang.String r20, float[] r21, androidx.compose.ui.graphics.colorspace.WhitePoint r22, final double r23, float r25, float r26, int r27) {
        /*
            r19 = this;
            r1 = r23
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 != 0) goto Lb
            androidx.compose.ui.graphics.colorspace.DoubleFunction r3 = androidx.compose.ui.graphics.colorspace.Rgb.DoubleIdentity
            goto L10
        Lb:
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda5 r3 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda5
            r3.<init>()
        L10:
            r17 = r3
            if (r0 != 0) goto L17
            androidx.compose.ui.graphics.colorspace.DoubleFunction r0 = androidx.compose.ui.graphics.colorspace.Rgb.DoubleIdentity
            goto L1c
        L17:
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda6 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda6
            r0.<init>()
        L1c:
            r18 = r0
            androidx.compose.ui.graphics.colorspace.TransferParameters r13 = new androidx.compose.ui.graphics.colorspace.TransferParameters
            r15 = 96
            r16 = 0
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r5 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            r0 = r13
            r13 = 0
            r0.<init>(r1, r3, r5, r7, r9, r11, r13, r15, r16)
            r8 = 0
            r4 = r19
            r5 = r20
            r6 = r21
            r7 = r22
            r11 = r25
            r12 = r26
            r14 = r27
            r13 = r0
            r9 = r17
            r10 = r18
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.WhitePoint, double, float, float, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final double _init_$lambda$6(double d, double d2) {
        if (d2 < AudioStats.AUDIO_AMPLITUDE_NONE) {
            d2 = 0.0d;
        }
        return Math.pow(d2, 1.0d / d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final double _init_$lambda$7(double d, double d2) {
        if (d2 < AudioStats.AUDIO_AMPLITUDE_NONE) {
            d2 = 0.0d;
        }
        return Math.pow(d2, d);
    }

    public Rgb(Rgb rgb, float[] fArr, WhitePoint whitePoint) {
        this(rgb.getName(), rgb.primaries, whitePoint, fArr, rgb.oetfOrig, rgb.eotfOrig, rgb.min, rgb.max, rgb.transferParameters, -1);
    }

    public final float[] getPrimaries(float[] primaries) {
        return ArraysKt.copyInto$default(this.primaries, primaries, 0, 0, 0, 14, (Object) null);
    }

    public final float[] getTransform(float[] transform) {
        return ArraysKt.copyInto$default(this.transform, transform, 0, 0, 0, 14, (Object) null);
    }

    public final float[] getInverseTransform(float[] inverseTransform) {
        return ArraysKt.copyInto$default(this.inverseTransform, inverseTransform, 0, 0, 0, 14, (Object) null);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        return this.min;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        return this.max;
    }

    public final float[] toLinear(float r, float g, float b) {
        return toLinear(new float[]{r, g, b});
    }

    public final float[] toLinear(float[] v) {
        if (v.length < 3) {
            return v;
        }
        v[0] = (float) this.eotfFunc.invoke(v[0]);
        v[1] = (float) this.eotfFunc.invoke(v[1]);
        v[2] = (float) this.eotfFunc.invoke(v[2]);
        return v;
    }

    public final float[] fromLinear(float r, float g, float b) {
        return fromLinear(new float[]{r, g, b});
    }

    public final float[] fromLinear(float[] v) {
        if (v.length < 3) {
            return v;
        }
        v[0] = (float) this.oetfFunc.invoke(v[0]);
        v[1] = (float) this.oetfFunc.invoke(v[1]);
        v[2] = (float) this.oetfFunc.invoke(v[2]);
        return v;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] toXyz(float[] v) {
        if (v.length < 3) {
            return v;
        }
        v[0] = (float) this.eotfFunc.invoke(v[0]);
        v[1] = (float) this.eotfFunc.invoke(v[1]);
        v[2] = (float) this.eotfFunc.invoke(v[2]);
        return ColorSpaceKt.mul3x3Float3(this.transform, v);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float v0, float v1, float v2) {
        float invoke = (float) this.eotfFunc.invoke(v0);
        float invoke2 = (float) this.eotfFunc.invoke(v1);
        float invoke3 = (float) this.eotfFunc.invoke(v2);
        float[] fArr = this.transform;
        if (fArr.length < 9) {
            return 0L;
        }
        float f = (fArr[0] * invoke) + (fArr[3] * invoke2) + (fArr[6] * invoke3);
        float f2 = (fArr[1] * invoke) + (fArr[4] * invoke2) + (fArr[7] * invoke3);
        return (Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float v0, float v1, float v2) {
        float invoke = (float) this.eotfFunc.invoke(v0);
        float invoke2 = (float) this.eotfFunc.invoke(v1);
        float invoke3 = (float) this.eotfFunc.invoke(v2);
        float[] fArr = this.transform;
        return (fArr[2] * invoke) + (fArr[5] * invoke2) + (fArr[8] * invoke3);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo4801xyzaToColorJlNiLsg$ui_graphics_release(float x, float y, float z, float a, ColorSpace colorSpace) {
        float[] fArr = this.inverseTransform;
        return ColorKt.Color((float) this.oetfFunc.invoke((fArr[0] * x) + (fArr[3] * y) + (fArr[6] * z)), (float) this.oetfFunc.invoke((fArr[1] * x) + (fArr[4] * y) + (fArr[7] * z)), (float) this.oetfFunc.invoke((fArr[2] * x) + (fArr[5] * y) + (fArr[8] * z)), a, colorSpace);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] fromXyz(float[] v) {
        ColorSpaceKt.mul3x3Float3(this.inverseTransform, v);
        if (v.length < 3) {
            return v;
        }
        v[0] = (float) this.oetfFunc.invoke(v[0]);
        v[1] = (float) this.oetfFunc.invoke(v[1]);
        v[2] = (float) this.oetfFunc.invoke(v[2]);
        return v;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass() || !super.equals(other)) {
            return false;
        }
        Rgb rgb = (Rgb) other;
        if (Float.compare(rgb.min, this.min) != 0 || Float.compare(rgb.max, this.max) != 0 || !Intrinsics.areEqual(this.whitePoint, rgb.whitePoint) || !Arrays.equals(this.primaries, rgb.primaries)) {
            return false;
        }
        TransferParameters transferParameters = this.transferParameters;
        if (transferParameters != null) {
            return Intrinsics.areEqual(transferParameters, rgb.transferParameters);
        }
        if (rgb.transferParameters == null) {
            return true;
        }
        if (Intrinsics.areEqual(this.oetfOrig, rgb.oetfOrig)) {
            return Intrinsics.areEqual(this.eotfOrig, rgb.eotfOrig);
        }
        return false;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public int hashCode() {
        int hashCode = ((((super.hashCode() * 31) + this.whitePoint.hashCode()) * 31) + Arrays.hashCode(this.primaries)) * 31;
        float f = this.min;
        int floatToIntBits = (hashCode + (f == 0.0f ? 0 : Float.floatToIntBits(f))) * 31;
        float f2 = this.max;
        int floatToIntBits2 = (floatToIntBits + (f2 == 0.0f ? 0 : Float.floatToIntBits(f2))) * 31;
        TransferParameters transferParameters = this.transferParameters;
        int hashCode2 = floatToIntBits2 + (transferParameters != null ? transferParameters.hashCode() : 0);
        return this.transferParameters == null ? (((hashCode2 * 31) + this.oetfOrig.hashCode()) * 31) + this.eotfOrig.hashCode() : hashCode2;
    }

    /* compiled from: Rgb.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\bH\u0002J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0002J)\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0082\bJ\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 H\u0002J@\u0010\"\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(H\u0002J \u0010)\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006H\u0002J\u0010\u0010*\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Rgb$Companion;", "", "()V", "DoubleIdentity", "Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "area", "", "primaries", "", "compare", "", "point", "", "a", "b", "computePrimaries", "toXYZ", "computePrimaries$ui_graphics_release", "computeWhitePoint", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "computeXYZMatrix", "whitePoint", "contains", "p1", "p2", "cross", "ax", "ay", "bx", "by", "generateEotf", "function", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "generateOetf", "isSrgb", "OETF", "EOTF", "min", "max", "id", "", "isWideGamut", "xyPrimaries", "ui-graphics_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final float cross(float ax, float ay, float bx, float by) {
            return (ax * by) - (ay * bx);
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isSrgb(float[] primaries, WhitePoint whitePoint, DoubleFunction OETF, DoubleFunction EOTF, float min, float max, int id) {
            if (id == 0) {
                return true;
            }
            if (!ColorSpaceKt.compare(primaries, ColorSpaces.INSTANCE.getSrgbPrimaries$ui_graphics_release()) || !ColorSpaceKt.compare(whitePoint, Illuminant.INSTANCE.getD65()) || min != 0.0f || max != 1.0f) {
                return false;
            }
            Rgb srgb = ColorSpaces.INSTANCE.getSrgb();
            for (double d = AudioStats.AUDIO_AMPLITUDE_NONE; d <= 1.0d; d += 0.00392156862745098d) {
                if (!compare(d, OETF, srgb.getOetfOrig()) || !compare(d, EOTF, srgb.getEotfOrig())) {
                    return false;
                }
            }
            return true;
        }

        private final boolean compare(double point, DoubleFunction a, DoubleFunction b) {
            return Math.abs(a.invoke(point) - b.invoke(point)) <= 0.001d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isWideGamut(float[] primaries, float min, float max) {
            if (area(primaries) / area(ColorSpaces.INSTANCE.getNtsc1953Primaries$ui_graphics_release()) <= 0.9f || !contains(primaries, ColorSpaces.INSTANCE.getSrgbPrimaries$ui_graphics_release())) {
                return min < 0.0f && max > 1.0f;
            }
            return true;
        }

        private final float area(float[] primaries) {
            if (primaries.length < 6) {
                return 0.0f;
            }
            float f = primaries[0];
            float f2 = primaries[1];
            float f3 = primaries[2];
            float f4 = primaries[3];
            float f5 = primaries[4];
            float f6 = primaries[5];
            float f7 = ((((((f * f4) + (f2 * f5)) + (f3 * f6)) - (f4 * f5)) - (f2 * f3)) - (f * f6)) * 0.5f;
            return f7 < 0.0f ? -f7 : f7;
        }

        private final boolean contains(float[] p1, float[] p2) {
            float f = p1[0];
            float f2 = p2[0];
            float f3 = p1[1];
            float f4 = p2[1];
            float f5 = p1[2];
            float f6 = p2[2];
            float f7 = p1[3];
            float f8 = p2[3];
            float f9 = p1[4];
            float f10 = p2[4];
            float f11 = p1[5];
            float f12 = p2[5];
            float[] fArr = {f - f2, f3 - f4, f5 - f6, f7 - f8, f9 - f10, f11 - f12};
            float f13 = fArr[0];
            float f14 = fArr[1];
            if (((f4 - f12) * f13) - ((f2 - f10) * f14) >= 0.0f && ((f2 - f6) * f14) - ((f4 - f8) * f13) >= 0.0f) {
                float f15 = fArr[2];
                float f16 = fArr[3];
                if (((f8 - f4) * f15) - ((f6 - f2) * f16) >= 0.0f && ((f6 - f10) * f16) - ((f8 - f12) * f15) >= 0.0f) {
                    float f17 = fArr[4];
                    float f18 = fArr[5];
                    if (((f12 - f8) * f17) - ((f10 - f6) * f18) >= 0.0f && ((f10 - f2) * f18) - ((f12 - f4) * f17) >= 0.0f) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final float[] computePrimaries$ui_graphics_release(float[] toXYZ) {
            float[] mul3x3Float3 = ColorSpaceKt.mul3x3Float3(toXYZ, new float[]{1.0f, 0.0f, 0.0f});
            float[] mul3x3Float32 = ColorSpaceKt.mul3x3Float3(toXYZ, new float[]{0.0f, 1.0f, 0.0f});
            float[] mul3x3Float33 = ColorSpaceKt.mul3x3Float3(toXYZ, new float[]{0.0f, 0.0f, 1.0f});
            float f = mul3x3Float3[0];
            float f2 = mul3x3Float3[1];
            float f3 = f + f2 + mul3x3Float3[2];
            float f4 = mul3x3Float32[0];
            float f5 = mul3x3Float32[1];
            float f6 = f4 + f5 + mul3x3Float32[2];
            float f7 = mul3x3Float33[0];
            float f8 = mul3x3Float33[1];
            float f9 = f7 + f8 + mul3x3Float33[2];
            return new float[]{f / f3, f2 / f3, f4 / f6, f5 / f6, f7 / f9, f8 / f9};
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final WhitePoint computeWhitePoint(float[] toXYZ) {
            float[] mul3x3Float3 = ColorSpaceKt.mul3x3Float3(toXYZ, new float[]{1.0f, 1.0f, 1.0f});
            float f = mul3x3Float3[0] + mul3x3Float3[1] + mul3x3Float3[2];
            return new WhitePoint(mul3x3Float3[0] / f, mul3x3Float3[1] / f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float[] xyPrimaries(float[] primaries) {
            float[] fArr = new float[6];
            if (primaries.length == 9) {
                float f = primaries[0];
                float f2 = primaries[1];
                float f3 = f + f2 + primaries[2];
                fArr[0] = f / f3;
                fArr[1] = f2 / f3;
                float f4 = primaries[3];
                float f5 = primaries[4];
                float f6 = f4 + f5 + primaries[5];
                fArr[2] = f4 / f6;
                fArr[3] = f5 / f6;
                float f7 = primaries[6];
                float f8 = primaries[7];
                float f9 = f7 + f8 + primaries[8];
                fArr[4] = f7 / f9;
                fArr[5] = f8 / f9;
                return fArr;
            }
            ArraysKt.copyInto$default(primaries, fArr, 0, 0, 6, 6, (Object) null);
            return fArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float[] computeXYZMatrix(float[] primaries, WhitePoint whitePoint) {
            float f = primaries[0];
            float f2 = primaries[1];
            float f3 = primaries[2];
            float f4 = primaries[3];
            float f5 = primaries[4];
            float f6 = primaries[5];
            float x = whitePoint.getX();
            float y = whitePoint.getY();
            float f7 = (1.0f - f) / f2;
            float f8 = (1.0f - x) / y;
            float f9 = f / f2;
            float f10 = (f3 / f4) - f9;
            float f11 = (x / y) - f9;
            float f12 = ((1.0f - f3) / f4) - f7;
            float f13 = (f5 / f6) - f9;
            float f14 = (((f8 - f7) * f10) - (f11 * f12)) / (((((1.0f - f5) / f6) - f7) * f10) - (f12 * f13));
            float f15 = (f11 - (f13 * f14)) / f10;
            float f16 = (1.0f - f15) - f14;
            float f17 = f16 / f2;
            float f18 = f15 / f4;
            float f19 = f14 / f6;
            return new float[]{f17 * f, f16, f17 * ((1.0f - f) - f2), f18 * f3, f15, f18 * ((1.0f - f3) - f4), f19 * f5, f14, f19 * ((1.0f - f5) - f6)};
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DoubleFunction generateOetf(final TransferParameters function) {
            if (function.isHLGish$ui_graphics_release()) {
                return new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda4
                    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                    public final double invoke(double d) {
                        double transferHlgOetf$ui_graphics_release;
                        transferHlgOetf$ui_graphics_release = ColorSpaces.INSTANCE.transferHlgOetf$ui_graphics_release(TransferParameters.this, d);
                        return transferHlgOetf$ui_graphics_release;
                    }
                };
            }
            if (function.isPQish$ui_graphics_release()) {
                return new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda5
                    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                    public final double invoke(double d) {
                        double transferSt2048Oetf$ui_graphics_release;
                        transferSt2048Oetf$ui_graphics_release = ColorSpaces.INSTANCE.transferSt2048Oetf$ui_graphics_release(TransferParameters.this, d);
                        return transferSt2048Oetf$ui_graphics_release;
                    }
                };
            }
            if (function.getE() == AudioStats.AUDIO_AMPLITUDE_NONE && function.getF() == AudioStats.AUDIO_AMPLITUDE_NONE) {
                return new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda6
                    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                    public final double invoke(double d) {
                        double rcpResponse;
                        rcpResponse = ColorSpaceKt.rcpResponse(d, r0.getA(), r0.getB(), r0.getC(), r0.getD(), TransferParameters.this.getGamma());
                        return rcpResponse;
                    }
                };
            }
            return new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda7
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d) {
                    double rcpResponse;
                    rcpResponse = ColorSpaceKt.rcpResponse(d, r0.getA(), r0.getB(), r0.getC(), r0.getD(), r0.getE(), r0.getF(), TransferParameters.this.getGamma());
                    return rcpResponse;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DoubleFunction generateEotf(final TransferParameters function) {
            if (function.isHLGish$ui_graphics_release()) {
                return new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda0
                    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                    public final double invoke(double d) {
                        double transferHlgEotf$ui_graphics_release;
                        transferHlgEotf$ui_graphics_release = ColorSpaces.INSTANCE.transferHlgEotf$ui_graphics_release(TransferParameters.this, d);
                        return transferHlgEotf$ui_graphics_release;
                    }
                };
            }
            if (function.isPQish$ui_graphics_release()) {
                return new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda1
                    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                    public final double invoke(double d) {
                        double transferSt2048Eotf$ui_graphics_release;
                        transferSt2048Eotf$ui_graphics_release = ColorSpaces.INSTANCE.transferSt2048Eotf$ui_graphics_release(TransferParameters.this, d);
                        return transferSt2048Eotf$ui_graphics_release;
                    }
                };
            }
            if (function.getE() == AudioStats.AUDIO_AMPLITUDE_NONE && function.getF() == AudioStats.AUDIO_AMPLITUDE_NONE) {
                return new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda2
                    @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                    public final double invoke(double d) {
                        double response;
                        response = ColorSpaceKt.response(d, r0.getA(), r0.getB(), r0.getC(), r0.getD(), TransferParameters.this.getGamma());
                        return response;
                    }
                };
            }
            return new DoubleFunction() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$Companion$$ExternalSyntheticLambda3
                @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                public final double invoke(double d) {
                    double response;
                    response = ColorSpaceKt.response(d, r0.getA(), r0.getB(), r0.getC(), r0.getD(), r0.getE(), r0.getF(), TransferParameters.this.getGamma());
                    return response;
                }
            };
        }
    }
}
