package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusTransactions.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a \u0010\u0003\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u001e\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001e\u0010\u000f\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u001e\u0010\u0011\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000e\u001a\u001e\u0010\u0013\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u000e\u001a\f\u0010\u0015\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0016\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0017\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u0014\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0002\u001a\f\u0010\u001a\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u001b\u001a\u00020\u0002*\u00020\u0002H\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"captureFocus", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "clearChildFocus", "forced", "refreshFocusEvents", "clearFocus", "freeFocus", "grantFocus", "performCustomClearFocus", "Landroidx/compose/ui/focus/CustomDestinationResult;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "performCustomClearFocus-Mxy_nc0", "(Landroidx/compose/ui/focus/FocusTargetNode;I)Landroidx/compose/ui/focus/CustomDestinationResult;", "performCustomEnter", "performCustomEnter-Mxy_nc0", "performCustomExit", "performCustomExit-Mxy_nc0", "performCustomRequestFocus", "performCustomRequestFocus-Mxy_nc0", "performRequestFocus", "performRequestFocusLegacy", "performRequestFocusOptimized", "requestFocusForChild", "childNode", "requestFocusForOwner", "requireActiveChild", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class FocusTransactionsKt {

    /* compiled from: FocusTransactions.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean performRequestFocus(FocusTargetNode focusTargetNode) {
        if (ComposeUiFlags.isTrackFocusEnabled) {
            return performRequestFocusOptimized(focusTargetNode);
        }
        return performRequestFocusLegacy(focusTargetNode);
    }

    private static final boolean performRequestFocusOptimized(FocusTargetNode focusTargetNode) {
        MutableVector mutableVector;
        int i;
        NodeChain nodes;
        NodeChain nodes2;
        FocusTargetNode focusTargetNode2;
        FocusTargetNode focusTargetNode3;
        MutableVector mutableVector2;
        FocusTargetNode focusTargetNode4 = focusTargetNode;
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(focusTargetNode4).getFocusOwner();
        FocusTargetNode activeFocusTargetNode = focusOwner.getActiveFocusTargetNode();
        FocusStateImpl focusState = focusTargetNode.getFocusState();
        int i2 = 1;
        if (activeFocusTargetNode == focusTargetNode) {
            FocusStateImpl focusStateImpl = focusState;
            focusTargetNode.dispatchFocusCallbacks$ui_release(focusStateImpl, focusStateImpl);
            return true;
        }
        int i3 = 0;
        if (activeFocusTargetNode == null && !requestFocusForOwner(focusTargetNode)) {
            return false;
        }
        int i4 = 1024;
        int i5 = 16;
        if (activeFocusTargetNode != null) {
            mutableVector = new MutableVector(new FocusTargetNode[16], 0);
            FocusTargetNode focusTargetNode5 = activeFocusTargetNode;
            int m5994constructorimpl = NodeKind.m5994constructorimpl(1024);
            if (!focusTargetNode5.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = focusTargetNode5.getNode().getParent();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode5);
            while (requireLayoutNode != null) {
                if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m5994constructorimpl) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & m5994constructorimpl) != 0) {
                            Modifier.Node node = parent;
                            MutableVector mutableVector3 = null;
                            while (node != null) {
                                int i6 = i4;
                                if (node instanceof FocusTargetNode) {
                                    mutableVector.add((FocusTargetNode) node);
                                } else if ((node.getKindSet() & m5994constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                    Modifier.Node delegate = ((DelegatingNode) node).getDelegate();
                                    int i7 = 0;
                                    while (delegate != null) {
                                        if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                                            i7++;
                                            if (i7 == i2) {
                                                focusTargetNode3 = focusTargetNode4;
                                                node = delegate;
                                            } else {
                                                if (mutableVector3 == null) {
                                                    focusTargetNode3 = focusTargetNode4;
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    focusTargetNode3 = focusTargetNode4;
                                                    mutableVector2 = mutableVector3;
                                                }
                                                if (node != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node);
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate);
                                                }
                                                mutableVector3 = mutableVector2;
                                            }
                                        } else {
                                            focusTargetNode3 = focusTargetNode4;
                                        }
                                        delegate = delegate.getChild();
                                        focusTargetNode4 = focusTargetNode3;
                                        i2 = 1;
                                    }
                                    focusTargetNode2 = focusTargetNode4;
                                    int i8 = i2;
                                    if (i7 == i8) {
                                        i2 = i8;
                                        i4 = i6;
                                        focusTargetNode4 = focusTargetNode2;
                                    } else {
                                        node = DelegatableNodeKt.pop(mutableVector3);
                                        i4 = i6;
                                        focusTargetNode4 = focusTargetNode2;
                                        i2 = 1;
                                    }
                                }
                                focusTargetNode2 = focusTargetNode4;
                                node = DelegatableNodeKt.pop(mutableVector3);
                                i4 = i6;
                                focusTargetNode4 = focusTargetNode2;
                                i2 = 1;
                            }
                        }
                        parent = parent.getParent();
                        i4 = i4;
                        focusTargetNode4 = focusTargetNode4;
                        i2 = 1;
                    }
                }
                FocusTargetNode focusTargetNode6 = focusTargetNode4;
                int i9 = i4;
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                parent = (requireLayoutNode == null || (nodes2 = requireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
                i4 = i9;
                focusTargetNode4 = focusTargetNode6;
                i2 = 1;
            }
        } else {
            mutableVector = null;
        }
        FocusTargetNode focusTargetNode7 = focusTargetNode4;
        MutableVector mutableVector4 = new MutableVector(new FocusTargetNode[16], 0);
        int m5994constructorimpl2 = NodeKind.m5994constructorimpl(i4);
        if (!focusTargetNode7.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent2 = focusTargetNode7.getNode().getParent();
        LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(focusTargetNode7);
        int i10 = 1;
        while (requireLayoutNode2 != null) {
            if ((requireLayoutNode2.getNodes().getHead().getAggregateChildKindSet() & m5994constructorimpl2) != 0) {
                while (parent2 != null) {
                    if ((parent2.getKindSet() & m5994constructorimpl2) != 0) {
                        Modifier.Node node2 = parent2;
                        MutableVector mutableVector5 = null;
                        while (node2 != null) {
                            if (node2 instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode8 = (FocusTargetNode) node2;
                                Boolean valueOf = mutableVector != null ? Boolean.valueOf(mutableVector.remove(focusTargetNode8)) : null;
                                if (valueOf == null || !valueOf.booleanValue()) {
                                    mutableVector4.add(focusTargetNode8);
                                }
                                if (focusTargetNode8 == activeFocusTargetNode) {
                                    i10 = i3;
                                }
                            } else if ((node2.getKindSet() & m5994constructorimpl2) != 0 && (node2 instanceof DelegatingNode)) {
                                Modifier.Node delegate2 = ((DelegatingNode) node2).getDelegate();
                                int i11 = i3;
                                while (delegate2 != null) {
                                    if ((delegate2.getKindSet() & m5994constructorimpl2) != 0) {
                                        i11++;
                                        if (i11 == 1) {
                                            node2 = delegate2;
                                        } else {
                                            if (mutableVector5 == null) {
                                                mutableVector5 = new MutableVector(new Modifier.Node[i5], 0);
                                            }
                                            if (node2 != null) {
                                                if (mutableVector5 != null) {
                                                    mutableVector5.add(node2);
                                                }
                                                node2 = null;
                                            }
                                            if (mutableVector5 != null) {
                                                mutableVector5.add(delegate2);
                                            }
                                        }
                                    }
                                    delegate2 = delegate2.getChild();
                                    i5 = 16;
                                }
                                if (i11 == 1) {
                                    i3 = 0;
                                    i5 = 16;
                                }
                            }
                            node2 = DelegatableNodeKt.pop(mutableVector5);
                            i3 = 0;
                            i5 = 16;
                        }
                    }
                    parent2 = parent2.getParent();
                    i3 = 0;
                    i5 = 16;
                }
            }
            requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
            parent2 = (requireLayoutNode2 == null || (nodes = requireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
            i3 = 0;
            i5 = 16;
        }
        if (i10 == 0 || activeFocusTargetNode == null) {
            i = 1;
        } else {
            i = 1;
            if (!clearFocus$default(activeFocusTargetNode, false, true, 1, null)) {
                return false;
            }
        }
        grantFocus(focusTargetNode);
        if (mutableVector != null) {
            int size = mutableVector.getSize() - i;
            Object[] objArr = mutableVector.content;
            if (size < objArr.length) {
                while (size >= 0) {
                    FocusTargetNode focusTargetNode9 = (FocusTargetNode) objArr[size];
                    if (focusOwner.getActiveFocusTargetNode() != focusTargetNode) {
                        return false;
                    }
                    focusTargetNode9.dispatchFocusCallbacks$ui_release(FocusStateImpl.ActiveParent, FocusStateImpl.Inactive);
                    size--;
                }
            }
        }
        int size2 = mutableVector4.getSize() - 1;
        Object[] objArr2 = mutableVector4.content;
        if (size2 < objArr2.length) {
            while (size2 >= 0) {
                FocusTargetNode focusTargetNode10 = (FocusTargetNode) objArr2[size2];
                if (focusOwner.getActiveFocusTargetNode() != focusTargetNode) {
                    return false;
                }
                focusTargetNode10.dispatchFocusCallbacks$ui_release(focusTargetNode10 == activeFocusTargetNode ? FocusStateImpl.Active : FocusStateImpl.Inactive, FocusStateImpl.ActiveParent);
                size2--;
            }
        }
        if (focusOwner.getActiveFocusTargetNode() != focusTargetNode) {
            return false;
        }
        focusTargetNode.dispatchFocusCallbacks$ui_release(focusState, FocusStateImpl.Active);
        if (focusOwner.getActiveFocusTargetNode() != focusTargetNode) {
            return false;
        }
        if (!ComposeUiFlags.isViewFocusFixEnabled || DelegatableNodeKt.requireLayoutNode(focusTargetNode7).getInteropView() != null) {
            return true;
        }
        DelegatableNodeKt.requireOwner(focusTargetNode7).getFocusOwner().mo4028requestFocusForOwner7o62pno(FocusDirection.m4006boximpl(FocusDirection.INSTANCE.m4017getNextdhqQ8s()), null);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e7, code lost:
    
        if (grantFocus(r11) != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00fa, code lost:
    
        if (grantFocus(r11) != false) goto L76;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final boolean performRequestFocusLegacy(androidx.compose.ui.focus.FocusTargetNode r11) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTransactionsKt.performRequestFocusLegacy(androidx.compose.ui.focus.FocusTargetNode):boolean");
    }

    public static final boolean captureFocus(FocusTargetNode focusTargetNode) {
        boolean z = false;
        if (ComposeUiFlags.isTrackFocusEnabled) {
            int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
            if (i == 1) {
                DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().setFocusCaptured(true);
                focusTargetNode.dispatchFocusCallbacks$ui_release(FocusStateImpl.Active, FocusStateImpl.Captured);
                return true;
            }
            if (i == 2) {
                return true;
            }
            if (i == 3 || i == 4) {
                return false;
            }
            throw new NoWhenBranchMatchedException();
        }
        FocusTransactionManager requireTransactionManager = FocusTargetNodeKt.requireTransactionManager(focusTargetNode);
        try {
            if (requireTransactionManager.getOngoingTransaction()) {
                requireTransactionManager.cancelTransaction();
            }
            requireTransactionManager.beginTransaction();
            int i2 = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
            if (i2 == 1) {
                focusTargetNode.setFocusState(FocusStateImpl.Captured);
                focusTargetNode.dispatchFocusCallbacks$ui_release();
            } else if (i2 != 2) {
                if (i2 != 3 && i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                return z;
            }
            z = true;
            return z;
        } finally {
            requireTransactionManager.commitTransaction();
        }
    }

    public static final boolean freeFocus(FocusTargetNode focusTargetNode) {
        boolean z = false;
        if (ComposeUiFlags.isTrackFocusEnabled) {
            int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3 || i == 4) {
                        return false;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().setFocusCaptured(false);
                focusTargetNode.dispatchFocusCallbacks$ui_release(FocusStateImpl.Captured, FocusStateImpl.Active);
            }
            return true;
        }
        FocusTransactionManager requireTransactionManager = FocusTargetNodeKt.requireTransactionManager(focusTargetNode);
        try {
            if (requireTransactionManager.getOngoingTransaction()) {
                requireTransactionManager.cancelTransaction();
            }
            requireTransactionManager.beginTransaction();
            int i2 = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3 && i2 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return z;
                }
                focusTargetNode.setFocusState(FocusStateImpl.Active);
                focusTargetNode.dispatchFocusCallbacks$ui_release();
            }
            z = true;
            return z;
        } finally {
            requireTransactionManager.commitTransaction();
        }
    }

    public static /* synthetic */ boolean clearFocus$default(FocusTargetNode focusTargetNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return clearFocus(focusTargetNode, z, z2);
    }

    public static final boolean clearFocus(FocusTargetNode focusTargetNode, boolean z, boolean z2) {
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i == 1) {
            if (ComposeUiFlags.isTrackFocusEnabled) {
                DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().setActiveFocusTargetNode(null);
                if (z2) {
                    focusTargetNode.dispatchFocusCallbacks$ui_release(FocusStateImpl.Active, FocusStateImpl.Inactive);
                }
            } else {
                focusTargetNode.setFocusState(FocusStateImpl.Inactive);
                if (z2) {
                    focusTargetNode.dispatchFocusCallbacks$ui_release();
                }
            }
            return true;
        }
        if (i == 2) {
            if (z) {
                if (ComposeUiFlags.isTrackFocusEnabled) {
                    DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().setActiveFocusTargetNode(null);
                    if (z2) {
                        focusTargetNode.dispatchFocusCallbacks$ui_release(FocusStateImpl.Captured, FocusStateImpl.Inactive);
                        return z;
                    }
                } else {
                    focusTargetNode.setFocusState(FocusStateImpl.Inactive);
                    if (z2) {
                        focusTargetNode.dispatchFocusCallbacks$ui_release();
                    }
                }
            }
            return z;
        }
        if (i != 3) {
            if (i == 4) {
                return true;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!clearChildFocus(focusTargetNode, z, z2)) {
            return false;
        }
        if (!ComposeUiFlags.isTrackFocusEnabled) {
            focusTargetNode.setFocusState(FocusStateImpl.Inactive);
            if (z2) {
                focusTargetNode.dispatchFocusCallbacks$ui_release();
            }
        } else if (z2) {
            focusTargetNode.dispatchFocusCallbacks$ui_release(FocusStateImpl.ActiveParent, FocusStateImpl.Inactive);
        }
        return true;
    }

    private static final boolean grantFocus(final FocusTargetNode focusTargetNode) {
        ObserverModifierNodeKt.observeReads(focusTargetNode, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTransactionsKt$grantFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FocusTargetNode.this.fetchFocusProperties$ui_release();
            }
        });
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i != 3 && i != 4) {
            return true;
        }
        if (ComposeUiFlags.isTrackFocusEnabled) {
            DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().setActiveFocusTargetNode(focusTargetNode);
            return true;
        }
        focusTargetNode.setFocusState(FocusStateImpl.Active);
        return true;
    }

    static /* synthetic */ boolean clearChildFocus$default(FocusTargetNode focusTargetNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return clearChildFocus(focusTargetNode, z, z2);
    }

    private static final boolean clearChildFocus(FocusTargetNode focusTargetNode, boolean z, boolean z2) {
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
        if (activeChild != null) {
            return clearFocus(activeChild, z, z2);
        }
        return true;
    }

    private static final boolean requestFocusForChild(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        Modifier.Node node;
        Modifier.Node node2;
        NodeChain nodes;
        NodeChain nodes2;
        FocusTargetNode focusTargetNode3 = focusTargetNode2;
        int m5994constructorimpl = NodeKind.m5994constructorimpl(1024);
        if (!focusTargetNode3.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = focusTargetNode3.getNode().getParent();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode3);
        loop0: while (true) {
            node = null;
            if (requireLayoutNode == null) {
                node2 = null;
                break;
            }
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m5994constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & m5994constructorimpl) != 0) {
                        node2 = parent;
                        MutableVector mutableVector = null;
                        while (node2 != null) {
                            if (node2 instanceof FocusTargetNode) {
                                break loop0;
                            }
                            if ((node2.getKindSet() & m5994constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node2).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node2 = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node2 != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(node2);
                                                }
                                                node2 = null;
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
                            node2 = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent = (requireLayoutNode == null || (nodes2 = requireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
        }
        if (!Intrinsics.areEqual(node2, focusTargetNode)) {
            throw new IllegalStateException("Non child node cannot request focus.".toString());
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i2 == 1) {
            boolean grantFocus = grantFocus(focusTargetNode2);
            if (grantFocus) {
                focusTargetNode.setFocusState(FocusStateImpl.ActiveParent);
            }
            return grantFocus;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4) {
                    FocusTargetNode focusTargetNode4 = focusTargetNode;
                    int m5994constructorimpl2 = NodeKind.m5994constructorimpl(1024);
                    if (!focusTargetNode4.getNode().getIsAttached()) {
                        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                    }
                    Modifier.Node parent2 = focusTargetNode4.getNode().getParent();
                    LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(focusTargetNode4);
                    loop4: while (true) {
                        if (requireLayoutNode2 == null) {
                            break;
                        }
                        if ((requireLayoutNode2.getNodes().getHead().getAggregateChildKindSet() & m5994constructorimpl2) != 0) {
                            while (parent2 != null) {
                                if ((parent2.getKindSet() & m5994constructorimpl2) != 0) {
                                    Modifier.Node node3 = parent2;
                                    MutableVector mutableVector2 = null;
                                    while (node3 != null) {
                                        if (node3 instanceof FocusTargetNode) {
                                            node = node3;
                                            break loop4;
                                        }
                                        if ((node3.getKindSet() & m5994constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                                            int i3 = 0;
                                            for (Modifier.Node delegate2 = ((DelegatingNode) node3).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                                                if ((delegate2.getKindSet() & m5994constructorimpl2) != 0) {
                                                    i3++;
                                                    if (i3 == 1) {
                                                        node3 = delegate2;
                                                    } else {
                                                        if (mutableVector2 == null) {
                                                            mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                        }
                                                        if (node3 != null) {
                                                            if (mutableVector2 != null) {
                                                                mutableVector2.add(node3);
                                                            }
                                                            node3 = null;
                                                        }
                                                        if (mutableVector2 != null) {
                                                            mutableVector2.add(delegate2);
                                                        }
                                                    }
                                                }
                                            }
                                            if (i3 == 1) {
                                            }
                                        }
                                        node3 = DelegatableNodeKt.pop(mutableVector2);
                                    }
                                }
                                parent2 = parent2.getParent();
                            }
                        }
                        requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                        parent2 = (requireLayoutNode2 == null || (nodes = requireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
                    }
                    FocusTargetNode focusTargetNode5 = (FocusTargetNode) node;
                    if (focusTargetNode5 == null && requestFocusForOwner(focusTargetNode)) {
                        boolean grantFocus2 = grantFocus(focusTargetNode2);
                        if (grantFocus2) {
                            focusTargetNode.setFocusState(FocusStateImpl.ActiveParent);
                        }
                        return grantFocus2;
                    }
                    if (focusTargetNode5 == null || !requestFocusForChild(focusTargetNode5, focusTargetNode)) {
                        return false;
                    }
                    boolean requestFocusForChild = requestFocusForChild(focusTargetNode, focusTargetNode2);
                    if (focusTargetNode.getFocusState() != FocusStateImpl.ActiveParent) {
                        throw new IllegalStateException("Deactivated node is focused".toString());
                    }
                    if (requestFocusForChild) {
                        focusTargetNode5.dispatchFocusCallbacks$ui_release();
                    }
                    return requestFocusForChild;
                }
                throw new NoWhenBranchMatchedException();
            }
            requireActiveChild(focusTargetNode);
            if (clearChildFocus$default(focusTargetNode, false, false, 3, null) && grantFocus(focusTargetNode2)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean requestFocusForOwner(FocusTargetNode focusTargetNode) {
        return DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().mo4028requestFocusForOwner7o62pno(null, null);
    }

    private static final FocusTargetNode requireActiveChild(FocusTargetNode focusTargetNode) {
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
        if (activeChild != null) {
            return activeChild;
        }
        throw new IllegalArgumentException("ActiveParent with no focused child".toString());
    }

    /* renamed from: performCustomRequestFocus-Mxy_nc0, reason: not valid java name */
    public static final CustomDestinationResult m4050performCustomRequestFocusMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        Modifier.Node node;
        NodeChain nodes;
        int i2 = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i2 == 1 || i2 == 2) {
            return CustomDestinationResult.None;
        }
        if (i2 == 3) {
            return m4047performCustomClearFocusMxy_nc0(requireActiveChild(focusTargetNode), i);
        }
        if (i2 == 4) {
            FocusTargetNode focusTargetNode2 = focusTargetNode;
            int m5994constructorimpl = NodeKind.m5994constructorimpl(1024);
            if (!focusTargetNode2.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = focusTargetNode2.getNode().getParent();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode2);
            loop0: while (true) {
                if (requireLayoutNode == null) {
                    node = null;
                    break;
                }
                if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m5994constructorimpl) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & m5994constructorimpl) != 0) {
                            node = parent;
                            MutableVector mutableVector = null;
                            while (node != null) {
                                if (node instanceof FocusTargetNode) {
                                    break loop0;
                                }
                                if ((node.getKindSet() & m5994constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                    int i3 = 0;
                                    for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                        if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                                            i3++;
                                            if (i3 == 1) {
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
                                    if (i3 == 1) {
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
            FocusTargetNode focusTargetNode3 = (FocusTargetNode) node;
            if (focusTargetNode3 == null) {
                return CustomDestinationResult.None;
            }
            int i4 = WhenMappings.$EnumSwitchMapping$0[focusTargetNode3.getFocusState().ordinal()];
            if (i4 == 1) {
                return m4048performCustomEnterMxy_nc0(focusTargetNode3, i);
            }
            if (i4 == 2) {
                return CustomDestinationResult.Cancelled;
            }
            if (i4 == 3) {
                return m4050performCustomRequestFocusMxy_nc0(focusTargetNode3, i);
            }
            if (i4 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            CustomDestinationResult m4050performCustomRequestFocusMxy_nc0 = m4050performCustomRequestFocusMxy_nc0(focusTargetNode3, i);
            CustomDestinationResult customDestinationResult = m4050performCustomRequestFocusMxy_nc0 != CustomDestinationResult.None ? m4050performCustomRequestFocusMxy_nc0 : null;
            return customDestinationResult == null ? m4048performCustomEnterMxy_nc0(focusTargetNode3, i) : customDestinationResult;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: performCustomClearFocus-Mxy_nc0, reason: not valid java name */
    public static final CustomDestinationResult m4047performCustomClearFocusMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return CustomDestinationResult.Cancelled;
            }
            if (i2 == 3) {
                CustomDestinationResult m4047performCustomClearFocusMxy_nc0 = m4047performCustomClearFocusMxy_nc0(requireActiveChild(focusTargetNode), i);
                if (m4047performCustomClearFocusMxy_nc0 == CustomDestinationResult.None) {
                    m4047performCustomClearFocusMxy_nc0 = null;
                }
                return m4047performCustomClearFocusMxy_nc0 == null ? m4049performCustomExitMxy_nc0(focusTargetNode, i) : m4047performCustomClearFocusMxy_nc0;
            }
            if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return CustomDestinationResult.None;
    }

    /* renamed from: performCustomEnter-Mxy_nc0, reason: not valid java name */
    private static final CustomDestinationResult m4048performCustomEnterMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        if (!focusTargetNode.isProcessingCustomEnter) {
            focusTargetNode.isProcessingCustomEnter = true;
            try {
                FocusProperties fetchFocusProperties$ui_release = focusTargetNode.fetchFocusProperties$ui_release();
                CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(i, null);
                FocusTransactionManager focusTransactionManager = FocusTargetNodeKt.getFocusTransactionManager(focusTargetNode);
                int generation = focusTransactionManager != null ? focusTransactionManager.getGeneration() : 0;
                FocusOwner focusOwner = DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner();
                FocusTargetNode activeFocusTargetNode = focusOwner.getActiveFocusTargetNode();
                fetchFocusProperties$ui_release.getOnEnter().invoke(cancelIndicatingFocusBoundaryScope);
                int generation2 = focusTransactionManager != null ? focusTransactionManager.getGeneration() : 0;
                FocusTargetNode activeFocusTargetNode2 = focusOwner.getActiveFocusTargetNode();
                if (cancelIndicatingFocusBoundaryScope.getIsCanceled()) {
                    FocusRequester cancel = FocusRequester.INSTANCE.getCancel();
                    if (cancel == FocusRequester.INSTANCE.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    if (cancel == FocusRequester.INSTANCE.getRedirect$ui_release()) {
                        return CustomDestinationResult.Redirected;
                    }
                    return FocusRequester.m4036requestFocus3ESFkO8$default(cancel, 0, 1, null) ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
                if (generation != generation2 || (ComposeUiFlags.isTrackFocusEnabled && activeFocusTargetNode != activeFocusTargetNode2 && activeFocusTargetNode2 != null)) {
                    FocusRequester redirect$ui_release = FocusRequester.INSTANCE.getRedirect$ui_release();
                    if (redirect$ui_release == FocusRequester.INSTANCE.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    if (redirect$ui_release == FocusRequester.INSTANCE.getRedirect$ui_release()) {
                        return CustomDestinationResult.Redirected;
                    }
                    return FocusRequester.m4036requestFocus3ESFkO8$default(redirect$ui_release, 0, 1, null) ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
            } finally {
                focusTargetNode.isProcessingCustomEnter = false;
            }
        }
        return CustomDestinationResult.None;
    }

    /* renamed from: performCustomExit-Mxy_nc0, reason: not valid java name */
    private static final CustomDestinationResult m4049performCustomExitMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        if (!focusTargetNode.isProcessingCustomExit) {
            focusTargetNode.isProcessingCustomExit = true;
            try {
                FocusProperties fetchFocusProperties$ui_release = focusTargetNode.fetchFocusProperties$ui_release();
                CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(i, null);
                FocusTransactionManager focusTransactionManager = FocusTargetNodeKt.getFocusTransactionManager(focusTargetNode);
                int generation = focusTransactionManager != null ? focusTransactionManager.getGeneration() : 0;
                FocusOwner focusOwner = DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner();
                FocusTargetNode activeFocusTargetNode = focusOwner.getActiveFocusTargetNode();
                fetchFocusProperties$ui_release.getOnExit().invoke(cancelIndicatingFocusBoundaryScope);
                int generation2 = focusTransactionManager != null ? focusTransactionManager.getGeneration() : 0;
                FocusTargetNode activeFocusTargetNode2 = focusOwner.getActiveFocusTargetNode();
                if (cancelIndicatingFocusBoundaryScope.getIsCanceled()) {
                    FocusRequester cancel = FocusRequester.INSTANCE.getCancel();
                    if (cancel == FocusRequester.INSTANCE.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    if (cancel == FocusRequester.INSTANCE.getRedirect$ui_release()) {
                        return CustomDestinationResult.Redirected;
                    }
                    return FocusRequester.m4036requestFocus3ESFkO8$default(cancel, 0, 1, null) ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
                if (generation != generation2 || (ComposeUiFlags.isTrackFocusEnabled && activeFocusTargetNode != activeFocusTargetNode2 && activeFocusTargetNode2 != null)) {
                    FocusRequester redirect$ui_release = FocusRequester.INSTANCE.getRedirect$ui_release();
                    if (redirect$ui_release == FocusRequester.INSTANCE.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    if (redirect$ui_release == FocusRequester.INSTANCE.getRedirect$ui_release()) {
                        return CustomDestinationResult.Redirected;
                    }
                    return FocusRequester.m4036requestFocus3ESFkO8$default(redirect$ui_release, 0, 1, null) ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
            } finally {
                focusTargetNode.isProcessingCustomExit = false;
            }
        }
        return CustomDestinationResult.None;
    }
}
