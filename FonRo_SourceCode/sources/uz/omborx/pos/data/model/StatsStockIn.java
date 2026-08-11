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
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002)*B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B+\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J)\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001b\u0002\b(¢\u0006\u0002\b'R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\t0\u0012¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR*\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\t0\u0016¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u0015Ê\u0001\u0002\b\u0010Ê\u0001\f\b,\u0012\b\b-\u0012\u0004\b\u0003\u0010\u0002¨\u0006+"}, d2 = {"Luz/FonRo/pos/data/model/StatsStockIn;", "", "count", "", "total", "", "<init>", "(ID)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCount$annotations", "()V", "getCount", "()I", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientInt;", "getTotal$annotations", "getTotal", "()D", "Luz/FonRo/pos/data/net/LenientDouble;", "component1", "component2", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class StatsStockIn {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int count;
    private final double total;

    public StatsStockIn() {
        this(0, AudioStats.AUDIO_AMPLITUDE_NONE, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ StatsStockIn copy$default(StatsStockIn statsStockIn, int i, double d, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = statsStockIn.count;
        }
        if ((i2 & 2) != 0) {
            d = statsStockIn.total;
        }
        return statsStockIn.copy(i, d);
    }

    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getCount$annotations() {
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getTotal$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* renamed from: component2, reason: from getter */
    public final double getTotal() {
        return this.total;
    }

    public final StatsStockIn copy(int count, double total) {
        return new StatsStockIn(count, total);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatsStockIn)) {
            return false;
        }
        StatsStockIn statsStockIn = (StatsStockIn) other;
        return this.count == statsStockIn.count && Double.compare(this.total, statsStockIn.total) == 0;
    }

    public int hashCode() {
        return (Integer.hashCode(this.count) * 31) + Double.hashCode(this.total);
    }

    public String toString() {
        return "StatsStockIn(count=" + this.count + ", total=" + this.total + ")";
    }

    /* compiled from: Stats.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/StatsStockIn$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/StatsStockIn;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<StatsStockIn> serializer() {
            return StatsStockIn$$serializer.INSTANCE;
        }
    }

    public StatsStockIn(int i, double d) {
        this.count = i;
        this.total = d;
    }

    public /* synthetic */ StatsStockIn(int i, int i2, double d, SerializationConstructorMarker serializationConstructorMarker) {
        this.count = (i & 1) == 0 ? 0 : i2;
        if ((i & 2) == 0) {
            this.total = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.total = d;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(StatsStockIn self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.count != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientInt.INSTANCE, Integer.valueOf(self.count));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && Double.compare(self.total, AudioStats.AUDIO_AMPLITUDE_NONE) == 0) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 1, LenientDouble.INSTANCE, Double.valueOf(self.total));
    }

    public /* synthetic */ StatsStockIn(int i, double d, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : d);
    }

    public final int getCount() {
        return this.count;
    }

    public final double getTotal() {
        return this.total;
    }
}
