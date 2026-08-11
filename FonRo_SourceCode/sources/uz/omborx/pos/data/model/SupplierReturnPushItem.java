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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 A2\u00020\u0001:\u0002@AB?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rBW\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003JO\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0014\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00105\u001a\u00020\u000fHÖ\u0081\u0004J\n\u00106\u001a\u00020\u0006HÖ\u0081\u0004J)\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0001b\u0002\b?¢\u0006\u0002\b>R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R*\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001c¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016R*\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b( ¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R*\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(%¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0014\u001a\u0004\b$\u0010\u001fR*\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b((¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010\"R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"Ê\u0001\u0002\bCÊ\u0001\f\bD\u0012\b\bE\u0012\u0004\b\u0003\u0010\u0002¨\u0006B"}, d2 = {"Luz/FonRo/pos/data/model/SupplierReturnPushItem;", "", "productId", "", "productServerId", "productName", "", FirebaseAnalytics.Param.QUANTITY, "", "productUnit", "purchasePrice", "amount", "<init>", "(JJLjava/lang/String;DLjava/lang/String;DD)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJLjava/lang/String;DLjava/lang/String;DDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getProductId$annotations", "()V", "getProductId", "()J", "Lkotlinx/serialization/SerialName;", "value", FirebaseAnalytics.Param.PRODUCT_ID, "getProductServerId$annotations", "getProductServerId", "product_server_id", "getProductName$annotations", "getProductName", "()Ljava/lang/String;", FirebaseAnalytics.Param.PRODUCT_NAME, "getQuantity", "()D", "getProductUnit$annotations", "getProductUnit", "product_unit", "getPurchasePrice$annotations", "getPurchasePrice", "purchase_price", "getAmount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class SupplierReturnPushItem {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double amount;
    private final long productId;
    private final String productName;
    private final long productServerId;
    private final String productUnit;
    private final double purchasePrice;
    private final double quantity;

    public static /* synthetic */ SupplierReturnPushItem copy$default(SupplierReturnPushItem supplierReturnPushItem, long j, long j2, String str, double d, String str2, double d2, double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = supplierReturnPushItem.productId;
        }
        return supplierReturnPushItem.copy(j, (i & 2) != 0 ? supplierReturnPushItem.productServerId : j2, (i & 4) != 0 ? supplierReturnPushItem.productName : str, (i & 8) != 0 ? supplierReturnPushItem.quantity : d, (i & 16) != 0 ? supplierReturnPushItem.productUnit : str2, (i & 32) != 0 ? supplierReturnPushItem.purchasePrice : d2, (i & 64) != 0 ? supplierReturnPushItem.amount : d3);
    }

    @SerialName(FirebaseAnalytics.Param.PRODUCT_ID)
    public static /* synthetic */ void getProductId$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PRODUCT_NAME)
    public static /* synthetic */ void getProductName$annotations() {
    }

    @SerialName("product_server_id")
    public static /* synthetic */ void getProductServerId$annotations() {
    }

    @SerialName("product_unit")
    public static /* synthetic */ void getProductUnit$annotations() {
    }

    @SerialName("purchase_price")
    public static /* synthetic */ void getPurchasePrice$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getProductId() {
        return this.productId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getProductServerId() {
        return this.productServerId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getProductName() {
        return this.productName;
    }

    /* renamed from: component4, reason: from getter */
    public final double getQuantity() {
        return this.quantity;
    }

    /* renamed from: component5, reason: from getter */
    public final String getProductUnit() {
        return this.productUnit;
    }

    /* renamed from: component6, reason: from getter */
    public final double getPurchasePrice() {
        return this.purchasePrice;
    }

    /* renamed from: component7, reason: from getter */
    public final double getAmount() {
        return this.amount;
    }

    public final SupplierReturnPushItem copy(long productId, long productServerId, String productName, double quantity, String productUnit, double purchasePrice, double amount) {
        Intrinsics.checkNotNullParameter(productName, "productName");
        Intrinsics.checkNotNullParameter(productUnit, "productUnit");
        return new SupplierReturnPushItem(productId, productServerId, productName, quantity, productUnit, purchasePrice, amount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SupplierReturnPushItem)) {
            return false;
        }
        SupplierReturnPushItem supplierReturnPushItem = (SupplierReturnPushItem) other;
        return this.productId == supplierReturnPushItem.productId && this.productServerId == supplierReturnPushItem.productServerId && Intrinsics.areEqual(this.productName, supplierReturnPushItem.productName) && Double.compare(this.quantity, supplierReturnPushItem.quantity) == 0 && Intrinsics.areEqual(this.productUnit, supplierReturnPushItem.productUnit) && Double.compare(this.purchasePrice, supplierReturnPushItem.purchasePrice) == 0 && Double.compare(this.amount, supplierReturnPushItem.amount) == 0;
    }

    public int hashCode() {
        return (((((((((((Long.hashCode(this.productId) * 31) + Long.hashCode(this.productServerId)) * 31) + this.productName.hashCode()) * 31) + Double.hashCode(this.quantity)) * 31) + this.productUnit.hashCode()) * 31) + Double.hashCode(this.purchasePrice)) * 31) + Double.hashCode(this.amount);
    }

    public String toString() {
        return "SupplierReturnPushItem(productId=" + this.productId + ", productServerId=" + this.productServerId + ", productName=" + this.productName + ", quantity=" + this.quantity + ", productUnit=" + this.productUnit + ", purchasePrice=" + this.purchasePrice + ", amount=" + this.amount + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/SupplierReturnPushItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/SupplierReturnPushItem;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SupplierReturnPushItem> serializer() {
            return SupplierReturnPushItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SupplierReturnPushItem(int i, long j, long j2, String str, double d, String str2, double d2, double d3, SerializationConstructorMarker serializationConstructorMarker) {
        if (127 != (i & 127)) {
            PluginExceptionsKt.throwMissingFieldException(i, 127, SupplierReturnPushItem$$serializer.INSTANCE.getDescriptor());
        }
        this.productId = j;
        this.productServerId = j2;
        this.productName = str;
        this.quantity = d;
        this.productUnit = str2;
        this.purchasePrice = d2;
        this.amount = d3;
    }

    public SupplierReturnPushItem(long j, long j2, String productName, double d, String productUnit, double d2, double d3) {
        Intrinsics.checkNotNullParameter(productName, "productName");
        Intrinsics.checkNotNullParameter(productUnit, "productUnit");
        this.productId = j;
        this.productServerId = j2;
        this.productName = productName;
        this.quantity = d;
        this.productUnit = productUnit;
        this.purchasePrice = d2;
        this.amount = d3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(SupplierReturnPushItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.productId);
        output.encodeLongElement(serialDesc, 1, self.productServerId);
        output.encodeStringElement(serialDesc, 2, self.productName);
        output.encodeDoubleElement(serialDesc, 3, self.quantity);
        output.encodeStringElement(serialDesc, 4, self.productUnit);
        output.encodeDoubleElement(serialDesc, 5, self.purchasePrice);
        output.encodeDoubleElement(serialDesc, 6, self.amount);
    }

    public final long getProductId() {
        return this.productId;
    }

    public final long getProductServerId() {
        return this.productServerId;
    }

    public final String getProductName() {
        return this.productName;
    }

    public final double getQuantity() {
        return this.quantity;
    }

    public final String getProductUnit() {
        return this.productUnit;
    }

    public final double getPurchasePrice() {
        return this.purchasePrice;
    }

    public final double getAmount() {
        return this.amount;
    }
}
