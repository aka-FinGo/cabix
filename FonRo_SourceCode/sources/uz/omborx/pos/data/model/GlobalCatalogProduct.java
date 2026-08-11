package uz.FonRo.pos.data.model;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
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
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u00029:BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bBS\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003JG\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0014\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010.\u001a\u00020\rHÖ\u0081\u0004J\n\u0010/\u001a\u00020\u0006HÖ\u0081\u0004J)\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0001b\u0002\b8¢\u0006\u0002\b7R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\t0\u0017¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R8\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001cr\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\t0\u0017¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR,\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(#¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u001eÊ\u0001\u0002\b\u0015Ê\u0001\f\b<\u0012\b\b=\u0012\u0004\b\u0003\u0010\u0002¨\u0006;"}, d2 = {"Luz/FonRo/pos/data/model/GlobalCatalogProduct;", "", "id", "", "categoryId", "name", "", OptionalModuleUtils.BARCODE, "unit", "imageUrl", "<init>", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getCategoryId$annotations", "getCategoryId", "Lkotlinx/serialization/SerialName;", "value", "category_id", "getName", "()Ljava/lang/String;", "getBarcode", "getUnit", "getImageUrl$annotations", "getImageUrl", "image_url", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class GlobalCatalogProduct {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String barcode;
    private final long categoryId;
    private final long id;
    private final String imageUrl;
    private final String name;
    private final String unit;

    public GlobalCatalogProduct() {
        this(0L, 0L, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GlobalCatalogProduct copy$default(GlobalCatalogProduct globalCatalogProduct, long j, long j2, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            j = globalCatalogProduct.id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = globalCatalogProduct.categoryId;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            str = globalCatalogProduct.name;
        }
        String str5 = str;
        if ((i & 8) != 0) {
            str2 = globalCatalogProduct.barcode;
        }
        return globalCatalogProduct.copy(j3, j4, str5, str2, (i & 16) != 0 ? globalCatalogProduct.unit : str3, (i & 32) != 0 ? globalCatalogProduct.imageUrl : str4);
    }

    @SerialName("category_id")
    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getCategoryId$annotations() {
    }

    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("image_url")
    public static /* synthetic */ void getImageUrl$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCategoryId() {
        return this.categoryId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBarcode() {
        return this.barcode;
    }

    /* renamed from: component5, reason: from getter */
    public final String getUnit() {
        return this.unit;
    }

    /* renamed from: component6, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final GlobalCatalogProduct copy(long id, long categoryId, String name, String barcode, String unit, String imageUrl) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(barcode, "barcode");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return new GlobalCatalogProduct(id, categoryId, name, barcode, unit, imageUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GlobalCatalogProduct)) {
            return false;
        }
        GlobalCatalogProduct globalCatalogProduct = (GlobalCatalogProduct) other;
        return this.id == globalCatalogProduct.id && this.categoryId == globalCatalogProduct.categoryId && Intrinsics.areEqual(this.name, globalCatalogProduct.name) && Intrinsics.areEqual(this.barcode, globalCatalogProduct.barcode) && Intrinsics.areEqual(this.unit, globalCatalogProduct.unit) && Intrinsics.areEqual(this.imageUrl, globalCatalogProduct.imageUrl);
    }

    public int hashCode() {
        int hashCode = ((((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.categoryId)) * 31) + this.name.hashCode()) * 31) + this.barcode.hashCode()) * 31) + this.unit.hashCode()) * 31;
        String str = this.imageUrl;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "GlobalCatalogProduct(id=" + this.id + ", categoryId=" + this.categoryId + ", name=" + this.name + ", barcode=" + this.barcode + ", unit=" + this.unit + ", imageUrl=" + this.imageUrl + ")";
    }

    /* compiled from: Catalog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/GlobalCatalogProduct$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/GlobalCatalogProduct;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<GlobalCatalogProduct> serializer() {
            return GlobalCatalogProduct$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ GlobalCatalogProduct(int i, long j, long j2, String str, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.id = 0L;
        } else {
            this.id = j;
        }
        if ((i & 2) == 0) {
            this.categoryId = 0L;
        } else {
            this.categoryId = j2;
        }
        if ((i & 4) == 0) {
            this.name = "";
        } else {
            this.name = str;
        }
        if ((i & 8) == 0) {
            this.barcode = "";
        } else {
            this.barcode = str2;
        }
        if ((i & 16) == 0) {
            this.unit = "pcs";
        } else {
            this.unit = str3;
        }
        if ((i & 32) == 0) {
            this.imageUrl = null;
        } else {
            this.imageUrl = str4;
        }
    }

    public GlobalCatalogProduct(long j, long j2, String name, String barcode, String unit, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(barcode, "barcode");
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.id = j;
        this.categoryId = j2;
        this.name = name;
        this.barcode = barcode;
        this.unit = unit;
        this.imageUrl = str;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(GlobalCatalogProduct self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.categoryId != 0) {
            output.encodeSerializableElement(serialDesc, 1, LenientLong.INSTANCE, Long.valueOf(self.categoryId));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.name, "")) {
            output.encodeStringElement(serialDesc, 2, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.barcode, "")) {
            output.encodeStringElement(serialDesc, 3, self.barcode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.unit, "pcs")) {
            output.encodeStringElement(serialDesc, 4, self.unit);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.imageUrl == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.imageUrl);
    }

    public /* synthetic */ GlobalCatalogProduct(long j, long j2, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? "pcs" : str3, (i & 32) != 0 ? null : str4);
    }

    public final long getId() {
        return this.id;
    }

    public final long getCategoryId() {
        return this.categoryId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getBarcode() {
        return this.barcode;
    }

    public final String getUnit() {
        return this.unit;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }
}
