package uz.FonRo.pos.ui.money;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.ui.components.PeriodKind;
import uz.FonRo.pos.ui.components.PeriodState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HistoryScreen.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0019R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00118F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Luz/FonRo/pos/ui/money/HistoryState;", "", "<init>", "()V", "<set-?>", "", "tab", "getTab", "()Ljava/lang/String;", "setTab", "(Ljava/lang/String;)V", "tab$delegate", "Landroidx/compose/runtime/MutableState;", "itemSort", "getItemSort", "setItemSort", "itemSort$delegate", "Luz/FonRo/pos/ui/components/PeriodState;", TypedValues.CycleType.S_WAVE_PERIOD, "getPeriod", "()Luz/FonRo/pos/ui/components/PeriodState;", "setPeriod", "(Luz/FonRo/pos/ui/components/PeriodState;)V", "period$delegate", "params", "", "app"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes7.dex */
public final class HistoryState {
    public static final HistoryState INSTANCE = new HistoryState();

    /* renamed from: itemSort$delegate, reason: from kotlin metadata */
    private static final MutableState itemSort;

    /* renamed from: period$delegate, reason: from kotlin metadata */
    private static final MutableState period;

    /* renamed from: tab$delegate, reason: from kotlin metadata */
    private static final MutableState tab;

    private HistoryState() {
    }

    static {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("receipts", null, 2, null);
        tab = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("sum", null, 2, null);
        itemSort = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PeriodState(PeriodKind.TODAY, null, null, 6, null), null, 2, null);
        period = mutableStateOf$default3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getTab() {
        return (String) tab.getValue();
    }

    public final void setTab(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        tab.setValue(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getItemSort() {
        return (String) itemSort.getValue();
    }

    public final void setItemSort(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        itemSort.setValue(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PeriodState getPeriod() {
        return (PeriodState) period.getValue();
    }

    public final void setPeriod(PeriodState periodState) {
        Intrinsics.checkNotNullParameter(periodState, "<set-?>");
        period.setValue(periodState);
    }

    public final Map<String, String> params() {
        if (getPeriod().getKind() == PeriodKind.ALL) {
            return MapsKt.mapOf(TuplesKt.to(TypedValues.CycleType.S_WAVE_PERIOD, "all"));
        }
        Pair<String, String> range = getPeriod().range();
        return MapsKt.mapOf(TuplesKt.to(TypedValues.CycleType.S_WAVE_PERIOD, "custom"), TuplesKt.to(TypedValues.TransitionType.S_FROM, range.component1()), TuplesKt.to(TypedValues.TransitionType.S_TO, range.component2()));
    }
}
