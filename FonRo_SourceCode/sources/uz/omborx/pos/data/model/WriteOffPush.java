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

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 ?2\u00020\u0001:\u0002>?BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eB]\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010!J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JT\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001¢\u0006\u0002\u0010/J\u0014\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00103\u001a\u00020\u0007HÖ\u0081\u0004J\n\u00104\u001a\u00020\u0003HÖ\u0081\u0004J)\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001b\u0002\b=¢\u0006\u0002\b<R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R.\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001e¢\u0006\u0010\n\u0002\u0010\u001d\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u001cR.\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(#¢\u0006\u0010\n\u0002\u0010\"\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'Ê\u0001\u0002\bAÊ\u0001\f\bB\u0012\b\bC\u0012\u0004\b\u0003\u0010\u0000¨\u0006@"}, d2 = {"Luz/FonRo/pos/data/model/WriteOffPush;", "", "clientId", "", "serverId", "", "documentCancel", "", "reason", "note", FirebaseAnalytics.Param.ITEMS, "", "Luz/FonRo/pos/data/model/WriteOffPushItem;", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getClientId$annotations", "()V", "getClientId", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "client_id", "getServerId$annotations", "getServerId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "server_id", "getDocumentCancel$annotations", "getDocumentCancel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "document_cancel", "getReason", "getNote", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Luz/FonRo/pos/data/model/WriteOffPush;", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class WriteOffPush {
    private final String clientId;
    private final Integer documentCancel;
    private final List<WriteOffPushItem> items;
    private final String note;
    private final String reason;
    private final Long serverId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.WriteOffPush$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = WriteOffPush._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(WriteOffPushItem$$serializer.INSTANCE);
    }

    public static /* synthetic */ WriteOffPush copy$default(WriteOffPush writeOffPush, String str, Long l, Integer num, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = writeOffPush.clientId;
        }
        if ((i & 2) != 0) {
            l = writeOffPush.serverId;
        }
        if ((i & 4) != 0) {
            num = writeOffPush.documentCancel;
        }
        if ((i & 8) != 0) {
            str2 = writeOffPush.reason;
        }
        if ((i & 16) != 0) {
            str3 = writeOffPush.note;
        }
        if ((i & 32) != 0) {
            list = writeOffPush.items;
        }
        String str4 = str3;
        List list2 = list;
        return writeOffPush.copy(str, l, num, str2, str4, list2);
    }

    @SerialName("client_id")
    public static /* synthetic */ void getClientId$annotations() {
    }

    @SerialName("document_cancel")
    public static /* synthetic */ void getDocumentCancel$annotations() {
    }

    @SerialName("server_id")
    public static /* synthetic */ void getServerId$annotations() {
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
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: component5, reason: from getter */
    public final String getNote() {
        return this.note;
    }

    public final List<WriteOffPushItem> component6() {
        return this.items;
    }

    public final WriteOffPush copy(String clientId, Long serverId, Integer documentCancel, String reason, String note, List<WriteOffPushItem> items) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(items, "items");
        return new WriteOffPush(clientId, serverId, documentCancel, reason, note, items);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WriteOffPush)) {
            return false;
        }
        WriteOffPush writeOffPush = (WriteOffPush) other;
        return Intrinsics.areEqual(this.clientId, writeOffPush.clientId) && Intrinsics.areEqual(this.serverId, writeOffPush.serverId) && Intrinsics.areEqual(this.documentCancel, writeOffPush.documentCancel) && Intrinsics.areEqual(this.reason, writeOffPush.reason) && Intrinsics.areEqual(this.note, writeOffPush.note) && Intrinsics.areEqual(this.items, writeOffPush.items);
    }

    public int hashCode() {
        int hashCode = this.clientId.hashCode() * 31;
        Long l = this.serverId;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        Integer num = this.documentCancel;
        return ((((((hashCode2 + (num != null ? num.hashCode() : 0)) * 31) + this.reason.hashCode()) * 31) + this.note.hashCode()) * 31) + this.items.hashCode();
    }

    public String toString() {
        return "WriteOffPush(clientId=" + this.clientId + ", serverId=" + this.serverId + ", documentCancel=" + this.documentCancel + ", reason=" + this.reason + ", note=" + this.note + ", items=" + this.items + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/WriteOffPush$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/WriteOffPush;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<WriteOffPush> serializer() {
            return WriteOffPush$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ WriteOffPush(int i, String str, Long l, Integer num, String str2, String str3, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, WriteOffPush$$serializer.INSTANCE.getDescriptor());
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
            this.reason = WriteOffReason.SPOILED;
        } else {
            this.reason = str2;
        }
        if ((i & 16) == 0) {
            this.note = "";
        } else {
            this.note = str3;
        }
        if ((i & 32) == 0) {
            this.items = CollectionsKt.emptyList();
        } else {
            this.items = list;
        }
    }

    public WriteOffPush(String clientId, Long l, Integer num, String reason, String note, List<WriteOffPushItem> items) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(items, "items");
        this.clientId = clientId;
        this.serverId = l;
        this.documentCancel = num;
        this.reason = reason;
        this.note = note;
        this.items = items;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(WriteOffPush self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.clientId);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.serverId != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.serverId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.documentCancel != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.documentCancel);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.reason, WriteOffReason.SPOILED)) {
            output.encodeStringElement(serialDesc, 3, self.reason);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.note, "")) {
            output.encodeStringElement(serialDesc, 4, self.note);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && Intrinsics.areEqual(self.items, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.items);
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

    public /* synthetic */ WriteOffPush(String str, Long l, Integer num, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : num, (i & 8) != 0 ? WriteOffReason.SPOILED : str2, (i & 16) != 0 ? "" : str3, (i & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getNote() {
        return this.note;
    }

    public final List<WriteOffPushItem> getItems() {
        return this.items;
    }
}
