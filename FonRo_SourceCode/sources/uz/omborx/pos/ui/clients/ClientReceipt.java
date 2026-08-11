package uz.FonRo.pos.ui.clients;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ClientsScreen.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J_\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\nHÆ\u0001J\u0014\u0010+\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010-\u001a\u00020.HÖ\u0081\u0004J\n\u0010/\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u001c\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010 R\u0011\u0010!\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b!\u0010 ¨\u00060"}, d2 = {"Luz/FonRo/pos/ui/clients/ClientReceipt;", "", "transactionId", "", "saleId", "", "soldAt", "itemNames", "", "gross", "", "returned", "paid", "debt", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/util/List;DDDD)V", "getTransactionId", "()Ljava/lang/String;", "getSaleId", "()J", "getSoldAt", "getItemNames", "()Ljava/util/List;", "getGross", "()D", "getReturned", "getPaid", "getDebt", "net", "getNet", "isReturned", "", "()Z", "isPaid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", WriteOffReason.OTHER, "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class ClientReceipt {
    private final double debt;
    private final double gross;
    private final List<String> itemNames;
    private final double paid;
    private final double returned;
    private final long saleId;
    private final String soldAt;
    private final String transactionId;

    /* renamed from: component1, reason: from getter */
    public final String getTransactionId() {
        return this.transactionId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getSaleId() {
        return this.saleId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSoldAt() {
        return this.soldAt;
    }

    public final List<String> component4() {
        return this.itemNames;
    }

    /* renamed from: component5, reason: from getter */
    public final double getGross() {
        return this.gross;
    }

    /* renamed from: component6, reason: from getter */
    public final double getReturned() {
        return this.returned;
    }

    /* renamed from: component7, reason: from getter */
    public final double getPaid() {
        return this.paid;
    }

    /* renamed from: component8, reason: from getter */
    public final double getDebt() {
        return this.debt;
    }

    public final ClientReceipt copy(String transactionId, long saleId, String soldAt, List<String> itemNames, double gross, double returned, double paid, double debt) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(soldAt, "soldAt");
        Intrinsics.checkNotNullParameter(itemNames, "itemNames");
        return new ClientReceipt(transactionId, saleId, soldAt, itemNames, gross, returned, paid, debt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClientReceipt)) {
            return false;
        }
        ClientReceipt clientReceipt = (ClientReceipt) other;
        return Intrinsics.areEqual(this.transactionId, clientReceipt.transactionId) && this.saleId == clientReceipt.saleId && Intrinsics.areEqual(this.soldAt, clientReceipt.soldAt) && Intrinsics.areEqual(this.itemNames, clientReceipt.itemNames) && Double.compare(this.gross, clientReceipt.gross) == 0 && Double.compare(this.returned, clientReceipt.returned) == 0 && Double.compare(this.paid, clientReceipt.paid) == 0 && Double.compare(this.debt, clientReceipt.debt) == 0;
    }

    public int hashCode() {
        return (((((((((((((this.transactionId.hashCode() * 31) + Long.hashCode(this.saleId)) * 31) + this.soldAt.hashCode()) * 31) + this.itemNames.hashCode()) * 31) + Double.hashCode(this.gross)) * 31) + Double.hashCode(this.returned)) * 31) + Double.hashCode(this.paid)) * 31) + Double.hashCode(this.debt);
    }

    public String toString() {
        return "ClientReceipt(transactionId=" + this.transactionId + ", saleId=" + this.saleId + ", soldAt=" + this.soldAt + ", itemNames=" + this.itemNames + ", gross=" + this.gross + ", returned=" + this.returned + ", paid=" + this.paid + ", debt=" + this.debt + ")";
    }

    public ClientReceipt(String transactionId, long j, String soldAt, List<String> itemNames, double d, double d2, double d3, double d4) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(soldAt, "soldAt");
        Intrinsics.checkNotNullParameter(itemNames, "itemNames");
        this.transactionId = transactionId;
        this.saleId = j;
        this.soldAt = soldAt;
        this.itemNames = itemNames;
        this.gross = d;
        this.returned = d2;
        this.paid = d3;
        this.debt = d4;
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

    public final List<String> getItemNames() {
        return this.itemNames;
    }

    public final double getGross() {
        return this.gross;
    }

    public final double getReturned() {
        return this.returned;
    }

    public final double getPaid() {
        return this.paid;
    }

    public final double getDebt() {
        return this.debt;
    }

    public final double getNet() {
        return Math.max(this.gross - this.returned, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public final boolean isReturned() {
        return this.returned > 0.001d && getNet() <= 0.01d;
    }

    public final boolean isPaid() {
        return !isReturned() && this.debt <= 0.01d;
    }
}
