package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Ruler.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0010¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/layout/HorizontalRuler;", "Landroidx/compose/ui/layout/Ruler;", "()V", "calculateCoordinate", "", "coordinate", "sourceCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "targetCoordinates", "calculateCoordinate$ui_release", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class HorizontalRuler extends Ruler {
    public static final int $stable = 0;

    public HorizontalRuler() {
        super(null);
    }

    @Override // androidx.compose.ui.layout.Ruler
    public float calculateCoordinate$ui_release(float coordinate, LayoutCoordinates sourceCoordinates, LayoutCoordinates targetCoordinates) {
        return Float.intBitsToFloat((int) (targetCoordinates.mo5741localPositionOfR5De75A(sourceCoordinates, Offset.m4117constructorimpl((Float.floatToRawIntBits(((int) (sourceCoordinates.mo5740getSizeYbymL2g() >> 32)) / 2.0f) << 32) | (Float.floatToRawIntBits(coordinate) & 4294967295L))) & 4294967295L));
    }
}
