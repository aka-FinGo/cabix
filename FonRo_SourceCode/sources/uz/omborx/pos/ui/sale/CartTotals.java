package uz.FonRo.pos.ui.sale;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: SaleState.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tÊ\u0001\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0017"}, d2 = {"Luz/FonRo/pos/ui/sale/CartTotals;", "", "subtotal", "", FirebaseAnalytics.Param.DISCOUNT, "total", "<init>", "(DDD)V", "getSubtotal", "()D", "getDiscount", "getTotal", "component1", "component2", "component3", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class CartTotals {
    public static final int $stable = 0;
    private final double discount;
    private final double subtotal;
    private final double total;

    public CartTotals() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 7, null);
    }

    public static /* synthetic */ CartTotals copy$default(CartTotals cartTotals, double d, double d2, double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            d = cartTotals.subtotal;
        }
        double d4 = d;
        if ((i & 2) != 0) {
            d2 = cartTotals.discount;
        }
        double d5 = d2;
        if ((i & 4) != 0) {
            d3 = cartTotals.total;
        }
        return cartTotals.copy(d4, d5, d3);
    }

    /* renamed from: component1, reason: from getter */
    public final double getSubtotal() {
        return this.subtotal;
    }

    /* renamed from: component2, reason: from getter */
    public final double getDiscount() {
        return this.discount;
    }

    /* renamed from: component3, reason: from getter */
    public final double getTotal() {
        return this.total;
    }

    public final CartTotals copy(double subtotal, double discount, double total) {
        return new CartTotals(subtotal, discount, total);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CartTotals)) {
            return false;
        }
        CartTotals cartTotals = (CartTotals) other;
        return Double.compare(this.subtotal, cartTotals.subtotal) == 0 && Double.compare(this.discount, cartTotals.discount) == 0 && Double.compare(this.total, cartTotals.total) == 0;
    }

    public int hashCode() {
        return (((Double.hashCode(this.subtotal) * 31) + Double.hashCode(this.discount)) * 31) + Double.hashCode(this.total);
    }

    public String toString() {
        return "CartTotals(subtotal=" + this.subtotal + ", discount=" + this.discount + ", total=" + this.total + ")";
    }

    public CartTotals(double d, double d2, double d3) {
        this.subtotal = d;
        this.discount = d2;
        this.total = d3;
    }

    public /* synthetic */ CartTotals(double d, double d2, double d3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0d : d, (i & 2) != 0 ? 0.0d : d2, (i & 4) != 0 ? 0.0d : d3);
    }

    public final double getSubtotal() {
        return this.subtotal;
    }

    public final double getDiscount() {
        return this.discount;
    }

    public final double getTotal() {
        return this.total;
    }
}
