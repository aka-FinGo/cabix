package com.google.android.material.listitem;

import android.R;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.listitem.ListItemLayout;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes6.dex */
public class ListItemLayout extends FrameLayout {
    private static final int DEFAULT_SIGNIFICANT_VEL_THRESHOLD = 500;
    public static final int POSITION_FIRST = 0;
    public static final int POSITION_LAST = 2;
    public static final int POSITION_MIDDLE = 1;
    public static final int POSITION_SINGLE = 3;
    private static final int SETTLING_DURATION = 350;
    private RevealableListItem activeSwipeToRevealLayout;
    private View contentView;
    private GestureDetector gestureDetector;
    private int lastStableSwipeState;
    private boolean originalClipToPadding;
    private int originalContentViewLeft;
    private int[] positionState;
    private int revealViewOffset;
    private final StateSettlingTracker stateSettlingTracker;
    private View.AccessibilityDelegate swipeAccessibilityDelegate;
    private int swipeState;
    private View swipeToRevealLayoutLeft;
    private View swipeToRevealLayoutRight;
    private ViewDragHelper viewDragHelper;
    private static final int[] FIRST_STATE_SET = {R.attr.state_first};
    private static final int[] MIDDLE_STATE_SET = {R.attr.state_middle};
    private static final int[] LAST_STATE_SET = {R.attr.state_last};
    private static final int[] SINGLE_STATE_SET = {R.attr.state_single};
    private static final TimeInterpolator CUBIC_BEZIER_INTERPOLATOR = new PathInterpolator(0.42f, 1.67f, 0.21f, 0.9f);

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface Position {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class StateSettlingTracker {
        private final Runnable continueSettlingRunnable;
        private boolean isContinueSettlingRunnablePosted;
        private int targetRevealGravity;
        private int targetSwipeState;

        private StateSettlingTracker() {
            this.continueSettlingRunnable = new Runnable() { // from class: com.google.android.material.listitem.ListItemLayout$StateSettlingTracker$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ListItemLayout.StateSettlingTracker.this.m7755x75cf24c1();
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$new$0$com-google-android-material-listitem-ListItemLayout$StateSettlingTracker, reason: not valid java name */
        public /* synthetic */ void m7755x75cf24c1() {
            this.isContinueSettlingRunnablePosted = false;
            if (ListItemLayout.this.viewDragHelper == null || !ListItemLayout.this.viewDragHelper.continueSettling(true)) {
                if (ListItemLayout.this.swipeState == 2) {
                    ListItemLayout.this.setSwipeStateInternal(this.targetSwipeState, this.targetRevealGravity);
                    return;
                }
                return;
            }
            continueSettlingToState(this.targetSwipeState, this.targetRevealGravity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void continueSettlingToState(int i, int i2) {
            this.targetSwipeState = i;
            this.targetRevealGravity = i2;
            if (this.isContinueSettlingRunnablePosted) {
                return;
            }
            ListItemLayout.this.post(this.continueSettlingRunnable);
            this.isContinueSettlingRunnablePosted = true;
        }
    }

    public ListItemLayout(Context context) {
        this(context, null);
    }

    public ListItemLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.listItemLayoutStyle);
    }

    public ListItemLayout(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, com.google.android.material.R.style.Widget_Material3_ListItemLayout);
    }

    public ListItemLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        this.swipeState = 3;
        this.lastStableSwipeState = 3;
        this.stateSettlingTracker = new StateSettlingTracker();
        getContext();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        if (this.positionState == null) {
            return super.onCreateDrawableState(i);
        }
        return mergeDrawableStates(super.onCreateDrawableState(i + 1), this.positionState);
    }

    public void updateAppearance(int i, int i2) {
        if (i < 0 || i2 < 0) {
            this.positionState = null;
        } else if (i2 == 1) {
            this.positionState = SINGLE_STATE_SET;
        } else if (i == 0) {
            this.positionState = FIRST_STATE_SET;
        } else if (i == i2 - 1) {
            this.positionState = LAST_STATE_SET;
        } else {
            this.positionState = MIDDLE_STATE_SET;
        }
        refreshDrawableState();
    }

    public void updateAppearance(int i) {
        if (i == 0) {
            this.positionState = FIRST_STATE_SET;
        } else if (i == 1) {
            this.positionState = MIDDLE_STATE_SET;
        } else if (i == 2) {
            this.positionState = LAST_STATE_SET;
        } else if (i == 3) {
            this.positionState = SINGLE_STATE_SET;
        }
        refreshDrawableState();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view instanceof RevealableListItem) {
            if (ListItemUtils.isRightAligned(view)) {
                if (this.swipeToRevealLayoutRight != null) {
                    throw new UnsupportedOperationException("Only one RevealableListItem with end gravity is supported.");
                }
                this.swipeToRevealLayoutRight = view;
            } else {
                if (this.swipeToRevealLayoutLeft != null) {
                    throw new UnsupportedOperationException("Only one RevealableListItem with start gravity is supported.");
                }
                this.swipeToRevealLayoutLeft = view;
            }
            ((RevealableListItem) view).setRevealedWidth(0);
            view.setElevation(getElevation() - 1.0f);
            return;
        }
        if (this.contentView != null && (view instanceof SwipeableListItem)) {
            throw new UnsupportedOperationException("Only one SwipeableListItem view is allowed in a ListItemLayout.");
        }
        if (view instanceof SwipeableListItem) {
            this.contentView = view;
        }
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view == this.swipeToRevealLayoutLeft) {
            this.swipeToRevealLayoutLeft = null;
        } else if (view == this.swipeToRevealLayoutRight) {
            this.swipeToRevealLayoutRight = null;
        } else if (this.contentView == view) {
            this.contentView = null;
        }
        if (!swipeToRevealLayoutExists() || this.contentView == null) {
            this.viewDragHelper = null;
            this.gestureDetector = null;
            this.swipeAccessibilityDelegate = null;
            setClipToPadding(this.originalClipToPadding);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (ensureSwipeToRevealSetupIfNeeded()) {
            this.viewDragHelper.processTouchEvent(motionEvent);
            this.gestureDetector.onTouchEvent(motionEvent);
            if (this.viewDragHelper.getViewDragState() == 1) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (ensureSwipeToRevealSetupIfNeeded()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 3 || actionMasked == 1) {
                this.viewDragHelper.cancel();
                return false;
            }
            this.gestureDetector.onTouchEvent(motionEvent);
            return this.viewDragHelper.shouldInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private boolean ensureSwipeToRevealSetupIfNeeded() {
        if (!swipeToRevealLayoutExists() || this.contentView == null) {
            return false;
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = createViewDragHelper();
        }
        if (this.gestureDetector == null) {
            this.gestureDetector = createGestureDetector();
        }
        if (this.swipeAccessibilityDelegate == null) {
            View.AccessibilityDelegate createSwipeAccessibilityDelegate = createSwipeAccessibilityDelegate();
            this.swipeAccessibilityDelegate = createSwipeAccessibilityDelegate;
            this.contentView.setAccessibilityDelegate(createSwipeAccessibilityDelegate);
        }
        if (!getClipToPadding()) {
            return true;
        }
        this.originalClipToPadding = getClipToPadding();
        setClipToPadding(false);
        return true;
    }

    private ViewDragHelper createViewDragHelper() {
        return ViewDragHelper.create(this, new ViewDragHelper.Callback() { // from class: com.google.android.material.listitem.ListItemLayout.1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                if ((!(ListItemLayout.this.contentView instanceof SwipeableListItem) || ((SwipeableListItem) ListItemLayout.this.contentView).isSwipeEnabled()) && ListItemLayout.this.swipeToRevealLayoutExists() && ListItemLayout.this.contentView != null) {
                    ListItemLayout.this.viewDragHelper.captureChildView(ListItemLayout.this.contentView, i);
                }
                return false;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View view, int i, int i2) {
                if (!(ListItemLayout.this.contentView instanceof SwipeableListItem) || !ListItemLayout.this.swipeToRevealLayoutExists()) {
                    return 0;
                }
                SwipeableListItem swipeableListItem = (SwipeableListItem) ListItemLayout.this.contentView;
                int i3 = ListItemLayout.this.originalContentViewLeft;
                int i4 = ListItemLayout.this.originalContentViewLeft;
                if (ListItemLayout.this.swipeToRevealLayoutRight instanceof RevealableListItem) {
                    i3 = ListItemLayout.this.originalContentViewLeft - (calculateMaxSwipeDistance((RevealableListItem) ListItemLayout.this.swipeToRevealLayoutRight) + swipeableListItem.getSwipeMaxOvershoot());
                }
                if (ListItemLayout.this.swipeToRevealLayoutLeft instanceof RevealableListItem) {
                    int calculateMaxSwipeDistance = calculateMaxSwipeDistance((RevealableListItem) ListItemLayout.this.swipeToRevealLayoutLeft);
                    i4 = calculateMaxSwipeDistance + swipeableListItem.getSwipeMaxOvershoot() + ListItemLayout.this.originalContentViewLeft;
                }
                return Math.max(i3, Math.min(i, i4));
            }

            /* JADX WARN: Multi-variable type inference failed */
            private int calculateMaxSwipeDistance(RevealableListItem revealableListItem) {
                int intrinsicWidth;
                int marginEnd;
                View view = (View) revealableListItem;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                if (revealableListItem.getPrimaryActionSwipeMode() != 0) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) ListItemLayout.this.contentView.getLayoutParams();
                    if (ListItemUtils.isRightAligned(view)) {
                        marginEnd = marginLayoutParams2.leftMargin;
                    } else {
                        marginEnd = marginLayoutParams2.rightMargin;
                    }
                    intrinsicWidth = ListItemLayout.this.contentView.getMeasuredWidth();
                } else {
                    intrinsicWidth = revealableListItem.getIntrinsicWidth() + marginLayoutParams.getMarginStart();
                    marginEnd = marginLayoutParams.getMarginEnd();
                }
                return intrinsicWidth + marginEnd;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewHorizontalDragRange(View view) {
                if (!(ListItemLayout.this.contentView instanceof SwipeableListItem)) {
                    return 0;
                }
                SwipeableListItem swipeableListItem = (SwipeableListItem) ListItemLayout.this.contentView;
                int intrinsicWidth = ListItemLayout.this.swipeToRevealLayoutLeft instanceof RevealableListItem ? ((RevealableListItem) ListItemLayout.this.swipeToRevealLayoutLeft).getIntrinsicWidth() + swipeableListItem.getSwipeMaxOvershoot() : 0;
                return ListItemLayout.this.swipeToRevealLayoutRight instanceof RevealableListItem ? intrinsicWidth + ((RevealableListItem) ListItemLayout.this.swipeToRevealLayoutRight).getIntrinsicWidth() + swipeableListItem.getSwipeMaxOvershoot() : intrinsicWidth;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                if (ListItemLayout.this.viewDragHelper != null && (ListItemLayout.this.contentView instanceof SwipeableListItem) && ListItemLayout.this.swipeToRevealLayoutExists()) {
                    super.onViewPositionChanged(view, i, i2, i3, i4);
                    ListItemLayout.this.updateSwipeProgress(i);
                    if (ListItemLayout.this.viewDragHelper.getViewDragState() != 1 || ListItemLayout.this.activeSwipeToRevealLayout == null) {
                        return;
                    }
                    ListItemLayout listItemLayout = ListItemLayout.this;
                    listItemLayout.setSwipeStateInternal(1, listItemLayout.getAbsoluteRevealGravity((View) listItemLayout.activeSwipeToRevealLayout));
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(View view, float f, float f2) {
                int left;
                if ((ListItemLayout.this.contentView instanceof SwipeableListItem) && ListItemLayout.this.swipeToRevealLayoutExists() && (left = view.getLeft()) != ListItemLayout.this.originalContentViewLeft) {
                    int i = left > ListItemLayout.this.originalContentViewLeft ? 3 : 5;
                    ListItemLayout listItemLayout = ListItemLayout.this;
                    RevealableListItem revealableListItem = i == 3 ? (RevealableListItem) listItemLayout.swipeToRevealLayoutLeft : (RevealableListItem) listItemLayout.swipeToRevealLayoutRight;
                    if (revealableListItem == null) {
                        return;
                    }
                    int calculateTargetSwipeState = calculateTargetSwipeState(i, revealableListItem, f, left);
                    ListItemLayout listItemLayout2 = ListItemLayout.this;
                    listItemLayout2.startSettling(listItemLayout2.contentView, calculateTargetSwipeState, i);
                }
            }

            private int calculateTargetSwipeState(int i, RevealableListItem revealableListItem, float f, int i2) {
                if (!ListItemLayout.this.swipeToRevealLayoutExistsForGravity(i)) {
                    return 3;
                }
                if (i != 3) {
                    f = -f;
                }
                return calculateTargetSwipeStateForRevealLayout(i2, f, revealableListItem, ListItemLayout.this.getSwipeRevealViewRevealedOffset(i), ListItemLayout.this.getSwipeToActionOffset(i));
            }

            private int calculateTargetSwipeStateForRevealLayout(int i, float f, RevealableListItem revealableListItem, int i2, int i3) {
                boolean z = revealableListItem.getPrimaryActionSwipeMode() != 0;
                boolean z2 = revealableListItem.getPrimaryActionSwipeMode() == 2;
                if (f > 500.0f) {
                    return (!z || (ListItemLayout.this.lastStableSwipeState == 3 && !z2)) ? 4 : 5;
                }
                if (f < -500.0f) {
                    return (z2 || ListItemLayout.this.lastStableSwipeState != 5) ? 3 : 4;
                }
                if (z && Math.abs(i - i3) < Math.abs(i - i2)) {
                    return 5;
                }
                if (z && z2) {
                    i2 = i3;
                }
                if (Math.abs(i - i2) < Math.abs(i - ListItemLayout.this.getSwipeViewClosedOffset())) {
                    return (z && z2) ? 5 : 4;
                }
                return 3;
            }
        });
    }

    private GestureDetector createGestureDetector() {
        return new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.google.android.material.listitem.ListItemLayout.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (ListItemLayout.this.getParent() == null) {
                    return false;
                }
                ListItemLayout.this.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
    }

    private View.AccessibilityDelegate createSwipeAccessibilityDelegate() {
        return new View.AccessibilityDelegate() { // from class: com.google.android.material.listitem.ListItemLayout.3
            private void addSwipeAccessibilityActions(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        View childAt = viewGroup.getChildAt(i);
                        if (shouldAddAccessibilityAction(childAt)) {
                            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(getAccessibilityActionId(childAt), childAt.getContentDescription()));
                        }
                    }
                }
            }

