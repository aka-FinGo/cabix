package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Rect;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SelectionMode.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ*\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\f*\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014j\u0002\b\u0015j\u0002\b\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionMode;", "", "(Ljava/lang/String;I)V", "compare", "", "position", "Landroidx/compose/ui/geometry/Offset;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "compare-3MmeM6k$foundation_release", "(JLandroidx/compose/ui/geometry/Rect;)I", "isSelected", "", "start", "end", "isSelected-2x9bVx0$foundation_release", "(Landroidx/compose/ui/geometry/Rect;JJ)Z", "containsInclusive", TypedValues.CycleType.S_WAVE_OFFSET, "containsInclusive-Uv8p0NA", "(Landroidx/compose/ui/geometry/Rect;J)Z", "Vertical", "Horizontal", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public abstract class SelectionMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SelectionMode[] $VALUES;
    public static final SelectionMode Vertical = new SelectionMode("Vertical", 0) { // from class: androidx.compose.foundation.text.selection.SelectionMode.Vertical
        {
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // androidx.compose.foundation.text.selection.SelectionMode
        /* renamed from: compare-3MmeM6k$foundation_release */
        public int mo1814compare3MmeM6k$foundation_release(long position, Rect bounds) {
            if (SelectionManagerKt.m1807containsInclusiveUv8p0NA(bounds, position)) {
                return 0;
            }
            int i = (int) (4294967295L & position);
            if (Float.intBitsToFloat(i) < bounds.getTop()) {
                return -1;
            }
            return (Float.intBitsToFloat((int) (position >> 32)) >= bounds.getLeft() || Float.intBitsToFloat(i) >= bounds.getBottom()) ? 1 : -1;
        }
    };
    public static final SelectionMode Horizontal = new SelectionMode("Horizontal", 1) { // from class: androidx.compose.foundation.text.selection.SelectionMode.Horizontal
        {
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // androidx.compose.foundation.text.selection.SelectionMode
        /* renamed from: compare-3MmeM6k$foundation_release */
        public int mo1814compare3MmeM6k$foundation_release(long position, Rect bounds) {
            if (SelectionManagerKt.m1807containsInclusiveUv8p0NA(bounds, position)) {
                return 0;
            }
            int i = (int) (position >> 32);
            if (Float.intBitsToFloat(i) < bounds.getLeft()) {
                return -1;
            }
            return (Float.intBitsToFloat((int) (position & 4294967295L)) >= bounds.getTop() || Float.intBitsToFloat(i) >= bounds.getRight()) ? 1 : -1;
        }
    };

    private static final /* synthetic */ SelectionMode[] $values() {
        return new SelectionMode[]{Vertical, Horizontal};
    }

    public /* synthetic */ SelectionMode(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i);
    }

    public static EnumEntries<SelectionMode> getEntries() {
        return $ENTRIES;
    }

    public static SelectionMode valueOf(String str) {
        return (SelectionMode) Enum.valueOf(SelectionMode.class, str);
    }

    public static SelectionMode[] values() {
        return (SelectionMode[]) $VALUES.clone();
    }

    /* renamed from: compare-3MmeM6k$foundation_release, reason: not valid java name */
    public abstract int mo1814compare3MmeM6k$foundation_release(long position, Rect bounds);

    private SelectionMode(String str, int i) {
    }

    static {
        SelectionMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    /* renamed from: isSelected-2x9bVx0$foundation_release, reason: not valid java name */
    public final boolean m1815isSelected2x9bVx0$foundation_release(Rect bounds, long start, long end) {
        if (m1813containsInclusiveUv8p0NA(bounds, start) || m1813containsInclusiveUv8p0NA(bounds, end)) {
            return true;
        }
        return (mo1814compare3MmeM6k$foundation_release(start, bounds) > 0) ^ (mo1814compare3MmeM6k$foundation_release(end, bounds) > 0);
    }

    /* renamed from: containsInclusive-Uv8p0NA, reason: not valid java name */
    private final boolean m1813containsInclusiveUv8p0NA(Rect rect, long j) {
        float left = rect.getLeft();
        float right = rect.getRight();
        float intBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        if (left > intBitsToFloat || intBitsToFloat > right) {
            return false;
        }
        float top = rect.getTop();
        float bottom = rect.getBottom();
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        return top <= intBitsToFloat2 && intBitsToFloat2 <= bottom;
    }
}
