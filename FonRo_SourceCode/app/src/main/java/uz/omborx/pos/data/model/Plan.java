package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
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
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientInt;

/* compiled from: Auth.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000278B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bBI\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010,\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010-\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001b\u0002\b6¢\u0006\u0002\b5R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R*\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\t0\u0019¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R*\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\t0\u001d¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u001cR,\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004r\f\b \u0012\b\b!\u0012\u0004\b\b(\"¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0011Ê\u0001\u0002\b\u0017Ê\u0001\f\b:\u0012\b\b;\u0012\u0004\b\u0003\u0010\u0002¨\u00069"}, d2 = {"Luz/FonRo/pos/data/model/Plan;", "", "key", "", "name", "workers", "", FirebaseAnalytics.Param.PRICE, "", "checkoutUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;IDLjava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;IDLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getKey", "()Ljava/lang/String;", "getName", "getWorkers$annotations", "()V", "getWorkers", "()I", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientInt;", "getPrice$annotations", "getPrice", "()D", "Luz/FonRo/pos/data/net/LenientDouble;", "getCheckoutUrl$annotations", "getCheckoutUrl", "Lkotlinx/serialization/SerialName;", "value", "checkout_url", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class Plan {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String checkoutUrl;
    private final String key;
    private final String name;
    private final double price;
    private final int workers;

    public Plan() {
        this((String) null, (String) null, 0, AudioStats.AUDIO_AMPLITUDE_NONE, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Plan copy$default(Plan plan, String str, String str2, int i, double d, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = plan.key;
        }
        if ((i2 & 2) != 0) {
            str2 = plan.name;
        }
        if ((i2 & 4) != 0) {
            i = plan.workers;
        }
        if ((i2 & 8) != 0) {
            d = plan.price;
        }
        if ((i2 & 16) != 0) {
            str3 = plan.checkoutUrl;
        }
        String str4 = str3;
        int i3 = i;
        return plan.copy(str, str2, i3, d, str4);
    }

    @SerialName("checkout_url")
    public static /* synthetic */ void getCheckoutUrl$annotations() {
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getPrice$annotations() {
    }

    @Serializable(with = LenientInt.class)
    public static /* synthetic */ void getWorkers$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final int getWorkers() {
        return this.workers;
    }

    /* renamed from: component4, reason: from getter */
    public final double getPrice() {
        return this.price;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCheckoutUrl() {
        return this.checkoutUrl;
    }

    public final Plan copy(String key, String name, int workers, double price, String checkoutUrl) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(name, "name");
        return new Plan(key, name, workers, price, checkoutUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Plan)) {
            return false;
        }
        Plan plan = (Plan) other;
        return Intrinsics.areEqual(this.key, plan.key) && Intrinsics.areEqual(this.name, plan.name) && this.workers == plan.workers && Double.compare(this.price, plan.price) == 0 && Intrinsics.areEqual(this.checkoutUrl, plan.checkoutUrl);
    }

    public int hashCode() {
        int hashCode = ((((((this.key.hashCode() * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.workers)) * 31) + Double.hashCode(this.price)) * 31;
        String str = this.checkoutUrl;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Plan(key=" + this.key + ", name=" + this.name + ", workers=" + this.workers + ", price=" + this.price + ", checkoutUrl=" + this.checkoutUrl + ")";
    }

    /* compiled from: Auth.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/Plan$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/Plan;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Plan> serializer() {
            return Plan$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Plan(int i, String str, String str2, int i2, double d, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.key = "";
        } else {
            this.key = str;
        }
        if ((i & 2) == 0) {
            this.name = "";
        } else {
            this.name = str2;
        }
        if ((i & 4) == 0) {
            this.workers = 0;
        } else {
            this.workers = i2;
        }
        if ((i & 8) == 0) {
            this.price = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.price = d;
        }
        if ((i & 16) == 0) {
            this.checkoutUrl = null;
        } else {
            this.checkoutUrl = str3;
        }
    }

    public Plan(String key, String name, int i, double d, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(name, "name");
        this.key = key;
        this.name = name;
        this.workers = i;
        this.price = d;
        this.checkoutUrl = str;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(Plan self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.key, "")) {
            output.encodeStringElement(serialDesc, 0, self.key);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.name, "")) {
            output.encodeStringElement(serialDesc, 1, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.workers != 0) {
            output.encodeSerializableElement(serialDesc, 2, LenientInt.INSTANCE, Integer.valueOf(self.workers));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || Double.compare(self.price, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 3, LenientDouble.INSTANCE, Double.valueOf(self.price));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.checkoutUrl == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.checkoutUrl);
    }

    public /* synthetic */ Plan(String str, String str2, int i, double d, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : d, (i2 & 16) != 0 ? null : str3);
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final int getWorkers() {
        return this.workers;
    }

    public final double getPrice() {
        return this.price;
    }

    public final String getCheckoutUrl() {
        return this.checkoutUrl;
    }
}
