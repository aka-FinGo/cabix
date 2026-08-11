package uz.FonRo.pos.ui.sale;

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
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: HeldCarts.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0002/0B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB=\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J1\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\fHÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0005HÖ\u0081\u0004J)\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001b\u0002\b.¢\u0006\u0002\b-R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aÊ\u0001\u0002\b2Ê\u0001\f\b3\u0012\b\b4\u0012\u0004\b\u0003\u0010\u0002¨\u00061"}, d2 = {"Luz/FonRo/pos/ui/sale/HeldItem;", "", "productId", "", "name", "", "qty", "", FirebaseAnalytics.Param.DISCOUNT, "<init>", "(JLjava/lang/String;DD)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;DDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getProductId$annotations", "()V", "getProductId", "()J", "Lkotlinx/serialization/SerialName;", "value", FirebaseAnalytics.Param.PRODUCT_ID, "getName", "()Ljava/lang/String;", "getQty", "()D", "getDiscount", "component1", "component2", "component3", "component4", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes7.dex */
public final /* data */ class HeldItem {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double discount;
    private final String name;
    private final long productId;
    private final double qty;

    public HeldItem() {
        this(0L, (String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ HeldItem copy$default(HeldItem heldItem, long j, String str, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = heldItem.productId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = heldItem.name;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            d = heldItem.qty;
        }
        double d3 = d;
        if ((i & 8) != 0) {
            d2 = heldItem.discount;
        }
        return heldItem.copy(j2, str2, d3, d2);
    }

    @SerialName(FirebaseAnalytics.Param.PRODUCT_ID)
    public static /* synthetic */ void getProductId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getProductId() {
        return this.productId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final double getQty() {
        return this.qty;
    }

    /* renamed from: component4, reason: from getter */
    public final double getDiscount() {
        return this.discount;
    }

    public final HeldItem copy(long productId, String name, double qty, double discount) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new HeldItem(productId, name, qty, discount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HeldItem)) {
            return false;
        }
        HeldItem heldItem = (HeldItem) other;
        return this.productId == heldItem.productId && Intrinsics.areEqual(this.name, heldItem.name) && Double.compare(this.qty, heldItem.qty) == 0 && Double.compare(this.discount, heldItem.discount) == 0;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.productId) * 31) + this.name.hashCode()) * 31) + Double.hashCode(this.qty)) * 31) + Double.hashCode(this.discount);
    }

    public String toString() {
        return "HeldItem(productId=" + this.productId + ", name=" + this.name + ", qty=" + this.qty + ", discount=" + this.discount + ")";
    }

    /* compiled from: HeldCarts.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/ui/sale/HeldItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/ui/sale/HeldItem;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<HeldItem> serializer() {
            return HeldItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ HeldItem(int i, long j, String str, double d, double d2, SerializationConstructorMarker serializationConstructorMarker) {
        this.productId = (i & 1) == 0 ? 0L : j;
        if ((i & 2) == 0) {
            this.name = "";
        } else {
            this.name = str;
        }
        if ((i & 4) == 0) {
            this.qty = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.qty = d;
        }
        if ((i & 8) == 0) {
            this.discount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.discount = d2;
        }
    }

    public HeldItem(long j, String name, double d, double d2) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.productId = j;
        this.name = name;
        this.qty = d;
        this.discount = d2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(HeldItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.productId != 0) {
            output.encodeLongElement(serialDesc, 0, self.productId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.name, "")) {
            output.encodeStringElement(serialDesc, 1, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || Double.compare(self.qty, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeDoubleElement(serialDesc, 2, self.qty);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && Double.compare(self.discount, AudioStats.AUDIO_AMPLITUDE_NONE) == 0) {
            return;
        }
        output.encodeDoubleElement(serialDesc, 3, self.discount);
    }

    public final long getProductId() {
        return this.productId;
    }

    public /* synthetic */ HeldItem(long j, String str, double d, double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? 0.0d : d, (i & 8) != 0 ? 0.0d : d2);
    }

    public final String getName() {
        return this.name;
    }

    public final double getQty() {
        return this.qty;
    }

    public final double getDiscount() {
        return this.discount;
    }
}
