package uz.FonRo.pos.ui.catalog;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: ProductForm.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Luz/FonRo/pos/ui/catalog/ProductVariant;", "", "base", "", "opt1", "opt2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBase", "()Ljava/lang/String;", "getOpt1", "getOpt2", "component1", "component2", "component3", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class ProductVariant {
    public static final int $stable = 0;
    private final String base;
    private final String opt1;
    private final String opt2;

    public static /* synthetic */ ProductVariant copy$default(ProductVariant productVariant, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = productVariant.base;
        }
        if ((i & 2) != 0) {
            str2 = productVariant.opt1;
        }
        if ((i & 4) != 0) {
            str3 = productVariant.opt2;
        }
        return productVariant.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getBase() {
        return this.base;
    }

    /* renamed from: component2, reason: from getter */
    public final String getOpt1() {
        return this.opt1;
    }

    /* renamed from: component3, reason: from getter */
    public final String getOpt2() {
        return this.opt2;
    }

    public final ProductVariant copy(String base, String opt1, String opt2) {
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(opt1, "opt1");
        Intrinsics.checkNotNullParameter(opt2, "opt2");
        return new ProductVariant(base, opt1, opt2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProductVariant)) {
            return false;
        }
        ProductVariant productVariant = (ProductVariant) other;
        return Intrinsics.areEqual(this.base, productVariant.base) && Intrinsics.areEqual(this.opt1, productVariant.opt1) && Intrinsics.areEqual(this.opt2, productVariant.opt2);
    }

    public int hashCode() {
        return (((this.base.hashCode() * 31) + this.opt1.hashCode()) * 31) + this.opt2.hashCode();
    }

    public String toString() {
        return "ProductVariant(base=" + this.base + ", opt1=" + this.opt1 + ", opt2=" + this.opt2 + ")";
    }

    public ProductVariant(String base, String opt1, String opt2) {
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(opt1, "opt1");
        Intrinsics.checkNotNullParameter(opt2, "opt2");
        this.base = base;
        this.opt1 = opt1;
        this.opt2 = opt2;
    }

    public final String getBase() {
        return this.base;
    }

    public final String getOpt1() {
        return this.opt1;
    }

    public final String getOpt2() {
        return this.opt2;
    }
}
