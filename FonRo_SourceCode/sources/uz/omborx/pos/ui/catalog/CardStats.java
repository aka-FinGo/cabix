package uz.FonRo.pos.ui.catalog;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProductCard.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t0\b\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t0\b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u001b\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t0\bHÆ\u0003J\u001b\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t0\bHÆ\u0003Ji\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t0\b2\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t0\bHÆ\u0001J\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\nHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR#\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006#"}, d2 = {"Luz/FonRo/pos/ui/catalog/CardStats;", "", "soldQuantity", "", "revenue", "profit", "returnedQuantity", "quantityPoints", "", "Lkotlin/Pair;", "", "revenuePoints", "<init>", "(DDDDLjava/util/List;Ljava/util/List;)V", "getSoldQuantity", "()D", "getRevenue", "getProfit", "getReturnedQuantity", "getQuantityPoints", "()Ljava/util/List;", "getRevenuePoints", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class CardStats {
    private final double profit;
    private final List<Pair<String, Double>> quantityPoints;
    private final double returnedQuantity;
    private final double revenue;
    private final List<Pair<String, Double>> revenuePoints;
    private final double soldQuantity;

    public static /* synthetic */ CardStats copy$default(CardStats cardStats, double d, double d2, double d3, double d4, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = cardStats.soldQuantity;
        }
        double d5 = d;
        if ((i & 2) != 0) {
            d2 = cardStats.revenue;
        }
        return cardStats.copy(d5, d2, (i & 4) != 0 ? cardStats.profit : d3, (i & 8) != 0 ? cardStats.returnedQuantity : d4, (i & 16) != 0 ? cardStats.quantityPoints : list, (i & 32) != 0 ? cardStats.revenuePoints : list2);
    }

    /* renamed from: component1, reason: from getter */
    public final double getSoldQuantity() {
        return this.soldQuantity;
    }

    /* renamed from: component2, reason: from getter */
    public final double getRevenue() {
        return this.revenue;
    }

    /* renamed from: component3, reason: from getter */
    public final double getProfit() {
        return this.profit;
    }

    /* renamed from: component4, reason: from getter */
    public final double getReturnedQuantity() {
        return this.returnedQuantity;
    }

    public final List<Pair<String, Double>> component5() {
        return this.quantityPoints;
    }

    public final List<Pair<String, Double>> component6() {
        return this.revenuePoints;
    }

    public final CardStats copy(double soldQuantity, double revenue, double profit, double returnedQuantity, List<Pair<String, Double>> quantityPoints, List<Pair<String, Double>> revenuePoints) {
        Intrinsics.checkNotNullParameter(quantityPoints, "quantityPoints");
        Intrinsics.checkNotNullParameter(revenuePoints, "revenuePoints");
        return new CardStats(soldQuantity, revenue, profit, returnedQuantity, quantityPoints, revenuePoints);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardStats)) {
            return false;
        }
        CardStats cardStats = (CardStats) other;
        return Double.compare(this.soldQuantity, cardStats.soldQuantity) == 0 && Double.compare(this.revenue, cardStats.revenue) == 0 && Double.compare(this.profit, cardStats.profit) == 0 && Double.compare(this.returnedQuantity, cardStats.returnedQuantity) == 0 && Intrinsics.areEqual(this.quantityPoints, cardStats.quantityPoints) && Intrinsics.areEqual(this.revenuePoints, cardStats.revenuePoints);
    }

    public int hashCode() {
        return (((((((((Double.hashCode(this.soldQuantity) * 31) + Double.hashCode(this.revenue)) * 31) + Double.hashCode(this.profit)) * 31) + Double.hashCode(this.returnedQuantity)) * 31) + this.quantityPoints.hashCode()) * 31) + this.revenuePoints.hashCode();
    }

    public String toString() {
        return "CardStats(soldQuantity=" + this.soldQuantity + ", revenue=" + this.revenue + ", profit=" + this.profit + ", returnedQuantity=" + this.returnedQuantity + ", quantityPoints=" + this.quantityPoints + ", revenuePoints=" + this.revenuePoints + ")";
    }

    public CardStats(double d, double d2, double d3, double d4, List<Pair<String, Double>> quantityPoints, List<Pair<String, Double>> revenuePoints) {
        Intrinsics.checkNotNullParameter(quantityPoints, "quantityPoints");
        Intrinsics.checkNotNullParameter(revenuePoints, "revenuePoints");
        this.soldQuantity = d;
        this.revenue = d2;
        this.profit = d3;
        this.returnedQuantity = d4;
        this.quantityPoints = quantityPoints;
        this.revenuePoints = revenuePoints;
    }

    public final double getSoldQuantity() {
        return this.soldQuantity;
    }

    public final double getRevenue() {
        return this.revenue;
    }

    public final double getProfit() {
        return this.profit;
    }

    public final double getReturnedQuantity() {
        return this.returnedQuantity;
    }

    public final List<Pair<String, Double>> getQuantityPoints() {
        return this.quantityPoints;
    }

    public final List<Pair<String, Double>> getRevenuePoints() {
        return this.revenuePoints;
    }
}