            private boolean performRevealViewAction(View view, int i) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (getAccessibilityActionId(childAt) == i) {
                            return childAt.performClick();
                        }
                    }
                }
                return false;
            }

            private boolean shouldAddAccessibilityAction(View view) {
                return view.isClickable() && view.getContentDescription() != null && view.isEnabled() && view.getVisibility() == 0;
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
                addSwipeAccessibilityActions(ListItemLayout.this.swipeToRevealLayoutLeft, wrap);
                addSwipeAccessibilityActions(ListItemLayout.this.swipeToRevealLayoutRight, wrap);
            }

            @Override // android.view.View.AccessibilityDelegate
            public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                if (performRevealViewAction(ListItemLayout.this.swipeToRevealLayoutLeft, i) || performRevealViewAction(ListItemLayout.this.swipeToRevealLayoutRight, i)) {
                    return true;
                }
                return super.performAccessibilityAction(view, i, bundle);
            }

            private int getAccessibilityActionId(View view) {
                return view.getId();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public int getSwipeRevealViewRevealedOffset(int i) {
        View view = isRevealGravityLeft(i) ? this.swipeToRevealLayoutLeft : this.swipeToRevealLayoutRight;
        if (view == 0) {
            return 0;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return this.originalContentViewLeft + ((isRevealGravityLeft(i) ? 1 : -1) * (((RevealableListItem) view).getIntrinsicWidth() + layoutParams.leftMargin + layoutParams.rightMargin));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSwipeViewClosedOffset() {
        return this.originalContentViewLeft;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSwipeToActionOffset(int i) {
        View view = this.contentView;
        if (view == null) {
            return 0;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return this.originalContentViewLeft + ((isRevealGravityLeft(i) ? 1 : -1) * (this.contentView.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin));
    }

    private boolean isRevealGravityLeft(int i) {
        return getAbsoluteHorizontalGravity(i) == 3;
    }

    private int getAbsoluteHorizontalGravity(int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, getLayoutDirection()) & 7;
        if (absoluteGravity == 3) {
            return 3;
        }
        return (absoluteGravity != 5 && getLayoutDirection() == 1) ? 3 : 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean swipeToRevealLayoutExistsForGravity(int i) {
        maybeSwapRevealLayoutsForGravity();
        if (isRevealGravityLeft(i)) {
            return this.swipeToRevealLayoutLeft instanceof RevealableListItem;
        }
        return this.swipeToRevealLayoutRight instanceof RevealableListItem;
    }

    private int getOffsetForSwipeState(int i, int i2) {
        if (!swipeToRevealLayoutExistsForGravity(i2)) {
            throw new IllegalArgumentException("No RevealableListItem with gravity " + i2);
        }
        if (i == 3) {
            return getSwipeViewClosedOffset();
        }
        if (i == 4) {
            return getSwipeRevealViewRevealedOffset(i2);
        }
        if (i == 5) {
            return getSwipeToActionOffset(i2);
        }
        throw new IllegalArgumentException("Invalid state to get swipe offset: " + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateSwipeProgress(int r7) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.listitem.ListItemLayout.updateSwipeProgress(int):void");
    }

    private void updateAlphaFade(int i, int i2) {
        int i3;
        if (i2 == i) {
            i3 = (getSwipeViewClosedOffset() + i) / 2;
        } else {
            i3 = (i2 + i) / 2;
        }
        this.contentView.setAlpha(AnimationUtils.lerp(1.0f, 0.0f, (this.revealViewOffset - i3) / (i - i3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSettling(View view, int i, int i2) {
        boolean smoothSlideViewTo;
        if (this.viewDragHelper == null) {
            return;
        }
        int offsetForSwipeState = getOffsetForSwipeState(i, i2);
        ViewDragHelper viewDragHelper = this.viewDragHelper;
        if (i == 4) {
            smoothSlideViewTo = viewDragHelper.smoothSlideViewTo(view, offsetForSwipeState, view.getTop(), SETTLING_DURATION, (Interpolator) CUBIC_BEZIER_INTERPOLATOR);
        } else {
            smoothSlideViewTo = viewDragHelper.smoothSlideViewTo(view, offsetForSwipeState, view.getTop());
        }
        if (smoothSlideViewTo) {
            setSwipeStateInternal(2, i2);
            this.stateSettlingTracker.continueSettlingToState(i, i2);
        } else {
            setSwipeStateInternal(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void setSwipeStateInternal(int i, int i2) {
        RevealableListItem revealableListItem;
        RevealableListItem revealableListItem2;
        Object obj;
        int absoluteHorizontalGravity = getAbsoluteHorizontalGravity(i2);
        if (i == this.swipeState && ((obj = this.activeSwipeToRevealLayout) == null || getAbsoluteRevealGravity((View) obj) == absoluteHorizontalGravity)) {
            return;
        }
        if (i == 3 || swipeToRevealLayoutExistsForGravity(absoluteHorizontalGravity)) {
            if (i == 5 && ((revealableListItem2 = this.activeSwipeToRevealLayout) == null || revealableListItem2.getPrimaryActionSwipeMode() == 0)) {
                return;
            }
            if (isRevealGravityLeft(absoluteHorizontalGravity)) {
                revealableListItem = (RevealableListItem) this.swipeToRevealLayoutLeft;
            } else {
                revealableListItem = (RevealableListItem) this.swipeToRevealLayoutRight;
            }
            this.activeSwipeToRevealLayout = revealableListItem;
            this.swipeState = i;
            if (i != 1 && i != 2) {
                this.lastStableSwipeState = i;
            }
            if (revealableListItem != 0) {
                absoluteHorizontalGravity = ((FrameLayout.LayoutParams) ((View) revealableListItem).getLayoutParams()).gravity;
            }
            SwipeableListItem swipeableListItem = (SwipeableListItem) this.contentView;
            View castToView = castToView(this.activeSwipeToRevealLayout);
            if (absoluteHorizontalGravity == -1) {
                absoluteHorizontalGravity = GravityCompat.END;
            }
            swipeableListItem.onSwipeStateChanged(i, castToView, absoluteHorizontalGravity);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T extends View & RevealableListItem> T castToView(RevealableListItem revealableListItem) {
        return (T) ((View) revealableListItem);
    }

    public <T extends View & RevealableListItem> void setSwipeState(int i, T t) {
        setSwipeState(i, (int) t, true);
    }

    public <T extends View & RevealableListItem> void setSwipeState(int i, T t, boolean z) {
        if (t != this.swipeToRevealLayoutLeft && t != this.swipeToRevealLayoutRight) {
            throw new IllegalArgumentException("revealView must be a child of ListItemLayout.");
        }
        setSwipeState(i, ((FrameLayout.LayoutParams) t.getLayoutParams()).gravity, z);
    }

    public void setSwipeState(int i, int i2) {
        setSwipeState(i, i2, true);
    }

    public void setSwipeState(final int i, final int i2, final boolean z) {
        if (i != 3 && i != 4 && i != 5) {
            throw new IllegalArgumentException("Invalid swipe state: " + i);
        }
        if (!(this.contentView instanceof SwipeableListItem) || !swipeToRevealLayoutExists()) {
            throw new IllegalArgumentException("ListItemLayout must have a SwipeableListItem child and a RevealableListItem child to be swiped.");
        }
        if (i != 3 && !swipeToRevealLayoutExistsForGravity(i2)) {
            throw new IllegalArgumentException("No RevealableListItem is defined for the given gravity: " + i2);
        }
        Runnable runnable = new Runnable() { // from class: com.google.android.material.listitem.ListItemLayout$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ListItemLayout.this.m7754x6b76121b(z, i, i2);
            }
        };
        if (isLaidOut()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setSwipeState$0$com-google-android-material-listitem-ListItemLayout, reason: not valid java name */
    public /* synthetic */ void m7754x6b76121b(boolean z, int i, int i2) {
        if (!z) {
            ViewDragHelper viewDragHelper = this.viewDragHelper;
            if (viewDragHelper != null) {
                viewDragHelper.abort();
            }
            int offsetForSwipeState = getOffsetForSwipeState(i, i2);
            View view = this.contentView;
            view.offsetLeftAndRight(offsetForSwipeState - view.getLeft());
            updateSwipeProgress(offsetForSwipeState);
            setSwipeStateInternal(i, i2);
            return;
        }
        startSettling(this.contentView, i, i2);
    }

    public int getSwipeState() {
        return this.swipeState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean swipeToRevealLayoutExists() {
        return (this.swipeToRevealLayoutLeft instanceof RevealableListItem) || (this.swipeToRevealLayoutRight instanceof RevealableListItem);
    }

    private void maybeSwapRevealLayoutsForGravity() {
        View view = this.swipeToRevealLayoutLeft;
        boolean z = view != null && ListItemUtils.isRightAligned(view);
        View view2 = this.swipeToRevealLayoutRight;
        boolean z2 = (view2 == null || ListItemUtils.isRightAligned(view2)) ? false : true;
        if (z && z2) {
            View view3 = this.swipeToRevealLayoutLeft;
            this.swipeToRevealLayoutLeft = this.swipeToRevealLayoutRight;
            this.swipeToRevealLayoutRight = view3;
            this.revealViewOffset *= -1;
            return;
        }
        if (z) {
            if (this.swipeToRevealLayoutRight != null) {
                throw new IllegalStateException("Cannot have more than one RevealableListItem with the same absolute gravity.");
            }
            this.swipeToRevealLayoutRight = this.swipeToRevealLayoutLeft;
            this.swipeToRevealLayoutLeft = null;
            this.revealViewOffset *= -1;
            return;
        }
        if (z2) {
            if (this.swipeToRevealLayoutLeft != null) {
                throw new IllegalStateException("Cannot have more than one RevealableListItem with the same absolute gravity.");
            }
            this.swipeToRevealLayoutLeft = this.swipeToRevealLayoutRight;
            this.swipeToRevealLayoutRight = null;
            this.revealViewOffset *= -1;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        maybeSwapRevealLayoutsForGravity();
        if (this.contentView != null && swipeToRevealLayoutExists() && ensureSwipeToRevealSetupIfNeeded()) {
            this.originalContentViewLeft = this.contentView.getLeft();
            int right = this.contentView.getRight();
            this.contentView.offsetLeftAndRight(this.revealViewOffset);
            View view = this.swipeToRevealLayoutLeft;
            if (view != null) {
                layoutRevealView(view, this.originalContentViewLeft, right);
            }
            View view2 = this.swipeToRevealLayoutRight;
            if (view2 != null) {
                layoutRevealView(view2, this.originalContentViewLeft, right);
            }
        }
    }

    private void layoutRevealView(View view, int i, int i2) {
        int i3;
        int measuredWidth;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (ListItemUtils.isRightAligned(view)) {
            measuredWidth = i2 - layoutParams.rightMargin;
            i3 = measuredWidth - view.getMeasuredWidth();
        } else {
            i3 = layoutParams.leftMargin + i;
            measuredWidth = i3 + view.getMeasuredWidth();
        }
        view.layout(i3, view.getTop(), measuredWidth, view.getBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getAbsoluteRevealGravity(View view) {
        return ListItemUtils.isRightAligned(view) ? 5 : 3;
    }
}
