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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 C2\u00020\u0001:\u0002BCBC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\rBW\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\t\u00101\u001a\u00020\bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003JQ\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0014\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00107\u001a\u00020\u000fHÖ\u0081\u0004J\n\u00108\u001a\u00020\u0006HÖ\u0081\u0004J)\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0001b\u0002\bA¢\u0006\u0002\b@R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R*\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001c¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016R*\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b( ¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R*\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(%¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0014\u001a\u0004\b$\u0010\"R*\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b((¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010\"R,\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(+¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0014\u001a\u0004\b*\u0010\u001fÊ\u0001\u0002\bEÊ\u0001\f\bF\u0012\b\bG\u0012\u0004\b\u0003\u0010\u0002¨\u0006D"}, d2 = {"Luz/FonRo/pos/data/model/StockInPushItem;", "", "productId", "", "productServerId", "productName", "", FirebaseAnalytics.Param.QUANTITY, "", "purchasePrice", "salePrice", "expirationDate", "<init>", "(JJLjava/lang/String;DDDLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJLjava/lang/String;DDDLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getProductId$annotations", "()V", "getProductId", "()J", "Lkotlinx/serialization/SerialName;", "value", FirebaseAnalytics.Param.PRODUCT_ID, "getProductServerId$annotations", "getProductServerId", "product_server_id", "getProductName$annotations", "getProductName", "()Ljava/lang/String;", FirebaseAnalytics.Param.PRODUCT_NAME, "getQuantity", "()D", "getPurchasePrice$annotations", "getPurchasePrice", "purchase_price", "getSalePrice$annotations", "getSalePrice", "sale_price", "getExpirationDate$annotations", "getExpirationDate", "expiration_date", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class StockInPushItem {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String expirationDate;
    private final long productId;
    private final String productName;
    private final long productServerId;
    private final double purchasePrice;
    private final double quantity;
    private final double salePrice;

    public static /* synthetic */ StockInPushItem copy$default(StockInPushItem stockInPushItem, long j, long j2, String str, double d, double d2, double d3, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = stockInPushItem.productId;
        }
        return stockInPushItem.copy(j, (i & 2) != 0 ? stockInPushItem.productServerId : j2, (i & 4) != 0 ? stockInPushItem.productName : str, (i & 8) != 0 ? stockInPushItem.quantity : d, (i & 16) != 0 ? stockInPushItem.purchasePrice : d2, (i & 32) != 0 ? stockInPushItem.salePrice : d3, (i & 64) != 0 ? stockInPushItem.expirationDate : str2);
    }

    @SerialName("expiration_date")
    public static /* synthetic */ void getExpirationDate$annotations() {
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

    @SerialName("purchase_price")
    public static /* synthetic */ void getPurchasePrice$annotations() {
    }

    @SerialName("sale_price")
    public static /* synthetic */ void getSalePrice$annotations() {
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
    public final double getPurchasePrice() {
        return this.purchasePrice;
    }

    /* renamed from: component6, reason: from getter */
    public final double getSalePrice() {
        return this.salePrice;
    }

    /* renamed from: component7, reason: from getter */
    public final String getExpirationDate() {
        return this.expirationDate;
    }

    public final StockInPushItem copy(long productId, long productServerId, String productName, double quantity, double purchasePrice, double salePrice, String expirationDate) {
        Intrinsics.checkNotNullParameter(productName, "productName");
        return new StockInPushItem(productId, productServerId, productName, quantity, purchasePrice, salePrice, expirationDate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StockInPushItem)) {
            return false;
        }
        StockInPushItem stockInPushItem = (StockInPushItem) other;
        return this.productId == stockInPushItem.productId && this.productServerId == stockInPushItem.productServerId && Intrinsics.areEqual(this.productName, stockInPushItem.productName) && Double.compare(this.quantity, stockInPushItem.quantity) == 0 && Double.compare(this.purchasePrice, stockInPushItem.purchasePrice) == 0 && Double.compare(this.salePrice, stockInPushItem.salePrice) == 0 && Intrinsics.areEqual(this.expirationDate, stockInPushItem.expirationDate);
    }

    public int hashCode() {
        int hashCode = ((((((((((Long.hashCode(this.productId) * 31) + Long.hashCode(this.productServerId)) * 31) + this.productName.hashCode()) * 31) + Double.hashCode(this.quantity)) * 31) + Double.hashCode(this.purchasePrice)) * 31) + Double.hashCode(this.salePrice)) * 31;
        String str = this.expirationDate;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "StockInPushItem(productId=" + this.productId + ", productServerId=" + this.productServerId + ", productName=" + this.productName + ", quantity=" + this.quantity + ", purchasePrice=" + this.purchasePrice + ", salePrice=" + this.salePrice + ", expirationDate=" + this.expirationDate + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/StockInPushItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/StockInPushItem;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<StockInPushItem> serializer() {
            return StockInPushItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ StockInPushItem(int i, long j, long j2, String str, double d, double d2, double d3, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i, 63, StockInPushItem$$serializer.INSTANCE.getDescriptor());
        }
        this.productId = j;
        this.productServerId = j2;
        this.productName = str;
        this.quantity = d;
        this.purchasePrice = d2;
        this.salePrice = d3;
        if ((i & 64) == 0) {
            this.expirationDate = null;
        } else {
            this.expirationDate = str2;
        }
    }

    public StockInPushItem(long j, long j2, String productName, double d, double d2, double d3, String str) {
        Intrinsics.checkNotNullParameter(productName, "productName");
        this.productId = j;
        this.productServerId = j2;
        this.productName = productName;
        this.quantity = d;
        this.purchasePrice = d2;
        this.salePrice = d3;
        this.expirationDate = str;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(StockInPushItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.productId);
        output.encodeLongElement(serialDesc, 1, self.productServerId);
        output.encodeStringElement(serialDesc, 2, self.productName);
        output.encodeDoubleElement(serialDesc, 3, self.quantity);
        output.encodeDoubleElement(serialDesc, 4, self.purchasePrice);
        output.encodeDoubleElement(serialDesc, 5, self.salePrice);
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.expirationDate == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.expirationDate);
    }

    public /* synthetic */ StockInPushItem(long j, long j2, String str, double d, double d2, double d3, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, str, d, d2, d3, (i & 64) != 0 ? null : str2);
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

    public final double getPurchasePrice() {
        return this.purchasePrice;
    }

    public final double getSalePrice() {
        return this.salePrice;
    }

    public final String getExpirationDate() {
        return this.expirationDate;
    }
}
