package uz.FonRo.pos.ui.money;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.ui.components.PeriodKind;
import uz.FonRo.pos.ui.components.PeriodState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExpensesScreen.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Luz/FonRo/pos/ui/money/ExpensesState;", "", "<init>", "()V", "<set-?>", "Luz/FonRo/pos/ui/components/PeriodState;", TypedValues.CycleType.S_WAVE_PERIOD, "getPeriod", "()Luz/FonRo/pos/ui/components/PeriodState;", "setPeriod", "(Luz/FonRo/pos/ui/components/PeriodState;)V", "period$delegate", "Landroidx/compose/runtime/MutableState;", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class ExpensesState {
    public static final ExpensesState INSTANCE = new ExpensesState();

    /* renamed from: period$delegate, reason: from kotlin metadata */
    private static final MutableState period;

    private ExpensesState() {
    }

    static {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PeriodState(PeriodKind.TODAY, null, null, 6, null), null, 2, null);
        period = mutableStateOf$default;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PeriodState getPeriod() {
        return (PeriodState) period.getValue();
    }

    public final void setPeriod(PeriodState periodState) {
        Intrinsics.checkNotNullParameter(periodState, "<set-?>");
        period.setValue(periodState);
    }
}
