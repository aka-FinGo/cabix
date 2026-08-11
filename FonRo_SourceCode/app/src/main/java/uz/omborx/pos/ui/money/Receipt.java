package uz.FonRo.pos.ui.money;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.ReturnDoc;
import uz.FonRo.pos.data.model.SaleRow;
import uz.FonRo.pos.data.model.WriteOffReason;
import uz.FonRo.pos.ui.nav.Routes;

/* compiled from: Receipts.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\bH\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bó\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019\u0012\u0006\u0010\u001d\u001a\u00020\r\u0012\u0006\u0010\u001e\u001a\u00020\r\u0012\u0006\u0010\u001f\u001a\u00020 \u0012\u0006\u0010!\u001a\u00020\r\u0012\u0006\u0010\"\u001a\u00020\r\u0012\u0006\u0010#\u001a\u00020\r\u0012\u0006\u0010$\u001a\u00020 ¢\u0006\u0004\b%\u0010&J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\rHÆ\u0003J\t\u0010R\u001a\u00020\rHÆ\u0003J\t\u0010S\u001a\u00020\rHÆ\u0003J\t\u0010T\u001a\u00020\rHÆ\u0003J\t\u0010U\u001a\u00020\rHÆ\u0003J\t\u0010V\u001a\u00020\rHÆ\u0003J\t\u0010W\u001a\u00020\rHÆ\u0003J\t\u0010X\u001a\u00020\rHÆ\u0003J\t\u0010Y\u001a\u00020\rHÆ\u0003J\t\u0010Z\u001a\u00020\rHÆ\u0003J\t\u0010[\u001a\u00020\rHÆ\u0003J\u000f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019HÆ\u0003J\u000f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019HÆ\u0003J\t\u0010^\u001a\u00020\rHÆ\u0003J\t\u0010_\u001a\u00020\rHÆ\u0003J\t\u0010`\u001a\u00020 HÆ\u0003J\t\u0010a\u001a\u00020\rHÆ\u0003J\t\u0010b\u001a\u00020\rHÆ\u0003J\t\u0010c\u001a\u00020\rHÆ\u0003J\t\u0010d\u001a\u00020 HÆ\u0003J\u00ad\u0002\u0010e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00192\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\r2\b\b\u0002\u0010#\u001a\u00020\r2\b\b\u0002\u0010$\u001a\u00020 HÆ\u0001J\u0014\u0010f\u001a\u00020 2\b\u0010g\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010h\u001a\u00020iHÖ\u0081\u0004J\n\u0010j\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010(R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010(R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b3\u00102R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b4\u00102R\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b5\u00102R\u0011\u0010\u0011\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b6\u00102R\u0011\u0010\u0012\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b7\u00102R\u0011\u0010\u0013\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b8\u00102R\u0011\u0010\u0014\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b9\u00102R\u0011\u0010\u0015\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b:\u00102R\u0011\u0010\u0016\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b;\u00102R\u0011\u0010\u0017\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b<\u00102R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019¢\u0006\b\n\u0000\u001a\u0004\b?\u0010>R\u0011\u0010\u001d\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b@\u00102R\u0011\u0010\u001e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bA\u00102R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010!\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bD\u00102R\u0011\u0010\"\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bE\u00102R\u0011\u0010#\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bF\u00102R\u0011\u0010$\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b$\u0010CR\u0011\u0010G\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\bH\u0010CÊ\u0001\f\bl\u0012\b\bm\u0012\u0004\b\u0003\u0010\u0002¨\u0006k"}, d2 = {"Luz/FonRo/pos/ui/money/Receipt;", "", "transactionId", "", "saleId", "", "soldAt", "customerId", "customerName", "cashierName", "paymentType", "paymentStatus", "paidAmount", "", "receivedAmount", "changeAmount", "cashAmount", "cardAmount", "debtAmount", "discountAmount", "total", "profit", "qty", "returnedQty", FirebaseAnalytics.Param.ITEMS, "", "Luz/FonRo/pos/data/model/SaleRow;", Routes.RETURNS, "Luz/FonRo/pos/data/model/ReturnDoc;", "returnedTotal", "returnedProfit", "fullReturn", "", "netTotal", "netProfit", "netQty", "isDebt", "<init>", "(Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDDDDDDDDDDLjava/util/List;Ljava/util/List;DDZDDDZ)V", "getTransactionId", "()Ljava/lang/String;", "getSaleId", "()J", "getSoldAt", "getCustomerId", "getCustomerName", "getCashierName", "getPaymentType", "getPaymentStatus", "getPaidAmount", "()D", "getReceivedAmount", "getChangeAmount", "getCashAmount", "getCardAmount", "getDebtAmount", "getDiscountAmount", "getTotal", "getProfit", "getQty", "getReturnedQty", "getItems", "()Ljava/util/List;", "getReturns", "getReturnedTotal", "getReturnedProfit", "getFullReturn", "()Z", "getNetTotal", "getNetProfit", "getNetQty", "hasReturn", "getHasReturn", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "copy", "equals", WriteOffReason.OTHER, "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class Receipt {
    public static final int $stable = 0;
    private final double cardAmount;
    private final double cashAmount;
    private final String cashierName;
    private final double changeAmount;
    private final long customerId;
    private final String customerName;
    private final double debtAmount;
    private final double discountAmount;
    private final boolean fullReturn;
    private final boolean isDebt;
    private final List<SaleRow> items;
    private final double netProfit;
    private final double netQty;
    private final double netTotal;
    private final double paidAmount;
    private final String paymentStatus;
    private final String paymentType;
    private final double profit;
    private final double qty;
    private final double receivedAmount;
    private final double returnedProfit;
    private final double returnedQty;
    private final double returnedTotal;
    private final List<ReturnDoc> returns;
    private final long saleId;
    private final String soldAt;
    private final double total;
    private final String transactionId;

    public static /* synthetic */ Receipt copy$default(Receipt receipt, String str, long j, String str2, long j2, String str3, String str4, String str5, String str6, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, List list, List list2, double d12, double d13, boolean z, double d14, double d15, double d16, boolean z2, int i, Object obj) {
        boolean z3;
        double d17;
        double d18;
        double d19;
        List list3;
        List list4;
        double d20;
        double d21;
        boolean z4;
        double d22;
        double d23;
        double d24;
        double d25;
        double d26;
        double d27;
        double d28;
        double d29;
        double d30;
        double d31;
        String str7;
        long j3;
        String str8;
        String str9;
        String str10;
        String str11;
        double d32;
        String str12 = (i & 1) != 0 ? receipt.transactionId : str;
        long j4 = (i & 2) != 0 ? receipt.saleId : j;
        String str13 = (i & 4) != 0 ? receipt.soldAt : str2;
        long j5 = (i & 8) != 0 ? receipt.customerId : j2;
        String str14 = (i & 16) != 0 ? receipt.customerName : str3;
        String str15 = (i & 32) != 0 ? receipt.cashierName : str4;
        String str16 = (i & 64) != 0 ? receipt.paymentType : str5;
        String str17 = (i & 128) != 0 ? receipt.paymentStatus : str6;
        double d33 = (i & 256) != 0 ? receipt.paidAmount : d;
        double d34 = (i & 512) != 0 ? receipt.receivedAmount : d2;
        String str18 = str12;
        long j6 = j4;
        double d35 = (i & 1024) != 0 ? receipt.changeAmount : d3;
        double d36 = (i & 2048) != 0 ? receipt.cashAmount : d4;
        double d37 = (i & 4096) != 0 ? receipt.cardAmount : d5;
        double d38 = (i & 8192) != 0 ? receipt.debtAmount : d6;
        double d39 = (i & 16384) != 0 ? receipt.discountAmount : d7;
        double d40 = (i & 32768) != 0 ? receipt.total : d8;
        double d41 = d39;
        double d42 = (i & 65536) != 0 ? receipt.profit : d9;
        double d43 = (i & 131072) != 0 ? receipt.qty : d10;
        double d44 = (i & 262144) != 0 ? receipt.returnedQty : d11;
        List list5 = (i & 524288) != 0 ? receipt.items : list;
        List list6 = (i & 1048576) != 0 ? receipt.returns : list2;
        double d45 = (i & 2097152) != 0 ? receipt.returnedTotal : d12;
        double d46 = (i & 4194304) != 0 ? receipt.returnedProfit : d13;
        boolean z5 = (i & 8388608) != 0 ? receipt.fullReturn : z;
        double d47 = (i & 16777216) != 0 ? receipt.netTotal : d14;
        double d48 = (i & 33554432) != 0 ? receipt.netProfit : d15;
        double d49 = (i & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? receipt.netQty : d16;
        if ((i & 134217728) != 0) {
            d17 = d49;
            z3 = receipt.isDebt;
            d19 = d44;
            list3 = list5;
            list4 = list6;
            d20 = d45;
            d21 = d46;
            z4 = z5;
            d22 = d47;
            d23 = d48;
            d24 = d40;
            d26 = d35;
            d27 = d36;
            d28 = d37;
            d29 = d38;
            d30 = d41;
            d31 = d42;
            d18 = d43;
            str7 = str13;
            j3 = j5;
            str8 = str14;
            str9 = str15;
            str10 = str16;
            str11 = str17;
            d32 = d33;
            d25 = d34;
        } else {
            z3 = z2;
            d17 = d49;
            d18 = d43;
            d19 = d44;
            list3 = list5;
            list4 = list6;
            d20 = d45;
            d21 = d46;
            z4 = z5;
            d22 = d47;
            d23 = d48;
            d24 = d40;
            d25 = d34;
            d26 = d35;
            d27 = d36;
            d28 = d37;
            d29 = d38;
            d30 = d41;
            d31 = d42;
            str7 = str13;
            j3 = j5;
            str8 = str14;
            str9 = str15;
            str10 = str16;
            str11 = str17;
            d32 = d33;
        }
        return receipt.copy(str18, j6, str7, j3, str8, str9, str10, str11, d32, d25, d26, d27, d28, d29, d30, d24, d31, d18, d19, list3, list4, d20, d21, z4, d22, d23, d17, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTransactionId() {
        return this.transactionId;
    }

    /* renamed from: component10, reason: from getter */
    public final double getReceivedAmount() {
        return this.receivedAmount;
    }

    /* renamed from: component11, reason: from getter */
    public final double getChangeAmount() {
        return this.changeAmount;
    }

    /* renamed from: component12, reason: from getter */
    public final double getCashAmount() {
        return this.cashAmount;
    }

    /* renamed from: component13, reason: from getter */
    public final double getCardAmount() {
        return this.cardAmount;
    }

    /* renamed from: component14, reason: from getter */
    public final double getDebtAmount() {
        return this.debtAmount;
    }

    /* renamed from: component15, reason: from getter */
    public final double getDiscountAmount() {
        return this.discountAmount;
    }

    /* renamed from: component16, reason: from getter */
    public final double getTotal() {
        return this.total;
    }

    /* renamed from: component17, reason: from getter */
    public final double getProfit() {
        return this.profit;
    }

    /* renamed from: component18, reason: from getter */
    public final double getQty() {
        return this.qty;
    }

    /* renamed from: component19, reason: from getter */
    public final double getReturnedQty() {
        return this.returnedQty;
    }

    /* renamed from: component2, reason: from getter */
    public final long getSaleId() {
        return this.saleId;
    }

    public final List<SaleRow> component20() {
        return this.items;
    }

    public final List<ReturnDoc> component21() {
        return this.returns;
    }

    /* renamed from: component22, reason: from getter */
    public final double getReturnedTotal() {
        return this.returnedTotal;
    }

    /* renamed from: component23, reason: from getter */
    public final double getReturnedProfit() {
        return this.returnedProfit;
    }

    /* renamed from: component24, reason: from getter */
    public final boolean getFullReturn() {
        return this.fullReturn;
    }

    /* renamed from: component25, reason: from getter */
    public final double getNetTotal() {
        return this.netTotal;
    }

    /* renamed from: component26, reason: from getter */
    public final double getNetProfit() {
        return this.netProfit;
    }

    /* renamed from: component27, reason: from getter */
    public final double getNetQty() {
        return this.netQty;
    }

    /* renamed from: component28, reason: from getter */
    public final boolean getIsDebt() {
        return this.isDebt;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSoldAt() {
        return this.soldAt;
    }

    /* renamed from: component4, reason: from getter */
    public final long getCustomerId() {
        return this.customerId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCustomerName() {
        return this.customerName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCashierName() {
        return this.cashierName;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPaymentType() {
        return this.paymentType;
    }

    /* renamed from: component8, reason: from getter */
    public final String getPaymentStatus() {
        return this.paymentStatus;
    }

    /* renamed from: component9, reason: from getter */
    public final double getPaidAmount() {
        return this.paidAmount;
    }

    public final Receipt copy(String transactionId, long saleId, String soldAt, long customerId, String customerName, String cashierName, String paymentType, String paymentStatus, double paidAmount, double receivedAmount, double changeAmount, double cashAmount, double cardAmount, double debtAmount, double discountAmount, double total, double profit, double qty, double returnedQty, List<SaleRow> items, List<ReturnDoc> returns, double returnedTotal, double returnedProfit, boolean fullReturn, double netTotal, double netProfit, double netQty, boolean isDebt) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(soldAt, "soldAt");
        Intrinsics.checkNotNullParameter(customerName, "customerName");
        Intrinsics.checkNotNullParameter(cashierName, "cashierName");
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        Intrinsics.checkNotNullParameter(paymentStatus, "paymentStatus");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(returns, "returns");
        return new Receipt(transactionId, saleId, soldAt, customerId, customerName, cashierName, paymentType, paymentStatus, paidAmount, receivedAmount, changeAmount, cashAmount, cardAmount, debtAmount, discountAmount, total, profit, qty, returnedQty, items, returns, returnedTotal, returnedProfit, fullReturn, netTotal, netProfit, netQty, isDebt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Receipt)) {
            return false;
        }
        Receipt receipt = (Receipt) other;
        return Intrinsics.areEqual(this.transactionId, receipt.transactionId) && this.saleId == receipt.saleId && Intrinsics.areEqual(this.soldAt, receipt.soldAt) && this.customerId == receipt.customerId && Intrinsics.areEqual(this.customerName, receipt.customerName) && Intrinsics.areEqual(this.cashierName, receipt.cashierName) && Intrinsics.areEqual(this.paymentType, receipt.paymentType) && Intrinsics.areEqual(this.paymentStatus, receipt.paymentStatus) && Double.compare(this.paidAmount, receipt.paidAmount) == 0 && Double.compare(this.receivedAmount, receipt.receivedAmount) == 0 && Double.compare(this.changeAmount, receipt.changeAmount) == 0 && Double.compare(this.cashAmount, receipt.cashAmount) == 0 && Double.compare(this.cardAmount, receipt.cardAmount) == 0 && Double.compare(this.debtAmount, receipt.debtAmount) == 0 && Double.compare(this.discountAmount, receipt.discountAmount) == 0 && Double.compare(this.total, receipt.total) == 0 && Double.compare(this.profit, receipt.profit) == 0 && Double.compare(this.qty, receipt.qty) == 0 && Double.compare(this.returnedQty, receipt.returnedQty) == 0 && Intrinsics.areEqual(this.items, receipt.items) && Intrinsics.areEqual(this.returns, receipt.returns) && Double.compare(this.returnedTotal, receipt.returnedTotal) == 0 && Double.compare(this.returnedProfit, receipt.returnedProfit) == 0 && this.fullReturn == receipt.fullReturn && Double.compare(this.netTotal, receipt.netTotal) == 0 && Double.compare(this.netProfit, receipt.netProfit) == 0 && Double.compare(this.netQty, receipt.netQty) == 0 && this.isDebt == receipt.isDebt;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((this.transactionId.hashCode() * 31) + Long.hashCode(this.saleId)) * 31) + this.soldAt.hashCode()) * 31) + Long.hashCode(this.customerId)) * 31) + this.customerName.hashCode()) * 31) + this.cashierName.hashCode()) * 31) + this.paymentType.hashCode()) * 31) + this.paymentStatus.hashCode()) * 31) + Double.hashCode(this.paidAmount)) * 31) + Double.hashCode(this.receivedAmount)) * 31) + Double.hashCode(this.changeAmount)) * 31) + Double.hashCode(this.cashAmount)) * 31) + Double.hashCode(this.cardAmount)) * 31) + Double.hashCode(this.debtAmount)) * 31) + Double.hashCode(this.discountAmount)) * 31) + Double.hashCode(this.total)) * 31) + Double.hashCode(this.profit)) * 31) + Double.hashCode(this.qty)) * 31) + Double.hashCode(this.returnedQty)) * 31) + this.items.hashCode()) * 31) + this.returns.hashCode()) * 31) + Double.hashCode(this.returnedTotal)) * 31) + Double.hashCode(this.returnedProfit)) * 31) + Boolean.hashCode(this.fullReturn)) * 31) + Double.hashCode(this.netTotal)) * 31) + Double.hashCode(this.netProfit)) * 31) + Double.hashCode(this.netQty)) * 31) + Boolean.hashCode(this.isDebt);
    }

    public String toString() {
        return "Receipt(transactionId=" + this.transactionId + ", saleId=" + this.saleId + ", soldAt=" + this.soldAt + ", customerId=" + this.customerId + ", customerName=" + this.customerName + ", cashierName=" + this.cashierName + ", paymentType=" + this.paymentType + ", paymentStatus=" + this.paymentStatus + ", paidAmount=" + this.paidAmount + ", receivedAmount=" + this.receivedAmount + ", changeAmount=" + this.changeAmount + ", cashAmount=" + this.cashAmount + ", cardAmount=" + this.cardAmount + ", debtAmount=" + this.debtAmount + ", discountAmount=" + this.discountAmount + ", total=" + this.total + ", profit=" + this.profit + ", qty=" + this.qty + ", returnedQty=" + this.returnedQty + ", items=" + this.items + ", returns=" + this.returns + ", returnedTotal=" + this.returnedTotal + ", returnedProfit=" + this.returnedProfit + ", fullReturn=" + this.fullReturn + ", netTotal=" + this.netTotal + ", netProfit=" + this.netProfit + ", netQty=" + this.netQty + ", isDebt=" + this.isDebt + ")";
    }

    public Receipt(String transactionId, long j, String soldAt, long j2, String customerName, String cashierName, String paymentType, String paymentStatus, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, List<SaleRow> items, List<ReturnDoc> returns, double d12, double d13, boolean z, double d14, double d15, double d16, boolean z2) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(soldAt, "soldAt");
        Intrinsics.checkNotNullParameter(customerName, "customerName");
        Intrinsics.checkNotNullParameter(cashierName, "cashierName");
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        Intrinsics.checkNotNullParameter(paymentStatus, "paymentStatus");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(returns, "returns");
        this.transactionId = transactionId;
        this.saleId = j;
        this.soldAt = soldAt;
        this.customerId = j2;
        this.customerName = customerName;
        this.cashierName = cashierName;
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
        this.paidAmount = d;
        this.receivedAmount = d2;
        this.changeAmount = d3;
        this.cashAmount = d4;
        this.cardAmount = d5;
        this.debtAmount = d6;
        this.discountAmount = d7;
        this.total = d8;
        this.profit = d9;
        this.qty = d10;
        this.returnedQty = d11;
        this.items = items;
        this.returns = returns;
        this.returnedTotal = d12;
        this.returnedProfit = d13;
        this.fullReturn = z;
        this.netTotal = d14;
        this.netProfit = d15;
        this.netQty = d16;
        this.isDebt = z2;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public final long getSaleId() {
        return this.saleId;
    }

    public final String getSoldAt() {
        return this.soldAt;
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

    public final String getPaymentType() {
        return this.paymentType;
    }

    public final String getPaymentStatus() {
        return this.paymentStatus;
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

    public final double getDebtAmount() {
        return this.debtAmount;
    }

    public final double getDiscountAmount() {
        return this.discountAmount;
    }

    public final double getTotal() {
        return this.total;
    }

    public final double getProfit() {
        return this.profit;
    }

    public final double getQty() {
        return this.qty;
    }

    public final double getReturnedQty() {
        return this.returnedQty;
    }

    public final List<SaleRow> getItems() {
        return this.items;
    }

    public final List<ReturnDoc> getReturns() {
        return this.returns;
    }

    public final double getReturnedTotal() {
        return this.returnedTotal;
    }

    public final double getReturnedProfit() {
        return this.returnedProfit;
    }

    public final boolean getFullReturn() {
        return this.fullReturn;
    }

    public final double getNetTotal() {
        return this.netTotal;
    }

    public final double getNetProfit() {
        return this.netProfit;
    }

    public final double getNetQty() {
        return this.netQty;
    }

    public final boolean isDebt() {
        return this.isDebt;
    }

    public final boolean getHasReturn() {
        return this.returnedTotal > 0.001d || this.returnedQty > 0.001d;
    }
}
