package uz.FonRo.pos.data.model;

import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.actions.SearchIntents;
import java.util.Locale;
import kotlin.Metadata;
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
import uz.FonRo.pos.data.net.LenientLong;

/* compiled from: Catalog.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 72\u00020\u0001:\u000267B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nBK\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0005J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003JA\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010)\u001a\u00020!2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010+\u001a\u00020\fHÖ\u0081\u0004J\n\u0010,\u001a\u00020\u0005HÖ\u0081\u0004J)\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0001b\u0002\b5¢\u0006\u0002\b4R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\t0\u0016¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R*\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019Ê\u0001\u0002\b\u0014Ê\u0001\f\b9\u0012\b\b:\u0012\u0004\b\u0003\u0010\u0002¨\u00068"}, d2 = {"Luz/FonRo/pos/data/model/Customer;", "", "id", "", "fullName", "", HintConstants.AUTOFILL_HINT_PHONE, "address", "note", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getFullName$annotations", "getFullName", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", "full_name", "getPhone", "getAddress", "getNote", "matches", "", SearchIntents.EXTRA_QUERY, "component1", "component2", "component3", "component4", "component5", "copy", "equals", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class Customer {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String address;
    private final String fullName;
    private final long id;
    private final String note;
    private final String phone;

    public Customer() {
        this(0L, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Customer copy$default(Customer customer, long j, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            j = customer.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = customer.fullName;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = customer.phone;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = customer.address;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = customer.note;
        }
        return customer.copy(j2, str5, str6, str7, str4);
    }

    @SerialName("full_name")
    public static /* synthetic */ void getFullName$annotations() {
    }

    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getId$annotations() {
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
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: component5, reason: from getter */
    public final String getNote() {
        return this.note;
    }

    public final Customer copy(long id, String fullName, String phone, String address, String note) {
        Intrinsics.checkNotNullParameter(fullName, "fullName");
        return new Customer(id, fullName, phone, address, note);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) other;
        return this.id == customer.id && Intrinsics.areEqual(this.fullName, customer.fullName) && Intrinsics.areEqual(this.phone, customer.phone) && Intrinsics.areEqual(this.address, customer.address) && Intrinsics.areEqual(this.note, customer.note);
    }

    public int hashCode() {
        int hashCode = ((Long.hashCode(this.id) * 31) + this.fullName.hashCode()) * 31;
        String str = this.phone;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.address;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.note;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "Customer(id=" + this.id + ", fullName=" + this.fullName + ", phone=" + this.phone + ", address=" + this.address + ", note=" + this.note + ")";
    }

    /* compiled from: Catalog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/Customer$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/Customer;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Customer> serializer() {
            return Customer$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Customer(int i, long j, String str, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.address = null;
        } else {
            this.address = str3;
        }
        if ((i & 16) == 0) {
            this.note = null;
        } else {
            this.note = str4;
        }
    }

    public Customer(long j, String fullName, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(fullName, "fullName");
        this.id = j;
        this.fullName = fullName;
        this.phone = str;
        this.address = str2;
        this.note = str3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(Customer self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.fullName, "")) {
            output.encodeStringElement(serialDesc, 1, self.fullName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.phone != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.phone);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.address != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.address);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.note == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.note);
    }

    public final long getId() {
        return this.id;
    }

    public /* synthetic */ Customer(long j, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
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

    public final boolean matches(String query) {
        String str;
        Intrinsics.checkNotNullParameter(query, "query");
        String lowerCase = StringsKt.trim((CharSequence) query).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str2 = lowerCase;
        if (str2.length() == 0) {
            return true;
        }
        String lowerCase2 = this.fullName.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) str2, false, 2, (Object) null) || ((str = this.phone) != null && StringsKt.contains$default((CharSequence) str, (CharSequence) str2, false, 2, (Object) null));
    }
}
