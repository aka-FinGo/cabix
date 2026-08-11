package uz.FonRo.pos.ui.money;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HistoryScreen.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\u001b\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R!\u0010!\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Luz/FonRo/pos/ui/money/ItemAccum;", "", "key", "", "name", "unit", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getName", "getUnit", "qty", "", "getQty", "()D", "setQty", "(D)V", "retQty", "getRetQty", "setRetQty", "revenue", "getRevenue", "setRevenue", "retAmount", "getRetAmount", "setRetAmount", "profit", "getProfit", "setProfit", "retProfit", "getRetProfit", "setRetProfit", "sales", "Ljava/util/ArrayList;", "Luz/FonRo/pos/ui/money/ItemSale;", "Lkotlin/collections/ArrayList;", "getSales", "()Ljava/util/ArrayList;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
final class ItemAccum {
    private final String key;
    private final String name;
    private double profit;
    private double qty;
    private double retAmount;
    private double retProfit;
    private double retQty;
    private double revenue;
    private final ArrayList<ItemSale> sales;
    private final String unit;

    public ItemAccum(String key, String name, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(name, "name");
        this.key = key;
        this.name = name;
        this.unit = str;
        this.sales = new ArrayList<>(4);
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

    public final void setQty(double d) {
        this.qty = d;
    }

    public final double getRetQty() {
        return this.retQty;
    }

    public final void setRetQty(double d) {
        this.retQty = d;
    }

    public final double getRevenue() {
        return this.revenue;
    }

    public final void setRevenue(double d) {
        this.revenue = d;
    }

    public final double getRetAmount() {
        return this.retAmount;
    }

    public final void setRetAmount(double d) {
        this.retAmount = d;
    }

    public final double getProfit() {
        return this.profit;
    }

    public final void setProfit(double d) {
        this.profit = d;
    }

    public final double getRetProfit() {
        return this.retProfit;
    }

    public final void setRetProfit(double d) {
        this.retProfit = d;
    }

    public final ArrayList<ItemSale> getSales() {
        return this.sales;
    }
}
