package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientInt;

/* compiled from: Stats.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB3\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J'\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J)\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001b\u0002\b,¢\u0006\u0002\b+R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\t0\u0013¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\t0\u0013¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010R*\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004r\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\t0\u0019¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0018Ê\u0001\u0002\b\u0011Ê\u0001\f\b0\u0012\b\b1\u0012\u0004\b\u0003\u0010\u0002¨\u0006/"}, d2 = {"Luz/FonRo/pos/data/model/StatsSales;", "", "revenue", "", "profit", "count", "", "<init>", "(DDI)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IDDILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRevenue$annotations", "()V", "getRevenue", "()D", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientDouble;", "getProfit$annotations", "getProfit", "getCount$annotations", "getCount", "()I", "Luz/FonRo/pos/data/net/LenientInt;", "component1", "component2", "component3", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class StatsSales {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int count;
    private final double profit;
    private final double revenue;

    public StatsSales() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ StatsSales copy$default(StatsSales statsSales, double d, double d2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d = statsSales.revenue;
        }
        double d3 = d;
        if ((i2 & 2) != 0) {
            d2 = statsSales.profit;
        }
        double d4 = d2;
        if ((i2 & 4) != 0) {
            i = statsSales.count;
        }
        return statsSales.copy(d3, d4, i);
    }

    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getCount$annotations() {
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getProfit$annotations() {
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getRevenue$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final double getRevenue() {
        return this.revenue;
    }

    /* renamed from: component2, reason: from getter */
    public final double getProfit() {
        return this.profit;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    public final StatsSales copy(double revenue, double profit, int count) {
        return new StatsSales(revenue, profit, count);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatsSales)) {
            return false;
        }
        StatsSales statsSales = (StatsSales) other;
        return Double.compare(this.revenue, statsSales.revenue) == 0 && Double.compare(this.profit, statsSales.profit) == 0 && this.count == statsSales.count;
    }

    public int hashCode() {
        return (((Double.hashCode(this.revenue) * 31) + Double.hashCode(this.profit)) * 31) + Integer.hashCode(this.count);
    }

    public String toString() {
        return "StatsSales(revenue=" + this.revenue + ", profit=" + this.profit + ", count=" + this.count + ")";
    }

    /* compiled from: Stats.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/StatsSales$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/StatsSales;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<StatsSales> serializer() {
            return StatsSales$$serializer.INSTANCE;
        }
    }

    public StatsSales(double d, double d2, int i) {
        this.revenue = d;
        this.profit = d2;
        this.count = i;
    }

    public /* synthetic */ StatsSales(int i, double d, double d2, int i2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.revenue = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.revenue = d;
        }
        if ((i & 2) == 0) {
            this.profit = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.profit = d2;
        }
        if ((i & 4) == 0) {
            this.count = 0;
        } else {
            this.count = i2;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(StatsSales self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || Double.compare(self.revenue, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientDouble.INSTANCE, Double.valueOf(self.revenue));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || Double.compare(self.profit, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 1, LenientDouble.INSTANCE, Double.valueOf(self.profit));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.count == 0) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 2, LenientInt.INSTANCE, Integer.valueOf(self.count));
    }

    public /* synthetic */ StatsSales(double d, double d2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0.0d : d, (i2 & 2) != 0 ? 0.0d : d2, (i2 & 4) != 0 ? 0 : i);
    }

    public final double getRevenue() {
        return this.revenue;
    }

    public final double getProfit() {
        return this.profit;
    }

    public final int getCount() {
        return this.count;
    }
}
