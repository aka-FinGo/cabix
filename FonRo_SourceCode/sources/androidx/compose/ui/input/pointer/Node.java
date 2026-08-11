package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.util.PointerIdArray;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.PointerInputModifierNodeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HitPathTracker.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\u0016\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0017\u0010!\u001a\u00020\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0#H\u0082\bJ.\u0010$\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u001a\u0010%\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\r2\u0006\u0010'\u001a\u00020\rH\u0002J\u0006\u0010(\u001a\u00020\u001dJ\u001e\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00000-H\u0016J\b\u0010.\u001a\u00020/H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "modifierNode", "Landroidx/compose/ui/Modifier$Node;", "(Landroidx/compose/ui/Modifier$Node;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "hasExited", "", "isIn", "getModifierNode", "()Landroidx/compose/ui/Modifier$Node;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerIds", "Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "getPointerIds", "()Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "relevantChanges", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "wasIn", "buildCache", "changes", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "cleanUpHits", "", "clearCache", "dispatchCancel", "dispatchFinalEventPass", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchMainEventPass", "hasPositionChanged", "oldEvent", "newEvent", "markIsIn", "removeInvalidPointerIdsAndChanges", "pointerIdValue", "", "hitNodes", "Landroidx/collection/MutableObjectList;", "toString", "", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class Node extends NodeParent {
    public static final int $stable = 8;
    private LayoutCoordinates coordinates;
    private final Modifier.Node modifierNode;
    private PointerEvent pointerEvent;
    private boolean wasIn;
    private final PointerIdArray pointerIds = new PointerIdArray();
    private final LongSparseArray<PointerInputChange> relevantChanges = new LongSparseArray<>(2);
    private boolean isIn = true;
    private boolean hasExited = true;

    public Node(Modifier.Node node) {
        this.modifierNode = node;
    }

    public final Modifier.Node getModifierNode() {
        return this.modifierNode;
    }

    public final PointerIdArray getPointerIds() {
        return this.pointerIds;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void removeInvalidPointerIdsAndChanges(long pointerIdValue, MutableObjectList<Node> hitNodes) {
        if (this.pointerIds.contains(pointerIdValue) && !hitNodes.contains(this)) {
            this.pointerIds.remove(pointerIdValue);
            this.relevantChanges.remove(pointerIdValue);
        }
        MutableVector<Node> children = getChildren();
        Node[] nodeArr = children.content;
        int size = children.getSize();
        for (int i = 0; i < size; i++) {
            nodeArr[i].removeInvalidPointerIdsAndChanges(pointerIdValue, hitNodes);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v23, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.ui.Modifier$Node] */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean buildCache(LongSparseArray<PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        PointerInputChange pointerInputChange;
        boolean z;
        int m5561getExit7fucELk;
        boolean z2;
        int i;
        boolean z3;
        int i2;
        int i3;
        boolean buildCache = super.buildCache(changes, parentCoordinates, internalPointerEvent, isInBounds);
        boolean z4 = true;
        if (!this.modifierNode.getIsAttached()) {
            return true;
        }
        DelegatingNode delegatingNode = this.modifierNode;
        int m5994constructorimpl = NodeKind.m5994constructorimpl(16);
        MutableVector mutableVector = null;
        while (delegatingNode != 0) {
            if (delegatingNode instanceof PointerInputModifierNode) {
                this.coordinates = PointerInputModifierNodeKt.getLayoutCoordinates((PointerInputModifierNode) delegatingNode);
            } else if ((delegatingNode.getKindSet() & m5994constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                Modifier.Node delegate = delegatingNode.getDelegate();
                int i4 = 0;
                delegatingNode = delegatingNode;
                while (delegate != null) {
                    if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                        i4++;
                        if (i4 == 1) {
                            delegatingNode = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (delegatingNode != 0) {
                                if (mutableVector != null) {
                                    mutableVector.add(delegatingNode);
                                }
                                delegatingNode = 0;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate);
                            }
                        }
                    }
                    delegate = delegate.getChild();
                    delegatingNode = delegatingNode;
                }
                if (i4 == 1) {
                }
            }
            delegatingNode = DelegatableNodeKt.pop(mutableVector);
        }
        if (this.coordinates == null) {
            return true;
        }
        int size = changes.size();
        int i5 = 0;
        while (i5 < size) {
            long keyAt = changes.keyAt(i5);
            PointerInputChange valueAt = changes.valueAt(i5);
            if (this.pointerIds.contains(keyAt)) {
                boolean z5 = z4;
                int i6 = i5;
                long previousPosition = valueAt.getPreviousPosition();
                z3 = z5;
                long position = valueAt.getPosition();
                if ((((previousPosition & 9223372034707292159L) + InlineClassHelperKt.DualLoadedSignificand) & (-9223372034707292160L)) == 0 && (((position & 9223372034707292159L) + InlineClassHelperKt.DualLoadedSignificand) & (-9223372034707292160L)) == 0) {
                    ArrayList arrayList = new ArrayList(valueAt.getHistorical().size());
                    List<HistoricalChange> historical = valueAt.getHistorical();
                    z2 = buildCache;
                    int size2 = historical.size();
                    i = size;
                    int i7 = 0;
                    while (i7 < size2) {
                        HistoricalChange historicalChange = historical.get(i7);
                        int i8 = size2;
                        int i9 = i7;
                        long position2 = historicalChange.getPosition();
                        if ((((position2 & 9223372034707292159L) + InlineClassHelperKt.DualLoadedSignificand) & (-9223372034707292160L)) == 0) {
                            long uptimeMillis = historicalChange.getUptimeMillis();
                            i3 = i6;
                            LayoutCoordinates layoutCoordinates = this.coordinates;
                            Intrinsics.checkNotNull(layoutCoordinates);
                            arrayList.add(new HistoricalChange(uptimeMillis, layoutCoordinates.mo5741localPositionOfR5De75A(parentCoordinates, position2), historicalChange.getOriginalEventPosition(), null));
                        } else {
                            i3 = i6;
                        }
                        i7 = i9 + 1;
                        size2 = i8;
                        i6 = i3;
                    }
                    i2 = i6;
                    LongSparseArray<PointerInputChange> longSparseArray = this.relevantChanges;
                    LayoutCoordinates layoutCoordinates2 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates2);
                    long mo5741localPositionOfR5De75A = layoutCoordinates2.mo5741localPositionOfR5De75A(parentCoordinates, previousPosition);
                    LayoutCoordinates layoutCoordinates3 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates3);
                    longSparseArray.put(keyAt, PointerInputChange.m5596copyOHpmEuE$default(valueAt, 0L, 0L, layoutCoordinates3.mo5741localPositionOfR5De75A(parentCoordinates, position), false, 0L, mo5741localPositionOfR5De75A, false, 0, arrayList, 0L, 731, null));
                } else {
                    z2 = buildCache;
                    i = size;
                    i2 = i6;
                }
            } else {
                z2 = buildCache;
                i = size;
                z3 = z4;
                i2 = i5;
            }
            i5 = i2 + 1;
            z4 = z3;
            buildCache = z2;
            size = i;
        }
        boolean z6 = buildCache;
        boolean z7 = z4;
        boolean isEmpty = this.relevantChanges.isEmpty();
        PointerIdArray pointerIdArray = this.pointerIds;
        if (isEmpty) {
            pointerIdArray.clear();
            getChildren().clear();
            return z7;
        }
        int size3 = pointerIdArray.getSize();
        while (true) {
            size3--;
            if (-1 >= size3) {
                break;
            }
            if (!changes.containsKey(this.pointerIds.m5700get_I2yYro(size3))) {
                this.pointerIds.removeAt(size3);
            }
        }
        ArrayList arrayList2 = new ArrayList(this.relevantChanges.size());
        int size4 = this.relevantChanges.size();
        for (int i10 = 0; i10 < size4; i10++) {
            arrayList2.add(this.relevantChanges.valueAt(i10));
        }
        PointerEvent pointerEvent = new PointerEvent(arrayList2, internalPointerEvent);
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size5 = changes2.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size5) {
                pointerInputChange = null;
                break;
            }
            PointerInputChange pointerInputChange2 = changes2.get(i11);
            if (internalPointerEvent.m5535activeHoverEvent0FcD4WY(pointerInputChange2.getId())) {
                pointerInputChange = pointerInputChange2;
                break;
            }
            i11++;
        }
        PointerInputChange pointerInputChange3 = pointerInputChange;
        if (pointerInputChange3 != null) {
            if (!isInBounds) {
                z = false;
                this.isIn = false;
            } else {
                z = false;
                if (!this.isIn && (pointerInputChange3.getPressed() || pointerInputChange3.getPreviousPressed())) {
                    Intrinsics.checkNotNull(this.coordinates);
                    this.isIn = !PointerEventKt.m5551isOutOfBoundsO0kMr_c(pointerInputChange3, r3.mo5740getSizeYbymL2g());
                }
            }
            if (this.isIn != this.wasIn && (PointerEventType.m5556equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m5562getMove7fucELk()) || PointerEventType.m5556equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m5560getEnter7fucELk()) || PointerEventType.m5556equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m5561getExit7fucELk()))) {
                if (this.isIn) {
                    m5561getExit7fucELk = PointerEventType.INSTANCE.m5560getEnter7fucELk();
                } else {
                    m5561getExit7fucELk = PointerEventType.INSTANCE.m5561getExit7fucELk();
                }
                pointerEvent.m5550setTypeEhbLWgg$ui_release(m5561getExit7fucELk);
            } else if (PointerEventType.m5556equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m5560getEnter7fucELk()) && this.wasIn && !this.hasExited) {
                pointerEvent.m5550setTypeEhbLWgg$ui_release(PointerEventType.INSTANCE.m5562getMove7fucELk());
            } else if (PointerEventType.m5556equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m5561getExit7fucELk()) && this.isIn && pointerInputChange3.getPressed()) {
                pointerEvent.m5550setTypeEhbLWgg$ui_release(PointerEventType.INSTANCE.m5562getMove7fucELk());
            }
        } else {
            z = false;
        }
        boolean z8 = (z6 || !PointerEventType.m5556equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m5562getMove7fucELk()) || hasPositionChanged(this.pointerEvent, pointerEvent)) ? z7 : z;
        this.pointerEvent = pointerEvent;
        return z8;
    }

    private final boolean hasPositionChanged(PointerEvent oldEvent, PointerEvent newEvent) {
        if (oldEvent == null || oldEvent.getChanges().size() != newEvent.getChanges().size()) {
            return true;
        }
        int size = newEvent.getChanges().size();
        for (int i = 0; i < size; i++) {
            if (!Offset.m4122equalsimpl0(oldEvent.getChanges().get(i).getPosition(), newEvent.getChanges().get(i).getPosition())) {
                return true;
            }
        }
        return false;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean dispatchIfNeeded(Function0<Unit> block) {
        if (this.relevantChanges.isEmpty() || !this.modifierNode.getIsAttached()) {
            return false;
        }
        block.invoke();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void dispatchCancel() {
        MutableVector<Node> children = getChildren();
        Node[] nodeArr = children.content;
        int size = children.getSize();
        for (int i = 0; i < size; i++) {
            nodeArr[i].dispatchCancel();
        }
        DelegatingNode delegatingNode = this.modifierNode;
        int m5994constructorimpl = NodeKind.m5994constructorimpl(16);
        MutableVector mutableVector = null;
        while (delegatingNode != 0) {
            if (delegatingNode instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) delegatingNode).onCancelPointerInput();
            } else if ((delegatingNode.getKindSet() & m5994constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                Modifier.Node delegate = delegatingNode.getDelegate();
                int i2 = 0;
                delegatingNode = delegatingNode;
                while (delegate != null) {
                    if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                        i2++;
                        if (i2 == 1) {
                            delegatingNode = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (delegatingNode != 0) {
                                if (mutableVector != null) {
                                    mutableVector.add(delegatingNode);
                                }
                                delegatingNode = 0;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate);
                            }
                        }
                    }
                    delegate = delegate.getChild();
                    delegatingNode = delegatingNode;
                }
                if (i2 == 1) {
                }
            }
            delegatingNode = DelegatableNodeKt.pop(mutableVector);
        }
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent = this.pointerEvent;
        if (pointerEvent == null) {
            return;
        }
        this.wasIn = this.isIn;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            boolean pressed = pointerInputChange.getPressed();
            boolean m5535activeHoverEvent0FcD4WY = internalPointerEvent.m5535activeHoverEvent0FcD4WY(pointerInputChange.getId());
            boolean z = this.isIn;
            if ((!pressed && !m5535activeHoverEvent0FcD4WY) || (!pressed && !z)) {
                this.pointerIds.remove(pointerInputChange.getId());
            }
        }
        this.isIn = false;
        this.hasExited = PointerEventType.m5556equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m5561getExit7fucELk());
    }

    public String toString() {
        return "Node(modifierNode=" + this.modifierNode + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchMainEventPass(LongSparseArray<PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        if (this.relevantChanges.isEmpty() || !this.modifierNode.getIsAttached()) {
            return false;
        }
        PointerEvent pointerEvent = this.pointerEvent;
        Intrinsics.checkNotNull(pointerEvent);
        LayoutCoordinates layoutCoordinates = this.coordinates;
        Intrinsics.checkNotNull(layoutCoordinates);
        long mo5740getSizeYbymL2g = layoutCoordinates.mo5740getSizeYbymL2g();
        DelegatingNode delegatingNode = this.modifierNode;
        int m5994constructorimpl = NodeKind.m5994constructorimpl(16);
        MutableVector mutableVector = null;
        while (delegatingNode != 0) {
            if (delegatingNode instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) delegatingNode).mo528onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Initial, mo5740getSizeYbymL2g);
            } else if ((delegatingNode.getKindSet() & m5994constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                Modifier.Node delegate = delegatingNode.getDelegate();
                int i = 0;
                delegatingNode = delegatingNode;
                while (delegate != null) {
                    if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                        i++;
                        if (i == 1) {
                            delegatingNode = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (delegatingNode != 0) {
                                if (mutableVector != null) {
                                    mutableVector.add(delegatingNode);
                                }
                                delegatingNode = 0;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate);
                            }
                        }
                    }
                    delegate = delegate.getChild();
                    delegatingNode = delegatingNode;
                }
                if (i == 1) {
                }
            }
            delegatingNode = DelegatableNodeKt.pop(mutableVector);
        }
        if (this.modifierNode.getIsAttached()) {
            MutableVector<Node> children = getChildren();
            Node[] nodeArr = children.content;
            int size = children.getSize();
            for (int i2 = 0; i2 < size; i2++) {
                Node node = nodeArr[i2];
                LongSparseArray<PointerInputChange> longSparseArray = this.relevantChanges;
                LayoutCoordinates layoutCoordinates2 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates2);
                node.dispatchMainEventPass(longSparseArray, layoutCoordinates2, internalPointerEvent, isInBounds);
            }
        }
        if (this.modifierNode.getIsAttached()) {
            DelegatingNode delegatingNode2 = this.modifierNode;
            int m5994constructorimpl2 = NodeKind.m5994constructorimpl(16);
            MutableVector mutableVector2 = null;
            while (delegatingNode2 != 0) {
                if (delegatingNode2 instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) delegatingNode2).mo528onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Main, mo5740getSizeYbymL2g);
                } else if ((delegatingNode2.getKindSet() & m5994constructorimpl2) != 0 && (delegatingNode2 instanceof DelegatingNode)) {
                    Modifier.Node delegate2 = delegatingNode2.getDelegate();
                    int i3 = 0;
                    delegatingNode2 = delegatingNode2;
                    while (delegate2 != null) {
                        if ((delegate2.getKindSet() & m5994constructorimpl2) != 0) {
                            i3++;
                            if (i3 == 1) {
                                delegatingNode2 = delegate2;
                            } else {
                                if (mutableVector2 == null) {
                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (delegatingNode2 != 0) {
                                    if (mutableVector2 != null) {
                                        mutableVector2.add(delegatingNode2);
                                    }
                                    delegatingNode2 = 0;
                                }
                                if (mutableVector2 != null) {
                                    mutableVector2.add(delegate2);
                                }
                            }
                        }
                        delegate2 = delegate2.getChild();
                        delegatingNode2 = delegatingNode2;
                    }
                    if (i3 == 1) {
                    }
                }
                delegatingNode2 = DelegatableNodeKt.pop(mutableVector2);
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        boolean z = false;
        z = false;
        if (!this.relevantChanges.isEmpty() && this.modifierNode.getIsAttached()) {
            PointerEvent pointerEvent = this.pointerEvent;
            Intrinsics.checkNotNull(pointerEvent);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            long mo5740getSizeYbymL2g = layoutCoordinates.mo5740getSizeYbymL2g();
            DelegatingNode delegatingNode = this.modifierNode;
            int m5994constructorimpl = NodeKind.m5994constructorimpl(16);
            MutableVector mutableVector = null;
            while (delegatingNode != 0) {
                if (delegatingNode instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) delegatingNode).mo528onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Final, mo5740getSizeYbymL2g);
                } else if ((delegatingNode.getKindSet() & m5994constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                    Modifier.Node delegate = delegatingNode.getDelegate();
                    int i = 0;
                    delegatingNode = delegatingNode;
                    while (delegate != null) {
                        if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                            i++;
                            if (i == 1) {
                                delegatingNode = delegate;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (delegatingNode != 0) {
                                    if (mutableVector != null) {
                                        mutableVector.add(delegatingNode);
                                    }
                                    delegatingNode = 0;
                                }
                                if (mutableVector != null) {
                                    mutableVector.add(delegate);
                                }
                            }
                        }
                        delegate = delegate.getChild();
                        delegatingNode = delegatingNode;
                    }
                    if (i == 1) {
                    }
                }
                delegatingNode = DelegatableNodeKt.pop(mutableVector);
            }
            if (this.modifierNode.getIsAttached()) {
                MutableVector<Node> children = getChildren();
                Node[] nodeArr = children.content;
                int size = children.getSize();
                for (int i2 = 0; i2 < size; i2++) {
                    nodeArr[i2].dispatchFinalEventPass(internalPointerEvent);
                }
            }
            z = true;
        }
        cleanUpHits(internalPointerEvent);
        clearCache();
        return z;
    }
}
