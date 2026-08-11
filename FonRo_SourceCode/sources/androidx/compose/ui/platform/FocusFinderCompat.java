package androidx.compose.ui.platform;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.ObjectList;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collections;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: FocusFinderCompat.android.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000  2\u00020\u0001:\u0002 !B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J0\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J \u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011J2\u0010\u0014\u001a\u0004\u0018\u00010\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0003J\"\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0002J0\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J2\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/compose/ui/platform/FocusFinderCompat;", "", "()V", "focusedRect", "Landroid/graphics/Rect;", "tmpList", "Landroidx/collection/MutableObjectList;", "Landroid/view/View;", "userSpecifiedFocusComparator", "Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator;", "FocusFinder", "", "findNextFocus", "root", "Landroid/view/ViewGroup;", "focused", "direction", "", "focusables", "findNextFocus1d", "findNextFocusInRelativeDirection", "findNextUserSpecifiedFocus", "getEffectiveRoot", "getNextFocusable", "Landroidx/collection/ObjectList;", "count", "outLooped", "", "getPreviousFocusable", "isValidId", "", "id", "Companion", "UserSpecifiedFocusComparator", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class FocusFinderCompat {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final FocusFinderCompat$Companion$FocusFinderThreadLocal$1 FocusFinderThreadLocal = new ThreadLocal<FocusFinderCompat>() { // from class: androidx.compose.ui.platform.FocusFinderCompat$Companion$FocusFinderThreadLocal$1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public FocusFinderCompat initialValue() {
            return new FocusFinderCompat();
        }
    };
    private final Rect focusedRect = new Rect();
    private final UserSpecifiedFocusComparator userSpecifiedFocusComparator = new UserSpecifiedFocusComparator(new UserSpecifiedFocusComparator.NextFocusGetter() { // from class: androidx.compose.ui.platform.FocusFinderCompat$$ExternalSyntheticLambda0
        @Override // androidx.compose.ui.platform.FocusFinderCompat.UserSpecifiedFocusComparator.NextFocusGetter
        public final View get(View view, View view2) {
            return FocusFinderCompat.userSpecifiedFocusComparator$lambda$0(FocusFinderCompat.this, view, view2);
        }
    });
    private final MutableObjectList<View> tmpList = new MutableObjectList<>(0, 1, null);

    private final void FocusFinder() {
    }

    private final boolean isValidId(int id) {
        return (id == 0 || id == -1) ? false : true;
    }

    /* compiled from: FocusFinderCompat.android.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/FocusFinderCompat$Companion;", "", "()V", "FocusFinderThreadLocal", "androidx/compose/ui/platform/FocusFinderCompat$Companion$FocusFinderThreadLocal$1", "Landroidx/compose/ui/platform/FocusFinderCompat$Companion$FocusFinderThreadLocal$1;", "instance", "Landroidx/compose/ui/platform/FocusFinderCompat;", "getInstance", "()Landroidx/compose/ui/platform/FocusFinderCompat;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FocusFinderCompat getInstance() {
            FocusFinderCompat focusFinderCompat = FocusFinderCompat.FocusFinderThreadLocal.get();
            Intrinsics.checkNotNull(focusFinderCompat);
            return focusFinderCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final View userSpecifiedFocusComparator$lambda$0(FocusFinderCompat focusFinderCompat, View view, View view2) {
        View findUserSetNextFocus;
        if (!focusFinderCompat.isValidId(view2.getNextFocusForwardId())) {
            return null;
        }
        findUserSetNextFocus = FocusFinderCompat_androidKt.findUserSetNextFocus(view2, view, 2);
        return findUserSetNextFocus;
    }

    public final View findNextFocus1d(ViewGroup root, View focused, int direction) {
        ViewGroup effectiveRoot = getEffectiveRoot(root, focused);
        View findNextUserSpecifiedFocus = findNextUserSpecifiedFocus(effectiveRoot, focused, direction);
        if (findNextUserSpecifiedFocus != null) {
            return findNextUserSpecifiedFocus;
        }
        MutableObjectList<View> mutableObjectList = this.tmpList;
        try {
            mutableObjectList.clear();
            FocusFinderCompat_androidKt.addFocusableViews(effectiveRoot, mutableObjectList, direction);
            if (!mutableObjectList.isEmpty()) {
                findNextUserSpecifiedFocus = findNextFocus(effectiveRoot, focused, direction, mutableObjectList);
            }
            return findNextUserSpecifiedFocus;
        } finally {
            mutableObjectList.clear();
        }
    }

    private final ViewGroup getEffectiveRoot(ViewGroup root, View focused) {
        if (focused != null && focused != root) {
            ViewParent parent = focused.getParent();
            ViewGroup viewGroup = null;
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    break;
                }
                if (parent == root) {
                    if (viewGroup == null) {
                        break;
                    }
                    return viewGroup;
                }
                ViewGroup viewGroup2 = (ViewGroup) parent;
                if (viewGroup2.getTouchscreenBlocksFocus() && focused.getContext().getPackageManager().hasSystemFeature("android.hardware.touchscreen")) {
                    viewGroup = viewGroup2;
                }
                parent = viewGroup2.getParent();
            }
        }
        return root;
    }

    private final View findNextUserSpecifiedFocus(ViewGroup root, View focused, int direction) {
        View findUserSetNextFocus;
        ViewGroup viewGroup = root;
        findUserSetNextFocus = FocusFinderCompat_androidKt.findUserSetNextFocus(focused, viewGroup, direction);
        boolean z = true;
        View view = findUserSetNextFocus;
        while (findUserSetNextFocus != null) {
            if (findUserSetNextFocus.isFocusable() && findUserSetNextFocus.getVisibility() == 0 && (!findUserSetNextFocus.isInTouchMode() || findUserSetNextFocus.isFocusableInTouchMode())) {
                return findUserSetNextFocus;
            }
            findUserSetNextFocus = FocusFinderCompat_androidKt.findUserSetNextFocus(findUserSetNextFocus, viewGroup, direction);
            boolean z2 = !z;
            if (!z) {
                view = view != null ? FocusFinderCompat_androidKt.findUserSetNextFocus(view, viewGroup, direction) : null;
                if (view == findUserSetNextFocus) {
                    break;
                }
            }
            z = z2;
        }
        return null;
    }

    private final View findNextFocus(ViewGroup root, View focused, int direction, MutableObjectList<View> focusables) {
        Rect rect = this.focusedRect;
        focused.getFocusedRect(rect);
        root.offsetDescendantRectToMyCoords(focused, rect);
        return findNextFocusInRelativeDirection(focusables, root, focused, direction);
    }

    private final View findNextFocusInRelativeDirection(MutableObjectList<View> focusables, ViewGroup root, View focused, int direction) {
        try {
            Intrinsics.checkNotNull(root);
            this.userSpecifiedFocusComparator.setFocusables(focusables, root);
            Collections.sort(focusables.asMutableList(), this.userSpecifiedFocusComparator);
            this.userSpecifiedFocusComparator.recycle();
            int size = focusables.getSize();
            View view = null;
            if (size < 2) {
                return null;
            }
            boolean[] zArr = new boolean[1];
            if (direction == 1) {
                view = getPreviousFocusable(focused, focusables, size, zArr);
            } else if (direction == 2) {
                view = getNextFocusable(focused, focusables, size, zArr);
            }
            return view == null ? focusables.get(size - 1) : view;
        } catch (Throwable th) {
            this.userSpecifiedFocusComparator.recycle();
            throw th;
        }
    }

    private final View getNextFocusable(View focused, ObjectList<View> focusables, int count, boolean[] outLooped) {
        int i;
        if (count < 2) {
            return null;
        }
        int lastIndexOf = focusables.lastIndexOf(focused);
        if (lastIndexOf >= 0 && (i = lastIndexOf + 1) < count) {
            return focusables.get(i);
        }
        outLooped[0] = true;
        return focusables.get(0);
    }

    private final View getPreviousFocusable(View focused, ObjectList<View> focusables, int count, boolean[] outLooped) {
        int indexOf;
        if (count < 2) {
            return null;
        }
        if (focused != null && (indexOf = focusables.indexOf(focused)) > 0) {
            return focusables.get(indexOf - 1);
        }
        outLooped[0] = true;
        return focusables.get(count - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FocusFinderCompat.android.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u0003:\u0001\u001aB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010\u0013\u001a\u00020\u0014J\u001c\u0010\u0015\u001a\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0002R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator;", "Ljava/util/Comparator;", "Landroid/view/View;", "Lkotlin/Comparator;", "mNextFocusGetter", "Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator$NextFocusGetter;", "(Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator$NextFocusGetter;)V", "headsOfChains", "Landroidx/collection/MutableScatterMap;", "isConnectedTo", "Landroidx/collection/MutableScatterSet;", "nextFoci", "originalOrdinal", "Landroidx/collection/MutableObjectIntMap;", "root", "compare", "", "first", "second", "recycle", "", "setFocusables", "focusables", "Landroidx/collection/ObjectList;", "setHeadOfChain", "head", "NextFocusGetter", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes4.dex */
    public static final class UserSpecifiedFocusComparator implements Comparator<View> {
        private final NextFocusGetter mNextFocusGetter;
        private View root;
        private final MutableScatterMap<View, View> nextFoci = ScatterMapKt.mutableScatterMapOf();
        private final MutableScatterSet<View> isConnectedTo = ScatterSetKt.mutableScatterSetOf();
        private final MutableScatterMap<View, View> headsOfChains = ScatterMapKt.mutableScatterMapOf();
        private final MutableObjectIntMap<View> originalOrdinal = ObjectIntMapKt.mutableObjectIntMapOf();

        /* compiled from: FocusFinderCompat.android.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator$NextFocusGetter;", "", "get", "Landroid/view/View;", "root", "view", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes4.dex */
        public interface NextFocusGetter {
            View get(View root, View view);
        }

        public UserSpecifiedFocusComparator(NextFocusGetter nextFocusGetter) {
            this.mNextFocusGetter = nextFocusGetter;
        }

        public final void recycle() {
            this.root = null;
            this.headsOfChains.clear();
            this.isConnectedTo.clear();
            this.originalOrdinal.clear();
            this.nextFoci.clear();
        }

        public final void setFocusables(ObjectList<View> focusables, View root) {
            this.root = root;
            Object[] objArr = focusables.content;
            int i = focusables._size;
            for (int i2 = 0; i2 < i; i2++) {
                this.originalOrdinal.set((View) objArr[i2], i2);
            }
            IntRange until = RangesKt.until(0, focusables._size);
            int first = until.getFirst();
            int last = until.getLast();
            if (first <= last) {
                while (true) {
                    View view = focusables.get(last);
                    View view2 = this.mNextFocusGetter.get(root, view);
                    if (view2 != null && this.originalOrdinal.containsKey(view2)) {
                        this.nextFoci.set(view, view2);
                        this.isConnectedTo.add(view2);
                    }
                    if (last == first) {
                        break;
                    } else {
                        last--;
                    }
                }
            }
            IntRange until2 = RangesKt.until(0, focusables._size);
            int first2 = until2.getFirst();
            int last2 = until2.getLast();
            if (first2 > last2) {
                return;
            }
            while (true) {
                View view3 = focusables.get(last2);
                if (this.nextFoci.get(view3) != null && !this.isConnectedTo.contains(view3)) {
                    setHeadOfChain(view3);
                }
                if (last2 == first2) {
                    return;
                } else {
                    last2--;
                }
            }
        }

        public final void setHeadOfChain(View head) {
            View view = head;
            while (head != null) {
                View view2 = this.headsOfChains.get(head);
                if (view2 != null) {
                    if (view2 == view) {
                        return;
                    }
                    head = view;
                    view = view2;
                }
                this.headsOfChains.set(head, view);
                head = this.nextFoci.get(head);
            }
        }

        @Override // java.util.Comparator
        public int compare(View first, View second) {
            if (first == second) {
                return 0;
            }
            if (first == null) {
                return -1;
            }
            if (second == null) {
                return 1;
            }
            View view = this.headsOfChains.get(first);
            View view2 = this.headsOfChains.get(second);
            if (view == view2 && view != null) {
                if (first == view) {
                    return -1;
                }
                return (second == view || this.nextFoci.get(first) == null) ? 1 : -1;
            }
            if (view != null) {
                first = view;
            }
            if (view2 != null) {
                second = view2;
            }
            if (view == null && view2 == null) {
                return 0;
            }
            return this.originalOrdinal.get(first) < this.originalOrdinal.get(second) ? -1 : 1;
        }
    }
}
