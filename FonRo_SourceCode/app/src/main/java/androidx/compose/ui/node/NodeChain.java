package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NodeChain.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0002klB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u0010H\u0002J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0010H\u0002J?\u0010+\u001a\u0004\u0018\u0001H,\"\u0006\b\u0000\u0010,\u0018\u00012\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0.2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u00020\u001900H\u0080\bø\u0001\u0000¢\u0006\u0004\b1\u00102J@\u00103\u001a\u00060\rR\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u00062\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u00107\u001a\u00020\u0019H\u0002J\f\u00108\u001a\b\u0012\u0004\u0012\u00020:09J\u001e\u0010;\u001a\u00020\u00192\n\u0010-\u001a\u0006\u0012\u0002\b\u00030.H\u0000ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u0015\u0010;\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\u0006H\u0000¢\u0006\u0002\b?J+\u0010\u0011\u001a\u0004\u0018\u0001H,\"\u0006\b\u0000\u0010,\u0018\u00012\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0.H\u0080\bø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\"\u0010B\u001a\u00020C2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020C00H\u0080\b¢\u0006\u0002\bDJ=\u0010B\u001a\u00020C\"\u0006\b\u0000\u0010,\u0018\u00012\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0.2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u00020C00H\u0080\bø\u0001\u0000¢\u0006\u0004\bE\u0010FJ*\u0010B\u001a\u00020C2\u0006\u0010>\u001a\u00020\u00062\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020C00H\u0080\b¢\u0006\u0002\bDJ\"\u0010G\u001a\u00020C2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020C00H\u0080\b¢\u0006\u0002\bHJ\u0018\u0010I\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0010H\u0002J\u0006\u0010J\u001a\u00020CJ\r\u0010K\u001a\u00020CH\u0000¢\u0006\u0002\bLJ\b\u0010M\u001a\u00020\u0010H\u0002J\u0018\u0010N\u001a\u00020C2\u0006\u0010O\u001a\u00020\u00102\u0006\u0010P\u001a\u00020 H\u0002J\u0010\u0010Q\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0010H\u0002J\r\u0010R\u001a\u00020CH\u0000¢\u0006\u0002\bSJ\u0006\u0010T\u001a\u00020CJ\r\u0010U\u001a\u00020CH\u0000¢\u0006\u0002\bVJ<\u0010W\u001a\u00020C2\u0006\u00104\u001a\u00020\u00062\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010$\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0019H\u0002J\b\u0010X\u001a\u00020CH\u0002J\u0006\u0010Y\u001a\u00020CJ+\u0010$\u001a\u0004\u0018\u0001H,\"\u0006\b\u0000\u0010,\u0018\u00012\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0.H\u0080\bø\u0001\u0000¢\u0006\u0004\bZ\u0010AJ\"\u0010[\u001a\u00020C2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020C00H\u0080\b¢\u0006\u0002\b\\J=\u0010[\u001a\u00020C\"\u0006\b\u0000\u0010,\u0018\u00012\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0.2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u00020C00H\u0080\bø\u0001\u0000¢\u0006\u0004\b]\u0010FJ*\u0010[\u001a\u00020C2\u0006\u0010>\u001a\u00020\u00062\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020C00H\u0080\b¢\u0006\u0002\b\\J\b\u0010^\u001a\u00020_H\u0016J\u0010\u0010`\u001a\u00020\u00102\u0006\u0010a\u001a\u00020\u0010H\u0002J\u0015\u0010b\u001a\u00020C2\u0006\u0010c\u001a\u00020dH\u0000¢\u0006\u0002\beJ \u0010f\u001a\u00020C2\u0006\u0010g\u001a\u00020\u000b2\u0006\u0010h\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u0010H\u0002J\u0017\u0010i\u001a\u00020C2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0002\bjR\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0018\u00010\rR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020 @BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006m"}, d2 = {"Landroidx/compose/ui/node/NodeChain;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "aggregateChildKindSet", "", "getAggregateChildKindSet", "()I", "buffer", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "cachedDiffer", "Landroidx/compose/ui/node/NodeChain$Differ;", "current", "<set-?>", "Landroidx/compose/ui/Modifier$Node;", "head", "getHead$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "innerCoordinator", "Landroidx/compose/ui/node/InnerNodeCoordinator;", "getInnerCoordinator$ui_release", "()Landroidx/compose/ui/node/InnerNodeCoordinator;", "isUpdating", "", "isUpdating$ui_release", "()Z", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "logger", "Landroidx/compose/ui/node/NodeChain$Logger;", "Landroidx/compose/ui/node/NodeCoordinator;", "outerCoordinator", "getOuterCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "tail", "getTail$ui_release", "createAndInsertNodeAsChild", "element", "parent", "detachAndRemoveNode", "node", "firstFromHead", ExifInterface.GPS_DIRECTION_TRUE, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Landroidx/compose/ui/node/NodeKind;", "block", "Lkotlin/Function1;", "firstFromHead-aLcG6gQ$ui_release", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getDiffer", TypedValues.CycleType.S_WAVE_OFFSET, "before", "after", "shouldAttachOnInsert", "getModifierInfo", "", "Landroidx/compose/ui/layout/ModifierInfo;", "has", "has-H91voCI$ui_release", "(I)Z", "mask", "has$ui_release", "head-H91voCI$ui_release", "(I)Ljava/lang/Object;", "headToTail", "", "headToTail$ui_release", "headToTail-aLcG6gQ$ui_release", "(ILkotlin/jvm/functions/Function1;)V", "headToTailExclusive", "headToTailExclusive$ui_release", "insertChild", "markAsAttached", "markAsDetached", "markAsDetached$ui_release", "padChain", "propagateCoordinator", "start", "coordinator", "removeNode", "resetState", "resetState$ui_release", "runAttachLifecycle", "runDetachLifecycle", "runDetachLifecycle$ui_release", "structuralUpdate", "syncAggregateChildKindSet", "syncCoordinators", "tail-H91voCI$ui_release", "tailToHead", "tailToHead$ui_release", "tailToHead-aLcG6gQ$ui_release", "toString", "", "trimChain", "paddedHead", "updateFrom", "m", "Landroidx/compose/ui/Modifier;", "updateFrom$ui_release", "updateNode", "prev", "next", "useLogger", "useLogger$ui_release", "Differ", "Logger", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class NodeChain {
    public static final int $stable = 8;
    private MutableVector<Modifier.Element> buffer;
    private Differ cachedDiffer;
    private MutableVector<Modifier.Element> current;
    private Modifier.Node head;
    private final InnerNodeCoordinator innerCoordinator;
    private final LayoutNode layoutNode;
    private Logger logger;
    private NodeCoordinator outerCoordinator;
    private final Modifier.Node tail;

    /* compiled from: NodeChain.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH&J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeChain$Logger;", "", "linearDiffAborted", "", FirebaseAnalytics.Param.INDEX, "", "prev", "Landroidx/compose/ui/Modifier$Element;", "next", "node", "Landroidx/compose/ui/Modifier$Node;", "nodeInserted", "atIndex", "newIndex", "element", "child", "inserted", "nodeRemoved", "oldIndex", "nodeReused", "nodeUpdated", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public interface Logger {
        void linearDiffAborted(int r1, Modifier.Element prev, Modifier.Element next, Modifier.Node node);

        void nodeInserted(int atIndex, int newIndex, Modifier.Element element, Modifier.Node child, Modifier.Node inserted);

        void nodeRemoved(int oldIndex, Modifier.Element element, Modifier.Node node);

        void nodeReused(int oldIndex, int newIndex, Modifier.Element prev, Modifier.Element next, Modifier.Node node);

        void nodeUpdated(int oldIndex, int newIndex, Modifier.Element prev, Modifier.Element next, Modifier.Node node);
    }

    public NodeChain(LayoutNode layoutNode) {
        this.layoutNode = layoutNode;
        InnerNodeCoordinator innerNodeCoordinator = new InnerNodeCoordinator(layoutNode);
        this.innerCoordinator = innerNodeCoordinator;
        this.outerCoordinator = innerNodeCoordinator;
        TailModifierNode tail = innerNodeCoordinator.getTail();
        this.tail = tail;
        this.head = tail;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    /* renamed from: getInnerCoordinator$ui_release, reason: from getter */
    public final InnerNodeCoordinator getInnerCoordinator() {
        return this.innerCoordinator;
    }

    /* renamed from: getOuterCoordinator$ui_release, reason: from getter */
    public final NodeCoordinator getOuterCoordinator() {
        return this.outerCoordinator;
    }

    /* renamed from: getTail$ui_release, reason: from getter */
    public final Modifier.Node getTail() {
        return this.tail;
    }

    /* renamed from: getHead$ui_release, reason: from getter */
    public final Modifier.Node getHead() {
        return this.head;
    }

    public final boolean isUpdating$ui_release() {
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1;
        nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
        return nodeChainKt$SentinelHead$1.getChild() != null;
    }

    public final int getAggregateChildKindSet() {
        return this.head.getAggregateChildKindSet();
    }

    public final void useLogger$ui_release(Logger logger) {
        this.logger = logger;
    }

    private final Modifier.Node padChain() {
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$12;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$13;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$14;
        Modifier.Node node = this.head;
        nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
        if (!(node != nodeChainKt$SentinelHead$1)) {
            InlineClassHelperKt.throwIllegalStateException("padChain called on already padded chain");
        }
        Modifier.Node node2 = this.head;
        nodeChainKt$SentinelHead$12 = NodeChainKt.SentinelHead;
        node2.setParent$ui_release(nodeChainKt$SentinelHead$12);
        nodeChainKt$SentinelHead$13 = NodeChainKt.SentinelHead;
        nodeChainKt$SentinelHead$13.setChild$ui_release(node2);
        nodeChainKt$SentinelHead$14 = NodeChainKt.SentinelHead;
        return nodeChainKt$SentinelHead$14;
    }

    private final Modifier.Node trimChain(Modifier.Node paddedHead) {
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$12;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$13;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$14;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$15;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$16;
        nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
        if (!(paddedHead == nodeChainKt$SentinelHead$1)) {
            InlineClassHelperKt.throwIllegalStateException("trimChain called on already trimmed chain");
        }
        nodeChainKt$SentinelHead$12 = NodeChainKt.SentinelHead;
        Modifier.Node child$ui_release = nodeChainKt$SentinelHead$12.getChild();
        if (child$ui_release == null) {
            child$ui_release = this.tail;
        }
        child$ui_release.setParent$ui_release(null);
        nodeChainKt$SentinelHead$13 = NodeChainKt.SentinelHead;
        nodeChainKt$SentinelHead$13.setChild$ui_release(null);
        nodeChainKt$SentinelHead$14 = NodeChainKt.SentinelHead;
        nodeChainKt$SentinelHead$14.setAggregateChildKindSet$ui_release(-1);
        nodeChainKt$SentinelHead$15 = NodeChainKt.SentinelHead;
        nodeChainKt$SentinelHead$15.updateCoordinator$ui_release(null);
        nodeChainKt$SentinelHead$16 = NodeChainKt.SentinelHead;
        if (!(child$ui_release != nodeChainKt$SentinelHead$16)) {
            InlineClassHelperKt.throwIllegalStateException("trimChain did not update the head");
        }
        return child$ui_release;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void updateFrom$ui_release(androidx.compose.ui.Modifier r18) {
        /*
            Method dump skipped, instructions count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeChain.updateFrom$ui_release(androidx.compose.ui.Modifier):void");
    }

    public final void syncCoordinators() {
        LayoutModifierNodeCoordinator layoutModifierNodeCoordinator;
        InnerNodeCoordinator innerNodeCoordinator = this.innerCoordinator;
        for (Modifier.Node parent = this.tail.getParent(); parent != null; parent = parent.getParent()) {
            LayoutModifierNode asLayoutModifierNode = DelegatableNodeKt.asLayoutModifierNode(parent);
            if (asLayoutModifierNode != null) {
                if (parent.getCoordinator() != null) {
                    NodeCoordinator coordinator = parent.getCoordinator();
                    Intrinsics.checkNotNull(coordinator, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                    layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) coordinator;
                    LayoutModifierNode layoutModifierNode = layoutModifierNodeCoordinator.getLayoutModifierNode();
                    layoutModifierNodeCoordinator.setLayoutModifierNode$ui_release(asLayoutModifierNode);
                    if (layoutModifierNode != parent) {
                        layoutModifierNodeCoordinator.onLayoutModifierNodeChanged();
                    }
                } else {
                    layoutModifierNodeCoordinator = new LayoutModifierNodeCoordinator(this.layoutNode, asLayoutModifierNode);
                    parent.updateCoordinator$ui_release(layoutModifierNodeCoordinator);
                }
                LayoutModifierNodeCoordinator layoutModifierNodeCoordinator2 = layoutModifierNodeCoordinator;
                innerNodeCoordinator.setWrappedBy$ui_release(layoutModifierNodeCoordinator2);
                layoutModifierNodeCoordinator.setWrapped$ui_release(innerNodeCoordinator);
                innerNodeCoordinator = layoutModifierNodeCoordinator2;
            } else {
                parent.updateCoordinator$ui_release(innerNodeCoordinator);
            }
        }
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        innerNodeCoordinator.setWrappedBy$ui_release(parent$ui_release != null ? parent$ui_release.getInnerCoordinator$ui_release() : null);
        this.outerCoordinator = innerNodeCoordinator;
    }

    private final void syncAggregateChildKindSet() {
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1;
        int i = 0;
        for (Modifier.Node parent = this.tail.getParent(); parent != null; parent = parent.getParent()) {
            nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
            if (parent == nodeChainKt$SentinelHead$1) {
                return;
            }
            i |= parent.getKindSet();
            parent.setAggregateChildKindSet$ui_release(i);
        }
    }

    public final void runAttachLifecycle() {
        NodeCoordinator nodeCoordinator = this.outerCoordinator;
        InnerNodeCoordinator innerNodeCoordinator = this.innerCoordinator;
        while (nodeCoordinator != innerNodeCoordinator) {
            nodeCoordinator.onAttach();
            nodeCoordinator = nodeCoordinator.getWrapped();
            Intrinsics.checkNotNull(nodeCoordinator);
        }
        innerNodeCoordinator.onAttach();
        for (Modifier.Node head = getHead(); head != null; head = head.getChild()) {
            head.runAttachLifecycle$ui_release();
            if (head.getInsertedNodeAwaitingAttachForInvalidation()) {
                NodeKindKt.autoInvalidateInsertedNode(head);
            }
            if (head.getUpdatedNodeAwaitingAttachForInvalidation()) {
                NodeKindKt.autoInvalidateUpdatedNode(head);
            }
            head.setInsertedNodeAwaitingAttachForInvalidation$ui_release(false);
            head.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(false);
        }
    }

    public final List<ModifierInfo> getModifierInfo() {
        MutableVector<Modifier.Element> mutableVector = this.current;
        if (mutableVector == null) {
            return CollectionsKt.emptyList();
        }
        int i = 0;
        MutableVector mutableVector2 = new MutableVector(new ModifierInfo[mutableVector.getSize()], 0);
        Modifier.Node head = getHead();
        while (head != null && head != getTail()) {
            NodeCoordinator coordinator = head.getCoordinator();
            if (coordinator == null) {
                throw new IllegalArgumentException("getModifierInfo called on node with no coordinator".toString());
            }
            OwnedLayer layer = coordinator.getLayer();
            OwnedLayer layer2 = this.innerCoordinator.getLayer();
            Modifier.Node child = head.getChild();
            if (child != this.tail || head.getCoordinator() == child.getCoordinator()) {
                layer2 = null;
            }
            if (layer == null) {
                layer = layer2;
            }
            mutableVector2.add(new ModifierInfo(mutableVector.content[i], coordinator, layer));
            head = head.getChild();
            i++;
        }
        return mutableVector2.asMutableList();
    }

    private final Differ getDiffer(Modifier.Node head, int r10, MutableVector<Modifier.Element> before, MutableVector<Modifier.Element> after, boolean shouldAttachOnInsert) {
        Differ differ = this.cachedDiffer;
        if (differ == null) {
            Differ differ2 = new Differ(head, r10, before, after, shouldAttachOnInsert);
            this.cachedDiffer = differ2;
            return differ2;
        }
        differ.setNode(head);
        differ.setOffset(r10);
        differ.setBefore(before);
        differ.setAfter(after);
        differ.setShouldAttachOnInsert(shouldAttachOnInsert);
        return differ;
    }

    public final void propagateCoordinator(Modifier.Node start, NodeCoordinator coordinator) {
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1;
        for (Modifier.Node parent = start.getParent(); parent != null; parent = parent.getParent()) {
            nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
            if (parent == nodeChainKt$SentinelHead$1) {
                LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
                coordinator.setWrappedBy$ui_release(parent$ui_release != null ? parent$ui_release.getInnerCoordinator$ui_release() : null);
                this.outerCoordinator = coordinator;
                return;
            } else {
                if ((NodeKind.m5994constructorimpl(2) & parent.getKindSet()) != 0) {
                    return;
                }
                parent.updateCoordinator$ui_release(coordinator);
            }
        }
    }

    /* compiled from: NodeChain.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0018\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0018\u0010&\u001a\u00020#2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006'"}, d2 = {"Landroidx/compose/ui/node/NodeChain$Differ;", "Landroidx/compose/ui/node/DiffCallback;", "node", "Landroidx/compose/ui/Modifier$Node;", TypedValues.CycleType.S_WAVE_OFFSET, "", "before", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "after", "shouldAttachOnInsert", "", "(Landroidx/compose/ui/node/NodeChain;Landroidx/compose/ui/Modifier$Node;ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/runtime/collection/MutableVector;Z)V", "getAfter", "()Landroidx/compose/runtime/collection/MutableVector;", "setAfter", "(Landroidx/compose/runtime/collection/MutableVector;)V", "getBefore", "setBefore", "getNode", "()Landroidx/compose/ui/Modifier$Node;", "setNode", "(Landroidx/compose/ui/Modifier$Node;)V", "getOffset", "()I", "setOffset", "(I)V", "getShouldAttachOnInsert", "()Z", "setShouldAttachOnInsert", "(Z)V", "areItemsTheSame", "oldIndex", "newIndex", "insert", "", "remove", "atIndex", "same", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public final class Differ implements DiffCallback {
        private MutableVector<Modifier.Element> after;
        private MutableVector<Modifier.Element> before;
        private Modifier.Node node;
        private int offset;
        private boolean shouldAttachOnInsert;

        public Differ(Modifier.Node node, int i, MutableVector<Modifier.Element> mutableVector, MutableVector<Modifier.Element> mutableVector2, boolean z) {
            this.node = node;
            this.offset = i;
            this.before = mutableVector;
            this.after = mutableVector2;
            this.shouldAttachOnInsert = z;
        }

        public final Modifier.Node getNode() {
            return this.node;
        }

        public final void setNode(Modifier.Node node) {
            this.node = node;
        }

        public final int getOffset() {
            return this.offset;
        }

        public final void setOffset(int i) {
            this.offset = i;
        }

        public final MutableVector<Modifier.Element> getBefore() {
            return this.before;
        }

        public final void setBefore(MutableVector<Modifier.Element> mutableVector) {
            this.before = mutableVector;
        }

        public final MutableVector<Modifier.Element> getAfter() {
            return this.after;
        }

        public final void setAfter(MutableVector<Modifier.Element> mutableVector) {
            this.after = mutableVector;
        }

        public final boolean getShouldAttachOnInsert() {
            return this.shouldAttachOnInsert;
        }

        public final void setShouldAttachOnInsert(boolean z) {
            this.shouldAttachOnInsert = z;
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public boolean areItemsTheSame(int oldIndex, int newIndex) {
            return NodeChainKt.actionForModifiers(this.before.content[this.offset + oldIndex], this.after.content[this.offset + newIndex]) != 0;
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public void insert(int newIndex) {
            int i = this.offset + newIndex;
            Modifier.Node node = this.node;
            this.node = NodeChain.this.createAndInsertNodeAsChild(this.after.content[i], node);
            Logger logger = NodeChain.this.logger;
            if (logger != null) {
                logger.nodeInserted(i, i, this.after.content[i], node, this.node);
            }
            boolean z = this.shouldAttachOnInsert;
            Modifier.Node node2 = this.node;
            if (z) {
                Modifier.Node child = node2.getChild();
                Intrinsics.checkNotNull(child);
                NodeCoordinator coordinator = child.getCoordinator();
                Intrinsics.checkNotNull(coordinator);
                LayoutModifierNode asLayoutModifierNode = DelegatableNodeKt.asLayoutModifierNode(this.node);
                if (asLayoutModifierNode != null) {
                    LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = new LayoutModifierNodeCoordinator(NodeChain.this.getLayoutNode(), asLayoutModifierNode);
                    LayoutModifierNodeCoordinator layoutModifierNodeCoordinator2 = layoutModifierNodeCoordinator;
                    this.node.updateCoordinator$ui_release(layoutModifierNodeCoordinator2);
                    NodeChain.this.propagateCoordinator(this.node, layoutModifierNodeCoordinator2);
                    layoutModifierNodeCoordinator.setWrappedBy$ui_release(coordinator.getWrappedBy());
                    layoutModifierNodeCoordinator.setWrapped$ui_release(coordinator);
                    coordinator.setWrappedBy$ui_release(layoutModifierNodeCoordinator2);
                } else {
                    this.node.updateCoordinator$ui_release(coordinator);
                }
                this.node.markAsAttached$ui_release();
                this.node.runAttachLifecycle$ui_release();
                NodeKindKt.autoInvalidateInsertedNode(this.node);
                return;
            }
            node2.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public void remove(int atIndex, int oldIndex) {
            Modifier.Node child = this.node.getChild();
            Intrinsics.checkNotNull(child);
            Logger logger = NodeChain.this.logger;
            if (logger != null) {
                MutableVector<Modifier.Element> mutableVector = this.before;
                logger.nodeRemoved(oldIndex, mutableVector.content[this.offset + oldIndex], child);
            }
            if ((NodeKind.m5994constructorimpl(2) & child.getKindSet()) != 0) {
                NodeCoordinator coordinator = child.getCoordinator();
                Intrinsics.checkNotNull(coordinator);
                NodeCoordinator wrappedBy = coordinator.getWrappedBy();
                NodeCoordinator wrapped = coordinator.getWrapped();
                Intrinsics.checkNotNull(wrapped);
                if (wrappedBy != null) {
                    wrappedBy.setWrapped$ui_release(wrapped);
                }
                wrapped.setWrappedBy$ui_release(wrappedBy);
                NodeChain.this.propagateCoordinator(this.node, wrapped);
            }
            this.node = NodeChain.this.detachAndRemoveNode(child);
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public void same(int oldIndex, int newIndex) {
            Modifier.Node child = this.node.getChild();
            Intrinsics.checkNotNull(child);
            this.node = child;
            MutableVector<Modifier.Element> mutableVector = this.before;
            Modifier.Element element = mutableVector.content[this.offset + oldIndex];
            MutableVector<Modifier.Element> mutableVector2 = this.after;
            Modifier.Element element2 = mutableVector2.content[this.offset + newIndex];
            boolean areEqual = Intrinsics.areEqual(element, element2);
            NodeChain nodeChain = NodeChain.this;
            if (!areEqual) {
                nodeChain.updateNode(element, element2, this.node);
                Logger logger = NodeChain.this.logger;
                if (logger != null) {
                    int i = this.offset;
                    logger.nodeUpdated(i + oldIndex, i + newIndex, element, element2, this.node);
                    return;
                }
                return;
            }
            Logger logger2 = nodeChain.logger;
            if (logger2 != null) {
                int i2 = this.offset;
                logger2.nodeReused(i2 + oldIndex, i2 + newIndex, element, element2, this.node);
            }
        }
    }

    private final void structuralUpdate(int r2, MutableVector<Modifier.Element> before, MutableVector<Modifier.Element> after, Modifier.Node tail, boolean shouldAttachOnInsert) {
        MyersDiffKt.executeDiff(before.getSize() - r2, after.getSize() - r2, getDiffer(tail, r2, before, after, shouldAttachOnInsert));
        syncAggregateChildKindSet();
    }

    public final Modifier.Node detachAndRemoveNode(Modifier.Node node) {
        if (node.getIsAttached()) {
            NodeKindKt.autoInvalidateRemovedNode(node);
            node.runDetachLifecycle$ui_release();
            node.markAsDetached$ui_release();
        }
        return removeNode(node);
    }

    private final Modifier.Node removeNode(Modifier.Node node) {
        Modifier.Node child = node.getChild();
        Modifier.Node parent = node.getParent();
        if (child != null) {
            child.setParent$ui_release(parent);
            node.setChild$ui_release(null);
        }
        if (parent != null) {
            parent.setChild$ui_release(child);
            node.setParent$ui_release(null);
        }
        Intrinsics.checkNotNull(parent);
        return parent;
    }

    public final Modifier.Node createAndInsertNodeAsChild(Modifier.Element element, Modifier.Node parent) {
        BackwardsCompatNode backwardsCompatNode;
        if (element instanceof ModifierNodeElement) {
            backwardsCompatNode = ((ModifierNodeElement) element).getNode();
            backwardsCompatNode.setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFromIncludingDelegates(backwardsCompatNode));
        } else {
            backwardsCompatNode = new BackwardsCompatNode(element);
        }
        if (backwardsCompatNode.getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("A ModifierNodeElement cannot return an already attached node from create() ");
        }
        backwardsCompatNode.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
        return insertChild(backwardsCompatNode, parent);
    }

    private final Modifier.Node insertChild(Modifier.Node node, Modifier.Node parent) {
        Modifier.Node child = parent.getChild();
        if (child != null) {
            child.setParent$ui_release(node);
            node.setChild$ui_release(child);
        }
        parent.setChild$ui_release(node);
        node.setParent$ui_release(parent);
        return node;
    }

    public final void updateNode(Modifier.Element prev, Modifier.Element next, Modifier.Node node) {
        if ((prev instanceof ModifierNodeElement) && (next instanceof ModifierNodeElement)) {
            NodeChainKt.updateUnsafe((ModifierNodeElement) next, node);
            if (node.getIsAttached()) {
                NodeKindKt.autoInvalidateUpdatedNode(node);
                return;
            } else {
                node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
                return;
            }
        }
        if (node instanceof BackwardsCompatNode) {
            ((BackwardsCompatNode) node).setElement(next);
            if (node.getIsAttached()) {
                NodeKindKt.autoInvalidateUpdatedNode(node);
                return;
            } else {
                node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
                return;
            }
        }
        InlineClassHelperKt.throwIllegalStateException("Unknown Modifier.Node type");
    }

    public final void headToTail$ui_release(int mask, Function1<? super Modifier.Node, Unit> block) {
        if ((getAggregateChildKindSet() & mask) == 0) {
            return;
        }
        for (Modifier.Node head = getHead(); head != null; head = head.getChild()) {
            if ((head.getKindSet() & mask) != 0) {
                block.invoke(head);
            }
            if ((head.getAggregateChildKindSet() & mask) == 0) {
                return;
            }
        }
    }

    public final void headToTail$ui_release(Function1<? super Modifier.Node, Unit> block) {
        for (Modifier.Node head = getHead(); head != null; head = head.getChild()) {
            block.invoke(head);
        }
    }

    public final void headToTailExclusive$ui_release(Function1<? super Modifier.Node, Unit> block) {
        for (Modifier.Node head = getHead(); head != null && head != getTail(); head = head.getChild()) {
            block.invoke(head);
        }
    }

    public final void tailToHead$ui_release(int mask, Function1<? super Modifier.Node, Unit> block) {
        if ((getAggregateChildKindSet() & mask) == 0) {
            return;
        }
        for (Modifier.Node tail = getTail(); tail != null; tail = tail.getParent()) {
            if ((tail.getKindSet() & mask) != 0) {
                block.invoke(tail);
            }
        }
    }

    public final void tailToHead$ui_release(Function1<? super Modifier.Node, Unit> block) {
        for (Modifier.Node tail = getTail(); tail != null; tail = tail.getParent()) {
            block.invoke(tail);
        }
    }

    /* renamed from: has-H91voCI$ui_release */
    public final boolean m5955hasH91voCI$ui_release(int r1) {
        return (getAggregateChildKindSet() & r1) != 0;
    }

    public final boolean has$ui_release(int mask) {
        return (getAggregateChildKindSet() & mask) != 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (this.head == this.tail) {
            sb.append("]");
        } else {
            Modifier.Node head = getHead();
            while (true) {
                if (head == null || head == getTail()) {
                    break;
                }
                sb.append(String.valueOf(head));
                if (head.getChild() == this.tail) {
                    sb.append("]");
                    break;
                }
                sb.append(",");
                head = head.getChild();
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final void resetState$ui_release() {
        for (Modifier.Node tail = getTail(); tail != null; tail = tail.getParent()) {
            if (tail.getIsAttached()) {
                tail.reset$ui_release();
            }
        }
        runDetachLifecycle$ui_release();
        markAsDetached$ui_release();
    }

    public final void markAsAttached() {
        for (Modifier.Node head = getHead(); head != null; head = head.getChild()) {
            head.markAsAttached$ui_release();
        }
    }

    public final void markAsDetached$ui_release() {
        for (Modifier.Node tail = getTail(); tail != null; tail = tail.getParent()) {
            if (tail.getIsAttached()) {
                tail.markAsDetached$ui_release();
            }
        }
    }

    public final void runDetachLifecycle$ui_release() {
        for (Modifier.Node tail = getTail(); tail != null; tail = tail.getParent()) {
            if (tail.getIsAttached()) {
                tail.runDetachLifecycle$ui_release();
            }
        }
        InnerNodeCoordinator innerNodeCoordinator = this.innerCoordinator;
        NodeCoordinator nodeCoordinator = this.outerCoordinator;
        while (innerNodeCoordinator != nodeCoordinator) {
            innerNodeCoordinator.onDetach();
            innerNodeCoordinator = innerNodeCoordinator.getWrappedBy();
            Intrinsics.checkNotNull(innerNodeCoordinator);
        }
        nodeCoordinator.onDetach();
    }

    /* renamed from: firstFromHead-aLcG6gQ$ui_release */
    public final /* synthetic */ <T> T m5954firstFromHeadaLcG6gQ$ui_release(int r9, Function1<? super T, Boolean> block) {
        if ((getAggregateChildKindSet() & r9) != 0) {
            for (Modifier.Node head = getHead(); head != null; head = head.getChild()) {
                if ((head.getKindSet() & r9) != 0) {
                    Modifier.Node node = head;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        if (node instanceof Object) {
                            if (block.invoke(node).booleanValue()) {
                                return (T) node;
                            }
                        } else {
                            Object obj = node;
                            if ((((Modifier.Node) node).getKindSet() & r9) != 0 && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = node.getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & r9) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            Object obj2 = node;
                                            if (node != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(node);
                                                }
                                                node = (Object) null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head.getAggregateChildKindSet() & r9) == 0) {
                    break;
                }
            }
        }
        return null;
    }

    /* renamed from: headToTail-aLcG6gQ$ui_release */
    public final /* synthetic */ <T> void m5957headToTailaLcG6gQ$ui_release(int r9, Function1<? super T, Unit> block) {
        if ((getAggregateChildKindSet() & r9) != 0) {
            for (Modifier.Node head = getHead(); head != null; head = head.getChild()) {
                if ((head.getKindSet() & r9) != 0) {
                    Modifier.Node node = head;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        if (node instanceof Object) {
                            block.invoke(node);
                        } else if ((node.getKindSet() & r9) != 0 && (node instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                if ((delegate.getKindSet() & r9) != 0) {
                                    i++;
                                    if (i == 1) {
                                        node = delegate;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (node != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(node);
                                            }
                                            node = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate);
                                        }
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head.getAggregateChildKindSet() & r9) == 0) {
                    return;
                }
            }
        }
    }

    /* renamed from: tailToHead-aLcG6gQ$ui_release */
    public final /* synthetic */ <T> void m5959tailToHeadaLcG6gQ$ui_release(int r9, Function1<? super T, Unit> block) {
        if ((getAggregateChildKindSet() & r9) != 0) {
            for (Modifier.Node tail = getTail(); tail != null; tail = tail.getParent()) {
                if ((tail.getKindSet() & r9) != 0) {
                    Modifier.Node node = tail;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        if (node instanceof Object) {
                            block.invoke(node);
                        } else if ((node.getKindSet() & r9) != 0 && (node instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                if ((delegate.getKindSet() & r9) != 0) {
                                    i++;
                                    if (i == 1) {
                                        node = delegate;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (node != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(node);
                                            }
                                            node = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate);
                                        }
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
            }
        }
    }

    /* renamed from: tail-H91voCI$ui_release */
    public final /* synthetic */ <T> T m5958tailH91voCI$ui_release(int r9) {
        if ((getAggregateChildKindSet() & r9) != 0) {
            for (Modifier.Node tail = getTail(); tail != null; tail = tail.getParent()) {
                if ((tail.getKindSet() & r9) != 0) {
                    Object obj = (T) tail;
                    MutableVector mutableVector = null;
                    while (obj != null) {
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        if (obj instanceof Object) {
                            return (T) obj;
                        }
                        Object obj2 = obj;
                        if ((((Modifier.Node) obj).getKindSet() & r9) != 0 && (obj instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate = obj.getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                if ((delegate.getKindSet() & r9) != 0) {
                                    i++;
                                    if (i == 1) {
                                        obj = (T) delegate;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        Object obj3 = obj;
                                        if (obj != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(obj);
                                            }
                                            obj = (T) null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate);
                                        }
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        obj = (T) DelegatableNodeKt.pop(mutableVector);
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: head-H91voCI$ui_release */
    public final /* synthetic */ <T> T m5956headH91voCI$ui_release(int r9) {
        if ((getAggregateChildKindSet() & r9) != 0) {
            for (Modifier.Node head = getHead(); head != null; head = head.getChild()) {
                if ((head.getKindSet() & r9) != 0) {
                    Object obj = (T) head;
                    MutableVector mutableVector = null;
                    while (obj != null) {
                        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                        if (obj instanceof Object) {
                            return (T) obj;
                        }
                        Object obj2 = obj;
                        if ((((Modifier.Node) obj).getKindSet() & r9) != 0 && (obj instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate = obj.getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                if ((delegate.getKindSet() & r9) != 0) {
                                    i++;
                                    if (i == 1) {
                                        obj = (T) delegate;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        Object obj3 = obj;
                                        if (obj != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(obj);
                                            }
                                            obj = (T) null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate);
                                        }
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        obj = (T) DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head.getAggregateChildKindSet() & r9) == 0) {
                    break;
                }
            }
        }
        return null;
    }
}
