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
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientInt;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 62\u00020\u0001:\u000256B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB=\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J1\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010+\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001b\u0002\b4¢\u0006\u0002\b3R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\t0\u0017¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R8\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001cr\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\t0\u0017¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014R8\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b( r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\t0!¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u001fÊ\u0001\u0002\b\u0015Ê\u0001\f\b8\u0012\b\b9\u0012\u0004\b\u0003\u0010\u0002¨\u00067"}, d2 = {"Luz/FonRo/pos/data/model/ShopStatDay;", "", "date", "", "visitors", "", "ordersCount", "ordersAmount", "", "<init>", "(Ljava/lang/String;IID)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;IIDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDate", "()Ljava/lang/String;", "getVisitors$annotations", "()V", "getVisitors", "()I", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientInt;", "getOrdersCount$annotations", "getOrdersCount", "Lkotlinx/serialization/SerialName;", "value", "orders_count", "getOrdersAmount$annotations", "getOrdersAmount", "()D", "orders_amount", "Luz/FonRo/pos/data/net/LenientDouble;", "component1", "component2", "component3", "component4", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ShopStatDay {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String date;
    private final double ordersAmount;
    private final int ordersCount;
    private final int visitors;

    public ShopStatDay() {
        this((String) null, 0, 0, AudioStats.AUDIO_AMPLITUDE_NONE, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopStatDay copy$default(ShopStatDay shopStatDay, String str, int i, int i2, double d, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = shopStatDay.date;
        }
        if ((i3 & 2) != 0) {
            i = shopStatDay.visitors;
        }
        if ((i3 & 4) != 0) {
            i2 = shopStatDay.ordersCount;
        }
        if ((i3 & 8) != 0) {
            d = shopStatDay.ordersAmount;
        }
        int i4 = i2;
        return shopStatDay.copy(str, i, i4, d);
    }

    @SerialName("orders_amount")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getOrdersAmount$annotations() {
    }

    @SerialName("orders_count")
    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getOrdersCount$annotations() {
    }

    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getVisitors$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component2, reason: from getter */
    public final int getVisitors() {
        return this.visitors;
    }

    /* renamed from: component3, reason: from getter */
    public final int getOrdersCount() {
        return this.ordersCount;
    }

    /* renamed from: component4, reason: from getter */
    public final double getOrdersAmount() {
        return this.ordersAmount;
    }

    public final ShopStatDay copy(String date, int visitors, int ordersCount, double ordersAmount) {
        Intrinsics.checkNotNullParameter(date, "date");
        return new ShopStatDay(date, visitors, ordersCount, ordersAmount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShopStatDay)) {
            return false;
        }
        ShopStatDay shopStatDay = (ShopStatDay) other;
        return Intrinsics.areEqual(this.date, shopStatDay.date) && this.visitors == shopStatDay.visitors && this.ordersCount == shopStatDay.ordersCount && Double.compare(this.ordersAmount, shopStatDay.ordersAmount) == 0;
    }

    public int hashCode() {
        return (((((this.date.hashCode() * 31) + Integer.hashCode(this.visitors)) * 31) + Integer.hashCode(this.ordersCount)) * 31) + Double.hashCode(this.ordersAmount);
    }

    public String toString() {
        return "ShopStatDay(date=" + this.date + ", visitors=" + this.visitors + ", ordersCount=" + this.ordersCount + ", ordersAmount=" + this.ordersAmount + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/ShopStatDay$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/ShopStatDay;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ShopStatDay> serializer() {
            return ShopStatDay$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ShopStatDay(int i, String str, int i2, int i3, double d, SerializationConstructorMarker serializationConstructorMarker) {
        this.date = (i & 1) == 0 ? "" : str;
        if ((i & 2) == 0) {
            this.visitors = 0;
        } else {
            this.visitors = i2;
        }
        if ((i & 4) == 0) {
            this.ordersCount = 0;
        } else {
            this.ordersCount = i3;
        }
        if ((i & 8) == 0) {
            this.ordersAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.ordersAmount = d;
        }
    }

    public ShopStatDay(String date, int i, int i2, double d) {
        Intrinsics.checkNotNullParameter(date, "date");
        this.date = date;
        this.visitors = i;
        this.ordersCount = i2;
        this.ordersAmount = d;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(ShopStatDay self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.date, "")) {
            output.encodeStringElement(serialDesc, 0, self.date);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.visitors != 0) {
            output.encodeSerializableElement(serialDesc, 1, LenientInt.INSTANCE, Integer.valueOf(self.visitors));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.ordersCount != 0) {
            output.encodeSerializableElement(serialDesc, 2, LenientInt.INSTANCE, Integer.valueOf(self.ordersCount));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && Double.compare(self.ordersAmount, AudioStats.AUDIO_AMPLITUDE_NONE) == 0) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 3, LenientDouble.INSTANCE, Double.valueOf(self.ordersAmount));
    }

    public /* synthetic */ ShopStatDay(String str, int i, int i2, double d, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : d);
    }

    public final String getDate() {
        return this.date;
    }

    public final int getVisitors() {
        return this.visitors;
    }

    public final int getOrdersCount() {
        return this.ordersCount;
    }

    public final double getOrdersAmount() {
        return this.ordersAmount;
    }
}
