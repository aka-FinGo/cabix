package androidx.compose.foundation.text.handwriting;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: StylusHandwriting.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\f\u0010\u0016\u001a\u00020\u0005*\u00020\u0017H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/text/handwriting/StylusHandwritingElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/handwriting/StylusHandwritingNode;", "onHandwritingSlopExceeded", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "getOnHandwritingSlopExceeded", "()Lkotlin/jvm/functions/Function0;", "component1", "copy", "create", "equals", "", WriteOffReason.OTHER, "", "hashCode", "", "toString", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final /* data */ class StylusHandwritingElement extends ModifierNodeElement<StylusHandwritingNode> {
    private final Function0<Unit> onHandwritingSlopExceeded;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StylusHandwritingElement copy$default(StylusHandwritingElement stylusHandwritingElement, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = stylusHandwritingElement.onHandwritingSlopExceeded;
        }
        return stylusHandwritingElement.copy(function0);
    }

    public final Function0<Unit> component1() {
        return this.onHandwritingSlopExceeded;
    }

    public final StylusHandwritingElement copy(Function0<Unit> onHandwritingSlopExceeded) {
        return new StylusHandwritingElement(onHandwritingSlopExceeded);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof StylusHandwritingElement) && Intrinsics.areEqual(this.onHandwritingSlopExceeded, ((StylusHandwritingElement) other).onHandwritingSlopExceeded);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.onHandwritingSlopExceeded.hashCode();
    }

    public String toString() {
        return "StylusHandwritingElement(onHandwritingSlopExceeded=" + this.onHandwritingSlopExceeded + ')';
    }

    public final Function0<Unit> getOnHandwritingSlopExceeded() {
        return this.onHandwritingSlopExceeded;
    }

    public StylusHandwritingElement(Function0<Unit> function0) {
        this.onHandwritingSlopExceeded = function0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* renamed from: create */
    public StylusHandwritingNode getNode() {
        return new StylusHandwritingNode(this.onHandwritingSlopExceeded);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(StylusHandwritingNode node) {
        node.setOnHandwritingSlopExceeded(this.onHandwritingSlopExceeded);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("stylusHandwriting");
        inspectorInfo.getProperties().set("onHandwritingSlopExceeded", this.onHandwritingSlopExceeded);
    }
}
