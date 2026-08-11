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
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 B2\u00020\u0001:\u0002ABBG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fBO\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003JI\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0014\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00106\u001a\u00020\u000eHÖ\u0081\u0004J\n\u00107\u001a\u00020\u0005HÖ\u0081\u0004J)\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0001b\u0002\b@¢\u0006\u0002\b?R8\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\t0\u001b¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R,\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001f¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u001eR*\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\t0#¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\"R,\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(&¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0013\u001a\u0004\b%\u0010\u001eR8\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b()r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\t0#¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0013\u001a\u0004\b(\u0010\"R*\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\t0#¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0013\u001a\u0004\b+\u0010\"Ê\u0001\u0002\b\u0019Ê\u0001\f\bD\u0012\b\bE\u0012\u0004\b\u0003\u0010\u0002¨\u0006C"}, d2 = {"Luz/FonRo/pos/data/model/SupplierReturnItem;", "", "productId", "", "productName", "", FirebaseAnalytics.Param.QUANTITY, "", "productUnit", "purchasePrice", "amount", "<init>", "(JLjava/lang/String;DLjava/lang/String;DD)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;DLjava/lang/String;DDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getProductId$annotations", "()V", "getProductId", "()J", "Lkotlinx/serialization/SerialName;", "value", FirebaseAnalytics.Param.PRODUCT_ID, "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getProductName$annotations", "getProductName", "()Ljava/lang/String;", FirebaseAnalytics.Param.PRODUCT_NAME, "getQuantity$annotations", "getQuantity", "()D", "Luz/FonRo/pos/data/net/LenientDouble;", "getProductUnit$annotations", "getProductUnit", "product_unit", "getPurchasePrice$annotations", "getPurchasePrice", "purchase_price", "getAmount$annotations", "getAmount", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class SupplierReturnItem {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double amount;
    private final long productId;
    private final String productName;
    private final String productUnit;
    private final double purchasePrice;
    private final double quantity;

    public SupplierReturnItem() {
        this(0L, (String) null, AudioStats.AUDIO_AMPLITUDE_NONE, (String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SupplierReturnItem copy$default(SupplierReturnItem supplierReturnItem, long j, String str, double d, String str2, double d2, double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = supplierReturnItem.productId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = supplierReturnItem.productName;
        }
        return supplierReturnItem.copy(j2, str, (i & 4) != 0 ? supplierReturnItem.quantity : d, (i & 8) != 0 ? supplierReturnItem.productUnit : str2, (i & 16) != 0 ? supplierReturnItem.purchasePrice : d2, (i & 32) != 0 ? supplierReturnItem.amount : d3);
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getAmount$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PRODUCT_ID)
    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getProductId$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PRODUCT_NAME)
    public static /* synthetic */ void getProductName$annotations() {
    }

    @SerialName("product_unit")
    public static /* synthetic */ void getProductUnit$annotations() {
    }

    @SerialName("purchase_price")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getPurchasePrice$annotations() {
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getQuantity$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getProductId() {
        return this.productId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getProductName() {
        return this.productName;
    }

    /* renamed from: component3, reason: from getter */
    public final double getQuantity() {
        return this.quantity;
    }

    /* renamed from: component4, reason: from getter */
    public final String getProductUnit() {
        return this.productUnit;
    }

    /* renamed from: component5, reason: from getter */
    public final double getPurchasePrice() {
        return this.purchasePrice;
    }

    /* renamed from: component6, reason: from getter */
    public final double getAmount() {
        return this.amount;
    }

    public final SupplierReturnItem copy(long productId, String productName, double quantity, String productUnit, double purchasePrice, double amount) {
        return new SupplierReturnItem(productId, productName, quantity, productUnit, purchasePrice, amount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SupplierReturnItem)) {
            return false;
        }
        SupplierReturnItem supplierReturnItem = (SupplierReturnItem) other;
        return this.productId == supplierReturnItem.productId && Intrinsics.areEqual(this.productName, supplierReturnItem.productName) && Double.compare(this.quantity, supplierReturnItem.quantity) == 0 && Intrinsics.areEqual(this.productUnit, supplierReturnItem.productUnit) && Double.compare(this.purchasePrice, supplierReturnItem.purchasePrice) == 0 && Double.compare(this.amount, supplierReturnItem.amount) == 0;
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.productId) * 31;
        String str = this.productName;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Double.hashCode(this.quantity)) * 31;
        String str2 = this.productUnit;
        return ((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Double.hashCode(this.purchasePrice)) * 31) + Double.hashCode(this.amount);
    }

    public String toString() {
        return "SupplierReturnItem(productId=" + this.productId + ", productName=" + this.productName + ", quantity=" + this.quantity + ", productUnit=" + this.productUnit + ", purchasePrice=" + this.purchasePrice + ", amount=" + this.amount + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/SupplierReturnItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/SupplierReturnItem;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SupplierReturnItem> serializer() {
            return SupplierReturnItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SupplierReturnItem(int i, long j, String str, double d, String str2, double d2, double d3, SerializationConstructorMarker serializationConstructorMarker) {
        this.productId = (i & 1) == 0 ? 0L : j;
        if ((i & 2) == 0) {
            this.productName = null;
        } else {
            this.productName = str;
        }
        if ((i & 4) == 0) {
            this.quantity = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.quantity = d;
        }
        if ((i & 8) == 0) {
            this.productUnit = null;
        } else {
            this.productUnit = str2;
        }
        if ((i & 16) == 0) {
            this.purchasePrice = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.purchasePrice = d2;
        }
        if ((i & 32) == 0) {
            this.amount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.amount = d3;
        }
    }

    public SupplierReturnItem(long j, String str, double d, String str2, double d2, double d3) {
        this.productId = j;
        this.productName = str;
        this.quantity = d;
        this.productUnit = str2;
        this.purchasePrice = d2;
        this.amount = d3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(SupplierReturnItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.productId != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.productId));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.productName != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.productName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || Double.compare(self.quantity, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 2, LenientDouble.INSTANCE, Double.valueOf(self.quantity));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.productUnit != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.productUnit);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || Double.compare(self.purchasePrice, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 4, LenientDouble.INSTANCE, Double.valueOf(self.purchasePrice));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && Double.compare(self.amount, AudioStats.AUDIO_AMPLITUDE_NONE) == 0) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 5, LenientDouble.INSTANCE, Double.valueOf(self.amount));
    }

    public /* synthetic */ SupplierReturnItem(long j, String str, double d, String str2, double d2, double d3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? 0.0d : d, (i & 8) == 0 ? str2 : null, (i & 16) != 0 ? 0.0d : d2, (i & 32) != 0 ? 0.0d : d3);
    }

    public final long getProductId() {
        return this.productId;
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
