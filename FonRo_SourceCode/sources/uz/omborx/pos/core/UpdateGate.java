package uz.FonRo.pos.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: UpdateGate.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eR+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nÊ\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000f"}, d2 = {"Luz/FonRo/pos/core/UpdateGate;", "", "<init>", "()V", "<set-?>", "", "required", "getRequired", "()Z", "setRequired", "(Z)V", "required$delegate", "Landroidx/compose/runtime/MutableState;", "require", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class UpdateGate {
    public static final int $stable = 0;
    public static final UpdateGate INSTANCE = new UpdateGate();

    /* renamed from: required$delegate, reason: from kotlin metadata */
    private static final MutableState required;

    private UpdateGate() {
    }

    static {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        required = mutableStateOf$default;
    }

    private final void setRequired(boolean z) {
        required.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getRequired() {
        return ((Boolean) required.getValue()).booleanValue();
    }

    public final void require() {
        setRequired(true);
    }
}
