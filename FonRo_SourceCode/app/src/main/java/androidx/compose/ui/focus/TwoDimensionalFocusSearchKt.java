package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TwoDimensionalFocusSearch.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a2\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\f\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0013H\u0002\u001a\f\u0010\u0014\u001a\u00020\u0006*\u00020\u0006H\u0002\u001a\u001a\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019H\u0002\u001a.\u0010\u001a\u001a\u0004\u0018\u00010\u0013*\b\u0012\u0004\u0012\u00020\u00130\u00192\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a2\u0010\u001e\u001a\u00020\u0004*\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040 H\u0000ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a:\u0010#\u001a\u00020\u0004*\u00020\u00132\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040 H\u0002ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a:\u0010'\u001a\u00020\u0004*\u00020\u00132\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040 H\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010&\u001a\f\u0010)\u001a\u00020\u0006*\u00020\u0006H\u0002\u001a>\u0010*\u001a\u0004\u0018\u00010\u0004*\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040 H\u0000ø\u0001\u0000¢\u0006\u0004\b,\u0010-\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"InvalidFocusDirection", "", "NoActiveChild", "beamBeats", "", FirebaseAnalytics.Param.SOURCE, "Landroidx/compose/ui/geometry/Rect;", "rect1", "rect2", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "beamBeats-I7lrPNg", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;I)Z", "isBetterCandidate", "proposedCandidate", "currentCandidate", "focusedRect", "isBetterCandidate-I7lrPNg", "activeNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "bottomRight", "collectAccessibleChildren", "", "Landroidx/compose/ui/node/DelegatableNode;", "accessibleChildren", "Landroidx/compose/runtime/collection/MutableVector;", "findBestCandidate", "focusRect", "findBestCandidate-4WY_MpI", "(Landroidx/compose/runtime/collection/MutableVector;Landroidx/compose/ui/geometry/Rect;I)Landroidx/compose/ui/focus/FocusTargetNode;", "findChildCorrespondingToFocusEnter", "onFound", "Lkotlin/Function1;", "findChildCorrespondingToFocusEnter--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Z", "generateAndSearchChildren", "focusedItem", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusTargetNode;Landroidx/compose/ui/geometry/Rect;ILkotlin/jvm/functions/Function1;)Z", "searchChildren", "searchChildren-4C6V_qg", "topLeft", "twoDimensionalFocusSearch", "previouslyFocusedRect", "twoDimensionalFocusSearch-sMXa3k8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class TwoDimensionalFocusSearchKt {
    private static final String InvalidFocusDirection = "This function should only be used for 2-D focus search";
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    /* compiled from: TwoDimensionalFocusSearch.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: twoDimensionalFocusSearch-sMXa3k8, reason: not valid java name */
    public static final Boolean m4075twoDimensionalFocusSearchsMXa3k8(FocusTargetNode focusTargetNode, int i, Rect rect, Function1<? super FocusTargetNode, Boolean> function1) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i2 != 1) {
            if (i2 == 2 || i2 == 3) {
                return Boolean.valueOf(m4071findChildCorrespondingToFocusEnterOMvw8(focusTargetNode, i, function1));
            }
            if (i2 == 4) {
                if (focusTargetNode.fetchFocusProperties$ui_release().getCanFocus()) {
                    return function1.invoke(focusTargetNode);
                }
                if (rect == null) {
                    return Boolean.valueOf(m4071findChildCorrespondingToFocusEnterOMvw8(focusTargetNode, i, function1));
                }
                return Boolean.valueOf(m4074searchChildren4C6V_qg(focusTargetNode, rect, i, function1));
            }
            throw new NoWhenBranchMatchedException();
        }
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
        if (activeChild == null) {
            throw new IllegalStateException(NoActiveChild.toString());
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[activeChild.getFocusState().ordinal()];
        if (i3 == 1) {
            Boolean m4075twoDimensionalFocusSearchsMXa3k8 = m4075twoDimensionalFocusSearchsMXa3k8(activeChild, i, rect, function1);
            if (!Intrinsics.areEqual((Object) m4075twoDimensionalFocusSearchsMXa3k8, (Object) false)) {
                return m4075twoDimensionalFocusSearchsMXa3k8;
            }
            if (rect == null) {
                rect = FocusTraversalKt.focusRect(activeNode(activeChild));
            }
            return Boolean.valueOf(m4072generateAndSearchChildren4C6V_qg(focusTargetNode, rect, i, function1));
        }
        if (i3 == 2 || i3 == 3) {
            if (rect == null) {
                rect = FocusTraversalKt.focusRect(activeChild);
            }
            return Boolean.valueOf(m4072generateAndSearchChildren4C6V_qg(focusTargetNode, rect, i, function1));
        }
        if (i3 == 4) {
            throw new IllegalStateException(NoActiveChild.toString());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg, reason: not valid java name */
    private static final boolean m4072generateAndSearchChildren4C6V_qg(final FocusTargetNode focusTargetNode, final Rect rect, final int i, final Function1<? super FocusTargetNode, Boolean> function1) {
        if (m4074searchChildren4C6V_qg(focusTargetNode, rect, i, function1)) {
            return true;
        }
        final FocusTransactionManager requireTransactionManager = FocusTargetNodeKt.requireTransactionManager(focusTargetNode);
        final int generation = requireTransactionManager.getGeneration();
        final FocusTargetNode activeFocusTargetNode = DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().getActiveFocusTargetNode();
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m4004searchBeyondBoundsOMvw8(focusTargetNode, i, new Function1<BeyondBoundsLayout.BeyondBoundsScope, Boolean>() { // from class: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BeyondBoundsLayout.BeyondBoundsScope beyondBoundsScope) {
                boolean m4074searchChildren4C6V_qg;
                if (generation == requireTransactionManager.getGeneration() && (!ComposeUiFlags.isTrackFocusEnabled || activeFocusTargetNode == DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().getActiveFocusTargetNode())) {
                    m4074searchChildren4C6V_qg = TwoDimensionalFocusSearchKt.m4074searchChildren4C6V_qg(focusTargetNode, rect, i, function1);
                    Boolean valueOf = Boolean.valueOf(m4074searchChildren4C6V_qg);
                    valueOf.getClass();
                    if (m4074searchChildren4C6V_qg || !beyondBoundsScope.getHasMoreContent()) {
                        return valueOf;
                    }
                    return null;
                }
                return true;
            }
        });
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* renamed from: findBestCandidate-4WY_MpI, reason: not valid java name */
    private static final FocusTargetNode m4070findBestCandidate4WY_MpI(MutableVector<FocusTargetNode> mutableVector, Rect rect, int i) {
        Rect translate;
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4016getLeftdhqQ8s())) {
            translate = rect.translate((rect.getRight() - rect.getLeft()) + 1.0f, 0.0f);
        } else if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4019getRightdhqQ8s())) {
            translate = rect.translate(-((rect.getRight() - rect.getLeft()) + 1.0f), 0.0f);
        } else if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4020getUpdhqQ8s())) {
            translate = rect.translate(0.0f, (rect.getBottom() - rect.getTop()) + 1.0f);
        } else if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4013getDowndhqQ8s())) {
            translate = rect.translate(0.0f, -((rect.getBottom() - rect.getTop()) + 1.0f));
        } else {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        }
        FocusTargetNode[] focusTargetNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        FocusTargetNode focusTargetNode = null;
        for (int i2 = 0; i2 < size; i2++) {
            FocusTargetNode focusTargetNode2 = focusTargetNodeArr[i2];
            if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2)) {
                Rect focusRect = FocusTraversalKt.focusRect(focusTargetNode2);
                if (m4073isBetterCandidateI7lrPNg(focusRect, translate, rect, i)) {
                    focusTargetNode = focusTargetNode2;
                    translate = focusRect;
                }
            }
        }
        return focusTargetNode;
    }

    private static final boolean isBetterCandidate_I7lrPNg$isCandidate(Rect rect, int i, Rect rect2) {
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4016getLeftdhqQ8s())) {
            return (rect2.getRight() > rect.getRight() || rect2.getLeft() >= rect.getRight()) && rect2.getLeft() > rect.getLeft();
        }
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4019getRightdhqQ8s())) {
            return (rect2.getLeft() < rect.getLeft() || rect2.getRight() <= rect.getLeft()) && rect2.getRight() < rect.getRight();
        }
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4020getUpdhqQ8s())) {
            return (rect2.getBottom() > rect.getBottom() || rect2.getTop() >= rect.getBottom()) && rect2.getTop() > rect.getTop();
        }
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4013getDowndhqQ8s())) {
            return (rect2.getTop() < rect.getTop() || rect2.getBottom() <= rect.getTop()) && rect2.getBottom() < rect.getBottom();
        }
        throw new IllegalStateException(InvalidFocusDirection.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final float isBetterCandidate_I7lrPNg$majorAxisDistance(androidx.compose.ui.geometry.Rect r1, int r2, androidx.compose.ui.geometry.Rect r3) {
        /*
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.INSTANCE
            int r0 = r0.m4016getLeftdhqQ8s()
            boolean r0 = androidx.compose.ui.focus.FocusDirection.m4009equalsimpl0(r2, r0)
            if (r0 == 0) goto L16
            float r2 = r3.getLeft()
            float r1 = r1.getRight()
        L14:
            float r2 = r2 - r1
            goto L57
        L16:
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.INSTANCE
            int r0 = r0.m4019getRightdhqQ8s()
            boolean r0 = androidx.compose.ui.focus.FocusDirection.m4009equalsimpl0(r2, r0)
            if (r0 == 0) goto L2d
            float r1 = r1.getLeft()
            float r2 = r3.getRight()
        L2a:
            float r2 = r1 - r2
            goto L57
        L2d:
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.INSTANCE
            int r0 = r0.m4020getUpdhqQ8s()
            boolean r0 = androidx.compose.ui.focus.FocusDirection.m4009equalsimpl0(r2, r0)
            if (r0 == 0) goto L42
            float r2 = r3.getTop()
            float r1 = r1.getBottom()
            goto L14
        L42:
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.INSTANCE
            int r0 = r0.m4013getDowndhqQ8s()
            boolean r2 = androidx.compose.ui.focus.FocusDirection.m4009equalsimpl0(r2, r0)
            if (r2 == 0) goto L5e
            float r1 = r1.getTop()
            float r2 = r3.getBottom()
            goto L2a
        L57:
            r1 = 0
            int r3 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r3 >= 0) goto L5d
            return r1
        L5d:
            return r2
        L5e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "This function should only be used for 2-D focus search"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt.isBetterCandidate_I7lrPNg$majorAxisDistance(androidx.compose.ui.geometry.Rect, int, androidx.compose.ui.geometry.Rect):float");
    }

    private static final float isBetterCandidate_I7lrPNg$minorAxisDistance(Rect rect, int i, Rect rect2) {
        float left;
        float left2;
        float right;
        float left3;
        if (!(FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4016getLeftdhqQ8s()) ? true : FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4019getRightdhqQ8s()))) {
            if (!(FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4020getUpdhqQ8s()) ? true : FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4013getDowndhqQ8s()))) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            left = rect2.getLeft() + ((rect2.getRight() - rect2.getLeft()) / 2.0f);
            left2 = rect.getLeft();
            right = rect.getRight();
            left3 = rect.getLeft();
        } else {
            left = rect2.getTop() + ((rect2.getBottom() - rect2.getTop()) / 2.0f);
            left2 = rect.getTop();
            right = rect.getBottom();
            left3 = rect.getTop();
        }
        return left - (left2 + ((right - left3) / 2.0f));
    }

    private static final long isBetterCandidate_I7lrPNg$weightedDistance(int i, Rect rect, Rect rect2) {
        long isBetterCandidate_I7lrPNg$majorAxisDistance = isBetterCandidate_I7lrPNg$majorAxisDistance(rect2, i, rect);
        long isBetterCandidate_I7lrPNg$minorAxisDistance = isBetterCandidate_I7lrPNg$minorAxisDistance(rect2, i, rect);
        return (13 * isBetterCandidate_I7lrPNg$majorAxisDistance * isBetterCandidate_I7lrPNg$majorAxisDistance) + (isBetterCandidate_I7lrPNg$minorAxisDistance * isBetterCandidate_I7lrPNg$minorAxisDistance);
    }

    /* renamed from: isBetterCandidate-I7lrPNg, reason: not valid java name */
    public static final boolean m4073isBetterCandidateI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i) {
        if (!isBetterCandidate_I7lrPNg$isCandidate(rect, i, rect3)) {
            return false;
        }
        if (isBetterCandidate_I7lrPNg$isCandidate(rect2, i, rect3) && !m4069beamBeatsI7lrPNg(rect3, rect, rect2, i)) {
            return !m4069beamBeatsI7lrPNg(rect3, rect2, rect, i) && isBetterCandidate_I7lrPNg$weightedDistance(i, rect3, rect) < isBetterCandidate_I7lrPNg$weightedDistance(i, rect3, rect2);
        }
        return true;
    }

    private static final boolean beamBeats_I7lrPNg$inSourceBeam(Rect rect, int i, Rect rect2) {
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4016getLeftdhqQ8s()) ? true : FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4019getRightdhqQ8s())) {
            return rect.getBottom() > rect2.getTop() && rect.getTop() < rect2.getBottom();
        }
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4020getUpdhqQ8s()) ? true : FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4013getDowndhqQ8s())) {
            return rect.getRight() > rect2.getLeft() && rect.getLeft() < rect2.getRight();
        }
        throw new IllegalStateException(InvalidFocusDirection.toString());
    }

    private static final boolean beamBeats_I7lrPNg$isInDirectionOfSearch(Rect rect, int i, Rect rect2) {
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4016getLeftdhqQ8s())) {
            return rect2.getLeft() >= rect.getRight();
        }
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4019getRightdhqQ8s())) {
            return rect2.getRight() <= rect.getLeft();
        }
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4020getUpdhqQ8s())) {
            return rect2.getTop() >= rect.getBottom();
        }
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4013getDowndhqQ8s())) {
            return rect2.getBottom() <= rect.getTop();
        }
        throw new IllegalStateException(InvalidFocusDirection.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final float beamBeats_I7lrPNg$majorAxisDistance$6(androidx.compose.ui.geometry.Rect r1, int r2, androidx.compose.ui.geometry.Rect r3) {
        /*
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.INSTANCE
            int r0 = r0.m4016getLeftdhqQ8s()
            boolean r0 = androidx.compose.ui.focus.FocusDirection.m4009equalsimpl0(r2, r0)
            if (r0 == 0) goto L16
            float r2 = r3.getLeft()
            float r1 = r1.getRight()
        L14:
            float r2 = r2 - r1
            goto L57
        L16:
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.INSTANCE
            int r0 = r0.m4019getRightdhqQ8s()
            boolean r0 = androidx.compose.ui.focus.FocusDirection.m4009equalsimpl0(r2, r0)
            if (r0 == 0) goto L2d
            float r1 = r1.getLeft()
            float r2 = r3.getRight()
        L2a:
            float r2 = r1 - r2
            goto L57
        L2d:
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.INSTANCE
            int r0 = r0.m4020getUpdhqQ8s()
            boolean r0 = androidx.compose.ui.focus.FocusDirection.m4009equalsimpl0(r2, r0)
            if (r0 == 0) goto L42
            float r2 = r3.getTop()
            float r1 = r1.getBottom()
            goto L14
        L42:
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.INSTANCE
            int r0 = r0.m4013getDowndhqQ8s()
            boolean r2 = androidx.compose.ui.focus.FocusDirection.m4009equalsimpl0(r2, r0)
            if (r2 == 0) goto L5e
            float r1 = r1.getTop()
            float r2 = r3.getBottom()
            goto L2a
        L57:
            r1 = 0
            int r3 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r3 >= 0) goto L5d
            return r1
        L5d:
            return r2
        L5e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "This function should only be used for 2-D focus search"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt.beamBeats_I7lrPNg$majorAxisDistance$6(androidx.compose.ui.geometry.Rect, int, androidx.compose.ui.geometry.Rect):float");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x005d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final float beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(androidx.compose.ui.geometry.Rect r1, int r2, androidx.compose.ui.geometry.Rect r3) {
        /*
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.INSTANCE
            int r0 = r0.m4016getLeftdhqQ8s()
            boolean r0 = androidx.compose.ui.focus.FocusDirection.m4009equalsimpl0(r2, r0)
            if (r0 == 0) goto L16
            float r2 = r3.getLeft()
            float r1 = r1.getLeft()
        L14:
            float r2 = r2 - r1
            goto L57
        L16:
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.INSTANCE
            int r0 = r0.m4019getRightdhqQ8s()
            boolean r0 = androidx.compose.ui.focus.FocusDirection.m4009equalsimpl0(r2, r0)
            if (r0 == 0) goto L2d
            float r1 = r1.getRight()
            float r2 = r3.getRight()
        L2a:
            float r2 = r1 - r2
            goto L57
        L2d:
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.INSTANCE
            int r0 = r0.m4020getUpdhqQ8s()
            boolean r0 = androidx.compose.ui.focus.FocusDirection.m4009equalsimpl0(r2, r0)
            if (r0 == 0) goto L42
            float r2 = r3.getTop()
            float r1 = r1.getTop()
            goto L14
        L42:
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.INSTANCE
            int r0 = r0.m4013getDowndhqQ8s()
            boolean r2 = androidx.compose.ui.focus.FocusDirection.m4009equalsimpl0(r2, r0)
            if (r2 == 0) goto L5f
            float r1 = r1.getBottom()
            float r2 = r3.getBottom()
            goto L2a
        L57:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r3 >= 0) goto L5e
            return r1
        L5e:
            return r2
        L5f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "This function should only be used for 2-D focus search"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt.beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(androidx.compose.ui.geometry.Rect, int, androidx.compose.ui.geometry.Rect):float");
    }

    /* renamed from: beamBeats-I7lrPNg, reason: not valid java name */
    private static final boolean m4069beamBeatsI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i) {
        if (beamBeats_I7lrPNg$inSourceBeam(rect3, i, rect) || !beamBeats_I7lrPNg$inSourceBeam(rect2, i, rect)) {
            return false;
        }
        return !beamBeats_I7lrPNg$isInDirectionOfSearch(rect3, i, rect) || FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4016getLeftdhqQ8s()) || FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4019getRightdhqQ8s()) || beamBeats_I7lrPNg$majorAxisDistance$6(rect2, i, rect) < beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(rect3, i, rect);
    }

    private static final Rect topLeft(Rect rect) {
        return new Rect(rect.getLeft(), rect.getTop(), rect.getLeft(), rect.getTop());
    }

    private static final Rect bottomRight(Rect rect) {
        return new Rect(rect.getRight(), rect.getBottom(), rect.getRight(), rect.getBottom());
    }

    private static final FocusTargetNode activeNode(FocusTargetNode focusTargetNode) {
        if (focusTargetNode.getFocusState() != FocusStateImpl.ActiveParent) {
            throw new IllegalStateException("Searching for active node in inactive hierarchy".toString());
        }
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusTargetNode);
        if (findActiveFocusNode != null) {
            return findActiveFocusNode;
        }
        throw new IllegalStateException(NoActiveChild.toString());
    }

    /* renamed from: findChildCorrespondingToFocusEnter--OM-vw8, reason: not valid java name */
    public static final boolean m4071findChildCorrespondingToFocusEnterOMvw8(FocusTargetNode focusTargetNode, int i, Function1<? super FocusTargetNode, Boolean> function1) {
        Rect bottomRight;
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
        collectAccessibleChildren(focusTargetNode, mutableVector);
        if (mutableVector.getSize() <= 1) {
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) (mutableVector.getSize() == 0 ? null : mutableVector.content[0]);
            if (focusTargetNode2 != null) {
                return function1.invoke(focusTargetNode2).booleanValue();
            }
            return false;
        }
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4014getEnterdhqQ8s())) {
            i = FocusDirection.INSTANCE.m4019getRightdhqQ8s();
        }
        if (FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4019getRightdhqQ8s()) ? true : FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4013getDowndhqQ8s())) {
            bottomRight = topLeft(FocusTraversalKt.focusRect(focusTargetNode));
        } else {
            if (!(FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4016getLeftdhqQ8s()) ? true : FocusDirection.m4009equalsimpl0(i, FocusDirection.INSTANCE.m4020getUpdhqQ8s()))) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            bottomRight = bottomRight(FocusTraversalKt.focusRect(focusTargetNode));
        }
        FocusTargetNode m4070findBestCandidate4WY_MpI = m4070findBestCandidate4WY_MpI(mutableVector, bottomRight, i);
        if (m4070findBestCandidate4WY_MpI != null) {
            return function1.invoke(m4070findBestCandidate4WY_MpI).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: searchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m4074searchChildren4C6V_qg(FocusTargetNode focusTargetNode, Rect rect, int i, Function1<? super FocusTargetNode, Boolean> function1) {
        FocusTargetNode m4070findBestCandidate4WY_MpI;
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
        FocusTargetNode focusTargetNode2 = focusTargetNode;
        int m5994constructorimpl = NodeKind.m5994constructorimpl(1024);
        if (!focusTargetNode2.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusTargetNode2.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusTargetNode2.getNode(), false);
        } else {
            mutableVector2.add(child);
        }
        while (mutableVector2.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node.getAggregateChildKindSet() & m5994constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node, false);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    }
                    if ((node.getKindSet() & m5994constructorimpl) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode3 = (FocusTargetNode) node;
                                if (focusTargetNode3.getIsAttached()) {
                                    mutableVector.add(focusTargetNode3);
                                }
                            } else if ((node.getKindSet() & m5994constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            node = delegate;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector3);
                        }
                    } else {
                        node = node.getChild();
                    }
                }
            }
        }
        while (mutableVector.getSize() != 0 && (m4070findBestCandidate4WY_MpI = m4070findBestCandidate4WY_MpI(mutableVector, rect, i)) != null) {
            if (m4070findBestCandidate4WY_MpI.fetchFocusProperties$ui_release().getCanFocus()) {
                return function1.invoke(m4070findBestCandidate4WY_MpI).booleanValue();
            }
            if (m4072generateAndSearchChildren4C6V_qg(m4070findBestCandidate4WY_MpI, rect, i, function1)) {
                return true;
            }
            mutableVector.remove(m4070findBestCandidate4WY_MpI);
        }
        return false;
    }

    private static final void collectAccessibleChildren(DelegatableNode delegatableNode, MutableVector<FocusTargetNode> mutableVector) {
        int m5994constructorimpl = NodeKind.m5994constructorimpl(1024);
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, delegatableNode.getNode(), false);
        } else {
            mutableVector2.add(child);
        }
        while (mutableVector2.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node.getAggregateChildKindSet() & m5994constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node, false);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    }
                    if ((node.getKindSet() & m5994constructorimpl) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode = (FocusTargetNode) node;
                                if (focusTargetNode.getIsAttached()) {
                                    FocusTargetNode focusTargetNode2 = focusTargetNode;
                                    if (!DelegatableNodeKt.requireLayoutNode(focusTargetNode2).getIsDeactivated()) {
                                        if (focusTargetNode.fetchFocusProperties$ui_release().getCanFocus()) {
                                            mutableVector.add(focusTargetNode);
                                        } else {
                                            collectAccessibleChildren(focusTargetNode2, mutableVector);
                                        }
                                    }
                                }
                            } else if ((node.getKindSet() & m5994constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & m5994constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node = delegate;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector3);
                        }
                    } else {
                        node = node.getChild();
                    }
                }
            }
        }
    }
}
