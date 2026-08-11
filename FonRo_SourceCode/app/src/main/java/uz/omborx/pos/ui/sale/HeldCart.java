package uz.FonRo.pos.ui.sale;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: HeldCarts.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000278B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rBQ\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JA\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0014\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010,\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010-\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001b\u0002\b6¢\u0006\u0002\b5R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0014R*\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"Ê\u0001\u0002\b:Ê\u0001\f\b;\u0012\b\b<\u0012\u0004\b\u0003\u0010\u0000¨\u00069"}, d2 = {"Luz/FonRo/pos/ui/sale/HeldCart;", "", "id", "", "createdAt", "customerId", "", FirebaseAnalytics.Param.DISCOUNT, "Luz/FonRo/pos/ui/sale/CartDiscount;", FirebaseAnalytics.Param.ITEMS, "", "Luz/FonRo/pos/ui/sale/HeldItem;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLuz/FonRo/pos/ui/sale/CartDiscount;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;JLuz/FonRo/pos/ui/sale/CartDiscount;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getCreatedAt$annotations", "()V", "getCreatedAt", "Lkotlinx/serialization/SerialName;", "value", "created_at", "getCustomerId$annotations", "getCustomerId", "()J", "customer_id", "getDiscount", "()Luz/FonRo/pos/ui/sale/CartDiscount;", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes7.dex */
public final /* data */ class HeldCart {
    private final String createdAt;
    private final long customerId;
    private final CartDiscount discount;
    private final String id;
    private final List<HeldItem> items;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = CartDiscount.$stable;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.ui.sale.HeldCart$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = HeldCart._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public HeldCart() {
        this((String) null, (String) null, 0L, (CartDiscount) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(HeldItem$$serializer.INSTANCE);
    }

    public static /* synthetic */ HeldCart copy$default(HeldCart heldCart, String str, String str2, long j, CartDiscount cartDiscount, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = heldCart.id;
        }
        if ((i & 2) != 0) {
            str2 = heldCart.createdAt;
        }
        if ((i & 4) != 0) {
            j = heldCart.customerId;
        }
        if ((i & 8) != 0) {
            cartDiscount = heldCart.discount;
        }
        if ((i & 16) != 0) {
            list = heldCart.items;
        }
        long j2 = j;
        return heldCart.copy(str, str2, j2, cartDiscount, list);
    }

    @SerialName("created_at")
    public static /* synthetic */ void getCreatedAt$annotations() {
    }

    @SerialName("customer_id")
    public static /* synthetic */ void getCustomerId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component3, reason: from getter */
    public final long getCustomerId() {
        return this.customerId;
    }

    /* renamed from: component4, reason: from getter */
    public final CartDiscount getDiscount() {
        return this.discount;
    }

    public final List<HeldItem> component5() {
        return this.items;
    }

    public final HeldCart copy(String id, String createdAt, long customerId, CartDiscount discount, List<HeldItem> items) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(discount, "discount");
        Intrinsics.checkNotNullParameter(items, "items");
        return new HeldCart(id, createdAt, customerId, discount, items);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HeldCart)) {
            return false;
        }
        HeldCart heldCart = (HeldCart) other;
        return Intrinsics.areEqual(this.id, heldCart.id) && Intrinsics.areEqual(this.createdAt, heldCart.createdAt) && this.customerId == heldCart.customerId && Intrinsics.areEqual(this.discount, heldCart.discount) && Intrinsics.areEqual(this.items, heldCart.items);
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.createdAt.hashCode()) * 31) + Long.hashCode(this.customerId)) * 31) + this.discount.hashCode()) * 31) + this.items.hashCode();
    }

    public String toString() {
        return "HeldCart(id=" + this.id + ", createdAt=" + this.createdAt + ", customerId=" + this.customerId + ", discount=" + this.discount + ", items=" + this.items + ")";
    }

    /* compiled from: HeldCarts.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/ui/sale/HeldCart$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/ui/sale/HeldCart;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<HeldCart> serializer() {
            return HeldCart$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ HeldCart(int i, String str, String str2, long j, CartDiscount cartDiscount, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.id = "";
        } else {
            this.id = str;
        }
        if ((i & 2) == 0) {
            this.createdAt = "";
        } else {
            this.createdAt = str2;
        }
        if ((i & 4) == 0) {
            this.customerId = 0L;
        } else {
            this.customerId = j;
        }
        if ((i & 8) == 0) {
            this.discount = new CartDiscount((String) null, AudioStats.AUDIO_AMPLITUDE_NONE, 3, (DefaultConstructorMarker) null);
        } else {
            this.discount = cartDiscount;
        }
        if ((i & 16) == 0) {
            this.items = CollectionsKt.emptyList();
        } else {
            this.items = list;
        }
    }

    public HeldCart(String id, String createdAt, long j, CartDiscount discount, List<HeldItem> items) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(discount, "discount");
        Intrinsics.checkNotNullParameter(items, "items");
        this.id = id;
        this.createdAt = createdAt;
        this.customerId = j;
        this.discount = discount;
        this.items = items;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(HeldCart self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.id, "")) {
            output.encodeStringElement(serialDesc, 0, self.id);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.createdAt, "")) {
            output.encodeStringElement(serialDesc, 1, self.createdAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.customerId != 0) {
            output.encodeLongElement(serialDesc, 2, self.customerId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.discount, new CartDiscount((String) null, AudioStats.AUDIO_AMPLITUDE_NONE, 3, (DefaultConstructorMarker) null))) {
            output.encodeSerializableElement(serialDesc, 3, CartDiscount$$serializer.INSTANCE, self.discount);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && Intrinsics.areEqual(self.items, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.items);
    }

    public /* synthetic */ HeldCart(String str, String str2, long j, CartDiscount cartDiscount, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? 0L : j, (i & 8) != 0 ? new CartDiscount((String) null, AudioStats.AUDIO_AMPLITUDE_NONE, 3, (DefaultConstructorMarker) null) : cartDiscount, (i & 16) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getId() {
        return this.id;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final long getCustomerId() {
        return this.customerId;
    }

    public final CartDiscount getDiscount() {
        return this.discount;
    }

    public final List<HeldItem> getItems() {
        return this.items;
    }
}
