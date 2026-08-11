package androidx.compose.animation.core;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: SpringEstimation.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a0\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0007\u001a8\u0010\u0002\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0007\u001a0\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\fH\u0007\u001a(\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002\u001a@\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002\u001a0\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002\u001a0\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002\u001a9\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001aH\u0082\b\u001a\r\u0010\u001c\u001a\u00020\u001d*\u00020\u0004H\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"MAX_LONG_MILLIS", "", "estimateAnimationDurationMillis", "stiffness", "", "dampingRatio", "initialVelocity", "initialDisplacement", "delta", "springConstant", "dampingCoefficient", "mass", "", "estimateCriticallyDamped", "firstRootReal", "p0", "v0", "estimateDurationInternal", "firstRootImaginary", "secondRootReal", "initialPosition", "estimateOverDamped", "estimateUnderDamped", "iterateNewtonsMethod", "x", "fn", "Lkotlin/Function1;", "fnPrime", "isNotFinite", "", "animation-core_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes6.dex */
public final class SpringEstimationKt {
    private static final long MAX_LONG_MILLIS = 9223372036854L;

    public static final long estimateAnimationDurationMillis(float f, float f2, float f3, float f4, float f5) {
        return f2 == 0.0f ? MAX_LONG_MILLIS : estimateAnimationDurationMillis(f, f2, f3, f4, f5);
    }

    public static final long estimateAnimationDurationMillis(double d, double d2, double d3, double d4, double d5) {
        double sqrt = 2.0d * d2 * Math.sqrt(d);
        double d6 = (sqrt * sqrt) - (4.0d * d);
        double d7 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double sqrt2 = d6 < AudioStats.AUDIO_AMPLITUDE_NONE ? 0.0d : Math.sqrt(d6);
        if (d6 < AudioStats.AUDIO_AMPLITUDE_NONE) {
            d7 = Math.sqrt(Math.abs(d6));
        }
        double d8 = -sqrt;
        return estimateDurationInternal((d8 + sqrt2) * 0.5d, d7 * 0.5d, (d8 - sqrt2) * 0.5d, d2, d3, d4, d5);
    }

    public static final long estimateAnimationDurationMillis(double d, double d2, double d3, double d4, double d5, double d6) {
        double sqrt = d2 / (Math.sqrt(d * d3) * 2.0d);
        double d7 = (d2 * d2) - ((4.0d * d3) * d);
        double d8 = 1.0d / (2.0d * d3);
        double d9 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double sqrt2 = d7 < AudioStats.AUDIO_AMPLITUDE_NONE ? 0.0d : Math.sqrt(d7);
        if (d7 < AudioStats.AUDIO_AMPLITUDE_NONE) {
            d9 = Math.sqrt(Math.abs(d7));
        }
        double d10 = -d2;
        return estimateDurationInternal((d10 + sqrt2) * d8, d9 * d8, (d10 - sqrt2) * d8, sqrt, d4, d5, d6);
    }

    private static final double estimateUnderDamped(double d, double d2, double d3, double d4, double d5) {
        double d6 = (d4 - (d * d3)) / d2;
        return Math.log(d5 / Math.sqrt((d3 * d3) + (d6 * d6))) / d;
    }

    private static final double estimateCriticallyDamped(double d, double d2, double d3, double d4) {
        double d5;
        double d6 = d4;
        double d7 = d * d2;
        double d8 = d3 - d7;
        double log = Math.log(Math.abs(d6 / d2)) / d;
        double log2 = Math.log(Math.abs(d6 / d8));
        int i = 0;
        double d9 = log2;
        for (int i2 = 0; i2 < 6; i2++) {
            d9 = log2 - Math.log(Math.abs(d9 / d));
        }
        double d10 = d9 / d;
        if (!((Double.doubleToRawLongBits(log) & Long.MAX_VALUE) < 9218868437227405312L)) {
            log = d10;
        } else if ((Double.doubleToRawLongBits(d10) & Long.MAX_VALUE) < 9218868437227405312L) {
            log = Math.max(log, d10);
        }
        double d11 = (-(d7 + d8)) / (d * d8);
        double d12 = d * d11;
        double exp = (Math.exp(d12) * d2) + (d8 * d11 * Math.exp(d12));
        if (!Double.isNaN(d11) && d11 > AudioStats.AUDIO_AMPLITUDE_NONE) {
            if (d11 <= AudioStats.AUDIO_AMPLITUDE_NONE || (-exp) >= d6) {
                log = (-(2.0d / d)) - (d2 / d8);
                d5 = Double.MAX_VALUE;
                while (d5 > 0.001d && i < 100) {
                    i++;
                    double d13 = d * log;
                    double exp2 = log - ((((d2 + (d8 * log)) * Math.exp(d13)) + d6) / ((((1.0d + d13) * d8) + d7) * Math.exp(d13)));
                    d5 = Math.abs(log - exp2);
                    log = exp2;
                }
                return log;
            }
            if (d8 < AudioStats.AUDIO_AMPLITUDE_NONE && d2 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                log = 0.0d;
            }
        }
        d6 = -d6;
        d5 = Double.MAX_VALUE;
        while (d5 > 0.001d) {
            i++;
            double d132 = d * log;
            double exp22 = log - ((((d2 + (d8 * log)) * Math.exp(d132)) + d6) / ((((1.0d + d132) * d8) + d7) * Math.exp(d132)));
            d5 = Math.abs(log - exp22);
            log = exp22;
        }
        return log;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final double estimateOverDamped(double r24, double r26, double r28, double r30, double r32) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SpringEstimationKt.estimateOverDamped(double, double, double, double, double):double");
    }

    private static final double estimateOverDamped$xInflection(double d, double d2, double d3, double d4, double d5) {
        return (d * Math.exp(d2 * d3)) + (d4 * Math.exp(d5 * d3));
    }

    private static final long estimateDurationInternal(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        double estimateCriticallyDamped;
        double d8 = d5;
        if (d6 == AudioStats.AUDIO_AMPLITUDE_NONE && d8 == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return 0L;
        }
        if (d6 < AudioStats.AUDIO_AMPLITUDE_NONE) {
            d8 = -d8;
        }
        double d9 = d8;
        double abs = Math.abs(d6);
        if (d4 > 1.0d) {
            estimateCriticallyDamped = estimateOverDamped(d, d3, abs, d9, d7);
        } else if (d4 < 1.0d) {
            estimateCriticallyDamped = estimateUnderDamped(d, d2, abs, d9, d7);
        } else {
            estimateCriticallyDamped = estimateCriticallyDamped(d, abs, d9, d7);
        }
        return (long) (estimateCriticallyDamped * 1000.0d);
    }

    private static final double iterateNewtonsMethod(double d, Function1<? super Double, Double> function1, Function1<? super Double, Double> function12) {
        return d - (function1.invoke(Double.valueOf(d)).doubleValue() / function12.invoke(Double.valueOf(d)).doubleValue());
    }

    private static final boolean isNotFinite(double d) {
        return !((Double.doubleToRawLongBits(d) & Long.MAX_VALUE) < 9218868437227405312L);
    }
}
