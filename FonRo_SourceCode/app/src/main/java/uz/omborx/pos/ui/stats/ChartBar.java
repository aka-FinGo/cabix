package uz.FonRo.pos.ui.stats;

import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: Charts.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJ$\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001a"}, d2 = {"Luz/FonRo/pos/ui/stats/ChartBar;", "", "value", "", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Color;", "<init>", "(DJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue", "()D", "getColor-0d7_KjU", "()J", "J", "component1", "component2", "component2-0d7_KjU", "copy", "copy-4WTKRHQ", "(DJ)Luz/FonRo/pos/ui/stats/ChartBar;", "equals", "", WriteOffReason.OTHER, "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class ChartBar {
    public static final int $stable = 0;
    private final long color;
    private final double value;

    public /* synthetic */ ChartBar(double d, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, j);
    }

    /* renamed from: copy-4WTKRHQ$default, reason: not valid java name */
    public static /* synthetic */ ChartBar m10148copy4WTKRHQ$default(ChartBar chartBar, double d, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            d = chartBar.value;
        }
        if ((i & 2) != 0) {
            j = chartBar.color;
        }
        return chartBar.m10150copy4WTKRHQ(d, j);
    }

    /* renamed from: component1, reason: from getter */
    public final double getValue() {
        return this.value;
    }

    /* renamed from: component2-0d7_KjU, reason: not valid java name and from getter */
    public final long getColor() {
        return this.color;
    }

    /* renamed from: copy-4WTKRHQ, reason: not valid java name */
    public final ChartBar m10150copy4WTKRHQ(double value, long color) {
        return new ChartBar(value, color, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChartBar)) {
            return false;
        }
        ChartBar chartBar = (ChartBar) other;
        return Double.compare(this.value, chartBar.value) == 0 && Color.m4385equalsimpl0(this.color, chartBar.color);
    }

    public int hashCode() {
        return (Double.hashCode(this.value) * 31) + Color.m4391hashCodeimpl(this.color);
    }

    public String toString() {
        return "ChartBar(value=" + this.value + ", color=" + Color.m4392toStringimpl(this.color) + ")";
    }

    private ChartBar(double d, long j) {
        this.value = d;
        this.color = j;
    }

    /* renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m10151getColor0d7_KjU() {
        return this.color;
    }

    public final double getValue() {
        return this.value;
    }
}
