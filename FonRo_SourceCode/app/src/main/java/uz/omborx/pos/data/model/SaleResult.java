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
import uz.FonRo.pos.data.net.LenientBool;
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientLong;
import uz.FonRo.pos.data.net.LenientString;

/* compiled from: Sales.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 A2\u00020\u0001:\u0002@AB;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rBG\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003J=\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0014\u00103\u001a\u00020\t2\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00105\u001a\u00020\u000fHÖ\u0081\u0004J\n\u00106\u001a\u00020\u0005HÖ\u0081\u0004J)\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0001b\u0002\b?¢\u0006\u0002\b>R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\t0\u0019¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R8\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001fr\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\t0 ¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u001cR8\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b($r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\t0%¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010#R8\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b()r\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\t0*¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010(R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,Ê\u0001\u0002\b\u0017Ê\u0001\f\bC\u0012\b\bD\u0012\u0004\b\u0003\u0010\u0000¨\u0006B"}, d2 = {"Luz/FonRo/pos/data/model/SaleResult;", "", "id", "", "transactionId", "", "totalAmount", "", "alreadySynced", "", "paywall", "Luz/FonRo/pos/data/model/Paywall;", "<init>", "(JLjava/lang/String;DZLuz/FonRo/pos/data/model/Paywall;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;DZLuz/FonRo/pos/data/model/Paywall;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getTransactionId$annotations", "getTransactionId", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", FirebaseAnalytics.Param.TRANSACTION_ID, "Luz/FonRo/pos/data/net/LenientString;", "getTotalAmount$annotations", "getTotalAmount", "()D", "total_amount", "Luz/FonRo/pos/data/net/LenientDouble;", "getAlreadySynced$annotations", "getAlreadySynced", "()Z", "already_synced", "Luz/FonRo/pos/data/net/LenientBool;", "getPaywall", "()Luz/FonRo/pos/data/model/Paywall;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class SaleResult {
    private final boolean alreadySynced;
    private final long id;
    private final Paywall paywall;
    private final double totalAmount;
    private final String transactionId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = Paywall.$stable;

    public SaleResult() {
        this(0L, (String) null, AudioStats.AUDIO_AMPLITUDE_NONE, false, (Paywall) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SaleResult copy$default(SaleResult saleResult, long j, String str, double d, boolean z, Paywall paywall, int i, Object obj) {
        if ((i & 1) != 0) {
            j = saleResult.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = saleResult.transactionId;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            d = saleResult.totalAmount;
        }
        double d2 = d;
        if ((i & 8) != 0) {
            z = saleResult.alreadySynced;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            paywall = saleResult.paywall;
        }
        return saleResult.copy(j2, str2, d2, z2, paywall);
    }

    @SerialName("already_synced")
    @Serializable(with = LenientBool.class)
    public static /* synthetic */ void getAlreadySynced$annotations() {
    }

    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("total_amount")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getTotalAmount$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.TRANSACTION_ID)
    @Serializable(with = LenientString.class)
    public static /* synthetic */ void getTransactionId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTransactionId() {
        return this.transactionId;
    }

    /* renamed from: component3, reason: from getter */
    public final double getTotalAmount() {
        return this.totalAmount;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getAlreadySynced() {
        return this.alreadySynced;
    }

    /* renamed from: component5, reason: from getter */
    public final Paywall getPaywall() {
        return this.paywall;
    }

    public final SaleResult copy(long id, String transactionId, double totalAmount, boolean alreadySynced, Paywall paywall) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        return new SaleResult(id, transactionId, totalAmount, alreadySynced, paywall);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleResult)) {
            return false;
        }
        SaleResult saleResult = (SaleResult) other;
        return this.id == saleResult.id && Intrinsics.areEqual(this.transactionId, saleResult.transactionId) && Double.compare(this.totalAmount, saleResult.totalAmount) == 0 && this.alreadySynced == saleResult.alreadySynced && Intrinsics.areEqual(this.paywall, saleResult.paywall);
    }

    public int hashCode() {
        int hashCode = ((((((Long.hashCode(this.id) * 31) + this.transactionId.hashCode()) * 31) + Double.hashCode(this.totalAmount)) * 31) + Boolean.hashCode(this.alreadySynced)) * 31;
        Paywall paywall = this.paywall;
        return hashCode + (paywall == null ? 0 : paywall.hashCode());
    }

    public String toString() {
        return "SaleResult(id=" + this.id + ", transactionId=" + this.transactionId + ", totalAmount=" + this.totalAmount + ", alreadySynced=" + this.alreadySynced + ", paywall=" + this.paywall + ")";
    }

    /* compiled from: Sales.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/SaleResult$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/SaleResult;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SaleResult> serializer() {
            return SaleResult$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SaleResult(int i, long j, String str, double d, boolean z, Paywall paywall, SerializationConstructorMarker serializationConstructorMarker) {
        this.id = (i & 1) == 0 ? 0L : j;
        if ((i & 2) == 0) {
            this.transactionId = "";
        } else {
            this.transactionId = str;
        }
        if ((i & 4) == 0) {
            this.totalAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.totalAmount = d;
        }
        if ((i & 8) == 0) {
            this.alreadySynced = false;
        } else {
            this.alreadySynced = z;
        }
        if ((i & 16) == 0) {
            this.paywall = null;
        } else {
            this.paywall = paywall;
        }
    }

    public SaleResult(long j, String transactionId, double d, boolean z, Paywall paywall) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        this.id = j;
        this.transactionId = transactionId;
        this.totalAmount = d;
        this.alreadySynced = z;
        this.paywall = paywall;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(SaleResult self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.transactionId, "")) {
            output.encodeSerializableElement(serialDesc, 1, LenientString.INSTANCE, self.transactionId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || Double.compare(self.totalAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 2, LenientDouble.INSTANCE, Double.valueOf(self.totalAmount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.alreadySynced) {
            output.encodeSerializableElement(serialDesc, 3, LenientBool.INSTANCE, Boolean.valueOf(self.alreadySynced));
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.paywall == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, Paywall$$serializer.INSTANCE, self.paywall);
    }

    public final long getId() {
        return this.id;
    }

    public /* synthetic */ SaleResult(long j, String str, double d, boolean z, Paywall paywall, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : d, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : paywall);
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public final double getTotalAmount() {
        return this.totalAmount;
    }

    public final boolean getAlreadySynced() {
        return this.alreadySynced;
    }

    public final Paywall getPaywall() {
        return this.paywall;
    }
}
