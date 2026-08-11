package androidx.compose.runtime;

import androidx.compose.ui.spatial.RectListKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

/* compiled from: SlotTable.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0015\n\u0002\b\u0016\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010H\u001a\u00020C2\b\b\u0002\u0010I\u001a\u00020\nJ\u0006\u0010J\u001a\u00020KJ\u0006\u0010L\u001a\u00020KJ\u000e\u0010M\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\nJ\u0006\u0010N\u001a\u00020KJ\u0006\u0010O\u001a\u00020KJ\f\u0010P\u001a\b\u0012\u0004\u0012\u00020R0QJ\u0010\u0010S\u001a\u0004\u0018\u00010\u00012\u0006\u0010I\u001a\u00020\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010I\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nJ\u0010\u0010T\u001a\u0004\u0018\u00010\u00012\u0006\u0010I\u001a\u00020\nJ\u0018\u0010T\u001a\u0004\u0018\u00010\u00012\u0006\u0010U\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010H\u001a\u00020CJ\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u0006\u0010I\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\n2\u0006\u0010I\u001a\u00020\nJ\u000e\u0010V\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\nJ\u000e\u0010+\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\nJ\u000e\u00100\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\nJ\b\u0010W\u001a\u0004\u0018\u00010\u0001J\u0010\u0010X\u001a\u0004\u0018\u00010\u00012\u0006\u0010I\u001a\u00020\nJ\u000e\u00101\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nJ\u000e\u00103\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nJ\u000e\u0010Y\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nJ\u000e\u0010Z\u001a\u00020K2\u0006\u0010I\u001a\u00020\nJ\u000e\u0010[\u001a\u00020K2\u0006\u0010I\u001a\u00020\nJ\u0006\u0010\\\u001a\u00020\nJ\u0006\u0010]\u001a\u00020KJ\u0006\u0010^\u001a\u00020KJ\u0006\u0010_\u001a\u00020KJ\b\u0010`\u001a\u00020aH\u0016J\u0016\u0010b\u001a\u0004\u0018\u00010\u0001*\u00020'2\u0006\u0010I\u001a\u00020\nH\u0002J\u0016\u0010X\u001a\u0004\u0018\u00010\u0001*\u00020'2\u0006\u0010I\u001a\u00020\nH\u0002J\u0016\u0010c\u001a\u0004\u0018\u00010\u0001*\u00020'2\u0006\u0010I\u001a\u00020\nH\u0002R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR\u0011\u0010\u001a\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\rR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010 \u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b!\u0010\rR\u0011\u0010\"\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b#\u0010\rR\u0011\u0010$\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b%\u0010\rR\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\tR\u0011\u0010+\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b,\u0010\tR\u0011\u0010-\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b.\u0010\tR\u0011\u0010/\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b/\u0010\tR\u0011\u00100\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b0\u0010\tR\u0011\u00101\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b2\u0010\rR\u001e\u00103\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\rR\u0011\u00105\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b6\u0010\rR\u0011\u00107\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b8\u0010\rR\u0011\u00109\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b:\u0010\rR\u0011\u0010;\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b<\u0010\rR\u0018\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010>X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?R\u000e\u0010@\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010A\u001a\"\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020D\u0018\u00010Bj\u0010\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020D\u0018\u0001`EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010G¨\u0006d"}, d2 = {"Landroidx/compose/runtime/SlotReader;", "", "table", "Landroidx/compose/runtime/SlotTable;", "(Landroidx/compose/runtime/SlotTable;)V", "<set-?>", "", "closed", "getClosed", "()Z", "", "currentEnd", "getCurrentEnd", "()I", "currentGroup", "getCurrentGroup", "currentSlot", "currentSlotEnd", "currentSlotStack", "Landroidx/compose/runtime/IntStack;", "emptyCount", "groupAux", "getGroupAux", "()Ljava/lang/Object;", "groupEnd", "getGroupEnd", "groupKey", "getGroupKey", "groupNode", "getGroupNode", "groupObjectKey", "getGroupObjectKey", "groupSize", "getGroupSize", "groupSlotCount", "getGroupSlotCount", "groupSlotIndex", "getGroupSlotIndex", "groups", "", "groupsSize", "hadNext", "getHadNext", "hasObjectKey", "getHasObjectKey", "inEmpty", "getInEmpty", "isGroupEnd", "isNode", "nodeCount", "getNodeCount", "parent", "getParent", "parentNodes", "getParentNodes", "remainingSlots", "getRemainingSlots", "size", "getSize", "slot", "getSlot", "slots", "", "[Ljava/lang/Object;", "slotsSize", "sourceInformationMap", "Ljava/util/HashMap;", "Landroidx/compose/runtime/Anchor;", "Landroidx/compose/runtime/GroupSourceInformation;", "Lkotlin/collections/HashMap;", "getTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "anchor", FirebaseAnalytics.Param.INDEX, "beginEmpty", "", "close", "containsMark", "endEmpty", "endGroup", "extractKeys", "", "Landroidx/compose/runtime/KeyInfo;", "get", "groupGet", "group", "hasMark", "next", "node", "parentOf", "reposition", "restoreParent", "skipGroup", "skipToGroupEnd", "startGroup", "startNode", "toString", "", "aux", "objectKey", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class SlotReader {
    public static final int $stable = 8;
    private boolean closed;
    private int currentEnd;
    private int currentGroup;
    private int currentSlot;
    private int currentSlotEnd;
    private final IntStack currentSlotStack;
    private int emptyCount;
    private final int[] groups;
    private final int groupsSize;
    private boolean hadNext;
    private int parent;
    private final Object[] slots;
    private final int slotsSize;
    private HashMap<Anchor, GroupSourceInformation> sourceInformationMap;
    private final SlotTable table;

    public SlotReader(SlotTable slotTable) {
        this.table = slotTable;
        this.groups = slotTable.getGroups();
        int groupsSize = slotTable.getGroupsSize();
        this.groupsSize = groupsSize;
        this.slots = slotTable.getSlots();
        this.slotsSize = slotTable.getSlotsSize();
        this.currentEnd = groupsSize;
        this.parent = -1;
        this.currentSlotStack = new IntStack();
    }

    /* renamed from: getTable$runtime_release, reason: from getter */
    public final SlotTable getTable() {
        return this.table;
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final int getCurrentEnd() {
        return this.currentEnd;
    }

    public final int getParent() {
        return this.parent;
    }

    /* renamed from: getSize, reason: from getter */
    public final int getGroupsSize() {
        return this.groupsSize;
    }

    public final int getSlot() {
        int slotAnchor;
        int i = this.currentSlot;
        slotAnchor = SlotTableKt.slotAnchor(this.groups, this.parent);
        return i - slotAnchor;
    }

    public final int parent(int r1) {
        return this.groups[(r1 * 5) + 2];
    }

    public final boolean isNode() {
        return (this.groups[(this.currentGroup * 5) + 1] & 1073741824) != 0;
    }

    public final boolean isNode(int r2) {
        return (this.groups[(r2 * 5) + 1] & 1073741824) != 0;
    }

    public final int getNodeCount() {
        return this.groups[(this.currentGroup * 5) + 1] & RectListKt.Lower26Bits;
    }

    public final int nodeCount(int r1) {
        return this.groups[(r1 * 5) + 1] & RectListKt.Lower26Bits;
    }

    public final Object node(int r4) {
        int[] iArr = this.groups;
        if ((iArr[(r4 * 5) + 1] & 1073741824) != 0) {
            return node(iArr, r4);
        }
        return null;
    }

    public final boolean isGroupEnd() {
        return getInEmpty() || this.currentGroup == this.currentEnd;
    }

    public final boolean getInEmpty() {
        return this.emptyCount > 0;
    }

    public final int getGroupSize() {
        int groupSize;
        groupSize = SlotTableKt.groupSize(this.groups, this.currentGroup);
        return groupSize;
    }

    public final int groupSize(int r1) {
        int groupSize;
        groupSize = SlotTableKt.groupSize(this.groups, r1);
        return groupSize;
    }

    public final int getGroupEnd() {
        return this.currentEnd;
    }

    public final int groupEnd(int r1) {
        int groupSize;
        groupSize = SlotTableKt.groupSize(this.groups, r1);
        return r1 + groupSize;
    }

    public final int getGroupKey() {
        int i = this.currentGroup;
        if (i < this.currentEnd) {
            return this.groups[i * 5];
        }
        return 0;
    }

    public final int groupKey(int r1) {
        return this.groups[r1 * 5];
    }

    public final int getGroupSlotIndex() {
        int slotAnchor;
        int i = this.currentSlot;
        slotAnchor = SlotTableKt.slotAnchor(this.groups, this.parent);
        return i - slotAnchor;
    }

    public final boolean hasObjectKey(int r2) {
        return (this.groups[(r2 * 5) + 1] & 536870912) != 0;
    }

    public final boolean getHasObjectKey() {
        int i = this.currentGroup;
        return i < this.currentEnd && (this.groups[(i * 5) + 1] & 536870912) != 0;
    }

    public final Object getGroupObjectKey() {
        int i = this.currentGroup;
        if (i < this.currentEnd) {
            return objectKey(this.groups, i);
        }
        return null;
    }

    public final Object groupObjectKey(int r2) {
        return objectKey(this.groups, r2);
    }

    public final Object getGroupAux() {
        int i = this.currentGroup;
        if (i < this.currentEnd) {
            return aux(this.groups, i);
        }
        return 0;
    }

    public final Object groupAux(int r2) {
        return aux(this.groups, r2);
    }

    public final Object getGroupNode() {
        int i = this.currentGroup;
        if (i < this.currentEnd) {
            return node(this.groups, i);
        }
        return null;
    }

    public final int groupKey(Anchor anchor) {
        if (anchor.getValid()) {
            return this.groups[this.table.anchorIndex(anchor) * 5];
        }
        return 0;
    }

    public final boolean hasMark(int r2) {
        return (this.groups[(r2 * 5) + 1] & 134217728) != 0;
    }

    public final boolean containsMark(int r2) {
        return (this.groups[(r2 * 5) + 1] & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0;
    }

    public final int getParentNodes() {
        int i = this.parent;
        if (i >= 0) {
            return this.groups[(i * 5) + 1] & RectListKt.Lower26Bits;
        }
        return 0;
    }

    public final int getRemainingSlots() {
        return this.currentSlotEnd - this.currentSlot;
    }

    public final int parentOf(int r3) {
        if (!(r3 >= 0 && r3 < this.groupsSize)) {
            PreconditionsKt.throwIllegalArgumentException("Invalid group index " + r3);
        }
        return this.groups[(r3 * 5) + 2];
    }

    public final int getGroupSlotCount() {
        int slotAnchor;
        int i;
        int i2 = this.currentGroup;
        slotAnchor = SlotTableKt.slotAnchor(this.groups, i2);
        int i3 = i2 + 1;
        if (i3 >= this.groupsSize) {
            i = this.slotsSize;
        } else {
            i = this.groups[(i3 * 5) + 4];
        }
        return i - slotAnchor;
    }

    public final Object get(int r2) {
        int i = this.currentSlot + r2;
        return i < this.currentSlotEnd ? this.slots[i] : Composer.INSTANCE.getEmpty();
    }

    public final Object groupGet(int r2) {
        return groupGet(this.currentGroup, r2);
    }

    public final Object groupGet(int group, int r4) {
        int slotAnchor;
        int i;
        slotAnchor = SlotTableKt.slotAnchor(this.groups, group);
        int i2 = group + 1;
        if (i2 >= this.groupsSize) {
            i = this.slotsSize;
        } else {
            i = this.groups[(i2 * 5) + 4];
        }
        int i3 = slotAnchor + r4;
        return i3 < i ? this.slots[i3] : Composer.INSTANCE.getEmpty();
    }

    public final Object next() {
        int i;
        if (this.emptyCount > 0 || (i = this.currentSlot) >= this.currentSlotEnd) {
            this.hadNext = false;
            return Composer.INSTANCE.getEmpty();
        }
        this.hadNext = true;
        Object[] objArr = this.slots;
        this.currentSlot = i + 1;
        return objArr[i];
    }

    public final boolean getHadNext() {
        return this.hadNext;
    }

    public final void beginEmpty() {
        this.emptyCount++;
    }

    public final void endEmpty() {
        if (!(this.emptyCount > 0)) {
            PreconditionsKt.throwIllegalArgumentException("Unbalanced begin/end empty");
        }
        this.emptyCount--;
    }

    public final void close() {
        this.closed = true;
        this.table.close$runtime_release(this, this.sourceInformationMap);
    }

    public final void startGroup() {
        int groupSize;
        int slotAnchor;
        GroupSourceInformation groupSourceInformation;
        if (this.emptyCount <= 0) {
            int i = this.parent;
            int i2 = this.currentGroup;
            if (!(this.groups[(i2 * 5) + 2] == i)) {
                PreconditionsKt.throwIllegalArgumentException("Invalid slot table detected");
            }
            HashMap<Anchor, GroupSourceInformation> hashMap = this.sourceInformationMap;
            if (hashMap != null && (groupSourceInformation = hashMap.get(anchor(i))) != null) {
                groupSourceInformation.reportGroup(this.table, i2);
            }
            IntStack intStack = this.currentSlotStack;
            int i3 = this.currentSlot;
            int i4 = this.currentSlotEnd;
            if (i3 == 0 && i4 == 0) {
                intStack.push(-1);
            } else {
                intStack.push(i3);
            }
            this.parent = i2;
            groupSize = SlotTableKt.groupSize(this.groups, i2);
            this.currentEnd = groupSize + i2;
            int i5 = i2 + 1;
            this.currentGroup = i5;
            slotAnchor = SlotTableKt.slotAnchor(this.groups, i2);
            this.currentSlot = slotAnchor;
            this.currentSlotEnd = i2 >= this.groupsSize - 1 ? this.slotsSize : this.groups[(i5 * 5) + 4];
        }
    }

    public final void startNode() {
        if (this.emptyCount <= 0) {
            if (!((this.groups[(this.currentGroup * 5) + 1] & 1073741824) != 0)) {
                PreconditionsKt.throwIllegalArgumentException("Expected a node group");
            }
            startGroup();
        }
    }

    public final int skipGroup() {
        int groupSize;
        if (!(this.emptyCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot skip while in an empty region");
        }
        int[] iArr = this.groups;
        int i = this.currentGroup;
        int i2 = (iArr[(i * 5) + 1] & 1073741824) == 0 ? iArr[(i * 5) + 1] & RectListKt.Lower26Bits : 1;
        groupSize = SlotTableKt.groupSize(iArr, i);
        this.currentGroup = i + groupSize;
        return i2;
    }

    public final void skipToGroupEnd() {
        if (!(this.emptyCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot skip the enclosing group while in an empty region");
        }
        this.currentGroup = this.currentEnd;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
    }

    public final void reposition(int r4) {
        int groupSize;
        if (!(this.emptyCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot reposition while in an empty region");
        }
        this.currentGroup = r4;
        int i = this.groupsSize;
        int i2 = r4 < i ? this.groups[(r4 * 5) + 2] : -1;
        this.parent = i2;
        if (i2 >= 0) {
            groupSize = SlotTableKt.groupSize(this.groups, i2);
            this.currentEnd = i2 + groupSize;
        } else {
            this.currentEnd = i;
        }
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
    }

    public final void restoreParent(int r6) {
        int groupSize;
        groupSize = SlotTableKt.groupSize(this.groups, r6);
        int i = groupSize + r6;
        int i2 = this.currentGroup;
        if (!(i2 >= r6 && i2 <= i)) {
            ComposerKt.composeImmediateRuntimeError("Index " + r6 + " is not a parent of " + i2);
        }
        this.parent = r6;
        this.currentEnd = i;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
    }

    public final void endGroup() {
        int groupSize;
        int i;
        if (this.emptyCount == 0) {
            if (!(this.currentGroup == this.currentEnd)) {
                ComposerKt.composeImmediateRuntimeError("endGroup() not called at the end of a group");
            }
            int[] iArr = this.groups;
            int i2 = iArr[(this.parent * 5) + 2];
            this.parent = i2;
            if (i2 >= 0) {
                groupSize = SlotTableKt.groupSize(iArr, i2);
                i = groupSize + i2;
            } else {
                i = this.groupsSize;
            }
            this.currentEnd = i;
            int pop = this.currentSlotStack.pop();
            if (pop < 0) {
                this.currentSlot = 0;
                this.currentSlotEnd = 0;
            } else {
                this.currentSlot = pop;
                this.currentSlotEnd = i2 >= this.groupsSize - 1 ? this.slotsSize : this.groups[((i2 + 1) * 5) + 4];
            }
        }
    }

    public final List<KeyInfo> extractKeys() {
        int groupSize;
        ArrayList arrayList = new ArrayList();
        if (this.emptyCount <= 0) {
            int i = 0;
            int i2 = this.currentGroup;
            while (true) {
                int i3 = i;
                if (i2 >= this.currentEnd) {
                    break;
                }
                int[] iArr = this.groups;
                int i4 = i2 * 5;
                int i5 = iArr[i4];
                Object objectKey = objectKey(iArr, i2);
                int i6 = 1;
                int i7 = this.groups[i4 + 1];
                if ((1073741824 & i7) == 0) {
                    i6 = i7 & RectListKt.Lower26Bits;
                }
                i = i3 + 1;
                arrayList.add(new KeyInfo(i5, objectKey, i2, i6, i3));
                groupSize = SlotTableKt.groupSize(this.groups, i2);
                i2 += groupSize;
            }
        }
        return arrayList;
    }

    public String toString() {
        return "SlotReader(current=" + this.currentGroup + ", key=" + getGroupKey() + ", parent=" + this.parent + ", end=" + this.currentEnd + ')';
    }

    public static /* synthetic */ Anchor anchor$default(SlotReader slotReader, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = slotReader.currentGroup;
        }
        return slotReader.anchor(i);
    }

    public final Anchor anchor(int r3) {
        ArrayList<Anchor> anchors$runtime_release = this.table.getAnchors$runtime_release();
        int search = SlotTableKt.search(anchors$runtime_release, r3, this.groupsSize);
        if (search < 0) {
            Anchor anchor = new Anchor(r3);
            anchors$runtime_release.add(-(search + 1), anchor);
            return anchor;
        }
        return anchors$runtime_release.get(search);
    }

    private final Object node(int[] iArr, int i) {
        int i2 = i * 5;
        if ((iArr[i2 + 1] & 1073741824) == 0) {
            return Composer.INSTANCE.getEmpty();
        }
        return this.slots[iArr[i2 + 4]];
    }

    private final Object aux(int[] iArr, int i) {
        int auxIndex;
        if ((iArr[(i * 5) + 1] & 268435456) != 0) {
            Object[] objArr = this.slots;
            auxIndex = SlotTableKt.auxIndex(iArr, i);
            return objArr[auxIndex];
        }
        return Composer.INSTANCE.getEmpty();
    }

    private final Object objectKey(int[] iArr, int i) {
        int objectKeyIndex;
        if ((iArr[(i * 5) + 1] & 536870912) == 0) {
            return null;
        }
        Object[] objArr = this.slots;
        objectKeyIndex = SlotTableKt.objectKeyIndex(iArr, i);
        return objArr[objectKeyIndex];
    }
}
