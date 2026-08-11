package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import uz.FonRo.pos.data.local.CacheStore;
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientInt;

/* compiled from: Stats.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB3\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J'\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010&\u001a\u00020'HÖ\u0081\u0004J)\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001b\u0002\b0¢\u0006\u0002\b/R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\t0\u0013¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R8\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019r\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\t0\u001a¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016R8\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001dr\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\t0\u001a¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0016Ê\u0001\u0002\b\u0011Ê\u0001\f\b4\u0012\b\b5\u0012\u0004\b\u0003\u0010\u0002¨\u00063"}, d2 = {"Luz/FonRo/pos/data/model/StatsInventory;", "", CacheStore.PRODUCTS, "", "stockPurchase", "", "stockSale", "<init>", "(IDD)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIDDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getProducts$annotations", "()V", "getProducts", "()I", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientInt;", "getStockPurchase$annotations", "getStockPurchase", "()D", "Lkotlinx/serialization/SerialName;", "value", "stock_purchase", "Luz/FonRo/pos/data/net/LenientDouble;", "getStockSale$annotations", "getStockSale", "stock_sale", "component1", "component2", "component3", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class StatsInventory {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int products;
    private final double stockPurchase;
    private final double stockSale;

    public StatsInventory() {
        this(0, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ StatsInventory copy$default(StatsInventory statsInventory, int i, double d, double d2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = statsInventory.products;
        }
        if ((i2 & 2) != 0) {
            d = statsInventory.stockPurchase;
        }
        if ((i2 & 4) != 0) {
            d2 = statsInventory.stockSale;
        }
        return statsInventory.copy(i, d, d2);
    }

    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getProducts$annotations() {
    }

    @SerialName("stock_purchase")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getStockPurchase$annotations() {
    }

    @SerialName("stock_sale")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getStockSale$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final int getProducts() {
        return this.products;
    }

    /* renamed from: component2, reason: from getter */
    public final double getStockPurchase() {
        return this.stockPurchase;
    }

    /* renamed from: component3, reason: from getter */
    public final double getStockSale() {
        return this.stockSale;
    }

    public final StatsInventory copy(int products, double stockPurchase, double stockSale) {
        return new StatsInventory(products, stockPurchase, stockSale);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatsInventory)) {
            return false;
        }
        StatsInventory statsInventory = (StatsInventory) other;
        return this.products == statsInventory.products && Double.compare(this.stockPurchase, statsInventory.stockPurchase) == 0 && Double.compare(this.stockSale, statsInventory.stockSale) == 0;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.products) * 31) + Double.hashCode(this.stockPurchase)) * 31) + Double.hashCode(this.stockSale);
    }

    public String toString() {
        return "StatsInventory(products=" + this.products + ", stockPurchase=" + this.stockPurchase + ", stockSale=" + this.stockSale + ")";
    }

    /* compiled from: Stats.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/StatsInventory$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/StatsInventory;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<StatsInventory> serializer() {
            return StatsInventory$$serializer.INSTANCE;
        }
    }

    public StatsInventory(int i, double d, double d2) {
        this.products = i;
        this.stockPurchase = d;
        this.stockSale = d2;
    }

    public /* synthetic */ StatsInventory(int i, int i2, double d, double d2, SerializationConstructorMarker serializationConstructorMarker) {
        this.products = (i & 1) == 0 ? 0 : i2;
        if ((i & 2) == 0) {
            this.stockPurchase = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.stockPurchase = d;
        }
        if ((i & 4) == 0) {
            this.stockSale = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.stockSale = d2;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(StatsInventory self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.products != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientInt.INSTANCE, Integer.valueOf(self.products));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || Double.compare(self.stockPurchase, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 1, LenientDouble.INSTANCE, Double.valueOf(self.stockPurchase));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && Double.compare(self.stockSale, AudioStats.AUDIO_AMPLITUDE_NONE) == 0) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 2, LenientDouble.INSTANCE, Double.valueOf(self.stockSale));
    }

    public /* synthetic */ StatsInventory(int i, double d, double d2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0.0d : d, (i2 & 4) != 0 ? 0.0d : d2);
    }

    public final int getProducts() {
        return this.products;
    }

    public final double getStockPurchase() {
        return this.stockPurchase;
    }

    public final double getStockSale() {
        return this.stockSale;
    }
}
