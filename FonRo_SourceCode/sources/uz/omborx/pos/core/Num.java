package uz.FonRo.pos.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Num.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005Ê\u0001\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\r"}, d2 = {"Luz/FonRo/pos/core/Num;", "", "<init>", "()V", "money", "", "v", "qty", "gte", "", "a", "b", "isZero", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class Num {
    public static final int $stable = 0;
    public static final Num INSTANCE = new Num();

    public final boolean gte(double a, double b) {
        return a >= b - 0.005d;
    }

    private Num() {
    }

    public final double money(double v) {
        return Math.rint(v * 100.0d) / 100.0d;
    }

    public final double qty(double v) {
        return Math.rint(v * 1000.0d) / 1000.0d;
    }

    public final boolean isZero(double v) {
        return Math.abs(v) < 0.001d;
    }
}
