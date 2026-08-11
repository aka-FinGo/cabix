package uz.FonRo.pos.ui.stats;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.ui.nav.Routes;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StatsScreen.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Luz/FonRo/pos/ui/stats/Bucket;", "", "key", "", "sortKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getSortKey", Routes.SALE, "", "getSale", "()D", "setSale", "(D)V", "profit", "getProfit", "setProfit", "expense", "getExpense", "setExpense", "ret", "getRet", "setRet", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class Bucket {
    private double expense;
    private final String key;
    private double profit;
    private double ret;
    private double sale;
    private final String sortKey;

    public Bucket(String key, String sortKey) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(sortKey, "sortKey");
        this.key = key;
        this.sortKey = sortKey;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getSortKey() {
        return this.sortKey;
    }

    public final double getSale() {
        return this.sale;
    }

    public final void setSale(double d) {
        this.sale = d;
    }

    public final double getProfit() {
        return this.profit;
    }

    public final void setProfit(double d) {
        this.profit = d;
    }

    public final double getExpense() {
        return this.expense;
    }

    public final void setExpense(double d) {
        this.expense = d;
    }

    public final double getRet() {
        return this.ret;
    }

    public final void setRet(double d) {
        this.ret = d;
    }
}
