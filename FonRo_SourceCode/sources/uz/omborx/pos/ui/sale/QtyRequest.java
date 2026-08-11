package uz.FonRo.pos.ui.sale;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.model.WriteOffReason;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SaleScreen.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Luz/FonRo/pos/ui/sale/QtyRequest;", "", "product", "Luz/FonRo/pos/data/model/Product;", "replace", "", "<init>", "(Luz/FonRo/pos/data/model/Product;Z)V", "getProduct", "()Luz/FonRo/pos/data/model/Product;", "getReplace", "()Z", "component1", "component2", "copy", "equals", WriteOffReason.OTHER, "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class QtyRequest {
    private final Product product;
    private final boolean replace;

    public static /* synthetic */ QtyRequest copy$default(QtyRequest qtyRequest, Product product, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            product = qtyRequest.product;
        }
        if ((i & 2) != 0) {
            z = qtyRequest.replace;
        }
        return qtyRequest.copy(product, z);
    }

    /* renamed from: component1, reason: from getter */
    public final Product getProduct() {
        return this.product;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getReplace() {
        return this.replace;
    }

    public final QtyRequest copy(Product product, boolean replace) {
        Intrinsics.checkNotNullParameter(product, "product");
        return new QtyRequest(product, replace);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QtyRequest)) {
            return false;
        }
        QtyRequest qtyRequest = (QtyRequest) other;
        return Intrinsics.areEqual(this.product, qtyRequest.product) && this.replace == qtyRequest.replace;
    }

    public int hashCode() {
        return (this.product.hashCode() * 31) + Boolean.hashCode(this.replace);
    }

    public String toString() {
        return "QtyRequest(product=" + this.product + ", replace=" + this.replace + ")";
    }

    public QtyRequest(Product product, boolean z) {
        Intrinsics.checkNotNullParameter(product, "product");
        this.product = product;
        this.replace = z;
    }

    public final Product getProduct() {
        return this.product;
    }

    public final boolean getReplace() {
        return this.replace;
    }
}
