package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 Q2\u00020\u0001:\u0002PQBo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011Bu\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0010\u0010\u0016J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\t\u0010=\u001a\u00020\nHÆ\u0003J\t\u0010>\u001a\u00020\nHÆ\u0003J\t\u0010?\u001a\u00020\nHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u000eHÆ\u0003Js\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0014\u0010C\u001a\u00020\u00062\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010E\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010F\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0001b\u0002\bO¢\u0006\u0002\bNR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R*\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004r\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( ¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR,\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(#¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u0018R*\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004r\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(&¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\u001dR*\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004r\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(*¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u001b\u001a\u0004\b(\u0010)R*\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004r\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(-¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u001b\u001a\u0004\b,\u0010)R*\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004r\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(0¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001b\u001a\u0004\b/\u0010)R,\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004r\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(4¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u001b\u001a\u0004\b2\u00103R,\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004r\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(7¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010\u001b\u001a\u0004\b6\u00103Ê\u0001\u0002\bSÊ\u0001\f\bT\u0012\b\bU\u0012\u0004\b\u0003\u0010\u0000¨\u0006R"}, d2 = {"Luz/FonRo/pos/data/model/ShopInfoBody;", "", "name", "", "about", "onlineShopEnabled", "", "shopCurrency", "deliveryEnabled", "deliveryPrice", "", "freeDeliveryRadiusKm", "freeDeliveryMinTotal", "locationLat", "Lkotlinx/serialization/json/JsonElement;", "locationLng", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZDDDLkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/json/JsonElement;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZDDDLkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getAbout", "getOnlineShopEnabled$annotations", "()V", "getOnlineShopEnabled", "()Z", "Lkotlinx/serialization/SerialName;", "value", "online_shop_enabled", "getShopCurrency$annotations", "getShopCurrency", "shop_currency", "getDeliveryEnabled$annotations", "getDeliveryEnabled", "delivery_enabled", "getDeliveryPrice$annotations", "getDeliveryPrice", "()D", "delivery_price", "getFreeDeliveryRadiusKm$annotations", "getFreeDeliveryRadiusKm", "free_delivery_radius_km", "getFreeDeliveryMinTotal$annotations", "getFreeDeliveryMinTotal", "free_delivery_min_total", "getLocationLat$annotations", "getLocationLat", "()Lkotlinx/serialization/json/JsonElement;", "location_lat", "getLocationLng$annotations", "getLocationLng", "location_lng", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ShopInfoBody {
    private final String about;
    private final boolean deliveryEnabled;
    private final double deliveryPrice;
    private final double freeDeliveryMinTotal;
    private final double freeDeliveryRadiusKm;
    private final JsonElement locationLat;
    private final JsonElement locationLng;
    private final String name;
    private final boolean onlineShopEnabled;
    private final String shopCurrency;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ ShopInfoBody copy$default(ShopInfoBody shopInfoBody, String str, String str2, boolean z, String str3, boolean z2, double d, double d2, double d3, JsonElement jsonElement, JsonElement jsonElement2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopInfoBody.name;
        }
        return shopInfoBody.copy(str, (i & 2) != 0 ? shopInfoBody.about : str2, (i & 4) != 0 ? shopInfoBody.onlineShopEnabled : z, (i & 8) != 0 ? shopInfoBody.shopCurrency : str3, (i & 16) != 0 ? shopInfoBody.deliveryEnabled : z2, (i & 32) != 0 ? shopInfoBody.deliveryPrice : d, (i & 64) != 0 ? shopInfoBody.freeDeliveryRadiusKm : d2, (i & 128) != 0 ? shopInfoBody.freeDeliveryMinTotal : d3, (i & 256) != 0 ? shopInfoBody.locationLat : jsonElement, (i & 512) != 0 ? shopInfoBody.locationLng : jsonElement2);
    }

    @SerialName("delivery_enabled")
    public static /* synthetic */ void getDeliveryEnabled$annotations() {
    }

    @SerialName("delivery_price")
    public static /* synthetic */ void getDeliveryPrice$annotations() {
    }

    @SerialName("free_delivery_min_total")
    public static /* synthetic */ void getFreeDeliveryMinTotal$annotations() {
    }

    @SerialName("free_delivery_radius_km")
    public static /* synthetic */ void getFreeDeliveryRadiusKm$annotations() {
    }

    @SerialName("location_lat")
    public static /* synthetic */ void getLocationLat$annotations() {
    }

    @SerialName("location_lng")
    public static /* synthetic */ void getLocationLng$annotations() {
    }

    @SerialName("online_shop_enabled")
    public static /* synthetic */ void getOnlineShopEnabled$annotations() {
    }

    @SerialName("shop_currency")
    public static /* synthetic */ void getShopCurrency$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component10, reason: from getter */
    public final JsonElement getLocationLng() {
        return this.locationLng;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAbout() {
        return this.about;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getOnlineShopEnabled() {
        return this.onlineShopEnabled;
    }

    /* renamed from: component4, reason: from getter */
    public final String getShopCurrency() {
        return this.shopCurrency;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getDeliveryEnabled() {
        return this.deliveryEnabled;
    }

    /* renamed from: component6, reason: from getter */
    public final double getDeliveryPrice() {
        return this.deliveryPrice;
    }

    /* renamed from: component7, reason: from getter */
    public final double getFreeDeliveryRadiusKm() {
        return this.freeDeliveryRadiusKm;
    }

    /* renamed from: component8, reason: from getter */
    public final double getFreeDeliveryMinTotal() {
        return this.freeDeliveryMinTotal;
    }

    /* renamed from: component9, reason: from getter */
    public final JsonElement getLocationLat() {
        return this.locationLat;
    }

    public final ShopInfoBody copy(String name, String about, boolean onlineShopEnabled, String shopCurrency, boolean deliveryEnabled, double deliveryPrice, double freeDeliveryRadiusKm, double freeDeliveryMinTotal, JsonElement locationLat, JsonElement locationLng) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(about, "about");
        return new ShopInfoBody(name, about, onlineShopEnabled, shopCurrency, deliveryEnabled, deliveryPrice, freeDeliveryRadiusKm, freeDeliveryMinTotal, locationLat, locationLng);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShopInfoBody)) {
            return false;
        }
        ShopInfoBody shopInfoBody = (ShopInfoBody) other;
        return Intrinsics.areEqual(this.name, shopInfoBody.name) && Intrinsics.areEqual(this.about, shopInfoBody.about) && this.onlineShopEnabled == shopInfoBody.onlineShopEnabled && Intrinsics.areEqual(this.shopCurrency, shopInfoBody.shopCurrency) && this.deliveryEnabled == shopInfoBody.deliveryEnabled && Double.compare(this.deliveryPrice, shopInfoBody.deliveryPrice) == 0 && Double.compare(this.freeDeliveryRadiusKm, shopInfoBody.freeDeliveryRadiusKm) == 0 && Double.compare(this.freeDeliveryMinTotal, shopInfoBody.freeDeliveryMinTotal) == 0 && Intrinsics.areEqual(this.locationLat, shopInfoBody.locationLat) && Intrinsics.areEqual(this.locationLng, shopInfoBody.locationLng);
    }

    public int hashCode() {
        int hashCode = ((((this.name.hashCode() * 31) + this.about.hashCode()) * 31) + Boolean.hashCode(this.onlineShopEnabled)) * 31;
        String str = this.shopCurrency;
        int hashCode2 = (((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.deliveryEnabled)) * 31) + Double.hashCode(this.deliveryPrice)) * 31) + Double.hashCode(this.freeDeliveryRadiusKm)) * 31) + Double.hashCode(this.freeDeliveryMinTotal)) * 31;
        JsonElement jsonElement = this.locationLat;
        int hashCode3 = (hashCode2 + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
        JsonElement jsonElement2 = this.locationLng;
        return hashCode3 + (jsonElement2 != null ? jsonElement2.hashCode() : 0);
    }

    public String toString() {
        return "ShopInfoBody(name=" + this.name + ", about=" + this.about + ", onlineShopEnabled=" + this.onlineShopEnabled + ", shopCurrency=" + this.shopCurrency + ", deliveryEnabled=" + this.deliveryEnabled + ", deliveryPrice=" + this.deliveryPrice + ", freeDeliveryRadiusKm=" + this.freeDeliveryRadiusKm + ", freeDeliveryMinTotal=" + this.freeDeliveryMinTotal + ", locationLat=" + this.locationLat + ", locationLng=" + this.locationLng + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/ShopInfoBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/ShopInfoBody;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ShopInfoBody> serializer() {
            return ShopInfoBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ShopInfoBody(int i, String str, String str2, boolean z, String str3, boolean z2, double d, double d2, double d3, JsonElement jsonElement, JsonElement jsonElement2, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, ShopInfoBody$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        if ((i & 2) == 0) {
            this.about = "";
        } else {
            this.about = str2;
        }
        if ((i & 4) == 0) {
            this.onlineShopEnabled = true;
        } else {
            this.onlineShopEnabled = z;
        }
        if ((i & 8) == 0) {
            this.shopCurrency = null;
        } else {
            this.shopCurrency = str3;
        }
        if ((i & 16) == 0) {
            this.deliveryEnabled = false;
        } else {
            this.deliveryEnabled = z2;
        }
        if ((i & 32) == 0) {
            this.deliveryPrice = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.deliveryPrice = d;
        }
        if ((i & 64) == 0) {
            this.freeDeliveryRadiusKm = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.freeDeliveryRadiusKm = d2;
        }
        if ((i & 128) == 0) {
            this.freeDeliveryMinTotal = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.freeDeliveryMinTotal = d3;
        }
        if ((i & 256) == 0) {
            this.locationLat = null;
        } else {
            this.locationLat = jsonElement;
        }
        if ((i & 512) == 0) {
            this.locationLng = null;
        } else {
            this.locationLng = jsonElement2;
        }
    }

    public ShopInfoBody(String name, String about, boolean z, String str, boolean z2, double d, double d2, double d3, JsonElement jsonElement, JsonElement jsonElement2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(about, "about");
        this.name = name;
        this.about = about;
        this.onlineShopEnabled = z;
        this.shopCurrency = str;
        this.deliveryEnabled = z2;
        this.deliveryPrice = d;
        this.freeDeliveryRadiusKm = d2;
        this.freeDeliveryMinTotal = d3;
        this.locationLat = jsonElement;
        this.locationLng = jsonElement2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(ShopInfoBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.name);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.about, "")) {
            output.encodeStringElement(serialDesc, 1, self.about);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !self.onlineShopEnabled) {
            output.encodeBooleanElement(serialDesc, 2, self.onlineShopEnabled);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.shopCurrency != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.shopCurrency);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.deliveryEnabled) {
            output.encodeBooleanElement(serialDesc, 4, self.deliveryEnabled);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || Double.compare(self.deliveryPrice, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeDoubleElement(serialDesc, 5, self.deliveryPrice);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || Double.compare(self.freeDeliveryRadiusKm, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeDoubleElement(serialDesc, 6, self.freeDeliveryRadiusKm);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || Double.compare(self.freeDeliveryMinTotal, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeDoubleElement(serialDesc, 7, self.freeDeliveryMinTotal);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.locationLat != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, JsonElementSerializer.INSTANCE, self.locationLat);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 9) && self.locationLng == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 9, JsonElementSerializer.INSTANCE, self.locationLng);
    }

    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ ShopInfoBody(java.lang.String r14, java.lang.String r15, boolean r16, java.lang.String r17, boolean r18, double r19, double r21, double r23, kotlinx.serialization.json.JsonElement r25, kotlinx.serialization.json.JsonElement r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r13 = this;
            r0 = r27
            r1 = r0 & 2
            if (r1 == 0) goto L9
            java.lang.String r1 = ""
            goto La
        L9:
            r1 = r15
        La:
            r2 = r0 & 4
            if (r2 == 0) goto L10
            r2 = 1
            goto L12
        L10:
            r2 = r16
        L12:
            r3 = r0 & 8
            r4 = 0
            if (r3 == 0) goto L19
            r3 = r4
            goto L1b
        L19:
            r3 = r17
        L1b:
            r5 = r0 & 16
            if (r5 == 0) goto L21
            r5 = 0
            goto L23
        L21:
            r5 = r18
        L23:
            r6 = r0 & 32
            r7 = 0
            if (r6 == 0) goto L2b
            r9 = r7
            goto L2d
        L2b:
            r9 = r19
        L2d:
            r6 = r0 & 64
            if (r6 == 0) goto L33
            r11 = r7
            goto L35
        L33:
            r11 = r21
        L35:
            r6 = r0 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L3a
            goto L3c
        L3a:
            r7 = r23
        L3c:
            r6 = r0 & 256(0x100, float:3.59E-43)
            if (r6 == 0) goto L42
            r6 = r4
            goto L44
        L42:
            r6 = r25
        L44:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L4b
            r28 = r4
            goto L4d
        L4b:
            r28 = r26
        L4d:
            r15 = r13
            r16 = r14
            r17 = r1
            r18 = r2
            r19 = r3
            r20 = r5
            r27 = r6
            r25 = r7
            r21 = r9
            r23 = r11
            r15.<init>(r16, r17, r18, r19, r20, r21, r23, r25, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.data.model.ShopInfoBody.<init>(java.lang.String, java.lang.String, boolean, java.lang.String, boolean, double, double, double, kotlinx.serialization.json.JsonElement, kotlinx.serialization.json.JsonElement, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getAbout() {
        return this.about;
    }

    public final boolean getOnlineShopEnabled() {
        return this.onlineShopEnabled;
    }

    public final String getShopCurrency() {
        return this.shopCurrency;
    }

    public final boolean getDeliveryEnabled() {
        return this.deliveryEnabled;
    }

    public final double getDeliveryPrice() {
        return this.deliveryPrice;
    }

    public final double getFreeDeliveryRadiusKm() {
        return this.freeDeliveryRadiusKm;
    }

    public final double getFreeDeliveryMinTotal() {
        return this.freeDeliveryMinTotal;
    }

    public final JsonElement getLocationLat() {
        return this.locationLat;
    }

    public final JsonElement getLocationLng() {
        return this.locationLng;
    }
}
