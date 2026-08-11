package uz.FonRo.pos.ui.sale;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.core.Num;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: SaleState.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0015J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J-\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010Ê\u0001\f\b\"\u0012\b\b#\u0012\u0004\b\u0003\u0010\u0000¨\u0006!"}, d2 = {"Luz/FonRo/pos/ui/sale/CartState;", "", FirebaseAnalytics.Param.ITEMS, "", "Luz/FonRo/pos/ui/sale/CartLine;", "customerId", "", FirebaseAnalytics.Param.DISCOUNT, "Luz/FonRo/pos/ui/sale/CartDiscount;", "<init>", "(Ljava/util/List;JLuz/FonRo/pos/ui/sale/CartDiscount;)V", "getItems", "()Ljava/util/List;", "getCustomerId", "()J", "getDiscount", "()Luz/FonRo/pos/ui/sale/CartDiscount;", "qtyOf", "", "productId", "totals", "Luz/FonRo/pos/ui/sale/CartTotals;", "component1", "component2", "component3", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class CartState {
    public static final int $stable = 8;
    private final long customerId;
    private final CartDiscount discount;
    private final List<CartLine> items;

    public CartState() {
        this(null, 0L, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CartState copy$default(CartState cartState, List list, long j, CartDiscount cartDiscount, int i, Object obj) {
        if ((i & 1) != 0) {
            list = cartState.items;
        }
        if ((i & 2) != 0) {
            j = cartState.customerId;
        }
        if ((i & 4) != 0) {
            cartDiscount = cartState.discount;
        }
        return cartState.copy(list, j, cartDiscount);
    }

    public final List<CartLine> component1() {
        return this.items;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCustomerId() {
        return this.customerId;
    }

    /* renamed from: component3, reason: from getter */
    public final CartDiscount getDiscount() {
        return this.discount;
    }

    public final CartState copy(List<CartLine> items, long customerId, CartDiscount discount) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(discount, "discount");
        return new CartState(items, customerId, discount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CartState)) {
            return false;
        }
        CartState cartState = (CartState) other;
        return Intrinsics.areEqual(this.items, cartState.items) && this.customerId == cartState.customerId && Intrinsics.areEqual(this.discount, cartState.discount);
    }

    public int hashCode() {
        return (((this.items.hashCode() * 31) + Long.hashCode(this.customerId)) * 31) + this.discount.hashCode();
    }

    public String toString() {
        return "CartState(items=" + this.items + ", customerId=" + this.customerId + ", discount=" + this.discount + ")";
    }

    public CartState(List<CartLine> items, long j, CartDiscount discount) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(discount, "discount");
        this.items = items;
        this.customerId = j;
        this.discount = discount;
    }

    public /* synthetic */ CartState(List list, long j, CartDiscount cartDiscount, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? new CartDiscount((String) null, AudioStats.AUDIO_AMPLITUDE_NONE, 3, (DefaultConstructorMarker) null) : cartDiscount);
    }

    public final List<CartLine> getItems() {
        return this.items;
    }

    public final long getCustomerId() {
        return this.customerId;
    }

    public final CartDiscount getDiscount() {
        return this.discount;
    }

    public final double qtyOf(long productId) {
        Object obj;
        Iterator<T> it = this.items.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((CartLine) obj).getProductId() == productId) {
                break;
            }
        }
        CartLine cartLine = (CartLine) obj;
        return cartLine != null ? cartLine.getQty() : AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public final CartTotals totals() {
        double d;
        Iterator<T> it = this.items.iterator();
        double d2 = 0.0d;
        while (it.hasNext()) {
            d2 += ((CartLine) it.next()).getSum();
        }
        if (this.discount.getValue() > AudioStats.AUDIO_AMPLITUDE_NONE) {
            boolean isPercent = this.discount.isPercent();
            CartDiscount cartDiscount = this.discount;
            if (isPercent) {
                d = Math.min(d2, (Math.min(100.0d, cartDiscount.getValue()) * d2) / 100.0d);
            } else {
                d = Math.min(d2, cartDiscount.getValue());
            }
        } else {
            d = 0.0d;
        }
        return new CartTotals(Num.INSTANCE.money(d2), Num.INSTANCE.money(d), Num.INSTANCE.money(Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, d2 - d)));
    }
}
