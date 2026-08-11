package androidx.compose.ui.text.android.selection;

import androidx.compose.ui.text.android.Paint29$$ExternalSyntheticApiModelOutline0;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: SegmentFinder.android.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/android/selection/Api34SegmentFinder;", "", "()V", "toAndroidSegmentFinder", "Landroid/text/SegmentFinder;", "Landroidx/compose/ui/text/android/selection/SegmentFinder;", "toAndroidSegmentFinder$ui_text_release", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class Api34SegmentFinder {
    public static final int $stable = 0;
    public static final Api34SegmentFinder INSTANCE = new Api34SegmentFinder();

    private Api34SegmentFinder() {
    }

    public final android.text.SegmentFinder toAndroidSegmentFinder$ui_text_release(final SegmentFinder segmentFinder) {
        return Paint29$$ExternalSyntheticApiModelOutline0.m((Object) new android.text.SegmentFinder() { // from class: androidx.compose.ui.text.android.selection.Api34SegmentFinder$toAndroidSegmentFinder$1
            public int previousStartBoundary(int offset) {
                return SegmentFinder.this.previousStartBoundary(offset);
            }

            public int previousEndBoundary(int offset) {
                return SegmentFinder.this.previousEndBoundary(offset);
            }

            public int nextStartBoundary(int offset) {
                return SegmentFinder.this.nextStartBoundary(offset);
            }

            public int nextEndBoundary(int offset) {
                return SegmentFinder.this.nextEndBoundary(offset);
            }
        });
    }
}
