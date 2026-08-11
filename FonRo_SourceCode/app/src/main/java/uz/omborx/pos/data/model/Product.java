package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientInt;
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 u2\u00020\u0001:\u0002tuB½\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018B¹\u0001\b\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0017\u0010\u001cJ\u000e\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0005J\u000e\u0010T\u001a\u00020R2\u0006\u0010U\u001a\u00020\u0005J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010[\u001a\u00020\u000bHÆ\u0003J\t\u0010\\\u001a\u00020\u0005HÆ\u0003J\t\u0010]\u001a\u00020\u000bHÆ\u0003J\t\u0010^\u001a\u00020\u000bHÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u000bHÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010e\u001a\u00020\u0016HÆ\u0003J¿\u0001\u0010f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u0016HÆ\u0001J\u0014\u0010g\u001a\u00020R2\b\u0010h\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010i\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010j\u001a\u00020\u0005HÖ\u0081\u0004J)\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u00002\u0006\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020qH\u0001b\u0002\bs¢\u0006\u0002\brR*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b!\u0012\b\b\"\u0012\u0004\b\t0#¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006X\u0087\u0004r\f\b*\u0012\b\b+\u0012\u0004\b\b(,¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u001e\u001a\u0004\b(\u0010)R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R*\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004r\f\b!\u0012\b\b\"\u0012\u0004\b\t01¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001e\u001a\u0004\b/\u00100R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010%R8\u0010\r\u001a\u00020\u000b8\u0006X\u0087\u0004r\f\b*\u0012\b\b+\u0012\u0004\b\b(5r\f\b!\u0012\b\b\"\u0012\u0004\b\t01¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u001e\u001a\u0004\b4\u00100R8\u0010\u000e\u001a\u00020\u000b8\u0006X\u0087\u0004r\f\b*\u0012\b\b+\u0012\u0004\b\b(8r\f\b!\u0012\b\b\"\u0012\u0004\b\t01¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u001e\u001a\u0004\b7\u00100R8\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b*\u0012\b\b+\u0012\u0004\b\b(;r\f\b!\u0012\b\b\"\u0012\u0004\b\t0#¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010\u001e\u001a\u0004\b:\u0010 R8\u0010\u0010\u001a\u00020\u000b8\u0006X\u0087\u0004r\f\b*\u0012\b\b+\u0012\u0004\b\b(>r\f\b!\u0012\b\b\"\u0012\u0004\b\t01¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010\u001e\u001a\u0004\b=\u00100R,\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b*\u0012\b\b+\u0012\u0004\b\b(A¢\u0006\u000e\n\u0000\u0012\u0004\b?\u0010\u001e\u001a\u0004\b@\u0010%R,\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b*\u0012\b\b+\u0012\u0004\b\b(D¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010\u001e\u001a\u0004\bC\u0010%R0\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006X\u0087\u0004r\f\b*\u0012\b\b+\u0012\u0004\b\b(G¢\u0006\u000e\n\u0000\u0012\u0004\bE\u0010\u001e\u001a\u0004\bF\u0010)R,\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b*\u0012\b\b+\u0012\u0004\b\b(J¢\u0006\u000e\n\u0000\u0012\u0004\bH\u0010\u001e\u001a\u0004\bI\u0010%R8\u0010\u0015\u001a\u00020\u00168\u0006X\u0087\u0004r\f\b*\u0012\b\b+\u0012\u0004\b\b(Mr\f\b!\u0012\b\b\"\u0012\u0004\b\t0N¢\u0006\u000e\n\u0000\u0012\u0004\bK\u0010\u001e\u001a\u0004\b\u0015\u0010LR\u0013\u0010O\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\bP\u0010%Ê\u0001\u0002\b!Ê\u0001\f\bw\u0012\b\bx\u0012\u0004\b\u0003\u0010\u0002¨\u0006v"}, d2 = {"Luz/FonRo/pos/data/model/Product;", "", "id", "", "name", "", OptionalModuleUtils.BARCODE, "barcodeAliases", "", "sku", FirebaseAnalytics.Param.QUANTITY, "", "unit", "salePrice", "purchasePrice", "categoryId", "saleStep", "expirationDate", "imageUrl", "imageUrls", "imageBase64", "isArchived", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;DLjava/lang/String;DDJDLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;DLjava/lang/String;DDJDLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getName", "()Ljava/lang/String;", "getBarcode", "getBarcodeAliases$annotations", "getBarcodeAliases", "()Ljava/util/List;", "Lkotlinx/serialization/SerialName;", "value", "barcode_aliases", "getSku", "getQuantity$annotations", "getQuantity", "()D", "Luz/FonRo/pos/data/net/LenientDouble;", "getUnit", "getSalePrice$annotations", "getSalePrice", "sale_price", "getPurchasePrice$annotations", "getPurchasePrice", "purchase_price", "getCategoryId$annotations", "getCategoryId", "category_id", "getSaleStep$annotations", "getSaleStep", "sale_step", "getExpirationDate$annotations", "getExpirationDate", "expiration_date", "getImageUrl$annotations", "getImageUrl", "image_url", "getImageUrls$annotations", "getImageUrls", "image_urls", "getImageBase64$annotations", "getImageBase64", "image_base64", "isArchived$annotations", "()I", "is_archived", "Luz/FonRo/pos/data/net/LenientInt;", "photo", "getPhoto", "matches", "", SearchIntents.EXTRA_QUERY, "hasBarcode", "code", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class Product {
    public static final int $stable = 0;
    private final String barcode;
    private final List<String> barcodeAliases;
    private final long categoryId;
    private final String expirationDate;
    private final long id;
    private final String imageBase64;
    private final String imageUrl;
    private final List<String> imageUrls;
    private final int isArchived;
    private final String name;
    private final double purchasePrice;
    private final double quantity;
    private final double salePrice;
    private final double saleStep;
    private final String sku;
    private final String unit;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.Product$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = Product._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.Product$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = Product._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), null, null};

    public Product() {
        this(0L, (String) null, (String) null, (List) null, (String) null, AudioStats.AUDIO_AMPLITUDE_NONE, (String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0L, AudioStats.AUDIO_AMPLITUDE_NONE, (String) null, (String) null, (List) null, (String) null, 0, 65535, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    public static /* synthetic */ Product copy$default(Product product, long j, String str, String str2, List list, String str3, double d, String str4, double d2, double d3, long j2, double d4, String str5, String str6, List list2, String str7, int i, int i2, Object obj) {
        long j3;
        long j4;
        long j5 = (i2 & 1) != 0 ? product.id : j;
        String str8 = (i2 & 2) != 0 ? product.name : str;
        String str9 = (i2 & 4) != 0 ? product.barcode : str2;
        List list3 = (i2 & 8) != 0 ? product.barcodeAliases : list;
        String str10 = (i2 & 16) != 0 ? product.sku : str3;
        double d5 = (i2 & 32) != 0 ? product.quantity : d;
        String str11 = (i2 & 64) != 0 ? product.unit : str4;
        double d6 = (i2 & 128) != 0 ? product.salePrice : d2;
        double d7 = (i2 & 256) != 0 ? product.purchasePrice : d3;
        if ((i2 & 512) != 0) {
            j3 = j5;
            j4 = product.categoryId;
        } else {
            j3 = j5;
            j4 = j2;
        }
        long j6 = j4;
        double d8 = (i2 & 1024) != 0 ? product.saleStep : d4;
        String str12 = (i2 & 2048) != 0 ? product.expirationDate : str5;
        return product.copy(j3, str8, str9, list3, str10, d5, str11, d6, d7, j6, d8, str12, (i2 & 4096) != 0 ? product.imageUrl : str6, (i2 & 8192) != 0 ? product.imageUrls : list2, (i2 & 16384) != 0 ? product.imageBase64 : str7, (i2 & 32768) != 0 ? product.isArchived : i);
    }

    @SerialName("barcode_aliases")
    public static /* synthetic */ void getBarcodeAliases$annotations() {
    }

    @SerialName("category_id")
    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getCategoryId$annotations() {
    }

    @SerialName("expiration_date")
    public static /* synthetic */ void getExpirationDate$annotations() {
    }

    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("image_base64")
    public static /* synthetic */ void getImageBase64$annotations() {
    }

    @SerialName("image_url")
    public static /* synthetic */ void getImageUrl$annotations() {
    }

    @SerialName("image_urls")
    public static /* synthetic */ void getImageUrls$annotations() {
    }

    @SerialName("purchase_price")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getPurchasePrice$annotations() {
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getQuantity$annotations() {
    }

    @SerialName("sale_price")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getSalePrice$annotations() {
    }

    @SerialName("sale_step")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getSaleStep$annotations() {
    }

    @SerialName("is_archived")
    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void isArchived$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final long getCategoryId() {
        return this.categoryId;
    }

    /* renamed from: component11, reason: from getter */
    public final double getSaleStep() {
        return this.saleStep;
    }

    /* renamed from: component12, reason: from getter */
    public final String getExpirationDate() {
        return this.expirationDate;
    }

    /* renamed from: component13, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final List<String> component14() {
        return this.imageUrls;
    }

    /* renamed from: component15, reason: from getter */
    public final String getImageBase64() {
        return this.imageBase64;
    }

    /* renamed from: component16, reason: from getter */
    public final int getIsArchived() {
        return this.isArchived;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBarcode() {
        return this.barcode;
    }

    public final List<String> component4() {
        return this.barcodeAliases;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSku() {
        return this.sku;
    }

    /* renamed from: component6, reason: from getter */
    public final double getQuantity() {
        return this.quantity;
    }

    /* renamed from: component7, reason: from getter */
    public final String getUnit() {
        return this.unit;
    }

    /* renamed from: component8, reason: from getter */
    public final double getSalePrice() {
        return this.salePrice;
    }

    /* renamed from: component9, reason: from getter */
    public final double getPurchasePrice() {
        return this.purchasePrice;
    }

    public final Product copy(long id, String name, String barcode, List<String> barcodeAliases, String sku, double quantity, String unit, double salePrice, double purchasePrice, long categoryId, double saleStep, String expirationDate, String imageUrl, List<String> imageUrls, String imageBase64, int isArchived) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(barcodeAliases, "barcodeAliases");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(imageUrls, "imageUrls");
        return new Product(id, name, barcode, barcodeAliases, sku, quantity, unit, salePrice, purchasePrice, categoryId, saleStep, expirationDate, imageUrl, imageUrls, imageBase64, isArchived);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Product)) {
            return false;
        }
        Product product = (Product) other;
        return this.id == product.id && Intrinsics.areEqual(this.name, product.name) && Intrinsics.areEqual(this.barcode, product.barcode) && Intrinsics.areEqual(this.barcodeAliases, product.barcodeAliases) && Intrinsics.areEqual(this.sku, product.sku) && Double.compare(this.quantity, product.quantity) == 0 && Intrinsics.areEqual(this.unit, product.unit) && Double.compare(this.salePrice, product.salePrice) == 0 && Double.compare(this.purchasePrice, product.purchasePrice) == 0 && this.categoryId == product.categoryId && Double.compare(this.saleStep, product.saleStep) == 0 && Intrinsics.areEqual(this.expirationDate, product.expirationDate) && Intrinsics.areEqual(this.imageUrl, product.imageUrl) && Intrinsics.areEqual(this.imageUrls, product.imageUrls) && Intrinsics.areEqual(this.imageBase64, product.imageBase64) && this.isArchived == product.isArchived;
    }

    public int hashCode() {
        int hashCode = ((Long.hashCode(this.id) * 31) + this.name.hashCode()) * 31;
        String str = this.barcode;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.barcodeAliases.hashCode()) * 31;
        String str2 = this.sku;
        int hashCode3 = (((((((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Double.hashCode(this.quantity)) * 31) + this.unit.hashCode()) * 31) + Double.hashCode(this.salePrice)) * 31) + Double.hashCode(this.purchasePrice)) * 31) + Long.hashCode(this.categoryId)) * 31) + Double.hashCode(this.saleStep)) * 31;
        String str3 = this.expirationDate;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.imageUrl;
        int hashCode5 = (((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.imageUrls.hashCode()) * 31;
        String str5 = this.imageBase64;
        return ((hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + Integer.hashCode(this.isArchived);
    }

    public String toString() {
        return "Product(id=" + this.id + ", name=" + this.name + ", barcode=" + this.barcode + ", barcodeAliases=" + this.barcodeAliases + ", sku=" + this.sku + ", quantity=" + this.quantity + ", unit=" + this.unit + ", salePrice=" + this.salePrice + ", purchasePrice=" + this.purchasePrice + ", categoryId=" + this.categoryId + ", saleStep=" + this.saleStep + ", expirationDate=" + this.expirationDate + ", imageUrl=" + this.imageUrl + ", imageUrls=" + this.imageUrls + ", imageBase64=" + this.imageBase64 + ", isArchived=" + this.isArchived + ")";
    }

    /* compiled from: Catalog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/Product$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/Product;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Product> serializer() {
            return Product$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Product(int i, long j, String str, String str2, List list, String str3, double d, String str4, double d2, double d3, long j2, double d4, String str5, String str6, List list2, String str7, int i2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.id = 0L;
        } else {
            this.id = j;
        }
        if ((i & 2) == 0) {
            this.name = "";
        } else {
            this.name = str;
        }
        if ((i & 4) == 0) {
            this.barcode = null;
        } else {
            this.barcode = str2;
        }
        if ((i & 8) == 0) {
            this.barcodeAliases = CollectionsKt.emptyList();
        } else {
            this.barcodeAliases = list;
        }
        if ((i & 16) == 0) {
            this.sku = null;
        } else {
            this.sku = str3;
        }
        int i3 = i & 32;
        double d5 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (i3 == 0) {
            this.quantity = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.quantity = d;
        }
        if ((i & 64) == 0) {
            this.unit = "pcs";
        } else {
            this.unit = str4;
        }
        if ((i & 128) == 0) {
            this.salePrice = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.salePrice = d2;
        }
        if ((i & 256) == 0) {
            this.purchasePrice = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.purchasePrice = d3;
        }
        if ((i & 512) == 0) {
            this.categoryId = 0L;
        } else {
            this.categoryId = j2;
        }
        this.saleStep = (i & 1024) != 0 ? d4 : d5;
        if ((i & 2048) == 0) {
            this.expirationDate = null;
        } else {
            this.expirationDate = str5;
        }
        if ((i & 4096) == 0) {
            this.imageUrl = null;
        } else {
            this.imageUrl = str6;
        }
        this.imageUrls = (i & 8192) == 0 ? CollectionsKt.emptyList() : list2;
        if ((i & 16384) == 0) {
            this.imageBase64 = null;
        } else {
            this.imageBase64 = str7;
        }
        this.isArchived = (i & 32768) == 0 ? 0 : i2;
    }

    public Product(long j, String name, String str, List<String> barcodeAliases, String str2, double d, String unit, double d2, double d3, long j2, double d4, String str3, String str4, List<String> imageUrls, String str5, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(barcodeAliases, "barcodeAliases");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(imageUrls, "imageUrls");
        this.id = j;
        this.name = name;
        this.barcode = str;
        this.barcodeAliases = barcodeAliases;
        this.sku = str2;
        this.quantity = d;
        this.unit = unit;
        this.salePrice = d2;
        this.purchasePrice = d3;
        this.categoryId = j2;
        this.saleStep = d4;
        this.expirationDate = str3;
        this.imageUrl = str4;
        this.imageUrls = imageUrls;
        this.imageBase64 = str5;
        this.isArchived = i;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(Product self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.name, "")) {
            output.encodeStringElement(serialDesc, 1, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.barcode != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.barcode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.barcodeAliases, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.barcodeAliases);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.sku != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.sku);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || Double.compare(self.quantity, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 5, LenientDouble.INSTANCE, Double.valueOf(self.quantity));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.unit, "pcs")) {
            output.encodeStringElement(serialDesc, 6, self.unit);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || Double.compare(self.salePrice, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 7, LenientDouble.INSTANCE, Double.valueOf(self.salePrice));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || Double.compare(self.purchasePrice, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 8, LenientDouble.INSTANCE, Double.valueOf(self.purchasePrice));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.categoryId != 0) {
            output.encodeSerializableElement(serialDesc, 9, LenientLong.INSTANCE, Long.valueOf(self.categoryId));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || Double.compare(self.saleStep, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 10, LenientDouble.INSTANCE, Double.valueOf(self.saleStep));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.expirationDate != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.expirationDate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.imageUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.imageUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || !Intrinsics.areEqual(self.imageUrls, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 13, lazyArr[13].getValue(), self.imageUrls);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.imageBase64 != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.imageBase64);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 15) && self.isArchived == 0) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 15, LenientInt.INSTANCE, Integer.valueOf(self.isArchived));
    }

    public final long getId() {
        return this.id;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ Product(long r21, java.lang.String r23, java.lang.String r24, java.util.List r25, java.lang.String r26, double r27, java.lang.String r29, double r30, double r32, long r34, double r36, java.lang.String r38, java.lang.String r39, java.util.List r40, java.lang.String r41, int r42, int r43, kotlin.jvm.internal.DefaultConstructorMarker r44) {
        /*
            Method dump skipped, instructions count: 188
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.data.model.Product.<init>(long, java.lang.String, java.lang.String, java.util.List, java.lang.String, double, java.lang.String, double, double, long, double, java.lang.String, java.lang.String, java.util.List, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getName() {
        return this.name;
    }

    public final String getBarcode() {
        return this.barcode;
    }

    public final List<String> getBarcodeAliases() {
        return this.barcodeAliases;
    }

    public final String getSku() {
        return this.sku;
    }

    public final double getQuantity() {
        return this.quantity;
    }

    public final String getUnit() {
        return this.unit;
    }

    public final double getSalePrice() {
        return this.salePrice;
    }

    public final double getPurchasePrice() {
        return this.purchasePrice;
    }

    public final long getCategoryId() {
        return this.categoryId;
    }

    public final double getSaleStep() {
        return this.saleStep;
    }

    public final String getExpirationDate() {
        return this.expirationDate;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final List<String> getImageUrls() {
        return this.imageUrls;
    }

    public final String getImageBase64() {
        return this.imageBase64;
    }

    public final int isArchived() {
        return this.isArchived;
    }

    public final String getPhoto() {
        String str = this.imageUrl;
        if (str != null) {
            if (StringsKt.isBlank(str)) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        String str2 = (String) CollectionsKt.firstOrNull((List) this.imageUrls);
        if (str2 != null) {
            if (StringsKt.isBlank(str2)) {
                str2 = null;
            }
            if (str2 != null) {
                return str2;
            }
        }
        String str3 = this.imageBase64;
        if (str3 != null) {
            if (StringsKt.isBlank(str3)) {
                str3 = null;
            }
            if (str3 != null) {
                if (StringsKt.startsWith$default(str3, "data:", false, 2, (Object) null)) {
                    return str3;
                }
                return "data:image/jpeg;base64," + str3;
            }
        }
        return null;
    }

    public final boolean matches(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        String lowerCase = StringsKt.trim((CharSequence) query).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str = lowerCase;
        if (str.length() == 0) {
            return true;
        }
        String lowerCase2 = this.name.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) str, false, 2, (Object) null)) {
            return true;
        }
        String str2 = this.barcode;
        if (str2 != null && StringsKt.contains$default((CharSequence) str2, (CharSequence) str, false, 2, (Object) null)) {
            return true;
        }
        String str3 = this.sku;
        if (str3 != null) {
            String lowerCase3 = str3.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
            if (lowerCase3 != null && StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) str, false, 2, (Object) null)) {
                return true;
            }
        }
        List<String> list = this.barcodeAliases;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String lowerCase4 = ((String) it.next()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase4, (CharSequence) str, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public final boolean hasBarcode(String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        String obj = StringsKt.trim((CharSequence) code).toString();
        if (obj.length() == 0) {
            return false;
        }
        String str = this.barcode;
        if (Intrinsics.areEqual(str != null ? StringsKt.trim((CharSequence) str).toString() : null, obj)) {
            return true;
        }
        String str2 = this.sku;
        if (Intrinsics.areEqual(str2 != null ? StringsKt.trim((CharSequence) str2).toString() : null, obj)) {
            return true;
        }
        List<String> list = this.barcodeAliases;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(StringsKt.trim((CharSequence) it.next()).toString(), obj)) {
                return true;
            }
        }
        return false;
    }
}
