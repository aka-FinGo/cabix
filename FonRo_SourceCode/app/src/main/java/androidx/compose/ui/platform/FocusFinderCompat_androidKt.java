package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewGroup;
import androidx.collection.MutableObjectList;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: FocusFinderCompat.android.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\"\u0010\u0006\u001a\u00020\u0007*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\n\u001a\u00020\u0005H\u0002\u001a*\u0010\u0006\u001a\u00020\u0007*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u001e\u0010\r\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0005H\u0002\u001a*\u0010\u000e\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0010H\u0002\u001a,\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006\u0013"}, d2 = {"findViewInsideOutShouldExist", "Landroid/view/View;", "root", "start", "id", "", "addFocusableViews", "", "views", "Landroidx/collection/MutableObjectList;", "direction", "inTouchMode", "", "findUserSetNextFocus", "findViewByPredicateInsideOut", "predicate", "Lkotlin/Function1;", "findViewByPredicateTraversal", "childToSkip", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class FocusFinderCompat_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final View findUserSetNextFocus(final View view, final View view2, int i) {
        int nextFocusForwardId;
        if (i == 1) {
            if (view.getId() == -1) {
                return null;
            }
            return findViewByPredicateInsideOut(view2, view, new Function1<View, Boolean>() { // from class: androidx.compose.ui.platform.FocusFinderCompat_androidKt$findUserSetNextFocus$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(View view3) {
                    View findViewInsideOutShouldExist;
                    findViewInsideOutShouldExist = FocusFinderCompat_androidKt.findViewInsideOutShouldExist(view2, view3, view3.getNextFocusForwardId());
                    return Boolean.valueOf(findViewInsideOutShouldExist == view);
                }
            });
        }
        if (i == 2 && (nextFocusForwardId = view.getNextFocusForwardId()) != -1) {
            return findViewInsideOutShouldExist(view2, view, nextFocusForwardId);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View findViewInsideOutShouldExist(View view, View view2, final int i) {
        return findViewByPredicateInsideOut(view, view2, new Function1<View, Boolean>() { // from class: androidx.compose.ui.platform.FocusFinderCompat_androidKt$findViewInsideOutShouldExist$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(View view3) {
                return Boolean.valueOf(view3.getId() == i);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001d, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final android.view.View findViewByPredicateInsideOut(android.view.View r4, android.view.View r5, kotlin.jvm.functions.Function1<? super android.view.View, java.lang.Boolean> r6) {
        /*
            r0 = 0
            r1 = r0
        L2:
            android.view.View r1 = findViewByPredicateTraversal(r5, r6, r1)
            if (r1 != 0) goto L1d
            if (r5 != r4) goto Lb
            goto L1d
        Lb:
            android.view.ViewParent r1 = r5.getParent()
            if (r1 == 0) goto L1c
            boolean r2 = r1 instanceof android.view.View
            if (r2 != 0) goto L16
            goto L1c
        L16:
            android.view.View r1 = (android.view.View) r1
            r3 = r1
            r1 = r5
            r5 = r3
            goto L2
        L1c:
            return r0
        L1d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.FocusFinderCompat_androidKt.findViewByPredicateInsideOut(android.view.View, android.view.View, kotlin.jvm.functions.Function1):android.view.View");
    }

    private static final View findViewByPredicateTraversal(View view, Function1<? super View, Boolean> function1, View view2) {
        View findViewByPredicateTraversal;
        if (function1.invoke(view).booleanValue()) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt != view2 && (findViewByPredicateTraversal = findViewByPredicateTraversal(childAt, function1, view2)) != null) {
                return findViewByPredicateTraversal;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addFocusableViews(View view, MutableObjectList<View> mutableObjectList, int i) {
        addFocusableViews(view, mutableObjectList, i, view.isInTouchMode());
    }

    private static final void addFocusableViews(View view, MutableObjectList<View> mutableObjectList, int i, boolean z) {
        if (view.getVisibility() == 0 && view.isFocusable() && view.isEnabled() && view.getWidth() > 0 && view.getHeight() > 0 && (!z || view.isFocusableInTouchMode())) {
            mutableObjectList.add(view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                addFocusableViews(viewGroup.getChildAt(i2), mutableObjectList, i, z);
            }
        }
    }
}
