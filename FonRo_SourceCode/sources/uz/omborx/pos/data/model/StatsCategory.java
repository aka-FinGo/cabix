package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.core.motion.utils.TypedValues;
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
import kotlinx.serialization.internal.StringSerializer;
import uz.FonRo.pos.data.net.LenientDouble;

/* compiled from: Stats.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB7\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J)\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020\nHÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0003HÖ\u0081\u0004J)\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001b\u0002\b)¢\u0006\u0002\b(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR*\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\t0\u0017¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0002\b\u0015Ê\u0001\f\b-\u0012\b\b.\u0012\u0004\b\u0003\u0010\u0002¨\u0006,"}, d2 = {"Luz/FonRo/pos/data/model/StatsCategory;", "", "name", "", TypedValues.Custom.S_COLOR, "revenue", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;D)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;DLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getColor", "getRevenue$annotations", "()V", "getRevenue", "()D", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientDouble;", "component1", "component2", "component3", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class StatsCategory {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String color;
    private final String name;
    private final double revenue;

    public StatsCategory() {
        this((String) null, (String) null, AudioStats.AUDIO_AMPLITUDE_NONE, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ StatsCategory copy$default(StatsCategory statsCategory, String str, String str2, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = statsCategory.name;
        }
        if ((i & 2) != 0) {
            str2 = statsCategory.color;
        }
        if ((i & 4) != 0) {
            d = statsCategory.revenue;
        }
        return statsCategory.copy(str, str2, d);
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getRevenue$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* renamed from: component3, reason: from getter */
    public final double getRevenue() {
        return this.revenue;
    }

    public final StatsCategory copy(String name, String color, double revenue) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new StatsCategory(name, color, revenue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatsCategory)) {
            return false;
        }
        StatsCategory statsCategory = (StatsCategory) other;
        return Intrinsics.areEqual(this.name, statsCategory.name) && Intrinsics.areEqual(this.color, statsCategory.color) && Double.compare(this.revenue, statsCategory.revenue) == 0;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        String str = this.color;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Double.hashCode(this.revenue);
    }

    public String toString() {
        return "StatsCategory(name=" + this.name + ", color=" + this.color + ", revenue=" + this.revenue + ")";
    }

    /* compiled from: Stats.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/StatsCategory$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/StatsCategory;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<StatsCategory> serializer() {
            return StatsCategory$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ StatsCategory(int i, String str, String str2, double d, SerializationConstructorMarker serializationConstructorMarker) {
        this.name = (i & 1) == 0 ? "" : str;
        if ((i & 2) == 0) {
            this.color = null;
        } else {
            this.color = str2;
        }
        if ((i & 4) == 0) {
            this.revenue = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.revenue = d;
        }
    }

    public StatsCategory(String name, String str, double d) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.color = str;
        this.revenue = d;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(StatsCategory self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.name, "")) {
            output.encodeStringElement(serialDesc, 0, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.color != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.color);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && Double.compare(self.revenue, AudioStats.AUDIO_AMPLITUDE_NONE) == 0) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 2, LenientDouble.INSTANCE, Double.valueOf(self.revenue));
    }

    public /* synthetic */ StatsCategory(String str, String str2, double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : d);
    }

    public final String getName() {
        return this.name;
    }

    public final String getColor() {
        return this.color;
    }

    public final double getRevenue() {
        return this.revenue;
    }
}
