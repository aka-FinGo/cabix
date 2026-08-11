package uz.FonRo.pos.ui.sale;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.PayType;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: SaleSubmit.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b0\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003J\t\u00100\u001a\u00020\fHÆ\u0003J\t\u00101\u001a\u00020\fHÆ\u0003J\t\u00102\u001a\u00020\fHÆ\u0003J\t\u00103\u001a\u00020\fHÆ\u0003J\t\u00104\u001a\u00020\fHÆ\u0003J\t\u00105\u001a\u00020\fHÆ\u0003J\t\u00106\u001a\u00020\fHÆ\u0003J\t\u00107\u001a\u00020\fHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009d\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010:\u001a\u00020\u00072\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010<\u001a\u00020=HÖ\u0081\u0004J\n\u0010>\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0011\u0010\u0010\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\u0011\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010\u0012\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0011\u0010\u0013\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0011\u0010\u0014\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019Ê\u0001\f\b@\u0012\b\bA\u0012\u0004\b\u0003\u0010\u0000¨\u0006?"}, d2 = {"Luz/FonRo/pos/ui/sale/SaleDone;", "", "transactionId", "", "payType", "Luz/FonRo/pos/data/model/PayType;", "queued", "", "lines", "", "Luz/FonRo/pos/ui/sale/CartLine;", "subtotal", "", "discountAmount", "total", "received", "paid", "cash", "card", "change", "debt", "customerName", "<init>", "(Ljava/lang/String;Luz/FonRo/pos/data/model/PayType;ZLjava/util/List;DDDDDDDDDLjava/lang/String;)V", "getTransactionId", "()Ljava/lang/String;", "getPayType", "()Luz/FonRo/pos/data/model/PayType;", "getQueued", "()Z", "getLines", "()Ljava/util/List;", "getSubtotal", "()D", "getDiscountAmount", "getTotal", "getReceived", "getPaid", "getCash", "getCard", "getChange", "getDebt", "getCustomerName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", WriteOffReason.OTHER, "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class SaleDone {
    public static final int $stable = 8;
    private final double card;
    private final double cash;
    private final double change;
    private final String customerName;
    private final double debt;
    private final double discountAmount;
    private final List<CartLine> lines;
    private final double paid;
    private final PayType payType;
    private final boolean queued;
    private final double received;
    private final double subtotal;
    private final double total;
    private final String transactionId;

    /* renamed from: component1, reason: from getter */
    public final String getTransactionId() {
        return this.transactionId;
    }

    /* renamed from: component10, reason: from getter */
    public final double getCash() {
        return this.cash;
    }

    /* renamed from: component11, reason: from getter */
    public final double getCard() {
        return this.card;
    }

    /* renamed from: component12, reason: from getter */
    public final double getChange() {
        return this.change;
    }

    /* renamed from: component13, reason: from getter */
    public final double getDebt() {
        return this.debt;
    }

    /* renamed from: component14, reason: from getter */
    public final String getCustomerName() {
        return this.customerName;
    }

    /* renamed from: component2, reason: from getter */
    public final PayType getPayType() {
        return this.payType;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getQueued() {
        return this.queued;
    }

    public final List<CartLine> component4() {
        return this.lines;
    }

    /* renamed from: component5, reason: from getter */
    public final double getSubtotal() {
        return this.subtotal;
    }

    /* renamed from: component6, reason: from getter */
    public final double getDiscountAmount() {
        return this.discountAmount;
    }

    /* renamed from: component7, reason: from getter */
    public final double getTotal() {
        return this.total;
    }

    /* renamed from: component8, reason: from getter */
    public final double getReceived() {
        return this.received;
    }

    /* renamed from: component9, reason: from getter */
    public final double getPaid() {
        return this.paid;
    }

    public final SaleDone copy(String transactionId, PayType payType, boolean queued, List<CartLine> lines, double subtotal, double discountAmount, double total, double received, double paid, double cash, double card, double change, double debt, String customerName) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(payType, "payType");
        Intrinsics.checkNotNullParameter(lines, "lines");
        return new SaleDone(transactionId, payType, queued, lines, subtotal, discountAmount, total, received, paid, cash, card, change, debt, customerName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleDone)) {
            return false;
        }
        SaleDone saleDone = (SaleDone) other;
        return Intrinsics.areEqual(this.transactionId, saleDone.transactionId) && this.payType == saleDone.payType && this.queued == saleDone.queued && Intrinsics.areEqual(this.lines, saleDone.lines) && Double.compare(this.subtotal, saleDone.subtotal) == 0 && Double.compare(this.discountAmount, saleDone.discountAmount) == 0 && Double.compare(this.total, saleDone.total) == 0 && Double.compare(this.received, saleDone.received) == 0 && Double.compare(this.paid, saleDone.paid) == 0 && Double.compare(this.cash, saleDone.cash) == 0 && Double.compare(this.card, saleDone.card) == 0 && Double.compare(this.change, saleDone.change) == 0 && Double.compare(this.debt, saleDone.debt) == 0 && Intrinsics.areEqual(this.customerName, saleDone.customerName);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((this.transactionId.hashCode() * 31) + this.payType.hashCode()) * 31) + Boolean.hashCode(this.queued)) * 31) + this.lines.hashCode()) * 31) + Double.hashCode(this.subtotal)) * 31) + Double.hashCode(this.discountAmount)) * 31) + Double.hashCode(this.total)) * 31) + Double.hashCode(this.received)) * 31) + Double.hashCode(this.paid)) * 31) + Double.hashCode(this.cash)) * 31) + Double.hashCode(this.card)) * 31) + Double.hashCode(this.change)) * 31) + Double.hashCode(this.debt)) * 31;
        String str = this.customerName;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SaleDone(transactionId=" + this.transactionId + ", payType=" + this.payType + ", queued=" + this.queued + ", lines=" + this.lines + ", subtotal=" + this.subtotal + ", discountAmount=" + this.discountAmount + ", total=" + this.total + ", received=" + this.received + ", paid=" + this.paid + ", cash=" + this.cash + ", card=" + this.card + ", change=" + this.change + ", debt=" + this.debt + ", customerName=" + this.customerName + ")";
    }

    public SaleDone(String transactionId, PayType payType, boolean z, List<CartLine> lines, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, String str) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(payType, "payType");
        Intrinsics.checkNotNullParameter(lines, "lines");
        this.transactionId = transactionId;
        this.payType = payType;
        this.queued = z;
        this.lines = lines;
        this.subtotal = d;
        this.discountAmount = d2;
        this.total = d3;
        this.received = d4;
        this.paid = d5;
        this.cash = d6;
        this.card = d7;
        this.change = d8;
        this.debt = d9;
        this.customerName = str;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public final PayType getPayType() {
        return this.payType;
    }

    public final boolean getQueued() {
        return this.queued;
    }

    public final List<CartLine> getLines() {
        return this.lines;
    }

    public final double getSubtotal() {
        return this.subtotal;
    }

    public final double getDiscountAmount() {
        return this.discountAmount;
    }

    public final double getTotal() {
        return this.total;
    }

    public final double getReceived() {
        return this.received;
    }

    public final double getPaid() {
        return this.paid;
    }

    public final double getCash() {
        return this.cash;
    }

    public final double getCard() {
        return this.card;
    }

    public final double getChange() {
        return this.change;
    }

    public final double getDebt() {
        return this.debt;
    }

    public final String getCustomerName() {
        return this.customerName;
    }
}
