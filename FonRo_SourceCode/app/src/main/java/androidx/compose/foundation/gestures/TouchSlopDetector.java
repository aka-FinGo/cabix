package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DragGestureDetector.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J#\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0014\u0010\u0017\u001a\u00020\u000f*\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u000f*\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u0005X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/gestures/TouchSlopDetector;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "initialPositionChange", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/foundation/gestures/Orientation;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "totalPositionChange", "J", "addPointerInputChange", "dragEvent", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "touchSlop", "", "addPointerInputChange-dBAh8RU", "(Landroidx/compose/ui/input/pointer/PointerInputChange;F)J", "calculatePostSlopOffset", "calculatePostSlopOffset-tuRUvjQ", "(F)J", "reset", "", "crossAxis", "crossAxis-k-4lQ0M", "(J)F", "mainAxis", "mainAxis-k-4lQ0M", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TouchSlopDetector {
    public static final int $stable = 8;
    private final Orientation orientation;
    private long totalPositionChange;

    public /* synthetic */ TouchSlopDetector(Orientation orientation, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(orientation, j);
    }

    private TouchSlopDetector(Orientation orientation, long j) {
        this.orientation = orientation;
        this.totalPositionChange = j;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public /* synthetic */ TouchSlopDetector(Orientation orientation, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : orientation, (i & 2) != 0 ? Offset.INSTANCE.m4141getZeroF1C5BW0() : j, null);
    }

    /* renamed from: mainAxis-k-4lQ0M, reason: not valid java name */
    public final float m847mainAxisk4lQ0M(long j) {
        return Float.intBitsToFloat((int) (this.orientation == Orientation.Horizontal ? j >> 32 : j & 4294967295L));
    }

    /* renamed from: crossAxis-k-4lQ0M, reason: not valid java name */
    public final float m846crossAxisk4lQ0M(long j) {
        return Float.intBitsToFloat((int) (this.orientation == Orientation.Horizontal ? j & 4294967295L : j >> 32));
    }

    /* renamed from: addPointerInputChange-dBAh8RU, reason: not valid java name */
    public final long m845addPointerInputChangedBAh8RU(PointerInputChange dragEvent, float touchSlop) {
        float abs;
        long m4130plusMKHz9U = Offset.m4130plusMKHz9U(this.totalPositionChange, Offset.m4129minusMKHz9U(dragEvent.getPosition(), dragEvent.getPreviousPosition()));
        this.totalPositionChange = m4130plusMKHz9U;
        if (this.orientation == null) {
            abs = Offset.m4123getDistanceimpl(m4130plusMKHz9U);
        } else {
            abs = Math.abs(m847mainAxisk4lQ0M(m4130plusMKHz9U));
        }
        if (abs >= touchSlop) {
            return m844calculatePostSlopOffsettuRUvjQ(touchSlop);
        }
        return Offset.INSTANCE.m4140getUnspecifiedF1C5BW0();
    }

    public final void reset() {
        this.totalPositionChange = Offset.INSTANCE.m4141getZeroF1C5BW0();
    }

    /* renamed from: calculatePostSlopOffset-tuRUvjQ, reason: not valid java name */
    private final long m844calculatePostSlopOffsettuRUvjQ(float touchSlop) {
        Orientation orientation = this.orientation;
        long j = this.totalPositionChange;
        if (orientation == null) {
            return Offset.m4129minusMKHz9U(this.totalPositionChange, Offset.m4132timestuRUvjQ(Offset.m4120divtuRUvjQ(j, Offset.m4123getDistanceimpl(j)), touchSlop));
        }
        float m847mainAxisk4lQ0M = m847mainAxisk4lQ0M(j) - (Math.signum(m847mainAxisk4lQ0M(this.totalPositionChange)) * touchSlop);
        float m846crossAxisk4lQ0M = m846crossAxisk4lQ0M(this.totalPositionChange);
        if (this.orientation == Orientation.Horizontal) {
            return Offset.m4117constructorimpl((Float.floatToRawIntBits(m846crossAxisk4lQ0M) & 4294967295L) | (Float.floatToRawIntBits(m847mainAxisk4lQ0M) << 32));
        }
        return Offset.m4117constructorimpl((Float.floatToRawIntBits(m846crossAxisk4lQ0M) << 32) | (Float.floatToRawIntBits(m847mainAxisk4lQ0M) & 4294967295L));
    }
}
