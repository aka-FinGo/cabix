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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 ?2\u00020\u0001:\u0002>?BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rB[\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JQ\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0014\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00103\u001a\u00020\u000fHÖ\u0081\u0004J\n\u00104\u001a\u00020\u0005HÖ\u0081\u0004J)\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001b\u0002\b=¢\u0006\u0002\b<R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\t0\u0019¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R,\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR*\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(#¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u001cR,\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(&¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010\u001cR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(Ê\u0001\u0002\b\u0017Ê\u0001\f\bA\u0012\b\bB\u0012\u0004\b\u0003\u0010\u0000¨\u0006@"}, d2 = {"Luz/FonRo/pos/data/model/AuditDoc;", "", "id", "", "clientId", "", "note", "createdAt", "createdByName", FirebaseAnalytics.Param.ITEMS, "", "Luz/FonRo/pos/data/model/AuditItem;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getClientId$annotations", "getClientId", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "client_id", "getNote", "getCreatedAt$annotations", "getCreatedAt", "created_at", "getCreatedByName$annotations", "getCreatedByName", "created_by_name", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class AuditDoc {
    private final String clientId;
    private final String createdAt;
    private final String createdByName;
    private final long id;
    private final List<AuditItem> items;
    private final String note;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.AuditDoc$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AuditDoc._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public AuditDoc() {
        this(0L, (String) null, (String) null, (String) null, (String) null, (List) null, 63, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(AuditItem$$serializer.INSTANCE);
    }

    public static /* synthetic */ AuditDoc copy$default(AuditDoc auditDoc, long j, String str, String str2, String str3, String str4, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = auditDoc.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = auditDoc.clientId;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = auditDoc.note;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = auditDoc.createdAt;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = auditDoc.createdByName;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            list = auditDoc.items;
        }
        return auditDoc.copy(j2, str5, str6, str7, str8, list);
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

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNote() {
        return this.note;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCreatedByName() {
        return this.createdByName;
    }

    public final List<AuditItem> component6() {
        return this.items;
    }

    public final AuditDoc copy(long id, String clientId, String note, String createdAt, String createdByName, List<AuditItem> items) {
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(items, "items");
        return new AuditDoc(id, clientId, note, createdAt, createdByName, items);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuditDoc)) {
            return false;
        }
        AuditDoc auditDoc = (AuditDoc) other;
        return this.id == auditDoc.id && Intrinsics.areEqual(this.clientId, auditDoc.clientId) && Intrinsics.areEqual(this.note, auditDoc.note) && Intrinsics.areEqual(this.createdAt, auditDoc.createdAt) && Intrinsics.areEqual(this.createdByName, auditDoc.createdByName) && Intrinsics.areEqual(this.items, auditDoc.items);
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.id) * 31;
        String str = this.clientId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.note;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.createdAt.hashCode()) * 31;
        String str3 = this.createdByName;
        return ((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.items.hashCode();
    }

    public String toString() {
        return "AuditDoc(id=" + this.id + ", clientId=" + this.clientId + ", note=" + this.note + ", createdAt=" + this.createdAt + ", createdByName=" + this.createdByName + ", items=" + this.items + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/AuditDoc$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/AuditDoc;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AuditDoc> serializer() {
            return AuditDoc$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AuditDoc(int i, long j, String str, String str2, String str3, String str4, List list, SerializationConstructorMarker serializationConstructorMarker) {
        this.id = (i & 1) == 0 ? 0L : j;
        if ((i & 2) == 0) {
            this.clientId = null;
        } else {
            this.clientId = str;
        }
        if ((i & 4) == 0) {
            this.note = null;
        } else {
            this.note = str2;
        }
        if ((i & 8) == 0) {
            this.createdAt = "";
        } else {
            this.createdAt = str3;
        }
        if ((i & 16) == 0) {
            this.createdByName = null;
        } else {
            this.createdByName = str4;
        }
        if ((i & 32) == 0) {
            this.items = CollectionsKt.emptyList();
        } else {
            this.items = list;
        }
    }

    public AuditDoc(long j, String str, String str2, String createdAt, String str3, List<AuditItem> items) {
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(items, "items");
        this.id = j;
        this.clientId = str;
        this.note = str2;
        this.createdAt = createdAt;
        this.createdByName = str3;
        this.items = items;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(AuditDoc self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.clientId != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.clientId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.note != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.note);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.createdAt, "")) {
            output.encodeStringElement(serialDesc, 3, self.createdAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.createdByName != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.createdByName);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && Intrinsics.areEqual(self.items, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.items);
    }

    public final long getId() {
        return this.id;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getNote() {
        return this.note;
    }

    public /* synthetic */ AuditDoc(long j, String str, String str2, String str3, String str4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? "" : str3, (i & 16) == 0 ? str4 : null, (i & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getCreatedByName() {
        return this.createdByName;
    }

    public final List<AuditItem> getItems() {
        return this.items;
    }
}
