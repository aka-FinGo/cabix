package uz.FonRo.pos.data.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
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
import uz.FonRo.pos.data.net.LenientInt;
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 K2\u00020\u0001:\u0002JKBW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eBg\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\tHÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003JY\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0014\u0010=\u001a\u0002022\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010?\u001a\u00020\tHÖ\u0081\u0004J\n\u0010@\u001a\u00020\u0005HÖ\u0081\u0004J)\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0001b\u0002\bI¢\u0006\u0002\bHR*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\t0\u0019¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR*\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( ¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u001bR*\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(#¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u001bR*\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\t0'¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010&R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR*\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(+¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0014\u001a\u0004\b*\u0010\u001bR*\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(.¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0014\u001a\u0004\b-\u0010\u001bR\u0011\u0010/\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b0\u0010\u001bR\u0011\u00101\u001a\u0002028F¢\u0006\u0006\u001a\u0004\b1\u00103Ê\u0001\u0002\b\u0017Ê\u0001\f\bM\u0012\b\bN\u0012\u0004\b\u0003\u0010\u0002¨\u0006L"}, d2 = {"Luz/FonRo/pos/data/model/ShopReview;", "", "id", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "", "productName", "customerName", "rating", "", "text", "replyText", "createdAt", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getType", "()Ljava/lang/String;", "getProductName$annotations", "getProductName", "Lkotlinx/serialization/SerialName;", "value", FirebaseAnalytics.Param.PRODUCT_NAME, "getCustomerName$annotations", "getCustomerName", "customer_name", "getRating$annotations", "getRating", "()I", "Luz/FonRo/pos/data/net/LenientInt;", "getText", "getReplyText$annotations", "getReplyText", "reply_text", "getCreatedAt$annotations", "getCreatedAt", "created_at", "key", "getKey", "isProduct", "", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ShopReview {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String createdAt;
    private final String customerName;
    private final long id;
    private final String productName;
    private final int rating;
    private final String replyText;
    private final String text;
    private final String type;

    public ShopReview() {
        this(0L, (String) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopReview copy$default(ShopReview shopReview, long j, String str, String str2, String str3, int i, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = shopReview.id;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            str = shopReview.type;
        }
        String str7 = str;
        if ((i2 & 4) != 0) {
            str2 = shopReview.productName;
        }
        String str8 = str2;
        if ((i2 & 8) != 0) {
            str3 = shopReview.customerName;
        }
        return shopReview.copy(j2, str7, str8, str3, (i2 & 16) != 0 ? shopReview.rating : i, (i2 & 32) != 0 ? shopReview.text : str4, (i2 & 64) != 0 ? shopReview.replyText : str5, (i2 & 128) != 0 ? shopReview.createdAt : str6);
    }

    @SerialName("created_at")
    public static /* synthetic */ void getCreatedAt$annotations() {
    }

    @SerialName("customer_name")
    public static /* synthetic */ void getCustomerName$annotations() {
    }

    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PRODUCT_NAME)
    public static /* synthetic */ void getProductName$annotations() {
    }

    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getRating$annotations() {
    }

    @SerialName("reply_text")
    public static /* synthetic */ void getReplyText$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getProductName() {
        return this.productName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCustomerName() {
        return this.customerName;
    }

    /* renamed from: component5, reason: from getter */
    public final int getRating() {
        return this.rating;
    }

    /* renamed from: component6, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component7, reason: from getter */
    public final String getReplyText() {
        return this.replyText;
    }

    /* renamed from: component8, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final ShopReview copy(long id, String type, String productName, String customerName, int rating, String text, String replyText, String createdAt) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(productName, "productName");
        Intrinsics.checkNotNullParameter(customerName, "customerName");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(replyText, "replyText");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        return new ShopReview(id, type, productName, customerName, rating, text, replyText, createdAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShopReview)) {
            return false;
        }
        ShopReview shopReview = (ShopReview) other;
        return this.id == shopReview.id && Intrinsics.areEqual(this.type, shopReview.type) && Intrinsics.areEqual(this.productName, shopReview.productName) && Intrinsics.areEqual(this.customerName, shopReview.customerName) && this.rating == shopReview.rating && Intrinsics.areEqual(this.text, shopReview.text) && Intrinsics.areEqual(this.replyText, shopReview.replyText) && Intrinsics.areEqual(this.createdAt, shopReview.createdAt);
    }

    public int hashCode() {
        return (((((((((((((Long.hashCode(this.id) * 31) + this.type.hashCode()) * 31) + this.productName.hashCode()) * 31) + this.customerName.hashCode()) * 31) + Integer.hashCode(this.rating)) * 31) + this.text.hashCode()) * 31) + this.replyText.hashCode()) * 31) + this.createdAt.hashCode();
    }

    public String toString() {
        return "ShopReview(id=" + this.id + ", type=" + this.type + ", productName=" + this.productName + ", customerName=" + this.customerName + ", rating=" + this.rating + ", text=" + this.text + ", replyText=" + this.replyText + ", createdAt=" + this.createdAt + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/ShopReview$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/ShopReview;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ShopReview> serializer() {
            return ShopReview$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ShopReview(int i, long j, String str, String str2, String str3, int i2, String str4, String str5, String str6, SerializationConstructorMarker serializationConstructorMarker) {
        this.id = (i & 1) == 0 ? 0L : j;
        if ((i & 2) == 0) {
            this.type = "store";
        } else {
            this.type = str;
        }
        if ((i & 4) == 0) {
            this.productName = "";
        } else {
            this.productName = str2;
        }
        if ((i & 8) == 0) {
            this.customerName = "";
        } else {
            this.customerName = str3;
        }
        if ((i & 16) == 0) {
            this.rating = 5;
        } else {
            this.rating = i2;
        }
        if ((i & 32) == 0) {
            this.text = "";
        } else {
            this.text = str4;
        }
        if ((i & 64) == 0) {
            this.replyText = "";
        } else {
            this.replyText = str5;
        }
        if ((i & 128) == 0) {
            this.createdAt = "";
        } else {
            this.createdAt = str6;
        }
    }

    public ShopReview(long j, String type, String productName, String customerName, int i, String text, String replyText, String createdAt) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(productName, "productName");
        Intrinsics.checkNotNullParameter(customerName, "customerName");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(replyText, "replyText");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        this.id = j;
        this.type = type;
        this.productName = productName;
        this.customerName = customerName;
        this.rating = i;
        this.text = text;
        this.replyText = replyText;
        this.createdAt = createdAt;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(ShopReview self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.type, "store")) {
            output.encodeStringElement(serialDesc, 1, self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.productName, "")) {
            output.encodeStringElement(serialDesc, 2, self.productName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.customerName, "")) {
            output.encodeStringElement(serialDesc, 3, self.customerName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.rating != 5) {
            output.encodeSerializableElement(serialDesc, 4, LenientInt.INSTANCE, Integer.valueOf(self.rating));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.text, "")) {
            output.encodeStringElement(serialDesc, 5, self.text);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.replyText, "")) {
            output.encodeStringElement(serialDesc, 6, self.replyText);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 7) && Intrinsics.areEqual(self.createdAt, "")) {
            return;
        }
        output.encodeStringElement(serialDesc, 7, self.createdAt);
    }

    public final long getId() {
        return this.id;
    }

    public /* synthetic */ ShopReview(long j, String str, String str2, String str3, int i, String str4, String str5, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? "store" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? 5 : i, (i2 & 32) != 0 ? "" : str4, (i2 & 64) != 0 ? "" : str5, (i2 & 128) != 0 ? "" : str6);
    }

    public final String getType() {
        return this.type;
    }

    public final String getProductName() {
        return this.productName;
    }

    public final String getCustomerName() {
        return this.customerName;
    }

    public final int getRating() {
        return this.rating;
    }

    public final String getText() {
        return this.text;
    }

    public final String getReplyText() {
        return this.replyText;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getKey() {
        return this.type + "-" + this.id;
    }

    public final boolean isProduct() {
        return Intrinsics.areEqual(this.type, "product");
    }
}
