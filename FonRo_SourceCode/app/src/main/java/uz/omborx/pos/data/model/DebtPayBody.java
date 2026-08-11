package uz.FonRo.pos.data.model;

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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Money.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 <2\u00020\u0001:\u0002;<B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fBO\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003JE\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0014\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00100\u001a\u00020\u000eHÖ\u0081\u0004J\n\u00101\u001a\u00020\u0007HÖ\u0081\u0004J)\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0001b\u0002\b:¢\u0006\u0002\b9R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR*\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u001dR*\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(!¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u001aR*\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b($¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dÊ\u0001\u0002\b>Ê\u0001\f\b?\u0012\b\b@\u0012\u0004\b\u0003\u0010\u0002¨\u0006="}, d2 = {"Luz/FonRo/pos/data/model/DebtPayBody;", "", "saleId", "", "amount", "", "paymentType", "", "cashAmount", "cardAmount", "note", "<init>", "(JDLjava/lang/String;DDLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJDLjava/lang/String;DDLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSaleId$annotations", "()V", "getSaleId", "()J", "Lkotlinx/serialization/SerialName;", "value", "sale_id", "getAmount", "()D", "getPaymentType$annotations", "getPaymentType", "()Ljava/lang/String;", FirebaseAnalytics.Param.PAYMENT_TYPE, "getCashAmount$annotations", "getCashAmount", "cash_amount", "getCardAmount$annotations", "getCardAmount", "card_amount", "getNote", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class DebtPayBody {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double amount;
    private final double cardAmount;
    private final double cashAmount;
    private final String note;
    private final String paymentType;
    private final long saleId;

    public static /* synthetic */ DebtPayBody copy$default(DebtPayBody debtPayBody, long j, double d, String str, double d2, double d3, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = debtPayBody.saleId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            d = debtPayBody.amount;
        }
        return debtPayBody.copy(j2, d, (i & 4) != 0 ? debtPayBody.paymentType : str, (i & 8) != 0 ? debtPayBody.cashAmount : d2, (i & 16) != 0 ? debtPayBody.cardAmount : d3, (i & 32) != 0 ? debtPayBody.note : str2);
    }

    @SerialName("card_amount")
    public static /* synthetic */ void getCardAmount$annotations() {
    }

    @SerialName("cash_amount")
    public static /* synthetic */ void getCashAmount$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PAYMENT_TYPE)
    public static /* synthetic */ void getPaymentType$annotations() {
    }

    @SerialName("sale_id")
    public static /* synthetic */ void getSaleId$annotations() {
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
    public final String getPaymentType() {
        return this.paymentType;
    }

    /* renamed from: component4, reason: from getter */
    public final double getCashAmount() {
        return this.cashAmount;
    }

    /* renamed from: component5, reason: from getter */
    public final double getCardAmount() {
        return this.cardAmount;
    }

    /* renamed from: component6, reason: from getter */
    public final String getNote() {
        return this.note;
    }

    public final DebtPayBody copy(long saleId, double amount, String paymentType, double cashAmount, double cardAmount, String note) {
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        Intrinsics.checkNotNullParameter(note, "note");
        return new DebtPayBody(saleId, amount, paymentType, cashAmount, cardAmount, note);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DebtPayBody)) {
            return false;
        }
        DebtPayBody debtPayBody = (DebtPayBody) other;
        return this.saleId == debtPayBody.saleId && Double.compare(this.amount, debtPayBody.amount) == 0 && Intrinsics.areEqual(this.paymentType, debtPayBody.paymentType) && Double.compare(this.cashAmount, debtPayBody.cashAmount) == 0 && Double.compare(this.cardAmount, debtPayBody.cardAmount) == 0 && Intrinsics.areEqual(this.note, debtPayBody.note);
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.saleId) * 31) + Double.hashCode(this.amount)) * 31) + this.paymentType.hashCode()) * 31) + Double.hashCode(this.cashAmount)) * 31) + Double.hashCode(this.cardAmount)) * 31) + this.note.hashCode();
    }

    public String toString() {
        return "DebtPayBody(saleId=" + this.saleId + ", amount=" + this.amount + ", paymentType=" + this.paymentType + ", cashAmount=" + this.cashAmount + ", cardAmount=" + this.cardAmount + ", note=" + this.note + ")";
    }

    /* compiled from: Money.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/DebtPayBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/DebtPayBody;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DebtPayBody> serializer() {
            return DebtPayBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DebtPayBody(int i, long j, double d, String str, double d2, double d3, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, DebtPayBody$$serializer.INSTANCE.getDescriptor());
        }
        this.saleId = j;
        this.amount = d;
        this.paymentType = str;
        this.cashAmount = d2;
        this.cardAmount = d3;
        if ((i & 32) == 0) {
            this.note = "";
        } else {
            this.note = str2;
        }
    }

    public DebtPayBody(long j, double d, String paymentType, double d2, double d3, String note) {
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        Intrinsics.checkNotNullParameter(note, "note");
        this.saleId = j;
        this.amount = d;
        this.paymentType = paymentType;
        this.cashAmount = d2;
        this.cardAmount = d3;
        this.note = note;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(DebtPayBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.saleId);
        output.encodeDoubleElement(serialDesc, 1, self.amount);
        output.encodeStringElement(serialDesc, 2, self.paymentType);
        output.encodeDoubleElement(serialDesc, 3, self.cashAmount);
        output.encodeDoubleElement(serialDesc, 4, self.cardAmount);
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && Intrinsics.areEqual(self.note, "")) {
            return;
        }
        output.encodeStringElement(serialDesc, 5, self.note);
    }

    public final long getSaleId() {
        return this.saleId;
    }

    public final double getAmount() {
        return this.amount;
    }

    public final String getPaymentType() {
        return this.paymentType;
    }

    public final double getCashAmount() {
        return this.cashAmount;
    }

    public final double getCardAmount() {
        return this.cardAmount;
    }

    public /* synthetic */ DebtPayBody(long j, double d, String str, double d2, double d3, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, d, str, d2, d3, (i & 32) != 0 ? "" : str2);
    }

    public final String getNote() {
        return this.note;
    }
}
