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
import uz.FonRo.pos.data.net.LenientLong;
import uz.FonRo.pos.data.net.LenientString;

/* compiled from: Money.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 N2\u00020\u0001:\u0002MNB[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000eBc\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\tHÆ\u0003J\t\u0010;\u001a\u00020\tHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\tHÆ\u0003J]\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0014\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010B\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010C\u001a\u00020\tHÖ\u0081\u0004J)\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0001b\u0002\bL¢\u0006\u0002\bKR8\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001ar\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\t0\u001d¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R*\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\t0!¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010 R8\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b($r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\t0!¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0015\u001a\u0004\b#\u0010 R8\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b('r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\t0!¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0015\u001a\u0004\b&\u0010 R*\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(+¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0015\u001a\u0004\b)\u0010*R8\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(.r\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\t0/¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0015\u001a\u0004\b-\u0010*R,\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(2¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u0015\u001a\u0004\b1\u0010*R,\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004r\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(5¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u0015\u001a\u0004\b4\u0010*Ê\u0001\u0002\b\u001bÊ\u0001\f\bP\u0012\b\bQ\u0012\u0004\b\u0003\u0010\u0002¨\u0006O"}, d2 = {"Luz/FonRo/pos/data/model/DebtPayment;", "", "saleId", "", "amount", "", "cashAmount", "cardAmount", "createdAt", "", "transactionId", "paymentType", "paidByName", "<init>", "(JDDDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJDDDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSaleId$annotations", "()V", "getSaleId", "()J", "Lkotlinx/serialization/SerialName;", "value", "sale_id", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getAmount$annotations", "getAmount", "()D", "Luz/FonRo/pos/data/net/LenientDouble;", "getCashAmount$annotations", "getCashAmount", "cash_amount", "getCardAmount$annotations", "getCardAmount", "card_amount", "getCreatedAt$annotations", "getCreatedAt", "()Ljava/lang/String;", "created_at", "getTransactionId$annotations", "getTransactionId", FirebaseAnalytics.Param.TRANSACTION_ID, "Luz/FonRo/pos/data/net/LenientString;", "getPaymentType$annotations", "getPaymentType", FirebaseAnalytics.Param.PAYMENT_TYPE, "getPaidByName$annotations", "getPaidByName", "paid_by_name", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class DebtPayment {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double amount;
    private final double cardAmount;
    private final double cashAmount;
    private final String createdAt;
    private final String paidByName;
    private final String paymentType;
    private final long saleId;
    private final String transactionId;

    public DebtPayment() {
        this(0L, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, (String) null, (String) null, (String) null, (String) null, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DebtPayment copy$default(DebtPayment debtPayment, long j, double d, double d2, double d3, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            j = debtPayment.saleId;
        }
        return debtPayment.copy(j, (i & 2) != 0 ? debtPayment.amount : d, (i & 4) != 0 ? debtPayment.cashAmount : d2, (i & 8) != 0 ? debtPayment.cardAmount : d3, (i & 16) != 0 ? debtPayment.createdAt : str, (i & 32) != 0 ? debtPayment.transactionId : str2, (i & 64) != 0 ? debtPayment.paymentType : str3, (i & 128) != 0 ? debtPayment.paidByName : str4);
    }

    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getAmount$annotations() {
    }

    @SerialName("card_amount")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getCardAmount$annotations() {
    }

    @SerialName("cash_amount")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getCashAmount$annotations() {
    }

    @SerialName("created_at")
    public static /* synthetic */ void getCreatedAt$annotations() {
    }

    @SerialName("paid_by_name")
    public static /* synthetic */ void getPaidByName$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PAYMENT_TYPE)
    public static /* synthetic */ void getPaymentType$annotations() {
    }

    @SerialName("sale_id")
    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getSaleId$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.TRANSACTION_ID)
    @Serializable(with = LenientString.class)
    public static /* synthetic */ void getTransactionId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getSaleId() {
        return this.saleId;
    }

    /* renamed from: component2, reason: from getter */
    public final double getAmount() {
        return this.amount;
    }

    /* renamed from: component3, reason: from getter */
    public final double getCashAmount() {
        return this.cashAmount;
    }

    /* renamed from: component4, reason: from getter */
    public final double getCardAmount() {
        return this.cardAmount;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTransactionId() {
        return this.transactionId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPaymentType() {
        return this.paymentType;
    }

    /* renamed from: component8, reason: from getter */
    public final String getPaidByName() {
        return this.paidByName;
    }

    public final DebtPayment copy(long saleId, double amount, double cashAmount, double cardAmount, String createdAt, String transactionId, String paymentType, String paidByName) {
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        return new DebtPayment(saleId, amount, cashAmount, cardAmount, createdAt, transactionId, paymentType, paidByName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DebtPayment)) {
            return false;
        }
        DebtPayment debtPayment = (DebtPayment) other;
        return this.saleId == debtPayment.saleId && Double.compare(this.amount, debtPayment.amount) == 0 && Double.compare(this.cashAmount, debtPayment.cashAmount) == 0 && Double.compare(this.cardAmount, debtPayment.cardAmount) == 0 && Intrinsics.areEqual(this.createdAt, debtPayment.createdAt) && Intrinsics.areEqual(this.transactionId, debtPayment.transactionId) && Intrinsics.areEqual(this.paymentType, debtPayment.paymentType) && Intrinsics.areEqual(this.paidByName, debtPayment.paidByName);
    }

    public int hashCode() {
        int hashCode = ((((((((((Long.hashCode(this.saleId) * 31) + Double.hashCode(this.amount)) * 31) + Double.hashCode(this.cashAmount)) * 31) + Double.hashCode(this.cardAmount)) * 31) + this.createdAt.hashCode()) * 31) + this.transactionId.hashCode()) * 31;
        String str = this.paymentType;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.paidByName;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DebtPayment(saleId=" + this.saleId + ", amount=" + this.amount + ", cashAmount=" + this.cashAmount + ", cardAmount=" + this.cardAmount + ", createdAt=" + this.createdAt + ", transactionId=" + this.transactionId + ", paymentType=" + this.paymentType + ", paidByName=" + this.paidByName + ")";
    }

    /* compiled from: Money.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/DebtPayment$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/DebtPayment;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DebtPayment> serializer() {
            return DebtPayment$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DebtPayment(int i, long j, double d, double d2, double d3, String str, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        this.saleId = (i & 1) == 0 ? 0L : j;
        if ((i & 2) == 0) {
            this.amount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.amount = d;
        }
        if ((i & 4) == 0) {
            this.cashAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.cashAmount = d2;
        }
        if ((i & 8) == 0) {
            this.cardAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.cardAmount = d3;
        }
        if ((i & 16) == 0) {
            this.createdAt = "";
        } else {
            this.createdAt = str;
        }
        if ((i & 32) == 0) {
            this.transactionId = "";
        } else {
            this.transactionId = str2;
        }
        if ((i & 64) == 0) {
            this.paymentType = null;
        } else {
            this.paymentType = str3;
        }
        if ((i & 128) == 0) {
            this.paidByName = null;
        } else {
            this.paidByName = str4;
        }
    }

    public DebtPayment(long j, double d, double d2, double d3, String createdAt, String transactionId, String str, String str2) {
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        this.saleId = j;
        this.amount = d;
        this.cashAmount = d2;
        this.cardAmount = d3;
        this.createdAt = createdAt;
        this.transactionId = transactionId;
        this.paymentType = str;
        this.paidByName = str2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(DebtPayment self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.saleId != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.saleId));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || Double.compare(self.amount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 1, LenientDouble.INSTANCE, Double.valueOf(self.amount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || Double.compare(self.cashAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 2, LenientDouble.INSTANCE, Double.valueOf(self.cashAmount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || Double.compare(self.cardAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 3, LenientDouble.INSTANCE, Double.valueOf(self.cardAmount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.createdAt, "")) {
            output.encodeStringElement(serialDesc, 4, self.createdAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.transactionId, "")) {
            output.encodeSerializableElement(serialDesc, 5, LenientString.INSTANCE, self.transactionId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.paymentType != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.paymentType);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.paidByName == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.paidByName);
    }

    public /* synthetic */ DebtPayment(long j, double d, double d2, double d3, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0.0d : d, (i & 4) != 0 ? 0.0d : d2, (i & 8) != 0 ? 0.0d : d3, (i & 16) != 0 ? "" : str, (i & 32) != 0 ? "" : str2, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : str4);
    }

    public final long getSaleId() {
        return this.saleId;
    }

    public final double getAmount() {
        return this.amount;
    }

    public final double getCashAmount() {
        return this.cashAmount;
    }

    public final double getCardAmount() {
        return this.cardAmount;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public final String getPaymentType() {
        return this.paymentType;
    }

    public final String getPaidByName() {
        return this.paidByName;
    }
}
