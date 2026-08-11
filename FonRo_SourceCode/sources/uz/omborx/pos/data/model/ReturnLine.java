package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Sales.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 72\u00020\u0001:\u000267B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB;\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J1\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010+\u001a\u00020,HÖ\u0081\u0004J)\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0001b\u0002\b5¢\u0006\u0002\b4R8\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\t0\u0018¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R8\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001br\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\t0\u0018¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R*\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\t0\u001f¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u001eR*\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\t0\u001f¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u001eÊ\u0001\u0002\b\u0016Ê\u0001\f\b9\u0012\b\b:\u0012\u0004\b\u0003\u0010\u0002¨\u00068"}, d2 = {"Luz/FonRo/pos/data/model/ReturnLine;", "", "saleItemId", "", "productId", FirebaseAnalytics.Param.QUANTITY, "", "amount", "<init>", "(JJDD)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJDDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSaleItemId$annotations", "()V", "getSaleItemId", "()J", "Lkotlinx/serialization/SerialName;", "value", "sale_item_id", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getProductId$annotations", "getProductId", FirebaseAnalytics.Param.PRODUCT_ID, "getQuantity$annotations", "getQuantity", "()D", "Luz/FonRo/pos/data/net/LenientDouble;", "getAmount$annotations", "getAmount", "component1", "component2", "component3", "component4", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ReturnLine {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double amount;
    private final long productId;
    private final double quantity;
    private final long saleItemId;

    public ReturnLine() {
        this(0L, 0L, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ReturnLine copy$default(ReturnLine returnLine, long j, long j2, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = returnLine.saleItemId;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = returnLine.productId;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            d = returnLine.quantity;
        }
        return returnLine.copy(j3, j4, d, (i & 8) != 0 ? returnLine.amount : d2);
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getAmount$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PRODUCT_ID)
    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getProductId$annotations() {
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getQuantity$annotations() {
    }

    @SerialName("sale_item_id")
    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getSaleItemId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getSaleItemId() {
        return this.saleItemId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getProductId() {
        return this.productId;
    }

    /* renamed from: component3, reason: from getter */
    public final double getQuantity() {
        return this.quantity;
    }

    /* renamed from: component4, reason: from getter */
    public final double getAmount() {
        return this.amount;
    }

    public final ReturnLine copy(long saleItemId, long productId, double quantity, double amount) {
        return new ReturnLine(saleItemId, productId, quantity, amount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReturnLine)) {
            return false;
        }
        ReturnLine returnLine = (ReturnLine) other;
        return this.saleItemId == returnLine.saleItemId && this.productId == returnLine.productId && Double.compare(this.quantity, returnLine.quantity) == 0 && Double.compare(this.amount, returnLine.amount) == 0;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.saleItemId) * 31) + Long.hashCode(this.productId)) * 31) + Double.hashCode(this.quantity)) * 31) + Double.hashCode(this.amount);
    }

    public String toString() {
        return "ReturnLine(saleItemId=" + this.saleItemId + ", productId=" + this.productId + ", quantity=" + this.quantity + ", amount=" + this.amount + ")";
    }

    /* compiled from: Sales.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/ReturnLine$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/ReturnLine;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ReturnLine> serializer() {
            return ReturnLine$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ReturnLine(int i, long j, long j2, double d, double d2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.saleItemId = 0L;
        } else {
            this.saleItemId = j;
        }
        if ((i & 2) == 0) {
            this.productId = 0L;
        } else {
            this.productId = j2;
        }
        if ((i & 4) == 0) {
            this.quantity = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.quantity = d;
        }
        if ((i & 8) == 0) {
            this.amount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.amount = d2;
        }
    }

    public ReturnLine(long j, long j2, double d, double d2) {
        this.saleItemId = j;
        this.productId = j2;
        this.quantity = d;
        this.amount = d2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(ReturnLine self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.saleItemId != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.saleItemId));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.productId != 0) {
            output.encodeSerializableElement(serialDesc, 1, LenientLong.INSTANCE, Long.valueOf(self.productId));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || Double.compare(self.quantity, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 2, LenientDouble.INSTANCE, Double.valueOf(self.quantity));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && Double.compare(self.amount, AudioStats.AUDIO_AMPLITUDE_NONE) == 0) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 3, LenientDouble.INSTANCE, Double.valueOf(self.amount));
    }

    public /* synthetic */ ReturnLine(long j, long j2, double d, double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2, (i & 4) != 0 ? 0.0d : d, (i & 8) != 0 ? 0.0d : d2);
    }

    public final long getSaleItemId() {
        return this.saleItemId;
    }

    public final long getProductId() {
        return this.productId;
    }

    public final double getQuantity() {
        return this.quantity;
    }

    public final double getAmount() {
        return this.amount;
    }
}
