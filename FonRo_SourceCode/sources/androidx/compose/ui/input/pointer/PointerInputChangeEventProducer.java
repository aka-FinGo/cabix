package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PointerInputEventProcessor.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer;", "", "()V", "previousPointerInputData", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer$PointerInputData;", "clear", "", "produce", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "pointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "PointerInputData", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class PointerInputChangeEventProducer {
    private final LongSparseArray<PointerInputData> previousPointerInputData = new LongSparseArray<>(0, 1, null);

    public final InternalPointerEvent produce(PointerInputEvent pointerInputEvent, PositionCalculator positionCalculator) {
        long uptime;
        boolean down;
        long mo5688screenToLocalMKHz9U;
        LongSparseArray longSparseArray = new LongSparseArray(pointerInputEvent.getPointers().size());
        List<PointerInputEventData> pointers = pointerInputEvent.getPointers();
        int size = pointers.size();
        for (int i = 0; i < size; i++) {
            PointerInputEventData pointerInputEventData = pointers.get(i);
            PointerInputData pointerInputData = this.previousPointerInputData.get(pointerInputEventData.m5621getIdJ3iCeTQ());
            if (pointerInputData == null) {
                down = false;
                uptime = pointerInputEventData.getUptime();
                mo5688screenToLocalMKHz9U = pointerInputEventData.m5623getPositionF1C5BW0();
            } else {
                uptime = pointerInputData.getUptime();
                down = pointerInputData.getDown();
                mo5688screenToLocalMKHz9U = positionCalculator.mo5688screenToLocalMKHz9U(pointerInputData.getPositionOnScreen());
            }
            longSparseArray.put(pointerInputEventData.m5621getIdJ3iCeTQ(), new PointerInputChange(pointerInputEventData.m5621getIdJ3iCeTQ(), pointerInputEventData.getUptime(), pointerInputEventData.m5623getPositionF1C5BW0(), pointerInputEventData.getDown(), pointerInputEventData.getPressure(), uptime, mo5688screenToLocalMKHz9U, down, false, pointerInputEventData.m5626getTypeT8wyACA(), pointerInputEventData.getHistorical(), pointerInputEventData.m5625getScrollDeltaF1C5BW0(), pointerInputEventData.m5622getOriginalEventPositionF1C5BW0(), null));
            boolean down2 = pointerInputEventData.getDown();
            LongSparseArray<PointerInputData> longSparseArray2 = this.previousPointerInputData;
            if (down2) {
                longSparseArray2.put(pointerInputEventData.m5621getIdJ3iCeTQ(), new PointerInputData(pointerInputEventData.getUptime(), pointerInputEventData.m5624getPositionOnScreenF1C5BW0(), pointerInputEventData.getDown(), null));
            } else {
                longSparseArray2.remove(pointerInputEventData.m5621getIdJ3iCeTQ());
            }
        }
        return new InternalPointerEvent(longSparseArray, pointerInputEvent);
    }

    public final void clear() {
        this.previousPointerInputData.clear();
    }

    /* compiled from: PointerInputEventProcessor.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer$PointerInputData;", "", "uptime", "", "positionOnScreen", "Landroidx/compose/ui/geometry/Offset;", "down", "", "(JJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDown", "()Z", "getPositionOnScreen-F1C5BW0", "()J", "J", "getUptime", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    private static final class PointerInputData {
        private final boolean down;
        private final long positionOnScreen;
        private final long uptime;

        public /* synthetic */ PointerInputData(long j, long j2, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2, z);
        }

        private PointerInputData(long j, long j2, boolean z) {
            this.uptime = j;
            this.positionOnScreen = j2;
            this.down = z;
        }

        public final long getUptime() {
            return this.uptime;
        }

        /* renamed from: getPositionOnScreen-F1C5BW0, reason: not valid java name and from getter */
        public final long getPositionOnScreen() {
            return this.positionOnScreen;
        }

        public final boolean getDown() {
            return this.down;
        }
    }
}
