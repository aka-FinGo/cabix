package uz.FonRo.pos.data.model;

import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Sync.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0002<=B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eBk\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\u0015\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\tHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010#Jd\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010-J\u0014\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00101\u001a\u00020\u0007HÖ\u0081\u0004J\n\u00102\u001a\u00020\u0003HÖ\u0081\u0004J)\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001b\u0002\b;¢\u0006\u0002\b:R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R*\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u0006\u0010\u001dR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#Ê\u0001\u0002\b?Ê\u0001\f\b@\u0012\b\bA\u0012\u0004\b\u0003\u0010\u0000¨\u0006>"}, d2 = {"Luz/FonRo/pos/data/model/WorkerBody;", "", "fullName", "", HintConstants.AUTOFILL_HINT_PHONE, "role", "isActive", "", "permissions", "", "action", "id", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;Ljava/lang/String;Ljava/lang/Long;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;Ljava/lang/String;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFullName$annotations", "()V", "getFullName", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "full_name", "getPhone", "getRole", "isActive$annotations", "()I", "is_active", "getPermissions", "()Ljava/util/Map;", "getAction", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;Ljava/lang/String;Ljava/lang/Long;)Luz/FonRo/pos/data/model/WorkerBody;", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class WorkerBody {
    private final String action;
    private final String fullName;
    private final Long id;
    private final int isActive;
    private final Map<String, Integer> permissions;
    private final String phone;
    private final String role;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.WorkerBody$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = WorkerBody._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new LinkedHashMapSerializer(StringSerializer.INSTANCE, IntSerializer.INSTANCE);
    }

    public static /* synthetic */ WorkerBody copy$default(WorkerBody workerBody, String str, String str2, String str3, int i, Map map, String str4, Long l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = workerBody.fullName;
        }
        if ((i2 & 2) != 0) {
            str2 = workerBody.phone;
        }
        if ((i2 & 4) != 0) {
            str3 = workerBody.role;
        }
        if ((i2 & 8) != 0) {
            i = workerBody.isActive;
        }
        if ((i2 & 16) != 0) {
            map = workerBody.permissions;
        }
        if ((i2 & 32) != 0) {
            str4 = workerBody.action;
        }
        if ((i2 & 64) != 0) {
            l = workerBody.id;
        }
        String str5 = str4;
        Long l2 = l;
        Map map2 = map;
        String str6 = str3;
        return workerBody.copy(str, str2, str6, i, map2, str5, l2);
    }

    @SerialName("full_name")
    public static /* synthetic */ void getFullName$annotations() {
    }

    @SerialName("is_active")
    public static /* synthetic */ void isActive$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getFullName() {
        return this.fullName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* renamed from: component4, reason: from getter */
    public final int getIsActive() {
        return this.isActive;
    }

    public final Map<String, Integer> component5() {
        return this.permissions;
    }

    /* renamed from: component6, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: component7, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    public final WorkerBody copy(String fullName, String phone, String role, int isActive, Map<String, Integer> permissions, String action, Long id) {
        Intrinsics.checkNotNullParameter(fullName, "fullName");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        return new WorkerBody(fullName, phone, role, isActive, permissions, action, id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkerBody)) {
            return false;
        }
        WorkerBody workerBody = (WorkerBody) other;
        return Intrinsics.areEqual(this.fullName, workerBody.fullName) && Intrinsics.areEqual(this.phone, workerBody.phone) && Intrinsics.areEqual(this.role, workerBody.role) && this.isActive == workerBody.isActive && Intrinsics.areEqual(this.permissions, workerBody.permissions) && Intrinsics.areEqual(this.action, workerBody.action) && Intrinsics.areEqual(this.id, workerBody.id);
    }

    public int hashCode() {
        int hashCode = ((((((((this.fullName.hashCode() * 31) + this.phone.hashCode()) * 31) + this.role.hashCode()) * 31) + Integer.hashCode(this.isActive)) * 31) + this.permissions.hashCode()) * 31;
        String str = this.action;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.id;
        return hashCode2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "WorkerBody(fullName=" + this.fullName + ", phone=" + this.phone + ", role=" + this.role + ", isActive=" + this.isActive + ", permissions=" + this.permissions + ", action=" + this.action + ", id=" + this.id + ")";
    }

    /* compiled from: Sync.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/WorkerBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/WorkerBody;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<WorkerBody> serializer() {
            return WorkerBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ WorkerBody(int i, String str, String str2, String str3, int i2, Map map, String str4, Long l, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, WorkerBody$$serializer.INSTANCE.getDescriptor());
        }
        this.fullName = str;
        if ((i & 2) == 0) {
            this.phone = "";
        } else {
            this.phone = str2;
        }
        if ((i & 4) == 0) {
            this.role = "cashier";
        } else {
            this.role = str3;
        }
        if ((i & 8) == 0) {
            this.isActive = 1;
        } else {
            this.isActive = i2;
        }
        if ((i & 16) == 0) {
            this.permissions = MapsKt.emptyMap();
        } else {
            this.permissions = map;
        }
        if ((i & 32) == 0) {
            this.action = null;
        } else {
            this.action = str4;
        }
        if ((i & 64) == 0) {
            this.id = null;
        } else {
            this.id = l;
        }
    }

    public WorkerBody(String fullName, String phone, String role, int i, Map<String, Integer> permissions, String str, Long l) {
        Intrinsics.checkNotNullParameter(fullName, "fullName");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        this.fullName = fullName;
        this.phone = phone;
        this.role = role;
        this.isActive = i;
        this.permissions = permissions;
        this.action = str;
        this.id = l;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(WorkerBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.fullName);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.phone, "")) {
            output.encodeStringElement(serialDesc, 1, self.phone);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.role, "cashier")) {
            output.encodeStringElement(serialDesc, 2, self.role);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.isActive != 1) {
            output.encodeIntElement(serialDesc, 3, self.isActive);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.permissions, MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.permissions);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.action != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.action);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.id == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 6, LongSerializer.INSTANCE, self.id);
    }

    public final String getFullName() {
        return this.fullName;
    }

    public /* synthetic */ WorkerBody(String str, String str2, String str3, int i, Map map, String str4, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "cashier" : str3, (i2 & 8) != 0 ? 1 : i, (i2 & 16) != 0 ? MapsKt.emptyMap() : map, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? null : l);
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getRole() {
        return this.role;
    }

    public final int isActive() {
        return this.isActive;
    }

    public final Map<String, Integer> getPermissions() {
        return this.permissions;
    }

    public final String getAction() {
        return this.action;
    }

    public final Long getId() {
        return this.id;
    }
}
