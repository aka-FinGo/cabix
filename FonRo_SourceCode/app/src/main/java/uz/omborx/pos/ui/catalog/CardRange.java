package uz.FonRo.pos.ui.catalog;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProductCard.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u001b\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00070\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Luz/FonRo/pos/ui/catalog/CardRange;", "", TypedValues.TransitionType.S_FROM, "", TypedValues.TransitionType.S_TO, "buckets", "", "Lkotlin/Pair;", "byMonth", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V", "getFrom", "()Ljava/lang/String;", "getTo", "getBuckets", "()Ljava/util/List;", "getByMonth", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", WriteOffReason.OTHER, "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final /* data */ class CardRange {
    private final List<Pair<String, String>> buckets;
    private final boolean byMonth;
    private final String from;
    private final String to;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CardRange copy$default(CardRange cardRange, String str, String str2, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cardRange.from;
        }
        if ((i & 2) != 0) {
            str2 = cardRange.to;
        }
        if ((i & 4) != 0) {
            list = cardRange.buckets;
        }
        if ((i & 8) != 0) {
            z = cardRange.byMonth;
        }
        return cardRange.copy(str, str2, list, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFrom() {
        return this.from;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTo() {
        return this.to;
    }

    public final List<Pair<String, String>> component3() {
        return this.buckets;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getByMonth() {
        return this.byMonth;
    }

    public final CardRange copy(String from, String to, List<Pair<String, String>> buckets, boolean byMonth) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(buckets, "buckets");
        return new CardRange(from, to, buckets, byMonth);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardRange)) {
            return false;
        }
        CardRange cardRange = (CardRange) other;
        return Intrinsics.areEqual(this.from, cardRange.from) && Intrinsics.areEqual(this.to, cardRange.to) && Intrinsics.areEqual(this.buckets, cardRange.buckets) && this.byMonth == cardRange.byMonth;
    }

    public int hashCode() {
        return (((((this.from.hashCode() * 31) + this.to.hashCode()) * 31) + this.buckets.hashCode()) * 31) + Boolean.hashCode(this.byMonth);
    }

    public String toString() {
        return "CardRange(from=" + this.from + ", to=" + this.to + ", buckets=" + this.buckets + ", byMonth=" + this.byMonth + ")";
    }

    public CardRange(String from, String to, List<Pair<String, String>> buckets, boolean z) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(buckets, "buckets");
        this.from = from;
        this.to = to;
        this.buckets = buckets;
        this.byMonth = z;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getTo() {
        return this.to;
    }

    public final List<Pair<String, String>> getBuckets() {
        return this.buckets;
    }

    public final boolean getByMonth() {
        return this.byMonth;
    }
}
