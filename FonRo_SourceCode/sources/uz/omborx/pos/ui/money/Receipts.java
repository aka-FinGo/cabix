package uz.FonRo.pos.ui.money;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.core.Num;
import uz.FonRo.pos.data.model.SaleRow;
import uz.FonRo.pos.ui.nav.Routes;

/* compiled from: Receipts.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0014\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Luz/FonRo/pos/ui/money/Receipts;", "", "<init>", "()V", "group", "", "Luz/FonRo/pos/ui/money/Receipt;", "rows", "Luz/FonRo/pos/data/model/SaleRow;", Routes.RETURNS, "Luz/FonRo/pos/data/model/ReturnDoc;", "cashierFallback", "", "totals", "Luz/FonRo/pos/ui/money/ReceiptTotals;", "list", "Acc", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class Receipts {
    public static final int $stable = 0;
    public static final Receipts INSTANCE = new Receipts();

    private Receipts() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Receipts.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\tj\b\u0012\u0004\u0012\u00020\u0003`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012¨\u0006\u001c"}, d2 = {"Luz/FonRo/pos/ui/money/Receipts$Acc;", "", "head", "Luz/FonRo/pos/data/model/SaleRow;", "<init>", "(Luz/FonRo/pos/data/model/SaleRow;)V", "getHead", "()Luz/FonRo/pos/data/model/SaleRow;", FirebaseAnalytics.Param.ITEMS, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "total", "", "getTotal", "()D", "setTotal", "(D)V", "profit", "getProfit", "setProfit", "qty", "getQty", "setQty", "returnedQty", "getReturnedQty", "setReturnedQty", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes7.dex */
    public static final class Acc {
        private final SaleRow head;
        private final ArrayList<SaleRow> items;
        private double profit;
        private double qty;
        private double returnedQty;
        private double total;

        public Acc(SaleRow head) {
            Intrinsics.checkNotNullParameter(head, "head");
            this.head = head;
            this.items = new ArrayList<>(4);
        }

        public final SaleRow getHead() {
            return this.head;
        }

        public final ArrayList<SaleRow> getItems() {
            return this.items;
        }

        public final double getTotal() {
            return this.total;
        }

        public final void setTotal(double d) {
            this.total = d;
        }

        public final double getProfit() {
            return this.profit;
        }

        public final void setProfit(double d) {
            this.profit = d;
        }

        public final double getQty() {
            return this.qty;
        }

        public final void setQty(double d) {
            this.qty = d;
        }

        public final double getReturnedQty() {
            return this.returnedQty;
        }

        public final void setReturnedQty(double d) {
            this.returnedQty = d;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List group$default(Receipts receipts, List list, List list2, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        if ((i & 4) != 0) {
            str = "";
        }
        return receipts.group(list, list2, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x017f, code lost:
    
        if (r15 == null) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0239  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<uz.FonRo.pos.ui.money.Receipt> group(java.util.List<uz.FonRo.pos.data.model.SaleRow> r56, java.util.List<uz.FonRo.pos.data.model.ReturnDoc> r57, java.lang.String r58) {
        /*
            Method dump skipped, instructions count: 600
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uz.FonRo.pos.ui.money.Receipts.group(java.util.List, java.util.List, java.lang.String):java.util.List");
    }

    public final ReceiptTotals totals(List<Receipt> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        double d6 = 0.0d;
        for (Receipt receipt : list) {
            d += receipt.getNetTotal();
            d2 += receipt.getNetProfit();
            d3 += receipt.getNetQty();
            d4 += receipt.getDiscountAmount();
            d5 += receipt.getReturnedTotal();
            d6 += receipt.getDebtAmount();
        }
        return new ReceiptTotals(list.size(), Num.INSTANCE.money(d), Num.INSTANCE.money(d2), Num.INSTANCE.qty(d3), Num.INSTANCE.money(d4), Num.INSTANCE.money(d5), Num.INSTANCE.money(d6));
    }
}
