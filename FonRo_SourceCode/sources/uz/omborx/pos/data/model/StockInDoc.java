package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 [2\u00020\u0001:\u0002Z[B\u0085\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u0087\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0012\u0010\u0018J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u000bHÆ\u0003J\t\u0010G\u001a\u00020\u000bHÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\u0087\u0001\u0010K\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0001J\u0014\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010O\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010P\u001a\u00020\u0005HÖ\u0081\u0004J)\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH\u0001b\u0002\bY¢\u0006\u0002\bXR*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\t0\u001f¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR,\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b#\u0012\b\b$\u0012\u0004\b\b(%¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\"R8\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b#\u0012\b\b$\u0012\u0004\b\b((r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\t0\u001f¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u001a\u001a\u0004\b'\u0010\u001cR,\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b#\u0012\b\b$\u0012\u0004\b\b(+¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u001a\u001a\u0004\b*\u0010\"R,\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b#\u0012\b\b$\u0012\u0004\b\b(.¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001a\u001a\u0004\b-\u0010\"R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R8\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004r\f\b#\u0012\b\b$\u0012\u0004\b\b(3r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\t04¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u001a\u001a\u0004\b1\u00102R8\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004r\f\b#\u0012\b\b$\u0012\u0004\b\b(7r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\t04¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010\u001a\u001a\u0004\b6\u00102R*\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b#\u0012\b\b$\u0012\u0004\b\b(:¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010\u001a\u001a\u0004\b9\u0010\"R,\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b#\u0012\b\b$\u0012\u0004\b\b(=¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010\u001a\u001a\u0004\b<\u0010\"R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?Ê\u0001\u0002\b\u001dÊ\u0001\f\b]\u0012\b\b^\u0012\u0004\b\u0003\u0010\u0000¨\u0006\\"}, d2 = {"Luz/FonRo/pos/data/model/StockInDoc;", "", "id", "", "clientId", "", "supplierId", "supplierName", "invoiceNumber", "note", "paidAmount", "", "totalAmount", "createdAt", "createdByName", FirebaseAnalytics.Param.ITEMS, "", "Luz/FonRo/pos/data/model/StockInItem;", "<init>", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getClientId$annotations", "getClientId", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "client_id", "getSupplierId$annotations", "getSupplierId", "supplier_id", "getSupplierName$annotations", "getSupplierName", "supplier_name", "getInvoiceNumber$annotations", "getInvoiceNumber", "invoice_number", "getNote", "getPaidAmount$annotations", "getPaidAmount", "()D", "paid_amount", "Luz/FonRo/pos/data/net/LenientDouble;", "getTotalAmount$annotations", "getTotalAmount", "total_amount", "getCreatedAt$annotations", "getCreatedAt", "created_at", "getCreatedByName$annotations", "getCreatedByName", "created_by_name", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class StockInDoc {
    private final String clientId;
    private final String createdAt;
    private final String createdByName;
    private final long id;
    private final String invoiceNumber;
    private final List<StockInItem> items;
    private final String note;
    private final double paidAmount;
    private final long supplierId;
    private final String supplierName;
    private final double totalAmount;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.StockInDoc$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = StockInDoc._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public StockInDoc() {
        this(0L, (String) null, 0L, (String) null, (String) null, (String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, (String) null, (String) null, (List) null, 2047, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(StockInItem$$serializer.INSTANCE);
    }

    @SerialName("client_id")
    public static /* synthetic */ void getClientId$annotations() {
    }

    @SerialName("created_at")
    public static /* synthetic */ void getCreatedAt$annotations() {
    }

    @SerialName("created_by_name")
    public static /* synthetic */ void getCreatedByName$annotations() {
    }

    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("invoice_number")
    public static /* synthetic */ void getInvoiceNumber$annotations() {
    }

    @SerialName("paid_amount")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getPaidAmount$annotations() {
    }

    @SerialName("supplier_id")
    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getSupplierId$annotations() {
    }

    @SerialName("supplier_name")
    public static /* synthetic */ void getSupplierName$annotations() {
    }

    @SerialName("total_amount")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getTotalAmount$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getCreatedByName() {
        return this.createdByName;
    }

    public final List<StockInItem> component11() {
        return this.items;
    }

    /* renamed from: component2, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getSupplierId() {
        return this.supplierId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSupplierName() {
        return this.supplierName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getInvoiceNumber() {
        return this.invoiceNumber;
    }

    /* renamed from: component6, reason: from getter */
    public final String getNote() {
        return this.note;
    }

    /* renamed from: component7, reason: from getter */
    public final double getPaidAmount() {
        return this.paidAmount;
    }

    /* renamed from: component8, reason: from getter */
    public final double getTotalAmount() {
        return this.totalAmount;
    }

    /* renamed from: component9, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final StockInDoc copy(long id, String clientId, long supplierId, String supplierName, String invoiceNumber, String note, double paidAmount, double totalAmount, String createdAt, String createdByName, List<StockInItem> items) {
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(items, "items");
        return new StockInDoc(id, clientId, supplierId, supplierName, invoiceNumber, note, paidAmount, totalAmount, createdAt, createdByName, items);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StockInDoc)) {
            return false;
        }
        StockInDoc stockInDoc = (StockInDoc) other;
        return this.id == stockInDoc.id && Intrinsics.areEqual(this.clientId, stockInDoc.clientId) && this.supplierId == stockInDoc.supplierId && Intrinsics.areEqual(this.supplierName, stockInDoc.supplierName) && Intrinsics.areEqual(this.invoiceNumber, stockInDoc.invoiceNumber) && Intrinsics.areEqual(this.note, stockInDoc.note) && Double.compare(this.paidAmount, stockInDoc.paidAmount) == 0 && Double.compare(this.totalAmount, stockInDoc.totalAmount) == 0 && Intrinsics.areEqual(this.createdAt, stockInDoc.createdAt) && Intrinsics.areEqual(this.createdByName, stockInDoc.createdByName) && Intrinsics.areEqual(this.items, stockInDoc.items);
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.id) * 31;
        String str = this.clientId;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.supplierId)) * 31;
        String str2 = this.supplierName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.invoiceNumber;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.note;
        int hashCode5 = (((((((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + Double.hashCode(this.paidAmount)) * 31) + Double.hashCode(this.totalAmount)) * 31) + this.createdAt.hashCode()) * 31;
        String str5 = this.createdByName;
        return ((hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.items.hashCode();
    }

    public String toString() {
        return "StockInDoc(id=" + this.id + ", clientId=" + this.clientId + ", supplierId=" + this.supplierId + ", supplierName=" + this.supplierName + ", invoiceNumber=" + this.invoiceNumber + ", note=" + this.note + ", paidAmount=" + this.paidAmount + ", totalAmount=" + this.totalAmount + ", createdAt=" + this.createdAt + ", createdByName=" + this.createdByName + ", items=" + this.items + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/StockInDoc$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/StockInDoc;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<StockInDoc> serializer() {
            return StockInDoc$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ StockInDoc(int i, long j, String str, long j2, String str2, String str3, String str4, double d, double d2, String str5, String str6, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.id = 0L;
        } else {
            this.id = j;
        }
        if ((i & 2) == 0) {
            this.clientId = null;
        } else {
            this.clientId = str;
        }
        if ((i & 4) == 0) {
            this.supplierId = 0L;
        } else {
            this.supplierId = j2;
        }
        if ((i & 8) == 0) {
            this.supplierName = null;
        } else {
            this.supplierName = str2;
        }
        if ((i & 16) == 0) {
            this.invoiceNumber = null;
        } else {
            this.invoiceNumber = str3;
        }
        if ((i & 32) == 0) {
            this.note = null;
        } else {
            this.note = str4;
        }
        int i2 = i & 64;
        double d3 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (i2 == 0) {
            this.paidAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.paidAmount = d;
        }
        this.totalAmount = (i & 128) != 0 ? d2 : d3;
        this.createdAt = (i & 256) == 0 ? "" : str5;
        if ((i & 512) == 0) {
            this.createdByName = null;
        } else {
            this.createdByName = str6;
        }
        this.items = (i & 1024) == 0 ? CollectionsKt.emptyList() : list;
    }

    public StockInDoc(long j, String str, long j2, String str2, String str3, String str4, double d, double d2, String createdAt, String str5, List<StockInItem> items) {
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(items, "items");
        this.id = j;
        this.clientId = str;
        this.supplierId = j2;
        this.supplierName = str2;
        this.invoiceNumber = str3;
        this.note = str4;
        this.paidAmount = d;
        this.totalAmount = d2;
        this.createdAt = createdAt;
        this.createdByName = str5;
        this.items = items;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(StockInDoc self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.clientId != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.clientId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.supplierId != 0) {
            output.encodeSerializableElement(serialDesc, 2, LenientLong.INSTANCE, Long.valueOf(self.supplierId));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.supplierName != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.supplierName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.invoiceNumber != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.invoiceNumber);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.note != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.note);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || Double.compare(self.paidAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 6, LenientDouble.INSTANCE, Double.valueOf(self.paidAmount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || Double.compare(self.totalAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 7, LenientDouble.INSTANCE, Double.valueOf(self.totalAmount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.createdAt, "")) {
            output.encodeStringElement(serialDesc, 8, self.createdAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.createdByName != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.createdByName);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 10) && Intrinsics.areEqual(self.items, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 10, lazyArr[10].getValue(), self.items);
    }

    public final long getId() {
        return this.id;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final long getSupplierId() {
        return this.supplierId;
    }

    public final String getSupplierName() {
        return this.supplierName;
    }

    public final String getInvoiceNumber() {
        return this.invoiceNumber;
    }

    public final String getNote() {
        return this.note;
    }

    public final double getPaidAmount() {
        return this.paidAmount;
    }

    public final double getTotalAmount() {
        return this.totalAmount;
    }

    public /* synthetic */ StockInDoc(long j, String str, long j2, String str2, String str3, String str4, double d, double d2, String str5, String str6, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str, (i & 4) == 0 ? j2 : 0L, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? 0.0d : d, (i & 128) == 0 ? d2 : AudioStats.AUDIO_AMPLITUDE_NONE, (i & 256) != 0 ? "" : str5, (i & 512) == 0 ? str6 : null, (i & 1024) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getCreatedByName() {
        return this.createdByName;
    }

    public final List<StockInItem> getItems() {
        return this.items;
    }
}
