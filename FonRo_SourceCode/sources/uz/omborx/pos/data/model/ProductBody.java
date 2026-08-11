package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 _2\u00020\u0001:\u0002^_B\u009d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0004\b\u0014\u0010\u0015B£\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0014\u0010\u0019J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010E\u001a\u00020\tHÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\fHÆ\u0003J\t\u0010H\u001a\u00020\fHÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010J\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010;J\u0011\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J¦\u0001\u0010N\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010OJ\u0014\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010S\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010T\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u00002\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H\u0001b\u0002\b]¢\u0006\u0002\b\\R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR0\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004r\f\b\"\u0012\b\b#\u0012\u0004\b\b($¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R*\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004r\f\b\"\u0012\b\b#\u0012\u0004\b\b((¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010'R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR*\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004r\f\b\"\u0012\b\b#\u0012\u0004\b\b(-¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001f\u001a\u0004\b+\u0010,R*\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004r\f\b\"\u0012\b\b#\u0012\u0004\b\b(0¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001f\u001a\u0004\b/\u0010,R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R.\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004r\f\b\"\u0012\b\b#\u0012\u0004\b\b(6¢\u0006\u0010\n\u0002\u00103\u0012\u0004\b4\u0010\u001f\u001a\u0004\b5\u00102R,\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\"\u0012\b\b#\u0012\u0004\b\b(9¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\u001f\u001a\u0004\b8\u0010\u001bR.\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004r\f\b\"\u0012\b\b#\u0012\u0004\b\b(=¢\u0006\u0010\n\u0002\u0010<\u0012\u0004\b:\u0010\u001f\u001a\u0004\b\u0011\u0010;R2\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00078\u0006X\u0087\u0004r\f\b\"\u0012\b\b#\u0012\u0004\b\b(@¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010\u001f\u001a\u0004\b?\u0010!Ê\u0001\u0002\baÊ\u0001\f\bb\u0012\b\bc\u0012\u0004\b\u0003\u0010\u0002¨\u0006`"}, d2 = {"Luz/FonRo/pos/data/model/ProductBody;", "", "name", "", OptionalModuleUtils.BARCODE, "sku", "barcodeAliases", "", "categoryId", "", "unit", "purchasePrice", "", "salePrice", FirebaseAnalytics.Param.QUANTITY, "saleStep", "expirationDate", "isArchived", "", "imageBase64List", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JLjava/lang/String;DDLjava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JLjava/lang/String;DDLjava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getBarcode", "getSku", "getBarcodeAliases$annotations", "()V", "getBarcodeAliases", "()Ljava/util/List;", "Lkotlinx/serialization/SerialName;", "value", "barcode_aliases", "getCategoryId$annotations", "getCategoryId", "()J", "category_id", "getUnit", "getPurchasePrice$annotations", "getPurchasePrice", "()D", "purchase_price", "getSalePrice$annotations", "getSalePrice", "sale_price", "getQuantity", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSaleStep$annotations", "getSaleStep", "sale_step", "getExpirationDate$annotations", "getExpirationDate", "expiration_date", "isArchived$annotations", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "is_archived", "getImageBase64List$annotations", "getImageBase64List", "image_base64_list", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JLjava/lang/String;DDLjava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Luz/FonRo/pos/data/model/ProductBody;", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ProductBody {
    public static final int $stable = 0;
    private final String barcode;
    private final List<String> barcodeAliases;
    private final long categoryId;
    private final String expirationDate;
    private final List<String> imageBase64List;
    private final Integer isArchived;
    private final String name;
    private final double purchasePrice;
    private final Double quantity;
    private final double salePrice;
    private final Double saleStep;
    private final String sku;
    private final String unit;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.ProductBody$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ProductBody._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.ProductBody$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = ProductBody._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    })};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    public static /* synthetic */ ProductBody copy$default(ProductBody productBody, String str, String str2, String str3, List list, long j, String str4, double d, double d2, Double d3, Double d4, String str5, Integer num, List list2, int i, Object obj) {
        String str6 = (i & 1) != 0 ? productBody.name : str;
        return productBody.copy(str6, (i & 2) != 0 ? productBody.barcode : str2, (i & 4) != 0 ? productBody.sku : str3, (i & 8) != 0 ? productBody.barcodeAliases : list, (i & 16) != 0 ? productBody.categoryId : j, (i & 32) != 0 ? productBody.unit : str4, (i & 64) != 0 ? productBody.purchasePrice : d, (i & 128) != 0 ? productBody.salePrice : d2, (i & 256) != 0 ? productBody.quantity : d3, (i & 512) != 0 ? productBody.saleStep : d4, (i & 1024) != 0 ? productBody.expirationDate : str5, (i & 2048) != 0 ? productBody.isArchived : num, (i & 4096) != 0 ? productBody.imageBase64List : list2);
    }

    @SerialName("barcode_aliases")
    public static /* synthetic */ void getBarcodeAliases$annotations() {
    }

    @SerialName("category_id")
    public static /* synthetic */ void getCategoryId$annotations() {
    }

    @SerialName("expiration_date")
    public static /* synthetic */ void getExpirationDate$annotations() {
    }

    @SerialName("image_base64_list")
    public static /* synthetic */ void getImageBase64List$annotations() {
    }

    @SerialName("purchase_price")
    public static /* synthetic */ void getPurchasePrice$annotations() {
    }

    @SerialName("sale_price")
    public static /* synthetic */ void getSalePrice$annotations() {
    }

    @SerialName("sale_step")
    public static /* synthetic */ void getSaleStep$annotations() {
    }

    @SerialName("is_archived")
    public static /* synthetic */ void isArchived$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component10, reason: from getter */
    public final Double getSaleStep() {
        return this.saleStep;
    }

    /* renamed from: component11, reason: from getter */
    public final String getExpirationDate() {
        return this.expirationDate;
    }

    /* renamed from: component12, reason: from getter */
    public final Integer getIsArchived() {
        return this.isArchived;
    }

    public final List<String> component13() {
        return this.imageBase64List;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBarcode() {
        return this.barcode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSku() {
        return this.sku;
    }

    public final List<String> component4() {
        return this.barcodeAliases;
    }

    /* renamed from: component5, reason: from getter */
    public final long getCategoryId() {
        return this.categoryId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getUnit() {
        return this.unit;
    }

    /* renamed from: component7, reason: from getter */
    public final double getPurchasePrice() {
        return this.purchasePrice;
    }

    /* renamed from: component8, reason: from getter */
    public final double getSalePrice() {
        return this.salePrice;
    }

    /* renamed from: component9, reason: from getter */
    public final Double getQuantity() {
        return this.quantity;
    }

    public final ProductBody copy(String name, String barcode, String sku, List<String> barcodeAliases, long categoryId, String unit, double purchasePrice, double salePrice, Double quantity, Double saleStep, String expirationDate, Integer isArchived, List<String> imageBase64List) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(barcode, "barcode");
        Intrinsics.checkNotNullParameter(sku, "sku");
        Intrinsics.checkNotNullParameter(barcodeAliases, "barcodeAliases");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return new ProductBody(name, barcode, sku, barcodeAliases, categoryId, unit, purchasePrice, salePrice, quantity, saleStep, expirationDate, isArchived, imageBase64List);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProductBody)) {
            return false;
        }
        ProductBody productBody = (ProductBody) other;
        return Intrinsics.areEqual(this.name, productBody.name) && Intrinsics.areEqual(this.barcode, productBody.barcode) && Intrinsics.areEqual(this.sku, productBody.sku) && Intrinsics.areEqual(this.barcodeAliases, productBody.barcodeAliases) && this.categoryId == productBody.categoryId && Intrinsics.areEqual(this.unit, productBody.unit) && Double.compare(this.purchasePrice, productBody.purchasePrice) == 0 && Double.compare(this.salePrice, productBody.salePrice) == 0 && Intrinsics.areEqual((Object) this.quantity, (Object) productBody.quantity) && Intrinsics.areEqual((Object) this.saleStep, (Object) productBody.saleStep) && Intrinsics.areEqual(this.expirationDate, productBody.expirationDate) && Intrinsics.areEqual(this.isArchived, productBody.isArchived) && Intrinsics.areEqual(this.imageBase64List, productBody.imageBase64List);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((this.name.hashCode() * 31) + this.barcode.hashCode()) * 31) + this.sku.hashCode()) * 31) + this.barcodeAliases.hashCode()) * 31) + Long.hashCode(this.categoryId)) * 31) + this.unit.hashCode()) * 31) + Double.hashCode(this.purchasePrice)) * 31) + Double.hashCode(this.salePrice)) * 31;
        Double d = this.quantity;
        int hashCode2 = (hashCode + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.saleStep;
        int hashCode3 = (hashCode2 + (d2 == null ? 0 : d2.hashCode())) * 31;
        String str = this.expirationDate;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.isArchived;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        List<String> list = this.imageBase64List;
        return hashCode5 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ProductBody(name=" + this.name + ", barcode=" + this.barcode + ", sku=" + this.sku + ", barcodeAliases=" + this.barcodeAliases + ", categoryId=" + this.categoryId + ", unit=" + this.unit + ", purchasePrice=" + this.purchasePrice + ", salePrice=" + this.salePrice + ", quantity=" + this.quantity + ", saleStep=" + this.saleStep + ", expirationDate=" + this.expirationDate + ", isArchived=" + this.isArchived + ", imageBase64List=" + this.imageBase64List + ")";
    }

    /* compiled from: Catalog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/ProductBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/ProductBody;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ProductBody> serializer() {
            return ProductBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ProductBody(int i, String str, String str2, String str3, List list, long j, String str4, double d, double d2, Double d3, Double d4, String str5, Integer num, List list2, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, ProductBody$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        if ((i & 2) == 0) {
            this.barcode = "";
        } else {
            this.barcode = str2;
        }
        if ((i & 4) == 0) {
            this.sku = "";
        } else {
            this.sku = str3;
        }
        if ((i & 8) == 0) {
            this.barcodeAliases = CollectionsKt.emptyList();
        } else {
            this.barcodeAliases = list;
        }
        if ((i & 16) == 0) {
            this.categoryId = 0L;
        } else {
            this.categoryId = j;
        }
        if ((i & 32) == 0) {
            this.unit = "pcs";
        } else {
            this.unit = str4;
        }
        if ((i & 64) == 0) {
            this.purchasePrice = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.purchasePrice = d;
        }
        if ((i & 128) == 0) {
            this.salePrice = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.salePrice = d2;
        }
        if ((i & 256) == 0) {
            this.quantity = null;
        } else {
            this.quantity = d3;
        }
        if ((i & 512) == 0) {
            this.saleStep = null;
        } else {
            this.saleStep = d4;
        }
        if ((i & 1024) == 0) {
            this.expirationDate = null;
        } else {
            this.expirationDate = str5;
        }
        if ((i & 2048) == 0) {
            this.isArchived = null;
        } else {
            this.isArchived = num;
        }
        if ((i & 4096) == 0) {
            this.imageBase64List = null;
        } else {
            this.imageBase64List = list2;
        }
    }

    public ProductBody(String name, String barcode, String sku, List<String> barcodeAliases, long j, String unit, double d, double d2, Double d3, Double d4, String str, Integer num, List<String> list) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(barcode, "barcode");
        Intrinsics.checkNotNullParameter(sku, "sku");
        Intrinsics.checkNotNullParameter(barcodeAliases, "barcodeAliases");
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.name = name;
        this.barcode = barcode;
        this.sku = sku;
        this.barcodeAliases = barcodeAliases;
        this.categoryId = j;
        this.unit = unit;
        this.purchasePrice = d;
        this.salePrice = d2;
        this.quantity = d3;
        this.saleStep = d4;
        this.expirationDate = str;
        this.isArchived = num;
        this.imageBase64List = list;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(ProductBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.name);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.barcode, "")) {
            output.encodeStringElement(serialDesc, 1, self.barcode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.sku, "")) {
            output.encodeStringElement(serialDesc, 2, self.sku);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.barcodeAliases, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.barcodeAliases);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.categoryId != 0) {
            output.encodeLongElement(serialDesc, 4, self.categoryId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.unit, "pcs")) {
            output.encodeStringElement(serialDesc, 5, self.unit);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || Double.compare(self.purchasePrice, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeDoubleElement(serialDesc, 6, self.purchasePrice);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || Double.compare(self.salePrice, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeDoubleElement(serialDesc, 7, self.salePrice);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.quantity != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, DoubleSerializer.INSTANCE, self.quantity);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.saleStep != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, DoubleSerializer.INSTANCE, self.saleStep);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.expirationDate != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.expirationDate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.isArchived != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, IntSerializer.INSTANCE, self.isArchived);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 12) && self.imageBase64List == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 12, lazyArr[12].getValue(), self.imageBase64List);
    }

    public /* synthetic */ ProductBody(String str, String str2, String str3, List list, long j, String str4, double d, double d2, Double d3, Double d4, String str5, Integer num, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) == 0 ? str3 : "", (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? 0L : j, (i & 32) != 0 ? "pcs" : str4, (i & 64) != 0 ? 0.0d : d, (i & 128) == 0 ? d2 : AudioStats.AUDIO_AMPLITUDE_NONE, (i & 256) != 0 ? null : d3, (i & 512) != 0 ? null : d4, (i & 1024) != 0 ? null : str5, (i & 2048) != 0 ? null : num, (i & 4096) != 0 ? null : list2);
    }

    public final String getName() {
        return this.name;
    }

    public final String getBarcode() {
        return this.barcode;
    }

    public final String getSku() {
        return this.sku;
    }

    public final List<String> getBarcodeAliases() {
        return this.barcodeAliases;
    }

    public final long getCategoryId() {
        return this.categoryId;
    }

    public final String getUnit() {
        return this.unit;
    }

    public final double getPurchasePrice() {
        return this.purchasePrice;
    }

    public final double getSalePrice() {
        return this.salePrice;
    }

    public final Double getQuantity() {
        return this.quantity;
    }

    public final Double getSaleStep() {
        return this.saleStep;
    }

    public final String getExpirationDate() {
        return this.expirationDate;
    }

    public final Integer isArchived() {
        return this.isArchived;
    }

    public final List<String> getImageBase64List() {
        return this.imageBase64List;
    }
}
