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
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 ?2\u00020\u0001:\u0002>?BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fBO\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003JI\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00103\u001a\u00020\u000eHÖ\u0081\u0004J\n\u00104\u001a\u00020\u0005HÖ\u0081\u0004J)\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001b\u0002\b=¢\u0006\u0002\b<R8\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\t0\u001b¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R,\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001f¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u001eR*\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\t0#¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\"R*\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\t0#¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0013\u001a\u0004\b%\u0010\"R*\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\t0#¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0013\u001a\u0004\b'\u0010\"R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eÊ\u0001\u0002\b\u0019Ê\u0001\f\bA\u0012\b\bB\u0012\u0004\b\u0003\u0010\u0002¨\u0006@"}, d2 = {"Luz/FonRo/pos/data/model/ShopOrderItem;", "", "productId", "", "productName", "", FirebaseAnalytics.Param.QUANTITY, "", FirebaseAnalytics.Param.PRICE, "amount", "unit", "<init>", "(JLjava/lang/String;DDDLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;DDDLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getProductId$annotations", "()V", "getProductId", "()J", "Lkotlinx/serialization/SerialName;", "value", FirebaseAnalytics.Param.PRODUCT_ID, "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getProductName$annotations", "getProductName", "()Ljava/lang/String;", FirebaseAnalytics.Param.PRODUCT_NAME, "getQuantity$annotations", "getQuantity", "()D", "Luz/FonRo/pos/data/net/LenientDouble;", "getPrice$annotations", "getPrice", "getAmount$annotations", "getAmount", "getUnit", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ShopOrderItem {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double amount;
    private final double price;
    private final long productId;
    private final String productName;
    private final double quantity;
    private final String unit;

    public ShopOrderItem() {
        this(0L, (String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopOrderItem copy$default(ShopOrderItem shopOrderItem, long j, String str, double d, double d2, double d3, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = shopOrderItem.productId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = shopOrderItem.productName;
        }
        return shopOrderItem.copy(j2, str, (i & 4) != 0 ? shopOrderItem.quantity : d, (i & 8) != 0 ? shopOrderItem.price : d2, (i & 16) != 0 ? shopOrderItem.amount : d3, (i & 32) != 0 ? shopOrderItem.unit : str2);
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getAmount$annotations() {
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getPrice$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PRODUCT_ID)
    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getProductId$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PRODUCT_NAME)
    public static /* synthetic */ void getProductName$annotations() {
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
    public final double getPrice() {
        return this.price;
    }

    /* renamed from: component5, reason: from getter */
    public final double getAmount() {
        return this.amount;
    }

    /* renamed from: component6, reason: from getter */
    public final String getUnit() {
        return this.unit;
    }

    public final ShopOrderItem copy(long productId, String productName, double quantity, double price, double amount, String unit) {
        return new ShopOrderItem(productId, productName, quantity, price, amount, unit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShopOrderItem)) {
            return false;
        }
        ShopOrderItem shopOrderItem = (ShopOrderItem) other;
        return this.productId == shopOrderItem.productId && Intrinsics.areEqual(this.productName, shopOrderItem.productName) && Double.compare(this.quantity, shopOrderItem.quantity) == 0 && Double.compare(this.price, shopOrderItem.price) == 0 && Double.compare(this.amount, shopOrderItem.amount) == 0 && Intrinsics.areEqual(this.unit, shopOrderItem.unit);
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.productId) * 31;
        String str = this.productName;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Double.hashCode(this.quantity)) * 31) + Double.hashCode(this.price)) * 31) + Double.hashCode(this.amount)) * 31;
        String str2 = this.unit;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ShopOrderItem(productId=" + this.productId + ", productName=" + this.productName + ", quantity=" + this.quantity + ", price=" + this.price + ", amount=" + this.amount + ", unit=" + this.unit + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/ShopOrderItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/ShopOrderItem;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ShopOrderItem> serializer() {
            return ShopOrderItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ShopOrderItem(int i, long j, String str, double d, double d2, double d3, String str2, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.price = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.price = d2;
        }
        if ((i & 16) == 0) {
            this.amount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.amount = d3;
        }
        if ((i & 32) == 0) {
            this.unit = null;
        } else {
            this.unit = str2;
        }
    }

    public ShopOrderItem(long j, String str, double d, double d2, double d3, String str2) {
        this.productId = j;
        this.productName = str;
        this.quantity = d;
        this.price = d2;
        this.amount = d3;
        this.unit = str2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(ShopOrderItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.productId != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.productId));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.productName != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.productName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || Double.compare(self.quantity, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 2, LenientDouble.INSTANCE, Double.valueOf(self.quantity));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || Double.compare(self.price, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 3, LenientDouble.INSTANCE, Double.valueOf(self.price));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || Double.compare(self.amount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 4, LenientDouble.INSTANCE, Double.valueOf(self.amount));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.unit == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.unit);
    }

    public /* synthetic */ ShopOrderItem(long j, String str, double d, double d2, double d3, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? 0.0d : d, (i & 8) != 0 ? 0.0d : d2, (i & 16) == 0 ? d3 : AudioStats.AUDIO_AMPLITUDE_NONE, (i & 32) != 0 ? null : str2);
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

    public final double getPrice() {
        return this.price;
    }

    public final double getAmount() {
        return this.amount;
    }

    public final String getUnit() {
        return this.unit;
    }
}
