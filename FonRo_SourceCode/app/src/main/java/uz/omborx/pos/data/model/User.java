package uz.FonRo.pos.data.model;

import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import uz.FonRo.pos.core.Perm;
import uz.FonRo.pos.data.net.LenientBool;
import uz.FonRo.pos.data.net.LenientInt;
import uz.FonRo.pos.data.net.LenientLong;
import uz.FonRo.pos.data.net.PermissionMapSerializer;

/* compiled from: Auth.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 Q2\u00020\u0001:\u0002PQB\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0010\u0010\u0011B\u0087\u0001\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0010\u0010\u0015J\u000e\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\u0005J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010>\u001a\u00020\nHÆ\u0003J\u0015\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\t\u0010@\u001a\u00020\rHÆ\u0003J\u0015\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\u0081\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\fHÆ\u0001J\u0014\u0010C\u001a\u00020\n2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010E\u001a\u00020\rHÖ\u0081\u0004J\n\u0010F\u001a\u00020\u0005HÖ\u0081\u0004J)\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0001b\u0002\bO¢\u0006\u0002\bNR*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\t0\u001c¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR,\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b!\u0012\b\b\"\u0012\u0004\b\b(#¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u001eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR8\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004r\f\b!\u0012\b\b\"\u0012\u0004\b\b((r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\t0)¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0017\u001a\u0004\b\t\u0010'R6\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\t0-¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0017\u001a\u0004\b+\u0010,R8\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004r\f\b!\u0012\b\b\"\u0012\u0004\b\b(1r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\t02¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0017\u001a\u0004\b/\u00100RD\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004r\f\b!\u0012\b\b\"\u0012\u0004\b\b(5r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\t0-¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u0017\u001a\u0004\b4\u0010,R\u0011\u00106\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b6\u0010'Ê\u0001\u0002\b\u001aÊ\u0001\f\bS\u0012\b\bT\u0012\u0004\b\u0003\u0010\u0002¨\u0006R"}, d2 = {"Luz/FonRo/pos/data/model/User;", "", "id", "", "role", "", "fullName", "email", HintConstants.AUTOFILL_HINT_PHONE, "isSuperAdmin", "", "permissions", "", "", "canSellFlat", "selfLimits", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;ILjava/util/Map;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;ILjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getRole", "()Ljava/lang/String;", "getFullName$annotations", "getFullName", "Lkotlinx/serialization/SerialName;", "value", "full_name", "getEmail", "getPhone", "isSuperAdmin$annotations", "()Z", "is_super_admin", "Luz/FonRo/pos/data/net/LenientBool;", "getPermissions$annotations", "getPermissions", "()Ljava/util/Map;", "Luz/FonRo/pos/data/net/PermissionMapSerializer;", "getCanSellFlat$annotations", "getCanSellFlat", "()I", Perm.SELL, "Luz/FonRo/pos/data/net/LenientInt;", "getSelfLimits$annotations", "getSelfLimits", "self_limits", "isOwnerLike", "selfLimited", "permission", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class User {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int canSellFlat;
    private final String email;
    private final String fullName;
    private final long id;
    private final boolean isSuperAdmin;
    private final Map<String, Integer> permissions;
    private final String phone;
    private final String role;
    private final Map<String, Integer> selfLimits;

    public User() {
        this(0L, (String) null, (String) null, (String) null, (String) null, false, (Map) null, 0, (Map) null, 511, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ User copy$default(User user, long j, String str, String str2, String str3, String str4, boolean z, Map map, int i, Map map2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = user.id;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            str = user.role;
        }
        String str5 = str;
        if ((i2 & 4) != 0) {
            str2 = user.fullName;
        }
        return user.copy(j2, str5, str2, (i2 & 8) != 0 ? user.email : str3, (i2 & 16) != 0 ? user.phone : str4, (i2 & 32) != 0 ? user.isSuperAdmin : z, (i2 & 64) != 0 ? user.permissions : map, (i2 & 128) != 0 ? user.canSellFlat : i, (i2 & 256) != 0 ? user.selfLimits : map2);
    }

    @SerialName(Perm.SELL)
    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getCanSellFlat$annotations() {
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

    @SerialName("self_limits")
    @Serializable(with = PermissionMapSerializer.class)
    public static /* synthetic */ void getSelfLimits$annotations() {
    }

    @SerialName("is_super_admin")
    @Serializable(with = LenientBool.class)
    public static /* synthetic */ void isSuperAdmin$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFullName() {
        return this.fullName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsSuperAdmin() {
        return this.isSuperAdmin;
    }

    public final Map<String, Integer> component7() {
        return this.permissions;
    }

    /* renamed from: component8, reason: from getter */
    public final int getCanSellFlat() {
        return this.canSellFlat;
    }

    public final Map<String, Integer> component9() {
        return this.selfLimits;
    }

    public final User copy(long id, String role, String fullName, String email, String r17, boolean isSuperAdmin, Map<String, Integer> permissions, int canSellFlat, Map<String, Integer> selfLimits) {
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(selfLimits, "selfLimits");
        return new User(id, role, fullName, email, r17, isSuperAdmin, permissions, canSellFlat, selfLimits);
    }

    public boolean equals(Object r8) {
        if (this == r8) {
            return true;
        }
        if (!(r8 instanceof User)) {
            return false;
        }
        User user = (User) r8;
        return this.id == user.id && Intrinsics.areEqual(this.role, user.role) && Intrinsics.areEqual(this.fullName, user.fullName) && Intrinsics.areEqual(this.email, user.email) && Intrinsics.areEqual(this.phone, user.phone) && this.isSuperAdmin == user.isSuperAdmin && Intrinsics.areEqual(this.permissions, user.permissions) && this.canSellFlat == user.canSellFlat && Intrinsics.areEqual(this.selfLimits, user.selfLimits);
    }

    public int hashCode() {
        int hashCode = ((Long.hashCode(this.id) * 31) + this.role.hashCode()) * 31;
        String str = this.fullName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.email;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.phone;
        return ((((((((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + Boolean.hashCode(this.isSuperAdmin)) * 31) + this.permissions.hashCode()) * 31) + Integer.hashCode(this.canSellFlat)) * 31) + this.selfLimits.hashCode();
    }

    public String toString() {
        return "User(id=" + this.id + ", role=" + this.role + ", fullName=" + this.fullName + ", email=" + this.email + ", phone=" + this.phone + ", isSuperAdmin=" + this.isSuperAdmin + ", permissions=" + this.permissions + ", canSellFlat=" + this.canSellFlat + ", selfLimits=" + this.selfLimits + ")";
    }

    /* compiled from: Auth.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/User$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/User;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<User> serializer() {
            return User$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ User(int i, long j, String str, String str2, String str3, String str4, boolean z, Map map, int i2, Map map2, SerializationConstructorMarker serializationConstructorMarker) {
        this.id = (i & 1) == 0 ? 0L : j;
        if ((i & 2) == 0) {
            this.role = "";
        } else {
            this.role = str;
        }
        if ((i & 4) == 0) {
            this.fullName = null;
        } else {
            this.fullName = str2;
        }
        if ((i & 8) == 0) {
            this.email = null;
        } else {
            this.email = str3;
        }
        if ((i & 16) == 0) {
            this.phone = null;
        } else {
            this.phone = str4;
        }
        if ((i & 32) == 0) {
            this.isSuperAdmin = false;
        } else {
            this.isSuperAdmin = z;
        }
        if ((i & 64) == 0) {
            this.permissions = MapsKt.emptyMap();
        } else {
            this.permissions = map;
        }
        if ((i & 128) == 0) {
            this.canSellFlat = 0;
        } else {
            this.canSellFlat = i2;
        }
        if ((i & 256) == 0) {
            this.selfLimits = MapsKt.emptyMap();
        } else {
            this.selfLimits = map2;
        }
    }

    public User(long j, String role, String str, String str2, String str3, boolean z, Map<String, Integer> permissions, int i, Map<String, Integer> selfLimits) {
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(selfLimits, "selfLimits");
        this.id = j;
        this.role = role;
        this.fullName = str;
        this.email = str2;
        this.phone = str3;
        this.isSuperAdmin = z;
        this.permissions = permissions;
        this.canSellFlat = i;
        this.selfLimits = selfLimits;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(User self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.role, "")) {
            output.encodeStringElement(serialDesc, 1, self.role);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.fullName != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.fullName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.email != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.email);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.phone != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.phone);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.isSuperAdmin) {
            output.encodeSerializableElement(serialDesc, 5, LenientBool.INSTANCE, Boolean.valueOf(self.isSuperAdmin));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.permissions, MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 6, PermissionMapSerializer.INSTANCE, self.permissions);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.canSellFlat != 0) {
            output.encodeSerializableElement(serialDesc, 7, LenientInt.INSTANCE, Integer.valueOf(self.canSellFlat));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 8) && Intrinsics.areEqual(self.selfLimits, MapsKt.emptyMap())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 8, PermissionMapSerializer.INSTANCE, self.selfLimits);
    }

    public final long getId() {
        return this.id;
    }

    public /* synthetic */ User(long j, String str, String str2, String str3, String str4, boolean z, Map map, int i, Map map2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? MapsKt.emptyMap() : map, (i2 & 128) != 0 ? 0 : i, (i2 & 256) != 0 ? MapsKt.emptyMap() : map2);
    }

    public final String getRole() {
        return this.role;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final boolean isSuperAdmin() {
        return this.isSuperAdmin;
    }

    public final Map<String, Integer> getPermissions() {
        return this.permissions;
    }

    public final int getCanSellFlat() {
        return this.canSellFlat;
    }

    public final Map<String, Integer> getSelfLimits() {
        return this.selfLimits;
    }

    public final boolean isOwnerLike() {
        return StringsKt.equals(this.role, "owner", true) || StringsKt.equals(this.role, "admin", true) || this.isSuperAdmin;
    }

    public final boolean selfLimited(String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Integer num = this.selfLimits.get(permission);
        return num != null && num.intValue() == 0;
    }
}
