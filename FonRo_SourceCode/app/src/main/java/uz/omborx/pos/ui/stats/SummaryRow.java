package uz.FonRo.pos.ui.stats;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StatsScreen.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Luz/FonRo/pos/ui/stats/SummaryRow;", "", "label", "", "value", "", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Color;", "<init>", "(Ljava/lang/String;DJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLabel", "()Ljava/lang/String;", "getValue", "()D", "getColor-0d7_KjU", "()J", "J", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class SummaryRow {
    private final long color;
    private final String label;
    private final double value;

    public /* synthetic */ SummaryRow(String str, double d, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, d, j);
    }

    private SummaryRow(String label, double d, long j) {
        Intrinsics.checkNotNullParameter(label, "label");
        this.label = label;
        this.value = d;
        this.color = j;
    }

    /* renamed from: getColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getColor() {
        return this.color;
    }

    public final String getLabel() {
        return this.label;
    }

    public final double getValue() {
        return this.value;
    }
}
