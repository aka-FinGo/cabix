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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientDoubleNullable;
import uz.FonRo.pos.data.net.LenientInt;

/* compiled from: Stats.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 Q2\u00020\u0001:\u0002PQBs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010Bs\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0014J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010!J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\t\u0010=\u001a\u00020\fHÆ\u0003J\t\u0010>\u001a\u00020\fHÆ\u0003J\t\u0010?\u001a\u00020\u0006HÆ\u0003Jz\u0010@\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010AJ\u0014\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010E\u001a\u00020\fHÖ\u0081\u0004J\n\u0010F\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0001b\u0002\bO¢\u0006\u0002\bNR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R*\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\t0\u001e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR.\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\t0#¢\u0006\u0010\n\u0002\u0010\"\u0012\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010!R.\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\t0#¢\u0006\u0010\n\u0002\u0010\"\u0012\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010!R*\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\t0\u001e¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010\u001bR*\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\t0\u001e¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0019\u001a\u0004\b)\u0010\u001bR*\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\t0-¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010,R8\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004r\f\b0\u0012\b\b1\u0012\u0004\b\b(2r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\t0-¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0019\u001a\u0004\b/\u0010,R8\u0010\u000e\u001a\u00020\u00068\u0006X\u0087\u0004r\f\b0\u0012\b\b1\u0012\u0004\b\b(5r\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\t0\u001e¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u0019\u001a\u0004\b4\u0010\u001bÊ\u0001\u0002\b\u001cÊ\u0001\f\bS\u0012\b\bT\u0012\u0004\b\u0003\u0010\u0002¨\u0006R"}, d2 = {"Luz/FonRo/pos/data/model/StatsEmployee;", "", "name", "", "role", "revenue", "", "cash", "card", "debt", "profit", "count", "", "returnsCount", "returnsAmount", "<init>", "(Ljava/lang/String;Ljava/lang/String;DLjava/lang/Double;Ljava/lang/Double;DDIID)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;DLjava/lang/Double;Ljava/lang/Double;DDIIDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getRole", "getRevenue$annotations", "()V", "getRevenue", "()D", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientDouble;", "getCash$annotations", "getCash", "()Ljava/lang/Double;", "Ljava/lang/Double;", "Luz/FonRo/pos/data/net/LenientDoubleNullable;", "getCard$annotations", "getCard", "getDebt$annotations", "getDebt", "getProfit$annotations", "getProfit", "getCount$annotations", "getCount", "()I", "Luz/FonRo/pos/data/net/LenientInt;", "getReturnsCount$annotations", "getReturnsCount", "Lkotlinx/serialization/SerialName;", "value", "returns_count", "getReturnsAmount$annotations", "getReturnsAmount", "returns_amount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;DLjava/lang/Double;Ljava/lang/Double;DDIID)Luz/FonRo/pos/data/model/StatsEmployee;", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class StatsEmployee {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Double card;
    private final Double cash;
    private final int count;
    private final double debt;
    private final String name;
    private final double profit;
    private final double returnsAmount;
    private final int returnsCount;
    private final double revenue;
    private final String role;

    public StatsEmployee() {
        this((String) null, (String) null, AudioStats.AUDIO_AMPLITUDE_NONE, (Double) null, (Double) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0, 0, AudioStats.AUDIO_AMPLITUDE_NONE, 1023, (DefaultConstructorMarker) null);
    }

    @Serializable(with = LenientDoubleNullable.class)
    public static /* synthetic */ void getCard$annotations() {
    }

    @Serializable(with = LenientDoubleNullable.class)
    public static /* synthetic */ void getCash$annotations() {
    }

    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getCount$annotations() {
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getDebt$annotations() {
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getProfit$annotations() {
    }

    @SerialName("returns_amount")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getReturnsAmount$annotations() {
    }

    @SerialName("returns_count")
    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getReturnsCount$annotations() {
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getRevenue$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component10, reason: from getter */
    public final double getReturnsAmount() {
        return this.returnsAmount;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* renamed from: component3, reason: from getter */
    public final double getRevenue() {
        return this.revenue;
    }

    /* renamed from: component4, reason: from getter */
    public final Double getCash() {
        return this.cash;
    }

    /* renamed from: component5, reason: from getter */
    public final Double getCard() {
        return this.card;
    }

    /* renamed from: component6, reason: from getter */
    public final double getDebt() {
        return this.debt;
    }

    /* renamed from: component7, reason: from getter */
    public final double getProfit() {
        return this.profit;
    }

    /* renamed from: component8, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* renamed from: component9, reason: from getter */
    public final int getReturnsCount() {
        return this.returnsCount;
    }

    public final StatsEmployee copy(String name, String role, double revenue, Double cash, Double card, double debt, double profit, int count, int returnsCount, double returnsAmount) {
        return new StatsEmployee(name, role, revenue, cash, card, debt, profit, count, returnsCount, returnsAmount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatsEmployee)) {
            return false;
        }
        StatsEmployee statsEmployee = (StatsEmployee) other;
        return Intrinsics.areEqual(this.name, statsEmployee.name) && Intrinsics.areEqual(this.role, statsEmployee.role) && Double.compare(this.revenue, statsEmployee.revenue) == 0 && Intrinsics.areEqual((Object) this.cash, (Object) statsEmployee.cash) && Intrinsics.areEqual((Object) this.card, (Object) statsEmployee.card) && Double.compare(this.debt, statsEmployee.debt) == 0 && Double.compare(this.profit, statsEmployee.profit) == 0 && this.count == statsEmployee.count && this.returnsCount == statsEmployee.returnsCount && Double.compare(this.returnsAmount, statsEmployee.returnsAmount) == 0;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.role;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + Double.hashCode(this.revenue)) * 31;
        Double d = this.cash;
        int hashCode3 = (hashCode2 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.card;
        return ((((((((((hashCode3 + (d2 != null ? d2.hashCode() : 0)) * 31) + Double.hashCode(this.debt)) * 31) + Double.hashCode(this.profit)) * 31) + Integer.hashCode(this.count)) * 31) + Integer.hashCode(this.returnsCount)) * 31) + Double.hashCode(this.returnsAmount);
    }

    public String toString() {
        return "StatsEmployee(name=" + this.name + ", role=" + this.role + ", revenue=" + this.revenue + ", cash=" + this.cash + ", card=" + this.card + ", debt=" + this.debt + ", profit=" + this.profit + ", count=" + this.count + ", returnsCount=" + this.returnsCount + ", returnsAmount=" + this.returnsAmount + ")";
    }

    /* compiled from: Stats.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/StatsEmployee$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/StatsEmployee;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<StatsEmployee> serializer() {
            return StatsEmployee$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ StatsEmployee(int i, String str, String str2, double d, Double d2, Double d3, double d4, double d5, int i2, int i3, double d6, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.name = null;
        } else {
            this.name = str;
        }
        if ((i & 2) == 0) {
            this.role = null;
        } else {
            this.role = str2;
        }
        if ((i & 4) == 0) {
            this.revenue = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.revenue = d;
        }
        if ((i & 8) == 0) {
            this.cash = null;
        } else {
            this.cash = d2;
        }
        if ((i & 16) == 0) {
            this.card = null;
        } else {
            this.card = d3;
        }
        if ((i & 32) == 0) {
            this.debt = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.debt = d4;
        }
        if ((i & 64) == 0) {
            this.profit = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.profit = d5;
        }
        if ((i & 128) == 0) {
            this.count = 0;
        } else {
            this.count = i2;
        }
        if ((i & 256) == 0) {
            this.returnsCount = 0;
        } else {
            this.returnsCount = i3;
        }
        if ((i & 512) == 0) {
            this.returnsAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.returnsAmount = d6;
        }
    }

    public StatsEmployee(String str, String str2, double d, Double d2, Double d3, double d4, double d5, int i, int i2, double d6) {
        this.name = str;
        this.role = str2;
        this.revenue = d;
        this.cash = d2;
        this.card = d3;
        this.debt = d4;
        this.profit = d5;
        this.count = i;
        this.returnsCount = i2;
        this.returnsAmount = d6;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(StatsEmployee self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.role != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.role);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || Double.compare(self.revenue, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 2, LenientDouble.INSTANCE, Double.valueOf(self.revenue));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.cash != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, LenientDoubleNullable.INSTANCE, self.cash);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.card != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, LenientDoubleNullable.INSTANCE, self.card);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || Double.compare(self.debt, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 5, LenientDouble.INSTANCE, Double.valueOf(self.debt));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || Double.compare(self.profit, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 6, LenientDouble.INSTANCE, Double.valueOf(self.profit));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.count != 0) {
            output.encodeSerializableElement(serialDesc, 7, LenientInt.INSTANCE, Integer.valueOf(self.count));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.returnsCount != 0) {
            output.encodeSerializableElement(serialDesc, 8, LenientInt.INSTANCE, Integer.valueOf(self.returnsCount));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 9) && Double.compare(self.returnsAmount, AudioStats.AUDIO_AMPLITUDE_NONE) == 0) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 9, LenientDouble.INSTANCE, Double.valueOf(self.returnsAmount));
    }

    public /* synthetic */ StatsEmployee(String str, String str2, double d, Double d2, Double d3, double d4, double d5, int i, int i2, double d6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? 0.0d : d, (i3 & 8) != 0 ? null : d2, (i3 & 16) == 0 ? d3 : null, (i3 & 32) != 0 ? 0.0d : d4, (i3 & 64) != 0 ? 0.0d : d5, (i3 & 128) != 0 ? 0 : i, (i3 & 256) == 0 ? i2 : 0, (i3 & 512) != 0 ? 0.0d : d6);
    }

    public final String getName() {
        return this.name;
    }

    public final String getRole() {
        return this.role;
    }

    public final double getRevenue() {
        return this.revenue;
    }

    public final Double getCash() {
        return this.cash;
    }

    public final Double getCard() {
        return this.card;
    }

    public final double getDebt() {
        return this.debt;
    }

    public final double getProfit() {
        return this.profit;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getReturnsCount() {
        return this.returnsCount;
    }

    public final double getReturnsAmount() {
        return this.returnsAmount;
    }
}
