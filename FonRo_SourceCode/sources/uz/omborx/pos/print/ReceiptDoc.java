package uz.FonRo.pos.print;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: ReceiptDoc.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000f0\fHÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00110\fHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u009d\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0014\u00102\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00104\u001a\u000205HÖ\u0081\u0004J\n\u00106\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017Ê\u0001\f\b8\u0012\b\b9\u0012\u0004\b\u0003\u0010\u0002¨\u00067"}, d2 = {"Luz/FonRo/pos/print/ReceiptDoc;", "", "receiptNumber", "", "dateText", "paymentText", "statusText", "statusFilled", "", "customer", "itemsCountText", "lines", "", "Luz/FonRo/pos/print/ReceiptLine;", "totals", "Luz/FonRo/pos/print/ReceiptTotal;", "paySection", "Luz/FonRo/pos/print/ReceiptPay;", "qrText", "footer", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getReceiptNumber", "()Ljava/lang/String;", "getDateText", "getPaymentText", "getStatusText", "getStatusFilled", "()Z", "getCustomer", "getItemsCountText", "getLines", "()Ljava/util/List;", "getTotals", "getPaySection", "getQrText", "getFooter", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", WriteOffReason.OTHER, "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final /* data */ class ReceiptDoc {
    public static final int $stable = 0;
    private final String customer;
    private final String dateText;
    private final String footer;
    private final String itemsCountText;
    private final List<ReceiptLine> lines;
    private final List<ReceiptPay> paySection;
    private final String paymentText;
    private final String qrText;
    private final String receiptNumber;
    private final boolean statusFilled;
    private final String statusText;
    private final List<ReceiptTotal> totals;

    public static /* synthetic */ ReceiptDoc copy$default(ReceiptDoc receiptDoc, String str, String str2, String str3, String str4, boolean z, String str5, String str6, List list, List list2, List list3, String str7, String str8, int i, Object obj) {
        if ((i & 1) != 0) {
            str = receiptDoc.receiptNumber;
        }
        if ((i & 2) != 0) {
            str2 = receiptDoc.dateText;
        }
        if ((i & 4) != 0) {
            str3 = receiptDoc.paymentText;
        }
        if ((i & 8) != 0) {
            str4 = receiptDoc.statusText;
        }
        if ((i & 16) != 0) {
            z = receiptDoc.statusFilled;
        }
        if ((i & 32) != 0) {
            str5 = receiptDoc.customer;
        }
        if ((i & 64) != 0) {
            str6 = receiptDoc.itemsCountText;
        }
        if ((i & 128) != 0) {
            list = receiptDoc.lines;
        }
        if ((i & 256) != 0) {
            list2 = receiptDoc.totals;
        }
        if ((i & 512) != 0) {
            list3 = receiptDoc.paySection;
        }
        if ((i & 1024) != 0) {
            str7 = receiptDoc.qrText;
        }
        if ((i & 2048) != 0) {
            str8 = receiptDoc.footer;
        }
        String str9 = str7;
        String str10 = str8;
        List list4 = list2;
        List list5 = list3;
        String str11 = str6;
        List list6 = list;
        boolean z2 = z;
        String str12 = str5;
        return receiptDoc.copy(str, str2, str3, str4, z2, str12, str11, list6, list4, list5, str9, str10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getReceiptNumber() {
        return this.receiptNumber;
    }

    public final List<ReceiptPay> component10() {
        return this.paySection;
    }

    /* renamed from: component11, reason: from getter */
    public final String getQrText() {
        return this.qrText;
    }

    /* renamed from: component12, reason: from getter */
    public final String getFooter() {
        return this.footer;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDateText() {
        return this.dateText;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPaymentText() {
        return this.paymentText;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStatusText() {
        return this.statusText;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getStatusFilled() {
        return this.statusFilled;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCustomer() {
        return this.customer;
    }

    /* renamed from: component7, reason: from getter */
    public final String getItemsCountText() {
        return this.itemsCountText;
    }

    public final List<ReceiptLine> component8() {
        return this.lines;
    }

    public final List<ReceiptTotal> component9() {
        return this.totals;
    }

    public final ReceiptDoc copy(String receiptNumber, String dateText, String paymentText, String statusText, boolean statusFilled, String customer, String itemsCountText, List<ReceiptLine> lines, List<ReceiptTotal> totals, List<ReceiptPay> paySection, String qrText, String footer) {
        Intrinsics.checkNotNullParameter(receiptNumber, "receiptNumber");
        Intrinsics.checkNotNullParameter(dateText, "dateText");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(totals, "totals");
        Intrinsics.checkNotNullParameter(paySection, "paySection");
        Intrinsics.checkNotNullParameter(footer, "footer");
        return new ReceiptDoc(receiptNumber, dateText, paymentText, statusText, statusFilled, customer, itemsCountText, lines, totals, paySection, qrText, footer);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReceiptDoc)) {
            return false;
        }
        ReceiptDoc receiptDoc = (ReceiptDoc) other;
        return Intrinsics.areEqual(this.receiptNumber, receiptDoc.receiptNumber) && Intrinsics.areEqual(this.dateText, receiptDoc.dateText) && Intrinsics.areEqual(this.paymentText, receiptDoc.paymentText) && Intrinsics.areEqual(this.statusText, receiptDoc.statusText) && this.statusFilled == receiptDoc.statusFilled && Intrinsics.areEqual(this.customer, receiptDoc.customer) && Intrinsics.areEqual(this.itemsCountText, receiptDoc.itemsCountText) && Intrinsics.areEqual(this.lines, receiptDoc.lines) && Intrinsics.areEqual(this.totals, receiptDoc.totals) && Intrinsics.areEqual(this.paySection, receiptDoc.paySection) && Intrinsics.areEqual(this.qrText, receiptDoc.qrText) && Intrinsics.areEqual(this.footer, receiptDoc.footer);
    }

    public int hashCode() {
        int hashCode = ((this.receiptNumber.hashCode() * 31) + this.dateText.hashCode()) * 31;
        String str = this.paymentText;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.statusText;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.statusFilled)) * 31;
        String str3 = this.customer;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.itemsCountText;
        int hashCode5 = (((((((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.lines.hashCode()) * 31) + this.totals.hashCode()) * 31) + this.paySection.hashCode()) * 31;
        String str5 = this.qrText;
        return ((hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.footer.hashCode();
    }

    public String toString() {
        return "ReceiptDoc(receiptNumber=" + this.receiptNumber + ", dateText=" + this.dateText + ", paymentText=" + this.paymentText + ", statusText=" + this.statusText + ", statusFilled=" + this.statusFilled + ", customer=" + this.customer + ", itemsCountText=" + this.itemsCountText + ", lines=" + this.lines + ", totals=" + this.totals + ", paySection=" + this.paySection + ", qrText=" + this.qrText + ", footer=" + this.footer + ")";
    }

    public ReceiptDoc(String receiptNumber, String dateText, String str, String str2, boolean z, String str3, String str4, List<ReceiptLine> lines, List<ReceiptTotal> totals, List<ReceiptPay> paySection, String str5, String footer) {
        Intrinsics.checkNotNullParameter(receiptNumber, "receiptNumber");
        Intrinsics.checkNotNullParameter(dateText, "dateText");
        Intrinsics.checkNotNullParameter(lines, "lines");
        Intrinsics.checkNotNullParameter(totals, "totals");
        Intrinsics.checkNotNullParameter(paySection, "paySection");
        Intrinsics.checkNotNullParameter(footer, "footer");
        this.receiptNumber = receiptNumber;
        this.dateText = dateText;
        this.paymentText = str;
        this.statusText = str2;
        this.statusFilled = z;
        this.customer = str3;
        this.itemsCountText = str4;
        this.lines = lines;
        this.totals = totals;
        this.paySection = paySection;
        this.qrText = str5;
        this.footer = footer;
    }

    public final String getReceiptNumber() {
        return this.receiptNumber;
    }

    public final String getDateText() {
        return this.dateText;
    }

    public final String getPaymentText() {
        return this.paymentText;
    }

    public final String getStatusText() {
        return this.statusText;
    }

    public final boolean getStatusFilled() {
        return this.statusFilled;
    }

    public final String getCustomer() {
        return this.customer;
    }

    public final String getItemsCountText() {
        return this.itemsCountText;
    }

    public /* synthetic */ ReceiptDoc(String str, String str2, String str3, String str4, boolean z, String str5, String str6, List list, List list2, List list3, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? false : z, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? CollectionsKt.emptyList() : list, (i & 256) != 0 ? CollectionsKt.emptyList() : list2, (i & 512) != 0 ? CollectionsKt.emptyList() : list3, (i & 1024) != 0 ? null : str7, (i & 2048) != 0 ? "Спасибо за покупку!" : str8);
    }

    public final List<ReceiptLine> getLines() {
        return this.lines;
    }

    public final List<ReceiptTotal> getTotals() {
        return this.totals;
    }

    public final List<ReceiptPay> getPaySection() {
        return this.paySection;
    }

    public final String getQrText() {
        return this.qrText;
    }

    public final String getFooter() {
        return this.footer;
    }
}
