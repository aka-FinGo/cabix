package uz.FonRo.pos.data.model;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Sales.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u0000 Z2\u00020\u0001:\u0002YZBu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013B\u0081\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0012\u0010\u0018J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\tHÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\fHÆ\u0003J\t\u0010E\u001a\u00020\tHÆ\u0003J\t\u0010F\u001a\u00020\tHÆ\u0003J\t\u0010G\u001a\u00020\tHÆ\u0003J\t\u0010H\u001a\u00020\tHÆ\u0003J\t\u0010I\u001a\u00020\tHÆ\u0003J}\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\tHÆ\u0001J\u0014\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010N\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010O\u001a\u00020\u0003HÖ\u0081\u0004J)\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0001b\u0002\bX¢\u0006\u0002\bWR*\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R*\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b($¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001cR*\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b((¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010'R*\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(+¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u001a\u001a\u0004\b*\u0010\u001cR*\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(/¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001a\u001a\u0004\b-\u0010.R*\u0010\r\u001a\u00020\t8\u0006X\u0087\u0004r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(2¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u001a\u001a\u0004\b1\u0010'R*\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(5¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u001a\u001a\u0004\b4\u0010'R*\u0010\u000f\u001a\u00020\t8\u0006X\u0087\u0004r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(8¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u001a\u001a\u0004\b7\u0010'R*\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(;¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010\u001a\u001a\u0004\b:\u0010'R*\u0010\u0011\u001a\u00020\t8\u0006X\u0087\u0004r\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(>¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010\u001a\u001a\u0004\b=\u0010'Ê\u0001\u0002\b\\Ê\u0001\f\b]\u0012\b\b^\u0012\u0004\b\u0003\u0010\u0000¨\u0006["}, d2 = {"Luz/FonRo/pos/data/model/SaleBody;", "", "transactionId", "", FirebaseAnalytics.Param.ITEMS, "", "Luz/FonRo/pos/data/model/SaleItemBody;", "discountType", "discountValue", "", "paymentType", "customerId", "", "paidAmount", "receivedAmount", "changeAmount", "cashAmount", "cardAmount", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;DLjava/lang/String;JDDDDD)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;DLjava/lang/String;JDDDDDLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTransactionId$annotations", "()V", "getTransactionId", "()Ljava/lang/String;", "Lkotlinx/serialization/SerialName;", "value", FirebaseAnalytics.Param.TRANSACTION_ID, "getItems", "()Ljava/util/List;", "getDiscountType$annotations", "getDiscountType", "discount_type", "getDiscountValue$annotations", "getDiscountValue", "()D", "discount_value", "getPaymentType$annotations", "getPaymentType", FirebaseAnalytics.Param.PAYMENT_TYPE, "getCustomerId$annotations", "getCustomerId", "()J", "customer_id", "getPaidAmount$annotations", "getPaidAmount", "paid_amount", "getReceivedAmount$annotations", "getReceivedAmount", "received_amount", "getChangeAmount$annotations", "getChangeAmount", "change_amount", "getCashAmount$annotations", "getCashAmount", "cash_amount", "getCardAmount$annotations", "getCardAmount", "card_amount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app", "Lkotlin/jvm/JvmStatic;", "$serializer", "Companion", "app", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class SaleBody {
    private final double cardAmount;
    private final double cashAmount;
    private final double changeAmount;
    private final long customerId;
    private final String discountType;
    private final double discountValue;
    private final List<SaleItemBody> items;
    private final double paidAmount;
    private final String paymentType;
    private final double receivedAmount;
    private final String transactionId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: uz.FonRo.pos.data.model.SaleBody$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = SaleBody._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, null, null, null, null, null};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(SaleItemBody$$serializer.INSTANCE);
    }

    public static /* synthetic */ SaleBody copy$default(SaleBody saleBody, String str, List list, String str2, double d, String str3, long j, double d2, double d3, double d4, double d5, double d6, int i, Object obj) {
        double d7;
        double d8;
        List list2;
        String str4;
        double d9;
        String str5;
        long j2;
        double d10;
        double d11;
        double d12;
        String str6 = (i & 1) != 0 ? saleBody.transactionId : str;
        List list3 = (i & 2) != 0 ? saleBody.items : list;
        String str7 = (i & 4) != 0 ? saleBody.discountType : str2;
        double d13 = (i & 8) != 0 ? saleBody.discountValue : d;
        String str8 = (i & 16) != 0 ? saleBody.paymentType : str3;
        long j3 = (i & 32) != 0 ? saleBody.customerId : j;
        double d14 = (i & 64) != 0 ? saleBody.paidAmount : d2;
        double d15 = (i & 128) != 0 ? saleBody.receivedAmount : d3;
        double d16 = (i & 256) != 0 ? saleBody.changeAmount : d4;
        String str9 = str6;
        List list4 = list3;
        double d17 = (i & 512) != 0 ? saleBody.cashAmount : d5;
        if ((i & 1024) != 0) {
            d8 = d17;
            d7 = saleBody.cardAmount;
            str4 = str7;
            d9 = d13;
            str5 = str8;
            j2 = j3;
            d10 = d14;
            d11 = d15;
            d12 = d16;
            list2 = list4;
        } else {
            d7 = d6;
            d8 = d17;
            list2 = list4;
            str4 = str7;
            d9 = d13;
            str5 = str8;
            j2 = j3;
            d10 = d14;
            d11 = d15;
            d12 = d16;
        }
        return saleBody.copy(str9, list2, str4, d9, str5, j2, d10, d11, d12, d8, d7);
    }

    @SerialName("card_amount")
    public static /* synthetic */ void getCardAmount$annotations() {
    }

    @SerialName("cash_amount")
    public static /* synthetic */ void getCashAmount$annotations() {
    }

    @SerialName("change_amount")
    public static /* synthetic */ void getChangeAmount$annotations() {
    }

    @SerialName("customer_id")
    public static /* synthetic */ void getCustomerId$annotations() {
    }

    @SerialName("discount_type")
    public static /* synthetic */ void getDiscountType$annotations() {
    }

    @SerialName("discount_value")
    public static /* synthetic */ void getDiscountValue$annotations() {
    }

    @SerialName("paid_amount")
    public static /* synthetic */ void getPaidAmount$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PAYMENT_TYPE)
    public static /* synthetic */ void getPaymentType$annotations() {
    }

    @SerialName("received_amount")
    public static /* synthetic */ void getReceivedAmount$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.TRANSACTION_ID)
    public static /* synthetic */ void getTransactionId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getTransactionId() {
        return this.transactionId;
    }

    /* renamed from: component10, reason: from getter */
    public final double getCashAmount() {
        return this.cashAmount;
    }

    /* renamed from: component11, reason: from getter */
    public final double getCardAmount() {
        return this.cardAmount;
    }

    public final List<SaleItemBody> component2() {
        return this.items;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDiscountType() {
        return this.discountType;
    }

    /* renamed from: component4, reason: from getter */
    public final double getDiscountValue() {
        return this.discountValue;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPaymentType() {
        return this.paymentType;
    }

    /* renamed from: component6, reason: from getter */
    public final long getCustomerId() {
        return this.customerId;
    }

    /* renamed from: component7, reason: from getter */
    public final double getPaidAmount() {
        return this.paidAmount;
    }

    /* renamed from: component8, reason: from getter */
    public final double getReceivedAmount() {
        return this.receivedAmount;
    }

    /* renamed from: component9, reason: from getter */
    public final double getChangeAmount() {
        return this.changeAmount;
    }

    public final SaleBody copy(String transactionId, List<SaleItemBody> items, String discountType, double discountValue, String paymentType, long customerId, double paidAmount, double receivedAmount, double changeAmount, double cashAmount, double cardAmount) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(discountType, "discountType");
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        return new SaleBody(transactionId, items, discountType, discountValue, paymentType, customerId, paidAmount, receivedAmount, changeAmount, cashAmount, cardAmount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleBody)) {
            return false;
        }
        SaleBody saleBody = (SaleBody) other;
        return Intrinsics.areEqual(this.transactionId, saleBody.transactionId) && Intrinsics.areEqual(this.items, saleBody.items) && Intrinsics.areEqual(this.discountType, saleBody.discountType) && Double.compare(this.discountValue, saleBody.discountValue) == 0 && Intrinsics.areEqual(this.paymentType, saleBody.paymentType) && this.customerId == saleBody.customerId && Double.compare(this.paidAmount, saleBody.paidAmount) == 0 && Double.compare(this.receivedAmount, saleBody.receivedAmount) == 0 && Double.compare(this.changeAmount, saleBody.changeAmount) == 0 && Double.compare(this.cashAmount, saleBody.cashAmount) == 0 && Double.compare(this.cardAmount, saleBody.cardAmount) == 0;
    }

    public int hashCode() {
        return (((((((((((((((((((this.transactionId.hashCode() * 31) + this.items.hashCode()) * 31) + this.discountType.hashCode()) * 31) + Double.hashCode(this.discountValue)) * 31) + this.paymentType.hashCode()) * 31) + Long.hashCode(this.customerId)) * 31) + Double.hashCode(this.paidAmount)) * 31) + Double.hashCode(this.receivedAmount)) * 31) + Double.hashCode(this.changeAmount)) * 31) + Double.hashCode(this.cashAmount)) * 31) + Double.hashCode(this.cardAmount);
    }

    public String toString() {
        return "SaleBody(transactionId=" + this.transactionId + ", items=" + this.items + ", discountType=" + this.discountType + ", discountValue=" + this.discountValue + ", paymentType=" + this.paymentType + ", customerId=" + this.customerId + ", paidAmount=" + this.paidAmount + ", receivedAmount=" + this.receivedAmount + ", changeAmount=" + this.changeAmount + ", cashAmount=" + this.cashAmount + ", cardAmount=" + this.cardAmount + ")";
    }

    /* compiled from: Sales.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Luz/FonRo/pos/data/model/SaleBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Luz/FonRo/pos/data/model/SaleBody;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SaleBody> serializer() {
            return SaleBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SaleBody(int i, String str, List list, String str2, double d, String str3, long j, double d2, double d3, double d4, double d5, double d6, SerializationConstructorMarker serializationConstructorMarker) {
        if (19 != (i & 19)) {
            PluginExceptionsKt.throwMissingFieldException(i, 19, SaleBody$$serializer.INSTANCE.getDescriptor());
        }
        this.transactionId = str;
        this.items = list;
        if ((i & 4) == 0) {
            this.discountType = "amount";
        } else {
            this.discountType = str2;
        }
        if ((i & 8) == 0) {
            this.discountValue = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.discountValue = d;
        }
        this.paymentType = str3;
        if ((i & 32) == 0) {
            this.customerId = 0L;
        } else {
            this.customerId = j;
        }
        if ((i & 64) == 0) {
            this.paidAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.paidAmount = d2;
        }
        if ((i & 128) == 0) {
            this.receivedAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.receivedAmount = d3;
        }
        if ((i & 256) == 0) {
            this.changeAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.changeAmount = d4;
        }
        if ((i & 512) == 0) {
            this.cashAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.cashAmount = d5;
        }
        if ((i & 1024) == 0) {
            this.cardAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            this.cardAmount = d6;
        }
    }

    public SaleBody(String transactionId, List<SaleItemBody> items, String discountType, double d, String paymentType, long j, double d2, double d3, double d4, double d5, double d6) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(discountType, "discountType");
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        this.transactionId = transactionId;
        this.items = items;
        this.discountType = discountType;
        this.discountValue = d;
        this.paymentType = paymentType;
        this.customerId = j;
        this.paidAmount = d2;
        this.receivedAmount = d3;
        this.changeAmount = d4;
        this.cashAmount = d5;
        this.cardAmount = d6;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app(SaleBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.transactionId);
        output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.items);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.discountType, "amount")) {
            output.encodeStringElement(serialDesc, 2, self.discountType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || Double.compare(self.discountValue, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeDoubleElement(serialDesc, 3, self.discountValue);
        }
        output.encodeStringElement(serialDesc, 4, self.paymentType);
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.customerId != 0) {
            output.encodeLongElement(serialDesc, 5, self.customerId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || Double.compare(self.paidAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeDoubleElement(serialDesc, 6, self.paidAmount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || Double.compare(self.receivedAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeDoubleElement(serialDesc, 7, self.receivedAmount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || Double.compare(self.changeAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeDoubleElement(serialDesc, 8, self.changeAmount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || Double.compare(self.cashAmount, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) {
            output.encodeDoubleElement(serialDesc, 9, self.cashAmount);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 10) && Double.compare(self.cardAmount, AudioStats.AUDIO_AMPLITUDE_NONE) == 0) {
            return;
        }
        output.encodeDoubleElement(serialDesc, 10, self.cardAmount);
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public final List<SaleItemBody> getItems() {
        return this.items;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ SaleBody(java.lang.String r22, java.util.List r23, java.lang.String r24, double r25, java.lang.String r27, long r28, double r30, double r32, double r34, double r36, double r38, int r40, kotlin.jvm.internal.DefaultConstructorMarker r41) {
        /*
            r21 = this;
            r0 = r40
            r1 = r0 & 4
            if (r1 == 0) goto La
            java.lang.String r1 = "amount"
            r5 = r1
            goto Lc
        La:
            r5 = r24
        Lc:
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L14
            r6 = r2
            goto L16
        L14:
            r6 = r25
        L16:
            r1 = r0 & 32
            if (r1 == 0) goto L1e
            r8 = 0
            r9 = r8
            goto L20
        L1e:
            r9 = r28
        L20:
            r1 = r0 & 64
            if (r1 == 0) goto L26
            r11 = r2
            goto L28
        L26:
            r11 = r30
        L28:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L2e
            r13 = r2
            goto L30
        L2e:
            r13 = r32
        L30:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L36
            r15 = r2
            goto L38
        L36:
            r15 = r34
        L38:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L3f
            r17 = r2
            goto L41
        L3f:
            r17 = r36
        L41:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L50
            r19 = r2
            r4 = r23
            r8 = r27
            r2 = r21
            r3 = r22
            goto L5a
        L50:
            r19 = r38
            r2 = r21
            r3 = r22
            r4 = r23
            r8 = r27
        L5a:
            r2.<init>(r3, r4, r5, r6, r8, r9, r11, r13, r15, r17, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.data.model.SaleBody.<init>(java.lang.String, java.util.List, java.lang.String, double, java.lang.String, long, double, double, double, double, double, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getDiscountType() {
        return this.discountType;
    }

    public final double getDiscountValue() {
        return this.discountValue;
    }

    public final String getPaymentType() {
        return this.paymentType;
    }

    public final long getCustomerId() {
        return this.customerId;
    }

    public final double getPaidAmount() {
        return this.paidAmount;
    }

    public final double getReceivedAmount() {
        return this.receivedAmount;
    }

    public final double getChangeAmount() {
        return this.changeAmount;
    }

    public final double getCashAmount() {
        return this.cashAmount;
    }

    public final double getCardAmount() {
        return this.cardAmount;
    }
}
