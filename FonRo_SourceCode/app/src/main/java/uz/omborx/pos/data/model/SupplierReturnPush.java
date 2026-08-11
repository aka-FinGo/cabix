package uz.FonRo.pos.data.model;

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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import uz.FonRo.pos.ui.docs.SupplierReturnCompensation;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 L2\u00020\u0001:\u0002KLB_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010Bo\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0014J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010#J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003Jh\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001¢\u0006\u0002\u0010<J\u0014\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010@\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010A\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0001b\u0002\bJ¢\u0006\u0002\bIR*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R.\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b( ¢\u0006\u0010\n\u0002\u0010\u001f\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u001eR.\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(%¢\u0006\u0010\n\u0002\u0010$\u0012\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010#R*\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b()¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010(R*\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(,¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0016\u001a\u0004\b+\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0018R*\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(0¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0016\u001a\u0004\b/\u0010\u0018R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b1\u00102Ê\u0001\u0002\bNÊ\u0001\f\bO\u0012\b\bP\u0012\u0004\b\u0003\u0010\u0000¨\u0006M"}, d2 = {"Luz/FonRo/pos/data/model/SupplierReturnPush;", "", "clientId", "", "serverId", "", "documentCancel", "", "supplierId", "supplierName", "reason", "compensationType", FirebaseAnalytics.Param.ITEMS, "", "Luz/FonRo/pos/data/model/SupplierReturnPushItem;", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getClientId$annotations", "()V", "getClientId", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "client_id", "getServerId$annotations", "getServerId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "server_id", "getDocumentCancel$annotations", "getDocumentCancel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "document_cancel", "getSupplierId$annotations", "getSupplierId", "()J", "supplier_id", "getSupplierName$annotations", "getSupplierName", "supplier_name", "getReason", "getCompensationType$annotations", "getCompensationType", "compensation_type", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Luz/FonRo/pos/data/model/SupplierReturnPush;", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class SupplierReturnPush {
    private final String clientId;
    private final String compensationType;
    private final Integer documentCancel;
    private final List<SupplierReturnPushItem> items;
    private final String reason;
    private final Long serverId;
    private final long supplierId;
    private final String supplierName;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.SupplierReturnPush$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = SupplierReturnPush._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(SupplierReturnPushItem$$serializer.INSTANCE);
    }

    public static /* synthetic */ SupplierReturnPush copy$default(SupplierReturnPush supplierReturnPush, String str, Long l, Integer num, long j, String str2, String str3, String str4, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = supplierReturnPush.clientId;
        }
        if ((i & 2) != 0) {
            l = supplierReturnPush.serverId;
        }
        if ((i & 4) != 0) {
            num = supplierReturnPush.documentCancel;
        }
        if ((i & 8) != 0) {
            j = supplierReturnPush.supplierId;
        }
        if ((i & 16) != 0) {
            str2 = supplierReturnPush.supplierName;
        }
        if ((i & 32) != 0) {
            str3 = supplierReturnPush.reason;
        }
        if ((i & 64) != 0) {
            str4 = supplierReturnPush.compensationType;
        }
        if ((i & 128) != 0) {
            list = supplierReturnPush.items;
        }
        long j2 = j;
        Integer num2 = num;
        return supplierReturnPush.copy(str, l, num2, j2, str2, str3, str4, list);
    }

    @SerialName("client_id")
    public static /* synthetic */ void getClientId$annotations() {
    }

    @SerialName("compensation_type")
    public static /* synthetic */ void getCompensationType$annotations() {
    }

    @SerialName("document_cancel")
    public static /* synthetic */ void getDocumentCancel$annotations() {
    }

    @SerialName("server_id")
    public static /* synthetic */ void getServerId$annotations() {
    }

    @SerialName("supplier_id")
    public static /* synthetic */ void getSupplierId$annotations() {
    }

    @SerialName("supplier_name")
    public static /* synthetic */ void getSupplierName$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getServerId() {
        return this.serverId;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getDocumentCancel() {
        return this.documentCancel;
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

    public final List<SupplierReturnPushItem> component8() {
        return this.items;
    }

    public final SupplierReturnPush copy(String clientId, Long serverId, Integer documentCancel, long supplierId, String supplierName, String reason, String compensationType, List<SupplierReturnPushItem> items) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(supplierName, "supplierName");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(compensationType, "compensationType");
        Intrinsics.checkNotNullParameter(items, "items");
        return new SupplierReturnPush(clientId, serverId, documentCancel, supplierId, supplierName, reason, compensationType, items);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SupplierReturnPush)) {
            return false;
        }
        SupplierReturnPush supplierReturnPush = (SupplierReturnPush) other;
        return Intrinsics.areEqual(this.clientId, supplierReturnPush.clientId) && Intrinsics.areEqual(this.serverId, supplierReturnPush.serverId) && Intrinsics.areEqual(this.documentCancel, supplierReturnPush.documentCancel) && this.supplierId == supplierReturnPush.supplierId && Intrinsics.areEqual(this.supplierName, supplierReturnPush.supplierName) && Intrinsics.areEqual(this.reason, supplierReturnPush.reason) && Intrinsics.areEqual(this.compensationType, supplierReturnPush.compensationType) && Intrinsics.areEqual(this.items, supplierReturnPush.items);
    }

    public int hashCode() {
        int hashCode = this.clientId.hashCode() * 31;
        Long l = this.serverId;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        Integer num = this.documentCancel;
        return ((((((((((hashCode2 + (num != null ? num.hashCode() : 0)) * 31) + Long.hashCode(this.supplierId)) * 31) + this.supplierName.hashCode()) * 31) + this.reason.hashCode()) * 31) + this.compensationType.hashCode()) * 31) + this.items.hashCode();
    }

    public String toString() {
        return "SupplierReturnPush(clientId=" + this.clientId + ", serverId=" + this.serverId + ", documentCancel=" + this.documentCancel + ", supplierId=" + this.supplierId + ", supplierName=" + this.supplierName + ", reason=" + this.reason + ", compensationType=" + this.compensationType + ", items=" + this.items + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/SupplierReturnPush$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/SupplierReturnPush;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SupplierReturnPush> serializer() {
            return SupplierReturnPush$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SupplierReturnPush(int i, String str, Long l, Integer num, long j, String str2, String str3, String str4, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, SupplierReturnPush$$serializer.INSTANCE.getDescriptor());
        }
        this.clientId = str;
        if ((i & 2) == 0) {
            this.serverId = null;
        } else {
            this.serverId = l;
        }
        if ((i & 4) == 0) {
            this.documentCancel = null;
        } else {
            this.documentCancel = num;
        }
        if ((i & 8) == 0) {
            this.supplierId = 0L;
        } else {
            this.supplierId = j;
        }
        if ((i & 16) == 0) {
            this.supplierName = "";
        } else {
            this.supplierName = str2;
        }
        if ((i & 32) == 0) {
            this.reason = "";
        } else {
            this.reason = str3;
        }
        if ((i & 64) == 0) {
            this.compensationType = SupplierReturnCompensation.REDUCE_DEBT;
        } else {
            this.compensationType = str4;
        }
        if ((i & 128) == 0) {
            this.items = CollectionsKt.emptyList();
        } else {
            this.items = list;
        }
    }

    public SupplierReturnPush(String clientId, Long l, Integer num, long j, String supplierName, String reason, String compensationType, List<SupplierReturnPushItem> items) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(supplierName, "supplierName");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(compensationType, "compensationType");
        Intrinsics.checkNotNullParameter(items, "items");
        this.clientId = clientId;
        this.serverId = l;
        this.documentCancel = num;
        this.supplierId = j;
        this.supplierName = supplierName;
        this.reason = reason;
        this.compensationType = compensationType;
        this.items = items;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(SupplierReturnPush self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.clientId);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.serverId != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.serverId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.documentCancel != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.documentCancel);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.supplierId != 0) {
            output.encodeLongElement(serialDesc, 3, self.supplierId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.supplierName, "")) {
            output.encodeStringElement(serialDesc, 4, self.supplierName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.reason, "")) {
            output.encodeStringElement(serialDesc, 5, self.reason);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.compensationType, SupplierReturnCompensation.REDUCE_DEBT)) {
            output.encodeStringElement(serialDesc, 6, self.compensationType);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 7) && Intrinsics.areEqual(self.items, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 7, lazyArr[7].getValue(), self.items);
    }

    public /* synthetic */ SupplierReturnPush(String str, Long l, Integer num, long j, String str2, String str3, String str4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : num, (i & 8) != 0 ? 0L : j, (i & 16) != 0 ? "" : str2, (i & 32) != 0 ? "" : str3, (i & 64) != 0 ? SupplierReturnCompensation.REDUCE_DEBT : str4, (i & 128) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final Long getServerId() {
        return this.serverId;
    }

    public final Integer getDocumentCancel() {
        return this.documentCancel;
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

    public final String getCompensationType() {
        return this.compensationType;
    }

    public final List<SupplierReturnPushItem> getItems() {
        return this.items;
    }
}
