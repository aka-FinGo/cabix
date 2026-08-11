package uz.FonRo.pos.ui.catalog;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.AuditDoc;
import uz.FonRo.pos.data.model.WriteOffReason;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProductCard.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001c"}, d2 = {"Luz/FonRo/pos/ui/catalog/AuditRow;", "", "doc", "Luz/FonRo/pos/data/model/AuditDoc;", "systemQty", "", "actualQty", "diff", "<init>", "(Luz/FonRo/pos/data/model/AuditDoc;DDD)V", "getDoc", "()Luz/FonRo/pos/data/model/AuditDoc;", "getSystemQty", "()D", "getActualQty", "getDiff", "component1", "component2", "component3", "component4", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class AuditRow {
    private final double actualQty;
    private final double diff;
    private final AuditDoc doc;
    private final double systemQty;

    public static /* synthetic */ AuditRow copy$default(AuditRow auditRow, AuditDoc auditDoc, double d, double d2, double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            auditDoc = auditRow.doc;
        }
        if ((i & 2) != 0) {
            d = auditRow.systemQty;
        }
        if ((i & 4) != 0) {
            d2 = auditRow.actualQty;
        }
        if ((i & 8) != 0) {
            d3 = auditRow.diff;
        }
        double d4 = d3;
        return auditRow.copy(auditDoc, d, d2, d4);
    }

    /* renamed from: component1, reason: from getter */
    public final AuditDoc getDoc() {
        return this.doc;
    }

    /* renamed from: component2, reason: from getter */
    public final double getSystemQty() {
        return this.systemQty;
    }

    /* renamed from: component3, reason: from getter */
    public final double getActualQty() {
        return this.actualQty;
    }

    /* renamed from: component4, reason: from getter */
    public final double getDiff() {
        return this.diff;
    }

    public final AuditRow copy(AuditDoc doc, double systemQty, double actualQty, double diff) {
        Intrinsics.checkNotNullParameter(doc, "doc");
        return new AuditRow(doc, systemQty, actualQty, diff);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuditRow)) {
            return false;
        }
        AuditRow auditRow = (AuditRow) other;
        return Intrinsics.areEqual(this.doc, auditRow.doc) && Double.compare(this.systemQty, auditRow.systemQty) == 0 && Double.compare(this.actualQty, auditRow.actualQty) == 0 && Double.compare(this.diff, auditRow.diff) == 0;
    }

    public int hashCode() {
        return (((((this.doc.hashCode() * 31) + Double.hashCode(this.systemQty)) * 31) + Double.hashCode(this.actualQty)) * 31) + Double.hashCode(this.diff);
    }

    public String toString() {
        return "AuditRow(doc=" + this.doc + ", systemQty=" + this.systemQty + ", actualQty=" + this.actualQty + ", diff=" + this.diff + ")";
    }

    public AuditRow(AuditDoc doc, double d, double d2, double d3) {
        Intrinsics.checkNotNullParameter(doc, "doc");
        this.doc = doc;
        this.systemQty = d;
        this.actualQty = d2;
        this.diff = d3;
    }

    public final AuditDoc getDoc() {
        return this.doc;
    }

    public final double getSystemQty() {
        return this.systemQty;
    }

    public final double getActualQty() {
        return this.actualQty;
    }

    public final double getDiff() {
        return this.diff;
    }
}
