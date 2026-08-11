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
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonObject;
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Money.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 N2\u00020\u0001:\u0002MNBa\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eBg\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\t\u00106\u001a\u00020\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\fHÆ\u0003Jc\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0014\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010B\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010C\u001a\u00020\u0005HÖ\u0081\u0004J)\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0001b\u0002\bL¢\u0006\u0002\bKR*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\t0\u001a¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR,\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b \u0012\b\b!\u0012\u0004\b\b(\"¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u001cR8\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b \u0012\b\b!\u0012\u0004\b\b(%r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\t0\u001a¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017R,\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b \u0012\b\b!\u0012\u0004\b\b((¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u001cR*\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b \u0012\b\b!\u0012\u0004\b\b(+¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0015\u001a\u0004\b*\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010.\u001a\u0004\u0018\u00010/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0013\u00102\u001a\u0004\u0018\u00010/8F¢\u0006\u0006\u001a\u0004\b3\u00101R\u0013\u00104\u001a\u0004\u0018\u00010/8F¢\u0006\u0006\u001a\u0004\b5\u00101Ê\u0001\u0002\b\u0018Ê\u0001\f\bP\u0012\b\bQ\u0012\u0004\b\u0003\u0010\u0000¨\u0006O"}, d2 = {"Luz/FonRo/pos/data/model/ActivityEntry;", "", "id", "", "action", "", "description", "entityType", "entityId", "userName", "createdAt", "payload", "Lkotlinx/serialization/json/JsonElement;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getAction", "()Ljava/lang/String;", "getDescription", "getEntityType$annotations", "getEntityType", "Lkotlinx/serialization/SerialName;", "value", "entity_type", "getEntityId$annotations", "getEntityId", "entity_id", "getUserName$annotations", "getUserName", "user_name", "getCreatedAt$annotations", "getCreatedAt", "created_at", "getPayload", "()Lkotlinx/serialization/json/JsonElement;", "payloadObject", "Lkotlinx/serialization/json/JsonObject;", "getPayloadObject", "()Lkotlinx/serialization/json/JsonObject;", "before", "getBefore", "after", "getAfter", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ActivityEntry {
    private final String action;
    private final String createdAt;
    private final String description;
    private final long entityId;
    private final String entityType;
    private final long id;
    private final JsonElement payload;
    private final String userName;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public ActivityEntry() {
        this(0L, (String) null, (String) null, (String) null, 0L, (String) null, (String) null, (JsonElement) null, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ActivityEntry copy$default(ActivityEntry activityEntry, long j, String str, String str2, String str3, long j2, String str4, String str5, JsonElement jsonElement, int i, Object obj) {
        if ((i & 1) != 0) {
            j = activityEntry.id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            str = activityEntry.action;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str2 = activityEntry.description;
        }
        return activityEntry.copy(j3, str6, str2, (i & 8) != 0 ? activityEntry.entityType : str3, (i & 16) != 0 ? activityEntry.entityId : j2, (i & 32) != 0 ? activityEntry.userName : str4, (i & 64) != 0 ? activityEntry.createdAt : str5, (i & 128) != 0 ? activityEntry.payload : jsonElement);
    }

    @SerialName("created_at")
    public static /* synthetic */ void getCreatedAt$annotations() {
    }

    @SerialName("entity_id")
    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getEntityId$annotations() {
    }

    @SerialName("entity_type")
    public static /* synthetic */ void getEntityType$annotations() {
    }

    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("user_name")
    public static /* synthetic */ void getUserName$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4, reason: from getter */
    public final String getEntityType() {
        return this.entityType;
    }

    /* renamed from: component5, reason: from getter */
    public final long getEntityId() {
        return this.entityId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* renamed from: component7, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component8, reason: from getter */
    public final JsonElement getPayload() {
        return this.payload;
    }

    public final ActivityEntry copy(long id, String action, String description, String entityType, long entityId, String userName, String createdAt, JsonElement payload) {
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        return new ActivityEntry(id, action, description, entityType, entityId, userName, createdAt, payload);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityEntry)) {
            return false;
        }
        ActivityEntry activityEntry = (ActivityEntry) other;
        return this.id == activityEntry.id && Intrinsics.areEqual(this.action, activityEntry.action) && Intrinsics.areEqual(this.description, activityEntry.description) && Intrinsics.areEqual(this.entityType, activityEntry.entityType) && this.entityId == activityEntry.entityId && Intrinsics.areEqual(this.userName, activityEntry.userName) && Intrinsics.areEqual(this.createdAt, activityEntry.createdAt) && Intrinsics.areEqual(this.payload, activityEntry.payload);
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.id) * 31;
        String str = this.action;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.entityType;
        int hashCode4 = (((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + Long.hashCode(this.entityId)) * 31;
        String str4 = this.userName;
        int hashCode5 = (((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.createdAt.hashCode()) * 31;
        JsonElement jsonElement = this.payload;
        return hashCode5 + (jsonElement != null ? jsonElement.hashCode() : 0);
    }

    public String toString() {
        return "ActivityEntry(id=" + this.id + ", action=" + this.action + ", description=" + this.description + ", entityType=" + this.entityType + ", entityId=" + this.entityId + ", userName=" + this.userName + ", createdAt=" + this.createdAt + ", payload=" + this.payload + ")";
    }

    /* compiled from: Money.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/ActivityEntry$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/ActivityEntry;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ActivityEntry> serializer() {
            return ActivityEntry$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ActivityEntry(int i, long j, String str, String str2, String str3, long j2, String str4, String str5, JsonElement jsonElement, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.id = 0L;
        } else {
            this.id = j;
        }
        if ((i & 2) == 0) {
            this.action = null;
        } else {
            this.action = str;
        }
        if ((i & 4) == 0) {
            this.description = null;
        } else {
            this.description = str2;
        }
        if ((i & 8) == 0) {
            this.entityType = null;
        } else {
            this.entityType = str3;
        }
        if ((i & 16) == 0) {
            this.entityId = 0L;
        } else {
            this.entityId = j2;
        }
        if ((i & 32) == 0) {
            this.userName = null;
        } else {
            this.userName = str4;
        }
        if ((i & 64) == 0) {
            this.createdAt = "";
        } else {
            this.createdAt = str5;
        }
        if ((i & 128) == 0) {
            this.payload = null;
        } else {
            this.payload = jsonElement;
        }
    }

    public ActivityEntry(long j, String str, String str2, String str3, long j2, String str4, String createdAt, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        this.id = j;
        this.action = str;
        this.description = str2;
        this.entityType = str3;
        this.entityId = j2;
        this.userName = str4;
        this.createdAt = createdAt;
        this.payload = jsonElement;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(ActivityEntry self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.action != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.action);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.description != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.description);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.entityType != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.entityType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.entityId != 0) {
            output.encodeSerializableElement(serialDesc, 4, LenientLong.INSTANCE, Long.valueOf(self.entityId));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.userName != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.userName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.createdAt, "")) {
            output.encodeStringElement(serialDesc, 6, self.createdAt);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.payload == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 7, JsonElementSerializer.INSTANCE, self.payload);
    }

    public final long getId() {
        return this.id;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getEntityType() {
        return this.entityType;
    }

    public final long getEntityId() {
        return this.entityId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public /* synthetic */ ActivityEntry(long j, String str, String str2, String str3, long j2, String str4, String str5, JsonElement jsonElement, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? 0L : j2, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? "" : str5, (i & 128) != 0 ? null : jsonElement);
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final JsonElement getPayload() {
        return this.payload;
    }

    private final JsonObject getPayloadObject() {
        JsonElement jsonElement = this.payload;
        if (jsonElement instanceof JsonObject) {
            return (JsonObject) jsonElement;
        }
        return null;
    }

    public final JsonObject getBefore() {
        JsonObject payloadObject = getPayloadObject();
        JsonElement jsonElement = payloadObject != null ? (JsonElement) payloadObject.get("before") : null;
        if (jsonElement instanceof JsonObject) {
            return (JsonObject) jsonElement;
        }
        return null;
    }

    public final JsonObject getAfter() {
        JsonObject payloadObject = getPayloadObject();
        JsonElement jsonElement = payloadObject != null ? (JsonElement) payloadObject.get("after") : null;
        if (jsonElement instanceof JsonObject) {
            return (JsonObject) jsonElement;
        }
        return null;
    }
}
