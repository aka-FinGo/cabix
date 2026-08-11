package uz.FonRo.pos.data.model;

import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
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

/* compiled from: Auth.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 B2\u00020\u0001:\u0002ABBc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eBi\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003Je\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0014\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00106\u001a\u00020\u0010HÖ\u0081\u0004J\n\u00107\u001a\u00020\u0005HÖ\u0081\u0004J)\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0001b\u0002\b@¢\u0006\u0002\b?R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\t0\u001a¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR,\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b\"\u0012\b\b#\u0012\u0004\b\b($¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u001cR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b)\u0010\u001cÊ\u0001\u0002\b\u0018Ê\u0001\f\bD\u0012\b\bE\u0012\u0004\b\u0003\u0010\u0000¨\u0006C"}, d2 = {"Luz/FonRo/pos/data/model/Store;", "", "id", "", "name", "", HintConstants.AUTOFILL_HINT_PHONE, "address", FirebaseAnalytics.Param.CURRENCY, "posCurrency", "slug", "paywall", "Luz/FonRo/pos/data/model/Paywall;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Luz/FonRo/pos/data/model/Paywall;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Luz/FonRo/pos/data/model/Paywall;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getName", "()Ljava/lang/String;", "getPhone", "getAddress", "getCurrency", "getPosCurrency$annotations", "getPosCurrency", "Lkotlinx/serialization/SerialName;", "value", "pos_currency", "getSlug", "getPaywall", "()Luz/FonRo/pos/data/model/Paywall;", "activeCurrency", "getActiveCurrency", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class Store {
    private final String address;
    private final String currency;
    private final long id;
    private final String name;
    private final Paywall paywall;
    private final String phone;
    private final String posCurrency;
    private final String slug;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public Store() {
        this(0L, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Paywall) null, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Store copy$default(Store store, long j, String str, String str2, String str3, String str4, String str5, String str6, Paywall paywall, int i, Object obj) {
        if ((i & 1) != 0) {
            j = store.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = store.name;
        }
        String str7 = str;
        if ((i & 4) != 0) {
            str2 = store.phone;
        }
        String str8 = str2;
        if ((i & 8) != 0) {
            str3 = store.address;
        }
        return store.copy(j2, str7, str8, str3, (i & 16) != 0 ? store.currency : str4, (i & 32) != 0 ? store.posCurrency : str5, (i & 64) != 0 ? store.slug : str6, (i & 128) != 0 ? store.paywall : paywall);
    }

    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("pos_currency")
    public static /* synthetic */ void getPosCurrency$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
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
    public final String getCurrency() {
        return this.currency;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPosCurrency() {
        return this.posCurrency;
    }

    /* renamed from: component7, reason: from getter */
    public final String getSlug() {
        return this.slug;
    }

    /* renamed from: component8, reason: from getter */
    public final Paywall getPaywall() {
        return this.paywall;
    }

    public final Store copy(long id, String name, String r14, String address, String r16, String posCurrency, String slug, Paywall paywall) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new Store(id, name, r14, address, r16, posCurrency, slug, paywall);
    }

    public boolean equals(Object r8) {
        if (this == r8) {
            return true;
        }
        if (!(r8 instanceof Store)) {
            return false;
        }
        Store store = (Store) r8;
        return this.id == store.id && Intrinsics.areEqual(this.name, store.name) && Intrinsics.areEqual(this.phone, store.phone) && Intrinsics.areEqual(this.address, store.address) && Intrinsics.areEqual(this.currency, store.currency) && Intrinsics.areEqual(this.posCurrency, store.posCurrency) && Intrinsics.areEqual(this.slug, store.slug) && Intrinsics.areEqual(this.paywall, store.paywall);
    }

    public int hashCode() {
        int hashCode = ((Long.hashCode(this.id) * 31) + this.name.hashCode()) * 31;
        String str = this.phone;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.address;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.currency;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.posCurrency;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.slug;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Paywall paywall = this.paywall;
        return hashCode6 + (paywall != null ? paywall.hashCode() : 0);
    }

    public String toString() {
        return "Store(id=" + this.id + ", name=" + this.name + ", phone=" + this.phone + ", address=" + this.address + ", currency=" + this.currency + ", posCurrency=" + this.posCurrency + ", slug=" + this.slug + ", paywall=" + this.paywall + ")";
    }

    /* compiled from: Auth.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/Store$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/Store;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Store> serializer() {
            return Store$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Store(int i, long j, String str, String str2, String str3, String str4, String str5, String str6, Paywall paywall, SerializationConstructorMarker serializationConstructorMarker) {
        this.id = (i & 1) == 0 ? 0L : j;
        if ((i & 2) == 0) {
            this.name = "";
        } else {
            this.name = str;
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
            this.currency = null;
        } else {
            this.currency = str4;
        }
        if ((i & 32) == 0) {
            this.posCurrency = null;
        } else {
            this.posCurrency = str5;
        }
        if ((i & 64) == 0) {
            this.slug = null;
        } else {
            this.slug = str6;
        }
        if ((i & 128) == 0) {
            this.paywall = null;
        } else {
            this.paywall = paywall;
        }
    }

    public Store(long j, String name, String str, String str2, String str3, String str4, String str5, Paywall paywall) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = j;
        this.name = name;
        this.phone = str;
        this.address = str2;
        this.currency = str3;
        this.posCurrency = str4;
        this.slug = str5;
        this.paywall = paywall;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(Store self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.name, "")) {
            output.encodeStringElement(serialDesc, 1, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.phone != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.phone);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.address != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.address);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.currency != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.currency);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.posCurrency != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.posCurrency);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.slug != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.slug);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.paywall == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 7, Paywall$$serializer.INSTANCE, self.paywall);
    }

    public final long getId() {
        return this.id;
    }

    public /* synthetic */ Store(long j, String str, String str2, String str3, String str4, String str5, String str6, Paywall paywall, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : paywall);
    }

    public final String getName() {
        return this.name;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getPosCurrency() {
        return this.posCurrency;
    }

    public final String getSlug() {
        return this.slug;
    }

    public final Paywall getPaywall() {
        return this.paywall;
    }

    public final String getActiveCurrency() {
        String str = this.posCurrency;
        String str2 = null;
        if (str != null) {
            if (StringsKt.isBlank(str)) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        String str3 = this.currency;
        if (str3 != null && !StringsKt.isBlank(str3)) {
            str2 = str3;
        }
        return str2 == null ? "UZS" : str2;
    }
}
