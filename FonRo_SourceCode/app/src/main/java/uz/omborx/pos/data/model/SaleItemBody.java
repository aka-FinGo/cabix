package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Sales.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB3\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J'\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J)\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001b\u0002\b,¢\u0006\u0002\b+R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R*\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0019¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0016Ê\u0001\u0002\b0Ê\u0001\f\b1\u0012\b\b2\u0012\u0004\b\u0003\u0010\u0002¨\u0006/"}, d2 = {"Luz/FonRo/pos/data/model/SaleItemBody;", "", "productId", "", FirebaseAnalytics.Param.QUANTITY, "", "discountAmount", "<init>", "(JDD)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJDDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getProductId$annotations", "()V", "getProductId", "()J", "Lkotlinx/serialization/SerialName;", "value", FirebaseAnalytics.Param.PRODUCT_ID, "getQuantity", "()D", "getDiscountAmount$annotations", "getDiscountAmount", "discount_amount", "component1", "component2", "component3", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class SaleItemBody {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double discountAmount;
    private final long productId;
    private final double quantity;

    public static /* synthetic */ SaleItemBody copy$default(SaleItemBody saleItemBody, long j, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = saleItemBody.productId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            d = saleItemBody.quantity;
        }
        double d3 = d;
        if ((i & 4) != 0) {
            d2 = saleItemBody.discountAmount;
        }
        return saleItemBody.copy(j2, d3, d2);
    }

    @SerialName("discount_amount")
    public static /* synthetic */ void getDiscountAmount$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PRODUCT_ID)
    public static /* synthetic */ void getProductId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getProductId() {
        return this.productId;
    }

    /* renamed from: component2, reason: from getter */
    public final double getQuantity() {
        return this.quantity;
    }

    /* renamed from: component3, reason: from getter */
    public final double getDiscountAmount() {
        return this.discountAmount;
    }

    public final SaleItemBody copy(long productId, double quantity, double discountAmount) {
        return new SaleItemBody(productId, quantity, discountAmount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleItemBody)) {
            return false;
        }
        SaleItemBody saleItemBody = (SaleItemBody) other;
        return this.productId == saleItemBody.productId && Double.compare(this.quantity, saleItemBody.quantity) == 0 && Double.compare(this.discountAmount, saleItemBody.discountAmount) == 0;
    }

    public int hashCode() {
        return (((Long.hashCode(this.productId) * 31) + Double.hashCode(this.quantity)) * 31) + Double.hashCode(this.discountAmount);
    }

    public String toString() {
        return "SaleItemBody(productId=" + this.productId + ", quantity=" + this.quantity + ", discountAmount=" + this.discountAmount + ")";
    }

    /* compiled from: Sales.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/SaleItemBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/SaleItemBody;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SaleItemBody> serializer() {
            return SaleItemBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SaleItemBody(int i, long j, double d, double d2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, SaleItemBody$$serializer.INSTANCE.getDescriptor());
        }
        this.productId = j;
        this.quantity = d;
        if ((i & 4) == 0) {
            this.discountAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.discountAmount = d2;
        }
    }

    public SaleItemBody(long j, double d, double d2) {
        this.productId = j;
        this.quantity = d;
        this.discountAmount = d2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(SaleItemBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.productId);
        output.encodeDoubleElement(serialDesc, 1, self.quantity);
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && Double.compare(self.discountAmount, AudioStats.AUDIO_AMPLITUDE_NONE) == 0) {
            return;
        }
        output.encodeDoubleElement(serialDesc, 2, self.discountAmount);
    }

    public /* synthetic */ SaleItemBody(long j, double d, double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, d, (i & 4) != 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : d2);
    }

    public final long getProductId() {
        return this.productId;
    }

    public final double getQuantity() {
        return this.quantity;
    }

    public final double getDiscountAmount() {
        return this.discountAmount;
    }
}
