package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import uz.FonRo.pos.data.net.LenientDouble;

/* compiled from: Stats.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0002/0B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tB=\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J1\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001b\u0002\b.¢\u0006\u0002\b-R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\t0\u0017¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\t0\u0017¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014R*\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\t0\u0017¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014Ê\u0001\u0002\b\u0015Ê\u0001\f\b2\u0012\b\b3\u0012\u0004\b\u0003\u0010\u0002¨\u00061"}, d2 = {"Luz/FonRo/pos/data/model/StatsProduct;", "", "name", "", "revenue", "", "profit", "qty", "<init>", "(Ljava/lang/String;DDD)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;DDDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getRevenue$annotations", "()V", "getRevenue", "()D", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientDouble;", "getProfit$annotations", "getProfit", "getQty$annotations", "getQty", "component1", "component2", "component3", "component4", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class StatsProduct {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String name;
    private final double profit;
    private final double qty;
    private final double revenue;

    public StatsProduct() {
        this((String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ StatsProduct copy$default(StatsProduct statsProduct, String str, double d, double d2, double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = statsProduct.name;
        }
        if ((i & 2) != 0) {
            d = statsProduct.revenue;
        }
        if ((i & 4) != 0) {
            d2 = statsProduct.profit;
        }
        if ((i & 8) != 0) {
            d3 = statsProduct.qty;
        }
        double d4 = d3;
        return statsProduct.copy(str, d, d2, d4);
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getProfit$annotations() {
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getQty$annotations() {
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getRevenue$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final double getRevenue() {
        return this.revenue;
    }

    /* renamed from: component3, reason: from getter */
    public final double getProfit() {
        return this.profit;
    }

    /* renamed from: component4, reason: from getter */
    public final double getQty() {
        return this.qty;
    }

    public final StatsProduct copy(String name, double revenue, double profit, double qty) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new StatsProduct(name, revenue, profit, qty);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatsProduct)) {
            return false;
        }
        StatsProduct statsProduct = (StatsProduct) other;
        return Intrinsics.areEqual(this.name, statsProduct.name) && Double.compare(this.revenue, statsProduct.revenue) == 0 && Double.compare(this.profit, statsProduct.profit) == 0 && Double.compare(this.qty, statsProduct.qty) == 0;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + Double.hashCode(this.revenue)) * 31) + Double.hashCode(this.profit)) * 31) + Double.hashCode(this.qty);
    }

    public String toString() {
        return "StatsProduct(name=" + this.name + ", revenue=" + this.revenue + ", profit=" + this.profit + ", qty=" + this.qty + ")";
    }

    /* compiled from: Stats.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/StatsProduct$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/StatsProduct;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<StatsProduct> serializer() {
            return StatsProduct$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ StatsProduct(int i, String str, double d, double d2, double d3, SerializationConstructorMarker serializationConstructorMarker) {
        this.name = (i & 1) == 0 ? "" : str;
        if ((i & 2) == 0) {
            this.revenue = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.revenue = d;
        }
        if ((i & 4) == 0) {
            this.profit = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.profit = d2;
        }
        if ((i & 8) == 0) {
            this.qty = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.qty = d3;
        }
    }

    public StatsProduct(String name, double d, double d2, double d3) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.revenue = d;
        this.profit = d2;
        this.qty = d3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(StatsProduct self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.name, "")) {
            output.encodeStringElement(serialDesc, 0, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || Double.compare(self.revenue, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 1, LenientDouble.INSTANCE, Double.valueOf(self.revenue));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || Double.compare(self.profit, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 2, LenientDouble.INSTANCE, Double.valueOf(self.profit));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && Double.compare(self.qty, AudioStats.AUDIO_AMPLITUDE_NONE) == 0) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 3, LenientDouble.INSTANCE, Double.valueOf(self.qty));
    }

    public /* synthetic */ StatsProduct(String str, double d, double d2, double d3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0.0d : d, (i & 4) != 0 ? 0.0d : d2, (i & 8) != 0 ? 0.0d : d3);
    }

    public final String getName() {
        return this.name;
    }

    public final double getRevenue() {
        return this.revenue;
    }

    public final double getProfit() {
        return this.profit;
    }

    public final double getQty() {
        return this.qty;
    }
}
