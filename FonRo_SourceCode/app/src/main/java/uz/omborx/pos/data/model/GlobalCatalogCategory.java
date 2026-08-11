package uz.FonRo.pos.data.model;

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
import uz.FonRo.pos.data.net.LenientInt;
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 62\u00020\u0001:\u000256B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J3\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020\bHÖ\u0081\u0004J\n\u0010+\u001a\u00020\u0005HÖ\u0081\u0004J)\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001b\u0002\b4¢\u0006\u0002\b3R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\t0\u0015¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R,\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0017R8\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b( r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\t0!¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u001fÊ\u0001\u0002\b\u0013Ê\u0001\f\b8\u0012\b\b9\u0012\u0004\b\u0003\u0010\u0002¨\u00067"}, d2 = {"Luz/FonRo/pos/data/model/GlobalCatalogCategory;", "", "id", "", "name", "", "colorHex", "productsCount", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getName", "()Ljava/lang/String;", "getColorHex$annotations", "getColorHex", "Lkotlinx/serialization/SerialName;", "value", "color_hex", "getProductsCount$annotations", "getProductsCount", "()I", "products_count", "Luz/FonRo/pos/data/net/LenientInt;", "component1", "component2", "component3", "component4", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class GlobalCatalogCategory {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String colorHex;
    private final long id;
    private final String name;
    private final int productsCount;

    public GlobalCatalogCategory() {
        this(0L, (String) null, (String) null, 0, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GlobalCatalogCategory copy$default(GlobalCatalogCategory globalCatalogCategory, long j, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = globalCatalogCategory.id;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            str = globalCatalogCategory.name;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = globalCatalogCategory.colorHex;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            i = globalCatalogCategory.productsCount;
        }
        return globalCatalogCategory.copy(j2, str3, str4, i);
    }

    @SerialName("color_hex")
    public static /* synthetic */ void getColorHex$annotations() {
    }

    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("products_count")
    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getProductsCount$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getColorHex() {
        return this.colorHex;
    }

    /* renamed from: component4, reason: from getter */
    public final int getProductsCount() {
        return this.productsCount;
    }

    public final GlobalCatalogCategory copy(long id, String name, String colorHex, int productsCount) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new GlobalCatalogCategory(id, name, colorHex, productsCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GlobalCatalogCategory)) {
            return false;
        }
        GlobalCatalogCategory globalCatalogCategory = (GlobalCatalogCategory) other;
        return this.id == globalCatalogCategory.id && Intrinsics.areEqual(this.name, globalCatalogCategory.name) && Intrinsics.areEqual(this.colorHex, globalCatalogCategory.colorHex) && this.productsCount == globalCatalogCategory.productsCount;
    }

    public int hashCode() {
        int hashCode = ((Long.hashCode(this.id) * 31) + this.name.hashCode()) * 31;
        String str = this.colorHex;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.productsCount);
    }

    public String toString() {
        return "GlobalCatalogCategory(id=" + this.id + ", name=" + this.name + ", colorHex=" + this.colorHex + ", productsCount=" + this.productsCount + ")";
    }

    /* compiled from: Catalog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/GlobalCatalogCategory$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/GlobalCatalogCategory;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<GlobalCatalogCategory> serializer() {
            return GlobalCatalogCategory$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ GlobalCatalogCategory(int i, long j, String str, String str2, int i2, SerializationConstructorMarker serializationConstructorMarker) {
        this.id = (i & 1) == 0 ? 0L : j;
        if ((i & 2) == 0) {
            this.name = "";
        } else {
            this.name = str;
        }
        if ((i & 4) == 0) {
            this.colorHex = null;
        } else {
            this.colorHex = str2;
        }
        if ((i & 8) == 0) {
            this.productsCount = 0;
        } else {
            this.productsCount = i2;
        }
    }

    public GlobalCatalogCategory(long j, String name, String str, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = j;
        this.name = name;
        this.colorHex = str;
        this.productsCount = i;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(GlobalCatalogCategory self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.name, "")) {
            output.encodeStringElement(serialDesc, 1, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.colorHex != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.colorHex);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.productsCount == 0) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 3, LenientInt.INSTANCE, Integer.valueOf(self.productsCount));
    }

    public final long getId() {
        return this.id;
    }

    public /* synthetic */ GlobalCatalogCategory(long j, String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? 0 : i);
    }

    public final String getName() {
        return this.name;
    }

    public final String getColorHex() {
        return this.colorHex;
    }

    public final int getProductsCount() {
        return this.productsCount;
    }
}
