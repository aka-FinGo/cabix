package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: TouchBoundsExpansion.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001)B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010\u0011\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000bJ\u0016\u0010\u0013\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u000bJ\u0016\u0010\u0015\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u000bJ\u0016\u0010\u0017\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u000bJ\t\u0010\u0019\u001a\u00020\bHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u001b\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\t\u0010'\u001a\u00020(HÖ\u0001R\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, d2 = {"Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "isLayoutDirectionAware", "", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM", "()F", "F", "getEnd-D9Ej5fM", "()Z", "getStart-D9Ej5fM", "getTop-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "component3", "component3-D9Ej5fM", "component4", "component4-D9Ej5fM", "component5", "copy", "copy-lDy3nrA", "(FFFFZ)Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "equals", WriteOffReason.OTHER, "hashCode", "", "roundToTouchBoundsExpansion", "Landroidx/compose/ui/node/TouchBoundsExpansion;", "density", "Landroidx/compose/ui/unit/Density;", "roundToTouchBoundsExpansion-TW6G1oQ", "(Landroidx/compose/ui/unit/Density;)J", "toString", "", "Companion", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final /* data */ class DpTouchBoundsExpansion {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final float bottom;
    private final float end;
    private final boolean isLayoutDirectionAware;
    private final float start;
    private final float top;

    public /* synthetic */ DpTouchBoundsExpansion(float f, float f2, float f3, float f4, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z);
    }

    /* renamed from: copy-lDy3nrA$default, reason: not valid java name */
    public static /* synthetic */ DpTouchBoundsExpansion m5880copylDy3nrA$default(DpTouchBoundsExpansion dpTouchBoundsExpansion, float f, float f2, float f3, float f4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            f = dpTouchBoundsExpansion.start;
        }
        if ((i & 2) != 0) {
            f2 = dpTouchBoundsExpansion.top;
        }
        if ((i & 4) != 0) {
            f3 = dpTouchBoundsExpansion.end;
        }
        if ((i & 8) != 0) {
            f4 = dpTouchBoundsExpansion.bottom;
        }
        if ((i & 16) != 0) {
            z = dpTouchBoundsExpansion.isLayoutDirectionAware;
        }
        boolean z2 = z;
        float f5 = f3;
        return dpTouchBoundsExpansion.m5885copylDy3nrA(f, f2, f5, f4, z2);
    }

    /* renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
    public final float getStart() {
        return this.start;
    }

    /* renamed from: component2-D9Ej5fM, reason: not valid java name and from getter */
    public final float getTop() {
        return this.top;
    }

    /* renamed from: component3-D9Ej5fM, reason: not valid java name and from getter */
    public final float getEnd() {
        return this.end;
    }

    /* renamed from: component4-D9Ej5fM, reason: not valid java name and from getter */
    public final float getBottom() {
        return this.bottom;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsLayoutDirectionAware() {
        return this.isLayoutDirectionAware;
    }

    /* renamed from: copy-lDy3nrA, reason: not valid java name */
    public final DpTouchBoundsExpansion m5885copylDy3nrA(float start, float top, float end, float bottom, boolean isLayoutDirectionAware) {
        return new DpTouchBoundsExpansion(start, top, end, bottom, isLayoutDirectionAware, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DpTouchBoundsExpansion)) {
            return false;
        }
        DpTouchBoundsExpansion dpTouchBoundsExpansion = (DpTouchBoundsExpansion) other;
        return Dp.m6994equalsimpl0(this.start, dpTouchBoundsExpansion.start) && Dp.m6994equalsimpl0(this.top, dpTouchBoundsExpansion.top) && Dp.m6994equalsimpl0(this.end, dpTouchBoundsExpansion.end) && Dp.m6994equalsimpl0(this.bottom, dpTouchBoundsExpansion.bottom) && this.isLayoutDirectionAware == dpTouchBoundsExpansion.isLayoutDirectionAware;
    }

    public int hashCode() {
        return (((((((Dp.m6995hashCodeimpl(this.start) * 31) + Dp.m6995hashCodeimpl(this.top)) * 31) + Dp.m6995hashCodeimpl(this.end)) * 31) + Dp.m6995hashCodeimpl(this.bottom)) * 31) + Boolean.hashCode(this.isLayoutDirectionAware);
    }

    public String toString() {
        return "DpTouchBoundsExpansion(start=" + ((Object) Dp.m7000toStringimpl(this.start)) + ", top=" + ((Object) Dp.m7000toStringimpl(this.top)) + ", end=" + ((Object) Dp.m7000toStringimpl(this.end)) + ", bottom=" + ((Object) Dp.m7000toStringimpl(this.bottom)) + ", isLayoutDirectionAware=" + this.isLayoutDirectionAware + ')';
    }

    private DpTouchBoundsExpansion(float f, float f2, float f3, float f4, boolean z) {
        this.start = f;
        this.top = f2;
        this.end = f3;
        this.bottom = f4;
        this.isLayoutDirectionAware = z;
        if (!(f >= 0.0f)) {
            InlineClassHelperKt.throwIllegalArgumentException("Left must be non-negative");
        }
        if (!(f2 >= 0.0f)) {
            InlineClassHelperKt.throwIllegalArgumentException("Top must be non-negative");
        }
        if (!(f3 >= 0.0f)) {
            InlineClassHelperKt.throwIllegalArgumentException("Right must be non-negative");
        }
        if (f4 >= 0.0f) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Bottom must be non-negative");
    }

    /* renamed from: getStart-D9Ej5fM, reason: not valid java name */
    public final float m5888getStartD9Ej5fM() {
        return this.start;
    }

    /* renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m5889getTopD9Ej5fM() {
        return this.top;
    }

    /* renamed from: getEnd-D9Ej5fM, reason: not valid java name */
    public final float m5887getEndD9Ej5fM() {
        return this.end;
    }

    /* renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m5886getBottomD9Ej5fM() {
        return this.bottom;
    }

    public final boolean isLayoutDirectionAware() {
        return this.isLayoutDirectionAware;
    }

    /* renamed from: roundToTouchBoundsExpansion-TW6G1oQ, reason: not valid java name */
    public final long m5890roundToTouchBoundsExpansionTW6G1oQ(Density density) {
        return TouchBoundsExpansion.m6076constructorimpl(TouchBoundsExpansion.INSTANCE.pack$ui_release(density.mo694roundToPx0680j_4(this.start), density.mo694roundToPx0680j_4(this.top), density.mo694roundToPx0680j_4(this.end), density.mo694roundToPx0680j_4(this.bottom), this.isLayoutDirectionAware));
    }

    /* compiled from: TouchBoundsExpansion.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"Landroidx/compose/ui/node/DpTouchBoundsExpansion$Companion;", "", "()V", "Absolute", "Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "left", "Landroidx/compose/ui/unit/Dp;", "top", "right", "bottom", "Absolute-a9UjIt4", "(FFFF)Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: Absolute-a9UjIt4, reason: not valid java name */
        public final DpTouchBoundsExpansion m5892Absolutea9UjIt4(float left, float top, float right, float bottom) {
            return new DpTouchBoundsExpansion(left, top, right, bottom, false, null);
        }

        /* renamed from: Absolute-a9UjIt4$default, reason: not valid java name */
        public static /* synthetic */ DpTouchBoundsExpansion m5891Absolutea9UjIt4$default(Companion companion, float f, float f2, float f3, float f4, int i, Object obj) {
            if ((i & 1) != 0) {
                f = Dp.m6989constructorimpl(0.0f);
            }
            if ((i & 2) != 0) {
                f2 = Dp.m6989constructorimpl(0.0f);
            }
            if ((i & 4) != 0) {
                f3 = Dp.m6989constructorimpl(0.0f);
            }
            if ((i & 8) != 0) {
                f4 = Dp.m6989constructorimpl(0.0f);
            }
            return companion.m5892Absolutea9UjIt4(f, f2, f3, f4);
        }
    }
}
