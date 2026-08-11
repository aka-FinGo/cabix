package uz.FonRo.pos.ui.money;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: DebtsScreen.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0010HÆ\u0003Jw\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0014\u0010.\u001a\u00020\u00102\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00100\u001a\u000201HÖ\u0081\u0004J\n\u00102\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!Ê\u0001\f\b4\u0012\b\b5\u0012\u0004\b\u0003\u0010\u0002¨\u00063"}, d2 = {"Luz/FonRo/pos/ui/money/DebtClosure;", "", "key", "", "amount", "", "cashAmount", "cardAmount", "createdAt", "transactionId", "paymentType", "paidBy", "customerId", "", "name", "closed", "", "<init>", "(Ljava/lang/String;DDDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Z)V", "getKey", "()Ljava/lang/String;", "getAmount", "()D", "getCashAmount", "getCardAmount", "getCreatedAt", "getTransactionId", "getPaymentType", "getPaidBy", "getCustomerId", "()J", "getName", "getClosed", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", WriteOffReason.OTHER, "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class DebtClosure {
    public static final int $stable = 0;
    private final double amount;
    private final double cardAmount;
    private final double cashAmount;
    private final boolean closed;
    private final String createdAt;
    private final long customerId;
    private final String key;
    private final String name;
    private final String paidBy;
    private final String paymentType;
    private final String transactionId;

    /* renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component10, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getClosed() {
        return this.closed;
    }

    /* renamed from: component2, reason: from getter */
    public final double getAmount() {
        return this.amount;
    }

    /* renamed from: component3, reason: from getter */
    public final double getCashAmount() {
        return this.cashAmount;
    }

    /* renamed from: component4, reason: from getter */
    public final double getCardAmount() {
        return this.cardAmount;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTransactionId() {
        return this.transactionId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPaymentType() {
        return this.paymentType;
    }

    /* renamed from: component8, reason: from getter */
    public final String getPaidBy() {
        return this.paidBy;
    }

    /* renamed from: component9, reason: from getter */
    public final long getCustomerId() {
        return this.customerId;
    }

    public final DebtClosure copy(String key, double amount, double cashAmount, double cardAmount, String createdAt, String transactionId, String paymentType, String paidBy, long customerId, String name, boolean closed) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        Intrinsics.checkNotNullParameter(paidBy, "paidBy");
        Intrinsics.checkNotNullParameter(name, "name");
        return new DebtClosure(key, amount, cashAmount, cardAmount, createdAt, transactionId, paymentType, paidBy, customerId, name, closed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DebtClosure)) {
            return false;
        }
        DebtClosure debtClosure = (DebtClosure) other;
        return Intrinsics.areEqual(this.key, debtClosure.key) && Double.compare(this.amount, debtClosure.amount) == 0 && Double.compare(this.cashAmount, debtClosure.cashAmount) == 0 && Double.compare(this.cardAmount, debtClosure.cardAmount) == 0 && Intrinsics.areEqual(this.createdAt, debtClosure.createdAt) && Intrinsics.areEqual(this.transactionId, debtClosure.transactionId) && Intrinsics.areEqual(this.paymentType, debtClosure.paymentType) && Intrinsics.areEqual(this.paidBy, debtClosure.paidBy) && this.customerId == debtClosure.customerId && Intrinsics.areEqual(this.name, debtClosure.name) && this.closed == debtClosure.closed;
    }

    public int hashCode() {
        return (((((((((((((((((((this.key.hashCode() * 31) + Double.hashCode(this.amount)) * 31) + Double.hashCode(this.cashAmount)) * 31) + Double.hashCode(this.cardAmount)) * 31) + this.createdAt.hashCode()) * 31) + this.transactionId.hashCode()) * 31) + this.paymentType.hashCode()) * 31) + this.paidBy.hashCode()) * 31) + Long.hashCode(this.customerId)) * 31) + this.name.hashCode()) * 31) + Boolean.hashCode(this.closed);
    }

    public String toString() {
        return "DebtClosure(key=" + this.key + ", amount=" + this.amount + ", cashAmount=" + this.cashAmount + ", cardAmount=" + this.cardAmount + ", createdAt=" + this.createdAt + ", transactionId=" + this.transactionId + ", paymentType=" + this.paymentType + ", paidBy=" + this.paidBy + ", customerId=" + this.customerId + ", name=" + this.name + ", closed=" + this.closed + ")";
    }

    public DebtClosure(String key, double d, double d2, double d3, String createdAt, String transactionId, String paymentType, String paidBy, long j, String name, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        Intrinsics.checkNotNullParameter(paidBy, "paidBy");
        Intrinsics.checkNotNullParameter(name, "name");
        this.key = key;
        this.amount = d;
        this.cashAmount = d2;
        this.cardAmount = d3;
        this.createdAt = createdAt;
        this.transactionId = transactionId;
        this.paymentType = paymentType;
        this.paidBy = paidBy;
        this.customerId = j;
        this.name = name;
        this.closed = z;
    }

    public final String getKey() {
        return this.key;
    }

    public final double getAmount() {
        return this.amount;
    }

    public final double getCashAmount() {
        return this.cashAmount;
    }

    public final double getCardAmount() {
        return this.cardAmount;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public final String getPaymentType() {
        return this.paymentType;
    }

    public final String getPaidBy() {
        return this.paidBy;
    }

    public final long getCustomerId() {
        return this.customerId;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getClosed() {
        return this.closed;
    }
}
