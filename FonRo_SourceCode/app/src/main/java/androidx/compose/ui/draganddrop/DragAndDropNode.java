package androidx.compose.ui.draganddrop;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;

/* compiled from: DragAndDropNode.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 D2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001DBB\u0012!\b\u0002\u0010\u0007\u001a\u001b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b¢\u0006\u0002\b\f\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u000fH\u0016J;\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\u0002\b\fH\u0017ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000fH\u0016J\b\u00103\u001a\u00020\u000bH\u0016J\u0010\u00104\u001a\u00020\u00162\u0006\u00102\u001a\u00020\u000fH\u0016J\u0010\u00105\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000fH\u0016J\u0010\u00106\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000fH\u0016J\u0010\u00107\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000fH\u0016J\u0010\u00108\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000fH\u0016J\u001a\u00109\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b:\u0010\u001fJ\u0010\u0010;\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000fH\u0016J\u001a\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b>\u0010\u001fJ*\u0010?\u001a\u00020\u000b*\u00020\t2\u0006\u0010=\u001a\u00020\n2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00160Aø\u0001\u0000¢\u0006\u0004\bB\u0010CR\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0007\u001a\u001b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b¢\u0006\u0002\b\fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001a\u001a\u00020\u001bX\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010!\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020#X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006E"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "Landroidx/compose/ui/draganddrop/DragAndDropSourceModifierNode;", "Landroidx/compose/ui/draganddrop/DragAndDropTargetModifierNode;", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "onStartTransfer", "Lkotlin/Function2;", "Landroidx/compose/ui/draganddrop/DragAndDropStartTransferScope;", "Landroidx/compose/ui/geometry/Offset;", "", "Lkotlin/ExtensionFunctionType;", "onDropTargetValidate", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "dragAndDropManager", "Landroidx/compose/ui/draganddrop/DragAndDropManager;", "getDragAndDropManager", "()Landroidx/compose/ui/draganddrop/DragAndDropManager;", "hasEligibleDropTarget", "", "()Z", "isRequestDragAndDropTransferRequired", "lastChildDragAndDropModifierNode", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g$ui_release", "()J", "setSize-ozmzZPI$ui_release", "(J)V", "J", "thisDragAndDropTarget", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "acceptDragAndDropTransfer", "startEvent", "drag", "transferData", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)V", "onChanged", NotificationCompat.CATEGORY_EVENT, "onDetach", "onDrop", "onEnded", "onEntered", "onExited", "onMoved", "onRemeasured", "onRemeasured-ozmzZPI", "onStarted", "requestDragAndDropTransfer", TypedValues.CycleType.S_WAVE_OFFSET, "requestDragAndDropTransfer-k-4lQ0M", "startDragAndDropTransfer", "isTransferStarted", "Lkotlin/Function0;", "startDragAndDropTransfer-d-4ec7I", "(Landroidx/compose/ui/draganddrop/DragAndDropStartTransferScope;JLkotlin/jvm/functions/Function0;)V", "Companion", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class DragAndDropNode extends Modifier.Node implements TraversableNode, DragAndDropModifierNode, DragAndDropSourceModifierNode, DragAndDropTargetModifierNode, DragAndDropTarget {
    private DragAndDropNode lastChildDragAndDropModifierNode;
    private final Function1<DragAndDropEvent, DragAndDropTarget> onDropTargetValidate;
    private Function2<? super DragAndDropStartTransferScope, ? super Offset, Unit> onStartTransfer;
    private long size;
    private DragAndDropTarget thisDragAndDropTarget;
    private final Object traverseKey;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public DragAndDropNode() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public /* synthetic */ DragAndDropNode(Function2 function2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function2, (i & 2) != 0 ? null : function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DragAndDropNode(Function2<? super DragAndDropStartTransferScope, ? super Offset, Unit> function2, Function1<? super DragAndDropEvent, ? extends DragAndDropTarget> function1) {
        this.onStartTransfer = function2;
        this.onDropTargetValidate = function1;
        this.traverseKey = Companion.DragAndDropTraversableKey.INSTANCE;
        this.size = IntSize.INSTANCE.m7165getZeroYbymL2g();
    }

    /* compiled from: DragAndDropNode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropNode$Companion;", "", "()V", "DragAndDropTraversableKey", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: DragAndDropNode.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropNode$Companion$DragAndDropTraversableKey;", "", "()V", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes4.dex */
        private static final class DragAndDropTraversableKey {
            public static final DragAndDropTraversableKey INSTANCE = new DragAndDropTraversableKey();

            private DragAndDropTraversableKey() {
            }
        }

        private Companion() {
        }
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DragAndDropManager getDragAndDropManager() {
        return DelegatableNodeKt.requireOwner(this).getDragAndDropManager();
    }

    public final boolean hasEligibleDropTarget() {
        return (this.lastChildDragAndDropModifierNode == null && this.thisDragAndDropTarget == null) ? false : true;
    }

    /* renamed from: getSize-YbymL2g$ui_release, reason: not valid java name and from getter */
    public final long getSize() {
        return this.size;
    }

    /* renamed from: setSize-ozmzZPI$ui_release, reason: not valid java name */
    public final void m3966setSizeozmzZPI$ui_release(long j) {
        this.size = j;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.thisDragAndDropTarget = null;
        this.lastChildDragAndDropModifierNode = null;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    /* renamed from: onRemeasured-ozmzZPI */
    public void mo688onRemeasuredozmzZPI(long size) {
        this.size = size;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropSourceModifierNode
    public boolean isRequestDragAndDropTransferRequired() {
        return getDragAndDropManager().isRequestDragAndDropTransferRequired();
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropSourceModifierNode
    /* renamed from: requestDragAndDropTransfer-k-4lQ0M, reason: not valid java name */
    public void mo3965requestDragAndDropTransferk4lQ0M(long offset) {
        if (!(this.onStartTransfer != null)) {
            InlineClassHelperKt.throwIllegalStateException("Check failed.");
        }
        getDragAndDropManager().mo3961requestDragAndDropTransferUv8p0NA(this, offset);
    }

    /* renamed from: startDragAndDropTransfer-d-4ec7I, reason: not valid java name */
    public final void m3967startDragAndDropTransferd4ec7I(final DragAndDropStartTransferScope dragAndDropStartTransferScope, final long j, final Function0<Boolean> function0) {
        final LayoutCoordinates coordinates = DelegatableNodeKt.requireLayoutNode(this).getCoordinates();
        DragAndDropNodeKt.traverseSelfAndDescendants(this, new Function1<DragAndDropNode, TraversableNode.Companion.TraverseDescendantsAction>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNode$startDragAndDropTransfer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TraversableNode.Companion.TraverseDescendantsAction invoke(DragAndDropNode dragAndDropNode) {
                Function2 function2;
                if (dragAndDropNode.getIsAttached()) {
                    function2 = dragAndDropNode.onStartTransfer;
                    if (function2 == null) {
                        return TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                    }
                    if (!Offset.m4122equalsimpl0(j, Offset.INSTANCE.m4140getUnspecifiedF1C5BW0())) {
                        long mo5741localPositionOfR5De75A = DelegatableNodeKt.requireLayoutNode(dragAndDropNode).getCoordinates().mo5741localPositionOfR5De75A(coordinates, j);
                        if (!SizeKt.m4215toRectuvyYCjk(IntSizeKt.m7172toSizeozmzZPI(dragAndDropNode.getSize())).m4151containsk4lQ0M(mo5741localPositionOfR5De75A)) {
                            return TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                        }
                        function2.invoke(dragAndDropStartTransferScope, Offset.m4114boximpl(mo5741localPositionOfR5De75A));
                    } else {
                        function2.invoke(dragAndDropStartTransferScope, Offset.m4114boximpl(Offset.INSTANCE.m4140getUnspecifiedF1C5BW0()));
                    }
                    if (function0.invoke().booleanValue()) {
                        return TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal;
                    }
                    return TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                }
                return TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
            }
        });
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropModifierNode
    @Deprecated(message = "Use DragAndDropSourceModifierNode.requestDragAndDropTransfer instead")
    /* renamed from: drag-12SF9DM */
    public void mo3963drag12SF9DM(final DragAndDropTransferData transferData, final long decorationSize, final Function1<? super DrawScope, Unit> drawDragDecoration) {
        if (!(this.onStartTransfer == null)) {
            InlineClassHelperKt.throwIllegalStateException("Check failed.");
        }
        this.onStartTransfer = new Function2<DragAndDropStartTransferScope, Offset, Unit>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNode$drag$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(DragAndDropStartTransferScope dragAndDropStartTransferScope, Offset offset) {
                m3968invokeUv8p0NA(dragAndDropStartTransferScope, offset.m4135unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
            public final void m3968invokeUv8p0NA(DragAndDropStartTransferScope dragAndDropStartTransferScope, long j) {
                dragAndDropStartTransferScope.mo3962startDragAndDropTransfer12SF9DM(DragAndDropTransferData.this, decorationSize, drawDragDecoration);
            }
        };
        getDragAndDropManager().mo3961requestDragAndDropTransferUv8p0NA(this, Offset.INSTANCE.m4140getUnspecifiedF1C5BW0());
        this.onStartTransfer = null;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropModifierNode
    public boolean acceptDragAndDropTransfer(final DragAndDropEvent startEvent) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        DragAndDropNodeKt.traverseSelfAndDescendants(this, new Function1<DragAndDropNode, TraversableNode.Companion.TraverseDescendantsAction>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNode$acceptDragAndDropTransfer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TraversableNode.Companion.TraverseDescendantsAction invoke(DragAndDropNode dragAndDropNode) {
                DragAndDropTarget dragAndDropTarget;
                Function1 function1;
                DragAndDropTarget dragAndDropTarget2;
                DragAndDropManager dragAndDropManager;
                if (dragAndDropNode.getIsAttached()) {
                    dragAndDropTarget = dragAndDropNode.thisDragAndDropTarget;
                    boolean z = true;
                    if (!(dragAndDropTarget == null)) {
                        InlineClassHelperKt.throwIllegalStateException("DragAndDropTarget self reference must be null at the start of a drag and drop session");
                    }
                    function1 = dragAndDropNode.onDropTargetValidate;
                    dragAndDropNode.thisDragAndDropTarget = function1 != null ? (DragAndDropTarget) function1.invoke(DragAndDropEvent.this) : null;
                    dragAndDropTarget2 = dragAndDropNode.thisDragAndDropTarget;
                    boolean z2 = dragAndDropTarget2 != null;
                    if (z2) {
                        dragAndDropManager = this.getDragAndDropManager();
                        dragAndDropManager.registerTargetInterest(dragAndDropNode);
                    }
                    Ref.BooleanRef booleanRef2 = booleanRef;
                    if (!booleanRef2.element && !z2) {
                        z = false;
                    }
                    booleanRef2.element = z;
                    return TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                }
                return TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
            }
        });
        return booleanRef.element;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void onStarted(DragAndDropEvent event) {
        DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
        if (dragAndDropTarget == null) {
            DragAndDropNode dragAndDropNode = this.lastChildDragAndDropModifierNode;
            if (dragAndDropNode != null) {
                dragAndDropNode.onStarted(event);
                return;
            }
            return;
        }
        dragAndDropTarget.onStarted(event);
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void onEntered(DragAndDropEvent event) {
        DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
        if (dragAndDropTarget == null) {
            DragAndDropNode dragAndDropNode = this.lastChildDragAndDropModifierNode;
            if (dragAndDropNode != null) {
                dragAndDropNode.onEntered(event);
                return;
            }
            return;
        }
        dragAndDropTarget.onEntered(event);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMoved(final androidx.compose.ui.draganddrop.DragAndDropEvent r5) {
        /*
            r4 = this;
            androidx.compose.ui.draganddrop.DragAndDropNode r0 = r4.lastChildDragAndDropModifierNode
            if (r0 == 0) goto L11
            long r1 = androidx.compose.ui.draganddrop.DragAndDrop_androidKt.getPositionInRoot(r5)
            boolean r1 = androidx.compose.ui.draganddrop.DragAndDropNodeKt.m3969access$containsUv8p0NA(r0, r1)
            r2 = 1
            if (r1 != r2) goto L11
            r1 = r0
            goto L35
        L11:
            r1 = r4
            androidx.compose.ui.node.TraversableNode r1 = (androidx.compose.ui.node.TraversableNode) r1
            androidx.compose.ui.Modifier$Node r2 = r1.getNode()
            boolean r2 = r2.getIsAttached()
            if (r2 != 0) goto L20
            r1 = 0
            goto L33
        L20:
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            androidx.compose.ui.draganddrop.DragAndDropNode$onMoved$$inlined$firstDescendantOrNull$1 r3 = new androidx.compose.ui.draganddrop.DragAndDropNode$onMoved$$inlined$firstDescendantOrNull$1
            r3.<init>()
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.ui.node.TraversableNodeKt.traverseDescendants(r1, r3)
            T r1 = r2.element
            androidx.compose.ui.node.TraversableNode r1 = (androidx.compose.ui.node.TraversableNode) r1
        L33:
            androidx.compose.ui.draganddrop.DragAndDropNode r1 = (androidx.compose.ui.draganddrop.DragAndDropNode) r1
        L35:
            if (r1 == 0) goto L47
            if (r0 != 0) goto L47
            r0 = r1
            androidx.compose.ui.draganddrop.DragAndDropTarget r0 = (androidx.compose.ui.draganddrop.DragAndDropTarget) r0
            androidx.compose.ui.draganddrop.DragAndDropNodeKt.access$dispatchEntered(r0, r5)
            androidx.compose.ui.draganddrop.DragAndDropTarget r0 = r4.thisDragAndDropTarget
            if (r0 == 0) goto L77
            r0.onExited(r5)
            goto L77
        L47:
            if (r1 != 0) goto L56
            if (r0 == 0) goto L56
            androidx.compose.ui.draganddrop.DragAndDropTarget r2 = r4.thisDragAndDropTarget
            if (r2 == 0) goto L52
            androidx.compose.ui.draganddrop.DragAndDropNodeKt.access$dispatchEntered(r2, r5)
        L52:
            r0.onExited(r5)
            goto L77
        L56:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r0)
            if (r2 != 0) goto L6a
            if (r1 == 0) goto L64
            r2 = r1
            androidx.compose.ui.draganddrop.DragAndDropTarget r2 = (androidx.compose.ui.draganddrop.DragAndDropTarget) r2
            androidx.compose.ui.draganddrop.DragAndDropNodeKt.access$dispatchEntered(r2, r5)
        L64:
            if (r0 == 0) goto L77
            r0.onExited(r5)
            goto L77
        L6a:
            if (r1 == 0) goto L70
            r1.onMoved(r5)
            goto L77
        L70:
            androidx.compose.ui.draganddrop.DragAndDropTarget r0 = r4.thisDragAndDropTarget
            if (r0 == 0) goto L77
            r0.onMoved(r5)
        L77:
            r4.lastChildDragAndDropModifierNode = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.draganddrop.DragAndDropNode.onMoved(androidx.compose.ui.draganddrop.DragAndDropEvent):void");
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void onChanged(DragAndDropEvent event) {
        DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
        if (dragAndDropTarget == null) {
            DragAndDropNode dragAndDropNode = this.lastChildDragAndDropModifierNode;
            if (dragAndDropNode != null) {
                dragAndDropNode.onChanged(event);
                return;
            }
            return;
        }
        dragAndDropTarget.onChanged(event);
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void onExited(DragAndDropEvent event) {
        DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
        if (dragAndDropTarget != null) {
            dragAndDropTarget.onExited(event);
        }
        DragAndDropNode dragAndDropNode = this.lastChildDragAndDropModifierNode;
        if (dragAndDropNode != null) {
            dragAndDropNode.onExited(event);
        }
        this.lastChildDragAndDropModifierNode = null;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public boolean onDrop(DragAndDropEvent event) {
        DragAndDropNode dragAndDropNode = this.lastChildDragAndDropModifierNode;
        if (dragAndDropNode == null) {
            DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
            if (dragAndDropTarget != null) {
                return dragAndDropTarget.onDrop(event);
            }
            return false;
        }
        return dragAndDropNode.onDrop(event);
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void onEnded(final DragAndDropEvent event) {
        DragAndDropNodeKt.traverseSelfAndDescendants(this, new Function1<DragAndDropNode, TraversableNode.Companion.TraverseDescendantsAction>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNode$onEnded$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TraversableNode.Companion.TraverseDescendantsAction invoke(DragAndDropNode dragAndDropNode) {
                DragAndDropTarget dragAndDropTarget;
                if (dragAndDropNode.getNode().getIsAttached()) {
                    dragAndDropTarget = dragAndDropNode.thisDragAndDropTarget;
                    if (dragAndDropTarget != null) {
                        dragAndDropTarget.onEnded(DragAndDropEvent.this);
                    }
                    dragAndDropNode.thisDragAndDropTarget = null;
                    dragAndDropNode.lastChildDragAndDropModifierNode = null;
                    return TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                }
                return TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
            }
        });
    }
}
