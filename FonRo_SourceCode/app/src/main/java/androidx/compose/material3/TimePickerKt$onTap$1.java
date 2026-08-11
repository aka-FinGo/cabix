package androidx.compose.material3;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimePicker.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.material3.TimePickerKt", f = "TimePicker.kt", i = {0, 0, 1, 1}, l = {894, 897}, m = "onTap-rOwcSBo", n = {"$this$onTap_u2drOwcSBo", "autoSwitchToMinute", "$this$onTap_u2drOwcSBo", "autoSwitchToMinute"}, s = {"L$0", "Z$0", "L$0", "Z$0"})
/* loaded from: classes4.dex */
public final class TimePickerKt$onTap$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TimePickerKt$onTap$1(Continuation<? super TimePickerKt$onTap$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m2836onTaprOwcSBo;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m2836onTaprOwcSBo = TimePickerKt.m2836onTaprOwcSBo(null, 0.0f, 0.0f, 0.0f, false, 0L, this);
        return m2836onTaprOwcSBo;
    }
}
