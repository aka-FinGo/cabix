package uz.FonRo.pos.data.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 52\u00020\u0001:\u000245B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tBA\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J<\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010%J\u0014\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010)\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010*\u001a\u00020\u0005HÖ\u0081\u0004J)\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001b\u0002\b3¢\u0006\u0002\b2R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R.\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001c¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR,\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001f¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0017Ê\u0001\u0002\b7Ê\u0001\f\b8\u0012\b\b9\u0012\u0004\b\u0003\u0010\u0002¨\u00066"}, d2 = {"Luz/FonRo/pos/data/model/OrderIdBody;", "", "orderId", "", "reason", "", "saleId", "transactionId", "<init>", "(JLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOrderId$annotations", "()V", "getOrderId", "()J", "Lkotlinx/serialization/SerialName;", "value", "order_id", "getReason", "()Ljava/lang/String;", "getSaleId$annotations", "getSaleId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "sale_id", "getTransactionId$annotations", "getTransactionId", FirebaseAnalytics.Param.TRANSACTION_ID, "component1", "component2", "component3", "component4", "copy", "(JLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Luz/FonRo/pos/data/model/OrderIdBody;", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class OrderIdBody {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long orderId;
    private final String reason;
    private final Long saleId;
    private final String transactionId;

    public static /* synthetic */ OrderIdBody copy$default(OrderIdBody orderIdBody, long j, String str, Long l, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = orderIdBody.orderId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = orderIdBody.reason;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            l = orderIdBody.saleId;
        }
        Long l2 = l;
        if ((i & 8) != 0) {
            str2 = orderIdBody.transactionId;
        }
        return orderIdBody.copy(j2, str3, l2, str2);
    }

    @SerialName("order_id")
    public static /* synthetic */ void getOrderId$annotations() {
    }

    @SerialName("sale_id")
    public static /* synthetic */ void getSaleId$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.TRANSACTION_ID)
    public static /* synthetic */ void getTransactionId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getOrderId() {
        return this.orderId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getSaleId() {
        return this.saleId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTransactionId() {
        return this.transactionId;
    }

    public final OrderIdBody copy(long orderId, String reason, Long saleId, String transactionId) {
        return new OrderIdBody(orderId, reason, saleId, transactionId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderIdBody)) {
            return false;
        }
        OrderIdBody orderIdBody = (OrderIdBody) other;
        return this.orderId == orderIdBody.orderId && Intrinsics.areEqual(this.reason, orderIdBody.reason) && Intrinsics.areEqual(this.saleId, orderIdBody.saleId) && Intrinsics.areEqual(this.transactionId, orderIdBody.transactionId);
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.orderId) * 31;
        String str = this.reason;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.saleId;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.transactionId;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "OrderIdBody(orderId=" + this.orderId + ", reason=" + this.reason + ", saleId=" + this.saleId + ", transactionId=" + this.transactionId + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/OrderIdBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/OrderIdBody;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OrderIdBody> serializer() {
            return OrderIdBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ OrderIdBody(int i, long j, String str, Long l, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, OrderIdBody$$serializer.INSTANCE.getDescriptor());
        }
        this.orderId = j;
        if ((i & 2) == 0) {
            this.reason = null;
        } else {
            this.reason = str;
        }
        if ((i & 4) == 0) {
            this.saleId = null;
        } else {
            this.saleId = l;
        }
        if ((i & 8) == 0) {
            this.transactionId = null;
        } else {
            this.transactionId = str2;
        }
    }

    public OrderIdBody(long j, String str, Long l, String str2) {
        this.orderId = j;
        this.reason = str;
        this.saleId = l;
        this.transactionId = str2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(OrderIdBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.orderId);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.reason != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.reason);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.saleId != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, LongSerializer.INSTANCE, self.saleId);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.transactionId == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.transactionId);
    }

    public /* synthetic */ OrderIdBody(long j, String str, Long l, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str2);
    }

    public final long getOrderId() {
        return this.orderId;
    }

    public final String getReason() {
        return this.reason;
    }

    public final Long getSaleId() {
        return this.saleId;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }
}
