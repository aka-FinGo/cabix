package uz.FonRo.pos.ui.docs;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import uz.FonRo.pos.data.model.WriteOffReason;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SuppliersScreen.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Luz/FonRo/pos/ui/docs/SupplierStat;", "", "count", "", "total", "", "<init>", "(ID)V", "getCount", "()I", "getTotal", "()D", "component1", "component2", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class SupplierStat {
    private final int count;
    private final double total;

    public static /* synthetic */ SupplierStat copy$default(SupplierStat supplierStat, int i, double d, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = supplierStat.count;
        }
        if ((i2 & 2) != 0) {
            d = supplierStat.total;
        }
        return supplierStat.copy(i, d);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* renamed from: component2, reason: from getter */
    public final double getTotal() {
        return this.total;
    }

    public final SupplierStat copy(int count, double total) {
        return new SupplierStat(count, total);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SupplierStat)) {
            return false;
        }
        SupplierStat supplierStat = (SupplierStat) other;
        return this.count == supplierStat.count && Double.compare(this.total, supplierStat.total) == 0;
    }

    public int hashCode() {
        return (Integer.hashCode(this.count) * 31) + Double.hashCode(this.total);
    }

    public String toString() {
        return "SupplierStat(count=" + this.count + ", total=" + this.total + ")";
    }

    public SupplierStat(int i, double d) {
        this.count = i;
        this.total = d;
    }

    public final int getCount() {
        return this.count;
    }

    public final double getTotal() {
        return this.total;
    }
}
