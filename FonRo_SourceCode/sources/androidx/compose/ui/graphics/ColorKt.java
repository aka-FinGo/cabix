package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Color.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a9\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a\u0017\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001a\u001a5\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\u0010\u001a\u00020\u00192\b\b\u0001\u0010\u0012\u001a\u00020\u00192\b\b\u0001\u0010\u0013\u001a\u00020\u00192\b\b\u0003\u0010\u0014\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001b\u001a\u0015\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001d\u001a9\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\u0010\u0017\u001a1\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0011H\u0082\b\u001a,\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\b\b\u0001\u0010(\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u001e\u0010+\u001a\u00020\u0007*\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u0016\u0010/\u001a\u000200*\u00020\u0007H\u0003ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a\u0016\u00103\u001a\u00020\u0011*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a%\u00106\u001a\u00020\u0007*\u00020\u00072\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000708H\u0086\bø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a\u0016\u0010;\u001a\u00020\u0019*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b<\u0010=\"\u0018\u0010\u0000\u001a\u00020\u00018\u0000X\u0081T¢\u0006\n\n\u0002\u0010\u0004\u0012\u0004\b\u0002\u0010\u0003\"\u001f\u0010\u0005\u001a\u00020\u0006*\u00020\u00078Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u001f\u0010\f\u001a\u00020\u0006*\u00020\u00078Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006>"}, d2 = {"UnspecifiedColor", "Lkotlin/ULong;", "getUnspecifiedColor$annotations", "()V", "J", "isSpecified", "", "Landroidx/compose/ui/graphics/Color;", "isSpecified-8_81llA$annotations", "(J)V", "isSpecified-8_81llA", "(J)Z", "isUnspecified", "isUnspecified-8_81llA$annotations", "isUnspecified-8_81llA", "Color", "red", "", "green", "blue", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", TypedValues.Custom.S_COLOR, "", "(I)J", "(IIII)J", "", "(J)J", "UncheckedColor", "compositeComponent", "fgC", "bgC", "fgA", "bgA", "a", "lerp", "start", "stop", "fraction", "lerp-jxsXWHM", "(JJF)J", "compositeOver", "background", "compositeOver--OWjLjI", "(JJ)J", "getComponents", "", "getComponents-8_81llA", "(J)[F", "luminance", "luminance-8_81llA", "(J)F", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-DxMtmZc", "(JLkotlin/jvm/functions/Function0;)J", "toArgb", "toArgb-8_81llA", "(J)I", "ui-graphics_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class ColorKt {
    public static final long UnspecifiedColor = 16;

    private static final float compositeComponent(float f, float f2, float f3, float f4, float f5) {
        if (f5 == 0.0f) {
            return 0.0f;
        }
        return ((f * f3) + ((f2 * f4) * (1.0f - f3))) / f5;
    }

    public static /* synthetic */ void getUnspecifiedColor$annotations() {
    }

    /* renamed from: isSpecified-8_81llA, reason: not valid java name */
    public static final boolean m4431isSpecified8_81llA(long j) {
        return j != 16;
    }

    /* renamed from: isSpecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m4432isSpecified8_81llA$annotations(long j) {
    }

    /* renamed from: isUnspecified-8_81llA, reason: not valid java name */
    public static final boolean m4433isUnspecified8_81llA(long j) {
        return j == 16;
    }

    /* renamed from: isUnspecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m4434isUnspecified8_81llA$annotations(long j) {
    }

    public static /* synthetic */ long Color$default(float f, float f2, float f3, float f4, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return Color(f, f2, f3, f4, colorSpace);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0188  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long Color(float r20, float r21, float r22, float r23, androidx.compose.ui.graphics.colorspace.ColorSpace r24) {
        /*
            Method dump skipped, instructions count: 503
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.ColorKt.Color(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    public static /* synthetic */ long UncheckedColor$default(float f, float f2, float f3, float f4, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return UncheckedColor(f, f2, f3, f4, colorSpace);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long UncheckedColor(float r17, float r18, float r19, float r20, androidx.compose.ui.graphics.colorspace.ColorSpace r21) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.ColorKt.UncheckedColor(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    public static final long Color(int i) {
        return Color.m4380constructorimpl(ULong.m8049constructorimpl(ULong.m8049constructorimpl(i) << 32));
    }

    public static final long Color(long j) {
        return Color.m4380constructorimpl(ULong.m8049constructorimpl(j << 32));
    }

    public static /* synthetic */ long Color$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 255;
        }
        return Color(i, i2, i3, i4);
    }

    public static final long Color(int i, int i2, int i3, int i4) {
        return Color(((i & 255) << 16) | ((i4 & 255) << 24) | ((i2 & 255) << 8) | (i3 & 255));
    }

    /* renamed from: lerp-jxsXWHM, reason: not valid java name */
    public static final long m4435lerpjxsXWHM(long j, long j2, float f) {
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long m4381convertvNxB06k = Color.m4381convertvNxB06k(j, oklab);
        long m4381convertvNxB06k2 = Color.m4381convertvNxB06k(j2, oklab);
        float m4386getAlphaimpl = Color.m4386getAlphaimpl(m4381convertvNxB06k);
        float m4390getRedimpl = Color.m4390getRedimpl(m4381convertvNxB06k);
        float m4389getGreenimpl = Color.m4389getGreenimpl(m4381convertvNxB06k);
        float m4387getBlueimpl = Color.m4387getBlueimpl(m4381convertvNxB06k);
        float m4386getAlphaimpl2 = Color.m4386getAlphaimpl(m4381convertvNxB06k2);
        float m4390getRedimpl2 = Color.m4390getRedimpl(m4381convertvNxB06k2);
        float m4389getGreenimpl2 = Color.m4389getGreenimpl(m4381convertvNxB06k2);
        float m4387getBlueimpl2 = Color.m4387getBlueimpl(m4381convertvNxB06k2);
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        return Color.m4381convertvNxB06k(UncheckedColor(MathHelpersKt.lerp(m4390getRedimpl, m4390getRedimpl2, f), MathHelpersKt.lerp(m4389getGreenimpl, m4389getGreenimpl2, f), MathHelpersKt.lerp(m4387getBlueimpl, m4387getBlueimpl2, f), MathHelpersKt.lerp(m4386getAlphaimpl, m4386getAlphaimpl2, f), oklab), Color.m4388getColorSpaceimpl(j2));
    }

    /* renamed from: compositeOver--OWjLjI, reason: not valid java name */
    public static final long m4429compositeOverOWjLjI(long j, long j2) {
        long m4381convertvNxB06k = Color.m4381convertvNxB06k(j, Color.m4388getColorSpaceimpl(j2));
        float m4386getAlphaimpl = Color.m4386getAlphaimpl(j2);
        float m4386getAlphaimpl2 = Color.m4386getAlphaimpl(m4381convertvNxB06k);
        float f = 1.0f - m4386getAlphaimpl2;
        float f2 = (m4386getAlphaimpl * f) + m4386getAlphaimpl2;
        return UncheckedColor(f2 == 0.0f ? 0.0f : ((Color.m4390getRedimpl(m4381convertvNxB06k) * m4386getAlphaimpl2) + ((Color.m4390getRedimpl(j2) * m4386getAlphaimpl) * f)) / f2, f2 == 0.0f ? 0.0f : ((Color.m4389getGreenimpl(m4381convertvNxB06k) * m4386getAlphaimpl2) + ((Color.m4389getGreenimpl(j2) * m4386getAlphaimpl) * f)) / f2, f2 != 0.0f ? ((Color.m4387getBlueimpl(m4381convertvNxB06k) * m4386getAlphaimpl2) + ((Color.m4387getBlueimpl(j2) * m4386getAlphaimpl) * f)) / f2 : 0.0f, f2, Color.m4388getColorSpaceimpl(j2));
    }

    /* renamed from: getComponents-8_81llA, reason: not valid java name */
    private static final float[] m4430getComponents8_81llA(long j) {
        return new float[]{Color.m4390getRedimpl(j), Color.m4389getGreenimpl(j), Color.m4387getBlueimpl(j), Color.m4386getAlphaimpl(j)};
    }

    /* renamed from: luminance-8_81llA, reason: not valid java name */
    public static final float m4436luminance8_81llA(long j) {
        ColorSpace m4388getColorSpaceimpl = Color.m4388getColorSpaceimpl(j);
        if (!ColorModel.m4791equalsimpl0(m4388getColorSpaceimpl.getModel(), ColorModel.INSTANCE.m4798getRgbxdoWZVw())) {
            InlineClassHelperKt.throwIllegalArgumentException("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) ColorModel.m4794toStringimpl(m4388getColorSpaceimpl.getModel())));
        }
        Intrinsics.checkNotNull(m4388getColorSpaceimpl, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction eotfFunc = ((Rgb) m4388getColorSpaceimpl).getEotfFunc();
        float invoke = (float) ((eotfFunc.invoke(Color.m4390getRedimpl(j)) * 0.2126d) + (eotfFunc.invoke(Color.m4389getGreenimpl(j)) * 0.7152d) + (eotfFunc.invoke(Color.m4387getBlueimpl(j)) * 0.0722d));
        if (invoke < 0.0f) {
            invoke = 0.0f;
        }
        if (invoke > 1.0f) {
            return 1.0f;
        }
        return invoke;
    }

    /* renamed from: toArgb-8_81llA, reason: not valid java name */
    public static final int m4438toArgb8_81llA(long j) {
        return (int) ULong.m8049constructorimpl(Color.m4381convertvNxB06k(j, ColorSpaces.INSTANCE.getSrgb()) >>> 32);
    }

    /* renamed from: takeOrElse-DxMtmZc, reason: not valid java name */
    public static final long m4437takeOrElseDxMtmZc(long j, Function0<Color> function0) {
        return j != 16 ? j : function0.invoke().m4394unboximpl();
    }
}
