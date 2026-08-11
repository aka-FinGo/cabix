package uz.FonRo.pos.ui.money;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: HistoryScreen.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\u0089\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0001J\u0014\u00104\u001a\u00020$2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00106\u001a\u000207HÖ\u0081\u0004J\n\u00108\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&Ê\u0001\f\b:\u0012\b\b;\u0012\u0004\b\u0003\u0010\u0000¨\u00069"}, d2 = {"Luz/FonRo/pos/ui/money/ItemAgg;", "", "key", "", "name", "unit", "qty", "", "retQty", "revenue", "retAmount", "profit", "netQty", "netRevenue", "netProfit", "sales", "", "Luz/FonRo/pos/ui/money/ItemSale;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDDDDDDDLjava/util/List;)V", "getKey", "()Ljava/lang/String;", "getName", "getUnit", "getQty", "()D", "getRetQty", "getRevenue", "getRetAmount", "getProfit", "getNetQty", "getNetRevenue", "getNetProfit", "getSales", "()Ljava/util/List;", "hasReturn", "", "getHasReturn", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", WriteOffReason.OTHER, "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class ItemAgg {
    public static final int $stable = 8;
    private final String key;
    private final String name;
    private final double netProfit;
    private final double netQty;
    private final double netRevenue;
    private final double profit;
    private final double qty;
    private final double retAmount;
    private final double retQty;
    private final double revenue;
    private final List<ItemSale> sales;
    private final String unit;

    /* renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component10, reason: from getter */
    public final double getNetRevenue() {
        return this.netRevenue;
    }

    /* renamed from: component11, reason: from getter */
    public final double getNetProfit() {
        return this.netProfit;
    }

    public final List<ItemSale> component12() {
        return this.sales;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUnit() {
        return this.unit;
    }

    /* renamed from: component4, reason: from getter */
    public final double getQty() {
        return this.qty;
    }

    /* renamed from: component5, reason: from getter */
    public final double getRetQty() {
        return this.retQty;
    }

    /* renamed from: component6, reason: from getter */
    public final double getRevenue() {
        return this.revenue;
    }

    /* renamed from: component7, reason: from getter */
    public final double getRetAmount() {
        return this.retAmount;
    }

    /* renamed from: component8, reason: from getter */
    public final double getProfit() {
        return this.profit;
    }

    /* renamed from: component9, reason: from getter */
    public final double getNetQty() {
        return this.netQty;
    }

    public final ItemAgg copy(String key, String name, String unit, double qty, double retQty, double revenue, double retAmount, double profit, double netQty, double netRevenue, double netProfit, List<ItemSale> sales) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(sales, "sales");
        return new ItemAgg(key, name, unit, qty, retQty, revenue, retAmount, profit, netQty, netRevenue, netProfit, sales);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemAgg)) {
            return false;
        }
        ItemAgg itemAgg = (ItemAgg) other;
        return Intrinsics.areEqual(this.key, itemAgg.key) && Intrinsics.areEqual(this.name, itemAgg.name) && Intrinsics.areEqual(this.unit, itemAgg.unit) && Double.compare(this.qty, itemAgg.qty) == 0 && Double.compare(this.retQty, itemAgg.retQty) == 0 && Double.compare(this.revenue, itemAgg.revenue) == 0 && Double.compare(this.retAmount, itemAgg.retAmount) == 0 && Double.compare(this.profit, itemAgg.profit) == 0 && Double.compare(this.netQty, itemAgg.netQty) == 0 && Double.compare(this.netRevenue, itemAgg.netRevenue) == 0 && Double.compare(this.netProfit, itemAgg.netProfit) == 0 && Intrinsics.areEqual(this.sales, itemAgg.sales);
    }

    public int hashCode() {
        int hashCode = ((this.key.hashCode() * 31) + this.name.hashCode()) * 31;
        String str = this.unit;
        return ((((((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Double.hashCode(this.qty)) * 31) + Double.hashCode(this.retQty)) * 31) + Double.hashCode(this.revenue)) * 31) + Double.hashCode(this.retAmount)) * 31) + Double.hashCode(this.profit)) * 31) + Double.hashCode(this.netQty)) * 31) + Double.hashCode(this.netRevenue)) * 31) + Double.hashCode(this.netProfit)) * 31) + this.sales.hashCode();
    }

    public String toString() {
        return "ItemAgg(key=" + this.key + ", name=" + this.name + ", unit=" + this.unit + ", qty=" + this.qty + ", retQty=" + this.retQty + ", revenue=" + this.revenue + ", retAmount=" + this.retAmount + ", profit=" + this.profit + ", netQty=" + this.netQty + ", netRevenue=" + this.netRevenue + ", netProfit=" + this.netProfit + ", sales=" + this.sales + ")";
    }

    public ItemAgg(String key, String name, String str, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, List<ItemSale> sales) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(sales, "sales");
        this.key = key;
        this.name = name;
        this.unit = str;
        this.qty = d;
        this.retQty = d2;
        this.revenue = d3;
        this.retAmount = d4;
        this.profit = d5;
        this.netQty = d6;
        this.netRevenue = d7;
        this.netProfit = d8;
        this.sales = sales;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUnit() {
        return this.unit;
    }

    public final double getQty() {
        return this.qty;
    }

    public final double getRetQty() {
        return this.retQty;
    }

    public final double getRevenue() {
        return this.revenue;
    }

    public final double getRetAmount() {
        return this.retAmount;
    }

    public final double getProfit() {
        return this.profit;
    }

    public final double getNetQty() {
        return this.netQty;
    }

    public final double getNetRevenue() {
        return this.netRevenue;
    }

    public final double getNetProfit() {
        return this.netProfit;
    }

    public final List<ItemSale> getSales() {
        return this.sales;
    }

    public final boolean getHasReturn() {
        return this.retQty > 0.001d;
    }
}
