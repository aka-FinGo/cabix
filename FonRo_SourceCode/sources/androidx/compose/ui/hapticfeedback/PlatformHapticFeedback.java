package androidx.compose.ui.hapticfeedback;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: PlatformHapticFeedback.android.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/hapticfeedback/PlatformHapticFeedback;", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "performHapticFeedback", "", "hapticFeedbackType", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "performHapticFeedback-CdsT49E", "(I)V", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class PlatformHapticFeedback implements HapticFeedback {
    public static final int $stable = 8;
    private final View view;

    public PlatformHapticFeedback(View view) {
        this.view = view;
    }

    @Override // androidx.compose.ui.hapticfeedback.HapticFeedback
    /* renamed from: performHapticFeedback-CdsT49E */
    public void mo5106performHapticFeedbackCdsT49E(int hapticFeedbackType) {
        if (HapticFeedbackType.m5110equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5114getConfirm5zf0vsI())) {
            this.view.performHapticFeedback(16);
            return;
        }
        if (HapticFeedbackType.m5110equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5115getContextClick5zf0vsI())) {
            this.view.performHapticFeedback(6);
            return;
        }
        if (HapticFeedbackType.m5110equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5116getGestureEnd5zf0vsI())) {
            this.view.performHapticFeedback(13);
            return;
        }
        if (HapticFeedbackType.m5110equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5117getGestureThresholdActivate5zf0vsI())) {
            this.view.performHapticFeedback(23);
            return;
        }
        if (HapticFeedbackType.m5110equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5118getLongPress5zf0vsI())) {
            this.view.performHapticFeedback(0);
            return;
        }
        if (HapticFeedbackType.m5110equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5119getReject5zf0vsI())) {
            this.view.performHapticFeedback(17);
            return;
        }
        if (HapticFeedbackType.m5110equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5120getSegmentFrequentTick5zf0vsI())) {
            this.view.performHapticFeedback(27);
            return;
        }
        if (HapticFeedbackType.m5110equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5121getSegmentTick5zf0vsI())) {
            this.view.performHapticFeedback(26);
            return;
        }
        if (HapticFeedbackType.m5110equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5122getTextHandleMove5zf0vsI())) {
            this.view.performHapticFeedback(9);
            return;
        }
        if (HapticFeedbackType.m5110equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5123getToggleOff5zf0vsI())) {
            this.view.performHapticFeedback(22);
        } else if (HapticFeedbackType.m5110equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5124getToggleOn5zf0vsI())) {
            this.view.performHapticFeedback(21);
        } else if (HapticFeedbackType.m5110equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m5125getVirtualKey5zf0vsI())) {
            this.view.performHapticFeedback(1);
        }
    }
}
