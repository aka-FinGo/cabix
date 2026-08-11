package uz.FonRo.pos.ui.money;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.SaleRow;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: HistoryScreen.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Luz/FonRo/pos/ui/money/ItemSale;", "", "receipt", "Luz/FonRo/pos/ui/money/Receipt;", "row", "Luz/FonRo/pos/data/model/SaleRow;", "<init>", "(Luz/FonRo/pos/ui/money/Receipt;Luz/FonRo/pos/data/model/SaleRow;)V", "getReceipt", "()Luz/FonRo/pos/ui/money/Receipt;", "getRow", "()Luz/FonRo/pos/data/model/SaleRow;", "component1", "component2", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class ItemSale {
    public static final int $stable = SaleRow.$stable | Receipt.$stable;
    private final Receipt receipt;
    private final SaleRow row;

    public static /* synthetic */ ItemSale copy$default(ItemSale itemSale, Receipt receipt, SaleRow saleRow, int i, Object obj) {
        if ((i & 1) != 0) {
            receipt = itemSale.receipt;
        }
        if ((i & 2) != 0) {
            saleRow = itemSale.row;
        }
        return itemSale.copy(receipt, saleRow);
    }

    /* renamed from: component1, reason: from getter */
    public final Receipt getReceipt() {
        return this.receipt;
    }

    /* renamed from: component2, reason: from getter */
    public final SaleRow getRow() {
        return this.row;
    }

    public final ItemSale copy(Receipt receipt, SaleRow row) {
        Intrinsics.checkNotNullParameter(receipt, "receipt");
        Intrinsics.checkNotNullParameter(row, "row");
        return new ItemSale(receipt, row);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemSale)) {
            return false;
        }
        ItemSale itemSale = (ItemSale) other;
        return Intrinsics.areEqual(this.receipt, itemSale.receipt) && Intrinsics.areEqual(this.row, itemSale.row);
    }

    public int hashCode() {
        return (this.receipt.hashCode() * 31) + this.row.hashCode();
    }

    public String toString() {
        return "ItemSale(receipt=" + this.receipt + ", row=" + this.row + ")";
    }

    public ItemSale(Receipt receipt, SaleRow row) {
        Intrinsics.checkNotNullParameter(receipt, "receipt");
        Intrinsics.checkNotNullParameter(row, "row");
        this.receipt = receipt;
        this.row = row;
    }

    public final Receipt getReceipt() {
        return this.receipt;
    }

    public final SaleRow getRow() {
        return this.row;
    }
}
