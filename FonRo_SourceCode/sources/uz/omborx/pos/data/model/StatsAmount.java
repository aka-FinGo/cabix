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
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J'\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020\nHÖ\u0081\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001b\u0002\b,¢\u0006\u0002\b+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR*\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\t0\u0016¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R*\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\t0\u0016¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\u0019\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0013Ê\u0001\u0002\b\u0014Ê\u0001\f\b0\u0012\b\b1\u0012\u0004\b\u0003\u0010\u0002¨\u0006/"}, d2 = {"Luz/FonRo/pos/data/model/StatsAmount;", "", "date", "", "total", "", "amount", "<init>", "(Ljava/lang/String;DD)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;DDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDate", "()Ljava/lang/String;", "getTotal$annotations", "()V", "getTotal", "()D", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientDouble;", "getAmount$annotations", "getAmount", "value", "getValue", "component1", "component2", "component3", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class StatsAmount {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double amount;
    private final String date;
    private final double total;

    public StatsAmount() {
        this((String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ StatsAmount copy$default(StatsAmount statsAmount, String str, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = statsAmount.date;
        }
        if ((i & 2) != 0) {
            d = statsAmount.total;
        }
        if ((i & 4) != 0) {
            d2 = statsAmount.amount;
        }
        return statsAmount.copy(str, d, d2);
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getAmount$annotations() {
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getTotal$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component2, reason: from getter */
    public final double getTotal() {
        return this.total;
    }

    /* renamed from: component3, reason: from getter */
    public final double getAmount() {
        return this.amount;
    }

    public final StatsAmount copy(String date, double total, double amount) {
        Intrinsics.checkNotNullParameter(date, "date");
        return new StatsAmount(date, total, amount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatsAmount)) {
            return false;
        }
        StatsAmount statsAmount = (StatsAmount) other;
        return Intrinsics.areEqual(this.date, statsAmount.date) && Double.compare(this.total, statsAmount.total) == 0 && Double.compare(this.amount, statsAmount.amount) == 0;
    }

    public int hashCode() {
        return (((this.date.hashCode() * 31) + Double.hashCode(this.total)) * 31) + Double.hashCode(this.amount);
    }

    public String toString() {
        return "StatsAmount(date=" + this.date + ", total=" + this.total + ", amount=" + this.amount + ")";
    }

    /* compiled from: Stats.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/StatsAmount$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/StatsAmount;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<StatsAmount> serializer() {
            return StatsAmount$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ StatsAmount(int i, String str, double d, double d2, SerializationConstructorMarker serializationConstructorMarker) {
        this.date = (i & 1) == 0 ? "" : str;
        if ((i & 2) == 0) {
            this.total = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.total = d;
        }
        if ((i & 4) == 0) {
            this.amount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.amount = d2;
        }
    }

    public StatsAmount(String date, double d, double d2) {
        Intrinsics.checkNotNullParameter(date, "date");
        this.date = date;
        this.total = d;
        this.amount = d2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(StatsAmount self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.date, "")) {
            output.encodeStringElement(serialDesc, 0, self.date);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || Double.compare(self.total, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 1, LenientDouble.INSTANCE, Double.valueOf(self.total));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && Double.compare(self.amount, AudioStats.AUDIO_AMPLITUDE_NONE) == 0) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 2, LenientDouble.INSTANCE, Double.valueOf(self.amount));
    }

    public /* synthetic */ StatsAmount(String str, double d, double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0.0d : d, (i & 4) != 0 ? 0.0d : d2);
    }

    public final String getDate() {
        return this.date;
    }

    public final double getTotal() {
        return this.total;
    }

    public final double getAmount() {
        return this.amount;
    }

    public final double getValue() {
        double d = this.total;
        return d == AudioStats.AUDIO_AMPLITUDE_NONE ? this.amount : d;
    }
}
