package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusTraversal.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0007\u001a\u00020\b*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0001H\u0000\u001aF\u0010\u0013\u001a\u0004\u0018\u00010\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0016H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"activeChild", "Landroidx/compose/ui/focus/FocusTargetNode;", "getActiveChild", "(Landroidx/compose/ui/focus/FocusTargetNode;)Landroidx/compose/ui/focus/FocusTargetNode;", "isEligibleForFocusSearch", "", "(Landroidx/compose/ui/focus/FocusTargetNode;)Z", "customFocusSearch", "Landroidx/compose/ui/focus/FocusRequester;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "customFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/focus/FocusRequester;", "findActiveFocusNode", "findNonDeactivatedParent", "focusRect", "Landroidx/compose/ui/geometry/Rect;", "focusSearch", "previouslyFocusedRect", "onFound", "Lkotlin/Function1;", "focusSearch-0X8WOeE", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class FocusTraversalKt {

    /* compiled from: FocusTraversal.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* renamed from: customFocusSearch--OM-vw8, reason: not valid java name */
    public static final FocusRequester m4051customFocusSearchOMvw8(FocusTargetNode focusTargetNode, int i, LayoutDirection layoutDirection) {
        FocusRequester end;
        FocusRequester focusRequester;
        FocusRequester start;
        FocusProperties fetchFocusProperties$ui_release = focusTargetNode.fetchFocusProperties$ui_release();
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4017getNextdhqQ8s())) {
            return fetchFocusProperties$ui_release.getNext();
        }
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4018getPreviousdhqQ8s())) {
            return fetchFocusProperties$ui_release.getPrevious();
        }
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4020getUpdhqQ8s())) {
            return fetchFocusProperties$ui_release.getUp();
        }
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4013getDowndhqQ8s())) {
            return fetchFocusProperties$ui_release.getDown();
        }
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4016getLeftdhqQ8s())) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i2 == 1) {
                start = fetchFocusProperties$ui_release.getStart();
            } else {
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                start = fetchFocusProperties$ui_release.getEnd();
            }
            focusRequester = start != FocusRequester.INSTANCE.getDefault() ? start : null;
            return focusRequester == null ? fetchFocusProperties$ui_release.getLeft() : focusRequester;
        }
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4019getRightdhqQ8s())) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i3 == 1) {
                end = fetchFocusProperties$ui_release.getEnd();
            } else {
                if (i3 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                end = fetchFocusProperties$ui_release.getStart();
            }
            focusRequester = end != FocusRequester.INSTANCE.getDefault() ? end : null;
            return focusRequester == null ? fetchFocusProperties$ui_release.getRight() : focusRequester;
        }
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4014getEnterdhqQ8s()) ? true : FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4015getExitdhqQ8s())) {
            CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(i, null);
            FocusTransactionManager focusTransactionManager = FocusTargetNodeKt.getFocusTransactionManager(focusTargetNode);
            int generation = focusTransactionManager != null ? focusTransactionManager.getGeneration() : 0;
            FocusOwner focusOwner = DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner();
            FocusTargetNode activeFocusTargetNode = focusOwner.getActiveFocusTargetNode();
            if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4014getEnterdhqQ8s())) {
                fetchFocusProperties$ui_release.getOnEnter().invoke(cancelIndicatingFocusBoundaryScope);
            } else {
                fetchFocusProperties$ui_release.getOnExit().invoke(cancelIndicatingFocusBoundaryScope);
            }
            int generation2 = focusTransactionManager != null ? focusTransactionManager.getGeneration() : 0;
            if (cancelIndicatingFocusBoundaryScope.getIsCanceled()) {
                return FocusRequester.INSTANCE.getCancel();
            }
            if (generation != generation2 || (ComposeUiFlags.isTrackFocusEnabled && activeFocusTargetNode != focusOwner.getActiveFocusTargetNode())) {
                return FocusRequester.INSTANCE.getRedirect$ui_release();
            }
            return FocusRequester.INSTANCE.getDefault();
        }
        throw new IllegalStateException("invalid FocusDirection".toString());
    }

    /* renamed from: focusSearch-0X8WOeE, reason: not valid java name */
    public static final Boolean m4052focusSearch0X8WOeE(FocusTargetNode focusTargetNode, int i, LayoutDirection layoutDirection, Rect rect, Function1<? super FocusTargetNode, Boolean> function1) {
        int m4019getRightdhqQ8s;
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4017getNextdhqQ8s()) ? true : FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4018getPreviousdhqQ8s())) {
            return Boolean.valueOf(OneDimensionalFocusSearchKt.m4066oneDimensionalFocusSearchOMvw8(focusTargetNode, i, function1));
        }
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4016getLeftdhqQ8s()) ? true : FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4019getRightdhqQ8s()) ? true : FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4020getUpdhqQ8s()) ? true : FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4013getDowndhqQ8s())) {
            return TwoDimensionalFocusSearchKt.m4075twoDimensionalFocusSearchsMXa3k8(focusTargetNode, i, rect, function1);
        }
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4014getEnterdhqQ8s())) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i2 == 1) {
                m4019getRightdhqQ8s = FocusDirection.INSTANCE.m4019getRightdhqQ8s();
            } else if (i2 == 2) {
                m4019getRightdhqQ8s = FocusDirection.INSTANCE.m4016getLeftdhqQ8s();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            FocusTargetNode findActiveFocusNode = findActiveFocusNode(focusTargetNode);
            if (findActiveFocusNode != null) {
                return TwoDimensionalFocusSearchKt.m4075twoDimensionalFocusSearchsMXa3k8(findActiveFocusNode, m4019getRightdhqQ8s, rect, function1);
            }
            return null;
        }
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4015getExitdhqQ8s())) {
            FocusTargetNode findActiveFocusNode2 = findActiveFocusNode(focusTargetNode);
            FocusTargetNode findNonDeactivatedParent = findActiveFocusNode2 != null ? findNonDeactivatedParent(findActiveFocusNode2) : null;
            return Boolean.valueOf((findNonDeactivatedParent == null || Intrinsics.areEqual(findNonDeactivatedParent, focusTargetNode)) ? false : function1.invoke(findNonDeactivatedParent).booleanValue());
        }
        throw new IllegalStateException(("Focus search invoked with invalid FocusDirection " + ((Object) FocusDirection.m4011toStringimpl(i))).toString());
    }

    public static final Rect focusRect(FocusTargetNode focusTargetNode) {
        NodeCoordinator coordinator$ui_release = focusTargetNode.getCoordinator();
        if (coordinator$ui_release != null) {
            NodeCoordinator nodeCoordinator = coordinator$ui_release;
            Rect localBoundingBoxOf = LayoutCoordinatesKt.findRootCoordinates(nodeCoordinator).localBoundingBoxOf(nodeCoordinator, false);
            if (localBoundingBoxOf != null) {
                return localBoundingBoxOf;
            }
        }
        return Rect.INSTANCE.getZero();
    }

    public static final boolean isEligibleForFocusSearch(FocusTargetNode focusTargetNode) {
        LayoutNode layoutNode;
        NodeCoordinator coordinator$ui_release;
        LayoutNode layoutNode2;
        NodeCoordinator coordinator$ui_release2 = focusTargetNode.getCoordinator();
        return (coordinator$ui_release2 == null || (layoutNode = coordinator$ui_release2.getLayoutNode()) == null || !layoutNode.isPlaced() || (coordinator$ui_release = focusTargetNode.getCoordinator()) == null || (layoutNode2 = coordinator$ui_release.getLayoutNode()) == null || !layoutNode2.isAttached()) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0043, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.focus.FocusTargetNode getActiveChild(androidx.compose.ui.focus.FocusTargetNode r10) {
        /*
            androidx.compose.ui.Modifier$Node r0 = r10.getNode()
            boolean r0 = r0.getIsAttached()
            r1 = 0
            if (r0 != 0) goto Lc
            return r1
        Lc:
            androidx.compose.ui.node.DelegatableNode r10 = (androidx.compose.ui.node.DelegatableNode) r10
            r0 = 1024(0x400, float:1.435E-42)
            int r0 = androidx.compose.ui.node.NodeKind.m5994constructorimpl(r0)
            androidx.compose.ui.Modifier$Node r2 = r10.getNode()
            boolean r2 = r2.getIsAttached()
            if (r2 != 0) goto L24
            java.lang.String r2 = "visitChildren called on an unattached node"
            androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException(r2)
        L24:
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            r3 = 16
            androidx.compose.ui.Modifier$Node[] r4 = new androidx.compose.ui.Modifier.Node[r3]
            r5 = 0
            r2.<init>(r4, r5)
            androidx.compose.ui.Modifier$Node r4 = r10.getNode()
            androidx.compose.ui.Modifier$Node r4 = r4.getChild()
            if (r4 != 0) goto L40
            androidx.compose.ui.Modifier$Node r10 = r10.getNode()
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r2, r10, r5)
            goto L43
        L40:
            r2.add(r4)
        L43:
            int r10 = r2.getSize()
            if (r10 == 0) goto Ldc
            int r10 = r2.getSize()
            r4 = 1
            int r10 = r10 - r4
            java.lang.Object r10 = r2.removeAt(r10)
            androidx.compose.ui.Modifier$Node r10 = (androidx.compose.ui.Modifier.Node) r10
            int r6 = r10.getAggregateChildKindSet()
            r6 = r6 & r0
            if (r6 != 0) goto L60
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r2, r10, r5)
            goto L43
        L60:
            if (r10 == 0) goto L43
            int r6 = r10.getKindSet()
            r6 = r6 & r0
            if (r6 == 0) goto Ld7
            r6 = r1
        L6a:
            if (r10 == 0) goto L43
            boolean r7 = r10 instanceof androidx.compose.ui.focus.FocusTargetNode
            if (r7 == 0) goto L92
            androidx.compose.ui.focus.FocusTargetNode r10 = (androidx.compose.ui.focus.FocusTargetNode) r10
            androidx.compose.ui.Modifier$Node r7 = r10.getNode()
            boolean r7 = r7.getIsAttached()
            if (r7 == 0) goto Ld2
            androidx.compose.ui.focus.FocusStateImpl r7 = r10.getFocusState()
            int[] r8 = androidx.compose.ui.focus.FocusTraversalKt.WhenMappings.$EnumSwitchMapping$1
            int r7 = r7.ordinal()
            r7 = r8[r7]
            if (r7 == r4) goto L91
            r8 = 2
            if (r7 == r8) goto L91
            r8 = 3
            if (r7 == r8) goto L91
            goto Ld2
        L91:
            return r10
        L92:
            int r7 = r10.getKindSet()
            r7 = r7 & r0
            if (r7 == 0) goto Ld2
            boolean r7 = r10 instanceof androidx.compose.ui.node.DelegatingNode
            if (r7 == 0) goto Ld2
            r7 = r10
            androidx.compose.ui.node.DelegatingNode r7 = (androidx.compose.ui.node.DelegatingNode) r7
            androidx.compose.ui.Modifier$Node r7 = r7.getDelegate()
            r8 = r5
        La5:
            if (r7 == 0) goto Lcf
            int r9 = r7.getKindSet()
            r9 = r9 & r0
            if (r9 == 0) goto Lca
            int r8 = r8 + 1
            if (r8 != r4) goto Lb4
            r10 = r7
            goto Lca
        Lb4:
            if (r6 != 0) goto Lbd
            androidx.compose.runtime.collection.MutableVector r6 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r9 = new androidx.compose.ui.Modifier.Node[r3]
            r6.<init>(r9, r5)
        Lbd:
            if (r10 == 0) goto Lc5
            if (r6 == 0) goto Lc4
            r6.add(r10)
        Lc4:
            r10 = r1
        Lc5:
            if (r6 == 0) goto Lca
            r6.add(r7)
        Lca:
            androidx.compose.ui.Modifier$Node r7 = r7.getChild()
            goto La5
        Lcf:
            if (r8 != r4) goto Ld2
            goto L6a
        Ld2:
            androidx.compose.ui.Modifier$Node r10 = androidx.compose.ui.node.DelegatableNodeKt.access$pop(r6)
            goto L6a
        Ld7:
            androidx.compose.ui.Modifier$Node r10 = r10.getChild()
            goto L60
        Ldc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTraversalKt.getActiveChild(androidx.compose.ui.focus.FocusTargetNode):androidx.compose.ui.focus.FocusTargetNode");
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0073, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.focus.FocusTargetNode findActiveFocusNode(androidx.compose.ui.focus.FocusTargetNode r10) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTraversalKt.findActiveFocusNode(androidx.compose.ui.focus.FocusTargetNode):androidx.compose.ui.focus.FocusTargetNode");
    }

    private static final FocusTargetNode findNonDeactivatedParent(FocusTargetNode focusTargetNode) {
        NodeChain nodes;
        FocusTargetNode focusTargetNode2 = focusTargetNode;
        int m5994constructorimpl = NodeKind.m5994constructorimpl(1024);
        if (!focusTargetNode2.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = focusTargetNode2.getNode().getParent();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode2);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m5994constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & m5994constructorimpl) != 0) {
                        Modifier.Node node = parent;
                        MutableVector mutableVector = null;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode3 = (FocusTargetNode) node;
                                if (focusTargetNode3.fetchFocusProperties$ui_release().getCanFocus()) {
                                    return focusTargetNode3;
                                }
                            } else if ((node.getKindSet() & m5994constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
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
                    parent = parent.getParent();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }
}
