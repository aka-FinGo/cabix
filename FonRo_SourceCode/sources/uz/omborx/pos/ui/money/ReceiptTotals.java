package uz.FonRo.pos.ui.money;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: Receipts.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010Ê\u0001\f\b%\u0012\b\b&\u0012\u0004\b\u0003\u0010\u0002¨\u0006$"}, d2 = {"Luz/FonRo/pos/ui/money/ReceiptTotals;", "", "count", "", "total", "", "profit", "qty", FirebaseAnalytics.Param.DISCOUNT, "returned", "debt", "<init>", "(IDDDDDD)V", "getCount", "()I", "getTotal", "()D", "getProfit", "getQty", "getDiscount", "getReturned", "getDebt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class ReceiptTotals {
    public static final int $stable = 0;
    private final int count;
    private final double debt;
    private final double discount;
    private final double profit;
    private final double qty;
    private final double returned;
    private final double total;

    public static /* synthetic */ ReceiptTotals copy$default(ReceiptTotals receiptTotals, int i, double d, double d2, double d3, double d4, double d5, double d6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = receiptTotals.count;
        }
        return receiptTotals.copy(i, (i2 & 2) != 0 ? receiptTotals.total : d, (i2 & 4) != 0 ? receiptTotals.profit : d2, (i2 & 8) != 0 ? receiptTotals.qty : d3, (i2 & 16) != 0 ? receiptTotals.discount : d4, (i2 & 32) != 0 ? receiptTotals.returned : d5, (i2 & 64) != 0 ? receiptTotals.debt : d6);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* renamed from: component2, reason: from getter */
    public final double getTotal() {
        return this.total;
    }

    /* renamed from: component3, reason: from getter */
    public final double getProfit() {
        return this.profit;
    }

    /* renamed from: component4, reason: from getter */
    public final double getQty() {
        return this.qty;
    }

    /* renamed from: component5, reason: from getter */
    public final double getDiscount() {
        return this.discount;
    }

    /* renamed from: component6, reason: from getter */
    public final double getReturned() {
        return this.returned;
    }

    /* renamed from: component7, reason: from getter */
    public final double getDebt() {
        return this.debt;
    }

    public final ReceiptTotals copy(int count, double total, double profit, double qty, double discount, double returned, double debt) {
        return new ReceiptTotals(count, total, profit, qty, discount, returned, debt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReceiptTotals)) {
            return false;
        }
        ReceiptTotals receiptTotals = (ReceiptTotals) other;
        return this.count == receiptTotals.count && Double.compare(this.total, receiptTotals.total) == 0 && Double.compare(this.profit, receiptTotals.profit) == 0 && Double.compare(this.qty, receiptTotals.qty) == 0 && Double.compare(this.discount, receiptTotals.discount) == 0 && Double.compare(this.returned, receiptTotals.returned) == 0 && Double.compare(this.debt, receiptTotals.debt) == 0;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.count) * 31) + Double.hashCode(this.total)) * 31) + Double.hashCode(this.profit)) * 31) + Double.hashCode(this.qty)) * 31) + Double.hashCode(this.discount)) * 31) + Double.hashCode(this.returned)) * 31) + Double.hashCode(this.debt);
    }

    public String toString() {
        return "ReceiptTotals(count=" + this.count + ", total=" + this.total + ", profit=" + this.profit + ", qty=" + this.qty + ", discount=" + this.discount + ", returned=" + this.returned + ", debt=" + this.debt + ")";
    }

    public ReceiptTotals(int i, double d, double d2, double d3, double d4, double d5, double d6) {
        this.count = i;
        this.total = d;
        this.profit = d2;
        this.qty = d3;
        this.discount = d4;
        this.returned = d5;
        this.debt = d6;
    }

    public final int getCount() {
        return this.count;
    }

    public final double getTotal() {
        return this.total;
    }

    public final double getProfit() {
        return this.profit;
    }

    public final double getQty() {
        return this.qty;
    }

    public final double getDiscount() {
        return this.discount;
    }

    public final double getReturned() {
        return this.returned;
    }

    public final double getDebt() {
        return this.debt;
    }
}
