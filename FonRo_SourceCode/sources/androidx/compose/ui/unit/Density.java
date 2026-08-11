package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Density.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\b\u001a\u00020\t*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\n*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0010\u001a\u00020\n*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0012J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\f\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0017J\u0016\u0010 \u001a\u00020\u0016*\u00020\u0015H\u0017ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0018J\u0019\u0010\"\u001a\u00020\r*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0019\u0010\"\u001a\u00020\r*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010%R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006&À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/FontScaling;", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "(J)F", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(F)J", "(I)J", "ui-unit_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public interface Density extends FontScaling {
    float getDensity();

    /* compiled from: Density.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getDensity$annotations() {
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m6977toDpGaN1DYA(Density density, long j) {
            return Density.super.mo695toDpGaN1DYA(j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m6984toSp0xMU5do(Density density, float f) {
            return Density.super.mo702toSp0xMU5do(f);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m6982toPx0680j_4(Density density, float f) {
            return Density.super.mo700toPx0680j_4(f);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m6976roundToPx0680j_4(Density density, float f) {
            return Density.super.mo694roundToPx0680j_4(f);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m6981toPxR2X_6o(Density density, long j) {
            return Density.super.mo699toPxR2X_6o(j);
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m6975roundToPxR2X_6o(Density density, long j) {
            return Density.super.mo693roundToPxR2X_6o(j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m6979toDpu2uoSUM(Density density, int i) {
            return Density.super.mo697toDpu2uoSUM(i);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m6986toSpkPz2Gy4(Density density, int i) {
            return Density.super.mo704toSpkPz2Gy4(i);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m6978toDpu2uoSUM(Density density, float f) {
            return Density.super.mo696toDpu2uoSUM(f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m6985toSpkPz2Gy4(Density density, float f) {
            return Density.super.mo703toSpkPz2Gy4(f);
        }

        @Deprecated
        public static Rect toRect(Density density, DpRect dpRect) {
            return Density.super.toRect(dpRect);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m6983toSizeXkaWNTQ(Density density, long j) {
            return Density.super.mo701toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m6980toDpSizekrfVVM(Density density, long j) {
            return Density.super.mo698toDpSizekrfVVM(j);
        }
    }

    /* renamed from: toPx-0680j_4 */
    default float mo700toPx0680j_4(float f) {
        return f * getDensity();
    }

    /* renamed from: roundToPx-0680j_4 */
    default int mo694roundToPx0680j_4(float f) {
        float mo700toPx0680j_4 = mo700toPx0680j_4(f);
        if (Float.isInfinite(mo700toPx0680j_4)) {
            return Integer.MAX_VALUE;
        }
        return Math.round(mo700toPx0680j_4);
    }

    /* renamed from: toPx--R2X_6o */
    default float mo699toPxR2X_6o(long j) {
        if (!TextUnitType.m7211equalsimpl0(TextUnit.m7182getTypeUIouoOA(j), TextUnitType.INSTANCE.m7216getSpUIouoOA())) {
            InlineClassHelperKt.throwIllegalStateException("Only Sp can convert to Px");
        }
        return mo700toPx0680j_4(mo695toDpGaN1DYA(j));
    }

    /* renamed from: roundToPx--R2X_6o */
    default int mo693roundToPxR2X_6o(long j) {
        return Math.round(mo699toPxR2X_6o(j));
    }

    /* renamed from: toDp-u2uoSUM */
    default float mo697toDpu2uoSUM(int i) {
        return Dp.m6989constructorimpl(i / getDensity());
    }

    /* renamed from: toSp-kPz2Gy4 */
    default long mo704toSpkPz2Gy4(int i) {
        return mo702toSp0xMU5do(mo697toDpu2uoSUM(i));
    }

    /* renamed from: toDp-u2uoSUM */
    default float mo696toDpu2uoSUM(float f) {
        return Dp.m6989constructorimpl(f / getDensity());
    }

    /* renamed from: toSp-kPz2Gy4 */
    default long mo703toSpkPz2Gy4(float f) {
        return mo702toSp0xMU5do(mo696toDpu2uoSUM(f));
    }

    default Rect toRect(DpRect dpRect) {
        return new Rect(mo700toPx0680j_4(dpRect.m7072getLeftD9Ej5fM()), mo700toPx0680j_4(dpRect.m7074getTopD9Ej5fM()), mo700toPx0680j_4(dpRect.m7073getRightD9Ej5fM()), mo700toPx0680j_4(dpRect.m7071getBottomD9Ej5fM()));
    }

    /* renamed from: toSize-XkaWNTQ */
    default long mo701toSizeXkaWNTQ(long j) {
        if (j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
            float mo700toPx0680j_4 = mo700toPx0680j_4(DpSize.m7087getWidthD9Ej5fM(j));
            float mo700toPx0680j_42 = mo700toPx0680j_4(DpSize.m7085getHeightD9Ej5fM(j));
            return Size.m4185constructorimpl((Float.floatToRawIntBits(mo700toPx0680j_4) << 32) | (Float.floatToRawIntBits(mo700toPx0680j_42) & 4294967295L));
        }
        return Size.INSTANCE.m4202getUnspecifiedNHjbRc();
    }

    /* renamed from: toDpSize-k-rfVVM */
    default long mo698toDpSizekrfVVM(long j) {
        if (j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
            return DpKt.m7011DpSizeYgX7TsA(mo696toDpu2uoSUM(Float.intBitsToFloat((int) (j >> 32))), mo696toDpu2uoSUM(Float.intBitsToFloat((int) (j & 4294967295L))));
        }
        return DpSize.INSTANCE.m7096getUnspecifiedMYxV2XQ();
    }
}
