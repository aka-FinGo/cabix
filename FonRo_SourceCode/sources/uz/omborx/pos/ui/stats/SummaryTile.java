package uz.FonRo.pos.ui.stats;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StatsScreen.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0011"}, d2 = {"Luz/FonRo/pos/ui/stats/SummaryTile;", "", "symbol", "", "tint", "Landroidx/compose/ui/graphics/Color;", "value", "label", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSymbol", "()Ljava/lang/String;", "getTint-0d7_KjU", "()J", "J", "getValue", "getLabel", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class SummaryTile {
    private final String label;
    private final String symbol;
    private final long tint;
    private final String value;

    public /* synthetic */ SummaryTile(String str, long j, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, str2, str3);
    }

    private SummaryTile(String symbol, long j, String value, String label) {
        Intrinsics.checkNotNullParameter(symbol, "symbol");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(label, "label");
        this.symbol = symbol;
        this.tint = j;
        this.value = value;
        this.label = label;
    }

    public final String getSymbol() {
        return this.symbol;
    }

    /* renamed from: getTint-0d7_KjU, reason: not valid java name and from getter */
    public final long getTint() {
        return this.tint;
    }

    public final String getValue() {
        return this.value;
    }

    public final String getLabel() {
        return this.label;
    }
}
