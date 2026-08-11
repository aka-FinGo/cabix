package uz.FonRo.pos.data.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Auth.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J)\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0001b\u0002\b\u001d¢\u0006\u0002\b\u001cR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fÊ\u0001\u0002\b!Ê\u0001\f\b\"\u0012\b\b#\u0012\u0004\b\u0003\u0010\u0002¨\u0006 "}, d2 = {"Luz/FonRo/pos/data/model/CouponResponse;", "", FirebaseAnalytics.Param.COUPON, "Luz/FonRo/pos/data/model/Coupon;", "<init>", "(Luz/FonRo/pos/data/model/Coupon;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILuz/FonRo/pos/data/model/Coupon;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCoupon", "()Luz/FonRo/pos/data/model/Coupon;", "component1", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class CouponResponse {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Coupon coupon;

    /* JADX WARN: Multi-variable type inference failed */
    public CouponResponse() {
        this((Coupon) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ CouponResponse copy$default(CouponResponse couponResponse, Coupon coupon, int i, Object obj) {
        if ((i & 1) != 0) {
            coupon = couponResponse.coupon;
        }
        return couponResponse.copy(coupon);
    }

    /* renamed from: component1, reason: from getter */
    public final Coupon getCoupon() {
        return this.coupon;
    }

    public final CouponResponse copy(Coupon coupon) {
        return new CouponResponse(coupon);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CouponResponse) && Intrinsics.areEqual(this.coupon, ((CouponResponse) other).coupon);
    }

    public int hashCode() {
        Coupon coupon = this.coupon;
        if (coupon == null) {
            return 0;
        }
        return coupon.hashCode();
    }

    public String toString() {
        return "CouponResponse(coupon=" + this.coupon + ")";
    }

    /* compiled from: Auth.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/CouponResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/CouponResponse;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CouponResponse> serializer() {
            return CouponResponse$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CouponResponse(int i, Coupon coupon, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.coupon = null;
        } else {
            this.coupon = coupon;
        }
    }

    public CouponResponse(Coupon coupon) {
        this.coupon = coupon;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(CouponResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.coupon == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 0, Coupon$$serializer.INSTANCE, self.coupon);
    }

    public /* synthetic */ CouponResponse(Coupon coupon, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : coupon);
    }

    public final Coupon getCoupon() {
        return this.coupon;
    }
}
