package uz.FonRo.pos.data.model;

import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
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
import uz.FonRo.pos.data.net.LenientBool;
import uz.FonRo.pos.data.net.LenientLong;
import uz.FonRo.pos.data.net.LenientString;
import uz.FonRo.pos.data.net.PermissionMapSerializer;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 E2\u00020\u0001:\u0002DEB[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fBi\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0013J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\nHÆ\u0003J\u0015\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J]\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\fHÆ\u0001J\u0014\u00107\u001a\u00020\n2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00109\u001a\u00020\rHÖ\u0081\u0004J\n\u0010:\u001a\u00020\u0005HÖ\u0081\u0004J)\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0001b\u0002\bC¢\u0006\u0002\bBR*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\t0\u001a¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R*\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( ¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR8\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(%r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\t0&¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u001dR8\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004r\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b()r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\t0*¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0015\u001a\u0004\b\t\u0010(R6\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\t0.¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0015\u001a\u0004\b,\u0010-Ê\u0001\u0002\b\u0018Ê\u0001\f\bG\u0012\b\bH\u0012\u0004\b\u0003\u0010\u0000¨\u0006F"}, d2 = {"Luz/FonRo/pos/data/model/Worker;", "", "id", "", "fullName", "", HintConstants.AUTOFILL_HINT_PHONE, "role", "accessKey", "isActive", "", "permissions", "", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getFullName$annotations", "getFullName", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "full_name", "getPhone", "getRole", "getAccessKey$annotations", "getAccessKey", "access_key", "Luz/FonRo/pos/data/net/LenientString;", "isActive$annotations", "()Z", "is_active", "Luz/FonRo/pos/data/net/LenientBool;", "getPermissions$annotations", "getPermissions", "()Ljava/util/Map;", "Luz/FonRo/pos/data/net/PermissionMapSerializer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class Worker {
    private final String accessKey;
    private final String fullName;
    private final long id;
    private final boolean isActive;
    private final Map<String, Integer> permissions;
    private final String phone;
    private final String role;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public Worker() {
        this(0L, (String) null, (String) null, (String) null, (String) null, false, (Map) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Worker copy$default(Worker worker, long j, String str, String str2, String str3, String str4, boolean z, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            j = worker.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = worker.fullName;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = worker.phone;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = worker.role;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = worker.accessKey;
        }
        return worker.copy(j2, str5, str6, str7, str4, (i & 32) != 0 ? worker.isActive : z, (i & 64) != 0 ? worker.permissions : map);
    }

    @SerialName("access_key")
    @Serializable(with = LenientString.class)
    public static /* synthetic */ void getAccessKey$annotations() {
    }

    @SerialName("full_name")
    public static /* synthetic */ void getFullName$annotations() {
    }

    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getId$annotations() {
    }

    @Serializable(with = PermissionMapSerializer.class)
    public static /* synthetic */ void getPermissions$annotations() {
    }

    @SerialName("is_active")
    @Serializable(with = LenientBool.class)
    public static /* synthetic */ void isActive$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFullName() {
        return this.fullName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAccessKey() {
        return this.accessKey;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    public final Map<String, Integer> component7() {
        return this.permissions;
    }

    public final Worker copy(long id, String fullName, String phone, String role, String accessKey, boolean isActive, Map<String, Integer> permissions) {
        Intrinsics.checkNotNullParameter(fullName, "fullName");
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(accessKey, "accessKey");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        return new Worker(id, fullName, phone, role, accessKey, isActive, permissions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Worker)) {
            return false;
        }
        Worker worker = (Worker) other;
        return this.id == worker.id && Intrinsics.areEqual(this.fullName, worker.fullName) && Intrinsics.areEqual(this.phone, worker.phone) && Intrinsics.areEqual(this.role, worker.role) && Intrinsics.areEqual(this.accessKey, worker.accessKey) && this.isActive == worker.isActive && Intrinsics.areEqual(this.permissions, worker.permissions);
    }

    public int hashCode() {
        int hashCode = ((Long.hashCode(this.id) * 31) + this.fullName.hashCode()) * 31;
        String str = this.phone;
        return ((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.role.hashCode()) * 31) + this.accessKey.hashCode()) * 31) + Boolean.hashCode(this.isActive)) * 31) + this.permissions.hashCode();
    }

    public String toString() {
        return "Worker(id=" + this.id + ", fullName=" + this.fullName + ", phone=" + this.phone + ", role=" + this.role + ", accessKey=" + this.accessKey + ", isActive=" + this.isActive + ", permissions=" + this.permissions + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/Worker$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/Worker;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Worker> serializer() {
            return Worker$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Worker(int i, long j, String str, String str2, String str3, String str4, boolean z, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        this.id = (i & 1) == 0 ? 0L : j;
        if ((i & 2) == 0) {
            this.fullName = "";
        } else {
            this.fullName = str;
        }
        if ((i & 4) == 0) {
            this.phone = null;
        } else {
            this.phone = str2;
        }
        if ((i & 8) == 0) {
            this.role = "cashier";
        } else {
            this.role = str3;
        }
        if ((i & 16) == 0) {
            this.accessKey = "";
        } else {
            this.accessKey = str4;
        }
        if ((i & 32) == 0) {
            this.isActive = true;
        } else {
            this.isActive = z;
        }
        if ((i & 64) == 0) {
            this.permissions = MapsKt.emptyMap();
        } else {
            this.permissions = map;
        }
    }

    public Worker(long j, String fullName, String str, String role, String accessKey, boolean z, Map<String, Integer> permissions) {
        Intrinsics.checkNotNullParameter(fullName, "fullName");
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(accessKey, "accessKey");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        this.id = j;
        this.fullName = fullName;
        this.phone = str;
        this.role = role;
        this.accessKey = accessKey;
        this.isActive = z;
        this.permissions = permissions;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(Worker self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.fullName, "")) {
            output.encodeStringElement(serialDesc, 1, self.fullName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.phone != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.phone);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.role, "cashier")) {
            output.encodeStringElement(serialDesc, 3, self.role);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.accessKey, "")) {
            output.encodeSerializableElement(serialDesc, 4, LenientString.INSTANCE, self.accessKey);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !self.isActive) {
            output.encodeSerializableElement(serialDesc, 5, LenientBool.INSTANCE, Boolean.valueOf(self.isActive));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && Intrinsics.areEqual(self.permissions, MapsKt.emptyMap())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 6, PermissionMapSerializer.INSTANCE, self.permissions);
    }

    public /* synthetic */ Worker(long j, String str, String str2, String str3, String str4, boolean z, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? "cashier" : str3, (i & 16) == 0 ? str4 : "", (i & 32) != 0 ? true : z, (i & 64) != 0 ? MapsKt.emptyMap() : map);
    }

    public final long getId() {
        return this.id;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getRole() {
        return this.role;
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final Map<String, Integer> getPermissions() {
        return this.permissions;
    }
}
