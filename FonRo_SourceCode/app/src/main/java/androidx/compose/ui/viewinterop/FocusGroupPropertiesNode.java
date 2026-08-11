package androidx.compose.ui.viewinterop;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusEnterExitScope;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusGroupNode.android.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\u001c\u0010!\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010\f2\b\u0010#\u001a\u0004\u0018\u00010\fH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\u0002\b\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\u0002\b\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017¨\u0006$"}, d2 = {"Landroidx/compose/ui/viewinterop/FocusGroupPropertiesNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "()V", "attachedViewTreeObserver", "Landroid/view/ViewTreeObserver;", "getAttachedViewTreeObserver", "()Landroid/view/ViewTreeObserver;", "setAttachedViewTreeObserver", "(Landroid/view/ViewTreeObserver;)V", "focusedChild", "Landroid/view/View;", "getFocusedChild", "()Landroid/view/View;", "setFocusedChild", "(Landroid/view/View;)V", "onEnter", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "", "Lkotlin/ExtensionFunctionType;", "getOnEnter", "()Lkotlin/jvm/functions/Function1;", "onExit", "getOnExit", "applyFocusProperties", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "getFocusTargetOfEmbeddedViewWrapper", "Landroidx/compose/ui/focus/FocusTargetNode;", "onAttach", "onDetach", "onGlobalFocusChanged", "oldFocus", "newFocus", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
final class FocusGroupPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode, ViewTreeObserver.OnGlobalFocusChangeListener {
    private ViewTreeObserver attachedViewTreeObserver;
    private View focusedChild;
    private final Function1<FocusEnterExitScope, Unit> onEnter = new Function1<FocusEnterExitScope, Unit>() { // from class: androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$onEnter$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FocusEnterExitScope focusEnterExitScope) {
            invoke2(focusEnterExitScope);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FocusEnterExitScope focusEnterExitScope) {
            View embeddedView;
            Rect currentlyFocusedRect;
            embeddedView = FocusGroupNode_androidKt.getEmbeddedView(FocusGroupPropertiesNode.this);
            if (embeddedView.isFocused() || embeddedView.hasFocus()) {
                return;
            }
            FocusOwner focusOwner = DelegatableNodeKt.requireOwner(FocusGroupPropertiesNode.this).getFocusOwner();
            View requireView = DelegatableNode_androidKt.requireView(FocusGroupPropertiesNode.this);
            Integer m4021toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m4021toAndroidFocusDirection3ESFkO8(focusEnterExitScope.getRequestedFocusDirection());
            currentlyFocusedRect = FocusGroupNode_androidKt.getCurrentlyFocusedRect(focusOwner, requireView, embeddedView);
            if (FocusInteropUtils_androidKt.requestInteropFocus(embeddedView, m4021toAndroidFocusDirection3ESFkO8, currentlyFocusedRect)) {
                return;
            }
            focusEnterExitScope.cancelFocusChange();
        }
    };
    private final Function1<FocusEnterExitScope, Unit> onExit = new Function1<FocusEnterExitScope, Unit>() { // from class: androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$onExit$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FocusEnterExitScope focusEnterExitScope) {
            invoke2(focusEnterExitScope);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FocusEnterExitScope focusEnterExitScope) {
            View embeddedView;
            Rect currentlyFocusedRect;
            View findNextFocusFromRect;
            boolean containsDescendant;
            embeddedView = FocusGroupNode_androidKt.getEmbeddedView(FocusGroupPropertiesNode.this);
            if (ComposeUiFlags.isViewFocusFixEnabled) {
                if (embeddedView.hasFocus() || embeddedView.isFocused()) {
                    embeddedView.clearFocus();
                    return;
                }
                return;
            }
            if (embeddedView.hasFocus()) {
                FocusOwner focusOwner = DelegatableNodeKt.requireOwner(FocusGroupPropertiesNode.this).getFocusOwner();
                View requireView = DelegatableNode_androidKt.requireView(FocusGroupPropertiesNode.this);
                if (embeddedView instanceof ViewGroup) {
                    currentlyFocusedRect = FocusGroupNode_androidKt.getCurrentlyFocusedRect(focusOwner, requireView, embeddedView);
                    Integer m4021toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m4021toAndroidFocusDirection3ESFkO8(focusEnterExitScope.getRequestedFocusDirection());
                    int intValue = m4021toAndroidFocusDirection3ESFkO8 != null ? m4021toAndroidFocusDirection3ESFkO8.intValue() : 130;
                    FocusFinder focusFinder = FocusFinder.getInstance();
                    FocusGroupPropertiesNode focusGroupPropertiesNode = FocusGroupPropertiesNode.this;
                    if (focusGroupPropertiesNode.getFocusedChild() != null) {
                        Intrinsics.checkNotNull(requireView, "null cannot be cast to non-null type android.view.ViewGroup");
                        findNextFocusFromRect = focusFinder.findNextFocus((ViewGroup) requireView, focusGroupPropertiesNode.getFocusedChild(), intValue);
                    } else {
                        Intrinsics.checkNotNull(requireView, "null cannot be cast to non-null type android.view.ViewGroup");
                        findNextFocusFromRect = focusFinder.findNextFocusFromRect((ViewGroup) requireView, currentlyFocusedRect, intValue);
                    }
                    if (findNextFocusFromRect != null) {
                        containsDescendant = FocusGroupNode_androidKt.containsDescendant(embeddedView, findNextFocusFromRect);
                        if (containsDescendant) {
                            findNextFocusFromRect.requestFocus(intValue, currentlyFocusedRect);
                            focusEnterExitScope.cancelFocusChange();
                            return;
                        }
                    }
                    if (!requireView.requestFocus()) {
                        throw new IllegalStateException("host view did not take focus".toString());
                    }
                    return;
                }
                if (!requireView.requestFocus()) {
                    throw new IllegalStateException("host view did not take focus".toString());
                }
            }
        }
    };

    public final View getFocusedChild() {
        return this.focusedChild;
    }

    public final void setFocusedChild(View view) {
        this.focusedChild = view;
    }

    public final ViewTreeObserver getAttachedViewTreeObserver() {
        return this.attachedViewTreeObserver;
    }

    public final void setAttachedViewTreeObserver(ViewTreeObserver viewTreeObserver) {
        this.attachedViewTreeObserver = viewTreeObserver;
    }

    public final Function1<FocusEnterExitScope, Unit> getOnEnter() {
        return this.onEnter;
    }

    public final Function1<FocusEnterExitScope, Unit> getOnExit() {
        return this.onExit;
    }

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setCanFocus(false);
        focusProperties.setOnEnter(this.onEnter);
        focusProperties.setOnExit(this.onExit);
    }

    private final FocusTargetNode getFocusTargetOfEmbeddedViewWrapper() {
        FocusGroupPropertiesNode focusGroupPropertiesNode = this;
        int m5994constructorimpl = NodeKind.m5994constructorimpl(1024);
        if (!focusGroupPropertiesNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = focusGroupPropertiesNode.getNode();
        if ((node.getAggregateChildKindSet() & m5994constructorimpl) != 0) {
            boolean z = false;
            for (Modifier.Node child = node.getChild(); child != null; child = child.getChild()) {
                if ((child.getKindSet() & m5994constructorimpl) != 0) {
                    Modifier.Node node2 = child;
                    MutableVector mutableVector = null;
                    while (node2 != null) {
                        if (node2 instanceof FocusTargetNode) {
                            FocusTargetNode focusTargetNode = (FocusTargetNode) node2;
                            if (z) {
                                return focusTargetNode;
                            }
                            z = true;
                        } else if ((node2.getKindSet() & m5994constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
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
            }
        }
        throw new IllegalStateException("Could not find focus target of embedded view wrapper".toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0083  */
    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onGlobalFocusChanged(android.view.View r7, android.view.View r8) {
        /*
            r6 = this;
            r0 = r6
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            androidx.compose.ui.node.LayoutNode r1 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r0)
            androidx.compose.ui.node.Owner r1 = r1.getOwner()
            if (r1 != 0) goto Lf
            goto L9f
        Lf:
            r1 = r6
            androidx.compose.ui.Modifier$Node r1 = (androidx.compose.ui.Modifier.Node) r1
            android.view.View r1 = androidx.compose.ui.viewinterop.FocusGroupNode_androidKt.access$getEmbeddedView(r1)
            androidx.compose.ui.node.Owner r2 = androidx.compose.ui.node.DelegatableNodeKt.requireOwner(r0)
            androidx.compose.ui.focus.FocusOwner r2 = r2.getFocusOwner()
            androidx.compose.ui.node.Owner r0 = androidx.compose.ui.node.DelegatableNodeKt.requireOwner(r0)
            r3 = 1
            r4 = 0
            if (r7 == 0) goto L34
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r0)
            if (r5 != 0) goto L34
            boolean r7 = androidx.compose.ui.viewinterop.FocusGroupNode_androidKt.access$containsDescendant(r1, r7)
            if (r7 == 0) goto L34
            r7 = r3
            goto L35
        L34:
            r7 = r4
        L35:
            if (r8 == 0) goto L45
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r0)
            if (r0 != 0) goto L45
            boolean r0 = androidx.compose.ui.viewinterop.FocusGroupNode_androidKt.access$containsDescendant(r1, r8)
            if (r0 == 0) goto L45
            r0 = r3
            goto L46
        L45:
            r0 = r4
        L46:
            if (r7 == 0) goto L4d
            if (r0 == 0) goto L4d
            r6.focusedChild = r8
            return
        L4d:
            if (r0 == 0) goto L83
            r6.focusedChild = r8
            androidx.compose.ui.focus.FocusTargetNode r6 = r6.getFocusTargetOfEmbeddedViewWrapper()
            androidx.compose.ui.focus.FocusStateImpl r7 = r6.getFocusState()
            boolean r7 = r7.getHasFocus()
            if (r7 != 0) goto L9f
            boolean r7 = androidx.compose.ui.ComposeUiFlags.isTrackFocusEnabled
            if (r7 == 0) goto L67
            androidx.compose.ui.focus.FocusTransactionsKt.performRequestFocus(r6)
            return
        L67:
            androidx.compose.ui.focus.FocusTransactionManager r7 = r2.getFocusTransactionManager()
            boolean r8 = r7.getOngoingTransaction()     // Catch: java.lang.Throwable -> L7e
            if (r8 == 0) goto L74
            androidx.compose.ui.focus.FocusTransactionManager.access$cancelTransaction(r7)     // Catch: java.lang.Throwable -> L7e
        L74:
            androidx.compose.ui.focus.FocusTransactionManager.access$beginTransaction(r7)     // Catch: java.lang.Throwable -> L7e
            androidx.compose.ui.focus.FocusTransactionsKt.performRequestFocus(r6)     // Catch: java.lang.Throwable -> L7e
            androidx.compose.ui.focus.FocusTransactionManager.access$commitTransaction(r7)
            return
        L7e:
            r6 = move-exception
            androidx.compose.ui.focus.FocusTransactionManager.access$commitTransaction(r7)
            throw r6
        L83:
            r8 = 0
            if (r7 == 0) goto La0
            r6.focusedChild = r8
            androidx.compose.ui.focus.FocusTargetNode r6 = r6.getFocusTargetOfEmbeddedViewWrapper()
            androidx.compose.ui.focus.FocusStateImpl r6 = r6.getFocusState()
            boolean r6 = r6.isFocused()
            if (r6 == 0) goto L9f
            androidx.compose.ui.focus.FocusDirection$Companion r6 = androidx.compose.ui.focus.FocusDirection.INSTANCE
            int r6 = r6.m4015getExitdhqQ8s()
            r2.mo4024clearFocusI7lrPNg(r4, r3, r4, r6)
        L9f:
            return
        La0:
            r6.focusedChild = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.FocusGroupPropertiesNode.onGlobalFocusChanged(android.view.View, android.view.View):void");
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        ViewTreeObserver viewTreeObserver = DelegatableNode_androidKt.requireView(this).getViewTreeObserver();
        this.attachedViewTreeObserver = viewTreeObserver;
        viewTreeObserver.addOnGlobalFocusChangeListener(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        ViewTreeObserver viewTreeObserver = this.attachedViewTreeObserver;
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalFocusChangeListener(this);
        }
        this.attachedViewTreeObserver = null;
        DelegatableNode_androidKt.requireView(this).getViewTreeObserver().removeOnGlobalFocusChangeListener(this);
        this.focusedChild = null;
        super.onDetach();
    }
}
