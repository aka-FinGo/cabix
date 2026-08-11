package uz.FonRo.pos.ui.catalog;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import uz.FonRo.pos.data.local.CacheStore;
import uz.FonRo.pos.data.model.WriteOffReason;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CatalogScreen.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Luz/FonRo/pos/ui/catalog/CatalogSummary;", "", CacheStore.PRODUCTS, "", "units", "", "value", "<init>", "(IDD)V", "getProducts", "()I", "getUnits", "()D", "getValue", "component1", "component2", "component3", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class CatalogSummary {
    private final int products;
    private final double units;
    private final double value;

    public static /* synthetic */ CatalogSummary copy$default(CatalogSummary catalogSummary, int i, double d, double d2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = catalogSummary.products;
        }
        if ((i2 & 2) != 0) {
            d = catalogSummary.units;
        }
        if ((i2 & 4) != 0) {
            d2 = catalogSummary.value;
        }
        return catalogSummary.copy(i, d, d2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getProducts() {
        return this.products;
    }

    /* renamed from: component2, reason: from getter */
    public final double getUnits() {
        return this.units;
    }

    /* renamed from: component3, reason: from getter */
    public final double getValue() {
        return this.value;
    }

    public final CatalogSummary copy(int products, double units, double value) {
        return new CatalogSummary(products, units, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CatalogSummary)) {
            return false;
        }
        CatalogSummary catalogSummary = (CatalogSummary) other;
        return this.products == catalogSummary.products && Double.compare(this.units, catalogSummary.units) == 0 && Double.compare(this.value, catalogSummary.value) == 0;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.products) * 31) + Double.hashCode(this.units)) * 31) + Double.hashCode(this.value);
    }

    public String toString() {
        return "CatalogSummary(products=" + this.products + ", units=" + this.units + ", value=" + this.value + ")";
    }

    public CatalogSummary(int i, double d, double d2) {
        this.products = i;
        this.units = d;
        this.value = d2;
    }

    public final int getProducts() {
        return this.products;
    }

    public final double getUnits() {
        return this.units;
    }

    public final double getValue() {
        return this.value;
    }
}
