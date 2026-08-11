package uz.FonRo.pos.ui.more;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LogScreen.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Luz/FonRo/pos/ui/more/DiffLine;", "", "label", "", "before", "after", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "getBefore", "getAfter", "component1", "component2", "component3", "copy", "equals", "", WriteOffReason.OTHER, "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class DiffLine {
    private final String after;
    private final String before;
    private final String label;

    public static /* synthetic */ DiffLine copy$default(DiffLine diffLine, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = diffLine.label;
        }
        if ((i & 2) != 0) {
            str2 = diffLine.before;
        }
        if ((i & 4) != 0) {
            str3 = diffLine.after;
        }
        return diffLine.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBefore() {
        return this.before;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAfter() {
        return this.after;
    }

    public final DiffLine copy(String label, String before, String after) {
        Intrinsics.checkNotNullParameter(label, "label");
        return new DiffLine(label, before, after);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiffLine)) {
            return false;
        }
        DiffLine diffLine = (DiffLine) other;
        return Intrinsics.areEqual(this.label, diffLine.label) && Intrinsics.areEqual(this.before, diffLine.before) && Intrinsics.areEqual(this.after, diffLine.after);
    }

    public int hashCode() {
        int hashCode = this.label.hashCode() * 31;
        String str = this.before;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.after;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DiffLine(label=" + this.label + ", before=" + this.before + ", after=" + this.after + ")";
    }

    public DiffLine(String label, String str, String str2) {
        Intrinsics.checkNotNullParameter(label, "label");
        this.label = label;
        this.before = str;
        this.after = str2;
    }

    public final String getAfter() {
        return this.after;
    }

    public final String getBefore() {
        return this.before;
    }

    public final String getLabel() {
        return this.label;
    }
}
