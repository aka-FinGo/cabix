package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TextLayoutResultProxy.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017J\"\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\b \u0010!J\u001a\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aH\u0000ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u001a\u0010%\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aH\u0000ø\u0001\u0000¢\u0006\u0004\b&\u0010$J\u0016\u0010'\u001a\u00020\u001a*\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010$R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"Landroidx/compose/foundation/text/TextLayoutResultProxy;", "", "value", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "decorationBoxCoordinates", "(Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;)V", "getDecorationBoxCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setDecorationBoxCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "getInnerTextFieldCoordinates", "setInnerTextFieldCoordinates", "getValue", "()Landroidx/compose/ui/text/TextLayoutResult;", "getLineEnd", "", "lineIndex", "visibleEnd", "", "getLineForVerticalPosition", "vertical", "", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "coerceInVisibleBounds", "getOffsetForPosition-3MmeM6k", "(JZ)I", "isPositionOnText", TypedValues.CycleType.S_WAVE_OFFSET, "isPositionOnText-k-4lQ0M", "(J)Z", "translateDecorationToInnerCoordinates", "translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release", "(J)J", "translateInnerToDecorationCoordinates", "translateInnerToDecorationCoordinates-MK-Hz9U$foundation_release", "coercedInVisibleBoundsOfInputText", "coercedInVisibleBoundsOfInputText-MK-Hz9U", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextLayoutResultProxy {
    public static final int $stable = 8;
    private LayoutCoordinates decorationBoxCoordinates;
    private LayoutCoordinates innerTextFieldCoordinates;
    private final TextLayoutResult value;

    public TextLayoutResultProxy(TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2) {
        this.value = textLayoutResult;
        this.innerTextFieldCoordinates = layoutCoordinates;
        this.decorationBoxCoordinates = layoutCoordinates2;
    }

    public /* synthetic */ TextLayoutResultProxy(TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textLayoutResult, (i & 2) != 0 ? null : layoutCoordinates, (i & 4) != 0 ? null : layoutCoordinates2);
    }

    public final TextLayoutResult getValue() {
        return this.value;
    }

    public final LayoutCoordinates getInnerTextFieldCoordinates() {
        return this.innerTextFieldCoordinates;
    }

    public final void setInnerTextFieldCoordinates(LayoutCoordinates layoutCoordinates) {
        this.innerTextFieldCoordinates = layoutCoordinates;
    }

    public final LayoutCoordinates getDecorationBoxCoordinates() {
        return this.decorationBoxCoordinates;
    }

    public final void setDecorationBoxCoordinates(LayoutCoordinates layoutCoordinates) {
        this.decorationBoxCoordinates = layoutCoordinates;
    }

    /* renamed from: getOffsetForPosition-3MmeM6k$default, reason: not valid java name */
    public static /* synthetic */ int m1488getOffsetForPosition3MmeM6k$default(TextLayoutResultProxy textLayoutResultProxy, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return textLayoutResultProxy.m1489getOffsetForPosition3MmeM6k(j, z);
    }

    /* renamed from: getOffsetForPosition-3MmeM6k, reason: not valid java name */
    public final int m1489getOffsetForPosition3MmeM6k(long position, boolean coerceInVisibleBounds) {
        if (coerceInVisibleBounds) {
            position = m1487coercedInVisibleBoundsOfInputTextMKHz9U(position);
        }
        return this.value.m6405getOffsetForPositionk4lQ0M(m1491translateDecorationToInnerCoordinatesMKHz9U$foundation_release(position));
    }

    public static /* synthetic */ int getLineEnd$default(TextLayoutResultProxy textLayoutResultProxy, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return textLayoutResultProxy.getLineEnd(i, z);
    }

    public final int getLineEnd(int lineIndex, boolean visibleEnd) {
        return this.value.getLineEnd(lineIndex, visibleEnd);
    }

    /* renamed from: isPositionOnText-k-4lQ0M, reason: not valid java name */
    public final boolean m1490isPositionOnTextk4lQ0M(long offset) {
        long m1491translateDecorationToInnerCoordinatesMKHz9U$foundation_release = m1491translateDecorationToInnerCoordinatesMKHz9U$foundation_release(m1487coercedInVisibleBoundsOfInputTextMKHz9U(offset));
        int lineForVerticalPosition = this.value.getLineForVerticalPosition(Float.intBitsToFloat((int) (4294967295L & m1491translateDecorationToInnerCoordinatesMKHz9U$foundation_release)));
        int i = (int) (m1491translateDecorationToInnerCoordinatesMKHz9U$foundation_release >> 32);
        return Float.intBitsToFloat(i) >= this.value.getLineLeft(lineForVerticalPosition) && Float.intBitsToFloat(i) <= this.value.getLineRight(lineForVerticalPosition);
    }

    /* renamed from: translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release, reason: not valid java name */
    public final long m1491translateDecorationToInnerCoordinatesMKHz9U$foundation_release(long offset) {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2 = this.innerTextFieldCoordinates;
        if (layoutCoordinates2 != null) {
            if (!layoutCoordinates2.isAttached()) {
                layoutCoordinates2 = null;
            }
            if (layoutCoordinates2 != null && (layoutCoordinates = this.decorationBoxCoordinates) != null) {
                LayoutCoordinates layoutCoordinates3 = layoutCoordinates.isAttached() ? layoutCoordinates : null;
                if (layoutCoordinates3 != null) {
                    return layoutCoordinates2.mo5741localPositionOfR5De75A(layoutCoordinates3, offset);
                }
            }
        }
        return offset;
    }

    /* renamed from: translateInnerToDecorationCoordinates-MK-Hz9U$foundation_release, reason: not valid java name */
    public final long m1492translateInnerToDecorationCoordinatesMKHz9U$foundation_release(long offset) {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2 = this.innerTextFieldCoordinates;
        if (layoutCoordinates2 != null) {
            if (!layoutCoordinates2.isAttached()) {
                layoutCoordinates2 = null;
            }
            if (layoutCoordinates2 != null && (layoutCoordinates = this.decorationBoxCoordinates) != null) {
                LayoutCoordinates layoutCoordinates3 = layoutCoordinates.isAttached() ? layoutCoordinates : null;
                if (layoutCoordinates3 != null) {
                    return layoutCoordinates3.mo5741localPositionOfR5De75A(layoutCoordinates2, offset);
                }
            }
        }
        return offset;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
    
        if (r1 == null) goto L11;
     */
    /* renamed from: coercedInVisibleBoundsOfInputText-MK-Hz9U, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long m1487coercedInVisibleBoundsOfInputTextMKHz9U(long r5) {
        /*
            r4 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r4.innerTextFieldCoordinates
            if (r0 == 0) goto L1e
            boolean r1 = r0.isAttached()
            if (r1 == 0) goto L16
            androidx.compose.ui.layout.LayoutCoordinates r4 = r4.decorationBoxCoordinates
            r1 = 0
            if (r4 == 0) goto L1c
            r2 = 0
            r3 = 2
            androidx.compose.ui.geometry.Rect r1 = androidx.compose.ui.layout.LayoutCoordinates.localBoundingBoxOf$default(r4, r0, r2, r3, r1)
            goto L1c
        L16:
            androidx.compose.ui.geometry.Rect$Companion r4 = androidx.compose.ui.geometry.Rect.INSTANCE
            androidx.compose.ui.geometry.Rect r1 = r4.getZero()
        L1c:
            if (r1 != 0) goto L24
        L1e:
            androidx.compose.ui.geometry.Rect$Companion r4 = androidx.compose.ui.geometry.Rect.INSTANCE
            androidx.compose.ui.geometry.Rect r1 = r4.getZero()
        L24:
            long r4 = androidx.compose.foundation.text.TextLayoutResultProxyKt.m1493access$coerceIn3MmeM6k(r5, r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextLayoutResultProxy.m1487coercedInVisibleBoundsOfInputTextMKHz9U(long):long");
    }

    public final int getLineForVerticalPosition(float vertical) {
        return this.value.getLineForVerticalPosition(Float.intBitsToFloat((int) (m1491translateDecorationToInnerCoordinatesMKHz9U$foundation_release(m1487coercedInVisibleBoundsOfInputTextMKHz9U(Offset.m4117constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(vertical) & 4294967295L)))) & 4294967295L)));
    }
}
