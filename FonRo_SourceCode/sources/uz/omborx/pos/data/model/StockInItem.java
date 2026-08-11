package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 H2\u00020\u0001:\u0002GHBQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\rBW\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00104\u001a\u00020\bHÆ\u0003J\t\u00105\u001a\u00020\bHÆ\u0003J\t\u00106\u001a\u00020\bHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0006HÆ\u0003JS\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0014\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010<\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010=\u001a\u00020\u0006HÖ\u0081\u0004J)\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0001b\u0002\bF¢\u0006\u0002\bER8\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\t0\u001c¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R8\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001fr\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\t0\u001c¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u0016R,\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(#¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0014\u001a\u0004\b!\u0010\"R*\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\t0'¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010&R8\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(*r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\t0'¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0014\u001a\u0004\b)\u0010&R8\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(-r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\t0'¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0014\u001a\u0004\b,\u0010&R,\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(0¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0014\u001a\u0004\b/\u0010\"Ê\u0001\u0002\b\u001aÊ\u0001\f\bJ\u0012\b\bK\u0012\u0004\b\u0003\u0010\u0002¨\u0006I"}, d2 = {"Luz/FonRo/pos/data/model/StockInItem;", "", "productId", "", "productServerId", "productName", "", FirebaseAnalytics.Param.QUANTITY, "", "purchasePrice", "salePrice", "expirationDate", "<init>", "(JJLjava/lang/String;DDDLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJLjava/lang/String;DDDLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getProductId$annotations", "()V", "getProductId", "()J", "Lkotlinx/serialization/SerialName;", "value", FirebaseAnalytics.Param.PRODUCT_ID, "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getProductServerId$annotations", "getProductServerId", "product_server_id", "getProductName$annotations", "getProductName", "()Ljava/lang/String;", FirebaseAnalytics.Param.PRODUCT_NAME, "getQuantity$annotations", "getQuantity", "()D", "Luz/FonRo/pos/data/net/LenientDouble;", "getPurchasePrice$annotations", "getPurchasePrice", "purchase_price", "getSalePrice$annotations", "getSalePrice", "sale_price", "getExpirationDate$annotations", "getExpirationDate", "expiration_date", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class StockInItem {
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

    public StockInItem() {
        this(0L, 0L, (String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ StockInItem copy$default(StockInItem stockInItem, long j, long j2, String str, double d, double d2, double d3, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = stockInItem.productId;
        }
        return stockInItem.copy(j, (i & 2) != 0 ? stockInItem.productServerId : j2, (i & 4) != 0 ? stockInItem.productName : str, (i & 8) != 0 ? stockInItem.quantity : d, (i & 16) != 0 ? stockInItem.purchasePrice : d2, (i & 32) != 0 ? stockInItem.salePrice : d3, (i & 64) != 0 ? stockInItem.expirationDate : str2);
    }

    @SerialName("expiration_date")
    public static /* synthetic */ void getExpirationDate$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PRODUCT_ID)
    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getProductId$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PRODUCT_NAME)
    public static /* synthetic */ void getProductName$annotations() {
    }

    @SerialName("product_server_id")
    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getProductServerId$annotations() {
    }

    @SerialName("purchase_price")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getPurchasePrice$annotations() {
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getQuantity$annotations() {
    }

    @SerialName("sale_price")
    @Serializable(with = LenientDouble.class)
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

    public final StockInItem copy(long productId, long productServerId, String productName, double quantity, double purchasePrice, double salePrice, String expirationDate) {
        return new StockInItem(productId, productServerId, productName, quantity, purchasePrice, salePrice, expirationDate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StockInItem)) {
            return false;
        }
        StockInItem stockInItem = (StockInItem) other;
        return this.productId == stockInItem.productId && this.productServerId == stockInItem.productServerId && Intrinsics.areEqual(this.productName, stockInItem.productName) && Double.compare(this.quantity, stockInItem.quantity) == 0 && Double.compare(this.purchasePrice, stockInItem.purchasePrice) == 0 && Double.compare(this.salePrice, stockInItem.salePrice) == 0 && Intrinsics.areEqual(this.expirationDate, stockInItem.expirationDate);
    }

    public int hashCode() {
        int hashCode = ((Long.hashCode(this.productId) * 31) + Long.hashCode(this.productServerId)) * 31;
        String str = this.productName;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Double.hashCode(this.quantity)) * 31) + Double.hashCode(this.purchasePrice)) * 31) + Double.hashCode(this.salePrice)) * 31;
        String str2 = this.expirationDate;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "StockInItem(productId=" + this.productId + ", productServerId=" + this.productServerId + ", productName=" + this.productName + ", quantity=" + this.quantity + ", purchasePrice=" + this.purchasePrice + ", salePrice=" + this.salePrice + ", expirationDate=" + this.expirationDate + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/StockInItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/StockInItem;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<StockInItem> serializer() {
            return StockInItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ StockInItem(int i, long j, long j2, String str, double d, double d2, double d3, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.productId = 0L;
        } else {
            this.productId = j;
        }
        if ((i & 2) == 0) {
            this.productServerId = 0L;
        } else {
            this.productServerId = j2;
        }
        if ((i & 4) == 0) {
            this.productName = null;
        } else {
            this.productName = str;
        }
        if ((i & 8) == 0) {
            this.quantity = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.quantity = d;
        }
        if ((i & 16) == 0) {
            this.purchasePrice = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.purchasePrice = d2;
        }
        if ((i & 32) == 0) {
            this.salePrice = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.salePrice = d3;
        }
        if ((i & 64) == 0) {
            this.expirationDate = null;
        } else {
            this.expirationDate = str2;
        }
    }

    public StockInItem(long j, long j2, String str, double d, double d2, double d3, String str2) {
        this.productId = j;
        this.productServerId = j2;
        this.productName = str;
        this.quantity = d;
        this.purchasePrice = d2;
        this.salePrice = d3;
        this.expirationDate = str2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(StockInItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.productId != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.productId));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.productServerId != 0) {
            output.encodeSerializableElement(serialDesc, 1, LenientLong.INSTANCE, Long.valueOf(self.productServerId));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.productName != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.productName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || Double.compare(self.quantity, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 3, LenientDouble.INSTANCE, Double.valueOf(self.quantity));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || Double.compare(self.purchasePrice, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 4, LenientDouble.INSTANCE, Double.valueOf(self.purchasePrice));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || Double.compare(self.salePrice, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 5, LenientDouble.INSTANCE, Double.valueOf(self.salePrice));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.expirationDate == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.expirationDate);
    }

    public /* synthetic */ StockInItem(long j, long j2, String str, double d, double d2, double d3, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) == 0 ? j2 : 0L, (i & 4) != 0 ? null : str, (i & 8) != 0 ? 0.0d : d, (i & 16) != 0 ? 0.0d : d2, (i & 32) == 0 ? d3 : AudioStats.AUDIO_AMPLITUDE_NONE, (i & 64) != 0 ? null : str2);
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
