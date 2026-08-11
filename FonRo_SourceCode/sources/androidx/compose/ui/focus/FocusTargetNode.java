package androidx.compose.ui.focus;

import android.os.Trace;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import uz.FonRo.pos.data.model.WriteOffReason;

/* compiled from: FocusTargetNode.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001SBc\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012:\b\u0002\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\r\u0010.\u001a\u00020\u000fH\u0000¢\u0006\u0002\b/J\r\u00100\u001a\u00020\u000fH\u0000¢\u0006\u0002\b1J\u001d\u00100\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\nH\u0000¢\u0006\u0002\b1J/\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u0002062\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u000f0\u0011H\u0080\bø\u0001\u0000¢\u0006\u0004\b9\u0010:JN\u0010;\u001a\u00020\u000f2\u0006\u00105\u001a\u0002062\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u000f0\u00112\u001d\u0010<\u001a\u0019\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\u0002\b?H\u0082\bø\u0001\u0000¢\u0006\u0004\b@\u0010AJ/\u0010B\u001a\u00020\u000f2\u0006\u00105\u001a\u0002062\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u000f0\u0011H\u0080\bø\u0001\u0000¢\u0006\u0004\bC\u0010:J\r\u0010D\u001a\u00020=H\u0000¢\u0006\u0002\bEJ\u0019\u0010F\u001a\u00020\u000f2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0002\bHJ\r\u0010I\u001a\u00020\u000fH\u0000¢\u0006\u0002\bJJ\r\u0010K\u001a\u00020%H\u0000¢\u0006\u0002\bLJ\b\u0010M\u001a\u00020\u000fH\u0016J\b\u0010N\u001a\u00020\u000fH\u0016J\b\u0010O\u001a\u00020\u000fH\u0016J\b\u0010P\u001a\u00020%H\u0017J\u001a\u0010P\u001a\u00020%2\u0006\u00105\u001a\u000206H\u0016ø\u0001\u0000¢\u0006\u0004\bQ\u0010RR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\u0014\u0010+\u001a\u00020%X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006T"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "focusability", "Landroidx/compose/ui/focus/Focusability;", "onFocusChange", "Lkotlin/Function2;", "Landroidx/compose/ui/focus/FocusState;", "Lkotlin/ParameterName;", "name", "previous", "current", "", "onDispatchEventsCompleted", "Lkotlin/Function1;", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "beyondBoundsLayoutParent", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "getBeyondBoundsLayoutParent", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "committedFocusState", "Landroidx/compose/ui/focus/FocusStateImpl;", "value", "focusState", "getFocusState", "()Landroidx/compose/ui/focus/FocusStateImpl;", "setFocusState", "(Landroidx/compose/ui/focus/FocusStateImpl;)V", "getFocusability-LCbbffg", "()I", "setFocusability-josRg5g", "(I)V", "I", "isProcessingCustomEnter", "", "isProcessingCustomExit", "previouslyFocusedChildHash", "", "getPreviouslyFocusedChildHash", "setPreviouslyFocusedChildHash", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "commitFocusState", "commitFocusState$ui_release", "dispatchFocusCallbacks", "dispatchFocusCallbacks$ui_release", "previousState", "newState", "fetchCustomEnter", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Landroidx/compose/ui/focus/FocusRequester;", "fetchCustomEnter-aToIllA$ui_release", "(ILkotlin/jvm/functions/Function1;)V", "fetchCustomEnterOrExit", "enterOrExit", "Landroidx/compose/ui/focus/FocusProperties;", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "Lkotlin/ExtensionFunctionType;", "fetchCustomEnterOrExit-ULY8qGw", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "fetchCustomExit", "fetchCustomExit-aToIllA$ui_release", "fetchFocusProperties", "fetchFocusProperties$ui_release", "initializeFocusState", "initialFocusState", "initializeFocusState$ui_release", "invalidateFocus", "invalidateFocus$ui_release", "isInitialized", "isInitialized$ui_release", "onAttach", "onDetach", "onObservedReadsChanged", "requestFocus", "requestFocus-3ESFkO8", "(I)Z", "FocusTargetElement", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class FocusTargetNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, FocusTargetModifierNode, ObserverModifierNode, ModifierLocalModifierNode {
    public static final int $stable = 8;
    private FocusStateImpl committedFocusState;
    private int focusability;
    private boolean isProcessingCustomEnter;
    private boolean isProcessingCustomExit;
    private final Function1<FocusTargetNode, Unit> onDispatchEventsCompleted;
    private final Function2<FocusState, FocusState, Unit> onFocusChange;
    private int previouslyFocusedChildHash;
    private final boolean shouldAutoInvalidate;

    /* compiled from: FocusTargetNode.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public /* synthetic */ FocusTargetNode(int i, Function2 function2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, function2, function1);
    }

    public /* synthetic */ FocusTargetNode(int i, Function2 function2, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Focusability.INSTANCE.m4061getAlwaysLCbbffg() : i, (i2 & 2) != 0 ? null : function2, (i2 & 4) != 0 ? null : function1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private FocusTargetNode(int i, Function2<? super FocusState, ? super FocusState, Unit> function2, Function1<? super FocusTargetNode, Unit> function1) {
        this.onFocusChange = function2;
        this.onDispatchEventsCompleted = function1;
        this.focusability = i;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.focus.FocusTargetModifierNode
    public FocusStateImpl getFocusState() {
        FocusStateImpl uncommittedFocusState;
        FocusOwner focusOwner;
        FocusTargetNode activeFocusTargetNode;
        NodeChain nodes;
        if (ComposeUiFlags.isTrackFocusEnabled) {
            if (getIsAttached() && (activeFocusTargetNode = (focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner()).getActiveFocusTargetNode()) != null) {
                if (this == activeFocusTargetNode) {
                    return focusOwner.isFocusCaptured() ? FocusStateImpl.Captured : FocusStateImpl.Active;
                }
                if (activeFocusTargetNode.getIsAttached()) {
                    FocusTargetNode focusTargetNode = activeFocusTargetNode;
                    int m5994constructorimpl = NodeKind.m5994constructorimpl(1024);
                    if (!focusTargetNode.getNode().getIsAttached()) {
                        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                    }
                    Modifier.Node parent = focusTargetNode.getNode().getParent();
                    LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
                    while (requireLayoutNode != null) {
                        if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m5994constructorimpl) != 0) {
                            while (parent != null) {
                                if ((parent.getKindSet() & m5994constructorimpl) != 0) {
                                    Modifier.Node node = parent;
                                    MutableVector mutableVector = null;
                                    while (node != null) {
                                        if (node instanceof FocusTargetNode) {
                                            if (this == ((FocusTargetNode) node)) {
                                                return FocusStateImpl.ActiveParent;
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
                }
                return FocusStateImpl.Inactive;
            }
            return FocusStateImpl.Inactive;
        }
        FocusTransactionManager focusTransactionManager = FocusTargetNodeKt.getFocusTransactionManager(this);
        if (focusTransactionManager != null && (uncommittedFocusState = focusTransactionManager.getUncommittedFocusState(this)) != null) {
            return uncommittedFocusState;
        }
        FocusStateImpl focusStateImpl = this.committedFocusState;
        return focusStateImpl == null ? FocusStateImpl.Inactive : focusStateImpl;
    }

    public void setFocusState(FocusStateImpl focusStateImpl) {
        if (ComposeUiFlags.isTrackFocusEnabled) {
            return;
        }
        FocusTargetNodeKt.requireTransactionManager(this).setUncommittedFocusState(this, focusStateImpl);
    }

    @Override // androidx.compose.ui.focus.FocusTargetModifierNode
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the version accepting FocusDirection", replaceWith = @ReplaceWith(expression = "this.requestFocus()", imports = {}))
    public /* synthetic */ boolean requestFocus() {
        return mo4040requestFocus3ESFkO8(FocusDirection.INSTANCE.m4014getEnterdhqQ8s());
    }

    @Override // androidx.compose.ui.focus.FocusTargetModifierNode
    /* renamed from: requestFocus-3ESFkO8 */
    public boolean mo4040requestFocus3ESFkO8(int focusDirection) {
        Trace.beginSection("FocusTransactions:requestFocus");
        try {
            boolean z = false;
            if (!fetchFocusProperties$ui_release().getCanFocus()) {
                return false;
            }
            if (ComposeUiFlags.isTrackFocusEnabled) {
                int i = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m4050performCustomRequestFocusMxy_nc0(this, focusDirection).ordinal()];
                if (i == 1) {
                    z = FocusTransactionsKt.performRequestFocus(this);
                } else if (i == 2) {
                    z = true;
                } else if (i != 3 && i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                FocusTransactionManager requireTransactionManager = FocusTargetNodeKt.requireTransactionManager(this);
                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTargetNode$requestFocus$1$1
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
                        if (FocusTargetNode.this.getNode().getIsAttached()) {
                            FocusTargetNode.this.dispatchFocusCallbacks$ui_release();
                        }
                    }
                };
                try {
                    if (requireTransactionManager.getOngoingTransaction()) {
                        FocusTransactionManager.access$cancelTransaction(requireTransactionManager);
                    }
                    FocusTransactionManager.access$beginTransaction(requireTransactionManager);
                    FocusTransactionManager.access$getCancellationListener$p(requireTransactionManager).add(function0);
                    int i2 = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m4050performCustomRequestFocusMxy_nc0(this, focusDirection).ordinal()];
                    if (i2 == 1) {
                        z = FocusTransactionsKt.performRequestFocus(this);
                    } else if (i2 == 2) {
                        z = true;
                    } else if (i2 != 3 && i2 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                } finally {
                    FocusTransactionManager.access$commitTransaction(requireTransactionManager);
                }
            }
            return z;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.compose.ui.focus.FocusTargetModifierNode
    /* renamed from: getFocusability-LCbbffg, reason: from getter */
    public int getFocusability() {
        return this.focusability;
    }

    @Override // androidx.compose.ui.focus.FocusTargetModifierNode
    /* renamed from: setFocusability-josRg5g */
    public void mo4041setFocusabilityjosRg5g(int i) {
        if (Focusability.m4057equalsimpl0(this.focusability, i)) {
            return;
        }
        this.focusability = i;
        if (ComposeUiFlags.isTrackFocusEnabled) {
            if (getIsAttached() && this == DelegatableNodeKt.requireOwner(this).getFocusOwner().getActiveFocusTargetNode() && !Focusability.m4054canFocusimpl$ui_release(this.focusability, this)) {
                FocusTransactionsKt.clearFocus(this, true, true);
                return;
            }
            return;
        }
        if (getIsAttached() && isInitialized$ui_release()) {
            onObservedReadsChanged();
        }
    }

    public final int getPreviouslyFocusedChildHash() {
        return this.previouslyFocusedChildHash;
    }

    public final void setPreviouslyFocusedChildHash(int i) {
        this.previouslyFocusedChildHash = i;
    }

    public final BeyondBoundsLayout getBeyondBoundsLayoutParent() {
        return (BeyondBoundsLayout) getCurrent(androidx.compose.ui.layout.BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout());
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        if (ComposeUiFlags.isTrackFocusEnabled) {
            invalidateFocus$ui_release();
            return;
        }
        FocusStateImpl focusState = getFocusState();
        invalidateFocus$ui_release();
        if (focusState != getFocusState()) {
            dispatchFocusCallbacks$ui_release();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        if (ComposeUiFlags.isTrackFocusEnabled) {
            return;
        }
        FocusTargetNodeKt.invalidateFocusTarget(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        int i = WhenMappings.$EnumSwitchMapping$1[getFocusState().ordinal()];
        if (i == 1 || i == 2) {
            FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
            focusOwner.mo4024clearFocusI7lrPNg(true, true, false, FocusDirection.INSTANCE.m4015getExitdhqQ8s());
            if (ComposeUiFlags.isTrackFocusEnabled) {
                focusOwner.scheduleInvalidationForOwner();
            } else {
                FocusTargetNodeKt.invalidateFocusTarget(this);
            }
        } else if (i == 3 && !ComposeUiFlags.isTrackFocusEnabled) {
            FocusTransactionManager requireTransactionManager = FocusTargetNodeKt.requireTransactionManager(this);
            try {
                if (requireTransactionManager.getOngoingTransaction()) {
                    FocusTransactionManager.access$cancelTransaction(requireTransactionManager);
                }
                FocusTransactionManager.access$beginTransaction(requireTransactionManager);
                setFocusState(FocusStateImpl.Inactive);
                Unit unit = Unit.INSTANCE;
            } finally {
                FocusTransactionManager.access$commitTransaction(requireTransactionManager);
            }
        }
        this.committedFocusState = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [androidx.compose.ui.Modifier$Node] */
    public final FocusProperties fetchFocusProperties$ui_release() {
        NodeChain nodes;
        FocusPropertiesImpl focusPropertiesImpl = new FocusPropertiesImpl();
        focusPropertiesImpl.setCanFocus(Focusability.m4054canFocusimpl$ui_release(getFocusability(), this));
        FocusTargetNode focusTargetNode = this;
        int m5994constructorimpl = NodeKind.m5994constructorimpl(2048);
        int m5994constructorimpl2 = NodeKind.m5994constructorimpl(1024);
        Modifier.Node node = focusTargetNode.getNode();
        int i = m5994constructorimpl | m5994constructorimpl2;
        if (!focusTargetNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node2 = focusTargetNode.getNode();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
        loop0: while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i) != 0) {
                while (node2 != null) {
                    if ((node2.getKindSet() & i) != 0) {
                        if (node2 != node && (node2.getKindSet() & m5994constructorimpl2) != 0) {
                            break loop0;
                        }
                        if ((node2.getKindSet() & m5994constructorimpl) != 0) {
                            DelegatingNode delegatingNode = node2;
                            MutableVector mutableVector = null;
                            while (delegatingNode != 0) {
                                if (delegatingNode instanceof FocusPropertiesModifierNode) {
                                    ((FocusPropertiesModifierNode) delegatingNode).applyFocusProperties(focusPropertiesImpl);
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
                    }
                    node2 = node2.getParent();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            node2 = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return focusPropertiesImpl;
    }

    /* renamed from: fetchCustomEnterOrExit-ULY8qGw, reason: not valid java name */
    private final void m4044fetchCustomEnterOrExitULY8qGw(int focusDirection, Function1<? super FocusRequester, Unit> block, Function2<? super FocusProperties, ? super FocusEnterExitScope, Unit> enterOrExit) {
        FocusProperties fetchFocusProperties$ui_release = fetchFocusProperties$ui_release();
        CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(focusDirection, null);
        FocusTransactionManager focusTransactionManager = FocusTargetNodeKt.getFocusTransactionManager(this);
        int generation = focusTransactionManager != null ? focusTransactionManager.getGeneration() : 0;
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        FocusTargetNode activeFocusTargetNode = focusOwner.getActiveFocusTargetNode();
        enterOrExit.invoke(fetchFocusProperties$ui_release, cancelIndicatingFocusBoundaryScope);
        int generation2 = focusTransactionManager != null ? focusTransactionManager.getGeneration() : 0;
        FocusTargetNode activeFocusTargetNode2 = focusOwner.getActiveFocusTargetNode();
        if (cancelIndicatingFocusBoundaryScope.getIsCanceled()) {
            block.invoke(FocusRequester.INSTANCE.getCancel());
        } else {
            if (generation == generation2 && (!ComposeUiFlags.isTrackFocusEnabled || activeFocusTargetNode == activeFocusTargetNode2 || activeFocusTargetNode2 == null)) {
                return;
            }
            block.invoke(FocusRequester.INSTANCE.getRedirect$ui_release());
        }
    }

    /* renamed from: fetchCustomEnter-aToIllA$ui_release, reason: not valid java name */
    public final void m4045fetchCustomEnteraToIllA$ui_release(int focusDirection, Function1<? super FocusRequester, Unit> block) {
        if (this.isProcessingCustomEnter) {
            return;
        }
        this.isProcessingCustomEnter = true;
        try {
            FocusProperties fetchFocusProperties$ui_release = fetchFocusProperties$ui_release();
            CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(focusDirection, null);
            FocusTransactionManager focusTransactionManager = FocusTargetNodeKt.getFocusTransactionManager(this);
            int generation = focusTransactionManager != null ? focusTransactionManager.getGeneration() : 0;
            FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
            FocusTargetNode activeFocusTargetNode = focusOwner.getActiveFocusTargetNode();
            fetchFocusProperties$ui_release.getOnEnter().invoke(cancelIndicatingFocusBoundaryScope);
            int generation2 = focusTransactionManager != null ? focusTransactionManager.getGeneration() : 0;
            FocusTargetNode activeFocusTargetNode2 = focusOwner.getActiveFocusTargetNode();
            if (cancelIndicatingFocusBoundaryScope.getIsCanceled()) {
                block.invoke(FocusRequester.INSTANCE.getCancel());
            } else if (generation != generation2 || (ComposeUiFlags.isTrackFocusEnabled && activeFocusTargetNode != activeFocusTargetNode2 && activeFocusTargetNode2 != null)) {
                block.invoke(FocusRequester.INSTANCE.getRedirect$ui_release());
            }
        } finally {
            this.isProcessingCustomEnter = false;
        }
    }

    /* renamed from: fetchCustomExit-aToIllA$ui_release, reason: not valid java name */
    public final void m4046fetchCustomExitaToIllA$ui_release(int focusDirection, Function1<? super FocusRequester, Unit> block) {
        if (this.isProcessingCustomExit) {
            return;
        }
        this.isProcessingCustomExit = true;
        try {
            FocusProperties fetchFocusProperties$ui_release = fetchFocusProperties$ui_release();
            CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = new CancelIndicatingFocusBoundaryScope(focusDirection, null);
            FocusTransactionManager focusTransactionManager = FocusTargetNodeKt.getFocusTransactionManager(this);
            int generation = focusTransactionManager != null ? focusTransactionManager.getGeneration() : 0;
            FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
            FocusTargetNode activeFocusTargetNode = focusOwner.getActiveFocusTargetNode();
            fetchFocusProperties$ui_release.getOnExit().invoke(cancelIndicatingFocusBoundaryScope);
            int generation2 = focusTransactionManager != null ? focusTransactionManager.getGeneration() : 0;
            FocusTargetNode activeFocusTargetNode2 = focusOwner.getActiveFocusTargetNode();
            if (cancelIndicatingFocusBoundaryScope.getIsCanceled()) {
                block.invoke(FocusRequester.INSTANCE.getCancel());
            } else if (generation != generation2 || (ComposeUiFlags.isTrackFocusEnabled && activeFocusTargetNode != activeFocusTargetNode2 && activeFocusTargetNode2 != null)) {
                block.invoke(FocusRequester.INSTANCE.getRedirect$ui_release());
            }
        } finally {
            this.isProcessingCustomExit = false;
        }
    }

    public final void commitFocusState$ui_release() {
        FocusStateImpl uncommittedFocusState = FocusTargetNodeKt.requireTransactionManager(this).getUncommittedFocusState(this);
        if (uncommittedFocusState != null) {
            this.committedFocusState = uncommittedFocusState;
        } else {
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("committing a node that was not updated in the current transaction");
            throw new KotlinNothingValueException();
        }
    }

    public final void invalidateFocus$ui_release() {
        FocusProperties focusProperties = null;
        if (!isInitialized$ui_release()) {
            initializeFocusState$ui_release$default(this, null, 1, null);
        }
        int i = WhenMappings.$EnumSwitchMapping$1[getFocusState().ordinal()];
        if (i == 1 || i == 2) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ObserverModifierNodeKt.observeReads(this, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTargetNode$invalidateFocus$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.ui.focus.FocusProperties, T] */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    objectRef.element = this.fetchFocusProperties$ui_release();
                }
            });
            if (objectRef.element == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("focusProperties");
            } else {
                focusProperties = (FocusProperties) objectRef.element;
            }
            if (focusProperties.getCanFocus()) {
                return;
            }
            DelegatableNodeKt.requireOwner(this).getFocusOwner().clearFocus(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [androidx.compose.ui.Modifier$Node] */
    public final void dispatchFocusCallbacks$ui_release() {
        NodeChain nodes;
        Function2<FocusState, FocusState, Unit> function2;
        FocusStateImpl focusStateImpl = this.committedFocusState;
        if (focusStateImpl == null) {
            focusStateImpl = FocusStateImpl.Inactive;
        }
        FocusStateImpl focusState = getFocusState();
        if (focusStateImpl != focusState && (function2 = this.onFocusChange) != null) {
            function2.invoke(focusStateImpl, focusState);
        }
        FocusTargetNode focusTargetNode = this;
        int m5994constructorimpl = NodeKind.m5994constructorimpl(4096);
        int m5994constructorimpl2 = NodeKind.m5994constructorimpl(1024);
        Modifier.Node node = focusTargetNode.getNode();
        int i = m5994constructorimpl | m5994constructorimpl2;
        if (!focusTargetNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node2 = focusTargetNode.getNode();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
        loop0: while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i) != 0) {
                while (node2 != null) {
                    if ((node2.getKindSet() & i) != 0) {
                        if (node2 != node && (node2.getKindSet() & m5994constructorimpl2) != 0) {
                            break loop0;
                        }
                        if ((node2.getKindSet() & m5994constructorimpl) != 0) {
                            DelegatingNode delegatingNode = node2;
                            MutableVector mutableVector = null;
                            while (delegatingNode != 0) {
                                if (!(delegatingNode instanceof FocusEventModifierNode)) {
                                    if ((delegatingNode.getKindSet() & m5994constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
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
                                } else {
                                    FocusEventModifierNode focusEventModifierNode = (FocusEventModifierNode) delegatingNode;
                                    focusEventModifierNode.onFocusEvent(FocusEventModifierNodeKt.getFocusState(focusEventModifierNode));
                                }
                                delegatingNode = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                    }
                    node2 = node2.getParent();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            node2 = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        Function1<FocusTargetNode, Unit> function1 = this.onDispatchEventsCompleted;
        if (function1 != null) {
            function1.invoke(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9, types: [androidx.compose.ui.Modifier$Node] */
    public final void dispatchFocusCallbacks$ui_release(FocusState previousState, FocusState newState) {
        NodeChain nodes;
        Function2<FocusState, FocusState, Unit> function2;
        FocusTargetNode focusTargetNode = this;
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner();
        FocusTargetNode activeFocusTargetNode = focusOwner.getActiveFocusTargetNode();
        if (!Intrinsics.areEqual(previousState, newState) && (function2 = this.onFocusChange) != null) {
            function2.invoke(previousState, newState);
        }
        int m5994constructorimpl = NodeKind.m5994constructorimpl(4096);
        int m5994constructorimpl2 = NodeKind.m5994constructorimpl(1024);
        Modifier.Node node = focusTargetNode.getNode();
        int i = m5994constructorimpl | m5994constructorimpl2;
        if (!focusTargetNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node2 = focusTargetNode.getNode();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
        loop0: while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i) != 0) {
                while (node2 != null) {
                    if ((node2.getKindSet() & i) != 0) {
                        if (node2 != node && (node2.getKindSet() & m5994constructorimpl2) != 0) {
                            break loop0;
                        }
                        if ((node2.getKindSet() & m5994constructorimpl) != 0) {
                            DelegatingNode delegatingNode = node2;
                            MutableVector mutableVector = null;
                            while (delegatingNode != 0) {
                                if (!(delegatingNode instanceof FocusEventModifierNode)) {
                                    if ((delegatingNode.getKindSet() & m5994constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
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
                                } else {
                                    FocusEventModifierNode focusEventModifierNode = (FocusEventModifierNode) delegatingNode;
                                    if (activeFocusTargetNode == focusOwner.getActiveFocusTargetNode()) {
                                        focusEventModifierNode.onFocusEvent(newState);
                                    }
                                }
                                delegatingNode = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                    }
                    node2 = node2.getParent();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            node2 = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        Function1<FocusTargetNode, Unit> function1 = this.onDispatchEventsCompleted;
        if (function1 != null) {
            function1.invoke(this);
        }
    }

    /* compiled from: FocusTargetNode.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\f\u0010\u000e\u001a\u00020\f*\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetNode$FocusTargetElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/focus/FocusTargetNode;", "()V", "create", "equals", "", WriteOffReason.OTHER, "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class FocusTargetElement extends ModifierNodeElement<FocusTargetNode> {
        public static final int $stable = 0;
        public static final FocusTargetElement INSTANCE = new FocusTargetElement();

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public boolean equals(Object other) {
            return other == this;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public int hashCode() {
            return 1739042953;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void update(FocusTargetNode node) {
        }

        private FocusTargetElement() {
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        /* renamed from: create, reason: avoid collision after fix types in other method */
        public FocusTargetNode getNode() {
            return new FocusTargetNode(0, null, null, 7, null);
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo inspectorInfo) {
            inspectorInfo.setName("focusTarget");
        }
    }

    public final boolean isInitialized$ui_release() {
        return ComposeUiFlags.isTrackFocusEnabled || this.committedFocusState != null;
    }

    public static /* synthetic */ void initializeFocusState$ui_release$default(FocusTargetNode focusTargetNode, FocusStateImpl focusStateImpl, int i, Object obj) {
        if ((i & 1) != 0) {
            focusStateImpl = null;
        }
        focusTargetNode.initializeFocusState$ui_release(focusStateImpl);
    }

    private static final boolean initializeFocusState$isInActiveSubTree(FocusTargetNode focusTargetNode) {
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
                                if (focusTargetNode3.isInitialized$ui_release()) {
                                    int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode3.getFocusState().ordinal()];
                                    if (i != 1 && i != 2) {
                                        if (i == 3) {
                                            return true;
                                        }
                                        if (i != 4) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                    }
                                    return false;
                                }
                            } else if ((node.getKindSet() & m5994constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                                        i2++;
                                        if (i2 == 1) {
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
                                if (i2 == 1) {
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
        return false;
    }

    private static final boolean initializeFocusState$hasActiveChild(FocusTargetNode focusTargetNode) {
        FocusTargetNode focusTargetNode2 = focusTargetNode;
        int m5994constructorimpl = NodeKind.m5994constructorimpl(1024);
        if (!focusTargetNode2.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusTargetNode2.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusTargetNode2.getNode(), false);
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet() & m5994constructorimpl) != 0) {
                for (Modifier.Node node2 = node; node2 != null; node2 = node2.getChild()) {
                    if ((node2.getKindSet() & m5994constructorimpl) != 0) {
                        Modifier.Node node3 = node2;
                        MutableVector mutableVector2 = null;
                        while (node3 != null) {
                            if (node3 instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode3 = (FocusTargetNode) node3;
                                if (focusTargetNode3.isInitialized$ui_release()) {
                                    int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode3.getFocusState().ordinal()];
                                    if (i == 1 || i == 2 || i == 3) {
                                        return true;
                                    }
                                    if (i != 4) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                }
                            } else if ((node3.getKindSet() & m5994constructorimpl) != 0 && (node3 instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node3).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            node3 = delegate;
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
                                                mutableVector2.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            node3 = DelegatableNodeKt.pop(mutableVector2);
                        }
                    }
                }
            }
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node, false);
        }
        return false;
    }

    public final void initializeFocusState$ui_release(FocusStateImpl initialFocusState) {
        if (isInitialized$ui_release()) {
            throw new IllegalStateException("Re-initializing focus target node.".toString());
        }
        if (ComposeUiFlags.isTrackFocusEnabled) {
            return;
        }
        FocusTransactionManager requireTransactionManager = FocusTargetNodeKt.requireTransactionManager(this);
        try {
            if (requireTransactionManager.getOngoingTransaction()) {
                FocusTransactionManager.access$cancelTransaction(requireTransactionManager);
            }
            FocusTransactionManager.access$beginTransaction(requireTransactionManager);
            if (initialFocusState == null) {
                initialFocusState = (initializeFocusState$isInActiveSubTree(this) && initializeFocusState$hasActiveChild(this)) ? FocusStateImpl.ActiveParent : FocusStateImpl.Inactive;
            }
            setFocusState(initialFocusState);
            Unit unit = Unit.INSTANCE;
        } finally {
            FocusTransactionManager.access$commitTransaction(requireTransactionManager);
        }
    }
}
