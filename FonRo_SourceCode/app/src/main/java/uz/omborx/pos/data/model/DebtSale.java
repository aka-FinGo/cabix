package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import uz.FonRo.pos.data.net.LenientDouble;
import uz.FonRo.pos.data.net.LenientLong;
import uz.FonRo.pos.data.net.LenientString;

/* compiled from: Money.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 ^2\u00020\u0001:\u0002]^B\u0081\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u0085\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0012\u0010\u0018J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u000bHÆ\u0003J\t\u0010J\u001a\u00020\u000bHÆ\u0003J\t\u0010K\u001a\u00020\u000bHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\u0083\u0001\u0010N\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0001J\u0014\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010R\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010S\u001a\u00020\u0005HÖ\u0081\u0004J)\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00002\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZH\u0001b\u0002\b\\¢\u0006\u0002\b[R*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\t0\u001f¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR8\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b#\u0012\b\b$\u0012\u0004\b\b(%r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\t0&¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\"R8\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b#\u0012\b\b$\u0012\u0004\b\b()r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\t0\u001f¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010\u001cR,\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b#\u0012\b\b$\u0012\u0004\b\b(,¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001a\u001a\u0004\b+\u0010\"R,\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b#\u0012\b\b$\u0012\u0004\b\b(/¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u001a\u001a\u0004\b.\u0010\"R*\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004r\f\b#\u0012\b\b$\u0012\u0004\b\b(2¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u001a\u001a\u0004\b1\u0010\"R8\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004r\f\b#\u0012\b\b$\u0012\u0004\b\b(6r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\t07¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u001a\u001a\u0004\b4\u00105R8\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004r\f\b#\u0012\b\b$\u0012\u0004\b\b(:r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\t07¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010\u001a\u001a\u0004\b9\u00105R8\u0010\r\u001a\u00020\u000b8\u0006X\u0087\u0004r\f\b#\u0012\b\b$\u0012\u0004\b\b(=r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\t07¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010\u001a\u001a\u0004\b<\u00105R,\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004r\f\b#\u0012\b\b$\u0012\u0004\b\b(@¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010\u001a\u001a\u0004\b?\u0010\"R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BÊ\u0001\u0002\b\u001dÊ\u0001\f\b`\u0012\b\ba\u0012\u0004\b\u0003\u0010\u0000¨\u0006_"}, d2 = {"Luz/FonRo/pos/data/model/DebtSale;", "", "id", "", "transactionId", "", "customerId", "customerName", "cashierName", "soldAt", "totalAmount", "", "paidAmount", "debtAmount", "paymentType", FirebaseAnalytics.Param.ITEMS, "", "Luz/FonRo/pos/data/model/DebtSaleItem;", "<init>", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;DDDLjava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;DDDLjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "Lkotlinx/serialization/Serializable;", "with", "Luz/FonRo/pos/data/net/LenientLong;", "getTransactionId$annotations", "getTransactionId", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", FirebaseAnalytics.Param.TRANSACTION_ID, "Luz/FonRo/pos/data/net/LenientString;", "getCustomerId$annotations", "getCustomerId", "customer_id", "getCustomerName$annotations", "getCustomerName", "customer_name", "getCashierName$annotations", "getCashierName", "cashier_name", "getSoldAt$annotations", "getSoldAt", "sold_at", "getTotalAmount$annotations", "getTotalAmount", "()D", "total_amount", "Luz/FonRo/pos/data/net/LenientDouble;", "getPaidAmount$annotations", "getPaidAmount", "paid_amount", "getDebtAmount$annotations", "getDebtAmount", "debt_amount", "getPaymentType$annotations", "getPaymentType", FirebaseAnalytics.Param.PAYMENT_TYPE, "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class DebtSale {
    private final String cashierName;
    private final long customerId;
    private final String customerName;
    private final double debtAmount;
    private final long id;
    private final List<DebtSaleItem> items;
    private final double paidAmount;
    private final String paymentType;
    private final String soldAt;
    private final double totalAmount;
    private final String transactionId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.DebtSale$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = DebtSale._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public DebtSale() {
        this(0L, (String) null, 0L, (String) null, (String) null, (String) null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, (String) null, (List) null, 2047, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(DebtSaleItem$$serializer.INSTANCE);
    }

    @SerialName("cashier_name")
    public static /* synthetic */ void getCashierName$annotations() {
    }

    @SerialName("customer_id")
    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getCustomerId$annotations() {
    }

    @SerialName("customer_name")
    public static /* synthetic */ void getCustomerName$annotations() {
    }

    @SerialName("debt_amount")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getDebtAmount$annotations() {
    }

    @Serializable(with = LenientLong.class)
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("paid_amount")
    @Serializable(with = LenientDouble.class)
    public static /* synthetic */ void getPaidAmount$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PAYMENT_TYPE)
    public static /* synthetic */ void getPaymentType$annotations() {
    }

    @SerialName("sold_at")
    public static /* synthetic */ void getSoldAt$annotations() {
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

    /* renamed from: component10, reason: from getter */
    public final String getPaymentType() {
        return this.paymentType;
    }

    public final List<DebtSaleItem> component11() {
        return this.items;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTransactionId() {
        return this.transactionId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getCustomerId() {
        return this.customerId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCustomerName() {
        return this.customerName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCashierName() {
        return this.cashierName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSoldAt() {
        return this.soldAt;
    }

    /* renamed from: component7, reason: from getter */
    public final double getTotalAmount() {
        return this.totalAmount;
    }

    /* renamed from: component8, reason: from getter */
    public final double getPaidAmount() {
        return this.paidAmount;
    }

    /* renamed from: component9, reason: from getter */
    public final double getDebtAmount() {
        return this.debtAmount;
    }

    public final DebtSale copy(long id, String transactionId, long customerId, String customerName, String cashierName, String soldAt, double totalAmount, double paidAmount, double debtAmount, String paymentType, List<DebtSaleItem> items) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(soldAt, "soldAt");
        Intrinsics.checkNotNullParameter(items, "items");
        return new DebtSale(id, transactionId, customerId, customerName, cashierName, soldAt, totalAmount, paidAmount, debtAmount, paymentType, items);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DebtSale)) {
            return false;
        }
        DebtSale debtSale = (DebtSale) other;
        return this.id == debtSale.id && Intrinsics.areEqual(this.transactionId, debtSale.transactionId) && this.customerId == debtSale.customerId && Intrinsics.areEqual(this.customerName, debtSale.customerName) && Intrinsics.areEqual(this.cashierName, debtSale.cashierName) && Intrinsics.areEqual(this.soldAt, debtSale.soldAt) && Double.compare(this.totalAmount, debtSale.totalAmount) == 0 && Double.compare(this.paidAmount, debtSale.paidAmount) == 0 && Double.compare(this.debtAmount, debtSale.debtAmount) == 0 && Intrinsics.areEqual(this.paymentType, debtSale.paymentType) && Intrinsics.areEqual(this.items, debtSale.items);
    }

    public int hashCode() {
        int hashCode = ((((Long.hashCode(this.id) * 31) + this.transactionId.hashCode()) * 31) + Long.hashCode(this.customerId)) * 31;
        String str = this.customerName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.cashierName;
        int hashCode3 = (((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.soldAt.hashCode()) * 31) + Double.hashCode(this.totalAmount)) * 31) + Double.hashCode(this.paidAmount)) * 31) + Double.hashCode(this.debtAmount)) * 31;
        String str3 = this.paymentType;
        return ((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.items.hashCode();
    }

    public String toString() {
        return "DebtSale(id=" + this.id + ", transactionId=" + this.transactionId + ", customerId=" + this.customerId + ", customerName=" + this.customerName + ", cashierName=" + this.cashierName + ", soldAt=" + this.soldAt + ", totalAmount=" + this.totalAmount + ", paidAmount=" + this.paidAmount + ", debtAmount=" + this.debtAmount + ", paymentType=" + this.paymentType + ", items=" + this.items + ")";
    }

    /* compiled from: Money.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/DebtSale$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/DebtSale;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DebtSale> serializer() {
            return DebtSale$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DebtSale(int i, long j, String str, long j2, String str2, String str3, String str4, double d, double d2, double d3, String str5, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.id = 0L;
        } else {
            this.id = j;
        }
        if ((i & 2) == 0) {
            this.transactionId = "";
        } else {
            this.transactionId = str;
        }
        if ((i & 4) == 0) {
            this.customerId = 0L;
        } else {
            this.customerId = j2;
        }
        if ((i & 8) == 0) {
            this.customerName = null;
        } else {
            this.customerName = str2;
        }
        if ((i & 16) == 0) {
            this.cashierName = null;
        } else {
            this.cashierName = str3;
        }
        if ((i & 32) == 0) {
            this.soldAt = "";
        } else {
            this.soldAt = str4;
        }
        if ((i & 64) == 0) {
            this.totalAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.totalAmount = d;
        }
        if ((i & 128) == 0) {
            this.paidAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.paidAmount = d2;
        }
        if ((i & 256) == 0) {
            this.debtAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.debtAmount = d3;
        }
        if ((i & 512) == 0) {
            this.paymentType = null;
        } else {
            this.paymentType = str5;
        }
        this.items = (i & 1024) == 0 ? CollectionsKt.emptyList() : list;
    }

    public DebtSale(long j, String transactionId, long j2, String str, String str2, String soldAt, double d, double d2, double d3, String str3, List<DebtSaleItem> items) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(soldAt, "soldAt");
        Intrinsics.checkNotNullParameter(items, "items");
        this.id = j;
        this.transactionId = transactionId;
        this.customerId = j2;
        this.customerName = str;
        this.cashierName = str2;
        this.soldAt = soldAt;
        this.totalAmount = d;
        this.paidAmount = d2;
        this.debtAmount = d3;
        this.paymentType = str3;
        this.items = items;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(DebtSale self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != 0) {
            output.encodeSerializableElement(serialDesc, 0, LenientLong.INSTANCE, Long.valueOf(self.id));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.transactionId, "")) {
            output.encodeSerializableElement(serialDesc, 1, LenientString.INSTANCE, self.transactionId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.customerId != 0) {
            output.encodeSerializableElement(serialDesc, 2, LenientLong.INSTANCE, Long.valueOf(self.customerId));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.customerName != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.customerName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.cashierName != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.cashierName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.soldAt, "")) {
            output.encodeStringElement(serialDesc, 5, self.soldAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || Double.compare(self.totalAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 6, LenientDouble.INSTANCE, Double.valueOf(self.totalAmount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || Double.compare(self.paidAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 7, LenientDouble.INSTANCE, Double.valueOf(self.paidAmount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || Double.compare(self.debtAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeSerializableElement(serialDesc, 8, LenientDouble.INSTANCE, Double.valueOf(self.debtAmount));
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.paymentType != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.paymentType);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 10) && Intrinsics.areEqual(self.items, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 10, lazyArr[10].getValue(), self.items);
    }

    public /* synthetic */ DebtSale(long j, String str, long j2, String str2, String str3, String str4, double d, double d2, double d3, String str5, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str, (i & 4) == 0 ? j2 : 0L, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) == 0 ? str4 : "", (i & 64) != 0 ? 0.0d : d, (i & 128) != 0 ? 0.0d : d2, (i & 256) == 0 ? d3 : AudioStats.AUDIO_AMPLITUDE_NONE, (i & 512) == 0 ? str5 : null, (i & 1024) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final long getId() {
        return this.id;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public final long getCustomerId() {
        return this.customerId;
    }

    public final String getCustomerName() {
        return this.customerName;
    }

    public final String getCashierName() {
        return this.cashierName;
    }

    public final String getSoldAt() {
        return this.soldAt;
    }

    public final double getTotalAmount() {
        return this.totalAmount;
    }

    public final double getPaidAmount() {
        return this.paidAmount;
    }

    public final double getDebtAmount() {
        return this.debtAmount;
    }

    public final String getPaymentType() {
        return this.paymentType;
    }

    public final List<DebtSaleItem> getItems() {
        return this.items;
    }
}
