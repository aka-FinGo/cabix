package uz.FonRo.pos.ui.sale;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: SaleState.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013Ê\u0001\f\b&\u0012\b\b'\u0012\u0004\b\u0003\u0010\u0002¨\u0006%"}, d2 = {"Luz/FonRo/pos/ui/sale/CartLine;", "", "productId", "", "name", "", "unit", FirebaseAnalytics.Param.PRICE, "", "qty", FirebaseAnalytics.Param.DISCOUNT, "<init>", "(JLjava/lang/String;Ljava/lang/String;DDD)V", "getProductId", "()J", "getName", "()Ljava/lang/String;", "getUnit", "getPrice", "()D", "getQty", "getDiscount", "sum", "getSum", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class CartLine {
    public static final int $stable = 0;
    private final double discount;
    private final String name;
    private final double price;
    private final long productId;
    private final double qty;
    private final String unit;

    public static /* synthetic */ CartLine copy$default(CartLine cartLine, long j, String str, String str2, double d, double d2, double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = cartLine.productId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = cartLine.name;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = cartLine.unit;
        }
        return cartLine.copy(j2, str3, str2, (i & 8) != 0 ? cartLine.price : d, (i & 16) != 0 ? cartLine.qty : d2, (i & 32) != 0 ? cartLine.discount : d3);
    }

    /* renamed from: component1, reason: from getter */
    public final long getProductId() {
        return this.productId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUnit() {
        return this.unit;
    }

    /* renamed from: component4, reason: from getter */
    public final double getPrice() {
        return this.price;
    }

    /* renamed from: component5, reason: from getter */
    public final double getQty() {
        return this.qty;
    }

    /* renamed from: component6, reason: from getter */
    public final double getDiscount() {
        return this.discount;
    }

    public final CartLine copy(long productId, String name, String unit, double price, double qty, double discount) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return new CartLine(productId, name, unit, price, qty, discount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CartLine)) {
            return false;
        }
        CartLine cartLine = (CartLine) other;
        return this.productId == cartLine.productId && Intrinsics.areEqual(this.name, cartLine.name) && Intrinsics.areEqual(this.unit, cartLine.unit) && Double.compare(this.price, cartLine.price) == 0 && Double.compare(this.qty, cartLine.qty) == 0 && Double.compare(this.discount, cartLine.discount) == 0;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.productId) * 31) + this.name.hashCode()) * 31) + this.unit.hashCode()) * 31) + Double.hashCode(this.price)) * 31) + Double.hashCode(this.qty)) * 31) + Double.hashCode(this.discount);
    }

    public String toString() {
        return "CartLine(productId=" + this.productId + ", name=" + this.name + ", unit=" + this.unit + ", price=" + this.price + ", qty=" + this.qty + ", discount=" + this.discount + ")";
    }

    public CartLine(long j, String name, String unit, double d, double d2, double d3) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.productId = j;
        this.name = name;
        this.unit = unit;
        this.price = d;
        this.qty = d2;
        this.discount = d3;
    }

    public /* synthetic */ CartLine(long j, String str, String str2, double d, double d2, double d3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, str2, d, d2, (i & 32) != 0 ? 0.0d : d3);
    }

    public final long getProductId() {
        return this.productId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUnit() {
        return this.unit;
    }

    public final double getPrice() {
        return this.price;
    }

    public final double getQty() {
        return this.qty;
    }

    public final double getDiscount() {
        return this.discount;
    }

    public final double getSum() {
        return Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, (this.price * this.qty) - this.discount);
    }
}
