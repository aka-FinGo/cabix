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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Auth.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0002=>BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bBW\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!JV\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010.J\u0014\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00102\u001a\u00020\rHÖ\u0081\u0004J\n\u00103\u001a\u00020\u0003HÖ\u0081\u0004J)\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0001b\u0002\b<¢\u0006\u0002\b;R,\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R,\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014R,\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001d¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R.\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(#¢\u0006\u0010\n\u0002\u0010\"\u0012\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010!R.\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004r\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(&¢\u0006\u0010\n\u0002\u0010\"\u0012\u0004\b$\u0010\u0012\u001a\u0004\b%\u0010!Ê\u0001\u0002\b@Ê\u0001\f\bA\u0012\b\bB\u0012\u0004\b\u0003\u0010\u0002¨\u0006?"}, d2 = {"Luz/FonRo/pos/data/model/WorkerKeyBody;", "", "accessKey", "", "deviceId", "deviceName", "action", "workerId", "", "deviceRowId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAccessKey$annotations", "()V", "getAccessKey", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "access_key", "getDeviceId$annotations", "getDeviceId", "device_id", "getDeviceName$annotations", "getDeviceName", "device_name", "getAction", "getWorkerId$annotations", "getWorkerId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "worker_id", "getDeviceRowId$annotations", "getDeviceRowId", "device_row_id", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Luz/FonRo/pos/data/model/WorkerKeyBody;", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class WorkerKeyBody {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String accessKey;
    private final String action;
    private final String deviceId;
    private final String deviceName;
    private final Long deviceRowId;
    private final Long workerId;

    public WorkerKeyBody() {
        this((String) null, (String) null, (String) null, (String) null, (Long) null, (Long) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WorkerKeyBody copy$default(WorkerKeyBody workerKeyBody, String str, String str2, String str3, String str4, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = workerKeyBody.accessKey;
        }
        if ((i & 2) != 0) {
            str2 = workerKeyBody.deviceId;
        }
        if ((i & 4) != 0) {
            str3 = workerKeyBody.deviceName;
        }
        if ((i & 8) != 0) {
            str4 = workerKeyBody.action;
        }
        if ((i & 16) != 0) {
            l = workerKeyBody.workerId;
        }
        if ((i & 32) != 0) {
            l2 = workerKeyBody.deviceRowId;
        }
        Long l3 = l;
        Long l4 = l2;
        return workerKeyBody.copy(str, str2, str3, str4, l3, l4);
    }

    @SerialName("access_key")
    public static /* synthetic */ void getAccessKey$annotations() {
    }

    @SerialName("device_id")
    public static /* synthetic */ void getDeviceId$annotations() {
    }

    @SerialName("device_name")
    public static /* synthetic */ void getDeviceName$annotations() {
    }

    @SerialName("device_row_id")
    public static /* synthetic */ void getDeviceRowId$annotations() {
    }

    @SerialName("worker_id")
    public static /* synthetic */ void getWorkerId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getAccessKey() {
        return this.accessKey;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: component5, reason: from getter */
    public final Long getWorkerId() {
        return this.workerId;
    }

    /* renamed from: component6, reason: from getter */
    public final Long getDeviceRowId() {
        return this.deviceRowId;
    }

    public final WorkerKeyBody copy(String accessKey, String deviceId, String deviceName, String action, Long workerId, Long deviceRowId) {
        return new WorkerKeyBody(accessKey, deviceId, deviceName, action, workerId, deviceRowId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkerKeyBody)) {
            return false;
        }
        WorkerKeyBody workerKeyBody = (WorkerKeyBody) other;
        return Intrinsics.areEqual(this.accessKey, workerKeyBody.accessKey) && Intrinsics.areEqual(this.deviceId, workerKeyBody.deviceId) && Intrinsics.areEqual(this.deviceName, workerKeyBody.deviceName) && Intrinsics.areEqual(this.action, workerKeyBody.action) && Intrinsics.areEqual(this.workerId, workerKeyBody.workerId) && Intrinsics.areEqual(this.deviceRowId, workerKeyBody.deviceRowId);
    }

    public int hashCode() {
        String str = this.accessKey;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deviceId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.deviceName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.action;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l = this.workerId;
        int hashCode5 = (hashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.deviceRowId;
        return hashCode5 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        return "WorkerKeyBody(accessKey=" + this.accessKey + ", deviceId=" + this.deviceId + ", deviceName=" + this.deviceName + ", action=" + this.action + ", workerId=" + this.workerId + ", deviceRowId=" + this.deviceRowId + ")";
    }

    /* compiled from: Auth.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/WorkerKeyBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/WorkerKeyBody;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<WorkerKeyBody> serializer() {
            return WorkerKeyBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ WorkerKeyBody(int i, String str, String str2, String str3, String str4, Long l, Long l2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.accessKey = null;
        } else {
            this.accessKey = str;
        }
        if ((i & 2) == 0) {
            this.deviceId = null;
        } else {
            this.deviceId = str2;
        }
        if ((i & 4) == 0) {
            this.deviceName = null;
        } else {
            this.deviceName = str3;
        }
        if ((i & 8) == 0) {
            this.action = null;
        } else {
            this.action = str4;
        }
        if ((i & 16) == 0) {
            this.workerId = null;
        } else {
            this.workerId = l;
        }
        if ((i & 32) == 0) {
            this.deviceRowId = null;
        } else {
            this.deviceRowId = l2;
        }
    }

    public WorkerKeyBody(String str, String str2, String str3, String str4, Long l, Long l2) {
        this.accessKey = str;
        this.deviceId = str2;
        this.deviceName = str3;
        this.action = str4;
        this.workerId = l;
        this.deviceRowId = l2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(WorkerKeyBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.accessKey != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.accessKey);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.deviceId != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.deviceId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.deviceName != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.deviceName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.action != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.action);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.workerId != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, LongSerializer.INSTANCE, self.workerId);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.deviceRowId == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 5, LongSerializer.INSTANCE, self.deviceRowId);
    }

    public /* synthetic */ WorkerKeyBody(String str, String str2, String str3, String str4, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : l2);
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getAction() {
        return this.action;
    }

    public final Long getWorkerId() {
        return this.workerId;
    }

    public final Long getDeviceRowId() {
        return this.deviceRowId;
    }
}
