package uz.FonRo.pos.print;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: ReceiptDoc.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eÊ\u0001\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001a"}, d2 = {"Luz/FonRo/pos/print/ReceiptTotal;", "", "label", "", "value", "big", "", "strong", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getLabel", "()Ljava/lang/String;", "getValue", "getBig", "()Z", "getStrong", "component1", "component2", "component3", "component4", "copy", "equals", WriteOffReason.OTHER, "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final /* data */ class ReceiptTotal {
    public static final int $stable = 0;
    private final boolean big;
    private final String label;
    private final boolean strong;
    private final String value;

    public static /* synthetic */ ReceiptTotal copy$default(ReceiptTotal receiptTotal, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = receiptTotal.label;
        }
        if ((i & 2) != 0) {
            str2 = receiptTotal.value;
        }
        if ((i & 4) != 0) {
            z = receiptTotal.big;
        }
        if ((i & 8) != 0) {
            z2 = receiptTotal.strong;
        }
        return receiptTotal.copy(str, str2, z, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getBig() {
        return this.big;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getStrong() {
        return this.strong;
    }

    public final ReceiptTotal copy(String label, String value, boolean big, boolean strong) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(value, "value");
        return new ReceiptTotal(label, value, big, strong);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReceiptTotal)) {
            return false;
        }
        ReceiptTotal receiptTotal = (ReceiptTotal) other;
        return Intrinsics.areEqual(this.label, receiptTotal.label) && Intrinsics.areEqual(this.value, receiptTotal.value) && this.big == receiptTotal.big && this.strong == receiptTotal.strong;
    }

    public int hashCode() {
        return (((((this.label.hashCode() * 31) + this.value.hashCode()) * 31) + Boolean.hashCode(this.big)) * 31) + Boolean.hashCode(this.strong);
    }

    public String toString() {
        return "ReceiptTotal(label=" + this.label + ", value=" + this.value + ", big=" + this.big + ", strong=" + this.strong + ")";
    }

    public ReceiptTotal(String label, String value, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(value, "value");
        this.label = label;
        this.value = value;
        this.big = z;
        this.strong = z2;
    }

    public /* synthetic */ ReceiptTotal(String str, String str2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
    }

    public final boolean getBig() {
        return this.big;
    }

    public final String getLabel() {
        return this.label;
    }

    public final boolean getStrong() {
        return this.strong;
    }

    public final String getValue() {
        return this.value;
    }
}
