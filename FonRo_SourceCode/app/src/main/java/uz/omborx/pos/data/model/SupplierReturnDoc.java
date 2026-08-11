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
import uz.FonRo.pos.data.net.LenientBool;
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientInt;
import uz.FonRo.pos.data.net.LenientLong;
import uz.FonRo.pos.ui.docs.SupplierReturnCompensation;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 k2\u00020\u0001:\u0002jkB¡\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b\u0017\u0010\u0018B\u009f\u0001\b\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0017\u0010\u001cJ\t\u0010N\u001a\u00020\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u0007HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\t\u0010U\u001a\u00020\rHÆ\u0003J\t\u0010V\u001a\u00020\rHÆ\u0003J\t\u0010W\u001a\u00020\u0010HÆ\u0003J\t\u0010X\u001a\u00020\u0010HÆ\u0003J\t\u0010Y\u001a\u00020\u0005HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015HÆ\u0003J£\u0001\u0010\\\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015HÆ\u0001J\u0014\u0010]\u001a\u00020\u00102\b\u0010^\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010_\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010`\u001a\u00020\u0005HÖ\u0081\u0004J)\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u00002\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0001b\u0002\bi¢\u0006\u0002\bhR*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b!\u0012\b\b\"\u0012\u0004\b\t0#¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R,\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b'\u0012\b\b(\u0012\u0004\b\b()¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010&R8\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b'\u0012\b\b(\u0012\u0004\b\b(-r\f\b!\u0012\b\b\"\u0012\u0004\b\t0.¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001e\u001a\u0004\b+\u0010,R8\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b'\u0012\b\b(\u0012\u0004\b\b(1r\f\b!\u0012\b\b\"\u0012\u0004\b\t0#¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\u001e\u001a\u0004\b0\u0010 R,\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b'\u0012\b\b(\u0012\u0004\b\b(4¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u001e\u001a\u0004\b3\u0010&R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010&R*\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b'\u0012\b\b(\u0012\u0004\b\b(8¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u001e\u001a\u0004\b7\u0010&R*\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004r\f\b!\u0012\b\b\"\u0012\u0004\b\t0<¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010\u001e\u001a\u0004\b:\u0010;R*\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004r\f\b!\u0012\b\b\"\u0012\u0004\b\t0<¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010\u001e\u001a\u0004\b>\u0010;R8\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004r\f\b'\u0012\b\b(\u0012\u0004\b\b(Ar\f\b!\u0012\b\b\"\u0012\u0004\b\t0B¢\u0006\u000e\n\u0000\u0012\u0004\b?\u0010\u001e\u001a\u0004\b\u000f\u0010@R8\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004r\f\b'\u0012\b\b(\u0012\u0004\b\b(Er\f\b!\u0012\b\b\"\u0012\u0004\b\t0B¢\u0006\u000e\n\u0000\u0012\u0004\bC\u0010\u001e\u001a\u0004\bD\u0010@R*\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b'\u0012\b\b(\u0012\u0004\b\b(H¢\u0006\u000e\n\u0000\u0012\u0004\bF\u0010\u001e\u001a\u0004\bG\u0010&R,\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b'\u0012\b\b(\u0012\u0004\b\b(K¢\u0006\u000e\n\u0000\u0012\u0004\bI\u0010\u001e\u001a\u0004\bJ\u0010&R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MÊ\u0001\u0002\b!Ê\u0001\f\bm\u0012\b\bn\u0012\u0004\b\u0003\u0010\u0000¨\u0006l"}, d2 = {"Luz/FonRo/pos/data/model/SupplierReturnDoc;", "", "id", "", "clientId", "", "docNumber", "", "supplierId", "supplierName", "reason", "compensationType", "amount", "", FirebaseAnalytics.Param.QUANTITY, "isCanceled", "", "canCancel", "createdAt", "createdByName", FirebaseAnalytics.Param.ITEMS, "", "Luz/FonRo/pos/data/model/SupplierReturnItem;", "<init>", "(JLjava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;DDZZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;DDZZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getClientId$annotations", "getClientId", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "client_id", "getDocNumber$annotations", "getDocNumber", "()I", "doc_number", "Luz/FonRo/pos/data/net/LenientInt;", "getSupplierId$annotations", "getSupplierId", "supplier_id", "getSupplierName$annotations", "getSupplierName", "supplier_name", "getReason", "getCompensationType$annotations", "getCompensationType", "compensation_type", "getAmount$annotations", "getAmount", "()D", "Luz/FonRo/pos/data/net/LenientDouble;", "getQuantity$annotations", "getQuantity", "isCanceled$annotations", "()Z", "is_canceled", "Luz/FonRo/pos/data/net/LenientBool;", "getCanCancel$annotations", "getCanCancel", "can_cancel", "getCreatedAt$annotations", "getCreatedAt", "created_at", "getCreatedByName$annotations", "getCreatedByName", "created_by_name", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class SupplierReturnDoc {
    private final double amount;
    private final boolean canCancel;
    private final String clientId;
    private final String compensationType;
    private final String createdAt;
    private final String createdByName;
    private final int docNumber;
    private final long id;
    private final boolean isCanceled;
    private final List<SupplierReturnItem> items;
    private final double quantity;
    private final String reason;
    private final long supplierId;
    private final String supplierName;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.SupplierReturnDoc$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = SupplierReturnDoc._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public SupplierReturnDoc() {
        this(0L, (String) null, 0, 0L, (String) null, (String) null, (String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, false, false, (String) null, (String) null, (List) null, 16383, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(SupplierReturnItem$$serializer.INSTANCE);
    }

    public static /* synthetic */ SupplierReturnDoc copy$default(SupplierReturnDoc supplierReturnDoc, long j, String str, int i, long j2, String str2, String str3, String str4, double d, double d2, boolean z, boolean z2, String str5, String str6, List list, int i2, Object obj) {
        long j3 = (i2 & 1) != 0 ? supplierReturnDoc.id : j;
        String str7 = (i2 & 2) != 0 ? supplierReturnDoc.clientId : str;
        int i3 = (i2 & 4) != 0 ? supplierReturnDoc.docNumber : i;
        long j4 = (i2 & 8) != 0 ? supplierReturnDoc.supplierId : j2;
        String str8 = (i2 & 16) != 0 ? supplierReturnDoc.supplierName : str2;
        String str9 = (i2 & 32) != 0 ? supplierReturnDoc.reason : str3;
        String str10 = (i2 & 64) != 0 ? supplierReturnDoc.compensationType : str4;
        double d3 = (i2 & 128) != 0 ? supplierReturnDoc.amount : d;
        double d4 = (i2 & 256) != 0 ? supplierReturnDoc.quantity : d2;
        boolean z3 = (i2 & 512) != 0 ? supplierReturnDoc.isCanceled : z;
        long j5 = j3;
        boolean z4 = (i2 & 1024) != 0 ? supplierReturnDoc.canCancel : z2;
        return supplierReturnDoc.copy(j5, str7, i3, j4, str8, str9, str10, d3, d4, z3, z4, (i2 & 2048) != 0 ? supplierReturnDoc.createdAt : str5, (i2 & 4096) != 0 ? supplierReturnDoc.createdByName : str6, (i2 & 8192) != 0 ? supplierReturnDoc.items : list);
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getAmount$annotations() {
    }

    @SerialName("can_cancel")
    @Serializable(with = LenientBool.class)
    public static /* synthetic */ void getCanCancel$annotations() {
    }

    @SerialName("client_id")
    public static /* synthetic */ void getClientId$annotations() {
    }

    @SerialName("compensation_type")
    public static /* synthetic */ void getCompensationType$annotations() {
    }

    @SerialName("created_at")
    public static /* synthetic */ void getCreatedAt$annotations() {
    }

    @SerialName("created_by_name")
    public static /* synthetic */ void getCreatedByName$annotations() {
    }

    @SerialName("doc_number")
    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getDocNumber$annotations() {
    }

    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getId$annotations() {
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getQuantity$annotations() {
    }

    @SerialName("supplier_id")
    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getSupplierId$annotations() {
    }

    @SerialName("supplier_name")
    public static /* synthetic */ void getSupplierName$annotations() {
    }

    @SerialName("is_canceled")
    @Serializable(with = LenientBool.class)
    public static /* synthetic */ void isCanceled$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsCanceled() {
        return this.isCanceled;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getCanCancel() {
        return this.canCancel;
    }

    /* renamed from: component12, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component13, reason: from getter */
    public final String getCreatedByName() {
        return this.createdByName;
    }

    public final List<SupplierReturnItem> component14() {
        return this.items;
    }

    /* renamed from: component2, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDocNumber() {
        return this.docNumber;
    }

    /* renamed from: component4, reason: from getter */
    public final long getSupplierId() {
        return this.supplierId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSupplierName() {
        return this.supplierName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: component7, reason: from getter */
    public final String getCompensationType() {
        return this.compensationType;
    }

    /* renamed from: component8, reason: from getter */
    public final double getAmount() {
        return this.amount;
    }

    /* renamed from: component9, reason: from getter */
    public final double getQuantity() {
        return this.quantity;
    }

    public final SupplierReturnDoc copy(long id, String clientId, int docNumber, long supplierId, String supplierName, String reason, String compensationType, double amount, double quantity, boolean isCanceled, boolean canCancel, String createdAt, String createdByName, List<SupplierReturnItem> items) {
        Intrinsics.checkNotNullParameter(compensationType, "compensationType");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(items, "items");
        return new SupplierReturnDoc(id, clientId, docNumber, supplierId, supplierName, reason, compensationType, amount, quantity, isCanceled, canCancel, createdAt, createdByName, items);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SupplierReturnDoc)) {
            return false;
        }
        SupplierReturnDoc supplierReturnDoc = (SupplierReturnDoc) other;
        return this.id == supplierReturnDoc.id && Intrinsics.areEqual(this.clientId, supplierReturnDoc.clientId) && this.docNumber == supplierReturnDoc.docNumber && this.supplierId == supplierReturnDoc.supplierId && Intrinsics.areEqual(this.supplierName, supplierReturnDoc.supplierName) && Intrinsics.areEqual(this.reason, supplierReturnDoc.reason) && Intrinsics.areEqual(this.compensationType, supplierReturnDoc.compensationType) && Double.compare(this.amount, supplierReturnDoc.amount) == 0 && Double.compare(this.quantity, supplierReturnDoc.quantity) == 0 && this.isCanceled == supplierReturnDoc.isCanceled && this.canCancel == supplierReturnDoc.canCancel && Intrinsics.areEqual(this.createdAt, supplierReturnDoc.createdAt) && Intrinsics.areEqual(this.createdByName, supplierReturnDoc.createdByName) && Intrinsics.areEqual(this.items, supplierReturnDoc.items);
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.id) * 31;
        String str = this.clientId;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.docNumber)) * 31) + Long.hashCode(this.supplierId)) * 31;
        String str2 = this.supplierName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.reason;
        int hashCode4 = (((((((((((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.compensationType.hashCode()) * 31) + Double.hashCode(this.amount)) * 31) + Double.hashCode(this.quantity)) * 31) + Boolean.hashCode(this.isCanceled)) * 31) + Boolean.hashCode(this.canCancel)) * 31) + this.createdAt.hashCode()) * 31;
        String str4 = this.createdByName;
        return ((hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.items.hashCode();
    }

    public String toString() {
        return "SupplierReturnDoc(id=" + this.id + ", clientId=" + this.clientId + ", docNumber=" + this.docNumber + ", supplierId=" + this.supplierId + ", supplierName=" + this.supplierName + ", reason=" + this.reason + ", compensationType=" + this.compensationType + ", amount=" + this.amount + ", quantity=" + this.quantity + ", isCanceled=" + this.isCanceled + ", canCancel=" + this.canCancel + ", createdAt=" + this.createdAt + ", createdByName=" + this.createdByName + ", items=" + this.items + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/SupplierReturnDoc$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/SupplierReturnDoc;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SupplierReturnDoc> serializer() {
            return SupplierReturnDoc$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SupplierReturnDoc(int i, long j, String str, int i2, long j2, String str2, String str3, String str4, double d, double d2, boolean z, boolean z2, String str5, String str6, List list, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.docNumber = 0;
        } else {
            this.docNumber = i2;
        }
        if ((i & 8) == 0) {
            this.supplierId = 0L;
        } else {
            this.supplierId = j2;
        }
        if ((i & 16) == 0) {
            this.supplierName = null;
        } else {
            this.supplierName = str2;
        }
        if ((i & 32) == 0) {
            this.reason = null;
        } else {
            this.reason = str3;
        }
        if ((i & 64) == 0) {
            this.compensationType = SupplierReturnCompensation.REDUCE_DEBT;
        } else {
            this.compensationType = str4;
        }
        int i3 = i & 128;
        double d3 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (i3 == 0) {
            this.amount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.amount = d;
        }
        this.quantity = (i & 256) != 0 ? d2 : d3;
        if ((i & 512) == 0) {
            this.isCanceled = false;
        } else {
            this.isCanceled = z;
        }
        if ((i & 1024) == 0) {
            this.canCancel = false;
        } else {
            this.canCancel = z2;
        }
        this.createdAt = (i & 2048) == 0 ? "" : str5;
        if ((i & 4096) == 0) {
            this.createdByName = null;
        } else {
            this.createdByName = str6;
        }
        this.items = (i & 8192) == 0 ? CollectionsKt.emptyList() : list;
    }

    public SupplierReturnDoc(long j, String str, int i, long j2, String str2, String str3, String compensationType, double d, double d2, boolean z, boolean z2, String createdAt, String str4, List<SupplierReturnItem> items) {
        Intrinsics.checkNotNullParameter(compensationType, "compensationType");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(items, "items");
        this.id = j;
        this.clientId = str;
        this.docNumber = i;
        this.supplierId = j2;
        this.supplierName = str2;
        this.reason = str3;
        this.compensationType = compensationType;
        this.amount = d;
        this.quantity = d2;
        this.isCanceled = z;
        this.canCancel = z2;
        this.createdAt = createdAt;
        this.createdByName = str4;
        this.items = items;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(SupplierReturnDoc self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.clientId != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.clientId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.docNumber != 0) {
            output.encodeSerializableElement(serialDesc, 2, LenientInt.INSTANCE, Integer.valueOf(self.docNumber));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.supplierId != 0) {
            output.encodeSerializableElement(serialDesc, 3, LenientLong.INSTANCE, Long.valueOf(self.supplierId));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.supplierName != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.supplierName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.reason != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.reason);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.compensationType, SupplierReturnCompensation.REDUCE_DEBT)) {
            output.encodeStringElement(serialDesc, 6, self.compensationType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || Double.compare(self.amount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 7, LenientDouble.INSTANCE, Double.valueOf(self.amount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || Double.compare(self.quantity, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 8, LenientDouble.INSTANCE, Double.valueOf(self.quantity));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.isCanceled) {
            output.encodeSerializableElement(serialDesc, 9, LenientBool.INSTANCE, Boolean.valueOf(self.isCanceled));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.canCancel) {
            output.encodeSerializableElement(serialDesc, 10, LenientBool.INSTANCE, Boolean.valueOf(self.canCancel));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || !Intrinsics.areEqual(self.createdAt, "")) {
            output.encodeStringElement(serialDesc, 11, self.createdAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.createdByName != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.createdByName);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 13) && Intrinsics.areEqual(self.items, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 13, lazyArr[13].getValue(), self.items);
    }

    public final long getId() {
        return this.id;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final int getDocNumber() {
        return this.docNumber;
    }

    public final long getSupplierId() {
        return this.supplierId;
    }

    public final String getSupplierName() {
        return this.supplierName;
    }

    public final String getReason() {
        return this.reason;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ SupplierReturnDoc(long r18, java.lang.String r20, int r21, long r22, java.lang.String r24, java.lang.String r25, java.lang.String r26, double r27, double r29, boolean r31, boolean r32, java.lang.String r33, java.lang.String r34, java.util.List r35, int r36, kotlin.jvm.internal.DefaultConstructorMarker r37) {
        /*
            r17 = this;
            r0 = r36
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto La
            r4 = r2
            goto Lc
        La:
            r4 = r18
        Lc:
            r1 = r0 & 2
            if (r1 == 0) goto L12
            r1 = 0
            goto L14
        L12:
            r1 = r20
        L14:
            r7 = r0 & 4
            r8 = 0
            if (r7 == 0) goto L1b
            r7 = r8
            goto L1d
        L1b:
            r7 = r21
        L1d:
            r9 = r0 & 8
            if (r9 == 0) goto L22
            goto L24
        L22:
            r2 = r22
        L24:
            r9 = r0 & 16
            if (r9 == 0) goto L2a
            r9 = 0
            goto L2c
        L2a:
            r9 = r24
        L2c:
            r10 = r0 & 32
            if (r10 == 0) goto L32
            r10 = 0
            goto L34
        L32:
            r10 = r25
        L34:
            r11 = r0 & 64
            if (r11 == 0) goto L3b
            java.lang.String r11 = "reduce_debt"
            goto L3d
        L3b:
            r11 = r26
        L3d:
            r12 = r0 & 128(0x80, float:1.794E-43)
            r13 = 0
            if (r12 == 0) goto L45
            r15 = r13
            goto L47
        L45:
            r15 = r27
        L47:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L4c
            goto L4e
        L4c:
            r13 = r29
        L4e:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L54
            r12 = r8
            goto L56
        L54:
            r12 = r31
        L56:
            r6 = r0 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L5b
            goto L5d
        L5b:
            r8 = r32
        L5d:
            r6 = r0 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L64
            java.lang.String r6 = ""
            goto L66
        L64:
            r6 = r33
        L66:
            r19 = r1
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L6e
            r1 = 0
            goto L70
        L6e:
            r1 = r34
        L70:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L7b
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r36 = r0
            goto L7d
        L7b:
            r36 = r35
        L7d:
            r18 = r17
            r21 = r19
            r35 = r1
            r23 = r2
            r19 = r4
            r34 = r6
            r22 = r7
            r33 = r8
            r25 = r9
            r26 = r10
            r27 = r11
            r32 = r12
            r30 = r13
            r28 = r15
            r18.<init>(r19, r21, r22, r23, r25, r26, r27, r28, r30, r32, r33, r34, r35, r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.data.model.SupplierReturnDoc.<init>(long, java.lang.String, int, long, java.lang.String, java.lang.String, java.lang.String, double, double, boolean, boolean, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getCompensationType() {
        return this.compensationType;
    }

    public final double getAmount() {
        return this.amount;
    }

    public final double getQuantity() {
        return this.quantity;
    }

    public final boolean isCanceled() {
        return this.isCanceled;
    }

    public final boolean getCanCancel() {
        return this.canCancel;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getCreatedByName() {
        return this.createdByName;
    }

    public final List<SupplierReturnItem> getItems() {
        return this.items;
    }
}
