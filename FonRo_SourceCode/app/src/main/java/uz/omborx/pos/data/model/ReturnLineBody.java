package uz.FonRo.pos.data.model;

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
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB3\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J'\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\nHÖ\u0081\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J)\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001b\u0002\b,¢\u0006\u0002\b+R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R*\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019Ê\u0001\u0002\b0Ê\u0001\f\b1\u0012\b\b2\u0012\u0004\b\u0003\u0010\u0002¨\u0006/"}, d2 = {"Luz/FonRo/pos/data/model/ReturnLineBody;", "", "saleItemId", "", "productId", FirebaseAnalytics.Param.QUANTITY, "", "<init>", "(JJD)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSaleItemId$annotations", "()V", "getSaleItemId", "()J", "Lkotlinx/serialization/SerialName;", "value", "sale_item_id", "getProductId$annotations", "getProductId", FirebaseAnalytics.Param.PRODUCT_ID, "getQuantity", "()D", "component1", "component2", "component3", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ReturnLineBody {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long productId;
    private final double quantity;
    private final long saleItemId;

    public static /* synthetic */ ReturnLineBody copy$default(ReturnLineBody returnLineBody, long j, long j2, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            j = returnLineBody.saleItemId;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = returnLineBody.productId;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            d = returnLineBody.quantity;
        }
        return returnLineBody.copy(j3, j4, d);
    }

    @SerialName(FirebaseAnalytics.Param.PRODUCT_ID)
    public static /* synthetic */ void getProductId$annotations() {
    }

    @SerialName("sale_item_id")
    public static /* synthetic */ void getSaleItemId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getSaleItemId() {
        return this.saleItemId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getProductId() {
        return this.productId;
    }

    /* renamed from: component3, reason: from getter */
    public final double getQuantity() {
        return this.quantity;
    }

    public final ReturnLineBody copy(long saleItemId, long productId, double quantity) {
        return new ReturnLineBody(saleItemId, productId, quantity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReturnLineBody)) {
            return false;
        }
        ReturnLineBody returnLineBody = (ReturnLineBody) other;
        return this.saleItemId == returnLineBody.saleItemId && this.productId == returnLineBody.productId && Double.compare(this.quantity, returnLineBody.quantity) == 0;
    }

    public int hashCode() {
        return (((Long.hashCode(this.saleItemId) * 31) + Long.hashCode(this.productId)) * 31) + Double.hashCode(this.quantity);
    }

    public String toString() {
        return "ReturnLineBody(saleItemId=" + this.saleItemId + ", productId=" + this.productId + ", quantity=" + this.quantity + ")";
    }

    /* compiled from: Sales.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/ReturnLineBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/ReturnLineBody;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ReturnLineBody> serializer() {
            return ReturnLineBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ReturnLineBody(int i, long j, long j2, double d, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, ReturnLineBody$$serializer.INSTANCE.getDescriptor());
        }
        this.saleItemId = j;
        this.productId = j2;
        this.quantity = d;
    }

    public ReturnLineBody(long j, long j2, double d) {
        this.saleItemId = j;
        this.productId = j2;
        this.quantity = d;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(ReturnLineBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.saleItemId);
        output.encodeLongElement(serialDesc, 1, self.productId);
        output.encodeDoubleElement(serialDesc, 2, self.quantity);
    }

    public final long getSaleItemId() {
        return this.saleItemId;
    }

    public final long getProductId() {
        return this.productId;
    }

    public final double getQuantity() {
        return this.quantity;
    }
}
