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

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bBC\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\nHÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001b\u0002\b*¢\u0006\u0002\b)R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011Ê\u0001\u0002\b.Ê\u0001\f\b/\u0012\b\b0\u0012\u0004\b\u0003\u0010\u0002¨\u0006-"}, d2 = {"Luz/FonRo/pos/data/model/CustomerBody;", "", "fullName", "", HintConstants.AUTOFILL_HINT_PHONE, "address", "note", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFullName$annotations", "()V", "getFullName", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "full_name", "getPhone", "getAddress", "getNote", "component1", "component2", "component3", "component4", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class CustomerBody {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String address;
    private final String fullName;
    private final String note;
    private final String phone;

    public static /* synthetic */ CustomerBody copy$default(CustomerBody customerBody, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = customerBody.fullName;
        }
        if ((i & 2) != 0) {
            str2 = customerBody.phone;
        }
        if ((i & 4) != 0) {
            str3 = customerBody.address;
        }
        if ((i & 8) != 0) {
            str4 = customerBody.note;
        }
        return customerBody.copy(str, str2, str3, str4);
    }

    @SerialName("full_name")
    public static /* synthetic */ void getFullName$annotations() {
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
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: component4, reason: from getter */
    public final String getNote() {
        return this.note;
    }

    public final CustomerBody copy(String fullName, String phone, String address, String note) {
        Intrinsics.checkNotNullParameter(fullName, "fullName");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(note, "note");
        return new CustomerBody(fullName, phone, address, note);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomerBody)) {
            return false;
        }
        CustomerBody customerBody = (CustomerBody) other;
        return Intrinsics.areEqual(this.fullName, customerBody.fullName) && Intrinsics.areEqual(this.phone, customerBody.phone) && Intrinsics.areEqual(this.address, customerBody.address) && Intrinsics.areEqual(this.note, customerBody.note);
    }

    public int hashCode() {
        return (((((this.fullName.hashCode() * 31) + this.phone.hashCode()) * 31) + this.address.hashCode()) * 31) + this.note.hashCode();
    }

    public String toString() {
        return "CustomerBody(fullName=" + this.fullName + ", phone=" + this.phone + ", address=" + this.address + ", note=" + this.note + ")";
    }

    /* compiled from: Catalog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/CustomerBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/CustomerBody;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CustomerBody> serializer() {
            return CustomerBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CustomerBody(int i, String str, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, CustomerBody$$serializer.INSTANCE.getDescriptor());
        }
        this.fullName = str;
        if ((i & 2) == 0) {
            this.phone = "";
        } else {
            this.phone = str2;
        }
        if ((i & 4) == 0) {
            this.address = "";
        } else {
            this.address = str3;
        }
        if ((i & 8) == 0) {
            this.note = "";
        } else {
            this.note = str4;
        }
    }

    public CustomerBody(String fullName, String phone, String address, String note) {
        Intrinsics.checkNotNullParameter(fullName, "fullName");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(note, "note");
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.note = note;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(CustomerBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.fullName);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.phone, "")) {
            output.encodeStringElement(serialDesc, 1, self.phone);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.address, "")) {
            output.encodeStringElement(serialDesc, 2, self.address);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && Intrinsics.areEqual(self.note, "")) {
            return;
        }
        output.encodeStringElement(serialDesc, 3, self.note);
    }

    public /* synthetic */ CustomerBody(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getNote() {
        return this.note;
    }
}
