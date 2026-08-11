package uz.FonRo.pos.ui.stats;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.StoreStats;
import uz.FonRo.pos.ui.nav.Routes;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StatsScreen.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0002\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\u0005\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\u0006\u0010\u0019\u001a\u00020\u000f¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR#\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0011\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0011\u0010\u0012\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0015\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u0011\u0010\u0016\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010#R\u0011\u0010\u0017\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\u0011\u0010\u0018\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b.\u0010#R\u0011\u0010\u0019\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%¨\u00060"}, d2 = {"Luz/FonRo/pos/ui/stats/StatsModel;", "", Routes.STATS, "Luz/FonRo/pos/data/model/StoreStats;", "buckets", "", "Luz/FonRo/pos/ui/stats/Bucket;", "summary", "Luz/FonRo/pos/ui/stats/SummaryRow;", "debtors", "Lkotlin/Pair;", "", "", "totalQty", "lowStock", "", "outOfStock", "stockUnits", "stockValue", "canPurchase", "", "auditDiff", "netRevenue", "netSalesProfit", "avgCheck", "periodDays", "<init>", "(Luz/FonRo/pos/data/model/StoreStats;Ljava/util/List;Ljava/util/List;Ljava/util/List;DIIDDZDDDDI)V", "getStats", "()Luz/FonRo/pos/data/model/StoreStats;", "getBuckets", "()Ljava/util/List;", "getSummary", "getDebtors", "getTotalQty", "()D", "getLowStock", "()I", "getOutOfStock", "getStockUnits", "getStockValue", "getCanPurchase", "()Z", "getAuditDiff", "getNetRevenue", "getNetSalesProfit", "getAvgCheck", "getPeriodDays", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class StatsModel {
    private final double auditDiff;
    private final double avgCheck;
    private final List<Bucket> buckets;
    private final boolean canPurchase;
    private final List<Pair<String, Double>> debtors;
    private final int lowStock;
    private final double netRevenue;
    private final double netSalesProfit;
    private final int outOfStock;
    private final int periodDays;
    private final StoreStats stats;
    private final double stockUnits;
    private final double stockValue;
    private final List<SummaryRow> summary;
    private final double totalQty;

    public StatsModel(StoreStats stats, List<Bucket> buckets, List<SummaryRow> summary, List<Pair<String, Double>> debtors, double d, int i, int i2, double d2, double d3, boolean z, double d4, double d5, double d6, double d7, int i3) {
        Intrinsics.checkNotNullParameter(stats, "stats");
        Intrinsics.checkNotNullParameter(buckets, "buckets");
        Intrinsics.checkNotNullParameter(summary, "summary");
        Intrinsics.checkNotNullParameter(debtors, "debtors");
        this.stats = stats;
        this.buckets = buckets;
        this.summary = summary;
        this.debtors = debtors;
        this.totalQty = d;
        this.lowStock = i;
        this.outOfStock = i2;
        this.stockUnits = d2;
        this.stockValue = d3;
        this.canPurchase = z;
        this.auditDiff = d4;
        this.netRevenue = d5;
        this.netSalesProfit = d6;
        this.avgCheck = d7;
        this.periodDays = i3;
    }

    public final StoreStats getStats() {
        return this.stats;
    }

    public final List<Bucket> getBuckets() {
        return this.buckets;
    }

    public final List<SummaryRow> getSummary() {
        return this.summary;
    }

    public final List<Pair<String, Double>> getDebtors() {
        return this.debtors;
    }

    public final double getTotalQty() {
        return this.totalQty;
    }

    public final int getLowStock() {
        return this.lowStock;
    }

    public final int getOutOfStock() {
        return this.outOfStock;
    }

    public final double getStockUnits() {
        return this.stockUnits;
    }

    public final double getStockValue() {
        return this.stockValue;
    }

    public final boolean getCanPurchase() {
        return this.canPurchase;
    }

    public final double getAuditDiff() {
        return this.auditDiff;
    }

    public final double getNetRevenue() {
        return this.netRevenue;
    }

    public final double getNetSalesProfit() {
        return this.netSalesProfit;
    }

    public final double getAvgCheck() {
        return this.avgCheck;
    }

    public final int getPeriodDays() {
        return this.periodDays;
    }
}
