package uz.FonRo.pos.ui.docs;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.Product;
import uz.FonRo.pos.data.model.WriteOffReason;
import uz.FonRo.pos.ui.nav.Routes;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StockInScreen.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\tHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Luz/FonRo/pos/ui/docs/StockInLine;", "", "product", "Luz/FonRo/pos/data/model/Product;", FirebaseAnalytics.Param.QUANTITY, "", FirebaseAnalytics.Event.PURCHASE, Routes.SALE, "expiration", "", "<init>", "(Luz/FonRo/pos/data/model/Product;DDDLjava/lang/String;)V", "getProduct", "()Luz/FonRo/pos/data/model/Product;", "getQuantity", "()D", "getPurchase", "getSale", "getExpiration", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class StockInLine {
    private final String expiration;
    private final Product product;
    private final double purchase;
    private final double quantity;
    private final double sale;

    public static /* synthetic */ StockInLine copy$default(StockInLine stockInLine, Product product, double d, double d2, double d3, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            product = stockInLine.product;
        }
        if ((i & 2) != 0) {
            d = stockInLine.quantity;
        }
        if ((i & 4) != 0) {
            d2 = stockInLine.purchase;
        }
        if ((i & 8) != 0) {
            d3 = stockInLine.sale;
        }
        if ((i & 16) != 0) {
            str = stockInLine.expiration;
        }
        String str2 = str;
        double d4 = d3;
        return stockInLine.copy(product, d, d2, d4, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final Product getProduct() {
        return this.product;
    }

    /* renamed from: component2, reason: from getter */
    public final double getQuantity() {
        return this.quantity;
    }

    /* renamed from: component3, reason: from getter */
    public final double getPurchase() {
        return this.purchase;
    }

    /* renamed from: component4, reason: from getter */
    public final double getSale() {
        return this.sale;
    }

    /* renamed from: component5, reason: from getter */
    public final String getExpiration() {
        return this.expiration;
    }

    public final StockInLine copy(Product product, double quantity, double purchase, double sale, String expiration) {
        Intrinsics.checkNotNullParameter(product, "product");
        return new StockInLine(product, quantity, purchase, sale, expiration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StockInLine)) {
            return false;
        }
        StockInLine stockInLine = (StockInLine) other;
        return Intrinsics.areEqual(this.product, stockInLine.product) && Double.compare(this.quantity, stockInLine.quantity) == 0 && Double.compare(this.purchase, stockInLine.purchase) == 0 && Double.compare(this.sale, stockInLine.sale) == 0 && Intrinsics.areEqual(this.expiration, stockInLine.expiration);
    }

    public int hashCode() {
        int hashCode = ((((((this.product.hashCode() * 31) + Double.hashCode(this.quantity)) * 31) + Double.hashCode(this.purchase)) * 31) + Double.hashCode(this.sale)) * 31;
        String str = this.expiration;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "StockInLine(product=" + this.product + ", quantity=" + this.quantity + ", purchase=" + this.purchase + ", sale=" + this.sale + ", expiration=" + this.expiration + ")";
    }

    public StockInLine(Product product, double d, double d2, double d3, String str) {
        Intrinsics.checkNotNullParameter(product, "product");
        this.product = product;
        this.quantity = d;
        this.purchase = d2;
        this.sale = d3;
        this.expiration = str;
    }

    public final Product getProduct() {
        return this.product;
    }

    public final double getQuantity() {
        return this.quantity;
    }

    public final double getPurchase() {
        return this.purchase;
    }

    public final double getSale() {
        return this.sale;
    }

    public final String getExpiration() {
        return this.expiration;
    }
}
