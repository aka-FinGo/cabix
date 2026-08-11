package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraversableNode.kt */
@Metadata(d1 = {"\u0000.\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u0001¢\u0006\u0002\u0010\u0003\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0002*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a-\u0010\u0007\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\f\u001a(\u0010\u0007\u001a\u00020\b*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n\u001a-\u0010\r\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\f\u001a(\u0010\r\u001a\u00020\b*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n\u001a-\u0010\u000e\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\u0002\u0010\f\u001a(\u0010\u000e\u001a\u00020\b*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\n¨\u0006\u0010"}, d2 = {"findNearestAncestor", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/node/TraversableNode;", "(Landroidx/compose/ui/node/TraversableNode;)Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/DelegatableNode;", "key", "", "traverseAncestors", "", "block", "Lkotlin/Function1;", "", "(Landroidx/compose/ui/node/TraversableNode;Lkotlin/jvm/functions/Function1;)V", "traverseChildren", "traverseDescendants", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class TraversableNodeKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static final <T extends TraversableNode> T findNearestAncestor(T t) {
        NodeChain nodes;
        T t2 = t;
        int m5994constructorimpl = NodeKind.m5994constructorimpl(262144);
        if (!t2.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = t2.getNode().getParent();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(t2);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m5994constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & m5994constructorimpl) != 0) {
                        DelegatingNode delegatingNode = parent;
                        MutableVector mutableVector = null;
                        while (delegatingNode != 0) {
                            if (delegatingNode instanceof TraversableNode) {
                                T t3 = (T) delegatingNode;
                                if (Intrinsics.areEqual(t.getTraverseKey(), t3.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(t, t3)) {
                                    return t3;
                                }
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
                    }
                    parent = parent.getParent();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [androidx.compose.ui.Modifier$Node] */
    public static final <T extends TraversableNode> void traverseAncestors(T t, Function1<? super T, Boolean> function1) {
        NodeChain nodes;
        T t2 = t;
        int m5994constructorimpl = NodeKind.m5994constructorimpl(262144);
        if (!t2.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = t2.getNode().getParent();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(t2);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m5994constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & m5994constructorimpl) != 0) {
                        DelegatingNode delegatingNode = parent;
                        MutableVector mutableVector = null;
                        while (delegatingNode != 0) {
                            boolean z = true;
                            if (delegatingNode instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) delegatingNode;
                                if (Intrinsics.areEqual(t.getTraverseKey(), traversableNode.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(t, traversableNode)) {
                                    z = function1.invoke(traversableNode).booleanValue();
                                }
                                if (!z) {
                                    return;
                                }
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
                    }
                    parent = parent.getParent();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0038, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v8, types: [androidx.compose.ui.Modifier$Node] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T extends androidx.compose.ui.node.TraversableNode> void traverseChildren(T r11, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r12) {
        /*
            r0 = r11
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            r1 = 262144(0x40000, float:3.67342E-40)
            int r1 = androidx.compose.ui.node.NodeKind.m5994constructorimpl(r1)
            androidx.compose.ui.Modifier$Node r2 = r0.getNode()
            boolean r2 = r2.getIsAttached()
            if (r2 != 0) goto L19
            java.lang.String r2 = "visitChildren called on an unattached node"
            androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException(r2)
        L19:
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            r3 = 16
            androidx.compose.ui.Modifier$Node[] r4 = new androidx.compose.ui.Modifier.Node[r3]
            r5 = 0
            r2.<init>(r4, r5)
            androidx.compose.ui.Modifier$Node r4 = r0.getNode()
            androidx.compose.ui.Modifier$Node r4 = r4.getChild()
            if (r4 != 0) goto L35
            androidx.compose.ui.Modifier$Node r0 = r0.getNode()
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r2, r0, r5)
            goto L38
        L35:
            r2.add(r4)
        L38:
            int r0 = r2.getSize()
            if (r0 == 0) goto Ld5
            int r0 = r2.getSize()
            r4 = 1
            int r0 = r0 - r4
            java.lang.Object r0 = r2.removeAt(r0)
            androidx.compose.ui.Modifier$Node r0 = (androidx.compose.ui.Modifier.Node) r0
            int r6 = r0.getAggregateChildKindSet()
            r6 = r6 & r1
            if (r6 != 0) goto L55
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r2, r0, r5)
            goto L38
        L55:
            if (r0 == 0) goto L38
            int r6 = r0.getKindSet()
            r6 = r6 & r1
            if (r6 == 0) goto Ld0
            r6 = 0
            r7 = r6
        L60:
            if (r0 == 0) goto L38
            boolean r8 = r0 instanceof androidx.compose.ui.node.TraversableNode
            if (r8 == 0) goto L8b
            androidx.compose.ui.node.TraversableNode r0 = (androidx.compose.ui.node.TraversableNode) r0
            java.lang.Object r8 = r11.getTraverseKey()
            java.lang.Object r9 = r0.getTraverseKey()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r9)
            if (r8 == 0) goto L87
            boolean r8 = androidx.compose.ui.Actual_jvmKt.areObjectsOfSameType(r11, r0)
            if (r8 == 0) goto L87
            java.lang.Object r0 = r12.invoke(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            goto L88
        L87:
            r0 = r4
        L88:
            if (r0 != 0) goto Lcb
            return
        L8b:
            int r8 = r0.getKindSet()
            r8 = r8 & r1
            if (r8 == 0) goto Lcb
            boolean r8 = r0 instanceof androidx.compose.ui.node.DelegatingNode
            if (r8 == 0) goto Lcb
            r8 = r0
            androidx.compose.ui.node.DelegatingNode r8 = (androidx.compose.ui.node.DelegatingNode) r8
            androidx.compose.ui.Modifier$Node r8 = r8.getDelegate()
            r9 = r5
        L9e:
            if (r8 == 0) goto Lc8
            int r10 = r8.getKindSet()
            r10 = r10 & r1
            if (r10 == 0) goto Lc3
            int r9 = r9 + 1
            if (r9 != r4) goto Lad
            r0 = r8
            goto Lc3
        Lad:
            if (r7 != 0) goto Lb6
            androidx.compose.runtime.collection.MutableVector r7 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r10 = new androidx.compose.ui.Modifier.Node[r3]
            r7.<init>(r10, r5)
        Lb6:
            if (r0 == 0) goto Lbe
            if (r7 == 0) goto Lbd
            r7.add(r0)
        Lbd:
            r0 = r6
        Lbe:
            if (r7 == 0) goto Lc3
            r7.add(r8)
        Lc3:
            androidx.compose.ui.Modifier$Node r8 = r8.getChild()
            goto L9e
        Lc8:
            if (r9 != r4) goto Lcb
            goto L60
        Lcb:
            androidx.compose.ui.Modifier$Node r0 = androidx.compose.ui.node.DelegatableNodeKt.access$pop(r7)
            goto L60
        Ld0:
            androidx.compose.ui.Modifier$Node r0 = r0.getChild()
            goto L55
        Ld5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.TraversableNodeKt.traverseChildren(androidx.compose.ui.node.TraversableNode, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.lang.Object] */
    public static final <T extends TraversableNode> void traverseDescendants(T t, Function1<? super T, ? extends TraversableNode.Companion.TraverseDescendantsAction> function1) {
        TraversableNode.Companion.TraverseDescendantsAction traverseDescendantsAction;
        T t2 = t;
        int m5994constructorimpl = NodeKind.m5994constructorimpl(262144);
        if (!t2.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = t2.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, t2.getNode(), false);
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet() & m5994constructorimpl) != 0) {
                for (Modifier.Node node2 = node; node2 != null; node2 = node2.getChild()) {
                    if ((node2.getKindSet() & m5994constructorimpl) != 0) {
                        DelegatingNode delegatingNode = node2;
                        MutableVector mutableVector2 = null;
                        while (delegatingNode != 0) {
                            if (delegatingNode instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) delegatingNode;
                                if (Intrinsics.areEqual(t.getTraverseKey(), traversableNode.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(t, traversableNode)) {
                                    traverseDescendantsAction = function1.invoke(traversableNode);
                                } else {
                                    traverseDescendantsAction = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                                }
                                if (traverseDescendantsAction == TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal) {
                                    return;
                                }
                                if (traverseDescendantsAction == TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                                    break;
                                }
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
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (delegatingNode != 0) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegatingNode);
                                                }
                                                delegatingNode = 0;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate);
                                            }
                                        }
                                    }
                                    delegate = delegate.getChild();
                                    delegatingNode = delegatingNode;
                                }
                                if (i == 1) {
                                }
                            }
                            delegatingNode = DelegatableNodeKt.pop(mutableVector2);
                        }
                    }
                }
            }
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static final TraversableNode findNearestAncestor(DelegatableNode delegatableNode, Object obj) {
        NodeChain nodes;
        int m5994constructorimpl = NodeKind.m5994constructorimpl(262144);
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = delegatableNode.getNode().getParent();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m5994constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & m5994constructorimpl) != 0) {
                        DelegatingNode delegatingNode = parent;
                        MutableVector mutableVector = null;
                        while (delegatingNode != 0) {
                            if (delegatingNode instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) delegatingNode;
                                if (Intrinsics.areEqual(obj, traversableNode.getTraverseKey())) {
                                    return traversableNode;
                                }
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
                    }
                    parent = parent.getParent();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.compose.ui.Modifier$Node] */
    public static final void traverseAncestors(DelegatableNode delegatableNode, Object obj, Function1<? super TraversableNode, Boolean> function1) {
        NodeChain nodes;
        int m5994constructorimpl = NodeKind.m5994constructorimpl(262144);
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = delegatableNode.getNode().getParent();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m5994constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & m5994constructorimpl) != 0) {
                        DelegatingNode delegatingNode = parent;
                        MutableVector mutableVector = null;
                        while (delegatingNode != 0) {
                            if (delegatingNode instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) delegatingNode;
                                if (!(Intrinsics.areEqual(obj, traversableNode.getTraverseKey()) ? function1.invoke(traversableNode).booleanValue() : true)) {
                                    return;
                                }
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
                    }
                    parent = parent.getParent();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0035, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r10v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r10v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r10v7, types: [androidx.compose.ui.Modifier$Node] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void traverseChildren(androidx.compose.ui.node.DelegatableNode r10, java.lang.Object r11, kotlin.jvm.functions.Function1<? super androidx.compose.ui.node.TraversableNode, java.lang.Boolean> r12) {
        /*
            r0 = 262144(0x40000, float:3.67342E-40)
            int r0 = androidx.compose.ui.node.NodeKind.m5994constructorimpl(r0)
            androidx.compose.ui.Modifier$Node r1 = r10.getNode()
            boolean r1 = r1.getIsAttached()
            if (r1 != 0) goto L16
            java.lang.String r1 = "visitChildren called on an unattached node"
            androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException(r1)
        L16:
            androidx.compose.runtime.collection.MutableVector r1 = new androidx.compose.runtime.collection.MutableVector
            r2 = 16
            androidx.compose.ui.Modifier$Node[] r3 = new androidx.compose.ui.Modifier.Node[r2]
            r4 = 0
            r1.<init>(r3, r4)
            androidx.compose.ui.Modifier$Node r3 = r10.getNode()
            androidx.compose.ui.Modifier$Node r3 = r3.getChild()
            if (r3 != 0) goto L32
            androidx.compose.ui.Modifier$Node r10 = r10.getNode()
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r1, r10, r4)
            goto L35
        L32:
            r1.add(r3)
        L35:
            int r10 = r1.getSize()
            if (r10 == 0) goto Lc8
            int r10 = r1.getSize()
            r3 = 1
            int r10 = r10 - r3
            java.lang.Object r10 = r1.removeAt(r10)
            androidx.compose.ui.Modifier$Node r10 = (androidx.compose.ui.Modifier.Node) r10
            int r5 = r10.getAggregateChildKindSet()
            r5 = r5 & r0
            if (r5 != 0) goto L52
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r1, r10, r4)
            goto L35
        L52:
            if (r10 == 0) goto L35
            int r5 = r10.getKindSet()
            r5 = r5 & r0
            if (r5 == 0) goto Lc3
            r5 = 0
            r6 = r5
        L5d:
            if (r10 == 0) goto L35
            boolean r7 = r10 instanceof androidx.compose.ui.node.TraversableNode
            if (r7 == 0) goto L7e
            androidx.compose.ui.node.TraversableNode r10 = (androidx.compose.ui.node.TraversableNode) r10
            java.lang.Object r7 = r10.getTraverseKey()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r7)
            if (r7 == 0) goto L7a
            java.lang.Object r10 = r12.invoke(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            goto L7b
        L7a:
            r10 = r3
        L7b:
            if (r10 != 0) goto Lbe
            return
        L7e:
            int r7 = r10.getKindSet()
            r7 = r7 & r0
            if (r7 == 0) goto Lbe
            boolean r7 = r10 instanceof androidx.compose.ui.node.DelegatingNode
            if (r7 == 0) goto Lbe
            r7 = r10
            androidx.compose.ui.node.DelegatingNode r7 = (androidx.compose.ui.node.DelegatingNode) r7
            androidx.compose.ui.Modifier$Node r7 = r7.getDelegate()
            r8 = r4
        L91:
            if (r7 == 0) goto Lbb
            int r9 = r7.getKindSet()
            r9 = r9 & r0
            if (r9 == 0) goto Lb6
            int r8 = r8 + 1
            if (r8 != r3) goto La0
            r10 = r7
            goto Lb6
        La0:
            if (r6 != 0) goto La9
            androidx.compose.runtime.collection.MutableVector r6 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r9 = new androidx.compose.ui.Modifier.Node[r2]
            r6.<init>(r9, r4)
        La9:
            if (r10 == 0) goto Lb1
            if (r6 == 0) goto Lb0
            r6.add(r10)
        Lb0:
            r10 = r5
        Lb1:
            if (r6 == 0) goto Lb6
            r6.add(r7)
        Lb6:
            androidx.compose.ui.Modifier$Node r7 = r7.getChild()
            goto L91
        Lbb:
            if (r8 != r3) goto Lbe
            goto L5d
        Lbe:
            androidx.compose.ui.Modifier$Node r10 = androidx.compose.ui.node.DelegatableNodeKt.access$pop(r6)
            goto L5d
        Lc3:
            androidx.compose.ui.Modifier$Node r10 = r10.getChild()
            goto L52
        Lc8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.TraversableNodeKt.traverseChildren(androidx.compose.ui.node.DelegatableNode, java.lang.Object, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object] */
    public static final void traverseDescendants(DelegatableNode delegatableNode, Object obj, Function1<? super TraversableNode, ? extends TraversableNode.Companion.TraverseDescendantsAction> function1) {
        TraversableNode.Companion.TraverseDescendantsAction traverseDescendantsAction;
        int m5994constructorimpl = NodeKind.m5994constructorimpl(262144);
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), false);
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet() & m5994constructorimpl) != 0) {
                for (Modifier.Node node2 = node; node2 != null; node2 = node2.getChild()) {
                    if ((node2.getKindSet() & m5994constructorimpl) != 0) {
                        DelegatingNode delegatingNode = node2;
                        MutableVector mutableVector2 = null;
                        while (delegatingNode != 0) {
                            if (delegatingNode instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) delegatingNode;
                                if (Intrinsics.areEqual(obj, traversableNode.getTraverseKey())) {
                                    traverseDescendantsAction = function1.invoke(traversableNode);
                                } else {
                                    traverseDescendantsAction = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                                }
                                if (traverseDescendantsAction == TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal) {
                                    return;
                                }
                                if (traverseDescendantsAction == TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                                    break;
                                }
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
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (delegatingNode != 0) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegatingNode);
                                                }
                                                delegatingNode = 0;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate);
                                            }
                                        }
                                    }
                                    delegate = delegate.getChild();
                                    delegatingNode = delegatingNode;
                                }
                                if (i == 1) {
                                }
                            }
                            delegatingNode = DelegatableNodeKt.pop(mutableVector2);
                        }
                    }
                }
            }
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node, false);
        }
    }
}
