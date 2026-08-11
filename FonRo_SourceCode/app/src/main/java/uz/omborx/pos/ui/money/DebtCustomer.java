package uz.FonRo.pos.ui.money;

import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.DebtSale;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: DebtsScreen.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003JU\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\u0014\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020\bHÖ\u0081\u0004J\n\u0010)\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cÊ\u0001\f\b+\u0012\b\b,\u0012\u0004\b\u0003\u0010\u0000¨\u0006*"}, d2 = {"Luz/FonRo/pos/ui/money/DebtCustomer;", "", "customerId", "", "name", "", HintConstants.AUTOFILL_HINT_PHONE, "salesCount", "", "debtTotal", "", "paidTotal", "sales", "", "Luz/FonRo/pos/data/model/DebtSale;", "<init>", "(JLjava/lang/String;Ljava/lang/String;IDDLjava/util/List;)V", "getCustomerId", "()J", "getName", "()Ljava/lang/String;", "getPhone", "getSalesCount", "()I", "getDebtTotal", "()D", "getPaidTotal", "getSales", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class DebtCustomer {
    public static final int $stable = 8;
    private final long customerId;
    private final double debtTotal;
    private final String name;
    private final double paidTotal;
    private final String phone;
    private final List<DebtSale> sales;
    private final int salesCount;

    public static /* synthetic */ DebtCustomer copy$default(DebtCustomer debtCustomer, long j, String str, String str2, int i, double d, double d2, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = debtCustomer.customerId;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            str = debtCustomer.name;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = debtCustomer.phone;
        }
        return debtCustomer.copy(j2, str3, str2, (i2 & 8) != 0 ? debtCustomer.salesCount : i, (i2 & 16) != 0 ? debtCustomer.debtTotal : d, (i2 & 32) != 0 ? debtCustomer.paidTotal : d2, (i2 & 64) != 0 ? debtCustomer.sales : list);
    }

    /* renamed from: component1, reason: from getter */
    public final long getCustomerId() {
        return this.customerId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component4, reason: from getter */
    public final int getSalesCount() {
        return this.salesCount;
    }

    /* renamed from: component5, reason: from getter */
    public final double getDebtTotal() {
        return this.debtTotal;
    }

    /* renamed from: component6, reason: from getter */
    public final double getPaidTotal() {
        return this.paidTotal;
    }

    public final List<DebtSale> component7() {
        return this.sales;
    }

    public final DebtCustomer copy(long customerId, String name, String phone, int salesCount, double debtTotal, double paidTotal, List<DebtSale> sales) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(sales, "sales");
        return new DebtCustomer(customerId, name, phone, salesCount, debtTotal, paidTotal, sales);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DebtCustomer)) {
            return false;
        }
        DebtCustomer debtCustomer = (DebtCustomer) other;
        return this.customerId == debtCustomer.customerId && Intrinsics.areEqual(this.name, debtCustomer.name) && Intrinsics.areEqual(this.phone, debtCustomer.phone) && this.salesCount == debtCustomer.salesCount && Double.compare(this.debtTotal, debtCustomer.debtTotal) == 0 && Double.compare(this.paidTotal, debtCustomer.paidTotal) == 0 && Intrinsics.areEqual(this.sales, debtCustomer.sales);
    }

    public int hashCode() {
        return (((((((((((Long.hashCode(this.customerId) * 31) + this.name.hashCode()) * 31) + this.phone.hashCode()) * 31) + Integer.hashCode(this.salesCount)) * 31) + Double.hashCode(this.debtTotal)) * 31) + Double.hashCode(this.paidTotal)) * 31) + this.sales.hashCode();
    }

    public String toString() {
        return "DebtCustomer(customerId=" + this.customerId + ", name=" + this.name + ", phone=" + this.phone + ", salesCount=" + this.salesCount + ", debtTotal=" + this.debtTotal + ", paidTotal=" + this.paidTotal + ", sales=" + this.sales + ")";
    }

    public DebtCustomer(long j, String name, String phone, int i, double d, double d2, List<DebtSale> sales) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(sales, "sales");
        this.customerId = j;
        this.name = name;
        this.phone = phone;
        this.salesCount = i;
        this.debtTotal = d;
        this.paidTotal = d2;
        this.sales = sales;
    }

    public final long getCustomerId() {
        return this.customerId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final int getSalesCount() {
        return this.salesCount;
    }

    public final double getDebtTotal() {
        return this.debtTotal;
    }

    public final double getPaidTotal() {
        return this.paidTotal;
    }

    public final List<DebtSale> getSales() {
        return this.sales;
    }
}
