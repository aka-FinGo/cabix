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
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0002:;B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nBK\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003JA\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010/\u001a\u00020\fHÖ\u0081\u0004J\n\u00100\u001a\u00020\u0005HÖ\u0081\u0004J)\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001b\u0002\b9¢\u0006\u0002\b8R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\t0\u0016¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R*\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019R,\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001f¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0019R,\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\"¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0019R,\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(%¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010\u0019Ê\u0001\u0002\b\u0014Ê\u0001\f\b=\u0012\b\b>\u0012\u0004\b\u0003\u0010\u0002¨\u0006<"}, d2 = {"Luz/FonRo/pos/data/model/WorkerDevice;", "", "id", "", "deviceId", "", "deviceName", "lastSeen", "createdAt", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getDeviceId$annotations", "getDeviceId", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "device_id", "getDeviceName$annotations", "getDeviceName", "device_name", "getLastSeen$annotations", "getLastSeen", "last_seen", "getCreatedAt$annotations", "getCreatedAt", "created_at", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class WorkerDevice {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String createdAt;
    private final String deviceId;
    private final String deviceName;
    private final long id;
    private final String lastSeen;

    public WorkerDevice() {
        this(0L, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WorkerDevice copy$default(WorkerDevice workerDevice, long j, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            j = workerDevice.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = workerDevice.deviceId;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = workerDevice.deviceName;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = workerDevice.lastSeen;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = workerDevice.createdAt;
        }
        return workerDevice.copy(j2, str5, str6, str7, str4);
    }

    @SerialName("created_at")
    public static /* synthetic */ void getCreatedAt$annotations() {
    }

    @SerialName("device_id")
    public static /* synthetic */ void getDeviceId$annotations() {
    }

    @SerialName("device_name")
    public static /* synthetic */ void getDeviceName$annotations() {
    }

    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("last_seen")
    public static /* synthetic */ void getLastSeen$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
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
    public final String getLastSeen() {
        return this.lastSeen;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final WorkerDevice copy(long id, String deviceId, String deviceName, String lastSeen, String createdAt) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        return new WorkerDevice(id, deviceId, deviceName, lastSeen, createdAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkerDevice)) {
            return false;
        }
        WorkerDevice workerDevice = (WorkerDevice) other;
        return this.id == workerDevice.id && Intrinsics.areEqual(this.deviceId, workerDevice.deviceId) && Intrinsics.areEqual(this.deviceName, workerDevice.deviceName) && Intrinsics.areEqual(this.lastSeen, workerDevice.lastSeen) && Intrinsics.areEqual(this.createdAt, workerDevice.createdAt);
    }

    public int hashCode() {
        int hashCode = ((Long.hashCode(this.id) * 31) + this.deviceId.hashCode()) * 31;
        String str = this.deviceName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.lastSeen;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.createdAt;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "WorkerDevice(id=" + this.id + ", deviceId=" + this.deviceId + ", deviceName=" + this.deviceName + ", lastSeen=" + this.lastSeen + ", createdAt=" + this.createdAt + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/WorkerDevice$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/WorkerDevice;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<WorkerDevice> serializer() {
            return WorkerDevice$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ WorkerDevice(int i, long j, String str, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        this.id = (i & 1) == 0 ? 0L : j;
        if ((i & 2) == 0) {
            this.deviceId = "";
        } else {
            this.deviceId = str;
        }
        if ((i & 4) == 0) {
            this.deviceName = null;
        } else {
            this.deviceName = str2;
        }
        if ((i & 8) == 0) {
            this.lastSeen = null;
        } else {
            this.lastSeen = str3;
        }
        if ((i & 16) == 0) {
            this.createdAt = null;
        } else {
            this.createdAt = str4;
        }
    }

    public WorkerDevice(long j, String deviceId, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        this.id = j;
        this.deviceId = deviceId;
        this.deviceName = str;
        this.lastSeen = str2;
        this.createdAt = str3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(WorkerDevice self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.deviceId, "")) {
            output.encodeStringElement(serialDesc, 1, self.deviceId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.deviceName != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.deviceName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.lastSeen != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.lastSeen);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.createdAt == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.createdAt);
    }

    public final long getId() {
        return this.id;
    }

    public /* synthetic */ WorkerDevice(long j, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getLastSeen() {
        return this.lastSeen;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }
}
