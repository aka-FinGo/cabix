package uz.FonRo.pos.data.model;

import androidx.autofill.HintConstants;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Auth.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tBM\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J;\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010%\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001b\u0002\b/¢\u0006\u0002\b.R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R*\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0018¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012Ê\u0001\u0002\b3Ê\u0001\f\b4\u0012\b\b5\u0012\u0004\b\u0003\u0010\u0002¨\u00062"}, d2 = {"Luz/FonRo/pos/data/model/RegisterBody;", "", "fullName", "", "storeName", HintConstants.AUTOFILL_HINT_PHONE, "email", HintConstants.AUTOFILL_HINT_PASSWORD, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFullName$annotations", "()V", "getFullName", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "full_name", "getStoreName$annotations", "getStoreName", "store_name", "getPhone", "getEmail", "getPassword", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class RegisterBody {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String email;
    private final String fullName;
    private final String password;
    private final String phone;
    private final String storeName;

    public static /* synthetic */ RegisterBody copy$default(RegisterBody registerBody, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = registerBody.fullName;
        }
        if ((i & 2) != 0) {
            str2 = registerBody.storeName;
        }
        if ((i & 4) != 0) {
            str3 = registerBody.phone;
        }
        if ((i & 8) != 0) {
            str4 = registerBody.email;
        }
        if ((i & 16) != 0) {
            str5 = registerBody.password;
        }
        String str6 = str5;
        String str7 = str3;
        return registerBody.copy(str, str2, str7, str4, str6);
    }

    @SerialName("full_name")
    public static /* synthetic */ void getFullName$annotations() {
    }

    @SerialName("store_name")
    public static /* synthetic */ void getStoreName$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getFullName() {
        return this.fullName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStoreName() {
        return this.storeName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component4, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPassword() {
        return this.password;
    }

    public final RegisterBody copy(String fullName, String storeName, String phone, String email, String password) {
        Intrinsics.checkNotNullParameter(fullName, "fullName");
        Intrinsics.checkNotNullParameter(storeName, "storeName");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(password, "password");
        return new RegisterBody(fullName, storeName, phone, email, password);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegisterBody)) {
            return false;
        }
        RegisterBody registerBody = (RegisterBody) other;
        return Intrinsics.areEqual(this.fullName, registerBody.fullName) && Intrinsics.areEqual(this.storeName, registerBody.storeName) && Intrinsics.areEqual(this.phone, registerBody.phone) && Intrinsics.areEqual(this.email, registerBody.email) && Intrinsics.areEqual(this.password, registerBody.password);
    }

    public int hashCode() {
        return (((((((this.fullName.hashCode() * 31) + this.storeName.hashCode()) * 31) + this.phone.hashCode()) * 31) + this.email.hashCode()) * 31) + this.password.hashCode();
    }

    public String toString() {
        return "RegisterBody(fullName=" + this.fullName + ", storeName=" + this.storeName + ", phone=" + this.phone + ", email=" + this.email + ", password=" + this.password + ")";
    }

    /* compiled from: Auth.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/RegisterBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/RegisterBody;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<RegisterBody> serializer() {
            return RegisterBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ RegisterBody(int i, String str, String str2, String str3, String str4, String str5, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, RegisterBody$$serializer.INSTANCE.getDescriptor());
        }
        this.fullName = str;
        this.storeName = str2;
        this.phone = str3;
        this.email = str4;
        this.password = str5;
    }

    public RegisterBody(String fullName, String storeName, String phone, String email, String password) {
        Intrinsics.checkNotNullParameter(fullName, "fullName");
        Intrinsics.checkNotNullParameter(storeName, "storeName");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(password, "password");
        this.fullName = fullName;
        this.storeName = storeName;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(RegisterBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.fullName);
        output.encodeStringElement(serialDesc, 1, self.storeName);
        output.encodeStringElement(serialDesc, 2, self.phone);
        output.encodeStringElement(serialDesc, 3, self.email);
        output.encodeStringElement(serialDesc, 4, self.password);
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final String getStoreName() {
        return this.storeName;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPassword() {
        return this.password;
    }
}
