package androidx.compose.ui.autofill;

import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.collection.ObjectListKt;
import androidx.compose.material3.internal.Listener$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.focus.FocusListener;
import androidx.compose.ui.focus.FocusTargetModifierNode;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.platform.coreshims.AutofillIdCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsInfo;
import androidx.compose.ui.semantics.SemanticsListener;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.spatial.RectManager;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidAutofillManager.android.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0015\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b!J\r\u0010\"\u001a\u00020\u001cH\u0000¢\u0006\u0002\b#J\u001c\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0015\u0010(\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b)J\u0015\u0010*\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b+J\u001d\u0010,\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010-\u001a\u00020.H\u0000¢\u0006\u0002\b/J\u001a\u00100\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0014\u00103\u001a\u00020\u001c2\f\u00104\u001a\b\u0012\u0004\u0012\u00020605J\u000e\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u000209J\u0015\u0010:\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b;R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Landroidx/compose/ui/autofill/AndroidAutofillManager;", "Landroidx/compose/ui/autofill/AutofillManager;", "Landroidx/compose/ui/semantics/SemanticsListener;", "Landroidx/compose/ui/focus/FocusListener;", "platformAutofillManager", "Landroidx/compose/ui/autofill/PlatformAutofillManager;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "view", "Landroid/view/View;", "rectManager", "Landroidx/compose/ui/spatial/RectManager;", "packageName", "", "(Landroidx/compose/ui/autofill/PlatformAutofillManager;Landroidx/compose/ui/semantics/SemanticsOwner;Landroid/view/View;Landroidx/compose/ui/spatial/RectManager;Ljava/lang/String;)V", "currentlyDisplayedIDs", "Landroidx/collection/MutableIntSet;", "pendingAutofillCommit", "", "getPlatformAutofillManager", "()Landroidx/compose/ui/autofill/PlatformAutofillManager;", "setPlatformAutofillManager", "(Landroidx/compose/ui/autofill/PlatformAutofillManager;)V", "reusableRect", "Landroid/graphics/Rect;", "rootAutofillId", "Landroid/view/autofill/AutofillId;", "cancel", "", "commit", "onDetach", "semanticsInfo", "Landroidx/compose/ui/semantics/SemanticsInfo;", "onDetach$ui_release", "onEndApplyChanges", "onEndApplyChanges$ui_release", "onFocusChanged", "previous", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "current", "onLayoutNodeDeactivated", "onLayoutNodeDeactivated$ui_release", "onPostAttach", "onPostAttach$ui_release", "onPostLayoutNodeReused", "previousSemanticsId", "", "onPostLayoutNodeReused$ui_release", "onSemanticsChanged", "previousSemanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "performAutofill", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "populateViewStructure", "rootViewStructure", "Landroid/view/ViewStructure;", "requestAutofill", "requestAutofill$ui_release", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public final class AndroidAutofillManager extends AutofillManager implements SemanticsListener, FocusListener {
    public static final int $stable = 8;
    private MutableIntSet currentlyDisplayedIDs;
    private final String packageName;
    private boolean pendingAutofillCommit;
    private PlatformAutofillManager platformAutofillManager;
    private final RectManager rectManager;
    private Rect reusableRect = new Rect();
    private AutofillId rootAutofillId;
    private final SemanticsOwner semanticsOwner;
    private final View view;

    public final PlatformAutofillManager getPlatformAutofillManager() {
        return this.platformAutofillManager;
    }

    public final void setPlatformAutofillManager(PlatformAutofillManager platformAutofillManager) {
        this.platformAutofillManager = platformAutofillManager;
    }

    public AndroidAutofillManager(PlatformAutofillManager platformAutofillManager, SemanticsOwner semanticsOwner, View view, RectManager rectManager, String str) {
        this.platformAutofillManager = platformAutofillManager;
        this.semanticsOwner = semanticsOwner;
        this.view = view;
        this.rectManager = rectManager;
        this.packageName = str;
        int i = 1;
        view.setImportantForAutofill(1);
        AutofillIdCompat autofillId = ViewCompatShims.getAutofillId(view);
        DefaultConstructorMarker defaultConstructorMarker = null;
        AutofillId autofillId2 = autofillId != null ? autofillId.toAutofillId() : null;
        if (autofillId2 != null) {
            this.rootAutofillId = autofillId2;
            this.currentlyDisplayedIDs = new MutableIntSet(0, i, defaultConstructorMarker);
        } else {
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
            throw new KotlinNothingValueException();
        }
    }

    @Override // androidx.compose.ui.autofill.AutofillManager
    public void commit() {
        this.platformAutofillManager.commit();
    }

    @Override // androidx.compose.ui.autofill.AutofillManager
    public void cancel() {
        this.platformAutofillManager.cancel();
    }

    @Override // androidx.compose.ui.focus.FocusListener
    public void onFocusChanged(FocusTargetModifierNode previous, FocusTargetModifierNode current) {
        SemanticsInfo requireSemanticsInfo;
        SemanticsConfiguration semanticsConfiguration;
        boolean isAutofillable;
        SemanticsInfo requireSemanticsInfo2;
        SemanticsConfiguration semanticsConfiguration2;
        boolean isAutofillable2;
        if (previous != null && (requireSemanticsInfo2 = DelegatableNodeKt.requireSemanticsInfo(previous)) != null && (semanticsConfiguration2 = requireSemanticsInfo2.getSemanticsConfiguration()) != null) {
            isAutofillable2 = AndroidAutofillManager_androidKt.isAutofillable(semanticsConfiguration2);
            if (isAutofillable2) {
                this.platformAutofillManager.notifyViewExited(this.view, requireSemanticsInfo2.getSemanticsId());
            }
        }
        if (current == null || (requireSemanticsInfo = DelegatableNodeKt.requireSemanticsInfo(current)) == null || (semanticsConfiguration = requireSemanticsInfo.getSemanticsConfiguration()) == null) {
            return;
        }
        isAutofillable = AndroidAutofillManager_androidKt.isAutofillable(semanticsConfiguration);
        if (isAutofillable) {
            final int semanticsId = requireSemanticsInfo.getSemanticsId();
            this.rectManager.getRects().withRect(semanticsId, new Function4<Integer, Integer, Integer, Integer, Unit>() { // from class: androidx.compose.ui.autofill.AndroidAutofillManager$onFocusChanged$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, Integer num3, Integer num4) {
                    invoke(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i, int i2, int i3, int i4) {
                    View view;
                    PlatformAutofillManager platformAutofillManager = AndroidAutofillManager.this.getPlatformAutofillManager();
                    view = AndroidAutofillManager.this.view;
                    platformAutofillManager.notifyViewEntered(view, semanticsId, new Rect(i, i2, i3, i4));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    @Override // androidx.compose.ui.semantics.SemanticsListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onSemanticsChanged(androidx.compose.ui.semantics.SemanticsInfo r9, androidx.compose.ui.semantics.SemanticsConfiguration r10) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.autofill.AndroidAutofillManager.onSemanticsChanged(androidx.compose.ui.semantics.SemanticsInfo, androidx.compose.ui.semantics.SemanticsConfiguration):void");
    }

    public final void populateViewStructure(ViewStructure rootViewStructure) {
        boolean isRelatedToAutofill;
        AutofillApi26Helper autofillApi26Helper = AutofillApi26Helper.INSTANCE;
        SemanticsInfo rootInfo$ui_release = this.semanticsOwner.getRootInfo$ui_release();
        PopulateViewStructure_androidKt.populate(rootViewStructure, rootInfo$ui_release, this.rootAutofillId, this.packageName, this.rectManager);
        MutableObjectList mutableObjectListOf = ObjectListKt.mutableObjectListOf(rootInfo$ui_release, rootViewStructure);
        while (mutableObjectListOf.isNotEmpty()) {
            MutableObjectList mutableObjectList = mutableObjectListOf;
            Object removeAt = mutableObjectListOf.removeAt(mutableObjectList._size - 1);
            Intrinsics.checkNotNull(removeAt, "null cannot be cast to non-null type android.view.ViewStructure");
            ViewStructure viewStructure = (ViewStructure) removeAt;
            Object removeAt2 = mutableObjectListOf.removeAt(mutableObjectList._size - 1);
            Intrinsics.checkNotNull(removeAt2, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsInfo");
            List<SemanticsInfo> childrenInfo = ((SemanticsInfo) removeAt2).getChildrenInfo();
            int size = childrenInfo.size();
            for (int i = 0; i < size; i++) {
                SemanticsInfo semanticsInfo = childrenInfo.get(i);
                if (!semanticsInfo.getIsDeactivated() && semanticsInfo.isAttached() && semanticsInfo.isPlaced()) {
                    SemanticsConfiguration semanticsConfiguration = semanticsInfo.getSemanticsConfiguration();
                    if (semanticsConfiguration != null) {
                        isRelatedToAutofill = AndroidAutofillManager_androidKt.isRelatedToAutofill(semanticsConfiguration);
                        if (isRelatedToAutofill) {
                            ViewStructure newChild = autofillApi26Helper.newChild(viewStructure, autofillApi26Helper.addChildCount(viewStructure, 1));
                            PopulateViewStructure_androidKt.populate(newChild, semanticsInfo, this.rootAutofillId, this.packageName, this.rectManager);
                            mutableObjectListOf.add(semanticsInfo);
                            mutableObjectListOf.add(newChild);
                        }
                    }
                    mutableObjectListOf.add(semanticsInfo);
                    mutableObjectListOf.add(viewStructure);
                }
            }
        }
    }

    public final void performAutofill(SparseArray<AutofillValue> values) {
        SemanticsConfiguration semanticsConfiguration;
        AccessibilityAction accessibilityAction;
        Function1 function1;
        int size = values.size();
        for (int i = 0; i < size; i++) {
            int keyAt = values.keyAt(i);
            AutofillValue m3012m = Listener$$ExternalSyntheticApiModelOutline0.m3012m((Object) values.get(keyAt));
            if (AutofillApi26Helper.INSTANCE.isText(m3012m)) {
                SemanticsInfo semanticsInfo = this.semanticsOwner.get$ui_release(keyAt);
                if (semanticsInfo != null && (semanticsConfiguration = semanticsInfo.getSemanticsConfiguration()) != null && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsActions.INSTANCE.getOnAutofillText())) != null && (function1 = (Function1) accessibilityAction.getAction()) != null) {
                }
            } else if (AutofillApi26Helper.INSTANCE.isDate(m3012m)) {
                Log.w("ComposeAutofillManager", "Auto filling Date fields is not yet supported.");
            } else if (AutofillApi26Helper.INSTANCE.isList(m3012m)) {
                Log.w("ComposeAutofillManager", "Auto filling dropdown lists is not yet supported.");
            } else if (AutofillApi26Helper.INSTANCE.isToggle(m3012m)) {
                Log.w("ComposeAutofillManager", "Auto filling toggle fields are not yet supported.");
            }
        }
    }

    public final void requestAutofill$ui_release(final SemanticsInfo semanticsInfo) {
        this.rectManager.getRects().withRect(semanticsInfo.getSemanticsId(), new Function4<Integer, Integer, Integer, Integer, Unit>() { // from class: androidx.compose.ui.autofill.AndroidAutofillManager$requestAutofill$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, Integer num3, Integer num4) {
                invoke(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i, int i2, int i3, int i4) {
                Rect rect;
                View view;
                Rect rect2;
                rect = AndroidAutofillManager.this.reusableRect;
                rect.set(i, i2, i3, i4);
                PlatformAutofillManager platformAutofillManager = AndroidAutofillManager.this.getPlatformAutofillManager();
                view = AndroidAutofillManager.this.view;
                int semanticsId = semanticsInfo.getSemanticsId();
                rect2 = AndroidAutofillManager.this.reusableRect;
                platformAutofillManager.requestAutofill(view, semanticsId, rect2);
            }
        });
    }

    public final void onPostAttach$ui_release(SemanticsInfo semanticsInfo) {
        boolean isRelatedToAutoCommit;
        SemanticsConfiguration semanticsConfiguration = semanticsInfo.getSemanticsConfiguration();
        if (semanticsConfiguration != null) {
            isRelatedToAutoCommit = AndroidAutofillManager_androidKt.isRelatedToAutoCommit(semanticsConfiguration);
            if (isRelatedToAutoCommit) {
                this.currentlyDisplayedIDs.add(semanticsInfo.getSemanticsId());
                this.platformAutofillManager.notifyViewVisibilityChanged(this.view, semanticsInfo.getSemanticsId(), true);
            }
        }
    }

    public final void onPostLayoutNodeReused$ui_release(SemanticsInfo semanticsInfo, int previousSemanticsId) {
        boolean isRelatedToAutoCommit;
        if (this.currentlyDisplayedIDs.remove(previousSemanticsId)) {
            this.platformAutofillManager.notifyViewVisibilityChanged(this.view, previousSemanticsId, false);
        }
        SemanticsConfiguration semanticsConfiguration = semanticsInfo.getSemanticsConfiguration();
        if (semanticsConfiguration != null) {
            isRelatedToAutoCommit = AndroidAutofillManager_androidKt.isRelatedToAutoCommit(semanticsConfiguration);
            if (isRelatedToAutoCommit) {
                this.currentlyDisplayedIDs.add(semanticsInfo.getSemanticsId());
                this.platformAutofillManager.notifyViewVisibilityChanged(this.view, semanticsInfo.getSemanticsId(), true);
            }
        }
    }

    public final void onLayoutNodeDeactivated$ui_release(SemanticsInfo semanticsInfo) {
        if (this.currentlyDisplayedIDs.remove(semanticsInfo.getSemanticsId())) {
            this.platformAutofillManager.notifyViewVisibilityChanged(this.view, semanticsInfo.getSemanticsId(), false);
        }
    }

    public final void onDetach$ui_release(SemanticsInfo semanticsInfo) {
        if (this.currentlyDisplayedIDs.remove(semanticsInfo.getSemanticsId())) {
            this.platformAutofillManager.notifyViewVisibilityChanged(this.view, semanticsInfo.getSemanticsId(), false);
        }
    }

    public final void onEndApplyChanges$ui_release() {
        if (this.currentlyDisplayedIDs.isEmpty() && this.pendingAutofillCommit) {
            this.platformAutofillManager.commit();
            this.pendingAutofillCommit = false;
        }
        if (this.currentlyDisplayedIDs.isNotEmpty()) {
            this.pendingAutofillCommit = true;
        }
    }
}
