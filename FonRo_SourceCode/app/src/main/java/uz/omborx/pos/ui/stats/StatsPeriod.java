package uz.FonRo.pos.ui.stats;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.ui.components.PeriodKind;
import uz.FonRo.pos.ui.components.PeriodState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StatsScreen.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Luz/FonRo/pos/ui/stats/StatsPeriod;", "", "<init>", "()V", "<set-?>", "Luz/FonRo/pos/ui/components/PeriodState;", "state", "getState", "()Luz/FonRo/pos/ui/components/PeriodState;", "setState", "(Luz/FonRo/pos/ui/components/PeriodState;)V", "state$delegate", "Landroidx/compose/runtime/MutableState;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class StatsPeriod {
    public static final StatsPeriod INSTANCE = new StatsPeriod();

    /* renamed from: state$delegate, reason: from kotlin metadata */
    private static final MutableState state;

    private StatsPeriod() {
    }

    static {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PeriodState(PeriodKind.TODAY, null, null, 6, null), null, 2, null);
        state = mutableStateOf$default;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PeriodState getState() {
        return (PeriodState) state.getValue();
    }

    public final void setState(PeriodState periodState) {
        Intrinsics.checkNotNullParameter(periodState, "<set-?>");
        state.setValue(periodState);
    }
}
