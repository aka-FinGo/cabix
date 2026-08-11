package uz.FonRo.pos.print;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: ReceiptDoc.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001b"}, d2 = {"Luz/FonRo/pos/print/ReceiptLine;", "", "name", "", "qty", FirebaseAnalytics.Param.PRICE, "", "sum", "<init>", "(Ljava/lang/String;Ljava/lang/String;DD)V", "getName", "()Ljava/lang/String;", "getQty", "getPrice", "()D", "getSum", "component1", "component2", "component3", "component4", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final /* data */ class ReceiptLine {
    public static final int $stable = 0;
    private final String name;
    private final double price;
    private final String qty;
    private final double sum;

    public static /* synthetic */ ReceiptLine copy$default(ReceiptLine receiptLine, String str, String str2, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = receiptLine.name;
        }
        if ((i & 2) != 0) {
            str2 = receiptLine.qty;
        }
        if ((i & 4) != 0) {
            d = receiptLine.price;
        }
        if ((i & 8) != 0) {
            d2 = receiptLine.sum;
        }
        double d3 = d2;
        return receiptLine.copy(str, str2, d, d3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getQty() {
        return this.qty;
    }

    /* renamed from: component3, reason: from getter */
    public final double getPrice() {
        return this.price;
    }

    /* renamed from: component4, reason: from getter */
    public final double getSum() {
        return this.sum;
    }

    public final ReceiptLine copy(String name, String qty, double price, double sum) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(qty, "qty");
        return new ReceiptLine(name, qty, price, sum);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReceiptLine)) {
            return false;
        }
        ReceiptLine receiptLine = (ReceiptLine) other;
        return Intrinsics.areEqual(this.name, receiptLine.name) && Intrinsics.areEqual(this.qty, receiptLine.qty) && Double.compare(this.price, receiptLine.price) == 0 && Double.compare(this.sum, receiptLine.sum) == 0;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.qty.hashCode()) * 31) + Double.hashCode(this.price)) * 31) + Double.hashCode(this.sum);
    }

    public String toString() {
        return "ReceiptLine(name=" + this.name + ", qty=" + this.qty + ", price=" + this.price + ", sum=" + this.sum + ")";
    }

    public ReceiptLine(String name, String qty, double d, double d2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(qty, "qty");
        this.name = name;
        this.qty = qty;
        this.price = d;
        this.sum = d2;
    }

    public final String getName() {
        return this.name;
    }

    public final double getPrice() {
        return this.price;
    }

    public final String getQty() {
        return this.qty;
    }

    public final double getSum() {
        return this.sum;
    }
}
